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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;

import org.llvm.support.sys.path;


/// \brief A stat "cache" that can be used by FileManager to keep
/// track of the results of stat() calls that occur throughout the
/// execution of the front end.
//<editor-fold defaultstate="collapsed" desc="clang::MemorizeStatCalls">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 113,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 113,
 FQN = "clang::MemorizeStatCalls", NM = "_ZN5clang17MemorizeStatCallsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang17MemorizeStatCallsE")
//</editor-fold>
public class MemorizeStatCalls extends /*public*/ FileSystemStatCache implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief The set of stat() calls that have been seen.
  public StringMap<FileData/*, BumpPtrAllocator*/> StatCalls;
  
  /*typedef llvm::StringMap<FileData, llvm::BumpPtrAllocator>::const_iterator iterator*/
//  public final class iterator extends StringMapIterator<FileData/*, BumpPtrAllocator*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::MemorizeStatCalls::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 121,
   FQN = "clang::MemorizeStatCalls::begin", NM = "_ZNK5clang17MemorizeStatCalls5beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZNK5clang17MemorizeStatCalls5beginEv")
  //</editor-fold>
  public StringMapIterator<FileData/*, BumpPtrAllocator*/> begin() /*const*/ {
    return StatCalls.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemorizeStatCalls::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 122,
   FQN = "clang::MemorizeStatCalls::end", NM = "_ZNK5clang17MemorizeStatCalls3endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZNK5clang17MemorizeStatCalls3endEv")
  //</editor-fold>
  public StringMapIterator<FileData/*, BumpPtrAllocator*/> end() /*const*/ {
    return StatCalls.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemorizeStatCalls::getStat">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp", old_line = 120,
   FQN = "clang::MemorizeStatCalls::getStat", NM = "_ZN5clang17MemorizeStatCalls7getStatEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang17MemorizeStatCalls7getStatEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE")
  //</editor-fold>
  @Override public MemorizeStatCalls.LookupResult getStat(/*const*/char$ptr/*char P*/ Path, int PathLen, FileData /*&*/ Data, boolean isFile, 
         std.unique_ptr<File> /*P*/ F, FileSystem /*&*/ FS)/* override*/ {
    LookupResult Result = statChained(Path, PathLen, Data, isFile, F, FS);
    
    // Do not cache failed stats, it is easy to construct common inconsistent
    // situations if we do, and they are not important for PCH performance (which
    // currently only needs the stats to construct the initial FileManager
    // entries).
    if (Result == LookupResult.CacheMissing) {
      return Result;
    }
    
    // Cache file 'stat' results and directories with absolutely paths.
    if (!Data.IsDirectory || path.is_absolute(Path)) {
      StatCalls.$at(new StringRef(Path)).$assign(Data);
    }
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemorizeStatCalls::~MemorizeStatCalls">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 113,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 113,
   FQN = "clang::MemorizeStatCalls::~MemorizeStatCalls", NM = "_ZN5clang17MemorizeStatCallsD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang17MemorizeStatCallsD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    StatCalls.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "StatCalls=" + StatCalls // NOI18N
              + super.toString(); // NOI18N
  }
}