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

import org.llvm.support.sys.sys;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.support.sys.ManagedStaticInfoImpl;


//<editor-fold defaultstate="collapsed" desc="static type PrettyStackTraceStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print -java-imports=${SPUTNIK}/modules/org.llvm.adtsupport/JavaImports ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -file-filter=${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp#31;${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp#33;${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp#47;${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp#76;${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp#138;${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp#149; -static-type=PrettyStackTraceStatics")
//</editor-fold>
public final class PrettyStackTraceStatics {
public static final ManagedStaticInfo<sys.ThreadLocal</*const*/PrettyStackTraceEntry> > StaticThreadLocalPrettyStackTraceEntry = new ManagedStaticInfoImpl<sys.ThreadLocal</*const*/PrettyStackTraceEntry> >() {

  @Override
  protected sys.ThreadLocal</*const*/PrettyStackTraceEntry>  create() {
    return new sys.ThreadLocal<>();
  }
};

//<editor-fold defaultstate="collapsed" desc="PrettyStackTraceHead">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 39,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 31,
 FQN = "PrettyStackTraceHead", NM = "_ZL20PrettyStackTraceHead",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZL20PrettyStackTraceHead")
//</editor-fold>
public static final ManagedStatic<sys.ThreadLocal</*const*/PrettyStackTraceEntry> > PrettyStackTraceHead/*J*/= new ManagedStatic<sys.ThreadLocal</*const*/PrettyStackTraceEntry> >(StaticThreadLocalPrettyStackTraceEntry);
//<editor-fold defaultstate="collapsed" desc="PrintStack">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 42,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 33,
 FQN = "PrintStack", NM = "_ZL10PrintStackPKN4llvm21PrettyStackTraceEntryERNS_11raw_ostreamE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZL10PrintStackPKN4llvm21PrettyStackTraceEntryERNS_11raw_ostreamE")
//</editor-fold>
public static /*uint*/int PrintStack(/*const*/PrettyStackTraceEntry /*P*/ Entry, raw_ostream /*&*/ OS) {
  /*uint*/int NextID = 0;
  if ((Entry.getNextEntry() != null)) {
    NextID = PrintStack(Entry.getNextEntry(), OS);
  }
  OS.$out_uint(NextID).$out(".\t");
  {
    sys.Watchdog W = null;
    try {
      W/*J*/= new sys.Watchdog(5);
      Entry.print(OS);
    } finally {
      if (W != null) { W.$destroy(); }
    }
  }
  
  return NextID + 1;
}


/// PrintCurStackTrace - Print the current stack trace to the specified stream.
//<editor-fold defaultstate="collapsed" desc="PrintCurStackTrace">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 56,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 47,
 FQN = "PrintCurStackTrace", NM = "_ZL18PrintCurStackTraceRN4llvm11raw_ostreamE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZL18PrintCurStackTraceRN4llvm11raw_ostreamE")
//</editor-fold>
public static void PrintCurStackTrace(raw_ostream /*&*/ OS) {
  // Don't print an empty trace.
  if (PrettyStackTraceHead.$arrow().get() == null) {
    return;
  }
  
  // If there are pretty stack frames registered, walk and emit them.
  OS.$out("Stack dump:\n");
  
  PrintStack(PrettyStackTraceHead.$arrow().get(), OS);
  OS.flush();
}


/// CrashHandler - This callback is run if a fatal signal is delivered to the
/// process, it prints the pretty stack trace.
//<editor-fold defaultstate="collapsed" desc="CrashHandler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 85,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 76,
 FQN = "CrashHandler", NM = "_ZL12CrashHandlerPv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZL12CrashHandlerPv")
//</editor-fold>
public static void CrashHandler(Object/*void P*/ $Prm0) {
  // On non-apple systems, just emit the crash stack trace to stderr.
  PrintCurStackTrace(errs());
}

//<editor-fold defaultstate="collapsed" desc="RegisterCrashPrinter">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 143,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 138,
 FQN = "RegisterCrashPrinter", NM = "_ZL20RegisterCrashPrinterv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZL20RegisterCrashPrinterv")
//</editor-fold>
public static boolean RegisterCrashPrinter() {
  sys.AddSignalHandler(PrettyStackTraceStatics::CrashHandler, null);
  return false;
}

//<editor-fold defaultstate="collapsed" desc="LLVMEnablePrettyStackTrace">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 149,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -filter=LLVMEnablePrettyStackTrace")
//</editor-fold>
public static void LLVMEnablePrettyStackTrace() {
  EnablePrettyStackTrace();
}

} // END OF class PrettyStackTraceStatics
