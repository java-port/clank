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

package org.clang.codegen.target.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6583,
 FQN="(anonymous namespace)::HexagonABIInfo", NM="_ZN12_GLOBAL__N_114HexagonABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114HexagonABIInfoE")
//</editor-fold>
public class HexagonABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo::HexagonABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6587,
   FQN="(anonymous namespace)::HexagonABIInfo::HexagonABIInfo", NM="_ZN12_GLOBAL__N_114HexagonABIInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114HexagonABIInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public HexagonABIInfo(final CodeGenTypes /*&*/ CGT) {
    // : ABIInfo(CGT) 
    //START JInit
    super(CGT);
    //END JInit
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6650,
   FQN="(anonymous namespace)::HexagonABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_114HexagonABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114HexagonABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  private ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    
    // Large vector types should be returned via memory.
    if (RetTy.$arrow().isVectorType() && $greater_ulong_ullong(getContext().getTypeSize(new QualType(RetTy)), $int2ullong(64))) {
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    if (!isAggregateTypeForABI(new QualType(RetTy))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (RetTy.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    if (isEmptyRecord(getContext(), new QualType(RetTy), true)) {
      return ABIArgInfo.getIgnore();
    }
    
    // Aggregates <= 8 bytes are returned in r0; other aggregates
    // are returned indirectly.
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
    if ($lesseq_ulong_ullong(Size, $int2ullong(64))) {
      // Return in the smallest viable integer type.
      if ($lesseq_ulong_ullong(Size, $int2ullong(8))) {
        return ABIArgInfo.getDirect(Type.getInt8Ty(getVMContext()));
      }
      if ($lesseq_ulong_ullong(Size, $int2ullong(16))) {
        return ABIArgInfo.getDirect(Type.getInt16Ty(getVMContext()));
      }
      if ($lesseq_ulong_ullong(Size, $int2ullong(32))) {
        return ABIArgInfo.getDirect(Type.getInt32Ty(getVMContext()));
      }
      return ABIArgInfo.getDirect(Type.getInt64Ty(getVMContext()));
    }
    
    return getNaturalAlignIndirect(new QualType(RetTy), /*ByVal=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6619,
   FQN="(anonymous namespace)::HexagonABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_114HexagonABIInfo20classifyArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114HexagonABIInfo20classifyArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  private ABIArgInfo classifyArgumentType(QualType Ty) /*const*/ {
    if (!isAggregateTypeForABI(new QualType(Ty))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          Ty.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (Ty.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    
    // Ignore empty records.
    if (isEmptyRecord(getContext(), new QualType(Ty), true)) {
      return ABIArgInfo.getIgnore();
    }
    {
      
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
      if ((RAA.getValue() != 0)) {
        return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
      }
    }
    
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
    if ($greater_ulong_ullong(Size, $int2ullong(64))) {
      return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ true);
    } else // Pass in the smallest viable integer type.
    if ($greater_ulong_ullong(Size, $int2ullong(32))) {
      return ABIArgInfo.getDirect(Type.getInt64Ty(getVMContext()));
    } else if ($greater_ulong_ullong(Size, $int2ullong(16))) {
      return ABIArgInfo.getDirect(Type.getInt32Ty(getVMContext()));
    } else if ($greater_ulong_ullong(Size, $int2ullong(8))) {
      return ABIArgInfo.getDirect(Type.getInt16Ty(getVMContext()));
    } else {
      return ABIArgInfo.getDirect(Type.getInt8Ty(getVMContext()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6612,
   FQN="(anonymous namespace)::HexagonABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_114HexagonABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114HexagonABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public/*private*/ void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6687,
   FQN="(anonymous namespace)::HexagonABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_114HexagonABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114HexagonABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    // FIXME: Someone needs to audit that this handle alignment correctly.
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), /*indirect*/ false, 
        getContext().getTypeInfoInChars(new QualType(Ty)), 
        CharUnits.fromQuantity(4), 
        /*AllowHigherAlign*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HexagonABIInfo::~HexagonABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6583,
   FQN="(anonymous namespace)::HexagonABIInfo::~HexagonABIInfo", NM="_ZN12_GLOBAL__N_114HexagonABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114HexagonABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
