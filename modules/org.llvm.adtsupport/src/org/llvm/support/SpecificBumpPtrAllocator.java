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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;

/*template <typename T> TEMPLATE*/

/// \brief A BumpPtrAllocator that allows only elements of a specific type to be
/// allocated.
///
/// This allows calling the destructor in DestroyAll() and when the allocator is
/// destroyed.
//<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 363,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 361,
 FQN = "llvm::SpecificBumpPtrAllocator", NM = "_ZN4llvm24SpecificBumpPtrAllocatorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocatorE")
//</editor-fold>
public class SpecificBumpPtrAllocator</*typename*/ T>  implements Destructors.ClassWithDestructor {
  private BumpPtrAllocatorImpl Allocator;
  private final Class<T> cls;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator::SpecificBumpPtrAllocator<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 367,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 365,
   FQN = "llvm::SpecificBumpPtrAllocator::SpecificBumpPtrAllocator<T>", NM = "_ZN4llvm24SpecificBumpPtrAllocatorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocatorC1Ev")
  //</editor-fold>
  public SpecificBumpPtrAllocator(Class<T> cls) {
    /* : Allocator()*/ 
    //START JInit
    this.Allocator = new BumpPtrAllocatorImpl();
    //END JInit
    this.cls = cls;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator::SpecificBumpPtrAllocator<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 368,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 366,
   FQN = "llvm::SpecificBumpPtrAllocator::SpecificBumpPtrAllocator<T>", NM = "_ZN4llvm24SpecificBumpPtrAllocatorC1EONS_24SpecificBumpPtrAllocatorIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocatorC1EONS_24SpecificBumpPtrAllocatorIT_EE")
  //</editor-fold>
  public SpecificBumpPtrAllocator(SpecificBumpPtrAllocator<T> /*&&*/Old) {
    /* : Allocator(std::move(Old.Allocator))*/ 
    //START JInit
    this.Allocator = new BumpPtrAllocatorImpl(std.move(Old.Allocator));
    //END JInit
    this.cls = Old.cls;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator::~SpecificBumpPtrAllocator<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 370,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 368,
   FQN = "llvm::SpecificBumpPtrAllocator::~SpecificBumpPtrAllocator<T>", NM = "_ZN4llvm24SpecificBumpPtrAllocatorD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocatorD0Ev")
  //</editor-fold>
  public void $destroy() {
    DestroyAll();
    //START JDestroy
    Allocator.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 372,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 370,
   FQN = "llvm::SpecificBumpPtrAllocator::operator=", NM = "_ZN4llvm24SpecificBumpPtrAllocatoraSEONS_24SpecificBumpPtrAllocatorIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocatoraSEONS_24SpecificBumpPtrAllocatorIT_EE")
  //</editor-fold>
  public SpecificBumpPtrAllocator<T> /*&*/ $assign(SpecificBumpPtrAllocator<T> /*&&*/RHS) {
    Allocator = std.move(RHS.Allocator);
    return /*Deref*/this;
  }

  private class DestroyElementsLambda {
    public void $call(char$ptr/*char P*/ Begin, char$ptr/*char P*/ End) {
      assert (Begin.$index() == alignAddr(Begin, llvm.alignOf(cls)));
      for (char$ptr/*char P*/ Ptr = $tryClone(Begin); Ptr.$add(sizeof(cls)).$lesseq(End); Ptr.$inc(sizeof(cls)))  {
        Native.destroy(Casts.reinterpret_ptr_cast(cls, Ptr));
      }
    }
  }
  
  /// Call the destructor of each allocated object and deallocate all but the
  /// current slab and reset the current pointer to the beginning of it, freeing
  /// all memory allocated so far.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator::DestroyAll">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 380,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 378,
   FQN = "llvm::SpecificBumpPtrAllocator::DestroyAll", NM = "_ZN4llvm24SpecificBumpPtrAllocator10DestroyAllEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocator10DestroyAllEv")
  //</editor-fold>
  public void DestroyAll() {
    DestroyElementsLambda DestroyElements = new DestroyElementsLambda();
    
    for (type$ptr<char$ptr/*void P*/>  I = Allocator.Slabs.begin(), E = Allocator.Slabs.end(); I.$noteq(E);
         I.$preInc()) {
      /*size_t*/int AllocatedSlabSize = BumpPtrAllocator.computeSlabSize(Allocator.SlabSize, Allocator.MaxSlabSize, std.distance(Allocator.Slabs.begin(), I));
      char$ptr/*char P*/ Begin = create_char$ptr(I.$star().$array(), alignAddr($Deref(I.$star()), llvm.alignOf(cls)));
      char$ptr/*char P*/ End = Native.$eq_ptr(I.$star(), Allocator.Slabs.back()) ? Allocator.CurPtr : (char$ptr/*char P*/ )$Deref(I.$star().$add(AllocatedSlabSize));
      
      DestroyElements.$call(Begin, End);
    }
    
    for (std.pairTypeInt<char$ptr/*void P*/> /*&*/ PtrAndSize : Allocator.CustomSizedSlabs) {
      char$ptr/*void P*/ Ptr = PtrAndSize.first;
      /*size_t*/int Size = PtrAndSize.second;
      DestroyElements.$call(create_char$ptr(Ptr.$array(), alignAddr(Ptr, llvm.alignOf(cls))), Ptr.$add(Size));
    }
    
    Allocator.Reset();
  }

  
  /// \brief Allocate space for an array of objects without constructing them.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecificBumpPtrAllocator::Allocate">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 408,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", old_line = 406,
   FQN = "llvm::SpecificBumpPtrAllocator::Allocate", NM = "_ZN4llvm24SpecificBumpPtrAllocator8AllocateEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm24SpecificBumpPtrAllocator8AllocateEj")
  //</editor-fold>
  public type$ptr<T> /*P*/ Allocate() {
    return Allocate(1);
  }
  public type$ptr<T> /*P*/ Allocate(/*size_t*/int num/*= 1*/) {
    return (type$ptr<T>) Allocator.Allocate(cls, num);
  }

  
  public String toString() {
    return "" + "Allocator=" + Allocator; // NOI18N
  }
}
