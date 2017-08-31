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


/// \brief Represents a call to an inherited base class constructor from an
/// inheriting constructor. This call implicitly forwards the arguments from
/// the enclosing context (an inheriting constructor) to the specified inherited
/// base class constructor.
//<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1325,
 FQN="clang::CXXInheritedCtorInitExpr", NM="_ZN5clang24CXXInheritedCtorInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24CXXInheritedCtorInitExprE")
//</editor-fold>
public class CXXInheritedCtorInitExpr extends /*public*/ Expr {
/*private:*/
  /*friend*/public CXXConstructorDecl /*P*/ Constructor;
  
  /// The location of the using declaration.
  /*friend*/public SourceLocation Loc;
  
  /// Whether this is the construction of a virtual base.
  /*friend*/public /*JBIT unsigned int*/ boolean ConstructsVirtualBase /*: 1*/;
  
  /// Whether the constructor is inherited from a virtual base class of the
  /// class that we construct.
  /*friend*/public /*JBIT unsigned int*/ boolean InheritedFromVirtualBase /*: 1*/;
/*public:*/
  /// \brief Construct a C++ inheriting construction expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::CXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1341,
   FQN="clang::CXXInheritedCtorInitExpr::CXXInheritedCtorInitExpr", NM="_ZN5clang24CXXInheritedCtorInitExprC1ENS_14SourceLocationENS_8QualTypeEPNS_18CXXConstructorDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24CXXInheritedCtorInitExprC1ENS_14SourceLocationENS_8QualTypeEPNS_18CXXConstructorDeclEbb")
  //</editor-fold>
  public CXXInheritedCtorInitExpr(SourceLocation Loc, QualType T, 
      CXXConstructorDecl /*P*/ Ctor, boolean ConstructsVirtualBase, 
      boolean InheritedFromVirtualBase) {
    // : Expr(CXXInheritedCtorInitExprClass, T, VK_RValue, OK_Ordinary, false, false, false, false), Constructor(Ctor), Loc(Loc), ConstructsVirtualBase(ConstructsVirtualBase), InheritedFromVirtualBase(InheritedFromVirtualBase) 
    //START JInit
    super(StmtClass.CXXInheritedCtorInitExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, 
        false, false, false);
    this.Constructor = Ctor;
    this.Loc = new SourceLocation(Loc);
    this.ConstructsVirtualBase = ConstructsVirtualBase;
    this.InheritedFromVirtualBase = InheritedFromVirtualBase;
    //END JInit
    assert (!T.$arrow().isDependentType());
  }

  
  /// \brief Construct an empty C++ inheriting construction expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::CXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1353,
   FQN="clang::CXXInheritedCtorInitExpr::CXXInheritedCtorInitExpr", NM="_ZN5clang24CXXInheritedCtorInitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24CXXInheritedCtorInitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXInheritedCtorInitExpr(EmptyShell Empty) {
    // : Expr(CXXInheritedCtorInitExprClass, Empty), Constructor(null), Loc(), ConstructsVirtualBase(false), InheritedFromVirtualBase(false) 
    //START JInit
    super(StmtClass.CXXInheritedCtorInitExprClass, new EmptyShell(Empty));
    this.Constructor = null;
    this.Loc = new SourceLocation();
    this.ConstructsVirtualBase = false;
    this.InheritedFromVirtualBase = false;
    //END JInit
  }

  
  /// \brief Get the constructor that this expression will call.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::getConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1358,
   FQN="clang::CXXInheritedCtorInitExpr::getConstructor", NM="_ZNK5clang24CXXInheritedCtorInitExpr14getConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr14getConstructorEv")
  //</editor-fold>
  public CXXConstructorDecl /*P*/ getConstructor() /*const*/ {
    return Constructor;
  }

  
  /// \brief Determine whether this constructor is actually constructing
  /// a base class (rather than a complete object).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::constructsVBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1362,
   FQN="clang::CXXInheritedCtorInitExpr::constructsVBase", NM="_ZNK5clang24CXXInheritedCtorInitExpr15constructsVBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr15constructsVBaseEv")
  //</editor-fold>
  public boolean constructsVBase() /*const*/ {
    return ConstructsVirtualBase;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::getConstructionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1363,
   FQN="clang::CXXInheritedCtorInitExpr::getConstructionKind", NM="_ZNK5clang24CXXInheritedCtorInitExpr19getConstructionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr19getConstructionKindEv")
  //</editor-fold>
  public CXXConstructExpr.ConstructionKind getConstructionKind() /*const*/ {
    return ConstructsVirtualBase ? CXXConstructExpr.ConstructionKind.CK_VirtualBase : CXXConstructExpr.ConstructionKind.CK_NonVirtualBase;
  }

  
  /// \brief Determine whether the inherited constructor is inherited from a
  /// virtual base of the object we construct. If so, we are not responsible
  /// for calling the inherited constructor (the complete object constructor
  /// does that), and so we don't need to pass any arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::inheritedFromVBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1372,
   FQN="clang::CXXInheritedCtorInitExpr::inheritedFromVBase", NM="_ZNK5clang24CXXInheritedCtorInitExpr18inheritedFromVBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr18inheritedFromVBaseEv")
  //</editor-fold>
  public boolean inheritedFromVBase() /*const*/ {
    return InheritedFromVirtualBase;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1374,
   FQN="clang::CXXInheritedCtorInitExpr::getLocation", NM="_ZNK5clang24CXXInheritedCtorInitExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1375,
   FQN="clang::CXXInheritedCtorInitExpr::getLocStart", NM="_ZNK5clang24CXXInheritedCtorInitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1376,
   FQN="clang::CXXInheritedCtorInitExpr::getLocEnd", NM="_ZNK5clang24CXXInheritedCtorInitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang24CXXInheritedCtorInitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1378,
   FQN="clang::CXXInheritedCtorInitExpr::classof", NM="_ZN5clang24CXXInheritedCtorInitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24CXXInheritedCtorInitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXInheritedCtorInitExprClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXInheritedCtorInitExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1381,
   FQN="clang::CXXInheritedCtorInitExpr::children", NM="_ZN5clang24CXXInheritedCtorInitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang24CXXInheritedCtorInitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "Constructor=" + Constructor // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", ConstructsVirtualBase=" + ConstructsVirtualBase // NOI18N
              + ", InheritedFromVirtualBase=" + InheritedFromVirtualBase // NOI18N
              + super.toString(); // NOI18N
  }
}
