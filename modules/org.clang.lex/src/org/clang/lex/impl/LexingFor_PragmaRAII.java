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

package org.clang.lex.impl;

import org.clank.support.*;
import org.clang.lex.*;

/// \brief Helper class for \see Preprocessor::Handle_Pragma.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LexingFor_PragmaRAII">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 127,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 126,
 FQN="(anonymous namespace)::LexingFor_PragmaRAII", NM="_ZN12_GLOBAL__N_120LexingFor_PragmaRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120LexingFor_PragmaRAIIE")
//</editor-fold>
public class LexingFor_PragmaRAII implements Destructors.ClassWithDestructor {
  private Preprocessor /*&*/ PP;
  private boolean InMacroArgPreExpansion;
  private boolean Failed;
  private Token /*&*/ OutTok;
  private Token PragmaTok;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LexingFor_PragmaRAII::LexingFor_PragmaRAII">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 134,
   FQN="(anonymous namespace)::LexingFor_PragmaRAII::LexingFor_PragmaRAII", NM="_ZN12_GLOBAL__N_120LexingFor_PragmaRAIIC1ERN5clang12PreprocessorEbRNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120LexingFor_PragmaRAIIC1ERN5clang12PreprocessorEbRNS1_5TokenE")
  //</editor-fold>
  public LexingFor_PragmaRAII(Preprocessor /*&*/ PP, boolean InMacroArgPreExpansion, 
      Token /*&*/ Tok) {
    /* : PP(PP), InMacroArgPreExpansion(InMacroArgPreExpansion), Failed(false), OutTok(Tok), PragmaTok()*/ 
    //START JInit
    this./*&*/PP=/*&*/PP;
    this.InMacroArgPreExpansion = InMacroArgPreExpansion;
    this.Failed = false;
    this./*&*/OutTok=/*&*/Tok;
    this.PragmaTok = new Token();
    //END JInit
    if (InMacroArgPreExpansion) {
      PragmaTok.$assign(OutTok);
      PP.EnableBacktrackAtThisPos();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LexingFor_PragmaRAII::~LexingFor_PragmaRAII">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 144,
   FQN="(anonymous namespace)::LexingFor_PragmaRAII::~LexingFor_PragmaRAII", NM="_ZN12_GLOBAL__N_120LexingFor_PragmaRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120LexingFor_PragmaRAIID0Ev")
  //</editor-fold>
  public void $destroy() {
    if (InMacroArgPreExpansion) {
      if (Failed) {
        PP.CommitBacktrackedTokens();
      } else {
        PP.Backtrack();
        OutTok.$assign(PragmaTok);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LexingFor_PragmaRAII::failed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 155,
   FQN="(anonymous namespace)::LexingFor_PragmaRAII::failed", NM="_ZN12_GLOBAL__N_120LexingFor_PragmaRAII6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120LexingFor_PragmaRAII6failedEv")
  //</editor-fold>
  public void failed() {
    Failed = true;
  }

  
  public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", InMacroArgPreExpansion=" + InMacroArgPreExpansion // NOI18N
              + ", Failed=" + Failed // NOI18N
              + ", OutTok=" + OutTok // NOI18N
              + ", PragmaTok=" + PragmaTok; // NOI18N
  }
}
