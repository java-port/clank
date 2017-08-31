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

package org.clang.lex;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Callback handler that receives notifications when performing code 
/// completion within the preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 24,
 FQN="clang::CodeCompletionHandler", NM="_ZN5clang21CodeCompletionHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandlerE")
//</editor-fold>
public interface/*class*/ CodeCompletionHandler {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::~CodeCompletionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 908,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 905,
   FQN="clang::CodeCompletionHandler::~CodeCompletionHandler", NM="_ZN5clang21CodeCompletionHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang21CodeCompletionHandlerD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$CodeCompletionHandler() {
  }


  
  /// \brief Callback invoked when performing code completion for a preprocessor
  /// directive.
  ///
  /// This callback will be invoked when the preprocessor processes a '#' at the
  /// start of a line, followed by the code-completion token.
  ///
  /// \param InConditional Whether we're inside a preprocessor conditional
  /// already.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompleteDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 36,
   FQN="clang::CodeCompletionHandler::CodeCompleteDirective", NM="_ZN5clang21CodeCompletionHandler21CodeCompleteDirectiveEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandler21CodeCompleteDirectiveEb")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CodeCompleteDirective(boolean InConditional) {
  }

  
  /// \brief Callback invoked when performing code completion within a block of
  /// code that was excluded due to preprocessor conditionals.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompleteInConditionalExclusion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 40,
   FQN="clang::CodeCompletionHandler::CodeCompleteInConditionalExclusion", NM="_ZN5clang21CodeCompletionHandler34CodeCompleteInConditionalExclusionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandler34CodeCompleteInConditionalExclusionEv")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CodeCompleteInConditionalExclusion() {
  }

  
  /// \brief Callback invoked when performing code completion in a context
  /// where the name of a macro is expected.
  ///
  /// \param IsDefinition Whether this is the definition of a macro, e.g.,
  /// in a \#define.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompleteMacroName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 47,
   FQN="clang::CodeCompletionHandler::CodeCompleteMacroName", NM="_ZN5clang21CodeCompletionHandler21CodeCompleteMacroNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandler21CodeCompleteMacroNameEb")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CodeCompleteMacroName(boolean IsDefinition) {
  }

  
  /// \brief Callback invoked when performing code completion in a preprocessor
  /// expression, such as the condition of an \#if or \#elif directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompletePreprocessorExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 51,
   FQN="clang::CodeCompletionHandler::CodeCompletePreprocessorExpression", NM="_ZN5clang21CodeCompletionHandler34CodeCompletePreprocessorExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandler34CodeCompletePreprocessorExpressionEv")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CodeCompletePreprocessorExpression() {
  }

  
  /// \brief Callback invoked when performing code completion inside a 
  /// function-like macro argument.
  ///
  /// There will be another callback invocation after the macro arguments are
  /// parsed, so this callback should generally be used to note that the next
  /// callback is invoked inside a macro argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompleteMacroArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 59,
   FQN="clang::CodeCompletionHandler::CodeCompleteMacroArgument", NM="_ZN5clang21CodeCompletionHandler25CodeCompleteMacroArgumentEPNS_14IdentifierInfoEPNS_9MacroInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandler25CodeCompleteMacroArgumentEPNS_14IdentifierInfoEPNS_9MacroInfoEj")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CodeCompleteMacroArgument(IdentifierInfo /*P*/ Macro, 
                           MacroInfo /*P*/ $MacroInfo, 
                           /*uint*/int ArgumentIndex) {
  }

  
  /// \brief Callback invoked when performing code completion in a part of the
  /// file where we expect natural language, e.g., a comment, string, or 
  /// \#error directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompleteNaturalLanguage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 66,
   FQN="clang::CodeCompletionHandler::CodeCompleteNaturalLanguage", NM="_ZN5clang21CodeCompletionHandler27CodeCompleteNaturalLanguageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandler27CodeCompleteNaturalLanguageEv")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CodeCompleteNaturalLanguage() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionHandler::CodeCompletionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/CodeCompletionHandler.h", line = 24,
   FQN="clang::CodeCompletionHandler::CodeCompletionHandler", NM="_ZN5clang21CodeCompletionHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang21CodeCompletionHandlerC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $CodeCompletionHandler() {
  }

}
