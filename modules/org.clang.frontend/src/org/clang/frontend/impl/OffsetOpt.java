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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 168,
 FQN="(anonymous namespace)::OffsetOpt", NM="_ZN12_GLOBAL__N_19OffsetOptE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19OffsetOptE")
//</editor-fold>
public class OffsetOpt {
  private boolean valid;
  private /*Offset*/int off;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt::OffsetOpt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 172,
   FQN="(anonymous namespace)::OffsetOpt::OffsetOpt", NM="_ZN12_GLOBAL__N_19OffsetOptC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19OffsetOptC1Ev")
  //</editor-fold>
  public OffsetOpt() {
    // : valid(false) 
    //START JInit
    this.valid = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt::hasOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 173,
   FQN="(anonymous namespace)::OffsetOpt::hasOffset", NM="_ZNK12_GLOBAL__N_19OffsetOpt9hasOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_19OffsetOpt9hasOffsetEv")
  //</editor-fold>
  public boolean hasOffset() /*const*/ {
    return valid;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 174,
   FQN="(anonymous namespace)::OffsetOpt::getOffset", NM="_ZNK12_GLOBAL__N_19OffsetOpt9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_19OffsetOpt9getOffsetEv")
  //</editor-fold>
  public /*Offset*/int getOffset() /*const*/ {
    assert (valid);
    return off;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt::setOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 175,
   FQN="(anonymous namespace)::OffsetOpt::setOffset", NM="_ZN12_GLOBAL__N_19OffsetOpt9setOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19OffsetOpt9setOffsetEj")
  //</editor-fold>
  public void setOffset(/*Offset*/int o) {
    off = o;
    valid = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt::OffsetOpt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 168,
   FQN="(anonymous namespace)::OffsetOpt::OffsetOpt", NM="_ZN12_GLOBAL__N_19OffsetOptC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19OffsetOptC1ERKS0_")
  //</editor-fold>
  public /*inline*/ OffsetOpt(/*const*/ OffsetOpt /*&*/ $Prm0) {
    // : valid(.valid), off(.off) 
    //START JInit
    this.valid = $Prm0.valid;
    this.off = $Prm0.off;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OffsetOpt::OffsetOpt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 168,
   FQN="(anonymous namespace)::OffsetOpt::OffsetOpt", NM="_ZN12_GLOBAL__N_19OffsetOptC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19OffsetOptC1EOS0_")
  //</editor-fold>
  public /*inline*/ OffsetOpt(JD$Move _dparam, OffsetOpt /*&&*/$Prm0) {
    // : valid(static_cast<OffsetOpt &&>().valid), off(static_cast<OffsetOpt &&>().off) 
    //START JInit
    this.valid = $Prm0.valid;
    this.off = $Prm0.off;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "valid=" + valid // NOI18N
              + ", off=" + off; // NOI18N
  }

}
