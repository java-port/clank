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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;



/// \brief Flags to identify the types for overloaded Neon builtins.
///
/// These must be kept in sync with the flags in utils/TableGen/NeonEmitter.h.
//<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 99,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 98,
 FQN="clang::NeonTypeFlags", NM="_ZN5clang13NeonTypeFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsE")
//</editor-fold>
public class NeonTypeFlags {
  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 99,
   FQN="clang::NeonTypeFlags::(anonymous)", NM="_ZN5clang13NeonTypeFlagsE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int EltTypeMask = 0xf;
    public static final /*uint*/int UnsignedFlag = 0x10;
    public static final /*uint*/int QuadFlag = 0x20;
  /*}*/;
  private /*uint32_t*/int Flags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::EltType">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 107,
   FQN="clang::NeonTypeFlags::EltType", NM="_ZN5clang13NeonTypeFlags7EltTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlags7EltTypeE")
  //</editor-fold>
  public enum EltType implements Native.ComparableLower {
    Int8(0),
    Int16(Int8.getValue() + 1),
    Int32(Int16.getValue() + 1),
    Int64(Int32.getValue() + 1),
    Poly8(Int64.getValue() + 1),
    Poly16(Poly8.getValue() + 1),
    Poly64(Poly16.getValue() + 1),
    Poly128(Poly64.getValue() + 1),
    Float16(Poly128.getValue() + 1),
    Float32(Float16.getValue() + 1),
    Float64(Float32.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EltType valueOf(int val) {
      EltType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final EltType[] VALUES;
      private static final EltType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EltType kind : EltType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EltType[min < 0 ? (1-min) : 0];
        VALUES = new EltType[max >= 0 ? (1+max) : 0];
        for (EltType kind : EltType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private EltType(int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EltType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EltType)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::NeonTypeFlags">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 121,
   FQN="clang::NeonTypeFlags::NeonTypeFlags", NM="_ZN5clang13NeonTypeFlagsC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsC1Ej")
  //</editor-fold>
  public NeonTypeFlags(/*uint*/int F) {
    /* : Flags(F)*/ 
    //START JInit
    this.Flags = F;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::NeonTypeFlags">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 122,
   FQN="clang::NeonTypeFlags::NeonTypeFlags", NM="_ZN5clang13NeonTypeFlagsC1ENS0_7EltTypeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsC1ENS0_7EltTypeEbb")
  //</editor-fold>
  public NeonTypeFlags(EltType ET, boolean IsUnsigned, boolean IsQuad) {
    /* : Flags(ET)*/ 
    //START JInit
    this.Flags = ET.getValue();
    //END JInit
    if (IsUnsigned) {
      Flags |= UnsignedFlag;
    }
    if (IsQuad) {
      Flags |= QuadFlag;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::getEltType">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 129,
   FQN="clang::NeonTypeFlags::getEltType", NM="_ZNK5clang13NeonTypeFlags10getEltTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZNK5clang13NeonTypeFlags10getEltTypeEv")
  //</editor-fold>
  public EltType getEltType() /*const*/ {
    return EltType.valueOf((Flags & EltTypeMask));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::isPoly">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 131,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 130,
   FQN="clang::NeonTypeFlags::isPoly", NM="_ZNK5clang13NeonTypeFlags6isPolyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZNK5clang13NeonTypeFlags6isPolyEv")
  //</editor-fold>
  public boolean isPoly() /*const*/ {
    EltType ET = getEltType();
    return ET == EltType.Poly8 || ET == EltType.Poly16;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 134,
   FQN="clang::NeonTypeFlags::isUnsigned", NM="_ZNK5clang13NeonTypeFlags10isUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZNK5clang13NeonTypeFlags10isUnsignedEv")
  //</editor-fold>
  public boolean isUnsigned() /*const*/ {
    return (Flags & UnsignedFlag) != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::isQuad">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 135,
   FQN="clang::NeonTypeFlags::isQuad", NM="_ZNK5clang13NeonTypeFlags6isQuadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZNK5clang13NeonTypeFlags6isQuadEv")
  //</editor-fold>
  public boolean isQuad() /*const*/ {
    return (Flags & QuadFlag) != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::NeonTypeFlags">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 98,
   FQN="clang::NeonTypeFlags::NeonTypeFlags", NM="_ZN5clang13NeonTypeFlagsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ NeonTypeFlags(/*const*/ NeonTypeFlags /*&*/ $Prm0) {
    /* : Flags(.Flags)*/ 
    //START JInit
    this.Flags = $Prm0.Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::NeonTypeFlags">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 98,
   FQN="clang::NeonTypeFlags::NeonTypeFlags", NM="_ZN5clang13NeonTypeFlagsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsC1EOS0_")
  //</editor-fold>
  public /*inline*/ NeonTypeFlags(JD$Move _dparam, NeonTypeFlags /*&&*/$Prm0) {
    /* : Flags(static_cast<NeonTypeFlags &&>().Flags)*/ 
    //START JInit
    this.Flags = $Prm0.Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NeonTypeFlags::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", old_line = 98,
   FQN="clang::NeonTypeFlags::operator=", NM="_ZN5clang13NeonTypeFlagsaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang13NeonTypeFlagsaSEOS0_")
  //</editor-fold>
  public /*inline*/ NeonTypeFlags /*&*/ $assignMove(NeonTypeFlags /*&&*/$Prm0) {
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "Flags=" + Flags; // NOI18N
  }
}
