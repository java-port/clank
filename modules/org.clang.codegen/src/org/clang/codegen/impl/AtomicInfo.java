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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGAtomicStatics.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 29,
 FQN="(anonymous namespace)::AtomicInfo", NM="_ZN12_GLOBAL__N_110AtomicInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfoE")
//</editor-fold>
public class AtomicInfo {
  private final CodeGenFunction /*&*/ CGF;
  private QualType AtomicTy;
  private QualType ValueTy;
  private long/*uint64_t*/ AtomicSizeInBits;
  private long/*uint64_t*/ ValueSizeInBits;
  private CharUnits AtomicAlign;
  private CharUnits ValueAlign;
  private CharUnits LValueAlign;
  private TypeEvaluationKind EvaluationKind;
  private boolean UseLibcall;
  private LValue LVal;
  private CGBitFieldInfo BFI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::AtomicInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 43,
   FQN="(anonymous namespace)::AtomicInfo::AtomicInfo", NM="_ZN12_GLOBAL__N_110AtomicInfoC1ERN5clang7CodeGen15CodeGenFunctionERNS2_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfoC1ERN5clang7CodeGen15CodeGenFunctionERNS2_6LValueE")
  //</editor-fold>
  public AtomicInfo(final CodeGenFunction /*&*/ CGF, final LValue /*&*/ lvalue) {
    // : CGF(CGF), AtomicTy(), ValueTy(), AtomicSizeInBits(0), ValueSizeInBits(0), AtomicAlign(), ValueAlign(), LValueAlign(), EvaluationKind(TEK_Scalar), UseLibcall(true), LVal(), BFI() 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.AtomicTy = new QualType();
    this.ValueTy = new QualType();
    this.AtomicSizeInBits = $int2ulong(0);
    this.ValueSizeInBits = $int2ulong(0);
    this.AtomicAlign = new CharUnits();
    this.ValueAlign = new CharUnits();
    this.LValueAlign = new CharUnits();
    this.EvaluationKind = TypeEvaluationKind.TEK_Scalar;
    this.UseLibcall = true;
    this.LVal = new LValue();
    this.BFI = new CGBitFieldInfo();
    //END JInit
    assert (!lvalue.isGlobalReg());
    final ASTContext /*&*/ C = CGF.getContext();
    if (lvalue.isSimple()) {
      AtomicTy.$assignMove(lvalue.getType());
      {
        /*const*/ AtomicType /*P*/ ATy = AtomicTy.$arrow().getAs(AtomicType.class);
        if ((ATy != null)) {
          ValueTy.$assignMove(ATy.getValueType());
        } else {
          ValueTy.$assign(AtomicTy);
        }
      }
      EvaluationKind = CGF.getEvaluationKind(new QualType(ValueTy));
      
      long/*uint64_t*/ ValueAlignInBits;
      long/*uint64_t*/ AtomicAlignInBits;
      TypeInfo ValueTI = C.getTypeInfo(new QualType(ValueTy));
      ValueSizeInBits = ValueTI.Width;
      ValueAlignInBits = $uint2ulong(ValueTI.Align);
      
      TypeInfo AtomicTI = C.getTypeInfo(new QualType(AtomicTy));
      AtomicSizeInBits = AtomicTI.Width;
      AtomicAlignInBits = $uint2ulong(AtomicTI.Align);
      assert ($lesseq_ulong(ValueSizeInBits, AtomicSizeInBits));
      assert ($lesseq_ulong(ValueAlignInBits, AtomicAlignInBits));
      
      AtomicAlign.$assignMove(C.toCharUnitsFromBits(AtomicAlignInBits));
      ValueAlign.$assignMove(C.toCharUnitsFromBits(ValueAlignInBits));
      if (lvalue.getAlignment().isZero()) {
        lvalue.setAlignment(new CharUnits(AtomicAlign));
      }
      
      LVal.$assign(lvalue);
    } else if (lvalue.isBitField()) {
      ValueTy.$assignMove(lvalue.getType());
      ValueSizeInBits = C.getTypeSize(new QualType(ValueTy));
      final /*const*/ CGBitFieldInfo /*&*/ OrigBFI = lvalue.getBitFieldInfo();
      /*llong*/long Offset = $uint2llong($16bits_uint2uint(OrigBFI.Offset)) % C.toBits(lvalue.getAlignment());
      AtomicSizeInBits = C.toBits(C.toCharUnitsFromBits(Offset + $uint2llong($15bits_uint2uint(OrigBFI.Size)) + C.getCharWidth() - $int2ullong(1)).
              alignTo(lvalue.getAlignment()));
      Value /*P*/ VoidPtrAddr = CGF.EmitCastToVoidPtr(lvalue.getBitFieldPointer());
      CharUnits OffsetInChars = $star_long_CharUnits$C((C.toCharUnitsFromBits($uint2long($16bits_uint2uint(OrigBFI.Offset))).$slash(lvalue.getAlignment())), 
          lvalue.getAlignment());
      VoidPtrAddr = CGF.Builder.CreateConstGEP1_64(VoidPtrAddr, OffsetInChars.getQuantity());
      Value /*P*/ Addr = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(VoidPtrAddr, 
          CGF.Builder.getIntNTy($ulong2uint(AtomicSizeInBits)).getPointerTo(), 
          new Twine(/*KEEP_STR*/"atomic_bitfield_base"));
      BFI.$assign(OrigBFI);
      BFI.Offset = $uint2uint_16bits($llong2uint(Offset));
      BFI.StorageSize = $ulong2uint(AtomicSizeInBits);
      BFI.StorageOffset.$addassign(OffsetInChars);
      LVal.$assignMove(LValue.MakeBitfield(new Address(Addr, lvalue.getAlignment()), 
              BFI, lvalue.getType(), 
              lvalue.getAlignmentSource()));
      LVal.setTBAAInfo(lvalue.getTBAAInfo());
      AtomicTy.$assignMove(C.getIntTypeForBitwidth($ulong2uint(AtomicSizeInBits), OrigBFI.IsSigned?1:0));
      if (AtomicTy.isNull()) {
        APInt Size/*J*/= new APInt(/*numBits=*/ 32, 
            C.toCharUnitsFromBits(AtomicSizeInBits).getQuantity());
        AtomicTy.$assignMove(C.getConstantArrayType(C.CharTy.$QualType(), Size, org.clang.ast.ArrayType.ArraySizeModifier.Normal, 
                /*IndexTypeQuals=*/ 0));
      }
      AtomicAlign.$assign(ValueAlign.$assignMove(lvalue.getAlignment()));
    } else if (lvalue.isVectorElt()) {
      ValueTy.$assignMove(lvalue.getType().$arrow().getAs(org.clang.ast.VectorType.class).getElementType());
      ValueSizeInBits = C.getTypeSize(new QualType(ValueTy));
      AtomicTy.$assignMove(lvalue.getType());
      AtomicSizeInBits = C.getTypeSize(new QualType(AtomicTy));
      AtomicAlign.$assign(ValueAlign.$assignMove(lvalue.getAlignment()));
      LVal.$assign(lvalue);
    } else {
      assert (lvalue.isExtVectorElt());
      ValueTy.$assignMove(lvalue.getType());
      ValueSizeInBits = C.getTypeSize(new QualType(ValueTy));
      AtomicTy.$assign(ValueTy.$assignMove(CGF.getContext().getExtVectorType(lvalue.getType(), lvalue.getExtVectorAddress().
                      getElementType().getVectorNumElements())));
      AtomicSizeInBits = C.getTypeSize(new QualType(AtomicTy));
      AtomicAlign.$assign(ValueAlign.$assignMove(lvalue.getAlignment()));
      LVal.$assign(lvalue);
    }
    UseLibcall = !C.getTargetInfo().hasBuiltinAtomic(AtomicSizeInBits, C.toBits(lvalue.getAlignment()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 132,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicType", NM="_ZNK12_GLOBAL__N_110AtomicInfo13getAtomicTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo13getAtomicTypeEv")
  //</editor-fold>
  public QualType getAtomicType() /*const*/ {
    return new QualType(AtomicTy);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 133,
   FQN="(anonymous namespace)::AtomicInfo::getValueType", NM="_ZNK12_GLOBAL__N_110AtomicInfo12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo12getValueTypeEv")
  //</editor-fold>
  public QualType getValueType() /*const*/ {
    return new QualType(ValueTy);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 134,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicAlignment", NM="_ZNK12_GLOBAL__N_110AtomicInfo18getAtomicAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo18getAtomicAlignmentEv")
  //</editor-fold>
  public CharUnits getAtomicAlignment() /*const*/ {
    return new CharUnits(AtomicAlign);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getValueAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 135,
   FQN="(anonymous namespace)::AtomicInfo::getValueAlignment", NM="_ZNK12_GLOBAL__N_110AtomicInfo17getValueAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo17getValueAlignmentEv")
  //</editor-fold>
  public CharUnits getValueAlignment() /*const*/ {
    return new CharUnits(ValueAlign);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 136,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicSizeInBits", NM="_ZNK12_GLOBAL__N_110AtomicInfo19getAtomicSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo19getAtomicSizeInBitsEv")
  //</editor-fold>
  public long/*uint64_t*/ getAtomicSizeInBits() /*const*/ {
    return AtomicSizeInBits;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getValueSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 137,
   FQN="(anonymous namespace)::AtomicInfo::getValueSizeInBits", NM="_ZNK12_GLOBAL__N_110AtomicInfo18getValueSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo18getValueSizeInBitsEv")
  //</editor-fold>
  public long/*uint64_t*/ getValueSizeInBits() /*const*/ {
    return ValueSizeInBits;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getEvaluationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 138,
   FQN="(anonymous namespace)::AtomicInfo::getEvaluationKind", NM="_ZNK12_GLOBAL__N_110AtomicInfo17getEvaluationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo17getEvaluationKindEv")
  //</editor-fold>
  public TypeEvaluationKind getEvaluationKind() /*const*/ {
    return EvaluationKind;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::shouldUseLibcall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 139,
   FQN="(anonymous namespace)::AtomicInfo::shouldUseLibcall", NM="_ZNK12_GLOBAL__N_110AtomicInfo16shouldUseLibcallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo16shouldUseLibcallEv")
  //</editor-fold>
  public boolean shouldUseLibcall() /*const*/ {
    return UseLibcall;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 140,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicLValue", NM="_ZNK12_GLOBAL__N_110AtomicInfo15getAtomicLValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo15getAtomicLValueEv")
  //</editor-fold>
  public /*const*/ LValue /*&*/ getAtomicLValue() /*const*/ {
    return LVal;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 141,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicPointer", NM="_ZNK12_GLOBAL__N_110AtomicInfo16getAtomicPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo16getAtomicPointerEv")
  //</editor-fold>
  public Value /*P*/ getAtomicPointer() /*const*/ {
    if (LVal.isSimple()) {
      return LVal.getPointer();
    } else if (LVal.isBitField()) {
      return LVal.getBitFieldPointer();
    } else if (LVal.isVectorElt()) {
      return LVal.getVectorPointer();
    }
    assert (LVal.isExtVectorElt());
    return LVal.getExtVectorPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 151,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicAddress", NM="_ZNK12_GLOBAL__N_110AtomicInfo16getAtomicAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo16getAtomicAddressEv")
  //</editor-fold>
  public Address getAtomicAddress() /*const*/ {
    return new Address(getAtomicPointer(), getAtomicAlignment());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicAddressAsAtomicIntPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 155,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicAddressAsAtomicIntPointer", NM="_ZNK12_GLOBAL__N_110AtomicInfo34getAtomicAddressAsAtomicIntPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo34getAtomicAddressAsAtomicIntPointerEv")
  //</editor-fold>
  public Address getAtomicAddressAsAtomicIntPointer() /*const*/ {
    return emitCastToAtomicIntPointer(getAtomicAddress());
  }

  
  /// Is the atomic size larger than the underlying value type?
  ///
  /// Note that the absence of padding does not mean that atomic
  /// objects are completely interchangeable with non-atomic
  /// objects: we might have promoted the alignment of a type
  /// without making it bigger.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::hasPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 165,
   FQN="(anonymous namespace)::AtomicInfo::hasPadding", NM="_ZNK12_GLOBAL__N_110AtomicInfo10hasPaddingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo10hasPaddingEv")
  //</editor-fold>
  public boolean hasPadding() /*const*/ {
    return (ValueSizeInBits != AtomicSizeInBits);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::emitMemSetZeroIfNecessary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 344,
   FQN="(anonymous namespace)::AtomicInfo::emitMemSetZeroIfNecessary", NM="_ZNK12_GLOBAL__N_110AtomicInfo25emitMemSetZeroIfNecessaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo25emitMemSetZeroIfNecessaryEv")
  //</editor-fold>
  public boolean emitMemSetZeroIfNecessary() /*const*/ {
    assert (LVal.isSimple());
    Value /*P*/ addr = LVal.getPointer();
    if (!requiresMemSetZero(addr.getType().getPointerElementType())) {
      return false;
    }
    
    CGF.Builder.CreateMemSet(addr, ConstantInt.get(CGF.Int8Ty, $int2ulong(0)), 
        CGF.getContext().toCharUnitsFromBits(AtomicSizeInBits).getQuantity(), 
        $long2uint(LVal.getAlignment().getQuantity()));
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::getAtomicSizeValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 171,
   FQN="(anonymous namespace)::AtomicInfo::getAtomicSizeValue", NM="_ZNK12_GLOBAL__N_110AtomicInfo18getAtomicSizeValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo18getAtomicSizeValueEv")
  //</editor-fold>
  public Value /*P*/ getAtomicSizeValue() /*const*/ {
    CharUnits size = CGF.getContext().toCharUnitsFromBits(AtomicSizeInBits);
    return CGF.CGM.getSize(new CharUnits(size));
  }

  
  /// Cast the given pointer to an integer pointer suitable for atomic
  /// operations if the source.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::emitCastToAtomicIntPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1141,
   FQN="(anonymous namespace)::AtomicInfo::emitCastToAtomicIntPointer", NM="_ZNK12_GLOBAL__N_110AtomicInfo26emitCastToAtomicIntPointerEN5clang7CodeGen7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo26emitCastToAtomicIntPointerEN5clang7CodeGen7AddressE")
  //</editor-fold>
  public Address emitCastToAtomicIntPointer(Address addr) /*const*/ {
    /*uint*/int addrspace = cast_PointerType(addr.getPointer().getType()).getAddressSpace();
    IntegerType /*P*/ ty = IntegerType.get(CGF.getLLVMContext(), $ulong2uint(AtomicSizeInBits));
    return CGF.Builder.CreateBitCast(new Address(addr), ty.getPointerTo(addrspace));
  }

  
  /// If Addr is compatible with the iN that will be used for an atomic
  /// operation, bitcast it. Otherwise, create a temporary that is suitable
  /// and copy the value across.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::convertToAtomicIntPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1149,
   FQN="(anonymous namespace)::AtomicInfo::convertToAtomicIntPointer", NM="_ZNK12_GLOBAL__N_110AtomicInfo25convertToAtomicIntPointerEN5clang7CodeGen7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo25convertToAtomicIntPointerEN5clang7CodeGen7AddressE")
  //</editor-fold>
  public Address convertToAtomicIntPointer(Address Addr) /*const*/ {
    org.llvm.ir.Type /*P*/ Ty = Addr.getElementType();
    long/*uint64_t*/ SourceSizeInBits = CGF.CGM.getDataLayout().getTypeSizeInBits(Ty);
    if (SourceSizeInBits != AtomicSizeInBits) {
      Address Tmp = CreateTempAlloca();
      CGF.Builder.CreateMemCpy(new Address(Tmp), new Address(Addr), 
          $div_ullong(std.min(AtomicSizeInBits, SourceSizeInBits), $int2ullong(8)));
      Addr.$assign(Tmp);
    }
    
    return emitCastToAtomicIntPointer(new Address(Addr));
  }

  
  /// Turn an atomic-layout object into an r-value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::convertAtomicTempToRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1162,
   FQN="(anonymous namespace)::AtomicInfo::convertAtomicTempToRValue", NM="_ZNK12_GLOBAL__N_110AtomicInfo25convertAtomicTempToRValueEN5clang7CodeGen7AddressENS2_12AggValueSlotENS1_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo25convertAtomicTempToRValueEN5clang7CodeGen7AddressENS2_12AggValueSlotENS1_14SourceLocationEb")
  //</editor-fold>
  public RValue convertAtomicTempToRValue(Address addr, 
                           AggValueSlot resultSlot, 
                           SourceLocation loc, 
                           boolean asValue) /*const*/ {
    if (LVal.isSimple()) {
      if (EvaluationKind == TypeEvaluationKind.TEK_Aggregate) {
        return resultSlot.asRValue();
      }
      
      // Drill into the padding structure if we have one.
      if (hasPadding()) {
        addr.$assignMove(CGF.Builder.CreateStructGEP(new Address(addr), 0, new CharUnits()));
      }
      
      // Otherwise, just convert the temporary to an r-value using the
      // normal conversion routine.
      return CGF.convertTempToRValue(new Address(addr), getValueType(), new SourceLocation(loc));
    }
    if (!asValue) {
      // Get RValue from temp memory as atomic for non-simple lvalues
      return RValue.get(CGF.Builder.CreateLoad(new Address(addr)));
    }
    if (LVal.isBitField()) {
      return CGF.EmitLoadOfBitfieldLValue(LValue.MakeBitfield(new Address(addr), LVal.getBitFieldInfo(), LVal.getType(), 
              LVal.getAlignmentSource()));
    }
    if (LVal.isVectorElt()) {
      return CGF.EmitLoadOfLValue(LValue.MakeVectorElt(new Address(addr), LVal.getVectorIdx(), LVal.getType(), 
              LVal.getAlignmentSource()), new SourceLocation(loc));
    }
    assert (LVal.isExtVectorElt());
    return CGF.EmitLoadOfExtVectorElementLValue(LValue.MakeExtVectorElt(new Address(addr), LVal.getExtVectorElts(), LVal.getType(), 
            LVal.getAlignmentSource()));
  }

  
  /// \brief Converts a rvalue to integer value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::convertRValueToInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1386,
   FQN="(anonymous namespace)::AtomicInfo::convertRValueToInt", NM="_ZNK12_GLOBAL__N_110AtomicInfo18convertRValueToIntEN5clang7CodeGen6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo18convertRValueToIntEN5clang7CodeGen6RValueE")
  //</editor-fold>
  public Value /*P*/ convertRValueToInt(RValue RVal) /*const*/ {
    // If we've got a scalar value of the right size, try to avoid going
    // through memory.
    if (RVal.isScalar() && (!hasPadding() || !LVal.isSimple())) {
      Value /*P*/ $Value = RVal.getScalarVal();
      if (isa_IntegerType($Value.getType())) {
        return CGF.EmitToMemory($Value, new QualType(ValueTy));
      } else {
        IntegerType /*P*/ InputIntTy = IntegerType.get(CGF.getLLVMContext(), 
            $ulong2uint(LVal.isSimple() ? getValueSizeInBits() : getAtomicSizeInBits()));
        if (isa_PointerType($Value.getType())) {
          return CGF.Builder.CreatePtrToInt($Value, InputIntTy);
        } else if (BitCastInst.isBitCastable($Value.getType(), InputIntTy)) {
          return CGF.Builder.CreateBitCast($Value, InputIntTy);
        }
      }
    }
    // Otherwise, we need to go through memory.
    // Put the r-value in memory.
    Address Addr = materializeRValue(new RValue(RVal));
    
    // Cast the temporary to the atomic int type and pull a value out.
    Addr.$assignMove(emitCastToAtomicIntPointer(new Address(Addr)));
    return CGF.Builder.CreateLoad(new Address(Addr));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::ConvertIntToValueOrAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1195,
   FQN="(anonymous namespace)::AtomicInfo::ConvertIntToValueOrAtomic", NM="_ZNK12_GLOBAL__N_110AtomicInfo25ConvertIntToValueOrAtomicEPN4llvm5ValueEN5clang7CodeGen12AggValueSlotENS4_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo25ConvertIntToValueOrAtomicEPN4llvm5ValueEN5clang7CodeGen12AggValueSlotENS4_14SourceLocationEb")
  //</editor-fold>
  public RValue ConvertIntToValueOrAtomic(Value /*P*/ IntVal, 
                           AggValueSlot ResultSlot, 
                           SourceLocation Loc, 
                           boolean AsValue) /*const*/ {
    // Try not to in some easy cases.
    assert (IntVal.getType().isIntegerTy()) : "Expected integer value";
    if (getEvaluationKind() == TypeEvaluationKind.TEK_Scalar
       && (((!LVal.isBitField()
       || $uint2ullong($15bits_uint2uint(LVal.getBitFieldInfo().Size)) == ValueSizeInBits)
       && !hasPadding())
       || !AsValue)) {
      org.llvm.ir.Type /*P*/ ValTy = AsValue ? CGF.ConvertTypeForMem(new QualType(ValueTy)) : getAtomicAddress().getType().getPointerElementType();
      if (ValTy.isIntegerTy()) {
        assert (IntVal.getType() == ValTy) : "Different integer types.";
        return RValue.get(CGF.EmitFromMemory(IntVal, new QualType(ValueTy)));
      } else if (ValTy.isPointerTy()) {
        return RValue.get(CGF.Builder.CreateIntToPtr(IntVal, ValTy));
      } else if (CastInst.isBitCastable(IntVal.getType(), ValTy)) {
        return RValue.get(CGF.Builder.CreateBitCast(IntVal, ValTy));
      }
    }
    
    // Create a temporary.  This needs to be big enough to hold the
    // atomic integer.
    Address Temp = Address.invalid();
    boolean TempIsVolatile = false;
    if (AsValue && getEvaluationKind() == TypeEvaluationKind.TEK_Aggregate) {
      assert (!ResultSlot.isIgnored());
      Temp.$assignMove(ResultSlot.getAddress());
      TempIsVolatile = ResultSlot.isVolatile();
    } else {
      Temp.$assignMove(CreateTempAlloca());
    }
    
    // Slam the integer into the temporary.
    Address CastTemp = emitCastToAtomicIntPointer(new Address(Temp));
    CGF.Builder.CreateStore(IntVal, new Address(CastTemp)).
        setVolatile(TempIsVolatile);
    
    return convertAtomicTempToRValue(new Address(Temp), new AggValueSlot(ResultSlot), new SourceLocation(Loc), AsValue);
  }

  
  /// Copy an atomic r-value into atomic-layout memory.
  
  /// Copy an r-value into memory as part of storing to an atomic type.
  /// This needs to create a bit-pattern suitable for atomic operations.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::emitCopyIntoMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1340,
   FQN="(anonymous namespace)::AtomicInfo::emitCopyIntoMemory", NM="_ZNK12_GLOBAL__N_110AtomicInfo18emitCopyIntoMemoryEN5clang7CodeGen6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo18emitCopyIntoMemoryEN5clang7CodeGen6RValueE")
  //</editor-fold>
  public void emitCopyIntoMemory(RValue rvalue) /*const*/ {
    assert (LVal.isSimple());
    // If we have an r-value, the rvalue should be of the atomic type,
    // which means that the caller is responsible for having zeroed
    // any padding.  Just do an aggregate copy of that type.
    if (rvalue.isAggregate()) {
      CGF.EmitAggregateCopy(getAtomicAddress(), 
          rvalue.getAggregateAddress(), 
          getAtomicType(), 
          (rvalue.isVolatileQualified()
             || LVal.isVolatileQualified()));
      return;
    }
    
    // Okay, otherwise we're copying stuff.
    
    // Zero out the buffer if necessary.
    emitMemSetZeroIfNecessary();
    
    // Drill past the padding if present.
    LValue TempLVal = projectValue();
    
    // Okay, store the rvalue in.
    if (rvalue.isScalar()) {
      CGF.EmitStoreOfScalar(rvalue.getScalarVal(), new LValue(TempLVal), /*init*/ true);
    } else {
      CGF.EmitStoreOfComplex(rvalue.getComplexVal(), new LValue(TempLVal), /*init*/ true);
    }
  }

  
  /// Project an l-value down to the value field.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::projectValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 200,
   FQN="(anonymous namespace)::AtomicInfo::projectValue", NM="_ZNK12_GLOBAL__N_110AtomicInfo12projectValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo12projectValueEv")
  //</editor-fold>
  public LValue projectValue() /*const*/ {
    assert (LVal.isSimple());
    Address addr = getAtomicAddress();
    if (hasPadding()) {
      addr.$assignMove(CGF.Builder.CreateStructGEP(new Address(addr), 0, new CharUnits()));
    }
    
    return LValue.MakeAddr(new Address(addr), getValueType(), CGF.getContext(), 
        LVal.getAlignmentSource(), LVal.getTBAAInfo());
  }

  
  /// \brief Emits atomic load.
  /// \returns Loaded value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1297,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicLoad", NM="_ZN12_GLOBAL__N_110AtomicInfo14EmitAtomicLoadEN5clang7CodeGen12AggValueSlotENS1_14SourceLocationEbN4llvm14AtomicOrderingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo14EmitAtomicLoadEN5clang7CodeGen12AggValueSlotENS1_14SourceLocationEbN4llvm14AtomicOrderingEb")
  //</editor-fold>
  public RValue EmitAtomicLoad(AggValueSlot ResultSlot, SourceLocation Loc, 
                boolean AsValue, AtomicOrdering AO, 
                boolean IsVolatile) {
    // Check whether we should use a library call.
    if (shouldUseLibcall()) {
      Address TempAddr = Address.invalid();
      if (LVal.isSimple() && !ResultSlot.isIgnored()) {
        assert (getEvaluationKind() == TypeEvaluationKind.TEK_Aggregate);
        TempAddr.$assignMove(ResultSlot.getAddress());
      } else {
        TempAddr.$assignMove(CreateTempAlloca());
      }
      
      EmitAtomicLoadLibcall(TempAddr.getPointer(), AO, IsVolatile);
      
      // Okay, turn that back into the original value or whole atomic (for
      // non-simple lvalues) type.
      return convertAtomicTempToRValue(new Address(TempAddr), new AggValueSlot(ResultSlot), new SourceLocation(Loc), AsValue);
    }
    
    // Okay, we're doing this natively.
    Value /*P*/ Load = EmitAtomicLoadOp(AO, IsVolatile);
    
    // If we're ignoring an aggregate return, don't do anything.
    if (getEvaluationKind() == TypeEvaluationKind.TEK_Aggregate && ResultSlot.isIgnored()) {
      return RValue.getAggregate(Address.invalid(), false);
    }
    
    // Okay, turn that back into the original value or atomic (for non-simple
    // lvalues) type.
    return ConvertIntToValueOrAtomic(Load, new AggValueSlot(ResultSlot), new SourceLocation(Loc), AsValue);
  }

  
  /// \brief Emits atomic compare-and-exchange sequence.
  /// \param Expected Expected value.
  /// \param Desired Desired value.
  /// \param Success Atomic ordering for success operation.
  /// \param Failure Atomic ordering for failed operation.
  /// \param IsWeak true if atomic operation is weak, false otherwise.
  /// \returns Pair of values: previous value from storage (value type) and
  /// boolean flag (i1 type) with true if success and false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicCompareExchange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1457,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicCompareExchange", NM="_ZN12_GLOBAL__N_110AtomicInfo25EmitAtomicCompareExchangeEN5clang7CodeGen6RValueES3_N4llvm14AtomicOrderingES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo25EmitAtomicCompareExchangeEN5clang7CodeGen6RValueES3_N4llvm14AtomicOrderingES5_b")
  //</editor-fold>
  public std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(RValue Expected, RValue Desired) {
    return EmitAtomicCompareExchange(Expected, Desired, AtomicOrdering.SequentiallyConsistent, 
                           AtomicOrdering.SequentiallyConsistent, false);
  }
  public std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(RValue Expected, RValue Desired, AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/) {
    return EmitAtomicCompareExchange(Expected, Desired, Success, 
                           AtomicOrdering.SequentiallyConsistent, false);
  }
  public std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(RValue Expected, RValue Desired, AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, 
                           AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/) {
    return EmitAtomicCompareExchange(Expected, Desired, Success, 
                           Failure, false);
  }
  public std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(RValue Expected, RValue Desired, AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, 
                           AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/, boolean IsWeak/*= false*/) {
    if (isStrongerThan(Failure, Success)) {
      // Don't assert on undefined behavior "failure argument shall be no stronger
      // than the success argument".
      Failure = AtomicCmpXchgInst.getStrongestFailureOrdering(Success);
    }
    
    // Check whether we should use a library call.
    if (shouldUseLibcall()) {
      // Produce a source address.
      Address ExpectedAddr = materializeRValue(new RValue(Expected));
      Address DesiredAddr = materializeRValue(new RValue(Desired));
      Value /*P*/ Res = EmitAtomicCompareExchangeLibcall(ExpectedAddr.getPointer(), 
          DesiredAddr.getPointer(), 
          Success, Failure);
      return std.make_pair_T_Ptr(convertAtomicTempToRValue(new Address(ExpectedAddr), AggValueSlot.ignored(), 
              new SourceLocation(), /*AsValue=*/ false), 
          Res);
    }
    
    // If we've got a scalar value of the right size, try to avoid going
    // through memory.
    Value /*P*/ ExpectedVal = convertRValueToInt(new RValue(Expected));
    Value /*P*/ DesiredVal = convertRValueToInt(new RValue(Desired));
    std.pair<Value /*P*/ , Value /*P*/ > Res = EmitAtomicCompareExchangeOp(ExpectedVal, DesiredVal, Success, 
        Failure, IsWeak);
    return std.make_pair_T_Ptr(ConvertIntToValueOrAtomic(Res.first, AggValueSlot.ignored(), 
            new SourceLocation(), /*AsValue=*/ false), 
        Res.second);
  }

  
  /// \brief Emits atomic update.
  /// \param AO Atomic ordering.
  /// \param UpdateOp Update operation for the current lvalue.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1687,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicUpdate", NM="_ZN12_GLOBAL__N_110AtomicInfo16EmitAtomicUpdateEN4llvm14AtomicOrderingERKNS1_12function_refIFN5clang7CodeGen6RValueES6_EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo16EmitAtomicUpdateEN4llvm14AtomicOrderingERKNS1_12function_refIFN5clang7CodeGen6RValueES6_EEEb")
  //</editor-fold>
  public void EmitAtomicUpdate(AtomicOrdering AO, final /*const*/Type2Type<RValue> /*&*/ UpdateOp, 
                  boolean IsVolatile) {
    if (shouldUseLibcall()) {
      EmitAtomicUpdateLibcall(AO, UpdateOp, IsVolatile);
    } else {
      EmitAtomicUpdateOp(AO, UpdateOp, IsVolatile);
    }
  }

  /// \brief Emits atomic update.
  /// \param AO Atomic ordering.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1697,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicUpdate", NM="_ZN12_GLOBAL__N_110AtomicInfo16EmitAtomicUpdateEN4llvm14AtomicOrderingEN5clang7CodeGen6RValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo16EmitAtomicUpdateEN4llvm14AtomicOrderingEN5clang7CodeGen6RValueEb")
  //</editor-fold>
  public void EmitAtomicUpdate(AtomicOrdering AO, RValue UpdateRVal, 
                  boolean IsVolatile) {
    if (shouldUseLibcall()) {
      EmitAtomicUpdateLibcall(AO, new RValue(UpdateRVal), IsVolatile);
    } else {
      EmitAtomicUpdateOp(AO, new RValue(UpdateRVal), IsVolatile);
    }
  }

  
  /// Materialize an atomic r-value in atomic-layout memory.
  
  /// Materialize an r-value into memory for the purposes of storing it
  /// to an atomic type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::materializeRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1373,
   FQN="(anonymous namespace)::AtomicInfo::materializeRValue", NM="_ZNK12_GLOBAL__N_110AtomicInfo17materializeRValueEN5clang7CodeGen6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo17materializeRValueEN5clang7CodeGen6RValueE")
  //</editor-fold>
  public Address materializeRValue(RValue rvalue) /*const*/ {
    // Aggregate r-values are already in memory, and EmitAtomicStore
    // requires them to be values of the atomic type.
    if (rvalue.isAggregate()) {
      return rvalue.getAggregateAddress();
    }
    
    // Otherwise, make a temporary and materialize into it.
    LValue TempLV = CGF.MakeAddrLValue(CreateTempAlloca(), getAtomicType());
    AtomicInfo Atomics/*J*/= new AtomicInfo(CGF, TempLV);
    Atomics.emitCopyIntoMemory(new RValue(rvalue));
    return TempLV.getAddress();
  }

  
  /// \brief Creates temp alloca for intermediate operations on atomic value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::CreateTempAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 290,
   FQN="(anonymous namespace)::AtomicInfo::CreateTempAlloca", NM="_ZNK12_GLOBAL__N_110AtomicInfo16CreateTempAllocaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo16CreateTempAllocaEv")
  //</editor-fold>
  public Address CreateTempAlloca() /*const*/ {
    Address TempAlloca = CGF.CreateMemTemp(new QualType((LVal.isBitField() && $greater_ulong(ValueSizeInBits, AtomicSizeInBits)) ? ValueTy : AtomicTy), 
        getAtomicAlignment(), 
        new Twine(/*KEEP_STR*/"atomic-temp"));
    // Cast to pointer to value type for bitfields.
    if (LVal.isBitField()) {
      return CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(new Address(TempAlloca), getAtomicAddress().getType());
    }
    return TempAlloca;
  }

