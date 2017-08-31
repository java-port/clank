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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// This class represents a description of a function call using the number of
/// arguments and the name of the function.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CallDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 55,
 FQN="clang::ento::CallDescription", NM="_ZN5clang4ento15CallDescriptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CallDescriptionE")
//</editor-fold>
public class CallDescription {
  /*friend  CallEvent*/
  /*package*//*friend*/ /*mutable */IdentifierInfo /*P*/ II;
  /*package*//*friend*/ StringRef FuncName;
  /*package*//*friend*/ /*uint*/int RequiredArgs;
/*public:*/
  public static /*const*//*uint*/int NoArgRequirement = ~0;
  /// \brief Constructs a CallDescription object.
  ///
  /// @param FuncName The name of the function that will be matched.
  ///
  /// @param RequiredArgs The number of arguments that is expected to match a
  /// call. Omit this parameter to match every occurance of call with a given
  /// name regardless the number of arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallDescription::CallDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 70,
   FQN="clang::ento::CallDescription::CallDescription", NM="_ZN5clang4ento15CallDescriptionC1EN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CallDescriptionC1EN4llvm9StringRefEj")
  //</editor-fold>
  public CallDescription(StringRef FuncName) {
    this(FuncName, NoArgRequirement);
  }
  public CallDescription(StringRef FuncName, /*uint*/int RequiredArgs/*= NoArgRequirement*/) {
    // : II(null), FuncName(FuncName), RequiredArgs(RequiredArgs) 
    //START JInit
    this.II = null;
    this.FuncName = new StringRef(FuncName);
    this.RequiredArgs = RequiredArgs;
    //END JInit
  }

  
  /// \brief Get the name of the function that this object matches.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallDescription::getFunctionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 74,
   FQN="clang::ento::CallDescription::getFunctionName", NM="_ZNK5clang4ento15CallDescription15getFunctionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CallDescription15getFunctionNameEv")
  //</editor-fold>
  public StringRef getFunctionName() /*const*/ {
    return new StringRef(FuncName);
  }

  
  @Override public String toString() {
    return "" + "II=" + II // NOI18N
              + ", FuncName=" + FuncName // NOI18N
              + ", RequiredArgs=" + RequiredArgs; // NOI18N
  }
}
