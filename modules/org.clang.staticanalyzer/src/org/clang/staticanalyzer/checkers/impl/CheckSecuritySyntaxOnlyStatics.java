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
package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerMemberPointers.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.QualType.*;


//<editor-fold defaultstate="collapsed" desc="static type CheckSecuritySyntaxOnlyStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZL17getIncrementedVarPKN5clang4ExprEPKNS_7VarDeclES5_;_ZL21isArc4RandomAvailableRKN5clang10ASTContextE;_ZN12_GLOBAL__N_112ChecksFilterE;_ZN12_GLOBAL__N_17WalkASTE; -static-type=CheckSecuritySyntaxOnlyStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class CheckSecuritySyntaxOnlyStatics {

//<editor-fold defaultstate="collapsed" desc="isArc4RandomAvailable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 28,
 FQN="isArc4RandomAvailable", NM="_ZL21isArc4RandomAvailableRKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZL21isArc4RandomAvailableRKN5clang10ASTContextE")
//</editor-fold>
public static boolean isArc4RandomAvailable(final /*const*/ ASTContext /*&*/ Ctx) {
  final /*const*/ Triple /*&*/ T = Ctx.getTargetInfo().getTriple();
  return T.getVendor() == Triple.VendorType.Apple
     || T.getOS() == Triple.OSType.CloudABI
     || T.getOS() == Triple.OSType.FreeBSD
     || T.getOS() == Triple.OSType.NetBSD
     || T.getOS() == Triple.OSType.OpenBSD
     || T.getOS() == Triple.OSType.Bitrig
     || T.getOS() == Triple.OSType.DragonFly;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChecksFilter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 40,
 FQN="(anonymous namespace)::ChecksFilter", NM="_ZN12_GLOBAL__N_112ChecksFilterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_112ChecksFilterE")
//</editor-fold>
public static class/*struct*/ ChecksFilter {
  public DefaultBool check_gets;
  public DefaultBool check_getpw;
  public DefaultBool check_mktemp;
  public DefaultBool check_mkstemp;
  public DefaultBool check_strcpy;
  public DefaultBool check_rand;
  public DefaultBool check_vfork;
  public DefaultBool check_FloatLoopCounter;
  public DefaultBool check_UncheckedReturn;
  
  public CheckName checkName_gets;
  public CheckName checkName_getpw;
  public CheckName checkName_mktemp;
  public CheckName checkName_mkstemp;
  public CheckName checkName_strcpy;
  public CheckName checkName_rand;
  public CheckName checkName_vfork;
  public CheckName checkName_FloatLoopCounter;
  public CheckName checkName_UncheckedReturn;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChecksFilter::ChecksFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 40,
   FQN="(anonymous namespace)::ChecksFilter::ChecksFilter", NM="_ZN12_GLOBAL__N_112ChecksFilterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_112ChecksFilterC1Ev")
  //</editor-fold>
  public /*inline*/ ChecksFilter() {
    // : check_gets(), check_getpw(), check_mktemp(), check_mkstemp(), check_strcpy(), check_rand(), check_vfork(), check_FloatLoopCounter(), check_UncheckedReturn(), checkName_gets(), checkName_getpw(), checkName_mktemp(), checkName_mkstemp(), checkName_strcpy(), checkName_rand(), checkName_vfork(), checkName_FloatLoopCounter(), checkName_UncheckedReturn() 
    //START JInit
    this.check_gets = new DefaultBool();
    this.check_getpw = new DefaultBool();
    this.check_mktemp = new DefaultBool();
    this.check_mkstemp = new DefaultBool();
    this.check_strcpy = new DefaultBool();
    this.check_rand = new DefaultBool();
    this.check_vfork = new DefaultBool();
    this.check_FloatLoopCounter = new DefaultBool();
    this.check_UncheckedReturn = new DefaultBool();
    this.checkName_gets = new CheckName();
    this.checkName_getpw = new CheckName();
    this.checkName_mktemp = new CheckName();
    this.checkName_mkstemp = new CheckName();
    this.checkName_strcpy = new CheckName();
    this.checkName_rand = new CheckName();
    this.checkName_vfork = new CheckName();
    this.checkName_FloatLoopCounter = new CheckName();
    this.checkName_UncheckedReturn = new CheckName();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "check_gets=" + check_gets // NOI18N
              + ", check_getpw=" + check_getpw // NOI18N
              + ", check_mktemp=" + check_mktemp // NOI18N
              + ", check_mkstemp=" + check_mkstemp // NOI18N
              + ", check_strcpy=" + check_strcpy // NOI18N
              + ", check_rand=" + check_rand // NOI18N
              + ", check_vfork=" + check_vfork // NOI18N
              + ", check_FloatLoopCounter=" + check_FloatLoopCounter // NOI18N
              + ", check_UncheckedReturn=" + check_UncheckedReturn // NOI18N
              + ", checkName_gets=" + checkName_gets // NOI18N
              + ", checkName_getpw=" + checkName_getpw // NOI18N
              + ", checkName_mktemp=" + checkName_mktemp // NOI18N
              + ", checkName_mkstemp=" + checkName_mkstemp // NOI18N
              + ", checkName_strcpy=" + checkName_strcpy // NOI18N
              + ", checkName_rand=" + checkName_rand // NOI18N
              + ", checkName_vfork=" + checkName_vfork // NOI18N
              + ", checkName_FloatLoopCounter=" + checkName_FloatLoopCounter // NOI18N
              + ", checkName_UncheckedReturn=" + checkName_UncheckedReturn; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // http://redbox.ru.oracle.com/bugzilla/show_bug.cgi?id=375
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 62,
 FQN="(anonymous namespace)::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE")
