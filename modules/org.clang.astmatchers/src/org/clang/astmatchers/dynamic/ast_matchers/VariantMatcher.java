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


/// \brief A variant matcher object.
///
/// The purpose of this object is to abstract simple and polymorphic matchers
/// into a single object type.
/// Polymorphic matchers might be implemented as a list of all the possible
/// overloads of the matcher. \c VariantMatcher knows how to select the
/// appropriate overload when needed.
/// To get a real matcher object out of a \c VariantMatcher you can do:
///  - getSingleMatcher() which returns a matcher, only if it is not ambiguous
///    to decide which matcher to return. Eg. it contains only a single
///    matcher, or a polymorphic one with only one overload.
///  - hasTypedMatcher<T>()/getTypedMatcher<T>(): These calls will determine if
///    the underlying matcher(s) can unambiguously return a Matcher<T>.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 92,
 FQN="clang::ast_matchers::dynamic::VariantMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcherE")
//</editor-fold>
public class VariantMatcher implements Destructors.ClassWithDestructor {
  /// \brief Methods that depend on T from hasTypedMatcher/getTypedMatcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 94,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher10MatcherOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher10MatcherOpsE")
  //</editor-fold>
  private abstract static class MatcherOps implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::MatcherOps">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 96,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::MatcherOps", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher10MatcherOpsC1ENS_15ast_type_traits11ASTNodeKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher10MatcherOpsC1ENS_15ast_type_traits11ASTNodeKindE")
    //</editor-fold>
    public MatcherOps(ASTNodeKind NodeKind) {
      // : NodeKind(NodeKind) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::canConstructFrom">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 52,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::canConstructFrom", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher10MatcherOps16canConstructFromERKNS0_8internal15DynTypedMatcherERb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher10MatcherOps16canConstructFromERKNS0_8internal15DynTypedMatcherERb")
    //</editor-fold>
    public boolean canConstructFrom(final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                    final bool$ref/*bool &*/ IsExactMatch) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    /// \brief Convert \p Matcher the destination type and return it as a new
    /// DynTypedMatcher.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::convertMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 103,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::convertMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher10MatcherOps14convertMatcherERKNS0_8internal15DynTypedMatcherE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher10MatcherOps14convertMatcherERKNS0_8internal15DynTypedMatcherE")
    //</editor-fold>
    public abstract /*virtual*/ DynTypedMatcher convertMatcher(final /*const*/ DynTypedMatcher /*&*/ Matcher) /*const*//* = 0*/;

    
    /// \brief Constructs a variadic typed matcher from \p InnerMatchers.
    /// Will try to convert each inner matcher to the destination type and
    /// return llvm::None if it fails to do so.
    
    /// \brief Constructs a variadic typed matcher from \p InnerMatchers.
    /// Will try to convert each inner matcher to the destination type and
    /// return llvm::None if it fails to do so.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::constructVariadicOperator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 59,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::constructVariadicOperator", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher10MatcherOps25constructVariadicOperatorENS0_8internal15DynTypedMatcher16VariadicOperatorEN4llvm8ArrayRefIS2_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher10MatcherOps25constructVariadicOperatorENS0_8internal15DynTypedMatcher16VariadicOperatorEN4llvm8ArrayRefIS2_EE")
    //</editor-fold>
    public Optional<DynTypedMatcher> constructVariadicOperator(DynTypedMatcher.VariadicOperator Op, 
                             ArrayRef<VariantMatcher> InnerMatchers) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


  /*protected:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::~MatcherOps">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 114,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::MatcherOps::~MatcherOps", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher10MatcherOpsD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher10MatcherOpsD0Ev")
    //</editor-fold>
    public/*protected*/ void $destroy()/* = default*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private ASTNodeKind NodeKind;
    
    @Override public String toString() {
      return "" + "NodeKind=" + NodeKind; // NOI18N
    }
  };
  
  /// \brief Payload interface to be specialized by each matcher type.
  ///
  /// It follows a similar interface as VariantMatcher itself.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 123,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher7PayloadE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher7PayloadE")
  //</editor-fold>
  private abstract static class Payload extends /*public*/ RefCountedBaseVPTR implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload::~Payload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 78,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload::~Payload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher7PayloadD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher7PayloadD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload::getSingleMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 126,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload::getSingleMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload16getSingleMatcherEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload16getSingleMatcherEv")
    //</editor-fold>
    public abstract /*virtual*/ Optional<DynTypedMatcher> getSingleMatcher() /*const*//* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload::getTypeAsString">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 127,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload::getTypeAsString", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload15getTypeAsStringEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload15getTypeAsStringEv")
    //</editor-fold>
    public abstract /*virtual*/ std.string getTypeAsString() /*const*//* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload::getTypedMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 128,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload::getTypedMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload15getTypedMatcherERKNS2_10MatcherOpsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload15getTypedMatcherERKNS2_10MatcherOpsE")
    //</editor-fold>
    public abstract /*virtual*/ Optional<DynTypedMatcher> getTypedMatcher(final /*const*/ MatcherOps /*&*/ Ops) /*const*//* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload::isConvertibleTo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 130,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher7Payload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj")
    //</editor-fold>
    public abstract /*virtual*/ boolean isConvertibleTo(ASTNodeKind Kind, 
                   uint$ptr/*uint P*/ Specificity) /*const*//* = 0*/;


    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::Payload::Payload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 123,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::Payload::Payload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher7PayloadC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher7PayloadC1Ev")
    //</editor-fold>
    public /*inline*/ Payload() {
      // : RefCountedBaseVPTR() 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
/*public:*/
  /// \brief A null matcher.
  /// \brief A null matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 216,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcherC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcherC1Ev")
  //</editor-fold>
  public VariantMatcher() {
    // : Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Clones the provided matcher.
  
  /// \brief Clones the provided matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SingleMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 218,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::SingleMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher13SingleMatcherERKNS0_8internal15DynTypedMatcherE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher13SingleMatcherERKNS0_8internal15DynTypedMatcherE")
  //</editor-fold>
  public static VariantMatcher SingleMatcher(final /*const*/ DynTypedMatcher /*&*/ Matcher) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Clones the provided matchers.
  ///
  /// They should be the result of a polymorphic matcher.
  
  /// \brief Clones the provided matchers.
  ///
  /// They should be the result of a polymorphic matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 222,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicMatcherESt6vectorINS0_8internal15DynTypedMatcherESaIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicMatcherESt6vectorINS0_8internal15DynTypedMatcherESaIS5_EE")
  //</editor-fold>
  public static VariantMatcher PolymorphicMatcher(std.vector<DynTypedMatcher> Matchers) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Creates a 'variadic' operator matcher.
  ///
  /// It will bind to the appropriate type on getTypedMatcher<T>().
  
  /// \brief Creates a 'variadic' operator matcher.
  ///
  /// It will bind to the appropriate type on getTypedMatcher<T>().
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOperatorMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 227,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOperatorMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher23VariadicOperatorMatcherENS0_8internal15DynTypedMatcher16VariadicOperatorESt6vectorIS2_SaIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher23VariadicOperatorMatcherENS0_8internal15DynTypedMatcher16VariadicOperatorESt6vectorIS2_SaIS2_EE")
  //</editor-fold>
  public static VariantMatcher VariadicOperatorMatcher(DynTypedMatcher.VariadicOperator Op, 
                         std.vector<VariantMatcher> Args) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Makes the matcher the "null" matcher.
  
  /// \brief Makes the matcher the "null" matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::reset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 237,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::reset", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher5resetEv")
  //</editor-fold>
  public void reset() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Whether the matcher is null.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::isNull">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 158,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::isNull", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return a single matcher, if there is no ambiguity.
  ///
  /// \returns the matcher, if there is only one matcher. An empty Optional, if
  /// the underlying matcher is a polymorphic matcher with more than one
  /// representation.
  
  /// \brief Return a single matcher, if there is no ambiguity.
  ///
  /// \returns the matcher, if there is only one matcher. An empty Optional, if
  /// the underlying matcher is a polymorphic matcher with more than one
  /// representation.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::getSingleMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 233,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::getSingleMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher16getSingleMatcherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher16getSingleMatcherEv")
  //</editor-fold>
  public Optional<DynTypedMatcher> getSingleMatcher() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Determines if the contained matcher can be converted to
  ///   \c Matcher<T>.
  ///
  /// For the Single case, it returns true if it can be converted to
  /// \c Matcher<T>.
  /// For the Polymorphic case, it returns true if one, and only one, of the
  /// overloads can be converted to \c Matcher<T>. If there are more than one
  /// that can, the result would be ambiguous and false is returned.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::hasTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 176,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::hasTypedMatcher", NM="Tpl__ZNK5clang12ast_matchers7dynamic14VariantMatcher15hasTypedMatcherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZNK5clang12ast_matchers7dynamic14VariantMatcher15hasTypedMatcherEv")
  //</editor-fold>
  public </*class*/ T> boolean hasTypedMatcher() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Determines if the contained matcher can be converted to \p Kind.
  ///
  /// \param Kind the requested destination type.
  ///
  /// \param Specificity value corresponding to the "specificity" of the
  ///   convertion.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 187,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj")
  //</editor-fold>
  public boolean isConvertibleTo(ASTNodeKind Kind, 
                 uint$ptr/*uint P*/ Specificity) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return this matcher as a \c Matcher<T>.
  ///
  /// Handles the different types (Single, Polymorphic) accordingly.
  /// Asserts that \c hasTypedMatcher<T>() is true.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::getTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 199,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::getTypedMatcher", NM="Tpl__ZNK5clang12ast_matchers7dynamic14VariantMatcher15getTypedMatcherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZNK5clang12ast_matchers7dynamic14VariantMatcher15getTypedMatcherEv")
  //</editor-fold>
  public </*class*/ T> Matcher<T> getTypedMatcher() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief String representation of the type of the value.
  ///
  /// If the underlying matcher is a polymorphic one, the string will show all
  /// the types.
  
  /// \brief String representation of the type of the value.
  ///
  /// If the underlying matcher is a polymorphic one, the string will show all
  /// the types.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::getTypeAsString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 239,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::getTypeAsString", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher15getTypeAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher15getTypeAsStringEv")
  //</editor-fold>
  public std.string getTypeAsString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 212,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcherC1EPNS2_7PayloadE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcherC1EPNS2_7PayloadE")
  //</editor-fold>
  private /*explicit*/ VariantMatcher(Payload /*P*/ Value) {
    // : Value(Value) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 80,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher13SinglePayloadE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher13SinglePayloadE")
  //</editor-fold>
  private static class SinglePayload extends /*public*/ VariantMatcher.Payload implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::SinglePayload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 82,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::SinglePayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher13SinglePayloadC1ERKNS0_8internal15DynTypedMatcherE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher13SinglePayloadC1ERKNS0_8internal15DynTypedMatcherE")
    //</editor-fold>
    public SinglePayload(final /*const*/ DynTypedMatcher /*&*/ Matcher) {
      // : VariantMatcher::Payload(), Matcher(Matcher) 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::getSingleMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 84,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::getSingleMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload16getSingleMatcherEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload16getSingleMatcherEv")
    //</editor-fold>
    @Override public Optional<DynTypedMatcher> getSingleMatcher() /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::getTypeAsString">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 88,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::getTypeAsString", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload15getTypeAsStringEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload15getTypeAsStringEv")
    //</editor-fold>
    @Override public std.string getTypeAsString() /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::getTypedMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 93,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::getTypedMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload15getTypedMatcherERKNS2_10MatcherOpsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload15getTypedMatcherERKNS2_10MatcherOpsE")
    //</editor-fold>
    @Override public Optional<DynTypedMatcher> getTypedMatcher(final /*const*/ MatcherOps /*&*/ Ops) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::isConvertibleTo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 101,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher13SinglePayload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj")
    //</editor-fold>
    @Override public boolean isConvertibleTo(ASTNodeKind Kind, 
                   uint$ptr/*uint P*/ Specificity) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
  /*private:*/
    private /*const*/ DynTypedMatcher Matcher;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::~SinglePayload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 80,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::SinglePayload::~SinglePayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher13SinglePayloadD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher13SinglePayloadD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    @Override public String toString() {
      return "" + "Matcher=" + Matcher // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 111,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayloadE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayloadE")
  //</editor-fold>
  private static class PolymorphicPayload extends /*public*/ VariantMatcher.Payload implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::PolymorphicPayload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 113,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::PolymorphicPayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayloadC1ESt6vectorINS0_8internal15DynTypedMatcherESaIS6_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayloadC1ESt6vectorINS0_8internal15DynTypedMatcherESaIS6_EE")
    //</editor-fold>
    public PolymorphicPayload(std.vector<DynTypedMatcher> MatchersIn) {
      // : VariantMatcher::Payload(), Matchers(std::move(MatchersIn)) 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::~PolymorphicPayload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 116,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::~PolymorphicPayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayloadD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayloadD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::getSingleMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 118,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::getSingleMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload16getSingleMatcherEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload16getSingleMatcherEv")
    //</editor-fold>
    @Override public Optional<DynTypedMatcher> getSingleMatcher() /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::getTypeAsString">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 124,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::getTypeAsString", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload15getTypeAsStringEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload15getTypeAsStringEv")
    //</editor-fold>
    @Override public std.string getTypeAsString() /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::getTypedMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 134,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::getTypedMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload15getTypedMatcherERKNS2_10MatcherOpsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload15getTypedMatcherERKNS2_10MatcherOpsE")
    //</editor-fold>
    @Override public Optional<DynTypedMatcher> getTypedMatcher(final /*const*/ MatcherOps /*&*/ Ops) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::isConvertibleTo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 159,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::PolymorphicPayload::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher18PolymorphicPayload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj")
    //</editor-fold>
    @Override public boolean isConvertibleTo(ASTNodeKind Kind, 
                   uint$ptr/*uint P*/ Specificity) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    public /*const*/std.vector<DynTypedMatcher> Matchers;
    
    @Override public String toString() {
      return "" + "Matchers=" + Matchers // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 177,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayloadE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayloadE")
  //</editor-fold>
  private static class VariadicOpPayload extends /*public*/ VariantMatcher.Payload implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::VariadicOpPayload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 179,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::VariadicOpPayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayloadC1ENS0_8internal15DynTypedMatcher16VariadicOperatorESt6vectorIS2_SaIS2_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayloadC1ENS0_8internal15DynTypedMatcher16VariadicOperatorESt6vectorIS2_SaIS2_EE")
    //</editor-fold>
    public VariadicOpPayload(DynTypedMatcher.VariadicOperator Op, 
        std.vector<VariantMatcher> Args) {
      // : VariantMatcher::Payload(), Op(Op), Args(std::move(Args)) 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::getSingleMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 183,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::getSingleMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload16getSingleMatcherEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload16getSingleMatcherEv")
    //</editor-fold>
    @Override public Optional<DynTypedMatcher> getSingleMatcher() /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::getTypeAsString">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 187,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::getTypeAsString", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload15getTypeAsStringEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload15getTypeAsStringEv")
    //</editor-fold>
    @Override public std.string getTypeAsString() /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::getTypedMatcher">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 197,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::getTypedMatcher", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload15getTypedMatcherERKNS2_10MatcherOpsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload15getTypedMatcherERKNS2_10MatcherOpsE")
    //</editor-fold>
    @Override public Optional<DynTypedMatcher> getTypedMatcher(final /*const*/ MatcherOps /*&*/ Ops) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::isConvertibleTo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 202,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayload15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPj")
    //</editor-fold>
    @Override public boolean isConvertibleTo(ASTNodeKind Kind, 
                   uint$ptr/*uint P*/ Specificity) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
  /*private:*/
    private /*const*/ DynTypedMatcher.VariadicOperator Op;
    private /*const*/std.vector<VariantMatcher> Args;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::~VariadicOpPayload">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 177,
     FQN="clang::ast_matchers::dynamic::VariantMatcher::VariadicOpPayload::~VariadicOpPayload", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayloadD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcher17VariadicOpPayloadD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    
    @Override public String toString() {
      return "" + "Op=" + Op // NOI18N
                + ", Args=" + Args // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  private IntrusiveRefCntPtr</*const*/ Payload> Value;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 92,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcherC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcherC1EOS2_")
  //</editor-fold>
  public /*inline*/ VariantMatcher(JD$Move _dparam, final VariantMatcher /*&&*/$Prm0) {
    // : Value(static_cast<VariantMatcher &&>().Value) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 92,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::operator=", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcheraSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcheraSEOS2_")
  //</editor-fold>
  public /*inline*/ VariantMatcher /*&*/ $assignMove(final VariantMatcher /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::~VariantMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 92,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::~VariantMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcherD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcherD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 92,
   FQN="clang::ast_matchers::dynamic::VariantMatcher::VariantMatcher", NM="_ZN5clang12ast_matchers7dynamic14VariantMatcherC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic14VariantMatcherC1ERKS2_")
  //</editor-fold>
  public /*inline*/ VariantMatcher(final /*const*/ VariantMatcher /*&*/ $Prm0) {
    // : Value(.Value) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value; // NOI18N
  }
}