/*private:*/
  
  /// Does the atomic type require memsetting to zero before initialization?
  ///
  /// The IR type is provided as a way of making certain queries faster.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::requiresMemSetZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 323,
   FQN="(anonymous namespace)::AtomicInfo::requiresMemSetZero", NM="_ZNK12_GLOBAL__N_110AtomicInfo18requiresMemSetZeroEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK12_GLOBAL__N_110AtomicInfo18requiresMemSetZeroEPN4llvm4TypeE")
  //</editor-fold>
  private boolean requiresMemSetZero(org.llvm.ir.Type /*P*/ type) /*const*/ {
    // If the atomic type has size padding, we definitely need a memset.
    if (hasPadding()) {
      return true;
    }
    
    // Otherwise, do some simple heuristics to try to avoid it:
    switch (getEvaluationKind()) {
     case TEK_Scalar:
      // For scalars and complexes, check whether the store size of the
      // type uses the full size.
      return !isFullSizeType(CGF.CGM, type, AtomicSizeInBits);
     case TEK_Complex:
      return !isFullSizeType(CGF.CGM, type.getStructElementType(0), 
          $div_ulong_ullong(AtomicSizeInBits, $int2ullong(2)));
     case TEK_Aggregate:
      
      // Padding in structs has an undefined bit pattern.  User beware.
      return false;
    }
    throw new llvm_unreachable("bad evaluation kind");
  }

  
  /// \brief Emits atomic load as a libcall.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicLoadLibcall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1238,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicLoadLibcall", NM="_ZN12_GLOBAL__N_110AtomicInfo21EmitAtomicLoadLibcallEPN4llvm5ValueENS1_14AtomicOrderingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo21EmitAtomicLoadLibcallEPN4llvm5ValueENS1_14AtomicOrderingEb")
  //</editor-fold>
  private void EmitAtomicLoadLibcall(Value /*P*/ AddForLoaded, 
                       AtomicOrdering AO, boolean $Prm2) {
    CallArgList Args = null;
    try {
      // void __atomic_load(size_t size, void *mem, void *return, int order);
      Args/*J*/= new CallArgList();
      Args.add(RValue.get(getAtomicSizeValue()), CGF.getContext().getSizeType().$QualType());
      Args.add(RValue.get(CGF.EmitCastToVoidPtr(getAtomicPointer())), 
          CGF.getContext().VoidPtrTy.$QualType());
      Args.add(RValue.get(CGF.EmitCastToVoidPtr(AddForLoaded)), 
          CGF.getContext().VoidPtrTy.$QualType());
      Args.add(RValue.get(ConstantInt.get(CGF.IntTy, $int2ulong(((int)toCABI(AO).getValue())))), 
          CGF.getContext().IntTy.$QualType());
      emitAtomicLibcall(CGF, new StringRef(/*KEEP_STR*/"__atomic_load"), CGF.getContext().VoidTy.$QualType(), Args);
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }

  /// \brief Emits atomic load as LLVM instruction.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicLoadOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1253,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicLoadOp", NM="_ZN12_GLOBAL__N_110AtomicInfo16EmitAtomicLoadOpEN4llvm14AtomicOrderingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo16EmitAtomicLoadOpEN4llvm14AtomicOrderingEb")
  //</editor-fold>
  private Value /*P*/ EmitAtomicLoadOp(AtomicOrdering AO, 
                  boolean IsVolatile) {
    // Okay, we're doing this natively.
    Address Addr = getAtomicAddressAsAtomicIntPointer();
    LoadInst /*P*/ Load = CGF.Builder.CreateLoad(new Address(Addr), $("atomic-load"));
    Load.setAtomic(AO);
    
    // Other decoration.
    if (IsVolatile) {
      Load.setVolatile(true);
    }
    if ((LVal.getTBAAInfo() != null)) {
      CGF.CGM.DecorateInstructionWithTBAA(Load, LVal.getTBAAInfo());
    }
    return Load;
  }

  /// \brief Emits atomic compare-and-exchange op as a libcall.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicCompareExchangeLibcall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1430,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicCompareExchangeLibcall", NM="_ZN12_GLOBAL__N_110AtomicInfo32EmitAtomicCompareExchangeLibcallEPN4llvm5ValueES3_NS1_14AtomicOrderingES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo32EmitAtomicCompareExchangeLibcallEPN4llvm5ValueES3_NS1_14AtomicOrderingES4_")
  //</editor-fold>
  private Value /*P*/ EmitAtomicCompareExchangeLibcall(Value /*P*/ ExpectedAddr, 
                                  Value /*P*/ DesiredAddr) {
    return EmitAtomicCompareExchangeLibcall(ExpectedAddr, 
                                  DesiredAddr, 
                                  AtomicOrdering.SequentiallyConsistent, 
                                  AtomicOrdering.SequentiallyConsistent);
  }
  private Value /*P*/ EmitAtomicCompareExchangeLibcall(Value /*P*/ ExpectedAddr, 
                                  Value /*P*/ DesiredAddr, 
                                  AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/) {
    return EmitAtomicCompareExchangeLibcall(ExpectedAddr, 
                                  DesiredAddr, 
                                  Success, 
                                  AtomicOrdering.SequentiallyConsistent);
  }
  private Value /*P*/ EmitAtomicCompareExchangeLibcall(Value /*P*/ ExpectedAddr, 
                                  Value /*P*/ DesiredAddr, 
                                  AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, 
                                  AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/) {
    CallArgList Args = null;
    try {
      // bool __atomic_compare_exchange(size_t size, void *obj, void *expected,
      // void *desired, int success, int failure);
      Args/*J*/= new CallArgList();
      Args.add(RValue.get(getAtomicSizeValue()), CGF.getContext().getSizeType().$QualType());
      Args.add(RValue.get(CGF.EmitCastToVoidPtr(getAtomicPointer())), 
          CGF.getContext().VoidPtrTy.$QualType());
      Args.add(RValue.get(CGF.EmitCastToVoidPtr(ExpectedAddr)), 
          CGF.getContext().VoidPtrTy.$QualType());
      Args.add(RValue.get(CGF.EmitCastToVoidPtr(DesiredAddr)), 
          CGF.getContext().VoidPtrTy.$QualType());
      Args.add(RValue.get(ConstantInt.get(CGF.IntTy, $int2ulong(((int)toCABI(Success).getValue())))), 
          CGF.getContext().IntTy.$QualType());
      Args.add(RValue.get(ConstantInt.get(CGF.IntTy, $int2ulong(((int)toCABI(Failure).getValue())))), 
          CGF.getContext().IntTy.$QualType());
      RValue SuccessFailureRVal = emitAtomicLibcall(CGF, new StringRef(/*KEEP_STR*/"__atomic_compare_exchange"), 
          CGF.getContext().BoolTy.$QualType(), Args);
      
      return SuccessFailureRVal.getScalarVal();
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }

  /// \brief Emits atomic compare-and-exchange op as LLVM instruction.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicCompareExchangeOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1412,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicCompareExchangeOp", NM="_ZN12_GLOBAL__N_110AtomicInfo27EmitAtomicCompareExchangeOpEPN4llvm5ValueES3_NS1_14AtomicOrderingES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo27EmitAtomicCompareExchangeOpEPN4llvm5ValueES3_NS1_14AtomicOrderingES4_b")
  //</editor-fold>
  private std.pair<Value /*P*/ , Value /*P*/ > EmitAtomicCompareExchangeOp(Value /*P*/ ExpectedVal, Value /*P*/ DesiredVal) {
    return EmitAtomicCompareExchangeOp(ExpectedVal, DesiredVal, 
                             AtomicOrdering.SequentiallyConsistent, AtomicOrdering.SequentiallyConsistent, false);
  }
  private std.pair<Value /*P*/ , Value /*P*/ > EmitAtomicCompareExchangeOp(Value /*P*/ ExpectedVal, Value /*P*/ DesiredVal, 
                             AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/) {
    return EmitAtomicCompareExchangeOp(ExpectedVal, DesiredVal, 
                             Success, AtomicOrdering.SequentiallyConsistent, false);
  }
  private std.pair<Value /*P*/ , Value /*P*/ > EmitAtomicCompareExchangeOp(Value /*P*/ ExpectedVal, Value /*P*/ DesiredVal, 
                             AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/) {
    return EmitAtomicCompareExchangeOp(ExpectedVal, DesiredVal, 
                             Success, Failure, false);
  }
  private std.pair<Value /*P*/ , Value /*P*/ > EmitAtomicCompareExchangeOp(Value /*P*/ ExpectedVal, Value /*P*/ DesiredVal, 
                             AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/, boolean IsWeak/*= false*/) {
    // Do the atomic store.
    Address Addr = getAtomicAddressAsAtomicIntPointer();
    AtomicCmpXchgInst /*P*/ Inst = CGF.Builder.CreateAtomicCmpXchg(Addr.getPointer(), 
        ExpectedVal, DesiredVal, 
        Success, Failure);
    // Other decoration.
    Inst.setVolatile(LVal.isVolatileQualified());
    Inst.setWeak(IsWeak);
    
    // Okay, turn that back into the original value type.
    Value /*P*/ PreviousVal = CGF.Builder.CreateExtractValue(Inst, /*Idxs=*/ new ArrayRefUInt(0));
    Value /*P*/ SuccessFailureVal = CGF.Builder.CreateExtractValue(Inst, /*Idxs=*/ new ArrayRefUInt(1));
    return std.make_pair_Ptr_Ptr(PreviousVal, SuccessFailureVal);
  }

  /// \brief Emit atomic update as libcalls.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateLibcall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1545,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateLibcall", NM="_ZN12_GLOBAL__N_110AtomicInfo23EmitAtomicUpdateLibcallEN4llvm14AtomicOrderingERKNS1_12function_refIFN5clang7CodeGen6RValueES6_EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo23EmitAtomicUpdateLibcallEN4llvm14AtomicOrderingERKNS1_12function_refIFN5clang7CodeGen6RValueES6_EEEb")
  //</editor-fold>
  private void EmitAtomicUpdateLibcall(AtomicOrdering AO, final /*const*/Type2Type<RValue> /*&*/ UpdateOp, 
                         boolean IsVolatile) {
    AtomicOrdering Failure = AtomicCmpXchgInst.getStrongestFailureOrdering(AO);
    
    Address ExpectedAddr = CreateTempAlloca();
    
    EmitAtomicLoadLibcall(ExpectedAddr.getPointer(), AO, IsVolatile);
    BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_cont"));
    BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_exit"));
    CGF.EmitBlock(ContBB);
    Address DesiredAddr = CreateTempAlloca();
    if ((LVal.isBitField() && $uint2ullong($15bits_uint2uint(BFI.Size)) != ValueSizeInBits)
       || requiresMemSetZero(getAtomicAddress().getElementType())) {
      LoadInst /*P*/ OldVal = CGF.Builder.CreateLoad(new Address(ExpectedAddr));
      CGF.Builder.CreateStore(OldVal, new Address(DesiredAddr));
    }
    RValue OldRVal = convertAtomicTempToRValue(new Address(ExpectedAddr), 
        AggValueSlot.ignored(), 
        new SourceLocation(), /*AsValue=*/ false);
    EmitAtomicUpdateValue(CGF, /*Deref*/this, new RValue(OldRVal), UpdateOp, new Address(DesiredAddr));
    Value /*P*/ Res = EmitAtomicCompareExchangeLibcall(ExpectedAddr.getPointer(), 
        DesiredAddr.getPointer(), 
        AO, Failure);
    CGF.Builder.CreateCondBr(Res, ExitBB, ContBB);
    CGF.EmitBlock(ExitBB, /*IsFinished=*/ true);
  }

  /// \brief Emit atomic update as LLVM instructions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1574,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateOp", NM="_ZN12_GLOBAL__N_110AtomicInfo18EmitAtomicUpdateOpEN4llvm14AtomicOrderingERKNS1_12function_refIFN5clang7CodeGen6RValueES6_EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo18EmitAtomicUpdateOpEN4llvm14AtomicOrderingERKNS1_12function_refIFN5clang7CodeGen6RValueES6_EEEb")
  //</editor-fold>
  private void EmitAtomicUpdateOp(AtomicOrdering AO, final /*const*/Type2Type<RValue> /*&*/ UpdateOp, 
                    boolean IsVolatile) {
    AtomicOrdering Failure = AtomicCmpXchgInst.getStrongestFailureOrdering(AO);
    
    // Do the atomic load.
    Value /*P*/ OldVal = EmitAtomicLoadOp(AO, IsVolatile);
    // For non-simple lvalues perform compare-and-swap procedure.
    BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_cont"));
    BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_exit"));
    BasicBlock /*P*/ CurBB = CGF.Builder.GetInsertBlock();
    CGF.EmitBlock(ContBB);
    PHINode /*P*/ PHI = CGF.Builder.CreatePHI(OldVal.getType(), 
        /*NumReservedValues=*/ 2);
    PHI.addIncoming(OldVal, CurBB);
    Address NewAtomicAddr = CreateTempAlloca();
    Address NewAtomicIntAddr = emitCastToAtomicIntPointer(new Address(NewAtomicAddr));
    if ((LVal.isBitField() && $uint2ullong($15bits_uint2uint(BFI.Size)) != ValueSizeInBits)
       || requiresMemSetZero(getAtomicAddress().getElementType())) {
      CGF.Builder.CreateStore(PHI, new Address(NewAtomicIntAddr));
    }
    RValue OldRVal = ConvertIntToValueOrAtomic(PHI, AggValueSlot.ignored(), 
        new SourceLocation(), /*AsValue=*/ false);
    EmitAtomicUpdateValue(CGF, /*Deref*/this, new RValue(OldRVal), UpdateOp, new Address(NewAtomicAddr));
    LoadInst /*P*/ DesiredVal = CGF.Builder.CreateLoad(new Address(NewAtomicIntAddr));
    // Try to write new value using cmpxchg operation
    std.pair<Value /*P*/ , Value /*P*/ > Res = EmitAtomicCompareExchangeOp(PHI, DesiredVal, AO, Failure);
    PHI.addIncoming(Res.first, CGF.Builder.GetInsertBlock());
    CGF.Builder.CreateCondBr(Res.second, ExitBB, ContBB);
    CGF.EmitBlock(ExitBB, /*IsFinished=*/ true);
  }

  /// \brief Emit atomic update as libcalls.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateLibcall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1633,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateLibcall", NM="_ZN12_GLOBAL__N_110AtomicInfo23EmitAtomicUpdateLibcallEN4llvm14AtomicOrderingEN5clang7CodeGen6RValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo23EmitAtomicUpdateLibcallEN4llvm14AtomicOrderingEN5clang7CodeGen6RValueEb")
  //</editor-fold>
  private void EmitAtomicUpdateLibcall(AtomicOrdering AO, 
                         RValue UpdateRVal, boolean IsVolatile) {
    AtomicOrdering Failure = AtomicCmpXchgInst.getStrongestFailureOrdering(AO);
    
    Address ExpectedAddr = CreateTempAlloca();
    
    EmitAtomicLoadLibcall(ExpectedAddr.getPointer(), AO, IsVolatile);
    BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_cont"));
    BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_exit"));
    CGF.EmitBlock(ContBB);
    Address DesiredAddr = CreateTempAlloca();
    if ((LVal.isBitField() && $uint2ullong($15bits_uint2uint(BFI.Size)) != ValueSizeInBits)
       || requiresMemSetZero(getAtomicAddress().getElementType())) {
      LoadInst /*P*/ OldVal = CGF.Builder.CreateLoad(new Address(ExpectedAddr));
      CGF.Builder.CreateStore(OldVal, new Address(DesiredAddr));
    }
    EmitAtomicUpdateValue(CGF, /*Deref*/this, new RValue(UpdateRVal), new Address(DesiredAddr));
    Value /*P*/ Res = EmitAtomicCompareExchangeLibcall(ExpectedAddr.getPointer(), 
        DesiredAddr.getPointer(), 
        AO, Failure);
    CGF.Builder.CreateCondBr(Res, ExitBB, ContBB);
    CGF.EmitBlock(ExitBB, /*IsFinished=*/ true);
  }

  /// \brief Emit atomic update as LLVM instructions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1658,
   FQN="(anonymous namespace)::AtomicInfo::EmitAtomicUpdateOp", NM="_ZN12_GLOBAL__N_110AtomicInfo18EmitAtomicUpdateOpEN4llvm14AtomicOrderingEN5clang7CodeGen6RValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN12_GLOBAL__N_110AtomicInfo18EmitAtomicUpdateOpEN4llvm14AtomicOrderingEN5clang7CodeGen6RValueEb")
  //</editor-fold>
  private void EmitAtomicUpdateOp(AtomicOrdering AO, RValue UpdateRVal, 
                    boolean IsVolatile) {
    AtomicOrdering Failure = AtomicCmpXchgInst.getStrongestFailureOrdering(AO);
    
    // Do the atomic load.
    Value /*P*/ OldVal = EmitAtomicLoadOp(AO, IsVolatile);
    // For non-simple lvalues perform compare-and-swap procedure.
    BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_cont"));
    BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_exit"));
    BasicBlock /*P*/ CurBB = CGF.Builder.GetInsertBlock();
    CGF.EmitBlock(ContBB);
    PHINode /*P*/ PHI = CGF.Builder.CreatePHI(OldVal.getType(), 
        /*NumReservedValues=*/ 2);
    PHI.addIncoming(OldVal, CurBB);
    Address NewAtomicAddr = CreateTempAlloca();
    Address NewAtomicIntAddr = emitCastToAtomicIntPointer(new Address(NewAtomicAddr));
    if ((LVal.isBitField() && $uint2ullong($15bits_uint2uint(BFI.Size)) != ValueSizeInBits)
       || requiresMemSetZero(getAtomicAddress().getElementType())) {
      CGF.Builder.CreateStore(PHI, new Address(NewAtomicIntAddr));
    }
    EmitAtomicUpdateValue(CGF, /*Deref*/this, new RValue(UpdateRVal), new Address(NewAtomicAddr));
    LoadInst /*P*/ DesiredVal = CGF.Builder.CreateLoad(new Address(NewAtomicIntAddr));
    // Try to write new value using cmpxchg operation
    std.pair<Value /*P*/ , Value /*P*/ > Res = EmitAtomicCompareExchangeOp(PHI, DesiredVal, AO, Failure);
    PHI.addIncoming(Res.first, CGF.Builder.GetInsertBlock());
    CGF.Builder.CreateCondBr(Res.second, ExitBB, ContBB);
    CGF.EmitBlock(ExitBB, /*IsFinished=*/ true);
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", AtomicTy=" + AtomicTy // NOI18N
              + ", ValueTy=" + ValueTy // NOI18N
              + ", AtomicSizeInBits=" + AtomicSizeInBits // NOI18N
              + ", ValueSizeInBits=" + ValueSizeInBits // NOI18N
              + ", AtomicAlign=" + AtomicAlign // NOI18N
              + ", ValueAlign=" + ValueAlign // NOI18N
              + ", LValueAlign=" + LValueAlign // NOI18N
              + ", EvaluationKind=" + EvaluationKind // NOI18N
              + ", UseLibcall=" + UseLibcall // NOI18N
              + ", LVal=" + LVal // NOI18N
              + ", BFI=" + BFI; // NOI18N
  }
}
