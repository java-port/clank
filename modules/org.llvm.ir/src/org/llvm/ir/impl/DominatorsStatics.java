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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.ir.*;
import org.llvm.cl.*;
import org.llvm.pass.*;
import org.llvm.cl.aliases.optBool;


//<editor-fold defaultstate="collapsed" desc="static type DominatorsStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.llvm.ir.impl.DominatorsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZL13VerifyDomInfo;_ZL14VerifyDomInfoX;_ZL42InitializeDominatorTreeWrapperPassPassFlag;_ZL42initializeDominatorTreeWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=DominatorsStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class DominatorsStatics {

//<editor-fold defaultstate="collapsed" desc="VerifyDomInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 34,
 FQN="VerifyDomInfo", NM="_ZL13VerifyDomInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZL13VerifyDomInfo")
//</editor-fold>
public static boolean VerifyDomInfo = false;
@Converted(kind = Converted.Kind.MANUAL_ADDED)
private static bool$ref VerifyDomInfo$ref = new bool$ref() {
  @Override
  public boolean $deref() {
    return VerifyDomInfo;
  }

  @Override
  public boolean $set(boolean value) {
    VerifyDomInfo = value;  
    return VerifyDomInfo;
  }
};
//<editor-fold defaultstate="collapsed" desc="VerifyDomInfoX">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 36,
 FQN="VerifyDomInfoX", NM="_ZL14VerifyDomInfoX",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZL14VerifyDomInfoX")
//</editor-fold>
public static optBool VerifyDomInfoX/*J*/= new optBool(opt.StorageKind.External, $("verify-dom-info"), ClGlobals.location$Bool(VerifyDomInfo$ref), 
    new desc($("Verify dominator info (time consuming)")));
//<editor-fold defaultstate="collapsed" desc="initializeDominatorTreeWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 339,
 FQN="initializeDominatorTreeWrapperPassPassOnce", NM="_ZL42initializeDominatorTreeWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZL42initializeDominatorTreeWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeDominatorTreeWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Dominator Tree Construction"), $("domtree"),
          $AddrOf(DominatorTreeWrapperPass.ID), () -> new DominatorTreeWrapperPass(),
          //((type$ptr<Pass /*P*/ (/*P*/ )()>)(/*FuncRef*/IrLlvmGlobals.<DominatorTreeWrapperPass>callDefaultCtor)),
          true, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeDominatorTreeWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 339,
 FQN="InitializeDominatorTreeWrapperPassPassFlag", NM="_ZL42InitializeDominatorTreeWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZL42InitializeDominatorTreeWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeDominatorTreeWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class DominatorsStatics
