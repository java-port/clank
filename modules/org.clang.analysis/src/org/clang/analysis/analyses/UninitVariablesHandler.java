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

package org.clang.analysis.analyses;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.*;

//<editor-fold defaultstate="collapsed" desc="clang::UninitVariablesHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 100,
 FQN="clang::UninitVariablesHandler", NM="_ZN5clang22UninitVariablesHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang22UninitVariablesHandlerE")
//</editor-fold>
public class UninitVariablesHandler implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UninitVariablesHandler::UninitVariablesHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 102,
   FQN="clang::UninitVariablesHandler::UninitVariablesHandler", NM="_ZN5clang22UninitVariablesHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang22UninitVariablesHandlerC1Ev")
  //</editor-fold>
  public UninitVariablesHandler() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitVariablesHandler::~UninitVariablesHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 925,
   FQN="clang::UninitVariablesHandler::~UninitVariablesHandler", NM="_ZN5clang22UninitVariablesHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang22UninitVariablesHandlerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Called when the uninitialized variable is used at the given expression.
  //<editor-fold defaultstate="collapsed" desc="clang::UninitVariablesHandler::handleUseOfUninitVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 106,
   FQN="clang::UninitVariablesHandler::handleUseOfUninitVariable", NM="_ZN5clang22UninitVariablesHandler25handleUseOfUninitVariableEPKNS_7VarDeclERKNS_9UninitUseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang22UninitVariablesHandler25handleUseOfUninitVariableEPKNS_7VarDeclERKNS_9UninitUseE")
  //</editor-fold>
  public /*virtual*/ void handleUseOfUninitVariable(/*const*/ VarDecl /*P*/ vd, 
                           final /*const*/ UninitUse /*&*/ use) {
  }

  
  /// Called when the uninitialized variable analysis detects the
  /// idiom 'int x = x'.  All other uses of 'x' within the initializer
  /// are handled by handleUseOfUninitVariable.
  //<editor-fold defaultstate="collapsed" desc="clang::UninitVariablesHandler::handleSelfInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 112,
   FQN="clang::UninitVariablesHandler::handleSelfInit", NM="_ZN5clang22UninitVariablesHandler14handleSelfInitEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang22UninitVariablesHandler14handleSelfInitEPKNS_7VarDeclE")
  //</editor-fold>
  public /*virtual*/ void handleSelfInit(/*const*/ VarDecl /*P*/ vd) {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
