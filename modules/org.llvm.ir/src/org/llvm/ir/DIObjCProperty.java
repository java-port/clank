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
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;

//<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2160,
 FQN="llvm::DIObjCProperty", NM="_ZN4llvm14DIObjCPropertyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCPropertyE")
//</editor-fold>
public class DIObjCProperty extends /*public*/ DINode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;
  private /*uint*/int Attributes;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::DIObjCProperty">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2167,
   FQN="llvm::DIObjCProperty::DIObjCProperty", NM="_ZN4llvm14DIObjCPropertyC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCPropertyC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIObjCProperty(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Line,
      /*uint*/int Attributes, ArrayRef<Metadata /*P*/ > Ops) {
    // : DINode(C, DIObjCPropertyKind, Storage, dwarf::DW_TAG_APPLE_property, Ops), Line(Line), Attributes(Attributes)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DIObjCPropertyKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_APPLE_property),
        new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    this.Attributes = Attributes;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::~DIObjCProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2172,
   FQN="llvm::DIObjCProperty::~DIObjCProperty", NM="_ZN4llvm14DIObjCPropertyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm14DIObjCPropertyD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2174,
   FQN="llvm::DIObjCProperty::getImpl", NM="_ZN4llvm14DIObjCProperty7getImplERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty7getImplERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIObjCProperty /*P*/ getImpl(final LLVMContext /*&*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int Line,
         StringRef GetterName, StringRef SetterName, /*uint*/int Attributes,
         TypedDINodeRef<DIType> Type, Metadata.StorageType Storage) {
    return getImpl(Context, Name, File, Line,
         GetterName, SetterName, Attributes,
         Type, Storage, true);
  }
  private static DIObjCProperty /*P*/ getImpl(final LLVMContext /*&*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int Line,
         StringRef GetterName, StringRef SetterName, /*uint*/int Attributes,
         TypedDINodeRef<DIType> Type, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return getImpl(Context, DINode.getCanonicalMDString(Context, new StringRef(Name)), File, Line,
        DINode.getCanonicalMDString(Context, new StringRef(GetterName)),
        DINode.getCanonicalMDString(Context, new StringRef(SetterName)), Attributes, Type.$Metadata$P(),
        Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 603,
   FQN="llvm::DIObjCProperty::getImpl", NM="_ZN4llvm14DIObjCProperty7getImplERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_NS5_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty7getImplERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_NS5_11StorageTypeEb")
  //</editor-fold>
  private static DIObjCProperty /*P*/ getImpl(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line,
         MDString /*P*/ GetterName, MDString /*P*/ SetterName, /*uint*/int Attributes,
         Metadata /*P*/ Type, Metadata.StorageType Storage) {
    return getImpl(Context, Name, File, Line,
         GetterName, SetterName, Attributes,
         Type, Storage, true);
  }
  private static DIObjCProperty /*P*/ getImpl(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line,
         MDString /*P*/ GetterName, MDString /*P*/ SetterName, /*uint*/int Attributes,
         Metadata /*P*/ Type, Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(GetterName)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(SetterName)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIObjCProperty /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIObjCPropertys, new MDNodeKeyImplDIObjCProperty(Name, File, Line, GetterName, SetterName, Attributes, Type));
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
    Metadata /*P*/ Ops[/*5*/] = new Metadata /*P*/  [/*5*/] {Name, File, GetterName, SetterName, Type};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIObjCProperty(Context, Storage, Line, Attributes, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIObjCPropertys);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2189,
   FQN="llvm::DIObjCProperty::cloneImpl", NM="_ZNK4llvm14DIObjCProperty9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIObjCProperty /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIObjCProperty.getTemporary(getContext(), getName(), getFile(), getLine(),
        getGetterName(), getSetterName(), getAttributes(),
        getType());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2196,
   FQN="llvm::DIObjCProperty::get", NM="_ZN4llvm14DIObjCProperty3getERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty3getERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static DIObjCProperty /*P*/ get(final LLVMContext /*&*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, StringRef GetterName, StringRef SetterName, /*uint*/int Attributes, TypedDINodeRef<DIType> Type) {
    return DIObjCProperty.getImpl(Context, new StringRef(Name), File, Line, new StringRef(GetterName), new StringRef(SetterName), Attributes, new TypedDINodeRef<DIType>(Type), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2196,
   FQN="llvm::DIObjCProperty::getIfExists", NM="_ZN4llvm14DIObjCProperty11getIfExistsERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty11getIfExistsERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static DIObjCProperty /*P*/ getIfExists(final LLVMContext /*&*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, StringRef GetterName, StringRef SetterName, /*uint*/int Attributes, TypedDINodeRef<DIType> Type) {
    return DIObjCProperty.getImpl(Context, new StringRef(Name), File, Line, new StringRef(GetterName), new StringRef(SetterName), Attributes, new TypedDINodeRef<DIType>(Type), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2196,
   FQN="llvm::DIObjCProperty::getDistinct", NM="_ZN4llvm14DIObjCProperty11getDistinctERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty11getDistinctERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static DIObjCProperty /*P*/ getDistinct(final LLVMContext /*&*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, StringRef GetterName, StringRef SetterName, /*uint*/int Attributes, TypedDINodeRef<DIType> Type) {
    return DIObjCProperty.getImpl(Context, new StringRef(Name), File, Line, new StringRef(GetterName), new StringRef(SetterName), Attributes, new TypedDINodeRef<DIType>(Type), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2196,
   FQN="llvm::DIObjCProperty::getTemporary", NM="_ZN4llvm14DIObjCProperty12getTemporaryERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty12getTemporaryERNS_11LLVMContextENS_9StringRefEPNS_6DIFileEjS3_S3_jNS_14TypedDINodeRefINS_6DITypeEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIObjCProperty /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, StringRef Name, DIFile /*P*/ File, /*uint*/int Line, StringRef GetterName, StringRef SetterName, /*uint*/int Attributes, TypedDINodeRef<DIType> Type) {
    return new std.unique_ptr_with_deleter<DIObjCProperty /*, TempMDNodeDeleter*/>(DIObjCProperty.getImpl(Context, new StringRef(Name), File, Line, new StringRef(GetterName), new StringRef(SetterName), Attributes, new TypedDINodeRef<DIType>(Type), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2202,
   FQN="llvm::DIObjCProperty::get", NM="_ZN4llvm14DIObjCProperty3getERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty3getERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_")
  //</editor-fold>
  public static DIObjCProperty /*P*/ get(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, MDString /*P*/ GetterName, MDString /*P*/ SetterName, /*uint*/int Attributes, Metadata /*P*/ Type) {
    return getImpl(Context, Name, File, Line, GetterName, SetterName, Attributes, Type, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2202,
   FQN="llvm::DIObjCProperty::getIfExists", NM="_ZN4llvm14DIObjCProperty11getIfExistsERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty11getIfExistsERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_")
  //</editor-fold>
  public static DIObjCProperty /*P*/ getIfExists(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, MDString /*P*/ GetterName, MDString /*P*/ SetterName, /*uint*/int Attributes, Metadata /*P*/ Type) {
    return getImpl(Context, Name, File, Line, GetterName, SetterName, Attributes, Type, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2202,
   FQN="llvm::DIObjCProperty::getDistinct", NM="_ZN4llvm14DIObjCProperty11getDistinctERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty11getDistinctERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_")
  //</editor-fold>
  public static DIObjCProperty /*P*/ getDistinct(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, MDString /*P*/ GetterName, MDString /*P*/ SetterName, /*uint*/int Attributes, Metadata /*P*/ Type) {
    return getImpl(Context, Name, File, Line, GetterName, SetterName, Attributes, Type, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2202,
   FQN="llvm::DIObjCProperty::getTemporary", NM="_ZN4llvm14DIObjCProperty12getTemporaryERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty12getTemporaryERNS_11LLVMContextEPNS_8MDStringEPNS_8MetadataEjS4_S4_jS6_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIObjCProperty /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line, MDString /*P*/ GetterName, MDString /*P*/ SetterName, /*uint*/int Attributes, Metadata /*P*/ Type) {
    return new std.unique_ptr_with_deleter<DIObjCProperty /*, TempMDNodeDeleter*/>(getImpl(Context, Name, File, Line, GetterName, SetterName, Attributes, Type, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2209,
   FQN="llvm::DIObjCProperty::clone", NM="_ZNK4llvm14DIObjCProperty5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIObjCProperty /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2211,
   FQN="llvm::DIObjCProperty::getLine", NM="_ZNK4llvm14DIObjCProperty7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2212,
   FQN="llvm::DIObjCProperty::getAttributes", NM="_ZNK4llvm14DIObjCProperty13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty13getAttributesEv")
  //</editor-fold>
  public /*uint*/int getAttributes() /*const*/ {
    return Attributes;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2213,
   FQN="llvm::DIObjCProperty::getName", NM="_ZNK4llvm14DIObjCProperty7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2214,
   FQN="llvm::DIObjCProperty::getFile", NM="_ZNK4llvm14DIObjCProperty7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty7getFileEv")
  //</editor-fold>
  public DIFile /*P*/ getFile() /*const*/ {
    return cast_or_null_DIFile(getRawFile());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getGetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2215,
   FQN="llvm::DIObjCProperty::getGetterName", NM="_ZNK4llvm14DIObjCProperty13getGetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty13getGetterNameEv")
  //</editor-fold>
  public StringRef getGetterName() /*const*/ {
    return getStringOperand(2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2216,
   FQN="llvm::DIObjCProperty::getSetterName", NM="_ZNK4llvm14DIObjCProperty13getSetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty13getSetterNameEv")
  //</editor-fold>
  public StringRef getSetterName() /*const*/ {
    return getStringOperand(3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2217,
   FQN="llvm::DIObjCProperty::getType", NM="_ZNK4llvm14DIObjCProperty7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty7getTypeEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getType() /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, getRawType());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2219,
   FQN="llvm::DIObjCProperty::getFilename", NM="_ZNK4llvm14DIObjCProperty11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty11getFilenameEv")
  //</editor-fold>
  public StringRef getFilename() /*const*/ {
    {
      DIFile /*P*/ F = getFile();
      if ((F != null)) {
        return F.getFilename();
      }
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2224,
   FQN="llvm::DIObjCProperty::getDirectory", NM="_ZNK4llvm14DIObjCProperty12getDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty12getDirectoryEv")
  //</editor-fold>
  public StringRef getDirectory() /*const*/ {
    {
      DIFile /*P*/ F = getFile();
      if ((F != null)) {
        return F.getDirectory();
      }
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2230,
   FQN="llvm::DIObjCProperty::getRawName", NM="_ZNK4llvm14DIObjCProperty10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getRawFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2231,
   FQN="llvm::DIObjCProperty::getRawFile", NM="_ZNK4llvm14DIObjCProperty10getRawFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty10getRawFileEv")
  //</editor-fold>
  public Metadata /*P*/ getRawFile() /*const*/ {
    return getOperand(1).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getRawGetterName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2232,
   FQN="llvm::DIObjCProperty::getRawGetterName", NM="_ZNK4llvm14DIObjCProperty16getRawGetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty16getRawGetterNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawGetterName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getRawSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2233,
   FQN="llvm::DIObjCProperty::getRawSetterName", NM="_ZNK4llvm14DIObjCProperty16getRawSetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty16getRawSetterNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawSetterName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::getRawType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2234,
   FQN="llvm::DIObjCProperty::getRawType", NM="_ZNK4llvm14DIObjCProperty10getRawTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DIObjCProperty10getRawTypeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawType() /*const*/ {
    return getOperand(4).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIObjCProperty::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2236,
   FQN="llvm::DIObjCProperty::classof", NM="_ZN4llvm14DIObjCProperty7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DIObjCProperty7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIObjCPropertyKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", Attributes=" + Attributes // NOI18N
              + super.toString(); // NOI18N
  }
}
