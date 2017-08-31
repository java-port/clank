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

package org.llvm.analysis.target;

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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.Triple;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
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
import org.llvm.analysis.target.impl.TargetLibraryInfoLlvmStatics;

//<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 321,
 FQN="llvm::TargetLibraryInfoWrapperPass", NM="_ZN4llvm28TargetLibraryInfoWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPassE")
//</editor-fold>
public class TargetLibraryInfoWrapperPass extends /*public*/ ImmutablePass implements Destructors.ClassWithDestructor {
  private TargetLibraryInfoImpl TLIImpl;
  private TargetLibraryInfo TLI;

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1172,
   FQN="llvm::TargetLibraryInfoWrapperPass::anchor", NM="_ZN4llvm28TargetLibraryInfoWrapperPass6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPass6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::TargetLibraryInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1149,
   FQN="llvm::TargetLibraryInfoWrapperPass::TargetLibraryInfoWrapperPass", NM="_ZN4llvm28TargetLibraryInfoWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPassC1Ev")
  //</editor-fold>
  public TargetLibraryInfoWrapperPass() {
    // : ImmutablePass(ID), TLIImpl(), TLI(TLIImpl)
    //START JInit
    super(ID);
    this.TLIImpl = new TargetLibraryInfoImpl();
    this.TLI = new TargetLibraryInfo(TLIImpl);
    //END JInit
    TargetLibraryInfoLlvmStatics.initializeTargetLibraryInfoWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::TargetLibraryInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1154,
   FQN="llvm::TargetLibraryInfoWrapperPass::TargetLibraryInfoWrapperPass", NM="_ZN4llvm28TargetLibraryInfoWrapperPassC1ERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPassC1ERKNS_6TripleE")
  //</editor-fold>
  public TargetLibraryInfoWrapperPass(final /*const*/ Triple /*&*/ T) {
    // : ImmutablePass(ID), TLIImpl(T), TLI(TLIImpl)
    //START JInit
    super(ID);
    this.TLIImpl = new TargetLibraryInfoImpl(T);
    this.TLI = new TargetLibraryInfo(TLIImpl);
    //END JInit
    TargetLibraryInfoLlvmStatics.initializeTargetLibraryInfoWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::TargetLibraryInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1159,
   FQN="llvm::TargetLibraryInfoWrapperPass::TargetLibraryInfoWrapperPass", NM="_ZN4llvm28TargetLibraryInfoWrapperPassC1ERKNS_21TargetLibraryInfoImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPassC1ERKNS_21TargetLibraryInfoImplE")
  //</editor-fold>
  public TargetLibraryInfoWrapperPass(final /*const*/ TargetLibraryInfoImpl /*&*/ TLIImpl) {
    // : ImmutablePass(ID), TLIImpl(TLIImpl), TLI(this->TLIImpl)
    //START JInit
    super(ID);
    this.TLIImpl = new TargetLibraryInfoImpl(TLIImpl);
    this.TLI = new TargetLibraryInfo(this.TLIImpl);
    //END JInit
    TargetLibraryInfoLlvmStatics.initializeTargetLibraryInfoWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::getTLI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 333,
   FQN="llvm::TargetLibraryInfoWrapperPass::getTLI", NM="_ZN4llvm28TargetLibraryInfoWrapperPass6getTLIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPass6getTLIEv")
  //</editor-fold>
  public TargetLibraryInfo /*&*/ getTLI() {
    return TLI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::getTLI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 334,
   FQN="llvm::TargetLibraryInfoWrapperPass::getTLI", NM="_ZNK4llvm28TargetLibraryInfoWrapperPass6getTLIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm28TargetLibraryInfoWrapperPass6getTLIEv")
  //</editor-fold>
  public /*const*/ TargetLibraryInfo /*&*/ getTLI$Const() /*const*/ {
    return TLI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoWrapperPass::~TargetLibraryInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 321,
   FQN="llvm::TargetLibraryInfoWrapperPass::~TargetLibraryInfoWrapperPass", NM="_ZN4llvm28TargetLibraryInfoWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm28TargetLibraryInfoWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    TLIImpl.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<TargetLibraryInfoWrapperPass> ID = TargetLibraryInfoWrapperPass.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "TLIImpl=" + TLIImpl // NOI18N
              + ", TLI=" + TLI // NOI18N
              + super.toString(); // NOI18N
  }
}
