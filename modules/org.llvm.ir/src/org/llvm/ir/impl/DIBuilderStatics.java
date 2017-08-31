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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type DIBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.DIBuilderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=Tpl__ZL13getSubprogrambDpOT_;_ZL12withDebugLocPN4llvm11InstructionEPKNS_10DILocationE;_ZL17getConstantOrNullPN4llvm8ConstantE;_ZL19createLocalVariableRN4llvm11LLVMContextERNS_8DenseMapIPNS_6MDNodeENS_11SmallVectorINS_18TypedTrackingMDRefIS3_EELj1EEENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S8_EEEEPNS_7DIScopeENS_9StringRefEjPNS_6DIFileEjPNS_6DITypeEbj;_ZL19createTypeWithFlagsRN4llvm11LLVMContextEPNS_6DITypeEj;_ZL20createImportedModuleRN4llvm11LLVMContextENS_5dwarf3TagEPNS_7DIScopeEPNS_8MetadataEjNS_9StringRefERNS_15SmallVectorImplINS_18TypedTrackingMDRefINS_6MDNodeEEEEE;_ZL22getNonCompileUnitScopePN4llvm7DIScopeE;_ZL24checkGlobalVariableScopePN4llvm7DIScopeE;_ZL24getDbgIntrinsicValueImplRN4llvm11LLVMContextEPNS_5ValueE;_ZL34createTemplateValueParameterHelperRN4llvm11LLVMContextEjPNS_7DIScopeENS_9StringRefEPNS_6DITypeEPNS_8MetadataE; -static-type=DIBuilderStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class DIBuilderStatics {


/// If N is compile unit return NULL otherwise return N.
//<editor-fold defaultstate="collapsed" desc="getNonCompileUnitScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 105,
 FQN="getNonCompileUnitScope", NM="_ZL22getNonCompileUnitScopePN4llvm7DIScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL22getNonCompileUnitScopePN4llvm7DIScopeE")
//</editor-fold>
public static DIScope /*P*/ getNonCompileUnitScope(DIScope /*P*/ N) {
  if (!(N != null) || isa_DICompileUnit(N)) {
    return null;
  }
  return cast_DIScope(N);
}

//<editor-fold defaultstate="collapsed" desc="createImportedModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 135,
 FQN="createImportedModule", NM="_ZL20createImportedModuleRN4llvm11LLVMContextENS_5dwarf3TagEPNS_7DIScopeEPNS_8MetadataEjNS_9StringRefERNS_15SmallVectorImplINS_18TypedTrackingMDRefINS_6MDNodeEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL20createImportedModuleRN4llvm11LLVMContextENS_5dwarf3TagEPNS_7DIScopeEPNS_8MetadataEjNS_9StringRefERNS_15SmallVectorImplINS_18TypedTrackingMDRefINS_6MDNodeEEEEE")
//</editor-fold>
public static DIImportedEntity /*P*/ createImportedModule(final LLVMContext /*&*/ C, /*Tag*//*uint16_t*/char Tag, DIScope /*P*/ Context, 
                    Metadata /*P*/ NS, /*uint*/int Line, StringRef Name, 
                    final SmallVectorImpl<TypedTrackingMDRef<MDNode> > /*&*/ AllImportedModules) {
  /*uint*/int EntitiesCount = C.pImpl.DIImportedEntitys.size();
  DIImportedEntity /*P*/ M = DIImportedEntity.get(C, $ushort2uint(Tag), Context, new TypedDINodeRef<DINode>(DINode.class, NS), Line, new StringRef(Name));
  if ($less_uint(EntitiesCount, C.pImpl.DIImportedEntitys.size())) {
    // A new Imported Entity was just added to the context.
    // Add it to the Imported Modules list.
    AllImportedModules.emplace_back(new TypedTrackingMDRef<MDNode>(M));
  }
  return M;
}

//<editor-fold defaultstate="collapsed" desc="getConstantOrNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 271,
 FQN="getConstantOrNull", NM="_ZL17getConstantOrNullPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL17getConstantOrNullPN4llvm8ConstantE")
//</editor-fold>
public static ConstantAsMetadata /*P*/ getConstantOrNull(Constant /*P*/ C) {
  if ((C != null)) {
    return ConstantAsMetadata.get(C);
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="createTemplateValueParameterHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 327,
 FQN="createTemplateValueParameterHelper", NM="_ZL34createTemplateValueParameterHelperRN4llvm11LLVMContextEjPNS_7DIScopeENS_9StringRefEPNS_6DITypeEPNS_8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL34createTemplateValueParameterHelperRN4llvm11LLVMContextEjPNS_7DIScopeENS_9StringRefEPNS_6DITypeEPNS_8MetadataE")
//</editor-fold>
public static DITemplateValueParameter /*P*/ createTemplateValueParameterHelper(final LLVMContext /*&*/ VMContext, /*uint*/int Tag, 
                                  DIScope /*P*/ Context, StringRef Name, DIType /*P*/ Ty, 
                                  Metadata /*P*/ MD) {
  assert ((!(Context != null) || isa_DICompileUnit(Context))) : "Expected compile unit";
  return DITemplateValueParameter.get(VMContext, Tag, new StringRef(Name), new TypedDINodeRef<DIType>(DIType.class, Ty), MD);
}

//<editor-fold defaultstate="collapsed" desc="createTypeWithFlags">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 447,
 FQN="createTypeWithFlags", NM="_ZL19createTypeWithFlagsRN4llvm11LLVMContextEPNS_6DITypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL19createTypeWithFlagsRN4llvm11LLVMContextEPNS_6DITypeEj")
