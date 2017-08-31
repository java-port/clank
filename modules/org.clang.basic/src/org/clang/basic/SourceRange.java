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
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.basic.java.RangeBase;

// JAVA: MANUAL_SEMANTIC changed SourceLocation => int for fields' types

/// \brief A trivial tuple used to represent a source range.
//<editor-fold defaultstate="collapsed" desc="clang::SourceRange">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 193,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 192,
 FQN = "clang::SourceRange", NM = "_ZN5clang11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRangeE")
//</editor-fold>
public class SourceRange implements RangeBase, Native.NativePOD<SourceRange> {
  public static final SourceRange EMPTY = new SourceRange();
  
  private /*SourceLocation*/int B;
  private /*SourceLocation*/int E;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::SourceRange">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 197,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 196,
   FQN = "clang::SourceRange::SourceRange", NM = "_ZN5clang11SourceRangeC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang11SourceRangeC1Ev")
  //</editor-fold>
  public SourceRange() {
    /* : B(SourceLocation()), E(SourceLocation())*/ 
    //START JInit
    this.B = SourceLocation.getInvalid();
    this.E = SourceLocation.getInvalid();
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::SourceRange">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 198,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 197,
   FQN = "clang::SourceRange::SourceRange", NM = "_ZN5clang11SourceRangeC1ENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRangeC1ENS_14SourceLocationE")
  //</editor-fold>
  public SourceRange(SourceLocation loc) {
    /* : B(loc), E(loc)*/ 
    //START JInit
    this.B = this.E = loc.getRawEncoding();
    //END JInit
    trackInstance();
  }
  public SourceRange(/*SourceLocation*/int loc) {
    /* : B(loc), E(loc)*/ 
    //START JInit
    this.B = this.E = loc;
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::SourceRange">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 199,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 198,
   FQN = "clang::SourceRange::SourceRange", NM = "_ZN5clang11SourceRangeC1ENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRangeC1ENS_14SourceLocationES1_")
  //</editor-fold>
  public SourceRange(SourceLocation begin, SourceLocation end) {
    /* : B(begin), E(end)*/ 
    //START JInit
    this.B = begin.getRawEncoding();
    this.E = end.getRawEncoding();
    //END JInit
    trackInstance();
  }
  
  public SourceRange(/*SourceLocation*/int begin, /*SourceLocation*/int end) {
    /* : B(begin), E(end)*/ 
    //START JInit
    this.B = begin;
    this.E = end;
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::getBegin">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 201,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 200,
   FQN = "clang::SourceRange::getBegin", NM = "_ZNK5clang11SourceRange8getBeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang11SourceRange8getBeginEv")
  //</editor-fold>
  public SourceLocation getBegin() /*const*/ {
    return SourceLocation.getFromRawEncoding(B);
  }
  public /*SourceLocation*/int $getBegin() /*const*/ {
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::getEnd">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 202,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 201,
   FQN = "clang::SourceRange::getEnd", NM = "_ZNK5clang11SourceRange6getEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang11SourceRange6getEndEv")
  //</editor-fold>
  public SourceLocation getEnd() /*const*/ {
    return SourceLocation.getFromRawEncoding(E);
  }
  public /*SourceLocation*/int $getEnd() /*const*/ {
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::setBegin">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 204,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 203,
   FQN = "clang::SourceRange::setBegin", NM = "_ZN5clang11SourceRange8setBeginENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRange8setBeginENS_14SourceLocationE")
  //</editor-fold>
  public void setBegin(SourceLocation b) {
    B = b.getRawEncoding();
  }
  public void setBegin(/*SourceLocation*/int b) {
    B = b;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::setEnd">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 205,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 204,
   FQN = "clang::SourceRange::setEnd", NM = "_ZN5clang11SourceRange6setEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRange6setEndENS_14SourceLocationE")
  //</editor-fold>
  public void setEnd(SourceLocation e) {
    E = e.getRawEncoding();
  }
  public void setEnd(/*SourceLocation*/int e) {
    E = e;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::isValid">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 207,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 206,
   FQN = "clang::SourceRange::isValid", NM = "_ZNK5clang11SourceRange7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang11SourceRange7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return isValid(B, E);
  }
  // JAVA: helper for decomposed <int, int> queries
  public static boolean isValid(/*SourceLocation*/int B, /*SourceLocation*/int E) /*const*/ {
    return SourceLocation.isValid(B) && SourceLocation.isValid(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::isInvalid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 208,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 207,
   FQN = "clang::SourceRange::isInvalid", NM = "_ZNK5clang11SourceRange9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang11SourceRange9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return !isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 209,
   FQN = "clang::SourceRange::operator==", NM = "_ZNK5clang11SourceRangeeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang11SourceRangeeqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/SourceRange /*&*/ X) /*const*/ {
    return $eq_SourceLocation$C(B, X.B) && $eq_SourceLocation$C(E, X.E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 213,
   FQN = "clang::SourceRange::operator!=", NM = "_ZNK5clang11SourceRangeneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang11SourceRangeneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/SourceRange /*&*/ X) /*const*/ {
    return $noteq_SourceLocation$C(B, X.B) || $noteq_SourceLocation$C(E, X.E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::SourceRange">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 193,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 192,
   FQN = "clang::SourceRange::SourceRange", NM = "_ZN5clang11SourceRangeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SourceRange(/*const*/ SourceRange /*&*/ $Prm0) {
    /* : B(.B), E(.E)*/ 
    //START JInit
    this.B = $Prm0.B;
    this.E = $Prm0.E;
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::SourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 193,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 192,
   FQN="clang::SourceRange::SourceRange", NM="_ZN5clang11SourceRangeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRangeC1EOS0_")
  //</editor-fold>
  public /*inline*/ SourceRange(JD$Move _dparam, SourceRange /*&&*/$Prm0) {
    /* : B(static_cast<SourceRange &&>().B), E(static_cast<SourceRange &&>().E)*/ 
    //START JInit
    this.B = $Prm0.B;
    this.E = $Prm0.E;
    //END JInit
    $Prm0.B = 0;
    $Prm0.E = 0;    
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::operator=">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 193,
   optimized = Converted.Optimization.VALUE_TYPE,       
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 192,
   FQN = "clang::SourceRange::operator=", NM = "_ZN5clang11SourceRangeaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang11SourceRangeaSERKS0_")
  //</editor-fold>
  public /*inline*/ SourceRange /*&*/ $assign(/*const*/ SourceRange /*&*/ $Prm0)/* throw()*/ {
    this.B = $Prm0.B;
    this.E = $Prm0.E;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceRange::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 193,
   optimized = Converted.Optimization.VALUE_TYPE,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 192,
   FQN="clang::SourceRange::operator=", NM="_ZN5clang11SourceRangeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang11SourceRangeaSEOS0_")
  //</editor-fold>
  public /*inline*/ SourceRange /*&*/ $assignMove(SourceRange /*&&*/$Prm0) {
    this.B = $Prm0.B;
    this.E = $Prm0.E;
    $Prm0.B = 0;
    $Prm0.E = 0;
    return /*Deref*/this;
  }

  public /*inline*/ SourceRange /*&*/ $assign(/*SourceLocation*/int B_E)/* throw()*/ {
    this.B = this.E = B_E;
    return /*Deref*/this;
  }

  public /*inline*/ SourceRange /*&*/ $assign(/*SourceLocation*/int B, /*SourceLocation*/int E)/* throw()*/ {
    this.B = B;
    this.E = E;
    return /*Deref*/this;
  }
  
  @Override
  public String toString() {
    return "[" + B + "-" + E + ']';
  }  

  @Override
  public SourceRange clone() {
    return new SourceRange(this);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", SourceRange.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(SourceRange.class.getSimpleName(), instances);
    return instances;    
  }  
}
