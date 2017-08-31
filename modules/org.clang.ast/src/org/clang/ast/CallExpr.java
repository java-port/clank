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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// CallExpr - Represents a function call (C99 6.5.2.2, C++ [expr.call]).
/// CallExpr itself represents a normal function call, e.g., "f(x, 2)",
/// while its subclasses may represent alternative syntax that (semantically)
/// results in a function call. For example, CXXOperatorCallExpr is
/// a subclass for overloaded operator calls that use operator syntax, e.g.,
/// "str1 + str2" to resolve to a function call.
//<editor-fold defaultstate="collapsed" desc="clang::CallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2148,
 FQN="clang::CallExpr", NM="_ZN5clang8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprE")
//</editor-fold>
public class CallExpr extends /*public*/ Expr {
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2149,
   FQN="clang::CallExpr::(anonymous)", NM="_ZN5clang8CallExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    FN(0),
    PREARGS_START(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  private type$ptr<Stmt /*P*/ /*P*/> SubExprs;
  private /*uint*/int NumArgs;
  private SourceLocation RParenLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::updateDependenciesFromArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1174,
   FQN="clang::CallExpr::updateDependenciesFromArg", NM="_ZN5clang8CallExpr25updateDependenciesFromArgEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr25updateDependenciesFromArgEPNS_4ExprE")
  //</editor-fold>
  private void updateDependenciesFromArg(Expr /*P*/ Arg) {
    if (Arg.isTypeDependent()) {
      Unnamed_field.ExprBits.TypeDependent = true;
    }
    if (Arg.isValueDependent()) {
      Unnamed_field.ExprBits.ValueDependent = true;
    }
    if (Arg.isInstantiationDependent()) {
      Unnamed_field.ExprBits.InstantiationDependent = true;
    }
    if (Arg.containsUnexpandedParameterPack()) {
      Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
    }
  }

/*protected:*/
  // These versions of the constructor are for derived classes.
  
