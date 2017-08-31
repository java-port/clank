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

package org.llvm.support.target;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.mc.*;

/*template <class MCAsmInfoImpl> TEMPLATE*/

/// RegisterMCAsmInfo - Helper template for registering a target assembly info
/// implementation.  This invokes the static "Create" method on the class to
/// actually do the construction.  Usage:
///
/// extern "C" void LLVMInitializeFooTarget() {
///   extern Target TheFooTarget;
///   RegisterMCAsmInfo<FooMCAsmInfo> X(TheFooTarget);
/// }
//<editor-fold defaultstate="collapsed" desc="llvm::RegisterMCAsmInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 891,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 847,
 FQN = "llvm::RegisterMCAsmInfo", NM = "_ZN4llvm17RegisterMCAsmInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm17RegisterMCAsmInfoE")
//</editor-fold>
public class/*struct*/ RegisterMCAsmInfo</*class*/ MCAsmInfoImpl>  {
  //<editor-fold defaultstate="collapsed" desc="llvm::RegisterMCAsmInfo::RegisterMCAsmInfo<MCAsmInfoImpl>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 892,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 849,
   FQN = "llvm::RegisterMCAsmInfo::RegisterMCAsmInfo<MCAsmInfoImpl>", NM = "_ZN4llvm17RegisterMCAsmInfoC1ERNS_6TargetE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm17RegisterMCAsmInfoC1ERNS_6TargetE")
  //</editor-fold>
  public RegisterMCAsmInfo(Target /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /*MRI*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegisterMCAsmInfo::Allocator">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 853,
   FQN = "llvm::RegisterMCAsmInfo::Allocator", NM = "_ZN4llvm17RegisterMCAsmInfo9AllocatorERKNS_14MCRegisterInfoENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -filter=llvm::RegisterMCAsmInfo::Allocator")
  //</editor-fold>
  private static MCAsmInfo /*P*/ Allocator(/*const*/MCRegisterInfo /*&*/ $Prm0, StringRef TT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
