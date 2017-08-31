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


//<editor-fold defaultstate="collapsed" desc="static type LazyCallGraphStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.LazyCallGraphStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL11printRefSCCRN4llvm11raw_ostreamERNS_13LazyCallGraph6RefSCCE;_ZL12printNodeDOTRN4llvm11raw_ostreamERNS_13LazyCallGraph4NodeE;_ZL14findReferencesRN4llvm15SmallVectorImplIPNS_8ConstantEEERNS_15SmallPtrSetImplIS2_EERNS0_INS_13LazyCallGraph4EdgeEEERNS_8DenseMapIPNS_8FunctionEiNS_12DenseMapInfoISE_EENS_6detail12DenseMapPairISE_iEEEE;_ZL7addEdgeRN4llvm15SmallVectorImplINS_13LazyCallGraph4EdgeEEERNS_8DenseMapIPNS_8FunctionEiNS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_iEEEERS6_NS2_4KindE;_ZL8printSCCRN4llvm11raw_ostreamERNS_13LazyCallGraph3SCCE;_ZL9printNodeRN4llvm11raw_ostreamERNS_13LazyCallGraph4NodeE; -static-type=LazyCallGraphStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class LazyCallGraphStatics {

//<editor-fold defaultstate="collapsed" desc="addEdge">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 23,
 FQN="addEdge", NM="_ZL7addEdgeRN4llvm15SmallVectorImplINS_13LazyCallGraph4EdgeEEERNS_8DenseMapIPNS_8FunctionEiNS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_iEEEERS6_NS2_4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL7addEdgeRN4llvm15SmallVectorImplINS_13LazyCallGraph4EdgeEEERNS_8DenseMapIPNS_8FunctionEiNS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_iEEEERS6_NS2_4KindE")
//</editor-fold>
public static void addEdge(final SmallVectorImpl<LazyCallGraph.Edge> /*&*/ Edges, 
       final DenseMapTypeInt<Function /*P*/ > /*&*/ EdgeIndexMap, final Function /*&*/ F, 
       LazyCallGraph.Edge.Kind EK) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="findReferences">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 43,
 FQN="findReferences", NM="_ZL14findReferencesRN4llvm15SmallVectorImplIPNS_8ConstantEEERNS_15SmallPtrSetImplIS2_EERNS0_INS_13LazyCallGraph4EdgeEEERNS_8DenseMapIPNS_8FunctionEiNS_12DenseMapInfoISE_EENS_6detail12DenseMapPairISE_iEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL14findReferencesRN4llvm15SmallVectorImplIPNS_8ConstantEEERNS_15SmallPtrSetImplIS2_EERNS0_INS_13LazyCallGraph4EdgeEEERNS_8DenseMapIPNS_8FunctionEiNS_12DenseMapInfoISE_EENS_6detail12DenseMapPairISE_iEEEE")
//</editor-fold>
public static void findReferences(final SmallVectorImpl<Constant /*P*/ > /*&*/ Worklist, 
              final SmallPtrSetImpl<Constant /*P*/ > /*&*/ Visited, 
              final SmallVectorImpl<LazyCallGraph.Edge> /*&*/ Edges, 
              final DenseMapTypeInt<Function /*P*/ > /*&*/ EdgeIndexMap) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="printNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1518,
 FQN="printNode", NM="_ZL9printNodeRN4llvm11raw_ostreamERNS_13LazyCallGraph4NodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL9printNodeRN4llvm11raw_ostreamERNS_13LazyCallGraph4NodeE")
//</editor-fold>
public static void printNode(final raw_ostream /*&*/ OS, final LazyCallGraph.Node /*&*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="printSCC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1527,
 FQN="printSCC", NM="_ZL8printSCCRN4llvm11raw_ostreamERNS_13LazyCallGraph3SCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL8printSCCRN4llvm11raw_ostreamERNS_13LazyCallGraph3SCCE")
//</editor-fold>
public static void printSCC(final raw_ostream /*&*/ OS, final LazyCallGraph.SCC /*&*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="printRefSCC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1535,
 FQN="printRefSCC", NM="_ZL11printRefSCCRN4llvm11raw_ostreamERNS_13LazyCallGraph6RefSCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL11printRefSCCRN4llvm11raw_ostreamERNS_13LazyCallGraph6RefSCCE")
//</editor-fold>
public static void printRefSCC(final raw_ostream /*&*/ OS, final LazyCallGraph.RefSCC /*&*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="printNodeDOT">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1564,
 FQN="printNodeDOT", NM="_ZL12printNodeDOTRN4llvm11raw_ostreamERNS_13LazyCallGraph4NodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZL12printNodeDOTRN4llvm11raw_ostreamERNS_13LazyCallGraph4NodeE")
//</editor-fold>
public static void printNodeDOT(final raw_ostream /*&*/ OS, final LazyCallGraph.Node /*&*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class LazyCallGraphStatics
