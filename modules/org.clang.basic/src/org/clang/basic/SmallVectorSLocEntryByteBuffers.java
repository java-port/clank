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

import java.nio.ByteBuffer;
import org.clank.support.Converted;
import org.clank.support.*;
import org.llvm.support.llvm;

/**
 * SmallVectorImpl for SrcMgr.SLocEntry
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
final class SmallVectorSLocEntryByteBuffers extends SmallVectorSLocEntry {

  private ByteBuffer  int_arrayRaw_Offsets;
  private ByteBuffer  int_arrayRaw_Union_IncludeLoc_or_SpellingLoc;
  private ByteBuffer  int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart;
  private ByteBuffer  int_arrayRaw_Union_Data_or_ExpansionLocEnd;

  protected SmallVectorSLocEntryByteBuffers(/*uint*/int capacity) {
    super(capacity);
    int newSizeInBytes = (int)capacity*NativeType.BYTES_IN_INT;
    this.int_arrayRaw_Offsets = copyBytes(null, newSizeInBytes);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = copyBytes(null, newSizeInBytes);
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = copyBytes(null, newSizeInBytes);
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = copyBytes(null, newSizeInBytes);
  }
  
  @Override
  protected int clearImpl(int keepCapacity) {
    releaseBuffers();
    int newSizeInBytes = keepCapacity*NativeType.BYTES_IN_INT;
    this.int_arrayRaw_Offsets = ByteBuffer.allocateDirect(newSizeInBytes);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = ByteBuffer.allocateDirect(newSizeInBytes);
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = ByteBuffer.allocateDirect(newSizeInBytes);
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd = ByteBuffer.allocateDirect(newSizeInBytes);
    return keepCapacity;
  }

  private void releaseBuffers() {
    ByteUtils.releaseDirectByteBuffer(int_arrayRaw_Offsets);
    int_arrayRaw_Offsets = null;
    ByteUtils.releaseDirectByteBuffer(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc);
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = null;
    ByteUtils.releaseDirectByteBuffer(int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart);
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = null;
    ByteUtils.releaseDirectByteBuffer(int_arrayRaw_Union_Data_or_ExpansionLocEnd);
    int_arrayRaw_Union_Data_or_ExpansionLocEnd = null;
  }
    
  public void $destroy() {
    releaseBuffers();
  }
  
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
  protected SmallVectorSLocEntry grow(int newSize) {
//    assert this.capacity == (int_arrayRaw_Offsets.remaining()/4) : (int_arrayRaw_Offsets.remaining()/4) + " vs. " + this.capacity;
    this.capacity = newSize;
    assert this.capacity > 0;

    int newSizeInBytes = capacity*NativeType.BYTES_IN_INT;
    int_arrayRaw_Offsets = copyBytes(int_arrayRaw_Offsets, newSizeInBytes);
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc = copyBytes(int_arrayRaw_Union_IncludeLoc_or_SpellingLoc, newSizeInBytes);
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart = copyBytes(int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart, newSizeInBytes);
    int_arrayRaw_Union_Data_or_ExpansionLocEnd = copyBytes(int_arrayRaw_Union_Data_or_ExpansionLocEnd, newSizeInBytes);
    return this;
  }

  private ByteBuffer copyBytes(ByteBuffer orig, int newSizeInBytes) {
    ByteBuffer NewBuffer;
    try {
      NewBuffer = ByteBuffer.allocateDirect(newSizeInBytes);
    } catch (OutOfMemoryError e) {
      llvm.errs().$out("Can not allocate new direct buffer for size " + NativeTrace.formatNumber(newSizeInBytes));
      NewBuffer = ByteBuffer.allocate(newSizeInBytes);
    }
    if (orig != null) {
      for (int i = 0; i < orig.capacity(); i++) {        
        NewBuffer.put(i, orig.get(i));
      }
      assert NewBuffer.position() == 0;
      ByteUtils.releaseDirectByteBuffer(orig);
    }
    return NewBuffer;
  }

  @Override
  protected int get_Raw_Offset(int origIdx) {
    origIdx = toIntIndex(origIdx);
    return this.int_arrayRaw_Offsets.getInt(origIdx);
  }
    
  @Override
  protected int get_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx) { 
    origIdx = toIntIndex(origIdx);
    return this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.getInt(origIdx);
  }
    
  @Override
  protected int get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx) {     
    origIdx = toIntIndex(origIdx);    
    return this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart.getInt(origIdx);
  }

  @Override
  protected int get_Raw_Union_Data_or_ExpansionLocEnd(int origIdx) {  
    origIdx = toIntIndex(origIdx);
    return this.int_arrayRaw_Union_Data_or_ExpansionLocEnd.getInt(origIdx);
  }

  @Override
  protected void set_Raw_Offset(int origIdx, int Value) {
    origIdx = toIntIndex(origIdx);
    this.int_arrayRaw_Offsets.putInt(origIdx, Value);
  }
    
  @Override
  protected void set_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx, int Value) {    
    origIdx = toIntIndex(origIdx);
    this.int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.putInt(origIdx, Value);
  }
    
  @Override
  protected void set_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx, int Value) {     
    origIdx = toIntIndex(origIdx);
    this.int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart.putInt(origIdx, Value);
  }

  @Override
  protected void set_Raw_Union_Data_or_ExpansionLocEnd(int origIdx, int Value) {
    origIdx = toIntIndex(origIdx);
    this.int_arrayRaw_Union_Data_or_ExpansionLocEnd.putInt(origIdx, Value);
  }
  
  @Override
  protected void setImpl(int origIdx, int Raw_Offset, int Raw_Union_IncludeLoc_or_SpellingLoc, int Raw_Union_NumCreatedFIDs_or_ExpansionLocStart, int Raw_Union_Data_or_ExpansionLocEnd) {  
    origIdx = toIntIndex(origIdx);
    int_arrayRaw_Offsets.putInt(origIdx, Raw_Offset);
    int_arrayRaw_Union_IncludeLoc_or_SpellingLoc.putInt(origIdx, Raw_Union_IncludeLoc_or_SpellingLoc);
    int_arrayRaw_Union_NumCreatedFIDs_or_ExpansionLocStart.putInt(origIdx, Raw_Union_NumCreatedFIDs_or_ExpansionLocStart);
    int_arrayRaw_Union_Data_or_ExpansionLocEnd.putInt(origIdx, Raw_Union_Data_or_ExpansionLocEnd);
  }    
  
  private int toIntIndex(int origIdx) {
    return origIdx*NativeType.BYTES_IN_INT;
  }
}
