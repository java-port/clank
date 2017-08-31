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

package org.llvm.ir.impl;

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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintFunctionPassWrapper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 75,
 FQN="(anonymous namespace)::PrintFunctionPassWrapper", NM="_ZN12_GLOBAL__N_124PrintFunctionPassWrapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN12_GLOBAL__N_124PrintFunctionPassWrapperE")
//</editor-fold>
public class PrintFunctionPassWrapper extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private PrintFunctionPass P;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintFunctionPassWrapper::PrintFunctionPassWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 80,
   FQN="(anonymous namespace)::PrintFunctionPassWrapper::PrintFunctionPassWrapper", NM="_ZN12_GLOBAL__N_124PrintFunctionPassWrapperC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN12_GLOBAL__N_124PrintFunctionPassWrapperC1Ev")
  //</editor-fold>
  public PrintFunctionPassWrapper() {
    // : FunctionPass(ID), P()
    //START JInit
    super(ID);
    this.P = new PrintFunctionPass();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintFunctionPassWrapper::PrintFunctionPassWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 81,
   FQN="(anonymous namespace)::PrintFunctionPassWrapper::PrintFunctionPassWrapper", NM="_ZN12_GLOBAL__N_124PrintFunctionPassWrapperC1ERN4llvm11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN12_GLOBAL__N_124PrintFunctionPassWrapperC1ERN4llvm11raw_ostreamERKSs")
  //</editor-fold>
  public PrintFunctionPassWrapper(final raw_ostream /*&*/ OS, final /*const*/std.string/*&*/ Banner) {
    // : FunctionPass(ID), P(OS, Banner)
    //START JInit
    super(ID);
    this.P = new PrintFunctionPass(OS, Banner);
    //END JInit
  }


  // This pass just prints a banner followed by the function as it's processed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintFunctionPassWrapper::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 85,
   FQN="(anonymous namespace)::PrintFunctionPassWrapper::runOnFunction", NM="_ZN12_GLOBAL__N_124PrintFunctionPassWrapper13runOnFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN12_GLOBAL__N_124PrintFunctionPassWrapper13runOnFunctionERN4llvm8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    AnalysisManager<Function> DummyFAM = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DummyFAM/*J*/= new AnalysisManager<Function>();
      $c$.clean($c$.track(P.run(F, DummyFAM)));
      return false;
    } finally {
      if (DummyFAM != null) { DummyFAM.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintFunctionPassWrapper::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 91,
   FQN="(anonymous namespace)::PrintFunctionPassWrapper::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_124PrintFunctionPassWrapper16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZNK12_GLOBAL__N_124PrintFunctionPassWrapper16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintFunctionPassWrapper::~PrintFunctionPassWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 75,
   FQN="(anonymous namespace)::PrintFunctionPassWrapper::~PrintFunctionPassWrapper", NM="_ZN12_GLOBAL__N_124PrintFunctionPassWrapperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN12_GLOBAL__N_124PrintFunctionPassWrapperD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    P.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<PrintFunctionPassWrapper> ID = PrintFunctionPassWrapper.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "P=" + P // NOI18N
              + super.toString(); // NOI18N
  }
}
