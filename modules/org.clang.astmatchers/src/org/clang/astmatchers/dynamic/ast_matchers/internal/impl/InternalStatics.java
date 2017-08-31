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
package org.clang.astmatchers.dynamic.ast_matchers.internal.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.ASTMatchersInternalGlobals.TypeList;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;
import org.llvm.adt.ADTFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type InternalStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal16VariadicFunctionIT_T0_XT1_EEEN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27ArgumentAdaptingMatcherFuncIT_T0_T1_EEN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27VariadicDynCastAllOfMatcherIT_T0_EEN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27VariadicOperatorMatcherFuncIXT_EXT0_EEEN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_T0_EN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_T0_T1_EN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_vEN4llvm9StringRefE;Tpl__ZN5clang12ast_matchers7dynamic8internal25variadicMatcherDescriptorEN4llvm9StringRefENS1_11SourceRangeENS3_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE;Tpl__ZN5clang12ast_matchers7dynamic8internal33buildReturnTypeVectorFromTypeListERSt6vectorINS_15ast_type_traits11ASTNodeKindESaIS5_EE;Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall0EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE;Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall1EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE;Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall2EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE;Tpl__ZN5clang12ast_matchers7dynamic8internalL17mergePolyMatchersERKT_RSt6vectorINS0_8internal15DynTypedMatcherESaIS8_EENS7_8TypeListIJEEE;Tpl__ZN5clang12ast_matchers7dynamic8internalL17mergePolyMatchersERKT_RSt6vectorINS0_8internal15DynTypedMatcherESaIS8_EET0_;Tpl__ZN5clang12ast_matchers7dynamic8internalL24outvalueToVariantMatcherERKT_PNS3_11ReturnTypesE;_ZN5clang12ast_matchers7dynamic8internal22isRetKindConvertibleToEN4llvm8ArrayRefINS_15ast_type_traits11ASTNodeKindEEES6_PjPS6_;_ZN5clang12ast_matchers7dynamic8internal33buildReturnTypeVectorFromTypeListINS0_8internal8TypeListIJEEEEEvRSt6vectorINS_15ast_type_traits11ASTNodeKindESaIS9_EE;_ZN5clang12ast_matchers7dynamic8internalL24outvalueToVariantMatcherERKNS0_8internal15DynTypedMatcherE; -static-type=InternalStatics -package=org.clang.astmatchers.dynamic.ast_matchers.internal.impl")
//</editor-fold>
public final class InternalStatics {

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::isRetKindConvertibleTo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 162,
 FQN="clang::ast_matchers::dynamic::internal::isRetKindConvertibleTo", NM="_ZN5clang12ast_matchers7dynamic8internal22isRetKindConvertibleToEN4llvm8ArrayRefINS_15ast_type_traits11ASTNodeKindEEES6_PjPS6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal22isRetKindConvertibleToEN4llvm8ArrayRefINS_15ast_type_traits11ASTNodeKindEEES6_PjPS6_")
//</editor-fold>
public static /*inline*/ boolean isRetKindConvertibleTo(ArrayRef<ASTNodeKind> RetKinds, 
                      ASTNodeKind Kind, uint$ptr/*uint P*/ Specificity, 
                      ASTNodeKind /*P*/ LeastDerivedKind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Helper methods to extract and merge all possible typed matchers
/// out of the polymorphic object.
/*template <class PolyMatcher> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::mergePolyMatchers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 234,
 FQN="clang::ast_matchers::dynamic::internal::mergePolyMatchers", NM="Tpl__ZN5clang12ast_matchers7dynamic8internalL17mergePolyMatchersERKT_RSt6vectorINS0_8internal15DynTypedMatcherESaIS8_EENS7_8TypeListIJEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internalL17mergePolyMatchersERKT_RSt6vectorINS0_8internal15DynTypedMatcherESaIS8_EENS7_8TypeListIJEEE")
//</editor-fold>
public static </*class*/ PolyMatcher> void mergePolyMatchers_T$C$R_vector$DynTypedMatcher_TypeList(final /*const*/ PolyMatcher /*&*/ Poly, 
                                                       final std.vector<DynTypedMatcher> /*&*/ Out, 
                                                       TypeList $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class PolyMatcher, class TypeList> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::mergePolyMatchers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 239,
 FQN="clang::ast_matchers::dynamic::internal::mergePolyMatchers", NM="Tpl__ZN5clang12ast_matchers7dynamic8internalL17mergePolyMatchersERKT_RSt6vectorINS0_8internal15DynTypedMatcherESaIS8_EET0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internalL17mergePolyMatchersERKT_RSt6vectorINS0_8internal15DynTypedMatcherESaIS8_EET0_")
//</editor-fold>
public static </*class*/ PolyMatcher, /*class*/ TypeList> void mergePolyMatchers_T$C$R_vector$DynTypedMatcher_T1(final /*const*/ PolyMatcher /*&*/ Poly, 
                                                 final std.vector<DynTypedMatcher> /*&*/ Out, TypeList $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Convert the return values of the functions into a VariantMatcher.
///
/// There are 2 cases right now: The return value is a Matcher<T> or is a
/// polymorphic matcher. For the former, we just construct the VariantMatcher.
/// For the latter, we instantiate all the possible Matcher<T> of the poly
/// matcher.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::outvalueToVariantMatcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 251,
 FQN="clang::ast_matchers::dynamic::internal::outvalueToVariantMatcher", NM="_ZN5clang12ast_matchers7dynamic8internalL24outvalueToVariantMatcherERKNS0_8internal15DynTypedMatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internalL24outvalueToVariantMatcherERKNS0_8internal15DynTypedMatcherE")
//</editor-fold>
public static VariantMatcher outvalueToVariantMatcher(final /*const*/ DynTypedMatcher /*&*/ Matcher) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::outvalueToVariantMatcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 256,
 FQN="clang::ast_matchers::dynamic::internal::outvalueToVariantMatcher", NM="Tpl__ZN5clang12ast_matchers7dynamic8internalL24outvalueToVariantMatcherERKT_PNS3_11ReturnTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internalL24outvalueToVariantMatcherERKT_PNS3_11ReturnTypesE")
