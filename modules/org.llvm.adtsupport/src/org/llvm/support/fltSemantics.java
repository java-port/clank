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

package org.llvm.support;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/* Represents floating point arithmetic semantics.  */
//<editor-fold defaultstate="collapsed" desc="llvm::fltSemantics">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 44,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 43,
 FQN="llvm::fltSemantics", NM="_ZN4llvm12fltSemanticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12fltSemanticsE")
//</editor-fold>
public class/*struct*/ fltSemantics {
  /* The largest E such that 2^E is representable; this matches the
  definition of IEEE 754.  */
  public short maxExponent;
  
  /* The smallest E such that 2^E is a normalized number; this
  matches the definition of IEEE 754.  */
  public short minExponent;
  
  /* Number of bits in the significand.  This includes the integer
  bit.  */
  public /*uint*/int precision;
  
  /* Number of bits actually used in the semantics. */
  public /*uint*/int sizeInBits;
  //<editor-fold defaultstate="collapsed" desc="llvm::fltSemantics::fltSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 44,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 43,
   FQN="llvm::fltSemantics::fltSemantics", NM="_ZN4llvm12fltSemanticsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12fltSemanticsC1Ev")
  //</editor-fold>
  public /*inline*/ fltSemantics() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::fltSemantics::fltSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 44,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 43,
   FQN="llvm::fltSemantics::fltSemantics", NM="_ZN4llvm12fltSemanticsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12fltSemanticsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ fltSemantics(final /*const*/ fltSemantics /*&*/ $Prm0) {
    // : maxExponent(.maxExponent), minExponent(.minExponent), precision(.precision), sizeInBits(.sizeInBits) 
    //START JInit
    this.maxExponent = $Prm0.maxExponent;
    this.minExponent = $Prm0.minExponent;
    this.precision = $Prm0.precision;
    this.sizeInBits = $Prm0.sizeInBits;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::fltSemantics::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 44,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 43,
   FQN="llvm::fltSemantics::operator=", NM="_ZN4llvm12fltSemanticsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12fltSemanticsaSERKS0_")
  //</editor-fold>
  public /*inline*/ fltSemantics /*&*/ $assign(final /*const*/ fltSemantics /*&*/ $Prm0) {
    this.maxExponent = $Prm0.maxExponent;
    this.minExponent = $Prm0.minExponent;
    this.precision = $Prm0.precision;
    this.sizeInBits = $Prm0.sizeInBits;
    return /*Deref*/this;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public fltSemantics(int maxExponent, int minExponent, /*uint*/int precision, /*uint*/int sizeInBits) {
    this.maxExponent = $int2short(maxExponent);
    this.minExponent = $int2short(minExponent);
    this.precision = precision;
    this.sizeInBits = sizeInBits;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public boolean $eq(final fltSemantics $Prm0) {
    if ($Prm0 == null) {
      return false;
    }
    return this.maxExponent == $Prm0.maxExponent && this.minExponent == $Prm0.minExponent &&
            this.precision == $Prm0.precision && this.sizeInBits == $Prm0.sizeInBits;
  }
  
  @Override public String toString() {
    String namedSemantic = "";
    if (this.$eq(APFloat.IEEEsingle)) {
      namedSemantic = "IEEEsingle";
    } else if (this.$eq(APFloat.IEEEdouble)) {
      namedSemantic = "IEEEdouble";
    } else if (this.$eq(APFloat.IEEEhalf)) {
      namedSemantic = "IEEEhalf";
    } else if (this.$eq(APFloat.IEEEquad)) {
      namedSemantic = "IEEEquad";
    } else if (this.$eq(APFloat.PPCDoubleDouble)) {
      namedSemantic = "PPCDoubleDouble";
    } else if (this.$eq(APFloat.x87DoubleExtended)) {
      namedSemantic = "x87DoubleExtended";
    } else if (this.$eq(APFloat.Bogus)) {
      namedSemantic = "Bogus";
    }
    return "[" + namedSemantic + "] maxExponent=" + maxExponent // NOI18N
              + ", minExponent=" + minExponent // NOI18N
              + ", precision=" + precision // NOI18N
              + ", sizeInBits=" + sizeInBits; // NOI18N
  }
}
