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
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1767,
 FQN="llvm::DITemplateValueParameter", NM="_ZN4llvm24DITemplateValueParameterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameterE")
//</editor-fold>
public class DITemplateValueParameter extends /*public*/ DITemplateParameter implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::DITemplateValueParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1771,
   FQN="llvm::DITemplateValueParameter::DITemplateValueParameter", NM="_ZN4llvm24DITemplateValueParameterC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameterC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DITemplateValueParameter(final LLVMContext /*&*/ Context, Metadata.StorageType Storage,
      /*uint*/int Tag, ArrayRef<Metadata /*P*/ > Ops) {
    // : DITemplateParameter(Context, DITemplateValueParameterKind, Storage, Tag, Ops)
    //START JInit
    super(Context, MetadataKind.DITemplateValueParameterKind.getValue(), Storage, Tag,
        new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::~DITemplateValueParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1775,
   FQN="llvm::DITemplateValueParameter::~DITemplateValueParameter", NM="_ZN4llvm24DITemplateValueParameterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm24DITemplateValueParameterD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1777,
   FQN="llvm::DITemplateValueParameter::getImpl", NM="_ZN4llvm24DITemplateValueParameter7getImplERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataENS7_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter7getImplERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataENS7_11StorageTypeEb")
  //</editor-fold>
  private static DITemplateValueParameter /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Name, TypedDINodeRef<DIType> Type,
         Metadata /*P*/ Value, Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Name, Type,
         Value, Storage,
         true);
  }
  private static DITemplateValueParameter /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Name, TypedDINodeRef<DIType> Type,
         Metadata /*P*/ Value, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Tag, DINode.getCanonicalMDString(Context, new StringRef(Name)), Type.$Metadata$P(),
        Value, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 499,
   FQN="llvm::DITemplateValueParameter::getImpl", NM="_ZN4llvm24DITemplateValueParameter7getImplERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_NS5_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter7getImplERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_NS5_11StorageTypeEb")
  //</editor-fold>
  private static DITemplateValueParameter /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ Type,
         Metadata /*P*/ Value, Metadata.StorageType Storage) {
    return getImpl(Context, Tag, Name, Type,
         Value, Storage, true);
  }
  private static DITemplateValueParameter /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ Type,
         Metadata /*P*/ Value, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DITemplateValueParameter /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DITemplateValueParameters, new MDNodeKeyImplDITemplateValueParameter(Tag, Name, Type, Value));
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
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {Name, Type, Value};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DITemplateValueParameter(Context, Storage, Tag, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DITemplateValueParameters);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1789,
   FQN="llvm::DITemplateValueParameter::cloneImpl", NM="_ZNK4llvm24DITemplateValueParameter9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm24DITemplateValueParameter9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DITemplateValueParameter /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DITemplateValueParameter.getTemporary(getContext(), getTag(), getName(), getType(),
        getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1795,
   FQN="llvm::DITemplateValueParameter::get", NM="_ZN4llvm24DITemplateValueParameter3getERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter3getERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE")
  //</editor-fold>
  public static DITemplateValueParameter /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, TypedDINodeRef<DIType> Type, Metadata /*P*/ Value) {
    return DITemplateValueParameter.getImpl(Context, Tag, new StringRef(Name), new TypedDINodeRef<DIType>(Type), Value, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1795,
   FQN="llvm::DITemplateValueParameter::getIfExists", NM="_ZN4llvm24DITemplateValueParameter11getIfExistsERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter11getIfExistsERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE")
  //</editor-fold>
  public static DITemplateValueParameter /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, TypedDINodeRef<DIType> Type, Metadata /*P*/ Value) {
    return DITemplateValueParameter.getImpl(Context, Tag, new StringRef(Name), new TypedDINodeRef<DIType>(Type), Value, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1795,
   FQN="llvm::DITemplateValueParameter::getDistinct", NM="_ZN4llvm24DITemplateValueParameter11getDistinctERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter11getDistinctERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE")
  //</editor-fold>
  public static DITemplateValueParameter /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, TypedDINodeRef<DIType> Type, Metadata /*P*/ Value) {
    return DITemplateValueParameter.getImpl(Context, Tag, new StringRef(Name), new TypedDINodeRef<DIType>(Type), Value, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1795,
   FQN="llvm::DITemplateValueParameter::getTemporary", NM="_ZN4llvm24DITemplateValueParameter12getTemporaryERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter12getTemporaryERNS_11LLVMContextEjNS_9StringRefENS_14TypedDINodeRefINS_6DITypeEEEPNS_8MetadataE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DITemplateValueParameter /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Name, TypedDINodeRef<DIType> Type, Metadata /*P*/ Value) {
    return new std.unique_ptr_with_deleter<DITemplateValueParameter /*, TempMDNodeDeleter*/>(DITemplateValueParameter.getImpl(Context, Tag, new StringRef(Name), new TypedDINodeRef<DIType>(Type), Value, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1798,
   FQN="llvm::DITemplateValueParameter::get", NM="_ZN4llvm24DITemplateValueParameter3getERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter3getERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_")
  //</editor-fold>
  public static DITemplateValueParameter /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ Type, Metadata /*P*/ Value) {
    return getImpl(Context, Tag, Name, Type, Value, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1798,
   FQN="llvm::DITemplateValueParameter::getIfExists", NM="_ZN4llvm24DITemplateValueParameter11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter11getIfExistsERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_")
  //</editor-fold>
  public static DITemplateValueParameter /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ Type, Metadata /*P*/ Value) {
    return getImpl(Context, Tag, Name, Type, Value, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1798,
   FQN="llvm::DITemplateValueParameter::getDistinct", NM="_ZN4llvm24DITemplateValueParameter11getDistinctERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter11getDistinctERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_")
  //</editor-fold>
  public static DITemplateValueParameter /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ Type, Metadata /*P*/ Value) {
    return getImpl(Context, Tag, Name, Type, Value, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1798,
   FQN="llvm::DITemplateValueParameter::getTemporary", NM="_ZN4llvm24DITemplateValueParameter12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter12getTemporaryERNS_11LLVMContextEjPNS_8MDStringEPNS_8MetadataES6_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DITemplateValueParameter /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Name, Metadata /*P*/ Type, Metadata /*P*/ Value) {
    return new std.unique_ptr_with_deleter<DITemplateValueParameter /*, TempMDNodeDeleter*/>(getImpl(Context, Tag, Name, Type, Value, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1802,
   FQN="llvm::DITemplateValueParameter::clone", NM="_ZNK4llvm24DITemplateValueParameter5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm24DITemplateValueParameter5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DITemplateValueParameter /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1804,
   FQN="llvm::DITemplateValueParameter::getValue", NM="_ZNK4llvm24DITemplateValueParameter8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm24DITemplateValueParameter8getValueEv")
  //</editor-fold>
  public Metadata /*P*/ getValue() /*const*/ {
    return getOperand(2).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITemplateValueParameter::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1806,
   FQN="llvm::DITemplateValueParameter::classof", NM="_ZN4llvm24DITemplateValueParameter7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm24DITemplateValueParameter7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DITemplateValueParameterKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
