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

package org.llvm.bitcode.writer.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.analysis.ModuleSummaryIndexWrapperPass;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.bitcode.impl.BitcodeWriterLlvmGlobals;
import org.llvm.pass.AnalysisUsage;
import org.llvm.pass.IrLlvmGlobals;
import static org.llvm.pass.IrLlvmGlobals.initializeWriteBitcodePassPass;
import org.llvm.pass.ModulePass;
import org.llvm.pass.PassRegistry;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 32,
 FQN="(anonymous namespace)::WriteBitcodePass", NM="_ZN12_GLOBAL__N_116WriteBitcodePassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN12_GLOBAL__N_116WriteBitcodePassE")
//</editor-fold>
public class WriteBitcodePass extends /*public*/ ModulePass implements Destructors.ClassWithDestructor {
  private final raw_ostream /*&*/ OS; // raw_ostream to print on
  private boolean ShouldPreserveUseListOrder;
  private boolean EmitSummaryIndex;
  private boolean EmitModuleHash;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0); // Pass identification, replacement for typeid
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass::WriteBitcodePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 40,
   FQN="(anonymous namespace)::WriteBitcodePass::WriteBitcodePass", NM="_ZN12_GLOBAL__N_116WriteBitcodePassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN12_GLOBAL__N_116WriteBitcodePassC1Ev")
  //</editor-fold>
  public WriteBitcodePass() {
    // : ModulePass(ID), OS(dbgs()) 
    //START JInit
    super(ID);
    this./*&*/OS=/*&*/dbgs();
    //END JInit
    IrLlvmGlobals.initializeWriteBitcodePassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass::WriteBitcodePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 44,
   FQN="(anonymous namespace)::WriteBitcodePass::WriteBitcodePass", NM="_ZN12_GLOBAL__N_116WriteBitcodePassC1ERN4llvm11raw_ostreamEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN12_GLOBAL__N_116WriteBitcodePassC1ERN4llvm11raw_ostreamEbbb")
  //</editor-fold>
  public /*explicit*/ WriteBitcodePass(final raw_ostream /*&*/ o, boolean ShouldPreserveUseListOrder, 
      boolean EmitSummaryIndex, boolean EmitModuleHash) {
    // : ModulePass(ID), OS(o), ShouldPreserveUseListOrder(ShouldPreserveUseListOrder), EmitSummaryIndex(EmitSummaryIndex), EmitModuleHash(EmitModuleHash) 
    //START JInit
    super(ID);
    this./*&*/OS=/*&*/o;
    this.ShouldPreserveUseListOrder = ShouldPreserveUseListOrder;
    this.EmitSummaryIndex = EmitSummaryIndex;
    this.EmitModuleHash = EmitModuleHash;
    //END JInit
    initializeWriteBitcodePassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 52,
   FQN="(anonymous namespace)::WriteBitcodePass::getPassName", NM="_ZNK12_GLOBAL__N_116WriteBitcodePass11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZNK12_GLOBAL__N_116WriteBitcodePass11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    return $("Bitcode Writer");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 54,
   FQN="(anonymous namespace)::WriteBitcodePass::runOnModule", NM="_ZN12_GLOBAL__N_116WriteBitcodePass11runOnModuleERN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN12_GLOBAL__N_116WriteBitcodePass11runOnModuleERN4llvm6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module /*&*/ M)/* override*/ {
    /*const*/ ModuleSummaryIndex /*P*/ Index = EmitSummaryIndex ? $AddrOf((this.<ModuleSummaryIndexWrapperPass>getAnalysis(ModuleSummaryIndexWrapperPass.class).getIndex())) : null;
    BitcodeWriterLlvmGlobals.WriteBitcodeToFile($AddrOf(M), OS, ShouldPreserveUseListOrder, Index, 
        EmitModuleHash);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 63,
   FQN="(anonymous namespace)::WriteBitcodePass::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_116WriteBitcodePass16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZNK12_GLOBAL__N_116WriteBitcodePass16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    if (EmitSummaryIndex) {
      AU.<ModuleSummaryIndexWrapperPass>addRequired(ModuleSummaryIndexWrapperPass.class);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WriteBitcodePass::~WriteBitcodePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 32,
   FQN="(anonymous namespace)::WriteBitcodePass::~WriteBitcodePass", NM="_ZN12_GLOBAL__N_116WriteBitcodePassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN12_GLOBAL__N_116WriteBitcodePassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<WriteBitcodePass> ID = WriteBitcodePass.class; // Pass identification, replacement for typeid

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", ShouldPreserveUseListOrder=" + ShouldPreserveUseListOrder // NOI18N
              + ", EmitSummaryIndex=" + EmitSummaryIndex // NOI18N
              + ", EmitModuleHash=" + EmitModuleHash // NOI18N
              + super.toString(); // NOI18N
  }
}
