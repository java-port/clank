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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.declcontext.DeclContextImplementation;

//<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 28,
 FQN = "clang::PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticE")
//</editor-fold>
public class PartialDiagnostic implements NativeMoveable<PartialDiagnostic>, NativeCloneable<PartialDiagnostic>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 30,
   FQN = "clang::PartialDiagnostic::(anonymous)", NM = "_ZN5clang17PartialDiagnosticE_Unnamed_enum",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    // The MaxArguments and MaxFixItHints member enum values from
    // DiagnosticsEngine are private but DiagnosticsEngine declares
    // PartialDiagnostic a friend.  These enum values are redeclared
    // here so that the nested Storage class below can access them.
    public static final int MaxArguments = DiagnosticsEngine.MaxArguments;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Storage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 38,
   FQN = "clang::PartialDiagnostic::Storage", NM = "_ZN5clang17PartialDiagnostic7StorageE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic7StorageE")
  //</editor-fold>
  public static class/*struct*/ Storage implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Storage::Storage">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 39,
     FQN = "clang::PartialDiagnostic::Storage::Storage", NM = "_ZN5clang17PartialDiagnostic7StorageC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic7StorageC1Ev")
    //</editor-fold>
    public Storage() {
      /* : NumDiagArgs(0), DiagArgumentsStr(), DiagRanges(), FixItHints()*/ 
      //START JInit
      this.NumDiagArgs = 0;
      this.DiagArgumentsStr = new$T(new std.string [10], ()->new std.string());
      this.DiagRanges = new SmallVector<CharSourceRange/*,8*/>(8, new CharSourceRange());
      this.FixItHints = new SmallVector<FixItHint>(6, new FixItHint());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Storage::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 41,
     FQN = "clang::PartialDiagnostic::Storage::(anonymous)", NM = "_ZN5clang17PartialDiagnostic7StorageE_Unnamed_enum",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic7StorageE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      /// \brief The maximum number of arguments we can hold. We
      /// currently only support up to 10 arguments (%0-%9).
      ///
      /// A single diagnostic with more than that almost certainly has to
      /// be simplified anyway.
      public static final int MaxArguments = PartialDiagnostic.MaxArguments;
    /*}*/;
    
    /// \brief The number of entries in Arguments.
    public /*uchar*/byte NumDiagArgs;
    
    /// \brief Specifies for each argument whether it is in DiagArgumentsStr
    /// or in DiagArguments.
    public /*uchar*/DiagnosticsEngine.ArgumentKind DiagArgumentsKind[/*10*/] = 
            new$T(new /*uchar*/DiagnosticsEngine.ArgumentKind [10], ()->DiagnosticsEngine.ArgumentKind.ak_std_string);
    
    /// \brief The values for the various substitution positions.
    ///
    /// This is used when the argument is not an std::string. The specific value
    /// is mangled into an intptr_t and the interpretation depends on exactly
    /// what sort of argument kind it is.
    public Object/*intptr_t*/ DiagArgumentsVal[/*10*/] = new Object/*intptr_t*/ [10];
    
    /// \brief The values for the various substitution positions that have
    /// string arguments.
    public std.string DiagArgumentsStr[/*10*/] = new std.string [10];
    
    /// \brief The list of ranges added to this diagnostic.
    public SmallVector<CharSourceRange/*,8*/> DiagRanges;
    
    /// \brief If valid, provides a hint with some code to insert, remove, or
    /// modify at a particular position.
    public SmallVector<FixItHint> FixItHints;
    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Storage::operator=">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 38,
     FQN="clang::PartialDiagnostic::Storage::operator=", NM="_ZN5clang17PartialDiagnostic7StorageaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic7StorageaSERKS1_")
    //</editor-fold>
    public /*inline*/ Storage /*&*/ $assign(final /*const*/ Storage /*&*/ $Prm0) {
      this.NumDiagArgs = $Prm0.NumDiagArgs;
      __builtin_memcpy($AddrOf(this.DiagArgumentsKind), $AddrOf($Prm0.DiagArgumentsKind)/*, SKIP_ARG*/, true/*enum as pointer*/);
      __builtin_memcpy($AddrOf(this.DiagArgumentsVal), $AddrOf($Prm0.DiagArgumentsVal)/*, SKIP_ARG*/, true);
      for (/*uint*/int __i0 = 0/*U*/; __i0 != $Prm0.DiagArgumentsStr.length/*U*/; ++__i0)  {
        this.DiagArgumentsStr[__i0].$assign($Prm0.DiagArgumentsStr[__i0]);
      }
      this.DiagRanges.$assign($Prm0.DiagRanges);
      this.FixItHints.$assign($Prm0.FixItHints);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Storage::~Storage">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 38,
     FQN = "clang::PartialDiagnostic::Storage::~Storage", NM = "_ZN5clang17PartialDiagnostic7StorageD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic7StorageD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      // JAVA PERF: no need to destory these collections
      //START JDestroy
//      FixItHints.$destroy();
//      DiagRanges.$destroy();
//      DiagArgumentsStr.$destroy();
      //END JDestroy
    }

    private Exception DebugAllocStack;
    
    public String toString() {
      return "" + "NumDiagArgs=" + NumDiagArgs // NOI18N
                + ", DiagArgumentsKind=" + DiagArgumentsKind // NOI18N
                + ", DiagArgumentsVal=" + DiagArgumentsVal // NOI18N
                + ", DiagArgumentsStr=" + DiagArgumentsStr // NOI18N
                + ", DiagRanges=" + DiagRanges // NOI18N
                + ", FixItHints=" + FixItHints; // NOI18N
    }
  };
  
  /// \brief An allocator for Storage objects, which uses a small cache to
  /// objects, used to reduce malloc()/free() traffic for partial diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::StorageAllocator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*initialization moved to constructor*/, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 78,
   FQN = "clang::PartialDiagnostic::StorageAllocator", NM = "_ZN5clang17PartialDiagnostic16StorageAllocatorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic16StorageAllocatorE")
  //</editor-fold>
  public static class StorageAllocator implements Destructors.ClassWithDestructor {
    private static final/*const*//*uint*/int NumCached = 16;
    private Storage Cached[/*16*/];
    private Storage /*P*/ FreeList[/*16*/];
    private /*uint*/int NumFreeListEntries;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::StorageAllocator::StorageAllocator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 1002,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 1001,
     FQN="clang::PartialDiagnostic::StorageAllocator::StorageAllocator", NM="_ZN5clang17PartialDiagnostic16StorageAllocatorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic16StorageAllocatorC1Ev")
    //</editor-fold>
    public StorageAllocator() {
      /* : Cached()*/ 
      //START JInit
      this.Cached = new$T(new Storage [16], ()->new Storage());
      this.FreeList =  new Storage /*P*/ [16];
      //END JInit
      for (/*uint*/int I = 0; I != NumCached; ++I)  {
        FreeList[I] = Cached[I];
      }
      NumFreeListEntries = NumCached;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::StorageAllocator::~StorageAllocator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 1008,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 1007,
     FQN="clang::PartialDiagnostic::StorageAllocator::~StorageAllocator", NM="_ZN5clang17PartialDiagnostic16StorageAllocatorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic16StorageAllocatorD0Ev")
    //</editor-fold>
    public void $destroy() {
      // Don't assert if we are in a CrashRecovery context, as this invariant may
      // be invalidated during a crash.
      assert (CrashRecoveryContext.isRecoveringFromCrash() || checkAllStoragesReleased()) : "A partial is on the lamb: " + NumFreeListEntries + " vs. " + NumCached;
      //START JDestroy
      Destructors.$destroyArray(Cached);
      //END JDestroy
    }

    /// \brief Allocate new storage.
    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::StorageAllocator::Allocate">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra clean up*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 89,
     FQN="clang::PartialDiagnostic::StorageAllocator::Allocate", NM="_ZN5clang17PartialDiagnostic16StorageAllocator8AllocateEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic16StorageAllocator8AllocateEv")
    //</editor-fold>
    @SuppressWarnings("AssertWithSideEffects")
    public Storage /*P*/ Allocate() {
      if (NumFreeListEntries == 0) {
        return new Storage();
      }

      Storage /*P*/ Result = FreeList[--NumFreeListEntries];
      Result.NumDiagArgs = $int2uchar(0);
      Result.DiagRanges.clear();
      Result.FixItHints.clear();
      // JAVA: clean up before reuse
      std.memset(create_type$ptr(Result.DiagArgumentsVal), null, Result.DiagArgumentsVal.length);      
      assert markCachedStorageAllocate(Result);
      return Result;
    }

    
    /// \brief Free the given storage object.
    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::StorageAllocator::Deallocate">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 101,
     FQN = "clang::PartialDiagnostic::StorageAllocator::Deallocate", NM = "_ZN5clang17PartialDiagnostic16StorageAllocator10DeallocateEPNS0_7StorageE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic16StorageAllocator10DeallocateEPNS0_7StorageE")
    //</editor-fold>
    @SuppressWarnings("AssertWithSideEffects")
    public void Deallocate(Storage /*P*/ S) {
      // check if pointer was from cached array
      for (Storage storage : Cached) {
        if (storage == S) {
          assert markCachedStorageDeallocate(S);
          FreeList[NumFreeListEntries++] = S;
          return;
        }
      }
//      if (S >= Cached && S <= Cached + NumCached) {
//        FreeList[NumFreeListEntries++] = S;
//        return;
//      }
      
      if (S != null) { S.$destroy();};
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    

    private StorageAllocator(JD$Misc _param) {
      // Leave all fields empty
    }

    private static final StorageAllocator JAVA_UNUSED_ALLOC = new StorageAllocator(JD$Misc.INSTANCE);

    private boolean markCachedStorageAllocate(Storage s) {
      if (NativeTrace.CHECK_STD_PTR_ACCESS_DESTROYED) {
        s.DebugAllocStack = new Exception("Not released [" + (NumFreeListEntries+1) + "] Storage from Cache");
      }
      return true;
    }
    
    private boolean markCachedStorageDeallocate(Storage s) {
      s.DebugAllocStack = null;
      return true;
    }
    
    private boolean checkAllStoragesReleased() {
      boolean allFreed = (NumFreeListEntries == NumCached);
      assert allFreed : "not all storages were released: " + NumFreeListEntries + " vs. " + NumCached;
      if (NativeTrace.CHECK_STD_PTR_ACCESS_DESTROYED) {
        NextCache:
        for (int i = 0; i < Cached.length; i++) {
          Storage storage = Cached[i];
          // should be in FreeList without AllocStack
          for (int j = 0; j < NumFreeListEntries; j++) {
            if (storage == FreeList[j]) {
              if (storage.DebugAllocStack != null) {
                NativeTrace.printStackTraceOnce(storage.DebugAllocStack);
                assert false : "how could it be storage in free list but with alloc stack?";
              }
              continue NextCache;
            }
          }
          assert (storage.DebugAllocStack != null) : "how could it be storage not found in free list but without alloc stack?";
          // found storage which was not released
          NativeTrace.printStackTraceOnce(storage.DebugAllocStack);
        }
      }
      return allFreed;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    public String toString() {
      return "" + "Cached=" + Cached // NOI18N
                + ", FreeList=" + FreeList // NOI18N
                + ", NumFreeListEntries=" + NumFreeListEntries; // NOI18N
    }
  };
/*private:*/
  // NOTE: Sema assumes that PartialDiagnostic is location-invariant
  // in the sense that its bits can be safely memcpy'ed and destructed
  // in the new location.
  
  /// \brief The diagnostic ID.
  private /*mutable *//*uint*/int DiagID;
  
  /// \brief Storage for args and ranges.
  private /*mutable */Storage /*P*/ DiagStorage;
  
  /// \brief Allocator used to allocate storage for this diagnostic.
  private StorageAllocator /*P*/ Allocator;
  
  /// \brief Retrieve storage for this particular diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 126,
   FQN = "clang::PartialDiagnostic::getStorage", NM = "_ZNK5clang17PartialDiagnostic10getStorageEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic10getStorageEv")
  //</editor-fold>
  private Storage /*P*/ getStorage() /*const*/ {
    if ((DiagStorage != null)) {
      return DiagStorage;
    }
    if ((Allocator != null)) {
      assert (Allocator != StorageAllocator.JAVA_UNUSED_ALLOC); // JAVA: added assertion
      DiagStorage = Allocator.Allocate();
    } else {
      assert (Allocator != StorageAllocator.JAVA_UNUSED_ALLOC);
      DiagStorage = new Storage();
    }
    return DiagStorage;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::freeStorage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 139,
   FQN = "clang::PartialDiagnostic::freeStorage", NM = "_ZN5clang17PartialDiagnostic11freeStorageEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic11freeStorageEv")
  //</editor-fold>
  private void freeStorage() {
    if (!(DiagStorage != null)) {
      return;
    }
    
    // The hot path for PartialDiagnostic is when we just used it to wrap an ID
    // (typically so we have the flexibility of passing a more complex
    // diagnostic into the callee, but that does not commonly occur).
    //
    // Split this out into a slow function for silly compilers (*cough*) which
    // can't do decent partial inlining.
    freeStorageSlow();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::freeStorageSlow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*reordered if statements*/, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 152,
   FQN = "clang::PartialDiagnostic::freeStorageSlow", NM = "_ZN5clang17PartialDiagnostic15freeStorageSlowEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic15freeStorageSlowEv")
  //</editor-fold>
  private void freeStorageSlow() {
    if (Allocator == StorageAllocator.JAVA_UNUSED_ALLOC) {
      // do nothing
    } else if ((Allocator != null)) {
      Allocator.Deallocate(DiagStorage);
    } else {
      if (DiagStorage != null) { DiagStorage.$destroy();};
    }
    DiagStorage = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::AddSourceRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 160,
   FQN = "clang::PartialDiagnostic::AddSourceRange", NM = "_ZNK5clang17PartialDiagnostic14AddSourceRangeERKNS_15CharSourceRangeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic14AddSourceRangeERKNS_15CharSourceRangeE")
  //</editor-fold>
  private void AddSourceRange(/*const*/CharSourceRange /*&*/ R) /*const*/ {
    if (!(DiagStorage != null)) {
      DiagStorage = getStorage();
    }
    
    DiagStorage.DiagRanges.push_back(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::AddFixItHint">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 167,
   FQN = "clang::PartialDiagnostic::AddFixItHint", NM = "_ZNK5clang17PartialDiagnostic12AddFixItHintERKNS_9FixItHintE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic12AddFixItHintERKNS_9FixItHintE")
  //</editor-fold>
  private void AddFixItHint(/*const*/FixItHint /*&*/ Hint) /*const*/ {
    if (Hint.isNull()) {
      return;
    }
    if (!(DiagStorage != null)) {
      DiagStorage = getStorage();
    }
    
    DiagStorage.FixItHints.push_back(Hint);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::NullDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 178,
   FQN = "clang::PartialDiagnostic::NullDiagnostic", NM = "_ZN5clang17PartialDiagnostic14NullDiagnosticE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic14NullDiagnosticE")
  //</editor-fold>
  public static class/*struct*/ NullDiagnostic {

    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::NullDiagnostic::NullDiagnostic">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 178,
     FQN="clang::PartialDiagnostic::NullDiagnostic::NullDiagnostic", NM="_ZN5clang17PartialDiagnostic14NullDiagnosticC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang17PartialDiagnostic14NullDiagnosticC1EOS1_")
    //</editor-fold>
    public /*inline*/ NullDiagnostic(JD$Move _dparam, NullDiagnostic /*&&*/$Prm0) {
    }

    public NullDiagnostic() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::NullDiagnostic::~NullDiagnostic">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 178,
     FQN="clang::PartialDiagnostic::NullDiagnostic::~NullDiagnostic", NM="_ZN5clang17PartialDiagnostic14NullDiagnosticD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang17PartialDiagnostic14NullDiagnosticD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    public String toString() {
      return ""; // NOI18N
    }
  };
  /// \brief Create a null partial diagnostic, which cannot carry a payload,
  /// and only exists to be swapped with a real partial diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::PartialDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 181,
   FQN = "clang::PartialDiagnostic::PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticC1ENS0_14NullDiagnosticE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticC1ENS0_14NullDiagnosticE")
  //</editor-fold>
  public PartialDiagnostic(NullDiagnostic $Prm0) {
    /* : DiagID(0), DiagStorage(null), Allocator(null)*/ 
    //START JInit
    this.DiagID = 0;
    this.DiagStorage = null;
    this.Allocator = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::PartialDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 184,
   FQN = "clang::PartialDiagnostic::PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticC1EjRNS0_16StorageAllocatorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticC1EjRNS0_16StorageAllocatorE")
  //</editor-fold>
  public PartialDiagnostic(/*uint*/int DiagID, StorageAllocator /*&*/ Allocator) {
    /* : DiagID(DiagID), DiagStorage(null), Allocator(&Allocator)*/ 
    //START JInit
    this.DiagID = DiagID;
    this.DiagStorage = null;
    this.Allocator = $AddrOf(Allocator);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::PartialDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 187,
   FQN = "clang::PartialDiagnostic::PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticC1ERKS0_")
  //</editor-fold>
  public PartialDiagnostic(/*const*/PartialDiagnostic /*&*/ Other) {
    /* : DiagID(Other.DiagID), DiagStorage(null), Allocator(Other.Allocator)*/ 
    //START JInit
    this.DiagID = Other.DiagID;
    this.DiagStorage = null;
    this.Allocator = Other.Allocator;
    //END JInit
    if ((Other.DiagStorage != null)) {
      DiagStorage = getStorage();
      /*Deref*/DiagStorage.$assign($Deref(Other.DiagStorage));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::PartialDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 196,
   FQN="clang::PartialDiagnostic::PartialDiagnostic", NM="_ZN5clang17PartialDiagnosticC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticC1EOS0_")
  //</editor-fold>
  public PartialDiagnostic(JD$Move _dparam, PartialDiagnostic /*&&*/Other) {
    /* : DiagID(Other.DiagID), DiagStorage(Other.DiagStorage), Allocator(Other.Allocator)*/ 
    //START JInit
    this.DiagID = Other.DiagID;
    this.DiagStorage = Other.DiagStorage;
    this.Allocator = Other.Allocator;
    //END JInit
    Other.DiagStorage = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::PartialDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*JAVA_UNUSED_ALLOC as a marker that there is no allocator*/, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 202,
   FQN = "clang::PartialDiagnostic::PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticC1ERKS0_PNS0_7StorageE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticC1ERKS0_PNS0_7StorageE")
  //</editor-fold>
  public PartialDiagnostic(/*const*/PartialDiagnostic /*&*/ Other, Storage /*P*/ DiagStorage) {
    /* : DiagID(Other.DiagID), DiagStorage(DiagStorage), Allocator(reinterpret_cast<StorageAllocator * >(~uintptr_t(0)))*/ 
    //START JInit
    this.DiagID = Other.DiagID;
    this.DiagStorage = DiagStorage;
    this.Allocator = StorageAllocator.JAVA_UNUSED_ALLOC;
    //END JInit
    if ((Other.DiagStorage != null)) {
      /*Deref*/this.DiagStorage.$assign($Deref(Other.DiagStorage));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::PartialDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 210,
   FQN = "clang::PartialDiagnostic::PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticC1ERKNS_10DiagnosticERNS0_16StorageAllocatorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticC1ERKNS_10DiagnosticERNS0_16StorageAllocatorE")
  //</editor-fold>
  public PartialDiagnostic(/*const*/Diagnostic /*&*/ Other, StorageAllocator /*&*/ Allocator) {
    /* : DiagID(Other.getID()), DiagStorage(null), Allocator(&Allocator)*/ 
    //START JInit
    this.DiagID = Other.getID();
    this.DiagStorage = null;
    this.Allocator = $AddrOf(Allocator);
    //END JInit
    // Copy arguments.
    for (/*uint*/int I = 0, N = Other.getNumArgs(); I != N; ++I) {
      if (Other.getArgKind(I) == DiagnosticsEngine.ArgumentKind.ak_std_string) {
        AddString(new StringRef(Other.getArgStdStr(I)));
      } else {
        AddTaggedVal(Other.getRawArg(I), Other.getArgKind(I));
      }
    }
    
    // Copy source ranges.
    for (/*uint*/int I = 0, N = Other.getNumRanges(); I != N; ++I)  {
      AddSourceRange(Other.getRange(I));
    }
    
    // Copy fix-its.
    for (/*uint*/int I = 0, N = Other.getNumFixItHints(); I != N; ++I)  {
      AddFixItHint(Other.getFixItHint(I));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 230,
   FQN = "clang::PartialDiagnostic::operator=", NM = "_ZN5clang17PartialDiagnosticaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticaSERKS0_")
  //</editor-fold>
  public PartialDiagnostic /*&*/ $assign(/*const*/PartialDiagnostic /*&*/ Other) {
    DiagID = Other.DiagID;
    if ((Other.DiagStorage != null)) {
      if (!(DiagStorage != null)) {
        DiagStorage = getStorage();
      }
      
      /*Deref*/DiagStorage.$assign($Deref(Other.DiagStorage));
    } else {
      freeStorage();
    }
    
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 244,
   FQN="clang::PartialDiagnostic::operator=", NM="_ZN5clang17PartialDiagnosticaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticaSEOS0_")
  //</editor-fold>
  public PartialDiagnostic /*&*/ $assignMove(PartialDiagnostic /*&&*/Other) {
    freeStorage();
    
    DiagID = Other.DiagID;
    DiagStorage = Other.DiagStorage;
    Allocator = Other.Allocator;
    
    Other.DiagStorage = null;
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::~PartialDiagnostic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 255,
   FQN = "clang::PartialDiagnostic::~PartialDiagnostic", NM = "_ZN5clang17PartialDiagnosticD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnosticD0Ev")
  //</editor-fold>
  public void $destroy() {
    freeStorage();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::swap">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 259,
   FQN = "clang::PartialDiagnostic::swap", NM = "_ZN5clang17PartialDiagnostic4swapERS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic4swapERS0_")
  //</editor-fold>
  public void swap(PartialDiagnostic /*&*/ PD) {
//    std.swap(DiagIDPrev, PD.DiagID);
    int DiagIDPrev = DiagID;
    DiagID = PD.DiagID;
    PD.DiagID = DiagIDPrev;
//    std.swap(DiagStorage, PD.DiagStorage);
    Storage DiagStoragePrev = DiagStorage;
    DiagStorage = PD.DiagStorage;
    PD.DiagStorage = DiagStoragePrev;
//    std.swap(Allocator, PD.Allocator);
    StorageAllocator AllocatorPrev = Allocator;
    Allocator = PD.Allocator;
    PD.Allocator = AllocatorPrev;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::getDiagID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 265,
   FQN = "clang::PartialDiagnostic::getDiagID", NM = "_ZNK5clang17PartialDiagnostic9getDiagIDEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic9getDiagIDEv")
  //</editor-fold>
  public /*uint*/int getDiagID() /*const*/ {
    return DiagID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::AddTaggedVal">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 267,
   FQN = "clang::PartialDiagnostic::AddTaggedVal", NM = "_ZNK5clang17PartialDiagnostic12AddTaggedValEiNS_17DiagnosticsEngine12ArgumentKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic12AddTaggedValEiNS_17DiagnosticsEngine12ArgumentKindE")
  //</editor-fold>
  public void AddTaggedVal(Object/*intptr_t*/ V, DiagnosticsEngine.ArgumentKind Kind) /*const*/ {
    if (!(DiagStorage != null)) {
      DiagStorage = getStorage();
    }
    assert ($uchar2int(DiagStorage.NumDiagArgs) < Storage.MaxArguments) : "Too many arguments to diagnostic!";
    DiagStorage.DiagArgumentsKind[DiagStorage.NumDiagArgs] = Kind;
    DiagStorage.DiagArgumentsVal[DiagStorage.NumDiagArgs++] = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::AddString">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 277,
   FQN = "clang::PartialDiagnostic::AddString", NM = "_ZNK5clang17PartialDiagnostic9AddStringEN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic9AddStringEN4llvm9StringRefE")
  //</editor-fold>
  public void AddString(StringRef V) /*const*/ {
    if (!(DiagStorage != null)) {
      DiagStorage = getStorage();
    }
    assert ($uchar2int(DiagStorage.NumDiagArgs) < Storage.MaxArguments) : "Too many arguments to diagnostic!";
    DiagStorage.DiagArgumentsKind[DiagStorage.NumDiagArgs] 
       = DiagnosticsEngine.ArgumentKind.ak_std_string;
    DiagStorage.DiagArgumentsStr[DiagStorage.NumDiagArgs++].$assignMove(V.$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Emit">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 288,
   FQN = "clang::PartialDiagnostic::Emit", NM = "_ZNK5clang17PartialDiagnostic4EmitERKNS_17DiagnosticBuilderE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic4EmitERKNS_17DiagnosticBuilderE")
  //</editor-fold>
  public void Emit(/*const*/DiagnosticBuilder /*&*/ DB) /*const*/ {
    if (!(DiagStorage != null)) {
      return;
    }
    
    // Add all arguments.
    for (/*uint*/int i = 0, e = $uchar2uint(DiagStorage.NumDiagArgs); i != e; ++i) {
      if (DiagStorage.DiagArgumentsKind[i] == DiagnosticsEngine.ArgumentKind.ak_std_string) {
        DB.AddString(new StringRef(DiagStorage.DiagArgumentsStr[i]));
      } else {
        DB.AddTaggedVal(DiagStorage.DiagArgumentsVal[i], 
            DiagStorage.DiagArgumentsKind[i]);
      }
    }
    
    // Add all ranges.
    for (/*const*/ CharSourceRange /*&*/ Range : DiagStorage.DiagRanges)  {
      DB.AddSourceRange(Range);
    }
    
    // Add all fix-its.
    for (/*const*/ FixItHint /*&*/ Fix : DiagStorage.FixItHints)  {
      DB.AddFixItHint(Fix);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::EmitToString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 311,
   FQN = "clang::PartialDiagnostic::EmitToString", NM = "_ZNK5clang17PartialDiagnostic12EmitToStringERNS_17DiagnosticsEngineERN4llvm15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic12EmitToStringERNS_17DiagnosticsEngineERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public void EmitToString(DiagnosticsEngine /*&*/ Diags, 
              SmallString/*&*/ Buf) /*const*/ {
    DiagnosticBuilder DB = null;
    try {
      // FIXME: It should be possible to render a diagnostic to a string without
      //        messing with the state of the diagnostics engine.
      DB/*J*/= Diags.Report(getDiagID());
      Emit(DB);
      DB.FlushCounts();
      new Diagnostic($AddrOf(Diags)).FormatDiagnostic(Buf);
      DB.Clear();
      Diags.Clear();
    } finally {
      if (DB != null) { DB.$destroy(); }
    }
  }

  
  /// \brief Clear out this partial diagnostic, giving it a new diagnostic ID
  /// and removing all of its arguments, ranges, and fix-it hints.
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::Reset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 325,
   FQN = "clang::PartialDiagnostic::Reset", NM = "_ZN5clang17PartialDiagnostic5ResetEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17PartialDiagnostic5ResetEj")
  //</editor-fold>
  public void Reset() {
    Reset(0);
  }
  public void Reset(/*uint*/int DiagID/*= 0*/) {
    this.DiagID = DiagID;
    freeStorage();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PartialDiagnostic::hasStorage">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 330,
   FQN = "clang::PartialDiagnostic::hasStorage", NM = "_ZNK5clang17PartialDiagnostic10hasStorageEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17PartialDiagnostic10hasStorageEv")
  //</editor-fold>
  public boolean hasStorage() /*const*/ {
    return DiagStorage != null;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 332,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEj")
  //</editor-fold>
  public static /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_uint(/*const*/ PartialDiagnostic /*&*/ PD, 
                             /*uint*/int I) {
    PD.AddTaggedVal(Integer.valueOf(I), DiagnosticsEngine.ArgumentKind.ak_uint);
    return PD;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 338,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEi")
  //</editor-fold>
  public static /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_int(/*const*/ PartialDiagnostic /*&*/ PD, 
                            int I) {
    PD.AddTaggedVal(Integer.valueOf(I), DiagnosticsEngine.ArgumentKind.ak_sint);
    return PD;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 344,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEPKc")
  //</editor-fold>
  public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_char$ptr$C(/*const*/ PartialDiagnostic /*&*/ PD, 
                                   /*const*/char$ptr/*char P*/ S) {
    PD.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(S), 
        DiagnosticsEngine.ArgumentKind.ak_c_string);
    return PD;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 351,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEN4llvm9StringRefE")
  //</editor-fold>
  public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_StringRef(/*const*/ PartialDiagnostic /*&*/ PD, 
                                  StringRef S) {
    
    PD.AddString(new StringRef(S));
    return PD;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 358,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_IdentifierInfo$C$P(/*const*/ PartialDiagnostic /*&*/ PD, 
                                       /*const*/ IdentifierInfo /*P*/ II) {
    PD.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(II), 
        DiagnosticsEngine.ArgumentKind.ak_identifierinfo);
    return PD;
  }

  
  // Adds a DeclContext to the diagnostic. The enable_if template magic is here
  // so that we only match those arguments that are (statically) DeclContexts;
  // other arguments that derive from DeclContext (e.g., RecordDecls) will not
  // match.
  /*friend*//*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 370,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_N5clang11DeclContextEEE5valueERKNS1_17PartialDiagnosticEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_N5clang11DeclContextEEE5valueERKNS1_17PartialDiagnosticEE4typeE")
  //</editor-fold>
  public static /*inline*/ /*<typename T>*/ /*std::enable_if<std::is_same<T, DeclContext>::value,  PartialDiagnostic  >::type*//*const*/ PartialDiagnostic /*&*/ $out$Same2DeclContext(/*const*/ PartialDiagnostic /*&*/ PD, DeclContextImplementation /*P*/ DC) {
    PD.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(DC), 
        DiagnosticsEngine.ArgumentKind.ak_declcontext);
    return PD;
  }
  
  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 379,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticENS_11SourceRangeE")
  //</editor-fold>
  public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_SourceRange(/*const*/ PartialDiagnostic /*&*/ PD, 
                                    SourceRange R) {
    PD.AddSourceRange(CharSourceRange.getTokenRange(/*NO_COPY*/R));
    return PD;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 385,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticERKNS_15CharSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticERKNS_15CharSourceRangeE")
  //</editor-fold>
  public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_CharSourceRange$C(/*const*/ PartialDiagnostic /*&*/ PD, 
                                        /*const*/ CharSourceRange /*&*/ R) {
    PD.AddSourceRange(R);
    return PD;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 391,
   FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticERKNS_9FixItHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticERKNS_9FixItHintE")
  //</editor-fold>
  public static /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_FixItHint$C(/*const*/ PartialDiagnostic /*&*/ PD, 
                                  /*const*/ FixItHint /*&*/ Hint) {
    PD.AddFixItHint(Hint);
    return PD;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public PartialDiagnostic clone() {
    return new PartialDiagnostic(this);
  }
  
  @Override
  public PartialDiagnostic move() {
    return new PartialDiagnostic(JD$Move.INSTANCE, this);
  }
  
  public void /*&*/ $MemoryCopy(/*const*/PartialDiagnostic /*&*/ Other) {
    DiagID = Other.DiagID;
    DiagStorage = Other.DiagStorage;
    this.Allocator = Other.Allocator;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  public String toString() {
    return "" + "DiagID=[" + org.clang.basic.java.diagJava.$name(DiagID) + "]" + DiagID // NOI18N
              + ", DiagStorage=" + DiagStorage // NOI18N
              + ", Allocator=" + Allocator; // NOI18N
  }
}
