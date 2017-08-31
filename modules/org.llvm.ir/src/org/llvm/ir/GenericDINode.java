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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief Generic tagged DWARF-like metadata node.
///
/// An un-specialized DWARF-like metadata node.  The first operand is a
/// (possibly empty) null-separated \a MDString header that contains arbitrary
/// fields.  The remaining operands are \a dwarf_operands(), and are pointers
/// to other metadata.
//<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 238,
 FQN="llvm::GenericDINode", NM="_ZN4llvm13GenericDINodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINodeE")
//</editor-fold>
public class GenericDINode extends /*public*/ DINode implements MDTuple_or_GenericDINode, Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::GenericDINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 242,
   FQN="llvm::GenericDINode::GenericDINode", NM="_ZN4llvm13GenericDINodeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINodeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EES7_")
  //</editor-fold>
  private GenericDINode(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Hash,
      /*uint*/int Tag, ArrayRef<Metadata /*P*/ > Ops1,
      ArrayRef<Metadata /*P*/ > Ops2) {
    // : DINode(C, GenericDINodeKind, Storage, Tag, Ops1, Ops2)
    //START JInit
    super(C, MetadataKind.GenericDINodeKind.getValue(), Storage, Tag, new ArrayRef<Metadata /*P*/ >(Ops1), new ArrayRef<Metadata /*P*/ >(Ops2));
    //END JInit
    setHash(Hash);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::~GenericDINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 248,
   FQN="llvm::GenericDINode::~GenericDINode", NM="_ZN4llvm13GenericDINodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINodeD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() {
    dropAllReferences();
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::setHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 250,
   FQN="llvm::GenericDINode::setHash", NM="_ZN4llvm13GenericDINode7setHashEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode7setHashEj")
  //</editor-fold>
  /*friend*/public/*private*/ void setHash(/*uint*/int Hash) {
    SubclassData32 = Hash;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::recalculateHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 185,
   FQN="llvm::GenericDINode::recalculateHash", NM="_ZN4llvm13GenericDINode15recalculateHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode15recalculateHashEv")
  //</editor-fold>
  /*friend*/public/*private*/ void recalculateHash() {
    setHash(MDNodeKeyImplGenericDINode.<GenericDINode>calculateHash(this));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 253,
   FQN="llvm::GenericDINode::getImpl", NM="_ZN4llvm13GenericDINode7getImplERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEENS5_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode7getImplERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEENS5_11StorageTypeEb")
  //</editor-fold>
  private static GenericDINode /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Header, ArrayRef<Metadata /*P*/ > DwarfOps,
         Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Header, DwarfOps,
         Storage, true);
  }
  private static GenericDINode /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         StringRef Header, ArrayRef<Metadata /*P*/ > DwarfOps,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Tag, DINode.getCanonicalMDString(Context, new StringRef(Header)),
        new ArrayRef<Metadata /*P*/ >(DwarfOps), Storage, ShouldCreate);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 161,
   FQN="llvm::GenericDINode::getImpl", NM="_ZN4llvm13GenericDINode7getImplERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEENS6_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode7getImplERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEENS6_11StorageTypeEb")
  //</editor-fold>
  private static GenericDINode /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         MDString /*P*/ Header,
         ArrayRef<Metadata /*P*/ > DwarfOps,
         Metadata.StorageType Storage) {
    return getImpl(Context, Tag,
         Header,
         DwarfOps,
         Storage, true);
  }
  private static GenericDINode /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Tag,
         MDString /*P*/ Header,
         ArrayRef<Metadata /*P*/ > DwarfOps,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    /*uint*/int Hash = 0;
    if (Storage == StorageType.Uniqued) {
      MDNodeKeyImplGenericDINode Key/*J*/= new MDNodeKeyImplGenericDINode(Tag, Header, new ArrayRef<Metadata /*P*/ >(DwarfOps));
      {
        GenericDINode /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.GenericDINodes, Key);
        if ((N != null)) {
          return N;
        }
      }
      if (!ShouldCreate) {
        return null;
      }
      Hash = Key.getHash();
    } else {
      assert (ShouldCreate) : "Expected non-uniqued nodes to always be created";
    }

    // Use a nullptr for empty headers.
    assert (DebugInfoMetadataStatics.isCanonical(Header)) : "Expected canonical MDString";
    Metadata /*P*/ PreOps[/*1*/] = new Metadata /*P*/  [/*1*/] {Header};
    int $FinalHash = Hash;
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (DwarfOps.size() + 1)*/ MDNode.$new(DwarfOps.size() + 1, (type$ptr<?> New$Mem)->{
            return new GenericDINode(Context, Storage, $FinalHash, Tag, new ArrayRef<Metadata /*P*/ >(PreOps, true), new ArrayRef<Metadata /*P*/ >(DwarfOps));
         }),
        Storage, Context.pImpl.GenericDINodes);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 264,
   FQN="llvm::GenericDINode::cloneImpl", NM="_ZNK4llvm13GenericDINode9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<GenericDINode /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return GenericDINode.getTemporary(getContext(), getTag(), getHeader(),
        new ArrayRef<Metadata /*P*/ >(new SmallVector<Metadata /*P*/ >(JD$T.INSTANCE, 4, dwarf_op_begin(), dwarf_op_end(), (Metadata /*P*/ )null, (MDOperand M) -> M.$Metadata$P()), true));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 271,
   FQN="llvm::GenericDINode::getHash", NM="_ZNK4llvm13GenericDINode7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    return SubclassData32;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 273,
   FQN="llvm::GenericDINode::get", NM="_ZN4llvm13GenericDINode3getERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode3getERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static GenericDINode /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return GenericDINode.getImpl(Context, Tag, new StringRef(Header), new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 273,
   FQN="llvm::GenericDINode::getIfExists", NM="_ZN4llvm13GenericDINode11getIfExistsERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode11getIfExistsERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static GenericDINode /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return GenericDINode.getImpl(Context, Tag, new StringRef(Header), new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 273,
   FQN="llvm::GenericDINode::getDistinct", NM="_ZN4llvm13GenericDINode11getDistinctERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode11getDistinctERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static GenericDINode /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return GenericDINode.getImpl(Context, Tag, new StringRef(Header), new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 273,
   FQN="llvm::GenericDINode::getTemporary", NM="_ZN4llvm13GenericDINode12getTemporaryERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode12getTemporaryERNS_11LLVMContextEjNS_9StringRefENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<GenericDINode /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, StringRef Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return new std.unique_ptr_with_deleter<GenericDINode /*, TempMDNodeDeleter*/>(GenericDINode.getImpl(Context, Tag, new StringRef(Header), new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 276,
   FQN="llvm::GenericDINode::get", NM="_ZN4llvm13GenericDINode3getERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode3getERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static GenericDINode /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return getImpl(Context, Tag, Header, new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 276,
   FQN="llvm::GenericDINode::getIfExists", NM="_ZN4llvm13GenericDINode11getIfExistsERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode11getIfExistsERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static GenericDINode /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return getImpl(Context, Tag, Header, new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 276,
   FQN="llvm::GenericDINode::getDistinct", NM="_ZN4llvm13GenericDINode11getDistinctERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode11getDistinctERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static GenericDINode /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return getImpl(Context, Tag, Header, new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 276,
   FQN="llvm::GenericDINode::getTemporary", NM="_ZN4llvm13GenericDINode12getTemporaryERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode12getTemporaryERNS_11LLVMContextEjPNS_8MDStringENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<GenericDINode /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Tag, MDString /*P*/ Header, ArrayRef<Metadata /*P*/ > DwarfOps) {
    return new std.unique_ptr_with_deleter<GenericDINode /*, TempMDNodeDeleter*/>(getImpl(Context, Tag, Header, new ArrayRef<Metadata /*P*/ >(DwarfOps), StorageType.Temporary));
  }


  /// \brief Return a (temporary) clone of this.
  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 281,
   FQN="llvm::GenericDINode::clone", NM="_ZNK4llvm13GenericDINode5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<GenericDINode /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 283,
   FQN="llvm::GenericDINode::getTag", NM="_ZNK4llvm13GenericDINode6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode6getTagEv")
  //</editor-fold>
  public /*uint*/int getTag() /*const*/ {
    return $ushort2uint(SubclassData16);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 284,
   FQN="llvm::GenericDINode::getHeader", NM="_ZNK4llvm13GenericDINode9getHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode9getHeaderEv")
  //</editor-fold>
  public StringRef getHeader() /*const*/ {
    return getStringOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getRawHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 285,
   FQN="llvm::GenericDINode::getRawHeader", NM="_ZNK4llvm13GenericDINode12getRawHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode12getRawHeaderEv")
  //</editor-fold>
  public MDString /*P*/ getRawHeader() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::dwarf_op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 287,
   FQN="llvm::GenericDINode::dwarf_op_begin", NM="_ZNK4llvm13GenericDINode14dwarf_op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode14dwarf_op_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ MDOperand /*P*/ > dwarf_op_begin() /*const*/ {
    return op_begin().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::dwarf_op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 288,
   FQN="llvm::GenericDINode::dwarf_op_end", NM="_ZNK4llvm13GenericDINode12dwarf_op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode12dwarf_op_endEv")
  //</editor-fold>
  public type$ptr</*const*/ MDOperand /*P*/ > dwarf_op_end() /*const*/ {
    return op_end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::dwarf_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 289,
   FQN="llvm::GenericDINode::dwarf_operands", NM="_ZNK4llvm13GenericDINode14dwarf_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode14dwarf_operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ MDOperand> dwarf_operands() /*const*/ {
    return new iterator_range</*const*/ MDOperand>(dwarf_op_begin(), dwarf_op_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getNumDwarfOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 293,
   FQN="llvm::GenericDINode::getNumDwarfOperands", NM="_ZNK4llvm13GenericDINode19getNumDwarfOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode19getNumDwarfOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumDwarfOperands() /*const*/ {
    return getNumOperands() - 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::getDwarfOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 294,
   FQN="llvm::GenericDINode::getDwarfOperand", NM="_ZNK4llvm13GenericDINode15getDwarfOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm13GenericDINode15getDwarfOperandEj")
  //</editor-fold>
  public /*const*/ MDOperand /*&*/ getDwarfOperand(/*uint*/int I) /*const*/ {
    return getOperand(I + 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::replaceDwarfOperandWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 297,
   FQN="llvm::GenericDINode::replaceDwarfOperandWith", NM="_ZN4llvm13GenericDINode23replaceDwarfOperandWithEjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode23replaceDwarfOperandWithEjPNS_8MetadataE")
  //</editor-fold>
  public void replaceDwarfOperandWith(/*uint*/int I, Metadata /*P*/ New) {
    replaceOperandWith(I + 1, New);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GenericDINode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 301,
   FQN="llvm::GenericDINode::classof", NM="_ZN4llvm13GenericDINode7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm13GenericDINode7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.GenericDINodeKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
