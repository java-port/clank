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
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// BlockExpr - Adaptor class for mixing a BlockDecl with expressions.
/// ^{ statement-body }   or   ^(int arg1, float arg2){ statement-body }
//<editor-fold defaultstate="collapsed" desc="clang::BlockExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4567,
 FQN="clang::BlockExpr", NM="_ZN5clang9BlockExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExprE")
//</editor-fold>
public class BlockExpr extends /*public*/ Expr {
/*protected:*/
  protected BlockDecl /*P*/ TheBlock;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::BlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4571,
   FQN="clang::BlockExpr::BlockExpr", NM="_ZN5clang9BlockExprC1EPNS_9BlockDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExprC1EPNS_9BlockDeclENS_8QualTypeE")
  //</editor-fold>
  public BlockExpr(BlockDecl /*P*/ BD, QualType ty) {
    // : Expr(BlockExprClass, ty, VK_RValue, OK_Ordinary, ty->isDependentType(), ty->isDependentType(), ty->isInstantiationDependentType() || BD->isDependentContext(), false), TheBlock(BD) 
    //START JInit
    super(StmtClass.BlockExprClass, new QualType(ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        ty.$arrow().isDependentType(), ty.$arrow().isDependentType(), 
        ty.$arrow().isInstantiationDependentType() || BD.isDependentContext(), 
        false);
    this.TheBlock = BD;
    //END JInit
  }

  
  /// \brief Build an empty block expression.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::BlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4579,
   FQN="clang::BlockExpr::BlockExpr", NM="_ZN5clang9BlockExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ BlockExpr(EmptyShell Empty) {
    // : Expr(BlockExprClass, Empty) 
    //START JInit
    super(StmtClass.BlockExprClass, new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4581,
   FQN="clang::BlockExpr::getBlockDecl", NM="_ZNK5clang9BlockExpr12getBlockDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9BlockExpr12getBlockDeclEv")
  //</editor-fold>
  public /*const*/ BlockDecl /*P*/ getBlockDecl$Const() /*const*/ {
    return TheBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4582,
   FQN="clang::BlockExpr::getBlockDecl", NM="_ZN5clang9BlockExpr12getBlockDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExpr12getBlockDeclEv")
  //</editor-fold>
  public BlockDecl /*P*/ getBlockDecl() {
    return TheBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::setBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4583,
   FQN="clang::BlockExpr::setBlockDecl", NM="_ZN5clang9BlockExpr12setBlockDeclEPNS_9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExpr12setBlockDeclEPNS_9BlockDeclE")
  //</editor-fold>
  public void setBlockDecl(BlockDecl /*P*/ BD) {
    TheBlock = BD;
  }

  
  // Convenience functions for probing the underlying BlockDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getCaretLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1877,
   FQN="clang::BlockExpr::getCaretLocation", NM="_ZNK5clang9BlockExpr16getCaretLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9BlockExpr16getCaretLocationEv")
  //</editor-fold>
  public SourceLocation getCaretLocation() /*const*/ {
    return TheBlock.getCaretLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1880,
   FQN="clang::BlockExpr::getBody", NM="_ZNK5clang9BlockExpr7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9BlockExpr7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return TheBlock.getBody();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1883,
   FQN="clang::BlockExpr::getBody", NM="_ZN5clang9BlockExpr7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExpr7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return TheBlock.getBody();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4590,
   FQN="clang::BlockExpr::getLocStart", NM="_ZNK5clang9BlockExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9BlockExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getCaretLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4591,
   FQN="clang::BlockExpr::getLocEnd", NM="_ZNK5clang9BlockExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9BlockExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getBody$Const().getLocEnd();
  }

  
  /// getFunctionType - Return the underlying function type for this block.
  
  /// getFunctionType - Return the underlying function type for this block.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::getFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1871,
   FQN="clang::BlockExpr::getFunctionType", NM="_ZNK5clang9BlockExpr15getFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9BlockExpr15getFunctionTypeEv")
  //</editor-fold>
  public /*const*/ FunctionProtoType /*P*/ getFunctionType() /*const*/ {
    // The block pointer is never sugared, but the function type might be.
    return cast_BlockPointerType(getType()).
    getPointeeType().$arrow().castAs(FunctionProtoType.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4596,
   FQN="clang::BlockExpr::classof", NM="_ZN5clang9BlockExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.BlockExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::BlockExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4601,
   FQN="clang::BlockExpr::children", NM="_ZN5clang9BlockExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9BlockExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "TheBlock=" + TheBlock // NOI18N
              + super.toString(); // NOI18N
  }
}
