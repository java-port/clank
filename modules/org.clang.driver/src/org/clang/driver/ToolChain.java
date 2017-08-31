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

import org.llvm.support.target.ARM;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
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
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.SanitizerKind.*;
import org.clang.basic.vfs.FileSystem;
import static org.clang.driver.DriverGlobals.*;
import static org.clang.driver.impl.ToolChainStatics.*;
import static org.llvm.config.llvm_config.*;
import org.llvm.support.target.TargetRegistry;
import org.llvm.target.target.DebuggerKind;


/// ToolChain - Access to tools for a single platform.
//<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 48,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 47,
 FQN="clang::driver::ToolChain", NM="_ZN5clang6driver9ToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChainE")
//</editor-fold>
public abstract class ToolChain implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef SmallVector<std::string, 16> path_list*/
//  public final class path_list extends SmallVector<std.string>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::CXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 51,
   FQN="clang::driver::ToolChain::CXXStdlibType", NM="_ZN5clang6driver9ToolChain13CXXStdlibTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain13CXXStdlibTypeE")
  //</editor-fold>
  public enum CXXStdlibType implements Native.ComparableLower {
    CST_Libcxx(0),
    CST_Libstdcxx(CST_Libcxx.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CXXStdlibType valueOf(int val) {
      CXXStdlibType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CXXStdlibType[] VALUES;
      private static final CXXStdlibType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CXXStdlibType kind : CXXStdlibType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CXXStdlibType[min < 0 ? (1-min) : 0];
        VALUES = new CXXStdlibType[max >= 0 ? (1+max) : 0];
        for (CXXStdlibType kind : CXXStdlibType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CXXStdlibType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXXStdlibType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXXStdlibType)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::RuntimeLibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 57,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 56,
   FQN="clang::driver::ToolChain::RuntimeLibType", NM="_ZN5clang6driver9ToolChain14RuntimeLibTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain14RuntimeLibTypeE")
  //</editor-fold>
  public enum RuntimeLibType implements Native.ComparableLower {
    RLT_CompilerRT(0),
    RLT_Libgcc(RLT_CompilerRT.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RuntimeLibType valueOf(int val) {
      RuntimeLibType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RuntimeLibType[] VALUES;
      private static final RuntimeLibType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RuntimeLibType kind : RuntimeLibType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RuntimeLibType[min < 0 ? (1-min) : 0];
        VALUES = new RuntimeLibType[max >= 0 ? (1+max) : 0];
        for (RuntimeLibType kind : RuntimeLibType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private RuntimeLibType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RuntimeLibType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RuntimeLibType)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::RTTIMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 62,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 61,
   FQN="clang::driver::ToolChain::RTTIMode", NM="_ZN5clang6driver9ToolChain8RTTIModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain8RTTIModeE")
  //</editor-fold>
  public enum RTTIMode implements Native.ComparableLower {
    RM_EnabledExplicitly(0),
    RM_EnabledImplicitly(RM_EnabledExplicitly.getValue() + 1),
    RM_DisabledExplicitly(RM_EnabledImplicitly.getValue() + 1),
    RM_DisabledImplicitly(RM_DisabledExplicitly.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RTTIMode valueOf(int val) {
      RTTIMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RTTIMode[] VALUES;
      private static final RTTIMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RTTIMode kind : RTTIMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RTTIMode[min < 0 ? (1-min) : 0];
        VALUES = new RTTIMode[max >= 0 ? (1+max) : 0];
        for (RTTIMode kind : RTTIMode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private RTTIMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RTTIMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RTTIMode)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*const*/ Driver /*&*/ D;
  private /*const*/ Triple _Triple;
  public /*const*/ ArgList /*&*/ Args;
  // We need to initialize CachedRTTIArg before CachedRTTIMode
  private /*const*/ Arg /*P*/ /*const*/ CachedRTTIArg;
  private /*const*/ RTTIMode CachedRTTIMode;
  
  /// The list of toolchain specific path prefixes to search for
  /// files.
  private SmallVector<std.string> FilePaths;
  
  /// The list of toolchain specific path prefixes to search for
  /// programs.
  private SmallVector<std.string> ProgramPaths;
  
  private /*mutable */std.unique_ptr<Tool> Clang;
  private /*mutable */std.unique_ptr<Tool> Assemble;
  private /*mutable */std.unique_ptr<Tool> Link;
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getClang">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 209,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 208,
   FQN="clang::driver::ToolChain::getClang", NM="_ZNK5clang6driver9ToolChain8getClangEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain8getClangEv")
  //</editor-fold>
  private Tool /*P*/ getClang() /*const*/ {
    if (!Clang.$bool()) {
      Clang.reset(new Clang(/*Deref*/this));
    }
    return Clang.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getAssemble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 223,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 222,
   FQN="clang::driver::ToolChain::getAssemble", NM="_ZNK5clang6driver9ToolChain11getAssembleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain11getAssembleEv")
  //</editor-fold>
  private Tool /*P*/ getAssemble() /*const*/ {
    if (!Assemble.$bool()) {
      Assemble.reset(buildAssembler());
    }
    return Assemble.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getLink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 234,
   FQN="clang::driver::ToolChain::getLink", NM="_ZNK5clang6driver9ToolChain7getLinkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain7getLinkEv")
  //</editor-fold>
  private Tool /*P*/ getLink() /*const*/ {
    if (!Link.$bool()) {
      Link.reset(buildLinker());
    }
    return Link.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getClangAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 229,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 228,
   FQN="clang::driver::ToolChain::getClangAs", NM="_ZNK5clang6driver9ToolChain10getClangAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain10getClangAsEv")
  //</editor-fold>
  private Tool /*P*/ getClangAs() /*const*/ {
    if (!Assemble.$bool()) {
      Assemble.reset(new ClangAs(/*Deref*/this));
    }
    return Assemble.get();
  }

  
  private /*mutable */std.unique_ptr<SanitizerArgs> SanitizerArguments;
/*protected:*/
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected ToolChain() {
    // for collections only    
  }
    
  protected MultilibSet Multilibs;
  protected /*const*/char$ptr/*char P*/ DefaultLinker/* = "ld"*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::ToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 67,
   FQN="clang::driver::ToolChain::ToolChain", NM="_ZN5clang6driver9ToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS5_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS5_3opt7ArgListE")
  //</editor-fold>
  protected ToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ T, 
      /*const*/ ArgList /*&*/ Args) {
    /* : D(D), Triple(T), Args(Args), CachedRTTIArg(GetRTTIArgument(Args)), CachedRTTIMode(CalculateRTTIMode(Args, Triple, CachedRTTIArg)), FilePaths(), ProgramPaths(), Clang(), Assemble(), Link(), SanitizerArguments(), Multilibs(), DefaultLinker("ld")*/ 
    //START JInit
    this./*&*/D=/*&*/D;
    this._Triple = new Triple(T);
    this./*&*/Args=/*&*/Args;
    this.CachedRTTIArg = GetRTTIArgument(Args);
    this.CachedRTTIMode = CalculateRTTIMode(Args, _Triple, CachedRTTIArg);
    this.FilePaths = new SmallVector<std.string>(16, new std.string());
    this.ProgramPaths = new SmallVector<std.string>(16, new std.string());
    this.Clang = new std.unique_ptr<Tool>();
    this.Assemble = new std.unique_ptr<Tool>();
    this.Link = new std.unique_ptr<Tool>();
    this.SanitizerArguments = new std.unique_ptr<SanitizerArgs>();
    this.Multilibs = new MultilibSet();
    /*InClass*/this.DefaultLinker = $tryClone($("ld"));
    //END JInit
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mthread_model.getValue()));
      if ((A != null)) {
        if (!isThreadModelSupported(new StringRef(A.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_invalid_thread_model_for_target)), 
                    A.getValue()), new StringRef(A.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 215,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 214,
   FQN="clang::driver::ToolChain::buildAssembler", NM="_ZNK5clang6driver9ToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain14buildAssemblerEv")
  //</editor-fold>
  protected Tool /*P*/ buildAssembler() /*const*/ {
    return new ClangAs(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 219,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 218,
   FQN="clang::driver::ToolChain::buildLinker", NM="_ZNK5clang6driver9ToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain11buildLinkerEv")
  //</editor-fold>
  protected Tool /*P*/ buildLinker() /*const*/ {
    throw new llvm_unreachable("Linking is not supported by this toolchain");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getTool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 241,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 240,
   FQN="clang::driver::ToolChain::getTool", NM="_ZNK5clang6driver9ToolChain7getToolENS0_6Action11ActionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain7getToolENS0_6Action11ActionClassE")
  //</editor-fold>
  protected Tool /*P*/ getTool(Action.ActionClass AC) /*const*/ {
    switch (AC) {
     case AssembleJobClass:
      return getAssemble();
     case LinkJobClass:
      return getLink();
     case InputClass:
     case BindArchClass:
     case OffloadClass:
     case LipoJobClass:
     case DsymutilJobClass:
     case VerifyDebugInfoJobClass:
      throw new llvm_unreachable("Invalid tool kind.");
     case CompileJobClass:
     case PrecompileJobClass:
     case PreprocessJobClass:
     case AnalyzeJobClass:
     case MigrateJobClass:
     case VerifyPCHJobClass:
     case BackendJobClass:
      return getClang();
    }
    throw new llvm_unreachable("Invalid tool kind.");
  }

  
  /// \name Utilities for implementing subclasses.
  ///@{
  
  /// \brief Utility function to add a system include directory to CC1 arguments.
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addSystemInclude">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 580,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 551,
   FQN="clang::driver::ToolChain::addSystemInclude", NM="_ZN5clang6driver9ToolChain16addSystemIncludeERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain16addSystemIncludeERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEERKNS2_5TwineE")
  //</editor-fold>
  protected static void addSystemInclude(/*const*/ ArgList /*&*/ DriverArgs, 
                  ArgStringList/*&*/ CC1Args, 
                  /*const*/ Twine /*&*/ Path) {
    CC1Args.push_back($("-internal-isystem"));
    CC1Args.push_back(DriverArgs.MakeArgString(Path));
  }

  
  /// \brief Utility function to add a system include directory with extern "C"
  /// semantics to CC1 arguments.
  ///
  /// Note that this should be used rarely, and only for directories that
  /// historically and for legacy reasons are treated as having implicit extern
  /// "C" semantics. These semantics are *ignored* by and large today, but its
  /// important to preserve the preprocessor changes resulting from the
  /// classification.
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addExternCSystemInclude">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 595,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 566,
   FQN="clang::driver::ToolChain::addExternCSystemInclude", NM="_ZN5clang6driver9ToolChain23addExternCSystemIncludeERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain23addExternCSystemIncludeERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEERKNS2_5TwineE")
  //</editor-fold>
  protected static void addExternCSystemInclude(/*const*/ ArgList /*&*/ DriverArgs, 
                         ArgStringList/*&*/ CC1Args, 
                         /*const*/ Twine /*&*/ Path) {
    CC1Args.push_back($("-internal-externc-isystem"));
    CC1Args.push_back(DriverArgs.MakeArgString(Path));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addExternCSystemIncludeIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 602,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 573,
   FQN="clang::driver::ToolChain::addExternCSystemIncludeIfExists", NM="_ZN5clang6driver9ToolChain31addExternCSystemIncludeIfExistsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain31addExternCSystemIncludeIfExistsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEERKNS2_5TwineE")
  //</editor-fold>
  protected static void addExternCSystemIncludeIfExists(/*const*/ ArgList /*&*/ DriverArgs, 
                                 ArgStringList/*&*/ CC1Args, 
                                 /*const*/ Twine /*&*/ Path) {
    if (fs.exists(Path)) {
      addExternCSystemInclude(DriverArgs, CC1Args, Path);
    }
  }

  
  /// \brief Utility function to add a list of system include directories to CC1.
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addSystemIncludes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 610,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 581,
   FQN="clang::driver::ToolChain::addSystemIncludes", NM="_ZN5clang6driver9ToolChain17addSystemIncludesERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEENS2_8ArrayRefINS2_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain17addSystemIncludesERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEENS2_8ArrayRefINS2_9StringRefEEE")
  //</editor-fold>
  protected static void addSystemIncludes(/*const*/ ArgList /*&*/ DriverArgs, 
                   ArgStringList/*&*/ CC1Args, 
                   ArrayRef<StringRef> Paths) {
    for (StringRef Path : Paths) {
      CC1Args.push_back($("-internal-isystem"));
      CC1Args.push_back(DriverArgs.MakeArgString(new Twine(Path)));
    }
  }

///@}
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::~ToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 77,
   FQN="clang::driver::ToolChain::~ToolChain", NM="_ZN5clang6driver9ToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChainD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Multilibs.$destroy();
    SanitizerArguments.$destroy();
    Link.$destroy();
    Assemble.$destroy();
    Clang.$destroy();
    ProgramPaths.$destroy();
    FilePaths.$destroy();
    _Triple.$destroy();
    //END JDestroy
  }

  
  // Accessors
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getDriver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 127,
   FQN="clang::driver::ToolChain::getDriver", NM="_ZNK5clang6driver9ToolChain9getDriverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain9getDriverEv")
  //</editor-fold>
  public /*const*/ Driver /*&*/ getDriver() /*const*/ {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getVFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 80,
   FQN="clang::driver::ToolChain::getVFS", NM="_ZNK5clang6driver9ToolChain6getVFSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain6getVFSEv")
  //</editor-fold>
  public FileSystem /*&*/ getVFS() /*const*/ {
    return getDriver().getVFS();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 129,
   FQN="clang::driver::ToolChain::getTriple", NM="_ZNK5clang6driver9ToolChain9getTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain9getTripleEv")
  //</editor-fold>
  public /*const*/ Triple /*&*/ getTriple() /*const*/ {
    return _Triple;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 131,
   FQN="clang::driver::ToolChain::getArch", NM="_ZNK5clang6driver9ToolChain7getArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain7getArchEv")
  //</editor-fold>
  public Triple.ArchType getArch() /*const*/ {
    return _Triple.getArch();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getArchName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 133,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 132,
   FQN="clang::driver::ToolChain::getArchName", NM="_ZNK5clang6driver9ToolChain11getArchNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain11getArchNameEv")
  //</editor-fold>
  public StringRef getArchName() /*const*/ {
    return _Triple.getArchName();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getPlatform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 133,
   FQN="clang::driver::ToolChain::getPlatform", NM="_ZNK5clang6driver9ToolChain11getPlatformEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain11getPlatformEv")
  //</editor-fold>
  public StringRef getPlatform() /*const*/ {
    return _Triple.getVendorName();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 134,
   FQN="clang::driver::ToolChain::getOS", NM="_ZNK5clang6driver9ToolChain5getOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain5getOSEv")
  //</editor-fold>
  public StringRef getOS() /*const*/ {
    return _Triple.getOSName();
  }

  
  /// \brief Provide the default architecture name (as expected by -arch) for
  /// this toolchain.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getDefaultUniversalArchName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 188,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 187,
   FQN="clang::driver::ToolChain::getDefaultUniversalArchName", NM="_ZNK5clang6driver9ToolChain27getDefaultUniversalArchNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain27getDefaultUniversalArchNameEv")
  //</editor-fold>
  public StringRef getDefaultUniversalArchName() /*const*/ {
    // In universal driver terms, the arch name accepted by -arch isn't exactly
    // the same as the ones that appear in the triple. Roughly speaking, this is
    // an inverse of the darwin::getArchTypeForDarwinArchName() function, but the
    // only interesting special case is powerpc.
    switch (_Triple.getArch()) {
     case ppc:
      return new StringRef(/*KEEP_STR*/"ppc");
     case ppc64:
      return new StringRef(/*KEEP_STR*/"ppc64");
     case ppc64le:
      return new StringRef(/*KEEP_STR*/"ppc64le");
     default:
      return _Triple.getArchName();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getTripleString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 140,
   FQN="clang::driver::ToolChain::getTripleString", NM="_ZNK5clang6driver9ToolChain15getTripleStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain15getTripleStringEv")
  //</editor-fold>
  public std.string getTripleString() /*const*/ {
    return new std.string(_Triple.getTriple());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getFilePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 144,
   FQN="clang::driver::ToolChain::getFilePaths", NM="_ZN5clang6driver9ToolChain12getFilePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain12getFilePathsEv")
  //</editor-fold>
  public SmallVector<std.string> /*&*/ getFilePaths() {
    return FilePaths;
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getFilePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 145,
   FQN="clang::driver::ToolChain::getFilePaths", NM="_ZNK5clang6driver9ToolChain12getFilePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain12getFilePathsEv")
  //</editor-fold>
  public /*const*/SmallVector<std.string> /*&*/ getFilePaths$Const() /*const*/ {
    return FilePaths;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getProgramPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 148,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 147,
   FQN="clang::driver::ToolChain::getProgramPaths", NM="_ZN5clang6driver9ToolChain15getProgramPathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain15getProgramPathsEv")
  //</editor-fold>
  public SmallVector<std.string> /*&*/ getProgramPaths() {
    return ProgramPaths;
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getProgramPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 148,
   FQN="clang::driver::ToolChain::getProgramPaths", NM="_ZNK5clang6driver9ToolChain15getProgramPathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain15getProgramPathsEv")
  //</editor-fold>
  public /*const*/SmallVector<std.string> /*&*/ getProgramPaths$Const() /*const*/ {
    return ProgramPaths;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getMultilibs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 150,
   FQN="clang::driver::ToolChain::getMultilibs", NM="_ZNK5clang6driver9ToolChain12getMultilibsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain12getMultilibsEv")
  //</editor-fold>
  public /*const*/ MultilibSet /*&*/ getMultilibs() /*const*/ {
    return Multilibs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getSanitizerArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 88,
   FQN="clang::driver::ToolChain::getSanitizerArgs", NM="_ZNK5clang6driver9ToolChain16getSanitizerArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16getSanitizerArgsEv")
  //</editor-fold>
  public /*const*/ SanitizerArgs /*&*/ getSanitizerArgs() /*const*/ {
    if (!(SanitizerArguments.get() != null)) {
      SanitizerArguments.reset(new SanitizerArgs(/*Deref*/this, Args));
    }
    return /*Deref*/SanitizerArguments.get();
  }

  
  // Returns the Arg * that explicitly turned on/off rtti, or nullptr.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getRTTIArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 155,
   FQN="clang::driver::ToolChain::getRTTIArg", NM="_ZNK5clang6driver9ToolChain10getRTTIArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain10getRTTIArgEv")
  //</editor-fold>
  public /*const*/ Arg /*P*/ getRTTIArg() /*const*/ {
    return CachedRTTIArg;
  }

  
  // Returns the RTTIMode for the toolchain with the current arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getRTTIMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 158,
   FQN="clang::driver::ToolChain::getRTTIMode", NM="_ZNK5clang6driver9ToolChain11getRTTIModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain11getRTTIModeEv")
  //</editor-fold>
  public RTTIMode getRTTIMode() /*const*/ {
    return CachedRTTIMode;
  }

  
  /// \brief Return any implicit target and/or mode flag for an invocation of
  /// the compiler driver as `ProgName`.
  ///
  /// For example, when called with i686-linux-android-g++, the first element
  /// of the return value will be set to `"i686-linux-android"` and the second
  /// will be set to "--driver-mode=g++"`.
  ///
  /// \pre `llvm::InitializeAllTargets()` has been called.
  /// \param ProgName The name the Clang driver was invoked with (from,
  /// e.g., argv[0])
  /// \return A pair of (`target`, `mode-flag`), where one or both may be empty.
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getTargetAndModeFromProgramName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use string consts*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 163,
   FQN="clang::driver::ToolChain::getTargetAndModeFromProgramName", NM="_ZN5clang6driver9ToolChain31getTargetAndModeFromProgramNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain31getTargetAndModeFromProgramNameEN4llvm9StringRefE")
  //</editor-fold>
  public static std.pair<std.string, std.string> getTargetAndModeFromProgramName(StringRef PN) {
    std.string ProgName = normalizeProgramName(new StringRef(PN));
    /*const*/ DriverSuffix /*P*/ DS = parseDriverSuffix(new StringRef(ProgName));
    if (!(DS != null)) {
      return new std.pairTypeType<std.string, std.string>(std.make_pair_T_T(std.string.EMPTY, std.string.EMPTY));
    }
    std.string ModeFlag = new std.string($eq_ptr(DS.ModeFlag, (/*const*/char$ptr/*char P*/ )null) ? $EMPTY : DS.ModeFlag);
    
    /*size_t*/int LastComponent = ProgName.rfind($$MINUS, ProgName.size() - strlen(DS.Suffix));
    if (LastComponent == std.string.npos) {
      return new std.pairTypeType<std.string, std.string>(std.make_pair_T_T(std.string.EMPTY, ModeFlag));
    }
    
    // Infer target from the prefix.
    StringRef Prefix/*J*/= new StringRef(ProgName);
    Prefix.$assignMove(Prefix.slice(0, LastComponent));
    std.string IgnoredError/*J*/= new std.string();
    std.string Target/*J*/= new std.string();
    if ((TargetRegistry.lookupTarget(Prefix.$string(), IgnoredError) != null)) {
      Target.$assignMove(Prefix.$string());
    }
    return std.make_pair_T_T(Target, ModeFlag);
  }

  
  // Tool access.
  
  /// TranslateArgs - Create a new derived argument list for any argument
  /// translations this ToolChain may wish to perform, or 0 if no tool chain
  /// specific translations are needed.
  ///
  /// \param BoundArch - The bound architecture name, or 0.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::TranslateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 181,
   FQN="clang::driver::ToolChain::TranslateArgs", NM="_ZNK5clang6driver9ToolChain13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc")
  //</editor-fold>
  public /*virtual*/ DerivedArgList /*P*/ TranslateArgs(/*const*/ DerivedArgList /*&*/ Args, 
               /*const*/char$ptr/*char P*/ BoundArch) /*const*/ {
    return null;
  }

  
  /// Choose a tool to use to handle the action \p JA.
  ///
  /// This can be overridden when a particular ToolChain needs to use
  /// a compiler other than Clang.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::SelectTool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 326,
   FQN="clang::driver::ToolChain::SelectTool", NM="_ZNK5clang6driver9ToolChain10SelectToolERKNS0_9JobActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain10SelectToolERKNS0_9JobActionE")
  //</editor-fold>
  public Tool /*P*/ SelectTool(/*const*/ JobAction /*&*/ JA) /*const*/ {
    if (getDriver().ShouldUseClangCompiler(JA)) {
      return getClang();
    }
    Action.ActionClass AC = JA.getKind();
    if (AC == Action.ActionClass.AssembleJobClass && useIntegratedAs()) {
      return getClangAs();
    }
    return getTool(AC);
  }

  
  // Helper methods
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetFilePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 334,
   FQN="clang::driver::ToolChain::GetFilePath", NM="_ZNK5clang6driver9ToolChain11GetFilePathEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain11GetFilePathEPKc")
  //</editor-fold>
  public std.string GetFilePath(/*const*/char$ptr/*char P*/ Name) /*const*/ {
    return D.GetFilePath(Name, /*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetProgramPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 338,
   FQN="clang::driver::ToolChain::GetProgramPath", NM="_ZNK5clang6driver9ToolChain14GetProgramPathEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain14GetProgramPathEPKc")
  //</editor-fold>
  public std.string GetProgramPath(/*const*/char$ptr/*char P*/ Name) /*const*/ {
    return D.GetProgramPath(Name, /*Deref*/this);
  }

  
  /// Returns the linker path, respecting the -fuse-ld= argument to determine
  /// the linker suffix or name.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetLinkerPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 342,
   FQN="clang::driver::ToolChain::GetLinkerPath", NM="_ZNK5clang6driver9ToolChain13GetLinkerPathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain13GetLinkerPathEv")
  //</editor-fold>
  public std.string GetLinkerPath() /*const*/ {
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fuse_ld_EQ.getValue()));
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef UseLinker = new StringRef(A.getValue());
          if (path.is_absolute(new Twine(UseLinker))) {
            // If we're passed -fuse-ld= with what looks like an absolute path,
            // don't attempt to second-guess that.
            if (fs.exists(new Twine(UseLinker))) {
              return UseLinker.$string();
            }
          } else {
            // If we're passed -fuse-ld= with no argument, or with the argument ld,
            // then use whatever the default system linker is.
            if (UseLinker.empty() || $eq_StringRef(/*NO_COPY*/UseLinker, /*STRINGREF_STR*/"ld")) {
              return GetProgramPath($("ld"));
            }
            
            SmallString/*8*/ LinkerName/*J*/= new SmallString/*8*/(new StringRef(/*KEEP_STR*/"ld."), 8);
            LinkerName.append(new StringRef(UseLinker));
            
            std.string LinkerPath/*J*/= GetProgramPath(LinkerName.c_str());
            if (fs.exists(new Twine(LinkerPath))) {
              return LinkerPath;
            }
          }
          
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_linker_name)), new StringRef(A.getAsString(Args))));
          return new std.string(/*KEEP_STR*/$EMPTY);
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return GetProgramPath(DefaultLinker);
  }

  
  /// \brief Dispatch to the specific toolchain for verbose printing.
  ///
  /// This is used when handling the verbose option to print detailed,
  /// toolchain-specific information useful for understanding the behavior of
  /// the driver on a specific platform.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::printVerboseInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 208,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 207,
   FQN="clang::driver::ToolChain::printVerboseInfo", NM="_ZNK5clang6driver9ToolChain16printVerboseInfoERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16printVerboseInfoERN4llvm11raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void printVerboseInfo(raw_ostream /*&*/ OS) /*const*/ {
  }

  
  // Platform defaults information
  
  /// \brief Returns true if the toolchain is targeting a non-native
  /// architecture.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::isCrossCompiling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 380,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 373,
   FQN="clang::driver::ToolChain::isCrossCompiling", NM="_ZNK5clang6driver9ToolChain16isCrossCompilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16isCrossCompilingEv")
  //</editor-fold>
  public boolean isCrossCompiling() /*const*/ {
    Triple HostTriple/*J*/= new Triple(new Twine(/*KEEP_STR*/LLVM_HOST_TRIPLE()));
    switch (HostTriple.getArch()) {
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      // The A32/T32/T16 instruction sets are not separate architectures in this
      // context.
      return getArch() != Triple.ArchType.arm && getArch() != Triple.ArchType.thumb
         && getArch() != Triple.ArchType.armeb && getArch() != Triple.ArchType.thumbeb;
     default:
      return HostTriple.getArch() != getArch();
    }
  }

  
  /// HasNativeLTOLinker - Check whether the linker and related tools have
  /// native LLVM support.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::HasNativeLLVMSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 376,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 369,
   FQN="clang::driver::ToolChain::HasNativeLLVMSupport", NM="_ZNK5clang6driver9ToolChain20HasNativeLLVMSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain20HasNativeLLVMSupportEv")
  //</editor-fold>
  public boolean HasNativeLLVMSupport() /*const*/ {
    return false;
  }

  
  /// LookupTypeForExtension - Return the default language type to use for the
  /// given extension.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::LookupTypeForExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 372,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 365,
   FQN="clang::driver::ToolChain::LookupTypeForExtension", NM="_ZNK5clang6driver9ToolChain22LookupTypeForExtensionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain22LookupTypeForExtensionEPKc")
  //</editor-fold>
  public types.ID LookupTypeForExtension(/*const*/char$ptr/*char P*/ Ext) /*const*/ {
    return types.lookupTypeForExtension(Ext);
  }

  
  /// IsBlocksDefault - Does this tool chain enable -fblocks by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::IsBlocksDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 224,
   FQN="clang::driver::ToolChain::IsBlocksDefault", NM="_ZNK5clang6driver9ToolChain15IsBlocksDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain15IsBlocksDefaultEv")
  //</editor-fold>
  public /*virtual*/ boolean IsBlocksDefault() /*const*/ {
    return false;
  }

  
  /// IsIntegratedAssemblerDefault - Does this tool chain enable -integrated-as
  /// by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 228,
   FQN="clang::driver::ToolChain::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver9ToolChain28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  public /*virtual*/ boolean IsIntegratedAssemblerDefault() /*const*/ {
    return false;
  }

  
  /// \brief Check if the toolchain should use the integrated assembler.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::useIntegratedAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 82,
   FQN="clang::driver::ToolChain::useIntegratedAs", NM="_ZNK5clang6driver9ToolChain15useIntegratedAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain15useIntegratedAsEv")
  //</editor-fold>
  public boolean useIntegratedAs() /*const*/ {
    return Args.hasFlag(new OptSpecifier(options.ID.OPT_fintegrated_as.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_integrated_as.getValue()), 
        IsIntegratedAssemblerDefault());
  }

  
  /// IsMathErrnoDefault - Does this tool chain use -fmath-errno by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 234,
   FQN="clang::driver::ToolChain::IsMathErrnoDefault", NM="_ZNK5clang6driver9ToolChain18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain18IsMathErrnoDefaultEv")
  //</editor-fold>
  public /*virtual*/ boolean IsMathErrnoDefault() /*const*/ {
    return true;
  }

  
  /// IsEncodeExtendedBlockSignatureDefault - Does this tool chain enable
  /// -fencode-extended-block-signature by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::IsEncodeExtendedBlockSignatureDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 239,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 238,
   FQN="clang::driver::ToolChain::IsEncodeExtendedBlockSignatureDefault", NM="_ZNK5clang6driver9ToolChain37IsEncodeExtendedBlockSignatureDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain37IsEncodeExtendedBlockSignatureDefaultEv")
  //</editor-fold>
  public /*virtual*/ boolean IsEncodeExtendedBlockSignatureDefault() /*const*/ {
    return false;
  }

  
  /// IsObjCNonFragileABIDefault - Does this tool chain set
  /// -fobjc-nonfragile-abi by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::IsObjCNonFragileABIDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 242,
   FQN="clang::driver::ToolChain::IsObjCNonFragileABIDefault", NM="_ZNK5clang6driver9ToolChain26IsObjCNonFragileABIDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain26IsObjCNonFragileABIDefaultEv")
  //</editor-fold>
  public /*virtual*/ boolean IsObjCNonFragileABIDefault() /*const*/ {
    return false;
  }

  
  /// UseObjCMixedDispatchDefault - When using non-legacy dispatch, should the
  /// mixed dispatch method be used?
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::UseObjCMixedDispatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 246,
   FQN="clang::driver::ToolChain::UseObjCMixedDispatch", NM="_ZNK5clang6driver9ToolChain20UseObjCMixedDispatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain20UseObjCMixedDispatchEv")
  //</editor-fold>
  public /*virtual*/ boolean UseObjCMixedDispatch() /*const*/ {
    return false;
  }

  
  /// GetDefaultStackProtectorLevel - Get the default stack protector level for
  /// this tool chain (0=off, 1=on, 2=strong, 3=all).
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetDefaultStackProtectorLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 250,
   FQN="clang::driver::ToolChain::GetDefaultStackProtectorLevel", NM="_ZNK5clang6driver9ToolChain29GetDefaultStackProtectorLevelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain29GetDefaultStackProtectorLevelEb")
  //</editor-fold>
  public /*virtual*/ /*uint*/int GetDefaultStackProtectorLevel(boolean KernelOrKext) /*const*/ {
    return 0;
  }

  
  /// GetDefaultRuntimeLibType - Get the default runtime library variant to use.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetDefaultRuntimeLibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 255,
   FQN="clang::driver::ToolChain::GetDefaultRuntimeLibType", NM="_ZNK5clang6driver9ToolChain24GetDefaultRuntimeLibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain24GetDefaultRuntimeLibTypeEv")
  //</editor-fold>
  public /*virtual*/ RuntimeLibType GetDefaultRuntimeLibType() /*const*/ {
    return ToolChain.RuntimeLibType.RLT_Libgcc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetDefaultCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 260,
   FQN="clang::driver::ToolChain::GetDefaultCXXStdlibType", NM="_ZNK5clang6driver9ToolChain23GetDefaultCXXStdlibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain23GetDefaultCXXStdlibTypeEv")
  //</editor-fold>
  public /*virtual*/ CXXStdlibType GetDefaultCXXStdlibType() /*const*/ {
    return ToolChain.CXXStdlibType.CST_Libstdcxx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getCompilerRT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 286,
   FQN="clang::driver::ToolChain::getCompilerRT", NM="_ZNK5clang6driver9ToolChain13getCompilerRTERKN4llvm3opt7ArgListENS2_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain13getCompilerRTERKN4llvm3opt7ArgListENS2_9StringRefEb")
  //</editor-fold>
  public std.string getCompilerRT(/*const*/ ArgList /*&*/ Args, StringRef Component) /*const*/ {
    return getCompilerRT(Args, Component, 
               false);
  }
  public std.string getCompilerRT(/*const*/ ArgList /*&*/ Args, StringRef Component, 
               boolean Shared/*= false*/) /*const*/ {
    /*const*/ Triple /*&*/ TT = getTriple();
    /*const*/char$ptr/*char P*/ Env = $tryClone(TT.isAndroid() ? $("-android") : $EMPTY);
    boolean IsITANMSVCWindows = TT.isWindowsMSVCEnvironment() || TT.isWindowsItaniumEnvironment();
    
    StringRef Arch = getArchNameForCompilerRTLib(/*Deref*/this, Args);
    /*const*/char$ptr/*char P*/ Prefix = $tryClone(IsITANMSVCWindows ? $EMPTY : $("lib"));
    /*const*/char$ptr/*char P*/ Suffix = $tryClone(Shared ? (_Triple.isOSWindows() ? $(".dll") : $(".so")) : (IsITANMSVCWindows ? $(".lib") : $(".a")));
    
    SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(getDriver().ResourceDir), 128);
    StringRef OSLibName = _Triple.isOSFreeBSD() ? new StringRef(/*KEEP_STR*/"freebsd") : getOS();
    path.append(Path, new Twine(/*KEEP_STR*/"lib"), new Twine(OSLibName));
    path.append(Path, $add_Twine($add_Twine($add_Twine($add_Twine($add_Twine($add_Twine(new Twine(Prefix), new Twine(/*KEEP_STR*/"clang_rt.")), new Twine(Component)), new Twine(/*KEEP_STR*/$MINUS)), 
                    new Twine(Arch)), new Twine(Env)), new Twine(Suffix)));
    return Path.str().$string();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getCompilerRTArgString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 306,
   FQN="clang::driver::ToolChain::getCompilerRTArgString", NM="_ZNK5clang6driver9ToolChain22getCompilerRTArgStringERKN4llvm3opt7ArgListENS2_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain22getCompilerRTArgStringERKN4llvm3opt7ArgListENS2_9StringRefEb")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCompilerRTArgString(/*const*/ ArgList /*&*/ Args, 
                        StringRef Component) /*const*/ {
    return getCompilerRTArgString(Args, 
                        Component, 
                        false);
  }
  public /*const*/char$ptr/*char P*/ getCompilerRTArgString(/*const*/ ArgList /*&*/ Args, 
                        StringRef Component, 
                        boolean Shared/*= false*/) /*const*/ {
    return Args.MakeArgString(new Twine(getCompilerRT(Args, new StringRef(Component), Shared)));
  }

  /// needsProfileRT - returns true if instrumentation profile is on.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::needsProfileRT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 312,
   FQN="clang::driver::ToolChain::needsProfileRT", NM="_ZN5clang6driver9ToolChain14needsProfileRTERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver9ToolChain14needsProfileRTERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public static boolean needsProfileRT(/*const*/ ArgList /*&*/ Args) {
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_arcs.getValue()), new OptSpecifier(options.ID.OPT_fno_profile_arcs.getValue()), 
        false)
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fprofile_generate.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fprofile_generate_EQ.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fprofile_instr_generate.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fprofile_instr_generate_EQ.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fcreate_profile.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_coverage.getValue()))) {
      return true;
    }
    
    return false;
  }

  
  /// IsUnwindTablesDefault - Does this tool chain use -funwind-tables
  /// by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 205,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 204,
   FQN="clang::driver::ToolChain::IsUnwindTablesDefault", NM="_ZNK5clang6driver9ToolChain21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain21IsUnwindTablesDefaultEv")
  //</editor-fold>
  public boolean IsUnwindTablesDefault() /*const*/ {
    return false;
  }

  
  /// \brief Test whether this toolchain defaults to PIC.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 279,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 274,
   FQN="clang::driver::ToolChain::isPICDefault", NM="_ZNK5clang6driver9ToolChain12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain12isPICDefaultEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isPICDefault() /*const*//* = 0*/;

  
  /// \brief Test whether this toolchain defaults to PIE.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 277,
   FQN="clang::driver::ToolChain::isPIEDefault", NM="_ZNK5clang6driver9ToolChain12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain12isPIEDefaultEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isPIEDefault() /*const*//* = 0*/;

  
  /// \brief Tests whether this toolchain forces its default for PIC, PIE or
  /// non-PIC.  If this returns true, any PIC related flags should be ignored
  /// and instead the results of \c isPICDefault() and \c isPIEDefault() are
  /// used exclusively.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 288,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 283,
   FQN="clang::driver::ToolChain::isPICDefaultForced", NM="_ZNK5clang6driver9ToolChain18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain18isPICDefaultForcedEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isPICDefaultForced() /*const*//* = 0*/;

  
  /// SupportsProfiling - Does this tool chain support -pg.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::SupportsProfiling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 291,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 286,
   FQN="clang::driver::ToolChain::SupportsProfiling", NM="_ZNK5clang6driver9ToolChain17SupportsProfilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain17SupportsProfilingEv")
  //</editor-fold>
  public /*virtual*/ boolean SupportsProfiling() /*const*/ {
    return true;
  }

  
  /// Does this tool chain support Objective-C garbage collection.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::SupportsObjCGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 294,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 289,
   FQN="clang::driver::ToolChain::SupportsObjCGC", NM="_ZNK5clang6driver9ToolChain14SupportsObjCGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain14SupportsObjCGCEv")
  //</editor-fold>
  public /*virtual*/ boolean SupportsObjCGC() /*const*/ {
    return true;
  }

  
  /// Complain if this tool chain doesn't support Objective-C ARC.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::CheckObjCARC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 297,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 292,
   FQN="clang::driver::ToolChain::CheckObjCARC", NM="_ZNK5clang6driver9ToolChain12CheckObjCARCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain12CheckObjCARCEv")
  //</editor-fold>
  public /*virtual*/ void CheckObjCARC() /*const*/ {
  }

  
  /// UseDwarfDebugFlags - Embed the compile options to clang into the Dwarf
  /// compile unit information.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::UseDwarfDebugFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 296,
   FQN="clang::driver::ToolChain::UseDwarfDebugFlags", NM="_ZNK5clang6driver9ToolChain18UseDwarfDebugFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain18UseDwarfDebugFlagsEv")
  //</editor-fold>
  public /*virtual*/ boolean UseDwarfDebugFlags() /*const*/ {
    return false;
  }

  
  // Return the DWARF version to emit, in the absence of arguments
  // to the contrary.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetDefaultDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 300,
   FQN="clang::driver::ToolChain::GetDefaultDwarfVersion", NM="_ZNK5clang6driver9ToolChain22GetDefaultDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain22GetDefaultDwarfVersionEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int GetDefaultDwarfVersion() /*const*/ {
    return 4;
  }

  
  // True if the driver should assume "-fstandalone-debug"
  // in the absence of an option specifying otherwise,
  // provided that debugging was requested in the first place.
  // i.e. a value of 'true' does not imply that debugging is wanted.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetDefaultStandaloneDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 311,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 306,
   FQN="clang::driver::ToolChain::GetDefaultStandaloneDebug", NM="_ZNK5clang6driver9ToolChain25GetDefaultStandaloneDebugEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain25GetDefaultStandaloneDebugEv")
  //</editor-fold>
  public /*virtual*/ boolean GetDefaultStandaloneDebug() /*const*/ {
    return false;
  }

  
  // Return the default debugger "tuning."
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getDefaultDebuggerTuning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 309,
   FQN="clang::driver::ToolChain::getDefaultDebuggerTuning", NM="_ZNK5clang6driver9ToolChain24getDefaultDebuggerTuningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain24getDefaultDebuggerTuningEv")
  //</editor-fold>
  public /*virtual*/ DebuggerKind getDefaultDebuggerTuning() /*const*/ {
    return DebuggerKind.GDB;
  }

  
  /// UseSjLjExceptions - Does this tool chain use SjLj exceptions.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::UseSjLjExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 314,
   FQN="clang::driver::ToolChain::UseSjLjExceptions", NM="_ZNK5clang6driver9ToolChain17UseSjLjExceptionsERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain17UseSjLjExceptionsERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public /*virtual*/ boolean UseSjLjExceptions(/*const*/ ArgList /*&*/ Args) /*const*/ {
    return false;
  }

  
  /// SupportsEmbeddedBitcode - Does this tool chain support embedded bitcode.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::SupportsEmbeddedBitcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 324,
   FQN="clang::driver::ToolChain::SupportsEmbeddedBitcode", NM="_ZNK5clang6driver9ToolChain23SupportsEmbeddedBitcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain23SupportsEmbeddedBitcodeEv")
  //</editor-fold>
  public /*virtual*/ boolean SupportsEmbeddedBitcode() /*const*/ {
    return false;
  }

  
  /// getThreadModel() - Which thread model does this target use?
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getThreadModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 329,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 319,
   FQN="clang::driver::ToolChain::getThreadModel", NM="_ZNK5clang6driver9ToolChain14getThreadModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain14getThreadModelEv")
  //</editor-fold>
  public /*virtual*/ std.string getThreadModel() /*const*/ {
    return new std.string(/*KEEP_STR*/"posix");
  }

  
  /// isThreadModelSupported() - Does this target support a thread model?
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::isThreadModelSupported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 401,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 394,
   FQN="clang::driver::ToolChain::isThreadModelSupported", NM="_ZNK5clang6driver9ToolChain22isThreadModelSupportedEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain22isThreadModelSupportedEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isThreadModelSupported(/*const*/ StringRef Model) /*const*/ {
    if ($eq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"single")) {
      // FIXME: 'single' is only supported on ARM and WebAssembly so far.
      return _Triple.getArch() == Triple.ArchType.arm
         || _Triple.getArch() == Triple.ArchType.armeb
         || _Triple.getArch() == Triple.ArchType.thumb
         || _Triple.getArch() == Triple.ArchType.thumbeb
         || _Triple.getArch() == Triple.ArchType.wasm32
         || _Triple.getArch() == Triple.ArchType.wasm64;
    } else if ($eq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"posix")) {
      return true;
    }
    
    return false;
  }

  
  /// ComputeLLVMTriple - Return the LLVM target triple to use, after taking
  /// command line arguments into account.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::ComputeLLVMTriple">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 416,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 409,
   FQN="clang::driver::ToolChain::ComputeLLVMTriple", NM="_ZNK5clang6driver9ToolChain17ComputeLLVMTripleERKN4llvm3opt7ArgListENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain17ComputeLLVMTripleERKN4llvm3opt7ArgListENS0_5types2IDE")
  //</editor-fold>
  public std.string ComputeLLVMTriple(/*const*/ ArgList /*&*/ Args) /*const*/ {
    return ComputeLLVMTriple(Args, 
                   types.ID.TY_INVALID);
  }
  public std.string ComputeLLVMTriple(/*const*/ ArgList /*&*/ Args, 
                   types.ID InputType/*= types::TY_INVALID*/) /*const*/ {
    switch (getTriple().getArch()) {
     default:
      return getTripleString();
     case x86_64:
      {
        Triple Triple = new Triple(getTriple());
        if (!Triple.isOSBinFormatMachO()) {
          return getTripleString();
        }
        {
          
          Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
          if ((A != null)) {
            // x86_64h goes in the triple. Other -march options just use the
            // vanilla triple we already have.
            StringRef MArch = new StringRef(A.getValue());
            if ($eq_StringRef(/*NO_COPY*/MArch, /*STRINGREF_STR*/"x86_64h")) {
              Triple.setArchName(new StringRef(MArch));
            }
          }
        }
        return new std.string(Triple.getTriple());
      }
     case aarch64:
      {
        Triple Triple = new Triple(getTriple());
        if (!Triple.isOSBinFormatMachO()) {
          return getTripleString();
        }
        
        // FIXME: older versions of ld64 expect the "arm64" component in the actual
        // triple string and query it to determine whether an LTO file can be
        // handled. Remove this when we don't care any more.
        Triple.setArchName(new StringRef(/*KEEP_STR*/"arm64"));
        return new std.string(Triple.getTriple());
      }
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      {
        // FIXME: Factor into subclasses.
        Triple _Triple = new Triple(getTriple());
        boolean IsBigEndian = getTriple().getArch() == Triple.ArchType.armeb
           || getTriple().getArch() == Triple.ArchType.thumbeb;
        {
          
          // Handle pseudo-target flags '-mlittle-endian'/'-EL' and
          // '-mbig-endian'/'-EB'.
          Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mlittle_endian.getValue()), 
              new OptSpecifier(options.ID.OPT_mbig_endian.getValue()));
          if ((A != null)) {
            IsBigEndian = !A.getOption().matches(new OptSpecifier(options.ID.OPT_mlittle_endian.getValue()));
          }
        }
        
        // Thumb2 is the default for V7 on Darwin.
        //
        // FIXME: Thumb should just be another -target-feaure, not in the triple.
        StringRef MCPU/*J*/= new StringRef(), MArch/*J*/= new StringRef();
        {
          /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
          if ((A != null)) {
            MCPU.$assignMove(/*STRINGREF_STR*/A.getValue());
          }
        }
        {
          /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
          if ((A != null)) {
            MArch.$assignMove(/*STRINGREF_STR*/A.getValue());
          }
        }
        std.string CPU = _Triple.isOSBinFormatMachO() ? ArmStatics.getARMCPUForMArch(new StringRef(MArch), _Triple).str() : ArmStatics.getARMTargetCPU(new StringRef(MCPU), new StringRef(MArch), _Triple);
        StringRef Suffix = ArmStatics.getLLVMArchSuffixForARM(new StringRef(CPU), new StringRef(MArch), _Triple);
        boolean IsMProfile = ARM.parseArchProfile(/*NO_COPY*/Suffix) == ARM.ProfileKind.PK_M.getValue();
        boolean ThumbDefault = IsMProfile || (ARM.parseArchVersion(/*NO_COPY*/Suffix) == 7
           && getTriple().isOSBinFormatMachO());
        // FIXME: this is invalid for WindowsCE
        if (getTriple().isOSWindows()) {
          ThumbDefault = true;
        }
        std.string ArchName/*J*/= new std.string();
        if (IsBigEndian) {
          ArchName.$assign(/*KEEP_STR*/"armeb");
        } else {
          ArchName.$assign(/*KEEP_STR*/"arm");
        }
        
        // Assembly files should start in ARM mode, unless arch is M-profile.
        if ((InputType != types.ID.TY_PP_Asm && Args.hasFlag(new OptSpecifier(options.ID.OPT_mthumb.getValue()), 
            new OptSpecifier(options.ID.OPT_mno_thumb.getValue()), ThumbDefault)) || IsMProfile) {
          if (IsBigEndian) {
            ArchName.$assign(/*KEEP_STR*/"thumbeb");
          } else {
            ArchName.$assign(/*KEEP_STR*/"thumb");
          }
        }
        _Triple.setArchName(new StringRef($add_string$C_string(ArchName, Suffix.str())));
        
        return new std.string(_Triple.getTriple());
      }
    }
  }

  
  /// ComputeEffectiveClangTriple - Return the Clang triple to use for this
  /// target, which may take into account the command line arguments. For
  /// example, on Darwin the -mmacosx-version-min= command line argument (which
  /// sets the deployment target) determines the version in the triple passed to
  /// Clang.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::ComputeEffectiveClangTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 504,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 497,
   FQN="clang::driver::ToolChain::ComputeEffectiveClangTriple", NM="_ZNK5clang6driver9ToolChain27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE")
  //</editor-fold>
  public std.string ComputeEffectiveClangTriple(/*const*/ ArgList /*&*/ Args) /*const*/ {
    return ComputeEffectiveClangTriple(Args, 
                             types.ID.TY_INVALID);
  }
  public std.string ComputeEffectiveClangTriple(/*const*/ ArgList /*&*/ Args, 
                             types.ID InputType/*= types::TY_INVALID*/) /*const*/ {
    return ComputeLLVMTriple(Args, InputType);
  }

  
  /// getDefaultObjCRuntime - Return the default Objective-C runtime
  /// for this platform.
  ///
  /// FIXME: this really belongs on some sort of DeploymentTarget abstraction
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getDefaultObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 396,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 389,
   FQN="clang::driver::ToolChain::getDefaultObjCRuntime", NM="_ZNK5clang6driver9ToolChain21getDefaultObjCRuntimeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain21getDefaultObjCRuntimeEb")
  //</editor-fold>
  public ObjCRuntime getDefaultObjCRuntime(boolean isNonFragile) /*const*/ {
    return new ObjCRuntime(isNonFragile ? ObjCRuntime.Kind.GNUstep : ObjCRuntime.Kind.GCC, 
        new VersionTuple());
  }

  
  /// hasBlocksRuntime - Given that the user is compiling with
  /// -fblocks, does this tool chain guarantee the existence of a
  /// blocks runtime?
  ///
  /// FIXME: this really belongs on some sort of DeploymentTarget abstraction
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::hasBlocksRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 360,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", old_line = 350,
   FQN="clang::driver::ToolChain::hasBlocksRuntime", NM="_ZNK5clang6driver9ToolChain16hasBlocksRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16hasBlocksRuntimeEv")
  //</editor-fold>
  public /*virtual*/ boolean hasBlocksRuntime() /*const*/ {
    return true;
  }

  
  /// \brief Add the clang cc1 arguments for system include paths.
  ///
  /// This routine is responsible for adding the necessary cc1 arguments to
  /// include headers from standard system header directories.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 509,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 502,
   FQN="clang::driver::ToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver9ToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*/ {
    // Each toolchain should provide the appropriate include flags.
  }

  
  /// \brief Add options that need to be passed to cc1 for this target.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addClangTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 514,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 507,
   FQN="clang::driver::ToolChain::addClangTargetOptions", NM="_ZNK5clang6driver9ToolChain21addClangTargetOptionsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain21addClangTargetOptionsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void addClangTargetOptions(/*const*/ ArgList /*&*/ DriverArgs, 
                       ArgStringList/*&*/ CC1Args) /*const*/ {
  }

  
  /// \brief Add warning options that need to be passed to cc1 for this target.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addClangWarningOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 518,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 511,
   FQN="clang::driver::ToolChain::addClangWarningOptions", NM="_ZNK5clang6driver9ToolChain22addClangWarningOptionsERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain22addClangWarningOptionsERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void addClangWarningOptions(ArgStringList/*&*/ CC1Args) /*const*/ {
  }

  
  // GetRuntimeLibType - Determine the runtime library type to use with the
  // given compilation arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetRuntimeLibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 527,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 521,
   FQN="clang::driver::ToolChain::GetRuntimeLibType", NM="_ZNK5clang6driver9ToolChain17GetRuntimeLibTypeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain17GetRuntimeLibTypeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public ToolChain.RuntimeLibType GetRuntimeLibType(/*const*/ ArgList /*&*/ Args) /*const*/ {
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_rtlib_EQ.getValue()));
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef Value = new StringRef(A.getValue());
          if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"compiler-rt")) {
            return ToolChain.RuntimeLibType.RLT_CompilerRT;
          }
          if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"libgcc")) {
            return ToolChain.RuntimeLibType.RLT_Libgcc;
          }
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_rtlib_name)), 
              new StringRef(A.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return GetDefaultRuntimeLibType();
  }

  
  // GetCXXStdlibType - Determine the C++ standard library type to use with the
  // given compilation arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::GetCXXStdlibType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 554,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 536,
   FQN="clang::driver::ToolChain::GetCXXStdlibType", NM="_ZNK5clang6driver9ToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public ToolChain.CXXStdlibType GetCXXStdlibType(/*const*/ ArgList /*&*/ Args) /*const*/ {
    type$ref<ToolChain.CXXStdlibType> Type = create_type$ref(null);
    boolean HasValidType = false;
    boolean ForcePlatformDefault = false;
    
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue()));
    if ((A != null)) {
      StringRef Value = new StringRef(A.getValue());
      HasValidType = ParseCXXStdlibType(Value, Type);
      
      // Only use in tests to override CLANG_DEFAULT_CXX_STDLIB!
      if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"platform")) {
        ForcePlatformDefault = true;
      } else if (!HasValidType) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_stdlib_name)), 
              new StringRef(A.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!HasValidType && (ForcePlatformDefault
       || !ParseCXXStdlibType(new StringRef(/*KEEP_STR*/$EMPTY), Type))) {
      Type.$set(GetDefaultCXXStdlibType());
    }
    assert Type.$deref() != null;
    return Type.$deref();
  }

  
  /// AddClangCXXStdlibIncludeArgs - Add the clang -cc1 level arguments to set
  /// the include paths to use for the given C++ standard library type.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 619,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 590,
   FQN="clang::driver::ToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver9ToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                              ArgStringList/*&*/ CC1Args) /*const*/ {
    // Header search paths should be handled by each of the subclasses.
    // Historically, they have not been, and instead have been handled inside of
    // the CC1-layer frontend. As the logic is hoisted out, this generic function
    // will slowly stop being called.
    //
    // While it is being called, replicate a bit of a hack to propagate the
    // '-stdlib=' flag down to CC1 so that it can in turn customize the C++
    // header search paths with it. Once all systems are overriding this
    // function, the CC1 flag and this line can be removed.
    DriverArgs.AddAllArgs(CC1Args, new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue()));
  }

  
  /// AddCXXStdlibLibArgs - Add the system specific linker arguments to use
  /// for the given C++ standard library type.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 633,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 604,
   FQN="clang::driver::ToolChain::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver9ToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ Args, 
                     ArgStringList/*&*/ CmdArgs) /*const*/ {
    CXXStdlibType Type = GetCXXStdlibType(Args);
    switch (Type) {
     case CST_Libcxx:
      CmdArgs.push_back($("-lc++"));
      break;
     case CST_Libstdcxx:
      CmdArgs.push_back($("-lstdc++"));
      break;
    }
  }

  
  /// AddFilePathLibArgs - Add each thing in getFilePaths() as a "-L" option.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddFilePathLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 648,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 619,
   FQN="clang::driver::ToolChain::AddFilePathLibArgs", NM="_ZNK5clang6driver9ToolChain18AddFilePathLibArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain18AddFilePathLibArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddFilePathLibArgs(/*const*/ ArgList /*&*/ Args, 
                    ArgStringList/*&*/ CmdArgs) /*const*/ {
    for (/*const*/std.string/*&*/ LibPath : getFilePaths())  {
      if ($greater_uint(LibPath.length(), 0)) {
        CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*STRINGREF_STR*/"-L"), new Twine(LibPath))));
      }
    }
  }

  
  /// AddCCKextLibArgs - Add the system specific linker arguments to use
  /// for kernel extensions (Darwin-specific).
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddCCKextLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 655,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 626,
   FQN="clang::driver::ToolChain::AddCCKextLibArgs", NM="_ZNK5clang6driver9ToolChain16AddCCKextLibArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16AddCCKextLibArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddCCKextLibArgs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*/ {
    CmdArgs.push_back($("-lcc_kext"));
  }

  
  /// AddFastMathRuntimeIfAvailable - If a runtime library exists that sets
  /// global flags for unsafe floating point math, add it and return true.
  ///
  /// This checks for presence of the -Ofast, -ffast-math or -funsafe-math flags.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddFastMathRuntimeIfAvailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 660,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 631,
   FQN="clang::driver::ToolChain::AddFastMathRuntimeIfAvailable", NM="_ZNK5clang6driver9ToolChain29AddFastMathRuntimeIfAvailableERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain29AddFastMathRuntimeIfAvailableERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public boolean AddFastMathRuntimeIfAvailable(/*const*/ ArgList /*&*/ Args, 
                               ArgStringList/*&*/ CmdArgs) /*const*/ {
    // Do not check for -fno-fast-math or -fno-unsafe-math when -Ofast passed
    // (to keep the linker options consistent with gcc and clang itself).
    if (!isOptimizationLevelFast(Args)) {
      // Check if -ffast-math or -funsafe-math.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), 
          new OptSpecifier(options.ID.OPT_funsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_unsafe_math_optimizations.getValue()));
      if (!(A != null) || A.getOption().getID() == options.ID.OPT_fno_fast_math.getValue()
         || A.getOption().getID() == options.ID.OPT_fno_unsafe_math_optimizations.getValue()) {
        return false;
      }
    }
    // If crtfastmath.o exists add it to the arguments.
    std.string Path = GetFilePath($("crtfastmath.o"));
    if ($eq_string$C_T(Path, /*KEEP_STR*/"crtfastmath.o")) { // Not found.
      return false;
    }
    
    CmdArgs.push_back(Args.MakeArgString(new Twine(Path)));
    return true;
  }

  /// addProfileRTLibs - When -fprofile-instr-profile is specified, try to pass
  /// a suitable profile runtime library to the linker.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::addProfileRTLibs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 520,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 513,
   FQN="clang::driver::ToolChain::addProfileRTLibs", NM="_ZNK5clang6driver9ToolChain16addProfileRTLibsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain16addProfileRTLibsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void addProfileRTLibs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*/ {
    if (!needsProfileRT(Args)) {
      return;
    }
    
    CmdArgs.push_back(getCompilerRTArgString(Args, new StringRef(/*KEEP_STR*/"profile")));
  }

  
  /// \brief Add arguments to use system-specific CUDA includes.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddCudaIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 696,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 667,
   FQN="clang::driver::ToolChain::AddCudaIncludeArgs", NM="_ZNK5clang6driver9ToolChain18AddCudaIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain18AddCudaIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddCudaIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                    ArgStringList/*&*/ CC1Args) /*const*/ {
  }

  
  /// \brief Add arguments to use MCU GCC toolchain includes.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::AddIAMCUIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 699,
   FQN="clang::driver::ToolChain::AddIAMCUIncludeArgs", NM="_ZNK5clang6driver9ToolChain19AddIAMCUIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain19AddIAMCUIncludeArgsERKN4llvm3opt7ArgListERNS2_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddIAMCUIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                     ArgStringList/*&*/ CC1Args) /*const*/ {
  }

  
  /// \brief Return sanitizers which are available in this toolchain.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 684,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 655,
   FQN="clang::driver::ToolChain::getSupportedSanitizers", NM="_ZNK5clang6driver9ToolChain22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain22getSupportedSanitizersEv")
  //</editor-fold>
  public long/*uint64_t*/ getSupportedSanitizers() /*const*/ {
    // Return sanitizers which don't require runtime support and are not
    // platform dependent.
    //JAVA: using namespace SanitizerKind;
    long/*uint64_t*/ Res = (Undefined & ~Vptr & ~Function) | (CFI & ~CFIICall)
       | CFICastStrict | UnsignedIntegerOverflow | LocalBounds;
    if (getTriple().getArch() == Triple.ArchType.x86
       || getTriple().getArch() == Triple.ArchType.x86_64) {
      Res |= CFIICall;
    }
    return Res;
  }

  
  /// \brief Return sanitizers which are enabled by default.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getDefaultSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 429,
   FQN="clang::driver::ToolChain::getDefaultSanitizers", NM="_ZNK5clang6driver9ToolChain20getDefaultSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain20getDefaultSanitizersEv")
  //</editor-fold>
  public /*virtual*/ long/*uint64_t*/ getDefaultSanitizers() /*const*/ {
    return 0;
  }

  
  /// \brief On Windows, returns the version of cl.exe.  On other platforms,
  /// returns an empty VersionTuple.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ToolChain::getMSVCVersionFromExe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/ToolChain.h", line = 433,
   FQN="clang::driver::ToolChain::getMSVCVersionFromExe", NM="_ZNK5clang6driver9ToolChain21getMSVCVersionFromExeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZNK5clang6driver9ToolChain21getMSVCVersionFromExeEv")
  //</editor-fold>
  public /*virtual*/ VersionTuple getMSVCVersionFromExe() /*const*/ {
    return new VersionTuple();
  }

  
  public String toString() {
    return "" + "D=" + D // NOI18N
              + ", _Triple=" + _Triple // NOI18N
              + ", Args=" + Args // NOI18N
              + ", CachedRTTIArg=" + CachedRTTIArg // NOI18N
              + ", CachedRTTIMode=" + CachedRTTIMode // NOI18N
              + ", FilePaths=" + FilePaths // NOI18N
              + ", ProgramPaths=" + ProgramPaths // NOI18N
              + ", Clang=" + Clang // NOI18N
              + ", Assemble=" + Assemble // NOI18N
              + ", Link=" + Link // NOI18N
              + ", SanitizerArguments=" + SanitizerArguments // NOI18N
              + ", Multilibs=" + Multilibs // NOI18N
              + ", DefaultLinker=" + DefaultLinker; // NOI18N
  }
}
