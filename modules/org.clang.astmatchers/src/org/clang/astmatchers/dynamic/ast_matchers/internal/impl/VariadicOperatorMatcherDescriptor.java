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


/// \brief Variadic operator marshaller function.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 583,
 FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptorE")
//</editor-fold>
public class VariadicOperatorMatcherDescriptor extends /*public*/ MatcherDescriptor implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef DynTypedMatcher::VariadicOperator VarOp*/
//  public final class VarOp extends DynTypedMatcher.VariadicOperator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::VariadicOperatorMatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 586,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::VariadicOperatorMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptorC1EjjNS0_8internal15DynTypedMatcher16VariadicOperatorEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptorC1EjjNS0_8internal15DynTypedMatcher16VariadicOperatorEN4llvm9StringRefE")
  //</editor-fold>
  public VariadicOperatorMatcherDescriptor(/*uint*/int MinCount, /*uint*/int MaxCount, 
      DynTypedMatcher.VariadicOperator Op, StringRef MatcherName) {
    // : MatcherDescriptor(), MinCount(MinCount), MaxCount(MaxCount), Op(Op), MatcherName(MatcherName) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 591,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::create", NM="_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  @Override public VariantMatcher create(SourceRange NameRange, 
        ArrayRef<ParserValue> Args, 
        Diagnostics /*P*/ Error) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::isVariadic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 616,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::isVariadic", NM="_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor10isVariadicEv")
  //</editor-fold>
  @Override public boolean isVariadic() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 617,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::getNumArgs", NM="_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::getArgKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 618,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::getArgKinds", NM="_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE")
  //</editor-fold>
  @Override public void getArgKinds(ASTNodeKind ThisKind, /*uint*/int ArgNo, 
             final std.vector<ArgKind> /*&*/ Kinds) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 622,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_")
  //</editor-fold>
  @Override public boolean isConvertibleTo(ASTNodeKind Kind, uint$ptr/*uint P*/ Specificity, 
                 ASTNodeKind /*P*/ LeastDerivedKind) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::isPolymorphic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 630,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::isPolymorphic", NM="_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor13isPolymorphicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptor13isPolymorphicEv")
  //</editor-fold>
  @Override public boolean isPolymorphic() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*const*//*uint*/int MinCount;
  private /*const*//*uint*/int MaxCount;
  private /*const*/ DynTypedMatcher.VariadicOperator Op;
  private /*const*/ StringRef MatcherName;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::~VariadicOperatorMatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 583,
   FQN="clang::ast_matchers::dynamic::internal::VariadicOperatorMatcherDescriptor::~VariadicOperatorMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal33VariadicOperatorMatcherDescriptorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "MinCount=" + MinCount // NOI18N
              + ", MaxCount=" + MaxCount // NOI18N
              + ", Op=" + Op // NOI18N
              + ", MatcherName=" + MatcherName // NOI18N
              + super.toString(); // NOI18N
  }
}
