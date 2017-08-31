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

package org.clang.frontend.staticanalyzer;

import static org.clang.frontend.staticanalyzer.impl.AnalyzerOptionsStatics.*;
import org.clang.frontend.staticanalyzer.spi.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", line = 124,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", old_line = 120,
 FQN="clang::AnalyzerOptions", NM="_ZN5clang15AnalyzerOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptionsE")
//</editor-fold>
public class AnalyzerOptions extends /*public*/ RefCountedBase<AnalyzerOptions> implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef llvm::StringMap<std::string> ConfigTable*/
//  public final class ConfigTable extends StringMap<std.string>{ };
  
  /// \brief Pair of checker name and enable/disable.
  public std.vector<std.pairTypeBool<std.string>> CheckersControlList;
  
  /// \brief A key-value table of use-specified configuration values.
  public StringMap<std.string> Config;
  public AnalysisStores AnalysisStoreOpt;
  public AnalysisConstraints AnalysisConstraintsOpt;
  public AnalysisDiagClients AnalysisDiagOpt;
  public AnalysisPurgeMode AnalysisPurgeOpt;
  
  public std.string AnalyzeSpecificFunction;
  
  /// \brief The maximum number of times the analyzer visits a block.
  public /*uint*/int maxBlockVisitOnPath;
  
  /// \brief Disable all analyzer checks.
  ///
  /// This flag allows one to disable analyzer checks on the code processed by
  /// the given analysis consumer. Note, the code will get parsed and the
  /// command-line options will get checked.
  public /*JBIT unsigned int*/ boolean DisableAllChecks /*: 1*/;
  
  public /*JBIT unsigned int*/ boolean ShowCheckerHelp /*: 1*/;
  public /*JBIT unsigned int*/ boolean AnalyzeAll /*: 1*/;
  public /*JBIT unsigned int*/ boolean AnalyzerDisplayProgress /*: 1*/;
  public /*JBIT unsigned int*/ boolean AnalyzeNestedBlocks /*: 1*/;
  
  /// \brief The flag regulates if we should eagerly assume evaluations of
  /// conditionals, thus, bifurcating the path.
  ///
  /// This flag indicates how the engine should handle expressions such as: 'x =
  /// (y != 0)'.  When this flag is true then the subexpression 'y != 0' will be
  /// eagerly assumed to be true or false, thus evaluating it to the integers 0
  /// or 1 respectively.  The upside is that this can increase analysis
  /// precision until we have a better way to lazily evaluate such logic.  The
  /// downside is that it eagerly bifurcates paths.
  public /*JBIT unsigned int*/ boolean eagerlyAssumeBinOpBifurcation /*: 1*/;
  
  public /*JBIT unsigned int*/ boolean TrimGraph /*: 1*/;
  public /*JBIT unsigned int*/ boolean visualizeExplodedGraphWithGraphViz /*: 1*/;
  public /*JBIT unsigned int*/ boolean visualizeExplodedGraphWithUbiGraph /*: 1*/;
  public /*JBIT unsigned int*/ boolean UnoptimizedCFG /*: 1*/;
  public /*JBIT unsigned int*/ boolean PrintStats /*: 1*/;
  
  /// \brief Do not re-analyze paths leading to exhausted nodes with a different
  /// strategy. We get better code coverage when retry is enabled.
  public /*JBIT unsigned int*/ boolean NoRetryExhausted /*: 1*/;
  
  /// \brief The inlining stack depth limit.
  public /*uint*/int InlineMaxStackDepth;
  
  /// \brief The mode of function selection used during inlining.
  public AnalysisInliningMode InliningMode;
