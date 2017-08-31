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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
import org.clang.staticanalyzer.checkers.ento.impl.StreamCheckerStatics.ProgramStateTraitStreamMap;
import org.clang.staticanalyzer.checkers.impl.StreamCheckerStatics.StreamState;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 59,
 FQN="(anonymous namespace)::StreamChecker", NM="_ZN12_GLOBAL__N_113StreamCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_113StreamCheckerE")
//</editor-fold>
public class StreamChecker extends /*public*/ Checker/*<eval.Call, DeadSymbols>*/ implements org.clang.staticanalyzer.java.EvalCallChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  private /*mutable */IdentifierInfo /*P*/ II_fopen;
  private /*mutable */IdentifierInfo /*P*/ II_tmpfile;
  private /*mutable */IdentifierInfo /*P*/ II_fclose;
  private /*mutable */IdentifierInfo /*P*/ II_fread;
  private /*mutable */IdentifierInfo /*P*/ II_fwrite;
  private /*mutable */IdentifierInfo /*P*/ II_fseek;
  private /*mutable */IdentifierInfo /*P*/ II_ftell;
  private /*mutable */IdentifierInfo /*P*/ II_rewind;
  private /*mutable */IdentifierInfo /*P*/ II_fgetpos;
  private /*mutable */IdentifierInfo /*P*/ II_fsetpos;
  private /*mutable */IdentifierInfo /*P*/ II_clearerr;
  private /*mutable */IdentifierInfo /*P*/ II_feof;
  private /*mutable */IdentifierInfo /*P*/ II_ferror;
  private /*mutable */IdentifierInfo /*P*/ II_fileno;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_nullfp;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_illegalwhence;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_doubleclose;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_ResourceLeak;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::StreamChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 69,
   FQN="(anonymous namespace)::StreamChecker::StreamChecker", NM="_ZN12_GLOBAL__N_113StreamCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_113StreamCheckerC1Ev")
  //</editor-fold>
  public StreamChecker() {
    // : Checker<eval::Call, DeadSymbols>(), II_fopen(null), II_tmpfile(null), II_fclose(null), II_fread(null), II_fwrite(null), II_fseek(null), II_ftell(null), II_rewind(null), II_fgetpos(null), II_fsetpos(null), II_clearerr(null), II_feof(null), II_ferror(null), II_fileno(null), BT_nullfp(), BT_illegalwhence(), BT_doubleclose(), BT_ResourceLeak() 
    //START JInit
    super();
    this.II_fopen = null;
    this.II_tmpfile = null;
    this.II_fclose = null;
    this.II_fread = null;
    this.II_fwrite = null;
    this.II_fseek = null;
    this.II_ftell = null;
    this.II_rewind = null;
    this.II_fgetpos = null;
    this.II_fsetpos = null;
    this.II_clearerr = null;
    this.II_feof = null;
    this.II_ferror = null;
    this.II_fileno = null;
    this.BT_nullfp = new std.unique_ptr<BuiltinBug>();
    this.BT_illegalwhence = new std.unique_ptr<BuiltinBug>();
    this.BT_doubleclose = new std.unique_ptr<BuiltinBug>();
    this.BT_ResourceLeak = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 108,
   FQN="(anonymous namespace)::StreamChecker::evalCall", NM="_ZNK12_GLOBAL__N_113StreamChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
    if (!(FD != null) || FD.getKind() != Decl.Kind.Function) {
      return false;
    }
    
    final ASTContext /*&*/ Ctx = C.getASTContext();
    if (!(II_fopen != null)) {
      II_fopen = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fopen")));
    }
    if (!(II_tmpfile != null)) {
      II_tmpfile = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"tmpfile")));
    }
    if (!(II_fclose != null)) {
      II_fclose = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fclose")));
    }
    if (!(II_fread != null)) {
      II_fread = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fread")));
    }
    if (!(II_fwrite != null)) {
      II_fwrite = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fwrite")));
    }
    if (!(II_fseek != null)) {
      II_fseek = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fseek")));
    }
    if (!(II_ftell != null)) {
      II_ftell = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"ftell")));
    }
    if (!(II_rewind != null)) {
      II_rewind = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"rewind")));
    }
    if (!(II_fgetpos != null)) {
      II_fgetpos = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fgetpos")));
    }
    if (!(II_fsetpos != null)) {
      II_fsetpos = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fsetpos")));
    }
    if (!(II_clearerr != null)) {
      II_clearerr = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"clearerr")));
    }
    if (!(II_feof != null)) {
      II_feof = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"feof")));
    }
    if (!(II_ferror != null)) {
      II_ferror = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"ferror")));
    }
    if (!(II_fileno != null)) {
      II_fileno = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"fileno")));
    }
    if (FD.getIdentifier() == II_fopen) {
      Fopen(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_tmpfile) {
      Tmpfile(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fclose) {
      Fclose(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fread) {
      Fread(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fwrite) {
      Fwrite(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fseek) {
      Fseek(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_ftell) {
      Ftell(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_rewind) {
      Rewind(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fgetpos) {
      Fgetpos(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fsetpos) {
      Fsetpos(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_clearerr) {
      Clearerr(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_feof) {
      Feof(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_ferror) {
      Ferror(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_fileno) {
      Fileno(C, CE);
      return true;
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 397,
   FQN="(anonymous namespace)::StreamChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_113StreamChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, 
                  final CheckerContext /*&*/ C) /*const*/ {
    // TODO: Clean up the state.
    for (DenseSet.iterator<SymExpr> I = SymReaper.dead_begin(), 
        E = SymReaper.dead_end(); I.$noteq(E); I.$preInc()) {
      IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
      try {
        /*const*/ SymExpr /*P*/ Sym = I.$star();
        state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());      
        /*const*/ StreamState /*P*/ SS = state.$arrow().get(ProgramStateTraitStreamMap.$Instance, Sym);
        if (!(SS != null)) {
          continue;
        }
        if (SS.isOpened()) {
          ExplodedNode /*P*/ N = C.generateErrorNode();
          if ((N != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if (!BT_ResourceLeak.$bool()) {
                BT_ResourceLeak.reset(new BuiltinBug(this, $("Resource Leak"), 
                        $("Opened File never closed. Potential Resource leak.")));
              }
              C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_ResourceLeak.$star(), BT_ResourceLeak.$arrow().getDescription(), N)))); $c$.clean();
            } finally {
              $c$.$destroy();
            }
          }
        }
      } finally {
       if (state != null) { state.$destroy(); }
      } 
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fopen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 203,
   FQN="(anonymous namespace)::StreamChecker::Fopen", NM="_ZNK12_GLOBAL__N_113StreamChecker5FopenERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker5FopenERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fopen(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    OpenFileAux(C, CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Tmpfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 207,
   FQN="(anonymous namespace)::StreamChecker::Tmpfile", NM="_ZNK12_GLOBAL__N_113StreamChecker7TmpfileERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker7TmpfileERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Tmpfile(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    OpenFileAux(C, CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fclose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 238,
   FQN="(anonymous namespace)::StreamChecker::Fclose", NM="_ZNK12_GLOBAL__N_113StreamChecker6FcloseERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker6FcloseERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fclose(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = $c$.clean(CheckDoubleClose(CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C));
      if (state.$bool()) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fread">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 244,
   FQN="(anonymous namespace)::StreamChecker::Fread", NM="_ZNK12_GLOBAL__N_113StreamChecker5FreadERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker5FreadERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fread(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(3), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fwrite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 251,
   FQN="(anonymous namespace)::StreamChecker::Fwrite", NM="_ZNK12_GLOBAL__N_113StreamChecker6FwriteERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker6FwriteERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fwrite(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(3), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fseek">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 258,
   FQN="(anonymous namespace)::StreamChecker::Fseek", NM="_ZNK12_GLOBAL__N_113StreamChecker5FseekERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker5FseekERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fseek(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!(state.$assign($c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), 
                  C.getLocationContext()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)))).$bool())) {
        return;
      }
      // Check the legality of the 'whence' argument of 'fseek'.
      SVal Whence = state.$arrow().getSVal(CE.getArg$Const(2), C.getLocationContext());
      Optional<NsNonloc.ConcreteInt> CI = Whence.getAs(NsNonloc.ConcreteInt.class);
      if (!CI.$bool()) {
        return;
      }
      
      long/*int64_t*/ x = CI.$arrow().getValue().getSExtValue();
      if (x >= 0 && x <= 2) {
        return;
      }
      {
        
        ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
        if ((N != null)) {
          if (!BT_illegalwhence.$bool()) {
            BT_illegalwhence.reset(new BuiltinBug(this, $("Illegal whence argument"), 
                    $("The whence argument to fseek() should be SEEK_SET, SEEK_END, or SEEK_CUR.")));
          }
          C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_illegalwhence.$star(), BT_illegalwhence.$arrow().getDescription(), N)))); $c$.clean();
        }
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Ftell">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 285,
   FQN="(anonymous namespace)::StreamChecker::Ftell", NM="_ZNK12_GLOBAL__N_113StreamChecker5FtellERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker5FtellERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Ftell(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Rewind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 292,
   FQN="(anonymous namespace)::StreamChecker::Rewind", NM="_ZNK12_GLOBAL__N_113StreamChecker6RewindERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker6RewindERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Rewind(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fgetpos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 299,
   FQN="(anonymous namespace)::StreamChecker::Fgetpos", NM="_ZNK12_GLOBAL__N_113StreamChecker7FgetposERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker7FgetposERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fgetpos(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fsetpos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 306,
   FQN="(anonymous namespace)::StreamChecker::Fsetpos", NM="_ZNK12_GLOBAL__N_113StreamChecker7FsetposERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker7FsetposERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fsetpos(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Clearerr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 313,
   FQN="(anonymous namespace)::StreamChecker::Clearerr", NM="_ZNK12_GLOBAL__N_113StreamChecker8ClearerrERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker8ClearerrERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Clearerr(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Feof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 320,
   FQN="(anonymous namespace)::StreamChecker::Feof", NM="_ZNK12_GLOBAL__N_113StreamChecker4FeofERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker4FeofERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Feof(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Ferror">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 327,
   FQN="(anonymous namespace)::StreamChecker::Ferror", NM="_ZNK12_GLOBAL__N_113StreamChecker6FerrorERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker6FerrorERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Ferror(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::Fileno">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 334,
   FQN="(anonymous namespace)::StreamChecker::Fileno", NM="_ZNK12_GLOBAL__N_113StreamChecker6FilenoERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker6FilenoERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Fileno(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(CheckNullStream(state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C)).$bool())) {
        return;
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::OpenFileAux">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 211,
   FQN="(anonymous namespace)::StreamChecker::OpenFileAux", NM="_ZNK12_GLOBAL__N_113StreamChecker11OpenFileAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker11OpenFileAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void OpenFileAux(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNotNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNull = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      /*const*/ LocationContext /*P*/ LCtx = C.getPredecessor().getLocationContext();
      DefinedSVal RetVal = svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, 
    C.blockCount()).castAs(DefinedSVal.class);
      $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, C.getLocationContext(), new SVal(RetVal)))));
      
      final ConstraintManager /*&*/ CM = C.getConstraintManager();
      // Bifurcate the state into two: one with a valid FILE* pointer, the other
      // with a NULL.
      stateNotNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateNotNull, stateNull).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(RetVal)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual = 
              $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(RetVal)));
      stateNotNull.$assign($assumeDual.first);
      stateNull.$assign($assumeDual.second);
      assert !$assumeDual.first.$bool();
      assert !$assumeDual.second.$bool();
      $c$.clean();
      
      {
        
        /*const*/ SymExpr /*P*/ Sym = RetVal.getAsSymbol();
        if ((Sym != null)) {
          // if RetVal is not NULL, set the symbol's state to Opened.
          $c$.clean(stateNotNull.$assign(
              $c$.track(stateNotNull.$arrow().set(ProgramStateTraitStreamMap.$Instance, Sym, StreamState.getOpened(CE)))
          ));
          $c$.clean(stateNull.$assign(
              $c$.track(stateNull.$arrow().set(ProgramStateTraitStreamMap.$Instance, Sym, StreamState.getOpenFailed(CE)))
          ));
          
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNotNull))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNull))));
        }
      }
    } finally {
      if (stateNull != null) { stateNull.$destroy(); }
      if (stateNotNull != null) { stateNotNull.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::CheckNullStream">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 341,
   FQN="(anonymous namespace)::StreamChecker::CheckNullStream", NM="_ZNK12_GLOBAL__N_113StreamChecker15CheckNullStreamEN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker15CheckNullStreamEN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERNS2_14CheckerContextE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> CheckNullStream(SVal SV, IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                 final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNotNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNull = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Optional<DefinedSVal> DV = SV.getAs(DefinedSVal.class);
      if (!DV.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      final ConstraintManager /*&*/ CM = C.getConstraintManager();
      stateNotNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateNotNull, stateNull).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(DV.$star())))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual = 
              $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(DV.$star())));
      stateNotNull.$assign($assumeDual.first);
      stateNull.$assign($assumeDual.second);
      assert !$assumeDual.first.$bool();
      assert !$assumeDual.second.$bool();
      $c$.clean();
      
      if (!stateNotNull.$bool() && stateNull.$bool()) {
        {
          ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNull))));
          if ((N != null)) {
            if (!BT_nullfp.$bool()) {
              BT_nullfp.reset(new BuiltinBug(this, $("NULL stream pointer"), 
                      $("Stream pointer might be NULL.")));
            }
            C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_nullfp.$star(), BT_nullfp.$arrow().getDescription(), N)))); $c$.clean();
          }
        }
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, stateNotNull);
    } finally {
      if (stateNull != null) { stateNull.$destroy(); }
      if (stateNotNull != null) { stateNotNull.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::CheckDoubleClose">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 364,
   FQN="(anonymous namespace)::StreamChecker::CheckDoubleClose", NM="_ZNK12_GLOBAL__N_113StreamChecker16CheckDoubleCloseEPKN5clang8CallExprEN4llvm18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEERNS7_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_113StreamChecker16CheckDoubleCloseEPKN5clang8CallExprEN4llvm18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEERNS7_14CheckerContextE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> CheckDoubleClose(/*const*/ CallExpr /*P*/ CE, 
                  IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                  final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ SymExpr /*P*/ Sym = state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()).getAsSymbol();
    if (!(Sym != null)) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }
    
    /*const*/ StreamState /*P*/ SS = state.$arrow().get(ProgramStateTraitStreamMap.$Instance, Sym);
    
    // If the file stream is not tracked, return.
    if (!(SS != null)) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }
    
    // Check: Double close a File Descriptor could cause undefined behaviour.
    // Conforming to man-pages
    if (SS.isClosed()) {
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_doubleclose.$bool()) {
            BT_doubleclose.reset(new BuiltinBug(this, $("Double fclose"), $("Try to close a file Descriptor already closed. Cause undefined behaviour.")));
          }
          C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_doubleclose.$star(), BT_doubleclose.$arrow().getDescription(), N)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    // Close the File Descriptor.
    return state.$arrow().set(ProgramStateTraitStreamMap.$Instance, Sym, StreamCheckerStatics.StreamState.getClosed(CE));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamChecker::~StreamChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 59,
   FQN="(anonymous namespace)::StreamChecker::~StreamChecker", NM="_ZN12_GLOBAL__N_113StreamCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_113StreamCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_ResourceLeak.$destroy();
    BT_doubleclose.$destroy();
    BT_illegalwhence.$destroy();
    BT_nullfp.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new eval.Call(),
    new DeadSymbols()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "II_fopen=" + II_fopen // NOI18N
              + ", II_tmpfile=" + II_tmpfile // NOI18N
              + ", II_fclose=" + II_fclose // NOI18N
              + ", II_fread=" + II_fread // NOI18N
              + ", II_fwrite=" + II_fwrite // NOI18N
              + ", II_fseek=" + II_fseek // NOI18N
              + ", II_ftell=" + II_ftell // NOI18N
              + ", II_rewind=" + II_rewind // NOI18N
              + ", II_fgetpos=" + II_fgetpos // NOI18N
              + ", II_fsetpos=" + II_fsetpos // NOI18N
              + ", II_clearerr=" + II_clearerr // NOI18N
              + ", II_feof=" + II_feof // NOI18N
              + ", II_ferror=" + II_ferror // NOI18N
              + ", II_fileno=" + II_fileno // NOI18N
              + ", BT_nullfp=" + BT_nullfp // NOI18N
              + ", BT_illegalwhence=" + BT_illegalwhence // NOI18N
              + ", BT_doubleclose=" + BT_doubleclose // NOI18N
              + ", BT_ResourceLeak=" + BT_ResourceLeak // NOI18N
              + super.toString(); // NOI18N
  }
}
