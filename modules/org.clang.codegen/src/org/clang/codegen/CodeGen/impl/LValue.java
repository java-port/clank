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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// LValue - This represents an lvalue references.  Because C/C++ allow
/// bitfields, this is not a simple LLVM pointer, it may be a pointer plus a
/// bitrange.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 152,
 FQN="clang::CodeGen::LValue", NM="_ZN5clang7CodeGen6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueE")
//</editor-fold>
public class LValue implements NativeCloneable<LValue>, NativeMoveable<LValue> {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 153,
   FQN="clang::CodeGen::LValue::(anonymous)", NM="_ZN5clang7CodeGen6LValueE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.NativeUIntEnum {
    Simple(0), // This is a normal l-value, use getAddress().
    VectorElt(Simple.getValue() + 1), // This is a vector element l-value (V[i]), use getVector*
    BitField(VectorElt.getValue() + 1), // This is a bitfield l-value, use getBitfield*.
    ExtVectorElt(BitField.getValue() + 1), // This is an extended vector subset, use getExtVectorComp
    GlobalReg(ExtVectorElt.getValue() + 1); // This is a register l-value, use getGlobalReg()

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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private Unnamed_enum LVType;
  
  private Value /*P*/ V;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 163,
   FQN="clang::CodeGen::LValue::(anonymous)", NM="_ZN5clang7CodeGen6LValueE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    // Index into a vector subscript: V[i]
    public Value /*P*/ VectorIdx;
    
    // ExtVector element subset: V.xyx
    public Constant /*P*/ VectorElts;
    
    // BitField start bit and size
    public /*const*/ CGBitFieldInfo /*P*/ BitFieldInfo;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 163,
     FQN="clang::CodeGen::LValue::(anonymous union)::", NM="_ZN5clang7CodeGen6LValueUt0_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueUt0_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 163,
     FQN="clang::CodeGen::LValue::(anonymous union)::", NM="_ZN5clang7CodeGen6LValueUt0_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueUt0_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 163,
     FQN="clang::CodeGen::LValue::(anonymous union)::operator=", NM="_ZN5clang7CodeGen6LValueUt0_aSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueUt0_aSERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
      
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 163,
     FQN="clang::CodeGen::LValue::(anonymous union)::operator=", NM="_ZN5clang7CodeGen6LValueUt0_aSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueUt0_aSEOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
      
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Unnamed_union1() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "VectorIdx=" + VectorIdx // NOI18N
                + ", VectorElts=" + VectorElts // NOI18N
                + ", BitFieldInfo=" + BitFieldInfo; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field2 = new Unnamed_union1();
  
  private QualType Type;
  
  // 'const' is unused here
  private Qualifiers Quals;
  
  // The alignment to use when accessing this lvalue.  (For vector elements,
  // this is the alignment of the whole vector.)
  private long/*int64_t*/ Alignment;
  
  // objective-c's ivar
  private /*JBIT bool*/ boolean Ivar /*: 1*/;
  
  // objective-c's ivar is an array
  private /*JBIT bool*/ boolean ObjIsArray /*: 1*/;
  
  // LValue is non-gc'able for any reason, including being a parameter or local
  // variable.
  private /*JBIT bool*/ boolean NonGC /*: 1*/;
  
  // Lvalue is a global reference of an objective-c object
  private /*JBIT bool*/ boolean GlobalObjCRef /*: 1*/;
  
  // Lvalue is a thread local reference
  private /*JBIT bool*/ boolean ThreadLocalRef /*: 1*/;
  
  // Lvalue has ARC imprecise lifetime.  We store this inverted to try
  // to make the default bitfield pattern all-zeroes.
  private /*JBIT bool*/ boolean ImpreciseLifetime /*: 1*/;
  
  private /*JBYTE unsigned int*/ byte AlignSource /*: 2*/;
  
  // This flag shows if a nontemporal load/stores should be used when accessing
  // this lvalue.
  private /*JBIT bool*/ boolean Nontemporal /*: 1*/;
  
  private Expr /*P*/ BaseIvarExp;
  
  /// Used by struct-path-aware TBAA.
  private QualType TBAABaseType;
  /// Offset relative to the base type.
  private long/*uint64_t*/ TBAAOffset;
  
