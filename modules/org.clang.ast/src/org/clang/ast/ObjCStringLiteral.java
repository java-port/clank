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
import static org.clang.ast.java.AstRTTI.*;

/// ObjCStringLiteral, used for Objective-C string literals
/// i.e. @"foo".
//<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 29,
 FQN="clang::ObjCStringLiteral", NM="_ZN5clang17ObjCStringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteralE")
//</editor-fold>
public class ObjCStringLiteral extends /*public*/ Expr {
  private Stmt /*P*/ String;
  private SourceLocation AtLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::ObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 33,
   FQN="clang::ObjCStringLiteral::ObjCStringLiteral", NM="_ZN5clang17ObjCStringLiteralC1EPNS_13StringLiteralENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteralC1EPNS_13StringLiteralENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public ObjCStringLiteral(StringLiteral /*P*/ SL, QualType T, SourceLocation L) {
    // : Expr(ObjCStringLiteralClass, T, VK_RValue, OK_Ordinary, false, false, false, false), String(SL), AtLoc(L) 
    //START JInit
    super(StmtClass.ObjCStringLiteralClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.String = SL;
    this.AtLoc = new SourceLocation(L);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::ObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 37,
   FQN="clang::ObjCStringLiteral::ObjCStringLiteral", NM="_ZN5clang17ObjCStringLiteralC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteralC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCStringLiteral(EmptyShell Empty) {
    // : Expr(ObjCStringLiteralClass, Empty), AtLoc() 
    //START JInit
    super(StmtClass.ObjCStringLiteralClass, new EmptyShell(Empty));
    this.AtLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 40,
   FQN="clang::ObjCStringLiteral::getString", NM="_ZN5clang17ObjCStringLiteral9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteral9getStringEv")
  //</editor-fold>
  public StringLiteral /*P*/ getString() {
    return cast_StringLiteral(String);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 41,
   FQN="clang::ObjCStringLiteral::getString", NM="_ZNK5clang17ObjCStringLiteral9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang17ObjCStringLiteral9getStringEv")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getString$Const() /*const*/ {
    return cast_StringLiteral(String);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::setString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 42,
   FQN="clang::ObjCStringLiteral::setString", NM="_ZN5clang17ObjCStringLiteral9setStringEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteral9setStringEPNS_13StringLiteralE")
  //</editor-fold>
  public void setString(StringLiteral /*P*/ S) {
    String = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 44,
   FQN="clang::ObjCStringLiteral::getAtLoc", NM="_ZNK5clang17ObjCStringLiteral8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang17ObjCStringLiteral8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 45,
   FQN="clang::ObjCStringLiteral::setAtLoc", NM="_ZN5clang17ObjCStringLiteral8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteral8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation L) {
    AtLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 47,
   FQN="clang::ObjCStringLiteral::getLocStart", NM="_ZNK5clang17ObjCStringLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang17ObjCStringLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 48,
   FQN="clang::ObjCStringLiteral::getLocEnd", NM="_ZNK5clang17ObjCStringLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang17ObjCStringLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return String.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 50,
   FQN="clang::ObjCStringLiteral::classof", NM="_ZN5clang17ObjCStringLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCStringLiteralClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCStringLiteral::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 55,
   FQN="clang::ObjCStringLiteral::children", NM="_ZN5clang17ObjCStringLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang17ObjCStringLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(String))), new StmtIterator(create_type$ptr($AddrOf(String)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "String=" + String // NOI18N
              + ", AtLoc=" + AtLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
