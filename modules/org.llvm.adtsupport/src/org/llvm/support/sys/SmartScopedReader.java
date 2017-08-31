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

package org.llvm.support.sys;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import org.llvm.cl.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.clank.java.stdimpl.aliases.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.adt.*;


/// ScopedReader - RAII acquisition of a reader lock
/*template <bool mt_only> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartScopedReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 146,
 FQN="llvm::sys::SmartScopedReader", NM="_ZN4llvm3sys17SmartScopedReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys17SmartScopedReaderE")
//</editor-fold>
public class/*struct*/ SmartScopedReader implements Destructors.ClassWithDestructor {
  /*template parameter*/ private final boolean mt_only;

  public final SmartRWMutex /*&*/ mutex;

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartScopedReader::SmartScopedReader<mt_only>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 150,
   FQN="llvm::sys::SmartScopedReader::SmartScopedReader<mt_only>", NM="_ZN4llvm3sys17SmartScopedReaderC1ERNS0_12SmartRWMutexIXT_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys17SmartScopedReaderC1ERNS0_12SmartRWMutexIXT_EEE")
  //</editor-fold>
  public /*explicit*/ SmartScopedReader(boolean mt_only, final SmartRWMutex /*&*/ m) {
    // : mutex(m)
    //START JInit
    /*template parameter*/ this.mt_only = mt_only;
    this./*&*/mutex=/*&*//*ParenListExpr*/m;
    //END JInit
    mutex.lock_shared();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartScopedReader::~SmartScopedReader<mt_only>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 154,
   FQN="llvm::sys::SmartScopedReader::~SmartScopedReader<mt_only>", NM="_ZN4llvm3sys17SmartScopedReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys17SmartScopedReaderD0Ev")
  //</editor-fold>
  public void $destroy() {
    mutex.unlock_shared();
  }


  @Override public String toString() {
    return "" + "mutex=" + mutex; // NOI18N
  }
}
