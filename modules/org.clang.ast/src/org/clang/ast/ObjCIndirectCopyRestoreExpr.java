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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// ObjCIndirectCopyRestoreExpr - Represents the passing of a function
/// argument by indirect copy-restore in ARC.  This is used to support
/// passing indirect arguments with the wrong lifetime, e.g. when
/// passing the address of a __strong local variable to an 'out'
/// parameter.  This expression kind is only valid in an "argument"
/// position to some sort of call expression.
///
/// The parameter must have type 'pointer to T', and the argument must
/// have type 'pointer to U', where T and U agree except possibly in
/// qualification.  If the argument value is null, then a null pointer
/// is passed;  otherwise it points to an object A, and:
/// 1. A temporary object B of type T is initialized, either by
///    zero-initialization (used when initializing an 'out' parameter)
///    or copy-initialization (used when initializing an 'inout'
///    parameter).
/// 2. The address of the temporary is passed to the function.
/// 3. If the call completes normally, A is move-assigned from B.
/// 4. Finally, A is destroyed immediately.
///
/// Currently 'T' must be a retainable object lifetime and must be
/// __autoreleasing;  this qualifier is ignored when initializing
/// the value.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1464,
 FQN="clang::ObjCIndirectCopyRestoreExpr", NM="_ZN5clang27ObjCIndirectCopyRestoreExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExprE")
//</editor-fold>
public class ObjCIndirectCopyRestoreExpr extends /*public*/ Expr {
  /*friend*/public Stmt /*P*/ Operand;
  
  // unsigned ObjCIndirectCopyRestoreBits.ShouldCopy : 1;
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::setShouldCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1472,
   FQN="clang::ObjCIndirectCopyRestoreExpr::setShouldCopy", NM="_ZN5clang27ObjCIndirectCopyRestoreExpr13setShouldCopyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExpr13setShouldCopyEb")
  //</editor-fold>
  /*friend*/public void setShouldCopy(boolean shouldCopy) {
    Unnamed_field.ObjCIndirectCopyRestoreExprBits.ShouldCopy = shouldCopy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::ObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1476,
   FQN="clang::ObjCIndirectCopyRestoreExpr::ObjCIndirectCopyRestoreExpr", NM="_ZN5clang27ObjCIndirectCopyRestoreExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ ObjCIndirectCopyRestoreExpr(EmptyShell Empty) {
    // : Expr(ObjCIndirectCopyRestoreExprClass, Empty) 
    //START JInit
    super(StmtClass.ObjCIndirectCopyRestoreExprClass, new EmptyShell(Empty));
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::ObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1480,
   FQN="clang::ObjCIndirectCopyRestoreExpr::ObjCIndirectCopyRestoreExpr", NM="_ZN5clang27ObjCIndirectCopyRestoreExprC1EPNS_4ExprENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExprC1EPNS_4ExprENS_8QualTypeEb")
  //</editor-fold>
  public ObjCIndirectCopyRestoreExpr(Expr /*P*/ operand, QualType type, boolean shouldCopy) {
    // : Expr(ObjCIndirectCopyRestoreExprClass, type, VK_LValue, OK_Ordinary, operand->isTypeDependent(), operand->isValueDependent(), operand->isInstantiationDependent(), operand->containsUnexpandedParameterPack()), Operand(operand) 
    //START JInit
    super(StmtClass.ObjCIndirectCopyRestoreExprClass, new QualType(type), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        operand.isTypeDependent(), operand.isValueDependent(), 
        operand.isInstantiationDependent(), 
        operand.containsUnexpandedParameterPack());
    this.Operand = operand;
    //END JInit
    setShouldCopy(shouldCopy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1489,
   FQN="clang::ObjCIndirectCopyRestoreExpr::getSubExpr", NM="_ZN5clang27ObjCIndirectCopyRestoreExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(Operand);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1490,
   FQN="clang::ObjCIndirectCopyRestoreExpr::getSubExpr", NM="_ZNK5clang27ObjCIndirectCopyRestoreExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang27ObjCIndirectCopyRestoreExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(Operand);
  }

  
  /// shouldCopy - True if we should do the 'copy' part of the
  /// copy-restore.  If false, the temporary will be zero-initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::shouldCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1494,
   FQN="clang::ObjCIndirectCopyRestoreExpr::shouldCopy", NM="_ZNK5clang27ObjCIndirectCopyRestoreExpr10shouldCopyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang27ObjCIndirectCopyRestoreExpr10shouldCopyEv")
  //</editor-fold>
  public boolean shouldCopy() /*const*/ {
    return Unnamed_field.ObjCIndirectCopyRestoreExprBits.ShouldCopy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1496,
   FQN="clang::ObjCIndirectCopyRestoreExpr::children", NM="_ZN5clang27ObjCIndirectCopyRestoreExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Operand))), new StmtIterator(create_type$ptr($AddrOf(Operand)).$add(1)));
  }

  
  // Source locations are determined by the subexpression.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1499,
   FQN="clang::ObjCIndirectCopyRestoreExpr::getLocStart", NM="_ZNK5clang27ObjCIndirectCopyRestoreExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang27ObjCIndirectCopyRestoreExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Operand.getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1502,
   FQN="clang::ObjCIndirectCopyRestoreExpr::getLocEnd", NM="_ZNK5clang27ObjCIndirectCopyRestoreExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang27ObjCIndirectCopyRestoreExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Operand.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1504,
   FQN="clang::ObjCIndirectCopyRestoreExpr::getExprLoc", NM="_ZNK5clang27ObjCIndirectCopyRestoreExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang27ObjCIndirectCopyRestoreExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return getSubExpr$Const().getExprLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIndirectCopyRestoreExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1508,
   FQN="clang::ObjCIndirectCopyRestoreExpr::classof", NM="_ZN5clang27ObjCIndirectCopyRestoreExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang27ObjCIndirectCopyRestoreExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ s) {
    return s.getStmtClass() == StmtClass.ObjCIndirectCopyRestoreExprClass;
  }

  
  @Override public String toString() {
    return "" + "Operand=" + Operand // NOI18N
              + super.toString(); // NOI18N
  }
}
