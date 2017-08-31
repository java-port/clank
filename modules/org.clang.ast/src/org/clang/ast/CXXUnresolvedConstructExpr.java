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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief Describes an explicit type conversion that uses functional
/// notion but could not be resolved because one or more arguments are
/// type-dependent.
///
/// The explicit type conversions expressed by
/// CXXUnresolvedConstructExpr have the form <tt>T(a1, a2, ..., aN)</tt>,
/// where \c T is some type and \c a1, \c a2, ..., \c aN are values, and
/// either \c T is a dependent type or one or more of the <tt>a</tt>'s is
/// type-dependent. For example, this would occur in a template such
/// as:
///
/// \code
///   template<typename T, typename A1>
///   inline T make_a(const A1& a1) {
///     return T(a1);
///   }
/// \endcode
///
/// When the returned expression is instantiated, it may resolve to a
/// constructor call, conversion function call, or some kind of type
/// conversion.
//<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3021,
 FQN="clang::CXXUnresolvedConstructExpr", NM="_ZN5clang26CXXUnresolvedConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExprE")
//</editor-fold>
public final class CXXUnresolvedConstructExpr extends /*public*/ Expr implements /*private*/ TrailingObjects<CXXUnresolvedConstructExpr, Expr /*P*/ >, ITrailingObjectsJavaBase<CXXUnresolvedConstructExpr> {
  /// \brief The type being constructed.
  /*friend*/public TypeSourceInfo /*P*/ Type;
  
  /// \brief The location of the left parentheses ('(').
  private SourceLocation LParenLoc;
  
  /// \brief The location of the right parentheses (')').
  private SourceLocation RParenLoc;
  
  /// \brief The number of arguments used to construct the type.
  private /*uint*/int NumArgs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::CXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1062,
   FQN="clang::CXXUnresolvedConstructExpr::CXXUnresolvedConstructExpr", NM="_ZN5clang26CXXUnresolvedConstructExprC1EPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExprC1EPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES3_")
  //</editor-fold>
  private CXXUnresolvedConstructExpr(TypeSourceInfo /*P*/ Type, 
      SourceLocation LParenLoc, 
      ArrayRef<Expr /*P*/ > Args, 
      SourceLocation RParenLoc) {
    // : Expr(CXXUnresolvedConstructExprClass, Type->getType().getNonReferenceType(), (Type->getType()->isLValueReferenceType() ? VK_LValue : Type->getType()->isRValueReferenceType() ? VK_XValue : VK_RValue), OK_Ordinary, Type->getType()->isDependentType(), true, true, Type->getType()->containsUnexpandedParameterPack()), TrailingObjects<CXXUnresolvedConstructExpr, Expr * >(), Type(Type), LParenLoc(LParenLoc), RParenLoc(RParenLoc), NumArgs(Args.size()) 
    //START JInit
    super(StmtClass.CXXUnresolvedConstructExprClass, 
        Type.getType().getNonReferenceType(), 
        (Type.getType().$arrow().isLValueReferenceType() ? ExprValueKind.VK_LValue : Type.getType().$arrow().isRValueReferenceType() ? ExprValueKind.VK_XValue : ExprValueKind.VK_RValue), 
        ExprObjectKind.OK_Ordinary, 
        Type.getType().$arrow().isDependentType(), true, true, 
        Type.getType().$arrow().containsUnexpandedParameterPack());
    $TrailingObjects();
    this.Type = Type;
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    this.NumArgs = Args.size();
    //END JInit
    type$ptr<Expr /*P*/ /*P*/> StoredArgs = $tryClone(this.<Expr /*P*/ >getTrailingObjects(Expr.class));
    for (/*uint*/int I = 0; I != Args.size(); ++I) {
      if (Args.$at(I).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      StoredArgs.$set(I, Args.$at(I));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::CXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3041,
   FQN="clang::CXXUnresolvedConstructExpr::CXXUnresolvedConstructExpr", NM="_ZN5clang26CXXUnresolvedConstructExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private CXXUnresolvedConstructExpr(EmptyShell Empty, /*uint*/int NumArgs) {
    // : Expr(CXXUnresolvedConstructExprClass, Empty), TrailingObjects<CXXUnresolvedConstructExpr, Expr * >(), Type(implicit TypeSourceInfo * ()), LParenLoc(), RParenLoc(), NumArgs(NumArgs) 
    //START JInit
    super(StmtClass.CXXUnresolvedConstructExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.Type = /*implicit-init*/((TypeSourceInfo /*P*/ )/*zero-init*/null);
    this.LParenLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    this.NumArgs = NumArgs;
    //END JInit
  }

  
  /*friend  TrailingObjects<CXXUnresolvedConstructExpr, Expr *>*/
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1087,
   FQN="clang::CXXUnresolvedConstructExpr::Create", NM="_ZN5clang26CXXUnresolvedConstructExpr6CreateERKNS_10ASTContextEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr6CreateERKNS_10ASTContextEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES6_")
  //</editor-fold>
  public static CXXUnresolvedConstructExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        TypeSourceInfo /*P*/ Type, 
        SourceLocation LParenLoc, 
        ArrayRef<Expr /*P*/ > Args, 
        SourceLocation RParenLoc) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Expr.class, Args.size()));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CXXUnresolvedConstructExpr(Type, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1097,
   FQN="clang::CXXUnresolvedConstructExpr::CreateEmpty", NM="_ZN5clang26CXXUnresolvedConstructExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static CXXUnresolvedConstructExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumArgs) {
    Stmt.EmptyShell Empty/*J*/= new Stmt.EmptyShell();
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Expr.class, NumArgs));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CXXUnresolvedConstructExpr(new EmptyShell(Empty), NumArgs);
     });
  }

  
  /// \brief Retrieve the type that is being constructed, as specified
  /// in the source code.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3059,
   FQN="clang::CXXUnresolvedConstructExpr::getTypeAsWritten", NM="_ZNK5clang26CXXUnresolvedConstructExpr16getTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr16getTypeAsWrittenEv")
  //</editor-fold>
  public QualType getTypeAsWritten() /*const*/ {
    return Type.getType();
  }

  
  /// \brief Retrieve the type source information for the type being
  /// constructed.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3063,
   FQN="clang::CXXUnresolvedConstructExpr::getTypeSourceInfo", NM="_ZNK5clang26CXXUnresolvedConstructExpr17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return Type;
  }

  
  /// \brief Retrieve the location of the left parentheses ('(') that
  /// precedes the argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3067,
   FQN="clang::CXXUnresolvedConstructExpr::getLParenLoc", NM="_ZNK5clang26CXXUnresolvedConstructExpr12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3068,
   FQN="clang::CXXUnresolvedConstructExpr::setLParenLoc", NM="_ZN5clang26CXXUnresolvedConstructExpr12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation L) {
    LParenLoc.$assign(L);
  }

  
  /// \brief Retrieve the location of the right parentheses (')') that
  /// follows the argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3072,
   FQN="clang::CXXUnresolvedConstructExpr::getRParenLoc", NM="_ZNK5clang26CXXUnresolvedConstructExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3073,
   FQN="clang::CXXUnresolvedConstructExpr::setRParenLoc", NM="_ZN5clang26CXXUnresolvedConstructExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  /// \brief Retrieve the number of arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::arg_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3076,
   FQN="clang::CXXUnresolvedConstructExpr::arg_size", NM="_ZNK5clang26CXXUnresolvedConstructExpr8arg_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr8arg_sizeEv")
  //</editor-fold>
  public /*uint*/int arg_size() /*const*/ {
    return NumArgs;
  }

  
  /*typedef Expr **arg_iterator*/
