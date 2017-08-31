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
package org.clang.staticanalyzer.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.frontend.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.llvm.support.sys.fs;


//<editor-fold defaultstate="collapsed" desc="static type AnalysisConsumerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL10MaxCFGSize;_ZL12CreateUbiVizv;_ZL15getFunctionNamePKN5clang4DeclE;_ZL18shouldSkipFunctionPKN5clang4DeclERKN4llvm8DenseSetIS2_NS3_12DenseMapInfoIS2_EEEES9_;_ZL19NumFunctionTopLevel;_ZL20NumFunctionsAnalyzed;_ZL22PercentReachableBlocks;_ZL28NumBlocksInAnalyzedFunctions; -static-type=AnalysisConsumerStatics -package=org.clang.staticanalyzer.frontend.impl")
//</editor-fold>
public final class AnalysisConsumerStatics {

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="CreateUbiViz">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 740,
 FQN="CreateUbiViz", NM="_ZL12CreateUbiVizv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL12CreateUbiVizv")
//</editor-fold>
public static std.unique_ptr<ExplodedNode.Auditor> CreateUbiViz() {
  unique_ptr<raw_fd_ostream> Stream = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SmallString/*128*/ P/*J*/= new SmallString/*128*/(128);
    int$ref FD = create_int$ref();
    fs.createTemporaryFile(new Twine(/*KEEP_STR*/"llvm_ubi"), new StringRef(/*KEEP_STR*/$EMPTY), FD, P);
    llvm.errs().$out(/*KEEP_STR*/"Writing '").$out(P).$out(/*KEEP_STR*/"'.\n");
    
    Stream = llvm.make_unique(new raw_fd_ostream(FD, true));
    return $c$.clean(new std.unique_ptr<ExplodedNode.Auditor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new UbigraphViz(std.move(Stream), P.$StringRef())))));
  } finally {
    if (Stream != null) { Stream.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="NumFunctionTopLevel">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 59,
 FQN="NumFunctionTopLevel", NM="_ZL19NumFunctionTopLevel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL19NumFunctionTopLevel")
//</editor-fold>
public static Statistic NumFunctionTopLevel = new Statistic($("AnalysisConsumer"), $("NumFunctionTopLevel"), $("The # of functions at top level."), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumFunctionsAnalyzed">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 60,
 FQN="NumFunctionsAnalyzed", NM="_ZL20NumFunctionsAnalyzed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL20NumFunctionsAnalyzed")
//</editor-fold>
public static Statistic NumFunctionsAnalyzed = new Statistic($("AnalysisConsumer"), $("NumFunctionsAnalyzed"), $("The # of functions and blocks analyzed (as top level with inlining turned on)."), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumBlocksInAnalyzedFunctions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 63,
 FQN="NumBlocksInAnalyzedFunctions", NM="_ZL28NumBlocksInAnalyzedFunctions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL28NumBlocksInAnalyzedFunctions")
//</editor-fold>
public static Statistic NumBlocksInAnalyzedFunctions = new Statistic($("AnalysisConsumer"), $("NumBlocksInAnalyzedFunctions"), $("The # of basic blocks in the analyzed functions."), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="PercentReachableBlocks">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 65,
 FQN="PercentReachableBlocks", NM="_ZL22PercentReachableBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL22PercentReachableBlocks")
//</editor-fold>
public static Statistic PercentReachableBlocks = new Statistic($("AnalysisConsumer"), $("PercentReachableBlocks"), $("The % of reachable basic blocks."), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="MaxCFGSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 66,
 FQN="MaxCFGSize", NM="_ZL10MaxCFGSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL10MaxCFGSize")
//</editor-fold>
public static Statistic MaxCFGSize = new Statistic($("AnalysisConsumer"), $("MaxCFGSize"), $("The maximum number of basic blocks in a function."), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="shouldSkipFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 419,
 FQN="shouldSkipFunction", NM="_ZL18shouldSkipFunctionPKN5clang4DeclERKN4llvm8DenseSetIS2_NS3_12DenseMapInfoIS2_EEEES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL18shouldSkipFunctionPKN5clang4DeclERKN4llvm8DenseSetIS2_NS3_12DenseMapInfoIS2_EEEES9_")
//</editor-fold>
public static boolean shouldSkipFunction(/*const*/ Decl /*P*/ D, 
                  final /*const*/DenseSet</*const*/ Decl /*P*/ > /*&*/ Visited, 
                  final /*const*/DenseSet</*const*/ Decl /*P*/ > /*&*/ VisitedAsTopLevel) {
  if ((VisitedAsTopLevel.count(D) != 0)) {
    return true;
  }
  
  // We want to re-analyse the functions as top level in the following cases:
  // - The 'init' methods should be reanalyzed because
  //   ObjCNonNilReturnValueChecker assumes that '[super init]' never returns
  //   'nil' and unless we analyze the 'init' functions as top level, we will
  //   not catch errors within defensive code.
  // - We want to reanalyze all ObjC methods as top level to report Retain
  //   Count naming convention errors more aggressively.
  if (isa_ObjCMethodDecl(D)) {
    return false;
  }
  
  // Otherwise, if we visited the function before, do not reanalyze it.
  return (Visited.count(D) != 0);
}

//<editor-fold defaultstate="collapsed" desc="getFunctionName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 571,
 FQN="getFunctionName", NM="_ZL15getFunctionNamePKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZL15getFunctionNamePKN5clang4DeclE")
//</editor-fold>
public static std.string getFunctionName(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ ObjCMethodDecl /*P*/ ID = dyn_cast_ObjCMethodDecl(D);
    if ((ID != null)) {
      return ID.getSelector().getAsString();
    }
  }
  {
    /*const*/ FunctionDecl /*P*/ ND = dyn_cast_FunctionDecl(D);
    if ((ND != null)) {
      IdentifierInfo /*P*/ II = ND.getIdentifier();
      if ((II != null)) {
        return II.getName().$string();
      }
    }
  }
  return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
}

} // END OF class AnalysisConsumerStatics
