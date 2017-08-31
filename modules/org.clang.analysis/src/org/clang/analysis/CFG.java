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

package org.clang.analysis;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.support.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.CFGStatics.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.llvm.support.AdtsupportLlvmGlobals.ViewGraph;


/// CFG - Represents a source-level, intra-procedural CFG that represents the
///  control-flow of a Stmt.  The Stmt can represent an entire function body,
///  or a single expression.  A CFG will always contain one empty block that
///  represents the Exit point of the CFG.  A CFG will also contain a designated
///  Entry block.  The CFG solely represents control-flow; it consists of
///  CFGBlocks which are simply containers of Stmt*'s in the AST the CFG
///  was constructed from.
//<editor-fold defaultstate="collapsed" desc="clang::CFG">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 721,
 FQN="clang::CFG", NM="_ZN5clang3CFGE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFGE")
//</editor-fold>
public class CFG implements Iterable<CFGBlock /*P*/>, NativeReverseIterable<std.reverse_iterator<CFGBlock /*P*/>>, Destructors.ClassWithDestructor {
/*public:*/
  //===--------------------------------------------------------------------===//
  // CFG Construction & Manipulation.
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::BuildOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 727,
   FQN="clang::CFG::BuildOptions", NM="_ZN5clang3CFG12BuildOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG12BuildOptionsE")
  //</editor-fold>
  public static class BuildOptions {
    private std.bitset/*<Stmt.StmtClass.lastStmtConstant>*/ alwaysAddMask;
  /*public:*/
    /*typedef llvm::DenseMap<const Stmt *, const CFGBlock *> ForcedBlkExprs*/
//    public final class ForcedBlkExprs extends DenseMap</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ >{ };
    public type$ptr<DenseMap</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > /*P*/ /*P*/> forcedBlkExprs;
    public CFGCallback /*P*/ Observer;
    public boolean PruneTriviallyFalseEdges;
    public boolean AddEHEdges;
    public boolean AddInitializers;
    public boolean AddImplicitDtors;
    public boolean AddTemporaryDtors;
    public boolean AddStaticInitBranches;
    public boolean AddCXXNewAllocator;
    public boolean AddCXXDefaultInitExprInCtors;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::BuildOptions::alwaysAdd">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 742,
     FQN="clang::CFG::BuildOptions::alwaysAdd", NM="_ZNK5clang3CFG12BuildOptions9alwaysAddEPKNS_4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG12BuildOptions9alwaysAddEPKNS_4StmtE")
    //</editor-fold>
    public boolean alwaysAdd(/*const*/ Stmt /*P*/ stmt) /*const*/ {
      return alwaysAddMask.$at$Const(stmt.getStmtClass().getValue());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::BuildOptions::setAlwaysAdd">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 746,
     FQN="clang::CFG::BuildOptions::setAlwaysAdd", NM="_ZN5clang3CFG12BuildOptions12setAlwaysAddENS_4Stmt9StmtClassEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG12BuildOptions12setAlwaysAddENS_4Stmt9StmtClassEb")
    //</editor-fold>
    public BuildOptions /*&*/ setAlwaysAdd(Stmt.StmtClass stmtClass) {
      return setAlwaysAdd(stmtClass, true);
    }
    public BuildOptions /*&*/ setAlwaysAdd(Stmt.StmtClass stmtClass, boolean val/*= true*/) {
      alwaysAddMask.set(/*KEEP_ENUM*/stmtClass.getValue(), /*KEEP_BOOL*/val);
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::BuildOptions::setAllAlwaysAdd">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 751,
     FQN="clang::CFG::BuildOptions::setAllAlwaysAdd", NM="_ZN5clang3CFG12BuildOptions15setAllAlwaysAddEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG12BuildOptions15setAllAlwaysAddEv")
    //</editor-fold>
    public BuildOptions /*&*/ setAllAlwaysAdd() {
      alwaysAddMask.set();
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::BuildOptions::BuildOptions">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 756,
     FQN="clang::CFG::BuildOptions::BuildOptions", NM="_ZN5clang3CFG12BuildOptionsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG12BuildOptionsC1Ev")
    //</editor-fold>
    public BuildOptions() {
      // : alwaysAddMask(), forcedBlkExprs(null), Observer(null), PruneTriviallyFalseEdges(true), AddEHEdges(false), AddInitializers(false), AddImplicitDtors(false), AddTemporaryDtors(false), AddStaticInitBranches(false), AddCXXNewAllocator(false), AddCXXDefaultInitExprInCtors(false) 
      //START JInit
      this.alwaysAddMask = new std.bitset(Stmt.StmtClass.lastStmtConstant.getValue());
      this.forcedBlkExprs = null;
      this.Observer = null;
      this.PruneTriviallyFalseEdges = true;
      this.AddEHEdges = false;
      this.AddInitializers = false;
      this.AddImplicitDtors = false;
      this.AddTemporaryDtors = false;
      this.AddStaticInitBranches = false;
      this.AddCXXNewAllocator = false;
      this.AddCXXDefaultInitExprInCtors = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::BuildOptions::BuildOptions">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 727,
     FQN="clang::CFG::BuildOptions::BuildOptions", NM="_ZN5clang3CFG12BuildOptionsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG12BuildOptionsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ BuildOptions(final /*const*/ BuildOptions /*&*/ $Prm0) {
      // : alwaysAddMask(.alwaysAddMask), forcedBlkExprs(.forcedBlkExprs), Observer(.Observer), PruneTriviallyFalseEdges(.PruneTriviallyFalseEdges), AddEHEdges(.AddEHEdges), AddInitializers(.AddInitializers), AddImplicitDtors(.AddImplicitDtors), AddTemporaryDtors(.AddTemporaryDtors), AddStaticInitBranches(.AddStaticInitBranches), AddCXXNewAllocator(.AddCXXNewAllocator), AddCXXDefaultInitExprInCtors(.AddCXXDefaultInitExprInCtors) 
      //START JInit
      this.alwaysAddMask = new std.bitset(/*Stmt.StmtClass.lastStmtConstant.getValue(), */$Prm0.alwaysAddMask);
      this.forcedBlkExprs = $tryClone($Prm0.forcedBlkExprs);
      this.Observer = $Prm0.Observer;
      this.PruneTriviallyFalseEdges = $Prm0.PruneTriviallyFalseEdges;
      this.AddEHEdges = $Prm0.AddEHEdges;
      this.AddInitializers = $Prm0.AddInitializers;
      this.AddImplicitDtors = $Prm0.AddImplicitDtors;
      this.AddTemporaryDtors = $Prm0.AddTemporaryDtors;
      this.AddStaticInitBranches = $Prm0.AddStaticInitBranches;
      this.AddCXXNewAllocator = $Prm0.AddCXXNewAllocator;
      this.AddCXXDefaultInitExprInCtors = $Prm0.AddCXXDefaultInitExprInCtors;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "alwaysAddMask=" + alwaysAddMask // NOI18N
                + ", forcedBlkExprs=" + forcedBlkExprs // NOI18N
                + ", Observer=" + Observer // NOI18N
                + ", PruneTriviallyFalseEdges=" + PruneTriviallyFalseEdges // NOI18N
                + ", AddEHEdges=" + AddEHEdges // NOI18N
                + ", AddInitializers=" + AddInitializers // NOI18N
                + ", AddImplicitDtors=" + AddImplicitDtors // NOI18N
                + ", AddTemporaryDtors=" + AddTemporaryDtors // NOI18N
                + ", AddStaticInitBranches=" + AddStaticInitBranches // NOI18N
                + ", AddCXXNewAllocator=" + AddCXXNewAllocator // NOI18N
                + ", AddCXXDefaultInitExprInCtors=" + AddCXXDefaultInitExprInCtors; // NOI18N
    }
  };
  
  /// \brief Provides a custom implementation of the iterator class to have the
  /// same interface as Function::iterator - iterator returns CFGBlock
  /// (not a pointer to CFGBlock).
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 767,
   FQN="clang::CFG::graph_iterator", NM="_ZN5clang3CFG14graph_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG14graph_iteratorE")
  //</editor-fold>
  public static class graph_iterator implements type$iterator<graph_iterator, CFGBlock> {
  /*public:*/
    /*typedef CFGBlock value_type*/
//    public final class value_type extends CFGBlock{ };
    /*typedef value_type &reference*/
//    public final class reference extends CFGBlock /*&*/ { };
    /*typedef value_type *pointer*/
//    public final class pointer extends CFGBlock /*P*/ { };
    /*typedef BumpVector<CFGBlock *>::iterator ImplTy*/
//    public final class ImplTy extends type$ptr<CFGBlock /*P*/ /*P*/>{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::graph_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 774,
     FQN="clang::CFG::graph_iterator::graph_iterator", NM="_ZN5clang3CFG14graph_iteratorC1ERKPPNS_8CFGBlockE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG14graph_iteratorC1ERKPPNS_8CFGBlockE")
    //</editor-fold>
    public graph_iterator(final type$ptr<CFGBlock /*P*/ /*const*/ /*&*/> i) {
      // : I(i) 
      //START JInit
      this.I = $tryClone(i);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 776,
     FQN="clang::CFG::graph_iterator::operator==", NM="_ZNK5clang3CFG14graph_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG14graph_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ graph_iterator /*&*/ X) /*const*/ {
      return $eq_ptr(I, X.I);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 777,
     FQN="clang::CFG::graph_iterator::operator!=", NM="_ZNK5clang3CFG14graph_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG14graph_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ graph_iterator /*&*/ X) /*const*/ {
      return $noteq_ptr(I, X.I);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 779,
     FQN="clang::CFG::graph_iterator::operator*", NM="_ZNK5clang3CFG14graph_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG14graph_iteratordeEv")
    //</editor-fold>
    public CFGBlock /*&*/ $star() /*const*/ {
      return $Deref($Deref(I.$star()));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 780,
     FQN="clang::CFG::graph_iterator::operator->", NM="_ZNK5clang3CFG14graph_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG14graph_iteratorptEv")
    //</editor-fold>
    public CFGBlock /*P*/ $arrow() /*const*/ {
      return $Deref(I.$arrow());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator CFGBlock * ">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 781,
     FQN="clang::CFG::graph_iterator::operator CFGBlock * ", NM="_ZN5clang3CFG14graph_iteratorcvPNS_8CFGBlockEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG14graph_iteratorcvPNS_8CFGBlockEEv")
    //</editor-fold>
    public CFGBlock /*P*/ $CFGBlock$P() {
      return $Deref(I.$star());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 783,
     FQN="clang::CFG::graph_iterator::operator++", NM="_ZN5clang3CFG14graph_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG14graph_iteratorppEv")
    //</editor-fold>
    public graph_iterator /*&*/ $preInc() {
      I.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::operator--">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 784,
     FQN="clang::CFG::graph_iterator::operator--", NM="_ZN5clang3CFG14graph_iteratormmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG14graph_iteratormmEv")
    //</editor-fold>
    public graph_iterator /*&*/ $preDec() {
      I.$preDec();
      return /*Deref*/this;
    }

  /*private:*/
    private type$ptr<CFGBlock /*P*/> I;
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::graph_iterator::graph_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 767,
     FQN="clang::CFG::graph_iterator::graph_iterator", NM="_ZN5clang3CFG14graph_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG14graph_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ graph_iterator(JD$Move _dparam, final graph_iterator /*&&*/$Prm0) {
      // : I(static_cast<graph_iterator &&>().I) 
      //START JInit
      this.I = $tryClone($Prm0.I);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public @Override graph_iterator clone() { return new graph_iterator($tryClone(I)); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "I=" + I; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 790,
   FQN="clang::CFG::const_graph_iterator", NM="_ZN5clang3CFG20const_graph_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20const_graph_iteratorE")
  //</editor-fold>
  public static class const_graph_iterator implements type$iterator<const_graph_iterator, CFGBlock> {
  /*public:*/
    /*typedef const CFGBlock value_type*/
//    public final class value_type extends /*const*/ CFGBlock{ };
    /*typedef value_type &reference*/
//    public final class reference extends /*const*/ CFGBlock /*&*/ { };
    /*typedef value_type *pointer*/
//    public final class pointer extends /*const*/ CFGBlock /*P*/ { };
    /*typedef BumpVector<CFGBlock *>::const_iterator ImplTy*/
//    public final class ImplTy extends type$ptr<CFGBlock /*P*/ /*const*/ /*P*/>{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::const_graph_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 797,
     FQN="clang::CFG::const_graph_iterator::const_graph_iterator", NM="_ZN5clang3CFG20const_graph_iteratorC1ERKPKPNS_8CFGBlockE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20const_graph_iteratorC1ERKPKPNS_8CFGBlockE")
    //</editor-fold>
    public const_graph_iterator(final type$ptr</*const*/ CFGBlock /*P*/ /*const*/ /*&*/> i) {
      // : I(i) 
      //START JInit
      this.I = $tryClone(i);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 799,
     FQN="clang::CFG::const_graph_iterator::operator==", NM="_ZNK5clang3CFG20const_graph_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20const_graph_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ const_graph_iterator /*&*/ X) /*const*/ {
      return $eq_ptr(I, X.I);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 800,
     FQN="clang::CFG::const_graph_iterator::operator!=", NM="_ZNK5clang3CFG20const_graph_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20const_graph_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ const_graph_iterator /*&*/ X) /*const*/ {
      return $noteq_ptr(I, X.I);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 802,
     FQN="clang::CFG::const_graph_iterator::operator*", NM="_ZNK5clang3CFG20const_graph_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20const_graph_iteratordeEv")
    //</editor-fold>
    public /*const*/ CFGBlock /*&*/ $star() /*const*/ {
      return $Deref($Deref(I.$star()));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 803,
     FQN="clang::CFG::const_graph_iterator::operator->", NM="_ZNK5clang3CFG20const_graph_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20const_graph_iteratorptEv")
    //</editor-fold>
    public /*const*/ CFGBlock /*P*/ $arrow() /*const*/ {
      return $Deref(I.$arrow());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator CFGBlock * ">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 804,
     FQN="clang::CFG::const_graph_iterator::operator CFGBlock * ", NM="_ZNK5clang3CFG20const_graph_iteratorcvPNS_8CFGBlockEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20const_graph_iteratorcvPNS_8CFGBlockEEv")
    //</editor-fold>
    public CFGBlock /*P*/ $CFGBlock$P() /*const*/ {
      return $Deref(I.$star());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 806,
     FQN="clang::CFG::const_graph_iterator::operator++", NM="_ZN5clang3CFG20const_graph_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20const_graph_iteratorppEv")
    //</editor-fold>
    public const_graph_iterator /*&*/ $preInc() {
      I.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::operator--">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 807,
     FQN="clang::CFG::const_graph_iterator::operator--", NM="_ZN5clang3CFG20const_graph_iteratormmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20const_graph_iteratormmEv")
    //</editor-fold>
    public const_graph_iterator /*&*/ $preDec() {
      I.$preDec();
      return /*Deref*/this;
    }

  /*private:*/
    private type$ptr</*const*/ CFGBlock /*P*/> I;
    //<editor-fold defaultstate="collapsed" desc="clang::CFG::const_graph_iterator::const_graph_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 790,
     FQN="clang::CFG::const_graph_iterator::const_graph_iterator", NM="_ZN5clang3CFG20const_graph_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20const_graph_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ const_graph_iterator(JD$Move _dparam, final const_graph_iterator /*&&*/$Prm0) {
      // : I(static_cast<const_graph_iterator &&>().I) 
      //START JInit
      this.I = $Prm0.I;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public @Override const_graph_iterator clone() { return new const_graph_iterator($tryClone(I)); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "I=" + I; // NOI18N
    }
  };
  
  /// buildCFG - Builds a CFG from an AST.
  
  /// buildCFG - Builds a CFG from an AST.
  
  /// buildCFG - Constructs a CFG from an AST.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::buildCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3888,
   FQN="clang::CFG::buildCFG", NM="_ZN5clang3CFG8buildCFGEPKNS_4DeclEPNS_4StmtEPNS_10ASTContextERKNS0_12BuildOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang3CFG8buildCFGEPKNS_4DeclEPNS_4StmtEPNS_10ASTContextERKNS0_12BuildOptionsE")
  //</editor-fold>
  public static std.unique_ptr<CFG> buildCFG(/*const*/ Decl /*P*/ D, Stmt /*P*/ Statement, 
          ASTContext /*P*/ C, final /*const*/ BuildOptions /*&*/ BO) {
    CFGBuilder Builder = null;
    try {
      Builder/*J*/= new CFGBuilder(C, BO);
      return Builder.buildCFG(D, Statement);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }


  
  /// createBlock - Create a new block in the CFG.  The CFG owns the block;
  ///  the caller should not directly free it.
  
  /// createBlock - Create a new block in the CFG.  The CFG owns the block;
  ///  the caller should not directly free it.
  // end anonymous namespace
  
  /// createBlock - Constructs and adds a new CFGBlock to the CFG.  The block has
  ///  no successors or predecessors.  If this is the first block created in the
  ///  CFG, it is automatically set to be the Entry and Exit of the CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::createBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3871,
   FQN="clang::CFG::createBlock", NM="_ZN5clang3CFG11createBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang3CFG11createBlockEv")
  //</editor-fold>
  public CFGBlock /*P*/ createBlock() {
    boolean first_block = $eq_ptr(begin(), end());
    
    // Create the block.
    CFGBlock /*P*/ Mem = getAllocator().Allocate$T(CFGBlock.class);
    /*NEW_EXPR [System]*/Mem = /*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new CFGBlock(NumBlockIDs++, BlkBVC, this);
     });
    Blocks.push_back(Mem, BlkBVC);
    
    // If this is the first block, set it as the Entry and Exit.
    if (first_block) {
      Entry = Exit = $AddrOf($toConst(back$ptr()));
    }
    
    // Return the block.
    return $AddrOf(back());
  }


  
  /// setEntry - Set the entry block of the CFG.  This is typically used
  ///  only during CFG construction.  Most CFG clients expect that the
  ///  entry block has no predecessors and contains no statements.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::setEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 824,
   FQN="clang::CFG::setEntry", NM="_ZN5clang3CFG8setEntryEPNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG8setEntryEPNS_8CFGBlockE")
  //</editor-fold>
  public void setEntry(CFGBlock /*P*/ B) {
    // JAVA: find input B in out Blocks collection and point vs. signle pointer around intput B
    Entry = find$EntryPtr(B);
  }

  
  /// setIndirectGotoBlock - Set the block used for indirect goto jumps.
  ///  This is typically used only during CFG construction.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::setIndirectGotoBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 828,
   FQN="clang::CFG::setIndirectGotoBlock", NM="_ZN5clang3CFG20setIndirectGotoBlockEPNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20setIndirectGotoBlockEPNS_8CFGBlockE")
  //</editor-fold>
  public void setIndirectGotoBlock(CFGBlock /*P*/ B) {
    // JAVA: find input B in out Blocks collection and point vs. signle pointer around intput B
    IndirectGotoBlock = find$EntryPtr(B);
  }

  
  //===--------------------------------------------------------------------===//
  // Block Iterators
  //===--------------------------------------------------------------------===//
  /*typedef BumpVector<CFGBlock *> CFGBlockListTy*/
