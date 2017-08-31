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

package org.llvm.bitcode;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.StringRef;
import org.llvm.analysis.ModuleSummaryIndexBuilder;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.bitcode.impl.BitcodeWriterLlvmGlobals;


/// \brief Pass for writing a module of IR out to a bitcode file.
///
/// Note that this is intended for use with the new pass manager. To construct
/// a pass for the legacy pass manager, use the function above.
//<editor-fold defaultstate="collapsed" desc="llvm::BitcodeWriterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitcodeWriterPass.h", line = 47,
 FQN="llvm::BitcodeWriterPass", NM="_ZN4llvm17BitcodeWriterPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm17BitcodeWriterPassE")
//</editor-fold>
public class BitcodeWriterPass {
  private final raw_ostream /*&*/ OS;
  private boolean ShouldPreserveUseListOrder;
  private boolean EmitSummaryIndex;
  private boolean EmitModuleHash;
/*public:*/
  /// \brief Construct a bitcode writer pass around a particular output stream.
  ///
  /// If \c ShouldPreserveUseListOrder, encode use-list order so it can be
  /// reproduced when deserialized.
  ///
  /// If \c EmitSummaryIndex, emit the summary index (currently
  /// for use in ThinLTO optimization).
  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeWriterPass::BitcodeWriterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitcodeWriterPass.h", line = 61,
   FQN="llvm::BitcodeWriterPass::BitcodeWriterPass", NM="_ZN4llvm17BitcodeWriterPassC1ERNS_11raw_ostreamEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm17BitcodeWriterPassC1ERNS_11raw_ostreamEbbb")
  //</editor-fold>
  public /*explicit*/ BitcodeWriterPass(final raw_ostream /*&*/ OS) {
    this(OS, 
      false, 
      false, 
      false);
  }
  public /*explicit*/ BitcodeWriterPass(final raw_ostream /*&*/ OS, 
      boolean ShouldPreserveUseListOrder/*= false*/) {
    this(OS, 
      ShouldPreserveUseListOrder, 
      false, 
      false);
  }
  public /*explicit*/ BitcodeWriterPass(final raw_ostream /*&*/ OS, 
      boolean ShouldPreserveUseListOrder/*= false*/, 
      boolean EmitSummaryIndex/*= false*/) {
    this(OS, 
      ShouldPreserveUseListOrder, 
      EmitSummaryIndex, 
      false);
  }
  public /*explicit*/ BitcodeWriterPass(final raw_ostream /*&*/ OS, 
      boolean ShouldPreserveUseListOrder/*= false*/, 
      boolean EmitSummaryIndex/*= false*/, 
      boolean EmitModuleHash/*= false*/) {
    // : OS(OS), ShouldPreserveUseListOrder(ShouldPreserveUseListOrder), EmitSummaryIndex(EmitSummaryIndex), EmitModuleHash(EmitModuleHash) 
    //START JInit
    this./*&*/OS=/*&*/OS;
    this.ShouldPreserveUseListOrder = ShouldPreserveUseListOrder;
    this.EmitSummaryIndex = EmitSummaryIndex;
    this.EmitModuleHash = EmitModuleHash;
    //END JInit
  }

  
  /// \brief Run the bitcode writer pass, and output the module to the selected
  /// output stream.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeWriterPass::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 22,
   FQN="llvm::BitcodeWriterPass::run", NM="_ZN4llvm17BitcodeWriterPass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm17BitcodeWriterPass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Module /*&*/ M, final AnalysisManager<Module>/*&*/ $Prm1) {
    std.unique_ptr<ModuleSummaryIndex> Index = null;
    try {
      Index/*J*/= new std.unique_ptr<ModuleSummaryIndex>();
      if (EmitSummaryIndex) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Index.$assignMove($c$.track($c$.track(new ModuleSummaryIndexBuilder($AddrOf(M))).takeIndex())));
        } finally {
          $c$.$destroy();
        }
      }
      BitcodeWriterLlvmGlobals.WriteBitcodeToFile($AddrOf(M), OS, ShouldPreserveUseListOrder, Index.get(), 
          EmitModuleHash);
      return PreservedAnalyses.all();
    } finally {
      if (Index != null) { Index.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeWriterPass::name">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitcodeWriterPass.h", line = 72,
   FQN="llvm::BitcodeWriterPass::name", NM="_ZN4llvm17BitcodeWriterPass4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm17BitcodeWriterPass4nameEv")
  //</editor-fold>
  public static StringRef name() {
    return new StringRef(/*KEEP_STR*/"BitcodeWriterPass");
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", ShouldPreserveUseListOrder=" + ShouldPreserveUseListOrder // NOI18N
              + ", EmitSummaryIndex=" + EmitSummaryIndex // NOI18N
              + ", EmitModuleHash=" + EmitModuleHash; // NOI18N
  }
}
