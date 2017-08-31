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

package org.llvm.support;

import org.clank.support.*;
import org.llvm.support.*;

/*template <typename T, typename Cleanup = CrashRecoveryContextDeleteCleanup<T>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContextCleanupRegistrar">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 182,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 184,
 FQN = "llvm::CrashRecoveryContextCleanupRegistrar", NM = "_ZN4llvm36CrashRecoveryContextCleanupRegistrarE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm36CrashRecoveryContextCleanupRegistrarE")
//</editor-fold>
public class CrashRecoveryContextCleanupRegistrar</*typename*/ T/*, typename Cleanup = CrashRecoveryContextDeleteCleanup<T>*/>  implements Destructors.ClassWithDestructor {
  private CrashRecoveryContextCleanup /*P*/ cleanup;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContextCleanupRegistrar::CrashRecoveryContextCleanupRegistrar<T, Cleanup>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 188,
   FQN = "llvm::CrashRecoveryContextCleanupRegistrar::CrashRecoveryContextCleanupRegistrar<T, Cleanup>", NM = "_ZN4llvm36CrashRecoveryContextCleanupRegistrarC1EPT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm36CrashRecoveryContextCleanupRegistrarC1EPT_")
  //</editor-fold>
  public CrashRecoveryContextCleanupRegistrar(T /*P*/ x) {
    /* : cleanup(Cleanup::create(x))*/ 
    NativeTrace.traceNotImplemented("CrashRecoveryContextCleanupRegistrar.CrashRecoveryContextCleanupRegistrar");
  }
  public CrashRecoveryContextCleanupRegistrar(CrashRecoveryContextCleanup Cleanup, T /*P*/ x) {
    /* : cleanup(Cleanup::create(x))*/ 
    NativeTrace.traceNotImplemented("CrashRecoveryContextCleanupRegistrar.CrashRecoveryContextCleanupRegistrar");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContextCleanupRegistrar::~CrashRecoveryContextCleanupRegistrar<T, Cleanup>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 194,
   FQN = "llvm::CrashRecoveryContextCleanupRegistrar::~CrashRecoveryContextCleanupRegistrar<T, Cleanup>", NM = "_ZN4llvm36CrashRecoveryContextCleanupRegistrarD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm36CrashRecoveryContextCleanupRegistrarD0Ev")
  //</editor-fold>
  public void $destroy() {
    unregister();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContextCleanupRegistrar::unregister">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 198,
   FQN = "llvm::CrashRecoveryContextCleanupRegistrar::unregister", NM = "_ZN4llvm36CrashRecoveryContextCleanupRegistrar10unregisterEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm36CrashRecoveryContextCleanupRegistrar10unregisterEv")
  //</editor-fold>
  public void unregister() {
    NativeTrace.traceNotImplemented("CrashRecoveryContextCleanupRegistrar.unregister");
  }

  
  public String toString() {
    return "" + "cleanup=" + cleanup; // NOI18N
  }
}
