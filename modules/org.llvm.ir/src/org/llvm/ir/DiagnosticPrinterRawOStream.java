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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// \brief Basic diagnostic printer that uses an underlying raw_ostream.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 61,
 FQN="llvm::DiagnosticPrinterRawOStream", NM="_ZN4llvm27DiagnosticPrinterRawOStreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamE")
//</editor-fold>
public class DiagnosticPrinterRawOStream extends /*public*/ DiagnosticPrinter implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final raw_ostream /*&*/ Stream;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::DiagnosticPrinterRawOStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 66,
   FQN="llvm::DiagnosticPrinterRawOStream::DiagnosticPrinterRawOStream", NM="_ZN4llvm27DiagnosticPrinterRawOStreamC1ERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamC1ERNS_11raw_ostreamE")
  //</editor-fold>
  public DiagnosticPrinterRawOStream(final raw_ostream /*&*/ Stream) {
    // : DiagnosticPrinter(), Stream(Stream)
    //START JInit
    super();
    this./*&*/Stream=/*&*/Stream;
    //END JInit
  }


  // Simple types.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 23,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEc")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_char(/*char*/byte C)/* override*/ {
    Stream.$out_char(C);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 28,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEh")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_uchar(/*uchar*/byte C)/* override*/ {
    Stream.$out_uchar(C);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 33,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEa",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEa")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_schar(/*schar*/byte C)/* override*/ {
    Stream.$out_schar(C);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 38,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsENS_9StringRefE")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(StringRef Str)/* override*/ {
    Stream.$out(/*NO_COPY*/Str);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 43,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEPKc")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(/*const*/char$ptr/*char P*/ Str)/* override*/ {
    Stream.$out(Str);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 48,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsERKSs")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(final /*const*/std.string/*&*/ Str)/* override*/ {
    Stream.$out(Str);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 54,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEm",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEm")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_ulong(/*ulong*/long N)/* override*/ {
    Stream.$out_ulong(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 58,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEl",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEl")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_long(long N)/* override*/ {
    Stream.$out_long(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 63,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEy")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_ullong(/*ullong*/long N)/* override*/ {
    Stream.$out_ullong(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 69,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEx")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_llong(/*llong*/long N)/* override*/ {
    Stream.$out_llong(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 74,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEPKv")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(/*const*/Object/*void P*/ P)/* override*/ {
    Stream.$out(P);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 79,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEj")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_uint(/*uint*/int N)/* override*/ {
    Stream.$out_uint(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 84,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEi")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out_int(int N)/* override*/ {
    Stream.$out_int(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 89,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsEd")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(double N)/* override*/ {
    Stream.$out_double(N);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 94,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_5TwineE")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(final /*const*/ Twine /*&*/ Str)/* override*/ {
    Str.print(Stream);
    return /*Deref*/this;
  }


  // IR related types.

  // IR related types.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 100,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_5ValueE")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(final /*const*/ Value /*&*/ V)/* override*/ {
    Stream.$out(V.getName());
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 105,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_6ModuleE")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(final /*const*/ Module /*&*/ M)/* override*/ {
    Stream.$out(M.getModuleIdentifier());
    return /*Deref*/this;
  }


  // Other types.

  // Other types.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp", line = 111,
   FQN="llvm::DiagnosticPrinterRawOStream::operator<<", NM="_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_12SMDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamlsERKNS_12SMDiagnosticE")
  //</editor-fold>
  @Override public DiagnosticPrinter /*&*/ $out(final /*const*/ SMDiagnostic /*&*/ Diag)/* override*/ {
    // We don't have to print the SMDiagnostic kind, as the diagnostic severity
    // is printed by the diagnostic handler.
    Diag.print($EMPTY, Stream, /*ShowColors=*/ true, /*ShowKindLabel=*/ false);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticPrinterRawOStream::~DiagnosticPrinterRawOStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticPrinter.h", line = 61,
   FQN="llvm::DiagnosticPrinterRawOStream::~DiagnosticPrinterRawOStream", NM="_ZN4llvm27DiagnosticPrinterRawOStreamD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticPrinter.cpp -nm=_ZN4llvm27DiagnosticPrinterRawOStreamD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "Stream=" + Stream // NOI18N
              + super.toString(); // NOI18N
  }
}
