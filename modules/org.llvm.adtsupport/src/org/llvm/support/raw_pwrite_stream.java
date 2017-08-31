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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


/// An abstract base class for streams implementations that also support a
/// pwrite operation. This is useful for code that can mostly stream out data,
/// but needs to patch in a header that needs to know the output size.
//<editor-fold defaultstate="collapsed" desc="llvm::raw_pwrite_stream">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 320,
 FQN="llvm::raw_pwrite_stream", NM="_ZN4llvm17raw_pwrite_streamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm17raw_pwrite_streamE")
//</editor-fold>
public abstract class raw_pwrite_stream extends /*public*/ raw_ostream implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_pwrite_stream::pwrite_impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 321,
   FQN="llvm::raw_pwrite_stream::pwrite_impl", NM="_ZN4llvm17raw_pwrite_stream11pwrite_implEPKcjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm17raw_pwrite_stream11pwrite_implEPKcjy")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ void pwrite_impl(/*const*/char$ptr/*char P*/ Ptr, /*size_t*/int Size, long/*uint64_t*/ Offset)/* = 0*/;

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_pwrite_stream::raw_pwrite_stream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 324,
   FQN="llvm::raw_pwrite_stream::raw_pwrite_stream", NM="_ZN4llvm17raw_pwrite_streamC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm17raw_pwrite_streamC1Eb")
  //</editor-fold>
  public /*explicit*/ raw_pwrite_stream() {
    this(false);
  }
  public /*explicit*/ raw_pwrite_stream(boolean Unbuffered/*= false*/) {
    /* : raw_ostream(Unbuffered)*/ 
    //START JInit
    super(Unbuffered);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_pwrite_stream::pwrite">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 326,
   FQN="llvm::raw_pwrite_stream::pwrite", NM="_ZN4llvm17raw_pwrite_stream6pwriteEPKcjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm17raw_pwrite_stream6pwriteEPKcjy")
  //</editor-fold>
  public void pwrite(/*const*/char$ptr/*char P*/ Ptr, /*size_t*/int Size, long/*uint64_t*/ Offset) {
    long/*uint64_t*/ Pos = tell();
    // /dev/null always reports a pos of 0, so we cannot perform this check
    // in that case.
    if ((Pos != 0)) {
      assert ($lesseq_ullong_ulong($uint2ullong(Size) + Offset, Pos)) : "We don't support extending the stream";
    }
    pwrite_impl(Ptr, Size, Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_pwrite_stream::~raw_pwrite_stream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 320,
   FQN="llvm::raw_pwrite_stream::~raw_pwrite_stream", NM="_ZN4llvm17raw_pwrite_streamD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm17raw_pwrite_streamD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
