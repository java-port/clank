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
package org.clang.parse;

import org.clank.support.*;
import org.clang.parse.*;
import static org.clang.parse.Parser.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_NestedEnums">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC /*inherited from CodeCompletionHandler*/,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser12ObjCTypeQualE;_ZN5clang6Parser13ExtraSemiKindE;_ZN5clang6Parser13TypeCastStateE;_ZN5clang6Parser14CachedInitKindE;_ZN5clang6Parser14SkipUntilFlagsE;_ZN5clang6Parser15DeclSpecContextE;_ZN5clang6Parser16AttrRequirementsE;_ZN5clang6Parser16IfExistsBehaviorE;_ZN5clang6Parser16ParenParseOptionE;_ZN5clang6Parser17AnnotatedNameKindE;_ZN5clang6Parser18CXX11AttributeKindE;_ZN5clang6Parser21AllowedContsructsKindE;_ZN5clang6Parser24ConditionOrInitStatementE;_ZN5clang6Parser25TentativeCXXTypeIdContextE;_ZN5clang6Parser8TPResultE;_ZN5clang6ParserE_Unnamed_enum; -static-type=Parser_NestedEnums -package=org.clang.parse")
//</editor-fold>
public class Parser_NestedEnums {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// ScopeCache - Cache scopes to reduce malloc traffic.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 86,
   FQN="clang::Parser::(anonymous)", NM="_ZN5clang6ParserE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6ParserE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int ScopeCacheSize = 16;
/*}*/
//<editor-fold defaultstate="collapsed" desc="clang::Parser::AnnotatedNameKind">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 596,
   FQN="clang::Parser::AnnotatedNameKind", NM="_ZN5clang6Parser17AnnotatedNameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17AnnotatedNameKindE")
  //</editor-fold>
  protected /*private*/ enum AnnotatedNameKind implements Native.ComparableLower {
    /// Annotation has failed and emitted an error.
    ANK_Error(0),
    /// The identifier is a tentatively-declared name.
    ANK_TentativeDecl(ANK_Error.getValue() + 1),
    /// The identifier is a template name. FIXME: Add an annotation for that.
    ANK_TemplateName(ANK_TentativeDecl.getValue() + 1),
    /// The identifier can't be resolved.
    ANK_Unresolved(ANK_TemplateName.getValue() + 1),
    /// Annotation was successful.
    ANK_Success(ANK_Unresolved.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AnnotatedNameKind valueOf(int val) {
      AnnotatedNameKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final AnnotatedNameKind[] VALUES;
      private static final AnnotatedNameKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AnnotatedNameKind kind : AnnotatedNameKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AnnotatedNameKind[min < 0 ? (1-min) : 0];
        VALUES = new AnnotatedNameKind[max >= 0 ? (1+max) : 0];
        for (AnnotatedNameKind kind : AnnotatedNameKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AnnotatedNameKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AnnotatedNameKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AnnotatedNameKind)obj).value);}
    //</editor-fold>
  }

/// \brief The kind of extra semi diagnostic to emit.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ExtraSemiKind">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 771,
   FQN="clang::Parser::ExtraSemiKind", NM="_ZN5clang6Parser13ExtraSemiKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser13ExtraSemiKindE")
  //</editor-fold>
  protected /*private*/ enum ExtraSemiKind implements Native.ComparableLower {
    OutsideFunction(0),
    InsideStruct(1),
    InstanceVariableList(2),
    AfterMemberFunctionDefinition(3);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ExtraSemiKind valueOf(int val) {
      ExtraSemiKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final ExtraSemiKind[] VALUES;
      private static final ExtraSemiKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ExtraSemiKind kind : ExtraSemiKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ExtraSemiKind[min < 0 ? (1-min) : 0];
        VALUES = new ExtraSemiKind[max >= 0 ? (1+max) : 0];
        for (ExtraSemiKind kind : ExtraSemiKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ExtraSemiKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ExtraSemiKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ExtraSemiKind)obj).value);}
    //</editor-fold>
  }

