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
package org.llvm.support.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.LLVM_ENABLE_THREADS;


//<editor-fold defaultstate="collapsed" desc="static type ThreadingLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.impl.ThreadingLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=Tpl__ZN4llvm9call_onceERSt9once_flagOT_DpOT0_;_ZN4llvm21llvm_is_multithreadedEv;_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j; -static-type=ThreadingLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class ThreadingLlvmGlobals {

/// Returns true if LLVM is compiled with support for multi-threading, and
/// false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_is_multithreaded">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", line = 24,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", old_line = 23,
 FQN="llvm::llvm_is_multithreaded", NM="_ZN4llvm21llvm_is_multithreadedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=_ZN4llvm21llvm_is_multithreadedEv")
//</editor-fold>
public static boolean llvm_is_multithreaded() {
  if (LLVM_ENABLE_THREADS) {
    return true;
  }
  return false;
}


/// llvm_execute_on_thread - Execute the given \p UserFn on a separate
/// thread, passing it the provided \p UserData and waits for thread
/// completion.
///
/// This function does not guarantee that the code will actually be executed
/// on a separate thread or honoring the requested stack size, but tries to do
/// so where system support is available.
///
/// \param UserFn - The callback to execute.
/// \param UserData - An argument to pass to the callback function.
/// \param RequestedStackSize - If non-zero, a requested size (in bytes) for
/// the thread stack.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_execute_on_thread">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", line = 45,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", old_line = 44,
 FQN="llvm::llvm_execute_on_thread", NM="_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j")
//</editor-fold>
public static void llvm_execute_on_thread(VoidPtr2Void Fn, Object/*void P*/ UserData) {
  llvm_execute_on_thread(Fn, UserData, 
                      0);
}
public static void llvm_execute_on_thread(VoidPtr2Void Fn, Object/*void P*/ UserData, 
                      /*uint*/int RequestedStackSize/*= 0*/) {
  try {
    if (true) {
      // need to start new thread to have thread locals work correctly
      final Thread thread = new Thread(()->Fn.$call(UserData));
      thread.start();
      thread.join();
      RequestedStackSize = RequestedStackSize; // stop point
    } else {
      Fn.$call(UserData);
    }
  } catch (InterruptedException ex) {
    NativeTrace.registerReason(ex);
  }
}


/// \brief Execute the function specified as a parameter once.
///
/// Typical usage:
/// \code
///   void foo() {...};
///   ...
///   LLVM_DEFINE_ONCE_FLAG(flag);
///   call_once(flag, foo);
/// \endcode
///
/// \param flag Flag used for tracking whether or not this has run.
/// \param F Function to call once.
/*template <typename Function, typename ... Args> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::call_once">
@Converted(kind = Converted.Kind.DUMMY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Threading.h", line = 91,
 FQN="llvm::call_once", NM="Tpl__ZN4llvm9call_onceERSt9once_flagOT_DpOT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=Tpl__ZN4llvm9call_onceERSt9once_flagOT_DpOT0_")
//</editor-fold>
public static </*typename*/ Function> void call_once(final std.once_flag /*&*/ flag, final Function /*&&*/F, Object /*&&*/...$ArgList) {
  throw new UnsupportedOperationException("Introduce specializations");
}
public static void call_once_Void2Void(final std.once_flag /*&*/ flag, final Void2Void /*&&*/F) {
  if (call_once$$.CALLED_ONCE.putIfAbsent(flag, call_once$$.CALLED) == null) {
    F.$call();
  }
}
public static <T> void call_once_Type2VoidPtr(final std.once_flag /*&*/ flag, final Type2VoidPtr<T> /*&&*/F, T/*void P*/Prm) {
  if (call_once$$.CALLED_ONCE.putIfAbsent(flag, call_once$$.CALLED) == null) {
    F.$call(Prm);
  }
}

private static final class call_once$$ {
  private static final ConcurrentMap<std.once_flag, Object> CALLED_ONCE = new ConcurrentHashMap<>();  
  private static final Boolean CALLED = Boolean.TRUE;
}

public static void java$shutdown() {
  call_once$$.CALLED_ONCE.clear();
}

} // END OF class ThreadingLlvmGlobals
