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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6701,
 FQN="(anonymous namespace)::LanaiABIInfo", NM="_ZN12_GLOBAL__N_112LanaiABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_112LanaiABIInfoE")
//</editor-fold>
public class LanaiABIInfo extends /*public*/ DefaultABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo::LanaiABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6703,
   FQN="(anonymous namespace)::LanaiABIInfo::LanaiABIInfo", NM="_ZN12_GLOBAL__N_112LanaiABIInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_112LanaiABIInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public LanaiABIInfo(final CodeGenTypes /*&*/ CGT) {
    // : DefaultABIInfo(CGT) 
    //START JInit
    super(CGT);
    //END JInit
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo::shouldUseInReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6728,
   FQN="(anonymous namespace)::LanaiABIInfo::shouldUseInReg", NM="_ZNK12_GLOBAL__N_112LanaiABIInfo14shouldUseInRegEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_112LanaiABIInfo14shouldUseInRegEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  public boolean shouldUseInReg(QualType Ty, final CCState /*&*/ State) /*const*/ {
    /*uint*/int Size = $ulong2uint(getContext().getTypeSize(new QualType(Ty)));
    /*uint*/int SizeInRegs = $ullong2uint($div_ulong_uint(llvm.alignTo($uint2ulong(Size), $uint2ulong(32/*U*/)), 32/*U*/));
    if (SizeInRegs == 0) {
      return false;
    }
    if ($greater_uint(SizeInRegs, State.FreeRegs)) {
      State.FreeRegs = 0;
      return false;
    }
    
    State.FreeRegs -= SizeInRegs;
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6707,
   FQN="(anonymous namespace)::LanaiABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_112LanaiABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_112LanaiABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    CCState State/*J*/= new CCState(FI.getCallingConvention());
    // Lanai uses 4 registers to pass arguments unless the function has the
    // regparm attribute set.
    if (FI.getHasRegParm()) {
      State.FreeRegs = FI.getRegParm();
    } else {
      State.FreeRegs = 4;
    }
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType(), State));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo::getIndirectResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6745,
   FQN="(anonymous namespace)::LanaiABIInfo::getIndirectResult", NM="_ZNK12_GLOBAL__N_112LanaiABIInfo17getIndirectResultEN5clang8QualTypeEbRNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_112LanaiABIInfo17getIndirectResultEN5clang8QualTypeEbRNS_7CCStateE")
  //</editor-fold>
  public ABIArgInfo getIndirectResult(QualType Ty, boolean ByVal, 
                   final CCState /*&*/ State) /*const*/ {
    if (!ByVal) {
      if ((State.FreeRegs != 0)) {
        --State.FreeRegs; // Non-byval indirects just use one pointer.
        return getNaturalAlignIndirectInReg(new QualType(Ty));
      }
      return getNaturalAlignIndirect(new QualType(Ty), false);
    }
    
    // Compute the byval alignment.
    /*const*//*uint*/int MinABIStackAlignInBytes = 4;
    /*uint*/int TypeAlign = $div_uint(getContext().getTypeAlign(new QualType(Ty)), 8);
    return ABIArgInfo.getIndirect(CharUnits.fromQuantity(4), /*ByVal=*/ true, 
        /*Realign=*/ $greater_uint(TypeAlign
          , MinABIStackAlignInBytes));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6763,
   FQN="(anonymous namespace)::LanaiABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_112LanaiABIInfo20classifyArgumentTypeEN5clang8QualTypeERNS_7CCStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_112LanaiABIInfo20classifyArgumentTypeEN5clang8QualTypeERNS_7CCStateE")
  //</editor-fold>
  public ABIArgInfo classifyArgumentType(QualType Ty, 
                      final CCState /*&*/ State) /*const*/ {
    // Check with the C++ ABI first.
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if ((RT != null)) {
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(RT, getCXXABI());
      if (RAA == CGCXXABI.RecordArgABI.RAA_Indirect) {
        return getIndirectResult(new QualType(Ty), /*ByVal=*/ false, State);
      } else if (RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory) {
        return getNaturalAlignIndirect(new QualType(Ty), /*ByRef=*/ true);
      }
    }
    if (isAggregateTypeForABI(new QualType(Ty))) {
      // Structures with flexible arrays are always indirect.
      if ((RT != null) && RT.getDecl().hasFlexibleArrayMember()) {
        return getIndirectResult(new QualType(Ty), /*ByVal=*/ true, State);
      }
      
      // Ignore empty structs/unions.
      if (isEmptyRecord(getContext(), new QualType(Ty), true)) {
        return ABIArgInfo.getIgnore();
      }
      
      final LLVMContext /*&*/ $LLVMContext = getVMContext();
      /*uint*/int SizeInRegs = $ullong2uint($div_ullong((getContext().getTypeSize(new QualType(Ty)) + $int2ullong(31)), $int2ullong(32)));
      if ($lesseq_uint(SizeInRegs, State.FreeRegs)) {
        IntegerType /*P*/ Int32 = Type.getInt32Ty($LLVMContext);
        SmallVector<Type /*P*/ > Elements/*J*/= new SmallVector<Type /*P*/ >(JD$UInt_T$C$R.INSTANCE, 3, SizeInRegs, Int32, (Type /*P*/ )null);
        Type /*P*/ Result = StructType.get($LLVMContext, new ArrayRef<Type /*P*/ >(Elements, true));
        State.FreeRegs -= SizeInRegs;
        return ABIArgInfo.getDirectInReg(Result);
      } else {
        State.FreeRegs = 0;
      }
      return getIndirectResult(new QualType(Ty), true, State);
    }
    {
      
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        Ty.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    boolean InReg = shouldUseInReg(new QualType(Ty), State);
    if (Ty.$arrow().isPromotableIntegerType()) {
      if (InReg) {
        return ABIArgInfo.getDirectInReg();
      }
      return ABIArgInfo.getExtend();
    }
    if (InReg) {
      return ABIArgInfo.getDirectInReg();
    }
    return ABIArgInfo.getDirect();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LanaiABIInfo::~LanaiABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6701,
   FQN="(anonymous namespace)::LanaiABIInfo::~LanaiABIInfo", NM="_ZN12_GLOBAL__N_112LanaiABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_112LanaiABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
