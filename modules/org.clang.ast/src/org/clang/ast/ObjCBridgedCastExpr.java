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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief An Objective-C "bridged" cast expression, which casts between
/// Objective-C pointers and C pointers, transferring ownership in the process.
///
/// \code
/// NSString *str = (__bridge_transfer NSString *)CFCreateString();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1519,
 FQN="clang::ObjCBridgedCastExpr", NM="_ZN5clang19ObjCBridgedCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBridgedCastExprE")
//</editor-fold>
public final class ObjCBridgedCastExpr extends /*public*/ ExplicitCastExpr implements /*private*/ TrailingObjects<ObjCBridgedCastExpr, CXXBaseSpecifier /*P*/ > {
  /*friend*/public SourceLocation LParenLoc;
  /*friend*/public SourceLocation BridgeKeywordLoc;
  /*friend*/public /*JBYTE unsigned int*/ byte Kind /*: 2*/;
  
  /*friend  TrailingObjects<ObjCBridgedCastExpr, CXXBaseSpecifier *>*/
  /*friend  class CastExpr*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::ObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1532,
   FQN="clang::ObjCBridgedCastExpr::ObjCBridgedCastExpr", NM="_ZN5clang19ObjCBridgedCastExprC1ENS_14SourceLocationENS_18ObjCBridgeCastKindENS_8CastKindES1_PNS_14TypeSourceInfoEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBridgedCastExprC1ENS_14SourceLocationENS_18ObjCBridgeCastKindENS_8CastKindES1_PNS_14TypeSourceInfoEPNS_4ExprE")
  //</editor-fold>
  public ObjCBridgedCastExpr(SourceLocation LParenLoc, ObjCBridgeCastKind Kind, 
      CastKind CK, SourceLocation BridgeKeywordLoc, 
      TypeSourceInfo /*P*/ TSInfo, Expr /*P*/ Operand) {
    // : ExplicitCastExpr(ObjCBridgedCastExprClass, TSInfo->getType(), VK_RValue, CK, Operand, 0, TSInfo), TrailingObjects<ObjCBridgedCastExpr, CXXBaseSpecifier * >(), LParenLoc(LParenLoc), BridgeKeywordLoc(BridgeKeywordLoc), Kind(Kind) 
    //START JInit
    super(StmtClass.ObjCBridgedCastExprClass, TSInfo.getType(), ExprValueKind.VK_RValue, 
        CK, Operand, 0, TSInfo);
    $TrailingObjects();
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.BridgeKeywordLoc = new SourceLocation(BridgeKeywordLoc);
    this.Kind = $uint2uint_2bits(Kind.getValue());
    //END JInit
  }

  
  /// \brief Construct an empty Objective-C bridged cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::ObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1540,
   FQN="clang::ObjCBridgedCastExpr::ObjCBridgedCastExpr", NM="_ZN5clang19ObjCBridgedCastExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBridgedCastExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCBridgedCastExpr(EmptyShell Shell) {
    // : ExplicitCastExpr(ObjCBridgedCastExprClass, Shell, 0), TrailingObjects<ObjCBridgedCastExpr, CXXBaseSpecifier * >(), LParenLoc(), BridgeKeywordLoc() 
    //START JInit
    super(StmtClass.ObjCBridgedCastExprClass, new EmptyShell(Shell), 0);
    $TrailingObjects();
    this.LParenLoc = new SourceLocation();
    this.BridgeKeywordLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1543,
   FQN="clang::ObjCBridgedCastExpr::getLParenLoc", NM="_ZNK5clang19ObjCBridgedCastExpr12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBridgedCastExpr12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  
  /// \brief Determine which kind of bridge is being performed via this cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::getBridgeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1546,
   FQN="clang::ObjCBridgedCastExpr::getBridgeKind", NM="_ZNK5clang19ObjCBridgedCastExpr13getBridgeKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBridgedCastExpr13getBridgeKindEv")
  //</editor-fold>
  public ObjCBridgeCastKind getBridgeKind() /*const*/ {
    return /*static_cast*/ObjCBridgeCastKind.valueOf(Kind);
  }

  
  /// \brief Retrieve the kind of bridge being performed as a string.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::getBridgeKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp", line = 349,
   FQN="clang::ObjCBridgedCastExpr::getBridgeKindName", NM="_ZNK5clang19ObjCBridgedCastExpr17getBridgeKindNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBridgedCastExpr17getBridgeKindNameEv")
  //</editor-fold>
  public StringRef getBridgeKindName() /*const*/ {
    switch (getBridgeKind()) {
     case OBC_Bridge:
      return new StringRef(/*KEEP_STR*/$__bridge);
     case OBC_BridgeTransfer:
      return new StringRef(/*KEEP_STR*/$__bridge_transfer);
     case OBC_BridgeRetained:
      return new StringRef(/*KEEP_STR*/$__bridge_retained);
    }
    throw new llvm_unreachable("Invalid BridgeKind!");
  }

  
  /// \brief The location of the bridge keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::getBridgeKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1554,
   FQN="clang::ObjCBridgedCastExpr::getBridgeKeywordLoc", NM="_ZNK5clang19ObjCBridgedCastExpr19getBridgeKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBridgedCastExpr19getBridgeKeywordLocEv")
  //</editor-fold>
  public SourceLocation getBridgeKeywordLoc() /*const*/ {
    return new SourceLocation(BridgeKeywordLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1556,
   FQN="clang::ObjCBridgedCastExpr::getLocStart", NM="_ZNK5clang19ObjCBridgedCastExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBridgedCastExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1557,
   FQN="clang::ObjCBridgedCastExpr::getLocEnd", NM="_ZNK5clang19ObjCBridgedCastExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBridgedCastExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getSubExpr$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgedCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1561,
   FQN="clang::ObjCBridgedCastExpr::classof", NM="_ZN5clang19ObjCBridgedCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBridgedCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCBridgedCastExprClass;
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", BridgeKeywordLoc=" + BridgeKeywordLoc // NOI18N
              + ", Kind=" + $uchar2uint(Kind) // NOI18N
              + super.toString(); // NOI18N
  }
}
