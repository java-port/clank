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
import org.clank.support.JavaDifferentiators.JD$Move;


/// \brief A collection of metadata nodes that might be associated with a
/// memory access used by the alias-analysis infrastructure.
//<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 607,
 FQN="llvm::AAMDNodes", NM="_ZN4llvm9AAMDNodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm9AAMDNodesE")
//</editor-fold>
public class/*struct*/ AAMDNodes implements Native.NativeComparable<AAMDNodes>, Native.Native$Bool {
  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::AAMDNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 608,
   FQN="llvm::AAMDNodes::AAMDNodes", NM="_ZN4llvm9AAMDNodesC1EPNS_6MDNodeES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm9AAMDNodesC1EPNS_6MDNodeES2_S2_")
  //</editor-fold>
  public /*explicit*/ AAMDNodes() {
    this((MDNode /*P*/ )null, (MDNode /*P*/ )null, 
      (MDNode /*P*/ )null);
  }
  public /*explicit*/ AAMDNodes(MDNode /*P*/ T/*= null*/) {
    this(T, (MDNode /*P*/ )null, 
      (MDNode /*P*/ )null);
  }
  public /*explicit*/ AAMDNodes(MDNode /*P*/ T/*= null*/, MDNode /*P*/ S/*= null*/) {
    this(T, S, 
      (MDNode /*P*/ )null);
  }
  public /*explicit*/ AAMDNodes(MDNode /*P*/ T/*= null*/, MDNode /*P*/ S/*= null*/, 
      MDNode /*P*/ N/*= null*/) {
    // : TBAA(T), Scope(S), NoAlias(N) 
    //START JInit
    this.TBAA = T;
    this.Scope = S;
    this.NoAlias = N;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 612,
   FQN="llvm::AAMDNodes::operator==", NM="_ZNK4llvm9AAMDNodeseqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZNK4llvm9AAMDNodeseqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ AAMDNodes /*&*/ A) /*const*/ {
    return TBAA == A.TBAA && Scope == A.Scope && NoAlias == A.NoAlias;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 616,
   FQN="llvm::AAMDNodes::operator!=", NM="_ZNK4llvm9AAMDNodesneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZNK4llvm9AAMDNodesneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ AAMDNodes /*&*/ A) /*const*/ {
    return !(/*Deref*/this.$eq(A));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 618,
   FQN="llvm::AAMDNodes::operator bool", NM="_ZNK4llvm9AAMDNodescvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZNK4llvm9AAMDNodescvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (TBAA != null) || (Scope != null) || (NoAlias != null);
  }

  
  /// \brief The tag for type-based alias analysis.
  public MDNode /*P*/ TBAA;
  
  /// \brief The tag for alias scope specification (used with noalias).
  public MDNode /*P*/ Scope;
  
  /// \brief The tag specifying the noalias scope.
  public MDNode /*P*/ NoAlias;
  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::AAMDNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 607,
   FQN="llvm::AAMDNodes::AAMDNodes", NM="_ZN4llvm9AAMDNodesC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm9AAMDNodesC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AAMDNodes(final /*const*/ AAMDNodes /*&*/ $Prm0) {
    // : TBAA(.TBAA), Scope(.Scope), NoAlias(.NoAlias) 
    //START JInit
    this.TBAA = $Prm0.TBAA;
    this.Scope = $Prm0.Scope;
    this.NoAlias = $Prm0.NoAlias;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::AAMDNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 607,
   FQN="llvm::AAMDNodes::AAMDNodes", NM="_ZN4llvm9AAMDNodesC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm9AAMDNodesC1EOS0_")
  //</editor-fold>
  public /*inline*/ AAMDNodes(JD$Move _dparam, final AAMDNodes /*&&*/$Prm0) {
    // : TBAA(static_cast<AAMDNodes &&>().TBAA), Scope(static_cast<AAMDNodes &&>().Scope), NoAlias(static_cast<AAMDNodes &&>().NoAlias) 
    //START JInit
    this.TBAA = $Prm0.TBAA;
    this.Scope = $Prm0.Scope;
    this.NoAlias = $Prm0.NoAlias;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 607,
   FQN="llvm::AAMDNodes::operator=", NM="_ZN4llvm9AAMDNodesaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm9AAMDNodesaSERKS0_")
  //</editor-fold>
  public /*inline*/ AAMDNodes /*&*/ $assign(final /*const*/ AAMDNodes /*&*/ $Prm0) {
    this.TBAA = $Prm0.TBAA;
    this.Scope = $Prm0.Scope;
    this.NoAlias = $Prm0.NoAlias;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAMDNodes::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 607,
   FQN="llvm::AAMDNodes::operator=", NM="_ZN4llvm9AAMDNodesaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm9AAMDNodesaSEOS0_")
  //</editor-fold>
  public /*inline*/ AAMDNodes /*&*/ $assignMove(final AAMDNodes /*&&*/$Prm0) {
    this.TBAA = $Prm0.TBAA;
    this.Scope = $Prm0.Scope;
    this.NoAlias = $Prm0.NoAlias;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "TBAA=" + TBAA // NOI18N
              + ", Scope=" + Scope // NOI18N
              + ", NoAlias=" + NoAlias; // NOI18N
  }
}
