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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// ValueTypes are data types that can actually be held in registers.
/// All variables and expressions must have a value type.
/// Pointer types are further subdivided into the various heap-allocated
/// types, such as functions, records, etc.
/// Structured types that are passed by value (e.g. complex numbers)
/// require special handling; they use BT_ValueRef, and size ST_0.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 131,
 FQN="clang::threadSafety::til::ValueType", NM="_ZN5clang12threadSafety3til9ValueTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueTypeE")
//</editor-fold>
public class/*struct*/ ValueType {
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::BaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 132,
   FQN="clang::threadSafety::til::ValueType::BaseType", NM="_ZN5clang12threadSafety3til9ValueType8BaseTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType8BaseTypeE")
  //</editor-fold>
  public enum BaseType/* : unsigned char*/ implements Native.ComparableLower {
    BT_Void($int2uchar(0)),
    BT_Bool(BT_Void.getValue() + 1),
    BT_Int(BT_Bool.getValue() + 1),
    BT_Float(BT_Int.getValue() + 1),
    BT_String(BT_Float.getValue() + 1), // String literals
    BT_Pointer(BT_String.getValue() + 1),
    BT_ValueRef(BT_Pointer.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BaseType valueOf(/*uchar*/byte val) {
      BaseType out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static BaseType valueOf(int val) {
      BaseType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BaseType[] VALUES;
      private static final BaseType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BaseType kind : BaseType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BaseType[min < 0 ? (1-min) : 0];
        VALUES = new BaseType[max >= 0 ? (1+max) : 0];
        for (BaseType kind : BaseType.values()) {
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

    private final /*uchar*/byte value;
    private BaseType(int val) { this.value = (/*uchar*/byte)val;}
    public /*uchar*/byte getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uchar(value, ((BaseType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uchar(value, ((BaseType)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::SizeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 142,
   FQN="clang::threadSafety::til::ValueType::SizeType", NM="_ZN5clang12threadSafety3til9ValueType8SizeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType8SizeTypeE")
  //</editor-fold>
  public enum SizeType/* : unsigned char*/ implements Native.ComparableLower {
    ST_0($int2uchar(0)),
    ST_1(ST_0.getValue() + 1),
    ST_8(ST_1.getValue() + 1),
    ST_16(ST_8.getValue() + 1),
    ST_32(ST_16.getValue() + 1),
    ST_64(ST_32.getValue() + 1),
    ST_128(ST_64.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SizeType valueOf(/*uchar*/byte val) {
      SizeType out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static SizeType valueOf(int val) {
      SizeType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SizeType[] VALUES;
      private static final SizeType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SizeType kind : SizeType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SizeType[min < 0 ? (1-min) : 0];
        VALUES = new SizeType[max >= 0 ? (1+max) : 0];
        for (SizeType kind : SizeType.values()) {
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

    private final /*uchar*/byte value;
    private SizeType(int val) { this.value = (/*uchar*/byte)val;}
    public /*uchar*/byte getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uchar(value, ((SizeType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uchar(value, ((SizeType)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getSizeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 168,
   FQN="clang::threadSafety::til::ValueType::getSizeType", NM="_ZN5clang12threadSafety3til9ValueType11getSizeTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType11getSizeTypeEj")
  //</editor-fold>
  public static /*inline*/ ValueType.SizeType getSizeType(/*uint*/int nbytes) {
    switch (nbytes) {
     case 1:
      return SizeType.ST_8;
     case 2:
      return SizeType.ST_16;
     case 4:
      return SizeType.ST_32;
     case 8:
      return SizeType.ST_64;
     case 16:
      return SizeType.ST_128;
     default:
      return SizeType.ST_0;
    }
  }

  
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 155,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="Tpl__ZN5clang12threadSafety3til9ValueType12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til9ValueType12getValueTypeEv")
  //</editor-fold>
  public static /*inline*/ </*class*/ T> ValueType getValueType() {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::ValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 157,
   FQN="clang::threadSafety::til::ValueType::ValueType", NM="_ZN5clang12threadSafety3til9ValueTypeC1ENS2_8BaseTypeENS2_8SizeTypeEbh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueTypeC1ENS2_8BaseTypeENS2_8SizeTypeEbh")
  //</editor-fold>
  public ValueType(BaseType B, SizeType Sz, boolean S, /*uchar*/byte VS) {
    // : Base(B), Size(Sz), Signed(S), VectSize(VS) 
    //START JInit
    this.Base = B;
    this.Size = Sz;
    this.Signed = S;
    this.VectSize = VS;
    //END JInit
  }

  
  public BaseType Base;
  public SizeType Size;
  public boolean Signed;
  public /*uchar*/byte VectSize; // 0 for scalar, otherwise num elements in vector
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::ValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 131,
   FQN="clang::threadSafety::til::ValueType::ValueType", NM="_ZN5clang12threadSafety3til9ValueTypeC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueTypeC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ValueType(final /*const*/ ValueType /*&*/ $Prm0) {
    // : Base(.Base), Size(.Size), Signed(.Signed), VectSize(.VectSize) 
    //START JInit
    this.Base = $Prm0.Base;
    this.Size = $Prm0.Size;
    this.Signed = $Prm0.Signed;
    this.VectSize = $Prm0.VectSize;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::ValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 131,
   FQN="clang::threadSafety::til::ValueType::ValueType", NM="_ZN5clang12threadSafety3til9ValueTypeC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueTypeC1EOS2_")
  //</editor-fold>
  public /*inline*/ ValueType(JD$Move _dparam, final ValueType /*&&*/$Prm0) {
    // : Base(static_cast<ValueType &&>().Base), Size(static_cast<ValueType &&>().Size), Signed(static_cast<ValueType &&>().Signed), VectSize(static_cast<ValueType &&>().VectSize) 
    //START JInit
    this.Base = $Prm0.Base;
    this.Size = $Prm0.Size;
    this.Signed = $Prm0.Signed;
    this.VectSize = $Prm0.VectSize;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 180,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIvEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIvEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Void() {
    return new ValueType(BaseType.BT_Void, SizeType.ST_0, false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 185,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIbEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIbEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Bool() {
    return new ValueType(BaseType.BT_Bool, SizeType.ST_1, false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 190,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIcEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIcEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Char() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_8, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 195,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIhEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIhEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$UChar() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_8, false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 200,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIsEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIsEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Short() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_16, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 205,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeItEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeItEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$UShort() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_16, false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 210,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIiEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIiEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Int() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_32, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 215,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIjEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIjEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$UInt() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_32, false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 220,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIxEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIxEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$LLong() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_64, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 225,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIyEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIyEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$ULLong() {
    return new ValueType(BaseType.BT_Int, SizeType.ST_64, false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 230,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIfEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIfEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Float() {
    return new ValueType(BaseType.BT_Float, SizeType.ST_32, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 235,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIdEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIdEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$Double() {
    return new ValueType(BaseType.BT_Float, SizeType.ST_64, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 240,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIeEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIeEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$LDouble() {
    return new ValueType(BaseType.BT_Float, SizeType.ST_128, true, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 245,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIN4llvm9StringRefEEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIN4llvm9StringRefEEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$StringRef() {
    if (true) throw new UnsupportedOperationException("getValueType$StringRef");
    // JAVA: what is the correct value to pass?
    return new ValueType(BaseType.BT_String, getSizeType($sizeof_ptr()/*$sizeof_StringRef()*/), false, $int2uchar(0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ValueType::getValueType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 250,
   FQN="clang::threadSafety::til::ValueType::getValueType", NM="_ZN5clang12threadSafety3til9ValueType12getValueTypeIPvEES2_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9ValueType12getValueTypeIPvEES2_v")
  //</editor-fold>
  public static /*inline*/ ValueType getValueType$VoidPtr() {
    if (true) throw new UnsupportedOperationException("getValueType$VoidPtr");
    // JAVA: what is the correct value to pass?
    return new ValueType(BaseType.BT_Pointer, getSizeType($sizeof_ptr(/*Object */)), false, $int2uchar(0));
  }

  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", Size=" + Size // NOI18N
              + ", Signed=" + Signed // NOI18N
              + ", VectSize=" + $uchar2uint(VectSize); // NOI18N
  }
}
