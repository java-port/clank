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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.AstClangGlobals.$out_raw_ostream_NamedDecl$C;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.staticanalyzer.java.*;
import org.clang.staticanalyzer.java.StaticAnalyzerMemberPointers.CStringChecker$FnCheck;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 32,
 FQN="(anonymous namespace)::CStringChecker", NM="_ZN12_GLOBAL__N_114CStringCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringCheckerE")
//</editor-fold>
public class CStringChecker extends /*public*/ Checker/*<eval.Call, PreStmt<DeclStmt>, LiveSymbols, DeadSymbols, RegionChanges>*/ 
         implements org.clang.staticanalyzer.java.EvalCallChecker, org.clang.staticanalyzer.java.RegionChangesChecker, org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.LiveSymbolsChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT_Null;
  private /*mutable */std.unique_ptr<BugType> BT_Bounds;
  private /*mutable */std.unique_ptr<BugType> BT_Overlap;
  private /*mutable */std.unique_ptr<BugType> BT_NotCString;
  private /*mutable */std.unique_ptr<BugType> BT_AdditionOverflow;
  
  private /*mutable *//*const*/char$ptr/*char P*/ CurrentFunctionDescription;
/*public:*/
  /// The filter is used to filter out the diagnostics which are not enabled by
  /// the user.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CStringChecksFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 46,
   FQN="(anonymous namespace)::CStringChecker::CStringChecksFilter", NM="_ZN12_GLOBAL__N_114CStringChecker19CStringChecksFilterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker19CStringChecksFilterE")
  //</editor-fold>
  public static class/*struct*/ CStringChecksFilter {
    public DefaultBool CheckCStringNullArg;
    public DefaultBool CheckCStringOutOfBounds;
    public DefaultBool CheckCStringBufferOverlap;
    public DefaultBool CheckCStringNotNullTerm;
    
    public CheckName CheckNameCStringNullArg;
    public CheckName CheckNameCStringOutOfBounds;
    public CheckName CheckNameCStringBufferOverlap;
    public CheckName CheckNameCStringNotNullTerm;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CStringChecksFilter::CStringChecksFilter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 46,
     FQN="(anonymous namespace)::CStringChecker::CStringChecksFilter::CStringChecksFilter", NM="_ZN12_GLOBAL__N_114CStringChecker19CStringChecksFilterC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker19CStringChecksFilterC1Ev")
    //</editor-fold>
    public /*inline*/ CStringChecksFilter() {
      // : CheckCStringNullArg(), CheckCStringOutOfBounds(), CheckCStringBufferOverlap(), CheckCStringNotNullTerm(), CheckNameCStringNullArg(), CheckNameCStringOutOfBounds(), CheckNameCStringBufferOverlap(), CheckNameCStringNotNullTerm() 
      //START JInit
      this.CheckCStringNullArg = new DefaultBool();
      this.CheckCStringOutOfBounds = new DefaultBool();
      this.CheckCStringBufferOverlap = new DefaultBool();
      this.CheckCStringNotNullTerm = new DefaultBool();
      this.CheckNameCStringNullArg = new CheckName();
      this.CheckNameCStringOutOfBounds = new CheckName();
      this.CheckNameCStringBufferOverlap = new CheckName();
      this.CheckNameCStringNotNullTerm = new CheckName();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "CheckCStringNullArg=" + CheckCStringNullArg // NOI18N
                + ", CheckCStringOutOfBounds=" + CheckCStringOutOfBounds // NOI18N
                + ", CheckCStringBufferOverlap=" + CheckCStringBufferOverlap // NOI18N
                + ", CheckCStringNotNullTerm=" + CheckCStringNotNullTerm // NOI18N
                + ", CheckNameCStringNullArg=" + CheckNameCStringNullArg // NOI18N
                + ", CheckNameCStringOutOfBounds=" + CheckNameCStringOutOfBounds // NOI18N
                + ", CheckNameCStringBufferOverlap=" + CheckNameCStringBufferOverlap // NOI18N
                + ", CheckNameCStringNotNullTerm=" + CheckNameCStringNotNullTerm; // NOI18N
    }
  };
  
  public CStringChecksFilter Filter;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 60,
   FQN="(anonymous namespace)::CStringChecker::getTag", NM="_ZN12_GLOBAL__N_114CStringChecker6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker6getTagEv")
  //</editor-fold>
  public static Object/*void P*/ getTag() {
    final/*static*/ Object tag = CStringChecker_getTag$$.tag;
    return $AddrOf(tag);
  }
  private static final class CStringChecker_getTag$$ {
    static final/*static*/ Object tag = CStringChecker.class;
  }

  
  //===----------------------------------------------------------------------===//
  // The driver method, and other Checker callbacks.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2015,
   FQN="(anonymous namespace)::CStringChecker::evalCall", NM="_ZNK12_GLOBAL__N_114CStringChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FDecl = C.getCalleeDecl(CE);
    if (!(FDecl != null)) {
      return false;
    }
  
    // FIXME: Poorly-factored string switches are slow.
    CStringChecker$FnCheck evalFunction = null;
    if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"memcpy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalMemcpy;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"mempcpy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalMempcpy;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"memcmp"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalMemcmp;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"memmove"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalMemmove;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strcpy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrcpy;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strncpy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrncpy;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"stpcpy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStpcpy;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strcat"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrcat;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strncat"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrncat;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strlen"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalstrLength;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strnlen"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalstrnLength;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strcmp"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrcmp;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strncmp"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrncmp;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strcasecmp"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrcasecmp;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strncasecmp"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrncasecmp;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strsep"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStrsep;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"bcopy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalBcopy;
    } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"bcmp"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalMemcmp;
    } else if (CStringCheckerStatics.isCPPStdLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"copy"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStdCopy;
    } else if (CStringCheckerStatics.isCPPStdLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"copy_backward"))) {
      evalFunction = /*AddrOf*//*FPtr*/CStringChecker::evalStdCopyBackward;
    }
    
    // If the callee isn't a string function, let another checker handle it.
    if (!(evalFunction != null)) {
      return false;
    }
    
    // Check and evaluate the call.
    evalFunction.$call(/*PtrMemI*/this, C, CE);
    
    // If the evaluate call resulted in no change, chain to the next eval call
    // handler.
    // Note, the custom CString evaluation calls assume that basic safety
    // properties are held. However, if the user chooses to turn off some of these
    // checks, we ignore the issues and leave the call evaluation to a generic
    // handler.
    return C.isDifferent();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2080,
   FQN="(anonymous namespace)::CStringChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_114CStringChecker12checkPreStmtEPKN5clang8DeclStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker12checkPreStmtEPKN5clang8DeclStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ DeclStmt /*P*/ DS, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Record string length for char a[] = "abc";
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      for (/*const*/ Decl /*P*/ I : DS.decls$Const()) {
        /*const*/ VarDecl /*P*/ D = dyn_cast_VarDecl(I);
        if (!(D != null)) {
          continue;
        }
        
        // FIXME: Handle array fields of structs.
        if (!D.getType().$arrow().isArrayType()) {
          continue;
        }
        
        /*const*/ Expr /*P*/ Init = D.getInit$Const();
        if (!(Init != null)) {
          continue;
        }
        if (!isa_StringLiteral(Init)) {
          continue;
        }
        
        Loc VarLoc = state.$arrow().getLValue(D, C.getLocationContext());
        /*const*/ MemRegion /*P*/ MR = VarLoc.getAsRegion();
        if (!(MR != null)) {
          continue;
        }
        
        SVal StrVal = state.$arrow().getSVal(Init, C.getLocationContext());
        assert (StrVal.isValid$SVal()) : "Initializer string is unknown or undefined";
        DefinedOrUnknownSVal strLength = getCStringLength(C, state, Init, new SVal(StrVal)).castAs(DefinedOrUnknownSVal.class);
        
        $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitCStringLength.$Instance, MR, new SVal(strLength)))));
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::checkLiveSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2173,
   FQN="(anonymous namespace)::CStringChecker::checkLiveSymbols", NM="_ZNK12_GLOBAL__N_114CStringChecker16checkLiveSymbolsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker16checkLiveSymbolsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_12SymbolReaperE")
  //</editor-fold>
  public void checkLiveSymbols(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                  final SymbolReaper /*&*/ SR) /*const*/ {
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal> Entries = null;
    try {
      // Mark all symbols in our string length map as valid.
      Entries = state.$arrow().get(ProgramStateTraitCStringLength.$Instance);
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , SVal> I = null;
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , SVal> E = null;
      try {
        
        for (I = Entries.begin(), E = Entries.end();
             I.$noteq(E); I.$preInc()) {
          SVal Len = new SVal(I.getData());
          SymExpr.symbol_iterator si = null;
          SymExpr.symbol_iterator se = null;
          try {
            
            for (si = Len.symbol_begin(), 
                se = Len.symbol_end(); si.$noteq(se); si.$preInc())  {
              SR.markInUse(si.$star());
            }
          } finally {
            if (se != null) { se.$destroy(); }
            if (si != null) { si.$destroy(); }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (Entries != null) { Entries.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2188,
   FQN="(anonymous namespace)::CStringChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_114CStringChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SR, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal> Entries = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!SR.hasDeadSymbols()) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      Entries = state.$arrow().get(ProgramStateTraitCStringLength.$Instance);
      if (Entries.isEmpty()) {
        return;
      }
      
      final ImmutableMapPtrType.Factory</*const*/ MemRegion /*P*/ , SVal> /*&*/ F = state.$arrow().get_context(ProgramStateTraitCStringLength.$Instance);
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , SVal> I = null;
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , SVal> E = null;
      try {
        for (I = Entries.begin(), E = Entries.end();
             I.$noteq(E); I.$preInc()) {
          SVal Len = new SVal(I.getData());
          {
            /*const*/ SymExpr /*P*/ Sym = Len.getAsSymbol();
            if ((Sym != null)) {
              if (SR.isDead(Sym)) {
                $c$.clean(Entries.$assign($c$.track(F.remove($c$.track(new ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal>(Entries)), I.getKey()))));
              }
            }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitCStringLength.$Instance, $c$.track(new ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal>(Entries))))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (Entries != null) { Entries.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2115,
   FQN="(anonymous namespace)::CStringChecker::wantsRegionChangeUpdate", NM="_ZNK12_GLOBAL__N_114CStringChecker23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  public boolean wantsRegionChangeUpdate(IntrusiveRefCntPtr</*const*/ ProgramState> state) /*const*/ {
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal> Entries = null;
    try {
      Entries = state.$arrow().get(ProgramStateTraitCStringLength.$Instance);
      return !Entries.isEmpty();
    } finally {
      if (Entries != null) { Entries.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::checkRegionChanges">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2120,
   FQN="(anonymous namespace)::CStringChecker::checkRegionChanges", NM="_ZNK12_GLOBAL__N_114CStringChecker18checkRegionChangesEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEENS1_8ArrayRefIPKNS4_9MemRegionEEESL_PKNS4_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker18checkRegionChangesEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEENS1_8ArrayRefIPKNS4_9MemRegionEEESL_PKNS4_9CallEventE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkRegionChanges(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                    /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ $Prm1, 
                    ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                    ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                    /*const*/ CallEvent /*P*/ Call) /*const*/ {
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal> Entries = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Entries = state.$arrow().get(ProgramStateTraitCStringLength.$Instance);
      if (Entries.isEmpty()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      SmallPtrSet</*const*/ MemRegion /*P*/ > Invalidated/*J*/= new SmallPtrSet</*const*/ MemRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
      SmallPtrSet</*const*/ MemRegion /*P*/ > SuperRegions/*J*/= new SmallPtrSet</*const*/ MemRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
      
      // First build sets for the changed regions and their super-regions.
      for (type$ptr</*const*/ MemRegion /*P*/ /*P*/> I = $tryClone(Regions.begin()), /*P*/ E = $tryClone(Regions.end()); $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ MemRegion /*P*/ MR = I.$star();
        Invalidated.insert(MR);
        
        SuperRegions.insert(MR);
        {
          /*const*/ SubRegion /*P*/ SR;
          while (((/*P*/ SR = dyn_cast_SubRegion(MR)) != null)) {
            MR = SR.getSuperRegion();
            SuperRegions.insert(MR);
          }
        }
      }
      
      final ImmutableMapPtrType.Factory</*const*/ MemRegion /*P*/ , SVal> /*&*/ F = state.$arrow().get_context(ProgramStateTraitCStringLength.$Instance);
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , SVal> I = null;
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , SVal> E = null;
      try {
        
        // Then loop over the entries in the current state.
        for (I = Entries.begin(), 
            E = Entries.end(); I.$noteq(E); I.$preInc()) {
          /*const*/ MemRegion /*P*/ MR = I.getKey();
          
          // Is this entry for a super-region of a changed region?
          if ((SuperRegions.count(MR) != 0)) {
            $c$.clean(Entries.$assign($c$.track(F.remove($c$.track(new ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal>(Entries)), MR))));
            continue;
          }
          
          // Is this entry for a sub-region of a changed region?
          /*const*/ MemRegion /*P*/ Super = MR;
          {
            /*const*/ SubRegion /*P*/ SR;
            while (((/*P*/ SR = dyn_cast_SubRegion(Super)) != null)) {
              Super = SR.getSuperRegion();
              if ((Invalidated.count(Super) != 0)) {
                $c$.clean(Entries.$assign($c$.track(F.remove($c$.track(new ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal>(Entries)), MR))));
                break;
              }
            }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      return $c$.clean(state.$arrow().set(ProgramStateTraitCStringLength.$Instance, $c$.track(new ImmutableMapPtrType</*const*/ MemRegion /*P*/ , SVal>(Entries))));
    } finally {
      if (Entries != null) { Entries.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // JAVA: typedef void (CStringChecker::*FnCheck)(CheckerContext &, const CallExpr *) const
//  public final class FnCheck extends CStringChecker$FnCheck{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalMemcpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1102,
   FQN="(anonymous namespace)::CStringChecker::evalMemcpy", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalMemcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalMemcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalMemcpy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }

      // void *memcpy(void *restrict dst, const void *restrict src, size_t n);
      // The return value is the address of the destination buffer.
      /*const*/ Expr /*P*/ Dest = CE.getArg$Const(0);
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      evalCopyCommon(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), CE.getArg$Const(2), Dest, CE.getArg$Const(1), true); $c$.clean();
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalMempcpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1114,
   FQN="(anonymous namespace)::CStringChecker::evalMempcpy", NM="_ZNK12_GLOBAL__N_114CStringChecker11evalMempcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker11evalMempcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalMempcpy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }

      // void *mempcpy(void *restrict dst, const void *restrict src, size_t n);
      // The return value is a pointer to the byte following the last written byte.
      /*const*/ Expr /*P*/ Dest = CE.getArg$Const(0);
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      evalCopyCommon(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), CE.getArg$Const(2), Dest, CE.getArg$Const(1), true, true); $c$.clean();
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalMemmove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1126,
   FQN="(anonymous namespace)::CStringChecker::evalMemmove", NM="_ZNK12_GLOBAL__N_114CStringChecker11evalMemmoveERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker11evalMemmoveERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalMemmove(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }

      // void *memmove(void *dst, const void *src, size_t n);
      // The return value is the address of the destination buffer.
      /*const*/ Expr /*P*/ Dest = CE.getArg$Const(0);
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      evalCopyCommon(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), CE.getArg$Const(2), Dest, CE.getArg$Const(1)); $c$.clean();
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalBcopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1138,
   FQN="(anonymous namespace)::CStringChecker::evalBcopy", NM="_ZNK12_GLOBAL__N_114CStringChecker9evalBcopyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker9evalBcopyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalBcopy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }

      // void bcopy(const void *src, void *dst, size_t n);
      evalCopyCommon(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), 
          CE.getArg$Const(2), CE.getArg$Const(1), CE.getArg$Const(0)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
  
  
  //===----------------------------------------------------------------------===//
  // evaluation of individual function calls.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalCopyCommon">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 991,
   FQN="(anonymous namespace)::CStringChecker::evalCopyCommon", NM="_ZNK12_GLOBAL__N_114CStringChecker14evalCopyCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESF_SF_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker14evalCopyCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESF_SF_bb")
  //</editor-fold>
  public void evalCopyCommon(final CheckerContext /*&*/ C, 
                /*const*/ CallExpr /*P*/ CE, 
                IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                /*const*/ Expr /*P*/ Size, /*const*/ Expr /*P*/ Dest, 
                /*const*/ Expr /*P*/ Source) /*const*/ {
    evalCopyCommon(C, 
                CE, 
                state, 
                Size, Dest, 
                Source, false, 
                false);
  }
  public void evalCopyCommon(final CheckerContext /*&*/ C, 
                /*const*/ CallExpr /*P*/ CE, 
                IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                /*const*/ Expr /*P*/ Size, /*const*/ Expr /*P*/ Dest, 
                /*const*/ Expr /*P*/ Source, boolean Restricted/*= false*/) /*const*/ {
    evalCopyCommon(C, 
                CE, 
                state, 
                Size, Dest, 
                Source, Restricted, 
                false);
  }
  public void evalCopyCommon(final CheckerContext /*&*/ C, 
                /*const*/ CallExpr /*P*/ CE, 
                IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                /*const*/ Expr /*P*/ Size, /*const*/ Expr /*P*/ Dest, 
                /*const*/ Expr /*P*/ Source, boolean Restricted/*= false*/, 
                boolean IsMempcpy/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> stateZeroSize = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNonZeroSize = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CurrentFunctionDescription = $("memory copy function");
      
      // See if the size argument is zero.
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal sizeVal = state.$arrow().getSVal(Size, LCtx);
      QualType sizeTy = Size.getType();
      
      stateZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateNonZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateZeroSize, stateNonZeroSize).$assign(
//          $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(sizeVal), new QualType(sizeTy)))
//      ));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(sizeVal), new QualType(sizeTy)));
      stateZeroSize.$assign($assume.first);
      stateNonZeroSize.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
          
      // Get the value of the Dest.
      SVal destVal = state.$arrow().getSVal(Dest, LCtx);
      
      // If the size is zero, there won't be any actual memory access, so
      // just bind the return value to the destination buffer and return.
      if (stateZeroSize.$bool() && !stateNonZeroSize.$bool()) {
        $c$.clean(stateZeroSize.$assign($c$.track(stateZeroSize.$arrow().BindExpr(CE, LCtx, new SVal(destVal)))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateZeroSize))));
        return;
      }

      // If the size can be nonzero, we have to check the other arguments.
      if (stateNonZeroSize.$bool()) {
        $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNonZeroSize))));
  
        // Ensure the destination is not null. If it is NULL there will be a
        // NULL pointer dereference.
        $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Dest, new SVal(destVal)))));
        if (!state.$bool()) {
          return;
        }
        
        // Get the value of the Src.
        SVal srcVal = state.$arrow().getSVal(Source, LCtx);
        
        // Ensure the source is not null. If it is NULL there will be a
        // NULL pointer dereference.
        $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Source, new SVal(srcVal)))));
        if (!state.$bool()) {
          return;
        }
        
        // Ensure the accesses are valid and that the buffers do not overlap.
        /*const*/char$ptr/*char P*//*const*/ writeWarning = $("Memory copy function overflows destination buffer");
        $c$.clean(state.$assign($c$.track(CheckBufferAccess(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Size, Dest, Source, 
                writeWarning, /* sourceWarning = */ (/*const*/char$ptr/*char P*/ )null))));
        if (Restricted) {
          $c$.clean(state.$assign($c$.track(CheckOverlap(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Size, Dest, Source))));
        }
        if (!state.$bool()) {
          return;
        }
        
        // If this is mempcpy, get the byte after the last byte copied and
        // bind the expr.
        if (IsMempcpy) {
          NsLoc.MemRegionVal destRegVal = destVal.castAs(NsLoc.MemRegionVal.class);
          {
            
            // Get the length to copy.
            Optional<NonLoc> lenValNonLoc = sizeVal.getAs(NonLoc.class);
            if (lenValNonLoc.$bool()) {
              // Get the byte after the last byte copied.
              final SValBuilder /*&*/ SvalBuilder = C.getSValBuilder();
              final ASTContext /*&*/ Ctx = SvalBuilder.getContext();
              QualType CharPtrTy = Ctx.getPointerType(/*NO_COPY*/Ctx.CharTy).$QualType();
              NsLoc.MemRegionVal DestRegCharVal = SvalBuilder.evalCast(new SVal(destRegVal), 
    new QualType(CharPtrTy), Dest.getType()).castAs(NsLoc.MemRegionVal.class);
              SVal lastElement = $c$.clean(C.getSValBuilder().evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, 
                  new Loc(DestRegCharVal), 
                  new NonLoc(lenValNonLoc.$star()), 
                  Dest.getType()));
              
              // The byte after the last byte copied is the return value.
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(lastElement)))));
            } else {
              // If we don't know how much we copied, we can at least
              // conjure a return value for later.
              SVal result = new SVal(JD$Move.INSTANCE, C.getSValBuilder().conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, 
                      C.blockCount()));
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(result)))));
            }
          }
        } else {
          // All other copies return the destination buffer.
          // (Well, bcopy() has a void return type, but this won't hurt.)
          $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(destVal)))));
        }
        
        // Invalidate the destination (regular invalidation without pointer-escaping
        // the address of the top-level region).
        // FIXME: Even if we can't perfectly model the copy, we should see if we
        // can use LazyCompoundVals to copy the source values into the destination.
        // This would probably remove any existing bindings past the end of the
        // copied region, but that's still an improvement over blank invalidation.
        $c$.clean(state.$assign($c$.track(InvalidateBuffer(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Dest, C.getSVal(Dest), 
                /*IsSourceBuffer*/ false, Size))));
        
        // Invalidate the source (const-invalidation without const-pointer-escaping
        // the address of the top-level region).
        $c$.clean(state.$assign($c$.track(InvalidateBuffer(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Source, C.getSVal(Source), 
                /*IsSourceBuffer*/ true, (/*const*/ Expr /*P*/ )null))));
        
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
    } finally {
      if (stateNonZeroSize != null) { stateNonZeroSize.$destroy(); }
      if (stateZeroSize != null) { stateZeroSize.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalMemcmp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1147,
   FQN="(anonymous namespace)::CStringChecker::evalMemcmp", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalMemcmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalMemcmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalMemcmp(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateZeroSize = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNonZeroSize = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }

      // int memcmp(const void *s1, const void *s2, size_t n);
      CurrentFunctionDescription = $("memory comparison function");
  
      /*const*/ Expr /*P*/ Left = CE.getArg$Const(0);
      /*const*/ Expr /*P*/ Right = CE.getArg$Const(1);
      /*const*/ Expr /*P*/ Size = CE.getArg$Const(2);
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      
      // See if the size argument is zero.
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal sizeVal = state.$arrow().getSVal(Size, LCtx);
      QualType sizeTy = Size.getType();
      
      stateZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateNonZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateZeroSize, stateNonZeroSize).$assign(
//          $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(sizeVal), new QualType(sizeTy)))
//      ));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeZero = 
              $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(sizeVal), new QualType(sizeTy)));
      stateZeroSize.$assign($assumeZero.first);
      stateNonZeroSize.$assign($assumeZero.second);
      assert !$assumeZero.first.$bool();
      assert !$assumeZero.second.$bool();
      $c$.clean();

      // If the size can be zero, the result will be 0 in that case, and we don't
      // have to check either of the buffers.
      if (stateZeroSize.$bool()) {
        $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateZeroSize))));
        $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, 
                new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(CE.getType()))))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
      
      // If the size can be nonzero, we have to check the other arguments.
      if (stateNonZeroSize.$bool()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> StSameBuf = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> StNotSameBuf = null;
        try {
          $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNonZeroSize))));
          // If we know the two buffers are the same, we know the result is 0.
          // First, get the two buffers' addresses. Another checker will have already
          // made sure they're not undefined.
          DefinedOrUnknownSVal LV = state.$arrow().getSVal(Left, LCtx).castAs(DefinedOrUnknownSVal.class);
          DefinedOrUnknownSVal RV = state.$arrow().getSVal(Right, LCtx).castAs(DefinedOrUnknownSVal.class);
          
          // See if they are the same.
          DefinedOrUnknownSVal SameBuf = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(LV), new DefinedOrUnknownSVal(RV)));
          StSameBuf/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          StNotSameBuf/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//          $c$.clean(std.tie(StSameBuf, StNotSameBuf).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(SameBuf)))));
          // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
          std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                  $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(SameBuf)));
          StSameBuf.$assign($assume.first);
          StNotSameBuf.$assign($assume.second);
          assert !$assume.first.$bool();
          assert !$assume.second.$bool();
          $c$.clean();
          
          // If the two arguments might be the same buffer, we know the result is 0,
          // and we only need to check one size.
          if (StSameBuf.$bool()) {
            $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StSameBuf))));
            $c$.clean(state.$assign($c$.track(CheckBufferAccess(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Size, Left))));
            if (state.$bool()) {
              $c$.clean(state.$assign($c$.track(StSameBuf.$arrow().BindExpr(CE, LCtx, 
                      new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(CE.getType()))))));
              $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
            }
          }
          
          // If the two arguments might be different buffers, we have to check the
          // size of both of them.
          if (StNotSameBuf.$bool()) {
            $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNotSameBuf))));
            $c$.clean(state.$assign($c$.track(CheckBufferAccess(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Size, Left, Right))));
            if (state.$bool()) {
              // The return value is the comparison result, which we don't know.
              SVal CmpV = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, 
                      C.blockCount()));
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(CmpV)))));
              $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
            }
          }
        } finally {
          if (StNotSameBuf != null) { StNotSameBuf.$destroy(); }
          if (StSameBuf != null) { StSameBuf.$destroy(); }
        }
      }
    } finally {
      if (stateNonZeroSize != null) { stateNonZeroSize.$destroy(); }
      if (stateZeroSize != null) { stateZeroSize.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalstrLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1223,
   FQN="(anonymous namespace)::CStringChecker::evalstrLength", NM="_ZNK12_GLOBAL__N_114CStringChecker13evalstrLengthERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker13evalstrLengthERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalstrLength(final CheckerContext /*&*/ C, 
               /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 1)) {
      return;
    }

    // size_t strlen(const char *s);
    evalstrLengthCommon(C, CE, /* IsStrnlen = */ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalstrnLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1232,
   FQN="(anonymous namespace)::CStringChecker::evalstrnLength", NM="_ZNK12_GLOBAL__N_114CStringChecker14evalstrnLengthERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker14evalstrnLengthERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalstrnLength(final CheckerContext /*&*/ C, 
                /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 2)) {
      return;
    }

    // size_t strnlen(const char *s, size_t maxlen);
    evalstrLengthCommon(C, CE, /* IsStrnlen = */ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalstrLengthCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1241,
   FQN="(anonymous namespace)::CStringChecker::evalstrLengthCommon", NM="_ZNK12_GLOBAL__N_114CStringChecker19evalstrLengthCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker19evalstrLengthCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEb")
  //</editor-fold>
  public void evalstrLengthCommon(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    evalstrLengthCommon(C, CE, 
                     false);
  }
  public void evalstrLengthCommon(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
                     boolean IsStrnlen/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CurrentFunctionDescription = $("string length function");
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      if (IsStrnlen) {
        IntrusiveRefCntPtr</*const*/ ProgramState> stateZeroSize = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> stateNonZeroSize = null;
        try {
          /*const*/ Expr /*P*/ maxlenExpr = CE.getArg$Const(1);
          SVal maxlenVal = state.$arrow().getSVal(maxlenExpr, LCtx);
          
          stateZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          stateNonZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//          $c$.clean(std.tie(stateZeroSize, stateNonZeroSize).$assign(
//              $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(maxlenVal), maxlenExpr.getType()))
//          ));
          // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
          std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeZero = 
                  $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(maxlenVal), maxlenExpr.getType()));
          stateZeroSize.$assign($assumeZero.first);
          stateNonZeroSize.$assign($assumeZero.second);
          assert !$assumeZero.first.$bool();
          assert !$assumeZero.second.$bool();
          $c$.clean();
          
          // If the size can be zero, the result will be 0 in that case, and we don't
          // have to check the string itself.
          if (stateZeroSize.$bool()) {
            SVal zero = new SVal(JD$Move.INSTANCE, C.getSValBuilder().makeZeroVal(CE.getType()));
            $c$.clean(stateZeroSize.$assign($c$.track(stateZeroSize.$arrow().BindExpr(CE, LCtx, new SVal(zero)))));
            $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateZeroSize))));
          }

          // If the size is GUARANTEED to be zero, we're done!
          if (!stateNonZeroSize.$bool()) {
            return;
          }
  
          // Otherwise, record the assumption that the size is nonzero.
          $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNonZeroSize))));
        } finally {
          if (stateNonZeroSize != null) { stateNonZeroSize.$destroy(); }
          if (stateZeroSize != null) { stateZeroSize.$destroy(); }
        }
      }
      
      // Check that the string argument is non-null.
      /*const*/ Expr /*P*/ Arg = CE.getArg$Const(0);
      SVal ArgVal = state.$arrow().getSVal(Arg, LCtx);
      
      $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Arg, new SVal(ArgVal)))));
      if (!state.$bool()) {
        return;
      }
      
      SVal strLength = getCStringLength(C, state, Arg, new SVal(ArgVal));
      
      // If the argument isn't a valid C string, there's no valid state to
      // transition to.
      if (strLength.isUndef$SVal()) {
        return;
      }
      
      DefinedOrUnknownSVal result = new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
      
      // If the check is for strnlen() then bind the return value to no more than
      // the maxlen value.
      if (IsStrnlen) {
        QualType cmpTy = C.getSValBuilder().getConditionType();
        
        // It's a little unfortunate to be getting this again,
        // but it's not that expensive...
        /*const*/ Expr /*P*/ maxlenExpr = CE.getArg$Const(1);
        SVal maxlenVal = state.$arrow().getSVal(maxlenExpr, LCtx);
        
        Optional<NonLoc> strLengthNL = strLength.getAs(NonLoc.class);
        Optional<NonLoc> maxlenValNL = maxlenVal.getAs(NonLoc.class);
        if (strLengthNL.$bool() && maxlenValNL.$bool()) {
          IntrusiveRefCntPtr</*const*/ ProgramState> stateStringTooLong = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> stateStringNotTooLong = null;
          try {
            stateStringTooLong/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            stateStringNotTooLong/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            
            // Check if the strLength is greater than the maxlen.
//            $c$.clean(std.tie(stateStringTooLong, stateStringNotTooLong).$assign($c$.track(state.$arrow().assume(C.getSValBuilder().
//    evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_GT, new NonLoc(strLengthNL.$star()), new NonLoc(maxlenValNL.$star()), new QualType(cmpTy)).castAs(DefinedOrUnknownSVal.class)))));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                    $c$.track(state.$arrow().assume(C.getSValBuilder().
                    evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_GT, new NonLoc(strLengthNL.$star()), new NonLoc(maxlenValNL.$star()), new QualType(cmpTy)).castAs(DefinedOrUnknownSVal.class)));
            stateStringTooLong.$assign($assume.first);
            stateStringNotTooLong.$assign($assume.second);
            assert !$assume.first.$bool();
            assert !$assume.second.$bool();
            $c$.clean();

            if (stateStringTooLong.$bool() && !stateStringNotTooLong.$bool()) {
              // If the string is longer than maxlen, return maxlen.
              result.$assign(maxlenValNL.$star());
            } else if (stateStringNotTooLong.$bool() && !stateStringTooLong.$bool()) {
              // If the string is shorter than maxlen, return its length.
              result.$assign(strLengthNL.$star());
            }
          } finally {
            if (stateStringNotTooLong != null) { stateStringNotTooLong.$destroy(); }
            if (stateStringTooLong != null) { stateStringTooLong.$destroy(); }
          }
        }
        if (result.isUnknown$SVal()) {
          // If we don't have enough information for a comparison, there's
          // no guarantee the full string length will actually be returned.
          // All we know is the return value is the min of the string length
          // and the limit. This is better than nothing.
          result.$assignMove(C.getSValBuilder().conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, 
                  C.blockCount()));
          NonLoc resultNL = result.castAs(NonLoc.class);
          if (strLengthNL.$bool()) {
            $c$.clean(state.$assign($c$.track(state.$arrow().assume(C.getSValBuilder().evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_LE, new NonLoc(resultNL), new NonLoc(strLengthNL.$star()), new QualType(cmpTy)).castAs(DefinedOrUnknownSVal.class), true))));
          }
          if (maxlenValNL.$bool()) {
            $c$.clean(state.$assign($c$.track(state.$arrow().assume(C.getSValBuilder().evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_LE, new NonLoc(resultNL), new NonLoc(maxlenValNL.$star()), new QualType(cmpTy)).castAs(DefinedOrUnknownSVal.class), true))));
          }
        }
      } else {
        // This is a plain strlen(), not strnlen().
        result.$assignMove(strLength.castAs(DefinedOrUnknownSVal.class));
        
        // If we don't know the length of the string, conjure a return
        // value, so it can be used in constraints, at least.
        if (result.isUnknown$SVal()) {
          result.$assignMove(C.getSValBuilder().conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, 
                  C.blockCount()));
        }
      }
      
      // Bind the return value.
      assert (!result.isUnknown$SVal()) : "Should have conjured a value by now";
      $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(result)))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrcpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1360,
   FQN="(anonymous namespace)::CStringChecker::evalStrcpy", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalStrcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalStrcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrcpy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 2)) {
      return;
    }

    // char *strcpy(char *restrict dst, const char *restrict src);
    evalStrcpyCommon(C, CE, 
        /* returnEnd = */ false, 
        /* isBounded = */ false, 
        /* isAppending = */ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrncpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1371,
   FQN="(anonymous namespace)::CStringChecker::evalStrncpy", NM="_ZNK12_GLOBAL__N_114CStringChecker11evalStrncpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker11evalStrncpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrncpy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 3)) {
      return;
    }

    // char *strncpy(char *restrict dst, const char *restrict src, size_t n);
    evalStrcpyCommon(C, CE, 
        /* returnEnd = */ false, 
        /* isBounded = */ true, 
        /* isAppending = */ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStpcpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1382,
   FQN="(anonymous namespace)::CStringChecker::evalStpcpy", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalStpcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalStpcpyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStpcpy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 2)) {
      return;
    }

    // char *stpcpy(char *restrict dst, const char *restrict src);
    evalStrcpyCommon(C, CE, 
        /* returnEnd = */ true, 
        /* isBounded = */ false, 
        /* isAppending = */ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrcpyCommon">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1415,
   FQN="(anonymous namespace)::CStringChecker::evalStrcpyCommon", NM="_ZNK12_GLOBAL__N_114CStringChecker16evalStrcpyCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker16evalStrcpyCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEbbb")
  //</editor-fold>
  public void evalStrcpyCommon(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
                  boolean returnEnd, boolean isBounded, 
                  boolean isAppending) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CurrentFunctionDescription = $("string copy function");
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      
      // Check that the destination is non-null.
      /*const*/ Expr /*P*/ Dst = CE.getArg$Const(0);
      SVal DstVal = state.$arrow().getSVal(Dst, LCtx);
      
      $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Dst, new SVal(DstVal)))));
      if (!state.$bool()) {
        return;
      }

      // Check that the source is non-null.
      /*const*/ Expr /*P*/ srcExpr = CE.getArg$Const(1);
      SVal srcVal = state.$arrow().getSVal(srcExpr, LCtx);
      $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), srcExpr, new SVal(srcVal)))));
      if (!state.$bool()) {
        return;
      }
  
      // Get the string length of the source.
      SVal strLength = getCStringLength(C, state, srcExpr, new SVal(srcVal));
      
      // If the source isn't a valid C string, give up.
      if (strLength.isUndef$SVal()) {
        return;
      }
      
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      QualType cmpTy = svalBuilder.getConditionType();
      QualType sizeTy = svalBuilder.getContext().getSizeType().$QualType();
      
      // These two values allow checking two kinds of errors:
      // - actual overflows caused by a source that doesn't fit in the destination
      // - potential overflows caused by a bound that could exceed the destination
      SVal amountCopied = new SVal(JD$Move.INSTANCE, new UnknownVal());
      SVal maxLastElementIndex = new SVal(JD$Move.INSTANCE, new UnknownVal());
      /*const*/char$ptr/*char P*/ boundWarning = null;
      
      // If the function is strncpy, strncat, etc... it is bounded.
      if (isBounded) {
        // Get the max number of characters to copy.
        /*const*/ Expr /*P*/ lenExpr = CE.getArg$Const(2);
        SVal lenVal = state.$arrow().getSVal(lenExpr, LCtx);
        
        // Protect against misdeclared strncpy().
        lenVal.$assignMove(svalBuilder.evalCast(new SVal(lenVal), new QualType(sizeTy), lenExpr.getType()));
        
        Optional<NonLoc> strLengthNL = strLength.getAs(NonLoc.class);
        Optional<NonLoc> lenValNL = lenVal.getAs(NonLoc.class);
        
        // If we know both values, we might be able to figure out how much
        // we're copying.
        if (strLengthNL.$bool() && lenValNL.$bool()) {
          IntrusiveRefCntPtr</*const*/ ProgramState> stateSourceTooLong = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> stateSourceNotTooLong = null;
          try {
            stateSourceTooLong/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            stateSourceNotTooLong/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            
            // Check if the max number to copy is less than the length of the src.
            // If the bound is equal to the source length, strncpy won't null-
            // terminate the result!
//            $c$.clean(std.tie(stateSourceTooLong, stateSourceNotTooLong).$assign($c$.track(state.$arrow().assume(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_GE, new NonLoc(strLengthNL.$star()), new NonLoc(lenValNL.$star()), new QualType(cmpTy)).castAs(DefinedOrUnknownSVal.class)))));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                    $c$.track(state.$arrow().assume(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_GE, new NonLoc(strLengthNL.$star()), new NonLoc(lenValNL.$star()), new QualType(cmpTy)).castAs(DefinedOrUnknownSVal.class)));
            stateSourceTooLong.$assign($assume.first);
            stateSourceNotTooLong.$assign($assume.second);
            assert !$assume.first.$bool();
            assert !$assume.second.$bool();
            $c$.clean();

            if (stateSourceTooLong.$bool() && !stateSourceNotTooLong.$bool()) {
              // Max number to copy is less than the length of the src, so the actual
              // strLength copied is the max number arg.
              $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateSourceTooLong))));
              amountCopied.$assign(lenVal);
            } else if (!stateSourceTooLong.$bool() && stateSourceNotTooLong.$bool()) {
              // The source buffer entirely fits in the bound.
              $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateSourceNotTooLong))));
              amountCopied.$assign(strLength);
            }
          } finally {
            if (stateSourceNotTooLong != null) { stateSourceNotTooLong.$destroy(); }
            if (stateSourceTooLong != null) { stateSourceTooLong.$destroy(); }
          }
        }
        
        // We still want to know if the bound is known to be too large.
        if (lenValNL.$bool()) {
          if (isAppending) {
            // For strncat, the check is strlen(dst) + lenVal < sizeof(dst)
            
            // Get the string length of the destination. If the destination is
            // memory that can't have a string length, we shouldn't be copying
            // into it anyway.
            SVal dstStrLength = getCStringLength(C, state, Dst, new SVal(DstVal));
            if (dstStrLength.isUndef$SVal()) {
              return;
            }
            {
              
              Optional<NonLoc> dstStrLengthNL = dstStrLength.getAs(NonLoc.class);
              if (dstStrLengthNL.$bool()) {
                $c$.clean(maxLastElementIndex.$assignMove(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, 
                        new NonLoc(lenValNL.$star()), 
                        new NonLoc(dstStrLengthNL.$star()), 
                        new QualType(sizeTy))));
                boundWarning = $("Size argument is greater than the free space in the destination buffer");
              }
            }
          } else {
            IntrusiveRefCntPtr</*const*/ ProgramState> StateZeroSize = null;
            IntrusiveRefCntPtr</*const*/ ProgramState> StateNonZeroSize = null;
            try {
              // For strncpy, this is just checking that lenVal <= sizeof(dst)
              // (Yes, strncpy and strncat differ in how they treat termination.
              // strncat ALWAYS terminates, but strncpy doesn't.)
              
              // We need a special case for when the copy size is zero, in which
              // case strncpy will do no work at all. Our bounds check uses n-1
              // as the last element accessed, so n == 0 is problematic.
              StateZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
              StateNonZeroSize/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//              $c$.clean(std.tie(StateZeroSize, StateNonZeroSize).$assign(
//                  $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(lenValNL.$star()), new QualType(sizeTy)))
//              ));
              // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
              std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                      $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(lenValNL.$star()), new QualType(sizeTy)));
              StateZeroSize.$assign($assume.first);
              StateNonZeroSize.$assign($assume.second);
              assert !$assume.first.$bool();
              assert !$assume.second.$bool();
              $c$.clean();

              // If the size is known to be zero, we're done.
              if (StateZeroSize.$bool() && !StateNonZeroSize.$bool()) {
                $c$.clean(StateZeroSize.$assign($c$.track(StateZeroSize.$arrow().BindExpr(CE, LCtx, new SVal(DstVal)))));
                $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateZeroSize))));
                return;
              }
              
              // Otherwise, go ahead and figure out the last element we'll touch.
              // We don't record the non-zero assumption here because we can't
              // be sure. We won't warn on a possible zero.
              NonLoc one = svalBuilder.makeIntVal($int2ulong(1), new QualType(sizeTy)).castAs(NonLoc.class);
              $c$.clean(maxLastElementIndex.$assignMove(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Sub, new NonLoc(lenValNL.$star()), 
                      new NonLoc(one), new QualType(sizeTy))));
              boundWarning = $("Size argument is greater than the length of the destination buffer");
            } finally {
              if (StateNonZeroSize != null) { StateNonZeroSize.$destroy(); }
              if (StateZeroSize != null) { StateZeroSize.$destroy(); }
            }
          }
        }
        
        // If we couldn't pin down the copy length, at least bound it.
        // FIXME: We should actually run this code path for append as well, but
        // right now it creates problems with constraints (since we can end up
        // trying to pass constraints from symbol to symbol).
        if (amountCopied.isUnknown$SVal() && !isAppending) {
          // Try to get a "hypothetical" string length symbol, which we can later
          // set as a real value if that turns out to be the case.
          amountCopied.$assignMove(getCStringLength(C, state, lenExpr, new SVal(srcVal), true));
          assert (!amountCopied.isUndef$SVal());
          {
            
            Optional<NonLoc> amountCopiedNL = amountCopied.getAs(NonLoc.class);
            if (amountCopiedNL.$bool()) {
              if (lenValNL.$bool()) {
                // amountCopied <= lenVal
                SVal copiedLessThanBound = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_LE, 
                    new NonLoc(amountCopiedNL.$star()), 
                    new NonLoc(lenValNL.$star()), 
                    new QualType(cmpTy)));
                $c$.clean(state.$assign($c$.track(state.$arrow().assume(copiedLessThanBound.castAs(DefinedOrUnknownSVal.class), true))));
                if (!state.$bool()) {
                  return;
                }
              }
              if (strLengthNL.$bool()) {
                // amountCopied <= strlen(source)
                SVal copiedLessThanSrc = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_LE, 
                    new NonLoc(amountCopiedNL.$star()), 
                    new NonLoc(strLengthNL.$star()), 
                    new QualType(cmpTy)));
                $c$.clean(state.$assign($c$.track(state.$arrow().assume(copiedLessThanSrc.castAs(DefinedOrUnknownSVal.class), true))));
                if (!state.$bool()) {
                  return;
                }
              }
            }
          }
        }
      } else {
        // The function isn't bounded. The amount copied should match the length
        // of the source buffer.
        amountCopied.$assign(strLength);
      }
      assert ((state).$bool());
      
      // This represents the number of characters copied into the destination
      // buffer. (It may not actually be the strlen if the destination buffer
      // is not terminated.)
      SVal finalStrLength = new SVal(JD$Move.INSTANCE, new UnknownVal());
      
      // If this is an appending function (strcat, strncat...) then set the
      // string length to strlen(src) + strlen(dst) since the buffer will
      // ultimately contain both.
      if (isAppending) {
        // Get the string length of the destination. If the destination is memory
        // that can't have a string length, we shouldn't be copying into it anyway.
        SVal dstStrLength = getCStringLength(C, state, Dst, new SVal(DstVal));
        if (dstStrLength.isUndef$SVal()) {
          return;
        }
        
        Optional<NonLoc> srcStrLengthNL = amountCopied.getAs(NonLoc.class);
        Optional<NonLoc> dstStrLengthNL = dstStrLength.getAs(NonLoc.class);
        
        // If we know both string lengths, we might know the final string length.
        if (srcStrLengthNL.$bool() && dstStrLengthNL.$bool()) {
          // Make sure the two lengths together don't overflow a size_t.
          $c$.clean(state.$assign($c$.track(checkAdditionOverflow(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new NonLoc(srcStrLengthNL.$star()), new NonLoc(dstStrLengthNL.$star())))));
          if (!state.$bool()) {
            return;
          }
          
          $c$.clean(finalStrLength.$assignMove(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, new NonLoc(srcStrLengthNL.$star()), 
                  new NonLoc(dstStrLengthNL.$star()), new QualType(sizeTy))));
        }
        
        // If we couldn't get a single value for the final string length,
        // we can at least bound it by the individual lengths.
        if (finalStrLength.isUnknown$SVal()) {
          // Try to get a "hypothetical" string length symbol, which we can later
          // set as a real value if that turns out to be the case.
          finalStrLength.$assignMove(getCStringLength(C, state, CE, new SVal(DstVal), true));
          assert (!finalStrLength.isUndef$SVal());
          {
            
            Optional<NonLoc> finalStrLengthNL = finalStrLength.getAs(NonLoc.class);
            if (finalStrLengthNL.$bool()) {
              if (srcStrLengthNL.$bool()) {
                // finalStrLength >= srcStrLength
                SVal sourceInResult = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GE, 
                    new NonLoc(finalStrLengthNL.$star()), 
                    new NonLoc(srcStrLengthNL.$star()), 
                    new QualType(cmpTy)));
                $c$.clean(state.$assign($c$.track(state.$arrow().assume(sourceInResult.castAs(DefinedOrUnknownSVal.class), 
                        true))));
                if (!state.$bool()) {
                  return;
                }
              }
              if (dstStrLengthNL.$bool()) {
                // finalStrLength >= dstStrLength
                SVal destInResult = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GE, 
                    new NonLoc(finalStrLengthNL.$star()), 
                    new NonLoc(dstStrLengthNL.$star()), 
                    new QualType(cmpTy)));
                $c$.clean(state.$assign(
                    $c$.track(state.$arrow().assume(destInResult.castAs(DefinedOrUnknownSVal.class), true))
                ));
                if (!state.$bool()) {
                  return;
                }
              }
            }
          }
        }
      } else {
        // Otherwise, this is a copy-over function (strcpy, strncpy, ...), and
        // the final string length will match the input string length.
        finalStrLength.$assign(amountCopied);
      }
      
      // The final result of the function will either be a pointer past the last
      // copied element, or a pointer to the start of the destination buffer.
      SVal Result = (returnEnd ? new SVal(JD$Move.INSTANCE, new UnknownVal()) : new SVal(DstVal));
      assert ((state).$bool());
      {
        
        // If the destination is a MemRegion, try to check for a buffer overflow and
        // record the new string length.
        Optional<NsLoc.MemRegionVal> dstRegVal = DstVal.getAs(NsLoc.MemRegionVal.class);
        if (dstRegVal.$bool()) {
          QualType ptrTy = Dst.getType();
          
          // If we have an exact value on a bounded copy, use that to check for
          // overflows, rather than our estimate about how much is actually copied.
          if (Native.$bool(boundWarning)) {
            {
              Optional<NonLoc> maxLastNL = maxLastElementIndex.getAs(NonLoc.class);
              if (maxLastNL.$bool()) {
                SVal maxLastElement = $c$.clean(svalBuilder.evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, new Loc(dstRegVal.$star()), 
                    new NonLoc(maxLastNL.$star()), new QualType(ptrTy)));
                $c$.clean(state.$assign($c$.track(CheckLocation(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), CE.getArg$Const(2), new SVal(maxLastElement), 
                        boundWarning))));
                if (!state.$bool()) {
                  return;
                }
              }
            }
          }
          {
            
            // Then, if the final length is known...
            Optional<NonLoc> knownStrLength = finalStrLength.getAs(NonLoc.class);
            if (knownStrLength.$bool()) {
              SVal lastElement = $c$.clean(svalBuilder.evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, new Loc(dstRegVal.$star()), 
                  new NonLoc(knownStrLength.$star()), new QualType(ptrTy)));
              
              // ...and we haven't checked the bound, we'll check the actual copy.
              if (!Native.$bool(boundWarning)) {
                /*const*/char$ptr/*char P*//*const*/ warningMsg = $("String copy function overflows destination buffer");
                $c$.clean(state.$assign($c$.track(CheckLocation(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Dst, new SVal(lastElement), warningMsg))));
                if (!state.$bool()) {
                  return;
                }
              }
              
              // If this is a stpcpy-style copy, the last element is the return value.
              if (returnEnd) {
                Result.$assign(lastElement);
              }
            }
          }
          
          // Invalidate the destination (regular invalidation without pointer-escaping
          // the address of the top-level region). This must happen before we set the
          // C string length because invalidation will clear the length.
          // FIXME: Even if we can't perfectly model the copy, we should see if we
          // can use LazyCompoundVals to copy the source values into the destination.
          // This would probably remove any existing bindings past the end of the
          // string, but that's still an improvement over blank invalidation.
          $c$.clean(state.$assign($c$.track(InvalidateBuffer(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Dst, new SVal(dstRegVal.$star()), 
                  /*IsSourceBuffer*/ false, (/*const*/ Expr /*P*/ )null))));
          
          // Invalidate the source (const-invalidation without const-pointer-escaping
          // the address of the top-level region).
          $c$.clean(state.$assign($c$.track(InvalidateBuffer(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), srcExpr, new SVal(srcVal), /*IsSourceBuffer*/ true, 
                  (/*const*/ Expr /*P*/ )null))));
          
          // Set the C string length of the destination, if we know it.
          if (isBounded && !isAppending) {
            // strncpy is annoying in that it doesn't guarantee to null-terminate
            // the result string. If the original string didn't fit entirely inside
            // the bound (including the null-terminator), we don't know how long the
            // result is.
            if (amountCopied.$noteq(strLength)) {
              finalStrLength.$assignMove(new UnknownVal());
            }
          }
          $c$.clean(state.$assign($c$.track(setCStringLength($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), dstRegVal.$arrow().getRegion(), new SVal(finalStrLength)))));
        }
      }
      assert ((state).$bool());
      
      // If this is a stpcpy-style copy, but we were unable to check for a buffer
      // overflow, we still need a result. Conjure a return value.
      if (returnEnd && Result.isUnknown$SVal()) {
        Result.$assignMove(svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, C.blockCount()));
      }
      
      // Set the return value.
      $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(Result)))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrcat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1393,
   FQN="(anonymous namespace)::CStringChecker::evalStrcat", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalStrcatERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalStrcatERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrcat(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 2)) {
      return;
    }

    //char *strcat(char *restrict s1, const char *restrict s2);
    evalStrcpyCommon(C, CE, 
        /* returnEnd = */ false, 
        /* isBounded = */ false, 
        /* isAppending = */ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrncat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1404,
   FQN="(anonymous namespace)::CStringChecker::evalStrncat", NM="_ZNK12_GLOBAL__N_114CStringChecker11evalStrncatERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker11evalStrncatERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrncat(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 3)) {
      return;
    }

    //char *strncat(char *restrict s1, const char *restrict s2, size_t n);
    evalStrcpyCommon(C, CE, 
        /* returnEnd = */ false, 
        /* isBounded = */ true, 
        /* isAppending = */ true);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrcmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1742,
   FQN="(anonymous namespace)::CStringChecker::evalStrcmp", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalStrcmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalStrcmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrcmp(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 2)) {
      return;
    }

    //int strcmp(const char *s1, const char *s2);
    evalStrcmpCommon(C, CE, /* isBounded = */ false, /* ignoreCase = */ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrncmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1750,
   FQN="(anonymous namespace)::CStringChecker::evalStrncmp", NM="_ZNK12_GLOBAL__N_114CStringChecker11evalStrncmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker11evalStrncmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrncmp(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 3)) {
      return;
    }

    //int strncmp(const char *s1, const char *s2, size_t n);
    evalStrcmpCommon(C, CE, /* isBounded = */ true, /* ignoreCase = */ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrcasecmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1758,
   FQN="(anonymous namespace)::CStringChecker::evalStrcasecmp", NM="_ZNK12_GLOBAL__N_114CStringChecker14evalStrcasecmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker14evalStrcasecmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrcasecmp(final CheckerContext /*&*/ C, 
                /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 2)) {
      return;
    }

    //int strcasecmp(const char *s1, const char *s2);
    evalStrcmpCommon(C, CE, /* isBounded = */ false, /* ignoreCase = */ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrncasecmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1767,
   FQN="(anonymous namespace)::CStringChecker::evalStrncasecmp", NM="_ZNK12_GLOBAL__N_114CStringChecker15evalStrncasecmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker15evalStrncasecmpERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrncasecmp(final CheckerContext /*&*/ C, 
                 /*const*/ CallExpr /*P*/ CE) /*const*/ {
    if ($less_uint(CE.getNumArgs(), 3)) {
      return;
    }

    //int strncasecmp(const char *s1, const char *s2, size_t n);
    evalStrcmpCommon(C, CE, /* isBounded = */ true, /* ignoreCase = */ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrcmpCommon">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1776,
   FQN="(anonymous namespace)::CStringChecker::evalStrcmpCommon", NM="_ZNK12_GLOBAL__N_114CStringChecker16evalStrcmpCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker16evalStrcmpCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprEbb")
  //</editor-fold>
  public void evalStrcmpCommon(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    evalStrcmpCommon(C, CE, 
                  false, false);
  }
  public void evalStrcmpCommon(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
                  boolean isBounded/*= false*/) /*const*/ {
    evalStrcmpCommon(C, CE, 
                  isBounded, false);
  }
  public void evalStrcmpCommon(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
                  boolean isBounded/*= false*/, boolean ignoreCase/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StSameBuf = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StNotSameBuf = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CurrentFunctionDescription = $("string comparison function");
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      
      // Check that the first string is non-null
      /*const*/ Expr /*P*/ s1 = CE.getArg$Const(0);
      SVal s1Val = state.$arrow().getSVal(s1, LCtx);
      $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), s1, new SVal(s1Val)))));
      if (!state.$bool()) {
        return;
      }

      // Check that the second string is non-null.
      /*const*/ Expr /*P*/ s2 = CE.getArg$Const(1);
      SVal s2Val = state.$arrow().getSVal(s2, LCtx);
      $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), s2, new SVal(s2Val)))));
      if (!state.$bool()) {
        return;
      }
  
      // Get the string length of the first string or give up.
      SVal s1Length = getCStringLength(C, state, s1, new SVal(s1Val));
      if (s1Length.isUndef$SVal()) {
        return;
      }
      
      // Get the string length of the second string or give up.
      SVal s2Length = getCStringLength(C, state, s2, new SVal(s2Val));
      if (s2Length.isUndef$SVal()) {
        return;
      }
      
      // If we know the two buffers are the same, we know the result is 0.
      // First, get the two buffers' addresses. Another checker will have already
      // made sure they're not undefined.
      DefinedOrUnknownSVal LV = s1Val.castAs(DefinedOrUnknownSVal.class);
      DefinedOrUnknownSVal RV = s2Val.castAs(DefinedOrUnknownSVal.class);
      
      // See if they are the same.
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      DefinedOrUnknownSVal SameBuf = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(LV), new DefinedOrUnknownSVal(RV)));
      StSameBuf/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      StNotSameBuf/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(StSameBuf, StNotSameBuf).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(SameBuf)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(SameBuf)));
      StSameBuf.$assign($assume.first);
      StNotSameBuf.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      // If the two arguments might be the same buffer, we know the result is 0,
      // and we only need to check one size.
      if (StSameBuf.$bool()) {
        $c$.clean(StSameBuf.$assign($c$.track(StSameBuf.$arrow().BindExpr(CE, LCtx, 
                new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(CE.getType()))))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StSameBuf))));
        
        // If the two arguments are GUARANTEED to be the same, we're done!
        if (!StNotSameBuf.$bool()) {
          return;
        }
      }
      assert ((StNotSameBuf).$bool());
      $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNotSameBuf))));
      
      // At this point we can go about comparing the two buffers.
      // For now, we only do this if they're both known string literals.
      
      // Attempt to extract string literals from both expressions.
      /*const*/ StringLiteral /*P*/ s1StrLiteral = getCStringLiteral(C, state, s1, new SVal(s1Val));
      /*const*/ StringLiteral /*P*/ s2StrLiteral = getCStringLiteral(C, state, s2, new SVal(s2Val));
      boolean canComputeResult = false;
      SVal resultVal = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, 
              C.blockCount()));
      if ((s1StrLiteral != null) && (s2StrLiteral != null)) {
        StringRef s1StrRef = s1StrLiteral.getString();
        StringRef s2StrRef = s2StrLiteral.getString();
        if (isBounded) {
          // Get the max number of characters to compare.
          /*const*/ Expr /*P*/ lenExpr = CE.getArg$Const(2);
          SVal lenVal = state.$arrow().getSVal(lenExpr, LCtx);
          {
            
            // If the length is known, we can get the right substrings.
            /*const*/ APSInt /*P*/ len = $c$.clean(svalBuilder.getKnownValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(lenVal)));
            if ((len != null)) {
              // Create substrings of each to compare the prefix.
              s1StrRef.$assignMove(s1StrRef.substr(0, (/*size_t*/int)$ulong2uint(len.getZExtValue())));
              s2StrRef.$assignMove(s2StrRef.substr(0, (/*size_t*/int)$ulong2uint(len.getZExtValue())));
              canComputeResult = true;
            }
          }
        } else {
          // This is a normal, unbounded strcmp.
          canComputeResult = true;
        }
        if (canComputeResult) {
          // Real strcmp stops at null characters.
          /*size_t*/int s1Term = s1StrRef.find($$TERM);
          if (s1Term != StringRef.npos) {
            s1StrRef.$assignMove(s1StrRef.substr(0, s1Term));
          }
          
          /*size_t*/int s2Term = s2StrRef.find($$TERM);
          if (s2Term != StringRef.npos) {
            s2StrRef.$assignMove(s2StrRef.substr(0, s2Term));
          }
          
          // Use StringRef's comparison methods to compute the actual result.
          int compareRes = ignoreCase ? s1StrRef.compare_lower(/*NO_COPY*/s2StrRef) : s1StrRef.compare(/*NO_COPY*/s2StrRef);
          
          // The strcmp function returns an integer greater than, equal to, or less
          // than zero, [c11, p7.24.4.2].
          if (compareRes == 0) {
            resultVal.$assignMove(svalBuilder.makeIntVal($int2ulong(compareRes), CE.getType()));
          } else {
            DefinedSVal zeroVal = svalBuilder.makeIntVal($int2ulong(0), CE.getType());
            // Constrain strcmp's result range based on the result of StringRef's
            // comparison methods.
            BinaryOperatorKind op = (compareRes == 1) ? BinaryOperatorKind.BO_GT : BinaryOperatorKind.BO_LT;
            SVal compareWithZero = $c$.clean(svalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new SVal(resultVal), new SVal(zeroVal), 
                svalBuilder.getConditionType()));
            DefinedSVal compareWithZeroVal = compareWithZero.castAs(DefinedSVal.class);
            $c$.clean(state.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(compareWithZeroVal), true))));
          }
        }
      }
      
      $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(resultVal)))));
      
      // Record this as a possible path.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (StNotSameBuf != null) { StNotSameBuf.$destroy(); }
      if (StSameBuf != null) { StSameBuf.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStrsep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1903,
   FQN="(anonymous namespace)::CStringChecker::evalStrsep", NM="_ZNK12_GLOBAL__N_114CStringChecker10evalStrsepERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker10evalStrsepERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStrsep(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //char *strsep(char **stringp, const char *delim);
      if ($less_uint(CE.getNumArgs(), 2)) {
        return;
      }

      // Sanity: does the search string parameter match the return type?
      /*const*/ Expr /*P*/ SearchStrPtr = CE.getArg$Const(0);
      QualType CharPtrTy = SearchStrPtr.getType().$arrow().getPointeeType();
      if (CharPtrTy.isNull()
         || QualType.$noteq_QualType$C(CE.getType().getUnqualifiedType(), CharPtrTy.getUnqualifiedType())) {
        return;
      }
  
      CurrentFunctionDescription = $("strsep()");
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
  
      // Check that the search string pointer is non-null (though it may point to
      // a null string).
      SVal SearchStrVal = State.$arrow().getSVal(SearchStrPtr, LCtx);
      $c$.clean(State.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), SearchStrPtr, new SVal(SearchStrVal)))));
      if (!State.$bool()) {
        return;
      }
      
      // Check that the delimiter string is non-null.
      /*const*/ Expr /*P*/ DelimStr = CE.getArg$Const(1);
      SVal DelimStrVal = State.$arrow().getSVal(DelimStr, LCtx);
      $c$.clean(State.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), DelimStr, new SVal(DelimStrVal)))));
      if (!State.$bool()) {
        return;
      }
      
      final SValBuilder /*&*/ SVB = C.getSValBuilder();
      SVal Result/*J*/= new SVal();
      {
        Optional<Loc> SearchStrLoc = SearchStrVal.getAs(Loc.class);
        if (SearchStrLoc.$bool()) {
          // Get the current value of the search string pointer, as a char*.
          Result.$assignMove(State.$arrow().getSVal(new Loc(SearchStrLoc.$star()), new QualType(CharPtrTy)));
          
          // Invalidate the search string, representing the change of one delimiter
          // character to NUL.
          $c$.clean(State.$assign($c$.track(InvalidateBuffer(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), SearchStrPtr, new SVal(Result), 
                  /*IsSourceBuffer*/ false, (/*const*/ Expr /*P*/ )null))));
          
          // Overwrite the search string pointer. The new value is either an address
          // further along in the same string, or NULL if there are no more tokens.
          $c$.clean(State.$assign($c$.track(State.$arrow().bindLoc(new Loc(SearchStrLoc.$star()), 
                  new SVal(JD$Move.INSTANCE, SVB.conjureSymbolVal(CStringChecker.getTag(), CE, LCtx, new QualType(CharPtrTy), 
                          C.blockCount()))))));
        } else {
          assert (SearchStrVal.isUnknown$SVal());
          // Conjure a symbolic value. It's the best we can do.
          Result.$assignMove(SVB.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, C.blockCount()));
        }
      }
      
      // Set the return value, and finish.
      $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CE, LCtx, new SVal(Result)))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  // These should probably be moved into a C++ standard library checker.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStdCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1961,
   FQN="(anonymous namespace)::CStringChecker::evalStdCopy", NM="_ZNK12_GLOBAL__N_114CStringChecker11evalStdCopyERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker11evalStdCopyERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStdCopy(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    evalStdCopyCommon(C, CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStdCopyBackward">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1965,
   FQN="(anonymous namespace)::CStringChecker::evalStdCopyBackward", NM="_ZNK12_GLOBAL__N_114CStringChecker19evalStdCopyBackwardERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker19evalStdCopyBackwardERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStdCopyBackward(final CheckerContext /*&*/ C, 
                     /*const*/ CallExpr /*P*/ CE) /*const*/ {
    evalStdCopyCommon(C, CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::evalStdCopyCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 1970,
   FQN="(anonymous namespace)::CStringChecker::evalStdCopyCommon", NM="_ZNK12_GLOBAL__N_114CStringChecker17evalStdCopyCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker17evalStdCopyCommonERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void evalStdCopyCommon(final CheckerContext /*&*/ C, 
                   /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
  
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      
      // template <class _InputIterator, class _OutputIterator>
      // _OutputIterator
      // copy(_InputIterator __first, _InputIterator __last,
      //        _OutputIterator __result)
      
      // Invalidate the destination buffer
      /*const*/ Expr /*P*/ Dst = CE.getArg$Const(2);
      SVal DstVal = State.$arrow().getSVal(Dst, LCtx);
      $c$.clean(State.$assign($c$.track(InvalidateBuffer(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Dst, new SVal(DstVal), /*IsSource=*/ false, 
              /*Size=*/ (/*const*/ Expr /*P*/ )null))));
      
      final SValBuilder /*&*/ SVB = C.getSValBuilder();
      
      SVal ResultVal = new SVal(JD$Move.INSTANCE, SVB.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, C.blockCount()));
      $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CE, LCtx, new SVal(ResultVal)))));
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Utility methods
  
  //===----------------------------------------------------------------------===//
  // Individual checks and utility methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::assumeZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 219,
   FQN="(anonymous namespace)::CStringChecker::assumeZero", NM="_ZN12_GLOBAL__N_114CStringChecker10assumeZeroERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS2_4SValENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker10assumeZeroERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS2_4SValENS1_8QualTypeE")
  //</editor-fold>
  public static std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState> > assumeZero(final CheckerContext /*&*/ C, IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal V, 
            QualType Ty) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Optional<DefinedSVal> val = V.getAs(DefinedSVal.class);
      if (!val.$bool()) {
        return new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState> >(JD$T$RR_T1$RR.INSTANCE, 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(state), 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(state));
      }

      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      DefinedOrUnknownSVal zero = svalBuilder.makeZeroVal(new QualType(Ty));
      return $c$.clean(state.$arrow().assume(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), 
              new DefinedOrUnknownSVal(val.$star()), new DefinedOrUnknownSVal(zero))));
    } finally {
      $c$.$destroy();
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::setCStringLength">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 632,
   FQN="(anonymous namespace)::CStringChecker::setCStringLength", NM="_ZN12_GLOBAL__N_114CStringChecker16setCStringLengthEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_9MemRegionENS4_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker16setCStringLengthEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_9MemRegionENS4_4SValE")
  //</editor-fold>
  public static IntrusiveRefCntPtr</*const*/ ProgramState> setCStringLength(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                  /*const*/ MemRegion /*P*/ MR, 
                  SVal strLength) {
    assert (!strLength.isUndef$SVal()) : "Attempt to set an undefined string length";
    
    MR = MR.StripCasts();
    switch (MR.getKind()) {
     case StringRegionKind:
      // FIXME: This can happen if we strcpy() into a string region. This is
      // undefined [C99 6.4.5p6], but we should still warn about it.
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
     case SymbolicRegionKind:
     case AllocaRegionKind:
     case VarRegionKind:
     case FieldRegionKind:
     case ObjCIvarRegionKind:
      // These are the types we can currently track string lengths for.
      break;
     case ElementRegionKind:
      // FIXME: Handle element regions by upper-bounding the parent region's
      // string length.
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
     default:
      // Other regions (mostly non-data) can't have a reliable C string length.
      // For now, just ignore the change.
      // FIXME: These are rare but not impossible. We should output some kind of
      // warning for things like strcpy((char[]){'a', 0}, "b");
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }
    if (strLength.isUnknown$SVal()) {
      return state.$arrow().remove(ProgramStateTraitCStringLength.$Instance, MR);
    }
    
    return state.$arrow().set(ProgramStateTraitCStringLength.$Instance, MR, new SVal(strLength));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::getCStringLengthForRegion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 672,
   FQN="(anonymous namespace)::CStringChecker::getCStringLengthForRegion", NM="_ZN12_GLOBAL__N_114CStringChecker25getCStringLengthForRegionERN5clang4ento14CheckerContextERN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprEPKNS2_9MemRegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker25getCStringLengthForRegionERN5clang4ento14CheckerContextERN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprEPKNS2_9MemRegionEb")
  //</editor-fold>
  public static SVal getCStringLengthForRegion(final CheckerContext /*&*/ C, 
                           final IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ state, 
                           /*const*/ Expr /*P*/ Ex, 
                           /*const*/ MemRegion /*P*/ MR, 
                           boolean hypothetical) {
    if (!hypothetical) {
      // If there's a recorded length, go ahead and return it.
      /*const*/ SVal /*P*/ Recorded = state.$arrow().get(ProgramStateTraitCStringLength.$Instance, MR);
      if ((Recorded != null)) {
        return new SVal($Deref(Recorded));
      }
    }
    
    // Otherwise, get a new symbol and update the state.
    final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
    QualType sizeTy = svalBuilder.getContext().getSizeType().$QualType();
    SVal strLength = new SVal(JD$Move.INSTANCE, svalBuilder.getMetadataSymbolVal(CStringChecker.getTag(), 
            MR, Ex, new QualType(sizeTy), 
            C.blockCount()));
    if (!hypothetical) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        {
          Optional<NonLoc> strLn = strLength.getAs(NonLoc.class);
          if (strLn.$bool()) {
            // In case of unbounded calls strlen etc bound the range to SIZE_MAX/4
            final BasicValueFactory /*&*/ BVF = svalBuilder.getBasicValueFactory();
            final /*const*/ APSInt /*&*/ maxValInt = BVF.getMaxValue(new QualType(sizeTy));
            APSInt fourInt = new APSIntType(maxValInt).getValue($int2ulong(4));
            /*const*/ APSInt /*P*/ maxLengthInt = BVF.evalAPSInt(BinaryOperatorKind.BO_Div, maxValInt, 
                fourInt);
            NonLoc maxLength = new NonLoc(JD$Move.INSTANCE, svalBuilder.makeIntVal($Deref(maxLengthInt)));
            SVal evalLength = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_LE, new NonLoc(strLn.$star()), 
                new NonLoc(maxLength), new QualType(sizeTy)));
            $c$.clean(state.$assign($c$.track(state.$arrow().assume(evalLength.castAs(DefinedOrUnknownSVal.class), true))));
          }
        }
        $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitCStringLength.$Instance, MR, new SVal(strLength)))));
      } finally {
        $c$.$destroy();
      }
    }
    
    return strLength;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::getCStringLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 710,
   FQN="(anonymous namespace)::CStringChecker::getCStringLength", NM="_ZNK12_GLOBAL__N_114CStringChecker16getCStringLengthERN5clang4ento14CheckerContextERN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker16getCStringLengthERN5clang4ento14CheckerContextERN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValEb")
  //</editor-fold>
  public SVal getCStringLength(final CheckerContext /*&*/ C, final IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ state, 
                  /*const*/ Expr /*P*/ Ex, SVal Buf) /*const*/ {
    return getCStringLength(C, state, 
                  Ex, Buf, 
                  false);
  }
  public SVal getCStringLength(final CheckerContext /*&*/ C, final IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ state, 
                  /*const*/ Expr /*P*/ Ex, SVal Buf, 
                  boolean hypothetical/*= false*/) /*const*/ {
    /*const*/ MemRegion /*P*/ MR = Buf.getAsRegion();
    if (!(MR != null)) {
      {
        // If we can't get a region, see if it's something we /know/ isn't a
        // C string. In the context of locations, the only time we can issue such
        // a warning is for labels.
        Optional<NsLoc.GotoLabel> Label = Buf.getAs(NsLoc.GotoLabel.class);
        if (Label.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (!Filter.CheckCStringNotNullTerm.$ConstBoolRef()) {
              return new SVal(JD$Move.INSTANCE, new UndefinedVal());
            }
            {

              ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              if ((N != null)) {
                raw_svector_ostream os = null;
                unique_ptr<BugReport> report = null;
                try {
                  if (!BT_NotCString.$bool()) {
                    BT_NotCString.reset(new BuiltinBug(new  CheckName(Filter.CheckNameCStringNotNullTerm), categories.UnixAPI, 
                            $("Argument is not a null-terminated string.")));
                  }
  
                  SmallString/*<120>*/ buf/*J*/= new SmallString/*<120>*/(120);
                  os/*J*/= new raw_svector_ostream(buf);
                  assert Native.$bool(CurrentFunctionDescription);
                  os.$out(/*KEEP_STR*/"Argument to ").$out(CurrentFunctionDescription).$out(
                      /*KEEP_STR*/" is the address of the label '"
                  ).$out(Label.$arrow().getLabel().getName()).$out(
                      /*KEEP_STR*/"', which is not a null-terminated string"
                  );
                  
                  // Generate a report for this bug.
                  report = llvm.make_unique(new BugReport(BT_NotCString.$star(), os.str(), N));
                  
                  report.$arrow().addRange(Ex.getSourceRange());
                  C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
                } finally {
                  if (report != null) { report.$destroy(); }
                  if (os != null) { os.$destroy(); }
                }
              }
            }
            return new SVal(JD$Move.INSTANCE, new UndefinedVal());
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If it's not a region and not a label, give up.
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // If we have a region, strip casts from it and see if we can figure out
    // its length. For anything we can't figure out, just return UnknownVal.
    MR = MR.StripCasts();
    switch (MR.getKind()) {
     case StringRegionKind:
      {
        // Modifying the contents of string regions is undefined [C99 6.4.5p6],
        // so we can assume that the byte length is the correct C string length.
        final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
        QualType sizeTy = svalBuilder.getContext().getSizeType().$QualType();
        /*const*/ StringLiteral /*P*/ strLit = cast_StringRegion(MR).getStringLiteral();
        return new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($uint2ulong(strLit.getByteLength()), new QualType(sizeTy)));
      }
     case SymbolicRegionKind:
     case AllocaRegionKind:
     case VarRegionKind:
     case FieldRegionKind:
     case ObjCIvarRegionKind:
      return getCStringLengthForRegion(C, state, Ex, MR, hypothetical);
     case CompoundLiteralRegionKind:
      // FIXME: Can we track this? Is it necessary?
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
     case ElementRegionKind:
      // FIXME: How can we handle this? It's not good enough to subtract the
      // offset from the base string length; consider "123\x00567" and &a[5].
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Other regions (mostly non-data) can't have a reliable C string length.
          // In this case, an error is emitted and UndefinedVal is returned.
          // The caller should always be prepared to handle this case.
          if (!Filter.CheckCStringNotNullTerm.$ConstBoolRef()) {
            return new SVal(JD$Move.INSTANCE, new UndefinedVal());
          }
          {
            
            ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
            if ((N != null)) {
              raw_svector_ostream os = null;
              unique_ptr<BugReport> report = null;
              try {
                if (!BT_NotCString.$bool()) {
                  BT_NotCString.reset(new BuiltinBug(new  CheckName(Filter.CheckNameCStringNotNullTerm), categories.UnixAPI, 
                          $("Argument is not a null-terminated string.")));
                }
                
                SmallString/*<120>*/ buf/*J*/= new SmallString/*<120>*/(120);
                os/*J*/= new raw_svector_ostream(buf);
                assert Native.$bool(CurrentFunctionDescription);
                os.$out(/*KEEP_STR*/"Argument to ").$out(CurrentFunctionDescription).$out(/*KEEP_STR*/" is ");
                if (CStringChecker.SummarizeRegion(os, C.getASTContext(), MR)) {
                  os.$out(/*KEEP_STR*/", which is not a null-terminated string");
                } else {
                  os.$out(/*KEEP_STR*/"not a null-terminated string");
                }
                
                // Generate a report for this bug.
                report = llvm.make_unique(new BugReport(BT_NotCString.$star(), os.str(), N));
                
                report.$arrow().addRange(Ex.getSourceRange());
                C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
              } finally {
                if (report != null) { report.$destroy(); }
                if (os != null) { os.$destroy(); }
              }
            }
          }
          
          return new SVal(JD$Move.INSTANCE, new UndefinedVal());
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::getCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 810,
   FQN="(anonymous namespace)::CStringChecker::getCStringLiteral", NM="_ZNK12_GLOBAL__N_114CStringChecker17getCStringLiteralERN5clang4ento14CheckerContextERN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker17getCStringLiteralERN5clang4ento14CheckerContextERN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValE")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getCStringLiteral(final CheckerContext /*&*/ C, 
                   final IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ state, /*const*/ Expr /*P*/ expr, SVal val) /*const*/ {
    
    // Get the memory region pointed to by the val.
    /*const*/ MemRegion /*P*/ bufRegion = val.getAsRegion();
    if (!(bufRegion != null)) {
      return null;
    }

    // Strip casts off the memory region.
    bufRegion = bufRegion.StripCasts();
  
    // Cast the memory region to a string region.
    /*const*/ StringRegion /*P*/ strRegion = dyn_cast_StringRegion(bufRegion);
    if (!(strRegion != null)) {
      return null;
    }
    
    // Return the actual string in the string region.
    return strRegion.getStringLiteral();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::InvalidateBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 893,
   FQN="(anonymous namespace)::CStringChecker::InvalidateBuffer", NM="_ZN12_GLOBAL__N_114CStringChecker16InvalidateBufferERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValEbSC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker16InvalidateBufferERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValEbSC_")
  //</editor-fold>
  public static IntrusiveRefCntPtr</*const*/ ProgramState> InvalidateBuffer(final CheckerContext /*&*/ C, 
                  IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                  /*const*/ Expr /*P*/ E, SVal V, 
                  boolean IsSourceBuffer, 
                  /*const*/ Expr /*P*/ Size) {
    Optional<Loc> L = V.getAs(Loc.class);
    if (!L.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }
    {

      // FIXME: This is a simplified version of what's in CFRefCount.cpp -- it makes
      // some assumptions about the value that CFRefCount can't. Even so, it should
      // probably be refactored.
      Optional<NsLoc.MemRegionVal> MR = L.$arrow().getAs(NsLoc.MemRegionVal.class);
      if (MR.$bool()) {
        RegionAndSymbolInvalidationTraits ITraits = null;
        try {
          /*const*/ MemRegion /*P*/ R = MR.$arrow().getRegion().StripCasts();
          {
  
            // Are we dealing with an ElementRegion?  If so, we should be invalidating
            // the super-region.
            /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(R);
            if ((ER != null)) {
              R = ER.getSuperRegion();
              // FIXME: What about layers of ElementRegions?
            }
          }
          
          // Invalidate this region.
          /*const*/ LocationContext /*P*/ LCtx = C.getPredecessor().getLocationContext();
          
          boolean CausesPointerEscape = false;
          ITraits/*J*/= new RegionAndSymbolInvalidationTraits();
          // Invalidate and escape only indirect regions accessible through the source
          // buffer.
          if (IsSourceBuffer) {
            ITraits.setTrait(R.getBaseRegion(), 
                RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_PreserveContents);
            ITraits.setTrait(R, RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_SuppressEscape);
            CausesPointerEscape = true;
          } else {
            final /*const*/ MemRegion.Kind /*&*/ K = R.getKind();
            if (K == MemRegion.Kind.FieldRegionKind) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if ($c$.clean((Size != null) && IsFirstBufInBound(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), E, Size))) {
                  // If destination buffer is a field region and access is in bound,
                  // do not invalidate its super region.
                  ITraits.setTrait(R, 
                      RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_DoNotInvalidateSuperRegion);
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          return state.$arrow().invalidateRegions_ArrayRef1(new ArrayRef</*const*/ MemRegion /*P*/ >(R, true), E, C.blockCount(), LCtx, 
              CausesPointerEscape, (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null, (/*const*/ CallEvent /*P*/ )null, 
              $AddrOf(ITraits));
        } finally {
          if (ITraits != null) { ITraits.$destroy(); }
        }
      }
    }
    
    // If we have a non-region value by chance, just remove the binding.
    // FIXME: is this necessary or correct? This handles the non-Region
    //  cases.  Is it ever valid to store to these?
    return state.$arrow().killBinding(new Loc(L.$star()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::SummarizeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 950,
   FQN="(anonymous namespace)::CStringChecker::SummarizeRegion", NM="_ZN12_GLOBAL__N_114CStringChecker15SummarizeRegionERN4llvm11raw_ostreamERN5clang10ASTContextEPKNS4_4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker15SummarizeRegionERN4llvm11raw_ostreamERN5clang10ASTContextEPKNS4_4ento9MemRegionE")
  //</editor-fold>
  public static boolean SummarizeRegion(final raw_ostream /*&*/ os, final ASTContext /*&*/ Ctx, 
                 /*const*/ MemRegion /*P*/ MR) {
    /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_TypedValueRegion(MR);
    switch (MR.getKind()) {
     case FunctionCodeRegionKind:
      {
        /*const*/ NamedDecl /*P*/ FD = cast_FunctionCodeRegion(MR).getDecl();
        if ((FD != null)) {
          $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"the address of the function '"), $Deref(FD)).$out_char($$SGL_QUOTE);
        } else {
          os.$out(/*KEEP_STR*/"the address of a function");
    }
        return true;
      }
     case BlockCodeRegionKind:
      os.$out(/*KEEP_STR*/"block text");
      return true;
     case BlockDataRegionKind:
      os.$out(/*KEEP_STR*/"a block");
      return true;
     case CXXThisRegionKind:
     case CXXTempObjectRegionKind:
      os.$out(/*KEEP_STR*/"a C++ temp object of type ").$out(TVR.getValueType().getAsString());
      return true;
     case VarRegionKind:
      os.$out(/*KEEP_STR*/"a variable of type").$out(TVR.getValueType().getAsString());
      return true;
     case FieldRegionKind:
      os.$out(/*KEEP_STR*/"a field of type ").$out(TVR.getValueType().getAsString());
      return true;
     case ObjCIvarRegionKind:
      os.$out(/*KEEP_STR*/"an instance variable of type ").$out(TVR.getValueType().getAsString());
      return true;
     default:
      return false;
    }
  }

  
  // Re-usable checks
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::checkNonNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 231,
   FQN="(anonymous namespace)::CStringChecker::checkNonNull", NM="_ZNK12_GLOBAL__N_114CStringChecker12checkNonNullERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker12checkNonNullERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkNonNull(final CheckerContext /*&*/ C, 
              IntrusiveRefCntPtr</*const*/ ProgramState> state, 
              /*const*/ Expr /*P*/ S, SVal l) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNonNull = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If a previous check has failed, propagate the failure.
      if (!state.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      stateNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateNonNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateNull, stateNonNull).$assign($c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(l), S.getType()))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeZero = 
              $c$.track(assumeZero(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(l), S.getType()));
      stateNull.$assign($assumeZero.first);
      stateNonNull.$assign($assumeZero.second);
      assert !$assumeZero.first.$bool();
      assert !$assumeZero.second.$bool();
      $c$.clean();
      
      if (stateNull.$bool() && !stateNonNull.$bool()) {
        raw_svector_ostream os = null;
        unique_ptr<BugReport> report = null;
        try {
          if (!Filter.CheckCStringNullArg.$ConstBoolRef()) {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
          
          ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNull))));
          if (!(N != null)) {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
          if (!BT_Null.$bool()) {
            BT_Null.reset(new BuiltinBug(new  CheckName(Filter.CheckNameCStringNullArg), categories.UnixAPI, 
                    $("Null pointer argument in call to byte string function")));
          }
          
          SmallString/*<80>*/ buf/*J*/= new SmallString/*<80>*/(80);
          os/*J*/= new raw_svector_ostream(buf);
          assert Native.$bool(CurrentFunctionDescription);
          os.$out(/*KEEP_STR*/"Null pointer argument in call to ").$out(CurrentFunctionDescription);
          
          // Generate a report for this bug.
          BuiltinBug /*P*/ BT = ((/*static_cast*/BuiltinBug /*P*/ )(BT_Null.get()));
          report = llvm.make_unique(new BugReport($Deref(BT), os.str(), N));
          
          report.$arrow().addRange(S.getSourceRange());
          NsBugreporter.trackNullOrUndefValue(N, S, report.$star());
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        } finally {
          if (report != null) { report.$destroy(); }
          if (os != null) { os.$destroy(); }
        }
      }
      
      // From here on, assume that the value is non-null.
      assert ((stateNonNull).$bool());
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, stateNonNull);
    } finally {
      if (stateNonNull != null) { stateNonNull.$destroy(); }
      if (stateNull != null) { stateNull.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // FIXME: This was originally copied from ArrayBoundChecker.cpp. Refactor?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CheckLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 275,
   FQN="(anonymous namespace)::CStringChecker::CheckLocation", NM="_ZNK12_GLOBAL__N_114CStringChecker13CheckLocationERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker13CheckLocationERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprENS2_4SValEPKc")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckLocation(final CheckerContext /*&*/ C, 
               IntrusiveRefCntPtr</*const*/ ProgramState> state, 
               /*const*/ Expr /*P*/ S, SVal l) /*const*/ {
    return CheckLocation(C, 
               state, 
               S, l, 
               (/*const*/char$ptr/*char P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckLocation(final CheckerContext /*&*/ C, 
               IntrusiveRefCntPtr</*const*/ ProgramState> state, 
               /*const*/ Expr /*P*/ S, SVal l, 
               /*const*/char$ptr/*char P*/ warningMsg/*= null*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> StInBound = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StOutBound = null;
    try {
      // If a previous check has failed, propagate the failure.
      if (!state.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // Check for out of bound array element access.
      /*const*/ MemRegion /*P*/ R = l.getAsRegion();
      if (!(R != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(R);
      if (!(ER != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      assert (QualType.$eq_QualType$C(ER.getValueType(), C.getASTContext().CharTy.$QualType())) : "CheckLocation should only be called with char* ElementRegions";
      
      // Get the size of the array.
      /*const*/ SubRegion /*P*/ superReg = cast_SubRegion(ER.getSuperRegion());
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      SVal Extent = svalBuilder.convertToArrayIndex(new SVal(JD$Move.INSTANCE, superReg.getExtent(svalBuilder)));
      DefinedOrUnknownSVal Size = Extent.castAs(DefinedOrUnknownSVal.class);
      
      // Get the index of the accessed element.
      DefinedOrUnknownSVal Idx = ER.getIndex().castAs(DefinedOrUnknownSVal.class);
      
      StInBound = state.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal(Size), true);
      StOutBound = state.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal(Size), false);
      if (StOutBound.$bool() && !StInBound.$bool()) {
        std.unique_ptr<BugReport> report = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StOutBound))));
          if (!(N != null)) {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
          if (!BT_Bounds.$bool()) {
            BT_Bounds.reset(new BuiltinBug(new  CheckName(Filter.CheckNameCStringOutOfBounds), $("Out-of-bound array access"), 
                    $("Byte string function accesses out-of-bound array element")));
          }
          BuiltinBug /*P*/ BT = ((/*static_cast*/BuiltinBug /*P*/ )(BT_Bounds.get()));
          
          // Generate a report for this bug.
          report/*J*/= new std.unique_ptr<BugReport>();
          if (Native.$bool(warningMsg)) {
            $c$.clean(report.$assignMove($c$.track(llvm.make_unique(new BugReport($Deref(BT), warningMsg, N)))));
          } else {
            raw_svector_ostream os = null;
            try {
              assert Native.$bool(CurrentFunctionDescription);
              assert (CurrentFunctionDescription.$at(0) != $$TERM);
              
              SmallString/*80*/ buf/*J*/= new SmallString/*80*/(80);
              os/*J*/= new raw_svector_ostream(buf);
              os.$out_char(toUppercase(CurrentFunctionDescription.$at(0))).$out(
                  /*JAVA: should it be just hex by casting to (Object)?*/CurrentFunctionDescription.$add(1)
              ).$out(
                  /*KEEP_STR*/" accesses out-of-bound array element"
              );
              $c$.clean(report.$assignMove($c$.track(llvm.make_unique(new BugReport($Deref(BT), os.str(), N)))));
            } finally {
              if (os != null) { os.$destroy(); }
            }
          }
          
          // FIXME: It would be nice to eventually make this diagnostic more clear,
          // e.g., by referencing the original declaration or by saying *why* this
          // reference is outside the range.
          report.$arrow().addRange(S.getSourceRange());
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        } finally {
          if (report != null) { report.$destroy(); }
          $c$.$destroy();
        }
      }
      
      // Array bound check succeeded.  From this point forward the array bound
      // should always succeed.
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, StInBound);
    } finally {
      if (StOutBound != null) { StOutBound.$destroy(); }
      if (StInBound != null) { StInBound.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CheckBufferAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 349,
   FQN="(anonymous namespace)::CStringChecker::CheckBufferAccess", NM="_ZNK12_GLOBAL__N_114CStringChecker17CheckBufferAccessERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_SC_PKcSE_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker17CheckBufferAccessERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_SC_PKcSE_b")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ FirstBuf, 
                   /*const*/ Expr /*P*/ SecondBuf) /*const*/ {
    return CheckBufferAccess(C, 
                   state, 
                   Size, 
                   FirstBuf, 
                   SecondBuf, 
                   (/*const*/char$ptr/*char P*/ )null, 
                   (/*const*/char$ptr/*char P*/ )null, 
                   false);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ FirstBuf, 
                   /*const*/ Expr /*P*/ SecondBuf, 
                   /*const*/char$ptr/*char P*/ firstMessage/*= null*/) /*const*/ {
    return CheckBufferAccess(C, 
                   state, 
                   Size, 
                   FirstBuf, 
                   SecondBuf, 
                   firstMessage, 
                   (/*const*/char$ptr/*char P*/ )null, 
                   false);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ FirstBuf, 
                   /*const*/ Expr /*P*/ SecondBuf, 
                   /*const*/char$ptr/*char P*/ firstMessage/*= null*/, 
                   /*const*/char$ptr/*char P*/ secondMessage/*= null*/) /*const*/ {
    return CheckBufferAccess(C, 
                   state, 
                   Size, 
                   FirstBuf, 
                   SecondBuf, 
                   firstMessage, 
                   secondMessage, 
                   false);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ FirstBuf, 
                   /*const*/ Expr /*P*/ SecondBuf, 
                   /*const*/char$ptr/*char P*/ firstMessage/*= null*/, 
                   /*const*/char$ptr/*char P*/ secondMessage/*= null*/, 
                   boolean WarnAboutSize/*= false*/) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If a previous check has failed, propagate the failure.
      if (!state.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }

      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      final ASTContext /*&*/ Ctx = svalBuilder.getContext();
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
  
      QualType sizeTy = Size.getType();
      QualType PtrTy = Ctx.getPointerType(/*NO_COPY*/Ctx.CharTy).$QualType();
      
      // Check that the first buffer is non-null.
      SVal BufVal = state.$arrow().getSVal(FirstBuf, LCtx);
      $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), FirstBuf, new SVal(BufVal)))));
      if (!state.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // If out-of-bounds checking is turned off, skip the rest.
      if (!Filter.CheckCStringOutOfBounds.$ConstBoolRef()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Get the access length and make sure it is known.
      // FIXME: This assumes the caller has already checked that the access length
      // is positive. And that it's unsigned.
      SVal LengthVal = state.$arrow().getSVal(Size, LCtx);
      Optional<NonLoc> Length = LengthVal.getAs(NonLoc.class);
      if (!Length.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Compute the offset of the last element to be accessed: size-1.
      NonLoc One = svalBuilder.makeIntVal($int2ulong(1), new QualType(sizeTy)).castAs(NonLoc.class);
      NonLoc LastOffset = $c$.clean(svalBuilder.
    evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_Sub, new NonLoc(Length.$star()), new NonLoc(One), new QualType(sizeTy)).castAs(NonLoc.class));
      
      // Check that the first buffer is sufficiently long.
      SVal BufStart = svalBuilder.evalCast(new SVal(BufVal), new QualType(PtrTy), FirstBuf.getType());
      {
        Optional<Loc> BufLoc = BufStart.getAs(Loc.class);
        if (BufLoc.$bool()) {
          /*const*/ Expr /*P*/ warningExpr = (WarnAboutSize ? Size : FirstBuf);
          
          SVal BufEnd = $c$.clean(svalBuilder.evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, new Loc(BufLoc.$star()), 
              new NonLoc(LastOffset), new QualType(PtrTy)));
          $c$.clean(state.$assign($c$.track(CheckLocation(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), warningExpr, new SVal(BufEnd), firstMessage))));
          
          // If the buffer isn't large enough, abort.
          if (!state.$bool()) {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
        }
      }
      
      // If there's a second buffer, check it as well.
      if ((SecondBuf != null)) {
        BufVal.$assignMove(state.$arrow().getSVal(SecondBuf, LCtx));
        $c$.clean(state.$assign($c$.track(checkNonNull(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), SecondBuf, new SVal(BufVal)))));
        if (!state.$bool()) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        }
        
        BufStart.$assignMove(svalBuilder.evalCast(new SVal(BufVal), new QualType(PtrTy), SecondBuf.getType()));
        {
          Optional<Loc> BufLoc = BufStart.getAs(Loc.class);
          if (BufLoc.$bool()) {
            /*const*/ Expr /*P*/ warningExpr = (WarnAboutSize ? Size : SecondBuf);
            
            SVal BufEnd = $c$.clean(svalBuilder.evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, new Loc(BufLoc.$star()), 
                new NonLoc(LastOffset), new QualType(PtrTy)));
            $c$.clean(state.$assign($c$.track(CheckLocation(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), warningExpr, new SVal(BufEnd), secondMessage))));
          }
        }
      }
      
      // Large enough or not, return this state!
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CheckBufferAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 177,
   FQN="(anonymous namespace)::CStringChecker::CheckBufferAccess", NM="_ZNK12_GLOBAL__N_114CStringChecker17CheckBufferAccessERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_PKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker17CheckBufferAccessERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_PKcb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ Buf) /*const*/ {
    return CheckBufferAccess(C, 
                   state, 
                   Size, 
                   Buf, 
                   (/*const*/char$ptr/*char P*/ )null, 
                   false);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ Buf, 
                   /*const*/char$ptr/*char P*/ message/*= null*/) /*const*/ {
    return CheckBufferAccess(C, 
                   state, 
                   Size, 
                   Buf, 
                   message, 
                   false);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckBufferAccess(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ Size, 
                   /*const*/ Expr /*P*/ Buf, 
                   /*const*/char$ptr/*char P*/ message/*= null*/, 
                   boolean WarnAboutSize/*= false*/) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // This is a convenience override.
      return $c$.clean(CheckBufferAccess(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Size, Buf, (/*const*/ Expr /*P*/ )null, message, (/*const*/char$ptr/*char P*/ )null, 
          WarnAboutSize));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CheckOverlap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 426,
   FQN="(anonymous namespace)::CStringChecker::CheckOverlap", NM="_ZNK12_GLOBAL__N_114CStringChecker12CheckOverlapERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_SC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker12CheckOverlapERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_SC_")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> CheckOverlap(final CheckerContext /*&*/ C, 
              IntrusiveRefCntPtr</*const*/ ProgramState> state, 
              /*const*/ Expr /*P*/ Size, 
              /*const*/ Expr /*P*/ First, 
              /*const*/ Expr /*P*/ Second) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> stateTrue = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateFalse = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Filter.CheckCStringBufferOverlap.$ConstBoolRef()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Do a simple check for overlap: if the two arguments are from the same
      // buffer, see if the end of the first is greater than the start of the second
      // or vice versa.
      
      // If a previous check has failed, propagate the failure.
      if (!state.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      stateTrue/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateFalse/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      
      // Get the buffer values and make sure they're known locations.
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal firstVal = state.$arrow().getSVal(First, LCtx);
      SVal secondVal = state.$arrow().getSVal(Second, LCtx);
      
      Optional<Loc> firstLoc = firstVal.getAs(Loc.class);
      if (!firstLoc.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      Optional<Loc> secondLoc = secondVal.getAs(Loc.class);
      if (!secondLoc.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Are the two values the same?
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
//      $c$.clean(std.tie(stateTrue, stateFalse).$assign(
//          $c$.track(state.$arrow().assume(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(firstLoc.$star()), new DefinedOrUnknownSVal(secondLoc.$star()))))
//      ));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(firstLoc.$star()), new DefinedOrUnknownSVal(secondLoc.$star()))));
      stateTrue.$assign($assume.first);
      stateFalse.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();

      if (stateTrue.$bool() && !stateFalse.$bool()) {
        // If the values are known to be equal, that's automatically an overlap.
        emitOverlapBug(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateTrue)), First, Second); $c$.clean();
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // assume the two expressions are not equal.
      assert ((stateFalse).$bool());
      $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateFalse))));
      
      // Which value comes first?
      QualType cmpTy = svalBuilder.getConditionType();
      SVal reverse = $c$.clean(svalBuilder.evalBinOpLL($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GT, 
          new Loc(firstLoc.$star()), new Loc(secondLoc.$star()), new QualType(cmpTy)));
      Optional<DefinedOrUnknownSVal> reverseTest = reverse.getAs(DefinedOrUnknownSVal.class);
      if (!reverseTest.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
//      $c$.clean(std.tie(stateTrue, stateFalse).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(reverseTest.$star())))));
      // JAVA: unfold std.tie
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume$1 = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(reverseTest.$star())));
      stateTrue.$assign($assume$1.first);
      stateFalse.$assign($assume$1.second);
      // states could swap here with input states, so no need for assert below, but need clean up to manage refCounts
      if (false) {
        assert !$assume$1.first.$bool();
        assert !$assume$1.second.$bool();
      }
      $c$.clean();
      
      if (stateTrue.$bool()) {
        if (stateFalse.$bool()) {
          // If we don't know which one comes first, we can't perform this test.
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
        } else {
          // Switch the values so that firstVal is before secondVal.
          std.swap(firstLoc, secondLoc);
          
          // Switch the Exprs as well, so that they still correspond.
          // std.swap(First, Second); // JAVA: in c++ both First and Second are just pointers, so:
          Expr $tmp = First;
          First = Second;
          Second = $tmp;
        }
      }
      
      // Get the length, and make sure it too is known.
      SVal LengthVal = state.$arrow().getSVal(Size, LCtx);
      Optional<NonLoc> Length = LengthVal.getAs(NonLoc.class);
      if (!Length.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Convert the first buffer's start address to char*.
      // Bail out if the cast fails.
      final ASTContext /*&*/ Ctx = svalBuilder.getContext();
      QualType CharPtrTy = Ctx.getPointerType(/*NO_COPY*/Ctx.CharTy).$QualType();
      SVal FirstStart = svalBuilder.evalCast(new SVal(firstLoc.$star()), new QualType(CharPtrTy), 
          First.getType());
      Optional<Loc> FirstStartLoc = FirstStart.getAs(Loc.class);
      if (!FirstStartLoc.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Compute the end of the first buffer. Bail out if THAT fails.
      SVal FirstEnd = $c$.clean(svalBuilder.evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, 
          new Loc(FirstStartLoc.$star()), new NonLoc(Length.$star()), new QualType(CharPtrTy)));
      Optional<Loc> FirstEndLoc = FirstEnd.getAs(Loc.class);
      if (!FirstEndLoc.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Is the end of the first buffer past the start of the second buffer?
      SVal Overlap = $c$.clean(svalBuilder.evalBinOpLL($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GT, 
          new Loc(FirstEndLoc.$star()), new Loc(secondLoc.$star()), new QualType(cmpTy)));
      Optional<DefinedOrUnknownSVal> OverlapTest = Overlap.getAs(DefinedOrUnknownSVal.class);
      if (!OverlapTest.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
//      $c$.clean(std.tie(stateTrue, stateFalse).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(OverlapTest.$star())))));
      // JAVA: unfold std.tie
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume$2 = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(OverlapTest.$star())));
      stateTrue.$assign($assume$2.first);
      stateFalse.$assign($assume$2.second);
      // states could swap here with input states, so no need for assert below, but need clean up to manage refCounts
      if (false) {
        assert !$assume$2.first.$bool();
        assert !$assume$2.second.$bool();
      }
      $c$.clean();
      
      if (stateTrue.$bool() && !stateFalse.$bool()) {
        // Overlap!
        emitOverlapBug(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateTrue)), First, Second); $c$.clean();
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // assume the two expressions don't overlap.
      assert ((stateFalse).$bool());
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, stateFalse);
    } finally {
      if (stateFalse != null) { stateFalse.$destroy(); }
      if (stateTrue != null) { stateTrue.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::emitOverlapBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 539,
   FQN="(anonymous namespace)::CStringChecker::emitOverlapBug", NM="_ZNK12_GLOBAL__N_114CStringChecker14emitOverlapBugERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4StmtESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker14emitOverlapBugERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4StmtESC_")
  //</editor-fold>
  public void emitOverlapBug(final CheckerContext /*&*/ C, IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                /*const*/ Stmt /*P*/ First, /*const*/ Stmt /*P*/ Second) /*const*/ {
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      if (!(N != null)) {
        return;
      }
      if (!BT_Overlap.$bool()) {
        BT_Overlap.reset(new BugType(new  CheckName(Filter.CheckNameCStringBufferOverlap), 
                new StringRef(categories.UnixAPI), new StringRef(/*KEEP_STR*/"Improper arguments")));
      }
      
      // Generate a report for this bug.
      report = llvm.make_unique(new BugReport(BT_Overlap.$star(), $("Arguments must not be overlapping buffers"), N));
      report.$arrow().addRange(First.getSourceRange());
      report.$arrow().addRange(Second.getSourceRange());
      
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::checkAdditionOverflow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 558,
   FQN="(anonymous namespace)::CStringChecker::checkAdditionOverflow", NM="_ZNK12_GLOBAL__N_114CStringChecker21checkAdditionOverflowERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS2_6NonLocESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK12_GLOBAL__N_114CStringChecker21checkAdditionOverflowERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS2_6NonLocESA_")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkAdditionOverflow(final CheckerContext /*&*/ C, 
                       IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                       NonLoc left, 
                       NonLoc right) /*const*/ {
    // If out-of-bounds checking is turned off, skip the rest.
    if (!Filter.CheckCStringOutOfBounds.$ConstBoolRef()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }
    
    // If a previous check has failed, propagate the failure.
    if (!state.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
    final BasicValueFactory /*&*/ BVF = svalBuilder.getBasicValueFactory();
    
    QualType sizeTy = svalBuilder.getContext().getSizeType().$QualType();
    final /*const*/ APSInt /*&*/ maxValInt = BVF.getMaxValue(new QualType(sizeTy));
    NonLoc maxVal = new NonLoc(JD$Move.INSTANCE, svalBuilder.makeIntVal(maxValInt));
    
    SVal maxMinusRight/*J*/= new SVal();
    if (right.getAs(NsNonloc.ConcreteInt.class).$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(maxMinusRight.$assignMove(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Sub, new NonLoc(maxVal), new NonLoc(right), 
                new QualType(sizeTy))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Try switching the operands. (The order of these two assignments is
        // important!)
        $c$.clean(maxMinusRight.$assignMove(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Sub, new NonLoc(maxVal), new NonLoc(left), 
                new QualType(sizeTy))));
        left.$assign(right);
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      Optional<NonLoc> maxMinusRightNL = maxMinusRight.getAs(NonLoc.class);
      if (maxMinusRightNL.$bool()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> stateOverflow = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> stateOkay = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          QualType cmpTy = svalBuilder.getConditionType();
          // If left > max - right, we have an overflow.
          SVal willOverflow = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GT, new NonLoc(left), 
              new NonLoc(maxMinusRightNL.$star()), new QualType(cmpTy)));
          
          stateOverflow/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          stateOkay/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//          $c$.clean(std.tie(stateOverflow, stateOkay).$assign(
//              $c$.track(state.$arrow().assume(willOverflow.castAs(DefinedOrUnknownSVal.class)))
//          ));
          // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
          std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                  $c$.track(state.$arrow().assume(willOverflow.castAs(DefinedOrUnknownSVal.class)));
          stateOverflow.$assign($assume.first);
          stateOkay.$assign($assume.second);
          assert !$assume.first.$bool();
          assert !$assume.second.$bool();
          $c$.clean();
          
          if (stateOverflow.$bool() && !stateOkay.$bool()) {
            // We have an overflow. Emit a bug report.
            ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateOverflow))));
            if (!(N != null)) {
              return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
            }
            if (!BT_AdditionOverflow.$bool()) {
              BT_AdditionOverflow.reset(new BuiltinBug(new  CheckName(Filter.CheckNameCStringOutOfBounds), $("API"), 
                      $("Sum of expressions causes overflow")));
            }
            
            // This isn't a great error message, but this should never occur in real
            // code anyway -- you'd have to create a buffer longer than a size_t can
            // represent, which is sort of a contradiction.
            /*const*/char$ptr/*char P*/ warning = $("This expression will create a string whose length is too big to be represented as a size_t");
            
            // Generate a report for this bug.
            C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_AdditionOverflow.$star(), new StringRef(warning), N)))); $c$.clean();
            
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
          
          // From now on, assume an overflow didn't occur.
          assert ((stateOkay).$bool());
          $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateOkay))));
        } finally {
          if (stateOkay != null) { stateOkay.$destroy(); }
          if (stateOverflow != null) { stateOverflow.$destroy(); }
          $c$.$destroy();
        }
      }
    }
    
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
  }

  
  // Return true if the destination buffer of the copy function may be in bound.
  // Expects SVal of Size to be positive and unsigned.
  // Expects SVal of FirstBuf to be a FieldRegion.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::IsFirstBufInBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 830,
   FQN="(anonymous namespace)::CStringChecker::IsFirstBufInBound", NM="_ZN12_GLOBAL__N_114CStringChecker17IsFirstBufInBoundERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringChecker17IsFirstBufInBoundERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprESC_")
  //</editor-fold>
  public static boolean IsFirstBufInBound(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Expr /*P*/ FirstBuf, 
                   /*const*/ Expr /*P*/ Size) {
    IntrusiveRefCntPtr</*const*/ ProgramState> StInBound = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If we do not know that the buffer is long enough we return 'true'.
      // Otherwise the parent region of this field region would also get
      // invalidated, which would lead to warnings based on an unknown state.
      
      // Originally copied from CheckBufferAccess and CheckLocation.
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      final ASTContext /*&*/ Ctx = svalBuilder.getContext();
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      
      QualType sizeTy = Size.getType();
      QualType PtrTy = Ctx.getPointerType(/*NO_COPY*/Ctx.CharTy).$QualType();
      SVal BufVal = state.$arrow().getSVal(FirstBuf, LCtx);
      
      SVal LengthVal = state.$arrow().getSVal(Size, LCtx);
      Optional<NonLoc> Length = LengthVal.getAs(NonLoc.class);
      if (!Length.$bool()) {
        return true; // cf top comment.
      }
      
      // Compute the offset of the last element to be accessed: size-1.
      NonLoc One = svalBuilder.makeIntVal($int2ulong(1), new QualType(sizeTy)).castAs(NonLoc.class);
      NonLoc LastOffset = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_Sub, new NonLoc(Length.$star()), new NonLoc(One), new QualType(sizeTy)).castAs(NonLoc.class));
      
      // Check that the first buffer is sufficiently long.
      SVal BufStart = svalBuilder.evalCast(new SVal(BufVal), new QualType(PtrTy), FirstBuf.getType());
      Optional<Loc> BufLoc = BufStart.getAs(Loc.class);
      if (!BufLoc.$bool()) {
        return true; // cf top comment.
      }
      
      SVal BufEnd = $c$.clean(svalBuilder.evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, new Loc(BufLoc.$star()), new NonLoc(LastOffset), new QualType(PtrTy)));
      
      // Check for out of bound array element access.
      /*const*/ MemRegion /*P*/ R = BufEnd.getAsRegion();
      if (!(R != null)) {
        return true; // cf top comment.
      }
      
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(R);
      if (!(ER != null)) {
        return true; // cf top comment.
      }
      assert (QualType.$eq_QualType$C(ER.getValueType(), C.getASTContext().CharTy.$QualType())) : "IsFirstBufInBound should only be called with char* ElementRegions";
      
      // Get the size of the array.
      /*const*/ SubRegion /*P*/ superReg = cast_SubRegion(ER.getSuperRegion());
      SVal Extent = svalBuilder.convertToArrayIndex(new SVal(JD$Move.INSTANCE, superReg.getExtent(svalBuilder)));
      DefinedOrUnknownSVal ExtentSize = Extent.castAs(DefinedOrUnknownSVal.class);
      
      // Get the index of the accessed element.
      DefinedOrUnknownSVal Idx = ER.getIndex().castAs(DefinedOrUnknownSVal.class);
      
      StInBound = state.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal(ExtentSize), true);
      
      return ((/*static_cast*/boolean)(StInBound.$bool()));
    } finally {
      if (StInBound != null) { StInBound.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::~CStringChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 32,
   FQN="(anonymous namespace)::CStringChecker::~CStringChecker", NM="_ZN12_GLOBAL__N_114CStringCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_AdditionOverflow.$destroy();
    BT_NotCString.$destroy();
    BT_Overlap.$destroy();
    BT_Bounds.$destroy();
    BT_Null.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CStringChecker::CStringChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 32,
   FQN="(anonymous namespace)::CStringChecker::CStringChecker", NM="_ZN12_GLOBAL__N_114CStringCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN12_GLOBAL__N_114CStringCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ CStringChecker() {
    // : Checker<eval::Call, PreStmt<DeclStmt>, LiveSymbols, DeadSymbols, RegionChanges>(), BT_Null(), BT_Bounds(), BT_Overlap(), BT_NotCString(), BT_AdditionOverflow(), Filter() 
    //START JInit
    super();
    this.BT_Null = new std.unique_ptr<BugType>();
    this.BT_Bounds = new std.unique_ptr<BugType>();
    this.BT_Overlap = new std.unique_ptr<BugType>();
    this.BT_NotCString = new std.unique_ptr<BugType>();
    this.BT_AdditionOverflow = new std.unique_ptr<BugType>();
    this.Filter = new CStringChecksFilter();
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof DeclStmt) {
      checkPreStmt((DeclStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new eval.Call(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<DeclStmt>(DeclStmt.class),
    new LiveSymbols(),
    new DeadSymbols(),
    new RegionChanges()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_Null=" + BT_Null // NOI18N
              + ", BT_Bounds=" + BT_Bounds // NOI18N
              + ", BT_Overlap=" + BT_Overlap // NOI18N
              + ", BT_NotCString=" + BT_NotCString // NOI18N
              + ", BT_AdditionOverflow=" + BT_AdditionOverflow // NOI18N
              + ", CurrentFunctionDescription=" + CurrentFunctionDescription // NOI18N
              + ", Filter=" + Filter // NOI18N
              + super.toString(); // NOI18N
  }
}
