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
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type MetadataStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.MetadataStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZL12uniquifyImplPT_RN4llvm8DenseSetIS0_T0_EE;_ZL11canBeMergedRKN4llvm13ConstantRangeES2_;_ZL12isContiguousRKN4llvm13ConstantRangeES2_;_ZL13tryMergeRangeRN4llvm15SmallVectorImplIPNS_11ConstantIntEEES2_S2_;_ZL16getLocalFunctionPN4llvm5ValueE;_ZL16hasSelfReferencePN4llvm6MDNodeE;_ZL18getOrSelfReferenceRN4llvm11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE;_ZL19isOperandUnresolvedPN4llvm8MetadataE;_ZL28canonicalizeMetadataForValueRN4llvm11LLVMContextEPNS_8MetadataE;_ZL8addRangeRN4llvm15SmallVectorImplIPNS_11ConstantIntEEES2_S2_;_ZL9getNMDOpsPv; -static-type=MetadataStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class MetadataStatics {


/// Canonicalize metadata arguments to intrinsics.
///
/// To support bitcode upgrades (and assembly semantic sugar) for \a
/// MetadataAsValue, we need to canonicalize certain metadata.
///
///   - nullptr is replaced by an empty MDNode.
///   - An MDNode with a single null operand is replaced by an empty MDNode.
///   - An MDNode whose only operand is a \a ConstantAsMetadata gets skipped.
///
/// This maintains readability of bitcode from when metadata was a type of
/// value, and these bridges were unnecessary.
//<editor-fold defaultstate="collapsed" desc="canonicalizeMetadataForValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 51,
 FQN="canonicalizeMetadataForValue", NM="_ZL28canonicalizeMetadataForValueRN4llvm11LLVMContextEPNS_8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL28canonicalizeMetadataForValueRN4llvm11LLVMContextEPNS_8MetadataE")
//</editor-fold>
public static Metadata /*P*/ canonicalizeMetadataForValue(final LLVMContext /*&*/ Context, 
                            Metadata /*P*/ MD) {
  if (!(MD != null)) {
    // !{}
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(None, true));
  }
  
  // Return early if this isn't a single-operand MDNode.
  MDNode /*P*/ N = dyn_cast_MDNode(MD);
  if (!(N != null) || N.getNumOperands() != 1) {
    return MD;
  }
  if (!((N.getOperand(0).$Metadata$P()) != null)) {
    // !{}
    return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(None, true));
  }
  {
    
    ConstantAsMetadata /*P*/ C = dyn_cast_ConstantAsMetadata(N.getOperand(0));
    if ((C != null)) {
      // Look through the MDNode.
      return C;
    }
  }
  
  return MD;
}

//<editor-fold defaultstate="collapsed" desc="getLocalFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 299,
 FQN="getLocalFunction", NM="_ZL16getLocalFunctionPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL16getLocalFunctionPN4llvm5ValueE")
