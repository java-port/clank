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

package org.clang.staticanalyzer.core.bugreporter.ento;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerJavaDifferentiators.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.core.impl.BugReporterStatics;
import org.clang.staticanalyzer.core.impl.PathDiagnosticStatics;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 550,
 FQN="clang::ento::PathDiagnosticCallPiece", NM="_ZN5clang4ento23PathDiagnosticCallPieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPieceE")
//</editor-fold>
public class PathDiagnosticCallPiece extends /*public*/ PathDiagnosticPiece implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::PathDiagnosticCallPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 551,
   FQN="clang::ento::PathDiagnosticCallPiece::PathDiagnosticCallPiece", NM="_ZN5clang4ento23PathDiagnosticCallPieceC1EPKNS_4DeclERKNS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPieceC1EPKNS_4DeclERKNS0_22PathDiagnosticLocationE")
  //</editor-fold>
  private PathDiagnosticCallPiece(/*const*/ Decl /*P*/ callerD, 
      final /*const*/ PathDiagnosticLocation /*&*/ callReturnPos) {
    // : PathDiagnosticPiece(Call), Caller(callerD), Callee(null), NoExit(false), CallStackMessage(), callEnter(), callEnterWithin(), callReturn(callReturnPos), path() 
    //START JInit
    super(JD$Kind_DisplayHint.INSTANCE, Kind.Call);
    this.Caller = callerD;
    this.Callee = null;
    this.NoExit = false;
    this.CallStackMessage = new std.string();
    this.callEnter = new PathDiagnosticLocation();
    this.callEnterWithin = new PathDiagnosticLocation();
    this.callReturn = new PathDiagnosticLocation(callReturnPos);
    this._path = new PathPieces();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::PathDiagnosticCallPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 556,
   FQN="clang::ento::PathDiagnosticCallPiece::PathDiagnosticCallPiece", NM="_ZN5clang4ento23PathDiagnosticCallPieceC1ERNS0_10PathPiecesEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPieceC1ERNS0_10PathPiecesEPKNS_4DeclE")
  //</editor-fold>
  private PathDiagnosticCallPiece(final PathPieces /*&*/ oldPath, /*const*/ Decl /*P*/ caller) {
    // : PathDiagnosticPiece(Call), Caller(caller), Callee(null), NoExit(true), CallStackMessage(), callEnter(), callEnterWithin(), callReturn(), path(oldPath) 
    //START JInit
    super(JD$Kind_DisplayHint.INSTANCE, Kind.Call);
    this.Caller = caller;
    this.Callee = null;
    this.NoExit = true;
    this.CallStackMessage = new std.string();
    this.callEnter = new PathDiagnosticLocation();
    this.callEnterWithin = new PathDiagnosticLocation();
    this.callReturn = new PathDiagnosticLocation();
    this._path = new PathPieces(oldPath);
    //END JInit
  }

  
  private /*const*/ Decl /*P*/ Caller;
  private /*const*/ Decl /*P*/ Callee;
  
  // Flag signifying that this diagnostic has only call enter and no matching
  // call exit.
  private boolean NoExit;
  
  // The custom string, which should appear after the call Return Diagnostic.
  // TODO: Should we allow multiple diagnostics?
  private std.string CallStackMessage;
