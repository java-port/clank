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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// Represents a call to the builtin function \c __builtin_va_arg.
//<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3655,
 FQN="clang::VAArgExpr", NM="_ZN5clang9VAArgExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExprE")
//</editor-fold>
public class VAArgExpr extends /*public*/ Expr {
  private Stmt /*P*/ Val;
  private PointerBoolPair<TypeSourceInfo /*P*/ > TInfo;
  private SourceLocation BuiltinLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::VAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3660,
   FQN="clang::VAArgExpr::VAArgExpr", NM="_ZN5clang9VAArgExprC1ENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES1_NS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExprC1ENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES1_NS_8QualTypeEb")
  //</editor-fold>
  public VAArgExpr(SourceLocation BLoc, Expr /*P*/ e, TypeSourceInfo /*P*/ TInfo, 
      SourceLocation RPLoc, QualType t, boolean IsMS) {
    // : Expr(VAArgExprClass, t, VK_RValue, OK_Ordinary, t->isDependentType(), false, (TInfo->getType()->isInstantiationDependentType() || e->isInstantiationDependent()), (TInfo->getType()->containsUnexpandedParameterPack() || e->containsUnexpandedParameterPack())), Val(e), TInfo(TInfo, IsMS), BuiltinLoc(BLoc), RParenLoc(RPLoc) 
    //START JInit
    super(StmtClass.VAArgExprClass, new QualType(t), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, t.$arrow().isDependentType(), 
        false, (TInfo.getType().$arrow().isInstantiationDependentType()
           || e.isInstantiationDependent()), 
        (TInfo.getType().$arrow().containsUnexpandedParameterPack()
           || e.containsUnexpandedParameterPack()));
    this.Val = e;
    this.TInfo = new PointerBoolPair<TypeSourceInfo /*P*/ >(TInfo, IsMS);
    this.BuiltinLoc = new SourceLocation(BLoc);
    this.RParenLoc = new SourceLocation(RPLoc);
    //END JInit
  }

  
  /// Create an empty __builtin_va_arg expression.
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::VAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3670,
   FQN="clang::VAArgExpr::VAArgExpr", NM="_ZN5clang9VAArgExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ VAArgExpr(EmptyShell Empty) {
    // : Expr(VAArgExprClass, Empty), Val(null), TInfo(null, false), BuiltinLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.VAArgExprClass, new EmptyShell(Empty));
    this.Val = null;
    this.TInfo = new PointerBoolPair<TypeSourceInfo /*P*/ >((TypeSourceInfo /*P*/ )null, false);
    this.BuiltinLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3673,
   FQN="clang::VAArgExpr::getSubExpr", NM="_ZNK5clang9VAArgExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3674,
   FQN="clang::VAArgExpr::getSubExpr", NM="_ZN5clang9VAArgExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::setSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3675,
   FQN="clang::VAArgExpr::setSubExpr", NM="_ZN5clang9VAArgExpr10setSubExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr10setSubExprEPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(Expr /*P*/ E) {
    Val = E;
  }

  
  /// Returns whether this is really a Win64 ABI va_arg expression.
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::isMicrosoftABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3678,
   FQN="clang::VAArgExpr::isMicrosoftABI", NM="_ZNK5clang9VAArgExpr14isMicrosoftABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr14isMicrosoftABIEv")
  //</editor-fold>
  public boolean isMicrosoftABI() /*const*/ {
    return TInfo.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::setIsMicrosoftABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3679,
   FQN="clang::VAArgExpr::setIsMicrosoftABI", NM="_ZN5clang9VAArgExpr17setIsMicrosoftABIEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr17setIsMicrosoftABIEb")
  //</editor-fold>
  public void setIsMicrosoftABI(boolean IsMS) {
    TInfo.setInt(IsMS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getWrittenTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3681,
   FQN="clang::VAArgExpr::getWrittenTypeInfo", NM="_ZNK5clang9VAArgExpr18getWrittenTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr18getWrittenTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getWrittenTypeInfo() /*const*/ {
    return TInfo.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::setWrittenTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3682,
   FQN="clang::VAArgExpr::setWrittenTypeInfo", NM="_ZN5clang9VAArgExpr18setWrittenTypeInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr18setWrittenTypeInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setWrittenTypeInfo(TypeSourceInfo /*P*/ TI) {
    TInfo.setPointer(TI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3684,
   FQN="clang::VAArgExpr::getBuiltinLoc", NM="_ZNK5clang9VAArgExpr13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::setBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3685,
   FQN="clang::VAArgExpr::setBuiltinLoc", NM="_ZN5clang9VAArgExpr13setBuiltinLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr13setBuiltinLocENS_14SourceLocationE")
  //</editor-fold>
  public void setBuiltinLoc(SourceLocation L) {
    BuiltinLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3687,
   FQN="clang::VAArgExpr::getRParenLoc", NM="_ZNK5clang9VAArgExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3688,
   FQN="clang::VAArgExpr::setRParenLoc", NM="_ZN5clang9VAArgExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3690,
   FQN="clang::VAArgExpr::getLocStart", NM="_ZNK5clang9VAArgExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3691,
   FQN="clang::VAArgExpr::getLocEnd", NM="_ZNK5clang9VAArgExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9VAArgExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3693,
   FQN="clang::VAArgExpr::classof", NM="_ZN5clang9VAArgExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.VAArgExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::VAArgExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3698,
   FQN="clang::VAArgExpr::children", NM="_ZN5clang9VAArgExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9VAArgExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Val))), new StmtIterator(create_type$ptr($AddrOf(Val)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + ", TInfo=" + TInfo // NOI18N
              + ", BuiltinLoc=" + BuiltinLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
