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
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// A raw_ostream that writes to an SmallVector or SmallString.  This is a
/// simple adaptor class. This class does not encounter output errors.
/// raw_svector_ostream operates without a buffer, delegating all memory
/// management to the SmallString. Thus the SmallString is always up-to-date,
/// may be used directly and there is no need to call flush().
//<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 477,
 FQN="llvm::raw_svector_ostream", NM="_ZN4llvm19raw_svector_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostreamE")
//</editor-fold>
public class raw_svector_ostream extends /*public*/ raw_pwrite_stream implements Destructors.ClassWithDestructor {
  private final SmallString/*&*/ OS;
  
  /// See raw_ostream::write_impl.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::write_impl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 762,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 763,
   FQN="llvm::raw_svector_ostream::write_impl", NM="_ZN4llvm19raw_svector_ostream10write_implEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostream10write_implEPKcj")
  //</editor-fold>
  @Override protected/*private*/ void write_impl(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size)/* override*/ {
    OS.append(Ptr, PtrIdx, Size);
  }
  @Override protected/*private*/ void write_impl(/*const*/byte[]/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    OS.append(Ptr, PtrIdx, Size);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::pwrite_impl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 766,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 767,
   FQN="llvm::raw_svector_ostream::pwrite_impl", NM="_ZN4llvm19raw_svector_ostream11pwrite_implEPKcjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostream11pwrite_implEPKcjy")
  //</editor-fold>
  @Override protected/*private*/ void pwrite_impl(/*const*/char$ptr/*char P*/ Ptr, /*size_t*/int Size, 
             long/*uint64_t*/ Offset)/* override*/ {
    memcpy(OS.data(), ((int) Offset), Ptr, 0, Size);
  }

  
  /// Return the current position within the stream.
  
  //===----------------------------------------------------------------------===//
  //  raw_svector_ostream
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::current_pos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 760,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 761,
   FQN="llvm::raw_svector_ostream::current_pos", NM="_ZNK4llvm19raw_svector_ostream11current_posEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm19raw_svector_ostream11current_posEv")
  //</editor-fold>
  @Override protected/*private*/ long/*uint64_t*/ current_pos() /*const*//* override*/ {
    return $uint2ulong(OS.size());
  }

/*public:*/
  /// Construct a new raw_svector_ostream.
  ///
  /// \param O The vector to write to; this should generally have at least 128
  /// bytes free to avoid any extraneous memory overhead.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::raw_svector_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 493,
   FQN="llvm::raw_svector_ostream::raw_svector_ostream", NM="_ZN4llvm19raw_svector_ostreamC1ERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostreamC1ERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public /*explicit*/ raw_svector_ostream(final SmallString/*&*/ O) {
    // : raw_pwrite_stream(), OS(O) 
    //START JInit
    super();
    this./*&*/OS=/*&*/O;
    //END JInit
    SetUnbuffered();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::~raw_svector_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 496,
   FQN="llvm::raw_svector_ostream::~raw_svector_ostream", NM="_ZN4llvm19raw_svector_ostreamD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostreamD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::flush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 498,
   FQN="llvm::raw_svector_ostream::flush", NM="_ZN4llvm19raw_svector_ostream5flushEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostream5flushEv")
  //</editor-fold>
  public final void flush$raw_svector_ostream() { throw new UnsupportedOperationException("Deleted");}
  
  
  /// Return a StringRef for the vector contents.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_svector_ostream::str">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 501,
   FQN="llvm::raw_svector_ostream::str", NM="_ZN4llvm19raw_svector_ostream3strEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm19raw_svector_ostream3strEv")
  //</editor-fold>
  public StringRef str() {
    return new StringRef(OS.data(), OS.size());
  }

  // JAVA: to implement constructor at least in buffer_ostream
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected final SmallString $Buffer() { return OS; }
  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + super.toString(); // NOI18N
  }  
}
