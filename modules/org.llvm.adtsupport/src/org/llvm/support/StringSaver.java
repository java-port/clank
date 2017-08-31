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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// \brief Saves strings in the inheritor's stable storage and returns a stable
/// raw character pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::StringSaver">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/StringSaver.h", line = 21,
 FQN="llvm::StringSaver", NM="_ZN4llvm11StringSaverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp -nm=_ZN4llvm11StringSaverE")
//</editor-fold>
public final class StringSaver {
  private BumpPtrAllocatorImpl /*&*/ Alloc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSaver::StringSaver">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/StringSaver.h", line = 25,
   FQN="llvm::StringSaver::StringSaver", NM="_ZN4llvm11StringSaverC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp -nm=_ZN4llvm11StringSaverC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public StringSaver(BumpPtrAllocatorImpl /*&*/ Alloc) {
    /* : Alloc(Alloc)*/ 
    //START JInit
    this./*&*/Alloc=/*&*/Alloc;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringSaver::save">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/StringSaver.h", line = 26,
   FQN="llvm::StringSaver::save", NM="_ZN4llvm11StringSaver4saveEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp -nm=_ZN4llvm11StringSaver4saveEPKc")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ save(/*const*/char$ptr/*char P*/ S) {
    return save(new StringRef(S));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringSaver::save">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp", line = 14,
   FQN="llvm::StringSaver::save", NM="_ZN4llvm11StringSaver4saveENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp -nm=_ZN4llvm11StringSaver4saveENS_9StringRefE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ save(StringRef S) {
    char$ptr/*char P*/ P = $tryClone(Alloc.Allocate(S.size() + 1));
    memcpy(P, S.data(), S.size());
    P.$set(S.size(), $$TERM);
    return P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringSaver::save">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/StringSaver.h", line = 28,
   FQN="llvm::StringSaver::save", NM="_ZN4llvm11StringSaver4saveERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp -nm=_ZN4llvm11StringSaver4saveERKNS_5TwineE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ save(/*const*/ Twine /*&*/ S) {
    return save(new StringRef(S.str()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringSaver::save">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/StringSaver.h", line = 29,
   FQN="llvm::StringSaver::save", NM="_ZN4llvm11StringSaver4saveERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringSaver.cpp -nm=_ZN4llvm11StringSaver4saveERSs")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ save(std.string/*&*/ S) {
    return save(new StringRef(S));
  }

  
  public String toString() {
    return "" + "Alloc=" + Alloc; // NOI18N
  }
}
