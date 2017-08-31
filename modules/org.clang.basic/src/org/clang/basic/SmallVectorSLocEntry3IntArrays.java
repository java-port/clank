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
abstract class SmallVectorSLocEntry3IntArrays extends SmallVectorSLocEntry {
// This is extracted from SmallVectorSLocEntry3SlicedRawIntArraysAndPlainOffsets
// by moving common logic into base class
  private int[][]  int_arrayRaw_Union_IncludeLoc_or_SpellingLoc;
  private int[][]  int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart;
  private int[][]  int_arrayRaw_Union_Data_or_ExpansionLocEnd;
  private int numUsedSlices;

  public SmallVectorSLocEntry3IntArrays(SmallVectorSLocEntry other, int[] int_arrayRaw_Union_IncludeLoc_or_SpellingLoc,
          int[] int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, 
          int[] int_arrayRaw_Union_Data_or_ExpansionLocEnd) {
    super(other);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = new$int_int$elem(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc);
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = new$int_int$elem(int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart);
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = new$int_int$elem(int_arrayRaw_Union_Data_or_ExpansionLocEnd);
    this.numUsedSlices = 1;
  }
  

  
  SmallVectorSLocEntry3IntArrays(SmallVectorSLocEntry3IntArrays other) {
    super(other);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = other.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc;
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = other.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart;
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = other.int_arrayRaw_Union_Data_or_ExpansionLocEnd;
    numUsedSlices = other.numUsedSlices;
  }

  protected SmallVectorSLocEntry3IntArrays(/*uint*/int capacity) {
    super(capacity == 0 ? 1 : capacity);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = new$int_int$elem(new$int(this.capacity));
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = new$int_int$elem(new$int(this.capacity));
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = new$int_int$elem(new$int(this.capacity));
    numUsedSlices = this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.length;
  }

  @Override
  protected final int clearImpl(int keepCapacity) {
    if (keepCapacity == 0) {
      keepCapacity = 1;
    }
    keepCapacity = clearRawOffsetsImpl(keepCapacity);
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = new$int_int$elem(new$int(keepCapacity));
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = new$int_int$elem(new$int(keepCapacity));
    int_arrayRaw_Union_Data_or_ExpansionLocEnd = new$int_int$elem(new$int(keepCapacity));
    numUsedSlices = this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.length;
    return keepCapacity;
  }
    
  @Override
  public void $destroy() {
  }
  
  @Override
  public /*size_t*/int capacity_in_bytes() {
    return 3*(capacity * NativeType.BYTES_IN_INT + NativeType.BYTES_IN_JAVA_ARRAY_HEADER);
  }
  
  @Override
  protected SmallVectorSLocEntry grow() {
    int curCapacity = capacity();
    assert curCapacity > 0;
    if (curCapacity < maxSliceCapacity) {
      return this.grow(curCapacity * 2);
    } else {
      return this.grow(curCapacity + maxSliceCapacity);
    }
  }
  
