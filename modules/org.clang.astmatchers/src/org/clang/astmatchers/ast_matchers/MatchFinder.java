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

package org.clang.astmatchers.ast_matchers;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.SourceManager;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


/// \brief A class to allow finding matches over the Clang AST.
///
/// After creation, you can add multiple matchers to the MatchFinder via
/// calls to addMatcher(...).
///
/// Once all matchers are added, newASTConsumer() returns an ASTConsumer
/// that will trigger the callbacks specified via addMatcher(...) when a match
/// is found.
///
/// The order of matches is guaranteed to be equivalent to doing a pre-order
/// traversal on the AST, and applying the matchers in the order in which they
/// were added to the MatchFinder.
///
/// See ASTMatchers.h for more information about how to create matchers.
///
/// Not intended to be subclassed.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 69,
 FQN="clang::ast_matchers::MatchFinder", NM="_ZN5clang12ast_matchers11MatchFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinderE")
//</editor-fold>
public class MatchFinder implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Contains all information for a given match.
  ///
  /// Every time a match is found, the MatchFinder will invoke the registered
  /// MatchCallback with a MatchResult containing information about the match.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 75,
   FQN="clang::ast_matchers::MatchFinder::MatchResult", NM="_ZN5clang12ast_matchers11MatchFinder11MatchResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder11MatchResultE")
  //</editor-fold>
  public static class/*struct*/ MatchResult implements Destructors.ClassWithDestructor {
    // end namespace internal
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchResult::MatchResult">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 888,
     FQN="clang::ast_matchers::MatchFinder::MatchResult::MatchResult", NM="_ZN5clang12ast_matchers11MatchFinder11MatchResultC1ERKNS0_10BoundNodesEPNS_10ASTContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder11MatchResultC1ERKNS0_10BoundNodesEPNS_10ASTContextE")
    //</editor-fold>
    public MatchResult(final /*const*/ BoundNodes /*&*/ Nodes, 
        ASTContext /*P*/ Context) {
      // : Nodes(Nodes), Context(Context), SourceManager(&Context->getSourceManager()) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Contains the nodes bound on the current match.
    ///
    /// This allows user code to easily extract matched AST nodes.
    public /*const*/ BoundNodes Nodes;
    
    /// \brief Utilities for interpreting the matched AST structures.
    /// @{
    public ASTContext /*P*/ /*const*/ Context;
    public SourceManager /*P*/ /*const*/ SourceManager;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchResult::~MatchResult">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 75,
     FQN="clang::ast_matchers::MatchFinder::MatchResult::~MatchResult", NM="_ZN5clang12ast_matchers11MatchFinder11MatchResultD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder11MatchResultD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Nodes=" + Nodes // NOI18N
                + ", Context=" + Context // NOI18N
                + ", SourceManager=" + "[SourceManager]"; // NOI18N
    }
  /// @}
    };
  
  /// \brief Called when the Match registered for it was successfully found
  /// in the AST.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 92,
   FQN="clang::ast_matchers::MatchFinder::MatchCallback", NM="_ZN5clang12ast_matchers11MatchFinder13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder13MatchCallbackE")
  //</editor-fold>
  public abstract static class MatchCallback implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback::~MatchCallback">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 893,
     FQN="clang::ast_matchers::MatchFinder::MatchCallback::~MatchCallback", NM="_ZN5clang12ast_matchers11MatchFinder13MatchCallbackD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder13MatchCallbackD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Called on every match by the \c MatchFinder.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback::run">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 97,
     FQN="clang::ast_matchers::MatchFinder::MatchCallback::run", NM="_ZN5clang12ast_matchers11MatchFinder13MatchCallback3runERKNS1_11MatchResultE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder13MatchCallback3runERKNS1_11MatchResultE")
    //</editor-fold>
    public abstract /*virtual*/ void run(final /*const*/ MatchResult /*&*/ Result)/* = 0*/;

    
    /// \brief Called at the start of each translation unit.
    ///
    /// Optionally override to do per translation unit tasks.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback::onStartOfTranslationUnit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 102,
     FQN="clang::ast_matchers::MatchFinder::MatchCallback::onStartOfTranslationUnit", NM="_ZN5clang12ast_matchers11MatchFinder13MatchCallback24onStartOfTranslationUnitEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder13MatchCallback24onStartOfTranslationUnitEv")
    //</editor-fold>
    public /*virtual*/ void onStartOfTranslationUnit() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Called at the end of each translation unit.
    ///
    /// Optionally override to do per translation unit tasks.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback::onEndOfTranslationUnit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 107,
     FQN="clang::ast_matchers::MatchFinder::MatchCallback::onEndOfTranslationUnit", NM="_ZN5clang12ast_matchers11MatchFinder13MatchCallback22onEndOfTranslationUnitEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder13MatchCallback22onEndOfTranslationUnitEv")
    //</editor-fold>
    public /*virtual*/ void onEndOfTranslationUnit() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief An id used to group the matchers.
    ///
    /// This id is used, for example, for the profiling output.
    /// It defaults to "<unknown>".
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback::getID">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 985,
     FQN="clang::ast_matchers::MatchFinder::MatchCallback::getID", NM="_ZNK5clang12ast_matchers11MatchFinder13MatchCallback5getIDEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers11MatchFinder13MatchCallback5getIDEv")
    //</editor-fold>
    public StringRef getID() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchCallback::MatchCallback">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 92,
     FQN="clang::ast_matchers::MatchFinder::MatchCallback::MatchCallback", NM="_ZN5clang12ast_matchers11MatchFinder13MatchCallbackC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang12ast_matchers11MatchFinder13MatchCallbackC1Ev")
    //</editor-fold>
    public /*inline*/ MatchCallback() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// \brief Called when parsing is finished. Intended for testing only.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::ParsingDoneTestCallback">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 117,
   FQN="clang::ast_matchers::MatchFinder::ParsingDoneTestCallback", NM="_ZN5clang12ast_matchers11MatchFinder23ParsingDoneTestCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder23ParsingDoneTestCallbackE")
  //</editor-fold>
  public abstract static class ParsingDoneTestCallback implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::ParsingDoneTestCallback::~ParsingDoneTestCallback">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 894,
     FQN="clang::ast_matchers::MatchFinder::ParsingDoneTestCallback::~ParsingDoneTestCallback", NM="_ZN5clang12ast_matchers11MatchFinder23ParsingDoneTestCallbackD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder23ParsingDoneTestCallbackD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::ParsingDoneTestCallback::run">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 120,
     FQN="clang::ast_matchers::MatchFinder::ParsingDoneTestCallback::run", NM="_ZN5clang12ast_matchers11MatchFinder23ParsingDoneTestCallback3runEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder23ParsingDoneTestCallback3runEv")
    //</editor-fold>
    public abstract /*virtual*/ void run()/* = 0*/;

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 123,
   FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsE")
  //</editor-fold>
  public static class/*struct*/ MatchFinderOptions implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions::Profiling">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 124,
     FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions::Profiling", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptions9ProfilingE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptions9ProfilingE")
    //</editor-fold>
    public static class/*struct*/ Profiling {
      //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions::Profiling::Profiling">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 125,
       FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions::Profiling::Profiling", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptions9ProfilingC1ERN4llvm9StringMapINS4_10TimeRecordENS4_15MallocAllocatorEEE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptions9ProfilingC1ERN4llvm9StringMapINS4_10TimeRecordENS4_15MallocAllocatorEEE")
      //</editor-fold>
      public Profiling(final StringMap<TimeRecord> /*&*/ Records) {
        // : Records(Records) 
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      /// \brief Per bucket timing information.
      public final StringMap<TimeRecord> /*&*/ Records;
      //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions::Profiling::Profiling">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 124,
       FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions::Profiling::Profiling", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptions9ProfilingC1EOS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptions9ProfilingC1EOS3_")
      //</editor-fold>
      public /*inline*/ Profiling(JD$Move _dparam, final Profiling /*&&*/$Prm0) {
        // : Records(static_cast<Profiling &&>().Records) 
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      @Override public String toString() {
        return "" + "Records=" + Records; // NOI18N
      }
    };
    
    /// \brief Enables per-check timers.
    ///
    /// It prints a report after match.
    public Optional<Profiling> CheckProfiling;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions::MatchFinderOptions">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 123,
     FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions::MatchFinderOptions", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsC1EOS2_")
    //</editor-fold>
    public /*inline*/ MatchFinderOptions(JD$Move _dparam, final MatchFinderOptions /*&&*/$Prm0) {
      // : CheckProfiling(static_cast<MatchFinderOptions &&>().CheckProfiling) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions::~MatchFinderOptions">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 123,
     FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions::~MatchFinderOptions", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinderOptions::MatchFinderOptions">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 123,
     FQN="clang::ast_matchers::MatchFinder::MatchFinderOptions::MatchFinderOptions", NM="_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang12ast_matchers11MatchFinder18MatchFinderOptionsC1Ev")
    //</editor-fold>
    public /*inline*/ MatchFinderOptions() {
      // : CheckProfiling() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "CheckProfiling=" + CheckProfiling; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchFinder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 896,
   FQN="clang::ast_matchers::MatchFinder::MatchFinder", NM="_ZN5clang12ast_matchers11MatchFinderC1ENS1_18MatchFinderOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinderC1ENS1_18MatchFinderOptionsE")
  //</editor-fold>
  public MatchFinder() {
    this(new MatchFinderOptions());
  }
  public MatchFinder(MatchFinderOptions Options/*= MatchFinderOptions()*/) {
    // : Matchers(), Options(std::move(Options)), ParsingDone(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::~MatchFinder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 899,
   FQN="clang::ast_matchers::MatchFinder::~MatchFinder", NM="_ZN5clang12ast_matchers11MatchFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinderD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Adds a matcher to execute when running over the AST.
  ///
  /// Calls 'Action' with the BoundNodes on every match.
  /// Adding more than one 'NodeMatch' allows finding different matches in a
  /// single pass over the AST.
  ///
  /// Does not take ownership of 'Action'.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 901,
   FQN="clang::ast_matchers::MatchFinder::addMatcher", NM="_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_4DeclEEEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_4DeclEEEPNS1_13MatchCallbackE")
  //</editor-fold>
  public void addMatcher_Matcher$Decl$C_MatchCallback$P(final /*const*/ Matcher<Decl> /*&*/ NodeMatch, 
                                           MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 907,
   FQN="clang::ast_matchers::MatchFinder::addMatcher", NM="_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_8QualTypeEEEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_8QualTypeEEEPNS1_13MatchCallbackE")
  //</editor-fold>
  public void addMatcher_Matcher$QualType$C_MatchCallback$P(final /*const*/ Matcher<QualType> /*&*/ NodeMatch, 
                                               MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 913,
   FQN="clang::ast_matchers::MatchFinder::addMatcher", NM="_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_4StmtEEEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_4StmtEEEPNS1_13MatchCallbackE")
  //</editor-fold>
  public void addMatcher_Matcher$Stmt$C_MatchCallback$P(final /*const*/ Matcher<Stmt> /*&*/ NodeMatch, 
                                           MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 919,
   FQN="clang::ast_matchers::MatchFinder::addMatcher", NM="_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEEPNS1_13MatchCallbackE")
  //</editor-fold>
  public void addMatcher_Matcher$NestedNameSpecifier$C_MatchCallback$P(final /*const*/ Matcher<NestedNameSpecifier> /*&*/ NodeMatch, 
                                                          MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 925,
   FQN="clang::ast_matchers::MatchFinder::addMatcher", NM="_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_22NestedNameSpecifierLocEEEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_22NestedNameSpecifierLocEEEPNS1_13MatchCallbackE")
  //</editor-fold>
  public void addMatcher_Matcher$NestedNameSpecifierLoc$C_MatchCallback$P(final /*const*/ Matcher<NestedNameSpecifierLoc> /*&*/ NodeMatch, 
                                                             MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 931,
   FQN="clang::ast_matchers::MatchFinder::addMatcher", NM="_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_7TypeLocEEEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder10addMatcherERKNS0_8internal7MatcherINS_7TypeLocEEEPNS1_13MatchCallbackE")
  //</editor-fold>
  public void addMatcher_Matcher$TypeLoc$C_MatchCallback$P(final /*const*/ Matcher<TypeLoc> /*&*/ NodeMatch, 
                                              MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @}
  
  /// \brief Adds a matcher to execute when running over the AST.
  ///
  /// This is similar to \c addMatcher(), but it uses the dynamic interface. It
  /// is more flexible, but the lost type information enables a caller to pass
  /// a matcher that cannot match anything.
  ///
  /// \returns \c true if the matcher is a valid top-level matcher, \c false
  ///   otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::addDynamicMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 937,
   FQN="clang::ast_matchers::MatchFinder::addDynamicMatcher", NM="_ZN5clang12ast_matchers11MatchFinder17addDynamicMatcherERKNS0_8internal15DynTypedMatcherEPNS1_13MatchCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder17addDynamicMatcherERKNS0_8internal15DynTypedMatcherEPNS1_13MatchCallbackE")
  //</editor-fold>
  public boolean addDynamicMatcher(final /*const*/ DynTypedMatcher /*&*/ NodeMatch, 
                   MatchCallback /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Creates a clang ASTConsumer that finds all matches.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::newASTConsumer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 961,
   FQN="clang::ast_matchers::MatchFinder::newASTConsumer", NM="_ZN5clang12ast_matchers11MatchFinder14newASTConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder14newASTConsumerEv")
  //</editor-fold>
  public std.unique_ptr<ASTConsumer> newASTConsumer() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Calls the registered callbacks on all matches on the given \p Node.
  ///
  /// Note that there can be multiple matches on a single node, for
  /// example when using decl(forEachDescendant(stmt())).
  ///
  /// @{
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::match">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 183,
   FQN="clang::ast_matchers::MatchFinder::match", NM="Tpl__ZN5clang12ast_matchers11MatchFinder5matchERKT_RNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers11MatchFinder5matchERKT_RNS_10ASTContextE")
  //</editor-fold>
  public </*typename*/ T> void match$T(final /*const*/ T /*&*/ Node, final ASTContext /*&*/ Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::match">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 965,
   FQN="clang::ast_matchers::MatchFinder::match", NM="_ZN5clang12ast_matchers11MatchFinder5matchERKNS_15ast_type_traits12DynTypedNodeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder5matchERKNS_15ast_type_traits12DynTypedNodeERNS_10ASTContextE")
  //</editor-fold>
  public void match(final /*const*/ DynTypedNode /*&*/ Node, 
       final ASTContext /*&*/ Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @}
  
  /// \brief Finds all matches in the given AST.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::matchAST">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 972,
   FQN="clang::ast_matchers::MatchFinder::matchAST", NM="_ZN5clang12ast_matchers11MatchFinder8matchASTERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder8matchASTERNS_10ASTContextE")
  //</editor-fold>
  public void matchAST(final ASTContext /*&*/ Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Registers a callback to notify the end of parsing.
  ///
  /// The provided closure is called after parsing is done, before the AST is
  /// traversed. Useful for benchmarking.
  /// Each call to FindAll(...) will call the closure once.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::registerTestCallbackAfterParsing">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 980,
   FQN="clang::ast_matchers::MatchFinder::registerTestCallbackAfterParsing", NM="_ZN5clang12ast_matchers11MatchFinder32registerTestCallbackAfterParsingEPNS1_23ParsingDoneTestCallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder32registerTestCallbackAfterParsingEPNS1_23ParsingDoneTestCallbackE")
  //</editor-fold>
  public void registerTestCallbackAfterParsing(MatchFinder.ParsingDoneTestCallback /*P*/ NewParsingDone) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief For each \c Matcher<> a \c MatchCallback that will be called
  /// when it matches.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchersByType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 202,
   FQN="clang::ast_matchers::MatchFinder::MatchersByType", NM="_ZN5clang12ast_matchers11MatchFinder14MatchersByTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder14MatchersByTypeE")
  //</editor-fold>
  public static class/*struct*/ MatchersByType implements Destructors.ClassWithDestructor {
    public std.vector<std.pair<DynTypedMatcher, MatchCallback /*P*/ >> DeclOrStmt;
    public std.vector<std.pair<Matcher<QualType>, MatchCallback /*P*/ >> Type;
    public std.vector<std.pair<Matcher<NestedNameSpecifier>, MatchCallback /*P*/ >> NestedNameSpecifier;
    public std.vector<std.pair<Matcher<NestedNameSpecifierLoc>, MatchCallback /*P*/ >> NestedNameSpecifierLoc;
    public std.vector<std.pair<Matcher<TypeLoc>, MatchCallback /*P*/ >> TypeLoc;
    /// \brief All the callbacks in one container to simplify iteration.
    public SmallPtrSet<MatchCallback /*P*/ > AllCallbacks;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchersByType::~MatchersByType">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 202,
     FQN="clang::ast_matchers::MatchFinder::MatchersByType::~MatchersByType", NM="_ZN5clang12ast_matchers11MatchFinder14MatchersByTypeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder14MatchersByTypeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::MatchFinder::MatchersByType::MatchersByType">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 202,
     FQN="clang::ast_matchers::MatchFinder::MatchersByType::MatchersByType", NM="_ZN5clang12ast_matchers11MatchFinder14MatchersByTypeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11MatchFinder14MatchersByTypeC1Ev")
    //</editor-fold>
    public /*inline*/ MatchersByType() {
      // : DeclOrStmt(), Type(), NestedNameSpecifier(), NestedNameSpecifierLoc(), TypeLoc(), AllCallbacks() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "DeclOrStmt=" + DeclOrStmt // NOI18N
                + ", Type=" + Type // NOI18N
                + ", NestedNameSpecifier=" + NestedNameSpecifier // NOI18N
                + ", NestedNameSpecifierLoc=" + NestedNameSpecifierLoc // NOI18N
                + ", TypeLoc=" + TypeLoc // NOI18N
                + ", AllCallbacks=" + AllCallbacks; // NOI18N
    }
  };
/*private:*/
  private MatchersByType Matchers;
  
  private MatchFinderOptions Options;
  
  /// \brief Called when parsing is done.
  private ParsingDoneTestCallback /*P*/ ParsingDone;
  
  @Override public String toString() {
    return "" + "Matchers=" + Matchers // NOI18N
              + ", Options=" + Options // NOI18N
              + ", ParsingDone=" + ParsingDone; // NOI18N
  }
}