/// \brief Control flags for SkipUntil functions.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipUntilFlags">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 864,
   FQN="clang::Parser::SkipUntilFlags", NM="_ZN5clang6Parser14SkipUntilFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser14SkipUntilFlagsE")
  //</editor-fold>
  public static final class/*enum*/ SkipUntilFlags {
    public static final int INVALID = 0; // JAVA
    public static final /*uint*/int StopAtSemi = 1 << 0; ///< Stop skipping at semicolon
    /// \brief Stop skipping at specified token, but don't skip the token itself
    public static final /*uint*/int StopBeforeMatch = 1 << 1;
    public static final /*uint*/int StopAtCodeCompletion = 1 << 2; ///< Stop at code completion
  }
//<editor-fold defaultstate="collapsed" desc="clang::Parser::CachedInitKind">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1204,
   FQN="clang::Parser::CachedInitKind", NM="_ZN5clang6Parser14CachedInitKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser14CachedInitKindE")
  //</editor-fold>
  protected /*private*/ enum CachedInitKind implements Native.ComparableLower {
    CIK_DefaultArgument(0),
    CIK_DefaultInitializer(CIK_DefaultArgument.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CachedInitKind valueOf(int val) {
      CachedInitKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final CachedInitKind[] VALUES;
      private static final CachedInitKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CachedInitKind kind : CachedInitKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CachedInitKind[min < 0 ? (1-min) : 0];
        VALUES = new CachedInitKind[max >= 0 ? (1+max) : 0];
        for (CachedInitKind kind : CachedInitKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CachedInitKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CachedInitKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CachedInitKind)obj).value);}
    //</editor-fold>
  }
// Definitions for Objective-c context sensitive keywords recognition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCTypeQual">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1376,
   FQN="clang::Parser::ObjCTypeQual", NM="_ZN5clang6Parser12ObjCTypeQualE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ObjCTypeQualE")
  //</editor-fold>
  protected /*private*/ enum ObjCTypeQual implements Native.ComparableLower {
    objc_in(0),
    objc_out(objc_in.getValue() + 1),
    objc_inout(objc_out.getValue() + 1),
    objc_oneway(objc_inout.getValue() + 1),
    objc_bycopy(objc_oneway.getValue() + 1),
    objc_byref(objc_bycopy.getValue() + 1),
    objc_nonnull(objc_byref.getValue() + 1),
    objc_nullable(objc_nonnull.getValue() + 1),
    objc_null_unspecified(objc_nullable.getValue() + 1),
    objc_NumQuals(objc_null_unspecified.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ObjCTypeQual valueOf(int val) {
      ObjCTypeQual out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final ObjCTypeQual[] VALUES;
      private static final ObjCTypeQual[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ObjCTypeQual kind : ObjCTypeQual.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ObjCTypeQual[min < 0 ? (1-min) : 0];
        VALUES = new ObjCTypeQual[max >= 0 ? (1+max) : 0];
        for (ObjCTypeQual kind : ObjCTypeQual.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ObjCTypeQual(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ObjCTypeQual)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ObjCTypeQual)obj).value);}
    //</editor-fold>
  }
//===--------------------------------------------------------------------===//
// C99 6.5: Expressions.

/// TypeCastState - State whether an expression is or may be a type cast.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TypeCastState">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1403,
   FQN="clang::Parser::TypeCastState", NM="_ZN5clang6Parser13TypeCastStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser13TypeCastStateE")
  //</editor-fold>
  public enum TypeCastState implements Native.ComparableLower {
    NotTypeCast(0),
    MaybeTypeCast(NotTypeCast.getValue() + 1),
    IsTypeCast(MaybeTypeCast.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TypeCastState valueOf(int val) {
      TypeCastState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final TypeCastState[] VALUES;
      private static final TypeCastState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TypeCastState kind : TypeCastState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TypeCastState[min < 0 ? (1-min) : 0];
        VALUES = new TypeCastState[max >= 0 ? (1+max) : 0];
        for (TypeCastState kind : TypeCastState.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TypeCastState(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TypeCastState)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TypeCastState)obj).value);}
    //</editor-fold>
  }

