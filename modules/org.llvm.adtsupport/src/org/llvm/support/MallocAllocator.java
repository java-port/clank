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

package org.llvm.support;

import java.util.HashMap;
import java.util.Map;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 89,
 FQN = "llvm::MallocAllocator", NM = "_ZN4llvm15MallocAllocatorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm15MallocAllocatorE")
//</editor-fold>
public class MallocAllocator /*extends AllocatorBase<MallocAllocator> */implements Destructors.ClassWithDestructor, NativeMemory.Allocator {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::MallocAllocator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 89,
   FQN = "llvm::MallocAllocator::MallocAllocator", NM = "_ZN4llvm15MallocAllocatorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm15MallocAllocatorC1Ev")
  //</editor-fold>
  public MallocAllocator() {}

  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::~MallocAllocator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 89,
   FQN = "llvm::MallocAllocator::~MallocAllocator", NM = "_ZN4llvm15MallocAllocatorD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm15MallocAllocatorD0Ev")
  //</editor-fold>
  public void $destroy() {}

  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::Reset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 91,
   FQN = "llvm::MallocAllocator::Reset", NM = "_ZN4llvm15MallocAllocator5ResetEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm15MallocAllocator5ResetEv")
  //</editor-fold>
  public void Reset() {
    // do nothing
  }  

  /*Alignment*/
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::Allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 93,
   FQN = "llvm::MallocAllocator::Allocate", NM = "_ZN4llvm15MallocAllocator8AllocateEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm15MallocAllocator8AllocateEjj")
  //</editor-fold>
  public char$ptr/*void P*/ Allocate(/*size_t*/int Size, /*size_t*/int Alignment) {
    if (NativeTrace.isDebugMode()) throw new UnsupportedOperationException("Used for Slabs only");
    trackAllocateNonSlab(Size);
    return create_char$ptr(new$char(Size));
  }

  /*template <typename T> TEMPLATE*/
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::Allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 39,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -filter=llvm::MallocAllocator::Allocate")
  //</editor-fold>
  public char$ptr /*P*/ Allocate(/*size_t*/int Size) {
    return Allocate(Size, 0);
  }

  /*template <typename T> TEMPLATE*/
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::Allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 39,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -filter=llvm::MallocAllocator::Allocate")
  //</editor-fold>
  public char$ptr /*P*/ AllocateSlab(/*size_t*/int Size) {
    trackAllocateSlab(Size);
    return $getSlabWithSize(Size);
  }

  /*template <typename T> TEMPLATE*/
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::Allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 42,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -filter=llvm::MallocAllocator::Allocate",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public </*typename*/ T> void$ptr /*P*/ Allocate(Class<T> cls, /*size_t*/int Num) {
    if (NativeTrace.isDebugMode()) throw new UnsupportedOperationException("Used for Slabs only");
    return null;
  }
  

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::Deallocate">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 46,
   FQN = "llvm::AllocatorBase::Allocate", NM = "_ZN4llvm13AllocatorBase8AllocateEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm13AllocatorBase8AllocateEjj")
  //</editor-fold>
  public void Deallocate(/*const*/Object/*void P*/ Ptr) {
    // do nothing
    throw new UnsupportedOperationException("Used for Slabs only");
  }

  public void Deallocate$NotSameRemoveCV(/*const*/Object/*void P*/ Ptr) {
    // do nothing
    throw new UnsupportedOperationException("Used for Slabs only");
  }

  @Override
  public void DeallocateSlab(char$ptr SlabStartPtr, /*size_t*/int Size) {
    if (NativeTrace.STATISTICS) {
      trackDeallocateSlab(Size);
    }
    $releaseSlabWithSize(SlabStartPtr, Size);
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::MallocAllocator::PrintStats">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 108,
   FQN = "llvm::MallocAllocator::PrintStats", NM = "_ZNK4llvm15MallocAllocator10PrintStatsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZNK4llvm15MallocAllocator10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
    // do nothing
  }

  @Override
  public long getTotalMemory() {
    return CharPtrSizeAllocations + CharPtrSizeSlabAllocations;
  }

  
  //////////////////////////////////////////////////////////////////////////////
  // Private
  private static final boolean USE_SLABS_POOL = Boolean.valueOf(System.getProperty("clank.slabs.pool", "true"));
  private static final int POOL_SIZE = 16;
  private static final char$ptr$array$stack[] POOL;
  private static final int SLAB_SIZE_MASK; // to be used instead of SlabSize % NativeMemory.Allocator.PageSize == 0
  private static final int SLAB_SIZE_INDEX_SHIFT_BY; // to be used instead of SlabSize / NativeMemory.Allocator.PageSize
  static {
    if (USE_SLABS_POOL) {
      SLAB_SIZE_MASK = (NativeMemory.Allocator.PageSize - 1);
      assert (NativeMemory.Allocator.PageSize & SLAB_SIZE_MASK) == 0 : "must be power of two " + Integer.toBinaryString(NativeMemory.Allocator.PageSize);
      SLAB_SIZE_INDEX_SHIFT_BY = Integer.bitCount(SLAB_SIZE_MASK);
      POOL = new char$ptr$array$stack[POOL_SIZE];
      for (int i = 0; i < POOL_SIZE; i++) {
        POOL[i] = new char$ptr$array$stack(1024);
      }
    } else {
      POOL = null;
      SLAB_SIZE_MASK = 0;
      SLAB_SIZE_INDEX_SHIFT_BY = 0;
    }
  }
  
  private static char$ptr $getSlabWithSize(/*size_t*/int Size) {
    char$ptr out = null;
    if (USE_SLABS_POOL) {
      char$ptr$array$stack stack = getPointersForSize(Size);
      if (stack != null) {
        synchronized (stack) {
          out = stack.pop_or_null();
        }
      }    
    }
    if (out == null) {
      out = create_char$ptr(new$char(Size));
    }
    return out;
  }
  
  private static void $releaseSlabWithSize(char$ptr SlabStartPtr, /*size_t*/int Size) {
    if (NativeTrace.isDebugMode()) {
      char$ptr$array Ptr = (char$ptr$array)SlabStartPtr;
      assert Ptr.$array() != null : "must has underlying array";
      assert Ptr.$array().length == Size : "must be the same size";
      assert Ptr.$index() == 0 : "must point to the start of array";
    }
    char$ptr Ptr = Native.$toConst(SlabStartPtr);
    if (USE_SLABS_POOL) {
      char$ptr$array$stack stack = getPointersForSize(Size);
      if (stack != null) {
        synchronized (stack) {
          stack.push((char$ptr$array)Ptr);
        }
      }
    }
  }
  
  private static char$ptr$array$stack getPointersForSize(/*size_t*/int Size) {
    assert Size < Integer.MAX_VALUE;
    assert Size >= 0 : Size;
    char$ptr$array$stack pointers = null;
    if ((Size & SLAB_SIZE_MASK) == 0) {
      int index = Size >>> SLAB_SIZE_INDEX_SHIFT_BY;
      assert index >= 0 : index;
      if (index < POOL_SIZE) {
        pointers = POOL[index];
        assert pointers != null;
      }
    }
    return pointers;
  }
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long CharPtrSizeSlabAllocations = 0;
  private static long CharPtrSizeAllocations = 0;
  private static long CharPtrSlabsSizeDeAllocations = 0;
  private static long CharPtrDiffInAllocDeallocSize = 0;
  private static long CharPtrMaxDiffInAllocDeallocSize = 0;
  private static final Map<Integer, Integer> SlabSizes = new HashMap();
  
  private static void trackAllocateNonSlab(/*size_t*/int Size) {
    if (NativeTrace.STATISTICS) {
      CharPtrSizeAllocations+=Size;
    }
  }
  private static void trackAllocateSlab(/*size_t*/int Size) {
    if (NativeTrace.STATISTICS) {
      Integer key = Size;
      synchronized (SlabSizes) {
        Integer value = SlabSizes.get(key);
        if (value == null) {
          value = Integer.valueOf(0);
        }
        value = value + 1;
        SlabSizes.put(key, value);
      }
      CharPtrSizeSlabAllocations+=Size;
      CharPtrDiffInAllocDeallocSize += Size;
      CharPtrMaxDiffInAllocDeallocSize = std.max(CharPtrMaxDiffInAllocDeallocSize, CharPtrDiffInAllocDeallocSize);
    }
  }
  private static void trackDeallocateSlab(/*size_t*/int Size) {
    if (NativeTrace.STATISTICS) {
      CharPtrSlabsSizeDeAllocations+=Size;
      CharPtrDiffInAllocDeallocSize -=Size;
      assert CharPtrDiffInAllocDeallocSize >= 0;
    }
  }
  
  public static void clearStatistics() {
    CharPtrSizeSlabAllocations = 0;
    CharPtrSlabsSizeDeAllocations = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out("\t----MallocAllocator info----\n");
    out.$out(String.format("%18s   allocated:\t", "Not Slab")).$out(NativeTrace.formatNumber(CharPtrSizeAllocations)).$out(".\n");
    out.$out(String.format("%18s   allocated:\t", "    Slab")).$out(NativeTrace.formatNumber(CharPtrSizeSlabAllocations)).$out(".\n");
    out.$out(String.format("%18s deallocated:\t", "    Slab")).$out(NativeTrace.formatNumber(CharPtrSlabsSizeDeAllocations)).$out(".\n");
    out.$out(String.format("%18s memory leak:\t", "    Slab")).$out(NativeTrace.formatNumber(CharPtrDiffInAllocDeallocSize)).$out(".\n");
    out.$out(String.format("%18s max at once:\t", "    Slab")).$out(NativeTrace.formatNumber(CharPtrMaxDiffInAllocDeallocSize)).$out(".\n");
    synchronized (SlabSizes) {
      for (Map.Entry<Integer, Integer> entry : SlabSizes.entrySet()) {
        out.$out(String.format("%18s %11s:\t", "Slab Size", NativeTrace.formatNumber(entry.getKey()))).
                $out(NativeTrace.formatNumber(entry.getValue())).$out($LF);
      }
    }
    for (int i = 0; i < POOL_SIZE; i++) {
      char$ptr$array$stack stack = POOL[i];
      synchronized (stack) {
        if (stack.size() > 0) {
          out.$out(String.format("%18s %11s:\t", "Slabs Pool For", NativeTrace.formatNumber(i * NativeMemory.Allocator.PageSize))).
                  $out(NativeTrace.formatNumber(stack.size())).$out($LF);
        }
      }
    }
    long Value = CharPtrSizeAllocations + CharPtrSizeSlabAllocations;
    StatisticsADTSupport.dumpStatisticValue(out, "TotalMallocAllocatedBytes", Value);
    return Value;
  }  
}
