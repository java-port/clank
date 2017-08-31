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


/// ObjCProtocolExpr used for protocol expression in Objective-C.
///
/// This is used as: \@protocol(foo), as in:
/// \code
///   [obj conformsToProtocol:@protocol(foo)]
/// \endcode
///
/// The return type is "Protocol*".
//<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 441,
 FQN="clang::ObjCProtocolExpr", NM="_ZN5clang16ObjCProtocolExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExprE")
//</editor-fold>
public class ObjCProtocolExpr extends /*public*/ Expr {
  private ObjCProtocolDecl /*P*/ TheProtocol;
  private SourceLocation AtLoc;
  /*friend*/public SourceLocation ProtoLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::ObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 445,
   FQN="clang::ObjCProtocolExpr::ObjCProtocolExpr", NM="_ZN5clang16ObjCProtocolExprC1ENS_8QualTypeEPNS_16ObjCProtocolDeclENS_14SourceLocationES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExprC1ENS_8QualTypeEPNS_16ObjCProtocolDeclENS_14SourceLocationES4_S4_")
  //</editor-fold>
  public ObjCProtocolExpr(QualType T, ObjCProtocolDecl /*P*/ protocol, 
      SourceLocation at, SourceLocation protoLoc, SourceLocation rp) {
    // : Expr(ObjCProtocolExprClass, T, VK_RValue, OK_Ordinary, false, false, false, false), TheProtocol(protocol), AtLoc(at), ProtoLoc(protoLoc), RParenLoc(rp) 
    //START JInit
    super(StmtClass.ObjCProtocolExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.TheProtocol = protocol;
    this.AtLoc = new SourceLocation(at);
    this.ProtoLoc = new SourceLocation(protoLoc);
    this.RParenLoc = new SourceLocation(rp);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::ObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 450,
   FQN="clang::ObjCProtocolExpr::ObjCProtocolExpr", NM="_ZN5clang16ObjCProtocolExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCProtocolExpr(EmptyShell Empty) {
    // : Expr(ObjCProtocolExprClass, Empty), AtLoc(), ProtoLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ObjCProtocolExprClass, new EmptyShell(Empty));
    this.AtLoc = new SourceLocation();
    this.ProtoLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::getProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 453,
   FQN="clang::ObjCProtocolExpr::getProtocol", NM="_ZNK5clang16ObjCProtocolExpr11getProtocolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCProtocolExpr11getProtocolEv")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ getProtocol() /*const*/ {
    return TheProtocol;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::setProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 454,
   FQN="clang::ObjCProtocolExpr::setProtocol", NM="_ZN5clang16ObjCProtocolExpr11setProtocolEPNS_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExpr11setProtocolEPNS_16ObjCProtocolDeclE")
  //</editor-fold>
  public void setProtocol(ObjCProtocolDecl /*P*/ P) {
    TheProtocol = P;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::getProtocolIdLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 456,
   FQN="clang::ObjCProtocolExpr::getProtocolIdLoc", NM="_ZNK5clang16ObjCProtocolExpr16getProtocolIdLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCProtocolExpr16getProtocolIdLocEv")
  //</editor-fold>
  public SourceLocation getProtocolIdLoc() /*const*/ {
    return new SourceLocation(ProtoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 457,
   FQN="clang::ObjCProtocolExpr::getAtLoc", NM="_ZNK5clang16ObjCProtocolExpr8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCProtocolExpr8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 458,
   FQN="clang::ObjCProtocolExpr::getRParenLoc", NM="_ZNK5clang16ObjCProtocolExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCProtocolExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 459,
   FQN="clang::ObjCProtocolExpr::setAtLoc", NM="_ZN5clang16ObjCProtocolExpr8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExpr8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation L) {
    AtLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 460,
   FQN="clang::ObjCProtocolExpr::setRParenLoc", NM="_ZN5clang16ObjCProtocolExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 462,
   FQN="clang::ObjCProtocolExpr::getLocStart", NM="_ZNK5clang16ObjCProtocolExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCProtocolExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 463,
   FQN="clang::ObjCProtocolExpr::getLocEnd", NM="_ZNK5clang16ObjCProtocolExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCProtocolExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 465,
   FQN="clang::ObjCProtocolExpr::classof", NM="_ZN5clang16ObjCProtocolExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCProtocolExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 470,
   FQN="clang::ObjCProtocolExpr::children", NM="_ZN5clang16ObjCProtocolExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCProtocolExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  @Override public String toString() {
    return "" + "TheProtocol=" + TheProtocol // NOI18N
              + ", AtLoc=" + AtLoc // NOI18N
              + ", ProtoLoc=" + ProtoLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