//</editor-fold>
public static </*typename*/ T> VariantMatcher outvalueToVariantMatcher$T(final /*const*/ T /*&*/ PolyMatcher) {
  return outvalueToVariantMatcher$T(PolyMatcher, 
                          null);
}
public static </*typename*/ T, ReturnTypes> VariantMatcher outvalueToVariantMatcher$T(final /*const*/ T /*&*/ PolyMatcher, 
                           /*T.*/ReturnTypes /*P*/ $Prm1/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::buildReturnTypeVectorFromTypeList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 266,
 FQN="clang::ast_matchers::dynamic::internal::buildReturnTypeVectorFromTypeList", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal33buildReturnTypeVectorFromTypeListERSt6vectorINS_15ast_type_traits11ASTNodeKindESaIS5_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal33buildReturnTypeVectorFromTypeListERSt6vectorINS_15ast_type_traits11ASTNodeKindESaIS5_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> void buildReturnTypeVectorFromTypeList(final std.vector<ASTNodeKind> /*&*/ RetTypes) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::buildReturnTypeVectorFromTypeList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 273,
 FQN="clang::ast_matchers::dynamic::internal::buildReturnTypeVectorFromTypeList", NM="_ZN5clang12ast_matchers7dynamic8internal33buildReturnTypeVectorFromTypeListINS0_8internal8TypeListIJEEEEEvRSt6vectorINS_15ast_type_traits11ASTNodeKindESaIS9_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal33buildReturnTypeVectorFromTypeListINS0_8internal8TypeListIJEEEEEvRSt6vectorINS_15ast_type_traits11ASTNodeKindESaIS9_EE")
//</editor-fold>
public static /*inline*/ void buildReturnTypeVectorFromTypeList_vector$ASTNodeKind(final std.vector<ASTNodeKind> /*&*/ RetTypes) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Variadic marshaller function.
/*template <typename ResultT, typename ArgT, ResultT (*)(ArrayRef<const ArgT *>) Func> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::variadicMatcherDescriptor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 302,
 FQN="clang::ast_matchers::dynamic::internal::variadicMatcherDescriptor", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal25variadicMatcherDescriptorEN4llvm9StringRefENS1_11SourceRangeENS3_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal25variadicMatcherDescriptorEN4llvm9StringRefENS1_11SourceRangeENS3_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
//</editor-fold>
public static </*typename*/ ResultT, /*typename*/ ArgT, Func extends ArrayRefOfPtrs2ResultType<ArgT, ResultT> > VariantMatcher variadicMatcherDescriptor(StringRef MatcherName, SourceRange NameRange, 
                         ArrayRef<ParserValue> Args, Diagnostics /*P*/ Error) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief 0-arg marshaller function.
/*template <typename ReturnType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::matcherMarshall0">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 437,
 FQN="clang::ast_matchers::dynamic::internal::matcherMarshall0", NM="Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall0EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall0EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
//</editor-fold>
public static </*typename*/ ReturnType> VariantMatcher matcherMarshall0(Void2Void Func, StringRef MatcherName, 
                SourceRange NameRange, 
                ArrayRef<ParserValue> Args, 
                Diagnostics /*P*/ Error) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief 1-arg marshaller function.
/*template <typename ReturnType, typename ArgType1> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::matcherMarshall1">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 448,
 FQN="clang::ast_matchers::dynamic::internal::matcherMarshall1", NM="Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall1EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall1EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
//</editor-fold>
public static </*typename*/ ReturnType, /*typename*/ ArgType1> VariantMatcher matcherMarshall1(Void2Void Func, StringRef MatcherName, 
                SourceRange NameRange, 
                ArrayRef<ParserValue> Args, 
                Diagnostics /*P*/ Error) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief 2-arg marshaller function.
