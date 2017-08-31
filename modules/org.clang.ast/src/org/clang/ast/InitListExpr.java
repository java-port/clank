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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// @brief Describes an C or C++ initializer list.
///
/// InitListExpr describes an initializer list, which can be used to
/// initialize objects of different types, including
/// struct/class/union types, arrays, and vectors. For example:
///
/// @code
/// struct foo x = { 1, { 2, 3 } };
/// @endcode
///
/// Prior to semantic analysis, an initializer list will represent the
/// initializer list as written by the user, but will have the
/// placeholder type "void". This initializer list is called the
/// syntactic form of the initializer, and may contain C99 designated
/// initializers (represented as DesignatedInitExprs), initializations
/// of subobject members without explicit braces, and so on. Clients
/// interested in the original syntax of the initializer list should
/// use the syntactic form of the initializer list.
///
/// After semantic analysis, the initializer list will represent the
/// semantic form of the initializer, where the initializations of all
/// subobjects are made explicit with nested InitListExpr nodes and
/// C99 designators have been eliminated by placing the designated
/// initializations into the subobject they initialize. Additionally,
/// any "holes" in the initialization, where no initializer has been
/// specified for a particular subobject, will be replaced with
/// implicitly-generated ImplicitValueInitExpr expressions that
/// value-initialize the subobjects. Note, however, that the
/// initializer lists may still have fewer initializers than there are
/// elements to initialize within the object.
///
/// After semantic analysis has completed, given an initializer list,
/// method isSemanticForm() returns true if and only if this is the
/// semantic form of the initializer list (note: the same AST node
/// may at the same time be the syntactic form).
/// Given the semantic form of the initializer list, one can retrieve
/// the syntactic form of that initializer list (when different)
/// using method getSyntacticForm(); the method returns null if applied
/// to a initializer list which is already in syntactic form.
/// Similarly, given the syntactic form (i.e., an initializer list such
/// that isSemanticForm() returns false), one can retrieve the semantic
/// form using method getSemanticForm().
/// Since many initializer lists have the same syntactic and semantic forms,
/// getSyntacticForm() may return NULL, indicating that the current
/// semantic initializer list also serves as its syntactic form.
//<editor-fold defaultstate="collapsed" desc="clang::InitListExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3746,
 FQN="clang::InitListExpr", NM="_ZN5clang12InitListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExprE")
//</editor-fold>
public class InitListExpr extends /*public*/ Expr implements Destructors.ClassWithDestructor {
  // FIXME: Eliminate this vector in favor of ASTContext allocation
  /*typedef ASTVector<Stmt *> InitExprsTy*/
//  public final class InitExprsTy extends ASTVector<Stmt /*P*/ >{ };
  private ASTVector<Stmt /*P*/ > InitExprs;
  private SourceLocation LBraceLoc;
  private SourceLocation RBraceLoc;
  
  /// The alternative form of the initializer list (if it exists).
  /// The int part of the pair stores whether this initializer list is
  /// in semantic form. If not null, the pointer points to:
  ///   - the syntactic form, if this is in semantic form;
  ///   - the semantic form, if this is in syntactic form.
  private PointerBoolPair<InitListExpr /*P*/ > AltForm;
  
