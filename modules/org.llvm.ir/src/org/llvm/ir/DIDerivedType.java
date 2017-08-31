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
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;


/// \brief Derived types.
///
/// This includes qualified types, pointers, references, friends, typedefs, and
/// class members.
///
/// TODO: Split out members (inheritance, fields, methods, etc.).
//<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 665,
 FQN="llvm::DIDerivedType", NM="_ZN4llvm13DIDerivedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedTypeE")
//</editor-fold>
public class DIDerivedType extends /*public*/ DIType implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::DIDerivedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 669,
   FQN="llvm::DIDerivedType::DIDerivedType", NM="_ZN4llvm13DIDerivedTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjyyyjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjyyyjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIDerivedType(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Tag,
      /*uint*/int Line, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits,
      long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIType(C, DIDerivedTypeKind, Storage, Tag, Line, SizeInBits, AlignInBits, OffsetInBits, Flags, Ops)
    //START JInit
    super(C, MetadataKind.DIDerivedTypeKind.getValue(), Storage, Tag, Line, SizeInBits,
        AlignInBits, OffsetInBits, Flags, new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::~DIDerivedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 674,
   FQN="llvm::DIDerivedType::~DIDerivedType", NM="_ZN4llvm13DIDerivedTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm13DIDerivedTypeD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 676,
   FQN="llvm::DIDerivedType::getImpl", NM="_ZN4llvm13DIDerivedType7getImplERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataENSB_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType7getImplERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataENSB_11StorageTypeEb")
  //</editor-fold>
  private static DIDerivedType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Name, DIFile /*P*/ File, /*uint*/int Line,
         TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType,
         long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits,
         long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
         Metadata /*P*/ ExtraData, Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Name, File, Line,
         Scope, BaseType,
         SizeInBits, AlignInBits,
         OffsetInBits, Flags,
         ExtraData, Storage,
         true);
  }
  private static DIDerivedType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Name, DIFile /*P*/ File, /*uint*/int Line,
         TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType,
         long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits,
         long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
         Metadata /*P*/ ExtraData, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Tag, DINode.getCanonicalMDString(Context, new StringRef(Name)), File,
        Line, Scope.$Metadata$P(), BaseType.$Metadata$P(), SizeInBits, AlignInBits, OffsetInBits,
        Flags, ExtraData, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 242,
   FQN="llvm::DIDerivedType::getImpl", NM="_ZN4llvm13DIDerivedType7getImplERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_NS5_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType7getImplERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_NS5_11StorageTypeEb")
  //</editor-fold>
  private static DIDerivedType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File,
         /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
         Metadata /*P*/ ExtraData, Metadata.StorageType Storage) {
    return getImpl(Context, Tag, Name, File,
         Line, Scope, BaseType, SizeInBits,
         AlignInBits, OffsetInBits, Flags,
         ExtraData, Storage, true);
  }
  private static DIDerivedType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File,
         /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags,
         Metadata /*P*/ ExtraData, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIDerivedType /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIDerivedTypes, new MDNodeKeyImplDIDerivedType(Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData));
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
    Metadata /*P*/ Ops[/*5*/] = new Metadata /*P*/  [/*5*/] {File, Scope, Name, BaseType, ExtraData};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIDerivedType(Context, Storage, Tag, Line, SizeInBits, AlignInBits, OffsetInBits, Flags, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIDerivedTypes);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 695,
   FQN="llvm::DIDerivedType::cloneImpl", NM="_ZNK4llvm13DIDerivedType9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIDerivedType.getTemporary(getContext(), getTag(), getName(), getFile(), getLine(),
        getScope(), getBaseType(), getSizeInBits(),
        getAlignInBits(), getOffsetInBits(), getFlags(),
        getExtraData());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 703,
   FQN="llvm::DIDerivedType::get", NM="_ZN4llvm13DIDerivedType3getERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType3getERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_")
  //</editor-fold>
  public static DIDerivedType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return get(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static DIDerivedType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 703,
   FQN="llvm::DIDerivedType::getIfExists", NM="_ZN4llvm13DIDerivedType11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_")
  //</editor-fold>
  public static DIDerivedType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return getIfExists(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static DIDerivedType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 703,
   FQN="llvm::DIDerivedType::getDistinct", NM="_ZN4llvm13DIDerivedType11getDistinctERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType11getDistinctERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_")
  //</editor-fold>
  public static DIDerivedType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static DIDerivedType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 703,
   FQN="llvm::DIDerivedType::getTemporary", NM="_ZN4llvm13DIDerivedType12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataEjS6_S6_yyyjS6_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return getTemporary(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Scope, Metadata /*P*/ BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return new std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/>(getImpl(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 711,
   FQN="llvm::DIDerivedType::get", NM="_ZN4llvm13DIDerivedType3getERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType3getERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE")
  //</editor-fold>
  public static DIDerivedType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return get(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static DIDerivedType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return DIDerivedType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 711,
   FQN="llvm::DIDerivedType::getIfExists", NM="_ZN4llvm13DIDerivedType11getIfExistsERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType11getIfExistsERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE")
  //</editor-fold>
  public static DIDerivedType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return getIfExists(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static DIDerivedType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return DIDerivedType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 711,
   FQN="llvm::DIDerivedType::getDistinct", NM="_ZN4llvm13DIDerivedType11getDistinctERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType11getDistinctERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE")
  //</editor-fold>
  public static DIDerivedType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return getDistinct(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static DIDerivedType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return DIDerivedType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 711,
   FQN="llvm::DIDerivedType::getTemporary", NM="_ZN4llvm13DIDerivedType12getTemporaryERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType12getTemporaryERNS_11LLVMContextEjNS_9StringRefEPNS_6DIFileEjNS_14TypedDINodeRefINS_7DIScopeEEENS6_INS_6DITypeEEEyyyjPNS_8MetadataE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    return getTemporary(Context, Tag, Name, File, Line, Scope, BaseType, SizeInBits, AlignInBits, OffsetInBits, Flags, (Metadata /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, TypedDINodeRef<DIScope> Scope, TypedDINodeRef<DIType> BaseType, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, Metadata /*P*/ ExtraData/*= null*/) {
    return new std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/>(DIDerivedType.getImpl(Context, Tag, new StringRef(Name), File, Line, new TypedDINodeRef<DIScope>(Scope), new TypedDINodeRef<DIType>(BaseType), SizeInBits, AlignInBits, OffsetInBits, Flags, ExtraData, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 719,
   FQN="llvm::DIDerivedType::clone", NM="_ZNK4llvm13DIDerivedType5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIDerivedType /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //// Get the base type this is derived from.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 722,
   FQN="llvm::DIDerivedType::getBaseType", NM="_ZNK4llvm13DIDerivedType11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType11getBaseTypeEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getBaseType() /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, getRawBaseType());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getRawBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 723,
   FQN="llvm::DIDerivedType::getRawBaseType", NM="_ZNK4llvm13DIDerivedType14getRawBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType14getRawBaseTypeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawBaseType() /*const*/ {
    return getOperand(3).$Metadata$P();
  }


  /// \brief Get extra data associated with this derived type.
  ///
  /// Class type for pointer-to-members, objective-c property node for ivars,
  /// or global constant wrapper for static members.
  ///
  /// TODO: Separate out types that need this extra operand: pointer-to-member
  /// types and member fields (static members and ivars).
  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getExtraData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 732,
   FQN="llvm::DIDerivedType::getExtraData", NM="_ZNK4llvm13DIDerivedType12getExtraDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType12getExtraDataEv")
  //</editor-fold>
  public Metadata /*P*/ getExtraData() /*const*/ {
    return getRawExtraData();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getRawExtraData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 733,
   FQN="llvm::DIDerivedType::getRawExtraData", NM="_ZNK4llvm13DIDerivedType15getRawExtraDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType15getRawExtraDataEv")
  //</editor-fold>
  public Metadata /*P*/ getRawExtraData() /*const*/ {
    return getOperand(4).$Metadata$P();
  }


  /// \brief Get casted version of extra data.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getClassType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 737,
   FQN="llvm::DIDerivedType::getClassType", NM="_ZNK4llvm13DIDerivedType12getClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType12getClassTypeEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getClassType() /*const*/ {
    assert (getTag() == $ushort2uint(Tag.DW_TAG_ptr_to_member_type));
    return new TypedDINodeRef<DIType>(DIType.class, getExtraData());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getObjCProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 741,
   FQN="llvm::DIDerivedType::getObjCProperty", NM="_ZNK4llvm13DIDerivedType15getObjCPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType15getObjCPropertyEv")
  //</editor-fold>
  public DIObjCProperty /*P*/ getObjCProperty() /*const*/ {
    return dyn_cast_or_null_DIObjCProperty(getExtraData());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getStorageOffsetInBits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 744,
   FQN="llvm::DIDerivedType::getStorageOffsetInBits", NM="_ZNK4llvm13DIDerivedType22getStorageOffsetInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType22getStorageOffsetInBitsEv")
  //</editor-fold>
  public Constant /*P*/ getStorageOffsetInBits() /*const*/ {
    assert (getTag() == $ushort2uint(Tag.DW_TAG_member) && isBitField());
    {
      ConstantAsMetadata /*P*/ C = cast_or_null_ConstantAsMetadata(getExtraData());
      if ((C != null)) {
        return C.getValue();
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::getConstant">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 750,
   FQN="llvm::DIDerivedType::getConstant", NM="_ZNK4llvm13DIDerivedType11getConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13DIDerivedType11getConstantEv")
  //</editor-fold>
  public Constant /*P*/ getConstant() /*const*/ {
    assert (getTag() == $ushort2uint(Tag.DW_TAG_member) && isStaticMember());
    {
      ConstantAsMetadata /*P*/ C = cast_or_null_ConstantAsMetadata(getExtraData());
      if ((C != null)) {
        return C.getValue();
      }
    }
    return null;
  }

  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::DIDerivedType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 758,
   FQN="llvm::DIDerivedType::classof", NM="_ZN4llvm13DIDerivedType7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13DIDerivedType7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIDerivedTypeKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
