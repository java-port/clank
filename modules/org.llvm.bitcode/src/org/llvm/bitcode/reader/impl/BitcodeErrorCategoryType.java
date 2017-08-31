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

package org.llvm.bitcode.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.bitcode.*;

// FIXME: This class is only here to support the transition to llvm::Error. It
// will be removed once this transition is complete. Clients should prefer to
// deal with the Error value directly, rather than converting to error_code.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeErrorCategoryType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6515,
 FQN="(anonymous namespace)::BitcodeErrorCategoryType", NM="_ZN12_GLOBAL__N_124BitcodeErrorCategoryTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_124BitcodeErrorCategoryTypeE")
//</editor-fold>
public class BitcodeErrorCategoryType extends /*public*/ std.error_category implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeErrorCategoryType::name">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6516,
   FQN="(anonymous namespace)::BitcodeErrorCategoryType::name", NM="_ZNK12_GLOBAL__N_124BitcodeErrorCategoryType4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_124BitcodeErrorCategoryType4nameEv")
  //</editor-fold>
  @Override public/*private*/ /*const*/String/*char P*/ name() /*const*//* override*/ {
    return "llvm.bitcode";
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeErrorCategoryType::message">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6519,
   FQN="(anonymous namespace)::BitcodeErrorCategoryType::message", NM="_ZNK12_GLOBAL__N_124BitcodeErrorCategoryType7messageEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_124BitcodeErrorCategoryType7messageEi")
  //</editor-fold>
  @Override public/*private*/ std.string message(int IE) /*const*//* override*/ {
    BitcodeError E = /*static_cast*/BitcodeError.valueOf(IE);
    switch (E) {
     case InvalidBitcodeSignature:
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Invalid bitcode signature");
     case CorruptedBitcode:
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Corrupted bitcode");
    }
    throw new llvm_unreachable("Unknown error type!");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeErrorCategoryType::~BitcodeErrorCategoryType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6515,
   FQN="(anonymous namespace)::BitcodeErrorCategoryType::~BitcodeErrorCategoryType", NM="_ZN12_GLOBAL__N_124BitcodeErrorCategoryTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_124BitcodeErrorCategoryTypeD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeErrorCategoryType::BitcodeErrorCategoryType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6515,
   FQN="(anonymous namespace)::BitcodeErrorCategoryType::BitcodeErrorCategoryType", NM="_ZN12_GLOBAL__N_124BitcodeErrorCategoryTypeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_124BitcodeErrorCategoryTypeC1Ev")
  //</editor-fold>
  public /*inline*/ BitcodeErrorCategoryType() {
    // : std::error_category() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
