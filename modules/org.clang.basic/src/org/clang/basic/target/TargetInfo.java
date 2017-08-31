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

package org.clang.basic.target;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.ir.DataLayout;

// JAVA: this class was generated from TargetInfo with -empty-body and then:
// - removed all fields
// - removed constructors and added two marker constructors
// - static methods are delegating to real implementer (impl.TargetInfo)
// - restored added constructors in nested classes
// - replaced all UnsupportedOperationException("EmptyBody") with UnsupportedOperationException("Why not overridden?")
//
// real implementer impl.TargetInfo will be cleaned as well:
// - nested classes/enums declared here are removed from impl.TargetInfo

/// \brief Exposes information about the current target.
///
//<editor-fold defaultstate="collapsed" desc="clang::TargetInfo">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 52,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 51,
 FQN="clang::TargetInfo", NM="_ZN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfoE")
//</editor-fold>
public abstract class TargetInfo extends /*public*/ RefCountedBase<TargetInfo> implements Destructors.ClassWithDestructor {
  // JAVA: special constructors for derived classes to distinguish inheritance from Template argumens
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected TargetInfo() {
    super();
    assert (this instanceof org.clang.basic.target.impl.TargetInfo) : "Unexpected class " + this.getClass();
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected TargetInfo(NoneType None) {
    assert (this instanceof org.clang.basic.target.impl.TargetInfoInherited) : "Unexpected class " + this.getClass();
  }

  
  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::resetDataLayout">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 99,
   FQN="clang::TargetInfo::resetDataLayout", NM="_ZN5clang10TargetInfo15resetDataLayoutEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo15resetDataLayoutEN4llvm9StringRefE")
  //</editor-fold>
  protected void resetDataLayout(StringRef DL) {
    throw new UnsupportedOperationException("Why not overridden?");
  }
  
/*public:*/
  /// \brief Construct a target for the given options.
  ///
  /// \param Opts - The options to use to initialize the target. The target may
  /// modify the options to canonicalize the target feature information to match
  /// what the backend expects.
  /// \brief Construct a target for the given options.
  ///
  /// \param Opts - The options to use to initialize the target. The target may
  /// modify the options to canonicalize the target feature information to match
  /// what the backend expects.
  
