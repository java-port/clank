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
import org.junit.Test;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.ast_type_traits.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTTypeTraitsTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -test=ASTTypeTraitsTest")
//</editor-fold>
public final class ASTTypeTraitsTest extends ADTSupportTestBase {

//JAVA: using namespace clang::ast_matchers
//JAVA: namespace clang {
//JAVA: namespace ast_type_traits {
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_NoKind_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 20,
 FQN="clang::ast_type_traits::ASTNodeKind_NoKind_Test::TestBody", NM="_ZN5clang15ast_type_traits23ASTNodeKind_NoKind_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits23ASTNodeKind_NoKind_Test8TestBodyEv")
//</editor-fold>
public void test_NoKind() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(new ASTNodeKind().isBaseOf(new ASTNodeKind()));
    EXPECT_FALSE(new ASTNodeKind().isSame(new ASTNodeKind()));
}


/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 25,
 FQN="clang::ast_type_traits::DNT", NM="Tpl__ZN5clang15ast_type_traitsL3DNTEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=Tpl__ZN5clang15ast_type_traitsL3DNTEv")
//</editor-fold>
public static </*typename*/ T> ASTNodeKind DNT(Class<T> clazz) {
  return ASTNodeKind.<T>getFromNodeKind(clazz);
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_IsNone_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 29,
 FQN="clang::ast_type_traits::ASTNodeKind_IsNone_Test::TestBody", NM="_ZN5clang15ast_type_traits23ASTNodeKind_IsNone_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits23ASTNodeKind_IsNone_Test8TestBodyEv")
//</editor-fold>
public void test_IsNone() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(new ASTNodeKind().isNone());
    EXPECT_FALSE(DNT(Decl.class).isNone());
    EXPECT_FALSE(DNT(VarDecl.class).isNone());
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_Bases_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 35,
 FQN="clang::ast_type_traits::ASTNodeKind_Bases_Test::TestBody", NM="_ZN5clang15ast_type_traits22ASTNodeKind_Bases_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits22ASTNodeKind_Bases_Test8TestBodyEv")
//</editor-fold>
public void test_Bases() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(DNT(Decl.class).isBaseOf(DNT(VarDecl.class)));
    EXPECT_FALSE(DNT(Decl.class).isSame(DNT(VarDecl.class)));
    EXPECT_FALSE(DNT(VarDecl.class).isBaseOf(DNT(Decl.class)));
    EXPECT_TRUE(DNT(Decl.class).isSame(DNT(Decl.class)));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_BaseDistances_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 43,
 FQN="clang::ast_type_traits::ASTNodeKind_BaseDistances_Test::TestBody", NM="_ZN5clang15ast_type_traits30ASTNodeKind_BaseDistances_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits30ASTNodeKind_BaseDistances_Test8TestBodyEv")
//</editor-fold>
public void test_BaseDistances() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  uint$ptr Distance = create_uint$ptr(1);
    EXPECT_TRUE(DNT(Expr.class).isBaseOf(DNT(Expr.class), $AddrOf(Distance)));
    EXPECT_EQ(0/*U*/, Distance.$star());
    EXPECT_TRUE(DNT(Stmt.class).isBaseOf(DNT(IfStmt.class), $AddrOf(Distance)));
    EXPECT_EQ(1/*U*/,Distance.$star());
  
  Distance.$set(3);
    EXPECT_TRUE(DNT(DeclaratorDecl.class).isBaseOf(DNT(ParmVarDecl.class), $AddrOf(Distance)));
    EXPECT_EQ(2/*U*/,Distance.$star());
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_SameBase_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 56,
 FQN="clang::ast_type_traits::ASTNodeKind_SameBase_Test::TestBody", NM="_ZN5clang15ast_type_traits25ASTNodeKind_SameBase_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits25ASTNodeKind_SameBase_Test8TestBodyEv")
