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
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// ImplicitCastExpr - Allows us to explicitly represent implicit type
/// conversions, which have no direct representation in the original
/// source code. For example: converting T[]->T*, void f()->void
/// (*f)(), float->double, short->int, etc.
///
/// In C, implicit casts always produce rvalues. However, in C++, an
/// implicit cast whose result is being bound to a reference will be
/// an lvalue or xvalue. For example:
///
/// @code
/// class Base { };
/// class Derived : public Base { };
/// Derived &&ref();
/// void f(Derived d) {
///   Base& b = d; // initializer is an ImplicitCastExpr
///                // to an lvalue of type Base
///   Base&& r = ref(); // initializer is an ImplicitCastExpr
///                     // to an xvalue of type Base
/// }
/// @endcode
//<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2734,
 FQN="clang::ImplicitCastExpr", NM="_ZN5clang16ImplicitCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExprE")
//</editor-fold>
public final class ImplicitCastExpr extends /*public*/ CastExpr implements /*private*/ TrailingObjects<ImplicitCastExpr, CXXBaseSpecifier /*P*/ > {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::ImplicitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2738,
   FQN="clang::ImplicitCastExpr::ImplicitCastExpr", NM="_ZN5clang16ImplicitCastExprC1ENS_8QualTypeENS_8CastKindEPNS_4ExprEjNS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExprC1ENS_8QualTypeENS_8CastKindEPNS_4ExprEjNS_13ExprValueKindE")
  //</editor-fold>
  private ImplicitCastExpr(QualType ty, CastKind kind, Expr /*P*/ op, 
      /*uint*/int BasePathLength, ExprValueKind VK) {
    // : CastExpr(ImplicitCastExprClass, ty, VK, kind, op, BasePathLength), TrailingObjects<ImplicitCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.ImplicitCastExprClass, new QualType(ty), VK, kind, op, BasePathLength);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Construct an empty implicit cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::ImplicitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2744,
   FQN="clang::ImplicitCastExpr::ImplicitCastExpr", NM="_ZN5clang16ImplicitCastExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private /*explicit*/ ImplicitCastExpr(EmptyShell Shell, /*uint*/int PathSize) {
    // : CastExpr(ImplicitCastExprClass, Shell, PathSize), TrailingObjects<ImplicitCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.ImplicitCastExprClass, new EmptyShell(Shell), PathSize);
    $TrailingObjects();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::OnStack_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2748,
   FQN="clang::ImplicitCastExpr::OnStack_t", NM="_ZN5clang16ImplicitCastExpr9OnStack_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExpr9OnStack_tE")
  //</editor-fold>
  public enum OnStack_t implements Native.ComparableLower {
    OnStack(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OnStack_t valueOf(int val) {
      OnStack_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OnStack_t[] VALUES;
      private static final OnStack_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OnStack_t kind : OnStack_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OnStack_t[min < 0 ? (1-min) : 0];
        VALUES = new OnStack_t[max >= 0 ? (1+max) : 0];
        for (OnStack_t kind : OnStack_t.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private OnStack_t(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OnStack_t)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OnStack_t)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::ImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2749,
   FQN="clang::ImplicitCastExpr::ImplicitCastExpr", NM="_ZN5clang16ImplicitCastExprC1ENS0_9OnStack_tENS_8QualTypeENS_8CastKindEPNS_4ExprENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExprC1ENS0_9OnStack_tENS_8QualTypeENS_8CastKindEPNS_4ExprENS_13ExprValueKindE")
  //</editor-fold>
  public ImplicitCastExpr(OnStack_t _, QualType ty, CastKind kind, Expr /*P*/ op, 
      ExprValueKind VK) {
    // : CastExpr(ImplicitCastExprClass, ty, VK, kind, op, 0), TrailingObjects<ImplicitCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.ImplicitCastExprClass, new QualType(ty), VK, kind, op, 0);
    $TrailingObjects();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1652,
   FQN="clang::ImplicitCastExpr::Create", NM="_ZN5clang16ImplicitCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS_13ExprValueKindE")
  //</editor-fold>
  public static ImplicitCastExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, 
        CastKind Kind, Expr /*P*/ Operand, 
        /*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath, 
        ExprValueKind VK) {
    /*uint*/int PathSize = ((BasePath != null) ? BasePath.size() : 0);
    Object/*void P*/ Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    ImplicitCastExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> New$Mem)->{
        return new ImplicitCastExpr(new QualType(T), Kind, Operand, PathSize, VK);
     });
    if ((PathSize != 0)) {
      std.uninitialized_copy_n(BasePath.data$Const(), BasePath.size(), 
          E.getTrailingObjects(CXXBaseSpecifier /*P*/.class));
    }
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1666,
   FQN="clang::ImplicitCastExpr::CreateEmpty", NM="_ZN5clang16ImplicitCastExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static ImplicitCastExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int PathSize) {
    Object/*void P*/ Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    return /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new ImplicitCastExpr(new EmptyShell(), PathSize);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2762,
   FQN="clang::ImplicitCastExpr::getLocStart", NM="_ZNK5clang16ImplicitCastExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16ImplicitCastExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getSubExpr$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2765,
   FQN="clang::ImplicitCastExpr::getLocEnd", NM="_ZNK5clang16ImplicitCastExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16ImplicitCastExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getSubExpr$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2769,
   FQN="clang::ImplicitCastExpr::classof", NM="_ZN5clang16ImplicitCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ImplicitCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ImplicitCastExprClass;
  }

  
  /*friend  TrailingObjects<ImplicitCastExpr, CXXBaseSpecifier *>*/
  /*friend  class CastExpr*/
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == CXXBaseSpecifier.class;
    return 0;
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
