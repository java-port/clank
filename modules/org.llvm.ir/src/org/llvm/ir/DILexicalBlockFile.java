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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1541,
 FQN="llvm::DILexicalBlockFile", NM="_ZN4llvm18DILexicalBlockFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFileE")
//</editor-fold>
public class DILexicalBlockFile extends /*public*/ DILexicalBlockBase implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Discriminator;

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::DILexicalBlockFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1547,
   FQN="llvm::DILexicalBlockFile::DILexicalBlockFile", NM="_ZN4llvm18DILexicalBlockFileC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFileC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DILexicalBlockFile(final LLVMContext /*&*/ C, Metadata.StorageType Storage,
      /*uint*/int Discriminator, ArrayRef<Metadata /*P*/ > Ops) {
    // : DILexicalBlockBase(C, DILexicalBlockFileKind, Storage, Ops), Discriminator(Discriminator)
    //START JInit
    super(C, MetadataKind.DILexicalBlockFileKind.getValue(), Storage, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Discriminator = Discriminator;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::~DILexicalBlockFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1551,
   FQN="llvm::DILexicalBlockFile::~DILexicalBlockFile", NM="_ZN4llvm18DILexicalBlockFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm18DILexicalBlockFileD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1553,
   FQN="llvm::DILexicalBlockFile::getImpl", NM="_ZN4llvm18DILexicalBlockFile7getImplERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile7getImplERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DILexicalBlockFile /*P*/ getImpl(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope,
         DIFile /*P*/ File, /*uint*/int Discriminator,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         File, Discriminator,
         Storage,
         true);
  }
  private static DILexicalBlockFile /*P*/ getImpl(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope,
         DIFile /*P*/ File, /*uint*/int Discriminator,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, ((/*static_cast*/Metadata /*P*/ )(Scope)),
        ((/*static_cast*/Metadata /*P*/ )(File)), Discriminator, Storage,
        ShouldCreate);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 457,
   FQN="llvm::DILexicalBlockFile::getImpl", NM="_ZN4llvm18DILexicalBlockFile7getImplERNS_11LLVMContextEPNS_8MetadataES4_jNS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile7getImplERNS_11LLVMContextEPNS_8MetadataES4_jNS3_11StorageTypeEb")
  //</editor-fold>
  private static DILexicalBlockFile /*P*/ getImpl(final LLVMContext /*&*/ Context,
         Metadata /*P*/ Scope, Metadata /*P*/ File,
         /*uint*/int Discriminator,
         Metadata.StorageType Storage) {
    return getImpl(Context,
         Scope, File,
         Discriminator,
         Storage,
         true);
  }
  private static DILexicalBlockFile /*P*/ getImpl(final LLVMContext /*&*/ Context,
         Metadata /*P*/ Scope, Metadata /*P*/ File,
         /*uint*/int Discriminator,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    assert ((Scope != null)) : "Expected scope";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DILexicalBlockFile /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DILexicalBlockFiles, new MDNodeKeyImplDILexicalBlockFile(Scope, File, Discriminator));
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
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {File, Scope};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DILexicalBlockFile(Context, Storage, Discriminator, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DILexicalBlockFiles);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1567,
   FQN="llvm::DILexicalBlockFile::cloneImpl", NM="_ZNK4llvm18DILexicalBlockFile9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockFile9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DILexicalBlockFile /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DILexicalBlockFile.getTemporary(getContext(), getScope(), getFile(),
        getDiscriminator());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1573,
   FQN="llvm::DILexicalBlockFile::get", NM="_ZN4llvm18DILexicalBlockFile3getERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile3getERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj")
  //</editor-fold>
  public static DILexicalBlockFile /*P*/ get(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Discriminator) {
    return DILexicalBlockFile.getImpl(Context, Scope, File, Discriminator, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1573,
   FQN="llvm::DILexicalBlockFile::getIfExists", NM="_ZN4llvm18DILexicalBlockFile11getIfExistsERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile11getIfExistsERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj")
  //</editor-fold>
  public static DILexicalBlockFile /*P*/ getIfExists(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Discriminator) {
    return DILexicalBlockFile.getImpl(Context, Scope, File, Discriminator, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1573,
   FQN="llvm::DILexicalBlockFile::getDistinct", NM="_ZN4llvm18DILexicalBlockFile11getDistinctERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile11getDistinctERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj")
  //</editor-fold>
  public static DILexicalBlockFile /*P*/ getDistinct(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Discriminator) {
    return DILexicalBlockFile.getImpl(Context, Scope, File, Discriminator, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1573,
   FQN="llvm::DILexicalBlockFile::getTemporary", NM="_ZN4llvm18DILexicalBlockFile12getTemporaryERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile12getTemporaryERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILexicalBlockFile /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Discriminator) {
    return new std.unique_ptr_with_deleter<DILexicalBlockFile /*, TempMDNodeDeleter*/>(DILexicalBlockFile.getImpl(Context, Scope, File, Discriminator, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1576,
   FQN="llvm::DILexicalBlockFile::get", NM="_ZN4llvm18DILexicalBlockFile3getERNS_11LLVMContextEPNS_8MetadataES4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile3getERNS_11LLVMContextEPNS_8MetadataES4_j")
  //</editor-fold>
  public static DILexicalBlockFile /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Discriminator) {
    return getImpl(Context, Scope, File, Discriminator, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1576,
   FQN="llvm::DILexicalBlockFile::getIfExists", NM="_ZN4llvm18DILexicalBlockFile11getIfExistsERNS_11LLVMContextEPNS_8MetadataES4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile11getIfExistsERNS_11LLVMContextEPNS_8MetadataES4_j")
  //</editor-fold>
  public static DILexicalBlockFile /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Discriminator) {
    return getImpl(Context, Scope, File, Discriminator, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1576,
   FQN="llvm::DILexicalBlockFile::getDistinct", NM="_ZN4llvm18DILexicalBlockFile11getDistinctERNS_11LLVMContextEPNS_8MetadataES4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile11getDistinctERNS_11LLVMContextEPNS_8MetadataES4_j")
  //</editor-fold>
  public static DILexicalBlockFile /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Discriminator) {
    return getImpl(Context, Scope, File, Discriminator, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1576,
   FQN="llvm::DILexicalBlockFile::getTemporary", NM="_ZN4llvm18DILexicalBlockFile12getTemporaryERNS_11LLVMContextEPNS_8MetadataES4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile12getTemporaryERNS_11LLVMContextEPNS_8MetadataES4_j")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILexicalBlockFile /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Discriminator) {
    return new std.unique_ptr_with_deleter<DILexicalBlockFile /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, File, Discriminator, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1580,
   FQN="llvm::DILexicalBlockFile::clone", NM="_ZNK4llvm18DILexicalBlockFile5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockFile5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DILexicalBlockFile /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  // TODO: Remove these once they're gone from DILexicalBlockBase.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1583,
   FQN="llvm::DILexicalBlockFile::getLine", NM="_ZNK4llvm18DILexicalBlockFile7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockFile7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1584,
   FQN="llvm::DILexicalBlockFile::getColumn", NM="_ZNK4llvm18DILexicalBlockFile9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockFile9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() /*const*/ { throw new UnsupportedOperationException("Deleted");}


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::getDiscriminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1586,
   FQN="llvm::DILexicalBlockFile::getDiscriminator", NM="_ZNK4llvm18DILexicalBlockFile16getDiscriminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm18DILexicalBlockFile16getDiscriminatorEv")
  //</editor-fold>
  public /*uint*/int getDiscriminator() /*const*/ {
    return Discriminator;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlockFile::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1588,
   FQN="llvm::DILexicalBlockFile::classof", NM="_ZN4llvm18DILexicalBlockFile7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm18DILexicalBlockFile7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DILexicalBlockFileKind.getValue();
  }


  @Override public String toString() {
    return "" + "Discriminator=" + Discriminator // NOI18N
              + super.toString(); // NOI18N
  }
}
