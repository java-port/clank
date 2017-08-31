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
package org.clang.tools.clang_format.format;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.InMemoryFileSystem;
import static org.clang.format.FormatGlobals.reformat;
import org.clang.format.FormatStyle;
import org.clang.rewrite.core.Rewriter;
import org.clang.tooling.ToolingGlobals;
import org.clang.tooling.core.*;
import static org.clang.tools.clang_format.ClangFormatGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.tools.clang_format.format.FormatGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL10fillRangesEPN4llvm12MemoryBufferERSt6vectorINS_7tooling5RangeESaIS6_EE;_ZN5clang6formatL14parseLineRangeEN4llvm9StringRefERjS3_;_ZN5clang6formatL18createInMemoryFileEN4llvm9StringRefEPNS1_12MemoryBufferERNS_13SourceManagerERNS_11FileManagerEPNS_3vfs18InMemoryFileSystemE;_ZN5clang6formatL20outputReplacementXMLEN4llvm9StringRefE;_ZN5clang6formatL21outputReplacementsXMLERKSt3setINS_7tooling11ReplacementESt4lessIS3_ESaIS3_EE;_ZN5clang6formatL6formatEN4llvm9StringRefE; -static-type=FormatGlobals -package=org.clang.tools.clang_format.format")
//</editor-fold>
public final class FormatGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::format::createInMemoryFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 113,
 FQN="clang::format::createInMemoryFile", NM="_ZN5clang6formatL18createInMemoryFileEN4llvm9StringRefEPNS1_12MemoryBufferERNS_13SourceManagerERNS_11FileManagerEPNS_3vfs18InMemoryFileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL18createInMemoryFileEN4llvm9StringRefEPNS1_12MemoryBufferERNS_13SourceManagerERNS_11FileManagerEPNS_3vfs18InMemoryFileSystemE")
//</editor-fold>
public static FileID createInMemoryFile(StringRef FileName, MemoryBuffer /*P*/ Source, 
                  final SourceManager /*&*/ Sources, final FileManager /*&*/ Files, 
                  InMemoryFileSystem /*P*/ MemFS) {
  MemFS.addFileNoOwn(new Twine(FileName), 0, Source);
  return Sources.createFileID(Files.getFile(/*NO_COPY*/FileName), new SourceLocation(), 
      SrcMgr.CharacteristicKind.C_User);
}


// Parses <start line>:<end line> input to a pair of line numbers.
// Returns true on error.
//<editor-fold defaultstate="collapsed" desc="clang::format::parseLineRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 123,
 FQN="clang::format::parseLineRange", NM="_ZN5clang6formatL14parseLineRangeEN4llvm9StringRefERjS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL14parseLineRangeEN4llvm9StringRefERjS3_")
//</editor-fold>
public static boolean parseLineRange(StringRef Input, final uint$ref/*uint &*/ FromLine, 
              final uint$ref/*uint &*/ ToLine) {
  std.pair<StringRef, StringRef> LineRange = Input.split($$COLON);
  return LineRange.first.getAsInteger$NotSigned(0, FromLine)
     || LineRange.second.getAsInteger$NotSigned(0, ToLine);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::fillRanges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 130,
 FQN="clang::format::fillRanges", NM="_ZN5clang6formatL10fillRangesEPN4llvm12MemoryBufferERSt6vectorINS_7tooling5RangeESaIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL10fillRangesEPN4llvm12MemoryBufferERSt6vectorINS_7tooling5RangeESaIS6_EE")
