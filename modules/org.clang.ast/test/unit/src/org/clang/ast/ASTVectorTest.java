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

import org.junit.Test;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.aliases.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTVectorTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -test=ASTVectorTest")
//</editor-fold>
public final class ASTVectorTest extends ADTSupportTestBase {

//JAVA: using namespace clang
//JAVA: namespace clang {
//JAVA: namespace ast {

//JAVA: namespace (anonymous) {
////<editor-fold defaultstate="collapsed" desc="clang::ast::(anonymous namespace)::ASTVectorTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp", line = 26,
// FQN="clang::ast::(anonymous namespace)::ASTVectorTest", NM="_ZN5clang3ast12_GLOBAL__N_113ASTVectorTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -nm=_ZN5clang3ast12_GLOBAL__N_113ASTVectorTestE")
////</editor-fold>
//public static class ASTVectorTest$1 implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast::(anonymous namespace)::ASTVectorTest::ASTVectorTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp", line = 28,
   FQN="clang::ast::(anonymous namespace)::ASTVectorTest::ASTVectorTest", NM="_ZN5clang3ast12_GLOBAL__N_113ASTVectorTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -nm=_ZN5clang3ast12_GLOBAL__N_113ASTVectorTestC1Ev")
  //</editor-fold>
  public ASTVectorTest() {
    // : Test(), FileMgrOpts(), FileMgr(FileMgrOpts), DiagID(new DiagnosticIDs()), Diags(DiagID, new DiagnosticOptions, new IgnoringDiagConsumer()), SourceMgr(Diags, FileMgr), LangOpts(), Idents(LangOpts, null), Sels(), Builtins(), Ctxt(LangOpts, SourceMgr, Idents, Sels, Builtins) 
    //START JInit
    super();
    this.FileMgrOpts = new FileSystemOptions();
    this.FileMgr = new FileManager(FileMgrOpts);
    this.DiagID = new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
    this.Diags = new DiagnosticsEngine(DiagID, new DiagnosticOptions(), new IgnoringDiagConsumer());
    this.SourceMgr = new SourceManager(Diags, FileMgr);
    this.LangOpts = new LangOptions();
    this.Idents = new IdentifierTable(LangOpts, (IdentifierInfoLookup /*P*/ )null);
    this.Sels = new SelectorTable();
    this.Builtins = new Builtin.Context();
    this.Ctxt = new ASTContext(LangOpts, SourceMgr, Idents, Sels, Builtins);
    //END JInit
  }

  
  protected FileSystemOptions FileMgrOpts;
  protected FileManager FileMgr;
  protected IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
  protected DiagnosticsEngine Diags;
  protected SourceManager SourceMgr;
  protected LangOptions LangOpts;
  protected IdentifierTable Idents;
  protected SelectorTable Sels;
  protected Builtin.Context Builtins;
  protected ASTContext Ctxt;
  //<editor-fold defaultstate="collapsed" desc="clang::ast::(anonymous namespace)::ASTVectorTest::~ASTVectorTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp", line = 26,
   FQN="clang::ast::(anonymous namespace)::ASTVectorTest::~ASTVectorTest", NM="_ZN5clang3ast12_GLOBAL__N_113ASTVectorTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -nm=_ZN5clang3ast12_GLOBAL__N_113ASTVectorTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy()/* throw()*/ {
    //START JDestroy
    Ctxt.$destroy();
    Sels.$destroy();
    Idents.$destroy();
    LangOpts.$destroy();
    SourceMgr.$destroy();
    Diags.$destroy();
    DiagID.$destroy();
    FileMgr.$destroy();
    FileMgrOpts.$destroy();
    //super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "FileMgrOpts=" + FileMgrOpts // NOI18N
              + ", FileMgr=" + "[FileManager]" // NOI18N
              + ", DiagID=" + DiagID // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", Idents=" + Idents // NOI18N
              + ", Sels=" + Sels // NOI18N
              + ", Builtins=" + "[Context]" // NOI18N
              + ", Ctxt=" + "[ASTContext]" // NOI18N
              + super.toString(); // NOI18N
  }
