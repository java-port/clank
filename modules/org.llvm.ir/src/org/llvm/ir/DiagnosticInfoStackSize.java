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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoStackSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 208,
 FQN="llvm::DiagnosticInfoStackSize", NM="_ZN4llvm23DiagnosticInfoStackSizeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoStackSizeE")
//</editor-fold>
public class DiagnosticInfoStackSize extends /*public*/ DiagnosticInfoResourceLimit implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoStackSize::DiagnosticInfoStackSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 210,
   FQN="llvm::DiagnosticInfoStackSize::DiagnosticInfoStackSize", NM="_ZN4llvm23DiagnosticInfoStackSizeC1ERKNS_8FunctionEyNS_18DiagnosticSeverityEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoStackSizeC1ERKNS_8FunctionEyNS_18DiagnosticSeverityEy")
  //</editor-fold>
  public DiagnosticInfoStackSize(final /*const*/ Function /*&*/ Fn,
      long/*uint64_t*/ StackSize) {
    this(Fn,
      StackSize,
      DiagnosticSeverity.DS_Warning,
      $int2ulong(0));
  }
  public DiagnosticInfoStackSize(final /*const*/ Function /*&*/ Fn,
      long/*uint64_t*/ StackSize,
      DiagnosticSeverity Severity/*= DS_Warning*/) {
    this(Fn,
      StackSize,
      Severity,
      $int2ulong(0));
  }
  public DiagnosticInfoStackSize(final /*const*/ Function /*&*/ Fn,
      long/*uint64_t*/ StackSize,
      DiagnosticSeverity Severity/*= DS_Warning*/,
      long/*uint64_t*/ StackLimit/*= 0*/) {
    // : DiagnosticInfoResourceLimit(Fn, "stack size", StackSize, Severity, DK_StackSize, StackLimit)
    //START JInit
    super(Fn, $("stack size"), StackSize,
        Severity, DiagnosticKind.DK_StackSize, StackLimit);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoStackSize::getStackSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 217,
   FQN="llvm::DiagnosticInfoStackSize::getStackSize", NM="_ZNK4llvm23DiagnosticInfoStackSize12getStackSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm23DiagnosticInfoStackSize12getStackSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getStackSize() /*const*/ {
    return getResourceSize();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoStackSize::getStackLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 218,
   FQN="llvm::DiagnosticInfoStackSize::getStackLimit", NM="_ZNK4llvm23DiagnosticInfoStackSize13getStackLimitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm23DiagnosticInfoStackSize13getStackLimitEv")
  //</editor-fold>
  public long/*uint64_t*/ getStackLimit() /*const*/ {
    return getResourceLimit();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoStackSize::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 220,
   FQN="llvm::DiagnosticInfoStackSize::classof", NM="_ZN4llvm23DiagnosticInfoStackSize7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoStackSize7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_StackSize.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoStackSize::~DiagnosticInfoStackSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 208,
   FQN="llvm::DiagnosticInfoStackSize::~DiagnosticInfoStackSize", NM="_ZN4llvm23DiagnosticInfoStackSizeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoStackSizeD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
