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

import static org.clang.basic.BasicClangGlobals.wrap_SourceLocation_SourceLocation;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

/**
 * SmallVectorImpl for SrcMgr.SLocEntry
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
abstract class SmallVectorSLocEntry implements NativeType.SizeofCapable, Destructors.ClassWithDestructor {
  private static boolean tracedEntryTables = false;

  protected int end;
  protected int capacity;
  protected final int maxSliceCapacity;
  protected final int maskForIndex;
  protected final int shiftForSlice;
  protected static final int DEFAULT_SLICE_SHIFT = Integer.getInteger("clank.slices.shift", 16); /*16 is 256K*/
  protected static final int DEFAULT_MAX_SLICE_CAPACITY = 1<<DEFAULT_SLICE_SHIFT; /*48K integers is 256K memory*/
  protected static final boolean SLICE_SLOC_ENTRY_ON_DEMAND = Boolean.parseBoolean(System.getProperty("clank.slice.on.demand", "true"));
  
  static {
    assert (DEFAULT_MAX_SLICE_CAPACITY & (DEFAULT_MAX_SLICE_CAPACITY-1)) == 0 : "must be power of two " + DEFAULT_MAX_SLICE_CAPACITY;
  }
  
  SmallVectorSLocEntry(SmallVectorSLocEntry other) {
    this.capacity = other.capacity;
    this.end = other.end;
    this.shiftForSlice = other.shiftForSlice;
    this.maxSliceCapacity = other.maxSliceCapacity;
    if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
      if (!tracedEntryTables) {
        tracedEntryTables = true;
        if (NativeTrace.STAT_OUT_FOLDER == null) {
          llvm.errs().$out("created ").$out(this.getClass().getSimpleName());
          llvm.errs().$out(" with max slice ").$out(NativeTrace.formatNumber((NativeType.BYTES_IN_INT * maxSliceCapacity)/1024)).$out("K\n");
        }
      }
    }
    assert (maxSliceCapacity & (maxSliceCapacity - 1)) == 0  : "not a power of two " + maxSliceCapacity;
    this.maskForIndex = other.maskForIndex;
    assert capacity <= maxSliceCapacity;
  }
  
  protected SmallVectorSLocEntry(/*uint*/int capacity) {
    this.capacity = (int) capacity;
    this.end = 0;
    if (capacity <= DEFAULT_MAX_SLICE_CAPACITY) {
      shiftForSlice = DEFAULT_SLICE_SHIFT;
    } else {
      int shift = DEFAULT_SLICE_SHIFT + 1;
      for (; shift < 31; shift++) {      
        if (capacity <= (1<<shift)) {
          break;
        }
      }
      shiftForSlice = shift;
    }
    maxSliceCapacity = 1 << shiftForSlice;
    if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
      if (!tracedEntryTables) {
        tracedEntryTables = true;
        if (NativeTrace.STAT_OUT_FOLDER == null) {
          llvm.errs().$out("created ").$out(this.getClass().getSimpleName());
          llvm.errs().$out(" with max slice ").$out(NativeTrace.formatNumber((NativeType.BYTES_IN_INT * maxSliceCapacity)/1024)).$out("K\n");
        }
      }
    }
    assert (maxSliceCapacity & (maxSliceCapacity - 1)) == 0  : "not a power of two " + maxSliceCapacity;
    maskForIndex = maxSliceCapacity - 1;
    assert capacity <= maxSliceCapacity;
  }
  
  public final SmallVectorSLocEntry resize(int newSize) {
    SmallVectorSLocEntry grown = this;
    if (newSize > this.capacity) {
      grown = this.grow(newSize);
    }
    grown.end = newSize;
    return grown;
  }  

  public final SmallVectorSLocEntry reserve(int N) {
    SmallVectorSLocEntry grown = this;
    if (this.capacity < N)
      grown = this.grow(N);
    return grown;
  }  
  
  public final SrcMgr.SLocEntry $at(int origIdx) {
    return SrcMgr.SLocEntry.get(
            get_Raw_Offset(origIdx), 
            get_Raw_Union_IncludeLoc_or_SpellingLoc(origIdx), 
            get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(origIdx), 
            get_Raw_Union_Data_or_ExpansionLocEnd(origIdx));
  }

  protected final int getSlice(int idx) {
    assert idx >= 0 : idx;
    return (idx >>> shiftForSlice);
  }
  
  protected final int getIndex(int idx) {
    return (idx & maskForIndex);
  }  
  
  final int offset_$at(int origIdx) {
    return SrcMgr.SLocEntry.toOffset(get_Raw_Offset(origIdx));
  }
    
  final boolean isExpansion_$at(int origIdx) {
    return SrcMgr.SLocEntry.isExpansion(get_Raw_Offset(origIdx));
  }

  final boolean isFile_$at(int origIdx) {
    return SrcMgr.SLocEntry.isNotExpansion(get_Raw_Offset(origIdx));
  }
  
  final int rawOffset_$at(int origIdx) {
    return get_Raw_Offset(origIdx);
  }
  
  final int $getContentCacheIndex(int origIdx) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    return SrcMgr.FileInfo.getContentCacheIndex(get_Raw_Union_Data_or_ExpansionLocEnd(origIdx));
  }
  
  final void $setNumCreatedFIDs(int origIdx, /*uint*/int NumFIDs) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    assert (get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(origIdx) == 0) : "Already set!" + get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(origIdx);
    set_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(origIdx, (int)NumFIDs);
  }
  
  final void $setHasLineDirectives(int origIdx) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    int Value = get_Raw_Union_Data_or_ExpansionLocEnd(origIdx);
    set_Raw_Union_Data_or_ExpansionLocEnd(origIdx, Value |= SrcMgr.FileInfo.LineDirectivesBit);
  }

  final boolean $hasLineDirectives(int origIdx) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    return (get_Raw_Union_Data_or_ExpansionLocEnd(origIdx) & SrcMgr.FileInfo.LineDirectivesBit) != 0;
  }

  final SrcMgr.CharacteristicKind $getFileCharacteristic(int origIdx) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    return SrcMgr.FileInfo.getFileCharacteristic(get_Raw_Union_Data_or_ExpansionLocEnd(origIdx));
  }

  final public void $set(int origIdx, SrcMgr.SLocEntry value) {
    setImpl(origIdx, 
            value.Offset, 
            value.Union_IncludeLoc_or_SpellingLoc, 
            value.Union_NumCreatedFIDs_or_ExpansionLocStart,
            value.Union_Data_or_ExpansionLocEnd);
    assert $at(origIdx).$eq(value) && $at(origIdx).getClass() == value.getClass();    
  }
  
  final void $setExpansion(int origIdx, /*uint*/int Offset, int SpellingLoc, int ExpansionLocStart, int ExpansionLocEnd) {
    setImpl(origIdx, 
            Offset | SrcMgr.SLocEntry.ExpansionBit,
            SpellingLoc,
            ExpansionLocStart,
            ExpansionLocEnd);
    assert isExpansion_$at(origIdx);    
  }
  
  final void $setFile(int origIdx, /*uint*/int Offset, int IncludePos, SrcMgr.ContentCache Con, SrcMgr.CharacteristicKind FileCharacter) {
    assert ((/*uint*/int)FileCharacter.getValue() < 4) : "invalid file character";       
    int Data = Con.$index();
    Data |= FileCharacter.getValue() << SrcMgr.FileInfo.CharacteristicKindShift;
    setImpl(origIdx, 
            Offset,
            IncludePos,
            0,
            Data);
    assert isFile_$at(origIdx);    
  }
  

  final /*<SourceLocation, SourceLocation>*/long $getRawExpansionLocRange(int idx) {
    return wrap_SourceLocation_SourceLocation($getRawExpansionLocStart(idx), $getRawExpansionLocEnd(idx));
  }
  
  final /*SourceLocation*/int $getRawExpansionLocStart(int origIdx) {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";      
    return this.get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(origIdx);
  }
  
  final/*SourceLocation*/int $getRawExpansionLocEndImpl(int origIdx) {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";
    return this.get_Raw_Union_Data_or_ExpansionLocEnd(origIdx);
  }
  
  final /*SourceLocation*/int $getRawExpansionLocEnd(int origIdx) {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";
    int RawExpansionLocEnd = $getRawExpansionLocEndImpl(origIdx);
    if (SourceLocation.isInvalid(RawExpansionLocEnd)) {
      return $getRawExpansionLocStart(origIdx);
    }
    return RawExpansionLocEnd;
  }
  
  final /*SourceLocation*/int $getRawSpellingLoc(int origIdx) {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";
    return this.get_Raw_Union_IncludeLoc_or_SpellingLoc(origIdx);
  }
  
  final int $getNumCreatedFIDs(int origIdx) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    return get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(origIdx);
  }
  
  final /*SourceLocation*/int $getRawIncludeLoc(int origIdx) {
    assert (isFile_$at(origIdx)) : "Not a File!";
    return this.get_Raw_Union_IncludeLoc_or_SpellingLoc(origIdx);
  }
  
  final boolean $isMacroArgExpansion(int origIdx) {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";
    return SourceLocation.isValid($getRawExpansionLocStart(origIdx)) 
            && SourceLocation.isInvalid($getRawExpansionLocEndImpl(origIdx));
  }  
  
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::isMacroBodyExpansion">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 339,
   FQN="clang::SrcMgr::ExpansionInfo::isMacroBodyExpansion", NM="_ZNK5clang6SrcMgr13ExpansionInfo20isMacroBodyExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo20isMacroBodyExpansionEv")
  //</editor-fold>
  final boolean $isMacroBodyExpansion(int origIdx) /*const*/ {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";
    return SourceLocation.isValid($getRawExpansionLocStart(origIdx)) 
            && SourceLocation.isValid($getRawExpansionLocEndImpl(origIdx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::isFunctionMacroExpansion">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 344,
   FQN="clang::SrcMgr::ExpansionInfo::isFunctionMacroExpansion", NM="_ZNK5clang6SrcMgr13ExpansionInfo24isFunctionMacroExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo24isFunctionMacroExpansionEv")
  //</editor-fold>
  final boolean $isFunctionMacroExpansion(int origIdx) /*const*/ {
    assert (isExpansion_$at(origIdx)) : "Not an Expansion!";
    return SourceLocation.isValid($getRawExpansionLocStart(origIdx)) 
            && ($getRawExpansionLocStart(origIdx) != $getRawExpansionLocEnd(origIdx));
  }  
  
  public final boolean empty() {
    return this.end == 0;
  }

  public final void clear() {
//    if (this.capacity != toCapacity) {
//      this.capacity = clearImpl(toCapacity == 0 ? 1 : toCapacity);
//    }
    this.end = 0;
  }
    
  protected abstract int clearImpl(int keepCapacity);
  
  public void $destroy() {
    this.end = 0;
  }
  
  public final SmallVectorSLocEntry push_back(SrcMgr.SLocEntry val) {
    SmallVectorSLocEntry grown = this;
    if (this.end >= this.capacity) {
      grown = this.grow();
    }
    grown.$set(grown.end++, val);
    return grown;
  }    

  final SmallVectorSLocEntry push_back_Expansion(/*uint*/int Offset, int SpellingLoc, int ExpansionLocStart, int ExpansionLocEnd) {
    SmallVectorSLocEntry grown = this;
    if (this.end >= this.capacity) {
      grown = this.grow();
    }
    grown.$setExpansion(grown.end++, Offset, SpellingLoc, ExpansionLocStart, ExpansionLocEnd);
    return grown;
  }    
  
  final SmallVectorSLocEntry push_back_File(/*uint*/int Offset, int IncludePos, SrcMgr.ContentCache File, SrcMgr.CharacteristicKind FileCharacter) {
    SmallVectorSLocEntry grown = this;
    if (this.end >= this.capacity) {
      grown = this.grow();
    }
    grown.$setFile(grown.end++, Offset, IncludePos, File, FileCharacter);
    return grown;
  }
    
  public final void pop_back() {
    this.end--;
  }

  public final SrcMgr.SLocEntry pop_back_val() {
    SrcMgr.SLocEntry val = this.back();
    this.end--;
    return val;
  }  

  public final iterator begin() {
    return new iterator(this, 0);
  }

  public final iterator end() {
    return new iterator(this, end);
  }
  
  public final SrcMgr.SLocEntry front() {
    return $at(0);
  }    
  
  public final SrcMgr.SLocEntry back() {
    return $at(end - 1);
  }    

  public final /*size_t*/int size() /*const*/ {
    return end;
  }

  public final  /*size_t*/int max_size() /*const*/ {
    return Integer.MAX_VALUE >>> 2; // TODO 
  }

  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  public final /*size_t*/int capacity() /*const*/ {
    return capacity;
  }

  @Override public final /*size_t*/int $sizeof() {
    return capacity_in_bytes();
  }

  public /*size_t*/int capacity_in_bytes() {
    throw new UnsupportedOperationException();
  }

  /// Set the array size to \p N, which the current array must have enough
  /// capacity for.
  ///
  /// This does not construct or destroy any elements in the vector.
  ///
  /// Clients can use this in conjunction with capacity() to write past the end
  /// of the buffer when they know that more elements are available, and only
  /// update the size later. This avoids the cost of value initializing elements
  /// which will only be overwritten.
  public final void set_size(int N) {
    assert(N <= this.capacity);
    this.end = N;
  }  
  
  protected SmallVectorSLocEntry grow() {
    int curCapacity = capacity();
    return this.grow(curCapacity == 0 ? 1 : curCapacity * 2);
  }
  
  protected abstract int get_Raw_Offset(int origIdx);
  protected abstract int get_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx);
  protected abstract int get_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx);
  protected abstract int get_Raw_Union_Data_or_ExpansionLocEnd(int origIdx);

  protected abstract void set_Raw_Offset(int origIdx, int Value);
  protected abstract void set_Raw_Union_IncludeLoc_or_SpellingLoc(int origIdx, int Value);
  protected abstract void set_Raw_Union_NumCreatedFIDs_or_ExpansionLocStart(int origIdx, int Value);
  protected abstract void set_Raw_Union_Data_or_ExpansionLocEnd(int origIdx, int Value);
  
  protected abstract SmallVectorSLocEntry grow(int newSize);

  protected abstract void setImpl(int origIdx, int Raw_Offset, int Raw_Union_IncludeLoc_or_SpellingLoc, int Raw_Union_NumCreatedFIDs_or_ExpansionLocStart, int Raw_Union_Data_or_ExpansionLocEnd);

  protected abstract boolean isSlicedByOffsets();
  protected abstract int $OffsetsMaxSliceIndex();
  protected abstract int[] $OffsetsSliceByIndex(int slice);
  protected abstract int $OffsetsSliceSize();
  
  protected abstract int offset_$at(int[] Array, int origIdx);
  protected abstract int offset_$at(int[] Array, int origIdx, int slice, int idxInSlice);
  
  /*
   * *************************************************************************
   *  Iterators
   * *************************************************************************
   */

    
  public static final class iterator implements type$iterator<iterator, SrcMgr.SLocEntry>, Native.assignable<iterator>, Native.ComparableLowerGreater {
    
    private final SmallVectorSLocEntry delegate;
    private int index;
    
    private iterator(SmallVectorSLocEntry delegate, int index) {
      this.delegate = delegate;
      this.index = index;
    }

    @Override
    public iterator $assign(iterator other) {
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }

    public SrcMgr.SLocEntry $arrow() {
      return $at(0);
    }

    @Override
    public SrcMgr.SLocEntry $star() {
      return $at(0);
    }
    
    @Override
    public type$ref<SrcMgr.SLocEntry> star$ref() {
      throw new UnsupportedOperationException();
    }       

    @Override
    public int $sub(iterator iter) {
      assert this.delegate == iter.delegate;
      return this.index - iter.index;
    }

    @Override
    public iterator $preInc() {
      ++this.index;
      return this;
    }

    @Override
    public iterator $preDec() {
      --this.index;
      return this;
    }

    @Override
    public iterator $postInc() {
      iterator cloned = new iterator(delegate, index);
      index++;
      return cloned;
    }

    @Override
    public iterator $postDec() {
      iterator cloned = new iterator(delegate, index);
      index--;
      return cloned;
    }
    @Override
    public iterator $inc(int amount) {
      index+=amount;
      return this;
    }

    @Override
    public iterator $dec(int amount) {
      index-=amount;
      return this;
    }

    @Override
    public iterator $add(int amount) {
      return new iterator(this.delegate, (this.index + amount));
    }

    @Override
    public iterator $sub(int amount) {
      return new iterator(this.delegate, (this.index - amount));
    }

    @Override
    public boolean $noteq(Object other) {
      assert this.delegate == ((iterator) other).delegate;
      return this.index != ((iterator) other).index;
    }

    @Override
    public boolean $eq(Object other) {
      assert this.delegate == ((iterator) other).delegate;
      return this.index == ((iterator) other).index;
    }

    @Override
    public iterator clone() {
      return new iterator(delegate, index);
    }

    @Override
    public iterator const_clone() {
      // TODO: pass constness
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean $less(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index < ((iterator) obj).index;
    }

    @Override
    public boolean $lesseq(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index <= ((iterator) obj).index;
    }

    @Override
    public boolean $greater(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index > ((iterator) obj).index;
    }

    @Override
    public boolean $greatereq(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index >= ((iterator) obj).index;
    }

    public SrcMgr.SLocEntry $at(int index) {
      return delegate.$at((this.index + index));
    }
    
  } 

  @Override
  public final String toString() {
    if (this.end == 0) {
      return "<EMPTY>";
    }
    StringBuilder out = new StringBuilder("\nSmallVectorSLocEntry{\nend = " + this.end + "; capacity=" + this.capacity + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      SrcMgr.SLocEntry element = $at(i);
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append(SourceLocation.getFromRawEncoding(this.rawOffset_$at(i))).append(":");
      out.append(element).append('\n');
    }
    out.append("}SmallVectorSLocEntry}\n");
    return out.toString();
  }
  
  protected void $release() {
    // derived classes might decide to return something into pool
    $destroy();
  }
  
  private static final boolean BYTE_BUFFER_SLOC_ENTRY = Boolean.getBoolean("clank.bytebuffer");
  private static final boolean SLICED_SLOC_ENTRY = Boolean.getBoolean("clank.sliced");
  private static final boolean RAW_SLICED_SLOC_ENTRY = Boolean.getBoolean("clank.raw.sliced");  
  public static SmallVectorSLocEntry $create(int capacity) {
    SmallVectorSLocEntry out;
    if (BYTE_BUFFER_SLOC_ENTRY) {
      out = new SmallVectorSLocEntryByteBuffers(capacity);
    } else if (SLICED_SLOC_ENTRY) {
      out = new SmallVectorSLocEntry4SlicedRawIntArrays(capacity);
    } else if (RAW_SLICED_SLOC_ENTRY) {
      out = new SmallVectorSLocEntryRawOffset3IntArrays(capacity);
    } else {
      out = new SmallVectorSLocEntry4RawIntArrays(capacity);
    }    
    return out;
  }

  public static void $release(SmallVectorSLocEntry Vector) {
    Vector.$release();
  }
    
}