//}
//} JAVA: end of namespace (anonymous) // unnamed namespace
//;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast::ASTVectorTest_Compile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp", line = 47,
 FQN="clang::ast::ASTVectorTest_Compile_Test::TestBody", NM="_ZN5clang3ast26ASTVectorTest_Compile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -nm=_ZN5clang3ast26ASTVectorTest_Compile_Test8TestBodyEv")
//</editor-fold>
public void test_Compile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ASTVectorInt V/*J*/= new ASTVectorInt(0);
  V.insert(Ctxt, V.begin(), 0);
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast::ASTVectorTest_InsertFill_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp", line = 52,
 FQN="clang::ast::ASTVectorTest_InsertFill_Test::TestBody", NM="_ZN5clang3ast29ASTVectorTest_InsertFill_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -nm=_ZN5clang3ast29ASTVectorTest_InsertFill_Test8TestBodyEv")
//</editor-fold>
public void test_InsertFill() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ASTVectorInt V/*J*/= new ASTVectorInt(0);
  
  // Ensure returned iterator points to first of inserted elements
  int$ptr I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(Ctxt, V.begin(), 5, 1));
    EXPECT_EQ_PTR(V.begin(),I);
  
  // Check non-empty case as well
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(Ctxt, V.begin().$add(1), 5, 1));
    EXPECT_EQ_PTR(V.begin().$add(1),I);
  
  // And insert-at-end
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(Ctxt, V.end(), 5, 1));
    EXPECT_EQ_PTR(V.end().$sub(5),I);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Test
public void test_InsertFillContent() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ASTVectorInt V/*J*/= new ASTVectorInt(0);
  
  // Ensure returned iterator points to first of inserted elements
  int$ptr I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(Ctxt, V.begin(), 5, 1));
    EXPECT_EQ_PTR(V.begin(),I);
  
  // Check non-empty case as well
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(Ctxt, V.begin().$add(1), 5, 2));
    EXPECT_EQ_PTR(V.begin().$add(1),I);
  
  // And insert-at-end
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(Ctxt, V.end(), 5, 3));
    EXPECT_EQ_PTR(V.end().$sub(5),I);
    
  int GoldenPattern[] = new int[] {1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 3, 3, 3, 3, 3};
  EXPECT_EQ(GoldenPattern.length, V.size());
  for (int i = 0; i < GoldenPattern.length; ++i) {
    EXPECT_EQ(GoldenPattern[i], V.$at(i));
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="clang::ast::ASTVectorTest_InsertEmpty_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp", line = 68,
 FQN="clang::ast::ASTVectorTest_InsertEmpty_Test::TestBody", NM="_ZN5clang3ast30ASTVectorTest_InsertEmpty_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/AST/ASTVectorTest.cpp -nm=_ZN5clang3ast30ASTVectorTest_InsertEmpty_Test8TestBodyEv")
//</editor-fold>
public void test_InsertEmpty() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ASTVectorInt V/*J*/= new ASTVectorInt(0);
  
  // Ensure no pointer overflow when inserting empty range
  int Values[/*4*/] = new$int(4, 0, 1, 2, 3);
  ArrayRefInt IntVec/*J*/= new ArrayRefInt(Values);
  int$ptr I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_T(Ctxt, V.begin(), IntVec.begin(), IntVec.begin()));
    EXPECT_EQ_PTR(V.begin(),I);
    ASSERT_TRUE(V.empty());
  
  // Non-empty range
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_T(Ctxt, V.begin(), IntVec.begin(), IntVec.end()));
    EXPECT_EQ_PTR(V.begin(),I);
  
  // Non-Empty Vector, empty range
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_T(Ctxt, V.end(), IntVec.begin(), IntVec.begin()));
    EXPECT_EQ_PTR(V.begin().$add(IntVec.size()),I);
  
  // Non-Empty Vector, non-empty range
  I = $tryClone(V.insert_ASTContext$C_type$ptr$T$P_T(Ctxt, V.end(), IntVec.begin(), IntVec.end()));
    EXPECT_EQ_PTR(V.begin().$add(IntVec.size()),I);
}

//} JAVA: end of namespace ast // end namespace ast
//} JAVA: end of namespace clang
} // END OF class ASTVectorTest