//</editor-fold>
public void test_SameBase() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(DNT(Expr.class).isBaseOf(DNT(CallExpr.class)));
    EXPECT_TRUE(DNT(Expr.class).isBaseOf(DNT(BinaryOperator.class)));
    EXPECT_FALSE(DNT(CallExpr.class).isBaseOf(DNT(BinaryOperator.class)));
    EXPECT_FALSE(DNT(BinaryOperator.class).isBaseOf(DNT(CallExpr.class)));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_DiffBase_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 63,
 FQN="clang::ast_type_traits::ASTNodeKind_DiffBase_Test::TestBody", NM="_ZN5clang15ast_type_traits25ASTNodeKind_DiffBase_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits25ASTNodeKind_DiffBase_Test8TestBodyEv")
//</editor-fold>
public void test_DiffBase() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(DNT(Expr.class).isBaseOf(DNT(ArrayType.class)));
    EXPECT_FALSE(DNT(QualType.class).isBaseOf(DNT(FunctionDecl.class)));
    EXPECT_FALSE(DNT(Type.class).isSame(DNT(QualType.class)));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_MostDerivedType_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 69,
 FQN="clang::ast_type_traits::ASTNodeKind_MostDerivedType_Test::TestBody", NM="_ZN5clang15ast_type_traits32ASTNodeKind_MostDerivedType_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits32ASTNodeKind_MostDerivedType_Test8TestBodyEv")
//</editor-fold>
public void test_MostDerivedType() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(DNT(BinaryOperator.class).isSame(ASTNodeKind.getMostDerivedType(DNT(Expr.class), DNT(BinaryOperator.class))));
    EXPECT_TRUE(DNT(BinaryOperator.class).isSame(ASTNodeKind.getMostDerivedType(DNT(BinaryOperator.class), DNT(Expr.class))));
    EXPECT_TRUE(DNT(VarDecl.class).isSame(ASTNodeKind.getMostDerivedType(DNT(VarDecl.class), DNT(VarDecl.class))));
    
    // Not related. Returns nothing.
    EXPECT_TRUE(ASTNodeKind.getMostDerivedType(DNT(IfStmt.class), DNT(VarDecl.class)).isNone());
    EXPECT_TRUE(ASTNodeKind.getMostDerivedType(DNT(IfStmt.class), DNT(BinaryOperator.class)).isNone());
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_MostDerivedCommonAncestor_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 84,
 FQN="clang::ast_type_traits::ASTNodeKind_MostDerivedCommonAncestor_Test::TestBody", NM="_ZN5clang15ast_type_traits42ASTNodeKind_MostDerivedCommonAncestor_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits42ASTNodeKind_MostDerivedCommonAncestor_Test8TestBodyEv")
//</editor-fold>
public void test_MostDerivedCommonAncestor() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(DNT(Expr.class).isSame(ASTNodeKind.getMostDerivedCommonAncestor(DNT(Expr.class), DNT(BinaryOperator.class))));
    EXPECT_TRUE(DNT(Expr.class).isSame(ASTNodeKind.getMostDerivedCommonAncestor(DNT(BinaryOperator.class), DNT(Expr.class))));
    EXPECT_TRUE(DNT(VarDecl.class).isSame(ASTNodeKind.getMostDerivedCommonAncestor(DNT(VarDecl.class), DNT(VarDecl.class))));
    
    // A little related. Returns the ancestor.
    EXPECT_TRUE(DNT(NamedDecl.class).isSame(ASTNodeKind.getMostDerivedCommonAncestor(DNT(CXXMethodDecl.class), DNT(RecordDecl.class))));
    
    // Not related. Returns nothing.
    EXPECT_TRUE(ASTNodeKind.getMostDerivedCommonAncestor(DNT(IfStmt.class), DNT(VarDecl.class)).isNone());
}


//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::Foo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 102,
 FQN="clang::ast_type_traits::Foo", NM="_ZN5clang15ast_type_traits3FooE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits3FooE")
