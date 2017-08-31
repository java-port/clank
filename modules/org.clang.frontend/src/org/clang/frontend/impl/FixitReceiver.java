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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.edit.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixitReceiver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 34,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 76,
 FQN="(anonymous namespace)::FixitReceiver", NM="_ZN12_GLOBAL__N_113FixitReceiverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN12_GLOBAL__N_113FixitReceiverE")
//</editor-fold>
public class FixitReceiver extends /*public*/ EditsReceiver implements Destructors.ClassWithDestructor {
  private SmallVectorImpl<FixItHint> /*&*/ MergedFixits;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixitReceiver::FixitReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 38,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 80,
   FQN="(anonymous namespace)::FixitReceiver::FixitReceiver", NM="_ZN12_GLOBAL__N_113FixitReceiverC1ERN4llvm15SmallVectorImplIN5clang9FixItHintEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN12_GLOBAL__N_113FixitReceiverC1ERN4llvm15SmallVectorImplIN5clang9FixItHintEEE")
  //</editor-fold>
  public FixitReceiver(SmallVectorImpl<FixItHint> /*&*/ MergedFixits) {
    // : EditsReceiver(), MergedFixits(MergedFixits) 
    //START JInit
    super();
    this./*&*/MergedFixits=/*&*/MergedFixits;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixitReceiver::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 40,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 82,
   FQN="(anonymous namespace)::FixitReceiver::insert", NM="_ZN12_GLOBAL__N_113FixitReceiver6insertEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN12_GLOBAL__N_113FixitReceiver6insertEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void insert(SourceLocation loc, StringRef text)/* override*/ {
    MergedFixits.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/loc, /*NO_COPY*/text));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixitReceiver::replace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 43,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 85,
   FQN="(anonymous namespace)::FixitReceiver::replace", NM="_ZN12_GLOBAL__N_113FixitReceiver7replaceEN5clang15CharSourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN12_GLOBAL__N_113FixitReceiver7replaceEN5clang15CharSourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void replace(CharSourceRange range, StringRef text)/* override*/ {
    MergedFixits.push_back_T$RR(FixItHint.CreateReplacement(/*NO_COPY*/range, /*NO_COPY*/text));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixitReceiver::~FixitReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 34,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 76,
   FQN="(anonymous namespace)::FixitReceiver::~FixitReceiver", NM="_ZN12_GLOBAL__N_113FixitReceiverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN12_GLOBAL__N_113FixitReceiverD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "MergedFixits=" + MergedFixits // NOI18N
              + super.toString(); // NOI18N
  }
}
