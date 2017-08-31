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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.support.TrailingObjects.*;


/// \brief A C++ lambda expression, which produces a function object
/// (of unspecified type) that can be invoked later.
///
/// Example:
/// \code
/// void low_pass_filter(std::vector<double> &values, double cutoff) {
///   values.erase(std::remove_if(values.begin(), values.end(),
///                               [=](double value) { return value > cutoff; });
/// }
/// \endcode
///
/// C++11 lambda expressions can capture local variables, either by copying
/// the values of those local variables at the time the function
/// object is constructed (not when it is called!) or by holding a
/// reference to the local variable. These captures can occur either
/// implicitly or can be written explicitly between the square
/// brackets ([...]) that start the lambda expression.
///
/// C++1y introduces a new form of "capture" called an init-capture that
/// includes an initializing expression (rather than capturing a variable),
/// and which can never occur implicitly.
//<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1503,
 FQN="clang::LambdaExpr", NM="_ZN5clang10LambdaExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExprE")
//</editor-fold>
public final class LambdaExpr extends /*public*/ Expr implements /*private*/ TrailingObjects$T$UInt$T<LambdaExpr, Stmt /*P*/ , /*uint Integer,*/ VarDecl /*P*/ > {
  /// \brief The source range that covers the lambda introducer ([...]).
  /*friend*/public SourceRange IntroducerRange;
  
  /// \brief The source location of this lambda's capture-default ('=' or '&').
  /*friend*/public SourceLocation CaptureDefaultLoc;
  
  /// \brief The number of captures.
  /*friend*/public /*JCHAR unsigned int*/ char NumCaptures /*: 16*/;
  
  /// \brief The default capture kind, which is a value of type
  /// LambdaCaptureDefault.
  /*friend*/public /*JBYTE unsigned int*/ byte CaptureDefault /*: 2*/;
  
  /// \brief Whether this lambda had an explicit parameter list vs. an
  /// implicit (and empty) parameter list.
  /*friend*/public /*JBIT unsigned int*/ boolean ExplicitParams /*: 1*/;
  
  /// \brief Whether this lambda had the result type explicitly specified.
  /*friend*/public /*JBIT unsigned int*/ boolean ExplicitResultType /*: 1*/;
  
  /// \brief Whether there are any array index variables stored at the end of
  /// this lambda expression.
  /*friend*/public /*JBIT unsigned int*/ boolean HasArrayIndexVars /*: 1*/;
  
