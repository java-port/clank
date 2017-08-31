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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


/// \brief Layout pointer alignment element.
///
/// Stores the alignment data associated with a given pointer and address space.
///
/// \note The unusual order of elements in the structure attempts to reduce
/// padding and make the structure slightly more cache friendly.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerAlignElem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 83,
 FQN="llvm::PointerAlignElem", NM="_ZN4llvm16PointerAlignElemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm16PointerAlignElemE")
//</editor-fold>
public class/*struct*/ PointerAlignElem implements NativePOD<PointerAlignElem>, Native.NativeComparable<PointerAlignElem> {
  public /*uint*/int ABIAlign;
  public /*uint*/int PrefAlign;
  public /*uint32_t*/int TypeByteWidth;
  public /*uint32_t*/int AddressSpace;
  
  /// Initializer
  
  //===----------------------------------------------------------------------===//
  // PointerAlignElem, PointerAlign support
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerAlignElem::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 128,
   FQN="llvm::PointerAlignElem::get", NM="_ZN4llvm16PointerAlignElem3getEjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm16PointerAlignElem3getEjjjj")
  //</editor-fold>
  public static PointerAlignElem get(/*uint32_t*/int AddressSpace, /*uint*/int ABIAlign, 
     /*uint*/int PrefAlign, /*uint32_t*/int TypeByteWidth) {
    assert ($lesseq_uint(ABIAlign, PrefAlign)) : "Preferred alignment worse than ABI!";
    PointerAlignElem retval/*J*/= new PointerAlignElem();
    retval.AddressSpace = AddressSpace;
    retval.ABIAlign = ABIAlign;
    retval.PrefAlign = PrefAlign;
    retval.TypeByteWidth = TypeByteWidth;
    return retval;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerAlignElem::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 140,
   FQN="llvm::PointerAlignElem::operator==", NM="_ZNK4llvm16PointerAlignElemeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm16PointerAlignElemeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ PointerAlignElem /*&*/ rhs) /*const*/ {
    return (ABIAlign == rhs.ABIAlign
       && AddressSpace == rhs.AddressSpace
       && PrefAlign == rhs.PrefAlign
       && TypeByteWidth == rhs.TypeByteWidth);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerAlignElem::PointerAlignElem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 83,
   FQN="llvm::PointerAlignElem::PointerAlignElem", NM="_ZN4llvm16PointerAlignElemC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm16PointerAlignElemC1Ev")
  //</editor-fold>
  public /*inline*/ PointerAlignElem() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerAlignElem::PointerAlignElem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 83,
   FQN="llvm::PointerAlignElem::PointerAlignElem", NM="_ZN4llvm16PointerAlignElemC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm16PointerAlignElemC1EOS0_")
  //</editor-fold>
  public /*inline*/ PointerAlignElem(JD$Move _dparam, final PointerAlignElem /*&&*/$Prm0) {
    // : ABIAlign(static_cast<PointerAlignElem &&>().ABIAlign), PrefAlign(static_cast<PointerAlignElem &&>().PrefAlign), TypeByteWidth(static_cast<PointerAlignElem &&>().TypeByteWidth), AddressSpace(static_cast<PointerAlignElem &&>().AddressSpace) 
    //START JInit
    this.ABIAlign = $Prm0.ABIAlign;
    this.PrefAlign = $Prm0.PrefAlign;
    this.TypeByteWidth = $Prm0.TypeByteWidth;
    this.AddressSpace = $Prm0.AddressSpace;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerAlignElem::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 83,
   FQN="llvm::PointerAlignElem::operator=", NM="_ZN4llvm16PointerAlignElemaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm16PointerAlignElemaSEOS0_")
  //</editor-fold>
  public /*inline*/ PointerAlignElem /*&*/ $assignMove(final PointerAlignElem /*&&*/$Prm0) {
    this.ABIAlign = $Prm0.ABIAlign;
    this.PrefAlign = $Prm0.PrefAlign;
    this.TypeByteWidth = $Prm0.TypeByteWidth;
    this.AddressSpace = $Prm0.AddressSpace;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public PointerAlignElem(int ABIAlign, int PrefAlign, int TypeByteWidth, int AddressSpace) {
    this.ABIAlign = ABIAlign;
    this.PrefAlign = PrefAlign;
    this.TypeByteWidth = TypeByteWidth;
    this.AddressSpace = AddressSpace;
  }
  
  
  @Override
  public PointerAlignElem $assign(PointerAlignElem $Prm0) {
    this.ABIAlign = $Prm0.ABIAlign;
    this.PrefAlign = $Prm0.PrefAlign;
    this.TypeByteWidth = $Prm0.TypeByteWidth;
    this.AddressSpace = $Prm0.AddressSpace;
    return /*Deref*/this;
  }
  
  @Override
  public PointerAlignElem clone() {
    return new PointerAlignElem(this.ABIAlign, this.PrefAlign, this.TypeByteWidth, this.AddressSpace);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ABIAlign=" + ABIAlign // NOI18N
              + ", PrefAlign=" + PrefAlign // NOI18N
              + ", TypeByteWidth=" + TypeByteWidth // NOI18N
              + ", AddressSpace=" + AddressSpace; // NOI18N
  }
}
