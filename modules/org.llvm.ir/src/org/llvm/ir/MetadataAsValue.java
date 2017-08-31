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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;


/// \brief Metadata wrapper in the Value hierarchy.
///
/// A member of the \a Value hierarchy to represent a reference to metadata.
/// This allows, e.g., instrinsics to have metadata as operands.
///
/// Notably, this is the only thing in either hierarchy that is allowed to
/// reference \a LocalAsMetadata.
//<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 149,
 FQN="llvm::MetadataAsValue", NM="_ZN4llvm15MetadataAsValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValueE")
//</editor-fold>
public class MetadataAsValue extends /*public*/ Value implements Destructors.ClassWithDestructor {
  /*friend  class ReplaceableMetadataImpl*/
  /*friend  class LLVMContextImpl*/

  private Metadata /*P*/ MD;

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::MetadataAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 30,
   FQN="llvm::MetadataAsValue::MetadataAsValue", NM="_ZN4llvm15MetadataAsValueC1EPNS_4TypeEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValueC1EPNS_4TypeEPNS_8MetadataE")
  //</editor-fold>
  private MetadataAsValue(Type /*P*/ Ty, Metadata /*P*/ MD) {
    // : Value(Ty, MetadataAsValueVal), MD(MD)
    //START JInit
    super(Ty, ValueTy.MetadataAsValueVal.getValue());
    this.MD = MD;
    //END JInit
    track();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::~MetadataAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 35,
   FQN="llvm::MetadataAsValue::~MetadataAsValue", NM="_ZN4llvm15MetadataAsValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValueD0Ev")
  //</editor-fold>
  @Override public/*private*/ void $destroy()/* override*/ {
    getType().getContext().pImpl.MetadataAsValues.erase(MD);
    untrack();
    super.$destroy();
  }


  /// \brief Drop use of metadata (during teardown).
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::dropUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 159,
   FQN="llvm::MetadataAsValue::dropUse", NM="_ZN4llvm15MetadataAsValue7dropUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue7dropUseEv")
  //</editor-fold>
  /*friend*/public/*private*/ void dropUse() {
    MD = null;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 73,
   FQN="llvm::MetadataAsValue::get", NM="_ZN4llvm15MetadataAsValue3getERNS_11LLVMContextEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue3getERNS_11LLVMContextEPNS_8MetadataE")
  //</editor-fold>
  public static MetadataAsValue /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ MD) {
    MD = MetadataStatics.canonicalizeMetadataForValue(Context, MD);
    final type$ref<MetadataAsValue /*P*/ /*&*/> Entry = Context.pImpl.MetadataAsValues.ref$at(MD);
    if (!(Entry.$deref() != null)) {
      Entry.$set(new MetadataAsValue(Type.getMetadataTy(Context), MD));
    }
    return Entry.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::getIfExists">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 81,
   FQN="llvm::MetadataAsValue::getIfExists", NM="_ZN4llvm15MetadataAsValue11getIfExistsERNS_11LLVMContextEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue11getIfExistsERNS_11LLVMContextEPNS_8MetadataE")
  //</editor-fold>
  public static MetadataAsValue /*P*/ getIfExists(final LLVMContext /*&*/ Context,
             Metadata /*P*/ MD) {
    MD = MetadataStatics.canonicalizeMetadataForValue(Context, MD);
    final DenseMap<Metadata /*P*/ , MetadataAsValue /*P*/> /*&*/ Store = Context.pImpl.MetadataAsValues;
    return Store.lookup(MD);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 164,
   FQN="llvm::MetadataAsValue::getMetadata", NM="_ZNK4llvm15MetadataAsValue11getMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15MetadataAsValue11getMetadataEv")
  //</editor-fold>
  public Metadata /*P*/ getMetadata() /*const*/ {
    return MD;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 166,
   FQN="llvm::MetadataAsValue::classof", NM="_ZN4llvm15MetadataAsValue7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.MetadataAsValueVal.getValue();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::handleChangedMetadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 88,
   FQN="llvm::MetadataAsValue::handleChangedMetadata", NM="_ZN4llvm15MetadataAsValue21handleChangedMetadataEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue21handleChangedMetadataEPNS_8MetadataE")
  //</editor-fold>
  /*friend*/public/*private*/ void handleChangedMetadata(Metadata /*P*/ MD) {
    final LLVMContext /*&*/ Context = getContext();
    MD = MetadataStatics.canonicalizeMetadataForValue(Context, MD);
    final DenseMap<Metadata /*P*/ , MetadataAsValue /*P*/> /*&*/ Store = Context.pImpl.MetadataAsValues;

    // Stop tracking the old metadata.
    Store.erase(this.MD);
    untrack();
    this.MD = null;

    // Start tracking MD, or RAUW if necessary.
    final type$ref<MetadataAsValue /*P*/ /*&*/> Entry = Store.ref$at(MD);
    if ((Entry.$deref() != null)) {
      replaceAllUsesWith(Entry.$deref());
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)this);
      return;
    }

    this.MD = MD;
    track();
    Entry.$set(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::track">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 111,
   FQN="llvm::MetadataAsValue::track", NM="_ZN4llvm15MetadataAsValue5trackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue5trackEv")
  //</editor-fold>
  private void track() {
    if ((MD != null)) {
      MetadataTracking.track($AddrOf(/*create_type$ptr2ConstT*/(MD$Ptr)), $Deref(MD), /*Deref*/this);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataAsValue::untrack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 116,
   FQN="llvm::MetadataAsValue::untrack", NM="_ZN4llvm15MetadataAsValue7untrackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MetadataAsValue7untrackEv")
  //</editor-fold>
  private void untrack() {
    if ((MD != null)) {
      MetadataTracking.untrack(MD$Ptr);
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final type$ptr<Metadata/*P*/> /*P*/ MD$Ptr = new type$ptr$inout<Metadata/*P*/>() {
    @Override
    protected Metadata/*P*/ $star$impl() {
      return MD;
    }

    @Override
    protected Metadata/*P*/ $set$impl(Metadata/*P*/ value) {
      return MD = value;
    }

    @Override
    public type$ptr$inout<Metadata> clone() {
      assert false : "why was cloned?";
      return this;
    }
  };
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "MD=" + MD // NOI18N
              + super.toString(); // NOI18N
  }
}
