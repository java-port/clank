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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.OMPExecutableDirective.getClausesOfKind;


//===----------------------------------------------------------------------===//
// AST classes for directives.
//===----------------------------------------------------------------------===//

/// \brief This is a basic class for representing single OpenMP executable
/// directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 33,
 FQN="clang::OMPExecutableDirective", NM="_ZN5clang22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirectiveE")
//</editor-fold>
public class OMPExecutableDirective extends /*public*/ Stmt {
  /*friend  class ASTStmtReader*/
  /// \brief Kind of the directive.
  private OpenMPDirectiveKind Kind;
  /// \brief Starting location of the directive (directive keyword).
  private SourceLocation StartLoc;
  /// \brief Ending location of the directive.
  private SourceLocation EndLoc;
  /// \brief Numbers of clauses.
  private /*const*//*uint*/int NumClauses;
  /// \brief Number of child expressions/stmts.
  private /*const*//*uint*/int NumChildren;
  /// \brief Offset from this to the start of clauses.
  /// There are NumClauses pointers to clauses, they are followed by
  /// NumChildren pointers to child stmts/exprs (if the directive type
  /// requires an associated stmt, then it has to be the first of them).
  private /*const*//*uint*/int ClausesOffset;
  
  /// \brief Get the clauses storage.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 52,
   FQN="clang::OMPExecutableDirective::getClauses", NM="_ZN5clang22OMPExecutableDirective10getClausesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective10getClausesEv")
  //</editor-fold>
  private MutableArrayRef<OMPClause /*P*/ > getClauses() {
    type$ptr<OMPClause /*P*/ /*P*/> ClauseStorage = $tryClone(((type$ptr<OMPClause /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, reinterpret_cast(char$ptr/*char P*/ .class, this).$add(ClausesOffset))));
    return new MutableArrayRef<OMPClause /*P*/ >(ClauseStorage, NumClauses, true);
  }

/*protected:*/
  /// \brief Build instance of directive of class \a K.
  ///
  /// \param SC Statement class.
  /// \param K Kind of OpenMP directive.
  /// \param StartLoc Starting location of the directive (directive keyword).
  /// \param EndLoc Ending location of the directive.
  ///
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::OMPExecutableDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 67,
   FQN="clang::OMPExecutableDirective::OMPExecutableDirective", NM="Tpl__ZN5clang22OMPExecutableDirectiveC1EPKT_NS_4Stmt9StmtClassENS_19OpenMPDirectiveKindENS_14SourceLocationES7_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=Tpl__ZN5clang22OMPExecutableDirectiveC1EPKT_NS_4Stmt9StmtClassENS_19OpenMPDirectiveKindENS_14SourceLocationES7_jj")
  //</editor-fold>
  protected </*typename*/ T> OMPExecutableDirective(/*const*/ T /*P*/ $Prm0, StmtClass SC, OpenMPDirectiveKind K, 
      SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int NumClauses, /*uint*/int NumChildren) {
    $OMPExecutableDirective($Prm0, SC, K, StartLoc, EndLoc, NumClauses, NumChildren);
  }
  protected </*typename*/ T> void $OMPExecutableDirective(/*const*/ T /*P*/ $Prm0, StmtClass SC, OpenMPDirectiveKind K, 
      SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int NumClauses, /*uint*/int NumChildren) {
    // : Stmt(SC), Kind(K), StartLoc(std::move(StartLoc)), EndLoc(std::move(EndLoc)), NumClauses(NumClauses), NumChildren(NumChildren), ClausesOffset(llvm::alignTo(sizeof(T), llvm::alignOf<OMPClause * >())) 
    //START JInit
    $Stmt(SC); ///*ParenListExpr*/super(SC);
    this.Kind = K;
    this.StartLoc = new SourceLocation(JD$Move.INSTANCE, std.move(StartLoc));
    this.EndLoc = new SourceLocation(JD$Move.INSTANCE, std.move(EndLoc));
    this.NumClauses = NumClauses;
    this.NumChildren = NumChildren;
    this.ClausesOffset = $ulong2uint(llvm.alignTo($uint2ulong(1/*$sizeof_T()*/), $uint2ulong(alignOf(OMPClause.class))));
    //END JInit
  }

  
  /// \brief Sets the list of variables for this clause.
  ///
  /// \param Clauses The list of clauses for the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::setClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 20,
   FQN="clang::OMPExecutableDirective::setClauses", NM="_ZN5clang22OMPExecutableDirective10setClausesEN4llvm8ArrayRefIPNS_9OMPClauseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective10setClausesEN4llvm8ArrayRefIPNS_9OMPClauseEEE")
  //</editor-fold>
  /*friend*/public void setClauses(ArrayRef<OMPClause /*P*/ > Clauses) {
    assert (Clauses.size() == getNumClauses()) : "Number of clauses is not the same as the preallocated buffer";
    std.copy(Clauses.begin(), Clauses.end(), getClauses().begin());
  }

  
  /// \brief Set the associated statement for the directive.
  ///
  /// /param S Associated statement.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::setAssociatedStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 85,
   FQN="clang::OMPExecutableDirective::setAssociatedStmt", NM="_ZN5clang22OMPExecutableDirective17setAssociatedStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective17setAssociatedStmtEPNS_4StmtE")
  //</editor-fold>
  /*friend*/public void setAssociatedStmt(Stmt /*P*/ S) {
    assert (hasAssociatedStmt()) : "no associated statement.";
    child_begin().star$ref().$set(S);
  }

