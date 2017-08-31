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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Composite types.
///
/// TODO: Detach from DerivedTypeBase (split out MDEnumType?).
/// TODO: Create a custom, unrelated node for DW_TAG_array_type.
//<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 767,
 FQN="llvm::DICompositeType", NM="_ZN4llvm15DICompositeTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeTypeE")
//</editor-fold>
public class DICompositeType extends /*public*/ DIType implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int RuntimeLang;

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::DICompositeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 773,
   FQN="llvm::DICompositeType::DICompositeType", NM="_ZN4llvm15DICompositeTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjjyyyjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjjyyyjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DICompositeType(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Tag,
      /*uint*/int Line, /*uint*/int RuntimeLang, long/*uint64_t*/ SizeInBits,
      long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DIType(C, DICompositeTypeKind, Storage, Tag, Line, SizeInBits, AlignInBits, OffsetInBits, Flags, Ops), RuntimeLang(RuntimeLang)
    //START JInit
    super(C, MetadataKind.DICompositeTypeKind.getValue(), Storage, Tag, Line, SizeInBits,
        AlignInBits, OffsetInBits, Flags, new ArrayRef<Metadata /*P*/ >(Ops));
    this.RuntimeLang = RuntimeLang;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::~DICompositeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 780,
   FQN="llvm::DICompositeType::~DICompositeType", NM="_ZN4llvm15DICompositeTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15DICompositeTypeD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  /// Change fields in place.
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::mutate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 783,
   FQN="llvm::DICompositeType::mutate", NM="_ZN4llvm15DICompositeType6mutateEjjjyyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType6mutateEjjjyyyj")
  //</editor-fold>
  private void mutate(/*uint*/int Tag, /*uint*/int Line, /*uint*/int RuntimeLang,
        long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
        /*uint*/int Flags) {
    assert (isDistinct()) : "Only distinct nodes can mutate";
    assert ((getRawIdentifier() != null)) : "Only ODR-uniqued nodes should mutate";
    this.RuntimeLang = RuntimeLang;
    super.mutate(Tag, Line, SizeInBits, AlignInBits, OffsetInBits, Flags);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 792,
   FQN="llvm::DICompositeType::getImpl", NM="_ZN4llvm15DICompositeType7getImplERNS_11LLVMContextEjNS_9StringRefEPNS_8MetadataEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyyNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_NS4_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType7getImplERNS_11LLVMContextEjNS_9StringRefEPNS_8MetadataEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyyNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_NS4_11StorageTypeEb")
  //</editor-fold>
  private static DICompositeType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, Metadata /*P*/ File,
         /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType,
         long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
         long/*uint64_t*/ Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang,
         TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams,
         StringRef Identifier, Metadata.StorageType Storage) {
    return getImpl(Context, Tag, Name, File,
         Line, Scope, BaseType,
         SizeInBits, AlignInBits, OffsetInBits,
         Flags, Elements, RuntimeLang,
         VTableHolder, TemplateParams,
         Identifier, Storage, true);
  }
  private static DICompositeType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, Metadata /*P*/ File,
         /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType,
         long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
         long/*uint64_t*/ Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang,
         TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams,
         StringRef Identifier, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Tag, DINode.getCanonicalMDString(Context, new StringRef(Name)), File, Line, Scope.$Metadata$P(),
        BaseType.$Metadata$P(), SizeInBits, AlignInBits, OffsetInBits, $ulong2uint(Flags), Elements.get(),
        RuntimeLang, VTableHolder.$Metadata$P(), TemplateParams.get(),
        DINode.getCanonicalMDString(Context, new StringRef(Identifier)), Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 257,
   FQN="llvm::DICompositeType::getImpl", NM="_ZN4llvm15DICompositeType7getImplERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_NS5_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType7getImplERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_NS5_11StorageTypeEb")
  //</editor-fold>
  private static DICompositeType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File,
         /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
         Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder,
         Metadata /*P*/ TemplateParams, MDString /*P*/ Identifier, Metadata.StorageType Storage) {
    return getImpl(Context, Tag, Name, File,
         Line, Scope, BaseType, SizeInBits,
         AlignInBits, OffsetInBits, Flags,
         Elements, RuntimeLang, VTableHolder,
         TemplateParams, Identifier, Storage,
         true);
  }
  private static DICompositeType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File,
         /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
         Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder,
         Metadata /*P*/ TemplateParams, MDString /*P*/ Identifier, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";

    // Keep this in sync with buildODRType.
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DICompositeType /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DICompositeTypes, new MDNodeKeyImplDICompositeType(Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, Identifier));
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
    Metadata /*P*/ Ops[/*8*/] = new Metadata /*P*/  [/*8*/] {
      File, Scope, Name, BaseType,
      Elements, VTableHolder, TemplateParams, Identifier};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DICompositeType(Context, Storage, Tag, Line, RuntimeLang, SizeInBits, AlignInBits, OffsetInBits, Flags, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DICompositeTypes);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 813,
   FQN="llvm::DICompositeType::cloneImpl", NM="_ZNK4llvm15DICompositeType9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DICompositeType.getTemporary(getContext(), getTag(), getName(), getFile(), getLine(),
        getScope(), getBaseType(), getSizeInBits(),
        getAlignInBits(), getOffsetInBits(), getFlags(),
        getElements(), getRuntimeLang(), getVTableHolder(),
        getTemplateParams(), getIdentifier());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 822,
   FQN="llvm::DICompositeType::get", NM="_ZN4llvm15DICompositeType3getERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType3getERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_")
  //</editor-fold>
  public static DICompositeType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder) {
    return get(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DICompositeType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return get(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DICompositeType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, StringRef Identifier/*= ""*/) {
    return DICompositeType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, $uint2ulong(Flags), new MDTupleTypedArrayWrapper<DINode>(Elements), RuntimeLang, new TypedDINodeRef<DIType>(VTableHolder), new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), new StringRef(Identifier), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getIfExists">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 822,
   FQN="llvm::DICompositeType::getIfExists", NM="_ZN4llvm15DICompositeType11getIfExistsERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType11getIfExistsERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_")
  //</editor-fold>
  public static DICompositeType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder) {
    return getIfExists(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DICompositeType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return getIfExists(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DICompositeType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, StringRef Identifier/*= ""*/) {
    return DICompositeType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, $uint2ulong(Flags), new MDTupleTypedArrayWrapper<DINode>(Elements), RuntimeLang, new TypedDINodeRef<DIType>(VTableHolder), new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), new StringRef(Identifier), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getDistinct">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 822,
   FQN="llvm::DICompositeType::getDistinct", NM="_ZN4llvm15DICompositeType11getDistinctERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType11getDistinctERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_")
  //</editor-fold>
  public static DICompositeType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder) {
    return getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DICompositeType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DICompositeType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, StringRef Identifier/*= ""*/) {
    return DICompositeType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, $uint2ulong(Flags), new MDTupleTypedArrayWrapper<DINode>(Elements), RuntimeLang, new TypedDINodeRef<DIType>(VTableHolder), new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), new StringRef(Identifier), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getTemporary">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 822,
   FQN="llvm::DICompositeType::getTemporary", NM="_ZN4llvm15DICompositeType12getTemporaryERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType12getTemporaryERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjNS_24MDTupleTypedArrayWrapperINS_6DINodeEEEjSA_NSB_INS_19DITemplateParameterEEES3_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder) {
    return getTemporary(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, (/*const*/ MDTuple /*P*/ )null), new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/) {
    return getTemporary(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, MDTupleTypedArrayWrapper<DINode> Elements, /*uint*/int RuntimeLang, TypedDINodeRef<DIType> VTableHolder, MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams/*= null*/, StringRef Identifier/*= ""*/) {
    return new std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/>(DICompositeType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, $uint2ulong(Flags), new MDTupleTypedArrayWrapper<DINode>(Elements), RuntimeLang, new TypedDINodeRef<DIType>(VTableHolder), new MDTupleTypedArrayWrapper<DITemplateParameter>(TemplateParams), new StringRef(Identifier), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 833,
   FQN="llvm::DICompositeType::get", NM="_ZN4llvm15DICompositeType3getERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType3getERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_")
  //</editor-fold>
  public static DICompositeType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder) {
    return get(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, (Metadata /*P*/ )null, (MDString /*P*/ )null);
  }
  public static DICompositeType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/) {
    return get(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, (MDString /*P*/ )null);
  }
  public static DICompositeType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/, MDString /*P*/ Identifier/*= null*/) {
    return getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, Identifier, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 833,
   FQN="llvm::DICompositeType::getIfExists", NM="_ZN4llvm15DICompositeType11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_")
  //</editor-fold>
  public static DICompositeType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder) {
    return getIfExists(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, (Metadata /*P*/ )null, (MDString /*P*/ )null);
  }
  public static DICompositeType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/) {
    return getIfExists(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, (MDString /*P*/ )null);
  }
  public static DICompositeType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/, MDString /*P*/ Identifier/*= null*/) {
    return getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, Identifier, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 833,
   FQN="llvm::DICompositeType::getDistinct", NM="_ZN4llvm15DICompositeType11getDistinctERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType11getDistinctERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_")
  //</editor-fold>
  public static DICompositeType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder) {
    return getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, (Metadata /*P*/ )null, (MDString /*P*/ )null);
  }
  public static DICompositeType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/) {
    return getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, (MDString /*P*/ )null);
  }
  public static DICompositeType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/, MDString /*P*/ Identifier/*= null*/) {
    return getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, Identifier, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 833,
   FQN="llvm::DICompositeType::getTemporary", NM="_ZN4llvm15DICompositeType12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_jS6_S6_S4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder) {
    return getTemporary(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, (Metadata /*P*/ )null, (MDString /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/) {
    return getTemporary(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, (MDString /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang, Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams/*= null*/, MDString /*P*/ Identifier/*= null*/) {
    return new std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/>(getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder, TemplateParams, Identifier, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 845,
   FQN="llvm::DICompositeType::clone", NM="_ZNK4llvm15DICompositeType5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  /// Get a DICompositeType with the given ODR identifier.
  ///
  /// If \a LLVMContext::isODRUniquingDebugTypes(), gets the mapped
  /// DICompositeType for the given ODR \c Identifier.  If none exists, creates
  /// a new node.
  ///
  /// Else, returns \c nullptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getODRType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 312,
   FQN="llvm::DICompositeType::getODRType", NM="_ZN4llvm15DICompositeType10getODRTypeERNS_11LLVMContextERNS_8MDStringEjPS3_PNS_8MetadataEjS7_S7_yyyjS7_jS7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType10getODRTypeERNS_11LLVMContextERNS_8MDStringEjPS3_PNS_8MetadataEjS7_S7_yyyjS7_jS7_S7_")
  //</editor-fold>
  public static DICompositeType /*P*/ getODRType(final LLVMContext /*&*/ Context, final MDString /*&*/ Identifier, /*uint*/int Tag, MDString /*P*/ Name,
            Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType,
            long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
            /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang,
            Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams) {
    assert (!Identifier.getString().empty()) : "Expected valid identifier";
    if (!Context.isODRUniquingDebugTypes()) {
      return null;
    }
    final type$ref<DICompositeType /*P*/ /*&*/> CT = (Context.pImpl.DITypeMap.$star()).ref$at($AddrOf(Identifier));
    if (!(CT.$deref() != null)) {
      CT.$set(DICompositeType.getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits,
          AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang, VTableHolder,
          TemplateParams, $AddrOf(Identifier)));
    }
    return CT.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getODRTypeIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 330,
   FQN="llvm::DICompositeType::getODRTypeIfExists", NM="_ZN4llvm15DICompositeType18getODRTypeIfExistsERNS_11LLVMContextERNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType18getODRTypeIfExistsERNS_11LLVMContextERNS_8MDStringE")
  //</editor-fold>
  public static DICompositeType /*P*/ getODRTypeIfExists(final LLVMContext /*&*/ Context,
                    final MDString /*&*/ Identifier) {
    assert (!Identifier.getString().empty()) : "Expected valid identifier";
    if (!Context.isODRUniquingDebugTypes()) {
      return null;
    }
    return Context.pImpl.DITypeMap.$arrow().lookup($AddrOf(Identifier));
  }


  /// Build a DICompositeType with the given ODR identifier.
  ///
  /// Looks up the mapped DICompositeType for the given ODR \c Identifier.  If
  /// it doesn't exist, creates a new one.  If it does exist and \a
  /// isForwardDecl(), and the new arguments would be a definition, mutates the
  /// the type in place.  In either case, returns the type.
  ///
  /// If not \a LLVMContext::isODRUniquingDebugTypes(), this function returns
  /// nullptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::buildODRType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 278,
   FQN="llvm::DICompositeType::buildODRType", NM="_ZN4llvm15DICompositeType12buildODRTypeERNS_11LLVMContextERNS_8MDStringEjPS3_PNS_8MetadataEjS7_S7_yyyjS7_jS7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType12buildODRTypeERNS_11LLVMContextERNS_8MDStringEjPS3_PNS_8MetadataEjS7_S7_yyyjS7_jS7_S7_")
  //</editor-fold>
  public static DICompositeType /*P*/ buildODRType(final LLVMContext /*&*/ Context, final MDString /*&*/ Identifier, /*uint*/int Tag, MDString /*P*/ Name,
              Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType,
              long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits,
              /*uint*/int Flags, Metadata /*P*/ Elements, /*uint*/int RuntimeLang,
              Metadata /*P*/ VTableHolder, Metadata /*P*/ TemplateParams) {
    assert (!Identifier.getString().empty()) : "Expected valid identifier";
    if (!Context.isODRUniquingDebugTypes()) {
      return null;
    }
    final type$ref<DICompositeType /*P*/ /*&*/> CT = (Context.pImpl.DITypeMap.$star()).ref$at($AddrOf(Identifier));
    if (!(CT.$deref() != null)) {
      return CT.$set(DICompositeType.getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits,
          AlignInBits, OffsetInBits, Flags, Elements, RuntimeLang,
          VTableHolder, TemplateParams, $AddrOf(Identifier)));
    }

    // Only mutate CT if it's a forward declaration and the new operands aren't.
    assert (CT.$deref().getRawIdentifier() == $AddrOf(Identifier)) : "Wrong ODR identifier?";
    if (!CT.$deref().isForwardDecl() || ((Flags & DINode.DIFlags.FlagFwdDecl) != 0)) {
      return CT.$deref();
    }

    // Mutate CT in place.  Keep this in sync with getImpl.
    CT.$deref().mutate(Tag, Line, RuntimeLang, SizeInBits, AlignInBits, OffsetInBits,
        Flags);
    Metadata /*P*/ Ops[/*8*/] = new Metadata /*P*/  [/*8*/] {
      File, Scope, Name, BaseType,
      Elements, VTableHolder, TemplateParams, $AddrOf(Identifier)};
    assert ((std.end(Ops).$sub(std.begin(Ops))) == (int)CT.$deref().getNumOperands()) : "Mismatched number of operands";
    for (/*uint*/int I = 0, E = CT.$deref().getNumOperands(); I != E; ++I)  {
      if (Ops[I] != CT.$deref().getOperand(I).$Metadata$P()) {
        CT.$deref().setOperand(I, Ops[I]);
      }
    }
    return CT.$deref();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 881,
   FQN="llvm::DICompositeType::getBaseType", NM="_ZNK4llvm15DICompositeType11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType11getBaseTypeEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getBaseType() /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, getRawBaseType());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 882,
   FQN="llvm::DICompositeType::getElements", NM="_ZNK4llvm15DICompositeType11getElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType11getElementsEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DINode> getElements() /*const*/ {
    return new MDTupleTypedArrayWrapper<DINode>(DINode.class, cast_or_null_MDTuple(getRawElements()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getVTableHolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 885,
   FQN="llvm::DICompositeType::getVTableHolder", NM="_ZNK4llvm15DICompositeType15getVTableHolderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType15getVTableHolderEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getVTableHolder() /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, getRawVTableHolder());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 886,
   FQN="llvm::DICompositeType::getTemplateParams", NM="_ZNK4llvm15DICompositeType17getTemplateParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType17getTemplateParamsEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DITemplateParameter> getTemplateParams() /*const*/ {
    return new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, cast_or_null_MDTuple(getRawTemplateParams()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 889,
   FQN="llvm::DICompositeType::getIdentifier", NM="_ZNK4llvm15DICompositeType13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType13getIdentifierEv")
  //</editor-fold>
  public StringRef getIdentifier() /*const*/ {
    return getStringOperand(7);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getRuntimeLang">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 890,
   FQN="llvm::DICompositeType::getRuntimeLang", NM="_ZNK4llvm15DICompositeType14getRuntimeLangEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType14getRuntimeLangEv")
  //</editor-fold>
  public /*uint*/int getRuntimeLang() /*const*/ {
    return RuntimeLang;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getRawBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 892,
   FQN="llvm::DICompositeType::getRawBaseType", NM="_ZNK4llvm15DICompositeType14getRawBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType14getRawBaseTypeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawBaseType() /*const*/ {
    return getOperand(3).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getRawElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 893,
   FQN="llvm::DICompositeType::getRawElements", NM="_ZNK4llvm15DICompositeType14getRawElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType14getRawElementsEv")
  //</editor-fold>
  public Metadata /*P*/ getRawElements() /*const*/ {
    return getOperand(4).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getRawVTableHolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 894,
   FQN="llvm::DICompositeType::getRawVTableHolder", NM="_ZNK4llvm15DICompositeType18getRawVTableHolderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType18getRawVTableHolderEv")
  //</editor-fold>
  public Metadata /*P*/ getRawVTableHolder() /*const*/ {
    return getOperand(5).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getRawTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 895,
   FQN="llvm::DICompositeType::getRawTemplateParams", NM="_ZNK4llvm15DICompositeType20getRawTemplateParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType20getRawTemplateParamsEv")
  //</editor-fold>
  public Metadata /*P*/ getRawTemplateParams() /*const*/ {
    return getOperand(6).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::getRawIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 896,
   FQN="llvm::DICompositeType::getRawIdentifier", NM="_ZNK4llvm15DICompositeType16getRawIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm15DICompositeType16getRawIdentifierEv")
  //</editor-fold>
  public MDString /*P*/ getRawIdentifier() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 7);
  }


  /// \brief Replace operands.
  ///
  /// If this \a isUniqued() and not \a isResolved(), on a uniquing collision
  /// this will be RAUW'ed and deleted.  Use a \a TrackingMDRef to keep track
  /// of its movement if necessary.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::replaceElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 904,
   FQN="llvm::DICompositeType::replaceElements", NM="_ZN4llvm15DICompositeType15replaceElementsENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType15replaceElementsENS_24MDTupleTypedArrayWrapperINS_6DINodeEEE")
  //</editor-fold>
  public void replaceElements(MDTupleTypedArrayWrapper<DINode> Elements) {
    for (DINode /*P*/ Op : getElements())  {
      assert ((std.find(Elements.$arrow().op_begin(), Elements.$arrow().op_end(), Op) != null)) : "Lost a member during member list replacement";
    }
    replaceOperandWith(4, Elements.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::replaceVTableHolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 912,
   FQN="llvm::DICompositeType::replaceVTableHolder", NM="_ZN4llvm15DICompositeType19replaceVTableHolderENS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType19replaceVTableHolderENS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public void replaceVTableHolder(TypedDINodeRef<DIType> VTableHolder) {
    replaceOperandWith(5, VTableHolder.$Metadata$P());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::replaceTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 915,
   FQN="llvm::DICompositeType::replaceTemplateParams", NM="_ZN4llvm15DICompositeType21replaceTemplateParamsENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType21replaceTemplateParamsENS_24MDTupleTypedArrayWrapperINS_19DITemplateParameterEEE")
  //</editor-fold>
  public void replaceTemplateParams(MDTupleTypedArrayWrapper<DITemplateParameter> TemplateParams) {
    replaceOperandWith(6, TemplateParams.get());
  }

  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::DICompositeType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 920,
   FQN="llvm::DICompositeType::classof", NM="_ZN4llvm15DICompositeType7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm15DICompositeType7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DICompositeTypeKind.getValue();
  }


  @Override public String toString() {
    return "" + "RuntimeLang=" + RuntimeLang // NOI18N
              + super.toString(); // NOI18N
  }
}
