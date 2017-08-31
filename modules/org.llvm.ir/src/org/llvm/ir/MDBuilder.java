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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 32,
 FQN="llvm::MDBuilder", NM="_ZN4llvm9MDBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilderE")
//</editor-fold>
public class MDBuilder {
  private final LLVMContext /*&*/ Context;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::MDBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 36,
   FQN="llvm::MDBuilder::MDBuilder", NM="_ZN4llvm9MDBuilderC1ERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilderC1ERNS_11LLVMContextE")
  //</editor-fold>
  public MDBuilder(final LLVMContext /*&*/ context) {
    // : Context(context)
    //START JInit
    this./*&*/Context=/*&*/context;
    //END JInit
  }


  /// \brief Return the given string as metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 20,
   FQN="llvm::MDBuilder::createString", NM="_ZN4llvm9MDBuilder12createStringENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder12createStringENS_9StringRefE")
  //</editor-fold>
  public MDString /*P*/ createString(StringRef Str) {
    return MDString.get(Context, new StringRef(Str));
  }


  /// \brief Return the given constant as metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 24,
   FQN="llvm::MDBuilder::createConstant", NM="_ZN4llvm9MDBuilder14createConstantEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder14createConstantEPNS_8ConstantE")
  //</editor-fold>
  public ConstantAsMetadata /*P*/ createConstant(Constant /*P*/ C) {
    return ConstantAsMetadata.get(C);
  }


  //===------------------------------------------------------------------===//
  // FPMath metadata.
  //===------------------------------------------------------------------===//

  /// \brief Return metadata with the given settings.  The special value 0.0
  /// for the Accuracy parameter indicates the default (maximal precision)
  /// setting.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createFPMath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 28,
   FQN="llvm::MDBuilder::createFPMath", NM="_ZN4llvm9MDBuilder12createFPMathEf",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder12createFPMathEf")
  //</editor-fold>
  public MDNode /*P*/ createFPMath(float Accuracy) {
    if (Accuracy == 0.) {
      return null;
    }
    assert (Accuracy > 0.) : "Invalid fpmath accuracy!";
    ConstantAsMetadata /*P*/ Op = createConstant(ConstantFP.get(Type.getFloatTy(Context), Accuracy));
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Op, true));
  }


  //===------------------------------------------------------------------===//
  // Prof metadata.
  //===------------------------------------------------------------------===//

  /// \brief Return metadata containing two branch weights.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createBranchWeights">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 37,
   FQN="llvm::MDBuilder::createBranchWeights", NM="_ZN4llvm9MDBuilder19createBranchWeightsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder19createBranchWeightsEjj")
  //</editor-fold>
  public MDNode /*P*/ createBranchWeights(/*uint32_t*/int TrueWeight,
                     /*uint32_t*/int FalseWeight) {
    return createBranchWeights(/*{ */new ArrayRefUInt(new /*const*//*uint*/int [/*2*/] {TrueWeight, FalseWeight})/* }*/);
  }


  /// \brief Return metadata containing a number of branch weights.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createBranchWeights">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 42,
   FQN="llvm::MDBuilder::createBranchWeights", NM="_ZN4llvm9MDBuilder19createBranchWeightsENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder19createBranchWeightsENS_8ArrayRefIjEE")
  //</editor-fold>
  public MDNode /*P*/ createBranchWeights(ArrayRefUInt Weights) {
    assert ($greatereq_uint(Weights.size(), 1)) : "Need at least one branch weights!";

    SmallVector<Metadata /*P*/ > Vals/*J*/= new SmallVector<Metadata /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, Weights.size() + 1, (Metadata /*P*/ )null);
    Vals.$set(0, createString(new StringRef(/*KEEP_STR*/"branch_weights")));

    Type /*P*/ Int32Ty = Type.getInt32Ty(Context);
    for (/*uint*/int i = 0, e = Weights.size(); i != e; ++i)  {
      Vals.$set(i + 1, createConstant(ConstantInt.get(Int32Ty, $uint2ulong(Weights.$at(i)))));
    }

    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Vals, true));
  }


  /// Return metadata specifying that a branch or switch is unpredictable.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createUnpredictable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 55,
   FQN="llvm::MDBuilder::createUnpredictable", NM="_ZN4llvm9MDBuilder19createUnpredictableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder19createUnpredictableEv")
  //</editor-fold>
  public MDNode /*P*/ createUnpredictable() {
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(None, true));
  }


  /// Return metadata containing the entry count for a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createFunctionEntryCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 59,
   FQN="llvm::MDBuilder::createFunctionEntryCount", NM="_ZN4llvm9MDBuilder24createFunctionEntryCountEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder24createFunctionEntryCountEy")
  //</editor-fold>
  public MDNode /*P*/ createFunctionEntryCount(long/*uint64_t*/ Count) {
    Type /*P*/ Int64Ty = Type.getInt64Ty(Context);
    return MDNode.get(Context,
        /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*2*/] {
              createString(new StringRef(/*KEEP_STR*/"function_entry_count")),
              createConstant(ConstantInt.get(Int64Ty, Count))}, true)/* }*/);
  }


  //===------------------------------------------------------------------===//
  // Range metadata.
  //===------------------------------------------------------------------===//

  /// \brief Return metadata describing the range [Lo, Hi).
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 66,
   FQN="llvm::MDBuilder::createRange", NM="_ZN4llvm9MDBuilder11createRangeERKNS_5APIntES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder11createRangeERKNS_5APIntES3_")
  //</editor-fold>
  public MDNode /*P*/ createRange(final /*const*/ APInt /*&*/ Lo, final /*const*/ APInt /*&*/ Hi) {
    assert (Lo.getBitWidth() == Hi.getBitWidth()) : "Mismatched bitwidths!";

    Type /*P*/ Ty = IntegerType.get(Context, Lo.getBitWidth());
    return createRange(ConstantInt.get(Ty, Lo), ConstantInt.get(Ty, Hi));
  }


  /// \brief Return metadata describing the range [Lo, Hi).
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 73,
   FQN="llvm::MDBuilder::createRange", NM="_ZN4llvm9MDBuilder11createRangeEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder11createRangeEPNS_8ConstantES2_")
  //</editor-fold>
  public MDNode /*P*/ createRange(Constant /*P*/ Lo, Constant /*P*/ Hi) {
    // If the range is everything then it is useless.
    if (Hi == Lo) {
      return null;
    }

    // Return the range [Lo, Hi).
    return MDNode.get(Context, /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*2*/] {createConstant(Lo), createConstant(Hi)}, true)/* }*/);
  }


  //===------------------------------------------------------------------===//
  // AA metadata.
  //===------------------------------------------------------------------===//
  /*protected:*/
  /// \brief Return metadata appropriate for a AA root node (scope or TBAA).
  /// Each returned node is distinct from all other metadata and will never
  /// be identified (uniqued) with anything else.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createAnonymousAARoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 82,
   FQN="llvm::MDBuilder::createAnonymousAARoot", NM="_ZN4llvm9MDBuilder21createAnonymousAARootENS_9StringRefEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder21createAnonymousAARootENS_9StringRefEPNS_6MDNodeE")
  //</editor-fold>
  protected MDNode /*P*/ createAnonymousAARoot() {
    return createAnonymousAARoot(new StringRef(), (MDNode /*P*/ )null);
  }
  protected MDNode /*P*/ createAnonymousAARoot(StringRef Name/*= StringRef()*/) {
    return createAnonymousAARoot(Name, (MDNode /*P*/ )null);
  }
  protected MDNode /*P*/ createAnonymousAARoot(StringRef Name/*= StringRef()*/, MDNode /*P*/ Extra/*= null*/) {
    std.unique_ptr_with_deleter<MDTuple/*,TempMDNodeDeleter*/> Dummy = null;
    try {
      // To ensure uniqueness the root node is self-referential.
      Dummy = MDNode.getTemporary(Context, new ArrayRef<Metadata /*P*/ >(None, true));

      SmallVector<Metadata /*P*/ > Args/*J*/= new SmallVector<Metadata /*P*/ >(JD$UInt_T$C$R.INSTANCE, 3, 1, Dummy.get(), (Metadata /*P*/ )null);
      if ((Extra != null)) {
        Args.push_back(Extra);
      }
      if (!Name.empty()) {
        Args.push_back(createString(new StringRef(Name)));
      }
      MDNode /*P*/ Root = MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Args, true));

      // At this point we have
      //   !0 = metadata !{}            <- dummy
      //   !1 = metadata !{metadata !0} <- root
      // Replace the dummy operand with the root node itself and delete the dummy.
      Root.replaceOperandWith(0, Root);

      // We now have
      //   !1 = metadata !{metadata !1} <- self-referential root
      return Root;
    } finally {
      if (Dummy != null) { Dummy.$destroy(); }
    }
  }

