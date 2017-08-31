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
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.DeclContext.*;


/// \brief This represents '#pragma omp declare reduction ...' directive.
/// For example, in the following, declared reduction 'foo' for types 'int' and
/// 'float':
///
/// \code
/// #pragma omp declare reduction (foo : int,float : omp_out += omp_in) \
///                     initializer (omp_priv = 0)
/// \endcode
///
/// Here 'omp_out += omp_in' is a combiner and 'omp_priv = 0' is an initializer.
//<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 102,
 FQN="clang::OMPDeclareReductionDecl", NM="_ZN5clang23OMPDeclareReductionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDeclE")
//</editor-fold>
public final class OMPDeclareReductionDecl extends /*public*/ ValueDecl implements /*public*/ DeclContext, Destructors.ClassWithDestructor {
/*private:*/
  /*friend  class ASTDeclReader*/
  /// \brief Combiner for declare reduction construct.
  private Expr /*P*/ Combiner;
  /// \brief Initializer for declare reduction construct.
  private Expr /*P*/ Initializer;
  /// \brief Reference to the previous declare reduction construct in the same
  /// scope with the same name. Required for proper templates instantiation if
  /// the declare reduction construct is declared inside compound statement.
  /*friend*/public LazyDeclPtr PrevDeclInScope;
  
  
  //===----------------------------------------------------------------------===//
  // OMPDeclareReductionDecl Implementation.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 60,
   FQN="clang::OMPDeclareReductionDecl::anchor", NM="_ZN5clang23OMPDeclareReductionDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::OMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 116,
   FQN="clang::OMPDeclareReductionDecl::OMPDeclareReductionDecl", NM="_ZN5clang23OMPDeclareReductionDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPS0_")
  //</editor-fold>
  private OMPDeclareReductionDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, 
      DeclarationName Name, QualType Ty, 
      OMPDeclareReductionDecl /*P*/ PrevDeclInScope) {
    // : ValueDecl(DK, DC, L, Name, Ty), DeclContext(DK), Combiner(null), Initializer(null), PrevDeclInScope(PrevDeclInScope) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(Name), new QualType(Ty));
    this.DeclContext$Flds = $DeclContext(DK);
    this.Combiner = null;
    this.Initializer = null;
    this.PrevDeclInScope = new LazyDeclPtr(PrevDeclInScope);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::setPrevDeclInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 122,
   FQN="clang::OMPDeclareReductionDecl::setPrevDeclInScope", NM="_ZN5clang23OMPDeclareReductionDecl18setPrevDeclInScopeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl18setPrevDeclInScopeEPS0_")
  //</editor-fold>
  private void setPrevDeclInScope(OMPDeclareReductionDecl /*P*/ Prev) {
    PrevDeclInScope.$assign(Prev);
  }