//  public final class arg_iterator extends type$ptr<Expr /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3079,
   FQN="clang::CXXUnresolvedConstructExpr::arg_begin", NM="_ZN5clang26CXXUnresolvedConstructExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr9arg_beginEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> arg_begin() {
    return this.<Expr /*P*/ >getTrailingObjects(Expr.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3080,
   FQN="clang::CXXUnresolvedConstructExpr::arg_end", NM="_ZN5clang26CXXUnresolvedConstructExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr7arg_endEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> arg_end() {
    return arg_begin().$add(NumArgs);
  }

  
  /*typedef const Expr *const *const_arg_iterator*/
//  public final class const_arg_iterator extends type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3083,
   FQN="clang::CXXUnresolvedConstructExpr::arg_begin", NM="_ZNK5clang26CXXUnresolvedConstructExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr9arg_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> arg_begin$Const() /*const*/ {
    return this.<Expr /*P*/ >getTrailingObjects$Const(Expr.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3084,
   FQN="clang::CXXUnresolvedConstructExpr::arg_end", NM="_ZNK5clang26CXXUnresolvedConstructExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr7arg_endEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> arg_end$Const() /*const*/ {
    return arg_begin$Const().$add(NumArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3088,
   FQN="clang::CXXUnresolvedConstructExpr::getArg", NM="_ZN5clang26CXXUnresolvedConstructExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr6getArgEj")
  //</editor-fold>
  public Expr /*P*/ getArg(/*uint*/int I) {
    assert ($less_uint(I, NumArgs)) : "Argument index out-of-range";
    return (arg_begin().$add(I)).$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3093,
   FQN="clang::CXXUnresolvedConstructExpr::getArg", NM="_ZNK5clang26CXXUnresolvedConstructExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr6getArgEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArg$Const(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, NumArgs)) : "Argument index out-of-range";
    return (arg_begin$Const().$add(I)).$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::setArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3098,
   FQN="clang::CXXUnresolvedConstructExpr::setArg", NM="_ZN5clang26CXXUnresolvedConstructExpr6setArgEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr6setArgEjPNS_4ExprE")
  //</editor-fold>
  public void setArg(/*uint*/int I, Expr /*P*/ E) {
    assert ($less_uint(I, NumArgs)) : "Argument index out-of-range";
    (arg_begin().$add(I)).$set(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1104,
   FQN="clang::CXXUnresolvedConstructExpr::getLocStart", NM="_ZNK5clang26CXXUnresolvedConstructExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Type.getTypeLoc().getBeginLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3104,
   FQN="clang::CXXUnresolvedConstructExpr::getLocEnd", NM="_ZNK5clang26CXXUnresolvedConstructExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang26CXXUnresolvedConstructExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (!RParenLoc.isValid() && $greater_uint(NumArgs, 0)) {
      return getArg$Const(NumArgs - 1).getLocEnd();
    }
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3110,
   FQN="clang::CXXUnresolvedConstructExpr::classof", NM="_ZN5clang26CXXUnresolvedConstructExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXUnresolvedConstructExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUnresolvedConstructExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3115,
   FQN="clang::CXXUnresolvedConstructExpr::children", NM="_ZN5clang26CXXUnresolvedConstructExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang26CXXUnresolvedConstructExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    type$ptr<Stmt /*P*/ /*P*/> begin = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, arg_begin())));
    return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), new StmtIterator(begin.$add(NumArgs)));
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == Expr.class;
    return 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Type=" + Type // NOI18N
              + ", LParenLoc=" + LParenLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + super.toString(); // NOI18N
  }
}
