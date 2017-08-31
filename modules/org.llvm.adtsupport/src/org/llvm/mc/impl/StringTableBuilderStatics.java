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
package org.llvm.mc.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type StringTableBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.StringTableBuilderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZL10charTailAtPSt4pairIN4llvm10CachedHashINS0_9StringRefEEEjEj;_ZL14multikey_qsortPPSt4pairIN4llvm10CachedHashINS0_9StringRefEEEjES6_i; -static-type=StringTableBuilderStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class StringTableBuilderStatics {


// Returns the character at Pos from end of a string.
//<editor-fold defaultstate="collapsed" desc="charTailAt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 40,
 FQN="charTailAt", NM="_ZL10charTailAtPSt4pairIN4llvm10CachedHashINS0_9StringRefEEEjEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZL10charTailAtPSt4pairIN4llvm10CachedHashINS0_9StringRefEEEjEj")
//</editor-fold>
public static int charTailAt(std.pairTypeUInt<CachedHashStringRef> /*P*/ P, /*size_t*/int Pos) {
  StringRef S = new StringRef(P.first.Val);
  if ($greatereq_uint(Pos, S.size())) {
    return -1;
  }
  return $uchar2int((/*uchar*/byte)S.$at(S.size() - Pos - 1));
}


// Three-way radix quicksort. This is much faster than std::sort with strcmp
// because it does not compare characters that we already know the same.
//<editor-fold defaultstate="collapsed" desc="multikey_qsort">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 49,
 FQN="multikey_qsort", NM="_ZL14multikey_qsortPPSt4pairIN4llvm10CachedHashINS0_9StringRefEEEjES6_i",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZL14multikey_qsortPPSt4pairIN4llvm10CachedHashINS0_9StringRefEEEjES6_i")
//</editor-fold>
public static void multikey_qsort(type$ptr<std.pairTypeUInt<CachedHashStringRef> /*P*/ /*P*/> Begin, type$ptr<std.pairTypeUInt<CachedHashStringRef> /*P*/ /*P*/> End, int Pos) {
 tailcall:
 while(true){
  if (End.$sub(Begin) <= 1) {
    return;
  }
  
  // Partition items. Items in [Begin, P) are greater than the pivot,
  // [P, Q) are the same as the pivot, and [Q, End) are less than the pivot.
  int Pivot = charTailAt(Begin.$star(), Pos);
  type$ptr<std.pairTypeUInt<CachedHashStringRef> /*P*/ /*P*/> P = $tryClone(Begin);
  type$ptr<std.pairTypeUInt<CachedHashStringRef> /*P*/ /*P*/> Q = $tryClone(End);
  for (type$ptr<std.pairTypeUInt<CachedHashStringRef> /*P*/ /*P*/> R = $tryClone(Begin.$add(1)); R.$less(Q);) {
    int C = charTailAt(R.$star(), Pos);
    if (C > Pivot) {
      std.swap(P.$postInc().$star(), R.$postInc().$star());
    } else if (C < Pivot) {
      Q.$preDec();
      std.swap(Q.$preDec().$star(), R.$star());
    } else {
      R.$postInc();
    }
  }
  
  multikey_qsort(Begin, P, Pos);
  multikey_qsort(Q, End, Pos);
  if (Pivot != -1) {
    // qsort(P, Q, Pos + 1), but with tail call optimization.
    Begin = $tryClone(P);
    End = $tryClone(Q);
    ++Pos;
    continue tailcall;
  }
  break;
 }
}

} // END OF class StringTableBuilderStatics
