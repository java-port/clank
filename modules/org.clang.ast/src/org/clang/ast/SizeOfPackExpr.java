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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief Represents an expression that computes the length of a parameter
/// pack.
///
/// \code
/// template<typename ...Types>
/// struct count {
///   static const unsigned value = sizeof...(Types);
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3653,
 FQN="clang::SizeOfPackExpr", NM="_ZN5clang14SizeOfPackExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExprE")
//</editor-fold>
public final class SizeOfPackExpr extends /*public*/ Expr implements /*private*/ TrailingObjects<SizeOfPackExpr, TemplateArgument> {
  /// \brief The location of the \c sizeof keyword.
  /*friend*/public SourceLocation OperatorLoc;
  
  /// \brief The location of the name of the parameter pack.
  /*friend*/public SourceLocation PackLoc;
  
  /// \brief The location of the closing parenthesis.
  /*friend*/public SourceLocation RParenLoc;
  
  /// \brief The length of the parameter pack, if known.
  ///
  /// When this expression is not value-dependent, this is the length of
  /// the pack. When the expression was parsed rather than instantiated
  /// (and thus is value-dependent), this is zero.
  ///
  /// After partial substitution into a sizeof...(X) expression (for instance,
  /// within an alias template or during function template argument deduction),
  /// we store a trailing array of partially-substituted TemplateArguments,
  /// and this is the length of that array.
  /*friend*/public /*uint*/int Length;
  
  /// \brief The parameter pack.
  /*friend*/public NamedDecl /*P*/ Pack;
  
