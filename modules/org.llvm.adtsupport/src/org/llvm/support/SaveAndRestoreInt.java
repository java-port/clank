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
package org.llvm.support;

import org.clank.support.*;
import org.clank.support.aliases.*;

// SaveAndRestore - A utility class that uses RAII to save and restore
//  the value of a variable.
//<editor-fold defaultstate="collapsed" desc="llvm::SaveAndRestore">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/SaveAndRestore.h", line = 22,
 FQN = "llvm::SaveAndRestore", NM = "_ZN4llvm14SaveAndRestoreE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN4llvm14SaveAndRestoreE")
//</editor-fold>
public class/*struct*/ SaveAndRestoreInt implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::SaveAndRestore::SaveAndRestore<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/SaveAndRestore.h", line = 23,
   FQN = "llvm::SaveAndRestore::SaveAndRestore<T>", NM = "_ZN4llvm14SaveAndRestoreC1ERT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN4llvm14SaveAndRestoreC1ERT_")
  //</editor-fold>
  public SaveAndRestoreInt(int$ref /*&*/ x) {
    /* : X(x), old_value(x)*/ 
    //START JInit
    this.X = x;
    this.old_value = x.$deref();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SaveAndRestore::SaveAndRestore<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/SaveAndRestore.h", line = 24,
   FQN = "llvm::SaveAndRestore::SaveAndRestore<T>", NM = "_ZN4llvm14SaveAndRestoreC1ERT_RKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN4llvm14SaveAndRestoreC1ERT_RKS1_")
  //</editor-fold>
  public SaveAndRestoreInt(int$ref /*&*/ x, /*const*/ int /*&*/ new_value) {
    /* : X(x), old_value(x)*/ 
    //START JInit
    this.X = x;
    this.old_value = x.$deref();
    //END JInit
    X.$set(new_value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SaveAndRestore::~SaveAndRestore<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/SaveAndRestore.h", line = 27,
   FQN = "llvm::SaveAndRestore::~SaveAndRestore<T>", NM = "_ZN4llvm14SaveAndRestoreD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN4llvm14SaveAndRestoreD0Ev")
  //</editor-fold>
  public void $destroy() {
    X.$set(old_value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SaveAndRestore::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/SaveAndRestore.h", line = 28,
   FQN = "llvm::SaveAndRestore::get", NM = "_ZN4llvm14SaveAndRestore3getEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN4llvm14SaveAndRestore3getEv")
  //</editor-fold>
  public int get() {
    return old_value;
  }

/*private:*/
  private int$ref /*&*/ X;
  private int old_value;

  @Override
  public String toString() {
    return "oldVal = " + old_value + "; Ref=" + X.$deref();
  }
}
