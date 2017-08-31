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

import org.clank.support.*;
import org.llvm.support.*;
import static org.llvm.support.impl.PrettyStackTraceStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type PrettyStackTraceLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm20SavePrettyStackStateEv;_ZN4llvm22EnablePrettyStackTraceEv;_ZN4llvm23RestorePrettyStackStateEPKv; -static-type=PrettyStackTraceLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class PrettyStackTraceLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::EnablePrettyStackTrace">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 163,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 149,
 FQN="llvm::EnablePrettyStackTrace", NM="_ZN4llvm22EnablePrettyStackTraceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm22EnablePrettyStackTraceEv")
//</editor-fold>
public static void EnablePrettyStackTrace() {
  // The first time this is called, we register the crash printer.
  final/*static*/ boolean HandlerRegistered = EnablePrettyStackTrace$$.HandlerRegistered;
  /*JAVA: (void)HandlerRegistered;*/
}
private static final class EnablePrettyStackTrace$$ {
  static final/*static*/ boolean HandlerRegistered = RegisterCrashPrinter();
}


/// Returns the topmost element of the "pretty" stack state.
//<editor-fold defaultstate="collapsed" desc="llvm::SavePrettyStackState">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 171,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 157,
 FQN="llvm::SavePrettyStackState", NM="_ZN4llvm20SavePrettyStackStateEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm20SavePrettyStackStateEv")
//</editor-fold>
public static /*const*/Object/*void P*/ SavePrettyStackState() {
  return PrettyStackTraceHead.$arrow().get();
}


/// Restores the topmost element of the "pretty" stack state to State, which
/// should come from a previous call to SavePrettyStackState().  This is
/// useful when using a CrashRecoveryContext in code that also uses
/// PrettyStackTraceEntries, to make sure the stack that's printed if a crash
/// happens after a crash that's been recovered by CrashRecoveryContext
/// doesn't have frames on it that were added in code unwound by the
/// CrashRecoveryContext.
//<editor-fold defaultstate="collapsed" desc="llvm::RestorePrettyStackState">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 179,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 165,
 FQN="llvm::RestorePrettyStackState", NM="_ZN4llvm23RestorePrettyStackStateEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm23RestorePrettyStackStateEPKv")
//</editor-fold>
public static void RestorePrettyStackState(/*const*/Object/*void P*/ Top) {
  PrettyStackTraceHead.$arrow().set(
     ((/*const*/PrettyStackTraceEntry)(((/*const_cast*/Object/*void P*/ )(Top))))
    );
}

} // END OF class PrettyStackTraceLlvmGlobals
