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
package org.llvm.adt.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.java.*;


//<editor-fold defaultstate="collapsed" desc="static type PostOrderIteratorLlvmGlobals">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm10po_ext_endET_RT0_;Tpl__ZN4llvm10post_orderERKT_;Tpl__ZN4llvm11ipo_ext_endERKT_RT0_;Tpl__ZN4llvm12po_ext_beginET_RT0_;Tpl__ZN4llvm13ipo_ext_beginERKT_RT0_;Tpl__ZN4llvm14post_order_extERKT_RT0_;Tpl__ZN4llvm18inverse_post_orderERKT_;Tpl__ZN4llvm22inverse_post_order_extERKT_RT0_;Tpl__ZN4llvm6po_endERKT_;Tpl__ZN4llvm7ipo_endERKT_;Tpl__ZN4llvm8po_beginERKT_;Tpl__ZN4llvm9ipo_beginERKT_; -static-type=PostOrderIteratorLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class PostOrderIteratorLlvmGlobals {


// Provide global constructors that automatically figure out correct types...
//
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_begin">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 178,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 177,
 FQN="llvm::po_begin", NM="Tpl__ZN4llvm8po_beginERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType "
         + "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN4llvm6po_endIPN5clang13CallGraphNodeEEENS_11po_iteratorIT_NS_11SmallPtrSetIPNS_11GraphTraitsIS5_E8NodeTypeELj8EEELb0ES8_EERKS5_")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_begin(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
  return po_iterator.begin(GT, G);
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_end">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 180,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 179,
 FQN="llvm::po_end", NM="Tpl__ZN4llvm6po_endERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=Tpl__ZN4llvm6po_endERKT_")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_end(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
  return po_iterator.end(GT, G);
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::post_order">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 182,
 FQN="llvm::post_order", NM="Tpl__ZN4llvm10post_orderERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm10post_orderERKT_")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeType> iterator_range<NodeType> post_order(final /*const*/ GraphT /*&*/ G) {
  throw new UnsupportedOperationException("EmptyBody");
}

///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_ext_begin">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 194,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 193,
// FQN="llvm::po_ext_begin", NM="Tpl__ZN4llvm12po_ext_beginET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm12po_ext_beginET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> po_ext_iterator<T, SetType> po_ext_begin(T G, final SetType /*&*/ S) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_ext_end">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 199,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 198,
// FQN="llvm::po_ext_end", NM="Tpl__ZN4llvm10po_ext_endET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm10po_ext_endET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> po_ext_iterator<T, SetType> po_ext_end(T G, final SetType /*&*/ S) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::post_order_ext">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 204,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 203,
// FQN="llvm::post_order_ext", NM="Tpl__ZN4llvm14post_order_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm14post_order_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> iterator_range<po_ext_iterator<T, SetType> > post_order_ext(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_begin">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 218,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 217,
// FQN="llvm::ipo_begin", NM="Tpl__ZN4llvm9ipo_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm9ipo_beginERKT_")
////</editor-fold>
//public static </*class*/ T> ipo_iterator<T> ipo_begin(final /*const*/ T /*&*/ G) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_end">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 223,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 222,
// FQN="llvm::ipo_end", NM="Tpl__ZN4llvm7ipo_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm7ipo_endERKT_")
////</editor-fold>
//public static </*class*/ T> ipo_iterator<T> ipo_end(final /*const*/ T /*&*/ G) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_post_order">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 228,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 227,
// FQN="llvm::inverse_post_order", NM="Tpl__ZN4llvm18inverse_post_orderERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm18inverse_post_orderERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range<ipo_iterator<T> > inverse_post_order(final /*const*/ T /*&*/ G) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_ext_begin">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 243,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 242,
// FQN="llvm::ipo_ext_begin", NM="Tpl__ZN4llvm13ipo_ext_beginERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm13ipo_ext_beginERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> ipo_ext_iterator<T, SetType> ipo_ext_begin(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_ext_end">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 248,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 247,
// FQN="llvm::ipo_ext_end", NM="Tpl__ZN4llvm11ipo_ext_endERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm11ipo_ext_endERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> ipo_ext_iterator<T, SetType> ipo_ext_end(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_post_order_ext">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 253,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 252,
// FQN="llvm::inverse_post_order_ext", NM="Tpl__ZN4llvm22inverse_post_order_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm22inverse_post_order_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> iterator_range<ipo_ext_iterator<T, SetType> > inverse_post_order_ext(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

} // END OF class PostOrderIteratorLlvmGlobals
