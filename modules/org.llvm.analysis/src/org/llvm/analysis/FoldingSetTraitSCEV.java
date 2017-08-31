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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


// Specialize FoldingSetTrait for SCEV to avoid needing to compute
// temporary FoldingSetNodeID values.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetTrait<SCEV>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 143,
 FQN="llvm::FoldingSetTrait<SCEV>", NM="_ZN4llvm15FoldingSetTraitINS_4SCEVEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15FoldingSetTraitINS_4SCEVEEE")
//</editor-fold>
public class/*struct*/ FoldingSetTraitSCEV extends /**/ DefaultFoldingSetTrait<SCEV> {
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetTrait<SCEV>::Profile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 144,
   FQN="llvm::FoldingSetTrait<SCEV>::Profile", NM="_ZN4llvm15FoldingSetTraitINS_4SCEVEE7ProfileERKS1_RNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15FoldingSetTraitINS_4SCEVEE7ProfileERKS1_RNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public /*static*/ void Profile(final /*const*/ SCEV /*&*/ X, final FoldingSetNodeID /*&*/ ID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetTrait<SCEV>::Equals">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 147,
   FQN="llvm::FoldingSetTrait<SCEV>::Equals", NM="_ZN4llvm15FoldingSetTraitINS_4SCEVEE6EqualsERKS1_RKNS_16FoldingSetNodeIDEjRS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15FoldingSetTraitINS_4SCEVEE6EqualsERKS1_RKNS_16FoldingSetNodeIDEjRS5_")
  //</editor-fold>
  public /*static*/ boolean Equals(final /*const*/ SCEV /*&*/ X, final /*const*/ FoldingSetNodeID /*&*/ ID, 
        /*uint*/int IDHash, final FoldingSetNodeID /*&*/ TempID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetTrait<SCEV>::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 151,
   FQN="llvm::FoldingSetTrait<SCEV>::ComputeHash", NM="_ZN4llvm15FoldingSetTraitINS_4SCEVEE11ComputeHashERKS1_RNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15FoldingSetTraitINS_4SCEVEE11ComputeHashERKS1_RNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public /*static*/ /*uint*/int ComputeHash(final /*const*/ SCEV /*&*/ X, final FoldingSetNodeID /*&*/ TempID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
