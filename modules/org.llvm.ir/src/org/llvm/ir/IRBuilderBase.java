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


/// \brief Common base class shared among various IRBuilders.
//<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 71,
 FQN="llvm::IRBuilderBase", NM="_ZN4llvm13IRBuilderBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBaseE")
//</editor-fold>
public class IRBuilderBase implements Destructors.ClassWithDestructor {
  private DebugLoc CurDbgLocation;
/*protected:*/
  protected BasicBlock /*P*/ BB;
  protected ilist_iterator<Instruction> InsertPt;
  protected final LLVMContext /*&*/ Context;

  protected MDNode /*P*/ DefaultFPMathTag;
  protected FastMathFlags FMF;

  protected ArrayRef<OperandBundleDefT<Value /*P*/ >> DefaultOperandBundles;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::IRBuilderBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 85,
   FQN="llvm::IRBuilderBase::IRBuilderBase", NM="_ZN4llvm13IRBuilderBaseC1ERNS_11LLVMContextEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBaseC1ERNS_11LLVMContextEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public IRBuilderBase(final LLVMContext /*&*/ context) {
    this(context, (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilderBase(final LLVMContext /*&*/ context, MDNode /*P*/ FPMathTag/*= null*/) {
    this(context, FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilderBase(final LLVMContext /*&*/ context, MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : CurDbgLocation(), InsertPt(), Context(context), DefaultFPMathTag(FPMathTag), FMF(), DefaultOperandBundles(OpBundles)
    //START JInit
    this.CurDbgLocation = new DebugLoc();
    this.InsertPt = new ilist_iterator<Instruction>(new SymbolTableListTraits$Instruction());
    this./*&*/Context=/*&*/context;
    this.DefaultFPMathTag = FPMathTag;
    this.FMF = new FastMathFlags();
    this.DefaultOperandBundles = new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpBundles);
    //END JInit
    ClearInsertionPoint();
  }


  //===--------------------------------------------------------------------===//
  // Builder configuration methods
  //===--------------------------------------------------------------------===//

  /// \brief Clear the insertion point: created instructions will not be
  /// inserted into a block.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::ClearInsertionPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 98,
   FQN="llvm::IRBuilderBase::ClearInsertionPoint", NM="_ZN4llvm13IRBuilderBase19ClearInsertionPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase19ClearInsertionPointEv")
  //</editor-fold>
  public void ClearInsertionPoint() {
    BB = null;
    InsertPt.reset((Instruction)null);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::GetInsertBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 103,
   FQN="llvm::IRBuilderBase::GetInsertBlock", NM="_ZNK4llvm13IRBuilderBase14GetInsertBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase14GetInsertBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ GetInsertBlock() /*const*/ {
    return BB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::GetInsertPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 104,
   FQN="llvm::IRBuilderBase::GetInsertPoint", NM="_ZNK4llvm13IRBuilderBase14GetInsertPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase14GetInsertPointEv")
  //</editor-fold>
  public ilist_iterator<Instruction> GetInsertPoint() /*const*/ {
    return new ilist_iterator<Instruction>(InsertPt);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 105,
   FQN="llvm::IRBuilderBase::getContext", NM="_ZNK4llvm13IRBuilderBase10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return Context;
  }


  /// \brief This specifies that created instructions should be appended to the
  /// end of the specified block.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::SetInsertPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 109,
   FQN="llvm::IRBuilderBase::SetInsertPoint", NM="_ZN4llvm13IRBuilderBase14SetInsertPointEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase14SetInsertPointEPNS_10BasicBlockE")
  //</editor-fold>
  public void SetInsertPoint(BasicBlock /*P*/ TheBB) {
    BB = TheBB;
    InsertPt.$assignMove(BB.end());
  }


  /// \brief This specifies that created instructions should be inserted before
  /// the specified instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::SetInsertPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 116,
   FQN="llvm::IRBuilderBase::SetInsertPoint", NM="_ZN4llvm13IRBuilderBase14SetInsertPointEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase14SetInsertPointEPNS_11InstructionE")
  //</editor-fold>
  public void SetInsertPoint(Instruction /*P*/ I) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      BB = I.getParent();
      InsertPt.$assignMove(I.getIterator());
      assert (InsertPt.$noteq(BB.end())) : "Can't read debug loc from end()";
      SetCurrentDebugLocation($c$.track(new DebugLoc(I.getDebugLoc()))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  /// \brief This specifies that created instructions should be inserted at the
  /// specified point.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::SetInsertPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 125,
   FQN="llvm::IRBuilderBase::SetInsertPoint", NM="_ZN4llvm13IRBuilderBase14SetInsertPointEPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase14SetInsertPointEPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE")
  //</editor-fold>
  public void SetInsertPoint(BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP) {
    BB = TheBB;
    InsertPt.$assign(IP);
    if (IP.$noteq(TheBB.end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SetCurrentDebugLocation($c$.track(new DebugLoc(IP.$arrow().getDebugLoc()))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }


  /// \brief Set location information used by debugging information.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::SetCurrentDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 133,
   FQN="llvm::IRBuilderBase::SetCurrentDebugLocation", NM="_ZN4llvm13IRBuilderBase23SetCurrentDebugLocationENS_8DebugLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase23SetCurrentDebugLocationENS_8DebugLocE")
  //</editor-fold>
  public void SetCurrentDebugLocation(DebugLoc L) {
    CurDbgLocation.$assignMove(std.move(L));
  }


  /// \brief Get location information used by debugging information.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getCurrentDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 136,
   FQN="llvm::IRBuilderBase::getCurrentDebugLocation", NM="_ZNK4llvm13IRBuilderBase23getCurrentDebugLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase23getCurrentDebugLocationEv")
  //</editor-fold>
  public /*const*/ DebugLoc /*&*/ getCurrentDebugLocation() /*const*/ {
    return CurDbgLocation;
  }


  /// \brief If this builder has a current debug location, set it on the
  /// specified instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::SetInstDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 140,
   FQN="llvm::IRBuilderBase::SetInstDebugLocation", NM="_ZNK4llvm13IRBuilderBase20SetInstDebugLocationEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase20SetInstDebugLocationEPNS_11InstructionE")
  //</editor-fold>
  public void SetInstDebugLocation(Instruction /*P*/ I) /*const*/ {
    if (CurDbgLocation.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        I.setDebugLoc($c$.track(new DebugLoc(CurDbgLocation))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }


  /// \brief Get the return type of the current function that we're emitting
  /// into.

  /// \brief Get the return type of the current function that we're emitting
  /// into.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getCurrentFunctionReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 41,
   FQN="llvm::IRBuilderBase::getCurrentFunctionReturnType", NM="_ZNK4llvm13IRBuilderBase28getCurrentFunctionReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZNK4llvm13IRBuilderBase28getCurrentFunctionReturnTypeEv")
  //</editor-fold>
  public Type /*P*/ getCurrentFunctionReturnType() /*const*/ {
    assert ((BB != null) && (BB.getParent() != null)) : "No current function!";
    return BB.getParent().getReturnType();
  }



  /// InsertPoint - A saved insertion point.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 150,
   FQN="llvm::IRBuilderBase::InsertPoint", NM="_ZN4llvm13IRBuilderBase11InsertPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11InsertPointE")
  //</editor-fold>
  public static class InsertPoint {
    private BasicBlock /*P*/ Block;
    private ilist_iterator<Instruction> Point;
  /*public:*/
    /// \brief Creates a new insertion point which doesn't point to anything.
    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::InsertPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 156,
     FQN="llvm::IRBuilderBase::InsertPoint::InsertPoint", NM="_ZN4llvm13IRBuilderBase11InsertPointC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11InsertPointC1Ev")
    //</editor-fold>
    public InsertPoint() {
      // : Block(null), Point()
      //START JInit
      this.Block = null;
      this.Point = new ilist_iterator<Instruction>(new SymbolTableListTraits$Instruction());
      //END JInit
    }