/*public:*/
  /// \brief Return metadata appropriate for a TBAA root node. Each returned
  /// node is distinct from all other metadata and will never be identified
  /// (uniqued) with anything else.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createAnonymousTBAARoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 94,
   FQN="llvm::MDBuilder::createAnonymousTBAARoot", NM="_ZN4llvm9MDBuilder23createAnonymousTBAARootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder23createAnonymousTBAARootEv")
  //</editor-fold>
  public MDNode /*P*/ createAnonymousTBAARoot() {
    return createAnonymousAARoot();
  }


  /// \brief Return metadata appropriate for an alias scope domain node.
  /// Each returned node is distinct from all other metadata and will never
  /// be identified (uniqued) with anything else.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createAnonymousAliasScopeDomain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 101,
   FQN="llvm::MDBuilder::createAnonymousAliasScopeDomain", NM="_ZN4llvm9MDBuilder31createAnonymousAliasScopeDomainENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder31createAnonymousAliasScopeDomainENS_9StringRefE")
  //</editor-fold>
  public MDNode /*P*/ createAnonymousAliasScopeDomain() {
    return createAnonymousAliasScopeDomain(new StringRef());
  }
  public MDNode /*P*/ createAnonymousAliasScopeDomain(StringRef Name/*= StringRef()*/) {
    return createAnonymousAARoot(new StringRef(Name));
  }


  /// \brief Return metadata appropriate for an alias scope root node.
  /// Each returned node is distinct from all other metadata and will never
  /// be identified (uniqued) with anything else.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createAnonymousAliasScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 108,
   FQN="llvm::MDBuilder::createAnonymousAliasScope", NM="_ZN4llvm9MDBuilder25createAnonymousAliasScopeEPNS_6MDNodeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder25createAnonymousAliasScopeEPNS_6MDNodeENS_9StringRefE")
  //</editor-fold>
  public MDNode /*P*/ createAnonymousAliasScope(MDNode /*P*/ Domain) {
    return createAnonymousAliasScope(Domain,
                           new StringRef());
  }
  public MDNode /*P*/ createAnonymousAliasScope(MDNode /*P*/ Domain,
                           StringRef Name/*= StringRef()*/) {
    return createAnonymousAARoot(new StringRef(Name), Domain);
  }


  /// \brief Return metadata appropriate for a TBAA root node with the given
  /// name.  This may be identified (uniqued) with other roots with the same
  /// name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createTBAARoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 104,
   FQN="llvm::MDBuilder::createTBAARoot", NM="_ZN4llvm9MDBuilder14createTBAARootENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder14createTBAARootENS_9StringRefE")
  //</editor-fold>
  public MDNode /*P*/ createTBAARoot(StringRef Name) {
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(createString(new StringRef(Name)), true));
  }


  /// \brief Return metadata appropriate for an alias scope domain node with
  /// the given name. This may be identified (uniqued) with other roots with
  /// the same name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createAliasScopeDomain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 120,
   FQN="llvm::MDBuilder::createAliasScopeDomain", NM="_ZN4llvm9MDBuilder22createAliasScopeDomainENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder22createAliasScopeDomainENS_9StringRefE")
  //</editor-fold>
  public MDNode /*P*/ createAliasScopeDomain(StringRef Name) {
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(createString(new StringRef(Name)), true));
  }


  /// \brief Return metadata appropriate for an alias scope node with
  /// the given name. This may be identified (uniqued) with other scopes with
  /// the same name and domain.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createAliasScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 124,
   FQN="llvm::MDBuilder::createAliasScope", NM="_ZN4llvm9MDBuilder16createAliasScopeENS_9StringRefEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder16createAliasScopeENS_9StringRefEPNS_6MDNodeE")
  //</editor-fold>
  public MDNode /*P*/ createAliasScope(StringRef Name, MDNode /*P*/ Domain) {
    return MDNode.get(Context, /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*2*/] {createString(new StringRef(Name)), Domain}, true)/* }*/);
  }


  /// \brief Return metadata for a non-root TBAA node with the given name,
  /// parent in the TBAA tree, and value for 'pointsToConstantMemory'.

  /// \brief Return metadata for a non-root TBAA node with the given name,
  /// parent in the TBAA tree, and value for 'pointsToConstantMemory'.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createTBAANode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 110,
   FQN="llvm::MDBuilder::createTBAANode", NM="_ZN4llvm9MDBuilder14createTBAANodeENS_9StringRefEPNS_6MDNodeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder14createTBAANodeENS_9StringRefEPNS_6MDNodeEb")
  //</editor-fold>
  public MDNode /*P*/ createTBAANode(StringRef Name, MDNode /*P*/ Parent) {
    return createTBAANode(Name, Parent,
                false);
  }
  public MDNode /*P*/ createTBAANode(StringRef Name, MDNode /*P*/ Parent,
                boolean isConstant/*= false*/) {
    if (isConstant) {
      Constant /*P*/ Flags = ConstantInt.get(Type.getInt64Ty(Context), $int2ulong(1));
      return MDNode.get(Context,
          /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*3*/] {createString(new StringRef(Name)), Parent, createConstant(Flags)}, true)/* }*/);
    }
    return MDNode.get(Context, /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*2*/] {createString(new StringRef(Name)), Parent}, true)/* }*/);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::TBAAStructField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 133,
   FQN="llvm::MDBuilder::TBAAStructField", NM="_ZN4llvm9MDBuilder15TBAAStructFieldE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder15TBAAStructFieldE")
  //</editor-fold>
  public static class/*struct*/ TBAAStructField {
    public long/*uint64_t*/ Offset;
    public long/*uint64_t*/ Size;
    public MDNode /*P*/ TBAA;
    //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::TBAAStructField::TBAAStructField">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/MDBuilder.h", line = 137,
     FQN="llvm::MDBuilder::TBAAStructField::TBAAStructField", NM="_ZN4llvm9MDBuilder15TBAAStructFieldC1EyyPNS_6MDNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder15TBAAStructFieldC1EyyPNS_6MDNodeE")
    //</editor-fold>
    public TBAAStructField(long/*uint64_t*/ Offset, long/*uint64_t*/ Size, MDNode /*P*/ TBAA) {
      // : Offset(Offset), Size(Size), TBAA(TBAA)
      //START JInit
      this.Offset = Offset;
      this.Size = Size;
      this.TBAA = TBAA;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public TBAAStructField() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Offset=" + Offset // NOI18N
                + ", Size=" + Size // NOI18N
                + ", TBAA=" + TBAA; // NOI18N
    }
  };

  /// \brief Return metadata for a tbaa.struct node with the given
  /// struct field descriptions.

  /// \brief Return metadata for a tbaa.struct node with the given
  /// struct field descriptions.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createTBAAStructNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 130,
   FQN="llvm::MDBuilder::createTBAAStructNode", NM="_ZN4llvm9MDBuilder20createTBAAStructNodeENS_8ArrayRefINS0_15TBAAStructFieldEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder20createTBAAStructNodeENS_8ArrayRefINS0_15TBAAStructFieldEEE")
  //</editor-fold>
  public MDNode /*P*/ createTBAAStructNode(ArrayRef<TBAAStructField> Fields) {
    SmallVector<Metadata /*P*/ > Vals/*J*/= new SmallVector<Metadata /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, Fields.size() * 3, (Metadata /*P*/ )null);
    Type /*P*/ Int64 = Type.getInt64Ty(Context);
    for (/*uint*/int i = 0, e = Fields.size(); i != e; ++i) {
      Vals.$set(i * 3 + 0, createConstant(ConstantInt.get(Int64, Fields.$at(i).Offset)));
      Vals.$set(i * 3 + 1, createConstant(ConstantInt.get(Int64, Fields.$at(i).Size)));
      Vals.$set(i * 3 + 2, Fields.$at(i).TBAA);
    }
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Vals, true));
  }


  /// \brief Return metadata for a TBAA struct node in the type DAG
  /// with the given name, a list of pairs (offset, field type in the type DAG).

  /// \brief Return metadata for a TBAA struct node in the type DAG
  /// with the given name, a list of pairs (offset, field type in the type DAG).
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createTBAAStructTypeNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 143,
   FQN="llvm::MDBuilder::createTBAAStructTypeNode", NM="_ZN4llvm9MDBuilder24createTBAAStructTypeNodeENS_9StringRefENS_8ArrayRefISt4pairIPNS_6MDNodeEyEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder24createTBAAStructTypeNodeENS_9StringRefENS_8ArrayRefISt4pairIPNS_6MDNodeEyEEE")
  //</editor-fold>
  public MDNode /*P*/ createTBAAStructTypeNode(StringRef Name, ArrayRef<std.pairPtrULong<MDNode /*P*/ >> Fields) {
    SmallVector<Metadata /*P*/ > Ops/*J*/= new SmallVector<Metadata /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, Fields.size() * 2 + 1, (Metadata /*P*/ )null);
    Type /*P*/ Int64 = Type.getInt64Ty(Context);
    Ops.$set(0, createString(new StringRef(Name)));
    for (/*uint*/int i = 0, e = Fields.size(); i != e; ++i) {
      Ops.$set(i * 2 + 1, Fields.$at(i).first);
      Ops.$set(i * 2 + 2, createConstant(ConstantInt.get(Int64, Fields.$at(i).second)));
    }
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Ops, true));
  }


  /// \brief Return metadata for a TBAA scalar type node with the
  /// given name, an offset and a parent in the TBAA type DAG.

  /// \brief Return metadata for a TBAA scalar type node with the
  /// given name, an offset and a parent in the TBAA type DAG.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createTBAAScalarTypeNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 157,
   FQN="llvm::MDBuilder::createTBAAScalarTypeNode", NM="_ZN4llvm9MDBuilder24createTBAAScalarTypeNodeENS_9StringRefEPNS_6MDNodeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder24createTBAAScalarTypeNodeENS_9StringRefEPNS_6MDNodeEy")
  //</editor-fold>
  public MDNode /*P*/ createTBAAScalarTypeNode(StringRef Name, MDNode /*P*/ Parent) {
    return createTBAAScalarTypeNode(Name, Parent,
                          $int2ulong(0));
  }
  public MDNode /*P*/ createTBAAScalarTypeNode(StringRef Name, MDNode /*P*/ Parent,
                          long/*uint64_t*/ Offset/*= 0*/) {
    ConstantInt /*P*/ Off = ConstantInt.get(Type.getInt64Ty(Context), Offset);
    return MDNode.get(Context,
        /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*3*/] {createString(new StringRef(Name)), Parent, createConstant(Off)}, true)/* }*/);
  }


  /// \brief Return metadata for a TBAA tag node with the given
  /// base type, access type and offset relative to the base type.

  /// \brief Return metadata for a TBAA tag node with the given
  /// base type, access type and offset relative to the base type.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDBuilder::createTBAAStructTagNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp", line = 166,
   FQN="llvm::MDBuilder::createTBAAStructTagNode", NM="_ZN4llvm9MDBuilder23createTBAAStructTagNodeEPNS_6MDNodeES2_yb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/MDBuilder.cpp -nm=_ZN4llvm9MDBuilder23createTBAAStructTagNodeEPNS_6MDNodeES2_yb")
  //</editor-fold>
  public MDNode /*P*/ createTBAAStructTagNode(MDNode /*P*/ BaseType, MDNode /*P*/ AccessType,
                         long/*uint64_t*/ Offset) {
    return createTBAAStructTagNode(BaseType, AccessType,
                         Offset, false);
  }
  public MDNode /*P*/ createTBAAStructTagNode(MDNode /*P*/ BaseType, MDNode /*P*/ AccessType,
                         long/*uint64_t*/ Offset, boolean IsConstant/*= false*/) {
    IntegerType /*P*/ Int64 = Type.getInt64Ty(Context);
    ConstantInt /*P*/ Off = ConstantInt.get(Int64, Offset);
    if (IsConstant) {
      return MDNode.get(Context, /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*4*/] {
                BaseType, AccessType, createConstant(Off),
                createConstant(ConstantInt.get(Int64, $int2ulong(1)))}, true)/* }*/);
    }
    return MDNode.get(Context, /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*3*/] {BaseType, AccessType, createConstant(Off)}, true)/* }*/);
  }


  @Override public String toString() {
    return "" + "Context=" + "[LLVMContext]"; // NOI18N
  }
}
