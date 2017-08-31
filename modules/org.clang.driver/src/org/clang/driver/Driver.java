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

package org.clang.driver;

import java.util.Comparator;
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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.config.config.*;
import static org.clang.driver.impl.DriverStatics.*;
import static org.clang.driver.types.*;
import static org.clang.driver.phases.*;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.VfsGlobals;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Top;


/// Driver - Encapsulate logic for constructing compilation processes
/// from a set of gcc-driver-like command line arguments.
//<editor-fold defaultstate="collapsed" desc="clang::driver::Driver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 66,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 65,
 FQN="clang::driver::Driver", NM="_ZN5clang6driver6DriverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6DriverE")
//</editor-fold>
public class Driver implements Destructors.ClassWithDestructor {
  private OptTable /*P*/ Opts;
  
  private final DiagnosticsEngine /*&*/ Diags;
  
  private IntrusiveRefCntPtr<FileSystem> VFS;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::DriverMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 73,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 72,
   FQN="clang::driver::Driver::DriverMode", NM="_ZN5clang6driver6Driver10DriverModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver10DriverModeE")
  //</editor-fold>
  private enum DriverMode implements Native.NativeUIntEnum {
    GCCMode(0),
    GXXMode(GCCMode.getValue() + 1),
    CPPMode(GXXMode.getValue() + 1),
    CLMode(CPPMode.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DriverMode valueOf(int val) {
      DriverMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DriverMode[] VALUES;
      private static final DriverMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DriverMode kind : DriverMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DriverMode[min < 0 ? (1-min) : 0];
        VALUES = new DriverMode[max >= 0 ? (1+max) : 0];
        for (DriverMode kind : DriverMode.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private DriverMode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  private  DriverMode Mode;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::SaveTempsMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 79,
   FQN="clang::driver::Driver::SaveTempsMode", NM="_ZN5clang6driver6Driver13SaveTempsModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver13SaveTempsModeE")
  //</editor-fold>
  private enum SaveTempsMode implements Native.NativeUIntEnum {
    SaveTempsNone(0),
    SaveTempsCwd(SaveTempsNone.getValue() + 1),
    SaveTempsObj(SaveTempsCwd.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SaveTempsMode valueOf(int val) {
      SaveTempsMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SaveTempsMode[] VALUES;
      private static final SaveTempsMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SaveTempsMode kind : SaveTempsMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SaveTempsMode[min < 0 ? (1-min) : 0];
        VALUES = new SaveTempsMode[max >= 0 ? (1+max) : 0];
        for (SaveTempsMode kind : SaveTempsMode.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private SaveTempsMode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  private  SaveTempsMode SaveTemps;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BitcodeEmbedMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 86,
   FQN="clang::driver::Driver::BitcodeEmbedMode", NM="_ZN5clang6driver6Driver16BitcodeEmbedModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver16BitcodeEmbedModeE")
  //</editor-fold>
  private enum BitcodeEmbedMode implements Native.NativeUIntEnum {
    EmbedNone(0),
    EmbedMarker(EmbedNone.getValue() + 1),
    EmbedBitcode(EmbedMarker.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BitcodeEmbedMode valueOf(int val) {
      BitcodeEmbedMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BitcodeEmbedMode[] VALUES;
      private static final BitcodeEmbedMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BitcodeEmbedMode kind : BitcodeEmbedMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BitcodeEmbedMode[min < 0 ? (1-min) : 0];
        VALUES = new BitcodeEmbedMode[max >= 0 ? (1+max) : 0];
        for (BitcodeEmbedMode kind : BitcodeEmbedMode.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private BitcodeEmbedMode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  private  BitcodeEmbedMode BitcodeEmbed;
  
  /// LTO mode selected via -f(no-)?lto(=.*)? options.
  private LTOKind LTOMode;
/*public:*/
  // Diag - Forwarding function for diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 90,
   FQN="clang::driver::Driver::Diag", NM="_ZNK5clang6driver6Driver4DiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver4DiagEj")
  //</editor-fold>
  public DiagnosticBuilder Diag(/*uint*/int DiagID) /*const*/ {
    return Diags.Report(DiagID);
  }


  // FIXME: Privatize once interface is stable.
  /*public:*/
  /// The name the driver was invoked as.
  public std.string Name;
  
  /// The path the driver executable was in, as invoked from the
  /// command line.
  public std.string Dir;
  
  /// The original path to the clang executable.
  public std.string ClangExecutable;
  
  /// The path to the installed clang directory, if any.
  public std.string InstalledDir;
  
  /// The path to the compiler resource directory.
  public std.string ResourceDir;
  
  /// A prefix directory used to emulate a limited subset of GCC's '-Bprefix'
  /// functionality.
  /// FIXME: This type of customization should be removed in favor of the
  /// universal driver when it is ready.
  // JAVA: typedef SmallVector<std::string, 4> prefix_list
//  public final class prefix_list extends SmallVector<std.string>{ };
  public SmallVector<std.string> PrefixDirs;
  
  /// sysroot, if present
  public std.string SysRoot;
  
  /// Dynamic loader prefix, if present
  public std.string DyldPrefix;
  
  /// If the standard library is used
  public boolean UseStdLib;
  
  /// Default target triple.
  public std.string DefaultTargetTriple;
  
  /// Driver title to use with help.
  public std.string DriverTitle;
  
  /// Information about the host which can be overridden by the user.
  public std.string HostBits;
  public std.string HostMachine;
  public std.string HostSystem;
  public std.string HostRelease;
  
  /// The file to log CC_PRINT_OPTIONS output to, if enabled.
  public /*const*/char$ptr/*char P*/ CCPrintOptionsFilename;
  
  /// The file to log CC_PRINT_HEADERS output to, if enabled.
  public /*const*/char$ptr/*char P*/ CCPrintHeadersFilename;
  
  /// The file to log CC_LOG_DIAGNOSTICS output to, if enabled.
  public /*const*/char$ptr/*char P*/ CCLogDiagnosticsFilename;
  
  /// A list of inputs and their types for the given arguments.
  // JAVA: typedef SmallVector<std::pair<types::ID, const llvm::opt::Arg *>, 16> InputList
//  public final class InputList extends SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >>{ };
  
  /// Whether the driver should follow g++ like behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::CCCIsCXX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 151,
   FQN="clang::driver::Driver::CCCIsCXX", NM="_ZNK5clang6driver6Driver8CCCIsCXXEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver8CCCIsCXXEv")
  //</editor-fold>
  public boolean CCCIsCXX() /*const*/ {
    return Mode == DriverMode.GXXMode;
  }

  
  /// Whether the driver is just the preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::CCCIsCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 154,
   FQN="clang::driver::Driver::CCCIsCPP", NM="_ZNK5clang6driver6Driver8CCCIsCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver8CCCIsCPPEv")
  //</editor-fold>
  public boolean CCCIsCPP() /*const*/ {
    return Mode == DriverMode.CPPMode;
  }

  
  /// Whether the driver should follow cl.exe like behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::IsCLMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 157,
   FQN="clang::driver::Driver::IsCLMode", NM="_ZNK5clang6driver6Driver8IsCLModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver8IsCLModeEv")
  //</editor-fold>
  public boolean IsCLMode() /*const*/ {
    return Mode == DriverMode.CLMode;
  }

  
  /// Only print tool bindings, don't build any jobs.
  public /*JBIT unsigned int*/ boolean CCCPrintBindings /*: 1*/;
  
  /// Set CC_PRINT_OPTIONS mode, which is like -v but logs the commands to
  /// CCPrintOptionsFilename or to stderr.
  public /*JBIT unsigned int*/ boolean CCPrintOptions /*: 1*/;
  
  /// Set CC_PRINT_HEADERS mode, which causes the frontend to log header include
  /// information to CCPrintHeadersFilename or to stderr.
  public /*JBIT unsigned int*/ boolean CCPrintHeaders /*: 1*/;
  
  /// Set CC_LOG_DIAGNOSTICS mode, which causes the frontend to log diagnostics
  /// to CCLogDiagnosticsFilename or to stderr, in a stable machine readable
  /// format.
  public /*JBIT unsigned int*/ boolean CCLogDiagnostics /*: 1*/;
  
  /// Whether the driver is generating diagnostics for debugging purposes.
  public /*JBIT unsigned int*/ boolean CCGenDiagnostics /*: 1*/;
/*private:*/
  /// Name to use when invoking gcc/g++.
  private std.string CCCGenericGCCName;
  
  /// Whether to check that input files exist when constructing compilation
  /// jobs.
  private /*JBIT unsigned int*/ boolean CheckInputsExist /*: 1*/;
/*public:*/
  /// Use lazy precompiled headers for PCH support.
  public /*JBIT unsigned int*/ boolean CCCUsePCH /*: 1*/;
/*private:*/
  /// Certain options suppress the 'no input files' warning.
  private /*JBIT unsigned int*/ boolean SuppressMissingInputWarning /*: 1*/;
  
  private std.list<std.string> TempFiles;
  private std.list<std.string> ResultFiles;
  
  /// \brief Cache of all the ToolChains in use by the driver.
  ///
  /// This maps from the string representation of a triple to a ToolChain
  /// created targeting that triple. The driver owns all the ToolChain objects
  /// stored in it, and will clean them up when torn down.
  private /*mutable */StringMap<ToolChain /*P*//*, MallocAllocator*/> ToolChains;
/*private:*/
  /// TranslateInputArgs - Create a new derived argument list from the input
  /// arguments, after applying the standard argument translations.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::TranslateInputArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 208,
   FQN="clang::driver::Driver::TranslateInputArgs", NM="_ZNK5clang6driver6Driver18TranslateInputArgsERKN4llvm3opt12InputArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver18TranslateInputArgsERKN4llvm3opt12InputArgListE")
  //</editor-fold>
  private DerivedArgList /*P*/ TranslateInputArgs(final /*const*/ InputArgList /*&*/ Args) /*const*/ {
    DerivedArgList /*P*/ DAL = new DerivedArgList(Args);
    
    boolean HasNostdlib = Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()));
    boolean HasNodefaultlib = Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()));
    for (Arg /*P*/ A : Args) {
      // Unfortunately, we have to parse some forwarding options (-Xassembler,
      // -Xlinker, -Xpreprocessor) because we either integrate their functionality
      // (assembler and preprocessor), or bypass a previous driver ('collect2').
      
      // Rewrite linker options, to replace --no-demangle with a custom internal
      // option.
      if ((A.getOption().matches(new OptSpecifier(options.ID.OPT_Wl_COMMA.getValue()))
         || A.getOption().matches(new OptSpecifier(options.ID.OPT_Xlinker.getValue())))
         && A.containsValue(new StringRef(/*KEEP_STR*/"--no-demangle"))) {
        // Add the rewritten no-demangle argument.
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_Z_Xlinker__no_demangle.getValue())));
        
        // Add the remaining values as Xlinker arguments.
        for (char$ptr Val : A.getValues())  {
          if ($noteq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"--no-demangle")) {
            DAL.AddSeparateArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_Xlinker.getValue())), /*NO_COPY*/new StringRef(Val));
          }
        }
        
        continue;
      }
      
      // Rewrite preprocessor options, to replace -Wp,-MD,FOO which is used by
      // some build systems. We don't try to be complete here because we don't
      // care to encourage this usage model.
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Wp_COMMA.getValue()))
         && ($eq_StringRef(/*STRINGREF_STR*/A.getValue(0), /*STRINGREF_STR*/"-MD")
         || $eq_StringRef(/*STRINGREF_STR*/A.getValue(0), /*STRINGREF_STR*/"-MMD"))) {
        // Rewrite to -MD/-MMD along with -MF.
        if ($eq_StringRef(/*STRINGREF_STR*/A.getValue(0), /*STRINGREF_STR*/"-MD")) {
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_MD.getValue())));
        } else {
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_MMD.getValue())));
        }
        if (A.getNumValues() == 2) {
          DAL.AddSeparateArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_MF.getValue())), 
              new StringRef(A.getValue(1)));
        }
        continue;
      }
      
      // Rewrite reserved library names.
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_l.getValue()))) {
        StringRef Value = new StringRef(A.getValue());
        
        // Rewrite unless -nostdlib is present.
        if (!HasNostdlib && !HasNodefaultlib && $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"stdc++")) {
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_Z_reserved_lib_stdcxx.getValue())));
          continue;
        }
        
        // Rewrite unconditionally.
        if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"cc_kext")) {
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_Z_reserved_lib_cckext.getValue())));
          continue;
        }
      }
      
      // Pick up inputs via the -- option.
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT__DASH_DASH.getValue()))) {
        A.claim();
        for (char$ptr Val : A.getValues())  {
          DAL.append(MakeInputArg(/*Deref*/DAL, Opts, /*NO_COPY*/new StringRef(Val)));
        }
        continue;
      }
      
      DAL.append(A);
    }
    
    // Enforce -static if -miamcu is present.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_miamcu.getValue()), new OptSpecifier(options.ID.OPT_mno_iamcu.getValue()), false)) {
      DAL.AddFlagArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_static.getValue())));
    }
    
    return DAL;
  }

  
  // getFinalPhase - Determine which compilation mode we are in and record 
  // which option we used to determine the final phase.
  
  // Determine which compilation mode we are in. We look for options which
  // affect the phase, starting with the earliest phases, and record which
  // option we used to determine the final phase.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getFinalPhase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 161,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 157,
   FQN="clang::driver::Driver::getFinalPhase", NM="_ZNK5clang6driver6Driver13getFinalPhaseERKN4llvm3opt14DerivedArgListEPPNS3_3ArgE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver13getFinalPhaseERKN4llvm3opt14DerivedArgListEPPNS3_3ArgE")
  //</editor-fold>
  private phases.ID getFinalPhase(final /*const*/ DerivedArgList /*&*/ DAL) /*const*/ {
    return getFinalPhase(DAL, 
               (type$ptr<Arg /*P*/ /*P*/>)null);
  }
  private phases.ID getFinalPhase(final /*const*/ DerivedArgList /*&*/ DAL, 
               type$ptr<Arg /*P*/ /*P*/> FinalPhaseArg/*= null*/) /*const*/ {
    Arg /*P*/ PhaseArg = null;
    phases.ID FinalPhase;
    
    // -{E,EP,P,M,MM} only run the preprocessor.
    if (CCCIsCPP() || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_E.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_EP.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_M.getValue()), new OptSpecifier(options.ID.OPT_MM.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_P.getValue()))) != null)) {
      FinalPhase = phases.ID.Preprocess;
      // -{fsyntax-only,-analyze,emit-ast} only run up to the compiler.
    } else if (((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_fsyntax_only.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_module_file_info.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_verify_pch.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_rewrite_objc.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_rewrite_legacy_objc.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT__migrate.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT__analyze.getValue()), 
        new OptSpecifier(options.ID.OPT__analyze_auto.getValue()))) != null)
       || ((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_emit_ast.getValue()))) != null)) {
      FinalPhase = phases.ID.Compile;
      // -S only runs up to the backend.
    } else if (((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_S.getValue()))) != null)) {
      FinalPhase = phases.ID.Backend;
      // -c compilation only runs up to the assembler.
    } else if (((PhaseArg = DAL.getLastArg(new OptSpecifier(options.ID.OPT_c.getValue()))) != null)) {
      FinalPhase = phases.ID.Assemble;
      // Otherwise do everything.
    } else {
      FinalPhase = phases.ID.Link;
    }
    if ((FinalPhaseArg != null)) {
      FinalPhaseArg.$set(PhaseArg);
    }
    
    return FinalPhase;
  }

  
  // Before executing jobs, sets up response files for commands that need them.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::setUpResponseFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 777,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 701,
   FQN="clang::driver::Driver::setUpResponseFiles", NM="_ZN5clang6driver6Driver18setUpResponseFilesERNS0_11CompilationERNS0_7CommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver18setUpResponseFilesERNS0_11CompilationERNS0_7CommandE")
  //</editor-fold>
  private void setUpResponseFiles(final Compilation /*&*/ C, final Command /*&*/ Cmd) {
    // Since commandLineFitsWithinSystemLimits() may underestimate system's capacity
    // if the tool does not support response files, there is a chance/ that things
    // will just work without a response file, so we silently just skip it.
    if (Cmd.getCreator().getResponseFilesSupport() == Tool.ResponseFileSupport.RF_None
       || sys.commandLineFitsWithinSystemLimits(new StringRef(Cmd.getExecutable()), new ArrayRef</*const*/char$ptr/*char P*/ >(Cmd.getArguments()))) {
      return;
    }
    
    std.string TmpName = GetTemporaryPath(new StringRef(/*KEEP_STR*/"response"), $("txt"));
    Cmd.setResponseFile(C.addTempFile(C.getArgs().MakeArgString(new Twine(TmpName.c_str()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::generatePrefixedToolNames">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2508,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2132,
   FQN="clang::driver::Driver::generatePrefixedToolNames", NM="_ZNK5clang6driver6Driver25generatePrefixedToolNamesEPKcRKNS0_9ToolChainERN4llvm15SmallVectorImplISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver25generatePrefixedToolNamesEPKcRKNS0_9ToolChainERN4llvm15SmallVectorImplISsEE")
  //</editor-fold>
  private void generatePrefixedToolNames(/*const*/char$ptr/*char P*/ Tool, final /*const*/ ToolChain /*&*/ TC, 
                           final SmallVectorImpl<std.string> /*&*/ Names) /*const*/ {
    // FIXME: Needs a better variable than DefaultTargetTriple
    Names.emplace_back($add_string_T($add_string$C_T(DefaultTargetTriple, /*KEEP_STR*/"-"), Tool));
    Names.emplace_back(new std.string(Tool));
    
    // Allow the discovery of tools prefixed with LLVM's default target triple.
    std.string LLVMDefaultTargetTriple = sys.getDefaultTargetTriple();
    if ($noteq_string$C(LLVMDefaultTargetTriple, DefaultTargetTriple)) {
      Names.emplace_back($add_string_T($add_string$C_T(LLVMDefaultTargetTriple, /*KEEP_STR*/"-"), Tool));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::Driver">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 49,
   FQN="clang::driver::Driver::Driver", NM="_ZN5clang6driver6DriverC1EN4llvm9StringRefES3_RNS_17DiagnosticsEngineENS2_18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6DriverC1EN4llvm9StringRefES3_RNS_17DiagnosticsEngineENS2_18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE")
  //</editor-fold>
  public Driver(StringRef ClangExecutable, StringRef DefaultTargetTriple, 
      final DiagnosticsEngine /*&*/ Diags) {
    this(JC$Push().forward(ClangExecutable), DefaultTargetTriple, 
      Diags, 
      JC$Top().track(new IntrusiveRefCntPtr<FileSystem>((FileSystem /*P*/ )null))); JC$Pop();
  }
  public Driver(StringRef ClangExecutable, StringRef DefaultTargetTriple, 
      final DiagnosticsEngine /*&*/ Diags, 
      IntrusiveRefCntPtr<FileSystem> VFS/*= $c$.track(null)*/) {
    // : Opts(createDriverOptTable()), Diags(Diags), VFS(std::move(VFS)), Mode(GCCMode), SaveTemps(SaveTempsNone), BitcodeEmbed(EmbedNone), LTOMode(LTOK_None), Name(), Dir(), ClangExecutable(ClangExecutable.operator basic_string()), InstalledDir(), ResourceDir(), PrefixDirs(), SysRoot(""), DyldPrefix(), UseStdLib(true), DefaultTargetTriple(DefaultTargetTriple.operator basic_string()), DriverTitle("clang LLVM compiler"), HostBits(), HostMachine(), HostSystem(), HostRelease(), CCPrintOptionsFilename(null), CCPrintHeadersFilename(null), CCLogDiagnosticsFilename(null), CCCPrintBindings(false), CCPrintHeaders(false), CCLogDiagnostics(false), CCGenDiagnostics(false), CCCGenericGCCName(""), CheckInputsExist(true), CCCUsePCH(true), SuppressMissingInputWarning(false), TempFiles(), ResultFiles(), ToolChains() 
    //START JInit
    this.Opts = DriverGlobals.createDriverOptTable();
    this./*&*/Diags=/*&*/Diags;
    this.VFS = new IntrusiveRefCntPtr<FileSystem>(JD$Move.INSTANCE, std.move(VFS));
    this.Mode = DriverMode.GCCMode;
    this.SaveTemps = SaveTempsMode.SaveTempsNone;
    this.BitcodeEmbed = BitcodeEmbedMode.EmbedNone;
    this.LTOMode = LTOKind.LTOK_None;
    this.Name = new std.string();
    this.Dir = new std.string();
    this.ClangExecutable = ClangExecutable.$string();
    this.InstalledDir = new std.string();
    this.ResourceDir = new std.string();
    this.PrefixDirs = new SmallVector<std.string>(4, new std.string());
    this.SysRoot = new std.string(/*KEEP_STR*/DEFAULT_SYSROOT);
    this.DyldPrefix = new std.string();
    this.UseStdLib = true;
    this.DefaultTargetTriple = DefaultTargetTriple.$string();
    this.DriverTitle = new std.string(/*KEEP_STR*/"clang LLVM compiler");
    this.HostBits = new std.string();
    this.HostMachine = new std.string();
    this.HostSystem = new std.string();
    this.HostRelease = new std.string();
    this.CCPrintOptionsFilename = null;
    this.CCPrintHeadersFilename = null;
    this.CCLogDiagnosticsFilename = null;
    this.CCCPrintBindings = false;
    this.CCPrintHeaders = false;
    this.CCLogDiagnostics = false;
    this.CCGenDiagnostics = false;
    this.CCCGenericGCCName = new std.string(/*KEEP_STR*/$EMPTY);
    this.CheckInputsExist = true;
    this.CCCUsePCH = true;
    this.SuppressMissingInputWarning = false;
    this.TempFiles = new std.list<std.string>(new std.string());
    this.ResultFiles = new std.list<std.string>(new std.string());
    this.ToolChains = new StringMap<ToolChain /*P*//*, MallocAllocator*/>(null);
    //END JInit
    
    // Provide a sane fallback if no VFS is specified.
    if (!this.VFS.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(this.VFS.$assign($c$.track(VfsGlobals.getRealFileSystem())));
      } finally {
        $c$.$destroy();
      }
    }
    
    Name.$assignMove(path.filename(/*NO_COPY*/ClangExecutable).$string());
    Dir.$assignMove(path.parent_path(/*NO_COPY*/ClangExecutable).$string());
    InstalledDir.$assign(Dir); // Provide a sensible default installed dir.
    
    // Compute the path to the resource directory.
    StringRef ClangResourceDir/*J*/= new StringRef(/*KEEP_STR*/CLANG_RESOURCE_DIR);
    SmallString/*128*/ P/*J*/= new SmallString/*128*/(128, new StringRef(Dir));
    if ($noteq_StringRef(/*NO_COPY*/ClangResourceDir, /*STRINGREF_STR*/"")) {
      path.append(P, new Twine(ClangResourceDir));
    } else {
      StringRef ClangLibdirSuffix/*J*/= new StringRef(/*KEEP_STR*/CLANG_LIBDIR_SUFFIX);
      path.append(P, new Twine(/*KEEP_STR*/$DOT_DOT), $add_Twine(new Twine(/*KEEP_STR*/"lib"), new Twine(ClangLibdirSuffix)), new Twine(/*KEEP_STR*/"clang"), 
          new Twine(/*KEEP_STR*/CLANG_VERSION_STRING));
    }
    ResourceDir.$assignMove(P.str().$string());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::~Driver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 86,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 84,
   FQN="clang::driver::Driver::~Driver", NM="_ZN5clang6driver6DriverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6DriverD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Opts != null) { Opts.$destroy();};
    
    llvm.DeleteContainerSeconds(ToolChains);
    //START JDestroy
    ToolChains.$destroy();
    ResultFiles.$destroy();
    TempFiles.$destroy();
    CCCGenericGCCName.$destroy();
    HostRelease.$destroy();
    HostSystem.$destroy();
    HostMachine.$destroy();
    HostBits.$destroy();
    DriverTitle.$destroy();
    DefaultTargetTriple.$destroy();
    DyldPrefix.$destroy();
    SysRoot.$destroy();
    PrefixDirs.$destroy();
    ResourceDir.$destroy();
    InstalledDir.$destroy();
    ClangExecutable.$destroy();
    Dir.$destroy();
    Name.$destroy();
    VFS.$destroy();
    //END JDestroy
  }

  
  /// @name Accessors
  /// @{
  
  /// Name to use when invoking gcc/g++.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getCCCGenericGCCName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 238,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 231,
   FQN="clang::driver::Driver::getCCCGenericGCCName", NM="_ZNK5clang6driver6Driver20getCCCGenericGCCNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver20getCCCGenericGCCNameEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getCCCGenericGCCName() /*const*/ {
    return CCCGenericGCCName;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 240,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 233,
   FQN="clang::driver::Driver::getOpts", NM="_ZNK5clang6driver6Driver7getOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver7getOptsEv")
  //</editor-fold>
  public /*const*/ OptTable /*&*/ getOpts() /*const*/ {
    return $Deref(Opts);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 235,
   FQN="clang::driver::Driver::getDiags", NM="_ZNK5clang6driver6Driver8getDiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver8getDiagsEv")
  //</editor-fold>
  public /*const*/ DiagnosticsEngine /*&*/ getDiags() /*const*/ {
    return Diags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getVFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 237,
   FQN="clang::driver::Driver::getVFS", NM="_ZNK5clang6driver6Driver6getVFSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver6getVFSEv")
  //</editor-fold>
  public FileSystem /*&*/ getVFS() /*const*/ {
    return VFS.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getCheckInputsExist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 239,
   FQN="clang::driver::Driver::getCheckInputsExist", NM="_ZNK5clang6driver6Driver19getCheckInputsExistEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver19getCheckInputsExistEv")
  //</editor-fold>
  public boolean getCheckInputsExist() /*const*/ {
    return CheckInputsExist;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::setCheckInputsExist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 248,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 241,
   FQN="clang::driver::Driver::setCheckInputsExist", NM="_ZN5clang6driver6Driver19setCheckInputsExistEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver19setCheckInputsExistEb")
  //</editor-fold>
  public void setCheckInputsExist(boolean Value) {
    CheckInputsExist = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getTitle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 250,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 243,
   FQN="clang::driver::Driver::getTitle", NM="_ZN5clang6driver6Driver8getTitleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver8getTitleEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getTitle() {
    return DriverTitle;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::setTitle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 244,
   FQN="clang::driver::Driver::setTitle", NM="_ZN5clang6driver6Driver8setTitleESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver8setTitleESs")
  //</editor-fold>
  public void setTitle(std.string Value) {
    DriverTitle.$assignMove(std.move(Value));
  }

  
  /// \brief Get the path to the main clang executable.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getClangProgramPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 247,
   FQN="clang::driver::Driver::getClangProgramPath", NM="_ZNK5clang6driver6Driver19getClangProgramPathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver19getClangProgramPathEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getClangProgramPath() /*const*/ {
    return ClangExecutable.c_str();
  }

  
  /// \brief Get the path to where the clang executable was installed.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getInstalledDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 259,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 252,
   FQN="clang::driver::Driver::getInstalledDir", NM="_ZNK5clang6driver6Driver15getInstalledDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver15getInstalledDirEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getInstalledDir() /*const*/ {
    if (!InstalledDir.empty()) {
      return InstalledDir.c_str();
    }
    return Dir.c_str();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::setInstalledDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 257,
   FQN="clang::driver::Driver::setInstalledDir", NM="_ZN5clang6driver6Driver15setInstalledDirEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver15setInstalledDirEN4llvm9StringRefE")
  //</editor-fold>
  public void setInstalledDir(StringRef Value) {
    InstalledDir.$assignMove(Value.$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::isSaveTempsEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 261,
   FQN="clang::driver::Driver::isSaveTempsEnabled", NM="_ZNK5clang6driver6Driver18isSaveTempsEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver18isSaveTempsEnabledEv")
  //</editor-fold>
  public boolean isSaveTempsEnabled() /*const*/ {
    return SaveTemps != SaveTempsMode.SaveTempsNone;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::isSaveTempsObj">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 269,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 262,
   FQN="clang::driver::Driver::isSaveTempsObj", NM="_ZNK5clang6driver6Driver14isSaveTempsObjEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver14isSaveTempsObjEv")
  //</editor-fold>
  public boolean isSaveTempsObj() /*const*/ {
    return SaveTemps == SaveTempsMode.SaveTempsObj;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::embedBitcodeEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 271,
   FQN="clang::driver::Driver::embedBitcodeEnabled", NM="_ZNK5clang6driver6Driver19embedBitcodeEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver19embedBitcodeEnabledEv")
  //</editor-fold>
  public boolean embedBitcodeEnabled() /*const*/ {
    return BitcodeEmbed == BitcodeEmbedMode.EmbedBitcode;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::embedBitcodeMarkerOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 272,
   FQN="clang::driver::Driver::embedBitcodeMarkerOnly", NM="_ZNK5clang6driver6Driver22embedBitcodeMarkerOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver22embedBitcodeMarkerOnlyEv")
  //</editor-fold>
  public boolean embedBitcodeMarkerOnly() /*const*/ {
    return BitcodeEmbed == BitcodeEmbedMode.EmbedMarker;
  }

  
  /// @}
  /// @name Primary Functionality
  /// @{
  
  /// CreateOffloadingDeviceToolChains - create all the toolchains required to
  /// support offloading devices given the programming models specified in the
  /// current compilation. Also, update the host tool chain kind accordingly.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::CreateOffloadingDeviceToolChains">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 426,
   FQN="clang::driver::Driver::CreateOffloadingDeviceToolChains", NM="_ZN5clang6driver6Driver32CreateOffloadingDeviceToolChainsERNS0_11CompilationERN4llvm11SmallVectorISt4pairINS0_5types2IDEPKNS4_3opt3ArgEELj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver32CreateOffloadingDeviceToolChainsERNS0_11CompilationERN4llvm11SmallVectorISt4pairINS0_5types2IDEPKNS4_3opt3ArgEELj16EEE")
  //</editor-fold>
  public void CreateOffloadingDeviceToolChains(final Compilation /*&*/ C, 
                                  final SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> /*&*/ Inputs) {
    
    //
    // CUDA
    //
    // We need to generate a CUDA toolchain if any of the inputs has a CUDA type.
    if (llvm.any_of(Inputs, /*[]*/ (final std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ > /*&*/ I) -> {
              return types.isCuda(I.first);
            })) {
      final /*const*/ ToolChain /*&*/ TC = getToolChain(C.getInputArgs(), 
          new Triple(new Twine(C./*<Action.OffloadKind.OFK_Host>*/getSingleOffloadToolChain(Action.OffloadKind.OFK_Host).
                      getTriple().
                      isArch64Bit() ? $("nvptx64-nvidia-cuda") : $("nvptx-nvidia-cuda"))));
      C.addOffloadDeviceToolChain($AddrOf(TC), Action.OffloadKind.OFK_Cuda);
    }
    
    //
    // TODO: Add support for other offloading programming models here.
    //
    return;
  }

  
  /// BuildCompilation - Construct a compilation object for a command
  /// line argument vector.
  ///
  /// \return A compilation, or 0 if none was built for the given
  /// argument vector. A null return value does not necessarily
  /// indicate an error condition, the diagnostics should be queried
  /// to determine if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildCompilation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 453,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 397,
   FQN="clang::driver::Driver::BuildCompilation", NM="_ZN5clang6driver6Driver16BuildCompilationEN4llvm8ArrayRefIPKcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver16BuildCompilationEN4llvm8ArrayRefIPKcEE")
  //</editor-fold>
  public Compilation /*P*/ BuildCompilation(ArrayRef</*const*/char$ptr/*char P*/ > ArgList) {
    PrettyStackTraceString CrashInfo = null;
    InputArgList Args = null;
    std.unique_ptr<InputArgList> UArgs = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Compilation construction"));
      {
        
        // FIXME: Handle environment options which affect driver behavior, somewhere
        // (client?). GCC_EXEC_PREFIX, LPATH, CC_PRINT_OPTIONS.
        char$ptr/*char P*/ env = $tryClone(/*::*/getenv($("COMPILER_PATH")));
        if ((env != null)) {
          StringRef CompilerPath = new StringRef(env);
          while (!CompilerPath.empty()) {
            std.pairTypeType<StringRef, StringRef> Split = CompilerPath.split(sys.EnvPathSeparator);
            PrefixDirs.push_back_T$RR(Split.first.$string());
            CompilerPath.$assign(Split.second);
          }
        }
      }
      
      // We look for the driver mode option early, because the mode can affect
      // how other options are parsed.
      ParseDriverMode(ArgList.slice(1));
      
      // FIXME: What are we going to do with -V and -b?
      
      // FIXME: This stuff needs to go into the Compilation, not the driver.
      boolean CCCPrintPhases;
      
      Args = ParseArgStrings(ArgList.slice(1));
      
      // Silence driver warnings if requested
      Diags.setIgnoreAllWarnings(Args.hasArg(new OptSpecifier(options.ID.OPT_w.getValue())));
      
      // -no-canonical-prefixes is used very early in main.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_no_canonical_prefixes.getValue()));
      
      // Ignore -pipe.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_pipe.getValue()));
      
      // Extract -ccc args.
      //
      // FIXME: We need to figure out where this behavior should live. Most of it
      // should be outside in the client; the parts that aren't should have proper
      // options, either by introducing new ones or by overloading gcc ones like -V
      // or -b.
      CCCPrintPhases = Args.hasArg(new OptSpecifier(options.ID.OPT_ccc_print_phases.getValue()));
      CCCPrintBindings = Args.hasArg(new OptSpecifier(options.ID.OPT_ccc_print_bindings.getValue()));
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ccc_gcc_name.getValue()));
        if ((A != null)) {
          CCCGenericGCCName.$assign_T$C$P(A.getValue());
        }
      }
      CCCUsePCH
         = Args.hasFlag(new OptSpecifier(options.ID.OPT_ccc_pch_is_pch.getValue()), new OptSpecifier(options.ID.OPT_ccc_pch_is_pth.getValue()));
      // FIXME: DefaultTargetTriple is used by the target-prefixed calls to as/ld
      // and getToolChain is const.
      if (IsCLMode()) {
        // clang-cl targets MSVC-style Win32.
        Triple T/*J*/= new Triple(new Twine(DefaultTargetTriple));
        T.setOS(Triple.OSType.Win32);
        T.setVendor(Triple.VendorType.PC);
        T.setEnvironment(Triple.EnvironmentType.MSVC);
        DefaultTargetTriple.$assign(T.str());
      }
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_target.getValue()));
        if ((A != null)) {
          DefaultTargetTriple.$assign_T$C$P(A.getValue());
        }
      }
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ccc_install_dir.getValue()));
        if ((A != null)) {
          Dir.$assign(InstalledDir.$assign_T$C$P(A.getValue()));
        }
      }
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_B.getValue()))) {
        A.claim();
        PrefixDirs.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, A.getValue(0)));
      }
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__sysroot_EQ.getValue()));
        if ((A != null)) {
          SysRoot.$assign_T$C$P(A.getValue());
        }
      }
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__dyld_prefix_EQ.getValue()));
        if ((A != null)) {
          DyldPrefix.$assign_T$C$P(A.getValue());
        }
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))) {
        UseStdLib = false;
      }
      {
        
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_resource_dir.getValue()));
        if ((A != null)) {
          ResourceDir.$assign_T$C$P(A.getValue());
        }
      }
      {
        
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_save_temps_EQ.getValue()));
        if ((A != null)) {
          SaveTemps = new StringSwitch<SaveTempsMode>(/*STRINGREF_STR*/A.getValue()).
              Case(/*KEEP_STR*/"cwd", SaveTempsMode.SaveTempsCwd).
              Case(/*KEEP_STR*/"obj", SaveTempsMode.SaveTempsObj).
              Default(SaveTempsMode.SaveTempsCwd);
        }
      }
      
      setLTOMode(Args);
      
      // Ignore -fembed-bitcode options with LTO
      // since the output will be bitcode anyway.
      if (getLTOMode() == LTOKind.LTOK_None) {
        {
          Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fembed_bitcode_EQ.getValue()));
          if ((A != null)) {
            StringRef Name = new StringRef(A.getValue());
            /*uint*/int Model = new StringSwitchUInt(/*NO_COPY*/Name).
                Case(/*KEEP_STR*/"off", BitcodeEmbedMode.EmbedNone.getValue()).
                Case(/*KEEP_STR*/"all", BitcodeEmbedMode.EmbedBitcode.getValue()).
                Case(/*KEEP_STR*/"bitcode", BitcodeEmbedMode.EmbedBitcode.getValue()).
                Case(/*KEEP_STR*/"marker", BitcodeEmbedMode.EmbedMarker.getValue()).
                Default(~0/*U*/);
            if (Model == ~0/*U*/) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), 
                    /*NO_COPY*/Name));
              } finally {
                $c$.$destroy();
              }
            } else {
              BitcodeEmbed = /*static_cast*/BitcodeEmbedMode.valueOf(Model);
            }
          }
        }
      } else {
        // claim the bitcode option under LTO so no warning is issued.
        Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fembed_bitcode_EQ.getValue()));
      }
      
      UArgs = llvm.make_unique(new InputArgList(JD$Move.INSTANCE, std.move(Args)));
      
      // Perform the default argument translations.
      DerivedArgList /*P*/ TranslatedArgs = TranslateInputArgs(UArgs.$star());
      
      // Owned by the host.
      final /*const*/ ToolChain /*&*/ TC = getToolChain(UArgs.$star(), DriverStatics.computeTargetTriple(/*Deref*/this, new StringRef(DefaultTargetTriple), UArgs.$star()));
      
      // The compilation takes ownership of Args.
      Compilation /*P*/ C = new Compilation(/*Deref*/this, TC, UArgs.release(), TranslatedArgs);
      if (!HandleImmediateArgs($Deref(C))) {
        return C;
      }
      
      // Construct the list of inputs.
      SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> Inputs/*J*/= new SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >>(16, new std.pairTypePtr(types.ID.TY_INVALID, null));
      BuildInputs(C.getDefaultToolChain(), $Deref(TranslatedArgs), Inputs);
      
      // Populate the tool chains for the offloading devices, if any.
      CreateOffloadingDeviceToolChains($Deref(C), Inputs);
      
      // Construct the list of abstract actions to perform for this compilation. On
      // MachO targets this uses the driver-driver and universal actions.
      if (TC.getTriple().isOSBinFormatMachO()) {
        BuildUniversalActions($Deref(C), C.getDefaultToolChain(), Inputs);
      } else {
        BuildActions($Deref(C), C.getArgs(), Inputs, C.getActions());
      }
      if (CCCPrintPhases) {
        PrintActions($Deref(C));
        return C;
      }
      
      BuildJobs($Deref(C));
      
      return C;
    } finally {
      if (UArgs != null) { UArgs.$destroy(); }
      if (Args != null) { Args.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// @name Driver Steps
  /// @{
  
  /// ParseDriverMode - Look for and handle the driver mode option in Args.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::ParseDriverMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 90,
   FQN="clang::driver::Driver::ParseDriverMode", NM="_ZN5clang6driver6Driver15ParseDriverModeEN4llvm8ArrayRefIPKcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver15ParseDriverModeEN4llvm8ArrayRefIPKcEE")
  //</editor-fold>
  public void ParseDriverMode(ArrayRef</*const*/char$ptr/*char P*/ > Args) {
    /*const*/std.string OptName = getOpts().getOption(new OptSpecifier(options.ID.OPT_driver_mode.getValue())).getPrefixedName();
    
    for (/*const*/char$ptr/*char P*/ ArgPtr : Args) {
      // Ingore nullptrs, they are response file's EOL markers
      if ($eq_ptr(ArgPtr, null)) {
        continue;
      }
      /*const*/ StringRef Arg = new StringRef(ArgPtr);
      if (!Arg.startswith(new StringRef(OptName))) {
        continue;
      }
      
      /*const*/ StringRef Value = Arg.drop_front(OptName.size());
      /*const*//*uint*/int M = new StringSwitchUInt(/*NO_COPY*/Value).
          Case(/*KEEP_STR*/"gcc", DriverMode.GCCMode.getValue()).
          Case(/*KEEP_STR*/"g++", DriverMode.GXXMode.getValue()).
          Case(/*KEEP_STR*/"cpp", DriverMode.CPPMode.getValue()).
          Case(/*KEEP_STR*/"cl", DriverMode.CLMode.getValue()).
          Default(~0/*U*/);
      if (M != ~0/*U*/) {
        Mode = /*static_cast*/DriverMode.valueOf(M);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_unsupported_option_argument)), new StringRef(OptName)), /*NO_COPY*/Value));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  /// ParseArgStrings - Parse the given list of strings into an
  /// ArgList.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::ParseArgStrings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 119,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 117,
   FQN="clang::driver::Driver::ParseArgStrings", NM="_ZN5clang6driver6Driver15ParseArgStringsEN4llvm8ArrayRefIPKcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver15ParseArgStringsEN4llvm8ArrayRefIPKcEE")
  //</editor-fold>
  public InputArgList ParseArgStrings(ArrayRef</*const*/char$ptr/*char P*/ > ArgStrings) {
    PrettyStackTraceString CrashInfo = null;
    InputArgList Args = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Command line argument parsing"));
      
      // JAVA: decompose std::tie
      pairUIntUInt includeExcludeOptionFlagMasks = getIncludeExcludeOptionFlagMasks();
      /*uint*/int IncludedFlagsBitmask = includeExcludeOptionFlagMasks.first;
      /*uint*/int ExcludedFlagsBitmask = includeExcludeOptionFlagMasks.second;
      // std.tie(IncludedFlagsBitmask, ExcludedFlagsBitmask).$assign(getIncludeExcludeOptionFlagMasks());
      
      uint$ref MissingArgIndex = create_uint$ref(0), MissingArgCount = create_uint$ref(0);
      Args = getOpts().ParseArgs(new ArrayRef</*const*/char$ptr/*char P*/ >(ArgStrings), MissingArgIndex, MissingArgCount, 
          IncludedFlagsBitmask, ExcludedFlagsBitmask);
      
      // Check for missing argument error.
      if ((MissingArgCount.$deref() != 0)) {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.err_drv_missing_argument)), 
                Args.getArgString(MissingArgIndex.$deref())), MissingArgCount.$deref()));
      }
      
      // Check for unsupported options.
      for (/*const*/ Arg /*P*/ A : Args) {
        if (A.getOption().hasFlag(options.ClangFlags.Unsupported)) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_unsupported_opt)), new StringRef(A.getAsString(Args))));
          continue;
        }
        
        // Warn about -mcpu= without an argument.
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue())) && A.containsValue(new StringRef(/*KEEP_STR*/$EMPTY))) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_empty_joined_argument)), new StringRef(A.getAsString(Args))));
        }
      }
      
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_UNKNOWN.getValue())))  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(IsCLMode() ? diag.warn_drv_unknown_argument_clang_cl : diag.err_drv_unknown_argument)), 
            new StringRef(A.getAsString(Args))));
      }
      
      return new InputArgList(JD$Move.INSTANCE, Args);
    } finally {
      if (Args != null) { Args.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// BuildInputs - Construct the list of inputs and their types from 
  /// the given arguments.
  ///
  /// \param TC - The default host tool chain.
  /// \param Args - The input arguments.
  /// \param Inputs - The list to store the resulting compilation 
  /// inputs onto.
  
  // Construct a the list of inputs and their types.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildInputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1238,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 1123,
   FQN="clang::driver::Driver::BuildInputs", NM="_ZNK5clang6driver6Driver11BuildInputsERKNS0_9ToolChainERN4llvm3opt14DerivedArgListERNS5_11SmallVectorISt4pairINS0_5types2IDEPKNS6_3ArgEELj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver11BuildInputsERKNS0_9ToolChainERN4llvm3opt14DerivedArgListERNS5_11SmallVectorISt4pairINS0_5types2IDEPKNS6_3ArgEELj16EEE")
  //</editor-fold>
  public void BuildInputs(final /*const*/ ToolChain /*&*/ TC, final DerivedArgList /*&*/ Args, 
             final SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> /*&*/ Inputs) /*const*/ {
    // Track the current user specified (-x) input. We also explicitly track the
    // argument used to set the type; we only want to claim the type when we
    // actually use it, so we warn about unused -x arguments.
    types.ID InputType = types.ID.TY_Nothing;
    Arg /*P*/ InputTypeArg = null;
    {
      
      // The last /TC or /TP option sets the input type to C or C++ globally.
      Arg /*P*/ TCTP = Args.getLastArgNoClaim(new OptSpecifier(options.ID.OPT__SLASH_TC.getValue()), 
          new OptSpecifier(options.ID.OPT__SLASH_TP.getValue()));
      if ((TCTP != null)) {
        InputTypeArg = TCTP;
        InputType = TCTP.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_TC.getValue())) ? types.ID.TY_C : types.ID.TY_CXX;
        
        arg_iterator it = Args.filtered_begin(new OptSpecifier(options.ID.OPT__SLASH_TC.getValue()), new OptSpecifier(options.ID.OPT__SLASH_TP.getValue()));
        /*const*/ arg_iterator ie = Args.filtered_end();
        Arg /*P*/ Previous = it.$postInc().$star();
        boolean ShowNote = false;
        while (arg_iterator.$noteq_arg_iterator(/*NO_COPY*/it, /*NO_COPY*/ie)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_overriding_flag_option)), 
                    Previous.getSpelling()), (it.$star()).getSpelling()));
            Previous = it.$postInc().$star();
            ShowNote = true;
          } finally {
            $c$.$destroy();
          }
        }
        if (ShowNote) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diag(diag.note_drv_t_option_is_global)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // No driver mode exposes -x and /TC or /TP; we don't support mixing them.
        assert (!Args.hasArg(new OptSpecifier(options.ID.OPT_x.getValue()))) : "-x and /TC or /TP is not allowed";
      }
    }
    
    for (Arg /*P*/ A : Args) {
      if (A.getOption().getKind() == Option.OptionClass.InputClass) {
        /*const*/char$ptr/*char P*/ Value = $tryClone(A.getValue());
        types.ID Ty = types.ID.TY_INVALID;
        
        // Infer the input type if necessary.
        if (InputType == types.ID.TY_Nothing) {
          // If there was an explicit arg for this, claim it.
          if ((InputTypeArg != null)) {
            InputTypeArg.claim();
          }
          
          // stdin must be handled specially.
          if (memcmp(Value, $MINUS, 2) == 0) {
            // If running with -E, treat as a C input (this changes the builtin
            // macros, for example). This may be overridden by -ObjC below.
            //
            // Otherwise emit an error but still use a valid type to avoid
            // spurious errors (e.g., no inputs).
            if (!Args.hasArgNoClaim(new OptSpecifier(options.ID.OPT_E.getValue())) && !CCCIsCPP()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(Diag(IsCLMode() ? diag.err_drv_unknown_stdin_type_clang_cl : diag.err_drv_unknown_stdin_type)));
              } finally {
                $c$.$destroy();
              }
            }
            Ty = types.ID.TY_C;
          } else {
            {
              // Otherwise lookup by extension.
              // Fallback is C if invoked as C preprocessor or Object otherwise.
              // We use a host hook here because Darwin at least has its own
              // idea of what .s is.
              /*const*/char$ptr/*char P*/ Ext = $tryClone(strrchr(Value, $$DOT));
              if ((Ext != null)) {
                Ty = TC.LookupTypeForExtension(Ext.$add(1));
              }
            }
            if (Ty == types.ID.TY_INVALID) {
              if (CCCIsCPP()) {
                Ty = types.ID.TY_C;
              } else {
                Ty = types.ID.TY_Object;
              }
            }
            
            // If the driver is invoked as C++ compiler (like clang++ or c++) it
            // should autodetect some input files as C++ for g++ compatibility.
            if (CCCIsCXX()) {
              types.ID OldTy = Ty;
              Ty = types.lookupCXXTypeForCType(Ty);
              if (Ty != OldTy) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.warn_drv_treating_input_as_cxx)), 
                          getTypeName(OldTy)), getTypeName(Ty)));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          
          // -ObjC and -ObjC++ override the default language, but only for "source
          // files". We just treat everything that isn't a linker input as a
          // source file.
          //
          // FIXME: Clean this up if we move the phase sequence into the type.
          if (Ty != types.ID.TY_Object) {
            if (Args.hasArg(new OptSpecifier(options.ID.OPT_ObjC.getValue()))) {
              Ty = types.ID.TY_ObjC;
            } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_ObjCXX.getValue()))) {
              Ty = types.ID.TY_ObjCXX;
            }
          }
        } else {
          assert ((InputTypeArg != null)) : "InputType set w/o InputTypeArg";
          if (!InputTypeArg.getOption().matches(new OptSpecifier(options.ID.OPT_x.getValue()))) {
            // If emulating cl.exe, make sure that /TC and /TP don't affect input
            // object files.
            /*const*/char$ptr/*char P*/ Ext = $tryClone(strrchr(Value, $$DOT));
            if ((Ext != null) && TC.LookupTypeForExtension(Ext.$add(1)) == types.ID.TY_Object) {
              Ty = types.ID.TY_Object;
            }
          }
          if (Ty == types.ID.TY_INVALID) {
            Ty = InputType;
            InputTypeArg.claim();
          }
        }
        if (DriverStatics.DiagnoseInputExistence(/*Deref*/this, Args, new StringRef(Value), Ty)) {
          Inputs.push_back(new std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Ty, /*Fwd2*//*Fwd*/A));
        }
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_Tc.getValue()))) {
        StringRef Value = new StringRef(A.getValue());
        if (DriverStatics.DiagnoseInputExistence(/*Deref*/this, Args, new StringRef(Value), types.ID.TY_C)) {
          Arg /*P*/ InputArg = DriverStatics.MakeInputArg(Args, Opts, new StringRef(A.getValue()));
          Inputs.push_back(new std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/types.ID.TY_C, /*Fwd2*//*Fwd*/InputArg));
        }
        A.claim();
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_Tp.getValue()))) {
        StringRef Value = new StringRef(A.getValue());
        if (DriverStatics.DiagnoseInputExistence(/*Deref*/this, Args, new StringRef(Value), types.ID.TY_CXX)) {
          Arg /*P*/ InputArg = DriverStatics.MakeInputArg(Args, Opts, new StringRef(A.getValue()));
          Inputs.push_back(new std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/types.ID.TY_CXX, /*Fwd2*//*Fwd*/InputArg));
        }
        A.claim();
      } else if (A.getOption().hasFlag(options.ClangFlags.LinkerInput)) {
        // Just treat as object type, we could make a special type for this if
        // necessary.
        Inputs.push_back(new std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/types.ID.TY_Object, /*Fwd2*//*Fwd*/A));
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_x.getValue()))) {
        InputTypeArg = A;
        InputType = types.lookupTypeForTypeSpecifier(A.getValue());
        A.claim();
        
        // Follow gcc behavior and treat as linker input for invalid -x
        // options. Its not clear why we shouldn't just revert to unknown; but
        // this isn't very important, we might as well be bug compatible.
        if (!(InputType.getValue() != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.err_drv_unknown_language)), A.getValue()));
            InputType = types.ID.TY_Object;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (CCCIsCPP() && Inputs.empty()) {
      // If called as standalone preprocessor, stdin is processed
      // if no other input is present.
      Arg /*P*/ A = DriverStatics.MakeInputArg(Args, Opts, StringRef.R$MINUS);
      Inputs.push_back(new std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/types.ID.TY_C, /*Fwd2*//*Fwd*/A));
    }
  }

  
  /// BuildActions - Construct the list of actions to perform for the
  /// given arguments, which are only done for a single architecture.
  ///
  /// \param C - The compilation that is being built.
  /// \param Args - The input arguments.
  /// \param Actions - The list to store the resulting actions onto.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildActions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1518,
   FQN="clang::driver::Driver::BuildActions", NM="_ZNK5clang6driver6Driver12BuildActionsERNS0_11CompilationERN4llvm3opt14DerivedArgListERKNS4_11SmallVectorISt4pairINS0_5types2IDEPKNS5_3ArgEELj16EEERNS8_IPNS0_6ActionELj3EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver12BuildActionsERNS0_11CompilationERN4llvm3opt14DerivedArgListERKNS4_11SmallVectorISt4pairINS0_5types2IDEPKNS5_3ArgEELj16EEERNS8_IPNS0_6ActionELj3EEE")
  //</editor-fold>
  public void BuildActions(final Compilation /*&*/ C, final DerivedArgList /*&*/ Args, 
              final /*const*/SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> /*&*/ Inputs, final /*ActionList*/SmallVector<Action /*P*/>/*&*/ Actions) /*const*/ {
    PrettyStackTraceString CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Building compilation actions"));
      if (!SuppressMissingInputWarning && Inputs.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diag(diag.err_drv_no_input_files)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      type$ptr<Arg /*P*/ > FinalPhaseArg = create_type$null$ptr();
      phases.ID FinalPhase = getFinalPhase(Args, $AddrOf(FinalPhaseArg));
      if (FinalPhase == phases.ID.Link && Args.hasArg(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diag(diag.err_drv_emit_llvm_link)));
        } finally {
          $c$.$destroy();
        }
      }
      {
        
        // Reject -Z* at the top level, these options should never have been exposed
        // by gcc.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_Z_Joined.getValue()));
        if ((A != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_use_of_Z_option)), new StringRef(A.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      {
        
        // Diagnose misuse of /Fo.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Fo.getValue()));
        if ((A != null)) {
          StringRef V = new StringRef(A.getValue());
          if ($greater_uint(Inputs.size(), 1) && !V.empty()
             && !path.is_separator(V.back())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Check whether /Fo tries to name an output file for multiple inputs.
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_out_file_argument_with_multiple_sources)), 
                      A.getSpelling()), /*NO_COPY*/V));
              Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Fo.getValue()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      {
        
        // Diagnose misuse of /Fa.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Fa.getValue()));
        if ((A != null)) {
          StringRef V = new StringRef(A.getValue());
          if ($greater_uint(Inputs.size(), 1) && !V.empty()
             && !path.is_separator(V.back())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Check whether /Fa tries to name an asm file for multiple inputs.
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_out_file_argument_with_multiple_sources)), 
                      A.getSpelling()), /*NO_COPY*/V));
              Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Fa.getValue()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      {
        
        // Diagnose misuse of /o.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_o.getValue()));
        if ((A != null)) {
          if (A.getValue().$at(0) == $$TERM) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // It has to have a value.
              $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_missing_argument)), A.getSpelling()), 1));
              Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_o.getValue()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      // Diagnose unsupported forms of /Yc /Yu. Ignore /Yc/Yu for now if:
      // * no filename after it
      // * both /Yc and /Yu passed but with different filenames
      // * corresponding file not also passed as /FI
      Arg /*P*/ YcArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
      Arg /*P*/ YuArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Yu.getValue()));
      if ((YcArg != null) && YcArg.getValue().$at(0) == $$TERM) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_ycyu_no_arg_clang_cl)), YcArg.getSpelling()));
          Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
          YcArg = null;
        } finally {
          $c$.$destroy();
        }
      }
      if ((YuArg != null) && YuArg.getValue().$at(0) == $$TERM) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_ycyu_no_arg_clang_cl)), YuArg.getSpelling()));
          Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yu.getValue()));
          YuArg = null;
        } finally {
          $c$.$destroy();
        }
      }
      if ((YcArg != null) && (YuArg != null) && strcmp(YcArg.getValue(), YuArg.getValue()) != 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diag(diag.warn_drv_ycyu_different_arg_clang_cl)));
          Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
          Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yu.getValue()));
          YcArg = YuArg = null;
        } finally {
          $c$.$destroy();
        }
      }
      if ((YcArg != null) || (YuArg != null)) {
        StringRef Val = new StringRef((YcArg != null) ? YcArg.getValue() : YuArg.getValue());
        boolean FoundMatchingInclude = false;
        for (/*const*/ Arg /*P*/ Inc : Args.filtered(new OptSpecifier(options.ID.OPT_include.getValue()))) {
          // FIXME: Do case-insensitive matching and consider / and \ as equal.
          if ($eq_StringRef(/*STRINGREF_STR*/Inc.getValue(), /*NO_COPY*/Val)) {
            FoundMatchingInclude = true;
          }
        }
        if (!FoundMatchingInclude) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_ycyu_no_fi_arg_clang_cl)), 
                ((YcArg != null) ? YcArg : YuArg).getSpelling()));
            Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
            Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yu.getValue()));
            YcArg = YuArg = null;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if ((YcArg != null) && $greater_uint(Inputs.size(), 1)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diag(diag.warn_drv_yc_multiple_inputs_clang_cl)));
          Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
          YcArg = null;
        } finally {
          $c$.$destroy();
        }
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_Y_.getValue()))) {
        // /Y- disables all pch handling.  Rather than check for it everywhere,
        // just remove clang-cl pch-related flags here.
        Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Fp.getValue()));
        Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
        Args.eraseArg(new OptSpecifier(options.ID.OPT__SLASH_Yu.getValue()));
        YcArg = YuArg = null;
      }
      
      // Track the host offload kinds used on this compilation.
      /*uint*/int CompilationActiveOffloadHostKinds = 0/*U*/;
      
      // Construct the actions to perform.
      /*ActionList*/SmallVector<Action /*P*/> LinkerInputs/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
      
      SmallVector<phases.ID>/*<phases.MaxNumberOfPhases>*/ PL/*J*/= new SmallVector<phases.ID>/*<phases.MaxNumberOfPhases>*/(phases.MaxNumberOfPhases);
      for (final /*constconst*/std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ > /*&*/ I : Inputs) {
        types.ID InputType = I.first;
        /*const*/ Arg /*P*/ InputArg = I.second;
        
        PL.clear();
        types.getCompilationPhases(InputType, PL);
        
        // If the first step comes after the final phase we are doing as part of
        // this compilation, warn the user about it.
        phases.ID InitialPhase = PL.$at(0);
        if (InitialPhase.getValue() > FinalPhase.getValue()) {
          // Claim here to avoid the more general unused warning.
          InputArg.claim();
          
          // Suppress all unused style warnings with -Qunused-arguments
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_Qunused_arguments.getValue()))) {
            continue;
          }
          
          // Special case when final phase determined by binary name, rather than
          // by a command-line argument with a corresponding Arg.
          if (CCCIsCPP()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_input_file_unused_by_cpp)), 
                      new StringRef(InputArg.getAsString(Args))), getPhaseName(InitialPhase)));
            } finally {
              $c$.$destroy();
            }
          } else // Special case '-E' warning on a previously preprocessed file to make
          // more sense.
          if (InitialPhase == phases.ID.Compile
             && FinalPhase == phases.ID.Preprocess
             && getPreprocessedType(InputType) == types.ID.TY_INVALID) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_preprocessed_input_file_unused)), 
                          new StringRef(InputArg.getAsString(Args))), !!(FinalPhaseArg.$star() != null)), 
                  ((FinalPhaseArg.$star() != null) ? FinalPhaseArg.$star().getOption().getName() : new StringRef(/*KEEP_STR*/$EMPTY))));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_input_file_unused)), 
                              new StringRef(InputArg.getAsString(Args))), getPhaseName(InitialPhase)), 
                      !!(FinalPhaseArg.$star() != null)), 
                  ((FinalPhaseArg.$star() != null) ? FinalPhaseArg.$star().getOption().getName() : new StringRef(/*KEEP_STR*/$EMPTY))));
            } finally {
              $c$.$destroy();
            }
          }
          continue;
        }
        if ((YcArg != null)) {
          // Add a separate precompile phase for the compile phase.
          if (FinalPhase.getValue() >= phases.ID.Compile.getValue()) {
            SmallVector<phases.ID>/*<phases.MaxNumberOfPhases>*/ PCHPL/*J*/= new SmallVector<phases.ID>/*<phases.MaxNumberOfPhases>*/(phases.MaxNumberOfPhases);
            types.getCompilationPhases(types.ID.TY_CXXHeader, PCHPL);
            Arg /*P*/ PchInputArg = DriverStatics.MakeInputArg(Args, Opts, new StringRef(YcArg.getValue()));
            
            // Build the pipeline for the pch file.
            Action /*P*/ ClangClPch = C.MakeAction(new InputAction(/*Deref*/PchInputArg, InputType));
            for (phases.ID Phase : PCHPL)  {
              ClangClPch = ConstructPhaseAction(C, Args, Phase, ClangClPch);
            }
            assert (ClangClPch != null);
            Actions.push_back(ClangClPch);
            // The driver currently exits after the first failed command.  This
            // relies on that behavior, to make sure if the pch generation fails,
            // the main compilation won't run.
          }
        }
        
        phases.ID CudaInjectionPhase = (phases.ID.Compile.getValue() < FinalPhase.getValue()
           && llvm.find(PL, /*KEEP_ENUM*/phases.ID.Compile).$noteq(PL.end())) ? phases.ID.Compile : FinalPhase;
        
        // Track the host offload kinds used on this input.
        /*uint*/int InputActiveOffloadHostKinds = 0/*U*/;
        
        // Build the pipeline for this file.
        Action /*P*/ Current = C.MakeAction(new InputAction(/*Deref*/InputArg, InputType));
        for (type$ptr<phases.ID> i = PL.begin(), e = PL.end();
             $noteq_ptr(i, e); i.$preInc()) {
          phases.ID Phase = i.$star();
          
          // We are done if this step is past what the user requested.
          if (Phase.getValue() > FinalPhase.getValue()) {
            break;
          }
          
          // Queue linker inputs.
          if (Phase == phases.ID.Link) {
            assert ($eq_ptr((i.$add(1)), e)) : "linking must be final compilation step.";
            LinkerInputs.push_back(Current);
            Current = null;
            break;
          }
          
          // Some types skip the assembler phase (e.g., llvm-bc), but we can't
          // encode this in the steps because the intermediate type depends on
          // arguments. Just special case here.
          if (Phase == phases.ID.Assemble && Current.getType() != types.ID.TY_PP_Asm) {
            continue;
          }
          
          // Otherwise construct the appropriate action.
          Current = ConstructPhaseAction(C, Args, Phase, Current);
          if (InputType == types.ID.TY_CUDA && Phase == CudaInjectionPhase) {
            Current = DriverStatics.buildCudaActions(C, Args, InputArg, Current, Actions);
            if (!(Current != null)) {
              break;
            }
            
            // We produced a CUDA action for this input, so the host has to support
            // CUDA.
            InputActiveOffloadHostKinds |= Action.OffloadKind.OFK_Cuda;
            CompilationActiveOffloadHostKinds |= Action.OffloadKind.OFK_Cuda;
          }
          if (Current.getType() == types.ID.TY_Nothing) {
            break;
          }
        }
        
        // If we ended with something, add to the output list. Also, propagate the
        // offload information to the top-level host action related with the current
        // input.
        if ((Current != null)) {
          if ((InputActiveOffloadHostKinds != 0)) {
            Current.propagateHostOffloadInfo(InputActiveOffloadHostKinds, 
                /*BoundArch=*/ (/*const*/char$ptr/*char P*/ )null);
          }
          Actions.push_back(Current);
        }
      }
      
      // Add a link action if necessary and propagate the offload information for
      // the current compilation.
      if (!LinkerInputs.empty()) {
        Actions.push_back(C.MakeAction(new LinkJobAction(LinkerInputs, types.ID.TY_Image)));
        Actions.back().propagateHostOffloadInfo(CompilationActiveOffloadHostKinds, 
            /*BoundArch=*/ (/*const*/char$ptr/*char P*/ )null);
      }
      
      // If we are linking, claim any options which are obviously only used for
      // compilation.
      if (FinalPhase == phases.ID.Link && PL.size() == 1) {
        Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_CompileOnly_Group.getValue()));
        Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_cl_compile_Group.getValue()));
      }
      
      // Claim ignored clang-cl options.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_cl_ignored_Group.getValue()));
      
      // Claim --cuda-host-only and --cuda-compile-host-device, which may be passed
      // to non-CUDA compilations and should not trigger warnings there.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_cuda_host_only.getValue()));
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_cuda_compile_host_device.getValue()));
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// BuildUniversalActions - Construct the list of actions to perform
  /// for the given arguments, which may require a universal build.
  ///
  /// \param C - The compilation that is being built.
  /// \param TC - The default host tool chain.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildUniversalActions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1110,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 1004,
   FQN="clang::driver::Driver::BuildUniversalActions", NM="_ZNK5clang6driver6Driver21BuildUniversalActionsERNS0_11CompilationERKNS0_9ToolChainERKN4llvm11SmallVectorISt4pairINS0_5types2IDEPKNS7_3opt3ArgEELj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver21BuildUniversalActionsERNS0_11CompilationERKNS0_9ToolChainERKN4llvm11SmallVectorISt4pairINS0_5types2IDEPKNS7_3opt3ArgEELj16EEE")
  //</editor-fold>
  public void BuildUniversalActions(final Compilation /*&*/ C, final /*const*/ ToolChain /*&*/ TC, 
                       final /*const*/SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> /*&*/ BAInputs) /*const*/ {
    PrettyStackTraceString CrashInfo = null;
    StringSet/*<MallocAllocator>*/ ArchNames = null;
    try {
      final DerivedArgList /*&*/ Args = C.getArgs();
      final /*ActionList*/SmallVector<Action /*P*/>/*&*/ Actions = C.getActions();
      CrashInfo/*J*/= new PrettyStackTraceString($("Building universal build actions"));
      // Collect the list of architectures. Duplicates are allowed, but should only
      // be handled once (in the order seen).
      ArchNames/*J*/= new StringSet/*<MallocAllocator>*/();
      SmallVector</*const*/char$ptr/*char P*//*,  4*/> Archs/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  4*/>(4, null);
      for (Arg /*P*/ A : Args) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_arch.getValue()))) {
          // Validate the option here; we don't save the type here because its
          // particular spelling may participate in other driver choices.
          Triple.ArchType Arch = DarwinStatics.getArchTypeForMachOArchName(new StringRef(A.getValue()));
          if (Arch == Triple.ArchType.UnknownArch) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_invalid_arch_name)), new StringRef(A.getAsString(Args))));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          
          A.claim();
          if (ArchNames.insert(new StringRef(A.getValue())).second) {
            Archs.push_back(A.getValue());
          }
        }
      }
      
      // When there is no explicit arch for this platform, make sure we still bind
      // the architecture (to the default) so that -Xarch_ is handled correctly.
      if (!(Archs.size() != 0)) {
        Archs.push_back(Args.MakeArgString(new Twine(TC.getDefaultUniversalArchName())));
      }
      
      /*ActionList*/SmallVector<Action /*P*/> SingleActions/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
      BuildActions(C, Args, BAInputs, SingleActions);
      
      // Add in arch bindings for every top level action, as well as lipo and
      // dsymutil steps if needed.
      for (Action /*P*/ Act : SingleActions) {
        // Make sure we can lipo this kind of output. If not (and it is an actual
        // output) then we disallow, since we can't create an output file with the
        // right name without overwriting it. We could remove this oddity by just
        // changing the output names to include the arch, which would also fix
        // -save-temps. Compatibility wins for now.
        if ($greater_uint(Archs.size(), 1) && !types.canLipoType(Act.getType())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.err_drv_invalid_output_with_multiple_archs)), 
                types.getTypeName(Act.getType())));
          } finally {
            $c$.$destroy();
          }
        }
        
        /*ActionList*/SmallVector<Action /*P*/> Inputs/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
        for (/*uint*/int i = 0, e = Archs.size(); i != e; ++i)  {
          Inputs.push_back(C.MakeAction(new BindArchAction(Act, Archs.$at(i))));
        }
        
        // Lipo if necessary, we do it this way because we need to set the arch flag
        // so that -Xarch_ gets overwritten.
        if (Inputs.size() == 1 || Act.getType() == types.ID.TY_Nothing) {
          Actions.append_T(Inputs.begin(), Inputs.end());
        } else {
          Actions.push_back(C.MakeAction(new LipoJobAction(Inputs, Act.getType())));
        }
        
        // Handle debug info queries.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
        if ((A != null) && !A.getOption().matches(new OptSpecifier(options.ID.OPT_g0.getValue()))
           && !A.getOption().matches(new OptSpecifier(options.ID.OPT_gstabs.getValue()))
           && DriverStatics.ContainsCompileOrAssembleAction(Actions.back())) {
          
          // Add a 'dsymutil' step if necessary, when debug info is enabled and we
          // have a compile input. We need to run 'dsymutil' ourselves in such cases
          // because the debug info will refer to a temporary object file which
          // will be removed at the end of the compilation process.
          if (Act.getType() == types.ID.TY_Image) {
            /*ActionList*/SmallVector<Action /*P*/> Inputs$1/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
            Inputs$1.push_back(Actions.back());
            Actions.pop_back();
            Actions.push_back(C.MakeAction(new DsymutilJobAction(Inputs$1, types.ID.TY_dSYM)));
          }
          
          // Verify the debug info output.
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_verify_debug_info.getValue()))) {
            Action /*P*/ LastAction = Actions.back();
            Actions.pop_back();
            Actions.push_back(C.MakeAction(new VerifyDebugInfoJobAction(LastAction, types.ID.TY_Nothing)));
          }
        }
      }
    } finally {
      if (ArchNames != null) { ArchNames.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// BuildJobs - Bind actions to concrete tools and translate
  /// arguments to form the list of jobs to run.
  ///
  /// \param C - The compilation that is being built.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildJobs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1847,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 1609,
   FQN="clang::driver::Driver::BuildJobs", NM="_ZNK5clang6driver6Driver9BuildJobsERNS0_11CompilationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver9BuildJobsERNS0_11CompilationE")
  //</editor-fold>
  public void BuildJobs(final Compilation /*&*/ C) /*const*/ {
    PrettyStackTraceString CrashInfo = null;
    StringSet/*<MallocAllocator>*/ ArchNames = null;
    std.mapTypeType<std.pairPtrType</*const*/ Action /*P*/ , std.string>, InputInfo> CachedResults = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Building compilation jobs"));
      
      Arg /*P*/ FinalOutput = C.getArgs().getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
      
      // It is an error to provide a -o option if we are making multiple output
      // files.
      if ((FinalOutput != null)) {
        /*uint*/int NumOutputs = 0;
        for (/*const*/ Action /*P*/ A : C.getActions())  {
          if (A.getType() != types.ID.TY_Nothing) {
            ++NumOutputs;
          }
        }
        if ($greater_uint(NumOutputs, 1)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diag(diag.err_drv_output_argument_with_multiple_files)));
            FinalOutput = null;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Collect the list of architectures.
      ArchNames/*J*/= new StringSet/*<MallocAllocator>*/();
      if (C.getDefaultToolChain().getTriple().isOSBinFormatMachO()) {
        for (/*const*/ Arg /*P*/ A : C.getArgs())  {
          if (A.getOption().matches(new OptSpecifier(options.ID.OPT_arch.getValue()))) {
            ArchNames.insert(new StringRef(A.getValue()));
          }
        }
      }
      
      // Set of (Action, canonical ToolChain triple) pairs we've built jobs for.
      CachedResults/*J*/= new std.mapTypeType<std.pairPtrType</*const*/ Action /*P*/ , std.string>, InputInfo>(CACHED_RESULT_COMPARATOR, new InputInfo());
      for (Action /*P*/ A : C.getActions()) {
        // If we are linking an image for multiple archs then the linker wants
        // -arch_multiple and -final_output <final image name>. Unfortunately, this
        // doesn't fit in cleanly because we have to pass this information down.
        //
        // FIXME: This is a hack; find a cleaner way to integrate this into the
        // process.
        /*const*/char$ptr/*char P*/ LinkingOutput = null;
        if (isa(LipoJobAction.class, A)) {
          if ((FinalOutput != null)) {
            LinkingOutput = $tryClone(FinalOutput.getValue());
          } else {
            LinkingOutput = $tryClone(getDefaultImageName());
          }
        }
        
        BuildJobsForAction(C, A, $AddrOf(C.getDefaultToolChain()), 
            /*BoundArch*/ (/*const*/char$ptr/*char P*/ )null, 
            /*AtTopLevel*/ true, 
            /*MultipleArchs*/ $greater_uint(ArchNames.size(), 1), 
            /*LinkingOutput*/ LinkingOutput, CachedResults, 
            /*BuildForOffloadDevice*/ false);
      }
      
      // If the user passed -Qunused-arguments or there were errors, don't warn
      // about any unused arguments.
      if (Diags.hasErrorOccurred()
         || C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_Qunused_arguments.getValue()))) {
        return;
      }
      
      // Claim -### here.
      /*J:(void)*/C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__HASH_HASH_HASH.getValue()));
      
      // Claim --driver-mode, --rsp-quoting, it was handled earlier.
      /*J:(void)*/C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_driver_mode.getValue()));
      /*J:(void)*/C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_rsp_quoting.getValue()));
      
      for (Arg /*P*/ A : C.getArgs()) {
        // FIXME: It would be nice to be able to send the argument to the
        // DiagnosticsEngine, so that extra values, position, and so on could be
        // printed.
        if (!A.isClaimed()) {
          if (A.getOption().hasFlag(options.ClangFlags.NoArgumentUnused)) {
            continue;
          }
          
          // Suppress the warning automatically if this is just a flag, and it is an
          // instance of an argument we already claimed.
          final /*const*/ Option /*&*/ Opt = A.getOption();
          if (Opt.getKind() == Option.OptionClass.FlagClass) {
            boolean DuplicateClaimed = false;
            
            for (/*const*/ Arg /*P*/ AA : C.getArgs().filtered(new OptSpecifier($AddrOf(Opt)))) {
              if (AA.isClaimed()) {
                DuplicateClaimed = true;
                break;
              }
            }
            if (DuplicateClaimed) {
              continue;
            }
          }
          
          // In clang-cl, don't mention unknown arguments here since they have
          // already been warned about.
          if (!IsCLMode() || !A.getOption().matches(new OptSpecifier(options.ID.OPT_UNKNOWN.getValue()))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.warn_drv_unused_argument)), 
                  new StringRef(A.getAsString(C.getArgs()))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    } finally {
      if (CachedResults != null) { CachedResults.$destroy(); }
      if (ArchNames != null) { ArchNames.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// ExecuteCompilation - Execute the compilation according to the command line
  /// arguments and return an appropriate exit code.
  ///
  /// This routine handles additional processing that must be done in addition
  /// to just running the subprocesses, for example reporting errors, setting
  /// up response files, removing temporary files, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::ExecuteCompilation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 790,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 714,
   FQN="clang::driver::Driver::ExecuteCompilation", NM="_ZN5clang6driver6Driver18ExecuteCompilationERNS0_11CompilationERN4llvm15SmallVectorImplISt4pairIiPKNS0_7CommandEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver18ExecuteCompilationERNS0_11CompilationERN4llvm15SmallVectorImplISt4pairIiPKNS0_7CommandEEEE")
  //</editor-fold>
  public int ExecuteCompilation(final Compilation /*&*/ C, 
                    final SmallVectorImpl<std.pairIntPtr</*const*/ Command /*P*/ > > /*&*/ FailingCommands) {
    // Just print if -### was present.
    if (C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__HASH_HASH_HASH.getValue()))) {
      C.getJobs().Print(llvm.errs(), $LF, true);
      return 0;
    }
    
    // If there were errors building the compilation, quit now.
    if (Diags.hasErrorOccurred()) {
      return 1;
    }
    
    // Set up response file names for each command, if necessary
    for (final Command /*&*/ Job : C.getJobs())  {
      setUpResponseFiles(C, Job);
    }
    
    C.ExecuteJobs(C.getJobs(), FailingCommands);
    
    // Remove temp files.
    C.CleanupFileList(C.getTempFiles());
    
    // If the command succeeded, we are done.
    if (FailingCommands.empty()) {
      return 0;
    }
    
    // Otherwise, remove result files and print extra information about abnormal
    // failures.
    for (final /*const*/pairIntPtr</*const*/ Command /*P*/ >/*&*/ CmdPair : FailingCommands) {
      int Res = CmdPair.first;
      /*const*/ Command /*P*/ FailingCommand = CmdPair.second;
      
      // Remove result files if we're not saving temps.
      if (!isSaveTempsEnabled()) {
        /*const*/ JobAction /*P*/ JA = cast(JobAction.class, /*AddrOf*/FailingCommand.getSource());
        C.CleanupFileMap(C.getResultFiles(), JA, true);
        
        // Failure result files are valid unless we crashed.
        if (Res < 0) {
          C.CleanupFileMap(C.getFailureResultFiles(), JA, true);
        }
      }
      
      // Print extra information about abnormal failures, if possible.
      //
      // This is ad-hoc, but we don't want to be excessively noisy. If the result
      // status was 1, assume the command failed normally. In particular, if it
      // was the compiler then assume it gave a reasonable error code. Failures
      // in other tools are less common, and they generally have worse
      // diagnostics, so always print the diagnostic there.
      final /*const*/ Tool /*&*/ FailingTool = FailingCommand.getCreator();
      if (!FailingCommand.getCreator().hasGoodDiagnostics() || Res != 1) {
        // FIXME: See FIXME above regarding result code interpretation.
        if (Res < 0) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.err_drv_command_signalled)), 
                FailingTool.getShortName()));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.err_drv_command_failed)), FailingTool.getShortName()), 
                Res));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    return 0;
  }

  
  /// generateCompilationDiagnostics - Generate diagnostics information 
  /// including preprocessed source file(s).
  /// 
  
  // When clang crashes, produce diagnostic information including the fully
  // preprocessed source file(s).  Request that the developer attach the
  // diagnostic information to a bug report.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::generateCompilationDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 616,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 540,
   FQN="clang::driver::Driver::generateCompilationDiagnostics", NM="_ZN5clang6driver6Driver30generateCompilationDiagnosticsERNS0_11CompilationERKNS0_7CommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver30generateCompilationDiagnosticsERNS0_11CompilationERKNS0_7CommandE")
  //</editor-fold>
  public void generateCompilationDiagnostics(final Compilation /*&*/ C, 
                                final /*const*/ Command /*&*/ FailingCommand) {
    Command Cmd = null;
    StringSet/*<MallocAllocator>*/ ArchNames = null;
    raw_fd_ostream ScriptOS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_fno_crash_diagnostics.getValue()))) {
        return;
      }
      
      // Don't try to generate diagnostics for link or dsymutil jobs.
      if (FailingCommand.getCreator().isLinkJob()
         || FailingCommand.getCreator().isDsymutilJob()) {
        return;
      }
      
      // Print the version of the compiler.
      PrintVersion(C, llvm.errs());
      
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
          /*KEEP_STR*/"PLEASE submit a bug report to http://llvm.org/bugs/ and include the crash backtrace, preprocessed source, and associated run script."));
      
      // Suppress driver output and emit preprocessor output to temp file.
      Mode = DriverMode.CPPMode;
      CCGenDiagnostics = true;
      
      // Save the original job command(s).
      Cmd = new Command(FailingCommand);
      
      // Keep track of whether we produce any errors while trying to produce
      // preprocessed sources.
      DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap(Diags);
      
      // Suppress tool output.
      C.initCompilationForDiagnostics();
      
      // Construct the list of inputs.
      SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> Inputs/*J*/= new SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >>(16, new std.pairTypePtr(types.ID.TY_INVALID, null));
      BuildInputs(C.getDefaultToolChain(), C.getArgs(), Inputs);
      
      for (type$ptr<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> it = Inputs.begin(), ie = Inputs.end(); $noteq_ptr(it, ie);) {
        boolean IgnoreInput = false;
        
        // Ignore input from stdin or any inputs that cannot be preprocessed.
        // Check type first as not all linker inputs have a value.
        if (types.getPreprocessedType(it./*->*/$star().first) == types.ID.TY_INVALID) {
          IgnoreInput = true;
        } else if (!(strcmp(it./*->*/$star().second.getValue(), /*KEEP_STR*/"-") != 0)) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
              /*KEEP_STR*/"Error generating preprocessed source(s) - ignoring input from stdin."));
          IgnoreInput = true;
        }
        if (IgnoreInput) {
          it = $tryClone(Inputs.erase(it));
          ie = $tryClone(Inputs.end());
        } else {
          it.$preInc();
        }
      }
      if (Inputs.empty()) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
            /*KEEP_STR*/"Error generating preprocessed source(s) - no preprocessable inputs."));
        return;
      }
      
      // Don't attempt to generate preprocessed files if multiple -arch options are
      // used, unless they're all duplicates.
      ArchNames/*J*/= new StringSet/*<MallocAllocator>*/();
      for (/*const*/ Arg /*P*/ A : C.getArgs()) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_arch.getValue()))) {
          StringRef ArchName = new StringRef(A.getValue());
          ArchNames.insert(/*NO_COPY*/ArchName);
        }
      }
      if ($greater_uint(ArchNames.size(), 1)) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
            /*KEEP_STR*/"Error generating preprocessed source(s) - cannot generate preprocessed source with multiple -arch options."));
        return;
      }
      
      // Construct the list of abstract actions to perform for this compilation. On
      // Darwin OSes this uses the driver-driver and builds universal actions.
      final /*const*/ ToolChain /*&*/ TC = C.getDefaultToolChain();
      if (TC.getTriple().isOSBinFormatMachO()) {
        BuildUniversalActions(C, TC, Inputs);
      } else {
        BuildActions(C, C.getArgs(), Inputs, C.getActions());
      }
      
      BuildJobs(C);
      
      // If there were errors building the compilation, quit now.
      if (Trap.hasErrorOccurred()) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
            /*KEEP_STR*/"Error generating preprocessed source(s)."));
        return;
      }
      
      // Generate preprocessed output.
      SmallVector<std.pairIntPtr</*const*/ Command /*P*/ >> FailingCommands/*J*/= new SmallVector<std.pairIntPtr</*const*/ Command /*P*/ >>(4, new std.pairIntPtr</*const*/ Command /*P*/ >(0, null));
      C.ExecuteJobs(C.getJobs(), FailingCommands);
      
      // If any of the preprocessing commands failed, clean up and exit.
      if (!FailingCommands.empty()) {
        if (!isSaveTempsEnabled()) {
          C.CleanupFileList(C.getTempFiles(), true);
        }
        
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
            /*KEEP_STR*/"Error generating preprocessed source(s)."));
        return;
      }
      
      final /*const*/ArgStringList/*&*/ TempFiles = C.getTempFiles();
      if (TempFiles.empty()) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
            /*KEEP_STR*/"Error generating preprocessed source(s)."));
        return;
      }
      
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
          /*KEEP_STR*/"\n********************\n\nPLEASE ATTACH THE FOLLOWING FILES TO THE BUG REPORT:\nPreprocessed source(s) and associated run script(s) are located at:"));
      
      SmallString/*<128>*/ VFS/*J*/= new SmallString/*<128>*/(128);
      for (/*const*/char$ptr/*char P*/ TempFile : TempFiles) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), TempFile));
        if (new StringRef(TempFile).endswith(/*STRINGREF_STR*/".cache")) {
          // In some cases (modules) we'll dump extra data to help with reproducing
          // the crash into a directory next to the output.
          VFS.$assign(path.filename(new StringRef(TempFile)));
          path.append(VFS, new Twine(/*KEEP_STR*/"vfs"), new Twine(/*KEEP_STR*/"vfs.yaml"));
        }
      }
      
      // Assume associated files are based off of the first temporary file.
      CrashReportInfo CrashInfo/*J*/= new CrashReportInfo(new StringRef(TempFiles.$at$Const(0)), VFS.$StringRef());
      
      std.string Script = $add_string_T$C$P(CrashInfo.Filename.rsplit($$DOT).first.str(), /*KEEP_STR*/".sh");
      std.error_code EC/*J*/= new std.error_code();
      ScriptOS/*J*/= new raw_fd_ostream(new StringRef(Script), EC, fs.OpenFlags.F_Excl);
      if (EC.$bool()) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
            new StringRef($add_string($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"Error generating run script: ", Script), /*KEEP_STR*/" "), EC.message()))));
      } else {
        ScriptOS.$out(/*KEEP_STR*/"# Crash reproducer for ").$out(getClangFullVersion()).$out(/*KEEP_STR*/$LF).$out(
                /*KEEP_STR*/"# Driver args: "
        );
        DriverStatics.printArgList(ScriptOS, C.getInputArgs());
        ScriptOS.$out(/*KEEP_STR*/"# Original command: ");
        Cmd.Print(ScriptOS, $LF, /*Quote=*/ true);
        Cmd.Print(ScriptOS, $LF, /*Quote=*/ true, $AddrOf(CrashInfo));
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), new StringRef(Script)));
      }
      
      for (final Arg /*P*/ /*const*/ /*&*/ A : C.getArgs().filtered(new OptSpecifier(options.ID.OPT_frewrite_map_file.getValue()), 
          new OptSpecifier(options.ID.OPT_frewrite_map_file_EQ.getValue())))  {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), A.getValue()));
      }
      
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(diag.note_drv_command_failed_diag_msg)), 
          /*KEEP_STR*/"\n\n********************"));
    } finally {
      if (ScriptOS != null) { ScriptOS.$destroy(); }
      if (ArchNames != null) { ArchNames.$destroy(); }
      if (Cmd != null) { Cmd.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// @}
  /// @name Helper Methods
  /// @{
  
  /// PrintActions - Print the list of actions.
  
  // Print the action graphs in a compilation C.
  // For example "clang -c file1.c file2.c" is composed of two subgraphs.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::PrintActions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1090,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 984,
   FQN="clang::driver::Driver::PrintActions", NM="_ZNK5clang6driver6Driver12PrintActionsERKNS0_11CompilationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver12PrintActionsERKNS0_11CompilationE")
  //</editor-fold>
  public void PrintActions(final /*const*/ Compilation /*&*/ C) /*const*/ {
    std.mapPtrUInt<Action /*P*/ > Ids = null;
    try {
      Ids/*J*/= new std.mapPtrUInt<Action /*P*/ >();
      for (Action /*P*/ A : C.getActions$Const())  {
        DriverStatics.PrintActions1(C, A, Ids);
      }
    } finally {
      if (Ids != null) { Ids.$destroy(); }
    }
  }

  
  /// PrintHelp - Print the help text.
  ///
  /// \param ShowHidden - Show hidden options.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::PrintHelp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 854,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 778,
   FQN="clang::driver::Driver::PrintHelp", NM="_ZNK5clang6driver6Driver9PrintHelpEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver9PrintHelpEb")
  //</editor-fold>
  public void PrintHelp(boolean ShowHidden) /*const*/ {
    // JAVA: decompose tie
    pairUIntUInt includeExcludeOptionFlagMasks = getIncludeExcludeOptionFlagMasks();
    /*uint*/int IncludedFlagsBitmask = includeExcludeOptionFlagMasks.first;
    /*uint*/int ExcludedFlagsBitmask = includeExcludeOptionFlagMasks.second;
    // std.tie(IncludedFlagsBitmask, ExcludedFlagsBitmask).$assign(getIncludeExcludeOptionFlagMasks());
    
    ExcludedFlagsBitmask |= options.ClangFlags.NoDriverOption;
    if (!ShowHidden) {
      ExcludedFlagsBitmask |= DriverFlag.HelpHidden;
    }
    
    getOpts().PrintHelp(llvm.outs(), Name.c_str(), DriverTitle.c_str(), 
        IncludedFlagsBitmask, ExcludedFlagsBitmask);
  }

  
  /// PrintVersion - Print the driver version.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::PrintVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 868,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 792,
   FQN="clang::driver::Driver::PrintVersion", NM="_ZNK5clang6driver6Driver12PrintVersionERKNS0_11CompilationERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver12PrintVersionERKNS0_11CompilationERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void PrintVersion(final /*const*/ Compilation /*&*/ C, final raw_ostream /*&*/ OS) /*const*/ {
    // FIXME: The following handlers should use a callback mechanism, we don't
    // know what the client would like to do.
    OS.$out(getClangFullVersion()).$out_char($$LF);
    final /*const*/ ToolChain /*&*/ TC = C.getDefaultToolChain();
    OS.$out(/*KEEP_STR*/"Target: ").$out(TC.getTripleString()).$out_char($$LF);
    {
      
      // Print the threading model.
      Arg /*P*/ A = C.getArgs$Const().getLastArg(new OptSpecifier(options.ID.OPT_mthread_model.getValue()));
      if ((A != null)) {
        // Don't print if the ToolChain would have barfed on it already
        if (TC.isThreadModelSupported(new StringRef(A.getValue()))) {
          OS.$out(/*KEEP_STR*/"Thread model: ").$out(A.getValue());
        }
      } else {
        OS.$out(/*KEEP_STR*/"Thread model: ").$out(TC.getThreadModel());
      }
    }
    OS.$out_char($$LF);
    
    // Print out the install directory.
    OS.$out(/*KEEP_STR*/"InstalledDir: ").$out(InstalledDir).$out_char($$LF);
  }

  
  /// GetFilePath - Lookup \p Name in the list of file search paths.
  ///
  /// \param TC - The tool chain for additional information on
  /// directories to search.
  //
  // FIXME: This should be in CompilationInfo.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetFilePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2103,
   FQN="clang::driver::Driver::GetFilePath", NM="_ZNK5clang6driver6Driver11GetFilePathEPKcRKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver11GetFilePathEPKcRKNS0_9ToolChainE")
  //</editor-fold>
  public std.string GetFilePath(/*const*/char$ptr/*char P*/ Name, final /*const*/ ToolChain /*&*/ TC) /*const*/ {
    // Respect a limited subset of the '-Bprefix' functionality in GCC by
    // attempting to use this prefix when looking for file paths.
    for (final /*const*/std.string/*&*/ Dir : PrefixDirs) {
      if (Dir.empty()) {
        continue;
      }
      SmallString/*<128>*/ P/*J*/= new SmallString/*<128>*/(128, new StringRef(Dir.$at$Const(0) == $$EQ ? $add_string$C_string(SysRoot, Dir.substr(1)) : new std.string(Dir)));
      path.append(P, new Twine(Name));
      if (fs.exists(new Twine(P))) {
        return P.str().$string();
      }
    }
    
    SmallString/*<128>*/ P/*J*/= new SmallString/*<128>*/(128, new StringRef(ResourceDir));
    path.append(P, new Twine(Name));
    if (fs.exists(new Twine(P))) {
      return P.str().$string();
    }
    
    for (final /*const*/std.string/*&*/ Dir : TC.getFilePaths$Const()) {
      if (Dir.empty()) {
        continue;
      }
      SmallString/*<128>*/ P$1/*J*/= new SmallString/*<128>*/(128, new StringRef(Dir.$at$Const(0) == $$EQ ? $add_string$C_string(SysRoot, Dir.substr(1)) : new std.string(Dir)));
      path.append(P$1, new Twine(Name));
      if (fs.exists(new Twine(P$1))) {
        return P$1.str().$string();
      }
    }
    
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, Name);
  }

  
  /// GetProgramPath - Lookup \p Name in the list of program search paths.
  ///
  /// \param TC - The provided tool chain for additional information on
  /// directories to search.
  //
  // FIXME: This should be in CompilationInfo.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetProgramPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2532,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2156,
   FQN="clang::driver::Driver::GetProgramPath", NM="_ZNK5clang6driver6Driver14GetProgramPathEPKcRKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver14GetProgramPathEPKcRKNS0_9ToolChainE")
  //</editor-fold>
  public std.string GetProgramPath(/*const*/char$ptr/*char P*/ Name, 
                final /*const*/ ToolChain /*&*/ TC) /*const*/ {
    SmallVector<std.string> TargetSpecificExecutables/*J*/= new SmallVector<std.string>(2, new std.string());
    generatePrefixedToolNames(Name, TC, TargetSpecificExecutables);
    
    // Respect a limited subset of the '-Bprefix' functionality in GCC by
    // attempting to use this prefix when looking for program paths.
    for (final /*const*/std.string/*&*/ PrefixDir : PrefixDirs) {
      if (fs.is_directory(new Twine(PrefixDir))) {
        SmallString/*<128>*/ P/*J*/= new SmallString/*<128>*/(128, new StringRef(PrefixDir));
        if (ScanDirForExecutable(P, new ArrayRef<std.string>(TargetSpecificExecutables, false))) {
          return P.str().$string();
        }
      } else {
        SmallString/*<128>*/ P/*J*/= new SmallString/*<128>*/(128, new StringRef($add_string$C_T$C$P(PrefixDir, Name)));
        if (fs.can_execute(new Twine(P))) {
          return P.str().$string();
        }
      }
    }
    
    final /*const*/SmallVector<std.string> /*&*/ List = TC.getProgramPaths$Const();
    for (final /*const*/std.string/*&*/ Path : List) {
      SmallString/*<128>*/ P/*J*/= new SmallString/*<128>*/(128, new StringRef(Path));
      if (ScanDirForExecutable(P, new ArrayRef<std.string>(TargetSpecificExecutables, false))) {
        return P.str().$string();
      }
    }
    
    // If all else failed, search the path.
    for (final /*const*/std.string/*&*/ TargetSpecificExecutable : TargetSpecificExecutables)  {
      {
        ErrorOr<std.string> P = sys.findProgramByName(new StringRef(TargetSpecificExecutable));
        if (P.$bool()) {
          return new std.string(P.$star());
        }
      }
    }
    
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, Name);
  }

  
  /// HandleImmediateArgs - Handle any arguments which should be
  /// treated before building actions or binding tools.
  ///
  /// \return Whether any compilation should be built for this
  /// invocation.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::HandleImmediateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 897,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 821,
   FQN="clang::driver::Driver::HandleImmediateArgs", NM="_ZN5clang6driver6Driver19HandleImmediateArgsERKNS0_11CompilationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver19HandleImmediateArgsERKNS0_11CompilationE")
  //</editor-fold>
  public boolean HandleImmediateArgs(final /*const*/ Compilation /*&*/ C) {
    // The order these options are handled in gcc is all over the place, but we
    // don't expect inconsistencies w.r.t. that to matter in practice.
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_dumpmachine.getValue()))) {
      llvm.outs().$out(C.getDefaultToolChain().getTripleString()).$out_char($$LF);
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_dumpversion.getValue()))) {
      // Since -dumpversion is only implemented for pedantic GCC compatibility, we
      // return an answer which matches our definition of __VERSION__.
      //
      // If we want to return a more correct answer some day, then we should
      // introduce a non-pedantically GCC compatible mode to Clang in which we
      // provide sensible definitions for -dumpversion, __VERSION__, etc.
      llvm.outs().$out(/*KEEP_STR*/"4.2.1\n");
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT__print_diagnostic_categories.getValue()))) {
      DriverStatics.PrintDiagnosticCategories(llvm.outs());
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_help.getValue()))
       || C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT__help_hidden.getValue()))) {
      PrintHelp(C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT__help_hidden.getValue())));
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT__version.getValue()))) {
      // Follow gcc behavior and use stdout for --version and stderr for -v.
      PrintVersion(C, llvm.outs());
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_v.getValue()))
       || C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT__HASH_HASH_HASH.getValue()))) {
      PrintVersion(C, llvm.errs());
      SuppressMissingInputWarning = true;
    }
    
    final /*const*/ ToolChain /*&*/ TC = C.getDefaultToolChain();
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_v.getValue()))) {
      TC.printVerboseInfo(llvm.errs());
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_print_search_dirs.getValue()))) {
      llvm.outs().$out(/*KEEP_STR*/"programs: =");
      boolean separator = false;
      for (final /*const*/std.string/*&*/ Path : TC.getProgramPaths$Const()) {
        if (separator) {
          llvm.outs().$out_char($$COLON);
        }
        llvm.outs().$out(Path);
        separator = true;
      }
      llvm.outs().$out(/*KEEP_STR*/$LF);
      llvm.outs().$out(/*KEEP_STR*/"libraries: =").$out(ResourceDir);
      
      StringRef sysroot = C.getSysRoot();
      
      for (final /*const*/std.string/*&*/ Path : TC.getFilePaths$Const()) {
        // Always print a separator. ResourceDir was the first item shown.
        llvm.outs().$out_char($$COLON);
        // Interpretation of leading '=' is needed only for NetBSD.
        if (Path.$at$Const(0) == $$EQ) {
          llvm.outs().$out(/*NO_COPY*/sysroot).$out(Path.substr(1));
        } else {
          llvm.outs().$out(Path);
        }
      }
      llvm.outs().$out(/*KEEP_STR*/$LF);
      return false;
    }
    {
      
      // FIXME: The following handlers should use a callback mechanism, we don't
      // know what the client would like to do.
      Arg /*P*/ A = C.getArgs$Const().getLastArg(new OptSpecifier(options.ID.OPT_print_file_name_EQ.getValue()));
      if ((A != null)) {
        llvm.outs().$out(GetFilePath(A.getValue(), TC)).$out(/*KEEP_STR*/$LF);
        return false;
      }
    }
    {
      
      Arg /*P*/ A = C.getArgs$Const().getLastArg(new OptSpecifier(options.ID.OPT_print_prog_name_EQ.getValue()));
      if ((A != null)) {
        llvm.outs().$out(GetProgramPath(A.getValue(), TC)).$out(/*KEEP_STR*/$LF);
        return false;
      }
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_print_libgcc_file_name.getValue()))) {
      llvm.outs().$out(GetFilePath($("libgcc.a"), TC)).$out(/*KEEP_STR*/$LF);
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_print_multi_lib.getValue()))) {
      for (final /*const*/ Multilib /*&*/ $Multilib : TC.getMultilibs())  {
        DriverGlobals.$out_raw_ostream_Multilib$C(llvm.outs(), $Multilib).$out(/*KEEP_STR*/$LF);
      }
      return false;
    }
    if (C.getArgs$Const().hasArg(new OptSpecifier(options.ID.OPT_print_multi_directory.getValue()))) {
      for (final /*const*/ Multilib /*&*/ $Multilib : TC.getMultilibs()) {
        if ($Multilib.gccSuffix().empty()) {
          llvm.outs().$out(/*KEEP_STR*/".\n");
        } else {
          StringRef Suffix/*J*/= new StringRef($Multilib.gccSuffix());
          assert (Suffix.front() == $$SLASH);
          llvm.outs().$out(Suffix.substr(1)).$out(/*KEEP_STR*/$LF);
        }
      }
      return false;
    }
    return true;
  }

  
  /// ConstructAction - Construct the appropriate action to do for
  /// \p Phase on the \p Input, taking in to account arguments
  /// like -fsyntax-only or --analyze.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::ConstructPhaseAction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1776,
   FQN="clang::driver::Driver::ConstructPhaseAction", NM="_ZNK5clang6driver6Driver20ConstructPhaseActionERNS0_11CompilationERKN4llvm3opt7ArgListENS0_6phases2IDEPNS0_6ActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver20ConstructPhaseActionERNS0_11CompilationERKN4llvm3opt7ArgListENS0_6phases2IDEPNS0_6ActionE")
  //</editor-fold>
  public Action /*P*/ ConstructPhaseAction(final Compilation /*&*/ C, final /*const*/ ArgList /*&*/ Args, 
                      phases.ID Phase, Action /*P*/ Input) /*const*/ {
    PrettyStackTraceString CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Constructing phase actions"));
      // Build the appropriate action.
      switch (Phase) {
       case Link:
        throw new llvm_unreachable("link action invalid here.");
       case Preprocess:
        {
          types.ID OutputTy;
          // -{M, MM} alter the output type.
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_M.getValue()), new OptSpecifier(options.ID.OPT_MM.getValue()))) {
            OutputTy = types.ID.TY_Dependencies;
          } else {
            OutputTy = Input.getType();
            if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_frewrite_includes.getValue()), 
                new OptSpecifier(options.ID.OPT_fno_rewrite_includes.getValue()), false)
               && !CCGenDiagnostics) {
              OutputTy = types.getPreprocessedType(OutputTy);
            }
            assert (OutputTy != types.ID.TY_INVALID) : "Cannot preprocess this input type!";
          }
          return C.MakeAction(new PreprocessJobAction(Input, OutputTy));
        }
       case Precompile:
        {
          types.ID OutputTy = types.ID.TY_PCH;
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_fsyntax_only.getValue()))) {
            // Syntax checks should not emit a PCH file
            OutputTy = types.ID.TY_Nothing;
          }
          return C.MakeAction(new PrecompileJobAction(Input, OutputTy));
        }
       case Compile:
        {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_fsyntax_only.getValue()))) {
            return C.MakeAction(new CompileJobAction(Input, types.ID.TY_Nothing));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_rewrite_objc.getValue()))) {
            return C.MakeAction(new CompileJobAction(Input, types.ID.TY_RewrittenObjC));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_rewrite_legacy_objc.getValue()))) {
            return C.MakeAction(new CompileJobAction(Input, 
                types.ID.TY_RewrittenLegacyObjC));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT__analyze.getValue()), new OptSpecifier(options.ID.OPT__analyze_auto.getValue()))) {
            return C.MakeAction(new AnalyzeJobAction(Input, types.ID.TY_Plist));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT__migrate.getValue()))) {
            return C.MakeAction(new MigrateJobAction(Input, types.ID.TY_Remap));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_emit_ast.getValue()))) {
            return C.MakeAction(new CompileJobAction(Input, types.ID.TY_AST));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_module_file_info.getValue()))) {
            return C.MakeAction(new CompileJobAction(Input, types.ID.TY_ModuleFile));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_verify_pch.getValue()))) {
            return C.MakeAction(new VerifyPCHJobAction(Input, types.ID.TY_Nothing));
          }
          return C.MakeAction(new CompileJobAction(Input, types.ID.TY_LLVM_BC));
        }
       case Backend:
        {
          if (isUsingLTO()) {
            types.ID Output = Args.hasArg(new OptSpecifier(options.ID.OPT_S.getValue())) ? types.ID.TY_LTO_IR : types.ID.TY_LTO_BC;
            return C.MakeAction(new BackendJobAction(Input, Output));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()))) {
            types.ID Output = Args.hasArg(new OptSpecifier(options.ID.OPT_S.getValue())) ? types.ID.TY_LLVM_IR : types.ID.TY_LLVM_BC;
            return C.MakeAction(new BackendJobAction(Input, Output));
          }
          return C.MakeAction(new BackendJobAction(Input, types.ID.TY_PP_Asm));
        }
       case Assemble:
        return C.MakeAction(new AssembleJobAction(std.move(Input), types.ID.TY_Object));
      }
      throw new llvm_unreachable("invalid phase in ConstructPhaseAction");
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// BuildJobsForAction - Construct the jobs to perform for the action \p A and
  /// return an InputInfo for the result of running \p A.  Will only construct
  /// jobs for a given (Action, ToolChain, BoundArch) tuple once.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildJobsForAction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2082,
   FQN="clang::driver::Driver::BuildJobsForAction", NM="_ZNK5clang6driver6Driver18BuildJobsForActionERNS0_11CompilationEPKNS0_6ActionEPKNS0_9ToolChainEPKcbbSB_RSt3mapISt4pairIS6_SsENS0_9InputInfoESt4lessISE_ESaISD_IKSE_SF_EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver18BuildJobsForActionERNS0_11CompilationEPKNS0_6ActionEPKNS0_9ToolChainEPKcbbSB_RSt3mapISt4pairIS6_SsENS0_9InputInfoESt4lessISE_ESaISD_IKSE_SF_EEEb")
  //</editor-fold>
  public InputInfo BuildJobsForAction(final Compilation /*&*/ C, /*const*/ Action /*P*/ A, /*const*/ ToolChain /*P*/ TC, /*const*/char$ptr/*char P*/ BoundArch, 
                    boolean AtTopLevel, boolean MultipleArchs, /*const*/char$ptr/*char P*/ LinkingOutput, 
                    final std.mapTypeType<std.pairPtrType</*const*/ Action /*P*/ , std.string>, InputInfo> /*&*/ CachedResults, 
                    boolean BuildForOffloadDevice) /*const*/ {
    // The bound arch is not necessarily represented in the toolchain's triple --
    // for example, armv7 and armv7s both map to the same triple -- so we need
    // both in our map.
    std.string TriplePlusArch = TC.getTriple().normalize();
    if ((BoundArch != null)) {
      TriplePlusArch.$addassign(/*KEEP_STR*/"-");
      TriplePlusArch.$addassign(BoundArch);
    }
    std.pairPtrType</*const*/Action/*P*/ , std.string> ActionTC = /*{ */new std.pairPtrType</*const*/Action/*P*/ , std.string>(A, TriplePlusArch)/* }*/;
    std.mapTypeType.iterator<pairPtrType</*const*/Action/*P*/ , std.string>, InputInfo> CachedResult = CachedResults.find(ActionTC);
    if (CachedResult.$noteq(CachedResults.end())) {
      return new InputInfo(CachedResult.$arrow().second);
    }
    InputInfo Result = BuildJobsForActionNoCache(C, A, TC, BoundArch, AtTopLevel, MultipleArchs, LinkingOutput, 
        CachedResults, BuildForOffloadDevice);
    CachedResults.$at_T$C$R(ActionTC).$assign(Result);
    return Result;
  }

  
  /// Returns the default name for linked images (e.g., "a.out").
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getDefaultImageName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2276,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 1906,
   FQN="clang::driver::Driver::getDefaultImageName", NM="_ZNK5clang6driver6Driver19getDefaultImageNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver19getDefaultImageNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getDefaultImageName() /*const*/ {
    Triple Target/*J*/= new Triple(new Twine(Triple.normalize(new StringRef(DefaultTargetTriple))));
    return Target.isOSWindows() ? $("a.exe") : $("a.out");
  }

  
  /// GetNamedOutputPath - Return the name to use for the output of
  /// the action \p JA. The result is appended to the compilation's
  /// list of temporary or result files, as appropriate.
  ///
  /// \param C - The compilation.
  /// \param JA - The action of interest.
  /// \param BaseInput - The original input file that this action was
  /// triggered by.
  /// \param BoundArch - The bound architecture. 
  /// \param AtTopLevel - Whether this is a "top-level" action.
  /// \param MultipleArchs - Whether multiple -arch options were supplied.
  /// \param NormalizedTriple - The normalized triple of the relevant target.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetNamedOutputPath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2314,
   FQN="clang::driver::Driver::GetNamedOutputPath", NM="_ZNK5clang6driver6Driver18GetNamedOutputPathERNS0_11CompilationERKNS0_9JobActionEPKcS8_bbN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver18GetNamedOutputPathERNS0_11CompilationERKNS0_9JobActionEPKcS8_bbN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ GetNamedOutputPath(final Compilation /*&*/ C, final /*const*/ JobAction /*&*/ JA, 
                    /*const*/char$ptr/*char P*/ BaseInput, 
                    /*const*/char$ptr/*char P*/ BoundArch, boolean AtTopLevel, 
                    boolean MultipleArchs, 
                    StringRef NormalizedTriple) /*const*/ {
    PrettyStackTraceString CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Computing output path"));
      // Output to a user requested destination?
      if (AtTopLevel && !isa(DsymutilJobAction.class, JA) && !isa(VerifyJobAction.class, JA)) {
        {
          Arg /*P*/ FinalOutput = C.getArgs().getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
          if ((FinalOutput != null)) {
            return C.addResultFile(FinalOutput.getValue(), $AddrOf(JA));
          }
        }
      }
      
      // For /P, preprocess to file named after BaseInput.
      if (C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_P.getValue()))) {
        assert (AtTopLevel && isa(PreprocessJobAction.class, JA));
        StringRef BaseName = path.filename(new StringRef(BaseInput));
        StringRef NameArg/*J*/= new StringRef();
        {
          Arg /*P*/ A = C.getArgs().getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Fi.getValue()));
          if ((A != null)) {
            NameArg.$assignMove(/*STRINGREF_STR*/A.getValue());
          }
        }
        return C.addResultFile(DriverStatics.MakeCLOutputFilename(C.getArgs(), new StringRef(NameArg), new StringRef(BaseName), types.ID.TY_PP_C), 
            $AddrOf(JA));
      }
      
      // Default to writing to stdout?
      if (AtTopLevel && !CCGenDiagnostics
         && (isa(PreprocessJobAction.class, JA) || JA.getType() == types.ID.TY_ModuleFile)) {
        return $MINUS;
      }
      
      // Is this the assembly listing for /FA?
      if (JA.getType() == types.ID.TY_PP_Asm
         && (C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_FA.getValue()))
         || C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_Fa.getValue())))) {
        // Use /Fa and the input filename to determine the asm file name.
        StringRef BaseName = path.filename(new StringRef(BaseInput));
        StringRef FaValue = C.getArgs().getLastArgValue(new OptSpecifier(options.ID.OPT__SLASH_Fa.getValue()));
        return C.addResultFile(DriverStatics.MakeCLOutputFilename(C.getArgs(), new StringRef(FaValue), new StringRef(BaseName), JA.getType()), 
            $AddrOf(JA));
      }
      
      // Output to a temporary file?
      if ((!AtTopLevel && !isSaveTempsEnabled()
         && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_Fo.getValue())))
         || CCGenDiagnostics) {
        StringRef Name = path.filename(new StringRef(BaseInput));
        std.pairTypeType<StringRef, StringRef> Split = Name.split($$DOT);
        std.string TmpName = GetTemporaryPath(new StringRef(Split.first), types.getTypeTempSuffix(JA.getType(), IsCLMode()));
        return C.addTempFile(C.getArgs().MakeArgString(new Twine(TmpName.c_str())));
      }
      
      SmallString/*<128>*/ BasePath/*J*/= new SmallString/*<128>*/(128, new StringRef(BaseInput));
      StringRef BaseName/*J*/= new StringRef();
      
      // Dsymutil actions should use the full path.
      if (isa(DsymutilJobAction.class, JA) || isa(VerifyJobAction.class, JA)) {
        BaseName.$assignMove(BasePath.$StringRef());
      } else {
        BaseName.$assignMove(path.filename(BasePath.$StringRef()));
      }
      
      // Determine what the derived output name should be.
      /*const*/char$ptr/*char P*/ NamedOutput = create_char$ptr();
      if (JA.getType() == types.ID.TY_Object
         && C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_Fo.getValue()), new OptSpecifier(options.ID.OPT__SLASH_o.getValue()))) {
        // The /Fo or /o flag decides the object filename.
        StringRef Val = new StringRef(C.getArgs().
                getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Fo.getValue()), new OptSpecifier(options.ID.OPT__SLASH_o.getValue())).
                getValue());
        NamedOutput = $tryClone(DriverStatics.MakeCLOutputFilename(C.getArgs(), new StringRef(Val), new StringRef(BaseName), types.ID.TY_Object));
      } else if (JA.getType() == types.ID.TY_Image
         && C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_Fe.getValue()), 
          new OptSpecifier(options.ID.OPT__SLASH_o.getValue()))) {
        // The /Fe or /o flag names the linked file.
        StringRef Val = new StringRef(C.getArgs().
                getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Fe.getValue()), new OptSpecifier(options.ID.OPT__SLASH_o.getValue())).
                getValue());
        NamedOutput = $tryClone(DriverStatics.MakeCLOutputFilename(C.getArgs(), new StringRef(Val), new StringRef(BaseName), types.ID.TY_Image));
      } else if (JA.getType() == types.ID.TY_Image) {
        if (IsCLMode()) {
          // clang-cl uses BaseName for the executable name.
          NamedOutput = $tryClone(DriverStatics.MakeCLOutputFilename(C.getArgs(), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(BaseName), types.ID.TY_Image));
        } else if (MultipleArchs && (BoundArch != null)) {
          SmallString/*<128>*/ Output/*J*/= new SmallString/*<128>*/(128, new StringRef(getDefaultImageName()));
          Output.$addassign(new StringRef(JA.getOffloadingFileNamePrefix(new StringRef(NormalizedTriple))));
          Output.$addassign(/*STRINGREF_STR*/"-");
          Output.append(new StringRef(BoundArch));
          NamedOutput = $tryClone(C.getArgs().MakeArgString(new Twine(Output.c_str())));
        } else {
          NamedOutput = $tryClone(getDefaultImageName());
        }
      } else if (JA.getType() == types.ID.TY_PCH && IsCLMode()) {
        NamedOutput = $tryClone(C.getArgs().MakeArgString(new Twine(GetClPchPath(C, new StringRef(BaseName)).c_str())));
      } else {
        /*const*/char$ptr/*char P*/ Suffix = $tryClone(types.getTypeTempSuffix(JA.getType(), IsCLMode()));
        assert ((Suffix != null)) : "All types used for output should have a suffix.";
        
        /*size_t*/int End = std.string.npos;
        if (!types.appendSuffixForType(JA.getType())) {
          End = BaseName.rfind($$DOT);
        }
        SmallString/*<128>*/ Suffixed/*J*/= new SmallString/*<128>*/(128, BaseName.substr(0, End));
        Suffixed.$addassign(new StringRef(JA.getOffloadingFileNamePrefix(new StringRef(NormalizedTriple))));
        if (MultipleArchs && (BoundArch != null)) {
          Suffixed.$addassign(/*STRINGREF_STR*/"-");
          Suffixed.append(new StringRef(BoundArch));
        }
        // When using both -save-temps and -emit-llvm, use a ".tmp.bc" suffix for
        // the unoptimized bitcode so that it does not get overwritten by the ".bc"
        // optimized bitcode output.
        if (!AtTopLevel && C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()))
           && JA.getType() == types.ID.TY_LLVM_BC) {
          Suffixed.$addassign(/*STRINGREF_STR*/".tmp");
        }
        Suffixed.$addassign($$DOT);
        Suffixed.$addassign(/*STRINGREF_STR*/Suffix);
        NamedOutput = $tryClone(C.getArgs().MakeArgString(new Twine(Suffixed.c_str())));
      }
      
      // Prepend object file path if -save-temps=obj
      if (!AtTopLevel && isSaveTempsObj() && C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_o.getValue()))
         && JA.getType() != types.ID.TY_PCH) {
        Arg /*P*/ FinalOutput = C.getArgs().getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
        SmallString/*<128>*/ TempPath/*J*/= new SmallString/*<128>*/(128, new StringRef(FinalOutput.getValue()));
        path.remove_filename(TempPath);
        StringRef OutputFileName = path.filename(new StringRef(NamedOutput));
        path.append(TempPath, new Twine(OutputFileName));
        NamedOutput = $tryClone(C.getArgs().MakeArgString(new Twine(TempPath.c_str())));
      }
      
      // If we're saving temps and the temp file conflicts with the input file,
      // then avoid overwriting input file.
      if (!AtTopLevel && isSaveTempsEnabled() && $eq_StringRef(/*STRINGREF_STR*/NamedOutput, /*NO_COPY*/BaseName)) {
        bool$ref SameFile = create_bool$ref(false);
        SmallString/*<256>*/ Result/*J*/= new SmallString/*<256>*/(256);
        fs.current_path(Result);
        path.append(Result, new Twine(BaseName));
        fs.equivalent(new Twine(BaseInput), new Twine(Result.c_str()), SameFile);
        // Must share the same path to conflict.
        if (SameFile.$deref()) {
          StringRef Name = path.filename(new StringRef(BaseInput));
          std.pairTypeType<StringRef, StringRef> Split = Name.split($$DOT);
          std.string TmpName = GetTemporaryPath(new StringRef(Split.first), types.getTypeTempSuffix(JA.getType(), IsCLMode()));
          return C.addTempFile(C.getArgs().MakeArgString(new Twine(TmpName.c_str())));
        }
      }
      
      // As an annoying special case, PCH generation doesn't strip the pathname.
      if (JA.getType() == types.ID.TY_PCH && !IsCLMode()) {
        path.remove_filename(BasePath);
        if (BasePath.empty()) {
          BasePath.$assign(/*STRINGREF_STR*/NamedOutput);
        } else {
          path.append(BasePath, new Twine(NamedOutput));
        }
        return C.addResultFile(C.getArgs().MakeArgString(new Twine(BasePath.c_str())), $AddrOf(JA));
      } else {
        return C.addResultFile(NamedOutput, $AddrOf(JA));
      }
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// GetTemporaryPath - Return the pathname of a temporary file to use 
  /// as part of compilation; the file will have the given prefix and suffix.
  ///
  /// GCC goes to extra lengths here to be a bit more robust.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetTemporaryPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2567,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2191,
   FQN="clang::driver::Driver::GetTemporaryPath", NM="_ZNK5clang6driver6Driver16GetTemporaryPathEN4llvm9StringRefEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver16GetTemporaryPathEN4llvm9StringRefEPKc")
  //</editor-fold>
  public std.string GetTemporaryPath(StringRef Prefix, 
                  /*const*/char$ptr/*char P*/ Suffix) /*const*/ {
    SmallString/*<128>*/ Path/*J*/= new SmallString/*<128>*/(128);
    std.error_code EC = fs.createTemporaryFile(new Twine(Prefix), new StringRef(Suffix), Path);
    if (EC.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_unable_to_make_temp)), new StringRef(EC.message())));
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
      } finally {
        $c$.$destroy();
      }
    }
    
    return Path.str().$string();
  }

  
  /// Return the pathname of the pch file in clang-cl mode.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetClPchPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2579,
   FQN="clang::driver::Driver::GetClPchPath", NM="_ZNK5clang6driver6Driver12GetClPchPathERNS0_11CompilationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver12GetClPchPathERNS0_11CompilationEN4llvm9StringRefE")
  //</editor-fold>
  public std.string GetClPchPath(final Compilation /*&*/ C, StringRef BaseName) /*const*/ {
    SmallString/*<128>*/ Output/*J*/= new SmallString/*<128>*/(128);
    {
      Arg /*P*/ FpArg = C.getArgs().getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Fp.getValue()));
      if ((FpArg != null)) {
        // FIXME: If anybody needs it, implement this obscure rule:
        // "If you specify a directory without a file name, the default file name
        // is VCx0.pch., where x is the major version of Visual C++ in use."
        Output.$assign(/*STRINGREF_STR*/FpArg.getValue());
        
        // "If you do not specify an extension as part of the path name, an
        // extension of .pch is assumed. "
        if (!path.has_extension(new Twine(Output))) {
          Output.$addassign(/*STRINGREF_STR*/".pch");
        }
      } else {
        Output.$assign(/*NO_COPY*/BaseName);
        path.replace_extension(Output, new Twine(/*KEEP_STR*/".pch"));
      }
    }
    return Output.str().$string();
  }

  
  /// ShouldUseClangCompiler - Should the clang compiler be used to
  /// handle this action.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::ShouldUseClangCompiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2717,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2315,
   FQN="clang::driver::Driver::ShouldUseClangCompiler", NM="_ZNK5clang6driver6Driver22ShouldUseClangCompilerERKNS0_9JobActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver22ShouldUseClangCompilerERKNS0_9JobActionE")
  //</editor-fold>
  public boolean ShouldUseClangCompiler(final /*const*/ JobAction /*&*/ JA) /*const*/ {
    // Say "no" if there is not exactly one input of a type clang understands.
    if (JA.size() != 1
       || !types.isAcceptedByClang((JA.input_begin$Const().$star()).getType())) {
      return false;
    }
    
    // And say "no" if this is not a kind of action clang understands.
    if (!isa(PreprocessJobAction.class, JA) && !isa(PrecompileJobAction.class, JA)
       && !isa(CompileJobAction.class, JA) && !isa(BackendJobAction.class, JA)) {
      return false;
    }
    
    return true;
  }

  
  /// Returns true if we are performing any kind of LTO.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::isUsingLTO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 439,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 421,
   FQN="clang::driver::Driver::isUsingLTO", NM="_ZNK5clang6driver6Driver10isUsingLTOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver10isUsingLTOEv")
  //</editor-fold>
  public boolean isUsingLTO() /*const*/ {
    return LTOMode != LTOKind.LTOK_None;
  }

  
  /// Get the specific kind of LTO being performed.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getLTOMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Driver.h", old_line = 424,
   FQN="clang::driver::Driver::getLTOMode", NM="_ZNK5clang6driver6Driver10getLTOModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver10getLTOModeEv")
  //</editor-fold>
  public LTOKind getLTOMode() /*const*/ {
    return LTOMode;
  }

