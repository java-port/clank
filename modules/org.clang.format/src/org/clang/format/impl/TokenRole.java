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
import org.clang.format.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 479,
 FQN="clang::format::TokenRole", NM="_ZN5clang6format9TokenRoleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRoleE")
//</editor-fold>
public class TokenRole implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole::TokenRole">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 481,
   FQN="clang::format::TokenRole::TokenRole", NM="_ZN5clang6format9TokenRoleC1ERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRoleC1ERKNS0_11FormatStyleE")
  //</editor-fold>
  public TokenRole(final /*const*/ FormatStyle /*&*/ Style) {
    // : Style(Style) 
    //START JInit
    this./*&*/Style=/*&*/Style;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole::~TokenRole">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 71,
   FQN="clang::format::TokenRole::~TokenRole", NM="_ZN5clang6format9TokenRoleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRoleD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \brief After the \c TokenAnnotator has finished annotating all the tokens,
  /// this function precomputes required information for formatting.
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole::precomputeFormattingInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 73,
   FQN="clang::format::TokenRole::precomputeFormattingInfos", NM="_ZN5clang6format9TokenRole25precomputeFormattingInfosEPKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRole25precomputeFormattingInfosEPKNS0_11FormatTokenE")
  //</editor-fold>
  public void precomputeFormattingInfos(/*const*/ FormatToken /*P*/ Token) {
  }

  
  /// \brief Apply the special formatting that the given role demands.
  ///
  /// Assumes that the token having this role is already formatted.
  ///
  /// Continues formatting from \p State leaving indentation to \p Indenter and
  /// returns the total penalty that this formatting incurs.
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole::formatFromToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 494,
   FQN="clang::format::TokenRole::formatFromToken", NM="_ZN5clang6format9TokenRole15formatFromTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRole15formatFromTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb")
  //</editor-fold>
  public /*virtual*/ /*uint*/int formatFromToken(final LineState /*&*/ State, 
                 ContinuationIndenter /*P*/ Indenter, 
                 boolean DryRun) {
    return 0;
  }

  
  /// \brief Same as \c formatFromToken, but assumes that the first token has
  /// already been set thereby deciding on the first line break.
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole::formatAfterToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 502,
   FQN="clang::format::TokenRole::formatAfterToken", NM="_ZN5clang6format9TokenRole16formatAfterTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRole16formatAfterTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb")
  //</editor-fold>
  public /*virtual*/ /*uint*/int formatAfterToken(final LineState /*&*/ State, 
                  ContinuationIndenter /*P*/ Indenter, 
                  boolean DryRun) {
    return 0;
  }

  
  /// \brief Notifies the \c Role that a comma was found.
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenRole::CommaFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 509,
   FQN="clang::format::TokenRole::CommaFound", NM="_ZN5clang6format9TokenRole10CommaFoundEPKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenRole10CommaFoundEPKNS0_11FormatTokenE")
  //</editor-fold>
  public /*virtual*/ void CommaFound(/*const*/ FormatToken /*P*/ Token) {
  }

/*protected:*/
  protected final /*const*/ FormatStyle /*&*/ Style;
  
  @Override public String toString() {
    return "" + "Style=" + Style; // NOI18N
  }
}
