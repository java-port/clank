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
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief A call to a literal operator (C++11 [over.literal])
/// written as a user-defined literal (C++11 [lit.ext]).
///
/// Represents a user-defined literal, e.g. "foo"_bar or 1.23_xyz. While this
/// is semantically equivalent to a normal call, this AST node provides better
/// information about the syntactic representation of the literal.
///
/// Since literal operators are never found by ADL and can only be declared at
/// namespace scope, a user-defined literal is never dependent.
//<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 409,
 FQN="clang::UserDefinedLiteral", NM="_ZN5clang18UserDefinedLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18UserDefinedLiteralE")
//</editor-fold>
public class UserDefinedLiteral extends /*public*/ CallExpr {
  /// \brief The location of a ud-suffix within the literal.
  /*friend*/public SourceLocation UDSuffixLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::UserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 414,
   FQN="clang::UserDefinedLiteral::UserDefinedLiteral", NM="_ZN5clang18UserDefinedLiteralC1ERKNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS5_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18UserDefinedLiteralC1ERKNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS5_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationESB_")
  //</editor-fold>
  public UserDefinedLiteral(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ Fn, ArrayRef<Expr /*P*/ > Args, 
      QualType T, ExprValueKind VK, SourceLocation LitEndLoc, 
      SourceLocation SuffixLoc) {
    // : CallExpr(C, UserDefinedLiteralClass, Fn, Args, T, VK, LitEndLoc), UDSuffixLoc(SuffixLoc) 
    //START JInit
    super(C, StmtClass.UserDefinedLiteralClass, Fn, new ArrayRef<Expr /*P*/ >(Args), new QualType(T), VK, new SourceLocation(LitEndLoc));
    this.UDSuffixLoc = new SourceLocation(SuffixLoc);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::UserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 419,
   FQN="clang::UserDefinedLiteral::UserDefinedLiteral", NM="_ZN5clang18UserDefinedLiteralC1ERKNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18UserDefinedLiteralC1ERKNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ UserDefinedLiteral(final /*const*/ ASTContext /*&*/ C, EmptyShell Empty) {
    // : CallExpr(C, UserDefinedLiteralClass, Empty), UDSuffixLoc() 
    //START JInit
    super(C, StmtClass.UserDefinedLiteralClass, new EmptyShell(Empty));
    this.UDSuffixLoc = new SourceLocation();
    //END JInit
  }

  
  /// The kind of literal operator which is invoked.
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::LiteralOperatorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 423,
   FQN="clang::UserDefinedLiteral::LiteralOperatorKind", NM="_ZN5clang18UserDefinedLiteral19LiteralOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18UserDefinedLiteral19LiteralOperatorKindE")
  //</editor-fold>
  public enum LiteralOperatorKind implements Native.ComparableLower {
    LOK_Raw(0), ///< Raw form: operator "" X (const char *)
    LOK_Template(LOK_Raw.getValue() + 1), ///< Raw form: operator "" X<cs...> ()
    LOK_Integer(LOK_Template.getValue() + 1), ///< operator "" X (unsigned long long)
    LOK_Floating(LOK_Integer.getValue() + 1), ///< operator "" X (long double)
    LOK_String(LOK_Floating.getValue() + 1), ///< operator "" X (const CharT *, size_t)
    LOK_Character(LOK_String.getValue() + 1); ///< operator "" X (CharT)

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LiteralOperatorKind valueOf(int val) {
      LiteralOperatorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LiteralOperatorKind[] VALUES;
      private static final LiteralOperatorKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LiteralOperatorKind kind : LiteralOperatorKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LiteralOperatorKind[min < 0 ? (1-min) : 0];
        VALUES = new LiteralOperatorKind[max >= 0 ? (1+max) : 0];
        for (LiteralOperatorKind kind : LiteralOperatorKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LiteralOperatorKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LiteralOperatorKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LiteralOperatorKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Returns the kind of literal operator invocation
  /// which this expression represents.
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getLiteralOperatorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 659,
   FQN="clang::UserDefinedLiteral::getLiteralOperatorKind", NM="_ZNK5clang18UserDefinedLiteral22getLiteralOperatorKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18UserDefinedLiteral22getLiteralOperatorKindEv")
  //</editor-fold>
  public UserDefinedLiteral.LiteralOperatorKind getLiteralOperatorKind() /*const*/ {
    if (getNumArgs() == 0) {
      return LiteralOperatorKind.LOK_Template;
    }
    if (getNumArgs() == 2) {
      return LiteralOperatorKind.LOK_String;
    }
    assert (getNumArgs() == 1) : "unexpected #args in literal operator call";
    QualType ParamTy = cast_FunctionDecl(getCalleeDecl$Const()).getParamDecl$Const(0).getType();
    if (ParamTy.$arrow().isPointerType()) {
      return LiteralOperatorKind.LOK_Raw;
    }
    if (ParamTy.$arrow().isAnyCharacterType()) {
      return LiteralOperatorKind.LOK_Character;
    }
    if (ParamTy.$arrow().isIntegerType()) {
      return LiteralOperatorKind.LOK_Integer;
    }
    if (ParamTy.$arrow().isFloatingType()) {
      return LiteralOperatorKind.LOK_Floating;
    }
    throw new llvm_unreachable("unknown kind of literal operator");
  }

  
  /// \brief If this is not a raw user-defined literal, get the
  /// underlying cooked literal (representing the literal with the suffix
  /// removed).
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getCookedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 681,
   FQN="clang::UserDefinedLiteral::getCookedLiteral", NM="_ZN5clang18UserDefinedLiteral16getCookedLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18UserDefinedLiteral16getCookedLiteralEv")
  //</editor-fold>
  public Expr /*P*/ getCookedLiteral() {
    LiteralOperatorKind LOK = getLiteralOperatorKind();
    assert (LOK != LiteralOperatorKind.LOK_Template && LOK != LiteralOperatorKind.LOK_Raw) : "not a cooked literal";
    return getArg(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getCookedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 440,
   FQN="clang::UserDefinedLiteral::getCookedLiteral", NM="_ZNK5clang18UserDefinedLiteral16getCookedLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18UserDefinedLiteral16getCookedLiteralEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCookedLiteral$Const() /*const*/ {
    return ((/*const_cast*/UserDefinedLiteral /*P*/ )(this)).getCookedLiteral();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 444,
   FQN="clang::UserDefinedLiteral::getLocStart", NM="_ZNK5clang18UserDefinedLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18UserDefinedLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*/ {
    if (getLiteralOperatorKind() == LiteralOperatorKind.LOK_Template) {
      return getRParenLoc();
    }
    return getArg$Const(0).getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 449,
   FQN="clang::UserDefinedLiteral::getLocEnd", NM="_ZNK5clang18UserDefinedLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18UserDefinedLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*/ {
    return getRParenLoc();
  }

  
  /// \brief Returns the location of a ud-suffix in the expression.
  ///
  /// For a string literal, there may be multiple identical suffixes. This
  /// returns the first.
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getUDSuffixLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 456,
   FQN="clang::UserDefinedLiteral::getUDSuffixLoc", NM="_ZNK5clang18UserDefinedLiteral14getUDSuffixLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18UserDefinedLiteral14getUDSuffixLocEv")
  //</editor-fold>
  public SourceLocation getUDSuffixLoc() /*const*/ {
    return new SourceLocation(UDSuffixLoc);
  }

  
  /// \brief Returns the ud-suffix specified for this literal.
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::getUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 689,
   FQN="clang::UserDefinedLiteral::getUDSuffix", NM="_ZNK5clang18UserDefinedLiteral11getUDSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18UserDefinedLiteral11getUDSuffixEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getUDSuffix() /*const*/ {
    return cast_FunctionDecl(getCalleeDecl$Const()).getLiteralIdentifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UserDefinedLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 461,
   FQN="clang::UserDefinedLiteral::classof", NM="_ZN5clang18UserDefinedLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18UserDefinedLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ S) {
    return S.getStmtClass() == StmtClass.UserDefinedLiteralClass;
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  @Override public String toString() {
    return "" + "UDSuffixLoc=" + UDSuffixLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
