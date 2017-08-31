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

//<editor-fold defaultstate="collapsed" desc="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*MUST NOT BE USED, must be unfolded to callable */,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 68,
 FQN="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>", NM="_ZN4llvm12function_refIFT_DpT0_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm12function_refIFT_DpT0_EEE")
//</editor-fold>
public class function_refT2T {
//  private /*ADD MAPPING FOR FUN PTR[Ret (* )(intptr_t, Params...)]*/Ret (/*P*/ callback)(Object/*intptr_t*/, Params...);
//  private Object/*intptr_t*/ callable;
//  
//  /*template <typename Callable> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>::callback_fn">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 74,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 73,
//   FQN="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>::callback_fn", NM="Tpl__ZN4llvm12function_refIFT_DpT0_EE11callback_fnEiS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm12function_refIFT_DpT0_EE11callback_fnEiS3_")
//  //</editor-fold>
//  private static </*typename*/ Callable> Ret callback_fn(Object/*intptr_t*/ callable, Params params...) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
///*public:*/
//  /*template <typename Callable> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>::function_ref<type-parameter-0-0 (type-parameter-0-1...)>">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 81,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 80,
//   FQN="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>::function_ref<type-parameter-0-0 (type-parameter-0-1...)>", NM="Tpl__ZN4llvm12function_refIFT_DpT0_EEC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS6_E4typeENS0_IS4_EEEE5valueEvE4typeE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm12function_refIFT_DpT0_EEC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS6_E4typeENS0_IS4_EEEE5valueEvE4typeE")
//  //</editor-fold>
//  public </*typename*/ Callable> function_refT2T(Callable /*&&*/callable) {
//    /* : callback(callback_fn< std::remove_reference<Callable>::type>), callable(reinterpret_cast<intptr_t>(&callable))*/ 
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>::operator()">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 87,
//   FQN="llvm::function_ref<type-parameter-0-0 (type-parameter-0-1...)>::operator()", NM="_ZNK4llvm12function_refIFT_DpT0_EEclES3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm12function_refIFT_DpT0_EEclES3_")
//  //</editor-fold>
//  public Ret $call(Params params...) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  public String toString() {
//    return "" + "callback=" + callback // NOI18N
//              + ", callable=" + callable; // NOI18N
//  }
}
