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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief A stack of loop information corresponding to loop nesting levels.
/// This stack can be used to prepare attributes which are applied when a loop
/// is emitted.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 94,
 FQN="clang::CodeGen::LoopInfoStack", NM="_ZN5clang7CodeGen13LoopInfoStackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStackE")
//</editor-fold>
public class LoopInfoStack implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::LoopInfoStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 95,
   FQN="clang::CodeGen::LoopInfoStack::LoopInfoStack", NM="_ZN5clang7CodeGen13LoopInfoStackC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStackC1ERKS1_")
  //</editor-fold>
  protected/*private*/ LoopInfoStack(final /*const*/ LoopInfoStack /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 96,
   FQN="clang::CodeGen::LoopInfoStack::operator=", NM="_ZN5clang7CodeGen13LoopInfoStackaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStackaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ LoopInfoStack /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::LoopInfoStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 99,
   FQN="clang::CodeGen::LoopInfoStack::LoopInfoStack", NM="_ZN5clang7CodeGen13LoopInfoStackC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStackC1Ev")
  //</editor-fold>
  public LoopInfoStack() {
    // : StagedAttrs(), Active() 
    //START JInit
    this.StagedAttrs = new LoopAttributes();
    this.Active = new SmallVector<LoopInfo>(4, new LoopInfo());
    //END JInit
  }

  
  /// \brief Begin a new structured loop. The set of staged attributes will be
  /// applied to the loop and then cleared.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::push">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 123,
   FQN="clang::CodeGen::LoopInfoStack::push", NM="_ZN5clang7CodeGen13LoopInfoStack4pushEPN4llvm10BasicBlockENS2_8DebugLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack4pushEPN4llvm10BasicBlockENS2_8DebugLocE")
  //</editor-fold>
  public void push(BasicBlock /*P*/ Header) {
    push(Header, new DebugLoc());//$c$.track(new DebugLoc()));
  }
  public void push(BasicBlock /*P*/ Header, DebugLoc Location/*= DebugLoc()*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Active.push_back(new LoopInfo(Header, StagedAttrs, $c$.track(new DebugLoc(Location)))); $c$.clean();
      // Clear the attributes so nested loops do not inherit them.
      StagedAttrs.clear();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Begin a new structured loop. Stage attributes from the Attrs list.
  /// The staged attributes are applied to the loop and then cleared.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::push">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 129,
   FQN="clang::CodeGen::LoopInfoStack::push", NM="_ZN5clang7CodeGen13LoopInfoStack4pushEPN4llvm10BasicBlockERNS_10ASTContextENS2_8ArrayRefIPKNS_4AttrEEENS2_8DebugLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack4pushEPN4llvm10BasicBlockERNS_10ASTContextENS2_8ArrayRefIPKNS_4AttrEEENS2_8DebugLocE")
  //</editor-fold>
  public void push(BasicBlock /*P*/ Header, final ASTContext /*&*/ Ctx, 
      ArrayRef</*const*/ Attr /*P*/ > Attrs) {
    push(Header, Ctx, 
      Attrs, 
      new DebugLoc());//$c$.track(new DebugLoc()));
  }
  public void push(BasicBlock /*P*/ Header, final ASTContext /*&*/ Ctx, 
      ArrayRef</*const*/ Attr /*P*/ > Attrs, 
      DebugLoc Location/*= DebugLoc()*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Identify loop hint attributes from Attrs.
      for (/*const*/ Attr /*P*/ $Attr : Attrs) {
        /*const*/ LoopHintAttr /*P*/ LH = dyn_cast_LoopHintAttr($Attr);
        /*const*/ OpenCLUnrollHintAttr /*P*/ OpenCLHint = dyn_cast_OpenCLUnrollHintAttr($Attr);
        
        // Skip non loop hint attributes
        if (!(LH != null) && !(OpenCLHint != null)) {
          continue;
        }
        
        LoopHintAttr.OptionType Option = LoopHintAttr.OptionType.Unroll;
        LoopHintAttr.LoopHintState State = LoopHintAttr.LoopHintState.Disable;
        /*uint*/int ValueInt = 1;
        // Translate opencl_unroll_hint attribute argument to
        // equivalent LoopHintAttr enums.
        // OpenCL v2.0 s6.11.5:  
        // 0 - full unroll (no argument).
        // 1 - disable unroll.
        // other positive integer n - unroll by n.
        if ((OpenCLHint != null)) {
          ValueInt = OpenCLHint.getUnrollHint();
          if (ValueInt == 0) {
            State = LoopHintAttr.LoopHintState.Full;
          } else if (ValueInt != 1) {
            Option = LoopHintAttr.OptionType.UnrollCount;
            State = LoopHintAttr.LoopHintState.Numeric;
          }
        } else if ((LH != null)) {
          Expr /*P*/ ValueExpr = LH.getValue();
          if ((ValueExpr != null)) {
            APSInt ValueAPS = ValueExpr.EvaluateKnownConstInt(Ctx);
            ValueInt = $long2uint(ValueAPS.getSExtValue());
          }
          
          Option = LH.getOption();
          State = LH.getState();
        }
        switch (State) {
         case Disable:
          switch (Option) {
           case Vectorize:
            // Disable vectorization by specifying a width of 1.
            setVectorizeWidth(1);
            break;
           case Interleave:
            // Disable interleaving by speciyfing a count of 1.
            setInterleaveCount(1);
            break;
           case Unroll:
            setUnrollState(LoopAttributes.LVEnableState.Disable);
            break;
           case Distribute:
            setDistributeState(false);
            break;
           case UnrollCount:
           case VectorizeWidth:
           case InterleaveCount:
            throw new llvm_unreachable("Options cannot be disabled.");
//            break;
          }
          break;
         case Enable:
          switch (Option) {
           case Vectorize:
           case Interleave:
            setVectorizeEnable(true);
            break;
           case Unroll:
            setUnrollState(LoopAttributes.LVEnableState.Enable);
            break;
           case Distribute:
            setDistributeState(true);
            break;
           case UnrollCount:
           case VectorizeWidth:
           case InterleaveCount:
            throw new llvm_unreachable("Options cannot enabled.");
//            break;
          }
          break;
         case AssumeSafety:
          switch (Option) {
           case Vectorize:
           case Interleave:
            // Apply "llvm.mem.parallel_loop_access" metadata to load/stores.
            setParallel(true);
            setVectorizeEnable(true);
            break;
           case Unroll:
           case UnrollCount:
           case VectorizeWidth:
           case InterleaveCount:
           case Distribute:
            throw new llvm_unreachable("Options cannot be used to assume mem safety.");
//            break;
          }
          break;
         case Full:
          switch (Option) {
           case Unroll:
            setUnrollState(LoopAttributes.LVEnableState.Full);
            break;
           case Vectorize:
           case Interleave:
           case UnrollCount:
           case VectorizeWidth:
           case InterleaveCount:
           case Distribute:
            throw new llvm_unreachable("Options cannot be used with 'full' hint.");
//            break;
          }
          break;
         case Numeric:
          switch (Option) {
           case VectorizeWidth:
            setVectorizeWidth(ValueInt);
            break;
           case InterleaveCount:
            setInterleaveCount(ValueInt);
            break;
           case UnrollCount:
            setUnrollCount(ValueInt);
            break;
           case Unroll:
           case Vectorize:
           case Interleave:
           case Distribute:
            throw new llvm_unreachable("Options cannot be assigned a value.");
//            break;
          }
          break;
        }
      }
      
      /// Stage the attributes.
      push(Header, $c$.track(new DebugLoc(Location))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief End the current loop.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::pop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 272,
   FQN="clang::CodeGen::LoopInfoStack::pop", NM="_ZN5clang7CodeGen13LoopInfoStack3popEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack3popEv")
  //</editor-fold>
  public void pop() {
    assert (!Active.empty()) : "No active loops to pop";
    Active.pop_back();
  }

  
  /// \brief Return the top loop id metadata.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::getCurLoopID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 116,
   FQN="clang::CodeGen::LoopInfoStack::getCurLoopID", NM="_ZNK5clang7CodeGen13LoopInfoStack12getCurLoopIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZNK5clang7CodeGen13LoopInfoStack12getCurLoopIDEv")
  //</editor-fold>
  public MDNode /*P*/ getCurLoopID() /*const*/ {
    return getInfo().getLoopID();
  }

  
  /// \brief Return true if the top loop is parallel.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::getCurLoopParallel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 119,
   FQN="clang::CodeGen::LoopInfoStack::getCurLoopParallel", NM="_ZNK5clang7CodeGen13LoopInfoStack18getCurLoopParallelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZNK5clang7CodeGen13LoopInfoStack18getCurLoopParallelEv")
  //</editor-fold>
  public boolean getCurLoopParallel() /*const*/ {
    return hasInfo() ? getInfo().getAttributes().IsParallel : false;
  }

  
  /// \brief Function called by the CodeGenFunction when an instruction is
  /// created.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::InsertHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 277,
   FQN="clang::CodeGen::LoopInfoStack::InsertHelper", NM="_ZNK5clang7CodeGen13LoopInfoStack12InsertHelperEPN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZNK5clang7CodeGen13LoopInfoStack12InsertHelperEPN4llvm11InstructionE")
  //</editor-fold>
  public void InsertHelper(Instruction /*P*/ I) /*const*/ {
    if (!hasInfo()) {
      return;
    }
    
    final /*const*/ LoopInfo /*&*/ L = getInfo();
    if (!(L.getLoopID() != null)) {
      return;
    }
    {
      
      TerminatorInst /*P*/ TI = dyn_cast_TerminatorInst(I);
      if ((TI != null)) {
        for (/*uint*/int i = 0, ie = TI.getNumSuccessors(); $less_uint(i, ie); ++i)  {
          if (TI.getSuccessor(i) == L.getHeader()) {
            TI.setMetadata(LLVMContext.Unnamed_enum.MD_loop.getValue(), L.getLoopID());
            break;
          }
        }
        return;
      }
    }
    if (L.getAttributes().IsParallel && I.mayReadOrWriteMemory()) {
      I.setMetadata(new StringRef(/*KEEP_STR*/"llvm.mem.parallel_loop_access"), L.getLoopID());
    }
  }

  
  /// \brief Set the next pushed loop as parallel.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setParallel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 128,
   FQN="clang::CodeGen::LoopInfoStack::setParallel", NM="_ZN5clang7CodeGen13LoopInfoStack11setParallelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack11setParallelEb")
  //</editor-fold>
  public void setParallel() {
    setParallel(true);
  }
  public void setParallel(boolean Enable/*= true*/) {
    StagedAttrs.IsParallel = Enable;
  }

  
  /// \brief Set the next pushed loop 'vectorize.enable'
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setVectorizeEnable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 131,
   FQN="clang::CodeGen::LoopInfoStack::setVectorizeEnable", NM="_ZN5clang7CodeGen13LoopInfoStack18setVectorizeEnableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack18setVectorizeEnableEb")
  //</editor-fold>
  public void setVectorizeEnable() {
    setVectorizeEnable(true);
  }
  public void setVectorizeEnable(boolean Enable/*= true*/) {
    StagedAttrs.VectorizeEnable
       = Enable ? LoopAttributes.LVEnableState.Enable : LoopAttributes.LVEnableState.Disable;
  }

  
  /// \brief Set the next pushed loop as a distribution candidate.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setDistributeState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 137,
   FQN="clang::CodeGen::LoopInfoStack::setDistributeState", NM="_ZN5clang7CodeGen13LoopInfoStack18setDistributeStateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack18setDistributeStateEb")
  //</editor-fold>
  public void setDistributeState() {
    setDistributeState(true);
  }
  public void setDistributeState(boolean Enable/*= true*/) {
    StagedAttrs.DistributeEnable
       = Enable ? LoopAttributes.LVEnableState.Enable : LoopAttributes.LVEnableState.Disable;
  }

  
  /// \brief Set the next pushed loop unroll state.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setUnrollState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 143,
   FQN="clang::CodeGen::LoopInfoStack::setUnrollState", NM="_ZN5clang7CodeGen13LoopInfoStack14setUnrollStateERKNS0_14LoopAttributes13LVEnableStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack14setUnrollStateERKNS0_14LoopAttributes13LVEnableStateE")
  //</editor-fold>
  public void setUnrollState(final /*const*/ LoopAttributes.LVEnableState /*&*/ State) {
    StagedAttrs.UnrollEnable = State;
  }

  
  /// \brief Set the vectorize width for the next loop pushed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setVectorizeWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 148,
   FQN="clang::CodeGen::LoopInfoStack::setVectorizeWidth", NM="_ZN5clang7CodeGen13LoopInfoStack17setVectorizeWidthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack17setVectorizeWidthEj")
  //</editor-fold>
  public void setVectorizeWidth(/*uint*/int W) {
    StagedAttrs.VectorizeWidth = W;
  }

  
  /// \brief Set the interleave count for the next loop pushed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setInterleaveCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 151,
   FQN="clang::CodeGen::LoopInfoStack::setInterleaveCount", NM="_ZN5clang7CodeGen13LoopInfoStack18setInterleaveCountEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack18setInterleaveCountEj")
  //</editor-fold>
  public void setInterleaveCount(/*uint*/int C) {
    StagedAttrs.InterleaveCount = C;
  }

  
  /// \brief Set the unroll count for the next loop pushed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::setUnrollCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 154,
   FQN="clang::CodeGen::LoopInfoStack::setUnrollCount", NM="_ZN5clang7CodeGen13LoopInfoStack14setUnrollCountEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen13LoopInfoStack14setUnrollCountEj")
  //</editor-fold>
  public void setUnrollCount(/*uint*/int C) {
    StagedAttrs.UnrollCount = C;
  }

