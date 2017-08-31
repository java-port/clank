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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;


/// \brief Options for controlling the compiler diagnostics engine.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 61,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", old_line = 28,
 FQN="clang::DiagnosticOptions", NM="_ZN5clang17DiagnosticOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptionsE")
//</editor-fold>
public class DiagnosticOptions extends /*public*/ RefCountedBase<DiagnosticOptions> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::TextDiagnosticFormat">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", old_line = 30,
   FQN="clang::DiagnosticOptions::TextDiagnosticFormat", NM="_ZN5clang17DiagnosticOptions20TextDiagnosticFormatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptions20TextDiagnosticFormatE")
  //</editor-fold>
  public enum TextDiagnosticFormat {
    Clang(0),
    MSVC(Clang.getValue() + 1),
    Vi(MSVC.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TextDiagnosticFormat valueOf(int val) {
      TextDiagnosticFormat out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final TextDiagnosticFormat[] VALUES;
      private static final TextDiagnosticFormat[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TextDiagnosticFormat kind : TextDiagnosticFormat.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TextDiagnosticFormat[min < 0 ? (1-min) : 0];
        VALUES = new TextDiagnosticFormat[max >= 0 ? (1+max) : 0];
        for (TextDiagnosticFormat kind : TextDiagnosticFormat.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private TextDiagnosticFormat(int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  
  // Default values.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", old_line = 33,
   FQN="clang::DiagnosticOptions::(anonymous)", NM="_ZN5clang17DiagnosticOptionsE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptionsE_Unnamed_enum1")
  //</editor-fold>
  public enum Unnamed_enum1 {
    DefaultTabStop(8),
    MaxTabStop(100),
    DefaultMacroBacktraceLimit(6),
    DefaultTemplateBacktraceLimit(10),
    DefaultConstexprBacktraceLimit(10),
    DefaultSpellCheckingLimit(50);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum1 valueOf(int val) {
      Unnamed_enum1 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum1[] VALUES;
      private static final Unnamed_enum1[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum1[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum1[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private Unnamed_enum1(int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  public /*JBIT unsigned int*/ boolean IgnoreWarnings /*: 1*/;
  /// -w
  public /*JBIT unsigned int*/ boolean NoRewriteMacros /*: 1*/;
  /// -Wno-rewrite-macros
  public /*JBIT unsigned int*/ boolean Pedantic /*: 1*/;
  /// -pedantic
  public /*JBIT unsigned int*/ boolean PedanticErrors /*: 1*/;
  /// -pedantic-errors
  public /*JBIT unsigned int*/ boolean ShowColumn /*: 1*/;
  /// Show column number on diagnostics.
  public /*JBIT unsigned int*/ boolean ShowLocation /*: 1*/;
  /// Show source location information.
  public /*JBIT unsigned int*/ boolean ShowCarets /*: 1*/;
  /// Show carets in diagnostics.
  public /*JBIT unsigned int*/ boolean ShowFixits /*: 1*/;
  /// Show fixit information.
  public /*JBIT unsigned int*/ boolean ShowSourceRanges /*: 1*/;
  /// Show source ranges in numeric form.
  public /*JBIT unsigned int*/ boolean ShowParseableFixits /*: 1*/;
  /// Show machine parseable fix-its.
  public /*JBIT unsigned int*/ boolean ShowPresumedLoc /*: 1*/;
  /// Show presumed location for diagnostics.
  public /*JBIT unsigned int*/ boolean ShowOptionNames /*: 1*/;
  /// Show the option name for mappable
  /// diagnostics.
  public /*JBIT unsigned int*/ boolean ShowNoteIncludeStack /*: 1*/;
  /// Show include stacks for notes.
  public /*JBYTE unsigned int*/ byte ShowCategories /*: 2*/;
  /// Format for diagnostics: 
  public /*JBIT unsigned int*/ boolean ShowColors /*: 1*/;
  /// Overload candidates to show.
  public /*JBIT unsigned int*/ boolean VerifyDiagnostics /*: 1*/;
  /// Ignore unexpected diagnostics of
  /// the specified levels when using
  /// -verify.
  public /*JBIT unsigned int*/ boolean ElideType /*: 1*/;
  /// Elide identical types in template diffing
  public /*JBIT unsigned int*/ boolean ShowTemplateTree /*: 1*/;
  /// Print a template tree when diffing
  public /*JBIT unsigned int*/ boolean CLFallbackMode /*: 1*/;
  /// Format for clang-cl fallback mode
  public /*uint*/int ErrorLimit /*: 32*/;
  /// Limit # errors emitted.
  /// Limit depth of macro expansion backtrace.
  public /*uint*/int MacroBacktraceLimit /*: 32*/;
  /// Limit depth of instantiation backtrace.
  public /*uint*/int TemplateBacktraceLimit /*: 32*/;
  /// Limit depth of constexpr backtrace.
  public /*uint*/int ConstexprBacktraceLimit /*: 32*/;
  /// Limit number of times to perform spell checking.
  public /*uint*/int SpellCheckingLimit /*: 32*/;
  public /*uint*/int TabStop /*: 32*/;
  /// The distance between tab stops.
  /// Column limit for formatting message diagnostics, or 0 if unused.
  public /*uint*/int MessageLength /*: 32*/;
/*protected:*/
  /// Show categories: 0 -> none, 1 -> Number,
  /// 2 -> Full Name.
  protected /*JBYTE unsigned int*/ TextDiagnosticFormat Format /*: 2*/; /// Format for diagnostics: 
  /// Show diagnostics with ANSI color sequences.
  protected /*JBIT unsigned int*/ OverloadsShown ShowOverloads /*: 1*/;
  /// Check that diagnostics match the expected
  /// diagnostics, indicated by markers in the
  /// input source file.
  protected /*JBYTE unsigned int*/ int VerifyIgnoreUnexpected /*: 4*/;
/*public:*/
  /// \brief The file to log diagnostic output to.
  public std.string DiagnosticLogFile;
  
  /// \brief The file to serialize diagnostics to (non-appending).
  public std.string DiagnosticSerializationFile;
  
  /// The list of -W... options used to alter the diagnostic mappings, with the
  /// prefixes removed.
  public std.vectorString Warnings;
  
  /// The list of -R... options used to alter the diagnostic mappings, with the
  /// prefixes removed.
  public std.vectorString Remarks;
/*public:*/
  /// Show categories: 0 -> none, 1 -> Number,
  /// 2 -> Full Name.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::getFormat">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", line = 64,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", old_line = 64,
   FQN="clang::DiagnosticOptions::getFormat", NM="_ZNK5clang17DiagnosticOptions9getFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang17DiagnosticOptions9getFormatEv")
  //</editor-fold>
  public TextDiagnosticFormat getFormat() /*const*/ {
    return ((/*static_cast*/TextDiagnosticFormat)(Format));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::setFormat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", line = 64,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", old_line = 64,
   FQN="clang::DiagnosticOptions::setFormat", NM="_ZN5clang17DiagnosticOptions9setFormatENS0_20TextDiagnosticFormatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptions9setFormatENS0_20TextDiagnosticFormatE")
  //</editor-fold>
  public void setFormat(TextDiagnosticFormat Value) {
    Format = ((Value));
  }

  /// Show diagnostics with ANSI color sequences.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::getShowOverloads">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", old_line = 67,
   FQN="clang::DiagnosticOptions::getShowOverloads", NM="_ZNK5clang17DiagnosticOptions16getShowOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang17DiagnosticOptions16getShowOverloadsEv")
  //</editor-fold>
  public OverloadsShown getShowOverloads() /*const*/ {
    return ((/*static_cast*/OverloadsShown)(ShowOverloads));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::setShowOverloads">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", old_line = 67,
   FQN="clang::DiagnosticOptions::setShowOverloads", NM="_ZN5clang17DiagnosticOptions16setShowOverloadsENS_14OverloadsShownE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptions16setShowOverloadsENS_14OverloadsShownE")
  //</editor-fold>
  public void setShowOverloads(OverloadsShown Value) {
    ShowOverloads = ((Value));
  }

  /// Check that diagnostics match the expected
  /// diagnostics, indicated by markers in the
  /// input source file.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::getVerifyIgnoreUnexpected">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", line = 72,
   FQN="clang::DiagnosticOptions::getVerifyIgnoreUnexpected", NM="_ZNK5clang17DiagnosticOptions25getVerifyIgnoreUnexpectedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang17DiagnosticOptions25getVerifyIgnoreUnexpectedEv")
  //</editor-fold>
  public int getVerifyIgnoreUnexpected() /*const*/ {
    return ((/*static_cast*/int)(VerifyIgnoreUnexpected));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::setVerifyIgnoreUnexpected">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.def", line = 72,
   FQN="clang::DiagnosticOptions::setVerifyIgnoreUnexpected", NM="_ZN5clang17DiagnosticOptions25setVerifyIgnoreUnexpectedENS_19DiagnosticLevelMaskE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptions25setVerifyIgnoreUnexpectedENS_19DiagnosticLevelMaskE")
  //</editor-fold>
  public void setVerifyIgnoreUnexpected(int Value) {
    VerifyIgnoreUnexpected = ((/*static_cast*//*uint*/int)(Value));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::DiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", old_line = 74,
   FQN="clang::DiagnosticOptions::DiagnosticOptions", NM="_ZN5clang17DiagnosticOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptionsC1Ev")
  //</editor-fold>
  public DiagnosticOptions() {
    /* : RefCountedBase<DiagnosticOptions>(), DiagnosticLogFile(), DiagnosticSerializationFile(), Warnings(), Remarks()*/ 
    //START JInit
    super();
    this.DiagnosticLogFile = new std.string();
    this.DiagnosticSerializationFile = new std.string();
    this.Warnings = new std.vectorString(std.string.EMPTY);
    this.Remarks = new std.vectorString(std.string.EMPTY);
    //END JInit
    IgnoreWarnings = false;
    /// -w
    NoRewriteMacros = false;
    /// -Wno-rewrite-macros
    Pedantic = false;
    /// -pedantic
    PedanticErrors = false;
    /// -pedantic-errors
    ShowColumn = true;
    /// Show column number on diagnostics.
    ShowLocation = true;
    /// Show source location information.
    ShowCarets = true;
    /// Show carets in diagnostics.
    ShowFixits = true;
    /// Show fixit information.
    ShowSourceRanges = false;
    /// Show source ranges in numeric form.
    ShowParseableFixits = false;
    /// Show machine parseable fix-its.
    ShowPresumedLoc = false;
    /// Show presumed location for diagnostics.
    ShowOptionNames = false;
    /// Show the option name for mappable
    /// diagnostics.
    ShowNoteIncludeStack = false;
    /// Show include stacks for notes.
    ShowCategories = 0;
    /// Show categories: 0 -> none, 1 -> Number,
    /// 2 -> Full Name.
    setFormat(TextDiagnosticFormat.Clang);
    /// Format for diagnostics: 
    ShowColors = false;
    /// Show diagnostics with ANSI color sequences.
    setShowOverloads(OverloadsShown.Ovl_All);
    /// Overload candidates to show.
    VerifyDiagnostics = false;
    /// Check that diagnostics match the expected
    /// diagnostics, indicated by markers in the
    /// input source file.
    setVerifyIgnoreUnexpected(DiagnosticLevelMask.None);
    /// Ignore unexpected diagnostics of
    /// the specified levels when using
    /// -verify.
    ElideType = false;
    /// Elide identical types in template diffing
    ShowTemplateTree = false;
    /// Print a template tree when diffing
    CLFallbackMode = false;
    /// Format for clang-cl fallback mode
    ErrorLimit = 0;
    /// Limit # errors emitted.
    /// Limit depth of macro expansion backtrace.
    MacroBacktraceLimit = Unnamed_enum1.DefaultMacroBacktraceLimit.getValue();
    /// Limit depth of instantiation backtrace.
    TemplateBacktraceLimit = Unnamed_enum1.DefaultTemplateBacktraceLimit.getValue();
    /// Limit depth of constexpr backtrace.
    ConstexprBacktraceLimit = Unnamed_enum1.DefaultConstexprBacktraceLimit.getValue();
    /// Limit number of times to perform spell checking.
    SpellCheckingLimit = Unnamed_enum1.DefaultSpellCheckingLimit.getValue();
    TabStop = Unnamed_enum1.DefaultTabStop.getValue();
    /// The distance between tab stops.
    /// Column limit for formatting message diagnostics, or 0 if unused.
    MessageLength = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::DiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", old_line = 28,
   FQN="clang::DiagnosticOptions::DiagnosticOptions", NM="_ZN5clang17DiagnosticOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DiagnosticOptions(/*const*/ DiagnosticOptions /*&*/ $Prm0) {
    /* : RefCountedBase<DiagnosticOptions>(), IgnoreWarnings(.IgnoreWarnings), NoRewriteMacros(.NoRewriteMacros), Pedantic(.Pedantic), PedanticErrors(.PedanticErrors), ShowColumn(.ShowColumn), ShowLocation(.ShowLocation), ShowCarets(.ShowCarets), ShowFixits(.ShowFixits), ShowSourceRanges(.ShowSourceRanges), ShowParseableFixits(.ShowParseableFixits), ShowPresumedLoc(.ShowPresumedLoc), ShowOptionNames(.ShowOptionNames), ShowNoteIncludeStack(.ShowNoteIncludeStack), ShowCategories(.ShowCategories), ShowColors(.ShowColors), VerifyDiagnostics(.VerifyDiagnostics), ElideType(.ElideType), ShowTemplateTree(.ShowTemplateTree), CLFallbackMode(.CLFallbackMode), ErrorLimit(.ErrorLimit), MacroBacktraceLimit(.MacroBacktraceLimit), TemplateBacktraceLimit(.TemplateBacktraceLimit), ConstexprBacktraceLimit(.ConstexprBacktraceLimit), SpellCheckingLimit(.SpellCheckingLimit), TabStop(.TabStop), MessageLength(.MessageLength), Format(.Format), ShowOverloads(.ShowOverloads), VerifyIgnoreUnexpected(.VerifyIgnoreUnexpected), DiagnosticLogFile(.DiagnosticLogFile), DiagnosticSerializationFile(.DiagnosticSerializationFile), Warnings(.Warnings), Remarks(.Remarks)*/ 
    //START JInit
    super($Prm0);
    this.IgnoreWarnings = $Prm0.IgnoreWarnings;
    this.NoRewriteMacros = $Prm0.NoRewriteMacros;
    this.Pedantic = $Prm0.Pedantic;
    this.PedanticErrors = $Prm0.PedanticErrors;
    this.ShowColumn = $Prm0.ShowColumn;
    this.ShowLocation = $Prm0.ShowLocation;
    this.ShowCarets = $Prm0.ShowCarets;
    this.ShowFixits = $Prm0.ShowFixits;
    this.ShowSourceRanges = $Prm0.ShowSourceRanges;
    this.ShowParseableFixits = $Prm0.ShowParseableFixits;
    this.ShowPresumedLoc = $Prm0.ShowPresumedLoc;
    this.ShowOptionNames = $Prm0.ShowOptionNames;
    this.ShowNoteIncludeStack = $Prm0.ShowNoteIncludeStack;
    this.ShowCategories = $Prm0.ShowCategories;
    this.ShowColors = $Prm0.ShowColors;
    this.VerifyDiagnostics = $Prm0.VerifyDiagnostics;
    this.ElideType = $Prm0.ElideType;
    this.ShowTemplateTree = $Prm0.ShowTemplateTree;
    this.CLFallbackMode = $Prm0.CLFallbackMode;
    this.ErrorLimit = $Prm0.ErrorLimit;
    this.MacroBacktraceLimit = $Prm0.MacroBacktraceLimit;
    this.TemplateBacktraceLimit = $Prm0.TemplateBacktraceLimit;
    this.ConstexprBacktraceLimit = $Prm0.ConstexprBacktraceLimit;
    this.SpellCheckingLimit = $Prm0.SpellCheckingLimit;
    this.TabStop = $Prm0.TabStop;
    this.MessageLength = $Prm0.MessageLength;
    this.Format = $Prm0.Format;
    this.ShowOverloads = $Prm0.ShowOverloads;
    this.VerifyIgnoreUnexpected = $Prm0.VerifyIgnoreUnexpected;
    this.DiagnosticLogFile = new std.string($Prm0.DiagnosticLogFile);
    this.DiagnosticSerializationFile = new std.string($Prm0.DiagnosticSerializationFile);
    this.Warnings = new std.vectorString($Prm0.Warnings);
    this.Remarks = new std.vectorString($Prm0.Remarks);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticOptions::~DiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", old_line = 28,
   FQN="clang::DiagnosticOptions::~DiagnosticOptions", NM="_ZN5clang17DiagnosticOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang17DiagnosticOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Remarks.$destroy();
    Warnings.$destroy();
    DiagnosticSerializationFile.$destroy();
    DiagnosticLogFile.$destroy();
    //~RefCountedBase<DiagnosticOptions>;
    //END JDestroy
  }

  
  public String toString() {
    return "" + "IgnoreWarnings=" + IgnoreWarnings // NOI18N
              + ", NoRewriteMacros=" + NoRewriteMacros // NOI18N
              + ", Pedantic=" + Pedantic // NOI18N
              + ", PedanticErrors=" + PedanticErrors // NOI18N
              + ", ShowColumn=" + ShowColumn // NOI18N
              + ", ShowLocation=" + ShowLocation // NOI18N
              + ", ShowCarets=" + ShowCarets // NOI18N
              + ", ShowFixits=" + ShowFixits // NOI18N
              + ", ShowSourceRanges=" + ShowSourceRanges // NOI18N
              + ", ShowParseableFixits=" + ShowParseableFixits // NOI18N
              + ", ShowPresumedLoc=" + ShowPresumedLoc // NOI18N
              + ", ShowOptionNames=" + ShowOptionNames // NOI18N
              + ", ShowNoteIncludeStack=" + ShowNoteIncludeStack // NOI18N
              + ", ShowCategories=" + ShowCategories // NOI18N
              + ", ShowColors=" + ShowColors // NOI18N
              + ", VerifyDiagnostics=" + VerifyDiagnostics // NOI18N
              + ", ElideType=" + ElideType // NOI18N
              + ", ShowTemplateTree=" + ShowTemplateTree // NOI18N
              + ", CLFallbackMode=" + CLFallbackMode // NOI18N
              + ", ErrorLimit=" + ErrorLimit // NOI18N
              + ", MacroBacktraceLimit=" + MacroBacktraceLimit // NOI18N
              + ", TemplateBacktraceLimit=" + TemplateBacktraceLimit // NOI18N
              + ", ConstexprBacktraceLimit=" + ConstexprBacktraceLimit // NOI18N
              + ", SpellCheckingLimit=" + SpellCheckingLimit // NOI18N
              + ", TabStop=" + TabStop // NOI18N
              + ", MessageLength=" + MessageLength // NOI18N
              + ", Format=" + Format // NOI18N
              + ", ShowOverloads=" + ShowOverloads // NOI18N
              + ", VerifyIgnoreUnexpected=" + VerifyIgnoreUnexpected // NOI18N
              + ", DiagnosticLogFile=" + DiagnosticLogFile // NOI18N
              + ", DiagnosticSerializationFile=" + DiagnosticSerializationFile // NOI18N
              + ", Warnings=" + Warnings // NOI18N
              + ", Remarks=" + Remarks // NOI18N
              + super.toString(); // NOI18N
  }
}
