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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \class NilReceiverBRVisitor
/// \brief Prints path notes when a message is sent to a nil receiver.
//<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 166,
 FQN="clang::ento::NilReceiverBRVisitor", NM="_ZN5clang4ento20NilReceiverBRVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento20NilReceiverBRVisitorE")
//</editor-fold>
public final class NilReceiverBRVisitor extends /*public*/ BugReporterVisitorImpl<NilReceiverBRVisitor> implements Destructors.ClassWithDestructor {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 170,
   FQN="clang::ento::NilReceiverBRVisitor::Profile", NM="_ZNK5clang4ento20NilReceiverBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento20NilReceiverBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object x = Profile$$.x;
    ID.AddPointer($AddrOf(x));
  }
  private static final class Profile$$ {
    static final/*static*/ Object x = NilReceiverBRVisitor.class;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1123,
   FQN="clang::ento::NilReceiverBRVisitor::VisitNode", NM="_ZN5clang4ento20NilReceiverBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento20NilReceiverBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ PrevN, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    raw_svector_ostream OS = null;
    try {
      Optional<org.clang.analysis.PreStmt> P = N.<org.clang.analysis.PreStmt>getLocationAs(org.clang.analysis.PreStmt.class);
      if (!P.$bool()) {
        return null;
      }
      
      /*const*/ Stmt /*P*/ S = P.$arrow().getStmt();
      /*const*/ Expr /*P*/ Receiver = getNilReceiver(S, N);
      if (!(Receiver != null)) {
        return null;
      }
      
      SmallString/*<256>*/ Buf/*J*/= new SmallString/*<256>*/(256);
      OS/*J*/= new raw_svector_ostream(Buf);
      {
        
        /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(S);
        if ((ME != null)) {
          OS.$out(/*KEEP_STR*/$SGL_QUOTE);
          ME.getSelector().print(OS);
          OS.$out(/*KEEP_STR*/"' not called");
        } else {
          OS.$out(/*KEEP_STR*/"No method is called");
        }
      }
      OS.$out(/*KEEP_STR*/" because the receiver is nil");
      
      // The receiver was nil, and hence the method was skipped.
      // Register a BugReporterVisitor to issue a message telling us how
      // the receiver was null.
      NsBugreporter.trackNullOrUndefValue(N, Receiver, BR, /*IsArg*/ false, 
          /*EnableNullFPSuppression*/ false);
      // Issue a message saying that the method was skipped.
      PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(Receiver, BRC.getSourceManager(), 
          new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
      return new PathDiagnosticEventPiece(L, OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  
  /// If the statement is a message send expression with nil receiver, returns
  /// the receiver expression. Returns NULL otherwise.
  
  /// If the statement is a message send expression with nil receiver, returns
  /// the receiver expression. Returns NULL otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor::getNilReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1109,
   FQN="clang::ento::NilReceiverBRVisitor::getNilReceiver", NM="_ZN5clang4ento20NilReceiverBRVisitor14getNilReceiverEPKNS_4StmtEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento20NilReceiverBRVisitor14getNilReceiverEPKNS_4StmtEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public static /*const*/ Expr /*P*/ getNilReceiver(/*const*/ Stmt /*P*/ S, 
                /*const*/ ExplodedNode /*P*/ N) {
    /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(S);
    if (!(ME != null)) {
      return null;
    }
    {
      /*const*/ Expr /*P*/ Receiver = ME.getInstanceReceiver$Const();
      if ((Receiver != null)) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
          SVal V = state.$arrow().getSVal(Receiver, N.getLocationContext());
          if ($c$.clean($c$.track(state.$arrow().isNull(new SVal(V))).isConstrainedTrue())) {
            return Receiver;
          }
        } finally {
          if (state != null) { state.$destroy(); }
          $c$.$destroy();
        }
      }
    }
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor::~NilReceiverBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 166,
   FQN="clang::ento::NilReceiverBRVisitor::~NilReceiverBRVisitor", NM="_ZN5clang4ento20NilReceiverBRVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento20NilReceiverBRVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor::NilReceiverBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 166,
   FQN="clang::ento::NilReceiverBRVisitor::NilReceiverBRVisitor", NM="_ZN5clang4ento20NilReceiverBRVisitorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento20NilReceiverBRVisitorC1Ev")
  //</editor-fold>
  public /*inline*/ NilReceiverBRVisitor() {
    // : BugReporterVisitorImpl<NilReceiverBRVisitor>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NilReceiverBRVisitor::NilReceiverBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 166,
   FQN="clang::ento::NilReceiverBRVisitor::NilReceiverBRVisitor", NM="_ZN5clang4ento20NilReceiverBRVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento20NilReceiverBRVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ NilReceiverBRVisitor(final /*const*/ NilReceiverBRVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<NilReceiverBRVisitor>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public NilReceiverBRVisitor clone() {
    return new NilReceiverBRVisitor(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