  //===----------------------------------------------------------------------===//
  // Postfix Operators.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::CallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1129,
   FQN="clang::CallExpr::CallExpr", NM="_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassEPNS_4ExprEN4llvm8ArrayRefIS7_EESA_NS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassEPNS_4ExprEN4llvm8ArrayRefIS7_EESA_NS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE")
  //</editor-fold>
  protected CallExpr(final /*const*/ ASTContext /*&*/ C, StmtClass SC, Expr /*P*/ fn, 
      ArrayRef<Expr /*P*/ > preargs, ArrayRef<Expr /*P*/ > args, QualType t, 
      ExprValueKind VK, SourceLocation rparenloc) {
    // : Expr(SC, t, VK, OK_Ordinary, fn->isTypeDependent(), fn->isValueDependent(), fn->isInstantiationDependent(), fn->containsUnexpandedParameterPack()), NumArgs(args.size()), RParenLoc() 
    //START JInit
    super(SC, new QualType(t), VK, ExprObjectKind.OK_Ordinary, fn.isTypeDependent(), 
        fn.isValueDependent(), fn.isInstantiationDependent(), 
        fn.containsUnexpandedParameterPack());
    this.NumArgs = args.size();
    this.RParenLoc = new SourceLocation();
    //END JInit
    
    /*uint*/int NumPreArgs = preargs.size();
    SubExprs = create_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [args.size() + Unnamed_enum.PREARGS_START.getValue() + NumPreArgs]);
    SubExprs.$set(Unnamed_enum.FN.getValue(), fn);
    for (/*uint*/int i = 0; i != NumPreArgs; ++i) {
      updateDependenciesFromArg(preargs.$at(i));
      SubExprs.$set(i + Unnamed_enum.PREARGS_START.getValue(), preargs.$at(i));
    }
    for (/*uint*/int i = 0; i != args.size(); ++i) {
      updateDependenciesFromArg(args.$at(i));
      SubExprs.$set(i + Unnamed_enum.PREARGS_START.getValue() + NumPreArgs, args.$at(i));
    }
    
    Unnamed_field.CallExprBits.NumPreArgs = $uint2uint_1bit(NumPreArgs);
    RParenLoc.$assign(rparenloc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::CallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1153,
   FQN="clang::CallExpr::CallExpr", NM="_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassEPNS_4ExprEN4llvm8ArrayRefIS7_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassEPNS_4ExprEN4llvm8ArrayRefIS7_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE")
  //</editor-fold>
  protected CallExpr(final /*const*/ ASTContext /*&*/ C, StmtClass SC, Expr /*P*/ fn, 
      ArrayRef<Expr /*P*/ > args, QualType t, ExprValueKind VK, 
      SourceLocation rparenloc) {
    // : CallExpr(C, SC, fn, ArrayRef<Expr * >(), args, t, VK, rparenloc) 
    //START JInit
    this(C, SC, fn, new ArrayRef<Expr /*P*/ >(true), new ArrayRef<Expr /*P*/ >(args), new QualType(t), VK, new SourceLocation(rparenloc));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::CallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1166,
   FQN="clang::CallExpr::CallExpr", NM="_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassEjNS4_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassEjNS4_10EmptyShellE")
  //</editor-fold>
  protected CallExpr(final /*const*/ ASTContext /*&*/ C, StmtClass SC, /*uint*/int NumPreArgs, 
      EmptyShell Empty) {
    // : Expr(SC, Empty), SubExprs(null), NumArgs(0), RParenLoc() 
    //START JInit
    super(SC, new EmptyShell(Empty));
    this.SubExprs = null;
    this.NumArgs = 0;
    this.RParenLoc = new SourceLocation();
    //END JInit
    // FIXME: Why do we allocate this?
    SubExprs = create_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [Unnamed_enum.PREARGS_START.getValue() + NumPreArgs]);//(/*implicit-init*/((Stmt /*P*/ )/*zero-init*/null)));
    Unnamed_field.CallExprBits.NumPreArgs = $uint2uint_1bit(NumPreArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getPreArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2166,
   FQN="clang::CallExpr::getPreArg", NM="_ZN5clang8CallExpr9getPreArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr9getPreArgEj")
  //</editor-fold>
  protected Stmt /*P*/ getPreArg(/*uint*/int i) {
    assert ($less_uint(i, getNumPreArgs())) : "Prearg access out of range!";
    return SubExprs.$at(Unnamed_enum.PREARGS_START.getValue() + i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getPreArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2170,
   FQN="clang::CallExpr::getPreArg", NM="_ZNK5clang8CallExpr9getPreArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr9getPreArgEj")
  //</editor-fold>
  protected /*const*/ Stmt /*P*/ getPreArg$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumPreArgs())) : "Prearg access out of range!";
    return SubExprs.$at(Unnamed_enum.PREARGS_START.getValue() + i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::setPreArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2174,
   FQN="clang::CallExpr::setPreArg", NM="_ZN5clang8CallExpr9setPreArgEjPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr9setPreArgEjPNS_4StmtE")
  //</editor-fold>
  protected void setPreArg(/*uint*/int i, Stmt /*P*/ PreArg) {
    assert ($less_uint(i, getNumPreArgs())) : "Prearg access out of range!";
    SubExprs.$set(Unnamed_enum.PREARGS_START.getValue() + i, PreArg);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getNumPreArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2179,
   FQN="clang::CallExpr::getNumPreArgs", NM="_ZNK5clang8CallExpr13getNumPreArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr13getNumPreArgsEv")
  //</editor-fold>
  protected /*uint*/int getNumPreArgs() /*const*/ {
    return $bool2uint(Unnamed_field.CallExprBits.NumPreArgs);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::CallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1158,
   FQN="clang::CallExpr::CallExpr", NM="_ZN5clang8CallExprC1ERKNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS5_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprC1ERKNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS5_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE")
  //</editor-fold>
  public CallExpr(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ fn, ArrayRef<Expr /*P*/ > args, 
      QualType t, ExprValueKind VK, SourceLocation rparenloc) {
    // : CallExpr(C, CallExprClass, fn, ArrayRef<Expr * >(), args, t, VK, rparenloc) 
    //START JInit
    this(C, StmtClass.CallExprClass, fn, new ArrayRef<Expr /*P*/ >(true), new ArrayRef<Expr /*P*/ >(args), new QualType(t), VK, new SourceLocation(rparenloc));
    //END JInit
  }

  
  /// \brief Build an empty call expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::CallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1163,
   FQN="clang::CallExpr::CallExpr", NM="_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassENS4_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassENS4_10EmptyShellE")
  //</editor-fold>
  public CallExpr(final /*const*/ ASTContext /*&*/ C, StmtClass SC, EmptyShell Empty) {
    // : CallExpr(C, SC, /*NumPreArgs=*/ 0, Empty) 
    //START JInit
    this(C, SC, 0, new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2188,
   FQN="clang::CallExpr::getCallee", NM="_ZNK5clang8CallExpr9getCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr9getCalleeEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCallee$Const() /*const*/ {
    return cast_Expr(SubExprs.$at(Unnamed_enum.FN.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2189,
   FQN="clang::CallExpr::getCallee", NM="_ZN5clang8CallExpr9getCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr9getCalleeEv")
  //</editor-fold>
  public Expr /*P*/ getCallee() {
    return cast_Expr(SubExprs.$at(Unnamed_enum.FN.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::setCallee">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2190,
   FQN="clang::CallExpr::setCallee", NM="_ZN5clang8CallExpr9setCalleeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr9setCalleeEPNS_4ExprE")
  //</editor-fold>
  public void setCallee(Expr /*P*/ F) {
    SubExprs.$set(Unnamed_enum.FN.getValue(), F);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getCalleeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1185,
   FQN="clang::CallExpr::getCalleeDecl", NM="_ZN5clang8CallExpr13getCalleeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr13getCalleeDeclEv")
  //</editor-fold>
  public Decl /*P*/ getCalleeDecl() {
    Expr /*P*/ CEE = getCallee().IgnoreParenImpCasts();
    {
      
      SubstNonTypeTemplateParmExpr /*P*/ NTTP;
      while (((/*P*/ NTTP = dyn_cast_SubstNonTypeTemplateParmExpr(CEE)) != null)) {
        CEE = NTTP.getReplacement().IgnoreParenCasts();
      }
    }
    {
      
      // If we're calling a dereference, look at the pointer instead.
      BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(CEE);
      if ((BO != null)) {
        if (BO.isPtrMemOp()) {
          CEE = BO.getRHS().IgnoreParenCasts();
        }
      } else {
        UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(CEE);
        if ((UO != null)) {
          if (UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
            CEE = UO.getSubExpr().IgnoreParenCasts();
          }
        }
      }
    }
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CEE);
      if ((DRE != null)) {
        return DRE.getDecl();
      }
    }
    {
      MemberExpr /*P*/ ME = dyn_cast_MemberExpr(CEE);
      if ((ME != null)) {
        return ME.getMemberDecl();
      }
    }
    
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getCalleeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2193,
   FQN="clang::CallExpr::getCalleeDecl", NM="_ZNK5clang8CallExpr13getCalleeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr13getCalleeDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getCalleeDecl$Const() /*const*/ {
    return ((/*const_cast*/CallExpr /*P*/ )(this)).getCalleeDecl();
  }

  
  /// \brief If the callee is a FunctionDecl, return it. Otherwise return 0.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getDirectCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1209,
   FQN="clang::CallExpr::getDirectCallee", NM="_ZN5clang8CallExpr15getDirectCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr15getDirectCalleeEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getDirectCallee() {
    return dyn_cast_or_null_FunctionDecl(getCalleeDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getDirectCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2199,
   FQN="clang::CallExpr::getDirectCallee", NM="_ZNK5clang8CallExpr15getDirectCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr15getDirectCalleeEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getDirectCallee$Const() /*const*/ {
    return ((/*const_cast*/CallExpr /*P*/ )(this)).getDirectCallee();
  }

  
  /// getNumArgs - Return the number of actual arguments to this call.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2205,
   FQN="clang::CallExpr::getNumArgs", NM="_ZNK5clang8CallExpr10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArgs;
  }

  
  /// \brief Retrieve the call arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2208,
   FQN="clang::CallExpr::getArgs", NM="_ZN5clang8CallExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr7getArgsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getArgs() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, SubExprs.$add(getNumPreArgs()).$add(Unnamed_enum.PREARGS_START.getValue())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2211,
   FQN="clang::CallExpr::getArgs", NM="_ZNK5clang8CallExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr7getArgsEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> getArgs$Const() /*const*/ {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, SubExprs.$add(getNumPreArgs()).$add(Unnamed_enum.PREARGS_START.getValue())));
  }

  
  /// getArg - Return the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2217,
   FQN="clang::CallExpr::getArg", NM="_ZN5clang8CallExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr6getArgEj")
  //</editor-fold>
  public Expr /*P*/ getArg(/*uint*/int Arg) {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return cast_or_null_Expr(SubExprs.$at(Arg + getNumPreArgs() + Unnamed_enum.PREARGS_START.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2221,
   FQN="clang::CallExpr::getArg", NM="_ZNK5clang8CallExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr6getArgEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArg$Const(/*uint*/int Arg) /*const*/ {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return cast_or_null_Expr(SubExprs.$at(Arg + getNumPreArgs() + Unnamed_enum.PREARGS_START.getValue()));
  }

  
  /// setArg - Set the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::setArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2227,
   FQN="clang::CallExpr::setArg", NM="_ZN5clang8CallExpr6setArgEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr6setArgEjPNS_4ExprE")
  //</editor-fold>
  public void setArg(/*uint*/int Arg, Expr /*P*/ ArgExpr) {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    SubExprs.$set(Arg + getNumPreArgs() + Unnamed_enum.PREARGS_START.getValue(), ArgExpr);
  }

  
  /// setNumArgs - This changes the number of arguments present in this call.
  /// Any orphaned expressions are deleted by this, and any new operands are set
  /// to null.
  
  /// setNumArgs - This changes the number of arguments present in this call.
  /// Any orphaned expressions are deleted by this, and any new operands are set
  /// to null.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::setNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1216,
   FQN="clang::CallExpr::setNumArgs", NM="_ZN5clang8CallExpr10setNumArgsERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr10setNumArgsERKNS_10ASTContextEj")
  //</editor-fold>
  public void setNumArgs(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumArgs) {
    // No change, just return.
    if (NumArgs == getNumArgs()) {
      return;
    }
    
    // If shrinking # arguments, just delete the extras and forgot them.
    if ($less_uint(NumArgs, getNumArgs())) {
      this.NumArgs = NumArgs;
      return;
    }
    
    // Otherwise, we are growing the # arguments.  New an bigger argument array.
    /*uint*/int NumPreArgs = getNumPreArgs();
    type$ptr<Stmt /*P*/ /*P*/> NewSubExprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [NumArgs + Unnamed_enum.PREARGS_START.getValue() + NumPreArgs]);
    // Copy over args.
    for (/*uint*/int i = 0; i != getNumArgs() + Unnamed_enum.PREARGS_START.getValue() + NumPreArgs; ++i)  {
      NewSubExprs.$set(i, SubExprs.$at(i));
    }
    // Null out new args.
    for (/*uint*/int i = getNumArgs() + Unnamed_enum.PREARGS_START.getValue() + NumPreArgs;
         i != NumArgs + Unnamed_enum.PREARGS_START.getValue() + NumPreArgs; ++i)  {
      NewSubExprs.$set(i, null);
    }
    if (Native.$bool(SubExprs)) {
      C.Deallocate(SubExprs);
    }
    SubExprs = $tryClone(NewSubExprs);
    this.NumArgs = NumArgs;
  }

  
  /*typedef ExprIterator arg_iterator*/
