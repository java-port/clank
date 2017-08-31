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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 307,
 FQN="(anonymous namespace)::PTHFileData", NM="_ZN12_GLOBAL__N_111PTHFileDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHFileDataE")
//</editor-fold>
public class PTHFileData {
  private /*const*//*uint32_t*/int TokenOff;
  private /*const*//*uint32_t*/int PPCondOff;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileData::PTHFileData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 311,
   FQN="(anonymous namespace)::PTHFileData::PTHFileData", NM="_ZN12_GLOBAL__N_111PTHFileDataC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHFileDataC1Ejj")
  //</editor-fold>
  public PTHFileData(/*uint32_t*/int tokenOff, /*uint32_t*/int ppCondOff) {
    /* : TokenOff(tokenOff), PPCondOff(ppCondOff)*/ 
    //START JInit
    this.TokenOff = tokenOff;
    this.PPCondOff = ppCondOff;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileData::getTokenOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 314,
   FQN="(anonymous namespace)::PTHFileData::getTokenOffset", NM="_ZNK12_GLOBAL__N_111PTHFileData14getTokenOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZNK12_GLOBAL__N_111PTHFileData14getTokenOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getTokenOffset() /*const*/ {
    return TokenOff;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileData::getPPCondOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 315,
   FQN="(anonymous namespace)::PTHFileData::getPPCondOffset", NM="_ZNK12_GLOBAL__N_111PTHFileData15getPPCondOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZNK12_GLOBAL__N_111PTHFileData15getPPCondOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getPPCondOffset() /*const*/ {
    return PPCondOff;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileData::PTHFileData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 307,
   FQN="(anonymous namespace)::PTHFileData::PTHFileData", NM="_ZN12_GLOBAL__N_111PTHFileDataC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_111PTHFileDataC1EOS0_")
  //</editor-fold>
  public /*inline*/ PTHFileData(JD$Move _dparam, PTHFileData /*&&*/$Prm0) {
    /* : TokenOff(static_cast<PTHFileData &&>().TokenOff), PPCondOff(static_cast<PTHFileData &&>().PPCondOff)*/ 
    //START JInit
    this.TokenOff = $Prm0.TokenOff;
    this.PPCondOff = $Prm0.PPCondOff;
    //END JInit
  }

  
  public String toString() {
    return "" + "TokenOff=" + TokenOff // NOI18N
              + ", PPCondOff=" + PPCondOff; // NOI18N
  }
}