//</editor-fold>
public static DIType /*P*/ createTypeWithFlags(final LLVMContext /*&*/ Context, DIType /*P*/ Ty, 
                   /*uint*/int FlagsToSet) {
  std_ptr.unique_ptr_with_deleter<DIType> NewTy = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    NewTy = (std_ptr.unique_ptr_with_deleter<DIType>)Ty.clone();
    NewTy.$arrow().setFlags(NewTy.$arrow().getFlags() | FlagsToSet);
    return $c$.clean(MDNode.replaceWithUniqued$BaseOfMDNode($c$.track(new std.unique_ptr_with_deleter<DIType /*, TempMDNodeDeleter*/>(JD$Move.INSTANCE, std.move(NewTy)))));
  } finally {
    if (NewTy != null) { NewTy.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="checkGlobalVariableScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 527,
 FQN="checkGlobalVariableScope", NM="_ZL24checkGlobalVariableScopePN4llvm7DIScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL24checkGlobalVariableScopePN4llvm7DIScopeE")
//</editor-fold>
public static void checkGlobalVariableScope(DIScope /*P*/ Context) {
  {
    DICompositeType /*P*/ CT = dyn_cast_or_null_DICompositeType(getNonCompileUnitScope(Context));
    if ((CT != null)) {
      assert (CT.getIdentifier().empty()) : "Context of a global variable should not be a type with identifier";
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="createLocalVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 563,
 FQN="createLocalVariable", NM="_ZL19createLocalVariableRN4llvm11LLVMContextERNS_8DenseMapIPNS_6MDNodeENS_11SmallVectorINS_18TypedTrackingMDRefIS3_EELj1EEENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S8_EEEEPNS_7DIScopeENS_9StringRefEjPNS_6DIFileEjPNS_6DITypeEbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL19createLocalVariableRN4llvm11LLVMContextERNS_8DenseMapIPNS_6MDNodeENS_11SmallVectorINS_18TypedTrackingMDRefIS3_EELj1EEENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S8_EEEEPNS_7DIScopeENS_9StringRefEjPNS_6DIFileEjPNS_6DITypeEbj")
//</editor-fold>
public static DILocalVariable /*P*/ createLocalVariable(final LLVMContext /*&*/ VMContext, 
                   final DenseMap<MDNode /*P*/ , SmallVector<TypedTrackingMDRef<MDNode>>> /*&*/ PreservedVariables, 
                   DIScope /*P*/ Scope, StringRef Name, /*uint*/int ArgNo, DIFile /*P*/ File, 
                   /*uint*/int LineNo, DIType /*P*/ Ty, boolean AlwaysPreserve, /*uint*/int Flags) {
  // FIXME: Why getNonCompileUnitScope()?
  // FIXME: Why is "!Context" okay here?
  // FIXME: Why doesn't this check for a subprogram or lexical block (AFAICT
  // the only valid scopes)?
  DIScope /*P*/ Context = getNonCompileUnitScope(Scope);
  
  DILocalVariable /*P*/ Node = DILocalVariable.get(VMContext, cast_or_null_DILocalScope(Context), new StringRef(Name), 
      File, LineNo, new TypedDINodeRef<DIType>(DIType.class, Ty), ArgNo, Flags);
  if (AlwaysPreserve) {
    // The optimizer may remove local variables. If there is an interest
    // to preserve variable info in such situation then stash it in a
    // named mdnode.
    DISubprogram /*P*/ Fn = IrLlvmGlobals.getDISubprogram(Scope);
    assert ((Fn != null)) : "Missing subprogram for local variable";
    PreservedVariables.$at_T1$RR(Fn).emplace_back(new TypedTrackingMDRef<MDNode>(Node));
  }
  return Node;
}

//template <class ... Ts = <LLVMContext &, DIScope *, StringRef &, StringRef &, DIFile *&, unsigned int &, DISubroutineType *&, bool &, bool &, unsigned int &, nullptr_t, int, int, int, unsigned int &, bool &, DICompileUnit *, MDTupleTypedArrayWrapper<DITemplateParameter> &, DISubprogram *&, MDTuple *>> 
//<editor-fold defaultstate="collapsed" desc="getSubprogram">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 622,
 FQN="getSubprogram", NM="_ZL13getSubprogramIJRN4llvm11LLVMContextEPNS0_7DIScopeERNS0_9StringRefES6_RPNS0_6DIFileERjRPNS0_16DISubroutineTypeERbSE_SA_DniiiSA_SE_PNS0_13DICompileUnitERNS0_24MDTupleTypedArrayWrapperINS0_19DITemplateParameterEEERPNS0_12DISubprogramEPNS0_7MDTupleEEESM_bDpOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL13getSubprogramIJRN4llvm11LLVMContextEPNS0_7DIScopeERNS0_9StringRefES6_RPNS0_6DIFileERjRPNS0_16DISubroutineTypeERbSE_SA_DniiiSA_SE_PNS0_13DICompileUnitERNS0_24MDTupleTypedArrayWrapperINS0_19DITemplateParameterEEERPNS0_12DISubprogramEPNS0_7MDTupleEEESM_bDpOT_")
//</editor-fold>
public static DISubprogram /*P*/ getSubprogram(boolean IsDistinct,
        final LLVMContext /*&*/ /*&*/ Context, final DIScope /*P*/ /*&&*/ Scope, final StringRef /*&*/ /*&*/ Name,
        final StringRef /*&*/ /*&*/ LinkageName, final DIFile /*P*/ /*&*/ /*&*/ File, final int/*uint &*//*&*/ Line,
        final DISubroutineType /*P*/ /*&*/ /*&*/ Type, final boolean/*bool &*//*&*/ IsLocalToUnit,
        final boolean/*bool &*//*&*/ IsDefinition, final int/*uint &*//*&*/ ScopeLine, final DIType /*P*/ /*&*/ /*&*/ ContainingType,
        final int/*int &*//*&*/ Virtuality, final int/*int &*//*&*/ VirtualIndex, final int/*int &*//*&*/ ThisAdjustment,
        final int/*uint &*//*&*/ Flags, final boolean/*bool &*//*&*/ IsOptimized, final DICompileUnit /*P*/ /*&&*/ Unit,
        final MDTupleTypedArrayWrapper<DITemplateParameter> /*&*/ /*&*/ TemplateParams, final DISubprogram /*P*/ /*&*/ /*&*/ Declaration,
        final MDTuple /*P*/ /*&&*/ Variables) {
  if (IsDistinct) {
    return DISubprogram.getDistinct(Context, new TypedDINodeRef<DIScope>(DIScope.class, Scope), new StringRef(Name),
            new StringRef(LinkageName), File, Line,
            Type, IsLocalToUnit,
            IsDefinition, ScopeLine, ContainingType == null? new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null): new TypedDINodeRef<DIType>(DIType.class, ContainingType),
            Virtuality, VirtualIndex, ThisAdjustment,
            Flags, IsOptimized, Unit,
            new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), Declaration,
            new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, Variables));
  }
  return DISubprogram.get(Context, new TypedDINodeRef<DIScope>(DIScope.class, Scope), new StringRef(Name),
            new StringRef(LinkageName), File, Line,
            Type, IsLocalToUnit,
            IsDefinition, ScopeLine, ContainingType == null? new TypedDINodeRef<DIType>(DIType.class, JD$NullPtr.INSTANCE, null): new TypedDINodeRef<DIType>(DIType.class, ContainingType),
            Virtuality, VirtualIndex, ThisAdjustment,
            Flags, IsOptimized, Unit,
            new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), Declaration,
            new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, Variables));
}
///*template <class ... Ts> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="getSubprogram">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 622,
// FQN="getSubprogram", NM="Tpl__ZL13getSubprogrambDpOT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=Tpl__ZL13getSubprogrambDpOT_")
////</editor-fold>
//public static </*class*/ /*...*/ Ts> DISubprogram /*P*/ getSubprogram(boolean IsDistinct, Ts /*&&*/...Args) {
//  if (IsDistinct) {
//    return DISubprogram.getDistinct(std.<Ts>forward(Args)...);
//  }
//  return DISubprogram.get(std.<Ts>forward(Args)...);
//}

