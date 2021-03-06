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

package org.clang.frontend.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief Preprocessor callback class that updates a hash value with the names 
/// of all macros that have been defined by the translation unit.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 765,
 FQN="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks", NM="_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacksE")
//</editor-fold>
public class MacroDefinitionTrackerPPCallbacks extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private uint$ref/*uint &*/ Hash;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks::MacroDefinitionTrackerPPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 769,
   FQN="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks::MacroDefinitionTrackerPPCallbacks", NM="_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacksC1ERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacksC1ERj")
  //</editor-fold>
  public /*explicit*/ MacroDefinitionTrackerPPCallbacks(uint$ref/*uint &*/ Hash) {
    // : PPCallbacks(), Hash(Hash) 
    //START JInit
    super();
    this./*&*/Hash=/*&*/Hash;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks::MacroDefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*hash/eod*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 771,
   FQN="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks::MacroDefined", NM="_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacks12MacroDefinedERKN5clang5TokenEPKNS1_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacks12MacroDefinedERKN5clang5TokenEPKNS1_14MacroDirectiveE")
  //</editor-fold>
  @Override public void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, /*const*/ Token /*&*/ MacroNameTok, 
              /*const*/ MacroDirective /*P*/ MD)/* override*/ {
    Hash.$set(llvm.HashString(MacroNameTok.getIdentifierInfo().getName(), Hash.$deref()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks::~MacroDefinitionTrackerPPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 765,
   FQN="(anonymous namespace)::MacroDefinitionTrackerPPCallbacks::~MacroDefinitionTrackerPPCallbacks", NM="_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_133MacroDefinitionTrackerPPCallbacksD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Hash=" + Hash // NOI18N
              + super.toString(); // NOI18N
  }
}