/*private:*/
  /// \brief Returns true if there is LoopInfo on the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::hasInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 158,
   FQN="clang::CodeGen::LoopInfoStack::hasInfo", NM="_ZNK5clang7CodeGen13LoopInfoStack7hasInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZNK5clang7CodeGen13LoopInfoStack7hasInfoEv")
  //</editor-fold>
  private boolean hasInfo() /*const*/ {
    return !Active.empty();
  }

  /// \brief Return the LoopInfo for the current loop. HasInfo should be called
  /// first to ensure LoopInfo is present.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::getInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 161,
   FQN="clang::CodeGen::LoopInfoStack::getInfo", NM="_ZNK5clang7CodeGen13LoopInfoStack7getInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZNK5clang7CodeGen13LoopInfoStack7getInfoEv")
  //</editor-fold>
  private /*const*/ LoopInfo /*&*/ getInfo() /*const*/ {
    return Active.back$Const();
  }

  /// \brief The set of attributes that will be applied to the next pushed loop.
  private LoopAttributes StagedAttrs;
  /// \brief Stack of active loops.
  private SmallVector<LoopInfo> Active;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopInfoStack::~LoopInfoStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 94,
   FQN="clang::CodeGen::LoopInfoStack::~LoopInfoStack", NM="_ZN5clang7CodeGen13LoopInfoStackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen13LoopInfoStackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Active.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "StagedAttrs=" + StagedAttrs // NOI18N
              + ", Active=" + Active; // NOI18N
  }
}
