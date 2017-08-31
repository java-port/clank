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
package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type InitHeaderSearchStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZL16CanPrefixSysrootN4llvm9StringRefE;_ZL16RemoveDuplicatesRSt6vectorIN5clang15DirectoryLookupESaIS1_EEjb; -static-type=InitHeaderSearchStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class InitHeaderSearchStatics {

// end anonymous namespace.
//<editor-fold defaultstate="collapsed" desc="CanPrefixSysroot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 108,
 FQN="CanPrefixSysroot", NM="_ZL16CanPrefixSysrootN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZL16CanPrefixSysrootN4llvm9StringRefE")
//</editor-fold>
public static boolean CanPrefixSysroot(StringRef Path) {
  return path.is_absolute(Path);
}


/// RemoveDuplicates - If there are duplicate directory entries in the specified
/// search list, remove the later (dead) ones.  Returns the number of non-system
/// headers removed, which is used to update NumAngled.
//<editor-fold defaultstate="collapsed" desc="RemoveDuplicates">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 494,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", old_line = 493,
 FQN="RemoveDuplicates", NM="_ZL16RemoveDuplicatesRSt6vectorIN5clang15DirectoryLookupESaIS1_EEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZL16RemoveDuplicatesRSt6vectorIN5clang15DirectoryLookupESaIS1_EEjb")
//</editor-fold>
public static /*uint*/int RemoveDuplicates(std.vector<DirectoryLookup>/*&*/ SearchList, 
                /*uint*/int First, boolean Verbose) {
  SmallPtrSet</*const*/ DirectoryEntry /*P*/> SeenDirs/*J*/= new SmallPtrSet</*const*/ DirectoryEntry /*P*/>(DenseMapInfo$LikePtr.$Info(), 8);
  SmallPtrSet</*const*/ DirectoryEntry /*P*/> SeenFrameworkDirs/*J*/= new SmallPtrSet</*const*/ DirectoryEntry /*P*/>(DenseMapInfo$LikePtr.$Info(), 8);
  SmallPtrSet</*const*/ HeaderMap /*P*/> SeenHeaderMaps/*J*/= new SmallPtrSet</*const*/ HeaderMap /*P*/>(DenseMapInfo$LikePtr.$Info(), 8);
  /*uint*/int NonSystemRemoved = 0;
  for (/*uint*/int i = First; i != SearchList.size(); ++i) {
    /*uint*/int DirToRemove = i;
    
    /*const*/ DirectoryLookup /*&*/ CurEntry = SearchList.$at(i);
    if (CurEntry.isNormalDir()) {
      // If this isn't the first time we've seen this dir, remove it.
      if (SeenDirs.insert(CurEntry.getDir()).second) {
        continue;
      }
    } else if (CurEntry.isFramework()) {
      // If this isn't the first time we've seen this framework dir, remove it.
      if (SeenFrameworkDirs.insert(CurEntry.getFrameworkDir()).second) {
        continue;
      }
    } else {
      assert (CurEntry.isHeaderMap()) : "Not a headermap or normal dir?";
      // If this isn't the first time we've seen this headermap, remove it.
      if (SeenHeaderMaps.insert(CurEntry.getHeaderMap()).second) {
        continue;
      }
    }
    
    // If we have a normal #include dir/framework/headermap that is shadowed
    // later in the chain by a system include location, we actually want to
    // ignore the user's request and drop the user dir... keeping the system
    // dir.  This is weird, but required to emulate GCC's search path correctly.
    //
    // Since dupes of system dirs are rare, just rescan to find the original
    // that we're nuking instead of using a DenseMap.
    if (CurEntry.getDirCharacteristic() != SrcMgr.CharacteristicKind.C_User) {
      // Find the dir that this is the same of.
      /*uint*/int FirstDir;
      for (FirstDir = 0;; ++FirstDir) {
        assert (FirstDir != i) : "Didn't find dupe?";
        
        /*const*/ DirectoryLookup /*&*/ SearchEntry = SearchList.$at(FirstDir);
        
        // If these are different lookup types, then they can't be the dupe.
        if (SearchEntry.getLookupType() != CurEntry.getLookupType()) {
          continue;
        }
        
        boolean isSame;
        if (CurEntry.isNormalDir()) {
          isSame = SearchEntry.getDir() == CurEntry.getDir();
        } else if (CurEntry.isFramework()) {
          isSame = SearchEntry.getFrameworkDir() == CurEntry.getFrameworkDir();
        } else {
          assert (CurEntry.isHeaderMap()) : "Not a headermap or normal dir?";
          isSame = SearchEntry.getHeaderMap() == CurEntry.getHeaderMap();
        }
        if (isSame) {
          break;
        }
      }
      
      // If the first dir in the search path is a non-system dir, zap it
      // instead of the system one.
      if (SearchList.$at(FirstDir).getDirCharacteristic() == SrcMgr.CharacteristicKind.C_User) {
        DirToRemove = FirstDir;
      }
    }
    if (Verbose) {
      llvm.errs().$out(/*KEEP_STR*/"ignoring duplicate directory \"").$out(
          CurEntry.getName()
      ).$out(/*KEEP_STR*/$QUOTE_LF);
      if (DirToRemove != i) {
        llvm.errs().$out(/*KEEP_STR*/"  as it is a non-system directory that duplicates ").$out(
            /*KEEP_STR*/"a system directory\n"
        );
      }
    }
    if (DirToRemove != i) {
      ++NonSystemRemoved;
    }
    
    // This is reached if the current entry is a duplicate.  Remove the
    // DirToRemove (usually the current dir).
    SearchList.erase((SearchList.begin().$add(DirToRemove)));
    --i;
  }
  return NonSystemRemoved;
}

} // END OF class InitHeaderSearchStatics
