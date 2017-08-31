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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.lex.impl.*;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 630,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 631,
 FQN="(anonymous namespace)::PTHStatData", NM="_ZN12_GLOBAL__N_111PTHStatDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHStatDataE")
//</editor-fold>
public class PTHStatData {
/*public:*/
  public /*const*/boolean HasData;
  public long/*uint64_t*/ Size;
  public long/*time_t*/ ModTime;
  public fs.UniqueID UniqueID;
  public boolean IsDirectory;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatData::PTHStatData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 638,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 639,
   FQN="(anonymous namespace)::PTHStatData::PTHStatData", NM="_ZN12_GLOBAL__N_111PTHStatDataC1EylN4llvm3sys2fs8UniqueIDEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHStatDataC1EylN4llvm3sys2fs8UniqueIDEb")
  //</editor-fold>
  public PTHStatData(long/*uint64_t*/ Size, long/*time_t*/ ModTime, fs.UniqueID UniqueID, 
      boolean IsDirectory) {
    /* : HasData(true), Size(Size), ModTime(ModTime), UniqueID(UniqueID), IsDirectory(IsDirectory)*/ 
    //START JInit
    this.HasData = true;
    this.Size = Size;
    this.ModTime = ModTime;
    this.UniqueID = new fs.UniqueID(UniqueID);
    this.IsDirectory = IsDirectory;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatData::PTHStatData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 643,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 644,
   FQN="(anonymous namespace)::PTHStatData::PTHStatData", NM="_ZN12_GLOBAL__N_111PTHStatDataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHStatDataC1Ev")
  //</editor-fold>
  public PTHStatData() {
    /* : HasData(false), UniqueID()*/ 
    //START JInit
    this.HasData = false;
    this.UniqueID = new fs.UniqueID();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatData::PTHStatData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 630,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 631,
   FQN="(anonymous namespace)::PTHStatData::PTHStatData", NM="_ZN12_GLOBAL__N_111PTHStatDataC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHStatDataC1EOS0_")
  //</editor-fold>
  public /*inline*/ PTHStatData(JD$Move _dparam, PTHStatData /*&&*/$Prm0) {
    /* : HasData(static_cast<PTHStatData &&>().HasData), Size(static_cast<PTHStatData &&>().Size), ModTime(static_cast<PTHStatData &&>().ModTime), UniqueID(static_cast<PTHStatData &&>().UniqueID), IsDirectory(static_cast<PTHStatData &&>().IsDirectory)*/ 
    //START JInit
    this.HasData = $Prm0.HasData;
    this.Size = $Prm0.Size;
    this.ModTime = $Prm0.ModTime;
    this.UniqueID = new fs.UniqueID(JD$Move.INSTANCE, $Prm0.UniqueID);
    this.IsDirectory = $Prm0.IsDirectory;
    //END JInit
  }

  
  public String toString() {
    return "" + "HasData=" + HasData // NOI18N
              + ", Size=" + Size // NOI18N
              + ", ModTime=" + ModTime // NOI18N
              + ", UniqueID=" + UniqueID // NOI18N
              + ", IsDirectory=" + IsDirectory; // NOI18N
  }
}
