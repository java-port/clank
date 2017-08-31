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


/// \brief Helper class used to collect all the possible overloads of an
///   argument adaptative matcher function.
/*template <template <typename ToArg, typename FromArg> class ArgumentAdapterT, typename FromTypes, typename ToTypes> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 479,
 FQN="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector", NM="_ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollectorE")
//</editor-fold>
public class AdaptativeOverloadCollector</*template <typename ToArg, typename FromArg> TEMPLATE*/
/*class */ArgumentAdapterT, /*typename*/ FromTypes, /*typename*/ ToTypes>  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector::AdaptativeOverloadCollector<ArgumentAdapterT, FromTypes, ToTypes>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 483,
   FQN="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector::AdaptativeOverloadCollector<ArgumentAdapterT, FromTypes, ToTypes>", NM="_ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollectorC1EN4llvm9StringRefERSt6vectorIPNS2_17MatcherDescriptorESaIS8_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollectorC1EN4llvm9StringRefERSt6vectorIPNS2_17MatcherDescriptorESaIS8_EE")
  //</editor-fold>
  public AdaptativeOverloadCollector(StringRef Name, 
      final std.vector<MatcherDescriptor /*P*/ > /*&*/ Out) {
    // : Name(Name), Out(Out) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /*typedef ast_matchers::internal::ArgumentAdaptingMatcherFunc<ArgumentAdapterT, FromTypes, ToTypes> AdaptativeFunc*/
//  public final class AdaptativeFunc extends ArgumentAdaptingMatcherFunc<ArgumentAdapterT, FromTypes, ToTypes>{ };
  
  /// \brief End case for the recursion
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector::collect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 494,
   FQN="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector::collect", NM="_ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollector7collectENS0_8internal8TypeListIJEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollector7collectENS0_8internal8TypeListIJEEE")
  //</editor-fold>
  private static void collect(TypeList $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Recursive case. Get the overload for the head of the list, and
  ///   recurse to the tail.
  /*template <typename FromTypeList> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector::collect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 712,
   FQN="clang::ast_matchers::dynamic::internal::AdaptativeOverloadCollector::collect", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollector7collectET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal27AdaptativeOverloadCollector7collectET_")
  //</editor-fold>
  private /*inline*/ </*typename*/ FromTypeList> void collect$T(FromTypeList $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private StringRef Name;
  private final std.vector<MatcherDescriptor /*P*/ > /*&*/ Out;
  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Out=" + Out; // NOI18N
  }
}
