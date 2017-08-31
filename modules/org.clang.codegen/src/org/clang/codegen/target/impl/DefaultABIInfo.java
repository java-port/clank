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
import org.clang.ast.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;


/// DefaultABIInfo - The default implementation for ABI specific
/// details. This implementation provides information which results in
/// self-consistent and sensible LLVM IR generation, but does not
/// conform to any particular ABI.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 563,
 FQN="(anonymous namespace)::DefaultABIInfo", NM="_ZN12_GLOBAL__N_114DefaultABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114DefaultABIInfoE")
//</editor-fold>
public class DefaultABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo::DefaultABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 565,
   FQN="(anonymous namespace)::DefaultABIInfo::DefaultABIInfo", NM="_ZN12_GLOBAL__N_114DefaultABIInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114DefaultABIInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public DefaultABIInfo(final CodeGenTypes /*&*/ CGT) {
    // : ABIInfo(CGT) 
    //START JInit
    super(CGT);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 609,
   FQN="(anonymous namespace)::DefaultABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_114DefaultABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114DefaultABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    if (isAggregateTypeForABI(new QualType(RetTy))) {
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    {
      
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    return (RetTy.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 589,
   FQN="(anonymous namespace)::DefaultABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_114DefaultABIInfo20classifyArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114DefaultABIInfo20classifyArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyArgumentType(QualType Ty) /*const*/ {
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    if (isAggregateTypeForABI(new QualType(Ty))) {
      {
        // Records with non-trivial destructors/copy-constructors should not be
        // passed by value.
        CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
        if ((RAA.getValue() != 0)) {
          return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
        }
      }
      
      return getNaturalAlignIndirect(new QualType(Ty));
    }
    {
      
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        Ty.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    return (Ty.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 570,
   FQN="(anonymous namespace)::DefaultABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_114DefaultABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114DefaultABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 577,
   FQN="(anonymous namespace)::DefaultABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_114DefaultABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114DefaultABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    return EmitVAArgInstr(CGF, new Address(VAListAddr), new QualType(Ty), classifyArgumentType(new QualType(Ty)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultABIInfo::~DefaultABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 563,
   FQN="(anonymous namespace)::DefaultABIInfo::~DefaultABIInfo", NM="_ZN12_GLOBAL__N_114DefaultABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114DefaultABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
