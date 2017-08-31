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

package org.llvm.analysis.cflaa.impl;

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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;
import static org.llvm.analysis.cflaa.impl.CflaaStatics.NumAliasAttrs;


///\brief A builder class used to create CFLGraph instance from a given function
/// The CFL-AA that uses this builder must provide its own type as a template
/// argument. This is necessary for interprocedural processing: CFLGraphBuilder
/// needs a way of obtaining the summary of other functions when callinsts are
/// encountered.
/// As a result, we expect the said CFL-AA to expose a getAliasSummary() public
/// member function that takes a Function& and returns the corresponding summary
/// as a const AliasSummary*.
/*template <typename CFLAA> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 141,
 FQN="llvm::cflaa::CFLGraphBuilder", NM="_ZN4llvm5cflaa15CFLGraphBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilderE")
//</editor-fold>
public class CFLGraphBuilder</*typename*/ CFLAA>  implements Destructors.ClassWithDestructor {
  // Input of the builder
  private final CFLAA /*&*/ Analysis;
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  
  // Output of the builder
  private CFLGraph Graph;
  private SmallVector<Value /*P*/ > ReturnedValues;
  
  // Helper class
  /// Gets the edges our graph should have, based on an Instruction*
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 152,
   FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitorE")
  //</editor-fold>
  private static class GetEdgesVisitor implements /*public*/ InstVisitorVoid<GetEdgesVisitor/*, void*/> {
    private final Object/*CFLAA*/ /*&*/ AA;
    private final /*const*/ TargetLibraryInfo /*&*/ TLI;
    