  /// TBAAInfo - TBAA information to attach to dereferences of this LValue.
  private MDNode /*P*/ TBAAInfo;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::Initialize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 220,
   FQN="clang::CodeGen::LValue::Initialize", NM="_ZN5clang7CodeGen6LValue10InitializeENS_8QualTypeENS_10QualifiersENS_9CharUnitsENS0_15AlignmentSourceEPN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue10InitializeENS_8QualTypeENS_10QualifiersENS_9CharUnitsENS0_15AlignmentSourceEPN4llvm6MDNodeE")
  //</editor-fold>
  private void Initialize(QualType Type, Qualifiers Quals, 
            CharUnits Alignment, AlignmentSource AlignSource) {
    Initialize(Type, Quals, 
            Alignment, AlignSource, 
            (MDNode /*P*/ )null);
  }
  private void Initialize(QualType Type, Qualifiers Quals, 
            CharUnits Alignment, AlignmentSource AlignSource, 
            MDNode /*P*/ TBAAInfo/*= null*/) {
    assert ((!Alignment.isZero() || Type.$arrow().isIncompleteType())) : "initializing l-value with zero alignment!";
    this.Type.$assign(Type);
    this.Quals.$assign(Quals);
    this.Alignment = Alignment.getQuantity();
    assert (this.Alignment == Alignment.getQuantity()) : "Alignment exceeds allowed max!";
    this.AlignSource = $uint2uint_2bits(((/*uint*/int)(AlignSource.getValue())));
    
    // Initialize Objective-C flags.
    this.Ivar = this.ObjIsArray = this.NonGC = this.GlobalObjCRef = false;
    this.ImpreciseLifetime = false;
    this.Nontemporal = false;
    this.ThreadLocalRef = false;
    this.BaseIvarExp = null;
    
    // Initialize fields for TBAA.
    this.TBAABaseType.$assign(Type);
    this.TBAAOffset = $int2ulong(0);
    this.TBAAInfo = TBAAInfo;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 246,
   FQN="clang::CodeGen::LValue::isSimple", NM="_ZNK5clang7CodeGen6LValue8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    return LVType == Unnamed_enum.Simple;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isVectorElt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 247,
   FQN="clang::CodeGen::LValue::isVectorElt", NM="_ZNK5clang7CodeGen6LValue11isVectorEltEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue11isVectorEltEv")
  //</editor-fold>
  public boolean isVectorElt() /*const*/ {
    return LVType == Unnamed_enum.VectorElt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 248,
   FQN="clang::CodeGen::LValue::isBitField", NM="_ZNK5clang7CodeGen6LValue10isBitFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue10isBitFieldEv")
  //</editor-fold>
  public boolean isBitField() /*const*/ {
    return LVType == Unnamed_enum.BitField;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isExtVectorElt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 249,
   FQN="clang::CodeGen::LValue::isExtVectorElt", NM="_ZNK5clang7CodeGen6LValue14isExtVectorEltEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue14isExtVectorEltEv")
  //</editor-fold>
  public boolean isExtVectorElt() /*const*/ {
    return LVType == Unnamed_enum.ExtVectorElt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isGlobalReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 250,
   FQN="clang::CodeGen::LValue::isGlobalReg", NM="_ZNK5clang7CodeGen6LValue11isGlobalRegEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue11isGlobalRegEv")
  //</editor-fold>
  public boolean isGlobalReg() /*const*/ {
    return LVType == Unnamed_enum.GlobalReg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isVolatileQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 252,
   FQN="clang::CodeGen::LValue::isVolatileQualified", NM="_ZNK5clang7CodeGen6LValue19isVolatileQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue19isVolatileQualifiedEv")
  //</editor-fold>
  public boolean isVolatileQualified() /*const*/ {
    return Quals.hasVolatile();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isRestrictQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 253,
   FQN="clang::CodeGen::LValue::isRestrictQualified", NM="_ZNK5clang7CodeGen6LValue19isRestrictQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue19isRestrictQualifiedEv")
  //</editor-fold>
  public boolean isRestrictQualified() /*const*/ {
    return Quals.hasRestrict();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 254,
   FQN="clang::CodeGen::LValue::getVRQualifiers", NM="_ZNK5clang7CodeGen6LValue15getVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue15getVRQualifiersEv")
  //</editor-fold>
  public /*uint*/int getVRQualifiers() /*const*/ {
    return Quals.getCVRQualifiers() & ~Qualifiers.TQ.Const;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 258,
   FQN="clang::CodeGen::LValue::getType", NM="_ZNK5clang7CodeGen6LValue7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(Type);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 260,
   FQN="clang::CodeGen::LValue::getObjCLifetime", NM="_ZNK5clang7CodeGen6LValue15getObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue15getObjCLifetimeEv")
  //</editor-fold>
  public Qualifiers.ObjCLifetime getObjCLifetime() /*const*/ {
    return Quals.getObjCLifetime();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isObjCIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 264,
   FQN="clang::CodeGen::LValue::isObjCIvar", NM="_ZNK5clang7CodeGen6LValue10isObjCIvarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue10isObjCIvarEv")
  //</editor-fold>
  public boolean isObjCIvar() /*const*/ {
    return Ivar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setObjCIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 265,
   FQN="clang::CodeGen::LValue::setObjCIvar", NM="_ZN5clang7CodeGen6LValue11setObjCIvarEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue11setObjCIvarEb")
  //</editor-fold>
  public void setObjCIvar(boolean Value) {
    Ivar = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isObjCArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 267,
   FQN="clang::CodeGen::LValue::isObjCArray", NM="_ZNK5clang7CodeGen6LValue11isObjCArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue11isObjCArrayEv")
  //</editor-fold>
  public boolean isObjCArray() /*const*/ {
    return ObjIsArray;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setObjCArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 268,
   FQN="clang::CodeGen::LValue::setObjCArray", NM="_ZN5clang7CodeGen6LValue12setObjCArrayEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue12setObjCArrayEb")
  //</editor-fold>
  public void setObjCArray(boolean Value) {
    ObjIsArray = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isNonGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 270,
   FQN="clang::CodeGen::LValue::isNonGC", NM="_ZNK5clang7CodeGen6LValue7isNonGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue7isNonGCEv")
  //</editor-fold>
  public boolean isNonGC() /*const*/ {
    return NonGC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setNonGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 271,
   FQN="clang::CodeGen::LValue::setNonGC", NM="_ZN5clang7CodeGen6LValue8setNonGCEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue8setNonGCEb")
  //</editor-fold>
  public void setNonGC(boolean Value) {
    NonGC = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isGlobalObjCRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 273,
   FQN="clang::CodeGen::LValue::isGlobalObjCRef", NM="_ZNK5clang7CodeGen6LValue15isGlobalObjCRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue15isGlobalObjCRefEv")
  //</editor-fold>
  public boolean isGlobalObjCRef() /*const*/ {
    return GlobalObjCRef;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setGlobalObjCRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 274,
   FQN="clang::CodeGen::LValue::setGlobalObjCRef", NM="_ZN5clang7CodeGen6LValue16setGlobalObjCRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue16setGlobalObjCRefEb")
  //</editor-fold>
  public void setGlobalObjCRef(boolean Value) {
    GlobalObjCRef = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isThreadLocalRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 276,
   FQN="clang::CodeGen::LValue::isThreadLocalRef", NM="_ZNK5clang7CodeGen6LValue16isThreadLocalRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue16isThreadLocalRefEv")
  //</editor-fold>
  public boolean isThreadLocalRef() /*const*/ {
    return ThreadLocalRef;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setThreadLocalRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 277,
   FQN="clang::CodeGen::LValue::setThreadLocalRef", NM="_ZN5clang7CodeGen6LValue17setThreadLocalRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue17setThreadLocalRefEb")
  //</editor-fold>
  public void setThreadLocalRef(boolean Value) {
    ThreadLocalRef = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isARCPreciseLifetime">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 279,
   FQN="clang::CodeGen::LValue::isARCPreciseLifetime", NM="_ZNK5clang7CodeGen6LValue20isARCPreciseLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue20isARCPreciseLifetimeEv")
  //</editor-fold>
  public ARCPreciseLifetime_t isARCPreciseLifetime() /*const*/ {
    return ARCPreciseLifetime_t.valueOf(!ImpreciseLifetime?1:0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setARCPreciseLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 282,
   FQN="clang::CodeGen::LValue::setARCPreciseLifetime", NM="_ZN5clang7CodeGen6LValue21setARCPreciseLifetimeENS0_20ARCPreciseLifetime_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue21setARCPreciseLifetimeENS0_20ARCPreciseLifetime_tE")
  //</editor-fold>
  public void setARCPreciseLifetime(ARCPreciseLifetime_t value) {
    ImpreciseLifetime = (value == ARCPreciseLifetime_t.ARCImpreciseLifetime);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isNontemporal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 285,
   FQN="clang::CodeGen::LValue::isNontemporal", NM="_ZNK5clang7CodeGen6LValue13isNontemporalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue13isNontemporalEv")
  //</editor-fold>
  public boolean isNontemporal() /*const*/ {
    return Nontemporal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setNontemporal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 286,
   FQN="clang::CodeGen::LValue::setNontemporal", NM="_ZN5clang7CodeGen6LValue14setNontemporalEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue14setNontemporalEb")
  //</editor-fold>
  public void setNontemporal(boolean Value) {
    Nontemporal = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isObjCWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 288,
   FQN="clang::CodeGen::LValue::isObjCWeak", NM="_ZNK5clang7CodeGen6LValue10isObjCWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue10isObjCWeakEv")
  //</editor-fold>
  public boolean isObjCWeak() /*const*/ {
    return Quals.getObjCGCAttr() == Qualifiers.GC.Weak;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isObjCStrong">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 291,
   FQN="clang::CodeGen::LValue::isObjCStrong", NM="_ZNK5clang7CodeGen6LValue12isObjCStrongEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue12isObjCStrongEv")
  //</editor-fold>
  public boolean isObjCStrong() /*const*/ {
    return Quals.getObjCGCAttr() == Qualifiers.GC.Strong;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 295,
   FQN="clang::CodeGen::LValue::isVolatile", NM="_ZNK5clang7CodeGen6LValue10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return Quals.hasVolatile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getBaseIvarExp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 299,
   FQN="clang::CodeGen::LValue::getBaseIvarExp", NM="_ZNK5clang7CodeGen6LValue14getBaseIvarExpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue14getBaseIvarExpEv")
  //</editor-fold>
  public Expr /*P*/ getBaseIvarExp() /*const*/ {
    return BaseIvarExp;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setBaseIvarExp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 300,
   FQN="clang::CodeGen::LValue::setBaseIvarExp", NM="_ZN5clang7CodeGen6LValue14setBaseIvarExpEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue14setBaseIvarExpEPNS_4ExprE")
  //</editor-fold>
  public void setBaseIvarExp(Expr /*P*/ V) {
    BaseIvarExp = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getTBAABaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 302,
   FQN="clang::CodeGen::LValue::getTBAABaseType", NM="_ZNK5clang7CodeGen6LValue15getTBAABaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue15getTBAABaseTypeEv")
  //</editor-fold>
  public QualType getTBAABaseType() /*const*/ {
    return new QualType(TBAABaseType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setTBAABaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 303,
   FQN="clang::CodeGen::LValue::setTBAABaseType", NM="_ZN5clang7CodeGen6LValue15setTBAABaseTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue15setTBAABaseTypeENS_8QualTypeE")
  //</editor-fold>
  public void setTBAABaseType(QualType T) {
    TBAABaseType.$assign(T);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getTBAAOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 305,
   FQN="clang::CodeGen::LValue::getTBAAOffset", NM="_ZNK5clang7CodeGen6LValue13getTBAAOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue13getTBAAOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ getTBAAOffset() /*const*/ {
    return TBAAOffset;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setTBAAOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 306,
   FQN="clang::CodeGen::LValue::setTBAAOffset", NM="_ZN5clang7CodeGen6LValue13setTBAAOffsetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue13setTBAAOffsetEy")
  //</editor-fold>
  public void setTBAAOffset(long/*uint64_t*/ O) {
    TBAAOffset = O;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getTBAAInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 308,
   FQN="clang::CodeGen::LValue::getTBAAInfo", NM="_ZNK5clang7CodeGen6LValue11getTBAAInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue11getTBAAInfoEv")
  //</editor-fold>
  public MDNode /*P*/ getTBAAInfo() /*const*/ {
    return TBAAInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setTBAAInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 309,
   FQN="clang::CodeGen::LValue::setTBAAInfo", NM="_ZN5clang7CodeGen6LValue11setTBAAInfoEPN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue11setTBAAInfoEPN4llvm6MDNodeE")
  //</editor-fold>
  public void setTBAAInfo(MDNode /*P*/ N) {
    TBAAInfo = N;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 311,
   FQN="clang::CodeGen::LValue::getQuals", NM="_ZNK5clang7CodeGen6LValue8getQualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue8getQualsEv")
  //</editor-fold>
  public /*const*/ Qualifiers /*&*/ getQuals$Const() /*const*/ {
    return Quals;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 312,
   FQN="clang::CodeGen::LValue::getQuals", NM="_ZN5clang7CodeGen6LValue8getQualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue8getQualsEv")
  //</editor-fold>
  public Qualifiers /*&*/ getQuals() {
    return Quals;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 314,
   FQN="clang::CodeGen::LValue::getAddressSpace", NM="_ZNK5clang7CodeGen6LValue15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue15getAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getAddressSpace() /*const*/ {
    return Quals.getAddressSpace();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 316,
   FQN="clang::CodeGen::LValue::getAlignment", NM="_ZNK5clang7CodeGen6LValue12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue12getAlignmentEv")
  //</editor-fold>
  public CharUnits getAlignment() /*const*/ {
    return CharUnits.fromQuantity(Alignment);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 317,
   FQN="clang::CodeGen::LValue::setAlignment", NM="_ZN5clang7CodeGen6LValue12setAlignmentENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue12setAlignmentENS_9CharUnitsE")
  //</editor-fold>
  public void setAlignment(CharUnits A) {
    Alignment = A.getQuantity();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getAlignmentSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 319,
   FQN="clang::CodeGen::LValue::getAlignmentSource", NM="_ZNK5clang7CodeGen6LValue18getAlignmentSourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue18getAlignmentSourceEv")
  //</editor-fold>
  public AlignmentSource getAlignmentSource() /*const*/ {
    return AlignmentSource.valueOf($2bits_uint2uint(AlignSource));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setAlignmentSource">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 322,
   FQN="clang::CodeGen::LValue::setAlignmentSource", NM="_ZN5clang7CodeGen6LValue18setAlignmentSourceENS0_15AlignmentSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue18setAlignmentSourceENS0_15AlignmentSourceE")
  //</editor-fold>
  public void setAlignmentSource(AlignmentSource Source) {
    AlignSource = $uint2uint_2bits(((/*uint*/int)(Source.getValue())));
  }

  
  // simple lvalue
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 327,
   FQN="clang::CodeGen::LValue::getPointer", NM="_ZNK5clang7CodeGen6LValue10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue10getPointerEv")
  //</editor-fold>
  public Value /*P*/ getPointer() /*const*/ {
    assert (isSimple());
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 331,
   FQN="clang::CodeGen::LValue::getAddress", NM="_ZNK5clang7CodeGen6LValue10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue10getAddressEv")
  //</editor-fold>
  public Address getAddress() /*const*/ {
    return new Address(getPointer(), getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::setAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 332,
   FQN="clang::CodeGen::LValue::setAddress", NM="_ZN5clang7CodeGen6LValue10setAddressENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue10setAddressENS0_7AddressE")
  //</editor-fold>
  public void setAddress(Address address) {
    assert (isSimple());
    V = address.getPointer();
    Alignment = address.getAlignment().getQuantity();
  }

  
  // vector elt lvalue
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getVectorAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 339,
   FQN="clang::CodeGen::LValue::getVectorAddress", NM="_ZNK5clang7CodeGen6LValue16getVectorAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue16getVectorAddressEv")
  //</editor-fold>
  public Address getVectorAddress() /*const*/ {
    return new Address(getVectorPointer(), getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getVectorPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 342,
   FQN="clang::CodeGen::LValue::getVectorPointer", NM="_ZNK5clang7CodeGen6LValue16getVectorPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue16getVectorPointerEv")
  //</editor-fold>
  public Value /*P*/ getVectorPointer() /*const*/ {
    assert (isVectorElt());
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getVectorIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 343,
   FQN="clang::CodeGen::LValue::getVectorIdx", NM="_ZNK5clang7CodeGen6LValue12getVectorIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue12getVectorIdxEv")
  //</editor-fold>
  public Value /*P*/ getVectorIdx() /*const*/ {
    assert (isVectorElt());
    return Unnamed_field2.VectorIdx;
  }

  
  // extended vector elements.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getExtVectorAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 346,
   FQN="clang::CodeGen::LValue::getExtVectorAddress", NM="_ZNK5clang7CodeGen6LValue19getExtVectorAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue19getExtVectorAddressEv")
  //</editor-fold>
  public Address getExtVectorAddress() /*const*/ {
    return new Address(getExtVectorPointer(), getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getExtVectorPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 349,
   FQN="clang::CodeGen::LValue::getExtVectorPointer", NM="_ZNK5clang7CodeGen6LValue19getExtVectorPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue19getExtVectorPointerEv")
  //</editor-fold>
  public Value /*P*/ getExtVectorPointer() /*const*/ {
    assert (isExtVectorElt());
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getExtVectorElts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 353,
   FQN="clang::CodeGen::LValue::getExtVectorElts", NM="_ZNK5clang7CodeGen6LValue16getExtVectorEltsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue16getExtVectorEltsEv")
  //</editor-fold>
  public Constant /*P*/ getExtVectorElts() /*const*/ {
    assert (isExtVectorElt());
    return Unnamed_field2.VectorElts;
  }

  
  // bitfield lvalue
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getBitFieldAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 359,
   FQN="clang::CodeGen::LValue::getBitFieldAddress", NM="_ZNK5clang7CodeGen6LValue18getBitFieldAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue18getBitFieldAddressEv")
  //</editor-fold>
  public Address getBitFieldAddress() /*const*/ {
    return new Address(getBitFieldPointer(), getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getBitFieldPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 362,
   FQN="clang::CodeGen::LValue::getBitFieldPointer", NM="_ZNK5clang7CodeGen6LValue18getBitFieldPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue18getBitFieldPointerEv")
  //</editor-fold>
  public Value /*P*/ getBitFieldPointer() /*const*/ {
    assert (isBitField());
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 363,
   FQN="clang::CodeGen::LValue::getBitFieldInfo", NM="_ZNK5clang7CodeGen6LValue15getBitFieldInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue15getBitFieldInfoEv")
  //</editor-fold>
  public /*const*/ CGBitFieldInfo /*&*/ getBitFieldInfo() /*const*/ {
    assert (isBitField());
    return /*Deref*/Unnamed_field2.BitFieldInfo;
  }

  
  // global register lvalue
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::getGlobalReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 369,
   FQN="clang::CodeGen::LValue::getGlobalReg", NM="_ZNK5clang7CodeGen6LValue12getGlobalRegEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue12getGlobalRegEv")
  //</editor-fold>
  public Value /*P*/ getGlobalReg() /*const*/ {
    assert (isGlobalReg());
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::MakeAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 371,
   FQN="clang::CodeGen::LValue::MakeAddr", NM="_ZN5clang7CodeGen6LValue8MakeAddrENS0_7AddressENS_8QualTypeERNS_10ASTContextENS0_15AlignmentSourceEPN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue8MakeAddrENS0_7AddressENS_8QualTypeERNS_10ASTContextENS0_15AlignmentSourceEPN4llvm6MDNodeE")
  //</editor-fold>
  public static LValue MakeAddr(Address address, QualType type, 
          final ASTContext /*&*/ Context, 
          AlignmentSource alignSource) {
    return MakeAddr(address, type, 
          Context, 
          alignSource, 
          (MDNode /*P*/ )null);
  }
  public static LValue MakeAddr(Address address, QualType type, 
          final ASTContext /*&*/ Context, 
          AlignmentSource alignSource, 
          MDNode /*P*/ TBAAInfo/*= null*/) {
    Qualifiers qs = type.getQualifiers();
    qs.setObjCGCAttr(Context.getObjCGCAttrKind(new QualType(type)));
    
    LValue R/*J*/= new LValue();
    R.LVType = Unnamed_enum.Simple;
    assert (address.getPointer().getType().isPointerTy());
    R.V = address.getPointer();
    R.Initialize(new QualType(type), new Qualifiers(qs), address.getAlignment(), alignSource, TBAAInfo);
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::MakeVectorElt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 386,
   FQN="clang::CodeGen::LValue::MakeVectorElt", NM="_ZN5clang7CodeGen6LValue13MakeVectorEltENS0_7AddressEPN4llvm5ValueENS_8QualTypeENS0_15AlignmentSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue13MakeVectorEltENS0_7AddressEPN4llvm5ValueENS_8QualTypeENS0_15AlignmentSourceE")
  //</editor-fold>
  public static LValue MakeVectorElt(Address vecAddress, Value /*P*/ Idx, 
               QualType type, AlignmentSource alignSource) {
    LValue R/*J*/= new LValue();
    R.LVType = Unnamed_enum.VectorElt;
    R.V = vecAddress.getPointer();
    R.Unnamed_field2.VectorIdx = Idx;
    R.Initialize(new QualType(type), type.getQualifiers(), vecAddress.getAlignment(), 
        alignSource);
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::MakeExtVectorElt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 397,
   FQN="clang::CodeGen::LValue::MakeExtVectorElt", NM="_ZN5clang7CodeGen6LValue16MakeExtVectorEltENS0_7AddressEPN4llvm8ConstantENS_8QualTypeENS0_15AlignmentSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue16MakeExtVectorEltENS0_7AddressEPN4llvm8ConstantENS_8QualTypeENS0_15AlignmentSourceE")
  //</editor-fold>
  public static LValue MakeExtVectorElt(Address vecAddress, Constant /*P*/ Elts, 
                  QualType type, AlignmentSource alignSource) {
    LValue R/*J*/= new LValue();
    R.LVType = Unnamed_enum.ExtVectorElt;
    R.V = vecAddress.getPointer();
    R.Unnamed_field2.VectorElts = Elts;
    R.Initialize(new QualType(type), type.getQualifiers(), vecAddress.getAlignment(), 
        alignSource);
    return R;
  }

  
  /// \brief Create a new object to represent a bit-field access.
  ///
  /// \param Addr - The base address of the bit-field sequence this
  /// bit-field refers to.
  /// \param Info - The information describing how to perform the bit-field
  /// access.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::MakeBitfield">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 414,
   FQN="clang::CodeGen::LValue::MakeBitfield", NM="_ZN5clang7CodeGen6LValue12MakeBitfieldENS0_7AddressERKNS0_14CGBitFieldInfoENS_8QualTypeENS0_15AlignmentSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue12MakeBitfieldENS0_7AddressERKNS0_14CGBitFieldInfoENS_8QualTypeENS0_15AlignmentSourceE")
  //</editor-fold>
  public static LValue MakeBitfield(Address Addr, 
              final /*const*/ CGBitFieldInfo /*&*/ Info, 
              QualType type, 
              AlignmentSource alignSource) {
    LValue R/*J*/= new LValue();
    R.LVType = Unnamed_enum.BitField;
    R.V = Addr.getPointer();
    R.Unnamed_field2.BitFieldInfo = /*AddrOf*/Info;
    R.Initialize(new QualType(type), type.getQualifiers(), Addr.getAlignment(), alignSource);
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::MakeGlobalReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 426,
   FQN="clang::CodeGen::LValue::MakeGlobalReg", NM="_ZN5clang7CodeGen6LValue13MakeGlobalRegENS0_7AddressENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValue13MakeGlobalRegENS0_7AddressENS_8QualTypeE")
  //</editor-fold>
  public static LValue MakeGlobalReg(Address Reg, QualType type) {
    LValue R/*J*/= new LValue();
    R.LVType = Unnamed_enum.GlobalReg;
    R.V = Reg.getPointer();
    R.Initialize(new QualType(type), type.getQualifiers(), Reg.getAlignment(), 
        AlignmentSource.Decl);
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::asAggregateRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 435,
   FQN="clang::CodeGen::LValue::asAggregateRValue", NM="_ZNK5clang7CodeGen6LValue17asAggregateRValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6LValue17asAggregateRValueEv")
  //</editor-fold>
  public RValue asAggregateRValue() /*const*/ {
    return RValue.getAggregate(getAddress(), isVolatileQualified());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::LValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 152,
   FQN="clang::CodeGen::LValue::LValue", NM="_ZN5clang7CodeGen6LValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueC1Ev")
  //</editor-fold>
  public /*inline*/ LValue() {
    // : Type(), Quals(), TBAABaseType() 
    //START JInit
    this.Type = new QualType();
    this.Quals = new Qualifiers();
    this.TBAABaseType = new QualType();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::LValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 152,
   FQN="clang::CodeGen::LValue::LValue", NM="_ZN5clang7CodeGen6LValueC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LValue(final /*const*/ LValue /*&*/ $Prm0) {
    // : LVType(.LVType), V(.V), Unnamed_field2(.), Type(.Type), Quals(.Quals), Alignment(.Alignment), Ivar(.Ivar), ObjIsArray(.ObjIsArray), NonGC(.NonGC), GlobalObjCRef(.GlobalObjCRef), ThreadLocalRef(.ThreadLocalRef), ImpreciseLifetime(.ImpreciseLifetime), AlignSource(.AlignSource), Nontemporal(.Nontemporal), BaseIvarExp(.BaseIvarExp), TBAABaseType(.TBAABaseType), TBAAOffset(.TBAAOffset), TBAAInfo(.TBAAInfo) 
    //START JInit
    this.LVType = $Prm0.LVType;
    this.V = $Prm0.V;
    this.Unnamed_field2 = new Unnamed_union1($Prm0.Unnamed_field2);
    this.Type = new QualType($Prm0.Type);
    this.Quals = new Qualifiers($Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.Ivar = $Prm0.Ivar;
    this.ObjIsArray = $Prm0.ObjIsArray;
    this.NonGC = $Prm0.NonGC;
    this.GlobalObjCRef = $Prm0.GlobalObjCRef;
    this.ThreadLocalRef = $Prm0.ThreadLocalRef;
    this.ImpreciseLifetime = $Prm0.ImpreciseLifetime;
    this.AlignSource = $uint2uint_2bits($2bits_uint2uint($Prm0.AlignSource));
    this.Nontemporal = $Prm0.Nontemporal;
    this.BaseIvarExp = $Prm0.BaseIvarExp;
    this.TBAABaseType = new QualType($Prm0.TBAABaseType);
    this.TBAAOffset = $Prm0.TBAAOffset;
    this.TBAAInfo = $Prm0.TBAAInfo;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::LValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 152,
   FQN="clang::CodeGen::LValue::LValue", NM="_ZN5clang7CodeGen6LValueC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueC1EOS1_")
  //</editor-fold>
  public /*inline*/ LValue(JD$Move _dparam, final LValue /*&&*/$Prm0) {
    // : LVType(static_cast<LValue &&>().LVType), V(static_cast<LValue &&>().V), Unnamed_field2(static_cast<LValue &&>().), Type(static_cast<LValue &&>().Type), Quals(static_cast<LValue &&>().Quals), Alignment(static_cast<LValue &&>().Alignment), Ivar(static_cast<LValue &&>().Ivar), ObjIsArray(static_cast<LValue &&>().ObjIsArray), NonGC(static_cast<LValue &&>().NonGC), GlobalObjCRef(static_cast<LValue &&>().GlobalObjCRef), ThreadLocalRef(static_cast<LValue &&>().ThreadLocalRef), ImpreciseLifetime(static_cast<LValue &&>().ImpreciseLifetime), AlignSource(static_cast<LValue &&>().AlignSource), Nontemporal(static_cast<LValue &&>().Nontemporal), BaseIvarExp(static_cast<LValue &&>().BaseIvarExp), TBAABaseType(static_cast<LValue &&>().TBAABaseType), TBAAOffset(static_cast<LValue &&>().TBAAOffset), TBAAInfo(static_cast<LValue &&>().TBAAInfo) 
    //START JInit
    this.LVType = $Prm0.LVType;
    this.V = $Prm0.V;
    this.Unnamed_field2 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field2);
    this.Type = new QualType(JD$Move.INSTANCE, $Prm0.Type);
    this.Quals = new Qualifiers(JD$Move.INSTANCE, $Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.Ivar = $Prm0.Ivar;
    this.ObjIsArray = $Prm0.ObjIsArray;
    this.NonGC = $Prm0.NonGC;
    this.GlobalObjCRef = $Prm0.GlobalObjCRef;
    this.ThreadLocalRef = $Prm0.ThreadLocalRef;
    this.ImpreciseLifetime = $Prm0.ImpreciseLifetime;
    this.AlignSource = $uint2uint_2bits($2bits_uint2uint($Prm0.AlignSource));
    this.Nontemporal = $Prm0.Nontemporal;
    this.BaseIvarExp = $Prm0.BaseIvarExp;
    this.TBAABaseType = new QualType(JD$Move.INSTANCE, $Prm0.TBAABaseType);
    this.TBAAOffset = $Prm0.TBAAOffset;
    this.TBAAInfo = $Prm0.TBAAInfo;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 152,
   FQN="clang::CodeGen::LValue::operator=", NM="_ZN5clang7CodeGen6LValueaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueaSERKS1_")
  //</editor-fold>
  public /*inline*/ LValue /*&*/ $assign(final /*const*/ LValue /*&*/ $Prm0) {
    this.LVType = $Prm0.LVType;
    this.V = $Prm0.V;
    this.Unnamed_field2.$assign($Prm0.Unnamed_field2);
    this.Type.$assign($Prm0.Type);
    this.Quals.$assign($Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.Ivar = $Prm0.Ivar;
    this.ObjIsArray = $Prm0.ObjIsArray;
    this.NonGC = $Prm0.NonGC;
    this.GlobalObjCRef = $Prm0.GlobalObjCRef;
    this.ThreadLocalRef = $Prm0.ThreadLocalRef;
    this.ImpreciseLifetime = $Prm0.ImpreciseLifetime;
    this.AlignSource = $uint2uint_2bits($2bits_uint2uint($Prm0.AlignSource));
    this.Nontemporal = $Prm0.Nontemporal;
    this.BaseIvarExp = $Prm0.BaseIvarExp;
    this.TBAABaseType.$assign($Prm0.TBAABaseType);
    this.TBAAOffset = $Prm0.TBAAOffset;
    this.TBAAInfo = $Prm0.TBAAInfo;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 152,
   FQN="clang::CodeGen::LValue::operator=", NM="_ZN5clang7CodeGen6LValueaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6LValueaSEOS1_")
  //</editor-fold>
  public /*inline*/ LValue /*&*/ $assignMove(final LValue /*&&*/$Prm0) {
    this.LVType = $Prm0.LVType;
    this.V = $Prm0.V;
    this.Unnamed_field2.$assignMove($Prm0.Unnamed_field2);
    this.Type.$assignMove($Prm0.Type);
    this.Quals.$assignMove($Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.Ivar = $Prm0.Ivar;
    this.ObjIsArray = $Prm0.ObjIsArray;
    this.NonGC = $Prm0.NonGC;
    this.GlobalObjCRef = $Prm0.GlobalObjCRef;
    this.ThreadLocalRef = $Prm0.ThreadLocalRef;
    this.ImpreciseLifetime = $Prm0.ImpreciseLifetime;
    this.AlignSource = $uint2uint_2bits($2bits_uint2uint($Prm0.AlignSource));
    this.Nontemporal = $Prm0.Nontemporal;
    this.BaseIvarExp = $Prm0.BaseIvarExp;
    this.TBAABaseType.$assignMove($Prm0.TBAABaseType);
    this.TBAAOffset = $Prm0.TBAAOffset;
    this.TBAAInfo = $Prm0.TBAAInfo;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public LValue clone() {
    return new LValue(this);
  }
  
  @Override public LValue move() {
    return new LValue(JD$Move.INSTANCE, this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  @Override public String toString() {
    return "" + "LVType=" + LVType // NOI18N
              + ", V=" + V // NOI18N
              + ", Unnamed_field2=" + Unnamed_field2 // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Quals=" + Quals // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", Ivar=" + Ivar // NOI18N
              + ", ObjIsArray=" + ObjIsArray // NOI18N
              + ", NonGC=" + NonGC // NOI18N
              + ", GlobalObjCRef=" + GlobalObjCRef // NOI18N
              + ", ThreadLocalRef=" + ThreadLocalRef // NOI18N
              + ", ImpreciseLifetime=" + ImpreciseLifetime // NOI18N
              + ", AlignSource=" + $uchar2uint(AlignSource) // NOI18N
              + ", Nontemporal=" + Nontemporal // NOI18N
              + ", BaseIvarExp=" + "[Expr]" // NOI18N
              + ", TBAABaseType=" + TBAABaseType // NOI18N
              + ", TBAAOffset=" + TBAAOffset // NOI18N
              + ", TBAAInfo=" + TBAAInfo; // NOI18N
  }
}
