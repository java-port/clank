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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//<editor-fold defaultstate="collapsed" desc="static type STLExtrasLlvmGlobals">
@Converted(kind = Converted.Kind.DUMMY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm11make_uniqueEDpOT0_R_ZTSNSt9enable_ifIXntsr3std8is_arrayIT_EE5valueESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE;Tpl__ZN4llvm11make_uniqueEjR_ZTSNSt9enable_ifIXaasr3std8is_arrayIT_EE5valueeqsr3std6extentIS0_EE5valueLi0EESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE;Tpl__ZN4llvm12is_containedEOT_RKT0_;Tpl__ZN4llvm12map_iteratorERKT_T0_;Tpl__ZN4llvm14array_lengthofERAT0__T_;Tpl__ZN4llvm14array_pod_sortET_S0_;Tpl__ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E;Tpl__ZN4llvm17make_filter_rangeEOT_T0_;Tpl__ZN4llvm21make_reverse_iteratorET_;Tpl__ZN4llvm22DeleteContainerSecondsERT_;Tpl__ZN4llvm23DeleteContainerPointersERT_;Tpl__ZN4llvm25array_pod_sort_comparatorEPKvS1_;Tpl__ZN4llvm29get_array_pod_sort_comparatorERKT_;Tpl__ZN4llvm4findEOT_RKT0_;Tpl__ZN4llvm6all_ofEOT_OT0_;Tpl__ZN4llvm6any_ofEOT_OT0_;Tpl__ZN4llvm7deleterEPT_;Tpl__ZN4llvm7find_ifEOT_RKT0_;Tpl__ZN4llvm7none_ofEOT_OT0_;Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXntsr10has_rbeginIS0_EE5valueEvE4typeE;Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXsr10has_rbeginIS0_EE5valueEvE4typeE;Tpl__ZN4llvm8count_ifEOT_OT0_;Tpl__ZN4llvm9remove_ifEOT_OT0_;Tpl__ZN4llvm9transformEOT_T0_OT1_;Tpl__ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_; -static-type=STLExtrasLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class STLExtrasLlvmGlobals {

// map_iterator - Provide a convenient way to create mapped_iterators, just like
// make_pair is useful for creating pairs...
//
/*template <class ItTy, class FuncTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::map_iterator">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 207,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 194,
 FQN="llvm::map_iterator", NM="Tpl__ZN4llvm12map_iteratorERKT_T0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm12map_iteratorERKT_T0_")
//</editor-fold>
public static /*inline*/ </*class*/ FromType, /*class*/ ToType> 
        mapped_iterator<FromType, ToType> 
        map_iterator(/*const*/type$iterator<?, FromType> /*&*/ I, Converter<FromType, ToType> F) {
  return new mapped_iterator<FromType, ToType>(I, F);
}

/// Provide wrappers to std::all_of which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::all_of">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 465,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 368,
 FQN="llvm::all_of", NM="Tpl__ZN4llvm6all_ofEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm6all_ofEOT_OT0_")
//</editor-fold>
public static <T> boolean all_of(NativeIterable<T> /*&&*/Range, BoolPredicate<T> /*&&*/P) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Provide wrappers to std::all_of which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::all_of">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 465,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 368,
 FQN="llvm::all_of", NM="Tpl__ZN4llvm6all_ofEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm6all_ofEOT_OT0_")
//</editor-fold>
public static boolean all_of(NativeIterable<uint$iterator> /*&&*/Range, UIntBoolPredicate /*&&*/P) {
  return std.all_of(Range.begin(), Range.end(), P);
}
public static boolean all_of(SmallVectorUInt /*&&*/Range, UIntBoolPredicate /*&&*/P) {
  return std.all_of(Range.begin(), Range.end(), P);
}


/// Provide wrappers to std::any_of which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::any_of">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 473,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 376,
 FQN="llvm::any_of", NM="Tpl__ZN4llvm6any_ofEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm6any_ofEOT_OT0_")
//</editor-fold>
public static </*typename*/ R, /*class*/ UnaryPredicate> boolean any_of(R /*&&*/Range, UnaryPredicate /*&&*/P) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Provide wrappers to std::none_of which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::none_of">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 481,
 FQN="llvm::none_of", NM="Tpl__ZN4llvm7none_ofEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm7none_ofEOT_OT0_")
//</editor-fold>
public static </*typename*/ R, /*class*/ UnaryPredicate> boolean none_of(R /*&&*/Range, UnaryPredicate /*&&*/P) {
  throw new UnsupportedOperationException("EmptyBody");
}

