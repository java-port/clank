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

package org.clang.analysis.analyses.analyze_format_string;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.analysis.analyses.analyze_format_string.*;


/// Class representing optional flags with location and representation
/// information.
//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 34,
 FQN="clang::analyze_format_string::OptionalFlag", NM="_ZN5clang21analyze_format_string12OptionalFlagE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlagE")
//</editor-fold>
public class OptionalFlag implements Native.Native$Bool {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::OptionalFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 36,
   FQN="clang::analyze_format_string::OptionalFlag::OptionalFlag", NM="_ZN5clang21analyze_format_string12OptionalFlagC1EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlagC1EPKc")
  //</editor-fold>
  public OptionalFlag(/*const*/char$ptr/*char P*/ Representation) {
    // : representation(Representation), flag(false) 
    //START JInit
    this.representation = $tryClone(Representation);
    this.flag = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::isSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 38,
   FQN="clang::analyze_format_string::OptionalFlag::isSet", NM="_ZN5clang21analyze_format_string12OptionalFlag5isSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlag5isSetEv")
  //</editor-fold>
  public boolean isSet() {
    return flag;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 39,
   FQN="clang::analyze_format_string::OptionalFlag::set", NM="_ZN5clang21analyze_format_string12OptionalFlag3setEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlag3setEv")
  //</editor-fold>
  public void set() {
    flag = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 40,
   FQN="clang::analyze_format_string::OptionalFlag::clear", NM="_ZN5clang21analyze_format_string12OptionalFlag5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlag5clearEv")
  //</editor-fold>
  public void clear() {
    flag = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::setPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 41,
   FQN="clang::analyze_format_string::OptionalFlag::setPosition", NM="_ZN5clang21analyze_format_string12OptionalFlag11setPositionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlag11setPositionEPKc")
  //</editor-fold>
  public void setPosition(/*const*/char$ptr/*char P*/ position) {
    assert Native.$bool(position);
    flag = true;
    this.position = $tryClone(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::getPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 46,
   FQN="clang::analyze_format_string::OptionalFlag::getPosition", NM="_ZNK5clang21analyze_format_string12OptionalFlag11getPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang21analyze_format_string12OptionalFlag11getPositionEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPosition() /*const*/ {
    assert Native.$bool(position);
    return position;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 50,
   FQN="clang::analyze_format_string::OptionalFlag::toString", NM="_ZNK5clang21analyze_format_string12OptionalFlag8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang21analyze_format_string12OptionalFlag8toStringEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ __toString() /*const*/ {
    return representation;
  }

  
  // Overloaded operators for bool like qualities
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 53,
   FQN="clang::analyze_format_string::OptionalFlag::operator bool", NM="_ZNK5clang21analyze_format_string12OptionalFlagcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang21analyze_format_string12OptionalFlagcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return flag;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$ref is not used here*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 54,
   FQN="clang::analyze_format_string::OptionalFlag::operator=", NM="_ZN5clang21analyze_format_string12OptionalFlagaSERKb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlagaSERKb")
  //</editor-fold>
  public OptionalFlag /*&*/ $assign(final /*const*/boolean/*bool &*/ rhs) {
    flag = rhs;
    return /*Deref*/this; // Return a reference to myself.
  }

/*private:*/
  private /*const*/char$ptr/*char P*/ representation;
  private /*const*/char$ptr/*char P*/ position;
  private boolean flag;
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::OptionalFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 34,
   FQN="clang::analyze_format_string::OptionalFlag::OptionalFlag", NM="_ZN5clang21analyze_format_string12OptionalFlagC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlagC1ERKS1_")
  //</editor-fold>
  public /*inline*/ OptionalFlag(final /*const*/ OptionalFlag /*&*/ $Prm0) {
    // : representation(.representation), position(.position), flag(.flag) 
    //START JInit
    this.representation = $tryClone($Prm0.representation);
    this.position = $tryClone($Prm0.position);
    this.flag = $Prm0.flag;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalFlag::OptionalFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 34,
   FQN="clang::analyze_format_string::OptionalFlag::OptionalFlag", NM="_ZN5clang21analyze_format_string12OptionalFlagC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string12OptionalFlagC1EOS1_")
  //</editor-fold>
  public /*inline*/ OptionalFlag(JD$Move _dparam, final OptionalFlag /*&&*/$Prm0) {
    // : representation(static_cast<OptionalFlag &&>().representation), position(static_cast<OptionalFlag &&>().position), flag(static_cast<OptionalFlag &&>().flag) 
    //START JInit
    this.representation = $tryClone($Prm0.representation);
    this.position = $tryClone($Prm0.position);
    this.flag = $Prm0.flag;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "representation=" + representation // NOI18N
              + ", position=" + position // NOI18N
              + ", flag=" + flag; // NOI18N
  }
}
