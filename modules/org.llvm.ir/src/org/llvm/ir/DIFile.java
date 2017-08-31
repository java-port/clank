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


/// \brief File.
///
/// TODO: Merge with directory/file node (including users).
/// TODO: Canonicalize paths on creation.
//<editor-fold defaultstate="collapsed" desc="llvm::DIFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 450,
 FQN="llvm::DIFile", NM="_ZN4llvm6DIFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFileE")
//</editor-fold>
public class DIFile extends /*public*/ DIScope implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::DIFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 454,
   FQN="llvm::DIFile::DIFile", NM="_ZN4llvm6DIFileC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFileC1ERNS_11LLVMContextENS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIFile(final LLVMContext /*&*/ C, Metadata.StorageType Storage, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIScope(C, DIFileKind, Storage, dwarf::DW_TAG_file_type, Ops)
    //START JInit
    super(C, MetadataKind.DIFileKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_file_type), new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::~DIFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 456,
   FQN="llvm::DIFile::~DIFile", NM="_ZN4llvm6DIFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6DIFileD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 458,
   FQN="llvm::DIFile::getImpl", NM="_ZN4llvm6DIFile7getImplERNS_11LLVMContextENS_9StringRefES3_NS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile7getImplERNS_11LLVMContextENS_9StringRefES3_NS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIFile /*P*/ getImpl(final LLVMContext /*&*/ Context, StringRef Filename,
         StringRef Directory, Metadata.StorageType Storage) {
    return getImpl(Context, Filename,
         Directory, Storage,
         true);
  }
  private static DIFile /*P*/ getImpl(final LLVMContext /*&*/ Context, StringRef Filename,
         StringRef Directory, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, DINode.getCanonicalMDString(Context, new StringRef(Filename)),
        DINode.getCanonicalMDString(Context, new StringRef(Directory)), Storage,
        ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 348,
   FQN="llvm::DIFile::getImpl", NM="_ZN4llvm6DIFile7getImplERNS_11LLVMContextEPNS_8MDStringES4_NS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile7getImplERNS_11LLVMContextEPNS_8MDStringES4_NS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIFile /*P*/ getImpl(final LLVMContext /*&*/ Context, MDString /*P*/ Filename,
         MDString /*P*/ Directory, Metadata.StorageType Storage) {
    return getImpl(Context, Filename,
         Directory, Storage,
         true);
  }
  private static DIFile /*P*/ getImpl(final LLVMContext /*&*/ Context, MDString /*P*/ Filename,
         MDString /*P*/ Directory, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Filename)) : "Expected canonical MDString";
    assert (DebugInfoMetadataStatics.isCanonical(Directory)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIFile /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIFiles, new MDNodeKeyImplDIFile(Filename, Directory));
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
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {Filename, Directory};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIFile(Context, Storage, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIFiles);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 469,
   FQN="llvm::DIFile::cloneImpl", NM="_ZNK4llvm6DIFile9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIFile9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIFile /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIFile.getTemporary(getContext(), getFilename(), getDirectory());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 474,
   FQN="llvm::DIFile::get", NM="_ZN4llvm6DIFile3getERNS_11LLVMContextENS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile3getERNS_11LLVMContextENS_9StringRefES3_")
  //</editor-fold>
  public static DIFile /*P*/ get(final LLVMContext /*&*/ Context, StringRef Filename, StringRef Directory) {
    return DIFile.getImpl(Context, new StringRef(Filename), new StringRef(Directory), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 474,
   FQN="llvm::DIFile::getIfExists", NM="_ZN4llvm6DIFile11getIfExistsERNS_11LLVMContextENS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile11getIfExistsERNS_11LLVMContextENS_9StringRefES3_")
  //</editor-fold>
  public static DIFile /*P*/ getIfExists(final LLVMContext /*&*/ Context, StringRef Filename, StringRef Directory) {
    return DIFile.getImpl(Context, new StringRef(Filename), new StringRef(Directory), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 474,
   FQN="llvm::DIFile::getDistinct", NM="_ZN4llvm6DIFile11getDistinctERNS_11LLVMContextENS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile11getDistinctERNS_11LLVMContextENS_9StringRefES3_")
  //</editor-fold>
  public static DIFile /*P*/ getDistinct(final LLVMContext /*&*/ Context, StringRef Filename, StringRef Directory) {
    return DIFile.getImpl(Context, new StringRef(Filename), new StringRef(Directory), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 474,
   FQN="llvm::DIFile::getTemporary", NM="_ZN4llvm6DIFile12getTemporaryERNS_11LLVMContextENS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile12getTemporaryERNS_11LLVMContextENS_9StringRefES3_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIFile /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, StringRef Filename, StringRef Directory) {
    return new std.unique_ptr_with_deleter<DIFile /*, TempMDNodeDeleter*/>(DIFile.getImpl(Context, new StringRef(Filename), new StringRef(Directory), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 476,
   FQN="llvm::DIFile::get", NM="_ZN4llvm6DIFile3getERNS_11LLVMContextEPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile3getERNS_11LLVMContextEPNS_8MDStringES4_")
  //</editor-fold>
  public static DIFile /*P*/ get(final LLVMContext /*&*/ Context, MDString /*P*/ Filename, MDString /*P*/ Directory) {
    return getImpl(Context, Filename, Directory, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 476,
   FQN="llvm::DIFile::getIfExists", NM="_ZN4llvm6DIFile11getIfExistsERNS_11LLVMContextEPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile11getIfExistsERNS_11LLVMContextEPNS_8MDStringES4_")
  //</editor-fold>
  public static DIFile /*P*/ getIfExists(final LLVMContext /*&*/ Context, MDString /*P*/ Filename, MDString /*P*/ Directory) {
    return getImpl(Context, Filename, Directory, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 476,
   FQN="llvm::DIFile::getDistinct", NM="_ZN4llvm6DIFile11getDistinctERNS_11LLVMContextEPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile11getDistinctERNS_11LLVMContextEPNS_8MDStringES4_")
  //</editor-fold>
  public static DIFile /*P*/ getDistinct(final LLVMContext /*&*/ Context, MDString /*P*/ Filename, MDString /*P*/ Directory) {
    return getImpl(Context, Filename, Directory, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 476,
   FQN="llvm::DIFile::getTemporary", NM="_ZN4llvm6DIFile12getTemporaryERNS_11LLVMContextEPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile12getTemporaryERNS_11LLVMContextEPNS_8MDStringES4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIFile /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, MDString /*P*/ Filename, MDString /*P*/ Directory) {
    return new std.unique_ptr_with_deleter<DIFile /*, TempMDNodeDeleter*/>(getImpl(Context, Filename, Directory, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 479,
   FQN="llvm::DIFile::clone", NM="_ZNK4llvm6DIFile5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIFile5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIFile /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 481,
   FQN="llvm::DIFile::getFilename", NM="_ZNK4llvm6DIFile11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIFile11getFilenameEv")
  //</editor-fold>
  public StringRef getFilename() /*const*/ {
    return getStringOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 482,
   FQN="llvm::DIFile::getDirectory", NM="_ZNK4llvm6DIFile12getDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIFile12getDirectoryEv")
  //</editor-fold>
  public StringRef getDirectory() /*const*/ {
    return getStringOperand(1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getRawFilename">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 484,
   FQN="llvm::DIFile::getRawFilename", NM="_ZNK4llvm6DIFile14getRawFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIFile14getRawFilenameEv")
  //</editor-fold>
  public MDString /*P*/ getRawFilename() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::getRawDirectory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 485,
   FQN="llvm::DIFile::getRawDirectory", NM="_ZNK4llvm6DIFile15getRawDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIFile15getRawDirectoryEv")
  //</editor-fold>
  public MDString /*P*/ getRawDirectory() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIFile::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 487,
   FQN="llvm::DIFile::classof", NM="_ZN4llvm6DIFile7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIFile7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIFileKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
