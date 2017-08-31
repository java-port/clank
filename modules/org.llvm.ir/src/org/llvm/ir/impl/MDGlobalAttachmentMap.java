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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


/// Multimap-like storage for metadata attachments for globals. This differs
/// from MDAttachmentMap in that it allows multiple attachments per metadata
/// kind.
//<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1010,
 FQN="llvm::MDGlobalAttachmentMap", NM="_ZN4llvm21MDGlobalAttachmentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMapE")
//</editor-fold>
public class MDGlobalAttachmentMap implements NativeCloneable<MDGlobalAttachmentMap>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::Attachment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1011,
   FQN="llvm::MDGlobalAttachmentMap::Attachment", NM="_ZN4llvm21MDGlobalAttachmentMap10AttachmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap10AttachmentE")
  //</editor-fold>
  private static class/*struct*/ Attachment implements NativeCloneable<Attachment>, Destructors.ClassWithDestructor {
    public /*uint*/int MDKind;
    public TypedTrackingMDRef<MDNode> Node;
    //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::Attachment::Attachment">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1011,
     FQN="llvm::MDGlobalAttachmentMap::Attachment::Attachment", NM="_ZN4llvm21MDGlobalAttachmentMap10AttachmentC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap10AttachmentC1EOS1_")
    //</editor-fold>
    public /*inline*/ Attachment(JD$Move _dparam, final Attachment /*&&*/$Prm0) {
      // : MDKind(static_cast<Attachment &&>().MDKind), Node(static_cast<Attachment &&>().Node) 
      //START JInit
      this.MDKind = $Prm0.MDKind;
      this.Node = new TypedTrackingMDRef<MDNode>(JD$Move.INSTANCE, $Prm0.Node);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::Attachment::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1011,
     FQN="llvm::MDGlobalAttachmentMap::Attachment::operator=", NM="_ZN4llvm21MDGlobalAttachmentMap10AttachmentaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap10AttachmentaSEOS1_")
    //</editor-fold>
    public /*inline*/ Attachment /*&*/ $assignMove(final Attachment /*&&*/$Prm0) {
      this.MDKind = $Prm0.MDKind;
      this.Node.$assignMove($Prm0.Node);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::Attachment::~Attachment">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1011,
     FQN="llvm::MDGlobalAttachmentMap::Attachment::~Attachment", NM="_ZN4llvm21MDGlobalAttachmentMap10AttachmentD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap10AttachmentD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Node.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::Attachment::Attachment">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1011,
     FQN="llvm::MDGlobalAttachmentMap::Attachment::Attachment", NM="_ZN4llvm21MDGlobalAttachmentMap10AttachmentC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap10AttachmentC1Ev")
    //</editor-fold>
    public /*inline*/ Attachment() {
      // : Node() 
      //START JInit
      this.Node = new TypedTrackingMDRef<MDNode>();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::Attachment::Attachment">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1011,
     FQN="llvm::MDGlobalAttachmentMap::Attachment::Attachment", NM="_ZN4llvm21MDGlobalAttachmentMap10AttachmentC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap10AttachmentC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Attachment(final /*const*/ Attachment /*&*/ $Prm0) {
      // : MDKind(.MDKind), Node(.Node) 
      //START JInit
      this.MDKind = $Prm0.MDKind;
      this.Node = new TypedTrackingMDRef<MDNode>($Prm0.Node);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Attachment(int MDKind, TypedTrackingMDRef<MDNode> Node) {
      this.MDKind = MDKind;
      this.Node = Node;
    }

    @Override public Attachment clone() { 
      return new Attachment(this); 
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "MDKind=" + MDKind // NOI18N
                + ", Node=" + Node; // NOI18N
    }
  };
  private SmallVector<Attachment> Attachments;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1018,
   FQN="llvm::MDGlobalAttachmentMap::empty", NM="_ZNK4llvm21MDGlobalAttachmentMap5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm21MDGlobalAttachmentMap5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Attachments.empty();
  }

  
  /// Appends all attachments with the given ID to \c Result in insertion order.
  /// If the global has no attachments with the given ID, or if ID is invalid,
  /// leaves Result unchanged.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1132,
   FQN="llvm::MDGlobalAttachmentMap::get", NM="_ZN4llvm21MDGlobalAttachmentMap3getEjRNS_15SmallVectorImplIPNS_6MDNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap3getEjRNS_15SmallVectorImplIPNS_6MDNodeEEE")
  //</editor-fold>
  public void get(/*uint*/int ID, 
     final SmallVectorImpl<MDNode /*P*/ > /*&*/ Result) {
    for (Attachment A : Attachments)  {
      if (A.MDKind == ID) {
        Result.push_back(A.Node.$T$P());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1128,
   FQN="llvm::MDGlobalAttachmentMap::insert", NM="_ZN4llvm21MDGlobalAttachmentMap6insertEjRNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap6insertEjRNS_6MDNodeE")
  //</editor-fold>
  public void insert(/*uint*/int ID, final MDNode /*&*/ MD) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Attachments.push_back_T$RR($c$.track(new Attachment(ID, $c$.track(new TypedTrackingMDRef<MDNode>($AddrOf(MD)))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1139,
   FQN="llvm::MDGlobalAttachmentMap::erase", NM="_ZN4llvm21MDGlobalAttachmentMap5eraseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMap5eraseEj")
  //</editor-fold>
  public void erase(/*uint*/int ID) {
    type$ptr<Attachment /*P*/ > Follower = $tryClone(Attachments.begin());
    for (type$ptr<Attachment /*P*/ > Leader = $tryClone(Attachments.begin()), /*P*/ E = $tryClone(Attachments.end()); $noteq_ptr(Leader, E);
         Leader.$preInc()) {
      if (Leader./*->*/$star().MDKind != ID) {
        if ($noteq_ptr(Follower, Leader)) {
          Follower.$star().$assignMove(std.move(Leader.$star()));
        }
        Follower.$preInc();
      }
    }
    Attachments.resize(Follower.$sub(Attachments.begin()));
  }

  
  /// Appends all attachments for the global to \c Result, sorting by attachment
  /// ID. Attachments with the same ID appear in insertion order. This function
  /// does \em not clear \c Result.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::getAll">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1152,
   FQN="llvm::MDGlobalAttachmentMap::getAll", NM="_ZNK4llvm21MDGlobalAttachmentMap6getAllERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm21MDGlobalAttachmentMap6getAllERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  public void getAll(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ Result) /*const*/ {
    for (final /*const*/ Attachment /*&*/ A : Attachments)  {
      Result.emplace_back(new std.pairUIntPtr<MDNode /*P*/ >(A.MDKind, A.Node.$T$P()));
    }
    
    // Sort the resulting array so it is stable with respect to metadata IDs. We
    // need to preserve the original insertion order though.
    std.stable_sort(Result.begin(), Result.end(), 
        /*[]*/ (final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ A, final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ B) -> {
              return $less_uint(A.first, B.first);
            });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::MDGlobalAttachmentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1010,
   FQN="llvm::MDGlobalAttachmentMap::MDGlobalAttachmentMap", NM="_ZN4llvm21MDGlobalAttachmentMapC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMapC1EOS0_")
  //</editor-fold>
  public /*inline*/ MDGlobalAttachmentMap(JD$Move _dparam, final MDGlobalAttachmentMap /*&&*/$Prm0) {
    // : Attachments(static_cast<MDGlobalAttachmentMap &&>().Attachments) 
    //START JInit
    this.Attachments = new SmallVector<Attachment>(JD$Move.INSTANCE, $Prm0.Attachments);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::~MDGlobalAttachmentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1010,
   FQN="llvm::MDGlobalAttachmentMap::~MDGlobalAttachmentMap", NM="_ZN4llvm21MDGlobalAttachmentMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Attachments.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDGlobalAttachmentMap::MDGlobalAttachmentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1010,
   FQN="llvm::MDGlobalAttachmentMap::MDGlobalAttachmentMap", NM="_ZN4llvm21MDGlobalAttachmentMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21MDGlobalAttachmentMapC1Ev")
  //</editor-fold>
  public /*inline*/ MDGlobalAttachmentMap() {
    // : Attachments() 
    //START JInit
    this.Attachments = new SmallVector<Attachment>(1, new Attachment());
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public MDGlobalAttachmentMap clone() {
    assert this.Attachments.empty() : "only empty can be cloned";
    return new MDGlobalAttachmentMap();
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Attachments=" + Attachments; // NOI18N
  }
}
