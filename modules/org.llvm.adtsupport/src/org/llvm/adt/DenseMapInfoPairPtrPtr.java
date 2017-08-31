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

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 136,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", old_line = 133,
 FQN = "llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >", NM = "_ZN4llvm12DenseMapInfoISt4pairIT_T0_EEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm12DenseMapInfoISt4pairIT_T0_EEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoPairPtrPtr<T/*P*/, U/*P*/> implements DenseMapInfo<std.pairPtrPtr<T/*P*/, U/*P*/>>  {
  private final static DenseMapInfoPairPtrPtr Info = new DenseMapInfoPairPtrPtr(DenseMapInfo$LikePtr.$Info(), DenseMapInfo$LikePtr.$Info());
  public static <T/*P*/, U/*P*/> DenseMapInfoPairPtrPtr<T/*P*/, U/*P*/> $Info() { return Info; }
  
  private final DenseMapInfoPair<T, U> delegate;
  
  public DenseMapInfoPairPtrPtr(DenseMapInfo<T> FirstInfo, DenseMapInfo<U> SecondInfo) {
    delegate = new DenseMapInfoPair(FirstInfo, SecondInfo);
  }

  @Override
  public /*inline*/ Object getEmptyKey() {
    return delegate.getEmptyKey();
  }

  @Override
  public /*inline*/ Object getTombstoneKey() {
    return delegate.getTombstoneKey();
  }

  @Override
  public /*uint*/int getHashValue(/*const*/std.pairPtrPtr<T, U> /*&*/ PairVal) {
    return delegate.getHashValue(PairVal);
  }

  public boolean isEqual(/*const*/std.pairPtrPtr<T, U> /*&*/ LHS, /*const*/std.pairPtrPtr<T, U> /*&*/ RHS) {
    return delegate.isEqual(LHS, RHS);
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }
}

