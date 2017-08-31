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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.IrLlvmGlobals;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import org.llvm.support.dwarf.DwarfGlobals;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.dwarf.VirtualityAttribute;


//<editor-fold defaultstate="collapsed" desc="static type AsmWriterStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.AsmWriterStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL10orderValuePKN4llvm5ValueERN12_GLOBAL__N_18OrderMapE;_ZL11orderModulePKN4llvm6ModuleE;_ZL11writeDIFileRN4llvm11raw_ostreamEPKNS_6DIFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL12writeDIMacroRN4llvm11raw_ostreamEPKNS_7DIMacroEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL12writeMDTupleRN4llvm11raw_ostreamEPKNS_7MDTupleEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL13PrintLLVMNameRN4llvm11raw_ostreamENS_9StringRefE10PrefixType;_ZL13PrintLLVMNameRN4llvm11raw_ostreamEPKNS_5ValueE;_ZL13writeDIModuleRN4llvm11raw_ostreamEPKNS_8DIModuleEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL15PrintVisibilityN4llvm11GlobalValue15VisibilityTypesERNS_21formatted_raw_ostreamE;_ZL15writeDILocationRN4llvm11raw_ostreamEPKNS_10DILocationEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL15writeDISubrangeRN4llvm11raw_ostreamEPKNS_10DISubrangeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL16PrintCallingConvjRN4llvm11raw_ostreamE;_ZL16getModuleFromValPKN4llvm5ValueE;_ZL16getPredicateTextj;_ZL16maybePrintComdatRN4llvm21formatted_raw_ostreamERKNS_12GlobalObjectE;_ZL16printWithoutTypeRKN4llvm5ValueERNS_11raw_ostreamEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL16writeDIBasicTypeRN4llvm11raw_ostreamEPKNS_11DIBasicTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL16writeDIMacroFileRN4llvm11raw_ostreamEPKNS_11DIMacroFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL16writeDINamespaceRN4llvm11raw_ostreamEPKNS_11DINamespaceEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL17createSlotTrackerPKN4llvm5ValueE;_ZL17printMetadataImplRN4llvm11raw_ostreamERKNS_8MetadataERNS_17ModuleSlotTrackerEPKNS_6ModuleEb;_ZL17writeDIEnumeratorRN4llvm11raw_ostreamEPKNS_12DIEnumeratorEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL17writeDIExpressionRN4llvm11raw_ostreamEPKNS_12DIExpressionEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL17writeDISubprogramRN4llvm11raw_ostreamEPKNS_12DISubprogramEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL18PrintEscapedStringN4llvm9StringRefERNS_11raw_ostreamE;_ZL18printAsOperandImplRKN4llvm5ValueERNS_11raw_ostreamEbRNS_17ModuleSlotTrackerE;_ZL18writeDICompileUnitRN4llvm11raw_ostreamEPKNS_13DICompileUnitEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL18writeDIDerivedTypeRN4llvm11raw_ostreamEPKNS_13DIDerivedTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL18writeGenericDINodeRN4llvm11raw_ostreamEPKNS_13GenericDINodeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL19getLinkagePrintNameN4llvm11GlobalValue12LinkageTypesE;_ZL19isReferencingMDNodeRKN4llvm11InstructionE;_ZL19predictUseListOrderPKN4llvm6ModuleE;_ZL19writeDILexicalBlockRN4llvm11raw_ostreamEPKNS_14DILexicalBlockEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL19writeDIObjCPropertyRN4llvm11raw_ostreamEPKNS_14DIObjCPropertyEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL20PrintDLLStorageClassN4llvm11GlobalValue20DLLStorageClassTypesERNS_21formatted_raw_ostreamE;_ZL20writeDICompositeTypeRN4llvm11raw_ostreamEPKNS_15DICompositeTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL20writeDILocalVariableRN4llvm11raw_ostreamEPKNS_15DILocalVariableEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL21PrintThreadLocalModelN4llvm11GlobalValue15ThreadLocalModeERNS_21formatted_raw_ostreamE;_ZL21WriteConstantInternalRN4llvm11raw_ostreamEPKNS_8ConstantERN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL21WriteOptimizationInfoRN4llvm11raw_ostreamEPKNS_4UserE;_ZL21writeDIGlobalVariableRN4llvm11raw_ostreamEPKNS_16DIGlobalVariableEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL21writeDIImportedEntityRN4llvm11raw_ostreamEPKNS_16DIImportedEntityEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL21writeDISubroutineTypeRN4llvm11raw_ostreamEPKNS_16DISubroutineTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL22WriteAsOperandInternalRN4llvm11raw_ostreamEPKNS_5ValueEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL22WriteAsOperandInternalRN4llvm11raw_ostreamEPKNS_8MetadataEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleEb;_ZL22getUnnamedAddrEncodingN4llvm11GlobalValue11UnnamedAddrE;_ZL22writeMetadataAsOperandRN4llvm11raw_ostreamEPKNS_8MetadataEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL23WriteMDNodeBodyInternalRN4llvm11raw_ostreamEPKNS_6MDNodeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL23printMetadataIdentifierN4llvm9StringRefERNS_21formatted_raw_ostreamE;_ZL23writeAtomicRMWOperationRN4llvm11raw_ostreamENS_13AtomicRMWInst5BinOpE;_ZL23writeDILexicalBlockFileRN4llvm11raw_ostreamEPKNS_18DILexicalBlockFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL24predictValueUseListOrderPKN4llvm5ValueEPKNS_8FunctionERN12_GLOBAL__N_18OrderMapERSt6vectorINS_12UseListOrderESaISA_EE;_ZL28predictValueUseListOrderImplPKN4llvm5ValueEPKNS_8FunctionEjRKN12_GLOBAL__N_18OrderMapERSt6vectorINS_12UseListOrderESaISB_EE;_ZL28writeDITemplateTypeParameterRN4llvm11raw_ostreamEPKNS_23DITemplateTypeParameterEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZL29writeDITemplateValueParameterRN4llvm11raw_ostreamEPKNS_24DITemplateValueParameterEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE;_ZN12_GLOBAL__N_1lsERN4llvm11raw_ostreamERNS_14FieldSeparatorE; -static-type=AsmWriterStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class AsmWriterStatics {

//<editor-fold defaultstate="collapsed" desc="orderValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 74,
 FQN="orderValue", NM="_ZL10orderValuePKN4llvm5ValueERN12_GLOBAL__N_18OrderMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL10orderValuePKN4llvm5ValueERN12_GLOBAL__N_18OrderMapE")
//</editor-fold>
public static void orderValue(/*const*/ Value /*P*/ V, final OrderMap /*&*/ OM) {
  if (((OM.lookup(V).first) != 0)) {
    return;
  }
  {
    
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(V);
    if ((C != null)) {
      if ((C.getNumOperands() != 0) && !isa_GlobalValue(C)) {
        for (/*const*/ Use /*P*/ U : C.operands$Const())  {
          Value /*P*/ Op = U.get();
          if (!isa_BasicBlock(Op) && !isa_GlobalValue(Op)) {
            orderValue(Op, OM);
          }
        }
      }
    }
  }
  
  // Note: we cannot cache this lookup above, since inserting into the map
  // changes the map's size, and thus affects the other IDs.
  OM.index(V);
}

//<editor-fold defaultstate="collapsed" desc="orderModule">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 89,
 FQN="orderModule", NM="_ZL11orderModulePKN4llvm6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL11orderModulePKN4llvm6ModuleE")
