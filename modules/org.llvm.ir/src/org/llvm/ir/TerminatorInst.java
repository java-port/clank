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


//===----------------------------------------------------------------------===//
//                            TerminatorInst Class
//===----------------------------------------------------------------------===//

/// Subclasses of this class are all able to terminate a basic
/// block. Thus, these are all the flow control type of operations.
///
//<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 38,
 FQN="llvm::TerminatorInst", NM="_ZN4llvm14TerminatorInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInstE")
//</editor-fold>
public abstract class TerminatorInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::TerminatorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 40,
   FQN="llvm::TerminatorInst::TerminatorInst", NM="_ZN4llvm14TerminatorInstC1EPNS_4TypeENS_11Instruction7TermOpsEPNS_3UseEjPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInstC1EPNS_4TypeENS_11Instruction7TermOpsEPNS_3UseEjPS3_")
  //</editor-fold>
  protected TerminatorInst(Type /*P*/ Ty, /*TermOps*/int iType,
      type$ptr<Use /*P*/> Ops, /*uint*/int NumOps) {
    this(Ty, iType,
      Ops, NumOps,
      (Instruction /*P*/ )null);
  }
  protected TerminatorInst(Type /*P*/ Ty, /*TermOps*/int iType,
      type$ptr<Use /*P*/> Ops, /*uint*/int NumOps,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(Ty, iType, Ops, NumOps, InsertBefore)
    //START JInit
    super(Ty, iType, Ops, NumOps, InsertBefore);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::TerminatorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 45,
   FQN="llvm::TerminatorInst::TerminatorInst", NM="_ZN4llvm14TerminatorInstC1EPNS_4TypeENS_11Instruction7TermOpsEPNS_3UseEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInstC1EPNS_4TypeENS_11Instruction7TermOpsEPNS_3UseEjPNS_10BasicBlockE")
  //</editor-fold>
  protected TerminatorInst(Type /*P*/ Ty, /*TermOps*/int iType,
      type$ptr<Use /*P*/> Ops, /*uint*/int NumOps, BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Ty, iType, Ops, NumOps, InsertAtEnd)
    //START JInit
    super(Ty, iType, Ops, NumOps, InsertAtEnd);
    //END JInit
  }


  // Out of line virtual method, so the vtable, etc has a home.

  // Out of line virtual method, so the vtable, etc has a home.

  //===----------------------------------------------------------------------===//
  //                            TerminatorInst Class
  //===----------------------------------------------------------------------===//

  // Out of line virtual method, so the vtable, etc has a home.
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::~TerminatorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 45,
   FQN="llvm::TerminatorInst::~TerminatorInst", NM="_ZN4llvm14TerminatorInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14TerminatorInstD0Ev")
  //</editor-fold>
  @Override public/*protected*/ void $destroy()/* override*/ {
    super.$destroy();
  }



  /// Virtual methods - Terminators should overload these and provide inline
  /// overrides of non-V methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 54,
   FQN="llvm::TerminatorInst::getSuccessorV", NM="_ZNK4llvm14TerminatorInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst13getSuccessorVEj")
  //</editor-fold>
  protected abstract /*virtual*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 55,
   FQN="llvm::TerminatorInst::getNumSuccessorsV", NM="_ZNK4llvm14TerminatorInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst17getNumSuccessorsVEv")
  //</editor-fold>
  protected abstract /*virtual*/ /*uint*/int getNumSuccessorsV() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 56,
   FQN="llvm::TerminatorInst::setSuccessorV", NM="_ZN4llvm14TerminatorInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  protected abstract /*virtual*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ B)/* = 0*/;