//  public final class CFGBlockListTy extends BumpVector<CFGBlock /*P*/ >{ };
  /*typedef CFGBlockListTy::iterator iterator*/
//  public final class iterator extends type$ptr<CFGBlock>{ };
  /*typedef CFGBlockListTy::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr<CFGBlock>{ };
  /*typedef std::reverse_iterator<iterator> reverse_iterator*/
//  public final class reverse_iterator extends std.reverse_iterator<CFGBlock /*P*/ >{ };
  /*typedef std::reverse_iterator<const_iterator> const_reverse_iterator*/
//  public final class const_reverse_iterator extends std.reverse_iterator<CFGBlock /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 840,
   FQN="clang::CFG::front", NM="_ZN5clang3CFG5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG5frontEv")
  //</editor-fold>
  public CFGBlock /*&*/ front() {
    return $Deref(Blocks.front());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 841,
   FQN="clang::CFG::back", NM="_ZN5clang3CFG4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG4backEv")
  //</editor-fold>
  public CFGBlock /*&*/ back() {
    return $Deref(Blocks.back());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::back">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED/*access to cell*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 841,
   FQN="clang::CFG::back", NM="_ZN5clang3CFG4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG4backEv")
  //</editor-fold>
  public type$ptr<CFGBlock> /*&*/ back$ptr() {
    return Blocks.back$ptr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 843,
   FQN="clang::CFG::begin", NM="_ZN5clang3CFG5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG5beginEv")
  //</editor-fold>
  public type$ptr<CFGBlock> begin() {
    return Blocks.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 844,
   FQN="clang::CFG::end", NM="_ZN5clang3CFG3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG3endEv")
  //</editor-fold>
  public type$ptr<CFGBlock> end() {
    return Blocks.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 845,
   FQN="clang::CFG::begin", NM="_ZNK5clang3CFG5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG5beginEv")
  //</editor-fold>
  public type$ptr<CFGBlock> begin$Const() /*const*/ {
    return Blocks.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 846,
   FQN="clang::CFG::end", NM="_ZNK5clang3CFG3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG3endEv")
  //</editor-fold>
  public type$ptr<CFGBlock> end$Const() /*const*/ {
    return Blocks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::nodes_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 848,
   FQN="clang::CFG::nodes_begin", NM="_ZN5clang3CFG11nodes_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG11nodes_beginEv")
  //</editor-fold>
  public graph_iterator nodes_begin() {
    return new graph_iterator(Blocks.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::nodes_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 849,
   FQN="clang::CFG::nodes_end", NM="_ZN5clang3CFG9nodes_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG9nodes_endEv")
  //</editor-fold>
  public graph_iterator nodes_end() {
    return new graph_iterator(Blocks.end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::nodes_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 850,
   FQN="clang::CFG::nodes_begin", NM="_ZNK5clang3CFG11nodes_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG11nodes_beginEv")
  //</editor-fold>
  public const_graph_iterator nodes_begin$Const() /*const*/ {
    return new const_graph_iterator(Blocks.begin$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::nodes_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 853,
   FQN="clang::CFG::nodes_end", NM="_ZNK5clang3CFG9nodes_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG9nodes_endEv")
  //</editor-fold>
  public const_graph_iterator nodes_end$Const() /*const*/ {
    return new const_graph_iterator(Blocks.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 857,
   FQN="clang::CFG::rbegin", NM="_ZN5clang3CFG6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<CFGBlock /*P*/ > rbegin() {
    return Blocks.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 858,
   FQN="clang::CFG::rend", NM="_ZN5clang3CFG4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG4rendEv")
  //</editor-fold>
  public std.reverse_iterator<CFGBlock /*P*/ > rend() {
    return Blocks.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 859,
   FQN="clang::CFG::rbegin", NM="_ZNK5clang3CFG6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<CFGBlock /*P*/ /*const*/> rbegin$Const() /*const*/ {
    return Blocks.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 860,
   FQN="clang::CFG::rend", NM="_ZNK5clang3CFG4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG4rendEv")
  //</editor-fold>
  public std.reverse_iterator<CFGBlock /*P*/ /*const*/> rend$Const() /*const*/ {
    return Blocks.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 862,
   FQN="clang::CFG::getEntry", NM="_ZN5clang3CFG8getEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG8getEntryEv")
  //</editor-fold>
  public CFGBlock /*&*/ getEntry() {
    return $Deref(Entry.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 863,
   FQN="clang::CFG::getEntry", NM="_ZNK5clang3CFG8getEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG8getEntryEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*&*/ getEntry$Const() /*const*/ {
    return $Deref(Entry.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getExit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 864,
   FQN="clang::CFG::getExit", NM="_ZN5clang3CFG7getExitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG7getExitEv")
  //</editor-fold>
  public CFGBlock /*&*/ getExit() {
    return $Deref(Exit.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getExit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 865,
   FQN="clang::CFG::getExit", NM="_ZNK5clang3CFG7getExitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG7getExitEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*&*/ getExit$Const() /*const*/ {
    return $Deref(Exit.$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getIndirectGotoBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 867,
   FQN="clang::CFG::getIndirectGotoBlock", NM="_ZN5clang3CFG20getIndirectGotoBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20getIndirectGotoBlockEv")
  //</editor-fold>
  public CFGBlock /*P*/ getIndirectGotoBlock() {
    return IndirectGotoBlock == null ? null : IndirectGotoBlock.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getIndirectGotoBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 868,
   FQN="clang::CFG::getIndirectGotoBlock", NM="_ZNK5clang3CFG20getIndirectGotoBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20getIndirectGotoBlockEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getIndirectGotoBlock$Const() /*const*/ {
    return IndirectGotoBlock == null ? null : IndirectGotoBlock.$star();
  }

  
  /*typedef std::vector<const CFGBlock *>::const_iterator try_block_iterator*/
//  public final class try_block_iterator extends std.vector.iterator</*const*/ CFGBlock /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::try_blocks_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 871,
   FQN="clang::CFG::try_blocks_begin", NM="_ZNK5clang3CFG16try_blocks_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG16try_blocks_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ CFGBlock /*P*/> try_blocks_begin() /*const*/ {
    return TryDispatchBlocks.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFG::try_blocks_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 874,
   FQN="clang::CFG::try_blocks_end", NM="_ZNK5clang3CFG14try_blocks_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG14try_blocks_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ CFGBlock /*P*/> try_blocks_end() /*const*/ {
    return TryDispatchBlocks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::addTryDispatchBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 878,
   FQN="clang::CFG::addTryDispatchBlock", NM="_ZN5clang3CFG19addTryDispatchBlockEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG19addTryDispatchBlockEPKNS_8CFGBlockE")
  //</editor-fold>
  public void addTryDispatchBlock(/*const*/ CFGBlock /*P*/ block) {
    TryDispatchBlocks.push_back_T$C$R(block);
  }

  
  /// Records a synthetic DeclStmt and the DeclStmt it was constructed from.
  ///
  /// The CFG uses synthetic DeclStmts when a single AST DeclStmt contains
  /// multiple decls.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::addSyntheticDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 886,
   FQN="clang::CFG::addSyntheticDeclStmt", NM="_ZN5clang3CFG20addSyntheticDeclStmtEPKNS_8DeclStmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20addSyntheticDeclStmtEPKNS_8DeclStmtES3_")
  //</editor-fold>
  public void addSyntheticDeclStmt(/*const*/ DeclStmt /*P*/ Synthetic, 
                      /*const*/ DeclStmt /*P*/ Source) {
    assert (Synthetic.isSingleDecl()) : "Can handle single declarations only";
    assert (Synthetic != Source) : "Don't include original DeclStmts in map";
    assert (!(SyntheticDeclStmts.count(Synthetic) != 0)) : "Already in map";
    SyntheticDeclStmts.$set(Synthetic, Source);
  }

  
  /*typedef llvm::DenseMap<const DeclStmt *, const DeclStmt *>::const_iterator synthetic_stmt_iterator*/
//  public final class synthetic_stmt_iterator extends DenseMapIterator</*const*/ DeclStmt /*P*/ , /*const*/ DeclStmt /*P*/ >{ };
  
  /// Iterates over synthetic DeclStmts in the CFG.
  ///
  /// Each element is a (synthetic statement, source statement) pair.
  ///
  /// \sa addSyntheticDeclStmt
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::synthetic_stmt_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 902,
   FQN="clang::CFG::synthetic_stmt_begin", NM="_ZNK5clang3CFG20synthetic_stmt_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG20synthetic_stmt_beginEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ DeclStmt /*P*/ , /*const*/ DeclStmt /*P*/ > synthetic_stmt_begin() /*const*/ {
    return SyntheticDeclStmts.begin$Const();
  }

  
  /// \sa synthetic_stmt_begin
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::synthetic_stmt_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 907,
   FQN="clang::CFG::synthetic_stmt_end", NM="_ZNK5clang3CFG18synthetic_stmt_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG18synthetic_stmt_endEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ DeclStmt /*P*/ , /*const*/ DeclStmt /*P*/ > synthetic_stmt_end() /*const*/ {
    return SyntheticDeclStmts.end$Const();
  }

  
  //===--------------------------------------------------------------------===//
  // Member templates useful for various batch operations over CFGs.
  //===--------------------------------------------------------------------===//
  /*template <typename CALLBACK> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::VisitBlockStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 916,
   FQN="clang::CFG::VisitBlockStmts", NM="Tpl__ZNK5clang3CFG15VisitBlockStmtsERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=Tpl__ZNK5clang3CFG15VisitBlockStmtsERT_")
  //</editor-fold>
  public </*typename*/ CALLBACK extends Stmt2Void> void VisitBlockStmts(final CALLBACK /*&*/ O) /*const*/ {
    for (type$ptr<CFGBlock> I = $tryClone(begin$Const()), /*P*/ E = $tryClone(end$Const()); $noteq_ptr(I, E); I.$preInc())  {
      for (std.reverse_iterator</*const*/ CFGElement> BI = new std.reverse_iterator</*const*/ CFGElement>(JD$Reverse_iterator$_Iter$C.INSTANCE, (I.$star()).begin()), BE = new std.reverse_iterator</*const*/ CFGElement>(JD$Reverse_iterator$_Iter$C.INSTANCE, (I.$star()).end());
           $noteq_reverse_iterator$C(BI, BE); BI.$preInc()) {
        {
          Optional<CFGStmt> stmt = BI.$arrow().getAs(CFGStmt.class);
          if (stmt.$bool()) {
            O.$call(((/*const_cast*/Stmt /*P*/ )(stmt.$arrow().getStmt())));
          }
        }
      }
    }
  }

  
  //===--------------------------------------------------------------------===//
  // CFG Introspection.
  //===--------------------------------------------------------------------===//
  
  /// getNumBlockIDs - Returns the total number of BlockIDs allocated (which
  /// start at 0).
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getNumBlockIDs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 931,
   FQN="clang::CFG::getNumBlockIDs", NM="_ZNK5clang3CFG14getNumBlockIDsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG14getNumBlockIDsEv")
  //</editor-fold>
  public /*uint*/int getNumBlockIDs() /*const*/ {
    return NumBlockIDs;
  }

  
  /// size - Return the total number of CFGBlocks within the CFG
  /// This is simply a renaming of the getNumBlockIDs(). This is necessary 
  /// because the dominator implementation needs such an interface.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 936,
   FQN="clang::CFG::size", NM="_ZNK5clang3CFG4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang3CFG4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumBlockIDs;
  }

  
  //===--------------------------------------------------------------------===//
  // CFG Debugging: Pretty-Printing and Visualization.
  //===--------------------------------------------------------------------===//
  
  //===--------------------------------------------------------------------===//
  // CFG Debugging: Pretty-Printing and Visualization.
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::viewCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4653,
   FQN="clang::CFG::viewCFG", NM="_ZNK5clang3CFG7viewCFGERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang3CFG7viewCFGERKNS_11LangOptionsE")
  //</editor-fold>
  public void viewCFG(final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    StmtPrinterHelper H = null;
    try {
      H/*J*/= new StmtPrinterHelper(this, LO);
      GraphHelper = $AddrOf(H);
      ViewGraph(this, new Twine(/*KEEP_STR*/"CFG"));
      GraphHelper = null;
    } finally {
      if (H != null) { H.$destroy(); }
    }
  }


  
  /// print - A simple pretty printer of a CFG that outputs to an ostream.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4532,
   FQN="clang::CFG::print", NM="_ZNK5clang3CFG5printERN4llvm11raw_ostreamERKNS_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang3CFG5printERN4llvm11raw_ostreamERKNS_11LangOptionsEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, final /*const*/ LangOptions /*&*/ LO, boolean ShowColors) /*const*/ {
    StmtPrinterHelper Helper = null;
    try {
      Helper/*J*/= new StmtPrinterHelper(this, LO);
      
      // Print the entry block.
      print_block(OS, this, getEntry$Const(), Helper, true, ShowColors);
      
      // Iterate through the CFGBlocks and print them one by one.
      for (type$ptr<CFGBlock> I = $tryClone(Blocks.begin$Const()), /*P*/ E = $tryClone(Blocks.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
        // Skip the entry block, because we already printed it.
        if ($AddrOf(($Deref(I.$star()))) == $AddrOf(getEntry$Const()) || $AddrOf(($Deref(I.$star()))) == $AddrOf(getExit$Const())) {
          continue;
        }
        
        print_block(OS, this, $Deref(I.$star()), Helper, true, ShowColors);
      }
      
      // Print the exit block.
      print_block(OS, this, getExit$Const(), Helper, true, ShowColors);
      OS.$out_char($$LF);
      OS.flush();
    } finally {
      if (Helper != null) { Helper.$destroy(); }
    }
  }


  
  /// dump - A simple pretty printer of a CFG that outputs to stderr.
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4527,
   FQN="clang::CFG::dump", NM="_ZNK5clang3CFG4dumpERKNS_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang3CFG4dumpERKNS_11LangOptionsEb")
  //</editor-fold>
  public void dump(final /*const*/ LangOptions /*&*/ LO, boolean ShowColors) /*const*/ {
    print(llvm.errs(), LO, ShowColors);
  }


  
  //===--------------------------------------------------------------------===//
  // Internal: constructors and data.
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::CFG">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 950,
   FQN="clang::CFG::CFG", NM="_ZN5clang3CFGC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFGC1Ev")
  //</editor-fold>
  public CFG() {
    // : Entry(null), Exit(null), IndirectGotoBlock(null), NumBlockIDs(0), BlkBVC(), Blocks(BlkBVC, 10), TryDispatchBlocks(), SyntheticDeclStmts() 
    //START JInit
    this.Entry = null;
    this.Exit = null;
    this.IndirectGotoBlock = null;
    this.NumBlockIDs = 0;
    this.BlkBVC = new BumpVectorContext();
    // JAVA: MEMORY
    this.Blocks = new BumpVector<CFGBlock /*P*/ >(
              new BumpVector.TypeAllocator<CFGBlock>(
                (int size)->{return new CFGBlock[size];}), 
              BlkBVC, 10);
    this.TryDispatchBlocks = new std.vector</*const*/ CFGBlock /*P*/ >((/*const*/ CFGBlock /*P*/ )null);
    this.SyntheticDeclStmts = new DenseMap</*const*/ DeclStmt /*P*/ , /*const*/ DeclStmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ DeclStmt /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 954,
   FQN="clang::CFG::getAllocator", NM="_ZN5clang3CFG12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ getAllocator() {
    return BlkBVC.getAllocator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::getBumpVectorContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 958,
   FQN="clang::CFG::getBumpVectorContext", NM="_ZN5clang3CFG20getBumpVectorContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFG20getBumpVectorContextEv")
  //</editor-fold>
  public BumpVectorContext /*&*/ getBumpVectorContext() {
    return BlkBVC;
  }