  /// \brief The location of the closing brace ('}') that completes
  /// the lambda.
  /// 
  /// The location of the brace is also available by looking up the
  /// function call operator in the lambda class. However, it is
  /// stored here to improve the performance of getSourceRange(), and
  /// to avoid having to deserialize the function call operator from a
  /// module file just to determine the source range.
  /*friend*/public SourceLocation ClosingBrace;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1540,
   FQN="clang::LambdaExpr::numTrailingObjects", NM="_ZNK5clang10LambdaExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_4StmtEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_4StmtEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$Stmt$P(OverloadToken<Stmt /*P*/ > $Prm0) /*const*/ {
    return NumCaptures + $int2uint_16bits(1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1544,
   FQN="clang::LambdaExpr::numTrailingObjects", NM="_ZNK5clang10LambdaExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIjEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadTokenUInt(OverloadTokenUInt $Prm0) /*const*/ {
    return HasArrayIndexVars ? NumCaptures + $int2uint_16bits(1) : 0;
  }

  
  /// \brief Construct a lambda expression.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::LambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 851,
   FQN="clang::LambdaExpr::LambdaExpr", NM="_ZN5clang10LambdaExprC1ENS_8QualTypeENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEN4llvm8ArrayRefINS_13LambdaCaptureEEEbbNS6_IPNS_4ExprEEENS6_IPNS_7VarDeclEEENS6_IjEES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExprC1ENS_8QualTypeENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEN4llvm8ArrayRefINS_13LambdaCaptureEEEbbNS6_IPNS_4ExprEEENS6_IPNS_7VarDeclEEENS6_IjEES4_b")
  //</editor-fold>
  private LambdaExpr(QualType T, SourceRange IntroducerRange, 
      LambdaCaptureDefault CaptureDefault, 
      SourceLocation CaptureDefaultLoc, 
      ArrayRef<LambdaCapture> Captures, boolean ExplicitParams, 
      boolean ExplicitResultType, ArrayRef<Expr /*P*/ > CaptureInits, 
      ArrayRef<VarDecl /*P*/ > ArrayIndexVars, 
      ArrayRefUInt ArrayIndexStarts, 
      SourceLocation ClosingBrace, 
      boolean ContainsUnexpandedParameterPack) {
    // : Expr(LambdaExprClass, T, VK_RValue, OK_Ordinary, T->isDependentType(), T->isDependentType(), T->isDependentType(), ContainsUnexpandedParameterPack), TrailingObjects<LambdaExpr, Stmt * , unsigned int, VarDecl * >(), IntroducerRange(IntroducerRange), CaptureDefaultLoc(CaptureDefaultLoc), NumCaptures(Captures.size()), CaptureDefault(CaptureDefault), ExplicitParams(ExplicitParams), ExplicitResultType(ExplicitResultType), ClosingBrace(ClosingBrace) 
    //START JInit
    super(StmtClass.LambdaExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, T.$arrow().isDependentType(), 
        T.$arrow().isDependentType(), T.$arrow().isDependentType(), 
        ContainsUnexpandedParameterPack);
    $TrailingObjects();
    this.IntroducerRange = new SourceRange(IntroducerRange);
    this.CaptureDefaultLoc = new SourceLocation(CaptureDefaultLoc);
    this.NumCaptures = $uint2uint_16bits(Captures.size());
    this.CaptureDefault = $uint2uint_2bits(CaptureDefault.getValue());
    this.ExplicitParams = ExplicitParams;
    this.ExplicitResultType = ExplicitResultType;
    this.ClosingBrace = new SourceLocation(ClosingBrace);
    //END JInit
    assert (CaptureInits.size() == Captures.size()) : "Wrong number of arguments";
    CXXRecordDecl /*P*/ Class = getLambdaClass();
    final CXXRecordDecl.LambdaDefinitionData /*&*/ Data = Class.getLambdaData();
    
    // FIXME: Propagate "has unexpanded parameter pack" bit.
    
    // Copy captures.
    final /*const*/ ASTContext /*&*/ Context = Class.getASTContext();
    Data.NumCaptures = $uint2uint_15bits(NumCaptures);
    Data.NumExplicitCaptures = $uint2uint_13bits(0);
    Data.Captures = create_const_type$ptr(new LambdaCapture[NumCaptures]);
    //TODO   = (type$ptr<LambdaCapture /*P*/>)Context.Allocate($sizeof_LambdaCapture() * NumCaptures);
    type$ptr<LambdaCapture /*P*/> ToCapture = $Clone(Data.Captures);
    for (/*uint*/int I = 0, N = Captures.size(); I != N; ++I) {
      if (Captures.$at(I).isExplicit()) {
        ++Data.NumExplicitCaptures;
      }
      
      ToCapture.star$ref().$set(Captures.$at(I)); ToCapture.$postInc();// /*Deref*/ToCapture++.$assign(Captures.$at(I));
    }
    
    // Copy initialization expressions for the non-static data members.
    type$ptr<Stmt /*P*/ /*P*/> Stored = $tryClone(getStoredStmts());
    for (/*uint*/int I = 0, N = CaptureInits.size(); I != N; ++I)  {
      Stored.$postInc().$set(CaptureInits.$at(I));
    }
    
    // Copy the body of the lambda.
    Stored.$postInc().$set(getCallOperator().getBody());
    
    // Copy the array index variables, if any.
    HasArrayIndexVars = !ArrayIndexVars.empty();
    if (HasArrayIndexVars) {
      // JAVA:
      assert (ArrayIndexStarts.size() == NumCaptures);
      memcpy(getArrayIndexVars(), ArrayIndexVars.data(), 
          (true/*JAVA:number of elements, not size in bytes*/ ? 1 : $sizeof_ptr(/*VarDecl  */)) * ArrayIndexVars.size(), true);
      memcpy(getArrayIndexStarts(), ArrayIndexStarts.data(), 
          /*JAVA: here we use $sizeof_UInt() to get number of bytes*/$sizeof_UInt() * Captures.size());
      getArrayIndexStarts().$set(Captures.size(), ArrayIndexVars.size());
    }
  }

  
  /// \brief Construct an empty lambda expression.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::LambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1558,
   FQN="clang::LambdaExpr::LambdaExpr", NM="_ZN5clang10LambdaExprC1ENS_4Stmt10EmptyShellEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExprC1ENS_4Stmt10EmptyShellEjb")
  //</editor-fold>
  private LambdaExpr(EmptyShell Empty, /*uint*/int NumCaptures, boolean HasArrayIndexVars) {
    // : Expr(LambdaExprClass, Empty), TrailingObjects<LambdaExpr, Stmt * , unsigned int, VarDecl * >(), IntroducerRange(), CaptureDefaultLoc(), NumCaptures(NumCaptures), CaptureDefault(LCD_None), ExplicitParams(false), ExplicitResultType(false), HasArrayIndexVars(true), ClosingBrace() 
    //START JInit
    super(StmtClass.LambdaExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.IntroducerRange = new SourceRange();
    this.CaptureDefaultLoc = new SourceLocation();
    this.NumCaptures = $uint2uint_16bits(NumCaptures);
    this.CaptureDefault = $uint2uint_2bits(LambdaCaptureDefault.LCD_None.getValue());
    this.ExplicitParams = false;
    this.ExplicitResultType = false;
    this.HasArrayIndexVars = true;
    this.ClosingBrace = new SourceLocation();
    //END JInit
    getStoredStmts().$set(NumCaptures, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getStoredStmts">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1565,
   FQN="clang::LambdaExpr::getStoredStmts", NM="_ZN5clang10LambdaExpr14getStoredStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr14getStoredStmtsEv")
  //</editor-fold>
  private type$ptr<Stmt /*P*/ /*P*/> getStoredStmts() {
    return this.<Stmt /*P*/ >getTrailingObjects(Stmt.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getStoredStmts">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1567,
   FQN="clang::LambdaExpr::getStoredStmts", NM="_ZNK5clang10LambdaExpr14getStoredStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr14getStoredStmtsEv")
  //</editor-fold>
  private type$ptr<Stmt /*P*/ /*const*/ /*P*/> getStoredStmts$Const() /*const*/ {
    return  this.<Stmt /*P*/ >getTrailingObjects$Const(Stmt.class);
  }

  
  /// \brief Retrieve the mapping from captures to the first array index
  /// variable.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getArrayIndexStarts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1571,
   FQN="clang::LambdaExpr::getArrayIndexStarts", NM="_ZN5clang10LambdaExpr19getArrayIndexStartsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr19getArrayIndexStartsEv")
  //</editor-fold>
  /*friend*/public uint$ptr/*uint P*/ getArrayIndexStarts() {
    return this.getTrailingObjects$Uint();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getArrayIndexStarts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1573,
   FQN="clang::LambdaExpr::getArrayIndexStarts", NM="_ZNK5clang10LambdaExpr19getArrayIndexStartsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr19getArrayIndexStartsEv")
  //</editor-fold>
  private /*const*/uint$ptr/*uint P*/ getArrayIndexStarts$Const() /*const*/ {
    return this.getTrailingObjects$Uint$Const();
  }

  
  /// \brief Retrieve the complete set of array-index variables.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getArrayIndexVars">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1578,
   FQN="clang::LambdaExpr::getArrayIndexVars", NM="_ZN5clang10LambdaExpr17getArrayIndexVarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr17getArrayIndexVarsEv")
  //</editor-fold>
  /*friend*/public type$ptr<VarDecl /*P*/ /*P*/> getArrayIndexVars() {
    return this.<VarDecl /*P*/ >getTrailingObjects(VarDecl.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getArrayIndexVars">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1580,
   FQN="clang::LambdaExpr::getArrayIndexVars", NM="_ZNK5clang10LambdaExpr17getArrayIndexVarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr17getArrayIndexVarsEv")
  //</editor-fold>
  private type$ptr<VarDecl /*P*/ /*const*/ /*P*/> getArrayIndexVars$Const() /*const*/ {
    return this.<VarDecl /*P*/ >getTrailingObjects$Const(VarDecl.class);
  }

/*public:*/
  /// \brief Construct a new lambda expression.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 907,
   FQN="clang::LambdaExpr::Create", NM="_ZN5clang10LambdaExpr6CreateERKNS_10ASTContextEPNS_13CXXRecordDeclENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEN4llvm8ArrayRefINS_13LambdaCaptureEEEbbNSA_IPNS_4ExprEEENSA_IPNS_7VarDeclEEENSA_IjEES8_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr6CreateERKNS_10ASTContextEPNS_13CXXRecordDeclENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEN4llvm8ArrayRefINS_13LambdaCaptureEEEbbNSA_IPNS_4ExprEEENSA_IPNS_7VarDeclEEENSA_IjEES8_b")
  //</editor-fold>
  public static LambdaExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, CXXRecordDecl /*P*/ Class, 
        SourceRange IntroducerRange, LambdaCaptureDefault CaptureDefault, 
        SourceLocation CaptureDefaultLoc, ArrayRef<LambdaCapture> Captures, 
        boolean ExplicitParams, boolean ExplicitResultType, ArrayRef<Expr /*P*/ > CaptureInits, 
        ArrayRef<VarDecl /*P*/ > ArrayIndexVars, ArrayRefUInt ArrayIndexStarts, 
        SourceLocation ClosingBrace, boolean ContainsUnexpandedParameterPack) {
    // Determine the type of the expression (i.e., the type of the
    // function object we're creating).
    QualType T = Context.getTypeDeclType(Class);
    
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(Stmt.class, int.class, VarDecl.class, Captures.size() + 1, ArrayIndexVars.empty() ? 0 : Captures.size() + 1, ArrayIndexVars.size());
    Object/*void P*/ _Mem = Context.Allocate$JavaRef(Size);
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new LambdaExpr(new QualType(T), new SourceRange(IntroducerRange), 
                CaptureDefault, new SourceLocation(CaptureDefaultLoc), new ArrayRef<LambdaCapture>(Captures), 
                ExplicitParams, ExplicitResultType, 
                new ArrayRef<Expr /*P*/ >(CaptureInits), new ArrayRef<VarDecl /*P*/ >(ArrayIndexVars), new ArrayRefUInt(ArrayIndexStarts), 
                new SourceLocation(ClosingBrace), ContainsUnexpandedParameterPack);
     });
  }

  
  /// \brief Construct a new lambda expression that will be deserialized from
  /// an external source.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 929,
   FQN="clang::LambdaExpr::CreateDeserialized", NM="_ZN5clang10LambdaExpr18CreateDeserializedERKNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr18CreateDeserializedERKNS_10ASTContextEjj")
  //</editor-fold>
  public static LambdaExpr /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ C, 
                    /*uint*/int NumCaptures, 
                    /*uint*/int NumArrayIndexVars) {
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(Stmt.class, int.class, VarDecl.class, NumCaptures + 1, (NumArrayIndexVars != 0) ? NumCaptures + 1 : 0, NumArrayIndexVars);
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size);
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new LambdaExpr(new EmptyShell(), NumCaptures, $greater_uint(NumArrayIndexVars, 0));
     });
  }

  
  /// \brief Determine the default capture kind for this lambda.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getCaptureDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1602,
   FQN="clang::LambdaExpr::getCaptureDefault", NM="_ZNK5clang10LambdaExpr17getCaptureDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr17getCaptureDefaultEv")
  //</editor-fold>
  public LambdaCaptureDefault getCaptureDefault() /*const*/ {
    return /*static_cast*/LambdaCaptureDefault.valueOf(CaptureDefault);
  }

  
  /// \brief Retrieve the location of this lambda's capture-default, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getCaptureDefaultLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1607,
   FQN="clang::LambdaExpr::getCaptureDefaultLoc", NM="_ZNK5clang10LambdaExpr20getCaptureDefaultLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr20getCaptureDefaultLocEv")
  //</editor-fold>
  public SourceLocation getCaptureDefaultLoc() /*const*/ {
    return new SourceLocation(CaptureDefaultLoc);
  }

  
  /// \brief Determine whether one of this lambda's captures is an init-capture.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::isInitCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 939,
   FQN="clang::LambdaExpr::isInitCapture", NM="_ZNK5clang10LambdaExpr13isInitCaptureEPKNS_13LambdaCaptureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr13isInitCaptureEPKNS_13LambdaCaptureE")
  //</editor-fold>
  public boolean isInitCapture(/*const*/ LambdaCapture /*P*/ C) /*const*/ {
    return (C.capturesVariable() && C.getCapturedVar().isInitCapture()
       && (getCallOperator() == C.getCapturedVar().getDeclContext()));
  }

  
  /// \brief An iterator that walks over the captures of the lambda,
  /// both implicit and explicit.
  /*typedef const LambdaCapture *capture_iterator*/
