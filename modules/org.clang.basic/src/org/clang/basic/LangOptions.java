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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Keeps track of the various options that can be
/// enabled, which controls the dialect of C or C++ that is accepted.
//<editor-fold defaultstate="collapsed" desc="clang::LangOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 48,
 FQN="clang::LangOptions", NM="_ZN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptionsE")
//</editor-fold>
public class LangOptions extends /*public*/ LangOptionsBase implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef clang::Visibility Visibility*/
//  public final class Visibility extends Visibility{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::GCMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 52,
   FQN="clang::LangOptions::GCMode", NM="_ZN5clang11LangOptions6GCModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions6GCModeE")
  //</editor-fold>
  public enum GCMode implements Native.ComparableLower {
    NonGC(0),
    GCOnly(NonGC.getValue() + 1),
    HybridGC(GCOnly.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static GCMode valueOf(int val) {
      GCMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final GCMode[] VALUES;
      private static final GCMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (GCMode kind : GCMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new GCMode[min < 0 ? (1-min) : 0];
        VALUES = new GCMode[max >= 0 ? (1+max) : 0];
        for (GCMode kind : GCMode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private GCMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((GCMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((GCMode)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::StackProtectorMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 53,
   FQN="clang::LangOptions::StackProtectorMode", NM="_ZN5clang11LangOptions18StackProtectorModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions18StackProtectorModeE")
  //</editor-fold>
  public enum StackProtectorMode implements Native.ComparableLower {
    SSPOff(0),
    SSPOn(SSPOff.getValue() + 1),
    SSPStrong(SSPOn.getValue() + 1),
    SSPReq(SSPStrong.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StackProtectorMode valueOf(int val) {
      StackProtectorMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StackProtectorMode[] VALUES;
      private static final StackProtectorMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StackProtectorMode kind : StackProtectorMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StackProtectorMode[min < 0 ? (1-min) : 0];
        VALUES = new StackProtectorMode[max >= 0 ? (1+max) : 0];
        for (StackProtectorMode kind : StackProtectorMode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private StackProtectorMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((StackProtectorMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((StackProtectorMode)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::SignedOverflowBehaviorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 55,
   FQN="clang::LangOptions::SignedOverflowBehaviorTy", NM="_ZN5clang11LangOptions24SignedOverflowBehaviorTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions24SignedOverflowBehaviorTyE")
  //</editor-fold>
  public enum SignedOverflowBehaviorTy implements Native.ComparableLower {
    SOB_Undefined(0), // Default C standard behavior.
    SOB_Defined(SOB_Undefined.getValue() + 1), // -fwrapv
    SOB_Trapping(SOB_Defined.getValue() + 1); // -ftrapv

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SignedOverflowBehaviorTy valueOf(int val) {
      SignedOverflowBehaviorTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SignedOverflowBehaviorTy[] VALUES;
      private static final SignedOverflowBehaviorTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SignedOverflowBehaviorTy kind : SignedOverflowBehaviorTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SignedOverflowBehaviorTy[min < 0 ? (1-min) : 0];
        VALUES = new SignedOverflowBehaviorTy[max >= 0 ? (1+max) : 0];
        for (SignedOverflowBehaviorTy kind : SignedOverflowBehaviorTy.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SignedOverflowBehaviorTy(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SignedOverflowBehaviorTy)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SignedOverflowBehaviorTy)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::PragmaMSPointersToMembersKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*INVALID*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 61,
   FQN="clang::LangOptions::PragmaMSPointersToMembersKind", NM="_ZN5clang11LangOptions29PragmaMSPointersToMembersKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions29PragmaMSPointersToMembersKindE")
  //</editor-fold>
  public enum PragmaMSPointersToMembersKind implements Native.ComparableLower {
    PPTMK_INVALID(-1), // JAVA
    PPTMK_BestCase(0),
    PPTMK_FullGeneralitySingleInheritance(PPTMK_BestCase.getValue() + 1),
    PPTMK_FullGeneralityMultipleInheritance(PPTMK_FullGeneralitySingleInheritance.getValue() + 1),
    PPTMK_FullGeneralityVirtualInheritance(PPTMK_FullGeneralityMultipleInheritance.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PragmaMSPointersToMembersKind valueOf(int val) {
      PragmaMSPointersToMembersKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PragmaMSPointersToMembersKind[] VALUES;
      private static final PragmaMSPointersToMembersKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PragmaMSPointersToMembersKind kind : PragmaMSPointersToMembersKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PragmaMSPointersToMembersKind[min < 0 ? (1-min) : 0];
        VALUES = new PragmaMSPointersToMembersKind[max >= 0 ? (1+max) : 0];
        for (PragmaMSPointersToMembersKind kind : PragmaMSPointersToMembersKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private PragmaMSPointersToMembersKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((PragmaMSPointersToMembersKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((PragmaMSPointersToMembersKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::DefaultCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 68,
   FQN="clang::LangOptions::DefaultCallingConvention", NM="_ZN5clang11LangOptions24DefaultCallingConventionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions24DefaultCallingConventionE")
  //</editor-fold>
  public enum DefaultCallingConvention implements Native.ComparableLower {
    DCC_None(0),
    DCC_CDecl(DCC_None.getValue() + 1),
    DCC_FastCall(DCC_CDecl.getValue() + 1),
    DCC_StdCall(DCC_FastCall.getValue() + 1),
    DCC_VectorCall(DCC_StdCall.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DefaultCallingConvention valueOf(int val) {
      DefaultCallingConvention out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DefaultCallingConvention[] VALUES;
      private static final DefaultCallingConvention[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DefaultCallingConvention kind : DefaultCallingConvention.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DefaultCallingConvention[min < 0 ? (1-min) : 0];
        VALUES = new DefaultCallingConvention[max >= 0 ? (1+max) : 0];
        for (DefaultCallingConvention kind : DefaultCallingConvention.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DefaultCallingConvention(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DefaultCallingConvention)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DefaultCallingConvention)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::AddrSpaceMapMangling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 68,
   FQN="clang::LangOptions::AddrSpaceMapMangling", NM="_ZN5clang11LangOptions20AddrSpaceMapManglingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions20AddrSpaceMapManglingE")
  //</editor-fold>
  public enum AddrSpaceMapMangling implements Native.ComparableLower {
    ASMM_Target(0),
    ASMM_On(ASMM_Target.getValue() + 1),
    ASMM_Off(ASMM_On.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AddrSpaceMapMangling valueOf(int val) {
      AddrSpaceMapMangling out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AddrSpaceMapMangling[] VALUES;
      private static final AddrSpaceMapMangling[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AddrSpaceMapMangling kind : AddrSpaceMapMangling.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AddrSpaceMapMangling[min < 0 ? (1-min) : 0];
        VALUES = new AddrSpaceMapMangling[max >= 0 ? (1+max) : 0];
        for (AddrSpaceMapMangling kind : AddrSpaceMapMangling.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AddrSpaceMapMangling(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AddrSpaceMapMangling)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AddrSpaceMapMangling)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::MSVCMajorVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 70,
   FQN="clang::LangOptions::MSVCMajorVersion", NM="_ZN5clang11LangOptions16MSVCMajorVersionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions16MSVCMajorVersionE")
  //</editor-fold>
  public enum MSVCMajorVersion implements Native.ComparableLower {
    MSVC2010(16),
    MSVC2012(17),
    MSVC2013(18),
    MSVC2015(19);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MSVCMajorVersion valueOf(int val) {
      MSVCMajorVersion out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MSVCMajorVersion[] VALUES;
      private static final MSVCMajorVersion[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MSVCMajorVersion kind : MSVCMajorVersion.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MSVCMajorVersion[min < 0 ? (1-min) : 0];
        VALUES = new MSVCMajorVersion[max >= 0 ? (1+max) : 0];
        for (MSVCMajorVersion kind : MSVCMajorVersion.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private MSVCMajorVersion(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MSVCMajorVersion)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MSVCMajorVersion)obj).value);}
    //</editor-fold>
  };
/*public:*/
  /// \brief Set of enabled sanitizers.
  public SanitizerSet Sanitize;
  
  /// \brief Paths to blacklist files specifying which objects
  /// (files, functions, variables) should not be instrumented.
  public std.vectorString SanitizerBlacklistFiles;
  
  public ObjCRuntime ObjCRuntime;
  
  public std.string ObjCConstantStringClass;
  
  /// \brief The name of the handler function to be called when -ftrapv is
  /// specified.
  ///
  /// If none is specified, abort (GCC-compatible behaviour).
  public std.string OverflowHandler;
  
  /// \brief The name of the current module, of which the main source file
  /// is a part. If CompilingModule is set, we are compiling the interface
  /// of this module, otherwise we are compiling an implementation file of
  /// it.
  public std.string CurrentModule;
  
  /// \brief The names of any features to enable in module 'requires' decls
  /// in addition to the hard-coded list in Module.cpp and the target features.
  ///
  /// This list is sorted.
  public std.vectorString ModuleFeatures;
  
  /// \brief Options for parsing comments.
  public CommentOptions CommentOpts;
  
  /// \brief A list of all -fno-builtin-* function names (e.g., memset).
  public std.vectorString NoBuiltinFuncs;
  
  /// \brief Triples of the OpenMP targets that the host code codegen should
  /// take into account in order to generate accurate offloading descriptors.
  public std.vector<Triple> OMPTargetTriples;
  
  /// \brief Name of the IR file that contains the result of the OpenMP target
  /// host code generation.
  public std.string OMPHostIRFile;
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::LangOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp", line = 18,
   FQN="clang::LangOptions::LangOptions", NM="_ZN5clang11LangOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZN5clang11LangOptionsC1Ev")
  //</editor-fold>
  public LangOptions() {
    /* : LangOptionsBase(), Sanitize(), SanitizerBlacklistFiles(), ObjCRuntime(), ObjCConstantStringClass(), OverflowHandler(), CurrentModule(), ModuleFeatures(), CommentOpts(), NoBuiltinFuncs(), OMPTargetTriples(), OMPHostIRFile()*/ 
    //START JInit
    super();
    this.Sanitize = new SanitizerSet();
    this.SanitizerBlacklistFiles = new std.vectorString(std.string.EMPTY);
    this.ObjCRuntime = new ObjCRuntime();
    this.ObjCConstantStringClass = new std.string();
    this.OverflowHandler = new std.string();
    this.CurrentModule = new std.string();
    this.ModuleFeatures = new std.vectorString(std.string.EMPTY);
    this.CommentOpts = new CommentOptions();
    this.NoBuiltinFuncs = new std.vectorString(std.string.EMPTY);
    this.OMPTargetTriples = new std.vector<Triple>(new Triple());
    this.OMPHostIRFile = new std.string();
    //END JInit
    
    // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
    C99 = false;
    C11 = false;
    MSVCCompat = false;
    MicrosoftExt = false;
    AsmBlocks = false;
    Borland = false;
    CPlusPlus = false;
    CPlusPlus11 = false;
    CPlusPlus14 = false;
    CPlusPlus1z = false;
    ObjC1 = false;
    ObjC2 = false;
    ObjCDefaultSynthProperties = false;
    EncodeExtendedBlockSig = false;
    ObjCInferRelatedResultType = true;
    AppExt = false;
    Trigraphs = false;
    LineComment = false;
    Bool = false;
    Half = false;
    WChar = CPlusPlus;
    DeclSpecKeyword = false;
    DollarIdents = true;
    AsmPreprocessor = false;
    GNUMode = true;
    GNUKeywords = true;
    ImplicitInt = !C99 && !CPlusPlus;
    Digraphs = false;
    HexFloats = C99;
    CXXOperatorNames = false;
    AppleKext = false;
    PascalStrings = false;
    WritableStrings = false;
    ConstStrings = false;
    LaxVectorConversions = true;
    AltiVec = false;
    ZVector = false;
    Exceptions = false;
    ObjCExceptions = false;
    CXXExceptions = false;
    SjLjExceptions = false;
    ExternCNoUnwind = false;
    TraditionalCPP = false;
    RTTI = true;
    RTTIData = true;
    MSBitfields = false;
    Freestanding = false;
    NoBuiltin = false;
    NoMathBuiltin = false;
    GNUAsm = true;
    Coroutines = false;
    ThreadsafeStatics = true;
    POSIXThreads = false;
    Blocks = false;
    EmitAllDecls = false;
    MathErrno = true;
    HeinousExtensions = false;
    Modules = false;
    CompilingModule = false;
    ModulesDeclUse = false;
    ModulesSearchAll = true;
    ModulesStrictDeclUse = false;
    ModulesErrorRecovery = true;
    ImplicitModules = true;
    ModulesLocalVisibility = false;
    Optimize = false;
    OptimizeSize = false;
    Static = false;
    PackStruct = 0;
    MaxTypeAlign = 0;
    AlignDouble = false;
    PICLevel = 0;
    PIE = false;
    GNUInline = false;
    NoInlineDefine = false;
    Deprecated = false;
    FastMath = false;
    FiniteMathOnly = false;
    UnsafeFPMath = false;
    ObjCGCBitmapPrint = false;
    AccessControl = true;
    CharIsSigned = true;
    ShortWChar = false;
    setMSPointerToMemberRepresentationMethod(PragmaMSPointersToMembersKind.PPTMK_BestCase);
    setDefaultCallingConv(DefaultCallingConvention.DCC_None);
    ShortEnums = false;
    OpenCL = false;
    OpenCLVersion = 0;
    NativeHalfType = false;
    NativeHalfArgsAndReturns = false;
    HalfArgsAndReturns = false;
    CUDA = false;
    OpenMP = 0;
    OpenMPUseTLS = false;
    OpenMPIsDevice = false;
    RenderScript = false;
    CUDAIsDevice = false;
    CUDAAllowVariadicFunctions = false;
    CUDAHostDeviceConstexpr = true;
    CUDADeviceFlushDenormalsToZero = false;
    CUDADeviceApproxTranscendentals = false;
    SizedDeallocation = false;
    ConceptsTS = false;
    ElideConstructors = true;
    DumpRecordLayouts = false;
    DumpRecordLayoutsSimple = false;
    DumpVTableLayouts = false;
    NoConstantCFStrings = false;
    InlineVisibilityHidden = false;
    ParseUnknownAnytype = false;
    DebuggerSupport = false;
    DebuggerCastResultToId = false;
    DebuggerObjCLiteral = false;
    SpellChecking = true;
    SinglePrecisionConstants = false;
    FastRelaxedMath = false;
    DefaultFPContract = false;
    NoBitFieldTypeAlign = false;
    HexagonQdsp6Compat = false;
    ObjCAutoRefCount = false;
    ObjCWeakRuntime = false;
    ObjCWeak = false;
    ObjCSubscriptingLegacyRuntime = false;
    FakeAddressSpaceMap = false;
    setAddressSpaceMapMangling(AddrSpaceMapMangling.ASMM_Target);
    IncludeDefaultHeader = false;
    DelayedTemplateParsing = false;
    BlocksRuntimeOptional = false;
    setGC(GCMode.NonGC);
    setValueVisibilityMode(Visibility.DefaultVisibility);
    setTypeVisibilityMode(Visibility.DefaultVisibility);
    setStackProtector(StackProtectorMode.SSPOff);
    setSignedOverflowBehavior(SignedOverflowBehaviorTy.SOB_Undefined);
    ArrowDepth = 256;
    InstantiationDepth = 256;
    ConstexprCallDepth = 512;
    ConstexprStepLimit = 1048576;
    BracketDepth = 256;
    NumLargeByValueCopy = 0;
    MSCompatibilityVersion = 0;
    VtorDispMode = 1;
    ApplePragmaPack = false;
    RetainCommentsFromSystemHeaders = false;
    SanitizeAddressFieldPadding = 0;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getMSPointerToMemberRepresentationMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 174,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 157,
   FQN="clang::LangOptions::getMSPointerToMemberRepresentationMethod", NM="_ZNK5clang11LangOptions40getMSPointerToMemberRepresentationMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions40getMSPointerToMemberRepresentationMethodEv")
  //</editor-fold>
  public PragmaMSPointersToMembersKind getMSPointerToMemberRepresentationMethod() /*const*/ {
    return (/*static_cast*/PragmaMSPointersToMembersKind.valueOf(MSPointerToMemberRepresentationMethod));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setMSPointerToMemberRepresentationMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 174,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 157,
   FQN="clang::LangOptions::setMSPointerToMemberRepresentationMethod", NM="_ZN5clang11LangOptions40setMSPointerToMemberRepresentationMethodENS0_29PragmaMSPointersToMembersKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions40setMSPointerToMemberRepresentationMethodENS0_29PragmaMSPointersToMembersKindE")
  //</editor-fold>
  public void setMSPointerToMemberRepresentationMethod(PragmaMSPointersToMembersKind Value) {
    MSPointerToMemberRepresentationMethod = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getDefaultCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 175,
   FQN="clang::LangOptions::getDefaultCallingConv", NM="_ZNK5clang11LangOptions21getDefaultCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions21getDefaultCallingConvEv")
  //</editor-fold>
  public DefaultCallingConvention getDefaultCallingConv() /*const*/ {
    return (/*static_cast*/DefaultCallingConvention.valueOf(DefaultCallingConv));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setDefaultCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 175,
   FQN="clang::LangOptions::setDefaultCallingConv", NM="_ZN5clang11LangOptions21setDefaultCallingConvENS0_24DefaultCallingConventionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions21setDefaultCallingConvENS0_24DefaultCallingConventionE")
  //</editor-fold>
  public void setDefaultCallingConv(DefaultCallingConvention Value) {
    DefaultCallingConv = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getAddressSpaceMapMangling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 220,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 200,
   FQN="clang::LangOptions::getAddressSpaceMapMangling", NM="_ZNK5clang11LangOptions26getAddressSpaceMapManglingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions26getAddressSpaceMapManglingEv")
  //</editor-fold>
  public AddrSpaceMapMangling getAddressSpaceMapMangling() /*const*/ {
    return (/*static_cast*/AddrSpaceMapMangling.valueOf(AddressSpaceMapMangling));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setAddressSpaceMapMangling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 220,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 200,
   FQN="clang::LangOptions::setAddressSpaceMapMangling", NM="_ZN5clang11LangOptions26setAddressSpaceMapManglingENS0_20AddrSpaceMapManglingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions26setAddressSpaceMapManglingENS0_20AddrSpaceMapManglingE")
  //</editor-fold>
  public void setAddressSpaceMapMangling(AddrSpaceMapMangling Value) {
    AddressSpaceMapMangling = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 206,
   FQN="clang::LangOptions::getGC", NM="_ZNK5clang11LangOptions5getGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions5getGCEv")
  //</editor-fold>
  public GCMode getGC() /*const*/ {
    return (/*static_cast*/GCMode.valueOf(GC));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 206,
   FQN="clang::LangOptions::setGC", NM="_ZN5clang11LangOptions5setGCENS0_6GCModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions5setGCENS0_6GCModeE")
  //</editor-fold>
  public void setGC(GCMode Value) {
    GC = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getValueVisibilityMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 207,
   FQN="clang::LangOptions::getValueVisibilityMode", NM="_ZNK5clang11LangOptions22getValueVisibilityModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions22getValueVisibilityModeEv")
  //</editor-fold>
  public Visibility getValueVisibilityMode() /*const*/ {
    return (/*static_cast*/Visibility.valueOf(ValueVisibilityMode));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setValueVisibilityMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 207,
   FQN="clang::LangOptions::setValueVisibilityMode", NM="_ZN5clang11LangOptions22setValueVisibilityModeENS_10VisibilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions22setValueVisibilityModeENS_10VisibilityE")
  //</editor-fold>
  public void setValueVisibilityMode(Visibility Value) {
    ValueVisibilityMode = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getTypeVisibilityMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 209,
   FQN="clang::LangOptions::getTypeVisibilityMode", NM="_ZNK5clang11LangOptions21getTypeVisibilityModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions21getTypeVisibilityModeEv")
  //</editor-fold>
  public Visibility getTypeVisibilityMode() /*const*/ {
    return (/*static_cast*/Visibility.valueOf(TypeVisibilityMode));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setTypeVisibilityMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 209,
   FQN="clang::LangOptions::setTypeVisibilityMode", NM="_ZN5clang11LangOptions21setTypeVisibilityModeENS_10VisibilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions21setTypeVisibilityModeENS_10VisibilityE")
  //</editor-fold>
  public void setTypeVisibilityMode(Visibility Value) {
    TypeVisibilityMode = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getStackProtector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 230,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 211,
   FQN="clang::LangOptions::getStackProtector", NM="_ZNK5clang11LangOptions17getStackProtectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions17getStackProtectorEv")
  //</editor-fold>
  public StackProtectorMode getStackProtector() /*const*/ {
    return (/*static_cast*/StackProtectorMode.valueOf(StackProtector));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setStackProtector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 230,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 211,
   FQN="clang::LangOptions::setStackProtector", NM="_ZN5clang11LangOptions17setStackProtectorENS0_18StackProtectorModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions17setStackProtectorENS0_18StackProtectorModeE")
  //</editor-fold>
  public void setStackProtector(StackProtectorMode Value) {
    StackProtector = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::getSignedOverflowBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 213,
   FQN="clang::LangOptions::getSignedOverflowBehavior", NM="_ZNK5clang11LangOptions25getSignedOverflowBehaviorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions25getSignedOverflowBehaviorEv")
  //</editor-fold>
  public SignedOverflowBehaviorTy getSignedOverflowBehavior() /*const*/ {
    return (/*static_cast*/SignedOverflowBehaviorTy.valueOf(SignedOverflowBehavior));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::setSignedOverflowBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", line = 232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.def", old_line = 213,
   FQN="clang::LangOptions::setSignedOverflowBehavior", NM="_ZN5clang11LangOptions25setSignedOverflowBehaviorENS0_24SignedOverflowBehaviorTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptions25setSignedOverflowBehaviorENS0_24SignedOverflowBehaviorTyE")
  //</editor-fold>
  public void setSignedOverflowBehavior(SignedOverflowBehaviorTy Value) {
    SignedOverflowBehavior = ((/*static_cast*//*uint*/byte)(Value.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::isSignedOverflowDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 132,
   FQN="clang::LangOptions::isSignedOverflowDefined", NM="_ZNK5clang11LangOptions23isSignedOverflowDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions23isSignedOverflowDefinedEv")
  //</editor-fold>
  public boolean isSignedOverflowDefined() /*const*/ {
    return getSignedOverflowBehavior() == SignedOverflowBehaviorTy.SOB_Defined;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::isSubscriptPointerArithmetic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 142,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 136,
   FQN="clang::LangOptions::isSubscriptPointerArithmetic", NM="_ZNK5clang11LangOptions28isSubscriptPointerArithmeticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions28isSubscriptPointerArithmeticEv")
  //</editor-fold>
  public boolean isSubscriptPointerArithmetic() /*const*/ {
    return ObjCRuntime.isSubscriptPointerArithmetic()
       && !ObjCSubscriptingLegacyRuntime;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::isCompatibleWithMSVC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 141,
   FQN="clang::LangOptions::isCompatibleWithMSVC", NM="_ZNK5clang11LangOptions20isCompatibleWithMSVCENS0_16MSVCMajorVersionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang11LangOptions20isCompatibleWithMSVCENS0_16MSVCMajorVersionE")
  //</editor-fold>
  public boolean isCompatibleWithMSVC(MSVCMajorVersion MajorVersion) /*const*/ {
    return $greatereq_uint(MSCompatibilityVersion, MajorVersion.getValue() * 10000000/*U*/);
  }

  
  /// \brief Reset all of the options that are not considered when building a
  /// module.
  
  /// \brief Reset all of the options that are not considered when building a
  /// module.
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::resetNonModularOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp", line = 24,
   FQN="clang::LangOptions::resetNonModularOptions", NM="_ZN5clang11LangOptions22resetNonModularOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZN5clang11LangOptions22resetNonModularOptionsEv")
  //</editor-fold>
  public void resetNonModularOptions() {
    ObjCDefaultSynthProperties = false;
    EncodeExtendedBlockSig = false;
    ObjCInferRelatedResultType = true;
    DollarIdents = true;
    AsmPreprocessor = false;
    GNUMode = true;
    ImplicitInt = !C99 && !CPlusPlus;
    HexFloats = C99;
    PascalStrings = false;
    ThreadsafeStatics = true;
    EmitAllDecls = false;
    HeinousExtensions = false;
    CompilingModule = false;
    ModulesSearchAll = true;
    ModulesErrorRecovery = true;
    ImplicitModules = true;
    ObjCGCBitmapPrint = false;
    AccessControl = true;
    ElideConstructors = true;
    DumpRecordLayouts = false;
    DumpRecordLayoutsSimple = false;
    DumpVTableLayouts = false;
    InlineVisibilityHidden = false;
    ParseUnknownAnytype = false;
    DebuggerSupport = false;
    DebuggerCastResultToId = false;
    DebuggerObjCLiteral = false;
    SpellChecking = true;
    DelayedTemplateParsing = false;
    ArrowDepth = 256;
    InstantiationDepth = 256;
    ConstexprCallDepth = 512;
    ConstexprStepLimit = 1048576;
    BracketDepth = 256;
    NumLargeByValueCopy = 0;
    
    // FIXME: This should not be reset; modules can be different with different
    // sanitizer options (this affects __has_feature(address_sanitizer) etc).
    Sanitize.clear();
    SanitizerBlacklistFiles.clear();
    
    CurrentModule.clear();
  }


  
  /// \brief Is this a libc/libm function that is no longer recognized as a
  /// builtin because a -fno-builtin-* option has been specified?
  
  /// \brief Is this a libc/libm function that is no longer recognized as a
  /// builtin because a -fno-builtin-* option has been specified?
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::isNoBuiltinFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp", old_line = 40,
   FQN="clang::LangOptions::isNoBuiltinFunc", NM="_ZNK5clang11LangOptions15isNoBuiltinFuncEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZNK5clang11LangOptions15isNoBuiltinFuncEPKc")
  //</editor-fold>
  public boolean isNoBuiltinFunc(/*const*/char$ptr/*char P*/ Name) /*const*/ {
    StringRef FuncName/*J*/= new StringRef(Name);
    for (/*uint*/int i = 0, e = NoBuiltinFuncs.size(); i != e; ++i)  {
      if (FuncName.equals(new StringRef(NoBuiltinFuncs.$at(i)))) {
        return true;
      }
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 48,
   FQN="clang::LangOptions::operator=", NM="_ZN5clang11LangOptionsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptionsaSERKS0_")
  //</editor-fold>
  public /*inline*/ LangOptions /*&*/ $assign(/*const*/ LangOptions /*&*/ $Prm0) {
    /*Deref*/super.$assign($Prm0);
    this.Sanitize.$assign($Prm0.Sanitize);
    this.SanitizerBlacklistFiles.$assign($Prm0.SanitizerBlacklistFiles);
    this.ObjCRuntime.$assign($Prm0.ObjCRuntime);
    this.ObjCConstantStringClass.$assign($Prm0.ObjCConstantStringClass);
    this.OverflowHandler.$assign($Prm0.OverflowHandler);
    this.CurrentModule.$assign($Prm0.CurrentModule);
    this.ModuleFeatures.$assign($Prm0.ModuleFeatures);
    this.CommentOpts.$assign($Prm0.CommentOpts);
    this.NoBuiltinFuncs.$assign($Prm0.NoBuiltinFuncs);
    this.OMPTargetTriples.$assign($Prm0.OMPTargetTriples);
    this.OMPHostIRFile.$assign($Prm0.OMPHostIRFile);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::~LangOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 48,
   FQN="clang::LangOptions::~LangOptions", NM="_ZN5clang11LangOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang11LangOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OMPHostIRFile.$destroy();
    OMPTargetTriples.$destroy();
    NoBuiltinFuncs.$destroy();
    CommentOpts.$destroy();
    ModuleFeatures.$destroy();
    CurrentModule.$destroy();
    OverflowHandler.$destroy();
    ObjCConstantStringClass.$destroy();
    SanitizerBlacklistFiles.$destroy();
    //super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::LangOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 48,
   FQN="clang::LangOptions::LangOptions", NM="_ZN5clang11LangOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang11LangOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LangOptions(/*const*/ LangOptions /*&*/ $Prm0) {
    /* : LangOptionsBase(), Sanitize(.Sanitize), SanitizerBlacklistFiles(.SanitizerBlacklistFiles), ObjCRuntime(.ObjCRuntime), ObjCConstantStringClass(.ObjCConstantStringClass), OverflowHandler(.OverflowHandler), CurrentModule(.CurrentModule), ModuleFeatures(.ModuleFeatures), CommentOpts(.CommentOpts), NoBuiltinFuncs(.NoBuiltinFuncs), OMPTargetTriples(.OMPTargetTriples), OMPHostIRFile(.OMPHostIRFile)*/ 
    //START JInit
    super($Prm0);
    this.Sanitize = new SanitizerSet($Prm0.Sanitize);
    this.SanitizerBlacklistFiles = new std.vectorString($Prm0.SanitizerBlacklistFiles);
    this.ObjCRuntime = new ObjCRuntime($Prm0.ObjCRuntime);
    this.ObjCConstantStringClass = new std.string($Prm0.ObjCConstantStringClass);
    this.OverflowHandler = new std.string($Prm0.OverflowHandler);
    this.CurrentModule = new std.string($Prm0.CurrentModule);
    this.ModuleFeatures = new std.vectorString($Prm0.ModuleFeatures);
    this.CommentOpts = new CommentOptions($Prm0.CommentOpts);
    this.NoBuiltinFuncs = new std.vectorString($Prm0.NoBuiltinFuncs);
    this.OMPTargetTriples = new std.vector<Triple>($Prm0.OMPTargetTriples);
    this.OMPHostIRFile = new std.string($Prm0.OMPHostIRFile);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptions::LangOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 48,
   FQN="clang::LangOptions::LangOptions", NM="_ZN5clang11LangOptionsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang11LangOptionsC1EOS0_")
  //</editor-fold>
  public /*inline*/ LangOptions(JD$Move _dparam, LangOptions /*&&*/$Prm0) {
    /* : LangOptionsBase(static_cast<LangOptions &&>()), Sanitize(static_cast<LangOptions &&>().Sanitize), SanitizerBlacklistFiles(static_cast<LangOptions &&>().SanitizerBlacklistFiles), ObjCRuntime(static_cast<LangOptions &&>().ObjCRuntime), ObjCConstantStringClass(static_cast<LangOptions &&>().ObjCConstantStringClass), OverflowHandler(static_cast<LangOptions &&>().OverflowHandler), CurrentModule(static_cast<LangOptions &&>().CurrentModule), ModuleFeatures(static_cast<LangOptions &&>().ModuleFeatures), CommentOpts(static_cast<LangOptions &&>().CommentOpts), NoBuiltinFuncs(static_cast<LangOptions &&>().NoBuiltinFuncs), OMPTargetTriples(static_cast<LangOptions &&>().OMPTargetTriples), OMPHostIRFile(static_cast<LangOptions &&>().OMPHostIRFile)*/ 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Sanitize = new SanitizerSet(JD$Move.INSTANCE, $Prm0.Sanitize);
    this.SanitizerBlacklistFiles = new std.vectorString(JD$Move.INSTANCE, $Prm0.SanitizerBlacklistFiles);
    this.ObjCRuntime = new ObjCRuntime(JD$Move.INSTANCE, $Prm0.ObjCRuntime);
    this.ObjCConstantStringClass = new std.string(JD$Move.INSTANCE, $Prm0.ObjCConstantStringClass);
    this.OverflowHandler = new std.string(JD$Move.INSTANCE, $Prm0.OverflowHandler);
    this.CurrentModule = new std.string(JD$Move.INSTANCE, $Prm0.CurrentModule);
    this.ModuleFeatures = new std.vectorString(JD$Move.INSTANCE, $Prm0.ModuleFeatures);
    this.CommentOpts = new CommentOptions(JD$Move.INSTANCE, $Prm0.CommentOpts);
    this.NoBuiltinFuncs = new std.vectorString(JD$Move.INSTANCE, $Prm0.NoBuiltinFuncs);
    this.OMPTargetTriples = new std.vector<Triple>(JD$Move.INSTANCE, $Prm0.OMPTargetTriples);
    this.OMPHostIRFile = new std.string(JD$Move.INSTANCE, $Prm0.OMPHostIRFile);
    //END JInit
  }

  
  public String toString() {
    return "" + "Sanitize=" + Sanitize // NOI18N
              + ", SanitizerBlacklistFiles=" + SanitizerBlacklistFiles // NOI18N
              + ", ObjCRuntime=" + ObjCRuntime // NOI18N
              + ", ObjCConstantStringClass=" + ObjCConstantStringClass // NOI18N
              + ", OverflowHandler=" + OverflowHandler // NOI18N
              + ", CurrentModule=" + CurrentModule // NOI18N
              + ", ModuleFeatures=" + ModuleFeatures // NOI18N
              + ", CommentOpts=" + CommentOpts // NOI18N
              + ", NoBuiltinFuncs=" + NoBuiltinFuncs // NOI18N
              + ", OMPTargetTriples=" + OMPTargetTriples // NOI18N
              + ", OMPHostIRFile=" + OMPHostIRFile // NOI18N
              + super.toString(); // NOI18N
  }
}