/*private:*/
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<CFGBlock> /*P*/ Entry;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<CFGBlock> /*P*/ Exit;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<CFGBlock> /*P*/ IndirectGotoBlock; // Special block to contain collective dispatch
  // for indirect gotos
  private /*uint*/int NumBlockIDs;
  
  private BumpVectorContext BlkBVC;
  
  private BumpVector<CFGBlock /*P*/ > Blocks;
  
  /// C++ 'try' statements are modeled with an indirect dispatch block.
  /// This is the collection of such blocks present in the CFG.
  private std.vector</*const*/ CFGBlock /*P*/ > TryDispatchBlocks;
  
  /// Collects DeclStmts synthesized for this CFG and maps each one back to its
  /// source DeclStmt.
  private DenseMap</*const*/ DeclStmt /*P*/ , /*const*/ DeclStmt /*P*/ > SyntheticDeclStmts;
  //<editor-fold defaultstate="collapsed" desc="clang::CFG::~CFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 721,
   FQN="clang::CFG::~CFG", NM="_ZN5clang3CFGD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang3CFGD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SyntheticDeclStmts.$destroy();
    TryDispatchBlocks.$destroy();
    Blocks.$destroy();
    BlkBVC.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<CFGBlock /*P*/> iterator() { return new JavaIterator<>(begin(), end()); }

  private type$ptr<CFGBlock /*P*/> find$EntryPtr(CFGBlock /*P*/ B) {
    for (int idx = this.Blocks.size()-1; idx >= 0 ; idx--) {
      if (this.Blocks.$at(idx) == B) {
        type$ptr<CFGBlock> out = $toConst(this.Blocks.ptr$at(idx));
        assert out.$star() == B;
        return out;
      }
    }
    throw new IllegalStateException("must find " + NativeTrace.getIdentityStr(B) + " in Blocks " + this.Blocks.size());
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Entry=" + Entry // NOI18N
              + ", Exit=" + Exit // NOI18N
              + ", IndirectGotoBlock=" + IndirectGotoBlock // NOI18N
              + ", NumBlockIDs=" + NumBlockIDs // NOI18N
              + ", BlkBVC=" + "[BumpVectorContext]" // NOI18N
              + ", Blocks=" + Blocks // NOI18N
              + ", TryDispatchBlocks=" + TryDispatchBlocks // NOI18N
              + ", SyntheticDeclStmts=" + SyntheticDeclStmts; // NOI18N
  }
}