//  public final class capture_iterator extends /*const*/ LambdaCapture /*P*/ { };
  
  /// \brief An iterator over a range of lambda captures.
  /*typedef llvm::iterator_range<capture_iterator> capture_range*/
//  public final class capture_range extends iterator_range</*const*/ LambdaCapture>{ };
  
  /// \brief Retrieve this lambda's captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 952,
   FQN="clang::LambdaExpr::captures", NM="_ZNK5clang10LambdaExpr8capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr8capturesEv")
  //</editor-fold>
  public iterator_range</*const*/ LambdaCapture> captures() /*const*/ {
    return new iterator_range</*const*/ LambdaCapture>(capture_begin(), capture_end());
  }

  
  /// \brief Retrieve an iterator pointing to the first lambda capture.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 944,
   FQN="clang::LambdaExpr::capture_begin", NM="_ZNK5clang10LambdaExpr13capture_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr13capture_beginEv")
  //</editor-fold>
  public type$ptr<LambdaCapture> capture_begin() /*const*/ {
    return getLambdaClass().getLambdaData().Captures;
  }

  
  /// \brief Retrieve an iterator pointing past the end of the
  /// sequence of lambda captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 948,
   FQN="clang::LambdaExpr::capture_end", NM="_ZNK5clang10LambdaExpr11capture_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr11capture_endEv")
  //</editor-fold>
  public type$ptr<LambdaCapture> capture_end() /*const*/ {
    return capture_begin().$add(NumCaptures);
  }

  
  /// \brief Determine the number of captures in this lambda.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1632,
   FQN="clang::LambdaExpr::capture_size", NM="_ZNK5clang10LambdaExpr12capture_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr12capture_sizeEv")
  //</editor-fold>
  public /*uint*/int capture_size() /*const*/ {
    return NumCaptures;
  }

  
  /// \brief Retrieve this lambda's explicit captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::explicit_captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 966,
   FQN="clang::LambdaExpr::explicit_captures", NM="_ZNK5clang10LambdaExpr17explicit_capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr17explicit_capturesEv")
  //</editor-fold>
  public iterator_range</*const*/ LambdaCapture> explicit_captures() /*const*/ {
    return new iterator_range</*const*/ LambdaCapture>(explicit_capture_begin(), explicit_capture_end());
  }

  
  /// \brief Retrieve an iterator pointing to the first explicit
  /// lambda capture.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::explicit_capture_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 956,
   FQN="clang::LambdaExpr::explicit_capture_begin", NM="_ZNK5clang10LambdaExpr22explicit_capture_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr22explicit_capture_beginEv")
  //</editor-fold>
  public type$ptr<LambdaCapture> explicit_capture_begin() /*const*/ {
    return capture_begin();
  }

  
  /// \brief Retrieve an iterator pointing past the end of the sequence of
  /// explicit lambda captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::explicit_capture_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 960,
   FQN="clang::LambdaExpr::explicit_capture_end", NM="_ZNK5clang10LambdaExpr20explicit_capture_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr20explicit_capture_endEv")
  //</editor-fold>
  public type$ptr<LambdaCapture> explicit_capture_end() /*const*/ {
    final  CXXRecordDecl.LambdaDefinitionData /*&*/ Data = getLambdaClass().getLambdaData();
    return Data.Captures.$add(Data.NumExplicitCaptures);
  }

  
  /// \brief Retrieve this lambda's implicit captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::implicit_captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 978,
   FQN="clang::LambdaExpr::implicit_captures", NM="_ZNK5clang10LambdaExpr17implicit_capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr17implicit_capturesEv")
  //</editor-fold>
  public iterator_range</*const*/ LambdaCapture> implicit_captures() /*const*/ {
    return new iterator_range</*const*/ LambdaCapture>(implicit_capture_begin(), implicit_capture_end());
  }

  
  /// \brief Retrieve an iterator pointing to the first implicit
  /// lambda capture.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::implicit_capture_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 970,
   FQN="clang::LambdaExpr::implicit_capture_begin", NM="_ZNK5clang10LambdaExpr22implicit_capture_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr22implicit_capture_beginEv")
  //</editor-fold>
  public type$ptr<LambdaCapture> implicit_capture_begin() /*const*/ {
    return explicit_capture_end();
  }

  
  /// \brief Retrieve an iterator pointing past the end of the sequence of
  /// implicit lambda captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::implicit_capture_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 974,
   FQN="clang::LambdaExpr::implicit_capture_end", NM="_ZNK5clang10LambdaExpr20implicit_capture_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr20implicit_capture_endEv")
  //</editor-fold>
  public type$ptr<LambdaCapture> implicit_capture_end() /*const*/ {
    return capture_end();
  }

  
  /// \brief Iterator that walks over the capture initialization
  /// arguments.
  /*typedef Expr **capture_init_iterator*/
