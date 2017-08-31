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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents binding an expression to a temporary.
///
/// This ensures the destructor is called for the temporary. It should only be
/// needed for non-POD, non-trivially destructable class types. For example:
///
/// \code
///   struct S {
///     S() { }  // User defined constructor makes S non-POD.
///     ~S() { } // User defined destructor makes it non-trivial.
///   };
///   void test() {
///     const S &s_ref = S(); // Requires a CXXBindTemporaryExpr.
///   }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1119,
 FQN="clang::CXXBindTemporaryExpr", NM="_ZN5clang20CXXBindTemporaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExprE")
//</editor-fold>
public class CXXBindTemporaryExpr extends /*public*/ Expr {
  private CXXTemporary /*P*/ Temp;
  
  private Stmt /*P*/ SubExpr;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::CXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1124,
   FQN="clang::CXXBindTemporaryExpr::CXXBindTemporaryExpr", NM="_ZN5clang20CXXBindTemporaryExprC1EPNS_12CXXTemporaryEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExprC1EPNS_12CXXTemporaryEPNS_4ExprE")
  //</editor-fold>
  private CXXBindTemporaryExpr(CXXTemporary /*P*/ temp, Expr /*P*/ SubExpr) {
    // : Expr(CXXBindTemporaryExprClass, SubExpr->getType(), VK_RValue, OK_Ordinary, SubExpr->isTypeDependent(), SubExpr->isValueDependent(), SubExpr->isInstantiationDependent(), SubExpr->containsUnexpandedParameterPack()), Temp(temp), SubExpr(SubExpr) 
    //START JInit
    super(StmtClass.CXXBindTemporaryExprClass, SubExpr.getType(), 
        ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, SubExpr.isTypeDependent(), 
        SubExpr.isValueDependent(), 
        SubExpr.isInstantiationDependent(), 
        SubExpr.containsUnexpandedParameterPack());
    this.Temp = temp;
    this.SubExpr = SubExpr;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::CXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1133,
   FQN="clang::CXXBindTemporaryExpr::CXXBindTemporaryExpr", NM="_ZN5clang20CXXBindTemporaryExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXBindTemporaryExpr(EmptyShell Empty) {
    // : Expr(CXXBindTemporaryExprClass, Empty), Temp(null), SubExpr(null) 
    //START JInit
    super(StmtClass.CXXBindTemporaryExprClass, new EmptyShell(Empty));
    this.Temp = null;
    this.SubExpr = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 709,
   FQN="clang::CXXBindTemporaryExpr::Create", NM="_ZN5clang20CXXBindTemporaryExpr6CreateERKNS_10ASTContextEPNS_12CXXTemporaryEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr6CreateERKNS_10ASTContextEPNS_12CXXTemporaryEPNS_4ExprE")
  //</editor-fold>
  public static CXXBindTemporaryExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        CXXTemporary /*P*/ Temp, 
        Expr /*P*/ SubExpr) {
    assert ((SubExpr.getType().$arrow().isRecordType() || SubExpr.getType().$arrow().isArrayType())) : "Expression bound to a temporary must have record or array type!";
    
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new CXXBindTemporaryExpr(Temp, SubExpr);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1139,
   FQN="clang::CXXBindTemporaryExpr::getTemporary", NM="_ZN5clang20CXXBindTemporaryExpr12getTemporaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr12getTemporaryEv")
  //</editor-fold>
  public CXXTemporary /*P*/ getTemporary() {
    return Temp;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1140,
   FQN="clang::CXXBindTemporaryExpr::getTemporary", NM="_ZNK5clang20CXXBindTemporaryExpr12getTemporaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20CXXBindTemporaryExpr12getTemporaryEv")
  //</editor-fold>
  public /*const*/ CXXTemporary /*P*/ getTemporary$Const() /*const*/ {
    return Temp;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::setTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1141,
   FQN="clang::CXXBindTemporaryExpr::setTemporary", NM="_ZN5clang20CXXBindTemporaryExpr12setTemporaryEPNS_12CXXTemporaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr12setTemporaryEPNS_12CXXTemporaryE")
  //</editor-fold>
  public void setTemporary(CXXTemporary /*P*/ T) {
    Temp = T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1143,
   FQN="clang::CXXBindTemporaryExpr::getSubExpr", NM="_ZNK5clang20CXXBindTemporaryExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20CXXBindTemporaryExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(SubExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1144,
   FQN="clang::CXXBindTemporaryExpr::getSubExpr", NM="_ZN5clang20CXXBindTemporaryExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(SubExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::setSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1145,
   FQN="clang::CXXBindTemporaryExpr::setSubExpr", NM="_ZN5clang20CXXBindTemporaryExpr10setSubExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr10setSubExprEPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(Expr /*P*/ E) {
    SubExpr = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1147,
   FQN="clang::CXXBindTemporaryExpr::getLocStart", NM="_ZNK5clang20CXXBindTemporaryExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20CXXBindTemporaryExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1150,
   FQN="clang::CXXBindTemporaryExpr::getLocEnd", NM="_ZNK5clang20CXXBindTemporaryExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20CXXBindTemporaryExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getLocEnd();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1153,
   FQN="clang::CXXBindTemporaryExpr::classof", NM="_ZN5clang20CXXBindTemporaryExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXBindTemporaryExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBindTemporaryExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1158,
   FQN="clang::CXXBindTemporaryExpr::children", NM="_ZN5clang20CXXBindTemporaryExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20CXXBindTemporaryExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    type$ptr<Stmt/*P*/> $SubExprPtr = create_type$ptr(new Stmt[]{SubExpr});
    return new iterator_range<Stmt/*P*/>(new StmtIterator($SubExprPtr), new StmtIterator($SubExprPtr.$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Temp=" + Temp // NOI18N
              + ", SubExpr=" + SubExpr // NOI18N
              + super.toString(); // NOI18N
  }
}
