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

package org.clang.tools.services.impl;

import org.clang.basic.FileData;
import org.clang.basic.FileSystemStatCache;
import org.clang.basic.vfs.File;
import org.clang.basic.vfs.FileSystem;
import static org.clang.tools.services.impl.PreprocessorInitializer.*;
import org.clank.java.std;
import org.llvm.adt.aliases.StringMap;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.StringMapEntry;
import static org.llvm.support.llvm.$eq_RawStringRef;
import org.llvm.support.sys.path;

/**
 * shared cache of stat queries not keeping misses to reduce memory.
 * Can be used when stat provider is fast enough for not existing files 
 * and/or when invalidation for non existing data can not be done correctly.
 * @author Vladimir Voskresensky
 */
public final class SharedNoStatMissingCache extends FileSystemStatCache {
  
  private final StringMap<FileData/*, BumpPtrAllocator*/> FileStatCalls;
  private final StringMap<FileData/*, BumpPtrAllocator*/> DirectoryStatCalls;

  public SharedNoStatMissingCache(StringMap<FileData/*, BumpPtrAllocator*/> FileStatCalls,
          StringMap<FileData/*, BumpPtrAllocator*/> DirectoryStatCalls) {
    this.FileStatCalls = FileStatCalls;
    this.DirectoryStatCalls = DirectoryStatCalls;
  }

  // Implement FileSystemStatCache::getStat().
  @Override
  protected LookupResult getStat(char$ptr Path, int PathLen, FileData Data, boolean isFile, std.unique_ptr<File> /*P*/ F, FileSystem /*&*/ FS) {
    final StringMap<FileData/*, BumpPtrAllocator*/> StatCalls = isFile ? FileStatCalls : DirectoryStatCalls;
    if (true || path.is_absolute(Path)) {
      assert PathLen == std.strlen(Path);
      FileData value;
      synchronized (StatCalls) {
        // only lookup to keep map small
        value = StatCalls.lookup(Path, PathLen);
        if (value != null && value.UniqueID == INVALID_ID) { // externally invalidated
          value = null;
        }
      }
      if (value != null) {
        // got from cache
        Data.$assign(value);
        return LookupResult.CacheExists;
      }
    }
    // get and cache stat result
    if (get(Path, PathLen, Data, isFile, F, null, FS)) {
      return LookupResult.CacheMissing;
    } else {
      boolean normalized = $eq_RawStringRef(Path, PathLen, Data.Name.$array(), 0, Data.Name.size());
      // lookup normalized and use it's FileData
      FileData NormalizedValue;
      synchronized (StatCalls) {
        // time to create entry if absent
        StringMapEntry<FileData> NormalizedEntry = StatCalls.GetOrCreateValue(Data.Name.$array(), 0, Data.Name.size());
        NormalizedValue = NormalizedEntry.getValue();
        if (NormalizedValue == null || NormalizedValue.UniqueID == INVALID_ID) {
          // initialize new or update out-of-date normalized value
          NormalizedEntry.setValue(NormalizedValue = new FileData(Data));
        }
        if (!normalized) {
          // when input was not normalized, update entry associated with Path as well
          StringMapEntry<FileData> PathEntry = StatCalls.GetOrCreateValue(Path, PathLen);
          // update value for Path to point on Normalized instance
          PathEntry.setValue(NormalizedValue);
        }
      }
      Data.$assign(NormalizedValue);
      return LookupResult.CacheExists;
    }
  }

  @Override
  public void $destroy() {
    super.$destroy(); 
  }

}
