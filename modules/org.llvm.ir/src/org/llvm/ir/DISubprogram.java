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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.dwarf.VirtualityAttribute;


/// \brief Subprogram description.
///
/// TODO: Remove DisplayName.  It's always equal to Name.
/// TODO: Split up flags.
//<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1275,
 FQN="llvm::DISubprogram", NM="_ZN4llvm12DISubprogramE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogramE")
//</editor-fold>
public class DISubprogram extends /*public*/ DILocalScope implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;
  private /*uint*/int ScopeLine;
  private /*uint*/int VirtualIndex;

  /// In the MS ABI, the implicit 'this' parameter is adjusted in the prologue
  /// of method overrides from secondary bases by this amount. It may be
  /// negative.
  private int ThisAdjustment;

  // Virtuality can only assume three values, so we can pack
  // in 2 bits (none/pure/pure_virtual).
  private /*JBYTE unsigned int*/ byte Virtuality /*: 2*/;

  private /*uint*/int Flags /*: 27*/;

  // These are boolean flags so one bit is enough.
  // MSVC starts a new container field every time the base
  // type changes so we can't use 'bool' to ensure these bits
  // are packed.
  private /*JBIT unsigned int*/ boolean IsLocalToUnit /*: 1*/;
  private /*JBIT unsigned int*/ boolean IsDefinition /*: 1*/;
  private /*JBIT unsigned int*/ boolean IsOptimized /*: 1*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::DISubprogram">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1302,
   FQN="llvm::DISubprogram::DISubprogram", NM="_ZN4llvm12DISubprogramC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjjjijbbbNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogramC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjjjijbbbNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DISubprogram(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Line,
      /*uint*/int ScopeLine, /*uint*/int Virtuality, /*uint*/int VirtualIndex,
      int ThisAdjustment, /*uint*/int Flags, boolean IsLocalToUnit,
      boolean IsDefinition, boolean IsOptimized, ArrayRef<Metadata /*P*/ > Ops) {
    // : DILocalScope(C, DISubprogramKind, Storage, dwarf::DW_TAG_subprogram, Ops), Line(Line), ScopeLine(ScopeLine), VirtualIndex(VirtualIndex), ThisAdjustment(ThisAdjustment), Virtuality(Virtuality), Flags(Flags), IsLocalToUnit(IsLocalToUnit), IsDefinition(IsDefinition), IsOptimized(IsOptimized)
    //START JInit
    super(C, MetadataKind.DISubprogramKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_subprogram),
        new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    this.ScopeLine = ScopeLine;
    this.VirtualIndex = VirtualIndex;
    this.ThisAdjustment = ThisAdjustment;
    this.Virtuality = $uint2uint_2bits(Virtuality);
    this.Flags = Flags;
    this.IsLocalToUnit = IsLocalToUnit;
    this.IsDefinition = IsDefinition;
    this.IsOptimized = IsOptimized;
    //END JInit
    static_assert(VirtualityAttribute.DW_VIRTUALITY_max < 4, $("Virtuality out of range"));
    assert ($less_uint(Virtuality, 4)) : "Virtuality out of range";
    assert (($less_uint(Flags, (1 << 27)))) : "Flags out of range";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::~DISubprogram">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1316,
   FQN="llvm::DISubprogram::~DISubprogram", NM="_ZN4llvm12DISubprogramD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12DISubprogramD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1318,
   FQN="llvm::DISubprogram::getImpl", NM="_ZN4llvm12DISubprogram7getImplERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram7getImplERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DISubprogram /*P*/ getImpl(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name,
         StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line,
         DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition,
         /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality,
         /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags,
         boolean IsOptimized, DICompileUnit /*P*/ Unit,
         MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams, DISubprogram /*P*/ Declaration,
         MDTupleTypedArrayWrapper<DILocalVariable> Variables, Metadata.StorageType Storage) {
    return getImpl(Context, Scope, Name,
         LinkageName, File, Line,
         Type, IsLocalToUnit, IsDefinition,
         ScopeLine, ContainingType, Virtuality,
         VirtualIndex, ThisAdjustment, Flags,
         IsOptimized, Unit,
         TemplateParams, Declaration,
         Variables, Storage,
         true);
  }
  private static DISubprogram /*P*/ getImpl(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name,
         StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line,
         DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition,
         /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality,
         /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags,
         boolean IsOptimized, DICompileUnit /*P*/ Unit,
         MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams, DISubprogram /*P*/ Declaration,
         MDTupleTypedArrayWrapper<DILocalVariable> Variables, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Scope.$Metadata$P(), DINode.getCanonicalMDString(Context, new StringRef(Name)),
        DINode.getCanonicalMDString(Context, new StringRef(LinkageName)), File, Line, Type,
        IsLocalToUnit, IsDefinition, ScopeLine, ContainingType.$Metadata$P(),
        Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized,
        Unit, TemplateParams.get(), Declaration, Variables.get(),
        Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 410,
   FQN="llvm::DISubprogram::getImpl", NM="_ZN4llvm12DISubprogram7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_NS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram7getImplERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_NS3_11StorageTypeEb")
  //</editor-fold>
  private static DISubprogram /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name,
         MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type,
         boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine,
         Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex,
         int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit,
         Metadata /*P*/ TemplateParams, Metadata /*P*/ Declaration, Metadata /*P*/ Variables,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope, Name,
         LinkageName, File, Line, Type,
         IsLocalToUnit, IsDefinition, ScopeLine,
         ContainingType, Virtuality, VirtualIndex,
         ThisAdjustment, Flags, IsOptimized, Unit,
         TemplateParams, Declaration, Variables,
         Storage, true);
  }
  private static DISubprogram /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name,
         MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type,
         boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine,
         Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex,
         int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit,
         Metadata /*P*/ TemplateParams, Metadata /*P*/ Declaration, Metadata /*P*/ Variables,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(LinkageName)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DISubprogram /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DISubprograms, new MDNodeKeyImplDISubprogram(Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, Variables));
          if ((N != null)) {
            return N;
          }
        }
        if (!ShouldCreate) {
          return null;
        }
      } else {
        assert (ShouldCreate) : "Expected non-uniqued nodes to always be created";
      }
    } while (false);
    Metadata /*P*/ Ops[/*11*/] = new Metadata /*P*/  [/*11*/] {
      File, Scope, Name, Name,
      LinkageName, Type, ContainingType, Unit,
      TemplateParams, Declaration, Variables};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DISubprogram(Context, Storage, Line, ScopeLine, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsLocalToUnit, IsDefinition, IsOptimized, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DISubprograms);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1344,
   FQN="llvm::DISubprogram::cloneImpl", NM="_ZNK4llvm12DISubprogram9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DISubprogram.getTemporary(getContext(), getScope(), getName(), getLinkageName(), getFile(),
        getLine(), getType(), isLocalToUnit(), isDefinition(), getScopeLine(),
        getContainingType(), getVirtuality(), getVirtualIndex(),
        getThisAdjustment(), getFlags(), isOptimized(), getUnit(),
        getTemplateParams(), getDeclaration(), getVariables());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1354,
   FQN="llvm::DISubprogram::get", NM="_ZN4llvm12DISubprogram3getERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram3getERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE")
  //</editor-fold>
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit) {
    return get(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return get(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/) {
    return get(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/, MDTupleTypedArrayWrapper<DILocalVariable> Variables/*= null*/) {
    return DISubprogram.getImpl(Context, new TypedDINodeRef<DIScope>(Scope), new StringRef(Name), new StringRef(LinkageName), File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, new TypedDINodeRef<DIType>(ContainingType), Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(Variables), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1354,
   FQN="llvm::DISubprogram::getIfExists", NM="_ZN4llvm12DISubprogram11getIfExistsERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram11getIfExistsERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE")
  //</editor-fold>
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit) {
    return getIfExists(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return getIfExists(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/) {
    return getIfExists(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/, MDTupleTypedArrayWrapper<DILocalVariable> Variables/*= null*/) {
    return DISubprogram.getImpl(Context, new TypedDINodeRef<DIScope>(Scope), new StringRef(Name), new StringRef(LinkageName), File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, new TypedDINodeRef<DIType>(ContainingType), Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(Variables), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1354,
   FQN="llvm::DISubprogram::getDistinct", NM="_ZN4llvm12DISubprogram11getDistinctERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram11getDistinctERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE")
  //</editor-fold>
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit) {
    return getDistinct(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return getDistinct(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/) {
    return getDistinct(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/, MDTupleTypedArrayWrapper<DILocalVariable> Variables/*= null*/) {
    return DISubprogram.getImpl(Context, new TypedDINodeRef<DIScope>(Scope), new StringRef(Name), new StringRef(LinkageName), File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, new TypedDINodeRef<DIType>(ContainingType), Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(Variables), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1354,
   FQN="llvm::DISubprogram::getTemporary", NM="_ZN4llvm12DISubprogram12getTemporaryERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram12getTemporaryERNS_11LLVMContextENS_14TypedDINodeRefINS_7DIScopeEEENS_9StringRefES6_PNS_6DIFileEjPNS_16DISubroutineTypeEbbjNS3_INS_6DITypeEEEjjijbPNS_13DICompileUnitENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEEPS0_NSF_INS_15DILocalVariableEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit) {
    return getTemporary(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return getTemporary(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (DISubprogram /*P*/ )null, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/) {
    return getTemporary(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, (/*const*/ MDTuple /*P*/ )null));
  }
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, TypedDINodeRef<DIScope> Scope, StringRef Name, StringRef LinkageName, DIFile /*P*/ File, /*uint*/int Line, DISubroutineType /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, TypedDINodeRef<DIType> ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, DICompileUnit /*P*/ Unit, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, DISubprogram /*P*/ Declaration/*= null*/, MDTupleTypedArrayWrapper<DILocalVariable> Variables/*= null*/) {
    return new std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/>(DISubprogram.getImpl(Context, new TypedDINodeRef<DIScope>(Scope), new StringRef(Name), new StringRef(LinkageName), File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, new TypedDINodeRef<DIType>(ContainingType), Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), Declaration, new MDTupleTypedArrayWrapper<DILocalVariable>(Variables), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1368,
   FQN="llvm::DISubprogram::get", NM="_ZN4llvm12DISubprogram3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram3getERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_")
  //</editor-fold>
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit) {
    return get(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, (Metadata /*P*/ )null, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/) {
    return get(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/) {
    return get(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/, Metadata /*P*/ Variables/*= null*/) {
    return getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, Variables, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1368,
   FQN="llvm::DISubprogram::getIfExists", NM="_ZN4llvm12DISubprogram11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram11getIfExistsERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_")
  //</editor-fold>
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit) {
    return getIfExists(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, (Metadata /*P*/ )null, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/) {
    return getIfExists(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/) {
    return getIfExists(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/, Metadata /*P*/ Variables/*= null*/) {
    return getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, Variables, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1368,
   FQN="llvm::DISubprogram::getDistinct", NM="_ZN4llvm12DISubprogram11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram11getDistinctERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_")
  //</editor-fold>
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit) {
    return getDistinct(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, (Metadata /*P*/ )null, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/) {
    return getDistinct(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/) {
    return getDistinct(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, (Metadata /*P*/ )null);
  }
  public static DISubprogram /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/, Metadata /*P*/ Variables/*= null*/) {
    return getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, Variables, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1368,
   FQN="llvm::DISubprogram::getTemporary", NM="_ZN4llvm12DISubprogram12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram12getTemporaryERNS_11LLVMContextEPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit) {
    return getTemporary(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, (Metadata /*P*/ )null, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/) {
    return getTemporary(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, (Metadata /*P*/ )null, (Metadata /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/) {
    return getTemporary(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, (Metadata /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type, boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine, Metadata /*P*/ ContainingType, /*uint*/int Virtuality, /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags, boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams/*= null*/, Metadata /*P*/ Declaration/*= null*/, Metadata /*P*/ Variables/*= null*/) {
    return new std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, Name, LinkageName, File, Line, Type, IsLocalToUnit, IsDefinition, ScopeLine, ContainingType, Virtuality, VirtualIndex, ThisAdjustment, Flags, IsOptimized, Unit, TemplateParams, Declaration, Variables, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1380,
   FQN="llvm::DISubprogram::clone", NM="_ZNK4llvm12DISubprogram5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DISubprogram /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1383,
   FQN="llvm::DISubprogram::getLine", NM="_ZNK4llvm12DISubprogram7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getVirtuality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1384,
   FQN="llvm::DISubprogram::getVirtuality", NM="_ZNK4llvm12DISubprogram13getVirtualityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram13getVirtualityEv")
  //</editor-fold>
  public /*uint*/int getVirtuality() /*const*/ {
    return $2bits_uint2uint(Virtuality);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getVirtualIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1385,
   FQN="llvm::DISubprogram::getVirtualIndex", NM="_ZNK4llvm12DISubprogram15getVirtualIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram15getVirtualIndexEv")
  //</editor-fold>
  public /*uint*/int getVirtualIndex() /*const*/ {
    return VirtualIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1386,
   FQN="llvm::DISubprogram::getThisAdjustment", NM="_ZNK4llvm12DISubprogram17getThisAdjustmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17getThisAdjustmentEv")
  //</editor-fold>
  public int getThisAdjustment() /*const*/ {
    return ThisAdjustment;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getScopeLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1387,
   FQN="llvm::DISubprogram::getScopeLine", NM="_ZNK4llvm12DISubprogram12getScopeLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram12getScopeLineEv")
  //</editor-fold>
  public /*uint*/int getScopeLine() /*const*/ {
    return ScopeLine;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1388,
   FQN="llvm::DISubprogram::getFlags", NM="_ZNK4llvm12DISubprogram8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram8getFlagsEv")
  //</editor-fold>
  public /*uint*/int getFlags() /*const*/ {
    return Flags;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isLocalToUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1389,
   FQN="llvm::DISubprogram::isLocalToUnit", NM="_ZNK4llvm12DISubprogram13isLocalToUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram13isLocalToUnitEv")
  //</editor-fold>
  public boolean isLocalToUnit() /*const*/ {
    return IsLocalToUnit;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1390,
   FQN="llvm::DISubprogram::isDefinition", NM="_ZNK4llvm12DISubprogram12isDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram12isDefinitionEv")
  //</editor-fold>
  public boolean isDefinition() /*const*/ {
    return IsDefinition;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isOptimized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1391,
   FQN="llvm::DISubprogram::isOptimized", NM="_ZNK4llvm12DISubprogram11isOptimizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram11isOptimizedEv")
  //</editor-fold>
  public boolean isOptimized() /*const*/ {
    return IsOptimized;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isArtificial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1393,
   FQN="llvm::DISubprogram::isArtificial", NM="_ZNK4llvm12DISubprogram12isArtificialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram12isArtificialEv")
  //</editor-fold>
  public /*uint*/int isArtificial() /*const*/ {
    return getFlags() & DIFlags.FlagArtificial;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1394,
   FQN="llvm::DISubprogram::isPrivate", NM="_ZNK4llvm12DISubprogram9isPrivateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram9isPrivateEv")
  //</editor-fold>
  public boolean isPrivate() /*const*/ {
    return (getFlags() & DIFlags.FlagAccessibility) == DIFlags.FlagPrivate;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isProtected">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1397,
   FQN="llvm::DISubprogram::isProtected", NM="_ZNK4llvm12DISubprogram11isProtectedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram11isProtectedEv")
  //</editor-fold>
  public boolean isProtected() /*const*/ {
    return (getFlags() & DIFlags.FlagAccessibility) == DIFlags.FlagProtected;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isPublic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1400,
   FQN="llvm::DISubprogram::isPublic", NM="_ZNK4llvm12DISubprogram8isPublicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram8isPublicEv")
  //</editor-fold>
  public boolean isPublic() /*const*/ {
    return (getFlags() & DIFlags.FlagAccessibility) == DIFlags.FlagPublic;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1403,
   FQN="llvm::DISubprogram::isExplicit", NM="_ZNK4llvm12DISubprogram10isExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram10isExplicitEv")
  //</editor-fold>
  public boolean isExplicit() /*const*/ {
    return ((getFlags() & DIFlags.FlagExplicit) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isPrototyped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1404,
   FQN="llvm::DISubprogram::isPrototyped", NM="_ZNK4llvm12DISubprogram12isPrototypedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram12isPrototypedEv")
  //</editor-fold>
  public boolean isPrototyped() /*const*/ {
    return ((getFlags() & DIFlags.FlagPrototyped) != 0);
  }


  /// \brief Check if this is reference-qualified.
  ///
  /// Return true if this subprogram is a C++11 reference-qualified non-static
  /// member function (void foo() &).
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isLValueReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1410,
   FQN="llvm::DISubprogram::isLValueReference", NM="_ZNK4llvm12DISubprogram17isLValueReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17isLValueReferenceEv")
  //</editor-fold>
  public /*uint*/int isLValueReference() /*const*/ {
    return getFlags() & DIFlags.FlagLValueReference;
  }


  /// \brief Check if this is rvalue-reference-qualified.
  ///
  /// Return true if this subprogram is a C++11 rvalue-reference-qualified
  /// non-static member function (void foo() &&).
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::isRValueReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1418,
   FQN="llvm::DISubprogram::isRValueReference", NM="_ZNK4llvm12DISubprogram17isRValueReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17isRValueReferenceEv")
  //</editor-fold>
  public /*uint*/int isRValueReference() /*const*/ {
    return getFlags() & DIFlags.FlagRValueReference;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1422,
   FQN="llvm::DISubprogram::getScope", NM="_ZNK4llvm12DISubprogram8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram8getScopeEv")
  //</editor-fold>
  public TypedDINodeRef<DIScope> getScope() /*const*/ {
    return new TypedDINodeRef<DIScope>(DIScope.class, getRawScope());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1424,
   FQN="llvm::DISubprogram::getName", NM="_ZNK4llvm12DISubprogram7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getDisplayName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1425,
   FQN="llvm::DISubprogram::getDisplayName", NM="_ZNK4llvm12DISubprogram14getDisplayNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram14getDisplayNameEv")
  //</editor-fold>
  public StringRef getDisplayName() /*const*/ {
    return getStringOperand(3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getLinkageName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1426,
   FQN="llvm::DISubprogram::getLinkageName", NM="_ZNK4llvm12DISubprogram14getLinkageNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram14getLinkageNameEv")
  //</editor-fold>
  public StringRef getLinkageName() /*const*/ {
    return getStringOperand(4);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1428,
   FQN="llvm::DISubprogram::getRawName", NM="_ZNK4llvm12DISubprogram10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawLinkageName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1429,
   FQN="llvm::DISubprogram::getRawLinkageName", NM="_ZNK4llvm12DISubprogram17getRawLinkageNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17getRawLinkageNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawLinkageName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 4);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1431,
   FQN="llvm::DISubprogram::getType", NM="_ZNK4llvm12DISubprogram7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram7getTypeEv")
  //</editor-fold>
  public DISubroutineType /*P*/ getType() /*const*/ {
    return cast_or_null_DISubroutineType(getRawType());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getContainingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1434,
   FQN="llvm::DISubprogram::getContainingType", NM="_ZNK4llvm12DISubprogram17getContainingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17getContainingTypeEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getContainingType() /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, getRawContainingType());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1438,
   FQN="llvm::DISubprogram::getUnit", NM="_ZNK4llvm12DISubprogram7getUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram7getUnitEv")
  //</editor-fold>
  public DICompileUnit /*P*/ getUnit() /*const*/ {
    return cast_or_null_DICompileUnit(getRawUnit());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::replaceUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1441,
   FQN="llvm::DISubprogram::replaceUnit", NM="_ZN4llvm12DISubprogram11replaceUnitEPNS_13DICompileUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram11replaceUnitEPNS_13DICompileUnitE")
  //</editor-fold>
  public void replaceUnit(DICompileUnit /*P*/ CU) {
    replaceOperandWith(7, CU);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1444,
   FQN="llvm::DISubprogram::getTemplateParams", NM="_ZNK4llvm12DISubprogram17getTemplateParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17getTemplateParamsEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DITemplateParameter> getTemplateParams() /*const*/ {
    return new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, cast_or_null_MDTuple(getRawTemplateParams()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1447,
   FQN="llvm::DISubprogram::getDeclaration", NM="_ZNK4llvm12DISubprogram14getDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram14getDeclarationEv")
  //</editor-fold>
  public DISubprogram /*P*/ getDeclaration() /*const*/ {
    return cast_or_null_DISubprogram(getRawDeclaration());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getVariables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1450,
   FQN="llvm::DISubprogram::getVariables", NM="_ZNK4llvm12DISubprogram12getVariablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram12getVariablesEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DILocalVariable> getVariables() /*const*/ {
    return new MDTupleTypedArrayWrapper<DILocalVariable>(DILocalVariable.class, cast_or_null_MDTuple(getRawVariables()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1454,
   FQN="llvm::DISubprogram::getRawScope", NM="_ZNK4llvm12DISubprogram11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(1).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1455,
   FQN="llvm::DISubprogram::getRawType", NM="_ZNK4llvm12DISubprogram10getRawTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram10getRawTypeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawType() /*const*/ {
    return getOperand(5).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawContainingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1456,
   FQN="llvm::DISubprogram::getRawContainingType", NM="_ZNK4llvm12DISubprogram20getRawContainingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram20getRawContainingTypeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawContainingType() /*const*/ {
    return getOperand(6).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1457,
   FQN="llvm::DISubprogram::getRawUnit", NM="_ZNK4llvm12DISubprogram10getRawUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram10getRawUnitEv")
  //</editor-fold>
  public Metadata /*P*/ getRawUnit() /*const*/ {
    return getOperand(7).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1458,
   FQN="llvm::DISubprogram::getRawTemplateParams", NM="_ZNK4llvm12DISubprogram20getRawTemplateParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram20getRawTemplateParamsEv")
  //</editor-fold>
  public Metadata /*P*/ getRawTemplateParams() /*const*/ {
    return getOperand(8).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1459,
   FQN="llvm::DISubprogram::getRawDeclaration", NM="_ZNK4llvm12DISubprogram17getRawDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram17getRawDeclarationEv")
  //</editor-fold>
  public Metadata /*P*/ getRawDeclaration() /*const*/ {
    return getOperand(9).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::getRawVariables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1460,
   FQN="llvm::DISubprogram::getRawVariables", NM="_ZNK4llvm12DISubprogram15getRawVariablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram15getRawVariablesEv")
  //</editor-fold>
  public Metadata /*P*/ getRawVariables() /*const*/ {
    return getOperand(10).$Metadata$P();
  }


  /// \brief Check if this subprogram describes the given function.
  ///
  /// FIXME: Should this be looking through bitcasts?
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::describes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 434,
   FQN="llvm::DISubprogram::describes", NM="_ZNK4llvm12DISubprogram9describesEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DISubprogram9describesEPKNS_8FunctionE")
  //</editor-fold>
  public boolean describes(/*const*/ Function /*P*/ F) /*const*/ {
    assert ((F != null)) : "Invalid function";
    if (F.getSubprogram() == this) {
      return true;
    }
    StringRef Name = getLinkageName();
    if (Name.empty()) {
      Name.$assignMove(getName());
    }
    return $eq_StringRef(F.getName(), /*NO_COPY*/Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubprogram::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1467,
   FQN="llvm::DISubprogram::classof", NM="_ZN4llvm12DISubprogram7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DISubprogram7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DISubprogramKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", ScopeLine=" + ScopeLine // NOI18N
              + ", VirtualIndex=" + VirtualIndex // NOI18N
              + ", ThisAdjustment=" + ThisAdjustment // NOI18N
              + ", Virtuality=" + $uchar2uint(Virtuality) // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", IsLocalToUnit=" + IsLocalToUnit // NOI18N
              + ", IsDefinition=" + IsDefinition // NOI18N
              + ", IsOptimized=" + IsOptimized // NOI18N
              + super.toString(); // NOI18N
  }
}
