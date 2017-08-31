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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// \brief Interface for custom diagnostic printing.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 31,
 FQN="llvm::DiagnosticPrinter", NM="_ZN4llvm17DiagnosticPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterE")
//</editor-fold>
public abstract class DiagnosticPrinter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::~DiagnosticPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 33,
   FQN="llvm::DiagnosticPrinter::~DiagnosticPrinter", NM="_ZN4llvm17DiagnosticPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }


  // Simple types.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 36,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEc")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_char(/*char*/byte C)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 37,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEh")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_uchar(/*uchar*/byte C)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 38,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEa",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEa")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_schar(/*schar*/byte C)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 39,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsENS_9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(StringRef Str)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 40,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEPKc")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(/*const*/char$ptr/*char P*/ Str)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 41,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsERKSs")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(final /*const*/std.string/*&*/ Str)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 42,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEm",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEm")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_ulong(/*ulong*/long N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 43,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEl",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEl")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_long(long N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 44,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEy")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_ullong(/*ullong*/long N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 45,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEx")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_llong(/*llong*/long N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 46,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEPKv")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(/*const*/Object/*void P*/ P)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 47,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEj")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_uint(/*uint*/int N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 48,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEi")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out_int(int N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 49,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsEd")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(double N)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 50,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsERKNS_5TwineE")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(final /*const*/ Twine /*&*/ Str)/* = 0*/;


  // IR related types.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 53,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsERKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsERKNS_5ValueE")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(final /*const*/ Value /*&*/ V)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 54,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsERKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsERKNS_6ModuleE")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(final /*const*/ Module /*&*/ M)/* = 0*/;


  // Other types.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 57,
   FQN="llvm::DiagnosticPrinter::operator<<", NM="_ZN4llvm17DiagnosticPrinterlsERKNS_12SMDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterlsERKNS_12SMDiagnosticE")
  //</editor-fold>
  public abstract /*virtual*/ DiagnosticPrinter /*&*/ $out(final /*const*/ SMDiagnostic /*&*/ Diag)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinter::DiagnosticPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 31,
   FQN="llvm::DiagnosticPrinter::DiagnosticPrinter", NM="_ZN4llvm17DiagnosticPrinterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm17DiagnosticPrinterC1Ev")
  //</editor-fold>
  public /*inline*/ DiagnosticPrinter() {
  }


  @Override public String toString() {
    return ""; // NOI18N
  }
}
