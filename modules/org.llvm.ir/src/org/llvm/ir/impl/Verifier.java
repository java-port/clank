/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.ir.mdconst.MdconstGlobals;
import org.llvm.support.dwarf.MacinfoRecordType;
import static org.llvm.ir.impl.VerifierStatics.*;
import static org.llvm.support.AdtsupportLlvmGlobals.isStrongerThan;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 209,
 FQN="(anonymous namespace)::Verifier", NM="_ZN12_GLOBAL__N_18VerifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18VerifierE")
//</editor-fold>
public class Verifier extends /**/ VerifierSupport implements /*public*/ InstVisitorVoid<Verifier>, Destructors.ClassWithDestructor {
  /*friend  class InstVisitor<Verifier>*/

  private LLVMContext /*P*/ Context;
  private DominatorTree DT;

  /// \brief When verifying a basic block, keep track of all of the
  /// instructions we have seen so far.
  ///
  /// This allows us to do efficient dominance checks for the case when an
  /// instruction has an operand that is an instruction in the same block.
  private SmallPtrSet<Instruction /*P*/ > InstsInThisBlock;

  /// \brief Keep track of the metadata nodes that have been checked already.
  private SmallPtrSet</*const*/ Metadata /*P*/ > MDNodes;

  /// Track all DICompileUnits visited.
  private SmallPtrSet</*const*/ Metadata /*P*/ > CUVisited;

  /// \brief The result type for a landingpad.
  private Type /*P*/ LandingPadResultTy;

  /// \brief Whether we've seen a call to @llvm.localescape in this function
  /// already.
  private boolean SawFrameEscape;

  /// Stores the count of how many objects were passed to llvm.localescape for a
  /// given function and the largest index passed to llvm.localrecover.
  private DenseMap<Function /*P*/ , std.pairUIntUInt> FrameEscapeInfo;

  // Maps catchswitches and cleanuppads that unwind to siblings to the
  // terminators that indicate the unwind, used to detect cycles therein.
  private MapVectorPtrPtr<Instruction /*P*/ , TerminatorInst /*P*/ > SiblingFuncletInfo;

  /// Cache of constants visited in search of ConstantExprs.
  private SmallPtrSet</*const*/ Constant /*P*/ > ConstantExprVisited;

  /// Cache of declarations of the llvm.experimental.deoptimize.<ty> intrinsic.
  private SmallVector</*const*/ Function /*P*/ > DeoptimizeDeclarations;

  // Verify that this GlobalValue is only used in this module.
  // This map is used to avoid visiting uses twice. We can arrive at a user
  // twice, if they have multiple operands. In particular for very large
  // constant expressions, we can arrive at a particular user many times.
  private SmallPtrSet</*const*/ Value /*P*/ > GlobalValueVisited;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::checkAtomicMemAccessSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2968,
   FQN="(anonymous namespace)::Verifier::checkAtomicMemAccessSize", NM="_ZN12_GLOBAL__N_18Verifier24checkAtomicMemAccessSizeEPKN4llvm6ModuleEPNS1_4TypeEPKNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier24checkAtomicMemAccessSizeEPKN4llvm6ModuleEPNS1_4TypeEPKNS1_11InstructionE")
  //</editor-fold>
  private void checkAtomicMemAccessSize(/*const*/ Module /*P*/ M, Type /*P*/ Ty,
                          /*const*/ Instruction /*P*/ I) {
    /*uint*/int Size = $ulong2uint(M.getDataLayout().getTypeSizeInBits(Ty));
    do {
      if (!($greatereq_uint(Size, 8))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"atomic memory access' size must be byte-sized"), Ty, I);
        return;
      }
    } while (false);
    do {
      if (!(!((Size & (Size - 1)) != 0))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"atomic memory access' operand must have a power-of-two size"), Ty, I);
        return;
      }
    } while (false);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::updateModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 258,
   FQN="(anonymous namespace)::Verifier::updateModule", NM="_ZN12_GLOBAL__N_18Verifier12updateModuleEPKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier12updateModuleEPKN4llvm6ModuleE")
  //</editor-fold>
  private void updateModule(/*const*/ Module /*P*/ NewM) {
    if (M == NewM) {
      return;
    }
    MST.emplace(new ModuleSlotTracker(NewM));
    M = NewM;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::Verifier">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 266,
   FQN="(anonymous namespace)::Verifier::Verifier", NM="_ZN12_GLOBAL__N_18VerifierC1EPN4llvm11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18VerifierC1EPN4llvm11raw_ostreamEb")
  //</editor-fold>
  public /*explicit*/ Verifier(raw_ostream /*P*/ OS, boolean ShouldTreatBrokenDebugInfoAsError) {
    // : InstVisitor<Verifier>(), VerifierSupport(OS), Context(null), DT(), InstsInThisBlock(), MDNodes(), CUVisited(), LandingPadResultTy(null), SawFrameEscape(false), FrameEscapeInfo(), SiblingFuncletInfo(), ConstantExprVisited(), DeoptimizeDeclarations(), GlobalValueVisited()
    //START JInit
    super(OS);
    $InstVisitor();
    this.Context = null;
    this.DT = new DominatorTree();
    this.InstsInThisBlock = new SmallPtrSet<Instruction /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    this.MDNodes = new SmallPtrSet</*const*/ Metadata /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    this.CUVisited = new SmallPtrSet</*const*/ Metadata /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    this.LandingPadResultTy = null;
    this.SawFrameEscape = false;
    this.FrameEscapeInfo = new DenseMap<Function /*P*/ , std.pairUIntUInt>(DenseMapInfo$LikePtr.$Info(), new std.pairUIntUInt());
    this.SiblingFuncletInfo = new MapVectorPtrPtr<Instruction /*P*/ , TerminatorInst /*P*/ >(DenseMapInfo$LikePtr.$Info(), (TerminatorInst /*P*/ )null);
    this.ConstantExprVisited = new SmallPtrSet</*const*/ Constant /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    this.DeoptimizeDeclarations = new SmallVector</*const*/ Function /*P*/ >(4, (/*const*/ Function /*P*/ )null);
    this.GlobalValueVisited = new SmallPtrSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    //END JInit
    TreatBrokenDebugInfoAsError = ShouldTreatBrokenDebugInfoAsError;
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::hasBrokenDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 272,
   FQN="(anonymous namespace)::Verifier::hasBrokenDebugInfo", NM="_ZNK12_GLOBAL__N_18Verifier18hasBrokenDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK12_GLOBAL__N_18Verifier18hasBrokenDebugInfoEv")
  //</editor-fold>
  public boolean hasBrokenDebugInfo() /*const*/ {
    return BrokenDebugInfo;
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 274,
   FQN="(anonymous namespace)::Verifier::verify", NM="_ZN12_GLOBAL__N_18Verifier6verifyERKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier6verifyERKN4llvm8FunctionE")
  //</editor-fold>
  public boolean verify(final /*const*/ Function /*&*/ F) {
    updateModule(F.getParent$Const());
    Context = $AddrOf(M.getContext());

    // First ensure the function is well-enough formed to compute dominance
    // information, and directly compute a dominance tree. We don't rely on the
    // pass manager to provide this as it isolates us from a potentially
    // out-of-date dominator tree and makes it significantly more complex to run
    // this code outside of a pass manager.
    // FIXME: It's really gross that we have to cast away constness here.
    if (!F.empty()) {
      DT.recalculate(GraphTraitsFunction$P.$GTraits(), ((/*const_cast*/Function /*&*/ )(F)));
    }

    for (final /*const*/ BasicBlock /*&*/ BB : F) {
      if (!BB.empty() && BB.back$Const().isTerminator()) {
        continue;
      }
      if ((OS != null)) {
        $Deref(OS).$out(/*KEEP_STR*/"Basic Block in function '").$out(F.getName()).$out(
            /*KEEP_STR*/"' does not have terminator!\n"
        );
        BB.printAsOperand($Deref(OS), true, MST.$star());
        $Deref(OS).$out(/*KEEP_STR*/$LF);
      }
      return false;
    }

    Broken = false;
    // FIXME: We strip const here because the inst visitor strips const.
    visit_Function(((/*const_cast*/Function /*&*/ )(F)));
    verifySiblingFuncletUnwinds();
    InstsInThisBlock.clear();
    LandingPadResultTy = null;
    SawFrameEscape = false;
    SiblingFuncletInfo.clear();

    return !Broken;
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verify">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 312,
   FQN="(anonymous namespace)::Verifier::verify", NM="_ZN12_GLOBAL__N_18Verifier6verifyERKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier6verifyERKN4llvm6ModuleE")
  //</editor-fold>
  public boolean verify(final /*const*/ Module /*&*/ M) {
    updateModule($AddrOf(M));
    Context = $AddrOf(M.getContext());
    Broken = false;

    // Collect all declarations of the llvm.experimental.deoptimize intrinsic.
    for (final /*const*/ Function /*&*/ F : M)  {
      if (F.getIntrinsicID() == ID.experimental_deoptimize) {
        DeoptimizeDeclarations.push_back($AddrOf(F));
      }
    }

    // Now that we've visited every function, verify that we never asked to
    // recover a frame index that wasn't escaped.
    verifyFrameRecoverIndices();
    for (final /*const*/ GlobalVariable /*&*/ GV : M.globals$Const())  {
      visitGlobalVariable(GV);
    }

    for (final /*const*/ GlobalAlias /*&*/ GA : M.aliases$Const())  {
      visitGlobalAlias(GA);
    }

    for (final /*const*/ NamedMDNode /*&*/ NMD : M.named_metadata$Const())  {
      visitNamedMDNode(NMD);
    }

    for (final /*const*/ StringMapEntry<Comdat> /*&*/ SMEC : M.getComdatSymbolTable$Const())  {
      visitComdat(SMEC.getValue$Const());
    }

    visitModuleFlags(M);
    visitModuleIdents(M);

    verifyCompileUnits();

    verifyDeoptimizeCallingConvs();

    return !Broken;
  }

