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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;


/// This is a helper class used for handling formatted output.  It is the
/// abstract base class of a templated derived class.
//<editor-fold defaultstate="collapsed" desc="llvm::format_object_base">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 37,
 FQN="llvm::format_object_base", NM="_ZN4llvm18format_object_baseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18format_object_baseE")
//</editor-fold>
public abstract class format_object_base implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*const*/char$ptr/*char P*/ Fmt;
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object_base::~format_object_base">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 40,
   FQN="llvm::format_object_base::~format_object_base", NM="_ZN4llvm18format_object_baseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18format_object_baseD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }
 // Disallow polymorphic deletion.

  //<editor-fold defaultstate="collapsed" desc="llvm::format_object_base::format_object_base">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 41,
   FQN="llvm::format_object_base::format_object_base", NM="_ZN4llvm18format_object_baseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18format_object_baseC1ERKS0_")
  //</editor-fold>
  protected format_object_base(final /*const*/ format_object_base /*&*/ $Prm0) {
    // : Fmt(.Fmt)/* = default*/ 
    //START JInit
    this.Fmt = $tryClone($Prm0.Fmt);
    //END JInit
  }

  
  //===----------------------------------------------------------------------===//
  //  Formatted Output
  //===----------------------------------------------------------------------===//
  
  // Out of line virtual method.
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object_base::home">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 484,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 487,
   FQN="llvm::format_object_base::home", NM="_ZN4llvm18format_object_base4homeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18format_object_base4homeEv")
  //</editor-fold>
  protected void home() {
  }
 // Out of line virtual method.
  
  /// Call snprintf() for this object, on the given buffer and size.
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object_base::snprint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 45,
   FQN="llvm::format_object_base::snprint", NM="_ZNK4llvm18format_object_base7snprintEPcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm18format_object_base7snprintEPcj")
  //</editor-fold>
  protected abstract /*virtual*/ int snprint(char$ptr/*char P*/ Buffer, /*uint*/int BufferSize) /*const*//* = 0*/;

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object_base::format_object_base">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 48,
   FQN="llvm::format_object_base::format_object_base", NM="_ZN4llvm18format_object_baseC1EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm18format_object_baseC1EPKc")
  //</editor-fold>
  public format_object_base(/*const*/char$ptr/*char P*/ fmt) {
    // : Fmt(fmt) 
    //START JInit
    this.Fmt = $tryClone(fmt);
    //END JInit
  }

  
  /// Format the object into the specified buffer.  On success, this returns
  /// the length of the formatted string.  If the buffer is too small, this
  /// returns a length to retry with, which will be larger than BufferSize.
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object_base::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 53,
   FQN="llvm::format_object_base::print", NM="_ZNK4llvm18format_object_base5printEPcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm18format_object_base5printEPcj")
  //</editor-fold>
  public /*uint*/int print(char$ptr/*char P*/ Buffer, /*uint*/int BufferSize) /*const*/ {
    assert ((BufferSize != 0)) : "Invalid buffer size!";
    
    // Print the string, leaving room for the terminating null.
    int N = snprint(Buffer, BufferSize);
    
    // VC++ and old GlibC return negative on overflow, just double the size.
    if (N < 0) {
      return BufferSize * 2;
    }
    
    // Other implementations yield number of bytes needed, not including the
    // final '\0'.
    if ($greatereq_uint(((/*uint*/int)(N)), BufferSize)) {
      return N + 1;
    }
    
    // Otherwise N is the length of output (not including the final '\0').
    return N;
  }

  
  @Override public String toString() {
    return "" + "Fmt=" + Fmt; // NOI18N
  }
}
