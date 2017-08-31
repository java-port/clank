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

package org.clang.sema;

import org.clank.support.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import static org.clang.sema.impl.AttributeListStatics.*;
import static org.clang.sema.java.SemaSizeofAndAlignment.*;


/// A factory, from which one makes pools, from which one creates
/// individual attributes which are deallocated with the pool.
///
/// Note that it's tolerably cheap to create and destroy one of
/// these as long as you don't actually allocate anything in it.
//<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 526,
 FQN="clang::AttributeFactory", NM="_ZN5clang16AttributeFactoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactoryE")
//</editor-fold>
public class AttributeFactory implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 528,
   FQN="clang::AttributeFactory::(anonymous)", NM="_ZN5clang16AttributeFactoryE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactoryE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    /// The required allocation size of an availability attribute,
    /// which we want to ensure is a multiple of sizeof(void*).
    AvailabilityAllocSize($sizeof_AttributeList()
       + ($div_uint(($sizeof_AvailabilityData() + $sizeof_ptr(/*Object */) + $sizeof_PointerUnion$Expr$IdentifierLoc$P$P() - 1)
      , $sizeof_ptr(/*Object */)) * $sizeof_ptr(/*Object */))),
    TypeTagForDatatypeAllocSize($sizeof_AttributeList()
       + $div_uint(($sizeof_TypeTagForDatatypeData() + $sizeof_ptr(/*Object */)
       + $sizeof_PointerUnion$Expr$IdentifierLoc$P$P() - 1)
      , $sizeof_ptr(/*Object */)) * $sizeof_ptr(/*Object */)),
    PropertyAllocSize($sizeof_AttributeList()
       + $div_uint(($sizeof_PropertyData() + $sizeof_ptr(/*Object */) - 1)
      , $sizeof_ptr(/*Object */)) * $sizeof_ptr(/*Object */));

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 547,
   FQN="clang::AttributeFactory::(anonymous)", NM="_ZN5clang16AttributeFactoryE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactoryE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// The number of free lists we want to be sure to support
    /// inline.  This is just enough that availability attributes
    /// don't surpass it.  It's actually very unlikely we'll see an
    /// attribute that needs more than that; on x86-64 you'd need 10
    /// expression arguments, and on i386 you'd need 19.
    public static final /*uint*/int InlineFreeListsCapacity = 1 + $div_uint((Unnamed_enum.AvailabilityAllocSize.getValue() - $sizeof_AttributeList()), $sizeof_ptr(/*Object */));
  /*}*/;
  
  private BumpPtrAllocatorImpl Alloc;
  
  /// Free lists.  The index is determined by the following formula:
  ///   (size - sizeof(AttributeList)) / sizeof(void*)
  private SmallVector<AttributeList /*P*/> FreeLists;
  
  // The following are the private interface used by AttributePool.
  /*friend  class AttributePool*/
  
  /// Allocate an attribute of the given size.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory::allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not yet supported in java*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 55,
   FQN="clang::AttributeFactory::allocate", NM="_ZN5clang16AttributeFactory8allocateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactory8allocateEj")
  //</editor-fold>
  /*friend*//*private*/ Object/*void P*/ allocate(/*size_t*/int size) {
    if (true) {
      NativeTrace.traceNotImplemented("clang::AttributeFactory::allocate");
      return null;
    }
    // Check for a previously reclaimed attribute.
    /*size_t*/int index = getFreeListIndexForSize(size);
    if ($less_uint(index, FreeLists.size())) {
      {
        AttributeList /*P*/ attr = FreeLists.$at(index);
        if ((attr != null)) {
          FreeLists.$set(index, attr.NextInPool);
          return attr;
        }
      }
    }
    
    // Otherwise, allocate something new.
    return Alloc.Allocate(size, AlignOf.<AttributeFactory>Unnamed_enum.Alignment$Native);
  }

  
  /// Reclaim all the attributes in the given pool chain, which is
  /// non-empty.  Note that the current implementation is safe
  /// against reclaiming things which were not actually allocated
  /// with the allocator, although of course it's important to make
  /// sure that their allocator lives at least as long as this one.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory::reclaimPool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not yet supported in java*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 69,
   FQN="clang::AttributeFactory::reclaimPool", NM="_ZN5clang16AttributeFactory11reclaimPoolEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactory11reclaimPoolEPNS_13AttributeListE")
  //</editor-fold>
  /*friend*//*private*/ void reclaimPool(AttributeList /*P*/ cur) {
    assert ((cur != null)) : "reclaiming empty pool!";
    if (true) {
      NativeTrace.traceNotImplemented("clang::AttributeFactory::reclaimPool");
      return;
    }
    assert false : " we do not support yet this AttributeFactory allocation in Java";
    do {
      // Read this here, because we're going to overwrite NextInPool
      // when we toss 'cur' into the appropriate queue.
      AttributeList /*P*/ next = cur.NextInPool;
      
      /*size_t*/int size = cur.allocated_size();
      /*size_t*/int freeListIndex = getFreeListIndexForSize(size);
      
      // Expand FreeLists to the appropriate size, if required.
      if ($greatereq_uint(freeListIndex, FreeLists.size())) {
        FreeLists.resize(freeListIndex + 1);
      }
      
      // Add 'cur' to the appropriate free-list.
      cur.NextInPool = FreeLists.$at(freeListIndex);
      FreeLists.$set(freeListIndex, cur);
      
      cur = next;
    } while ((cur != null));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory::AttributeFactory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 43,
   FQN="clang::AttributeFactory::AttributeFactory", NM="_ZN5clang16AttributeFactoryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactoryC1Ev")
  //</editor-fold>
  public AttributeFactory() {
    // : Alloc(), FreeLists() 
    //START JInit
    this.Alloc = new BumpPtrAllocatorImpl();
    this.FreeLists = new SmallVector<AttributeList /*P*/>(InlineFreeListsCapacity);
    //END JInit
    // Go ahead and configure all the inline capacity.  This is just a memset.
    FreeLists.resize(InlineFreeListsCapacity);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeFactory::~AttributeFactory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 47,
   FQN="clang::AttributeFactory::~AttributeFactory", NM="_ZN5clang16AttributeFactoryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16AttributeFactoryD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    FreeLists.$destroy();
    Alloc.$destroy();
    //END JDestroy
  }
  
  @Override public String toString() {
    return "" + "Alloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", FreeLists=" + FreeLists; // NOI18N
  }
}