/*public:*/
  /// Return the number of successors that this terminator has.
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 60,
   FQN="llvm::TerminatorInst::getNumSuccessors", NM="_ZNK4llvm14TerminatorInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return getNumSuccessorsV();
  }


  /// Return the specified successor.
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::getSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 65,
   FQN="llvm::TerminatorInst::getSuccessor", NM="_ZNK4llvm14TerminatorInst12getSuccessorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12getSuccessorEj")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor(/*uint*/int idx) /*const*/ {
    return getSuccessorV(idx);
  }


  /// Update the specified successor to point at the provided block.
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::setSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 70,
   FQN="llvm::TerminatorInst::setSuccessor", NM="_ZN4llvm14TerminatorInst12setSuccessorEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12setSuccessorEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(/*uint*/int idx, BasicBlock /*P*/ B) {
    setSuccessorV(idx, B);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 75,
   FQN="llvm::TerminatorInst::classof", NM="_ZN4llvm14TerminatorInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.isTerminator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 78,
   FQN="llvm::TerminatorInst::classof", NM="_ZN4llvm14TerminatorInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && TerminatorInst.classof(cast_Instruction(V));
  }


  // \brief Returns true if this terminator relates to exception handling.
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::isExceptional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 83,
   FQN="llvm::TerminatorInst::isExceptional", NM="_ZNK4llvm14TerminatorInst13isExceptionalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst13isExceptionalEv")
  //</editor-fold>
  public boolean isExceptional() /*const*/ {
    switch (getOpcode()) {
     case Instruction.TermOps.CatchSwitch:
     case Instruction.TermOps.CatchRet:
     case Instruction.TermOps.CleanupRet:
     case Instruction.TermOps.Invoke:
     case Instruction.TermOps.Resume:
      return true;
     default:
      return false;
    }
  }


  //===--------------------------------------------------------------------===//
  // succ_iterator definition
  //===--------------------------------------------------------------------===//
  /*template <class Term, class BB> TEMPLATE*/
  // Successor Iterator
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*TermInst*/,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 100,
   FQN="llvm::TerminatorInst::SuccIterator", NM="_ZN4llvm14TerminatorInst12SuccIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorE")
  //</editor-fold>
  public static class SuccIterator</*class*/ Term extends TerminatorInst, /*class*/ BB extends BasicBlock>  implements /*public*/ std.iterator<std.random_access_iterator_tag, BB>, type$iterator<SuccIterator, BB>, Native.NativeComparable {
    // JAVA: typedef std::iterator<std::random_access_iterator_tag, BB, int, BB *, BB *> super
//    public final class super extends std.iterator<std.random_access_iterator_tag, BB>{ };
  /*public:*/
    // JAVA: typedef typename super::pointer pointer
//    public final class pointer extends BB{ };
    // JAVA: typedef typename super::reference reference
//    public final class reference extends BB{ };
  /*private:*/
    private Term/*P*/ TermInst; // JAVA: this is a pointer (or a smart pointer), because in C++ it is dereferenced with "->"
    private /*uint*/int idx;
    // JAVA: typedef SuccIterator<Term, BB> Self
//    public final class Self extends SuccIterator<Term, BB>{ };

    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::index_is_valid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 115,
     FQN="llvm::TerminatorInst::SuccIterator::index_is_valid", NM="_ZN4llvm14TerminatorInst12SuccIterator14index_is_validEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator14index_is_validEj")
    //</editor-fold>
    private /*inline*/ boolean index_is_valid(/*uint*/int idx) {
      return Native.$less(idx, TermInst.getNumSuccessors());
    }


    /// \brief Proxy object to allow write access in operator[]
    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccessorProxy">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 120,
     FQN="llvm::TerminatorInst::SuccIterator::SuccessorProxy", NM="_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyE")
    //</editor-fold>
    private /*static*/ class SuccessorProxy {
      private SuccIterator<Term, BB> it;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccessorProxy::SuccessorProxy">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 124,
       FQN="llvm::TerminatorInst::SuccIterator::SuccessorProxy::SuccessorProxy", NM="_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyC1ERKNS0_12SuccIteratorIT_T0_EE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyC1ERKNS0_12SuccIteratorIT_T0_EE")
      //</editor-fold>
      public /*explicit*/ SuccessorProxy(final /*const*/ SuccIterator<Term, BB> /*&*/ it) {
        // : it(it)
        //START JInit
        this.it = /*ParenListExpr*/new SuccIterator<Term, BB>(it);
        //END JInit
      }


      //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccessorProxy::SuccessorProxy">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 126,
       FQN="llvm::TerminatorInst::SuccIterator::SuccessorProxy::SuccessorProxy", NM="_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyC1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyC1ERKS2_")
      //</editor-fold>
      public SuccessorProxy(final /*const*/ SuccessorProxy /*&*/ $Prm0)/* = default*/ {
        /*<<<default copy constructor: may be there is another TU where objects are copied?>>>*/
        // memcpy(this, $1, sizeof($1));
      }



      //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccessorProxy::operator=">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 128,
       FQN="llvm::TerminatorInst::SuccIterator::SuccessorProxy::operator=", NM="_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyaSES2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyaSES2_")
      //</editor-fold>
      public SuccessorProxy /*&*/ $assign(SuccessorProxy r) {
        this.$assign((BB)new BasicBlock(r.$BB()));
        return /*Deref*/this;
      }


      //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccessorProxy::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 133,
       FQN="llvm::TerminatorInst::SuccIterator::SuccessorProxy::operator=", NM="_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyaSENSt8iteratorISt26random_access_iterator_tagT0_iPS5_S6_E9referenceE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator14SuccessorProxyaSENSt8iteratorISt26random_access_iterator_tagT0_iPS5_S6_E9referenceE")
      //</editor-fold>
      public SuccessorProxy /*&*/ $assign(BB r) {
        it.TermInst.setSuccessor(it.idx, r);
        return /*Deref*/this;
      }


      //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccessorProxy::operator  iterator<random_access_iterator_tag, type-parameter-0-1, int, type-parameter-0-1 * , type-parameter-0-1 * >::reference">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 138,
       FQN="llvm::TerminatorInst::SuccIterator::SuccessorProxy::operator  iterator<random_access_iterator_tag, type-parameter-0-1, int, type-parameter-0-1 * , type-parameter-0-1 * >::reference", NM="_ZNK4llvm14TerminatorInst12SuccIterator14SuccessorProxycvNSt8iteratorISt26random_access_iterator_tagT0_iPS5_S6_E9referenceEEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIterator14SuccessorProxycvNSt8iteratorISt26random_access_iterator_tagT0_iPS5_S6_E9referenceEEv")
      //</editor-fold>
      public BB $BB() /*const*/ {
        return it.$star();
      }


      @Override public String toString() {
        return "" + "it=" + it; // NOI18N
      }
    };
  /*public:*/
    // begin iterator
    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccIterator<Term, BB>">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 143,
     FQN="llvm::TerminatorInst::SuccIterator::SuccIterator<Term, BB>", NM="_ZN4llvm14TerminatorInst12SuccIteratorC1ET_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorC1ET_")
    //</editor-fold>
    public /*inline*/ /*explicit*/ SuccIterator(Term T) {
      // : TermInst(T), idx(0)
      //START JInit
      this.TermInst = /*ParenListExpr*/$tryClone(T);
      this.idx = 0;
      //END JInit
    }

    // end iterator
    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::SuccIterator<Term, BB>">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 145,
     FQN="llvm::TerminatorInst::SuccIterator::SuccIterator<Term, BB>", NM="_ZN4llvm14TerminatorInst12SuccIteratorC1ET_b",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorC1ET_b")
    //</editor-fold>
    public /*inline*/ SuccIterator(Term T, boolean $Prm1) {
      // : TermInst(T)
      //START JInit
      this.TermInst = /*ParenListExpr*/$tryClone(T);
      //END JInit
      if (Native.$bool(TermInst)) {
        idx = TermInst.getNumSuccessors();
      } else {
        // Term == NULL happens, if a basic block is not fully constructed and
        // consequently getTerminator() returns NULL. In this case we construct
        // a SuccIterator which describes a basic block that has zero
        // successors.
        // Defining SuccIterator for incomplete and malformed CFGs is especially
        // useful for debugging.
        idx = 0;
      }
    }


    /// This is used to interface between code that wants to
    /// operate on terminator instructions directly.
    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::getSuccessorIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 160,
     FQN="llvm::TerminatorInst::SuccIterator::getSuccessorIndex", NM="_ZNK4llvm14TerminatorInst12SuccIterator17getSuccessorIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIterator17getSuccessorIndexEv")
    //</editor-fold>
    public /*uint*/int getSuccessorIndex() /*const*/ {
      return idx;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Override*/,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 162,
     FQN="llvm::TerminatorInst::SuccIterator::operator==", NM="_ZNK4llvm14TerminatorInst12SuccIteratoreqERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratoreqERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    @Override
    public /*inline*/ boolean $eq(final /*const*/ Object /*&*/ x) /*const*/ {
      return Native.$eq(idx, ((SuccIterator<Term, BB>) x).idx);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Override*/,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 163,
     FQN="llvm::TerminatorInst::SuccIterator::operator!=", NM="_ZNK4llvm14TerminatorInst12SuccIteratorneERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorneERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    @Override
    public /*inline*/ boolean $noteq(final /*const*/ Object /*&*/ x) /*const*/ {
      return Native.$not($eq(x));
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 165,
     FQN="llvm::TerminatorInst::SuccIterator::operator*", NM="_ZNK4llvm14TerminatorInst12SuccIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratordeEv")
    //</editor-fold>
    public /*inline*/ BB $star() /*const*/ {
      return (BB) TermInst.getSuccessor(idx);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 166,
     FQN="llvm::TerminatorInst::SuccIterator::operator->", NM="_ZNK4llvm14TerminatorInst12SuccIteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorptEv")
    //</editor-fold>
    public /*inline*/ BB $arrow() /*const*/ {
      return $star();
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 168,
     FQN="llvm::TerminatorInst::SuccIterator::operator++", NM="_ZN4llvm14TerminatorInst12SuccIteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorppEv")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> /*&*/ $preInc() {
      ++idx;
      return /*Deref*/this;
    } // Preincrement


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 173,
     FQN="llvm::TerminatorInst::SuccIterator::operator++", NM="_ZN4llvm14TerminatorInst12SuccIteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorppEi")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> $postInc(int $Prm0) {
      // Postincrement
      SuccIterator<Term, BB> tmp = /*Deref*/this;
      /*Deref*/this.$preInc();
      return tmp;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator--">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 179,
     FQN="llvm::TerminatorInst::SuccIterator::operator--", NM="_ZN4llvm14TerminatorInst12SuccIteratormmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratormmEv")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> /*&*/ $preDec() {
      --idx;
      return /*Deref*/this;
    } // Predecrement

    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator--">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 183,
     FQN="llvm::TerminatorInst::SuccIterator::operator--", NM="_ZN4llvm14TerminatorInst12SuccIteratormmEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratormmEi")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> $postDec(int $Prm0) {
      // Postdecrement
      SuccIterator<Term, BB> tmp = /*Deref*/this;
      /*Deref*/this.$preDec();
      return tmp;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 189,
     FQN="llvm::TerminatorInst::SuccIterator::operator<", NM="_ZNK4llvm14TerminatorInst12SuccIteratorltERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorltERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    public /*inline*/ boolean $less(final /*const*/ SuccIterator<Term, BB> /*&*/ x) /*const*/ {
      assert Native.$bool(Native.$eq(TermInst, x.TermInst)) : "Cannot compare iterators of different blocks!";
      return Native.$less(idx, x.idx);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator<=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 195,
     FQN="llvm::TerminatorInst::SuccIterator::operator<=", NM="_ZNK4llvm14TerminatorInst12SuccIteratorleERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorleERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    public /*inline*/ boolean $lesseq(final /*const*/ SuccIterator<Term, BB> /*&*/ x) /*const*/ {
      assert Native.$bool(Native.$eq(TermInst, x.TermInst)) : "Cannot compare iterators of different blocks!";
      return Native.$lesseq(idx, x.idx);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator>=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 200,
     FQN="llvm::TerminatorInst::SuccIterator::operator>=", NM="_ZNK4llvm14TerminatorInst12SuccIteratorgeERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorgeERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    public /*inline*/ boolean $greatereq(final /*const*/ SuccIterator<Term, BB> /*&*/ x) /*const*/ {
      assert Native.$bool(Native.$eq(TermInst, x.TermInst)) : "Cannot compare iterators of different blocks!";
      return Native.$greatereq(idx, x.idx);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 206,
     FQN="llvm::TerminatorInst::SuccIterator::operator>", NM="_ZNK4llvm14TerminatorInst12SuccIteratorgtERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorgtERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    public /*inline*/ boolean $greater(final /*const*/ SuccIterator<Term, BB> /*&*/ x) /*const*/ {
      assert Native.$bool(Native.$eq(TermInst, x.TermInst)) : "Cannot compare iterators of different blocks!";
      return Native.$greater(idx, x.idx);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator+=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 212,
     FQN="llvm::TerminatorInst::SuccIterator::operator+=", NM="_ZN4llvm14TerminatorInst12SuccIteratorpLEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorpLEi")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> /*&*/ $addassign(int Right) {
      /*uint*/int new_idx = Native.$add(idx, Right);
      assert Native.$bool(index_is_valid(new_idx)) : "Iterator index out of bound";
      idx = new_idx;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator+">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 219,
     FQN="llvm::TerminatorInst::SuccIterator::operator+", NM="_ZNK4llvm14TerminatorInst12SuccIteratorplEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratorplEi")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> $add(int Right) /*const*/ {
      SuccIterator<Term, BB> tmp = /*Deref*/this;
      tmp.$addassign(Right);
      return tmp;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator-=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 225,
     FQN="llvm::TerminatorInst::SuccIterator::operator-=", NM="_ZN4llvm14TerminatorInst12SuccIteratormIEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratormIEi")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> /*&*/ $minusassign(int Right) {
      return $addassign(-Right);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator-">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 227,
     FQN="llvm::TerminatorInst::SuccIterator::operator-", NM="_ZNK4llvm14TerminatorInst12SuccIteratormiEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratormiEi")
    //</editor-fold>
    public /*inline*/ SuccIterator<Term, BB> $sub(int Right) /*const*/ {
      return $add(-Right);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator-">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 229,
     FQN="llvm::TerminatorInst::SuccIterator::operator-", NM="_ZNK4llvm14TerminatorInst12SuccIteratormiERKNS0_12SuccIteratorIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst12SuccIteratormiERKNS0_12SuccIteratorIT_T0_EE")
    //</editor-fold>
    public /*inline*/ int $sub(final /*const*/ SuccIterator<Term, BB> /*&*/ x) /*const*/ {
      assert Native.$bool(Native.$eq(TermInst, x.TermInst)) : "Cannot work on iterators of different blocks!";
      int distance = idx - x.idx;
      return distance;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::operator[]">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 236,
     FQN="llvm::TerminatorInst::SuccIterator::operator[]", NM="_ZN4llvm14TerminatorInst12SuccIteratorixEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIteratorixEi")
    //</editor-fold>
    public /*inline*/ SuccessorProxy $at(int offset) {
      SuccIterator<Term, BB> tmp = /*Deref*/this;
      tmp.$addassign(offset);
      return new SuccessorProxy(tmp);
    }


    /// Get the source BB of this iterator.
    //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::SuccIterator::getSource">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 243,
     FQN="llvm::TerminatorInst::SuccIterator::getSource", NM="_ZN4llvm14TerminatorInst12SuccIterator9getSourceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst12SuccIterator9getSourceEv")
    //</editor-fold>
    public /*inline*/ BB /*P*/ getSource() {
      assert Native.$bool(TermInst) : "Source not available, if basic block was malformed";
      return (BB) TermInst.getParent();
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public SuccIterator(SuccIterator<Term, BB> other) {
      this.TermInst = other.TermInst;
      this.idx = other.idx;
    }

    @Override
    public SuccIterator clone() {
        return new SuccIterator(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "TermInst=" + TermInst // NOI18N
                + ", idx=" + idx // NOI18N
                + super.toString(); // NOI18N
    }
  };

  // JAVA: typedef SuccIterator<TerminatorInst *, BasicBlock> succ_iterator
//  public final class succ_iterator extends SuccIterator<TerminatorInst /*P*/ , BasicBlock>{ };
  // JAVA: typedef SuccIterator<const TerminatorInst *, const BasicBlock> succ_const_iterator
//  public final class succ_const_iterator extends SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock>{ };
  // JAVA: typedef llvm::iterator_range<succ_iterator> succ_range
//  public final class succ_range extends iterator_range<BasicBlock>{ };
  // JAVA: typedef llvm::iterator_range<succ_const_iterator> succ_const_range
//  public final class succ_const_range extends iterator_range</*const*/ BasicBlock>{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::succ_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 256,
   FQN="llvm::TerminatorInst::succ_begin", NM="_ZN4llvm14TerminatorInst10succ_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst10succ_beginEv")
  //</editor-fold>
  private /*inline*/ SuccIterator<TerminatorInst /*P*/ , BasicBlock> succ_begin() {
    return new SuccIterator<TerminatorInst /*P*/ , BasicBlock>(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::succ_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 257,
   FQN="llvm::TerminatorInst::succ_begin", NM="_ZNK4llvm14TerminatorInst10succ_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst10succ_beginEv")
  //</editor-fold>
  private /*inline*/ SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> succ_begin$Const() /*const*/ {
    return new SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock>(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::succ_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 260,
   FQN="llvm::TerminatorInst::succ_end", NM="_ZN4llvm14TerminatorInst8succ_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst8succ_endEv")
  //</editor-fold>
  private /*inline*/ SuccIterator<TerminatorInst /*P*/ , BasicBlock> succ_end() {
    return new SuccIterator<TerminatorInst /*P*/ , BasicBlock>(this, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::succ_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 261,
   FQN="llvm::TerminatorInst::succ_end", NM="_ZNK4llvm14TerminatorInst8succ_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst8succ_endEv")
  //</editor-fold>
  private /*inline*/ SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> succ_end$Const() /*const*/ {
    return new SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock>(this, true);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::successors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 266,
   FQN="llvm::TerminatorInst::successors", NM="_ZN4llvm14TerminatorInst10successorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm14TerminatorInst10successorsEv")
  //</editor-fold>
  public /*inline*/ iterator_range<BasicBlock> successors() {
    return new iterator_range<BasicBlock>(succ_begin(), succ_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TerminatorInst::successors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 269,
   FQN="llvm::TerminatorInst::successors", NM="_ZNK4llvm14TerminatorInst10successorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm14TerminatorInst10successorsEv")
  //</editor-fold>
  public /*inline*/ iterator_range</*const*/ BasicBlock> successors$Const() /*const*/ {
    return new iterator_range</*const*/ BasicBlock>(succ_begin$Const(), succ_end$Const());
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
