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


/// \brief A runtime availability query.
///
/// There are 2 ways to spell this node:
/// \code
///   @available(macos 10.10, ios 8, *); // Objective-C
///   __builtin_available(macos 10.10, ios 8, *); // C, C++, and Objective-C
/// \endcode
///
/// Note that we only need to keep track of one \c VersionTuple here, which is
/// the one that corresponds to the current deployment target. This is meant to
/// be used in the condition of an \c if, but it is also usable as top level
/// expressions.
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1579,
 FQN="clang::ObjCAvailabilityCheckExpr", NM="_ZN5clang25ObjCAvailabilityCheckExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang25ObjCAvailabilityCheckExprE")
//</editor-fold>
public class ObjCAvailabilityCheckExpr extends /*public*/ Expr {
  /*friend*/public VersionTuple VersionToCheck;
  /*friend*/public SourceLocation AtLoc;
  /*friend*/public SourceLocation RParen;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::ObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1585,
   FQN="clang::ObjCAvailabilityCheckExpr::ObjCAvailabilityCheckExpr", NM="_ZN5clang25ObjCAvailabilityCheckExprC1ENS_12VersionTupleENS_14SourceLocationES2_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang25ObjCAvailabilityCheckExprC1ENS_12VersionTupleENS_14SourceLocationES2_NS_8QualTypeE")
  //</editor-fold>
  public ObjCAvailabilityCheckExpr(VersionTuple VersionToCheck, SourceLocation AtLoc, 
      SourceLocation RParen, QualType Ty) {
    // : Expr(ObjCAvailabilityCheckExprClass, Ty, VK_RValue, OK_Ordinary, false, false, false, false), VersionToCheck(VersionToCheck), AtLoc(AtLoc), RParen(RParen) 
    //START JInit
    super(StmtClass.ObjCAvailabilityCheckExprClass, new QualType(Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, 
        false, false, false);
    this.VersionToCheck = new VersionTuple(VersionToCheck);
    this.AtLoc = new SourceLocation(AtLoc);
    this.RParen = new SourceLocation(RParen);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::ObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1591,
   FQN="clang::ObjCAvailabilityCheckExpr::ObjCAvailabilityCheckExpr", NM="_ZN5clang25ObjCAvailabilityCheckExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang25ObjCAvailabilityCheckExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCAvailabilityCheckExpr(EmptyShell Shell) {
    // : Expr(ObjCAvailabilityCheckExprClass, Shell), VersionToCheck(), AtLoc(), RParen() 
    //START JInit
    super(StmtClass.ObjCAvailabilityCheckExprClass, new EmptyShell(Shell));
    this.VersionToCheck = new VersionTuple();
    this.AtLoc = new SourceLocation();
    this.RParen = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1594,
   FQN="clang::ObjCAvailabilityCheckExpr::getLocStart", NM="_ZNK5clang25ObjCAvailabilityCheckExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang25ObjCAvailabilityCheckExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1595,
   FQN="clang::ObjCAvailabilityCheckExpr::getLocEnd", NM="_ZNK5clang25ObjCAvailabilityCheckExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang25ObjCAvailabilityCheckExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*/ {
    return new SourceLocation(RParen);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1596,
   FQN="clang::ObjCAvailabilityCheckExpr::getSourceRange", NM="_ZNK5clang25ObjCAvailabilityCheckExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang25ObjCAvailabilityCheckExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*/ {
    return /*{ */new SourceRange(/*NO_COPY*/AtLoc, /*NO_COPY*/RParen)/* }*/;
  }

  
  /// \brief This may be '*', in which case this should fold to true.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::hasVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1599,
   FQN="clang::ObjCAvailabilityCheckExpr::hasVersion", NM="_ZNK5clang25ObjCAvailabilityCheckExpr10hasVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang25ObjCAvailabilityCheckExpr10hasVersionEv")
  //</editor-fold>
  public boolean hasVersion() /*const*/ {
    return !VersionToCheck.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::getVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1600,
   FQN="clang::ObjCAvailabilityCheckExpr::getVersion", NM="_ZN5clang25ObjCAvailabilityCheckExpr10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang25ObjCAvailabilityCheckExpr10getVersionEv")
  //</editor-fold>
  public VersionTuple getVersion() {
    return new VersionTuple(VersionToCheck);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1602,
   FQN="clang::ObjCAvailabilityCheckExpr::children", NM="_ZN5clang25ObjCAvailabilityCheckExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang25ObjCAvailabilityCheckExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAvailabilityCheckExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1606,
   FQN="clang::ObjCAvailabilityCheckExpr::classof", NM="_ZN5clang25ObjCAvailabilityCheckExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang25ObjCAvailabilityCheckExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAvailabilityCheckExprClass;
  }

  
  @Override public String toString() {
    return "" + "VersionToCheck=" + VersionToCheck // NOI18N
              + ", AtLoc=" + AtLoc // NOI18N
              + ", RParen=" + RParen // NOI18N
              + super.toString(); // NOI18N
  }
}