//</editor-fold>
public static OrderMap orderModule(/*const*/ Module /*P*/ M) {
  OrderMap OM = null;
  try {
    // This needs to match the order used by ValueEnumerator::ValueEnumerator()
    // and ValueEnumerator::incorporateFunction().
    OM/*J*/= new OrderMap();
    
    for (final /*const*/ GlobalVariable /*&*/ G : M.globals$Const()) {
      if (G.hasInitializer()) {
        if (!isa_GlobalValue(G.getInitializer$Const())) {
          orderValue(G.getInitializer$Const(), OM);
        }
      }
      orderValue($AddrOf(G), OM);
    }
    for (final /*const*/ GlobalAlias /*&*/ A : M.aliases$Const()) {
      if (!isa_GlobalValue(A.getAliasee$Const())) {
        orderValue(A.getAliasee$Const(), OM);
      }
      orderValue($AddrOf(A), OM);
    }
    for (final /*const*/ GlobalIFunc /*&*/ I : M.ifuncs$Const()) {
      if (!isa_GlobalValue(I.getResolver$Const())) {
        orderValue(I.getResolver$Const(), OM);
      }
      orderValue($AddrOf(I), OM);
    }
    for (final /*const*/ Function /*&*/ F : $Deref(M)) {
      for (final /*const*/ Use /*&*/ U : F.operands$Const())  {
        if (!isa_GlobalValue(U.get())) {
          orderValue(U.get(), OM);
        }
      }
      
      orderValue($AddrOf(F), OM);
      if (F.isDeclaration()) {
        continue;
      }
      
      for (final /*const*/ Argument /*&*/ A : F.args$Const())  {
        orderValue($AddrOf(A), OM);
      }
      for (final /*const*/ BasicBlock /*&*/ BB : F) {
        orderValue($AddrOf(BB), OM);
        for (final /*const*/ Instruction /*&*/ I : BB) {
          for (/*const*/ Use /*P*/ U : I.operands$Const())  {
             Value /*P*/ Op = U.get();
            if ((isa_Constant($Deref(Op)) && !isa_GlobalValue($Deref(Op)))
               || isa_InlineAsm($Deref(Op))) {
              orderValue(Op, OM);
            }
          }
          orderValue($AddrOf(I), OM);
        }
      }
    }
    return new OrderMap(JD$Move.INSTANCE, OM);
  } finally {
    if (OM != null) { OM.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="predictValueUseListOrderImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 136,
 FQN="predictValueUseListOrderImpl", NM="_ZL28predictValueUseListOrderImplPKN4llvm5ValueEPKNS_8FunctionEjRKN12_GLOBAL__N_18OrderMapERSt6vectorINS_12UseListOrderESaISB_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL28predictValueUseListOrderImplPKN4llvm5ValueEPKNS_8FunctionEjRKN12_GLOBAL__N_18OrderMapERSt6vectorINS_12UseListOrderESaISB_EE")
//</editor-fold>
public static void predictValueUseListOrderImpl(/*const*/ Value /*P*/ V, /*const*/ Function /*P*/ F, 
                            /*uint*/int ID, final /*const*/ OrderMap /*&*/ OM, 
                            final std.vector<UseListOrder> /*&*/ Stack) {
  // Predict use-list order for this one.
  // JAVA: typedef std::pair<const Use *, unsigned int> Entry
//  final class Entry extends std.pairPtrUInt</*const*/type$ptr<Use /*P*/> >{ };
  SmallVector<std.pairPtrUInt</*const*/Use /*P*/ >> List/*J*/= new SmallVector<std.pairPtrUInt</*const*/Use /*P*/ >>(64, new std.pairPtrUInt</*const*/Use /*P*/>());
  for (final /*const*/ Use /*&*/ U : V.uses$Const())  {
    // Check if this user will be serialized.
    if (((OM.lookup(U.getUser()).first) != 0)) {
      List.push_back(std.make_pair_Ptr_uint($AddrOf(U), List.size()));
    }
  }
  if ($less_uint(List.size(), 2)) {
    // We may have lost some users.
    return;
  }
  
  boolean GetsReversed = !isa_GlobalVariable(V) && !isa_Function(V) && !isa_BasicBlock(V);
  {
    /*const*/ BlockAddress /*P*/ BA = dyn_cast_BlockAddress(V);
    if ((BA != null)) {
      ID = OM.lookup(BA.getBasicBlock()).first;
    }
  }
  int ID_final = ID;
  std.sort(List.begin(), List.end(), /*[&, &OM, &GetsReversed, &ID]*/ (final /*const*/std.pairPtrUInt</*const*/Use /*P*/ > /*&*/ L, final /*const*/std.pairPtrUInt</*const*/Use /*P*/> /*&*/ R) -> {
            /*const*/Use /*P*/ LU = L.first;
            /*const*/Use /*P*/ RU = R.first;
            if ($eq_ptr(LU, RU)) {
              return false;
            }
            
            /*uint*/int LID = OM.lookup(LU./*->*/getUser()).first;
            /*uint*/int RID = OM.lookup(RU./*->*/getUser()).first;
            
            // If ID is 4, then expect: 7 6 5 1 2 3.
            if ($less_uint(LID, RID)) {
              if (GetsReversed) {
                if ($lesseq_uint(RID, ID_final)) {
                  return true;
                }
              }
              return false;
            }
            if ($less_uint(RID, LID)) {
              if (GetsReversed) {
                if ($lesseq_uint(LID, ID_final)) {
                  return false;
                }
              }
              return true;
            }
            
            // LID and RID are equal, so we have different operands of the same user.
            // Assume operands are added in order for all instructions.
            if (GetsReversed) {
              if ($lesseq_uint(LID, ID_final)) {
                return $less_uint(LU./*->*/getOperandNo(), RU./*->*/getOperandNo());
              }
            }
            return $greater_uint(LU./*->*/getOperandNo(), RU./*->*/getOperandNo());
          });
  if (std.is_sorted(List.begin(), List.end(), 
      /*[]*/ (final /*const*/std.pairPtrUInt</*const*/Use /*P*/ > /*&*/ L, final /*const*/std.pairPtrUInt</*const*/Use /*P*/ > /*&*/ R) -> {
            return $less_uint(L.second, R.second);
          })) {
    // Order is already correct.
    return;
  }
  
  // Store the shuffle.
  Stack.emplace_back(new UseListOrder(V, F, List.size()));
  assert (List.size() == Stack.back().Shuffle.size()) : "Wrong size";
  for (/*size_t*/int I = 0, E = List.size(); I != E; ++I)  {
    Stack.back().Shuffle.$set(I, List.$at(I).second);
  }
}

//<editor-fold defaultstate="collapsed" desc="predictValueUseListOrder">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 199,
 FQN="predictValueUseListOrder", NM="_ZL24predictValueUseListOrderPKN4llvm5ValueEPKNS_8FunctionERN12_GLOBAL__N_18OrderMapERSt6vectorINS_12UseListOrderESaISA_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL24predictValueUseListOrderPKN4llvm5ValueEPKNS_8FunctionERN12_GLOBAL__N_18OrderMapERSt6vectorINS_12UseListOrderESaISA_EE")
//</editor-fold>
public static void predictValueUseListOrder(/*const*/ Value /*P*/ V, /*const*/ Function /*P*/ F, 
                        final OrderMap /*&*/ OM, final std.vector<UseListOrder> /*&*/ Stack) {
  final std.pairUIntBool/*&*/ IDPair = OM.$at(V);
  assert ((IDPair.first != 0)) : "Unmapped value";
  if (IDPair.second) {
    // Already predicted.
    return;
  }
  
  // Do the actual prediction.
  IDPair.second = true;
  if (!V.use_empty() && std.next(V.use_begin$Const()).$noteq(V.use_end$Const())) {
    predictValueUseListOrderImpl(V, F, IDPair.first, OM, Stack);
  }
  {
    
    // Recursive descent into constants.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(V);
    if ((C != null)) {
      if ((C.getNumOperands() != 0)) { // Visit GlobalValues.
        for (/*const*/ Use /*P*/ U : C.operands$Const())  {
          Value /*P*/ Op = U.get();
          if (isa_Constant(Op)) { // Visit GlobalValues.
            predictValueUseListOrder(Op, F, OM, Stack);
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="predictUseListOrder">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 220,
 FQN="predictUseListOrder", NM="_ZL19predictUseListOrderPKN4llvm6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL19predictUseListOrderPKN4llvm6ModuleE")
//</editor-fold>
public static std.vector<UseListOrder> predictUseListOrder(/*const*/ Module /*P*/ M) {
  OrderMap OM = null;
  std.vector<UseListOrder> Stack = null;
  try {
    OM = orderModule(M);
    
    // Use-list orders need to be serialized after all the users have been added
    // to a value, or else the shuffles will be incomplete.  Store them per
    // function in a stack.
    //
    // Aside from function order, the order of values doesn't matter much here.
    Stack/*J*/= new std.vector<UseListOrder>(new UseListOrder());
    
    // We want to visit the functions backward now so we can list function-local
    // constants in the last Function they're used in.  Module-level constants
    // have already been visited above.
    for (final /*const*/ Function /*&*/ F : make_range(M.rbegin$Const(), M.rend$Const())) {
      if (F.isDeclaration()) {
        continue;
      }
      for (final /*const*/ BasicBlock /*&*/ BB : F)  {
        predictValueUseListOrder($AddrOf(BB), $AddrOf(F), OM, Stack);
      }
      for (final /*const*/ Argument /*&*/ A : F.args$Const())  {
        predictValueUseListOrder($AddrOf(A), $AddrOf(F), OM, Stack);
      }
      for (final /*const*/ BasicBlock /*&*/ BB : F)  {
        for (final /*const*/ Instruction /*&*/ I : BB)  {
          for (/*const*/ Use /*P*/ U : I.operands$Const())  {
            Value /*P*/ Op = U.get();
            if (isa_Constant($Deref(Op)) || isa_InlineAsm($Deref(Op))) { // Visit GlobalValues.
              predictValueUseListOrder(Op, $AddrOf(F), OM, Stack);
            }
          }
        }
      }
      for (final /*const*/ BasicBlock /*&*/ BB : F)  {
        for (final /*const*/ Instruction /*&*/ I : BB)  {
          predictValueUseListOrder($AddrOf(I), $AddrOf(F), OM, Stack);
        }
      }
    }
    
    // Visit globals last.
    for (final /*const*/ GlobalVariable /*&*/ G : M.globals$Const())  {
      predictValueUseListOrder($AddrOf(G), (/*const*/ Function /*P*/ )null, OM, Stack);
    }
    for (final /*const*/ Function /*&*/ F : $Deref(M))  {
      predictValueUseListOrder($AddrOf(F), (/*const*/ Function /*P*/ )null, OM, Stack);
    }
    for (final /*const*/ GlobalAlias /*&*/ A : M.aliases$Const())  {
      predictValueUseListOrder($AddrOf(A), (/*const*/ Function /*P*/ )null, OM, Stack);
    }
    for (final /*const*/ GlobalIFunc /*&*/ I : M.ifuncs$Const())  {
      predictValueUseListOrder($AddrOf(I), (/*const*/ Function /*P*/ )null, OM, Stack);
    }
    for (final /*const*/ GlobalVariable /*&*/ G : M.globals$Const())  {
      if (G.hasInitializer()) {
        predictValueUseListOrder(G.getInitializer$Const(), (/*const*/ Function /*P*/ )null, OM, Stack);
      }
    }
    for (final /*const*/ GlobalAlias /*&*/ A : M.aliases$Const())  {
      predictValueUseListOrder(A.getAliasee$Const(), (/*const*/ Function /*P*/ )null, OM, Stack);
    }
    for (final /*const*/ GlobalIFunc /*&*/ I : M.ifuncs$Const())  {
      predictValueUseListOrder(I.getResolver$Const(), (/*const*/ Function /*P*/ )null, OM, Stack);
    }
    for (final /*const*/ Function /*&*/ F : $Deref(M))  {
      for (final /*const*/ Use /*&*/ U : F.operands$Const())  {
        predictValueUseListOrder(U.get(), (/*const*/ Function /*P*/ )null, OM, Stack);
      }
    }
    
    return new std.vector<UseListOrder>(JD$Move.INSTANCE, Stack);
  } finally {
    if (Stack != null) { Stack.$destroy(); }
    if (OM != null) { OM.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getModuleFromVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 273,
 FQN="getModuleFromVal", NM="_ZL16getModuleFromValPKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16getModuleFromValPKN4llvm5ValueE")
//</editor-fold>
public static /*const*/ Module /*P*/ getModuleFromVal(/*const*/ Value /*P*/ V) {
  {
    /*const*/ Argument /*P*/ MA = dyn_cast_Argument(V);
    if ((MA != null)) {
      return (MA.getParent$Const() != null) ? MA.getParent$Const().getParent$Const() : null;
    }
  }
  {
    
    /*const*/ BasicBlock /*P*/ BB = dyn_cast_BasicBlock(V);
    if ((BB != null)) {
      return (BB.getParent$Const() != null) ? BB.getParent$Const().getParent$Const() : null;
    }
  }
  {
    
    /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(V);
    if ((I != null)) {
      /*const*/ Function /*P*/ M = (I.getParent$Const() != null) ? I.getParent$Const().getParent$Const() : null;
      return (M != null) ? M.getParent$Const() : null;
    }
  }
  {
    
    /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(V);
    if ((GV != null)) {
      return GV.getParent$Const();
    }
  }
  {
    
    /*const*/ MetadataAsValue /*P*/ MAV = dyn_cast_MetadataAsValue(V);
    if ((MAV != null)) {
      for (/*const*/ User /*P*/ U : MAV.users$Const())  {
        if (isa_Instruction(U)) {
          {
            /*const*/ Module /*P*/ M = getModuleFromVal(U);
            if ((M != null)) {
              return M;
            }
          }
        }
      }
      return null;
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="PrintCallingConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 299,
 FQN="PrintCallingConv", NM="_ZL16PrintCallingConvjRN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16PrintCallingConvjRN4llvm11raw_ostreamE")
//</editor-fold>
public static void PrintCallingConv(/*uint*/int cc, final raw_ostream /*&*/ Out) {
  switch (cc) {
   default:
    Out.$out(/*KEEP_STR*/"cc").$out_uint(cc);
    break;
   case CallingConv.Fast:
    Out.$out(/*KEEP_STR*/"fastcc");
    break;
   case CallingConv.Cold:
    Out.$out(/*KEEP_STR*/"coldcc");
    break;
   case CallingConv.WebKit_JS:
    Out.$out(/*KEEP_STR*/"webkit_jscc");
    break;
   case CallingConv.AnyReg:
    Out.$out(/*KEEP_STR*/"anyregcc");
    break;
   case CallingConv.PreserveMost:
    Out.$out(/*KEEP_STR*/"preserve_mostcc");
    break;
   case CallingConv.PreserveAll:
    Out.$out(/*KEEP_STR*/"preserve_allcc");
    break;
   case CallingConv.CXX_FAST_TLS:
    Out.$out(/*KEEP_STR*/"cxx_fast_tlscc");
    break;
   case CallingConv.GHC:
    Out.$out(/*KEEP_STR*/"ghccc");
    break;
   case CallingConv.X86_StdCall:
    Out.$out(/*KEEP_STR*/"x86_stdcallcc");
    break;
   case CallingConv.X86_FastCall:
    Out.$out(/*KEEP_STR*/"x86_fastcallcc");
    break;
   case CallingConv.X86_ThisCall:
    Out.$out(/*KEEP_STR*/"x86_thiscallcc");
    break;
   case CallingConv.X86_VectorCall:
    Out.$out(/*KEEP_STR*/"x86_vectorcallcc");
    break;
   case CallingConv.Intel_OCL_BI:
    Out.$out(/*KEEP_STR*/"intel_ocl_bicc");
    break;
   case CallingConv.ARM_APCS:
    Out.$out(/*KEEP_STR*/"arm_apcscc");
    break;
   case CallingConv.ARM_AAPCS:
    Out.$out(/*KEEP_STR*/"arm_aapcscc");
    break;
   case CallingConv.ARM_AAPCS_VFP:
    Out.$out(/*KEEP_STR*/"arm_aapcs_vfpcc");
    break;
   case CallingConv.MSP430_INTR:
    Out.$out(/*KEEP_STR*/"msp430_intrcc");
    break;
   case CallingConv.AVR_INTR:
    Out.$out(/*KEEP_STR*/"avr_intrcc ");
    break;
   case CallingConv.AVR_SIGNAL:
    Out.$out(/*KEEP_STR*/"avr_signalcc ");
    break;
   case CallingConv.PTX_Kernel:
    Out.$out(/*KEEP_STR*/"ptx_kernel");
    break;
   case CallingConv.PTX_Device:
    Out.$out(/*KEEP_STR*/"ptx_device");
    break;
   case CallingConv.X86_64_SysV:
    Out.$out(/*KEEP_STR*/"x86_64_sysvcc");
    break;
   case CallingConv.X86_64_Win64:
    Out.$out(/*KEEP_STR*/"x86_64_win64cc");
    break;
   case CallingConv.SPIR_FUNC:
    Out.$out(/*KEEP_STR*/"spir_func");
    break;
   case CallingConv.SPIR_KERNEL:
    Out.$out(/*KEEP_STR*/"spir_kernel");
    break;
   case CallingConv.Swift:
    Out.$out(/*KEEP_STR*/"swiftcc");
    break;
   case CallingConv.X86_INTR:
    Out.$out(/*KEEP_STR*/"x86_intrcc");
    break;
   case CallingConv.HHVM:
    Out.$out(/*KEEP_STR*/"hhvmcc");
    break;
   case CallingConv.HHVM_C:
    Out.$out(/*KEEP_STR*/"hhvm_ccc");
    break;
   case CallingConv.AMDGPU_VS:
    Out.$out(/*KEEP_STR*/"amdgpu_vs");
    break;
   case CallingConv.AMDGPU_GS:
    Out.$out(/*KEEP_STR*/"amdgpu_gs");
    break;
   case CallingConv.AMDGPU_PS:
    Out.$out(/*KEEP_STR*/"amdgpu_ps");
    break;
   case CallingConv.AMDGPU_CS:
    Out.$out(/*KEEP_STR*/"amdgpu_cs");
    break;
   case CallingConv.AMDGPU_KERNEL:
    Out.$out(/*KEEP_STR*/"amdgpu_kernel");
    break;
  }
}


// PrintEscapedString - Print each character of the specified string, escaping
// it if it is not printable or if it is an escape char.
//<editor-fold defaultstate="collapsed" desc="PrintEscapedString">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 341,
 FQN="PrintEscapedString", NM="_ZL18PrintEscapedStringN4llvm9StringRefERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL18PrintEscapedStringN4llvm9StringRefERNS_11raw_ostreamE")
//</editor-fold>
public static void PrintEscapedString(StringRef Name, final raw_ostream /*&*/ Out) {
  for (/*uint*/int i = 0, e = Name.size(); i != e; ++i) {
    /*uchar*/byte C = Name.$at(i);
    if ((isprint($uchar2int(C)) != 0) && $uchar2int(C) != $$BACK_SLASH && $uchar2int(C) != $$DBL_QUOTE) {
      Out.$out_uchar(C);
    } else {
      Out.$out_char($$BACK_SLASH).$out_char(llvm.hexdigit($uchar2int(C) >> 4)).$out_char(llvm.hexdigit($uchar2int(C) & 0x0F));
    }
  }
}


/// Turn the specified name into an 'LLVM name', which is either prefixed with %
/// (if the string only contains simple characters) or is surrounded with ""'s
/// (if it has special chars in it). Print it out.
//<editor-fold defaultstate="collapsed" desc="PrintLLVMName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 395,
 FQN="PrintLLVMName", NM="_ZL13PrintLLVMNameRN4llvm11raw_ostreamENS_9StringRefE10PrefixType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL13PrintLLVMNameRN4llvm11raw_ostreamENS_9StringRefE10PrefixType")
//</editor-fold>
public static void PrintLLVMName(final raw_ostream /*&*/ OS, StringRef Name, PrefixType Prefix) {
  switch (Prefix) {
   case NoPrefix:
    break;
   case GlobalPrefix:
    OS.$out_char($$AT);
    break;
   case ComdatPrefix:
    OS.$out_char($$DOLLAR);
    break;
   case LabelPrefix:
    break;
   case LocalPrefix:
    OS.$out_char($$PERCENT);
    break;
  }
  IrLlvmGlobals.printLLVMNameWithoutPrefix(OS, new StringRef(Name));
}


/// Turn the specified name into an 'LLVM name', which is either prefixed with %
/// (if the string only contains simple characters) or is surrounded with ""'s
/// (if it has special chars in it). Print it out.
//<editor-fold defaultstate="collapsed" desc="PrintLLVMName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 417,
 FQN="PrintLLVMName", NM="_ZL13PrintLLVMNameRN4llvm11raw_ostreamEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL13PrintLLVMNameRN4llvm11raw_ostreamEPKNS_5ValueE")
//</editor-fold>
public static void PrintLLVMName(final raw_ostream /*&*/ OS, /*const*/ Value /*P*/ V) {
  PrintLLVMName(OS, V.getName(), 
      isa_GlobalValue(V) ? PrefixType.GlobalPrefix : PrefixType.LocalPrefix);
}

//<editor-fold defaultstate="collapsed" desc="createSlotTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 739,
 FQN="createSlotTracker", NM="_ZL17createSlotTrackerPKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL17createSlotTrackerPKN4llvm5ValueE")
//</editor-fold>
public static SlotTracker /*P*/ createSlotTracker(/*const*/ Value /*P*/ V) {
  {
    /*const*/ Argument /*P*/ FA = dyn_cast_Argument(V);
    if ((FA != null)) {
      return new SlotTracker(FA.getParent$Const());
    }
  }
  {
    
    /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(V);
    if ((I != null)) {
      if ((I.getParent$Const() != null)) {
        return new SlotTracker(I.getParent$Const().getParent$Const());
      }
    }
  }
  {
    
    /*const*/ BasicBlock /*P*/ BB = dyn_cast_BasicBlock(V);
    if ((BB != null)) {
      return new SlotTracker(BB.getParent$Const());
    }
  }
  {
    
    /*const*/ GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(V);
    if ((GV != null)) {
      return new SlotTracker(GV.getParent$Const());
    }
  }
  {
    
    /*const*/ GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(V);
    if ((GA != null)) {
      return new SlotTracker(GA.getParent$Const());
    }
  }
  {
    
    /*const*/ GlobalIFunc /*P*/ GIF = dyn_cast_GlobalIFunc(V);
    if ((GIF != null)) {
      return new SlotTracker(GIF.getParent$Const());
    }
  }
  {
    
    /*const*/ Function /*P*/ Func = dyn_cast_Function(V);
    if ((Func != null)) {
      return new SlotTracker(Func);
    }
  }
  
  return null;
}


//===----------------------------------------------------------------------===//
// AsmWriter Implementation
//===----------------------------------------------------------------------===//

// Full implementation of printing a Value as an operand with support for
// TypePrinting, etc.
//<editor-fold defaultstate="collapsed" desc="WriteAsOperandInternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1940,
 FQN="WriteAsOperandInternal", NM="_ZL22WriteAsOperandInternalRN4llvm11raw_ostreamEPKNS_5ValueEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL22WriteAsOperandInternalRN4llvm11raw_ostreamEPKNS_5ValueEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void WriteAsOperandInternal(final raw_ostream /*&*/ Out, /*const*/ Value /*P*/ V, 
                      TypePrinting /*P*/ TypePrinter, 
                      SlotTracker /*P*/ Machine, 
                      /*const*/ Module /*P*/ Context) {
  if (V.hasName()) {
    PrintLLVMName(Out, V);
    return;
  }
  
  /*const*/ Constant /*P*/ CV = dyn_cast_Constant(V);
  if ((CV != null) && !isa_GlobalValue(CV)) {
    assert ((TypePrinter != null)) : "Constants require TypePrinting!";
    WriteConstantInternal(Out, CV, $Deref(TypePrinter), Machine, Context);
    return;
  }
  {
    
    /*const*/ InlineAsm /*P*/ IA = dyn_cast_InlineAsm(V);
    if ((IA != null)) {
      Out.$out(/*KEEP_STR*/"asm ");
      if (IA.hasSideEffects()) {
        Out.$out(/*KEEP_STR*/"sideeffect ");
      }
      if (IA.isAlignStack()) {
        Out.$out(/*KEEP_STR*/"alignstack ");
      }
      // We don't emit the AD_ATT dialect as it's the assumed default.
      if (IA.getDialect() == InlineAsm.AsmDialect.AD_Intel) {
        Out.$out(/*KEEP_STR*/"inteldialect ");
      }
      Out.$out_char($$DBL_QUOTE);
      PrintEscapedString(new StringRef(IA.getAsmString()), Out);
      Out.$out(/*KEEP_STR*/"\", \"");
      PrintEscapedString(new StringRef(IA.getConstraintString()), Out);
      Out.$out_char($$DBL_QUOTE);
      return;
    }
  }
  {
    
    /*const*/ MetadataAsValue /*P*/ MD = dyn_cast_MetadataAsValue(V);
    if ((MD != null)) {
      WriteAsOperandInternal(Out, MD.getMetadata(), TypePrinter, Machine, 
          Context, /* FromValue */ true);
      return;
    }
  }
  
  /*char*/byte Prefix = $$PERCENT;
  int Slot;
  // If we have a SlotTracker, use it.
  if ((Machine != null)) {
    {
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(V);
      if ((GV != null)) {
        Slot = Machine.getGlobalSlot(GV);
        Prefix = $$AT;
      } else {
        Slot = Machine.getLocalSlot(V);
        
        // If the local value didn't succeed, then we may be referring to a value
        // from a different function.  Translate it, as this can happen when using
        // address of blocks.
        if (Slot == -1) {
          if (((Machine = createSlotTracker(V)) != null)) {
            Slot = Machine.getLocalSlot(V);
            /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Machine);
          }
        }
      }
    }
  } else if (((Machine = createSlotTracker(V)) != null)) {
    {
      // Otherwise, create one to get the # and then destroy it.
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(V);
      if ((GV != null)) {
        Slot = Machine.getGlobalSlot(GV);
        Prefix = $$AT;
      } else {
        Slot = Machine.getLocalSlot(V);
      }
    }
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Machine);
    Machine = null;
  } else {
    Slot = -1;
  }
  if (Slot != -1) {
    Out.$out_char(Prefix).$out_int(Slot);
  } else {
    Out.$out(/*KEEP_STR*/"<badref>");
  }
}

//<editor-fold defaultstate="collapsed" desc="WriteAsOperandInternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2018,
 FQN="WriteAsOperandInternal", NM="_ZL22WriteAsOperandInternalRN4llvm11raw_ostreamEPKNS_8MetadataEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL22WriteAsOperandInternalRN4llvm11raw_ostreamEPKNS_8MetadataEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleEb")
//</editor-fold>
public static void WriteAsOperandInternal(final raw_ostream /*&*/ Out, /*const*/ Metadata /*P*/ MD, 
                      TypePrinting /*P*/ TypePrinter, 
                      SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
  WriteAsOperandInternal(Out, MD, 
                      TypePrinter, 
                      Machine, Context, 
                      false);
}
public static void WriteAsOperandInternal(final raw_ostream /*&*/ Out, /*const*/ Metadata /*P*/ MD, 
                      TypePrinting /*P*/ TypePrinter, 
                      SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context, 
                      boolean FromValue/*= false*/) {
  {
    /*const*/ MDNode /*P*/ N = dyn_cast_MDNode(MD);
    if ((N != null)) {
      std.unique_ptr<SlotTracker> MachineStorage = null;
      try {
        MachineStorage/*J*/= new std.unique_ptr<SlotTracker>();
        if (!(Machine != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(MachineStorage.$assignMove($c$.track(llvm.make_unique(new SlotTracker(Context)))));
            Machine = MachineStorage.get();
          } finally {
            $c$.$destroy();
          }
        }
        int Slot = Machine.getMetadataSlot(N);
        if (Slot == -1) {
          // Give the pointer value instead of "badref", since this comes up all
          // the time when debugging.
          Out.$out(/*KEEP_STR*/$LT).$out(N).$out(/*KEEP_STR*/$GT);
        } else {
          Out.$out_char($$EXCLAMATION).$out_int(Slot);
        }
        return;
      } finally {
        if (MachineStorage != null) { MachineStorage.$destroy(); }
      }
    }
  }
  {
    
    /*const*/ MDString /*P*/ MDS = dyn_cast_MDString(MD);
    if ((MDS != null)) {
      Out.$out(/*KEEP_STR*/"!\"");
      PrintEscapedString(MDS.getString(), Out);
      Out.$out_char($$DBL_QUOTE);
      return;
    }
  }
  
  /*const*/ ValueAsMetadata /*P*/ V = cast_ValueAsMetadata(MD);
  assert ((TypePrinter != null)) : "TypePrinter required for metadata values";
  assert ((FromValue || !isa_LocalAsMetadata(V))) : "Unexpected function-local metadata outside of value argument";
  
  TypePrinter.print(V.getValue().getType(), Out);
  Out.$out_char($$SPACE);
  WriteAsOperandInternal(Out, V.getValue(), TypePrinter, Machine, Context);
}

//<editor-fold defaultstate="collapsed" desc="getPredicateText">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1044,
 FQN="getPredicateText", NM="_ZL16getPredicateTextj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16getPredicateTextj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getPredicateText(/*uint*/int predicate) {
  /*const*/char$ptr/*char P*/ pred = $unknown;
  switch (CmpInst.Predicate.valueOf(predicate)) {
   case FCMP_FALSE:
    pred = $false;
    break;
   case FCMP_OEQ:
    pred = $("oeq");
    break;
   case FCMP_OGT:
    pred = $("ogt");
    break;
   case FCMP_OGE:
    pred = $("oge");
    break;
   case FCMP_OLT:
    pred = $("olt");
    break;
   case FCMP_OLE:
    pred = $("ole");
    break;
   case FCMP_ONE:
    pred = $("one");
    break;
   case FCMP_ORD:
    pred = $("ord");
    break;
   case FCMP_UNO:
    pred = $("uno");
    break;
   case FCMP_UEQ:
    pred = $("ueq");
    break;
   case FCMP_UGT:
    pred = $("ugt");
    break;
   case FCMP_UGE:
    pred = $("uge");
    break;
   case FCMP_ULT:
    pred = $("ult");
    break;
   case FCMP_ULE:
    pred = $("ule");
    break;
   case FCMP_UNE:
    pred = $("une");
    break;
   case FCMP_TRUE:
    pred = $true;
    break;
   case ICMP_EQ:
    pred = $("eq");
    break;
   case ICMP_NE:
    pred = $("ne");
    break;
   case ICMP_SGT:
    pred = $("sgt");
    break;
   case ICMP_SGE:
    pred = $("sge");
    break;
   case ICMP_SLT:
    pred = $("slt");
    break;
   case ICMP_SLE:
    pred = $("sle");
    break;
   case ICMP_UGT:
    pred = $("ugt");
    break;
   case ICMP_UGE:
    pred = $("uge");
    break;
   case ICMP_ULT:
    pred = $("ult");
    break;
   case ICMP_ULE:
    pred = $("ule");
    break;
  }
  return pred;
}

//<editor-fold defaultstate="collapsed" desc="writeAtomicRMWOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1077,
 FQN="writeAtomicRMWOperation", NM="_ZL23writeAtomicRMWOperationRN4llvm11raw_ostreamENS_13AtomicRMWInst5BinOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL23writeAtomicRMWOperationRN4llvm11raw_ostreamENS_13AtomicRMWInst5BinOpE")
