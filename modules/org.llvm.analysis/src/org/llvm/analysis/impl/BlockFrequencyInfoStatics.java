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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;
import org.llvm.cl.*;
import static org.llvm.cl.ClGlobals.clEnumValEnd;
import org.llvm.cl.aliases.optString;
import org.llvm.cl.aliases.optUInt;


//<editor-fold defaultstate="collapsed" desc="static type BlockFrequencyInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.impl.BlockFrequencyInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_Z18ViewHotFreqPercent;_Z21ViewBlockFreqFuncNameB5cxx11;_ZL27ViewBlockFreqPropagationDAG;_ZL47InitializeBlockFrequencyInfoWrapperPassPassFlag;_ZL47initializeBlockFrequencyInfoWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=BlockFrequencyInfoStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class BlockFrequencyInfoStatics {

//<editor-fold defaultstate="collapsed" desc="ViewBlockFreqPropagationDAG">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 30,
 FQN="ViewBlockFreqPropagationDAG", NM="_ZL27ViewBlockFreqPropagationDAG",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZL27ViewBlockFreqPropagationDAG")
//</editor-fold>
public static optEnum<GVDAGType> ViewBlockFreqPropagationDAG/*J*/= new optEnum<GVDAGType>(GVDAGType::valueOf, opt.StorageKind.Internal, $("view-block-freq-propagation-dags"), OptionHidden.Hidden, 
    new desc($("Pop up a window to show a dag displaying how block frequencies propagation through the CFG.")), 
    ClGlobals.values/*$Int*/($("none"), ((int)(GVDAGType.GVDT_None.getValue())), $("do not display graphs."), 
        $("fraction"), ((int)(GVDAGType.GVDT_Fraction.getValue())), $("display a graph using the fractional block frequency representation."), 
        $("integer"), ((int)(GVDAGType.GVDT_Integer.getValue())), $("display a graph using the raw integer fractional block frequency representation."), 
        $("count"), ((int)(GVDAGType.GVDT_Count.getValue())), $("display a graph using the real profile count if available."), 
        (reinterpret_cast(Object/*void P*/ .class, clEnumValEnd))));
//<editor-fold defaultstate="collapsed" desc="ViewBlockFreqFuncName">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 45,
 FQN="ViewBlockFreqFuncName", NM="_Z21ViewBlockFreqFuncName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_Z21ViewBlockFreqFuncName")
//</editor-fold>
public static optString ViewBlockFreqFuncName/*J*/= new optString(opt.StorageKind.Internal, $("view-bfi-func-name"), OptionHidden.Hidden, 
    new desc($("The option to specify the name of the function whose CFG will be displayed.")));
//<editor-fold defaultstate="collapsed" desc="ViewHotFreqPercent">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 51,
 FQN="ViewHotFreqPercent", NM="_Z18ViewHotFreqPercent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_Z18ViewHotFreqPercent")
//</editor-fold>
public static optUInt ViewHotFreqPercent/*J*/= new optUInt(opt.StorageKind.Internal, $("view-hot-freq-percent"), ClGlobals.init$Int(10), OptionHidden.Hidden, 
    new desc($("An integer in percent used to specify the hot blocks/edges to be displayed in red: a block or edge whose frequency is no less than the max frequency of the function multiplied by this percent.")));
//<editor-fold defaultstate="collapsed" desc="initializeBlockFrequencyInfoWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 213,
 FQN="initializeBlockFrequencyInfoWrapperPassPassOnce", NM="_ZL47initializeBlockFrequencyInfoWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZL47initializeBlockFrequencyInfoWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeBlockFrequencyInfoWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  BranchProbabilityInfoLlvmStatics.initializeBranchProbabilityInfoWrapperPassPass(Registry);
  LoopInfoLlvmStatics.initializeLoopInfoWrapperPassPass(Registry);
  PassInfo /*P*/ PI = new PassInfo($("Block Frequency Analysis"), $("block-freq"), $AddrOf(BlockFrequencyInfoWrapperPass.ID),
          ()->new BlockFrequencyInfoWrapperPass(),
          //((NormalCtor_t)(/*FuncRef*/<BlockFrequencyInfoWrapperPass>callDefaultCtor)),
          true, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeBlockFrequencyInfoWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 217,
 FQN="InitializeBlockFrequencyInfoWrapperPassPassFlag", NM="_ZL47InitializeBlockFrequencyInfoWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZL47InitializeBlockFrequencyInfoWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeBlockFrequencyInfoWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class BlockFrequencyInfoStatics
