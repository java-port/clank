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

package org.clang.ast;

import org.clank.support.*;


/// \brief Structure used to store a statement, the constant value to
/// which it was evaluated (if any), and whether or not the statement
/// is an integral constant expression (if known).
//<editor-fold defaultstate="collapsed" desc="clang::EvaluatedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 739,
 FQN="clang::EvaluatedStmt", NM="_ZN5clang13EvaluatedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13EvaluatedStmtE")
//</editor-fold>
public class/*struct*/ EvaluatedStmt implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedStmt::EvaluatedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 740,
   FQN="clang::EvaluatedStmt::EvaluatedStmt", NM="_ZN5clang13EvaluatedStmtC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13EvaluatedStmtC1Ev")
  //</editor-fold>
  public EvaluatedStmt() {
    // : WasEvaluated(false), IsEvaluating(false), CheckedICE(false), CheckingICE(false), IsICE(false), Evaluated() 
    //START JInit
    this.WasEvaluated = false;
    this.IsEvaluating = false;
    this.CheckedICE = false;
    this.CheckingICE = false;
    this.IsICE = false;
    this.Evaluated = new APValue();
    //END JInit
  }

  
  /// \brief Whether this statement was already evaluated.
  public /*JBIT bool*/ boolean WasEvaluated /*: 1*/;
  
  /// \brief Whether this statement is being evaluated.
  public /*JBIT bool*/ boolean IsEvaluating /*: 1*/;
  
  /// \brief Whether we already checked whether this statement was an
  /// integral constant expression.
  public /*JBIT bool*/ boolean CheckedICE /*: 1*/;
  
  /// \brief Whether we are checking whether this statement is an
  /// integral constant expression.
  public /*JBIT bool*/ boolean CheckingICE /*: 1*/;
  
  /// \brief Whether this statement is an integral constant expression,
  /// or in C++11, whether the statement is a constant expression. Only
  /// valid if CheckedICE is true.
  public /*JBIT bool*/ boolean IsICE /*: 1*/;
  
  public Stmt /*P*/ Value;
  public APValue Evaluated;
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedStmt::~EvaluatedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 739,
   FQN="clang::EvaluatedStmt::~EvaluatedStmt", NM="_ZN5clang13EvaluatedStmtD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13EvaluatedStmtD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Evaluated.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "WasEvaluated=" + WasEvaluated // NOI18N
              + ", IsEvaluating=" + IsEvaluating // NOI18N
              + ", CheckedICE=" + CheckedICE // NOI18N
              + ", CheckingICE=" + CheckingICE // NOI18N
              + ", IsICE=" + IsICE // NOI18N
              + ", Value=" + Value // NOI18N
              + ", Evaluated=" + Evaluated; // NOI18N
  }
}
