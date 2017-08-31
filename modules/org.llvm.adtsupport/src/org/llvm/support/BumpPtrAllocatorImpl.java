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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clank.support.NativeMemory;
import org.clank.support.NativeMemory.BumpAllocator;
import org.llvm.support.llvm.support.detail;
import org.llvm.support.sys.*;

/*template <typename AllocatorT = MallocAllocator, size_t SlabSize = 4096, size_t SizeThreshold = SlabSize> TEMPLATE*/
// End namespace detail.

/// \brief Allocate memory in an ever growing pool, as if by bump-pointer.
///
/// This isn't strictly a bump-pointer allocator as it uses backing slabs of
/// memory rather than relying on a boundless contiguous heap. However, it has
/// bump-pointer semantics in that it is a monotonically growing pool of memory
/// where every allocation is found by merely allocating the next N bytes in
/// the slab, or the next N bytes in the next slab.
///
/// Note that this also has a threshold for forcing allocations above a certain
/// size into their own slab.
///
/// The BumpPtrAllocatorImpl template defaults to using a MallocAllocator
/// object, which wraps malloc, to allocate memory, but it can be changed to
/// use a custom allocator.
//<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 133,
 FQN = "llvm::BumpPtrAllocatorImpl", NM = "_ZN4llvm20BumpPtrAllocatorImplE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImplE")
//</editor-fold>
public class BumpPtrAllocatorImpl extends /*public*/ AllocatorBase<BumpPtrAllocatorImpl> implements Destructors.ClassWithDestructor, BumpAllocator {
/*public:*/
  /*package*/ final /*size_t*/int SlabSize/* = 4096*/;
  /*package*/ final /*size_t*/int SizeThreshold/* = SlabSize*/;
  /*package*/ final /*size_t*/int MaxSlabSize;
  
  //static_assert(SizeThreshold <= SlabSize, $("The SizeThreshold must be at most the SlabSize to ensure that objects larger than a slab go into their own memory allocation."));
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 144,
   FQN = "llvm::BumpPtrAllocatorImpl::BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>", NM = "_ZN4llvm20BumpPtrAllocatorImplC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImplC1Ev")
  //</editor-fold>
  public BumpPtrAllocatorImpl() {
    this(new MallocAllocator());
  }
  public BumpPtrAllocatorImpl(NativeMemory.Allocator Allocator) {
    this(Allocator, 4096);
  }
  public BumpPtrAllocatorImpl(NativeMemory.Allocator Allocator, /*size_t*/int SlabSize) {
    this(Allocator, SlabSize, SlabSize);
  }
  public BumpPtrAllocatorImpl(NativeMemory.Allocator Allocator, /*size_t*/int SlabSize, /*size_t*/int SizeThreshold) {
    this(Allocator, SlabSize, SizeThreshold, NativeMemory.Allocator.MaxPageSize);
  }
  public BumpPtrAllocatorImpl(NativeMemory.Allocator Allocator, /*size_t*/int SlabSize, /*size_t*/int SizeThreshold, int MaxSlabSize) {
    /* : CurPtr(null), End(null), BytesAllocated(0), Allocator()*/ 
    //START JInit
    this.Slabs = new SmallVector<char$ptr/*void P*/>(4, (char$ptr)null);
    this.CustomSizedSlabs = new SmallVector<std.pairTypeInt<char$ptr/*void P*/>>(0, new std.pairTypeInt(null, 0));
    this.CurPtr = null;
    this.End = null;
    this.BytesAllocated = 0;
    this.Allocator = Allocator;
    //END JInit
    this.SlabSize = SlabSize;
    this.SizeThreshold = SizeThreshold;
    this.MaxSlabSize = MaxSlabSize;
  }

