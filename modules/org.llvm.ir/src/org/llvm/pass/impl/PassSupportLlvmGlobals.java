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
package org.llvm.pass.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.support.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type PassSupportLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.pass.impl.PassSupportLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm15callDefaultCtorEv;Tpl__ZN4llvm21callTargetMachineCtorEPNS_13TargetMachineE; -static-type=PassSupportLlvmGlobals -package=org.llvm.pass.impl")
//</editor-fold>
public final class PassSupportLlvmGlobals {

/*template <typename PassName> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::callDefaultCtor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 79,
 FQN="llvm::callDefaultCtor", NM="Tpl__ZN4llvm15callDefaultCtorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm15callDefaultCtorEv")
//</editor-fold>
public static </*typename*/ PassName> Pass /*P*/ callDefaultCtor(Class<PassName> cls) {
  //return /*FIXME: NEW_EXPR [NoNewFun]*/new PassName((  ));
  try {
    Constructor<PassName> constructor = cls.getConstructor();
      return (Pass) constructor.newInstance();
  } catch (InstantiationException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IllegalArgumentException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (InvocationTargetException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (NoSuchMethodException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (SecurityException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  }
  return null;
}

/*template <typename PassName> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::callTargetMachineCtor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 81,
 FQN="llvm::callTargetMachineCtor", NM="Tpl__ZN4llvm21callTargetMachineCtorEPNS_13TargetMachineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm21callTargetMachineCtorEPNS_13TargetMachineE")
//</editor-fold>
public static </*typename*/ PassName> Pass /*P*/ callTargetMachineCtor(Class<PassName> cls, TargetMachineForward /*P*/ TM) {
  //return /*FIXME: NEW_EXPR [NoNewFun]*/new PassName(( TM ));
  try {
    Constructor<PassName> constructor = cls.getConstructor(TargetMachineForward.class);
    return (Pass) constructor.newInstance(TM);
  } catch (InstantiationException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IllegalArgumentException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (InvocationTargetException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (NoSuchMethodException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  } catch (SecurityException ex) {
    Logger.getLogger(PassSupportLlvmGlobals.class.getName()).log(Level.SEVERE, null, ex);
  }
  return null;
}

} // END OF class PassSupportLlvmGlobals
