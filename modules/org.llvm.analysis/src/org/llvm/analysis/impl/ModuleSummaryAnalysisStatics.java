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
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.DenseSet;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ModuleSummaryAnalysisStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.impl.ModuleSummaryAnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZL12findRefEdgesPKN4llvm4UserERNS_8DenseSetIPKNS_5ValueENS_12DenseMapInfoIS6_EEEERNS_11SmallPtrSetIS2_Lj8EEE;_ZL47InitializeModuleSummaryIndexWrapperPassPassFlag;_ZL47initializeModuleSummaryIndexWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=ModuleSummaryAnalysisStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ModuleSummaryAnalysisStatics {


// Walk through the operands of a given User via worklist iteration and populate
// the set of GlobalValue references encountered. Invoked either on an
// Instruction or a GlobalVariable (which walks its initializer).
//<editor-fold defaultstate="collapsed" desc="findRefEdges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 34,
 FQN="findRefEdges", NM="_ZL12findRefEdgesPKN4llvm4UserERNS_8DenseSetIPKNS_5ValueENS_12DenseMapInfoIS6_EEEERNS_11SmallPtrSetIS2_Lj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZL12findRefEdgesPKN4llvm4UserERNS_8DenseSetIPKNS_5ValueENS_12DenseMapInfoIS6_EEEERNS_11SmallPtrSetIS2_Lj8EEE")
//</editor-fold>
public static void findRefEdges(/*const*/ User /*P*/ CurUser, final DenseSet</*const*/ Value /*P*/ > /*&*/ RefEdges, 
            final SmallPtrSet</*const*/ User /*P*/ > /*&*/ Visited) {
  SmallVector</*const*/ User /*P*/ > Worklist/*J*/= new SmallVector</*const*/ User /*P*/ >(32, (/*const*/ User /*P*/ )null);
  Worklist.push_back(CurUser);
  while (!Worklist.empty()) {
    /*const*/ User /*P*/ U = Worklist.pop_back_val();
    if (!Visited.insert(U).second) {
      continue;
    }
    
    ImmutableCallSite CS/*J*/= new ImmutableCallSite(U);
    
    for (final /*const*/ Use /*&*/ OI : U.operands$Const()) {
      /*const*/ User /*P*/ Operand = dyn_cast_User(OI);
      if (!(Operand != null)) {
        continue;
      }
      if (isa_BlockAddress(Operand)) {
        continue;
      }
      if (isa_GlobalValue(Operand)) {
        // We have a reference to a global value. This should be added to
        // the reference set unless it is a callee. Callees are handled
        // specially by WriteFunction and are added to a separate list.
        if (!(CS.$bool() && CS.isCallee($AddrOf(OI)))) {
          RefEdges.insert(Operand);
        }
        continue;
      }
      Worklist.push_back(Operand);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="initializeModuleSummaryIndexWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 178,
 FQN="initializeModuleSummaryIndexWrapperPassPassOnce", NM="_ZL47initializeModuleSummaryIndexWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZL47initializeModuleSummaryIndexWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeModuleSummaryIndexWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  BlockFrequencyInfoLlvmStatics.initializeBlockFrequencyInfoWrapperPassPass(Registry);
  PassInfo /*P*/ PI = new PassInfo($("Module Summary Analysis"), $("module-summary-analysis"), $AddrOf(ModuleSummaryIndexWrapperPass.ID), 
          ()->new ModuleSummaryIndexWrapperPass(),
          //((NormalCtor_t)(/*FuncRef*/<ModuleSummaryIndexWrapperPass>callDefaultCtor)),
          false, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeModuleSummaryIndexWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 181,
 FQN="InitializeModuleSummaryIndexWrapperPassPassFlag", NM="_ZL47InitializeModuleSummaryIndexWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZL47InitializeModuleSummaryIndexWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeModuleSummaryIndexWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class ModuleSummaryAnalysisStatics
