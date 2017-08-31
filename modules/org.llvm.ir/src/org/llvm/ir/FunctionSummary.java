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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief Function summary information to aid decisions and implementation of
/// importing.
//<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 232,
 FQN="llvm::FunctionSummary", NM="_ZN4llvm15FunctionSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummaryE")
//</editor-fold>
public class FunctionSummary extends /*public*/ GlobalValueSummary implements Destructors.ClassWithDestructor {
/*public:*/
  /// <CalleeValueInfo, CalleeInfo> call edge pair.
  // JAVA: typedef std::pair<ValueInfo, CalleeInfo> EdgeTy
//  public final class EdgeTy extends std.pairTypeType<ValueInfo, CalleeInfo>{ };
/*private:*/
  /// Number of instructions (ignoring debug instructions, e.g.) computed
  /// during the initial compile step when the summary index is first built.
  private /*uint*/int InstCount;

  /// List of <CalleeValueInfo, CalleeInfo> call edge pairs from this function.
  private std.vector<std.pairTypeType<ValueInfo, CalleeInfo>> CallGraphEdgeList;
/*public:*/
  /// Summary constructors.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::FunctionSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 247,
   FQN="llvm::FunctionSummary::FunctionSummary", NM="_ZN4llvm15FunctionSummaryC1ENS_18GlobalValueSummary7GVFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummaryC1ENS_18GlobalValueSummary7GVFlagsEj")
  //</editor-fold>
  public FunctionSummary(GlobalValueSummary.GVFlags Flags, /*uint*/int NumInsts) {
    // : GlobalValueSummary(FunctionKind, Flags), InstCount(NumInsts), CallGraphEdgeList()
    //START JInit
    super(SummaryKind.FunctionKind, new GlobalValueSummary.GVFlags(Flags));
    this.InstCount = NumInsts;
    this.CallGraphEdgeList = new std.vector<std.pairTypeType<ValueInfo, CalleeInfo>>(new std.pairTypeType<ValueInfo, CalleeInfo>());
    //END JInit
  }


  /// Check if this is a function summary.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 251,
   FQN="llvm::FunctionSummary::classof", NM="_ZN4llvm15FunctionSummary7classofEPKNS_18GlobalValueSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummary7classofEPKNS_18GlobalValueSummaryE")
  //</editor-fold>
  public static boolean classof(/*const*/ GlobalValueSummary /*P*/ GVS) {
    return GVS.getSummaryKind() == SummaryKind.FunctionKind;
  }


  /// Get the instruction count recorded for this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::instCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 256,
   FQN="llvm::FunctionSummary::instCount", NM="_ZNK4llvm15FunctionSummary9instCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZNK4llvm15FunctionSummary9instCountEv")
  //</editor-fold>
  public /*uint*/int instCount() /*const*/ {
    return InstCount;
  }


  /// Record a call graph edge from this function to the function identified
  /// by \p CalleeGUID, with \p CalleeInfo including the cumulative profile
  /// count (across all calls from this function) or 0 if no PGO.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::addCallGraphEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 261,
   FQN="llvm::FunctionSummary::addCallGraphEdge", NM="_ZN4llvm15FunctionSummary16addCallGraphEdgeEyNS_10CalleeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummary16addCallGraphEdgeEyNS_10CalleeInfoE")
  //</editor-fold>
  public void addCallGraphEdge(long/*uint64_t*/ CalleeGUID, CalleeInfo Info) {
    CallGraphEdgeList.push_back_T$RR(new std.pairTypeType<ValueInfo, CalleeInfo>(JD$Pair$_U1$_U2.INSTANCE, new ValueInfo(/*Fwd2*//*Fwd*/CalleeGUID), new CalleeInfo(JD$Move.INSTANCE, /*Fwd*/new CalleeInfo(/*Fwd2*/Info))));
  }


  /// Record a call graph edge from this function to each function GUID recorded
  /// in \p CallGraphEdges.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::addCallGraphEdges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 267,
   FQN="llvm::FunctionSummary::addCallGraphEdges", NM="_ZN4llvm15FunctionSummary17addCallGraphEdgesERNS_8DenseMapIyNS_10CalleeInfoENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS2_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummary17addCallGraphEdgesERNS_8DenseMapIyNS_10CalleeInfoENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS2_EEEE")
  //</editor-fold>
  public void addCallGraphEdges(final DenseMapULongType<CalleeInfo> /*&*/ CallGraphEdges) {
    for (final std.pairULongType<CalleeInfo> /*&*/ EI : CallGraphEdges)  {
      addCallGraphEdge(EI.first, new CalleeInfo(EI.second));
    }
  }


  /// Record a call graph edge from this function to the function identified
  /// by \p CalleeV, with \p CalleeInfo including the cumulative profile
  /// count (across all calls from this function) or 0 if no PGO.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::addCallGraphEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 276,
   FQN="llvm::FunctionSummary::addCallGraphEdge", NM="_ZN4llvm15FunctionSummary16addCallGraphEdgeEPKNS_5ValueENS_10CalleeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummary16addCallGraphEdgeEPKNS_5ValueENS_10CalleeInfoE")
  //</editor-fold>
  public void addCallGraphEdge(/*const*/ Value /*P*/ CalleeV, CalleeInfo Info) {
    CallGraphEdgeList.push_back_T$RR(new std.pairTypeType<ValueInfo, CalleeInfo>(JD$Pair$_U1$_U2.INSTANCE, new ValueInfo(/*Fwd2*//*Fwd*/CalleeV), new CalleeInfo(JD$Move.INSTANCE, /*Fwd*/new CalleeInfo(/*Fwd2*/Info))));
  }


  /// Record a call graph edge from this function to each function recorded
  /// in \p CallGraphEdges.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::addCallGraphEdges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 282,
   FQN="llvm::FunctionSummary::addCallGraphEdges", NM="_ZN4llvm15FunctionSummary17addCallGraphEdgesERNS_8DenseMapIPKNS_5ValueENS_10CalleeInfoENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummary17addCallGraphEdgesERNS_8DenseMapIPKNS_5ValueENS_10CalleeInfoENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEE")
  //</editor-fold>
  public void addCallGraphEdges(final DenseMap</*const*/ Value /*P*/ , CalleeInfo> /*&*/ CallGraphEdges) {
    for (final std.pair</*const*/ Value /*P*/ , CalleeInfo> /*&*/ EI : CallGraphEdges)  {
      addCallGraphEdge(EI.first, new CalleeInfo(EI.second));
    }
  }


  /// Return the list of <CalleeValueInfo, CalleeInfo> pairs.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::calls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 288,
   FQN="llvm::FunctionSummary::calls", NM="_ZN4llvm15FunctionSummary5callsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummary5callsEv")
  //</editor-fold>
  public std.vector<std.pairTypeType<ValueInfo, CalleeInfo>> /*&*/ calls() {
    return CallGraphEdgeList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::calls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 289,
   FQN="llvm::FunctionSummary::calls", NM="_ZNK4llvm15FunctionSummary5callsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZNK4llvm15FunctionSummary5callsEv")
  //</editor-fold>
  public /*const*/std.vector<std.pairTypeType<ValueInfo, CalleeInfo>> /*&*/ calls$Const() /*const*/ {
    return CallGraphEdgeList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionSummary::~FunctionSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 232,
   FQN="llvm::FunctionSummary::~FunctionSummary", NM="_ZN4llvm15FunctionSummaryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm15FunctionSummaryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CallGraphEdgeList.$destroy();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "InstCount=" + InstCount // NOI18N
              + ", CallGraphEdgeList=" + CallGraphEdgeList // NOI18N
              + super.toString(); // NOI18N
  }
}