//<editor-fold defaultstate="collapsed" desc="getDbgIntrinsicValueImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 710,
 FQN="getDbgIntrinsicValueImpl", NM="_ZL24getDbgIntrinsicValueImplRN4llvm11LLVMContextEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL24getDbgIntrinsicValueImplRN4llvm11LLVMContextEPNS_5ValueE")
//</editor-fold>
public static Value /*P*/ getDbgIntrinsicValueImpl(final LLVMContext /*&*/ VMContext, Value /*P*/ V) {
  assert ((V != null)) : "no value passed to dbg intrinsic";
  return MetadataAsValue.get(VMContext, ValueAsMetadata.get(V));
}

//<editor-fold defaultstate="collapsed" desc="withDebugLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp", line = 715,
 FQN="withDebugLoc", NM="_ZL12withDebugLocPN4llvm11InstructionEPKNS_10DILocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DIBuilder.cpp -nm=_ZL12withDebugLocPN4llvm11InstructionEPKNS_10DILocationE")
//</editor-fold>
public static Instruction /*P*/ withDebugLoc(Instruction /*P*/ I, /*const*/ DILocation /*P*/ DL) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    I.setDebugLoc($c$.track(new DebugLoc(((/*const_cast*/DILocation /*P*/ )(DL))))); $c$.clean();
    return I;
  } finally {
    $c$.$destroy();
  }
}

} // END OF class DIBuilderStatics