//</editor-fold>
public static boolean fillRanges(MemoryBuffer /*P*/ Code, 
          final std.vector<Range> /*&*/ Ranges) {
  IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem = null;
  FileManager Files = null;
  DiagnosticsEngine Diagnostics = null;
  SourceManager Sources = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    InMemoryFileSystem/*J*/= new IntrusiveRefCntPtr<InMemoryFileSystem>(new InMemoryFileSystem());
    Files/*J*/= $c$.clean(new FileManager(new FileSystemOptions(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, InMemoryFileSystem))));
    Diagnostics/*J*/= $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
        new DiagnosticOptions()));
    Sources/*J*/= new SourceManager(Diagnostics, Files);
    FileID ID = createInMemoryFile(new StringRef(/*KEEP_STR*/"<irrelevant>"), Code, Sources, Files, 
        InMemoryFileSystem.get());
    if (!LineRanges.empty()) {
      if (!Offsets.empty() || !Lengths.empty()) {
        errs().$out(/*KEEP_STR*/"error: cannot use -lines with -offset/-length\n");
        return true;
      }
      
      for (/*uint*/int i = 0, e = LineRanges.size(); $less_uint(i, e); ++i) {
        uint$ref FromLine = create_uint$ref();
        uint$ref ToLine = create_uint$ref();
        if (parseLineRange(new StringRef(LineRanges.$at(i)), FromLine, ToLine)) {
          errs().$out(/*KEEP_STR*/"error: invalid <start line>:<end line> pair\n");
          return true;
        }
        if ($greater_uint(FromLine.$deref(), ToLine.$deref())) {
          errs().$out(/*KEEP_STR*/"error: start line should be less than end line\n");
          return true;
        }
        SourceLocation Start = Sources.translateLineCol(/*NO_COPY*/ID, FromLine.$deref(), 1);
        SourceLocation End = Sources.translateLineCol(/*NO_COPY*/ID, ToLine.$deref(), UINT_MAX);
        if (Start.isInvalid() || End.isInvalid()) {
          return true;
        }
        /*uint*/int Offset = Sources.getFileOffset(/*NO_COPY*/Start);
        /*uint*/int Length = Sources.getFileOffset(/*NO_COPY*/End) - Offset;
        Ranges.push_back_T$RR(new Range(Offset, Length));
      }
      return false;
    }
    if (Offsets.empty()) {
      Offsets.push_back_T$RR(0);
    }
    if (Offsets.size() != Lengths.size()
       && !(Offsets.size() == 1 && Lengths.empty())) {
      errs().$out(/*KEEP_STR*/"error: number of -offset and -length arguments must match.\n");
      return true;
    }
    for (/*uint*/int i = 0, e = Offsets.size(); i != e; ++i) {
      if ($greatereq_uint(Offsets.$at(i), Code.getBufferSize())) {
        errs().$out(/*KEEP_STR*/"error: offset ").$out_uint(Offsets.$at(i)).$out(/*KEEP_STR*/" is outside the file\n");
        return true;
      }
      SourceLocation Start = Sources.getLocForStartOfFile(/*NO_COPY*/ID).getLocWithOffset(Offsets.$at(i));
      SourceLocation End/*J*/= new SourceLocation();
      if ($less_uint(i, Lengths.size())) {
        if ($greater_uint(Offsets.$at(i) + Lengths.$at(i), Code.getBufferSize())) {
          errs().$out(/*KEEP_STR*/"error: invalid length ").$out_uint(Lengths.$at(i)).$out(
              /*KEEP_STR*/", offset + length ("
          ).$out_uint(Offsets.$at(i) + Lengths.$at(i)).$out(
              /*KEEP_STR*/") is outside the file.\n"
          );
          return true;
        }
        End.$assignMove(Start.getLocWithOffset(Lengths.$at(i)));
      } else {
        End.$assignMove(Sources.getLocForEndOfFile(/*NO_COPY*/ID));
      }
      /*uint*/int Offset = Sources.getFileOffset(/*NO_COPY*/Start);
      /*uint*/int Length = Sources.getFileOffset(/*NO_COPY*/End) - Offset;
      Ranges.push_back_T$RR(new Range(Offset, Length));
    }
    return false;
  } finally {
    if (Sources != null) { Sources.$destroy(); }
    if (Diagnostics != null) { Diagnostics.$destroy(); }
    if (Files != null) { Files.$destroy(); }
    if (InMemoryFileSystem != null) { InMemoryFileSystem.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::outputReplacementXML">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 201,
 FQN="clang::format::outputReplacementXML", NM="_ZN5clang6formatL20outputReplacementXMLEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL20outputReplacementXMLEN4llvm9StringRefE")
//</editor-fold>
public static void outputReplacementXML(StringRef Text) {
  // FIXME: When we sort includes, we need to make sure the stream is correct
  // utf-8.
  /*size_t*/int From = 0;
  /*size_t*/int Index;
  while ((Index = Text.find_first_of(/*STRINGREF_STR*/"\n\015<&", From)) != StringRef.npos) {
    outs().$out(Text.substr(From, Index - From));
    switch (Text.$at(Index)) {
     case '\n':
      outs().$out(/*KEEP_STR*/"&#10;");
      break;
     case '\r':
      outs().$out(/*KEEP_STR*/"&#13;");
      break;
     case '<':
      outs().$out(/*KEEP_STR*/"&lt;");
      break;
     case '&':
      outs().$out(/*KEEP_STR*/"&amp;");
      break;
     default:
      throw new llvm_unreachable("Unexpected character encountered!");
    }
    From = Index + 1;
  }
  outs().$out(Text.substr(From));
}

//<editor-fold defaultstate="collapsed" desc="clang::format::outputReplacementsXML">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 229,
 FQN="clang::format::outputReplacementsXML", NM="_ZN5clang6formatL21outputReplacementsXMLERKSt3setINS_7tooling11ReplacementESt4lessIS3_ESaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL21outputReplacementsXMLERKSt3setINS_7tooling11ReplacementESt4lessIS3_ESaIS3_EE")