  /// \brief Either:
  ///  If this initializer list initializes an array with more elements than
  ///  there are initializers in the list, specifies an expression to be used
  ///  for value initialization of the rest of the elements.
  /// Or
  ///  If this initializer list initializes a union, specifies which
  ///  field within the union will be initialized.
  /*friend*/public PointerUnion<Expr /*P*/ , FieldDecl /*P*/ > ArrayFillerOrUnionFieldInit;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::InitListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1766,
   FQN="clang::InitListExpr::InitListExpr", NM="_ZN5clang12InitListExprC1ERKNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExprC1ERKNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES4_")
  //</editor-fold>
  public InitListExpr(final /*const*/ ASTContext /*&*/ C, SourceLocation lbraceloc, 
      ArrayRef<Expr /*P*/ > initExprs, SourceLocation rbraceloc) {
    // : Expr(InitListExprClass, QualType(), VK_RValue, OK_Ordinary, false, false, false, false), InitExprs(C, initExprs.size()), LBraceLoc(lbraceloc), RBraceLoc(rbraceloc), AltForm(null, true), ArrayFillerOrUnionFieldInit() 
    //START JInit
    super(StmtClass.InitListExprClass, new QualType(), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.InitExprs = new ASTVector<Stmt /*P*/ >(C, initExprs.size(), null);
    this.LBraceLoc = new SourceLocation(lbraceloc);
    this.RBraceLoc = new SourceLocation(rbraceloc);
    this.AltForm = new PointerBoolPair<InitListExpr /*P*/ >((InitListExpr /*P*/ )null, true);
    this.ArrayFillerOrUnionFieldInit = new PointerUnion<Expr /*P*/ , FieldDecl /*P*/ >(Expr /*P*/ .class);
    //END JInit
    sawArrayRangeDesignator(false);
    for (/*uint*/int I = 0; I != initExprs.size(); ++I) {
      if (initExprs.$at(I).isTypeDependent()) {
        Unnamed_field.ExprBits.TypeDependent = true;
      }
      if (initExprs.$at(I).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (initExprs.$at(I).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (initExprs.$at(I).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
    }
    
    InitExprs.insert_ASTContext$C_type$ptr$T$P_T(C, InitExprs.end(), initExprs.begin(), initExprs.end());
  }

  
  /// \brief Build an empty initializer list.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::InitListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3773,
   FQN="clang::InitListExpr::InitListExpr", NM="_ZN5clang12InitListExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ InitListExpr(EmptyShell Empty) {
    // : Expr(InitListExprClass, Empty), InitExprs(), LBraceLoc(), RBraceLoc(), AltForm(), ArrayFillerOrUnionFieldInit() 
    //START JInit
    super(StmtClass.InitListExprClass, new EmptyShell(Empty));
    this.InitExprs = new ASTVector<Stmt /*P*/ >(null);
    this.LBraceLoc = new SourceLocation();
    this.RBraceLoc = new SourceLocation();
    this.AltForm = new PointerBoolPair<InitListExpr /*P*/ >();
    this.ArrayFillerOrUnionFieldInit = new PointerUnion<Expr /*P*/ , FieldDecl /*P*/ >(Expr /*P*/ .class);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getNumInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3776,
   FQN="clang::InitListExpr::getNumInits", NM="_ZNK5clang12InitListExpr11getNumInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr11getNumInitsEv")
  //</editor-fold>
  public /*uint*/int getNumInits() /*const*/ {
    return InitExprs.size();
  }

  
  /// \brief Retrieve the set of initializers.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3779,
   FQN="clang::InitListExpr::getInits", NM="_ZN5clang12InitListExpr8getInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr8getInitsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getInits() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, InitExprs.data()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3781,
   FQN="clang::InitListExpr::inits", NM="_ZN5clang12InitListExpr5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr5initsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > inits() {
    return llvm.makeArrayRef(getInits(), getNumInits());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3785,
   FQN="clang::InitListExpr::getInit", NM="_ZNK5clang12InitListExpr7getInitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr7getInitEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInit$Const(/*uint*/int Init) /*const*/ {
    assert ($less_uint(Init, getNumInits())) : "Initializer access out of range!";
    return cast_or_null_Expr(InitExprs.$at$Const(Init));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3790,
   FQN="clang::InitListExpr::getInit", NM="_ZN5clang12InitListExpr7getInitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr7getInitEj")
  //</editor-fold>
  public Expr /*P*/ getInit(/*uint*/int Init) {
    assert ($less_uint(Init, getNumInits())) : "Initializer access out of range!";
    return cast_or_null_Expr(InitExprs.$at(Init));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::setInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3795,
   FQN="clang::InitListExpr::setInit", NM="_ZN5clang12InitListExpr7setInitEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr7setInitEjPNS_4ExprE")
  //</editor-fold>
  public void setInit(/*uint*/int Init, Expr /*P*/ expr) {
    assert ($less_uint(Init, getNumInits())) : "Initializer access out of range!";
    InitExprs.$set(Init, expr);
    if ((expr != null)) {
      Unnamed_field.ExprBits.TypeDependent |= expr.isTypeDependent();
      Unnamed_field.ExprBits.ValueDependent |= expr.isValueDependent();
      Unnamed_field.ExprBits.InstantiationDependent |= expr.isInstantiationDependent();
      Unnamed_field.ExprBits.ContainsUnexpandedParameterPack |= expr.containsUnexpandedParameterPack();
    }
  }

  
  /// \brief Reserve space for some number of initializers.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::reserveInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1788,
   FQN="clang::InitListExpr::reserveInits", NM="_ZN5clang12InitListExpr12reserveInitsERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr12reserveInitsERKNS_10ASTContextEj")
  //</editor-fold>
  public void reserveInits(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumInits) {
    if ($greater_uint(NumInits, InitExprs.size())) {
      InitExprs.reserve(C, NumInits);
    }
  }

  
  /// @brief Specify the number of initializers
  ///
  /// If there are more than @p NumInits initializers, the remaining
  /// initializers will be destroyed. If there are fewer than @p
  /// NumInits initializers, NULL expressions will be added for the
  /// unknown initializers.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::resizeInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1793,
   FQN="clang::InitListExpr::resizeInits", NM="_ZN5clang12InitListExpr11resizeInitsERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr11resizeInitsERKNS_10ASTContextEj")
  //</editor-fold>
  public void resizeInits(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumInits) {
    InitExprs.resize(C, NumInits, (Stmt /*P*/ /*const*/)null);
  }

  
  /// @brief Updates the initializer at index @p Init with the new
  /// expression @p expr, and returns the old expression at that
  /// location.
  ///
  /// When @p Init is out of range for this initializer list, the
  /// initializer list will be extended with NULL expressions to
  /// accommodate the new entry.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::updateInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1797,
   FQN="clang::InitListExpr::updateInit", NM="_ZN5clang12InitListExpr10updateInitERKNS_10ASTContextEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr10updateInitERKNS_10ASTContextEjPNS_4ExprE")
  //</editor-fold>
  public Expr /*P*/ updateInit(final /*const*/ ASTContext /*&*/ C, /*uint*/int Init, Expr /*P*/ expr) {
    if ($greatereq_uint(Init, InitExprs.size())) {
      InitExprs.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(C, InitExprs.end(), Init - InitExprs.size() + 1, (Stmt /*P*/ /*const*/)null);
      setInit(Init, expr);
      return null;
    }
    
    Expr /*P*/ Result = cast_or_null_Expr(InitExprs.$at(Init));
    setInit(Init, expr);
    return Result;
  }

  
  /// \brief If this initializer list initializes an array with more elements
  /// than there are initializers in the list, specifies an expression to be
  /// used for value initialization of the rest of the elements.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getArrayFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3831,
   FQN="clang::InitListExpr::getArrayFiller", NM="_ZN5clang12InitListExpr14getArrayFillerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr14getArrayFillerEv")
  //</editor-fold>
  public Expr /*P*/ getArrayFiller() {
    return ArrayFillerOrUnionFieldInit.dyn_cast(Expr /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getArrayFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3834,
   FQN="clang::InitListExpr::getArrayFiller", NM="_ZNK5clang12InitListExpr14getArrayFillerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr14getArrayFillerEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArrayFiller$Const() /*const*/ {
    return ((/*const_cast*/InitListExpr /*P*/ )(this)).getArrayFiller();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::setArrayFiller">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1809,
   FQN="clang::InitListExpr::setArrayFiller", NM="_ZN5clang12InitListExpr14setArrayFillerEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr14setArrayFillerEPNS_4ExprE")
  //</editor-fold>
  public void setArrayFiller(Expr /*P*/ filler) {
    assert (!hasArrayFiller()) : "Filler already set!";
    ArrayFillerOrUnionFieldInit.$assign_T$C$R(Expr /*P*/.class, filler);
    // Fill out any "holes" in the array due to designated initializers.
    type$ptr<Expr /*P*/ /*P*/> inits = $tryClone(getInits());
    for (/*uint*/int i = 0, e = getNumInits(); i != e; ++i)  {
      if (inits.$at(i) == null) {
        inits.$set(i, filler);
      }
    }
  }

  
  /// \brief Return true if this is an array initializer and its array "filler"
  /// has been set.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::hasArrayFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3841,
   FQN="clang::InitListExpr::hasArrayFiller", NM="_ZNK5clang12InitListExpr14hasArrayFillerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr14hasArrayFillerEv")
  //</editor-fold>
  public boolean hasArrayFiller() /*const*/ {
    return (getArrayFiller$Const() != null);
  }

  
  /// \brief If this initializes a union, specifies which field in the
  /// union to initialize.
  ///
  /// Typically, this field is the first named field within the
  /// union. However, a designated initializer can specify the
  /// initialization of a different field within the union.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getInitializedFieldInUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3849,
   FQN="clang::InitListExpr::getInitializedFieldInUnion", NM="_ZN5clang12InitListExpr26getInitializedFieldInUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr26getInitializedFieldInUnionEv")
  //</editor-fold>
  public FieldDecl /*P*/ getInitializedFieldInUnion() {
    return ArrayFillerOrUnionFieldInit.dyn_cast(FieldDecl /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getInitializedFieldInUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3852,
   FQN="clang::InitListExpr::getInitializedFieldInUnion", NM="_ZNK5clang12InitListExpr26getInitializedFieldInUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr26getInitializedFieldInUnionEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getInitializedFieldInUnion$Const() /*const*/ {
    return ((/*const_cast*/InitListExpr /*P*/ )(this)).getInitializedFieldInUnion();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::setInitializedFieldInUnion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3855,
   FQN="clang::InitListExpr::setInitializedFieldInUnion", NM="_ZN5clang12InitListExpr26setInitializedFieldInUnionEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr26setInitializedFieldInUnionEPNS_9FieldDeclE")
  //</editor-fold>
  public void setInitializedFieldInUnion(FieldDecl /*P*/ FD) {
    assert ((FD == null || getInitializedFieldInUnion() == null || getInitializedFieldInUnion() == FD)) : "Only one field of a union may be initialized at a time!";
    ArrayFillerOrUnionFieldInit.$assign_T1$C$R(FieldDecl /*P*/.class, FD);
  }

  
  // Explicit InitListExpr's originate from source code (and have valid source
  // locations). Implicit InitListExpr's are created by the semantic analyzer.
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::isExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3865,
   FQN="clang::InitListExpr::isExplicit", NM="_ZN5clang12InitListExpr10isExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr10isExplicitEv")
  //</editor-fold>
  public boolean isExplicit() {
    return LBraceLoc.isValid() && RBraceLoc.isValid();
  }

  
  // Is this an initializer for an array of characters, initialized by a string
  // literal or an @encode?
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::isStringLiteralInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1819,
   FQN="clang::InitListExpr::isStringLiteralInit", NM="_ZNK5clang12InitListExpr19isStringLiteralInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr19isStringLiteralInitEv")
  //</editor-fold>
  public boolean isStringLiteralInit() /*const*/ {
    if (getNumInits() != 1) {
      return false;
    }
    /*const*/ ArrayType /*P*/ AT = getType().$arrow().getAsArrayTypeUnsafe();
    if (!(AT != null) || !AT.getElementType().$arrow().isIntegerType()) {
      return false;
    }
    // It is possible for getInit() to return null.
    /*const*/ Expr /*P*/ Init = getInit$Const(0);
    if (!(Init != null)) {
      return false;
    }
    Init = Init.IgnoreParens$Const();
    return isa_StringLiteral(Init) || isa_ObjCEncodeExpr(Init);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3873,
   FQN="clang::InitListExpr::getLBraceLoc", NM="_ZNK5clang12InitListExpr12getLBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr12getLBraceLocEv")
  //</editor-fold>
  public SourceLocation getLBraceLoc() /*const*/ {
    return new SourceLocation(LBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::setLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3874,
   FQN="clang::InitListExpr::setLBraceLoc", NM="_ZN5clang12InitListExpr12setLBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr12setLBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLBraceLoc(SourceLocation Loc) {
    LBraceLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3875,
   FQN="clang::InitListExpr::getRBraceLoc", NM="_ZNK5clang12InitListExpr12getRBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr12getRBraceLocEv")
  //</editor-fold>
  public SourceLocation getRBraceLoc() /*const*/ {
    return new SourceLocation(RBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::setRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3876,
   FQN="clang::InitListExpr::setRBraceLoc", NM="_ZN5clang12InitListExpr12setRBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr12setRBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBraceLoc(SourceLocation Loc) {
    RBraceLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::isSemanticForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3878,
   FQN="clang::InitListExpr::isSemanticForm", NM="_ZNK5clang12InitListExpr14isSemanticFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr14isSemanticFormEv")
  //</editor-fold>
  public boolean isSemanticForm() /*const*/ {
    return AltForm.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getSemanticForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3879,
   FQN="clang::InitListExpr::getSemanticForm", NM="_ZNK5clang12InitListExpr15getSemanticFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr15getSemanticFormEv")
  //</editor-fold>
  public InitListExpr /*P*/ getSemanticForm() /*const*/ {
    return isSemanticForm() ? null : AltForm.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getSyntacticForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3882,
   FQN="clang::InitListExpr::getSyntacticForm", NM="_ZNK5clang12InitListExpr16getSyntacticFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr16getSyntacticFormEv")
  //</editor-fold>
  public InitListExpr /*P*/ getSyntacticForm() /*const*/ {
    return isSemanticForm() ? AltForm.getPointer() : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::setSyntacticForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3886,
   FQN="clang::InitListExpr::setSyntacticForm", NM="_ZN5clang12InitListExpr16setSyntacticFormEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr16setSyntacticFormEPS0_")
  //</editor-fold>
  public void setSyntacticForm(InitListExpr /*P*/ Init) {
    AltForm.setPointer(Init);
    AltForm.setInt(true);
    Init.AltForm.setPointer(this);
    Init.AltForm.setInt(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::hadArrayRangeDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3893,
   FQN="clang::InitListExpr::hadArrayRangeDesignator", NM="_ZNK5clang12InitListExpr23hadArrayRangeDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr23hadArrayRangeDesignatorEv")
  //</editor-fold>
  public boolean hadArrayRangeDesignator() /*const*/ {
    return Unnamed_field.InitListExprBits.HadArrayRangeDesignator != false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::sawArrayRangeDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3896,
   FQN="clang::InitListExpr::sawArrayRangeDesignator", NM="_ZN5clang12InitListExpr23sawArrayRangeDesignatorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr23sawArrayRangeDesignatorEb")
  //</editor-fold>
  public void sawArrayRangeDesignator() {
    sawArrayRangeDesignator(true);
  }
  public void sawArrayRangeDesignator(boolean ARD/*= true*/) {
    Unnamed_field.InitListExprBits.HadArrayRangeDesignator = ARD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1833,
   FQN="clang::InitListExpr::getLocStart", NM="_ZNK5clang12InitListExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    {
      InitListExpr /*P*/ SyntacticForm = getSyntacticForm();
      if ((SyntacticForm != null)) {
        return SyntacticForm.getLocStart();
      }
    }
    SourceLocation Beg = new SourceLocation(LBraceLoc);
    if (Beg.isInvalid()) {
      // Find the first non-null initializer.
      for (type$ptr<Stmt/*P*/>/*iterator*/ I = $tryClone(InitExprs.begin$Const()), 
          /*P*/ E = $tryClone(InitExprs.end$Const());
           $noteq_ptr(I, E); I.$preInc()) {
        {
          Stmt /*P*/ S = I.$star();
          if ((S != null)) {
            Beg.$assignMove(S.getLocStart());
            break;
          }
        }
      }
    }
    return Beg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1851,
   FQN="clang::InitListExpr::getLocEnd", NM="_ZNK5clang12InitListExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    {
      InitListExpr /*P*/ SyntacticForm = getSyntacticForm();
      if ((SyntacticForm != null)) {
        return SyntacticForm.getLocEnd();
      }
    }
    SourceLocation End = new SourceLocation(RBraceLoc);
    if (End.isInvalid()) {
      // Find the first non-null initializer from the end.
      for (std.reverse_iterator<Stmt /*P*/ /*const*/> I = InitExprs.rbegin$Const(), 
          E = InitExprs.rend$Const();
           $noteq_reverse_iterator$C(I, E); I.$preInc()) {
        {
          Stmt /*P*/ S = I.$star();
          if ((S != null)) {
            End.$assignMove(S.getLocEnd());
            break;
          }
        }
      }
    }
    return End;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3903,
   FQN="clang::InitListExpr::classof", NM="_ZN5clang12InitListExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.InitListExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3908,
   FQN="clang::InitListExpr::children", NM="_ZN5clang12InitListExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    // FIXME: This does not include the array filler expression.
    if (InitExprs.empty()) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(InitExprs.begin())), new StmtIterator($AddrOf(InitExprs.end())));
  }

  
  /*typedef InitExprsTy::iterator iterator*/