//
///// Provide wrappers to std::find which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::find">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 489,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 384,
// FQN="llvm::find", NM="Tpl__ZN4llvm4findEOT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm4findEOT_RKT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ T> auto find(final R /*&&*/Range, final /*const*/ T /*&*/ val) -> decltype(Range.begin()) {
//  return std.find(Range.begin(), Range.end(), val);
//}
//
//
///// Provide wrappers to std::find_if which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::find_if">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 496,
// FQN="llvm::find_if", NM="Tpl__ZN4llvm7find_ifEOT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm7find_ifEOT_RKT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ T> auto find_if(final R /*&&*/Range, final /*const*/ T /*&*/ Pred) -> decltype(Range.begin()) {
//  return std.find_if(Range.begin(), Range.end(), Pred);
//}
//
//
///// Provide wrappers to std::remove_if which take ranges instead of having to
///// pass begin/end explicitly.
///*template <typename R, class UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::remove_if">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 503,
// FQN="llvm::remove_if", NM="Tpl__ZN4llvm9remove_ifEOT_OT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm9remove_ifEOT_OT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ UnaryPredicate> auto remove_if(final R /*&&*/Range, final UnaryPredicate /*&&*/P) -> decltype(Range.begin()) {
//  return std.remove_if(Range.begin(), Range.end(), P);
//}
//
//
/// Wrapper function around std::find to detect if an element exists
/// in a container.
/*template <typename R, typename E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::is_contained">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 510,
 FQN="llvm::is_contained", NM="Tpl__ZN4llvm12is_containedEOT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm12is_containedEOT_RKT0_")
//</editor-fold>
public static </*typename*/ R extends NativeIterable<type$ptr<E>>, /*typename*/ E> boolean is_contained(final R /*&&*/Range, final /*const*/ E /*&*/ Element) {
  return std.find(Range.begin(), Range.end(), Element).$noteq(Range.end());
}


/// Wrapper function around std::count_if to count the number of times an
/// element satisfying a given predicate occurs in a range.
/*template <typename R, typename UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::count_if">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 517,
 FQN="llvm::count_if", NM="Tpl__ZN4llvm8count_ifEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm8count_ifEOT_OT0_")
//</editor-fold>
public static </*typename*/ R extends NativeIterable<type$iterator<?, T>>, /*typename*/ T> int count_if(final R /*&&*/Range, final BoolPredicate<T> /*&&*/P) {
  return std.count_if(Range.begin(), Range.end(), P);
}


///// Wrapper function around std::transform to apply a function to a range and
///// store the result elsewhere.
///*template <typename R, class OutputIt, typename UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::transform">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 525,
// FQN="llvm::transform", NM="Tpl__ZN4llvm9transformEOT_T0_OT1_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm9transformEOT_T0_OT1_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ OutputIt, /*typename*/ UnaryPredicate> OutputIt transform(final R /*&&*/Range, OutputIt d_first, final UnaryPredicate /*&&*/P) {
//  return std.transform(Range.begin(), Range.end(), d_first, 
//      std.<UnaryPredicate>forward(P));
//}
//
//
////===----------------------------------------------------------------------===//
////     Extra additions to <memory>
////===----------------------------------------------------------------------===//
//
//// Implement make_unique according to N3656.
//
///// \brief Constructs a `new T()` with the given args and returns a
/////        `unique_ptr<T>` which owns the object.
/////
///// Example:
/////
/////     auto p = make_unique<int>();
/////     auto p = make_unique<std::tuple<int, int>>(0, 1);
///*template <class T, class ... Args> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 544,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 402,
// FQN="llvm::make_unique", NM="Tpl__ZN4llvm11make_uniqueEDpOT0_R_ZTSNSt9enable_ifIXntsr3std8is_arrayIT_EE5valueESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm11make_uniqueEDpOT0_R_ZTSNSt9enable_ifIXntsr3std8is_arrayIT_EE5valueESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE")
////</editor-fold>
//public static </*class*/ T, /*class*/ /*...*/ Args> /*std::enable_if<!std::is_array<T>::value, std::unique_ptr<T> >::type*/std.unique_ptr<T> make_unique$NotArray(Args /*&&*/...args) {
//  return std.unique_ptr<T>(new T(( std.<Args>forward(args)... )));
//}
//
//
///// \brief Constructs a `new T[n]` with the given args and returns a
/////        `unique_ptr<T[]>` which owns the object.
/////
///// \param n size of the new array.
/////
///// Example:
/////
/////     auto p = make_unique<int[]>(2); // value-initializes the array with 0's.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 558,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 416,
// FQN="llvm::make_unique", NM="Tpl__ZN4llvm11make_uniqueEjR_ZTSNSt9enable_ifIXaasr3std8is_arrayIT_EE5valueeqsr3std6extentIS0_EE5valueLi0EESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN4llvm11make_uniqueEjR_ZTSNSt9enable_ifIXaasr3std8is_arrayIT_EE5valueeqsr3std6extentIS0_EE5valueLi0EESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE")
////</editor-fold>
//public static </*class*/ T> /*std::enable_if<Native.$bool(std::is_array<T>::value) && Native.$bool(std::extent<T>::value == 0), std::unique_ptr<T> >::type*/std.unique_ptr<T> make_unique$ArrayAndExtentEqZero(/*size_t*/int n) {
//  return std.unique_ptr<T>(new  std.remove_extent.type<T> [n]((  )));
//}

} // END OF class STLExtrasLlvmGlobals
