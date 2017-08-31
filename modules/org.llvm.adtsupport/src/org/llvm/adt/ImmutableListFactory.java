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

package org.llvm.adt;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.type$ptr;
import org.clank.support.aliases.type$ref;
import org.llvm.support.*;
import org.llvm.adt.*;

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 139,
 FQN="llvm::ImmutableListFactory", NM="_ZN4llvm20ImmutableListFactoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactoryE")
//</editor-fold>
public class ImmutableListFactory</*typename*/ T>  implements Destructors.ClassWithDestructor {
  /*typedef ImmutableListImpl<T> ListTy*/
//  public final class ListTy extends ImmutableListImpl<T>{ };
  /*typedef FoldingSet<ListTy> CacheTy*/
//  public final class CacheTy extends FoldingSet<ImmutableListImpl<T> >{ };
  
  private final FoldingSet<ImmutableListImpl<T> > Cache;
  private final BumpPtrAllocatorImpl/*uintptr_t*/ Allocator;
  private final boolean/*uintptr_t*/ Owns$Allocator;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::ownsAllocator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 147,
   FQN="llvm::ImmutableListFactory::ownsAllocator", NM="_ZNK4llvm20ImmutableListFactory13ownsAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm20ImmutableListFactory13ownsAllocatorEv")
  //</editor-fold>
  private boolean ownsAllocator() /*const*/ {
    return Owns$Allocator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::getAllocator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 151,
   FQN="llvm::ImmutableListFactory::getAllocator", NM="_ZNK4llvm20ImmutableListFactory12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm20ImmutableListFactory12getAllocatorEv")
  //</editor-fold>
  private BumpPtrAllocatorImpl /*&*/ getAllocator() /*const*/ {
    return Allocator;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::ImmutableListFactory<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 156,
   FQN="llvm::ImmutableListFactory::ImmutableListFactory<T>", NM="_ZN4llvm20ImmutableListFactoryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactoryC1Ev")
  //</editor-fold>
  public ImmutableListFactory() {
    // : Allocator(reinterpret_cast<uintptr_t>(new BumpPtrAllocator())) 
    this.Cache = new FoldingSet<>(new DefaultFoldingSetTrait<ImmutableListImpl<T>>());
    this.Allocator = new BumpPtrAllocator();
    this.Owns$Allocator = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::ImmutableListFactory<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 159,
   FQN="llvm::ImmutableListFactory::ImmutableListFactory<T>", NM="_ZN4llvm20ImmutableListFactoryC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactoryC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public ImmutableListFactory(final BumpPtrAllocatorImpl /*&*/ Alloc) {
    // : Allocator(reinterpret_cast<uintptr_t>(&Alloc) | 0x1) 
    this.Cache = new FoldingSet<>(new DefaultFoldingSetTrait<ImmutableListImpl<T>>());
    this.Allocator = Alloc;
    this.Owns$Allocator = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::~ImmutableListFactory<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 162,
   FQN="llvm::ImmutableListFactory::~ImmutableListFactory<T>", NM="_ZN4llvm20ImmutableListFactoryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactoryD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (ownsAllocator()) {
      /*delete*/Destructors.$destroy($AddrOf(getAllocator()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::concat">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 166,
   FQN="llvm::ImmutableListFactory::concat", NM="_ZN4llvm20ImmutableListFactory6concatERKT_NS_13ImmutableListIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactory6concatERKT_NS_13ImmutableListIS1_EE")
  //</editor-fold>
  public ImmutableList<T> concat(final /*const*/ T /*&*/ Head, ImmutableList<T> Tail) {
    // Profile the new list to see if it already exists in our cache.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    type$ref<type$ptr<ImmutableListImpl<T>>/*void P*/> InsertPos = NativePointer.create_type$null$ref();

    /*const*/ ImmutableListImpl<T> /*P*/ TailImpl = Tail.getInternalPointer();
    ImmutableListImpl.<T>Profile(ID, Head, TailImpl);
    ImmutableListImpl<T> /*P*/ L = Cache.FindNodeOrInsertPos(ID, InsertPos);
    if (L == null) {
      // The list does not exist in our cache.  Create it.
      final BumpPtrAllocatorImpl /*&*/ A = getAllocator();
//      L = (ImmutableListImpl<T> /*P*/ )A.<ImmutableListImpl<T> >Allocate();
      /*FIXME: NEW_EXPR [NoNewFun]*/L = /*new (L)*/ new ImmutableListImpl(Head, TailImpl);

      // Insert the new list into the cache.
      Cache.InsertNode(L, InsertPos.$deref());
    }

    return new ImmutableList<T>(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::add">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 188,
   FQN="llvm::ImmutableListFactory::add", NM="_ZN4llvm20ImmutableListFactory3addERKT_NS_13ImmutableListIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactory3addERKT_NS_13ImmutableListIS1_EE")
  //</editor-fold>
  public ImmutableList<T> add(final /*const*/ T /*&*/ D, ImmutableList<T> L) {
    return concat(D, L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::getEmptyList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 192,
   FQN="llvm::ImmutableListFactory::getEmptyList", NM="_ZNK4llvm20ImmutableListFactory12getEmptyListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm20ImmutableListFactory12getEmptyListEv")
  //</editor-fold>
  public ImmutableList<T> getEmptyList() /*const*/ {
    return new ImmutableList<T>();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListFactory::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 196,
   FQN="llvm::ImmutableListFactory::create", NM="_ZN4llvm20ImmutableListFactory6createERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm20ImmutableListFactory6createERKT_")
  //</editor-fold>
  public ImmutableList<T> create(final /*const*/ T /*&*/ X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Cache=" + Cache // NOI18N
              + ", Allocator=" + Allocator; // NOI18N
  }
}
