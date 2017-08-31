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
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.swiftcall.*;
import org.llvm.ir.VectorType;
import org.llvm.ir.Type;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.CodeGen.swiftcall.SwiftcallGlobals.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SwiftCallingConvStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL10isPowerOf2j;_ZL12classifyTypeRN5clang7CodeGen13CodeGenModuleENS_7CanQualINS_4TypeEEEb;_ZL13getCommonTypePN4llvm4TypeES1_;_ZL15getSwiftABIInfoRN5clang7CodeGen13CodeGenModuleE;_ZL16getTypeStoreSizeRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeE;_ZL18areBytesInSameUnitN5clang9CharUnitsES0_S0_;_ZL20classifyExpandedTypeRN5clang7CodeGen9swiftcall16SwiftAggLoweringEbNS_9CharUnitsE;_ZL22getOffsetAtStartOfUnitN5clang9CharUnitsES0_; -static-type=SwiftCallingConvStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class SwiftCallingConvStatics {

//<editor-fold defaultstate="collapsed" desc="getSwiftABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 23,
 FQN="getSwiftABIInfo", NM="_ZL15getSwiftABIInfoRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL15getSwiftABIInfoRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static /*const*/ SwiftABIInfo /*&*/ getSwiftABIInfo(final CodeGenModule /*&*/ CGM) {
  return cast_SwiftABIInfo(CGM.getTargetCodeGenInfo().getABIInfo());
}

//<editor-fold defaultstate="collapsed" desc="isPowerOf2">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 27,
 FQN="isPowerOf2", NM="_ZL10isPowerOf2j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL10isPowerOf2j")
//</editor-fold>
public static boolean isPowerOf2(/*uint*/int n) {
  return n == (n & -n);
}


/// Given two types with the same size, try to find a common type.
//<editor-fold defaultstate="collapsed" desc="getCommonType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 32,
 FQN="getCommonType", NM="_ZL13getCommonTypePN4llvm4TypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL13getCommonTypePN4llvm4TypeES1_")
//</editor-fold>
public static Type /*P*/ getCommonType(Type /*P*/ first, Type /*P*/ second) {
  assert (first != second);
  
  // Allow pointers to merge with integers, but prefer the integer type.
  if (first.isIntegerTy()) {
    if (second.isPointerTy()) {
      return first;
    }
  } else if (first.isPointerTy()) {
    if (second.isIntegerTy()) {
      return second;
    }
    if (second.isPointerTy()) {
      return first;
    }
    // Allow two vectors to be merged (given that they have the same size).
    // This assumes that we never have two different vector register sets.
  } else {
    VectorType /*P*/ firstVecTy = dyn_cast_VectorType(first);
    if ((firstVecTy != null)) {
      {
        VectorType /*P*/ secondVecTy = dyn_cast_VectorType(second);
        if ((secondVecTy != null)) {
          {
            Type /*P*/ commonTy = getCommonType(firstVecTy.getElementType(), 
                secondVecTy.getElementType());
            if ((commonTy != null)) {
              return (commonTy == firstVecTy.getElementType() ? first : second);
            }
          }
        }
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="getTypeStoreSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 56,
 FQN="getTypeStoreSize", NM="_ZL16getTypeStoreSizeRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL16getTypeStoreSizeRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeE")
//</editor-fold>
public static CharUnits getTypeStoreSize(final CodeGenModule /*&*/ CGM, Type /*P*/ type) {
  return CharUnits.fromQuantity(CGM.getDataLayout().getTypeStoreSize(type));
}


/// Given a power-of-two unit size, return the offset of the aligned unit
/// of that size which contains the given offset.
///
/// In other words, round down to the nearest multiple of the unit size.
//<editor-fold defaultstate="collapsed" desc="getOffsetAtStartOfUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 402,
 FQN="getOffsetAtStartOfUnit", NM="_ZL22getOffsetAtStartOfUnitN5clang9CharUnitsES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL22getOffsetAtStartOfUnitN5clang9CharUnitsES0_")
//</editor-fold>
public static CharUnits getOffsetAtStartOfUnit(CharUnits offset, CharUnits unitSize) {
  assert (isPowerOf2($long2uint(unitSize.getQuantity())));
  /*llong*/long unitMask = ~(unitSize.getQuantity() - 1);
  return CharUnits.fromQuantity(offset.getQuantity() & unitMask);
}

//<editor-fold defaultstate="collapsed" desc="areBytesInSameUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 408,
 FQN="areBytesInSameUnit", NM="_ZL18areBytesInSameUnitN5clang9CharUnitsES0_S0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL18areBytesInSameUnitN5clang9CharUnitsES0_S0_")
//</editor-fold>
public static boolean areBytesInSameUnit(CharUnits first, CharUnits second, 
                  CharUnits chunkSize) {
  return getOffsetAtStartOfUnit(new CharUnits(first), new CharUnits(chunkSize)).$eq(
      getOffsetAtStartOfUnit(new CharUnits(second), new CharUnits(chunkSize))
  );
}

//<editor-fold defaultstate="collapsed" desc="classifyExpandedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 753,
 FQN="classifyExpandedType", NM="_ZL20classifyExpandedTypeRN5clang7CodeGen9swiftcall16SwiftAggLoweringEbNS_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL20classifyExpandedTypeRN5clang7CodeGen9swiftcall16SwiftAggLoweringEbNS_9CharUnitsE")
