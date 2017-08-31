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

package org.clang.astmatchers.dynamic.ast_matchers;

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


/// \brief Variant value class.
///
/// Basically, a tagged union with value type semantics.
/// It is used by the registry as the return value and argument type for the
/// matcher factory methods.
/// It can be constructed from any of the supported types. It supports
/// copy/assignment.
///
/// Supported types:
///  - \c unsigned
///  - \c llvm::StringRef
///  - \c VariantMatcher (\c DynTypedMatcher / \c Matcher<T>)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 247,
 FQN="clang::ast_matchers::dynamic::VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueE")
//</editor-fold>
public class VariantValue implements Destructors.ClassWithDestructor, Native.Native$Bool  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::VariantValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 249,
   FQN="clang::ast_matchers::dynamic::VariantValue::VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueC1Ev")
  //</editor-fold>
  public VariantValue() {
    // : Type(VT_Nothing), Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::VariantValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 244,
   FQN="clang::ast_matchers::dynamic::VariantValue::VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueC1ERKS2_")
  //</editor-fold>
  public VariantValue(final /*const*/ VariantValue /*&*/ Other) {
    // : Type(VT_Nothing), Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::~VariantValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 260,
   FQN="clang::ast_matchers::dynamic::VariantValue::~VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 262,
   FQN="clang::ast_matchers::dynamic::VariantValue::operator=", NM="_ZN5clang12ast_matchers7dynamic12VariantValueaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueaSERKS2_")
  //</editor-fold>
  public VariantValue /*&*/ $assign(final /*const*/ VariantValue /*&*/ Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Specific constructors for each supported type.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::VariantValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 248,
   FQN="clang::ast_matchers::dynamic::VariantValue::VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueC1Ej")
  //</editor-fold>
  public VariantValue(/*uint*/int Unsigned) {
    // : Type(VT_Nothing), Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::VariantValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 252,
   FQN="clang::ast_matchers::dynamic::VariantValue::VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueC1EN4llvm9StringRefE")
  //</editor-fold>
  public VariantValue(StringRef String) {
    // : Type(VT_Nothing), Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::VariantValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 256,
   FQN="clang::ast_matchers::dynamic::VariantValue::VariantValue", NM="_ZN5clang12ast_matchers7dynamic12VariantValueC1ERKNS1_14VariantMatcherE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValueC1ERKNS1_14VariantMatcherE")
  //</editor-fold>
  public VariantValue(final /*const*/ VariantMatcher /*&*/ Matcher) {
    // : Type(VT_Nothing), Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns true iff this is not an empty value.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::operator bool">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 261,
   FQN="clang::ast_matchers::dynamic::VariantValue::operator bool", NM="_ZNK5clang12ast_matchers7dynamic12VariantValuecvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValuecvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::hasValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 262,
   FQN="clang::ast_matchers::dynamic::VariantValue::hasValue", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue8hasValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue8hasValueEv")
  //</editor-fold>
  public boolean hasValue() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Unsigned value functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 298,
   FQN="clang::ast_matchers::dynamic::VariantValue::isUnsigned", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue10isUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue10isUnsignedEv")
  //</editor-fold>
  public boolean isUnsigned() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::getUnsigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 302,
   FQN="clang::ast_matchers::dynamic::VariantValue::getUnsigned", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue11getUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue11getUnsignedEv")
  //</editor-fold>
  public /*uint*/int getUnsigned() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::setUnsigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 307,
   FQN="clang::ast_matchers::dynamic::VariantValue::setUnsigned", NM="_ZN5clang12ast_matchers7dynamic12VariantValue11setUnsignedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue11setUnsignedEj")
  //</editor-fold>
  public void setUnsigned(/*uint*/int NewValue) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief String value functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::isString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 313,
   FQN="clang::ast_matchers::dynamic::VariantValue::isString", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue8isStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue8isStringEv")
  //</editor-fold>
  public boolean isString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::getString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 317,
   FQN="clang::ast_matchers::dynamic::VariantValue::getString", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue9getStringEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::setString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 322,
   FQN="clang::ast_matchers::dynamic::VariantValue::setString", NM="_ZN5clang12ast_matchers7dynamic12VariantValue9setStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue9setStringEN4llvm9StringRefE")
  //</editor-fold>
  public void setString(StringRef NewValue) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Matcher value functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::isMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 328,
   FQN="clang::ast_matchers::dynamic::VariantValue::isMatcher", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue9isMatcherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue9isMatcherEv")
  //</editor-fold>
  public boolean isMatcher() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::getMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 332,
   FQN="clang::ast_matchers::dynamic::VariantValue::getMatcher", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue10getMatcherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue10getMatcherEv")
  //</editor-fold>
  public /*const*/ VariantMatcher /*&*/ getMatcher() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::setMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 337,
   FQN="clang::ast_matchers::dynamic::VariantValue::setMatcher", NM="_ZN5clang12ast_matchers7dynamic12VariantValue10setMatcherERKNS1_14VariantMatcherE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue10setMatcherERKNS1_14VariantMatcherE")
  //</editor-fold>
  public void setMatcher(final /*const*/ VariantMatcher /*&*/ NewValue) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Determines if the contained value can be converted to \p Kind.
  ///
  /// \param Kind the requested destination type.
  ///
  /// \param Specificity value corresponding to the "specificity" of the
  ///   convertion.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 343,
   FQN="clang::ast_matchers::dynamic::VariantValue::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue15isConvertibleToENS1_7ArgKindEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue15isConvertibleToENS1_7ArgKindEPj")
  //</editor-fold>
  public boolean isConvertibleTo(ArgKind Kind, uint$ptr/*uint P*/ Specificity) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Determines if the contained value can be converted to any kind
  /// in \p Kinds.
  ///
  /// \param Kinds the requested destination types.
  ///
  /// \param Specificity value corresponding to the "specificity" of the
  ///   convertion. It is the maximum specificity of all the possible
  ///   conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 365,
   FQN="clang::ast_matchers::dynamic::VariantValue::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue15isConvertibleToEN4llvm8ArrayRefINS1_7ArgKindEEEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue15isConvertibleToEN4llvm8ArrayRefINS1_7ArgKindEEEPj")
  //</editor-fold>
  public boolean isConvertibleTo(ArrayRef<ArgKind> Kinds, 
                 uint$ptr/*uint P*/ Specificity) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief String representation of the type of the value.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::getTypeAsString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 380,
   FQN="clang::ast_matchers::dynamic::VariantValue::getTypeAsString", NM="_ZNK5clang12ast_matchers7dynamic12VariantValue15getTypeAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic12VariantValue15getTypeAsStringEv")
  //</editor-fold>
  public std.string getTypeAsString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::reset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 282,
   FQN="clang::ast_matchers::dynamic::VariantValue::reset", NM="_ZN5clang12ast_matchers7dynamic12VariantValue5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue5resetEv")
  //</editor-fold>
  private void reset() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief All supported value types.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::ValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 304,
   FQN="clang::ast_matchers::dynamic::VariantValue::ValueType", NM="_ZN5clang12ast_matchers7dynamic12VariantValue9ValueTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue9ValueTypeE")
  //</editor-fold>
  private enum ValueType implements Native.ComparableLower {
    VT_Nothing(0),
    VT_Unsigned(VT_Nothing.getValue() + 1),
    VT_String(VT_Unsigned.getValue() + 1),
    VT_Matcher(VT_String.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ValueType valueOf(int val) {
      ValueType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ValueType[] VALUES;
      private static final ValueType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ValueType kind : ValueType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ValueType[min < 0 ? (1-min) : 0];
        VALUES = new ValueType[max >= 0 ? (1+max) : 0];
        for (ValueType kind : ValueType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ValueType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ValueType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ValueType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief All supported value types.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::AllValues">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 312,
   FQN="clang::ast_matchers::dynamic::VariantValue::AllValues", NM="_ZN5clang12ast_matchers7dynamic12VariantValue9AllValuesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue9AllValuesE")
  //</editor-fold>
  private static class/*union*/ AllValues {
    public /*uint*/int Unsigned;
    public std.string/*P*/ String;
    public VariantMatcher /*P*/ Matcher;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantValue::AllValues::AllValues">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 312,
     FQN="clang::ast_matchers::dynamic::VariantValue::AllValues::AllValues", NM="_ZN5clang12ast_matchers7dynamic12VariantValue9AllValuesC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic12VariantValue9AllValuesC1Ev")
    //</editor-fold>
    public /*inline*/ AllValues() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Unsigned=" + Unsigned // NOI18N
                + ", String=" + String // NOI18N
                + ", Matcher=" + Matcher; // NOI18N
    }
  };
  
  private ValueType Type;
  private AllValues Value;
  
  @Override public String toString() {
    return "" + "Type=" + Type // NOI18N
              + ", Value=" + Value; // NOI18N
  }
}