/// ParenParseOption - Control what ParseParenExpression will parse.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParenParseOption">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1471,
   FQN="clang::Parser::ParenParseOption", NM="_ZN5clang6Parser16ParenParseOptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser16ParenParseOptionE")
  //</editor-fold>
  protected /*private*/ enum ParenParseOption implements Native.ComparableLower {
    SimpleExpr(0), // Only parse '(' expression ')'
    CompoundStmt(SimpleExpr.getValue() + 1), // Also allow '(' compound-statement ')'
    CompoundLiteral(CompoundStmt.getValue() + 1), // Also allow '(' type-name ')' '{' ... '}'
    CastExpr(CompoundLiteral.getValue() + 1); // Also allow '(' type-name ')' <anything>

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ParenParseOption valueOf(int val) {
      ParenParseOption out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final ParenParseOption[] VALUES;
      private static final ParenParseOption[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ParenParseOption kind : ParenParseOption.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ParenParseOption[min < 0 ? (1-min) : 0];
        VALUES = new ParenParseOption[max >= 0 ? (1+max) : 0];
        for (ParenParseOption kind : ParenParseOption.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ParenParseOption(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ParenParseOption)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ParenParseOption)obj).value);}
    //</editor-fold>
  }
//<editor-fold defaultstate="collapsed" desc="clang::Parser::AllowedContsructsKind">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1669,
   FQN="clang::Parser::AllowedContsructsKind", NM="_ZN5clang6Parser21AllowedContsructsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21AllowedContsructsKindE")
  //</editor-fold>
  protected /*private*/ enum AllowedContsructsKind implements Native.ComparableLower {
    /// \brief Allow any declarations, statements, OpenMP directives.
    ACK_Any(0),
    /// \brief Allow only statements and non-standalone OpenMP directives.
    ACK_StatementsOpenMPNonStandalone(ACK_Any.getValue() + 1),
    /// \brief Allow statements and all executable OpenMP directives
    ACK_StatementsOpenMPAnyExecutable(ACK_StatementsOpenMPNonStandalone.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AllowedContsructsKind valueOf(int val) {
      AllowedContsructsKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final AllowedContsructsKind[] VALUES;
      private static final AllowedContsructsKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AllowedContsructsKind kind : AllowedContsructsKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AllowedContsructsKind[min < 0 ? (1-min) : 0];
        VALUES = new AllowedContsructsKind[max >= 0 ? (1+max) : 0];
        for (AllowedContsructsKind kind : AllowedContsructsKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AllowedContsructsKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AllowedContsructsKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AllowedContsructsKind)obj).value);}
    //</editor-fold>
  }

