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
package org.clang.tools.clang_format;

import org.llvm.cl.aliases.optString;
import org.llvm.cl.aliases.optBool;
import org.llvm.cl.aliases.optUInt;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.format.FormatGlobals;
import org.llvm.cl.*;
import org.llvm.support.sys.sys;


//<editor-fold defaultstate="collapsed" desc="static type ClangFormatGlobals">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.tools.clang_format.ClangFormatGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_Z4main;_ZL10DumpConfig;_ZL10LineRangesB5cxx11;_ZL12PrintVersionv;_ZL12SortIncludes;_ZL13FallbackStyleB5cxx11;_ZL14AssumeFileNameB5cxx11;_ZL19ClangFormatCategory;_ZL4Help;_ZL5StyleB5cxx11;_ZL6Cursor;_ZL7Inplace;_ZL7Lengths;_ZL7Offsets;_ZL9FileNamesB5cxx11;_ZL9OutputXML; -static-type=ClangFormatGlobals -package=org.clang.tools.clang_format")
//</editor-fold>
public final class ClangFormatGlobals {

//<editor-fold defaultstate="collapsed" desc="Help">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 32,
 FQN="Help", NM="_ZL4Help",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL4Help")
//</editor-fold>
public static optBool Help/*J*/= new optBool($h, new desc($("Alias for -help")), OptionHidden.Hidden);

// Mark all our options with this category, everything else (except for -version
// and -help) will be hidden.
//<editor-fold defaultstate="collapsed" desc="ClangFormatCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 36,
 FQN="ClangFormatCategory", NM="_ZL19ClangFormatCategory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL19ClangFormatCategory")
//</editor-fold>
public static OptionCategory ClangFormatCategory/*J*/= new OptionCategory($("Clang-format options"));
//<editor-fold defaultstate="collapsed" desc="Offsets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 38,
 FQN="Offsets", NM="_ZL7Offsets",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL7Offsets")
