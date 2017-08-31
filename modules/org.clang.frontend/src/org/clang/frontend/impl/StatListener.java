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
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.vfs.File;
import org.clang.basic.vfs.FileSystem;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;

/// StatListener - A simple "interpose" object used to monitor stat calls
/// invoked by FileManager while processing the original sources used
/// as input to PTH generation.  StatListener populates the PTHWriter's
/// file map with stat information for directories as well as negative stats.
/// Stat information for files are populated elsewhere.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 547,
 FQN="(anonymous namespace)::StatListener", NM="_ZN12_GLOBAL__N_112StatListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_112StatListenerE")
//</editor-fold>
public class StatListener extends /*public*/ FileSystemStatCache implements Destructors.ClassWithDestructor {
  private OnDiskChainedHashTableGenerator<Void/*unused*/, PTHEntryKeyVariant, PTHEntry>/*&*/ PM;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatListener::StatListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 550,
   FQN="(anonymous namespace)::StatListener::StatListener", NM="_ZN12_GLOBAL__N_112StatListenerC1ERN4llvm31OnDiskChainedHashTableGeneratorINS_21FileEntryPTHEntryInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_112StatListenerC1ERN4llvm31OnDiskChainedHashTableGeneratorINS_21FileEntryPTHEntryInfoEEE")
  //</editor-fold>
  public StatListener(OnDiskChainedHashTableGenerator<Void/*unused*/, PTHEntryKeyVariant, PTHEntry>/*&*/ pm) {
    // : FileSystemStatCache(), PM(pm) 
    //START JInit
    super();
    this./*&*/PM=/*&*/pm;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatListener::~StatListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 551,
   FQN="(anonymous namespace)::StatListener::~StatListener", NM="_ZN12_GLOBAL__N_112StatListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_112StatListenerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatListener::getStat">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra param*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 553,
   FQN="(anonymous namespace)::StatListener::getStat", NM="_ZN12_GLOBAL__N_112StatListener7getStatEPKcRN5clang8FileDataEbPSt10unique_ptrINS3_3vfs4FileESt14default_deleteIS8_EERNS7_10FileSystemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_112StatListener7getStatEPKcRN5clang8FileDataEbPSt10unique_ptrINS3_3vfs4FileESt14default_deleteIS8_EERNS7_10FileSystemE")
  //</editor-fold>
  @Override public LookupResult getStat(/*const*/char$ptr/*char P*/ Path, int PathLen, FileData /*&*/ Data, boolean isFile, 
         std.unique_ptr<File> /*P*/ F, 
         FileSystem /*&*/ FS)/* override*/ {
    LookupResult Result = statChained(Path, PathLen, Data, isFile, F, FS);
    if (Result == LookupResult.CacheMissing) { // Failed 'stat'.
      PM.insert(new PTHEntryKeyVariant(Path), new PTHEntry());
    } else if (Data.IsDirectory) {
      // Only cache directories with absolute paths.
      if (path.is_relative(new Twine(Path))) {
        return Result;
      }
      
      PM.insert(new PTHEntryKeyVariant(/*AddrOf*/Data, Path), new PTHEntry());
    }
    
    return Result;
  }

  
  @Override public String toString() {
    return "" + "PM=" + PM // NOI18N
              + super.toString(); // NOI18N
  }
}
