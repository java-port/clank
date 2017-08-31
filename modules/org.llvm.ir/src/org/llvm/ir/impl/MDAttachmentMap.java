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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


/// \brief Map-like storage for metadata attachments.
//<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 970,
 FQN="llvm::MDAttachmentMap", NM="_ZN4llvm15MDAttachmentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MDAttachmentMapE")
//</editor-fold>
public class MDAttachmentMap implements NativeCloneable<MDAttachmentMap>, Destructors.ClassWithDestructor {
  private SmallVector<std.pairUIntType<TypedTrackingMDRef<MDNode>>> Attachments;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 974,
   FQN="llvm::MDAttachmentMap::empty", NM="_ZNK4llvm15MDAttachmentMap5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15MDAttachmentMap5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Attachments.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 975,
   FQN="llvm::MDAttachmentMap::size", NM="_ZNK4llvm15MDAttachmentMap4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15MDAttachmentMap4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Attachments.size();
  }

  
  /// \brief Get a particular attachment (if any).
  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1112,
   FQN="llvm::MDAttachmentMap::lookup", NM="_ZNK4llvm15MDAttachmentMap6lookupEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15MDAttachmentMap6lookupEj")
  //</editor-fold>
  public MDNode /*P*/ lookup(/*uint*/int ID) /*const*/ {
    for (final /*const*/std.pairUIntType<TypedTrackingMDRef<MDNode>> /*&*/ I : Attachments)  {
      if (I.first == ID) {
        return I.second.$T$P();
      }
    }
    return null;
  }

  
  /// \brief Set an attachment to a particular node.
  ///
  /// Set the \c ID attachment to \c MD, replacing the current attachment at \c
  /// ID (if anyway).
  
  //===----------------------------------------------------------------------===//
  // Instruction Metadata method implementations.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1083,
   FQN="llvm::MDAttachmentMap::set", NM="_ZN4llvm15MDAttachmentMap3setEjRNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MDAttachmentMap3setEjRNS_6MDNodeE")
  //</editor-fold>
  public void set(/*uint*/int ID, final MDNode /*&*/ MD) {
    for (final std.pairUIntType<TypedTrackingMDRef<MDNode>> /*&*/ I : Attachments)  {
      if (I.first == ID) {
        I.second.reset($AddrOf(MD));
        return;
      }
    }
    Attachments.emplace_back(new std.pairUIntType<TypedTrackingMDRef<MDNode>>(/*std.piecewise_construct,*/ /*std.make_tuple(ID), */
        /*std.make_tuple(*MD))*/ID, new TypedTrackingMDRef(MD)));
  }

  
  /// \brief Remove an attachment.
  ///
  /// Remove the attachment at \c ID, if any.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1093,
   FQN="llvm::MDAttachmentMap::erase", NM="_ZN4llvm15MDAttachmentMap5eraseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MDAttachmentMap5eraseEj")
  //</editor-fold>
  public void erase(/*uint*/int ID) {
    if (empty()) {
      return;
    }
    
    // Common case is one/last value.
    if (Attachments.back().first == ID) {
      Attachments.pop_back();
      return;
    }
    
    for (type$ptr<std.pairUIntType<TypedTrackingMDRef<MDNode>> /*P*/> I = $tryClone(Attachments.begin()), E = std.prev(Attachments.end()); I.$noteq(E);
         I.$preInc())  {
      if (I./*->*/$star().first == ID) {
        I.$star().$assignMove(std.move(Attachments.back()));
        Attachments.pop_back();
        return;
      }
    }
  }

  
  /// \brief Copy out all the attachments.
  ///
  /// Copies all the current attachments into \c Result, sorting by attachment
  /// ID.  This function does \em not clear \c Result.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::getAll">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1119,
   FQN="llvm::MDAttachmentMap::getAll", NM="_ZNK4llvm15MDAttachmentMap6getAllERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15MDAttachmentMap6getAllERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  public void getAll(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ Result) /*const*/ {
    Result.append_T(Attachments.begin$Const(), Attachments.end$Const(), new Converter<pairUIntType<TypedTrackingMDRef<MDNode>>, pairUIntPtr<MDNode>>() {
      @Override
      public pairUIntPtr<MDNode /*P*/> $call(pairUIntType<TypedTrackingMDRef<MDNode>> from) {
        return new std.pairUIntPtr<>(from.first, from.second.$T$P());
      }
    });
    
    // Sort the resulting array so it is stable.
    if ($greater_uint(Result.size(), 1)) {
      array_pod_sort(Result.begin(), Result.end());
    }
  }

  
  /// \brief Erase matching attachments.
  ///
  /// Erases all attachments matching the \c shouldRemove predicate.
  /*template <class PredTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::remove_if">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1000,
   FQN="llvm::MDAttachmentMap::remove_if", NM="Tpl__ZN4llvm15MDAttachmentMap9remove_ifET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm15MDAttachmentMap9remove_ifET_")
  //</editor-fold>
  public void remove_if(BoolPredicate<std.pairUIntType<TypedTrackingMDRef<MDNode>>> shouldRemove) {
    Attachments.erase(std.remove_if(Attachments.begin(), Attachments.end(), shouldRemove), 
        Attachments.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::MDAttachmentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 970,
   FQN="llvm::MDAttachmentMap::MDAttachmentMap", NM="_ZN4llvm15MDAttachmentMapC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MDAttachmentMapC1EOS0_")
  //</editor-fold>
  public /*inline*/ MDAttachmentMap(JD$Move _dparam, final MDAttachmentMap /*&&*/$Prm0) {
    // : Attachments(static_cast<MDAttachmentMap &&>().Attachments) 
    //START JInit
    this.Attachments = new SmallVector<std.pairUIntType<TypedTrackingMDRef<MDNode>>>(JD$Move.INSTANCE, $Prm0.Attachments);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::~MDAttachmentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 970,
   FQN="llvm::MDAttachmentMap::~MDAttachmentMap", NM="_ZN4llvm15MDAttachmentMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MDAttachmentMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Attachments.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDAttachmentMap::MDAttachmentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 970,
   FQN="llvm::MDAttachmentMap::MDAttachmentMap", NM="_ZN4llvm15MDAttachmentMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15MDAttachmentMapC1Ev")
  //</editor-fold>
  public /*inline*/ MDAttachmentMap() {
    // : Attachments() 
    //START JInit
    this.Attachments = new SmallVector<std.pairUIntType<TypedTrackingMDRef<MDNode>>>(2, new std.pairUIntType<TypedTrackingMDRef<MDNode>>());
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public MDAttachmentMap clone() {
    assert Attachments.empty() : "can clone only empty";
    return new MDAttachmentMap();
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Attachments=" + Attachments; // NOI18N
  }
}
