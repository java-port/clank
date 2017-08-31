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
package org.clang.sema;

import org.clank.support.*;
import static org.clang.sema.Sema.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_NestedEnums">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema10TagUseKindE;_ZN5clang4Sema10VarArgKindE;_ZN5clang4Sema12AccessResultE;_ZN5clang4Sema12OverloadKindE;_ZN5clang4Sema13ConditionKindE;_ZN5clang4Sema14ForRangeStatusE;_ZN5clang4Sema14IfExistsResultE;_ZN5clang4Sema14LookupNameKindE;_ZN5clang4Sema14TryCaptureKindE;_ZN5clang4Sema15CorrectTypoKindE;_ZN5clang4Sema15ObjCLiteralKindE;_ZN5clang4Sema15ObjCMessageKindE;_ZN5clang4Sema16AssignmentActionE;_ZN5clang4Sema16CXXSpecialMemberE;_ZN5clang4Sema16DeduceAutoResultE;_ZN5clang4Sema16FormatStringTypeE;_ZN5clang4Sema16VariadicCallTypeE;_ZN5clang4Sema17AbstractDiagSelIDE;_ZN5clang4Sema17AssignConvertTypeE;_ZN5clang4Sema17BuildForRangeKindE;_ZN5clang4Sema17MissingImportKindE;_ZN5clang4Sema17ObjCContainerKindE;_ZN5clang4Sema17ObjCSubscriptKindE;_ZN5clang4Sema17PragmaSectionKindE;_ZN5clang4Sema17RedeclarationKindE;_ZN5clang4Sema18CUDAFunctionTargetE;_ZN5clang4Sema19ARCConversionResultE;_ZN5clang4Sema19MethodMatchStrategyE;_ZN5clang4Sema19PragmaMsStackActionE;_ZN5clang4Sema21AvailabilityMergeKindE;_ZN5clang4Sema21CheckedConversionKindE;_ZN5clang4Sema21ObjCSpecialMethodKindE;_ZN5clang4Sema22AvailabilityDiagnosticE;_ZN5clang4Sema22CUDAFunctionPreferenceE;_ZN5clang4Sema22NameClassificationKindE;_ZN5clang4Sema22PragmaOptionsAlignKindE;_ZN5clang4Sema22ReferenceCompareResultE;_ZN5clang4Sema23ParserCompletionContextE;_ZN5clang4Sema23TemplateDeductionResultE;_ZN5clang4Sema24ReuseLambdaContextDecl_tE;_ZN5clang4Sema24TemplateParamListContextE;_ZN5clang4Sema25CheckTemplateArgumentKindE;_ZN5clang4Sema27ExpressionEvaluationContextE;_ZN5clang4Sema27LiteralOperatorLookupResultE;_ZN5clang4Sema27ResultTypeCompatibilityKindE;_ZN5clang4Sema30TemplateParameterListEqualKindE;_ZN5clang4Sema30UnexpandedParameterPackContextE;_ZN5clang4Sema7CCEKindE; -static-type=Sema_NestedEnums -package=org.clang.sema")
//</editor-fold>
public class Sema_NestedEnums {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaMsStackAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 333,
 FQN="clang::Sema::PragmaMsStackAction", NM="_ZN5clang4Sema19PragmaMsStackActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19PragmaMsStackActionE")
//</editor-fold>
public static final class/*enum*/ PragmaMsStackAction {
  public static final /*uint*/int PSK_Reset = 0x0; // #pragma ()
  public static final /*uint*/int PSK_Set = 0x1; // #pragma (value)
  public static final /*uint*/int PSK_Push = 0x2; // #pragma (push[, id])
  public static final /*uint*/int PSK_Pop = 0x4; // #pragma (pop[, id])
  public static final /*uint*/int PSK_Show = 0x8; // #pragma (show) -- only for "pack"!
  public static final /*uint*/int PSK_Push_Set = PragmaMsStackAction.PSK_Push | PragmaMsStackAction.PSK_Set; // #pragma (push[, id], value)
  public static final /*uint*/int PSK_Pop_Set = PragmaMsStackAction.PSK_Pop | PragmaMsStackAction.PSK_Set; // #pragma (pop[, id], value)
}

/// \brief Describes how the expressions currently being parsed are
/// evaluated at run-time, if at all.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 793,
 FQN="clang::Sema::ExpressionEvaluationContext", NM="_ZN5clang4Sema27ExpressionEvaluationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27ExpressionEvaluationContextE")
//</editor-fold>
public enum ExpressionEvaluationContext implements Native.NativeUIntEnum {
  /// \brief The current expression and its subexpressions occur within an
  /// unevaluated operand (C++11 [expr]p7), such as the subexpression of
  /// \c sizeof, where the type of the expression may be significant but
  /// no code will be generated to evaluate the value of the expression at
  /// run time.
  Unevaluated(0),
  
  /// \brief The current expression occurs within a discarded statement.
  /// This behaves largely similarly to an unevaluated operand in preventing
  /// definitions from being required, but not in other ways.
  DiscardedStatement(Unevaluated.getValue() + 1),
  
  /// \brief The current expression occurs within an unevaluated
  /// operand that unconditionally permits abstract references to
  /// fields, such as a SIZE operator in MS-style inline assembly.
  UnevaluatedAbstract(DiscardedStatement.getValue() + 1),
  
  /// \brief The current context is "potentially evaluated" in C++11 terms,
  /// but the expression is evaluated at compile-time (like the values of
  /// cases in a switch statement).
  ConstantEvaluated(UnevaluatedAbstract.getValue() + 1),
  
  /// \brief The current expression is potentially evaluated at run time,
  /// which means that code may be generated to evaluate the value of the
  /// expression at run time.
  PotentiallyEvaluated(ConstantEvaluated.getValue() + 1),
  
