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


// We use ReachabilitySet to keep track of value aliases (The nonterminal "V" in
// the paper) during the analysis.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReachabilitySet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 82,
 FQN="(anonymous namespace)::ReachabilitySet", NM="_ZN12_GLOBAL__N_115ReachabilitySetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_115ReachabilitySetE")
//</editor-fold>
public class ReachabilitySet implements Destructors.ClassWithDestructor {
  // JAVA: typedef std::bitset<4> StateSet
//  public final class StateSet extends std.bitset<4>{ };
  // JAVA: typedef DenseMap<InstantiatedValue, StateSet> ValueStateMap
//  public final class ValueStateMap extends DenseMap<InstantiatedValue, std.bitset<4>>{ };
  // JAVA: typedef DenseMap<InstantiatedValue, ValueStateMap> ValueReachMap
//  public final class ValueReachMap extends DenseMap<InstantiatedValue, DenseMap<InstantiatedValue, std.bitset<4>>>{ };
  private DenseMap<InstantiatedValue, DenseMap<InstantiatedValue, std.bitset/*<4>*/>> ReachMap;
/*public:*/
  // JAVA: typedef ValueStateMap::const_iterator const_valuestate_iterator
//  public final class const_valuestate_iterator extends DenseMapIterator<InstantiatedValue, std.bitset<4>>{ };
  // JAVA: typedef ValueReachMap::const_iterator const_value_iterator
//  public final class const_value_iterator extends DenseMapIterator<InstantiatedValue, DenseMap<InstantiatedValue, std.bitset<4>, DenseMapInfoInstantiatedValue, std.pair<InstantiatedValue, std.bitset<4>> >>{ };
  
  // Insert edge 'From->To' at state 'State'
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReachabilitySet::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 93,
   FQN="(anonymous namespace)::ReachabilitySet::insert", NM="_ZN12_GLOBAL__N_115ReachabilitySet6insertEN4llvm5cflaa17InstantiatedValueES3_NS_10MatchStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_115ReachabilitySet6insertEN4llvm5cflaa17InstantiatedValueES3_NS_10MatchStateE")
  //</editor-fold>
  public boolean insert(InstantiatedValue From, InstantiatedValue To, MatchState State) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Return the set of all ('From', 'State') pair for a given node 'To'
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReachabilitySet::reachableValueAliases">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 104,
   FQN="(anonymous namespace)::ReachabilitySet::reachableValueAliases", NM="_ZNK12_GLOBAL__N_115ReachabilitySet21reachableValueAliasesEN4llvm5cflaa17InstantiatedValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_115ReachabilitySet21reachableValueAliasesEN4llvm5cflaa17InstantiatedValueE")
  //</editor-fold>
  public iterator_range</*constconst*/std.pair<InstantiatedValue, std.bitset/*<4>*/> /*&*/> reachableValueAliases(InstantiatedValue V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReachabilitySet::value_mappings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 114,
   FQN="(anonymous namespace)::ReachabilitySet::value_mappings", NM="_ZNK12_GLOBAL__N_115ReachabilitySet14value_mappingsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_115ReachabilitySet14value_mappingsEv")
  //</editor-fold>
  public iterator_range</*constconst*/std.pair<InstantiatedValue, DenseMap<InstantiatedValue, std.bitset/*<4>*/ > > /*&*/> value_mappings() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReachabilitySet::~ReachabilitySet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 82,
   FQN="(anonymous namespace)::ReachabilitySet::~ReachabilitySet", NM="_ZN12_GLOBAL__N_115ReachabilitySetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_115ReachabilitySetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReachabilitySet::ReachabilitySet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 82,
   FQN="(anonymous namespace)::ReachabilitySet::ReachabilitySet", NM="_ZN12_GLOBAL__N_115ReachabilitySetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_115ReachabilitySetC1Ev")
  //</editor-fold>
  public /*inline*/ ReachabilitySet() {
    // : ReachMap() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ReachMap=" + ReachMap; // NOI18N
  }
}