  /// CreateTargetInfo - Return the target info object for the specified target
  /// options.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::CreateTargetInfo">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 8553,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7939,
   FQN="clang::TargetInfo::CreateTargetInfo", NM="_ZN5clang10TargetInfo16CreateTargetInfoERNS_17DiagnosticsEngineERKSt10shared_ptrINS_13TargetOptionsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN5clang10TargetInfo16CreateTargetInfoERNS_17DiagnosticsEngineERKSt10shared_ptrINS_13TargetOptionsEE")
  //</editor-fold>
  public static TargetInfo /*P*/ CreateTargetInfo(DiagnosticsEngine /*&*/ Diags, 
                  /*const*/ std.shared_ptr<TargetOptions> /*&*/ Opts) {
    return org.clang.basic.target.impl.TargetInfo.CreateTargetInfo(Diags, Opts);
  }


  
  // Out of line virtual dtor for TargetInfo.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::~TargetInfo">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 105,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 103,
   FQN="clang::TargetInfo::~TargetInfo", NM="_ZN5clang10TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZN5clang10TargetInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    super.$destroy();
  }


  
  /// \brief Retrieve the target options.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTargetOpts">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 111,
   FQN="clang::TargetInfo::getTargetOpts", NM="_ZNK5clang10TargetInfo13getTargetOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getTargetOptsEv")
  //</editor-fold>
  public TargetOptions /*&*/ getTargetOpts() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  ///===---- Target Data Type Query Methods -------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::IntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 117,
   FQN="clang::TargetInfo::IntType", NM="_ZN5clang10TargetInfo7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo7IntTypeE")
  //</editor-fold>
  public enum IntType implements Native.ComparableLower {
    NoInt(0),
    SignedChar(NoInt.getValue() + 1),
    UnsignedChar(SignedChar.getValue() + 1),
    SignedShort(UnsignedChar.getValue() + 1),
    UnsignedShort(SignedShort.getValue() + 1),
    SignedInt(UnsignedShort.getValue() + 1),
    UnsignedInt(SignedInt.getValue() + 1),
    SignedLong(UnsignedInt.getValue() + 1),
    UnsignedLong(SignedLong.getValue() + 1),
    SignedLongLong(UnsignedLong.getValue() + 1),
    UnsignedLongLong(SignedLongLong.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IntType valueOf(int val) {
      IntType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IntType[] VALUES;
      private static final IntType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IntType kind : IntType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IntType[min < 0 ? (1-min) : 0];
        VALUES = new IntType[max >= 0 ? (1+max) : 0];
        for (IntType kind : IntType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private IntType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((IntType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((IntType)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::RealType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 131,
   FQN="clang::TargetInfo::RealType", NM="_ZN5clang10TargetInfo8RealTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo8RealTypeE")
  //</editor-fold>
  public enum RealType implements Native.ComparableLower {
    NoFloat(255),
    Float(0),
    Double(Float.getValue() + 1),
    LongDouble(Double.getValue() + 1),
    Float128(LongDouble.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RealType valueOf(int val) {
      RealType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RealType[] VALUES;
      private static final RealType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RealType kind : RealType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RealType[min < 0 ? (1-min) : 0];
        VALUES = new RealType[max >= 0 ? (1+max) : 0];
        for (RealType kind : RealType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private RealType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RealType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RealType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief The different kinds of __builtin_va_list types defined by
  /// the target implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::BuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 140,
   FQN="clang::TargetInfo::BuiltinVaListKind", NM="_ZN5clang10TargetInfo17BuiltinVaListKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo17BuiltinVaListKindE")
  //</editor-fold>
  public enum BuiltinVaListKind implements Native.ComparableLower {
    /// typedef char* __builtin_va_list;
    CharPtrBuiltinVaList(0),
    
    /// typedef void* __builtin_va_list;
    VoidPtrBuiltinVaList(CharPtrBuiltinVaList.getValue() + 1),
    
    /// __builtin_va_list as defind by the AArch64 ABI
    /// http://infocenter.arm.com/help/topic/com.arm.doc.ihi0055a/IHI0055A_aapcs64.pdf
    AArch64ABIBuiltinVaList(VoidPtrBuiltinVaList.getValue() + 1),
    
    /// __builtin_va_list as defined by the PNaCl ABI:
    /// http://www.chromium.org/nativeclient/pnacl/bitcode-abi#TOC-Machine-Types
    PNaClABIBuiltinVaList(AArch64ABIBuiltinVaList.getValue() + 1),
    
    /// __builtin_va_list as defined by the Power ABI:
    /// https://www.power.org
    ///        /resources/downloads/Power-Arch-32-bit-ABI-supp-1.0-Embedded.pdf
    PowerABIBuiltinVaList(PNaClABIBuiltinVaList.getValue() + 1),
    
    /// __builtin_va_list as defined by the x86-64 ABI:
    /// http://www.x86-64.org/documentation/abi.pdf
    X86_64ABIBuiltinVaList(PowerABIBuiltinVaList.getValue() + 1),
    
    /// __builtin_va_list as defined by ARM AAPCS ABI
    /// http://infocenter.arm.com
    //        /help/topic/com.arm.doc.ihi0042d/IHI0042D_aapcs.pdf
    AAPCSABIBuiltinVaList(X86_64ABIBuiltinVaList.getValue() + 1),
    
    // typedef struct __va_list_tag
    //   {
    //     long __gpr;
    //     long __fpr;
    //     void *__overflow_arg_area;
    //     void *__reg_save_area;
    //   } va_list[1];
    SystemZBuiltinVaList(AAPCSABIBuiltinVaList.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BuiltinVaListKind valueOf(int val) {
      BuiltinVaListKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BuiltinVaListKind[] VALUES;
      private static final BuiltinVaListKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BuiltinVaListKind kind : BuiltinVaListKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BuiltinVaListKind[min < 0 ? (1-min) : 0];
        VALUES = new BuiltinVaListKind[max >= 0 ? (1+max) : 0];
        for (BuiltinVaListKind kind : BuiltinVaListKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private BuiltinVaListKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BuiltinVaListKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BuiltinVaListKind)obj).value);}
    //</editor-fold>
  };

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getSizeType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 223,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 214,
   FQN="clang::TargetInfo::getSizeType", NM="_ZNK5clang10TargetInfo11getSizeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo11getSizeTypeEv")
  //</editor-fold>
  public IntType getSizeType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getIntMaxType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 224,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 215,
   FQN="clang::TargetInfo::getIntMaxType", NM="_ZNK5clang10TargetInfo13getIntMaxTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getIntMaxTypeEv")
  //</editor-fold>
  public IntType getIntMaxType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getUIntMaxType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 216,
   FQN="clang::TargetInfo::getUIntMaxType", NM="_ZNK5clang10TargetInfo14getUIntMaxTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getUIntMaxTypeEv")
  //</editor-fold>
  public IntType getUIntMaxType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPtrDiffType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 219,
   FQN="clang::TargetInfo::getPtrDiffType", NM="_ZNK5clang10TargetInfo14getPtrDiffTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getPtrDiffTypeEj")
  //</editor-fold>
  public IntType getPtrDiffType(/*uint*/int AddrSpace) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getIntPtrType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 222,
   FQN="clang::TargetInfo::getIntPtrType", NM="_ZNK5clang10TargetInfo13getIntPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getIntPtrTypeEv")
  //</editor-fold>
  public IntType getIntPtrType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getUIntPtrType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 223,
   FQN="clang::TargetInfo::getUIntPtrType", NM="_ZNK5clang10TargetInfo14getUIntPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getUIntPtrTypeEv")
  //</editor-fold>
  public IntType getUIntPtrType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getWCharType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 226,
   FQN="clang::TargetInfo::getWCharType", NM="_ZNK5clang10TargetInfo12getWCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getWCharTypeEv")
  //</editor-fold>
  public IntType getWCharType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getWIntType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 236,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 227,
   FQN="clang::TargetInfo::getWIntType", NM="_ZNK5clang10TargetInfo11getWIntTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo11getWIntTypeEv")
  //</editor-fold>
  public IntType getWIntType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getChar16Type">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 237,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 228,
   FQN="clang::TargetInfo::getChar16Type", NM="_ZNK5clang10TargetInfo13getChar16TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getChar16TypeEv")
  //</editor-fold>
  public IntType getChar16Type() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getChar32Type">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 238,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 229,
   FQN="clang::TargetInfo::getChar32Type", NM="_ZNK5clang10TargetInfo13getChar32TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getChar32TypeEv")
  //</editor-fold>
  public IntType getChar32Type() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getInt64Type">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 239,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 230,
   FQN="clang::TargetInfo::getInt64Type", NM="_ZNK5clang10TargetInfo12getInt64TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getInt64TypeEv")
  //</editor-fold>
  public IntType getInt64Type() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getUInt64Type">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 240,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 231,
   FQN="clang::TargetInfo::getUInt64Type", NM="_ZNK5clang10TargetInfo13getUInt64TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getUInt64TypeEv")
  //</editor-fold>
  public IntType getUInt64Type() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getSigAtomicType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 234,
   FQN="clang::TargetInfo::getSigAtomicType", NM="_ZNK5clang10TargetInfo16getSigAtomicTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getSigAtomicTypeEv")
  //</editor-fold>
  public IntType getSigAtomicType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getProcessIDType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 235,
   FQN="clang::TargetInfo::getProcessIDType", NM="_ZNK5clang10TargetInfo16getProcessIDTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getProcessIDTypeEv")
  //</editor-fold>
  public IntType getProcessIDType() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getCorrespondingUnsignedType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 237,
   FQN="clang::TargetInfo::getCorrespondingUnsignedType", NM="_ZN5clang10TargetInfo28getCorrespondingUnsignedTypeENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo28getCorrespondingUnsignedTypeENS0_7IntTypeE")
  //</editor-fold>
  public static IntType getCorrespondingUnsignedType(IntType T) {
    return org.clang.basic.target.impl.TargetInfo.getCorrespondingUnsignedType(T);
  }

  
  /// \brief Return the width (in bits) of the specified integer type enum.
  ///
  /// For example, SignedInt -> getIntWidth().
  
  /// \brief Return the width (in bits) of the specified integer type enum.
  ///
  /// For example, SignedInt -> getIntWidth().
  
  /// getTypeWidth - Return the width (in bits) of the specified integer type
  /// enum. For example, SignedInt -> getIntWidth().
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTypeWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 166,
   FQN="clang::TargetInfo::getTypeWidth", NM="_ZNK5clang10TargetInfo12getTypeWidthENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo12getTypeWidthENS0_7IntTypeE")
  //</editor-fold>
  public /*uint*/int getTypeWidth(IntType T) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Return integer type with specified width.
  
  /// \brief Return integer type with specified width.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getIntTypeByWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 182,
   FQN="clang::TargetInfo::getIntTypeByWidth", NM="_ZNK5clang10TargetInfo17getIntTypeByWidthEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo17getIntTypeByWidthEjb")
  //</editor-fold>
  public TargetInfo.IntType getIntTypeByWidth(/*uint*/int BitWidth, boolean IsSigned) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Return the smallest integer type with at least the specified width.
  
  /// \brief Return the smallest integer type with at least the specified width.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLeastIntTypeByWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 197,
   FQN="clang::TargetInfo::getLeastIntTypeByWidth", NM="_ZNK5clang10TargetInfo22getLeastIntTypeByWidthEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo22getLeastIntTypeByWidthEjb")
  //</editor-fold>
  public TargetInfo.IntType getLeastIntTypeByWidth(/*uint*/int BitWidth, 
                        boolean IsSigned) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Return floating point type with specified width.
  
  /// \brief Return floating point type with specified width.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getRealTypeByWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 212,
   FQN="clang::TargetInfo::getRealTypeByWidth", NM="_ZNK5clang10TargetInfo18getRealTypeByWidthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo18getRealTypeByWidthEj")
  //</editor-fold>
  public TargetInfo.RealType getRealTypeByWidth(/*uint*/int BitWidth) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Return the alignment (in bits) of the specified integer type enum.
  ///
  /// For example, SignedInt -> getIntAlign().
  
  /// \brief Return the alignment (in bits) of the specified integer type enum.
  ///
  /// For example, SignedInt -> getIntAlign().
  
  /// getTypeAlign - Return the alignment (in bits) of the specified integer type
  /// enum. For example, SignedInt -> getIntAlign().
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTypeAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 239,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 235,
   FQN="clang::TargetInfo::getTypeAlign", NM="_ZNK5clang10TargetInfo12getTypeAlignENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo12getTypeAlignENS0_7IntTypeE")
  //</editor-fold>
  public /*uint*/int getTypeAlign(IntType T) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Returns true if the type is signed; false otherwise.
  
  /// \brief Returns true if the type is signed; false otherwise.
  
  /// isTypeSigned - Return whether an integer types is signed. Returns true if
  /// the type is signed; false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isTypeSigned">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 257,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 253,
   FQN="clang::TargetInfo::isTypeSigned", NM="_ZN5clang10TargetInfo12isTypeSignedENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZN5clang10TargetInfo12isTypeSignedENS0_7IntTypeE")
  //</editor-fold>
  public static boolean isTypeSigned(IntType T) {
    return org.clang.basic.target.impl.TargetInfo.isTypeSigned(T);
  }


  
  /// \brief Return the width of pointers on this target, for the
  /// specified address space.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPointerWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 288,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 279,
   FQN="clang::TargetInfo::getPointerWidth", NM="_ZNK5clang10TargetInfo15getPointerWidthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15getPointerWidthEj")
  //</editor-fold>
  public long/*uint64_t*/ getPointerWidth(/*uint*/int AddrSpace) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPointerAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 291,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 282,
   FQN="clang::TargetInfo::getPointerAlign", NM="_ZNK5clang10TargetInfo15getPointerAlignEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15getPointerAlignEj")
  //</editor-fold>
  public long/*uint64_t*/ getPointerAlign(/*uint*/int AddrSpace) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the size of '_Bool' and C++ 'bool' for this target, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getBoolWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 287,
   FQN="clang::TargetInfo::getBoolWidth", NM="_ZNK5clang10TargetInfo12getBoolWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getBoolWidthEv")
  //</editor-fold>
  public /*uint*/int getBoolWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the alignment of '_Bool' and C++ 'bool' for this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getBoolAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 299,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 290,
   FQN="clang::TargetInfo::getBoolAlign", NM="_ZNK5clang10TargetInfo12getBoolAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getBoolAlignEv")
  //</editor-fold>
  public /*uint*/int getBoolAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getCharWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 292,
   FQN="clang::TargetInfo::getCharWidth", NM="_ZNK5clang10TargetInfo12getCharWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getCharWidthEv")
  //</editor-fold>
  public /*uint*/int getCharWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }
 // FIXME
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getCharAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 302,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 293,
   FQN="clang::TargetInfo::getCharAlign", NM="_ZNK5clang10TargetInfo12getCharAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getCharAlignEv")
  //</editor-fold>
  public /*uint*/int getCharAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }
 // FIXME
  
  /// \brief Return the size of 'signed short' and 'unsigned short' for this
  /// target, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getShortWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 306,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 297,
   FQN="clang::TargetInfo::getShortWidth", NM="_ZNK5clang10TargetInfo13getShortWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getShortWidthEv")
  //</editor-fold>
  public /*uint*/int getShortWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }
 // FIXME
  
  /// \brief Return the alignment of 'signed short' and 'unsigned short' for
  /// this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getShortAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 310,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 301,
   FQN="clang::TargetInfo::getShortAlign", NM="_ZNK5clang10TargetInfo13getShortAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getShortAlignEv")
  //</editor-fold>
  public /*uint*/int getShortAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }
 // FIXME
  
  /// getIntWidth/Align - Return the size of 'signed int' and 'unsigned int' for
  /// this target, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getIntWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 305,
   FQN="clang::TargetInfo::getIntWidth", NM="_ZNK5clang10TargetInfo11getIntWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo11getIntWidthEv")
  //</editor-fold>
  public /*uint*/int getIntWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getIntAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 306,
   FQN="clang::TargetInfo::getIntAlign", NM="_ZNK5clang10TargetInfo11getIntAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo11getIntAlignEv")
  //</editor-fold>
  public /*uint*/int getIntAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getLongWidth/Align - Return the size of 'signed long' and 'unsigned long'
  /// for this target, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 310,
   FQN="clang::TargetInfo::getLongWidth", NM="_ZNK5clang10TargetInfo12getLongWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getLongWidthEv")
  //</editor-fold>
  public /*uint*/int getLongWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 320,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 311,
   FQN="clang::TargetInfo::getLongAlign", NM="_ZNK5clang10TargetInfo12getLongAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getLongAlignEv")
  //</editor-fold>
  public /*uint*/int getLongAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getLongLongWidth/Align - Return the size of 'signed long long' and
  /// 'unsigned long long' for this target, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongLongWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 315,
   FQN="clang::TargetInfo::getLongLongWidth", NM="_ZNK5clang10TargetInfo16getLongLongWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getLongLongWidthEv")
  //</editor-fold>
  public /*uint*/int getLongLongWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongLongAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 325,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 316,
   FQN="clang::TargetInfo::getLongLongAlign", NM="_ZNK5clang10TargetInfo16getLongLongAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getLongLongAlignEv")
  //</editor-fold>
  public /*uint*/int getLongLongAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Determine whether the __int128 type is supported on this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasInt128Type">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 319,
   FQN="clang::TargetInfo::hasInt128Type", NM="_ZNK5clang10TargetInfo13hasInt128TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13hasInt128TypeEv")
  //</editor-fold>
  public /*virtual*/ boolean hasInt128Type() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }
 // FIXME
  
  /// \brief Determine whether the __float128 type is supported on this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasFloat128Type">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 333,
   FQN="clang::TargetInfo::hasFloat128Type", NM="_ZNK5clang10TargetInfo15hasFloat128TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15hasFloat128TypeEv")
  //</editor-fold>
  public /*virtual*/ boolean hasFloat128Type() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the alignment that is suitable for storing any
  /// object with a fundamental alignment requirement.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getSuitableAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 337,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 325,
   FQN="clang::TargetInfo::getSuitableAlign", NM="_ZNK5clang10TargetInfo16getSuitableAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getSuitableAlignEv")
  //</editor-fold>
  public /*uint*/int getSuitableAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the default alignment for __attribute__((aligned)) on
  /// this target, to be used if no alignment value is specified.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getDefaultAlignForAttributeAligned">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 329,
   FQN="clang::TargetInfo::getDefaultAlignForAttributeAligned", NM="_ZNK5clang10TargetInfo34getDefaultAlignForAttributeAlignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo34getDefaultAlignForAttributeAlignedEv")
  //</editor-fold>
  public /*uint*/int getDefaultAlignForAttributeAligned() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getMinGlobalAlign - Return the minimum alignment of a global variable,
  /// unless its alignment is explicitly reduced via attributes.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getMinGlobalAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 347,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 335,
   FQN="clang::TargetInfo::getMinGlobalAlign", NM="_ZNK5clang10TargetInfo17getMinGlobalAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17getMinGlobalAlignEv")
  //</editor-fold>
  public /*uint*/int getMinGlobalAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getWCharWidth/Align - Return the size of 'wchar_t' for this target, in
  /// bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getWCharWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 351,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 339,
   FQN="clang::TargetInfo::getWCharWidth", NM="_ZNK5clang10TargetInfo13getWCharWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getWCharWidthEv")
  //</editor-fold>
  public /*uint*/int getWCharWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getWCharAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 352,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 340,
   FQN="clang::TargetInfo::getWCharAlign", NM="_ZNK5clang10TargetInfo13getWCharAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getWCharAlignEv")
  //</editor-fold>
  public /*uint*/int getWCharAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getChar16Width/Align - Return the size of 'char16_t' for this target, in
  /// bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getChar16Width">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 356,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 344,
   FQN="clang::TargetInfo::getChar16Width", NM="_ZNK5clang10TargetInfo14getChar16WidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getChar16WidthEv")
  //</editor-fold>
  public /*uint*/int getChar16Width() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getChar16Align">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 357,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 345,
   FQN="clang::TargetInfo::getChar16Align", NM="_ZNK5clang10TargetInfo14getChar16AlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getChar16AlignEv")
  //</editor-fold>
  public /*uint*/int getChar16Align() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getChar32Width/Align - Return the size of 'char32_t' for this target, in
  /// bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getChar32Width">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 349,
   FQN="clang::TargetInfo::getChar32Width", NM="_ZNK5clang10TargetInfo14getChar32WidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getChar32WidthEv")
  //</editor-fold>
  public /*uint*/int getChar32Width() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getChar32Align">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 362,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 350,
   FQN="clang::TargetInfo::getChar32Align", NM="_ZNK5clang10TargetInfo14getChar32AlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getChar32AlignEv")
  //</editor-fold>
  public /*uint*/int getChar32Align() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getHalfWidth/Align/Format - Return the size/align/format of 'half'.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getHalfWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 365,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 353,
   FQN="clang::TargetInfo::getHalfWidth", NM="_ZNK5clang10TargetInfo12getHalfWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getHalfWidthEv")
  //</editor-fold>
  public /*uint*/int getHalfWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getHalfAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 366,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 354,
   FQN="clang::TargetInfo::getHalfAlign", NM="_ZNK5clang10TargetInfo12getHalfAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo12getHalfAlignEv")
  //</editor-fold>
  public /*uint*/int getHalfAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getHalfFormat">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 367,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 355,
   FQN="clang::TargetInfo::getHalfFormat", NM="_ZNK5clang10TargetInfo13getHalfFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getHalfFormatEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getHalfFormat() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getFloatWidth/Align/Format - Return the size/align/format of 'float'.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloatWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 370,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 358,
   FQN="clang::TargetInfo::getFloatWidth", NM="_ZNK5clang10TargetInfo13getFloatWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getFloatWidthEv")
  //</editor-fold>
  public /*uint*/int getFloatWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloatAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 371,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 359,
   FQN="clang::TargetInfo::getFloatAlign", NM="_ZNK5clang10TargetInfo13getFloatAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getFloatAlignEv")
  //</editor-fold>
  public /*uint*/int getFloatAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloatFormat">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 372,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 360,
   FQN="clang::TargetInfo::getFloatFormat", NM="_ZNK5clang10TargetInfo14getFloatFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getFloatFormatEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getFloatFormat() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getDoubleWidth/Align/Format - Return the size/align/format of 'double'.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getDoubleWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 375,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 363,
   FQN="clang::TargetInfo::getDoubleWidth", NM="_ZNK5clang10TargetInfo14getDoubleWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getDoubleWidthEv")
  //</editor-fold>
  public /*uint*/int getDoubleWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getDoubleAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 376,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 364,
   FQN="clang::TargetInfo::getDoubleAlign", NM="_ZNK5clang10TargetInfo14getDoubleAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getDoubleAlignEv")
  //</editor-fold>
  public /*uint*/int getDoubleAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getDoubleFormat">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 377,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 365,
   FQN="clang::TargetInfo::getDoubleFormat", NM="_ZNK5clang10TargetInfo15getDoubleFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15getDoubleFormatEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getDoubleFormat() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getLongDoubleWidth/Align/Format - Return the size/align/format of 'long
  /// double'.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongDoubleWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 369,
   FQN="clang::TargetInfo::getLongDoubleWidth", NM="_ZNK5clang10TargetInfo18getLongDoubleWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getLongDoubleWidthEv")
  //</editor-fold>
  public /*uint*/int getLongDoubleWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongDoubleAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 382,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 370,
   FQN="clang::TargetInfo::getLongDoubleAlign", NM="_ZNK5clang10TargetInfo18getLongDoubleAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getLongDoubleAlignEv")
  //</editor-fold>
  public /*uint*/int getLongDoubleAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLongDoubleFormat">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 383,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 371,
   FQN="clang::TargetInfo::getLongDoubleFormat", NM="_ZNK5clang10TargetInfo19getLongDoubleFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo19getLongDoubleFormatEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getLongDoubleFormat() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// getFloat128Width/Align/Format - Return the size/align/format of
  /// '__float128'.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloat128Width">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 389,
   FQN="clang::TargetInfo::getFloat128Width", NM="_ZNK5clang10TargetInfo16getFloat128WidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getFloat128WidthEv")
  //</editor-fold>
  public /*uint*/int getFloat128Width() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloat128Align">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 390,
   FQN="clang::TargetInfo::getFloat128Align", NM="_ZNK5clang10TargetInfo16getFloat128AlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getFloat128AlignEv")
  //</editor-fold>
  public /*uint*/int getFloat128Align() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloat128Format">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 391,
   FQN="clang::TargetInfo::getFloat128Format", NM="_ZNK5clang10TargetInfo17getFloat128FormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17getFloat128FormatEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getFloat128Format() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return true if the 'long double' type should be mangled like
  /// __float128.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useFloat128ManglingForLongDouble">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 397,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 377,
   FQN="clang::TargetInfo::useFloat128ManglingForLongDouble", NM="_ZNK5clang10TargetInfo32useFloat128ManglingForLongDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo32useFloat128ManglingForLongDoubleEv")
  //</editor-fold>
  public /*virtual*/ boolean useFloat128ManglingForLongDouble() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the value for the C99 FLT_EVAL_METHOD macro.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getFloatEvalMethod">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 400,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 380,
   FQN="clang::TargetInfo::getFloatEvalMethod", NM="_ZNK5clang10TargetInfo18getFloatEvalMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getFloatEvalMethodEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getFloatEvalMethod() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  // getLargeArrayMinWidth/Align - Return the minimum array size that is
  // 'large' and its alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLargeArrayMinWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 384,
   FQN="clang::TargetInfo::getLargeArrayMinWidth", NM="_ZNK5clang10TargetInfo21getLargeArrayMinWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo21getLargeArrayMinWidthEv")
  //</editor-fold>
  public /*uint*/int getLargeArrayMinWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getLargeArrayAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 385,
   FQN="clang::TargetInfo::getLargeArrayAlign", NM="_ZNK5clang10TargetInfo18getLargeArrayAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getLargeArrayAlignEv")
  //</editor-fold>
  public /*uint*/int getLargeArrayAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the maximum width lock-free atomic operation which will
  /// ever be supported for the given target
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getMaxAtomicPromoteWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 409,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 389,
   FQN="clang::TargetInfo::getMaxAtomicPromoteWidth", NM="_ZNK5clang10TargetInfo24getMaxAtomicPromoteWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo24getMaxAtomicPromoteWidthEv")
  //</editor-fold>
  public /*uint*/int getMaxAtomicPromoteWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  /// \brief Return the maximum width lock-free atomic operation which can be
  /// inlined given the supported features of the given target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getMaxAtomicInlineWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 412,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 392,
   FQN="clang::TargetInfo::getMaxAtomicInlineWidth", NM="_ZNK5clang10TargetInfo23getMaxAtomicInlineWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo23getMaxAtomicInlineWidthEv")
  //</editor-fold>
  public /*uint*/int getMaxAtomicInlineWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  /// \brief Returns true if the given target supports lock-free atomic
  /// operations at the specified width and alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasBuiltinAtomic">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 415,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 395,
   FQN="clang::TargetInfo::hasBuiltinAtomic", NM="_ZNK5clang10TargetInfo16hasBuiltinAtomicEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16hasBuiltinAtomicEyy")
  //</editor-fold>
  public /*virtual*/ boolean hasBuiltinAtomic(long/*uint64_t*/ AtomicSizeInBits, 
                  long/*uint64_t*/ AlignmentInBits) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the maximum vector alignment supported for the given target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getMaxVectorAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 424,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 404,
   FQN="clang::TargetInfo::getMaxVectorAlign", NM="_ZNK5clang10TargetInfo17getMaxVectorAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17getMaxVectorAlignEv")
  //</editor-fold>
  public /*uint*/int getMaxVectorAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  /// \brief Return default simd alignment for the given target. Generally, this
  /// value is type-specific, but this alignment can be used for most of the
  /// types for the given target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getSimdDefaultAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 428,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 408,
   FQN="clang::TargetInfo::getSimdDefaultAlign", NM="_ZNK5clang10TargetInfo19getSimdDefaultAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo19getSimdDefaultAlignEv")
  //</editor-fold>
  public /*uint*/int getSimdDefaultAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// Return the alignment (in bits) of the thrown exception object. This is
  /// only meaningful for targets that allocate C++ exceptions in a system
  /// runtime, such as those using the Itanium C++ ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getExnObjectAlignment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 433,
   FQN="clang::TargetInfo::getExnObjectAlignment", NM="_ZNK5clang10TargetInfo21getExnObjectAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo21getExnObjectAlignmentEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getExnObjectAlignment() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the size of intmax_t and uintmax_t for this target, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getIntMaxTWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 446,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 411,
   FQN="clang::TargetInfo::getIntMaxTWidth", NM="_ZNK5clang10TargetInfo15getIntMaxTWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15getIntMaxTWidthEv")
  //</editor-fold>
  public /*uint*/int getIntMaxTWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  // Return the size of unwind_word for this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getUnwindWordWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 451,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 416,
   FQN="clang::TargetInfo::getUnwindWordWidth", NM="_ZNK5clang10TargetInfo18getUnwindWordWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getUnwindWordWidthEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getUnwindWordWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the "preferred" register width on this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getRegisterWidth">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 454,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 419,
   FQN="clang::TargetInfo::getRegisterWidth", NM="_ZNK5clang10TargetInfo16getRegisterWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getRegisterWidthEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getRegisterWidth() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Returns the name of the mcount instrumentation function.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getMCountName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 462,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 435,
   FQN="clang::TargetInfo::getMCountName", NM="_ZNK5clang10TargetInfo13getMCountNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getMCountNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getMCountName() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check if the Objective-C built-in boolean type should be signed
  /// char.
  ///
  /// Otherwise, if this returns false, the normal built-in boolean type
  /// should also be used for Objective-C.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useSignedCharForObjCBool">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 471,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 444,
   FQN="clang::TargetInfo::useSignedCharForObjCBool", NM="_ZNK5clang10TargetInfo24useSignedCharForObjCBoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo24useSignedCharForObjCBoolEv")
  //</editor-fold>
  public boolean useSignedCharForObjCBool() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::noSignedCharForObjCBool">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 447,
   FQN="clang::TargetInfo::noSignedCharForObjCBool", NM="_ZN5clang10TargetInfo23noSignedCharForObjCBoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo23noSignedCharForObjCBoolEv")
  //</editor-fold>
  public void noSignedCharForObjCBool() {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check whether the alignment of bit-field types is respected
  /// when laying out structures.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useBitFieldTypeAlignment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 480,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 453,
   FQN="clang::TargetInfo::useBitFieldTypeAlignment", NM="_ZNK5clang10TargetInfo24useBitFieldTypeAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo24useBitFieldTypeAlignmentEv")
  //</editor-fold>
  public boolean useBitFieldTypeAlignment() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check whether zero length bitfields should force alignment of
  /// the next member.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useZeroLengthBitfieldAlignment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 486,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 459,
   FQN="clang::TargetInfo::useZeroLengthBitfieldAlignment", NM="_ZNK5clang10TargetInfo30useZeroLengthBitfieldAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo30useZeroLengthBitfieldAlignmentEv")
  //</editor-fold>
  public boolean useZeroLengthBitfieldAlignment() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Get the fixed alignment value in bits for a member that follows
  /// a zero length bitfield.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getZeroLengthBitfieldBoundary">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 492,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 465,
   FQN="clang::TargetInfo::getZeroLengthBitfieldBoundary", NM="_ZNK5clang10TargetInfo29getZeroLengthBitfieldBoundaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo29getZeroLengthBitfieldBoundaryEv")
  //</editor-fold>
  public /*uint*/int getZeroLengthBitfieldBoundary() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check whether explicit bitfield alignment attributes should be
  //  honored, as in "__attribute__((aligned(2))) int b : 1;".
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useExplicitBitFieldAlignment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 498,
   FQN="clang::TargetInfo::useExplicitBitFieldAlignment", NM="_ZNK5clang10TargetInfo28useExplicitBitFieldAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo28useExplicitBitFieldAlignmentEv")
  //</editor-fold>
  public boolean useExplicitBitFieldAlignment() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check whether this target support '\#pragma options align=mac68k'.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasAlignMac68kSupport">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 503,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 470,
   FQN="clang::TargetInfo::hasAlignMac68kSupport", NM="_ZNK5clang10TargetInfo21hasAlignMac68kSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo21hasAlignMac68kSupportEv")
  //</editor-fold>
  public boolean hasAlignMac68kSupport() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the user string for the specified integer type enum.
  ///
  /// For example, SignedShort -> "short".
  
  /// \brief Return the user string for the specified integer type enum.
  ///
  /// For example, SignedShort -> "short".
  
  /// getTypeName - Return the user string for the specified integer type enum.
  /// For example, SignedShort -> "short".
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTypeName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 107,
   FQN="clang::TargetInfo::getTypeName", NM="_ZN5clang10TargetInfo11getTypeNameENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZN5clang10TargetInfo11getTypeNameENS0_7IntTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getTypeName(IntType T) {
    return org.clang.basic.target.impl.TargetInfo.getTypeName(T);
  }


  
  /// \brief Return the constant suffix for the specified integer type enum.
  ///
  /// For example, SignedLong -> "L".
  
  /// \brief Return the constant suffix for the specified integer type enum.
  ///
  /// For example, SignedLong -> "L".
  
  /// getTypeConstantSuffix - Return the constant suffix for the specified
  /// integer type enum. For example, SignedLong -> "L".
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTypeConstantSuffix">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 127,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 125,
   FQN="clang::TargetInfo::getTypeConstantSuffix", NM="_ZNK5clang10TargetInfo21getTypeConstantSuffixENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo21getTypeConstantSuffixENS0_7IntTypeE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getTypeConstantSuffix(IntType T) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Return the printf format modifier for the specified
  /// integer type enum.
  ///
  /// For example, SignedLong -> "l".
  
  /// \brief Return the printf format modifier for the specified
  /// integer type enum.
  ///
  /// For example, SignedLong -> "l".
  
  /// getTypeFormatModifier - Return the printf format modifier for the
  /// specified integer type enum. For example, SignedLong -> "l".
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTypeFormatModifier">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 150,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 148,
   FQN="clang::TargetInfo::getTypeFormatModifier", NM="_ZN5clang10TargetInfo21getTypeFormatModifierENS0_7IntTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZN5clang10TargetInfo21getTypeFormatModifierENS0_7IntTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getTypeFormatModifier(IntType T) {
    return org.clang.basic.target.impl.TargetInfo.getTypeFormatModifier(T);
  }


  
  /// \brief Check whether the given real type should use the "fpret" flavor of
  /// Objective-C message passing on this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useObjCFPRetForRealType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 525,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 492,
   FQN="clang::TargetInfo::useObjCFPRetForRealType", NM="_ZNK5clang10TargetInfo23useObjCFPRetForRealTypeENS0_8RealTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo23useObjCFPRetForRealTypeENS0_8RealTypeE")
  //</editor-fold>
  public boolean useObjCFPRetForRealType(RealType T) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check whether _Complex long double should use the "fp2ret" flavor
  /// of Objective-C message passing on this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useObjCFP2RetForComplexLongDouble">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 531,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 498,
   FQN="clang::TargetInfo::useObjCFP2RetForComplexLongDouble", NM="_ZNK5clang10TargetInfo33useObjCFP2RetForComplexLongDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo33useObjCFP2RetForComplexLongDoubleEv")
  //</editor-fold>
  public boolean useObjCFP2RetForComplexLongDouble() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Specify if mangling based on address space map should be used or
  /// not for language specific address spaces
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::useAddressSpaceMapMangling">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 537,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 504,
   FQN="clang::TargetInfo::useAddressSpaceMapMangling", NM="_ZNK5clang10TargetInfo26useAddressSpaceMapManglingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo26useAddressSpaceMapManglingEv")
  //</editor-fold>
  public boolean useAddressSpaceMapMangling() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  ///===---- Other target property query methods --------------------------===//
  
  /// \brief Appends the target-specific \#define values for this
  /// target set to the specified buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 545,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 512,
   FQN="clang::TargetInfo::getTargetDefines", NM="_ZNK5clang10TargetInfo16getTargetDefinesERKNS_11LangOptionsERNS_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getTargetDefinesERKNS_11LangOptionsERNS_12MacroBuilderE")
  //</editor-fold>
  public abstract /*virtual*/ void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* = 0*/;

  
  /// Return information about target-specific builtins for
  /// the current primary target, and info about which builtins are non-portable
  /// across the current set of primary and secondary targets.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 552,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 519,
   FQN="clang::TargetInfo::getTargetBuiltins", NM="_ZNK5clang10TargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  public abstract /*virtual*/ ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* = 0*/;

  
  /// The __builtin_clz* and __builtin_ctz* built-in
  /// functions are specified to have undefined results for zero inputs, but
  /// on targets that support these operations in a way that provides
  /// well-defined results for zero without loss of performance, it is a good
  /// idea to avoid optimizing based on that undef behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isCLZForZeroUndef">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 559,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 526,
   FQN="clang::TargetInfo::isCLZForZeroUndef", NM="_ZNK5clang10TargetInfo17isCLZForZeroUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17isCLZForZeroUndefEv")
  //</editor-fold>
  public /*virtual*/ boolean isCLZForZeroUndef() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Returns the kind of __builtin_va_list type that should be used
  /// with this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 563,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 530,
   FQN="clang::TargetInfo::getBuiltinVaListKind", NM="_ZNK5clang10TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  public abstract /*virtual*/ BuiltinVaListKind getBuiltinVaListKind() /*const*//* = 0*/;

  
  /// Returns whether or not type \c __builtin_ms_va_list type is
  /// available on this target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasBuiltinMSVaList">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 567,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 534,
   FQN="clang::TargetInfo::hasBuiltinMSVaList", NM="_ZNK5clang10TargetInfo18hasBuiltinMSVaListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18hasBuiltinMSVaListEv")
  //</editor-fold>
  public boolean hasBuiltinMSVaList() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Returns whether the passed in string is a valid clobber in an
  /// inline asm statement.
  ///
  /// This is used by Sema.
  
  /// \brief Returns whether the passed in string is a valid clobber in an
  /// inline asm statement.
  ///
  /// This is used by Sema.
  
  /// isValidClobber - Returns whether the passed in string is
  /// a valid clobber in an inline asm statement. This is used by
  /// Sema.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isValidClobber">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 348,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 340,
   FQN="clang::TargetInfo::isValidClobber", NM="_ZNK5clang10TargetInfo14isValidClobberEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo14isValidClobberEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isValidClobber(StringRef Name) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Returns whether the passed in string is a valid register name
  /// according to GCC.
  ///
  /// This is used by Sema for inline asm statements.
  
  /// \brief Returns whether the passed in string is a valid register name
  /// according to GCC.
  ///
  /// This is used by Sema for inline asm statements.
  
  /// isValidGCCRegisterName - Returns whether the passed in string
  /// is a valid register name according to GCC. This is used by Sema for
  /// inline asm statements.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isValidGCCRegisterName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 356,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 348,
   FQN="clang::TargetInfo::isValidGCCRegisterName", NM="_ZNK5clang10TargetInfo22isValidGCCRegisterNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo22isValidGCCRegisterNameEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isValidGCCRegisterName(StringRef Name) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Returns the "normalized" GCC register name.
  ///
  /// For example, on x86 it will return "ax" when "eax" is passed in.
  
  /// \brief Returns the "normalized" GCC register name.
  ///
  /// For example, on x86 it will return "ax" when "eax" is passed in.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getNormalizedGCCRegisterName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 401,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 393,
   FQN="clang::TargetInfo::getNormalizedGCCRegisterName", NM="_ZNK5clang10TargetInfo28getNormalizedGCCRegisterNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo28getNormalizedGCCRegisterNameEN4llvm9StringRefE")
  //</editor-fold>
  public StringRef getNormalizedGCCRegisterName(StringRef Name) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 586,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 553,
   FQN="clang::TargetInfo::ConstraintInfo", NM="_ZN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  public static class/*struct*/ ConstraintInfo implements Destructors.ClassWithDestructor, NativeCloneable<ConstraintInfo> {

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 587,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 554,
     FQN="clang::TargetInfo::ConstraintInfo::(anonymous)", NM="_ZN5clang10TargetInfo14ConstraintInfoE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int CI_None = 0x00;
      public static final /*uint*/int CI_AllowsMemory = 0x01;
      public static final /*uint*/int CI_AllowsRegister = 0x02;
      public static final /*uint*/int CI_ReadWrite = 0x04; // "+r" output constraint (read and write).
      public static final /*uint*/int CI_HasMatchingInput = 0x08; // This output operand has a matching input.
      public static final /*uint*/int CI_ImmediateConstant = 0x10; // This operand must be an immediate constant
      public static final /*uint*/int CI_EarlyClobber = 0x20; // "&" output constraint (early clobber).
    /*}*/;
    public /*uint*/int Flags;
    public int TiedOperand;
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 598,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 565,
     FQN="clang::TargetInfo::ConstraintInfo::(anonymous)", NM="_ZN5clang10TargetInfo14ConstraintInfoE_Unnamed_struct1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoE_Unnamed_struct1")
    //</editor-fold>
    public static class/*struct*/ Unnamed_struct1 {
      public int Min;
      public int Max;
      //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::(anonymous struct)::">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 598,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 565,
       FQN="clang::TargetInfo::ConstraintInfo::(anonymous struct)::", NM="_ZN5clang10TargetInfo14ConstraintInfoUt0_C1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoUt0_C1ERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1(Unnamed_struct1 $Prm0) {
        /* : Min(.Min), Max(.Max)*/ 
        //START JInit
        this.Min = $Prm0.Min;
        this.Max = $Prm0.Max;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::(anonymous struct)::">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 598,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 565,
       FQN="clang::TargetInfo::ConstraintInfo::(anonymous struct)::", NM="_ZN5clang10TargetInfo14ConstraintInfoUt0_C1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoUt0_C1EOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1(JD$Move _dparam, Unnamed_struct1 $Prm0) {
        /* : Min(static_cast<(anonymous struct at /home/vv159170/devarea/LLVM39/llvm/tools/clang/include/clang/Basic/TargetInfo.h:598:5) &&>().Min), Max(static_cast<(anonymous struct at /home/vv159170/devarea/LLVM39/llvm/tools/clang/include/clang/Basic/TargetInfo.h:598:5) &&>().Max)*/ 
        //START JInit
        this.Min = $Prm0.Min;
        this.Max = $Prm0.Max;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::(anonymous struct)::">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 598,
       old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 565,
       FQN="clang::TargetInfo::ConstraintInfo::(anonymous struct)::", NM="_ZN5clang10TargetInfo14ConstraintInfoUt0_C1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoUt0_C1Ev")
      //</editor-fold>
      public /*inline*/ Unnamed_struct1() {
      }

      
      public String toString() {
        return "" + "Min=" + Min // NOI18N
                  + ", Max=" + Max; // NOI18N
      }
    };
    public final Unnamed_struct1 ImmRange;
    public final SmallSetInt ImmSet;
    
    public final std.string ConstraintStr; // constraint: "=rm"
    public final std.string Name; // Operand name: [foo] with no []'s.
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 607,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 574,
     FQN="clang::TargetInfo::ConstraintInfo::ConstraintInfo", NM="_ZN5clang10TargetInfo14ConstraintInfoC1EN4llvm9StringRefES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoC1EN4llvm9StringRefES3_")
    //</editor-fold>
    public ConstraintInfo(StringRef ConstraintStr, StringRef Name) {
      /* : Flags(0), TiedOperand(-1), ImmRange(), ImmSet(), ConstraintStr(ConstraintStr.str()), Name(Name.str())*/ 
      //START JInit
      this.Flags = 0;
      this.TiedOperand = -1;
      this.ImmRange = new Unnamed_struct1();
      this.ImmSet = new SmallSetInt(4);
      this.ConstraintStr = ConstraintStr.str();
      this.Name = Name.str();
      //END JInit
      ImmRange.Min = ImmRange.Max = 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::getConstraintStr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 613,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 580,
     FQN="clang::TargetInfo::ConstraintInfo::getConstraintStr", NM="_ZNK5clang10TargetInfo14ConstraintInfo16getConstraintStrEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo16getConstraintStrEv")
    //</editor-fold>
    public /*const*/std.string/*&*/ getConstraintStr() /*const*/ {
      return ConstraintStr;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::getName">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 614,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 581,
     FQN="clang::TargetInfo::ConstraintInfo::getName", NM="_ZNK5clang10TargetInfo14ConstraintInfo7getNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo7getNameEv")
    //</editor-fold>
    public /*const*/std.string/*&*/ getName() /*const*/ {
      return Name;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::isReadWrite">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 615,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 582,
     FQN="clang::TargetInfo::ConstraintInfo::isReadWrite", NM="_ZNK5clang10TargetInfo14ConstraintInfo11isReadWriteEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo11isReadWriteEv")
    //</editor-fold>
    public boolean isReadWrite() /*const*/ {
      return (Flags & CI_ReadWrite) != 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::earlyClobber">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 616,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 583,
     FQN="clang::TargetInfo::ConstraintInfo::earlyClobber", NM="_ZN5clang10TargetInfo14ConstraintInfo12earlyClobberEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo12earlyClobberEv")
    //</editor-fold>
    public boolean earlyClobber() {
      return (Flags & CI_EarlyClobber) != 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::allowsRegister">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 617,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 584,
     FQN="clang::TargetInfo::ConstraintInfo::allowsRegister", NM="_ZNK5clang10TargetInfo14ConstraintInfo14allowsRegisterEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo14allowsRegisterEv")
    //</editor-fold>
    public boolean allowsRegister() /*const*/ {
      return (Flags & CI_AllowsRegister) != 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::allowsMemory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 618,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 585,
     FQN="clang::TargetInfo::ConstraintInfo::allowsMemory", NM="_ZNK5clang10TargetInfo14ConstraintInfo12allowsMemoryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo12allowsMemoryEv")
    //</editor-fold>
    public boolean allowsMemory() /*const*/ {
      return (Flags & CI_AllowsMemory) != 0;
    }

    
    /// \brief Return true if this output operand has a matching
    /// (tied) input operand.
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::hasMatchingInput">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 622,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 589,
     FQN="clang::TargetInfo::ConstraintInfo::hasMatchingInput", NM="_ZNK5clang10TargetInfo14ConstraintInfo16hasMatchingInputEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo16hasMatchingInputEv")
    //</editor-fold>
    public boolean hasMatchingInput() /*const*/ {
      return (Flags & CI_HasMatchingInput) != 0;
    }

    
    /// \brief Return true if this input operand is a matching
    /// constraint that ties it to an output operand.
    ///
    /// If this returns true then getTiedOperand will indicate which output
    /// operand this is tied to.
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::hasTiedOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 629,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 596,
     FQN="clang::TargetInfo::ConstraintInfo::hasTiedOperand", NM="_ZNK5clang10TargetInfo14ConstraintInfo14hasTiedOperandEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo14hasTiedOperandEv")
    //</editor-fold>
    public boolean hasTiedOperand() /*const*/ {
      return TiedOperand != -1;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::getTiedOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 630,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 597,
     FQN="clang::TargetInfo::ConstraintInfo::getTiedOperand", NM="_ZNK5clang10TargetInfo14ConstraintInfo14getTiedOperandEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo14getTiedOperandEv")
    //</editor-fold>
    public /*uint*/int getTiedOperand() /*const*/ {
      assert (hasTiedOperand()) : "Has no tied operand!";
      return (/*uint*/int)TiedOperand;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::requiresImmediateConstant">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 635,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 602,
     FQN="clang::TargetInfo::ConstraintInfo::requiresImmediateConstant", NM="_ZNK5clang10TargetInfo14ConstraintInfo25requiresImmediateConstantEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo25requiresImmediateConstantEv")
    //</editor-fold>
    public boolean requiresImmediateConstant() /*const*/ {
      return (Flags & CI_ImmediateConstant) != 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::isValidAsmImmediate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 638,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 605,
     FQN="clang::TargetInfo::ConstraintInfo::isValidAsmImmediate", NM="_ZNK5clang10TargetInfo14ConstraintInfo19isValidAsmImmediateERKN4llvm5APIntE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14ConstraintInfo19isValidAsmImmediateERKN4llvm5APIntE")
    //</editor-fold>
    public boolean isValidAsmImmediate(/*const*/ APInt /*&*/ Value) /*const*/ {
      return (Value.sge(ImmRange.Min) && Value.sle($int2ulong(ImmRange.Max)))
         || ImmSet.count($ulong2int(Value.getZExtValue())) != 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setIsReadWrite">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 643,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 610,
     FQN="clang::TargetInfo::ConstraintInfo::setIsReadWrite", NM="_ZN5clang10TargetInfo14ConstraintInfo14setIsReadWriteEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo14setIsReadWriteEv")
    //</editor-fold>
    public void setIsReadWrite() {
      Flags |= CI_ReadWrite;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setEarlyClobber">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 644,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 611,
     FQN="clang::TargetInfo::ConstraintInfo::setEarlyClobber", NM="_ZN5clang10TargetInfo14ConstraintInfo15setEarlyClobberEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo15setEarlyClobberEv")
    //</editor-fold>
    public void setEarlyClobber() {
      Flags |= CI_EarlyClobber;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setAllowsMemory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 645,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 612,
     FQN="clang::TargetInfo::ConstraintInfo::setAllowsMemory", NM="_ZN5clang10TargetInfo14ConstraintInfo15setAllowsMemoryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo15setAllowsMemoryEv")
    //</editor-fold>
    public void setAllowsMemory() {
      Flags |= CI_AllowsMemory;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setAllowsRegister">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 646,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 613,
     FQN="clang::TargetInfo::ConstraintInfo::setAllowsRegister", NM="_ZN5clang10TargetInfo14ConstraintInfo17setAllowsRegisterEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo17setAllowsRegisterEv")
    //</editor-fold>
    public void setAllowsRegister() {
      Flags |= CI_AllowsRegister;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setHasMatchingInput">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 647,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 614,
     FQN="clang::TargetInfo::ConstraintInfo::setHasMatchingInput", NM="_ZN5clang10TargetInfo14ConstraintInfo19setHasMatchingInputEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo19setHasMatchingInputEv")
    //</editor-fold>
    public void setHasMatchingInput() {
      Flags |= CI_HasMatchingInput;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setRequiresImmediate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 648,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 615,
     FQN="clang::TargetInfo::ConstraintInfo::setRequiresImmediate", NM="_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEii",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEii")
    //</editor-fold>
    public void setRequiresImmediate(int Min, int Max) {
      Flags |= CI_ImmediateConstant;
      ImmRange.Min = Min;
      ImmRange.Max = Max;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setRequiresImmediate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 653,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 620,
     FQN="clang::TargetInfo::ConstraintInfo::setRequiresImmediate", NM="_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEN4llvm8ArrayRefIiEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEN4llvm8ArrayRefIiEE")
    //</editor-fold>
    public void setRequiresImmediate(ArrayRefInt Exacts) {
      Flags |= CI_ImmediateConstant;
      for (int Exact : Exacts)  {
        ImmSet.insert(Exact);
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setRequiresImmediate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 658,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 625,
     FQN="clang::TargetInfo::ConstraintInfo::setRequiresImmediate", NM="_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEi")
    //</editor-fold>
    public void setRequiresImmediate(int Exact) {
      Flags |= CI_ImmediateConstant;
      ImmSet.insert(Exact);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setRequiresImmediate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 662,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 629,
     FQN="clang::TargetInfo::ConstraintInfo::setRequiresImmediate", NM="_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo20setRequiresImmediateEv")
    //</editor-fold>
    public void setRequiresImmediate() {
      Flags |= CI_ImmediateConstant;
      ImmRange.Min = INT_MIN;
      ImmRange.Max = INT_MAX;
    }

    
    /// \brief Indicate that this is an input operand that is tied to
    /// the specified output operand.
    ///
    /// Copy over the various constraint information from the output.
    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::setTiedOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 672,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 639,
     FQN="clang::TargetInfo::ConstraintInfo::setTiedOperand", NM="_ZN5clang10TargetInfo14ConstraintInfo14setTiedOperandEjRS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfo14setTiedOperandEjRS1_")
    //</editor-fold>
    public void setTiedOperand(/*uint*/int N, ConstraintInfo /*&*/ Output) {
      Output.setHasMatchingInput();
      Flags = Output.Flags;
      TiedOperand = N;
      // Don't copy Name or constraint string.
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 586,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 553,
     FQN="clang::TargetInfo::ConstraintInfo::ConstraintInfo", NM="_ZN5clang10TargetInfo14ConstraintInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ConstraintInfo(/*const*/ ConstraintInfo /*&*/ $Prm0) {
      /* : Flags(.Flags), TiedOperand(.TiedOperand), ImmRange(.ImmRange), ImmSet(.ImmSet), ConstraintStr(.ConstraintStr), Name(.Name)*/ 
      //START JInit
      this.Flags = $Prm0.Flags;
      this.TiedOperand = $Prm0.TiedOperand;
      this.ImmRange = new Unnamed_struct1($Prm0.ImmRange);
      this.ImmSet = new SmallSetInt($Prm0.ImmSet);
      this.ConstraintStr = new std.string($Prm0.ConstraintStr);
      this.Name = new std.string($Prm0.Name);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 586,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 553,
     FQN="clang::TargetInfo::ConstraintInfo::ConstraintInfo", NM="_ZN5clang10TargetInfo14ConstraintInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ConstraintInfo(JD$Move _dparam, ConstraintInfo /*&&*/$Prm0) {
      /* : Flags(static_cast<ConstraintInfo &&>().Flags), TiedOperand(static_cast<ConstraintInfo &&>().TiedOperand), ImmRange(static_cast<ConstraintInfo &&>().ImmRange), ImmSet(static_cast<ConstraintInfo &&>().ImmSet), ConstraintStr(static_cast<ConstraintInfo &&>().ConstraintStr), Name(static_cast<ConstraintInfo &&>().Name)*/ 
      //START JInit
      this.Flags = $Prm0.Flags;
      this.TiedOperand = $Prm0.TiedOperand;
      this.ImmRange = new Unnamed_struct1(JD$Move.INSTANCE, $Prm0.ImmRange);
      this.ImmSet = new SmallSetInt(JD$Move.INSTANCE, $Prm0.ImmSet);
      this.ConstraintStr = new std.string(JD$Move.INSTANCE, $Prm0.ConstraintStr);
      this.Name = new std.string(JD$Move.INSTANCE, $Prm0.Name);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::ConstraintInfo::~ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 586,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 553,
     FQN="clang::TargetInfo::ConstraintInfo::~ConstraintInfo", NM="_ZN5clang10TargetInfo14ConstraintInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo14ConstraintInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Name.$destroy();
      ConstraintStr.$destroy();
      ImmSet.$destroy();
      //END JDestroy
    }

    public ConstraintInfo() {
      this.ImmRange = new Unnamed_struct1();
      this.ImmSet = new SmallSetInt(4);
      this.ConstraintStr = new std.string();
      this.Name = new std.string();
    }
    
    @Override public ConstraintInfo clone() { 
      return new ConstraintInfo(this); 
    }
    
    public String toString() {
      return "" + "Flags=" + Flags // NOI18N
                + ", TiedOperand=" + TiedOperand // NOI18N
                + ", ImmRange=" + ImmRange // NOI18N
                + ", ImmSet=" + ImmSet // NOI18N
                + ", ConstraintStr=" + ConstraintStr // NOI18N
                + ", Name=" + Name; // NOI18N
    }
  };  
  
  /// \brief Validate register name used for global register variables.
  ///
  /// This function returns true if the register passed in RegName can be used
  /// for global register variables on this target. In addition, it returns
  /// true in HasSizeMismatch if the size of the register doesn't match the
  /// variable size passed in RegSize.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateGlobalRegisterVariable">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 686,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 653,
   FQN="clang::TargetInfo::validateGlobalRegisterVariable", NM="_ZNK5clang10TargetInfo30validateGlobalRegisterVariableEN4llvm9StringRefEjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo30validateGlobalRegisterVariableEN4llvm9StringRefEjRb")
  //</editor-fold>
  public /*virtual*/ boolean validateGlobalRegisterVariable(StringRef RegName, 
                                /*uint*/int RegSize, 
                                bool$ref/*bool &*/ HasSizeMismatch) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  // validateOutputConstraint, validateInputConstraint - Checks that
  // a constraint is valid and provides information about it.
  // FIXME: These should return a real error instead of just true/false.
  
  // validateOutputConstraint, validateInputConstraint - Checks that
  // a constraint is valid and provides information about it.
  // FIXME: These should return a real error instead of just true/false.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateOutputConstraint">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 442,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 434,
   FQN="clang::TargetInfo::validateOutputConstraint", NM="_ZNK5clang10TargetInfo24validateOutputConstraintERNS0_14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo24validateOutputConstraintERNS0_14ConstraintInfoE")
  //</editor-fold>
  public boolean validateOutputConstraint(ConstraintInfo /*&*/ Info) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateInputConstraint">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 534,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 526,
   FQN="clang::TargetInfo::validateInputConstraint", NM="_ZNK5clang10TargetInfo23validateInputConstraintEN4llvm15MutableArrayRefINS0_14ConstraintInfoEEERS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo23validateInputConstraintEN4llvm15MutableArrayRefINS0_14ConstraintInfoEEERS3_")
  //</editor-fold>
  public boolean validateInputConstraint(MutableArrayRef<ConstraintInfo> OutputConstraints, 
                         ConstraintInfo /*&*/ Info) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateOutputSize">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 700,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 667,
   FQN="clang::TargetInfo::validateOutputSize", NM="_ZNK5clang10TargetInfo18validateOutputSizeEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18validateOutputSizeEN4llvm9StringRefEj")
  //</editor-fold>
  public /*virtual*/ boolean validateOutputSize(StringRef $Prm0/*Constraint*/, 
                    /*uint*/int $Prm1/*Size*/) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateInputSize">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 705,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 672,
   FQN="clang::TargetInfo::validateInputSize", NM="_ZNK5clang10TargetInfo17validateInputSizeEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17validateInputSizeEN4llvm9StringRefEj")
  //</editor-fold>
  public /*virtual*/ boolean validateInputSize(StringRef $Prm0/*Constraint*/, 
                   /*uint*/int $Prm1/*Size*/) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateConstraintModifier">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 709,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 676,
   FQN="clang::TargetInfo::validateConstraintModifier", NM="_ZNK5clang10TargetInfo26validateConstraintModifierEN4llvm9StringRefEcjRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo26validateConstraintModifierEN4llvm9StringRefEcjRSs")
  //</editor-fold>
  public /*virtual*/ boolean validateConstraintModifier(StringRef $Prm0/*Constraint*/, 
                            /*char*/byte $Prm1/*Modifier*/, 
                            /*uint*/int $Prm2/*Size*/, 
                            std.string/*&*/ $Prm3/*SuggestedModifier*/) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 716,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 683,
   FQN="clang::TargetInfo::validateAsmConstraint", NM="_ZNK5clang10TargetInfo21validateAsmConstraintERPKcRNS0_14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo21validateAsmConstraintERPKcRNS0_14ConstraintInfoE")
  //</editor-fold>
  public abstract /*virtual*/ boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ info) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::resolveSymbolicName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 511,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 503,
   FQN="clang::TargetInfo::resolveSymbolicName", NM="_ZNK5clang10TargetInfo19resolveSymbolicNameERPKcN4llvm8ArrayRefINS0_14ConstraintInfoEEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo19resolveSymbolicNameERPKcN4llvm8ArrayRefINS0_14ConstraintInfoEEERj")
  //</editor-fold>
  public boolean resolveSymbolicName(char$ptr/*const char P &*/ Name, 
                     ArrayRef<ConstraintInfo> OutputConstraints, 
                     uint$ref/*uint &*/ Index) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  // Constraint parm will be left pointing at the last character of
  // the constraint.  In practice, it won't be changed unless the
  // constraint is longer than one character.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::convertConstraint">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 727,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 694,
   FQN="clang::TargetInfo::convertConstraint", NM="_ZNK5clang10TargetInfo17convertConstraintERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17convertConstraintERPKc")
  //</editor-fold>
  public /*virtual*/ std.string convertConstraint(char$ptr/*const char P &*/ Constraint) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Returns a string of target-specific clobbers, in LLVM format.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 735,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 702,
   FQN="clang::TargetInfo::getClobbers", NM="_ZNK5clang10TargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo11getClobbersEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/char$ptr/*char P*/ getClobbers() /*const*//* = 0*/;

  
  /// \brief Returns true if NaN encoding is IEEE 754-2008.
  /// Only MIPS allows a different encoding.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isNan2008">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 739,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 706,
   FQN="clang::TargetInfo::isNan2008", NM="_ZNK5clang10TargetInfo9isNan2008Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo9isNan2008Ev")
  //</editor-fold>
  public /*virtual*/ boolean isNan2008() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Returns the target triple of the primary target.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getTriple">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 744,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 711,
   FQN="clang::TargetInfo::getTriple", NM="_ZNK5clang10TargetInfo9getTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo9getTripleEv")
  //</editor-fold>
  public /*const*/ Triple /*&*/ getTriple() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getDataLayout">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 748,
   FQN="clang::TargetInfo::getDataLayout", NM="_ZNK5clang10TargetInfo13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::GCCRegAlias">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 753,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 720,
   FQN="clang::TargetInfo::GCCRegAlias", NM="_ZN5clang10TargetInfo11GCCRegAliasE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo11GCCRegAliasE")
  //</editor-fold>
  public static class/*struct*/ GCCRegAlias {
    public /*const*/char$ptr/*char P*//*const*/ Aliases[/*5*/] = new /*const*/char$ptr/*char P*//*const*/ [5];
    public /*const*/char$ptr/*char P*//*const*/ Register;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public GCCRegAlias(String[] Aliases, String Register) {
      this.Register = create_char$ptr(Register);
      int len = Math.min(this.Aliases.length, Aliases.length);
      for (int i = 0; i < len; i++) {
        this.Aliases[i] = create_char$ptr(Aliases[i]);
      }
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public GCCRegAlias(char$ptr[] Aliases, char$ptr Register) {
      this.Register = Register;
      copy$Object(Aliases, 0, this.Aliases, 0, Aliases.length);
    }
    
    public String toString() {
      return "" + "Aliases=" + Aliases // NOI18N
                + ", Register=" + Register; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::AddlRegName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 758,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 725,
   FQN="clang::TargetInfo::AddlRegName", NM="_ZN5clang10TargetInfo11AddlRegNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo11AddlRegNameE")
  //</editor-fold>
  public static class/*struct*/ AddlRegName {
    public /*const*/char$ptr/*char P*//*const*/ Names[/*5*/] = new /*const*/char$ptr/*char P*//*const*/ [5];
    public /*const*//*uint*/int RegNum;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public AddlRegName(String[] Names, int i) {
      int len = Math.min(this.Names.length, Names.length);
      for (int j = 0; j < len; j++) {
        this.Names[j] = create_char$ptr(Names[j]);
      }
      RegNum = i;
    }  
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public AddlRegName(char$ptr[] Names, int i) {
      copy$Object(Names, 0, this.Names, 0, Names.length);
      RegNum = i;
    }  
    
    public String toString() {
      return "" + "Names=" + Names // NOI18N
                + ", RegNum=" + RegNum; // NOI18N
    }
  };
  
  /// \brief Does this target support "protected" visibility?
  ///
  /// Any target which dynamic libraries will naturally support
  /// something like "default" (meaning that the symbol is visible
  /// outside this shared object) and "hidden" (meaning that it isn't)
  /// visibilities, but "protected" is really an ELF-specific concept
  /// with weird semantics designed around the convenience of dynamic
  /// linker implementations.  Which is not to suggest that there's
  /// consistent target-independent semantics for "default" visibility
  /// either; the entire thing is pretty badly mangled.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasProtectedVisibility">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 773,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 740,
   FQN="clang::TargetInfo::hasProtectedVisibility", NM="_ZNK5clang10TargetInfo22hasProtectedVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo22hasProtectedVisibilityEv")
  //</editor-fold>
  public /*virtual*/ boolean hasProtectedVisibility() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief An optional hook that targets can implement to perform semantic
  /// checking on attribute((section("foo"))) specifiers.
  ///
  /// In this case, "foo" is passed in to be checked.  If the section
  /// specifier is invalid, the backend should return a non-empty string
  /// that indicates the problem.
  ///
  /// This hook is a simple quality of implementation feature to catch errors
  /// and give good diagnostics in cases when the assembler or code generator
  /// would otherwise reject the section specifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isValidSectionSpecifier">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 786,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 753,
   FQN="clang::TargetInfo::isValidSectionSpecifier", NM="_ZNK5clang10TargetInfo23isValidSectionSpecifierEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo23isValidSectionSpecifierEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ std.string isValidSectionSpecifier(StringRef SR) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Set forced language options.
  ///
  /// Apply changes to the target information with respect to certain
  /// language options which change the target configuration.
  
  /// \brief Set forced language options.
  ///
  /// Apply changes to the target information with respect to certain
  /// language options which change the target configuration.
  
  /// adjust - Set forced language options.
  /// Apply changes to the target information with respect to certain
  /// language options which change the target configuration.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::adjust">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 278,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 274,
   FQN="clang::TargetInfo::adjust", NM="_ZN5clang10TargetInfo6adjustERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZN5clang10TargetInfo6adjustERKNS_11LangOptionsE")
  //</editor-fold>
  public void adjust(/*const*/ LangOptions /*&*/ Opts) {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Initialize the map with the default set of target features for the
  /// CPU this should include all legal feature strings on the target.
  ///
  /// \return False on error (invalid features).
  
  /// \brief Initialize the map with the default set of target features for the
  /// CPU this should include all legal feature strings on the target.
  ///
  /// \return False on error (invalid features).
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", line = 323,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp", old_line = 315,
   FQN="clang::TargetInfo::initFeatureMap", NM="_ZNK5clang10TargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERNS_17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp -nm=_ZNK5clang10TargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERNS_17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  public boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeatureVec) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }


  
  /// \brief Get the ABI currently in use.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getABI">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 805,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 772,
   FQN="clang::TargetInfo::getABI", NM="_ZNK5clang10TargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo6getABIEv")
  //</editor-fold>
  public /*virtual*/ StringRef getABI() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Get the C++ ABI currently in use.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getCXXABI">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 808,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 775,
   FQN="clang::TargetInfo::getCXXABI", NM="_ZNK5clang10TargetInfo9getCXXABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo9getCXXABIEv")
  //</editor-fold>
  public TargetCXXABI getCXXABI() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Target the specified CPU.
  ///
  /// \return  False on error (invalid CPU name).
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::setCPU">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 815,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 782,
   FQN="clang::TargetInfo::setCPU", NM="_ZN5clang10TargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo6setCPUERKSs")
  //</editor-fold>
  public /*virtual*/ boolean setCPU(/*const*/std.string/*&*/ Name) {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Use the specified ABI.
  ///
  /// \return False on error (invalid ABI name).
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::setABI">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 822,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 789,
   FQN="clang::TargetInfo::setABI", NM="_ZN5clang10TargetInfo6setABIERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo6setABIERKSs")
  //</editor-fold>
  public /*virtual*/ boolean setABI(/*const*/std.string/*&*/ Name) {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Use the specified unit for FP math.
  ///
  /// \return False on error (invalid unit name).
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::setFPMath">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 829,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 796,
   FQN="clang::TargetInfo::setFPMath", NM="_ZN5clang10TargetInfo9setFPMathEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo9setFPMathEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ boolean setFPMath(StringRef Name) {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Enable or disable a specific target feature;
  /// the feature name must be valid.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::setFeatureEnabled">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 835,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 802,
   FQN="clang::TargetInfo::setFeatureEnabled", NM="_ZNK5clang10TargetInfo17setFeatureEnabledERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17setFeatureEnabledERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb")
  //</editor-fold>
  public /*virtual*/ void setFeatureEnabled(StringMapBool/*&*/ Features, 
                   StringRef Name, 
                   boolean Enabled) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Perform initialization based on the user configured
  /// set of features (e.g., +sse4).
  ///
  /// The list is guaranteed to have at most one entry per feature.
  ///
  /// The target may modify the features list, to change which options are
  /// passed onwards to the backend.
  /// FIXME: This part should be fixed so that we can change handleTargetFeatures
  /// to merely a TargetInfo initialization routine.
  ///
  /// \return  False on error.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 852,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 819,
   FQN="clang::TargetInfo::handleTargetFeatures", NM="_ZN5clang10TargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public /*virtual*/ boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags) {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Determine whether the given target has the given feature.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 858,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 825,
   FQN="clang::TargetInfo::hasFeature", NM="_ZNK5clang10TargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ boolean hasFeature(StringRef Feature) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  // \brief Validate the contents of the __builtin_cpu_supports(const char*)
  // argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateCpuSupports">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 864,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 831,
   FQN="clang::TargetInfo::validateCpuSupports", NM="_ZNK5clang10TargetInfo19validateCpuSupportsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo19validateCpuSupportsEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ boolean validateCpuSupports(StringRef Name) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  // \brief Returns maximal number of args passed in registers.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getRegParmMax">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 867,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 834,
   FQN="clang::TargetInfo::getRegParmMax", NM="_ZNK5clang10TargetInfo13getRegParmMaxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo13getRegParmMaxEv")
  //</editor-fold>
  public /*uint*/int getRegParmMax() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Whether the target supports thread-local storage.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isTLSSupported">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 873,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 840,
   FQN="clang::TargetInfo::isTLSSupported", NM="_ZNK5clang10TargetInfo14isTLSSupportedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14isTLSSupportedEv")
  //</editor-fold>
  public boolean isTLSSupported() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the maximum alignment (in bits) of a TLS variable
  ///
  /// Gets the maximum alignment (in bits) of a TLS variable on this target.
  /// Returns zero if there is no such constraint.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getMaxTLSAlign">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 881,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 848,
   FQN="clang::TargetInfo::getMaxTLSAlign", NM="_ZNK5clang10TargetInfo14getMaxTLSAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getMaxTLSAlignEv")
  //</editor-fold>
  public /*ushort*/char getMaxTLSAlign() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Whether the target supports SEH __try.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isSEHTrySupported">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 886,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 853,
   FQN="clang::TargetInfo::isSEHTrySupported", NM="_ZNK5clang10TargetInfo17isSEHTrySupportedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo17isSEHTrySupportedEv")
  //</editor-fold>
  public boolean isSEHTrySupported() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return true if {|} are normal characters in the asm string.
  ///
  /// If this returns false (the default), then {abc|xyz} is syntax
  /// that says that when compiling for asm variant #0, "abc" should be
  /// generated, but when compiling for asm variant #1, "xyz" should be
  /// generated.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasNoAsmVariants">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 898,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 865,
   FQN="clang::TargetInfo::hasNoAsmVariants", NM="_ZNK5clang10TargetInfo16hasNoAsmVariantsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16hasNoAsmVariantsEv")
  //</editor-fold>
  public boolean hasNoAsmVariants() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the register number that __builtin_eh_return_regno would
  /// return with the specified argument.
  /// This corresponds with TargetLowering's getExceptionPointerRegister
  /// and getExceptionSelectorRegister in the backend.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 906,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 871,
   FQN="clang::TargetInfo::getEHDataRegisterNumber", NM="_ZNK5clang10TargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  public /*virtual*/ int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Return the section to use for C++ static initialization functions.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getStaticInitSectionSpecifier">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 911,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 876,
   FQN="clang::TargetInfo::getStaticInitSectionSpecifier", NM="_ZNK5clang10TargetInfo29getStaticInitSectionSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo29getStaticInitSectionSpecifierEv")
  //</editor-fold>
  public /*virtual*/ /*const*/char$ptr/*char P*/ getStaticInitSectionSpecifier() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getAddressSpaceMap">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 915,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 880,
   FQN="clang::TargetInfo::getAddressSpaceMap", NM="_ZNK5clang10TargetInfo18getAddressSpaceMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getAddressSpaceMapEv")
  //</editor-fold>
  public /*const*/LangAS.Map /*&*/ getAddressSpaceMap() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Retrieve the name of the platform as it is used in the
  /// availability attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPlatformName">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 921,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 886,
   FQN="clang::TargetInfo::getPlatformName", NM="_ZNK5clang10TargetInfo15getPlatformNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15getPlatformNameEv")
  //</editor-fold>
  public StringRef getPlatformName() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Retrieve the minimum desired version of the platform, to
  /// which the program should be compiled.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPlatformMinVersion">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 925,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 890,
   FQN="clang::TargetInfo::getPlatformMinVersion", NM="_ZNK5clang10TargetInfo21getPlatformMinVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo21getPlatformMinVersionEv")
  //</editor-fold>
  public VersionTuple getPlatformMinVersion() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::isBigEndian">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 927,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 892,
   FQN="clang::TargetInfo::isBigEndian", NM="_ZNK5clang10TargetInfo11isBigEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo11isBigEndianEv")
  //</editor-fold>
  public boolean isBigEndian() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::CallingConvMethodType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 929,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 894,
   FQN="clang::TargetInfo::CallingConvMethodType", NM="_ZN5clang10TargetInfo21CallingConvMethodTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo21CallingConvMethodTypeE")
  //</editor-fold>
  public enum CallingConvMethodType implements Native.ComparableLower {
    CCMT_Unknown(0),
    CCMT_Member(CCMT_Unknown.getValue() + 1),
    CCMT_NonMember(CCMT_Member.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CallingConvMethodType valueOf(int val) {
      CallingConvMethodType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CallingConvMethodType[] VALUES;
      private static final CallingConvMethodType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CallingConvMethodType kind : CallingConvMethodType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CallingConvMethodType[min < 0 ? (1-min) : 0];
        VALUES = new CallingConvMethodType[max >= 0 ? (1+max) : 0];
        for (CallingConvMethodType kind : CallingConvMethodType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CallingConvMethodType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CallingConvMethodType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CallingConvMethodType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Gets the default calling convention for the given target and
  /// declaration context.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getDefaultCallingConv">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 937,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 902,
   FQN="clang::TargetInfo::getDefaultCallingConv", NM="_ZNK5clang10TargetInfo21getDefaultCallingConvENS0_21CallingConvMethodTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo21getDefaultCallingConvENS0_21CallingConvMethodTypeE")
  //</editor-fold>
  public /*virtual*/ CallingConv getDefaultCallingConv(CallingConvMethodType MT) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::CallingConvCheckResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 944,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 909,
   FQN="clang::TargetInfo::CallingConvCheckResult", NM="_ZN5clang10TargetInfo22CallingConvCheckResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo22CallingConvCheckResultE")
  //</editor-fold>
  public enum CallingConvCheckResult implements Native.ComparableLower {
    CCCR_OK(0),
    CCCR_Warning(CCCR_OK.getValue() + 1),
    CCCR_Ignore(CCCR_Warning.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CallingConvCheckResult valueOf(int val) {
      CallingConvCheckResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CallingConvCheckResult[] VALUES;
      private static final CallingConvCheckResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CallingConvCheckResult kind : CallingConvCheckResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CallingConvCheckResult[min < 0 ? (1-min) : 0];
        VALUES = new CallingConvCheckResult[max >= 0 ? (1+max) : 0];
        for (CallingConvCheckResult kind : CallingConvCheckResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CallingConvCheckResult(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CallingConvCheckResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CallingConvCheckResult)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Determines whether a given calling convention is valid for the
  /// target. A calling convention can either be accepted, produce a warning
  /// and be substituted with the default calling convention, or (someday)
  /// produce an error (such as using thiscall on a non-instance function).
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 954,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 919,
   FQN="clang::TargetInfo::checkCallingConvention", NM="_ZNK5clang10TargetInfo22checkCallingConventionENS_11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo22checkCallingConventionENS_11CallingConvE")
  //</editor-fold>
  public /*virtual*/ CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// Controls if __builtin_longjmp / __builtin_setjmp can be lowered to
  /// llvm.eh.sjlj.longjmp / llvm.eh.sjlj.setjmp.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::hasSjLjLowering">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 965,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 930,
   FQN="clang::TargetInfo::hasSjLjLowering", NM="_ZNK5clang10TargetInfo15hasSjLjLoweringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15hasSjLjLoweringEv")
  //</editor-fold>
  public /*virtual*/ boolean hasSjLjLowering() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Whether target allows to overalign ABI-specified prefered alignment
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::allowsLargerPreferedTypeAlignment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 970,
   FQN="clang::TargetInfo::allowsLargerPreferedTypeAlignment", NM="_ZNK5clang10TargetInfo33allowsLargerPreferedTypeAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo33allowsLargerPreferedTypeAlignmentEv")
  //</editor-fold>
  public /*virtual*/ boolean allowsLargerPreferedTypeAlignment() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Set supported OpenCL extensions and optional core features.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::setSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 973,
   FQN="clang::TargetInfo::setSupportedOpenCLOpts", NM="_ZN5clang10TargetInfo22setSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo22setSupportedOpenCLOptsEv")
  //</editor-fold>
  public /*virtual*/ void setSupportedOpenCLOpts() {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Get supported OpenCL extensions and optional core features.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 976,
   FQN="clang::TargetInfo::getSupportedOpenCLOpts", NM="_ZN5clang10TargetInfo22getSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang10TargetInfo22getSupportedOpenCLOptsEv")
  //</editor-fold>
  public OpenCLOptions /*&*/ getSupportedOpenCLOpts() {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Get const supported OpenCL extensions and optional core features.
  ////<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 981,
   FQN="clang::TargetInfo::getSupportedOpenCLOpts", NM="_ZNK5clang10TargetInfo22getSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo22getSupportedOpenCLOptsEv")
  //</editor-fold>
  public /*const*/ OpenCLOptions /*&*/ getSupportedOpenCLOpts$Const() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  
  /// \brief Check the target is valid after it is fully initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::validateTarget">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 986,
   FQN="clang::TargetInfo::validateTarget", NM="_ZNK5clang10TargetInfo14validateTargetERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14validateTargetERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public /*virtual*/ boolean validateTarget(DiagnosticsEngine /*&*/ Diags) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPointerWidthV">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 991,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 935,
   FQN="clang::TargetInfo::getPointerWidthV", NM="_ZNK5clang10TargetInfo16getPointerWidthVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getPointerWidthVEj")
  //</editor-fold>
  protected /*virtual*/ long/*uint64_t*/ getPointerWidthV(/*uint*/int AddrSpace) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPointerAlignV">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 994,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 938,
   FQN="clang::TargetInfo::getPointerAlignV", NM="_ZNK5clang10TargetInfo16getPointerAlignVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getPointerAlignVEj")
  //</editor-fold>
  protected /*virtual*/ long/*uint64_t*/ getPointerAlignV(/*uint*/int AddrSpace) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getPtrDiffTypeV">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 997,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 941,
   FQN="clang::TargetInfo::getPtrDiffTypeV", NM="_ZNK5clang10TargetInfo15getPtrDiffTypeVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo15getPtrDiffTypeVEj")
  //</editor-fold>
  protected /*virtual*/  IntType getPtrDiffTypeV(/*uint*/int AddrSpace) /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 1000,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 944,
   FQN="clang::TargetInfo::getGCCRegNames", NM="_ZNK5clang10TargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  protected abstract /*virtual*/ ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 1001,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 945,
   FQN="clang::TargetInfo::getGCCRegAliases", NM="_ZNK5clang10TargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  protected abstract /*virtual*/ ArrayRef<GCCRegAlias> getGCCRegAliases() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::TargetInfo::getGCCAddlRegNames">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", line = 1002,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetInfo.h", old_line = 946,
   FQN="clang::TargetInfo::getGCCAddlRegNames", NM="_ZNK5clang10TargetInfo18getGCCAddlRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZNK5clang10TargetInfo18getGCCAddlRegNamesEv")
  //</editor-fold>
  protected /*virtual*/ ArrayRef<AddlRegName> getGCCAddlRegNames() /*const*/ {
    throw new UnsupportedOperationException("Why not overridden?");
  }
}