  /// \brief The current expression is potentially evaluated, but any
  /// declarations referenced inside that expression are only used if
  /// in fact the current expression is used.
  ///
  /// This value is used when parsing default function arguments, for which
  /// we would like to provide diagnostics (e.g., passing non-POD arguments
  /// through varargs) but do not want to mark declarations as "referenced"
  /// until the default argument is used.
  PotentiallyEvaluatedIfUsed(PotentiallyEvaluated.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ExpressionEvaluationContext valueOf(int val) {
    ExpressionEvaluationContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ExpressionEvaluationContext[] VALUES;
    private static final ExpressionEvaluationContext[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ExpressionEvaluationContext kind : ExpressionEvaluationContext.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ExpressionEvaluationContext[min < 0 ? (1-min) : 0];
      VALUES = new ExpressionEvaluationContext[max >= 0 ? (1+max) : 0];
      for (ExpressionEvaluationContext kind : ExpressionEvaluationContext.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ExpressionEvaluationContext(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// Kinds of C++ special members.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CXXSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1007,
 FQN="clang::Sema::CXXSpecialMember", NM="_ZN5clang4Sema16CXXSpecialMemberE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16CXXSpecialMemberE")
//</editor-fold>
public enum CXXSpecialMember implements Native.NativeUIntEnum {
  CXXDefaultConstructor(0),
  CXXCopyConstructor(CXXDefaultConstructor.getValue() + 1),
  CXXMoveConstructor(CXXCopyConstructor.getValue() + 1),
  CXXCopyAssignment(CXXMoveConstructor.getValue() + 1),
  CXXMoveAssignment(CXXCopyAssignment.getValue() + 1),
  CXXDestructor(CXXMoveAssignment.getValue() + 1),
  CXXInvalid(CXXDestructor.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXXSpecialMember valueOf(int val) {
    CXXSpecialMember out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXXSpecialMember[] VALUES;
    private static final CXXSpecialMember[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXXSpecialMember kind : CXXSpecialMember.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXXSpecialMember[min < 0 ? (1-min) : 0];
      VALUES = new CXXSpecialMember[max >= 0 ? (1+max) : 0];
      for (CXXSpecialMember kind : CXXSpecialMember.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CXXSpecialMember(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Describes the result of the name lookup and resolution performed
/// by \c ClassifyName().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassificationKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1548,
 FQN="clang::Sema::NameClassificationKind", NM="_ZN5clang4Sema22NameClassificationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22NameClassificationKindE")
//</editor-fold>
public enum NameClassificationKind implements Native.NativeUIntEnum {
  NC_Unknown(0),
  NC_Error(NC_Unknown.getValue() + 1),
  NC_Keyword(NC_Error.getValue() + 1),
  NC_Type(NC_Keyword.getValue() + 1),
  NC_Expression(NC_Type.getValue() + 1),
  NC_NestedNameSpecifier(NC_Expression.getValue() + 1),
  NC_TypeTemplate(NC_NestedNameSpecifier.getValue() + 1),
  NC_VarTemplate(NC_TypeTemplate.getValue() + 1),
  NC_FunctionTemplate(NC_VarTemplate.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static NameClassificationKind valueOf(int val) {
    NameClassificationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final NameClassificationKind[] VALUES;
    private static final NameClassificationKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (NameClassificationKind kind : NameClassificationKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new NameClassificationKind[min < 0 ? (1-min) : 0];
      VALUES = new NameClassificationKind[max >= 0 ? (1+max) : 0];
      for (NameClassificationKind kind : NameClassificationKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private NameClassificationKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// Kinds of missing import. Note, the values of these enumerators correspond
/// to %select values in diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MissingImportKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1884,
 FQN="clang::Sema::MissingImportKind", NM="_ZN5clang4Sema17MissingImportKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17MissingImportKindE")
//</editor-fold>
public enum /*class */MissingImportKind/* : int*/ implements Native.NativeIntEnum {
  Declaration(0),
  Definition(Declaration.getValue() + 1),
  DefaultArgument(Definition.getValue() + 1),
  ExplicitSpecialization(DefaultArgument.getValue() + 1),
  PartialSpecialization(ExplicitSpecialization.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static MissingImportKind valueOf(int val) {
    MissingImportKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final MissingImportKind[] VALUES;
    private static final MissingImportKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (MissingImportKind kind : MissingImportKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new MissingImportKind[min < 0 ? (1-min) : 0];
      VALUES = new MissingImportKind[max >= 0 ? (1+max) : 0];
      for (MissingImportKind kind : MissingImportKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final int value;
  private MissingImportKind(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TagUseKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1944,
 FQN="clang::Sema::TagUseKind", NM="_ZN5clang4Sema10TagUseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema10TagUseKindE")
//</editor-fold>
public enum TagUseKind implements Native.NativeUIntEnum {
  TUK_Reference(0), // Reference to a tag:  'struct foo *X;'
  TUK_Declaration(TUK_Reference.getValue() + 1), // Fwd decl of a tag:   'struct foo;'
  TUK_Definition(TUK_Declaration.getValue() + 1), // Definition of a tag: 'struct foo { int X; } Y;'
  TUK_Friend(TUK_Definition.getValue() + 1); // Friend declaration:  'friend struct foo;'

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TagUseKind valueOf(int val) {
    TagUseKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TagUseKind[] VALUES;
    private static final TagUseKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TagUseKind kind : TagUseKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TagUseKind[min < 0 ? (1-min) : 0];
      VALUES = new TagUseKind[max >= 0 ? (1+max) : 0];
      for (TagUseKind kind : TagUseKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private TagUseKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Describes the kind of merge to perform for availability
/// attributes (including "deprecated", "unavailable", and "availability").
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AvailabilityMergeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2149,
 FQN="clang::Sema::AvailabilityMergeKind", NM="_ZN5clang4Sema21AvailabilityMergeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21AvailabilityMergeKindE")
//</editor-fold>
public enum AvailabilityMergeKind implements Native.NativeUIntEnum {
  /// \brief Don't merge availability attributes at all.
  AMK_None(0),
  /// \brief Merge availability attributes for a redeclaration, which requires
  /// an exact match.
  AMK_Redeclaration(AMK_None.getValue() + 1),
  /// \brief Merge availability attributes for an override, which requires
  /// an exact match or a weakening of constraints.
  AMK_Override(AMK_Redeclaration.getValue() + 1),
  /// \brief Merge availability attributes for an implementation of
  /// a protocol requirement.
  AMK_ProtocolImplementation(AMK_Override.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AvailabilityMergeKind valueOf(int val) {
    AvailabilityMergeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AvailabilityMergeKind[] VALUES;
    private static final AvailabilityMergeKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AvailabilityMergeKind kind : AvailabilityMergeKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AvailabilityMergeKind[min < 0 ? (1-min) : 0];
      VALUES = new AvailabilityMergeKind[max >= 0 ? (1+max) : 0];
      for (AvailabilityMergeKind kind : AvailabilityMergeKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private AvailabilityMergeKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// AssignmentAction - This is used by all the assignment diagnostic functions
// to represent what is actually causing the operation
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AssignmentAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2223,
 FQN="clang::Sema::AssignmentAction", NM="_ZN5clang4Sema16AssignmentActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16AssignmentActionE")
//</editor-fold>
public enum AssignmentAction implements Native.NativeUIntEnum {
  AA_Assigning(0),
  AA_Passing(AA_Assigning.getValue() + 1),
  AA_Returning(AA_Passing.getValue() + 1),
  AA_Converting(AA_Returning.getValue() + 1),
  AA_Initializing(AA_Converting.getValue() + 1),
  AA_Sending(AA_Initializing.getValue() + 1),
  AA_Casting(AA_Sending.getValue() + 1),
  AA_Passing_CFAudited(AA_Casting.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AssignmentAction valueOf(int val) {
    AssignmentAction out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AssignmentAction[] VALUES;
    private static final AssignmentAction[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AssignmentAction kind : AssignmentAction.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AssignmentAction[min < 0 ? (1-min) : 0];
      VALUES = new AssignmentAction[max >= 0 ? (1+max) : 0];
      for (AssignmentAction kind : AssignmentAction.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private AssignmentAction(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// C++ Overloading.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::OverloadKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2235,
 FQN="clang::Sema::OverloadKind", NM="_ZN5clang4Sema12OverloadKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema12OverloadKindE")
//</editor-fold>
public enum OverloadKind implements Native.NativeUIntEnum {
  /// This is a legitimate overload: the existing declarations are
  /// functions or function templates with different signatures.
  Ovl_Overload(0),
  
  /// This is not an overload because the signature exactly matches
  /// an existing declaration.
  Ovl_Match(Ovl_Overload.getValue() + 1),
  
  /// This is not an overload because the lookup results contain a
  /// non-function.
  Ovl_NonFunction(Ovl_Match.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OverloadKind valueOf(int val) {
    OverloadKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OverloadKind[] VALUES;
    private static final OverloadKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OverloadKind kind : OverloadKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OverloadKind[min < 0 ? (1-min) : 0];
      VALUES = new OverloadKind[max >= 0 ? (1+max) : 0];
      for (OverloadKind kind : OverloadKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private OverloadKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// Contexts in which a converted constant expression is required.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CCEKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2332,
 FQN="clang::Sema::CCEKind", NM="_ZN5clang4Sema7CCEKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema7CCEKindE")
//</editor-fold>
public enum CCEKind implements Native.NativeUIntEnum {
  CCEK_CaseValue(0), ///< Expression in a case label.
  CCEK_Enumerator(CCEK_CaseValue.getValue() + 1), ///< Enumerator value with fixed underlying type.
  CCEK_TemplateArg(CCEK_Enumerator.getValue() + 1), ///< Value of a non-type template parameter.
  CCEK_NewExpr(CCEK_TemplateArg.getValue() + 1), ///< Constant expression in a noptr-new-declarator.
  CCEK_ConstexprIf(CCEK_NewExpr.getValue() + 1); ///< Condition in a constexpr if statement.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CCEKind valueOf(int val) {
    CCEKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CCEKind[] VALUES;
    private static final CCEKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CCEKind kind : CCEKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CCEKind[min < 0 ? (1-min) : 0];
      VALUES = new CCEKind[max >= 0 ? (1+max) : 0];
      for (CCEKind kind : CCEKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CCEKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCSubscriptKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2422,
 FQN="clang::Sema::ObjCSubscriptKind", NM="_ZN5clang4Sema17ObjCSubscriptKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17ObjCSubscriptKindE")
//</editor-fold>
public enum ObjCSubscriptKind implements Native.NativeUIntEnum {
  OS_Array(0),
  OS_Dictionary(OS_Array.getValue() + 1),
  OS_Error(OS_Dictionary.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ObjCSubscriptKind valueOf(int val) {
    ObjCSubscriptKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ObjCSubscriptKind[] VALUES;
    private static final ObjCSubscriptKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ObjCSubscriptKind kind : ObjCSubscriptKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ObjCSubscriptKind[min < 0 ? (1-min) : 0];
      VALUES = new ObjCSubscriptKind[max >= 0 ? (1+max) : 0];
      for (ObjCSubscriptKind kind : ObjCSubscriptKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ObjCSubscriptKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// Note that LK_String is intentionally after the other literals, as
// this is used for diagnostics logic.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCLiteralKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2431,
 FQN="clang::Sema::ObjCLiteralKind", NM="_ZN5clang4Sema15ObjCLiteralKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema15ObjCLiteralKindE")
//</editor-fold>
public enum ObjCLiteralKind implements Native.NativeUIntEnum {
  LK_Array(0),
  LK_Dictionary(LK_Array.getValue() + 1),
  LK_Numeric(LK_Dictionary.getValue() + 1),
  LK_Boxed(LK_Numeric.getValue() + 1),
  LK_String(LK_Boxed.getValue() + 1),
  LK_Block(LK_String.getValue() + 1),
  LK_None(LK_Block.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ObjCLiteralKind valueOf(int val) {
    ObjCLiteralKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ObjCLiteralKind[] VALUES;
    private static final ObjCLiteralKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ObjCLiteralKind kind : ObjCLiteralKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ObjCLiteralKind[min < 0 ? (1-min) : 0];
      VALUES = new ObjCLiteralKind[max >= 0 ? (1+max) : 0];
      for (ObjCLiteralKind kind : ObjCLiteralKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ObjCLiteralKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// An enum used to represent the different possible results of building a
// range-based for loop.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ForRangeStatus">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2605,
 FQN="clang::Sema::ForRangeStatus", NM="_ZN5clang4Sema14ForRangeStatusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14ForRangeStatusE")
//</editor-fold>
public enum ForRangeStatus implements Native.NativeUIntEnum {
  FRS_Success(0),
  FRS_NoViableFunction(FRS_Success.getValue() + 1),
  FRS_DiagnosticIssued(FRS_NoViableFunction.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ForRangeStatus valueOf(int val) {
    ForRangeStatus out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ForRangeStatus[] VALUES;
    private static final ForRangeStatus[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ForRangeStatus kind : ForRangeStatus.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ForRangeStatus[min < 0 ? (1-min) : 0];
      VALUES = new ForRangeStatus[max >= 0 ? (1+max) : 0];
      for (ForRangeStatus kind : ForRangeStatus.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ForRangeStatus(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \name Name lookup
///
/// These routines provide name lookup that is used during semantic
/// analysis to resolve the various kinds of names (identifiers,
/// overloaded operator names, constructor names, etc.) into zero or
/// more declarations within a particular scope. The major entry
/// points are LookupName, which performs unqualified name lookup,
/// and LookupQualifiedName, which performs qualified name lookup.
///
/// All name lookup is performed based on some specific criteria,
/// which specify what names will be visible to name lookup and how
/// far name lookup should work. These criteria are important both
/// for capturing language semantics (certain lookups will ignore
/// certain names, for example) and for performance, since name
/// lookup is often a bottleneck in the compilation of C++. Name
/// lookup criteria is specified via the LookupCriteria enumeration.
///
/// The results of name lookup can vary based on the kind of name
/// lookup performed, the current language, and the translation
/// unit. In C, for example, name lookup will either return nothing
/// (no entity found) or a single declaration. In C++, name lookup
/// can additionally refer to a set of overloaded functions or
/// result in an ambiguity. All of the possible results of name
/// lookup are captured by the LookupResult class, which provides
/// the ability to distinguish among them.
//@{

/// @brief Describes the kind of name lookup to perform.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupNameKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2701,
 FQN="clang::Sema::LookupNameKind", NM="_ZN5clang4Sema14LookupNameKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14LookupNameKindE")
//</editor-fold>
public enum LookupNameKind implements Native.NativeUIntEnum {
  /// Ordinary name lookup, which finds ordinary names (functions,
  /// variables, typedefs, etc.) in C and most kinds of names
  /// (functions, variables, members, types, etc.) in C++.
  LookupOrdinaryName(0),
  /// Tag name lookup, which finds the names of enums, classes,
  /// structs, and unions.
  LookupTagName(LookupOrdinaryName.getValue() + 1),
  /// Label name lookup.
  LookupLabel(LookupTagName.getValue() + 1),
  /// Member name lookup, which finds the names of
  /// class/struct/union members.
  LookupMemberName(LookupLabel.getValue() + 1),
  /// Look up of an operator name (e.g., operator+) for use with
  /// operator overloading. This lookup is similar to ordinary name
  /// lookup, but will ignore any declarations that are class members.
  LookupOperatorName(LookupMemberName.getValue() + 1),
  /// Look up of a name that precedes the '::' scope resolution
  /// operator in C++. This lookup completely ignores operator, object,
  /// function, and enumerator names (C++ [basic.lookup.qual]p1).
  LookupNestedNameSpecifierName(LookupOperatorName.getValue() + 1),
  /// Look up a namespace name within a C++ using directive or
  /// namespace alias definition, ignoring non-namespace names (C++
  /// [basic.lookup.udir]p1).
  LookupNamespaceName(LookupNestedNameSpecifierName.getValue() + 1),
  /// Look up all declarations in a scope with the given name,
  /// including resolved using declarations.  This is appropriate
  /// for checking redeclarations for a using declaration.
  LookupUsingDeclName(LookupNamespaceName.getValue() + 1),
  /// Look up an ordinary name that is going to be redeclared as a
  /// name with linkage. This lookup ignores any declarations that
  /// are outside of the current scope unless they have linkage. See
  /// C99 6.2.2p4-5 and C++ [basic.link]p6.
  LookupRedeclarationWithLinkage(LookupUsingDeclName.getValue() + 1),
  /// Look up a friend of a local class. This lookup does not look
  /// outside the innermost non-class scope. See C++11 [class.friend]p11.
  LookupLocalFriendName(LookupRedeclarationWithLinkage.getValue() + 1),
  /// Look up the name of an Objective-C protocol.
  LookupObjCProtocolName(LookupLocalFriendName.getValue() + 1),
  /// Look up implicit 'self' parameter of an objective-c method.
  LookupObjCImplicitSelfParam(LookupObjCProtocolName.getValue() + 1),
  /// \brief Look up the name of an OpenMP user-defined reduction operation.
  LookupOMPReductionName(LookupObjCImplicitSelfParam.getValue() + 1),
  /// \brief Look up any declaration with any name.
  LookupAnyName(LookupOMPReductionName.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LookupNameKind valueOf(int val) {
    LookupNameKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LookupNameKind[] VALUES;
    private static final LookupNameKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LookupNameKind kind : LookupNameKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LookupNameKind[min < 0 ? (1-min) : 0];
      VALUES = new LookupNameKind[max >= 0 ? (1+max) : 0];
      for (LookupNameKind kind : LookupNameKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LookupNameKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Specifies whether (or how) name lookup is being performed for a
/// redeclaration (vs. a reference).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RedeclarationKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2750,
 FQN="clang::Sema::RedeclarationKind", NM="_ZN5clang4Sema17RedeclarationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17RedeclarationKindE")
//</editor-fold>
public enum RedeclarationKind implements Native.NativeUIntEnum {
  /// \brief The lookup is a reference to this name that is not for the
  /// purpose of redeclaring the name.
  NotForRedeclaration(0),
  /// \brief The lookup results will be used for redeclaration of a name,
  /// if an entity by that name already exists.
  ForRedeclaration(NotForRedeclaration.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static RedeclarationKind valueOf(int val) {
    RedeclarationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final RedeclarationKind[] VALUES;
    private static final RedeclarationKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (RedeclarationKind kind : RedeclarationKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new RedeclarationKind[min < 0 ? (1-min) : 0];
      VALUES = new RedeclarationKind[max >= 0 ? (1+max) : 0];
      for (RedeclarationKind kind : RedeclarationKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private RedeclarationKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief The possible outcomes of name lookup for a literal operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LiteralOperatorLookupResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2760,
 FQN="clang::Sema::LiteralOperatorLookupResult", NM="_ZN5clang4Sema27LiteralOperatorLookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27LiteralOperatorLookupResultE")
//</editor-fold>
public enum LiteralOperatorLookupResult implements Native.NativeUIntEnum {
  /// \brief The lookup resulted in an error.
  LOLR_Error(0),
  /// \brief The lookup found a single 'cooked' literal operator, which
  /// expects a normal literal to be built and passed to it.
  LOLR_Cooked(LOLR_Error.getValue() + 1),
  /// \brief The lookup found a single 'raw' literal operator, which expects
  /// a string literal containing the spelling of the literal token.
  LOLR_Raw(LOLR_Cooked.getValue() + 1),
  /// \brief The lookup found an overload set of literal operator templates,
  /// which expect the characters of the spelling of the literal token to be
  /// passed as a non-type template argument pack.
  LOLR_Template(LOLR_Raw.getValue() + 1),
  /// \brief The lookup found an overload set of literal operator templates,
  /// which expect the character type and characters of the spelling of the
  /// string literal token to be passed as template arguments.
  LOLR_StringTemplate(LOLR_Template.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LiteralOperatorLookupResult valueOf(int val) {
    LiteralOperatorLookupResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LiteralOperatorLookupResult[] VALUES;
    private static final LiteralOperatorLookupResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LiteralOperatorLookupResult kind : LiteralOperatorLookupResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LiteralOperatorLookupResult[min < 0 ? (1-min) : 0];
      VALUES = new LiteralOperatorLookupResult[max >= 0 ? (1+max) : 0];
      for (LiteralOperatorLookupResult kind : LiteralOperatorLookupResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LiteralOperatorLookupResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectTypoKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2903,
 FQN="clang::Sema::CorrectTypoKind", NM="_ZN5clang4Sema15CorrectTypoKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema15CorrectTypoKindE")
//</editor-fold>
public enum CorrectTypoKind implements Native.NativeUIntEnum {
  CTK_NonError(0), // CorrectTypo used in a non error recovery situation.
  CTK_ErrorRecovery(CTK_NonError.getValue() + 1); // CorrectTypo used in normal error recovery.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CorrectTypoKind valueOf(int val) {
    CorrectTypoKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CorrectTypoKind[] VALUES;
    private static final CorrectTypoKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CorrectTypoKind kind : CorrectTypoKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CorrectTypoKind[min < 0 ? (1-min) : 0];
      VALUES = new CorrectTypoKind[max >= 0 ? (1+max) : 0];
      for (CorrectTypoKind kind : CorrectTypoKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CorrectTypoKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MethodMatchStrategy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3175,
 FQN="clang::Sema::MethodMatchStrategy", NM="_ZN5clang4Sema19MethodMatchStrategyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19MethodMatchStrategyE")
//</editor-fold>
public enum MethodMatchStrategy implements Native.NativeUIntEnum {
  MMS_loose(0),
  MMS_strict(MMS_loose.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static MethodMatchStrategy valueOf(int val) {
    MethodMatchStrategy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final MethodMatchStrategy[] VALUES;
    private static final MethodMatchStrategy[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (MethodMatchStrategy kind : MethodMatchStrategy.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new MethodMatchStrategy[min < 0 ? (1-min) : 0];
      VALUES = new MethodMatchStrategy[max >= 0 ? (1+max) : 0];
      for (MethodMatchStrategy kind : MethodMatchStrategy.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private MethodMatchStrategy(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildForRangeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3433,
 FQN="clang::Sema::BuildForRangeKind", NM="_ZN5clang4Sema17BuildForRangeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17BuildForRangeKindE")
//</editor-fold>
public enum BuildForRangeKind implements Native.NativeUIntEnum {
  /// Initial building of a for-range statement.
  BFRK_Build(0),
  /// Instantiation or recovery rebuild of a for-range statement. Don't
  /// attempt any typo-correction.
  BFRK_Rebuild(BFRK_Build.getValue() + 1),
  /// Determining whether a for-range statement could be built. Avoid any
  /// unnecessary or irreversible actions.
  BFRK_Check(BFRK_Rebuild.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static BuildForRangeKind valueOf(int val) {
    BuildForRangeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final BuildForRangeKind[] VALUES;
    private static final BuildForRangeKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (BuildForRangeKind kind : BuildForRangeKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new BuildForRangeKind[min < 0 ? (1-min) : 0];
      VALUES = new BuildForRangeKind[max >= 0 ? (1+max) : 0];
      for (BuildForRangeKind kind : BuildForRangeKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private BuildForRangeKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AvailabilityDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3621,
 FQN="clang::Sema::AvailabilityDiagnostic", NM="_ZN5clang4Sema22AvailabilityDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22AvailabilityDiagnosticE")
//</editor-fold>
public enum AvailabilityDiagnostic implements Native.NativeUIntEnum {
  AD_Deprecation(0),
  AD_Unavailable(AD_Deprecation.getValue() + 1),
  AD_Partial(AD_Unavailable.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AvailabilityDiagnostic valueOf(int val) {
    AvailabilityDiagnostic out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AvailabilityDiagnostic[] VALUES;
    private static final AvailabilityDiagnostic[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AvailabilityDiagnostic kind : AvailabilityDiagnostic.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AvailabilityDiagnostic[min < 0 ? (1-min) : 0];
      VALUES = new AvailabilityDiagnostic[max >= 0 ? (1+max) : 0];
      for (AvailabilityDiagnostic kind : AvailabilityDiagnostic.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private AvailabilityDiagnostic(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ReuseLambdaContextDecl_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3652,
 FQN="clang::Sema::ReuseLambdaContextDecl_t", NM="_ZN5clang4Sema24ReuseLambdaContextDecl_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24ReuseLambdaContextDecl_tE")
//</editor-fold>
public enum ReuseLambdaContextDecl_t implements Native.NativeUIntEnum {
  ReuseLambdaContextDecl(0);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ReuseLambdaContextDecl_t valueOf(int val) {
    ReuseLambdaContextDecl_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ReuseLambdaContextDecl_t[] VALUES;
    private static final ReuseLambdaContextDecl_t[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ReuseLambdaContextDecl_t kind : ReuseLambdaContextDecl_t.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ReuseLambdaContextDecl_t[min < 0 ? (1-min) : 0];
      VALUES = new ReuseLambdaContextDecl_t[max >= 0 ? (1+max) : 0];
      for (ReuseLambdaContextDecl_t kind : ReuseLambdaContextDecl_t.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ReuseLambdaContextDecl_t(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TryCaptureKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3687,
 FQN="clang::Sema::TryCaptureKind", NM="_ZN5clang4Sema14TryCaptureKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14TryCaptureKindE")
//</editor-fold>
public enum TryCaptureKind implements Native.NativeUIntEnum {
  TryCapture_Implicit(0),
  TryCapture_ExplicitByVal(TryCapture_Implicit.getValue() + 1),
  TryCapture_ExplicitByRef(TryCapture_ExplicitByVal.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TryCaptureKind valueOf(int val) {
    TryCaptureKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TryCaptureKind[] VALUES;
    private static final TryCaptureKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TryCaptureKind kind : TryCaptureKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TryCaptureKind[min < 0 ? (1-min) : 0];
      VALUES = new TryCaptureKind[max >= 0 ? (1+max) : 0];
      for (TryCaptureKind kind : TryCaptureKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private TryCaptureKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Describes the result of an "if-exists" condition check.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IfExistsResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4118,
 FQN="clang::Sema::IfExistsResult", NM="_ZN5clang4Sema14IfExistsResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14IfExistsResultE")
//</editor-fold>
public enum IfExistsResult implements Native.NativeUIntEnum {
  /// \brief The symbol exists.
  IER_Exists(0),
  
  /// \brief The symbol does not exist.
  IER_DoesNotExist(IER_Exists.getValue() + 1),
  
  /// \brief The name is a dependent name, so the results will differ
  /// from one instantiation to the next.
  IER_Dependent(IER_DoesNotExist.getValue() + 1),
  
  /// \brief An error occurred.
  IER_Error(IER_Dependent.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static IfExistsResult valueOf(int val) {
    IfExistsResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final IfExistsResult[] VALUES;
    private static final IfExistsResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (IfExistsResult kind : IfExistsResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new IfExistsResult[min < 0 ? (1-min) : 0];
      VALUES = new IfExistsResult[max >= 0 ? (1+max) : 0];
      for (IfExistsResult kind : IfExistsResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private IfExistsResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

//===--------------------------------------------------------------------===//
// C++ Access Control
//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AccessResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5556,
 FQN="clang::Sema::AccessResult", NM="_ZN5clang4Sema12AccessResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema12AccessResultE")
//</editor-fold>
public enum AccessResult implements Native.NativeUIntEnum {
  AR_accessible(0),
  AR_inaccessible(AR_accessible.getValue() + 1),
  AR_dependent(AR_inaccessible.getValue() + 1),
  AR_delayed(AR_dependent.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AccessResult valueOf(int val) {
    AccessResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AccessResult[] VALUES;
    private static final AccessResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AccessResult kind : AccessResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AccessResult[min < 0 ? (1-min) : 0];
      VALUES = new AccessResult[max >= 0 ? (1+max) : 0];
      for (AccessResult kind : AccessResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private AccessResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AbstractDiagSelID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5623,
 FQN="clang::Sema::AbstractDiagSelID", NM="_ZN5clang4Sema17AbstractDiagSelIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17AbstractDiagSelIDE")
//</editor-fold>
public enum AbstractDiagSelID implements Native.NativeIntEnum {
  AbstractNone(-1),
  AbstractReturnType(AbstractNone.getValue() + 1),
  AbstractParamType(AbstractReturnType.getValue() + 1),
  AbstractVariableType(AbstractParamType.getValue() + 1),
  AbstractFieldType(AbstractVariableType.getValue() + 1),
  AbstractIvarType(AbstractFieldType.getValue() + 1),
  AbstractSynthesizedIvarType(AbstractIvarType.getValue() + 1),
  AbstractArrayType(AbstractSynthesizedIvarType.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AbstractDiagSelID valueOf(int val) {
    AbstractDiagSelID out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AbstractDiagSelID[] VALUES;
    private static final AbstractDiagSelID[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AbstractDiagSelID kind : AbstractDiagSelID.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AbstractDiagSelID[min < 0 ? (1-min) : 0];
      VALUES = new AbstractDiagSelID[max >= 0 ? (1+max) : 0];
      for (AbstractDiagSelID kind : AbstractDiagSelID.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final int value;
  private AbstractDiagSelID(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  //</editor-fold>
}

/// \brief The context in which we are checking a template parameter list.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TemplateParamListContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5721,
 FQN="clang::Sema::TemplateParamListContext", NM="_ZN5clang4Sema24TemplateParamListContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24TemplateParamListContextE")
//</editor-fold>
public enum TemplateParamListContext implements Native.NativeUIntEnum {
  TPC_ClassTemplate(0),
  TPC_VarTemplate(TPC_ClassTemplate.getValue() + 1),
  TPC_FunctionTemplate(TPC_VarTemplate.getValue() + 1),
  TPC_ClassTemplateMember(TPC_FunctionTemplate.getValue() + 1),
  TPC_FriendClassTemplate(TPC_ClassTemplateMember.getValue() + 1),
  TPC_FriendFunctionTemplate(TPC_FriendClassTemplate.getValue() + 1),
  TPC_FriendFunctionTemplateDefinition(TPC_FriendFunctionTemplate.getValue() + 1),
  TPC_TypeAliasTemplate(TPC_FriendFunctionTemplateDefinition.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TemplateParamListContext valueOf(int val) {
    TemplateParamListContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TemplateParamListContext[] VALUES;
    private static final TemplateParamListContext[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TemplateParamListContext kind : TemplateParamListContext.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TemplateParamListContext[min < 0 ? (1-min) : 0];
      VALUES = new TemplateParamListContext[max >= 0 ? (1+max) : 0];
      for (TemplateParamListContext kind : TemplateParamListContext.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private TemplateParamListContext(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Specifies the context in which a particular template
/// argument is being checked.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgumentKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5889,
 FQN="clang::Sema::CheckTemplateArgumentKind", NM="_ZN5clang4Sema25CheckTemplateArgumentKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25CheckTemplateArgumentKindE")
//</editor-fold>
public enum CheckTemplateArgumentKind implements Native.NativeUIntEnum {
  /// \brief The template argument was specified in the code or was
  /// instantiated with some deduced template arguments.
  CTAK_Specified(0),
  
  /// \brief The template argument was deduced via template argument
  /// deduction.
  CTAK_Deduced(CTAK_Specified.getValue() + 1),
  
  /// \brief The template argument was deduced from an array bound
  /// via template argument deduction.
  CTAK_DeducedFromArrayBound(CTAK_Deduced.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CheckTemplateArgumentKind valueOf(int val) {
    CheckTemplateArgumentKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CheckTemplateArgumentKind[] VALUES;
    private static final CheckTemplateArgumentKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CheckTemplateArgumentKind kind : CheckTemplateArgumentKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CheckTemplateArgumentKind[min < 0 ? (1-min) : 0];
      VALUES = new CheckTemplateArgumentKind[max >= 0 ? (1+max) : 0];
      for (CheckTemplateArgumentKind kind : CheckTemplateArgumentKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CheckTemplateArgumentKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Enumeration describing how template parameter lists are compared
/// for equality.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TemplateParameterListEqualKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5963,
 FQN="clang::Sema::TemplateParameterListEqualKind", NM="_ZN5clang4Sema30TemplateParameterListEqualKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30TemplateParameterListEqualKindE")
//</editor-fold>
public enum TemplateParameterListEqualKind implements Native.NativeUIntEnum {
  /// \brief We are matching the template parameter lists of two templates
  /// that might be redeclarations.
  ///
  /// \code
  /// template<typename T> struct X;
  /// template<typename T> struct X;
  /// \endcode
  TPL_TemplateMatch(0),
  
  /// \brief We are matching the template parameter lists of two template
  /// template parameters as part of matching the template parameter lists
  /// of two templates that might be redeclarations.
  ///
  /// \code
  /// template<template<int I> class TT> struct X;
  /// template<template<int Value> class Other> struct X;
  /// \endcode
  TPL_TemplateTemplateParmMatch(TPL_TemplateMatch.getValue() + 1),
  
  /// \brief We are matching the template parameter lists of a template
  /// template argument against the template parameter lists of a template
  /// template parameter.
  ///
  /// \code
  /// template<template<int Value> class Metafun> struct X;
  /// template<int Value> struct integer_c;
  /// X<integer_c> xic;
  /// \endcode
  TPL_TemplateTemplateArgumentMatch(TPL_TemplateTemplateParmMatch.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TemplateParameterListEqualKind valueOf(int val) {
    TemplateParameterListEqualKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TemplateParameterListEqualKind[] VALUES;
    private static final TemplateParameterListEqualKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TemplateParameterListEqualKind kind : TemplateParameterListEqualKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TemplateParameterListEqualKind[min < 0 ? (1-min) : 0];
      VALUES = new TemplateParameterListEqualKind[max >= 0 ? (1+max) : 0];
      for (TemplateParameterListEqualKind kind : TemplateParameterListEqualKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private TemplateParameterListEqualKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief The context in which an unexpanded parameter pack is
/// being diagnosed.
///
/// Note that the values of this enumeration line up with the first
/// argument to the \c err_unexpanded_parameter_pack diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::UnexpandedParameterPackContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6077,
 FQN="clang::Sema::UnexpandedParameterPackContext", NM="_ZN5clang4Sema30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30UnexpandedParameterPackContextE")
//</editor-fold>
public enum UnexpandedParameterPackContext implements Native.NativeUIntEnum {
  /// \brief An arbitrary expression.
  UPPC_Expression(0),
  
  /// \brief The base type of a class type.
  UPPC_BaseType(UPPC_Expression.getValue() + 1),
  
  /// \brief The type of an arbitrary declaration.
  UPPC_DeclarationType(UPPC_BaseType.getValue() + 1),
  
  /// \brief The type of a data member.
  UPPC_DataMemberType(UPPC_DeclarationType.getValue() + 1),
  
  /// \brief The size of a bit-field.
  UPPC_BitFieldWidth(UPPC_DataMemberType.getValue() + 1),
  
  /// \brief The expression in a static assertion.
  UPPC_StaticAssertExpression(UPPC_BitFieldWidth.getValue() + 1),
  
  /// \brief The fixed underlying type of an enumeration.
  UPPC_FixedUnderlyingType(UPPC_StaticAssertExpression.getValue() + 1),
  
  /// \brief The enumerator value.
  UPPC_EnumeratorValue(UPPC_FixedUnderlyingType.getValue() + 1),
  
  /// \brief A using declaration.
  UPPC_UsingDeclaration(UPPC_EnumeratorValue.getValue() + 1),
  
  /// \brief A friend declaration.
  UPPC_FriendDeclaration(UPPC_UsingDeclaration.getValue() + 1),
  
  /// \brief A declaration qualifier.
  UPPC_DeclarationQualifier(UPPC_FriendDeclaration.getValue() + 1),
  
  /// \brief An initializer.
  UPPC_Initializer(UPPC_DeclarationQualifier.getValue() + 1),
  
  /// \brief A default argument.
  UPPC_DefaultArgument(UPPC_Initializer.getValue() + 1),
  
  /// \brief The type of a non-type template parameter.
  UPPC_NonTypeTemplateParameterType(UPPC_DefaultArgument.getValue() + 1),
  
  /// \brief The type of an exception.
  UPPC_ExceptionType(UPPC_NonTypeTemplateParameterType.getValue() + 1),
  
  /// \brief Partial specialization.
  UPPC_PartialSpecialization(UPPC_ExceptionType.getValue() + 1),
  
  /// \brief Microsoft __if_exists.
  UPPC_IfExists(UPPC_PartialSpecialization.getValue() + 1),
  
  /// \brief Microsoft __if_not_exists.
  UPPC_IfNotExists(UPPC_IfExists.getValue() + 1),
  
  /// \brief Lambda expression.
  UPPC_Lambda(UPPC_IfNotExists.getValue() + 1),
  
  /// \brief Block expression,
  UPPC_Block(UPPC_Lambda.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static UnexpandedParameterPackContext valueOf(int val) {
    UnexpandedParameterPackContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final UnexpandedParameterPackContext[] VALUES;
    private static final UnexpandedParameterPackContext[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (UnexpandedParameterPackContext kind : UnexpandedParameterPackContext.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new UnexpandedParameterPackContext[min < 0 ? (1-min) : 0];
      VALUES = new UnexpandedParameterPackContext[max >= 0 ? (1+max) : 0];
      for (UnexpandedParameterPackContext kind : UnexpandedParameterPackContext.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private UnexpandedParameterPackContext(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Describes the result of template argument deduction.
///
/// The TemplateDeductionResult enumeration describes the result of
/// template argument deduction, as returned from
/// DeduceTemplateArguments(). The separate TemplateDeductionInfo
/// structure provides additional information about the results of
/// template argument deduction, e.g., the deduced template argument
/// list (if successful) or the specific template parameters or
/// deduced arguments that were involved in the failure.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TemplateDeductionResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6414,
 FQN="clang::Sema::TemplateDeductionResult", NM="_ZN5clang4Sema23TemplateDeductionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23TemplateDeductionResultE")
//</editor-fold>
public enum TemplateDeductionResult implements Native.NativeUIntEnum {
  /// \brief Template argument deduction was successful.
  TDK_Success(0),
  /// \brief The declaration was invalid; do nothing.
  TDK_Invalid(TDK_Success.getValue() + 1),
  /// \brief Template argument deduction exceeded the maximum template
  /// instantiation depth (which has already been diagnosed).
  TDK_InstantiationDepth(TDK_Invalid.getValue() + 1),
  /// \brief Template argument deduction did not deduce a value
  /// for every template parameter.
  TDK_Incomplete(TDK_InstantiationDepth.getValue() + 1),
  /// \brief Template argument deduction produced inconsistent
  /// deduced values for the given template parameter.
  TDK_Inconsistent(TDK_Incomplete.getValue() + 1),
  /// \brief Template argument deduction failed due to inconsistent
  /// cv-qualifiers on a template parameter type that would
  /// otherwise be deduced, e.g., we tried to deduce T in "const T"
  /// but were given a non-const "X".
  TDK_Underqualified(TDK_Inconsistent.getValue() + 1),
  /// \brief Substitution of the deduced template argument values
  /// resulted in an error.
  TDK_SubstitutionFailure(TDK_Underqualified.getValue() + 1),
  /// \brief After substituting deduced template arguments, a dependent
  /// parameter type did not match the corresponding argument.
  TDK_DeducedMismatch(TDK_SubstitutionFailure.getValue() + 1),
  /// \brief A non-depnedent component of the parameter did not match the
  /// corresponding component of the argument.
  TDK_NonDeducedMismatch(TDK_DeducedMismatch.getValue() + 1),
  /// \brief When performing template argument deduction for a function
  /// template, there were too many call arguments.
  TDK_TooManyArguments(TDK_NonDeducedMismatch.getValue() + 1),
  /// \brief When performing template argument deduction for a function
  /// template, there were too few call arguments.
  TDK_TooFewArguments(TDK_TooManyArguments.getValue() + 1),
  /// \brief The explicitly-specified template arguments were not valid
  /// template arguments for the given template.
  TDK_InvalidExplicitArguments(TDK_TooFewArguments.getValue() + 1),
  /// \brief The arguments included an overloaded function name that could
  /// not be resolved to a suitable function.
  TDK_FailedOverloadResolution(TDK_InvalidExplicitArguments.getValue() + 1),
  /// \brief Deduction failed; that's all we know.
  TDK_MiscellaneousDeductionFailure(TDK_FailedOverloadResolution.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TemplateDeductionResult valueOf(int val) {
    TemplateDeductionResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TemplateDeductionResult[] VALUES;
    private static final TemplateDeductionResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TemplateDeductionResult kind : TemplateDeductionResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TemplateDeductionResult[min < 0 ? (1-min) : 0];
      VALUES = new TemplateDeductionResult[max >= 0 ? (1+max) : 0];
      for (TemplateDeductionResult kind : TemplateDeductionResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private TemplateDeductionResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Result type of DeduceAutoType.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceAutoResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6534,
 FQN="clang::Sema::DeduceAutoResult", NM="_ZN5clang4Sema16DeduceAutoResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16DeduceAutoResultE")
//</editor-fold>
public enum DeduceAutoResult implements Native.NativeUIntEnum {
  DAR_Succeeded(0),
  DAR_Failed(DAR_Succeeded.getValue() + 1),
  DAR_FailedAlreadyDiagnosed(DAR_Failed.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static DeduceAutoResult valueOf(int val) {
    DeduceAutoResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final DeduceAutoResult[] VALUES;
    private static final DeduceAutoResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (DeduceAutoResult kind : DeduceAutoResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new DeduceAutoResult[min < 0 ? (1-min) : 0];
      VALUES = new DeduceAutoResult[max >= 0 ? (1+max) : 0];
      for (DeduceAutoResult kind : DeduceAutoResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private DeduceAutoResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// Objective-C declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCContainerKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7310,
 FQN="clang::Sema::ObjCContainerKind", NM="_ZN5clang4Sema17ObjCContainerKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17ObjCContainerKindE")
//</editor-fold>
public enum ObjCContainerKind implements Native.NativeIntEnum {
  OCK_None(-1),
  OCK_Interface(0),
  OCK_Protocol(OCK_Interface.getValue() + 1),
  OCK_Category(OCK_Protocol.getValue() + 1),
  OCK_ClassExtension(OCK_Category.getValue() + 1),
  OCK_Implementation(OCK_ClassExtension.getValue() + 1),
  OCK_CategoryImplementation(OCK_Implementation.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ObjCContainerKind valueOf(int val) {
    ObjCContainerKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ObjCContainerKind[] VALUES;
    private static final ObjCContainerKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ObjCContainerKind kind : ObjCContainerKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ObjCContainerKind[min < 0 ? (1-min) : 0];
      VALUES = new ObjCContainerKind[max >= 0 ? (1+max) : 0];
      for (ObjCContainerKind kind : ObjCContainerKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final int value;
  private ObjCContainerKind(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCSpecialMethodKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7525,
 FQN="clang::Sema::ObjCSpecialMethodKind", NM="_ZN5clang4Sema21ObjCSpecialMethodKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21ObjCSpecialMethodKindE")
//</editor-fold>
public enum ObjCSpecialMethodKind implements Native.NativeUIntEnum {
  OSMK_None(0),
  OSMK_Alloc(OSMK_None.getValue() + 1),
  OSMK_New(OSMK_Alloc.getValue() + 1),
  OSMK_Copy(OSMK_New.getValue() + 1),
  OSMK_RetainingInit(OSMK_Copy.getValue() + 1),
  OSMK_NonRetainingInit(OSMK_RetainingInit.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ObjCSpecialMethodKind valueOf(int val) {
    ObjCSpecialMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ObjCSpecialMethodKind[] VALUES;
    private static final ObjCSpecialMethodKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ObjCSpecialMethodKind kind : ObjCSpecialMethodKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ObjCSpecialMethodKind[min < 0 ? (1-min) : 0];
      VALUES = new ObjCSpecialMethodKind[max >= 0 ? (1+max) : 0];
      for (ObjCSpecialMethodKind kind : ObjCSpecialMethodKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ObjCSpecialMethodKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Describes the kind of message expression indicated by a message
/// send that starts with an identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCMessageKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7588,
 FQN="clang::Sema::ObjCMessageKind", NM="_ZN5clang4Sema15ObjCMessageKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema15ObjCMessageKindE")
//</editor-fold>
public enum ObjCMessageKind implements Native.NativeUIntEnum {
  /// \brief The message is sent to 'super'.
  ObjCSuperMessage(0),
  /// \brief The message is an instance message.
  ObjCInstanceMessage(ObjCSuperMessage.getValue() + 1),
  /// \brief The message is a class message, and the identifier is a type
  /// name.
  ObjCClassMessage(ObjCInstanceMessage.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ObjCMessageKind valueOf(int val) {
    ObjCMessageKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ObjCMessageKind[] VALUES;
    private static final ObjCMessageKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ObjCMessageKind kind : ObjCMessageKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ObjCMessageKind[min < 0 ? (1-min) : 0];
      VALUES = new ObjCMessageKind[max >= 0 ? (1+max) : 0];
      for (ObjCMessageKind kind : ObjCMessageKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ObjCMessageKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief Describes the compatibility of a result type with its method.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ResultTypeCompatibilityKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7708,
 FQN="clang::Sema::ResultTypeCompatibilityKind", NM="_ZN5clang4Sema27ResultTypeCompatibilityKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27ResultTypeCompatibilityKindE")
//</editor-fold>
public enum ResultTypeCompatibilityKind implements Native.NativeUIntEnum {
  RTC_Compatible(0),
  RTC_Incompatible(RTC_Compatible.getValue() + 1),
  RTC_Unknown(RTC_Incompatible.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ResultTypeCompatibilityKind valueOf(int val) {
    ResultTypeCompatibilityKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ResultTypeCompatibilityKind[] VALUES;
    private static final ResultTypeCompatibilityKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ResultTypeCompatibilityKind kind : ResultTypeCompatibilityKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ResultTypeCompatibilityKind[min < 0 ? (1-min) : 0];
      VALUES = new ResultTypeCompatibilityKind[max >= 0 ? (1+max) : 0];
      for (ResultTypeCompatibilityKind kind : ResultTypeCompatibilityKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ResultTypeCompatibilityKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaOptionsAlignKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7718,
 FQN="clang::Sema::PragmaOptionsAlignKind", NM="_ZN5clang4Sema22PragmaOptionsAlignKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22PragmaOptionsAlignKindE")
//</editor-fold>
public enum PragmaOptionsAlignKind implements Native.NativeUIntEnum {
  POAK_Native(0), // #pragma options align=native
  POAK_Natural(POAK_Native.getValue() + 1), // #pragma options align=natural
  POAK_Packed(POAK_Natural.getValue() + 1), // #pragma options align=packed
  POAK_Power(POAK_Packed.getValue() + 1), // #pragma options align=power
  POAK_Mac68k(POAK_Power.getValue() + 1), // #pragma options align=mac68k
  POAK_Reset(POAK_Mac68k.getValue() + 1); // #pragma options align=reset

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static PragmaOptionsAlignKind valueOf(int val) {
    PragmaOptionsAlignKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final PragmaOptionsAlignKind[] VALUES;
    private static final PragmaOptionsAlignKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (PragmaOptionsAlignKind kind : PragmaOptionsAlignKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new PragmaOptionsAlignKind[min < 0 ? (1-min) : 0];
      VALUES = new PragmaOptionsAlignKind[max >= 0 ? (1+max) : 0];
      for (PragmaOptionsAlignKind kind : PragmaOptionsAlignKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private PragmaOptionsAlignKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaSectionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7755,
 FQN="clang::Sema::PragmaSectionKind", NM="_ZN5clang4Sema17PragmaSectionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17PragmaSectionKindE")
//</editor-fold>
public enum PragmaSectionKind implements Native.NativeUIntEnum {
  PSK_DataSeg(0),
  PSK_BSSSeg(PSK_DataSeg.getValue() + 1),
  PSK_ConstSeg(PSK_BSSSeg.getValue() + 1),
  PSK_CodeSeg(PSK_ConstSeg.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static PragmaSectionKind valueOf(int val) {
    PragmaSectionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final PragmaSectionKind[] VALUES;
    private static final PragmaSectionKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (PragmaSectionKind kind : PragmaSectionKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new PragmaSectionKind[min < 0 ? (1-min) : 0];
      VALUES = new PragmaSectionKind[max >= 0 ? (1+max) : 0];
      for (PragmaSectionKind kind : PragmaSectionKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private PragmaSectionKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \brief The kind of conversion being performed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckedConversionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8499,
 FQN="clang::Sema::CheckedConversionKind", NM="_ZN5clang4Sema21CheckedConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21CheckedConversionKindE")
//</editor-fold>
public enum CheckedConversionKind implements Native.NativeUIntEnum {
  /// \brief An implicit conversion.
  CCK_ImplicitConversion(0),
  /// \brief A C-style cast.
  CCK_CStyleCast(CCK_ImplicitConversion.getValue() + 1),
  /// \brief A functional-style cast.
  CCK_FunctionalCast(CCK_CStyleCast.getValue() + 1),
  /// \brief A cast other than a C-style cast.
  CCK_OtherCast(CCK_FunctionalCast.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CheckedConversionKind valueOf(int val) {
    CheckedConversionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CheckedConversionKind[] VALUES;
    private static final CheckedConversionKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CheckedConversionKind kind : CheckedConversionKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CheckedConversionKind[min < 0 ? (1-min) : 0];
      VALUES = new CheckedConversionKind[max >= 0 ? (1+max) : 0];
      for (CheckedConversionKind kind : CheckedConversionKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CheckedConversionKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// Used for emitting the right warning by DefaultVariadicArgumentPromotion
//<editor-fold defaultstate="collapsed" desc="clang::Sema::VariadicCallType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8558,
 FQN="clang::Sema::VariadicCallType", NM="_ZN5clang4Sema16VariadicCallTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16VariadicCallTypeE")
//</editor-fold>
public enum VariadicCallType implements Native.NativeUIntEnum {
  VariadicFunction(0),
  VariadicBlock(VariadicFunction.getValue() + 1),
  VariadicMethod(VariadicBlock.getValue() + 1),
  VariadicConstructor(VariadicMethod.getValue() + 1),
  VariadicDoesNotApply(VariadicConstructor.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static VariadicCallType valueOf(int val) {
    VariadicCallType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final VariadicCallType[] VALUES;
    private static final VariadicCallType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (VariadicCallType kind : VariadicCallType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new VariadicCallType[min < 0 ? (1-min) : 0];
      VALUES = new VariadicCallType[max >= 0 ? (1+max) : 0];
      for (VariadicCallType kind : VariadicCallType.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private VariadicCallType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// Used for determining in which context a type is allowed to be passed to a
// vararg function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::VarArgKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8572,
 FQN="clang::Sema::VarArgKind", NM="_ZN5clang4Sema10VarArgKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema10VarArgKindE")
//</editor-fold>
public enum VarArgKind implements Native.NativeUIntEnum {
  VAK_Valid(0),
  VAK_ValidInCXX11(VAK_Valid.getValue() + 1),
  VAK_Undefined(VAK_ValidInCXX11.getValue() + 1),
  VAK_MSVCUndefined(VAK_Undefined.getValue() + 1),
  VAK_Invalid(VAK_MSVCUndefined.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static VarArgKind valueOf(int val) {
    VarArgKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final VarArgKind[] VALUES;
    private static final VarArgKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (VarArgKind kind : VarArgKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new VarArgKind[min < 0 ? (1-min) : 0];
      VALUES = new VarArgKind[max >= 0 ? (1+max) : 0];
      for (VarArgKind kind : VarArgKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private VarArgKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// AssignConvertType - All of the 'assignment' semantic checks return this
/// enum to indicate whether the assignment was allowed.  These checks are
/// done for simple assignments, as well as initialization, return from
/// function, argument passing, etc.  The query is phrased in terms of a
/// source and destination type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AssignConvertType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8618,
 FQN="clang::Sema::AssignConvertType", NM="_ZN5clang4Sema17AssignConvertTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17AssignConvertTypeE")
//</editor-fold>
public enum AssignConvertType implements Native.NativeUIntEnum {
  /// Compatible - the types are compatible according to the standard.
  Compatible(0),
  
  /// PointerToInt - The assignment converts a pointer to an int, which we
  /// accept as an extension.
  PointerToInt(Compatible.getValue() + 1),
  
  /// IntToPointer - The assignment converts an int to a pointer, which we
  /// accept as an extension.
  IntToPointer(PointerToInt.getValue() + 1),
  
  /// FunctionVoidPointer - The assignment is between a function pointer and
  /// void*, which the standard doesn't allow, but we accept as an extension.
  FunctionVoidPointer(IntToPointer.getValue() + 1),
  
  /// IncompatiblePointer - The assignment is between two pointers types that
  /// are not compatible, but we accept them as an extension.
  IncompatiblePointer(FunctionVoidPointer.getValue() + 1),
  
  /// IncompatiblePointer - The assignment is between two pointers types which
  /// point to integers which have a different sign, but are otherwise
  /// identical. This is a subset of the above, but broken out because it's by
  /// far the most common case of incompatible pointers.
  IncompatiblePointerSign(IncompatiblePointer.getValue() + 1),
  
  /// CompatiblePointerDiscardsQualifiers - The assignment discards
  /// c/v/r qualifiers, which we accept as an extension.
  CompatiblePointerDiscardsQualifiers(IncompatiblePointerSign.getValue() + 1),
  
  /// IncompatiblePointerDiscardsQualifiers - The assignment
  /// discards qualifiers that we don't permit to be discarded,
  /// like address spaces.
  IncompatiblePointerDiscardsQualifiers(CompatiblePointerDiscardsQualifiers.getValue() + 1),
  
  /// IncompatibleNestedPointerQualifiers - The assignment is between two
  /// nested pointer types, and the qualifiers other than the first two
  /// levels differ e.g. char ** -> const char **, but we accept them as an
  /// extension.
  IncompatibleNestedPointerQualifiers(IncompatiblePointerDiscardsQualifiers.getValue() + 1),
  
  /// IncompatibleVectors - The assignment is between two vector types that
  /// have the same size, which we accept as an extension.
  IncompatibleVectors(IncompatibleNestedPointerQualifiers.getValue() + 1),
  
  /// IntToBlockPointer - The assignment converts an int to a block
  /// pointer. We disallow this.
  IntToBlockPointer(IncompatibleVectors.getValue() + 1),
  
  /// IncompatibleBlockPointer - The assignment is between two block
  /// pointers types that are not compatible.
  IncompatibleBlockPointer(IntToBlockPointer.getValue() + 1),
  
  /// IncompatibleObjCQualifiedId - The assignment is between a qualified
  /// id type and something else (that is incompatible with it). For example,
  /// "id <XXX>" = "Foo *", where "Foo *" doesn't implement the XXX protocol.
  IncompatibleObjCQualifiedId(IncompatibleBlockPointer.getValue() + 1),
  
  /// IncompatibleObjCWeakRef - Assigning a weak-unavailable object to an
  /// object with __weak qualifier.
  IncompatibleObjCWeakRef(IncompatibleObjCQualifiedId.getValue() + 1),
  
  /// Incompatible - We reject this conversion outright, it is invalid to
  /// represent it in the AST.
  Incompatible(IncompatibleObjCWeakRef.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AssignConvertType valueOf(int val) {
    AssignConvertType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AssignConvertType[] VALUES;
    private static final AssignConvertType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AssignConvertType kind : AssignConvertType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AssignConvertType[min < 0 ? (1-min) : 0];
      VALUES = new AssignConvertType[max >= 0 ? (1+max) : 0];
      for (AssignConvertType kind : AssignConvertType.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private AssignConvertType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// type checking C++ declaration initializers (C++ [dcl.init]).

/// ReferenceCompareResult - Expresses the result of comparing two
/// types (cv1 T1 and cv2 T2) to determine their compatibility for the
/// purposes of initialization by reference (C++ [dcl.init.ref]p4).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ReferenceCompareResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8853,
 FQN="clang::Sema::ReferenceCompareResult", NM="_ZN5clang4Sema22ReferenceCompareResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22ReferenceCompareResultE")
//</editor-fold>
public enum ReferenceCompareResult implements Native.NativeUIntEnum {
  /// Ref_Incompatible - The two types are incompatible, so direct
  /// reference binding is not possible.
  Ref_Incompatible(0),
  /// Ref_Related - The two types are reference-related, which means
  /// that their unqualified forms (T1 and T2) are either the same
  /// or T1 is a base class of T2.
  Ref_Related(Ref_Incompatible.getValue() + 1),
  /// Ref_Compatible_With_Added_Qualification - The two types are
  /// reference-compatible with added qualification, meaning that
  /// they are reference-compatible and the qualifiers on T1 (cv1)
  /// are greater than the qualifiers on T2 (cv2).
  Ref_Compatible_With_Added_Qualification(Ref_Related.getValue() + 1),
  /// Ref_Compatible - The two types are reference-compatible and
  /// have equivalent qualifiers (cv1 == cv2).
  Ref_Compatible(Ref_Compatible_With_Added_Qualification.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ReferenceCompareResult valueOf(int val) {
    ReferenceCompareResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ReferenceCompareResult[] VALUES;
    private static final ReferenceCompareResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ReferenceCompareResult kind : ReferenceCompareResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ReferenceCompareResult[min < 0 ? (1-min) : 0];
      VALUES = new ReferenceCompareResult[max >= 0 ? (1+max) : 0];
      for (ReferenceCompareResult kind : ReferenceCompareResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ReferenceCompareResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ARCConversionResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8914,
 FQN="clang::Sema::ARCConversionResult", NM="_ZN5clang4Sema19ARCConversionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19ARCConversionResultE")
//</editor-fold>
public enum ARCConversionResult implements Native.NativeUIntEnum {
  ACR_okay(0),
  ACR_unbridged(ACR_okay.getValue() + 1),
  ACR_error(ACR_unbridged.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ARCConversionResult valueOf(int val) {
    ARCConversionResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ARCConversionResult[] VALUES;
    private static final ARCConversionResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ARCConversionResult kind : ARCConversionResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ARCConversionResult[min < 0 ? (1-min) : 0];
      VALUES = new ARCConversionResult[max >= 0 ? (1+max) : 0];
      for (ARCConversionResult kind : ARCConversionResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ARCConversionResult(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9009,
 FQN="clang::Sema::ConditionKind", NM="_ZN5clang4Sema13ConditionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema13ConditionKindE")
//</editor-fold>
public enum /*class */ConditionKind/* : int*/ implements Native.NativeIntEnum {
  Boolean(0), ///< A boolean condition, from 'if', 'while', 'for', or 'do'.
  ConstexprIf(Boolean.getValue() + 1), ///< A constant boolean condition from 'if constexpr'.
  Switch(ConstexprIf.getValue() + 1); ///< An integral condition for a 'switch' statement.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ConditionKind valueOf(int val) {
    ConditionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ConditionKind[] VALUES;
    private static final ConditionKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ConditionKind kind : ConditionKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ConditionKind[min < 0 ? (1-min) : 0];
      VALUES = new ConditionKind[max >= 0 ? (1+max) : 0];
      for (ConditionKind kind : ConditionKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final int value;
  private ConditionKind(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CUDAFunctionTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9096,
 FQN="clang::Sema::CUDAFunctionTarget", NM="_ZN5clang4Sema18CUDAFunctionTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18CUDAFunctionTargetE")
//</editor-fold>
public enum CUDAFunctionTarget implements Native.NativeUIntEnum {
  CFT_Device(0),
  CFT_Global(CFT_Device.getValue() + 1),
  CFT_Host(CFT_Global.getValue() + 1),
  CFT_HostDevice(CFT_Host.getValue() + 1),
  CFT_InvalidTarget(CFT_HostDevice.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CUDAFunctionTarget valueOf(int val) {
    CUDAFunctionTarget out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CUDAFunctionTarget[] VALUES;
    private static final CUDAFunctionTarget[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CUDAFunctionTarget kind : CUDAFunctionTarget.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CUDAFunctionTarget[min < 0 ? (1-min) : 0];
      VALUES = new CUDAFunctionTarget[max >= 0 ? (1+max) : 0];
      for (CUDAFunctionTarget kind : CUDAFunctionTarget.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CUDAFunctionTarget(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

// CUDA function call preference. Must be ordered numerically from
// worst to best.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CUDAFunctionPreference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9108,
 FQN="clang::Sema::CUDAFunctionPreference", NM="_ZN5clang4Sema22CUDAFunctionPreferenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22CUDAFunctionPreferenceE")
//</editor-fold>
public enum CUDAFunctionPreference implements Native.NativeUIntEnum {
  CFP_Never(0), // Invalid caller/callee combination.
  CFP_WrongSide(CFP_Never.getValue() + 1), // Calls from host-device to host or device
  // function that do not match current compilation
  // mode. Only in effect if
  // LangOpts.CUDADisableTargetCallChecks is true.
  CFP_HostDevice(CFP_WrongSide.getValue() + 1), // Any calls to host/device functions.
  CFP_SameSide(CFP_HostDevice.getValue() + 1), // Calls from host-device to host or device
  // function matching current compilation mode.
  CFP_Native(CFP_SameSide.getValue() + 1); // host-to-host or device-to-device calls.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CUDAFunctionPreference valueOf(int val) {
    CUDAFunctionPreference out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CUDAFunctionPreference[] VALUES;
    private static final CUDAFunctionPreference[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CUDAFunctionPreference kind : CUDAFunctionPreference.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CUDAFunctionPreference[min < 0 ? (1-min) : 0];
      VALUES = new CUDAFunctionPreference[max >= 0 ? (1+max) : 0];
      for (CUDAFunctionPreference kind : CUDAFunctionPreference.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CUDAFunctionPreference(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}

/// \name Code completion
//@{
/// \brief Describes the context in which code completion occurs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParserCompletionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9177,
 FQN="clang::Sema::ParserCompletionContext", NM="_ZN5clang4Sema23ParserCompletionContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23ParserCompletionContextE")
//</editor-fold>
public enum ParserCompletionContext implements Native.NativeUIntEnum {
  /// \brief Code completion occurs at top-level or namespace context.
  PCC_Namespace(0),
  /// \brief Code completion occurs within a class, struct, or union.
  PCC_Class(PCC_Namespace.getValue() + 1),
  /// \brief Code completion occurs within an Objective-C interface, protocol,
  /// or category.
  PCC_ObjCInterface(PCC_Class.getValue() + 1),
  /// \brief Code completion occurs within an Objective-C implementation or
  /// category implementation
  PCC_ObjCImplementation(PCC_ObjCInterface.getValue() + 1),
  /// \brief Code completion occurs within the list of instance variables
  /// in an Objective-C interface, protocol, category, or implementation.
  PCC_ObjCInstanceVariableList(PCC_ObjCImplementation.getValue() + 1),
  /// \brief Code completion occurs following one or more template
  /// headers.
  PCC_Template(PCC_ObjCInstanceVariableList.getValue() + 1),
  /// \brief Code completion occurs following one or more template
  /// headers within a class.
  PCC_MemberTemplate(PCC_Template.getValue() + 1),
  /// \brief Code completion occurs within an expression.
  PCC_Expression(PCC_MemberTemplate.getValue() + 1),
  /// \brief Code completion occurs within a statement, which may
  /// also be an expression or a declaration.
  PCC_Statement(PCC_Expression.getValue() + 1),
  /// \brief Code completion occurs at the beginning of the
  /// initialization statement (or expression) in a for loop.
  PCC_ForInit(PCC_Statement.getValue() + 1),
  /// \brief Code completion occurs within the condition of an if,
  /// while, switch, or for statement.
  PCC_Condition(PCC_ForInit.getValue() + 1),
  /// \brief Code completion occurs within the body of a function on a
  /// recovery path, where we do not have a specific handle on our position
  /// in the grammar.
  PCC_RecoveryInFunction(PCC_Condition.getValue() + 1),
  /// \brief Code completion occurs where only a type is permitted.
  PCC_Type(PCC_RecoveryInFunction.getValue() + 1),
  /// \brief Code completion occurs in a parenthesized expression, which
  /// might also be a type cast.
  PCC_ParenthesizedExpression(PCC_Type.getValue() + 1),
  /// \brief Code completion occurs within a sequence of declaration
  /// specifiers within a function, method, or block.
  PCC_LocalDeclarationSpecifiers(PCC_ParenthesizedExpression.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ParserCompletionContext valueOf(int val) {
    ParserCompletionContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ParserCompletionContext[] VALUES;
    private static final ParserCompletionContext[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ParserCompletionContext kind : ParserCompletionContext.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ParserCompletionContext[min < 0 ? (1-min) : 0];
      VALUES = new ParserCompletionContext[max >= 0 ? (1+max) : 0];
      for (ParserCompletionContext kind : ParserCompletionContext.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ParserCompletionContext(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FormatStringType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9413,
 FQN="clang::Sema::FormatStringType", NM="_ZN5clang4Sema16FormatStringTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16FormatStringTypeE")
//</editor-fold>
public enum FormatStringType implements Native.NativeUIntEnum {
  FST_Scanf(0),
  FST_Printf(FST_Scanf.getValue() + 1),
  FST_NSString(FST_Printf.getValue() + 1),
  FST_Strftime(FST_NSString.getValue() + 1),
  FST_Strfmon(FST_Strftime.getValue() + 1),
  FST_Kprintf(FST_Strfmon.getValue() + 1),
  FST_FreeBSDKPrintf(FST_Kprintf.getValue() + 1),
  FST_OSTrace(FST_FreeBSDKPrintf.getValue() + 1),
  FST_Unknown(FST_OSTrace.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FormatStringType valueOf(int val) {
    FormatStringType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FormatStringType[] VALUES;
    private static final FormatStringType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FormatStringType kind : FormatStringType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FormatStringType[min < 0 ? (1-min) : 0];
      VALUES = new FormatStringType[max >= 0 ? (1+max) : 0];
      for (FormatStringType kind : FormatStringType.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private FormatStringType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  
  //</editor-fold>
}
} // END OF class Sema_NestedEnums