  /*friend  TrailingObjects<SizeOfPackExpr, TemplateArgument>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  /// \brief Create an expression that computes the length of
  /// the given parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::SizeOfPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3686,
   FQN="clang::SizeOfPackExpr::SizeOfPackExpr", NM="_ZN5clang14SizeOfPackExprC1ENS_8QualTypeENS_14SourceLocationEPNS_9NamedDeclES2_S2_N4llvm8OptionalIjEENS5_8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExprC1ENS_8QualTypeENS_14SourceLocationEPNS_9NamedDeclES2_S2_N4llvm8OptionalIjEENS5_8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  private SizeOfPackExpr(QualType SizeType, SourceLocation OperatorLoc, NamedDecl /*P*/ Pack, 
      SourceLocation PackLoc, SourceLocation RParenLoc, 
      OptionalUInt Length, ArrayRef<TemplateArgument> PartialArgs) {
    // : Expr(SizeOfPackExprClass, SizeType, VK_RValue, OK_Ordinary, /*TypeDependent=*/ false, /*ValueDependent=*/ !Length.operator bool(), /*InstantiationDependent=*/ !Length.operator bool(), /*ContainsUnexpandedParameterPack=*/ false), TrailingObjects<SizeOfPackExpr, TemplateArgument>(), OperatorLoc(OperatorLoc), PackLoc(PackLoc), RParenLoc(RParenLoc), Length(Length.operator bool() ? * Length : PartialArgs.size()), Pack(Pack) 
    //START JInit
    super(StmtClass.SizeOfPackExprClass, new QualType(SizeType), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, !Length.$bool(), 
        !Length.$bool(), 
        false);
    $TrailingObjects();
    this.OperatorLoc = new SourceLocation(OperatorLoc);
    this.PackLoc = new SourceLocation(PackLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    this.Length = Length.$bool() ? Length.$star() : PartialArgs.size();
    this.Pack = Pack;
    //END JInit
    assert ((!Length.$bool() || PartialArgs.empty())) : "have partial args for non-dependent sizeof... expression";
    type$ptr<TemplateArgument/*P*/> Args = $tryClone(this.<TemplateArgument>getTrailingObjects(TemplateArgument.class));
    std.uninitialized_copy(PartialArgs.begin(), PartialArgs.end(), Args);
  }

  
  /// \brief Create an empty expression.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::SizeOfPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3702,
   FQN="clang::SizeOfPackExpr::SizeOfPackExpr", NM="_ZN5clang14SizeOfPackExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private SizeOfPackExpr(EmptyShell Empty, /*uint*/int NumPartialArgs) {
    // : Expr(SizeOfPackExprClass, Empty), TrailingObjects<SizeOfPackExpr, TemplateArgument>(), OperatorLoc(), PackLoc(), RParenLoc(), Length(NumPartialArgs), Pack(implicit NamedDecl * ()) 
    //START JInit
    super(StmtClass.SizeOfPackExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.OperatorLoc = new SourceLocation();
    this.PackLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    this.Length = NumPartialArgs;
    this.Pack = /*implicit-init*/((NamedDecl /*P*/ )/*zero-init*/null);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1309,
   FQN="clang::SizeOfPackExpr::Create", NM="_ZN5clang14SizeOfPackExpr6CreateERNS_10ASTContextENS_14SourceLocationEPNS_9NamedDeclES3_S3_N4llvm8OptionalIjEENS6_8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExpr6CreateERNS_10ASTContextENS_14SourceLocationEPNS_9NamedDeclES3_S3_N4llvm8OptionalIjEENS6_8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public static SizeOfPackExpr /*P*/ Create(final ASTContext /*&*/ Context, SourceLocation OperatorLoc, 
        NamedDecl /*P*/ Pack, SourceLocation PackLoc, 
        SourceLocation RParenLoc) {
    return Create(Context, OperatorLoc, 
        Pack, PackLoc, 
        RParenLoc, 
        new OptionalUInt(None), 
        new ArrayRef<TemplateArgument>(None, false));
  }
  public static SizeOfPackExpr /*P*/ Create(final ASTContext /*&*/ Context, SourceLocation OperatorLoc, 
        NamedDecl /*P*/ Pack, SourceLocation PackLoc, 
        SourceLocation RParenLoc, 
        OptionalUInt Length/*= None*/) {
    return Create(Context, OperatorLoc, 
        Pack, PackLoc, 
        RParenLoc, 
        Length, 
        new ArrayRef<TemplateArgument>(None, false));
  }
  public static SizeOfPackExpr /*P*/ Create(final ASTContext /*&*/ Context, SourceLocation OperatorLoc, 
        NamedDecl /*P*/ Pack, SourceLocation PackLoc, 
        SourceLocation RParenLoc, 
        OptionalUInt Length/*= None*/, 
        ArrayRef<TemplateArgument> PartialArgs/*= None*/) {
    Object/*void P*/ Storage;
    if (false) {
      Storage = Context.Allocate(TrailingObjects.totalSizeToAlloc$Same(TemplateArgument.class, PartialArgs.size()));
    } else {
      Storage = Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(TemplateArgument.class, PartialArgs.size()));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Storage)*/ Stmt.$new(Storage, (type$ptr<?> Mem)->{
        return new SizeOfPackExpr(Context.getSizeType().$QualType(), new SourceLocation(OperatorLoc), Pack, 
                new SourceLocation(PackLoc), new SourceLocation(RParenLoc), new OptionalUInt(Length), new ArrayRef<TemplateArgument>(PartialArgs));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1321,
   FQN="clang::SizeOfPackExpr::CreateDeserialized", NM="_ZN5clang14SizeOfPackExpr18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExpr18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static SizeOfPackExpr /*P*/ CreateDeserialized(final ASTContext /*&*/ Context, 
                    /*uint*/int NumPartialArgs) {
    Object/*void P*/ Storage;
    if (false) {
      Storage = Context.Allocate(TrailingObjects.totalSizeToAlloc$Same(TemplateArgument.class, NumPartialArgs));
    } else {
      Storage = Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(TemplateArgument.class, NumPartialArgs));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Storage)*/ Stmt.$new(Storage, (type$ptr<?> Mem)->{
        return new SizeOfPackExpr(new EmptyShell(), NumPartialArgs);
     });
  }

  
  /// \brief Determine the location of the 'sizeof' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3715,
   FQN="clang::SizeOfPackExpr::getOperatorLoc", NM="_ZNK5clang14SizeOfPackExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OperatorLoc);
  }

  
  /// \brief Determine the location of the parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getPackLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3718,
   FQN="clang::SizeOfPackExpr::getPackLoc", NM="_ZNK5clang14SizeOfPackExpr10getPackLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr10getPackLocEv")
  //</editor-fold>
  public SourceLocation getPackLoc() /*const*/ {
    return new SourceLocation(PackLoc);
  }

  
  /// \brief Determine the location of the right parenthesis.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3721,
   FQN="clang::SizeOfPackExpr::getRParenLoc", NM="_ZNK5clang14SizeOfPackExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  /// \brief Retrieve the parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3724,
   FQN="clang::SizeOfPackExpr::getPack", NM="_ZNK5clang14SizeOfPackExpr7getPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr7getPackEv")
  //</editor-fold>
  public NamedDecl /*P*/ getPack() /*const*/ {
    return Pack;
  }

  
  /// \brief Retrieve the length of the parameter pack.
  ///
  /// This routine may only be invoked when the expression is not
  /// value-dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getPackLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3730,
   FQN="clang::SizeOfPackExpr::getPackLength", NM="_ZNK5clang14SizeOfPackExpr13getPackLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr13getPackLengthEv")
  //</editor-fold>
  public /*uint*/int getPackLength() /*const*/ {
    assert (!isValueDependent()) : "Cannot get the length of a value-dependent pack size expression";
    return Length;
  }

  
  /// \brief Determine whether this represents a partially-substituted sizeof...
  /// expression, such as is produced for:
  ///
  ///   template<typename ...Ts> using X = int[sizeof...(Ts)];
  ///   template<typename ...Us> void f(X<Us..., 1, 2, 3, Us...>);
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::isPartiallySubstituted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3741,
   FQN="clang::SizeOfPackExpr::isPartiallySubstituted", NM="_ZNK5clang14SizeOfPackExpr22isPartiallySubstitutedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr22isPartiallySubstitutedEv")
  //</editor-fold>
  public boolean isPartiallySubstituted() /*const*/ {
    return isValueDependent() && (Length != 0);
  }

  
  /// \brief Get
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getPartialArguments">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3746,
   FQN="clang::SizeOfPackExpr::getPartialArguments", NM="_ZNK5clang14SizeOfPackExpr19getPartialArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr19getPartialArgumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgument> getPartialArguments() /*const*/ {
    assert (isPartiallySubstituted());
    /*const*/type$ptr<TemplateArgument/*P*/> Args = $tryClone(this.<TemplateArgument>getTrailingObjects$Const(TemplateArgument.class));
    return llvm.makeArrayRef(Args, Args.$add(Length));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3752,
   FQN="clang::SizeOfPackExpr::getLocStart", NM="_ZNK5clang14SizeOfPackExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(OperatorLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3753,
   FQN="clang::SizeOfPackExpr::getLocEnd", NM="_ZNK5clang14SizeOfPackExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang14SizeOfPackExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3755,
   FQN="clang::SizeOfPackExpr::classof", NM="_ZN5clang14SizeOfPackExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.SizeOfPackExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::SizeOfPackExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3760,
   FQN="clang::SizeOfPackExpr::children", NM="_ZN5clang14SizeOfPackExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang14SizeOfPackExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert TemplateArgument.class == clazz;
    return 0;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OperatorLoc=" + OperatorLoc // NOI18N
              + ", PackLoc=" + PackLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", Length=" + Length // NOI18N
              + ", Pack=" + Pack // NOI18N
              + super.toString(); // NOI18N
  }
}
