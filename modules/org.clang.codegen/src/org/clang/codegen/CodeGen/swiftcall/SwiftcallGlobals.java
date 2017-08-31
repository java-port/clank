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
package org.clang.codegen.CodeGen.swiftcall;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.CodeGen.swiftcall.SwiftcallGlobals.*;
import static org.clang.codegen.impl.SwiftCallingConvStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type SwiftcallGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.swiftcall.SwiftcallGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall14computeABIInfoERNS0_13CodeGenModuleERNS0_14CGFunctionInfoE;_ZN5clang7CodeGen9swiftcall17isLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeE;_ZN5clang7CodeGen9swiftcall17isLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm4TypeEj;_ZN5clang7CodeGen9swiftcall18classifyReturnTypeERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEE;_ZN5clang7CodeGen9swiftcall18isLegalIntegerTypeERNS0_13CodeGenModuleEPN4llvm11IntegerTypeE;_ZN5clang7CodeGen9swiftcall18legalizeVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeERNS5_15SmallVectorImplIPNS5_4TypeEEE;_ZN5clang7CodeGen9swiftcall19getNaturalAlignmentERNS0_13CodeGenModuleEPN4llvm4TypeE;_ZN5clang7CodeGen9swiftcall20classifyArgumentTypeERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEE;_ZN5clang7CodeGen9swiftcall20splitLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeE;_ZN5clang7CodeGen9swiftcall29shouldPassCXXRecordIndirectlyERNS0_13CodeGenModuleEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen9swiftcall30getMaximumVoluntaryIntegerSizeERNS0_13CodeGenModuleE; -static-type=SwiftcallGlobals -package=org.clang.codegen.CodeGen.swiftcall")
//</editor-fold>
public final class SwiftcallGlobals {


/// Return the maximum voluntary integer size for the current target.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::getMaximumVoluntaryIntegerSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 595,
 FQN="clang::CodeGen::swiftcall::getMaximumVoluntaryIntegerSize", NM="_ZN5clang7CodeGen9swiftcall30getMaximumVoluntaryIntegerSizeERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall30getMaximumVoluntaryIntegerSizeERNS0_13CodeGenModuleE")
//</editor-fold>
public static CharUnits getMaximumVoluntaryIntegerSize(final CodeGenModule /*&*/ CGM) {
  // Currently always the size of an ordinary pointer.
  return CGM.getContext().toCharUnitsFromBits(CGM.getContext().getTargetInfo().getPointerWidth(0));
}


/// Return the Swift CC's notion of the natural alignment of a type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::getNaturalAlignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 601,
 FQN="clang::CodeGen::swiftcall::getNaturalAlignment", NM="_ZN5clang7CodeGen9swiftcall19getNaturalAlignmentERNS0_13CodeGenModuleEPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall19getNaturalAlignmentERNS0_13CodeGenModuleEPN4llvm4TypeE")
//</editor-fold>
public static CharUnits getNaturalAlignment(final CodeGenModule /*&*/ CGM, org.llvm.ir.Type /*P*/ type) {
  // For Swift's purposes, this is always just the store size of the type
  // rounded up to a power of 2.
  /*ullong*/long size = (/*ullong*/long)getTypeStoreSize(CGM, type).getQuantity();
  if (!isPowerOf2($ullong2uint(size))) {
    size = 1L/*ULL*/ << (llvm.findLastSet(size, ZeroBehavior.ZB_Undefined) + $int2ullong(1));
  }
  assert ($greatereq_ullong_uint(size, CGM.getDataLayout().getABITypeAlignment(type)));
  return CharUnits.fromQuantity(size);
}


/// Is the given integer type "legal" for Swift's perspective on the
/// current platform?
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::isLegalIntegerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 612,
 FQN="clang::CodeGen::swiftcall::isLegalIntegerType", NM="_ZN5clang7CodeGen9swiftcall18isLegalIntegerTypeERNS0_13CodeGenModuleEPN4llvm11IntegerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall18isLegalIntegerTypeERNS0_13CodeGenModuleEPN4llvm11IntegerTypeE")
//</editor-fold>
public static boolean isLegalIntegerType(final CodeGenModule /*&*/ CGM, 
                  IntegerType /*P*/ intTy) {
  /*uint*/int size = intTy.getBitWidth();
  switch (size) {
   case 1:
   case 8:
   case 16:
   case 32:
   case 64:
    // Just assume that the above are always legal.
    return true;
   case 128:
    return CGM.getContext().getTargetInfo().hasInt128Type();
   default:
    return false;
  }
}


/// Is the given vector type "legal" for Swift's perspective on the
/// current platform?
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::isLegalVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 632,
 FQN="clang::CodeGen::swiftcall::isLegalVectorType", NM="_ZN5clang7CodeGen9swiftcall17isLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall17isLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeE")
