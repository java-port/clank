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

package org.llvm.adt;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/*template <typename T> TEMPLATE*/

/// MutableArrayRefChar - Represent a mutable reference to an array (0 or more
/// elements consecutively in memory), i.e. a start pointer and a length.  It
/// allows various APIs to take and modify consecutive elements easily and
/// conveniently.
///
/// This class does not own the underlying data, it is expected to be used in
/// situations where the data resides in some other buffer, whose lifetime
/// extends past that of the MutableArrayRefChar. For this reason, it is not in
/// general safe to store a MutableArrayRefChar.
///
/// This is intended to be trivially copyable, so it should be passed by
/// value.
//<editor-fold defaultstate="collapsed" desc="llvm::MutableArrayRefChar">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 226)
//</editor-fold>
public class MutableArrayRefChar  extends /*public*/ ArrayRefChar {
  private static final MutableArrayRefChar NONE;
  static {
    // initialize into temporary to have NONE = null in constructor
    MutableArrayRefChar obj = new MutableArrayRefChar(NoneType.None);
    NONE = obj;
  }

  // constant replacement for new ArrayRef<T>(NoneType.None)
  public static MutableArrayRefChar None() {
    return (MutableArrayRefChar)NONE;
  }

  public MutableArrayRefChar(/*uint*/byte OneElt, boolean isDataPointerLike) {
    super(OneElt, isDataPointerLike);
  }  

  public MutableArrayRefChar(SmallVectorImplChar Vec) {
    super(Vec);
  }

  public MutableArrayRefChar(/*uint*/byte Vec[]) {
    super(Vec);
  }

  public MutableArrayRefChar(NoneType $Prm0, boolean isDataPointerLike) {
    super(); // DO NOT CALL super($Prm0) here, because it will assert
//    if (NONE != null) {
//      NativeTrace.printStackTraceOnce(new Exception("use MutableArrayRefChar.None() instead"));
//    }    
    assert isDataPointerLike : "only true is expected for this constructor";    
  }
  
  public MutableArrayRefChar(NoneType $Prm0) {
    super($Prm0);
  }

  public MutableArrayRefChar(MutableArrayRefChar other) {
    super(other);
  }

  public MutableArrayRefChar(char$ptr Vec, int Size) {
    super(Vec, Size);
  }

  public MutableArrayRefChar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  public /*uint*/int $set(int index, /*uint*/byte val) {
    return super.data().$set(index, val);
  }
  
  @Override
  public MutableArrayRefChar $assignMove(ArrayRefChar other) {
    assert other != NONE : "use new MutableArrayRefChar() instead?";
    super.$assignMove(other);
    return this;
  }
    
  @Override
  public MutableArrayRefChar clone() {
    return new MutableArrayRefChar(this);
  }
}