/*public:*/
  /// \brief Create declare reduction node.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 62,
   FQN="clang::OMPDeclareReductionDecl::Create", NM="_ZN5clang23OMPDeclareReductionDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPS0_")
  //</editor-fold>
  public static OMPDeclareReductionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L, DeclarationName Name, 
        QualType T, OMPDeclareReductionDecl /*P*/ PrevDeclInScope) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new OMPDeclareReductionDecl(Kind.OMPDeclareReduction, DC, new SourceLocation(L), new DeclarationName(Name), 
                new QualType(T), PrevDeclInScope);
     });
  }

  /// \brief Create deserialized declare reduction node.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 69,
   FQN="clang::OMPDeclareReductionDecl::CreateDeserialized", NM="_ZN5clang23OMPDeclareReductionDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static OMPDeclareReductionDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new OMPDeclareReductionDecl(Kind.OMPDeclareReduction, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), new DeclarationName(), 
                new QualType(), /*PrevDeclInScope=*/ (OMPDeclareReductionDecl /*P*/ )null);
     });
  }

  
  /// \brief Get combiner expression of the declare reduction construct.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::getCombiner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 136,
   FQN="clang::OMPDeclareReductionDecl::getCombiner", NM="_ZN5clang23OMPDeclareReductionDecl11getCombinerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl11getCombinerEv")
  //</editor-fold>
  public Expr /*P*/ getCombiner() {
    return Combiner;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::getCombiner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 137,
   FQN="clang::OMPDeclareReductionDecl::getCombiner", NM="_ZNK5clang23OMPDeclareReductionDecl11getCombinerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang23OMPDeclareReductionDecl11getCombinerEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCombiner$Const() /*const*/ {
    return Combiner;
  }

  /// \brief Set combiner expression for the declare reduction construct.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::setCombiner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 139,
   FQN="clang::OMPDeclareReductionDecl::setCombiner", NM="_ZN5clang23OMPDeclareReductionDecl11setCombinerEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl11setCombinerEPNS_4ExprE")
  //</editor-fold>
  public void setCombiner(Expr /*P*/ E) {
    Combiner = E;
  }

  
  /// \brief Get initializer expression (if specified) of the declare reduction
  /// construct.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 143,
   FQN="clang::OMPDeclareReductionDecl::getInitializer", NM="_ZN5clang23OMPDeclareReductionDecl14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl14getInitializerEv")
  //</editor-fold>
  public Expr /*P*/ getInitializer() {
    return Initializer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 144,
   FQN="clang::OMPDeclareReductionDecl::getInitializer", NM="_ZNK5clang23OMPDeclareReductionDecl14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang23OMPDeclareReductionDecl14getInitializerEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInitializer$Const() /*const*/ {
    return Initializer;
  }

  /// \brief Set initializer expression for the declare reduction construct.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::setInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 146,
   FQN="clang::OMPDeclareReductionDecl::setInitializer", NM="_ZN5clang23OMPDeclareReductionDecl14setInitializerEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl14setInitializerEPNS_4ExprE")
  //</editor-fold>
  public void setInitializer(Expr /*P*/ E) {
    Initializer = E;
  }

  
  /// \brief Get reference to previous declare reduction construct in the same
  /// scope with the same name.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::getPrevDeclInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 76,
   FQN="clang::OMPDeclareReductionDecl::getPrevDeclInScope", NM="_ZN5clang23OMPDeclareReductionDecl18getPrevDeclInScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl18getPrevDeclInScopeEv")
  //</editor-fold>
  public OMPDeclareReductionDecl /*P*/ getPrevDeclInScope() {
    return cast_or_null_OMPDeclareReductionDecl(PrevDeclInScope.get(getASTContext().getExternalSource()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::getPrevDeclInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 80,
   FQN="clang::OMPDeclareReductionDecl::getPrevDeclInScope", NM="_ZNK5clang23OMPDeclareReductionDecl18getPrevDeclInScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang23OMPDeclareReductionDecl18getPrevDeclInScopeEv")
  //</editor-fold>
  public /*const*/ OMPDeclareReductionDecl /*P*/ getPrevDeclInScope$Const() /*const*/ {
    return cast_or_null_OMPDeclareReductionDecl(PrevDeclInScope.get(getASTContext().getExternalSource()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 153,
   FQN="clang::OMPDeclareReductionDecl::classof", NM="_ZN5clang23OMPDeclareReductionDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 154,
   FQN="clang::OMPDeclareReductionDecl::classofKind", NM="_ZN5clang23OMPDeclareReductionDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.OMPDeclareReduction;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 155,
   FQN="clang::OMPDeclareReductionDecl::castToDeclContext", NM="_ZN5clang23OMPDeclareReductionDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ OMPDeclareReductionDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/OMPDeclareReductionDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 158,
   FQN="clang::OMPDeclareReductionDecl::castFromDeclContext", NM="_ZN5clang23OMPDeclareReductionDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static OMPDeclareReductionDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/OMPDeclareReductionDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareReductionDecl::~OMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 102,
   FQN="clang::OMPDeclareReductionDecl::~OMPDeclareReductionDecl", NM="_ZN5clang23OMPDeclareReductionDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang23OMPDeclareReductionDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
  }
  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  @Override public String toString() {
    return "" + "Combiner=" + Combiner // NOI18N
              + ", Initializer=" + Initializer // NOI18N
              + ", PrevDeclInScope=" + PrevDeclInScope // NOI18N
              + super.toString(); // NOI18N
  }
}
