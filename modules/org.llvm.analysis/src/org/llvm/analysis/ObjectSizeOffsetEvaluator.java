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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// \brief Evaluate the size and offset of an object pointed to by a Value*.
/// May create code to compute the result at run-time.
//<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 208,
 FQN="llvm::ObjectSizeOffsetEvaluator", NM="_ZN4llvm25ObjectSizeOffsetEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluatorE")
//</editor-fold>
public class ObjectSizeOffsetEvaluator implements /*public*/ InstVisitor<ObjectSizeOffsetEvaluator, std.pair<Value /*P*/ , Value /*P*/ > >, Destructors.ClassWithDestructor {
  
  // JAVA: typedef IRBuilder<TargetFolder> BuilderTy
//  public final class BuilderTy extends IRBuilder<TargetFolder>{ };
  // JAVA: typedef std::pair<WeakVH, WeakVH> WeakEvalType
//  public final class WeakEvalType extends std.pair<WeakVH, WeakVH>{ };
  // JAVA: typedef DenseMap<const Value *, WeakEvalType> CacheMapTy
//  public final class CacheMapTy extends DenseMap</*const*/ Value /*P*/ , std.pair<WeakVH, WeakVH>>{ };
  // JAVA: typedef SmallPtrSet<const Value *, 8> PtrSetTy
//  public final class PtrSetTy extends SmallPtrSet</*const*/ Value /*P*/ >{ };
  
