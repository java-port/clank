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
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


// TODO: Turn into a calss.
//<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilderContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 182,
 FQN="clang::ento::NodeBuilderContext", NM="_ZN5clang4ento18NodeBuilderContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento18NodeBuilderContextE")
//</editor-fold>
public class/*struct*/ NodeBuilderContext {
  public final /*const*/ CoreEngine /*&*/ Eng;
  public /*const*/ CFGBlock /*P*/ Block;
  public /*const*/ LocationContext /*P*/ LC;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilderContext::NodeBuilderContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 186,
   FQN="clang::ento::NodeBuilderContext::NodeBuilderContext", NM="_ZN5clang4ento18NodeBuilderContextC1ERKNS0_10CoreEngineEPKNS_8CFGBlockEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento18NodeBuilderContextC1ERKNS0_10CoreEngineEPKNS_8CFGBlockEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public NodeBuilderContext(final /*const*/ CoreEngine /*&*/ E, /*const*/ CFGBlock /*P*/ B, ExplodedNode /*P*/ N) {
    // : Eng(E), Block(B), LC(N->getLocationContext()) 
    //START JInit
    this./*&*/Eng=/*&*/E;
    this.Block = B;
    this.LC = N.getLocationContext();
    //END JInit
    assert Native.$bool(B);
  }

  
  /// \brief Return the CFGBlock associated with this builder.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilderContext::getBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 190,
   FQN="clang::ento::NodeBuilderContext::getBlock", NM="_ZNK5clang4ento18NodeBuilderContext8getBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento18NodeBuilderContext8getBlockEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getBlock() /*const*/ {
    return Block;
  }

  
  /// \brief Returns the number of times the current basic block has been
  /// visited on the exploded graph path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilderContext::blockCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 194,
   FQN="clang::ento::NodeBuilderContext::blockCount", NM="_ZNK5clang4ento18NodeBuilderContext10blockCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento18NodeBuilderContext10blockCountEv")
  //</editor-fold>
  public /*uint*/int blockCount() /*const*/ {
    return Eng.WList.$arrow().getBlockCounter().getNumVisited(LC.getCurrentStackFrame(), 
        Block.getBlockID());
  }

  
  @Override public String toString() {
    return "" + "Eng=" + NativeTrace.getIdentityStr(Eng) // NOI18N
              + "\nLC={" + LC // NOI18N
              + "}\nBlock=" + Block; // NOI18N
  }
}
