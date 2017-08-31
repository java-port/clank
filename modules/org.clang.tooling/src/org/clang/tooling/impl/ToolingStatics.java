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
package org.clang.tooling.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.basic.vfs.*;
import org.clang.tooling.impl.*;
import org.clang.tooling.core.*;
import org.llvm.support.yaml.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.driver.*;
import org.llvm.option.*;
import org.clang.lex.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type ToolingStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN5clang7tooling27shiftedCodePositionInternalERKT_j;_ZN5clang7tooling12_GLOBAL__N_119unescapeCommandLineEN4llvm9StringRefE;_ZN5clang7tooling16JSONAnchorSourceE;_ZN5clang7toolingL12getRangeSizeERKNS_13SourceManagerERKNS_15CharSourceRangeERKNS_11LangOptionsE;_ZN5clang7toolingL14JSONAnchorDestE;_ZN5clang7toolingL15InvalidLocationE;_ZN5clang7toolingL15getCC1ArgumentsEPNS_17DiagnosticsEngineEPNS_6driver11CompilationE;_ZN5clang7toolingL17injectResourceDirERSt6vectorISsSaISsEEPKcPv;_ZN5clang7toolingL17nodeToCommandLineERKSt6vectorIPN4llvm4yaml10ScalarNodeESaIS5_EE;_ZN5clang7toolingL18mergeAndSortRangesESt6vectorINS0_5RangeESaIS2_EE;_ZN5clang7toolingL19replaceStmtWithStmtERNS_13SourceManagerERKNS_4StmtES5_;_ZN5clang7toolingL19replaceStmtWithTextERNS_13SourceManagerERKNS_4StmtEN4llvm9StringRefE;_ZN5clang7toolingL1XE;_ZN5clang7toolingL21getSyntaxOnlyToolArgsERKN4llvm5TwineERKSt6vectorISsSaISsEENS1_9StringRefE;_ZN5clang7toolingL9newDriverEPNS_17DiagnosticsEngineEPKcN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE; -static-type=ToolingStatics -package=org.clang.tooling.impl")
//</editor-fold>
public final class ToolingStatics {

// This anchor is used to force the linker to link in the generated object file
// and thus register the JSONCompilationDatabasePlugin.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONAnchorSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 142,
 FQN="clang::tooling::JSONAnchorSource", NM="_ZN5clang7tooling16JSONAnchorSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling16JSONAnchorSourceE")
//</editor-fold>
public static /*volatile*/int JSONAnchorSource = 0;

//<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONAnchorDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 329,
 FQN="clang::tooling::JSONAnchorDest", NM="_ZN5clang7toolingL14JSONAnchorDestE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7toolingL14JSONAnchorDestE")
//</editor-fold>
public static int JSONAnchorDest = JSONAnchorSource/* __attribute__((unused))*/;
//<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::unescapeCommandLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 114,
 FQN="clang::tooling::(anonymous namespace)::unescapeCommandLine", NM="_ZN5clang7tooling12_GLOBAL__N_119unescapeCommandLineEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_119unescapeCommandLineEN4llvm9StringRefE")
//</editor-fold>
public static std.vectorString unescapeCommandLine(StringRef EscapedCommandLine) {
  CommandLineArgumentParser parser = null;
  try {
    parser/*J*/= new CommandLineArgumentParser(new StringRef(EscapedCommandLine));
    return parser.parse();
  } finally {
    if (parser != null) { parser.$destroy(); }
  }
}

// end namespace

// Register the JSONCompilationDatabasePlugin with the
// CompilationDatabasePluginRegistry using this statically initialized variable.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::X">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 137,
 FQN="clang::tooling::X", NM="_ZN5clang7toolingL1XE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7toolingL1XE")
//</editor-fold>
static Object X = ToolingRegistry.Add($("json-compilation-database"), $("Reads JSON formatted compilation databases"));

