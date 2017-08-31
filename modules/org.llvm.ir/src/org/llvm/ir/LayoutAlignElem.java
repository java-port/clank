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
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


// FIXME: Currently the DataLayout string carries a "preferred alignment"
// for types. As the DataLayout is module/global, this should likely be
// sunk down to an FTTI element that is queried rather than a global
// preference.

/// \brief Layout alignment element.
///
/// Stores the alignment data associated with a given alignment type (integer,
/// vector, float) and type bit width.
///
/// \note The unusual order of elements in the structure attempts to reduce
/// padding and make the structure slightly more cache friendly.
//<editor-fold defaultstate="collapsed" desc="llvm::LayoutAlignElem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 65,
 FQN="llvm::LayoutAlignElem", NM="_ZN4llvm15LayoutAlignElemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm15LayoutAlignElemE")
//</editor-fold>
public class/*struct*/ LayoutAlignElem implements NativeCloneable<LayoutAlignElem>, Native.NativeComparable<LayoutAlignElem> {
  /// \brief Alignment type from \c AlignTypeEnum
  public /*JBYTE unsigned int*/ byte AlignType /*: 8*/;
  public /*uint*/int TypeBitWidth /*: 24*/;
  public /*JCHAR unsigned int*/ char ABIAlign /*: 16*/;
  public /*JCHAR unsigned int*/ char PrefAlign /*: 16*/;
  
  
  //===----------------------------------------------------------------------===//
  // LayoutAlignElem, LayoutAlign support
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::LayoutAlignElem::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 101,
   FQN="llvm::LayoutAlignElem::get", NM="_ZN4llvm15LayoutAlignElem3getENS_13AlignTypeEnumEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm15LayoutAlignElem3getENS_13AlignTypeEnumEjjj")
  //</editor-fold>
  public static LayoutAlignElem get(/*AlignTypeEnum*/byte align_type, /*uint*/int abi_align, 
     /*uint*/int pref_align, /*uint32_t*/int bit_width) {
    assert ($lesseq_uint(abi_align, pref_align)) : "Preferred alignment worse than ABI!";
    LayoutAlignElem retval/*J*/= new LayoutAlignElem();
    retval.AlignType = $uint2uint_8bits(align_type);
    retval.ABIAlign = $uint2uint_16bits(abi_align);
    retval.PrefAlign = $uint2uint_16bits(pref_align);
    retval.TypeBitWidth = bit_width;
    return retval;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LayoutAlignElem::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 113,
   FQN="llvm::LayoutAlignElem::operator==", NM="_ZNK4llvm15LayoutAlignElemeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm15LayoutAlignElemeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ LayoutAlignElem /*&*/ rhs) /*const*/ {
    return ($8bits_uint2uint(AlignType) == $8bits_uint2uint(rhs.AlignType)
       && $16bits_uint2uint(ABIAlign) == $16bits_uint2uint(rhs.ABIAlign)
       && $16bits_uint2uint(PrefAlign) == $16bits_uint2uint(rhs.PrefAlign)
       && TypeBitWidth == rhs.TypeBitWidth);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LayoutAlignElem::LayoutAlignElem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 65,
   FQN="llvm::LayoutAlignElem::LayoutAlignElem", NM="_ZN4llvm15LayoutAlignElemC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm15LayoutAlignElemC1Ev")
  //</editor-fold>
  public /*inline*/ LayoutAlignElem() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LayoutAlignElem::LayoutAlignElem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 65,
   FQN="llvm::LayoutAlignElem::LayoutAlignElem", NM="_ZN4llvm15LayoutAlignElemC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm15LayoutAlignElemC1EOS0_")
  //</editor-fold>
  public /*inline*/ LayoutAlignElem(JD$Move _dparam, final LayoutAlignElem /*&&*/$Prm0) {
    // : AlignType(static_cast<LayoutAlignElem &&>().AlignType), TypeBitWidth(static_cast<LayoutAlignElem &&>().TypeBitWidth), ABIAlign(static_cast<LayoutAlignElem &&>().ABIAlign), PrefAlign(static_cast<LayoutAlignElem &&>().PrefAlign) 
    //START JInit
    this.AlignType = $uint2uint_8bits($8bits_uint2uint($Prm0.AlignType));
    this.TypeBitWidth = $Prm0.TypeBitWidth;
    this.ABIAlign = $uint2uint_16bits($16bits_uint2uint($Prm0.ABIAlign));
    this.PrefAlign = $uint2uint_16bits($16bits_uint2uint($Prm0.PrefAlign));
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public LayoutAlignElem(byte AlignType, int TypeBitWidth, char ABIAlign, char PrefAlign) {
    this.AlignType = AlignType;
    this.TypeBitWidth = TypeBitWidth;
    this.ABIAlign = ABIAlign;
    this.PrefAlign = PrefAlign;
  }
  
  public LayoutAlignElem(byte AlignType, int TypeBitWidth, int ABIAlign, int PrefAlign) {
    this(AlignType, TypeBitWidth, $uint2ushort(ABIAlign), $uint2ushort(PrefAlign));
  }
  
  @Override
  public LayoutAlignElem clone() {
    return new LayoutAlignElem(this.AlignType, this.TypeBitWidth, this.ABIAlign, this.PrefAlign);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AlignType=" + $uchar2uint(AlignType) // NOI18N
              + ", TypeBitWidth=" + TypeBitWidth // NOI18N
              + ", ABIAlign=" + $ushort2uint(ABIAlign) // NOI18N
              + ", PrefAlign=" + $ushort2uint(PrefAlign); // NOI18N
  }
}
