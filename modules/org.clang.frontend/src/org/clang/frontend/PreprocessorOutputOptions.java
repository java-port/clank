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

package org.clang.frontend;

import org.clank.support.*;
import org.clang.frontend.*;


/// PreprocessorOutputOptions - Options for controlling the C preprocessor
/// output (e.g., -E).
//<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOutputOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PreprocessorOutputOptions.h", line = 17,
 FQN="clang::PreprocessorOutputOptions", NM="_ZN5clang25PreprocessorOutputOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang25PreprocessorOutputOptionsE")
//</editor-fold>
public class PreprocessorOutputOptions {
/*public:*/
  public /*JBIT unsigned int*/ boolean ShowCPP /*: 1*/; ///< Print normal preprocessed output.
  public /*JBIT unsigned int*/ boolean ShowComments /*: 1*/; ///< Show comments.
  public /*JBIT unsigned int*/ boolean ShowLineMarkers /*: 1*/; ///< Show \#line markers.
  public /*JBIT unsigned int*/ boolean UseLineDirectives /*: 1*/; ///< Use \#line instead of GCC-style \# N.
  public /*JBIT unsigned int*/ boolean ShowMacroComments /*: 1*/; ///< Show comments, even in macros.
  public /*JBIT unsigned int*/ boolean ShowMacros /*: 1*/; ///< Print macro definitions.
  public /*JBIT unsigned int*/ boolean RewriteIncludes /*: 1*/; ///< Preprocess include directives only.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOutputOptions::PreprocessorOutputOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PreprocessorOutputOptions.h", line = 28,
   FQN="clang::PreprocessorOutputOptions::PreprocessorOutputOptions", NM="_ZN5clang25PreprocessorOutputOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang25PreprocessorOutputOptionsC1Ev")
  //</editor-fold>
  public PreprocessorOutputOptions() {
    ShowCPP = false;
    ShowComments = false;
    ShowLineMarkers = true;
    UseLineDirectives = false;
    ShowMacroComments = false;
    ShowMacros = false;
    RewriteIncludes = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOutputOptions::PreprocessorOutputOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PreprocessorOutputOptions.h", line = 17,
   FQN="clang::PreprocessorOutputOptions::PreprocessorOutputOptions", NM="_ZN5clang25PreprocessorOutputOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang25PreprocessorOutputOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PreprocessorOutputOptions(/*const*/ PreprocessorOutputOptions /*&*/ $Prm0) {
    // : ShowCPP(.ShowCPP), ShowComments(.ShowComments), ShowLineMarkers(.ShowLineMarkers), UseLineDirectives(.UseLineDirectives), ShowMacroComments(.ShowMacroComments), ShowMacros(.ShowMacros), RewriteIncludes(.RewriteIncludes) 
    //START JInit
    this.ShowCPP = $Prm0.ShowCPP;
    this.ShowComments = $Prm0.ShowComments;
    this.ShowLineMarkers = $Prm0.ShowLineMarkers;
    this.UseLineDirectives = $Prm0.UseLineDirectives;
    this.ShowMacroComments = $Prm0.ShowMacroComments;
    this.ShowMacros = $Prm0.ShowMacros;
    this.RewriteIncludes = $Prm0.RewriteIncludes;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "ShowCPP=" + ShowCPP // NOI18N
              + ", ShowComments=" + ShowComments // NOI18N
              + ", ShowLineMarkers=" + ShowLineMarkers // NOI18N
              + ", UseLineDirectives=" + UseLineDirectives // NOI18N
              + ", ShowMacroComments=" + ShowMacroComments // NOI18N
              + ", ShowMacros=" + ShowMacros // NOI18N
              + ", RewriteIncludes=" + RewriteIncludes; // NOI18N
  }
}