//<editor-fold defaultstate="collapsed" desc="clang::tooling::nodeToCommandLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 213,
 FQN="clang::tooling::nodeToCommandLine", NM="_ZN5clang7toolingL17nodeToCommandLineERKSt6vectorIPN4llvm4yaml10ScalarNodeESaIS5_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7toolingL17nodeToCommandLineERKSt6vectorIPN4llvm4yaml10ScalarNodeESaIS5_EE")
//</editor-fold>
public static std.vectorString nodeToCommandLine(final /*const*/std.vector<ScalarNode /*P*/ > /*&*/ Nodes) {
  std.vectorString Arguments = null;
  try {
    SmallString/*1024*/ Storage/*J*/= new SmallString/*1024*/(1024);
    if (Nodes.size() == 1) {
      return unescapeCommandLine(Nodes.$at$Const(0).getValue(Storage));
    }
    Arguments/*J*/= new std.vectorString(std.string.EMPTY);
    for (ScalarNode /*P*/ Node : Nodes) {
      Arguments.push_back_T$RR(Node.getValue(Storage).$string());
    }
    return new std.vectorString(JD$Move.INSTANCE, Arguments);
  } finally {
    if (Arguments != null) { Arguments.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::replaceStmtWithText">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp", line = 23,
 FQN="clang::tooling::replaceStmtWithText", NM="_ZN5clang7toolingL19replaceStmtWithTextERNS_13SourceManagerERKNS_4StmtEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp -nm=_ZN5clang7toolingL19replaceStmtWithTextERNS_13SourceManagerERKNS_4StmtEN4llvm9StringRefE")
//</editor-fold>
public static Replacement replaceStmtWithText(final SourceManager /*&*/ Sources, 
                   final /*const*/ Stmt /*&*/ From, 
                   StringRef Text) {
  return new Replacement(Sources, CharSourceRange.getTokenRange(From.getSourceRange()), new StringRef(Text));
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::replaceStmtWithStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp", line = 29,
 FQN="clang::tooling::replaceStmtWithStmt", NM="_ZN5clang7toolingL19replaceStmtWithStmtERNS_13SourceManagerERKNS_4StmtES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp -nm=_ZN5clang7toolingL19replaceStmtWithStmtERNS_13SourceManagerERKNS_4StmtES5_")
//</editor-fold>
public static Replacement replaceStmtWithStmt(final SourceManager /*&*/ Sources, 
                   final /*const*/ Stmt /*&*/ From, 
                   final /*const*/ Stmt /*&*/ To) {
  return replaceStmtWithText(Sources, From, Lexer.getSourceText(CharSourceRange.getTokenRange(To.getSourceRange()), 
          Sources, new LangOptions()));
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::InvalidLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 30,
 FQN="clang::tooling::InvalidLocation", NM="_ZN5clang7toolingL15InvalidLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingL15InvalidLocationE")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ InvalidLocation = $EMPTY;

// FIXME: This should go into the Lexer, but we need to figure out how
// to handle ranges for refactoring in general first - there is no obvious
// good way how to integrate this into the Lexer yet.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getRangeSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 119,
 FQN="clang::tooling::getRangeSize", NM="_ZN5clang7toolingL12getRangeSizeERKNS_13SourceManagerERKNS_15CharSourceRangeERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingL12getRangeSizeERKNS_13SourceManagerERKNS_15CharSourceRangeERKNS_11LangOptionsE")
//</editor-fold>
public static int getRangeSize(final /*const*/ SourceManager /*&*/ Sources, 
            final /*const*/ CharSourceRange /*&*/ Range, 
            final /*const*/ LangOptions /*&*/ LangOpts) {
  SourceLocation SpellingBegin = Sources.getSpellingLoc(Range.getBegin());
  SourceLocation SpellingEnd = Sources.getSpellingLoc(Range.getEnd());
  std.pairTypeUInt<FileID> Start = Sources.getDecomposedLoc(/*NO_COPY*/SpellingBegin);
  std.pairTypeUInt<FileID> End = Sources.getDecomposedLoc(/*NO_COPY*/SpellingEnd);
  if (Start.first.$noteq(End.first)) {
    return -1;
  }
  if (Range.isTokenRange()) {
    End.second += Lexer.MeasureTokenLength(/*NO_COPY*/SpellingEnd, Sources, LangOpts);
  }
  return End.second - Start.second;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::shiftedCodePositionInternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 142,
 FQN="clang::tooling::shiftedCodePositionInternal", NM="Tpl__ZN5clang7tooling27shiftedCodePositionInternalERKT_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=Tpl__ZN5clang7tooling27shiftedCodePositionInternalERKT_j")
//</editor-fold>
public static </*typename*/ T extends Iterable<Replacement>> /*uint*/int shiftedCodePositionInternal(final /*const*/ T /*&*/ Replaces, /*uint*/int Position) {
  /*uint*/int Offset = 0;
  for (final Replacement /*const*/ /*&*/ R : Replaces) {
    if ($lesseq_uint(R.getOffset() + R.getLength(), Position)) {
      Offset += R.getReplacementText().size() - R.getLength();
      continue;
    }
    if (Native.$less(R.getOffset(), Position)
       && $lesseq_uint(R.getOffset() + R.getReplacementText().size(), Position)) {
      Position = R.getOffset() + R.getReplacementText().size() - 1;
    }
    break;
  }
  return Position + Offset;
}


// Merge and sort overlapping ranges in \p Ranges.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::mergeAndSortRanges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 286,
 FQN="clang::tooling::mergeAndSortRanges", NM="_ZN5clang7toolingL18mergeAndSortRangesESt6vectorINS0_5RangeESaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingL18mergeAndSortRangesESt6vectorINS0_5RangeESaIS2_EE")
