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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;
import org.llvm.cl.*;
import org.llvm.cl.aliases.optBool;


//<editor-fold defaultstate="collapsed" desc="static type LoopInfoStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.llvm.analysis.impl.LoopInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZL14VerifyLoopInfo;_ZL15VerifyLoopInfoX;_ZL37InitializeLoopInfoWrapperPassPassFlag;_ZL37initializeLoopInfoWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=LoopInfoStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class LoopInfoStatics {

//<editor-fold defaultstate="collapsed" desc="VerifyLoopInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 45,
 FQN="VerifyLoopInfo", NM="_ZL14VerifyLoopInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZL14VerifyLoopInfo")
//</editor-fold>
public static boolean VerifyLoopInfo = false;
//////////////////////////////////////////////////////////////
// EXTRA MEMBERS: BEGIN

public static bool$ref VerifyLoopInfo_ref = new bool$ref() {
  @Override
  public boolean $deref() {
    return VerifyLoopInfo;
  }

  @Override
  public boolean $set(boolean value) {
    VerifyLoopInfo = value;
    return VerifyLoopInfo;
  }
};


// EXTRA MEMBERS: END
//////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="VerifyLoopInfoX">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 47,
 FQN="VerifyLoopInfoX", NM="_ZL15VerifyLoopInfoX",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZL15VerifyLoopInfoX")
//</editor-fold>
public static optBool VerifyLoopInfoX/*J*/= new optBool(opt.StorageKind.External, opt.StorageKind.External, $("verify-loop-info"), ClGlobals.location$Bool(VerifyLoopInfo_ref), 
    new desc($("Verify loop info (time consuming)")));
//<editor-fold defaultstate="collapsed" desc="initializeLoopInfoWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 687,
 FQN="initializeLoopInfoWrapperPassPassOnce", NM="_ZL37initializeLoopInfoWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZL37initializeLoopInfoWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeLoopInfoWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeDominatorTreeWrapperPassPass(Registry);
  PassInfo /*P*/ PI = new PassInfo($("Natural Loop Information"), $("loops"), $AddrOf(LoopInfoWrapperPass.ID), 
          ()-> new LoopInfoWrapperPass(),
          //((NormalCtor_t)(/*FuncRef*/<LoopInfoWrapperPass>callDefaultCtor)),
          true, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeLoopInfoWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 690,
 FQN="InitializeLoopInfoWrapperPassPassFlag", NM="_ZL37InitializeLoopInfoWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZL37InitializeLoopInfoWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeLoopInfoWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class LoopInfoStatics
