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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
;


//<editor-fold defaultstate="collapsed" desc="static type ObjCContainersASTCheckerStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // see http://redbox.ru.oracle.com/bugzilla/show_bug.cgi?id=375
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZL13getCalleeNamePN5clang8CallExprE;_ZN12_GLOBAL__N_17WalkASTE; -static-type=ObjCContainersASTCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class ObjCContainersASTCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 28,
 FQN="(anonymous namespace)::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE")
//</editor-fold>
public static class WalkAST implements /*public*/ StmtVisitorVoid<WalkAST> {
  private final BugReporter /*&*/ BR;
  private /*const*/ CheckerBase /*P*/ Checker;
  private AnalysisDeclContext /*P*/ AC;
  private final ASTContext /*&*/ ASTC;
  private long/*uint64_t*/ PtrWidth;
  
  /// Check if the type has pointer size (very conservative).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::isPointerSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 36,
   FQN="(anonymous namespace)::WalkAST::isPointerSize", NM="_ZN12_GLOBAL__N_17WalkAST13isPointerSizeEPKN5clang4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13isPointerSizeEPKN5clang4TypeE")
  //</editor-fold>
  private /*inline*/ boolean isPointerSize(/*const*/ Type /*P*/ T) {
    if (!(T != null)) {
      return true;
    }
    if (T.isIncompleteType()) {
      return true;
    }
    return (ASTC.getTypeSize(T) == PtrWidth);
  }

  
  /// Check if the type is a pointer/array to pointer sized values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::hasPointerToPointerSizedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 45,
   FQN="(anonymous namespace)::WalkAST::hasPointerToPointerSizedType", NM="_ZN12_GLOBAL__N_17WalkAST28hasPointerToPointerSizedTypeEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST28hasPointerToPointerSizedTypeEPKN5clang4ExprE")
  //</editor-fold>
  private /*inline*/ boolean hasPointerToPointerSizedType(/*const*/ Expr /*P*/ E) {
    QualType T = E.getType();
    
    // The type could be either a pointer or array.
    /*const*/ Type /*P*/ TP = T.getTypePtr();
    QualType PointeeT = TP.getPointeeType();
    if (!PointeeT.isNull()) {
      {
        // If the type is a pointer to an array, check the size of the array
        // elements. To avoid false positives coming from assumption that the
        // values x and &x are equal when x is an array.
        /*const*/ Type /*P*/ TElem = PointeeT.$arrow().getArrayElementTypeNoTypeQual();
        if ((TElem != null)) {
          if (isPointerSize(TElem)) {
            return true;
          }
        }
      }
      
      // Else, check the pointee size.
      return isPointerSize(PointeeT.getTypePtr());
    }
    {
      
      /*const*/ Type /*P*/ TElem = TP.getArrayElementTypeNoTypeQual();
      if ((TElem != null)) {
        return isPointerSize(TElem);
      }
    }
    
    // The type must be an array/pointer type.
    
    // This could be a null constant, which is allowed.
    return ((/*static_cast*/boolean)((E.isNullPointerConstant(ASTC, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::WalkAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 74,
   FQN="(anonymous namespace)::WalkAST::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTC1ERN5clang4ento11BugReporterEPKNS2_11CheckerBaseEPNS1_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTC1ERN5clang4ento11BugReporterEPKNS2_11CheckerBaseEPNS1_19AnalysisDeclContextE")
  //</editor-fold>
  public WalkAST(final BugReporter /*&*/ br, /*const*/ CheckerBase /*P*/ checker, AnalysisDeclContext /*P*/ ac) {
    // : StmtVisitor<WalkAST>(), BR(br), Checker(checker), AC(ac), ASTC(AC->getASTContext()), PtrWidth(ASTC.getTargetInfo().getPointerWidth(0)) 
    //START JInit
    $StmtVisitor();
    this./*&*/BR=/*&*/br;
    this.Checker = checker;
    this.AC = ac;
    this./*&*/ASTC=/*&*/AC.getASTContext();
    this.PtrWidth = ASTC.getTargetInfo().getPointerWidth(0);
    //END JInit
  }

  
  // Statement visitor methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 154,
   FQN="(anonymous namespace)::WalkAST::VisitChildren", NM="_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 80,
   FQN="(anonymous namespace)::WalkAST::VisitStmt", NM="_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 97,
   FQN="(anonymous namespace)::WalkAST::VisitCallExpr", NM="_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    StringRef Name = getCalleeName(CE);
    if (Name.empty()) {
      return;
    }
    
    /*const*/ Expr /*P*/ Arg = null;
    /*uint*/int ArgNum = 0;
    if (Name.equals(/*STRINGREF_STR*/"CFArrayCreate") || Name.equals(/*STRINGREF_STR*/"CFSetCreate")) {
      if (CE.getNumArgs() != 4) {
        return;
      }
      ArgNum = 1;
      Arg = CE.getArg(ArgNum).IgnoreParenCasts();
      if (hasPointerToPointerSizedType(Arg)) {
        return;
      }
    } else if (Name.equals(/*STRINGREF_STR*/"CFDictionaryCreate")) {
      if (CE.getNumArgs() != 6) {
        return;
      }
      // Check first argument.
      ArgNum = 1;
      Arg = CE.getArg(ArgNum).IgnoreParenCasts();
      if (hasPointerToPointerSizedType(Arg)) {
        // Check second argument.
        ArgNum = 2;
        Arg = CE.getArg(ArgNum).IgnoreParenCasts();
        if (hasPointerToPointerSizedType(Arg)) {
          // Both are good, return.
          return;
        }
      }
    }
    if ((Arg != null)) {
      raw_svector_ostream OsName = null;
      raw_svector_ostream Os = null;
      try {
        assert (ArgNum == 1 || ArgNum == 2);
        
        SmallString/*64*/ BufName/*J*/= new SmallString/*64*/(64);
        OsName/*J*/= new raw_svector_ostream(BufName);
        OsName.$out(/*KEEP_STR*/" Invalid use of '").$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/$SGL_QUOTE);
        
        SmallString/*256*/ Buf/*J*/= new SmallString/*256*/(256);
        Os/*J*/= new raw_svector_ostream(Buf);
        // Use "second" and "third" since users will expect 1-based indexing
        // for parameter names when mentioned in prose.
        Os.$out(/*KEEP_STR*/" The ").$out(((ArgNum == 1) ? $("second") : $("third"))).$out(/*KEEP_STR*/" argument to '").$out(
            /*NO_COPY*/Name
        ).$out(/*KEEP_STR*/"' must be a C array of pointer-sized values, not '").$out(
            Arg.getType().getAsString()
        ).$out(/*KEEP_STR*/$SGL_QUOTE);
        
        PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
        BR.EmitBasicReport(AC.getDecl(), Checker, OsName.str(), 
            new StringRef(categories.CoreFoundationObjectiveC), Os.str(), new PathDiagnosticLocation(CELoc), 
            new ArrayRef<SourceRange>(Arg.getSourceRange(), false));
      } finally {
        if (Os != null) { Os.$destroy(); }
        if (OsName != null) { OsName.$destroy(); }
      }
    }
    
    // Recurse and check children.
    VisitChildren(CE);
  }

  @Override public String toString() {
    return "" + "BR=" + BR // NOI18N
              + ", Checker=" + Checker // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + ", ASTC=" + "[ASTContext]" // NOI18N
              + ", PtrWidth=" + PtrWidth // NOI18N
              + super.toString(); // NOI18N
  }
}
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="getCalleeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 85,
 FQN="getCalleeName", NM="_ZL13getCalleeNamePN5clang8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZL13getCalleeNamePN5clang8CallExprE")
//</editor-fold>
public static StringRef getCalleeName(CallExpr /*P*/ CE) {
  /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee();
  if (!(FD != null)) {
    return new StringRef();
  }
  
  IdentifierInfo /*P*/ II = FD.getIdentifier();
  if (!(II != null)) { // if no identifier, not a simple C function
    return new StringRef();
  }
  
  return II.getName();
}

} // END OF class ObjCContainersASTCheckerStatics