//</editor-fold>
public static boolean isLegalVectorType(final CodeGenModule /*&*/ CGM, CharUnits vectorSize, 
                 org.llvm.ir.VectorType /*P*/ vectorTy) {
  return isLegalVectorType(CGM, new CharUnits(vectorSize), vectorTy.getElementType(), 
      vectorTy.getNumElements());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::isLegalVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 638,
 FQN="clang::CodeGen::swiftcall::isLegalVectorType", NM="_ZN5clang7CodeGen9swiftcall17isLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm4TypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall17isLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm4TypeEj")
//</editor-fold>
public static boolean isLegalVectorType(final CodeGenModule /*&*/ CGM, CharUnits vectorSize, 
                 org.llvm.ir.Type /*P*/ eltTy, /*uint*/int numElts) {
  assert ($greater_uint(numElts, 1)) : "illegal vector length";
  return getSwiftABIInfo(CGM).
      isLegalVectorTypeForSwift(new CharUnits(vectorSize), eltTy, numElts);
}


/// Minimally split a legal vector type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::splitLegalVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 645,
 FQN="clang::CodeGen::swiftcall::splitLegalVectorType", NM="_ZN5clang7CodeGen9swiftcall20splitLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall20splitLegalVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeE")
//</editor-fold>
public static std.pairTypeUInt<org.llvm.ir.Type /*P*/ > splitLegalVectorType(final CodeGenModule /*&*/ CGM, CharUnits vectorSize, 
                    org.llvm.ir.VectorType /*P*/ vectorTy) {
  /*uint*/int numElts = vectorTy.getNumElements();
  org.llvm.ir.Type /*P*/ eltTy = vectorTy.getElementType();
  
  // Try to split the vector type in half.
  if ($greatereq_uint(numElts, 4) && isPowerOf2(numElts)) {
    if (isLegalVectorType(CGM, vectorSize.$slash(2), eltTy, $div_uint(numElts, 2))) {
      return /*{ */new std.pairPtrUInt<org.llvm.ir.Type /*P*/ >(JD$T$RR_T1$RR.INSTANCE, org.llvm.ir.VectorType.get(eltTy, $div_uint(numElts, 2)), 2)/* }*/;
    }
  }
  
  return /*{ */new std.pairPtrUInt<org.llvm.ir.Type /*P*/ >(JD$T$RR_T1$RR.INSTANCE, eltTy, numElts)/* }*/;
}


/// Turn a vector type in a sequence of legal component vector types.
///
/// The caller may assume that the sum of the data sizes of the resulting
/// types will equal the data size of the vector type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::legalizeVectorType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 660,
 FQN="clang::CodeGen::swiftcall::legalizeVectorType", NM="_ZN5clang7CodeGen9swiftcall18legalizeVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeERNS5_15SmallVectorImplIPNS5_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall18legalizeVectorTypeERNS0_13CodeGenModuleENS_9CharUnitsEPN4llvm10VectorTypeERNS5_15SmallVectorImplIPNS5_4TypeEEE")
//</editor-fold>
public static void legalizeVectorType(final CodeGenModule /*&*/ CGM, CharUnits origVectorSize, 
                  org.llvm.ir.VectorType /*P*/ origVectorTy, 
                  final SmallVectorImpl<org.llvm.ir.Type /*P*/ > /*&*/ components) {
  // If it's already a legal vector type, use it.
  if (isLegalVectorType(CGM, new CharUnits(origVectorSize), origVectorTy)) {
    components.push_back(origVectorTy);
    return;
  }
  
  // Try to split the vector into legal subvectors.
  /*uint*/int numElts = origVectorTy.getNumElements();
  org.llvm.ir.Type /*P*/ eltTy = origVectorTy.getElementType();
  assert (numElts != 1);
  
  // The largest size that we're still considering making subvectors of.
  // Always a power of 2.
  /*uint*/int logCandidateNumElts = llvm.findLastSet(numElts, ZeroBehavior.ZB_Undefined);
  /*uint*/int candidateNumElts = 1/*U*/ << logCandidateNumElts;
  assert ($lesseq_uint(candidateNumElts, numElts) && $greater_uint(candidateNumElts * 2, numElts));
  
  // Minor optimization: don't check the legality of this exact size twice.
  if (candidateNumElts == numElts) {
    logCandidateNumElts--;
    candidateNumElts >>>= 1;
  }
  
  CharUnits eltSize = (origVectorSize.$slash($uint2long(numElts)));
  CharUnits candidateSize = eltSize.$star($uint2long(candidateNumElts));
  
  // The sensibility of this algorithm relies on the fact that we never
  // have a legal non-power-of-2 vector size without having the power of 2
  // also be legal.
  while ($greater_uint(logCandidateNumElts, 0)) {
    assert (candidateNumElts == 1/*U*/ << logCandidateNumElts);
    assert ($lesseq_uint(candidateNumElts, numElts));
    assert (candidateSize.$eq(eltSize.$star($uint2long(candidateNumElts))));
    
    // Skip illegal vector sizes.
    if (!isLegalVectorType(CGM, new CharUnits(candidateSize), eltTy, candidateNumElts)) {
      logCandidateNumElts--;
      candidateNumElts = $div_uint(candidateNumElts, 2);
      candidateSize.$slashassign(2);
      continue;
    }
    
    // Add the right number of vectors of this size.
    /*uint*/int numVecs = numElts >>> logCandidateNumElts;
    components.append(numVecs, org.llvm.ir.VectorType.get(eltTy, candidateNumElts));
    numElts -= (numVecs << logCandidateNumElts);
    if (numElts == 0) {
      return;
    }
    
    // It's possible that the number of elements remaining will be legal.
    // This can happen with e.g. <7 x float> when <3 x float> is legal.
    // This only needs to be separately checked if it's not a power of 2.
    if ($greater_uint(numElts, 2) && !isPowerOf2(numElts)
       && isLegalVectorType(CGM, eltSize.$star($uint2long(numElts)), eltTy, numElts)) {
      components.push_back(org.llvm.ir.VectorType.get(eltTy, numElts));
      return;
    }
    
    // Bring vecSize down to something no larger than numElts.
    do {
      logCandidateNumElts--;
      candidateNumElts = $div_uint(candidateNumElts, 2);
      candidateSize.$slashassign(2);
    } while ($greater_uint(candidateNumElts, numElts));
  }
  
  // Otherwise, just append a bunch of individual elements.
  components.append(numElts, eltTy);
}


