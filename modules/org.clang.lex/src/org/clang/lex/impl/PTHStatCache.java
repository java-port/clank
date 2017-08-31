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

package org.clang.lex.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.clang.lex.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::PTHStatCache">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 689,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 690,
 FQN = "clang::PTHStatCache", NM = "_ZN5clang12PTHStatCacheE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang12PTHStatCacheE")
//</editor-fold>
public class PTHStatCache extends /*public*/ FileSystemStatCache implements Destructors.ClassWithDestructor {
  /*typedef llvm::OnDiskChainedHashTable<PTHStatLookupTrait> CacheTy*/
//  public final class CacheTy extends OnDiskChainedHashTable<PTHStatLookupTrait>{ };
  private OnDiskChainedHashTable<char$ptr, std.pairUCharType</*const*/ char$ptr/*char P*/ >, PTHStatData> Cache;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PTHStatCache::PTHStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 694,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 695,
   FQN = "clang::PTHStatCache::PTHStatCache", NM = "_ZN5clang12PTHStatCacheC1ERN4llvm22OnDiskChainedHashTableINS_10PTHManager18PTHFileLookupTraitEEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang12PTHStatCacheC1ERN4llvm22OnDiskChainedHashTableINS_10PTHManager18PTHFileLookupTraitEEE")
  //</editor-fold>
  public PTHStatCache(OnDiskChainedHashTable<FileEntry, std.pairUCharType</*const*/ char$ptr/*char P*/ >, PTHFileData>/*&*/ FL) {
    /* : FileSystemStatCache(), Cache(FL.getNumBuckets(), FL.getNumEntries(), FL.getBuckets(), FL.getBase())*/ 
    //START JInit
    super();
    this.Cache = new OnDiskChainedHashTable(FL.getNumBuckets(), FL.getNumEntries(), $noClone(FL.getBuckets()), $noClone(FL.getBase()), new PTHStatLookupTrait());
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PTHStatCache::getStat">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 698,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 699,
   FQN = "clang::PTHStatCache::getStat", NM = "_ZN5clang12PTHStatCache7getStatEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang12PTHStatCache7getStatEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE")
  //</editor-fold>
  @Override protected LookupResult getStat(/*const*/char$ptr/*char P*/ Path, int PathLen, FileData /*&*/ Data, boolean isFile, 
         std.unique_ptr<File> /*P*/ F, 
         FileSystem /*&*/ FS)/* override*/ {
    // Do the lookup for the file's data in the PTH file.
    PTHStatData I = Cache.$get(Path);
    
    // If we don't get a hit in the PTH file just forward to 'stat'.
    if (I == null) {
      return statChained(Path, PathLen, Data, isFile, F, FS);
    }
    
    /*const*/ PTHStatData /*&*/ D = (PTHStatData) I;
    if (!D.HasData) {
      return LookupResult.CacheMissing;
    }
    
    Data.Name.$assign(Path);
    Data.Size = D.Size;
    Data.ModTime = D.ModTime;
    Data.UniqueID.$assign(D.UniqueID);
    Data.IsDirectory = D.IsDirectory;
    Data.IsNamedPipe = false;
    Data.InPCH = true;
    
    return LookupResult.CacheExists;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PTHStatCache::~PTHStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 689,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 690,
   FQN = "clang::PTHStatCache::~PTHStatCache", NM = "_ZN5clang12PTHStatCacheD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang12PTHStatCacheD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "Cache=" + Cache // NOI18N
              + super.toString(); // NOI18N
  }
}