//</editor-fold>
public static class WalkAST implements /*public*/ StmtVisitorVoid<WalkAST> {
  private final BugReporter /*&*/ BR;
  private AnalysisDeclContext /*P*/ AC;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 65,
   FQN="(anonymous namespace)::WalkAST::(anonymous)", NM="_ZN12_GLOBAL__N_17WalkASTE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int num_setids = 6;
  /*}*/;
  private IdentifierInfo /*P*/ II_setid[/*6*/] = new IdentifierInfo /*P*/  [6];
  
  private /*const*/boolean CheckRand;
  private final /*const*/ ChecksFilter /*&*/ filter;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::WalkAST">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 72,
   FQN="(anonymous namespace)::WalkAST::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTC1ERN5clang4ento11BugReporterEPNS1_19AnalysisDeclContextERKNS_12ChecksFilterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkASTC1ERN5clang4ento11BugReporterEPNS1_19AnalysisDeclContextERKNS_12ChecksFilterE")
  //</editor-fold>
  public WalkAST(final BugReporter /*&*/ br, AnalysisDeclContext /*P*/ ac, 
      final /*const*/ ChecksFilter /*&*/ f) {
    // : StmtVisitor<WalkAST>(), BR(br), AC(ac), II_setid(implicit IdentifierInfo * [6]()), CheckRand(isArc4RandomAvailable(BR.getContext())), filter(f) 
    //START JInit
    $StmtVisitor();
    this./*&*/BR=/*&*/br;
    this.AC = ac;
    this.II_setid = /*implicit-init*/new IdentifierInfo /*P*/  [6];// {/*zero-init*/0};
    this.CheckRand = isArc4RandomAvailable(BR.getContext());
    this./*&*/filter=/*&*/f;
    //END JInit
  }

  
  // Statement visitor methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 116,
   FQN="(anonymous namespace)::WalkAST::VisitCallExpr", NM="_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    // Get the callee.
    /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee();
    if (!(FD != null)) {
      return;
    }
    
    // Get the name of the callee. If it's a builtin, strip off the prefix.
    IdentifierInfo /*P*/ II = FD.getIdentifier();
    if (!(II != null)) { // if no identifier, not a simple C function
      return;
    }
    StringRef Name = II.getName();
    if (Name.startswith(/*STRINGREF_STR*/"__builtin_")) {
      Name.$assignMove(Name.substr(10));
    }
    
    // Set the evaluation function by switching on the callee name.
    WalkAST$FnCheck evalFunction = new StringSwitch<WalkAST$FnCheck>(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"gets", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_gets(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"getpw", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_getpw(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"mktemp", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_mktemp(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"mkstemp", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_mkstemp(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"mkdtemp", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_mkstemp(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"mkstemps", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_mkstemp(callExpr, funDecl); }).
        Cases(/*KEEP_STR*/"strcpy", /*KEEP_STR*/"__strcpy_chk", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_strcpy(callExpr, funDecl); }).
        Cases(/*KEEP_STR*/"strcat", /*KEEP_STR*/"__strcat_chk", /*AddrOf*//*FPtr*/(WalkAST$FnCheck) (CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_strcat(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"drand48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"erand48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"jrand48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"lrand48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"mrand48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"nrand48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"lcong48", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"rand", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"rand_r", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_rand(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"random", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_random(callExpr, funDecl); }).
        Case(/*KEEP_STR*/"vfork", /*AddrOf*//*FPtr*/(CallExpr callExpr, FunctionDecl funDecl) -> { checkCall_vfork(callExpr, funDecl); }).
        Default((WalkAST$FnCheck)null);
    
    // If the callee isn't defined, it is not of security concern.
    // Check and evaluate the call.
    if ((evalFunction != null)) {
      evalFunction.$call(/*PtrMemI this,*/ CE, FD);
    }
    
    // Recurse and check children.
    VisitChildren(CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 172,
   FQN="(anonymous namespace)::WalkAST::VisitForStmt", NM="_ZN12_GLOBAL__N_17WalkAST12VisitForStmtEPN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST12VisitForStmtEPN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(ForStmt /*P*/ FS) {
    checkLoopConditionForFloat(FS);
    
    // Recurse and check children.
    VisitChildren(FS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 163,
   FQN="(anonymous namespace)::WalkAST::VisitCompoundStmt", NM="_ZN12_GLOBAL__N_17WalkAST17VisitCompoundStmtEPN5clang12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST17VisitCompoundStmtEPN5clang12CompoundStmtE")
  //</editor-fold>
  public void VisitCompoundStmt(CompoundStmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        {
          CallExpr /*P*/ CE = dyn_cast_CallExpr(Child);
          if ((CE != null)) {
            checkUncheckedReturnValue(CE);
          }
        }
        Visit(Child);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 82,
   FQN="(anonymous namespace)::WalkAST::VisitStmt", NM="_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  
  // end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // AST walking.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 110,
   FQN="(anonymous namespace)::WalkAST::VisitChildren", NM="_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  
  // Helpers.
  
  //===----------------------------------------------------------------------===//
  // Common check for str* functions with no bounds parameters.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_strCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 558,
   FQN="(anonymous namespace)::WalkAST::checkCall_strCommon", NM="_ZN12_GLOBAL__N_17WalkAST19checkCall_strCommonEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST19checkCall_strCommonEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public boolean checkCall_strCommon(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!(FPT != null)) {
      return false;
    }
    
    // Verify the function takes two arguments, three in the _chk version.
    int numArgs = FPT.getNumParams();
    if (numArgs != 2 && numArgs != 3) {
      return false;
    }
    
    // Verify the type for both arguments.
    for (int i = 0; i < 2; i++) {
      // Verify that the arguments are pointers.
      /*const*/ PointerType /*P*/ PT = FPT.getParamType(i).$arrow().getAs(PointerType.class);
      if (!(PT != null)) {
        return false;
      }
      
      // Verify that the argument is a 'char*'.
      if ($noteq_QualType$C(PT.getPointeeType().getUnqualifiedType(), BR.getContext().CharTy.$QualType())) {
        return false;
      }
    }
    
    return true;
  }

  
  /*typedef void (WalkAST::*FnCheck)(const CallExpr *, const FunctionDecl *)*/
//  public final class FnCheck extends WalkAST$FnCheck{ };
  
  // Checker-specific methods.
  
  /// CheckLoopConditionForFloat - This check looks for 'for' statements that
  ///  use a floating point variable as a loop counter.
  ///  CERT: FLP30-C, FLP30-CPP.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkLoopConditionForFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 219,
   FQN="(anonymous namespace)::WalkAST::checkLoopConditionForFloat", NM="_ZN12_GLOBAL__N_17WalkAST26checkLoopConditionForFloatEPKN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST26checkLoopConditionForFloatEPKN5clang7ForStmtE")
  //</editor-fold>
  public void checkLoopConditionForFloat(/*const*/ ForStmt /*P*/ FS) {
    raw_svector_ostream os = null;
    try {
      if (!filter.check_FloatLoopCounter.$ConstBoolRef()) {
        return;
      }
      
      // Does the loop have a condition?
      /*const*/ Expr /*P*/ condition = FS.getCond$Const();
      if (!(condition != null)) {
        return;
      }
      
      // Does the loop have an increment?
      /*const*/ Expr /*P*/ increment = FS.getInc$Const();
      if (!(increment != null)) {
        return;
      }
      
      // Strip away '()' and casts.
      condition = condition.IgnoreParenCasts$Const();
      increment = increment.IgnoreParenCasts$Const();
      
      // Is the loop condition a comparison?
      /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(condition);
      if (!(B != null)) {
        return;
      }
      
      // Is this a comparison?
      if (!(B.isRelationalOp() || B.isEqualityOp())) {
        return;
      }
      
      // Are we comparing variables?
      /*const*/ DeclRefExpr /*P*/ drLHS = dyn_cast_DeclRefExpr(B.getLHS().IgnoreParenLValueCasts());
      /*const*/ DeclRefExpr /*P*/ drRHS = dyn_cast_DeclRefExpr(B.getRHS().IgnoreParenLValueCasts());
      
      // Does at least one of the variables have a floating point type?
      drLHS = (drLHS != null) && drLHS.getType().$arrow().isRealFloatingType() ? drLHS : null;
      drRHS = (drRHS != null) && drRHS.getType().$arrow().isRealFloatingType() ? drRHS : null;
      if (!(drLHS != null) && !(drRHS != null)) {
        return;
      }
      
      /*const*/ VarDecl /*P*/ vdLHS = (drLHS != null) ? dyn_cast_VarDecl(drLHS.getDecl$Const()) : null;
      /*const*/ VarDecl /*P*/ vdRHS = (drRHS != null) ? dyn_cast_VarDecl(drRHS.getDecl$Const()) : null;
      if (!(vdLHS != null) && !(vdRHS != null)) {
        return;
      }
      
      // Does either variable appear in increment?
      /*const*/ DeclRefExpr /*P*/ drInc = getIncrementedVar(increment, vdLHS, vdRHS);
      if (!(drInc != null)) {
        return;
      }
      
      // Emit the error.  First figure out which DeclRefExpr in the condition
      // referenced the compared variable.
      assert Native.$bool(drInc.getDecl$Const());
      /*const*/ DeclRefExpr /*P*/ drCond = vdLHS == drInc.getDecl$Const() ? drLHS : drRHS;
      
      SmallVector<SourceRange> ranges/*J*/= new SmallVector<SourceRange>(2, SourceRange.EMPTY);
      SmallString/*256*/ sbuf/*J*/= new SmallString/*256*/(256);
      os/*J*/= new raw_svector_ostream(sbuf);
      
      os.$out(/*KEEP_STR*/"Variable '").$out(drCond.getDecl$Const().getName()).$out(
          /*KEEP_STR*/"' with floating point type '"
      ).$out(drCond.getType().getAsString()).$out(
          /*KEEP_STR*/"' should not be used as a loop counter"
      );
      
      ranges.push_back(drCond.getSourceRange());
      ranges.push_back(drInc.getSourceRange());
      
      /*const*/char$ptr/*char P*/ bugType = $("Floating point variable used as loop counter");
      
      PathDiagnosticLocation FSLoc = PathDiagnosticLocation.createBegin(FS, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_FloatLoopCounter), 
          new StringRef(bugType), new StringRef(/*KEEP_STR*/"Security"), os.str(), 
          new PathDiagnosticLocation(FSLoc), new ArrayRef<SourceRange>(ranges, false));
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Any use of 'gets' is insecure.
  // Originally: <rdar://problem/6335715>
  // Implements (part of): 300-BSI (buildsecurityin.us-cert.gov)
  // CWE-242: Use of Inherently Dangerous Function
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_gets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 306,
   FQN="(anonymous namespace)::WalkAST::checkCall_gets", NM="_ZN12_GLOBAL__N_17WalkAST14checkCall_getsEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST14checkCall_getsEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_gets(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!filter.check_gets.$ConstBoolRef()) {
      return;
    }
    
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!(FPT != null)) {
      return;
    }
    
    // Verify that the function takes a single argument.
    if (FPT.getNumParams() != 1) {
      return;
    }
    
    // Is the argument a 'char*'?
    /*const*/ PointerType /*P*/ PT = FPT.getParamType(0).$arrow().getAs(PointerType.class);
    if (!(PT != null)) {
      return;
    }
    if ($noteq_QualType$C(PT.getPointeeType().getUnqualifiedType(), BR.getContext().CharTy.$QualType())) {
      return;
    }
    
    // Issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_gets), 
        new StringRef(/*KEEP_STR*/"Potential buffer overflow in call to 'gets'"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"Call to function 'gets' is extremely insecure as it can always result in a buffer overflow"), 
        new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Any use of 'getpwd' is insecure.
  // CWE-477: Use of Obsolete Functions
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_getpw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 342,
   FQN="(anonymous namespace)::WalkAST::checkCall_getpw", NM="_ZN12_GLOBAL__N_17WalkAST15checkCall_getpwEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST15checkCall_getpwEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_getpw(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!filter.check_getpw.$ConstBoolRef()) {
      return;
    }
    
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!(FPT != null)) {
      return;
    }
    
    // Verify that the function takes two arguments.
    if (FPT.getNumParams() != 2) {
      return;
    }
    
    // Verify the first argument type is integer.
    if (!FPT.getParamType(0).$arrow().isIntegralOrUnscopedEnumerationType()) {
      return;
    }
    
    // Verify the second argument type is char*.
    /*const*/ PointerType /*P*/ PT = FPT.getParamType(1).$arrow().getAs(PointerType.class);
    if (!(PT != null)) {
      return;
    }
    if ($noteq_QualType$C(PT.getPointeeType().getUnqualifiedType(), BR.getContext().CharTy.$QualType())) {
      return;
    }
    
    // Issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_getpw), 
        new StringRef(/*KEEP_STR*/"Potential buffer overflow in call to 'getpw'"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"The getpw() function is dangerous as it may overflow the provided buffer. It is obsoleted by getpwuid()."), 
        new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Any use of 'mktemp' is insecure.  It is obsoleted by mkstemp().
  // CWE-377: Insecure Temporary File
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_mktemp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 382,
   FQN="(anonymous namespace)::WalkAST::checkCall_mktemp", NM="_ZN12_GLOBAL__N_17WalkAST16checkCall_mktempEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST16checkCall_mktempEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_mktemp(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!filter.check_mktemp.$ConstBoolRef()) {
      // Fall back to the security check of looking for enough 'X's in the
      // format string, since that is a less severe warning.
      checkCall_mkstemp(CE, FD);
      return;
    }
    
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!(FPT != null)) {
      return;
    }
    
    // Verify that the function takes a single argument.
    if (FPT.getNumParams() != 1) {
      return;
    }
    
    // Verify that the argument is Pointer Type.
    /*const*/ PointerType /*P*/ PT = FPT.getParamType(0).$arrow().getAs(PointerType.class);
    if (!(PT != null)) {
      return;
    }
    
    // Verify that the argument is a 'char*'.
    if ($noteq_QualType$C(PT.getPointeeType().getUnqualifiedType(), BR.getContext().CharTy.$QualType())) {
      return;
    }
    
    // Issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_mktemp), 
        new StringRef(/*KEEP_STR*/"Potential insecure temporary file in call 'mktemp'"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"Call to function 'mktemp' is insecure as it always creates or uses insecure temporary file.  Use 'mkstemp' instead"), 
        new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Use of 'mkstemp', 'mktemp', 'mkdtemp' should contain at least 6 X's.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_mkstemp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 424,
   FQN="(anonymous namespace)::WalkAST::checkCall_mkstemp", NM="_ZN12_GLOBAL__N_17WalkAST17checkCall_mkstempEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST17checkCall_mkstempEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_mkstemp(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    raw_svector_ostream out = null;
    try {
      if (!filter.check_mkstemp.$ConstBoolRef()) {
        return;
      }
      
      StringRef Name = FD.getIdentifier().getName();
      std.pairIntInt ArgSuffix = new StringSwitch<std.pairIntInt>(/*NO_COPY*/Name).
          Case(/*KEEP_STR*/"mktemp", std.make_pair_int_int(0, -1)).
          Case(/*KEEP_STR*/"mkstemp", std.make_pair_int_int(0, -1)).
          Case(/*KEEP_STR*/"mkdtemp", std.make_pair_int_int(0, -1)).
          Case(/*KEEP_STR*/"mkstemps", std.make_pair_int_int(0, 1)).
          Default(std.make_pair_int_int(-1, -1));
      assert (ArgSuffix.first >= 0) : "Unsupported function";
      
      // Check if the number of arguments is consistent with out expectations.
      /*uint*/int numArgs = CE.getNumArgs();
      if ((int)numArgs <= ArgSuffix.first) {
        return;
      }
      
      /*const*/ StringLiteral /*P*/ strArg = dyn_cast_StringLiteral(CE.getArg$Const((/*uint*/int)ArgSuffix.first).
    IgnoreParenImpCasts$Const());
      
      // Currently we only handle string literals.  It is possible to do better,
      // either by looking at references to const variables, or by doing real
      // flow analysis.
      if (!(strArg != null) || strArg.getCharByteWidth() != 1) {
        return;
      }
      
      // Count the number of X's, taking into account a possible cutoff suffix.
      StringRef str = strArg.getString();
      /*uint*/int numX = 0;
      /*uint*/int n = str.size();
      
      // Take into account the suffix.
      /*uint*/int suffix = 0;
      if (ArgSuffix.second >= 0) {
        /*const*/ Expr /*P*/ suffixEx = CE.getArg$Const((/*uint*/int)ArgSuffix.second);
        APSInt Result/*J*/= new APSInt();
        if (!suffixEx.EvaluateAsInt(Result, BR.getContext())) {
          return;
        }
        // FIXME: Issue a warning.
        if (Result.isNegative()) {
          return;
        }
        suffix = (/*uint*/int)$ulong2uint(Result.getZExtValue());
        n = ($greater_uint(n, suffix)) ? n - suffix : 0;
      }
      
      for (/*uint*/int i = 0; $less_uint(i, n); ++i)  {
        if (str.$at(i) == $$X) {
          ++numX;
        }
      }
      if ($greatereq_uint(numX, 6)) {
        return;
      }
      
      // Issue a warning.
      PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      SmallString/*512*/ buf/*J*/= new SmallString/*512*/(512);
      out/*J*/= new raw_svector_ostream(buf);
      out.$out(/*KEEP_STR*/"Call to '").$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/"' should have at least 6 'X's in the format string to be secure (").$out_uint(numX).$out(/*KEEP_STR*/" 'X'");
      if (numX != 1) {
        out.$out_char($$s);
      }
      out.$out(/*KEEP_STR*/" seen");
      if ((suffix != 0)) {
        out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(suffix).$out(/*KEEP_STR*/" character");
        if ($greater_uint(suffix, 1)) {
          out.$out_char($$s);
        }
        out.$out(/*KEEP_STR*/" used as a suffix");
      }
      out.$out_char($$RPAREN);
      BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_mkstemp), 
          new StringRef(/*KEEP_STR*/"Insecure temporary file creation"), new StringRef(/*KEEP_STR*/"Security"), 
          out.str(), new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(strArg.getSourceRange(), false));
    } finally {
      if (out != null) { out.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Any use of 'strcpy' is insecure.
  //
  // CWE-119: Improper Restriction of Operations within
  // the Bounds of a Memory Buffer
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_strcpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 507,
   FQN="(anonymous namespace)::WalkAST::checkCall_strcpy", NM="_ZN12_GLOBAL__N_17WalkAST16checkCall_strcpyEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST16checkCall_strcpyEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_strcpy(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!filter.check_strcpy.$ConstBoolRef()) {
      return;
    }
    if (!checkCall_strCommon(CE, FD)) {
      return;
    }
    
    // Issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_strcpy), 
        new StringRef(/*KEEP_STR*/"Potential insecure memory buffer bounds restriction in call 'strcpy'"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"Call to function 'strcpy' is insecure as it does not provide bounding of the memory buffer. Replace unbounded copy functions with analogous functions that support length arguments such as 'strlcpy'. CWE-119."), 
        new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Any use of 'strcat' is insecure.
  //
  // CWE-119: Improper Restriction of Operations within
  // the Bounds of a Memory Buffer
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_strcat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 534,
   FQN="(anonymous namespace)::WalkAST::checkCall_strcat", NM="_ZN12_GLOBAL__N_17WalkAST16checkCall_strcatEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST16checkCall_strcatEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_strcat(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!filter.check_strcpy.$ConstBoolRef()) {
      return;
    }
    if (!checkCall_strCommon(CE, FD)) {
      return;
    }
    
    // Issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_strcpy), 
        new StringRef(/*KEEP_STR*/"Potential insecure memory buffer bounds restriction in call 'strcat'"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"Call to function 'strcat' is insecure as it does not provide bounding of the memory buffer. Replace unbounded copy functions with analogous functions that support length arguments such as 'strlcat'. CWE-119."), 
        new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Linear congruent random number generators should not be used
  // Originally: <rdar://problem/63371000>
  // CWE-338: Use of cryptographically weak prng
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_rand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 589,
   FQN="(anonymous namespace)::WalkAST::checkCall_rand", NM="_ZN12_GLOBAL__N_17WalkAST14checkCall_randEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST14checkCall_randEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_rand(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    raw_svector_ostream os1 = null;
    raw_svector_ostream os2 = null;
    try {
      if (!filter.check_rand.$ConstBoolRef() || !CheckRand) {
        return;
      }
      
      /*const*/ FunctionProtoType /*P*/ FTP = FD.getType().$arrow().getAs(FunctionProtoType.class);
      if (!(FTP != null)) {
        return;
      }
      if (FTP.getNumParams() == 1) {
        // Is the argument an 'unsigned short *'?
        // (Actually any integer type is allowed.)
        /*const*/ PointerType /*P*/ PT = FTP.getParamType(0).$arrow().getAs(PointerType.class);
        if (!(PT != null)) {
          return;
        }
        if (!PT.getPointeeType().$arrow().isIntegralOrUnscopedEnumerationType()) {
          return;
        }
      } else if (FTP.getNumParams() != 0) {
        return;
      }
      
      // Issue a warning.
      SmallString/*256*/ buf1/*J*/= new SmallString/*256*/(256);
      os1/*J*/= new raw_svector_ostream(buf1);
      $out_raw_ostream_NamedDecl$C(os1.$out_char($$SGL_QUOTE), $Deref(FD)).$out(/*KEEP_STR*/"' is a poor random number generator");
      
      SmallString/*256*/ buf2/*J*/= new SmallString/*256*/(256);
      os2/*J*/= new raw_svector_ostream(buf2);
      $out_raw_ostream_NamedDecl$C(os2.$out(/*KEEP_STR*/"Function '"), $Deref(FD)).$out(
          /*KEEP_STR*/"' is obsolete because it implements a poor random number generator."
      ).$out(
          /*KEEP_STR*/"  Use 'arc4random' instead"
      );
      
      PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_rand), os1.str(), 
          new StringRef(/*KEEP_STR*/"Security"), os2.str(), new PathDiagnosticLocation(CELoc), 
          new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
    } finally {
      if (os2 != null) { os2.$destroy(); }
      if (os1 != null) { os1.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Check: 'random' should not be used
  // Originally: <rdar://problem/63371000>
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_random">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 632,
   FQN="(anonymous namespace)::WalkAST::checkCall_random", NM="_ZN12_GLOBAL__N_17WalkAST16checkCall_randomEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST16checkCall_randomEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_random(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!CheckRand || !filter.check_rand.$ConstBoolRef()) {
      return;
    }
    
    /*const*/ FunctionProtoType /*P*/ FTP = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!(FTP != null)) {
      return;
    }
    
    // Verify that the function takes no argument.
    if (FTP.getNumParams() != 0) {
      return;
    }
    
    // Issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_rand), 
        new StringRef(/*KEEP_STR*/"'random' is not a secure random number generator"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"The 'random' function produces a sequence of values that an adversary may be able to predict.  Use 'arc4random' instead"), new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: 'vfork' should not be used.
  // POS33-C: Do not use vfork().
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkCall_vfork">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 660,
   FQN="(anonymous namespace)::WalkAST::checkCall_vfork", NM="_ZN12_GLOBAL__N_17WalkAST15checkCall_vforkEPKN5clang8CallExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST15checkCall_vforkEPKN5clang8CallExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  public void checkCall_vfork(/*const*/ CallExpr /*P*/ CE, /*const*/ FunctionDecl /*P*/ FD) {
    if (!filter.check_vfork.$ConstBoolRef()) {
      return;
    }
    
    // All calls to vfork() are insecure, issue a warning.
    PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
    BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_vfork), 
        new StringRef(/*KEEP_STR*/"Potential insecure implementation-specific behavior in call 'vfork'"), 
        new StringRef(/*KEEP_STR*/"Security"), 
        new StringRef(/*KEEP_STR*/"Call to function 'vfork' is insecure as it can lead to denial of service situations in the parent process. Replace calls to vfork with calls to the safer 'posix_spawn' function"), 
        new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(CE.getCallee$Const().getSourceRange(), false));
  }

  
  //===----------------------------------------------------------------------===//
  // Check: Should check whether privileges are dropped successfully.
  // Originally: <rdar://problem/6337132>
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::checkUncheckedReturnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 683,
   FQN="(anonymous namespace)::WalkAST::checkUncheckedReturnValue", NM="_ZN12_GLOBAL__N_17WalkAST25checkUncheckedReturnValueEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN12_GLOBAL__N_17WalkAST25checkUncheckedReturnValueEPN5clang8CallExprE")
  //</editor-fold>
  public void checkUncheckedReturnValue(CallExpr /*P*/ CE) {
    raw_svector_ostream os1 = null;
    raw_svector_ostream os2 = null;
    try {
      if (!filter.check_UncheckedReturn.$ConstBoolRef()) {
        return;
      }
      
      /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee();
      if (!(FD != null)) {
        return;
      }
      if (II_setid[0] == null) {
        final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[6]*/> identifiers = checkUncheckedReturnValue$$.identifiers;
        
        for (/*size_t*/int i = 0; $less_uint(i, num_setids); i++)  {
          II_setid[i] = $AddrOf(BR.getContext().Idents.get(new StringRef(identifiers.$at(i))));
        }
      }
      
      /*const*/ IdentifierInfo /*P*/ id = FD.getIdentifier();
      /*size_t*/int identifierid;
      
      for (identifierid = 0; $less_uint(identifierid, num_setids); identifierid++)  {
        if (id == II_setid[identifierid]) {
          break;
        }
      }
      if ($greatereq_uint(identifierid, num_setids)) {
        return;
      }
      
      /*const*/ FunctionProtoType /*P*/ FTP = FD.getType().$arrow().getAs(FunctionProtoType.class);
      if (!(FTP != null)) {
        return;
      }
      
      // Verify that the function takes one or two arguments (depending on
      //   the function).
      if (FTP.getNumParams() != ($less_uint(identifierid, 4) ? 1 : 2)) {
        return;
      }
      
      // The arguments must be integers.
      for (/*uint*/int i = 0; $less_uint(i, FTP.getNumParams()); i++)  {
        if (!FTP.getParamType(i).$arrow().isIntegralOrUnscopedEnumerationType()) {
          return;
        }
      }
      
      // Issue a warning.
      SmallString/*256*/ buf1/*J*/= new SmallString/*256*/(256);
      os1/*J*/= new raw_svector_ostream(buf1);
      $out_raw_ostream_NamedDecl$C(os1.$out(/*KEEP_STR*/"Return value is not checked in call to '"), $Deref(FD)).$out_char($$SGL_QUOTE);
      
      SmallString/*256*/ buf2/*J*/= new SmallString/*256*/(256);
      os2/*J*/= new raw_svector_ostream(buf2);
      $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(os2.$out(/*KEEP_STR*/"The return value from the call to '"), $Deref(FD)).$out(
              /*KEEP_STR*/"' is not checked.  If an error occurs in '"
          ), $Deref(FD)).$out(
          /*KEEP_STR*/"', the following code may execute with unexpected privileges"
      );
      
      PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      BR.EmitBasicReport(AC.getDecl(), new CheckName(filter.checkName_UncheckedReturn), os1.str(), 
          new StringRef(/*KEEP_STR*/"Security"), os2.str(), new PathDiagnosticLocation(CELoc), 
          new ArrayRef<SourceRange>(CE.getCallee().getSourceRange(), false));
    } finally {
      if (os2 != null) { os2.$destroy(); }
      if (os1 != null) { os1.$destroy(); }
    }
  }
  private static final class checkUncheckedReturnValue$$ {
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[6]*/> identifiers = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*6*/] {
      $("setuid"), $("setgid"), $("seteuid"), $("setegid"), 
      $("setreuid"), $("setregid")
    });
  }

  @Override public String toString() {
    return "" + "BR=" + BR // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + ", II_setid=" + II_setid // NOI18N
              + ", CheckRand=" + CheckRand // NOI18N
              + ", filter=" + filter // NOI18N
              + super.toString(); // NOI18N
  }
}