//</editor-fold>
public static void writeAtomicRMWOperation(final raw_ostream /*&*/ Out, 
                       AtomicRMWInst.BinOp Op) {
  switch (Op) {
   default:
    Out.$out(/*KEEP_STR*/" <unknown operation ").$out_int(Op.getValue()).$out(/*KEEP_STR*/$GT);
    break;
   case Xchg:
    Out.$out(/*KEEP_STR*/" xchg");
    break;
   case Add:
    Out.$out(/*KEEP_STR*/" add");
    break;
   case Sub:
    Out.$out(/*KEEP_STR*/" sub");
    break;
   case And:
    Out.$out(/*KEEP_STR*/" and");
    break;
   case Nand:
    Out.$out(/*KEEP_STR*/" nand");
    break;
   case Or:
    Out.$out(/*KEEP_STR*/" or");
    break;
   case Xor:
    Out.$out(/*KEEP_STR*/" xor");
    break;
   case Max:
    Out.$out(/*KEEP_STR*/" max");
    break;
   case Min:
    Out.$out(/*KEEP_STR*/" min");
    break;
   case UMax:
    Out.$out(/*KEEP_STR*/" umax");
    break;
   case UMin:
    Out.$out(/*KEEP_STR*/" umin");
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="WriteOptimizationInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1095,
 FQN="WriteOptimizationInfo", NM="_ZL21WriteOptimizationInfoRN4llvm11raw_ostreamEPKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL21WriteOptimizationInfoRN4llvm11raw_ostreamEPKNS_4UserE")
//</editor-fold>
public static void WriteOptimizationInfo(final raw_ostream /*&*/ Out, /*const*/ User /*P*/ U) {
  {
    /*const*/ FPMathOperator /*P*/ FPO = dyn_cast_FPMathOperator(U);
    if ((FPO != null)) {
      // Unsafe algebra implies all the others, no need to write them all out
      if (FPO.hasUnsafeAlgebra()) {
        Out.$out(/*KEEP_STR*/" fast");
      } else {
        if (FPO.hasNoNaNs()) {
          Out.$out(/*KEEP_STR*/" nnan");
        }
        if (FPO.hasNoInfs()) {
          Out.$out(/*KEEP_STR*/" ninf");
        }
        if (FPO.hasNoSignedZeros()) {
          Out.$out(/*KEEP_STR*/" nsz");
        }
        if (FPO.hasAllowReciprocal()) {
          Out.$out(/*KEEP_STR*/" arcp");
        }
      }
    }
  }
  {
    
    /*const*/ OverflowingBinaryOperator /*P*/ OBO = dyn_cast_OverflowingBinaryOperator(U);
    if ((OBO != null)) {
      if (OBO.hasNoUnsignedWrap()) {
        Out.$out(/*KEEP_STR*/" nuw");
      }
      if (OBO.hasNoSignedWrap()) {
        Out.$out(/*KEEP_STR*/" nsw");
      }
    } else {
      /*const*/ PossiblyExactOperator /*P*/ Div = dyn_cast_PossiblyExactOperator(U);
      if ((Div != null)) {
        if (Div.isExact()) {
          Out.$out(/*KEEP_STR*/" exact");
        }
      } else {
        /*const*/ GEPOperator /*P*/ GEP = dyn_cast_GEPOperator(U);
        if ((GEP != null)) {
          if (GEP.isInBounds()) {
            Out.$out(/*KEEP_STR*/" inbounds");
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="WriteConstantInternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1128,
 FQN="WriteConstantInternal", NM="_ZL21WriteConstantInternalRN4llvm11raw_ostreamEPKNS_8ConstantERN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL21WriteConstantInternalRN4llvm11raw_ostreamEPKNS_8ConstantERN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void WriteConstantInternal(final raw_ostream /*&*/ Out, /*const*/ Constant /*P*/ CV, 
                     final TypePrinting /*&*/ TypePrinter, 
                     SlotTracker /*P*/ Machine, 
                     /*const*/ Module /*P*/ Context) {
  {
    /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(CV);
    if ((CI != null)) {
      if (CI.getType().isIntegerTy(1)) {
        Out.$out(((CI.getZExtValue() != 0) ? $true : $false));
        return;
      }
      $out_raw_ostream_APInt$C(Out, CI.getValue());
      return;
    }
  }
  {
    
    /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(CV);
    if ((CFP != null)) {
      if ($AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.IEEEsingle)
         || $AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.IEEEdouble)) {
        // We would like to output the FP constant value in exponential notation,
        // but we cannot do this if doing so will lose precision.  Check here to
        // make sure that we only output it in exponential format if we can parse
        // the value back and get the same value.
        //
        bool$ptr ignored = create_bool$ptr();
        boolean isDouble = $AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.IEEEdouble);
        boolean isInf = CFP.getValueAPF().isInfinity();
        boolean isNaN = CFP.getValueAPF().isNaN();
        if (!isInf && !isNaN) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            double Val = isDouble ? CFP.getValueAPF().convertToDouble() : CFP.getValueAPF().convertToFloat();
            SmallString/*<128>*/ StrVal/*J*/= new SmallString/*<128>*/(128);
            $c$.clean($c$.track(new raw_svector_ostream(StrVal)).$out_double(Val));
            
            // Check to make sure that the stringized number is not some string like
            // "Inf" or NaN, that atof will accept, but the lexer will not.  Check
            // that the string matches the "[-+]?[0-9]" regex.
            //
            if ((StrVal.$at(0) >= $$0 && StrVal.$at(0) <= $$9)
               || ((StrVal.$at(0) == $$MINUS || StrVal.$at(0) == $$PLUS)
               && (StrVal.$at(1) >= $$0 && StrVal.$at(1) <= $$9))) {
              // Reparse stringized version!
              if (new APFloat(APFloat.IEEEdouble, StrVal.$StringRef()).convertToDouble() == Val) {
                Out.$out(StrVal);
                return;
              }
            }
          } finally {
            $c$.$destroy();
          }
        }
        // Otherwise we could not reparse it to exactly the same value, so we must
        // output the string in hexadecimal format!  Note that loading and storing
        // floating point types changes the bits of NaNs on some hosts, notably
        // x86, so we must not use these types.
        static_assert($sizeof_Double() == $sizeof_ULong(), $("assuming that double is 64 bits!"));
        APFloat apf = new APFloat(CFP.getValueAPF());
        // Floats are represented in ASCII IR as double, convert.
        if (!isDouble) {
          apf.convert(APFloat.IEEEdouble, APFloat.roundingMode.rmNearestTiesToEven, 
              $AddrOf(ignored));
        }
        Out.$out(format_hex(apf.bitcastToAPInt().getZExtValue(), 0, /*Upper=*/ true));
        return;
      }
      
      // Either half, or some form of long double.
      // These appear as a magic letter identifying the type, then a
      // fixed number of hex digits.
      Out.$out(/*KEEP_STR*/"0x");
      APInt API = CFP.getValueAPF().bitcastToAPInt();
      if ($AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.x87DoubleExtended)) {
        Out.$out_char($$K);
        Out.$out(format_hex_no_prefix(API.getHiBits(16).getZExtValue(), 4, 
                /*Upper=*/ true));
        Out.$out(format_hex_no_prefix(API.getLoBits(64).getZExtValue(), 16, 
                /*Upper=*/ true));
        return;
      } else if ($AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.IEEEquad)) {
        Out.$out_char($$L);
        Out.$out(format_hex_no_prefix(API.getLoBits(64).getZExtValue(), 16, 
                /*Upper=*/ true));
        Out.$out(format_hex_no_prefix(API.getHiBits(64).getZExtValue(), 16, 
                /*Upper=*/ true));
      } else if ($AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.PPCDoubleDouble)) {
        Out.$out_char($$M);
        Out.$out(format_hex_no_prefix(API.getLoBits(64).getZExtValue(), 16, 
                /*Upper=*/ true));
        Out.$out(format_hex_no_prefix(API.getHiBits(64).getZExtValue(), 16, 
                /*Upper=*/ true));
      } else if ($AddrOf(CFP.getValueAPF().getSemantics()) == $AddrOf(APFloat.IEEEhalf)) {
        Out.$out_char($$H);
        Out.$out(format_hex_no_prefix(API.getZExtValue(), 4, 
                /*Upper=*/ true));
      } else {
        throw new llvm_unreachable("Unsupported floating point type");
      }
      return;
    }
  }
  if (isa_ConstantAggregateZero(CV)) {
    Out.$out(/*KEEP_STR*/"zeroinitializer");
    return;
  }
  {
    
    /*const*/ BlockAddress /*P*/ BA = dyn_cast_BlockAddress(CV);
    if ((BA != null)) {
      Out.$out(/*KEEP_STR*/"blockaddress(");
      WriteAsOperandInternal(Out, BA.getFunction(), $AddrOf(TypePrinter), Machine, 
          Context);
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      WriteAsOperandInternal(Out, BA.getBasicBlock(), $AddrOf(TypePrinter), Machine, 
          Context);
      Out.$out(/*KEEP_STR*/$RPAREN);
      return;
    }
  }
  {
    
    /*const*/ ConstantArray /*P*/ CA = dyn_cast_ConstantArray(CV);
    if ((CA != null)) {
      Type /*P*/ ETy = CA.getType().getElementType();
      Out.$out_char($$LSQUARE);
      TypePrinter.print(ETy, Out);
      Out.$out_char($$SPACE);
      WriteAsOperandInternal(Out, CA.getOperand(0), 
          $AddrOf(TypePrinter), Machine, 
          Context);
      for (/*uint*/int i = 1, e = CA.getNumOperands(); i != e; ++i) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        TypePrinter.print(ETy, Out);
        Out.$out_char($$SPACE);
        WriteAsOperandInternal(Out, CA.getOperand(i), $AddrOf(TypePrinter), Machine, 
            Context);
      }
      Out.$out_char($$RSQUARE);
      return;
    }
  }
  {
    
    /*const*/ ConstantDataArray /*P*/ CA = dyn_cast_ConstantDataArray(CV);
    if ((CA != null)) {
      // As a special case, print the array as a string if it is an array of
      // i8 with ConstantInt values.
      if (CA.isString()) {
        Out.$out(/*KEEP_STR*/"c\"");
        PrintEscapedString(CA.getAsString(), Out);
        Out.$out_char($$DBL_QUOTE);
        return;
      }
      
      Type /*P*/ ETy = CA.getType().getElementType();
      Out.$out_char($$LSQUARE);
      TypePrinter.print(ETy, Out);
      Out.$out_char($$SPACE);
      WriteAsOperandInternal(Out, CA.getElementAsConstant(0), 
          $AddrOf(TypePrinter), Machine, 
          Context);
      for (/*uint*/int i = 1, e = CA.getNumElements(); i != e; ++i) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        TypePrinter.print(ETy, Out);
        Out.$out_char($$SPACE);
        WriteAsOperandInternal(Out, CA.getElementAsConstant(i), $AddrOf(TypePrinter), 
            Machine, Context);
      }
      Out.$out_char($$RSQUARE);
      return;
    }
  }
  {
    
    /*const*/ ConstantStruct /*P*/ CS = dyn_cast_ConstantStruct(CV);
    if ((CS != null)) {
      if (CS.getType().isPacked()) {
        Out.$out_char($$LT);
      }
      Out.$out_char($$LCURLY);
      /*uint*/int N = CS.getNumOperands();
      if ((N != 0)) {
        Out.$out_char($$SPACE);
        TypePrinter.print(CS.getOperand(0).getType(), Out);
        Out.$out_char($$SPACE);
        
        WriteAsOperandInternal(Out, CS.getOperand(0), $AddrOf(TypePrinter), Machine, 
            Context);
        
        for (/*uint*/int i = 1; $less_uint(i, N); i++) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          TypePrinter.print(CS.getOperand(i).getType(), Out);
          Out.$out_char($$SPACE);
          
          WriteAsOperandInternal(Out, CS.getOperand(i), $AddrOf(TypePrinter), Machine, 
              Context);
        }
        Out.$out_char($$SPACE);
      }
      
      Out.$out_char($$RCURLY);
      if (CS.getType().isPacked()) {
        Out.$out_char($$GT);
      }
      return;
    }
  }
  if (isa_ConstantVector(CV) || isa_ConstantDataVector(CV)) {
    Type /*P*/ ETy = CV.getType().getVectorElementType();
    Out.$out_char($$LT);
    TypePrinter.print(ETy, Out);
    Out.$out_char($$SPACE);
    WriteAsOperandInternal(Out, CV.getAggregateElement(0/*U*/), $AddrOf(TypePrinter), 
        Machine, Context);
    for (/*uint*/int i = 1, e = CV.getType().getVectorNumElements(); i != e; ++i) {
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      TypePrinter.print(ETy, Out);
      Out.$out_char($$SPACE);
      WriteAsOperandInternal(Out, CV.getAggregateElement(i), $AddrOf(TypePrinter), 
          Machine, Context);
    }
    Out.$out_char($$GT);
    return;
  }
  if (isa_ConstantPointerNull(CV)) {
    Out.$out(/*KEEP_STR*/"null");
    return;
  }
  if (isa_ConstantTokenNone(CV)) {
    Out.$out(/*KEEP_STR*/"none");
    return;
  }
  if (isa_UndefValue(CV)) {
    Out.$out(/*KEEP_STR*/$undef);
    return;
  }
  {
    
    /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(CV);
    if ((CE != null)) {
      Out.$out(CE.getOpcodeName());
      WriteOptimizationInfo(Out, CE);
      if (CE.isCompare()) {
        Out.$out_char($$SPACE).$out(getPredicateText(CE.getPredicate()));
      }
      Out.$out(/*KEEP_STR*/" (");
      {
        
        /*const*/ GEPOperator /*P*/ GEP = dyn_cast_GEPOperator(CE);
        if ((GEP != null)) {
          TypePrinter.print(GEP.getSourceElementType(), Out);
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
      }
      
      for (/*const*/type$ptr<Use /*P*/> OI = $tryClone(CE.op_begin$Const()); $noteq_ptr(OI, CE.op_end$Const()); OI.$preInc()) {
        TypePrinter.print((OI.$star()).$arrow$Const().getType(), Out);
        Out.$out_char($$SPACE);
        WriteAsOperandInternal(Out, OI.$star().$Value$P(), $AddrOf(TypePrinter), Machine, Context);
        if ($noteq_ptr(OI.$add(1), CE.op_end$Const())) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
      }
      if (CE.hasIndices()) {
        ArrayRefUInt Indices = CE.getIndices();
        for (/*uint*/int i = 0, e = Indices.size(); i != e; ++i)  {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(Indices.$at(i));
        }
      }
      if (CE.isCast()) {
        Out.$out(/*KEEP_STR*/" to ");
        TypePrinter.print(CE.getType(), Out);
      }
      
      Out.$out_char($$RPAREN);
      return;
    }
  }
  
  Out.$out(/*KEEP_STR*/"<placeholder or erroneous Constant>");
}

