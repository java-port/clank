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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// Represents an expression -- generally a full-expression -- that
/// introduces cleanups to be run at the end of the sub-expression's
/// evaluation.  The most common source of expression-introduced
/// cleanups is temporary objects in C++, but several other kinds of
/// expressions can create cleanups, including basically every
/// call in ARC that returns an Objective-C pointer.
///
/// This expression also tracks whether the sub-expression contains a
/// potentially-evaluated block literal.  The lifetime of a block
/// literal is the extent of the enclosing scope.
//<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2936,
 FQN="clang::ExprWithCleanups", NM="_ZN5clang16ExprWithCleanupsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanupsE")
//</editor-fold>
public final class ExprWithCleanups extends /*public*/ Expr implements /*private*/ TrailingObjects<ExprWithCleanups, BlockDecl /*P*/ > {
/*public:*/
  /// The type of objects that are kept in the cleanup.
  /// It's useful to remember the set of blocks;  we could also
  /// remember the set of temporaries, but there's currently
  /// no need.
  /*typedef BlockDecl *CleanupObject*/
//  public final class CleanupObject extends BlockDecl /*P*/ { };
/*private:*/
  /*friend*/public Stmt /*P*/ SubExpr;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::ExprWithCleanups">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1049,
   FQN="clang::ExprWithCleanups::ExprWithCleanups", NM="_ZN5clang16ExprWithCleanupsC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanupsC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private ExprWithCleanups(Stmt.EmptyShell empty, /*uint*/int numObjects) {
    // : Expr(ExprWithCleanupsClass, empty), TrailingObjects<ExprWithCleanups, BlockDecl * >() 
    //START JInit
    super(StmtClass.ExprWithCleanupsClass, new Stmt.EmptyShell(empty));
    $TrailingObjects();
    //END JInit
    Unnamed_field.ExprWithCleanupsBits.NumObjects = $uint2uint_15bits(numObjects);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::ExprWithCleanups">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1025,
   FQN="clang::ExprWithCleanups::ExprWithCleanups", NM="_ZN5clang16ExprWithCleanupsC1EPNS_4ExprEbN4llvm8ArrayRefIPNS_9BlockDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanupsC1EPNS_4ExprEbN4llvm8ArrayRefIPNS_9BlockDeclEEE")
  //</editor-fold>
  private ExprWithCleanups(Expr /*P*/ subexpr, 
      boolean CleanupsHaveSideEffects, 
      ArrayRef<BlockDecl /*P*/ > objects) {
    // : Expr(ExprWithCleanupsClass, subexpr->getType(), subexpr->getValueKind(), subexpr->getObjectKind(), subexpr->isTypeDependent(), subexpr->isValueDependent(), subexpr->isInstantiationDependent(), subexpr->containsUnexpandedParameterPack()), TrailingObjects<ExprWithCleanups, BlockDecl * >(), SubExpr(subexpr) 
    //START JInit
    super(StmtClass.ExprWithCleanupsClass, subexpr.getType(), 
        subexpr.getValueKind(), subexpr.getObjectKind(), 
        subexpr.isTypeDependent(), subexpr.isValueDependent(), 
        subexpr.isInstantiationDependent(), 
        subexpr.containsUnexpandedParameterPack());
    $TrailingObjects();
    this.SubExpr = subexpr;
    //END JInit
    Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects = CleanupsHaveSideEffects;
    Unnamed_field.ExprWithCleanupsBits.NumObjects = $uint2uint_15bits(objects.size());
    for (/*uint*/int i = 0, e = objects.size(); i != e; ++i)  {
      getTrailingObjects(BlockDecl /*P*/.class).$set(i, objects.$at(i));
    }
  }

  
  /*friend  TrailingObjects<ExprWithCleanups, BlockDecl *>*/
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1054,
   FQN="clang::ExprWithCleanups::Create", NM="_ZN5clang16ExprWithCleanups6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanups6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  public static ExprWithCleanups /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        Stmt.EmptyShell empty, 
        /*uint*/int numObjects) {
    Object/*void P*/ buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(BlockDecl.class, numObjects), 
        alignOf(ExprWithCleanups.class));
    return /*NEW_EXPR [Stmt::new]*//*new (buffer)*/ Stmt.$new(buffer, (type$ptr<?> New$Mem)->{
        return new ExprWithCleanups(new Stmt.EmptyShell(empty), numObjects);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1040,
   FQN="clang::ExprWithCleanups::Create", NM="_ZN5clang16ExprWithCleanups6CreateERKNS_10ASTContextEPNS_4ExprEbN4llvm8ArrayRefIPNS_9BlockDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanups6CreateERKNS_10ASTContextEPNS_4ExprEbN4llvm8ArrayRefIPNS_9BlockDeclEEE")
  //</editor-fold>
  public static ExprWithCleanups /*P*/ Create(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ subexpr, 
        boolean CleanupsHaveSideEffects, 
        ArrayRef<BlockDecl /*P*/ > objects) {
    Object/*void P*/ buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(BlockDecl.class, objects.size()), 
        alignOf(ExprWithCleanups.class));
    return /*NEW_EXPR [Stmt::new]*//*new (buffer)*/ Stmt.$new(buffer, (type$ptr<?> New$Mem)->{
        return new ExprWithCleanups(subexpr, CleanupsHaveSideEffects, new ArrayRef<BlockDecl /*P*/ >(objects));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2964,
   FQN="clang::ExprWithCleanups::getObjects", NM="_ZNK5clang16ExprWithCleanups10getObjectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups10getObjectsEv")
  //</editor-fold>
  public ArrayRef<BlockDecl /*P*/ > getObjects() /*const*/ {
    return llvm.makeArrayRef(getTrailingObjects$Const(BlockDecl /*P*/.class), 
        getNumObjects());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getNumObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2969,
   FQN="clang::ExprWithCleanups::getNumObjects", NM="_ZNK5clang16ExprWithCleanups13getNumObjectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups13getNumObjectsEv")
  //</editor-fold>
  public /*uint*/int getNumObjects() /*const*/ {
    return Unnamed_field.ExprWithCleanupsBits.NumObjects;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2971,
   FQN="clang::ExprWithCleanups::getObject", NM="_ZNK5clang16ExprWithCleanups9getObjectEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups9getObjectEj")
  //</editor-fold>
  public BlockDecl /*P*/ getObject(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumObjects())) : "Index out of range";
    return getObjects().$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2976,
   FQN="clang::ExprWithCleanups::getSubExpr", NM="_ZN5clang16ExprWithCleanups10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanups10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(SubExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2977,
   FQN="clang::ExprWithCleanups::getSubExpr", NM="_ZNK5clang16ExprWithCleanups10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(SubExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::cleanupsHaveSideEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2978,
   FQN="clang::ExprWithCleanups::cleanupsHaveSideEffects", NM="_ZNK5clang16ExprWithCleanups23cleanupsHaveSideEffectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups23cleanupsHaveSideEffectsEv")
  //</editor-fold>
  public boolean cleanupsHaveSideEffects() /*const*/ {
    return Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects;
  }

  
  /// As with any mutator of the AST, be very careful
  /// when modifying an existing AST to preserve its invariants.
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::setSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2984,
   FQN="clang::ExprWithCleanups::setSubExpr", NM="_ZN5clang16ExprWithCleanups10setSubExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanups10setSubExprEPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(Expr /*P*/ E) {
    SubExpr = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2986,
   FQN="clang::ExprWithCleanups::getLocStart", NM="_ZNK5clang16ExprWithCleanups11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2989,
   FQN="clang::ExprWithCleanups::getLocEnd", NM="_ZNK5clang16ExprWithCleanups9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16ExprWithCleanups9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getLocEnd();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2992,
   FQN="clang::ExprWithCleanups::classof", NM="_ZN5clang16ExprWithCleanups7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanups7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ExprWithCleanupsClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ExprWithCleanups::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2997,
   FQN="clang::ExprWithCleanups::children", NM="_ZN5clang16ExprWithCleanups8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16ExprWithCleanups8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(create_type$ptr2ConstT(SubExpr))), new StmtIterator($AddrOf(create_type$ptr2ConstT(SubExpr).$add(1))));
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == BlockDecl.class;
    return 0;
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SubExpr=" + SubExpr // NOI18N
              + super.toString(); // NOI18N
  }
}
