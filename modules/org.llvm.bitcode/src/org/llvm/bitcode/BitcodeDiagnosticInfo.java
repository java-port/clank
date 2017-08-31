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

package org.llvm.bitcode;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.Twine;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::BitcodeDiagnosticInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 191,
 FQN="llvm::BitcodeDiagnosticInfo", NM="_ZN4llvm21BitcodeDiagnosticInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm21BitcodeDiagnosticInfoE")
//</editor-fold>
public class BitcodeDiagnosticInfo extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
  private final /*const*/ Twine /*&*/ Msg;
  private std.error_code EC;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeDiagnosticInfo::BitcodeDiagnosticInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 550,
   FQN="llvm::BitcodeDiagnosticInfo::BitcodeDiagnosticInfo", NM="_ZN4llvm21BitcodeDiagnosticInfoC1ESt10error_codeNS_18DiagnosticSeverityERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm21BitcodeDiagnosticInfoC1ESt10error_codeNS_18DiagnosticSeverityERKNS_5TwineE")
  //</editor-fold>
  public BitcodeDiagnosticInfo(std.error_code EC, 
      DiagnosticSeverity Severity, 
      final /*const*/ Twine /*&*/ Msg) {
    // : DiagnosticInfo(DK_Bitcode, Severity), Msg(Msg), EC(EC) 
    //START JInit
    super(DiagnosticKind.DK_Bitcode.getValue(), Severity);
    this./*&*/Msg=/*&*/Msg;
    this.EC = new std.error_code(EC);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeDiagnosticInfo::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 555,
   FQN="llvm::BitcodeDiagnosticInfo::print", NM="_ZNK4llvm21BitcodeDiagnosticInfo5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm21BitcodeDiagnosticInfo5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    DP.$out(Msg);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeDiagnosticInfo::getError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 199,
   FQN="llvm::BitcodeDiagnosticInfo::getError", NM="_ZNK4llvm21BitcodeDiagnosticInfo8getErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm21BitcodeDiagnosticInfo8getErrorEv")
  //</editor-fold>
  public std.error_code getError() /*const*/ {
    return new std.error_code(EC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeDiagnosticInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 201,
   FQN="llvm::BitcodeDiagnosticInfo::classof", NM="_ZN4llvm21BitcodeDiagnosticInfo7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm21BitcodeDiagnosticInfo7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_Bitcode.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitcodeDiagnosticInfo::~BitcodeDiagnosticInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 191,
   FQN="llvm::BitcodeDiagnosticInfo::~BitcodeDiagnosticInfo", NM="_ZN4llvm21BitcodeDiagnosticInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm21BitcodeDiagnosticInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Msg=" + Msg // NOI18N
              + ", EC=" + EC // NOI18N
              + super.toString(); // NOI18N
  }
}
