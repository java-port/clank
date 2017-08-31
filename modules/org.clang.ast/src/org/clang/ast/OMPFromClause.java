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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.support.TrailingObjects.*;


/// \brief This represents clause 'from' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp target update from(a,b)
/// \endcode
/// In this example directive '#pragma omp target update' has clause 'from'
/// with the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4126,
 FQN="clang::OMPFromClause", NM="_ZN5clang13OMPFromClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClauseE")
//</editor-fold>
public final class OMPFromClause extends /*public*/ OMPMappableExprListClause<OMPFromClause> implements /*private*/ TrailingObjects$T$T$UInt$T<OMPFromClause, Expr /*P*/ , ValueDecl /*P*/ , /*uint Integer,*/ OMPClauseMappableExprCommon.MappableComponent> {
  /*friend  TrailingObjects<OMPFromClause, Expr *, ValueDecl *, unsigned int, MappableComponent>*/
  /*friend  OMPVarListClause<OMPFromClause>*/
  /*friend  OMPMappableExprListClause<OMPFromClause>*/
  /*friend  class OMPClauseReader*/
  
  /// Define the sizes of each trailing object array except the last one. This
  /// is required for TrailingObjects to work properly.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4138,
   FQN="clang::OMPFromClause::numTrailingObjects", NM="_ZNK5clang13OMPFromClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang13OMPFromClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_4ExprEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$Expr$P(OverloadToken<Expr /*P*/ > $Prm0) /*const*/ {
    return varlist_size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4141,
   FQN="clang::OMPFromClause::numTrailingObjects", NM="_ZNK5clang13OMPFromClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9ValueDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang13OMPFromClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9ValueDeclEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$ValueDecl$P(OverloadToken<ValueDecl /*P*/ > $Prm0) /*const*/ {
    return getUniqueDeclarationsNum();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4144,
   FQN="clang::OMPFromClause::numTrailingObjects", NM="_ZNK5clang13OMPFromClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang13OMPFromClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIjEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadTokenUInt(OverloadTokenUInt $Prm0) /*const*/ {
    return getUniqueDeclarationsNum() + getTotalComponentListNum();
  }

  
  /// \brief Build clause with number of variables \a NumVars.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param EndLoc Ending location of the clause.
  /// \param NumVars Number of expressions listed in this clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of component lists in this clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::OMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4158,
   FQN="clang::OMPFromClause::OMPFromClause", NM="_ZN5clang13OMPFromClauseC1ENS_14SourceLocationES1_S1_jjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClauseC1ENS_14SourceLocationES1_S1_jjjj")
  //</editor-fold>
  private /*explicit*/ OMPFromClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int NumVars, 
      /*uint*/int NumUniqueDeclarations, 
      /*uint*/int NumComponentLists, /*uint*/int NumComponents) {
    // : OMPMappableExprListClause<OMPFromClause>(OMPC_from, StartLoc, LParenLoc, EndLoc, NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents), TrailingObjects<OMPFromClause, Expr * , ValueDecl * , unsigned int, OMPClauseMappableExprCommon::MappableComponent>() 
    //START JInit
    super(OpenMPClauseKind.OMPC_from, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
        NumVars, NumUniqueDeclarations, 
        NumComponentLists, NumComponents);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param NumVars Number of expressions listed in this clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of component lists in this clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::OMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4174,
   FQN="clang::OMPFromClause::OMPFromClause", NM="_ZN5clang13OMPFromClauseC1Ejjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClauseC1Ejjjj")
  //</editor-fold>
  private /*explicit*/ OMPFromClause(/*uint*/int NumVars, /*uint*/int NumUniqueDeclarations, 
      /*uint*/int NumComponentLists, /*uint*/int NumComponents) {
    // : OMPMappableExprListClause<OMPFromClause>(OMPC_from, SourceLocation(), SourceLocation(), SourceLocation(), NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents), TrailingObjects<OMPFromClause, Expr * , ValueDecl * , unsigned int, OMPClauseMappableExprCommon::MappableComponent>() 
    //START JInit
    super(OpenMPClauseKind.OMPC_from, new SourceLocation(), new SourceLocation(), new SourceLocation(), 
        NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents);
    $TrailingObjects();
    //END JInit
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a Vars.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param EndLoc Ending location of the clause.
  /// \param Vars The original expression used in the clause.
  /// \param Declarations Declarations used in the clause.
  /// \param ComponentLists Component lists used in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 686,
   FQN="clang::OMPFromClause::Create", NM="_ZN5clang13OMPFromClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEENS6_IPNS_9ValueDeclEEENS6_INS5_11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEENS6_IPNS_9ValueDeclEEENS6_INS5_11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEEEE")
  //</editor-fold>
  public static OMPFromClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation LParenLoc, SourceLocation EndLoc, 
        ArrayRef<Expr /*P*/ > Vars, ArrayRef<ValueDecl /*P*/ > Declarations, 
        ArrayRef<SmallVector<MappableComponent>> ComponentLists) {
    /*uint*/int NumVars = Vars.size();
    /*uint*/int NumUniqueDeclarations = OMPClauseMappableExprCommon.getUniqueDeclarationsTotalNumber(new ArrayRef<ValueDecl /*P*/ >(Declarations));
    /*uint*/int NumComponentLists = ComponentLists.size();
    /*uint*/int NumComponents = OMPClauseMappableExprCommon.getComponentsTotalNumber(new ArrayRef<SmallVector<MappableComponent>>(ComponentLists));
    
    // We need to allocate:
    // NumVars x Expr* - we have an original list expression for each clause list
    // entry.
    // NumUniqueDeclarations x ValueDecl* - unique base declarations associated
    // with each component list.
    // (NumUniqueDeclarations + NumComponentLists) x unsigned - we specify the
    // number of lists for each unique declaration and the size of each component
    // list.
    // NumComponents x MappableComponent - the total of all the components in all
    // the lists.
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, ValueDecl.class, int.class, MappableComponent.class, NumVars, NumUniqueDeclarations, NumUniqueDeclarations + NumComponentLists, NumComponents));
    
    OMPFromClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPFromClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), NumVars, NumUniqueDeclarations, 
                NumComponentLists, NumComponents);
     });
    
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars));
    Clause.setClauseInfo(new ArrayRef<ValueDecl /*P*/ >(Declarations), new ArrayRef<SmallVector<MappableComponent>>(ComponentLists));
    return Clause;
  }

  
  /// \brief Creates an empty clause with the place for \a NumVars variables.
  ///
  /// \param C AST context.
  /// \param NumVars Number of expressions listed in the clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of unique base declarations in this
  /// clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 722,
   FQN="clang::OMPFromClause::CreateEmpty", NM="_ZN5clang13OMPFromClause11CreateEmptyERKNS_10ASTContextEjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClause11CreateEmptyERKNS_10ASTContextEjjjj")
  //</editor-fold>
  public static OMPFromClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumVars, 
             /*uint*/int NumUniqueDeclarations, 
             /*uint*/int NumComponentLists, 
             /*uint*/int NumComponents) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, ValueDecl.class, int.class, MappableComponent.class, NumVars, NumUniqueDeclarations, NumUniqueDeclarations + NumComponentLists, NumComponents));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPFromClause(NumVars, NumUniqueDeclarations, 
                NumComponentLists, NumComponents);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4211,
   FQN="clang::OMPFromClause::classof", NM="_ZN5clang13OMPFromClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_from;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFromClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4215,
   FQN="clang::OMPFromClause::children", NM="_ZN5clang13OMPFromClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPFromClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { return numTrailingObjects_OverloadToken$Expr$P((OverloadToken<Expr /*P*/>)null); }
  
  @Override public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { return numTrailingObjects_OverloadToken$ValueDecl$P((OverloadToken<ValueDecl /*P*/>)null); }
  
  @Override public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy3() { return numTrailingObjects_OverloadTokenUInt((OverloadTokenUInt)null); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
