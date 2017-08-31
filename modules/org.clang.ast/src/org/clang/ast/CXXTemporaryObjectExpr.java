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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// @brief Represents a C++ functional cast expression that builds a
/// temporary object.
///
/// This expression type represents a C++ "functional" cast
/// (C++[expr.type.conv]) with N != 1 arguments that invokes a
/// constructor to build a temporary object. With N == 1 arguments the
/// functional cast expression will be represented by CXXFunctionalCastExpr.
/// Example:
/// \code
/// struct X { X(int, float); }
///
/// X create_X() {
///   return X(1, 3.14f); // creates a CXXTemporaryObjectExpr
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1454,
 FQN="clang::CXXTemporaryObjectExpr", NM="_ZN5clang22CXXTemporaryObjectExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang22CXXTemporaryObjectExprE")
//</editor-fold>
public class CXXTemporaryObjectExpr extends /*public*/ CXXConstructExpr {
  /*friend*/public TypeSourceInfo /*P*/ Type;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr::CXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 719,
   FQN="clang::CXXTemporaryObjectExpr::CXXTemporaryObjectExpr", NM="_ZN5clang22CXXTemporaryObjectExprC1ERKNS_10ASTContextEPNS_18CXXConstructorDeclEPNS_14TypeSourceInfoEN4llvm8ArrayRefIPNS_4ExprEEENS_11SourceRangeEbbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang22CXXTemporaryObjectExprC1ERKNS_10ASTContextEPNS_18CXXConstructorDeclEPNS_14TypeSourceInfoEN4llvm8ArrayRefIPNS_4ExprEEENS_11SourceRangeEbbbb")
  //</editor-fold>
  public CXXTemporaryObjectExpr(final /*const*/ ASTContext /*&*/ C, 
      CXXConstructorDecl /*P*/ Cons, 
      TypeSourceInfo /*P*/ Type, 
      ArrayRef<Expr /*P*/ > Args, 
      SourceRange ParenOrBraceRange, 
      boolean HadMultipleCandidates, 
      boolean ListInitialization, 
      boolean StdInitListInitialization, 
      boolean ZeroInitialization) {
    // : CXXConstructExpr(C, CXXTemporaryObjectExprClass, Type->getType().getNonReferenceType(), Type->getTypeLoc().getBeginLoc(), Cons, false, Args, HadMultipleCandidates, ListInitialization, StdInitListInitialization, ZeroInitialization, CXXConstructExpr::CK_Complete, ParenOrBraceRange), Type(Type) 
    //START JInit
    super(C, StmtClass.CXXTemporaryObjectExprClass, 
        Type.getType().getNonReferenceType(), 
        Type.getTypeLoc().getBeginLoc(), 
        Cons, false, new ArrayRef<Expr /*P*/ >(Args), 
        HadMultipleCandidates, 
        ListInitialization, 
        StdInitListInitialization, 
        ZeroInitialization, 
        CXXConstructExpr.ConstructionKind.CK_Complete, new SourceRange(ParenOrBraceRange));
    this.Type = Type;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr::CXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1467,
   FQN="clang::CXXTemporaryObjectExpr::CXXTemporaryObjectExpr", NM="_ZN5clang22CXXTemporaryObjectExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang22CXXTemporaryObjectExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXTemporaryObjectExpr(EmptyShell Empty) {
    // : CXXConstructExpr(CXXTemporaryObjectExprClass, Empty), Type(implicit TypeSourceInfo * ()) 
    //START JInit
    super(StmtClass.CXXTemporaryObjectExprClass, new EmptyShell(Empty));
    this.Type = /*implicit-init*/((TypeSourceInfo /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1470,
   FQN="clang::CXXTemporaryObjectExpr::getTypeSourceInfo", NM="_ZNK5clang22CXXTemporaryObjectExpr17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang22CXXTemporaryObjectExpr17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return Type;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 740,
   FQN="clang::CXXTemporaryObjectExpr::getLocStart", NM="_ZNK5clang22CXXTemporaryObjectExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang22CXXTemporaryObjectExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Type.getTypeLoc().getBeginLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 744,
   FQN="clang::CXXTemporaryObjectExpr::getLocEnd", NM="_ZNK5clang22CXXTemporaryObjectExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang22CXXTemporaryObjectExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    SourceLocation Loc = getParenOrBraceRange().getEnd();
    if (Loc.isInvalid() && (getNumArgs() != 0)) {
      Loc.$assignMove(getArg$Const(getNumArgs() - 1).getLocEnd());
    }
    return Loc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporaryObjectExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1475,
   FQN="clang::CXXTemporaryObjectExpr::classof", NM="_ZN5clang22CXXTemporaryObjectExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang22CXXTemporaryObjectExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXTemporaryObjectExprClass;
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "Type=" + Type // NOI18N
              + super.toString(); // NOI18N
  }
}
