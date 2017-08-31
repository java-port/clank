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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;


/// \brief Type array for a subprogram.
///
/// TODO: Fold the array of types in directly as operands.
//<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 928,
 FQN="llvm::DISubroutineType", NM="_ZN4llvm16DISubroutineTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineTypeE")
//</editor-fold>
public class DISubroutineType extends /*public*/ DIType implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  /// The calling convention used with DW_AT_calling_convention. Actually of
  /// type dwarf::CallingConvention.
  private byte/*uint8_t*/ CC;

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::DISubroutineType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 936,
   FQN="llvm::DISubroutineType::DISubroutineType", NM="_ZN4llvm16DISubroutineTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjhNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineTypeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjhNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DISubroutineType(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Flags,
      byte/*uint8_t*/ CC, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIType(C, DISubroutineTypeKind, Storage, dwarf::DW_TAG_subroutine_type, 0, 0, 0, 0, Flags, Ops), CC(CC)
    //START JInit
    super(C, MetadataKind.DISubroutineTypeKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_subroutine_type),
        0, $int2ulong(0), $int2ulong(0), $int2ulong(0), Flags, new ArrayRef<Metadata /*P*/ >(Ops));
    this.CC = CC;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::~DISubroutineType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 941,
   FQN="llvm::DISubroutineType::~DISubroutineType", NM="_ZN4llvm16DISubroutineTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16DISubroutineTypeD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 943,
   FQN="llvm::DISubroutineType::getImpl", NM="_ZN4llvm16DISubroutineType7getImplERNS_11LLVMContextEjhNS_14DITypeRefArrayENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType7getImplERNS_11LLVMContextEjhNS_14DITypeRefArrayENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DISubroutineType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Flags,
         byte/*uint8_t*/ CC, DITypeRefArray TypeArray,
         Metadata.StorageType Storage) {
    return getImpl(Context, Flags,
         CC, TypeArray,
         Storage,
         true);
  }
  private static DISubroutineType /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Flags,
         byte/*uint8_t*/ CC, DITypeRefArray TypeArray,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Flags, CC, TypeArray.get(), Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 338,
   FQN="llvm::DISubroutineType::getImpl", NM="_ZN4llvm16DISubroutineType7getImplERNS_11LLVMContextEjhPNS_8MetadataENS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType7getImplERNS_11LLVMContextEjhPNS_8MetadataENS3_11StorageTypeEb")
  //</editor-fold>
  private static DISubroutineType /*P*/ getImpl(final LLVMContext /*&*/ Context,
         /*uint*/int Flags, byte/*uint8_t*/ CC,
         Metadata /*P*/ TypeArray,
         Metadata.StorageType Storage) {
    return getImpl(Context,
         Flags, CC,
         TypeArray,
         Storage,
         true);
  }
  private static DISubroutineType /*P*/ getImpl(final LLVMContext /*&*/ Context,
         /*uint*/int Flags, byte/*uint8_t*/ CC,
         Metadata /*P*/ TypeArray,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DISubroutineType /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DISubroutineTypes, new MDNodeKeyImplDISubroutineType(Flags, CC, TypeArray));
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
    Metadata /*P*/ Ops[/*4*/] = new Metadata /*P*/  [/*4*/] {null, null, null, TypeArray};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DISubroutineType(Context, Storage, Flags, CC, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DISubroutineTypes);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 954,
   FQN="llvm::DISubroutineType::cloneImpl", NM="_ZNK4llvm16DISubroutineType9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DISubroutineType9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DISubroutineType /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DISubroutineType.getTemporary(getContext(), getFlags(), getCC(), getTypeArray());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 959,
   FQN="llvm::DISubroutineType::get", NM="_ZN4llvm16DISubroutineType3getERNS_11LLVMContextEjhNS_14DITypeRefArrayE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType3getERNS_11LLVMContextEjhNS_14DITypeRefArrayE")
  //</editor-fold>
  public static DISubroutineType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, DITypeRefArray TypeArray) {
    return DISubroutineType.getImpl(Context, Flags, CC, new DITypeRefArray(TypeArray), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 959,
   FQN="llvm::DISubroutineType::getIfExists", NM="_ZN4llvm16DISubroutineType11getIfExistsERNS_11LLVMContextEjhNS_14DITypeRefArrayE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType11getIfExistsERNS_11LLVMContextEjhNS_14DITypeRefArrayE")
  //</editor-fold>
  public static DISubroutineType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, DITypeRefArray TypeArray) {
    return DISubroutineType.getImpl(Context, Flags, CC, new DITypeRefArray(TypeArray), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 959,
   FQN="llvm::DISubroutineType::getDistinct", NM="_ZN4llvm16DISubroutineType11getDistinctERNS_11LLVMContextEjhNS_14DITypeRefArrayE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType11getDistinctERNS_11LLVMContextEjhNS_14DITypeRefArrayE")
  //</editor-fold>
  public static DISubroutineType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, DITypeRefArray TypeArray) {
    return DISubroutineType.getImpl(Context, Flags, CC, new DITypeRefArray(TypeArray), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 959,
   FQN="llvm::DISubroutineType::getTemporary", NM="_ZN4llvm16DISubroutineType12getTemporaryERNS_11LLVMContextEjhNS_14DITypeRefArrayE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType12getTemporaryERNS_11LLVMContextEjhNS_14DITypeRefArrayE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DISubroutineType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, DITypeRefArray TypeArray) {
    return new std.unique_ptr_with_deleter<DISubroutineType /*, TempMDNodeDeleter*/>(DISubroutineType.getImpl(Context, Flags, CC, new DITypeRefArray(TypeArray), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 962,
   FQN="llvm::DISubroutineType::get", NM="_ZN4llvm16DISubroutineType3getERNS_11LLVMContextEjhPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType3getERNS_11LLVMContextEjhPNS_8MetadataE")
  //</editor-fold>
  public static DISubroutineType /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, Metadata /*P*/ TypeArray) {
    return getImpl(Context, Flags, CC, TypeArray, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 962,
   FQN="llvm::DISubroutineType::getIfExists", NM="_ZN4llvm16DISubroutineType11getIfExistsERNS_11LLVMContextEjhPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType11getIfExistsERNS_11LLVMContextEjhPNS_8MetadataE")
  //</editor-fold>
  public static DISubroutineType /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, Metadata /*P*/ TypeArray) {
    return getImpl(Context, Flags, CC, TypeArray, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 962,
   FQN="llvm::DISubroutineType::getDistinct", NM="_ZN4llvm16DISubroutineType11getDistinctERNS_11LLVMContextEjhPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType11getDistinctERNS_11LLVMContextEjhPNS_8MetadataE")
  //</editor-fold>
  public static DISubroutineType /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, Metadata /*P*/ TypeArray) {
    return getImpl(Context, Flags, CC, TypeArray, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 962,
   FQN="llvm::DISubroutineType::getTemporary", NM="_ZN4llvm16DISubroutineType12getTemporaryERNS_11LLVMContextEjhPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType12getTemporaryERNS_11LLVMContextEjhPNS_8MetadataE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DISubroutineType /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Flags, byte/*uint8_t*/ CC, Metadata /*P*/ TypeArray) {
    return new std.unique_ptr_with_deleter<DISubroutineType /*, TempMDNodeDeleter*/>(getImpl(Context, Flags, CC, TypeArray, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 966,
   FQN="llvm::DISubroutineType::clone", NM="_ZNK4llvm16DISubroutineType5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DISubroutineType5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DISubroutineType /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 968,
   FQN="llvm::DISubroutineType::getCC", NM="_ZNK4llvm16DISubroutineType5getCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DISubroutineType5getCCEv")
  //</editor-fold>
  public byte/*uint8_t*/ getCC() /*const*/ {
    return CC;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getTypeArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 970,
   FQN="llvm::DISubroutineType::getTypeArray", NM="_ZNK4llvm16DISubroutineType12getTypeArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DISubroutineType12getTypeArrayEv")
  //</editor-fold>
  public DITypeRefArray getTypeArray() /*const*/ {
    return new DITypeRefArray(cast_or_null_MDTuple(getRawTypeArray()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::getRawTypeArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 973,
   FQN="llvm::DISubroutineType::getRawTypeArray", NM="_ZNK4llvm16DISubroutineType15getRawTypeArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DISubroutineType15getRawTypeArrayEv")
  //</editor-fold>
  public Metadata /*P*/ getRawTypeArray() /*const*/ {
    return getOperand(3).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubroutineType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 975,
   FQN="llvm::DISubroutineType::classof", NM="_ZN4llvm16DISubroutineType7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DISubroutineType7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DISubroutineTypeKind.getValue();
  }


  @Override public String toString() {
    return "" + "CC=" + $uchar2uint(CC) // NOI18N
              + super.toString(); // NOI18N
  }
}
