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


/// \brief Helper class to manage error messages.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 51,
 FQN="clang::ast_matchers::dynamic::Diagnostics", NM="_ZN5clang12ast_matchers7dynamic11DiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11DiagnosticsE")
//</editor-fold>
public class Diagnostics implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Parser context types.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 54,
   FQN="clang::ast_matchers::dynamic::Diagnostics::ContextType", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics11ContextTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics11ContextTypeE")
  //</editor-fold>
  public enum ContextType implements Native.ComparableLower {
    CT_MatcherArg(0),
    CT_MatcherConstruct(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ContextType valueOf(int val) {
      ContextType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ContextType[] VALUES;
      private static final ContextType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ContextType kind : ContextType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ContextType[min < 0 ? (1-min) : 0];
        VALUES = new ContextType[max >= 0 ? (1+max) : 0];
        for (ContextType kind : ContextType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ContextType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ContextType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ContextType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief All errors from the system.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 60,
   FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorType", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics9ErrorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics9ErrorTypeE")
  //</editor-fold>
  public enum ErrorType implements Native.ComparableLower {
    ET_None(0),
    
    ET_RegistryMatcherNotFound(1),
    ET_RegistryWrongArgCount(2),
    ET_RegistryWrongArgType(3),
    ET_RegistryNotBindable(4),
    ET_RegistryAmbiguousOverload(5),
    ET_RegistryValueNotFound(6),
    
    ET_ParserStringError(100),
    ET_ParserNoOpenParen(101),
    ET_ParserNoCloseParen(102),
    ET_ParserNoComma(103),
    ET_ParserNoCode(104),
    ET_ParserNotAMatcher(105),
    ET_ParserInvalidToken(106),
    ET_ParserMalformedBindExpr(107),
    ET_ParserTrailingCode(108),
    ET_ParserUnsignedError(109),
    ET_ParserOverloadedType(110);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ErrorType valueOf(int val) {
      ErrorType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ErrorType[] VALUES;
      private static final ErrorType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ErrorType kind : ErrorType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ErrorType[min < 0 ? (1-min) : 0];
        VALUES = new ErrorType[max >= 0 ? (1+max) : 0];
        for (ErrorType kind : ErrorType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ErrorType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ErrorType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ErrorType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Helper stream class.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ArgStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 84,
   FQN="clang::ast_matchers::dynamic::Diagnostics::ArgStream", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamE")
  //</editor-fold>
  public static class ArgStream {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ArgStream::ArgStream">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 86,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ArgStream::ArgStream", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamC1EPSt6vectorISsSaISsEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamC1EPSt6vectorISsSaISsEE")
    //</editor-fold>
    public ArgStream(std.vectorString/*P*/ Out) {
      // : Out(Out) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    /*template <class T> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ArgStream::operator<<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 87,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ArgStream::operator<<", NM="Tpl__ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamlsERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamlsERKT_")
    //</editor-fold>
    public </*class*/ T> ArgStream /*&*/ $out$T(final /*const*/ T /*&*/ Arg) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ArgStream::operator<<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 61,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ArgStream::operator<<", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamlsERKN4llvm5TwineE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamlsERKN4llvm5TwineE")
    //</editor-fold>
    public Diagnostics.ArgStream /*&*/ $out(final /*const*/ Twine /*&*/ Arg) {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private std.vectorString/*P*/ Out;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ArgStream::ArgStream">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 84,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ArgStream::ArgStream", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics9ArgStreamC1EOS3_")
    //</editor-fold>
    public /*inline*/ ArgStream(JD$Move _dparam, final ArgStream /*&&*/$Prm0) {
      // : Out(static_cast<ArgStream &&>().Out) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Out=" + Out; // NOI18N
    }
  };
  
  /// \brief Class defining a parser context.
  ///
  /// Used by the parser to specify (possibly recursive) contexts where the
  /// parsing/construction can fail. Any error triggered within a context will
  /// keep information about the context chain.
  /// This class should be used as a RAII instance in the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Context">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 102,
   FQN="clang::ast_matchers::dynamic::Diagnostics::Context", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextE")
  //</editor-fold>
  public static class/*struct*/ Context implements Destructors.ClassWithDestructor {
  /*public:*/
    /// \brief About to call the constructor for a matcher.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Context::ConstructMatcherEnum">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 105,
     FQN="clang::ast_matchers::dynamic::Diagnostics::Context::ConstructMatcherEnum", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics7Context20ConstructMatcherEnumE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics7Context20ConstructMatcherEnumE")
    //</editor-fold>
    public enum ConstructMatcherEnum implements Native.ComparableLower {
      ConstructMatcher(0);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static ConstructMatcherEnum valueOf(int val) {
        ConstructMatcherEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final ConstructMatcherEnum[] VALUES;
        private static final ConstructMatcherEnum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (ConstructMatcherEnum kind : ConstructMatcherEnum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new ConstructMatcherEnum[min < 0 ? (1-min) : 0];
          VALUES = new ConstructMatcherEnum[max >= 0 ? (1+max) : 0];
          for (ConstructMatcherEnum kind : ConstructMatcherEnum.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private ConstructMatcherEnum(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConstructMatcherEnum)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConstructMatcherEnum)obj).value);}
      //</editor-fold>
    };
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Context::Context">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 24,
     FQN="clang::ast_matchers::dynamic::Diagnostics::Context::Context", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextC1ENS3_20ConstructMatcherEnumEPS2_N4llvm9StringRefENS1_11SourceRangeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextC1ENS3_20ConstructMatcherEnumEPS2_N4llvm9StringRefENS1_11SourceRangeE")
    //</editor-fold>
    public Context(ConstructMatcherEnum $Prm0, Diagnostics /*P*/ Error, 
        StringRef MatcherName, 
        SourceRange MatcherRange) {
      // : Error(Error) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    /// \brief About to recurse into parsing one argument for a matcher.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Context::MatcherArgEnum">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 109,
     FQN="clang::ast_matchers::dynamic::Diagnostics::Context::MatcherArgEnum", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics7Context14MatcherArgEnumE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics7Context14MatcherArgEnumE")
    //</editor-fold>
    public enum MatcherArgEnum implements Native.ComparableLower {
      MatcherArg(0);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static MatcherArgEnum valueOf(int val) {
        MatcherArgEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final MatcherArgEnum[] VALUES;
        private static final MatcherArgEnum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (MatcherArgEnum kind : MatcherArgEnum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new MatcherArgEnum[min < 0 ? (1-min) : 0];
          VALUES = new MatcherArgEnum[max >= 0 ? (1+max) : 0];
          for (MatcherArgEnum kind : MatcherArgEnum.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private MatcherArgEnum(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MatcherArgEnum)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MatcherArgEnum)obj).value);}
      //</editor-fold>
    };
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Context::Context">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 31,
     FQN="clang::ast_matchers::dynamic::Diagnostics::Context::Context", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextC1ENS3_14MatcherArgEnumEPS2_N4llvm9StringRefENS1_11SourceRangeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextC1ENS3_14MatcherArgEnumEPS2_N4llvm9StringRefENS1_11SourceRangeEj")
    //</editor-fold>
    public Context(MatcherArgEnum $Prm0, Diagnostics /*P*/ Error, 
        StringRef MatcherName, 
        SourceRange MatcherRange, 
        /*uint*/int ArgNumber) {
      // : Error(Error) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Context::~Context">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 40,
     FQN="clang::ast_matchers::dynamic::Diagnostics::Context::~Context", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics7ContextD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private Diagnostics /*P*/ /*const*/ Error;
    
    @Override public String toString() {
      return "" + "Error=" + Error; // NOI18N
    }
  };
  
  /// \brief Context for overloaded matcher construction.
  ///
  /// This context will take care of merging all errors that happen within it
  /// as "candidate" overloads for the same matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::OverloadContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 122,
   FQN="clang::ast_matchers::dynamic::Diagnostics::OverloadContext", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContextE")
  //</editor-fold>
  public static class/*struct*/ OverloadContext implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::OverloadContext::OverloadContext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 42,
     FQN="clang::ast_matchers::dynamic::Diagnostics::OverloadContext::OverloadContext", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContextC1EPS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContextC1EPS2_")
    //</editor-fold>
    public OverloadContext(Diagnostics /*P*/ Error) {
      // : Error(Error), BeginIndex(Error->Errors.size()) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::OverloadContext::~OverloadContext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 45,
     FQN="clang::ast_matchers::dynamic::Diagnostics::OverloadContext::~OverloadContext", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContextD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContextD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Revert all errors that happened within this context.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::OverloadContext::revertErrors">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 56,
     FQN="clang::ast_matchers::dynamic::Diagnostics::OverloadContext::revertErrors", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContext12revertErrorsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics15OverloadContext12revertErrorsEv")
    //</editor-fold>
    public void revertErrors() {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private Diagnostics /*P*/ /*const*/ Error;
    private /*uint*/int BeginIndex;
    
    @Override public String toString() {
      return "" + "Error=" + Error // NOI18N
                + ", BeginIndex=" + BeginIndex; // NOI18N
    }
  };
  
  /// \brief Add an error to the diagnostics.
  ///
  /// All the context information will be kept on the error message.
  /// \return a helper class to allow the caller to pass the arguments for the
  /// error message, using the << operator.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::addError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 66,
   FQN="clang::ast_matchers::dynamic::Diagnostics::addError", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics8addErrorENS1_11SourceRangeENS2_9ErrorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics8addErrorENS1_11SourceRangeENS2_9ErrorTypeE")
  //</editor-fold>
  public Diagnostics.ArgStream addError(SourceRange Range, 
          ErrorType Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Information stored for one frame of the context.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextFrame">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 143,
   FQN="clang::ast_matchers::dynamic::Diagnostics::ContextFrame", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameE")
  //</editor-fold>
  public static class/*struct*/ ContextFrame implements Destructors.ClassWithDestructor {
    public ContextType Type;
    public SourceRange Range;
    public std.vectorString Args;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::ContextFrame">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 143,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::ContextFrame", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameC1EOS3_")
    //</editor-fold>
    public /*inline*/ ContextFrame(JD$Move _dparam, final ContextFrame /*&&*/$Prm0) {
      // : Type(static_cast<ContextFrame &&>().Type), Range(static_cast<ContextFrame &&>().Range), Args(static_cast<ContextFrame &&>().Args) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::~ContextFrame">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 143,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::~ContextFrame", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::ContextFrame">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 143,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::ContextFrame", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameC1Ev")
    //</editor-fold>
    public /*inline*/ ContextFrame() {
      // : Range(), Args() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::ContextFrame">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 143,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::ContextFrame", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameC1ERKS3_")
    //</editor-fold>
    public /*inline*/ ContextFrame(final /*const*/ ContextFrame /*&*/ $Prm0) {
      // : Type(.Type), Range(.Range), Args(.Args) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 143,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ContextFrame::operator=", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameaSERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ContextFrameaSERKS3_")
    //</editor-fold>
    public /*inline*/ ContextFrame /*&*/ $assign(final /*const*/ ContextFrame /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", Range=" + Range // NOI18N
                + ", Args=" + Args; // NOI18N
    }
  };
  
  /// \brief Information stored for each error found.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 150,
   FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentE")
  //</editor-fold>
  public static class/*struct*/ ErrorContent implements Destructors.ClassWithDestructor {
    public std.vector<ContextFrame> ContextStack;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 152,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageE")
    //</editor-fold>
    public static class/*struct*/ Message implements Destructors.ClassWithDestructor {
      public SourceRange Range;
      public ErrorType Type;
      public std.vectorString Args;
      //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::Message">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 152,
       FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::Message", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageC1EOS4_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageC1EOS4_")
      //</editor-fold>
      public /*inline*/ Message(JD$Move _dparam, final Message /*&&*/$Prm0) {
        // : Range(static_cast<Message &&>().Range), Type(static_cast<Message &&>().Type), Args(static_cast<Message &&>().Args) 
        throw new UnsupportedOperationException("EmptyBody");
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::~Message">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 152,
       FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::~Message", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        throw new UnsupportedOperationException("EmptyBody");
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::Message">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 152,
       FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::Message", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageC1Ev")
      //</editor-fold>
      public /*inline*/ Message() {
        // : Range(), Args() 
        throw new UnsupportedOperationException("EmptyBody");
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::Message">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 152,
       FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::Message::Message", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageC1ERKS4_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContent7MessageC1ERKS4_")
      //</editor-fold>
      public /*inline*/ Message(final /*const*/ Message /*&*/ $Prm0) {
        // : Range(.Range), Type(.Type), Args(.Args) 
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      @Override public String toString() {
        return "" + "Range=" + Range // NOI18N
                  + ", Type=" + Type // NOI18N
                  + ", Args=" + Args; // NOI18N
      }
    };
    public std.vector<Message> Messages;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::ErrorContent">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 150,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::ErrorContent", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentC1EOS3_")
    //</editor-fold>
    public /*inline*/ ErrorContent(JD$Move _dparam, final ErrorContent /*&&*/$Prm0) {
      // : ContextStack(static_cast<ErrorContent &&>().ContextStack), Messages(static_cast<ErrorContent &&>().Messages) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::~ErrorContent">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 150,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::~ErrorContent", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::ErrorContent">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 150,
     FQN="clang::ast_matchers::dynamic::Diagnostics::ErrorContent::ErrorContent", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics12ErrorContentC1Ev")
    //</editor-fold>
    public /*inline*/ ErrorContent() {
      // : ContextStack(), Messages() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "ContextStack=" + ContextStack // NOI18N
                + ", Messages=" + Messages; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::errors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 159,
   FQN="clang::ast_matchers::dynamic::Diagnostics::errors", NM="_ZNK5clang12ast_matchers7dynamic11Diagnostics6errorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZNK5clang12ast_matchers7dynamic11Diagnostics6errorsEv")
  //</editor-fold>
  public ArrayRef<ErrorContent> errors() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns a simple string representation of each error.
  ///
  /// Each error only shows the error message without any context.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::printToStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 187,
   FQN="clang::ast_matchers::dynamic::Diagnostics::printToStream", NM="_ZNK5clang12ast_matchers7dynamic11Diagnostics13printToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZNK5clang12ast_matchers7dynamic11Diagnostics13printToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printToStream(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::toString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 194,
   FQN="clang::ast_matchers::dynamic::Diagnostics::toString", NM="_ZNK5clang12ast_matchers7dynamic11Diagnostics8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZNK5clang12ast_matchers7dynamic11Diagnostics8toStringEv")
  //</editor-fold>
  public std.string __toString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the full string representation of each error.
  ///
  /// Each error message contains the full context.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::printToStreamFull">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 201,
   FQN="clang::ast_matchers::dynamic::Diagnostics::printToStreamFull", NM="_ZNK5clang12ast_matchers7dynamic11Diagnostics17printToStreamFullERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZNK5clang12ast_matchers7dynamic11Diagnostics17printToStreamFullERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printToStreamFull(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::toStringFull">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 213,
   FQN="clang::ast_matchers::dynamic::Diagnostics::toStringFull", NM="_ZNK5clang12ast_matchers7dynamic11Diagnostics12toStringFullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZNK5clang12ast_matchers7dynamic11Diagnostics12toStringFullEv")
  //</editor-fold>
  public std.string toStringFull() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Helper function used by the constructors of ContextFrame.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::pushContextFrame">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 15,
   FQN="clang::ast_matchers::dynamic::Diagnostics::pushContextFrame", NM="_ZN5clang12ast_matchers7dynamic11Diagnostics16pushContextFrameENS2_11ContextTypeENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamic11Diagnostics16pushContextFrameENS2_11ContextTypeENS1_11SourceRangeE")
  //</editor-fold>
  private Diagnostics.ArgStream pushContextFrame(ContextType Type, 
                  SourceRange Range) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private std.vector<ContextFrame> ContextStack;
  private std.vector<ErrorContent> Errors;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::~Diagnostics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 51,
   FQN="clang::ast_matchers::dynamic::Diagnostics::~Diagnostics", NM="_ZN5clang12ast_matchers7dynamic11DiagnosticsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic11DiagnosticsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }



  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Diagnostics::Diagnostics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Diagnostics.h", line = 51,
   FQN="clang::ast_matchers::dynamic::Diagnostics::Diagnostics", NM="_ZN5clang12ast_matchers7dynamic11DiagnosticsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic11DiagnosticsC1Ev")
  //</editor-fold>
  public /*inline*/ Diagnostics() {
    // : ContextStack(), Errors() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ContextStack=" + ContextStack // NOI18N
              + ", Errors=" + Errors; // NOI18N
  }
}
