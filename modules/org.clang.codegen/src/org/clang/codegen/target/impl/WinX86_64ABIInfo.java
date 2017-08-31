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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;


/// WinX86_64ABIInfo - The Windows X86_64 ABI information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1980,
 FQN="(anonymous namespace)::WinX86_64ABIInfo", NM="_ZN12_GLOBAL__N_116WinX86_64ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_116WinX86_64ABIInfoE")
//</editor-fold>
public class WinX86_64ABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::WinX86_64ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1982,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::WinX86_64ABIInfo", NM="_ZN12_GLOBAL__N_116WinX86_64ABIInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_116WinX86_64ABIInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public WinX86_64ABIInfo(final CodeGenTypes /*&*/ CGT) {
    // : ABIInfo(CGT), IsMingw64(getTarget().getTriple().isWindowsGNUEnvironment()) 
    //START JInit
    super(CGT);
    this.IsMingw64 = getTarget().getTriple().isWindowsGNUEnvironment();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3607,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_116WinX86_64ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_116WinX86_64ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    boolean IsVectorCall = FI.getCallingConvention() == org.llvm.ir.CallingConv.X86_VectorCall;
    
    // We can use up to 4 SSE return registers with vectorcall.
    uint$ref FreeSSERegs = create_uint$ref(IsVectorCall ? 4 : 0);
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classify(FI.getReturnType().$QualType(), FreeSSERegs, true));
    }
    
    // We can use up to 6 SSE register parameters with vectorcall.
    FreeSSERegs.$set(IsVectorCall ? 6 : 0);
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classify(I.type.$QualType(), FreeSSERegs, false));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3622,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_116WinX86_64ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_116WinX86_64ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), /*indirect*/ false, 
        CGF.getContext().getTypeInfoInChars(new QualType(Ty)), 
        CharUnits.fromQuantity(8), 
        /*allowHigherAlign*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::isHomogeneousAggregateBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1991,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::isHomogeneousAggregateBaseType", NM="_ZNK12_GLOBAL__N_116WinX86_64ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_116WinX86_64ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean isHomogeneousAggregateBaseType(QualType Ty) /*const*//* override*/ {
    // FIXME: Assumes vectorcall is in use.
    return isX86VectorTypeForVectorCall(getContext(), new QualType(Ty));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::isHomogeneousAggregateSmallEnough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1996,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::isHomogeneousAggregateSmallEnough", NM="_ZNK12_GLOBAL__N_116WinX86_64ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_116WinX86_64ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy")
  //</editor-fold>
  @Override public boolean isHomogeneousAggregateSmallEnough(/*const*/ org.clang.ast.Type /*P*/ Ty, 
                                   long/*uint64_t*/ NumMembers) /*const*//* override*/ {
    // FIXME: Assumes vectorcall is in use.
    return isX86VectorCallAggregateSmallEnough(NumMembers);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::classify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3532,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::classify", NM="_ZNK12_GLOBAL__N_116WinX86_64ABIInfo8classifyEN5clang8QualTypeERjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_116WinX86_64ABIInfo8classifyEN5clang8QualTypeERjb")
  //</editor-fold>
  private ABIArgInfo classify(QualType Ty, final uint$ref/*uint &*/ FreeSSERegs, 
          boolean IsReturnType) /*const*/ {
    if (Ty.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    {
      
      /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        Ty.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    TypeInfo Info = getContext().getTypeInfo(new QualType(Ty));
    long/*uint64_t*/ Width = Info.Width;
    CharUnits Align = getContext().toCharUnitsFromBits($uint2long(Info.Align));
    
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if ((RT != null)) {
      if (!IsReturnType) {
        {
          CGCXXABI.RecordArgABI RAA = getRecordArgABI(RT, getCXXABI());
          if ((RAA.getValue() != 0)) {
            return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
          }
        }
      }
      if (RT.getDecl().hasFlexibleArrayMember()) {
        return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
      }
    }
    
    // vectorcall adds the concept of a homogenous vector aggregate, similar to
    // other targets.
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref NumElts = create_ulong$ref($int2ulong(0));
    if ((FreeSSERegs.$deref() != 0) && isHomogeneousAggregate(new QualType(Ty), Base, NumElts)) {
      if ($greatereq_uint_ulong(FreeSSERegs.$deref(), NumElts.$deref())) {
        FreeSSERegs.$set$minusassign((int) NumElts.$deref());
        if (IsReturnType || Ty.$arrow().isBuiltinType() || Ty.$arrow().isVectorType()) {
          return ABIArgInfo.getDirect();
        }
        return ABIArgInfo.getExpand();
      }
      return ABIArgInfo.getIndirect(new CharUnits(Align), /*ByVal=*/ false);
    }
    if (Ty.$arrow().isMemberPointerType()) {
      // If the member pointer is represented by an LLVM int or ptr, pass it
      // directly.
      Type /*P*/ LLTy = CGT.ConvertType(new QualType(Ty));
      if (LLTy.isPointerTy() || LLTy.isIntegerTy()) {
        return ABIArgInfo.getDirect();
      }
    }
    if ((RT != null) || Ty.$arrow().isAnyComplexType() || Ty.$arrow().isMemberPointerType()) {
      // MS x64 ABI requirement: "Any argument that doesn't fit in 8 bytes, or is
      // not 1, 2, 4, or 8 bytes, must be passed by reference."
      if ($greater_ulong_ullong(Width, $int2ullong(64)) || !llvm.isPowerOf2_64(Width)) {
        return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
      }
      
      // Otherwise, coerce it to a small integer.
      return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), $ulong2uint(Width)));
    }
    
    // Bool type is always extended to the ABI, other builtin types are not
    // extended.
    /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
    if ((BT != null) && BT.getKind() == BuiltinType.Kind.Bool) {
      return ABIArgInfo.getExtend();
    }
    
    // Mingw64 GCC uses the old 80 bit extended precision floating point unit. It
    // passes them indirectly through memory.
    if (IsMingw64 && (BT != null) && BT.getKind() == BuiltinType.Kind.LongDouble) {
      /*const*/ fltSemantics /*P*/ LDF = /*AddrOf*/getTarget().getLongDoubleFormat();
      if (LDF == /*AddrOf*/APFloat.x87DoubleExtended) {
        return ABIArgInfo.getIndirect(new CharUnits(Align), /*ByVal=*/ false);
      }
    }
    
    return ABIArgInfo.getDirect();
  }

  
  private boolean IsMingw64;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WinX86_64ABIInfo::~WinX86_64ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1980,
   FQN="(anonymous namespace)::WinX86_64ABIInfo::~WinX86_64ABIInfo", NM="_ZN12_GLOBAL__N_116WinX86_64ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_116WinX86_64ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "IsMingw64=" + IsMingw64 // NOI18N
              + super.toString(); // NOI18N
  }
}