//  public final class iterator extends type$ptr<Stmt/*P*/>/*iterator*/{ };
  /*typedef InitExprsTy::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr<Stmt/*P*/>/*iterator*/{ };
  /*typedef InitExprsTy::reverse_iterator reverse_iterator*/
//  public final class reverse_iterator extends std.reverse_iterator<Stmt /*P*/ >{ };
  /*typedef InitExprsTy::const_reverse_iterator const_reverse_iterator*/
//  public final class const_reverse_iterator extends std.reverse_iterator<Stmt /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3920,
   FQN="clang::InitListExpr::begin", NM="_ZN5clang12InitListExpr5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr5beginEv")
  //</editor-fold>
  public type$ptr<Stmt/*P*/>/*iterator*/ begin() {
    return InitExprs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3921,
   FQN="clang::InitListExpr::begin", NM="_ZNK5clang12InitListExpr5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr5beginEv")
  //</editor-fold>
  public type$ptr<Stmt/*P*/>/*iterator*/ begin$Const() /*const*/ {
    return InitExprs.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3922,
   FQN="clang::InitListExpr::end", NM="_ZN5clang12InitListExpr3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr3endEv")
  //</editor-fold>
  public type$ptr<Stmt/*P*/>/*iterator*/ end() {
    return InitExprs.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3923,
   FQN="clang::InitListExpr::end", NM="_ZNK5clang12InitListExpr3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr3endEv")
  //</editor-fold>
  public type$ptr<Stmt/*P*/>/*iterator*/ end$Const() /*const*/ {
    return InitExprs.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3924,
   FQN="clang::InitListExpr::rbegin", NM="_ZN5clang12InitListExpr6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ > rbegin() {
    return InitExprs.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3925,
   FQN="clang::InitListExpr::rbegin", NM="_ZNK5clang12InitListExpr6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ /*const*/> rbegin$Const() /*const*/ {
    return InitExprs.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3926,
   FQN="clang::InitListExpr::rend", NM="_ZN5clang12InitListExpr4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12InitListExpr4rendEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ > rend() {
    return InitExprs.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3927,
   FQN="clang::InitListExpr::rend", NM="_ZNK5clang12InitListExpr4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12InitListExpr4rendEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ /*const*/> rend$Const() /*const*/ {
    return InitExprs.rend$Const();
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::InitListExpr::~InitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3746,
   FQN="clang::InitListExpr::~InitListExpr", NM="_ZN5clang12InitListExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang12InitListExprD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    InitExprs.$destroy();
    super.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "InitExprs=" + InitExprs // NOI18N
              + ", LBraceLoc=" + LBraceLoc // NOI18N
              + ", RBraceLoc=" + RBraceLoc // NOI18N
              + ", AltForm=" + AltForm // NOI18N
              + ", ArrayFillerOrUnionFieldInit=" + ArrayFillerOrUnionFieldInit // NOI18N
              + super.toString(); // NOI18N
  }
}
