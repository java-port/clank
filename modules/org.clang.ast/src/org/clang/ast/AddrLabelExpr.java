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


/// AddrLabelExpr - The GNU address of label extension, representing &&label.
//<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3339,
 FQN="clang::AddrLabelExpr", NM="_ZN5clang13AddrLabelExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExprE")
//</editor-fold>
public class AddrLabelExpr extends /*public*/ Expr {
  private SourceLocation AmpAmpLoc;
  private SourceLocation LabelLoc;
  private LabelDecl /*P*/ Label;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::AddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3343,
   FQN="clang::AddrLabelExpr::AddrLabelExpr", NM="_ZN5clang13AddrLabelExprC1ENS_14SourceLocationES1_PNS_9LabelDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExprC1ENS_14SourceLocationES1_PNS_9LabelDeclENS_8QualTypeE")
  //</editor-fold>
  public AddrLabelExpr(SourceLocation AALoc, SourceLocation LLoc, LabelDecl /*P*/ L, 
      QualType t) {
    // : Expr(AddrLabelExprClass, t, VK_RValue, OK_Ordinary, false, false, false, false), AmpAmpLoc(AALoc), LabelLoc(LLoc), Label(L) 
    //START JInit
    super(StmtClass.AddrLabelExprClass, new QualType(t), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, false, 
        false);
    this.AmpAmpLoc = new SourceLocation(AALoc);
    this.LabelLoc = new SourceLocation(LLoc);
    this.Label = L;
    //END JInit
  }

  
  /// \brief Build an empty address of a label expression.
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::AddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3350,
   FQN="clang::AddrLabelExpr::AddrLabelExpr", NM="_ZN5clang13AddrLabelExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ AddrLabelExpr(EmptyShell Empty) {
    // : Expr(AddrLabelExprClass, Empty), AmpAmpLoc(), LabelLoc() 
    //START JInit
    super(StmtClass.AddrLabelExprClass, new EmptyShell(Empty));
    this.AmpAmpLoc = new SourceLocation();
    this.LabelLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::getAmpAmpLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3353,
   FQN="clang::AddrLabelExpr::getAmpAmpLoc", NM="_ZNK5clang13AddrLabelExpr12getAmpAmpLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13AddrLabelExpr12getAmpAmpLocEv")
  //</editor-fold>
  public SourceLocation getAmpAmpLoc() /*const*/ {
    return new SourceLocation(AmpAmpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::setAmpAmpLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3354,
   FQN="clang::AddrLabelExpr::setAmpAmpLoc", NM="_ZN5clang13AddrLabelExpr12setAmpAmpLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExpr12setAmpAmpLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAmpAmpLoc(SourceLocation L) {
    AmpAmpLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::getLabelLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3355,
   FQN="clang::AddrLabelExpr::getLabelLoc", NM="_ZNK5clang13AddrLabelExpr11getLabelLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13AddrLabelExpr11getLabelLocEv")
  //</editor-fold>
  public SourceLocation getLabelLoc() /*const*/ {
    return new SourceLocation(LabelLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::setLabelLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3356,
   FQN="clang::AddrLabelExpr::setLabelLoc", NM="_ZN5clang13AddrLabelExpr11setLabelLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExpr11setLabelLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLabelLoc(SourceLocation L) {
    LabelLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3358,
   FQN="clang::AddrLabelExpr::getLocStart", NM="_ZNK5clang13AddrLabelExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13AddrLabelExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AmpAmpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3359,
   FQN="clang::AddrLabelExpr::getLocEnd", NM="_ZNK5clang13AddrLabelExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13AddrLabelExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LabelLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3361,
   FQN="clang::AddrLabelExpr::getLabel", NM="_ZNK5clang13AddrLabelExpr8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13AddrLabelExpr8getLabelEv")
  //</editor-fold>
  public LabelDecl /*P*/ getLabel() /*const*/ {
    return Label;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::setLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3362,
   FQN="clang::AddrLabelExpr::setLabel", NM="_ZN5clang13AddrLabelExpr8setLabelEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExpr8setLabelEPNS_9LabelDeclE")
  //</editor-fold>
  public void setLabel(LabelDecl /*P*/ L) {
    Label = L;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3364,
   FQN="clang::AddrLabelExpr::classof", NM="_ZN5clang13AddrLabelExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.AddrLabelExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::AddrLabelExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3369,
   FQN="clang::AddrLabelExpr::children", NM="_ZN5clang13AddrLabelExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13AddrLabelExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "AmpAmpLoc=" + AmpAmpLoc // NOI18N
              + ", LabelLoc=" + LabelLoc // NOI18N
              + ", Label=" + Label // NOI18N
              + super.toString(); // NOI18N
  }
}
