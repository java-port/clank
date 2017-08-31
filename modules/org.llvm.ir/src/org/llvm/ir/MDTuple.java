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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
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


/// \brief Tuple of metadata.
///
/// This is the simple \a MDNode arbitrary tuple.  Nodes are uniqued by
/// default based on their operands.
//<editor-fold defaultstate="collapsed" desc="llvm::MDTuple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1048,
 FQN="llvm::MDTuple", NM="_ZN4llvm7MDTupleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTupleE")
//</editor-fold>
public class MDTuple extends /*public*/ MDNode implements MDTuple_or_GenericDINode, Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::MDTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1052,
   FQN="llvm::MDTuple::MDTuple", NM="_ZN4llvm7MDTupleC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTupleC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private MDTuple(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Hash,
      ArrayRef<Metadata /*P*/ > Vals) {
    // : MDNode(C, MDTupleKind, Storage, Vals)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.MDTupleKind.getValue(), Storage, new ArrayRef<Metadata /*P*/ >(Vals));
    //END JInit
    setHash(Hash);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::~MDTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1057,
   FQN="llvm::MDTuple::~MDTuple", NM="_ZN4llvm7MDTupleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTupleD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() {
    dropAllReferences();
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::setHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1059,
   FQN="llvm::MDTuple::setHash", NM="_ZN4llvm7MDTuple7setHashEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple7setHashEj")
  //</editor-fold>
  /*friend*/public/*private*/ void setHash(/*uint*/int Hash) {
    SubclassData32 = Hash;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::recalculateHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 649,
   FQN="llvm::MDTuple::recalculateHash", NM="_ZN4llvm7MDTuple15recalculateHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple15recalculateHashEv")
  //</editor-fold>
  /*friend*/public/*private*/ void recalculateHash() {
    setHash(MDNodeKeyImplMDTuple.<MDTuple>calculateHash(this));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 776,
   FQN="llvm::MDTuple::getImpl", NM="_ZN4llvm7MDTuple7getImplERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEENS4_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple7getImplERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEENS4_11StorageTypeEb")
  //</editor-fold>
  private static MDTuple /*P*/ getImpl(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs,
         Metadata.StorageType Storage) {
    return getImpl(Context, MDs,
         Storage, true);
  }
  private static MDTuple /*P*/ getImpl(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    /*uint*/int Hash = 0;
    if (Storage == StorageType.Uniqued) {
      MDNodeKeyImplMDTuple Key/*J*/= new MDNodeKeyImplMDTuple(new ArrayRef<Metadata /*P*/ >(MDs));
      {
        MDTuple /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.MDTuples, Key);
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

    int $FinalHash = Hash;
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (MDs.size())*/ MDNode.$new(MDs.size(), (type$ptr<?> New$Mem)->{
            return new MDTuple(Context, Storage, $FinalHash, new ArrayRef<Metadata /*P*/ >(MDs));
         }),
        Storage, Context.pImpl.MDTuples);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1065,
   FQN="llvm::MDTuple::cloneImpl", NM="_ZNK4llvm7MDTuple9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm7MDTuple9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return MDTuple.getTemporary(getContext(),
        new ArrayRef<Metadata /*P*/ >(new SmallVector<Metadata /*P*/ >(JD$T.INSTANCE, 4, op_begin(), op_end(), (Metadata /*P*/ )null, (MDOperand M) -> M.$Metadata$P()), true));
  }

/*public:*/
  /// \brief Get the hash, if any.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::getHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1072,
   FQN="llvm::MDTuple::getHash", NM="_ZNK4llvm7MDTuple7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm7MDTuple7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    return SubclassData32;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1074,
   FQN="llvm::MDTuple::get", NM="_ZN4llvm7MDTuple3getERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple3getERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static MDTuple /*P*/ get(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs) {
    return getImpl(Context, new ArrayRef<Metadata /*P*/ >(MDs), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1077,
   FQN="llvm::MDTuple::getIfExists", NM="_ZN4llvm7MDTuple11getIfExistsERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple11getIfExistsERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static MDTuple /*P*/ getIfExists(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs) {
    return getImpl(Context, new ArrayRef<Metadata /*P*/ >(MDs), StorageType.Uniqued, /* ShouldCreate */ false);
  }


  /// \brief Return a distinct node.
  ///
  /// Return a distinct node -- i.e., a node that is not uniqued.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1084,
   FQN="llvm::MDTuple::getDistinct", NM="_ZN4llvm7MDTuple11getDistinctERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple11getDistinctERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static MDTuple /*P*/ getDistinct(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs) {
    return getImpl(Context, new ArrayRef<Metadata /*P*/ >(MDs), StorageType.Distinct);
  }


  /// \brief Return a temporary node.
  ///
  /// For use in constructing cyclic MDNode structures. A temporary MDNode is
  /// not uniqued, may be RAUW'd, and must be manually deleted with
  /// deleteTemporary.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1093,
   FQN="llvm::MDTuple::getTemporary", NM="_ZN4llvm7MDTuple12getTemporaryERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple12getTemporaryERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context,
              ArrayRef<Metadata /*P*/ > MDs) {
    return new std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/>(getImpl(Context, new ArrayRef<Metadata /*P*/ >(MDs), StorageType.Temporary));
  }


  /// \brief Return a (temporary) clone of this.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1099,
   FQN="llvm::MDTuple::clone", NM="_ZNK4llvm7MDTuple5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm7MDTuple5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTuple::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1101,
   FQN="llvm::MDTuple::classof", NM="_ZN4llvm7MDTuple7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7MDTuple7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.MDTupleKind.getValue();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public MDTuple(MDTuple Other) {
    super(Other);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
