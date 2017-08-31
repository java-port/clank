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
package org.clang.astmatchers.ast_matchers.internal.impl;

import org.clang.astmatchers.dynamic.ast_matchers.impl.llvm.TrueMatcherImplInfo;
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
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.basic.SourceManager;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type InternalStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_10RecordDeclERN4llvm11SmallStringILj128EEE;_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_13NamespaceDeclERN4llvm11SmallStringILj128EEE;_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_9NamedDeclERN4llvm11SmallStringILj128EEE;_ZN5clang12ast_matchers8internal12_GLOBAL__N_117consumeNameSuffixERN4llvm9StringRefES4_;_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L19TrueMatcherInstanceE;_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L21MaxMemoizationEntriesE;_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L35getAsCXXRecordDeclOrPrimaryTemplateEPKNS_4TypeE;_ZN5clang12ast_matchers8internal16NotUnaryOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE;_ZN5clang12ast_matchers8internal21AllOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE;_ZN5clang12ast_matchers8internal21AnyOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE;_ZN5clang12ast_matchers8internal22EachOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE; -static-type=InternalStatics -package=org.clang.astmatchers.ast_matchers.internal.impl -empty-body")
//</editor-fold>
public final class InternalStatics {


// The maximum number of memoization entries to store.
// 10k has been experimentally found to give a good trade-off
// of performance vs. memory consumption by running matcher
// that match on every statement over a very large codebase.
//
// FIXME: Do some performance optimization in general and
// revisit this number; also, put up micro-benchmarks that we can
// optimize this on.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MaxMemoizationEntries">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 45,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::MaxMemoizationEntries", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L21MaxMemoizationEntriesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L21MaxMemoizationEntriesE")
//</editor-fold>
public static /*const*//*uint*/int MaxMemoizationEntries = 10000;
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::getAsCXXRecordDeclOrPrimaryTemplate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 758,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::getAsCXXRecordDeclOrPrimaryTemplate", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L35getAsCXXRecordDeclOrPrimaryTemplateEPKNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L35getAsCXXRecordDeclOrPrimaryTemplateEPKNS_4TypeE")
//</editor-fold>
public static CXXRecordDecl /*P*/ getAsCXXRecordDeclOrPrimaryTemplate(/*const*/ Type /*P*/ TypeNode) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::NotUnaryOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 232,
 FQN="clang::ast_matchers::internal::NotUnaryOperator", NM="_ZN5clang12ast_matchers8internal16NotUnaryOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal16NotUnaryOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE")
//</editor-fold>
public static boolean NotUnaryOperator(final /*const*/ DynTypedNode /*&*/ DynNode, 
                ASTMatchFinder /*P*/ Finder, BoundNodesTreeBuilder /*P*/ Builder, 
                ArrayRef<DynTypedMatcher> InnerMatchers) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::AllOfVariadicOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 252,
 FQN="clang::ast_matchers::internal::AllOfVariadicOperator", NM="_ZN5clang12ast_matchers8internal21AllOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal21AllOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE")
//</editor-fold>
public static boolean AllOfVariadicOperator(final /*const*/ DynTypedNode /*&*/ DynNode, 
                     ASTMatchFinder /*P*/ Finder, 
                     BoundNodesTreeBuilder /*P*/ Builder, 
                     ArrayRef<DynTypedMatcher> InnerMatchers) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::EachOfVariadicOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 266,
 FQN="clang::ast_matchers::internal::EachOfVariadicOperator", NM="_ZN5clang12ast_matchers8internal22EachOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal22EachOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE")
//</editor-fold>
public static boolean EachOfVariadicOperator(final /*const*/ DynTypedNode /*&*/ DynNode, 
                      ASTMatchFinder /*P*/ Finder, 
                      BoundNodesTreeBuilder /*P*/ Builder, 
                      ArrayRef<DynTypedMatcher> InnerMatchers) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::AnyOfVariadicOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 283,
 FQN="clang::ast_matchers::internal::AnyOfVariadicOperator", NM="_ZN5clang12ast_matchers8internal21AnyOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal21AnyOfVariadicOperatorERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEN4llvm8ArrayRefINS1_15DynTypedMatcherEEE")
//</editor-fold>
public static boolean AnyOfVariadicOperator(final /*const*/ DynTypedNode /*&*/ DynNode, 
                     ASTMatchFinder /*P*/ Finder, 
                     BoundNodesTreeBuilder /*P*/ Builder, 
                     ArrayRef<DynTypedMatcher> InnerMatchers) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::TrueMatcherInstance">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 108,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::TrueMatcherInstance", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L19TrueMatcherInstanceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_1L19TrueMatcherInstanceE")
//</editor-fold>
public static ManagedStatic<TrueMatcherImpl> TrueMatcherInstance/*J*/= new ManagedStatic<TrueMatcherImpl>(new TrueMatcherImplInfo());
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::consumeNameSuffix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 318,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::consumeNameSuffix", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_117consumeNameSuffixERN4llvm9StringRefES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_117consumeNameSuffixERN4llvm9StringRefES4_")
//</editor-fold>
public static boolean consumeNameSuffix(final StringRef /*&*/ FullName, StringRef Suffix) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::getNodeName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 332,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::getNodeName", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_9NamedDeclERN4llvm11SmallStringILj128EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_9NamedDeclERN4llvm11SmallStringILj128EEE")
//</editor-fold>
public static StringRef getNodeName_NamedDecl$C_SmallString(final /*const*/ NamedDecl /*&*/ Node, final SmallString/*128*/ /*&*/ Scratch) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::getNodeName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 348,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::getNodeName", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_10RecordDeclERN4llvm11SmallStringILj128EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_10RecordDeclERN4llvm11SmallStringILj128EEE")
//</editor-fold>
public static StringRef getNodeName_RecordDecl$C_SmallString(final /*const*/ RecordDecl /*&*/ Node, final SmallString/*128*/ /*&*/ Scratch) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::getNodeName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 356,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::getNodeName", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_13NamespaceDeclERN4llvm11SmallStringILj128EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_111getNodeNameERKNS_13NamespaceDeclERN4llvm11SmallStringILj128EEE")
//</editor-fold>
public static StringRef getNodeName_NamespaceDecl$C_SmallString(final /*const*/ NamespaceDecl /*&*/ Node, 
                                       final SmallString/*128*/ /*&*/ Scratch) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InternalStatics