//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 147,
//   FQN="llvm::BumpPtrAllocatorImpl::BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>", NM="_ZN4llvm20BumpPtrAllocatorImplC1EOT_",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImplC1EOT_")
//  //</editor-fold>
//  public </*typename*/ T> BumpPtrAllocatorImpl(T /*&&*/Allocator) {
//    /* : CurPtr(null), End(null), BytesAllocated(0), Allocator(std::forward<T &&>(Allocator))*/ 
//    //START JInit
//    this.CurPtr = $tryClone(null);
//    this.End = $tryClone(null);
//    this.BytesAllocated = 0;
//    this.Allocator = new AllocatorT(std.forward<T /*&&*/>(Allocator));
//    //END JInit
//  }

  
  // Manually implement a move constructor as we must clear the old allocators
  // slabs as a matter of correctness.
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 153,
   FQN = "llvm::BumpPtrAllocatorImpl::BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>", NM = "_ZN4llvm20BumpPtrAllocatorImplC1EONS_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImplC1EONS_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE")
  //</editor-fold>
  public BumpPtrAllocatorImpl(BumpPtrAllocatorImpl /*&&*/Old) {
    /* : CurPtr(Old.CurPtr), End(Old.End), Slabs(std::move(Old.Slabs)), CustomSizedSlabs(std::move(Old.CustomSizedSlabs)), BytesAllocated(Old.BytesAllocated), Allocator(std::move(Old.Allocator))*/ 
    //START JInit
    this.CurPtr = $tryClone(Old.CurPtr);
    this.End = $tryClone(Old.End);
    this.Slabs = new SmallVector<char$ptr/*void P*/>(std.move(Old.Slabs));
    this.CustomSizedSlabs = new SmallVector<std.pairTypeInt<char$ptr/*void P*/>>(std.move(Old.CustomSizedSlabs));
    this.BytesAllocated = Old.BytesAllocated;
    this.Allocator = std.move(Old.Allocator);
    //END JInit
    Old.CurPtr = Old.End = null;
    Old.BytesAllocated = 0;
    Old.Slabs.clear();
    Old.CustomSizedSlabs.clear();
    
    this.SlabSize = Old.SlabSize;
    this.SizeThreshold = Old.SizeThreshold;
    this.MaxSlabSize = Old.MaxSlabSize;
    assert SlabSize <= MaxSlabSize : SlabSize + " is bigger than " + MaxSlabSize;   
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::~BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 164,
   FQN = "llvm::BumpPtrAllocatorImpl::~BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold>", NM = "_ZN4llvm20BumpPtrAllocatorImplD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    DeallocateSlabs(Slabs, 0);
    DeallocateCustomSizedSlabs();
    //START JDestroy
    CustomSizedSlabs.$destroy();
    Slabs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 169,
   FQN = "llvm::BumpPtrAllocatorImpl::operator=", NM = "_ZN4llvm20BumpPtrAllocatorImplaSEONS_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImplaSEONS_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ $assign(BumpPtrAllocatorImpl/*&&*/RHS) {
    DeallocateSlabs(Slabs, 0);
    DeallocateCustomSizedSlabs();
    
    CurPtr = RHS.CurPtr;
    End = RHS.End;
    BytesAllocated = RHS.BytesAllocated;
    Slabs = std.move(RHS.Slabs);
    CustomSizedSlabs = std.move(RHS.CustomSizedSlabs);
    Allocator = std.move(RHS.Allocator);
    
    RHS.CurPtr = RHS.End = null;
    RHS.BytesAllocated = 0;
    RHS.Slabs.clear();
    RHS.CustomSizedSlabs.clear();
    return /*Deref*/this;
  }

  
  /// \brief Deallocate all but the current slab and reset the current pointer
  /// to the beginning of it, freeing all memory allocated so far.
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::Reset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 189,
   FQN = "llvm::BumpPtrAllocatorImpl::Reset", NM = "_ZN4llvm20BumpPtrAllocatorImpl5ResetEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl5ResetEv")
  //</editor-fold>
  public void Reset() {
    if (Slabs.empty()) {
      return;
    }
    
    // Reset the state.
    BytesAllocated = 0;
    CurPtr = $tryClone((char$ptr/*char P*/ )Slabs.front());
    End = CurPtr.$add(SlabSize);
    
    // Deallocate all but the first slab, and all custome sized slabs.
    DeallocateSlabs(Slabs, 1);
    Slabs.erase(std.next(Slabs.begin()), Slabs.end());
    DeallocateCustomSizedSlabs();
    CustomSizedSlabs.clear();
  }

  
  /// \brief Allocate space at the specified alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::Allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 206,
   FQN = "llvm::BumpPtrAllocatorImpl::Allocate", NM = "_ZN4llvm20BumpPtrAllocatorImpl8AllocateEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl8AllocateEjj")
  //</editor-fold>
  @Override
  public char$ptr/*void P*/ Allocate(/*size_t*/int Size, /*size_t*/int Alignment)/* __attribute__((returns_nonnull))*/ {
    assert (Alignment > 0) : "0-byte alignnment is not allowed. Use 1 instead.";
    
    // Keep track of how many bytes we've allocated.
    BytesAllocated += Size;
    
    /*size_t*/int Adjustment = alignmentAdjustment(CurPtr, Alignment);
    assert (Adjustment + Size >= Size) : "Adjustment + Size must not overflow";
    
    // Check if we have enough space.
    if (Adjustment + Size <= (/*size_t*/int)(Native.$sub_ptr(End, CurPtr))) {
      char$ptr/*char P*/ AlignedPtr = CurPtr.$add(Adjustment);
      CurPtr = $tryClone(AlignedPtr.$add(Size));
      ;
      return AlignedPtr;
    }
    
    // If Size is really big, allocate a separate slab for it.
    /*size_t*/int PaddedSize = Size + Alignment - 1;
    if (PaddedSize > SizeThreshold) {
      char$ptr/*void P*/ NewSlab = Allocator.AllocateSlab(PaddedSize);
      CustomSizedSlabs.push_back(std.make_pair_T_int(NewSlab, PaddedSize));
      
      int/*uintptr_t*/ AlignedAddr = alignAddr(NewSlab, Alignment);
      assert (AlignedAddr + Size <= (int/*uintptr_t*/)NewSlab.$index() + PaddedSize);
      char$ptr/*char P*/ AlignedPtr = create_char$ptr(NewSlab.$array(), AlignedAddr);
      ;
      return AlignedPtr;
    }
    
    // Otherwise, start a new slab and try again.
    StartNewSlab();
    int/*uintptr_t*/ AlignedAddr = alignAddr(CurPtr, Alignment);
    assert (AlignedAddr + Size <= (int/*uintptr_t*/)End.$index()) : "Unable to allocate memory!";
    char$ptr/*char P*/ AlignedPtr = create_char$ptr(CurPtr.$array(), AlignedAddr);
    CurPtr = $tryClone(AlignedPtr.$add(Size));
    ;
    return AlignedPtr;
  }

  @Override
  public int AllocateAndGetIndex(/*size_t*/int Size) {
    return AllocateAndGetIndex(Size, 8);
  }

  @Override
  public int AllocateAndGetIndex(/*size_t*/int Size, /*size_t*/int Alignment) {
    assert (Alignment > 0) : "0-byte alignnment is not allowed. Use 1 instead.";
    
    // Keep track of how many bytes we've allocated.
    BytesAllocated += Size;
    
    /*size_t*/int Adjustment = alignmentAdjustment(CurPtr, Alignment);
    assert (Adjustment + Size >= Size) : "Adjustment + Size must not overflow";
    
    // Check if we have enough space.
    if (Adjustment + Size <= (/*size_t*/int)(Native.$sub_ptr(End, CurPtr))) {
      int/*char P*/ AlignedPtr = Native.$ptr_index(CurPtr);
      Native.$setIndex(CurPtr, AlignedPtr + (int)Size);
      assert AlignedPtr < MaxSlabSize : String.valueOf(AlignedPtr) + " is bigger or equal to " + MaxSlabSize;
      return AlignedPtr;
    }
    
    // If Size is really big, allocate a separate slab for it.
    /*size_t*/int PaddedSize = Size + Alignment - 1;
    if (PaddedSize > SizeThreshold) {
      char$ptr/*void P*/ NewSlab = Allocator.AllocateSlab(PaddedSize);
      CustomSizedSlabs.push_back(std.make_pair_T_int(NewSlab, PaddedSize));
      
      int/*uintptr_t*/ AlignedAddr = alignAddr(NewSlab, Alignment);
      assert (AlignedAddr + Size <= (int/*uintptr_t*/)NewSlab.$index() + PaddedSize);
      //char$ptr/*char P*/ AlignedPtr = create_char$ptr(NewSlab.$array(), AlignedAddr);
      assert AlignedAddr < MaxSlabSize : String.valueOf(AlignedAddr) + " is bigger or equal to " + MaxSlabSize;
      return (int) AlignedAddr;
    }
    
    // Otherwise, start a new slab and try again.
    StartNewSlab();
    int/*uintptr_t*/ AlignedAddr = alignAddr(CurPtr, Alignment);
    assert (AlignedAddr + Size <= (int/*uintptr_t*/)End.$index()) : "Unable to allocate memory!";
    Native.$setIndex(CurPtr, (int)(AlignedAddr + Size));
    assert AlignedAddr < MaxSlabSize : String.valueOf(AlignedAddr) + " is bigger or equal to " + MaxSlabSize;
    return (int) AlignedAddr;
  }

  @Override
  public byte[] GetLastAllocationStorage() {
    assert CurPtr != null : "can be called only once after AllocateAndGetIndex";
    return CurPtr.$array();
  }
  
  @Override
  public char$ptr Allocate(/*size_t*/int Size) {
    return Allocate(Size, 8);
  }

  @Override
  public <T> void$ptr Allocate(Class<T> cls, /*size_t*/int Num) {
    return null;
  }

  public <T> T Allocate$T(Class<T> cls) {
    return null;
  }

  public type$ptr<?> Allocate$JavaRef(int Nr) {
    return create_type$ptr(new$Object(Nr));
  }
  
  @Override
  public char$ptr AllocateSlab(/*size_t*/int Size) {
    throw new UnsupportedOperationException("Bump Pointer should not be used for other allocators");
  }
  
  // Pull in base class overloads.
  //JAVA: using AllocatorBase<BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold> >::Allocate;
  
  /*Ptr*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::Deallocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 253,
   FQN = "llvm::BumpPtrAllocatorImpl::Deallocate", NM = "_ZN4llvm20BumpPtrAllocatorImpl10DeallocateEPKvj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl10DeallocateEPKvj")
  //</editor-fold>
  @Override
  public void DeallocateSlab(/*const*/char$ptr/*void P*/ $Prm0, /*size_t*/int $Prm1) {
    throw new UnsupportedOperationException("Bump Pointer should not be used for other allocators");
  }

  @Override
  public void Deallocate(Object Ptr) {
  }

  @Override
  public void Deallocate$NotSameRemoveCV(Object Ptr) {
  }
  
  // Pull in base class overloads.
  //JAVA: using AllocatorBase<BumpPtrAllocatorImpl<AllocatorT, SlabSize, SizeThreshold> >::Deallocate;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::GetNumSlabs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 258,
   FQN = "llvm::BumpPtrAllocatorImpl::GetNumSlabs", NM = "_ZNK4llvm20BumpPtrAllocatorImpl11GetNumSlabsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZNK4llvm20BumpPtrAllocatorImpl11GetNumSlabsEv")
  //</editor-fold>
  public /*size_t*/int GetNumSlabs() /*const*/ {
    return Slabs.size() + CustomSizedSlabs.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::getTotalMemory">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 272,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 260,
   FQN = "llvm::BumpPtrAllocatorImpl::getTotalMemory", NM = "_ZNK4llvm20BumpPtrAllocatorImpl14getTotalMemoryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZNK4llvm20BumpPtrAllocatorImpl14getTotalMemoryEv")
  //</editor-fold>
  @Override
  public /*size_t*/long getTotalMemory() /*const*/ {
    /*size_t*/int TotalMemory = 0;
    for (int I = 0, E = Slabs.size(); I < E; ++I)  {
      TotalMemory += computeSlabSize(I);
    }
    for (int index = 0, end = CustomSizedSlabs.size(); index < end; ++index) {    
      std.pairTypeInt<char$ptr/*void P*/> /*&*/ PtrAndSize = CustomSizedSlabs.$at(index);
      TotalMemory += PtrAndSize.second;
    }
    return TotalMemory;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::PrintStats">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 281,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 269,
   FQN = "llvm::BumpPtrAllocatorImpl::PrintStats", NM = "_ZNK4llvm20BumpPtrAllocatorImpl10PrintStatsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZNK4llvm20BumpPtrAllocatorImpl10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
    PrintStats("", llvm.errs());
  }
  // JAVA: pass OS and return some integral value
  public long PrintStats(String container, raw_ostream /*&*/ OS) /*const*/ {
    return detail.printBumpPtrAllocatorStats(container, OS, Slabs.size(), BytesAllocated,
        getTotalMemory(), SizeThreshold, SlabSize);
  }

