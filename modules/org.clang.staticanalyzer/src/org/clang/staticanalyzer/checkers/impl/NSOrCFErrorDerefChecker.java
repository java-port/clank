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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.checkers.impl.NSErrorCheckerStatics.*;
import org.clang.staticanalyzer.java.*;
;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSOrCFErrorDerefChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 152,
 FQN="(anonymous namespace)::NSOrCFErrorDerefChecker", NM="_ZN12_GLOBAL__N_123NSOrCFErrorDerefCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN12_GLOBAL__N_123NSOrCFErrorDerefCheckerE")
//</editor-fold>
public class NSOrCFErrorDerefChecker extends /*public*/ Checker/*<Location, Event<ImplicitNullDerefEvent> > */
        implements org.clang.staticanalyzer.java.LocationChecker, org.clang.staticanalyzer.java.EventChecker, Destructors.ClassWithDestructor {
  private /*mutable */IdentifierInfo /*P*/ NSErrorII;
  private /*mutable */IdentifierInfo /*P*/ CFErrorII;
  private /*mutable */std.unique_ptr<NSErrorDerefBug> NSBT;
  private /*mutable */std.unique_ptr<CFErrorDerefBug> CFBT;
/*public:*/
  public boolean ShouldCheckNSError;
  public boolean ShouldCheckCFError;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSOrCFErrorDerefChecker::NSOrCFErrorDerefChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 160,
   FQN="(anonymous namespace)::NSOrCFErrorDerefChecker::NSOrCFErrorDerefChecker", NM="_ZN12_GLOBAL__N_123NSOrCFErrorDerefCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN12_GLOBAL__N_123NSOrCFErrorDerefCheckerC1Ev")
  //</editor-fold>
  public NSOrCFErrorDerefChecker() {
    // : Checker<Location, Event<ImplicitNullDerefEvent> >(), NSErrorII(null), CFErrorII(null), NSBT(), CFBT(), ShouldCheckNSError(0), ShouldCheckCFError(0) 
    //START JInit
    super();
    this.NSErrorII = null;
    this.CFErrorII = null;
    this.NSBT = new std.unique_ptr<NSErrorDerefBug>();
    this.CFBT = new std.unique_ptr<CFErrorDerefBug>();
    this.ShouldCheckNSError = false;
    this.ShouldCheckCFError = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSOrCFErrorDerefChecker::checkLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 203,
   FQN="(anonymous namespace)::NSOrCFErrorDerefChecker::checkLocation", NM="_ZNK12_GLOBAL__N_123NSOrCFErrorDerefChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZNK12_GLOBAL__N_123NSOrCFErrorDerefChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal loc, boolean isLoad, 
               /*const*/ Stmt /*P*/ S, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      if (!isLoad) {
        return;
      }
      if (loc.isUndef$SVal() || !loc.getAs(Loc.class).$bool()) {
        return;
      }

      final ASTContext /*&*/ Ctx = C.getASTContext();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());

      // If we are loading from NSError**/CFErrorRef* parameter, mark the resulting
      // SVal so that we can later check it when handling the
      // ImplicitNullDerefEvent event.
      // FIXME: Cumbersome! Maybe add hook at construction of SVals at start of
      // function ?
      QualType parmT = NSErrorCheckerStatics.parameterTypeFromSVal(new SVal(loc), C);
      if (parmT.isNull()) {
        return;
      }
      if (!(NSErrorII != null)) {
        NSErrorII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSError")));
      }
      if (!(CFErrorII != null)) {
        CFErrorII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFErrorRef")));
      }
      if (ShouldCheckNSError && NSErrorCheckerStatics.IsNSError(new QualType(parmT), NSErrorII)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NSErrorCheckerStatics./*<NSErrorOut>*/setFlag(ProgramStateTraitNSErrorOut.$Instance, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), state.$arrow().getSVal(loc.castAs(Loc.class)), C); $c$.clean();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (ShouldCheckCFError && NSErrorCheckerStatics.IsCFError(new QualType(parmT), CFErrorII)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NSErrorCheckerStatics./*<NSErrorOut>*/setFlag(ProgramStateTraitCFErrorOut.$Instance, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), state.$arrow().getSVal(loc.castAs(Loc.class)), C); $c$.clean();
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSOrCFErrorDerefChecker::checkEvent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 240,
   FQN="(anonymous namespace)::NSOrCFErrorDerefChecker::checkEvent", NM="_ZNK12_GLOBAL__N_123NSOrCFErrorDerefChecker10checkEventEN5clang4ento22ImplicitNullDerefEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZNK12_GLOBAL__N_123NSOrCFErrorDerefChecker10checkEventEN5clang4ento22ImplicitNullDerefEventE")
  //</editor-fold>
  public void checkEvent(ImplicitNullDerefEvent event) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    raw_svector_ostream os = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (event.IsLoad) {
        return;
      }
      
      SVal loc = new SVal(event.Location);
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(event.SinkNode.getState());
      final BugReporter /*&*/ BR = $Deref(event.BR);
      
      boolean isNSError = $c$.clean(NSErrorCheckerStatics./*<NSErrorOut>*/hasFlag(ProgramStateTraitNSErrorOut.$Instance, new SVal(loc), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      boolean isCFError = false;
      if (!isNSError) {
        $c$.clean(isCFError = NSErrorCheckerStatics./*<NSErrorOut>*/hasFlag(ProgramStateTraitCFErrorOut.$Instance, new SVal(loc), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
      if (!(isNSError || isCFError)) {
        return;
      }
      
      // Storing to possible null NSError/CFErrorRef out parameter.
      SmallString/*<128>*/ Buf/*J*/= new SmallString/*<128>*/(128);
      os/*J*/= new raw_svector_ostream(Buf);
      
      os.$out(/*KEEP_STR*/"Potential null dereference.  According to coding standards ");
      os.$out((isNSError ? $("in 'Creating and Returning NSError Objects' the parameter") : $("documented in CoreFoundation/CFError.h the parameter")));
      
      os.$out(/*KEEP_STR*/" may be null");
      
      BugType /*P*/ bug = null;
      if (isNSError) {
        if (!NSBT.$bool()) {
          NSBT.reset(new NSErrorDerefBug(this));
        }
        bug = NSBT.get();
      } else {
        if (!CFBT.$bool()) {
          CFBT.reset(new CFErrorDerefBug(this));
        }
        bug = CFBT.get();
      }
      BR.emitReport($c$.track(llvm.make_unique(new BugReport($Deref(bug), os.str(), event.SinkNode)))); $c$.clean();
    } finally {
      if (os != null) { os.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSOrCFErrorDerefChecker::~NSOrCFErrorDerefChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 152,
   FQN="(anonymous namespace)::NSOrCFErrorDerefChecker::~NSOrCFErrorDerefChecker", NM="_ZN12_GLOBAL__N_123NSOrCFErrorDerefCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN12_GLOBAL__N_123NSOrCFErrorDerefCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CFBT.$destroy();
    NSBT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new Location(),
    new Event<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  @Override public String toString() {
    return "" + "NSErrorII=" + NSErrorII // NOI18N
              + ", CFErrorII=" + CFErrorII // NOI18N
              + ", NSBT=" + NSBT // NOI18N
              + ", CFBT=" + CFBT // NOI18N
              + ", ShouldCheckNSError=" + ShouldCheckNSError // NOI18N
              + ", ShouldCheckCFError=" + ShouldCheckCFError // NOI18N
              + super.toString(); // NOI18N
  }
}