//===----------------------------------------------------------------------===//
// Check: floating poing variable used as loop counter.
// Originally: <rdar://problem/6336718>
// Implements: CERT security coding advisory FLP-30.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="getIncrementedVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 185,
 FQN="getIncrementedVar", NM="_ZL17getIncrementedVarPKN5clang4ExprEPKNS_7VarDeclES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZL17getIncrementedVarPKN5clang4ExprEPKNS_7VarDeclES5_")
//</editor-fold>
public static /*const*/ DeclRefExpr /*P*/ getIncrementedVar(/*const*/ Expr /*P*/ expr, /*const*/ VarDecl /*P*/ x, /*const*/ VarDecl /*P*/ y) {
  expr = expr.IgnoreParenCasts$Const();
  {
    
    /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(expr);
    if ((B != null)) {
      if (!(B.isAssignmentOp() || B.isCompoundAssignmentOp()
         || B.getOpcode() == BinaryOperatorKind.BO_Comma)) {
        return null;
      }
      {
        
        /*const*/ DeclRefExpr /*P*/ lhs = getIncrementedVar(B.getLHS(), x, y);
        if ((lhs != null)) {
          return lhs;
        }
      }
      {
        
        /*const*/ DeclRefExpr /*P*/ rhs = getIncrementedVar(B.getRHS(), x, y);
        if ((rhs != null)) {
          return rhs;
        }
      }
      
      return null;
    }
  }
  {
    
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(expr);
    if ((DR != null)) {
      /*const*/ NamedDecl /*P*/ ND = DR.getDecl$Const();
      return ND == x || ND == y ? DR : null;
    }
  }
  {
    
    /*const*/ UnaryOperator /*P*/ U = dyn_cast_UnaryOperator(expr);
    if ((U != null)) {
      return U.isIncrementDecrementOp() ? getIncrementedVar(U.getSubExpr(), x, y) : null;
    }
  }
  
  return null;
}

} // END OF class CheckSecuritySyntaxOnlyStatics