  private final /*const*/ DataLayout /*&*/ DL;
  private /*const*/ TargetLibraryInfo /*P*/ TLI;
  private final LLVMContext /*&*/ Context;
  private IRBuilder<TargetFolder, IRBuilderDefaultInserter> Builder;
  private IntegerType /*P*/ IntTy;
  private Value /*P*/ Zero;
  private DenseMap</*const*/ Value /*P*/ , std.pair<WeakVH, WeakVH>> CacheMap;
  private SmallPtrSet</*const*/ Value /*P*/ > SeenVals;
  private boolean RoundToAlign;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::unknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 226,
   FQN="llvm::ObjectSizeOffsetEvaluator::unknown", NM="_ZN4llvm25ObjectSizeOffsetEvaluator7unknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator7unknownEv")
  //</editor-fold>
  private std.pair<Value /*P*/ , Value /*P*/ > unknown() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::compute_">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 675,
   FQN="llvm::ObjectSizeOffsetEvaluator::compute_", NM="_ZN4llvm25ObjectSizeOffsetEvaluator8compute_EPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator8compute_EPNS_5ValueE")
  //</editor-fold>
  private std.pair<Value /*P*/ , Value /*P*/ > compute_(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::ObjectSizeOffsetEvaluator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 643,
   FQN="llvm::ObjectSizeOffsetEvaluator::ObjectSizeOffsetEvaluator", NM="_ZN4llvm25ObjectSizeOffsetEvaluatorC1ERKNS_10DataLayoutEPKNS_17TargetLibraryInfoERNS_11LLVMContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluatorC1ERKNS_10DataLayoutEPKNS_17TargetLibraryInfoERNS_11LLVMContextEb")
  //</editor-fold>
  public ObjectSizeOffsetEvaluator(final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI, final LLVMContext /*&*/ Context) {
    this(DL, TLI, Context, 
      false);
  }
  public ObjectSizeOffsetEvaluator(final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI, final LLVMContext /*&*/ Context, 
      boolean RoundToAlign/*= false*/) {
    // : InstVisitor<ObjectSizeOffsetEvaluator, SizeOffsetEvalType>(), DL(DL), TLI(TLI), Context(Context), Builder(Context, TargetFolder(DL)), CacheMap(), SeenVals(), RoundToAlign(RoundToAlign) 
    $InstVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::compute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 652,
   FQN="llvm::ObjectSizeOffsetEvaluator::compute", NM="_ZN4llvm25ObjectSizeOffsetEvaluator7computeEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator7computeEPNS_5ValueE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > compute(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::knownSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 236,
   FQN="llvm::ObjectSizeOffsetEvaluator::knownSize", NM="_ZN4llvm25ObjectSizeOffsetEvaluator9knownSizeESt4pairIPNS_5ValueES3_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator9knownSizeESt4pairIPNS_5ValueES3_E")
  //</editor-fold>
  public boolean knownSize(std.pair<Value /*P*/ , Value /*P*/ > SizeOffset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::knownOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 240,
   FQN="llvm::ObjectSizeOffsetEvaluator::knownOffset", NM="_ZN4llvm25ObjectSizeOffsetEvaluator11knownOffsetESt4pairIPNS_5ValueES3_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator11knownOffsetESt4pairIPNS_5ValueES3_E")
  //</editor-fold>
  public boolean knownOffset(std.pair<Value /*P*/ , Value /*P*/ > SizeOffset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::anyKnown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 244,
   FQN="llvm::ObjectSizeOffsetEvaluator::anyKnown", NM="_ZN4llvm25ObjectSizeOffsetEvaluator8anyKnownESt4pairIPNS_5ValueES3_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator8anyKnownESt4pairIPNS_5ValueES3_E")
  //</editor-fold>
  public boolean anyKnown(std.pair<Value /*P*/ , Value /*P*/ > SizeOffset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::bothKnown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 248,
   FQN="llvm::ObjectSizeOffsetEvaluator::bothKnown", NM="_ZN4llvm25ObjectSizeOffsetEvaluator9bothKnownESt4pairIPNS_5ValueES3_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator9bothKnownESt4pairIPNS_5ValueES3_E")
  //</editor-fold>
  public boolean bothKnown(std.pair<Value /*P*/ , Value /*P*/ > SizeOffset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // The individual instruction visitors should be treated as private.
  
  // The individual instruction visitors should be treated as private.
  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitAllocaInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 725,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitAllocaInst", NM="_ZN4llvm25ObjectSizeOffsetEvaluator15visitAllocaInstERNS_10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator15visitAllocaInstERNS_10AllocaInstE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitAllocaInst(final AllocaInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitCallSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 738,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitCallSite", NM="_ZN4llvm25ObjectSizeOffsetEvaluator13visitCallSiteENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator13visitCallSiteENS_8CallSiteE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitCallSite(CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitExtractElementInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 769,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitExtractElementInst", NM="_ZN4llvm25ObjectSizeOffsetEvaluator23visitExtractElementInstERNS_18ExtractElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator23visitExtractElementInstERNS_18ExtractElementInstE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitExtractElementInst(final ExtractElementInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 774,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitExtractValueInst", NM="_ZN4llvm25ObjectSizeOffsetEvaluator21visitExtractValueInstERNS_16ExtractValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator21visitExtractValueInstERNS_16ExtractValueInstE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitExtractValueInst(final ExtractValueInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitGEPOperator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 779,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitGEPOperator", NM="_ZN4llvm25ObjectSizeOffsetEvaluator16visitGEPOperatorERNS_11GEPOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator16visitGEPOperatorERNS_11GEPOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitGEPOperator(final GEPOperator /*&*/ GEP) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitIntToPtrInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 790,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitIntToPtrInst", NM="_ZN4llvm25ObjectSizeOffsetEvaluator17visitIntToPtrInstERNS_12IntToPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator17visitIntToPtrInstERNS_12IntToPtrInstE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitIntToPtrInst(final IntToPtrInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitLoadInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 795,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitLoadInst", NM="_ZN4llvm25ObjectSizeOffsetEvaluator13visitLoadInstERNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator13visitLoadInstERNS_8LoadInstE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitLoadInst(final LoadInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitPHINode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 799,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitPHINode", NM="_ZN4llvm25ObjectSizeOffsetEvaluator12visitPHINodeERNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator12visitPHINodeERNS_7PHINodeE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitPHINode(final PHINode /*&*/ PHI) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitSelectInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 837,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitSelectInst", NM="_ZN4llvm25ObjectSizeOffsetEvaluator15visitSelectInstERNS_10SelectInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator15visitSelectInstERNS_10SelectInstE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitSelectInst(final SelectInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::visitInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 853,
   FQN="llvm::ObjectSizeOffsetEvaluator::visitInstruction", NM="_ZN4llvm25ObjectSizeOffsetEvaluator16visitInstructionERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluator16visitInstructionERNS_11InstructionE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > visitInstruction_ObjectSizeOffsetEvaluator(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ObjectSizeOffsetEvaluator::~ObjectSizeOffsetEvaluator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 208,
   FQN="llvm::ObjectSizeOffsetEvaluator::~ObjectSizeOffsetEvaluator", NM="_ZN4llvm25ObjectSizeOffsetEvaluatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm25ObjectSizeOffsetEvaluatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DL=" + DL // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", Context=" + "[LLVMContext]" // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", IntTy=" + IntTy // NOI18N
              + ", Zero=" + Zero // NOI18N
              + ", CacheMap=" + CacheMap // NOI18N
              + ", SeenVals=" + SeenVals // NOI18N
              + ", RoundToAlign=" + RoundToAlign // NOI18N
              + super.toString(); // NOI18N
  }
}
