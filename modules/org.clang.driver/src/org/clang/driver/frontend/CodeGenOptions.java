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

package org.clang.driver.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.codegenoptions.*;
import org.llvm.target.target.DebuggerKind;


/// CodeGenOptions - Track various options which control how the code
/// is optimized and passed to the backend.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 44,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", old_line = 42,
 FQN="clang::CodeGenOptions", NM="_ZN5clang14CodeGenOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptionsE")
//</editor-fold>
public class CodeGenOptions extends /*public*/ CodeGenOptionsBase implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::InliningMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 46,
   FQN="clang::CodeGenOptions::InliningMethod", NM="_ZN5clang14CodeGenOptions14InliningMethodE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions14InliningMethodE")
  //</editor-fold>
  public enum InliningMethod implements Native.ComparableLower {
    NoInlining(0), // Perform no inlining whatsoever.
    NormalInlining(NoInlining.getValue() + 1), // Use the standard function inlining pass.
    OnlyHintInlining(NormalInlining.getValue() + 1), // Inline only (implicitly) hinted functions.
    OnlyAlwaysInlining(OnlyHintInlining.getValue() + 1); // Only run the always inlining pass.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InliningMethod valueOf(int val) {
      InliningMethod out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InliningMethod[] VALUES;
      private static final InliningMethod[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InliningMethod kind : InliningMethod.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InliningMethod[min < 0 ? (1-min) : 0];
        VALUES = new InliningMethod[max >= 0 ? (1+max) : 0];
        for (InliningMethod kind : InliningMethod.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private InliningMethod(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InliningMethod)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InliningMethod)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::VectorLibrary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 53,
   FQN="clang::CodeGenOptions::VectorLibrary", NM="_ZN5clang14CodeGenOptions13VectorLibraryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions13VectorLibraryE")
  //</editor-fold>
  public enum VectorLibrary implements Native.ComparableLower {
    NoLibrary(0), // Don't use any vector library.
    Accelerate(NoLibrary.getValue() + 1); // Use the Accelerate framework.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VectorLibrary valueOf(int val) {
      VectorLibrary out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VectorLibrary[] VALUES;
      private static final VectorLibrary[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VectorLibrary kind : VectorLibrary.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VectorLibrary[min < 0 ? (1-min) : 0];
        VALUES = new VectorLibrary[max >= 0 ? (1+max) : 0];
        for (VectorLibrary kind : VectorLibrary.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private VectorLibrary(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VectorLibrary)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VectorLibrary)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::ObjCDispatchMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 58,
   FQN="clang::CodeGenOptions::ObjCDispatchMethodKind", NM="_ZN5clang14CodeGenOptions22ObjCDispatchMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions22ObjCDispatchMethodKindE")
  //</editor-fold>
  public enum ObjCDispatchMethodKind implements Native.ComparableLower {
    Legacy(0),
    NonLegacy(1),
    Mixed(2);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ObjCDispatchMethodKind valueOf(int val) {
      ObjCDispatchMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ObjCDispatchMethodKind[] VALUES;
      private static final ObjCDispatchMethodKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ObjCDispatchMethodKind kind : ObjCDispatchMethodKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ObjCDispatchMethodKind[min < 0 ? (1-min) : 0];
        VALUES = new ObjCDispatchMethodKind[max >= 0 ? (1+max) : 0];
        for (ObjCDispatchMethodKind kind : ObjCDispatchMethodKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ObjCDispatchMethodKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ObjCDispatchMethodKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ObjCDispatchMethodKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::TLSModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 64,
   FQN="clang::CodeGenOptions::TLSModel", NM="_ZN5clang14CodeGenOptions8TLSModelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions8TLSModelE")
  //</editor-fold>
  public enum TLSModel implements Native.ComparableLower {
    GeneralDynamicTLSModel(0),
    LocalDynamicTLSModel(GeneralDynamicTLSModel.getValue() + 1),
    InitialExecTLSModel(LocalDynamicTLSModel.getValue() + 1),
    LocalExecTLSModel(InitialExecTLSModel.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TLSModel valueOf(int val) {
      TLSModel out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TLSModel[] VALUES;
      private static final TLSModel[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TLSModel kind : TLSModel.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TLSModel[min < 0 ? (1-min) : 0];
        VALUES = new TLSModel[max >= 0 ? (1+max) : 0];
        for (TLSModel kind : TLSModel.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TLSModel(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TLSModel)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TLSModel)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::FPContractModeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 71,
   FQN="clang::CodeGenOptions::FPContractModeKind", NM="_ZN5clang14CodeGenOptions18FPContractModeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions18FPContractModeKindE")
  //</editor-fold>
  public enum FPContractModeKind implements Native.ComparableLower {
    FPC_Off(0), // Form fused FP ops only where result will not be affected.
    FPC_On(FPC_Off.getValue() + 1), // Form fused FP ops according to FP_CONTRACT rules.
    FPC_Fast(FPC_On.getValue() + 1); // Aggressively fuse FP ops (E.g. FMA).

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FPContractModeKind valueOf(int val) {
      FPContractModeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FPContractModeKind[] VALUES;
      private static final FPContractModeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FPContractModeKind kind : FPContractModeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FPContractModeKind[min < 0 ? (1-min) : 0];
        VALUES = new FPContractModeKind[max >= 0 ? (1+max) : 0];
        for (FPContractModeKind kind : FPContractModeKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FPContractModeKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FPContractModeKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FPContractModeKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::StructReturnConventionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 77,
   FQN="clang::CodeGenOptions::StructReturnConventionKind", NM="_ZN5clang14CodeGenOptions26StructReturnConventionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions26StructReturnConventionKindE")
  //</editor-fold>
  public enum StructReturnConventionKind implements Native.ComparableLower {
    SRCK_Default(0), // No special option was passed.
    SRCK_OnStack(SRCK_Default.getValue() + 1), // Small structs on the stack (-fpcc-struct-return).
    SRCK_InRegs(SRCK_OnStack.getValue() + 1); // Small structs in registers (-freg-struct-return).

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StructReturnConventionKind valueOf(int val) {
      StructReturnConventionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StructReturnConventionKind[] VALUES;
      private static final StructReturnConventionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StructReturnConventionKind kind : StructReturnConventionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StructReturnConventionKind[min < 0 ? (1-min) : 0];
        VALUES = new StructReturnConventionKind[max >= 0 ? (1+max) : 0];
        for (StructReturnConventionKind kind : StructReturnConventionKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private StructReturnConventionKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((StructReturnConventionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((StructReturnConventionKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::ProfileInstrKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 83,
   FQN="clang::CodeGenOptions::ProfileInstrKind", NM="_ZN5clang14CodeGenOptions16ProfileInstrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions16ProfileInstrKindE")
  //</editor-fold>
  public enum ProfileInstrKind implements Native.ComparableLower {
    ProfileNone(0), // Profile instrumentation is turned off.
    ProfileClangInstr(ProfileNone.getValue() + 1), // Clang instrumentation to generate execution counts
    // to use with PGO.
    ProfileIRInstr(ProfileClangInstr.getValue() + 1); // IR level PGO instrumentation in LLVM.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ProfileInstrKind valueOf(int val) {
      ProfileInstrKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ProfileInstrKind[] VALUES;
      private static final ProfileInstrKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ProfileInstrKind kind : ProfileInstrKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ProfileInstrKind[min < 0 ? (1-min) : 0];
        VALUES = new ProfileInstrKind[max >= 0 ? (1+max) : 0];
        for (ProfileInstrKind kind : ProfileInstrKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ProfileInstrKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ProfileInstrKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ProfileInstrKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::EmbedBitcodeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 90,
   FQN="clang::CodeGenOptions::EmbedBitcodeKind", NM="_ZN5clang14CodeGenOptions16EmbedBitcodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions16EmbedBitcodeKindE")
  //</editor-fold>
  public enum EmbedBitcodeKind implements Native.ComparableLower {
    Embed_Off(0), // No embedded bitcode.
    Embed_All(Embed_Off.getValue() + 1), // Embed both bitcode and commandline in the output.
    Embed_Bitcode(Embed_All.getValue() + 1), // Embed just the bitcode in the output.
    Embed_Marker(Embed_Bitcode.getValue() + 1); // Embed a marker as a placeholder for bitcode.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EmbedBitcodeKind valueOf(int val) {
      EmbedBitcodeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final EmbedBitcodeKind[] VALUES;
      private static final EmbedBitcodeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EmbedBitcodeKind kind : EmbedBitcodeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EmbedBitcodeKind[min < 0 ? (1-min) : 0];
        VALUES = new EmbedBitcodeKind[max >= 0 ? (1+max) : 0];
        for (EmbedBitcodeKind kind : EmbedBitcodeKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private EmbedBitcodeKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EmbedBitcodeKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EmbedBitcodeKind)obj).value);}
    //</editor-fold>
  };
  
  /// The code model to use (-mcmodel).
  public std.string CodeModel;
  
  /// The filename with path we use for coverage files. The extension will be
  /// replaced.
  public std.string CoverageFile;
  
  /// The version string to put into coverage files.
  public /*char*/byte CoverageVersion[/*4*/] = new$char(4);
  
  /// Enable additional debugging information.
  public std.string DebugPass;
  
  /// The string to embed in debug information as the current working directory.
  public std.string DebugCompilationDir;
  
  /// The string to embed in the debug information for the compile unit, if
  /// non-empty.
  public std.string DwarfDebugFlags;
  
  public std.mapTypeType<std.string, std.string> DebugPrefixMap;
  
  /// The ABI to use for passing floating point arguments.
  public std.string FloatABI;
  
  /// The float precision limit to use, if non-empty.
  public std.string LimitFloatPrecision;
  
  /// The name of the bitcode file to link before optzns.
  public std.vector<std.pairUIntType<std.string>> LinkBitcodeFiles;
  
  /// The user provided name for the "main file", if non-empty. This is useful
  /// in situations where the input file name does not match the original input
  /// file, for example with -save-temps.
  public std.string MainFileName;
  
  /// The name for the split debug info file that we'll break out. This is used
  /// in the backend for setting the name in the skeleton cu.
  public std.string SplitDwarfFile;
  
  /// The name of the relocation model to use.
  public std.string RelocationModel;
  
  /// The thread model to use
  public std.string ThreadModel;
  
  /// If not an empty string, trap intrinsics are lowered to calls to this
  /// function instead of to trap instructions.
  public std.string TrapFuncName;
  
  /// A list of command-line options to forward to the LLVM backend.
  public std.vectorString BackendOptions;
  
  /// A list of dependent libraries.
  public std.vectorString DependentLibraries;
  
  /// A list of linker options to embed in the object file.
  public std.vectorString LinkerOptions;
  
  /// Name of the profile file to use as output for -fprofile-instr-generate
  /// and -fprofile-generate.
  public std.string InstrProfileOutput;
  
  /// Name of the profile file to use with -fprofile-sample-use.
  public std.string SampleProfileFile;
  
  /// Name of the profile file to use as input for -fprofile-instr-use
  public std.string ProfileInstrumentUsePath;
  
  /// Name of the function summary index file to use for ThinLTO function
  /// importing.
  public std.string ThinLTOIndexFile;
  
  /// A list of file names passed with -fcuda-include-gpubinary options to
  /// forward to CUDA runtime back-end for incorporating them into host-side
  /// object file.
  public std.vectorString CudaGpuBinaryFileNames;
  
  /// Regular expression to select optimizations for which we should enable
  /// optimization remarks. Transformation passes whose name matches this
  /// expression (and support this feature), will emit a diagnostic
  /// whenever they perform a transformation. This is enabled by the
  /// -Rpass=regexp flag.
  public std.shared_ptr<Regex> OptimizationRemarkPattern;
  
  /// Regular expression to select optimizations for which we should enable
  /// missed optimization remarks. Transformation passes whose name matches this
  /// expression (and support this feature), will emit a diagnostic
  /// whenever they tried but failed to perform a transformation. This is
  /// enabled by the -Rpass-missed=regexp flag.
  public std.shared_ptr<Regex> OptimizationRemarkMissedPattern;
  
  /// Regular expression to select optimizations for which we should enable
  /// optimization analyses. Transformation passes whose name matches this
  /// expression (and support this feature), will emit a diagnostic
  /// whenever they want to explain why they decided to apply or not apply
  /// a given transformation. This is enabled by the -Rpass-analysis=regexp
  /// flag.
  public std.shared_ptr<Regex> OptimizationRemarkAnalysisPattern;
  
  /// Set of files definining the rules for the symbol rewriting.
  public std.vectorString RewriteMapFiles;
  
  /// Set of sanitizer checks that are non-fatal (i.e. execution should be
  /// continued when possible).
  public SanitizerSet SanitizeRecover;
  
  /// Set of sanitizer checks that trap rather than diagnose.
  public SanitizerSet SanitizeTrap;
  
  /// List of backend command-line options for -fembed-bitcode.
  public std.vectorUChar CmdArgs;
  
  /// \brief A list of all -fno-builtin-* function names (e.g., memset).
  public std.vectorString NoBuiltinFuncs;
/*public:*/
  ///< Set when -femulated-tls is enabled.
  /// \brief FP_CONTRACT mode (on/off/fast).
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getFPContractMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 69,
   FQN="clang::CodeGenOptions::getFPContractMode", NM="_ZNK5clang14CodeGenOptions17getFPContractModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions17getFPContractModeEv")
  //</editor-fold>
  public FPContractModeKind getFPContractMode() /*const*/ {
    return ((/*static_cast*/FPContractModeKind)(FPContractMode));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setFPContractMode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 69,
   FQN="clang::CodeGenOptions::setFPContractMode", NM="_ZN5clang14CodeGenOptions17setFPContractModeENS0_18FPContractModeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions17setFPContractModeENS0_18FPContractModeKindE")
  //</editor-fold>
  public void setFPContractMode(FPContractModeKind Value) {
    FPContractMode = Value;
  }

  /// \brief Embed Bitcode mode (off/all/bitcode/marker).
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getEmbedBitcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 71,
   FQN="clang::CodeGenOptions::getEmbedBitcode", NM="_ZNK5clang14CodeGenOptions15getEmbedBitcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions15getEmbedBitcodeEv")
  //</editor-fold>
  public EmbedBitcodeKind getEmbedBitcode() /*const*/ {
    return ((/*static_cast*/EmbedBitcodeKind)(EmbedBitcode));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setEmbedBitcode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 71,
   FQN="clang::CodeGenOptions::setEmbedBitcode", NM="_ZN5clang14CodeGenOptions15setEmbedBitcodeENS0_16EmbedBitcodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions15setEmbedBitcodeENS0_16EmbedBitcodeKindE")
  //</editor-fold>
  public void setEmbedBitcode(EmbedBitcodeKind Value) {
    EmbedBitcode = Value;
  }

  ///< -fno-zero-initialized-in-bss.
  /// \brief Method of Objective-C dispatch to use.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getObjCDispatchMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 114,
   FQN="clang::CodeGenOptions::getObjCDispatchMethod", NM="_ZNK5clang14CodeGenOptions21getObjCDispatchMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions21getObjCDispatchMethodEv")
  //</editor-fold>
  public ObjCDispatchMethodKind getObjCDispatchMethod() /*const*/ {
    return ((/*static_cast*/ObjCDispatchMethodKind)(ObjCDispatchMethod));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setObjCDispatchMethod">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 114,
   FQN="clang::CodeGenOptions::setObjCDispatchMethod", NM="_ZN5clang14CodeGenOptions21setObjCDispatchMethodENS0_22ObjCDispatchMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions21setObjCDispatchMethodENS0_22ObjCDispatchMethodKindE")
  //</editor-fold>
  public void setObjCDispatchMethod(ObjCDispatchMethodKind Value) {
    ObjCDispatchMethod = Value;
  }

  ///< If -Os (==1) or -Oz (==2) is specified.
  
  /// \brief Choose profile instrumenation kind or no instrumentation.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getProfileInstr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 121,
   FQN="clang::CodeGenOptions::getProfileInstr", NM="_ZNK5clang14CodeGenOptions15getProfileInstrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions15getProfileInstrEv")
  //</editor-fold>
  public ProfileInstrKind getProfileInstr() /*const*/ {
    return ((/*static_cast*/ProfileInstrKind)(ProfileInstr));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setProfileInstr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 121,
   FQN="clang::CodeGenOptions::setProfileInstr", NM="_ZN5clang14CodeGenOptions15setProfileInstrENS0_16ProfileInstrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions15setProfileInstrENS0_16ProfileInstrKindE")
  //</editor-fold>
  public void setProfileInstr(ProfileInstrKind Value) {
    ProfileInstr = Value;
  }

  /// \brief Choose profile kind for PGO use compilation.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getProfileUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 123,
   FQN="clang::CodeGenOptions::getProfileUse", NM="_ZNK5clang14CodeGenOptions13getProfileUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions13getProfileUseEv")
  //</editor-fold>
  public ProfileInstrKind getProfileUse() /*const*/ {
    return ((/*static_cast*/ProfileInstrKind)(ProfileUse));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setProfileUse">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 123,
   FQN="clang::CodeGenOptions::setProfileUse", NM="_ZN5clang14CodeGenOptions13setProfileUseENS0_16ProfileInstrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions13setProfileUseENS0_16ProfileInstrKindE")
  //</editor-fold>
  public void setProfileUse(ProfileInstrKind Value) {
    ProfileUse = Value;
  }

  ///< Dump the generated coverage mapping
  ///< regions.
  
  /// If -fpcc-struct-return or -freg-struct-return is specified.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getStructReturnConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 130,
   FQN="clang::CodeGenOptions::getStructReturnConvention", NM="_ZNK5clang14CodeGenOptions25getStructReturnConventionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions25getStructReturnConventionEv")
  //</editor-fold>
  public StructReturnConventionKind getStructReturnConvention() /*const*/ {
    return ((/*static_cast*/StructReturnConventionKind)(StructReturnConvention));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setStructReturnConvention">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 130,
   FQN="clang::CodeGenOptions::setStructReturnConvention", NM="_ZN5clang14CodeGenOptions25setStructReturnConventionENS0_26StructReturnConventionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions25setStructReturnConventionENS0_26StructReturnConventionKindE")
  //</editor-fold>
  public void setStructReturnConvention(StructReturnConventionKind Value) {
    StructReturnConvention = Value;
  }

  
  /// The kind of generated debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 212,
   FQN="clang::CodeGenOptions::getDebugInfo", NM="_ZNK5clang14CodeGenOptions12getDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions12getDebugInfoEv")
  //</editor-fold>
  public DebugInfoKind getDebugInfo() /*const*/ {
    return ((/*static_cast*/DebugInfoKind)(DebugInfo));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setDebugInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 212,
   FQN="clang::CodeGenOptions::setDebugInfo", NM="_ZN5clang14CodeGenOptions12setDebugInfoENS_14codegenoptions13DebugInfoKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions12setDebugInfoENS_14codegenoptions13DebugInfoKindE")
  //</editor-fold>
  public void setDebugInfo(DebugInfoKind Value) {
    DebugInfo = Value;
  }

  
  /// Tune the debug info for this debugger.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getDebuggerTuning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 215,
   FQN="clang::CodeGenOptions::getDebuggerTuning", NM="_ZNK5clang14CodeGenOptions17getDebuggerTuningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions17getDebuggerTuningEv")
  //</editor-fold>
  public DebuggerKind getDebuggerTuning() /*const*/ {
    return ((/*static_cast*/DebuggerKind)(DebuggerTuning));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setDebuggerTuning">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 215,
   FQN="clang::CodeGenOptions::setDebuggerTuning", NM="_ZN5clang14CodeGenOptions17setDebuggerTuningEN4llvm12DebuggerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions17setDebuggerTuningEN4llvm12DebuggerKindE")
  //</editor-fold>
  public void setDebuggerTuning(DebuggerKind Value) {
    DebuggerTuning = Value;
  }

  
  /// The kind of inlining to perform.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getInlining">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 227,
   FQN="clang::CodeGenOptions::getInlining", NM="_ZNK5clang14CodeGenOptions11getInliningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions11getInliningEv")
  //</editor-fold>
  public InliningMethod getInlining() /*const*/ {
    return ((/*static_cast*/InliningMethod)(Inlining));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setInlining">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 227,
   FQN="clang::CodeGenOptions::setInlining", NM="_ZN5clang14CodeGenOptions11setInliningENS0_14InliningMethodE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions11setInliningENS0_14InliningMethodE")
  //</editor-fold>
  public void setInlining(InliningMethod Value) {
    Inlining = Value;
  }

  
  // Vector functions library to use.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getVecLib">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 230,
   FQN="clang::CodeGenOptions::getVecLib", NM="_ZNK5clang14CodeGenOptions9getVecLibEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions9getVecLibEv")
  //</editor-fold>
  public VectorLibrary getVecLib() /*const*/ {
    return ((/*static_cast*/VectorLibrary)(VecLib));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setVecLib">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 230,
   FQN="clang::CodeGenOptions::setVecLib", NM="_ZN5clang14CodeGenOptions9setVecLibENS0_13VectorLibraryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions9setVecLibENS0_13VectorLibraryE")
  //</editor-fold>
  public void setVecLib(VectorLibrary Value) {
    VecLib = Value;
  }

  
  /// The default TLS model to use.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getDefaultTLSModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 233,
   FQN="clang::CodeGenOptions::getDefaultTLSModel", NM="_ZNK5clang14CodeGenOptions18getDefaultTLSModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions18getDefaultTLSModelEv")
  //</editor-fold>
  public TLSModel getDefaultTLSModel() /*const*/ {
    return ((/*static_cast*/TLSModel)(DefaultTLSModel));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::setDefaultTLSModel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.def", line = 233,
   FQN="clang::CodeGenOptions::setDefaultTLSModel", NM="_ZN5clang14CodeGenOptions18setDefaultTLSModelENS0_8TLSModelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptions18setDefaultTLSModelENS0_8TLSModelE")
  //</editor-fold>
  public void setDefaultTLSModel(TLSModel Value) {
    DefaultTLSModel = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::CodeGenOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp", line = 15,
   FQN="clang::CodeGenOptions::CodeGenOptions", NM="_ZN5clang14CodeGenOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang14CodeGenOptionsC1Ev")
  //</editor-fold>
  public CodeGenOptions() {
    /* : CodeGenOptionsBase(), CodeModel(), CoverageFile(), DebugPass(), DebugCompilationDir(), DwarfDebugFlags(), DebugPrefixMap(), FloatABI(), LimitFloatPrecision(), LinkBitcodeFiles(), MainFileName(), SplitDwarfFile(), RelocationModel(), ThreadModel(), TrapFuncName(), BackendOptions(), DependentLibraries(), LinkerOptions(), InstrProfileOutput(), SampleProfileFile(), ProfileInstrumentUsePath(), ThinLTOIndexFile(), CudaGpuBinaryFileNames(), OptimizationRemarkPattern(), OptimizationRemarkMissedPattern(), OptimizationRemarkAnalysisPattern(), RewriteMapFiles(), SanitizeRecover(), SanitizeTrap(), CmdArgs(), NoBuiltinFuncs()*/ 
    //START JInit
    super();
    this.CodeModel = new std.string();
    this.CoverageFile = new std.string();
    this.DebugPass = new std.string();
    this.DebugCompilationDir = new std.string();
    this.DwarfDebugFlags = new std.string();
    this.DebugPrefixMap = new std.mapTypeType<std.string, std.string>(std.string.EMPTY);
    this.FloatABI = new std.string();
    this.LimitFloatPrecision = new std.string();
    this.LinkBitcodeFiles = new std.vector<std.pairUIntType<std.string>>(new std.pairUIntType<std.string>(0, std.string.EMPTY));
    this.MainFileName = new std.string();
    this.SplitDwarfFile = new std.string();
    this.RelocationModel = new std.string();
    this.ThreadModel = new std.string();
    this.TrapFuncName = new std.string();
    this.BackendOptions = new std.vectorString(std.string.EMPTY);
    this.DependentLibraries = new std.vectorString(std.string.EMPTY);
    this.LinkerOptions = new std.vectorString(std.string.EMPTY);
    this.InstrProfileOutput = new std.string();
    this.SampleProfileFile = new std.string();
    this.ProfileInstrumentUsePath = new std.string();
    this.ThinLTOIndexFile = new std.string();
    this.CudaGpuBinaryFileNames = new std.vectorString(std.string.EMPTY);
    this.OptimizationRemarkPattern = new std.shared_ptr<Regex>();
    this.OptimizationRemarkMissedPattern = new std.shared_ptr<Regex>();
    this.OptimizationRemarkAnalysisPattern = new std.shared_ptr<Regex>();
    this.RewriteMapFiles = new std.vectorString(std.string.EMPTY);
    this.SanitizeRecover = new SanitizerSet();
    this.SanitizeTrap = new SanitizerSet();
    this.CmdArgs = new std.vectorUChar();
    this.NoBuiltinFuncs = new std.vectorString(std.string.EMPTY);
    //END JInit
    DisableIntegratedAS = false; ///< -no-integrated-as
    CompressDebugSections = false; ///< -Wa,-compress-debug-sections
    RelaxELFRelocations = false; ///< -Wa,--mrelax-relocations
    AsmVerbose = false; ///< -dA, -fverbose-asm.
    AssumeSaneOperatorNew = true; ///< implicit __attribute__((malloc)) operator new
    Autolink = true; ///< -fno-autolink
    ObjCAutoRefCountExceptions = false; ///< Whether ARC should be EH-safe.
    Backchain = false; ///< -mbackchain
    CoverageExtraChecksum = false; ///< Whether we need a second checksum for functions in GCNO files.
    CoverageNoFunctionNamesInData = false; ///< Do not include function names in GCDA files.
    CoverageExitBlockBeforeBody = false; ///< Whether to emit the exit block before the body blocks in GCNO files.
    CXAAtExit = true; ///< Use __cxa_atexit for calling destructors.
    CXXCtorDtorAliases = false; ///< Emit complete ctors/dtors as linker
    ///< aliases to base ctors when possible.
    DataSections = false; ///< Set when -fdata-sections is enabled.
    UniqueSectionNames = true; ///< Set for -funique-section-names.
    DisableFPElim = false; ///< Set when -fomit-frame-pointer is enabled.
    DisableFree = false; ///< Don't free memory.
    DiscardValueNames = false; ///< Discard Value Names from the IR (LLVMContext flag)
    DisableGCov = false; ///< Don't run the GCov pass, for testing.
    DisableLLVMOpts = false; ///< Don't run any optimizations, for use in
    ///< getting .bc files that correspond to the
    ///< internal state before optimizations are
    ///< done.
    DisableLLVMPasses = false; ///< Don't run any LLVM IR passes to get
    ///< the pristine IR generated by the
    ///< frontend.
    DisableRedZone = false; ///< Set when -mno-red-zone is enabled.
    DisableTailCalls = false; ///< Do not emit tail calls.
    EmitDeclMetadata = false; ///< Emit special metadata indicating what
    ///< Decl* various IR entities came from.
    ///< Only useful when running CodeGen as a
    ///< subroutine.
    EmitGcovArcs = false; ///< Emit coverage data files, aka. GCDA.
    EmitGcovNotes = false; ///< Emit coverage "notes" files, aka GCNO.
    EmitOpenCLArgMetadata = false; ///< Emit OpenCL kernel arg metadata.
    EmulatedTLS = false; ///< Set when -femulated-tls is enabled.
    /// \brief FP_CONTRACT mode (on/off/fast).
    setFPContractMode(FPContractModeKind.FPC_On);
    /// \brief Embed Bitcode mode (off/all/bitcode/marker).
    setEmbedBitcode(EmbedBitcodeKind.Embed_Off);
    ForbidGuardVariables = false; ///< Issue errors if C++ guard variables
    ///< are required.
    FunctionSections = false; ///< Set when -ffunction-sections is enabled.
    InstrumentFunctions = false; ///< Set when -finstrument-functions is
    ///< enabled.
    XRayInstrumentFunctions = false; ///< Set when -fxray-instrument is
    ///< enabled.
    
    ///< Set the minimum number of instructions in a function to determine selective
    ///< XRay instrumentation.
    XRayInstructionThreshold = 200;
    InstrumentForProfiling = false; ///< Set when -pg is enabled.
    LessPreciseFPMAD = false; ///< Enable less precise MAD instructions to
    ///< be generated.
    PrepareForLTO = false; ///< Set when -flto is enabled on the
    ///< compile step.
    EmitSummaryIndex = false; ///< Set when -flto=thin is enabled on the
    ///< compile step.
    IncrementalLinkerCompatible = false; ///< Emit an object file which can
    ///< be used with an incremental
    ///< linker.
    MergeAllConstants = true; ///< Merge identical constants.
    MergeFunctions = false; ///< Set when -fmerge-functions is enabled.
    MSVolatile = false; ///< Set when /volatile:ms is enabled.
    NoCommon = false; ///< Set when -fno-common or C++ is enabled.
    NoDwarfDirectoryAsm = false; ///< Set when -fno-dwarf-directory-asm is
    ///< enabled.
    NoExecStack = false; ///< Set when -Wa,--noexecstack is enabled.
    FatalWarnings = false; ///< Set when -Wa,--fatal-warnings is
    ///< enabled.
    EnableSegmentedStacks = false; ///< Set when -fsplit-stack is enabled.
    NoImplicitFloat = false; ///< Set when -mno-implicit-float is enabled.
    NoInfsFPMath = false; ///< Assume FP arguments, results not +-Inf.
    NoSignedZeros = false; ///< Allow ignoring the signedness of FP zero
    ReciprocalMath = false; ///< Allow FP divisions to be reassociated.
    NoInline = false; ///< Set when -fno-inline is enabled.
    ///< Disables use of the inline keyword.
    NoNaNsFPMath = false; ///< Assume FP arguments, results not NaN.
    NoZeroInitializedInBSS = false; ///< -fno-zero-initialized-in-bss.
    /// \brief Method of Objective-C dispatch to use.
    setObjCDispatchMethod(ObjCDispatchMethodKind.Legacy);
    OmitLeafFramePointer = false; ///< Set when -momit-leaf-frame-pointer is
    ///< enabled.
    OptimizationLevel = 0; ///< The -O[0-3] option specified.
    OptimizeSize = 0; ///< If -Os (==1) or -Oz (==2) is specified.
    
    /// \brief Choose profile instrumenation kind or no instrumentation.
    setProfileInstr(ProfileInstrKind.ProfileNone);
    /// \brief Choose profile kind for PGO use compilation.
    setProfileUse(ProfileInstrKind.ProfileNone);
    CoverageMapping = false; ///< Generate coverage mapping regions to
    ///< enable code coverage analysis.
    DumpCoverageMapping = false; ///< Dump the generated coverage mapping
    ///< regions.
    
    /// If -fpcc-struct-return or -freg-struct-return is specified.
    setStructReturnConvention(StructReturnConventionKind.SRCK_Default);
    RelaxAll = false; ///< Relax all machine code instructions.
    RelaxedAliasing = false; ///< Set when -fno-strict-aliasing is enabled.
    StructPathTBAA = false; ///< Whether or not to use struct-path TBAA.
    SaveTempLabels = false; ///< Save temporary labels.
    SanitizeAddressUseAfterScope = false; ///< Enable use-after-scope detection
    ///< in AddressSanitizer
    SanitizeMemoryTrackOrigins = 0; ///< Enable tracking origins in
    ///< MemorySanitizer
    SanitizeMemoryUseAfterDtor = false; ///< Enable use-after-delete detection
    ///< in MemorySanitizer
    SanitizeCfiCrossDso = false; ///< Enable cross-dso support in CFI.
    SanitizeCoverageType = 0; ///< Type of sanitizer coverage
    ///< instrumentation.
    SanitizeCoverageIndirectCalls = false; ///< Enable sanitizer coverage
    ///< for indirect calls.
    SanitizeCoverageTraceBB = false; ///< Enable basic block tracing in
    ///< in sanitizer coverage.
    SanitizeCoverageTraceCmp = false; ///< Enable cmp instruction tracing
    ///< in sanitizer coverage.
    SanitizeCoverage8bitCounters = false; ///< Use 8-bit frequency counters
    ///< in sanitizer coverage.
    SanitizeCoverageTracePC = false; ///< Enable PC tracing
    ///< in sanitizer coverage.
    SanitizeStats = false; ///< Collect statistics for sanitizers.
    SimplifyLibCalls = true; ///< Set when -fbuiltin is enabled.
    SoftFloat = false; ///< -soft-float.
    StrictEnums = false; ///< Optimize based on strict enum definition.
    StrictVTablePointers = false; ///< Optimize based on the strict vtable pointers
    TimePasses = false; ///< Set when -ftime-report is enabled.
    UnrollLoops = false; ///< Control whether loops are unrolled.
    RerollLoops = false; ///< Control whether loops are rerolled.
    NoUseJumpTables = false; ///< Set when -fno-jump-tables is enabled.
    UnsafeFPMath = false; ///< Allow unsafe floating point optzns.
    UnwindTables = false; ///< Emit unwind tables.
    VectorizeBB = false; ///< Run basic block vectorizer.
    VectorizeLoop = false; ///< Run loop vectorizer.
    VectorizeSLP = false; ///< Run SLP vectorizer.
    
    /// Attempt to use register sized accesses to bit-fields in structures, when
    /// possible.
    UseRegisterSizedBitfieldAccess = false;
    VerifyModule = true; ///< Control whether the module should be run
    ///< through the LLVM Verifier.
    StackRealignment = false; ///< Control whether to force stack
    ///< realignment.
    UseInitArray = false; ///< Control whether to use .init_array or
    ///< .ctors.
    StackAlignment = 0; ///< Overrides default stack
    ///< alignment, if not 0.
    StackProbeSize = 4096; ///< Overrides default stack
    ///< probe size, even if 0.
    DebugColumnInfo = false; ///< Whether or not to use column information
    ///< in debug info.
    DebugTypeExtRefs = false; ///< Whether or not debug info should contain
    ///< external references to a PCH or module.
    DebugExplicitImport = false; ///< Whether or not debug info should
    ///< contain explicit imports for
    ///< anonymous namespaces
    EmitLLVMUseLists = false; ///< Control whether to serialize use-lists.
    WholeProgramVTables = false; ///< Whether to apply whole-program
    ///  vtable optimization.
    
    /// Whether to use public LTO visibility for entities in std and stdext
    /// namespaces. This is enabled by clang-cl's /MT and /MTd flags.
    LTOVisibilityPublicStd = false;
    
    /// The user specified number of registers to be used for integral arguments,
    /// or 0 if unspecified.
    NumRegisterParameters = 0;
    
    /// The lower bound for a buffer to be considered for stack protection.
    SSPBufferSize = 0;
    
    /// The kind of generated debug info.
    setDebugInfo(DebugInfoKind.NoDebugInfo);
    
    /// Tune the debug info for this debugger.
    setDebuggerTuning(DebuggerKind.Default);
    
    /// Dwarf version. Version zero indicates to LLVM that no DWARF should be
    /// emitted.
    DwarfVersion = 0;
    
    /// Whether we should emit CodeView debug information. It's possible to emit
    /// CodeView and DWARF into the same object.
    EmitCodeView = false;
    
    /// The kind of inlining to perform.
    setInlining(InliningMethod.NoInlining);
    
    // Vector functions library to use.
    setVecLib(VectorLibrary.NoLibrary);
    
    /// The default TLS model to use.
    setDefaultTLSModel(TLSModel.GeneralDynamicTLSModel);
    
    /// Number of path components to strip when emitting checks. (0 == full
    /// filename)
    EmitCheckPathComponentsToStrip = 0;
    
    RelocationModel.$assign(/*KEEP_STR*/"pic");
    memcpy(CoverageVersion, /*KEEP_STR*/"402*", 4);
  }

  
  /// \brief Is this a libc/libm function that is no longer recognized as a
  /// builtin because a -fno-builtin-* option has been specified?
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::isNoBuiltinFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp", line = 24,
   FQN="clang::CodeGenOptions::isNoBuiltinFunc", NM="_ZNK5clang14CodeGenOptions15isNoBuiltinFuncEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions15isNoBuiltinFuncEPKc")
  //</editor-fold>
  public boolean isNoBuiltinFunc(/*const*/char$ptr/*char P*/ Name) /*const*/ {
    StringRef FuncName/*J*/= new StringRef(Name);
    for (/*uint*/int i = 0, e = NoBuiltinFuncs.size(); i != e; ++i)  {
      if (FuncName.equals(NoBuiltinFuncs.$at(i))) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::getNoBuiltinFuncs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 227,
   FQN="clang::CodeGenOptions::getNoBuiltinFuncs", NM="_ZNK5clang14CodeGenOptions17getNoBuiltinFuncsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions17getNoBuiltinFuncsEv")
  //</editor-fold>
  public /*const*/std.vectorString/*&*/ getNoBuiltinFuncs() /*const*/ {
    return NoBuiltinFuncs;
  }

  
  /// \brief Check if Clang profile instrumenation is on.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::hasProfileClangInstr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 232,
   FQN="clang::CodeGenOptions::hasProfileClangInstr", NM="_ZNK5clang14CodeGenOptions20hasProfileClangInstrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions20hasProfileClangInstrEv")
  //</editor-fold>
  public boolean hasProfileClangInstr() /*const*/ {
    return getProfileInstr() == ProfileInstrKind.ProfileClangInstr;
  }

  
  /// \brief Check if IR level profile instrumentation is on.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::hasProfileIRInstr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 237,
   FQN="clang::CodeGenOptions::hasProfileIRInstr", NM="_ZNK5clang14CodeGenOptions17hasProfileIRInstrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions17hasProfileIRInstrEv")
  //</editor-fold>
  public boolean hasProfileIRInstr() /*const*/ {
    return getProfileInstr() == ProfileInstrKind.ProfileIRInstr;
  }

  
  /// \brief Check if Clang profile use is on.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::hasProfileClangUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 242,
   FQN="clang::CodeGenOptions::hasProfileClangUse", NM="_ZNK5clang14CodeGenOptions18hasProfileClangUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions18hasProfileClangUseEv")
  //</editor-fold>
  public boolean hasProfileClangUse() /*const*/ {
    return getProfileUse() == ProfileInstrKind.ProfileClangInstr;
  }

  
  /// \brief Check if IR level profile use is on.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::hasProfileIRUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 247,
   FQN="clang::CodeGenOptions::hasProfileIRUse", NM="_ZNK5clang14CodeGenOptions15hasProfileIRUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZNK5clang14CodeGenOptions15hasProfileIRUseEv")
  //</editor-fold>
  public boolean hasProfileIRUse() /*const*/ {
    return getProfileUse() == ProfileInstrKind.ProfileIRInstr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::~CodeGenOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 44,
   FQN="clang::CodeGenOptions::~CodeGenOptions", NM="_ZN5clang14CodeGenOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang14CodeGenOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NoBuiltinFuncs.$destroy();
    CmdArgs.$destroy();
    RewriteMapFiles.$destroy();
    OptimizationRemarkAnalysisPattern.$destroy();
    OptimizationRemarkMissedPattern.$destroy();
    OptimizationRemarkPattern.$destroy();
    CudaGpuBinaryFileNames.$destroy();
    ThinLTOIndexFile.$destroy();
    ProfileInstrumentUsePath.$destroy();
    SampleProfileFile.$destroy();
    InstrProfileOutput.$destroy();
    LinkerOptions.$destroy();
    DependentLibraries.$destroy();
    BackendOptions.$destroy();
    TrapFuncName.$destroy();
    ThreadModel.$destroy();
    RelocationModel.$destroy();
    SplitDwarfFile.$destroy();
    MainFileName.$destroy();
    LinkBitcodeFiles.$destroy();
    LimitFloatPrecision.$destroy();
    FloatABI.$destroy();
    DebugPrefixMap.$destroy();
    DwarfDebugFlags.$destroy();
    DebugCompilationDir.$destroy();
    DebugPass.$destroy();
    CoverageFile.$destroy();
    CodeModel.$destroy();
    super.$destroy();
    //END JDestroy
  }



  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptions::CodeGenOptions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 44,
   FQN="clang::CodeGenOptions::CodeGenOptions", NM="_ZN5clang14CodeGenOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang14CodeGenOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CodeGenOptions(/*const*/ CodeGenOptions /*&*/ $Prm0) {
    /* : CodeGenOptionsBase(), CodeModel(.CodeModel), CoverageFile(.CoverageFile), CoverageVersion(.CoverageVersion[__i0]), DebugPass(.DebugPass), DebugCompilationDir(.DebugCompilationDir), DwarfDebugFlags(.DwarfDebugFlags), DebugPrefixMap(.DebugPrefixMap), FloatABI(.FloatABI), LimitFloatPrecision(.LimitFloatPrecision), LinkBitcodeFiles(.LinkBitcodeFiles), MainFileName(.MainFileName), SplitDwarfFile(.SplitDwarfFile), RelocationModel(.RelocationModel), ThreadModel(.ThreadModel), TrapFuncName(.TrapFuncName), BackendOptions(.BackendOptions), DependentLibraries(.DependentLibraries), LinkerOptions(.LinkerOptions), InstrProfileOutput(.InstrProfileOutput), SampleProfileFile(.SampleProfileFile), ProfileInstrumentUsePath(.ProfileInstrumentUsePath), ThinLTOIndexFile(.ThinLTOIndexFile), CudaGpuBinaryFileNames(.CudaGpuBinaryFileNames), OptimizationRemarkPattern(.OptimizationRemarkPattern), OptimizationRemarkMissedPattern(.OptimizationRemarkMissedPattern), OptimizationRemarkAnalysisPattern(.OptimizationRemarkAnalysisPattern), RewriteMapFiles(.RewriteMapFiles), SanitizeRecover(.SanitizeRecover), SanitizeTrap(.SanitizeTrap), CmdArgs(.CmdArgs), NoBuiltinFuncs(.NoBuiltinFuncs)*/ 
    //START JInit
    super($Prm0);
    this.CodeModel = new std.string($Prm0.CodeModel);
    this.CoverageFile = new std.string($Prm0.CoverageFile);
    this.CoverageVersion = $Prm0.CoverageVersion;
    this.DebugPass = new std.string($Prm0.DebugPass);
    this.DebugCompilationDir = new std.string($Prm0.DebugCompilationDir);
    this.DwarfDebugFlags = new std.string($Prm0.DwarfDebugFlags);
    this.DebugPrefixMap = new std.mapTypeType<std.string, std.string>($Prm0.DebugPrefixMap);
    this.FloatABI = new std.string($Prm0.FloatABI);
    this.LimitFloatPrecision = new std.string($Prm0.LimitFloatPrecision);
    this.LinkBitcodeFiles = new std.vector<std.pairUIntType<std.string>>($Prm0.LinkBitcodeFiles);
    this.MainFileName = new std.string($Prm0.MainFileName);
    this.SplitDwarfFile = new std.string($Prm0.SplitDwarfFile);
    this.RelocationModel = new std.string($Prm0.RelocationModel);
    this.ThreadModel = new std.string($Prm0.ThreadModel);
    this.TrapFuncName = new std.string($Prm0.TrapFuncName);
    this.BackendOptions = new std.vectorString($Prm0.BackendOptions);
    this.DependentLibraries = new std.vectorString($Prm0.DependentLibraries);
    this.LinkerOptions = new std.vectorString($Prm0.LinkerOptions);
    this.InstrProfileOutput = new std.string($Prm0.InstrProfileOutput);
    this.SampleProfileFile = new std.string($Prm0.SampleProfileFile);
    this.ProfileInstrumentUsePath = new std.string($Prm0.ProfileInstrumentUsePath);
    this.ThinLTOIndexFile = new std.string($Prm0.ThinLTOIndexFile);
    this.CudaGpuBinaryFileNames = new std.vectorString($Prm0.CudaGpuBinaryFileNames);
    this.OptimizationRemarkPattern = new std.shared_ptr<Regex>($Prm0.OptimizationRemarkPattern);
    this.OptimizationRemarkMissedPattern = new std.shared_ptr<Regex>($Prm0.OptimizationRemarkMissedPattern);
    this.OptimizationRemarkAnalysisPattern = new std.shared_ptr<Regex>($Prm0.OptimizationRemarkAnalysisPattern);
    this.RewriteMapFiles = new std.vectorString($Prm0.RewriteMapFiles);
    this.SanitizeRecover = new SanitizerSet($Prm0.SanitizeRecover);
    this.SanitizeTrap = new SanitizerSet($Prm0.SanitizeTrap);
    this.CmdArgs = new std.vectorUChar($Prm0.CmdArgs);
    this.NoBuiltinFuncs = new std.vectorString($Prm0.NoBuiltinFuncs);
    //END JInit
  }

  
  public String toString() {
    return "" + "CodeModel=" + CodeModel // NOI18N
              + ", CoverageFile=" + CoverageFile // NOI18N
              + ", CoverageVersion=" + CoverageVersion // NOI18N
              + ", DebugPass=" + DebugPass // NOI18N
              + ", DebugCompilationDir=" + DebugCompilationDir // NOI18N
              + ", DwarfDebugFlags=" + DwarfDebugFlags // NOI18N
              + ", DebugPrefixMap=" + DebugPrefixMap // NOI18N
              + ", FloatABI=" + FloatABI // NOI18N
              + ", LimitFloatPrecision=" + LimitFloatPrecision // NOI18N
              + ", LinkBitcodeFiles=" + LinkBitcodeFiles // NOI18N
              + ", MainFileName=" + MainFileName // NOI18N
              + ", SplitDwarfFile=" + SplitDwarfFile // NOI18N
              + ", RelocationModel=" + RelocationModel // NOI18N
              + ", ThreadModel=" + ThreadModel // NOI18N
              + ", TrapFuncName=" + TrapFuncName // NOI18N
              + ", BackendOptions=" + BackendOptions // NOI18N
              + ", DependentLibraries=" + DependentLibraries // NOI18N
              + ", LinkerOptions=" + LinkerOptions // NOI18N
              + ", InstrProfileOutput=" + InstrProfileOutput // NOI18N
              + ", SampleProfileFile=" + SampleProfileFile // NOI18N
              + ", ProfileInstrumentUsePath=" + ProfileInstrumentUsePath // NOI18N
              + ", ThinLTOIndexFile=" + ThinLTOIndexFile // NOI18N
              + ", CudaGpuBinaryFileNames=" + CudaGpuBinaryFileNames // NOI18N
              + ", OptimizationRemarkPattern=" + OptimizationRemarkPattern // NOI18N
              + ", OptimizationRemarkMissedPattern=" + OptimizationRemarkMissedPattern // NOI18N
              + ", OptimizationRemarkAnalysisPattern=" + OptimizationRemarkAnalysisPattern // NOI18N
              + ", RewriteMapFiles=" + RewriteMapFiles // NOI18N
              + ", SanitizeRecover=" + SanitizeRecover // NOI18N
              + ", SanitizeTrap=" + SanitizeTrap // NOI18N
              + ", CmdArgs=" + CmdArgs // NOI18N
              + ", NoBuiltinFuncs=" + NoBuiltinFuncs // NOI18N
              + super.toString(); // NOI18N
  }
}
