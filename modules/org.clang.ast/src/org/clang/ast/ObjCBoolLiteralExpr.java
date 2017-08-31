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


/// ObjCBoolLiteralExpr - Objective-C Boolean Literal.
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 60,
 FQN="clang::ObjCBoolLiteralExpr", NM="_ZN5clang19ObjCBoolLiteralExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExprE")
//</editor-fold>
public class ObjCBoolLiteralExpr extends /*public*/ Expr {
  private boolean Value;
  private SourceLocation Loc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::ObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 64,
   FQN="clang::ObjCBoolLiteralExpr::ObjCBoolLiteralExpr", NM="_ZN5clang19ObjCBoolLiteralExprC1EbNS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExprC1EbNS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public ObjCBoolLiteralExpr(boolean val, QualType Ty, SourceLocation l) {
    // : Expr(ObjCBoolLiteralExprClass, Ty, VK_RValue, OK_Ordinary, false, false, false, false), Value(val), Loc(l) 
    //START JInit
    super(StmtClass.ObjCBoolLiteralExprClass, new QualType(Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.Value = val;
    this.Loc = new SourceLocation(l);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::ObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 68,
   FQN="clang::ObjCBoolLiteralExpr::ObjCBoolLiteralExpr", NM="_ZN5clang19ObjCBoolLiteralExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCBoolLiteralExpr(EmptyShell Empty) {
    // : Expr(ObjCBoolLiteralExprClass, Empty), Loc() 
    //START JInit
    super(StmtClass.ObjCBoolLiteralExprClass, new EmptyShell(Empty));
    this.Loc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 71,
   FQN="clang::ObjCBoolLiteralExpr::getValue", NM="_ZNK5clang19ObjCBoolLiteralExpr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBoolLiteralExpr8getValueEv")
  //</editor-fold>
  public boolean getValue() /*const*/ {
    return Value;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::setValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 72,
   FQN="clang::ObjCBoolLiteralExpr::setValue", NM="_ZN5clang19ObjCBoolLiteralExpr8setValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExpr8setValueEb")
  //</editor-fold>
  public void setValue(boolean V) {
    Value = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 74,
   FQN="clang::ObjCBoolLiteralExpr::getLocStart", NM="_ZNK5clang19ObjCBoolLiteralExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBoolLiteralExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 75,
   FQN="clang::ObjCBoolLiteralExpr::getLocEnd", NM="_ZNK5clang19ObjCBoolLiteralExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBoolLiteralExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 77,
   FQN="clang::ObjCBoolLiteralExpr::getLocation", NM="_ZNK5clang19ObjCBoolLiteralExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang19ObjCBoolLiteralExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 78,
   FQN="clang::ObjCBoolLiteralExpr::setLocation", NM="_ZN5clang19ObjCBoolLiteralExpr11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExpr11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    Loc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 80,
   FQN="clang::ObjCBoolLiteralExpr::classof", NM="_ZN5clang19ObjCBoolLiteralExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCBoolLiteralExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBoolLiteralExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 85,
   FQN="clang::ObjCBoolLiteralExpr::children", NM="_ZN5clang19ObjCBoolLiteralExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang19ObjCBoolLiteralExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