/*private:*/
  /// \brief Describes the kinds for high-level analyzer mode.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::UserModeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", old_line = 181,
   FQN="clang::AnalyzerOptions::UserModeKind", NM="_ZN5clang15AnalyzerOptions12UserModeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions12UserModeKindE")
  //</editor-fold>
  private enum UserModeKind implements Native.ComparableLower {
    UMK_NotSet(0),
    /// Perform shallow but fast analyzes.
    UMK_Shallow(1),
    /// Perform deep analyzes.
    UMK_Deep(2);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static UserModeKind valueOf(int val) {
      UserModeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final UserModeKind[] VALUES;
      private static final UserModeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (UserModeKind kind : UserModeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new UserModeKind[min < 0 ? (1-min) : 0];
        VALUES = new UserModeKind[max >= 0 ? (1+max) : 0];
        for (UserModeKind kind : UserModeKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private UserModeKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((UserModeKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((UserModeKind)obj).value);}
    //</editor-fold>
  };
  
  /// Controls the high-level analyzer mode, which influences the default 
  /// settings for some of the lower-level config options (such as IPAMode).
  /// \sa getUserMode
  private UserModeKind UserMode;
  
  /// Controls the mode of inter-procedural analysis.
  private IPAKind IPAMode;
  
  /// Controls which C++ member functions will be considered for inlining.
  private CXXInlineableMemberKind CXXMemberInliningMode;
  
  /// \sa includeTemporaryDtorsInCFG
  private OptionalBool IncludeTemporaryDtorsInCFG;
  
  /// \sa mayInlineCXXStandardLibrary
  private OptionalBool InlineCXXStandardLibrary;
  
  /// \sa mayInlineTemplateFunctions
  private OptionalBool InlineTemplateFunctions;
  
  /// \sa mayInlineCXXAllocator
  private OptionalBool InlineCXXAllocator;
  
  /// \sa mayInlineCXXContainerMethods
  private OptionalBool InlineCXXContainerMethods;
  
  /// \sa mayInlineCXXSharedPtrDtor
  private OptionalBool InlineCXXSharedPtrDtor;
  
  /// \sa mayInlineObjCMethod
  private OptionalBool ObjCInliningMode;
  
  // Cache of the "ipa-always-inline-size" setting.
  // \sa getAlwaysInlineSize
  private OptionalUInt AlwaysInlineSize;
  
  /// \sa shouldSuppressNullReturnPaths
  private OptionalBool SuppressNullReturnPaths;
  
  // \sa getMaxInlinableSize
  private OptionalUInt MaxInlinableSize;
  
  /// \sa shouldAvoidSuppressingNullArgumentPaths
  private OptionalBool AvoidSuppressingNullArgumentPaths;
  
  /// \sa shouldSuppressInlinedDefensiveChecks
  private OptionalBool SuppressInlinedDefensiveChecks;
  
  /// \sa shouldSuppressFromCXXStandardLibrary
  private OptionalBool SuppressFromCXXStandardLibrary;
  
  /// \sa reportIssuesInMainSourceFile
  private OptionalBool ReportIssuesInMainSourceFile;
  
  /// \sa StableReportFilename
  private OptionalBool StableReportFilename;
  
  /// \sa getGraphTrimInterval
  private OptionalUInt GraphTrimInterval;
  
  /// \sa getMaxTimesInlineLarge
  private OptionalUInt MaxTimesInlineLarge;
  
  /// \sa getMinCFGSizeTreatFunctionsAsLarge
  private OptionalUInt MinCFGSizeTreatFunctionsAsLarge;
  
  /// \sa getMaxNodesPerTopLevelFunction
  private OptionalUInt MaxNodesPerTopLevelFunction;
  
  /// \sa shouldInlineLambdas
  private OptionalBool InlineLambdas;
  
  /// \sa shouldWidenLoops
  private OptionalBool WidenLoops;
  
  /// A helper function that retrieves option for a given full-qualified
  /// checker name.
  /// Options for checkers can be specified via 'analyzer-config' command-line
  /// option.
  /// Example:
  /// @code-analyzer-config unix.Malloc:OptionName=CheckerOptionValue @endcode
  /// or @code-analyzer-config unix:OptionName=GroupOptionValue @endcode
  /// for groups of checkers.
  /// @param [in] CheckerName  Full-qualified checker name, like
  /// alpha.unix.StreamChecker.
  /// @param [in] OptionName  Name of the option to get.
  /// @param [in] Default  Default value if no option is specified.
  /// @param [in] SearchInParents If set to true and the searched option was not
  /// specified for the given checker the options for the parent packages will
  /// be searched as well. The inner packages take precedence over the outer
  /// ones.
  /// @retval CheckerOptionValue  An option for a checker if it was specified.
  /// @retval GroupOptionValue  An option for group if it was specified and no
  /// checker-specific options were found. The closer group to checker,
  /// the more priority it has. For example, @c coregroup.subgroup has more
  /// priority than @c coregroup for @c coregroup.subgroup.CheckerName checker.
  /// @retval Default  If nor checker option, nor group option was found.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getCheckerOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 105,
   FQN="clang::AnalyzerOptions::getCheckerOption", NM="_ZN5clang15AnalyzerOptions16getCheckerOptionEN4llvm9StringRefES2_S2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions16getCheckerOptionEN4llvm9StringRefES2_S2_b")
  //</editor-fold>
  private StringRef getCheckerOption(StringRef CheckerName, 
                  StringRef OptionName, 
                  StringRef Default) {
    return getCheckerOption(CheckerName, 
                  OptionName, 
                  Default, 
                  false);
  }
  private StringRef getCheckerOption(StringRef CheckerName, 
                  StringRef OptionName, 
                  StringRef Default, 
                  boolean SearchInParents/*= false*/) {
    // Search for a package option if the option for the checker is not specified
    // and search in parents is enabled.
    StringMapConstIterator<std.string> E = Config.end();
    do {
      StringMapConstIterator<std.string> I = Config.find(new StringRef(($add_Twine($add_Twine(new Twine(CheckerName), new Twine(/*KEEP_STR*/$COLON)), new Twine(OptionName))).str()));
      if (I.$noteq(E)) {
        return new StringRef(I.$arrow().getValue());
      }
      /*size_t*/int Pos = CheckerName.rfind($$DOT);
      if (Pos == StringRef.npos) {
        return new StringRef(JD$Move.INSTANCE, Default);
      }
      CheckerName.$assignMove(CheckerName.substr(0, Pos));
    } while (!CheckerName.empty() && SearchInParents);
    return new StringRef(JD$Move.INSTANCE, Default);
  }

/*public:*/
  /// Interprets an option's string value as a boolean. The "true" string is
  /// interpreted as true and the "false" string is interpreted as false.
  ///
  /// If an option value is not provided, returns the given \p DefaultVal.
  /// @param [in] Name Name for option to retrieve.
  /// @param [in] DefaultVal Default value returned if no such option was
  /// specified.
  /// @param [in] C The optional checker parameter that can be used to restrict
  /// the search to the options of this particular checker (and its parents
  /// dependening on search mode).
  /// @param [in] SearchInParents If set to true and the searched option was not
  /// specified for the given checker the options for the parent packages will
  /// be searched as well. The inner packages take precedence over the outer
  /// ones.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getBooleanOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 125,
   FQN="clang::AnalyzerOptions::getBooleanOption", NM="_ZN5clang15AnalyzerOptions16getBooleanOptionEN4llvm9StringRefEbPKNS_4ento11CheckerBaseEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions16getBooleanOptionEN4llvm9StringRefEbPKNS_4ento11CheckerBaseEb")
  //</editor-fold>
  public boolean getBooleanOption(StringRef Name, boolean DefaultVal) {
    return getBooleanOption(Name, DefaultVal, 
                  (/*const*/ CheckerBaseImplementation /*P*/ )null, 
                  false);
  }
  public boolean getBooleanOption(StringRef Name, boolean DefaultVal, 
                  /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/) {
    return getBooleanOption(Name, DefaultVal, 
                  C, 
                  false);
  }
  public boolean getBooleanOption(StringRef Name, boolean DefaultVal, 
                  /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/, 
                  boolean SearchInParents/*= false*/) {
    // FIXME: We should emit a warning here if the value is something other than
    // "true", "false", or the empty string (meaning the default value),
    // but the AnalyzerOptions doesn't have access to a diagnostic engine.
    StringRef Default = __toString(DefaultVal);
    StringRef V = (C != null) ? getCheckerOption(C.getTagDescription(), new StringRef(Name), new StringRef(Default), 
        SearchInParents) : new StringRef(Config.insert(std.make_pair(Name, Default.str())).first.$arrow().second);
    return new StringSwitchBool(/*NO_COPY*/V).
        Case(/*KEEP_STR*/"true", true).
        Case(/*KEEP_STR*/"false", false).
        Default(DefaultVal);
  }

  
  /// Variant that accepts a Optional value to cache the result.
  ///
  /// @param [in,out] V Return value storage, returned if parameter contains
  /// an existing valid option, else it is used to store a return value
  /// @param [in] Name Name for option to retrieve.
  /// @param [in] DefaultVal Default value returned if no such option was
  /// specified.
  /// @param [in] C The optional checker parameter that can be used to restrict
  /// the search to the options of this particular checker (and its parents
  /// dependening on search mode).
  /// @param [in] SearchInParents If set to true and the searched option was not
  /// specified for the given checker the options for the parent packages will
  /// be searched as well. The inner packages take precedence over the outer
  /// ones.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getBooleanOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 142,
   FQN="clang::AnalyzerOptions::getBooleanOption", NM="_ZN5clang15AnalyzerOptions16getBooleanOptionERN4llvm8OptionalIbEENS1_9StringRefEbPKNS_4ento11CheckerBaseImplementationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions16getBooleanOptionERN4llvm8OptionalIbEENS1_9StringRefEbPKNS_4ento11CheckerBaseImplementationEb")
  //</editor-fold>
  public boolean getBooleanOption(OptionalBool/*&*/ V, StringRef Name, 
                  boolean DefaultVal) {
    return getBooleanOption(V, Name, 
                  DefaultVal, (/*const*/ CheckerBaseImplementation /*P*/ )null, 
                  false);
  }
  public boolean getBooleanOption(OptionalBool/*&*/ V, StringRef Name, 
                  boolean DefaultVal, /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/) {
    return getBooleanOption(V, Name, 
                  DefaultVal, C, 
                  false);
  }
  public boolean getBooleanOption(OptionalBool/*&*/ V, StringRef Name, 
                  boolean DefaultVal, /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/, 
                  boolean SearchInParents/*= false*/) {
    if (!V.hasValue()) {
      V.$assign(/*KEEP_BOOL*/getBooleanOption(new StringRef(Name), DefaultVal, C, SearchInParents));
    }
    return V.getValue();
  }

  
  /// Interprets an option's string value as an integer value.
  ///
  /// If an option value is not provided, returns the given \p DefaultVal.
  /// @param [in] Name Name for option to retrieve.
  /// @param [in] DefaultVal Default value returned if no such option was
  /// specified.
  /// @param [in] C The optional checker parameter that can be used to restrict
  /// the search to the options of this particular checker (and its parents
  /// dependening on search mode).
  /// @param [in] SearchInParents If set to true and the searched option was not
  /// specified for the given checker the options for the parent packages will
  /// be searched as well. The inner packages take precedence over the outer
  /// ones.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getOptionAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 230,
   FQN="clang::AnalyzerOptions::getOptionAsInteger", NM="_ZN5clang15AnalyzerOptions18getOptionAsIntegerEN4llvm9StringRefEiPKNS_4ento11CheckerBaseImplementationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions18getOptionAsIntegerEN4llvm9StringRefEiPKNS_4ento11CheckerBaseImplementationEb")
  //</editor-fold>
  public int getOptionAsInteger(StringRef Name, int DefaultVal) {
    return getOptionAsInteger(Name, DefaultVal, 
                    (/*const*/ CheckerBaseImplementation /*P*/ )null, 
                    false);
  }
  public int getOptionAsInteger(StringRef Name, int DefaultVal, 
                    /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/) {
    return getOptionAsInteger(Name, DefaultVal, 
                    C, 
                    false);
  }
  public int getOptionAsInteger(StringRef Name, int DefaultVal, 
                    /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/, 
                    boolean SearchInParents/*= false*/) {
    raw_svector_ostream OS = null;
    try {
      SmallString/*10*/ StrBuf/*J*/= new SmallString/*10*/(10);
      OS/*J*/= new raw_svector_ostream(StrBuf);
      OS.$out_int(DefaultVal);
      
      StringRef V = (C != null) ? getCheckerOption(C.getTagDescription(), new StringRef(Name), OS.str(), 
          SearchInParents) : new StringRef(Config.insert(std.make_pair(Name, OS.str().str())).
              first.$arrow().second);
      
      int$ref Res = create_int$ref(DefaultVal);
      boolean b = V.getAsInteger$Signed(10, Res);
      assert (!b) : "analyzer-config option should be numeric";
      /*(void)b;*/
      return Res.$deref();
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// Query an option's string value.
  ///
  /// If an option value is not provided, returns the given \p DefaultVal.
  /// @param [in] Name Name for option to retrieve.
  /// @param [in] DefaultVal Default value returned if no such option was
  /// specified.
  /// @param [in] C The optional checker parameter that can be used to restrict
  /// the search to the options of this particular checker (and its parents
  /// dependening on search mode).
  /// @param [in] SearchInParents If set to true and the searched option was not
  /// specified for the given checker the options for the parent packages will
  /// be searched as well. The inner packages take precedence over the outer
  /// ones.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getOptionAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 249,
   FQN="clang::AnalyzerOptions::getOptionAsString", NM="_ZN5clang15AnalyzerOptions17getOptionAsStringEN4llvm9StringRefES2_PKNS_4ento11CheckerBaseImplementationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions17getOptionAsStringEN4llvm9StringRefES2_PKNS_4ento11CheckerBaseImplementationEb")
  //</editor-fold>
  public StringRef getOptionAsString(StringRef Name, 
                   StringRef DefaultVal) {
    return getOptionAsString(Name, 
                   DefaultVal, 
                   (/*const*/ CheckerBaseImplementation /*P*/ )null, 
                   false);
  }
  public StringRef getOptionAsString(StringRef Name, 
                   StringRef DefaultVal, 
                   /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/) {
    return getOptionAsString(Name, 
                   DefaultVal, 
                   C, 
                   false);
  }
  public StringRef getOptionAsString(StringRef Name, 
                   StringRef DefaultVal, 
                   /*const*/ CheckerBaseImplementation /*P*/ C/*= null*/, 
                   boolean SearchInParents/*= false*/) {
    return (C != null) ? getCheckerOption(C.getTagDescription(), new StringRef(Name), new StringRef(DefaultVal), 
        SearchInParents) : new StringRef(Config.insert(new std.pair<StringRef, std.string>(std.make_pair(Name, DefaultVal.str()))).first.$arrow().second);
  }

  
  /// \brief Retrieves and sets the UserMode. This is a high-level option,
  /// which is used to set other low-level options. It is not accessible
  /// outside of AnalyzerOptions.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getUserMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 24,
   FQN="clang::AnalyzerOptions::getUserMode", NM="_ZN5clang15AnalyzerOptions11getUserModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions11getUserModeEv")
  //</editor-fold>
  public AnalyzerOptions.UserModeKind getUserMode() {
    if (UserMode == UserModeKind.UMK_NotSet) {
      StringRef ModeStr = new StringRef(Config.insert(new std.pair<StringRef, std.string>(std.make_pair(new StringRef("mode"), new std.string("deep")))).first.$arrow().second);
      UserMode = new StringSwitch<UserModeKind>(/*NO_COPY*/ModeStr).
          Case(/*KEEP_STR*/"shallow", UserModeKind.UMK_Shallow).
          Case(/*KEEP_STR*/"deep", UserModeKind.UMK_Deep).
          Default(UserModeKind.UMK_NotSet);
      assert (UserMode != UserModeKind.UMK_NotSet) : "User mode is invalid.";
    }
    return UserMode;
  }

  
  /// \brief Returns the inter-procedural analysis mode.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getIPAMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 37,
   FQN="clang::AnalyzerOptions::getIPAMode", NM="_ZN5clang15AnalyzerOptions10getIPAModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions10getIPAModeEv")
  //</editor-fold>
  public IPAKind getIPAMode() {
    if (IPAMode == IPAKind.IPAK_NotSet) {
      
      // Use the User Mode to set the default IPA value.
      // Note, we have to add the string to the Config map for the ConfigDumper
      // checker to function properly.
      /*const*/char$ptr/*char P*/ DefaultIPA = null;
      UserModeKind HighLevelMode = getUserMode();
      if (HighLevelMode == UserModeKind.UMK_Shallow) {
        DefaultIPA = $tryClone($("inlining"));
      } else if (HighLevelMode == UserModeKind.UMK_Deep) {
        DefaultIPA = $tryClone($("dynamic-bifurcate"));
      }
      assert (DefaultIPA != null);
      
      // Lookup the ipa configuration option, use the default from User Mode.
      StringRef ModeStr = new StringRef(Config.insert(std.make_pair_T_T(new StringRef("ipa"), new std.string(DefaultIPA))).first.$arrow().second);
      IPAKind IPAConfig = new StringSwitch<IPAKind>(/*NO_COPY*/ModeStr).
          Case(/*KEEP_STR*/"none", IPAKind.IPAK_None).
          Case(/*KEEP_STR*/"basic-inlining", IPAKind.IPAK_BasicInlining).
          Case(/*KEEP_STR*/"inlining", IPAKind.IPAK_Inlining).
          Case(/*KEEP_STR*/"dynamic", IPAKind.IPAK_DynamicDispatch).
          Case(/*KEEP_STR*/"dynamic-bifurcate", IPAKind.IPAK_DynamicDispatchBifurcate).
          Default(IPAKind.IPAK_NotSet);
      assert (IPAConfig != IPAKind.IPAK_NotSet) : "IPA Mode is invalid.";
      
      // Set the member variable.
      IPAMode = IPAConfig;
    }
    
    return IPAMode;
  }

  
  /// Returns the option controlling which C++ member functions will be
  /// considered for inlining.
  ///
  /// This is controlled by the 'c++-inlining' config option.
  ///
  /// \sa CXXMemberInliningMode
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineCXXMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 72,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 70,
   FQN="clang::AnalyzerOptions::mayInlineCXXMemberFunction", NM="_ZN5clang15AnalyzerOptions26mayInlineCXXMemberFunctionENS_23CXXInlineableMemberKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions26mayInlineCXXMemberFunctionENS_23CXXInlineableMemberKindE")
  //</editor-fold>
  public boolean mayInlineCXXMemberFunction(CXXInlineableMemberKind K) {
    if (getIPAMode().getValue() < IPAKind.IPAK_Inlining.getValue()) {
      return false;
    }
    if (!(CXXMemberInliningMode.getValue() != 0)) {
      final/*static*/ /*const*/char$ptr/*char P*/ ModeKey = mayInlineCXXMemberFunction$$.ModeKey;
      
      StringRef ModeStr = new StringRef(Config.insert(std.make_pair_Ptr_T(new StringRef(ModeKey), new std.string("destructors"))).first.$arrow().second);
      
      CXXInlineableMemberKind /*&*/ MutableMode = ((/*const_cast*/CXXInlineableMemberKind /*&*/ )(CXXMemberInliningMode));
      
      MutableMode = new StringSwitch<CXXInlineableMemberKind>(/*NO_COPY*/ModeStr).
          Case(/*KEEP_STR*/"constructors", CXXInlineableMemberKind.CIMK_Constructors).
          Case(/*KEEP_STR*/"destructors", CXXInlineableMemberKind.CIMK_Destructors).
          Case(/*KEEP_STR*/"none", CXXInlineableMemberKind.CIMK_None).
          Case(/*KEEP_STR*/"methods", CXXInlineableMemberKind.CIMK_MemberFunctions).
          Default(CXXInlineableMemberKind.Uninitialized);
      if (!(MutableMode.getValue() != 0)) {
        // FIXME: We should emit a warning here about an unknown inlining kind,
        // but the AnalyzerOptions doesn't have access to a diagnostic engine.
        MutableMode = CXXInlineableMemberKind.CIMK_None;
      }
    }
    
    return CXXMemberInliningMode.getValue() >= K.getValue();
  }
  private static final class mayInlineCXXMemberFunction$$ {
    static final/*static*/ /*const*/char$ptr/*char P*/ ModeKey = $("c++-inlining");
  }

  
  /// Returns true if ObjectiveC inlining is enabled, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineObjCMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 187,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 159,
   FQN="clang::AnalyzerOptions::mayInlineObjCMethod", NM="_ZN5clang15AnalyzerOptions19mayInlineObjCMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions19mayInlineObjCMethodEv")
  //</editor-fold>
  public boolean mayInlineObjCMethod() {
    return getBooleanOption(ObjCInliningMode, 
        new StringRef(/*KEEP_STR*/"objc-inlining"), 
        /* Default = */ true);
  }

  
  /// Returns whether or not the destructors for C++ temporary objects should
  /// be included in the CFG.
  ///
  /// This is controlled by the 'cfg-temporary-dtors' config option, which
  /// accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::includeTemporaryDtorsInCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 150,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 122,
   FQN="clang::AnalyzerOptions::includeTemporaryDtorsInCFG", NM="_ZN5clang15AnalyzerOptions26includeTemporaryDtorsInCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions26includeTemporaryDtorsInCFGEv")
  //</editor-fold>
  public boolean includeTemporaryDtorsInCFG() {
    return getBooleanOption(IncludeTemporaryDtorsInCFG, 
        new StringRef(/*KEEP_STR*/"cfg-temporary-dtors"), 
        /* Default = */ false);
  }

  
  /// Returns whether or not C++ standard library functions may be considered
  /// for inlining.
  ///
  /// This is controlled by the 'c++-stdlib-inlining' config option, which
  /// accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineCXXStandardLibrary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 128,
   FQN="clang::AnalyzerOptions::mayInlineCXXStandardLibrary", NM="_ZN5clang15AnalyzerOptions27mayInlineCXXStandardLibraryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions27mayInlineCXXStandardLibraryEv")
  //</editor-fold>
  public boolean mayInlineCXXStandardLibrary() {
    return getBooleanOption(InlineCXXStandardLibrary, 
        new StringRef(/*KEEP_STR*/"c++-stdlib-inlining"), 
        /*Default=*/ true);
  }

  
  /// Returns whether or not templated functions may be considered for inlining.
  ///
  /// This is controlled by the 'c++-template-inlining' config option, which
  /// accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineTemplateFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 134,
   FQN="clang::AnalyzerOptions::mayInlineTemplateFunctions", NM="_ZN5clang15AnalyzerOptions26mayInlineTemplateFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions26mayInlineTemplateFunctionsEv")
  //</editor-fold>
  public boolean mayInlineTemplateFunctions() {
    return getBooleanOption(InlineTemplateFunctions, 
        new StringRef(/*KEEP_STR*/"c++-template-inlining"), 
        /*Default=*/ true);
  }

  
  /// Returns whether or not allocator call may be considered for inlining.
  ///
  /// This is controlled by the 'c++-allocator-inlining' config option, which
  /// accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineCXXAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 140,
   FQN="clang::AnalyzerOptions::mayInlineCXXAllocator", NM="_ZN5clang15AnalyzerOptions21mayInlineCXXAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions21mayInlineCXXAllocatorEv")
  //</editor-fold>
  public boolean mayInlineCXXAllocator() {
    return getBooleanOption(InlineCXXAllocator, 
        new StringRef(/*KEEP_STR*/"c++-allocator-inlining"), 
        /*Default=*/ false);
  }

  
  /// Returns whether or not methods of C++ container objects may be considered
  /// for inlining.
  ///
  /// This is controlled by the 'c++-container-inlining' config option, which
  /// accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineCXXContainerMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 174,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 146,
   FQN="clang::AnalyzerOptions::mayInlineCXXContainerMethods", NM="_ZN5clang15AnalyzerOptions28mayInlineCXXContainerMethodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions28mayInlineCXXContainerMethodsEv")
  //</editor-fold>
  public boolean mayInlineCXXContainerMethods() {
    return getBooleanOption(InlineCXXContainerMethods, 
        new StringRef(/*KEEP_STR*/"c++-container-inlining"), 
        /*Default=*/ false);
  }

  
  /// Returns whether or not the destructor of C++ 'shared_ptr' may be
  /// considered for inlining.
  ///
  /// This covers std::shared_ptr, std::tr1::shared_ptr, and boost::shared_ptr,
  /// and indeed any destructor named "~shared_ptr".
  ///
  /// This is controlled by the 'c++-shared_ptr-inlining' config option, which
  /// accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::mayInlineCXXSharedPtrDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 152,
   FQN="clang::AnalyzerOptions::mayInlineCXXSharedPtrDtor", NM="_ZN5clang15AnalyzerOptions25mayInlineCXXSharedPtrDtorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions25mayInlineCXXSharedPtrDtorEv")
  //</editor-fold>
  public boolean mayInlineCXXSharedPtrDtor() {
    return getBooleanOption(InlineCXXSharedPtrDtor, 
        new StringRef(/*KEEP_STR*/"c++-shared_ptr-inlining"), 
        /*Default=*/ false);
  }

  
  /// Returns whether or not paths that go through null returns should be
  /// suppressed.
  ///
  /// This is a heuristic for avoiding bug reports with paths that go through
  /// inlined functions that are more defensive than their callers.
  ///
  /// This is controlled by the 'suppress-null-return-paths' config option,
  /// which accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldSuppressNullReturnPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 165,
   FQN="clang::AnalyzerOptions::shouldSuppressNullReturnPaths", NM="_ZN5clang15AnalyzerOptions29shouldSuppressNullReturnPathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions29shouldSuppressNullReturnPathsEv")
  //</editor-fold>
  public boolean shouldSuppressNullReturnPaths() {
    return getBooleanOption(SuppressNullReturnPaths, 
        new StringRef(/*KEEP_STR*/"suppress-null-return-paths"), 
        /* Default = */ true);
  }

  
  /// Returns whether a bug report should \em not be suppressed if its path
  /// includes a call with a null argument, even if that call has a null return.
  ///
  /// This option has no effect when #shouldSuppressNullReturnPaths() is false.
  ///
  /// This is a counter-heuristic to avoid false negatives.
  ///
  /// This is controlled by the 'avoid-suppressing-null-argument-paths' config
  /// option, which accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldAvoidSuppressingNullArgumentPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 171,
   FQN="clang::AnalyzerOptions::shouldAvoidSuppressingNullArgumentPaths", NM="_ZN5clang15AnalyzerOptions39shouldAvoidSuppressingNullArgumentPathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions39shouldAvoidSuppressingNullArgumentPathsEv")
  //</editor-fold>
  public boolean shouldAvoidSuppressingNullArgumentPaths() {
    return getBooleanOption(AvoidSuppressingNullArgumentPaths, 
        new StringRef(/*KEEP_STR*/"avoid-suppressing-null-argument-paths"), 
        /* Default = */ false);
  }

  
  /// Returns whether or not diagnostics containing inlined defensive NULL
  /// checks should be suppressed.
  ///
  /// This is controlled by the 'suppress-inlined-defensive-checks' config
  /// option, which accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldSuppressInlinedDefensiveChecks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 205,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 177,
   FQN="clang::AnalyzerOptions::shouldSuppressInlinedDefensiveChecks", NM="_ZN5clang15AnalyzerOptions36shouldSuppressInlinedDefensiveChecksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions36shouldSuppressInlinedDefensiveChecksEv")
  //</editor-fold>
  public boolean shouldSuppressInlinedDefensiveChecks() {
    return getBooleanOption(SuppressInlinedDefensiveChecks, 
        new StringRef(/*KEEP_STR*/"suppress-inlined-defensive-checks"), 
        /* Default = */ true);
  }

  
  /// Returns whether or not diagnostics reported within the C++ standard
  /// library should be suppressed.
  ///
  /// This is controlled by the 'suppress-c++-stdlib' config option,
  /// which accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldSuppressFromCXXStandardLibrary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 211,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 183,
   FQN="clang::AnalyzerOptions::shouldSuppressFromCXXStandardLibrary", NM="_ZN5clang15AnalyzerOptions36shouldSuppressFromCXXStandardLibraryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions36shouldSuppressFromCXXStandardLibraryEv")
  //</editor-fold>
  public boolean shouldSuppressFromCXXStandardLibrary() {
    return getBooleanOption(SuppressFromCXXStandardLibrary, 
        new StringRef(/*KEEP_STR*/"suppress-c++-stdlib"), 
        /* Default = */ false);
  }

  
  /// Returns whether or not the diagnostic report should be always reported
  /// in the main source file and not the headers.
  ///
  /// This is controlled by the 'report-in-main-source-file' config option,
  /// which accepts the values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldReportIssuesInMainSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 217,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 189,
   FQN="clang::AnalyzerOptions::shouldReportIssuesInMainSourceFile", NM="_ZN5clang15AnalyzerOptions34shouldReportIssuesInMainSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions34shouldReportIssuesInMainSourceFileEv")
  //</editor-fold>
  public boolean shouldReportIssuesInMainSourceFile() {
    return getBooleanOption(ReportIssuesInMainSourceFile, 
        new StringRef(/*KEEP_STR*/"report-in-main-source-file"), 
        /* Default = */ false);
  }

  
  /// Returns whether or not the report filename should be random or not.
  ///
  /// This is controlled by the 'stable-report-filename' config option,
  /// which accepts the values "true" and "false". Default = false
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldWriteStableReportFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 224,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 196,
   FQN="clang::AnalyzerOptions::shouldWriteStableReportFilename", NM="_ZN5clang15AnalyzerOptions31shouldWriteStableReportFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions31shouldWriteStableReportFilenameEv")
  //</editor-fold>
  public boolean shouldWriteStableReportFilename() {
    return getBooleanOption(StableReportFilename, 
        new StringRef(/*KEEP_STR*/"stable-report-filename"), 
        /* Default = */ false);
  }

  
  /// Returns whether irrelevant parts of a bug report path should be pruned
  /// out of the final output.
  ///
  /// This is controlled by the 'prune-paths' config option, which accepts the
  /// values "true" and "false".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldPrunePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 328,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 277,
   FQN="clang::AnalyzerOptions::shouldPrunePaths", NM="_ZN5clang15AnalyzerOptions16shouldPrunePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions16shouldPrunePathsEv")
  //</editor-fold>
  public boolean shouldPrunePaths() {
    return getBooleanOption(new StringRef(/*KEEP_STR*/"prune-paths"), true);
  }

  
  /// Returns true if 'static' initializers should be in conditional logic
  /// in the CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldConditionalizeStaticInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 332,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 281,
   FQN="clang::AnalyzerOptions::shouldConditionalizeStaticInitializers", NM="_ZN5clang15AnalyzerOptions38shouldConditionalizeStaticInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions38shouldConditionalizeStaticInitializersEv")
  //</editor-fold>
  public boolean shouldConditionalizeStaticInitializers() {
    return getBooleanOption(new StringRef(/*KEEP_STR*/"cfg-conditional-static-initializers"), true);
  }

  
  // Returns the size of the functions (in basic blocks), which should be
  // considered to be small enough to always inline.
  //
  // This is controlled by "ipa-always-inline-size" analyzer-config option.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getAlwaysInlineSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 259,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 215,
   FQN="clang::AnalyzerOptions::getAlwaysInlineSize", NM="_ZN5clang15AnalyzerOptions19getAlwaysInlineSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions19getAlwaysInlineSizeEv")
  //</editor-fold>
  public /*uint*/int getAlwaysInlineSize() {
    if (!AlwaysInlineSize.hasValue()) {
      AlwaysInlineSize.$assign(getOptionAsInteger(new StringRef(/*KEEP_STR*/"ipa-always-inline-size"), 3));
    }
    return AlwaysInlineSize.getValue();
  }

  
  // Returns the bound on the number of basic blocks in an inlined function
  // (50 by default).
  //
  // This is controlled by "-analyzer-config max-inlinable-size" option.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getMaxInlinableSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 265,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 221,
   FQN="clang::AnalyzerOptions::getMaxInlinableSize", NM="_ZN5clang15AnalyzerOptions19getMaxInlinableSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions19getMaxInlinableSizeEv")
  //</editor-fold>
  public /*uint*/int getMaxInlinableSize() {
    if (!MaxInlinableSize.hasValue()) {
      
      int DefaultValue = 0;
      UserModeKind HighLevelMode = getUserMode();
      switch (HighLevelMode) {
       default:
        throw new llvm_unreachable("Invalid mode.");
       case UMK_Shallow:
        DefaultValue = 4;
        break;
       case UMK_Deep:
        DefaultValue = 50;
        break;
      }
      
      MaxInlinableSize.$assign(getOptionAsInteger(new StringRef(/*KEEP_STR*/"max-inlinable-size"), DefaultValue));
    }
    return MaxInlinableSize.getValue();
  }

  
  /// Returns true if the analyzer engine should synthesize fake bodies
  /// for well-known functions.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldSynthesizeBodies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 273,
   FQN="clang::AnalyzerOptions::shouldSynthesizeBodies", NM="_ZN5clang15AnalyzerOptions22shouldSynthesizeBodiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions22shouldSynthesizeBodiesEv")
  //</editor-fold>
  public boolean shouldSynthesizeBodies() {
    return getBooleanOption(new StringRef(/*KEEP_STR*/"faux-bodies"), true);
  }

  
  /// Returns how often nodes in the ExplodedGraph should be recycled to save
  /// memory.
  ///
  /// This is controlled by the 'graph-trim-interval' config option. To disable
  /// node reclamation, set the option to "0".
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getGraphTrimInterval">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 286,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 242,
   FQN="clang::AnalyzerOptions::getGraphTrimInterval", NM="_ZN5clang15AnalyzerOptions20getGraphTrimIntervalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions20getGraphTrimIntervalEv")
  //</editor-fold>
  public /*uint*/int getGraphTrimInterval() {
    if (!GraphTrimInterval.hasValue()) {
      GraphTrimInterval.$assign(getOptionAsInteger(new StringRef(/*KEEP_STR*/"graph-trim-interval"), 1000));
    }
    return GraphTrimInterval.getValue();
  }

  
  /// Returns the maximum times a large function could be inlined.
  ///
  /// This is controlled by the 'max-times-inline-large' config option.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getMaxTimesInlineLarge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 292,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 248,
   FQN="clang::AnalyzerOptions::getMaxTimesInlineLarge", NM="_ZN5clang15AnalyzerOptions22getMaxTimesInlineLargeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions22getMaxTimesInlineLargeEv")
  //</editor-fold>
  public /*uint*/int getMaxTimesInlineLarge() {
    if (!MaxTimesInlineLarge.hasValue()) {
      MaxTimesInlineLarge.$assign(getOptionAsInteger(new StringRef(/*KEEP_STR*/"max-times-inline-large"), 32));
    }
    return MaxTimesInlineLarge.getValue();
  }

  
  /// Returns the number of basic blocks a function needs to have to be
  /// considered large for the 'max-times-inline-large' config option.
  ///
  /// This is controlled by the 'min-cfg-size-treat-functions-as-large' config
  /// option.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getMinCFGSizeTreatFunctionsAsLarge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 298,
   FQN="clang::AnalyzerOptions::getMinCFGSizeTreatFunctionsAsLarge", NM="_ZN5clang15AnalyzerOptions34getMinCFGSizeTreatFunctionsAsLargeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions34getMinCFGSizeTreatFunctionsAsLargeEv")
  //</editor-fold>
  public /*uint*/int getMinCFGSizeTreatFunctionsAsLarge() {
    if (!MinCFGSizeTreatFunctionsAsLarge.hasValue()) {
      MinCFGSizeTreatFunctionsAsLarge.$assign(getOptionAsInteger(new StringRef(/*KEEP_STR*/"min-cfg-size-treat-functions-as-large"), 14));
    }
    return MinCFGSizeTreatFunctionsAsLarge.getValue();
  }

  
  /// Returns the maximum number of nodes the analyzer can generate while
  /// exploring a top level function (for each exploded graph).
  /// 150000 is default; 0 means no limit.
  ///
  /// This is controlled by the 'max-nodes' config option.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::getMaxNodesPerTopLevelFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", old_line = 254,
   FQN="clang::AnalyzerOptions::getMaxNodesPerTopLevelFunction", NM="_ZN5clang15AnalyzerOptions30getMaxNodesPerTopLevelFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions30getMaxNodesPerTopLevelFunctionEv")
  //</editor-fold>
  public /*uint*/int getMaxNodesPerTopLevelFunction() {
    if (!MaxNodesPerTopLevelFunction.hasValue()) {
      int DefaultValue = 0;
      UserModeKind HighLevelMode = getUserMode();
      switch (HighLevelMode) {
       default:
        throw new llvm_unreachable("Invalid mode.");
       case UMK_Shallow:
        DefaultValue = 75000;
        break;
       case UMK_Deep:
        DefaultValue = 150000;
        break;
      }
      MaxNodesPerTopLevelFunction.$assign(getOptionAsInteger(new StringRef(/*KEEP_STR*/"max-nodes"), DefaultValue));
    }
    return MaxNodesPerTopLevelFunction.getValue();
  }

  
  /// Returns true if lambdas should be inlined. Otherwise a sink node will be
  /// generated each time a LambdaExpr is visited.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldInlineLambdas">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 336,
   FQN="clang::AnalyzerOptions::shouldInlineLambdas", NM="_ZN5clang15AnalyzerOptions19shouldInlineLambdasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions19shouldInlineLambdasEv")
  //</editor-fold>
  public boolean shouldInlineLambdas() {
    if (!InlineLambdas.hasValue()) {
      InlineLambdas.$assign(/*KEEP_BOOL*/getBooleanOption(new StringRef(/*KEEP_STR*/"inline-lambdas"), /*Default=*/ true));
    }
    return InlineLambdas.getValue();
  }

  
  /// Returns true if the analysis should try to widen loops.
  /// This is controlled by the 'widen-loops' config option.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::shouldWidenLoops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp", line = 342,
   FQN="clang::AnalyzerOptions::shouldWidenLoops", NM="_ZN5clang15AnalyzerOptions16shouldWidenLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptions16shouldWidenLoopsEv")
  //</editor-fold>
  public boolean shouldWidenLoops() {
    if (!WidenLoops.hasValue()) {
      WidenLoops.$assign(/*KEEP_BOOL*/getBooleanOption(new StringRef(/*KEEP_STR*/"widen-loops"), /*Default=*/ false));
    }
    return WidenLoops.getValue();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::AnalyzerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", line = 537,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", old_line = 425,
   FQN="clang::AnalyzerOptions::AnalyzerOptions", NM="_ZN5clang15AnalyzerOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptionsC1Ev")
  //</editor-fold>
  public AnalyzerOptions() {
    /* : RefCountedBase<AnalyzerOptions>(), CheckersControlList(), Config(), AnalysisStoreOpt(RegionStoreModel), AnalysisConstraintsOpt(RangeConstraintsModel), AnalysisDiagOpt(PD_HTML), AnalysisPurgeOpt(PurgeStmt), AnalyzeSpecificFunction(), DisableAllChecks(0), ShowCheckerHelp(0), AnalyzeAll(0), AnalyzerDisplayProgress(0), AnalyzeNestedBlocks(0), eagerlyAssumeBinOpBifurcation(0), TrimGraph(0), visualizeExplodedGraphWithGraphViz(0), visualizeExplodedGraphWithUbiGraph(0), UnoptimizedCFG(0), PrintStats(0), NoRetryExhausted(0), InlineMaxStackDepth(5), InliningMode(NoRedundancy), UserMode(UMK_NotSet), IPAMode(IPAK_NotSet), CXXMemberInliningMode(implicit CXXInlineableMemberKind()), IncludeTemporaryDtorsInCFG(), InlineCXXStandardLibrary(), InlineTemplateFunctions(), InlineCXXAllocator(), InlineCXXContainerMethods(), InlineCXXSharedPtrDtor(), ObjCInliningMode(), AlwaysInlineSize(), SuppressNullReturnPaths(), MaxInlinableSize(), AvoidSuppressingNullArgumentPaths(), SuppressInlinedDefensiveChecks(), SuppressFromCXXStandardLibrary(), ReportIssuesInMainSourceFile(), StableReportFilename(), GraphTrimInterval(), MaxTimesInlineLarge(), MinCFGSizeTreatFunctionsAsLarge(), MaxNodesPerTopLevelFunction(), InlineLambdas(), WidenLoops()*/ 
    //START JInit
    super();
    this.CheckersControlList = new std.vector<std.pairTypeBool<std.string>>(new std.pairTypeBool<std.string>(std.string.EMPTY, false));
    this.Config = new StringMap<std.string>(std.string.EMPTY);
    this.AnalysisStoreOpt = AnalysisStores.RegionStoreModel;
    this.AnalysisConstraintsOpt = AnalysisConstraints.RangeConstraintsModel;
    this.AnalysisDiagOpt = AnalysisDiagClients.PD_HTML;
    this.AnalysisPurgeOpt = AnalysisPurgeMode.PurgeStmt;
    this.AnalyzeSpecificFunction = new std.string();
    this.DisableAllChecks = false;
    this.ShowCheckerHelp = false;
    this.AnalyzeAll = false;
    this.AnalyzerDisplayProgress = false;
    this.AnalyzeNestedBlocks = false;
    this.eagerlyAssumeBinOpBifurcation = false;
    this.TrimGraph = false;
    this.visualizeExplodedGraphWithGraphViz = false;
    this.visualizeExplodedGraphWithUbiGraph = false;
    this.UnoptimizedCFG = false;
    this.PrintStats = false;
    this.NoRetryExhausted = false;
    this.InlineMaxStackDepth = 5;
    this.InliningMode = AnalysisInliningMode.NoRedundancy;
    this.UserMode = UserModeKind.UMK_NotSet;
    this.IPAMode = IPAKind.IPAK_NotSet;
    this.CXXMemberInliningMode = /*implicit-init*/CXXInlineableMemberKind.valueOf(/*zero-init*/0);
    this.IncludeTemporaryDtorsInCFG = new OptionalBool();
    this.InlineCXXStandardLibrary = new OptionalBool();
    this.InlineTemplateFunctions = new OptionalBool();
    this.InlineCXXAllocator = new OptionalBool();
    this.InlineCXXContainerMethods = new OptionalBool();
    this.InlineCXXSharedPtrDtor = new OptionalBool();
    this.ObjCInliningMode = new OptionalBool();
    this.AlwaysInlineSize = new OptionalUInt();
    this.SuppressNullReturnPaths = new OptionalBool();
    this.MaxInlinableSize = new OptionalUInt();
    this.AvoidSuppressingNullArgumentPaths = new OptionalBool();
    this.SuppressInlinedDefensiveChecks = new OptionalBool();
    this.SuppressFromCXXStandardLibrary = new OptionalBool();
    this.ReportIssuesInMainSourceFile = new OptionalBool();
    this.StableReportFilename = new OptionalBool();
    this.GraphTrimInterval = new OptionalUInt();
    this.MaxTimesInlineLarge = new OptionalUInt();
    this.MinCFGSizeTreatFunctionsAsLarge = new OptionalUInt();
    this.MaxNodesPerTopLevelFunction = new OptionalUInt();
    this.InlineLambdas = new OptionalBool();
    this.WidenLoops = new OptionalBool();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalyzerOptions::~AnalyzerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/AnalyzerOptions.h", old_line = 120,
   FQN="clang::AnalyzerOptions::~AnalyzerOptions", NM="_ZN5clang15AnalyzerOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15AnalyzerOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    WidenLoops.$destroy();
    InlineLambdas.$destroy();
    MaxNodesPerTopLevelFunction.$destroy();
    MinCFGSizeTreatFunctionsAsLarge.$destroy();
    MaxTimesInlineLarge.$destroy();
    GraphTrimInterval.$destroy();
    StableReportFilename.$destroy();
    ReportIssuesInMainSourceFile.$destroy();
    SuppressFromCXXStandardLibrary.$destroy();
    SuppressInlinedDefensiveChecks.$destroy();
    AvoidSuppressingNullArgumentPaths.$destroy();
    MaxInlinableSize.$destroy();
    SuppressNullReturnPaths.$destroy();
    AlwaysInlineSize.$destroy();
    ObjCInliningMode.$destroy();
    InlineCXXSharedPtrDtor.$destroy();
    InlineCXXContainerMethods.$destroy();
    InlineCXXAllocator.$destroy();
    InlineTemplateFunctions.$destroy();
    InlineCXXStandardLibrary.$destroy();
    IncludeTemporaryDtorsInCFG.$destroy();
    AnalyzeSpecificFunction.$destroy();
    Config.$destroy();
    CheckersControlList.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "CheckersControlList=" + CheckersControlList // NOI18N
              + ", Config=" + Config // NOI18N
              + ", AnalysisStoreOpt=" + AnalysisStoreOpt // NOI18N
              + ", AnalysisConstraintsOpt=" + AnalysisConstraintsOpt // NOI18N
              + ", AnalysisDiagOpt=" + AnalysisDiagOpt // NOI18N
              + ", AnalysisPurgeOpt=" + AnalysisPurgeOpt // NOI18N
              + ", AnalyzeSpecificFunction=" + AnalyzeSpecificFunction // NOI18N
              + ", maxBlockVisitOnPath=" + maxBlockVisitOnPath // NOI18N
              + ", DisableAllChecks=" + DisableAllChecks // NOI18N
              + ", ShowCheckerHelp=" + ShowCheckerHelp // NOI18N
              + ", AnalyzeAll=" + AnalyzeAll // NOI18N
              + ", AnalyzerDisplayProgress=" + AnalyzerDisplayProgress // NOI18N
              + ", AnalyzeNestedBlocks=" + AnalyzeNestedBlocks // NOI18N
              + ", eagerlyAssumeBinOpBifurcation=" + eagerlyAssumeBinOpBifurcation // NOI18N
              + ", TrimGraph=" + TrimGraph // NOI18N
              + ", visualizeExplodedGraphWithGraphViz=" + visualizeExplodedGraphWithGraphViz // NOI18N
              + ", visualizeExplodedGraphWithUbiGraph=" + visualizeExplodedGraphWithUbiGraph // NOI18N
              + ", UnoptimizedCFG=" + UnoptimizedCFG // NOI18N
              + ", PrintStats=" + PrintStats // NOI18N
              + ", NoRetryExhausted=" + NoRetryExhausted // NOI18N
              + ", InlineMaxStackDepth=" + InlineMaxStackDepth // NOI18N
              + ", InliningMode=" + InliningMode // NOI18N
              + ", UserMode=" + UserMode // NOI18N
              + ", IPAMode=" + IPAMode // NOI18N
              + ", CXXMemberInliningMode=" + CXXMemberInliningMode // NOI18N
              + ", IncludeTemporaryDtorsInCFG=" + IncludeTemporaryDtorsInCFG // NOI18N
              + ", InlineCXXStandardLibrary=" + InlineCXXStandardLibrary // NOI18N
              + ", InlineTemplateFunctions=" + InlineTemplateFunctions // NOI18N
              + ", InlineCXXAllocator=" + InlineCXXAllocator // NOI18N
              + ", InlineCXXContainerMethods=" + InlineCXXContainerMethods // NOI18N
              + ", InlineCXXSharedPtrDtor=" + InlineCXXSharedPtrDtor // NOI18N
              + ", ObjCInliningMode=" + ObjCInliningMode // NOI18N
              + ", AlwaysInlineSize=" + AlwaysInlineSize // NOI18N
              + ", SuppressNullReturnPaths=" + SuppressNullReturnPaths // NOI18N
              + ", MaxInlinableSize=" + MaxInlinableSize // NOI18N
              + ", AvoidSuppressingNullArgumentPaths=" + AvoidSuppressingNullArgumentPaths // NOI18N
              + ", SuppressInlinedDefensiveChecks=" + SuppressInlinedDefensiveChecks // NOI18N
              + ", SuppressFromCXXStandardLibrary=" + SuppressFromCXXStandardLibrary // NOI18N
              + ", ReportIssuesInMainSourceFile=" + ReportIssuesInMainSourceFile // NOI18N
              + ", StableReportFilename=" + StableReportFilename // NOI18N
              + ", GraphTrimInterval=" + GraphTrimInterval // NOI18N
              + ", MaxTimesInlineLarge=" + MaxTimesInlineLarge // NOI18N
              + ", MinCFGSizeTreatFunctionsAsLarge=" + MinCFGSizeTreatFunctionsAsLarge // NOI18N
              + ", MaxNodesPerTopLevelFunction=" + MaxNodesPerTopLevelFunction // NOI18N
              + ", InlineLambdas=" + InlineLambdas // NOI18N
              + ", WidenLoops=" + WidenLoops // NOI18N
              + super.toString(); // NOI18N
  }
}
