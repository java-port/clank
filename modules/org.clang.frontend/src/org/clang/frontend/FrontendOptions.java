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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.frontend.frontend.ActionKind;


/// FrontendOptions - Options for controlling the behavior of the frontend.
//<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 122,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 120,
 FQN="clang::FrontendOptions", NM="_ZN5clang15FrontendOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15FrontendOptionsE")
//</editor-fold>
public class FrontendOptions implements Destructors.ClassWithDestructor {
/*public:*/
  public /*JBIT unsigned int*/ boolean DisableFree /*: 1*/; ///< Disable memory freeing on exit.
  public /*JBIT unsigned int*/ boolean RelocatablePCH /*: 1*/; ///< When generating PCH files,
  /// instruct the AST writer to create
  /// relocatable PCH files.
  public /*JBIT unsigned int*/ boolean ShowHelp /*: 1*/; ///< Show the -help text.
  public /*JBIT unsigned int*/ boolean ShowStats /*: 1*/; ///< Show frontend performance
  /// metrics and statistics.
  public /*JBIT unsigned int*/ boolean ShowTimers /*: 1*/; ///< Show timers for individual
  /// actions.
  public /*JBIT unsigned int*/ boolean ShowVersion /*: 1*/; ///< Show the -version text.
  public /*JBIT unsigned int*/ boolean FixWhatYouCan /*: 1*/; ///< Apply fixes even if there are
  /// unfixable errors.
  public /*JBIT unsigned int*/ boolean FixOnlyWarnings /*: 1*/; ///< Apply fixes only for warnings.
  public /*JBIT unsigned int*/ boolean FixAndRecompile /*: 1*/; ///< Apply fixes and recompile.
  public /*JBIT unsigned int*/ boolean FixToTemporaries /*: 1*/; ///< Apply fixes to temporary files.
  public /*JBIT unsigned int*/ boolean ARCMTMigrateEmitARCErrors /*: 1*/; /// Emit ARC errors even if the
  /// migrator can fix them
  public /*JBIT unsigned int*/ boolean SkipFunctionBodies /*: 1*/; ///< Skip over function bodies to
  /// speed up parsing in cases you do
  /// not need them (e.g. with code
  /// completion).
  public /*JBIT unsigned int*/ boolean UseGlobalModuleIndex /*: 1*/; ///< Whether we can use the
  ///< global module index if available.
  public /*JBIT unsigned int*/ boolean GenerateGlobalModuleIndex /*: 1*/; ///< Whether we can generate the
  ///< global module index if needed.
  public /*JBIT unsigned int*/ boolean ASTDumpDecls /*: 1*/; ///< Whether we include declaration
  ///< dumps in AST dumps.
  public /*JBIT unsigned int*/ boolean ASTDumpLookups /*: 1*/; ///< Whether we include lookup table
  ///< dumps in AST dumps.
  public /*JBIT unsigned int*/ boolean BuildingImplicitModule /*: 1*/; ///< Whether we are performing an
  ///< implicit module build.
  public /*JBIT unsigned int*/ boolean ModulesEmbedAllFiles /*: 1*/; ///< Whether we should embed all used
  ///< files into the PCM file.
  public /*JBIT unsigned int*/ boolean IncludeTimestamps /*: 1*/; ///< Whether timestamps should be
  ///< written to the produced PCH file.
  
