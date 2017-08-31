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


// This class implements inst_begin() & inst_end() for
// inst_iterator and const_inst_iterator's.
//
/*template <class BB_t, class BB_i_t, class BI_t, class II_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::InstIterator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 30,
 FQN="llvm::InstIterator", NM="_ZN4llvm12InstIteratorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIteratorE")
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm12InstIteratorE")
//</editor-fold>
public class InstIterator<
        /*class*/ BB_t extends SymbolTableList<BasicBlock, Function>,
        /*class*/ BB_i_t extends ilist_iterator<BasicBlock>,
        /*class*/ BI_t extends ilist_iterator<Instruction>,
        /*class*/ II_t extends Instruction>  implements Native.NativeComparable, type$iterator<InstIterator, II_t>  {
  /*typedef BB_t BBty*/
//  public final class BBty extends BB_t{ };
  // JAVA: typedef BB_i_t BBIty
//  public final class BBIty extends BB_i_t{ };
  // JAVA: typedef BI_t BIty
//  public final class BIty extends BI_t{ };
  // JAVA: typedef II_t IIty
//  public final class IIty extends II_t{ };
  private BB_t /*P*/ BBs; // BasicBlocksType
  private BB_i_t BB; // BasicBlocksType::iterator
  private BI_t BI; // BasicBlock::iterator
/*public:*/
  // JAVA: typedef std::bidirectional_iterator_tag iterator_category
//  public final class iterator_category extends std.bidirectional_iterator_tag{ };
  // JAVA: typedef IIty value_type
//  public final class value_type extends II_t{ };
  // JAVA: typedef int difference_type;
  // JAVA: typedef IIty *pointer
//  public final class pointer extends II_t /*P*/ { };
  // JAVA: typedef IIty &reference
//  public final class reference extends II_t /*&*/ { };

  // Default constructor
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 46,
   FQN="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>", NM="_ZN4llvm12InstIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIteratorC1Ev")
  //</editor-fold>
  public InstIterator() {
  }


  // Copy constructor...
  /*template <typename A, typename B, typename C, typename D> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 50,
   FQN="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>", NM="Tpl__ZN4llvm12InstIteratorC1ERKNS_12InstIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=Tpl__ZN4llvm12InstIteratorC1ERKNS_12InstIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public InstIterator(JD$InstIterator$A$B$C$D$C _dparam, final /*const*/ InstIterator<BB_t, BB_i_t, BI_t, II_t> /*&*/ II) {
    // : BBs(II.BBs), BB(II.BB), BI(II.BI)
    //START JInit
    this.BBs = /*ParenListExpr*/II.BBs;
    this.BB = (BB_i_t) new /*BB_i_t*/ilist_iterator<BasicBlock>(II.BB);
    this.BI = (BI_t) new /*BI_t*/ ilist_iterator<Instruction>(II.BI);
    //END JInit
  }


  /*template <typename A, typename B, typename C, typename D> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 54,
   FQN="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>", NM="Tpl__ZN4llvm12InstIteratorC1ERNS_12InstIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=Tpl__ZN4llvm12InstIteratorC1ERNS_12InstIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public InstIterator(JD$InstIterator$A$B$C$D _dparam, final InstIterator<BB_t, BB_i_t, BI_t, II_t> /*&*/ II) {
    // : BBs(II.BBs), BB(II.BB), BI(II.BI)
    //START JInit
    this.BBs = /*ParenListExpr*/II.BBs;
    this.BB = /*ParenListExpr*/(BB_i_t) new /*BB_i_t*/ilist_iterator<BasicBlock>(II.BB);
    this.BI = /*ParenListExpr*/(BI_t) new /*BI_t*/ ilist_iterator<Instruction>(II.BI);
    //END JInit
  }


  /*template <class M> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 57,
   FQN="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>", NM="Tpl__ZN4llvm12InstIteratorC1ERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=Tpl__ZN4llvm12InstIteratorC1ERT_")
  //</editor-fold>
  public </*class*/ M extends Function> InstIterator(final M /*&*/ m) {
    // : BBs(&m.getBasicBlockList()), BB(BBs->begin())
    //START JInit
    if(false) {
      m.getBasicBlockList();
    }
    this.BBs = /*ParenListExpr*/(BB_t) $AddrOf(m.getBasicBlockList());
    this.BB = (BB_i_t) new /*BB_i_t*/ilist_iterator<BasicBlock>(BBs.begin());
    //END JInit
    // begin ctor
    if (Native.$noteq(BB, BBs.end())) {
      BI = (BI_t) BB.$arrow().begin();
      advanceToNextBB();
    }
  }


  /*template <class M> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 65,
   FQN="llvm::InstIterator::InstIterator<BB_t, BB_i_t, BI_t, II_t>", NM="Tpl__ZN4llvm12InstIteratorC1ERT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=Tpl__ZN4llvm12InstIteratorC1ERT_b")
  //</editor-fold>
  public </*class*/ M extends Function> InstIterator(final M /*&*/ m, boolean $Prm1) {
    // : BBs(&m.getBasicBlockList()), BB(BBs->end())
    //START JInit
    this.BBs = /*ParenListExpr*/(BB_t)$AddrOf(m.getBasicBlockList());
    this.BB = (BB_i_t) new /*BB_i_t*/ilist_iterator<BasicBlock>(BBs.end());
    //END JInit
    // end ctor
  }


  // Accessors to get at the underlying iterators...
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::getBasicBlockIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 70,
   FQN="llvm::InstIterator::getBasicBlockIterator", NM="_ZN4llvm12InstIterator21getBasicBlockIteratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIterator21getBasicBlockIteratorEv")
  //</editor-fold>
  public /*inline*/ BB_i_t /*&*/ getBasicBlockIterator() {
    return BB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::getInstructionIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 71,
   FQN="llvm::InstIterator::getInstructionIterator", NM="_ZN4llvm12InstIterator22getInstructionIteratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIterator22getInstructionIteratorEv")
  //</editor-fold>
  public /*inline*/ BI_t /*&*/ getInstructionIterator() {
    return BI;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 73,
   FQN="llvm::InstIterator::operator*", NM="_ZNK4llvm12InstIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZNK4llvm12InstIteratordeEv")
  //</editor-fold>
  public /*inline*/ II_t /*&*/ $star() /*const*/ {
    return (II_t) $Deref(BI);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 74,
   FQN="llvm::InstIterator::operator->", NM="_ZNK4llvm12InstIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZNK4llvm12InstIteratorptEv")
  //</editor-fold>
  public /*inline*/ II_t /*P*/ $arrow() /*const*/ {
    return $AddrOf($star());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 76,
   FQN="llvm::InstIterator::operator==", NM="_ZNK4llvm12InstIteratoreqERKNS_12InstIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZNK4llvm12InstIteratoreqERKNS_12InstIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ InstIterator<BB_t, BB_i_t, BI_t, II_t> /*&*/ y) /*const*/ {
    return Native.$bool(Native.$eq(BB, y.BB)) && Native.$bool((Native.$bool(Native.$eq(BB, BBs.end())) || Native.$bool(Native.$eq(BI, y.BI))));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 79,
   FQN="llvm::InstIterator::operator!=", NM="_ZNK4llvm12InstIteratorneERKNS_12InstIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZNK4llvm12InstIteratorneERKNS_12InstIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ InstIterator<BB_t, BB_i_t, BI_t, II_t> /*&*/ y) /*const*/ {
    return Native.$not($eq(y));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 83,
   FQN="llvm::InstIterator::operator++", NM="_ZN4llvm12InstIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIteratorppEv")
  //</editor-fold>
  public InstIterator<BB_t, BB_i_t, BI_t, II_t> /*&*/ $preInc() {
    BI.$preInc();
    advanceToNextBB();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 88,
   FQN="llvm::InstIterator::operator++", NM="_ZN4llvm12InstIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIteratorppEi")
  //</editor-fold>
  public /*inline*/ InstIterator<BB_t, BB_i_t, BI_t, II_t> $postInc(int $Prm0) {
    InstIterator<BB_t, BB_i_t, BI_t, II_t> tmp = /*Deref*/this;
    /*Deref*/this.$preInc();
    return tmp;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 92,
   FQN="llvm::InstIterator::operator--", NM="_ZN4llvm12InstIteratormmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIteratormmEv")
  //</editor-fold>
  public InstIterator<BB_t, BB_i_t, BI_t, II_t> /*&*/ $preDec() {
    while (Native.$bool(Native.$eq(BB, BBs.end())) || Native.$bool(Native.$eq(BI, BB.$arrow().begin()))) {
      BB.$preDec();
      BI = (BI_t) BB.$arrow().end();
    }
    BI.$preDec();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 100,
   FQN="llvm::InstIterator::operator--", NM="_ZN4llvm12InstIteratormmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIteratormmEi")
  //</editor-fold>
  public /*inline*/ InstIterator<BB_t, BB_i_t, BI_t, II_t> $postDec(int $Prm0) {
    InstIterator<BB_t, BB_i_t, BI_t, II_t> tmp = /*Deref*/this;
    /*Deref*/this.$preDec();
    return tmp;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::atEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 104,
   FQN="llvm::InstIterator::atEnd", NM="_ZNK4llvm12InstIterator5atEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZNK4llvm12InstIterator5atEndEv")
  //</editor-fold>
  public /*inline*/ boolean atEnd() /*const*/ {
    return Native.$eq(BB, BBs.end());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstIterator::advanceToNextBB">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 107,
   FQN="llvm::InstIterator::advanceToNextBB", NM="_ZN4llvm12InstIterator15advanceToNextBBEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12InstIterator15advanceToNextBBEv")
  //</editor-fold>
  private /*inline*/ void advanceToNextBB() {
    // The only way that the II could be broken is if it is now pointing to
    // the end() of the current BasicBlock and there are successor BBs.
    while (Native.$eq(BI, BB.$arrow().end())) {
      BB.$preInc();
      if (Native.$eq(BB, BBs.end())) {
        break;
      }
      BI = (BI_t) BB.$arrow().begin();
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public  InstIterator(InstIterator</*class*/ BB_t, /*class*/ BB_i_t, /*class*/ BI_t, /*class*/ II_t> other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  @Override
  public InstIterator</*class*/ BB_t, /*class*/ BB_i_t, /*class*/ BI_t, /*class*/ II_t>  clone() {
    return new InstIterator(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "BBs=" + BBs // NOI18N
              + ", BB=" + BB // NOI18N
              + ", BI=" + BI; // NOI18N
  }
}
