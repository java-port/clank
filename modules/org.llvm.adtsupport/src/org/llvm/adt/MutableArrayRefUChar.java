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

import org.clank.java.std;
import org.clank.support.JavaDifferentiators;
import org.clank.support.aliases.uchar$ptr;
import org.llvm.adt.aliases.ArrayRefUChar;
import org.llvm.adt.aliases.SmallVectorImplUChar;

/**
 *
 * @author alex
 */
public class MutableArrayRefUChar extends /*public*/ ArrayRefUChar {

  private static final MutableArrayRefUChar NONE;
  static {
    // initialize into temporary to have NONE = null in constructor
    MutableArrayRefUChar obj = new MutableArrayRefUChar(NoneType.None);
    NONE = obj;
  }

  public MutableArrayRefUChar() {
  }

  public MutableArrayRefUChar(boolean isDataPointerLike) {
    super(isDataPointerLike);
  }

  public MutableArrayRefUChar(NoneType $Prm0) {
    super($Prm0);
  }

  public MutableArrayRefUChar(NoneType $Prm0, boolean isDataPointerLike) {
    super($Prm0, isDataPointerLike);
  }

  public MutableArrayRefUChar(byte OneElt) {
    super(OneElt);
  }

  public MutableArrayRefUChar(byte OneElt, int len, boolean isDataPointerLike) {
    super(OneElt, len, isDataPointerLike);
  }

  public MutableArrayRefUChar(byte OneElt, boolean isDataPointerLike) {
    super(OneElt, isDataPointerLike);
  }

  public MutableArrayRefUChar(byte[] data, int length) {
    super(data, length);
  }

  public MutableArrayRefUChar(byte[] data, int length, boolean isDataPointerLike) {
    super(data, length, isDataPointerLike);
  }

  public MutableArrayRefUChar(uchar$ptr data, int length) {
    super(data, length);
  }

  public MutableArrayRefUChar(uchar$ptr data, int length, boolean isDataPointerLike) {
    super(data, length, isDataPointerLike);
  }

  public MutableArrayRefUChar(uchar$ptr begin, uchar$ptr end) {
    super(begin, end);
  }

  public MutableArrayRefUChar(uchar$ptr begin, uchar$ptr end, boolean isDataPointerLike) {
    super(begin, end, isDataPointerLike);
  }

  public <U extends Object> MutableArrayRefUChar(SmallVectorImplUChar Vec) {
    super(Vec);
  }

  public <U extends Object> MutableArrayRefUChar(SmallVectorImplUChar Vec, boolean isDataPointerLike) {
    super(Vec, isDataPointerLike);
  }

  public <A extends Object> MutableArrayRefUChar(std.vectorUChar Vec) {
    super(Vec);
  }

  public <A extends Object> MutableArrayRefUChar(std.vectorUChar Vec, boolean isDataPointerLike) {
    super(Vec, isDataPointerLike);
  }

  public MutableArrayRefUChar(std.vectorString Vec) {
    super(Vec);
  }

  public MutableArrayRefUChar(std.vectorString Vec, boolean isDataPointerLike) {
    super(Vec, isDataPointerLike);
  }

  public MutableArrayRefUChar(byte[] Arr) {
    super(Arr);
  }

  public MutableArrayRefUChar(byte[] Arr, boolean isDataPointerLike) {
    super(Arr, isDataPointerLike);
  }

  public MutableArrayRefUChar(ArrayRefUChar other) {
    super(other);
  }

  public MutableArrayRefUChar(JavaDifferentiators.JD$Convertible _param, ArrayRefUChar other, boolean isDataPointerLike) {
    super(_param, other, isDataPointerLike);
  }

  public MutableArrayRefUChar(JavaDifferentiators.JD$Convertible _param, SmallVectorImplUChar Vec, boolean isDataPointerLike) {
    super(_param, Vec, isDataPointerLike);
  }

  public MutableArrayRefUChar(JavaDifferentiators.JD$Move _dparam, ArrayRefUChar other) {
    super(_dparam, other);
  }

  @Override
  public MutableArrayRefUChar $assignMove(ArrayRefUChar other) {
    assert other != NONE : "use new MutableArrayRefChar() instead?";
    super.$assignMove(other);
    return this;
  }

  @Override
  public MutableArrayRefUChar clone() {
    return new MutableArrayRefUChar(this);
  }  
}
