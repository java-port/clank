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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.ADTFunctionPointers.fatal_error_handler_t;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type ErrorHandlingStatics">
@Converted(kind = Converted.Kind.AUTO, cmd = "jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZL12ErrorHandler;_ZL20ErrorHandlerUserData;_ZL17ErrorHandlerMutex;_ZL20bindingsErrorHandlerPvRKSsb; -static-type=ErrorHandlingStatics")
//</editor-fold>
public final class ErrorHandlingStatics {
  
  public static final ManagedStaticInfo<sys.Mutex> MutexManagedStaticInfo = new ManagedStaticInfoImpl<sys.Mutex>() {

    @Override
    protected sys.Mutex create() {
      return new sys.Mutex();
    }
  };
  

//<editor-fold defaultstate="collapsed" desc="ErrorHandler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 42,
 FQN = "ErrorHandler", NM = "_ZL12ErrorHandler",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZL12ErrorHandler")
//</editor-fold>
public static fatal_error_handler_t ErrorHandler = null;
//<editor-fold defaultstate="collapsed" desc="ErrorHandlerUserData">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 43,
 FQN = "ErrorHandlerUserData", NM = "_ZL20ErrorHandlerUserData",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZL20ErrorHandlerUserData")
//</editor-fold>
public static Object/*void P*/ ErrorHandlerUserData = null;
//<editor-fold defaultstate="collapsed" desc="ErrorHandlerMutex">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 45,
 FQN = "ErrorHandlerMutex", NM = "_ZL17ErrorHandlerMutex",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZL17ErrorHandlerMutex")
//</editor-fold>
public static ManagedStatic<sys.Mutex> ErrorHandlerMutex/*J*/= new ManagedStatic<sys.Mutex>(MutexManagedStaticInfo);
//<editor-fold defaultstate="collapsed" desc="bindingsErrorHandler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 125,
 FQN = "bindingsErrorHandler", NM = "_ZL20bindingsErrorHandlerPvRKSsb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZL20bindingsErrorHandlerPvRKSsb")
//</editor-fold>
public static void bindingsErrorHandler(void$ptr/*void P*/ user_data, /*const*/std.string/*&*/ reason, 
                    boolean gen_crash_diag) {
  ConstCharPtr2Void handler = (ConstCharPtr2Void)user_data;
  handler.$call(reason.c_str());
}

} // END OF class ErrorHandlingStatics
