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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.analysis.impl.BlockFrequencyInfoStatics.ViewBlockFreqFuncName;
import static org.llvm.analysis.impl.BlockFrequencyInfoStatics.ViewBlockFreqPropagationDAG;
import static org.llvm.support.AdtsupportLlvmGlobals.ViewGraph;


/// BlockFrequencyInfo pass uses BlockFrequencyInfoImpl implementation to
/// estimate IR basic block frequencies.
//<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfo.h", line = 31,
 FQN="llvm::BlockFrequencyInfo", NM="_ZN4llvm18BlockFrequencyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoE")
//</editor-fold>
public class BlockFrequencyInfo implements Destructors.ClassWithDestructor {
  // JAVA: typedef BlockFrequencyInfoImpl<BasicBlock> ImplType
//  public final class ImplType extends BlockFrequencyInfoImpl<BasicBlock>{ };
  private std.unique_ptr<BlockFrequencyInfoImpl<BasicBlock> > BFI;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfo.h", line = 35,
   FQN="llvm::BlockFrequencyInfo::operator=", NM="_ZN4llvm18BlockFrequencyInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ BlockFrequencyInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::BlockFrequencyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfo.h", line = 36,
   FQN="llvm::BlockFrequencyInfo::BlockFrequencyInfo", NM="_ZN4llvm18BlockFrequencyInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoC1ERKS0_")
  //</editor-fold>
  protected/*private*/ BlockFrequencyInfo(final /*const*/ BlockFrequencyInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::BlockFrequencyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 115,
   FQN="llvm::BlockFrequencyInfo::BlockFrequencyInfo", NM="_ZN4llvm18BlockFrequencyInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoC1Ev")
  //</editor-fold>
  public BlockFrequencyInfo() {
    // : BFI() 
    //START JInit
    this.BFI = new std.unique_ptr<BlockFrequencyInfoImpl<BasicBlock> >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::BlockFrequencyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 117,
   FQN="llvm::BlockFrequencyInfo::BlockFrequencyInfo", NM="_ZN4llvm18BlockFrequencyInfoC1ERKNS_8FunctionERKNS_21BranchProbabilityInfoERKNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoC1ERKNS_8FunctionERKNS_21BranchProbabilityInfoERKNS_8LoopInfoE")
  //</editor-fold>
  public BlockFrequencyInfo(final /*const*/ Function /*&*/ F, 
      final /*const*/ BranchProbabilityInfo /*&*/ BPI, 
      final /*const*/ LoopInfo /*&*/ LI) {
    // : BFI() 
    //START JInit
    this.BFI = new std.unique_ptr<BlockFrequencyInfoImpl<BasicBlock> >();
    //END JInit
    calculate(F, BPI, LI);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::BlockFrequencyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 123,
   FQN="llvm::BlockFrequencyInfo::BlockFrequencyInfo", NM="_ZN4llvm18BlockFrequencyInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoC1EOS0_")
  //</editor-fold>
  public BlockFrequencyInfo(JD$Move _dparam, final BlockFrequencyInfo /*&&*/Arg) {
    // : BFI(std::move(Arg.BFI)) 
    //START JInit
    this.BFI = new std.unique_ptr<BlockFrequencyInfoImpl<BasicBlock> >(JD$Move.INSTANCE, std.move(Arg.BFI));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 126,
   FQN="llvm::BlockFrequencyInfo::operator=", NM="_ZN4llvm18BlockFrequencyInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoaSEOS0_")
  //</editor-fold>
  public BlockFrequencyInfo /*&*/ $assignMove(final BlockFrequencyInfo /*&&*/RHS) {
    releaseMemory();
    BFI.$assignMove(std.move(RHS.BFI));
    return /*Deref*/this;
  }

  
  
  // Explicitly define the default constructor otherwise it would be implicitly
  // defined at the first ODR-use which is the BFI member in the
  // LazyBlockFrequencyInfo header.  The dtor needs the BlockFrequencyInfoImpl
  // template instantiated which is not available in the header.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::~BlockFrequencyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 136,
   FQN="llvm::BlockFrequencyInfo::~BlockFrequencyInfo", NM="_ZN4llvm18BlockFrequencyInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    BFI.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 182,
   FQN="llvm::BlockFrequencyInfo::getFunction", NM="_ZNK4llvm18BlockFrequencyInfo11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo11getFunctionEv")
  //</editor-fold>
  public /*const*/ Function /*P*/ getFunction() /*const*/ {
    return BFI.$bool() ? BFI.$arrow().getFunction() : null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::getBPI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 186,
   FQN="llvm::BlockFrequencyInfo::getBPI", NM="_ZNK4llvm18BlockFrequencyInfo6getBPIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo6getBPIEv")
  //</editor-fold>
  public /*const*/ BranchProbabilityInfo /*P*/ getBPI() /*const*/ {
    return BFI.$bool() ? $AddrOf(BFI.$arrow().getBPI()) : null;
  }

  
  /// Pop up a ghostview window with the current block frequency propagation
  /// rendered using dot.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::view">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 172,
   FQN="llvm::BlockFrequencyInfo::view", NM="_ZNK4llvm18BlockFrequencyInfo4viewEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo4viewEv")
  //</editor-fold>
  public void view() /*const*/ {
    ViewGraph(((/*const_cast*/BlockFrequencyInfo /*P*/ )(this)), new Twine(/*KEEP_STR*/"BlockFrequencyDAGs"));
    // NDEBUG
  }

  
  /// getblockFreq - Return block frequency. Return 0 if we don't have the
  /// information. Please note that initial frequency is equal to ENTRY_FREQ. It
  /// means that we should not rely on the value itself, but only on the
  /// comparison to the other block frequencies. We do this to avoid using of
  /// floating points.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::getBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 153,
   FQN="llvm::BlockFrequencyInfo::getBlockFreq", NM="_ZNK4llvm18BlockFrequencyInfo12getBlockFreqEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo12getBlockFreqEPKNS_10BasicBlockE")
  //</editor-fold>
  public BlockFrequency getBlockFreq(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    return BFI.$bool() ? BFI.$arrow().getBlockFreq(BB) : new BlockFrequency($int2ulong(0));
  }

  
  /// \brief Returns the estimated profile count of \p BB.
  /// This computes the relative block frequency of \p BB and multiplies it by
  /// the enclosing function's count (if available) and returns the value.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::getBlockProfileCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 157,
   FQN="llvm::BlockFrequencyInfo::getBlockProfileCount", NM="_ZNK4llvm18BlockFrequencyInfo20getBlockProfileCountEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo20getBlockProfileCountEPKNS_10BasicBlockE")
  //</editor-fold>
  public OptionalULong getBlockProfileCount(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    if (!BFI.$bool()) {
      return new OptionalULong(None);
    }
    
    return BFI.$arrow().getBlockProfileCount($Deref(getFunction()), BB);
  }

  
  // Set the frequency of the given basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::setBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 165,
   FQN="llvm::BlockFrequencyInfo::setBlockFreq", NM="_ZN4llvm18BlockFrequencyInfo12setBlockFreqEPKNS_10BasicBlockEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfo12setBlockFreqEPKNS_10BasicBlockEy")
  //</editor-fold>
  public void setBlockFreq(/*const*/ BasicBlock /*P*/ BB, long/*uint64_t*/ Freq) {
    assert (BFI.$bool()) : "Expected analysis to be available";
    BFI.$arrow().setBlockFreq(BB, Freq);
  }

  
  /// calculate - compute block frequency info for the given function.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::calculate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 138,
   FQN="llvm::BlockFrequencyInfo::calculate", NM="_ZN4llvm18BlockFrequencyInfo9calculateERKNS_8FunctionERKNS_21BranchProbabilityInfoERKNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfo9calculateERKNS_8FunctionERKNS_21BranchProbabilityInfoERKNS_8LoopInfoE")
  //</editor-fold>
  public void calculate(final /*const*/ Function /*&*/ F, 
           final /*const*/ BranchProbabilityInfo /*&*/ BPI, 
           final /*const*/ LoopInfo /*&*/ LI) {
    if (!BFI.$bool()) {
      BFI.reset(new BlockFrequencyInfoImpl<BasicBlock>());
    }
    BFI.$arrow().calculate(F, BPI, LI);
    if (ViewBlockFreqPropagationDAG.$T() != GVDAGType.GVDT_None
       && (ViewBlockFreqFuncName.std$string().empty()
       || F.getName().equals(new StringRef(ViewBlockFreqFuncName)))) {
      view();
    }
  }

  
  // Print the block frequency Freq to OS using the current functions entry
  // frequency to convert freq into a relative decimal form.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::printBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 190,
   FQN="llvm::BlockFrequencyInfo::printBlockFreq", NM="_ZNK4llvm18BlockFrequencyInfo14printBlockFreqERNS_11raw_ostreamENS_14BlockFrequencyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo14printBlockFreqERNS_11raw_ostreamENS_14BlockFrequencyE")
  //</editor-fold>
  public raw_ostream /*&*/ printBlockFreq(final raw_ostream /*&*/ OS, /*const*/ BlockFrequency Freq) /*const*/ {
    return BFI.$bool() ? BFI.$arrow().printBlockFreq(OS, Freq) : OS;
  }

  
  // Convenience method that attempts to look up the frequency associated with
  // BB and print it to OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::printBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 195,
   FQN="llvm::BlockFrequencyInfo::printBlockFreq", NM="_ZNK4llvm18BlockFrequencyInfo14printBlockFreqERNS_11raw_ostreamEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo14printBlockFreqERNS_11raw_ostreamEPKNS_10BasicBlockE")
  //</editor-fold>
  public raw_ostream /*&*/ printBlockFreq(final raw_ostream /*&*/ OS, 
                /*const*/ BasicBlock /*P*/ BB) /*const*/ {
    return BFI.$bool() ? BFI.$arrow().printBlockFreq(OS, BB) : OS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::getEntryFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 201,
   FQN="llvm::BlockFrequencyInfo::getEntryFreq", NM="_ZNK4llvm18BlockFrequencyInfo12getEntryFreqEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo12getEntryFreqEv")
  //</editor-fold>
  public long/*uint64_t*/ getEntryFreq() /*const*/ {
    return BFI.$bool() ? BFI.$arrow().getEntryFreq() : $int2ullong(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 205,
   FQN="llvm::BlockFrequencyInfo::releaseMemory", NM="_ZN4llvm18BlockFrequencyInfo13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm18BlockFrequencyInfo13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    BFI.reset();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfo::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 207,
   FQN="llvm::BlockFrequencyInfo::print", NM="_ZNK4llvm18BlockFrequencyInfo5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm18BlockFrequencyInfo5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    if (BFI.$bool()) {
      BFI.$arrow().print(OS);
    }
  }

  
  @Override public String toString() {
    return "" + "BFI=" + BFI; // NOI18N
  }
}
