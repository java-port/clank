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


//<editor-fold defaultstate="collapsed" desc="static type detail">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp ${LLVM_SRC}/llvm/lib/IR/Constants.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp ${LLVM_SRC}/llvm/lib/Support/Options.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail11AlignerImplE;_ZN4llvm6detail12ConstantLog2E;_ZN4llvm6detail12ConstantLog2ILj1EEE;_ZN4llvm6detail12DenseMapPairE;_ZN4llvm6detail12DenseSetPairE;_ZN4llvm6detail13DenseSetEmptyE;_ZN4llvm6detail17AlignmentCalcImplE;_ZN4llvm6detail17AlignmentCalcImplIT_Lb1EEE;_ZN4llvm6detail17PopulationCounterE;_ZN4llvm6detail17PopulationCounterIT_Lj8EEE;_ZN4llvm6detail19LeadingZerosCounterE;_ZN4llvm6detail19LeadingZerosCounterIT_Lj4EEE;_ZN4llvm6detail19LeadingZerosCounterIT_Lj8EEE;_ZN4llvm6detail20PointerSumTypeHelperE;_ZN4llvm6detail20TrailingZerosCounterE;_ZN4llvm6detail20TrailingZerosCounterIT_Lj4EEE;_ZN4llvm6detail20TrailingZerosCounterIT_Lj8EEE;_ZN4llvm6detail21AlignmentCalcImplBaseE;_ZN4llvm6detail26printBumpPtrAllocatorStatsEjjj;_ZN4llvm6detail9OptionKeyE;_ZN4llvm6detail9SizerImplE; -static-type=detail -package=org.llvm.support")
//</editor-fold>
public final class detail {

///*template <typename T, std::size_t SizeOfT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::TrailingZerosCounter">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 45,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 43,
// FQN="llvm::detail::TrailingZerosCounter", NM="_ZN4llvm6detail20TrailingZerosCounterE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail20TrailingZerosCounterE")
////</editor-fold>
//public static class/*struct*/ TrailingZerosCounter</*typename*/ T, /*uint*/int SizeOfT>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::TrailingZerosCounter::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 46,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 44,
//   FQN="llvm::detail::TrailingZerosCounter::count", NM="_ZN4llvm6detail20TrailingZerosCounter5countET_NS_12ZeroBehaviorE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail20TrailingZerosCounter5countET_NS_12ZeroBehaviorE")
//  //</editor-fold>
//  public static </*typename*/ T, /*uint*/int SizeOfT> /*uint*/int count(T Val, ZeroBehavior $Prm1) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 4>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 69,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 67,
// FQN="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 4>", NM="_ZN4llvm6detail20TrailingZerosCounterIT_Lj4EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail20TrailingZerosCounterIT_Lj4EEE")
////</editor-fold>
//public static class/*struct*/ TrailingZerosCounterT</*typename*/ T>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 4>::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 70,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 68,
//   FQN="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 4>::count", NM="_ZN4llvm6detail20TrailingZerosCounterIT_Lj4EE5countES2_NS_12ZeroBehaviorE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail20TrailingZerosCounterIT_Lj4EE5countES2_NS_12ZeroBehaviorE")
//  //</editor-fold>
//  public static </*typename*/ T> /*uint*/int count(T Val, ZeroBehavior ZB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 8>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 85,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 83,
// FQN="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 8>", NM="_ZN4llvm6detail20TrailingZerosCounterIT_Lj8EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail20TrailingZerosCounterIT_Lj8EEE")
////</editor-fold>
//public static class/*struct*/ TrailingZerosCounterT</*typename*/ T>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 8>::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 86,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 84,
//   FQN="llvm::detail::TrailingZerosCounter<type-parameter-0-0, 8>::count", NM="_ZN4llvm6detail20TrailingZerosCounterIT_Lj8EE5countES2_NS_12ZeroBehaviorE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail20TrailingZerosCounterIT_Lj8EE5countES2_NS_12ZeroBehaviorE")
//  //</editor-fold>
//  public static </*typename*/ T> /*uint*/int count(T Val, ZeroBehavior ZB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T, std::size_t SizeOfT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::LeadingZerosCounter">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 119,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 117,
// FQN="llvm::detail::LeadingZerosCounter", NM="_ZN4llvm6detail19LeadingZerosCounterE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail19LeadingZerosCounterE")
////</editor-fold>
//public static class/*struct*/ LeadingZerosCounter</*typename*/ T, /*uint*/int SizeOfT>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::LeadingZerosCounter::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 120,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 118,
//   FQN="llvm::detail::LeadingZerosCounter::count", NM="_ZN4llvm6detail19LeadingZerosCounter5countET_NS_12ZeroBehaviorE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail19LeadingZerosCounter5countET_NS_12ZeroBehaviorE")
//  //</editor-fold>
//  public static </*typename*/ T, /*uint*/int SizeOfT> /*uint*/int count(T Val, ZeroBehavior $Prm1) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 4>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 138,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 136,
// FQN="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 4>", NM="_ZN4llvm6detail19LeadingZerosCounterIT_Lj4EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail19LeadingZerosCounterIT_Lj4EEE")
////</editor-fold>
//public static class/*struct*/ LeadingZerosCounterT</*typename*/ T>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 4>::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 139,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 137,
//   FQN="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 4>::count", NM="_ZN4llvm6detail19LeadingZerosCounterIT_Lj4EE5countES2_NS_12ZeroBehaviorE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail19LeadingZerosCounterIT_Lj4EE5countES2_NS_12ZeroBehaviorE")
//  //</editor-fold>
//  public static </*typename*/ T> /*uint*/int count(T Val, ZeroBehavior ZB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 8>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 154,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 152,
// FQN="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 8>", NM="_ZN4llvm6detail19LeadingZerosCounterIT_Lj8EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail19LeadingZerosCounterIT_Lj8EEE")
////</editor-fold>
//public static class/*struct*/ LeadingZerosCounterT</*typename*/ T>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 8>::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 155,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 153,
//   FQN="llvm::detail::LeadingZerosCounter<type-parameter-0-0, 8>::count", NM="_ZN4llvm6detail19LeadingZerosCounterIT_Lj8EE5countES2_NS_12ZeroBehaviorE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail19LeadingZerosCounterIT_Lj8EE5countES2_NS_12ZeroBehaviorE")
//  //</editor-fold>
//  public static </*typename*/ T> /*uint*/int count(T Val, ZeroBehavior ZB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T, std::size_t SizeOfT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::PopulationCounter">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 454,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 415,
// FQN="llvm::detail::PopulationCounter", NM="_ZN4llvm6detail17PopulationCounterE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17PopulationCounterE")
////</editor-fold>
//public static class/*struct*/ PopulationCounter</*typename*/ T, /*uint*/int SizeOfT>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PopulationCounter::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 455,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 416,
//   FQN="llvm::detail::PopulationCounter::count", NM="_ZN4llvm6detail17PopulationCounter5countET_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17PopulationCounter5countET_")
//  //</editor-fold>
//  public static </*typename*/ T, /*uint*/int SizeOfT> /*uint*/int count(T Value) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::PopulationCounter<type-parameter-0-0, 8>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 469,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 430,
// FQN="llvm::detail::PopulationCounter<type-parameter-0-0, 8>", NM="_ZN4llvm6detail17PopulationCounterIT_Lj8EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17PopulationCounterIT_Lj8EEE")
////</editor-fold>
//public static class/*struct*/ PopulationCounterT</*typename*/ T>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PopulationCounter<type-parameter-0-0, 8>::count">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 470,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 431,
//   FQN="llvm::detail::PopulationCounter<type-parameter-0-0, 8>::count", NM="_ZN4llvm6detail17PopulationCounterIT_Lj8EE5countES2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17PopulationCounterIT_Lj8EE5countES2_")
//  //</editor-fold>
//  public static </*typename*/ T> /*uint*/int count(T Value) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
//
//// For everything other than an abstract class we can calulate alignment by
//// building a class with a single character and a member of the given type.
///*template <typename T, bool = std::is_abstract<T>::value> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignmentCalcImpl">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 28,
// FQN="llvm::detail::AlignmentCalcImpl", NM="_ZN4llvm6detail17AlignmentCalcImplE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17AlignmentCalcImplE")
////</editor-fold>
//public static class/*struct*/ AlignmentCalcImpl</*typename*/ T, boolean/* = std.is_abstract.<T>value*/>  {
//  public /*char*/byte x;
//  public T t;
///*private:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignmentCalcImpl::AlignmentCalcImpl<T, >">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 41,
//   FQN="llvm::detail::AlignmentCalcImpl::AlignmentCalcImpl<T, >", NM="_ZN4llvm6detail17AlignmentCalcImplC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17AlignmentCalcImplC1Ev")
//  //</editor-fold>
//  protected/*private*/ AlignmentCalcImpl() { throw new UnsupportedOperationException("Deleted");}
//
//  
//  @Override public String toString() {
//    return "" + "x=" + x // NOI18N
//              + ", t=" + t; // NOI18N
//  }
//}
//
//// Abstract base class helper, this will have the minimal alignment and size
//// for any abstract class. We don't even define its destructor because this
//// type should never be used in a way that requires it.
////<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignmentCalcImplBase">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 47,
// FQN="llvm::detail::AlignmentCalcImplBase", NM="_ZN4llvm6detail21AlignmentCalcImplBaseE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail21AlignmentCalcImplBaseE")
////</editor-fold>
//public abstract static class/*struct*/ AlignmentCalcImplBase implements Destructors.ClassWithDestructor {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignmentCalcImplBase::~AlignmentCalcImplBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 48,
//   FQN="llvm::detail::AlignmentCalcImplBase::~AlignmentCalcImplBase", NM="_ZN4llvm6detail21AlignmentCalcImplBaseD0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail21AlignmentCalcImplBaseD0Ev")
//  //</editor-fold>
//  public abstract /*virtual*/ void $destroy()/* = 0*/;
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
//
//// When we have an abstract class type, specialize the alignment computation
//// engine to create another abstract class that derives from both an empty
//// abstract base class and the provided type. This has the same effect as the
//// above except that it handles the fact that we can't actually create a member
//// of type T.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignmentCalcImpl<type-parameter-0-0, true>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 56,
// FQN="llvm::detail::AlignmentCalcImpl<type-parameter-0-0, true>", NM="_ZN4llvm6detail17AlignmentCalcImplIT_Lb1EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17AlignmentCalcImplIT_Lb1EEE")
////</editor-fold>
//public abstract static class/*struct*/ AlignmentCalcImplTTrue</*typename*/ T>  extends /**/ AlignmentCalcImplBase, /**/ T implements Destructors.ClassWithDestructor {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignmentCalcImpl<type-parameter-0-0, true>::~AlignmentCalcImpl<type-parameter-0-0, true>">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 58,
//   FQN="llvm::detail::AlignmentCalcImpl<type-parameter-0-0, true>::~AlignmentCalcImpl<type-parameter-0-0, true>", NM="_ZN4llvm6detail17AlignmentCalcImplIT_Lb1EED0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail17AlignmentCalcImplIT_Lb1EED0Ev")
//  //</editor-fold>
//  @Override public abstract void $destroy()/* override*//* = 0*/;
//
//  
//  @Override public String toString() {
//    return "" + super.toString(); // NOI18N
//  }
//}
///*template <typename T1, typename T2 = char, typename T3 = char, typename T4 = char, typename T5 = char, typename T6 = char, typename T7 = char, typename T8 = char, typename T9 = char, typename T10 = char> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignerImpl">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 219,
// FQN="llvm::detail::AlignerImpl", NM="_ZN4llvm6detail11AlignerImplE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail11AlignerImplE")
////</editor-fold>
//public static class AlignerImpl</*typename*/ T1, /*typename*/ T2/* = char*/, /*typename*/ T3/* = char*/, /*typename*/ T4/* = char*/, /*typename*/ T5/* = char*/, /*typename*/ T6/* = char*/, /*typename*/ T7/* = char*/, /*typename*/ T8/* = char*/, /*typename*/ T9/* = char*/, /*typename*/ T10/* = char*/>  {
//  private T1 t1;
//  private T2 t2;
//  private T3 t3;
//  private T4 t4;
//  private T5 t5;
//  private T6 t6;
//  private T7 t7;
//  private T8 t8;
//  private T9 t9;
//  private T10 t10;
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AlignerImpl::AlignerImpl<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 226,
//   FQN="llvm::detail::AlignerImpl::AlignerImpl<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>", NM="_ZN4llvm6detail11AlignerImplC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail11AlignerImplC1Ev")
//  //</editor-fold>
//  protected/*private*/ AlignerImpl() { throw new UnsupportedOperationException("Deleted");}
//
//  
//  @Override public String toString() {
//    return "" + "t1=" + t1 // NOI18N
//              + ", t2=" + t2 // NOI18N
//              + ", t3=" + t3 // NOI18N
//              + ", t4=" + t4 // NOI18N
//              + ", t5=" + t5 // NOI18N
//              + ", t6=" + t6 // NOI18N
//              + ", t7=" + t7 // NOI18N
//              + ", t8=" + t8 // NOI18N
//              + ", t9=" + t9 // NOI18N
//              + ", t10=" + t10; // NOI18N
//  }
//}
///*template <typename T1, typename T2 = char, typename T3 = char, typename T4 = char, typename T5 = char, typename T6 = char, typename T7 = char, typename T8 = char, typename T9 = char, typename T10 = char> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::SizerImpl">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 229,
// FQN="llvm::detail::SizerImpl", NM="_ZN4llvm6detail9SizerImplE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail9SizerImplE")
////</editor-fold>
//public static class/*union*/ SizerImpl</*typename*/ T1, /*typename*/ T2/* = char*/, /*typename*/ T3/* = char*/, /*typename*/ T4/* = char*/, /*typename*/ T5/* = char*/, /*typename*/ T6/* = char*/, /*typename*/ T7/* = char*/, /*typename*/ T8/* = char*/, /*typename*/ T9/* = char*/, /*typename*/ T10/* = char*/>  {
//  public /*char*/byte arr1[$sizeof_T()] = new$char($sizeof_T());
//  public /*char*/byte arr2[$sizeof_T1()] = new$char($sizeof_T1());
//  public /*char*/byte arr3[$sizeof_T2()] = new$char($sizeof_T2());
//  public /*char*/byte arr4[$sizeof_T3()] = new$char($sizeof_T3());
//  public /*char*/byte arr5[$sizeof_T4()] = new$char($sizeof_T4());
//  public /*char*/byte arr6[$sizeof_T5()] = new$char($sizeof_T5());
//  public /*char*/byte arr7[$sizeof_T6()] = new$char($sizeof_T6());
//  public /*char*/byte arr8[$sizeof_T7()] = new$char($sizeof_T7());
//  public /*char*/byte arr9[$sizeof_T8()] = new$char($sizeof_T8());
//  public /*char*/byte arr10[$sizeof_T9()] = new$char($sizeof_T9());
//  
//  @Override public String toString() {
//    return "" + "arr1=" + arr1 // NOI18N
//              + ", arr2=" + arr2 // NOI18N
//              + ", arr3=" + arr3 // NOI18N
//              + ", arr4=" + arr4 // NOI18N
//              + ", arr5=" + arr5 // NOI18N
//              + ", arr6=" + arr6 // NOI18N
//              + ", arr7=" + arr7 // NOI18N
//              + ", arr8=" + arr8 // NOI18N
//              + ", arr9=" + arr9 // NOI18N
//              + ", arr10=" + arr10; // NOI18N
//  }
//}
///// A tiny meta function to compute the log2 of a compile time constant.
///*template <size_t N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::ConstantLog2">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 33,
// FQN="llvm::detail::ConstantLog2", NM="_ZN4llvm6detail12ConstantLog2E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12ConstantLog2E")
////</editor-fold>
//public static class/*struct*/ ConstantLog2</*size_t*/int N>  extends /**/ std.integral_constant</*size_t*/int, ConstantLog2.<$div_uint(N, 2)>value + 1> {
//  
//  @Override public String toString() {
//    return "" + super.toString(); // NOI18N
//  }
//}
////<editor-fold defaultstate="collapsed" desc="llvm::detail::ConstantLog2<1>">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 36,
// FQN="llvm::detail::ConstantLog2<1>", NM="_ZN4llvm6detail12ConstantLog2ILj1EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12ConstantLog2ILj1EEE")
////</editor-fold>
//public static class/*struct*/ ConstantLog2 extends /**/ std.integral_constant</*size_t*/int, 0> {
//  
//  @Override public String toString() {
//    return "" + super.toString(); // NOI18N
//  }
//}
//// We extend a pair to allow users to override the bucket type with their own
//// implementation without requiring two members.
///*template <typename KeyT, typename ValueT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseMapPair">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 38,
// FQN="llvm::detail::DenseMapPair", NM="_ZN4llvm6detail12DenseMapPairE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12DenseMapPairE")
////</editor-fold>
//public static class/*struct*/ DenseMapPair</*typename*/ KeyT, /*typename*/ ValueT>  extends /*public*/ std.pair<KeyT, ValueT> {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseMapPair::getFirst">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 40,
//   FQN="llvm::detail::DenseMapPair::getFirst", NM="_ZN4llvm6detail12DenseMapPair8getFirstEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12DenseMapPair8getFirstEv")
//  //</editor-fold>
//  public KeyT /*&*/ getFirst() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseMapPair::getFirst">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 41,
//   FQN="llvm::detail::DenseMapPair::getFirst", NM="_ZNK4llvm6detail12DenseMapPair8getFirstEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK4llvm6detail12DenseMapPair8getFirstEv")
//  //</editor-fold>
//  public /*const*/ KeyT /*&*/ getFirst$Const() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseMapPair::getSecond">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 42,
//   FQN="llvm::detail::DenseMapPair::getSecond", NM="_ZN4llvm6detail12DenseMapPair9getSecondEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12DenseMapPair9getSecondEv")
//  //</editor-fold>
//  public ValueT /*&*/ getSecond() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseMapPair::getSecond">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 43,
//   FQN="llvm::detail::DenseMapPair::getSecond", NM="_ZNK4llvm6detail12DenseMapPair9getSecondEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK4llvm6detail12DenseMapPair9getSecondEv")
//  //</editor-fold>
//  public /*const*/ ValueT /*&*/ getSecond$Const() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return "" + super.toString(); // NOI18N
//  }
//}
////<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetEmpty">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 22,
// FQN="llvm::detail::DenseSetEmpty", NM="_ZN4llvm6detail13DenseSetEmptyE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail13DenseSetEmptyE")
////</editor-fold>
//public static class/*struct*/ DenseSetEmpty {
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetEmpty::DenseSetEmpty">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 22,
//   FQN="llvm::detail::DenseSetEmpty::DenseSetEmpty", NM="_ZN4llvm6detail13DenseSetEmptyC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail13DenseSetEmptyC1Ev")
//  //</editor-fold>
//  public /*inline*/ DenseSetEmpty() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetEmpty::DenseSetEmpty">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 22,
//   FQN="llvm::detail::DenseSetEmpty::DenseSetEmpty", NM="_ZN4llvm6detail13DenseSetEmptyC1ERKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm6detail13DenseSetEmptyC1ERKS1_")
//  //</editor-fold>
//  public /*inline*/ DenseSetEmpty(final /*const*/ DenseSetEmpty /*&*/ $Prm0) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetEmpty::DenseSetEmpty">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 22,
//   FQN="llvm::detail::DenseSetEmpty::DenseSetEmpty", NM="_ZN4llvm6detail13DenseSetEmptyC1EOS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm6detail13DenseSetEmptyC1EOS1_")
//  //</editor-fold>
//  public /*inline*/ DenseSetEmpty(JD$Move _dparam, final DenseSetEmpty /*&&*/$Prm0) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return ""; // NOI18N
//  }
//}
//
//// Use the empty base class trick so we can create a DenseMap where the buckets
//// contain only a single item.
///*template <typename KeyT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetPair">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 26,
// FQN="llvm::detail::DenseSetPair", NM="_ZN4llvm6detail12DenseSetPairE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12DenseSetPairE")
////</editor-fold>
//public static class DenseSetPair</*typename*/ KeyT>  extends /*public*/ DenseSetEmpty {
//  private KeyT key;
///*public:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetPair::getFirst">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 30,
//   FQN="llvm::detail::DenseSetPair::getFirst", NM="_ZN4llvm6detail12DenseSetPair8getFirstEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12DenseSetPair8getFirstEv")
//  //</editor-fold>
//  public KeyT /*&*/ getFirst() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetPair::getFirst">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 31,
//   FQN="llvm::detail::DenseSetPair::getFirst", NM="_ZNK4llvm6detail12DenseSetPair8getFirstEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK4llvm6detail12DenseSetPair8getFirstEv")
//  //</editor-fold>
//  public /*const*/ KeyT /*&*/ getFirst$Const() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetPair::getSecond">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 32,
//   FQN="llvm::detail::DenseSetPair::getSecond", NM="_ZN4llvm6detail12DenseSetPair9getSecondEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm6detail12DenseSetPair9getSecondEv")
//  //</editor-fold>
//  public DenseSetEmpty /*&*/ getSecond() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::DenseSetPair::getSecond">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 33,
//   FQN="llvm::detail::DenseSetPair::getSecond", NM="_ZNK4llvm6detail12DenseSetPair9getSecondEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK4llvm6detail12DenseSetPair9getSecondEv")
//  //</editor-fold>
//  public /*const*/ DenseSetEmpty /*&*/ getSecond$Const() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return "" + "key=" + key // NOI18N
//              + super.toString(); // NOI18N
//  }
//}
//
//// We call out to an external function to actually print the message as the
//// printing code uses Allocator.h in its implementation.
////<editor-fold defaultstate="collapsed" desc="llvm::detail::printBumpPtrAllocatorStats">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/lib/Support/Allocator.cpp", line = 21,
// FQN="llvm::detail::printBumpPtrAllocatorStats", NM="_ZN4llvm6detail26printBumpPtrAllocatorStatsEjjj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm6detail26printBumpPtrAllocatorStatsEjjj")
////</editor-fold>
//public static void printBumpPtrAllocatorStats(/*uint*/int NumSlabs, /*size_t*/int BytesAllocated, 
//                          /*size_t*/int TotalMemory) {
//  throw new UnsupportedOperationException("EmptyBody");
//}


// Options are keyed of the unique address of a static character synthesized
// based on template arguments.
/*template <typename ValT, typename Base, ValT (Base::*) Mem> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::OptionKey">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Options.h", line = 49,
 FQN="llvm::detail::OptionKey", NM="_ZN4llvm6detail9OptionKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm6detail9OptionKeyE")
//</editor-fold>
public static abstract class OptionKey</*typename*/ ValT/*, typename Base, ValT (Base::*) Mem*/>  {
/*public:*/
//  public static /*char*/byte ID = 0;
  public abstract /*char*/byte $ID();
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//
///// A helper template for implementing \c PointerSumType. It provides fast
///// compile-time lookup of the member from a particular tag value, along with
///// useful constants and compile time checking infrastructure..
///*template <typename TagT, typename ... MemberTs> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 118,
// FQN="llvm::detail::PointerSumTypeHelper", NM="_ZN4llvm6detail20PointerSumTypeHelperE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelperE")
////</editor-fold>
//public static class/*struct*/ PointerSumTypeHelper</*typename*/ TagT, /*typename*/ /*...*/ MemberTs>  extends /**/ MemberTs... {
//  // First we use a trick to allow quickly looking up information about
//  // a particular member of the sum type. This works because we arranged to
//  // have this type derive from all of the member type templates. We can select
//  // the matching member for a tag using type deduction during overload
//  // resolution.
//  /*template <TagT N, typename PointerT, typename TraitsT> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::LookupOverload">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 126,
//   FQN="llvm::detail::PointerSumTypeHelper::LookupOverload", NM="Tpl__ZN4llvm6detail20PointerSumTypeHelper14LookupOverloadEPNS_20PointerSumTypeMemberIXT_ET0_T1_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=Tpl__ZN4llvm6detail20PointerSumTypeHelper14LookupOverloadEPNS_20PointerSumTypeMemberIXT_ET0_T1_EE")
//  //</editor-fold>
//  public static <TagT N, /*typename*/ PointerT, /*typename*/ TraitsT> PointerSumTypeMember<N, PointerT, TraitsT> LookupOverload(PointerSumTypeMember<N, PointerT, TraitsT> /*P*/ $Prm0) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  /*template <TagT N> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::LookupOverload">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 128,
//   FQN="llvm::detail::PointerSumTypeHelper::LookupOverload", NM="Tpl__ZN4llvm6detail20PointerSumTypeHelper14LookupOverloadEz",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=Tpl__ZN4llvm6detail20PointerSumTypeHelper14LookupOverloadEz")
//  //</editor-fold>
//  public static <TagT N> void LookupOverload(Object ... $VarArg) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  /*template <TagT N> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::Lookup">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 129,
//   FQN="llvm::detail::PointerSumTypeHelper::Lookup", NM="_ZN4llvm6detail20PointerSumTypeHelper6LookupE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelper6LookupE")
//  //</editor-fold>
//  public static class/*struct*/ Lookup<TagT N>  {
//    // Compute a particular member type by resolving the lookup helper ovorload.
//    /*typedef decltype(LookupOverload<N>(static_cast<PointerSumTypeHelper<TagT, MemberTs...> *>(null))) MemberT*/
////    public final class MemberT extends decltype(LookupOverload /*P*/ )(null))))<N>(((/*static_cast*/PointerSumTypeHelper<TagT, MemberTs...>{ };
//    
//    /// The Nth member's pointer type.
//    /*typedef typename MemberT::PointerT PointerT*/
////    public final class PointerT extends  decltype(LookupOverload /*P*/ )(null)))).PointerT<N>(((/*static_cast*/PointerSumTypeHelper<TagT, MemberTs...>{ };
//    
//    /// The Nth member's traits type.
//    /*typedef typename MemberT::TraitsT TraitsT*/
////    public final class TraitsT extends  decltype(LookupOverload /*P*/ )(null)))).TraitsT<N>(((/*static_cast*/PointerSumTypeHelper<TagT, MemberTs...>{ };
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
//  
//  // Next we need to compute the number of bits available for the discriminant
//  // by taking the min of the bits available for each member. Much of this
//  // would be amazingly easier with good constexpr support.
//  /*template <uintptr_t V, uintptr_t... Vs> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::Min">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 144,
//   FQN="llvm::detail::PointerSumTypeHelper::Min", NM="_ZN4llvm6detail20PointerSumTypeHelper3MinE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelper3MinE")
//  //</editor-fold>
//  public static class/*struct*/ Min<Object/*uintptr_t*/ V, Object/*uintptr_t*//*...*/ Vs>  extends /**/ std.integral_constant<Object/*uintptr_t*/, (Native.$less(V, Min.<Vs...>value) ? V : Min.<Vs...>value)> {
//    
//    @Override public String toString() {
//      return "" + super.toString(); // NOI18N
//    }
//  };
//  /*template <uintptr_t V> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::Min<V>">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 148,
//   FQN="llvm::detail::PointerSumTypeHelper::Min<V>", NM="_ZN4llvm6detail20PointerSumTypeHelper3MinIXT_EJEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelper3MinIXT_EJEEE")
//  //</editor-fold>
//  public static class/*struct*/ Min<Object/*uintptr_t*/ V>  extends /**/ std.integral_constant<Object/*uintptr_t*/, V> {
//    
//    @Override public String toString() {
//      return "" + super.toString(); // NOI18N
//    }
//  };
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::(anonymous)">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 150,
//   FQN="llvm::detail::PointerSumTypeHelper::(anonymous)", NM="_ZN4llvm6detail20PointerSumTypeHelperE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelperE_Unnamed_enum")
//  //</editor-fold>
//  /*enum ANONYMOUS_INT_CONSTANTS {*/
//    public static final /*<dependent type>*/void NumTagBits = Min.<MemberTs.TraitsT.NumLowBitsAvailable...>value;
//  /*}*/;
//  
//  // Also compute the smallest discriminant and various masks for convenience.
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::(anonymous)">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 153,
//   FQN="llvm::detail::PointerSumTypeHelper::(anonymous)", NM="_ZN4llvm6detail20PointerSumTypeHelperE_Unnamed_enum1",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelperE_Unnamed_enum1")
//  //</editor-fold>
//  public enum Unnamed_enum1/* : uint64_t*/ implements Native.NativeULongEnum {
//    MinTag(Min.<MemberTs.Tag...>value),
//    PointerMask(Native.$out(((/*static_cast*/long/*uint64_t*/)($int2ulong(-1))), NumTagBits)),
//    TagMask(~Unnamed_enum1.PointerMask);
//
//    //<editor-fold defaultstate="collapsed" desc="hidden">
//    public static Unnamed_enum1 valueOf(long/*uint64_t*/ val) {
//      Unnamed_enum1 out = valueOf((int)val);
//      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
//      return out;
//    }
//    public static Unnamed_enum1 valueOf(int val) {
//      Unnamed_enum1 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
//      assert out != null : "no value for " + val;
//      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
//      return out;
//    }
//
//    private static final class Values {
//      private static final Unnamed_enum1[] VALUES;
//      private static final Unnamed_enum1[] _VALUES; // [0] not used
//      static {
//        int max = 0;
//        int min = 0;
//        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
//          if (kind.value > max) { max = kind.value; }
//          if (kind.value < min) { min = kind.value; }
//        }
//        _VALUES = new Unnamed_enum1[min < 0 ? (1-min) : 0];
//        VALUES = new Unnamed_enum1[max >= 0 ? (1+max) : 0];
//        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
//          if (kind.value < 0) {
//            if (_VALUES[-kind.value] == null) {
//              _VALUES[-kind.value] = kind;
//            } else {
//              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
//            }
//          } else {
//            if (VALUES[kind.value] == null) {
//              VALUES[kind.value] = kind;
//            } else {
//              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
//            }
//          }
//        }
//      }
//    }
//
//    private final long/*uint64_t*/ value;
//    private Unnamed_enum1(int val) { this.value = (long/*uint64_t*/)val;}
//    @Override public final long/*uint64_t*/ getValue() { return value;}
//    //</editor-fold>
//  };
//  
//  // Finally we need a recursive template to do static checks of each
//  // member.
//  /*template <typename MemberT, typename ... InnerMemberTs> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::Checker">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 161,
//   FQN="llvm::detail::PointerSumTypeHelper::Checker", NM="_ZN4llvm6detail20PointerSumTypeHelper7CheckerE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelper7CheckerE")
//  //</editor-fold>
//  public static class/*struct*/ Checker</*typename*/ MemberT, /*typename*/ /*...*/ InnerMemberTs>  extends /**/ Checker<InnerMemberTs...> {
//    static { static_assert(Native.$less(MemberT.Tag, (Native.$out(1, NumTagBits))), $("This discriminant value requires too many bits!")); };
//    
//    @Override public String toString() {
//      return "" + super.toString(); // NOI18N
//    }
//  };
//  /*template <typename MemberT> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PointerSumTypeHelper::Checker<type-parameter-1-0>">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerSumType.h", line = 166,
//   FQN="llvm::detail::PointerSumTypeHelper::Checker<type-parameter-1-0>", NM="_ZN4llvm6detail20PointerSumTypeHelper7CheckerIT_JEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm6detail20PointerSumTypeHelper7CheckerIT_JEEE")
//  //</editor-fold>
//  public static class/*struct*/ CheckerT</*typename*/ MemberT>  extends /**/ integral_constant_bool_true {
//    static { static_assert(Native.$less(MemberT.Tag, (Native.$out(1, NumTagBits))), $("This discriminant value requires too many bits!")); };
//    
//    @Override public String toString() {
//      return "" + super.toString(); // NOI18N
//    }
//  };
//  static { static_assert(Checker.<MemberTs...>value, $("Each member must pass the checker.")); };
//
//
//
//
//
//  /*template <uintptr_t V> TEMPLATE*/
//
//
//
//
//
//
//
//
//  /*template <typename MemberT> TEMPLATE*/
//
//  
//  @Override public String toString() {
//    return "" + super.toString(); // NOI18N
//  }
//}
} // END OF class detail
