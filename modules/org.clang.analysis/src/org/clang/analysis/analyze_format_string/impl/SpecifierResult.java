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

package org.clang.analysis.analyze_format_string.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 56,
 FQN="clang::analyze_format_string::SpecifierResult", NM="_ZN5clang21analyze_format_string15SpecifierResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15SpecifierResultE")
//</editor-fold>
public class SpecifierResult</*typename*/ T>  {
  private T FS;
  private /*const*/char$ptr/*char P*/ Start;
  private boolean Stop;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::SpecifierResult<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 61,
   FQN="clang::analyze_format_string::SpecifierResult::SpecifierResult<T>", NM="_ZN5clang21analyze_format_string15SpecifierResultC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15SpecifierResultC1Eb")
  //</editor-fold>
  public SpecifierResult() {
    this(false);
  }
  public SpecifierResult(boolean stop/*= false*/) {
    // : Start(null), Stop(stop) 
    //START JInit
    this.Start = null;
    this.Stop = stop;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::SpecifierResult<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 63,
   FQN="clang::analyze_format_string::SpecifierResult::SpecifierResult<T>", NM="_ZN5clang21analyze_format_string15SpecifierResultC1EPKcRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15SpecifierResultC1EPKcRKT_")
  //</editor-fold>
  public SpecifierResult(/*const*/char$ptr/*char P*/ start, 
      final /*const*/ T /*&*/ fs) {
    // : FS(fs), Start(start), Stop(false) 
    //START JInit
    this.FS = $tryClone(fs);///*ParenListExpr*/new T(fs);
    this.Start = $tryClone(start);
    this.Stop = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 67,
   FQN="clang::analyze_format_string::SpecifierResult::getStart", NM="_ZNK5clang21analyze_format_string15SpecifierResult8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15SpecifierResult8getStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getStart() /*const*/ {
    return Start;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::shouldStop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 68,
   FQN="clang::analyze_format_string::SpecifierResult::shouldStop", NM="_ZNK5clang21analyze_format_string15SpecifierResult10shouldStopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15SpecifierResult10shouldStopEv")
  //</editor-fold>
  public boolean shouldStop() /*const*/ {
    return Stop;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::hasValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 69,
   FQN="clang::analyze_format_string::SpecifierResult::hasValue", NM="_ZNK5clang21analyze_format_string15SpecifierResult8hasValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15SpecifierResult8hasValueEv")
  //</editor-fold>
  public boolean hasValue() /*const*/ {
    return Native.$noteq_iter(Start, null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 70,
   FQN="clang::analyze_format_string::SpecifierResult::getValue", NM="_ZNK5clang21analyze_format_string15SpecifierResult8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15SpecifierResult8getValueEv")
  //</editor-fold>
  public /*const*/ T /*&*/ getValue$Const() /*const*/ {
    assert Native.$bool(hasValue());
    return FS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::SpecifierResult::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatStringParsing.h", line = 74,
   FQN="clang::analyze_format_string::SpecifierResult::getValue", NM="_ZN5clang21analyze_format_string15SpecifierResult8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15SpecifierResult8getValueEv")
  //</editor-fold>
  public /*const*/ T /*&*/ getValue() {
    return FS;
   }
  
  @Override public String toString() {
    return "" + "FS=" + FS // NOI18N
              + ", Start=" + Start // NOI18N
              + ", Stop=" + Stop; // NOI18N
  }
}
