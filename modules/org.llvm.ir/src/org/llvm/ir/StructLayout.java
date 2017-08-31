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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;


/// Used to lazily calculate structure layout information for a target machine,
/// based on the DataLayout structure.
//<editor-fold defaultstate="collapsed" desc="llvm::StructLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 473,
 FQN="llvm::StructLayout", NM="_ZN4llvm12StructLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm12StructLayoutE")
//</editor-fold>
public class StructLayout {
  private long/*uint64_t*/ StructSize;
  private /*uint*/int StructAlignment;
  private /*JBIT unsigned int*/ boolean IsPadded /*: 1*/;
  private /*uint*/int NumElements /*: 31*/;
  private long/*uint64_t*/ MemberOffsets[/*1*/] = new$ulong(1); // variable sized array!
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::getSizeInBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 480,
   FQN="llvm::StructLayout::getSizeInBytes", NM="_ZNK4llvm12StructLayout14getSizeInBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout14getSizeInBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getSizeInBytes() /*const*/ {
    return StructSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::getSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 482,
   FQN="llvm::StructLayout::getSizeInBits", NM="_ZNK4llvm12StructLayout13getSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout13getSizeInBitsEv")
  //</editor-fold>
  public long/*uint64_t*/ getSizeInBits() /*const*/ {
    return $int2ullong(8) * StructSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 484,
   FQN="llvm::StructLayout::getAlignment", NM="_ZNK4llvm12StructLayout12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return StructAlignment;
  }

  
  /// Returns whether the struct has padding or not between its fields.
  /// NB: Padding in nested element is not taken into account.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::hasPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 488,
   FQN="llvm::StructLayout::hasPadding", NM="_ZNK4llvm12StructLayout10hasPaddingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout10hasPaddingEv")
  //</editor-fold>
  public boolean hasPadding() /*const*/ {
    return IsPadded;
  }

  
  /// \brief Given a valid byte offset into the structure, returns the structure
  /// index that contains it.
  
  /// getElementContainingOffset - Given a valid offset into the structure,
  /// return the structure index that contains it.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::getElementContainingOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 79,
   FQN="llvm::StructLayout::getElementContainingOffset", NM="_ZNK4llvm12StructLayout26getElementContainingOffsetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout26getElementContainingOffsetEy")
  //</editor-fold>
  public /*uint*/int getElementContainingOffset(long/*uint64_t*/ Offset) /*const*/ {
    ulong$ptr tmp = create_ulong$ptr(MemberOffsets);
    /*const*/ulong$ptr/*uint64_t P*/ SI = $tryClone(std.upper_bound_ulong(tmp, tmp.$add(NumElements), Offset));
    assert ($noteq_ptr(SI, $AddrOf(MemberOffsets[0]))) : "Offset not in structure type!";
    SI.$preDec();
    assert ($lesseq_ulong(SI.$star(), Offset)) : "upper_bound didn't work";
    assert (($eq_ptr(SI, $AddrOf(MemberOffsets[0])) || $lesseq_ulong((SI.$sub(1)).$star(), Offset)) && ($eq_ptr(SI.$add(1), $AddrOf(MemberOffsets[NumElements])) || $greater_ulong((SI.$add(1)).$star(), Offset))) : "Upper bound didn't work!";
    
    // Multiple fields can have the same offset if any of them are zero sized.
    // For example, in { i32, [0 x i32], i32 }, searching for offset 4 will stop
    // at the i32 element, because it is the last element at that offset.  This is
    // the right one to return, because anything after it will have a higher
    // offset, implying that this element is non-empty.
    return SI.$sub(tmp);//$AddrOf(MemberOffsets[0]));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::getElementOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 494,
   FQN="llvm::StructLayout::getElementOffset", NM="_ZNK4llvm12StructLayout16getElementOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout16getElementOffsetEj")
  //</editor-fold>
  public long/*uint64_t*/ getElementOffset(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, NumElements)) : "Invalid element idx!";
    return MemberOffsets[Idx];
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::getElementOffsetInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 499,
   FQN="llvm::StructLayout::getElementOffsetInBits", NM="_ZNK4llvm12StructLayout22getElementOffsetInBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm12StructLayout22getElementOffsetInBitsEj")
  //</editor-fold>
  public long/*uint64_t*/ getElementOffsetInBits(/*uint*/int Idx) /*const*/ {
    return getElementOffset(Idx) * $int2ullong(8);
  }

/*private:*/
  /*friend  class DataLayout*/ // Only DataLayout can create this class
  
  //===----------------------------------------------------------------------===//
  // Support for StructLayout
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::StructLayout::StructLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 40,
   FQN="llvm::StructLayout::StructLayout", NM="_ZN4llvm12StructLayoutC1EPNS_10StructTypeERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm12StructLayoutC1EPNS_10StructTypeERKNS_10DataLayoutE")
  //</editor-fold>
  /*friend*//*private*/ StructLayout(final type$ref Java$SL, type$ptr Java$This, StructType /*P*/ ST, final /*const*/ DataLayout /*&*/ DL) {
    // JAVA: see llvm::DataLayout::getStructLayout
    $this = $toConst(Java$This);
    $this.$set(this);
    Java$SL.$set(this);
    
    assert (!ST.isOpaque()) : "Cannot get layout of opaque structs";
    StructAlignment = 0;
    StructSize = $int2ulong(0);
    IsPadded = false;
    NumElements = ST.getNumElements();
    
    //JAVA: init array
    MemberOffsets = new$ulong(NumElements);
    // Loop over each of the elements, placing them in memory.
    for (/*uint*/int i = 0, e = NumElements; i != e; ++i) {
      Type /*P*/ Ty = ST.getElementType(i);
      /*uint*/int TyAlign = ST.isPacked() ? 1 : DL.getABITypeAlignment(Ty);
      
      // Add padding if necessary to align the data element properly.
      if ((StructSize & $uint2ullong((TyAlign - 1))) != $int2ullong(0)) {
        IsPadded = true;
        StructSize = alignTo(StructSize, $uint2ulong(TyAlign));
      }
      
      // Keep track of maximum alignment constraint.
      StructAlignment = std.max(TyAlign, StructAlignment);
      
      MemberOffsets[i] = StructSize;
      StructSize += DL.getTypeAllocSize(Ty); // Consume space for this data item
    }
    
    // Empty structures have alignment of 1 byte.
    if (StructAlignment == 0) {
      StructAlignment = 1;
    }
    
    // Add padding to the end of the struct so that it could be put in an array
    // and all array elements would be aligned correctly.
    if ((StructSize & $uint2ullong((StructAlignment - 1))) != $int2ullong(0)) {
      IsPadded = true;
      StructSize = alignTo(StructSize, $uint2ulong(StructAlignment));
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr $this;
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "StructSize=" + StructSize // NOI18N
              + ", StructAlignment=" + StructAlignment // NOI18N
              + ", IsPadded=" + IsPadded // NOI18N
              + ", NumElements=" + NumElements // NOI18N
              + ", MemberOffsets=" + MemberOffsets; // NOI18N
  }
}
