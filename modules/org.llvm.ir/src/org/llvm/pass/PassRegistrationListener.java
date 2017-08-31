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

package org.llvm.pass;

import org.clank.support.*;


//===---------------------------------------------------------------------------
/// PassRegistrationListener class - This class is meant to be derived from by
/// clients that are interested in which passes get registered and unregistered
/// at runtime (which can be because of the RegisterPass constructors being run
/// as the program starts up, or may be because a shared object just got
/// loaded).
///
//<editor-fold defaultstate="collapsed" desc="llvm::PassRegistrationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 210,
 FQN="llvm::PassRegistrationListener", NM="_ZN4llvm24PassRegistrationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm24PassRegistrationListenerE")
//</editor-fold>
public interface/*struct*/ PassRegistrationListener extends Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistrationListener::PassRegistrationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 211,
   FQN="llvm::PassRegistrationListener::PassRegistrationListener", NM="_ZN4llvm24PassRegistrationListenerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm24PassRegistrationListenerC1Ev")
  //</editor-fold>
  public default/*interface*/ void $PassRegistrationListener() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistrationListener::~PassRegistrationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 212,
   FQN="llvm::PassRegistrationListener::~PassRegistrationListener", NM="_ZN4llvm24PassRegistrationListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm24PassRegistrationListenerD0Ev")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void $destroy$PassRegistrationListener() {
  }

  
  /// Callback functions - These functions are invoked whenever a pass is loaded
  /// or removed from the current executable.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistrationListener::passRegistered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 217,
   FQN="llvm::PassRegistrationListener::passRegistered", NM="_ZN4llvm24PassRegistrationListener14passRegisteredEPKNS_8PassInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm24PassRegistrationListener14passRegisteredEPKNS_8PassInfoE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void passRegistered(/*const*/ PassInfo /*P*/ $Prm0) {
  }

  
  /// enumeratePasses - Iterate over the registered passes, calling the
  /// passEnumerate callback on each PassInfo object.
  ///
  
  //===----------------------------------------------------------------------===//
  // PassRegistrationListener implementation
  //
  
  // enumeratePasses - Iterate over the registered passes, calling the
  // passEnumerate callback on each PassInfo object.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistrationListener::enumeratePasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 235,
   FQN="llvm::PassRegistrationListener::enumeratePasses", NM="_ZN4llvm24PassRegistrationListener15enumeratePassesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm24PassRegistrationListener15enumeratePassesEv")
  //</editor-fold>
  public default/*interface*/ void enumeratePasses() {
    PassRegistry.getPassRegistry().enumerateWith(this);
  }

  
  /// passEnumerate - Callback function invoked when someone calls
  /// enumeratePasses on this PassRegistrationListener object.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistrationListener::passEnumerate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 227,
   FQN="llvm::PassRegistrationListener::passEnumerate", NM="_ZN4llvm24PassRegistrationListener13passEnumerateEPKNS_8PassInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm24PassRegistrationListener13passEnumerateEPKNS_8PassInfoE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void passEnumerate(/*const*/ PassInfo /*P*/ $Prm0) {
  }

}
