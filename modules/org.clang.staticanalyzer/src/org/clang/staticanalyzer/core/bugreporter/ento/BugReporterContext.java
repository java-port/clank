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

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 526,
 FQN="clang::ento::BugReporterContext", NM="_ZN5clang4ento18BugReporterContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContextE")
//</editor-fold>
public abstract class BugReporterContext implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 51,
   FQN="clang::ento::BugReporterContext::anchor", NM="_ZN5clang4ento18BugReporterContext6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private final GRBugReporter /*&*/ BR;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::BugReporterContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 530,
   FQN="clang::ento::BugReporterContext::BugReporterContext", NM="_ZN5clang4ento18BugReporterContextC1ERNS0_13GRBugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContextC1ERNS0_13GRBugReporterE")
  //</editor-fold>
  public BugReporterContext(final GRBugReporter /*&*/ br) {
    // : BR(br) 
    //START JInit
    this./*&*/BR=/*&*/br;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::~BugReporterContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 532,
   FQN="clang::ento::BugReporterContext::~BugReporterContext", NM="_ZN5clang4ento18BugReporterContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContextD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 534,
   FQN="clang::ento::BugReporterContext::getBugReporter", NM="_ZN5clang4ento18BugReporterContext14getBugReporterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext14getBugReporterEv")
  //</editor-fold>
  public GRBugReporter /*&*/ getBugReporter() {
    return BR;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 536,
   FQN="clang::ento::BugReporterContext::getGraph", NM="_ZN5clang4ento18BugReporterContext8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext8getGraphEv")
  //</editor-fold>
  public ExplodedGraph /*&*/ getGraph() {
    return BR.getGraph();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 538,
   FQN="clang::ento::BugReporterContext::getStateManager", NM="_ZN5clang4ento18BugReporterContext15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext15getStateManagerEv")
  //</editor-fold>
  public ProgramStateManager /*&*/ getStateManager() {
    return BR.getStateManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getSValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 542,
   FQN="clang::ento::BugReporterContext::getSValBuilder", NM="_ZN5clang4ento18BugReporterContext14getSValBuilderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext14getSValBuilderEv")
  //</editor-fold>
  public SValBuilder /*&*/ getSValBuilder() {
    return getStateManager().getSValBuilder();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 546,
   FQN="clang::ento::BugReporterContext::getASTContext", NM="_ZN5clang4ento18BugReporterContext13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() {
    return BR.getContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 550,
   FQN="clang::ento::BugReporterContext::getSourceManager", NM="_ZN5clang4ento18BugReporterContext16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() {
    return BR.getSourceManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterContext::getNodeResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 554,
   FQN="clang::ento::BugReporterContext::getNodeResolver", NM="_ZN5clang4ento18BugReporterContext15getNodeResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterContext15getNodeResolverEv")
  //</editor-fold>
  public abstract /*virtual*/ BugReport.NodeResolver /*&*/ getNodeResolver()/* = 0*/;

  
  @Override public String toString() {
    return "" + "BR=" + BR; // NOI18N
  }
}
