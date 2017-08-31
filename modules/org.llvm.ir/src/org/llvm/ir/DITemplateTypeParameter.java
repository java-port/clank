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
import org.llvm.support.dwarf.Tag;

//<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1730,
 FQN="llvm::DITemplateTypeParameter", NM="_ZN4llvm23DITemplateTypeParameterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameterE")
//</editor-fold>
public class DITemplateTypeParameter extends /*public*/ DITemplateParameter implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::DITemplateTypeParameter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1734,
   FQN="llvm::DITemplateTypeParameter::DITemplateTypeParameter", NM="_ZN4llvm23DITemplateTypeParameterC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameterC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DITemplateTypeParameter(final LLVMContext /*&*/ Context, Metadata.StorageType Storage,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DITemplateParameter(Context, DITemplateTypeParameterKind, Storage, dwarf::DW_TAG_template_type_parameter, Ops)
    //START JInit
    super(Context, MetadataKind.DITemplateTypeParameterKind.getValue(), Storage,
        $ushort2uint(Tag.DW_TAG_template_type_parameter), new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::~DITemplateTypeParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1738,
   FQN="llvm::DITemplateTypeParameter::~DITemplateTypeParameter", NM="_ZN4llvm23DITemplateTypeParameterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23DITemplateTypeParameterD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1740,
   FQN="llvm::DITemplateTypeParameter::getImpl", NM="_ZN4llvm23DITemplateTypeParameter7getImplERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter7getImplERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DITemplateTypeParameter /*P*/ getImpl(final LLVMContext /*&*/ Context, StringRef Name,
         TypedDINodeRef<DIType> Type, Metadata.StorageType Storage) {
    return getImpl(Context, Name,
         Type, Storage,
         true);
  }
  private static DITemplateTypeParameter /*P*/ getImpl(final LLVMContext /*&*/ Context, StringRef Name,
         TypedDINodeRef<DIType> Type, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, DINode.getCanonicalMDString(Context, new StringRef(Name)), Type.$Metadata$P(), Storage,
        ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 488,
   FQN="llvm::DITemplateTypeParameter::getImpl", NM="_ZN4llvm23DITemplateTypeParameter7getImplERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataENS5_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter7getImplERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataENS5_11StorageTypeEb")
  //</editor-fold>
  private static DITemplateTypeParameter /*P*/ getImpl(final LLVMContext /*&*/ Context,
         MDString /*P*/ Name,
         Metadata /*P*/ Type,
         Metadata.StorageType Storage) {
    return getImpl(Context,
         Name,
         Type,
         Storage,
         true);
  }
  private static DITemplateTypeParameter /*P*/ getImpl(final LLVMContext /*&*/ Context,
         MDString /*P*/ Name,
         Metadata /*P*/ Type,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DITemplateTypeParameter /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DITemplateTypeParameters, new MDNodeKeyImplDITemplateTypeParameter(Name, Type));
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
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {Name, Type};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DITemplateTypeParameter(Context, Storage, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DITemplateTypeParameters);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1750,
   FQN="llvm::DITemplateTypeParameter::cloneImpl", NM="_ZNK4llvm23DITemplateTypeParameter9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm23DITemplateTypeParameter9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DITemplateTypeParameter /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DITemplateTypeParameter.getTemporary(getContext(), getName(), getType());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1755,
   FQN="llvm::DITemplateTypeParameter::get", NM="_ZN4llvm23DITemplateTypeParameter3getERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter3getERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static DITemplateTypeParameter /*P*/ get(final LLVMContext /*&*/ Context, StringRef Name, TypedDINodeRef<DIType> Type) {
    return DITemplateTypeParameter.getImpl(Context, new StringRef(Name), new TypedDINodeRef<DIType>(Type), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1755,
   FQN="llvm::DITemplateTypeParameter::getIfExists", NM="_ZN4llvm23DITemplateTypeParameter11getIfExistsERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter11getIfExistsERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static DITemplateTypeParameter /*P*/ getIfExists(final LLVMContext /*&*/ Context, StringRef Name, TypedDINodeRef<DIType> Type) {
    return DITemplateTypeParameter.getImpl(Context, new StringRef(Name), new TypedDINodeRef<DIType>(Type), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1755,
   FQN="llvm::DITemplateTypeParameter::getDistinct", NM="_ZN4llvm23DITemplateTypeParameter11getDistinctERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter11getDistinctERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static DITemplateTypeParameter /*P*/ getDistinct(final LLVMContext /*&*/ Context, StringRef Name, TypedDINodeRef<DIType> Type) {
    return DITemplateTypeParameter.getImpl(Context, new StringRef(Name), new TypedDINodeRef<DIType>(Type), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1755,
   FQN="llvm::DITemplateTypeParameter::getTemporary", NM="_ZN4llvm23DITemplateTypeParameter12getTemporaryERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter12getTemporaryERNS_11LLVMContextENS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DITemplateTypeParameter /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, StringRef Name, TypedDINodeRef<DIType> Type) {
    return new std.unique_ptr_with_deleter<DITemplateTypeParameter /*, TempMDNodeDeleter*/>(DITemplateTypeParameter.getImpl(Context, new StringRef(Name), new TypedDINodeRef<DIType>(Type), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1757,
   FQN="llvm::DITemplateTypeParameter::get", NM="_ZN4llvm23DITemplateTypeParameter3getERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter3getERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE")
  //</editor-fold>
  public static DITemplateTypeParameter /*P*/ get(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ Type) {
    return getImpl(Context, Name, Type, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1757,
   FQN="llvm::DITemplateTypeParameter::getIfExists", NM="_ZN4llvm23DITemplateTypeParameter11getIfExistsERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter11getIfExistsERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE")
  //</editor-fold>
  public static DITemplateTypeParameter /*P*/ getIfExists(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ Type) {
    return getImpl(Context, Name, Type, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1757,
   FQN="llvm::DITemplateTypeParameter::getDistinct", NM="_ZN4llvm23DITemplateTypeParameter11getDistinctERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter11getDistinctERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE")
  //</editor-fold>
  public static DITemplateTypeParameter /*P*/ getDistinct(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ Type) {
    return getImpl(Context, Name, Type, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1757,
   FQN="llvm::DITemplateTypeParameter::getTemporary", NM="_ZN4llvm23DITemplateTypeParameter12getTemporaryERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter12getTemporaryERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DITemplateTypeParameter /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ Type) {
    return new std.unique_ptr_with_deleter<DITemplateTypeParameter /*, TempMDNodeDeleter*/>(getImpl(Context, Name, Type, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1760,
   FQN="llvm::DITemplateTypeParameter::clone", NM="_ZNK4llvm23DITemplateTypeParameter5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm23DITemplateTypeParameter5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DITemplateTypeParameter /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateTypeParameter::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1762,
   FQN="llvm::DITemplateTypeParameter::classof", NM="_ZN4llvm23DITemplateTypeParameter7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm23DITemplateTypeParameter7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DITemplateTypeParameterKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