    private final CFLGraph /*&*/ Graph;
    private final SmallVectorImpl<Value /*P*/ > /*&*/ ReturnValues;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::hasUsefulEdges">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 159,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::hasUsefulEdges", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor14hasUsefulEdgesEPNS_12ConstantExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor14hasUsefulEdgesEPNS_12ConstantExprE")
    //</editor-fold>
    private static </*typename*/ CFLAA> boolean hasUsefulEdges(ConstantExpr /*P*/ CE) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    // Returns possible functions called by CS into the given SmallVectorImpl.
    // Returns true if targets found, false otherwise.
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::getPossibleTargets">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 169,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::getPossibleTargets", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor18getPossibleTargetsENS_8CallSiteERNS_15SmallVectorImplIPNS_8FunctionEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor18getPossibleTargetsENS_8CallSiteERNS_15SmallVectorImplIPNS_8FunctionEEE")
    //</editor-fold>
    private static </*typename*/ CFLAA> boolean getPossibleTargets(CallSite CS, 
                      final SmallVectorImpl<Function /*P*/ > /*&*/ Output) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addNode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 182,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addNode", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor7addNodeEPNS_5ValueESt6bitsetILj32EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor7addNodeEPNS_5ValueESt6bitsetILj32EE")
    //</editor-fold>
    private void addNode(Value /*P*/ Val) {
      addNode(Val, new std.bitset/*NumAliasAttrs*/(NumAliasAttrs));
    }
    private void addNode(Value /*P*/ Val, std.bitset/*NumAliasAttrs*/ Attr/*= std.AliasAttrs()*/) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addAssignEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 197,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addAssignEdge", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13addAssignEdgeEPNS_5ValueES4_x",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13addAssignEdgeEPNS_5ValueES4_x")
    //</editor-fold>
    private void addAssignEdge(Value /*P*/ From, Value /*P*/ To) {
      addAssignEdge(From, To, 0);
    }
    private void addAssignEdge(Value /*P*/ From, Value /*P*/ To, long/*int64_t*/ Offset/*= 0*/) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addDerefEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 209,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addDerefEdge", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor12addDerefEdgeEPNS_5ValueES4_b",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor12addDerefEdgeEPNS_5ValueES4_b")
    //</editor-fold>
    private void addDerefEdge(Value /*P*/ From, Value /*P*/ To, boolean IsRead) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addLoadEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 224,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addLoadEdge", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor11addLoadEdgeEPNS_5ValueES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor11addLoadEdgeEPNS_5ValueES4_")
    //</editor-fold>
    private void addLoadEdge(Value /*P*/ From, Value /*P*/ To) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addStoreEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 225,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::addStoreEdge", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor12addStoreEdgeEPNS_5ValueES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor12addStoreEdgeEPNS_5ValueES4_")
    //</editor-fold>
    private void addStoreEdge(Value /*P*/ From, Value /*P*/ To) {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::GetEdgesVisitor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 228,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::GetEdgesVisitor", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitorC1ERNS0_15CFLGraphBuilderIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitorC1ERNS0_15CFLGraphBuilderIT_EE")
    //</editor-fold>
    public <CFLAA> GetEdgesVisitor(final CFLGraphBuilder<CFLAA> /*&*/ Builder) {
      // : AA(Builder.Analysis), TLI(Builder.TLI), Graph(Builder.Graph), ReturnValues(Builder.ReturnedValues) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitInstruction">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 232,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitInstruction", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor16visitInstructionERNS_11InstructionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor16visitInstructionERNS_11InstructionE")
    //</editor-fold>
    public void visitInstruction(final Instruction /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitReturnInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 236,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitReturnInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor15visitReturnInstERNS_10ReturnInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor15visitReturnInstERNS_10ReturnInstE")
    //</editor-fold>
    public void visitReturnInst(final ReturnInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitPtrToIntInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 245,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitPtrToIntInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor17visitPtrToIntInstERNS_12PtrToIntInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor17visitPtrToIntInstERNS_12PtrToIntInstE")
    //</editor-fold>
    public void visitPtrToIntInst(final PtrToIntInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitIntToPtrInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 250,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitIntToPtrInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor17visitIntToPtrInstERNS_12IntToPtrInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor17visitIntToPtrInstERNS_12IntToPtrInstE")
    //</editor-fold>
    public void visitIntToPtrInst(final IntToPtrInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitCastInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 255,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitCastInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13visitCastInstERNS_8CastInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13visitCastInstERNS_8CastInstE")
    //</editor-fold>
    public void visitCastInst(final CastInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitBinaryOperator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 260,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitBinaryOperator", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor19visitBinaryOperatorERNS_14BinaryOperatorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor19visitBinaryOperatorERNS_14BinaryOperatorE")
    //</editor-fold>
    public void visitBinaryOperator(final BinaryOperator /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitAtomicCmpXchgInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 267,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitAtomicCmpXchgInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitAtomicCmpXchgInstERNS_17AtomicCmpXchgInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitAtomicCmpXchgInstERNS_17AtomicCmpXchgInstE")
    //</editor-fold>
    public void visitAtomicCmpXchgInst(final AtomicCmpXchgInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitAtomicRMWInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 273,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitAtomicRMWInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor18visitAtomicRMWInstERNS_13AtomicRMWInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor18visitAtomicRMWInstERNS_13AtomicRMWInstE")
    //</editor-fold>
    public void visitAtomicRMWInst(final AtomicRMWInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitPHINode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 279,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitPHINode", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor12visitPHINodeERNS_7PHINodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor12visitPHINodeERNS_7PHINodeE")
    //</editor-fold>
    public void visitPHINode(final PHINode /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitGetElementPtrInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 284,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitGetElementPtrInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitGetElementPtrInstERNS_17GetElementPtrInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitGetElementPtrInstERNS_17GetElementPtrInstE")
    //</editor-fold>
    public void visitGetElementPtrInst(final GetElementPtrInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitSelectInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 289,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitSelectInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor15visitSelectInstERNS_10SelectInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor15visitSelectInstERNS_10SelectInstE")
    //</editor-fold>
    public void visitSelectInst(final SelectInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitAllocaInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 301,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitAllocaInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor15visitAllocaInstERNS_10AllocaInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor15visitAllocaInstERNS_10AllocaInstE")
    //</editor-fold>
    public void visitAllocaInst(final AllocaInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitLoadInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 303,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitLoadInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13visitLoadInstERNS_8LoadInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13visitLoadInstERNS_8LoadInstE")
    //</editor-fold>
    public void visitLoadInst(final LoadInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitStoreInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 309,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitStoreInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor14visitStoreInstERNS_9StoreInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor14visitStoreInstERNS_9StoreInstE")
    //</editor-fold>
    public void visitStoreInst(final StoreInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitVAArgInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 315,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitVAArgInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor14visitVAArgInstERNS_9VAArgInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor14visitVAArgInstERNS_9VAArgInstE")
    //</editor-fold>
    public void visitVAArgInst(final VAArgInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::isFunctionExternal">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 327,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::isFunctionExternal", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor18isFunctionExternalEPNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor18isFunctionExternalEPNS_8FunctionE")
    //</editor-fold>
    public static </*typename*/ CFLAA> boolean isFunctionExternal(Function /*P*/ Fn) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::tryInterproceduralAnalysis">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 331,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::tryInterproceduralAnalysis", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor26tryInterproceduralAnalysisENS_8CallSiteERKNS_15SmallVectorImplIPNS_8FunctionEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor26tryInterproceduralAnalysisENS_8CallSiteERKNS_15SmallVectorImplIPNS_8FunctionEEE")
    //</editor-fold>
    public boolean tryInterproceduralAnalysis(CallSite CS, 
                              final /*const*/ SmallVectorImpl<Function /*P*/ > /*&*/ Fns) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitCallSite">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 373,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitCallSite", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13visitCallSiteENS_8CallSiteE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor13visitCallSiteENS_8CallSiteE")
    //</editor-fold>
    public void visitCallSite(CallSite CS) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Because vectors/aggregates are immutable and unaddressable, there's
    /// nothing we can do to coax a value out of them, other than calling
    /// Extract{Element,Value}. We can effectively treat them as pointers to
    /// arbitrary memory locations we can store in and load from.
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitExtractElementInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 430,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitExtractElementInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor23visitExtractElementInstERNS_18ExtractElementInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor23visitExtractElementInstERNS_18ExtractElementInstE")
    //</editor-fold>
    public void visitExtractElementInst(final ExtractElementInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitInsertElementInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 436,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitInsertElementInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitInsertElementInstERNS_17InsertElementInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitInsertElementInstERNS_17InsertElementInstE")
    //</editor-fold>
    public void visitInsertElementInst(final InsertElementInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitLandingPadInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 443,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitLandingPadInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor19visitLandingPadInstERNS_14LandingPadInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor19visitLandingPadInstERNS_14LandingPadInstE")
    //</editor-fold>
    public void visitLandingPadInst(final LandingPadInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitInsertValueInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 450,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitInsertValueInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor20visitInsertValueInstERNS_15InsertValueInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor20visitInsertValueInstERNS_15InsertValueInstE")
    //</editor-fold>
    public void visitInsertValueInst(final InsertValueInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitExtractValueInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 457,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitExtractValueInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor21visitExtractValueInstERNS_16ExtractValueInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor21visitExtractValueInstERNS_16ExtractValueInstE")
    //</editor-fold>
    public void visitExtractValueInst(final ExtractValueInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitShuffleVectorInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 462,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitShuffleVectorInst", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitShuffleVectorInstERNS_17ShuffleVectorInstE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor22visitShuffleVectorInstERNS_17ShuffleVectorInstE")
    //</editor-fold>
    public void visitShuffleVectorInst(final ShuffleVectorInst /*&*/ Inst) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitConstantExpr">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 469,
     FQN="llvm::cflaa::CFLGraphBuilder::GetEdgesVisitor::visitConstantExpr", NM="_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor17visitConstantExprEPNS_12ConstantExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder15GetEdgesVisitor17visitConstantExprEPNS_12ConstantExprE")
    //</editor-fold>
    public void visitConstantExpr(ConstantExpr /*P*/ CE) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "AA=" + AA // NOI18N
                + ", TLI=" + TLI // NOI18N
                + ", Graph=" + Graph // NOI18N
                + ", ReturnValues=" + ReturnValues // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  // Helper functions
  
  // Determines whether or not we an instruction is useless to us (e.g.
  // FenceInst)
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::hasUsefulEdges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 487,
   FQN="llvm::cflaa::CFLGraphBuilder::hasUsefulEdges", NM="_ZN4llvm5cflaa15CFLGraphBuilder14hasUsefulEdgesEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder14hasUsefulEdgesEPNS_11InstructionE")
  //</editor-fold>
  private static </*typename*/ CFLAA> boolean hasUsefulEdges(Instruction /*P*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::addArgumentToGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 495,
   FQN="llvm::cflaa::CFLGraphBuilder::addArgumentToGraph", NM="_ZN4llvm5cflaa15CFLGraphBuilder18addArgumentToGraphERNS_8ArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder18addArgumentToGraphERNS_8ArgumentE")
  //</editor-fold>
  private void addArgumentToGraph(final Argument /*&*/ Arg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Given an Instruction, this will add it to the graph, along with any
  // Instructions that are potentially only available from said Instruction
  // For example, given the following line:
  //   %0 = load i16* getelementptr ([1 x i16]* @a, 0, 0), align 2
  // addInstructionToGraph would add both the `load` and `getelementptr`
  // instructions to the graph appropriately.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::addInstructionToGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 510,
   FQN="llvm::cflaa::CFLGraphBuilder::addInstructionToGraph", NM="_ZN4llvm5cflaa15CFLGraphBuilder21addInstructionToGraphERNS1_15GetEdgesVisitorERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder21addInstructionToGraphERNS1_15GetEdgesVisitorERNS_11InstructionE")
  //</editor-fold>
  private void addInstructionToGraph(final GetEdgesVisitor /*&*/ Visitor, final Instruction /*&*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Builds the graph needed for constructing the StratifiedSets for the given
  // function
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::buildGraphFrom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 519,
   FQN="llvm::cflaa::CFLGraphBuilder::buildGraphFrom", NM="_ZN4llvm5cflaa15CFLGraphBuilder14buildGraphFromERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilder14buildGraphFromERNS_8FunctionE")
  //</editor-fold>
  private void buildGraphFrom(final Function /*&*/ Fn) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::CFLGraphBuilder<CFLAA>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 531,
   FQN="llvm::cflaa::CFLGraphBuilder::CFLGraphBuilder<CFLAA>", NM="_ZN4llvm5cflaa15CFLGraphBuilderC1ERT_RKNS_17TargetLibraryInfoERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa15CFLGraphBuilderC1ERT_RKNS_17TargetLibraryInfoERNS_8FunctionE")
  //</editor-fold>
  public CFLGraphBuilder(final CFLAA /*&*/ Analysis, final /*const*/ TargetLibraryInfo /*&*/ TLI, final Function /*&*/ Fn) {
    // : Analysis(Analysis), TLI(TLI) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::getCFLGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 536,
   FQN="llvm::cflaa::CFLGraphBuilder::getCFLGraph", NM="_ZNK4llvm5cflaa15CFLGraphBuilder11getCFLGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa15CFLGraphBuilder11getCFLGraphEv")
  //</editor-fold>
  public /*const*/ CFLGraph /*&*/ getCFLGraph() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraphBuilder::getReturnValues">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 537,
   FQN="llvm::cflaa::CFLGraphBuilder::getReturnValues", NM="_ZNK4llvm5cflaa15CFLGraphBuilder15getReturnValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa15CFLGraphBuilder15getReturnValuesEv")
  //</editor-fold>
  public /*const*/SmallVector<Value /*P*/ > /*&*/ getReturnValues() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $destroy() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Analysis=" + Analysis // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", Graph=" + Graph // NOI18N
              + ", ReturnedValues=" + ReturnedValues; // NOI18N
  }
}
