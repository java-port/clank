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

package org.clang.format.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.clang.format.*;


/// \brief Formatter that puts all tokens into a single line without breaks.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::NoLineBreakFormatter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 600,
 FQN="clang::format::(anonymous namespace)::NoLineBreakFormatter", NM="_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatterE")
//</editor-fold>
public class NoLineBreakFormatter extends /*public*/ LineFormatter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::NoLineBreakFormatter::NoLineBreakFormatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 602,
   FQN="clang::format::(anonymous namespace)::NoLineBreakFormatter::NoLineBreakFormatter", NM="_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleEPNS0_22UnwrappedLineFormatterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleEPNS0_22UnwrappedLineFormatterE")
  //</editor-fold>
  public NoLineBreakFormatter(ContinuationIndenter /*P*/ Indenter, 
      WhitespaceManager /*P*/ Whitespaces, final /*const*/ FormatStyle /*&*/ Style, 
      UnwrappedLineFormatter /*P*/ BlockFormatter) {
    // : LineFormatter(Indenter, Whitespaces, Style, BlockFormatter) 
    //START JInit
    super(Indenter, Whitespaces, Style, BlockFormatter);
    //END JInit
  }

  
  /// \brief Puts all tokens into a single line.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::NoLineBreakFormatter::formatLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 608,
   FQN="clang::format::(anonymous namespace)::NoLineBreakFormatter::formatLine", NM="_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatter10formatLineERKNS0_13AnnotatedLineEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatter10formatLineERKNS0_13AnnotatedLineEjb")
  //</editor-fold>
  @Override public /*uint*/int formatLine(final /*const*/ AnnotatedLine /*&*/ Line, /*uint*/int FirstIndent, 
            boolean DryRun)/* override*/ {
    LineState State = null;
    try {
      uint$ref Penalty = create_uint$ref(0);
      State = Indenter.getInitialState(FirstIndent, /*AddrOf*/Line, DryRun);
      while ((State.NextToken != null)) {
        formatChildren(State, /*Newline=*/ false, DryRun, Penalty);
        Indenter.addTokenToState(State, /*Newline=*/ false, DryRun);
      }
      return Penalty.$deref();
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::NoLineBreakFormatter::~NoLineBreakFormatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 600,
   FQN="clang::format::(anonymous namespace)::NoLineBreakFormatter::~NoLineBreakFormatter", NM="_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_120NoLineBreakFormatterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
