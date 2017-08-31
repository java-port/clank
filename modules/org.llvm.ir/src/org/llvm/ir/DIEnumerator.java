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


/// \brief Enumeration value.
///
/// TODO: Add a pointer to the context (DW_TAG_enumeration_type) once that no
/// longer creates a type cycle.
//<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 349,
 FQN="llvm::DIEnumerator", NM="_ZN4llvm12DIEnumeratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumeratorE")
//</editor-fold>
public class DIEnumerator extends /*public*/ DINode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private long/*int64_t*/ Value;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::DIEnumerator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 355,
   FQN="llvm::DIEnumerator::DIEnumerator", NM="_ZN4llvm12DIEnumeratorC1ERNS_11LLVMContextENS_8Metadata11StorageTypeExNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumeratorC1ERNS_11LLVMContextENS_8Metadata11StorageTypeExNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIEnumerator(final LLVMContext /*&*/ C, Metadata.StorageType Storage, long/*int64_t*/ Value,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DINode(C, DIEnumeratorKind, Storage, dwarf::DW_TAG_enumerator, Ops), Value(Value)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DIEnumeratorKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_enumerator), new ArrayRef<Metadata /*P*/ >(Ops));
    this.Value = Value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::~DIEnumerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 359,
   FQN="llvm::DIEnumerator::~DIEnumerator", NM="_ZN4llvm12DIEnumeratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12DIEnumeratorD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 361,
   FQN="llvm::DIEnumerator::getImpl", NM="_ZN4llvm12DIEnumerator7getImplERNS_11LLVMContextExNS_9StringRefENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator7getImplERNS_11LLVMContextExNS_9StringRefENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIEnumerator /*P*/ getImpl(final LLVMContext /*&*/ Context, long/*int64_t*/ Value,
         StringRef Name, Metadata.StorageType Storage) {
    return getImpl(Context, Value,
         Name, Storage,
         true);
  }
  private static DIEnumerator /*P*/ getImpl(final LLVMContext /*&*/ Context, long/*int64_t*/ Value,
         StringRef Name, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Value, DINode.getCanonicalMDString(Context, new StringRef(Name)), Storage,
        ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 221,
   FQN="llvm::DIEnumerator::getImpl", NM="_ZN4llvm12DIEnumerator7getImplERNS_11LLVMContextExPNS_8MDStringENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator7getImplERNS_11LLVMContextExPNS_8MDStringENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIEnumerator /*P*/ getImpl(final LLVMContext /*&*/ Context, long/*int64_t*/ Value,
         MDString /*P*/ Name, Metadata.StorageType Storage) {
    return getImpl(Context, Value,
         Name, Storage,
         true);
  }
  private static DIEnumerator /*P*/ getImpl(final LLVMContext /*&*/ Context, long/*int64_t*/ Value,
         MDString /*P*/ Name, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIEnumerator /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIEnumerators, new MDNodeKeyImplDIEnumerator(Value, Name));
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
    Metadata /*P*/ Ops[/*1*/] = new Metadata /*P*/  [/*1*/] {Name};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIEnumerator(Context, Storage, Value, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIEnumerators);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 371,
   FQN="llvm::DIEnumerator::cloneImpl", NM="_ZNK4llvm12DIEnumerator9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIEnumerator9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIEnumerator /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIEnumerator.getTemporary(getContext(), getValue(), getName());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 376,
   FQN="llvm::DIEnumerator::get", NM="_ZN4llvm12DIEnumerator3getERNS_11LLVMContextExNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator3getERNS_11LLVMContextExNS_9StringRefE")
  //</editor-fold>
  public static DIEnumerator /*P*/ get(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, StringRef Name) {
    return DIEnumerator.getImpl(Context, Value, new StringRef(Name), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 376,
   FQN="llvm::DIEnumerator::getIfExists", NM="_ZN4llvm12DIEnumerator11getIfExistsERNS_11LLVMContextExNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator11getIfExistsERNS_11LLVMContextExNS_9StringRefE")
  //</editor-fold>
  public static DIEnumerator /*P*/ getIfExists(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, StringRef Name) {
    return DIEnumerator.getImpl(Context, Value, new StringRef(Name), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 376,
   FQN="llvm::DIEnumerator::getDistinct", NM="_ZN4llvm12DIEnumerator11getDistinctERNS_11LLVMContextExNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator11getDistinctERNS_11LLVMContextExNS_9StringRefE")
  //</editor-fold>
  public static DIEnumerator /*P*/ getDistinct(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, StringRef Name) {
    return DIEnumerator.getImpl(Context, Value, new StringRef(Name), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 376,
   FQN="llvm::DIEnumerator::getTemporary", NM="_ZN4llvm12DIEnumerator12getTemporaryERNS_11LLVMContextExNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator12getTemporaryERNS_11LLVMContextExNS_9StringRefE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIEnumerator /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, StringRef Name) {
    return new std.unique_ptr_with_deleter<DIEnumerator /*, TempMDNodeDeleter*/>(DIEnumerator.getImpl(Context, Value, new StringRef(Name), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 378,
   FQN="llvm::DIEnumerator::get", NM="_ZN4llvm12DIEnumerator3getERNS_11LLVMContextExPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator3getERNS_11LLVMContextExPNS_8MDStringE")
  //</editor-fold>
  public static DIEnumerator /*P*/ get(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, MDString /*P*/ Name) {
    return getImpl(Context, Value, Name, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 378,
   FQN="llvm::DIEnumerator::getIfExists", NM="_ZN4llvm12DIEnumerator11getIfExistsERNS_11LLVMContextExPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator11getIfExistsERNS_11LLVMContextExPNS_8MDStringE")
  //</editor-fold>
  public static DIEnumerator /*P*/ getIfExists(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, MDString /*P*/ Name) {
    return getImpl(Context, Value, Name, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 378,
   FQN="llvm::DIEnumerator::getDistinct", NM="_ZN4llvm12DIEnumerator11getDistinctERNS_11LLVMContextExPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator11getDistinctERNS_11LLVMContextExPNS_8MDStringE")
  //</editor-fold>
  public static DIEnumerator /*P*/ getDistinct(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, MDString /*P*/ Name) {
    return getImpl(Context, Value, Name, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 378,
   FQN="llvm::DIEnumerator::getTemporary", NM="_ZN4llvm12DIEnumerator12getTemporaryERNS_11LLVMContextExPNS_8MDStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator12getTemporaryERNS_11LLVMContextExPNS_8MDStringE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIEnumerator /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, long/*int64_t*/ Value, MDString /*P*/ Name) {
    return new std.unique_ptr_with_deleter<DIEnumerator /*, TempMDNodeDeleter*/>(getImpl(Context, Value, Name, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 381,
   FQN="llvm::DIEnumerator::clone", NM="_ZNK4llvm12DIEnumerator5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIEnumerator5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIEnumerator /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 383,
   FQN="llvm::DIEnumerator::getValue", NM="_ZNK4llvm12DIEnumerator8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIEnumerator8getValueEv")
  //</editor-fold>
  public long/*int64_t*/ getValue() /*const*/ {
    return Value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 384,
   FQN="llvm::DIEnumerator::getName", NM="_ZNK4llvm12DIEnumerator7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIEnumerator7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 386,
   FQN="llvm::DIEnumerator::getRawName", NM="_ZNK4llvm12DIEnumerator10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm12DIEnumerator10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIEnumerator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 388,
   FQN="llvm::DIEnumerator::classof", NM="_ZN4llvm12DIEnumerator7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm12DIEnumerator7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIEnumeratorKind.getValue();
  }


  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
