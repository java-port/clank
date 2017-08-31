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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clank.support.Native.NativePOD;

/// \brief Struct that defines common infrastructure to handle mappable
/// expressions used in OpenMP clauses.
//<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2786,
 FQN="clang::OMPClauseMappableExprCommon", NM="_ZN5clang27OMPClauseMappableExprCommonE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommonE")
//</editor-fold>
public interface/*class*/ OMPClauseMappableExprCommon {
/*public:*/
  // \brief Class that represents a component of a mappable expression. E.g.
  // for an expression S.a, the first component is a declaration reference
  // expression associated with 'S' and the second is a member expression
  // associated with the field declaration 'a'. If the expression is an array
  // subscript it may not have any associated declaration. In that case the
  // associated declaration is set to nullptr.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2794,
   FQN="clang::OMPClauseMappableExprCommon::MappableComponent", NM="_ZN5clang27OMPClauseMappableExprCommon17MappableComponentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon17MappableComponentE")
  //</editor-fold>
  public static class MappableComponent implements NativePOD<MappableComponent> {
    // \brief Expression associated with the component.
    private Expr /*P*/ AssociatedExpression/* = null*/;
    // \brief Declaration associated with the declaration. If the component does
    // not have a declaration (e.g. array subscripts or section), this is set to
    // nullptr.
    private ValueDecl /*P*/ AssociatedDeclaration/* = null*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::MappableComponent">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2803,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::MappableComponent", NM="_ZN5clang27OMPClauseMappableExprCommon17MappableComponentC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon17MappableComponentC1Ev")
    //</editor-fold>
    public /*explicit*/ MappableComponent() {
      // : AssociatedExpression(null), AssociatedDeclaration(null) 
      //START JInit
      /*InClass*/this.AssociatedExpression = null;
      /*InClass*/this.AssociatedDeclaration = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::MappableComponent">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2804,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::MappableComponent", NM="_ZN5clang27OMPClauseMappableExprCommon17MappableComponentC1EPNS_4ExprEPNS_9ValueDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon17MappableComponentC1EPNS_4ExprEPNS_9ValueDeclE")
    //</editor-fold>
    public /*explicit*/ MappableComponent(Expr /*P*/ AssociatedExpression, 
        ValueDecl /*P*/ AssociatedDeclaration) {
      // : AssociatedExpression(AssociatedExpression), AssociatedDeclaration(AssociatedDeclaration ? cast<ValueDecl>(AssociatedDeclaration->getCanonicalDecl()) : null) 
      //START JInit
      this.AssociatedExpression = AssociatedExpression;
      this.AssociatedDeclaration = (AssociatedDeclaration != null) ? cast_ValueDecl(AssociatedDeclaration.getCanonicalDecl()) : null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::getAssociatedExpression">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2812,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::getAssociatedExpression", NM="_ZNK5clang27OMPClauseMappableExprCommon17MappableComponent23getAssociatedExpressionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang27OMPClauseMappableExprCommon17MappableComponent23getAssociatedExpressionEv")
    //</editor-fold>
    public Expr /*P*/ getAssociatedExpression() /*const*/ {
      return AssociatedExpression;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::getAssociatedDeclaration">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2813,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::getAssociatedDeclaration", NM="_ZNK5clang27OMPClauseMappableExprCommon17MappableComponent24getAssociatedDeclarationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang27OMPClauseMappableExprCommon17MappableComponent24getAssociatedDeclarationEv")
    //</editor-fold>
    public ValueDecl /*P*/ getAssociatedDeclaration() /*const*/ {
      return AssociatedDeclaration;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2794,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::operator=", NM="_ZN5clang27OMPClauseMappableExprCommon17MappableComponentaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon17MappableComponentaSERKS1_")
    //</editor-fold>
    public /*inline*/ MappableComponent /*&*/ $assign(final /*const*/ MappableComponent /*&*/ $Prm0) {
      this.AssociatedExpression = $Prm0.AssociatedExpression;
      this.AssociatedDeclaration = $Prm0.AssociatedDeclaration;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::~MappableComponent">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2794,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::~MappableComponent", NM="_ZN5clang27OMPClauseMappableExprCommon17MappableComponentD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon17MappableComponentD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::MappableComponent::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2794,
     FQN="clang::OMPClauseMappableExprCommon::MappableComponent::operator=", NM="_ZN5clang27OMPClauseMappableExprCommon17MappableComponentaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon17MappableComponentaSEOS1_")
    //</editor-fold>
    public /*inline*/ MappableComponent /*&*/ $assignMove(final MappableComponent /*&&*/$Prm0) {
      this.AssociatedExpression = $Prm0.AssociatedExpression;
      this.AssociatedDeclaration = $Prm0.AssociatedDeclaration;
      return /*Deref*/this;
    }

    @Override public MappableComponent clone() {
      return new MappableComponent().$assign(this);
    }
    
    @Override public String toString() {
      return "" + "AssociatedExpression=" + AssociatedExpression // NOI18N
                + ", AssociatedDeclaration=" + AssociatedDeclaration; // NOI18N
    }
  };
  
  // \brief List of components of an expression. This first one is the whole
  // expression and the last one is the base expression.
  /*typedef SmallVector<MappableComponent, 8> MappableExprComponentList*/
//  public final class MappableExprComponentList extends SmallVector<MappableComponent>{ };
  /*typedef ArrayRef<MappableComponent> MappableExprComponentListRef*/
//  public final class MappableExprComponentListRef extends ArrayRef<MappableComponent>{ };
  
  // \brief List of all component lists associated to the same base declaration.
  // E.g. if both 'S.a' and 'S.b' are a mappable expressions, each will have
  // their component list but the same base declaration 'S'.
  /*typedef SmallVector<MappableExprComponentList, 8> MappableExprComponentLists*/
//  public final class MappableExprComponentLists extends SmallVector<SmallVector<MappableComponent>>{ };
  /*typedef ArrayRef<MappableExprComponentList> MappableExprComponentListsRef*/
//  public final class MappableExprComponentListsRef extends ArrayRef<SmallVector<MappableComponent>>{ };
/*protected:*/
  // \brief Return the total number of elements in a list of component lists.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::getComponentsTotalNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 561,
   FQN="clang::OMPClauseMappableExprCommon::getComponentsTotalNumber", NM="_ZN5clang27OMPClauseMappableExprCommon24getComponentsTotalNumberEN4llvm8ArrayRefINS1_11SmallVectorINS0_17MappableComponentELj8EEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon24getComponentsTotalNumberEN4llvm8ArrayRefINS1_11SmallVectorINS0_17MappableComponentELj8EEEEE")
  //</editor-fold>
  public/*protected*/ /*interface*/ static /*uint*/int getComponentsTotalNumber(ArrayRef<SmallVector<MappableComponent>> ComponentLists) {
    /*uint*/int TotalNum = 0/*U*/;
    for (final /*constconst*/SmallVector<MappableComponent> /*&*/ C : ComponentLists)  {
      TotalNum += C.size();
    }
    return TotalNum;
  }

  
  // \brief Return the total number of elements in a list of declarations. All
  // declarations are expected to be canonical.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::getUniqueDeclarationsTotalNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 569,
   FQN="clang::OMPClauseMappableExprCommon::getUniqueDeclarationsTotalNumber", NM="_ZN5clang27OMPClauseMappableExprCommon32getUniqueDeclarationsTotalNumberEN4llvm8ArrayRefIPNS_9ValueDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommon32getUniqueDeclarationsTotalNumberEN4llvm8ArrayRefIPNS_9ValueDeclEEE")
  //</editor-fold>
  public/*protected*/ /*interface*/ static /*uint*/int getUniqueDeclarationsTotalNumber(ArrayRef<ValueDecl /*P*/ > Declarations) {
    /*uint*/int TotalNum = 0/*U*/;
    SmallPtrSet</*const*/ ValueDecl /*P*/ > Cache/*J*/= new SmallPtrSet</*const*/ ValueDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    for (ValueDecl /*P*/ D : Declarations) {
      /*const*/ ValueDecl /*P*/ VD = (D != null) ? cast_ValueDecl(D.getCanonicalDecl()) : null;
      if ((Cache.count(VD) != 0)) {
        continue;
      }
      ++TotalNum;
      Cache.insert(VD);
    }
    return TotalNum;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseMappableExprCommon::OMPClauseMappableExprCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2786,
   FQN="clang::OMPClauseMappableExprCommon::OMPClauseMappableExprCommon", NM="_ZN5clang27OMPClauseMappableExprCommonC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang27OMPClauseMappableExprCommonC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $OMPClauseMappableExprCommon() {
  }

}