//<editor-fold defaultstate="collapsed" desc="writeMDTuple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1386,
 FQN="writeMDTuple", NM="_ZL12writeMDTupleRN4llvm11raw_ostreamEPKNS_7MDTupleEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL12writeMDTupleRN4llvm11raw_ostreamEPKNS_7MDTupleEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeMDTuple(final raw_ostream /*&*/ Out, /*const*/ MDTuple /*P*/ Node, 
            TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
            /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!{");
  for (/*uint*/int mi = 0, me = Node.getNumOperands(); mi != me; ++mi) {
    /*const*/ Metadata /*P*/ MD = Node.getOperand(mi).$Metadata$P();
    if (!(MD != null)) {
      Out.$out(/*KEEP_STR*/"null");
    } else {
      /*const*/ ValueAsMetadata /*P*/ MDV = dyn_cast_ValueAsMetadata(MD);
      if ((MDV != null)) {
        Value /*P*/ V = MDV.getValue();
        TypePrinter.print(V.getType(), Out);
        Out.$out_char($$SPACE);
        WriteAsOperandInternal(Out, V, TypePrinter, Machine, Context);
      } else {
        WriteAsOperandInternal(Out, MD, TypePrinter, Machine, Context);
      }
    }
    if (mi + 1 != me) {
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
    }
  }
  
  Out.$out(/*KEEP_STR*/$RCURLY);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1415,
 FQN="(anonymous namespace)::operator<<", NM="_ZN12_GLOBAL__N_1lsERN4llvm11raw_ostreamERNS_14FieldSeparatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_1lsERN4llvm11raw_ostreamERNS_14FieldSeparatorE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_FieldSeparator(final raw_ostream /*&*/ OS, final FieldSeparator /*&*/ FS) {
  if (FS.Skip) {
    FS.Skip = false;
    return OS;
  }
  return OS.$out(FS.Sep);
}

