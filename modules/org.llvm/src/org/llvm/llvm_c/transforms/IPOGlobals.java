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
package org.llvm.llvm_c.transforms;

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
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type IPOGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.transforms.IPOGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z17LLVMAddIPSCCPPass;_Z18LLVMAddPruneEHPass;_Z20LLVMAddGlobalDCEPass;_Z22LLVMAddInternalizePass;_Z23LLVMAddStripSymbolsPass;_Z24LLVMAddAlwaysInlinerPass;_Z24LLVMAddConstantMergePass;_Z24LLVMAddFunctionAttrsPass;_Z26LLVMAddGlobalOptimizerPass;_Z27LLVMAddFunctionInliningPass;_Z28LLVMAddArgumentPromotionPass;_Z29LLVMAddDeadArgEliminationPass;_Z30LLVMAddStripDeadPrototypesPass;_Z32LLVMAddIPConstantPropagationPass; -static-type=IPOGlobals -package=org.llvm.llvm_c.transforms")
//</editor-fold>
public final class IPOGlobals {


/**
* @defgroup LLVMCTransformsIPO Interprocedural transformations
* @ingroup LLVMCTransforms
*
* @{
*/

/** See llvm::createArgumentPromotionPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddArgumentPromotionPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 64,
 FQN="LLVMAddArgumentPromotionPass", NM="_Z28LLVMAddArgumentPromotionPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z28LLVMAddArgumentPromotionPass")
//</editor-fold>
public static void LLVMAddArgumentPromotionPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createConstantMergePass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddConstantMergePass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 68,
 FQN="LLVMAddConstantMergePass", NM="_Z24LLVMAddConstantMergePass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z24LLVMAddConstantMergePass")
//</editor-fold>
public static void LLVMAddConstantMergePass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createDeadArgEliminationPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddDeadArgEliminationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 72,
 FQN="LLVMAddDeadArgEliminationPass", NM="_Z29LLVMAddDeadArgEliminationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z29LLVMAddDeadArgEliminationPass")
//</editor-fold>
public static void LLVMAddDeadArgEliminationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createFunctionAttrsPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddFunctionAttrsPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 76,
 FQN="LLVMAddFunctionAttrsPass", NM="_Z24LLVMAddFunctionAttrsPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z24LLVMAddFunctionAttrsPass")
//</editor-fold>
public static void LLVMAddFunctionAttrsPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createFunctionInliningPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddFunctionInliningPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 80,
 FQN="LLVMAddFunctionInliningPass", NM="_Z27LLVMAddFunctionInliningPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z27LLVMAddFunctionInliningPass")
//</editor-fold>
public static void LLVMAddFunctionInliningPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createAlwaysInlinerPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddAlwaysInlinerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 84,
 FQN="LLVMAddAlwaysInlinerPass", NM="_Z24LLVMAddAlwaysInlinerPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z24LLVMAddAlwaysInlinerPass")
//</editor-fold>
public static void LLVMAddAlwaysInlinerPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createGlobalDCEPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddGlobalDCEPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 88,
 FQN="LLVMAddGlobalDCEPass", NM="_Z20LLVMAddGlobalDCEPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z20LLVMAddGlobalDCEPass")
//</editor-fold>
public static void LLVMAddGlobalDCEPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createGlobalOptimizerPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddGlobalOptimizerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 92,
 FQN="LLVMAddGlobalOptimizerPass", NM="_Z26LLVMAddGlobalOptimizerPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z26LLVMAddGlobalOptimizerPass")
//</editor-fold>
public static void LLVMAddGlobalOptimizerPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createIPConstantPropagationPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddIPConstantPropagationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 96,
 FQN="LLVMAddIPConstantPropagationPass", NM="_Z32LLVMAddIPConstantPropagationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z32LLVMAddIPConstantPropagationPass")
//</editor-fold>
public static void LLVMAddIPConstantPropagationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createPruneEHPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddPruneEHPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 100,
 FQN="LLVMAddPruneEHPass", NM="_Z18LLVMAddPruneEHPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z18LLVMAddPruneEHPass")
//</editor-fold>
public static void LLVMAddPruneEHPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createIPSCCPPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddIPSCCPPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 104,
 FQN="LLVMAddIPSCCPPass", NM="_Z17LLVMAddIPSCCPPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z17LLVMAddIPSCCPPass")
//</editor-fold>
public static void LLVMAddIPSCCPPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createInternalizePass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddInternalizePass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 108,
 FQN="LLVMAddInternalizePass", NM="_Z22LLVMAddInternalizePass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z22LLVMAddInternalizePass")
//</editor-fold>
public static void LLVMAddInternalizePass( LLVMOpaquePassManager /*P*/ PM, /*uint*/int AllButMain) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createStripDeadPrototypesPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddStripDeadPrototypesPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 115,
 FQN="LLVMAddStripDeadPrototypesPass", NM="_Z30LLVMAddStripDeadPrototypesPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z30LLVMAddStripDeadPrototypesPass")
//</editor-fold>
public static void LLVMAddStripDeadPrototypesPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createStripSymbolsPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddStripSymbolsPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 119,
 FQN="LLVMAddStripSymbolsPass", NM="_Z23LLVMAddStripSymbolsPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z23LLVMAddStripSymbolsPass")
//</editor-fold>
public static void LLVMAddStripSymbolsPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class IPOGlobals