  public CodeCompleteOptions CodeCompleteOpts;
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 158,
   FQN="clang::FrontendOptions::(anonymous)", NM="_ZN5clang15FrontendOptionsE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15FrontendOptionsE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    ARCMT_None(0),
    ARCMT_Check(ARCMT_None.getValue() + 1),
    ARCMT_Modify(ARCMT_Check.getValue() + 1),
    ARCMT_Migrate(ARCMT_Modify.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  
  public Unnamed_enum ARCMTAction;
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 169,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 165,
   FQN="clang::FrontendOptions::(anonymous)", NM="_ZN5clang15FrontendOptionsE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15FrontendOptionsE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int ObjCMT_None = 0;
    /// \brief Enable migration to modern ObjC literals.
    public static final /*uint*/int ObjCMT_Literals = 0x1;
    /// \brief Enable migration to modern ObjC subscripting.
    public static final /*uint*/int ObjCMT_Subscripting = 0x2;
    /// \brief Enable migration to modern ObjC readonly property.
    public static final /*uint*/int ObjCMT_ReadonlyProperty = 0x4;
    /// \brief Enable migration to modern ObjC readwrite property.
    public static final /*uint*/int ObjCMT_ReadwriteProperty = 0x8;
    /// \brief Enable migration to modern ObjC property.
    public static final /*uint*/int ObjCMT_Property = (ObjCMT_ReadonlyProperty | ObjCMT_ReadwriteProperty);
    /// \brief Enable annotation of ObjCMethods of all kinds.
    public static final /*uint*/int ObjCMT_Annotation = 0x10;
    /// \brief Enable migration of ObjC methods to 'instancetype'.
    public static final /*uint*/int ObjCMT_Instancetype = 0x20;
    /// \brief Enable migration to NS_ENUM/NS_OPTIONS macros.
    public static final /*uint*/int ObjCMT_NsMacros = 0x40;
    /// \brief Enable migration to add conforming protocols.
    public static final /*uint*/int ObjCMT_ProtocolConformance = 0x80;
    /// \brief prefer 'atomic' property over 'nonatomic'.
    public static final /*uint*/int ObjCMT_AtomicProperty = 0x100;
    /// \brief annotate property with NS_RETURNS_INNER_POINTER
    public static final /*uint*/int ObjCMT_ReturnsInnerPointerProperty = 0x200;
    /// \brief use NS_NONATOMIC_IOSONLY for property 'atomic' attribute
    public static final /*uint*/int ObjCMT_NsAtomicIOSOnlyProperty = 0x400;
    /// \brief Enable inferring NS_DESIGNATED_INITIALIZER for ObjC methods.
    public static final /*uint*/int ObjCMT_DesignatedInitializer = 0x800;
    /// \brief Enable converting setter/getter expressions to property-dot syntx.
    public static final /*uint*/int ObjCMT_PropertyDotSyntax = 0x1000;
    public static final /*uint*/int ObjCMT_MigrateDecls = (ObjCMT_ReadonlyProperty | ObjCMT_ReadwriteProperty
       | ObjCMT_Annotation | ObjCMT_Instancetype
       | ObjCMT_NsMacros | ObjCMT_ProtocolConformance
       | ObjCMT_NsAtomicIOSOnlyProperty
       | ObjCMT_DesignatedInitializer);
    public static final /*uint*/int ObjCMT_MigrateAll = (ObjCMT_Literals | ObjCMT_Subscripting
       | ObjCMT_MigrateDecls | ObjCMT_PropertyDotSyntax);
  /*}*/;
  public /*uint*/int ObjCMTAction;
  public std.string ObjCMTWhiteListPath;
  
  public std.string MTMigrateDir;
  public std.string ARCMTMigrateReportOut;
  
  /// The input files and their types.
  public std.vector<FrontendInputFile> Inputs;
  
  /// The output file, if any.
  public std.string OutputFile;
  
  /// If given, the new suffix for fix-it rewritten files.
  public std.string FixItSuffix;
  
  /// If given, filter dumped AST Decl nodes by this substring.
  public std.string ASTDumpFilter;
  
  /// If given, enable code completion at the provided location.
  public ParsedSourceLocation CodeCompletionAt;
  
  /// The frontend action to perform.
  public ActionKind ProgramAction;
  
  /// The name of the action to run when using a plugin action.
  public std.string ActionName;
  
  /// Args to pass to the plugins
  public std.mapTypeType<std.string, std.vectorString> PluginArgs;
  
  /// The list of plugin actions to run in addition to the normal action.
  public std.vectorString AddPluginActions;
  
  /// The list of plugins to load.
  public std.vectorString Plugins;
  
  /// The list of module file extensions.
  public std.vector<IntrusiveRefCntPtr<ModuleFileExtension>> ModuleFileExtensions;
  
  /// \brief The list of module map files to load before processing the input.
  public std.vectorString ModuleMapFiles;
  
  /// \brief The list of additional prebuilt module files to load before
  /// processing the input.
  public std.vectorString ModuleFiles;
  
  /// \brief The list of files to embed into the compiled module file.
  public std.vectorString ModulesEmbedFiles;
  
  /// \brief The list of AST files to merge.
  public std.vectorString ASTMergeFiles;
  
  /// \brief A list of arguments to forward to LLVM's option processing; this
  /// should only be used for debugging and experimental features.
  public std.vectorString LLVMArgs;
  
  /// \brief File name of the file that will provide record layouts
  /// (in the format produced by -fdump-record-layouts).
  public std.string OverrideRecordLayoutsFile;
  
  /// \brief Auxiliary triple for CUDA compilation.
  public std.string AuxTriple;
  
  /// \brief If non-empty, search the pch input file as it was a header
  // included by this file.
  public std.string FindPchSource;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions::FrontendOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 270,
   FQN="clang::FrontendOptions::FrontendOptions", NM="_ZN5clang15FrontendOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15FrontendOptionsC1Ev")
  //</editor-fold>
  public FrontendOptions() {
    // : DisableFree(false), RelocatablePCH(false), ShowHelp(false), ShowStats(false), ShowTimers(false), ShowVersion(false), FixWhatYouCan(false), FixOnlyWarnings(false), FixAndRecompile(false), FixToTemporaries(false), ARCMTMigrateEmitARCErrors(false), SkipFunctionBodies(false), UseGlobalModuleIndex(true), GenerateGlobalModuleIndex(true), ASTDumpDecls(false), ASTDumpLookups(false), BuildingImplicitModule(false), ModulesEmbedAllFiles(false), IncludeTimestamps(true), CodeCompleteOpts(), ARCMTAction(ARCMT_None), ObjCMTAction(ObjCMT_None), ObjCMTWhiteListPath(), MTMigrateDir(), ARCMTMigrateReportOut(), Inputs(), OutputFile(), FixItSuffix(), ASTDumpFilter(), CodeCompletionAt(), ProgramAction(frontend::ParseSyntaxOnly), ActionName(), PluginArgs(), AddPluginActions(), Plugins(), ModuleFileExtensions(), ModuleMapFiles(), ModuleFiles(), ModulesEmbedFiles(), ASTMergeFiles(), LLVMArgs(), OverrideRecordLayoutsFile(), AuxTriple(), FindPchSource() 
    //START JInit
    this.DisableFree = false;
    this.RelocatablePCH = false;
    this.ShowHelp = false;
    this.ShowStats = false;
    this.ShowTimers = false;
    this.ShowVersion = false;
    this.FixWhatYouCan = false;
    this.FixOnlyWarnings = false;
    this.FixAndRecompile = false;
    this.FixToTemporaries = false;
    this.ARCMTMigrateEmitARCErrors = false;
    this.SkipFunctionBodies = false;
    this.UseGlobalModuleIndex = true;
    this.GenerateGlobalModuleIndex = true;
    this.ASTDumpDecls = false;
    this.ASTDumpLookups = false;
    this.BuildingImplicitModule = false;
    this.ModulesEmbedAllFiles = false;
    this.IncludeTimestamps = true;
    this.CodeCompleteOpts = new CodeCompleteOptions();
    this.ARCMTAction = Unnamed_enum.ARCMT_None;
    this.ObjCMTAction = ObjCMT_None;
    this.ObjCMTWhiteListPath = new std.string();
    this.MTMigrateDir = new std.string();
    this.ARCMTMigrateReportOut = new std.string();
    this.Inputs = new std.vector<FrontendInputFile>(new FrontendInputFile());
    this.OutputFile = new std.string();
    this.FixItSuffix = new std.string();
    this.ASTDumpFilter = new std.string();
    this.CodeCompletionAt = new ParsedSourceLocation();
    this.ProgramAction = frontend.ActionKind.ParseSyntaxOnly;
    this.ActionName = new std.string();
    this.PluginArgs = new std.mapTypeType<std.string, std.vectorString>(new std.vectorString());
    this.AddPluginActions = new std.vectorString(std.string.EMPTY);
    this.Plugins = new std.vectorString(std.string.EMPTY);
    this.ModuleFileExtensions = new std.vector<IntrusiveRefCntPtr<ModuleFileExtension>>(new IntrusiveRefCntPtr<ModuleFileExtension>());
    this.ModuleMapFiles = new std.vectorString(std.string.EMPTY);
    this.ModuleFiles = new std.vectorString(std.string.EMPTY);
    this.ModulesEmbedFiles = new std.vectorString(std.string.EMPTY);
    this.ASTMergeFiles = new std.vectorString(std.string.EMPTY);
    this.LLVMArgs = new std.vectorString(std.string.EMPTY);
    this.OverrideRecordLayoutsFile = new std.string();
    this.AuxTriple = new std.string();
    this.FindPchSource = new std.string();
    //END JInit
  }

  
  /// getInputKindForExtension - Return the appropriate input kind for a file
  /// extension. For example, "c" would return IK_C.
  ///
  /// \return The input kind for the extension, or IK_None if the extension is
  /// not recognized.
  
