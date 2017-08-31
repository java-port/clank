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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.impl.TypePrinterStatics.*;
import org.clank.support.Native.NativePOD;


/// The collection of all-type qualifiers we support.
/// Clang supports five independent qualifiers:
/// * C99: const, volatile, and restrict
/// * MS: __unaligned
/// * Embedded C (TR18037): address spaces
/// * Objective C: the GC attributes (none, weak, or strong)
//<editor-fold defaultstate="collapsed" desc="clang::Qualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 117,
 FQN="clang::Qualifiers", NM="_ZN5clang10QualifiersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersE")
//</editor-fold>
public class Qualifiers implements Native.NativeComparable<Qualifiers>, Native.Native$Bool, NativePOD<Qualifiers> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::TQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 119,
   FQN="clang::Qualifiers::TQ", NM="_ZN5clang10Qualifiers2TQE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers2TQE")
  //</editor-fold>
  public static final class/*enum*/ TQ {
    // NOTE: These flags must be kept in sync with DeclSpec::TQ.
    public static final /*uint*/int Const = 0x1;
    public static final /*uint*/int Restrict = 0x2;
    public static final /*uint*/int Volatile = 0x4;
    public static final /*uint*/int CVRMask = TQ.Const | TQ.Volatile | TQ.Restrict;
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::GC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 126,
   FQN="clang::Qualifiers::GC", NM="_ZN5clang10Qualifiers2GCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers2GCE")
  //</editor-fold>
  public enum GC implements Native.ComparableLower, Native.NativeUIntEnum {
    GCNone(0),
    Weak(GCNone.getValue() + 1),
    Strong(Weak.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static GC valueOf(int val) {
      GC out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final GC[] VALUES;
      private static final GC[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (GC kind : GC.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new GC[min < 0 ? (1-min) : 0];
        VALUES = new GC[max >= 0 ? (1+max) : 0];
        for (GC kind : GC.values()) {
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
    private GC(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((GC)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((GC)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::ObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 132,
   FQN="clang::Qualifiers::ObjCLifetime", NM="_ZN5clang10Qualifiers12ObjCLifetimeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers12ObjCLifetimeE")
  //</editor-fold>
  public enum ObjCLifetime implements Native.ComparableLower, Native.NativeUIntEnum {
    /// There is no lifetime qualification on this type.
    OCL_None(0),
    
    /// This object can be modified without requiring retains or
    /// releases.
    OCL_ExplicitNone(OCL_None.getValue() + 1),
    
    /// Assigning into this object requires the old value to be
    /// released and the new value to be retained.  The timing of the
    /// release of the old value is inexact: it may be moved to
    /// immediately after the last known point where the value is
    /// live.
    OCL_Strong(OCL_ExplicitNone.getValue() + 1),
    
    /// Reading or writing from this object requires a barrier call.
    OCL_Weak(OCL_Strong.getValue() + 1),
    
    /// Assigning into this object requires a lifetime extension.
    OCL_Autoreleasing(OCL_Weak.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ObjCLifetime valueOf(int val) {
      ObjCLifetime out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ObjCLifetime[] VALUES;
      private static final ObjCLifetime[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ObjCLifetime kind : ObjCLifetime.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ObjCLifetime[min < 0 ? (1-min) : 0];
        VALUES = new ObjCLifetime[max >= 0 ? (1+max) : 0];
        for (ObjCLifetime kind : ObjCLifetime.values()) {
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
    private ObjCLifetime(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ObjCLifetime)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ObjCLifetime)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 154,
   FQN="clang::Qualifiers::(anonymous)", NM="_ZN5clang10QualifiersE_Unnamed_enum3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersE_Unnamed_enum3")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// The maximum supported address space number.
    /// 23 bits should be enough for anyone.
    public static final /*uint*/int MaxAddressSpace = 0x7fffff/*U*/;
    
    /// The width of the "fast" qualifier mask.
    public static final /*uint*/int FastWidth = 3;
    
    /// The fast qualifier mask.
    public static final /*uint*/int FastMask = (1 << FastWidth) - 1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::Qualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 166,
   FQN="clang::Qualifiers::Qualifiers", NM="_ZN5clang10QualifiersC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersC1Ev")
  //</editor-fold>
  public Qualifiers() {
    // : Mask(0) 
    //START JInit
    this.Mask = 0;
    //END JInit
  }

  
  /// Returns the common set of qualifiers while removing them from
  /// the given sets.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeCommonQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 170,
   FQN="clang::Qualifiers::removeCommonQualifiers", NM="_ZN5clang10Qualifiers22removeCommonQualifiersERS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers22removeCommonQualifiersERS0_S1_")
  //</editor-fold>
  public static Qualifiers removeCommonQualifiers(final Qualifiers /*&*/ L, final Qualifiers /*&*/ R) {
    // If both are only CVR-qualified, bit operations are sufficient.
    if (!((L.Mask & ~TQ.CVRMask) != 0) && !((R.Mask & ~TQ.CVRMask) != 0)) {
      Qualifiers Q/*J*/= new Qualifiers();
      Q.Mask = L.Mask & R.Mask;
      L.Mask &= ~Q.Mask;
      R.Mask &= ~Q.Mask;
      return Q;
    }
    
    Qualifiers Q/*J*/= new Qualifiers();
    /*uint*/int CommonCRV = L.getCVRQualifiers() & R.getCVRQualifiers();
    Q.addCVRQualifiers(CommonCRV);
    L.removeCVRQualifiers(CommonCRV);
    R.removeCVRQualifiers(CommonCRV);
    if (L.getObjCGCAttr() == R.getObjCGCAttr()) {
      Q.setObjCGCAttr(L.getObjCGCAttr());
      L.removeObjCGCAttr();
      R.removeObjCGCAttr();
    }
    if (L.getObjCLifetime() == R.getObjCLifetime()) {
      Q.setObjCLifetime(L.getObjCLifetime());
      L.removeObjCLifetime();
      R.removeObjCLifetime();
    }
    if (L.getAddressSpace() == R.getAddressSpace()) {
      Q.setAddressSpace(L.getAddressSpace());
      L.removeAddressSpace();
      R.removeAddressSpace();
    }
    return Q;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::fromFastMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 206,
   FQN="clang::Qualifiers::fromFastMask", NM="_ZN5clang10Qualifiers12fromFastMaskEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers12fromFastMaskEj")
  //</editor-fold>
  public static Qualifiers fromFastMask(/*uint*/int Mask) {
    Qualifiers Qs/*J*/= new Qualifiers();
    Qs.addFastQualifiers(Mask);
    return Qs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::fromCVRMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 212,
   FQN="clang::Qualifiers::fromCVRMask", NM="_ZN5clang10Qualifiers11fromCVRMaskEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers11fromCVRMaskEj")
  //</editor-fold>
  public static Qualifiers fromCVRMask(/*uint*/int CVR) {
    Qualifiers Qs/*J*/= new Qualifiers();
    Qs.addCVRQualifiers(CVR);
    return Qs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::fromCVRUMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 218,
   FQN="clang::Qualifiers::fromCVRUMask", NM="_ZN5clang10Qualifiers12fromCVRUMaskEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers12fromCVRUMaskEj")
  //</editor-fold>
  public static Qualifiers fromCVRUMask(/*uint*/int CVRU) {
    Qualifiers Qs/*J*/= new Qualifiers();
    Qs.addCVRUQualifiers(CVRU);
    return Qs;
  }

  
  // Deserialize qualifiers from an opaque representation.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::fromOpaqueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 225,
   FQN="clang::Qualifiers::fromOpaqueValue", NM="_ZN5clang10Qualifiers15fromOpaqueValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers15fromOpaqueValueEj")
  //</editor-fold>
  public static Qualifiers fromOpaqueValue(/*uint*/int opaque) {
    Qualifiers Qs/*J*/= new Qualifiers();
    Qs.Mask = opaque;
    return Qs;
  }

  
  // Serialize these qualifiers into an opaque representation.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getAsOpaqueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 232,
   FQN="clang::Qualifiers::getAsOpaqueValue", NM="_ZNK5clang10Qualifiers16getAsOpaqueValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers16getAsOpaqueValueEv")
  //</editor-fold>
  public /*uint*/int getAsOpaqueValue() /*const*/ {
    return Mask;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 236,
   FQN="clang::Qualifiers::hasConst", NM="_ZNK5clang10Qualifiers8hasConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers8hasConstEv")
  //</editor-fold>
  public boolean hasConst() /*const*/ {
    return ((Mask & TQ.Const) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 237,
   FQN="clang::Qualifiers::setConst", NM="_ZN5clang10Qualifiers8setConstEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers8setConstEb")
  //</editor-fold>
  public void setConst(boolean flag) {
    Mask = (Mask & ~TQ.Const) | (flag ? TQ.Const : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 240,
   FQN="clang::Qualifiers::removeConst", NM="_ZN5clang10Qualifiers11removeConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers11removeConstEv")
  //</editor-fold>
  public void removeConst() {
    Mask &= ~TQ.Const;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 241,
   FQN="clang::Qualifiers::addConst", NM="_ZN5clang10Qualifiers8addConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers8addConstEv")
  //</editor-fold>
  public void addConst() {
    Mask |= TQ.Const;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 243,
   FQN="clang::Qualifiers::hasVolatile", NM="_ZNK5clang10Qualifiers11hasVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers11hasVolatileEv")
  //</editor-fold>
  public boolean hasVolatile() /*const*/ {
    return ((Mask & TQ.Volatile) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 244,
   FQN="clang::Qualifiers::setVolatile", NM="_ZN5clang10Qualifiers11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean flag) {
    Mask = (Mask & ~TQ.Volatile) | (flag ? TQ.Volatile : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 247,
   FQN="clang::Qualifiers::removeVolatile", NM="_ZN5clang10Qualifiers14removeVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers14removeVolatileEv")
  //</editor-fold>
  public void removeVolatile() {
    Mask &= ~TQ.Volatile;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 248,
   FQN="clang::Qualifiers::addVolatile", NM="_ZN5clang10Qualifiers11addVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers11addVolatileEv")
  //</editor-fold>
  public void addVolatile() {
    Mask |= TQ.Volatile;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 250,
   FQN="clang::Qualifiers::hasRestrict", NM="_ZNK5clang10Qualifiers11hasRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers11hasRestrictEv")
  //</editor-fold>
  public boolean hasRestrict() /*const*/ {
    return ((Mask & TQ.Restrict) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 251,
   FQN="clang::Qualifiers::setRestrict", NM="_ZN5clang10Qualifiers11setRestrictEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers11setRestrictEb")
  //</editor-fold>
  public void setRestrict(boolean flag) {
    Mask = (Mask & ~TQ.Restrict) | (flag ? TQ.Restrict : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 254,
   FQN="clang::Qualifiers::removeRestrict", NM="_ZN5clang10Qualifiers14removeRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers14removeRestrictEv")
  //</editor-fold>
  public void removeRestrict() {
    Mask &= ~TQ.Restrict;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 255,
   FQN="clang::Qualifiers::addRestrict", NM="_ZN5clang10Qualifiers11addRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers11addRestrictEv")
  //</editor-fold>
  public void addRestrict() {
    Mask |= TQ.Restrict;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 257,
   FQN="clang::Qualifiers::hasCVRQualifiers", NM="_ZNK5clang10Qualifiers16hasCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers16hasCVRQualifiersEv")
  //</editor-fold>
  public boolean hasCVRQualifiers() /*const*/ {
    return (getCVRQualifiers() != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 258,
   FQN="clang::Qualifiers::getCVRQualifiers", NM="_ZNK5clang10Qualifiers16getCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers16getCVRQualifiersEv")
  //</editor-fold>
  public /*uint*/int getCVRQualifiers() /*const*/ {
    return Mask & TQ.CVRMask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 259,
   FQN="clang::Qualifiers::setCVRQualifiers", NM="_ZN5clang10Qualifiers16setCVRQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers16setCVRQualifiersEj")
  //</editor-fold>
  public void setCVRQualifiers(/*uint*/int mask) {
    assert (!((mask & ~TQ.CVRMask) != 0)) : "bitmask contains non-CVR bits";
    Mask = (Mask & ~TQ.CVRMask) | mask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 263,
   FQN="clang::Qualifiers::removeCVRQualifiers", NM="_ZN5clang10Qualifiers19removeCVRQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers19removeCVRQualifiersEj")
  //</editor-fold>
  public void removeCVRQualifiers(/*uint*/int mask) {
    assert (!((mask & ~TQ.CVRMask) != 0)) : "bitmask contains non-CVR bits";
    Mask &= ~mask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 267,
   FQN="clang::Qualifiers::removeCVRQualifiers", NM="_ZN5clang10Qualifiers19removeCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers19removeCVRQualifiersEv")
  //</editor-fold>
  public void removeCVRQualifiers() {
    removeCVRQualifiers(TQ.CVRMask);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 270,
   FQN="clang::Qualifiers::addCVRQualifiers", NM="_ZN5clang10Qualifiers16addCVRQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers16addCVRQualifiersEj")
  //</editor-fold>
  public void addCVRQualifiers(/*uint*/int mask) {
    assert (!((mask & ~TQ.CVRMask) != 0)) : "bitmask contains non-CVR bits";
    Mask |= mask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addCVRUQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 274,
   FQN="clang::Qualifiers::addCVRUQualifiers", NM="_ZN5clang10Qualifiers17addCVRUQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers17addCVRUQualifiersEj")
  //</editor-fold>
  public void addCVRUQualifiers(/*uint*/int mask) {
    assert (!((mask & ~TQ.CVRMask & ~UMask) != 0)) : "bitmask contains non-CVRU bits";
    Mask |= mask;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasUnaligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 279,
   FQN="clang::Qualifiers::hasUnaligned", NM="_ZNK5clang10Qualifiers12hasUnalignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers12hasUnalignedEv")
  //</editor-fold>
  public boolean hasUnaligned() /*const*/ {
    return ((Mask & UMask) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setUnaligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 280,
   FQN="clang::Qualifiers::setUnaligned", NM="_ZN5clang10Qualifiers12setUnalignedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers12setUnalignedEb")
  //</editor-fold>
  public void setUnaligned(boolean flag) {
    Mask = (Mask & ~UMask) | (flag ? UMask : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeUnaligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 283,
   FQN="clang::Qualifiers::removeUnaligned", NM="_ZN5clang10Qualifiers15removeUnalignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers15removeUnalignedEv")
  //</editor-fold>
  public void removeUnaligned() {
    Mask &= ~UMask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addUnaligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 284,
   FQN="clang::Qualifiers::addUnaligned", NM="_ZN5clang10Qualifiers12addUnalignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers12addUnalignedEv")
  //</editor-fold>
  public void addUnaligned() {
    Mask |= UMask;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 286,
   FQN="clang::Qualifiers::hasObjCGCAttr", NM="_ZNK5clang10Qualifiers13hasObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers13hasObjCGCAttrEv")
  //</editor-fold>
  public boolean hasObjCGCAttr() /*const*/ {
    return ((Mask & GCAttrMask) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 287,
   FQN="clang::Qualifiers::getObjCGCAttr", NM="_ZNK5clang10Qualifiers13getObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers13getObjCGCAttrEv")
  //</editor-fold>
  public GC getObjCGCAttr() /*const*/ {
    return GC.valueOf((Mask & GCAttrMask) >>> GCAttrShift);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 288,
   FQN="clang::Qualifiers::setObjCGCAttr", NM="_ZN5clang10Qualifiers13setObjCGCAttrENS0_2GCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers13setObjCGCAttrENS0_2GCE")
  //</editor-fold>
  public void setObjCGCAttr(GC type) {
    Mask = (Mask & ~GCAttrMask) | (type.getValue() << GCAttrShift);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 291,
   FQN="clang::Qualifiers::removeObjCGCAttr", NM="_ZN5clang10Qualifiers16removeObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers16removeObjCGCAttrEv")
  //</editor-fold>
  public void removeObjCGCAttr() {
    setObjCGCAttr(GC.GCNone);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 292,
   FQN="clang::Qualifiers::addObjCGCAttr", NM="_ZN5clang10Qualifiers13addObjCGCAttrENS0_2GCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers13addObjCGCAttrENS0_2GCE")
  //</editor-fold>
  public void addObjCGCAttr(GC type) {
    assert Native.$bool(type);
    setObjCGCAttr(type);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::withoutObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 296,
   FQN="clang::Qualifiers::withoutObjCGCAttr", NM="_ZNK5clang10Qualifiers17withoutObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers17withoutObjCGCAttrEv")
  //</editor-fold>
  public Qualifiers withoutObjCGCAttr() /*const*/ {
    Qualifiers qs = new Qualifiers(/*Deref*/this);
    qs.removeObjCGCAttr();
    return qs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::withoutObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 301,
   FQN="clang::Qualifiers::withoutObjCLifetime", NM="_ZNK5clang10Qualifiers19withoutObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers19withoutObjCLifetimeEv")
  //</editor-fold>
  public Qualifiers withoutObjCLifetime() /*const*/ {
    Qualifiers qs = new Qualifiers(/*Deref*/this);
    qs.removeObjCLifetime();
    return qs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 307,
   FQN="clang::Qualifiers::hasObjCLifetime", NM="_ZNK5clang10Qualifiers15hasObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers15hasObjCLifetimeEv")
  //</editor-fold>
  public boolean hasObjCLifetime() /*const*/ {
    return ((Mask & LifetimeMask) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 308,
   FQN="clang::Qualifiers::getObjCLifetime", NM="_ZNK5clang10Qualifiers15getObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers15getObjCLifetimeEv")
  //</editor-fold>
  public ObjCLifetime getObjCLifetime() /*const*/ {
    return ObjCLifetime.valueOf((Mask & LifetimeMask) >>> LifetimeShift);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 311,
   FQN="clang::Qualifiers::setObjCLifetime", NM="_ZN5clang10Qualifiers15setObjCLifetimeENS0_12ObjCLifetimeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers15setObjCLifetimeENS0_12ObjCLifetimeE")
  //</editor-fold>
  public void setObjCLifetime(ObjCLifetime type) {
    Mask = (Mask & ~LifetimeMask) | (type.getValue() << LifetimeShift);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 314,
   FQN="clang::Qualifiers::removeObjCLifetime", NM="_ZN5clang10Qualifiers18removeObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers18removeObjCLifetimeEv")
  //</editor-fold>
  public void removeObjCLifetime() {
    setObjCLifetime(ObjCLifetime.OCL_None);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 315,
   FQN="clang::Qualifiers::addObjCLifetime", NM="_ZN5clang10Qualifiers15addObjCLifetimeENS0_12ObjCLifetimeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers15addObjCLifetimeENS0_12ObjCLifetimeE")
  //</editor-fold>
  public void addObjCLifetime(ObjCLifetime type) {
    assert Native.$bool(type);
    assert (!hasObjCLifetime());
    Mask |= (type.getValue() << LifetimeShift);
  }

  
  /// True if the lifetime is neither None or ExplicitNone.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasNonTrivialObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 322,
   FQN="clang::Qualifiers::hasNonTrivialObjCLifetime", NM="_ZNK5clang10Qualifiers25hasNonTrivialObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers25hasNonTrivialObjCLifetimeEv")
  //</editor-fold>
  public boolean hasNonTrivialObjCLifetime() /*const*/ {
    ObjCLifetime lifetime = getObjCLifetime();
    return (lifetime.getValue() > ObjCLifetime.OCL_ExplicitNone.getValue());
  }

  
  /// True if the lifetime is either strong or weak.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasStrongOrWeakObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 328,
   FQN="clang::Qualifiers::hasStrongOrWeakObjCLifetime", NM="_ZNK5clang10Qualifiers27hasStrongOrWeakObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers27hasStrongOrWeakObjCLifetimeEv")
  //</editor-fold>
  public boolean hasStrongOrWeakObjCLifetime() /*const*/ {
    ObjCLifetime lifetime = getObjCLifetime();
    return (lifetime == ObjCLifetime.OCL_Strong || lifetime == ObjCLifetime.OCL_Weak);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 333,
   FQN="clang::Qualifiers::hasAddressSpace", NM="_ZNK5clang10Qualifiers15hasAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers15hasAddressSpaceEv")
  //</editor-fold>
  public boolean hasAddressSpace() /*const*/ {
    return ((Mask & AddressSpaceMask) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 334,
   FQN="clang::Qualifiers::getAddressSpace", NM="_ZNK5clang10Qualifiers15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers15getAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getAddressSpace() /*const*/ {
    return Mask >>> AddressSpaceShift;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 335,
   FQN="clang::Qualifiers::setAddressSpace", NM="_ZN5clang10Qualifiers15setAddressSpaceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers15setAddressSpaceEj")
  //</editor-fold>
  public void setAddressSpace(/*uint*/int space) {
    assert ($lesseq_uint(space, MaxAddressSpace));
    Mask = (Mask & ~AddressSpaceMask)
       | (((/*uint32_t*/int)space) << AddressSpaceShift);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 340,
   FQN="clang::Qualifiers::removeAddressSpace", NM="_ZN5clang10Qualifiers18removeAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers18removeAddressSpaceEv")
  //</editor-fold>
  public void removeAddressSpace() {
    setAddressSpace(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 341,
   FQN="clang::Qualifiers::addAddressSpace", NM="_ZN5clang10Qualifiers15addAddressSpaceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers15addAddressSpaceEj")
  //</editor-fold>
  public void addAddressSpace(/*uint*/int space) {
    assert Native.$bool(space);
    setAddressSpace(space);
  }

  
  // Fast qualifiers are those that can be allocated directly
  // on a QualType object.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 348,
   FQN="clang::Qualifiers::hasFastQualifiers", NM="_ZNK5clang10Qualifiers17hasFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers17hasFastQualifiersEv")
  //</editor-fold>
  public boolean hasFastQualifiers() /*const*/ {
    return (getFastQualifiers() != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 349,
   FQN="clang::Qualifiers::getFastQualifiers", NM="_ZNK5clang10Qualifiers17getFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers17getFastQualifiersEv")
  //</editor-fold>
  public /*uint*/int getFastQualifiers() /*const*/ {
    return Mask & FastMask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::setFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 350,
   FQN="clang::Qualifiers::setFastQualifiers", NM="_ZN5clang10Qualifiers17setFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers17setFastQualifiersEj")
  //</editor-fold>
  public void setFastQualifiers(/*uint*/int mask) {
    assert (!((mask & ~FastMask) != 0)) : "bitmask contains non-fast qualifier bits";
    Mask = (Mask & ~FastMask) | mask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 354,
   FQN="clang::Qualifiers::removeFastQualifiers", NM="_ZN5clang10Qualifiers20removeFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers20removeFastQualifiersEj")
  //</editor-fold>
  public void removeFastQualifiers(/*uint*/int mask) {
    assert (!((mask & ~FastMask) != 0)) : "bitmask contains non-fast qualifier bits";
    Mask &= ~mask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 358,
   FQN="clang::Qualifiers::removeFastQualifiers", NM="_ZN5clang10Qualifiers20removeFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers20removeFastQualifiersEv")
  //</editor-fold>
  public void removeFastQualifiers() {
    removeFastQualifiers(FastMask);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 361,
   FQN="clang::Qualifiers::addFastQualifiers", NM="_ZN5clang10Qualifiers17addFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers17addFastQualifiersEj")
  //</editor-fold>
  public void addFastQualifiers(/*uint*/int mask) {
    assert (!((mask & ~FastMask) != 0)) : "bitmask contains non-fast qualifier bits";
    Mask |= mask;
  }

  
  /// Return true if the set contains any qualifiers which require an ExtQuals
  /// node to be allocated.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasNonFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 368,
   FQN="clang::Qualifiers::hasNonFastQualifiers", NM="_ZNK5clang10Qualifiers20hasNonFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers20hasNonFastQualifiersEv")
  //</editor-fold>
  public boolean hasNonFastQualifiers() /*const*/ {
    return ((Mask & ~FastMask) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getNonFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 369,
   FQN="clang::Qualifiers::getNonFastQualifiers", NM="_ZNK5clang10Qualifiers20getNonFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers20getNonFastQualifiersEv")
  //</editor-fold>
  public Qualifiers getNonFastQualifiers() /*const*/ {
    Qualifiers Quals = new Qualifiers(/*Deref*/this);
    Quals.setFastQualifiers(0);
    return Quals;
  }

  
  /// Return true if the set contains any qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::hasQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 376,
   FQN="clang::Qualifiers::hasQualifiers", NM="_ZNK5clang10Qualifiers13hasQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers13hasQualifiersEv")
  //</editor-fold>
  public boolean hasQualifiers() /*const*/ {
    return (Mask != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 377,
   FQN="clang::Qualifiers::empty", NM="_ZNK5clang10Qualifiers5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return !(Mask != 0);
  }

  
  /// Add the qualifiers from the given set to this set.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 380,
   FQN="clang::Qualifiers::addQualifiers", NM="_ZN5clang10Qualifiers13addQualifiersES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers13addQualifiersES0_")
  //</editor-fold>
  public void addQualifiers(Qualifiers Q) {
    // If the other set doesn't have any non-boolean qualifiers, just
    // bit-or it in.
    if (!((Q.Mask & ~TQ.CVRMask) != 0)) {
      Mask |= Q.Mask;
    } else {
      Mask |= (Q.Mask & TQ.CVRMask);
      if (Q.hasAddressSpace()) {
        addAddressSpace(Q.getAddressSpace());
      }
      if (Q.hasObjCGCAttr()) {
        addObjCGCAttr(Q.getObjCGCAttr());
      }
      if (Q.hasObjCLifetime()) {
        addObjCLifetime(Q.getObjCLifetime());
      }
    }
  }

  
  /// \brief Remove the qualifiers from the given set from this set.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::removeQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 397,
   FQN="clang::Qualifiers::removeQualifiers", NM="_ZN5clang10Qualifiers16removeQualifiersES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers16removeQualifiersES0_")
  //</editor-fold>
  public void removeQualifiers(Qualifiers Q) {
    // If the other set doesn't have any non-boolean qualifiers, just
    // bit-and the inverse in.
    if (!((Q.Mask & ~TQ.CVRMask) != 0)) {
      Mask &= ~Q.Mask;
    } else {
      Mask &= ~(Q.Mask & TQ.CVRMask);
      if (getObjCGCAttr() == Q.getObjCGCAttr()) {
        removeObjCGCAttr();
      }
      if (getObjCLifetime() == Q.getObjCLifetime()) {
        removeObjCLifetime();
      }
      if (getAddressSpace() == Q.getAddressSpace()) {
        removeAddressSpace();
      }
    }
  }

  
  /// Add the qualifiers from the given set to this set, given that
  /// they don't conflict.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::addConsistentQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 415,
   FQN="clang::Qualifiers::addConsistentQualifiers", NM="_ZN5clang10Qualifiers23addConsistentQualifiersES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10Qualifiers23addConsistentQualifiersES0_")
  //</editor-fold>
  public void addConsistentQualifiers(Qualifiers qs) {
    assert (getAddressSpace() == qs.getAddressSpace() || !hasAddressSpace() || !qs.hasAddressSpace());
    assert (getObjCGCAttr() == qs.getObjCGCAttr() || !hasObjCGCAttr() || !qs.hasObjCGCAttr());
    assert (getObjCLifetime() == qs.getObjCLifetime() || !hasObjCLifetime() || !qs.hasObjCLifetime());
    Mask |= qs.Mask;
  }

  
  /// Returns true if this address space is a superset of the other one.
  /// OpenCL v2.0 defines conversion rules (OpenCLC v2.0 s6.5.5) and notion of
  /// overlapping address spaces.
  /// CL1.1 or CL1.2:
  ///   every address space is a superset of itself.
  /// CL2.0 adds:
  ///   __generic is a superset of any address space except for __constant.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::isAddressSpaceSupersetOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 432,
   FQN="clang::Qualifiers::isAddressSpaceSupersetOf", NM="_ZNK5clang10Qualifiers24isAddressSpaceSupersetOfES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers24isAddressSpaceSupersetOfES0_")
  //</editor-fold>
  public boolean isAddressSpaceSupersetOf(Qualifiers other) /*const*/ {
    return // Address spaces must match exactly.
        getAddressSpace() == other.getAddressSpace()
      // Otherwise in OpenCLC v2.0 s6.5.5: every address space except
      // for __constant can be used as __generic.
       || (getAddressSpace() == LangAS.ID.opencl_generic
       && other.getAddressSpace() != LangAS.ID.opencl_constant);
  }

  
  /// Determines if these qualifiers compatibly include another set.
  /// Generally this answers the question of whether an object with the other
  /// qualifiers can be safely used as an object with these qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::compatiblyIncludes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 445,
   FQN="clang::Qualifiers::compatiblyIncludes", NM="_ZNK5clang10Qualifiers18compatiblyIncludesES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers18compatiblyIncludesES0_")
  //</editor-fold>
  public boolean compatiblyIncludes(Qualifiers other) /*const*/ {
    return isAddressSpaceSupersetOf(new Qualifiers(other))
      // ObjC GC qualifiers can match, be added, or be removed, but can't
      // be changed.
       && (getObjCGCAttr() == other.getObjCGCAttr() || !hasObjCGCAttr()
       || !other.hasObjCGCAttr())
      // ObjC lifetime qualifiers must match exactly.
       && getObjCLifetime() == other.getObjCLifetime()
      // CVR qualifiers may subset.
       && (((Mask & TQ.CVRMask) | (other.Mask & TQ.CVRMask)) == (Mask & TQ.CVRMask))
      // U qualifier may superset.
       && (!other.hasUnaligned() || hasUnaligned());
  }

  
  /// \brief Determines if these qualifiers compatibly include another set of
  /// qualifiers from the narrow perspective of Objective-C ARC lifetime.
  ///
  /// One set of Objective-C lifetime qualifiers compatibly includes the other
  /// if the lifetime qualifiers match, or if both are non-__weak and the
  /// including set also contains the 'const' qualifier, or both are non-__weak
  /// and one is None (which can only happen in non-ARC modes).
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::compatiblyIncludesObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 466,
   FQN="clang::Qualifiers::compatiblyIncludesObjCLifetime", NM="_ZNK5clang10Qualifiers30compatiblyIncludesObjCLifetimeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers30compatiblyIncludesObjCLifetimeES0_")
  //</editor-fold>
  public boolean compatiblyIncludesObjCLifetime(Qualifiers other) /*const*/ {
    if (getObjCLifetime() == other.getObjCLifetime()) {
      return true;
    }
    if (getObjCLifetime() == ObjCLifetime.OCL_Weak || other.getObjCLifetime() == ObjCLifetime.OCL_Weak) {
      return false;
    }
    if (getObjCLifetime() == ObjCLifetime.OCL_None || other.getObjCLifetime() == ObjCLifetime.OCL_None) {
      return true;
    }
    
    return hasConst();
  }

  
  /// \brief Determine whether this set of qualifiers is a strict superset of
  /// another set of qualifiers, not considering qualifier compatibility.
  
  /// \brief Determine whether this set of qualifiers is a strict superset of
  /// another set of qualifiers, not considering qualifier compatibility.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::isStrictSupersetOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 32,
   FQN="clang::Qualifiers::isStrictSupersetOf", NM="_ZNK5clang10Qualifiers18isStrictSupersetOfES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10Qualifiers18isStrictSupersetOfES0_")
  //</editor-fold>
  public boolean isStrictSupersetOf(Qualifiers Other) /*const*/ {
    return (/*Deref*/this.$noteq(/*NO_COPY*/Other))
      // CVR qualifiers superset
       && (((Mask & TQ.CVRMask) | (Other.Mask & TQ.CVRMask)) == (Mask & TQ.CVRMask))
      // ObjC GC qualifiers superset
       && ((getObjCGCAttr() == Other.getObjCGCAttr())
       || (hasObjCGCAttr() && !Other.hasObjCGCAttr()))
      // Address space superset.
       && ((getAddressSpace() == Other.getAddressSpace())
       || (hasAddressSpace() && !Other.hasAddressSpace()))
      // Lifetime qualifier superset.
       && ((getObjCLifetime() == Other.getObjCLifetime())
       || (hasObjCLifetime() && !Other.hasObjCLifetime()));
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 483,
   FQN="clang::Qualifiers::operator==", NM="_ZNK5clang10QualifierseqES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10QualifierseqES0_")
  //</editor-fold>
  public boolean $eq(Qualifiers Other) /*const*/ {
    return Mask == Other.Mask;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 484,
   FQN="clang::Qualifiers::operator!=", NM="_ZNK5clang10QualifiersneES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10QualifiersneES0_")
  //</editor-fold>
  public boolean $noteq(Qualifiers Other) /*const*/ {
    return Mask != Other.Mask;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 486,
   FQN="clang::Qualifiers::operator bool", NM="_ZNK5clang10QualifierscvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10QualifierscvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return hasQualifiers();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator+=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 488,
   FQN="clang::Qualifiers::operator+=", NM="_ZN5clang10QualifierspLES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifierspLES0_")
  //</editor-fold>
  public Qualifiers /*&*/ $addassign(Qualifiers R) {
    addQualifiers(new Qualifiers(R));
    return /*Deref*/this;
  }

  
  // Union two qualifier sets.  If an enumerated qualifier appears
  // in both sets, use the one from the right.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 495,
   FQN="clang::operator+", NM="_ZN5clangplENS_10QualifiersES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clangplENS_10QualifiersES0_")
  //</editor-fold>
  public static Qualifiers $add_Qualifiers(Qualifiers L, Qualifiers R) {
    L.$addassign(/*NO_COPY*/R);
    return new Qualifiers(JD$Move.INSTANCE, L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 500,
   FQN="clang::Qualifiers::operator-=", NM="_ZN5clang10QualifiersmIES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersmIES0_")
  //</editor-fold>
  public Qualifiers /*&*/ $minusassign(Qualifiers R) {
    removeQualifiers(new Qualifiers(R));
    return /*Deref*/this;
  }

  
  /// \brief Compute the difference between two qualifier sets.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 506,
   FQN="clang::operator-", NM="_ZN5clangmiENS_10QualifiersES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clangmiENS_10QualifiersES0_")
  //</editor-fold>
  public static Qualifiers $sub_Qualifiers(Qualifiers L, Qualifiers R) {
    L.$minusassign(/*NO_COPY*/R);
    return new Qualifiers(JD$Move.INSTANCE, L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1537,
   FQN="clang::Qualifiers::getAsString", NM="_ZNK5clang10Qualifiers11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZNK5clang10Qualifiers11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    LangOptions LO/*J*/= new LangOptions();
    return getAsString(new PrintingPolicy(LO));
  }


  
  // Appends qualifiers to the given string, separated by spaces.  Will
  // prefix a space if the string is non-empty.  Will not append a final
  // space.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1545,
   FQN="clang::Qualifiers::getAsString", NM="_ZNK5clang10Qualifiers11getAsStringERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZNK5clang10Qualifiers11getAsStringERKNS_14PrintingPolicyE")
  //</editor-fold>
  public std.string getAsString(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    raw_svector_ostream StrOS = null;
    try {
      SmallString/*64*/ Buf/*J*/= new SmallString/*64*/(64);
      StrOS/*J*/= new raw_svector_ostream(Buf);
      print(StrOS, Policy);
      return StrOS.str().$string();
    } finally {
      if (StrOS != null) { StrOS.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::isEmptyWhenPrinted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1552,
   FQN="clang::Qualifiers::isEmptyWhenPrinted", NM="_ZNK5clang10Qualifiers18isEmptyWhenPrintedERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZNK5clang10Qualifiers18isEmptyWhenPrintedERKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean isEmptyWhenPrinted(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    if ((getCVRQualifiers() != 0)) {
      return false;
    }
    if ((getAddressSpace() != 0)) {
      return false;
    }
    if ((getObjCGCAttr().getValue() != 0)) {
      return false;
    }
    {
      
      Qualifiers.ObjCLifetime lifetime = getObjCLifetime();
      if ((lifetime.getValue() != 0)) {
        if (!(lifetime == Qualifiers.ObjCLifetime.OCL_Strong && Policy.SuppressStrongLifetime)) {
          return false;
        }
      }
    }
    
    return true;
  }


  
  // Appends qualifiers to the given string, separated by spaces.  Will
  // prefix a space if the string is non-empty.  Will not append a final
  // space.
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1572,
   FQN="clang::Qualifiers::print", NM="_ZNK5clang10Qualifiers5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZNK5clang10Qualifiers5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    print(OS, Policy, 
       false);
  }
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, 
       boolean appendSpaceIfNonEmpty/*= false*/) /*const*/ {
    boolean addSpace = false;
    
    /*uint*/int quals = getCVRQualifiers();
    if ((quals != 0)) {
      AppendTypeQualList(OS, quals, Policy.Restrict);
      addSpace = true;
    }
    if (hasUnaligned()) {
      if (addSpace) {
        OS.$out_char($$SPACE);
      }
      OS.$out(/*KEEP_STR*/$__unaligned);
      addSpace = true;
    }
    {
      /*uint*/int addrspace = getAddressSpace();
      if ((addrspace != 0)) {
        if (addSpace) {
          OS.$out_char($$SPACE);
        }
        addSpace = true;
        switch (addrspace) {
         case LangAS.ID.opencl_global:
          OS.$out(/*KEEP_STR*/$__global);
          break;
         case LangAS.ID.opencl_local:
          OS.$out(/*KEEP_STR*/$__local);
          break;
         case LangAS.ID.opencl_constant:
          OS.$out(/*KEEP_STR*/$__constant);
          break;
         case LangAS.ID.opencl_generic:
          OS.$out(/*KEEP_STR*/$__generic);
          break;
         default:
          OS.$out(/*KEEP_STR*/"__attribute__((address_space(");
          OS.$out_uint(addrspace);
          OS.$out(/*KEEP_STR*/")))");
        }
      }
    }
    {
      Qualifiers.GC gc = getObjCGCAttr();
      if ((gc.getValue() != 0)) {
        if (addSpace) {
          OS.$out_char($$SPACE);
        }
        addSpace = true;
        if (gc == Qualifiers.GC.Weak) {
          OS.$out(/*KEEP_STR*/"__weak");
        } else {
          OS.$out(/*KEEP_STR*/"__strong");
        }
      }
    }
    {
      Qualifiers.ObjCLifetime lifetime = getObjCLifetime();
      if ((lifetime.getValue() != 0)) {
        if (!(lifetime == Qualifiers.ObjCLifetime.OCL_Strong && Policy.SuppressStrongLifetime)) {
          if (addSpace) {
            OS.$out_char($$SPACE);
          }
          addSpace = true;
        }
        switch (lifetime) {
         case OCL_None:
          throw new llvm_unreachable("none but true");
         case OCL_ExplicitNone:
          OS.$out(/*KEEP_STR*/"__unsafe_unretained");
          break;
         case OCL_Strong:
          if (!Policy.SuppressStrongLifetime) {
            OS.$out(/*KEEP_STR*/"__strong");
          }
          break;
         case OCL_Weak:
          OS.$out(/*KEEP_STR*/"__weak");
          break;
         case OCL_Autoreleasing:
          OS.$out(/*KEEP_STR*/"__autoreleasing");
          break;
        }
      }
    }
    if (appendSpaceIfNonEmpty && addSpace) {
      OS.$out_char($$SPACE);
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 518,
   FQN="clang::Qualifiers::Profile", NM="_ZNK5clang10Qualifiers7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK5clang10Qualifiers7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint(Mask);
  }

/*private:*/
  
  // bits:     |0 1 2|3|4 .. 5|6  ..  8|9   ...   31|
  //           |C R V|U|GCAttr|Lifetime|AddressSpace|
  private /*uint32_t*/int Mask;
  
  private static /*const*//*uint32_t*/int UMask = 0x8;
  private static /*const*//*uint32_t*/int UShift = 3;
  private static /*const*//*uint32_t*/int GCAttrMask = 0x30;
  private static /*const*//*uint32_t*/int GCAttrShift = 4;
  private static /*const*//*uint32_t*/int LifetimeMask = 0x1C0;
  private static /*const*//*uint32_t*/int LifetimeShift = 6;
  private static /*const*//*uint32_t*/int AddressSpaceMask = ~(TQ.CVRMask | UMask | GCAttrMask | LifetimeMask);
  private static /*const*//*uint32_t*/int AddressSpaceShift = 9;
  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::Qualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 117,
   FQN="clang::Qualifiers::Qualifiers", NM="_ZN5clang10QualifiersC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Qualifiers(final /*const*/ Qualifiers /*&*/ $Prm0) {
    // : Mask(.Mask) 
    //START JInit
    this.Mask = $Prm0.Mask;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::Qualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 117,
   FQN="clang::Qualifiers::Qualifiers", NM="_ZN5clang10QualifiersC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersC1EOS0_")
  //</editor-fold>
  public /*inline*/ Qualifiers(JD$Move _dparam, final Qualifiers /*&&*/$Prm0) {
    // : Mask(static_cast<Qualifiers &&>().Mask) 
    //START JInit
    this.Mask = $Prm0.Mask;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 117,
   FQN="clang::Qualifiers::operator=", NM="_ZN5clang10QualifiersaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersaSERKS0_")
  //</editor-fold>
  public /*inline*/ Qualifiers /*&*/ $assign(final /*const*/ Qualifiers /*&*/ $Prm0) {
    this.Mask = $Prm0.Mask;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Qualifiers::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 117,
   FQN="clang::Qualifiers::operator=", NM="_ZN5clang10QualifiersaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang10QualifiersaSEOS0_")
  //</editor-fold>
  public /*inline*/ Qualifiers /*&*/ $assignMove(final Qualifiers /*&&*/$Prm0) {
    this.Mask = $Prm0.Mask;
    return /*Deref*/this;
  }

  @Override public Qualifiers clone() { return new Qualifiers(this); }
  
  @Override public String toString() {
    return "" + "Mask=" + Integer.toBinaryString(Mask); // NOI18N
  }
}