//</editor-fold>
public static std.vector<Range> mergeAndSortRanges(std.vector<Range> Ranges) {
  std.vector<Range> Result = null;
  try {
    std.sort(Ranges.begin(), Ranges.end(), new Compare<Range>() {
        @Override
        public boolean compare(Range LHS, Range RHS) {
            if (LHS.getOffset() != RHS.getOffset()) {
              return $less_uint(LHS.getOffset(), RHS.getOffset());
            }
            return $less_uint(LHS.getLength(), RHS.getLength());
        }
        @Override
        public boolean $less(Range first, Range second) {
            return $less(first, second); 
        }
        
    });
    Result/*J*/= new std.vector<Range>(new Range());
    for (final /*const*/ Range /*&*/ R : Ranges) {
      if (Result.empty()
         || $less_uint(Result.back().getOffset() + Result.back().getLength(), R.getOffset())) {
        Result.push_back_T$C$R(R);
      } else {
        /*uint*/int NewEnd = std.max(Result.back().getOffset() + Result.back().getLength(), 
            R.getOffset() + R.getLength());
        Result.$at(Result.size() - 1).$assignMove(
            new Range(Result.back().getOffset(), NewEnd - Result.back().getOffset())
        );
      }
    }
    return new std.vector<Range>(JD$Move.INSTANCE, Result);
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


// FIXME: This file contains structural duplication with other parts of the
// code that sets up a compiler to run tools on it, and we should refactor
// it to be based on the same framework.

/// \brief Builds a clang driver initialized for running clang tools.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newDriver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 50,
 FQN="clang::tooling::newDriver", NM="_ZN5clang7toolingL9newDriverEPNS_17DiagnosticsEngineEPKcN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL9newDriverEPNS_17DiagnosticsEngineEPKcN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE")
//</editor-fold>
public static Driver /*P*/ newDriver(DiagnosticsEngine /*P*/ Diagnostics, /*const*/char$ptr/*char P*/ BinaryName, 
         IntrusiveRefCntPtr<FileSystem> VFS) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Driver /*P*/ CompilerDriver = $c$.clean(new Driver(new StringRef(BinaryName), new StringRef(sys.getDefaultTargetTriple()), 
        /*Deref*/Diagnostics, $c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$Move.INSTANCE, std.move(VFS)))));
    CompilerDriver.setTitle(new std.string(/*KEEP_STR*/"clang_based_tool"));
    return CompilerDriver;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Retrieves the clang CC1 specific flags out of the compilation's jobs.