/// \brief Describes the behavior that should be taken for an __if_exists
/// block.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::IfExistsBehavior">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1717,
   FQN="clang::Parser::IfExistsBehavior", NM="_ZN5clang6Parser16IfExistsBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser16IfExistsBehaviorE")
  //</editor-fold>
  protected /*private*/ enum IfExistsBehavior implements Native.ComparableLower {
    /// \brief Parse the block; this code is always used.
    IEB_Parse(0),
    /// \brief Skip the block entirely; this code is never used.
    IEB_Skip(IEB_Parse.getValue() + 1),
    /// \brief Parse the block as a dependent block, which may be used in
    /// some template instantiations but not others.
    IEB_Dependent(IEB_Skip.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IfExistsBehavior valueOf(int val) {
      IfExistsBehavior out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final IfExistsBehavior[] VALUES;
      private static final IfExistsBehavior[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IfExistsBehavior kind : IfExistsBehavior.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IfExistsBehavior[min < 0 ? (1-min) : 0];
        VALUES = new IfExistsBehavior[max >= 0 ? (1+max) : 0];
        for (IfExistsBehavior kind : IfExistsBehavior.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private IfExistsBehavior(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((IfExistsBehavior)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((IfExistsBehavior)obj).value);}
    //</editor-fold>
  }

//===--------------------------------------------------------------------===//
// C99 6.7: Declarations.

/// A context for parsing declaration specifiers.  TODO: flesh this
/// out, there are other significant restrictions on specifiers than
/// would be best implemented in the parser.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DeclSpecContext">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1789,
   FQN="clang::Parser::DeclSpecContext", NM="_ZN5clang6Parser15DeclSpecContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15DeclSpecContextE")
  //</editor-fold>
  protected /*private*/ enum DeclSpecContext implements Native.ComparableLower {
    DSC_normal(0), // normal context
    DSC_class(DSC_normal.getValue() + 1), // class context, enables 'friend'
    DSC_type_specifier(DSC_class.getValue() + 1), // C++ type-specifier-seq or C specifier-qualifier-list
    DSC_trailing(DSC_type_specifier.getValue() + 1), // C++11 trailing-type-specifier in a trailing return type
    DSC_alias_declaration(DSC_trailing.getValue() + 1), // C++11 type-specifier-seq in an alias-declaration
    DSC_top_level(DSC_alias_declaration.getValue() + 1), // top-level/namespace declaration context
    DSC_template_type_arg(DSC_top_level.getValue() + 1), // template type argument context
    DSC_objc_method_result(DSC_template_type_arg.getValue() + 1), // ObjC method result context, enables 'instancetype'
    DSC_condition(DSC_objc_method_result.getValue() + 1); // condition declaration context

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DeclSpecContext valueOf(int val) {
      DeclSpecContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final DeclSpecContext[] VALUES;
      private static final DeclSpecContext[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DeclSpecContext kind : DeclSpecContext.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DeclSpecContext[min < 0 ? (1-min) : 0];
        VALUES = new DeclSpecContext[max >= 0 ? (1+max) : 0];
        for (DeclSpecContext kind : DeclSpecContext.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DeclSpecContext(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DeclSpecContext)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DeclSpecContext)obj).value);}
    //</editor-fold>
  }

/// \brief Specifies the context in which type-id/expression
/// disambiguation will occur.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TentativeCXXTypeIdContext">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1938,
   FQN="clang::Parser::TentativeCXXTypeIdContext", NM="_ZN5clang6Parser25TentativeCXXTypeIdContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25TentativeCXXTypeIdContextE")
  //</editor-fold>
  protected /*private*/ enum TentativeCXXTypeIdContext implements Native.ComparableLower {
    TypeIdInParens(0),
    TypeIdUnambiguous(TypeIdInParens.getValue() + 1),
    TypeIdAsTemplateArgument(TypeIdUnambiguous.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TentativeCXXTypeIdContext valueOf(int val) {
      TentativeCXXTypeIdContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final TentativeCXXTypeIdContext[] VALUES;
      private static final TentativeCXXTypeIdContext[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TentativeCXXTypeIdContext kind : TentativeCXXTypeIdContext.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TentativeCXXTypeIdContext[min < 0 ? (1-min) : 0];
        VALUES = new TentativeCXXTypeIdContext[max >= 0 ? (1+max) : 0];
        for (TentativeCXXTypeIdContext kind : TentativeCXXTypeIdContext.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TentativeCXXTypeIdContext(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TentativeCXXTypeIdContext)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TentativeCXXTypeIdContext)obj).value);}
    //</editor-fold>
  }
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionOrInitStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1991,
   FQN="clang::Parser::ConditionOrInitStatement", NM="_ZN5clang6Parser24ConditionOrInitStatementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser24ConditionOrInitStatementE")
  //</editor-fold>
  protected /*private*/ enum /*class */ConditionOrInitStatement/* : int*/ implements Native.ComparableLower {
    Expression(0), ///< Disambiguated as an expression (either kind).
    ConditionDecl(Expression.getValue() + 1), ///< Disambiguated as the declaration form of condition.
    InitStmtDecl(ConditionDecl.getValue() + 1), ///< Disambiguated as a simple-declaration init-statement.
    Error(InitStmtDecl.getValue() + 1); ///< Can't be any of the above!

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ConditionOrInitStatement valueOf(int val) {
      ConditionOrInitStatement out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final ConditionOrInitStatement[] VALUES;
      private static final ConditionOrInitStatement[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ConditionOrInitStatement kind : ConditionOrInitStatement.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ConditionOrInitStatement[min < 0 ? (1-min) : 0];
        VALUES = new ConditionOrInitStatement[max >= 0 ? (1+max) : 0];
        for (ConditionOrInitStatement kind : ConditionOrInitStatement.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private ConditionOrInitStatement(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((ConditionOrInitStatement)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((ConditionOrInitStatement)obj).value);}
    //</editor-fold>
  }

/// TPResult - Used as the result value for functions whose purpose is to
/// disambiguate C++ constructs by "tentatively parsing" them.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TPResult">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2011,
   FQN="clang::Parser::TPResult", NM="_ZN5clang6Parser8TPResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser8TPResultE")
  //</editor-fold>
  protected /*private*/ enum /*class */TPResult/* : int*/ implements Native.ComparableLower {
    True(0),
    False(True.getValue() + 1),
    Ambiguous(False.getValue() + 1),
    Error(Ambiguous.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TPResult valueOf(int val) {
      TPResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final TPResult[] VALUES;
      private static final TPResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TPResult kind : TPResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TPResult[min < 0 ? (1-min) : 0];
        VALUES = new TPResult[max >= 0 ? (1+max) : 0];
        for (TPResult kind : TPResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private TPResult(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((TPResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((TPResult)obj).value);}
    //</editor-fold>
  }
//<editor-fold defaultstate="collapsed" desc="clang::Parser::AttrRequirements">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2337,
   FQN="clang::Parser::AttrRequirements", NM="_ZN5clang6Parser16AttrRequirementsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser16AttrRequirementsE")
  //</editor-fold>
  protected /*private*/ static final class/*enum*/ AttrRequirements {
    public static final /*uint*/int AR_NoAttributesParsed = 0; ///< No attributes are diagnosed.
    public static final /*uint*/int AR_GNUAttributesParsedAndRejected = 1 << 0; ///< Diagnose GNU attributes.
    public static final /*uint*/int AR_GNUAttributesParsed = 1 << 1;
    public static final /*uint*/int AR_CXX11AttributesParsed = 1 << 2;
    public static final /*uint*/int AR_DeclspecAttributesParsed = 1 << 3;
    public static final /*uint*/int AR_AllAttributesParsed = AttrRequirements.AR_GNUAttributesParsed
       | AttrRequirements.AR_CXX11AttributesParsed
       | AttrRequirements.AR_DeclspecAttributesParsed;
    public static final /*uint*/int AR_VendorAttributesParsed = AttrRequirements.AR_GNUAttributesParsed
       | AttrRequirements.AR_DeclspecAttributesParsed;
  }

//===--------------------------------------------------------------------===//
// C++ 7: Declarations [dcl.dcl]

/// The kind of attribute specifier we have found.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::CXX11AttributeKind">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2379,
   FQN="clang::Parser::CXX11AttributeKind", NM="_ZN5clang6Parser18CXX11AttributeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18CXX11AttributeKindE")
  //</editor-fold>
  protected /*private*/ enum CXX11AttributeKind implements Native.ComparableLower {
    /// This is not an attribute specifier.
    CAK_NotAttributeSpecifier(0),
    /// This should be treated as an attribute-specifier.
    CAK_AttributeSpecifier(CAK_NotAttributeSpecifier.getValue() + 1),
    /// The next tokens are '[[', but this is not an attribute-specifier. This
    /// is ill-formed by C++11 [dcl.attr.grammar]p6.
    CAK_InvalidAttributeSpecifier(CAK_AttributeSpecifier.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CXX11AttributeKind valueOf(int val) {
      CXX11AttributeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      private static final CXX11AttributeKind[] VALUES;
      private static final CXX11AttributeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CXX11AttributeKind kind : CXX11AttributeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CXX11AttributeKind[min < 0 ? (1-min) : 0];
        VALUES = new CXX11AttributeKind[max >= 0 ? (1+max) : 0];
        for (CXX11AttributeKind kind : CXX11AttributeKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CXX11AttributeKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXX11AttributeKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXX11AttributeKind)obj).value);}
    //</editor-fold>
  }
} // END OF class Parser_NestedEnums
