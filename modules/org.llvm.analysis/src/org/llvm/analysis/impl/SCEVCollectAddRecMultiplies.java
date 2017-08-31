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

package org.llvm.analysis.impl;

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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;


// Find factors that are multiplied with an expression that (possibly as a
// subexpression) contains an AddRecExpr. In the expression:
//
//  8 * (100 +  %p * %q * (%a + {0, +, 1}_loop))
//
// "%p * %q" are factors multiplied by the expression "(%a + {0, +, 1}_loop)"
// that contains the AddRec {0, +, 1}_loop. %p * %q are likely to be array size
// parameters as they form a product with an induction variable.
//
// This collector expects all array size parameters to be in the same MulExpr.
// It might be necessary to later add support for collecting parameters that are
// spread over different nested MulExpr.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVCollectAddRecMultiplies">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9015,
 FQN="(anonymous namespace)::SCEVCollectAddRecMultiplies", NM="_ZN12_GLOBAL__N_127SCEVCollectAddRecMultipliesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_127SCEVCollectAddRecMultipliesE")
//</editor-fold>
public class/*struct*/ SCEVCollectAddRecMultiplies {
  public final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Terms;
  public final ScalarEvolution /*&*/ SE;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVCollectAddRecMultiplies::SCEVCollectAddRecMultiplies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9019,
   FQN="(anonymous namespace)::SCEVCollectAddRecMultiplies::SCEVCollectAddRecMultiplies", NM="_ZN12_GLOBAL__N_127SCEVCollectAddRecMultipliesC1ERN4llvm15SmallVectorImplIPKNS1_4SCEVEEERNS1_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_127SCEVCollectAddRecMultipliesC1ERN4llvm15SmallVectorImplIPKNS1_4SCEVEEERNS1_15ScalarEvolutionE")
  //</editor-fold>
  public SCEVCollectAddRecMultiplies(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ T, final ScalarEvolution /*&*/ SE) {
    // : Terms(T), SE(SE) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVCollectAddRecMultiplies::follow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9022,
   FQN="(anonymous namespace)::SCEVCollectAddRecMultiplies::follow", NM="_ZN12_GLOBAL__N_127SCEVCollectAddRecMultiplies6followEPKN4llvm4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_127SCEVCollectAddRecMultiplies6followEPKN4llvm4SCEVE")
  //</editor-fold>
  public boolean follow(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVCollectAddRecMultiplies::isDone">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9050,
   FQN="(anonymous namespace)::SCEVCollectAddRecMultiplies::isDone", NM="_ZNK12_GLOBAL__N_127SCEVCollectAddRecMultiplies6isDoneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK12_GLOBAL__N_127SCEVCollectAddRecMultiplies6isDoneEv")
  //</editor-fold>
  public boolean isDone() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Terms=" + Terms // NOI18N
              + ", SE=" + SE; // NOI18N
  }
}
