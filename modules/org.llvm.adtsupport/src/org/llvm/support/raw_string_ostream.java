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
import org.llvm.support.*;


/// raw_string_ostream - A raw_ostream that writes to an std::string.  This is a
/// simple adaptor class. This class does not encounter output errors.
//<editor-fold defaultstate="collapsed" desc="llvm::raw_string_ostream">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 450,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 440,
 FQN = "llvm::raw_string_ostream", NM = "_ZN4llvm18raw_string_ostreamE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18raw_string_ostreamE")
//</editor-fold>
public class raw_string_ostream extends /*public*/ raw_ostream implements Destructors.ClassWithDestructor {
  private std.string /*&*/ OS;
  
  /// write_impl - See raw_ostream::write_impl.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_string_ostream::write_impl">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 753,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 735,
   FQN = "llvm::raw_string_ostream::write_impl", NM = "_ZN4llvm18raw_string_ostream10write_implEPKcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18raw_string_ostream10write_implEPKcj")
  //</editor-fold>
  @Override protected/*private*/ void write_impl(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    OS.append(Ptr, PtrIdx, Size);
  }
  @Override protected void write_impl(byte[] Ptr, int PtrIdx, int Size) {
    OS.append(Ptr, PtrIdx, Size);
  }

  /// current_pos - Return the current position within the stream, not
  /// counting the bytes currently in the buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_string_ostream::current_pos">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 458,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 448,
   FQN = "llvm::raw_string_ostream::current_pos", NM = "_ZNK4llvm18raw_string_ostream11current_posEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm18raw_string_ostream11current_posEv")
  //</editor-fold>
  @Override protected/*private*/ /*virtual*/ long/*uint64_t*/ current_pos() /*const*/ {
    return OS.size();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_string_ostream::raw_string_ostream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 450,
   FQN = "llvm::raw_string_ostream::raw_string_ostream", NM = "_ZN4llvm18raw_string_ostreamC1ERSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18raw_string_ostreamC1ERSs")
  //</editor-fold>
  public /*explicit*/ raw_string_ostream(std.string /*&*/ str) {
    /* : raw_ostream(), OS(O)*/ 
    //START JInit
    super();
    this.OS = str;
    //END JInit
  }

  
  //===----------------------------------------------------------------------===//
  //  raw_string_ostream
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_string_ostream::~raw_string_ostream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 749,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 731,
   FQN = "llvm::raw_string_ostream::~raw_string_ostream", NM = "_ZN4llvm18raw_string_ostreamD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18raw_string_ostreamD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    flush();
    // must be the last
    super.$destroy();
  }

  
  /// str - Flushes the stream contents to the target string and returns
  ///  the string's reference.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_string_ostream::str">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 455,
   FQN = "llvm::raw_string_ostream::str", NM = "_ZN4llvm18raw_string_ostream3strEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18raw_string_ostream3strEv")
  //</editor-fold>
  public std.string /*&*/ str() {
    flush();
    return OS;
  }

}