//<editor-fold defaultstate="collapsed" desc="writeMetadataAsOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1478,
 FQN="writeMetadataAsOperand", NM="_ZL22writeMetadataAsOperandRN4llvm11raw_ostreamEPKNS_8MetadataEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL22writeMetadataAsOperandRN4llvm11raw_ostreamEPKNS_8MetadataEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeMetadataAsOperand(final raw_ostream /*&*/ Out, /*const*/ Metadata /*P*/ MD, 
                      TypePrinting /*P*/ TypePrinter, 
                      SlotTracker /*P*/ Machine, 
                      /*const*/ Module /*P*/ Context) {
  if (!(MD != null)) {
    Out.$out(/*KEEP_STR*/"null");
    return;
  }
  WriteAsOperandInternal(Out, MD, TypePrinter, Machine, Context);
}

//<editor-fold defaultstate="collapsed" desc="writeGenericDINode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1548,
 FQN="writeGenericDINode", NM="_ZL18writeGenericDINodeRN4llvm11raw_ostreamEPKNS_13GenericDINodeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL18writeGenericDINodeRN4llvm11raw_ostreamEPKNS_13GenericDINodeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeGenericDINode(final raw_ostream /*&*/ Out, /*const*/ GenericDINode /*P*/ N, 
                  TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                  /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!GenericDINode(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printTag(N);
  Printer.printString(new StringRef(/*KEEP_STR*/"header"), N.getHeader());
  if ((N.getNumDwarfOperands() != 0)) {
    $out_raw_ostream_FieldSeparator(Out, Printer.FS).$out(/*KEEP_STR*/"operands: {");
    FieldSeparator IFS/*J*/= new FieldSeparator();
    for (final /*const*/ MDOperand /*&*/ I : N.dwarf_operands()) {
      $out_raw_ostream_FieldSeparator(Out, IFS);
      writeMetadataAsOperand(Out, I.$Metadata$P(), TypePrinter, Machine, Context);
    }
    Out.$out(/*KEEP_STR*/$RCURLY);
  }
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDILocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1567,
 FQN="writeDILocation", NM="_ZL15writeDILocationRN4llvm11raw_ostreamEPKNS_10DILocationEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL15writeDILocationRN4llvm11raw_ostreamEPKNS_10DILocationEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDILocation(final raw_ostream /*&*/ Out, /*const*/ DILocation /*P*/ DL, 
               TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
               /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DILocation(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  // Always output the line, since 0 is a relevant and important value for it.
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), DL.getLine(), /* ShouldSkipZero */ false);
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"column"), DL.getColumn());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), DL.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"inlinedAt"), DL.getRawInlinedAt());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDISubrange">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1580,
 FQN="writeDISubrange", NM="_ZL15writeDISubrangeRN4llvm11raw_ostreamEPKNS_10DISubrangeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL15writeDISubrangeRN4llvm11raw_ostreamEPKNS_10DISubrangeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDISubrange(final raw_ostream /*&*/ Out, /*const*/ DISubrange /*P*/ N, 
               TypePrinting /*P*/ $Prm2, SlotTracker /*P*/ $Prm3, /*const*/ Module /*P*/ $Prm4) {
  Out.$out(/*KEEP_STR*/"!DISubrange(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out);
  Printer.printInt$LLong(new StringRef(/*KEEP_STR*/"count"), N.getCount(), /* ShouldSkipZero */ false);
  Printer.printInt$LLong(new StringRef(/*KEEP_STR*/"lowerBound"), N.getLowerBound());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIEnumerator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1589,
 FQN="writeDIEnumerator", NM="_ZL17writeDIEnumeratorRN4llvm11raw_ostreamEPKNS_12DIEnumeratorEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL17writeDIEnumeratorRN4llvm11raw_ostreamEPKNS_12DIEnumeratorEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIEnumerator(final raw_ostream /*&*/ Out, /*const*/ DIEnumerator /*P*/ N, 
                 TypePrinting /*P*/ $Prm2, SlotTracker /*P*/ $Prm3, /*const*/ Module /*P*/ $Prm4) {
  Out.$out(/*KEEP_STR*/"!DIEnumerator(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName(), /* ShouldSkipEmpty */ false);
  Printer.printInt$LLong(new StringRef(/*KEEP_STR*/"value"), N.getValue(), /* ShouldSkipZero */ false);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIBasicType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1598,
 FQN="writeDIBasicType", NM="_ZL16writeDIBasicTypeRN4llvm11raw_ostreamEPKNS_11DIBasicTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16writeDIBasicTypeRN4llvm11raw_ostreamEPKNS_11DIBasicTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIBasicType(final raw_ostream /*&*/ Out, /*const*/ DIBasicType /*P*/ N, 
                TypePrinting /*P*/ $Prm2, SlotTracker /*P*/ $Prm3, /*const*/ Module /*P*/ $Prm4) {
  Out.$out(/*KEEP_STR*/"!DIBasicType(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out);
  if (N.getTag() != $ushort2uint(Tag.DW_TAG_base_type)) {
    Printer.printTag(N);
  }
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printInt$LLong(new StringRef(/*KEEP_STR*/"size"), N.getSizeInBits());
  Printer.printInt$LLong(new StringRef(/*KEEP_STR*/"align"), N.getAlignInBits());
  Printer.printDwarfEnum$UInt(new StringRef(/*KEEP_STR*/"encoding"), N.getEncoding(), 
      /*FuncRef*/DwarfGlobals::AttributeEncodingString);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIDerivedType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1612,
 FQN="writeDIDerivedType", NM="_ZL18writeDIDerivedTypeRN4llvm11raw_ostreamEPKNS_13DIDerivedTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL18writeDIDerivedTypeRN4llvm11raw_ostreamEPKNS_13DIDerivedTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIDerivedType(final raw_ostream /*&*/ Out, /*const*/ DIDerivedType /*P*/ N, 
                  TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                  /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIDerivedType(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printTag(N);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"baseType"), N.getRawBaseType(), 
      /* ShouldSkipNull */ false);
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"size"), N.getSizeInBits());
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"align"), N.getAlignInBits());
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"offset"), N.getOffsetInBits());
  Printer.printDIFlags(new StringRef(/*KEEP_STR*/"flags"), N.getFlags());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"extraData"), N.getRawExtraData());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDICompositeType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1632,
 FQN="writeDICompositeType", NM="_ZL20writeDICompositeTypeRN4llvm11raw_ostreamEPKNS_15DICompositeTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL20writeDICompositeTypeRN4llvm11raw_ostreamEPKNS_15DICompositeTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDICompositeType(final raw_ostream /*&*/ Out, /*const*/ DICompositeType /*P*/ N, 
                    TypePrinting /*P*/ TypePrinter, 
                    SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DICompositeType(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printTag(N);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"baseType"), N.getRawBaseType());
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"size"), N.getSizeInBits());
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"align"), N.getAlignInBits());
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"offset"), N.getOffsetInBits());
  Printer.printDIFlags(new StringRef(/*KEEP_STR*/"flags"), N.getFlags());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"elements"), N.getRawElements());
  Printer.printDwarfEnum$UInt(new StringRef(/*KEEP_STR*/"runtimeLang"), N.getRuntimeLang(), 
      /*FuncRef*/DwarfGlobals::LanguageString);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"vtableHolder"), N.getRawVTableHolder());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"templateParams"), N.getRawTemplateParams());
  Printer.printString(new StringRef(/*KEEP_STR*/$identifier), N.getIdentifier());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDISubroutineType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1656,
 FQN="writeDISubroutineType", NM="_ZL21writeDISubroutineTypeRN4llvm11raw_ostreamEPKNS_16DISubroutineTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL21writeDISubroutineTypeRN4llvm11raw_ostreamEPKNS_16DISubroutineTypeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDISubroutineType(final raw_ostream /*&*/ Out, /*const*/ DISubroutineType /*P*/ N, 
                     TypePrinting /*P*/ TypePrinter, 
                     SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DISubroutineType(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printDIFlags(new StringRef(/*KEEP_STR*/"flags"), N.getFlags());
  Printer.printDwarfEnum$UChar(new StringRef(/*KEEP_STR*/"cc"), N.getCC(), /*FuncRef*/DwarfGlobals::ConventionString);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"types"), N.getRawTypeArray(), 
      /* ShouldSkipNull */ false);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1668,
 FQN="writeDIFile", NM="_ZL11writeDIFileRN4llvm11raw_ostreamEPKNS_6DIFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL11writeDIFileRN4llvm11raw_ostreamEPKNS_6DIFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIFile(final raw_ostream /*&*/ Out, /*const*/ DIFile /*P*/ N, TypePrinting /*P*/ $Prm2, 
           SlotTracker /*P*/ $Prm3, /*const*/ Module /*P*/ $Prm4) {
  Out.$out(/*KEEP_STR*/"!DIFile(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out);
  Printer.printString(new StringRef(/*KEEP_STR*/"filename"), N.getFilename(), 
      /* ShouldSkipEmpty */ false);
  Printer.printString(new StringRef(/*KEEP_STR*/"directory"), N.getDirectory(), 
      /* ShouldSkipEmpty */ false);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDICompileUnit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1679,
 FQN="writeDICompileUnit", NM="_ZL18writeDICompileUnitRN4llvm11raw_ostreamEPKNS_13DICompileUnitEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL18writeDICompileUnitRN4llvm11raw_ostreamEPKNS_13DICompileUnitEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDICompileUnit(final raw_ostream /*&*/ Out, /*const*/ DICompileUnit /*P*/ N, 
                  TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                  /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DICompileUnit(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printDwarfEnum$UInt(new StringRef(/*KEEP_STR*/"language"), N.getSourceLanguage(), 
      /*FuncRef*/DwarfGlobals::LanguageString, /* ShouldSkipZero */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile(), /* ShouldSkipNull */ false);
  Printer.printString(new StringRef(/*KEEP_STR*/"producer"), N.getProducer());
  Printer.printBool(new StringRef(/*KEEP_STR*/"isOptimized"), N.isOptimized());
  Printer.printString(new StringRef(/*KEEP_STR*/"flags"), N.getFlags());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"runtimeVersion"), N.getRuntimeVersion(), 
      /* ShouldSkipZero */ false);
  Printer.printString(new StringRef(/*KEEP_STR*/"splitDebugFilename"), N.getSplitDebugFilename());
  Printer.printEmissionKind(new StringRef(/*KEEP_STR*/"emissionKind"), N.getEmissionKind());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"enums"), N.getRawEnumTypes());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"retainedTypes"), N.getRawRetainedTypes());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"globals"), N.getRawGlobalVariables());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"imports"), N.getRawImportedEntities());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"macros"), N.getRawMacros());
  Printer.printInt$ULLong(new StringRef(/*KEEP_STR*/"dwoId"), N.getDWOId());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDISubprogram">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1703,
 FQN="writeDISubprogram", NM="_ZL17writeDISubprogramRN4llvm11raw_ostreamEPKNS_12DISubprogramEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL17writeDISubprogramRN4llvm11raw_ostreamEPKNS_12DISubprogramEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDISubprogram(final raw_ostream /*&*/ Out, /*const*/ DISubprogram /*P*/ N, 
                 TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                 /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DISubprogram(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printString(new StringRef(/*KEEP_STR*/"linkageName"), N.getLinkageName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"type"), N.getRawType());
  Printer.printBool(new StringRef(/*KEEP_STR*/"isLocal"), N.isLocalToUnit());
  Printer.printBool(new StringRef(/*KEEP_STR*/"isDefinition"), N.isDefinition());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"scopeLine"), N.getScopeLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"containingType"), N.getRawContainingType());
  Printer.printDwarfEnum$UInt(new StringRef(/*KEEP_STR*/"virtuality"), N.getVirtuality(), 
      /*FuncRef*/DwarfGlobals::VirtualityString);
  if (N.getVirtuality() != VirtualityAttribute.DW_VIRTUALITY_none
     || N.getVirtualIndex() != 0) {
    Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"virtualIndex"), N.getVirtualIndex(), false);
  }
  Printer.printInt$Int(new StringRef(/*KEEP_STR*/"thisAdjustment"), N.getThisAdjustment());
  Printer.printDIFlags(new StringRef(/*KEEP_STR*/"flags"), N.getFlags());
  Printer.printBool(new StringRef(/*KEEP_STR*/"isOptimized"), N.isOptimized());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"unit"), N.getRawUnit());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"templateParams"), N.getRawTemplateParams());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"declaration"), N.getRawDeclaration());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"variables"), N.getRawVariables());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDILexicalBlock">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1733,
 FQN="writeDILexicalBlock", NM="_ZL19writeDILexicalBlockRN4llvm11raw_ostreamEPKNS_14DILexicalBlockEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL19writeDILexicalBlockRN4llvm11raw_ostreamEPKNS_14DILexicalBlockEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDILexicalBlock(final raw_ostream /*&*/ Out, /*const*/ DILexicalBlock /*P*/ N, 
                   TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                   /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DILexicalBlock(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"column"), N.getColumn());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDILexicalBlockFile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1745,
 FQN="writeDILexicalBlockFile", NM="_ZL23writeDILexicalBlockFileRN4llvm11raw_ostreamEPKNS_18DILexicalBlockFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL23writeDILexicalBlockFileRN4llvm11raw_ostreamEPKNS_18DILexicalBlockFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDILexicalBlockFile(final raw_ostream /*&*/ Out, 
                       /*const*/ DILexicalBlockFile /*P*/ N, 
                       TypePrinting /*P*/ TypePrinter, 
                       SlotTracker /*P*/ Machine, 
                       /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DILexicalBlockFile(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"discriminator"), N.getDiscriminator(), 
      /* ShouldSkipZero */ false);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDINamespace">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1759,
 FQN="writeDINamespace", NM="_ZL16writeDINamespaceRN4llvm11raw_ostreamEPKNS_11DINamespaceEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16writeDINamespaceRN4llvm11raw_ostreamEPKNS_11DINamespaceEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDINamespace(final raw_ostream /*&*/ Out, /*const*/ DINamespace /*P*/ N, 
                TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DINamespace(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIMacro">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1771,
 FQN="writeDIMacro", NM="_ZL12writeDIMacroRN4llvm11raw_ostreamEPKNS_7DIMacroEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL12writeDIMacroRN4llvm11raw_ostreamEPKNS_7DIMacroEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIMacro(final raw_ostream /*&*/ Out, /*const*/ DIMacro /*P*/ N, 
            TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
            /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIMacro(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printMacinfoType(N);
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printString(new StringRef(/*KEEP_STR*/"value"), N.getValue());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIMacroFile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1783,
 FQN="writeDIMacroFile", NM="_ZL16writeDIMacroFileRN4llvm11raw_ostreamEPKNS_11DIMacroFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16writeDIMacroFileRN4llvm11raw_ostreamEPKNS_11DIMacroFileEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIMacroFile(final raw_ostream /*&*/ Out, /*const*/ DIMacroFile /*P*/ N, 
                TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIMacroFile(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"nodes"), N.getRawElements());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1794,
 FQN="writeDIModule", NM="_ZL13writeDIModuleRN4llvm11raw_ostreamEPKNS_8DIModuleEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL13writeDIModuleRN4llvm11raw_ostreamEPKNS_8DIModuleEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIModule(final raw_ostream /*&*/ Out, /*const*/ DIModule /*P*/ N, 
             TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
             /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIModule(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printString(new StringRef(/*KEEP_STR*/"configMacros"), N.getConfigurationMacros());
  Printer.printString(new StringRef(/*KEEP_STR*/"includePath"), N.getIncludePath());
  Printer.printString(new StringRef(/*KEEP_STR*/"isysroot"), N.getISysRoot());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDITemplateTypeParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1808,
 FQN="writeDITemplateTypeParameter", NM="_ZL28writeDITemplateTypeParameterRN4llvm11raw_ostreamEPKNS_23DITemplateTypeParameterEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL28writeDITemplateTypeParameterRN4llvm11raw_ostreamEPKNS_23DITemplateTypeParameterEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDITemplateTypeParameter(final raw_ostream /*&*/ Out, 
                            /*const*/ DITemplateTypeParameter /*P*/ N, 
                            TypePrinting /*P*/ TypePrinter, 
                            SlotTracker /*P*/ Machine, 
                            /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DITemplateTypeParameter(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"type"), N.getRawType(), /* ShouldSkipNull */ false);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDITemplateValueParameter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1820,
 FQN="writeDITemplateValueParameter", NM="_ZL29writeDITemplateValueParameterRN4llvm11raw_ostreamEPKNS_24DITemplateValueParameterEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL29writeDITemplateValueParameterRN4llvm11raw_ostreamEPKNS_24DITemplateValueParameterEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDITemplateValueParameter(final raw_ostream /*&*/ Out, 
                             /*const*/ DITemplateValueParameter /*P*/ N, 
                             TypePrinting /*P*/ TypePrinter, 
                             SlotTracker /*P*/ Machine, 
                             /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DITemplateValueParameter(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  if (N.getTag() != $ushort2uint(Tag.DW_TAG_template_value_parameter)) {
    Printer.printTag(N);
  }
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"type"), N.getRawType());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"value"), N.getValue(), /* ShouldSkipNull */ false);
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIGlobalVariable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1835,
 FQN="writeDIGlobalVariable", NM="_ZL21writeDIGlobalVariableRN4llvm11raw_ostreamEPKNS_16DIGlobalVariableEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL21writeDIGlobalVariableRN4llvm11raw_ostreamEPKNS_16DIGlobalVariableEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIGlobalVariable(final raw_ostream /*&*/ Out, /*const*/ DIGlobalVariable /*P*/ N, 
                     TypePrinting /*P*/ TypePrinter, 
                     SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIGlobalVariable(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printString(new StringRef(/*KEEP_STR*/"linkageName"), N.getLinkageName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"type"), N.getRawType());
  Printer.printBool(new StringRef(/*KEEP_STR*/"isLocal"), N.isLocalToUnit());
  Printer.printBool(new StringRef(/*KEEP_STR*/"isDefinition"), N.isDefinition());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"variable"), N.getRawVariable());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"declaration"), N.getRawStaticDataMemberDeclaration());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDILocalVariable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1853,
 FQN="writeDILocalVariable", NM="_ZL20writeDILocalVariableRN4llvm11raw_ostreamEPKNS_15DILocalVariableEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL20writeDILocalVariableRN4llvm11raw_ostreamEPKNS_15DILocalVariableEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDILocalVariable(final raw_ostream /*&*/ Out, /*const*/ DILocalVariable /*P*/ N, 
                    TypePrinting /*P*/ TypePrinter, 
                    SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DILocalVariable(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"arg"), N.getArg());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"type"), N.getRawType());
  Printer.printDIFlags(new StringRef(/*KEEP_STR*/"flags"), N.getFlags());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIExpression">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1868,
 FQN="writeDIExpression", NM="_ZL17writeDIExpressionRN4llvm11raw_ostreamEPKNS_12DIExpressionEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL17writeDIExpressionRN4llvm11raw_ostreamEPKNS_12DIExpressionEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIExpression(final raw_ostream /*&*/ Out, /*const*/ DIExpression /*P*/ N, 
                 TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                 /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIExpression(");
  FieldSeparator FS/*J*/= new FieldSeparator();
  if (N.isValid()) {
    for (DIExpression.expr_op_iterator I = N.expr_op_begin(), E = N.expr_op_end(); I.$noteq(E); I.$preInc()) {
      /*const*/char$ptr/*char P*/ OpStr = $tryClone(DwarfGlobals.OperationEncodingString($ulong2uint(I.$arrow().getOp())));
      assert (Native.$bool(OpStr)) : "Expected valid opcode";
      
      $out_raw_ostream_FieldSeparator(Out, FS).$out(OpStr);
      for (/*uint*/int A = 0, AE = I.$arrow().getNumArgs(); A != AE; ++A)  {
        $out_raw_ostream_FieldSeparator(Out, FS).$out_ullong(I.$arrow().getArg(A));
      }
    }
  } else {
    for (final /*const*/long/*ullong &*/ I : N.getElements())  {
      $out_raw_ostream_FieldSeparator(Out, FS).$out_ullong(I);
    }
  }
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIObjCProperty">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1889,
 FQN="writeDIObjCProperty", NM="_ZL19writeDIObjCPropertyRN4llvm11raw_ostreamEPKNS_14DIObjCPropertyEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL19writeDIObjCPropertyRN4llvm11raw_ostreamEPKNS_14DIObjCPropertyEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIObjCProperty(final raw_ostream /*&*/ Out, /*const*/ DIObjCProperty /*P*/ N, 
                   TypePrinting /*P*/ TypePrinter, SlotTracker /*P*/ Machine, 
                   /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIObjCProperty(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"file"), N.getRawFile());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Printer.printString(new StringRef(/*KEEP_STR*/"setter"), N.getSetterName());
  Printer.printString(new StringRef(/*KEEP_STR*/"getter"), N.getGetterName());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/"attributes"), N.getAttributes());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"type"), N.getRawType());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="writeDIImportedEntity">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1904,
 FQN="writeDIImportedEntity", NM="_ZL21writeDIImportedEntityRN4llvm11raw_ostreamEPKNS_16DIImportedEntityEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL21writeDIImportedEntityRN4llvm11raw_ostreamEPKNS_16DIImportedEntityEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void writeDIImportedEntity(final raw_ostream /*&*/ Out, /*const*/ DIImportedEntity /*P*/ N, 
                     TypePrinting /*P*/ TypePrinter, 
                     SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
  Out.$out(/*KEEP_STR*/"!DIImportedEntity(");
  MDFieldPrinter Printer/*J*/= new MDFieldPrinter(Out, TypePrinter, Machine, Context);
  Printer.printTag(N);
  Printer.printString(new StringRef(/*KEEP_STR*/"name"), N.getName());
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"scope"), N.getRawScope(), /* ShouldSkipNull */ false);
  Printer.printMetadata(new StringRef(/*KEEP_STR*/"entity"), N.getRawEntity());
  Printer.printInt$UInt(new StringRef(/*KEEP_STR*/$line), N.getLine());
  Out.$out(/*KEEP_STR*/$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="WriteMDNodeBodyInternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1918,
 FQN="WriteMDNodeBodyInternal", NM="_ZL23WriteMDNodeBodyInternalRN4llvm11raw_ostreamEPKNS_6MDNodeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL23WriteMDNodeBodyInternalRN4llvm11raw_ostreamEPKNS_6MDNodeEPN12_GLOBAL__N_112TypePrintingEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static void WriteMDNodeBodyInternal(final raw_ostream /*&*/ Out, /*const*/ MDNode /*P*/ Node, 
                       TypePrinting /*P*/ TypePrinter, 
                       SlotTracker /*P*/ Machine, 
                       /*const*/ Module /*P*/ Context) {
  if (Node.isDistinct()) {
    Out.$out(/*KEEP_STR*/"distinct ");
  } else if (Node.isTemporary()) {
    Out.$out(/*KEEP_STR*/"<temporary!> "); // Handle broken code.
  }
  switch (Metadata.MetadataKind.valueOf(Node.getMetadataID())) {
   default:
    throw new llvm_unreachable("Expected uniquable MDNode");
   case MDTupleKind:
    writeMDTuple(Out, cast_MDTuple(Node), TypePrinter, Machine, Context);
    break;
   case DILocationKind:
    writeDILocation(Out, cast_DILocation(Node), TypePrinter, Machine, Context);
    break;
   case DIExpressionKind:
    writeDIExpression(Out, cast_DIExpression(Node), TypePrinter, Machine, Context);
    break;
   case GenericDINodeKind:
    writeGenericDINode(Out, cast_GenericDINode(Node), TypePrinter, Machine, Context);
    break;
   case DISubrangeKind:
    writeDISubrange(Out, cast_DISubrange(Node), TypePrinter, Machine, Context);
    break;
   case DIEnumeratorKind:
    writeDIEnumerator(Out, cast_DIEnumerator(Node), TypePrinter, Machine, Context);
    break;
   case DIBasicTypeKind:
    writeDIBasicType(Out, cast_DIBasicType(Node), TypePrinter, Machine, Context);
    break;
   case DIDerivedTypeKind:
    writeDIDerivedType(Out, cast_DIDerivedType(Node), TypePrinter, Machine, Context);
    break;
   case DICompositeTypeKind:
    writeDICompositeType(Out, cast_DICompositeType(Node), TypePrinter, Machine, Context);
    break;
   case DISubroutineTypeKind:
    writeDISubroutineType(Out, cast_DISubroutineType(Node), TypePrinter, Machine, Context);
    break;
   case DIFileKind:
    writeDIFile(Out, cast_DIFile(Node), TypePrinter, Machine, Context);
    break;
   case DICompileUnitKind:
    writeDICompileUnit(Out, cast_DICompileUnit(Node), TypePrinter, Machine, Context);
    break;
   case DISubprogramKind:
    writeDISubprogram(Out, cast_DISubprogram(Node), TypePrinter, Machine, Context);
    break;
   case DILexicalBlockKind:
    writeDILexicalBlock(Out, cast_DILexicalBlock(Node), TypePrinter, Machine, Context);
    break;
   case DILexicalBlockFileKind:
    writeDILexicalBlockFile(Out, cast_DILexicalBlockFile(Node), TypePrinter, Machine, Context);
    break;
   case DINamespaceKind:
    writeDINamespace(Out, cast_DINamespace(Node), TypePrinter, Machine, Context);
    break;
   case DIModuleKind:
    writeDIModule(Out, cast_DIModule(Node), TypePrinter, Machine, Context);
    break;
   case DITemplateTypeParameterKind:
    writeDITemplateTypeParameter(Out, cast_DITemplateTypeParameter(Node), TypePrinter, Machine, Context);
    break;
   case DITemplateValueParameterKind:
    writeDITemplateValueParameter(Out, cast_DITemplateValueParameter(Node), TypePrinter, Machine, Context);
    break;
   case DIGlobalVariableKind:
    writeDIGlobalVariable(Out, cast_DIGlobalVariable(Node), TypePrinter, Machine, Context);
    break;
   case DILocalVariableKind:
    writeDILocalVariable(Out, cast_DILocalVariable(Node), TypePrinter, Machine, Context);
    break;
   case DIObjCPropertyKind:
    writeDIObjCProperty(Out, cast_DIObjCProperty(Node), TypePrinter, Machine, Context);
    break;
   case DIImportedEntityKind:
    writeDIImportedEntity(Out, cast_DIImportedEntity(Node), TypePrinter, Machine, Context);
    break;
   case DIMacroKind:
    writeDIMacro(Out, cast_DIMacro(Node), TypePrinter, Machine, Context);
    break;
   case DIMacroFileKind:
    writeDIMacroFile(Out, cast_DIMacroFile(Node), TypePrinter, Machine, Context);
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="printMetadataIdentifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2324,
 FQN="printMetadataIdentifier", NM="_ZL23printMetadataIdentifierN4llvm9StringRefERNS_21formatted_raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL23printMetadataIdentifierN4llvm9StringRefERNS_21formatted_raw_ostreamE")
//</editor-fold>
public static void printMetadataIdentifier(StringRef Name, 
                       final formatted_raw_ostream /*&*/ Out) {
  if (Name.empty()) {
    Out.$out(/*KEEP_STR*/"<empty name> ");
  } else {
    if ((isalpha($uchar2int(((/*static_cast*//*uchar*/byte)(Name.$at(0))))) != 0) || Name.$at(0) == $$MINUS
       || Name.$at(0) == $$DOLLAR || Name.$at(0) == $$DOT || Name.$at(0) == $$UNDERSCORE) {
      Out.$out_char(Name.$at(0));
    } else {
      Out.$out_char($$BACK_SLASH).$out_char(llvm.hexdigit(Name.$at(0) >> 4)).$out_char(llvm.hexdigit(Name.$at(0) & 0x0F));
    }
    for (/*uint*/int i = 1, e = Name.size(); i != e; ++i) {
      /*uchar*/byte C = Name.$at(i);
      if ((isalnum($uchar2int(((/*static_cast*//*uchar*/byte)(C)))) != 0) || $uchar2int(C) == $$MINUS || $uchar2int(C) == $$DOLLAR
         || $uchar2int(C) == $$DOT || $uchar2int(C) == $$UNDERSCORE) {
        Out.$out_uchar(C);
      } else {
        Out.$out_char($$BACK_SLASH).$out_char(llvm.hexdigit($uchar2int(C) >> 4)).$out_char(llvm.hexdigit($uchar2int(C) & 0x0F));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getLinkagePrintName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2361,
 FQN="getLinkagePrintName", NM="_ZL19getLinkagePrintNameN4llvm11GlobalValue12LinkageTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL19getLinkagePrintNameN4llvm11GlobalValue12LinkageTypesE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getLinkagePrintName(GlobalValue.LinkageTypes LT) {
  switch (LT) {
   case ExternalLinkage:
    return $EMPTY;
   case PrivateLinkage:
    return $("private ");
   case InternalLinkage:
    return $("internal ");
   case LinkOnceAnyLinkage:
    return $("linkonce ");
   case LinkOnceODRLinkage:
    return $("linkonce_odr ");
   case WeakAnyLinkage:
    return $("weak ");
   case WeakODRLinkage:
    return $("weak_odr ");
   case CommonLinkage:
    return $("common ");
   case AppendingLinkage:
    return $("appending ");
   case ExternalWeakLinkage:
    return $("extern_weak ");
   case AvailableExternallyLinkage:
    return $("available_externally ");
  }
  throw new llvm_unreachable("invalid linkage");
}

//<editor-fold defaultstate="collapsed" desc="PrintVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2389,
 FQN="PrintVisibility", NM="_ZL15PrintVisibilityN4llvm11GlobalValue15VisibilityTypesERNS_21formatted_raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL15PrintVisibilityN4llvm11GlobalValue15VisibilityTypesERNS_21formatted_raw_ostreamE")
//</editor-fold>
public static void PrintVisibility(GlobalValue.VisibilityTypes Vis, 
               final formatted_raw_ostream /*&*/ Out) {
  switch (Vis) {
   case DefaultVisibility:
    break;
   case HiddenVisibility:
    Out.$out(/*KEEP_STR*/"hidden ");
    break;
   case ProtectedVisibility:
    Out.$out(/*KEEP_STR*/"protected ");
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="PrintDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2398,
 FQN="PrintDLLStorageClass", NM="_ZL20PrintDLLStorageClassN4llvm11GlobalValue20DLLStorageClassTypesERNS_21formatted_raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL20PrintDLLStorageClassN4llvm11GlobalValue20DLLStorageClassTypesERNS_21formatted_raw_ostreamE")
//</editor-fold>
public static void PrintDLLStorageClass(GlobalValue.DLLStorageClassTypes SCT, 
                    final formatted_raw_ostream /*&*/ Out) {
  switch (SCT) {
   case DefaultStorageClass:
    break;
   case DLLImportStorageClass:
    Out.$out(/*KEEP_STR*/"dllimport ");
    break;
   case DLLExportStorageClass:
    Out.$out(/*KEEP_STR*/"dllexport ");
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="PrintThreadLocalModel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2407,
 FQN="PrintThreadLocalModel", NM="_ZL21PrintThreadLocalModelN4llvm11GlobalValue15ThreadLocalModeERNS_21formatted_raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL21PrintThreadLocalModelN4llvm11GlobalValue15ThreadLocalModeERNS_21formatted_raw_ostreamE")
//</editor-fold>
public static void PrintThreadLocalModel(GlobalVariable.ThreadLocalMode TLM, 
                     final formatted_raw_ostream /*&*/ Out) {
  switch (TLM) {
   case NotThreadLocal:
    break;
   case GeneralDynamicTLSModel:
    Out.$out(/*KEEP_STR*/"thread_local ");
    break;
   case LocalDynamicTLSModel:
    Out.$out(/*KEEP_STR*/"thread_local(localdynamic) ");
    break;
   case InitialExecTLSModel:
    Out.$out(/*KEEP_STR*/"thread_local(initialexec) ");
    break;
   case LocalExecTLSModel:
    Out.$out(/*KEEP_STR*/"thread_local(localexec) ");
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="getUnnamedAddrEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2427,
 FQN="getUnnamedAddrEncoding", NM="_ZL22getUnnamedAddrEncodingN4llvm11GlobalValue11UnnamedAddrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL22getUnnamedAddrEncodingN4llvm11GlobalValue11UnnamedAddrE")
//</editor-fold>
public static StringRef getUnnamedAddrEncoding(GlobalVariable.UnnamedAddr UA) {
  switch (UA) {
   case None:
    return new StringRef(/*KEEP_STR*/$EMPTY);
   case Local:
    return new StringRef(/*KEEP_STR*/"local_unnamed_addr");
   case Global:
    return new StringRef(/*KEEP_STR*/"unnamed_addr");
  }
  throw new llvm_unreachable("Unknown UnnamedAddr");
}

//<editor-fold defaultstate="collapsed" desc="maybePrintComdat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2439,
 FQN="maybePrintComdat", NM="_ZL16maybePrintComdatRN4llvm21formatted_raw_ostreamERKNS_12GlobalObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16maybePrintComdatRN4llvm21formatted_raw_ostreamERKNS_12GlobalObjectE")
//</editor-fold>
public static void maybePrintComdat(final formatted_raw_ostream /*&*/ Out, 
                final /*const*/ GlobalObject /*&*/ GO) {
  /*const*/ Comdat /*P*/ C = GO.getComdat$Const();
  if (!(C != null)) {
    return;
  }
  if (isa_GlobalVariable(GO)) {
    Out.$out_char($$COMMA);
  }
  Out.$out(/*KEEP_STR*/" comdat");
  if ($eq_StringRef(GO.getName(), C.getName())) {
    return;
  }
  
  Out.$out_char($$LPAREN);
  PrintLLVMName(Out, C.getName(), PrefixType.ComdatPrefix);
  Out.$out_char($$RPAREN);
}

//<editor-fold defaultstate="collapsed" desc="isReferencingMDNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3378,
 FQN="isReferencingMDNode", NM="_ZL19isReferencingMDNodeRKN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL19isReferencingMDNodeRKN4llvm11InstructionE")
//</editor-fold>
public static boolean isReferencingMDNode(final /*const*/ Instruction /*&*/ I) {
  {
    /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst($AddrOf(I));
    if ((CI != null)) {
      {
        Function /*P*/ F = CI.getCalledFunction();
        if ((F != null)) {
          if (F.isIntrinsic()) {
            for (final /*const*/ Use /*&*/ Op : I.operands$Const())  {
              {
                MetadataAsValue /*P*/ V = dyn_cast_or_null_MetadataAsValue(Op);
                if ((V != null)) {
                  if (isa_MDNode(V.getMetadata())) {
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  return false;
}


/// Print without a type, skipping the TypePrinting object.
///
/// \return \c true iff printing was successful.
//<editor-fold defaultstate="collapsed" desc="printWithoutType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3444,
 FQN="printWithoutType", NM="_ZL16printWithoutTypeRKN4llvm5ValueERNS_11raw_ostreamEPNS_11SlotTrackerEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL16printWithoutTypeRKN4llvm5ValueERNS_11raw_ostreamEPNS_11SlotTrackerEPKNS_6ModuleE")
//</editor-fold>
public static boolean printWithoutType(final /*const*/ Value /*&*/ V, final raw_ostream /*&*/ O, 
                SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ M) {
  if (V.hasName() || isa_GlobalValue(V)
     || (!isa_Constant(V) && !isa_MetadataAsValue(V))) {
    WriteAsOperandInternal(O, $AddrOf(V), (TypePrinting /*P*/ )null, Machine, M);
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="printAsOperandImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3454,
 FQN="printAsOperandImpl", NM="_ZL18printAsOperandImplRKN4llvm5ValueERNS_11raw_ostreamEbRNS_17ModuleSlotTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL18printAsOperandImplRKN4llvm5ValueERNS_11raw_ostreamEbRNS_17ModuleSlotTrackerE")
//</editor-fold>
public static void printAsOperandImpl(final /*const*/ Value /*&*/ V, final raw_ostream /*&*/ O, boolean PrintType, 
                  final ModuleSlotTracker /*&*/ MST) {
  TypePrinting TypePrinter = null;
  try {
    TypePrinter/*J*/= new TypePrinting();
    {
      /*const*/ Module /*P*/ M = MST.getModule();
      if ((M != null)) {
        TypePrinter.incorporateTypes($Deref(M));
      }
    }
    if (PrintType) {
      TypePrinter.print(V.getType(), O);
      O.$out_char($$SPACE);
    }
    
    WriteAsOperandInternal(O, $AddrOf(V), $AddrOf(TypePrinter), MST.getMachine(), 
        MST.getModule());
  } finally {
    if (TypePrinter != null) { TypePrinter.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="printMetadataImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3492,
 FQN="printMetadataImpl", NM="_ZL17printMetadataImplRN4llvm11raw_ostreamERKNS_8MetadataERNS_17ModuleSlotTrackerEPKNS_6ModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZL17printMetadataImplRN4llvm11raw_ostreamERKNS_8MetadataERNS_17ModuleSlotTrackerEPKNS_6ModuleEb")
//</editor-fold>
public static void printMetadataImpl(final raw_ostream /*&*/ ROS, final /*const*/ Metadata /*&*/ MD, 
                 final ModuleSlotTracker /*&*/ MST, /*const*/ Module /*P*/ M, 
                 boolean OnlyAsOperand) {
  formatted_raw_ostream OS = null;
  TypePrinting TypePrinter = null;
  try {
    OS/*J*/= new formatted_raw_ostream(ROS);
    
    TypePrinter/*J*/= new TypePrinting();
    if ((M != null)) {
      TypePrinter.incorporateTypes($Deref(M));
    }
    
    WriteAsOperandInternal(OS, $AddrOf(MD), $AddrOf(TypePrinter), MST.getMachine(), M, 
        /* FromValue */ true);
    
    /*const*/ MDNode /*P*/ N = dyn_cast_MDNode($AddrOf(MD));
    if (OnlyAsOperand || !(N != null)) {
      return;
    }
    
    OS.$out(/*KEEP_STR*/" = ");
    WriteMDNodeBodyInternal(OS, N, $AddrOf(TypePrinter), MST.getMachine(), M);
  } finally {
    if (TypePrinter != null) { TypePrinter.$destroy(); }
    if (OS != null) { OS.$destroy(); }
  }
}

} // END OF class AsmWriterStatics
