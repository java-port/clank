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

package org.clang.analysis;

import org.clank.support.*;
import org.clang.ast.*;


/// \brief CodeInjector is an interface which is responsible for injecting AST
/// of function definitions that may not be available in the original source.
///
/// The getBody function will be called each time the static analyzer examines a
/// function call that has no definition available in the current translation
/// unit. If the returned statement is not a null pointer, it is assumed to be
/// the body of a function which will be used for the analysis. The source of
/// the body can be arbitrary, but it is advised to use memoization to avoid
/// unnecessary reparsing of the external source that provides the body of the
/// functions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeInjector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CodeInjector.h", line = 36,
 FQN="clang::CodeInjector", NM="_ZN5clang12CodeInjectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp -nm=_ZN5clang12CodeInjectorE")
//</editor-fold>
public abstract class CodeInjector implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeInjector::CodeInjector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp", line = 14,
   FQN="clang::CodeInjector::CodeInjector", NM="_ZN5clang12CodeInjectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp -nm=_ZN5clang12CodeInjectorC1Ev")
  //</editor-fold>
  public CodeInjector() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeInjector::~CodeInjector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp", line = 15,
   FQN="clang::CodeInjector::~CodeInjector", NM="_ZN5clang12CodeInjectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp -nm=_ZN5clang12CodeInjectorD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeInjector::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CodeInjector.h", line = 41,
   FQN="clang::CodeInjector::getBody", NM="_ZN5clang12CodeInjector7getBodyEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp -nm=_ZN5clang12CodeInjector7getBodyEPKNS_12FunctionDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Stmt /*P*/ getBody(/*const*/ FunctionDecl /*P*/ D)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeInjector::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CodeInjector.h", line = 42,
   FQN="clang::CodeInjector::getBody", NM="_ZN5clang12CodeInjector7getBodyEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CodeInjector.cpp -nm=_ZN5clang12CodeInjector7getBodyEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Stmt /*P*/ getBody(/*const*/ ObjCMethodDecl /*P*/ D)/* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
