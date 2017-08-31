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
package org.clang.basic;

import org.clank.support.Converted;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;

/**
 * SmallVectorImpl for SrcMgr.SLocEntry
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
final class SmallVectorSLocEntry4SlicedRawIntArrays extends SmallVectorSLocEntry3IntArrays {

  private int[][]  int_arrayRaw_Offsets;
  private int numUsedOffsetSlices;
  
  protected SmallVectorSLocEntry4SlicedRawIntArrays(/*uint*/int capacity) {
    super(capacity == 0 ? 1 : capacity);
    this.int_arrayRaw_Offsets = new$int_int$elem(new$int(this.capacity));
    numUsedOffsetSlices = this.int_arrayRaw_Offsets.length;
  }

  SmallVectorSLocEntry4SlicedRawIntArrays(SmallVectorSLocEntry3IntArrays raw, int[] Raw_Offsets) {
    super(raw);
    assert raw.capacity == Raw_Offsets.length : raw.capacity + " vs. " + Raw_Offsets.length;
    this.int_arrayRaw_Offsets = new$int_int$elem(Raw_Offsets);
    numUsedOffsetSlices = 1;
  }

  public SmallVectorSLocEntry4SlicedRawIntArrays(SmallVectorSLocEntry other, 
          int[] Raw_Offsets,
          int[] int_arrayRaw_Union_IncludeLoc_or_SpellingLoc,
          int[] int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, 
          int[] int_arrayRaw_Union_Data_or_ExpansionLocEnd) {
    super(other, int_arrayRaw_Union_IncludeLoc_or_SpellingLoc, int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, int_arrayRaw_Union_Data_or_ExpansionLocEnd);
    assert other.capacity == Raw_Offsets.length : other.capacity + " vs. " + Raw_Offsets.length;
    this.int_arrayRaw_Offsets = new$int_int$elem(Raw_Offsets);
    numUsedOffsetSlices = 1;
  }  
  
  public void $destroy() {
  }

  public /*size_t*/int capacity_in_bytes() {
    return 4*(capacity * NativeType.BYTES_IN_INT + NativeType.BYTES_IN_JAVA_ARRAY_HEADER);
  }

  @Override
  protected boolean isSlicedByOffsets() {
    return true;
  }

  @Override
  protected int[] $OffsetsSliceByIndex(int slice) {
    return this.int_arrayRaw_Offsets[slice];
  }

  @Override
  protected int $OffsetsMaxSliceIndex() {
    return size() == 0 ? 0 : getSlice(size()-1);
  }

  @Override
  protected int $OffsetsSliceSize() {
    return this.int_arrayRaw_Offsets[0].length;
  }

  @Override
  protected int offset_$at(int[] Array, int origIdx) {
    return SrcMgr.SLocEntry.toOffset(Array[getIndex(origIdx)]);
  }

  @Override
  protected int offset_$at(int[] Array, int origIdx, int slice, int idxInSlice) {
    assert this.int_arrayRaw_Offsets[slice] == Array;
    return SrcMgr.SLocEntry.toOffset(Array[getIndex(idxInSlice)]);
  }
    
  @Override
  protected final int clearRawOffsetsImpl(int keepCapacity) {
    if (keepCapacity == 0) {
      keepCapacity = 1;
    }    
    int_arrayRaw_Offsets = new$int_int$elem(new$int(keepCapacity));
    numUsedOffsetSlices = this.int_arrayRaw_Offsets.length;
    return keepCapacity;
  }
  
  @Override
  protected final SmallVectorSLocEntry growRawOffsetsImpl(int newSize) {
    this.capacity = newSize;
    assert this.capacity > 0;
    assert numUsedOffsetSlices > 0;
    assert (this.capacity <= maxSliceCapacity) || (this.capacity & maskForIndex) == 0 : "must have trailing zeros " + this.capacity;
    int newNumSlices;
    int sliceCapacity;
    // one slice or multiple slices
    if (this.capacity <= maxSliceCapacity) {
      newNumSlices = 1;
      sliceCapacity = this.capacity;
      // expand zeor slice
      int slice = 0;
      assert (int_arrayRaw_Offsets[slice].length < sliceCapacity);
      assert (sliceCapacity <= maxSliceCapacity);
      int_arrayRaw_Offsets[slice] = copyOf$int(int_arrayRaw_Offsets[slice], sliceCapacity);
    } else {
      // expand slices if needed
      newNumSlices = getSlice(this.capacity-1) + 1;
      assert newNumSlices > 1;
      sliceCapacity = maxSliceCapacity;
      int ActualNumSlices = int_arrayRaw_Offsets.length;
      if (ActualNumSlices < newNumSlices) {
        // new slices are required
        ActualNumSlices *= 2;        
        if (ActualNumSlices < newNumSlices) {
          ActualNumSlices = newNumSlices;
        }        
        if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
          if (NativeTrace.STAT_OUT_FOLDER == null) {
            System.err.println(this.getClass().getSimpleName() + " increase number of OFFSET slice containers " + 
                    NativeTrace.formatNumber(ActualNumSlices) + " vs. " + NativeTrace.formatNumber(int_arrayRaw_Offsets.length));
          }
        }
        // new slices are required
        int_arrayRaw_Offsets = copyOf$int_int(int_arrayRaw_Offsets, ActualNumSlices);
      }
    }
    // change the last slice or add extra slices
    if (newNumSlices > numUsedOffsetSlices) {
      if (NativeTrace.isDebugMode()) {
        for (int slice = 0; slice < numUsedOffsetSlices; slice++) {
          assert int_arrayRaw_Offsets[slice].length == maxSliceCapacity;
        }
        int oneSlizeK = NativeType.BYTES_IN_INT*maxSliceCapacity/1024;
        if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
          if (NativeTrace.STAT_OUT_FOLDER == null) {
            System.err.println(this.getClass().getSimpleName() + " allocate new OFFSET slices " +
                    NativeTrace.formatNumber(newNumSlices) + " vs. " + NativeTrace.formatNumber(numUsedOffsetSlices) +
                    " allocating " + NativeTrace.formatNumber(oneSlizeK * (newNumSlices - numUsedOffsetSlices)) +
                    "K: slice is " + NativeTrace.formatNumber(oneSlizeK) + "K");
          }
        }
      }      
      // add extra slices with known max capacity
      for (int slice = numUsedOffsetSlices; slice < newNumSlices; slice++) {
        assert sliceCapacity == maxSliceCapacity;
        assert int_arrayRaw_Offsets[slice] == null;
        int_arrayRaw_Offsets[slice] = new$int(maxSliceCapacity);
      }
    }
    if (NativeTrace.isDebugMode()) {
      int size = 0;
      int slice = 0;
      for (; slice < newNumSlices; slice++) {
        assert int_arrayRaw_Offsets[slice].length <= maxSliceCapacity;
        assert (slice == 0) || (int_arrayRaw_Offsets[slice].length == maxSliceCapacity);
        size += int_arrayRaw_Offsets[slice].length;
      }
      for (;slice < int_arrayRaw_Offsets.length; slice++) {
        assert int_arrayRaw_Offsets[slice] == null;
      }      
      assert size == this.capacity : size + " vs. " + this.capacity;
    }
    numUsedOffsetSlices = newNumSlices;
    return this;
  }

  @Override
  protected final int get_Raw_Offset(int origIdx) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);
    return this.int_arrayRaw_Offsets[slice][idx];
  }

  @Override
  protected final void set_Raw_Offset(int origIdx, int Value) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);
    this.int_arrayRaw_Offsets[slice][idx] = Value;
  }  
}