//</editor-fold>
public static class/*struct*/ Foo {
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_UnknownKind_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 104,
 FQN="clang::ast_type_traits::ASTNodeKind_UnknownKind_Test::TestBody", NM="_ZN5clang15ast_type_traits28ASTNodeKind_UnknownKind_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits28ASTNodeKind_UnknownKind_Test8TestBodyEv")
//</editor-fold>
public void test_UnknownKind() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // JAVA: to be sure that all classes are registered we throw an exception if unknown class is used
  try {
    // We can construct one, but it is nowhere in the hierarchy.
    EXPECT_FALSE(DNT(Foo.class).isSame(DNT(Foo.class)));
    throw new llvm_unreachable("How it is possible?");
  } catch (Throwable thr) {
    EXPECT_TRUE(thr.getMessage().equals("not registered kind-id for class org.clang.ast.ASTTypeTraitsTest$Foo"));
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind_Name_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 109,
 FQN="clang::ast_type_traits::ASTNodeKind_Name_Test::TestBody", NM="_ZN5clang15ast_type_traits21ASTNodeKind_Name_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits21ASTNodeKind_Name_Test8TestBodyEv")
//</editor-fold>
public void test_Name() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("<None>",new ASTNodeKind().asStringRef());
    EXPECT_EQ("TemplateArgument",DNT(TemplateArgument.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("NestedNameSpecifierLoc",DNT(NestedNameSpecifierLoc.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("QualType",DNT(QualType.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("TypeLoc",DNT(TypeLoc.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("CXXCtorInitializer",DNT(CXXCtorInitializer.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("NestedNameSpecifier",DNT(NestedNameSpecifier.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("Decl",DNT(Decl.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("CXXRecordDecl",DNT(CXXRecordDecl.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("Stmt",DNT(Stmt.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("CallExpr",DNT(CallExpr.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("Type",DNT(Type.class).asStringRef());
  /*JSKIP;*/
    EXPECT_EQ("ConstantArrayType",DNT(ConstantArrayType.class).asStringRef());
  /*JSKIP;*/
}

;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_DeclSourceRange_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 127,
// FQN="clang::ast_type_traits::DynTypedNode_DeclSourceRange_Test::TestBody", NM="_ZN5clang15ast_type_traits33DynTypedNode_DeclSourceRange_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits33DynTypedNode_DeclSourceRange_Test8TestBodyEv")
////</editor-fold>
//public void test_DeclSourceRange() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  RangeVerifier<DynTypedNode> Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new RangeVerifier<DynTypedNode>();
//    Verifier.expectRange(1, 1, 1, 11);
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(decl.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_StmtSourceRange_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 133,
// FQN="clang::ast_type_traits::DynTypedNode_StmtSourceRange_Test::TestBody", NM="_ZN5clang15ast_type_traits33DynTypedNode_StmtSourceRange_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits33DynTypedNode_StmtSourceRange_Test8TestBodyEv")
////</editor-fold>
//public void test_StmtSourceRange() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  RangeVerifier<DynTypedNode> Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new RangeVerifier<DynTypedNode>();
//    Verifier.expectRange(1, 10, 1, 11);
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(stmt.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_TypeLocSourceRange_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 139,
// FQN="clang::ast_type_traits::DynTypedNode_TypeLocSourceRange_Test::TestBody", NM="_ZN5clang15ast_type_traits36DynTypedNode_TypeLocSourceRange_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits36DynTypedNode_TypeLocSourceRange_Test8TestBodyEv")
////</editor-fold>
//public void test_TypeLocSourceRange() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  RangeVerifier<DynTypedNode> Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new RangeVerifier<DynTypedNode>();
//    Verifier.expectRange(1, 1, 1, 8);
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(typeLoc.$call$T($c$.track(loc_Matcher$QualType$C($c$.track(new Matcher<QualType>($c$.track(functionType.$call()))))))))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_NNSLocSourceRange_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 145,
// FQN="clang::ast_type_traits::DynTypedNode_NNSLocSourceRange_Test::TestBody", NM="_ZN5clang15ast_type_traits35DynTypedNode_NNSLocSourceRange_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits35DynTypedNode_NNSLocSourceRange_Test8TestBodyEv")
////</editor-fold>
//public void test_NNSLocSourceRange() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  RangeVerifier<DynTypedNode> Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new RangeVerifier<DynTypedNode>();
//    Verifier.expectRange(1, 33, 1, 34);
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("namespace N { typedef void T; } N::T f() {}")), $c$.track(nestedNameSpecifierLoc.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_DeclDump_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 152,
// FQN="clang::ast_type_traits::DynTypedNode_DeclDump_Test::TestBody", NM="_ZN5clang15ast_type_traits26DynTypedNode_DeclDump_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits26DynTypedNode_DeclDump_Test8TestBodyEv")
////</editor-fold>
//public void test_DeclDump() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  DumpVerifier Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new DumpVerifier();
//    Verifier.expectSubstring($c$.track(new std.string($("FunctionDecl")))); $c$.clean();
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(functionDecl.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_StmtDump_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 158,
// FQN="clang::ast_type_traits::DynTypedNode_StmtDump_Test::TestBody", NM="_ZN5clang15ast_type_traits26DynTypedNode_StmtDump_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits26DynTypedNode_StmtDump_Test8TestBodyEv")
////</editor-fold>
//public void test_StmtDump() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  DumpVerifier Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new DumpVerifier();
//    Verifier.expectSubstring($c$.track(new std.string($("CompoundStmt")))); $c$.clean();
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(stmt.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_DeclPrint_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 164,
// FQN="clang::ast_type_traits::DynTypedNode_DeclPrint_Test::TestBody", NM="_ZN5clang15ast_type_traits27DynTypedNode_DeclPrint_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits27DynTypedNode_DeclPrint_Test8TestBodyEv")
////</editor-fold>
//public void test_DeclPrint() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  PrintVerifier Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new PrintVerifier();
//    Verifier.expectString($c$.track(new std.string($("void f() {\n}\n\n")))); $c$.clean();
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(functionDecl.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_StmtPrint_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 170,
// FQN="clang::ast_type_traits::DynTypedNode_StmtPrint_Test::TestBody", NM="_ZN5clang15ast_type_traits27DynTypedNode_StmtPrint_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits27DynTypedNode_StmtPrint_Test8TestBodyEv")
////</editor-fold>
//public void test_StmtPrint() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  PrintVerifier Verifier = null;
//  JavaCleaner $c$ = $createJavaCleaner();
//  try {
//    Verifier/*J*/= new PrintVerifier();
//    Verifier.expectString($c$.track(new std.string($("{\n}\n")))); $c$.clean();
//    EXPECT_TRUE($c$.track(Verifier.match_string$C_T$C$R($c$.track(new std.string("void f() {}")), $c$.track(stmt.$call()))));
//  } finally {
//    if (Verifier != null) { Verifier.$destroy(); }
//    $c$.$destroy();
//  }
//}
//
//;
//@Test
////<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode_QualType_Test::TestBody">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp", line = 176,
// FQN="clang::ast_type_traits::DynTypedNode_QualType_Test::TestBody", NM="_ZN5clang15ast_type_traits26DynTypedNode_QualType_Test8TestBodyEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTTypeTraitsTest.cpp -nm=_ZN5clang15ast_type_traits26DynTypedNode_QualType_Test8TestBodyEv")
////</editor-fold>
//public void test_QualType() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  QualType Q/*J*/= new QualType();
//  DynTypedNode Node = DynTypedNode.create(Q);
//    EXPECT_TRUE(Node.$eq(Node));
//    EXPECT_FALSE(Node.$less(Node));
//}

//} JAVA: end of namespace ast_type_traits // namespace ast_type_traits
//} JAVA: end of namespace clang
} // END OF class ASTTypeTraitsTest