/// Should a C++ record type be passed and returned indirectly?
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::shouldPassCXXRecordIndirectly">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 733,
 FQN="clang::CodeGen::swiftcall::shouldPassCXXRecordIndirectly", NM="_ZN5clang7CodeGen9swiftcall29shouldPassCXXRecordIndirectlyERNS0_13CodeGenModuleEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall29shouldPassCXXRecordIndirectlyERNS0_13CodeGenModuleEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static boolean shouldPassCXXRecordIndirectly(final CodeGenModule /*&*/ CGM, 
                             /*const*/ CXXRecordDecl /*P*/ record) {
  // Following a recommendation from Richard Smith, pass a C++ type
  // indirectly only if the destructor is non-trivial or *all* of the
  // copy/move constructors are deleted or non-trivial.
  if (record.hasNonTrivialDestructor()) {
    return true;
  }
  
  // It would be nice if this were summarized on the CXXRecordDecl.
  for (CXXConstructorDecl /*P*/ ctor : record.ctors()) {
    if (ctor.isCopyOrMoveConstructor() && !ctor.isDeleted()
       && ctor.isTrivial()) {
      return false;
    }
  }
  
  return true;
}


/// Classify the rules for how to return a particular type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::classifyReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 813,
 FQN="clang::CodeGen::swiftcall::classifyReturnType", NM="_ZN5clang7CodeGen9swiftcall18classifyReturnTypeERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall18classifyReturnTypeERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEE")
//</editor-fold>
public static ABIArgInfo classifyReturnType(final CodeGenModule /*&*/ CGM, CanQual<org.clang.ast.Type> type) {
  return classifyType(CGM, new CanQual<org.clang.ast.Type>(type), /*forReturn*/ true);
}


/// Classify the rules for how to pass a particular type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::classifyArgumentType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 817,
 FQN="clang::CodeGen::swiftcall::classifyArgumentType", NM="_ZN5clang7CodeGen9swiftcall20classifyArgumentTypeERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall20classifyArgumentTypeERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEE")
//</editor-fold>
public static ABIArgInfo classifyArgumentType(final CodeGenModule /*&*/ CGM, 
                    CanQual<org.clang.ast.Type> type) {
  return classifyType(CGM, new CanQual<org.clang.ast.Type>(type), /*forReturn*/ false);
}


/// Compute the ABI information of a swiftcall function.  This is a
/// private interface for Clang.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::swiftcall::computeABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp", line = 822,
 FQN="clang::CodeGen::swiftcall::computeABIInfo", NM="_ZN5clang7CodeGen9swiftcall14computeABIInfoERNS0_13CodeGenModuleERNS0_14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN5clang7CodeGen9swiftcall14computeABIInfoERNS0_13CodeGenModuleERNS0_14CGFunctionInfoE")
//</editor-fold>
public static void computeABIInfo(final CodeGenModule /*&*/ CGM, final CGFunctionInfo /*&*/ FI) {
  final ABIArgInfo /*&*/ retInfo = FI.getReturnInfo();
  retInfo.$assignMove(classifyReturnType(CGM, FI.getReturnType()));
  
  for (/*uint*/int i = 0, e = FI.arg_size(); i != e; ++i) {
    final CGFunctionInfoArgInfo /*&*/ argInfo = FI.arg_begin().$at(i);
    argInfo.info.$assignMove(classifyArgumentType(CGM, new CanQual<org.clang.ast.Type>(argInfo.type)));
  }
}

} // END OF class SwiftcallGlobals
