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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;


//<editor-fold defaultstate="collapsed" desc="static type CFGStmtMapStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZL10AccumulateRN4llvm8DenseMapIPKN5clang4StmtEPNS1_8CFGBlockENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S6_EEEES6_;_ZL5AsMapPv; -static-type=CFGStmtMapStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class CFGStmtMapStatics {

//<editor-fold defaultstate="collapsed" desc="AsMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp", line = 23,
 FQN="AsMap", NM="_ZL5AsMapPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZL5AsMapPv")
//</editor-fold>
public static DenseMap</*const*/ Stmt /*P*/ , CFGBlock /*P*/ > /*P*/ AsMap(Object/*void P*/ m) {
  return (DenseMap</*const*/ Stmt /*P*/ , CFGBlock /*P*/ > /*P*/)m;
}

//<editor-fold defaultstate="collapsed" desc="Accumulate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp", line = 49,
 FQN="Accumulate", NM="_ZL10AccumulateRN4llvm8DenseMapIPKN5clang4StmtEPNS1_8CFGBlockENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S6_EEEES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZL10AccumulateRN4llvm8DenseMapIPKN5clang4StmtEPNS1_8CFGBlockENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S6_EEEES6_")
//</editor-fold>
public static void Accumulate(final DenseMap</*const*/ Stmt /*P*/ , CFGBlock /*P*/ > /*&*/ SM, CFGBlock /*P*/ B) {
  // First walk the block-level expressions.
  for (std.reverse_iterator<CFGElement> I = B.begin(), E = B.end(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
    final /*const*/ CFGElement /*&*/ CE = I.$star();
    Optional<CFGStmt> CS = CE.getAs(CFGStmt.class);
    if (!CS.$bool()) {
      continue;
    }
    
    final type$ref<CFGBlock /*P*/ /*&*/> Entry = SM.ref$at(CS.$arrow().getStmt());
    // If 'Entry' is already initialized (e.g., a terminator was already),
    // skip.
    if ((Entry.$deref() != null)) {
      continue;
    }
    
    Entry.$set(B);
  }
  {
    
    // Look at the label of the block.
    Stmt /*P*/ Label = B.getLabel();
    if ((Label != null)) {
      SM.$set(Label, B);
    }
  }
  {
    
    // Finally, look at the terminator.  If the terminator was already added
    // because it is a block-level expression in another block, overwrite
    // that mapping.
    Stmt /*P*/ Term = B.getTerminator().$Stmt$P();
    if ((Term != null)) {
      SM.$set(Term, B);
    }
  }
}

} // END OF class CFGStmtMapStatics
