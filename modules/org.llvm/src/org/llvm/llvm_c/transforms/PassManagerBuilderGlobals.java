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


//<editor-fold defaultstate="collapsed" desc="static type PassManagerBuilderGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.transforms.PassManagerBuilderGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z28LLVMPassManagerBuilderCreate;_Z29LLVMPassManagerBuilderDispose;_Z33LLVMPassManagerBuilderSetOptLevel;_Z34LLVMPassManagerBuilderSetSizeLevel;_Z43LLVMPassManagerBuilderSetDisableUnitAtATime;_Z43LLVMPassManagerBuilderSetDisableUnrollLoops;_Z44LLVMPassManagerBuilderPopulateLTOPassManager;_Z45LLVMPassManagerBuilderUseInlinerWithThreshold;_Z47LLVMPassManagerBuilderPopulateModulePassManager;_Z48LLVMPassManagerBuilderSetDisableSimplifyLibCalls;_Z49LLVMPassManagerBuilderPopulateFunctionPassManager; -static-type=PassManagerBuilderGlobals -package=org.llvm.llvm_c.transforms")
//</editor-fold>
public final class PassManagerBuilderGlobals {


/**
* @defgroup LLVMCTransformsPassManagerBuilder Pass manager builder
* @ingroup LLVMCTransforms
*
* @{
*/

/** See llvm::PassManagerBuilder. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderCreate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 824,
 FQN="LLVMPassManagerBuilderCreate", NM="_Z28LLVMPassManagerBuilderCreate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z28LLVMPassManagerBuilderCreate")
//</editor-fold>
public static  LLVMOpaquePassManagerBuilder /*P*/ LLVMPassManagerBuilderCreate() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderDispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 829,
 FQN="LLVMPassManagerBuilderDispose", NM="_Z29LLVMPassManagerBuilderDispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z29LLVMPassManagerBuilderDispose")
//</editor-fold>
public static void LLVMPassManagerBuilderDispose( LLVMOpaquePassManagerBuilder /*P*/ PMB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::OptLevel. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetOptLevel">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 834,
 FQN="LLVMPassManagerBuilderSetOptLevel", NM="_Z33LLVMPassManagerBuilderSetOptLevel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z33LLVMPassManagerBuilderSetOptLevel")
//</editor-fold>
public static void LLVMPassManagerBuilderSetOptLevel( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                 /*uint*/int OptLevel) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::SizeLevel. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetSizeLevel">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 841,
 FQN="LLVMPassManagerBuilderSetSizeLevel", NM="_Z34LLVMPassManagerBuilderSetSizeLevel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z34LLVMPassManagerBuilderSetSizeLevel")
//</editor-fold>
public static void LLVMPassManagerBuilderSetSizeLevel( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                  /*uint*/int SizeLevel) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::DisableUnitAtATime. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetDisableUnitAtATime">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 848,
 FQN="LLVMPassManagerBuilderSetDisableUnitAtATime", NM="_Z43LLVMPassManagerBuilderSetDisableUnitAtATime",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z43LLVMPassManagerBuilderSetDisableUnitAtATime")
//</editor-fold>
public static void LLVMPassManagerBuilderSetDisableUnitAtATime( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                           int Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::DisableUnrollLoops. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetDisableUnrollLoops">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 855,
 FQN="LLVMPassManagerBuilderSetDisableUnrollLoops", NM="_Z43LLVMPassManagerBuilderSetDisableUnrollLoops",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z43LLVMPassManagerBuilderSetDisableUnrollLoops")
//</editor-fold>
public static void LLVMPassManagerBuilderSetDisableUnrollLoops( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                           int Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::DisableSimplifyLibCalls */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetDisableSimplifyLibCalls">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 862,
 FQN="LLVMPassManagerBuilderSetDisableSimplifyLibCalls", NM="_Z48LLVMPassManagerBuilderSetDisableSimplifyLibCalls",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z48LLVMPassManagerBuilderSetDisableSimplifyLibCalls")
//</editor-fold>
public static void LLVMPassManagerBuilderSetDisableSimplifyLibCalls( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                                int Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::Inliner. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderUseInlinerWithThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 868,
 FQN="LLVMPassManagerBuilderUseInlinerWithThreshold", NM="_Z45LLVMPassManagerBuilderUseInlinerWithThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z45LLVMPassManagerBuilderUseInlinerWithThreshold")
//</editor-fold>
public static void LLVMPassManagerBuilderUseInlinerWithThreshold( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                             /*uint*/int Threshold) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::populateFunctionPassManager. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderPopulateFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 875,
 FQN="LLVMPassManagerBuilderPopulateFunctionPassManager", NM="_Z49LLVMPassManagerBuilderPopulateFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z49LLVMPassManagerBuilderPopulateFunctionPassManager")
//</editor-fold>
public static void LLVMPassManagerBuilderPopulateFunctionPassManager( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                                  LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::populateModulePassManager. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderPopulateModulePassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 883,
 FQN="LLVMPassManagerBuilderPopulateModulePassManager", NM="_Z47LLVMPassManagerBuilderPopulateModulePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z47LLVMPassManagerBuilderPopulateModulePassManager")
//</editor-fold>
public static void LLVMPassManagerBuilderPopulateModulePassManager( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                                LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::PassManagerBuilder::populateLTOPassManager. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderPopulateLTOPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 891,
 FQN="LLVMPassManagerBuilderPopulateLTOPassManager", NM="_Z44LLVMPassManagerBuilderPopulateLTOPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z44LLVMPassManagerBuilderPopulateLTOPassManager")
//</editor-fold>
public static void LLVMPassManagerBuilderPopulateLTOPassManager( LLVMOpaquePassManagerBuilder /*P*/ PMB, 
                                             LLVMOpaquePassManager /*P*/ PM, 
                                            int Internalize, 
                                            int RunInliner) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class PassManagerBuilderGlobals