//  public final class arg_iterator extends ExprIterator{ };
  /*typedef ConstExprIterator const_arg_iterator*/
//  public final class const_arg_iterator extends ConstExprIterator{ };
  /*typedef llvm::iterator_range<arg_iterator> arg_range*/
//  public final class arg_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<const_arg_iterator> arg_const_range*/
//  public final class arg_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2242,
   FQN="clang::CallExpr::arguments", NM="_ZN5clang8CallExpr9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr9argumentsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > arguments() {
    return new iterator_range<Expr /*P*/ >(arg_begin(), arg_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2243,
   FQN="clang::CallExpr::arguments", NM="_ZNK5clang8CallExpr9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr9argumentsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> arguments$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(arg_begin$Const(), arg_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2247,
   FQN="clang::CallExpr::arg_begin", NM="_ZN5clang8CallExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr9arg_beginEv")
  //</editor-fold>
  public ExprIterator arg_begin() {
    return new ExprIterator(SubExprs.$add(Unnamed_enum.PREARGS_START.getValue()).$add(getNumPreArgs()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2248,
   FQN="clang::CallExpr::arg_end", NM="_ZN5clang8CallExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr7arg_endEv")
  //</editor-fold>
  public ExprIterator arg_end() {
    return new ExprIterator(SubExprs.$add(Unnamed_enum.PREARGS_START.getValue()).$add(getNumPreArgs()).$add(getNumArgs()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2251,
   FQN="clang::CallExpr::arg_begin", NM="_ZNK5clang8CallExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr9arg_beginEv")
  //</editor-fold>
  public ConstExprIterator arg_begin$Const() /*const*/ {
    return new ConstExprIterator(SubExprs.$add(Unnamed_enum.PREARGS_START.getValue()).$add(getNumPreArgs()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2254,
   FQN="clang::CallExpr::arg_end", NM="_ZNK5clang8CallExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr7arg_endEv")
  //</editor-fold>
  public ConstExprIterator arg_end$Const() /*const*/ {
    return new ConstExprIterator(SubExprs.$add(Unnamed_enum.PREARGS_START.getValue()).$add(getNumPreArgs()).$add(getNumArgs()));
  }

  
  /// This method provides fast access to all the subexpressions of
  /// a CallExpr without going through the slower virtual child_iterator
  /// interface.  This provides efficient reverse iteration of the
  /// subexpressions.  This is currently used for CFG construction.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getRawSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2262,
   FQN="clang::CallExpr::getRawSubExprs", NM="_ZN5clang8CallExpr14getRawSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr14getRawSubExprsEv")
  //</editor-fold>
  public ArrayRef<Stmt /*P*/ > getRawSubExprs() {
    return llvm.makeArrayRef(SubExprs, 
        getNumPreArgs() + Unnamed_enum.PREARGS_START.getValue() + getNumArgs());
  }

  
  /// getNumCommas - Return the number of commas that must have been present in
  /// this function call.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getNumCommas">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2269,
   FQN="clang::CallExpr::getNumCommas", NM="_ZNK5clang8CallExpr12getNumCommasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr12getNumCommasEv")
  //</editor-fold>
  public /*uint*/int getNumCommas() /*const*/ {
    return (NumArgs != 0) ? NumArgs - 1 : 0;
  }

  
  /// getBuiltinCallee - If this is a call to a builtin, return the builtin ID
  /// of the callee. If not, return 0.
  
  /// getBuiltinCallee - If this is a call to a builtin, return the builtin ID. If
  /// not, return 0.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getBuiltinCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1244,
   FQN="clang::CallExpr::getBuiltinCallee", NM="_ZNK5clang8CallExpr16getBuiltinCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr16getBuiltinCalleeEv")
  //</editor-fold>
  public /*uint*/int getBuiltinCallee() /*const*/ {
    // All simple function calls (e.g. func()) are implicitly cast to pointer to
    // function. As a result, we try and obtain the DeclRefExpr from the
    // ImplicitCastExpr.
    /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(getCallee$Const());
    if (!(ICE != null)) { // FIXME: deal with more complex calls (e.g. (func)(), (*func)()).
      return 0;
    }
    
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(ICE.getSubExpr$Const());
    if (!(DRE != null)) {
      return 0;
    }
    
    /*const*/ FunctionDecl /*P*/ FDecl = dyn_cast_FunctionDecl(DRE.getDecl$Const());
    if (!(FDecl != null)) {
      return 0;
    }
    if (!(FDecl.getIdentifier() != null)) {
      return 0;
    }
    
    return FDecl.getBuiltinID();
  }

  
  /// \brief Returns \c true if this is a call to a builtin which does not
  /// evaluate side-effects within its arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::isUnevaluatedBuiltinCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1266,
   FQN="clang::CallExpr::isUnevaluatedBuiltinCall", NM="_ZNK5clang8CallExpr24isUnevaluatedBuiltinCallERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr24isUnevaluatedBuiltinCallERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isUnevaluatedBuiltinCall(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    {
      /*uint*/int BI = getBuiltinCallee();
      if ((BI != 0)) {
        return Ctx.BuiltinInfo.isUnevaluated(BI);
      }
    }
    return false;
  }

  
  /// getCallReturnType - Get the return type of the call expr. This is not
  /// always the type of the expr itself, if the return type is a reference
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getCallReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1272,
   FQN="clang::CallExpr::getCallReturnType", NM="_ZNK5clang8CallExpr17getCallReturnTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr17getCallReturnTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType getCallReturnType(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    /*const*/ Expr /*P*/ Callee = getCallee$Const();
    QualType CalleeType = Callee.getType();
    {
      /*const*/ PointerType /*P*/ FnTypePtr = CalleeType.$arrow().getAs(PointerType.class);
      if ((FnTypePtr != null)) {
        CalleeType.$assignMove(FnTypePtr.getPointeeType());
      } else {
        /*const*/ BlockPointerType /*P*/ BPT = CalleeType.$arrow().getAs(BlockPointerType.class);
        if ((BPT != null)) {
          CalleeType.$assignMove(BPT.getPointeeType());
        } else if (CalleeType.$arrow().isSpecificPlaceholderType(BuiltinType.Kind.BoundMember.getValue())) {
          if (isa_CXXPseudoDestructorExpr(Callee.IgnoreParens$Const())) {
            return Ctx.VoidTy.$QualType();
          }
          
          // This should never be overloaded and so should never return null.
          CalleeType.$assignMove(Expr.findBoundMemberType(Callee));
        }
      }
    }
    
    /*const*/ FunctionType /*P*/ FnType = CalleeType.$arrow().castAs(FunctionType.class);
    return FnType.getReturnType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2284,
   FQN="clang::CallExpr::getRParenLoc", NM="_ZNK5clang8CallExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2285,
   FQN="clang::CallExpr::setRParenLoc", NM="_ZN5clang8CallExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1291,
   FQN="clang::CallExpr::getLocStart", NM="_ZNK5clang8CallExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    if (isa_CXXOperatorCallExpr(this)) {
      return cast_CXXOperatorCallExpr(this).getLocStart();
    }
    
    SourceLocation begin = getCallee$Const().getLocStart();
    if (begin.isInvalid() && $greater_uint(getNumArgs(), 0) && (getArg$Const(0) != null)) {
      begin.$assignMove(getArg$Const(0).getLocStart());
    }
    return begin;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1300,
   FQN="clang::CallExpr::getLocEnd", NM="_ZNK5clang8CallExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CallExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (isa_CXXOperatorCallExpr(this)) {
      return cast_CXXOperatorCallExpr(this).getLocEnd();
    }
    
    SourceLocation end = getRParenLoc();
    if (end.isInvalid() && $greater_uint(getNumArgs(), 0) && (getArg$Const(getNumArgs() - 1) != null)) {
      end.$assignMove(getArg$Const(getNumArgs() - 1).getLocEnd());
    }
    return end;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2290,
   FQN="clang::CallExpr::classof", NM="_ZN5clang8CallExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass().getValue() >= StmtClass.firstCallExprConstant.getValue()
       && T.getStmtClass().getValue() <= StmtClass.lastCallExprConstant.getValue();
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CallExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2296,
   FQN="clang::CallExpr::children", NM="_ZN5clang8CallExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CallExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(SubExprs/*.$set$addr(0)*/), 
        new StmtIterator(SubExprs/*.$set$addr(0)*/.$add(NumArgs).$add(getNumPreArgs()).$add(Unnamed_enum.PREARGS_START.getValue())));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