/*public:*/
  public PathDiagnosticLocation callEnter;
  public PathDiagnosticLocation callEnterWithin;
  public PathDiagnosticLocation callReturn;
  public PathPieces _path;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::~PathDiagnosticCallPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 60,
   FQN="clang::ento::PathDiagnosticCallPiece::~PathDiagnosticCallPiece", NM="_ZN5clang4ento23PathDiagnosticCallPieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPieceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    _path.$destroy();
    CallStackMessage.$destroy();
    super.$destroy();
    //END JDestroy
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::getCaller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 579,
   FQN="clang::ento::PathDiagnosticCallPiece::getCaller", NM="_ZNK5clang4ento23PathDiagnosticCallPiece9getCallerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece9getCallerEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getCaller() /*const*/ {
    return Caller;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::getCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 581,
   FQN="clang::ento::PathDiagnosticCallPiece::getCallee", NM="_ZNK5clang4ento23PathDiagnosticCallPiece9getCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece9getCalleeEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getCallee() /*const*/ {
    return Callee;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::setCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 898,
   FQN="clang::ento::PathDiagnosticCallPiece::setCallee", NM="_ZN5clang4ento23PathDiagnosticCallPiece9setCalleeERKNS_9CallEnterERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece9setCalleeERKNS_9CallEnterERKNS_13SourceManagerE")
  //</editor-fold>
  public void setCallee(final /*const*/ CallEnter /*&*/ CE, 
           final /*const*/ SourceManager /*&*/ SM) {
    /*const*/ StackFrameContext /*P*/ CalleeCtx = CE.getCalleeContext();
    Callee = CalleeCtx.getDecl();
    
    callEnterWithin.$assignMove(PathDiagnosticLocation.createBegin(Callee, SM));
    callEnter.$assignMove(PathDiagnosticStatics.getLocationForCaller(CalleeCtx, CE.getLocationContext(), SM));
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::hasCallStackMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 584,
   FQN="clang::ento::PathDiagnosticCallPiece::hasCallStackMessage", NM="_ZN5clang4ento23PathDiagnosticCallPiece19hasCallStackMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece19hasCallStackMessageEv")
  //</editor-fold>
  public boolean hasCallStackMessage() {
    return !CallStackMessage.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::setCallStackMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 585,
   FQN="clang::ento::PathDiagnosticCallPiece::setCallStackMessage", NM="_ZN5clang4ento23PathDiagnosticCallPiece19setCallStackMessageEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece19setCallStackMessageEN4llvm9StringRefE")
  //</editor-fold>
  public void setCallStackMessage(StringRef st) {
    CallStackMessage.$assignMove(st.$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 589,
   FQN="clang::ento::PathDiagnosticCallPiece::getLocation", NM="_ZNK5clang4ento23PathDiagnosticCallPiece11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece11getLocationEv")
  //</editor-fold>
  @Override public PathDiagnosticLocation getLocation() /*const*//* override*/ {
    return new PathDiagnosticLocation(callEnter);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::getCallEnterEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 977,
   FQN="clang::ento::PathDiagnosticCallPiece::getCallEnterEvent", NM="_ZNK5clang4ento23PathDiagnosticCallPiece17getCallEnterEventEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece17getCallEnterEventEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<PathDiagnosticEventPiece> getCallEnterEvent() /*const*/ {
    raw_svector_ostream Out = null;
    try {
      if (!(Callee != null)) {
        return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>((PathDiagnosticEventPiece /*P*/ )null);
      }
      
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(buf);
      
      Out.$out(/*KEEP_STR*/"Calling ");
      PathDiagnosticStatics.describeCodeDecl(Out, Callee, /*ExtendedDescription=*/ true);
      assert (callEnter.asLocation().isValid());
      return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>(new PathDiagnosticEventPiece(callEnter, Out.str()));
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::getCallEnterWithinCallerEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 992,
   FQN="clang::ento::PathDiagnosticCallPiece::getCallEnterWithinCallerEvent", NM="_ZNK5clang4ento23PathDiagnosticCallPiece29getCallEnterWithinCallerEventEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece29getCallEnterWithinCallerEventEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<PathDiagnosticEventPiece> getCallEnterWithinCallerEvent() /*const*/ {
    raw_svector_ostream Out = null;
    try {
      if (!callEnterWithin.asLocation().isValid()) {
        return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>((PathDiagnosticEventPiece /*P*/ )null);
      }
      if (Callee.isImplicit() || !Callee.hasBody()) {
        return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>((PathDiagnosticEventPiece /*P*/ )null);
      }
      {
        /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Callee);
        if ((MD != null)) {
          if (MD.isDefaulted()) {
            return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>((PathDiagnosticEventPiece /*P*/ )null);
          }
        }
      }
      
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(buf);
      
      Out.$out(/*KEEP_STR*/"Entered call");
      PathDiagnosticStatics.describeCodeDecl(Out, Caller, /*ExtendedDescription=*/ false, new StringRef(/*KEEP_STR*/" from "));
      
      return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>(new PathDiagnosticEventPiece(callEnterWithin, Out.str()));
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::getCallExitEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1011,
   FQN="clang::ento::PathDiagnosticCallPiece::getCallExitEvent", NM="_ZNK5clang4ento23PathDiagnosticCallPiece16getCallExitEventEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece16getCallExitEventEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<PathDiagnosticEventPiece> getCallExitEvent() /*const*/ {
    raw_svector_ostream Out = null;
    try {
      if (NoExit) {
        return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>((PathDiagnosticEventPiece /*P*/ )null);
      }
      
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(buf);
      if (!CallStackMessage.empty()) {
        Out.$out(CallStackMessage);
      } else {
        boolean DidDescribe = PathDiagnosticStatics.describeCodeDecl(Out, Callee, 
            /*ExtendedDescription=*/ false, 
            new StringRef(/*KEEP_STR*/"Returning from "));
        if (!DidDescribe) {
          Out.$out(/*KEEP_STR*/"Returning to caller");
        }
      }
      assert (callReturn.asLocation().isValid());
      return new IntrusiveRefCntPtr<PathDiagnosticEventPiece>(new PathDiagnosticEventPiece(callReturn, Out.str()));
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::flattenLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 598,
   FQN="clang::ento::PathDiagnosticCallPiece::flattenLocations", NM="_ZN5clang4ento23PathDiagnosticCallPiece16flattenLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece16flattenLocationsEv")
  //</editor-fold>
  @Override public void flattenLocations()/* override*/ {
    callEnter.flatten();
    callReturn.flatten();
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin(), 
        E = _path.end(); I.$noteq(E); I.$preInc())  {
      (I.$star()).$arrow().flattenLocations();
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Manipulation of PathDiagnosticCallPieces.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::construct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 878,
   FQN="clang::ento::PathDiagnosticCallPiece::construct", NM="_ZN5clang4ento23PathDiagnosticCallPiece9constructEPKNS0_12ExplodedNodeERKNS_11CallExitEndERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece9constructEPKNS0_12ExplodedNodeERKNS_11CallExitEndERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticCallPiece /*P*/ construct(/*const*/ ExplodedNode /*P*/ N, 
           final /*const*/ CallExitEnd /*&*/ CE, 
           final /*const*/ SourceManager /*&*/ SM) {
    /*const*/ Decl /*P*/ caller = CE.getLocationContext().getDecl();
    PathDiagnosticLocation pos = PathDiagnosticStatics.getLocationForCaller(CE.getCalleeContext(), 
        CE.getLocationContext(), 
        SM);
    return new PathDiagnosticCallPiece(caller, pos);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::construct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 889,
   FQN="clang::ento::PathDiagnosticCallPiece::construct", NM="_ZN5clang4ento23PathDiagnosticCallPiece9constructERNS0_10PathPiecesEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece9constructERNS0_10PathPiecesEPKNS_4DeclE")
  //</editor-fold>
  public static PathDiagnosticCallPiece /*P*/ construct(final PathPieces /*&*/ _path, 
           /*const*/ Decl /*P*/ caller) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      PathDiagnosticCallPiece /*P*/ C = new PathDiagnosticCallPiece(_path, caller);
      _path.clear();
      _path.push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(C))); $c$.clean();
      return C;
    } finally {
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3490,
   FQN="clang::ento::PathDiagnosticCallPiece::dump", NM="_ZNK5clang4ento23PathDiagnosticCallPiece4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece4dumpEv")
  //</editor-fold>
  @Override public void dump() /*const*//* __attribute__((used)) __attribute__((noinline)) override*/ {
    llvm.errs().$out(/*KEEP_STR*/"CALL\n--------------\n");
    {
      
      /*const*/ Stmt /*P*/ SLoc = BugReporterStatics.getLocStmt(getLocation());
      if ((SLoc != null)) {
        SLoc.dump();
      } else {
        /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(getCallee());
        if ((ND != null)) {
          $out_raw_ostream_NamedDecl$C(llvm.errs(), $Deref(ND)).$out(/*KEEP_STR*/$LF);
        } else {
          getLocation().dump();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1075,
   FQN="clang::ento::PathDiagnosticCallPiece::Profile", NM="_ZNK5clang4ento23PathDiagnosticCallPiece7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento23PathDiagnosticCallPiece7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    super.Profile(ID);
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> it = _path.begin$Const(), 
        et = _path.end$Const(); it.$noteq(et); it.$preInc()) {
      ID.Add(it.$star().$star());
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticCallPiece::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 616,
   FQN="clang::ento::PathDiagnosticCallPiece::classof", NM="_ZN5clang4ento23PathDiagnosticCallPiece7classofEPKNS0_19PathDiagnosticPieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento23PathDiagnosticCallPiece7classofEPKNS0_19PathDiagnosticPieceE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ PathDiagnosticPiece /*P*/ P) {
    return P.getKind() == Kind.Call;
  }

  
  @Override public String toString() {
    return "" + "Caller=" + "[Decl]" // NOI18N
              + ", Callee=" + "[Decl]" // NOI18N
              + ", NoExit=" + NoExit // NOI18N
              + ", CallStackMessage=" + CallStackMessage // NOI18N
              + ", callEnter=" + callEnter // NOI18N
              + ", callEnterWithin=" + callEnterWithin // NOI18N
              + ", callReturn=" + callReturn // NOI18N
              + ", _path=" + _path // NOI18N
              + super.toString(); // NOI18N
  }
}