//</editor-fold>
public static void outputReplacementsXML(final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
  for (final /*const*/ Replacement /*&*/ R : Replaces) {
    outs().$out(/*KEEP_STR*/"<replacement ").$out(
        /*KEEP_STR*/"offset='"
    ).$out_uint(R.getOffset()).$out(/*KEEP_STR*/"' ").$out(
        /*KEEP_STR*/"length='"
    ).$out_uint(R.getLength()).$out(/*KEEP_STR*/"'>");
    outputReplacementXML(R.getReplacementText());
    outs().$out(/*KEEP_STR*/"</replacement>\n");
  }
}


// Returns true on error.
//<editor-fold defaultstate="collapsed" desc="clang::format::format">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp", line = 240,
 FQN="clang::format::format", NM="_ZN5clang6formatL6formatEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp -nm=_ZN5clang6formatL6formatEN4llvm9StringRefE")
//</editor-fold>
public static boolean format(StringRef FileName) {
  ErrorOr<std.unique_ptr<MemoryBuffer> > CodeOrErr = null;
  std.vector<Range> Ranges = null;
  FormatStyle $FormatStyle = null;
  std.setType<Replacement> Replaces = null;
  Expected<std.string> ChangedCode = null;
  std.setType<Replacement> FormatChanges = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    CodeOrErr = MemoryBuffer.getFileOrSTDIN(new Twine(FileName));
    {
      std.error_code EC = CodeOrErr.getError();
      if (EC.$bool()) {
        errs().$out(EC.message()).$out(/*KEEP_STR*/$LF);
        return true;
      }
    }
    std.unique_ptr<MemoryBuffer> Code = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(CodeOrErr.get()));
    if (Code.$arrow().getBufferSize() == 0) {
      return false; // Empty files are formatted correctly.
    }
    Ranges/*J*/= new std.vector<Range>(new Range());
    if (fillRanges(Code.get(), Ranges)) {
      return true;
    }
    StringRef AssumedFileName = ($eq_StringRef(/*NO_COPY*/FileName, /*STRINGREF_STR*/"-")) ? new StringRef(AssumeFileName) : new StringRef(FileName);
    $FormatStyle = org.clang.format.FormatGlobals.getStyle(new StringRef(Style), new StringRef(AssumedFileName), new StringRef(FallbackStyle));
    if (SortIncludes.getNumOccurrences() != 0) {
      $FormatStyle.SortIncludes = SortIncludes.$T();
    }
    uint$ptr CursorPosition = create_uint$ptr(Cursor.$T());
    Replaces = org.clang.format.FormatGlobals.sortIncludes($FormatStyle, Code.$arrow().getBuffer(), new ArrayRef<Range>(Ranges, false), 
        new StringRef(AssumedFileName), /*AddrOf*/CursorPosition);
    ChangedCode = ToolingGlobals.applyAllReplacements(Code.$arrow().getBuffer(), Replaces);
    if (!ChangedCode.$bool()) {
      $c$.clean(llvm.errs().$out(llvm.__toString($c$.track(ChangedCode.takeError()))).$out(/*KEEP_STR*/$LF));
      return true;
    }
    for (final /*const*/ Replacement /*&*/ R : Replaces)  {
      Ranges.push_back_T$RR(/*{ */new Range(R.getOffset(), R.getLength())/* }*/);
    }
    
    bool$ptr IncompleteFormat = create_bool$ptr(false);
    FormatChanges = reformat($FormatStyle, new StringRef(ChangedCode.$star()), new ArrayRef<Range>(Ranges, false), 
        new StringRef(AssumedFileName), /*AddrOf*/IncompleteFormat);
    $c$.clean(Replaces.$assignMove($c$.track(ToolingGlobals.mergeReplacements(Replaces, FormatChanges))));
    if (OutputXML.$T()) {
      outs().$out(/*KEEP_STR*/"<?xml version='1.0'?>\n<replacements xml:space='preserve' incomplete_format='").$out(
          (IncompleteFormat.$star() ? $true : $false)
      ).$out(/*KEEP_STR*/"'>\n");
      if (Cursor.getNumOccurrences() != 0) {
        outs().$out(/*KEEP_STR*/"<cursor>").$out_uint(
            ToolingGlobals.shiftedCodePosition(FormatChanges, CursorPosition.$star())
        ).$out(
            /*KEEP_STR*/"</cursor>\n"
        );
      }
      
      outputReplacementsXML(Replaces);
      outs().$out(/*KEEP_STR*/"</replacements>\n");
    } else {
      IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem = null;
      FileManager Files = null;
      DiagnosticsEngine Diagnostics = null;
      SourceManager Sources = null;
      Rewriter Rewrite = null;
      try {
        InMemoryFileSystem/*J*/= new IntrusiveRefCntPtr<InMemoryFileSystem>(new InMemoryFileSystem());
        Files/*J*/= $c$.clean(new FileManager(new FileSystemOptions(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, InMemoryFileSystem))));
        Diagnostics/*J*/= $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
            new DiagnosticOptions()));
        Sources/*J*/= new SourceManager(Diagnostics, Files);
        FileID ID = createInMemoryFile(new StringRef(AssumedFileName), Code.get(), Sources, Files, 
            InMemoryFileSystem.get());
        Rewrite/*J*/= new Rewriter(Sources, new LangOptions());
        ToolingGlobals.applyAllReplacements(Replaces, Rewrite);
        if (Inplace.$T()) {
          if ($eq_StringRef(/*NO_COPY*/FileName, /*STRINGREF_STR*/"-")) {
            errs().$out(/*KEEP_STR*/"error: cannot use -i when reading from stdin.\n");
          } else if (Rewrite.overwriteChangedFiles()) {
            return true;
          }
        } else {
          if (Cursor.getNumOccurrences() != 0) {
            outs().$out(/*KEEP_STR*/"{ \"Cursor\": ").$out_uint(
                ToolingGlobals.shiftedCodePosition(FormatChanges, CursorPosition.$star())
            ).$out(
                /*KEEP_STR*/", \"IncompleteFormat\": "
            ).$out(
                (IncompleteFormat.$star() ? $true : $false)
            ).$out(/*KEEP_STR*/" }\n");
          }
          Rewrite.getEditBuffer(new FileID(ID)).write(outs());
        }
      } finally {
        if (Rewrite != null) { Rewrite.$destroy(); }
        if (Sources != null) { Sources.$destroy(); }
        if (Diagnostics != null) { Diagnostics.$destroy(); }
        if (Files != null) { Files.$destroy(); }
        if (InMemoryFileSystem != null) { InMemoryFileSystem.$destroy(); }
      }
    }
    return false;
  } finally {
    if (FormatChanges != null) { FormatChanges.$destroy(); }
    if (ChangedCode != null) { ChangedCode.$destroy(); }
    if (Replaces != null) { Replaces.$destroy(); }
    if ($FormatStyle != null) { $FormatStyle.$destroy(); }
    if (Ranges != null) { Ranges.$destroy(); }
    if (CodeOrErr != null) { CodeOrErr.$destroy(); }
    $c$.$destroy();
  }
}

} // END OF class FormatGlobals
