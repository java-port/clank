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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LineConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 478,
 FQN="(anonymous namespace)::LineConsumer", NM="_ZN12_GLOBAL__N_112LineConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_112LineConsumerE")
//</editor-fold>
public class LineConsumer implements Destructors.ClassWithDestructor {
  private std.unique_ptr<MemoryBuffer> Buffer;
  private StringRef Remaining;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LineConsumer::LineConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 483,
   FQN="(anonymous namespace)::LineConsumer::LineConsumer", NM="_ZN12_GLOBAL__N_112LineConsumerC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_112LineConsumerC1EN4llvm9StringRefE")
  //</editor-fold>
  public LineConsumer(StringRef Filename) {
    // : Buffer(), Remaining() 
    //START JInit
    this.Buffer = new std.unique_ptr<MemoryBuffer>();
    this.Remaining = new StringRef();
    //END JInit
    ErrorOr<std.unique_ptr<MemoryBuffer> > BufferOrErr = null;
    try {
      BufferOrErr = MemoryBuffer.getFileOrSTDIN(new Twine(Filename));
      {
        std.error_code EC = BufferOrErr.getError();
        if (EC.$bool()) {
          errs().$out(/*NO_COPY*/Filename).$out(/*KEEP_STR*/": ").$out(EC.message()).$out(/*KEEP_STR*/$LF);
          Remaining.$assignMove(/*STRINGREF_STR*/$EMPTY);
        } else {
          Buffer.$assignMove(std.move(BufferOrErr.get()));
          Remaining.$assignMove(Buffer.$arrow().getBuffer());
        }
      }
    } finally {
      if (BufferOrErr != null) { BufferOrErr.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LineConsumer::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 494,
   FQN="(anonymous namespace)::LineConsumer::empty", NM="_ZN12_GLOBAL__N_112LineConsumer5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_112LineConsumer5emptyEv")
  //</editor-fold>
  public boolean empty() {
    return Remaining.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LineConsumer::printNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 495,
   FQN="(anonymous namespace)::LineConsumer::printNext", NM="_ZN12_GLOBAL__N_112LineConsumer9printNextERN4llvm11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_112LineConsumer9printNextERN4llvm11raw_ostreamEj")
  //</editor-fold>
  public void printNext(final raw_ostream /*&*/ OS, /*uint32_t*/int LineNum) {
    StringRef Line/*J*/= new StringRef();
    if (empty()) {
      Line.$assignMove(/*STRINGREF_STR*/"/*EOF*/");
    } else {
      std.tie(Line, Remaining).$assign(Remaining.split(/*STRINGREF_STR*/"\n"));
    }
    OS.$out(format_uint(/*KEEP_STR*/"%5u:", LineNum)).$out(/*NO_COPY*/Line).$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LineConsumer::LineConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 478,
   FQN="(anonymous namespace)::LineConsumer::LineConsumer", NM="_ZN12_GLOBAL__N_112LineConsumerC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_112LineConsumerC1EOS0_")
  //</editor-fold>
  public /*inline*/ LineConsumer(JD$Move _dparam, final LineConsumer /*&&*/$Prm0) {
    // : Buffer(static_cast<LineConsumer &&>().Buffer), Remaining(static_cast<LineConsumer &&>().Remaining) 
    //START JInit
    this.Buffer = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, $Prm0.Buffer);
    this.Remaining = new StringRef(JD$Move.INSTANCE, $Prm0.Remaining);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LineConsumer::~LineConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 478,
   FQN="(anonymous namespace)::LineConsumer::~LineConsumer", NM="_ZN12_GLOBAL__N_112LineConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_112LineConsumerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Buffer.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Buffer=" + Buffer // NOI18N
              + ", Remaining=" + Remaining; // NOI18N
  }
}