///
/// Returns NULL on error.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getCC1Arguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 63,
 FQN="clang::tooling::getCC1Arguments", NM="_ZN5clang7toolingL15getCC1ArgumentsEPNS_17DiagnosticsEngineEPNS_6driver11CompilationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL15getCC1ArgumentsEPNS_17DiagnosticsEngineEPNS_6driver11CompilationE")
//</editor-fold>
public static /*const*/ArgStringList/*P*/ getCC1Arguments(DiagnosticsEngine /*P*/ Diagnostics, 
               Compilation /*P*/ Compilation) {
  // We expect to get back exactly one Command job, if we didn't something
  // failed. Extract that job from the Compilation.
  final /*const*/ JobList /*&*/ Jobs = Compilation.getJobs();
  if (Jobs.size() != 1 || !isa(Command.class, Jobs.begin$Const().$star())) {
    raw_svector_ostream error_stream = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallString/*256*/ error_msg/*J*/= new SmallString/*256*/(256);
      error_stream/*J*/= new raw_svector_ostream(error_msg);
      Jobs.Print(error_stream, $("; "), true);
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diagnostics.Report(diag.err_fe_expected_compiler_job)), 
          error_stream.str()));
      return null;
    } finally {
      if (error_stream != null) { error_stream.$destroy(); }
      $c$.$destroy();
    }
  }
  
  // The one job we find should be to invoke clang again.
  final /*const*/ Command /*&*/ Cmd = cast(Command.class, Jobs.begin$Const().$star());
  if ($noteq_StringRef(/*STRINGREF_STR*/Cmd.getCreator().getName(), /*STRINGREF_STR*/"clang")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(Diagnostics.Report(diag.err_fe_expected_clang_command)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  return /*AddrOf*/Cmd.getArguments();
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::getSyntaxOnlyToolArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 112,
 FQN="clang::tooling::getSyntaxOnlyToolArgs", NM="_ZN5clang7toolingL21getSyntaxOnlyToolArgsERKN4llvm5TwineERKSt6vectorISsSaISsEENS1_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL21getSyntaxOnlyToolArgsERKN4llvm5TwineERKSt6vectorISsSaISsEENS1_9StringRefE")
//</editor-fold>
public static std.vectorString getSyntaxOnlyToolArgs(final /*const*/ Twine /*&*/ ToolName, 
                     final /*const*/std.vectorString/*&*/ ExtraArgs, 
                     StringRef FileName) {
  std.vectorString Args = null;
  try {
    Args/*J*/= new std.vectorString(std.string.EMPTY);
    Args.push_back_T$RR(ToolName.str());
    Args.push_back_T$RR(new std.string(/*KEEP_STR*/"-fsyntax-only"));
    Args.insert$T(new std.vectorString.iterator(Args.end()), ExtraArgs.begin$Const(), ExtraArgs.end$Const());
    Args.push_back_T$RR(FileName.str());
    return new std.vectorString(JD$Move.INSTANCE, Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::injectResourceDir">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 348,
 FQN="clang::tooling::injectResourceDir", NM="_ZN5clang7toolingL17injectResourceDirERSt6vectorISsSaISsEEPKcPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL17injectResourceDirERSt6vectorISsSaISsEEPKcPv")
//</editor-fold>
public static void injectResourceDir(final std.vectorString/*&*/ Args, /*const*/char$ptr/*char P*/ Argv0, 
                 Object/*void P*/ MainAddr) {
  // Allow users to override the resource dir.
  for (string s : Args)  {
    StringRef Arg = new StringRef(s);
    if (Arg.startswith(/*STRINGREF_STR*/"-resource-dir")) {
      return;
    }
  }
  
  // If there's no override in place add our resource dir.
  Args.push_back_T$RR($add_T$C$P_string(/*KEEP_STR*/"-resource-dir=", 
          CompilerInvocation.GetResourcesPath(Argv0, MainAddr)));
}

} // END OF class ToolingStatics
