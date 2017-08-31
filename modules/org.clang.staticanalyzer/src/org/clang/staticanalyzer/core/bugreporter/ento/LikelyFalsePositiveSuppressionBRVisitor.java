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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Suppress reports that might lead to known false positives.
///
/// Currently this suppresses reports based on locations of bugs.
//<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 253,
 FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorE")
//</editor-fold>
public final class LikelyFalsePositiveSuppressionBRVisitor extends /*public*/ BugReporterVisitorImpl<LikelyFalsePositiveSuppressionBRVisitor> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 256,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::getTag", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitor6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitor6getTagEv")
  //</editor-fold>
  public static Object/*void P*/ getTag() {
    final/*static*/ Object Tag = getTag$$.Tag;
    return (reinterpret_cast(/*static_cast*/Object/*void P*/ .class, ($AddrOf(Tag))));
  }
  private static final class getTag$$ {
    static final/*static*/ Object Tag = LikelyFalsePositiveSuppressionBRVisitor.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 261,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::Profile", NM="_ZNK5clang4ento39LikelyFalsePositiveSuppressionBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento39LikelyFalsePositiveSuppressionBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ID.AddPointer(getTag());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 265,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::VisitNode", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ Prev, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::getEndPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1555,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::getEndPath", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitor10getEndPathERNS0_18BugReporterContextEPKNS0_12ExplodedNodeERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitor10getEndPathERNS0_18BugReporterContextEPKNS0_12ExplodedNodeERNS0_9BugReportE")
  //</editor-fold>
  @Override public std.unique_ptr<PathDiagnosticPiece> getEndPath(final BugReporterContext /*&*/ BRC, 
            /*const*/ ExplodedNode /*P*/ N, 
            final BugReport /*&*/ BR)/* override*/ {
    // Here we suppress false positives coming from system headers. This list is
    // based on known issues.
    final ExprEngine /*&*/ Eng = BRC.getBugReporter().getEngine();
    final AnalyzerOptions /*&*/ Options = Eng.getAnalysisManager().options;
    /*const*/ Decl /*P*/ D = N.getLocationContext().getDecl();
    if (AnalysisDeclContext.isInStdNamespace(D)) {
      // Skip reports within the 'std' namespace. Although these can sometimes be
      // the user's fault, we currently don't report them very well, and
      // Note that this will not help for any other data structure libraries, like
      // TR1, Boost, or llvm/ADT.
      if (Options.shouldSuppressFromCXXStandardLibrary()) {
        BR.markInvalid(getTag(), (/*const*/Object/*void P*/ )null);
        return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
      } else {
        {
          // If the complete 'std' suppression is not enabled, suppress reports
          // from the 'std' namespace that are known to produce false positives.
          
          // The analyzer issues a false use-after-free when std::list::pop_front
          // or std::list::pop_back are called multiple times because we cannot
          // reason about the internal invariants of the datastructure.
          /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
          if ((MD != null)) {
            /*const*/ CXXRecordDecl /*P*/ CD = MD.getParent$Const();
            if ($eq_StringRef(CD.getName(), /*STRINGREF_STR*/"list")) {
              BR.markInvalid(getTag(), (/*const*/Object/*void P*/ )null);
              return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
            }
          }
        }
        {
          
          // The analyzer issues a false positive when the constructor of
          // std::__independent_bits_engine from algorithms is used.
          /*const*/ CXXConstructorDecl /*P*/ MD = dyn_cast_CXXConstructorDecl(D);
          if ((MD != null)) {
            /*const*/ CXXRecordDecl /*P*/ CD = MD.getParent$Const();
            if ($eq_StringRef(CD.getName(), /*STRINGREF_STR*/"__independent_bits_engine")) {
              BR.markInvalid(getTag(), (/*const*/Object/*void P*/ )null);
              return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
            }
          }
        }
        
        for (/*const*/ LocationContext /*P*/ LCtx = N.getLocationContext(); (LCtx != null);
             LCtx = LCtx.getParent()) {
          /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(LCtx.getDecl());
          if (!(MD != null)) {
            continue;
          }
          
          /*const*/ CXXRecordDecl /*P*/ CD = MD.getParent$Const();
          // The analyzer issues a false positive on
          //   std::basic_string<uint8_t> v; v.push_back(1);
          // and
          //   std::u16string s; s += u'a';
          // because we cannot reason about the internal invariants of the
          // datastructure.
          if ($eq_StringRef(CD.getName(), /*STRINGREF_STR*/"basic_string")) {
            BR.markInvalid(getTag(), (/*const*/Object/*void P*/ )null);
            return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
          }
          
          // The analyzer issues a false positive on
          //    std::shared_ptr<int> p(new int(1)); p = nullptr;
          // because it does not reason properly about temporary destructors.
          if ($eq_StringRef(CD.getName(), /*STRINGREF_STR*/"shared_ptr")) {
            BR.markInvalid(getTag(), (/*const*/Object/*void P*/ )null);
            return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
          }
        }
      }
    }
    
    // Skip reports within the sys/queue.h macros as we do not have the ability to
    // reason about data structure shapes.
    final SourceManager /*&*/ SM = BRC.getSourceManager();
    FullSourceLoc Loc = BR.getLocation(SM).asLocation();
    while (Loc.isMacroID()) {
      Loc.$assignMove(Loc.getSpellingLoc());
      if (SM.getFilename(/*NO_COPY*/Loc).endswith(/*STRINGREF_STR*/"sys/queue.h")) {
        BR.markInvalid(getTag(), (/*const*/Object/*void P*/ )null);
        return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
      }
    }
    
    return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::~LikelyFalsePositiveSuppressionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 253,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::~LikelyFalsePositiveSuppressionBRVisitor", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::LikelyFalsePositiveSuppressionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 253,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::LikelyFalsePositiveSuppressionBRVisitor", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorC1Ev")
  //</editor-fold>
  public /*inline*/ LikelyFalsePositiveSuppressionBRVisitor() {
    // : BugReporterVisitorImpl<LikelyFalsePositiveSuppressionBRVisitor>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::LikelyFalsePositiveSuppressionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 253,
   FQN="clang::ento::LikelyFalsePositiveSuppressionBRVisitor::LikelyFalsePositiveSuppressionBRVisitor", NM="_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento39LikelyFalsePositiveSuppressionBRVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LikelyFalsePositiveSuppressionBRVisitor(final /*const*/ LikelyFalsePositiveSuppressionBRVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<LikelyFalsePositiveSuppressionBRVisitor>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  @Override public LikelyFalsePositiveSuppressionBRVisitor clone() {
    return new LikelyFalsePositiveSuppressionBRVisitor(this);
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
