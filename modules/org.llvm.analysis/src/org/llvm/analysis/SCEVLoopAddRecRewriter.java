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


/// The SCEVLoopAddRecRewriter takes a scalar evolution expression and applies
/// the Map (Loop -> SCEV) to all AddRecExprs.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVLoopAddRecRewriter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 653,
 FQN="llvm::SCEVLoopAddRecRewriter", NM="_ZN4llvm22SCEVLoopAddRecRewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm22SCEVLoopAddRecRewriterE")
//</editor-fold>
public class SCEVLoopAddRecRewriter extends /*public*/ SCEVRewriteVisitor<SCEVLoopAddRecRewriter> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVLoopAddRecRewriter::rewrite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 656,
   FQN="llvm::SCEVLoopAddRecRewriter::rewrite", NM="_ZN4llvm22SCEVLoopAddRecRewriter7rewriteEPKNS_4SCEVERNS_8DenseMapIPKNS_4LoopES3_NS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S3_EEEERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm22SCEVLoopAddRecRewriter7rewriteEPKNS_4SCEVERNS_8DenseMapIPKNS_4LoopES3_NS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S3_EEEERNS_15ScalarEvolutionE")
  //</editor-fold>
  public static /*const*/ SCEV /*P*/ rewrite(/*const*/ SCEV /*P*/ Scev, final DenseMap</*const*/ Loop /*P*/ , /*const*/ SCEV /*P*/ > /*&*/ Map, 
         final ScalarEvolution /*&*/ SE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVLoopAddRecRewriter::SCEVLoopAddRecRewriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 662,
   FQN="llvm::SCEVLoopAddRecRewriter::SCEVLoopAddRecRewriter", NM="_ZN4llvm22SCEVLoopAddRecRewriterC1ERNS_15ScalarEvolutionERNS_8DenseMapIPKNS_4LoopEPKNS_4SCEVENS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm22SCEVLoopAddRecRewriterC1ERNS_15ScalarEvolutionERNS_8DenseMapIPKNS_4LoopEPKNS_4SCEVENS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S9_EEEE")
  //</editor-fold>
  public SCEVLoopAddRecRewriter(final ScalarEvolution /*&*/ SE, final DenseMap</*const*/ Loop /*P*/ , /*const*/ SCEV /*P*/ > /*&*/ M) {
    // : SCEVRewriteVisitor<SCEVLoopAddRecRewriter>(SE), Map(M) 
    super(SE);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVLoopAddRecRewriter::visitAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 665,
   FQN="llvm::SCEVLoopAddRecRewriter::visitAddRecExpr", NM="_ZN4llvm22SCEVLoopAddRecRewriter15visitAddRecExprEPKNS_14SCEVAddRecExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm22SCEVLoopAddRecRewriter15visitAddRecExprEPKNS_14SCEVAddRecExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitAddRecExpr(/*const*/ SCEVAddRecExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private final DenseMap</*const*/ Loop /*P*/ , /*const*/ SCEV /*P*/ > /*&*/ Map;
  
  @Override public String toString() {
    return "" + "Map=" + Map // NOI18N
              + super.toString(); // NOI18N
  }
}