  @Override
  protected final SmallVectorSLocEntry grow(int newSize) {
    SmallVectorSLocEntry vector = growRawOffsetsImpl(newSize);
    if (vector != this) {
      return vector;
    }
    this.capacity = vector.capacity;
    assert this.capacity > 0;
    assert numUsedSlices > 0;
    assert (this.capacity <= maxSliceCapacity) || (this.capacity & maskForIndex) == 0 : "must have trailing zeros " + this.capacity;
    int newNumSlices;
    int sliceCapacity;
    // one slice or multiple slices
    if (this.capacity <= maxSliceCapacity) {
      newNumSlices = 1;
      sliceCapacity = this.capacity;
      // expand zero slice
      int slice = 0;
      assert (sliceCapacity <= maxSliceCapacity);
      int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice] = copyOf$int(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice], sliceCapacity);
      int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice] = copyOf$int(int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice], sliceCapacity);
      int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice] = copyOf$int(int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice], sliceCapacity);
    } else {
      // expand slices if needed
      newNumSlices = getSlice(this.capacity-1) + 1;
      assert newNumSlices > 1;
      sliceCapacity = maxSliceCapacity;
      int ActualNumSlices = int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.length;
      if (ActualNumSlices < newNumSlices) {
        // new slices are required
        ActualNumSlices *= 2;        
        if (ActualNumSlices < newNumSlices) {
          ActualNumSlices = newNumSlices;
        }
        if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
          if (NativeTrace.STAT_OUT_FOLDER == null) {
            System.err.println(this.getClass().getSimpleName() + " increase number of DATA slice containers " + 
                    NativeTrace.formatNumber(ActualNumSlices) + " vs. " + NativeTrace.formatNumber(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.length));
          }
        }
        int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = copyOf$int_int(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc, ActualNumSlices);
        int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = copyOf$int_int(int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, ActualNumSlices);
        int_arrayRaw_Union_Data_or_ExpansionLocEnd = copyOf$int_int(int_arrayRaw_Union_Data_or_ExpansionLocEnd, ActualNumSlices);
      }
    }
    // change the last slice or add extra slices
    if (newNumSlices > numUsedSlices) {
      if (NativeTrace.isDebugMode()) {
        for (int slice = 0; slice < numUsedSlices; slice++) {
          assert int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice].length == maxSliceCapacity;
          assert int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice].length == maxSliceCapacity;
          assert int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice].length == maxSliceCapacity;
        }
        if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
          if (NativeTrace.STAT_OUT_FOLDER == null) {
            int oneSlizeK = NativeType.BYTES_IN_INT*maxSliceCapacity/1024;
            System.err.println(this.getClass().getSimpleName() + " allocate new DATA slices " +
                    NativeTrace.formatNumber(newNumSlices) + " vs. " + NativeTrace.formatNumber(numUsedSlices) +
                    " allocating " + NativeTrace.formatNumber(3 * oneSlizeK * (newNumSlices - numUsedSlices)) +
                    "K: slice is " + NativeTrace.formatNumber(oneSlizeK) + "K");
          }
        }
      }      
      // add extra slices with known max capacity
      for (int slice = numUsedSlices; slice < newNumSlices; slice++) {
        assert sliceCapacity == maxSliceCapacity;
        assert int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice] == null;
        assert int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice] == null;
        assert int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice] == null;
        int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice] = new$int(maxSliceCapacity);
        int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice] = new$int(maxSliceCapacity);
        int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice] = new$int(maxSliceCapacity);
      }
    }
    if (NativeTrace.isDebugMode()) {
      int size = 0;
      int slice = 0;
      for (; slice < newNumSlices; slice++) {
        assert int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice].length <= maxSliceCapacity;
        assert (slice == 0) || (int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice].length == maxSliceCapacity);
        size += int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice].length;
      }
      for (;slice < int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.length; slice++) {
        assert int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice] == null;
        assert int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice] == null;
        assert int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice] == null;
      }
      assert size == this.capacity : size + " vs. " + this.capacity;
    }
    numUsedSlices = newNumSlices;
    return this;
  }

  abstract int clearRawOffsetsImpl(int keepCapacity);

  abstract SmallVectorSLocEntry growRawOffsetsImpl(int newSize);
  
  @Override
  protected abstract int get_Raw_Offset(int origIdx);

  @Override
  protected abstract void set_Raw_Offset(int origIdx, int Value);
    
  @Override
  protected final int get_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    return this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice][idx];
  }
    
  @Override
  protected final int get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    return this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice][idx];
  }

  @Override
  protected final int get_Raw_Union_Data_or_ExpansionLocEnd(int origIdx) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    return this.int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice][idx];
  }
  @Override
  protected final void set_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx, int Value) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice][idx] = Value;
  }
    
  @Override
  protected final void set_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx, int Value) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice][idx] = Value;
  }

  @Override
  protected final void set_Raw_Union_Data_or_ExpansionLocEnd(int origIdx, int Value) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice][idx] = Value;
  }
  
  @Override
  protected final void setImpl(int origIdx, int Raw_Offset, int Raw_Union_IncludeLoc_or_SpellingLoc, int Raw_Union_NumCreatedFIDs_or_ExpansionLocStart, int Raw_Union_Data_or_ExpansionLocEnd) {
    int slice = getSlice(origIdx);
    int idx = getIndex(origIdx);       
    set_Raw_Offset(origIdx, Raw_Offset);
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[slice][idx] = Raw_Union_IncludeLoc_or_SpellingLoc;
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[slice][idx] = Raw_Union_NumCreatedFIDs_or_ExpansionLocStart;
    int_arrayRaw_Union_Data_or_ExpansionLocEnd[slice][idx] = Raw_Union_Data_or_ExpansionLocEnd;
  }  
}