/*public:*/
  /// \brief Iterates over a filtered subrange of clauses applied to a
  /// directive.
  ///
  /// This iterator visits only clauses of type SpecificClause.
  /*template <typename SpecificClause> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::specific_clause_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 95,
   FQN="clang::OMPExecutableDirective::specific_clause_iterator", NM="_ZN5clang22OMPExecutableDirective24specific_clause_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective24specific_clause_iteratorE")
  //</editor-fold>
  public static class specific_clause_iterator</*typename*/ SpecificClause extends OMPClause>  extends /*public*/ iterator_adaptor_base<specific_clause_iterator<SpecificClause>, type$ptr<OMPClause>, std.forward_iterator_tag, /*const*/ SpecificClause, SpecificClause> {
    
    private type$ptr<OMPClause> End;
    
    //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::specific_clause_iterator::SkipToNextClause">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 104,
     FQN="clang::OMPExecutableDirective::specific_clause_iterator::SkipToNextClause", NM="_ZN5clang22OMPExecutableDirective24specific_clause_iterator16SkipToNextClauseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective24specific_clause_iterator16SkipToNextClauseEv")
    //</editor-fold>
    private void SkipToNextClause() {
      while (Native.$bool(Native.$noteq_iter(this.I, (type$iterator<?, OMPClause>)End)) && Native.$not(isa(clazz, Native.$star(this.I)))) {
        this.I.$preInc();
      }
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::specific_clause_iterator::specific_clause_iterator<SpecificClause>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 110,
     FQN="clang::OMPExecutableDirective::specific_clause_iterator::specific_clause_iterator<SpecificClause>", NM="_ZN5clang22OMPExecutableDirective24specific_clause_iteratorC1EN4llvm8ArrayRefIPNS_9OMPClauseEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective24specific_clause_iteratorC1EN4llvm8ArrayRefIPNS_9OMPClauseEEE")
    //</editor-fold>
    public /*explicit*/ specific_clause_iterator(Class<SpecificClause> clazz, ArrayRef<OMPClause /*P*/ > Clauses) {
      // : specific_clause_iterator<SpecificClause>::iterator_adaptor_base(Clauses.begin()), End(Clauses.end()) 
      //START JInit
      /*ParenListExpr*/super(Clauses.begin());
      this.clazz = clazz;
      this.End = $tryClone(Clauses.end());
      //END JInit
      SkipToNextClause();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::specific_clause_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 116,
     FQN="clang::OMPExecutableDirective::specific_clause_iterator::operator*", NM="_ZNK5clang22OMPExecutableDirective24specific_clause_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective24specific_clause_iteratordeEv")
    //</editor-fold>
    public /*const*/ SpecificClause /*P*/ $star() /*const*/ {
      return cast(clazz, Native.$star(this.I));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::specific_clause_iterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 119,
     FQN="clang::OMPExecutableDirective::specific_clause_iterator::operator->", NM="_ZNK5clang22OMPExecutableDirective24specific_clause_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective24specific_clause_iteratorptEv")
    //</editor-fold>
    public /*const*/ SpecificClause /*P*/ $arrow() /*const*/ {
      return this.$star();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::specific_clause_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 121,
     FQN="clang::OMPExecutableDirective::specific_clause_iterator::operator++", NM="_ZN5clang22OMPExecutableDirective24specific_clause_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective24specific_clause_iteratorppEv")
    //</editor-fold>
    public specific_clause_iterator<SpecificClause> /*&*/ $preInc() {
      this.I.$preInc();
      SkipToNextClause();
      return this;
    }

    private final Class<SpecificClause> clazz;
    
    public specific_clause_iterator(specific_clause_iterator $Prm0) { super(JD$BaseOf.INSTANCE, $Prm0); this.clazz = $Prm0.clazz; this.End = $tryClone($Prm0.End); }
    
    @Override public specific_clause_iterator clone() { return new specific_clause_iterator(this); }
    
    @Override public String toString() {
      return "" + "End=" + End // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /*template <typename SpecificClause> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getClausesOfKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 129,
   FQN="clang::OMPExecutableDirective::getClausesOfKind", NM="Tpl__ZN5clang22OMPExecutableDirective16getClausesOfKindEN4llvm8ArrayRefIPNS_9OMPClauseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=Tpl__ZN5clang22OMPExecutableDirective16getClausesOfKindEN4llvm8ArrayRefIPNS_9OMPClauseEEE")
  //</editor-fold>
  public static </*typename*/ SpecificClause extends OMPClause> iterator_range</*const*/ SpecificClause /*P*/ > getClausesOfKind(Class<SpecificClause> clazz, ArrayRef<OMPClause /*P*/ > Clauses) {
    return /*JAVA:InitListExpr*/new iterator_range</*const*/ SpecificClause /*P*/ >(
      new specific_clause_iterator<SpecificClause>(clazz, Clauses), 
      new specific_clause_iterator<SpecificClause>(clazz, llvm.makeArrayRef(Clauses.end(), 0))
    );
  }

  
  /*template <typename SpecificClause> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getClausesOfKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 137,
   FQN="clang::OMPExecutableDirective::getClausesOfKind", NM="Tpl__ZNK5clang22OMPExecutableDirective16getClausesOfKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=Tpl__ZNK5clang22OMPExecutableDirective16getClausesOfKindEv")
  //</editor-fold>
  public </*typename*/ SpecificClause extends OMPClause> iterator_range</*const*/ SpecificClause /*P*/ > getClausesOfKind(Class<SpecificClause> clazz) /*const*/ {
    return getClausesOfKind(clazz, clauses$Const());
  }

  
  /// Gets a single clause of the specified kind associated with the
  /// current directive iff there is only one clause of this kind (and assertion
  /// is fired if there is more than one clause is associated with the
  /// directive). Returns nullptr if no clause of this kind is associated with
  /// the directive.
  /*template <typename SpecificClause> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getSingleClause">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 148,
   FQN="clang::OMPExecutableDirective::getSingleClause", NM="Tpl__ZNK5clang22OMPExecutableDirective15getSingleClauseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=Tpl__ZNK5clang22OMPExecutableDirective15getSingleClauseEv")
  //</editor-fold>
  public </*typename*/ SpecificClause extends OMPClause> /*const*/ SpecificClause /*P*/ getSingleClause(Class<SpecificClause> clazz) /*const*/ {
    iterator_range</*const*/ SpecificClause /*P*/ >  Clauses = getClausesOfKind(clazz);
    if (Native.$noteq_iter(Clauses.begin(), Clauses.end())) {
      assert Native.$bool(Native.$eq(std.next(Clauses.begin()), Clauses.end())) : "There are at least 2 clauses of the specified kind";
      return Native.$star(Clauses.begin());
    }
    return null;
  }

  
  /// Returns true if the current directive has one or more clauses of a
  /// specific kind.
  /*template <typename SpecificClause> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::hasClausesOfKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 162,
   FQN="clang::OMPExecutableDirective::hasClausesOfKind", NM="Tpl__ZNK5clang22OMPExecutableDirective16hasClausesOfKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=Tpl__ZNK5clang22OMPExecutableDirective16hasClausesOfKindEv")
  //</editor-fold>
  public </*typename*/ SpecificClause extends OMPClause> boolean hasClausesOfKind(Class<SpecificClause> clazz) /*const*/ {
    iterator_range<SpecificClause> Clauses = getClausesOfKind(clazz);
    return Native.$noteq_iter(Clauses.begin(), Clauses.end());
  }

  
  /// \brief Returns starting location of directive kind.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 168,
   FQN="clang::OMPExecutableDirective::getLocStart", NM="_ZNK5clang22OMPExecutableDirective11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*/ {
    return new SourceLocation(StartLoc);
  }

  /// \brief Returns ending location of directive.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 170,
   FQN="clang::OMPExecutableDirective::getLocEnd", NM="_ZNK5clang22OMPExecutableDirective9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*/ {
    return new SourceLocation(EndLoc);
  }

  
  /// \brief Set starting location of directive kind.
  ///
  /// \param Loc New starting location of directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::setLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 176,
   FQN="clang::OMPExecutableDirective::setLocStart", NM="_ZN5clang22OMPExecutableDirective11setLocStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective11setLocStartENS_14SourceLocationE")
  //</editor-fold>
  public void setLocStart(SourceLocation Loc) {
    StartLoc.$assign(Loc);
  }

  /// \brief Set ending location of directive.
  ///
  /// \param Loc New ending location of directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::setLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 181,
   FQN="clang::OMPExecutableDirective::setLocEnd", NM="_ZN5clang22OMPExecutableDirective9setLocEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective9setLocEndENS_14SourceLocationE")
  //</editor-fold>
  public void setLocEnd(SourceLocation Loc) {
    EndLoc.$assign(Loc);
  }

  
  /// \brief Get number of clauses.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getNumClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 184,
   FQN="clang::OMPExecutableDirective::getNumClauses", NM="_ZNK5clang22OMPExecutableDirective13getNumClausesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective13getNumClausesEv")
  //</editor-fold>
  public /*uint*/int getNumClauses() /*const*/ {
    return NumClauses;
  }

  
  /// \brief Returns specified clause.
  ///
  /// \param i Number of clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 190,
   FQN="clang::OMPExecutableDirective::getClause", NM="_ZNK5clang22OMPExecutableDirective9getClauseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective9getClauseEj")
  //</editor-fold>
  public OMPClause /*P*/ getClause(/*uint*/int i) /*const*/ {
    return clauses$Const().$at(i);
  }

  
  /// \brief Returns true if directive has associated statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::hasAssociatedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 193,
   FQN="clang::OMPExecutableDirective::hasAssociatedStmt", NM="_ZNK5clang22OMPExecutableDirective17hasAssociatedStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective17hasAssociatedStmtEv")
  //</editor-fold>
  public boolean hasAssociatedStmt() /*const*/ {
    return $greater_uint(NumChildren, 0);
  }

  
  /// \brief Returns statement associated with the directive.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getAssociatedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 196,
   FQN="clang::OMPExecutableDirective::getAssociatedStmt", NM="_ZNK5clang22OMPExecutableDirective17getAssociatedStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective17getAssociatedStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getAssociatedStmt() /*const*/ {
    assert (hasAssociatedStmt()) : "no associated statement.";
    return ((/*const_cast*/Stmt /*P*/ )(child_begin$Const().$star()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::getDirectiveKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 201,
   FQN="clang::OMPExecutableDirective::getDirectiveKind", NM="_ZNK5clang22OMPExecutableDirective16getDirectiveKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective16getDirectiveKindEv")
  //</editor-fold>
  public OpenMPDirectiveKind getDirectiveKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 203,
   FQN="clang::OMPExecutableDirective::classof", NM="_ZN5clang22OMPExecutableDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ S) {
    return S.getStmtClass().getValue() >= StmtClass.firstOMPExecutableDirectiveConstant.getValue()
       && S.getStmtClass().getValue() <= StmtClass.lastOMPExecutableDirectiveConstant.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 208,
   FQN="clang::OMPExecutableDirective::children", NM="_ZN5clang22OMPExecutableDirective8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if (!hasAssociatedStmt()) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    type$ptr<Stmt /*P*/ /*P*/> ChildStorage = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getClauses().end())));
    return new iterator_range<Stmt/*P*/>(new StmtIterator(ChildStorage), new StmtIterator(ChildStorage.$add(NumChildren)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::clauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 215,
   FQN="clang::OMPExecutableDirective::clauses", NM="_ZN5clang22OMPExecutableDirective7clausesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPExecutableDirective7clausesEv")
  //</editor-fold>
  public ArrayRef<OMPClause /*P*/ > clauses() {
    return new ArrayRef<OMPClause /*P*/ >(JD$Move.INSTANCE, getClauses());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPExecutableDirective::clauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 217,
   FQN="clang::OMPExecutableDirective::clauses", NM="_ZNK5clang22OMPExecutableDirective7clausesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang22OMPExecutableDirective7clausesEv")
  //</editor-fold>
  public ArrayRef<OMPClause /*P*/ > clauses$Const() /*const*/ {
    return new ArrayRef<OMPClause /*P*/ >(JD$Move.INSTANCE, ((/*const_cast*/OMPExecutableDirective /*P*/ )(this)).getClauses());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected OMPExecutableDirective() {}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", StartLoc=" + StartLoc // NOI18N
              + ", EndLoc=" + EndLoc // NOI18N
              + ", NumClauses=" + NumClauses // NOI18N
              + ", NumChildren=" + NumChildren // NOI18N
              + ", ClausesOffset=" + ClausesOffset // NOI18N
              + super.toString(); // NOI18N
  }
}
