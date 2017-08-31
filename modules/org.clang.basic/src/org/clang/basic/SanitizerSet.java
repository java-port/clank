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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 48,
 FQN="clang::SanitizerSet", NM="_ZN5clang12SanitizerSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang12SanitizerSetE")
//</editor-fold>
public class/*struct*/ SanitizerSet {
  /// \brief Check if a certain (single) sanitizer is enabled.
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::has">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", old_line = 52,
   FQN="clang::SanitizerSet::has", NM="_ZNK5clang12SanitizerSet3hasEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang12SanitizerSet3hasEy")
  //</editor-fold>
  public boolean has(long/*uint64_t*/ K) /*const*/ {
    assert (llvm.isPowerOf2_64(K));
    return ((Mask & K) != 0);
  }

  
  /// \brief Check if one or more sanitizers are enabled.
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::hasOneOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", old_line = 58,
   FQN="clang::SanitizerSet::hasOneOf", NM="_ZNK5clang12SanitizerSet8hasOneOfEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang12SanitizerSet8hasOneOfEy")
  //</editor-fold>
  public boolean hasOneOf(long/*uint64_t*/ K) /*const*/ {
    return ((Mask & K) != 0);
  }

  
  /// \brief Enable or disable a certain (single) sanitizer.
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 59,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", old_line = 61,
   FQN="clang::SanitizerSet::set", NM="_ZN5clang12SanitizerSet3setEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang12SanitizerSet3setEyb")
  //</editor-fold>
  public void set(long/*uint64_t*/ K, boolean Value) {
    assert (llvm.isPowerOf2_64(K));
    Mask = Value ? (Mask | K) : (Mask & ~K);
  }

  
  /// \brief Disable all sanitizers.
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", old_line = 67,
   FQN="clang::SanitizerSet::clear", NM="_ZN5clang12SanitizerSet5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang12SanitizerSet5clearEv")
  //</editor-fold>
  public void clear() {
    Mask = 0;
  }

  
  /// \brief Returns true if at least one sanitizer is enabled.
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", old_line = 70,
   FQN="clang::SanitizerSet::empty", NM="_ZNK5clang12SanitizerSet5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang12SanitizerSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Mask == 0;
  }

  
  /// \brief Bitmask of enabled sanitizers.
  public long/*uint64_t*/ Mask/* = 0*/;
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::SanitizerSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 48,
   FQN="clang::SanitizerSet::SanitizerSet", NM="_ZN5clang12SanitizerSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang12SanitizerSetC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SanitizerSet(/*const*/ SanitizerSet /*&*/ $Prm0) {
    /* : Mask(.Mask)*/ 
    //START JInit
    this.Mask = $Prm0.Mask;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 48,
   FQN="clang::SanitizerSet::operator=", NM="_ZN5clang12SanitizerSetaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang12SanitizerSetaSERKS0_")
  //</editor-fold>
  public /*inline*/ SanitizerSet /*&*/ $assign(/*const*/ SanitizerSet /*&*/ $Prm0) {
    this.Mask = $Prm0.Mask;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::SanitizerSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 48,
   FQN="clang::SanitizerSet::SanitizerSet", NM="_ZN5clang12SanitizerSetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang12SanitizerSetC1EOS0_")
  //</editor-fold>
  public /*inline*/ SanitizerSet(JD$Move _dparam, SanitizerSet /*&&*/$Prm0) {
    /* : Mask(static_cast<SanitizerSet &&>().Mask)*/ 
    //START JInit
    this.Mask = $Prm0.Mask;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerSet::SanitizerSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", old_line = 49,
   FQN="clang::SanitizerSet::SanitizerSet", NM="_ZN5clang12SanitizerSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZN5clang12SanitizerSetC1Ev")
  //</editor-fold>
  public /*inline*/ SanitizerSet() {
    /* : Mask(0)*/ 
    //START JInit
    /*InClass*/this.Mask = 0;
    //END JInit
  }

  
  public String toString() {
    return "" + "Mask=" + Mask; // NOI18N
  }
}
