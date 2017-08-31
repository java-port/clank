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

package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 440,
 FQN="llvm::ConstantExprKeyType", NM="_ZN4llvm19ConstantExprKeyTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantExprKeyTypeE")
//</editor-fold>
public class/*struct*/ ConstantExprKeyType implements Native.NativeComparable<ConstantExprKeyType> {
  public byte/*uint8_t*/ Opcode;
  public byte/*uint8_t*/ SubclassOptionalData;
  public /*uint16_t*/char SubclassData;
  public ArrayRef<Constant /*P*/ > Ops;
  public ArrayRefUInt Indexes;
  public Type /*P*/ ExplicitTy;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::ConstantExprKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 448,
   FQN="llvm::ConstantExprKeyType::ConstantExprKeyType", NM="_ZN4llvm19ConstantExprKeyTypeC1EjNS_8ArrayRefIPNS_8ConstantEEEttNS1_IjEEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantExprKeyTypeC1EjNS_8ArrayRefIPNS_8ConstantEEEttNS1_IjEEPNS_4TypeE")
  //</editor-fold>
  public ConstantExprKeyType(/*uint*/int Opcode, ArrayRef<Constant /*P*/ > Ops) {
    this(Opcode, Ops, 
      $int2ushort(0), 
      $int2ushort(0), 
      new ArrayRefUInt(None), 
      (Type /*P*/ )null);
  }
  public ConstantExprKeyType(/*uint*/int Opcode, ArrayRef<Constant /*P*/ > Ops, 
      /*ushort*/char SubclassData/*= 0*/) {
    this(Opcode, Ops, 
      SubclassData, 
      $int2ushort(0), 
      new ArrayRefUInt(None), 
      (Type /*P*/ )null);
  }
  public ConstantExprKeyType(/*uint*/int Opcode, ArrayRef<Constant /*P*/ > Ops, 
      /*ushort*/char SubclassData/*= 0*/, 
      /*ushort*/char SubclassOptionalData/*= 0*/) {
    this(Opcode, Ops, 
      SubclassData, 
      SubclassOptionalData, 
      new ArrayRefUInt(None), 
      (Type /*P*/ )null);
  }
  public ConstantExprKeyType(/*uint*/int Opcode, ArrayRef<Constant /*P*/ > Ops, 
      /*ushort*/char SubclassData/*= 0*/, 
      /*ushort*/char SubclassOptionalData/*= 0*/, 
      ArrayRefUInt Indexes/*= None*/) {
    this(Opcode, Ops, 
      SubclassData, 
      SubclassOptionalData, 
      Indexes, 
      (Type /*P*/ )null);
  }
  public ConstantExprKeyType(/*uint*/int Opcode, ArrayRef<Constant /*P*/ > Ops, 
      /*ushort*/char SubclassData/*= 0*/, 
      /*ushort*/char SubclassOptionalData/*= 0*/, 
      ArrayRefUInt Indexes/*= None*/, 
      Type /*P*/ ExplicitTy/*= null*/) {
    // : Opcode(Opcode), SubclassOptionalData(SubclassOptionalData), SubclassData(SubclassData), Ops(Ops), Indexes(Indexes), ExplicitTy(ExplicitTy) 
    //START JInit
    this.Opcode = $uint2uchar(Opcode);
    this.SubclassOptionalData = $ushort2uchar(SubclassOptionalData);
    this.SubclassData = SubclassData;
    this.Ops = new ArrayRef<Constant /*P*/ >(Ops);
    this.Indexes = new ArrayRefUInt(Indexes);
    this.ExplicitTy = ExplicitTy;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::ConstantExprKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 456,
   FQN="llvm::ConstantExprKeyType::ConstantExprKeyType", NM="_ZN4llvm19ConstantExprKeyTypeC1ENS_8ArrayRefIPNS_8ConstantEEEPKNS_12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantExprKeyTypeC1ENS_8ArrayRefIPNS_8ConstantEEEPKNS_12ConstantExprE")
  //</editor-fold>
  public ConstantExprKeyType(ArrayRef<Constant /*P*/ > Operands, /*const*/ ConstantExpr /*P*/ CE) {
    // : Opcode(CE->getOpcode()), SubclassOptionalData(CE->getRawSubclassOptionalData()), SubclassData(CE->isCompare() ? CE->getPredicate() : 0), Ops(Operands), Indexes(CE->hasIndices() ? CE->getIndices() : ArrayRef<unsigned int>()) 
    //START JInit
    this.Opcode = $uint2uchar(CE.getOpcode());
    this.SubclassOptionalData = $uint2uchar(CE.getRawSubclassOptionalData());
    this.SubclassData = $uint2ushort(CE.isCompare() ? CE.getPredicate() : 0);
    this.Ops = new ArrayRef<Constant /*P*/ >(Operands);
    this.Indexes = CE.hasIndices() ? CE.getIndices() : new ArrayRefUInt();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::ConstantExprKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 461,
   FQN="llvm::ConstantExprKeyType::ConstantExprKeyType", NM="_ZN4llvm19ConstantExprKeyTypeC1EPKNS_12ConstantExprERNS_15SmallVectorImplIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantExprKeyTypeC1EPKNS_12ConstantExprERNS_15SmallVectorImplIPNS_8ConstantEEE")
  //</editor-fold>
  public ConstantExprKeyType(/*const*/ ConstantExpr /*P*/ CE, 
      final SmallVectorImpl<Constant /*P*/ > /*&*/ Storage) {
    // : Opcode(CE->getOpcode()), SubclassOptionalData(CE->getRawSubclassOptionalData()), SubclassData(CE->isCompare() ? CE->getPredicate() : 0), Ops(), Indexes(CE->hasIndices() ? CE->getIndices() : ArrayRef<unsigned int>()) 
    //START JInit
    this.Opcode = $uint2uchar(CE.getOpcode());
    this.SubclassOptionalData = $uint2uchar(CE.getRawSubclassOptionalData());
    this.SubclassData = $uint2ushort(CE.isCompare() ? CE.getPredicate() : 0);
    this.Ops = new ArrayRef<Constant /*P*/ >(true);
    this.Indexes = CE.hasIndices() ? CE.getIndices() : new ArrayRefUInt();
    //END JInit
    assert (Storage.empty()) : "Expected empty storage";
    for (/*uint*/int I = 0, E = CE.getNumOperands(); I != E; ++I)  {
      Storage.push_back(CE.getOperand_Constant(I));
    }
    Ops.$assignMove(new ArrayRef<Constant /*P*/ >(Storage, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 473,
   FQN="llvm::ConstantExprKeyType::operator==", NM="_ZNK4llvm19ConstantExprKeyTypeeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantExprKeyTypeeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ConstantExprKeyType /*&*/ X) /*const*/ {
    return $uchar2int(Opcode) == $uchar2int(X.Opcode) && $ushort2int(SubclassData) == $ushort2int(X.SubclassData)
       && $uchar2int(SubclassOptionalData) == $uchar2int(X.SubclassOptionalData) && $eq_ArrayRef$T(/*NO_COPY*/Ops, /*NO_COPY*/X.Ops)
       && $eq_ArrayRef$T(/*NO_COPY*/Indexes, /*NO_COPY*/X.Indexes);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 479,
   FQN="llvm::ConstantExprKeyType::operator==", NM="_ZNK4llvm19ConstantExprKeyTypeeqEPKNS_12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantExprKeyTypeeqEPKNS_12ConstantExprE")
  //</editor-fold>
  public boolean $eq(/*const*/ ConstantExpr /*P*/ CE) /*const*/ {
    if ($uchar2uint(Opcode) != CE.getOpcode()) {
      return false;
    }
    if ($uchar2uint(SubclassOptionalData) != CE.getRawSubclassOptionalData()) {
      return false;
    }
    if (Ops.size() != CE.getNumOperands()) {
      return false;
    }
    if ($ushort2uint(SubclassData) != (CE.isCompare() ? CE.getPredicate() : 0)) {
      return false;
    }
    for (/*uint*/int I = 0, E = Ops.size(); I != E; ++I)  {
      if (Ops.$at(I) != CE.getOperand_Constant(I)) {
        return false;
      }
    }
    if ($noteq_ArrayRef$T(/*NO_COPY*/Indexes, (CE.hasIndices() ? CE.getIndices() : new ArrayRefUInt()))) {
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::getHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 496,
   FQN="llvm::ConstantExprKeyType::getHash", NM="_ZNK4llvm19ConstantExprKeyType7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantExprKeyType7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    return hash_combine(Opcode, SubclassOptionalData, SubclassData, 
        hash_combine_range_ptrs(Ops.begin(), Ops.end()), 
        hash_combine_range(Indexes.begin(), Indexes.end())).$uint();
  }

  
  // JAVA: typedef ConstantInfo<ConstantExpr>::TypeClass TypeClass
//  public final class TypeClass extends Type{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 503,
   FQN="llvm::ConstantExprKeyType::create", NM="_ZNK4llvm19ConstantExprKeyType6createEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantExprKeyType6createEPNS_4TypeE")
  //</editor-fold>
  public ConstantExpr /*P*/ create(Type /*P*/ Ty) /*const*/ {
    switch ($uchar2int(Opcode)) {
     default:
      if (Instruction.isCast($uchar2uint(Opcode))) {
        return /*NEW_EXPR [UnaryConstantExpr::new]*/UnaryConstantExpr.$new_UnaryConstantExpr((type$ptr<?> New$Mem)->{
            return new UnaryConstantExpr($uchar2uint(Opcode), Ops.$at(0), Ty);
         });
      }
      if (($uchar2int(Opcode) >= Instruction.BinaryOps.BinaryOpsBegin
         && $uchar2int(Opcode) < Instruction.BinaryOps.BinaryOpsEnd)) {
        return /*NEW_EXPR [BinaryConstantExpr::new]*/BinaryConstantExpr.$new_BinaryConstantExpr((type$ptr<?> New$Mem)->{
            return new BinaryConstantExpr($uchar2uint(Opcode), Ops.$at(0), Ops.$at(1), 
                    $uchar2uint(SubclassOptionalData));
         });
      }
      throw new llvm_unreachable("Invalid ConstantExpr!");
     case Instruction.OtherOps.Select:
      return /*NEW_EXPR [SelectConstantExpr::new]*/SelectConstantExpr.$new_SelectConstantExpr((type$ptr<?> New$Mem)->{
          return new SelectConstantExpr(Ops.$at(0), Ops.$at(1), Ops.$at(2));
       });
     case Instruction.OtherOps.ExtractElement:
      return /*NEW_EXPR [ExtractElementConstantExpr::new]*/ExtractElementConstantExpr.$new_ExtractElementConstantExpr((type$ptr<?> New$Mem)->{
          return new ExtractElementConstantExpr(Ops.$at(0), Ops.$at(1));
       });
     case Instruction.OtherOps.InsertElement:
      return /*NEW_EXPR [InsertElementConstantExpr::new]*/InsertElementConstantExpr.$new_InsertElementConstantExpr((type$ptr<?> New$Mem)->{
          return new InsertElementConstantExpr(Ops.$at(0), Ops.$at(1), Ops.$at(2));
       });
     case Instruction.OtherOps.ShuffleVector:
      return /*NEW_EXPR [ShuffleVectorConstantExpr::new]*/ShuffleVectorConstantExpr.$new_ShuffleVectorConstantExpr((type$ptr<?> New$Mem)->{
          return new ShuffleVectorConstantExpr(Ops.$at(0), Ops.$at(1), Ops.$at(2));
       });
     case Instruction.OtherOps.InsertValue:
      return /*NEW_EXPR [InsertValueConstantExpr::new]*/InsertValueConstantExpr.$new_InsertValueConstantExpr((type$ptr<?> New$Mem)->{
          return new InsertValueConstantExpr(Ops.$at(0), Ops.$at(1), new ArrayRefUInt(Indexes), Ty);
       });
     case Instruction.OtherOps.ExtractValue:
      return /*NEW_EXPR [ExtractValueConstantExpr::new]*/ExtractValueConstantExpr.$new_ExtractValueConstantExpr((type$ptr<?> New$Mem)->{
          return new ExtractValueConstantExpr(Ops.$at(0), new ArrayRefUInt(Indexes), Ty);
       });
     case Instruction.MemoryOps.GetElementPtr:
      return GetElementPtrConstantExpr.Create((ExplicitTy != null) ? ExplicitTy : cast_PointerType(Ops.$at(0).getType().getScalarType()).
              getElementType(), 
          Ops.$at(0), Ops.slice(1), Ty, $uchar2uint(SubclassOptionalData));
     case Instruction.OtherOps.ICmp:
      return /*NEW_EXPR [CompareConstantExpr::new]*/CompareConstantExpr.$new_CompareConstantExpr((type$ptr<?> New$Mem)->{
          return new CompareConstantExpr(Ty, Instruction.OtherOps.ICmp, SubclassData, 
                  Ops.$at(0), Ops.$at(1));
       });
     case Instruction.OtherOps.FCmp:
      return /*NEW_EXPR [CompareConstantExpr::new]*/CompareConstantExpr.$new_CompareConstantExpr((type$ptr<?> New$Mem)->{
          return new CompareConstantExpr(Ty, Instruction.OtherOps.FCmp, SubclassData, 
                  Ops.$at(0), Ops.$at(1));
       });
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::ConstantExprKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 440,
   FQN="llvm::ConstantExprKeyType::ConstantExprKeyType", NM="_ZN4llvm19ConstantExprKeyTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantExprKeyTypeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ConstantExprKeyType(final /*const*/ ConstantExprKeyType /*&*/ $Prm0) {
    // : Opcode(.Opcode), SubclassOptionalData(.SubclassOptionalData), SubclassData(.SubclassData), Ops(.Ops), Indexes(.Indexes), ExplicitTy(.ExplicitTy) 
    //START JInit
    this.Opcode = $Prm0.Opcode;
    this.SubclassOptionalData = $Prm0.SubclassOptionalData;
    this.SubclassData = $Prm0.SubclassData;
    this.Ops = new ArrayRef<Constant /*P*/ >($Prm0.Ops);
    this.Indexes = new ArrayRefUInt($Prm0.Indexes);
    this.ExplicitTy = $Prm0.ExplicitTy;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExprKeyType::ConstantExprKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 440,
   FQN="llvm::ConstantExprKeyType::ConstantExprKeyType", NM="_ZN4llvm19ConstantExprKeyTypeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantExprKeyTypeC1EOS0_")
  //</editor-fold>
  public /*inline*/ ConstantExprKeyType(JD$Move _dparam, final ConstantExprKeyType /*&&*/$Prm0) {
    // : Opcode(static_cast<ConstantExprKeyType &&>().Opcode), SubclassOptionalData(static_cast<ConstantExprKeyType &&>().SubclassOptionalData), SubclassData(static_cast<ConstantExprKeyType &&>().SubclassData), Ops(static_cast<ConstantExprKeyType &&>().Ops), Indexes(static_cast<ConstantExprKeyType &&>().Indexes), ExplicitTy(static_cast<ConstantExprKeyType &&>().ExplicitTy) 
    //START JInit
    this.Opcode = $Prm0.Opcode;
    this.SubclassOptionalData = $Prm0.SubclassOptionalData;
    this.SubclassData = $Prm0.SubclassData;
    this.Ops = new ArrayRef<Constant /*P*/ >(JD$Move.INSTANCE, $Prm0.Ops);
    this.Indexes = new ArrayRefUInt(JD$Move.INSTANCE, $Prm0.Indexes);
    this.ExplicitTy = $Prm0.ExplicitTy;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Opcode=" + $uchar2uint(Opcode) // NOI18N
              + ", SubclassOptionalData=" + $uchar2uint(SubclassOptionalData) // NOI18N
              + ", SubclassData=" + $ushort2uint(SubclassData) // NOI18N
              + ", Ops=" + Ops // NOI18N
              + ", Indexes=" + Indexes // NOI18N
              + ", ExplicitTy=" + ExplicitTy; // NOI18N
  }
}
