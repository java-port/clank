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


/// \brief Basic type, like 'int' or 'float'.
///
/// TODO: Split out DW_TAG_unspecified_type.
/// TODO: Drop unused accessors.
//<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 607,
 FQN="llvm::DIBasicType", NM="_ZN4llvm11DIBasicTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicTypeE")
//</editor-fold>
public class DIBasicType extends /*public*/ DIType implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Encoding;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::DIBasicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 613,
   FQN="llvm::DIBasicType::DIBasicType", NM="_ZN4llvm11DIBasicTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjyyjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjyyjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIBasicType(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Tag,
      long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DIType(C, DIBasicTypeKind, Storage, Tag, 0, SizeInBits, AlignInBits, 0, 0, Ops), Encoding(Encoding)
    //START JInit
    super(C, MetadataKind.DIBasicTypeKind.getValue(), Storage, Tag, 0, SizeInBits, AlignInBits, $int2ulong(0),
        0, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Encoding = Encoding;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::~DIBasicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 619,
   FQN="llvm::DIBasicType::~DIBasicType", NM="_ZN4llvm11DIBasicTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11DIBasicTypeD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 621,
   FQN="llvm::DIBasicType::getImpl", NM="_ZN4llvm11DIBasicType7getImplERNS_11LLVMContextEjNS_9StringRefEyyjNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType7getImplERNS_11LLVMContextEjNS_9StringRefEyyjNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIBasicType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Name, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, /*uint*/int Encoding,
         Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Name, SizeInBits,
         AlignInBits, Encoding,
         Storage, true);
  }
  private static DIBasicType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Name, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, /*uint*/int Encoding,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return DIBasicType.getImpl(Context, Tag, DINode.getCanonicalMDString(Context, new StringRef(Name)),
        SizeInBits, AlignInBits, Encoding, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 230,
   FQN="llvm::DIBasicType::getImpl", NM="_ZN4llvm11DIBasicType7getImplERNS_11LLVMContextEjPNS_8MDStringEyyjNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType7getImplERNS_11LLVMContextEjPNS_8MDStringEyyjNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIBasicType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         MDString /*P*/ Name, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, /*uint*/int Encoding,
         Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Name, SizeInBits,
         AlignInBits, Encoding,
         Storage, true);
  }
  private static DIBasicType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         MDString /*P*/ Name, long/*uint64_t*/ SizeInBits,
         long/*uint64_t*/ AlignInBits, /*uint*/int Encoding,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIBasicType /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIBasicTypes, new MDNodeKeyImplDIBasicType(Tag, Name, SizeInBits, AlignInBits, Encoding));
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
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {null, null, Name};
    return MDNode.storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIBasicType(Context, Storage, Tag, SizeInBits, AlignInBits, Encoding, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIBasicTypes);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 633,
   FQN="llvm::DIBasicType::cloneImpl", NM="_ZNK4llvm11DIBasicType9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIBasicType9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIBasicType.getTemporary(getContext(), getTag(), getName(), getSizeInBits(),
        getAlignInBits(), getEncoding());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 639,
   FQN="llvm::DIBasicType::get", NM="_ZN4llvm11DIBasicType3getERNS_11LLVMContextEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType3getERNS_11LLVMContextEjNS_9StringRefE")
  //</editor-fold>
  public static DIBasicType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name) {
    return DIBasicType.getImpl(Context, Tag, new StringRef(Name), $int2ulong(0), $int2ulong(0), 0, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 639,
   FQN="llvm::DIBasicType::getIfExists", NM="_ZN4llvm11DIBasicType11getIfExistsERNS_11LLVMContextEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType11getIfExistsERNS_11LLVMContextEjNS_9StringRefE")
  //</editor-fold>
  public static DIBasicType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name) {
    return DIBasicType.getImpl(Context, Tag, new StringRef(Name), $int2ulong(0), $int2ulong(0), 0, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 639,
   FQN="llvm::DIBasicType::getDistinct", NM="_ZN4llvm11DIBasicType11getDistinctERNS_11LLVMContextEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType11getDistinctERNS_11LLVMContextEjNS_9StringRefE")
  //</editor-fold>
  public static DIBasicType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name) {
    return DIBasicType.getImpl(Context, Tag, new StringRef(Name), $int2ulong(0), $int2ulong(0), 0, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 639,
   FQN="llvm::DIBasicType::getTemporary", NM="_ZN4llvm11DIBasicType12getTemporaryERNS_11LLVMContextEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType12getTemporaryERNS_11LLVMContextEjNS_9StringRefE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name) {
    return new std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/>(DIBasicType.getImpl(Context, Tag, new StringRef(Name), $int2ulong(0), $int2ulong(0), 0, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 641,
   FQN="llvm::DIBasicType::get", NM="_ZN4llvm11DIBasicType3getERNS_11LLVMContextEjNS_9StringRefEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType3getERNS_11LLVMContextEjNS_9StringRefEyyj")
  //</editor-fold>
  public static DIBasicType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return DIBasicType.getImpl(Context, Tag, new StringRef(Name), SizeInBits, AlignInBits, Encoding, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 641,
   FQN="llvm::DIBasicType::getIfExists", NM="_ZN4llvm11DIBasicType11getIfExistsERNS_11LLVMContextEjNS_9StringRefEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType11getIfExistsERNS_11LLVMContextEjNS_9StringRefEyyj")
  //</editor-fold>
  public static DIBasicType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return DIBasicType.getImpl(Context, Tag, new StringRef(Name), SizeInBits, AlignInBits, Encoding, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 641,
   FQN="llvm::DIBasicType::getDistinct", NM="_ZN4llvm11DIBasicType11getDistinctERNS_11LLVMContextEjNS_9StringRefEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType11getDistinctERNS_11LLVMContextEjNS_9StringRefEyyj")
  //</editor-fold>
  public static DIBasicType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return DIBasicType.getImpl(Context, Tag, new StringRef(Name), SizeInBits, AlignInBits, Encoding, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 641,
   FQN="llvm::DIBasicType::getTemporary", NM="_ZN4llvm11DIBasicType12getTemporaryERNS_11LLVMContextEjNS_9StringRefEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType12getTemporaryERNS_11LLVMContextEjNS_9StringRefEyyj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return new std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/>(DIBasicType.getImpl(Context, Tag, new StringRef(Name), SizeInBits, AlignInBits, Encoding, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 645,
   FQN="llvm::DIBasicType::get", NM="_ZN4llvm11DIBasicType3getERNS_11LLVMContextEjPNS_8MDStringEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType3getERNS_11LLVMContextEjPNS_8MDStringEyyj")
  //</editor-fold>
  public static DIBasicType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return getImpl(Context, Tag, Name, SizeInBits, AlignInBits, Encoding, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 645,
   FQN="llvm::DIBasicType::getIfExists", NM="_ZN4llvm11DIBasicType11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEyyj")
  //</editor-fold>
  public static DIBasicType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return getImpl(Context, Tag, Name, SizeInBits, AlignInBits, Encoding, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 645,
   FQN="llvm::DIBasicType::getDistinct", NM="_ZN4llvm11DIBasicType11getDistinctERNS_11LLVMContextEjPNS_8MDStringEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType11getDistinctERNS_11LLVMContextEjPNS_8MDStringEyyj")
  //</editor-fold>
  public static DIBasicType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return getImpl(Context, Tag, Name, SizeInBits, AlignInBits, Encoding, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 645,
   FQN="llvm::DIBasicType::getTemporary", NM="_ZN4llvm11DIBasicType12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEyyj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits, /*uint*/int Encoding) {
    return new std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/>(getImpl(Context, Tag, Name, SizeInBits, AlignInBits, Encoding, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 650,
   FQN="llvm::DIBasicType::clone", NM="_ZNK4llvm11DIBasicType5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIBasicType5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIBasicType /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::getEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 652,
   FQN="llvm::DIBasicType::getEncoding", NM="_ZNK4llvm11DIBasicType11getEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIBasicType11getEncodingEv")
  //</editor-fold>
  public /*uint*/int getEncoding() /*const*/ {
    return Encoding;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIBasicType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 654,
   FQN="llvm::DIBasicType::classof", NM="_ZN4llvm11DIBasicType7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIBasicType7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIBasicTypeKind.getValue();
  }


  @Override public String toString() {
    return "" + "Encoding=" + Encoding // NOI18N
              + super.toString(); // NOI18N
  }
}
