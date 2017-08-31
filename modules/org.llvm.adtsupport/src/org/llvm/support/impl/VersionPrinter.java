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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import static org.llvm.support.impl.CommandLineStatics.*;

//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VersionPrinter">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1736,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1735,
 FQN = "(anonymous namespace)::VersionPrinter", NM = "_ZN12_GLOBAL__N_114VersionPrinterE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_114VersionPrinterE")
//</editor-fold>
public class VersionPrinter {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VersionPrinter::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1738,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1737,
   FQN = "(anonymous namespace)::VersionPrinter::print", NM = "_ZN12_GLOBAL__N_114VersionPrinter5printEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_114VersionPrinter5printEv")
  //</editor-fold>
  public void print() {
    raw_ostream /*&*/ OS = outs();
    OS.$out($("LLVM (http://llvm.org/):\n")).$out($("  ")).$out($("LLVM")).$out($(" version ")).$out($("3.6.0"));
    OS.$out($("\n  "));
    OS.$out($("DEBUG build"));
    OS.$out($(" with assertions"));
    std.string CPU = sys.getHostCPUName().$string();
    if ($eq_str_T(CPU, $("generic"))) {
      CPU.$assign($("(unknown)"));
    }
    OS.$out($(".\n")).$out($("  Built ")).$out($("Apr 30 2015")).$out($(" (")).$out($("13:32:50")).$out($(").\n")).$out($("  Default target: ")).$out(sys.getDefaultTargetTriple()).$out_char($('\n')).$out($("  Host CPU: ")).$out(CPU).$out_char($('\n'));
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VersionPrinter::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1736,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1735,
   FQN = "(anonymous namespace)::VersionPrinter::operator=", NM = "_ZN12_GLOBAL__N_114VersionPrinteraSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_114VersionPrinteraSERKS0_")
  //</editor-fold>
  public /*inline*/ VersionPrinter /*&*/ $assign(/*const*/ VersionPrinter /*&*/ $Prm0) {
    /*<<<default assign operator>>>*/
    // memcpy(this, $1, sizeof($1));
    NativeTrace.traceNotImplemented(getClass().getName() + ".$assign");
    return $Prm0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VersionPrinter::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1764,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1763,
   FQN = "(anonymous namespace)::VersionPrinter::operator=", NM = "_ZN12_GLOBAL__N_114VersionPrinteraSEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_114VersionPrinteraSEb")
  //</editor-fold>
  public void $assign(boolean OptionWasSpecified) {
    if (!OptionWasSpecified) {
      return;
    }
    if (OverrideVersionPrinter != null) {
      OverrideVersionPrinter.$call();
      exit(0);
    }
    print();

    // Iterate over any registered extra printers and call them to add further
    // information.
    if (ExtraVersionPrinters != null) {
      outs().$out_char($('\n'));
      for (std.vector.iterator<Void2Void> I = ExtraVersionPrinters.begin(), 
          E = ExtraVersionPrinters.end();
           $noteq___normal_iterator(I, E); I.$preInc())  {
        (I.$star()).$call();
      }
    }

    exit(0);
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VersionPrinter::VersionPrinter">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1736,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1735,
   FQN = "(anonymous namespace)::VersionPrinter::VersionPrinter", NM = "_ZN12_GLOBAL__N_114VersionPrinterC1EOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_114VersionPrinterC1EOS0_")
  //</editor-fold>
  public /*inline*/ VersionPrinter() {
  }

}