  /// getInputKindForExtension - Return the appropriate input kind for a file
  /// extension. For example, "c" would return IK_C.
  ///
  /// \return The input kind for the extension, or IK_None if the extension is
  /// not recognized.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions::getInputKindForExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendOptions.cpp", line = 14,
   FQN="clang::FrontendOptions::getInputKindForExtension", NM="_ZN5clang15FrontendOptions24getInputKindForExtensionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendOptions.cpp -nm=_ZN5clang15FrontendOptions24getInputKindForExtensionEN4llvm9StringRefE")
  //</editor-fold>
  public static InputKind getInputKindForExtension(StringRef Extension) {
    return new StringSwitch<InputKind>(/*NO_COPY*/Extension).
        Cases(/*KEEP_STR*/"ast", /*KEEP_STR*/"pcm", InputKind.IK_AST).
        Case(/*KEEP_STR*/"c", InputKind.IK_C).
        Cases(/*KEEP_STR*/"S", /*KEEP_STR*/"s", InputKind.IK_Asm).
        Case(/*KEEP_STR*/"i", InputKind.IK_PreprocessedC).
        Case(/*KEEP_STR*/"ii", InputKind.IK_PreprocessedCXX).
        Case(/*KEEP_STR*/"cui", InputKind.IK_PreprocessedCuda).
        Case(/*KEEP_STR*/"m", InputKind.IK_ObjC).
        Case(/*KEEP_STR*/"mi", InputKind.IK_PreprocessedObjC).
        Cases(/*KEEP_STR*/"mm", /*KEEP_STR*/"M", InputKind.IK_ObjCXX).
        Case(/*KEEP_STR*/"mii", InputKind.IK_PreprocessedObjCXX).
        Cases(/*KEEP_STR*/"C", /*KEEP_STR*/"cc", /*KEEP_STR*/"cp", InputKind.IK_CXX).
        Cases(/*KEEP_STR*/"cpp", /*KEEP_STR*/"CPP", /*KEEP_STR*/"c++", /*KEEP_STR*/"cxx", /*KEEP_STR*/"hpp", InputKind.IK_CXX).
        Case(/*KEEP_STR*/"cl", InputKind.IK_OpenCL).
        Case(/*KEEP_STR*/"cu", InputKind.IK_CUDA).
        Cases(/*KEEP_STR*/"ll", /*KEEP_STR*/"bc", InputKind.IK_LLVM_IR).
        Default(InputKind.IK_C);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions::FrontendOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 120,
   FQN="clang::FrontendOptions::FrontendOptions", NM="_ZN5clang15FrontendOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15FrontendOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FrontendOptions(/*const*/ FrontendOptions /*&*/ $Prm0) {
    // : DisableFree(.DisableFree), RelocatablePCH(.RelocatablePCH), ShowHelp(.ShowHelp), ShowStats(.ShowStats), ShowTimers(.ShowTimers), ShowVersion(.ShowVersion), FixWhatYouCan(.FixWhatYouCan), FixOnlyWarnings(.FixOnlyWarnings), FixAndRecompile(.FixAndRecompile), FixToTemporaries(.FixToTemporaries), ARCMTMigrateEmitARCErrors(.ARCMTMigrateEmitARCErrors), SkipFunctionBodies(.SkipFunctionBodies), UseGlobalModuleIndex(.UseGlobalModuleIndex), GenerateGlobalModuleIndex(.GenerateGlobalModuleIndex), ASTDumpDecls(.ASTDumpDecls), ASTDumpLookups(.ASTDumpLookups), BuildingImplicitModule(.BuildingImplicitModule), ModulesEmbedAllFiles(.ModulesEmbedAllFiles), IncludeTimestamps(.IncludeTimestamps), CodeCompleteOpts(.CodeCompleteOpts), ARCMTAction(.ARCMTAction), ObjCMTAction(.ObjCMTAction), ObjCMTWhiteListPath(.ObjCMTWhiteListPath), MTMigrateDir(.MTMigrateDir), ARCMTMigrateReportOut(.ARCMTMigrateReportOut), Inputs(.Inputs), OutputFile(.OutputFile), FixItSuffix(.FixItSuffix), ASTDumpFilter(.ASTDumpFilter), CodeCompletionAt(.CodeCompletionAt), ProgramAction(.ProgramAction), ActionName(.ActionName), PluginArgs(.PluginArgs), AddPluginActions(.AddPluginActions), Plugins(.Plugins), ModuleFileExtensions(.ModuleFileExtensions), ModuleMapFiles(.ModuleMapFiles), ModuleFiles(.ModuleFiles), ModulesEmbedFiles(.ModulesEmbedFiles), ASTMergeFiles(.ASTMergeFiles), LLVMArgs(.LLVMArgs), OverrideRecordLayoutsFile(.OverrideRecordLayoutsFile), AuxTriple(.AuxTriple), FindPchSource(.FindPchSource) 
    //START JInit
    this.DisableFree = $Prm0.DisableFree;
    this.RelocatablePCH = $Prm0.RelocatablePCH;
    this.ShowHelp = $Prm0.ShowHelp;
    this.ShowStats = $Prm0.ShowStats;
    this.ShowTimers = $Prm0.ShowTimers;
    this.ShowVersion = $Prm0.ShowVersion;
    this.FixWhatYouCan = $Prm0.FixWhatYouCan;
    this.FixOnlyWarnings = $Prm0.FixOnlyWarnings;
    this.FixAndRecompile = $Prm0.FixAndRecompile;
    this.FixToTemporaries = $Prm0.FixToTemporaries;
    this.ARCMTMigrateEmitARCErrors = $Prm0.ARCMTMigrateEmitARCErrors;
    this.SkipFunctionBodies = $Prm0.SkipFunctionBodies;
    this.UseGlobalModuleIndex = $Prm0.UseGlobalModuleIndex;
    this.GenerateGlobalModuleIndex = $Prm0.GenerateGlobalModuleIndex;
    this.ASTDumpDecls = $Prm0.ASTDumpDecls;
    this.ASTDumpLookups = $Prm0.ASTDumpLookups;
    this.BuildingImplicitModule = $Prm0.BuildingImplicitModule;
    this.ModulesEmbedAllFiles = $Prm0.ModulesEmbedAllFiles;
    this.IncludeTimestamps = $Prm0.IncludeTimestamps;
    this.CodeCompleteOpts = new CodeCompleteOptions($Prm0.CodeCompleteOpts);
    this.ARCMTAction = $Prm0.ARCMTAction;
    this.ObjCMTAction = $Prm0.ObjCMTAction;
    this.ObjCMTWhiteListPath = new std.string($Prm0.ObjCMTWhiteListPath);
    this.MTMigrateDir = new std.string($Prm0.MTMigrateDir);
    this.ARCMTMigrateReportOut = new std.string($Prm0.ARCMTMigrateReportOut);
    this.Inputs = new std.vector<FrontendInputFile>($Prm0.Inputs);
    this.OutputFile = new std.string($Prm0.OutputFile);
    this.FixItSuffix = new std.string($Prm0.FixItSuffix);
    this.ASTDumpFilter = new std.string($Prm0.ASTDumpFilter);
    this.CodeCompletionAt = new ParsedSourceLocation($Prm0.CodeCompletionAt);
    this.ProgramAction = $Prm0.ProgramAction;
    this.ActionName = new std.string($Prm0.ActionName);
    this.PluginArgs = new std.mapTypeType<std.string, std.vectorString>($Prm0.PluginArgs);
    this.AddPluginActions = new std.vectorString($Prm0.AddPluginActions);
    this.Plugins = new std.vectorString($Prm0.Plugins);
    this.ModuleFileExtensions = new std.vector<IntrusiveRefCntPtr<ModuleFileExtension>>($Prm0.ModuleFileExtensions);
    this.ModuleMapFiles = new std.vectorString($Prm0.ModuleMapFiles);
    this.ModuleFiles = new std.vectorString($Prm0.ModuleFiles);
    this.ModulesEmbedFiles = new std.vectorString($Prm0.ModulesEmbedFiles);
    this.ASTMergeFiles = new std.vectorString($Prm0.ASTMergeFiles);
    this.LLVMArgs = new std.vectorString($Prm0.LLVMArgs);
    this.OverrideRecordLayoutsFile = new std.string($Prm0.OverrideRecordLayoutsFile);
    this.AuxTriple = new std.string($Prm0.AuxTriple);
    this.FindPchSource = new std.string($Prm0.FindPchSource);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendOptions::~FrontendOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 120,
   FQN="clang::FrontendOptions::~FrontendOptions", NM="_ZN5clang15FrontendOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15FrontendOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FindPchSource.$destroy();
    AuxTriple.$destroy();
    OverrideRecordLayoutsFile.$destroy();
    LLVMArgs.$destroy();
    ASTMergeFiles.$destroy();
    ModulesEmbedFiles.$destroy();
    ModuleFiles.$destroy();
    ModuleMapFiles.$destroy();
    ModuleFileExtensions.$destroy();
    Plugins.$destroy();
    AddPluginActions.$destroy();
    PluginArgs.$destroy();
    ActionName.$destroy();
    CodeCompletionAt.$destroy();
    ASTDumpFilter.$destroy();
    FixItSuffix.$destroy();
    OutputFile.$destroy();
    Inputs.$destroy();
    ARCMTMigrateReportOut.$destroy();
    MTMigrateDir.$destroy();
    ObjCMTWhiteListPath.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "DisableFree=" + DisableFree // NOI18N
              + ", RelocatablePCH=" + RelocatablePCH // NOI18N
              + ", ShowHelp=" + ShowHelp // NOI18N
              + ", ShowStats=" + ShowStats // NOI18N
              + ", ShowTimers=" + ShowTimers // NOI18N
              + ", ShowVersion=" + ShowVersion // NOI18N
              + ", FixWhatYouCan=" + FixWhatYouCan // NOI18N
              + ", FixOnlyWarnings=" + FixOnlyWarnings // NOI18N
              + ", FixAndRecompile=" + FixAndRecompile // NOI18N
              + ", FixToTemporaries=" + FixToTemporaries // NOI18N
              + ", ARCMTMigrateEmitARCErrors=" + ARCMTMigrateEmitARCErrors // NOI18N
              + ", SkipFunctionBodies=" + SkipFunctionBodies // NOI18N
              + ", UseGlobalModuleIndex=" + UseGlobalModuleIndex // NOI18N
              + ", GenerateGlobalModuleIndex=" + GenerateGlobalModuleIndex // NOI18N
              + ", ASTDumpDecls=" + ASTDumpDecls // NOI18N
              + ", ASTDumpLookups=" + ASTDumpLookups // NOI18N
              + ", BuildingImplicitModule=" + BuildingImplicitModule // NOI18N
              + ", ModulesEmbedAllFiles=" + ModulesEmbedAllFiles // NOI18N
              + ", IncludeTimestamps=" + IncludeTimestamps // NOI18N
              + ", CodeCompleteOpts=" + CodeCompleteOpts // NOI18N
              + ", ARCMTAction=" + ARCMTAction // NOI18N
              + ", ObjCMTAction=" + ObjCMTAction // NOI18N
              + ", ObjCMTWhiteListPath=" + ObjCMTWhiteListPath // NOI18N
              + ", MTMigrateDir=" + MTMigrateDir // NOI18N
              + ", ARCMTMigrateReportOut=" + ARCMTMigrateReportOut // NOI18N
              + ", Inputs=" + Inputs // NOI18N
              + ", OutputFile=" + OutputFile // NOI18N
              + ", FixItSuffix=" + FixItSuffix // NOI18N
              + ", ASTDumpFilter=" + ASTDumpFilter // NOI18N
              + ", CodeCompletionAt=" + CodeCompletionAt // NOI18N
              + ", ProgramAction=" + ProgramAction // NOI18N
              + ", ActionName=" + ActionName // NOI18N
              + ", PluginArgs=" + PluginArgs // NOI18N
              + ", AddPluginActions=" + AddPluginActions // NOI18N
              + ", Plugins=" + Plugins // NOI18N
              + ", ModuleFileExtensions=" + ModuleFileExtensions // NOI18N
              + ", ModuleMapFiles=" + ModuleMapFiles // NOI18N
              + ", ModuleFiles=" + ModuleFiles // NOI18N
              + ", ModulesEmbedFiles=" + ModulesEmbedFiles // NOI18N
              + ", ASTMergeFiles=" + ASTMergeFiles // NOI18N
              + ", LLVMArgs=" + LLVMArgs // NOI18N
              + ", OverrideRecordLayoutsFile=" + OverrideRecordLayoutsFile // NOI18N
              + ", AuxTriple=" + AuxTriple // NOI18N
              + ", FindPchSource=" + FindPchSource; // NOI18N
  }
}