/*private:*/
  // Verification methods...
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitGlobalValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 499,
   FQN="(anonymous namespace)::Verifier::visitGlobalValue", NM="_ZN12_GLOBAL__N_18Verifier16visitGlobalValueERKN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitGlobalValueERKN4llvm11GlobalValueE")
  //</editor-fold>
  private void visitGlobalValue(final /*const*/ GlobalValue /*&*/ GV) {
    do {
      if (!(!GV.isDeclaration() || GV.hasValidDeclarationLinkage())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Global is external, but doesn't have external or weak linkage!"), $AddrOf(GV));
        return;
      }
    } while (false);
    do {
      if (!($lesseq_uint(GV.getAlignment(), Value.MaximumAlignment))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"huge alignment values are unsupported"), $AddrOf(GV));
        return;
      }
    } while (false);
    do {
      if (!(!GV.hasAppendingLinkage() || isa_GlobalVariable(GV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Only global variables can have appending linkage!"), $AddrOf(GV));
        return;
      }
    } while (false);
    if (GV.hasAppendingLinkage()) {
      /*const*/ GlobalVariable /*P*/ GVar = dyn_cast_GlobalVariable($AddrOf(GV));
      do {
        if (!((GVar != null) && GVar.getValueType().isArrayTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Only global arrays can have appending linkage!"), GVar);
          return;
        }
      } while (false);
    }
    if (GV.isDeclarationForLinker()) {
      do {
        if (!(!GV.hasComdat())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Declaration may not be in a Comdat!"), $AddrOf(GV));
          return;
        }
      } while (false);
    }

    VerifierStatics.forEachUser($AddrOf(GV), GlobalValueVisited, /*FuncArg*//*[&, this, &GV]*/ (/*const*/ Value /*P*/ V) -> {
              {
                /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(V);
                if ((I != null)) {
                  if (!(I.getParent$Const() != null) || !(I.getParent$Const().getParent$Const() != null)) {
                    CheckFailed$T(new Twine(/*KEEP_STR*/"Global is referenced by parentless instruction!"), $AddrOf(GV),
                        M, I);
                  } else if (I.getParent$Const().getParent$Const().getParent$Const() != M) {
                    CheckFailed$T(new Twine(/*KEEP_STR*/"Global is referenced in a different module!"), $AddrOf(GV),
                        M, I, I.getParent$Const().getParent$Const(),
                        I.getParent$Const().getParent$Const().getParent$Const());
                  }
                  return false;
                } else {
                  /*const*/ Function /*P*/ F = dyn_cast_Function(V);
                  if ((F != null)) {
                    if (F.getParent$Const() != M) {
                      CheckFailed$T(new Twine(/*KEEP_STR*/"Global is used by function in a different module"), $AddrOf(GV),
                          M, F, F.getParent$Const());
                    }
                    return false;
                  }
                }
              }
              return true;
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitGlobalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 537,
   FQN="(anonymous namespace)::Verifier::visitGlobalVariable", NM="_ZN12_GLOBAL__N_18Verifier19visitGlobalVariableERKN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitGlobalVariableERKN4llvm14GlobalVariableE")
  //</editor-fold>
  private void visitGlobalVariable(final /*const*/ GlobalVariable /*&*/ GV) {
    if (GV.hasInitializer()) {
      do {
        if (!(GV.getInitializer$Const().getType() == GV.getValueType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Global variable initializer type does not match global variable type!"), $AddrOf(GV));
          return;
        }
      } while (false);

      // If the global has common linkage, it must have a zero initializer and
      // cannot be constant.
      if (GV.hasCommonLinkage()) {
        do {
          if (!(GV.getInitializer$Const().isNullValue())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"'common' global must have a zero initializer!"), $AddrOf(GV));
            return;
          }
        } while (false);
        do {
          if (!(!GV.isConstant())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"'common' global may not be marked constant!"), $AddrOf(GV));
            return;
          }
        } while (false);
        do {
          if (!(!GV.hasComdat())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"'common' global may not be in a Comdat!"), $AddrOf(GV));
            return;
          }
        } while (false);
      }
    }
    if (GV.hasName() && ($eq_StringRef(GV.getName(), /*STRINGREF_STR*/"llvm.global_ctors")
       || $eq_StringRef(GV.getName(), /*STRINGREF_STR*/"llvm.global_dtors"))) {
      do {
        if (!(!GV.hasInitializer() || GV.hasAppendingLinkage())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"invalid linkage for intrinsic global variable"), $AddrOf(GV));
          return;
        }
      } while (false);
      {
        // Don't worry about emitting an error for it not being an array,
        // visitGlobalValue will complain on appending non-array.
        ArrayType /*P*/ ATy = dyn_cast_ArrayType(GV.getValueType());
        if ((ATy != null)) {
          StructType /*P*/ STy = dyn_cast_StructType(ATy.getElementType());
          PointerType /*P*/ FuncPtrTy = FunctionType.get(Type.getVoidTy($Deref(Context)), false).getPointerTo();
          // FIXME: Reject the 2-field form in LLVM 4.0.
          do {
            if (!((STy != null) && (STy.getNumElements() == 2 || STy.getNumElements() == 3) && STy.getTypeAtIndex(0/*U*/).isIntegerTy(32) && STy.getTypeAtIndex(1) == FuncPtrTy)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"wrong type for intrinsic global variable"), $AddrOf(GV));
              return;
            }
          } while (false);
          if (STy.getNumElements() == 3) {
            Type /*P*/ ETy = STy.getTypeAtIndex(2);
            do {
              if (!(ETy.isPointerTy() && cast_PointerType(ETy).getElementType().isIntegerTy(8))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"wrong type for intrinsic global variable"), $AddrOf(GV));
                return;
              }
            } while (false);
          }
        }
      }
    }
    if (GV.hasName() && ($eq_StringRef(GV.getName(), /*STRINGREF_STR*/"llvm.used")
       || $eq_StringRef(GV.getName(), /*STRINGREF_STR*/"llvm.compiler.used"))) {
      do {
        if (!(!GV.hasInitializer() || GV.hasAppendingLinkage())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"invalid linkage for intrinsic global variable"), $AddrOf(GV));
          return;
        }
      } while (false);
      Type /*P*/ GVType = GV.getValueType();
      {
        ArrayType /*P*/ ATy = dyn_cast_ArrayType(GVType);
        if ((ATy != null)) {
          PointerType /*P*/ PTy = dyn_cast_PointerType(ATy.getElementType());
          do {
            if (!((PTy) != null)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"wrong type for intrinsic global variable"), $AddrOf(GV));
              return;
            }
          } while (false);
          if (GV.hasInitializer()) {
            /*const*/ Constant /*P*/ Init = GV.getInitializer$Const();
            /*const*/ ConstantArray /*P*/ InitArray = dyn_cast_ConstantArray(Init);
            do {
              if (!((InitArray) != null)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"wrong initalizer for intrinsic global variable"), Init);
                return;
              }
            } while (false);
            for (Use /*P*/ U : InitArray.operands$Const()) {
              Value Op = U.$Value$P();
              Value /*P*/ V = Op.stripPointerCastsNoFollowAliases();
              do {
                if (!(isa_GlobalVariable(V) || isa_Function(V) || isa_GlobalAlias(V))) {
                  CheckFailed$T(new Twine(/*KEEP_STR*/"invalid llvm.used member"), V);
                  return;
                }
              } while (false);
              do {
                if (!(V.hasName())) {
                  CheckFailed$T(new Twine(/*KEEP_STR*/"members of llvm.used must be named"), V);
                  return;
                }
              } while (false);
            }
          }
        }
      }
    }
    do {
      if (!(!GV.hasDLLImportStorageClass() || (GV.isDeclaration() && GV.hasExternalLinkage()) || GV.hasAvailableExternallyLinkage())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Global is marked as dllimport, but not external"), $AddrOf(GV));
        return;
      }
    } while (false);
    if (!GV.hasInitializer()) {
      visitGlobalValue(GV);
      return;
    }

    // Walk any aggregate initializers looking for bitcasts between address spaces
    visitConstantExprsRecursively(GV.getInitializer$Const());

    visitGlobalValue(GV);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitGlobalAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 656,
   FQN="(anonymous namespace)::Verifier::visitGlobalAlias", NM="_ZN12_GLOBAL__N_18Verifier16visitGlobalAliasERKN4llvm11GlobalAliasE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitGlobalAliasERKN4llvm11GlobalAliasE")
  //</editor-fold>
  private void visitGlobalAlias(final /*const*/ GlobalAlias /*&*/ GA) {
    do {
      if (!(GlobalAlias.isValidLinkage(GA.getLinkage()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Alias should have private, internal, linkonce, weak, linkonce_odr, weak_odr, or external linkage!"), $AddrOf(GA));
        return;
      }
    } while (false);
    /*const*/ Constant /*P*/ Aliasee = GA.getAliasee$Const();
    do {
      if (!((Aliasee) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Aliasee cannot be NULL!"), $AddrOf(GA));
        return;
      }
    } while (false);
    do {
      if (!(GA.getType() == Aliasee.getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Alias and aliasee types should match!"), $AddrOf(GA));
        return;
      }
    } while (false);
    do {
      if (!(isa_GlobalValue(Aliasee) || isa_ConstantExpr(Aliasee))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Aliasee should be either GlobalValue or ConstantExpr"), $AddrOf(GA));
        return;
      }
    } while (false);

    visitAliaseeSubExpr(GA, $Deref(Aliasee));

    visitGlobalValue(GA);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitAliaseeSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 620,
   FQN="(anonymous namespace)::Verifier::visitAliaseeSubExpr", NM="_ZN12_GLOBAL__N_18Verifier19visitAliaseeSubExprERKN4llvm11GlobalAliasERKNS1_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitAliaseeSubExprERKN4llvm11GlobalAliasERKNS1_8ConstantE")
  //</editor-fold>
  private void visitAliaseeSubExpr(final /*const*/ GlobalAlias /*&*/ GA, final /*const*/ Constant /*&*/ C) {
    SmallPtrSet</*const*/ GlobalAlias /*P*/ > Visited/*J*/= new SmallPtrSet</*const*/ GlobalAlias /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    Visited.insert($AddrOf(GA));
    visitAliaseeSubExpr(Visited, GA, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitAliaseeSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 626,
   FQN="(anonymous namespace)::Verifier::visitAliaseeSubExpr", NM="_ZN12_GLOBAL__N_18Verifier19visitAliaseeSubExprERN4llvm15SmallPtrSetImplIPKNS1_11GlobalAliasEEERS4_RKNS1_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitAliaseeSubExprERN4llvm15SmallPtrSetImplIPKNS1_11GlobalAliasEEERS4_RKNS1_8ConstantE")
  //</editor-fold>
  private void visitAliaseeSubExpr(final SmallPtrSetImpl</*const*/ GlobalAlias /*P*/ > /*&*/ Visited,
                     final /*const*/ GlobalAlias /*&*/ GA, final /*const*/ Constant /*&*/ C) {
    {
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue($AddrOf(C));
      if ((GV != null)) {
        do {
          if (!(!GV.isDeclarationForLinker())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Alias must point to a definition"), $AddrOf(GA));
            return;
          }
        } while (false);
        {

          /*const*/ GlobalAlias /*P*/ GA2 = dyn_cast_GlobalAlias(GV);
          if ((GA2 != null)) {
            do {
              if (!(Visited.insert(GA2).second)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Aliases cannot form a cycle"), $AddrOf(GA));
                return;
              }
            } while (false);
            do {
              if (!(!GA2.isInterposable())) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Alias cannot point to an interposable alias"), $AddrOf(GA));
                return;
              }
            } while (false);
          } else {
            // Only continue verifying subexpressions of GlobalAliases.
            // Do not recurse into global initializers.
            return;
          }
        }
      }
    }
    {

      /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr($AddrOf(C));
      if ((CE != null)) {
        visitConstantExprsRecursively(CE);
      }
    }

    for (final /*const*/ Use /*&*/ U : C.operands$Const()) {
      Value /*P*/ V = $AddrOf($Deref(U.$Value$P()));
      {
        /*const*/ GlobalAlias /*P*/ GA2 = dyn_cast_GlobalAlias(V);
        if ((GA2 != null)) {
          visitAliaseeSubExpr(Visited, GA, $Deref(GA2.getAliasee$Const()));
        } else {
          /*const*/ Constant /*P*/ C2 = dyn_cast_Constant(V);
          if ((C2 != null)) {
            visitAliaseeSubExpr(Visited, GA, $Deref(C2));
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitNamedMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 674,
   FQN="(anonymous namespace)::Verifier::visitNamedMDNode", NM="_ZN12_GLOBAL__N_18Verifier16visitNamedMDNodeERKN4llvm11NamedMDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitNamedMDNodeERKN4llvm11NamedMDNodeE")
  //</editor-fold>
  private void visitNamedMDNode(final /*const*/ NamedMDNode /*&*/ NMD) {
    for (/*const*/ MDNode /*P*/ MD : NMD.operands$Const()) {
      if ($eq_StringRef(NMD.getName(), /*STRINGREF_STR*/"llvm.dbg.cu")) {
        do {
          if (!((MD != null) && isa_DICompileUnit(MD))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid compile unit"), $AddrOf(NMD), MD);
            return;
          }
        } while (false);
      }
      if (!(MD != null)) {
        continue;
      }

      visitMDNode($Deref(MD));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 687,
   FQN="(anonymous namespace)::Verifier::visitMDNode", NM="_ZN12_GLOBAL__N_18Verifier11visitMDNodeERKN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier11visitMDNodeERKN4llvm6MDNodeE")
  //</editor-fold>
  private void visitMDNode(final /*const*/ MDNode /*&*/ MD) {
    // Only visit each node once.  Metadata can be mutually recursive, so this
    // avoids infinite recursion here, as well as being an optimization.
    if (!MDNodes.insert($AddrOf(MD)).second) {
      return;
    }
    switch (Metadata.MetadataKind.valueOf(MD.getMetadataID())) {
     default:
      throw new llvm_unreachable("Invalid MDNode subclass");
     case MDTupleKind:
      break;
     case DILocationKind:
      visitDILocation(cast_DILocation(MD));
      break;
     case DIExpressionKind:
      visitDIExpression(cast_DIExpression(MD));
      break;
     case GenericDINodeKind:
      visitGenericDINode(cast_GenericDINode(MD));
      break;
     case DISubrangeKind:
      visitDISubrange(cast_DISubrange(MD));
      break;
     case DIEnumeratorKind:
      visitDIEnumerator(cast_DIEnumerator(MD));
      break;
     case DIBasicTypeKind:
      visitDIBasicType(cast_DIBasicType(MD));
      break;
     case DIDerivedTypeKind:
      visitDIDerivedType(cast_DIDerivedType(MD));
      break;
     case DICompositeTypeKind:
      visitDICompositeType(cast_DICompositeType(MD));
      break;
     case DISubroutineTypeKind:
      visitDISubroutineType(cast_DISubroutineType(MD));
      break;
     case DIFileKind:
      visitDIFile(cast_DIFile(MD));
      break;
     case DICompileUnitKind:
      visitDICompileUnit(cast_DICompileUnit(MD));
      break;
     case DISubprogramKind:
      visitDISubprogram(cast_DISubprogram(MD));
      break;
     case DILexicalBlockKind:
      visitDILexicalBlock(cast_DILexicalBlock(MD));
      break;
     case DILexicalBlockFileKind:
      visitDILexicalBlockFile(cast_DILexicalBlockFile(MD));
      break;
     case DINamespaceKind:
      visitDINamespace(cast_DINamespace(MD));
      break;
     case DIModuleKind:
      visitDIModule(cast_DIModule(MD));
      break;
     case DITemplateTypeParameterKind:
      visitDITemplateTypeParameter(cast_DITemplateTypeParameter(MD));
      break;
     case DITemplateValueParameterKind:
      visitDITemplateValueParameter(cast_DITemplateValueParameter(MD));
      break;
     case DIGlobalVariableKind:
      visitDIGlobalVariable(cast_DIGlobalVariable(MD));
      break;
     case DILocalVariableKind:
      visitDILocalVariable(cast_DILocalVariable(MD));
      break;
     case DIObjCPropertyKind:
      visitDIObjCProperty(cast_DIObjCProperty(MD));
      break;
     case DIImportedEntityKind:
      visitDIImportedEntity(cast_DIImportedEntity(MD));
      break;
     case DIMacroKind:
      visitDIMacro(cast_DIMacro(MD));
      break;
     case DIMacroFileKind:
      visitDIMacroFile(cast_DIMacroFile(MD));
      break;
    }

    for (/*const*/ MDOperand /*P*/ M : MD.operands()) {
      Metadata /*P*/ Op = M.$Metadata$P();
      if (!(Op != null)) {
        continue;
      }
      do {
        if (!(!isa_LocalAsMetadata(Op))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid operand for global metadata!"), $AddrOf(MD), Op);
          return;
        }
      } while (false);
      {
        /*const*/ MDNode /*P*/ N = dyn_cast_MDNode(Op);
        if ((N != null)) {
          visitMDNode($Deref(N));
          continue;
        }
      }
      {
        /*const*/ ValueAsMetadata /*P*/ V = dyn_cast_ValueAsMetadata(Op);
        if ((V != null)) {
          visitValueAsMetadata($Deref(V), (Function /*P*/ )null);
          continue;
        }
      }
    }

    // Check these last, so we diagnose problems in operands first.
    do {
      if (!(!MD.isTemporary())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Expected no forward declarations!"), $AddrOf(MD));
        return;
      }
    } while (false);
    do {
      if (!(MD.isResolved())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"All nodes should be resolved!"), $AddrOf(MD));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitMetadataAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 751,
   FQN="(anonymous namespace)::Verifier::visitMetadataAsValue", NM="_ZN12_GLOBAL__N_18Verifier20visitMetadataAsValueERKN4llvm15MetadataAsValueEPNS1_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitMetadataAsValueERKN4llvm15MetadataAsValueEPNS1_8FunctionE")
  //</editor-fold>
  private void visitMetadataAsValue(final /*const*/ MetadataAsValue /*&*/ MDV, Function /*P*/ F) {
    Metadata /*P*/ MD = MDV.getMetadata();
    {
      MDNode /*P*/ N = dyn_cast_MDNode(MD);
      if ((N != null)) {
        visitMDNode($Deref(N));
        return;
      }
    }

    // Only visit each node once.  Metadata can be mutually recursive, so this
    // avoids infinite recursion here, as well as being an optimization.
    if (!MDNodes.insert(MD).second) {
      return;
    }
    {

      ValueAsMetadata /*P*/ V = dyn_cast_ValueAsMetadata(MD);
      if ((V != null)) {
        visitValueAsMetadata($Deref(V), F);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitValueAsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 725,
   FQN="(anonymous namespace)::Verifier::visitValueAsMetadata", NM="_ZN12_GLOBAL__N_18Verifier20visitValueAsMetadataERKN4llvm15ValueAsMetadataEPNS1_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitValueAsMetadataERKN4llvm15ValueAsMetadataEPNS1_8FunctionE")
  //</editor-fold>
  private void visitValueAsMetadata(final /*const*/ ValueAsMetadata /*&*/ MD, Function /*P*/ F) {
    do {
      if (!((MD.getValue()) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Expected valid value"), $AddrOf(MD));
        return;
      }
    } while (false);
    do {
      if (!(!MD.getValue().getType().isMetadataTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Unexpected metadata round-trip through values"), $AddrOf(MD), MD.getValue());
        return;
      }
    } while (false);

    /*const*/ LocalAsMetadata /*P*/ L = dyn_cast_LocalAsMetadata($AddrOf(MD));
    if (!(L != null)) {
      return;
    }
    do {
      if (!((F) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"function-local metadata used outside a function"), L);
        return;
      }
    } while (false);

    // If this was an instruction, bb, or argument, verify that it is in the
    // function that we expect.
    Function /*P*/ ActualF = null;
    {
      Instruction /*P*/ I = dyn_cast_Instruction(L.getValue());
      if ((I != null)) {
        do {
          if (!((I.getParent()) != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"function-local metadata not in basic block"), L, I);
            return;
          }
        } while (false);
        ActualF = I.getParent().getParent();
      } else {
        BasicBlock /*P*/ BB = dyn_cast_BasicBlock(L.getValue());
        if ((BB != null)) {
          ActualF = BB.getParent();
        } else {
          Argument /*P*/ A = dyn_cast_Argument(L.getValue());
          if ((A != null)) {
            ActualF = A.getParent();
          }
        }
      }
    }
    assert ((ActualF != null)) : "Unimplemented function local metadata case!";
    do {
      if (!(ActualF == F)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"function-local metadata used in wrong function"), L);
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1134,
   FQN="(anonymous namespace)::Verifier::visitComdat", NM="_ZN12_GLOBAL__N_18Verifier11visitComdatERKN4llvm6ComdatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier11visitComdatERKN4llvm6ComdatE")
  //</editor-fold>
  private void visitComdat(final /*const*/ Comdat /*&*/ C) {
    {
      // The Module is invalid if the GlobalValue has private linkage.  Entities
      // with private linkage don't have entries in the symbol table.
      /*const*/ GlobalValue /*P*/ GV = M.getNamedValue(C.getName());
      if ((GV != null)) {
        do {
          if (!(!GV.hasPrivateLinkage())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"comdat global value has private linkage"), GV);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitModuleIdents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1142,
   FQN="(anonymous namespace)::Verifier::visitModuleIdents", NM="_ZN12_GLOBAL__N_18Verifier17visitModuleIdentsERKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitModuleIdentsERKN4llvm6ModuleE")
  //</editor-fold>
  private void visitModuleIdents(final /*const*/ Module /*&*/ M) {
    /*const*/ NamedMDNode /*P*/ Idents = M.getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.ident"));
    if (!(Idents != null)) {
      return;
    }

    // llvm.ident takes a list of metadata entry. Each entry has only one string.
    // Scan each llvm.ident entry and make sure that this requirement is met.
    for (/*const*/ MDNode /*P*/ N : Idents.operands$Const()) {
      do {
        if (!(N.getNumOperands() == 1)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"incorrect number of operands in llvm.ident metadata"), N);
          return;
        }
      } while (false);
      do {
        if (!((dyn_cast_or_null_MDString(N.getOperand(0))) != null)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/("invalid value for llvm.ident metadata entry operand(the operand should be a string)")), N.getOperand(0));
          return;
        }
      } while (false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitModuleFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1159,
   FQN="(anonymous namespace)::Verifier::visitModuleFlags", NM="_ZN12_GLOBAL__N_18Verifier16visitModuleFlagsERKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitModuleFlagsERKN4llvm6ModuleE")
  //</editor-fold>
  private void visitModuleFlags(final /*const*/ Module /*&*/ M) {
    /*const*/ NamedMDNode /*P*/ Flags = M.getModuleFlagsMetadata();
    if (!(Flags != null)) {
      return;
    }

    // Scan each flag, and track the flags and requirements.
    DenseMap</*const*/ MDString /*P*/ , /*const*/ MDNode /*P*/ > SeenIDs/*J*/= new DenseMap</*const*/ MDString /*P*/ , /*const*/ MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ MDNode /*P*/ )null);
    SmallVector</*const*/ MDNode /*P*/ > Requirements/*J*/= new SmallVector</*const*/ MDNode /*P*/ >(16, (/*const*/ MDNode /*P*/ )null);
    for (/*const*/ MDNode /*P*/ MDN : Flags.operands$Const())  {
      visitModuleFlag(MDN, SeenIDs, Requirements);
    }

    // Validate that the requirements in the module are valid.
    for (/*const*/ MDNode /*P*/ Requirement : Requirements) {
      /*const*/ MDString /*P*/ Flag = cast_MDString(Requirement.getOperand(0));
      /*const*/ Metadata /*P*/ ReqValue = Requirement.getOperand(1).$Metadata$P();

      /*const*/ MDNode /*P*/ Op = SeenIDs.lookup(Flag);
      if (!(Op != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"invalid requirement on flag, flag is not present in module"),
            Flag);
        continue;
      }
      if (Op.getOperand(2).$Metadata$P() != ReqValue) {
        CheckFailed$T(new Twine(/*KEEP_STR*/("invalid requirement on flag, flag does not have the required value")),
            Flag);
        continue;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitModuleFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1190,
   FQN="(anonymous namespace)::Verifier::visitModuleFlag", NM="_ZN12_GLOBAL__N_18Verifier15visitModuleFlagEPKN4llvm6MDNodeERNS1_8DenseMapIPKNS1_8MDStringES4_NS1_12DenseMapInfoIS8_EENS1_6detail12DenseMapPairIS8_S4_EEEERNS1_15SmallVectorImplIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitModuleFlagEPKN4llvm6MDNodeERNS1_8DenseMapIPKNS1_8MDStringES4_NS1_12DenseMapInfoIS8_EENS1_6detail12DenseMapPairIS8_S4_EEEERNS1_15SmallVectorImplIS4_EE")
  //</editor-fold>
  private void visitModuleFlag(/*const*/ MDNode /*P*/ Op,
                 final DenseMap</*const*/ MDString /*P*/ , /*const*/ MDNode /*P*/ > /*&*/ SeenIDs,
                 final SmallVectorImpl</*const*/ MDNode /*P*/ > /*&*/ Requirements) {
    // Each module flag should have three arguments, the merge behavior (a
    // constant int), the flag ID (an MDString), and the value.
    do {
      if (!(Op.getNumOperands() == 3)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"incorrect number of operands in module flag"), Op);
        return;
      }
    } while (false);
    type$ref<Module.ModFlagBehavior> MFB = create_type$ref();
    if (!Module.isValidModFlagBehavior(Op.getOperand(0).$Metadata$P(), MFB)) {
      do {
        if (!((MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract_or_null$ValidPointer(ConstantInt.class, Op.getOperand(0))) != null)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"invalid behavior operand in module flag (expected constant integer)"), Op.getOperand(0));
          return;
        }
      } while (false);
      do {
        if (!(false)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"invalid behavior operand in module flag (unexpected constant)"), Op.getOperand(0));
          return;
        }
      } while (false);
    }
    MDString /*P*/ ID = dyn_cast_or_null_MDString(Op.getOperand(1));
    do {
      if (!((ID) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"invalid ID operand in module flag (expected metadata string)"), Op.getOperand(1));
        return;
      }
    } while (false);

    // Sanity check the values for behaviors with additional requirements.
    switch (MFB.$deref()) {
     case Error:
     case Warning:
     case Override:
      // These behavior types accept any value.
      break;
     case Require:
      {
        // The value should itself be an MDNode with two operands, a flag ID (an
        // MDString), and a value.
        MDNode /*P*/ Value = dyn_cast_MDNode(Op.getOperand(2));
        do {
          if (!((Value != null) && Value.getNumOperands() == 2)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"invalid value for 'require' module flag (expected metadata pair)"), Op.getOperand(2));
            return;
          }
        } while (false);
        do {
          if (!(isa_MDString(Value.getOperand(0)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/("invalid value for 'require' module flag (first value operand should be a string)")), Value.getOperand(0));
            return;
          }
        } while (false);

        // Append it to the list of requirements, to check once all module flags are
        // scanned.
        Requirements.push_back(Value);
        break;
      }
     case Append:
     case AppendUnique:
      {
        // These behavior types require the operand be an MDNode.
        do {
          if (!(isa_MDNode(Op.getOperand(2)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"invalid value for 'append'-type module flag (expected a metadata node)"), Op.getOperand(2));
            return;
          }
        } while (false);
        break;
      }
    }

    // Unless this is a "requires" flag, check the ID is unique.
    if (MFB.$deref() != Module.ModFlagBehavior.Require) {
      boolean Inserted = SeenIDs.insert_pair$KeyT$ValueT(new std.pairPtrPtr</*const*/ MDString /*P*/ , /*const*/ MDNode /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/ID, /*Fwd2*//*Fwd*/Op)).second;
      do {
        if (!(Inserted)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"module flag identifiers must be unique (or of 'require' type)"), ID);
          return;
        }
      } while (false);
    }
  }


  // visitFunction - Verify that a function is ok.
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1876,
   FQN="(anonymous namespace)::Verifier::visitFunction", NM="_ZN12_GLOBAL__N_18Verifier13visitFunctionERKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitFunctionERKN4llvm8FunctionE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFunction(final /*const*/ Function /*&*/ F) {
    visitGlobalValue(F);

    // Check function arguments.
    FunctionType /*P*/ FT = F.getFunctionType();
    /*uint*/int NumArgs = F.arg_size();
    do {
      if (!(Context == $AddrOf(F.getContext()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Function context does not match Module context!"), $AddrOf(F));
        return;
      }
    } while (false);
    do {
      if (!(!F.hasCommonLinkage())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Functions may not have common linkage"), $AddrOf(F));
        return;
      }
    } while (false);
    do {
      if (!(FT.getNumParams() == NumArgs)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"# formal arguments must match # of arguments for function type!"), $AddrOf(F), FT);
        return;
      }
    } while (false);
    do {
      if (!(F.getReturnType().isFirstClassType() || F.getReturnType().isVoidTy() || F.getReturnType().isStructTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Functions cannot return aggregate values!"), $AddrOf(F));
        return;
      }
    } while (false);
    do {
      if (!(!F.hasStructRetAttr() || F.getReturnType().isVoidTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid struct return type!"), $AddrOf(F));
        return;
      }
    } while (false);

    AttributeSet Attrs = F.getAttributes();
    do {
      if (!(verifyAttributeCount(new AttributeSet(Attrs), FT.getNumParams()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute after last parameter!"), $AddrOf(F));
        return;
      }
    } while (false);

    // Check function attributes.
    verifyFunctionAttrs(FT, new AttributeSet(Attrs), $AddrOf(F));

    // On function declarations/definitions, we do not support the builtin
    // attribute. We do not check this in VerifyFunctionAttrs since that is
    // checking for Attributes that can/can not ever be on functions.
    do {
      if (!(!Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.Builtin))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'builtin' can only be applied to a callsite."), $AddrOf(F));
        return;
      }
    } while (false);

    // Check that this function meets the restrictions on this calling convention.
    // Sometimes varargs is used for perfectly forwarding thunks, so some of these
    // restrictions can be lifted.
    switch (F.getCallingConv()) {
     default:
     case CallingConv.C:
      break;
     case CallingConv.Fast:
     case CallingConv.Cold:
     case CallingConv.Intel_OCL_BI:
     case CallingConv.PTX_Kernel:
     case CallingConv.PTX_Device:
      do {
        if (!(!F.isVarArg())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Calling convention does not support varargs or perfect forwarding!"), $AddrOf(F));
          return;
        }
      } while (false);
      break;
    }

    boolean isLLVMdotName = $greatereq_uint(F.getName().size(), 5)
       && $eq_StringRef(F.getName().substr(0, 5), /*STRINGREF_STR*/"llvm.");

    // Check that the argument values match the function type for this function...
    /*uint*/int i = 0;
    for (final /*const*/ Argument /*&*/ Arg : F.args$Const()) {
      do {
        if (!(Arg.getType() == FT.getParamType(i))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Argument value does not match function argument type!"), $AddrOf(Arg), FT.getParamType(i));
          return;
        }
      } while (false);
      do {
        if (!(Arg.getType().isFirstClassType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Function arguments must have first-class types!"), $AddrOf(Arg));
          return;
        }
      } while (false);
      if (!isLLVMdotName) {
        do {
          if (!(!Arg.getType().isMetadataTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Function takes metadata but isn't an intrinsic"), $AddrOf(Arg), $AddrOf(F));
            return;
          }
        } while (false);
        do {
          if (!(!Arg.getType().isTokenTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Function takes token but isn't an intrinsic"), $AddrOf(Arg), $AddrOf(F));
            return;
          }
        } while (false);
      }

      // Check that swifterror argument is only used by loads and stores.
      if (Attrs.hasAttribute(i + 1, Attribute.AttrKind.SwiftError)) {
        verifySwiftErrorValue($AddrOf(Arg));
      }
      ++i;
    }
    if (!isLLVMdotName) {
      do {
        if (!(!F.getReturnType().isTokenTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Functions returns a token but isn't an intrinsic"), $AddrOf(F));
          return;
        }
      } while (false);
    }

    // Get the function metadata attachments.
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
    F.getAllMetadata(MDs);
    assert (F.hasMetadata() != MDs.empty()) : "Bit out-of-sync";
    verifyFunctionMetadata(new ArrayRef<std.pairUIntPtr<MDNode /*P*/ >>(MDs, false));

    // Check validity of the personality function
    if (F.hasPersonalityFn()) {
      Function /*P*/ Per = dyn_cast_Function(F.getPersonalityFn().stripPointerCasts());
      if ((Per != null)) {
        do {
          if (!(Per.getParent() == F.getParent$Const())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Referencing personality function in another module!"), $AddrOf(F), F.getParent$Const(), Per, Per.getParent());
            return;
          }
        } while (false);
      }
    }
    if (F.isMaterializable()) {
      // Function has a body somewhere we can't see.
      do {
        if (!(MDs.empty())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"unmaterialized function cannot have metadata"), $AddrOf(F), MDs.empty() ? (MDNode /*P*/ )null : MDs.front().second);
          return;
        }
      } while (false);
    } else if (F.isDeclaration()) {
      for (final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ I : MDs) {
        do {
          if (!(I.first != LLVMContext.Unnamed_enum.MD_dbg.getValue())) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"function declaration may not have a !dbg attachment"), $AddrOf(F));
            return;
          }
        } while (false);
        do {
          if (!(I.first != LLVMContext.Unnamed_enum.MD_prof.getValue())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"function declaration may not have a !prof attachment"), $AddrOf(F));
            return;
          }
        } while (false);

        // Verify the metadata itself.
        visitMDNode($Deref(I.second));
      }
      do {
        if (!(!F.hasPersonalityFn())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Function declaration shouldn't have a personality routine"), $AddrOf(F));
          return;
        }
      } while (false);
    } else {
      // Verify that this function (which has a body) is not named "llvm.*".  It
      // is not legal to define intrinsics.
      do {
        if (!(!isLLVMdotName)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"llvm intrinsics cannot be defined!"), $AddrOf(F));
          return;
        }
      } while (false);

      // Check the entry node
      /*const*/ BasicBlock /*P*/ Entry = $AddrOf(F.getEntryBlock$Const());
      do {
        if (!(IrLlvmGlobals.pred_empty(Entry))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Entry block to function must not have predecessors!"), Entry);
          return;
        }
      } while (false);

      // The address of the entry block cannot be taken, unless it is dead.
      if (Entry.hasAddressTaken()) {
        do {
          if (!(!BlockAddress.lookup(Entry).isConstantUsed())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"blockaddress may not be used with the entry block!"), Entry);
            return;
          }
        } while (false);
      }

      /*uint*/int NumDebugAttachments = 0;
      /*uint*/int NumProfAttachments = 0;
      // Visit metadata attachments.
      for (final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ I : MDs) {
        // Verify that the attachment is legal.
        switch (LLVMContext.Unnamed_enum.valueOf(I.first)) {
         default:
          break;
         case MD_dbg:
          ++NumDebugAttachments;
          do {
            if (!(NumDebugAttachments == 1)) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"function must have a single !dbg attachment"), $AddrOf(F), I.second);
              return;
            }
          } while (false);
          do {
            if (!(isa_DISubprogram(I.second))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"function !dbg attachment must be a subprogram"), $AddrOf(F), I.second);
              return;
            }
          } while (false);
          break;
         case MD_prof:
          ++NumProfAttachments;
          do {
            if (!(NumProfAttachments == 1)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"function must have a single !prof attachment"), $AddrOf(F), I.second);
              return;
            }
          } while (false);
          break;
        }

        // Verify the metadata itself.
        visitMDNode($Deref(I.second));
      }
    }

    // If this function is actually an intrinsic, verify that it is only used in
    // direct call/invokes, never having its "address taken".
    // Only do this if the module is materialized, otherwise we don't have all the
    // uses.
    if ((F.getIntrinsicID() != 0) && F.getParent$Const().isMaterialized()) {
      type$ptr</*const*/ User /*P*/ > U = create_type$null$ptr();
      if (F.hasAddressTaken($AddrOf(U))) {
        do {
          if (!false) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid user of intrinsic instruction!"), U);
            return;
          }
        } while (false);
      }
    }
    do {
      if (!(!F.hasDLLImportStorageClass() || (F.isDeclaration() && F.hasExternalLinkage()) || F.hasAvailableExternallyLinkage())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Function is marked as dllimport, but not external."), $AddrOf(F));
        return;
      }
    } while (false);

    DISubprogram /*P*/ N = F.getSubprogram();
    if (!(N != null)) {
      return;
    }

    visitDISubprogram($Deref(N));

    // Check that all !dbg attachments lead to back to N (or, at least, another
    // subprogram that describes the same function).
    //
    // FIXME: Check this incrementally while visiting !dbg attachments.
    // FIXME: Only check when N is the canonical subprogram for F.
    SmallPtrSet</*const*/ MDNode /*P*/ > Seen/*J*/= new SmallPtrSet</*const*/ MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    for (final /*const*/ BasicBlock /*&*/ BB : F)  {
      for (final /*const*/ Instruction /*&*/ I : BB) {
        // Be careful about using DILocation here since we might be dealing with
        // broken code (this is the Verifier after all).
        DILocation /*P*/ DL = dyn_cast_or_null_DILocation(I.getDebugLoc().getAsMDNode());
        if (!(DL != null)) {
          continue;
        }
        if (!Seen.insert(DL).second) {
          continue;
        }

        DILocalScope /*P*/ Scope = DL.getInlinedAtScope();
        if ((Scope != null) && !Seen.insert(Scope).second) {
          continue;
        }

        DISubprogram /*P*/ SP = (Scope != null) ? Scope.getSubprogram() : null;

        // Scope and SP could be the same MDNode and we don't want to skip
        // validation in that case
        if ((SP != null) && ((Scope != SP) && !Seen.insert(SP).second)) {
          continue;
        }

        // FIXME: Once N is canonical, check "SP == &N".
        do {
          if (!(SP.describes($AddrOf(F)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"!dbg attachment points at wrong subprogram for function"), N, $AddrOf(F), $AddrOf(I), DL, Scope, SP);
            return;
          }
        } while (false);
      }
    }
  }


  // verifyBasicBlock - Verify that a basic block is well formed...
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2089,
   FQN="(anonymous namespace)::Verifier::visitBasicBlock", NM="_ZN12_GLOBAL__N_18Verifier15visitBasicBlockERN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitBasicBlockERN4llvm10BasicBlockE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitBasicBlock(final BasicBlock /*&*/ BB) {
    InstsInThisBlock.clear();

    // Ensure that basic blocks have terminators!
    do {
      if (!((BB.getTerminator()) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Basic Block does not have terminator!"), $AddrOf(BB));
        return;
      }
    } while (false);

    // Check constraints that this basic block imposes on all of the PHI nodes in
    // it.
    if (isa_PHINode(BB.front())) {
      SmallVector<BasicBlock /*P*/ > Preds/*J*/= new SmallVector<BasicBlock /*P*/ >(JD$T.INSTANCE, 8, IrLlvmGlobals.pred_begin_BasicBlock$P($AddrOf(BB)), IrLlvmGlobals.pred_end_BasicBlock$P($AddrOf(BB)), (BasicBlock /*P*/ )null);
      SmallVector<std.pairPtrPtr<BasicBlock /*P*/ , Value /*P*/ >> Values/*J*/= new SmallVector<std.pairPtrPtr<BasicBlock /*P*/ , Value /*P*/ >>(8, new std.pairPtrPtr<BasicBlock /*P*/ , Value /*P*/ >());
      std.sort(Preds.begin(), Preds.end(), (BasicBlock LHS, BasicBlock RHS) -> Native.compare$JavaRef(LHS, RHS) < 0);
      PHINode /*P*/ PN;
      for (ilist_iterator<Instruction> I = BB.begin(); ((PN = dyn_cast_PHINode(I.$star())) != null); I.$preInc()) {
        // Ensure that PHI nodes have at least one entry!
        do {
          if (!(PN.getNumIncomingValues() != 0)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"PHI nodes must have at least one entry.  If the block is dead, the PHI should be removed!"), PN);
            return;
          }
        } while (false);
        do {
          if (!(PN.getNumIncomingValues() == Preds.size())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"PHINode should have one entry for each predecessor of its parent basic block!"), PN);
            return;
          }
        } while (false);

        // Get and sort all incoming values in the PHI node...
        Values.clear();
        Values.reserve(PN.getNumIncomingValues());
        for (/*uint*/int i = 0, e = PN.getNumIncomingValues(); i != e; ++i)  {
          Values.push_back(std.make_pair_Ptr_Ptr(PN.getIncomingBlock(i), PN.getIncomingValue(i)
                  ));
        }
        std.sort(Values.begin(), Values.end());

        for (/*uint*/int i = 0, e = Values.size(); i != e; ++i) {
          // Check to make sure that if there is more than one entry for a
          // particular basic block in this PHI node, that the incoming values are
          // all identical.
          //
          do {
            if (!(i == 0 || Values.$at(i).first != Values.$at(i - 1).first || Values.$at(i).second == Values.$at(i - 1).second)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"PHI node has multiple entries for the same basic block with different incoming values!"), PN, Values.$at(i).first, Values.$at(i).second, Values.$at(i - 1).second);
              return;
            }
          } while (false);

          // Check to make sure that the predecessors and PHI node entries are
          // matched up.
          do {
            if (!(Values.$at(i).first == Preds.$at(i))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"PHI node entries do not match predecessors!"), PN, Values.$at(i).first, Preds.$at(i));
              return;
            }
          } while (false);
        }
      }
    }

    // Check that all instructions have their parent pointers set up correctly.
    for (final Instruction /*&*/ I : BB) {
      do {
        if (!(I.getParent() == $AddrOf(BB))) {
          CheckFailed(new Twine(/*KEEP_STR*/"Instruction has bogus parent pointer!"));
          return;
        }
      } while (false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitRangeMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2918,
   FQN="(anonymous namespace)::Verifier::visitRangeMetadata", NM="_ZN12_GLOBAL__N_18Verifier18visitRangeMetadataERN4llvm11InstructionEPNS1_6MDNodeEPNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18visitRangeMetadataERN4llvm11InstructionEPNS1_6MDNodeEPNS1_4TypeE")
  //</editor-fold>
  private void visitRangeMetadata(final Instruction /*&*/ I,
                    MDNode /*P*/ Range, Type /*P*/ Ty) {
    ConstantRange LastRange = null;
    try {
      assert ((Range != null) && Range == I.getMetadata(LLVMContext.Unnamed_enum.MD_range.getValue())) : "precondition violation";

      /*uint*/int NumOperands = Range.getNumOperands();
      do {
        if (!($rem_uint(NumOperands, 2) == 0)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Unfinished range!"), Range);
          return;
        }
      } while (false);
      /*uint*/int NumRanges = $div_uint(NumOperands, 2);
      do {
        if (!($greatereq_uint(NumRanges, 1))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"It should have at least one range!"), Range);
          return;
        }
      } while (false);

      LastRange/*J*/= new ConstantRange(1); // Dummy initial value
      for (/*uint*/int i = 0; $less_uint(i, NumRanges); ++i) {
        ConstantRange CurRange = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ConstantInt /*P*/ Low = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, Range.getOperand(2 * i));
          do {
            if (!((Low) != null)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"The lower limit must be an integer!"), Low);
              return;
            }
          } while (false);
          ConstantInt /*P*/ High = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, Range.getOperand(2 * i + 1));
          do {
            if (!((High) != null)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"The upper limit must be an integer!"), High);
              return;
            }
          } while (false);
          do {
            if (!(High.getType() == Low.getType() && High.getType() == Ty)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Range types must match instruction type!"), $AddrOf(I));
              return;
            }
          } while (false);

          APInt HighV = new APInt(High.getValue());
          APInt LowV = new APInt(Low.getValue());
          CurRange/*J*/= new ConstantRange(new APInt(LowV), new APInt(HighV));
          do {
            if (!(!CurRange.isEmptySet() && !CurRange.isFullSet())) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Range must not be empty!"), Range);
              return;
            }
          } while (false);
          if (i != 0) {
            do {
              if ($c$.clean(!($c$.track(CurRange.intersectWith(LastRange)).isEmptySet()))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Intervals are overlapping"), Range);
                return;
              }
            } while (false);
            do {
              if (!(LowV.sgt(LastRange.getLower()))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Intervals are not in order"), Range);
                return;
              }
            } while (false);
            do {
              if (!(!isContiguous(CurRange, LastRange))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Intervals are contiguous"), Range);
                return;
              }
            } while (false);
          }
          $c$.clean(LastRange.$assignMove($c$.track(new ConstantRange(new APInt(LowV), new APInt(HighV)))));
        } finally {
          if (CurRange != null) { CurRange.$destroy(); }
          $c$.$destroy();
        }
      }
      if ($greater_uint(NumRanges, 2)) {
        ConstantRange FirstRange = null;
        try {
          APInt FirstLow = new APInt(MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, Range.getOperand(0)).getValue());
          APInt FirstHigh = new APInt(MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, Range.getOperand(1)).getValue());
          FirstRange/*J*/= new ConstantRange(new APInt(FirstLow), new APInt(FirstHigh));
          do {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if ($c$.clean(!($c$.track(FirstRange.intersectWith(LastRange)).isEmptySet()))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Intervals are overlapping"), Range);
                return;
              }
            } finally {
              $c$.$destroy();
            }
          } while (false);
          do {
            if (!(!isContiguous(FirstRange, LastRange))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Intervals are contiguous"), Range);
              return;
            }
          } while (false);
        } finally {
          if (FirstRange != null) { FirstRange.$destroy(); }
        }
      }
    } finally {
      if (LastRange != null) { LastRange.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDereferenceableMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3582,
   FQN="(anonymous namespace)::Verifier::visitDereferenceableMetadata", NM="_ZN12_GLOBAL__N_18Verifier28visitDereferenceableMetadataERN4llvm11InstructionEPNS1_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier28visitDereferenceableMetadataERN4llvm11InstructionEPNS1_6MDNodeE")
  //</editor-fold>
  private void visitDereferenceableMetadata(final Instruction /*&*/ I, MDNode /*P*/ MD) {
    do {
      if (!(I.getType().isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"dereferenceable, dereferenceable_or_null apply only to pointer types"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(isa_LoadInst(I))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"dereferenceable, dereferenceable_or_null apply only to load instructions, use attributes for calls or invokes"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(MD.getNumOperands() == 1)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"dereferenceable, dereferenceable_or_null take one operand!"), $AddrOf(I));
        return;
      }
    } while (false);
    ConstantInt /*P*/ CI = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, MD.getOperand(0));
    do {
      if (!((CI != null) && CI.getType().isIntegerTy(64))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"dereferenceable, dereferenceable_or_null metadata value must be an i64!"), $AddrOf(I));
        return;
      }
    } while (false);
  }


  /*template <class Ty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::isValidMetadataArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 370,
   FQN="(anonymous namespace)::Verifier::isValidMetadataArray", NM="Tpl__ZN12_GLOBAL__N_18Verifier20isValidMetadataArrayERKN4llvm7MDTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_18Verifier20isValidMetadataArrayERKN4llvm7MDTupleE")
  //</editor-fold>
  private </*class*/ Ty> boolean isValidMetadataArray(final /*const*/ MDTuple /*&*/ N) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDILocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 795,
   FQN="(anonymous namespace)::Verifier::visitDILocation", NM="_ZN12_GLOBAL__N_18Verifier15visitDILocationERKN4llvm10DILocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitDILocationERKN4llvm10DILocationE")
  //</editor-fold>
  private void visitDILocation(final /*const*/ DILocation /*&*/ N) {
    do {
      if (!((N.getRawScope() != null) && isa_DILocalScope(N.getRawScope()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"location requires a valid scope"), $AddrOf(N), N.getRawScope());
        return;
      }
    } while (false);
    {
      Metadata /*P*/ IA = N.getRawInlinedAt();
      if ((IA != null)) {
        do {
          if (!(isa_DILocation(IA))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"inlined-at should be a location"), $AddrOf(N), IA);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1112,
   FQN="(anonymous namespace)::Verifier::visitDIExpression", NM="_ZN12_GLOBAL__N_18Verifier17visitDIExpressionERKN4llvm12DIExpressionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitDIExpressionERKN4llvm12DIExpressionE")
  //</editor-fold>
  private void visitDIExpression(final /*const*/ DIExpression /*&*/ N) {
    do {
      if (!(N.isValid())) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid expression"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitGenericDINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 802,
   FQN="(anonymous namespace)::Verifier::visitGenericDINode", NM="_ZN12_GLOBAL__N_18Verifier18visitGenericDINodeERKN4llvm13GenericDINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18visitGenericDINodeERKN4llvm13GenericDINodeE")
  //</editor-fold>
  private void visitGenericDINode(final /*const*/ GenericDINode /*&*/ N) {
    do {
      if (!((N.getTag()) != 0)) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDISubrange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 811,
   FQN="(anonymous namespace)::Verifier::visitDISubrange", NM="_ZN12_GLOBAL__N_18Verifier15visitDISubrangeERKN4llvm10DISubrangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitDISubrangeERKN4llvm10DISubrangeE")
  //</editor-fold>
  private void visitDISubrange(final /*const*/ DISubrange /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_subrange_type))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(N.getCount() >= -1)) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid subrange count"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIEnumerator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 816,
   FQN="(anonymous namespace)::Verifier::visitDIEnumerator", NM="_ZN12_GLOBAL__N_18Verifier17visitDIEnumeratorERKN4llvm12DIEnumeratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitDIEnumeratorERKN4llvm12DIEnumeratorE")
  //</editor-fold>
  private void visitDIEnumerator(final /*const*/ DIEnumerator /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_enumerator))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIBasicType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 820,
   FQN="(anonymous namespace)::Verifier::visitDIBasicType", NM="_ZN12_GLOBAL__N_18Verifier16visitDIBasicTypeERKN4llvm11DIBasicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitDIBasicTypeERKN4llvm11DIBasicTypeE")
  //</editor-fold>
  private void visitDIBasicType(final /*const*/ DIBasicType /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_base_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_unspecified_type))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIDerivedType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 826,
   FQN="(anonymous namespace)::Verifier::visitDIDerivedType", NM="_ZN12_GLOBAL__N_18Verifier18visitDIDerivedTypeERKN4llvm13DIDerivedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18visitDIDerivedTypeERKN4llvm13DIDerivedTypeE")
  //</editor-fold>
  private void visitDIDerivedType(final /*const*/ DIDerivedType /*&*/ N) {
    // Common scope checks.
    visitDIScope(N);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_typedef) || N.getTag() == $ushort2uint(Tag.DW_TAG_pointer_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_ptr_to_member_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_reference_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_rvalue_reference_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_const_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_volatile_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_restrict_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_member) || N.getTag() == $ushort2uint(Tag.DW_TAG_inheritance) || N.getTag() == $ushort2uint(Tag.DW_TAG_friend))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    if (N.getTag() == $ushort2uint(Tag.DW_TAG_ptr_to_member_type)) {
      do {
        if (!(VerifierStatics.isType(N.getRawExtraData()))) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid pointer to member type"), $AddrOf(N), N.getRawExtraData());
          return;
        }
      } while (false);
    }
    do {
      if (!(VerifierStatics.isScope(N.getRawScope()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid scope"), $AddrOf(N), N.getRawScope());
        return;
      }
    } while (false);
    do {
      if (!(VerifierStatics.isType(N.getRawBaseType()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid base type"), $AddrOf(N), N.getRawBaseType());
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDICompositeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 866,
   FQN="(anonymous namespace)::Verifier::visitDICompositeType", NM="_ZN12_GLOBAL__N_18Verifier20visitDICompositeTypeERKN4llvm15DICompositeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitDICompositeTypeERKN4llvm15DICompositeTypeE")
  //</editor-fold>
  private void visitDICompositeType(final /*const*/ DICompositeType /*&*/ N) {
    // Common scope checks.
    visitDIScope(N);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_array_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_structure_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_union_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_enumeration_type) || N.getTag() == $ushort2uint(Tag.DW_TAG_class_type))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(VerifierStatics.isScope(N.getRawScope()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid scope"), $AddrOf(N), N.getRawScope());
        return;
      }
    } while (false);
    do {
      if (!(VerifierStatics.isType(N.getRawBaseType()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid base type"), $AddrOf(N), N.getRawBaseType());
        return;
      }
    } while (false);
    do {
      if (!(!(N.getRawElements() != null) || isa_MDTuple(N.getRawElements()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid composite elements"), $AddrOf(N), N.getRawElements());
        return;
      }
    } while (false);
    do {
      if (!(VerifierStatics.isType(N.getRawVTableHolder()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid vtable holder"), $AddrOf(N), N.getRawVTableHolder());
        return;
      }
    } while (false);
    do {
      if (!(!VerifierStatics.hasConflictingReferenceFlags(N.getFlags()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid reference flags"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ Params = N.getRawTemplateParams();
      if ((Params != null)) {
        visitTemplateParams(N, $Deref(Params));
      }
    }
    if (N.getTag() == $ushort2uint(Tag.DW_TAG_class_type)
       || N.getTag() == $ushort2uint(Tag.DW_TAG_union_type)) {
      do {
        if (!((N.getFile() != null) && !N.getFile().getFilename().empty())) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"class/union requires a filename"), $AddrOf(N), N.getFile());
          return;
        }
      } while (false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDISubroutineType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 897,
   FQN="(anonymous namespace)::Verifier::visitDISubroutineType", NM="_ZN12_GLOBAL__N_18Verifier21visitDISubroutineTypeERKN4llvm16DISubroutineTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier21visitDISubroutineTypeERKN4llvm16DISubroutineTypeE")
  //</editor-fold>
  private void visitDISubroutineType(final /*const*/ DISubroutineType /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_subroutine_type))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ Types = N.getRawTypeArray();
      if ((Types != null)) {
        do {
          if (!(isa_MDTuple(Types))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid composite elements"), $AddrOf(N), Types);
            return;
          }
        } while (false);
        for (MDOperand O : N.getTypeArray().$arrow().operands()) {
          Metadata /*P*/ Ty = O.$Metadata$P();
          do {
            if (!(VerifierStatics.isType(Ty))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid subroutine type ref"), $AddrOf(N), Types, Ty);
              return;
            }
          } while (false);
        }
      }
    }
    do {
      if (!(!VerifierStatics.hasConflictingReferenceFlags(N.getFlags()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid reference flags"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 909,
   FQN="(anonymous namespace)::Verifier::visitDIFile", NM="_ZN12_GLOBAL__N_18Verifier11visitDIFileERKN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier11visitDIFileERKN4llvm6DIFileE")
  //</editor-fold>
  private void visitDIFile(final /*const*/ DIFile /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_file_type))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDICompileUnit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 913,
   FQN="(anonymous namespace)::Verifier::visitDICompileUnit", NM="_ZN12_GLOBAL__N_18Verifier18visitDICompileUnitERKN4llvm13DICompileUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18visitDICompileUnitERKN4llvm13DICompileUnitE")
  //</editor-fold>
  private void visitDICompileUnit(final /*const*/ DICompileUnit /*&*/ N) {
    do {
      if (!(N.isDistinct())) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"compile units must be distinct"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_compile_unit))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);

    // Don't bother verifying the compilation directory or producer string
    // as those could be empty.
    do {
      if (!((N.getRawFile() != null) && isa_DIFile(N.getRawFile()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid file"), $AddrOf(N), N.getRawFile());
        return;
      }
    } while (false);
    do {
      if (!(!N.getFile().getFilename().empty())) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid filename"), $AddrOf(N), N.getFile());
        return;
      }
    } while (false);
    do {
      if (!(($lesseq_uint(N.getEmissionKind().getValue(), DICompileUnit.DebugEmissionKind.LastEmissionKind.getValue())))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid emission kind"), $AddrOf(N));
        return;
      }
    } while (false);
    {

      Metadata /*P*/ Array = N.getRawEnumTypes();
      if ((Array != null)) {
        do {
          if (!(isa_MDTuple(Array))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid enum list"), $AddrOf(N), Array);
            return;
          }
        } while (false);
        for (MDOperand O : N.getEnumTypes().$arrow().operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          DICompositeType /*P*/ Enum = dyn_cast_or_null_DICompositeType(Op);
          do {
            if (!((Enum != null) && Enum.getTag() == $ushort2uint(Tag.DW_TAG_enumeration_type))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid enum type"), $AddrOf(N), N.getEnumTypes(), Op);
              return;
            }
          } while (false);
        }
      }
    }
    {
      Metadata /*P*/ Array = N.getRawRetainedTypes();
      if ((Array != null)) {
        do {
          if (!(isa_MDTuple(Array))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid retained type list"), $AddrOf(N), Array);
            return;
          }
        } while (false);
        for (MDOperand O : N.getRetainedTypes().$arrow().operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          do {
            if (!((Op != null) && (isa_DIType(Op) || (isa_DISubprogram(Op) && cast_DISubprogram(Op).isDefinition() == false)))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid retained type"), $AddrOf(N), Op);
              return;
            }
          } while (false);
        }
      }
    }
    {
      Metadata /*P*/ Array = N.getRawGlobalVariables();
      if ((Array != null)) {
        do {
          if (!(isa_MDTuple(Array))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid global variable list"), $AddrOf(N), Array);
            return;
          }
        } while (false);
        for (MDOperand O : N.getGlobalVariables().$arrow().operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          do {
            if (!((Op != null) && isa_DIGlobalVariable(Op))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid global variable ref"), $AddrOf(N), Op);
              return;
            }
          } while (false);
        }
      }
    }
    {
      Metadata /*P*/ Array = N.getRawImportedEntities();
      if ((Array != null)) {
        do {
          if (!(isa_MDTuple(Array))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid imported entity list"), $AddrOf(N), Array);
            return;
          }
        } while (false);
        for (MDOperand O : N.getImportedEntities().$arrow().operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          do {
            if (!((Op != null) && isa_DIImportedEntity(Op))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid imported entity ref"), $AddrOf(N), Op);
              return;
            }
          } while (false);
        }
      }
    }
    {
      Metadata /*P*/ Array = N.getRawMacros();
      if ((Array != null)) {
        do {
          if (!(isa_MDTuple(Array))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid macro list"), $AddrOf(N), Array);
            return;
          }
        } while (false);
        for (MDOperand O : N.getMacros().$arrow().operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          do {
            if (!((Op != null) && isa_DIMacroNode(Op))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid macro ref"), $AddrOf(N), Op);
              return;
            }
          } while (false);
        }
      }
    }
    CUVisited.insert($AddrOf(N));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDISubprogram">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 967,
   FQN="(anonymous namespace)::Verifier::visitDISubprogram", NM="_ZN12_GLOBAL__N_18Verifier17visitDISubprogramERKN4llvm12DISubprogramE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitDISubprogramERKN4llvm12DISubprogramE")
  //</editor-fold>
  private void visitDISubprogram(final /*const*/ DISubprogram /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_subprogram))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(VerifierStatics.isScope(N.getRawScope()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid scope"), $AddrOf(N), N.getRawScope());
        return;
      }
    } while (false);
    {
      Metadata /*P*/ F = N.getRawFile();
      if ((F != null)) {
        do {
          if (!(isa_DIFile(F))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid file"), $AddrOf(N), F);
            return;
          }
        } while (false);
      }
    }
    {
      Metadata /*P*/ T = N.getRawType();
      if ((T != null)) {
        do {
          if (!(isa_DISubroutineType(T))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid subroutine type"), $AddrOf(N), T);
            return;
          }
        } while (false);
      }
    }
    do {
      if (!(VerifierStatics.isType(N.getRawContainingType()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid containing type"), $AddrOf(N), N.getRawContainingType());
        return;
      }
    } while (false);
    {
      Metadata /*P*/ Params = N.getRawTemplateParams();
      if ((Params != null)) {
        visitTemplateParams(N, $Deref(Params));
      }
    }
    {
      Metadata /*P*/ S = N.getRawDeclaration();
      if ((S != null)) {
        do {
          if (!(isa_DISubprogram(S) && !cast_DISubprogram(S).isDefinition())) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid subprogram declaration"), $AddrOf(N), S);
            return;
          }
        } while (false);
      }
    }
    {
      Metadata /*P*/ RawVars = N.getRawVariables();
      if ((RawVars != null)) {
        MDTuple /*P*/ Vars = dyn_cast_MDTuple(RawVars);
        do {
          if (!((Vars) != null)) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid variable list"), $AddrOf(N), RawVars);
            return;
          }
        } while (false);
        for (MDOperand O : Vars.operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          do {
            if (!((Op != null) && isa_DILocalVariable(Op))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid local variable"), $AddrOf(N), Vars, Op);
              return;
            }
          } while (false);
        }
      }
    }
    do {
      if (!(!VerifierStatics.hasConflictingReferenceFlags(N.getFlags()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid reference flags"), $AddrOf(N));
        return;
      }
    } while (false);

    Metadata /*P*/ Unit = N.getRawUnit();
    if (N.isDefinition()) {
      // Subprogram definitions (not part of the type hierarchy).
      do {
        if (!(N.isDistinct())) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"subprogram definitions must be distinct"), $AddrOf(N));
          return;
        }
      } while (false);
      do {
        if (!((Unit) != null)) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"subprogram definitions must have a compile unit"), $AddrOf(N));
          return;
        }
      } while (false);
      do {
        if (!(isa_DICompileUnit(Unit))) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid unit type"), $AddrOf(N), Unit);
          return;
        }
      } while (false);
    } else {
      // Subprogram declarations (part of the type hierarchy).
      do {
        if (!(!(Unit != null))) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"subprogram declarations must not have a compile unit"), $AddrOf(N));
          return;
        }
      } while (false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDILexicalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1010,
   FQN="(anonymous namespace)::Verifier::visitDILexicalBlock", NM="_ZN12_GLOBAL__N_18Verifier19visitDILexicalBlockERKN4llvm14DILexicalBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitDILexicalBlockERKN4llvm14DILexicalBlockE")
  //</editor-fold>
  private void visitDILexicalBlock(final /*const*/ DILexicalBlock /*&*/ N) {
    visitDILexicalBlockBase(N);
    do {
      if (!((N.getLine() != 0) || !(N.getColumn() != 0))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"cannot have column info without line info"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDILexicalBlockFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1017,
   FQN="(anonymous namespace)::Verifier::visitDILexicalBlockFile", NM="_ZN12_GLOBAL__N_18Verifier23visitDILexicalBlockFileERKN4llvm18DILexicalBlockFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier23visitDILexicalBlockFileERKN4llvm18DILexicalBlockFileE")
  //</editor-fold>
  private void visitDILexicalBlockFile(final /*const*/ DILexicalBlockFile /*&*/ N) {
    visitDILexicalBlockBase(N);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDINamespace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1021,
   FQN="(anonymous namespace)::Verifier::visitDINamespace", NM="_ZN12_GLOBAL__N_18Verifier16visitDINamespaceERKN4llvm11DINamespaceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitDINamespaceERKN4llvm11DINamespaceE")
  //</editor-fold>
  private void visitDINamespace(final /*const*/ DINamespace /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_namespace))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ S = N.getRawScope();
      if ((S != null)) {
        do {
          if (!(isa_DIScope(S))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid scope ref"), $AddrOf(N), S);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1051,
   FQN="(anonymous namespace)::Verifier::visitDIModule", NM="_ZN12_GLOBAL__N_18Verifier13visitDIModuleERKN4llvm8DIModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitDIModuleERKN4llvm8DIModuleE")
  //</editor-fold>
  private void visitDIModule(final /*const*/ DIModule /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_module))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(!N.getName().empty())) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"anonymous module"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDITemplateTypeParameter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1060,
   FQN="(anonymous namespace)::Verifier::visitDITemplateTypeParameter", NM="_ZN12_GLOBAL__N_18Verifier28visitDITemplateTypeParameterERKN4llvm23DITemplateTypeParameterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier28visitDITemplateTypeParameterERKN4llvm23DITemplateTypeParameterE")
  //</editor-fold>
  private void visitDITemplateTypeParameter(final /*const*/ DITemplateTypeParameter /*&*/ N) {
    visitDITemplateParameter(N);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_template_type_parameter))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDITemplateValueParameter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1067,
   FQN="(anonymous namespace)::Verifier::visitDITemplateValueParameter", NM="_ZN12_GLOBAL__N_18Verifier29visitDITemplateValueParameterERKN4llvm24DITemplateValueParameterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier29visitDITemplateValueParameterERKN4llvm24DITemplateValueParameterE")
  //</editor-fold>
  private void visitDITemplateValueParameter(final /*const*/ DITemplateValueParameter /*&*/ N) {
    visitDITemplateParameter(N);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_template_value_parameter) || N.getTag() == $ushort2uint(Tag.DW_TAG_GNU_template_template_param) || N.getTag() == $ushort2uint(Tag.DW_TAG_GNU_template_parameter_pack))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIGlobalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1085,
   FQN="(anonymous namespace)::Verifier::visitDIGlobalVariable", NM="_ZN12_GLOBAL__N_18Verifier21visitDIGlobalVariableERKN4llvm16DIGlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier21visitDIGlobalVariableERKN4llvm16DIGlobalVariableE")
  //</editor-fold>
  private void visitDIGlobalVariable(final /*const*/ DIGlobalVariable /*&*/ N) {
    // Checks common to all variables.
    visitDIVariable(N);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_variable))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(!N.getName().empty())) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"missing global variable name"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ V = N.getRawVariable();
      if ((V != null)) {
        do {
          if (!(isa_ConstantAsMetadata(V) && !isa_Function(cast_ConstantAsMetadata(V).getValue()))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid global varaible ref"), $AddrOf(N), V);
            return;
          }
        } while (false);
        visitConstantExprsRecursively(cast_ConstantAsMetadata(V).getValue());
      }
    }
    {
      Metadata /*P*/ Member = N.getRawStaticDataMemberDeclaration();
      if ((Member != null)) {
        do {
          if (!(isa_DIDerivedType(Member))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid static data member declaration"), $AddrOf(N), Member);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDILocalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1103,
   FQN="(anonymous namespace)::Verifier::visitDILocalVariable", NM="_ZN12_GLOBAL__N_18Verifier20visitDILocalVariableERKN4llvm15DILocalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitDILocalVariableERKN4llvm15DILocalVariableE")
  //</editor-fold>
  private void visitDILocalVariable(final /*const*/ DILocalVariable /*&*/ N) {
    // Checks common to all variables.
    visitDIVariable(N);
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_variable))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!((N.getRawScope() != null) && isa_DILocalScope(N.getRawScope()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"local variable requires a valid scope"), $AddrOf(N), N.getRawScope());
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIObjCProperty">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1116,
   FQN="(anonymous namespace)::Verifier::visitDIObjCProperty", NM="_ZN12_GLOBAL__N_18Verifier19visitDIObjCPropertyERKN4llvm14DIObjCPropertyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitDIObjCPropertyERKN4llvm14DIObjCPropertyE")
  //</editor-fold>
  private void visitDIObjCProperty(final /*const*/ DIObjCProperty /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_APPLE_property))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ T = N.getRawType();
      if ((T != null)) {
        do {
          if (!(VerifierStatics.isType(T))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid type ref"), $AddrOf(N), T);
            return;
          }
        } while (false);
      }
    }
    {
      Metadata /*P*/ F = N.getRawFile();
      if ((F != null)) {
        do {
          if (!(isa_DIFile(F))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid file"), $AddrOf(N), F);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIImportedEntity">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1124,
   FQN="(anonymous namespace)::Verifier::visitDIImportedEntity", NM="_ZN12_GLOBAL__N_18Verifier21visitDIImportedEntityERKN4llvm16DIImportedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier21visitDIImportedEntityERKN4llvm16DIImportedEntityE")
  //</editor-fold>
  private void visitDIImportedEntity(final /*const*/ DIImportedEntity /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_imported_module) || N.getTag() == $ushort2uint(Tag.DW_TAG_imported_declaration))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ S = N.getRawScope();
      if ((S != null)) {
        do {
          if (!(isa_DIScope(S))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid scope for imported entity"), $AddrOf(N), S);
            return;
          }
        } while (false);
      }
    }
    do {
      if (!(VerifierStatics.isDINode(N.getRawEntity()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid imported entity"), $AddrOf(N), N.getRawEntity());
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIMacro">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1027,
   FQN="(anonymous namespace)::Verifier::visitDIMacro", NM="_ZN12_GLOBAL__N_18Verifier12visitDIMacroERKN4llvm7DIMacroE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier12visitDIMacroERKN4llvm7DIMacroE")
  //</editor-fold>
  private void visitDIMacro(final /*const*/ DIMacro /*&*/ N) {
    do {
      if (!(N.getMacinfoType() == MacinfoRecordType.DW_MACINFO_define || N.getMacinfoType() == MacinfoRecordType.DW_MACINFO_undef)) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid macinfo type"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!(!N.getName().empty())) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"anonymous macro"), $AddrOf(N));
        return;
      }
    } while (false);
    if (!N.getValue().empty()) {
      assert (N.getValue().data().$at(0) != $$SPACE) : "Macro value has a space prefix";
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIMacroFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1037,
   FQN="(anonymous namespace)::Verifier::visitDIMacroFile", NM="_ZN12_GLOBAL__N_18Verifier16visitDIMacroFileERKN4llvm11DIMacroFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitDIMacroFileERKN4llvm11DIMacroFileE")
  //</editor-fold>
  private void visitDIMacroFile(final /*const*/ DIMacroFile /*&*/ N) {
    do {
      if (!(N.getMacinfoType() == MacinfoRecordType.DW_MACINFO_start_file)) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid macinfo type"), $AddrOf(N));
        return;
      }
    } while (false);
    {
      Metadata /*P*/ F = N.getRawFile();
      if ((F != null)) {
        do {
          if (!(isa_DIFile(F))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid file"), $AddrOf(N), F);
            return;
          }
        } while (false);
      }
    }
    {

      Metadata /*P*/ Array = N.getRawElements();
      if ((Array != null)) {
        do {
          if (!(isa_MDTuple(Array))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid macro list"), $AddrOf(N), Array);
            return;
          }
        } while (false);
        for (MDOperand O : N.getElements().$arrow().operands()) {
          Metadata /*P*/ Op = O.$Metadata$P();
          do {
            if (!((Op != null) && isa_DIMacroNode(Op))) {
              DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid macro ref"), $AddrOf(N), Op);
              return;
            }
          } while (false);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 806,
   FQN="(anonymous namespace)::Verifier::visitDIScope", NM="_ZN12_GLOBAL__N_18Verifier12visitDIScopeERKN4llvm7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier12visitDIScopeERKN4llvm7DIScopeE")
  //</editor-fold>
  private void visitDIScope(final /*const*/ DIScope /*&*/ N) {
    {
      Metadata /*P*/ F = N.getRawFile();
      if ((F != null)) {
        do {
          if (!(isa_DIFile(F))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid file"), $AddrOf(N), F);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDIVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1077,
   FQN="(anonymous namespace)::Verifier::visitDIVariable", NM="_ZN12_GLOBAL__N_18Verifier15visitDIVariableERKN4llvm10DIVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitDIVariableERKN4llvm10DIVariableE")
  //</editor-fold>
  private void visitDIVariable(final /*const*/ DIVariable /*&*/ N) {
    {
      Metadata /*P*/ S = N.getRawScope();
      if ((S != null)) {
        do {
          if (!(isa_DIScope(S))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid scope"), $AddrOf(N), S);
            return;
          }
        } while (false);
      }
    }
    do {
      if (!(VerifierStatics.isType(N.getRawType()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid type ref"), $AddrOf(N), N.getRawType());
        return;
      }
    } while (false);
    {
      Metadata /*P*/ F = N.getRawFile();
      if ((F != null)) {
        do {
          if (!(isa_DIFile(F))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid file"), $AddrOf(N), F);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDILexicalBlockBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1004,
   FQN="(anonymous namespace)::Verifier::visitDILexicalBlockBase", NM="_ZN12_GLOBAL__N_18Verifier23visitDILexicalBlockBaseERKN4llvm18DILexicalBlockBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier23visitDILexicalBlockBaseERKN4llvm18DILexicalBlockBaseE")
  //</editor-fold>
  private void visitDILexicalBlockBase(final /*const*/ DILexicalBlockBase /*&*/ N) {
    do {
      if (!(N.getTag() == $ushort2uint(Tag.DW_TAG_lexical_block))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid tag"), $AddrOf(N));
        return;
      }
    } while (false);
    do {
      if (!((N.getRawScope() != null) && isa_DILocalScope(N.getRawScope()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid local scope"), $AddrOf(N), N.getRawScope());
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDITemplateParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1056,
   FQN="(anonymous namespace)::Verifier::visitDITemplateParameter", NM="_ZN12_GLOBAL__N_18Verifier24visitDITemplateParameterERKN4llvm19DITemplateParameterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier24visitDITemplateParameterERKN4llvm19DITemplateParameterE")
  //</editor-fold>
  private void visitDITemplateParameter(final /*const*/ DITemplateParameter /*&*/ N) {
    do {
      if (!(VerifierStatics.isType(N.getRawType()))) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid type ref"), $AddrOf(N), N.getRawType());
        return;
      }
    } while (false);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitTemplateParams">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 857,
   FQN="(anonymous namespace)::Verifier::visitTemplateParams", NM="_ZN12_GLOBAL__N_18Verifier19visitTemplateParamsERKN4llvm6MDNodeERKNS1_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitTemplateParamsERKN4llvm6MDNodeERKNS1_8MetadataE")
  //</editor-fold>
  private void visitTemplateParams(final /*const*/ MDNode /*&*/ N, final /*const*/ Metadata /*&*/ RawParams) {
    /*const*/ MDTuple /*P*/ Params = dyn_cast_MDTuple($AddrOf(RawParams));
    do {
      if (!((Params) != null)) {
        DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid template params"), $AddrOf(N), $AddrOf(RawParams));
        return;
      }
    } while (false);
    for (MDOperand O : Params.operands()) {
      Metadata /*P*/ Op = O.$Metadata$P();
      do {
        if (!((Op != null) && isa_DITemplateParameter(Op))) {
          DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid template parameter"), $AddrOf(N), Params, Op);
          return;
        }
      } while (false);
    }
  }


  // InstVisitor overrides...
  //JAVA: using InstVisitor<Verifier>::visit;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 480,
   FQN="(anonymous namespace)::Verifier::visit", NM="_ZN12_GLOBAL__N_18Verifier5visitERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier5visitERN4llvm11InstructionE")
  //</editor-fold>
  private void visit(final Instruction /*&*/ I) {
    for (/*uint*/int i = 0, e = I.getNumOperands$User(); i != e; ++i)  {
      do {
        if (!(I.getOperand(i) != null)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Operand is null"), $AddrOf(I));
          return;
        }
      } while (false);
    }
    InstVisitorVoid.super.visit_Instruction(I);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitTruncInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2224,
   FQN="(anonymous namespace)::Verifier::visitTruncInst", NM="_ZN12_GLOBAL__N_18Verifier14visitTruncInstERN4llvm9TruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier14visitTruncInstERN4llvm9TruncInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitTruncInst(final TruncInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    // Get the size of the types in bits, we'll need this later
    /*uint*/int SrcBitSize = SrcTy.getScalarSizeInBits();
    /*uint*/int DestBitSize = DestTy.getScalarSizeInBits();
    do {
      if (!(SrcTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Trunc only operates on integer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Trunc only produces integer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"trunc source and destination must both be a vector or neither"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!($greater_uint(SrcBitSize, DestBitSize))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"DestTy too big for Trunc"), $AddrOf(I));
        return;
      }
    } while (false);

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitZExtInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2242,
   FQN="(anonymous namespace)::Verifier::visitZExtInst", NM="_ZN12_GLOBAL__N_18Verifier13visitZExtInstERN4llvm8ZExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitZExtInstERN4llvm8ZExtInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitZExtInst(final ZExtInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    // Get the size of the types in bits, we'll need this later
    do {
      if (!(SrcTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"ZExt only operates on integer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"ZExt only produces an integer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"zext source and destination must both be a vector or neither"), $AddrOf(I));
        return;
      }
    } while (false);
    /*uint*/int SrcBitSize = SrcTy.getScalarSizeInBits();
    /*uint*/int DestBitSize = DestTy.getScalarSizeInBits();
    do {
      if (!($less_uint(SrcBitSize, DestBitSize))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Type too small for ZExt"), $AddrOf(I));
        return;
      }
    } while (false);

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitSExtInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2260,
   FQN="(anonymous namespace)::Verifier::visitSExtInst", NM="_ZN12_GLOBAL__N_18Verifier13visitSExtInstERN4llvm8SExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitSExtInstERN4llvm8SExtInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitSExtInst(final SExtInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    // Get the size of the types in bits, we'll need this later
    /*uint*/int SrcBitSize = SrcTy.getScalarSizeInBits();
    /*uint*/int DestBitSize = DestTy.getScalarSizeInBits();
    do {
      if (!(SrcTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"SExt only operates on integer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"SExt only produces an integer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"sext source and destination must both be a vector or neither"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!($less_uint(SrcBitSize, DestBitSize))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Type too small for SExt"), $AddrOf(I));
        return;
      }
    } while (false);

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFPTruncInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2278,
   FQN="(anonymous namespace)::Verifier::visitFPTruncInst", NM="_ZN12_GLOBAL__N_18Verifier16visitFPTruncInstERN4llvm11FPTruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitFPTruncInstERN4llvm11FPTruncInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFPTruncInst(final FPTruncInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();
    // Get the size of the types in bits, we'll need this later
    /*uint*/int SrcBitSize = SrcTy.getScalarSizeInBits();
    /*uint*/int DestBitSize = DestTy.getScalarSizeInBits();
    do {
      if (!(SrcTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPTrunc only operates on FP"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPTrunc only produces an FP"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"fptrunc source and destination must both be a vector or neither"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!($greater_uint(SrcBitSize, DestBitSize))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"DestTy too big for FPTrunc"), $AddrOf(I));
        return;
      }
    } while (false);

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFPExtInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2295,
   FQN="(anonymous namespace)::Verifier::visitFPExtInst", NM="_ZN12_GLOBAL__N_18Verifier14visitFPExtInstERN4llvm9FPExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier14visitFPExtInstERN4llvm9FPExtInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFPExtInst(final FPExtInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    // Get the size of the types in bits, we'll need this later
    /*uint*/int SrcBitSize = SrcTy.getScalarSizeInBits();
    /*uint*/int DestBitSize = DestTy.getScalarSizeInBits();
    do {
      if (!(SrcTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPExt only operates on FP"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPExt only produces an FP"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"fpext source and destination must both be a vector or neither"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!($less_uint(SrcBitSize, DestBitSize))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"DestTy too small for FPExt"), $AddrOf(I));
        return;
      }
    } while (false);

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFPToUIInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2359,
   FQN="(anonymous namespace)::Verifier::visitFPToUIInst", NM="_ZN12_GLOBAL__N_18Verifier15visitFPToUIInstERN4llvm10FPToUIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitFPToUIInstERN4llvm10FPToUIInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFPToUIInst(final FPToUIInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    boolean SrcVec = SrcTy.isVectorTy();
    boolean DstVec = DestTy.isVectorTy();
    do {
      if (!(SrcVec == DstVec)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPToUI source and dest must both be vector or scalar"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPToUI source must be FP or FP vector"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPToUI result must be integer or integer vector"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcVec && DstVec) {
      do {
        if (!(cast_VectorType(SrcTy).getNumElements() == cast_VectorType(DestTy).getNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"FPToUI source and dest vector length mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFPToSIInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2382,
   FQN="(anonymous namespace)::Verifier::visitFPToSIInst", NM="_ZN12_GLOBAL__N_18Verifier15visitFPToSIInstERN4llvm10FPToSIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitFPToSIInstERN4llvm10FPToSIInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFPToSIInst(final FPToSIInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    boolean SrcVec = SrcTy.isVectorTy();
    boolean DstVec = DestTy.isVectorTy();
    do {
      if (!(SrcVec == DstVec)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPToSI source and dest must both be vector or scalar"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPToSI source must be FP or FP vector"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"FPToSI result must be integer or integer vector"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcVec && DstVec) {
      do {
        if (!(cast_VectorType(SrcTy).getNumElements() == cast_VectorType(DestTy).getNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"FPToSI source and dest vector length mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitUIToFPInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2313,
   FQN="(anonymous namespace)::Verifier::visitUIToFPInst", NM="_ZN12_GLOBAL__N_18Verifier15visitUIToFPInstERN4llvm10UIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitUIToFPInstERN4llvm10UIToFPInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitUIToFPInst(final UIToFPInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    boolean SrcVec = SrcTy.isVectorTy();
    boolean DstVec = DestTy.isVectorTy();
    do {
      if (!(SrcVec == DstVec)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"UIToFP source and dest must both be vector or scalar"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"UIToFP source must be integer or integer vector"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"UIToFP result must be FP or FP vector"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcVec && DstVec) {
      do {
        if (!(cast_VectorType(SrcTy).getNumElements() == cast_VectorType(DestTy).getNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"UIToFP source and dest vector length mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitSIToFPInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2336,
   FQN="(anonymous namespace)::Verifier::visitSIToFPInst", NM="_ZN12_GLOBAL__N_18Verifier15visitSIToFPInstERN4llvm10SIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitSIToFPInstERN4llvm10SIToFPInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitSIToFPInst(final SIToFPInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();

    boolean SrcVec = SrcTy.isVectorTy();
    boolean DstVec = DestTy.isVectorTy();
    do {
      if (!(SrcVec == DstVec)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"SIToFP source and dest must both be vector or scalar"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isIntOrIntVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"SIToFP source must be integer or integer vector"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"SIToFP result must be FP or FP vector"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcVec && DstVec) {
      do {
        if (!(cast_VectorType(SrcTy).getNumElements() == cast_VectorType(DestTy).getNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"SIToFP source and dest vector length mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitIntToPtrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2427,
   FQN="(anonymous namespace)::Verifier::visitIntToPtrInst", NM="_ZN12_GLOBAL__N_18Verifier17visitIntToPtrInstERN4llvm12IntToPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitIntToPtrInstERN4llvm12IntToPtrInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitIntToPtrInst(final IntToPtrInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();
    do {
      if (!(SrcTy.getScalarType().isIntegerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"IntToPtr source must be an integral"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.getScalarType().isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"IntToPtr result must be a pointer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"IntToPtr type mismatch"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcTy.isVectorTy()) {
      VectorType /*P*/ VSrc = dyn_cast_VectorType(SrcTy);
      VectorType /*P*/ VDest = dyn_cast_VectorType(DestTy);
      do {
        if (!(VSrc.getNumElements() == VDest.getNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"IntToPtr Vector width mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }
    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitPtrToIntInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2405,
   FQN="(anonymous namespace)::Verifier::visitPtrToIntInst", NM="_ZN12_GLOBAL__N_18Verifier17visitPtrToIntInstERN4llvm12PtrToIntInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitPtrToIntInstERN4llvm12PtrToIntInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitPtrToIntInst(final PtrToIntInst /*&*/ I) {
    // Get the source and destination types
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();
    do {
      if (!(SrcTy.getScalarType().isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"PtrToInt source must be pointer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.getScalarType().isIntegerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"PtrToInt result must be integral"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.isVectorTy() == DestTy.isVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"PtrToInt type mismatch"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcTy.isVectorTy()) {
      VectorType /*P*/ VSrc = dyn_cast_VectorType(SrcTy);
      VectorType /*P*/ VDest = dyn_cast_VectorType(DestTy);
      do {
        if (!(VSrc.getNumElements() == VDest.getNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"PtrToInt Vector width mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }

    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitBitCastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2447,
   FQN="(anonymous namespace)::Verifier::visitBitCastInst", NM="_ZN12_GLOBAL__N_18Verifier16visitBitCastInstERN4llvm11BitCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitBitCastInstERN4llvm11BitCastInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitBitCastInst(final BitCastInst /*&*/ I) {
    do {
      if (!(CastInst.castIsValid(Instruction.CastOps.BitCast, I.getOperand(0), I.getType()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid bitcast"), $AddrOf(I));
        return;
      }
    } while (false);
    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitAddrSpaceCastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2454,
   FQN="(anonymous namespace)::Verifier::visitAddrSpaceCastInst", NM="_ZN12_GLOBAL__N_18Verifier22visitAddrSpaceCastInstERN4llvm17AddrSpaceCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitAddrSpaceCastInstERN4llvm17AddrSpaceCastInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitAddrSpaceCastInst(final AddrSpaceCastInst /*&*/ I) {
    Type /*P*/ SrcTy = I.getOperand(0).getType();
    Type /*P*/ DestTy = I.getType();
    do {
      if (!(SrcTy.isPtrOrPtrVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"AddrSpaceCast source must be a pointer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(DestTy.isPtrOrPtrVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"AddrSpaceCast result must be a pointer"), $AddrOf(I));
        return;
      }
    } while (false);
    do {
      if (!(SrcTy.getPointerAddressSpace() != DestTy.getPointerAddressSpace())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"AddrSpaceCast must be between different address spaces"), $AddrOf(I));
        return;
      }
    } while (false);
    if (SrcTy.isVectorTy()) {
      do {
        if (!(SrcTy.getVectorNumElements() == DestTy.getVectorNumElements())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"AddrSpaceCast vector pointer number of elements mismatch"), $AddrOf(I));
          return;
        }
      } while (false);
    }
    visitInstruction(I);
  }


  /// visitPHINode - Ensure that a PHI node is well formed.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitPHINode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2472,
   FQN="(anonymous namespace)::Verifier::visitPHINode", NM="_ZN12_GLOBAL__N_18Verifier12visitPHINodeERN4llvm7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier12visitPHINodeERN4llvm7PHINodeE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitPHINode(final PHINode /*&*/ PN) {
    // Ensure that the PHI nodes are all grouped together at the top of the block.
    // This can be tested by checking whether the instruction before this is
    // either nonexistent (because this is begin()) or is a PHI node.  If not,
    // then there is some other instruction before a PHI.
    do {
      if (!($AddrOf(PN) == $AddrOf(PN.getParent().front()) || isa_PHINode(PN.$This$Ptr().$preDec()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"PHI nodes not grouped at top of basic block!"), $AddrOf(PN), PN.getParent());
        return;
      }
    } while (false);

    // Check that a PHI doesn't yield a Token.
    do {
      if (!(!PN.getType().isTokenTy())) {
        CheckFailed(new Twine(/*KEEP_STR*/"PHI nodes cannot have token type!"));
        return;
      }
    } while (false);

    // Check that all of the values of the PHI node have the same type as the
    // result, and that the incoming blocks are really basic blocks.
    for (Use U : PN.incoming_values()) {
      Value /*P*/ IncValue = U.$Value$P();
      do {
        if (!(PN.getType() == IncValue.getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"PHI node operands are not the same type as the result!"), $AddrOf(PN));
          return;
        }
      } while (false);
    }

    // All other PHI node constraints are checked in the visitBasicBlock method.
    visitInstruction(PN);
  }


  /// visitBinaryOperator - Check that both arguments to the binary operator are
  /// of the same type!
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2763,
   FQN="(anonymous namespace)::Verifier::visitBinaryOperator", NM="_ZN12_GLOBAL__N_18Verifier19visitBinaryOperatorERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitBinaryOperatorERN4llvm14BinaryOperatorE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitBinaryOperator(final BinaryOperator /*&*/ B) {
    do {
      if (!(B.getOperand(0).getType() == B.getOperand(1).getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Both operands to a binary operator are not of the same type!"), $AddrOf(B));
        return;
      }
    } while (false);
    switch (B.getOpcode()) {
     case Instruction.BinaryOps.Add:
     case Instruction.BinaryOps.Sub:
     case Instruction.BinaryOps.Mul:
     case Instruction.BinaryOps.SDiv:
     case Instruction.BinaryOps.UDiv:
     case Instruction.BinaryOps.SRem:
     case Instruction.BinaryOps.URem:
      // Check that integer arithmetic operators are only used with
      // integral operands.
      do {
        if (!(B.getType().isIntOrIntVectorTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Integer arithmetic operators only work with integral types!"), $AddrOf(B));
          return;
        }
      } while (false);
      do {
        if (!(B.getType() == B.getOperand(0).getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Integer arithmetic operators must have same type for operands and result!"), $AddrOf(B));
          return;
        }
      } while (false);
      break;
     case Instruction.BinaryOps.FAdd:
     case Instruction.BinaryOps.FSub:
     case Instruction.BinaryOps.FMul:
     case Instruction.BinaryOps.FDiv:
     case Instruction.BinaryOps.FRem:
      // Check that floating-point arithmetic operators are only used with
      // floating-point operands.
      do {
        if (!(B.getType().isFPOrFPVectorTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Floating-point arithmetic operators only work with floating-point types!"), $AddrOf(B));
          return;
        }
      } while (false);
      do {
        if (!(B.getType() == B.getOperand(0).getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Floating-point arithmetic operators must have same type for operands and result!"), $AddrOf(B));
          return;
        }
      } while (false);
      break;
     case Instruction.BinaryOps.And:
     case Instruction.BinaryOps.Or:
     case Instruction.BinaryOps.Xor:
      // Check that logical operators are only used with integral operands.
      do {
        if (!(B.getType().isIntOrIntVectorTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Logical operators only work with integral types!"), $AddrOf(B));
          return;
        }
      } while (false);
      do {
        if (!(B.getType() == B.getOperand(0).getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Logical operators must have same type for operands and result!"), $AddrOf(B));
          return;
        }
      } while (false);
      break;
     case Instruction.BinaryOps.Shl:
     case Instruction.BinaryOps.LShr:
     case Instruction.BinaryOps.AShr:
      do {
        if (!(B.getType().isIntOrIntVectorTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Shifts only work with integral types!"), $AddrOf(B));
          return;
        }
      } while (false);
      do {
        if (!(B.getType() == B.getOperand(0).getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Shift return type must be same as operands!"), $AddrOf(B));
          return;
        }
      } while (false);
      break;
     default:
      throw new llvm_unreachable("Unknown BinaryOperator opcode!");
    }
    
    visitInstruction(B);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitICmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2825,
   FQN="(anonymous namespace)::Verifier::visitICmpInst", NM="_ZN12_GLOBAL__N_18Verifier13visitICmpInstERN4llvm8ICmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitICmpInstERN4llvm8ICmpInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitICmpInst(final ICmpInst /*&*/ IC) {
    // Check that the operands are the same type
    Type /*P*/ Op0Ty = IC.getOperand(0).getType();
    Type /*P*/ Op1Ty = IC.getOperand(1).getType();
    do {
      if (!(Op0Ty == Op1Ty)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Both operands to ICmp instruction are not of the same type!"), $AddrOf(IC));
        return;
      }
    } while (false);
    // Check that the operands are the right type
    do {
      if (!(Op0Ty.isIntOrIntVectorTy() || Op0Ty.getScalarType().isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid operand types for ICmp instruction"), $AddrOf(IC));
        return;
      }
    } while (false);
    // Check that the predicate is valid.
    do {
      if (!(IC.getPredicate().getValue() >= CmpInst.Predicate.FIRST_ICMP_PREDICATE.getValue() && IC.getPredicate().getValue() <= CmpInst.Predicate.LAST_ICMP_PREDICATE.getValue())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid predicate in ICmp instruction!"), $AddrOf(IC));
        return;
      }
    } while (false);

    visitInstruction(IC);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFCmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2842,
   FQN="(anonymous namespace)::Verifier::visitFCmpInst", NM="_ZN12_GLOBAL__N_18Verifier13visitFCmpInstERN4llvm8FCmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitFCmpInstERN4llvm8FCmpInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFCmpInst(final FCmpInst /*&*/ FC) {
    // Check that the operands are the same type
    Type /*P*/ Op0Ty = FC.getOperand(0).getType();
    Type /*P*/ Op1Ty = FC.getOperand(1).getType();
    do {
      if (!(Op0Ty == Op1Ty)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Both operands to FCmp instruction are not of the same type!"), $AddrOf(FC));
        return;
      }
    } while (false);
    // Check that the operands are the right type
    do {
      if (!(Op0Ty.isFPOrFPVectorTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid operand types for FCmp instruction"), $AddrOf(FC));
        return;
      }
    } while (false);
    // Check that the predicate is valid.
    do {
      if (!(FC.getPredicate().getValue() >= CmpInst.Predicate.FIRST_FCMP_PREDICATE.getValue() && FC.getPredicate().getValue() <= CmpInst.Predicate.LAST_FCMP_PREDICATE.getValue())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid predicate in FCmp instruction!"), $AddrOf(FC));
        return;
      }
    } while (false);

    visitInstruction(FC);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitExtractElementInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2859,
   FQN="(anonymous namespace)::Verifier::visitExtractElementInst", NM="_ZN12_GLOBAL__N_18Verifier23visitExtractElementInstERN4llvm18ExtractElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier23visitExtractElementInstERN4llvm18ExtractElementInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitExtractElementInst(final ExtractElementInst /*&*/ EI) {
    do {
      if (!(ExtractElementInst.isValidOperands(EI.getOperand(0), EI.getOperand(1)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid extractelement operands!"), $AddrOf(EI));
        return;
      }
    } while (false);
    visitInstruction(EI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitInsertElementInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2866,
   FQN="(anonymous namespace)::Verifier::visitInsertElementInst", NM="_ZN12_GLOBAL__N_18Verifier22visitInsertElementInstERN4llvm17InsertElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitInsertElementInstERN4llvm17InsertElementInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitInsertElementInst(final InsertElementInst /*&*/ IE) {
    do {
      if (!(InsertElementInst.isValidOperands(IE.getOperand(0), IE.getOperand(1), IE.getOperand(2)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid insertelement operands!"), $AddrOf(IE));
        return;
      }
    } while (false);
    visitInstruction(IE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitShuffleVectorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2873,
   FQN="(anonymous namespace)::Verifier::visitShuffleVectorInst", NM="_ZN12_GLOBAL__N_18Verifier22visitShuffleVectorInstERN4llvm17ShuffleVectorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitShuffleVectorInstERN4llvm17ShuffleVectorInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitShuffleVectorInst(final ShuffleVectorInst /*&*/ SV) {
    do {
      if (!(ShuffleVectorInst.isValidOperands(SV.getOperand(0), SV.getOperand(1), SV.getOperand(2)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid shufflevector operands!"), $AddrOf(SV));
        return;
      }
    } while (false);
    visitInstruction(SV);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitVAArgInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 404,
   FQN="(anonymous namespace)::Verifier::visitVAArgInst", NM="_ZN12_GLOBAL__N_18Verifier14visitVAArgInstERN4llvm9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier14visitVAArgInstERN4llvm9VAArgInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitVAArgInst(final VAArgInst /*&*/ VAA) {
    visitInstruction(VAA);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitCallInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2740,
   FQN="(anonymous namespace)::Verifier::visitCallInst", NM="_ZN12_GLOBAL__N_18Verifier13visitCallInstERN4llvm8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitCallInstERN4llvm8CallInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitCallInst(final CallInst /*&*/ CI) {
    verifyCallSite(new CallSite($AddrOf(CI)));
    if (CI.isMustTailCall()) {
      verifyMustTailCall(CI);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitInvokeInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2747,
   FQN="(anonymous namespace)::Verifier::visitInvokeInst", NM="_ZN12_GLOBAL__N_18Verifier15visitInvokeInstERN4llvm10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitInvokeInstERN4llvm10InvokeInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitInvokeInst(final InvokeInst /*&*/ II) {
    verifyCallSite(new CallSite($AddrOf(II)));

    // Verify that the first non-PHI instruction of the unwind destination is an
    // exception handling instruction.
    do {
      if (!(II.getUnwindDest().isEHPad())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"The unwind destination does not have an exception handling instruction!"), $AddrOf(II));
        return;
      }
    } while (false);

    visitTerminatorInst(II);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitGetElementPtrInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2880,
   FQN="(anonymous namespace)::Verifier::visitGetElementPtrInst", NM="_ZN12_GLOBAL__N_18Verifier22visitGetElementPtrInstERN4llvm17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitGetElementPtrInstERN4llvm17GetElementPtrInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitGetElementPtrInst(final GetElementPtrInst /*&*/ GEP) {
    Type /*P*/ TargetTy = GEP.getPointerOperandType().getScalarType();
    do {
      if (!(isa_PointerType(TargetTy))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"GEP base pointer is not a vector or a vector of pointers"), $AddrOf(GEP));
        return;
      }
    } while (false);
    do {
      if (!(GEP.getSourceElementType().isSized())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"GEP into unsized type!"), $AddrOf(GEP));
        return;
      }
    } while (false);
    SmallVector<Value /*P*/ > Idxs/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 16, GEP.idx_begin(), GEP.idx_end(), (Value /*P*/ )null, (Use U) -> U.$Value$P());
    Type /*P*/ ElTy = GetElementPtrInst.getIndexedType_Type$P_ArrayRef$Value$P(GEP.getSourceElementType(), new ArrayRef<Value /*P*/ >(Idxs, true));
    do {
      if (!((ElTy) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid indices for GEP pointer type!"), $AddrOf(GEP));
        return;
      }
    } while (false);
    do {
      if (!(GEP.getType().getScalarType().isPointerTy() && GEP.getResultElementType() == ElTy)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"GEP is not of right type for indices!"), $AddrOf(GEP), ElTy);
        return;
      }
    } while (false);
    if (GEP.getType().isVectorTy()) {
      // Additional checks for vector GEPs.
      /*uint*/int GEPWidth = GEP.getType().getVectorNumElements();
      if (GEP.getPointerOperandType().isVectorTy()) {
        do {
          if (!(GEPWidth == GEP.getPointerOperandType().getVectorNumElements())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Vector GEP result width doesn't match operand's"), $AddrOf(GEP));
            return;
          }
        } while (false);
      }
      for (Value /*P*/ Idx : Idxs) {
        Type /*P*/ IndexTy = Idx.getType();
        if (IndexTy.isVectorTy()) {
          /*uint*/int IndexWidth = IndexTy.getVectorNumElements();
          do {
            if (!(IndexWidth == GEPWidth)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid GEP index vector width"), $AddrOf(GEP));
              return;
            }
          } while (false);
        }
        do {
          if (!(IndexTy.getScalarType().isIntegerTy())) {
            CheckFailed(new Twine(/*KEEP_STR*/"All GEP indices should be of integer type"));
            return;
          }
        } while (false);
      }
    }
    visitInstruction(GEP);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitLoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2976,
   FQN="(anonymous namespace)::Verifier::visitLoadInst", NM="_ZN12_GLOBAL__N_18Verifier13visitLoadInstERN4llvm8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier13visitLoadInstERN4llvm8LoadInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitLoadInst(final LoadInst /*&*/ LI) {
    PointerType /*P*/ PTy = dyn_cast_PointerType(LI.getOperand(0).getType());
    do {
      if (!((PTy) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Load operand must be a pointer."), $AddrOf(LI));
        return;
      }
    } while (false);
    Type /*P*/ ElTy = LI.getType();
    do {
      if (!($lesseq_uint(LI.getAlignment(), Value.MaximumAlignment))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"huge alignment values are unsupported"), $AddrOf(LI));
        return;
      }
    } while (false);
    do {
      if (!(ElTy.isSized())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"loading unsized types is not allowed"), $AddrOf(LI));
        return;
      }
    } while (false);
    if (LI.isAtomic()) {
      do {
        if (!(LI.getOrdering() != AtomicOrdering.Release && LI.getOrdering() != AtomicOrdering.AcquireRelease)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Load cannot have Release ordering"), $AddrOf(LI));
          return;
        }
      } while (false);
      do {
        if (!(LI.getAlignment() != 0)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Atomic load must specify explicit alignment"), $AddrOf(LI));
          return;
        }
      } while (false);
      do {
        if (!(ElTy.isIntegerTy() || ElTy.isPointerTy() || ElTy.isFloatingPointTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"atomic load operand must have integer, pointer, or floating point type!"), ElTy, $AddrOf(LI));
          return;
        }
      } while (false);
      checkAtomicMemAccessSize(M, ElTy, $AddrOf(LI));
    } else {
      do {
        if (!(LI.getSynchScope() == SynchronizationScope.CrossThread)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Non-atomic load cannot have SynchronizationScope specified"), $AddrOf(LI));
          return;
        }
      } while (false);
    }

    visitInstruction(LI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitStoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3003,
   FQN="(anonymous namespace)::Verifier::visitStoreInst", NM="_ZN12_GLOBAL__N_18Verifier14visitStoreInstERN4llvm9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier14visitStoreInstERN4llvm9StoreInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitStoreInst(final StoreInst /*&*/ SI) {
    PointerType /*P*/ PTy = dyn_cast_PointerType(SI.getOperand(1).getType());
    do {
      if (!((PTy) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Store operand must be a pointer."), $AddrOf(SI));
        return;
      }
    } while (false);
    Type /*P*/ ElTy = PTy.getElementType();
    do {
      if (!(ElTy == SI.getOperand(0).getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Stored value type does not match pointer operand type!"), $AddrOf(SI), ElTy);
        return;
      }
    } while (false);
    do {
      if (!($lesseq_uint(SI.getAlignment(), Value.MaximumAlignment))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"huge alignment values are unsupported"), $AddrOf(SI));
        return;
      }
    } while (false);
    do {
      if (!(ElTy.isSized())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"storing unsized types is not allowed"), $AddrOf(SI));
        return;
      }
    } while (false);
    if (SI.isAtomic()) {
      do {
        if (!(SI.getOrdering() != AtomicOrdering.Acquire && SI.getOrdering() != AtomicOrdering.AcquireRelease)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Store cannot have Acquire ordering"), $AddrOf(SI));
          return;
        }
      } while (false);
      do {
        if (!(SI.getAlignment() != 0)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Atomic store must specify explicit alignment"), $AddrOf(SI));
          return;
        }
      } while (false);
      do {
        if (!(ElTy.isIntegerTy() || ElTy.isPointerTy() || ElTy.isFloatingPointTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"atomic store operand must have integer, pointer, or floating point type!"), ElTy, $AddrOf(SI));
          return;
        }
      } while (false);
      checkAtomicMemAccessSize(M, ElTy, $AddrOf(SI));
    } else {
      do {
        if (!(SI.getSynchScope() == SynchronizationScope.CrossThread)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Non-atomic store cannot have SynchronizationScope specified"), $AddrOf(SI));
          return;
        }
      } while (false);
    }
    visitInstruction(SI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyDominatesUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3557,
   FQN="(anonymous namespace)::Verifier::verifyDominatesUse", NM="_ZN12_GLOBAL__N_18Verifier18verifyDominatesUseERN4llvm11InstructionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18verifyDominatesUseERN4llvm11InstructionEj")
  //</editor-fold>
  private void verifyDominatesUse(final Instruction /*&*/ I, /*uint*/int i) {
    Instruction /*P*/ Op = cast_Instruction(I.getOperand(i));
    {
      // If the we have an invalid invoke, don't try to compute the dominance.
      // We already reject it in the invoke specific checks and the dominance
      // computation doesn't handle multiple edges.
      InvokeInst /*P*/ II = dyn_cast_InvokeInst(Op);
      if ((II != null)) {
        if (II.getNormalDest() == II.getUnwindDest()) {
          return;
        }
      }
    }

    // Quick check whether the def has already been encountered in the same block.
    // PHI nodes are not checked to prevent accepting preceeding PHIs, because PHI
    // uses are defined to happen on the incoming edge, not at the instruction.
    //
    // FIXME: If this operand is a MetadataAsValue (wrapping a LocalAsMetadata)
    // wrapping an SSA value, assert that we've already encountered it.  See
    // related FIXME in Mapper::mapLocalAsMetadata in ValueMapper.cpp.
    if (!isa_PHINode(I) && (InstsInThisBlock.count(Op) != 0)) {
      return;
    }

    final /*const*/ Use /*&*/ U = I.getOperandUse(i);
    do {
      if (!(DT.dominates(Op, U))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction does not dominate all uses!"), Op, $AddrOf(I));
        return;
      }
    } while (false);
  }


  /// verifyInstruction - Verify that an instruction is well formed.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitInstruction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3597,
   FQN="(anonymous namespace)::Verifier::visitInstruction", NM="_ZN12_GLOBAL__N_18Verifier16visitInstructionERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16visitInstructionERN4llvm11InstructionE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitInstruction(final Instruction /*&*/ I) {
    BasicBlock /*P*/ BB = I.getParent();
    do {
      if (!((BB) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction not embedded in basic block!"), $AddrOf(I));
        return;
      }
    } while (false);
    if (!isa_PHINode(I)) { // Check that non-phi nodes are not self referential
      for (User /*P*/ U : I.users()) {
        do {
          if (!(U != (User /*P*/ )$AddrOf(I) || !DT.isReachableFromEntry(BB))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Only PHI nodes may reference their own value!"), $AddrOf(I));
            return;
          }
        } while (false);
      }
    }

    // Check that void typed values don't have names
    do {
      if (!(!I.getType().isVoidTy() || !I.hasName())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction has a name, but provides a void value!"), $AddrOf(I));
        return;
      }
    } while (false);

    // Check that the return value of the instruction is either void or a legal
    // value type.
    do {
      if (!(I.getType().isVoidTy() || I.getType().isFirstClassType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction returns a non-scalar type!"), $AddrOf(I));
        return;
      }
    } while (false);

    // Check that the instruction doesn't produce metadata. Calls are already
    // checked against the callee type.
    do {
      if (!(!I.getType().isMetadataTy() || isa_CallInst(I) || isa_InvokeInst(I))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid use of metadata!"), $AddrOf(I));
        return;
      }
    } while (false);

    // Check that all uses of the instruction, if they are instructions
    // themselves, actually have parent basic blocks.  If the use is not an
    // instruction, it is an error!
    for (final Use /*&*/ U : I.uses()) {
      {
        Instruction /*P*/ Used = dyn_cast_Instruction(U.getUser());
        if ((Used != null)) {
          do {
            if (!(Used.getParent() != null)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction referencing instruction not embedded in a basic block!"), $AddrOf(I), Used);
              return;
            }
          } while (false);
        } else {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Use of instruction is not an instruction!"), U);
          return;
        }
      }
    }

    for (/*uint*/int i = 0, e = I.getNumOperands$User(); i != e; ++i) {
      do {
        if (!(I.getOperand(i) != null)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction has null operand!"), $AddrOf(I));
          return;
        }
      } while (false);

      // Check to make sure that only first-class-values are operands to
      // instructions.
      if (!I.getOperand(i).getType().isFirstClassType()) {
        do {
          if (!false) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Instruction operands must be first-class values!"), $AddrOf(I));
            return;
          }
        } while (false);
      }
      {

        Function /*P*/ F = dyn_cast_Function(I.getOperand(i));
        if ((F != null)) {
          // Check to make sure that the "address of" an intrinsic function is never
          // taken.
          do {
            if (!(!F.isIntrinsic() || i == (isa_CallInst(I) ? e - 1 : isa_InvokeInst(I) ? e - 3 : 0))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot take the address of an intrinsic!"), $AddrOf(I));
              return;
            }
          } while (false);
          do {
            if (!(!F.isIntrinsic() || isa_CallInst(I) || F.getIntrinsicID() == ID.donothing || F.getIntrinsicID() == ID.experimental_patchpoint_void || F.getIntrinsicID() == ID.experimental_patchpoint_i64 || F.getIntrinsicID() == ID.experimental_gc_statepoint)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot invoke an intrinsic other than donothing, patchpoint or statepoint"), $AddrOf(I));
              return;
            }
          } while (false);
          do {
            if (!(F.getParent() == M)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Referencing function in another module!"), $AddrOf(I), M, F, F.getParent());
              return;
            }
          } while (false);
        } else {
          BasicBlock /*P*/ OpBB = dyn_cast_BasicBlock(I.getOperand(i));
          if ((OpBB != null)) {
            do {
              if (!(OpBB.getParent() == BB.getParent())) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Referring to a basic block in another function!"), $AddrOf(I));
                return;
              }
            } while (false);
          } else {
            Argument /*P*/ OpArg = dyn_cast_Argument(I.getOperand(i));
            if ((OpArg != null)) {
              do {
                if (!(OpArg.getParent() == BB.getParent())) {
                  CheckFailed$T(new Twine(/*KEEP_STR*/"Referring to an argument in another function!"), $AddrOf(I));
                  return;
                }
              } while (false);
            } else {
              GlobalValue /*P*/ GV = dyn_cast_GlobalValue(I.getOperand(i));
              if ((GV != null)) {
                do {
                  if (!(GV.getParent() == M)) {
                    CheckFailed$T(new Twine(/*KEEP_STR*/"Referencing global in another module!"), $AddrOf(I), M, GV, GV.getParent());
                    return;
                  }
                } while (false);
              } else if (isa_Instruction(I.getOperand(i))) {
                verifyDominatesUse(I, i);
              } else if (isa_InlineAsm(I.getOperand(i))) {
                do {
                  if (!((i + 1 == e && isa_CallInst(I)) || (i + 3 == e && isa_InvokeInst(I)))) {
                    CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot take the address of an inline asm!"), $AddrOf(I));
                    return;
                  }
                } while (false);
              } else {
                ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(I.getOperand(i));
                if ((CE != null)) {
                  if (CE.getType().isPtrOrPtrVectorTy()) {
                    // If we have a ConstantExpr pointer, we need to see if it came from an
                    // illegal bitcast (inttoptr <constant int> )
                    visitConstantExprsRecursively(CE);
                  }
                }
              }
            }
          }
        }
      }
    }
    {

      MDNode /*P*/ MD = I.getMetadata(LLVMContext.Unnamed_enum.MD_fpmath.getValue());
      if ((MD != null)) {
        do {
          if (!(I.getType().isFPOrFPVectorTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"fpmath requires a floating point result!"), $AddrOf(I));
            return;
          }
        } while (false);
        do {
          if (!(MD.getNumOperands() == 1)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"fpmath takes one operand!"), $AddrOf(I));
            return;
          }
        } while (false);
        {
          ConstantFP /*P*/ CFP0 = MdconstGlobals.<ConstantFP, /*const*/ MDOperand /*&*/ >dyn_extract_or_null$ValidPointer(ConstantFP.class, MD.getOperand(0));
          if ((CFP0 != null)) {
            final /*const*/ APFloat /*&*/ Accuracy = CFP0.getValueAPF();
            do {
              if (!($AddrOf(Accuracy.getSemantics()) == $AddrOf(APFloat.IEEEsingle))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"fpmath accuracy must have float type"), $AddrOf(I));
                return;
              }
            } while (false);
            do {
              if (!(Accuracy.isFiniteNonZero() && !Accuracy.isNegative())) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"fpmath accuracy not a positive number!"), $AddrOf(I));
                return;
              }
            } while (false);
          } else {
            do {
              if (!(false)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"invalid fpmath accuracy!"), $AddrOf(I));
                return;
              }
            } while (false);
          }
        }
      }
    }
    {

      MDNode /*P*/ Range = I.getMetadata(LLVMContext.Unnamed_enum.MD_range.getValue());
      if ((Range != null)) {
        do {
          if (!(isa_LoadInst(I) || isa_CallInst(I) || isa_InvokeInst(I))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Ranges are only for loads, calls and invokes!"), $AddrOf(I));
            return;
          }
        } while (false);
        visitRangeMetadata(I, Range, I.getType());
      }
    }
    if ((I.getMetadata(LLVMContext.Unnamed_enum.MD_nonnull.getValue()) != null)) {
      do {
        if (!(I.getType().isPointerTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"nonnull applies only to pointer types"), $AddrOf(I));
          return;
        }
      } while (false);
      do {
        if (!(isa_LoadInst(I))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"nonnull applies only to load instructions, use attributes for calls or invokes"), $AddrOf(I));
          return;
        }
      } while (false);
    }
    {

      MDNode /*P*/ MD = I.getMetadata(LLVMContext.Unnamed_enum.MD_dereferenceable.getValue());
      if ((MD != null)) {
        visitDereferenceableMetadata(I, MD);
      }
    }
    {

      MDNode /*P*/ MD = I.getMetadata(LLVMContext.Unnamed_enum.MD_dereferenceable_or_null.getValue());
      if ((MD != null)) {
        visitDereferenceableMetadata(I, MD);
      }
    }
    {

      MDNode /*P*/ AlignMD = I.getMetadata(LLVMContext.Unnamed_enum.MD_align.getValue());
      if ((AlignMD != null)) {
        do {
          if (!(I.getType().isPointerTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"align applies only to pointer types"), $AddrOf(I));
            return;
          }
        } while (false);
        do {
          if (!(isa_LoadInst(I))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"align applies only to load instructions, use attributes for calls or invokes"), $AddrOf(I));
            return;
          }
        } while (false);
        do {
          if (!(AlignMD.getNumOperands() == 1)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"align takes one operand!"), $AddrOf(I));
            return;
          }
        } while (false);
        ConstantInt /*P*/ CI = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, AlignMD.getOperand(0));
        do {
          if (!((CI != null) && CI.getType().isIntegerTy(64))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"align metadata value must be an i64!"), $AddrOf(I));
            return;
          }
        } while (false);
        long/*uint64_t*/ Align = CI.getZExtValue();
        do {
          if (!(isPowerOf2_64(Align))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"align metadata value must be a power of 2!"), $AddrOf(I));
            return;
          }
        } while (false);
        do {
          if (!($lesseq_ulong_uint(Align, Value.MaximumAlignment))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"alignment is larger that implementation defined limit"), $AddrOf(I));
            return;
          }
        } while (false);
      }
    }
    {

      MDNode /*P*/ N = I.getDebugLoc().getAsMDNode();
      if ((N != null)) {
        do {
          if (!(isa_DILocation(N))) {
            DebugInfoCheckFailed$T(new Twine(/*KEEP_STR*/"invalid !dbg metadata attachment"), $AddrOf(I), N);
            return;
          }
        } while (false);
        visitMDNode($Deref(N));
      }
    }
    {

      DbgInfoIntrinsic /*P*/ DII = dyn_cast_DbgInfoIntrinsic($AddrOf(I));
      if ((DII != null)) {
        verifyBitPieceExpression($Deref(DII));
      }
    }

    InstsInThisBlock.insert($AddrOf(I));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitTerminatorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2148,
   FQN="(anonymous namespace)::Verifier::visitTerminatorInst", NM="_ZN12_GLOBAL__N_18Verifier19visitTerminatorInstERN4llvm14TerminatorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitTerminatorInstERN4llvm14TerminatorInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitTerminatorInst(final TerminatorInst /*&*/ I) {
    // Ensure that terminators only exist at the end of the basic block.
    do {
      if (!($AddrOf(I) == I.getParent().getTerminator())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Terminator found in the middle of a basic block!"), I.getParent());
        return;
      }
    } while (false);
    visitInstruction(I);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitBranchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2155,
   FQN="(anonymous namespace)::Verifier::visitBranchInst", NM="_ZN12_GLOBAL__N_18Verifier15visitBranchInstERN4llvm10BranchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitBranchInstERN4llvm10BranchInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitBranchInst(final BranchInst /*&*/ BI) {
    if (BI.isConditional()) {
      do {
        if (!(BI.getCondition().getType().isIntegerTy(1))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Branch condition is not 'i1' type!"), $AddrOf(BI), BI.getCondition());
          return;
        }
      } while (false);
    }
    visitTerminatorInst(BI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2163,
   FQN="(anonymous namespace)::Verifier::visitReturnInst", NM="_ZN12_GLOBAL__N_18Verifier15visitReturnInstERN4llvm10ReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitReturnInstERN4llvm10ReturnInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitReturnInst(final ReturnInst /*&*/ RI) {
    Function /*P*/ F = RI.getParent().getParent();
    /*uint*/int N = RI.getNumOperands();
    if (F.getReturnType().isVoidTy()) {
      do {
        if (!(N == 0)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Found return instr that returns non-void in Function of void return type!"), $AddrOf(RI), F.getReturnType());
          return;
        }
      } while (false);
    } else {
      do {
        if (!(N == 1 && F.getReturnType() == RI.getOperand(0).getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Function return type does not match operand type of return inst!"), $AddrOf(RI), F.getReturnType());
          return;
        }
      } while (false);
    }

    // Check to make sure that the return value has necessary properties for
    // terminators...
    visitTerminatorInst(RI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2182,
   FQN="(anonymous namespace)::Verifier::visitSwitchInst", NM="_ZN12_GLOBAL__N_18Verifier15visitSwitchInstERN4llvm10SwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitSwitchInstERN4llvm10SwitchInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitSwitchInst(final SwitchInst /*&*/ SI) {
    // Check to make sure that all of the constants in the switch instruction
    // have the same type as the switched-on value.
    Type /*P*/ SwitchTy = SI.getCondition().getType();
    SmallPtrSet<ConstantInt /*P*/ > Constants/*J*/= new SmallPtrSet<ConstantInt /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    for (final SwitchInst.CaseIteratorT<SwitchInst, ConstantInt, BasicBlock> /*&*/ Case : SI.cases()) {
      do {
        if (!(Case.getCaseValue().getType() == SwitchTy)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Switch constants must all be same type as switch value!"), $AddrOf(SI));
          return;
        }
      } while (false);
      do {
        if (!(Constants.insert(Case.getCaseValue()).second)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Duplicate integer as switch case"), $AddrOf(SI), Case.getCaseValue());
          return;
        }
      } while (false);
    }

    visitTerminatorInst(SI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitIndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2197,
   FQN="(anonymous namespace)::Verifier::visitIndirectBrInst", NM="_ZN12_GLOBAL__N_18Verifier19visitIndirectBrInstERN4llvm14IndirectBrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitIndirectBrInstERN4llvm14IndirectBrInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitIndirectBrInst(final IndirectBrInst /*&*/ BI) {
    do {
      if (!(BI.getAddress().getType().isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Indirectbr operand must have pointer type!"), $AddrOf(BI));
        return;
      }
    } while (false);
    for (/*uint*/int i = 0, e = BI.getNumDestinations(); i != e; ++i)  {
      do {
        if (!(BI.getDestination(i).getType().isLabelTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Indirectbr destinations must all have pointer type!"), $AddrOf(BI));
          return;
        }
      } while (false);
    }

    visitTerminatorInst(BI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitSelectInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2207,
   FQN="(anonymous namespace)::Verifier::visitSelectInst", NM="_ZN12_GLOBAL__N_18Verifier15visitSelectInstERN4llvm10SelectInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitSelectInstERN4llvm10SelectInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitSelectInst(final SelectInst /*&*/ SI) {
    do {
      if (!(!Native.$bool(SelectInst.areInvalidOperands(SI.getOperand(0), SI.getOperand(1), SI.getOperand(2))))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid operands for select instruction!"), $AddrOf(SI));
        return;
      }
    } while (false);
    do {
      if (!(SI.getTrueValue().getType() == SI.getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Select values must have same type as select instruction!"), $AddrOf(SI));
        return;
      }
    } while (false);
    visitInstruction(SI);
  }


  /// visitUserOp1 - User defined operators shouldn't live beyond the lifetime of
  /// a pass, if any exist, it's an error.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitUserOp1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2220,
   FQN="(anonymous namespace)::Verifier::visitUserOp1", NM="_ZN12_GLOBAL__N_18Verifier12visitUserOp1ERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier12visitUserOp1ERN4llvm11InstructionE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitUserOp1(final Instruction /*&*/ I) {
    do {
      if (!false) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"User-defined operators should not live outside of a pass!"), $AddrOf(I));
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitUserOp2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 419,
   FQN="(anonymous namespace)::Verifier::visitUserOp2", NM="_ZN12_GLOBAL__N_18Verifier12visitUserOp2ERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier12visitUserOp2ERN4llvm11InstructionE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitUserOp2(final Instruction /*&*/ I) {
    visitUserOp1(I);
  }


  /// Allow intrinsics to be verified in different ways.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitIntrinsicCallSite">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3752,
   FQN="(anonymous namespace)::Verifier::visitIntrinsicCallSite", NM="_ZN12_GLOBAL__N_18Verifier22visitIntrinsicCallSiteEN4llvm9Intrinsic2IDENS1_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitIntrinsicCallSiteEN4llvm9Intrinsic2IDENS1_8CallSiteE")
  //</editor-fold>
  private void visitIntrinsicCallSite(/*Intrinsic.ID*/int _ID, CallSite CS) {
    Function /*P*/ IF = CS.getCalledFunction();
    do {
      if (!(IF.isDeclaration())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Intrinsic functions should never be defined!"), IF);
        return;
      }
    } while (false);

    // Verify that the intrinsic prototype lines up with what the .td files
    // describe.
    FunctionType /*P*/ IFTy = IF.getFunctionType();
    boolean IsVarArg = IFTy.isVarArg();

    SmallVector<IITDescriptor> Table/*J*/= new SmallVector<IITDescriptor>(8, new IITDescriptor());
    IntrinsicGlobals.getIntrinsicInfoTableEntries(_ID, Table);
    ArrayRef<IITDescriptor> TableRef = new ArrayRef<IITDescriptor>(Table, false);

    SmallVector<Type /*P*/ > ArgTys/*J*/= new SmallVector<Type /*P*/ >(4, (Type /*P*/ )null);
    do {
      if (!(!IntrinsicGlobals.matchIntrinsicType(IFTy.getReturnType(), TableRef, ArgTys))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Intrinsic has incorrect return type!"), IF);
        return;
      }
    } while (false);
    for (/*uint*/int i = 0, e = IFTy.getNumParams(); i != e; ++i)  {
      do {
        if (!(!IntrinsicGlobals.matchIntrinsicType(IFTy.getParamType(i), TableRef, ArgTys))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Intrinsic has incorrect argument type!"), IF);
          return;
        }
      } while (false);
    }

    // Verify if the intrinsic call matches the vararg property.
    if (IsVarArg) {
      do {
        if (!(!IntrinsicGlobals.matchIntrinsicVarArg(IsVarArg, TableRef))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Intrinsic was not defined with variable arguments!"), IF);
          return;
        }
      } while (false);
    } else {
      do {
        if (!(!IntrinsicGlobals.matchIntrinsicVarArg(IsVarArg, TableRef))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Callsite was not defined with variable arguments!"), IF);
          return;
        }
      } while (false);
    }

    // All descriptors should be absorbed by now.
    do {
      if (!(TableRef.empty())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Intrinsic has too few arguments!"), IF);
        return;
      }
    } while (false);

    // Now that we have the intrinsic ID and the actual argument types (and we
    // know they are legal for the intrinsic!) get the intrinsic name through the
    // usual means.  This allows us to verify the mangling of argument types into
    // the name.
    /*const*/std.string ExpectedName = IntrinsicGlobals.getName(_ID, new ArrayRef<Type /*P*/ >(ArgTys, true));
    do {
      if (!($eq_StringRef(new StringRef(ExpectedName), IF.getName()))) {
        CheckFailed$T(new Twine($add_T$C$P_string$C(/*KEEP_STR*/"Intrinsic name not mangled correctly for type arguments! Should be: ", ExpectedName)), IF);
        return;
      }
    } while (false);

    // If the intrinsic takes MDNode arguments, verify that they are either global
    // or are local to *this* function.
    for (Use U : CS.args())  {
      {
        Value /*P*/ V = U.$Value$P();
        MetadataAsValue /*P*/ MD = dyn_cast_MetadataAsValue(V);
        if ((MD != null)) {
          visitMetadataAsValue($Deref(MD), CS.getCaller());
        }
      }
    }
    switch (_ID) {
     default:
      break;
     case ID.ctlz: // llvm.ctlz
     case ID.cttz: // llvm.cttz
      do {
        if (!(isa_ConstantInt(CS.getArgOperand(1)))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"is_zero_undef argument of bit counting intrinsics must be a constant int"), CS);
          return;
        }
      } while (false);
      break;
     case ID.dbg_declare: // llvm.dbg.declare
      do {
        if (!(isa_MetadataAsValue(CS.getArgOperand(0)))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"invalid llvm.dbg.declare intrinsic call 1"), CS);
          return;
        }
      } while (false);
      visitDbgIntrinsic(new StringRef(/*KEEP_STR*/"declare"), cast_DbgDeclareInst($Deref(CS.getInstruction())));
      break;
     case ID.dbg_value: // llvm.dbg.value
      visitDbgIntrinsic(new StringRef(/*KEEP_STR*/"value"), cast_DbgValueInst($Deref(CS.getInstruction())));
      break;
     case ID.memcpy:
     case ID.memmove:
     case ID.memset:
      {
        ConstantInt /*P*/ AlignCI = dyn_cast_ConstantInt(CS.getArgOperand(3));
        do {
          if (!((AlignCI) != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"alignment argument of memory intrinsics must be a constant int"), CS);
            return;
          }
        } while (false);
        final /*const*/ APInt /*&*/ AlignVal = AlignCI.getValue();
        do {
          if (!(AlignCI.isZero() || AlignVal.isPowerOf2())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"alignment argument of memory intrinsics must be a power of 2"), CS);
            return;
          }
        } while (false);
        do {
          if (!(isa_ConstantInt(CS.getArgOperand(4)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"isvolatile argument of memory intrinsics must be a constant int"), CS);
            return;
          }
        } while (false);
        break;
      }
     case ID.gcroot:
     case ID.gcwrite:
     case ID.gcread:
      if (_ID == ID.gcroot) {
        AllocaInst /*P*/ AI = dyn_cast_AllocaInst(CS.getArgOperand(0).stripPointerCasts());
        do {
          if (!((AI) != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.gcroot parameter #1 must be an alloca."), CS);
            return;
          }
        } while (false);
        do {
          if (!(isa_Constant(CS.getArgOperand(1)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.gcroot parameter #2 must be a constant."), CS);
            return;
          }
        } while (false);
        if (!AI.getAllocatedType().isPointerTy()) {
          do {
            if (!(!isa_ConstantPointerNull(CS.getArgOperand(1)))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.gcroot parameter #1 must either be a pointer alloca, or argument #2 must be a non-null constant."), CS);
              return;
            }
          } while (false);
        }
      }
      do {
        if (!(CS.getParent().getParent().hasGC())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Enclosing function does not use GC."), CS);
          return;
        }
      } while (false);
      break;
     case ID.init_trampoline:
      do {
        if (!(isa_Function(CS.getArgOperand(1).stripPointerCasts()))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.init_trampoline parameter #2 must resolve to a function."), CS);
          return;
        }
      } while (false);
      break;
     case ID.prefetch:
      do {
        if (!(isa_ConstantInt(CS.getArgOperand(1)) && isa_ConstantInt(CS.getArgOperand(2)) && $less_ulong_ullong(cast_ConstantInt(CS.getArgOperand(1)).getZExtValue(), $int2ullong(2)) && $less_ulong_ullong(cast_ConstantInt(CS.getArgOperand(2)).getZExtValue(), $int2ullong(4)))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"invalid arguments to llvm.prefetch"), CS);
          return;
        }
      } while (false);
      break;
     case ID.stackprotector:
      do {
        if (!(isa_AllocaInst(CS.getArgOperand(1).stripPointerCasts()))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.stackprotector parameter #2 must resolve to an alloca."), CS);
          return;
        }
      } while (false);
      break;
     case ID.lifetime_start:
     case ID.lifetime_end:
     case ID.invariant_start:
      do {
        if (!(isa_ConstantInt(CS.getArgOperand(0)))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"size argument of memory use markers must be a constant integer"), CS);
          return;
        }
      } while (false);
      break;
     case ID.invariant_end:
      do {
        if (!(isa_ConstantInt(CS.getArgOperand(1)))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.invariant.end parameter #2 must be a constant integer"), CS);
          return;
        }
      } while (false);
      break;
     case ID.localescape:
      {
        BasicBlock /*P*/ BB = CS.getParent();
        do {
          if (!(BB == $AddrOf(BB.getParent().front()))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.localescape used outside of entry block"), CS);
            return;
          }
        } while (false);
        do {
          if (!(!SawFrameEscape)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"multiple calls to llvm.localescape in one function"), CS);
            return;
          }
        } while (false);
        for (Use U : CS.args()) {
          Value /*P*/ Arg = U.$Value$P();
          if (isa_ConstantPointerNull(Arg)) {
            continue; // Null values are allowed as placeholders.
          }
          AllocaInst /*P*/ AI = dyn_cast_AllocaInst(Arg.stripPointerCasts());
          do {
            if (!((AI != null) && AI.isStaticAlloca())) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.localescape only accepts static allocas"), CS);
              return;
            }
          } while (false);
        }
        FrameEscapeInfo.$at_T1$RR(BB.getParent()).first = CS.getNumArgOperands();
        SawFrameEscape = true;
        break;
      }
     case ID.localrecover:
      {
        Value /*P*/ FnArg = CS.getArgOperand(0).stripPointerCasts();
        Function /*P*/ Fn = dyn_cast_Function(FnArg);
        do {
          if (!((Fn != null) && !Fn.isDeclaration())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"llvm.localrecover first argument must be function defined in this module"), CS);
            return;
          }
        } while (false);
        ConstantInt /*P*/ IdxArg = dyn_cast_ConstantInt(CS.getArgOperand(2));
        do {
          if (!((IdxArg) != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"idx argument of llvm.localrecover must be a constant int"), CS);
            return;
          }
        } while (false);
        final std.pairUIntUInt/*&*/ Entry = FrameEscapeInfo.$at_T1$C$R(Fn);
        Entry.second = ((/*uint*/int)($ullong2uint(std.max(((long/*uint64_t*/)($uint2ulong(Entry.second))), IdxArg.getLimitedValue($uint2ulong(~0/*U*/)) + $int2ullong(1)))));
        break;
      }
     case ID.experimental_gc_statepoint:
      do {
        if (!(!CS.isInlineAsm())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint support for inline assembly unimplemented"), CS);
          return;
        }
      } while (false);
      do {
        if (!(CS.getParent().getParent().hasGC())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Enclosing function does not use GC."), CS);
          return;
        }
      } while (false);

      verifyStatepoint(new ImmutableCallSite(new CallSite(CS)));
      break;
     case ID.experimental_gc_result:
      {
        do {
          if (!(CS.getParent().getParent().hasGC())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Enclosing function does not use GC."), CS);
            return;
          }
        } while (false);
        // Are we tied to a statepoint properly?
        CallSite StatepointCS/*J*/= new CallSite(CS.getArgOperand(0));
        /*const*/ Function /*P*/ StatepointFn = (StatepointCS.getInstruction() != null) ? StatepointCS.getCalledFunction() : null;
        do {
          if (!((StatepointFn != null) && StatepointFn.isDeclaration() && StatepointFn.getIntrinsicID() == ID.experimental_gc_statepoint)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.result operand #1 must be from a statepoint"), CS, CS.getArgOperand(0));
            return;
          }
        } while (false);

        // Assert that result type matches wrapped callee.
        /*const*/ Value /*P*/ Target = StatepointCS.getArgument(2);
        PointerType /*P*/ PT = cast_PointerType(Target.getType());
        FunctionType /*P*/ TargetFuncType = cast_FunctionType(PT.getElementType());
        do {
          if (!(CS.getType() == TargetFuncType.getReturnType())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.result result type does not match wrapped callee"), CS);
            return;
          }
        } while (false);
        break;
      }
     case ID.experimental_gc_relocate:
      {
        do {
          if (!(CS.getNumArgOperands() == 3)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"wrong number of arguments"), CS);
            return;
          }
        } while (false);
        do {
          if (!(isa_PointerType(CS.getType().getScalarType()))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate must return a pointer or a vector of pointers"), CS);
            return;
          }
        } while (false);
        {

          // Check that this relocate is correctly tied to the statepoint

          // This is case for relocate on the unwinding path of an invoke statepoint
          LandingPadInst /*P*/ LandingPad = dyn_cast_LandingPadInst(CS.getArgOperand(0));
          if ((LandingPad != null)) {

            /*const*/ BasicBlock /*P*/ InvokeBB = LandingPad.getParent().getUniquePredecessor();

            // Landingpad relocates should have only one predecessor with invoke
            // statepoint terminator
            do {
              if (!((InvokeBB) != null)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"safepoints should have unique landingpads"), LandingPad.getParent());
                return;
              }
            } while (false);
            do {
              if (!((InvokeBB.getTerminator$Const()) != null)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"safepoint block should be well formed"), InvokeBB);
                return;
              }
            } while (false);
            do {
              if (!(IrLlvmGlobals.isStatepoint_Value$C$P(InvokeBB.getTerminator$Const()))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"gc relocate should be linked to a statepoint"), InvokeBB);
                return;
              }
            } while (false);
          } else {
            // In all other cases relocate should be tied to the statepoint directly.
            // This covers relocates on a normal return path of invoke statepoint and
            // relocates of a call statepoint.
            Value /*P*/ Token = CS.getArgOperand(0);
            do {
              if (!(isa_Instruction(Token) && IrLlvmGlobals.isStatepoint_Value$C$P(cast_Instruction(Token)))) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"gc relocate is incorrectly tied to the statepoint"), CS, Token);
                return;
              }
            } while (false);
          }
        }

        // Verify rest of the relocate arguments.
        ImmutableCallSite StatepointCS/*J*/= new ImmutableCallSite(cast_GCRelocateInst($Deref(CS.getInstruction())).getStatepoint());

        // Both the base and derived must be piped through the safepoint.
        Value /*P*/ Base = CS.getArgOperand(1);
        do {
          if (!(isa_ConstantInt(Base))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate operand #2 must be integer offset"), CS);
            return;
          }
        } while (false);

        Value /*P*/ Derived = CS.getArgOperand(2);
        do {
          if (!(isa_ConstantInt(Derived))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate operand #3 must be integer offset"), CS);
            return;
          }
        } while (false);

        /*const*/int BaseIndex = $ulong2int(cast_ConstantInt(Base).getZExtValue());
        /*const*/int DerivedIndex = $ulong2int(cast_ConstantInt(Derived).getZExtValue());
        // Check the bounds
        do {
          if (!(0 <= BaseIndex && BaseIndex < (int)StatepointCS.arg_size())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: statepoint base index out of bounds"), CS);
            return;
          }
        } while (false);
        do {
          if (!(0 <= DerivedIndex && DerivedIndex < (int)StatepointCS.arg_size())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: statepoint derived index out of bounds"), CS);
            return;
          }
        } while (false);

        // Check that BaseIndex and DerivedIndex fall within the 'gc parameters'
        // section of the statepoint's argument.
        do {
          if (!($greater_uint(StatepointCS.arg_size(), 0))) {
            CheckFailed(new Twine(/*KEEP_STR*/"gc.statepoint: insufficient arguments"));
            return;
          }
        } while (false);
        do {
          if (!(isa_ConstantInt(StatepointCS.getArgument(3)))) {
            CheckFailed(new Twine(/*KEEP_STR*/"gc.statement: number of call arguments must be constant integer"));
            return;
          }
        } while (false);
        /*const*//*uint*/int NumCallArgs = $ulong2uint(cast_ConstantInt(StatepointCS.getArgument(3)).getZExtValue());
        do {
          if (!($greater_uint(StatepointCS.arg_size(), NumCallArgs + 5))) {
            CheckFailed(new Twine(/*KEEP_STR*/"gc.statepoint: mismatch in number of call arguments"));
            return;
          }
        } while (false);
        do {
          if (!(isa_ConstantInt(StatepointCS.getArgument(NumCallArgs + 5)))) {
            CheckFailed(new Twine(/*KEEP_STR*/"gc.statepoint: number of transition arguments must be a constant integer"));
            return;
          }
        } while (false);
        /*const*/int NumTransitionArgs = $ulong2int(cast_ConstantInt(StatepointCS.getArgument(NumCallArgs + 5)).
            getZExtValue());
        /*const*/int DeoptArgsStart = 4 + NumCallArgs + 1 + NumTransitionArgs + 1;
        do {
          if (!(isa_ConstantInt(StatepointCS.getArgument(DeoptArgsStart)))) {
            CheckFailed(new Twine(/*KEEP_STR*/"gc.statepoint: number of deoptimization arguments must be a constant integer"));
            return;
          }
        } while (false);
        /*const*/int NumDeoptArgs = $ulong2int(cast_ConstantInt(StatepointCS.getArgument(DeoptArgsStart)).
            getZExtValue());
        /*const*/int GCParamArgsStart = DeoptArgsStart + 1 + NumDeoptArgs;
        /*const*/int GCParamArgsEnd = StatepointCS.arg_size();
        do {
          if (!(GCParamArgsStart <= BaseIndex && BaseIndex < GCParamArgsEnd)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: statepoint base index doesn't fall within the 'gc parameters' section of the statepoint call"), CS);
            return;
          }
        } while (false);
        do {
          if (!(GCParamArgsStart <= DerivedIndex && DerivedIndex < GCParamArgsEnd)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: statepoint derived index doesn't fall within the 'gc parameters' section of the statepoint call"), CS);
            return;
          }
        } while (false);

        // Relocated value must be either a pointer type or vector-of-pointer type,
        // but gc_relocate does not need to return the same pointer type as the
        // relocated pointer. It can be casted to the correct type later if it's
        // desired. However, they must have the same address space and 'vectorness'
        final GCRelocateInst /*&*/ Relocate = cast_GCRelocateInst($Deref(CS.getInstruction()));
        do {
          if (!(Relocate.getDerivedPtr().getType().getScalarType().isPointerTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: relocated value must be a gc pointer"), CS);
            return;
          }
        } while (false);

        Type /*P*/ ResultType = CS.getType();
        Type /*P*/ DerivedType = Relocate.getDerivedPtr().getType();
        do {
          if (!(ResultType.isVectorTy() == DerivedType.isVectorTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: vector relocates to vector and pointer to pointer"), CS);
            return;
          }
        } while (false);
        do {
          if (!(ResultType.getPointerAddressSpace() == DerivedType.getPointerAddressSpace())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate: relocating a pointer shouldn't change its address space"), CS);
            return;
          }
        } while (false);
        break;
      }
     case ID.eh_exceptioncode:
     case ID.eh_exceptionpointer:
      {
        do {
          if (!(isa_CatchPadInst(CS.getArgOperand(0)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"eh.exceptionpointer argument must be a catchpad"), CS);
            return;
          }
        } while (false);
        break;
      }
     case ID.masked_load:
      {
        do {
          if (!(CS.getType().isVectorTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_load: must return a vector"), CS);
            return;
          }
        } while (false);

        Value /*P*/ Ptr = CS.getArgOperand(0);
        //Value *Alignment = CS.getArgOperand(1);
        Value /*P*/ Mask = CS.getArgOperand(2);
        Value /*P*/ PassThru = CS.getArgOperand(3);
        do {
          if (!(Mask.getType().isVectorTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_load: mask must be vector"), CS);
            return;
          }
        } while (false);

        // DataTy is the overloaded type
        Type /*P*/ DataTy = cast_PointerType(Ptr.getType()).getElementType();
        do {
          if (!(DataTy == CS.getType())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_load: return must match pointer type"), CS);
            return;
          }
        } while (false);
        do {
          if (!(PassThru.getType() == DataTy)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_load: pass through and data type must match"), CS);
            return;
          }
        } while (false);
        do {
          if (!(Mask.getType().getVectorNumElements() == DataTy.getVectorNumElements())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_load: vector mask must be same length as data"), CS);
            return;
          }
        } while (false);
        break;
      }
     case ID.masked_store:
      {
        Value /*P*/ Val = CS.getArgOperand(0);
        Value /*P*/ Ptr = CS.getArgOperand(1);
        //Value *Alignment = CS.getArgOperand(2);
        Value /*P*/ Mask = CS.getArgOperand(3);
        do {
          if (!(Mask.getType().isVectorTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_store: mask must be vector"), CS);
            return;
          }
        } while (false);

        // DataTy is the overloaded type
        Type /*P*/ DataTy = cast_PointerType(Ptr.getType()).getElementType();
        do {
          if (!(DataTy == Val.getType())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_store: storee must match pointer type"), CS);
            return;
          }
        } while (false);
        do {
          if (!(Mask.getType().getVectorNumElements() == DataTy.getVectorNumElements())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"masked_store: vector mask must be same length as data"), CS);
            return;
          }
        } while (false);
        break;
      }
     case ID.experimental_guard:
      {
        do {
          if (!(CS.isCall())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"experimental_guard cannot be invoked"), CS);
            return;
          }
        } while (false);
        do {
          if (!(CS.countOperandBundlesOfType(LLVMContext.Unnamed_enum1.OB_deopt.getValue()) == 1)) {
            CheckFailed(new Twine(/*KEEP_STR*/"experimental_guard must have exactly one \"deopt\" operand bundle"));
            return;
          }
        } while (false);
        break;
      }
     case ID.experimental_deoptimize:
      {
        do {
          if (!(CS.isCall())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"experimental_deoptimize cannot be invoked"), CS);
            return;
          }
        } while (false);
        do {
          if (!(CS.countOperandBundlesOfType(LLVMContext.Unnamed_enum1.OB_deopt.getValue()) == 1)) {
            CheckFailed(new Twine(/*KEEP_STR*/"experimental_deoptimize must have exactly one \"deopt\" operand bundle"));
            return;
          }
        } while (false);
        do {
          if (!(CS.getType() == CS.getInstruction().getFunction().getReturnType())) {
            CheckFailed(new Twine(/*KEEP_STR*/"experimental_deoptimize return type must match caller return type"));
            return;
          }
        } while (false);
        if (CS.isCall()) {
          Instruction /*P*/ DeoptCI = CS.getInstruction();
          ReturnInst /*P*/ RI = dyn_cast_ReturnInst(DeoptCI.getNextNode());
          do {
            if (!((RI) != null)) {
              CheckFailed(new Twine(/*KEEP_STR*/"calls to experimental_deoptimize must be followed by a return"));
              return;
            }
          } while (false);
          if (!CS.getType().isVoidTy() && (RI != null)) {
            do {
              if (!(RI.getReturnValue() == DeoptCI)) {
                CheckFailed(new Twine(/*KEEP_STR*/"calls to experimental_deoptimize must be followed by a return of the value computed by experimental_deoptimize"));
                return;
              }
            } while (false);
          }
        }

        break;
      }
    }
    /*JSKIP;*/
  }

  /*template <class DbgIntrinsicTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitDbgIntrinsic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4153,
   FQN="(anonymous namespace)::Verifier::visitDbgIntrinsic", NM="Tpl__ZN12_GLOBAL__N_18Verifier17visitDbgIntrinsicEN4llvm9StringRefERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_18Verifier17visitDbgIntrinsicEN4llvm9StringRefERT_")
  //</editor-fold>
  private </*class*/  DbgIntrinsicTy extends DbgInfoIntrinsic & IVariableAndExprOwner> void visitDbgIntrinsic(StringRef Kind, final DbgIntrinsicTy /*&*/ DII) {
    Metadata /*P*/ MD = cast_MetadataAsValue(DII.getArgOperand(0)).getMetadata();
    do {
      if (Native.$not((Native.$bool(isa_ValueAsMetadata(MD)) || Native.$bool((Native.$bool(isa_MDNode(MD)) && Native.$not(cast_MDNode(MD).getNumOperands())))))) {
        DebugInfoCheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"invalid llvm.dbg.", Kind), new Twine(/*KEEP_STR*/" intrinsic address/value")), $AddrOf(DII), MD);
        return;
      }
    } while (false);
    do {
      if (Native.$not((isa_DILocalVariable(DII.getRawVariable())))) {
        DebugInfoCheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"invalid llvm.dbg.", Kind), new Twine(/*KEEP_STR*/" intrinsic variable")), $AddrOf(DII), DII.getRawVariable());
        return;
      }
    } while (false);
    do {
      if (Native.$not((isa_DIExpression(DII.getRawExpression())))) {
        DebugInfoCheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"invalid llvm.dbg.", Kind), new Twine(/*KEEP_STR*/" intrinsic expression")), $AddrOf(DII), DII.getRawExpression());
        return;
      }
    } while (false);
    {

      // Ignore broken !dbg attachments; they're checked elsewhere.
      MDNode /*P*/ N = DII.getDebugLoc().getAsMDNode();
      if ((N != null)) {
        if (!isa_DILocation(N)) {
          return;
        }
      }
    }

    BasicBlock /*P*/ BB = DII.getParent();
    Function /*P*/ F = (BB != null) ? BB.getParent() : null;

    // The scopes for variables and !dbg attachments must agree.
    DILocalVariable /*P*/ Var = DII.getVariable();
    DILocation /*P*/ Loc = DII.getDebugLoc().$DILocation$P();
    do {
      if (!((Loc) != null)) {
        CheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"llvm.dbg.", Kind), new Twine(/*KEEP_STR*/" intrinsic requires a !dbg attachment")), $AddrOf(DII), BB, F);
        return;
      }
    } while (false);

    DISubprogram /*P*/ VarSP = VerifierStatics.getSubprogram(Var.getRawScope());
    DISubprogram /*P*/ LocSP = VerifierStatics.getSubprogram(Loc.getRawScope());
    if (!(VarSP != null) || !(LocSP != null)) {
      return; // Broken scope chains are checked elsewhere.
    }
    do {
      if (!(VarSP == LocSP)) {
        CheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"mismatched subprogram between llvm.dbg.", Kind), new Twine(/*KEEP_STR*/" variable and !dbg attachment")), $AddrOf(DII), BB, F, Var, Var.getScope().getSubprogram(), Loc, Loc.getScope().getSubprogram());
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitAtomicCmpXchgInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3087,
   FQN="(anonymous namespace)::Verifier::visitAtomicCmpXchgInst", NM="_ZN12_GLOBAL__N_18Verifier22visitAtomicCmpXchgInstERN4llvm17AtomicCmpXchgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitAtomicCmpXchgInstERN4llvm17AtomicCmpXchgInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitAtomicCmpXchgInst(final AtomicCmpXchgInst /*&*/ CXI) {

    // FIXME: more conditions???
    do {
      if (!(CXI.getSuccessOrdering() != AtomicOrdering.NotAtomic)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg instructions must be atomic."), $AddrOf(CXI));
        return;
      }
    } while (false);
    do {
      if (!(CXI.getFailureOrdering() != AtomicOrdering.NotAtomic)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg instructions must be atomic."), $AddrOf(CXI));
        return;
      }
    } while (false);
    do {
      if (!(CXI.getSuccessOrdering() != AtomicOrdering.Unordered)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg instructions cannot be unordered."), $AddrOf(CXI));
        return;
      }
    } while (false);
    do {
      if (!(CXI.getFailureOrdering() != AtomicOrdering.Unordered)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg instructions cannot be unordered."), $AddrOf(CXI));
        return;
      }
    } while (false);
    do {
      if (!(!isStrongerThan(CXI.getFailureOrdering(), CXI.getSuccessOrdering()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg instructions failure argument shall be no stronger than the success argument"), $AddrOf(CXI));
        return;
      }
    } while (false);
    do {
      if (!(CXI.getFailureOrdering() != AtomicOrdering.Release && CXI.getFailureOrdering() != AtomicOrdering.AcquireRelease)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg failure ordering cannot include release semantics"), $AddrOf(CXI));
        return;
      }
    } while (false);

    PointerType /*P*/ PTy = dyn_cast_PointerType(CXI.getOperand(0).getType());
    do {
      if (!((PTy) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"First cmpxchg operand must be a pointer."), $AddrOf(CXI));
        return;
      }
    } while (false);
    Type /*P*/ ElTy = PTy.getElementType();
    do {
      if (!(ElTy.isIntegerTy() || ElTy.isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cmpxchg operand must have integer or pointer type"), ElTy, $AddrOf(CXI));
        return;
      }
    } while (false);
    checkAtomicMemAccessSize(M, ElTy, $AddrOf(CXI));
    do {
      if (!(ElTy == CXI.getOperand(1).getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Expected value type does not match pointer operand type!"), $AddrOf(CXI), ElTy);
        return;
      }
    } while (false);
    do {
      if (!(ElTy == CXI.getOperand(2).getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Stored value type does not match pointer operand type!"), $AddrOf(CXI), ElTy);
        return;
      }
    } while (false);
    visitInstruction(CXI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitAtomicRMWInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3121,
   FQN="(anonymous namespace)::Verifier::visitAtomicRMWInst", NM="_ZN12_GLOBAL__N_18Verifier18visitAtomicRMWInstERN4llvm13AtomicRMWInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18visitAtomicRMWInstERN4llvm13AtomicRMWInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitAtomicRMWInst(final AtomicRMWInst /*&*/ RMWI) {
    do {
      if (!(RMWI.getOrdering() != AtomicOrdering.NotAtomic)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"atomicrmw instructions must be atomic."), $AddrOf(RMWI));
        return;
      }
    } while (false);
    do {
      if (!(RMWI.getOrdering() != AtomicOrdering.Unordered)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"atomicrmw instructions cannot be unordered."), $AddrOf(RMWI));
        return;
      }
    } while (false);
    PointerType /*P*/ PTy = dyn_cast_PointerType(RMWI.getOperand(0).getType());
    do {
      if (!((PTy) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"First atomicrmw operand must be a pointer."), $AddrOf(RMWI));
        return;
      }
    } while (false);
    Type /*P*/ ElTy = PTy.getElementType();
    do {
      if (!(ElTy.isIntegerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"atomicrmw operand must have integer type!"), $AddrOf(RMWI), ElTy);
        return;
      }
    } while (false);
    checkAtomicMemAccessSize(M, ElTy, $AddrOf(RMWI));
    do {
      if (!(ElTy == RMWI.getOperand(1).getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Argument value type does not match pointer operand type!"), $AddrOf(RMWI), ElTy);
        return;
      }
    } while (false);
    do {
      if (!(AtomicRMWInst.BinOp.FIRST_BINOP.getValue() <= RMWI.getOperation().getValue() && RMWI.getOperation().getValue() <= AtomicRMWInst.BinOp.LAST_BINOP.getValue())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid binary operation!"), $AddrOf(RMWI));
        return;
      }
    } while (false);
    visitInstruction(RMWI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFenceInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3141,
   FQN="(anonymous namespace)::Verifier::visitFenceInst", NM="_ZN12_GLOBAL__N_18Verifier14visitFenceInstERN4llvm9FenceInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier14visitFenceInstERN4llvm9FenceInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFenceInst(final FenceInst /*&*/ FI) {
    /*const*/ AtomicOrdering Ordering = FI.getOrdering();
    do {
      if (!(Ordering == AtomicOrdering.Acquire || Ordering == AtomicOrdering.Release || Ordering == AtomicOrdering.AcquireRelease || Ordering == AtomicOrdering.SequentiallyConsistent)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"fence instructions may only have acquire, release, acq_rel, or seq_cst ordering."), $AddrOf(FI));
        return;
      }
    } while (false);
    visitInstruction(FI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitAllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3067,
   FQN="(anonymous namespace)::Verifier::visitAllocaInst", NM="_ZN12_GLOBAL__N_18Verifier15visitAllocaInstERN4llvm10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier15visitAllocaInstERN4llvm10AllocaInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitAllocaInst(final AllocaInst /*&*/ AI) {
    SmallPtrSet<Type /*P*/ > Visited/*J*/= new SmallPtrSet<Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    PointerType /*P*/ PTy = AI.getType();
    do {
      if (!(PTy.getAddressSpace() == 0)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Allocation instruction pointer not in the generic address space!"), $AddrOf(AI));
        return;
      }
    } while (false);
    do {
      if (!(AI.getAllocatedType().isSized($AddrOf(Visited)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot allocate unsized type"), $AddrOf(AI));
        return;
      }
    } while (false);
    do {
      if (!(AI.getArraySize().getType().isIntegerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Alloca array size must have integer type"), $AddrOf(AI));
        return;
      }
    } while (false);
    do {
      if (!($lesseq_uint(AI.getAlignment(), Value.MaximumAlignment))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"huge alignment values are unsupported"), $AddrOf(AI));
        return;
      }
    } while (false);
    if (AI.isSwiftError()) {
      verifySwiftErrorValue($AddrOf(AI));
    }

    visitInstruction(AI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3153,
   FQN="(anonymous namespace)::Verifier::visitExtractValueInst", NM="_ZN12_GLOBAL__N_18Verifier21visitExtractValueInstERN4llvm16ExtractValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier21visitExtractValueInstERN4llvm16ExtractValueInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitExtractValueInst(final ExtractValueInst /*&*/ EVI) {
    do {
      if (!(ExtractValueInst.getIndexedType(EVI.getAggregateOperand().getType(), EVI.getIndices()) == EVI.getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid ExtractValueInst operands!"), $AddrOf(EVI));
        return;
      }
    } while (false);

    visitInstruction(EVI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitInsertValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3161,
   FQN="(anonymous namespace)::Verifier::visitInsertValueInst", NM="_ZN12_GLOBAL__N_18Verifier20visitInsertValueInstERN4llvm15InsertValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitInsertValueInstERN4llvm15InsertValueInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitInsertValueInst(final InsertValueInst /*&*/ IVI) {
    do {
      if (!(ExtractValueInst.getIndexedType(IVI.getAggregateOperand().getType(), IVI.getIndices()) == IVI.getOperand(1).getType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid InsertValueInst operands!"), $AddrOf(IVI));
        return;
      }
    } while (false);

    visitInstruction(IVI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitEHPadPredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3177,
   FQN="(anonymous namespace)::Verifier::visitEHPadPredecessors", NM="_ZN12_GLOBAL__N_18Verifier22visitEHPadPredecessorsERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitEHPadPredecessorsERN4llvm11InstructionE")
  //</editor-fold>
  private void visitEHPadPredecessors(final Instruction /*&*/ I) {
    assert (I.isEHPad());

    BasicBlock /*P*/ BB = I.getParent();
    Function /*P*/ F = BB.getParent();
    do {
      if (!(BB != $AddrOf(F.getEntryBlock()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"EH pad cannot be in entry block."), $AddrOf(I));
        return;
      }
    } while (false);
    {

      LandingPadInst /*P*/ LPI = dyn_cast_LandingPadInst($AddrOf(I));
      if ((LPI != null)) {
        // The landingpad instruction defines its parent as a landing pad block. The
        // landing pad block may be branched to only by the unwind edge of an
        // invoke.
        for (BasicBlock /*P*/ PredBB : IrLlvmGlobals.predecessors_BasicBlock$P(BB)) {
          /*const*/ InvokeInst /*P*/ II = dyn_cast_InvokeInst(PredBB.getTerminator());
          do {
            if (!((II != null) && II.getUnwindDest() == BB && II.getNormalDest() != BB)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Block containing LandingPadInst must be jumped to only by the unwind edge of an invoke."), LPI);
              return;
            }
          } while (false);
        }
        return;
      }
    }
    {
      CatchPadInst /*P*/ CPI = dyn_cast_CatchPadInst($AddrOf(I));
      if ((CPI != null)) {
        if (!IrLlvmGlobals.pred_empty(BB)) {
          do {
            if (!(BB.getUniquePredecessor() == CPI.getCatchSwitch().getParent())) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Block containg CatchPadInst must be jumped to only by its catchswitch."), CPI);
              return;
            }
          } while (false);
        }
        do {
          if (!(BB != CPI.getCatchSwitch().getUnwindDest())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Catchswitch cannot unwind to one of its catchpads"), CPI.getCatchSwitch(), CPI);
            return;
          }
        } while (false);
        return;
      }
    }

    // Verify that each pred has a legal terminator with a legal to/from EH
    // pad relationship.
    Instruction /*P*/ ToPad = $AddrOf(I);
    Value /*P*/ ToPadParent = VerifierStatics.getParentPad(ToPad);
    for (BasicBlock /*P*/ PredBB : IrLlvmGlobals.predecessors_BasicBlock$P(BB)) {
      SmallSetT$PLess$T$P<Value /*P*/ > Seen = null;
      try {
        TerminatorInst /*P*/ TI = PredBB.getTerminator();
        Value /*P*/ FromPad;
        {
          InvokeInst /*P*/ II = dyn_cast_InvokeInst(TI);
          if ((II != null)) {
            do {
              if (!(II.getUnwindDest() == BB && II.getNormalDest() != BB)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"EH pad must be jumped to via an unwind edge"), ToPad, II);
                return;
              }
            } while (false);
            {
              Optional<OperandBundleUse> Bundle = II.getOperandBundle(LLVMContext.Unnamed_enum1.OB_funclet.getValue());
              if (Bundle.$bool()) {
                FromPad = Bundle.$arrow().Inputs.$at(0).$Value$P();
              } else {
                FromPad = ConstantTokenNone.get(II.getContext());
              }
            }
          } else {
            CleanupReturnInst /*P*/ CRI = dyn_cast_CleanupReturnInst(TI);
            if ((CRI != null)) {
              FromPad = CRI.getOperand(0);
              do {
                if (!(FromPad != ToPadParent)) {
                  CheckFailed$T(new Twine(/*KEEP_STR*/"A cleanupret must exit its cleanup"), CRI);
                  return;
                }
              } while (false);
            } else {
              CatchSwitchInst /*P*/ CSI = dyn_cast_CatchSwitchInst(TI);
              if ((CSI != null)) {
                FromPad = CSI;
              } else {
                do {
                  if (!(false)) {
                    CheckFailed$T(new Twine(/*KEEP_STR*/"EH pad must be jumped to via an unwind edge"), ToPad, TI);
                    return;
                  }
                } while (false);
              }
            }
          }
        }

        // The edge may exit from zero or more nested pads.
        Seen/*J*/= new SmallSetT$PLess$T$P<Value /*P*/ >(8);
        for (;; FromPad = VerifierStatics.getParentPad(FromPad)) {
          do {
            if (!(FromPad != ToPad)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"EH pad cannot handle exceptions raised within it"), FromPad, TI);
              return;
            }
          } while (false);
          if (FromPad == ToPadParent) {
            // This is a legal unwind edge.
            break;
          }
          do {
            if (!(!isa_ConstantTokenNone(FromPad))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"A single unwind edge may only enter one EH pad"), TI);
              return;
            }
          } while (false);
          do {
            if (!(Seen.insert(FromPad).second)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"EH pad jumps through a cycle of pads"), FromPad);
              return;
            }
          } while (false);
        }
      } finally {
        if (Seen != null) { Seen.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitLandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3250,
   FQN="(anonymous namespace)::Verifier::visitLandingPadInst", NM="_ZN12_GLOBAL__N_18Verifier19visitLandingPadInstERN4llvm14LandingPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitLandingPadInstERN4llvm14LandingPadInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitLandingPadInst(final LandingPadInst /*&*/ LPI) {
    // The landingpad instruction is ill-formed if it doesn't have any clauses and
    // isn't a cleanup.
    do {
      if (!($greater_uint(LPI.getNumClauses(), 0) || LPI.isCleanup())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"LandingPadInst needs at least one clause or to be a cleanup."), $AddrOf(LPI));
        return;
      }
    } while (false);

    visitEHPadPredecessors(LPI);
    if (!(LandingPadResultTy != null)) {
      LandingPadResultTy = LPI.getType();
    } else {
      do {
        if (!(LandingPadResultTy == LPI.getType())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"The landingpad instruction should have a consistent result type inside a function."), $AddrOf(LPI));
          return;
        }
      } while (false);
    }

    Function /*P*/ F = LPI.getParent().getParent();
    do {
      if (!(F.hasPersonalityFn())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"LandingPadInst needs to be in a function with a personality."), $AddrOf(LPI));
        return;
      }
    } while (false);

    // The landingpad instruction must be the first non-PHI instruction in the
    // block.
    do {
      if (!(LPI.getParent().getLandingPadInst() == $AddrOf(LPI))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"LandingPadInst not the first non-PHI instruction in the block."), $AddrOf(LPI));
        return;
      }
    } while (false);

    for (/*uint*/int i = 0, e = LPI.getNumClauses(); $less_uint(i, e); ++i) {
      Constant /*P*/ Clause = LPI.getClause(i);
      if (LPI.isCatch(i)) {
        do {
          if (!(isa_PointerType(Clause.getType()))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Catch operand does not have pointer type!"), $AddrOf(LPI));
            return;
          }
        } while (false);
      } else {
        do {
          if (!(LPI.isFilter(i))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Clause is neither catch nor filter!"), $AddrOf(LPI));
            return;
          }
        } while (false);
        do {
          if (!(isa_ConstantArray(Clause) || isa_ConstantAggregateZero(Clause))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Filter operand is not an array of constants!"), $AddrOf(LPI));
            return;
          }
        } while (false);
      }
    }

    visitInstruction(LPI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitCatchPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3291,
   FQN="(anonymous namespace)::Verifier::visitCatchPadInst", NM="_ZN12_GLOBAL__N_18Verifier17visitCatchPadInstERN4llvm12CatchPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitCatchPadInstERN4llvm12CatchPadInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitCatchPadInst(final CatchPadInst /*&*/ CPI) {
    BasicBlock /*P*/ BB = CPI.getParent();

    Function /*P*/ F = BB.getParent();
    do {
      if (!(F.hasPersonalityFn())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchPadInst needs to be in a function with a personality."), $AddrOf(CPI));
        return;
      }
    } while (false);
    do {
      if (!(isa_CatchSwitchInst(CPI.getParentPad()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchPadInst needs to be directly nested in a CatchSwitchInst."), CPI.getParentPad());
        return;
      }
    } while (false);

    // The catchpad instruction must be the first non-PHI instruction in the
    // block.
    do {
      if (!(BB.getFirstNonPHI() == $AddrOf(CPI))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchPadInst not the first non-PHI instruction in the block."), $AddrOf(CPI));
        return;
      }
    } while (false);

    visitEHPadPredecessors(CPI);
    visitFuncletPadInst(CPI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitCatchReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3311,
   FQN="(anonymous namespace)::Verifier::visitCatchReturnInst", NM="_ZN12_GLOBAL__N_18Verifier20visitCatchReturnInstERN4llvm15CatchReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitCatchReturnInstERN4llvm15CatchReturnInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitCatchReturnInst(final CatchReturnInst /*&*/ CatchReturn) {
    do {
      if (!(isa_CatchPadInst(CatchReturn.getOperand(0)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchReturnInst needs to be provided a CatchPad"), $AddrOf(CatchReturn), CatchReturn.getOperand(0));
        return;
      }
    } while (false);

    visitTerminatorInst(CatchReturn);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitCleanupPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3319,
   FQN="(anonymous namespace)::Verifier::visitCleanupPadInst", NM="_ZN12_GLOBAL__N_18Verifier19visitCleanupPadInstERN4llvm14CleanupPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitCleanupPadInstERN4llvm14CleanupPadInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitCleanupPadInst(final CleanupPadInst /*&*/ CPI) {
    BasicBlock /*P*/ BB = CPI.getParent();

    Function /*P*/ F = BB.getParent();
    do {
      if (!(F.hasPersonalityFn())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CleanupPadInst needs to be in a function with a personality."), $AddrOf(CPI));
        return;
      }
    } while (false);

    // The cleanuppad instruction must be the first non-PHI instruction in the
    // block.
    do {
      if (!(BB.getFirstNonPHI() == $AddrOf(CPI))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CleanupPadInst not the first non-PHI instruction in the block."), $AddrOf(CPI));
        return;
      }
    } while (false);

    Value /*P*/ ParentPad = CPI.getParentPad();
    do {
      if (!(isa_ConstantTokenNone(ParentPad) || isa_FuncletPadInst(ParentPad))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CleanupPadInst has an invalid parent."), $AddrOf(CPI));
        return;
      }
    } while (false);

    visitEHPadPredecessors(CPI);
    visitFuncletPadInst(CPI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitFuncletPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3340,
   FQN="(anonymous namespace)::Verifier::visitFuncletPadInst", NM="_ZN12_GLOBAL__N_18Verifier19visitFuncletPadInstERN4llvm14FuncletPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19visitFuncletPadInstERN4llvm14FuncletPadInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitFuncletPadInst(final FuncletPadInst /*&*/ FPI) {
    SmallSetT$PLess$T$P<FuncletPadInst /*P*/ > Seen = null;
    try {
      User /*P*/ FirstUser = null;
      Value /*P*/ FirstUnwindPad = null;
      SmallVector<FuncletPadInst /*P*/ > Worklist/*J*/= new SmallVector<FuncletPadInst /*P*/ >(8, new FuncletPadInst /*P*/ /*const*/ [/*1*/] {$AddrOf(FPI)}, (FuncletPadInst /*P*/ )null);
      Seen/*J*/= new SmallSetT$PLess$T$P<FuncletPadInst /*P*/ >(8);
      while (!Worklist.empty()) {
        FuncletPadInst /*P*/ CurrentPad = Worklist.pop_back_val();
        do {
          if (!(Seen.insert(CurrentPad).second)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"FuncletPadInst must not be nested within itself"), CurrentPad);
            return;
          }
        } while (false);
        Value /*P*/ UnresolvedAncestorPad = null;
        for (User /*P*/ U : CurrentPad.users()) {
          BasicBlock /*P*/ UnwindDest;
          {
            CleanupReturnInst /*P*/ CRI = dyn_cast_CleanupReturnInst(U);
            if ((CRI != null)) {
              UnwindDest = CRI.getUnwindDest();
            } else {
              CatchSwitchInst /*P*/ CSI = dyn_cast_CatchSwitchInst(U);
              if ((CSI != null)) {
                // We allow catchswitch unwind to caller to nest
                // within an outer pad that unwinds somewhere else,
                // because catchswitch doesn't have a nounwind variant.
                // See e.g. SimplifyCFGOpt::SimplifyUnreachable.
                if (CSI.unwindsToCaller()) {
                  continue;
                }
                UnwindDest = CSI.getUnwindDest();
              } else {
                InvokeInst /*P*/ II = dyn_cast_InvokeInst(U);
                if ((II != null)) {
                  UnwindDest = II.getUnwindDest();
                } else if (isa_CallInst(U)) {
                  // Calls which don't unwind may be found inside funclet
                  // pads that unwind somewhere else.  We don't *require*
                  // such calls to be annotated nounwind.
                  continue;
                } else {
                  CleanupPadInst /*P*/ CPI = dyn_cast_CleanupPadInst(U);
                  if ((CPI != null)) {
                    // The unwind dest for a cleanup can only be found by
                    // recursive search.  Add it to the worklist, and we'll
                    // search for its first use that determines where it unwinds.
                    Worklist.push_back(CPI);
                    continue;
                  } else {
                    do {
                      if (!(isa_CatchReturnInst(U))) {
                        CheckFailed$T(new Twine(/*KEEP_STR*/"Bogus funclet pad use"), U);
                        return;
                      }
                    } while (false);
                    continue;
                  }
                }
              }
            }
          }

          Value /*P*/ UnwindPad;
          boolean ExitsFPI;
          if ((UnwindDest != null)) {
            UnwindPad = UnwindDest.getFirstNonPHI();
            if (!cast_Instruction(UnwindPad).isEHPad()) {
              continue;
            }
            Value /*P*/ UnwindParent = VerifierStatics.getParentPad(UnwindPad);
            // Ignore unwind edges that don't exit CurrentPad.
            if (UnwindParent == CurrentPad) {
              continue;
            }
            // Determine whether the original funclet pad is exited,
            // and if we are scanning nested pads determine how many
            // of them are exited so we can stop searching their
            // children.
            Value /*P*/ ExitedPad = CurrentPad;
            ExitsFPI = false;
            do {
              if (ExitedPad == $AddrOf(FPI)) {
                ExitsFPI = true;
                // Now we can resolve any ancestors of CurrentPad up to
                // FPI, but not including FPI since we need to make sure
                // to check all direct users of FPI for consistency.
                UnresolvedAncestorPad = $AddrOf(FPI);
                break;
              }
              Value /*P*/ ExitedParent = VerifierStatics.getParentPad(ExitedPad);
              if (ExitedParent == UnwindParent) {
                // ExitedPad is the ancestor-most pad which this unwind
                // edge exits, so we can resolve up to it, meaning that
                // ExitedParent is the first ancestor still unresolved.
                UnresolvedAncestorPad = ExitedParent;
                break;
              }
              ExitedPad = ExitedParent;
            } while (!isa_ConstantTokenNone(ExitedPad));
          } else {
            // Unwinding to caller exits all pads.
            UnwindPad = ConstantTokenNone.get(FPI.getContext());
            ExitsFPI = true;
            UnresolvedAncestorPad = $AddrOf(FPI);
          }
          if (ExitsFPI) {
            // This unwind edge exits FPI.  Make sure it agrees with other
            // such edges.
            if ((FirstUser != null)) {
              do {
                if (!(UnwindPad == FirstUnwindPad)) {
                  CheckFailed$T(new Twine(/*KEEP_STR*/"Unwind edges out of a funclet pad must have the same unwind dest"), $AddrOf(FPI), U, FirstUser);
                  return;
                }
              } while (false);
            } else {
              FirstUser = U;
              FirstUnwindPad = UnwindPad;
              // Record cleanup sibling unwinds for verifySiblingFuncletUnwinds
              if (isa_CleanupPadInst($AddrOf(FPI)) && !isa_ConstantTokenNone(UnwindPad)
                 && VerifierStatics.getParentPad(UnwindPad) == VerifierStatics.getParentPad($AddrOf(FPI))) {
                SiblingFuncletInfo.$set($AddrOf(FPI), cast_TerminatorInst(U));
              }
            }
          }
          // Make sure we visit all uses of FPI, but for nested pads stop as
          // soon as we know where they unwind to.
          if (CurrentPad != $AddrOf(FPI)) {
            break;
          }
        }
        if ((UnresolvedAncestorPad != null)) {
          if (CurrentPad == UnresolvedAncestorPad) {
            // When CurrentPad is FPI itself, we don't mark it as resolved even if
            // we've found an unwind edge that exits it, because we need to verify
            // all direct uses of FPI.
            assert (CurrentPad == $AddrOf(FPI));
            continue;
          }
          // Pop off the worklist any nested pads that we've found an unwind
          // destination for.  The pads on the worklist are the uncles,
          // great-uncles, etc. of CurrentPad.  We've found an unwind destination
          // for all ancestors of CurrentPad up to but not including
          // UnresolvedAncestorPad.
          Value /*P*/ ResolvedPad = CurrentPad;
          while (!Worklist.empty()) {
            Value /*P*/ UnclePad = Worklist.back();
            Value /*P*/ AncestorPad = VerifierStatics.getParentPad(UnclePad);
            // Walk ResolvedPad up the ancestor list until we either find the
            // uncle's parent or the last resolved ancestor.
            while (ResolvedPad != AncestorPad) {
              Value /*P*/ ResolvedParent = VerifierStatics.getParentPad(ResolvedPad);
              if (ResolvedParent == UnresolvedAncestorPad) {
                break;
              }
              ResolvedPad = ResolvedParent;
            }
            // If the resolved ancestor search didn't find the uncle's parent,
            // then the uncle is not yet resolved.
            if (ResolvedPad != AncestorPad) {
              break;
            }
            // This uncle is resolved, so pop it from the worklist.
            Worklist.pop_back();
          }
        }
      }
      if ((FirstUnwindPad != null)) {
        {
          CatchSwitchInst /*P*/ CatchSwitch = dyn_cast_CatchSwitchInst(FPI.getParentPad());
          if ((CatchSwitch != null)) {
            BasicBlock /*P*/ SwitchUnwindDest = CatchSwitch.getUnwindDest();
            Value /*P*/ SwitchUnwindPad;
            if ((SwitchUnwindDest != null)) {
              SwitchUnwindPad = SwitchUnwindDest.getFirstNonPHI();
            } else {
              SwitchUnwindPad = ConstantTokenNone.get(FPI.getContext());
            }
            do {
              if (!(SwitchUnwindPad == FirstUnwindPad)) {
                CheckFailed$T(new Twine(/*KEEP_STR*/"Unwind edges out of a catch must have the same unwind dest as the parent catchswitch"), $AddrOf(FPI), FirstUser, CatchSwitch);
                return;
              }
            } while (false);
          }
        }
      }

      visitInstruction(FPI);
    } finally {
      if (Seen != null) { Seen.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitCatchSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3499,
   FQN="(anonymous namespace)::Verifier::visitCatchSwitchInst", NM="_ZN12_GLOBAL__N_18Verifier20visitCatchSwitchInstERN4llvm15CatchSwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20visitCatchSwitchInstERN4llvm15CatchSwitchInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitCatchSwitchInst(final CatchSwitchInst /*&*/ CatchSwitch) {
    BasicBlock /*P*/ BB = CatchSwitch.getParent();

    Function /*P*/ F = BB.getParent();
    do {
      if (!(F.hasPersonalityFn())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchSwitchInst needs to be in a function with a personality."), $AddrOf(CatchSwitch));
        return;
      }
    } while (false);

    // The catchswitch instruction must be the first non-PHI instruction in the
    // block.
    do {
      if (!(BB.getFirstNonPHI() == $AddrOf(CatchSwitch))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchSwitchInst not the first non-PHI instruction in the block."), $AddrOf(CatchSwitch));
        return;
      }
    } while (false);

    Value /*P*/ ParentPad = CatchSwitch.getParentPad();
    do {
      if (!(isa_ConstantTokenNone(ParentPad) || isa_FuncletPadInst(ParentPad))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchSwitchInst has an invalid parent."), ParentPad);
        return;
      }
    } while (false);
    {

      BasicBlock /*P*/ UnwindDest = CatchSwitch.getUnwindDest();
      if ((UnwindDest != null)) {
        Instruction /*P*/ I = UnwindDest.getFirstNonPHI();
        do {
          if (!(I.isEHPad() && !isa_LandingPadInst(I))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"CatchSwitchInst must unwind to an EH block which is not a landingpad."), $AddrOf(CatchSwitch));
            return;
          }
        } while (false);

        // Record catchswitch sibling unwinds for verifySiblingFuncletUnwinds
        if (VerifierStatics.getParentPad(I) == ParentPad) {
          SiblingFuncletInfo.$set($AddrOf(CatchSwitch), $AddrOf(CatchSwitch));
        }
      }
    }
    do {
      if (!(CatchSwitch.getNumHandlers() != 0)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CatchSwitchInst cannot have empty handler list"), $AddrOf(CatchSwitch));
        return;
      }
    } while (false);

    for (BasicBlock /*P*/ Handler : CatchSwitch.handlers()) {
      do {
        if (!(isa_CatchPadInst(Handler.getFirstNonPHI()))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"CatchSwitchInst handlers must be catchpads"), $AddrOf(CatchSwitch), Handler);
          return;
        }
      } while (false);
    }

    visitEHPadPredecessors(CatchSwitch);
    visitTerminatorInst(CatchSwitch);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitCleanupReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3541,
   FQN="(anonymous namespace)::Verifier::visitCleanupReturnInst", NM="_ZN12_GLOBAL__N_18Verifier22visitCleanupReturnInstERN4llvm17CleanupReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22visitCleanupReturnInstERN4llvm17CleanupReturnInstE")
  //</editor-fold>
  /*implements*/ public/*private*/ void visitCleanupReturnInst(final CleanupReturnInst /*&*/ CRI) {
    do {
      if (!(isa_CleanupPadInst(CRI.getOperand(0)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"CleanupReturnInst needs to be provided a CleanupPad"), $AddrOf(CRI), CRI.getOperand(0));
        return;
      }
    } while (false);
    {

      BasicBlock /*P*/ UnwindDest = CRI.getUnwindDest();
      if ((UnwindDest != null)) {
        Instruction /*P*/ I = UnwindDest.getFirstNonPHI();
        do {
          if (!(I.isEHPad() && !isa_LandingPadInst(I))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"CleanupReturnInst must unwind to an EH block which is not a landingpad."), $AddrOf(CRI));
            return;
          }
        } while (false);
      }
    }

    visitTerminatorInst(CRI);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2496,
   FQN="(anonymous namespace)::Verifier::verifyCallSite", NM="_ZN12_GLOBAL__N_18Verifier14verifyCallSiteEN4llvm8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier14verifyCallSiteEN4llvm8CallSiteE")
  //</editor-fold>
  private void verifyCallSite(CallSite CS) {
    Instruction /*P*/ I = CS.getInstruction();
    do {
      if (!(CS.getCalledValue().getType().isPointerTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Called function must be a pointer!"), I);
        return;
      }
    } while (false);
    PointerType /*P*/ FPTy = cast_PointerType(CS.getCalledValue().getType());
    do {
      if (!(FPTy.getElementType().isFunctionTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Called function is not pointer to function type!"), I);
        return;
      }
    } while (false);
    do {
      if (!(FPTy.getElementType() == CS.getFunctionType())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Called function is not the same type as the call!"), I);
        return;
      }
    } while (false);

    FunctionType /*P*/ FTy = CS.getFunctionType();

    // Verify that the correct number of arguments are being passed
    if (FTy.isVarArg()) {
      do {
        if (!($greatereq_uint(CS.arg_size(), FTy.getNumParams()))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Called function requires more parameters than were provided!"), I);
          return;
        }
      } while (false);
    } else {
      do {
        if (!(CS.arg_size() == FTy.getNumParams())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Incorrect number of arguments passed to called function!"), I);
          return;
        }
      } while (false);
    }

    // Verify that all arguments to the call match the function type.
    for (/*uint*/int i = 0, e = FTy.getNumParams(); i != e; ++i)  {
      do {
        if (!(CS.getArgument(i).getType() == FTy.getParamType(i))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Call parameter type does not match function signature!"), CS.getArgument(i), FTy.getParamType(i), I);
          return;
        }
      } while (false);
    }

    AttributeSet Attrs = new AttributeSet(CS.getAttributes());
    do {
      if (!(verifyAttributeCount(new AttributeSet(Attrs), CS.arg_size()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute after last parameter!"), I);
        return;
      }
    } while (false);

    // Verify call attributes.
    verifyFunctionAttrs(FTy, new AttributeSet(Attrs), I);

    // Conservatively check the inalloca argument.
    // We have a bug if we can find that there is an underlying alloca without
    // inalloca.
    if (CS.hasInAllocaArgument()) {
      Value /*P*/ InAllocaArg = CS.getArgument(FTy.getNumParams() - 1);
      {
        AllocaInst /*P*/ AI = dyn_cast_AllocaInst(InAllocaArg.stripInBoundsOffsets());
        if ((AI != null)) {
          do {
            if (!(AI.isUsedWithInAlloca())) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"inalloca argument for call has mismatched alloca"), AI, I);
              return;
            }
          } while (false);
        }
      }
    }

    // For each argument of the callsite, if it has the swifterror argument,
    // make sure the underlying alloca has swifterror as well.
    for (/*uint*/int i = 0, e = FTy.getNumParams(); i != e; ++i)  {
      if (CS.paramHasAttr(i + 1, Attribute.AttrKind.SwiftError)) {
        Value /*P*/ SwiftErrorArg = CS.getArgument(i);
        AllocaInst /*P*/ AI = dyn_cast_AllocaInst(SwiftErrorArg.stripInBoundsOffsets());
        do {
          if (!((AI) != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"swifterror argument should come from alloca"), AI, I);
            return;
          }
        } while (false);
        if ((AI != null)) {
          do {
            if (!(AI.isSwiftError())) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"swifterror argument for call has mismatched alloca"), AI, I);
              return;
            }
          } while (false);
        }
      }
    }
    if (FTy.isVarArg()) {
      // FIXME? is 'nest' even legal here?
      boolean SawNest = false;
      boolean SawReturned = false;

      for (/*uint*/int Idx = 1; $less_uint(Idx, 1 + FTy.getNumParams()); ++Idx) {
        if (Attrs.hasAttribute(Idx, Attribute.AttrKind.Nest)) {
          SawNest = true;
        }
        if (Attrs.hasAttribute(Idx, Attribute.AttrKind.Returned)) {
          SawReturned = true;
        }
      }

      // Check attributes on the varargs part.
      for (/*uint*/int Idx = 1 + FTy.getNumParams(); $lesseq_uint(Idx, CS.arg_size()); ++Idx) {
        Type /*P*/ Ty = CS.getArgument(Idx - 1).getType();
        verifyParameterAttrs(new AttributeSet(Attrs), Idx, Ty, false, I);
        if (Attrs.hasAttribute(Idx, Attribute.AttrKind.Nest)) {
          do {
            if (!(!SawNest)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"More than one parameter has attribute nest!"), I);
              return;
            }
          } while (false);
          SawNest = true;
        }
        if (Attrs.hasAttribute(Idx, Attribute.AttrKind.Returned)) {
          do {
            if (!(!SawReturned)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"More than one parameter has attribute returned!"), I);
              return;
            }
          } while (false);
          do {
            if (!(Ty.canLosslesslyBitCastTo(FTy.getReturnType()))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Incompatible argument and return types for 'returned' attribute"), I);
              return;
            }
          } while (false);
          SawReturned = true;
        }
        do {
          if (!(!Attrs.hasAttribute(Idx, Attribute.AttrKind.StructRet))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'sret' cannot be used for vararg call arguments!"), I);
            return;
          }
        } while (false);
        if (Attrs.hasAttribute(Idx, Attribute.AttrKind.InAlloca)) {
          do {
            if (!(Idx == CS.arg_size())) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"inalloca isn't on the last argument!"), I);
              return;
            }
          } while (false);
        }
      }
    }

    // Verify that there's no metadata unless it's a direct call to an intrinsic.
    if (CS.getCalledFunction() == null
       || !CS.getCalledFunction().getName().startswith(/*STRINGREF_STR*/"llvm.")) {
      for (Type /*P*/ ParamTy : FTy.params()) {
        do {
          if (!(!ParamTy.isMetadataTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Function has metadata parameter but isn't an intrinsic"), I);
            return;
          }
        } while (false);
        do {
          if (!(!ParamTy.isTokenTy())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Function has token parameter but isn't an intrinsic"), I);
            return;
          }
        } while (false);
      }
    }

    // Verify that indirect calls don't return tokens.
    if (CS.getCalledFunction() == null) {
      do {
        if (!(!FTy.getReturnType().isTokenTy())) {
          CheckFailed(new Twine(/*KEEP_STR*/"Return type cannot be token for indirect call!"));
          return;
        }
      } while (false);
    }
    {

      Function /*P*/ F = CS.getCalledFunction();
      if ((F != null)) {
        {
          /*Intrinsic.ID*/int ID = (/*Intrinsic.ID*/int)F.getIntrinsicID();
          if ((ID != 0)) {
            visitIntrinsicCallSite(ID, new CallSite(CS));
          }
        }
      }
    }

    // Verify that a callsite has at most one "deopt", at most one "funclet" and
    // at most one "gc-transition" operand bundle.
    boolean FoundDeoptBundle = false;
    boolean FoundFuncletBundle = false;
    boolean FoundGCTransitionBundle = false;
    for (/*uint*/int i = 0, e = CS.getNumOperandBundles(); $less_uint(i, e); ++i) {
      OperandBundleUse BU = CS.getOperandBundleAt(i);
      /*uint32_t*/int Tag = BU.getTagID();
      if (Tag == LLVMContext.Unnamed_enum1.OB_deopt.getValue()) {
        do {
          if (!(!FoundDeoptBundle)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Multiple deopt operand bundles"), I);
            return;
          }
        } while (false);
        FoundDeoptBundle = true;
      } else if (Tag == LLVMContext.Unnamed_enum1.OB_gc_transition.getValue()) {
        do {
          if (!(!FoundGCTransitionBundle)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Multiple gc-transition operand bundles"), I);
            return;
          }
        } while (false);
        FoundGCTransitionBundle = true;
      } else if (Tag == LLVMContext.Unnamed_enum1.OB_funclet.getValue()) {
        do {
          if (!(!FoundFuncletBundle)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Multiple funclet operand bundles"), I);
            return;
          }
        } while (false);
        FoundFuncletBundle = true;
        do {
          if (!(BU.Inputs.size() == 1)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Expected exactly one funclet bundle operand"), I);
            return;
          }
        } while (false);
        do {
          if (!(isa_FuncletPadInst(BU.Inputs.front()))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Funclet bundle operands should correspond to a FuncletPadInst"), I);
            return;
          }
        } while (false);
      }
    }

    // Verify that each inlinable callsite of a debug-info-bearing function in a
    // debug-info-bearing function has a debug location attached to it. Failure to
    // do so causes assertion failures when the inliner sets up inline scope info.
    if ((I.getFunction().getSubprogram() != null) && (CS.getCalledFunction() != null)
       && (CS.getCalledFunction().getSubprogram() != null)) {
      do {
        if (!(I.getDebugLoc()).$bool()) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"inlinable function call in a function with debug info must have a !dbg location"), I);
          return;
        }
      } while (false);
    }

    visitInstruction($Deref(I));
  }


  /// Check that SwiftErrorVal is used as a swifterror argument in CS.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifySwiftErrorCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3032,
   FQN="(anonymous namespace)::Verifier::verifySwiftErrorCallSite", NM="_ZN12_GLOBAL__N_18Verifier24verifySwiftErrorCallSiteEN4llvm8CallSiteEPKNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier24verifySwiftErrorCallSiteEN4llvm8CallSiteEPKNS1_5ValueE")
  //</editor-fold>
  private void verifySwiftErrorCallSite(CallSite CS,
                          /*const*/ Value /*P*/ SwiftErrorVal) {
    /*uint*/int Idx = 0;
    for (type$ptr<Use /*P*/> I = $tryClone(CS.arg_begin()), E = $tryClone(CS.arg_end());
         $noteq_ptr(I, E); I.$preInc() , ++Idx) {
      if (I.$star().$Value$P() == SwiftErrorVal) {
        do {
          if (!(CS.paramHasAttr(Idx + 1, Attribute.AttrKind.SwiftError))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"swifterror value when used in a callsite should be marked with swifterror attribute"), SwiftErrorVal, CS);
            return;
          }
        } while (false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifySwiftErrorValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3046,
   FQN="(anonymous namespace)::Verifier::verifySwiftErrorValue", NM="_ZN12_GLOBAL__N_18Verifier21verifySwiftErrorValueEPKN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier21verifySwiftErrorValueEPKN4llvm5ValueE")
  //</editor-fold>
  private void verifySwiftErrorValue(/*const*/ Value /*P*/ SwiftErrorVal) {
    // Check that swifterror value is only used by loads, stores, or as
    // a swifterror argument.
    for (/*const*/ User /*P*/ U : SwiftErrorVal.users$Const()) {
      do {
        if (!(isa_LoadInst(U) || isa_StoreInst(U) || isa_CallInst(U) || isa_InvokeInst(U))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"swifterror value can only be loaded and stored from, or as a swifterror argument!"), SwiftErrorVal, U);
          return;
        }
      } while (false);
      {
        // If it is used by a store, check it is the second operand.
        /*const*/ StoreInst /*P*/ StoreI = dyn_cast_StoreInst(U);
        if ((StoreI != null)) {
          do {
            if (!(StoreI.getOperand(1) == SwiftErrorVal)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"swifterror value should be the second operand when used by stores"), SwiftErrorVal, U);
              return;
            }
          } while (false);
        }
      }
      {
        /*const*/ CallInst /*P*/ CallI = dyn_cast_CallInst(U);
        if ((CallI != null)) {
          verifySwiftErrorCallSite(new CallSite(((/*const_cast*/CallInst /*P*/ )(CallI))), SwiftErrorVal);
        }
      }
      {
        /*const*/ InvokeInst /*P*/ II = dyn_cast_InvokeInst(U);
        if ((II != null)) {
          verifySwiftErrorCallSite(new CallSite(((/*const_cast*/InvokeInst /*P*/ )(II))), SwiftErrorVal);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyMustTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2679,
   FQN="(anonymous namespace)::Verifier::verifyMustTailCall", NM="_ZN12_GLOBAL__N_18Verifier18verifyMustTailCallERN4llvm8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18verifyMustTailCallERN4llvm8CallInstE")
  //</editor-fold>
  private void verifyMustTailCall(final CallInst /*&*/ CI) {
    do {
      if (!(!CI.isInlineAsm())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cannot use musttail call with inline asm"), $AddrOf(CI));
        return;
      }
    } while (false);

    // - The caller and callee prototypes must match.  Pointer types of
    //   parameters or return types may differ in pointee type, but not
    //   address space.
    Function /*P*/ F = CI.getParent().getParent();
    FunctionType /*P*/ CallerTy = F.getFunctionType();
    FunctionType /*P*/ CalleeTy = CI.getFunctionType();
    do {
      if (!(CallerTy.getNumParams() == CalleeTy.getNumParams())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cannot guarantee tail call due to mismatched parameter counts"), $AddrOf(CI));
        return;
      }
    } while (false);
    do {
      if (!(CallerTy.isVarArg() == CalleeTy.isVarArg())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cannot guarantee tail call due to mismatched varargs"), $AddrOf(CI));
        return;
      }
    } while (false);
    do {
      if (!(VerifierStatics.isTypeCongruent(CallerTy.getReturnType(), CalleeTy.getReturnType()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cannot guarantee tail call due to mismatched return types"), $AddrOf(CI));
        return;
      }
    } while (false);
    for (int I = 0, E = CallerTy.getNumParams(); I != E; ++I) {
      do {
        if (!(VerifierStatics.isTypeCongruent(CallerTy.getParamType(I), CalleeTy.getParamType(I)))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"cannot guarantee tail call due to mismatched parameter types"), $AddrOf(CI));
          return;
        }
      } while (false);
    }

    // - The calling conventions of the caller and callee must match.
    do {
      if (!(F.getCallingConv() == CI.getCallingConv())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"cannot guarantee tail call due to mismatched calling conv"), $AddrOf(CI));
        return;
      }
    } while (false);

    // - All ABI-impacting function attributes, such as sret, byval, inreg,
    //   returned, and inalloca, must match.
    AttributeSet CallerAttrs = F.getAttributes();
    AttributeSet CalleeAttrs = new AttributeSet(CI.getAttributes());
    for (int I = 0, E = CallerTy.getNumParams(); I != E; ++I) {
      AttrBuilder CallerABIAttrs = null;
      AttrBuilder CalleeABIAttrs = null;
      try {
        CallerABIAttrs = VerifierStatics.getParameterABIAttributes(I, new AttributeSet(CallerAttrs));
        CalleeABIAttrs = VerifierStatics.getParameterABIAttributes(I, new AttributeSet(CalleeAttrs));
        do {
          if (!(CallerABIAttrs.$eq(CalleeABIAttrs))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"cannot guarantee tail call due to mismatched ABI impacting function attributes"), $AddrOf(CI), CI.getOperand(I));
            return;
          }
        } while (false);
      } finally {
        if (CalleeABIAttrs != null) { CalleeABIAttrs.$destroy(); }
        if (CallerABIAttrs != null) { CallerABIAttrs.$destroy(); }
      }
    }

    // - The call must immediately precede a :ref:`ret <i_ret>` instruction,
    //   or a pointer bitcast followed by a ret instruction.
    // - The ret instruction must return the (possibly bitcasted) value
    //   produced by the call or void.
    Value /*P*/ RetVal = $AddrOf(CI);
    Instruction /*P*/ Next = CI.getNextNode();
    {

      // Handle the optional bitcast.
      BitCastInst /*P*/ BI = dyn_cast_or_null_BitCastInst(Next);
      if ((BI != null)) {
        do {
          if (!(BI.getOperand(0) == RetVal)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"bitcast following musttail call must use the call"), BI);
            return;
          }
        } while (false);
        RetVal = BI;
        Next = BI.getNextNode();
      }
    }

    // Check the return.
    ReturnInst /*P*/ Ret = dyn_cast_or_null_ReturnInst(Next);
    do {
      if (!((Ret) != null)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"musttail call must be precede a ret with an optional bitcast"), $AddrOf(CI));
        return;
      }
    } while (false);
    do {
      if (!(!(Ret.getReturnValue() != null) || Ret.getReturnValue() == RetVal)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"musttail call result must be returned"), Ret);
        return;
      }
    } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::performTypeCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 442,
   FQN="(anonymous namespace)::Verifier::performTypeCheck", NM="_ZN12_GLOBAL__N_18Verifier16performTypeCheckEN4llvm9Intrinsic2IDEPNS1_8FunctionEPNS1_4TypeEijRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16performTypeCheckEN4llvm9Intrinsic2IDEPNS1_8FunctionEPNS1_4TypeEijRSs")
  //</editor-fold>
  private boolean performTypeCheck(/*Intrinsic.ID*/int ID, Function /*P*/ F, Type /*P*/ Ty, int VT,
                  /*uint*/int ArgNo, final std.string/*&*/ Suffix) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyAttributeCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1659,
   FQN="(anonymous namespace)::Verifier::verifyAttributeCount", NM="_ZN12_GLOBAL__N_18Verifier20verifyAttributeCountEN4llvm12AttributeSetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20verifyAttributeCountEN4llvm12AttributeSetEj")
  //</editor-fold>
  private boolean verifyAttributeCount(AttributeSet Attrs, /*uint*/int Params) {
    if (Attrs.getNumSlots() == 0) {
      return true;
    }

    /*uint*/int LastSlot = Attrs.getNumSlots() - 1;
    /*uint*/int LastIndex = Attrs.getSlotIndex(LastSlot);
    if ($lesseq_uint(LastIndex, Params)
       || (LastIndex == AttributeSet.AttrIndex.FunctionIndex.getValue()
       && (LastSlot == 0 || $lesseq_uint(Attrs.getSlotIndex(LastSlot - 1), Params)))) {
      return true;
    }

    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyAttributeTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1257,
   FQN="(anonymous namespace)::Verifier::verifyAttributeTypes", NM="_ZN12_GLOBAL__N_18Verifier20verifyAttributeTypesEN4llvm12AttributeSetEjbPKNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20verifyAttributeTypesEN4llvm12AttributeSetEjbPKNS1_5ValueE")
  //</editor-fold>
  private void verifyAttributeTypes(AttributeSet Attrs, /*uint*/int Idx,
                      boolean isFunction, /*const*/ Value /*P*/ V) {
    /*uint*/int Slot = ~0/*U*/;
    for (/*uint*/int I = 0, E = Attrs.getNumSlots(); I != E; ++I)  {
      if (Attrs.getSlotIndex(I) == Idx) {
        Slot = I;
        break;
      }
    }
    assert (Slot != ~0/*U*/) : "Attribute set inconsistency!";

    for (type$ptr<Attribute> I = $tryClone(Attrs.begin(Slot)), /*P*/ E = $tryClone(Attrs.end(Slot));
         $noteq_ptr(I, E); I.$preInc()) {
      if (I./*->*/$star().isStringAttribute()) {
        continue;
      }
      if (I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoReturn
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoUnwind
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoInline
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.AlwaysInline
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.OptimizeForSize
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.StackProtect
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.StackProtectReq
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.StackProtectStrong
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.SafeStack
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoRedZone
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoImplicitFloat
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.Naked
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.InlineHint
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.StackAlignment
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.UWTable
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NonLazyBind
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.ReturnsTwice
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.SanitizeAddress
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.SanitizeThread
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.SanitizeMemory
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.MinSize
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoDuplicate
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.Builtin
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoBuiltin
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.Cold
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.OptimizeNone
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.JumpTable
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.Convergent
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.ArgMemOnly
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.NoRecurse
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.InaccessibleMemOnly
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.InaccessibleMemOrArgMemOnly
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.AllocSize) {
        if (!isFunction) {
          CheckFailed$T(new Twine($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"Attribute '", I./*->*/$star().getAsString()),
                      /*KEEP_STR*/"' only applies to functions!")), V);
          return;
        }
      } else if (I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.ReadOnly
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.WriteOnly
         || I./*->*/$star().getKindAsEnum() == Attribute.AttrKind.ReadNone) {
        if (Idx == 0) {
          CheckFailed(new Twine($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"Attribute '", I./*->*/$star().getAsString()),
                      /*KEEP_STR*/"' does not apply to function returns")));
          return;
        }
      } else if (isFunction) {
        CheckFailed$T(new Twine($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"Attribute '", I./*->*/$star().getAsString()),
                    /*KEEP_STR*/"' does not apply to functions!")), V);
        return;
      }
    }
  }


  // VerifyParameterAttrs - Check the given attributes for an argument or return
  // value of the specified type.  The value V is printed in error messages.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyParameterAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1329,
   FQN="(anonymous namespace)::Verifier::verifyParameterAttrs", NM="_ZN12_GLOBAL__N_18Verifier20verifyParameterAttrsEN4llvm12AttributeSetEjPNS1_4TypeEbPKNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier20verifyParameterAttrsEN4llvm12AttributeSetEjPNS1_4TypeEbPKNS1_5ValueE")
  //</editor-fold>
  private void verifyParameterAttrs(AttributeSet Attrs, /*uint*/int Idx, Type /*P*/ Ty,
                      boolean isReturnValue, /*const*/ Value /*P*/ V) {
    if (!Attrs.hasAttributes(Idx)) {
      return;
    }

    verifyAttributeTypes(new AttributeSet(Attrs), Idx, false, V);
    if (isReturnValue) {
      do {
        if (!(!Attrs.hasAttribute(Idx, Attribute.AttrKind.ByVal) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.Nest) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.StructRet) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.NoCapture) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.Returned) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.InAlloca) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.SwiftSelf) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.SwiftError))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'byval', 'inalloca', 'nest', 'sret', 'nocapture', 'returned', 'swiftself', and 'swifterror' do not apply to return values!"), V);
          return;
        }
      } while (false);
    }

    // Check for mutually incompatible attributes.  Only inreg is compatible with
    // sret.
    /*uint*/int AttrCount = 0;
    AttrCount += (Attrs.hasAttribute(Idx, Attribute.AttrKind.ByVal) ? 1 : 0);
    AttrCount += (Attrs.hasAttribute(Idx, Attribute.AttrKind.InAlloca) ? 1 : 0);
    AttrCount += ((Attrs.hasAttribute(Idx, Attribute.AttrKind.StructRet)
       || Attrs.hasAttribute(Idx, Attribute.AttrKind.InReg)) ? 1 : 0);
    AttrCount += (Attrs.hasAttribute(Idx, Attribute.AttrKind.Nest) ? 1 : 0);
    do {
      if (!($lesseq_uint(AttrCount, 1))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'byval', 'inalloca', 'inreg', 'nest', and 'sret' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.InAlloca) && Attrs.hasAttribute(Idx, Attribute.AttrKind.ReadOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'inalloca and readonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.StructRet) && Attrs.hasAttribute(Idx, Attribute.AttrKind.Returned)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'sret and returned' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.ZExt) && Attrs.hasAttribute(Idx, Attribute.AttrKind.SExt)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'zeroext and signext' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.ReadNone) && Attrs.hasAttribute(Idx, Attribute.AttrKind.ReadOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readnone and readonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.ReadNone) && Attrs.hasAttribute(Idx, Attribute.AttrKind.WriteOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readnone and writeonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.ReadOnly) && Attrs.hasAttribute(Idx, Attribute.AttrKind.WriteOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readonly and writeonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(Idx, Attribute.AttrKind.NoInline) && Attrs.hasAttribute(Idx, Attribute.AttrKind.AlwaysInline)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'noinline and alwaysinline' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if ($c$.clean(!(!$c$.track(new AttrBuilder(new AttributeSet(Attrs), Idx)).overlaps($c$.track(AttributeFuncs.typeIncompatible(Ty)))))) {
          CheckFailed$T(new Twine($add_T$C$P_string(/*KEEP_STR*/"Wrong types for attribute: ", AttributeSet.get($Deref(Context), Idx, $c$.track(AttributeFuncs.typeIncompatible(Ty))).getAsString(Idx))), V); $c$.clean();
          return;
        }
      } finally {
        $c$.$destroy();
      }
    } while (false);
    {

      PointerType /*P*/ PTy = dyn_cast_PointerType(Ty);
      if ((PTy != null)) {
        SmallPtrSet<Type /*P*/ > Visited/*J*/= new SmallPtrSet<Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
        if (!PTy.getElementType().isSized($AddrOf(Visited))) {
          do {
            if (!(!Attrs.hasAttribute(Idx, Attribute.AttrKind.ByVal) && !Attrs.hasAttribute(Idx, Attribute.AttrKind.InAlloca))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'byval' and 'inalloca' do not support unsized types!"), V);
              return;
            }
          } while (false);
        }
        if (!isa_PointerType(PTy.getElementType())) {
          do {
            if (!(!Attrs.hasAttribute(Idx, Attribute.AttrKind.SwiftError))) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'swifterror' only applies to parameters with pointer to pointer type!"), V);
              return;
            }
          } while (false);
        }
      } else {
        do {
          if (!(!Attrs.hasAttribute(Idx, Attribute.AttrKind.ByVal))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'byval' only applies to parameters with pointer type!"), V);
            return;
          }
        } while (false);
        do {
          if (!(!Attrs.hasAttribute(Idx, Attribute.AttrKind.SwiftError))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'swifterror' only applies to parameters with pointer type!"), V);
            return;
          }
        } while (false);
      }
    }
  }


  // Check parameter attributes against a function type.
  // The value V is printed in error messages.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyFunctionAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1437,
   FQN="(anonymous namespace)::Verifier::verifyFunctionAttrs", NM="_ZN12_GLOBAL__N_18Verifier19verifyFunctionAttrsEPN4llvm12FunctionTypeENS1_12AttributeSetEPKNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier19verifyFunctionAttrsEPN4llvm12FunctionTypeENS1_12AttributeSetEPKNS1_5ValueE")
  //</editor-fold>
  private void verifyFunctionAttrs(FunctionType /*P*/ FT, AttributeSet Attrs,
                     /*const*/ Value /*P*/ V) {
    if (Attrs.isEmpty()) {
      return;
    }

    boolean SawNest = false;
    boolean SawReturned = false;
    boolean SawSRet = false;
    boolean SawSwiftSelf = false;
    boolean SawSwiftError = false;

    for (/*uint*/int i = 0, e = Attrs.getNumSlots(); i != e; ++i) {
      /*uint*/int Idx = Attrs.getSlotIndex(i);

      Type /*P*/ Ty;
      if (Idx == 0) {
        Ty = FT.getReturnType();
      } else if ($less_uint(Idx - 1, FT.getNumParams())) {
        Ty = FT.getParamType(Idx - 1);
      } else {
        break; // VarArgs attributes, verified elsewhere.
      }

      verifyParameterAttrs(new AttributeSet(Attrs), Idx, Ty, Idx == 0, V);
      if (Idx == 0) {
        continue;
      }
      if (Attrs.hasAttribute(Idx, Attribute.AttrKind.Nest)) {
        do {
          if (!(!SawNest)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"More than one parameter has attribute nest!"), V);
            return;
          }
        } while (false);
        SawNest = true;
      }
      if (Attrs.hasAttribute(Idx, Attribute.AttrKind.Returned)) {
        do {
          if (!(!SawReturned)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"More than one parameter has attribute returned!"), V);
            return;
          }
        } while (false);
        do {
          if (!(Ty.canLosslesslyBitCastTo(FT.getReturnType()))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Incompatible argument and return types for 'returned' attribute"), V);
            return;
          }
        } while (false);
        SawReturned = true;
      }
      if (Attrs.hasAttribute(Idx, Attribute.AttrKind.StructRet)) {
        do {
          if (!(!SawSRet)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot have multiple 'sret' parameters!"), V);
            return;
          }
        } while (false);
        do {
          if (!(Idx == 1 || Idx == 2)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'sret' is not on first or second parameter!"), V);
            return;
          }
        } while (false);
        SawSRet = true;
      }
      if (Attrs.hasAttribute(Idx, Attribute.AttrKind.SwiftSelf)) {
        do {
          if (!(!SawSwiftSelf)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot have multiple 'swiftself' parameters!"), V);
            return;
          }
        } while (false);
        SawSwiftSelf = true;
      }
      if (Attrs.hasAttribute(Idx, Attribute.AttrKind.SwiftError)) {
        do {
          if (!(!SawSwiftError)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"Cannot have multiple 'swifterror' parameters!"), V);
            return;
          }
        } while (false);
        SawSwiftError = true;
      }
      if (Attrs.hasAttribute(Idx, Attribute.AttrKind.InAlloca)) {
        do {
          if (!(Idx == FT.getNumParams())) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"inalloca isn't on the last parameter!"), V);
            return;
          }
        } while (false);
      }
    }
    if (!Attrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
      return;
    }

    verifyAttributeTypes(new AttributeSet(Attrs), AttributeSet.AttrIndex.FunctionIndex.getValue(), true, V);
    do {
      if (!(!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadNone) && Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readnone and readonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadNone) && Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.WriteOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readnone and writeonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadOnly) && Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.WriteOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readonly and writeonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadNone) && Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.InaccessibleMemOrArgMemOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readnone and inaccessiblemem_or_argmemonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadNone) && Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.InaccessibleMemOnly)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'readnone and inaccessiblememonly' are incompatible!"), V);
        return;
      }
    } while (false);
    do {
      if (!(!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoInline) && Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.AlwaysInline)))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'noinline and alwaysinline' are incompatible!"), V);
        return;
      }
    } while (false);
    if (Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(),
        Attribute.AttrKind.OptimizeNone)) {
      do {
        if (!(Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoInline))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'optnone' requires 'noinline'!"), V);
          return;
        }
      } while (false);
      do {
        if (!(!Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.OptimizeForSize))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'optsize and optnone' are incompatible!"), V);
          return;
        }
      } while (false);
      do {
        if (!(!Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.MinSize))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Attributes 'minsize and optnone' are incompatible!"), V);
          return;
        }
      } while (false);
    }
    if (Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(),
        Attribute.AttrKind.JumpTable)) {
      /*const*/ GlobalValue /*P*/ GV = cast_GlobalValue(V);
      do {
        if (!(GV.hasGlobalUnnamedAddr())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"Attribute 'jumptable' requires 'unnamed_addr'"), V);
          return;
        }
      } while (false);
    }
    if (Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.AllocSize)) {
      std.pairUIntType<OptionalUInt> Args = Attrs.getAllocSizeArgs(AttributeSet.AttrIndex.FunctionIndex.getValue());

      StringRefUInt2Bool CheckParam = /*[&, &FT, this, &V]*/ (StringRef Name, /*uint*/int ParamNo) -> {
            if ($greatereq_uint(ParamNo, FT.getNumParams())) {
              CheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"'allocsize' ", Name), new Twine(/*KEEP_STR*/" argument is out of bounds")), V);
              return false;
            }
            if (!FT.getParamType(ParamNo).isIntegerTy()) {
              CheckFailed$T($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"'allocsize' ", Name),
                      new Twine(/*KEEP_STR*/" argument must refer to an integer parameter")),
                  V);
              return false;
            }

            return true;
          };
      if (!CheckParam.$call(new StringRef(/*KEEP_STR*/"element size"), Args.first)) {
        return;
      }
      if (Args.second.$bool() && !CheckParam.$call(new StringRef(/*KEEP_STR*/"number of elements"), Args.second.$star())) {
        return;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyFunctionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1589,
   FQN="(anonymous namespace)::Verifier::verifyFunctionMetadata", NM="_ZN12_GLOBAL__N_18Verifier22verifyFunctionMetadataEN4llvm8ArrayRefISt4pairIjPNS1_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier22verifyFunctionMetadataEN4llvm8ArrayRefISt4pairIjPNS1_6MDNodeEEEE")
  //</editor-fold>
  private void verifyFunctionMetadata(ArrayRef<std.pairUIntPtr<MDNode /*P*/ >> MDs) {
    for (final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ Pair : MDs) {
      if (Pair.first == LLVMContext.Unnamed_enum.MD_prof.getValue()) {
        MDNode /*P*/ MD = Pair.second;
        do {
          if (!(MD.getNumOperands() == 2)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"!prof annotations should have exactly 2 operands"), MD);
            return;
          }
        } while (false);

        // Check first operand.
        do {
          if (!(MD.getOperand(0).$Metadata$P() != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"first operand should not be null"), MD);
            return;
          }
        } while (false);
        do {
          if (!(isa_MDString(MD.getOperand(0)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"expected string with name of the !prof annotation"), MD);
            return;
          }
        } while (false);
        MDString /*P*/ MDS = cast_MDString(MD.getOperand(0));
        StringRef ProfName = MDS.getString();
        do {
          if (!(ProfName.equals(/*STRINGREF_STR*/"function_entry_count"))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"first operand should be 'function_entry_count'"), MD);
            return;
          }
        } while (false);

        // Check second operand.
        do {
          if (!(MD.getOperand(1).$Metadata$P() != null)) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"second operand should not be null"), MD);
            return;
          }
        } while (false);
        do {
          if (!(isa_ConstantAsMetadata(MD.getOperand(1)))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"expected integer argument to function_entry_count"), MD);
            return;
          }
        } while (false);
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitConstantExprsRecursively">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1616,
   FQN="(anonymous namespace)::Verifier::visitConstantExprsRecursively", NM="_ZN12_GLOBAL__N_18Verifier29visitConstantExprsRecursivelyEPKN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier29visitConstantExprsRecursivelyEPKN4llvm8ConstantE")
  //</editor-fold>
  private void visitConstantExprsRecursively(/*const*/ Constant /*P*/ EntryC) {
    if (!ConstantExprVisited.insert(EntryC).second) {
      return;
    }

    SmallVector</*const*/ Constant /*P*/ > Stack/*J*/= new SmallVector</*const*/ Constant /*P*/ >(16, (/*const*/ Constant /*P*/ )null);
    Stack.push_back(EntryC);
    while (!Stack.empty()) {
      /*const*/ Constant /*P*/ C = Stack.pop_back_val();
      {

        // Check this constant expression.
        /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(C);
        if ((CE != null)) {
          visitConstantExpr(CE);
        }
      }
      {

        /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(C);
        if ((GV != null)) {
          // Global Values get visited separately, but we do need to make sure
          // that the global value is in the correct module
          do {
            if (!(GV.getParent$Const() == M)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"Referencing global in another module!"), EntryC, M, GV, GV.getParent$Const());
              return;
            }
          } while (false);
          continue;
        }
      }

      // Visit all sub-expressions.
      for (final /*const*/ Use /*&*/ U : C.operands$Const()) {
        /*const*/ Constant /*P*/ OpC = dyn_cast_Constant(U);
        if (!(OpC != null)) {
          continue;
        }
        if (!ConstantExprVisited.insert(OpC).second) {
          continue;
        }
        Stack.push_back(OpC);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::visitConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1650,
   FQN="(anonymous namespace)::Verifier::visitConstantExpr", NM="_ZN12_GLOBAL__N_18Verifier17visitConstantExprEPKN4llvm12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier17visitConstantExprEPKN4llvm12ConstantExprE")
  //</editor-fold>
  private void visitConstantExpr(/*const*/ ConstantExpr /*P*/ CE) {
    if (CE.getOpcode() != Instruction.CastOps.BitCast) {
      return;
    }
    do {
      if (!(CastInst.castIsValid(Instruction.CastOps.BitCast, CE.getOperand_Constant(0), CE.getType()))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"Invalid bitcast"), CE);
        return;
      }
    } while (false);
  }


  /// Verify that statepoint intrinsic is well formed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyStatepoint">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1674,
   FQN="(anonymous namespace)::Verifier::verifyStatepoint", NM="_ZN12_GLOBAL__N_18Verifier16verifyStatepointEN4llvm17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier16verifyStatepointEN4llvm17ImmutableCallSiteE")
  //</editor-fold>
  private void verifyStatepoint(ImmutableCallSite CS) {
    assert ((CS.getCalledFunction() != null) && CS.getCalledFunction().getIntrinsicID() == ID.experimental_gc_statepoint);

    final /*const*/ Instruction /*&*/ CI = $Deref(CS.getInstruction());
    do {
      if (!(!CS.doesNotAccessMemory() && !CS.onlyReadsMemory() && !CS.onlyAccessesArgMemory())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint must read and write all memory to preserve reordering restrictions required by safepoint semantics"), $AddrOf(CI));
        return;
      }
    } while (false);

    /*const*/ Value /*P*/ IDV = CS.getArgument(0);
    do {
      if (!(isa_ConstantInt(IDV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint ID must be a constant integer"), $AddrOf(CI));
        return;
      }
    } while (false);

    /*const*/ Value /*P*/ NumPatchBytesV = CS.getArgument(1);
    do {
      if (!(isa_ConstantInt(NumPatchBytesV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of patchable bytes must be a constant integer"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/long/*int64_t*/ NumPatchBytes = cast_ConstantInt(NumPatchBytesV).getSExtValue();
    assert (isInt(32, (int)NumPatchBytes)) : "NumPatchBytesV is an i32!";
    do {
      if (!(NumPatchBytes >= 0)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of patchable bytes must be positive"), $AddrOf(CI));
        return;
      }
    } while (false);

    /*const*/ Value /*P*/ Target = CS.getArgument(2);
    PointerType /*P*/ PT = dyn_cast_PointerType(Target.getType());
    do {
      if (!((PT != null) && PT.getElementType().isFunctionTy())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint callee must be of function pointer type"), $AddrOf(CI), Target);
        return;
      }
    } while (false);
    FunctionType /*P*/ TargetFuncType = cast_FunctionType(PT.getElementType());

    /*const*/ Value /*P*/ NumCallArgsV = CS.getArgument(3);
    do {
      if (!(isa_ConstantInt(NumCallArgsV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of arguments to underlying call must be constant integer"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/int NumCallArgs = $ulong2int(cast_ConstantInt(NumCallArgsV).getZExtValue());
    do {
      if (!(NumCallArgs >= 0)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of arguments to underlying call must be positive"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/int NumParams = (int)TargetFuncType.getNumParams();
    if (TargetFuncType.isVarArg()) {
      do {
        if (!(NumCallArgs >= NumParams)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint mismatch in number of vararg call args"), $AddrOf(CI));
          return;
        }
      } while (false);

      // TODO: Remove this limitation
      do {
        if (!(TargetFuncType.getReturnType().isVoidTy())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint doesn't support wrapping non-void vararg functions yet"), $AddrOf(CI));
          return;
        }
      } while (false);
    } else {
      do {
        if (!(NumCallArgs == NumParams)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint mismatch in number of call args"), $AddrOf(CI));
          return;
        }
      } while (false);
    }

    /*const*/ Value /*P*/ FlagsV = CS.getArgument(4);
    do {
      if (!(isa_ConstantInt(FlagsV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint flags must be constant integer"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/long/*uint64_t*/ Flags = cast_ConstantInt(FlagsV).getZExtValue();
    do {
      if (!((Flags & ~((long/*uint64_t*/)StatepointFlags.MaskAll.getValue())) == $int2ullong(0))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"unknown flag used in gc.statepoint flags argument"), $AddrOf(CI));
        return;
      }
    } while (false);

    // Verify that the types of the call parameter arguments match
    // the type of the wrapped callee.
    for (int i = 0; i < NumParams; i++) {
      Type /*P*/ ParamType = TargetFuncType.getParamType(i);
      Type /*P*/ ArgType = CS.getArgument(5 + i).getType();
      do {
        if (!(ArgType == ParamType)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint call argument does not match wrapped function type"), $AddrOf(CI));
          return;
        }
      } while (false);
    }

    /*const*/int EndCallArgsInx = 4 + NumCallArgs;

    /*const*/ Value /*P*/ NumTransitionArgsV = CS.getArgument(EndCallArgsInx + 1);
    do {
      if (!(isa_ConstantInt(NumTransitionArgsV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of transition arguments must be constant integer"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/int NumTransitionArgs = $ulong2int(cast_ConstantInt(NumTransitionArgsV).getZExtValue());
    do {
      if (!(NumTransitionArgs >= 0)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of transition arguments must be positive"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/int EndTransitionArgsInx = EndCallArgsInx + 1 + NumTransitionArgs;

    /*const*/ Value /*P*/ NumDeoptArgsV = CS.getArgument(EndTransitionArgsInx + 1);
    do {
      if (!(isa_ConstantInt(NumDeoptArgsV))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of deoptimization arguments must be constant integer"), $AddrOf(CI));
        return;
      }
    } while (false);
    /*const*/int NumDeoptArgs = $ulong2int(cast_ConstantInt(NumDeoptArgsV).getZExtValue());
    do {
      if (!(NumDeoptArgs >= 0)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint number of deoptimization arguments must be positive"), $AddrOf(CI));
        return;
      }
    } while (false);

    /*const*/int ExpectedNumArgs = 7 + NumCallArgs + NumTransitionArgs + NumDeoptArgs;
    do {
      if (!(ExpectedNumArgs <= (int)CS.arg_size())) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"gc.statepoint too few arguments according to length fields"), $AddrOf(CI));
        return;
      }
    } while (false);

    // Check that the only uses of this gc.statepoint are gc.result or
    // gc.relocate calls which are tied to this statepoint and thus part
    // of the same statepoint sequence
    for (/*const*/ User /*P*/ U : CI.users$Const()) {
      /*const*/ CallInst /*P*/ Call = dyn_cast_CallInst(U);
      do {
        if (!((Call) != null)) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"illegal use of statepoint token"), $AddrOf(CI), U);
          return;
        }
      } while (false);
      if (!(Call != null)) {
        continue;
      }
      do {
        if (!(isa_GCRelocateInst(Call) || isa_GCResultInst(Call))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"gc.result or gc.relocate are the only value usesof a gc.statepoint"), $AddrOf(CI), U);
          return;
        }
      } while (false);
      if (isa_GCResultInst(Call)) {
        do {
          if (!(Call.getArgOperand(0) == $AddrOf(CI))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.result connected to wrong gc.statepoint"), $AddrOf(CI), Call);
            return;
          }
        } while (false);
      } else if (isa_GCRelocateInst(Call)) {
        do {
          if (!(Call.getArgOperand(0) == $AddrOf(CI))) {
            CheckFailed$T(new Twine(/*KEEP_STR*/"gc.relocate connected to wrong gc.statepoint"), $AddrOf(CI), Call);
            return;
          }
        } while (false);
      }
    }
    // Note: It is legal for a single derived pointer to be listed multiple
    // times.  It's non-optimal, but it is legal.  It can also happen after
    // insertion if we strip a bitcast away.
    // Note: It is really tempting to check that each base is relocated and
    // that a derived pointer is never reused as a base pointer.  This turns
    // out to be problematic since optimizations run after safepoint insertion
    // can recognize equality properties that the insertion logic doesn't know
    // about.  See example statepoint.ll in the verifier subdirectory
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyFrameRecoverIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1808,
   FQN="(anonymous namespace)::Verifier::verifyFrameRecoverIndices", NM="_ZN12_GLOBAL__N_18Verifier25verifyFrameRecoverIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier25verifyFrameRecoverIndicesEv")
  //</editor-fold>
  private void verifyFrameRecoverIndices() {
    for (final std.pair<Function /*P*/ , std.pairUIntUInt> /*&*/ Counts : FrameEscapeInfo) {
      Function /*P*/ F = Counts.first;
      /*uint*/int EscapedObjectCount = Counts.second.first;
      /*uint*/int MaxRecoveredIndex = Counts.second.second;
      do {
        if (!($lesseq_uint(MaxRecoveredIndex, EscapedObjectCount))) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"all indices passed to llvm.localrecover must be less than the number of arguments passed ot llvm.localescape in the parent function"), F);
          return;
        }
      } while (false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifySiblingFuncletUnwinds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1832,
   FQN="(anonymous namespace)::Verifier::verifySiblingFuncletUnwinds", NM="_ZN12_GLOBAL__N_18Verifier27verifySiblingFuncletUnwindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier27verifySiblingFuncletUnwindsEv")
  //</editor-fold>
  private void verifySiblingFuncletUnwinds() {
    SmallPtrSet<Instruction /*P*/ > Visited/*J*/= new SmallPtrSet<Instruction /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    SmallPtrSet<Instruction /*P*/ > Active/*J*/= new SmallPtrSet<Instruction /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    for (final /*const*/std.pairPtrPtr<Instruction /*P*/ , TerminatorInst /*P*/ > /*&*/ Pair : SiblingFuncletInfo) {
      Instruction /*P*/ PredPad = Pair.first;
      if ((Visited.count(PredPad) != 0)) {
        continue;
      }
      Active.insert(PredPad);
      TerminatorInst /*P*/ Terminator = Pair.second;
      do {
        Instruction /*P*/ SuccPad = VerifierStatics.getSuccPad(Terminator);
        if ((Active.count(SuccPad) != 0)) {
          // Found a cycle; report error
          Instruction /*P*/ CyclePad = SuccPad;
          SmallVector<Instruction /*P*/ > CycleNodes/*J*/= new SmallVector<Instruction /*P*/ >(8, (Instruction /*P*/ )null);
          do {
            CycleNodes.push_back(CyclePad);
            TerminatorInst /*P*/ CycleTerminator = SiblingFuncletInfo.$at(CyclePad);
            if (CycleTerminator != CyclePad) {
              CycleNodes.push_back(CycleTerminator);
            }
            CyclePad = VerifierStatics.getSuccPad(CycleTerminator);
          } while (CyclePad != SuccPad);
          do {
            if (!(false)) {
              CheckFailed$T(new Twine(/*KEEP_STR*/"EH pads can't handle each other's exceptions"), new ArrayRef<Instruction /*P*/ >(CycleNodes, true));
              return;
            }
          } while (false);
        }
        // Don't re-walk a node we've already checked
        if (!Visited.insert(SuccPad).second) {
          break;
        }
        // Walk to this successor if it has a map entry.
        PredPad = SuccPad;
        std.vector.iterator<std.pairPtrPtr<Instruction /*P*/ , TerminatorInst /*P*/ > /*P*/> TermI = SiblingFuncletInfo.find(PredPad);
        if ($eq___normal_iterator$C(TermI, SiblingFuncletInfo.end())) {
          break;
        }
        Terminator = TermI.$arrow().second;
        Active.insert(PredPad);
      } while (true);
      // Each node only has one successor, so we've walked all the active
      // nodes' successors.
      Active.clear();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyBitPieceExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4213,
   FQN="(anonymous namespace)::Verifier::verifyBitPieceExpression", NM="_ZN12_GLOBAL__N_18Verifier24verifyBitPieceExpressionERKN4llvm16DbgInfoIntrinsicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier24verifyBitPieceExpressionERKN4llvm16DbgInfoIntrinsicE")
  //</editor-fold>
  private void verifyBitPieceExpression(final /*const*/ DbgInfoIntrinsic /*&*/ I) {
    DILocalVariable /*P*/ V;
    DIExpression /*P*/ E;
    {
      /*const*/ DbgValueInst /*P*/ DVI = dyn_cast_DbgValueInst($AddrOf(I));
      if ((DVI != null)) {
        V = dyn_cast_or_null_DILocalVariable(DVI.getRawVariable());
        E = dyn_cast_or_null_DIExpression(DVI.getRawExpression());
      } else {
        /*const*/ DbgDeclareInst /*P*/ DDI = cast_DbgDeclareInst($AddrOf(I));
        V = dyn_cast_or_null_DILocalVariable(DDI.getRawVariable());
        E = dyn_cast_or_null_DIExpression(DDI.getRawExpression());
      }
    }

    // We don't know whether this intrinsic verified correctly.
    if (!(V != null) || !(E != null) || !E.isValid()) {
      return;
    }

    // Nothing to do if this isn't a bit piece expression.
    if (!E.isBitPiece()) {
      return;
    }

    // The frontend helps out GDB by emitting the members of local anonymous
    // unions as artificial local variables with shared storage. When SROA splits
    // the storage for artificial local variables that are smaller than the entire
    // union, the overhang piece will be outside of the allotted space for the
    // variable and this check fails.
    // FIXME: Remove this check as soon as clang stops doing this; it hides bugs.
    if (V.isArtificial()) {
      return;
    }

    // If there's no size, the type is broken, but that should be checked
    // elsewhere.
    long/*uint64_t*/ VarSize = VerifierStatics.getVariableSize($Deref(V));
    if (!(VarSize != 0)) {
      return;
    }

    /*uint*/int PieceSize = $ulong2uint(E.getBitPieceSize());
    /*uint*/int PieceOffset = $ulong2uint(E.getBitPieceOffset());
    do {
      if (!($lesseq_uint_ulong(PieceSize + PieceOffset, VarSize))) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"piece is larger than or outside of variable"), $AddrOf(I), V, E);
        return;
      }
    } while (false);
    do {
      if (!($uint2ullong(PieceSize) != VarSize)) {
        CheckFailed$T(new Twine(/*KEEP_STR*/"piece covers entire variable"), $AddrOf(I), V, E);
        return;
      }
    } while (false);
  }


  /// Module-level debug info verification...
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyCompileUnits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4255,
   FQN="(anonymous namespace)::Verifier::verifyCompileUnits", NM="_ZN12_GLOBAL__N_18Verifier18verifyCompileUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier18verifyCompileUnitsEv")
  //</editor-fold>
  private void verifyCompileUnits() {
    NamedMDNode /*P*/ CUs = M.getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.dbg.cu"));
    SmallPtrSet</*const*/ Metadata /*P*/ > Listed/*J*/= new SmallPtrSet</*const*/ Metadata /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    if ((CUs != null)) {
      Listed.insert$T(CUs.op_begin(), CUs.op_end());
    }
    do {
      if (!(std.all_of(CUVisited.begin(), CUVisited.end(), /*[&Listed]*/ (/*const*/ Metadata /*P*/ CU) -> {
                return Listed.count(CU) != 0;
              }))) {
        CheckFailed(new Twine(/*KEEP_STR*/"All DICompileUnits must be listed in llvm.dbg.cu"));
        return;
      }
    } while (false);
    CUVisited.clear();
  }


  /// Module-level verification that all @llvm.experimental.deoptimize
  /// declarations share the same calling convention.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::verifyDeoptimizeCallingConvs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4267,
   FQN="(anonymous namespace)::Verifier::verifyDeoptimizeCallingConvs", NM="_ZN12_GLOBAL__N_18Verifier28verifyDeoptimizeCallingConvsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18Verifier28verifyDeoptimizeCallingConvsEv")
  //</editor-fold>
  private void verifyDeoptimizeCallingConvs() {
    if (DeoptimizeDeclarations.empty()) {
      return;
    }

    /*const*/ Function /*P*/ First = DeoptimizeDeclarations.$at(0);
    for (/*const*/ Function /*P*/ F : makeArrayRef(DeoptimizeDeclarations, true).slice(1)) {
      do {
        if (!(First.getCallingConv() == F.getCallingConv())) {
          CheckFailed$T(new Twine(/*KEEP_STR*/"All llvm.experimental.deoptimize declarations must have the same calling convention"), First, F);
          return;
        }
      } while (false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Verifier::~Verifier">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 209,
   FQN="(anonymous namespace)::Verifier::~Verifier", NM="_ZN12_GLOBAL__N_18VerifierD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_18VerifierD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    GlobalValueVisited.$destroy();
    DeoptimizeDeclarations.$destroy();
    ConstantExprVisited.$destroy();
    SiblingFuncletInfo.$destroy();
    FrameEscapeInfo.$destroy();
    CUVisited.$destroy();
    MDNodes.$destroy();
    InstsInThisBlock.$destroy();
    DT.$destroy();
    // no such method InstVisitorVoid.super.$destroy$InstVisitor();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "Context=" + "[LLVMContext]" // NOI18N
              + ", DT=" + DT // NOI18N
              + ", InstsInThisBlock=" + InstsInThisBlock // NOI18N
              + ", MDNodes=" + MDNodes // NOI18N
              + ", CUVisited=" + CUVisited // NOI18N
              + ", LandingPadResultTy=" + LandingPadResultTy // NOI18N
              + ", SawFrameEscape=" + SawFrameEscape // NOI18N
              + ", FrameEscapeInfo=" + FrameEscapeInfo // NOI18N
              + ", SiblingFuncletInfo=" + SiblingFuncletInfo // NOI18N
              + ", ConstantExprVisited=" + ConstantExprVisited // NOI18N
              + ", DeoptimizeDeclarations=" + DeoptimizeDeclarations // NOI18N
              + ", GlobalValueVisited=" + GlobalValueVisited // NOI18N
              + super.toString(); // NOI18N
  }
}
