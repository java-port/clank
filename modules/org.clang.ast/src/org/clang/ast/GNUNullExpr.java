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


/// GNUNullExpr - Implements the GNU __null extension, which is a name
/// for a null pointer constant that has integral type (e.g., int or
/// long) and is the same size and alignment as a pointer. The __null
/// extension is typically only used by system headers, which define
/// NULL as __null in C++ rather than using 0 (which is an integer
/// that may not match the size of a pointer).
//<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3624,
 FQN="clang::GNUNullExpr", NM="_ZN5clang11GNUNullExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11GNUNullExprE")
//</editor-fold>
public class GNUNullExpr extends /*public*/ Expr {
  /// TokenLoc - The location of the __null keyword.
  private SourceLocation TokenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::GNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3629,
   FQN="clang::GNUNullExpr::GNUNullExpr", NM="_ZN5clang11GNUNullExprC1ENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11GNUNullExprC1ENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public GNUNullExpr(QualType Ty, SourceLocation Loc) {
    // : Expr(GNUNullExprClass, Ty, VK_RValue, OK_Ordinary, false, false, false, false), TokenLoc(Loc) 
    //START JInit
    super(StmtClass.GNUNullExprClass, new QualType(Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, false, 
        false);
    this.TokenLoc = new SourceLocation(Loc);
    //END JInit
  }

  
  /// \brief Build an empty GNU __null expression.
  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::GNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3635,
   FQN="clang::GNUNullExpr::GNUNullExpr", NM="_ZN5clang11GNUNullExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11GNUNullExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ GNUNullExpr(EmptyShell Empty) {
    // : Expr(GNUNullExprClass, Empty), TokenLoc() 
    //START JInit
    super(StmtClass.GNUNullExprClass, new EmptyShell(Empty));
    this.TokenLoc = new SourceLocation();
    //END JInit
  }

  
  /// getTokenLocation - The location of the __null token.
  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::getTokenLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3638,
   FQN="clang::GNUNullExpr::getTokenLocation", NM="_ZNK5clang11GNUNullExpr16getTokenLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11GNUNullExpr16getTokenLocationEv")
  //</editor-fold>
  public SourceLocation getTokenLocation() /*const*/ {
    return new SourceLocation(TokenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::setTokenLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3639,
   FQN="clang::GNUNullExpr::setTokenLocation", NM="_ZN5clang11GNUNullExpr16setTokenLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11GNUNullExpr16setTokenLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setTokenLocation(SourceLocation L) {
    TokenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3641,
   FQN="clang::GNUNullExpr::getLocStart", NM="_ZNK5clang11GNUNullExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11GNUNullExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(TokenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3642,
   FQN="clang::GNUNullExpr::getLocEnd", NM="_ZNK5clang11GNUNullExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11GNUNullExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(TokenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3644,
   FQN="clang::GNUNullExpr::classof", NM="_ZN5clang11GNUNullExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11GNUNullExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.GNUNullExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::GNUNullExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3649,
   FQN="clang::GNUNullExpr::children", NM="_ZN5clang11GNUNullExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11GNUNullExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "TokenLoc=" + TokenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
