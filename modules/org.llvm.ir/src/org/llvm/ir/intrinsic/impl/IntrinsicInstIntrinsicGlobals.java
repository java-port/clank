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
package org.llvm.ir.intrinsic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.ir.java.IRFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type IntrinsicInstIntrinsicGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.intrinsic.impl.IntrinsicInstIntrinsicGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm9Intrinsic25lookupLLVMIntrinsicByNameENS_8ArrayRefIPKcEENS_9StringRefE; -static-type=IntrinsicInstIntrinsicGlobals -package=org.llvm.ir.intrinsic.impl")
//</editor-fold>
public final class IntrinsicInstIntrinsicGlobals {


/// Looks up Name in NameTable via binary search. NameTable must be sorted
/// and all entries must start with "llvm.".  If NameTable contains an exact
/// match for Name or a prefix of Name followed by a dot, its index in
/// NameTable is returned. Otherwise, -1 is returned.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::lookupLLVMIntrinsicByName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp", line = 49,
 FQN="llvm::Intrinsic::lookupLLVMIntrinsicByName", NM="_ZN4llvm9Intrinsic25lookupLLVMIntrinsicByNameENS_8ArrayRefIPKcEENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm9Intrinsic25lookupLLVMIntrinsicByNameENS_8ArrayRefIPKcEENS_9StringRefE")
//</editor-fold>
public static int lookupLLVMIntrinsicByName(ArrayRef</*const*/char$ptr/*char P*/ > NameTable, 
                         StringRef Name) {
  assert (Name.startswith(/*STRINGREF_STR*/"llvm."));
  
  // Do successive binary searches of the dotted name components. For
  // "llvm.gc.experimental.statepoint.p1i8.p1i32", we will find the range of
  // intrinsics starting with "llvm.gc", then "llvm.gc.experimental", then
  // "llvm.gc.experimental.statepoint", and then we will stop as the range is
  // size 1. During the search, we can skip the prefix that we already know is
  // identical. By using strncmp we consider names with differing suffixes to
  // be part of the equal range.
  /*size_t*/int CmpStart = 0;
  /*size_t*/int CmpEnd = 4; // Skip the "llvm" component.
  /*const*/type$ptr<char$ptr>/*char P const P*/ Low = $tryClone(NameTable.begin());
  /*const*/type$ptr<char$ptr>/*char P const P*/ High = $tryClone(NameTable.end());
  /*const*/type$ptr<char$ptr>/*char P const P*/ LastLow = $tryClone(Low);
  while ($less_uint(CmpEnd, Name.size()) && High.$sub(Low) > 0) {
    CmpStart = CmpEnd;
    CmpEnd = Name.find($$DOT, CmpStart + 1);
    CmpEnd = CmpEnd == StringRef.npos ? Name.size() : CmpEnd;
    int L$CmpStart = CmpStart;
    int L$CmpEnd = CmpEnd;
    CharPtrCharPtr2Bool Cmp = /*[=L$CmpStart(CmpStart), =L$CmpEnd(CmpEnd)]*/ (/*const*/char$ptr/*char P*/ LHS, /*const*/char$ptr/*char P*/ RHS) -> {
          return strncmp(LHS.$add(L$CmpStart), RHS.$add(L$CmpStart), L$CmpEnd - L$CmpStart) < 0;
        };
    LastLow = $tryClone(Low);
    std_pair.pair<type$ptr<char$ptr>, type$ptr<char$ptr>> tmp = std.equal_range(Low, High, Name.data(), (char$ptr one, char$ptr other) -> {return Cmp.$call(one, other);});
    Low.$assign(tmp.first);
    High.$assign(tmp.second);
    //std.tie(Low, High).$assign(std.equal_range(Low, High, Name.data(), new Cmp(Cmp)));
  }
  if (High.$sub(Low) > 0) {
    LastLow = $tryClone(Low);
  }
  if ($eq_ptr(LastLow, NameTable.end())) {
    return -1;
  }
  StringRef NameFound = new StringRef(LastLow.$star());
  if ($eq_StringRef(/*NO_COPY*/Name, /*NO_COPY*/NameFound)
     || (Name.startswith(/*NO_COPY*/NameFound) && Name.$at(NameFound.size()) == $$DOT)) {
    return LastLow.$sub(NameTable.begin());
  }
  return -1;
}

} // END OF class IntrinsicInstIntrinsicGlobals
