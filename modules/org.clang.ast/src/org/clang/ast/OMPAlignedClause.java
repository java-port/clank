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


/// \brief This represents clause 'aligned' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp simd aligned(a,b : 8)
/// \endcode
/// In this example directive '#pragma omp simd' has clause 'aligned'
/// with variables 'a', 'b' and alignment '8'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2110,
 FQN="clang::OMPAlignedClause", NM="_ZN5clang16OMPAlignedClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClauseE")
//</editor-fold>
public final class OMPAlignedClause extends /*public*/ OMPVarListClause<OMPAlignedClause> implements /*private*/ TrailingObjects<OMPAlignedClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPAlignedClause, Expr *>*/
  /*friend  OMPVarListClause<OMPAlignedClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Location of ':'.
  private SourceLocation ColonLoc;
  
  /// \brief Sets the alignment for clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2120,
   FQN="clang::OMPAlignedClause::setAlignment", NM="_ZN5clang16OMPAlignedClause12setAlignmentEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause12setAlignmentEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setAlignment(Expr /*P*/ A) {
    varlist_end().$set(A);
  }

  
  /// \brief Build 'aligned' clause with given number of variables \a NumVars.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param ColonLoc Location of ':'.
  /// \param EndLoc Ending location of the clause.
  /// \param NumVars Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::OMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2130,
   FQN="clang::OMPAlignedClause::OMPAlignedClause", NM="_ZN5clang16OMPAlignedClauseC1ENS_14SourceLocationES1_S1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClauseC1ENS_14SourceLocationES1_S1_S1_j")
  //</editor-fold>
  private OMPAlignedClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation ColonLoc, SourceLocation EndLoc, 
      /*uint*/int NumVars) {
    // : OMPVarListClause<OMPAlignedClause>(OMPC_aligned, StartLoc, LParenLoc, EndLoc, NumVars), TrailingObjects<OMPAlignedClause, Expr * >(), ColonLoc(ColonLoc) 
    //START JInit
    super(OpenMPClauseKind.OMPC_aligned, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc), NumVars);
    $TrailingObjects();
    this.ColonLoc = new SourceLocation(ColonLoc);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param NumVars Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::OMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2141,
   FQN="clang::OMPAlignedClause::OMPAlignedClause", NM="_ZN5clang16OMPAlignedClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPAlignedClause(/*uint*/int NumVars) {
    // : OMPVarListClause<OMPAlignedClause>(OMPC_aligned, SourceLocation(), SourceLocation(), SourceLocation(), NumVars), TrailingObjects<OMPAlignedClause, Expr * >(), ColonLoc(SourceLocation()) 
    //START JInit
    super(OpenMPClauseKind.OMPC_aligned, new SourceLocation(), 
        new SourceLocation(), new SourceLocation(), 
        NumVars);
    $TrailingObjects();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL and alignment \a A.
  ///
  /// \param C AST Context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param ColonLoc Location of ':'.
  /// \param EndLoc Ending location of the clause.
  /// \param VL List of references to the variables.
  /// \param A Alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 350,
   FQN="clang::OMPAlignedClause::Create", NM="_ZN5clang16OMPAlignedClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_S4_N4llvm8ArrayRefIPNS_4ExprEEES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_S4_N4llvm8ArrayRefIPNS_4ExprEEES8_")
  //</editor-fold>
  public static OMPAlignedClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation LParenLoc, SourceLocation ColonLoc, 
        SourceLocation EndLoc, ArrayRef<Expr /*P*/ > VL, Expr /*P*/ A) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, VL.size() + 1));
    OMPAlignedClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPAlignedClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setAlignment(A);
    return Clause;
  }

  
  /// \brief Creates an empty clause with the place for \a NumVars variables.
  ///
  /// \param C AST context.
  /// \param NumVars Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 362,
   FQN="clang::OMPAlignedClause::CreateEmpty", NM="_ZN5clang16OMPAlignedClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPAlignedClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumVars) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, NumVars + 1));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPAlignedClause(NumVars);
     });
  }

  
  /// \brief Sets the location of ':'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2171,
   FQN="clang::OMPAlignedClause::setColonLoc", NM="_ZN5clang16OMPAlignedClause11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setColonLoc(SourceLocation Loc) {
    ColonLoc.$assign(Loc);
  }

  /// \brief Returns the location of ':'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2173,
   FQN="clang::OMPAlignedClause::getColonLoc", NM="_ZNK5clang16OMPAlignedClause11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPAlignedClause11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  /// \brief Returns alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2176,
   FQN="clang::OMPAlignedClause::getAlignment", NM="_ZN5clang16OMPAlignedClause12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause12getAlignmentEv")
  //</editor-fold>
  public Expr /*P*/ getAlignment() {
    return varlist_end().$star();
  }

  /// \brief Returns alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2178,
   FQN="clang::OMPAlignedClause::getAlignment", NM="_ZNK5clang16OMPAlignedClause12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPAlignedClause12getAlignmentEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getAlignment$Const() /*const*/ {
    return varlist_end$Const().$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2180,
   FQN="clang::OMPAlignedClause::children", NM="_ZN5clang16OMPAlignedClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAlignedClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2185,
   FQN="clang::OMPAlignedClause::classof", NM="_ZN5clang16OMPAlignedClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPAlignedClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_aligned;
  }

  
  @Override public String toString() {
    return "" + "ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
