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
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief An imported module (C++ using directive or similar).
//<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2242,
 FQN="llvm::DIImportedEntity", NM="_ZN4llvm16DIImportedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntityE")
//</editor-fold>
public class DIImportedEntity extends /*public*/ DINode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::DIImportedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2248,
   FQN="llvm::DIImportedEntity::DIImportedEntity", NM="_ZN4llvm16DIImportedEntityC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntityC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIImportedEntity(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Tag,
      /*uint*/int Line, ArrayRef<Metadata /*P*/ > Ops) {
    // : DINode(C, DIImportedEntityKind, Storage, Tag, Ops), Line(Line)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DIImportedEntityKind.getValue(), Storage, Tag, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::~DIImportedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2251,
   FQN="llvm::DIImportedEntity::~DIImportedEntity", NM="_ZN4llvm16DIImportedEntityD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16DIImportedEntityD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2253,
   FQN="llvm::DIImportedEntity::getImpl", NM="_ZN4llvm16DIImportedEntity7getImplERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity7getImplERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIImportedEntity /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity,
         /*uint*/int Line, StringRef Name,
         Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Scope, Entity,
         Line, Name,
         Storage,
         true);
  }
  private static DIImportedEntity /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity,
         /*uint*/int Line, StringRef Name,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return DIImportedEntity.getImpl(Context, Tag, Scope, Entity.$Metadata$P(), Line,
        DINode.getCanonicalMDString(Context, new StringRef(Name)), Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 616,
   FQN="llvm::DIImportedEntity::getImpl", NM="_ZN4llvm16DIImportedEntity7getImplERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringENS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity7getImplERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringENS3_11StorageTypeEb")
  //</editor-fold>
  private static DIImportedEntity /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         Metadata /*P*/ Scope, Metadata /*P*/ Entity,
         /*uint*/int Line, MDString /*P*/ Name,
         Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Scope, Entity,
         Line, Name,
         Storage,
         true);
  }
  private static DIImportedEntity /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         Metadata /*P*/ Scope, Metadata /*P*/ Entity,
         /*uint*/int Line, MDString /*P*/ Name,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIImportedEntity /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIImportedEntitys, new MDNodeKeyImplDIImportedEntity(Tag, Scope, Entity, Line, Name));
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
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {Scope, Entity, Name};
    return MDNode.storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIImportedEntity(Context, Storage, Tag, Line, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIImportedEntitys);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2267,
   FQN="llvm::DIImportedEntity::cloneImpl", NM="_ZNK4llvm16DIImportedEntity9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIImportedEntity.getTemporary(getContext(), getTag(), getScope(), getEntity(),
        getLine(), getName());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2273,
   FQN="llvm::DIImportedEntity::get", NM="_ZN4llvm16DIImportedEntity3getERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity3getERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE")
  //</editor-fold>
  public static DIImportedEntity /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line) {
    return get(Context, Tag, Scope, Entity, Line, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DIImportedEntity /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line, StringRef Name/*= ""*/) {
    return DIImportedEntity.getImpl(Context, Tag, Scope, new TypedDINodeRef<DINode>(Entity), Line, new StringRef(Name), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2273,
   FQN="llvm::DIImportedEntity::getIfExists", NM="_ZN4llvm16DIImportedEntity11getIfExistsERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity11getIfExistsERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE")
  //</editor-fold>
  public static DIImportedEntity /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line) {
    return getIfExists(Context, Tag, Scope, Entity, Line, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DIImportedEntity /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line, StringRef Name/*= ""*/) {
    return DIImportedEntity.getImpl(Context, Tag, Scope, new TypedDINodeRef<DINode>(Entity), Line, new StringRef(Name), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2273,
   FQN="llvm::DIImportedEntity::getDistinct", NM="_ZN4llvm16DIImportedEntity11getDistinctERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity11getDistinctERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE")
  //</editor-fold>
  public static DIImportedEntity /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line) {
    return getDistinct(Context, Tag, Scope, Entity, Line, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DIImportedEntity /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line, StringRef Name/*= ""*/) {
    return DIImportedEntity.getImpl(Context, Tag, Scope, new TypedDINodeRef<DINode>(Entity), Line, new StringRef(Name), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2273,
   FQN="llvm::DIImportedEntity::getTemporary", NM="_ZN4llvm16DIImportedEntity12getTemporaryERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity12getTemporaryERNS_11LLVMContextEjPNS_7DIScopeENS_14TypedDINodeRefINS_6DINodeEEEjNS_9StringRefE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line) {
    return getTemporary(Context, Tag, Scope, Entity, Line, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, DIScope /*P*/ Scope, TypedDINodeRef<DINode> Entity, /*uint*/int Line, StringRef Name/*= ""*/) {
    return new std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/>(DIImportedEntity.getImpl(Context, Tag, Scope, new TypedDINodeRef<DINode>(Entity), Line, new StringRef(Name), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2277,
   FQN="llvm::DIImportedEntity::get", NM="_ZN4llvm16DIImportedEntity3getERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity3getERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE")
  //</editor-fold>
  public static DIImportedEntity /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, Metadata /*P*/ Scope, Metadata /*P*/ Entity, /*uint*/int Line, MDString /*P*/ Name) {
    return getImpl(Context, Tag, Scope, Entity, Line, Name, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2277,
   FQN="llvm::DIImportedEntity::getIfExists", NM="_ZN4llvm16DIImportedEntity11getIfExistsERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity11getIfExistsERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE")
  //</editor-fold>
  public static DIImportedEntity /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, Metadata /*P*/ Scope, Metadata /*P*/ Entity, /*uint*/int Line, MDString /*P*/ Name) {
    return getImpl(Context, Tag, Scope, Entity, Line, Name, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2277,
   FQN="llvm::DIImportedEntity::getDistinct", NM="_ZN4llvm16DIImportedEntity11getDistinctERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity11getDistinctERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE")
  //</editor-fold>
  public static DIImportedEntity /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, Metadata /*P*/ Scope, Metadata /*P*/ Entity, /*uint*/int Line, MDString /*P*/ Name) {
    return getImpl(Context, Tag, Scope, Entity, Line, Name, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2277,
   FQN="llvm::DIImportedEntity::getTemporary", NM="_ZN4llvm16DIImportedEntity12getTemporaryERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity12getTemporaryERNS_11LLVMContextEjPNS_8MetadataES4_jPNS_8MDStringE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, Metadata /*P*/ Scope, Metadata /*P*/ Entity, /*uint*/int Line, MDString /*P*/ Name) {
    return new std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/>(getImpl(Context, Tag, Scope, Entity, Line, Name, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2282,
   FQN="llvm::DIImportedEntity::clone", NM="_ZNK4llvm16DIImportedEntity5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIImportedEntity /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2284,
   FQN="llvm::DIImportedEntity::getLine", NM="_ZNK4llvm16DIImportedEntity7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2285,
   FQN="llvm::DIImportedEntity::getScope", NM="_ZNK4llvm16DIImportedEntity8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity8getScopeEv")
  //</editor-fold>
  public DIScope /*P*/ getScope() /*const*/ {
    return cast_or_null_DIScope(getRawScope());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2286,
   FQN="llvm::DIImportedEntity::getEntity", NM="_ZNK4llvm16DIImportedEntity9getEntityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity9getEntityEv")
  //</editor-fold>
  public TypedDINodeRef<DINode> getEntity() /*const*/ {
    return new TypedDINodeRef<DINode>(DINode.class, getRawEntity());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2287,
   FQN="llvm::DIImportedEntity::getName", NM="_ZNK4llvm16DIImportedEntity7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2289,
   FQN="llvm::DIImportedEntity::getRawScope", NM="_ZNK4llvm16DIImportedEntity11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(0).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getRawEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2290,
   FQN="llvm::DIImportedEntity::getRawEntity", NM="_ZNK4llvm16DIImportedEntity12getRawEntityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity12getRawEntityEv")
  //</editor-fold>
  public Metadata /*P*/ getRawEntity() /*const*/ {
    return getOperand(1).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2291,
   FQN="llvm::DIImportedEntity::getRawName", NM="_ZNK4llvm16DIImportedEntity10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm16DIImportedEntity10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIImportedEntity::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2293,
   FQN="llvm::DIImportedEntity::classof", NM="_ZN4llvm16DIImportedEntity7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm16DIImportedEntity7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIImportedEntityKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + super.toString(); // NOI18N
  }
}