/*private:*/
  /// \brief The current pointer into the current slab.
  ///
  /// This points to the next free byte in the slab.
  /*package*/ char$ptr/*char P*/ CurPtr;
  
  /// \brief The end of the current slab.
  /*package*/ char$ptr/*char P*/ End;
  
  /// \brief The slabs allocated so far.
  /*package*/ SmallVector<char$ptr/*void P*/> Slabs;
  
  /// \brief Custom-sized slabs allocated for too-large allocation requests.
  /*package*/ SmallVector<std.pairTypeInt<char$ptr/*void P*/>> CustomSizedSlabs;
  
  /// \brief How many bytes we've allocated.
  ///
  /// Used so that we can compute how much space was wasted.
  private /*size_t*/int BytesAllocated;
  
  /// \brief The allocator instance we use to get slabs of memory.
  private NativeMemory.Allocator Allocator;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::computeSlabSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 297,
   FQN = "llvm::BumpPtrAllocatorImpl::computeSlabSize", NM = "_ZN4llvm20BumpPtrAllocatorImpl15computeSlabSizeEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl15computeSlabSizeEj")
  //</editor-fold>
  private /*size_t*/int computeSlabSize(/*uint*/int SlabIdx) {
    return computeSlabSize(SlabSize, MaxSlabSize, SlabIdx);
  }
  /*package*/ static /*size_t*/int computeSlabSize(/*size_t*/int SlabSize, /*size_t*/int MaxSlabSize, /*uint*/int SlabIdx) {
    // Scale the actual allocated slab size based on the number of slabs
    // allocated. Every 128 slabs allocated, we double the allocated size to
    // reduce allocation frequency, but saturate at multiplying the slab size by
    // 2^30.
    int NextSlabSize = SlabSize * ((/*size_t*/int)1 << std.min(30, SlabIdx / 128));
    if (NextSlabSize <= 0) {
      // int multiplication overflow
      return MaxSlabSize;
    } 
    assert NextSlabSize >= 0 : NextSlabSize;
    return Math.min(NextSlabSize, MaxSlabSize); // #JAVA: SlabSize must not be bigger than MaxSlabSize
  }

  
  /// \brief Allocate a new slab and move the bump pointers over into the new
  /// slab, modifying CurPtr and End.
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::StartNewSlab">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 307,
   FQN = "llvm::BumpPtrAllocatorImpl::StartNewSlab", NM = "_ZN4llvm20BumpPtrAllocatorImpl12StartNewSlabEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl12StartNewSlabEv")
  //</editor-fold>
  private void StartNewSlab() {
    /*size_t*/int AllocatedSlabSize = computeSlabSize(Slabs.size());
    
    char$ptr/*void P*/ NewSlab = Allocator.AllocateSlab(AllocatedSlabSize);
    Slabs.push_back(NewSlab);
    CurPtr = $tryClone(NewSlab);
    End = NewSlab.$add(AllocatedSlabSize);
  }

  
  /// \brief Deallocate a sequence of slabs.
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::DeallocateSlabs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 333,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 317,
   FQN = "llvm::BumpPtrAllocatorImpl::DeallocateSlabs", NM = "_ZN4llvm20BumpPtrAllocatorImpl15DeallocateSlabsEPPvS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl15DeallocateSlabsEPPvS2_")
  //</editor-fold>
  private void DeallocateSlabs(SmallVectorImpl<char$ptr/*void P*/ > Slabs, int fromIndex) {
    Object[] $Array = Slabs.$array();
    for (int index = fromIndex, end = Slabs.size(); index < end; ++index) {
      /*size_t*/int AllocatedSlabSize = computeSlabSize(index);
      char$ptr Ptr = (char$ptr)$Array[index];
      // Poison the memory so stale pointers crash sooner.  Note we must
      // preserve the Size and NextPtr fields at the beginning.
      if (AllocatedSlabSize != 0) {
        Memory.setRangeWritable(Ptr, AllocatedSlabSize);
        memset(Ptr, $$0xCD, AllocatedSlabSize);
      }
      Allocator.DeallocateSlab(Ptr, AllocatedSlabSize);
    }
  }

  
  /// \brief Deallocate all memory for custom sized slabs.
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocatorImpl::DeallocateCustomSizedSlabs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 335,
   FQN = "llvm::BumpPtrAllocatorImpl::DeallocateCustomSizedSlabs", NM = "_ZN4llvm20BumpPtrAllocatorImpl26DeallocateCustomSizedSlabsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm20BumpPtrAllocatorImpl26DeallocateCustomSizedSlabsEv")
  //</editor-fold>
  private void DeallocateCustomSizedSlabs() {
    Object[] $Array = CustomSizedSlabs.$array();
    for (int index = 0, end = CustomSizedSlabs.size(); index < end; ++index) {    
      pairTypeInt<char$ptr/*void P*/> /*&*/ PtrAndSize = (pairTypeInt<char$ptr/*void P*/>) $Array[index];
      char$ptr/*void P*/ Ptr = PtrAndSize.first;
      /*size_t*/int Size = PtrAndSize.second;
      // Poison the memory so stale pointers crash sooner.  Note we must
      // preserve the Size and NextPtr fields at the beginning.
      Memory.setRangeWritable(Ptr, Size);
      memset(Ptr, $$0xCD, Size);
      Allocator.DeallocateSlab(Ptr, Size);
    }
  }

  
  /*friend template <typename T> class SpecificBumpPtrAllocator*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  public BumpPtrAllocatorImpl(/*size_t*/int SlabSize, /*size_t*/int SizeThreshold) {
    this(new MallocAllocator(), SlabSize, SizeThreshold);
  }

  public BumpPtrAllocatorImpl(JavaDifferentiators.JD$Move INSTANCE, BumpPtrAllocatorImpl Memory) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public void Deallocate(Object Ptr, int Size) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CurPtr=" + CurPtr // NOI18N
              + ", End=" + End // NOI18N
              + ", Slabs=" + Slabs // NOI18N
              + ", CustomSizedSlabs=" + CustomSizedSlabs // NOI18N
              + ", BytesAllocated=" + BytesAllocated // NOI18N
              + ", Allocator=" + Allocator // NOI18N
              + super.toString(); // NOI18N
  }
}
