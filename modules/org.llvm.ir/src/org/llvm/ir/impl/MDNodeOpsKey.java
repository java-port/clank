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

package org.llvm.ir.impl;

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


/// \brief Structure for hashing arbitrary MDNode operands.
//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 172,
 FQN="llvm::MDNodeOpsKey", NM="_ZN4llvm12MDNodeOpsKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm12MDNodeOpsKeyE")
//</editor-fold>
public class MDNodeOpsKey {
  private ArrayRef<Metadata /*P*/ > RawOps;
  private ArrayRef<MDOperand> Ops;

  private /*uint*/int Hash;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::MDNodeOpsKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 179,
   FQN="llvm::MDNodeOpsKey::MDNodeOpsKey", NM="_ZN4llvm12MDNodeOpsKeyC1ENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm12MDNodeOpsKeyC1ENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  protected MDNodeOpsKey(ArrayRef<Metadata /*P*/ > Ops) {
    // : RawOps(Ops), Ops(), Hash(calculateHash(Ops))
    //START JInit
    this.RawOps = new ArrayRef<Metadata /*P*/ >(Ops);
    this.Ops = new ArrayRef<MDOperand>(false);
    this.Hash = calculateHash(new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }


  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::MDNodeOpsKey">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 183,
   FQN="llvm::MDNodeOpsKey::MDNodeOpsKey", NM="Tpl__ZN4llvm12MDNodeOpsKeyC1EPKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=Tpl__ZN4llvm12MDNodeOpsKeyC1EPKT_j")
  //</editor-fold>
  protected </*class*/ NodeTy extends MDTuple_or_GenericDINode> MDNodeOpsKey(/*const*/ NodeTy /*P*/ N) {
    this(N, 0);
  }
  protected </*class*/ NodeTy extends MDTuple_or_GenericDINode> MDNodeOpsKey(/*const*/ NodeTy /*P*/ N, /*uint*/int Offset/*= 0*/) {
    // : Ops(N->op_begin() + Offset, N->op_end()), Hash(N->getHash())
    //START JInit
    this.Ops = /*ParenListExpr*/new ArrayRef<MDOperand>(Native.$add(N.op_begin(), Offset), N.op_end(), false);
    this.Hash = /*ParenListExpr*//*uint*/N.getHash();
    //END JInit
  }


  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::compareOps">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 187,
   FQN="llvm::MDNodeOpsKey::compareOps", NM="Tpl__ZNK4llvm12MDNodeOpsKey10compareOpsEPKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=Tpl__ZNK4llvm12MDNodeOpsKey10compareOpsEPKT_j")
  //</editor-fold>
  protected </*class*/ NodeTy extends MDTuple_or_GenericDINode> boolean compareOps(/*const*/ NodeTy /*P*/ RHS) /*const*/ {
    return compareOps(RHS, 0);
  }
  protected </*class*/ NodeTy extends MDTuple_or_GenericDINode> boolean compareOps(/*const*/ NodeTy /*P*/ RHS, /*uint*/int Offset/*= 0*/) /*const*/ {
    if (Native.$noteq(getHash(), RHS.getHash())) {
      return false;
    }
    assert ((RawOps.empty() || Ops.empty())) : "Two sets of operands?";
    return RawOps.empty() ? compareOps(Ops, (MDNode)RHS, Offset) : compareOps(RawOps, (MDNode)RHS, Offset);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::calculateHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 182,
   FQN="llvm::MDNodeOpsKey::calculateHash", NM="_ZN4llvm12MDNodeOpsKey13calculateHashEPNS_6MDNodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm12MDNodeOpsKey13calculateHashEPNS_6MDNodeEj")
  //</editor-fold>
  protected static /*uint*/int calculateHash(MDNode /*P*/ N) {
    return calculateHash(N, 0);
  }
  protected static /*uint*/int calculateHash(MDNode /*P*/ N, /*uint*/int Offset/*= 0*/) {
    /*uint*/int Hash = hash_combine_range(N.op_begin().$add(Offset), N.op_end()).$uint();
    {
      SmallVector<Metadata /*P*/ > MDs/*J*/= new SmallVector<Metadata /*P*/ >(JD$T.INSTANCE, 8, N.op_begin().$add(Offset), N.op_end(), (Metadata /*P*/ )null, (MDOperand M) -> M.$Metadata$P());
      /*uint*/int RawHash = calculateHash(new ArrayRef<Metadata /*P*/ >(MDs, true));
      assert (Hash == RawHash) : "Expected hash of MDOperand to equal hash of Metadata*";
    }
    return Hash;
  }

/*private:*/
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::compareOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 200,
   FQN="llvm::MDNodeOpsKey::compareOps", NM="Tpl__ZN4llvm12MDNodeOpsKey10compareOpsENS_8ArrayRefIT_EEPKNS_6MDNodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=Tpl__ZN4llvm12MDNodeOpsKey10compareOpsENS_8ArrayRefIT_EEPKNS_6MDNodeEj")
  //</editor-fold>
  private static </*class*/ T> boolean compareOps(ArrayRef<T> Ops, /*const*/ MDNode /*P*/ RHS, /*uint*/int Offset) {
    if (Native.$noteq(Ops.size(), RHS.getNumOperands() - Offset)) {
      return false;
    }
    return std.equal(Ops.begin(), Ops.end(), RHS.op_begin().$add(Offset));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::calculateHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 195,
   FQN="llvm::MDNodeOpsKey::calculateHash", NM="_ZN4llvm12MDNodeOpsKey13calculateHashENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm12MDNodeOpsKey13calculateHashENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  private static /*uint*/int calculateHash(ArrayRef<Metadata /*P*/ > Ops) {
    return hash_combine_range_ptrs(Ops.begin(), Ops.end()).$uint();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeOpsKey::getHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 209,
   FQN="llvm::MDNodeOpsKey::getHash", NM="_ZNK4llvm12MDNodeOpsKey7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm12MDNodeOpsKey7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    return Hash;
  }


  @Override public String toString() {
    return "" + "RawOps=" + RawOps // NOI18N
              + ", Ops=" + Ops // NOI18N
              + ", Hash=" + Hash; // NOI18N
  }
}
