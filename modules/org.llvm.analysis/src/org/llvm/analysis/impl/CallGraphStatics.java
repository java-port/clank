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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;


//<editor-fold defaultstate="collapsed" desc="static type CallGraphStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.impl.CallGraphStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZL38InitializeCallGraphWrapperPassPassFlag;_ZL38initializeCallGraphWrapperPassPassOnceRN4llvm12PassRegistryE;_ZL44InitializeCallGraphPrinterLegacyPassPassFlag;_ZL44initializeCallGraphPrinterLegacyPassPassOnceRN4llvm12PassRegistryE; -static-type=CallGraphStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class CallGraphStatics {

//<editor-fold defaultstate="collapsed" desc="initializeCallGraphWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 293,
 FQN="initializeCallGraphWrapperPassPassOnce", NM="_ZL38initializeCallGraphWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZL38initializeCallGraphWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeCallGraphWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("CallGraph Construction"), $("basiccg"), $AddrOf(CallGraphWrapperPass.ID), 
          ()->new CallGraphWrapperPass(),
//          ((NormalCtor_t)(/*FuncRef*/<CallGraphWrapperPass>callDefaultCtor)), 
          false, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeCallGraphWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 293,
 FQN="InitializeCallGraphWrapperPassPassFlag", NM="_ZL38InitializeCallGraphWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZL38InitializeCallGraphWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeCallGraphWrapperPassPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="initializeCallGraphPrinterLegacyPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 333,
 FQN="initializeCallGraphPrinterLegacyPassPassOnce", NM="_ZL44initializeCallGraphPrinterLegacyPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZL44initializeCallGraphPrinterLegacyPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeCallGraphPrinterLegacyPassPassOnce(final PassRegistry /*&*/ Registry) {
  CallGraphLlvmStatics.initializeCallGraphWrapperPassPass(Registry);
  PassInfo /*P*/ PI = new PassInfo($("Print a call graph"), $("print-callgraph"), $AddrOf(CallGraphPrinterLegacyPass.ID), 
          ()->new CallGraphPrinterLegacyPass(),
//          ((NormalCtor_t)(/*FuncRef*/<CallGraphPrinterLegacyPass>callDefaultCtor)), 
          true, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeCallGraphPrinterLegacyPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 336,
 FQN="InitializeCallGraphPrinterLegacyPassPassFlag", NM="_ZL44InitializeCallGraphPrinterLegacyPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZL44InitializeCallGraphPrinterLegacyPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeCallGraphPrinterLegacyPassPassFlag/*J*/= new std.once_flag();
} // END OF class CallGraphStatics