//  public final class capture_init_iterator extends type$ptr<Expr /*P*/ /*P*/>{ };
  
  /// \brief Const iterator that walks over the capture initialization
  /// arguments.
  /*typedef Expr *const *const_capture_init_iterator*/
//  public final class const_capture_init_iterator extends type$ptr<Expr /*P*/ /*const*/ /*P*/>{ };
  
  /// \brief Retrieve the initialization expressions for this lambda's captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1665,
   FQN="clang::LambdaExpr::capture_inits", NM="_ZN5clang10LambdaExpr13capture_initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr13capture_initsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > capture_inits() {
    return llvm.make_range(capture_init_begin(), capture_init_end());
  }

  
  /// \brief Retrieve the initialization expressions for this lambda's captures.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1670,
   FQN="clang::LambdaExpr::capture_inits", NM="_ZNK5clang10LambdaExpr13capture_initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr13capture_initsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ /*const*/> capture_inits$Const() /*const*/ {
    return llvm.make_range(capture_init_begin$Const(), capture_init_end$Const());
  }

  
  /// \brief Retrieve the first initialization argument for this
  /// lambda expression (which initializes the first capture field).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1676,
   FQN="clang::LambdaExpr::capture_init_begin", NM="_ZN5clang10LambdaExpr18capture_init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr18capture_init_beginEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> capture_init_begin() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getStoredStmts()));
  }

  
  /// \brief Retrieve the first initialization argument for this
  /// lambda expression (which initializes the first capture field).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1682,
   FQN="clang::LambdaExpr::capture_init_begin", NM="_ZNK5clang10LambdaExpr18capture_init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr18capture_init_beginEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*const*/ /*P*/> capture_init_begin$Const() /*const*/ {
    return ((type$ptr<Expr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, getStoredStmts$Const()));
  }

  
  /// \brief Retrieve the iterator pointing one past the last
  /// initialization argument for this lambda expression.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1688,
   FQN="clang::LambdaExpr::capture_init_end", NM="_ZN5clang10LambdaExpr16capture_init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr16capture_init_endEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> capture_init_end() {
    return capture_init_begin().$add(NumCaptures);
  }

  
  /// \brief Retrieve the iterator pointing one past the last
  /// initialization argument for this lambda expression.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::capture_init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1694,
   FQN="clang::LambdaExpr::capture_init_end", NM="_ZNK5clang10LambdaExpr16capture_init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr16capture_init_endEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*const*/ /*P*/> capture_init_end$Const() /*const*/ {
    return capture_init_begin$Const().$add(NumCaptures);
  }

  
  /// \brief Retrieve the set of index variables used in the capture
  /// initializer of an array captured by copy.
  ///
  /// \param Iter The iterator that points at the capture initializer for
  /// which we are extracting the corresponding index variables.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getCaptureInitIndexVars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 982,
   FQN="clang::LambdaExpr::getCaptureInitIndexVars", NM="_ZNK5clang10LambdaExpr23getCaptureInitIndexVarsEPKPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr23getCaptureInitIndexVarsEPKPNS_4ExprE")
  //</editor-fold>
  public ArrayRef<VarDecl /*P*/ > getCaptureInitIndexVars(type$ptr<Expr /*P*/ /*const*/ /*P*/> Iter) /*const*/ {
    assert (HasArrayIndexVars) : "No array index-var data?";
    
    /*uint*/int Index = Iter.$sub(capture_init_begin$Const());
    assert ($less_uint(Index, getLambdaClass().getLambdaData().NumCaptures)) : "Capture index out-of-range";
    type$ptr<VarDecl /*P*/ /*const*/ /*P*/> IndexVars = $tryClone(getArrayIndexVars$Const());
    /*const*/uint$ptr/*uint P*/ IndexStarts = $tryClone(getArrayIndexStarts$Const());
    return llvm.makeArrayRef(IndexVars.$add(IndexStarts.$at(Index)), 
        IndexVars.$add(IndexStarts.$at(Index + 1)));
  }

  
  /// \brief Retrieve the source range covering the lambda introducer,
  /// which contains the explicit capture list surrounded by square
  /// brackets ([...]).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getIntroducerRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1709,
   FQN="clang::LambdaExpr::getIntroducerRange", NM="_ZNK5clang10LambdaExpr18getIntroducerRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr18getIntroducerRangeEv")
  //</editor-fold>
  public SourceRange getIntroducerRange() /*const*/ {
    return new SourceRange(IntroducerRange);
  }

  
  /// \brief Retrieve the class that corresponds to the lambda.
  /// 
  /// This is the "closure type" (C++1y [expr.prim.lambda]), and stores the
  /// captures in its fields and provides the various operations permitted
  /// on a lambda (copying, calling).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getLambdaClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 995,
   FQN="clang::LambdaExpr::getLambdaClass", NM="_ZNK5clang10LambdaExpr14getLambdaClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr14getLambdaClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getLambdaClass() /*const*/ {
    return getType().$arrow().getAsCXXRecordDecl();
  }

  
  /// \brief Retrieve the function call operator associated with this
  /// lambda expression. 
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getCallOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 999,
   FQN="clang::LambdaExpr::getCallOperator", NM="_ZNK5clang10LambdaExpr15getCallOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr15getCallOperatorEv")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getCallOperator() /*const*/ {
    CXXRecordDecl /*P*/ Record = getLambdaClass();
    return Record.getLambdaCallOperator();
  }

  
  /// \brief If this is a generic lambda expression, retrieve the template 
  /// parameter list associated with it, or else return null. 
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1004,
   FQN="clang::LambdaExpr::getTemplateParameterList", NM="_ZNK5clang10LambdaExpr24getTemplateParameterListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr24getTemplateParameterListEv")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameterList() /*const*/ {
    CXXRecordDecl /*P*/ Record = getLambdaClass();
    return Record.getGenericLambdaTemplateParameterList();
  }

  
  /// \brief Whether this is a generic lambda.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::isGenericLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1727,
   FQN="clang::LambdaExpr::isGenericLambda", NM="_ZNK5clang10LambdaExpr15isGenericLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr15isGenericLambdaEv")
  //</editor-fold>
  public boolean isGenericLambda() /*const*/ {
    return (getTemplateParameterList() != null);
  }

  
  /// \brief Retrieve the body of the lambda.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getBody">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1010,
   FQN="clang::LambdaExpr::getBody", NM="_ZNK5clang10LambdaExpr7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr7getBodyEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getBody() /*const*/ {
    // FIXME: this mutation in getBody is bogus. It should be
    // initialized in ASTStmtReader::VisitLambdaExpr, but for reasons I
    // don't understand, that doesn't work.
    if (!(getStoredStmts$Const().$at(NumCaptures) != null)) {
      getStoredStmts$Const().$set(NumCaptures, //((/*const_cast*/type$ptr<Stmt /*P*/ /*P*/>)(getStoredStmts$Const().$set(NumCaptures))).$set(
        getCallOperator().getBody());
    }
    
    return ((/*static_cast*/CompoundStmt /*P*/ )(getStoredStmts$Const().$at(NumCaptures)));
  }

  
  /// \brief Determine whether the lambda is mutable, meaning that any
  /// captures values can be modified.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::isMutable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1021,
   FQN="clang::LambdaExpr::isMutable", NM="_ZNK5clang10LambdaExpr9isMutableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr9isMutableEv")
  //</editor-fold>
  public boolean isMutable() /*const*/ {
    return !getCallOperator().isConst();
  }

  
  /// \brief Determine whether this lambda has an explicit parameter
  /// list vs. an implicit (empty) parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::hasExplicitParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1738,
   FQN="clang::LambdaExpr::hasExplicitParameters", NM="_ZNK5clang10LambdaExpr21hasExplicitParametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr21hasExplicitParametersEv")
  //</editor-fold>
  public boolean hasExplicitParameters() /*const*/ {
    return ExplicitParams;
  }

  
  /// \brief Whether this lambda had its result type explicitly specified.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::hasExplicitResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1741,
   FQN="clang::LambdaExpr::hasExplicitResultType", NM="_ZNK5clang10LambdaExpr21hasExplicitResultTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr21hasExplicitResultTypeEv")
  //</editor-fold>
  public boolean hasExplicitResultType() /*const*/ {
    return ExplicitResultType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1743,
   FQN="clang::LambdaExpr::classof", NM="_ZN5clang10LambdaExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.LambdaExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1747,
   FQN="clang::LambdaExpr::getLocStart", NM="_ZNK5clang10LambdaExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return IntroducerRange.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1750,
   FQN="clang::LambdaExpr::getLocEnd", NM="_ZNK5clang10LambdaExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang10LambdaExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(ClosingBrace);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1752,
   FQN="clang::LambdaExpr::children", NM="_ZN5clang10LambdaExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang10LambdaExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    // Includes initialization exprs plus body stmt
    return new iterator_range<Stmt/*P*/>(new StmtIterator(getStoredStmts()), new StmtIterator(getStoredStmts().$add(NumCaptures).$add(1)));
  }

  
  /*friend  TrailingObjects<LambdaExpr, Stmt *, unsigned int, VarDecl *>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() {
    return numTrailingObjects_OverloadToken$Stmt$P((OverloadToken<Stmt /*P*/>)null); 
  }
  
  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { 
    return numTrailingObjects_OverloadTokenUInt((OverloadTokenUInt)null); 
  }
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    // Stmt /*P*/ , /*uint Integer,*/ VarDecl /*P*/ 
    assert clazz == Stmt.class
            || clazz == int.class
            || clazz == VarDecl.class;
    if (clazz == Stmt.class) {
      return 0;
    } else if (clazz == int.class) {
      return getNumTailingObject_OverloadToken$TrailingTy1();
    }
    return getNumTailingObject_OverloadToken$TrailingTy1() + getNumTailingObject_OverloadToken$TrailingTy2();
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "IntroducerRange=" + IntroducerRange // NOI18N
              + ", CaptureDefaultLoc=" + CaptureDefaultLoc // NOI18N
              + ", NumCaptures=" + $ushort2uint(NumCaptures) // NOI18N
              + ", CaptureDefault=" + $uchar2uint(CaptureDefault) // NOI18N
              + ", ExplicitParams=" + ExplicitParams // NOI18N
              + ", ExplicitResultType=" + ExplicitResultType // NOI18N
              + ", HasArrayIndexVars=" + HasArrayIndexVars // NOI18N
              + ", ClosingBrace=" + ClosingBrace // NOI18N
              + super.toString(); // NOI18N
  }
}
