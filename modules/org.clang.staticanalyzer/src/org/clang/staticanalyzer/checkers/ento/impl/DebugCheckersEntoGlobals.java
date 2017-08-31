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
package org.clang.staticanalyzer.checkers.ento.impl;

import org.clank.support.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type DebugCheckersEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento17registerCFGDumperERNS0_14CheckerManagerE;_ZN5clang4ento17registerCFGViewerERNS0_14CheckerManagerE;_ZN5clang4ento20registerConfigDumperERNS0_14CheckerManagerE;_ZN5clang4ento21registerBugHashDumperERNS0_14CheckerManagerE;_ZN5clang4ento23registerCallGraphDumperERNS0_14CheckerManagerE;_ZN5clang4ento23registerCallGraphViewerERNS0_14CheckerManagerE;_ZN5clang4ento27registerExplodedGraphViewerERNS0_14CheckerManagerE;_ZN5clang4ento27registerLiveVariablesDumperERNS0_14CheckerManagerE;_ZN5clang4ento28registerDominatorsTreeDumperERNS0_14CheckerManagerE; -static-type=DebugCheckersEntoGlobals -package=org.clang.staticanalyzer.checkers.ento.impl")
//</editor-fold>
public final class DebugCheckersEntoGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerBugHashDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 245,
 FQN="clang::ento::registerBugHashDumper", NM="_ZN5clang4ento21registerBugHashDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento21registerBugHashDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerBugHashDumper(final CheckerManager /*&*/ mgr) {
  mgr.<BugHashDumper>registerChecker(BugHashDumper.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFGDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 114,
 FQN="clang::ento::registerCFGDumper", NM="_ZN5clang4ento17registerCFGDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento17registerCFGDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFGDumper(final CheckerManager /*&*/ mgr) {
  mgr.<CFGDumper>registerChecker(CFGDumper.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFGViewer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 88,
 FQN="clang::ento::registerCFGViewer", NM="_ZN5clang4ento17registerCFGViewerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento17registerCFGViewerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFGViewer(final CheckerManager /*&*/ mgr) {
  mgr.<CFGViewer>registerChecker(CFGViewer.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallGraphDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 154,
 FQN="clang::ento::registerCallGraphDumper", NM="_ZN5clang4ento23registerCallGraphDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento23registerCallGraphDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallGraphDumper(final CheckerManager /*&*/ mgr) {
  mgr.<CallGraphDumper>registerChecker(CallGraphDumper.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallGraphViewer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 134,
 FQN="clang::ento::registerCallGraphViewer", NM="_ZN5clang4ento23registerCallGraphViewerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento23registerCallGraphViewerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallGraphViewer(final CheckerManager /*&*/ mgr) {
  mgr.<CallGraphViewer>registerChecker(CallGraphViewer.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerConfigDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 193,
 FQN="clang::ento::registerConfigDumper", NM="_ZN5clang4ento20registerConfigDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento20registerConfigDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerConfigDumper(final CheckerManager /*&*/ mgr) {
  mgr.<ConfigDumper>registerChecker(ConfigDumper.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDominatorsTreeDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 48,
 FQN="clang::ento::registerDominatorsTreeDumper", NM="_ZN5clang4ento28registerDominatorsTreeDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento28registerDominatorsTreeDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDominatorsTreeDumper(final CheckerManager /*&*/ mgr) {
  mgr.<DominatorsTreeDumper>registerChecker(DominatorsTreeDumper.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerExplodedGraphViewer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 212,
 FQN="clang::ento::registerExplodedGraphViewer", NM="_ZN5clang4ento27registerExplodedGraphViewerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento27registerExplodedGraphViewerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerExplodedGraphViewer(final CheckerManager /*&*/ mgr) {
  mgr.<ExplodedGraphViewer>registerChecker(ExplodedGraphViewer.class);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerLiveVariablesDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 68,
 FQN="clang::ento::registerLiveVariablesDumper", NM="_ZN5clang4ento27registerLiveVariablesDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento27registerLiveVariablesDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerLiveVariablesDumper(final CheckerManager /*&*/ mgr) {
  mgr.<LiveVariablesDumper>registerChecker(LiveVariablesDumper.class);
}

} // END OF class DebugCheckersEntoGlobals