/*private:*/
  /// Parse the \p Args list for LTO options and record the type of LTO
  /// compilation based on which -f(no-)?lto(=.*)? option occurs last.
  
  // \brief Parse the LTO options and record the type of LTO compilation
  // based on which -f(no-)?lto(=.*)? option occurs last.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::setLTOMode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 402,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 373,
   FQN="clang::driver::Driver::setLTOMode", NM="_ZN5clang6driver6Driver10setLTOModeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver10setLTOModeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  private void setLTOMode(final /*const*/ ArgList /*&*/ Args) {
    LTOMode = LTOKind.LTOK_None;
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_flto.getValue()), new OptSpecifier(options.ID.OPT_flto_EQ.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_lto.getValue()), false)) {
      return;
    }
    
    StringRef LTOName/*J*/= new StringRef(/*KEEP_STR*/"full");
    
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_flto_EQ.getValue()));
    if ((A != null)) {
      LTOName.$assignMove(/*STRINGREF_STR*/A.getValue());
    }
    
    LTOMode = new StringSwitch<LTOKind>(/*NO_COPY*/LTOName).
        Case(/*KEEP_STR*/"full", LTOKind.LTOK_Full).
        Case(/*KEEP_STR*/"thin", LTOKind.LTOK_Thin).
        Default(LTOKind.LTOK_Unknown);
    if (LTOMode == LTOKind.LTOK_Unknown) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert (A != null);
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_drv_unsupported_option_argument)), A.getOption().getName()), 
            A.getValue()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// \brief Retrieves a ToolChain for a particular \p Target triple.
  ///
  /// Will cache ToolChains for the life of the driver object, and create them
  /// on-demand.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2598,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2203,
   FQN="clang::driver::Driver::getToolChain", NM="_ZNK5clang6driver6Driver12getToolChainERKN4llvm3opt7ArgListERKNS2_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver12getToolChainERKN4llvm3opt7ArgListERKNS2_6TripleE")
  //</editor-fold>
  private /*const*/ ToolChain /*&*/ getToolChain(final /*const*/ ArgList /*&*/ Args, 
              final /*const*/ Triple /*&*/ Target) /*const*/ {
    
    final type$ref<ToolChain /*P*/ /*&*/> TC = ToolChains.ref$at(new StringRef(Target.str()));
    if (!(TC.$deref() != null)) {
      switch (Target.getOS()) {
       case Haiku:
        TC.$set(new Haiku(/*Deref*/this, Target, Args));
        break;
       case CloudABI:
        TC.$set(new CloudABI(/*Deref*/this, Target, Args));
        break;
       case Darwin:
       case MacOSX:
       case IOS:
       case TvOS:
       case WatchOS:
        TC.$set(new DarwinClang(/*Deref*/this, Target, Args));
        break;
       case DragonFly:
        TC.$set(new DragonFly(/*Deref*/this, Target, Args));
        break;
       case OpenBSD:
        TC.$set(new OpenBSD(/*Deref*/this, Target, Args));
        break;
       case Bitrig:
        TC.$set(new Bitrig(/*Deref*/this, Target, Args));
        break;
       case NetBSD:
        TC.$set(new NetBSD(/*Deref*/this, Target, Args));
        break;
       case FreeBSD:
        TC.$set(new FreeBSD(/*Deref*/this, Target, Args));
        break;
       case Minix:
        TC.$set(new Minix(/*Deref*/this, Target, Args));
        break;
       case Linux:
       case ELFIAMCU:
        if (Target.getArch() == Triple.ArchType.hexagon) {
          TC.$set(new HexagonToolChain(/*Deref*/this, Target, Args));
        } else if ((Target.getVendor() == Triple.VendorType.MipsTechnologies)
           && !Target.hasEnvironment()) {
          TC.$set(new MipsLLVMToolChain(/*Deref*/this, Target, Args));
        } else {
          TC.$set(new Linux(/*Deref*/this, Target, Args));
        }
        break;
       case NaCl:
        TC.$set(new NaClToolChain(/*Deref*/this, Target, Args));
        break;
       case Solaris:
        TC.$set(new Solaris(/*Deref*/this, Target, Args));
        break;
       case AMDHSA:
        TC.$set(new AMDGPUToolChain(/*Deref*/this, Target, Args));
        break;
       case Win32:
        switch (Target.getEnvironment()) {
         default:
          if (Target.isOSBinFormatELF()) {
            TC.$set(new Generic_ELF(/*Deref*/this, Target, Args));
          } else if (Target.isOSBinFormatMachO()) {
            TC.$set(new org.clang.driver.toolchains.impl.MachO(/*Deref*/this, Target, Args));
          } else {
            TC.$set(new Generic_GCC(/*Deref*/this, Target, Args));
          }
          break;
         case GNU:
          TC.$set(new MinGW(/*Deref*/this, Target, Args));
          break;
         case Itanium:
          TC.$set(new CrossWindowsToolChain(/*Deref*/this, Target, Args));
          break;
         case MSVC:
         case UnknownEnvironment:
          TC.$set(new MSVCToolChain(/*Deref*/this, Target, Args));
          break;
        }
        break;
       case CUDA:
        TC.$set(new CudaToolChain(/*Deref*/this, Target, Args));
        break;
       case PS4:
        TC.$set(new PS4CPU(/*Deref*/this, Target, Args));
        break;
       default:
        // Of these targets, Hexagon is the only one that might have
        // an OS of Linux, in which case it got handled above already.
        switch (Target.getArch()) {
         case tce:
          TC.$set(new TCEToolChain(/*Deref*/this, Target, Args));
          break;
         case hexagon:
          TC.$set(new HexagonToolChain(/*Deref*/this, Target, Args));
          break;
         case lanai:
          TC.$set(new LanaiToolChain(/*Deref*/this, Target, Args));
          break;
         case xcore:
          TC.$set(new XCoreToolChain(/*Deref*/this, Target, Args));
          break;
         case wasm32:
         case wasm64:
          TC.$set(new WebAssembly(/*Deref*/this, Target, Args));
          break;
         default:
          if (Target.getVendor() == Triple.VendorType.Myriad) {
            TC.$set(new MyriadToolChain(/*Deref*/this, Target, Args));
          } else if (Target.isOSBinFormatELF()) {
            TC.$set(new Generic_ELF(/*Deref*/this, Target, Args));
          } else if (Target.isOSBinFormatMachO()) {
            TC.$set(new org.clang.driver.toolchains.impl.MachO(/*Deref*/this, Target, Args));
          } else {
            TC.$set(new Generic_GCC(/*Deref*/this, Target, Args));
          }
        }
      }
    }
    return $Deref(TC.$deref());
  }

  
  /// @}
  
  /// \brief Get bitmasks for which option flags to include and exclude based on
  /// the driver mode.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::getIncludeExcludeOptionFlagMasks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2797,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2366,
   FQN="clang::driver::Driver::getIncludeExcludeOptionFlagMasks", NM="_ZNK5clang6driver6Driver32getIncludeExcludeOptionFlagMasksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver32getIncludeExcludeOptionFlagMasksEv")
  //</editor-fold>
  private std.pairUIntUInt getIncludeExcludeOptionFlagMasks() /*const*/ {
    /*uint*/int IncludedFlagsBitmask = 0;
    /*uint*/int ExcludedFlagsBitmask = options.ClangFlags.NoDriverOption;
    if (Mode == DriverMode.CLMode) {
      // Include CL and Core options.
      IncludedFlagsBitmask |= options.ClangFlags.CLOption;
      IncludedFlagsBitmask |= options.ClangFlags.CoreOption;
    } else {
      ExcludedFlagsBitmask |= options.ClangFlags.CLOption;
    }
    
    return std.make_pair_uint_uint(IncludedFlagsBitmask, ExcludedFlagsBitmask);
  }

  
  /// Helper used in BuildJobsForAction.  Doesn't use the cache when building
  /// jobs specifically for the given action, but will use the cache when
  /// building jobs for the Action's inputs.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::BuildJobsForActionNoCache">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2107,
   FQN="clang::driver::Driver::BuildJobsForActionNoCache", NM="_ZNK5clang6driver6Driver25BuildJobsForActionNoCacheERNS0_11CompilationEPKNS0_6ActionEPKNS0_9ToolChainEPKcbbSB_RSt3mapISt4pairIS6_SsENS0_9InputInfoESt4lessISE_ESaISD_IKSE_SF_EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver6Driver25BuildJobsForActionNoCacheERNS0_11CompilationEPKNS0_6ActionEPKNS0_9ToolChainEPKcbbSB_RSt3mapISt4pairIS6_SsENS0_9InputInfoESt4lessISE_ESaISD_IKSE_SF_EEEb")
  //</editor-fold>
  private InputInfo BuildJobsForActionNoCache(final Compilation /*&*/ C, /*const*/ Action /*P*/ A, /*const*/ ToolChain /*P*/ TC, /*const*/char$ptr/*char P*/ BoundArch, 
                           boolean AtTopLevel, boolean MultipleArchs, /*const*/char$ptr/*char P*/ LinkingOutput, 
                           final std.mapTypeType<std.pairPtrType</*const*/ Action /*P*/ , std.string>, InputInfo> /*&*/ CachedResults, 
                           boolean BuildForOffloadDevice) /*const*/ {
    PrettyStackTraceString CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceString($("Building compilation jobs"));
      
      /*InputInfoList*/SmallVector<InputInfo> OffloadDependencesInputInfo/*J*/= new /*InputInfoList*/SmallVector<InputInfo>(4, new InputInfo());
      {
        /*const*/ OffloadAction /*P*/ OA = dyn_cast(OffloadAction.class, A);
        if ((OA != null)) {
          // The offload action is expected to be used in four different situations.
          //
          // a) Set a toolchain/architecture/kind for a host action:
          //    Host Action 1 -> OffloadAction -> Host Action 2
          //
          // b) Set a toolchain/architecture/kind for a device action;
          //    Device Action 1 -> OffloadAction -> Device Action 2
          //
          // c) Specify a device dependences to a host action;
          //    Device Action 1  _
          //                      \
          //      Host Action 1  ---> OffloadAction -> Host Action 2
          //
          // d) Specify a host dependence to a device action.
          //      Host Action 1  _
          //                      \
          //    Device Action 1  ---> OffloadAction -> Device Action 2
          //
          // For a) and b), we just return the job generated for the dependence. For
          // c) and d) we override the current action with the host/device dependence
          // if the current toolchain is host/device and set the offload dependences
          // info with the jobs obtained from the device/host dependence(s).
          
          // If there is a single device option, just generate the job for it.
          if (OA.hasSingleDeviceDependence()) {
            InputInfo DevA/*J*/= new InputInfo();
            OA.doOnEachDeviceDependence(/*FuncArg*//*[&, &DevA, this, &C, &AtTopLevel, &LinkingOutput, &CachedResults]*/ (Action /*P*/ DepA, /*const*/ ToolChain /*P*/ DepTC, /*const*/char$ptr/*char P*/ DepBoundArch) -> {
                        DevA.$assignMove(
                                BuildJobsForAction(C, DepA, DepTC, DepBoundArch, AtTopLevel, 
                              /*MultipleArchs*/ !!(DepBoundArch != null), LinkingOutput, 
                              CachedResults, /*BuildForOffloadDevice=*/ true)
                        );
                    });
            return DevA;
          }
          
          // If 'Action 2' is host, we generate jobs for the device dependences and
          // override the current action with the host dependence. Otherwise, we
          // generate the host dependences and override the action with the device
          // dependence. The dependences can't therefore be a top-level action.
          OA.doOnEachDependence(/*IsHostDependence=*/ BuildForOffloadDevice, 
              /*FuncArg*//*[&, &OffloadDependencesInputInfo, this, &C, &LinkingOutput, &CachedResults]*/ (Action /*P*/ DepA, /*const*/ ToolChain /*P*/ DepTC, /*const*/char$ptr/*char P*/ DepBoundArch) -> {
                      OffloadDependencesInputInfo.push_back(BuildJobsForAction(C, DepA, DepTC, DepBoundArch, /*AtTopLevel=*/ false, 
                            /*MultipleArchs*/ !!(DepBoundArch != null), LinkingOutput, CachedResults, 
                            /*BuildForOffloadDevice=*/ DepA.getOffloadingDeviceKind()
                               != Action.OffloadKind.OFK_None));
                  });
          
          A = BuildForOffloadDevice ? OA.getSingleDeviceDependence(/*DoNotConsiderHostActions=*/ true) : OA.getHostDependence();
        }
      }
      {
        
        /*const*/ InputAction /*P*/ IA = dyn_cast(InputAction.class, A);
        if ((IA != null)) {
          // FIXME: It would be nice to not claim this here; maybe the old scheme of
          // just using Args was better?
          final /*const*/ Arg /*&*/ Input = IA.getInputArg();
          Input.claim();
          if (Input.getOption().matches(new OptSpecifier(options.ID.OPT_INPUT.getValue()))) {
            /*const*/char$ptr/*char P*/ Name = $tryClone(Input.getValue());
            return new InputInfo(A, Name, /* BaseInput = */ Name);
          }
          return new InputInfo(A, $AddrOf(Input), /* BaseInput = */ $EMPTY);
        }
      }
      {
        
        /*const*/ BindArchAction /*P*/ BAA = dyn_cast(BindArchAction.class, A);
        if ((BAA != null)) {
          /*const*/ ToolChain /*P*/ TC$1;
          /*const*/char$ptr/*char P*/ ArchName = $tryClone(BAA.getArchName());
          if ((ArchName != null)) {
            TC$1 = $AddrOf(getToolChain(C.getArgs(), 
                DriverStatics.computeTargetTriple(/*Deref*/this, new StringRef(DefaultTargetTriple), 
                    C.getArgs(), new StringRef(ArchName))));
          } else {
            TC$1 = $AddrOf(C.getDefaultToolChain());
          }
          
          return BuildJobsForAction(C, BAA.input_begin$Const().$star(), TC$1, ArchName, AtTopLevel, 
              MultipleArchs, LinkingOutput, CachedResults, 
              BuildForOffloadDevice);
        }
      }
      
      type$ref</*const*//*ActionList*/SmallVector<Action /*P*/>/*P*/ > Inputs = create_type$ref($AddrOf(A.getInputs$Const()));
      
      /*const*/ JobAction /*P*/ JA = cast(JobAction.class, A);
      /*ActionList*/SmallVector<Action /*P*/> CollapsedOffloadActions/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
      
      /*const*/ Tool /*P*/ T = DriverStatics.selectToolForJob(C, isSaveTempsEnabled(), embedBitcodeEnabled(), TC, JA, 
          Inputs, CollapsedOffloadActions);
      if (!(T != null)) {
        return new InputInfo();
      }
      
      // If we've collapsed action list that contained OffloadAction we
      // need to build jobs for host/device-side inputs it may have held.
      for (/*const*/ Action /*P*/ OA : CollapsedOffloadActions)  {
        cast(OffloadAction.class, OA).doOnEachDependence(/*IsHostDependence=*/ BuildForOffloadDevice, 
            /*FuncArg*//*[&, &OffloadDependencesInputInfo, this, &C, &AtTopLevel, &LinkingOutput, &CachedResults]*/ (Action /*P*/ DepA, /*const*/ ToolChain /*P*/ DepTC, /*const*/char$ptr/*char P*/ DepBoundArch) -> {
                    OffloadDependencesInputInfo.push_back(BuildJobsForAction(C, DepA, DepTC, DepBoundArch, AtTopLevel, 
                            /*MultipleArchs=*/ !!(DepBoundArch != null), LinkingOutput, CachedResults, 
                            /*BuildForOffloadDevice=*/ DepA.getOffloadingDeviceKind()
                               != Action.OffloadKind.OFK_None));
                });
      }
      
      // Only use pipes when there is exactly one input.
      /*InputInfoList*/SmallVector<InputInfo> InputInfos/*J*/= new /*InputInfoList*/SmallVector<InputInfo>(4, new InputInfo());
      for (/*const*/ Action /*P*/ Input : $Deref(Inputs.$deref())) {
        // Treat dsymutil and verify sub-jobs as being at the top-level too, they
        // shouldn't get temporary output names.
        // FIXME: Clean this up.
        boolean SubJobAtTopLevel = AtTopLevel && (isa(DsymutilJobAction.class, A) || isa(VerifyJobAction.class, A));
        InputInfos.push_back(BuildJobsForAction(C, Input, TC, BoundArch, SubJobAtTopLevel, MultipleArchs, LinkingOutput, 
                CachedResults, BuildForOffloadDevice));
      }
      
      // Always use the first input as the base input.
      /*const*/char$ptr/*char P*/ BaseInput = $tryClone(InputInfos.$at(0).getBaseInput());
      
      // ... except dsymutil actions, which use their actual input as the base
      // input.
      if (JA.getType() == types.ID.TY_dSYM) {
        BaseInput = $tryClone(InputInfos.$at(0).getFilename());
      }
      
      // Append outputs of offload device jobs to the input list
      if (!OffloadDependencesInputInfo.empty()) {
        InputInfos.append_T(OffloadDependencesInputInfo.begin(), 
            OffloadDependencesInputInfo.end());
      }
      
      // Determine the place to write output to, if any.
      InputInfo Result/*J*/= new InputInfo();
      if (JA.getType() == types.ID.TY_Nothing) {
        Result.$assignMove(new InputInfo(A, BaseInput));
      } else {
        Result.$assignMove(new InputInfo(A, GetNamedOutputPath(C, $Deref(JA), BaseInput, BoundArch, 
                    AtTopLevel, MultipleArchs, 
                    new StringRef(TC.getTriple().normalize())), 
                BaseInput));
      }
      if (CCCPrintBindings && !CCGenDiagnostics) {
        llvm.errs().$out(/*KEEP_STR*/"# \"").$out(T.getToolChain().getTripleString()).$out_char($$DBL_QUOTE).$out(
                /*KEEP_STR*/" - \""
        ).$out(T.getName()).$out(/*KEEP_STR*/"\", inputs: [");
        for (/*uint*/int i = 0, e = InputInfos.size(); i != e; ++i) {
          llvm.errs().$out(InputInfos.$at(i).getAsString());
          if (i + 1 != e) {
            llvm.errs().$out(/*KEEP_STR*/$COMMA_SPACE);
          }
        }
        llvm.errs().$out(/*KEEP_STR*/"], output: ").$out(Result.getAsString()).$out(/*KEEP_STR*/$LF);
      } else {
        T.ConstructJob(C, $Deref(JA), Result, InputInfos, 
            C.getArgsForToolChain(TC, BoundArch), LinkingOutput);
      }
      return Result;
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

/*public:*/
  /// GetReleaseVersion - Parse (([0-9]+)(.([0-9]+)(.([0-9]+)?))?)? and
  /// return the grouped values as integers. Numbers which are not
  /// provided are set to 0.
  ///
  /// \return True if the entire string was parsed (9.2), or all
  /// groups were parsed (10.3.5extrastuff). HadExtra is true if all
  /// groups were parsed but extra characters remain at the end.
  
  /// GetReleaseVersion - Parse (([0-9]+)(.([0-9]+)(.([0-9]+)?))?)? and return the
  /// grouped values as integers. Numbers which are not provided are set to 0.
  ///
  /// \return True if the entire string was parsed (9.2), or all groups were
  /// parsed (10.3.5extrastuff).
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetReleaseVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2736,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2333,
   FQN="clang::driver::Driver::GetReleaseVersion", NM="_ZN5clang6driver6Driver17GetReleaseVersionEPKcRjS4_S4_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver17GetReleaseVersionEPKcRjS4_S4_Rb")
  //</editor-fold>
  public static boolean GetReleaseVersion(/*const*/char$ptr/*char P*/ Str, final uint$ref/*uint &*/ Major, 
                   final uint$ref/*uint &*/ Minor, final uint$ref/*uint &*/ Micro, 
                   final bool$ref/*bool &*/ HadExtra) {
    HadExtra.$set(false);
    
    Major.$set(Minor.$set(Micro.$set(0)));
    if (Str.$star() == $$TERM) {
      return false;
    }
    
    char$ptr/*char P*/ End = create_char$ptr();
    Major.$set((/*uint*/int)strtol(Str, End.$addr(), 10));
    if (Str.$star() != $$TERM && End.$star() == $$TERM) {
      return true;
    }
    if (End.$star() != $$DOT) {
      return false;
    }
    
    Str = $tryClone(End.$add(1));
    Minor.$set((/*uint*/int)strtol(Str, End.$addr(), 10));
    if (Str.$star() != $$TERM && End.$star() == $$TERM) {
      return true;
    }
    if (End.$star() != $$DOT) {
      return false;
    }
    
    Str = $tryClone(End.$add(1));
    Micro.$set((/*uint*/int)strtol(Str, End.$addr(), 10));
    if (Str.$star() != $$TERM && End.$star() == $$TERM) {
      return true;
    }
    if ($eq_ptr(Str, End)) {
      return false;
    }
    HadExtra.$set(true);
    return true;
  }

  
  /// Parse digits from a string \p Str and fulfill \p Digits with
  /// the parsed numbers. This method assumes that the max number of
  /// digits to look for is equal to Digits.size().
  ///
  /// \return True if the entire string was parsed and there are
  /// no extra characters remaining at the end.
  
  /// Parse digits from a string \p Str and fulfill \p Digits with
  /// the parsed numbers. This method assumes that the max number of
  /// digits to look for is equal to Digits.size().
  ///
  /// \return True if the entire string was parsed and there are
  /// no extra characters remaining at the end.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Driver::GetReleaseVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2775,
   FQN="clang::driver::Driver::GetReleaseVersion", NM="_ZN5clang6driver6Driver17GetReleaseVersionEPKcN4llvm15MutableArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver6Driver17GetReleaseVersionEPKcN4llvm15MutableArrayRefIjEE")
  //</editor-fold>
  public static boolean GetReleaseVersion(/*const*/char$ptr/*char P*/ Str, 
                   MutableArrayRefUInt Digits) {
    if (Str.$star() == $$TERM) {
      return false;
    }
    
    char$ptr/*char P*/ End = create_char$ptr();
    /*uint*/int CurDigit = 0;
    while ($less_uint(CurDigit, Digits.size())) {
      /*uint*/int Digit = (/*uint*/int)strtol(Str, End.$addr(), 10);
      Digits.$set(CurDigit, Digit);
      if (Str.$star() != $$TERM && End.$star() == $$TERM) {
        return true;
      }
      if (End.$star() != $$DOT || $eq_ptr(Str, End)) {
        return false;
      }
      Str = $tryClone(End.$add(1));
      CurDigit++;
    }
    
    // More digits than requested, bail out...
    return false;
  }

  
  @Override public String toString() {
    return "" + "Opts=" + Opts // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", VFS=" + VFS // NOI18N
              + ", Mode=" + Mode // NOI18N
              + ", SaveTemps=" + SaveTemps // NOI18N
              + ", BitcodeEmbed=" + BitcodeEmbed // NOI18N
              + ", LTOMode=" + LTOMode // NOI18N
              + ", Name=" + Name // NOI18N
              + ", Dir=" + Dir // NOI18N
              + ", ClangExecutable=" + ClangExecutable // NOI18N
              + ", InstalledDir=" + InstalledDir // NOI18N
              + ", ResourceDir=" + ResourceDir // NOI18N
              + ", PrefixDirs=" + PrefixDirs // NOI18N
              + ", SysRoot=" + SysRoot // NOI18N
              + ", DyldPrefix=" + DyldPrefix // NOI18N
              + ", UseStdLib=" + UseStdLib // NOI18N
              + ", DefaultTargetTriple=" + DefaultTargetTriple // NOI18N
              + ", DriverTitle=" + DriverTitle // NOI18N
              + ", HostBits=" + HostBits // NOI18N
              + ", HostMachine=" + HostMachine // NOI18N
              + ", HostSystem=" + HostSystem // NOI18N
              + ", HostRelease=" + HostRelease // NOI18N
              + ", CCPrintOptionsFilename=" + CCPrintOptionsFilename // NOI18N
              + ", CCPrintHeadersFilename=" + CCPrintHeadersFilename // NOI18N
              + ", CCLogDiagnosticsFilename=" + CCLogDiagnosticsFilename // NOI18N
              + ", CCCPrintBindings=" + CCCPrintBindings // NOI18N
              + ", CCPrintOptions=" + CCPrintOptions // NOI18N
              + ", CCPrintHeaders=" + CCPrintHeaders // NOI18N
              + ", CCLogDiagnostics=" + CCLogDiagnostics // NOI18N
              + ", CCGenDiagnostics=" + CCGenDiagnostics // NOI18N
              + ", CCCGenericGCCName=" + CCCGenericGCCName // NOI18N
              + ", CheckInputsExist=" + CheckInputsExist // NOI18N
              + ", CCCUsePCH=" + CCCUsePCH // NOI18N
              + ", SuppressMissingInputWarning=" + SuppressMissingInputWarning // NOI18N
              + ", TempFiles=" + TempFiles // NOI18N
              + ", ResultFiles=" + ResultFiles // NOI18N
              + ", ToolChains=" + ToolChains; // NOI18N
  }
  
  private static final Comparator<pairPtrType<Action/*P*/, string>> CACHED_RESULT_COMPARATOR = new Comparator<pairPtrType<Action, string>>() {
    @Override
    public int compare(pairPtrType<Action, string> o1, pairPtrType<Action, string> o2) {
      if (o1.first == o2.first) {
        return o1.second.compare(o2.second);
      } else {
        return o1.hashCode() - o2.hashCode();
      }
    }
  };
  
}
