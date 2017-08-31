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


/// \brief Kind identifier.
///
/// It supports all types that VariantValue can contain.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 35,
 FQN="clang::ast_matchers::dynamic::ArgKind", NM="_ZN5clang12ast_matchers7dynamic7ArgKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic7ArgKindE")
//</editor-fold>
public class ArgKind {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 37,
   FQN="clang::ast_matchers::dynamic::ArgKind::Kind", NM="_ZN5clang12ast_matchers7dynamic7ArgKind4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic7ArgKind4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    AK_Matcher(0),
    AK_Unsigned(AK_Matcher.getValue() + 1),
    AK_String(AK_Unsigned.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  /// \brief Constructor for non-matcher types.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::ArgKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 43,
   FQN="clang::ast_matchers::dynamic::ArgKind::ArgKind", NM="_ZN5clang12ast_matchers7dynamic7ArgKindC1ENS2_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic7ArgKindC1ENS2_4KindE")
  //</editor-fold>
  public ArgKind(Kind K) {
    // : K(K), MatcherKind() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Constructor for matcher types.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::ArgKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 46,
   FQN="clang::ast_matchers::dynamic::ArgKind::ArgKind", NM="_ZN5clang12ast_matchers7dynamic7ArgKindC1ENS_15ast_type_traits11ASTNodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic7ArgKindC1ENS_15ast_type_traits11ASTNodeKindE")
  //</editor-fold>
  public ArgKind(ASTNodeKind MatcherKind) {
    // : K(AK_Matcher), MatcherKind(MatcherKind) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::getArgKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 49,
   FQN="clang::ast_matchers::dynamic::ArgKind::getArgKind", NM="_ZNK5clang12ast_matchers7dynamic7ArgKind10getArgKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic7ArgKind10getArgKindEv")
  //</editor-fold>
  public Kind getArgKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::getMatcherKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 50,
   FQN="clang::ast_matchers::dynamic::ArgKind::getMatcherKind", NM="_ZNK5clang12ast_matchers7dynamic7ArgKind14getMatcherKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic7ArgKind14getMatcherKindEv")
  //</editor-fold>
  public ASTNodeKind getMatcherKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Determines if this type can be converted to \p To.
  ///
  /// \param To the requested destination type.
  ///
  /// \param Specificity value corresponding to the "specificity" of the
  ///   convertion.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 35,
   FQN="clang::ast_matchers::dynamic::ArgKind::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic7ArgKind15isConvertibleToES2_Pj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic7ArgKind15isConvertibleToES2_Pj")
  //</editor-fold>
  public boolean isConvertibleTo(ArgKind To, uint$ptr/*uint P*/ Specificity) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 63,
   FQN="clang::ast_matchers::dynamic::ArgKind::operator<", NM="_ZNK5clang12ast_matchers7dynamic7ArgKindltERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic7ArgKindltERKS2_")
  //</editor-fold>
  public boolean $less(final /*const*/ ArgKind /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief String representation of the type.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::asString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp", line = 23,
   FQN="clang::ast_matchers::dynamic::ArgKind::asString", NM="_ZNK5clang12ast_matchers7dynamic7ArgKind8asStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZNK5clang12ast_matchers7dynamic7ArgKind8asStringEv")
  //</editor-fold>
  public std.string asString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private Kind K;
  private ASTNodeKind MatcherKind;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::ArgKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 35,
   FQN="clang::ast_matchers::dynamic::ArgKind::ArgKind", NM="_ZN5clang12ast_matchers7dynamic7ArgKindC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic7ArgKindC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ArgKind(final /*const*/ ArgKind /*&*/ $Prm0) {
    // : K(.K), MatcherKind(.MatcherKind) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::ArgKind::ArgKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/VariantValue.h", line = 35,
   FQN="clang::ast_matchers::dynamic::ArgKind::ArgKind", NM="_ZN5clang12ast_matchers7dynamic7ArgKindC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/VariantValue.cpp -nm=_ZN5clang12ast_matchers7dynamic7ArgKindC1EOS2_")
  //</editor-fold>
  public /*inline*/ ArgKind(JD$Move _dparam, final ArgKind /*&&*/$Prm0) {
    // : K(static_cast<ArgKind &&>().K), MatcherKind(static_cast<ArgKind &&>().MatcherKind) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "K=" + K // NOI18N
              + ", MatcherKind=" + MatcherKind; // NOI18N
  }
}
