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

package org.llvm.support.sys;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.*;


/// This class provides a portable interface to dynamic libraries which also
/// might be known as shared libraries, shared objects, dynamic shared
/// objects, or dynamic link libraries. Regardless of the terminology or the
/// operating system interface, this class provides a portable interface that
/// allows dynamic libraries to be loaded and searched for externally
/// defined symbols. This is typically used to provide "plug-in" support.
/// It also allows for symbols to be defined which don't live in any library,
/// but rather the main program itself, useful on Windows where the main
/// executable cannot be searched.
///
/// Note: there is currently no interface for temporarily loading a library,
/// or for unloading libraries when the LLVM library is unloaded.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/DynamicLibrary.h", line = 37,
 FQN="llvm::sys::DynamicLibrary", NM="_ZN4llvm3sys14DynamicLibraryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibraryE")
//</editor-fold>
public class DynamicLibrary {
  // Placeholder whose address represents an invalid library.
  // We use this instead of NULL or a pointer-int pair because the OS library
  // might define 0 or 1 to be "special" handles, such as "search all".
  private static /*char*/Byte Invalid = new Byte((byte)0);
  
  // Opaque data used to interface with OS-specific dynamic library handling.
  private Object/*void P*/ Data;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::DynamicLibrary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DynamicLibrary.h", line = 47,
   FQN="llvm::sys::DynamicLibrary::DynamicLibrary", NM="_ZN4llvm3sys14DynamicLibraryC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibraryC1EPv")
  //</editor-fold>
  public /*explicit*/ DynamicLibrary() {
    this($AddrOf(Invalid));
  }
  public /*explicit*/ DynamicLibrary(Object/*void P*/ data/*= &Invalid*/) {
    // : Data(data) 
    //START JInit
    this.Data = data;
    //END JInit
  }

  
  /// Returns true if the object refers to a valid library.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DynamicLibrary.h", line = 50,
   FQN="llvm::sys::DynamicLibrary::isValid", NM="_ZNK4llvm3sys14DynamicLibrary7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZNK4llvm3sys14DynamicLibrary7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Data != $AddrOf(Invalid);
  }

  
  /// Searches through the library for the symbol \p symbolName. If it is
  /// found, the address of that symbol is returned. If not, NULL is returned.
  /// Note that NULL will also be returned if the library failed to load.
  /// Use isValid() to distinguish these cases if it is important.
  /// Note that this will \e not search symbols explicitly registered by
  /// AddSymbol().
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::getAddressOfSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp", line = 84,
   FQN="llvm::sys::DynamicLibrary::getAddressOfSymbol", NM="_ZN4llvm3sys14DynamicLibrary18getAddressOfSymbolEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibrary18getAddressOfSymbolEPKc")
  //</editor-fold>
  public Object/*void P*/ getAddressOfSymbol(/*const*/char$ptr/*char P*/ symbolName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This function permanently loads the dynamic library at the given path.
  /// The library will only be unloaded when the program terminates.
  /// This returns a valid DynamicLibrary instance on success and an invalid
  /// instance on failure (see isValid()). \p *errMsg will only be modified
  /// if the library fails to load.
  ///
  /// It is safe to call this function multiple times for the same library.
  /// @brief Open a dynamic library permanently.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::getPermanentLibrary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp", line = 56,
   FQN="llvm::sys::DynamicLibrary::getPermanentLibrary", NM="_ZN4llvm3sys14DynamicLibrary19getPermanentLibraryEPKcPSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibrary19getPermanentLibraryEPKcPSs")
  //</editor-fold>
  public static DynamicLibrary getPermanentLibrary(/*const*/char$ptr/*char P*/ filename) {
    return getPermanentLibrary(filename, 
                     (std.string/*P*/ )null);
  }
  public static DynamicLibrary getPermanentLibrary(/*const*/char$ptr/*char P*/ filename, 
                     std.string/*P*/ errMsg/*= null*/) {
    SmartScopedLock/*true*/ lock = null;
    try {
      lock/*J*/= new SmartScopedLock/*true*/(true, DynamicLibraryStatics.SymbolsMutex.$star());

//      Object/*void P*/ handle = dlopen(filename, RTLD_LAZY|RTLD_GLOBAL);
//      if (!(handle != null)) {
//        if ((errMsg != null)) {
//          $Deref(errMsg).$assign_T$C$P(dlerror());
//        }
//        return new DynamicLibrary();
//      }
      // JAVA implementation
      try {
        System.load(Native.$toString(filename));
      } catch (UnsatisfiedLinkError ex) {
        $Deref(errMsg).$assign(ex.getMessage());
        return new DynamicLibrary();
      }
      Object/*void P*/ handle = Native.$toString(filename);
      
      if (!(DynamicLibraryStatics.OpenedHandles != null)) {
        DynamicLibraryStatics.OpenedHandles = new DenseSet<Object/*void P*/>(DenseMapInfo$LikePtr.$Info());
      }
      
      // If we've already loaded this library, dlclose() the handle in order to
      // keep the internal refcount at +1.
      if (!DynamicLibraryStatics.OpenedHandles.insert(handle).second) {
        //dlclose(handle);
      }
      
      return new DynamicLibrary(handle);
    } finally {
      if (lock != null) { lock.$destroy(); }
    }
  }

  
  /// This function permanently loads the dynamic library at the given path.
  /// Use this instead of getPermanentLibrary() when you won't need to get
  /// symbols from the library itself.
  ///
  /// It is safe to call this function multiple times for the same library.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::LoadLibraryPermanently">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DynamicLibrary.h", line = 76,
   FQN="llvm::sys::DynamicLibrary::LoadLibraryPermanently", NM="_ZN4llvm3sys14DynamicLibrary22LoadLibraryPermanentlyEPKcPSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibrary22LoadLibraryPermanentlyEPKcPSs")
  //</editor-fold>
  public static boolean LoadLibraryPermanently(/*const*/char$ptr/*char P*/ Filename) {
    return LoadLibraryPermanently(Filename, 
                        (std.string/*P*/ )null);
  }
  public static boolean LoadLibraryPermanently(/*const*/char$ptr/*char P*/ Filename, 
                        std.string/*P*/ ErrMsg/*= null*/) {
    return !DynamicLibrary.getPermanentLibrary(Filename, ErrMsg).isValid();
  }

  
  /// This function will search through all previously loaded dynamic
  /// libraries for the symbol \p symbolName. If it is found, the address of
  /// that symbol is returned. If not, null is returned. Note that this will
  /// search permanently loaded libraries (getPermanentLibrary()) as well
  /// as explicitly registered symbols (AddSymbol()).
  /// @throws std::string on error.
  /// @brief Search through libraries for address of a symbol
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::SearchForAddressOfSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp", line = 111,
   FQN="llvm::sys::DynamicLibrary::SearchForAddressOfSymbol", NM="_ZN4llvm3sys14DynamicLibrary24SearchForAddressOfSymbolEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibrary24SearchForAddressOfSymbolEPKc")
  //</editor-fold>
  public static Object/*void P*/ SearchForAddressOfSymbol(/*const*/char$ptr/*char P*/ symbolName) {
    SmartScopedLock/*true*/ Lock = null;
    try {
      Lock/*J*/= new SmartScopedLock/*true*/(true, DynamicLibraryStatics.SymbolsMutex.$star());
      
      // First check symbols added via AddSymbol().
      if (DynamicLibraryStatics.ExplicitSymbols.isConstructed()) {
        StringMapIterator<Object/*void P*/ > i = DynamicLibraryStatics.ExplicitSymbols.$arrow().find(/*STRINGREF_STR*/symbolName);
        if (i.$noteq(DynamicLibraryStatics.ExplicitSymbols.$arrow().end())) {
          return i.$arrow().second;
        }
      }
      // Now search the libraries.
      if ((DynamicLibraryStatics.OpenedHandles != null)) {
        for (DenseSet.iterator<Object> I = DynamicLibraryStatics.OpenedHandles.begin(), 
            E = DynamicLibraryStatics.OpenedHandles.end(); I.$noteq(E); I.$preInc()) {
          //lt_ptr ptr = lt_dlsym(*I, symbolName);
          //JAVA implementation?
          //Object/*void P*/ ptr = dlsym(I.$star(), symbolName);
          //if ((ptr != null)) {
          //  return ptr;
          //}
        }
      }
      {
        
        Object/*void P*/ Result = SearchForAddressOfSpecialSymbolStatics.DoSearch(symbolName);
        if ((Result != null)) {
          return Result;
        }
      }
      {
      }
      
      return null;
    } finally {
      if (Lock != null) { Lock.$destroy(); }
    }
  }

  
  /// @brief Convenience function for C++ophiles.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::SearchForAddressOfSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DynamicLibrary.h", line = 91,
   FQN="llvm::sys::DynamicLibrary::SearchForAddressOfSymbol", NM="_ZN4llvm3sys14DynamicLibrary24SearchForAddressOfSymbolERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibrary24SearchForAddressOfSymbolERKSs")
  //</editor-fold>
  public static Object/*void P*/ SearchForAddressOfSymbol(final /*const*/std.string/*&*/ symbolName) {
    return DynamicLibrary.SearchForAddressOfSymbol(symbolName.c_str());
  }

  
  /// This functions permanently adds the symbol \p symbolName with the
  /// value \p symbolValue.  These symbols are searched before any
  /// libraries.
  /// @brief Add searchable symbol/value pair.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::AddSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp", line = 30,
   FQN="llvm::sys::DynamicLibrary::AddSymbol", NM="_ZN4llvm3sys14DynamicLibrary9AddSymbolENS_9StringRefEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibrary9AddSymbolENS_9StringRefEPv")
  //</editor-fold>
  public static void AddSymbol(StringRef symbolName, 
           Object/*void P*/ symbolValue) {
    SmartScopedLock/*true*/ lock = null;
    try {
      lock/*J*/= new SmartScopedLock/*true*/(true, DynamicLibraryStatics.SymbolsMutex.$star());
      (DynamicLibraryStatics.ExplicitSymbols.$star()).$set(/*NO_COPY*/symbolName, symbolValue);
    } finally {
      if (lock != null) { lock.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::DynamicLibrary::DynamicLibrary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DynamicLibrary.h", line = 37,
   FQN="llvm::sys::DynamicLibrary::DynamicLibrary", NM="_ZN4llvm3sys14DynamicLibraryC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DynamicLibrary.cpp -nm=_ZN4llvm3sys14DynamicLibraryC1EOS1_")
  //</editor-fold>
  public /*inline*/ DynamicLibrary(JD$Move _dparam, final DynamicLibrary /*&&*/$Prm0) {
    // : Data(static_cast<DynamicLibrary &&>().Data) 
    //START JInit
    this.Data = $Prm0.Data;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Data=" + NativeTrace.getIdentityStr(Data); // NOI18N
  }
}
