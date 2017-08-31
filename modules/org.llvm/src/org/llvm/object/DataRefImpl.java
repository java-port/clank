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

package org.llvm.object;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="llvm::object::DataRefImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 24,
 FQN="llvm::object::DataRefImpl", NM="_ZN4llvm6object11DataRefImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object11DataRefImplE")
//</editor-fold>
public class/*union*/ DataRefImpl {
  // This entire union should probably be a
  // char[max(8, sizeof(uintptr_t))] and require the impl to cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::DataRefImpl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 27,
   FQN="llvm::object::DataRefImpl::(anonymous)", NM="_ZN4llvm6object11DataRefImplE_Unnamed_struct1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object11DataRefImplE_Unnamed_struct1")
  //</editor-fold>
  public static class/*struct*/ Unnamed_struct1 {
    public /*uint32_t*/int a;
    public /*uint32_t*/int b;
    
    @Override public String toString() {
      return "" + "a=" + a // NOI18N
                + ", b=" + b; // NOI18N
    }
  };
  public Unnamed_struct1 d = new Unnamed_struct1();
  public Object/*uintptr_t*/ p;
  //<editor-fold defaultstate="collapsed" desc="llvm::object::DataRefImpl::DataRefImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 31,
   FQN="llvm::object::DataRefImpl::DataRefImpl", NM="_ZN4llvm6object11DataRefImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object11DataRefImplC1Ev")
  //</editor-fold>
  public DataRefImpl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::DataRefImpl::DataRefImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 24,
   FQN="llvm::object::DataRefImpl::DataRefImpl", NM="_ZN4llvm6object11DataRefImplC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object11DataRefImplC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DataRefImpl(final /*const*/ DataRefImpl /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::DataRefImpl::DataRefImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 24,
   FQN="llvm::object::DataRefImpl::DataRefImpl", NM="_ZN4llvm6object11DataRefImplC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object11DataRefImplC1EOS1_")
  //</editor-fold>
  public /*inline*/ DataRefImpl(JD$Move _dparam, final DataRefImpl /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "d=" + d // NOI18N
              + ", p=" + p; // NOI18N
  }
}