//</editor-fold>
public static Function /*P*/ getLocalFunction(Value /*P*/ V) {
  assert ((V != null)) : "Expected value";
  {
    Argument /*P*/ A = dyn_cast_Argument(V);
    if ((A != null)) {
      return A.getParent();
    }
  }
  {
    BasicBlock /*P*/ BB = cast_Instruction(V).getParent();
    if ((BB != null)) {
      return BB.getParent();
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="isOperandUnresolved">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 496,
 FQN="isOperandUnresolved", NM="_ZL19isOperandUnresolvedPN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL19isOperandUnresolvedPN4llvm8MetadataE")
//</editor-fold>
public static boolean isOperandUnresolved(Metadata /*P*/ Op) {
  {
    MDNode /*P*/ N = dyn_cast_or_null_MDNode(Op);
    if ((N != null)) {
      return !N.isResolved();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasSelfReference">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 604,
 FQN="hasSelfReference", NM="_ZL16hasSelfReferencePN4llvm6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL16hasSelfReferencePN4llvm6MDNodeE")
//</editor-fold>
public static boolean hasSelfReference(MDNode /*P*/ N) {
  for (MDOperand /*P*/ OP : N.operands())  {
    Metadata /*P*/ MD = OP.$Metadata$P();
    if (MD == N) {
      return true;
    }
  }
  return false;
}

/*template <class T, class InfoT> TEMPLATE*/
//template <class T = MDTuple, class InfoT = MDNodeInfo<MDTuple>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm7MDTupleENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm7MDTupleENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static MDTuple /*P*/ uniquifyImpl(MDTuple /*P*/ N, final DenseSet<MDTuple /*P*/ > /*&*/ Store) {
  {
    MDTuple /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplMDTuple(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DILocation, class InfoT = MDNodeInfo<DILocation>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm10DILocationENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm10DILocationENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DILocation /*P*/ uniquifyImpl(DILocation /*P*/ N, final DenseSet<DILocation /*P*/ > /*&*/ Store) {
  {
    DILocation /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDILocation(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIExpression, class InfoT = MDNodeInfo<DIExpression>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm12DIExpressionENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm12DIExpressionENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIExpression /*P*/ uniquifyImpl(DIExpression /*P*/ N, final DenseSet<DIExpression /*P*/ > /*&*/ Store) {
  {
    DIExpression /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIExpression(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = GenericDINode, class InfoT = MDNodeInfo<GenericDINode>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm13GenericDINodeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm13GenericDINodeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static GenericDINode /*P*/ uniquifyImpl(GenericDINode /*P*/ N, final DenseSet<GenericDINode /*P*/ > /*&*/ Store) {
  {
    GenericDINode /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplGenericDINode(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DISubrange, class InfoT = MDNodeInfo<DISubrange>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm10DISubrangeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm10DISubrangeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DISubrange /*P*/ uniquifyImpl(DISubrange /*P*/ N, final DenseSet<DISubrange /*P*/ > /*&*/ Store) {
  {
    DISubrange /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDISubrange(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIEnumerator, class InfoT = MDNodeInfo<DIEnumerator>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm12DIEnumeratorENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm12DIEnumeratorENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIEnumerator /*P*/ uniquifyImpl(DIEnumerator /*P*/ N, final DenseSet<DIEnumerator /*P*/ > /*&*/ Store) {
  {
    DIEnumerator /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIEnumerator(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIBasicType, class InfoT = MDNodeInfo<DIBasicType>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm11DIBasicTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm11DIBasicTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIBasicType /*P*/ uniquifyImpl(DIBasicType /*P*/ N, final DenseSet<DIBasicType /*P*/ > /*&*/ Store) {
  {
    DIBasicType /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIBasicType(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIDerivedType, class InfoT = MDNodeInfo<DIDerivedType>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm13DIDerivedTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm13DIDerivedTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIDerivedType /*P*/ uniquifyImpl(DIDerivedType /*P*/ N, final DenseSet<DIDerivedType /*P*/ > /*&*/ Store) {
  {
    DIDerivedType /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIDerivedType(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DICompositeType, class InfoT = MDNodeInfo<DICompositeType>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm15DICompositeTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm15DICompositeTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DICompositeType /*P*/ uniquifyImpl(DICompositeType /*P*/ N, final DenseSet<DICompositeType /*P*/ > /*&*/ Store) {
  {
    DICompositeType /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDICompositeType(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DISubroutineType, class InfoT = MDNodeInfo<DISubroutineType>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm16DISubroutineTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm16DISubroutineTypeENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DISubroutineType /*P*/ uniquifyImpl(DISubroutineType /*P*/ N, final DenseSet<DISubroutineType /*P*/ > /*&*/ Store) {
  {
    DISubroutineType /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDISubroutineType(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIFile, class InfoT = MDNodeInfo<DIFile>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm6DIFileENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm6DIFileENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIFile /*P*/ uniquifyImpl(DIFile /*P*/ N, final DenseSet<DIFile /*P*/ > /*&*/ Store) {
  {
    DIFile /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIFile(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DISubprogram, class InfoT = MDNodeInfo<DISubprogram>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm12DISubprogramENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm12DISubprogramENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DISubprogram /*P*/ uniquifyImpl(DISubprogram /*P*/ N, final DenseSet<DISubprogram /*P*/ > /*&*/ Store) {
  {
    DISubprogram /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDISubprogram(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DILexicalBlock, class InfoT = MDNodeInfo<DILexicalBlock>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm14DILexicalBlockENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm14DILexicalBlockENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DILexicalBlock /*P*/ uniquifyImpl(DILexicalBlock /*P*/ N, final DenseSet<DILexicalBlock /*P*/ > /*&*/ Store) {
  {
    DILexicalBlock /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDILexicalBlock(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DILexicalBlockFile, class InfoT = MDNodeInfo<DILexicalBlockFile>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm18DILexicalBlockFileENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm18DILexicalBlockFileENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DILexicalBlockFile /*P*/ uniquifyImpl(DILexicalBlockFile /*P*/ N, final DenseSet<DILexicalBlockFile /*P*/ > /*&*/ Store) {
  {
    DILexicalBlockFile /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDILexicalBlockFile(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DINamespace, class InfoT = MDNodeInfo<DINamespace>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm11DINamespaceENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm11DINamespaceENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DINamespace /*P*/ uniquifyImpl(DINamespace /*P*/ N, final DenseSet<DINamespace /*P*/ > /*&*/ Store) {
  {
    DINamespace /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDINamespace(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIModule, class InfoT = MDNodeInfo<DIModule>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm8DIModuleENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm8DIModuleENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIModule /*P*/ uniquifyImpl(DIModule /*P*/ N, final DenseSet<DIModule /*P*/ > /*&*/ Store) {
  {
    DIModule /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIModule(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DITemplateTypeParameter, class InfoT = MDNodeInfo<DITemplateTypeParameter>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm23DITemplateTypeParameterENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm23DITemplateTypeParameterENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DITemplateTypeParameter /*P*/ uniquifyImpl(DITemplateTypeParameter /*P*/ N, final DenseSet<DITemplateTypeParameter /*P*/ > /*&*/ Store) {
  {
    DITemplateTypeParameter /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDITemplateTypeParameter(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DITemplateValueParameter, class InfoT = MDNodeInfo<DITemplateValueParameter>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm24DITemplateValueParameterENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm24DITemplateValueParameterENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DITemplateValueParameter /*P*/ uniquifyImpl(DITemplateValueParameter /*P*/ N, final DenseSet<DITemplateValueParameter /*P*/ > /*&*/ Store) {
  {
    DITemplateValueParameter /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDITemplateValueParameter(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIGlobalVariable, class InfoT = MDNodeInfo<DIGlobalVariable>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm16DIGlobalVariableENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm16DIGlobalVariableENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIGlobalVariable /*P*/ uniquifyImpl(DIGlobalVariable /*P*/ N, final DenseSet<DIGlobalVariable /*P*/ > /*&*/ Store) {
  {
    DIGlobalVariable /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIGlobalVariable(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DILocalVariable, class InfoT = MDNodeInfo<DILocalVariable>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm15DILocalVariableENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm15DILocalVariableENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DILocalVariable /*P*/ uniquifyImpl(DILocalVariable /*P*/ N, final DenseSet<DILocalVariable /*P*/ > /*&*/ Store) {
  {
    DILocalVariable /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDILocalVariable(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIObjCProperty, class InfoT = MDNodeInfo<DIObjCProperty>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm14DIObjCPropertyENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm14DIObjCPropertyENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIObjCProperty /*P*/ uniquifyImpl(DIObjCProperty /*P*/ N, final DenseSet<DIObjCProperty /*P*/ > /*&*/ Store) {
  {
    DIObjCProperty /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIObjCProperty(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIImportedEntity, class InfoT = MDNodeInfo<DIImportedEntity>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm16DIImportedEntityENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm16DIImportedEntityENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIImportedEntity /*P*/ uniquifyImpl(DIImportedEntity /*P*/ N, final DenseSet<DIImportedEntity /*P*/ > /*&*/ Store) {
  {
    DIImportedEntity /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIImportedEntity(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIMacro, class InfoT = MDNodeInfo<DIMacro>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm7DIMacroENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm7DIMacroENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIMacro /*P*/ uniquifyImpl(DIMacro /*P*/ N, final DenseSet<DIMacro /*P*/ > /*&*/ Store) {
  {
    DIMacro /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIMacro(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
//template <class T = DIMacroFile, class InfoT = MDNodeInfo<DIMacroFile>> 
//<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
 FQN="uniquifyImpl", NM="_ZL12uniquifyImplIN4llvm11DIMacroFileENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12uniquifyImplIN4llvm11DIMacroFileENS0_10MDNodeInfoIS1_EEEPT_S5_RNS0_8DenseSetIS5_T0_EE")
//</editor-fold>
public static DIMacroFile /*P*/ uniquifyImpl(DIMacroFile /*P*/ N, final DenseSet<DIMacroFile /*P*/ > /*&*/ Store) {
  {
    DIMacroFile /*P*/ U = IrLlvmStatics.getUniqued(Store, new MDNodeKeyImplDIMacroFile(N));
    if ((U != null)) {
      return U;
    }
  }
  
  Store.insert(N);
  return N;
}
///*template <class T, class InfoT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="uniquifyImpl">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 725,
// FQN="uniquifyImpl", NM="Tpl__ZL12uniquifyImplPT_RN4llvm8DenseSetIS0_T0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZL12uniquifyImplPT_RN4llvm8DenseSetIS0_T0_EE")
////</editor-fold>
//public static </*class*/ T, /*class*/ InfoT> T /*P*/ uniquifyImpl(T /*P*/ N, final DenseSet<T /*P*/ , InfoT> /*&*/ Store) {
//  {
//    T /*P*/ U = getUniqued(Store, N);
//    if (U) {
//      return U;
//    }
//  }
//  
//  Store.insert(N);
//  return N;
//}

/// Get a node or a self-reference that looks like it.
///
/// Special handling for finding self-references, for use by \a
/// MDNode::concatenate() and \a MDNode::intersect() to maintain behaviour from
/// when self-referencing nodes were still uniqued.  If the first operand has
/// the same operands as \c Ops, return the first operand instead.
//<editor-fold defaultstate="collapsed" desc="getOrSelfReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 845,
 FQN="getOrSelfReference", NM="_ZL18getOrSelfReferenceRN4llvm11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL18getOrSelfReferenceRN4llvm11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
//</editor-fold>
public static MDNode /*P*/ getOrSelfReference(final LLVMContext /*&*/ Context, 
                  ArrayRef<Metadata /*P*/ > Ops) {
  if (!Ops.empty()) {
    {
      MDNode /*P*/ N = dyn_cast_or_null_MDNode(Ops.$at(0));
      if ((N != null)) {
        if (N.getNumOperands() == Ops.size() && N == N.getOperand(0).$Metadata$P()) {
          for (/*uint*/int I = 1, E = Ops.size(); I != E; ++I)  {
            if (Ops.$at(I) != N.getOperand(I).$Metadata$P()) {
              return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Ops));
            }
          }
          return N;
        }
      }
    }
  }
  
  return MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Ops));
}

//<editor-fold defaultstate="collapsed" desc="isContiguous">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 914,
 FQN="isContiguous", NM="_ZL12isContiguousRKN4llvm13ConstantRangeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL12isContiguousRKN4llvm13ConstantRangeES2_")
//</editor-fold>
public static boolean isContiguous(final /*const*/ ConstantRange /*&*/ A, final /*const*/ ConstantRange /*&*/ B) {
  return A.getUpper().$eq(B.getLower()) || A.getLower().$eq(B.getUpper());
}

//<editor-fold defaultstate="collapsed" desc="canBeMerged">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 918,
 FQN="canBeMerged", NM="_ZL11canBeMergedRKN4llvm13ConstantRangeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL11canBeMergedRKN4llvm13ConstantRangeES2_")
//</editor-fold>
public static boolean canBeMerged(final /*const*/ ConstantRange /*&*/ A, final /*const*/ ConstantRange /*&*/ B) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(!$c$.track(A.intersectWith(B)).isEmptySet() || isContiguous(A, B));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="tryMergeRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 922,
 FQN="tryMergeRange", NM="_ZL13tryMergeRangeRN4llvm15SmallVectorImplIPNS_11ConstantIntEEES2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL13tryMergeRangeRN4llvm15SmallVectorImplIPNS_11ConstantIntEEES2_S2_")
//</editor-fold>
public static boolean tryMergeRange(final SmallVectorImpl<ConstantInt /*P*/ > /*&*/ EndPoints, 
             ConstantInt /*P*/ Low, ConstantInt /*P*/ High) {
  ConstantRange NewRange = null;
  ConstantRange LastRange = null;
  try {
    NewRange/*J*/= new ConstantRange(new APInt(Low.getValue()), new APInt(High.getValue()));
    /*uint*/int Size = EndPoints.size();
    APInt LB = new APInt(EndPoints.$at(Size - 2).getValue());
    APInt LE = new APInt(EndPoints.$at(Size - 1).getValue());
    LastRange/*J*/= new ConstantRange(new APInt(LB), new APInt(LE));
    if (canBeMerged(NewRange, LastRange)) {
      ConstantRange Union = null;
      try {
        Union = LastRange.unionWith(NewRange);
        Type /*P*/ Ty = High.getType();
        EndPoints.$set(Size - 2, 
          cast_ConstantInt(ConstantInt.get(Ty, Union.getLower())));
        EndPoints.$set(Size - 1, 
          cast_ConstantInt(ConstantInt.get(Ty, Union.getUpper())));
        return true;
      } finally {
        if (Union != null) { Union.$destroy(); }
      }
    }
    return false;
  } finally {
    if (LastRange != null) { LastRange.$destroy(); }
    if (NewRange != null) { NewRange.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="addRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 941,
 FQN="addRange", NM="_ZL8addRangeRN4llvm15SmallVectorImplIPNS_11ConstantIntEEES2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL8addRangeRN4llvm15SmallVectorImplIPNS_11ConstantIntEEES2_S2_")
//</editor-fold>
public static void addRange(final SmallVectorImpl<ConstantInt /*P*/ > /*&*/ EndPoints, 
        ConstantInt /*P*/ Low, ConstantInt /*P*/ High) {
  if (!EndPoints.empty()) {
    if (tryMergeRange(EndPoints, Low, High)) {
      return;
    }
  }
  
  EndPoints.push_back(Low);
  EndPoints.push_back(High);
}


//===----------------------------------------------------------------------===//
// NamedMDNode implementation.
//
//<editor-fold defaultstate="collapsed" desc="getNMDOps">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1038,
 FQN="getNMDOps", NM="_ZL9getNMDOpsPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZL9getNMDOpsPv")
//</editor-fold>
public static SmallVector<TrackingMDRef> /*&*/ getNMDOps(Object/*void P*/ Operands) {
  return $Deref((SmallVector<TrackingMDRef> /*P*/)Operands);
}

} // END OF class MetadataStatics
