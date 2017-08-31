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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.ir.java.*;


/// \brief Tracking metadata reference owned by Metadata.
///
/// Similar to \a TrackingMDRef, but it's expected to be owned by an instance
/// of \a Metadata, which has the option of registering itself for callbacks to
/// re-unique itself.
///
/// In particular, this is used by \a MDNode.
//<editor-fold defaultstate="collapsed" desc="llvm::MDOperand">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 658,
 FQN="llvm::MDOperand", NM="_ZN4llvm9MDOperandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandE")
//</editor-fold>
public class MDOperand implements GetMetadata, simplify_type, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::MDOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 659,
   FQN="llvm::MDOperand::MDOperand", NM="_ZN4llvm9MDOperandC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandC1EOS0_")
  //</editor-fold>
  protected/*private*/ MDOperand(JD$Move _dparam, final MDOperand /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::MDOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 660,
   FQN="llvm::MDOperand::MDOperand", NM="_ZN4llvm9MDOperandC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MDOperand(final /*const*/ MDOperand /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 661,
   FQN="llvm::MDOperand::operator=", NM="_ZN4llvm9MDOperandaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandaSEOS0_")
  //</editor-fold>
  protected/*private*/ MDOperand /*&*/ $assignMove(final MDOperand /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 662,
   FQN="llvm::MDOperand::operator=", NM="_ZN4llvm9MDOperandaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandaSERKS0_")
  //</editor-fold>
  protected/*private*/ MDOperand /*&*/ $assign(final /*const*/ MDOperand /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  // JAVA: MD is the first field in this class, so this == &MD$Ptr
  private Metadata /*P*/ MD;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::MDOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 667,
   FQN="llvm::MDOperand::MDOperand", NM="_ZN4llvm9MDOperandC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandC1Ev")
  //</editor-fold>
  public MDOperand() {
    // : MD(null)
    //START JInit
    this.MD = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::~MDOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 668,
   FQN="llvm::MDOperand::~MDOperand", NM="_ZN4llvm9MDOperandD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperandD0Ev")
  //</editor-fold>
  public void $destroy() {
    untrack();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 670,
   FQN="llvm::MDOperand::get", NM="_ZNK4llvm9MDOperand3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm9MDOperand3getEv")
  //</editor-fold>
  public Metadata /*P*/ get() /*const*/ {
    return MD;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::operator Metadata * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 671,
   FQN="llvm::MDOperand::operator Metadata * ", NM="_ZNK4llvm9MDOperandcvPNS_8MetadataEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm9MDOperandcvPNS_8MetadataEEv")
  //</editor-fold>
  public Metadata /*P*/ $Metadata$P() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 672,
   FQN="llvm::MDOperand::operator->", NM="_ZNK4llvm9MDOperandptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm9MDOperandptEv")
  //</editor-fold>
  public Metadata /*P*/ $arrow() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 673,
   FQN="llvm::MDOperand::operator*", NM="_ZNK4llvm9MDOperanddeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm9MDOperanddeEv")
  //</editor-fold>
  public Metadata /*&*/ $star() /*const*/ {
    return $Deref(get());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 675,
   FQN="llvm::MDOperand::reset", NM="_ZN4llvm9MDOperand5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperand5resetEv")
  //</editor-fold>
  public void reset() {
    untrack();
    MD = null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 679,
   FQN="llvm::MDOperand::reset", NM="_ZN4llvm9MDOperand5resetEPNS_8MetadataES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperand5resetEPNS_8MetadataES2_")
  //</editor-fold>
  public void reset(Metadata /*P*/ MD, Metadata /*P*/ Owner) {
    untrack();
    this.MD = MD;
    track(Owner);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::track">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 686,
   FQN="llvm::MDOperand::track", NM="_ZN4llvm9MDOperand5trackEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperand5trackEPNS_8MetadataE")
  //</editor-fold>
  private void track(Metadata /*P*/ Owner) {
    if ((MD != null)) {
      if ((Owner != null)) {
        // /*JAVA: this == &MD, so pass MD field as a key for correct untrack
        MetadataTracking.track(MD$Ptr, $Deref(MD), $Deref(Owner));
      } else {
        MetadataTracking.track(MD$Ptr);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::untrack">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 694,
   FQN="llvm::MDOperand::untrack", NM="_ZN4llvm9MDOperand7untrackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm9MDOperand7untrackEv")
  //</editor-fold>
  private void untrack() {
    //JAVA: I don't thinbk this assertion makes sense in Java
    //assert ((reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (this))) == MD.deref$ptr()) : "Expected same address";
    if ((MD != null)) {
      MetadataTracking.untrack(MD$Ptr);
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::getSimplifiedValue">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 706)
  //</editor-fold>
  @Override public Object getSimplifiedValue(Object $This) {
    // copied from simplify_type<const MDOperand> 
    assert $This == this : "must be called on itself " + $This + " vs. " + this;
    return this.get();
  }
  
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
    return "" + "MD=" + MD; // NOI18N
  }
}