//</editor-fold>
public static listUIntBool Offsets/*J*/= new listUIntBool($("offset"), 
    new desc($("Format a range starting at this byte offset.\nMultiple ranges can be formatted by specifying\nseveral -offset and -length pairs.\nCan only be used with one input file.")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="Lengths">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 45,
 FQN="Lengths", NM="_ZL7Lengths",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL7Lengths")
//</editor-fold>
public static listUIntBool Lengths/*J*/= new listUIntBool($("length"), 
    new desc($("Format a range of this length (in bytes).\nMultiple ranges can be formatted by specifying\nseveral -offset and -length pairs.\nWhen only a single -offset is specified without\n-length, clang-format will format up to the end\nof the file.\nCan only be used with one input file.")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="LineRanges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 55,
 FQN="LineRanges", NM="_ZL10LineRanges",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL10LineRanges")
//</editor-fold>
public static listStringBool LineRanges/*J*/= new listStringBool($("lines"), new desc($("<start line>:<end line> - format a range of\nlines (both 1-based).\nMultiple ranges can be formatted by specifying\nseveral -lines arguments.\nCan't be used with -offset and -length.\nCan only be used with one input file.")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="Style">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 63,
 FQN="Style", NM="_ZL5Style",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL5Style")
//</editor-fold>
public static optString Style/*J*/= new optString($("style"), 
    new desc(FormatGlobals.StyleOptionHelpDescription), 
    ClGlobals.init($("file")), new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="FallbackStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 67,
 FQN="FallbackStyle", NM="_ZL13FallbackStyle",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL13FallbackStyle")
//</editor-fold>
public static optString FallbackStyle/*J*/= new optString($("fallback-style"), 
    new desc($("The name of the predefined style used as a\nfallback in case clang-format is invoked with\n-style=file, but can not find the .clang-format\nfile to use.\nUse -fallback-style=none to skip formatting.")), 
    ClGlobals.init($("LLVM")), new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="AssumeFileName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 76,
 FQN="AssumeFileName", NM="_ZL14AssumeFileName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL14AssumeFileName")
//</editor-fold>
public static optString AssumeFileName/*J*/= new optString($("assume-filename"), 
    new desc($("When reading from stdin, clang-format assumes this\nfilename to look for a style config file (with\n-style=file) and to determine the language.")), 
    ClGlobals.init($("<stdin>")), new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="Inplace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 83,
 FQN="Inplace", NM="_ZL7Inplace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL7Inplace")
//</editor-fold>
public static optBool Inplace/*J*/= new optBool($i, 
    new desc($("Inplace edit <file>s, if specified.")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="OutputXML">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 87,
 FQN="OutputXML", NM="_ZL9OutputXML",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL9OutputXML")
//</editor-fold>
public static optBool OutputXML/*J*/= new optBool($("output-replacements-xml"), 
    new desc($("Output replacements as XML.")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="DumpConfig">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 90,
 FQN="DumpConfig", NM="_ZL10DumpConfig",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL10DumpConfig")
//</editor-fold>
public static optBool DumpConfig/*J*/= new optBool($("dump-config"), 
    new desc($("Dump configuration options to stdout and exit.\nCan be used with -style option.")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="Cursor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 95,
 FQN="Cursor", NM="_ZL6Cursor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL6Cursor")
//</editor-fold>
public static optUInt Cursor/*J*/= new optUInt($("cursor"), 
    new desc($("The position of the cursor when invoking\nclang-format from an editor integration")), 
    ClGlobals.init(0), new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="SortIncludes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 101,
 FQN="SortIncludes", NM="_ZL12SortIncludes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL12SortIncludes")
//</editor-fold>
public static optBool SortIncludes/*J*/= new optBool($("sort-includes"), 
    new desc($("If set, overrides the include sorting behavior determined by the SortIncludes style flag")), 
    new cat(ClangFormatCategory));
//<editor-fold defaultstate="collapsed" desc="FileNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 107,
 FQN="FileNames", NM="_ZL9FileNames",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL9FileNames")
//</editor-fold>
public static listStringBool FileNames/*J*/= new listStringBool(org.llvm.cl.FormattingFlags.Positional, new desc($("[<file> ...]")), 
    new cat(ClangFormatCategory));
// namespace clang
//<editor-fold defaultstate="collapsed" desc="PrintVersion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 315,
 FQN="PrintVersion", NM="_ZL12PrintVersionv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZL12PrintVersionv")
//</editor-fold>
public static void PrintVersion() {
  final raw_ostream /*&*/ OS = outs();
  OS.$out(getClangToolFullVersion(new StringRef(/*KEEP_STR*/"clang-format"))).$out_char($$LF);
}

//<editor-fold defaultstate="collapsed" desc="main">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 320,
 FQN="main", NM="_Z4main",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_Z4main")
//</editor-fold>
public static int main(int argc, /*const*/type$ptr<char$ptr>/*char PP*/ argv) {
 try {
  sys.PrintStackTraceOnErrorSignal(new StringRef(argv.$at(0)));
  
  ClGlobals.HideUnrelatedOptions(ClangFormatCategory);
  
  ClGlobals.SetVersionPrinter(/*FuncRef*/ClangFormatGlobals::PrintVersion);
  ClGlobals.ParseCommandLineOptions(argc, argv, 
      $("A tool to format C/C++/Java/JavaScript/Objective-C/Protobuf code.\n\nIf no arguments are specified, it formats the code from standard input\nand writes the result to the standard output.\nIf <file>s are given, it reformats the files. If -i is specified\ntogether with <file>s, the files are edited in-place. Otherwise, the\nresult is written to the standard output.\n"));
  if (Help.$T()) {
    ClGlobals.PrintHelpMessage();
  }
  if (DumpConfig.$T()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Config = $c$.clean(FormatGlobals.configurationAsText($c$.track(FormatGlobals.getStyle(new StringRef(Style), new StringRef(FileNames.empty() ? AssumeFileName : FileNames.$at(0)), 
              new StringRef(FallbackStyle)))));
      outs().$out(Config).$out(/*KEEP_STR*/$LF);
      return 0;
    } finally {
      $c$.$destroy();
    }
  }
  
  boolean Error = false;
  switch (FileNames.size()) {
   case 0:
    Error = org.clang.tools.clang_format.format.FormatGlobals.format(new StringRef(/*KEEP_STR*/$MINUS));
    break;
   case 1:
    Error = org.clang.tools.clang_format.format.FormatGlobals.format(new StringRef(FileNames.$at(0)));
    break;
   default:
    if (!Offsets.empty() || !Lengths.empty() || !LineRanges.empty()) {
      errs().$out(/*KEEP_STR*/"error: -offset, -length and -lines can only be used for single file.\n");
      return 1;
    }
    for (/*uint*/int i = 0; $less_uint(i, FileNames.size()); ++i)  {
      Error |= org.clang.tools.clang_format.format.FormatGlobals.format(new StringRef(FileNames.$at(i)));
    }
    break;
  }
  return Error ? 1 : 0;
 } finally {
  ClangFormatGlobals.java$shutdown();
 }
}

private static void java$shutdown() {
  AssumeFileName.reset();
  assert AssumeFileName.std$string().$eq(new std.string("<stdin>")) : "generated with intial <stdin>: " + AssumeFileName.std$string();
  Cursor.reset();
  assert Cursor.$T() == 0 : "generated with initial 0: " + Cursor.$T();
  DumpConfig.reset();
  assert DumpConfig.$T() == false : "generated with initial false: " + DumpConfig.$T();
  FallbackStyle.reset();
  assert FallbackStyle.std$string().$eq(new std.string("LLVM")) : "generated with initial LLVM: " + FallbackStyle.std$string();
  FileNames.reset();
  assert FileNames.empty() : "generated with empty initial state: " + FileNames;
  Help.reset();
  assert Help.$T() == false : "generated with initial false: " + Help.$T();
  Inplace.reset();
  assert Inplace.$T() == false : "generated with initial false: " + Inplace.$T();
  Lengths.reset();
  assert Lengths.empty() : "generated with empty initial state: " + Lengths;
  LineRanges.reset();
  assert LineRanges.empty() : "generated with empty initial state: " + LineRanges;
  Offsets.reset();
  assert Offsets.empty() : "generated with empty initial state: " + Offsets;
  OutputXML.reset();
  assert OutputXML.$T() == false : "generated with initial false: " + OutputXML.$T();
  SortIncludes.reset();
  assert SortIncludes.$T() == false : "generated with initial false: " + SortIncludes.$T();
  Style.reset();
  assert Style.std$string().$eq(new std.string("file")) : "generated with initial 'file': " + Style.std$string();
}

} // END OF class ClangFormatGlobals
