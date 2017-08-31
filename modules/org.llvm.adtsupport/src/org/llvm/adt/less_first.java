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
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;


//===----------------------------------------------------------------------===//
//     Extra additions to <utility>
//===----------------------------------------------------------------------===//

/// \brief Function object to check whether the first component of a std::pair
/// compares less than the first component of another std::pair.
//<editor-fold defaultstate="collapsed" desc="llvm::less_first">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 336,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 240,
 FQN="llvm::less_first", NM="_ZN4llvm10less_firstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm10less_firstE")
//</editor-fold>
public class/*struct*/ less_first {
  /*template <typename T> TEMPLATE*/
  //template <typename T = pair<unsigned long, StringRef>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 337,
   FQN="llvm::less_first::operator()", NM="_ZNK4llvm10less_firstclISt4pairIyNS_9StringRefEEEEbRKT_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm10less_firstclISt4pairIyNS_9StringRefEEEEbRKT_S7_")
  //</editor-fold>
  public static boolean $call(final /*const*/std.pairULongType<?> /*&*/ lhs, final /*const*/std.pairULongType<?> /*&*/ rhs) /*const*/ {
    return $less_ulong(lhs.first, rhs.first);
  }
  //template <typename T = pair<unsigned long, Function *>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 337,
   FQN="llvm::less_first::operator()", NM="_ZNK4llvm10less_firstclISt4pairIyPNS_8FunctionEEEEbRKT_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm10less_firstclISt4pairIyPNS_8FunctionEEEEbRKT_S8_")
  //</editor-fold>
  public static boolean $call(final /*const*/std.pairULongPtr<? /*P*/ > /*&*/ lhs, final /*const*/std.pairULongPtr<? /*P*/ > /*&*/ rhs) /*const*/ {
    return $less_ulong(lhs.first, rhs.first);
  }
  //template <typename T = pair<unsigned long, unsigned long>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 337,
   FQN="llvm::less_first::operator()", NM="_ZNK4llvm10less_firstclISt4pairIyyEEEbRKT_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm10less_firstclISt4pairIyyEEEbRKT_S6_")
  //</editor-fold>
  public static boolean $call(final /*const*/std.pairULongULong/*&*/ lhs, final /*const*/std.pairULongULong/*&*/ rhs) /*const*/ {
    return $less_ulong(lhs.first, rhs.first);
  }
  //template <typename T = pair<unsigned int, unsigned int>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 337,
   FQN="llvm::less_first::operator()", NM="_ZNK4llvm10less_firstclISt4pairIyyEEEbRKT_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm10less_firstclISt4pairIyyEEEbRKT_S6_")
  //</editor-fold>
  public static boolean $call(final /*const*/std.pairUIntUInt/*&*/ lhs, final /*const*/std.pairUIntUInt/*&*/ rhs) /*const*/ {
    return $less_uint(lhs.first, rhs.first);
  }
  public static <T extends Native.ComparableLower> boolean $call(final /*const*/std.pair/*<Type, ?>*/<T,?>/*&*/ lhs, final /*const*/std.pair/*<Type, ?>*/<T,?>/*&*/ rhs) /*const*/ {
    return lhs.first.$less(rhs.first);
  }
//  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::operator()">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 337,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 241,
//   FQN="llvm::less_first::operator()", NM="Tpl__ZNK4llvm10less_firstclERKT_S3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZNK4llvm10less_firstclERKT_S3_")
//  //</editor-fold>
//  public </*typename*/ T> boolean $call(final /*const*/ T /*&*/ lhs, final /*const*/ T /*&*/ rhs) /*const*/ {
//    return Native.$less(lhs.first, rhs.first);
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::less_first">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 240,
   FQN="llvm::less_first::less_first", NM="_ZN4llvm10less_firstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm10less_firstC1ERKS0_")
  //</editor-fold>
  public /*inline*/ less_first(final /*const*/ less_first /*&*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::less_first::less_first">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 240,
   FQN="llvm::less_first::less_first", NM="_ZN4llvm10less_firstC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm10less_firstC1EOS0_")
  //</editor-fold>
  public /*inline*/ less_first(JD$Move _dparam, final less_first /*&&*/$Prm0) {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