    /// \brief Creates a new insertion point at the given location.
    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::InsertPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 159,
     FQN="llvm::IRBuilderBase::InsertPoint::InsertPoint", NM="_ZN4llvm13IRBuilderBase11InsertPointC1EPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11InsertPointC1EPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE")
    //</editor-fold>
    public InsertPoint(BasicBlock /*P*/ InsertBlock, ilist_iterator<Instruction> InsertPoint) {
      // : Block(InsertBlock), Point(InsertPoint)
      //START JInit
      this.Block = InsertBlock;
      this.Point = new ilist_iterator<Instruction>(InsertPoint);
      //END JInit
    }


    /// \brief Returns true if this insert point is set.
    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::isSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 163,
     FQN="llvm::IRBuilderBase::InsertPoint::isSet", NM="_ZNK4llvm13IRBuilderBase11InsertPoint5isSetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase11InsertPoint5isSetEv")
    //</editor-fold>
    public boolean isSet() /*const*/ {
      return (Block != null);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::getBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 165,
     FQN="llvm::IRBuilderBase::InsertPoint::getBlock", NM="_ZNK4llvm13IRBuilderBase11InsertPoint8getBlockEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase11InsertPoint8getBlockEv")
    //</editor-fold>
    public BasicBlock /*P*/ getBlock() /*const*/ {
      return Block;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::getPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 166,
     FQN="llvm::IRBuilderBase::InsertPoint::getPoint", NM="_ZNK4llvm13IRBuilderBase11InsertPoint8getPointEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase11InsertPoint8getPointEv")
    //</editor-fold>
    public ilist_iterator<Instruction> getPoint() /*const*/ {
      return new ilist_iterator<Instruction>(Point);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::InsertPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 150,
     FQN="llvm::IRBuilderBase::InsertPoint::InsertPoint", NM="_ZN4llvm13IRBuilderBase11InsertPointC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11InsertPointC1ERKS1_")
    //</editor-fold>
    public /*inline*/ InsertPoint(final /*const*/ InsertPoint /*&*/ $Prm0) {
      // : Block(.Block), Point(.Point)
      //START JInit
      this.Block = $Prm0.Block;
      this.Point = new ilist_iterator<Instruction>($Prm0.Point);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::InsertPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 150,
     FQN="llvm::IRBuilderBase::InsertPoint::InsertPoint", NM="_ZN4llvm13IRBuilderBase11InsertPointC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11InsertPointC1EOS1_")
    //</editor-fold>
    public /*inline*/ InsertPoint(JD$Move _dparam, final InsertPoint /*&&*/$Prm0) {
      // : Block(static_cast<InsertPoint &&>().Block), Point(static_cast<InsertPoint &&>().Point)
      //START JInit
      this.Block = $Prm0.Block;
      this.Point = new ilist_iterator<Instruction>(JD$Move.INSTANCE, $Prm0.Point);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPoint::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 150,
     FQN="llvm::IRBuilderBase::InsertPoint::operator=", NM="_ZN4llvm13IRBuilderBase11InsertPointaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11InsertPointaSEOS1_")
    //</editor-fold>
    public /*inline*/ InsertPoint /*&*/ $assignMove(final InsertPoint /*&&*/$Prm0) {
      this.Block = $Prm0.Block;
      this.Point.$assignMove($Prm0.Point);
      return /*Deref*/this;
    }


    @Override public String toString() {
      return "" + "Block=" + Block // NOI18N
                + ", Point=" + Point; // NOI18N
    }
  };

  /// \brief Returns the current insert point.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::saveIP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 170,
   FQN="llvm::IRBuilderBase::saveIP", NM="_ZNK4llvm13IRBuilderBase6saveIPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase6saveIPEv")
  //</editor-fold>
  public InsertPoint saveIP() /*const*/ {
    return new InsertPoint(GetInsertBlock(), GetInsertPoint());
  }


  /// \brief Returns the current insert point, clearing it in the process.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::saveAndClearIP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 175,
   FQN="llvm::IRBuilderBase::saveAndClearIP", NM="_ZN4llvm13IRBuilderBase14saveAndClearIPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase14saveAndClearIPEv")
  //</editor-fold>
  public InsertPoint saveAndClearIP() {
    InsertPoint IP/*J*/= new InsertPoint(GetInsertBlock(), GetInsertPoint());
    ClearInsertionPoint();
    return IP;
  }


  /// \brief Sets the current insert point to a previously-saved location.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::restoreIP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 182,
   FQN="llvm::IRBuilderBase::restoreIP", NM="_ZN4llvm13IRBuilderBase9restoreIPENS0_11InsertPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase9restoreIPENS0_11InsertPointE")
  //</editor-fold>
  public void restoreIP(InsertPoint IP) {
    if (IP.isSet()) {
      SetInsertPoint(IP.getBlock(), IP.getPoint());
    } else {
      ClearInsertionPoint();
    }
  }


  /// \brief Get the floating point math metadata being used.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getDefaultFPMathTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 190,
   FQN="llvm::IRBuilderBase::getDefaultFPMathTag", NM="_ZNK4llvm13IRBuilderBase19getDefaultFPMathTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase19getDefaultFPMathTagEv")
  //</editor-fold>
  public MDNode /*P*/ getDefaultFPMathTag() /*const*/ {
    return DefaultFPMathTag;
  }


  /// \brief Get the flags to be applied to created floating point ops
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 193,
   FQN="llvm::IRBuilderBase::getFastMathFlags", NM="_ZNK4llvm13IRBuilderBase16getFastMathFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK4llvm13IRBuilderBase16getFastMathFlagsEv")
  //</editor-fold>
  public FastMathFlags getFastMathFlags() /*const*/ {
    return new FastMathFlags(FMF);
  }


  /// \brief Clear the fast-math flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::clearFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 196,
   FQN="llvm::IRBuilderBase::clearFastMathFlags", NM="_ZN4llvm13IRBuilderBase18clearFastMathFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase18clearFastMathFlagsEv")
  //</editor-fold>
  public void clearFastMathFlags() {
    FMF.clear();
  }


  /// \brief Set the floating point math metadata to be used.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::setDefaultFPMathTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 199,
   FQN="llvm::IRBuilderBase::setDefaultFPMathTag", NM="_ZN4llvm13IRBuilderBase19setDefaultFPMathTagEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase19setDefaultFPMathTagEPNS_6MDNodeE")
  //</editor-fold>
  public void setDefaultFPMathTag(MDNode /*P*/ FPMathTag) {
    DefaultFPMathTag = FPMathTag;
  }


  /// \brief Set the fast-math flags to be used with generated fp-math operators
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::setFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 202,
   FQN="llvm::IRBuilderBase::setFastMathFlags", NM="_ZN4llvm13IRBuilderBase16setFastMathFlagsENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase16setFastMathFlagsENS_13FastMathFlagsE")
  //</editor-fold>
  public void setFastMathFlags(FastMathFlags NewFMF) {
    FMF.$assign(NewFMF);
  }


  //===--------------------------------------------------------------------===//
  // RAII helpers.
  //===--------------------------------------------------------------------===//

  // \brief RAII object that stores the current insertion point and restores it
  // when the object is destroyed. This includes the debug location.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPointGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 210,
   FQN="llvm::IRBuilderBase::InsertPointGuard", NM="_ZN4llvm13IRBuilderBase16InsertPointGuardE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase16InsertPointGuardE")
  //</editor-fold>
  public static class InsertPointGuard implements Destructors.ClassWithDestructor {
    private final IRBuilderBase /*&*/ Builder;
    private AssertingVH<BasicBlock> Block;
    private ilist_iterator<Instruction> Point;
    private DebugLoc DbgLoc;

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPointGuard::InsertPointGuard">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 216,
     FQN="llvm::IRBuilderBase::InsertPointGuard::InsertPointGuard", NM="_ZN4llvm13IRBuilderBase16InsertPointGuardC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase16InsertPointGuardC1ERKS1_")
    //</editor-fold>
    protected/*private*/ InsertPointGuard(final /*const*/ InsertPointGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPointGuard::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 217,
     FQN="llvm::IRBuilderBase::InsertPointGuard::operator=", NM="_ZN4llvm13IRBuilderBase16InsertPointGuardaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase16InsertPointGuardaSERKS1_")
    //</editor-fold>
    protected/*private*/ InsertPointGuard /*&*/ $assign(final /*const*/ InsertPointGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPointGuard::InsertPointGuard">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 220,
     FQN="llvm::IRBuilderBase::InsertPointGuard::InsertPointGuard", NM="_ZN4llvm13IRBuilderBase16InsertPointGuardC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase16InsertPointGuardC1ERS0_")
    //</editor-fold>
    public InsertPointGuard(final IRBuilderBase /*&*/ B) {
      // : Builder(B), Block(B.GetInsertBlock()), Point(B.GetInsertPoint()), DbgLoc(B.getCurrentDebugLocation())
      //START JInit
      this./*&*/Builder=/*&*/B;
      this.Block = new AssertingVH<BasicBlock>(B.GetInsertBlock());
      this.Point = B.GetInsertPoint();
      this.DbgLoc = new DebugLoc(B.getCurrentDebugLocation());
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::InsertPointGuard::~InsertPointGuard">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 224,
     FQN="llvm::IRBuilderBase::InsertPointGuard::~InsertPointGuard", NM="_ZN4llvm13IRBuilderBase16InsertPointGuardD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase16InsertPointGuardD0Ev")
    //</editor-fold>
    public void $destroy() {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Builder.restoreIP(new InsertPoint(Block.$T$P(), new ilist_iterator<Instruction>(Point)));
        Builder.SetCurrentDebugLocation($c$.track(new DebugLoc(DbgLoc))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
      //START JDestroy
      DbgLoc.$destroy();
      Block.$destroy();
      //END JDestroy
    }


    @Override public String toString() {
      return "" + "Builder=" + Builder // NOI18N
                + ", Block=" + Block // NOI18N
                + ", Point=" + Point // NOI18N
                + ", DbgLoc=" + DbgLoc; // NOI18N
    }
  };

  // \brief RAII object that stores the current fast math settings and restores
  // them when the object is destroyed.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::FastMathFlagGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 232,
   FQN="llvm::IRBuilderBase::FastMathFlagGuard", NM="_ZN4llvm13IRBuilderBase17FastMathFlagGuardE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase17FastMathFlagGuardE")
  //</editor-fold>
  public static class FastMathFlagGuard implements Destructors.ClassWithDestructor {
    private final IRBuilderBase /*&*/ Builder;
    private FastMathFlags FMF;
    private MDNode /*P*/ FPMathTag;

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::FastMathFlagGuard::FastMathFlagGuard">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 237,
     FQN="llvm::IRBuilderBase::FastMathFlagGuard::FastMathFlagGuard", NM="_ZN4llvm13IRBuilderBase17FastMathFlagGuardC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase17FastMathFlagGuardC1ERKS1_")
    //</editor-fold>
    protected/*private*/ FastMathFlagGuard(final /*const*/ FastMathFlagGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::FastMathFlagGuard::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 238,
     FQN="llvm::IRBuilderBase::FastMathFlagGuard::operator=", NM="_ZN4llvm13IRBuilderBase17FastMathFlagGuardaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase17FastMathFlagGuardaSERKS1_")
    //</editor-fold>
    protected/*private*/ FastMathFlagGuard /*&*/ $assign(final /*const*/ FastMathFlagGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::FastMathFlagGuard::FastMathFlagGuard">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 242,
     FQN="llvm::IRBuilderBase::FastMathFlagGuard::FastMathFlagGuard", NM="_ZN4llvm13IRBuilderBase17FastMathFlagGuardC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase17FastMathFlagGuardC1ERS0_")
    //</editor-fold>
    public FastMathFlagGuard(final IRBuilderBase /*&*/ B) {
      // : Builder(B), FMF(B.FMF), FPMathTag(B.DefaultFPMathTag)
      //START JInit
      this./*&*/Builder=/*&*/B;
      this.FMF = new FastMathFlags(B.FMF);
      this.FPMathTag = B.DefaultFPMathTag;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::FastMathFlagGuard::~FastMathFlagGuard">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 245,
     FQN="llvm::IRBuilderBase::FastMathFlagGuard::~FastMathFlagGuard", NM="_ZN4llvm13IRBuilderBase17FastMathFlagGuardD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase17FastMathFlagGuardD0Ev")
    //</editor-fold>
    public void $destroy() {
      Builder.FMF.$assign(FMF);
      Builder.DefaultFPMathTag = FPMathTag;
    }


    @Override public String toString() {
      return "" + "Builder=" + Builder // NOI18N
                + ", FMF=" + FMF // NOI18N
                + ", FPMathTag=" + FPMathTag; // NOI18N
    }
  };

  //===--------------------------------------------------------------------===//
  // Miscellaneous creation methods.
  //===--------------------------------------------------------------------===//

  /// \brief Make a new global variable with initializer type i8*
  ///
  /// Make a new global variable with an initializer that has array of i8 type
  /// filled in with the null terminated string value specified.  The new global
  /// variable will be marked mergable with any others of the same contents.  If
  /// Name is specified, it is the name of the global variable created.

  //===--------------------------------------------------------------------===//
  // Miscellaneous creation methods.
  //===--------------------------------------------------------------------===//

  /// \brief Make a new global variable with initializer type i8*
  ///
  /// Make a new global variable with an initializer that has array of i8 type
  /// filled in with the null terminated string value specified.  The new global
  /// variable will be marked mergable with any others of the same contents.  If
  /// Name is specified, it is the name of the global variable created.

  /// CreateGlobalString - Make a new global variable with an initializer that
  /// has array of i8 type filled in with the nul terminated string value
  /// specified.  If Name is specified, it is the name of the global variable
  /// created.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGlobalString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 27,
   FQN="llvm::IRBuilderBase::CreateGlobalString", NM="_ZN4llvm13IRBuilderBase18CreateGlobalStringENS_9StringRefERKNS_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase18CreateGlobalStringENS_9StringRefERKNS_5TwineEj")
  //</editor-fold>
  public GlobalVariable /*P*/ CreateGlobalString(StringRef Str) {
    return CreateGlobalString(Str,
                    new Twine(/*KEEP_STR*/$EMPTY),
                    0);
  }
  public GlobalVariable /*P*/ CreateGlobalString(StringRef Str,
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateGlobalString(Str,
                    Name,
                    0);
  }
  public GlobalVariable /*P*/ CreateGlobalString(StringRef Str,
                    final /*const*/ Twine /*&*/ Name/*= ""*/,
                    /*uint*/int AddressSpace/*= 0*/) {
    Constant /*P*/ StrConstant = ConstantDataArray.getString(Context, new StringRef(Str));
    final Module /*&*/ M = $Deref(BB.getParent().getParent());
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(M, StrConstant.getType(),
                true, GlobalValue.LinkageTypes.PrivateLinkage,
                StrConstant, Name, (GlobalVariable /*P*/ )null,
                GlobalVariable.ThreadLocalMode.NotThreadLocal,
                AddressSpace);
     });
    GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    return GV;
  }



  /// \brief Get a constant value representing either true or false.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 265,
   FQN="llvm::IRBuilderBase::getInt1", NM="_ZN4llvm13IRBuilderBase7getInt1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase7getInt1Eb")
  //</editor-fold>
  public ConstantInt /*P*/ getInt1(boolean V) {
    return ConstantInt.get(getInt1Ty(), (V ? 1 : 0));
  }


  /// \brief Get the constant value for i1 true.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 270,
   FQN="llvm::IRBuilderBase::getTrue", NM="_ZN4llvm13IRBuilderBase7getTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase7getTrueEv")
  //</editor-fold>
  public ConstantInt /*P*/ getTrue() {
    return ConstantInt.getTrue(Context);
  }


  /// \brief Get the constant value for i1 false.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getFalse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 275,
   FQN="llvm::IRBuilderBase::getFalse", NM="_ZN4llvm13IRBuilderBase8getFalseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase8getFalseEv")
  //</editor-fold>
  public ConstantInt /*P*/ getFalse() {
    return ConstantInt.getFalse(Context);
  }


  /// \brief Get a constant 8-bit value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 280,
   FQN="llvm::IRBuilderBase::getInt8", NM="_ZN4llvm13IRBuilderBase7getInt8Eh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase7getInt8Eh")
  //</editor-fold>
  public ConstantInt /*P*/ getInt8(byte/*uint8_t*/ C) {
    return ConstantInt.get(getInt8Ty(), $uchar2ulong(C));
  }


  /// \brief Get a constant 16-bit value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 285,
   FQN="llvm::IRBuilderBase::getInt16", NM="_ZN4llvm13IRBuilderBase8getInt16Et",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase8getInt16Et")
  //</editor-fold>
  public ConstantInt /*P*/ getInt16(/*uint16_t*/char C) {
    return ConstantInt.get(getInt16Ty(), $ushort2ulong(C));
  }


  /// \brief Get a constant 32-bit value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 290,
   FQN="llvm::IRBuilderBase::getInt32", NM="_ZN4llvm13IRBuilderBase8getInt32Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase8getInt32Ej")
  //</editor-fold>
  public ConstantInt /*P*/ getInt32(/*uint32_t*/int C) {
    return ConstantInt.get(getInt32Ty(), $uint2ulong(C));
  }


  /// \brief Get a constant 64-bit value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 295,
   FQN="llvm::IRBuilderBase::getInt64", NM="_ZN4llvm13IRBuilderBase8getInt64Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase8getInt64Ey")
  //</editor-fold>
  public ConstantInt /*P*/ getInt64(long/*uint64_t*/ C) {
    return ConstantInt.get(getInt64Ty(), C);
  }


  /// \brief Get a constant N-bit value, zero extended or truncated from
  /// a 64-bit value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getIntN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 301,
   FQN="llvm::IRBuilderBase::getIntN", NM="_ZN4llvm13IRBuilderBase7getIntNEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase7getIntNEjy")
  //</editor-fold>
  public ConstantInt /*P*/ getIntN(/*uint*/int N, long/*uint64_t*/ C) {
    return ConstantInt.get(getIntNTy(N), C);
  }


  /// \brief Get a constant integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 306,
   FQN="llvm::IRBuilderBase::getInt", NM="_ZN4llvm13IRBuilderBase6getIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase6getIntERKNS_5APIntE")
  //</editor-fold>
  public ConstantInt /*P*/ getInt(final /*const*/ APInt /*&*/ AI) {
    return ConstantInt.get(Context, AI);
  }


  //===--------------------------------------------------------------------===//
  // Type creation methods
  //===--------------------------------------------------------------------===//

  /// \brief Fetch the type representing a single bit
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt1Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 315,
   FQN="llvm::IRBuilderBase::getInt1Ty", NM="_ZN4llvm13IRBuilderBase9getInt1TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase9getInt1TyEv")
  //</editor-fold>
  public IntegerType /*P*/ getInt1Ty() {
    return Type.getInt1Ty(Context);
  }


  /// \brief Fetch the type representing an 8-bit integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt8Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 320,
   FQN="llvm::IRBuilderBase::getInt8Ty", NM="_ZN4llvm13IRBuilderBase9getInt8TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase9getInt8TyEv")
  //</editor-fold>
  public IntegerType /*P*/ getInt8Ty() {
    return Type.getInt8Ty(Context);
  }


  /// \brief Fetch the type representing a 16-bit integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt16Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 325,
   FQN="llvm::IRBuilderBase::getInt16Ty", NM="_ZN4llvm13IRBuilderBase10getInt16TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase10getInt16TyEv")
  //</editor-fold>
  public IntegerType /*P*/ getInt16Ty() {
    return Type.getInt16Ty(Context);
  }


  /// \brief Fetch the type representing a 32-bit integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt32Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 330,
   FQN="llvm::IRBuilderBase::getInt32Ty", NM="_ZN4llvm13IRBuilderBase10getInt32TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase10getInt32TyEv")
  //</editor-fold>
  public IntegerType /*P*/ getInt32Ty() {
    return Type.getInt32Ty(Context);
  }


  /// \brief Fetch the type representing a 64-bit integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt64Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 335,
   FQN="llvm::IRBuilderBase::getInt64Ty", NM="_ZN4llvm13IRBuilderBase10getInt64TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase10getInt64TyEv")
  //</editor-fold>
  public IntegerType /*P*/ getInt64Ty() {
    return Type.getInt64Ty(Context);
  }


  /// \brief Fetch the type representing a 128-bit integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt128Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 340,
   FQN="llvm::IRBuilderBase::getInt128Ty", NM="_ZN4llvm13IRBuilderBase11getInt128TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11getInt128TyEv")
  //</editor-fold>
  public IntegerType /*P*/ getInt128Ty() {
    return Type.getInt128Ty(Context);
  }


  /// \brief Fetch the type representing an N-bit integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getIntNTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 343,
   FQN="llvm::IRBuilderBase::getIntNTy", NM="_ZN4llvm13IRBuilderBase9getIntNTyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase9getIntNTyEj")
  //</editor-fold>
  public IntegerType /*P*/ getIntNTy(/*uint*/int N) {
    return Type.getIntNTy(Context, N);
  }


  /// \brief Fetch the type representing a 16-bit floating point value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getHalfTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 348,
   FQN="llvm::IRBuilderBase::getHalfTy", NM="_ZN4llvm13IRBuilderBase9getHalfTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase9getHalfTyEv")
  //</editor-fold>
  public Type /*P*/ getHalfTy() {
    return Type.getHalfTy(Context);
  }


  /// \brief Fetch the type representing a 32-bit floating point value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getFloatTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 353,
   FQN="llvm::IRBuilderBase::getFloatTy", NM="_ZN4llvm13IRBuilderBase10getFloatTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase10getFloatTyEv")
  //</editor-fold>
  public Type /*P*/ getFloatTy() {
    return Type.getFloatTy(Context);
  }


  /// \brief Fetch the type representing a 64-bit floating point value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getDoubleTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 358,
   FQN="llvm::IRBuilderBase::getDoubleTy", NM="_ZN4llvm13IRBuilderBase11getDoubleTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11getDoubleTyEv")
  //</editor-fold>
  public Type /*P*/ getDoubleTy() {
    return Type.getDoubleTy(Context);
  }


  /// \brief Fetch the type representing void.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getVoidTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 363,
   FQN="llvm::IRBuilderBase::getVoidTy", NM="_ZN4llvm13IRBuilderBase9getVoidTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase9getVoidTyEv")
  //</editor-fold>
  public Type /*P*/ getVoidTy() {
    return Type.getVoidTy(Context);
  }


  /// \brief Fetch the type representing a pointer to an 8-bit integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getInt8PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 368,
   FQN="llvm::IRBuilderBase::getInt8PtrTy", NM="_ZN4llvm13IRBuilderBase12getInt8PtrTyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase12getInt8PtrTyEj")
  //</editor-fold>
  public PointerType /*P*/ getInt8PtrTy() {
    return getInt8PtrTy(0);
  }
  public PointerType /*P*/ getInt8PtrTy(/*uint*/int AddrSpace/*= 0*/) {
    return Type.getInt8PtrTy(Context, AddrSpace);
  }


  /// \brief Fetch the type representing a pointer to an integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getIntPtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 373,
   FQN="llvm::IRBuilderBase::getIntPtrTy", NM="_ZN4llvm13IRBuilderBase11getIntPtrTyERKNS_10DataLayoutEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase11getIntPtrTyERKNS_10DataLayoutEj")
  //</editor-fold>
  public IntegerType /*P*/ getIntPtrTy(final /*const*/ DataLayout /*&*/ DL) {
    return getIntPtrTy(DL, 0);
  }
  public IntegerType /*P*/ getIntPtrTy(final /*const*/ DataLayout /*&*/ DL, /*uint*/int AddrSpace/*= 0*/) {
    return DL.getIntPtrType(Context, AddrSpace);
  }


  //===--------------------------------------------------------------------===//
  // Intrinsic creation methods
  //===--------------------------------------------------------------------===//

  /// \brief Create and insert a memset to the specified pointer and the
  /// specified value.
  ///
  /// If the pointer isn't an i8*, it will be converted. If a TBAA tag is
  /// specified, it will be added to the instruction. Likewise with alias.scope
  /// and noalias tags.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMemSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 387,
   FQN="llvm::IRBuilderBase::CreateMemSet", NM="_ZN4llvm13IRBuilderBase12CreateMemSetEPNS_5ValueES2_yjbPNS_6MDNodeES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase12CreateMemSetEPNS_5ValueES2_yjbPNS_6MDNodeES4_S4_")
  //</editor-fold>
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, long/*uint64_t*/ Size, /*uint*/int Align) {
    return CreateMemSet(Ptr, Val, Size, Align,
              false, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/) {
    return CreateMemSet(Ptr, Val, Size, Align,
              isVolatile, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/) {
    return CreateMemSet(Ptr, Val, Size, Align,
              isVolatile, TBAATag,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
              MDNode /*P*/ ScopeTag/*= null*/) {
    return CreateMemSet(Ptr, Val, Size, Align,
              isVolatile, TBAATag,
              ScopeTag,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
              MDNode /*P*/ ScopeTag/*= null*/,
              MDNode /*P*/ NoAliasTag/*= null*/) {
    return CreateMemSet(Ptr, Val, getInt64(Size), Align, isVolatile,
        TBAATag, ScopeTag, NoAliasTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMemSet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 81,
   FQN="llvm::IRBuilderBase::CreateMemSet", NM="_ZN4llvm13IRBuilderBase12CreateMemSetEPNS_5ValueES2_S2_jbPNS_6MDNodeES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase12CreateMemSetEPNS_5ValueES2_S2_jbPNS_6MDNodeES4_S4_")
  //</editor-fold>
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, Value /*P*/ Size, /*uint*/int Align) {
    return CreateMemSet(Ptr, Val, Size, Align,
              false, (MDNode /*P*/ )null, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/) {
    return CreateMemSet(Ptr, Val, Size, Align,
              isVolatile, (MDNode /*P*/ )null, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/) {
    return CreateMemSet(Ptr, Val, Size, Align,
              isVolatile, TBAATag, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ ScopeTag/*= null*/) {
    return CreateMemSet(Ptr, Val, Size, Align,
              isVolatile, TBAATag, ScopeTag,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemSet(Value /*P*/ Ptr, Value /*P*/ Val, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ ScopeTag/*= null*/,
              MDNode /*P*/ NoAliasTag/*= null*/) {
    Ptr = getCastedInt8PtrValue(Ptr);
    Value /*P*/ Ops[/*5*/] = new Value /*P*/  [/*5*/] {Ptr, Val, Size, getInt32(Align), getInt1(isVolatile)};
    Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ptr.getType(), Size.getType()};
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ TheFn = IntrinsicGlobals.getDeclaration(M, ID.memset, new ArrayRef<Type /*P*/ >(Tys, true));

    CallInst /*P*/ CI = IRBuilderStatics.createCallHelper(TheFn, new ArrayRef<Value /*P*/ >(Ops, true), this);

    // Set the TBAA info if present.
    if ((TBAATag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), TBAATag);
    }
    if ((ScopeTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_alias_scope.getValue(), ScopeTag);
    }
    if ((NoAliasTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_noalias.getValue(), NoAliasTag);
    }

    return CI;
  }



  /// \brief Create and insert a memcpy between the specified pointers.
  ///
  /// If the pointers aren't i8*, they will be converted.  If a TBAA tag is
  /// specified, it will be added to the instruction. Likewise with alias.scope
  /// and noalias tags.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMemCpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 405,
   FQN="llvm::IRBuilderBase::CreateMemCpy", NM="_ZN4llvm13IRBuilderBase12CreateMemCpyEPNS_5ValueES2_yjbPNS_6MDNodeES4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase12CreateMemCpyEPNS_5ValueES2_yjbPNS_6MDNodeES4_S4_S4_")
  //</editor-fold>
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align) {
    return CreateMemCpy(Dst, Src, Size, Align,
              false, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, TBAATag,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
              MDNode /*P*/ TBAAStructTag/*= null*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, TBAATag,
              TBAAStructTag,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
              MDNode /*P*/ TBAAStructTag/*= null*/,
              MDNode /*P*/ ScopeTag/*= null*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, TBAATag,
              TBAAStructTag,
              ScopeTag,
              (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
              MDNode /*P*/ TBAAStructTag/*= null*/,
              MDNode /*P*/ ScopeTag/*= null*/,
              MDNode /*P*/ NoAliasTag/*= null*/) {
    return CreateMemCpy(Dst, Src, getInt64(Size), Align, isVolatile, TBAATag,
        TBAAStructTag, ScopeTag, NoAliasTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMemCpy">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 106,
   FQN="llvm::IRBuilderBase::CreateMemCpy", NM="_ZN4llvm13IRBuilderBase12CreateMemCpyEPNS_5ValueES2_S2_jbPNS_6MDNodeES4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase12CreateMemCpyEPNS_5ValueES2_S2_jbPNS_6MDNodeES4_S4_S4_")
  //</editor-fold>
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align) {
    return CreateMemCpy(Dst, Src, Size, Align,
              false, (MDNode /*P*/ )null, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, (MDNode /*P*/ )null, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, TBAATag, (MDNode /*P*/ )null,
              (MDNode /*P*/ )null, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ TBAAStructTag/*= null*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, TBAATag, TBAAStructTag,
              (MDNode /*P*/ )null, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ TBAAStructTag/*= null*/,
              MDNode /*P*/ ScopeTag/*= null*/) {
    return CreateMemCpy(Dst, Src, Size, Align,
              isVolatile, TBAATag, TBAAStructTag,
              ScopeTag, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
              boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ TBAAStructTag/*= null*/,
              MDNode /*P*/ ScopeTag/*= null*/, MDNode /*P*/ NoAliasTag/*= null*/) {
    Dst = getCastedInt8PtrValue(Dst);
    Src = getCastedInt8PtrValue(Src);

    Value /*P*/ Ops[/*5*/] = new Value /*P*/  [/*5*/] {Dst, Src, Size, getInt32(Align), getInt1(isVolatile)};
    Type /*P*/ Tys[/*3*/] = new Type /*P*/  [/*3*/] {Dst.getType(), Src.getType(), Size.getType()};
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ TheFn = IntrinsicGlobals.getDeclaration(M, ID.memcpy, new ArrayRef<Type /*P*/ >(Tys, true));

    CallInst /*P*/ CI = IRBuilderStatics.createCallHelper(TheFn, new ArrayRef<Value /*P*/ >(Ops, true), this);

    // Set the TBAA info if present.
    if ((TBAATag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), TBAATag);
    }

    // Set the TBAA Struct info if present.
    if ((TBAAStructTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa_struct.getValue(), TBAAStructTag);
    }
    if ((ScopeTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_alias_scope.getValue(), ScopeTag);
    }
    if ((NoAliasTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_noalias.getValue(), NoAliasTag);
    }

    return CI;
  }



  /// \brief Create and insert a memmove between the specified
  /// pointers.
  ///
  /// If the pointers aren't i8*, they will be converted.  If a TBAA tag is
  /// specified, it will be added to the instruction. Likewise with alias.scope
  /// and noalias tags.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMemMove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 426,
   FQN="llvm::IRBuilderBase::CreateMemMove", NM="_ZN4llvm13IRBuilderBase13CreateMemMoveEPNS_5ValueES2_yjbPNS_6MDNodeES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBase13CreateMemMoveEPNS_5ValueES2_yjbPNS_6MDNodeES4_S4_")
  //</editor-fold>
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align) {
    return CreateMemMove(Dst, Src, Size, Align,
               false, (MDNode /*P*/ )null,
               (MDNode /*P*/ )null,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/) {
    return CreateMemMove(Dst, Src, Size, Align,
               isVolatile, (MDNode /*P*/ )null,
               (MDNode /*P*/ )null,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/) {
    return CreateMemMove(Dst, Src, Size, Align,
               isVolatile, TBAATag,
               (MDNode /*P*/ )null,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
               MDNode /*P*/ ScopeTag/*= null*/) {
    return CreateMemMove(Dst, Src, Size, Align,
               isVolatile, TBAATag,
               ScopeTag,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, long/*uint64_t*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/,
               MDNode /*P*/ ScopeTag/*= null*/,
               MDNode /*P*/ NoAliasTag/*= null*/) {
    return CreateMemMove(Dst, Src, getInt64(Size), Align, isVolatile,
        TBAATag, ScopeTag, NoAliasTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMemMove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 137,
   FQN="llvm::IRBuilderBase::CreateMemMove", NM="_ZN4llvm13IRBuilderBase13CreateMemMoveEPNS_5ValueES2_S2_jbPNS_6MDNodeES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase13CreateMemMoveEPNS_5ValueES2_S2_jbPNS_6MDNodeES4_S4_")
  //</editor-fold>
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align) {
    return CreateMemMove(Dst, Src, Size, Align,
               false, (MDNode /*P*/ )null, (MDNode /*P*/ )null,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/) {
    return CreateMemMove(Dst, Src, Size, Align,
               isVolatile, (MDNode /*P*/ )null, (MDNode /*P*/ )null,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/) {
    return CreateMemMove(Dst, Src, Size, Align,
               isVolatile, TBAATag, (MDNode /*P*/ )null,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ ScopeTag/*= null*/) {
    return CreateMemMove(Dst, Src, Size, Align,
               isVolatile, TBAATag, ScopeTag,
               (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateMemMove(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Size, /*uint*/int Align,
               boolean isVolatile/*= false*/, MDNode /*P*/ TBAATag/*= null*/, MDNode /*P*/ ScopeTag/*= null*/,
               MDNode /*P*/ NoAliasTag/*= null*/) {
    Dst = getCastedInt8PtrValue(Dst);
    Src = getCastedInt8PtrValue(Src);

    Value /*P*/ Ops[/*5*/] = new Value /*P*/  [/*5*/] {Dst, Src, Size, getInt32(Align), getInt1(isVolatile)};
    Type /*P*/ Tys[/*3*/] = new Type /*P*/  [/*3*/] {Dst.getType(), Src.getType(), Size.getType()};
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ TheFn = IntrinsicGlobals.getDeclaration(M, ID.memmove, new ArrayRef<Type /*P*/ >(Tys, true));

    CallInst /*P*/ CI = IRBuilderStatics.createCallHelper(TheFn, new ArrayRef<Value /*P*/ >(Ops, true), this);

    // Set the TBAA info if present.
    if ((TBAATag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), TBAATag);
    }
    if ((ScopeTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_alias_scope.getValue(), ScopeTag);
    }
    if ((NoAliasTag != null)) {
      CI.setMetadata(LLVMContext.Unnamed_enum.MD_noalias.getValue(), NoAliasTag);
    }

    return CI;
  }



  /// \brief Create a lifetime.start intrinsic.
  ///
  /// If the pointer isn't i8* it will be converted.

  /// \brief Create a lifetime.start intrinsic.
  ///
  /// If the pointer isn't i8* it will be converted.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateLifetimeStart">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 164,
   FQN="llvm::IRBuilderBase::CreateLifetimeStart", NM="_ZN4llvm13IRBuilderBase19CreateLifetimeStartEPNS_5ValueEPNS_11ConstantIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase19CreateLifetimeStartEPNS_5ValueEPNS_11ConstantIntE")
  //</editor-fold>
  public CallInst /*P*/ CreateLifetimeStart(Value /*P*/ Ptr) {
    return CreateLifetimeStart(Ptr, (ConstantInt /*P*/ )null);
  }
  public CallInst /*P*/ CreateLifetimeStart(Value /*P*/ Ptr, ConstantInt /*P*/ Size/*= null*/) {
    assert (isa_PointerType(Ptr.getType())) : "lifetime.start only applies to pointers.";
    Ptr = getCastedInt8PtrValue(Ptr);
    if (!(Size != null)) {
      Size = getInt64($int2ulong(-1));
    } else {
      assert (Size.getType() == getInt64Ty()) : "lifetime.start requires the size to be an i64";
    }
    Value /*P*/ Ops[/*2*/] = new Value /*P*/  [/*2*/] {Size, Ptr};
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ TheFn = IntrinsicGlobals.getDeclaration(M, ID.lifetime_start);
    return IRBuilderStatics.createCallHelper(TheFn, new ArrayRef<Value /*P*/ >(Ops, true), this);
  }



  /// \brief Create a lifetime.end intrinsic.
  ///
  /// If the pointer isn't i8* it will be converted.

  /// \brief Create a lifetime.end intrinsic.
  ///
  /// If the pointer isn't i8* it will be converted.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateLifetimeEnd">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 179,
   FQN="llvm::IRBuilderBase::CreateLifetimeEnd", NM="_ZN4llvm13IRBuilderBase17CreateLifetimeEndEPNS_5ValueEPNS_11ConstantIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase17CreateLifetimeEndEPNS_5ValueEPNS_11ConstantIntE")
  //</editor-fold>
  public CallInst /*P*/ CreateLifetimeEnd(Value /*P*/ Ptr) {
    return CreateLifetimeEnd(Ptr, (ConstantInt /*P*/ )null);
  }
  public CallInst /*P*/ CreateLifetimeEnd(Value /*P*/ Ptr, ConstantInt /*P*/ Size/*= null*/) {
    assert (isa_PointerType(Ptr.getType())) : "lifetime.end only applies to pointers.";
    Ptr = getCastedInt8PtrValue(Ptr);
    if (!(Size != null)) {
      Size = getInt64($int2ulong(-1));
    } else {
      assert (Size.getType() == getInt64Ty()) : "lifetime.end requires the size to be an i64";
    }
    Value /*P*/ Ops[/*2*/] = new Value /*P*/  [/*2*/] {Size, Ptr};
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ TheFn = IntrinsicGlobals.getDeclaration(M, ID.lifetime_end);
    return IRBuilderStatics.createCallHelper(TheFn, new ArrayRef<Value /*P*/ >(Ops, true), this);
  }



  /// \brief Create a call to Masked Load intrinsic

  /// \brief Create a call to Masked Load intrinsic

  /// \brief Create a call to a Masked Load intrinsic.
  /// \p Ptr      - base pointer for the load
  /// \p Align    - alignment of the source location
  /// \p Mask     - vector of booleans which indicates what vector lanes should
  ///               be accessed in memory
  /// \p PassThru - pass-through value that is used to fill the masked-off lanes
  ///               of the result
  /// \p Name     - name of the result variable
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMaskedLoad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 212,
   FQN="llvm::IRBuilderBase::CreateMaskedLoad", NM="_ZN4llvm13IRBuilderBase16CreateMaskedLoadEPNS_5ValueEjS2_S2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase16CreateMaskedLoadEPNS_5ValueEjS2_S2_RKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateMaskedLoad(Value /*P*/ Ptr, /*uint*/int Align,
                  Value /*P*/ Mask) {
    return CreateMaskedLoad(Ptr, Align,
                  Mask, (Value /*P*/ )null,
                  new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateMaskedLoad(Value /*P*/ Ptr, /*uint*/int Align,
                  Value /*P*/ Mask, Value /*P*/ PassThru/*= null*/) {
    return CreateMaskedLoad(Ptr, Align,
                  Mask, PassThru,
                  new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateMaskedLoad(Value /*P*/ Ptr, /*uint*/int Align,
                  Value /*P*/ Mask, Value /*P*/ PassThru/*= null*/,
                  final /*const*/ Twine /*&*/ Name/*= ""*/) {
    PointerType /*P*/ PtrTy = cast_PointerType(Ptr.getType());
    Type /*P*/ DataTy = PtrTy.getElementType();
    assert (DataTy.isVectorTy()) : "Ptr should point to a vector";
    if (!(PassThru != null)) {
      PassThru = UndefValue.get(DataTy);
    }
    Type /*P*/ OverloadedTypes[/*2*/] = new Type /*P*/  [/*2*/] {DataTy, PtrTy};
    Value /*P*/ Ops[/*4*/] = new Value /*P*/  [/*4*/] {Ptr, getInt32(Align), Mask, PassThru};
    return CreateMaskedIntrinsic(ID.masked_load, new ArrayRef<Value /*P*/ >(Ops, true),
        new ArrayRef<Type /*P*/ >(OverloadedTypes, true), Name);
  }



  /// \brief Create a call to Masked Store intrinsic

  /// \brief Create a call to Masked Store intrinsic

  /// \brief Create a call to a Masked Store intrinsic.
  /// \p Val   - data to be stored,
  /// \p Ptr   - base pointer for the store
  /// \p Align - alignment of the destination location
  /// \p Mask  - vector of booleans which indicates what vector lanes should
  ///            be accessed in memory
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMaskedStore">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 232,
   FQN="llvm::IRBuilderBase::CreateMaskedStore", NM="_ZN4llvm13IRBuilderBase17CreateMaskedStoreEPNS_5ValueES2_jS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase17CreateMaskedStoreEPNS_5ValueES2_jS2_")
  //</editor-fold>
  public CallInst /*P*/ CreateMaskedStore(Value /*P*/ Val, Value /*P*/ Ptr,
                   /*uint*/int Align, Value /*P*/ Mask) {
    PointerType /*P*/ PtrTy = cast_PointerType(Ptr.getType());
    Type /*P*/ DataTy = PtrTy.getElementType();
    assert (DataTy.isVectorTy()) : "Ptr should point to a vector";
    Type /*P*/ OverloadedTypes[/*2*/] = new Type /*P*/  [/*2*/] {DataTy, PtrTy};
    Value /*P*/ Ops[/*4*/] = new Value /*P*/  [/*4*/] {Val, Ptr, getInt32(Align), Mask};
    return CreateMaskedIntrinsic(ID.masked_store, new ArrayRef<Value /*P*/ >(Ops, true), new ArrayRef<Type /*P*/ >(OverloadedTypes, true));
  }



  /// \brief Create a call to Masked Gather intrinsic

  /// \brief Create a call to Masked Gather intrinsic

  /// \brief Create a call to a Masked Gather intrinsic.
  /// \p Ptrs     - vector of pointers for loading
  /// \p Align    - alignment for one element
  /// \p Mask     - vector of booleans which indicates what vector lanes should
  ///               be accessed in memory
  /// \p PassThru - pass-through value that is used to fill the masked-off lanes
  ///               of the result
  /// \p Name     - name of the result variable
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMaskedGather">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 262,
   FQN="llvm::IRBuilderBase::CreateMaskedGather", NM="_ZN4llvm13IRBuilderBase18CreateMaskedGatherEPNS_5ValueEjS2_S2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase18CreateMaskedGatherEPNS_5ValueEjS2_S2_RKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateMaskedGather(Value /*P*/ Ptrs, /*uint*/int Align) {
    return CreateMaskedGather(Ptrs, Align,
                    (Value /*P*/ )null, (Value /*P*/ )null,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateMaskedGather(Value /*P*/ Ptrs, /*uint*/int Align,
                    Value /*P*/ Mask/*= null*/) {
    return CreateMaskedGather(Ptrs, Align,
                    Mask, (Value /*P*/ )null,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateMaskedGather(Value /*P*/ Ptrs, /*uint*/int Align,
                    Value /*P*/ Mask/*= null*/, Value /*P*/ PassThru/*= null*/) {
    return CreateMaskedGather(Ptrs, Align,
                    Mask, PassThru,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateMaskedGather(Value /*P*/ Ptrs, /*uint*/int Align,
                    Value /*P*/ Mask/*= null*/, Value /*P*/ PassThru/*= null*/,
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    VectorType /*P*/ PtrsTy = cast_VectorType(Ptrs.getType());
    PointerType /*P*/ PtrTy = cast_PointerType(PtrsTy.getElementType());
    /*uint*/int NumElts = PtrsTy.getVectorNumElements();
    Type /*P*/ DataTy = VectorType.get(PtrTy.getElementType(), NumElts);
    if (!(Mask != null)) {
      Mask = Constant.getAllOnesValue(VectorType.get(Type.getInt1Ty(Context),
              NumElts));
    }

    Value /*P*/ Ops[/*4*/] = new Value /*P*/  [/*4*/] {Ptrs, getInt32(Align), Mask, UndefValue.get(DataTy)};

    // We specify only one type when we create this intrinsic. Types of other
    // arguments are derived from this type.
    return CreateMaskedIntrinsic(ID.masked_gather, new ArrayRef<Value /*P*/ >(Ops, true), /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*1*/] {DataTy}, true)/* }*/, Name);
  }



  /// \brief Create a call to Masked Scatter intrinsic

  /// \brief Create a call to Masked Scatter intrinsic

  /// \brief Create a call to a Masked Scatter intrinsic.
  /// \p Data  - data to be stored,
  /// \p Ptrs  - the vector of pointers, where the \p Data elements should be
  ///            stored
  /// \p Align - alignment for one element
  /// \p Mask  - vector of booleans which indicates what vector lanes should
  ///            be accessed in memory
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMaskedScatter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 288,
   FQN="llvm::IRBuilderBase::CreateMaskedScatter", NM="_ZN4llvm13IRBuilderBase19CreateMaskedScatterEPNS_5ValueES2_jS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase19CreateMaskedScatterEPNS_5ValueES2_jS2_")
  //</editor-fold>
  public CallInst /*P*/ CreateMaskedScatter(Value /*P*/ Data, Value /*P*/ Ptrs,
                     /*uint*/int Align) {
    return CreateMaskedScatter(Data, Ptrs,
                     Align, (Value /*P*/ )null);
  }
  public CallInst /*P*/ CreateMaskedScatter(Value /*P*/ Data, Value /*P*/ Ptrs,
                     /*uint*/int Align, Value /*P*/ Mask/*= null*/) {
    VectorType /*P*/ PtrsTy = cast_VectorType(Ptrs.getType());
    VectorType /*P*/ DataTy = cast_VectorType(Data.getType());
    /*uint*/int NumElts = PtrsTy.getVectorNumElements();
    PointerType /*P*/ PtrTy = cast_PointerType(PtrsTy.getElementType());
    assert (NumElts == DataTy.getVectorNumElements() && PtrTy.getElementType() == DataTy.getElementType()) : "Incompatible pointer and data types";
    if (!(Mask != null)) {
      Mask = Constant.getAllOnesValue(VectorType.get(Type.getInt1Ty(Context),
              NumElts));
    }
    Value /*P*/ Ops[/*4*/] = new Value /*P*/  [/*4*/] {Data, Ptrs, getInt32(Align), Mask};

    // We specify only one type when we create this intrinsic. Types of other
    // arguments are derived from this type.
    return CreateMaskedIntrinsic(ID.masked_scatter, new ArrayRef<Value /*P*/ >(Ops, true), /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*1*/] {DataTy}, true)/* }*/);
  }



  /// \brief Create an assume intrinsic call that allows the optimizer to
  /// assume that the provided condition will be true.

  /// \brief Create an assume intrinsic call that allows the optimizer to
  /// assume that the provided condition will be true.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateAssumption">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 194,
   FQN="llvm::IRBuilderBase::CreateAssumption", NM="_ZN4llvm13IRBuilderBase16CreateAssumptionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase16CreateAssumptionEPNS_5ValueE")
  //</editor-fold>
  public CallInst /*P*/ CreateAssumption(Value /*P*/ Cond) {
    assert (Cond.getType() == getInt1Ty()) : "an assumption condition must be of type i1";

    Value /*P*/ Ops[/*1*/] = new Value /*P*/  [/*1*/] {Cond};
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ FnAssume = IntrinsicGlobals.getDeclaration(M, ID.assume);
    return IRBuilderStatics.createCallHelper(FnAssume, new ArrayRef<Value /*P*/ >(Ops, true), this);
  }



  /// \brief Create a call to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.

  /// \brief Create a call to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCStatepointCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 357,
   FQN="llvm::IRBuilderBase::CreateGCStatepointCall", NM="_ZN4llvm13IRBuilderBase22CreateGCStatepointCallEyjPNS_5ValueENS_8ArrayRefIS2_EES4_S4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase22CreateGCStatepointCallEyjPNS_5ValueENS_8ArrayRefIS2_EES4_S4_RKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateGCStatepointCall_ulong_uint_Value$P_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualCallee,
                                                                    ArrayRef<Value /*P*/ > CallArgs, ArrayRef<Value /*P*/ > DeoptArgs,
                                                                    ArrayRef<Value /*P*/ > GCArgs) {
    return CreateGCStatepointCall_ulong_uint_Value$P_ArrayRef$Value$P_Twine$C(ID, NumPatchBytes, ActualCallee,
                                                                    CallArgs, DeoptArgs,
                                                                    GCArgs, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateGCStatepointCall_ulong_uint_Value$P_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualCallee,
                                                                    ArrayRef<Value /*P*/ > CallArgs, ArrayRef<Value /*P*/ > DeoptArgs,
                                                                    ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return IRBuilderStatics.<Value /*P*/ , Value /*P*/ , Value /*P*/ , Value /*P*/ >CreateGCStatepointCallCommon$Value(this, ID, NumPatchBytes, ActualCallee, StatepointFlags.None.getValue(),
        new ArrayRef<Value /*P*/ >(CallArgs), new ArrayRef<Value /*P*/ >(None/* No Transition Args */, true), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs), Name);
  }



  /// \brief Create a call to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.

  /// \brief Create a call to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCStatepointCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 366,
   FQN="llvm::IRBuilderBase::CreateGCStatepointCall", NM="_ZN4llvm13IRBuilderBase22CreateGCStatepointCallEyjPNS_5ValueEjNS_8ArrayRefINS_3UseEEES5_S5_NS3_IS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase22CreateGCStatepointCallEyjPNS_5ValueEjNS_8ArrayRefINS_3UseEEES5_S5_NS3_IS2_EERKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateGCStatepointCall(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualCallee, /*uint32_t*/int Flags,
                        ArrayRef<Use> CallArgs, ArrayRef<Use> TransitionArgs,
                        ArrayRef<Use> DeoptArgs, ArrayRef<Value /*P*/ > GCArgs) {
    return CreateGCStatepointCall(ID, NumPatchBytes, ActualCallee, Flags,
                        CallArgs, TransitionArgs,
                        DeoptArgs, GCArgs, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateGCStatepointCall(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualCallee, /*uint32_t*/int Flags,
                        ArrayRef<Use> CallArgs, ArrayRef<Use> TransitionArgs,
                        ArrayRef<Use> DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return IRBuilderStatics.<Use, Use, Use, Value /*P*/ >CreateGCStatepointCallCommon$Use(this, ID, NumPatchBytes, ActualCallee, Flags, new ArrayRef<Use>(CallArgs), new ArrayRef<Use>(TransitionArgs),
        new ArrayRef<Use>(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs), Name);
  }



  // \brief Conveninence function for the common case when CallArgs are filled
  // in using makeArrayRef(CS.arg_begin(), CS.arg_end()); Use needs to be
  // .get()'ed to get the Value pointer.

  // \brief Conveninence function for the common case when CallArgs are filled
  // in using makeArrayRef(CS.arg_begin(), CS.arg_end()); Use needs to be
  // .get()'ed to get the Value pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCStatepointCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 375,
   FQN="llvm::IRBuilderBase::CreateGCStatepointCall", NM="_ZN4llvm13IRBuilderBase22CreateGCStatepointCallEyjPNS_5ValueENS_8ArrayRefINS_3UseEEENS3_IS2_EES6_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase22CreateGCStatepointCallEyjPNS_5ValueENS_8ArrayRefINS_3UseEEENS3_IS2_EES6_RKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateGCStatepointCall_ulong_uint_Value$P_ArrayRef$Use_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualCallee,
                                                                                 ArrayRef<Use> CallArgs, ArrayRef<Value /*P*/ > DeoptArgs,
                                                                                 ArrayRef<Value /*P*/ > GCArgs) {
    return CreateGCStatepointCall_ulong_uint_Value$P_ArrayRef$Use_ArrayRef$Value$P_Twine$C(ID, NumPatchBytes, ActualCallee,
                                                                                 CallArgs, DeoptArgs,
                                                                                 GCArgs, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateGCStatepointCall_ulong_uint_Value$P_ArrayRef$Use_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualCallee,
                                                                                 ArrayRef<Use> CallArgs, ArrayRef<Value /*P*/ > DeoptArgs,
                                                                                 ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return IRBuilderStatics.<Use, Value /*P*/ , Value /*P*/ , Value /*P*/ >CreateGCStatepointCallCommon$UseValue(this, ID, NumPatchBytes, ActualCallee, StatepointFlags.None.getValue(),
        new ArrayRef<Use>(CallArgs), new ArrayRef<Value /*P*/ >(None, true), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs), Name);
  }



  /// brief Create an invoke to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.

  /// brief Create an invoke to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCStatepointInvoke">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 407,
   FQN="llvm::IRBuilderBase::CreateGCStatepointInvoke", NM="_ZN4llvm13IRBuilderBase24CreateGCStatepointInvokeEyjPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EES6_S6_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase24CreateGCStatepointInvokeEyjPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EES6_S6_RKNS_5TwineE")
  //</editor-fold>
  public InvokeInst /*P*/ CreateGCStatepointInvoke_ulong_uint_Value$P_BasicBlock$P_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualInvokee,
                                                                                   BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest,
                                                                                   ArrayRef<Value /*P*/ > InvokeArgs, ArrayRef<Value /*P*/ > DeoptArgs,
                                                                                   ArrayRef<Value /*P*/ > GCArgs) {
    return CreateGCStatepointInvoke_ulong_uint_Value$P_BasicBlock$P_ArrayRef$Value$P_Twine$C(ID, NumPatchBytes, ActualInvokee,
                                                                                   NormalDest, UnwindDest,
                                                                                   InvokeArgs, DeoptArgs,
                                                                                   GCArgs, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public InvokeInst /*P*/ CreateGCStatepointInvoke_ulong_uint_Value$P_BasicBlock$P_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualInvokee,
                                                                                   BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest,
                                                                                   ArrayRef<Value /*P*/ > InvokeArgs, ArrayRef<Value /*P*/ > DeoptArgs,
                                                                                   ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return IRBuilderStatics.<Value /*P*/ , Value /*P*/ , Value /*P*/ , Value /*P*/ >CreateGCStatepointInvokeCommon$Value(this, ID, NumPatchBytes, ActualInvokee, NormalDest, UnwindDest,
        StatepointFlags.None.getValue(), new ArrayRef<Value /*P*/ >(InvokeArgs), new ArrayRef<Value /*P*/ >(None/* No Transition Args*/, true),
        new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs), Name);
  }



  /// brief Create an invoke to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.

  /// brief Create an invoke to the experimental.gc.statepoint intrinsic to
  /// start a new statepoint sequence.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCStatepointInvoke">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 418,
   FQN="llvm::IRBuilderBase::CreateGCStatepointInvoke", NM="_ZN4llvm13IRBuilderBase24CreateGCStatepointInvokeEyjPNS_5ValueEPNS_10BasicBlockES4_jNS_8ArrayRefINS_3UseEEES7_S7_NS5_IS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase24CreateGCStatepointInvokeEyjPNS_5ValueEPNS_10BasicBlockES4_jNS_8ArrayRefINS_3UseEEES7_S7_NS5_IS2_EERKNS_5TwineE")
  //</editor-fold>
  public InvokeInst /*P*/ CreateGCStatepointInvoke(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualInvokee,
                          BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, /*uint32_t*/int Flags,
                          ArrayRef<Use> InvokeArgs, ArrayRef<Use> TransitionArgs,
                          ArrayRef<Use> DeoptArgs, ArrayRef<Value /*P*/ > GCArgs) {
    return CreateGCStatepointInvoke(ID, NumPatchBytes, ActualInvokee,
                          NormalDest, UnwindDest, Flags,
                          InvokeArgs, TransitionArgs,
                          DeoptArgs, GCArgs, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public InvokeInst /*P*/ CreateGCStatepointInvoke(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualInvokee,
                          BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, /*uint32_t*/int Flags,
                          ArrayRef<Use> InvokeArgs, ArrayRef<Use> TransitionArgs,
                          ArrayRef<Use> DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return IRBuilderStatics.<Use, Use, Use, Value /*P*/ >CreateGCStatepointInvokeCommon$Use(this, ID, NumPatchBytes, ActualInvokee, NormalDest, UnwindDest, Flags,
        new ArrayRef<Use>(InvokeArgs), new ArrayRef<Use>(TransitionArgs), new ArrayRef<Use>(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs), Name);
  }



  // Conveninence function for the common case when CallArgs are filled in using
  // makeArrayRef(CS.arg_begin(), CS.arg_end()); Use needs to be .get()'ed to
  // get the Value *.

  // Conveninence function for the common case when CallArgs are filled in using
  // makeArrayRef(CS.arg_begin(), CS.arg_end()); Use needs to be .get()'ed to
  // get the Value *.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCStatepointInvoke">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 428,
   FQN="llvm::IRBuilderBase::CreateGCStatepointInvoke", NM="_ZN4llvm13IRBuilderBase24CreateGCStatepointInvokeEyjPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefINS_3UseEEENS5_IS2_EES8_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase24CreateGCStatepointInvokeEyjPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefINS_3UseEEENS5_IS2_EES8_RKNS_5TwineE")
  //</editor-fold>
  public InvokeInst /*P*/ CreateGCStatepointInvoke_ulong_uint_Value$P_BasicBlock$P_ArrayRef$Use_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualInvokee,
                                                                                                BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, ArrayRef<Use> InvokeArgs,
                                                                                                ArrayRef<Value /*P*/ > DeoptArgs, ArrayRef<Value /*P*/ > GCArgs) {
    return CreateGCStatepointInvoke_ulong_uint_Value$P_BasicBlock$P_ArrayRef$Use_ArrayRef$Value$P_Twine$C(ID, NumPatchBytes, ActualInvokee,
                                                                                                NormalDest, UnwindDest, InvokeArgs,
                                                                                                DeoptArgs, GCArgs, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public InvokeInst /*P*/ CreateGCStatepointInvoke_ulong_uint_Value$P_BasicBlock$P_ArrayRef$Use_ArrayRef$Value$P_Twine$C(long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, Value /*P*/ ActualInvokee,
                                                                                                BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, ArrayRef<Use> InvokeArgs,
                                                                                                ArrayRef<Value /*P*/ > DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return IRBuilderStatics.<Use, Value /*P*/ , Value /*P*/ , Value /*P*/ >CreateGCStatepointInvokeCommon$UseValue(this, ID, NumPatchBytes, ActualInvokee, NormalDest, UnwindDest,
        StatepointFlags.None.getValue(), new ArrayRef<Use>(InvokeArgs), new ArrayRef<Value /*P*/ >(None, true), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs),
        Name);
  }



  /// \brief Create a call to the experimental.gc.result intrinsic to extract
  /// the result from a call wrapped in a statepoint.

  /// \brief Create a call to the experimental.gc.result intrinsic to extract
  /// the result from a call wrapped in a statepoint.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCResult">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 438,
   FQN="llvm::IRBuilderBase::CreateGCResult", NM="_ZN4llvm13IRBuilderBase14CreateGCResultEPNS_11InstructionEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase14CreateGCResultEPNS_11InstructionEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateGCResult(Instruction /*P*/ Statepoint,
                Type /*P*/ ResultType) {
    return CreateGCResult(Statepoint,
                ResultType,
                new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateGCResult(Instruction /*P*/ Statepoint,
                Type /*P*/ ResultType,
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
    /*Intrinsic.ID*/int _ID = ID.experimental_gc_result;
    Module /*P*/ M = BB.getParent().getParent();
    Type /*P*/ Types[/*1*/] = new Type /*P*/  [/*1*/] {ResultType};
    Value /*P*/ FnGCResult = IntrinsicGlobals.getDeclaration(M, _ID, new ArrayRef<Type /*P*/ >(Types, true));

    Value /*P*/ Args[/*1*/] = new Value /*P*/  [/*1*/] {Statepoint};
    return IRBuilderStatics.createCallHelper(FnGCResult, new ArrayRef<Value /*P*/ >(Args, true), this, Name);
  }



  /// \brief Create a call to the experimental.gc.relocate intrinsics to
  /// project the relocated value of one pointer from the statepoint.

  /// \brief Create a call to the experimental.gc.relocate intrinsics to
  /// project the relocated value of one pointer from the statepoint.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateGCRelocate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 450,
   FQN="llvm::IRBuilderBase::CreateGCRelocate", NM="_ZN4llvm13IRBuilderBase16CreateGCRelocateEPNS_11InstructionEiiPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase16CreateGCRelocateEPNS_11InstructionEiiPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public CallInst /*P*/ CreateGCRelocate(Instruction /*P*/ Statepoint,
                  int BaseOffset,
                  int DerivedOffset,
                  Type /*P*/ ResultType) {
    return CreateGCRelocate(Statepoint,
                  BaseOffset,
                  DerivedOffset,
                  ResultType,
                  new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CallInst /*P*/ CreateGCRelocate(Instruction /*P*/ Statepoint,
                  int BaseOffset,
                  int DerivedOffset,
                  Type /*P*/ ResultType,
                  final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Module /*P*/ M = BB.getParent().getParent();
    Type /*P*/ Types[/*1*/] = new Type /*P*/  [/*1*/] {ResultType};
    Value /*P*/ FnGCRelocate = IntrinsicGlobals.getDeclaration(M, ID.experimental_gc_relocate, new ArrayRef<Type /*P*/ >(Types, true));

    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      Statepoint,
      getInt32(BaseOffset),
      getInt32(DerivedOffset)};
    return IRBuilderStatics.createCallHelper(FnGCRelocate, new ArrayRef<Value /*P*/ >(Args, true), this, Name);
  }


/*private:*/
  /// \brief Create a call to a masked intrinsic with given Id.
  /// \brief Create a call to a masked intrinsic with given Id.

  /// Create a call to a Masked intrinsic, with given intrinsic Id,
  /// an array of operands - Ops, and an array of overloaded types -
  /// OverloadedTypes.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::CreateMaskedIntrinsic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 245,
   FQN="llvm::IRBuilderBase::CreateMaskedIntrinsic", NM="_ZN4llvm13IRBuilderBase21CreateMaskedIntrinsicENS_9Intrinsic2IDENS_8ArrayRefIPNS_5ValueEEENS3_IPNS_4TypeEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase21CreateMaskedIntrinsicENS_9Intrinsic2IDENS_8ArrayRefIPNS_5ValueEEENS3_IPNS_4TypeEEERKNS_5TwineE")
  //</editor-fold>
  private CallInst /*P*/ CreateMaskedIntrinsic(/*Intrinsic.ID*/int Id,
                       ArrayRef<Value /*P*/ > Ops,
                       ArrayRef<Type /*P*/ > OverloadedTypes) {
    return CreateMaskedIntrinsic(Id,
                       Ops,
                       OverloadedTypes,
                       new Twine(/*KEEP_STR*/$EMPTY));
  }
  private CallInst /*P*/ CreateMaskedIntrinsic(/*Intrinsic.ID*/int Id,
                       ArrayRef<Value /*P*/ > Ops,
                       ArrayRef<Type /*P*/ > OverloadedTypes,
                       final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Module /*P*/ M = BB.getParent().getParent();
    Value /*P*/ TheFn = IntrinsicGlobals.getDeclaration(M, Id, new ArrayRef<Type /*P*/ >(OverloadedTypes));
    return IRBuilderStatics.createCallHelper(TheFn, new ArrayRef<Value /*P*/ >(Ops), this, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::getCastedInt8PtrValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 46,
   FQN="llvm::IRBuilderBase::getCastedInt8PtrValue", NM="_ZN4llvm13IRBuilderBase21getCastedInt8PtrValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm13IRBuilderBase21getCastedInt8PtrValueEPNS_5ValueE")
  //</editor-fold>
  private Value /*P*/ getCastedInt8PtrValue(Value /*P*/ Ptr) {
    PointerType /*P*/ PT = cast_PointerType(Ptr.getType());
    if (PT.getElementType().isIntegerTy(8)) {
      return Ptr;
    }

    // Otherwise, we need to insert a bitcast.
    PT = getInt8PtrTy(PT.getAddressSpace());
    PointerType $PTFinal = PT;
    BitCastInst /*P*/ BCI = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
        return new BitCastInst(Ptr, $PTFinal, new Twine(/*KEEP_STR*/$EMPTY));
     });
    BB.getInstList().insert_ilist_iterator$NodeTy_T$P(new ilist_iterator<Instruction>(InsertPt), BCI);
    SetInstDebugLocation(BCI);
    return BCI;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::~IRBuilderBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 71,
   FQN="llvm::IRBuilderBase::~IRBuilderBase", NM="_ZN4llvm13IRBuilderBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN4llvm13IRBuilderBaseD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CurDbgLocation.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilderBase::IRBuilderBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 71,
   FQN="llvm::IRBuilderBase::IRBuilderBase", NM="_ZN4llvm13IRBuilderBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm13IRBuilderBaseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ IRBuilderBase(final /*const*/ IRBuilderBase /*&*/ $Prm0) {
    // : CurDbgLocation(.CurDbgLocation), BB(.BB), InsertPt(.InsertPt), Context(.Context), DefaultFPMathTag(.DefaultFPMathTag), FMF(.FMF), DefaultOperandBundles(.DefaultOperandBundles)
    //START JInit
    this.CurDbgLocation = new DebugLoc($Prm0.CurDbgLocation);
    this.BB = $Prm0.BB;
    this.InsertPt = new ilist_iterator<Instruction>($Prm0.InsertPt);
    this./*&*/Context=/*&*/$Prm0.Context;
    this.DefaultFPMathTag = $Prm0.DefaultFPMathTag;
    this.FMF = new FastMathFlags($Prm0.FMF);
    this.DefaultOperandBundles = new ArrayRef<OperandBundleDefT<Value /*P*/ >>($Prm0.DefaultOperandBundles);
    //END JInit
  }


  @Override public String toString() {
    return "" + "CurDbgLocation=" + CurDbgLocation // NOI18N
              + ", BB=" + BB // NOI18N
              + ", InsertPt=" + InsertPt // NOI18N
              + ", Context=" + "[LLVMContext]" // NOI18N
              + ", DefaultFPMathTag=" + DefaultFPMathTag // NOI18N
              + ", FMF=" + FMF // NOI18N
              + ", DefaultOperandBundles=" + DefaultOperandBundles; // NOI18N
  }
}
