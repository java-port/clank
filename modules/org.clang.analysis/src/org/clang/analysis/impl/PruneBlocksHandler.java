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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PruneBlocksHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 835,
 FQN="(anonymous namespace)::PruneBlocksHandler", NM="_ZN12_GLOBAL__N_118PruneBlocksHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_118PruneBlocksHandlerE")
//</editor-fold>
public class/*struct*/ PruneBlocksHandler extends /*public*/ UninitVariablesHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PruneBlocksHandler::PruneBlocksHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 836,
   FQN="(anonymous namespace)::PruneBlocksHandler::PruneBlocksHandler", NM="_ZN12_GLOBAL__N_118PruneBlocksHandlerC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_118PruneBlocksHandlerC1Ej")
  //</editor-fold>
  public PruneBlocksHandler(/*uint*/int numBlocks) {
    // : UninitVariablesHandler(), hadUse(numBlocks, false), hadAnyUse(false), currentBlock(0) 
    //START JInit
    super();
    this.hadUse = new BitVector(numBlocks, false);
    this.hadAnyUse = false;
    this.currentBlock = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PruneBlocksHandler::~PruneBlocksHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 840,
   FQN="(anonymous namespace)::PruneBlocksHandler::~PruneBlocksHandler", NM="_ZN12_GLOBAL__N_118PruneBlocksHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_118PruneBlocksHandlerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    hadUse.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// Records if a CFGBlock had a potential use of an uninitialized variable.
  public BitVector hadUse;
  
  /// Records if any CFGBlock had a potential use of an uninitialized variable.
  public boolean hadAnyUse;
  
  /// The current block to scribble use information.
  public /*uint*/int currentBlock;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PruneBlocksHandler::handleUseOfUninitVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 851,
   FQN="(anonymous namespace)::PruneBlocksHandler::handleUseOfUninitVariable", NM="_ZN12_GLOBAL__N_118PruneBlocksHandler25handleUseOfUninitVariableEPKN5clang7VarDeclERKNS1_9UninitUseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_118PruneBlocksHandler25handleUseOfUninitVariableEPKN5clang7VarDeclERKNS1_9UninitUseE")
  //</editor-fold>
  @Override public void handleUseOfUninitVariable(/*const*/ VarDecl /*P*/ vd, 
                           final /*const*/ UninitUse /*&*/ use)/* override*/ {
    hadUse.$at(currentBlock).$assign(/*KEEP_BOOL*/true);
    hadAnyUse = true;
  }

  
  /// Called when the uninitialized variable analysis detects the
  /// idiom 'int x = x'.  All other uses of 'x' within the initializer
  /// are handled by handleUseOfUninitVariable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PruneBlocksHandler::handleSelfInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 860,
   FQN="(anonymous namespace)::PruneBlocksHandler::handleSelfInit", NM="_ZN12_GLOBAL__N_118PruneBlocksHandler14handleSelfInitEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_118PruneBlocksHandler14handleSelfInitEPKN5clang7VarDeclE")
  //</editor-fold>
  @Override public void handleSelfInit(/*const*/ VarDecl /*P*/ vd)/* override*/ {
    hadUse.$at(currentBlock).$assign(/*KEEP_BOOL*/true);
    hadAnyUse = true;
  }

  
  @Override public String toString() {
    return "" + "hadUse=" + hadUse // NOI18N
              + ", hadAnyUse=" + hadAnyUse // NOI18N
              + ", currentBlock=" + currentBlock // NOI18N
              + super.toString(); // NOI18N
  }
}
