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
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// ObjCBoxedExpr - used for generalized expression boxing.
/// as in: @(strdup("hello world")), @(random()) or @(view.frame)
/// Also used for boxing non-parenthesized numeric literals;
/// as in: @42 or \@true (c++/objc++) or \@__yes (c/objc).
//<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 94,
 FQN="clang::ObjCBoxedExpr", NM="_ZN5clang13ObjCBoxedExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang13ObjCBoxedExprE")
//</editor-fold>
public class ObjCBoxedExpr extends /*public*/ Expr {
  /*friend*/public Stmt /*P*/ SubExpr;
  /*friend*/public ObjCMethodDecl /*P*/ BoxingMethod;
  /*friend*/public SourceRange Range;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::ObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 99,
   FQN="clang::ObjCBoxedExpr::ObjCBoxedExpr", NM="_ZN5clang13ObjCBoxedExprC1EPNS_4ExprENS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang13ObjCBoxedExprC1EPNS_4ExprENS_8QualTypeEPNS_14ObjCMethodDeclENS_11SourceRangeE")
  //</editor-fold>
  public ObjCBoxedExpr(Expr /*P*/ E, QualType T, ObjCMethodDecl /*P*/ method, 
      SourceRange R) {
    // : Expr(ObjCBoxedExprClass, T, VK_RValue, OK_Ordinary, E->isTypeDependent(), E->isValueDependent(), E->isInstantiationDependent(), E->containsUnexpandedParameterPack()), SubExpr(E), BoxingMethod(method), Range(R) 
    //START JInit
    super(StmtClass.ObjCBoxedExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        E.isTypeDependent(), E.isValueDependent(), 
        E.isInstantiationDependent(), E.containsUnexpandedParameterPack());
    this.SubExpr = E;
    this.BoxingMethod = method;
    this.Range = new SourceRange(R);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::ObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 105,
   FQN="clang::ObjCBoxedExpr::ObjCBoxedExpr", NM="_ZN5clang13ObjCBoxedExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang13ObjCBoxedExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCBoxedExpr(EmptyShell Empty) {
    // : Expr(ObjCBoxedExprClass, Empty), Range() 
    //START JInit
    super(StmtClass.ObjCBoxedExprClass, new EmptyShell(Empty));
    this.Range = new SourceRange();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 108,
   FQN="clang::ObjCBoxedExpr::getSubExpr", NM="_ZN5clang13ObjCBoxedExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang13ObjCBoxedExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(SubExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 109,
   FQN="clang::ObjCBoxedExpr::getSubExpr", NM="_ZNK5clang13ObjCBoxedExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(SubExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getBoxingMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 111,
   FQN="clang::ObjCBoxedExpr::getBoxingMethod", NM="_ZNK5clang13ObjCBoxedExpr15getBoxingMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr15getBoxingMethodEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getBoxingMethod() /*const*/ {
    return BoxingMethod;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 115,
   FQN="clang::ObjCBoxedExpr::getAtLoc", NM="_ZNK5clang13ObjCBoxedExpr8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return Range.getBegin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 117,
   FQN="clang::ObjCBoxedExpr::getLocStart", NM="_ZNK5clang13ObjCBoxedExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 118,
   FQN="clang::ObjCBoxedExpr::getLocEnd", NM="_ZNK5clang13ObjCBoxedExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 119,
   FQN="clang::ObjCBoxedExpr::getSourceRange", NM="_ZNK5clang13ObjCBoxedExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 123,
   FQN="clang::ObjCBoxedExpr::classof", NM="_ZN5clang13ObjCBoxedExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang13ObjCBoxedExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCBoxedExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 128,
   FQN="clang::ObjCBoxedExpr::children", NM="_ZN5clang13ObjCBoxedExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang13ObjCBoxedExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubExpr))), new StmtIterator(create_type$ptr($AddrOf(SubExpr)).$add(1)));
  }

  
  /*typedef ConstExprIterator const_arg_iterator*/
//  public final class const_arg_iterator extends ConstExprIterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 132,
   FQN="clang::ObjCBoxedExpr::arg_begin", NM="_ZNK5clang13ObjCBoxedExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr9arg_beginEv")
  //</editor-fold>
  public ConstExprIterator arg_begin() /*const*/ {
    return new ConstExprIterator(((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(SubExpr))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoxedExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 135,
   FQN="clang::ObjCBoxedExpr::arg_end", NM="_ZNK5clang13ObjCBoxedExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang13ObjCBoxedExpr7arg_endEv")
  //</editor-fold>
  public ConstExprIterator arg_end() /*const*/ {
    return new ConstExprIterator(((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, create_type$ptr($AddrOf(SubExpr)).$add(1))));
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "SubExpr=" + SubExpr // NOI18N
              + ", BoxingMethod=" + BoxingMethod // NOI18N
              + ", Range=" + Range // NOI18N
              + super.toString(); // NOI18N
  }
}