/*template <typename ReturnType, typename ArgType1, typename ArgType2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::matcherMarshall2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 461,
 FQN="clang::ast_matchers::dynamic::internal::matcherMarshall2", NM="Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall2EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internalL16matcherMarshall2EPFvvEN4llvm9StringRefENS1_11SourceRangeENS5_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
//</editor-fold>
public static </*typename*/ ReturnType, /*typename*/ ArgType1, /*typename*/ ArgType2> VariantMatcher matcherMarshall2(Void2Void Func, StringRef MatcherName, 
                SourceRange NameRange, 
                ArrayRef<ParserValue> Args, 
                Diagnostics /*P*/ Error) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper functions to select the appropriate marshaller functions.
/// They detect the number of arguments, arguments types and return type.

/// \brief 0-arg overload
/*template <typename ReturnType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 644,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_vEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_vEN4llvm9StringRefE")
//</editor-fold>
public static </*typename*/ ReturnType> MatcherDescriptor /*P*/ makeMatcherAutoMarshall(Void2RetType<ReturnType> Func, 
                       StringRef MatcherName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief 1-arg overload
/*template <typename ReturnType, typename ArgType1> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 655,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_T0_EN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_T0_EN4llvm9StringRefE")
//</editor-fold>
public static </*typename*/ ReturnType, /*typename*/ ArgType1> MatcherDescriptor /*P*/ makeMatcherAutoMarshall(Type2RetType<ArgType1, ReturnType> Func, 
                       StringRef MatcherName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief 2-arg overload
/*template <typename ReturnType, typename ArgType1, typename ArgType2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 667,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_T0_T1_EN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallEPFT_T0_T1_EN4llvm9StringRefE")
//</editor-fold>
public static </*typename*/ ReturnType, /*typename*/ ArgType1, /*typename*/ ArgType2> MatcherDescriptor /*P*/ makeMatcherAutoMarshall(TwoTypes2RetType<ArgType1, ArgType2, ReturnType> Func, 
                       StringRef MatcherName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Variadic overload.
/*template <typename ResultT, typename ArgT, ResultT (*)(ArrayRef<const ArgT *>) Func> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 681,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal16VariadicFunctionIT_T0_XT1_EEEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal16VariadicFunctionIT_T0_XT1_EEEN4llvm9StringRefE")
//</editor-fold>
public static </*typename*/ ResultT, /*typename*/ ArgT/*, Func extends ArrayRefOfPtrs2ResultType<ArgT, ResultT>*/ > MatcherDescriptor /*P*/ makeMatcherAutoMarshall(VariadicFunction<ResultT, ArgT/*, Func*/> VarFunc, 
                       StringRef MatcherName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overload for VariadicDynCastAllOfMatchers.
///
/// Not strictly necessary, but DynCastAllOfMatcherDescriptor gives us better
/// completion results for that type of matcher.
/*template <typename BaseT, typename DerivedT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 692,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27VariadicDynCastAllOfMatcherIT_T0_EEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27VariadicDynCastAllOfMatcherIT_T0_EEN4llvm9StringRefE")
//</editor-fold>
public static </*typename*/ BaseT, /*typename*/ DerivedT> MatcherDescriptor /*P*/ makeMatcherAutoMarshall(VariadicDynCastAllOfMatcher<BaseT, DerivedT> VarFunc, 
                       StringRef MatcherName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Argument adaptative overload.
/*template <template <typename ToArg, typename FromArg> class ArgumentAdapterT, typename FromTypes, typename ToTypes> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 702,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27ArgumentAdaptingMatcherFuncIT_T0_T1_EEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27ArgumentAdaptingMatcherFuncIT_T0_T1_EEN4llvm9StringRefE")
//</editor-fold>
public static </*template <typename ToArg, typename FromArg> TEMPLATE*/
/*class*/ ArgumentAdapterT, /*typename*/ FromTypes, /*typename*/ ToTypes> MatcherDescriptor /*P*/ makeMatcherAutoMarshall(ArgumentAdaptingMatcherFunc<ArgumentAdapterT, FromTypes, ToTypes> $Prm0, 
                       StringRef MatcherName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Variadic operator overload.
/*template <unsigned int MinCount, unsigned int MaxCount> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 724,
 FQN="clang::ast_matchers::dynamic::internal::makeMatcherAutoMarshall", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27VariadicOperatorMatcherFuncIXT_EXT0_EEEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal23makeMatcherAutoMarshallENS0_8internal27VariadicOperatorMatcherFuncIXT_EXT0_EEEN4llvm9StringRefE")
//</editor-fold>
public static /*<uint MinCount, uint MaxCount>*/ MatcherDescriptor /*P*/ makeMatcherAutoMarshall(VariadicOperatorMatcherFunc/*<MinCount, MaxCount>*/ Func, 
                       StringRef MatcherName, /*uint*/int MinCount, /*uint*/int MaxCount) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InternalStatics
