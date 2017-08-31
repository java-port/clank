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
final class SmallVectorSLocEntry4RawIntArrays extends SmallVectorSLocEntry {

  private int[]  int_arrayRaw_Offsets;
  private int[]  int_arrayRaw_Union_IncludeLoc_or_SpellingLoc;
  private int[]  int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart;
  private int[]  int_arrayRaw_Union_Data_or_ExpansionLocEnd;

  protected SmallVectorSLocEntry4RawIntArrays(int capacity) {
    super(capacity);
    this.int_arrayRaw_Offsets = new$int(this.capacity);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = new$int(this.capacity);
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = new$int(this.capacity);
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = new$int(this.capacity);
  }
  
  
  @Override
  protected int clearImpl(int keepCapacity) {
    if (keepCapacity == 0) {
      keepCapacity = 1;
    }
    this.int_arrayRaw_Offsets = new$int(keepCapacity);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = new$int(keepCapacity);
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = new$int(keepCapacity);
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = new$int(keepCapacity);
    return keepCapacity;
  }

  @Override
  public /*size_t*/int capacity_in_bytes() {
    return 4*(capacity * NativeType.BYTES_IN_INT + NativeType.BYTES_IN_JAVA_ARRAY_HEADER);
  }

  @Override
  protected boolean isSlicedByOffsets() {
    return false;
  }

  @Override
  protected int $OffsetsMaxSliceIndex() {
    throw new UnsupportedOperationException("Not supported for this collection");
  }

  @Override
  protected int[] $OffsetsSliceByIndex(int slice) {
    throw new UnsupportedOperationException("Not supported for this collection");
  }

  @Override
  protected int $OffsetsSliceSize() {
    throw new UnsupportedOperationException("Not supported for this collection");
  }
  
  @Override
  protected int offset_$at(int[] Array, int origIdx) {
    return -1;
  }

  @Override
  protected int offset_$at(int[] Array, int origIdx, int slice, int idxInSlice) {
    return -1;
  }
    
  @Override
  protected SmallVectorSLocEntry grow() {
    int newCapacity = capacity() * 2;
    assert newCapacity > 0;
    if (SLICE_SLOC_ENTRY_ON_DEMAND && newCapacity > maxSliceCapacity) {
      SmallVectorSLocEntry other = new SmallVectorSLocEntry4SlicedRawIntArrays(this, 
              int_arrayRaw_Offsets, 
              int_arrayRaw_Union_IncludeLoc_or_SpellingLoc, 
              int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, 
              int_arrayRaw_Union_Data_or_ExpansionLocEnd);
      other = other.grow();
      if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
        if (NativeTrace.STAT_OUT_FOLDER == null) {
          System.err.println(this.getClass().getSimpleName() + " grown into new vector " + other.getClass().getSimpleName() + " with capacity " +
                  NativeTrace.formatNumber(other.capacity) + " vs. " + NativeTrace.formatNumber(int_arrayRaw_Offsets.length));
        }
      }      
      return other;
    } else {
      return this.grow(newCapacity);
    }
  }
  
  @Override
  protected SmallVectorSLocEntry grow(int newSize) {
    this.capacity = newSize;
    assert this.capacity > 0;
    if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
      if (NativeTrace.STAT_OUT_FOLDER == null) {
        System.err.println(this.getClass().getSimpleName() + " allocate 4 new arrays " + 
                NativeTrace.formatNumber(this.capacity*4/1024) + "K vs. " + NativeTrace.formatNumber(int_arrayRaw_Offsets.length*4/1024) + "K");        
      }
    }
    int_arrayRaw_Offsets = copyOf$int(int_arrayRaw_Offsets, this.capacity);
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = copyOf$int(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc, this.capacity);
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = copyOf$int(int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, this.capacity);
    int_arrayRaw_Union_Data_or_ExpansionLocEnd = copyOf$int(int_arrayRaw_Union_Data_or_ExpansionLocEnd, this.capacity);
    return this;
  }

  @Override
  protected int get_Raw_Offset(int origIdx) {
    return this.int_arrayRaw_Offsets[origIdx];
  }
    
  @Override
  protected int get_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx) { 
    return this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[origIdx];
  }
    
  @Override
  protected int get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx) {     
    return this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[origIdx];
  }

  @Override
  protected int get_Raw_Union_Data_or_ExpansionLocEnd(int origIdx) {  
    return this.int_arrayRaw_Union_Data_or_ExpansionLocEnd[origIdx];
  }

  @Override
  protected void set_Raw_Offset(int origIdx, int Value) {
    this.int_arrayRaw_Offsets[origIdx] = Value;
  }
    
  @Override
  protected void set_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx, int Value) {    
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[origIdx] = Value;
  }
    
  @Override
  protected void set_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx, int Value) {     
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[origIdx] = Value;
  }

  @Override
  protected void set_Raw_Union_Data_or_ExpansionLocEnd(int origIdx, int Value) {
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd[origIdx] = Value;
  }
  
  @Override
  protected void setImpl(int origIdx, int Raw_Offset, int Raw_Union_IncludeLoc_or_SpellingLoc, int Raw_Union_NumCreatedFIDs_or_ExpansionLocStart, int Raw_Union_Data_or_ExpansionLocEnd) {  
    int_arrayRaw_Offsets[origIdx] = Raw_Offset;
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc[origIdx] = Raw_Union_IncludeLoc_or_SpellingLoc;
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart[origIdx] = Raw_Union_NumCreatedFIDs_or_ExpansionLocStart;
    int_arrayRaw_Union_Data_or_ExpansionLocEnd[origIdx] = Raw_Union_Data_or_ExpansionLocEnd;
  }      
}
