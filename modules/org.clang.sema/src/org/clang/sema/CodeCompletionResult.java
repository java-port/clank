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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.clangc.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaCodeCompleteStatics.*;
import static org.clang.ast.AvailabilityResult.*;
import static org.clang.sema.impl.CodeCompleteConsumerStatics.getDeclAvailability;
import static org.clang.sema.impl.CodeCompleteConsumerStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Captures a result of code completion.
//<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 624,
 FQN="clang::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultE")
//</editor-fold>
public class CodeCompletionResult implements ComparableLower, NativePOD<CodeCompletionResult> {

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public CodeCompletionResult() { /* for collections */ }

  /*public:*/
  /// \brief Describes the kind of result generated.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::ResultKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 627,
   FQN="clang::CodeCompletionResult::ResultKind", NM="_ZN5clang20CodeCompletionResult10ResultKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResult10ResultKindE")
  //</editor-fold>
  public enum ResultKind implements Native.ComparableLower {
    RK_Declaration(0), ///< Refers to a declaration
    RK_Keyword(RK_Declaration.getValue() + 1), ///< Refers to a keyword or symbol.
    RK_Macro(RK_Keyword.getValue() + 1), ///< Refers to a macro
    RK_Pattern(RK_Macro.getValue() + 1); ///< Refers to a precomputed pattern.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ResultKind valueOf(int val) {
      ResultKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ResultKind[] VALUES;
      private static final ResultKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ResultKind kind : ResultKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ResultKind[min < 0 ? (1-min) : 0];
        VALUES = new ResultKind[max >= 0 ? (1+max) : 0];
        for (ResultKind kind : ResultKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ResultKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ResultKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ResultKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief When Kind == RK_Declaration or RK_Pattern, the declaration we are
  /// referring to. In the latter case, the declaration might be NULL.
  public /*const*/ NamedDecl /*P*/ Declaration;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 638,
   FQN="clang::CodeCompletionResult::(anonymous)", NM="_ZN5clang20CodeCompletionResultE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    /// \brief When Kind == RK_Keyword, the string representing the keyword
    /// or symbol's spelling.
    public /*const*/char$ptr/*char P*/ Keyword;
    
    /// \brief When Kind == RK_Pattern, the code-completion string that
    /// describes the completion text to insert.
    public CodeCompletionString /*P*/ Pattern;
    
    /// \brief When Kind == RK_Macro, the identifier that refers to a macro.
    public /*const*/ IdentifierInfo /*P*/ Macro;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 638,
     FQN="clang::CodeCompletionResult::(anonymous union)::", NM="_ZN5clang20CodeCompletionResultUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
      $assignMove($Prm0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 638,
     FQN="clang::CodeCompletionResult::(anonymous union)::operator=", NM="_ZN5clang20CodeCompletionResultUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
      
      this.Keyword = $tryClone($Prm0.Keyword);
      
      this.Pattern = $Prm0.Pattern;
      
      this.Macro = $Prm0.Macro;
      
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 638,
     FQN="clang::CodeCompletionResult::(anonymous union)::", NM="_ZN5clang20CodeCompletionResultUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResultUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
      $assign($Prm0);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 638,
     FQN="clang::CodeCompletionResult::(anonymous union)::operator=", NM="_ZN5clang20CodeCompletionResultUt_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResultUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
      
      this.Keyword = $tryClone($Prm0.Keyword);
      
      this.Pattern = $Prm0.Pattern;
      
      this.Macro = $Prm0.Macro;
      
      return /*Deref*/this;
    }

    protected Unnamed_union1() { }
    
    @Override public String toString() {
      return "" + "Keyword=" + Keyword // NOI18N
                + ", Pattern=" + Pattern // NOI18N
                + ", Macro=" + Macro; // NOI18N
    }
  };
  public Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
  
  /// \brief The priority of this particular code-completion result.
  public /*uint*/int Priority;
  
  /// \brief Specifies which parameter (of a function, Objective-C method,
  /// macro, etc.) we should start with when formatting the result.
  public /*uint*/int StartParameter;
  
  /// \brief The kind of result stored here.
  public ResultKind Kind;
  
  /// \brief The cursor kind that describes this result.
  public CXCursorKind CursorKind;
  
  /// \brief The availability of this result.
  public CXAvailabilityKind Availability;
  
  /// \brief Whether this result is hidden by another name.
  public /*JBIT bool*/ boolean Hidden /*: 1*/;
  
  /// \brief Whether this result was found via lookup into a base class.
  public /*JBIT bool*/ boolean QualifierIsInformative /*: 1*/;
  
  /// \brief Whether this declaration is the beginning of a
  /// nested-name-specifier and, therefore, should be followed by '::'.
  public /*JBIT bool*/ boolean StartsNestedNameSpecifier /*: 1*/;
  
  /// \brief Whether all parameters (of a function, Objective-C
  /// method, etc.) should be considered "informative".
  public /*JBIT bool*/ boolean AllParametersAreInformative /*: 1*/;
  
  /// \brief Whether we're completing a declaration of the given entity,
  /// rather than a use of that entity.
  public /*JBIT bool*/ boolean DeclaringEntity /*: 1*/;
  
  /// \brief If the result should have a nested-name-specifier, this is it.
  /// When \c QualifierIsInformative, the nested-name-specifier is
  /// informative rather than required.
  public NestedNameSpecifier /*P*/ Qualifier;
  
  /// \brief Build a result that refers to a declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 691,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1EPKNS_9NamedDeclEjPNS_19NestedNameSpecifierEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultC1EPKNS_9NamedDeclEjPNS_19NestedNameSpecifierEbb")
  //</editor-fold>
  public CodeCompletionResult(/*const*/ NamedDecl /*P*/ Declaration, 
      /*uint*/int Priority) {
    this(Declaration, 
      Priority, 
      (NestedNameSpecifier /*P*/ )null, 
      false, 
      true);
  }
  public CodeCompletionResult(/*const*/ NamedDecl /*P*/ Declaration, 
      /*uint*/int Priority, 
      NestedNameSpecifier /*P*/ Qualifier/*= null*/) {
    this(Declaration, 
      Priority, 
      Qualifier, 
      false, 
      true);
  }
  public CodeCompletionResult(/*const*/ NamedDecl /*P*/ Declaration, 
      /*uint*/int Priority, 
      NestedNameSpecifier /*P*/ Qualifier/*= null*/, 
      boolean QualifierIsInformative/*= false*/) {
    this(Declaration, 
      Priority, 
      Qualifier, 
      QualifierIsInformative, 
      true);
  }
  public CodeCompletionResult(/*const*/ NamedDecl /*P*/ Declaration, 
      /*uint*/int Priority, 
      NestedNameSpecifier /*P*/ Qualifier/*= null*/, 
      boolean QualifierIsInformative/*= false*/, 
      boolean Accessible/*= true*/) {
    // : Declaration(Declaration), Priority(Priority), StartParameter(0), Kind(RK_Declaration), Availability(CXAvailability_Available), Hidden(false), QualifierIsInformative(QualifierIsInformative), StartsNestedNameSpecifier(false), AllParametersAreInformative(false), DeclaringEntity(false), Qualifier(Qualifier) 
    //START JInit
    this.Declaration = Declaration;
    this.Priority = Priority;
    this.StartParameter = 0;
    this.Kind = ResultKind.RK_Declaration;
    this.Availability = CXAvailabilityKind.CXAvailability_Available;
    this.Hidden = false;
    this.QualifierIsInformative = QualifierIsInformative;
    this.StartsNestedNameSpecifier = false;
    this.AllParametersAreInformative = false;
    this.DeclaringEntity = false;
    this.Qualifier = Qualifier;
    //END JInit
    computeCursorKindAndAvailability(Accessible);
  }

  
  /// \brief Build a result that refers to a keyword or symbol.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 706,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1EPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultC1EPKcj")
  //</editor-fold>
  public CodeCompletionResult(/*const*/char$ptr/*char P*/ Keyword) {
    this(Keyword, CCP_Keyword);
  }
  public CodeCompletionResult(/*const*/char$ptr/*char P*/ Keyword, /*uint*/int Priority/*= CCP_Keyword*/) {
    // : Declaration(null), Keyword(Keyword), Priority(Priority), StartParameter(0), Kind(RK_Keyword), CursorKind(CXCursor_NotImplemented), Availability(CXAvailability_Available), Hidden(false), QualifierIsInformative(0), StartsNestedNameSpecifier(false), AllParametersAreInformative(false), DeclaringEntity(false), Qualifier(null) 
    //START JInit
    this.Declaration = null;
    /*Indirect*/this.Unnamed_field1.Keyword = $tryClone(Keyword);
    this.Priority = Priority;
    this.StartParameter = 0;
    this.Kind = ResultKind.RK_Keyword;
    this.CursorKind = CXCursorKind.CXCursor_NotImplemented;
    this.Availability = CXAvailabilityKind.CXAvailability_Available;
    this.Hidden = false;
    this.QualifierIsInformative = false;
    this.StartsNestedNameSpecifier = false;
    this.AllParametersAreInformative = false;
    this.DeclaringEntity = false;
    this.Qualifier = null;
    //END JInit
  }

  
  /// \brief Build a result that refers to a macro.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 715,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1EPKNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultC1EPKNS_14IdentifierInfoEj")
  //</editor-fold>
  public CodeCompletionResult(/*const*/ IdentifierInfo /*P*/ Macro) {
    this(Macro, 
      CCP_Macro);
  }
  public CodeCompletionResult(/*const*/ IdentifierInfo /*P*/ Macro, 
      /*uint*/int Priority/*= CCP_Macro*/) {
    // : Declaration(null), Macro(Macro), Priority(Priority), StartParameter(0), Kind(RK_Macro), CursorKind(CXCursor_MacroDefinition), Availability(CXAvailability_Available), Hidden(false), QualifierIsInformative(0), StartsNestedNameSpecifier(false), AllParametersAreInformative(false), DeclaringEntity(false), Qualifier(null) 
    //START JInit
    this.Declaration = null;
    /*Indirect*/this.Unnamed_field1.Macro = Macro;
    this.Priority = Priority;
    this.StartParameter = 0;
    this.Kind = ResultKind.RK_Macro;
    this.CursorKind = CXCursorKind.CXCursor_MacroDefinition;
    this.Availability = CXAvailabilityKind.CXAvailability_Available;
    this.Hidden = false;
    this.QualifierIsInformative = false;
    this.StartsNestedNameSpecifier = false;
    this.AllParametersAreInformative = false;
    this.DeclaringEntity = false;
    this.Qualifier = null;
    //END JInit
  }

  
  /// \brief Build a result that refers to a pattern.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 725,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1EPNS_20CodeCompletionStringEj12CXCursorKind18CXAvailabilityKindPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultC1EPNS_20CodeCompletionStringEj12CXCursorKind18CXAvailabilityKindPKNS_9NamedDeclE")
  //</editor-fold>
  public CodeCompletionResult(CodeCompletionString /*P*/ Pattern) {
    this(Pattern, 
      CCP_CodePattern, 
      CXCursorKind.CXCursor_NotImplemented, 
      CXAvailabilityKind.CXAvailability_Available, 
      (/*const*/ NamedDecl /*P*/ )null);
  }
  public CodeCompletionResult(CodeCompletionString /*P*/ Pattern, 
      /*uint*/int Priority/*= CCP_CodePattern*/) {
    this(Pattern, 
      Priority, 
      CXCursorKind.CXCursor_NotImplemented, 
      CXAvailabilityKind.CXAvailability_Available, 
      (/*const*/ NamedDecl /*P*/ )null);
  }
  public CodeCompletionResult(CodeCompletionString /*P*/ Pattern, 
      /*uint*/int Priority/*= CCP_CodePattern*/, 
      CXCursorKind CursorKind/*= CXCursor_NotImplemented*/) {
    this(Pattern, 
      Priority, 
      CursorKind, 
      CXAvailabilityKind.CXAvailability_Available, 
      (/*const*/ NamedDecl /*P*/ )null);
  }
  public CodeCompletionResult(CodeCompletionString /*P*/ Pattern, 
      /*uint*/int Priority/*= CCP_CodePattern*/, 
      CXCursorKind CursorKind/*= CXCursor_NotImplemented*/, 
      CXAvailabilityKind Availability/*= CXAvailability_Available*/) {
    this(Pattern, 
      Priority, 
      CursorKind, 
      Availability, 
      (/*const*/ NamedDecl /*P*/ )null);
  }
  public CodeCompletionResult(CodeCompletionString /*P*/ Pattern, 
      /*uint*/int Priority/*= CCP_CodePattern*/, 
      CXCursorKind CursorKind/*= CXCursor_NotImplemented*/, 
      CXAvailabilityKind Availability/*= CXAvailability_Available*/, 
      /*const*/ NamedDecl /*P*/ D/*= null*/) {
    // : Declaration(D), Pattern(Pattern), Priority(Priority), StartParameter(0), Kind(RK_Pattern), CursorKind(CursorKind), Availability(Availability), Hidden(false), QualifierIsInformative(0), StartsNestedNameSpecifier(false), AllParametersAreInformative(false), DeclaringEntity(false), Qualifier(null) 
    //START JInit
    this.Declaration = D;
    /*Indirect*/this.Unnamed_field1.Pattern = Pattern;
    this.Priority = Priority;
    this.StartParameter = 0;
    this.Kind = ResultKind.RK_Pattern;
    this.CursorKind = CursorKind;
    this.Availability = Availability;
    this.Hidden = false;
    this.QualifierIsInformative = false;
    this.StartsNestedNameSpecifier = false;
    this.AllParametersAreInformative = false;
    this.DeclaringEntity = false;
    this.Qualifier = null;
    //END JInit
  }

  
  /// \brief Build a result that refers to a pattern with an associated
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 740,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1EPNS_20CodeCompletionStringEPNS_9NamedDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultC1EPNS_20CodeCompletionStringEPNS_9NamedDeclEj")
  //</editor-fold>
  public CodeCompletionResult(CodeCompletionString /*P*/ Pattern, NamedDecl /*P*/ D, 
      /*uint*/int Priority) {
    // : Declaration(D), Pattern(Pattern), Priority(Priority), StartParameter(0), Kind(RK_Pattern), Availability(CXAvailability_Available), Hidden(false), QualifierIsInformative(false), StartsNestedNameSpecifier(false), AllParametersAreInformative(false), DeclaringEntity(false), Qualifier(null) 
    //START JInit
    this.Declaration = D;
    /*Indirect*/this.Unnamed_field1.Pattern = Pattern;
    this.Priority = Priority;
    this.StartParameter = 0;
    this.Kind = ResultKind.RK_Pattern;
    this.Availability = CXAvailabilityKind.CXAvailability_Available;
    this.Hidden = false;
    this.QualifierIsInformative = false;
    this.StartsNestedNameSpecifier = false;
    this.AllParametersAreInformative = false;
    this.DeclaringEntity = false;
    this.Qualifier = null;
    //END JInit
    computeCursorKindAndAvailability();
  }

  
  /// \brief Retrieve the declaration stored in this result.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::getDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 751,
   FQN="clang::CodeCompletionResult::getDeclaration", NM="_ZNK5clang20CodeCompletionResult14getDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionResult14getDeclarationEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getDeclaration() /*const*/ {
    assert (Kind == ResultKind.RK_Declaration) : "Not a declaration result";
    return Declaration;
  }

  
  /// \brief Retrieve the keyword stored in this result.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::getKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 757,
   FQN="clang::CodeCompletionResult::getKeyword", NM="_ZNK5clang20CodeCompletionResult10getKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionResult10getKeywordEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getKeyword() /*const*/ {
    assert (Kind == ResultKind.RK_Keyword) : "Not a keyword result";
    return Unnamed_field1.Keyword;
  }

  
  /// \brief Create a new code-completion string that describes how to insert
  /// this result into a program.
  ///
  /// \param S The semantic analysis that created the result.
  ///
  /// \param Allocator The allocator that will be used to allocate the
  /// string itself.
  
  /// \brief Create a new code-completion string that describes how to insert
  /// this result into a program.
  ///
  /// \param S The semantic analysis that created the result.
  ///
  /// \param Allocator The allocator that will be used to allocate the
  /// string itself.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CreateCodeCompletionString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2578,
   FQN="clang::CodeCompletionResult::CreateCodeCompletionString", NM="_ZN5clang20CodeCompletionResult26CreateCodeCompletionStringERNS_4SemaERKNS_21CodeCompletionContextERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResult26CreateCodeCompletionStringERNS_4SemaERKNS_21CodeCompletionContextERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEb")
  //</editor-fold>
  public CodeCompletionString /*P*/ CreateCodeCompletionString(final Sema /*&*/ S, 
                            final /*const*/ CodeCompletionContext /*&*/ CCContext, 
                            final CodeCompletionAllocator /*&*/ Allocator, 
                            final CodeCompletionTUInfo /*&*/ CCTUInfo, 
                            boolean IncludeBriefComments) {
    return CreateCodeCompletionString(S.Context, S.PP, CCContext, Allocator, 
        CCTUInfo, IncludeBriefComments);
  }


  
  /// \brief If possible, create a new code completion string for the given
  /// result.
  ///
  /// \returns Either a new, heap-allocated code completion string describing
  /// how to use this result, or NULL to indicate that the string or name of the
  /// result is all that is needed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CreateCodeCompletionString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2593,
   FQN="clang::CodeCompletionResult::CreateCodeCompletionString", NM="_ZN5clang20CodeCompletionResult26CreateCodeCompletionStringERNS_10ASTContextERNS_12PreprocessorERKNS_21CodeCompletionContextERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResult26CreateCodeCompletionStringERNS_10ASTContextERNS_12PreprocessorERKNS_21CodeCompletionContextERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEb")
  //</editor-fold>
  public CodeCompletionString /*P*/ CreateCodeCompletionString(final ASTContext /*&*/ Ctx, 
                            final Preprocessor /*&*/ PP, 
                            final /*const*/ CodeCompletionContext /*&*/ CCContext, 
                            final CodeCompletionAllocator /*&*/ Allocator, 
                            final CodeCompletionTUInfo /*&*/ CCTUInfo, 
                            boolean IncludeBriefComments) {
    CodeCompletionBuilder Result = null;
    try {
      Result/*J*/= new CodeCompletionBuilder(Allocator, CCTUInfo, Priority, Availability);
      
      PrintingPolicy Policy = getCompletionPrintingPolicy(Ctx, PP);
      if (Kind == ResultKind.RK_Pattern) {
        Unnamed_field1.Pattern.Priority = $uint2uint_16bits(Priority);
        Unnamed_field1.Pattern.Availability = $uint2uint_2bits(Availability.getValue());
        if ((Declaration != null)) {
          Result.addParentContext(Declaration.getDeclContext$Const());
          Unnamed_field1.Pattern.ParentName.$assignMove(Result.getParentName());
          // Provide code completion comment for self.GetterName where
          // GetterName is the getter method for a property with name
          // different from the property name (declared via a property
          // getter attribute.
          /*const*/ NamedDecl /*P*/ ND = Declaration;
          {
            /*const*/ ObjCMethodDecl /*P*/ M = dyn_cast_ObjCMethodDecl(ND);
            if ((M != null)) {
              if (M.isPropertyAccessor()) {
                {
                  /*const*/ ObjCPropertyDecl /*P*/ PDecl = M.findPropertyDecl();
                  if ((PDecl != null)) {
                    if (PDecl.getGetterName().$eq(M.getSelector())
                       && PDecl.getIdentifier() != M.getIdentifier()) {
                      {
                        /*const*/ RawComment /*P*/ RC = Ctx.getRawCommentForAnyRedecl(M);
                        if ((RC != null)) {
                          Result.addBriefComment(new StringRef(RC.getBriefText(Ctx)));
                          Unnamed_field1.Pattern.BriefComment = $tryClone(Result.getBriefComment());
                        } else {
                          /*const*/ RawComment /*P*/ _RC = Ctx.getRawCommentForAnyRedecl(PDecl);
                          if ((_RC != null)) {
                            Result.addBriefComment(new StringRef(_RC.getBriefText(Ctx)));
                            Unnamed_field1.Pattern.BriefComment = $tryClone(Result.getBriefComment());
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        
        return Unnamed_field1.Pattern;
      }
      if (Kind == ResultKind.RK_Keyword) {
        Result.AddTypedTextChunk(Unnamed_field1.Keyword);
        return Result.TakeString();
      }
      if (Kind == ResultKind.RK_Macro) {
        /*const*/ MacroInfo /*P*/ MI = PP.getMacroInfo(Unnamed_field1.Macro);
        Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(Unnamed_field1.Macro.getName())));
        if (!(MI != null) || !MI.isFunctionLike()) {
          return Result.TakeString();
        }
        
        // Format a function-like macro with placeholders for the arguments.
        Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        type$ptr<IdentifierInfo>/*arg_iterator*/ A = $tryClone(MI.arg_begin()), /*P*/ /*const*/ /*P*/ AEnd = $tryClone(MI.arg_end());
        
        // C99 variadic macros add __VA_ARGS__ at the end. Skip it.
        if (MI.isC99Varargs()) {
          AEnd.$preDec();
          if ($eq_ptr(A, AEnd)) {
            Result.AddPlaceholderChunk($ELLIPSIS);
          }
        }
        
        for (type$ptr<IdentifierInfo>/*arg_iterator*/ _A = $tryClone(MI.arg_begin()); $noteq_ptr(_A, AEnd); _A.$preInc()) {
          if ($noteq_ptr(_A, MI.arg_begin())) {
            Result.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
          }
          if (MI.isVariadic() && $eq_ptr((_A.$add(1)), AEnd)) {
            SmallString/*32*/ Arg = new SmallString/*32*/((_A.$star()).getName(), 32);
            if (MI.isC99Varargs()) {
              Arg.$addassign(/*STRINGREF_STR*/", ...");
            } else {
              Arg.$addassign(/*STRINGREF_STR*/"...");
            }
            Result.AddPlaceholderChunk(Result.getAllocator().CopyString(new Twine(Arg)));
            break;
          }
          
          // Non-variadic macros are simple.
          Result.AddPlaceholderChunk(Result.getAllocator().CopyString(new Twine((_A.$star()).getName())));
        }
        Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        return Result.TakeString();
      }
      assert (Kind == ResultKind.RK_Declaration) : "Missed a result kind?";
      /*const*/ NamedDecl /*P*/ ND = Declaration;
      Result.addParentContext(ND.getDeclContext$Const());
      if (IncludeBriefComments) {
        {
          // Add documentation comment, if it exists.
          /*const*/ RawComment /*P*/ RC = Ctx.getRawCommentForAnyRedecl(ND);
          if ((RC != null)) {
            Result.addBriefComment(new StringRef(RC.getBriefText(Ctx)));
          } else {
            /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(ND);
            if ((OMD != null)) {
              if (OMD.isPropertyAccessor()) {
                {
                  /*const*/ ObjCPropertyDecl /*P*/ PDecl = OMD.findPropertyDecl();
                  if ((PDecl != null)) {
                    {
                      /*const*/ RawComment /*P*/ _RC = Ctx.getRawCommentForAnyRedecl(PDecl);
                      if ((_RC != null)) {
                        Result.addBriefComment(new StringRef(_RC.getBriefText(Ctx)));
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (StartsNestedNameSpecifier) {
        Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(ND.getNameAsString())));
        Result.AddTextChunk($COLON_COLON);
        return Result.TakeString();
      }
      final iterator_range<AnnotateAttr> specific_attrs = ND.specific_attrs(AnnotateAttr.class);      
      for (/*const*/ AnnotateAttr /*P*/ I : specific_attrs)  {
        Result.AddAnnotation(Result.getAllocator().CopyString(new Twine(I.getAnnotation())));
      }
      
      AddResultTypeChunk(Ctx, Policy, ND, CCContext.getBaseType(), Result);
      {
        
        /*const*/ FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(ND);
        if ((Function != null)) {
          AddQualifierToCompletionString(Result, Qualifier, QualifierIsInformative, 
              Ctx, Policy);
          AddTypedNameChunk(Ctx, Policy, ND, Result);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          AddFunctionParameterChunks(PP, Policy, Function, Result);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          AddFunctionTypeQualsToCompletionString(Result, Function);
          return Result.TakeString();
        }
      }
      {
        
        /*const*/ FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(ND);
        if ((FunTmpl != null)) {
          AddQualifierToCompletionString(Result, Qualifier, QualifierIsInformative, 
              Ctx, Policy);
          FunctionDecl /*P*/ Function = FunTmpl.getTemplatedDecl();
          AddTypedNameChunk(Ctx, Policy, Function, Result);

          // Figure out which template parameters are deduced (or have default
          // arguments).
          SmallBitVector Deduced/*J*/= new SmallBitVector();
          Sema.MarkDeducedTemplateParameters(Ctx, FunTmpl, Deduced);
          /*uint*/int LastDeducibleArgument;
          for (LastDeducibleArgument = Deduced.size(); $greater_uint(LastDeducibleArgument, 0);
               --LastDeducibleArgument) {
            if (!Deduced.$at$Const(LastDeducibleArgument - 1)) {
              // C++0x: Figure out if the template argument has a default. If so,
              // the user doesn't need to type this argument.
              // FIXME: We need to abstract template parameters better!
              boolean HasDefaultArg = false;
              NamedDecl /*P*/ Param = FunTmpl.getTemplateParameters().getParam(LastDeducibleArgument - 1);
              {
                TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Param);
                if ((TTP != null)) {
                  HasDefaultArg = TTP.hasDefaultArgument();
                } else {
                  NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
                  if ((NTTP != null)) {
                    HasDefaultArg = NTTP.hasDefaultArgument();
                  } else {
                    assert (isa_TemplateTemplateParmDecl(Param));
                    HasDefaultArg
                       = cast_TemplateTemplateParmDecl(Param).hasDefaultArgument();
                  }
                }
              }
              if (!HasDefaultArg) {
                break;
              }
            }
          }
          if ((LastDeducibleArgument != 0)) {
            // Some of the function template arguments cannot be deduced from a
            // function call, so we introduce an explicit template argument list
            // containing all of the arguments up to the first deducible argument.
            Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
            AddTemplateParameterChunks(Ctx, Policy, FunTmpl, Result, 
                LastDeducibleArgument);
            Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
          }

          // Add the function parameters
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          AddFunctionParameterChunks(PP, Policy, Function, Result);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          AddFunctionTypeQualsToCompletionString(Result, Function);
          return Result.TakeString();
        }
      }
      {
        
        /*const*/ TemplateDecl /*P*/ Template = dyn_cast_TemplateDecl(ND);
        if ((Template != null)) {
          AddQualifierToCompletionString(Result, Qualifier, QualifierIsInformative, 
              Ctx, Policy);
          Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(Template.getNameAsString())));
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
          AddTemplateParameterChunks(Ctx, Policy, Template, Result);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
          return Result.TakeString();
        }
      }
      {
        
        /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(ND);
        if ((Method != null)) {
          Selector Sel = Method.getSelector();
          if (Sel.isUnarySelector()) {
            Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(Sel.getNameForSlot(0))));
            return Result.TakeString();
          }
          
          std.string SelName = Sel.getNameForSlot(0).str();
          SelName.$addassign_T($$COLON);
          if (StartParameter == 0) {
            Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(SelName)));
          } else {
            Result.AddInformativeChunk(Result.getAllocator().CopyString(new Twine(SelName)));
            
            // If there is only one parameter, and we're past it, add an empty
            // typed-text chunk since there is nothing to type.
            if (Method.param_size() == 1) {
              Result.AddTypedTextChunk($EMPTY);
            }
          }
          /*uint*/int Idx = 0;
          for (type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/ > P = $tryClone(Method.param_begin$Const()), 
              /*P*/ /*const*/ /*P*/ PEnd = $tryClone(Method.param_end$Const());
               $noteq_ptr(P, PEnd); P.$preInc() , ++Idx) {
            if ($greater_uint(Idx, 0)) {
              std.string Keyword/*J*/= new std.string();
              if ($greater_uint(Idx, StartParameter)) {
                Result.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
              }
              {
                IdentifierInfo /*P*/ II = Sel.getIdentifierInfoForSlot(Idx);
                if ((II != null)) {
                  $addassign_string_StringRef(Keyword, II.getName());
                }
              }
              Keyword.$addassign_T$C$P(/*KEEP_STR*/":");
              if ($less_uint(Idx, StartParameter) || AllParametersAreInformative) {
                Result.AddInformativeChunk(Result.getAllocator().CopyString(new Twine(Keyword)));
              } else {
                Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(Keyword)));
              }
            }
            
            // If we're before the starting parameter, skip the placeholder.
            if ($less_uint(Idx, StartParameter)) {
              continue;
            }
            
            std.string Arg/*J*/= new std.string();
            QualType ParamType = (P.$star()).getType();
            Optional<ArrayRef<QualType> > ObjCSubsts/*J*/= new Optional<ArrayRef<QualType> >();
            if (!CCContext.getBaseType().isNull()) {
              ObjCSubsts.$assignMove(CCContext.getBaseType().$arrow().getObjCSubstitutions(Method));
            }
            if (ParamType.$arrow().isBlockPointerType() && !DeclaringEntity) {
              Arg.$assignMove(FormatFunctionParameter(Policy, P.$star(), true, 
                      /*SuppressBlock=*/ false, 
                      new Optional<ArrayRef<QualType> >(ObjCSubsts)));
            } else {
              if (ObjCSubsts.$bool()) {
                ParamType.$assignMove(ParamType.substObjCTypeArgs(Ctx, new ArrayRef<QualType>(ObjCSubsts.$star()), 
                        ObjCSubstitutionContext.Parameter));
              }
              Arg.$assignMove($add_T$C$P_string(/*KEEP_STR*/"(", formatObjCParamQualifiers((P.$star()).getObjCDeclQualifier(), 
                          ParamType)));
              Arg.$addassign($add_string_T$C$P(ParamType.getAsString(Policy), /*KEEP_STR*/")"));
              {
                IdentifierInfo /*P*/ II = (P.$star()).getIdentifier();
                if ((II != null)) {
                  if (DeclaringEntity || AllParametersAreInformative) {
                    $addassign_string_StringRef(Arg, II.getName());
                  }
                }
              }
            }
            if (Method.isVariadic() && $eq_ptr((P.$add(1)), PEnd)) {
              Arg.$addassign_T$C$P(/*KEEP_STR*/", ...");
            }
            if (DeclaringEntity) {
              Result.AddTextChunk(Result.getAllocator().CopyString(new Twine(Arg)));
            } else if (AllParametersAreInformative) {
              Result.AddInformativeChunk(Result.getAllocator().CopyString(new Twine(Arg)));
            } else {
              Result.AddPlaceholderChunk(Result.getAllocator().CopyString(new Twine(Arg)));
            }
          }
          if (Method.isVariadic()) {
            if (Method.param_size() == 0) {
              if (DeclaringEntity) {
                Result.AddTextChunk($(", ..."));
              } else if (AllParametersAreInformative) {
                Result.AddInformativeChunk($(", ..."));
              } else {
                Result.AddPlaceholderChunk($(", ..."));
              }
            }
            
            MaybeAddSentinel(PP, Method, Result);
          }
          
          return Result.TakeString();
        }
      }
      if ((Qualifier != null)) {
        AddQualifierToCompletionString(Result, Qualifier, QualifierIsInformative, 
            Ctx, Policy);
      }
      
      Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(ND.getNameAsString())));
      return Result.TakeString();
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::computeCursorKindAndAvailability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 533,
   FQN="clang::CodeCompletionResult::computeCursorKindAndAvailability", NM="_ZN5clang20CodeCompletionResult32computeCursorKindAndAvailabilityEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResult32computeCursorKindAndAvailabilityEb")
  //</editor-fold>
  private void computeCursorKindAndAvailability() {
    computeCursorKindAndAvailability(true);
  }
  private void computeCursorKindAndAvailability(boolean Accessible/*= true*/) {
    switch (Kind) {
     case RK_Pattern:
      if (!(Declaration != null)) {
        // Do nothing: Patterns can come with cursor kinds!
        break;
      }
     case RK_Declaration:
      {
        // Set the availability based on attributes.
        switch (getDeclAvailability(Declaration)) {
         case AR_Available:
         case AR_NotYetIntroduced:
          Availability = CXAvailabilityKind.CXAvailability_Available;
          break;
         case AR_Deprecated:
          Availability = CXAvailabilityKind.CXAvailability_Deprecated;
          break;
         case AR_Unavailable:
          Availability = CXAvailabilityKind.CXAvailability_NotAvailable;
          break;
        }
        {
          
          /*const*/ FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(Declaration);
          if ((Function != null)) {
            if (Function.isDeleted()) {
              Availability = CXAvailabilityKind.CXAvailability_NotAvailable;
            }
          }
        }
        
        CursorKind = getCursorKindForDecl(Declaration);
        if (CursorKind == CXCursorKind.CXCursor_UnexposedDecl) {
          // FIXME: Forward declarations of Objective-C classes and protocols 
          // are not directly exposed, but we want code completion to treat them 
          // like a definition.
          if (isa_ObjCInterfaceDecl(Declaration)) {
            CursorKind = CXCursorKind.CXCursor_ObjCInterfaceDecl;
          } else if (isa_ObjCProtocolDecl(Declaration)) {
            CursorKind = CXCursorKind.CXCursor_ObjCProtocolDecl;
          } else {
            CursorKind = CXCursorKind.CXCursor_NotImplemented;
          }
        }
        break;
      }
     case RK_Macro:
     case RK_Keyword:
      throw new llvm_unreachable("Macro and keyword kinds are handled by the constructors");
    }
    if (!Accessible) {
      Availability = CXAvailabilityKind.CXAvailability_NotAccessible;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 624,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultC1EOS0_")
  //</editor-fold>
  public /*inline*/ CodeCompletionResult(JD$Move _dparam, final CodeCompletionResult /*&&*/$Prm0) {
    // : Declaration(static_cast<CodeCompletionResult &&>().Declaration), Unnamed_field1(static_cast<CodeCompletionResult &&>().), Priority(static_cast<CodeCompletionResult &&>().Priority), StartParameter(static_cast<CodeCompletionResult &&>().StartParameter), Kind(static_cast<CodeCompletionResult &&>().Kind), CursorKind(static_cast<CodeCompletionResult &&>().CursorKind), Availability(static_cast<CodeCompletionResult &&>().Availability), Hidden(static_cast<CodeCompletionResult &&>().Hidden), QualifierIsInformative(static_cast<CodeCompletionResult &&>().QualifierIsInformative), StartsNestedNameSpecifier(static_cast<CodeCompletionResult &&>().StartsNestedNameSpecifier), AllParametersAreInformative(static_cast<CodeCompletionResult &&>().AllParametersAreInformative), DeclaringEntity(static_cast<CodeCompletionResult &&>().DeclaringEntity), Qualifier(static_cast<CodeCompletionResult &&>().Qualifier) 
    //START JInit
    this.Declaration = $Prm0.Declaration;
    this.Unnamed_field1 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
    this.Priority = $Prm0.Priority;
    this.StartParameter = $Prm0.StartParameter;
    this.Kind = $Prm0.Kind;
    this.CursorKind = $Prm0.CursorKind;
    this.Availability = $Prm0.Availability;
    this.Hidden = $Prm0.Hidden;
    this.QualifierIsInformative = $Prm0.QualifierIsInformative;
    this.StartsNestedNameSpecifier = $Prm0.StartsNestedNameSpecifier;
    this.AllParametersAreInformative = $Prm0.AllParametersAreInformative;
    this.DeclaringEntity = $Prm0.DeclaringEntity;
    this.Qualifier = $Prm0.Qualifier;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 624,
   FQN="clang::CodeCompletionResult::operator=", NM="_ZN5clang20CodeCompletionResultaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionResultaSEOS0_")
  //</editor-fold>
  public /*inline*/ CodeCompletionResult /*&*/ $assignMove(final CodeCompletionResult /*&&*/$Prm0) {
    this.Declaration = $Prm0.Declaration;
    this.Unnamed_field1.$assignMove($Prm0.Unnamed_field1);
    this.Priority = $Prm0.Priority;
    this.StartParameter = $Prm0.StartParameter;
    this.Kind = $Prm0.Kind;
    this.CursorKind = $Prm0.CursorKind;
    this.Availability = $Prm0.Availability;
    this.Hidden = $Prm0.Hidden;
    this.QualifierIsInformative = $Prm0.QualifierIsInformative;
    this.StartsNestedNameSpecifier = $Prm0.StartsNestedNameSpecifier;
    this.AllParametersAreInformative = $Prm0.AllParametersAreInformative;
    this.DeclaringEntity = $Prm0.DeclaringEntity;
    this.Qualifier = $Prm0.Qualifier;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 624,
   FQN="clang::CodeCompletionResult::CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResultC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CodeCompletionResult(final /*const*/ CodeCompletionResult /*&*/ $Prm0) {
    // : Declaration(.Declaration), Unnamed_field1(.), Priority(.Priority), StartParameter(.StartParameter), Kind(.Kind), CursorKind(.CursorKind), Availability(.Availability), Hidden(.Hidden), QualifierIsInformative(.QualifierIsInformative), StartsNestedNameSpecifier(.StartsNestedNameSpecifier), AllParametersAreInformative(.AllParametersAreInformative), DeclaringEntity(.DeclaringEntity), Qualifier(.Qualifier) 
    //START JInit
    this.Declaration = $Prm0.Declaration;
    this.Unnamed_field1 = new Unnamed_union1($Prm0.Unnamed_field1);
    this.Priority = $Prm0.Priority;
    this.StartParameter = $Prm0.StartParameter;
    this.Kind = $Prm0.Kind;
    this.CursorKind = $Prm0.CursorKind;
    this.Availability = $Prm0.Availability;
    this.Hidden = $Prm0.Hidden;
    this.QualifierIsInformative = $Prm0.QualifierIsInformative;
    this.StartsNestedNameSpecifier = $Prm0.StartsNestedNameSpecifier;
    this.AllParametersAreInformative = $Prm0.AllParametersAreInformative;
    this.DeclaringEntity = $Prm0.DeclaringEntity;
    this.Qualifier = $Prm0.Qualifier;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::~CodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 624,
   FQN="clang::CodeCompletionResult::~CodeCompletionResult", NM="_ZN5clang20CodeCompletionResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResultD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 624,
   FQN="clang::CodeCompletionResult::operator=", NM="_ZN5clang20CodeCompletionResultaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompletionResultaSERKS0_")
  //</editor-fold>
  public /*inline*/ CodeCompletionResult /*&*/ $assign(final /*const*/ CodeCompletionResult /*&*/ $Prm0) {
    this.Declaration = $Prm0.Declaration;
    this.Unnamed_field1.$assign($Prm0.Unnamed_field1);
    this.Priority = $Prm0.Priority;
    this.StartParameter = $Prm0.StartParameter;
    this.Kind = $Prm0.Kind;
    this.CursorKind = $Prm0.CursorKind;
    this.Availability = $Prm0.Availability;
    this.Hidden = $Prm0.Hidden;
    this.QualifierIsInformative = $Prm0.QualifierIsInformative;
    this.StartsNestedNameSpecifier = $Prm0.StartsNestedNameSpecifier;
    this.AllParametersAreInformative = $Prm0.AllParametersAreInformative;
    this.DeclaringEntity = $Prm0.DeclaringEntity;
    this.Qualifier = $Prm0.Qualifier;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionResult::CodeCompletionResult">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 623)
  //</editor-fold>
  private static boolean $less(CodeCompletionResult /*const&*/ X, CodeCompletionResult /*const&*/  Y) {
    string XSaved = new string(), YSaved = new string();
    StringRef XStr = getOrderedName(X, XSaved);
    StringRef YStr = getOrderedName(Y, YSaved);
    int cmp = XStr.compare_lower(YStr);
    if (cmp != 0) {
      return cmp < 0;
    }

    // If case-insensitive comparison fails, try case-sensitive comparison.
    cmp = XStr.compare(YStr);
    if (cmp != 0) {
      return cmp < 0;
    }

    return false;
  }

  @Override public boolean $less(Object obj) { return $less(this, (CodeCompletionResult) obj); }
  
  @Override public CodeCompletionResult clone() { return new CodeCompletionResult(this); }
  
  @Override public String toString() {
    return "" + "Declaration=" + Declaration // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
              + ", Priority=" + Priority // NOI18N
              + ", StartParameter=" + StartParameter // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", CursorKind=" + CursorKind // NOI18N
              + ", Availability=" + Availability // NOI18N
              + ", Hidden=" + Hidden // NOI18N
              + ", QualifierIsInformative=" + QualifierIsInformative // NOI18N
              + ", StartsNestedNameSpecifier=" + StartsNestedNameSpecifier // NOI18N
              + ", AllParametersAreInformative=" + AllParametersAreInformative // NOI18N
              + ", DeclaringEntity=" + DeclaringEntity // NOI18N
              + ", Qualifier=" + Qualifier; // NOI18N
  }
}
