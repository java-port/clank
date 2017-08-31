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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 47,
 FQN="(anonymous namespace)::PTHEntry", NM="_ZN12_GLOBAL__N_18PTHEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_18PTHEntryE")
//</editor-fold>
public class PTHEntry {
  private /*Offset*/int TokenData;
  private /*Offset*/int PPCondData;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry::PTHEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 51,
   FQN="(anonymous namespace)::PTHEntry::PTHEntry", NM="_ZN12_GLOBAL__N_18PTHEntryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_18PTHEntryC1Ev")
  //</editor-fold>
  public PTHEntry() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry::PTHEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 53,
   FQN="(anonymous namespace)::PTHEntry::PTHEntry", NM="_ZN12_GLOBAL__N_18PTHEntryC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_18PTHEntryC1Ejj")
  //</editor-fold>
  public PTHEntry(/*Offset*/int td, /*Offset*/int ppcd) {
    // : TokenData(td), PPCondData(ppcd) 
    //START JInit
    this.TokenData = td;
    this.PPCondData = ppcd;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry::getTokenOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 56,
   FQN="(anonymous namespace)::PTHEntry::getTokenOffset", NM="_ZNK12_GLOBAL__N_18PTHEntry14getTokenOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_18PTHEntry14getTokenOffsetEv")
  //</editor-fold>
  public /*Offset*/int getTokenOffset() /*const*/ {
    return TokenData;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry::getPPCondTableOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 57,
   FQN="(anonymous namespace)::PTHEntry::getPPCondTableOffset", NM="_ZNK12_GLOBAL__N_18PTHEntry20getPPCondTableOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_18PTHEntry20getPPCondTableOffsetEv")
  //</editor-fold>
  public /*Offset*/int getPPCondTableOffset() /*const*/ {
    return PPCondData;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry::PTHEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 47,
   FQN="(anonymous namespace)::PTHEntry::PTHEntry", NM="_ZN12_GLOBAL__N_18PTHEntryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_18PTHEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PTHEntry(/*const*/ PTHEntry /*&*/ $Prm0) {
    // : TokenData(.TokenData), PPCondData(.PPCondData) 
    //START JInit
    this.TokenData = $Prm0.TokenData;
    this.PPCondData = $Prm0.PPCondData;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntry::PTHEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 47,
   FQN="(anonymous namespace)::PTHEntry::PTHEntry", NM="_ZN12_GLOBAL__N_18PTHEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_18PTHEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ PTHEntry(JD$Move _dparam, PTHEntry /*&&*/$Prm0) {
    // : TokenData(static_cast<PTHEntry &&>().TokenData), PPCondData(static_cast<PTHEntry &&>().PPCondData) 
    //START JInit
    this.TokenData = $Prm0.TokenData;
    this.PPCondData = $Prm0.PPCondData;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "TokenData=" + TokenData // NOI18N
              + ", PPCondData=" + PPCondData; // NOI18N
  }
}
