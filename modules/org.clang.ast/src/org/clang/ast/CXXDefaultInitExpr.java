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
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief A use of a default initializer in a constructor or in aggregate
/// initialization.
///
/// This wraps a use of a C++ default initializer (technically,
/// a brace-or-equal-initializer for a non-static data member) when it
/// is implicitly used in a mem-initializer-list in a constructor
/// (C++11 [class.base.init]p8) or in aggregate initialization
/// (C++1y [dcl.init.aggr]p7).
//<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1037,
 FQN="clang::CXXDefaultInitExpr", NM="_ZN5clang18CXXDefaultInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExprE")
//</editor-fold>
public class CXXDefaultInitExpr extends /*public*/ Expr {
  /// \brief The field whose default is being used.
  /*friend*/public FieldDecl /*P*/ Field;
  
  /// \brief The location where the default initializer expression was used.
  /*friend*/public SourceLocation Loc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::CXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 693,
   FQN="clang::CXXDefaultInitExpr::CXXDefaultInitExpr", NM="_ZN5clang18CXXDefaultInitExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_9FieldDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_9FieldDeclENS_8QualTypeE")
  //</editor-fold>
  private CXXDefaultInitExpr(final /*const*/ ASTContext /*&*/ C, SourceLocation Loc, 
      FieldDecl /*P*/ Field, QualType T) {
    // : Expr(CXXDefaultInitExprClass, T.getNonLValueExprType(C), T->isLValueReferenceType() ? VK_LValue : T->isRValueReferenceType() ? VK_XValue : VK_RValue, /*FIXME*/ OK_Ordinary, false, false, false, false), Field(Field), Loc(Loc) 
    //START JInit
    super(StmtClass.CXXDefaultInitExprClass, T.getNonLValueExprType(C), 
        T.$arrow().isLValueReferenceType() ? ExprValueKind.VK_LValue : T.$arrow().isRValueReferenceType() ? ExprValueKind.VK_XValue : ExprValueKind.VK_RValue, 
        ExprObjectKind.OK_Ordinary, false, false, false, false);
    this.Field = Field;
    this.Loc = new SourceLocation(Loc);
    //END JInit
    assert (Field.hasInClassInitializer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::CXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1047,
   FQN="clang::CXXDefaultInitExpr::CXXDefaultInitExpr", NM="_ZN5clang18CXXDefaultInitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ CXXDefaultInitExpr(EmptyShell Empty) {
    // : Expr(CXXDefaultInitExprClass, Empty), Loc() 
    //START JInit
    super(StmtClass.CXXDefaultInitExprClass, new EmptyShell(Empty));
    this.Loc = new SourceLocation();
    //END JInit
  }

/*public:*/
  /// \p Field is the non-static data member whose default initializer is used
  /// by this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1052,
   FQN="clang::CXXDefaultInitExpr::Create", NM="_ZN5clang18CXXDefaultInitExpr6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExpr6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_9FieldDeclE")
  //</editor-fold>
  public static CXXDefaultInitExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation Loc, 
        FieldDecl /*P*/ Field) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new CXXDefaultInitExpr(C, new SourceLocation(Loc), Field, Field.getType());
     });
  }

  
  /// \brief Get the field whose initializer will be used.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::getField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1058,
   FQN="clang::CXXDefaultInitExpr::getField", NM="_ZN5clang18CXXDefaultInitExpr8getFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExpr8getFieldEv")
  //</editor-fold>
  public FieldDecl /*P*/ getField() {
    return Field;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::getField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1059,
   FQN="clang::CXXDefaultInitExpr::getField", NM="_ZNK5clang18CXXDefaultInitExpr8getFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18CXXDefaultInitExpr8getFieldEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getField$Const() /*const*/ {
    return Field;
  }

  
  /// \brief Get the initialization expression that will be used.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1062,
   FQN="clang::CXXDefaultInitExpr::getExpr", NM="_ZNK5clang18CXXDefaultInitExpr7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18CXXDefaultInitExpr7getExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr$Const() /*const*/ {
    assert ((Field.getInClassInitializer() != null)) : "initializer hasn't been parsed";
    return Field.getInClassInitializer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1066,
   FQN="clang::CXXDefaultInitExpr::getExpr", NM="_ZN5clang18CXXDefaultInitExpr7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExpr7getExprEv")
  //</editor-fold>
  public Expr /*P*/ getExpr() {
    assert ((Field.getInClassInitializer() != null)) : "initializer hasn't been parsed";
    return Field.getInClassInitializer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1071,
   FQN="clang::CXXDefaultInitExpr::getLocStart", NM="_ZNK5clang18CXXDefaultInitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18CXXDefaultInitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1072,
   FQN="clang::CXXDefaultInitExpr::getLocEnd", NM="_ZNK5clang18CXXDefaultInitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18CXXDefaultInitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1074,
   FQN="clang::CXXDefaultInitExpr::classof", NM="_ZN5clang18CXXDefaultInitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXDefaultInitExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultInitExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1079,
   FQN="clang::CXXDefaultInitExpr::children", NM="_ZN5clang18CXXDefaultInitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CXXDefaultInitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "Field=" + Field // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
