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

package org.clang.sema;

import org.clank.support.*;
import org.clang.ast.*;


/// \brief An abstract interface that should be implemented by
/// clients that read ASTs and then require further semantic
/// analysis of the entities in those ASTs.
//<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaConsumer.h", line = 26,
 FQN="clang::SemaConsumer", NM="_ZN5clang12SemaConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumerE")
//</editor-fold>
public class SemaConsumer extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp", line = 14,
   FQN="clang::SemaConsumer::anchor", NM="_ZN5clang12SemaConsumer6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumer6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer::SemaConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaConsumer.h", line = 29,
   FQN="clang::SemaConsumer::SemaConsumer", NM="_ZN5clang12SemaConsumerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumerC1Ev")
  //</editor-fold>
  public SemaConsumer() {
    // : ASTConsumer() 
    //START JInit
    super();
    //END JInit
    super.SemaConsumer = true;
  }

  
  /// \brief Initialize the semantic consumer with the Sema instance
  /// being used to perform semantic analysis on the abstract syntax
  /// tree.
  //<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer::InitializeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaConsumer.h", line = 36,
   FQN="clang::SemaConsumer::InitializeSema", NM="_ZN5clang12SemaConsumer14InitializeSemaERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumer14InitializeSemaERNS_4SemaE")
  //</editor-fold>
  public /*virtual*/ void InitializeSema(final Sema /*&*/ S) {
  }

  
  /// \brief Inform the semantic consumer that Sema is no longer available.
  //<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer::ForgetSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaConsumer.h", line = 39,
   FQN="clang::SemaConsumer::ForgetSema", NM="_ZN5clang12SemaConsumer10ForgetSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumer10ForgetSemaEv")
  //</editor-fold>
  public /*virtual*/ void ForgetSema() {
  }

  
  // isa/cast/dyn_cast support
  //<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaConsumer.h", line = 42,
   FQN="clang::SemaConsumer::classof", NM="_ZN5clang12SemaConsumer7classofEPKNS_11ASTConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumer7classofEPKNS_11ASTConsumerE")
  //</editor-fold>
  public static boolean classof(/*const*/ ASTConsumer /*P*/ Consumer) {
    return Consumer.SemaConsumer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SemaConsumer::~SemaConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaConsumer.h", line = 26,
   FQN="clang::SemaConsumer::~SemaConsumer", NM="_ZN5clang12SemaConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaConsumer.cpp -nm=_ZN5clang12SemaConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