//</editor-fold>
public static ABIArgInfo classifyExpandedType(final SwiftAggLowering /*&*/ lowering, 
                    boolean forReturn, 
                    CharUnits alignmentForIndirect) {
  if (lowering.empty()) {
    return ABIArgInfo.getIgnore();
  } else if (lowering.shouldPassIndirectly(forReturn)) {
    return ABIArgInfo.getIndirect(new CharUnits(alignmentForIndirect), /*byval*/ false);
  } else {
    std.pair<StructType /*P*/ , Type /*P*/ > types = lowering.getCoerceAndExpandTypes();
    return ABIArgInfo.getCoerceAndExpand(types.first, types.second);
  }
}

//<editor-fold defaultstate="collapsed" desc="classifyType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 766,
 FQN="classifyType", NM="_ZL12classifyTypeRN5clang7CodeGen13CodeGenModuleENS_7CanQualINS_4TypeEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZL12classifyTypeRN5clang7CodeGen13CodeGenModuleENS_7CanQualINS_4TypeEEEb")
//</editor-fold>
public static ABIArgInfo classifyType(final CodeGenModule /*&*/ CGM, CanQual<org.clang.ast.Type> type, 
            boolean forReturn) {
  {
    /*const*/ RecordType /*P*/ recordType = dyn_cast_RecordType(type);
    if ((recordType != null)) {
      SwiftAggLowering lowering = null;
      try {
        RecordDecl /*P*/ record = recordType.getDecl();
        final /*const*/ ASTRecordLayout /*&*/ layout = CGM.getContext().getASTRecordLayout(record);
        {
          
          CXXRecordDecl /*P*/ cxxRecord = dyn_cast_CXXRecordDecl(record);
          if ((cxxRecord != null)) {
            if (shouldPassCXXRecordIndirectly(CGM, cxxRecord)) {
              return ABIArgInfo.getIndirect(layout.getAlignment(), /*byval*/ false);
            }
          }
        }
        
        lowering/*J*/= new SwiftAggLowering(CGM);
        lowering.addTypedData(recordType.getDecl(), CharUnits.Zero(), layout);
        lowering.finish();
        
        return classifyExpandedType(lowering, forReturn, layout.getAlignment());
      } finally {
        if (lowering != null) { lowering.$destroy(); }
      }
    }
  }
  
  // Just assume that all of our target ABIs can support returning at least
  // two integer or floating-point values.
  if (isa_ComplexType(type)) {
    return (forReturn ? ABIArgInfo.getDirect() : ABIArgInfo.getExpand());
  }
  
  // Vector types may need to be legalized.
  if (isa_VectorType(type)) {
    SwiftAggLowering lowering = null;
    try {
      lowering/*J*/= new SwiftAggLowering(CGM);
      lowering.addTypedData(type.$QualType(), CharUnits.Zero());
      lowering.finish();
      
      CharUnits alignment = CGM.getContext().getTypeAlignInChars(type.$QualType());
      return classifyExpandedType(lowering, forReturn, new CharUnits(alignment));
    } finally {
      if (lowering != null) { lowering.$destroy(); }
    }
  }
  
  // Member pointer types need to be expanded, but it's a simple form of
  // expansion that 'Direct' can handle.  Note that CanBeFlattened should be
  // true for this to work.
  
  // 'void' needs to be ignored.
  if (((CanProxyType)type.$arrow()).$arrow().isVoidType()) {
    return ABIArgInfo.getIgnore();
  }
  
  // Everything else can be passed directly.
  return ABIArgInfo.getDirect();
}

} // END OF class SwiftCallingConvStatics
