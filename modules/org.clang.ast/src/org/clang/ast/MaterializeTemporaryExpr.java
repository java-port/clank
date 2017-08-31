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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Represents a prvalue temporary that is written into memory so that
/// a reference can bind to it.
///
/// Prvalue expressions are materialized when they need to have an address
/// in memory for a reference to bind to. This happens when binding a
/// reference to the result of a conversion, e.g.,
///
/// \code
/// const int &r = 1.0;
/// \endcode
///
/// Here, 1.0 is implicitly converted to an \c int. That resulting \c int is
/// then materialized via a \c MaterializeTemporaryExpr, and the reference
/// binds to the temporary. \c MaterializeTemporaryExprs are always glvalues
/// (either an lvalue or an xvalue, depending on the kind of reference binding
/// to it), maintaining the invariant that references always bind to glvalues.
///
/// Reference binding and copy-elision can both extend the lifetime of a
/// temporary. When either happens, the expression will also track the
/// declaration which is responsible for the lifetime extension.
//<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3962,
 FQN="clang::MaterializeTemporaryExpr", NM="_ZN5clang24MaterializeTemporaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExprE")
//</editor-fold>
public class MaterializeTemporaryExpr extends /*public*/ Expr {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::ExtraState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3964,
   FQN="clang::MaterializeTemporaryExpr::ExtraState", NM="_ZN5clang24MaterializeTemporaryExpr10ExtraStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExpr10ExtraStateE")
  //</editor-fold>
  private static class/*struct*/ ExtraState {
    /// \brief The temporary-generating expression whose value will be
    /// materialized.
    public Stmt /*P*/ Temporary;
    
    /// \brief The declaration which lifetime-extended this reference, if any.
    /// Either a VarDecl, or (for a ctor-initializer) a FieldDecl.
    public /*const*/ ValueDecl /*P*/ ExtendingDecl;
    
    public /*uint*/int ManglingNumber;
    //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::ExtraState::ExtraState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3964,
     FQN="clang::MaterializeTemporaryExpr::ExtraState::ExtraState", NM="_ZN5clang24MaterializeTemporaryExpr10ExtraStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExpr10ExtraStateC1Ev")
    //</editor-fold>
    public /*inline*/ ExtraState() {
    }

    
    @Override public String toString() {
      return "" + "Temporary=" + Temporary // NOI18N
                + ", ExtendingDecl=" + ExtendingDecl // NOI18N
                + ", ManglingNumber=" + ManglingNumber; // NOI18N
    }
  };
  /*friend*/public PointerUnion<Stmt /*P*/ , ExtraState /*P*/ > State;
  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::initializeExtraState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3980,
   FQN="clang::MaterializeTemporaryExpr::initializeExtraState", NM="_ZN5clang24MaterializeTemporaryExpr20initializeExtraStateEPKNS_9ValueDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExpr20initializeExtraStateEPKNS_9ValueDeclEj")
  //</editor-fold>
  private void initializeExtraState(/*const*/ ValueDecl /*P*/ ExtendedBy, 
                      /*uint*/int ManglingNumber) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::MaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3984,
   FQN="clang::MaterializeTemporaryExpr::MaterializeTemporaryExpr", NM="_ZN5clang24MaterializeTemporaryExprC1ENS_8QualTypeEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExprC1ENS_8QualTypeEPNS_4ExprEb")
  //</editor-fold>
  public MaterializeTemporaryExpr(QualType T, Expr /*P*/ Temporary, 
      boolean BoundToLvalueReference) {
    // : Expr(MaterializeTemporaryExprClass, T, BoundToLvalueReference ? VK_LValue : VK_XValue, OK_Ordinary, Temporary->isTypeDependent(), Temporary->isValueDependent(), Temporary->isInstantiationDependent(), Temporary->containsUnexpandedParameterPack()), State(Temporary) 
    //START JInit
    super(StmtClass.MaterializeTemporaryExprClass, new QualType(T), 
        BoundToLvalueReference ? ExprValueKind.VK_LValue : ExprValueKind.VK_XValue, ExprObjectKind.OK_Ordinary, 
        Temporary.isTypeDependent(), Temporary.isValueDependent(), 
        Temporary.isInstantiationDependent(), 
        Temporary.containsUnexpandedParameterPack());
    this.State = new PointerUnion<Stmt /*P*/ , ExtraState /*P*/ >(JD$T.INSTANCE, Stmt /*P*/ .class, Temporary);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::MaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3993,
   FQN="clang::MaterializeTemporaryExpr::MaterializeTemporaryExpr", NM="_ZN5clang24MaterializeTemporaryExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public MaterializeTemporaryExpr(EmptyShell Empty) {
    // : Expr(MaterializeTemporaryExprClass, Empty), State() 
    //START JInit
    super(StmtClass.MaterializeTemporaryExprClass, new EmptyShell(Empty));
    this.State = new PointerUnion<Stmt /*P*/ , ExtraState /*P*/ >(Stmt /*P*/ .class);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3996,
   FQN="clang::MaterializeTemporaryExpr::getTemporary", NM="_ZNK5clang24MaterializeTemporaryExpr12getTemporaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr12getTemporaryEv")
  //</editor-fold>
  public Stmt /*P*/ getTemporary() /*const*/ {
    return (State.is(Stmt /*P*/.class) != 0) ? State.get(Stmt /*P*/.class) : State.get(ExtraState /*P*/.class).Temporary;
  }

  
  /// \brief Retrieve the temporary-generating subexpression whose value will
  /// be materialized into a glvalue.
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::GetTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4003,
   FQN="clang::MaterializeTemporaryExpr::GetTemporaryExpr", NM="_ZNK5clang24MaterializeTemporaryExpr16GetTemporaryExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr16GetTemporaryExprEv")
  //</editor-fold>
  public Expr /*P*/ GetTemporaryExpr() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(getTemporary()));
  }

  
  /// \brief Retrieve the storage duration for the materialized temporary.
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::getStorageDuration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4006,
   FQN="clang::MaterializeTemporaryExpr::getStorageDuration", NM="_ZNK5clang24MaterializeTemporaryExpr18getStorageDurationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr18getStorageDurationEv")
  //</editor-fold>
  public StorageDuration getStorageDuration() /*const*/ {
    /*const*/ ValueDecl /*P*/ ExtendingDecl = getExtendingDecl();
    if (!(ExtendingDecl != null)) {
      return StorageDuration.SD_FullExpression;
    }
    // FIXME: This is not necessarily correct for a temporary materialized
    // within a default initializer.
    if (isa_FieldDecl(ExtendingDecl)) {
      return StorageDuration.SD_Automatic;
    }
    return cast_VarDecl(ExtendingDecl).getStorageDuration();
  }

  
  /// \brief Get the declaration which triggered the lifetime-extension of this
  /// temporary, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::getExtendingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4019,
   FQN="clang::MaterializeTemporaryExpr::getExtendingDecl", NM="_ZNK5clang24MaterializeTemporaryExpr16getExtendingDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr16getExtendingDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ getExtendingDecl() /*const*/ {
    return (State.is(Stmt /*P*/.class) != 0) ? null : State.get(ExtraState /*P*/.class).ExtendingDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::setExtendingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1369,
   FQN="clang::MaterializeTemporaryExpr::setExtendingDecl", NM="_ZN5clang24MaterializeTemporaryExpr16setExtendingDeclEPKNS_9ValueDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExpr16setExtendingDeclEPKNS_9ValueDeclEj")
  //</editor-fold>
  public void setExtendingDecl(/*const*/ ValueDecl /*P*/ ExtendedBy, 
                  /*uint*/int ManglingNumber) {
    // We only need extra state if we have to remember more than just the Stmt.
    if (!(ExtendedBy != null)) {
      return;
    }
    
    // We may need to allocate extra storage for the mangling number and the
    // extended-by ValueDecl.
    if (!(State.is(ExtraState /*P*/.class) != 0)) {
      ExtraState /*P*/ ES = /*FIXME:NEW_EXPR*//*new (ExtendedBy->getASTContext())*/ new ExtraState();
      ES.Temporary = State.get(Stmt /*P*/.class);
      State.$assign_T1$C$R(ExtraState /*P*/.class, ES);
    }
    
    ExtraState /*P*/ ES = State.get(ExtraState /*P*/.class);
    ES.ExtendingDecl = ExtendedBy;
    ES.ManglingNumber = ManglingNumber;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4026,
   FQN="clang::MaterializeTemporaryExpr::getManglingNumber", NM="_ZNK5clang24MaterializeTemporaryExpr17getManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr17getManglingNumberEv")
  //</editor-fold>
  public /*uint*/int getManglingNumber() /*const*/ {
    return (State.is(Stmt /*P*/.class) != 0) ? 0 : State.get(ExtraState /*P*/.class).ManglingNumber;
  }

  
  /// \brief Determine whether this materialized temporary is bound to an
  /// lvalue reference; otherwise, it's bound to an rvalue reference.
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::isBoundToLvalueReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4032,
   FQN="clang::MaterializeTemporaryExpr::isBoundToLvalueReference", NM="_ZNK5clang24MaterializeTemporaryExpr24isBoundToLvalueReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr24isBoundToLvalueReferenceEv")
  //</editor-fold>
  public boolean isBoundToLvalueReference() /*const*/ {
    return getValueKind() == ExprValueKind.VK_LValue;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4036,
   FQN="clang::MaterializeTemporaryExpr::getLocStart", NM="_ZNK5clang24MaterializeTemporaryExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getTemporary().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4039,
   FQN="clang::MaterializeTemporaryExpr::getLocEnd", NM="_ZNK5clang24MaterializeTemporaryExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24MaterializeTemporaryExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getTemporary().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4043,
   FQN="clang::MaterializeTemporaryExpr::classof", NM="_ZN5clang24MaterializeTemporaryExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.MaterializeTemporaryExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::MaterializeTemporaryExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4048,
   FQN="clang::MaterializeTemporaryExpr::children", NM="_ZN5clang24MaterializeTemporaryExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24MaterializeTemporaryExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if ((State.is(Stmt /*P*/.class) != 0)) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(State.getAddrOfPtr1(Stmt/*P*/.class)), new StmtIterator(State.getAddrOfPtr1(Stmt/*P*/.class).$add(1)));
    }
    
    ExtraState /*P*/ ES = State.get(ExtraState /*P*/.class);
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(ES.Temporary))), new StmtIterator(create_type$ptr($AddrOf(ES.Temporary)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "State=" + State // NOI18N
              + super.toString(); // NOI18N
  }
}
