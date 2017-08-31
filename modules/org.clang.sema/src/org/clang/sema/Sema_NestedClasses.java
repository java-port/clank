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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.sema.java.SemaJavaDifferentiators.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_NestedClasses">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_NestedEnums ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema10SFINAETrapE;_ZN5clang4Sema11ContextRAIIE;_ZN5clang4Sema11FullExprArgE;_ZN5clang4Sema11ObjCArgInfoE;_ZN5clang4Sema11PragmaStackE;_ZN5clang4Sema11TypeTagDataE;_ZN5clang4Sema12SkipBodyInfoE;_ZN5clang4Sema13TypeDiagnoserE;_ZN5clang4Sema13TypoExprStateE;_ZN5clang4Sema15ConditionResultE;_ZN5clang4Sema15OriginalCallArgE;_ZN5clang4Sema16CXXThisScopeRAIIE;_ZN5clang4Sema16FormatStringInfoE;_ZN5clang4Sema17CompoundScopeRAIIE;_ZN5clang4Sema17FunctionScopeRAIIE;_ZN5clang4Sema17OffsetOfComponentE;_ZN5clang4Sema18BoundTypeDiagnoserE;_ZN5clang4Sema18DelayedDiagnosticsE;_ZN5clang4Sema18NameClassificationE;_ZN5clang4Sema18VerifyICEDiagnoserE;_ZN5clang4Sema19FPContractStateRAIIE;_ZN5clang4Sema19ICEConvertDiagnoserE;_ZN5clang4Sema21InstantiatingTemplateE;_ZN5clang4Sema21SemaDiagnosticBuilderE;_ZN5clang4Sema22TentativeAnalysisScopeE;_ZN5clang4Sema23DelayedDiagnosticsStateE;_ZN5clang4Sema23ExtParameterInfoBuilderE;_ZN5clang4Sema23PragmaStackSentinelRAIIE;_ZN5clang4Sema24InheritedConstructorInfoE;_ZN5clang4Sema24SynthesizedFunctionScopeE;_ZN5clang4Sema25LateInstantiatedAttributeE;_ZN5clang4Sema26ActOnMemberAccessExtraArgsE;_ZN5clang4Sema26CodeCompleteExpressionDataE;_ZN5clang4Sema27ActiveTemplateInstantiationE;_ZN5clang4Sema27ContextualImplicitConverterE;_ZN5clang4Sema27SpecialMemberOverloadResultE;_ZN5clang4Sema30ImplicitExceptionSpecificationE;_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIIE;_ZN5clang4Sema33ExpressionEvaluationContextRecordE;_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIIE;_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIIE;_ZN5clang4SemaE_Unnamed_class42;_ZN5clang4SemaE_Unnamed_class43; -static-type=Sema_NestedClasses -package=org.clang.sema")
//</editor-fold>
public class Sema_NestedClasses extends Sema_NestedEnums {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

/*template <typename ValueType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 343,
 FQN="clang::Sema::PragmaStack", NM="_ZN5clang4Sema11PragmaStackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStackE")
//</editor-fold>
public static class/*struct*/ PragmaStack</*typename*/ ValueType>  {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  void $destroy() {
    this.Stack.$destroy();
    Destructors.$destroy(this.CurrentValue);
    Destructors.$destroy(this.DefaultValue);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::Slot">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 345,
   FQN="clang::Sema::PragmaStack::Slot", NM="_ZN5clang4Sema11PragmaStack4SlotE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStack4SlotE")
  //</editor-fold>
    public static class/*struct*/ Slot<ValueType> {

    public StringRef StackSlotLabel;
    public ValueType Value;
    public SourceLocation PragmaLocation;
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::Slot::Slot">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 349,
     FQN="clang::Sema::PragmaStack::Slot::Slot", NM="_ZN5clang4Sema11PragmaStack4SlotC1EN4llvm9StringRefET_NS_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStack4SlotC1EN4llvm9StringRefET_NS_14SourceLocationE")
    //</editor-fold>
    public Slot(StringRef StackSlotLabel, 
        ValueType Value, 
        SourceLocation PragmaLocation) {
      // : StackSlotLabel(StackSlotLabel), Value(Value), PragmaLocation(PragmaLocation) 
      //START JInit
      this.StackSlotLabel = new StringRef(StackSlotLabel);
        this.Value = /*ParenListExpr*//*new ValueType(Default)*/ $tryClone(Value);
      this.PragmaLocation = new SourceLocation(PragmaLocation);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "StackSlotLabel=" + StackSlotLabel // NOI18N
                + ", Value=" + Value // NOI18N
                + ", PragmaLocation=" + PragmaLocation; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::Act">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 211,
   FQN="clang::Sema::PragmaStack::Act", NM="_ZN5clang4Sema11PragmaStack3ActENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema11PragmaStack3ActENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefET_")
  //</editor-fold>
  public final void Act(SourceLocation PragmaLocation, 
     /*PragmaMsStackAction*//*uint*/int Action, 
     StringRef StackSlotLabel, 
     ValueType Value) {
    if (Action == PragmaMsStackAction.PSK_Reset) {
      CurrentValue = DefaultValue;
      return;
    }
    if (((Action & PragmaMsStackAction.PSK_Push) != 0)) {
        Stack.push_back(new Slot(StackSlotLabel, CurrentValue, CurrentPragmaLocation));
    } else if (((Action & PragmaMsStackAction.PSK_Pop) != 0)) {
      if (!StackSlotLabel.empty()) {
        // If we've got a label, try to find it and jump there.
          /*<dependent type>*/
          std.reverse_iterator<Slot<ValueType>> I = (std.reverse_iterator<Slot<ValueType>>)llvm.find_if(llvm.reverse(Stack), /*[&]*/ (final /*const*/ Slot<ValueType> /*&*/ x) -> {
                  return Native.$eq(x.StackSlotLabel, StackSlotLabel);
                });
        // If we found the label so pop from there.
        if (Native.$noteq_iter(I, Stack.rend())) {
            CurrentValue = I.$star().Value;
            CurrentPragmaLocation = I.$star().PragmaLocation;
            // FIXME the cast type$ptr<Slot<ValueType>> below shoudl be removed. SmallVector.erase(type$iterator...) should be used instead
            Stack.erase(std.prev((type$ptr<Slot<ValueType>>)I.base()), Stack.end());
        }
      } else if (Native.$not(Stack.empty())) {
        // We don't have a label, just pop the last entry.
        CurrentValue = Stack.back().Value;
        CurrentPragmaLocation = Stack.back().PragmaLocation;
        Stack.pop_back();
      }
    }
    if (((Action & PragmaMsStackAction.PSK_Set) != 0)) {
      CurrentValue = Value;
      CurrentPragmaLocation = PragmaLocation;
    }
  }


  
  // MSVC seems to add artificial slots to #pragma stacks on entering a C++
  // method body to restore the stacks on exit, so it works like this:
  //
  //   struct S {
  //     #pragma <name>(push, InternalPragmaSlot, <current_pragma_value>)
  //     void Method {}
  //     #pragma <name>(pop, InternalPragmaSlot)
  //   };
  //
  // It works even with #pragma vtordisp, although MSVC doesn't support
  //   #pragma vtordisp(push [, id], n)
  // syntax.
  //
  // Push / pop a named sentinel slot.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::SentinelAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 374,
   FQN="clang::Sema::PragmaStack::SentinelAction", NM="_ZN5clang4Sema11PragmaStack14SentinelActionENS0_19PragmaMsStackActionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStack14SentinelActionENS0_19PragmaMsStackActionEN4llvm9StringRefE")
  //</editor-fold>
  public final void SentinelAction(/*PragmaMsStackAction*//*uint*/int Action, StringRef Label) {
    assert ((Action == PragmaMsStackAction.PSK_Push || Action == PragmaMsStackAction.PSK_Pop)) : "Can only push / pop #pragma stack sentinels!";
    Act(CurrentPragmaLocation, Action, Label, CurrentValue);
  }

  
  // Constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::PragmaStack<ValueType>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 381,
   FQN="clang::Sema::PragmaStack::PragmaStack<ValueType>", NM="_ZN5clang4Sema11PragmaStackC1ERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStackC1ERKT_")
  //</editor-fold>
  public /*explicit*/ PragmaStack(final /*const*/ ValueType /*&*/ Default) {
    // : DefaultValue(Default), CurrentValue(Default) 
    //START JInit
    this.DefaultValue = /*ParenListExpr*//*new ValueType*/ $tryClone(Default);
    this.CurrentValue = /*ParenListExpr*//*new ValueType(Default)*/ $tryClone(Default);
    //END JInit
    this.Stack = new SmallVector<Slot<ValueType>>(2);
    this.CurrentPragmaLocation = new SourceLocation();
  }

  public SmallVector<Slot<ValueType>> Stack;
  public ValueType DefaultValue; // Value used for PSK_Reset action.
  public ValueType CurrentValue;
  public SourceLocation CurrentPragmaLocation;
  
  @Override public String toString() {
    return "" + "Stack=" + Stack // NOI18N
              + ", DefaultValue=" + DefaultValue // NOI18N
              + ", CurrentValue=" + CurrentValue // NOI18N
              + ", CurrentPragmaLocation=" + CurrentPragmaLocation; // NOI18N
  }
  }

// RAII object to push / pop sentinel slots for all MS #pragma stacks.
// Actions should be performed only if we enter / exit a C++ method body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStackSentinelRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 413,
 FQN="clang::Sema::PragmaStackSentinelRAII", NM="_ZN5clang4Sema23PragmaStackSentinelRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23PragmaStackSentinelRAIIE")
//</editor-fold>
public static class PragmaStackSentinelRAII implements Destructors.ClassWithDestructor {
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Pragma 'pack' and 'options align'
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStackSentinelRAII::PragmaStackSentinelRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 28,
   FQN="clang::Sema::PragmaStackSentinelRAII::PragmaStackSentinelRAII", NM="_ZN5clang4Sema23PragmaStackSentinelRAIIC1ERS0_N4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema23PragmaStackSentinelRAIIC1ERS0_N4llvm9StringRefEb")
  //</editor-fold>
  public PragmaStackSentinelRAII(final Sema /*&*/ S, 
      StringRef SlotLabel, 
      boolean ShouldAct) {
    // : S(S), SlotLabel(SlotLabel), ShouldAct(ShouldAct) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.SlotLabel = new StringRef(SlotLabel);
    this.ShouldAct = ShouldAct;
    //END JInit
    if (ShouldAct) {
      S.VtorDispStack.SentinelAction(PragmaMsStackAction.PSK_Push, new StringRef(SlotLabel));
      S.DataSegStack.SentinelAction(PragmaMsStackAction.PSK_Push, new StringRef(SlotLabel));
      S.BSSSegStack.SentinelAction(PragmaMsStackAction.PSK_Push, new StringRef(SlotLabel));
      S.ConstSegStack.SentinelAction(PragmaMsStackAction.PSK_Push, new StringRef(SlotLabel));
      S.CodeSegStack.SentinelAction(PragmaMsStackAction.PSK_Push, new StringRef(SlotLabel));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStackSentinelRAII::~PragmaStackSentinelRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 41,
   FQN="clang::Sema::PragmaStackSentinelRAII::~PragmaStackSentinelRAII", NM="_ZN5clang4Sema23PragmaStackSentinelRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema23PragmaStackSentinelRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    if (ShouldAct) {
      S.VtorDispStack.SentinelAction(PragmaMsStackAction.PSK_Pop, new StringRef(SlotLabel));
      S.DataSegStack.SentinelAction(PragmaMsStackAction.PSK_Pop, new StringRef(SlotLabel));
      S.BSSSegStack.SentinelAction(PragmaMsStackAction.PSK_Pop, new StringRef(SlotLabel));
      S.ConstSegStack.SentinelAction(PragmaMsStackAction.PSK_Pop, new StringRef(SlotLabel));
      S.CodeSegStack.SentinelAction(PragmaMsStackAction.PSK_Pop, new StringRef(SlotLabel));
    }
  }


/*private:*/
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ StringRef SlotLabel;
  protected/*private*/ boolean ShouldAct;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SlotLabel=" + SlotLabel // NOI18N
              + ", ShouldAct=" + ShouldAct; // NOI18N
  }
}

/// A class which encapsulates the logic for delaying diagnostics
/// during parsing and other processing.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 582,
 FQN="clang::Sema::DelayedDiagnostics", NM="_ZN5clang4Sema18DelayedDiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnosticsE")
//</editor-fold>
public static class DelayedDiagnostics {
  /// \brief The current pool of diagnostics into which delayed
  /// diagnostics should go.
  protected/*private*/ DelayedDiagnosticPool /*P*/ CurPool;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::DelayedDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 588,
   FQN="clang::Sema::DelayedDiagnostics::DelayedDiagnostics", NM="_ZN5clang4Sema18DelayedDiagnosticsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnosticsC1Ev")
  //</editor-fold>
  public DelayedDiagnostics() {
    // : CurPool(null) 
    //START JInit
    this.CurPool = null;
    //END JInit
  }

  
  /// Adds a delayed diagnostic.
  
  /// Add a diagnostic to the current delay pool.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 297,
   FQN="clang::Sema::DelayedDiagnostics::add", NM="_ZN5clang4Sema18DelayedDiagnostics3addERKNS_4sema17DelayedDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnostics3addERKNS_4sema17DelayedDiagnosticE")
  //</editor-fold>
  public final /*inline*/ void add(final /*const*/ DelayedDiagnostic /*&*/ _diag) {
    assert (shouldDelayDiagnostics()) : "trying to delay without pool";
    CurPool.add(_diag);
  }
 // in DelayedDiagnostic.h
  
  /// Determines whether diagnostics should be delayed.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::shouldDelayDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 594,
   FQN="clang::Sema::DelayedDiagnostics::shouldDelayDiagnostics", NM="_ZN5clang4Sema18DelayedDiagnostics22shouldDelayDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnostics22shouldDelayDiagnosticsEv")
  //</editor-fold>
  public final boolean shouldDelayDiagnostics() {
    return CurPool != null;
  }

  
  /// Returns the current delayed-diagnostics pool.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::getCurrentPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 597,
   FQN="clang::Sema::DelayedDiagnostics::getCurrentPool", NM="_ZNK5clang4Sema18DelayedDiagnostics14getCurrentPoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema18DelayedDiagnostics14getCurrentPoolEv")
  //</editor-fold>
  public final DelayedDiagnosticPool /*P*/ getCurrentPool() /*const*/ {
    return CurPool;
  }

  
  /// Enter a new scope.  Access and deprecation diagnostics will be
  /// collected in this pool.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::push">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 603,
   FQN="clang::Sema::DelayedDiagnostics::push", NM="_ZN5clang4Sema18DelayedDiagnostics4pushERNS_4sema21DelayedDiagnosticPoolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnostics4pushERNS_4sema21DelayedDiagnosticPoolE")
  //</editor-fold>
  public final DelayedDiagnosticsState push(final DelayedDiagnosticPool /*&*/ pool) {
    DelayedDiagnosticsState state/*J*/= new DelayedDiagnosticsState();
    state.SavedPool = CurPool;
    CurPool = $AddrOf(pool);
    return state;
  }

  
  /// Leave a delayed-diagnostic state that was previously pushed.
  /// Do not emit any of the diagnostics.  This is performed as part
  /// of the bookkeeping of popping a pool "properly".
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::popWithoutEmitting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 613,
   FQN="clang::Sema::DelayedDiagnostics::popWithoutEmitting", NM="_ZN5clang4Sema18DelayedDiagnostics18popWithoutEmittingENS0_23DelayedDiagnosticsStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnostics18popWithoutEmittingENS0_23DelayedDiagnosticsStateE")
  //</editor-fold>
  public final void popWithoutEmitting(DelayedDiagnosticsState state) {
    CurPool = state.SavedPool;
  }

  
  /// Enter a new scope where access and deprecation diagnostics are
  /// not delayed.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::pushUndelayed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 619,
   FQN="clang::Sema::DelayedDiagnostics::pushUndelayed", NM="_ZN5clang4Sema18DelayedDiagnostics13pushUndelayedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnostics13pushUndelayedEv")
  //</editor-fold>
  public final DelayedDiagnosticsState pushUndelayed() {
    DelayedDiagnosticsState state/*J*/= new DelayedDiagnosticsState();
    state.SavedPool = CurPool;
    CurPool = null;
    return state;
  }

  
  /// Undo a previous pushUndelayed().
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnostics::popUndelayed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 627,
   FQN="clang::Sema::DelayedDiagnostics::popUndelayed", NM="_ZN5clang4Sema18DelayedDiagnostics12popUndelayedENS0_23DelayedDiagnosticsStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18DelayedDiagnostics12popUndelayedENS0_23DelayedDiagnosticsStateE")
  //</editor-fold>
  public final void popUndelayed(DelayedDiagnosticsState state) {
    assert (CurPool == null);
    CurPool = state.SavedPool;
  }

  
  @Override public String toString() {
    return "" + "CurPool=" + CurPool; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnosticsState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 573,
 FQN="clang::Sema::DelayedDiagnosticsState", NM="_ZN5clang4Sema23DelayedDiagnosticsStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23DelayedDiagnosticsStateE")
//</editor-fold>
public static class DelayedDiagnosticsState {
  protected/*private*/ DelayedDiagnosticPool /*P*/ SavedPool;
  /*friend  class Sema::DelayedDiagnostics*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnosticsState::DelayedDiagnosticsState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 573,
   FQN="clang::Sema::DelayedDiagnosticsState::DelayedDiagnosticsState", NM="_ZN5clang4Sema23DelayedDiagnosticsStateC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23DelayedDiagnosticsStateC1Ev")
  //</editor-fold>
  public /*inline*/ DelayedDiagnosticsState() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnosticsState::DelayedDiagnosticsState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 573,
   FQN="clang::Sema::DelayedDiagnosticsState::DelayedDiagnosticsState", NM="_ZN5clang4Sema23DelayedDiagnosticsStateC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23DelayedDiagnosticsStateC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DelayedDiagnosticsState(final /*const*/ DelayedDiagnosticsState /*&*/ $Prm0) {
    // : SavedPool(.SavedPool) 
    //START JInit
    this.SavedPool = $Prm0.SavedPool;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnosticsState::DelayedDiagnosticsState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 573,
   FQN="clang::Sema::DelayedDiagnosticsState::DelayedDiagnosticsState", NM="_ZN5clang4Sema23DelayedDiagnosticsStateC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23DelayedDiagnosticsStateC1EOS1_")
  //</editor-fold>
  public /*inline*/ DelayedDiagnosticsState(JD$Move _dparam, final DelayedDiagnosticsState /*&&*/$Prm0) {
    // : SavedPool(static_cast<DelayedDiagnosticsState &&>().SavedPool) 
    //START JInit
    this.SavedPool = $Prm0.SavedPool;
    //END JInit
    $Prm0.SavedPool = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::DelayedDiagnosticsState::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 573,
   FQN="clang::Sema::DelayedDiagnosticsState::operator=", NM="_ZN5clang4Sema23DelayedDiagnosticsStateaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23DelayedDiagnosticsStateaSEOS1_")
  //</editor-fold>
  public final /*inline*/ DelayedDiagnosticsState /*&*/ $assignMove(final DelayedDiagnosticsState /*&&*/$Prm0) {
    this.SavedPool = $Prm0.SavedPool;
    $Prm0.SavedPool = null;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "SavedPool=" + SavedPool; // NOI18N
  }
}

/// A RAII object to temporarily push a declaration context.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 634,
 FQN="clang::Sema::ContextRAII", NM="_ZN5clang4Sema11ContextRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11ContextRAIIE")
//</editor-fold>
public static class ContextRAII implements Destructors.ClassWithDestructor {
/*private:*/
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ DeclContext /*P*/ SavedContext;
  protected/*private*/ DelayedDiagnosticsState SavedContextState;
  protected/*private*/ QualType SavedCXXThisTypeOverride;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextRAII::ContextRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 642,
   FQN="clang::Sema::ContextRAII::ContextRAII", NM="_ZN5clang4Sema11ContextRAIIC1ERS0_PNS_11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11ContextRAIIC1ERS0_PNS_11DeclContextEb")
  //</editor-fold>
  public ContextRAII(final Sema /*&*/ S, DeclContext /*P*/ ContextToPush) {
    this(S, ContextToPush, true);
  }
  public ContextRAII(final Sema /*&*/ S, DeclContext /*P*/ ContextToPush, boolean NewThisContext/*= true*/) {
    // : S(S), SavedContext(S.CurContext), SavedContextState(S.DelayedDiagnostics.pushUndelayed()), SavedCXXThisTypeOverride(S.CXXThisTypeOverride) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.SavedContext = S.CurContext;
    this.SavedContextState = S.DelayedDiagnostics.pushUndelayed();
    this.SavedCXXThisTypeOverride = new QualType(S.CXXThisTypeOverride);
    //END JInit
    assert ((ContextToPush != null)) : "pushing null context";
    S.CurContext = ContextToPush;
    if (NewThisContext) {
      S.CXXThisTypeOverride.$assignMove(new QualType());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextRAII::pop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 653,
   FQN="clang::Sema::ContextRAII::pop", NM="_ZN5clang4Sema11ContextRAII3popEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11ContextRAII3popEv")
  //</editor-fold>
  public final void pop() {
    if (!(SavedContext != null)) {
      return;
    }
    S.CurContext = SavedContext;
    S.DelayedDiagnostics.popUndelayed(new DelayedDiagnosticsState(SavedContextState));
    S.CXXThisTypeOverride.$assign(SavedCXXThisTypeOverride);
    SavedContext = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextRAII::~ContextRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 661,
   FQN="clang::Sema::ContextRAII::~ContextRAII", NM="_ZN5clang4Sema11ContextRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11ContextRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    pop();
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SavedContext=" + "[DeclContext]" // NOI18N
              + ", SavedContextState=" + SavedContextState // NOI18N
              + ", SavedCXXThisTypeOverride=" + SavedCXXThisTypeOverride; // NOI18N
  }
}

/// \brief RAII object to handle the state changes required to synthesize
/// a function body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SynthesizedFunctionScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 668,
 FQN="clang::Sema::SynthesizedFunctionScope", NM="_ZN5clang4Sema24SynthesizedFunctionScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema24SynthesizedFunctionScopeE")
//</editor-fold>
public static class SynthesizedFunctionScope implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ Sema.ContextRAII SavedContext;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SynthesizedFunctionScope::SynthesizedFunctionScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 673,
   FQN="clang::Sema::SynthesizedFunctionScope::SynthesizedFunctionScope", NM="_ZN5clang4Sema24SynthesizedFunctionScopeC1ERS0_PNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema24SynthesizedFunctionScopeC1ERS0_PNS_11DeclContextE")
  //</editor-fold>
  public SynthesizedFunctionScope(final Sema /*&*/ S, DeclContext /*P*/ DC) {
    // : S(S), SavedContext(S, DC) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.SavedContext = new Sema.ContextRAII(S, DC);
    //END JInit
    S.PushFunctionScope();
    S.PushExpressionEvaluationContext(Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SynthesizedFunctionScope::~SynthesizedFunctionScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 680,
   FQN="clang::Sema::SynthesizedFunctionScope::~SynthesizedFunctionScope", NM="_ZN5clang4Sema24SynthesizedFunctionScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema24SynthesizedFunctionScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    S.PopExpressionEvaluationContext();
    S.PopFunctionScopeInfo();
    //START JDestroy
    SavedContext.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SavedContext=" + SavedContext; // NOI18N
  }
}

/// \brief Data structure used to record current or nested
/// expression evaluation contexts.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContextRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 834,
 FQN="clang::Sema::ExpressionEvaluationContextRecord", NM="_ZN5clang4Sema33ExpressionEvaluationContextRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema33ExpressionEvaluationContextRecordE")
//</editor-fold>
public static class/*struct*/ ExpressionEvaluationContextRecord implements Destructors.ClassWithDestructor {
  /// \brief The expression evaluation context.
  public ExpressionEvaluationContext Context;
  
  /// \brief Whether the enclosing context needed a cleanup.
  public CleanupInfo ParentCleanup;
  
  /// \brief Whether we are in a decltype expression.
  public boolean IsDecltype;
  
  /// \brief The number of active cleanup objects when we entered
  /// this expression evaluation context.
  public /*uint*/int NumCleanupObjects;
  
  /// \brief The number of typos encountered during this expression evaluation
  /// context (i.e. the number of TypoExprs created).
  public /*uint*/int NumTypos;
  
  public SmallPtrSet<Expr /*P*/ > SavedMaybeODRUseExprs;
  
  /// \brief The lambdas that are present within this context, if it
  /// is indeed an unevaluated context.
  public SmallVector<LambdaExpr /*P*/ > Lambdas;
  
  /// \brief The declaration that provides context for lambda expressions
  /// and block literals if the normal declaration context does not
  /// suffice, e.g., in a default function argument.
  public Decl /*P*/ ManglingContextDecl;
  
  /// \brief The context information used to mangle lambda expressions
  /// and block literals within this context.
  ///
  /// This mangling information is allocated lazily, since most contexts
  /// do not have lambda expressions or block literals.
  public IntrusiveRefCntPtr<MangleNumberingContext> MangleNumbering;
  
  /// \brief If we are processing a decltype type, a set of call expressions
  /// for which we have deferred checking the completeness of the return type.
  public SmallVector<CallExpr /*P*/ > DelayedDecltypeCalls;
  
  /// \brief If we are processing a decltype type, a set of temporary binding
  /// expressions for which we have deferred checking the destructor.
  public SmallVector<CXXBindTemporaryExpr /*P*/ > DelayedDecltypeBinds;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContextRecord::ExpressionEvaluationContextRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 878,
   FQN="clang::Sema::ExpressionEvaluationContextRecord::ExpressionEvaluationContextRecord", NM="_ZN5clang4Sema33ExpressionEvaluationContextRecordC1ENS0_27ExpressionEvaluationContextEjNS_11CleanupInfoEPNS_4DeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema33ExpressionEvaluationContextRecordC1ENS0_27ExpressionEvaluationContextEjNS_11CleanupInfoEPNS_4DeclEb")
  //</editor-fold>
  public ExpressionEvaluationContextRecord(ExpressionEvaluationContext Context, 
      /*uint*/int NumCleanupObjects, 
      CleanupInfo ParentCleanup, 
      Decl /*P*/ ManglingContextDecl, 
      boolean IsDecltype) {
    // : Context(Context), ParentCleanup(ParentCleanup), IsDecltype(IsDecltype), NumCleanupObjects(NumCleanupObjects), NumTypos(0), SavedMaybeODRUseExprs(), Lambdas(), ManglingContextDecl(ManglingContextDecl), MangleNumbering(), DelayedDecltypeCalls(), DelayedDecltypeBinds() 
    //START JInit
    this.Context = Context;
    this.ParentCleanup = new CleanupInfo(ParentCleanup);
    this.IsDecltype = IsDecltype;
    this.NumCleanupObjects = NumCleanupObjects;
    this.NumTypos = 0;
    this.SavedMaybeODRUseExprs = new SmallPtrSet<Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    this.Lambdas = new SmallVector<LambdaExpr /*P*/ >(2, (LambdaExpr /*P*/ )null);
    this.ManglingContextDecl = ManglingContextDecl;
    this.MangleNumbering = new IntrusiveRefCntPtr<MangleNumberingContext>();
    this.DelayedDecltypeCalls = new SmallVector<CallExpr /*P*/ >(8, (CallExpr /*P*/ )null);
    this.DelayedDecltypeBinds = new SmallVector<CXXBindTemporaryExpr /*P*/ >(8, (CXXBindTemporaryExpr /*P*/ )null);
    //END JInit
  }

  
  /// \brief Retrieve the mangling numbering context, used to consistently
  /// number constructs like lambdas for mangling.
  
  /// \brief Retrieve the mangling numbering context, used to consistently
  /// number constructs like lambdas for mangling.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContextRecord::getMangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 345,
   FQN="clang::Sema::ExpressionEvaluationContextRecord::getMangleNumberingContext", NM="_ZN5clang4Sema33ExpressionEvaluationContextRecord25getMangleNumberingContextERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema33ExpressionEvaluationContextRecord25getMangleNumberingContextERNS_10ASTContextE")
  //</editor-fold>
  public final MangleNumberingContext /*&*/ getMangleNumberingContext(final ASTContext /*&*/ Ctx) {
    assert ((ManglingContextDecl != null)) : "Need to have a context declaration";
    if (!MangleNumbering.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(MangleNumbering.$assign($c$.track(new IntrusiveRefCntPtr<MangleNumberingContext>(Ctx.createMangleNumberingContext()))));
      } finally {
        $c$.$destroy();
      }
    }
    return MangleNumbering.$star();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContextRecord::isUnevaluated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 892,
   FQN="clang::Sema::ExpressionEvaluationContextRecord::isUnevaluated", NM="_ZNK5clang4Sema33ExpressionEvaluationContextRecord13isUnevaluatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema33ExpressionEvaluationContextRecord13isUnevaluatedEv")
  //</editor-fold>
  public final boolean isUnevaluated() /*const*/ {
    return Context == ExpressionEvaluationContext.Unevaluated || Context == ExpressionEvaluationContext.UnevaluatedAbstract;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContextRecord::~ExpressionEvaluationContextRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 834,
   FQN="clang::Sema::ExpressionEvaluationContextRecord::~ExpressionEvaluationContextRecord", NM="_ZN5clang4Sema33ExpressionEvaluationContextRecordD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema33ExpressionEvaluationContextRecordD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    DelayedDecltypeBinds.$destroy();
    DelayedDecltypeCalls.$destroy();
    MangleNumbering.$destroy();
    Lambdas.$destroy();
    SavedMaybeODRUseExprs.$destroy();
    //END JDestroy
  }



  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExpressionEvaluationContextRecord::ExpressionEvaluationContextRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 834,
   FQN="clang::Sema::ExpressionEvaluationContextRecord::ExpressionEvaluationContextRecord", NM="_ZN5clang4Sema33ExpressionEvaluationContextRecordC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema33ExpressionEvaluationContextRecordC1EOS1_")
  //</editor-fold>
  public /*inline*/ ExpressionEvaluationContextRecord(JD$Move _dparam, final ExpressionEvaluationContextRecord /*&&*/$Prm0) {
    // : Context(static_cast<ExpressionEvaluationContextRecord &&>().Context), ParentCleanup(static_cast<ExpressionEvaluationContextRecord &&>().ParentCleanup), IsDecltype(static_cast<ExpressionEvaluationContextRecord &&>().IsDecltype), NumCleanupObjects(static_cast<ExpressionEvaluationContextRecord &&>().NumCleanupObjects), NumTypos(static_cast<ExpressionEvaluationContextRecord &&>().NumTypos), SavedMaybeODRUseExprs(static_cast<ExpressionEvaluationContextRecord &&>().SavedMaybeODRUseExprs), Lambdas(static_cast<ExpressionEvaluationContextRecord &&>().Lambdas), ManglingContextDecl(static_cast<ExpressionEvaluationContextRecord &&>().ManglingContextDecl), MangleNumbering(static_cast<ExpressionEvaluationContextRecord &&>().MangleNumbering), DelayedDecltypeCalls(static_cast<ExpressionEvaluationContextRecord &&>().DelayedDecltypeCalls), DelayedDecltypeBinds(static_cast<ExpressionEvaluationContextRecord &&>().DelayedDecltypeBinds) 
    //START JInit
    this.Context = $Prm0.Context;
    this.ParentCleanup = new CleanupInfo(JD$Move.INSTANCE, $Prm0.ParentCleanup);
    this.IsDecltype = $Prm0.IsDecltype;
    this.NumCleanupObjects = $Prm0.NumCleanupObjects;
    this.NumTypos = $Prm0.NumTypos;
    this.SavedMaybeODRUseExprs = new SmallPtrSet<Expr /*P*/ >(JD$Move.INSTANCE, $Prm0.SavedMaybeODRUseExprs);
    this.Lambdas = new SmallVector<LambdaExpr /*P*/ >(JD$Move.INSTANCE, $Prm0.Lambdas);
    this.ManglingContextDecl = $Prm0.ManglingContextDecl;
    this.MangleNumbering = new IntrusiveRefCntPtr<MangleNumberingContext>(JD$Move.INSTANCE, $Prm0.MangleNumbering);
    this.DelayedDecltypeCalls = new SmallVector<CallExpr /*P*/ >(JD$Move.INSTANCE, $Prm0.DelayedDecltypeCalls);
    this.DelayedDecltypeBinds = new SmallVector<CXXBindTemporaryExpr /*P*/ >(JD$Move.INSTANCE, $Prm0.DelayedDecltypeBinds);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ExpressionEvaluationContext]" // NOI18N
              + ", ParentCleanup=" + ParentCleanup // NOI18N
              + ", IsDecltype=" + IsDecltype // NOI18N
              + ", NumCleanupObjects=" + NumCleanupObjects // NOI18N
              + ", NumTypos=" + NumTypos // NOI18N
              + ", SavedMaybeODRUseExprs=" + SavedMaybeODRUseExprs // NOI18N
              + ", Lambdas=" + Lambdas // NOI18N
              + ", ManglingContextDecl=" + ManglingContextDecl // NOI18N
              + ", MangleNumbering=" + "[IntrusiveRefCntPtr$MangleNumberingContext]" // NOI18N
              + ", DelayedDecltypeCalls=" + DelayedDecltypeCalls // NOI18N
              + ", DelayedDecltypeBinds=" + DelayedDecltypeBinds; // NOI18N
  }
  }

/// SpecialMemberOverloadResult - The overloading result for a special member
/// function.
///
/// This is basically a wrapper around PointerIntPair. The lowest bits of the
/// integer are used to determine whether overload resolution succeeded.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 917,
 FQN="clang::Sema::SpecialMemberOverloadResult", NM="_ZN5clang4Sema27SpecialMemberOverloadResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27SpecialMemberOverloadResultE")
//</editor-fold>
public static class SpecialMemberOverloadResult extends /*public*/ FastFoldingSetNode implements Destructors.ClassWithDestructor {
  static FoldingSetTrait<SpecialMemberOverloadResult> TRAIT = new DefaultFoldingSetTrait<>();
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 919,
   FQN="clang::Sema::SpecialMemberOverloadResult::Kind", NM="_ZN5clang4Sema27SpecialMemberOverloadResult4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27SpecialMemberOverloadResult4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    NoMemberOrDeleted(0),
    Ambiguous(NoMemberOrDeleted.getValue() + 1),
    Success(Ambiguous.getValue() + 1);

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
/*private:*/
  protected/*private*/ PointerIntPair<CXXMethodDecl /*P*/ > Pair;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult::SpecialMemberOverloadResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 929,
   FQN="clang::Sema::SpecialMemberOverloadResult::SpecialMemberOverloadResult", NM="_ZN5clang4Sema27SpecialMemberOverloadResultC1ERKN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27SpecialMemberOverloadResultC1ERKN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public SpecialMemberOverloadResult(final /*const*/ FoldingSetNodeID /*&*/ ID) {
    // : FastFoldingSetNode(ID), Pair() 
    //START JInit
    super(ID);
    this.Pair = new PointerIntPair<CXXMethodDecl /*P*/ >();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult::getMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 933,
   FQN="clang::Sema::SpecialMemberOverloadResult::getMethod", NM="_ZNK5clang4Sema27SpecialMemberOverloadResult9getMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema27SpecialMemberOverloadResult9getMethodEv")
  //</editor-fold>
  public final CXXMethodDecl /*P*/ getMethod() /*const*/ {
    return Pair.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult::setMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 934,
   FQN="clang::Sema::SpecialMemberOverloadResult::setMethod", NM="_ZN5clang4Sema27SpecialMemberOverloadResult9setMethodEPNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27SpecialMemberOverloadResult9setMethodEPNS_13CXXMethodDeclE")
  //</editor-fold>
  public final void setMethod(CXXMethodDecl /*P*/ MD) {
    Pair.setPointer(MD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 936,
   FQN="clang::Sema::SpecialMemberOverloadResult::getKind", NM="_ZNK5clang4Sema27SpecialMemberOverloadResult7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema27SpecialMemberOverloadResult7getKindEv")
  //</editor-fold>
  public final Kind getKind() /*const*/ {
    return /*static_cast*/Kind.valueOf(Pair.getInt());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberOverloadResult::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 937,
   FQN="clang::Sema::SpecialMemberOverloadResult::setKind", NM="_ZN5clang4Sema27SpecialMemberOverloadResult7setKindENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27SpecialMemberOverloadResult7setKindENS1_4KindE")
  //</editor-fold>
  public final void setKind(Kind K) {
    Pair.setInt(K.getValue());
  }

  
  @Override public String toString() {
    return "" + "Pair=" + Pair // NOI18N
              + super.toString(); // NOI18N
  }
}

/// Records and restores the FP_CONTRACT state on entry/exit of compound
/// statements.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FPContractStateRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1038,
 FQN="clang::Sema::FPContractStateRAII", NM="_ZN5clang4Sema19FPContractStateRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19FPContractStateRAIIE")
//</editor-fold>
public static class FPContractStateRAII implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FPContractStateRAII::FPContractStateRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1040,
   FQN="clang::Sema::FPContractStateRAII::FPContractStateRAII", NM="_ZN5clang4Sema19FPContractStateRAIIC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19FPContractStateRAIIC1ERS0_")
  //</editor-fold>
  public FPContractStateRAII(final Sema /*&*/ S) {
    // : S(S), OldFPContractState(S.FPFeatures.fp_contract) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.OldFPContractState = S.FPFeatures.fp_contract;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FPContractStateRAII::~FPContractStateRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1042,
   FQN="clang::Sema::FPContractStateRAII::~FPContractStateRAII", NM="_ZN5clang4Sema19FPContractStateRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19FPContractStateRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    S.FPFeatures.fp_contract = OldFPContractState;
  }

/*private:*/
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ /*JBIT bool*/ boolean OldFPContractState /*: 1*/;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", OldFPContractState=" + OldFPContractState; // NOI18N
  }
}

/// \brief Helper class that creates diagnostics with optional
/// template instantiation stacks.
///
/// This class provides a wrapper around the basic DiagnosticBuilder
/// class that emits diagnostics. SemaDiagnosticBuilder is
/// responsible for emitting the diagnostic (as DiagnosticBuilder
/// does) and, if the diagnostic comes from inside a template
/// instantiation, printing the template instantiation stack as
/// well.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaDiagnosticBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1092,
 FQN="clang::Sema::SemaDiagnosticBuilder", NM="_ZN5clang4Sema21SemaDiagnosticBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21SemaDiagnosticBuilderE")
//</editor-fold>
public static class SemaDiagnosticBuilder extends /*public*/ DiagnosticBuilder implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ SemaRef;
  protected/*private*/ /*uint*/int DiagID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaDiagnosticBuilder::SemaDiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1097,
   FQN="clang::Sema::SemaDiagnosticBuilder::SemaDiagnosticBuilder", NM="_ZN5clang4Sema21SemaDiagnosticBuilderC1ERNS_17DiagnosticBuilderERS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21SemaDiagnosticBuilderC1ERNS_17DiagnosticBuilderERS0_j")
  //</editor-fold>
  public SemaDiagnosticBuilder(final DiagnosticBuilder /*&*/ DB, final Sema /*&*/ SemaRef, /*uint*/int DiagID) {
    // : DiagnosticBuilder(DB), SemaRef(SemaRef), DiagID(DiagID) 
    //START JInit
    super(DB);
    this./*&*/SemaRef=/*&*/SemaRef;
    this.DiagID = DiagID;
    //END JInit
  }

  
  // This is a cunning lie. DiagnosticBuilder actually performs move
  // construction in its copy constructor (but due to varied uses, it's not
  // possible to conveniently express this as actual move construction). So
  // the default copy ctor here is fine, because the base class disables the
  // source anyway, so the user-defined ~SemaDiagnosticBuilder is a safe no-op
  // in that case anwyay.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaDiagnosticBuilder::SemaDiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1106,
   FQN="clang::Sema::SemaDiagnosticBuilder::SemaDiagnosticBuilder", NM="_ZN5clang4Sema21SemaDiagnosticBuilderC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21SemaDiagnosticBuilderC1ERKS1_")
  //</editor-fold>
  public SemaDiagnosticBuilder(final /*const*/ SemaDiagnosticBuilder /*&*/ $Prm0) {
    // : DiagnosticBuilder(), SemaRef(.SemaRef), DiagID(.DiagID)/* = default*/ 
    //START JInit
    super($Prm0);
    this./*&*/SemaRef=/*&*/$Prm0.SemaRef;
    this.DiagID = $Prm0.DiagID;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaDiagnosticBuilder::~SemaDiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1108,
   FQN="clang::Sema::SemaDiagnosticBuilder::~SemaDiagnosticBuilder", NM="_ZN5clang4Sema21SemaDiagnosticBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21SemaDiagnosticBuilderD0Ev")
  //</editor-fold>
  public final void $destroy() {
    // If we aren't active, there is nothing to do.
    if (!isActive()) {
      return;
    }
    
    // Otherwise, we need to emit the diagnostic. First flush the underlying
    // DiagnosticBuilder data, and clear the diagnostic builder itself so it
    // won't emit the diagnostic in its own destructor.
    //
    // This seems wasteful, in that as written the DiagnosticBuilder dtor will
    // do its own needless checks to see if the diagnostic needs to be
    // emitted. However, because we take care to ensure that the builder
    // objects never escape, a sufficiently smart compiler will be able to
    // eliminate that code.
    FlushCounts();
    Clear();
    
    // Dispatch to Sema to emit the diagnostic.
    SemaRef.EmitCurrentDiagnostic(DiagID);
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*RangeBase as replacement of two classes*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_15CharSourceRangeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clanglsINS_15CharSourceRangeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>  
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_Range(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag,
          final /*const*/ org.clang.basic.java.RangeBase /*&*/ Value) {
    // called from (anonymous namespace)::CheckFormatHandler::EmitFormatDiagnostic
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    if (Value instanceof CharSourceRange) {
      $out_DiagnosticBuilder$C_CharSourceRange$C(BaseDiag, (CharSourceRange)Value);
    } else {
      $out_DiagnosticBuilder$C_SourceRange(BaseDiag, (SourceRange)Value);
    }
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ org.clang.basic.java.RangeBase /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_Range(Diag, Value);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIN4llvm8ArrayRefINS_9FixItHintEEEEERKNS_4Sema21SemaDiagnosticBuilderES8_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clanglsIN4llvm8ArrayRefINS_9FixItHintEEEEERKNS_4Sema21SemaDiagnosticBuilderES8_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_ArrayRef$FixItHint(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag,
          final /*const*/ ArrayRef<FixItHint> /*&*/ Value) {
    // called from (anonymous namespace)::CheckFormatHandler::EmitFormatDiagnostic
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_ArrayRef$FixItHint(Diag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ ArrayRef<FixItHint> /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_ArrayRef$FixItHint(Diag, Value);
  }

  /// Teach operator<< to produce an object of the correct type.
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_15CharSourceRangeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clanglsINS_15CharSourceRangeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_CharSourceRange(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ CharSourceRange /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_CharSourceRange$C(BaseDiag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ CharSourceRange /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_CharSourceRange(Diag, Value);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_8SelectorEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clanglsINS_8SelectorEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_Selector(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag,
          final /*const*/ Selector /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_DeclarationName(BaseDiag, getPrintable(Value));
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ Selector /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_Selector(Diag, Value);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPNS_4ExprEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clanglsIPNS_4ExprEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_Expr(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final Expr /*P*/ /*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_TemplateArgument$C(BaseDiag, new TemplateArgument(Value));
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ Expr /*P*/ Value) {
    return $out_SemaDiagnosticBuilder_Expr(Diag, /*NO_COPY*/Value);
  } 
  
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_16TemplateArgumentEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clanglsINS_16TemplateArgumentEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_TemplateArgument(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ TemplateArgument /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_TemplateArgument$C(BaseDiag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ TemplateArgument /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_TemplateArgument(Diag, /*NO_COPY*/Value);
  }  
    
//  /// Teach operator<< to produce an object of the correct type.
//  /*friend*//*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
//  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
//   FQN="clang::operator<<", NM="Tpl__ZN5clanglsERKNS_4Sema21SemaDiagnosticBuilderERKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=Tpl__ZN5clanglsERKNS_4Sema21SemaDiagnosticBuilderERKT_")
//  //</editor-fold>
//  public static </*typename*/ T> /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, final /*const*/ T /*&*/ Value) {
//    if (Value instanceof java.lang.Enum) {
//      NativeTrace.printStackTraceOnce(new UnsupportedOperationException("Mark your enum " + NativeTrace.getIdentityStr(Value) + " to be appropriate Native*Enum type"));
//    } else {
//      NativeTrace.printStackTraceOnce(new UnsupportedOperationException("EmptyBody / Reconvert caller with instantiation might help. Use specialization based on $out_DiagnosticBuilder* instead. Class is : " + NativeTrace.getIdentityStr(Value)));
//    }
//    return Diag;
//  }


  /// Teach operator<< to produce an object of the correct type.
  //</*typename*/ T/* = boolean*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_ADDED/*For Enumerators*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>  
//  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, final /*const*/ java.lang.Enum /*&*/ Value) {
//    if (Value instanceof NativeUIntEnum) {
//      return $out_SemaDiagnosticBuilder_uint(Diag, ((NativeUIntEnum)Value).getValue());
//    } else if (Value instanceof NativeIntEnum) {
//      return $out_SemaDiagnosticBuilder_int(Diag, ((NativeIntEnum)Value).getValue());
//    } else if (Value instanceof NativeUShortEnum) {
//      return $out_SemaDiagnosticBuilder_uint(Diag, $ushort2uint(((NativeUShortEnum)Value).getValue()));
//    } else if (Value instanceof NativeUCharEnum) {
//      return $out_SemaDiagnosticBuilder_uint(Diag, $uchar2uint(((NativeUCharEnum)Value).getValue()));
//    }
//    NativeTrace.printStackTraceOnce(new UnsupportedOperationException("Mark your enum " + NativeTrace.getIdentityStr(Value) + " to be appropriate Native*Enum type"));
//    // try ordinal and how it will help
//    return $out_SemaDiagnosticBuilder_uint(Diag, Value.ordinal());
//  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ AccessSpecifier /*&*/ Value) {
    AstClangGlobals.$out_DiagnosticBuilder$C_AccessSpecifier(Diag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ NativeUIntEnum /*&*/ Value) {
    $out_SemaDiagnosticBuilder_uint(Diag, ((NativeUIntEnum)Value).getValue());
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ NativeIntEnum /*&*/ Value) {
    $out_SemaDiagnosticBuilder_int(Diag, ((NativeIntEnum)Value).getValue());
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ NativeUShortEnum /*&*/ Value) {
    $out_SemaDiagnosticBuilder_uint(Diag, $ushort2uint(((NativeUShortEnum)Value).getValue()));
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ NativeUCharEnum /*&*/ Value) {
    $out_SemaDiagnosticBuilder_uint(Diag, $uchar2uint(((NativeUCharEnum)Value).getValue()));
    return Diag;
  }

  /// Teach operator<< to produce an object of the correct type.
  //</*typename*/ T/* = boolean*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIbEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_bool(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ boolean /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_uint(Diag, Value);
  }
  
  /// Teach operator<< to produce an object of the correct type.
  //</*typename*/ T/* = boolean*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ boolean /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_uint(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ /*uint*/int /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_uint(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ uint$ref /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_uint(Diag, Value.$deref());
  }
  
  /// Teach operator<< to produce an object of the correct type.
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_ADDED/*instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_QualType(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag,
          final /*const*/ QualType /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_QualType(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ QualType /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_QualType(Diag, Value);
  }
  
  /// Teach operator<< to produce an object of the correct type.
  //</*typename*/ T/* = QualType*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_8QualTypeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_CanQual(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ CanQual<?> /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_CanQual$Type(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_CanQual(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ QualType /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_QualType(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ CanQual<?> /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_CanQual(Diag, Value);
  }
  
  //</*typename*/ T/* = const IdentifierInfo **/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPKNS_14IdentifierInfoEEERKNS_4Sema21SemaDiagnosticBuilderES7_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIPKNS_14IdentifierInfoEEERKNS_4Sema21SemaDiagnosticBuilderES7_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_II(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ IdentifierInfo /*P*/ /*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_IdentifierInfo$C$P(BaseDiag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ IdentifierInfo /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_II(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_II(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ type$ref<IdentifierInfo> /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_II(Diag, Value.$deref());
  }
  
  //</*typename*/ T/* = const BeginEndFunction **/> 
  /// Teach operator<< to produce an object of the correct type.
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPNS_19NestedNameSpecifierEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clanglsIPNS_19NestedNameSpecifierEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_NestedNameSpec(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final NestedNameSpecifier /*P*/ /*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_NestedNameSpecifier$P(BaseDiag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final NestedNameSpecifier /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_NestedNameSpec(Diag, Value);
  }
  
  //</*typename*/ T/* = const BeginEndFunction **/> 
  /// Teach operator<< to produce an object of the correct type.
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIN12_GLOBAL__N_116BeginEndFunctionEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clanglsIN12_GLOBAL__N_116BeginEndFunctionEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_BegEndFunc(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, final /*const*/ BeginEndFunction /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_int(BaseDiag, Value.getValue());
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ BeginEndFunction /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_BegEndFunc(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_BegEndFunc(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ type$ptr<BeginEndFunction> /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_BegEndFunc(Diag, Value.$star());
  }
  
  //</*typename*/ T/* = const CXXRecordDecl **/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPNS_16ObjCProtocolDeclEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clanglsIPNS_16ObjCProtocolDeclEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_NamedDecl(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ NamedDecl /*P*/ /*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_NamedDecl$C$P(BaseDiag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ NamedDecl /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_NamedDecl(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_NamedDecl(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ type$ref<? extends NamedDecl> /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_NamedDecl(Diag, Value.$deref());
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_NamedDecl(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ type$ptr<? extends NamedDecl> /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_NamedDecl(Diag, Value.$star());
  }
  
  //</*typename*/ T/* = TemplateName*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_12TemplateNameEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_12TemplateNameEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_TemplateName(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ TemplateName /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_TemplateName(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ TemplateName /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_TemplateName(Diag, Value);
  }
  
  //</*typename*/ T/* = SourceRange*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED/*instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_11SourceRangeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_11SourceRangeEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_SourceRange(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ SourceRange /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_SourceRange(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ SourceRange /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_SourceRange(Diag, Value);
  }
  
  //</*typename*/ T/* = DeclContext **/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPNS_11DeclContextEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIPNS_11DeclContextEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_DeclContext(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final DeclContext /*P*/ /*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out$Same2DeclContext(BaseDiag, Value);
    return Diag;
  }  
  
  //</*typename*/ T/* = DeclContext **/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL/*instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_14SourceLocationEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_14SourceLocationEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_SourceLocation(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ SourceLocation /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_SourceRange(BaseDiag, new SourceRange(/*NO_COPY*/Value));
    return Diag;
  }
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ SourceLocation /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_SourceLocation(Diag, Value);
  }
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_SourceLocation(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ type$ref<SourceLocation> /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_SourceLocation(Diag, Value.$deref());
  }
  public static /*const*/ Sema.SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_SourceLocation(final /*const*/ Sema.SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ type$ptr<SourceLocation> /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_SourceLocation(Diag, Value.$star());
  }
  
  //</*typename*/ T/* = StringRef*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIN4llvm9StringRefEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIN4llvm9StringRefEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_StringRef(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ StringRef /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_StringRef(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_StringRef(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ String /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_StringRef(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ StringRef /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_StringRef(Diag, Value);
  }
  //</*typename*/ T/* = FixItHint*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL/*instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_9FixItHintEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_9FixItHintEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_FixItHint(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ FixItHint /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_FixItHint$C(BaseDiag, Value);
    return Diag;
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ FixItHint /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_FixItHint(Diag, Value);
  }
  
  //</*typename*/ T/* = unsigned int*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL/*instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIjEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIjEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_uint(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/uint$ref/*uint &*/ Value) {
    return $out_SemaDiagnosticBuilder_uint(Diag, Value.$deref());
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_uint(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/boolean/*uint &*/ Value) {
    return $out_SemaDiagnosticBuilder_uint(Diag, Value ? 1 : 0);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_uint(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/int/*uint &*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_uint(BaseDiag, Value);
    return Diag;
  }
  
  //</*typename*/ T/* = DeclarationName*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsINS_15DeclarationNameEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsINS_15DeclarationNameEEERKNS_4Sema21SemaDiagnosticBuilderES5_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_DeclarationName(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ DeclarationName /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_DeclarationName(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ DeclarationName /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_DeclarationName(Diag, Value);
  }  
  
  //</*typename*/ T/* = const char **/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPKcEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIPKcEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_char$ptr$C(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/char$ptr/*char P*//*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_char$ptr$C(BaseDiag, Value);
    return Diag;
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/char$ptr/*char P*//*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_char$ptr$C(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_char$ptr$C(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/std.string/*char P*//*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_char$ptr$C(BaseDiag, Value);
    return Diag;
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/std.string/*char P*//*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_char$ptr$C(Diag, Value);
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_char$ptr$C(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/SmallString/*char P*//*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_char$ptr$C(BaseDiag, Value.c_str());
    return Diag;
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/SmallString/*char P*//*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_char$ptr$C(Diag, Value);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_char$ptr$C(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/String/*char P*//*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_char$ptr$C(BaseDiag, Value);
    return Diag;
  } 
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/String/*char P*//*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_char$ptr$C(Diag, Value);
  } 
  //</*typename*/ T/* = int*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIiEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIiEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_int(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/int$ref/*&*/ Value) {
    return $out_SemaDiagnosticBuilder_int(Diag, Value.$deref());
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_int(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/boolean/*&*/ Value) {
    return $out_SemaDiagnosticBuilder_int(Diag, Value ? 1 : 0);
  }
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_int(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/int/*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_int(BaseDiag, Value);
    return Diag;
  }
  
  //</*typename*/ T/* = Attr **/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIPNS_11AlignedAttrEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIPNS_11AlignedAttrEEERKNS_4Sema21SemaDiagnosticBuilderES6_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_Attr(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final Attr /*P*/ /*const*/ /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_Attr$C$P(BaseDiag, Value);
    return Diag;
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final Attr /*P*/ /*const*/ /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_Attr(Diag, Value);
  }  
  
  //</*typename*/ T/* = bool*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsIbEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsIbEERKNS_4Sema21SemaDiagnosticBuilderES4_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/bool$ref/*bool &*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out$Same2Bool(BaseDiag, Value.$deref());
    return Diag;
  }  
  //</*typename*/ T/* = pair<NullabilityKind, bool>*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1130,
   FQN="clang::operator<<", NM="_ZN5clanglsISt4pairINS_15NullabilityKindEbEEERKNS_4Sema21SemaDiagnosticBuilderES7_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clanglsISt4pairINS_15NullabilityKindEbEEERKNS_4Sema21SemaDiagnosticBuilderES7_RKT_")
  //</editor-fold>
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder_NullabilityBool(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ std.pairTypeBool<NullabilityKind> /*&*/ Value) {
    final /*const*/ DiagnosticBuilder /*&*/ BaseDiag = Diag;
    $out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind(BaseDiag, /*NO_COPY*/Value);
    return Diag;
  }  
  public static /*const*/ SemaDiagnosticBuilder /*&*/ $out_SemaDiagnosticBuilder$C_T$C$R(final /*const*/ SemaDiagnosticBuilder /*&*/ Diag, 
          final /*const*/ std.pairTypeBool<NullabilityKind> /*&*/ Value) {
    return $out_SemaDiagnosticBuilder_NullabilityBool(Diag, Value);
  }  
  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", DiagID=" + DiagID // NOI18N
              + super.toString(); // NOI18N
  }
}

/// \brief Abstract class used to diagnose incomplete types.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeDiagnoser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1341,
 FQN="clang::Sema::TypeDiagnoser", NM="_ZN5clang4Sema13TypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema13TypeDiagnoserE")
//</editor-fold>
public abstract static class/*struct*/ TypeDiagnoser implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeDiagnoser::TypeDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1342,
   FQN="clang::Sema::TypeDiagnoser::TypeDiagnoser", NM="_ZN5clang4Sema13TypeDiagnoserC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema13TypeDiagnoserC1Ev")
  //</editor-fold>
  public TypeDiagnoser() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeDiagnoser::diagnose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1344,
   FQN="clang::Sema::TypeDiagnoser::diagnose", NM="_ZN5clang4Sema13TypeDiagnoser8diagnoseERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema13TypeDiagnoser8diagnoseERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ void diagnose(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeDiagnoser::~TypeDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1345,
   FQN="clang::Sema::TypeDiagnoser::~TypeDiagnoser", NM="_ZN5clang4Sema13TypeDiagnoserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema13TypeDiagnoserD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
/*template <typename ... Ts> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1364,
 FQN="clang::Sema::BoundTypeDiagnoser", NM="_ZN5clang4Sema18BoundTypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18BoundTypeDiagnoserE")
//</editor-fold>
public static class BoundTypeDiagnoser/*<typename... Ts>*/  extends /*public*/ TypeDiagnoser implements Destructors.ClassWithDestructor {
  protected/*private*/ /*uint*/int DiagID;
  protected/*private*/ Object/*const Ts & ...*/ Args[];
  
/*private*/
  /*template <std::size_t... Is> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser::emit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1369,
   FQN="clang::Sema::BoundTypeDiagnoser::emit", NM="Tpl__ZNK5clang4Sema18BoundTypeDiagnoser4emitERKNS0_21SemaDiagnosticBuilderEN4llvm14index_sequenceIJXspT_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=Tpl__ZNK5clang4Sema18BoundTypeDiagnoser4emitERKNS0_21SemaDiagnosticBuilderEN4llvm14index_sequenceIJXspT_EEEE")
  //</editor-fold>
  protected void emit(final /*const*/ SemaDiagnosticBuilder /*&*/ DB,
          index_sequence $Prm1) /*const*/ {
    // Apply all tuple elements to the builder in order.
    // boolean Dummy[] = ((void)false, (Native.$out(DB, getPrintable(std.<Is>get(Args))))...);
    ///*J:(void)*/Dummy;
    // JAVA
    if (Args != null) {
      for (Object arg : Args) {
        emitArgImpl(arg, DB);
      }
    }
  }

  protected void emitArgImpl(Object arg, final SemaDiagnosticBuilder DB) {
    assert arg != null;
    if (arg instanceof QualType) {
      $out_SemaDiagnosticBuilder_QualType(DB, getPrintable(new QualType((QualType)arg)));
    } else if (arg instanceof TypeLoc) {
      $out_SemaDiagnosticBuilder_SourceRange(DB, getPrintable((TypeLoc)arg));
    } else if (arg instanceof Expr) {
      $out_SemaDiagnosticBuilder_SourceRange(DB, getPrintable((Expr)arg));
    } else if (arg instanceof SourceLocation) {
      $out_SemaDiagnosticBuilder_SourceRange(DB, getPrintable(new SourceLocation((SourceLocation)arg)));
    } else if (arg instanceof SourceRange) {
      $out_SemaDiagnosticBuilder_SourceRange(DB, getPrintable(new SourceRange((SourceRange)arg)));
    } else if (arg instanceof StringRef) {
      $out_SemaDiagnosticBuilder_StringRef(DB, getPrintable(new StringRef((StringRef)arg)));
    } else if (arg instanceof char$ptr) {
      $out_SemaDiagnosticBuilder_char$ptr$C(DB, getPrintable((char$ptr)arg));
    } else if (arg instanceof std.string) {
      $out_SemaDiagnosticBuilder_char$ptr$C(DB, getPrintable((std.string)arg));
    } else if (arg instanceof String) {
      $out_SemaDiagnosticBuilder_char$ptr$C(DB, getPrintable((String)arg));
    } else if (arg instanceof IdentifierInfo) {
      $out_SemaDiagnosticBuilder_II(DB, getPrintable((IdentifierInfo)arg));
    } else if (arg instanceof DeclarationName) {
      $out_SemaDiagnosticBuilder_DeclarationName(DB, getPrintable(new DeclarationName((DeclarationName)arg)));
    } else if (arg instanceof Boolean) {
      $out_SemaDiagnosticBuilder_uint(DB, getPrintable((boolean)arg));
    } else if (arg instanceof Selector) {
      $out_SemaDiagnosticBuilder_DeclarationName(DB, getPrintable((Selector)arg));
    } else if (arg instanceof NamedDecl) {
      $out_SemaDiagnosticBuilder_NamedDecl(DB, ((NamedDecl)arg));
    } else if (arg instanceof NativeBoolEnum) {
      $out_SemaDiagnosticBuilder_int(DB, getPrintable(((NativeBoolEnum) arg).getValue()));
    } else if (arg instanceof NativeIntEnum) {
      $out_SemaDiagnosticBuilder_int(DB, getPrintable_int(((NativeIntEnum) arg).getValue()));
    } else if (arg instanceof NativeUIntEnum) {
      $out_SemaDiagnosticBuilder_uint(DB, getPrintable_uint(((NativeUIntEnum) arg).getValue()));
    } else if (arg instanceof Integer) {
      // let's hope Integer is for signed/unsigned is the same...
      $out_SemaDiagnosticBuilder_uint(DB, getPrintable_uint(((Integer) arg).intValue()));
    } else if (arg instanceof DeclContext) { // should be at the end of instanceof checks
      $out_SemaDiagnosticBuilder_DeclContext(DB, ((DeclContext)arg));
    } else if (arg instanceof type$ref<?>) {
      // sometimes client passes wrapped type$refs like
      // type$ref<Expr /*P*/> Base = create_type$ref(_Base);
      assert arg instanceof org.clank.support.type$ptr$single : "Unexpected type$ref " + NativeTrace.getIdentityStr(arg);
      arg = ((type$ref)arg).$deref();
      emitArgImpl(arg, DB);
    } else {
      if (arg instanceof Enum) {
        assert false : "unhandled enum [" + arg.getClass() + "] " + arg;
      } else {
        assert false : "unhandled [" + arg.getClass() + "] " + arg;
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser::BoundTypeDiagnoser<Ts...>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*NB: added an assertion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1377,
   FQN="clang::Sema::BoundTypeDiagnoser::BoundTypeDiagnoser<Ts...>", NM="_ZN5clang4Sema18BoundTypeDiagnoserC1EjDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18BoundTypeDiagnoserC1EjDpRKT_")
  //</editor-fold>
    public BoundTypeDiagnoser(/*uint*/int DiagID, /*const Ts*/ Object... /*&*/ Args) {
    // : TypeDiagnoser(), DiagID(DiagID), Args(Args...) 
    //START JInit
    /*ParenListExpr*/super();
    this.DiagID = DiagID;
    this.Args = /*ParenListExpr*//* new std.tuple*//*const Ts & ...*/(Args);
    //END JInit
    assert (DiagID != 0) : "no diagnostic for type diagnoser";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser::diagnose">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clean!*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1382,
   FQN="clang::Sema::BoundTypeDiagnoser::diagnose", NM="_ZN5clang4Sema18BoundTypeDiagnoser8diagnoseERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema18BoundTypeDiagnoser8diagnoseERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  @Override public void diagnose(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
    /*const*/ SemaDiagnosticBuilder /*&*/ DB = null;
    try {
      DB = S.Diag(Loc, DiagID);
      emit(DB, new index_sequence_for/*<Ts>*/());
      $out_SemaDiagnosticBuilder$C_T$C$R(DB, T);
    } finally {
      if (DB != null) { DB.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "DiagID=" + DiagID // NOI18N
              + ", Args=" + Args // NOI18N
              + super.toString(); // NOI18N
  }
  }

/*template <typename ... Ts> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1364,
 FQN="clang::Sema::BoundTypeDiagnoser", NM="_ZN5clang4Sema18BoundTypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18BoundTypeDiagnoserE")
//</editor-fold>
public static class BoundUIntTypeDiagnoser/*<typename... Ts>*/  extends /*public*/ TypeDiagnoser implements Destructors.ClassWithDestructor {
  protected/*private*/ /*uint*/int DiagID;
  protected/*private*/ /*uint*/int/*const Ts & ...*/ Args[];
  
  /*template <std::size_t... Is> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser::emit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1369,
   FQN="clang::Sema::BoundTypeDiagnoser::emit", NM="Tpl__ZNK5clang4Sema18BoundTypeDiagnoser4emitERKNS0_21SemaDiagnosticBuilderEN4llvm14index_sequenceIJXspT_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=Tpl__ZNK5clang4Sema18BoundTypeDiagnoser4emitERKNS0_21SemaDiagnosticBuilderEN4llvm14index_sequenceIJXspT_EEEE")
  //</editor-fold>
  /*private*/protected void emit(final /*const*/ SemaDiagnosticBuilder /*&*/ DB,
            index_sequence $Prm1) /*const*/ {
    // Apply all tuple elements to the builder in order.
    // boolean Dummy[] = ((void)false, (Native.$out(DB, getPrintable(std.<Is>get(Args))))...);
    ///*J:(void)*/Dummy;
    // JAVA
    if (Args != null) {
      for (/*uint*/int arg : Args) {
        $out_SemaDiagnosticBuilder_uint(DB, getPrintable_uint(arg));
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser::BoundTypeDiagnoser<Ts...>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*NB: added an assertion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1377,
   FQN="clang::Sema::BoundTypeDiagnoser::BoundTypeDiagnoser<Ts...>", NM="_ZN5clang4Sema18BoundTypeDiagnoserC1EjDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18BoundTypeDiagnoserC1EjDpRKT_")
  //</editor-fold>
    public BoundUIntTypeDiagnoser(/*uint*/int DiagID, /*const Ts*/ int... /*&*/ Args) {
    // : TypeDiagnoser(), DiagID(DiagID), Args(Args...) 
    //START JInit
    /*ParenListExpr*/super();
    this.DiagID = DiagID;
    this.Args = /*ParenListExpr*/ /*const Ts & ...*/(Args);
    //END JInit
    assert Args != null && Args.length == 1 : "This specialization is called with one argumen";
    assert (DiagID != 0) : "no diagnostic for type diagnoser";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::BoundTypeDiagnoser::diagnose">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clean!*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1382,
   FQN="clang::Sema::BoundTypeDiagnoser::diagnose", NM="_ZN5clang4Sema18BoundTypeDiagnoser8diagnoseERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema18BoundTypeDiagnoser8diagnoseERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  @Override public void diagnose(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
    /*const*/ SemaDiagnosticBuilder /*&*/ DB = null;
    try {
      DB = S.Diag(Loc, DiagID);
      emit(DB, new index_sequence_for/*<Ts>*/());
      $out_SemaDiagnosticBuilder$C_T$C$R(DB, T);
    } finally {
      if (DB != null) { DB.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "DiagID=" + DiagID // NOI18N
              + ", Args=" + Args // NOI18N
              + super.toString(); // NOI18N
  }
}

//===--------------------------------------------------------------------===//
// Symbol table / Decl tracking callbacks: SemaDecl.cpp.
//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SkipBodyInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1504,
 FQN="clang::Sema::SkipBodyInfo", NM="_ZN5clang4Sema12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema12SkipBodyInfoE")
//</editor-fold>
public static class/*struct*/ SkipBodyInfo {
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SkipBodyInfo::SkipBodyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1505,
   FQN="clang::Sema::SkipBodyInfo::SkipBodyInfo", NM="_ZN5clang4Sema12SkipBodyInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema12SkipBodyInfoC1Ev")
  //</editor-fold>
  public SkipBodyInfo() {
    // : ShouldSkip(false), Previous(null) 
    //START JInit
    this.ShouldSkip = false;
    this.Previous = null;
    //END JInit
  }

  public boolean ShouldSkip;
  public NamedDecl /*P*/ Previous;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SkipBodyInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1504,
   FQN="clang::Sema::SkipBodyInfo::operator=", NM="_ZN5clang4Sema12SkipBodyInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema12SkipBodyInfoaSEOS1_")
  //</editor-fold>
  public final /*inline*/ SkipBodyInfo /*&*/ $assignMove(final SkipBodyInfo /*&&*/$Prm0) {
    this.ShouldSkip = $Prm0.ShouldSkip;
    this.Previous = $Prm0.Previous;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SkipBodyInfo::SkipBodyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1504,
   FQN="clang::Sema::SkipBodyInfo::SkipBodyInfo", NM="_ZN5clang4Sema12SkipBodyInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema12SkipBodyInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ SkipBodyInfo(JD$Move _dparam, final SkipBodyInfo /*&&*/$Prm0) {
    // : ShouldSkip(static_cast<SkipBodyInfo &&>().ShouldSkip), Previous(static_cast<SkipBodyInfo &&>().Previous) 
    //START JInit
    this.ShouldSkip = $Prm0.ShouldSkip;
    this.Previous = $Prm0.Previous;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "ShouldSkip=" + ShouldSkip // NOI18N
              + ", Previous=" + Previous; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1560,
 FQN="clang::Sema::NameClassification", NM="_ZN5clang4Sema18NameClassificationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassificationE")
//</editor-fold>
public static class NameClassification {
  protected/*private*/ NameClassificationKind Kind;
  protected/*private*/ ActionResultTTrue<Expr /*P*/ > Expr;
  protected/*private*/ TemplateName Template;
  protected/*private*/ OpaquePtr<QualType> Type;
  protected/*private*/ /*const*/ IdentifierInfo /*P*/ Keyword;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::NameClassification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1567,
   FQN="clang::Sema::NameClassification::NameClassification", NM="_ZN5clang4Sema18NameClassificationC1ENS0_22NameClassificationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassificationC1ENS0_22NameClassificationKindE")
  //</editor-fold>
  protected/*private*/ /*explicit*/ NameClassification(NameClassificationKind Kind) {
    // : Kind(Kind), Expr(), Template(), Type() 
    //START JInit
    this.Kind = Kind;
    this.Expr = new ActionResultTTrue<Expr /*P*/ >();
    this.Template = new TemplateName();
    this.Type = new OpaquePtr<QualType>();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::NameClassification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1570,
   FQN="clang::Sema::NameClassification::NameClassification", NM="_ZN5clang4Sema18NameClassificationC1ENS_12ActionResultIPNS_4ExprELb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassificationC1ENS_12ActionResultIPNS_4ExprELb1EEE")
  //</editor-fold>
  public NameClassification(ActionResultTTrue<Expr /*P*/ > Expr) {
    // : Kind(NC_Expression), Expr(Expr), Template(), Type() 
    //START JInit
    this.Kind = NameClassificationKind.NC_Expression;
    this.Expr = new ActionResultTTrue<Expr /*P*/ >(Expr);
    this.Template = new TemplateName();
    this.Type = new OpaquePtr<QualType>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::NameClassification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1572,
   FQN="clang::Sema::NameClassification::NameClassification", NM="_ZN5clang4Sema18NameClassificationC1ENS_9OpaquePtrINS_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassificationC1ENS_9OpaquePtrINS_8QualTypeEEE")
  //</editor-fold>
  public NameClassification(OpaquePtr<QualType> Type) {
    // : Kind(NC_Type), Expr(), Template(), Type(Type) 
    //START JInit
    this.Kind = NameClassificationKind.NC_Type;
    this.Expr = new ActionResultTTrue<Expr /*P*/ >();
    this.Template = new TemplateName();
    this.Type = new OpaquePtr<QualType>(Type);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::NameClassification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1574,
   FQN="clang::Sema::NameClassification::NameClassification", NM="_ZN5clang4Sema18NameClassificationC1EPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassificationC1EPKNS_14IdentifierInfoE")
  //</editor-fold>
  public NameClassification(/*const*/ IdentifierInfo /*P*/ Keyword) {
    // : Kind(NC_Keyword), Expr(), Template(), Type(), Keyword(Keyword) 
    //START JInit
    this.Kind = NameClassificationKind.NC_Keyword;
    this.Expr = new ActionResultTTrue<Expr /*P*/ >();
    this.Template = new TemplateName();
    this.Type = new OpaquePtr<QualType>();
    this.Keyword = Keyword;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1577,
   FQN="clang::Sema::NameClassification::Error", NM="_ZN5clang4Sema18NameClassification5ErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassification5ErrorEv")
  //</editor-fold>
  public static NameClassification Error() {
    return new NameClassification(NameClassificationKind.NC_Error);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::Unknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1581,
   FQN="clang::Sema::NameClassification::Unknown", NM="_ZN5clang4Sema18NameClassification7UnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassification7UnknownEv")
  //</editor-fold>
  public static NameClassification Unknown() {
    return new NameClassification(NameClassificationKind.NC_Unknown);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::NestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1585,
   FQN="clang::Sema::NameClassification::NestedNameSpecifier", NM="_ZN5clang4Sema18NameClassification19NestedNameSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassification19NestedNameSpecifierEv")
  //</editor-fold>
  public static NameClassification NestedNameSpecifier() {
    return new NameClassification(NameClassificationKind.NC_NestedNameSpecifier);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::TypeTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1589,
   FQN="clang::Sema::NameClassification::TypeTemplate", NM="_ZN5clang4Sema18NameClassification12TypeTemplateENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassification12TypeTemplateENS_12TemplateNameE")
  //</editor-fold>
  public static NameClassification TypeTemplate(TemplateName Name) {
    NameClassification Result/*J*/= new NameClassification(NameClassificationKind.NC_TypeTemplate);
    Result.Template.$assign(Name);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::VarTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1595,
   FQN="clang::Sema::NameClassification::VarTemplate", NM="_ZN5clang4Sema18NameClassification11VarTemplateENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassification11VarTemplateENS_12TemplateNameE")
  //</editor-fold>
  public static NameClassification VarTemplate(TemplateName Name) {
    NameClassification Result/*J*/= new NameClassification(NameClassificationKind.NC_VarTemplate);
    Result.Template.$assign(Name);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::FunctionTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1601,
   FQN="clang::Sema::NameClassification::FunctionTemplate", NM="_ZN5clang4Sema18NameClassification16FunctionTemplateENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassification16FunctionTemplateENS_12TemplateNameE")
  //</editor-fold>
  public static NameClassification FunctionTemplate(TemplateName Name) {
    NameClassification Result/*J*/= new NameClassification(NameClassificationKind.NC_FunctionTemplate);
    Result.Template.$assign(Name);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1607,
   FQN="clang::Sema::NameClassification::getKind", NM="_ZNK5clang4Sema18NameClassification7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema18NameClassification7getKindEv")
  //</editor-fold>
  public final NameClassificationKind getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1609,
   FQN="clang::Sema::NameClassification::getType", NM="_ZNK5clang4Sema18NameClassification7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema18NameClassification7getTypeEv")
  //</editor-fold>
  public final OpaquePtr<QualType> getType() /*const*/ {
    assert (Kind == NameClassificationKind.NC_Type);
    return new OpaquePtr<QualType>(Type);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::getExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1614,
   FQN="clang::Sema::NameClassification::getExpression", NM="_ZNK5clang4Sema18NameClassification13getExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema18NameClassification13getExpressionEv")
  //</editor-fold>
  public final ActionResultTTrue<Expr /*P*/ > getExpression() /*const*/ {
    assert (Kind == NameClassificationKind.NC_Expression);
    return new ActionResultTTrue<Expr /*P*/ >(Expr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::getTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1619,
   FQN="clang::Sema::NameClassification::getTemplateName", NM="_ZNK5clang4Sema18NameClassification15getTemplateNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema18NameClassification15getTemplateNameEv")
  //</editor-fold>
  public final TemplateName getTemplateName() /*const*/ {
    assert (Kind == NameClassificationKind.NC_TypeTemplate || Kind == NameClassificationKind.NC_FunctionTemplate || Kind == NameClassificationKind.NC_VarTemplate);
    return new TemplateName(Template);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::getTemplateNameKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1625,
   FQN="clang::Sema::NameClassification::getTemplateNameKind", NM="_ZNK5clang4Sema18NameClassification19getTemplateNameKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema18NameClassification19getTemplateNameKindEv")
  //</editor-fold>
  public final TemplateNameKind getTemplateNameKind() /*const*/ {
    switch (Kind) {
     case NC_TypeTemplate:
      return TemplateNameKind.TNK_Type_template;
     case NC_FunctionTemplate:
      return TemplateNameKind.TNK_Function_template;
     case NC_VarTemplate:
      return TemplateNameKind.TNK_Var_template;
     default:
      throw new llvm_unreachable("unsupported name classification.");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::NameClassification::NameClassification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1560,
   FQN="clang::Sema::NameClassification::NameClassification", NM="_ZN5clang4Sema18NameClassificationC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18NameClassificationC1EOS1_")
  //</editor-fold>
  public /*inline*/ NameClassification(JD$Move _dparam, final NameClassification /*&&*/$Prm0) {
    // : Kind(static_cast<NameClassification &&>().Kind), Expr(static_cast<NameClassification &&>().Expr), Template(static_cast<NameClassification &&>().Template), Type(static_cast<NameClassification &&>().Type), Keyword(static_cast<NameClassification &&>().Keyword) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Expr = new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, $Prm0.Expr);
    this.Template = new TemplateName(JD$Move.INSTANCE, $Prm0.Template);
    this.Type = new OpaquePtr<QualType>(JD$Move.INSTANCE, $Prm0.Type);
    this.Keyword = $Prm0.Keyword;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Expr=" + Expr // NOI18N
              + ", Template=" + Template // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Keyword=" + Keyword; // NOI18N
  }
}

/// \brief Abstract base class used to perform a contextual implicit
/// conversion from an expression to any type passing a filter.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2346,
 FQN="clang::Sema::ContextualImplicitConverter", NM="_ZN5clang4Sema27ContextualImplicitConverterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverterE")
//</editor-fold>
public abstract static class ContextualImplicitConverter implements Destructors.ClassWithDestructor {
/*public:*/
  public boolean Suppress;
  public boolean SuppressConversion;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::ContextualImplicitConverter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2351,
   FQN="clang::Sema::ContextualImplicitConverter::ContextualImplicitConverter", NM="_ZN5clang4Sema27ContextualImplicitConverterC1Ebb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverterC1Ebb")
  //</editor-fold>
  public ContextualImplicitConverter() {
    this(false, 
      false);
  }
  public ContextualImplicitConverter(boolean Suppress/*= false*/) {
    this(Suppress, 
      false);
  }
  public ContextualImplicitConverter(boolean Suppress/*= false*/, 
      boolean SuppressConversion/*= false*/) {
    // : Suppress(Suppress), SuppressConversion(SuppressConversion) 
    //START JInit
    this.Suppress = Suppress;
    this.SuppressConversion = SuppressConversion;
    //END JInit
  }

  
  /// \brief Determine whether the specified type is a valid destination type
  /// for this conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::match">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2357,
   FQN="clang::Sema::ContextualImplicitConverter::match", NM="_ZN5clang4Sema27ContextualImplicitConverter5matchENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter5matchENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ boolean match(QualType T)/* = 0*/;

  
  /// \brief Emits a diagnostic complaining that the expression does not have
  /// integral or enumeration type.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::diagnoseNoMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2361,
   FQN="clang::Sema::ContextualImplicitConverter::diagnoseNoMatch", NM="_ZN5clang4Sema27ContextualImplicitConverter15diagnoseNoMatchERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter15diagnoseNoMatchERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder diagnoseNoMatch(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* = 0*/;

  
  /// \brief Emits a diagnostic when the expression has incomplete class type.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::diagnoseIncomplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2365,
   FQN="clang::Sema::ContextualImplicitConverter::diagnoseIncomplete", NM="_ZN5clang4Sema27ContextualImplicitConverter18diagnoseIncompleteERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter18diagnoseIncompleteERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder diagnoseIncomplete(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* = 0*/;

  
  /// \brief Emits a diagnostic when the only matching conversion function
  /// is explicit.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::diagnoseExplicitConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2370,
   FQN="clang::Sema::ContextualImplicitConverter::diagnoseExplicitConv", NM="_ZN5clang4Sema27ContextualImplicitConverter20diagnoseExplicitConvERS0_NS_14SourceLocationENS_8QualTypeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter20diagnoseExplicitConvERS0_NS_14SourceLocationENS_8QualTypeES4_")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder diagnoseExplicitConv(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* = 0*/;

  
  /// \brief Emits a note for the explicit conversion function.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::noteExplicitConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2374,
   FQN="clang::Sema::ContextualImplicitConverter::noteExplicitConv", NM="_ZN5clang4Sema27ContextualImplicitConverter16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder noteExplicitConv(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* = 0*/;

  
  /// \brief Emits a diagnostic when there are multiple possible conversion
  /// functions.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::diagnoseAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2379,
   FQN="clang::Sema::ContextualImplicitConverter::diagnoseAmbiguous", NM="_ZN5clang4Sema27ContextualImplicitConverter17diagnoseAmbiguousERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter17diagnoseAmbiguousERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder diagnoseAmbiguous(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* = 0*/;

  
  /// \brief Emits a note for one of the candidate conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::noteAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2383,
   FQN="clang::Sema::ContextualImplicitConverter::noteAmbiguous", NM="_ZN5clang4Sema27ContextualImplicitConverter13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder noteAmbiguous(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* = 0*/;

  
  /// \brief Emits a diagnostic when we picked a conversion function
  /// (for cases when we are not allowed to pick a conversion function).
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::diagnoseConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2388,
   FQN="clang::Sema::ContextualImplicitConverter::diagnoseConversion", NM="_ZN5clang4Sema27ContextualImplicitConverter18diagnoseConversionERS0_NS_14SourceLocationENS_8QualTypeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverter18diagnoseConversionERS0_NS_14SourceLocationENS_8QualTypeES4_")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder diagnoseConversion(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ContextualImplicitConverter::~ContextualImplicitConverter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2391,
   FQN="clang::Sema::ContextualImplicitConverter::~ContextualImplicitConverter", NM="_ZN5clang4Sema27ContextualImplicitConverterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ContextualImplicitConverterD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  @Override public String toString() {
    return "" + "Suppress=" + Suppress // NOI18N
              + ", SuppressConversion=" + SuppressConversion; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ICEConvertDiagnoser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2394,
 FQN="clang::Sema::ICEConvertDiagnoser", NM="_ZN5clang4Sema19ICEConvertDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19ICEConvertDiagnoserE")
//</editor-fold>
public abstract static class ICEConvertDiagnoser extends /*public*/ ContextualImplicitConverter implements Destructors.ClassWithDestructor {
  protected/*private*/ boolean AllowScopedEnumerations;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ICEConvertDiagnoser::ICEConvertDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2398,
   FQN="clang::Sema::ICEConvertDiagnoser::ICEConvertDiagnoser", NM="_ZN5clang4Sema19ICEConvertDiagnoserC1Ebbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19ICEConvertDiagnoserC1Ebbb")
  //</editor-fold>
  public ICEConvertDiagnoser(boolean AllowScopedEnumerations, 
      boolean Suppress, boolean SuppressConversion) {
    // : ContextualImplicitConverter(Suppress, SuppressConversion), AllowScopedEnumerations(AllowScopedEnumerations) 
    //START JInit
    super(Suppress, SuppressConversion);
    this.AllowScopedEnumerations = AllowScopedEnumerations;
    //END JInit
  }

  
  /// Match an integral or (possibly scoped) enumeration type.
  
  /// Match an integral or (possibly scoped) enumeration type.
  
  /// Determine whether the provided type is an integral type, or an enumeration
  /// type of a permitted flavor.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ICEConvertDiagnoser::match">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5327,
   FQN="clang::Sema::ICEConvertDiagnoser::match", NM="_ZN5clang4Sema19ICEConvertDiagnoser5matchENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema19ICEConvertDiagnoser5matchENS_8QualTypeE")
  //</editor-fold>
  @Override public boolean match(QualType T)/* override*/ {
    return AllowScopedEnumerations ? T.$arrow().isIntegralOrEnumerationType() : T.$arrow().isIntegralOrUnscopedEnumerationType();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ICEConvertDiagnoser::diagnoseNoMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2406,
   FQN="clang::Sema::ICEConvertDiagnoser::diagnoseNoMatch", NM="_ZN5clang4Sema19ICEConvertDiagnoser15diagnoseNoMatchERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19ICEConvertDiagnoser15diagnoseNoMatchERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  @Override public SemaDiagnosticBuilder diagnoseNoMatch(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
    return diagnoseNotInt(S, new SourceLocation(Loc), new QualType(T));
  }

  
  /// \brief Emits a diagnostic complaining that the expression does not have
  /// integral or enumeration type.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ICEConvertDiagnoser::diagnoseNotInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2413,
   FQN="clang::Sema::ICEConvertDiagnoser::diagnoseNotInt", NM="_ZN5clang4Sema19ICEConvertDiagnoser14diagnoseNotIntERS0_NS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema19ICEConvertDiagnoser14diagnoseNotIntERS0_NS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SemaDiagnosticBuilder diagnoseNotInt(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ICEConvertDiagnoser::~ICEConvertDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2394,
   FQN="clang::Sema::ICEConvertDiagnoser::~ICEConvertDiagnoser", NM="_ZN5clang4Sema19ICEConvertDiagnoserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19ICEConvertDiagnoserD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  
  @Override public String toString() {
    return "" + "AllowScopedEnumerations=" + AllowScopedEnumerations // NOI18N
              + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TypoExprState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2794,
 FQN="clang::Sema::TypoExprState", NM="_ZN5clang4Sema13TypoExprStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema13TypoExprStateE")
//</editor-fold>
public/*private*/ static class/*struct*/ TypoExprState implements NativeMoveable<TypoExprState>, NativeCloneable<TypoExprState>, Destructors.ClassWithDestructor {
  public std.unique_ptr<TypoCorrectionConsumer> Consumer;
  public TypoDiagnosticGenerator DiagHandler;
  public/*public*/ TypoRecoveryCallback RecoveryHandler;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypoExprState::TypoExprState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 334,
   FQN="clang::Sema::TypoExprState::TypoExprState", NM="_ZN5clang4Sema13TypoExprStateC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema13TypoExprStateC1Ev")
  //</editor-fold>
  public /*inline*/ TypoExprState() {
    // : Consumer(), DiagHandler(), RecoveryHandler() 
    //START JInit
    this.Consumer = new std.unique_ptr<TypoCorrectionConsumer>();
    this.DiagHandler = null;
    this.RecoveryHandler = null;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypoExprState::TypoExprState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 336,
   FQN="clang::Sema::TypoExprState::TypoExprState", NM="_ZN5clang4Sema13TypoExprStateC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema13TypoExprStateC1EOS1_")
  //</editor-fold>
  public /*inline*/ TypoExprState(JD$Move _dparam, final TypoExprState /*&&*/other) {
    // : Consumer(), DiagHandler(), RecoveryHandler() 
    //START JInit
    this.Consumer = new std.unique_ptr<TypoCorrectionConsumer>();
    this.DiagHandler = null;
    this.RecoveryHandler = null;
    //END JInit
    /*Deref*/this.$assignMove(std.move(other));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypoExprState::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 340,
   FQN="clang::Sema::TypoExprState::operator=", NM="_ZN5clang4Sema13TypoExprStateaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema13TypoExprStateaSEOS1_")
  //</editor-fold>
  public final /*inline*/ Sema.TypoExprState /*&*/ $assignMove(final Sema.TypoExprState /*&&*/other) {
    Consumer.$assignMove(std.move(other.Consumer));
    DiagHandler = std.move(other.DiagHandler);
    RecoveryHandler = std.move(other.RecoveryHandler);
    return /*Deref*/ this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypoExprState::~TypoExprState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2794,
   FQN="clang::Sema::TypoExprState::~TypoExprState", NM="_ZN5clang4Sema13TypoExprStateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema13TypoExprStateD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    //RecoveryHandler.$destroy();
    //DiagHandler.$destroy();
    Consumer.$destroy();
    //END JDestroy
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*only for cloning in collections*/)
  @Override public TypoExprState clone() { 
    assert !Consumer.$bool() : "must be empty object used only as clone for default value";
    assert DiagHandler == null : "must be empty object used only as clone for default value";
    assert RecoveryHandler == null : "must be empty object used only as clone for default value";
    return new TypoExprState(); 
  }

  @Override
  public TypoExprState move() {
    return new TypoExprState(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "Consumer=" + "[Unique_ptr$TypoCorrectionConsumer]" // NOI18N
              + ", DiagHandler=" + DiagHandler // NOI18N
              + ", RecoveryHandler=" + RecoveryHandler; // NOI18N
  }
}

//===--------------------------------------------------------------------===//
// Statement Parsing Callbacks: SemaStmt.cpp.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3303,
 FQN="clang::Sema::FullExprArg", NM="_ZN5clang4Sema11FullExprArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgE")
//</editor-fold>
public static class FullExprArg {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::FullExprArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3305,
   FQN="clang::Sema::FullExprArg::FullExprArg", NM="_ZN5clang4Sema11FullExprArgC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgC1Ev")
  //</editor-fold>
  public FullExprArg() {
    // : E(null) 
    //START JInit
    this.E = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::FullExprArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3306,
   FQN="clang::Sema::FullExprArg::FullExprArg", NM="_ZN5clang4Sema11FullExprArgC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgC1ERS0_")
  //</editor-fold>
  public FullExprArg(final Sema /*&*/ actions) {
    // : E(null) 
    //START JInit
    this.E = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::release">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3308,
   FQN="clang::Sema::FullExprArg::release", NM="_ZN5clang4Sema11FullExprArg7releaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArg7releaseEv")
  //</editor-fold>
  public final ActionResultTTrue<Expr /*P*/ > release() {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3312,
   FQN="clang::Sema::FullExprArg::get", NM="_ZNK5clang4Sema11FullExprArg3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema11FullExprArg3getEv")
  //</editor-fold>
  public final Expr /*P*/ get() /*const*/ {
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3314,
   FQN="clang::Sema::FullExprArg::operator->", NM="_ZN5clang4Sema11FullExprArgptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgptEv")
  //</editor-fold>
  public final Expr /*P*/ $arrow() {
    return E;
  }

/*private:*/
  // FIXME: No need to make the entire Sema class a friend when it's just
  // Sema::MakeFullExpr that needs access to the constructor below.
  /*friend  class Sema*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::FullExprArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3323,
   FQN="clang::Sema::FullExprArg::FullExprArg", NM="_ZN5clang4Sema11FullExprArgC1EPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgC1EPNS_4ExprE")
  //</editor-fold>
  protected/*private*/ /*explicit*/ FullExprArg(Expr /*P*/ expr) {
    // : E(expr) 
    //START JInit
    this.E = expr;
    //END JInit
  }

  
  protected/*private*/ Expr /*P*/ E;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::FullExprArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3303,
   FQN="clang::Sema::FullExprArg::FullExprArg", NM="_ZN5clang4Sema11FullExprArgC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgC1ERKS1_")
  //</editor-fold>
  public /*inline*/ FullExprArg(final /*const*/ FullExprArg /*&*/ $Prm0) {
    // : E(.E) 
    //START JInit
    this.E = $Prm0.E;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::FullExprArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3303,
   FQN="clang::Sema::FullExprArg::FullExprArg", NM="_ZN5clang4Sema11FullExprArgC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11FullExprArgC1EOS1_")
  //</editor-fold>
  public /*inline*/ FullExprArg(JD$Move _dparam, final FullExprArg /*&&*/$Prm0) {
    // : E(static_cast<FullExprArg &&>().E) 
    //START JInit
    this.E = $Prm0.E;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FullExprArg::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3303,
   FQN="clang::Sema::FullExprArg::operator=", NM="_ZN5clang4Sema11FullExprArgaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema11FullExprArgaSEOS1_")
  //</editor-fold>
  public final /*inline*/ FullExprArg /*&*/ $assignMove(final FullExprArg /*&&*/$Prm0) {
    this.E = $Prm0.E;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "E=" + E; // NOI18N
  }
}

/// \brief A RAII object to enter scope of a compound statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CompoundScopeRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3353,
 FQN="clang::Sema::CompoundScopeRAII", NM="_ZN5clang4Sema17CompoundScopeRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17CompoundScopeRAIIE")
//</editor-fold>
public static class CompoundScopeRAII implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CompoundScopeRAII::CompoundScopeRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3355,
   FQN="clang::Sema::CompoundScopeRAII::CompoundScopeRAII", NM="_ZN5clang4Sema17CompoundScopeRAIIC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17CompoundScopeRAIIC1ERS0_")
  //</editor-fold>
  public CompoundScopeRAII(final Sema /*&*/ S) {
    // : S(S) 
    //START JInit
    this./*&*/S=/*&*/S;
    //END JInit
    S.ActOnStartOfCompoundStmt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CompoundScopeRAII::~CompoundScopeRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3359,
   FQN="clang::Sema::CompoundScopeRAII::~CompoundScopeRAII", NM="_ZN5clang4Sema17CompoundScopeRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17CompoundScopeRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    S.ActOnFinishOfCompoundStmt();
  }

/*private:*/
  protected/*private*/ final Sema /*&*/ S;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]"; // NOI18N
  }
}

/// An RAII helper that pops function a function scope on exit.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FunctionScopeRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3368,
 FQN="clang::Sema::FunctionScopeRAII", NM="_ZN5clang4Sema17FunctionScopeRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17FunctionScopeRAIIE")
//</editor-fold>
public static class/*struct*/ FunctionScopeRAII implements Destructors.ClassWithDestructor {
  public final Sema /*&*/ S;
  public boolean Active;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FunctionScopeRAII::FunctionScopeRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3371,
   FQN="clang::Sema::FunctionScopeRAII::FunctionScopeRAII", NM="_ZN5clang4Sema17FunctionScopeRAIIC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17FunctionScopeRAIIC1ERS0_")
  //</editor-fold>
  public FunctionScopeRAII(final Sema /*&*/ S) {
    // : S(S), Active(true) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Active = true;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FunctionScopeRAII::~FunctionScopeRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3372,
   FQN="clang::Sema::FunctionScopeRAII::~FunctionScopeRAII", NM="_ZN5clang4Sema17FunctionScopeRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17FunctionScopeRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    if (Active) {
      S.PopFunctionScopeInfo();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FunctionScopeRAII::disable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3376,
   FQN="clang::Sema::FunctionScopeRAII::disable", NM="_ZN5clang4Sema17FunctionScopeRAII7disableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17FunctionScopeRAII7disableEv")
  //</editor-fold>
  public final void disable() {
    Active = false;
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Active=" + Active; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8975,
 FQN="clang::Sema::ConditionResult", NM="_ZN5clang4Sema15ConditionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15ConditionResultE")
//</editor-fold>
public static class ConditionResult {
  protected/*private*/ Decl /*P*/ ConditionVar;
  protected/*private*/ FullExprArg Condition;
  protected/*private*/ boolean Invalid;
  protected/*private*/ boolean HasKnownValue;
  protected/*private*/ boolean KnownValue;
  
  /*friend  class Sema*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::ConditionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8983,
   FQN="clang::Sema::ConditionResult::ConditionResult", NM="_ZN5clang4Sema15ConditionResultC1ERS0_PNS_4DeclENS0_11FullExprArgEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15ConditionResultC1ERS0_PNS_4DeclENS0_11FullExprArgEb")
  //</editor-fold>
  protected/*private*/ ConditionResult(final Sema /*&*/ S, Decl /*P*/ ConditionVar, FullExprArg Condition, 
      boolean IsConstexpr) {
    // : ConditionVar(ConditionVar), Condition(Condition), Invalid(false), HasKnownValue(IsConstexpr && Condition.get() && !Condition.get()->isValueDependent()), KnownValue(HasKnownValue && !! Condition.get()->EvaluateKnownConstInt(S.Context)) 
    //START JInit
    this.ConditionVar = ConditionVar;
    this.Condition = new FullExprArg(Condition);
    this.Invalid = false;
    this.HasKnownValue = IsConstexpr && (Condition.get() != null)
       && !Condition.get().isValueDependent();
    this.KnownValue = HasKnownValue
       && !Condition.get().EvaluateKnownConstInt(S.Context).$not();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::ConditionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8990,
   FQN="clang::Sema::ConditionResult::ConditionResult", NM="_ZN5clang4Sema15ConditionResultC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15ConditionResultC1Eb")
  //</editor-fold>
  protected/*private*/ /*explicit*/ ConditionResult(boolean Invalid) {
    // : ConditionVar(null), Condition(null), Invalid(Invalid), HasKnownValue(false), KnownValue(false) 
    //START JInit
    this.ConditionVar = null;
    this.Condition = new FullExprArg((Expr /*P*/ )null);
    this.Invalid = Invalid;
    this.HasKnownValue = false;
    this.KnownValue = false;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::ConditionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8995,
   FQN="clang::Sema::ConditionResult::ConditionResult", NM="_ZN5clang4Sema15ConditionResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15ConditionResultC1Ev")
  //</editor-fold>
  public ConditionResult() {
    // : ConditionResult(false) 
    //START JInit
    this(false);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8996,
   FQN="clang::Sema::ConditionResult::isInvalid", NM="_ZNK5clang4Sema15ConditionResult9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema15ConditionResult9isInvalidEv")
  //</editor-fold>
  public final boolean isInvalid() /*const*/ {
    return Invalid;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8997,
   FQN="clang::Sema::ConditionResult::get", NM="_ZNK5clang4Sema15ConditionResult3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema15ConditionResult3getEv")
  //</editor-fold>
  public final std.pair<VarDecl /*P*/ , Expr /*P*/ > get() /*const*/ {
    return std.make_pair_Ptr_Ptr(cast_or_null_VarDecl(ConditionVar), 
        Condition.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::getKnownValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9001,
   FQN="clang::Sema::ConditionResult::getKnownValue", NM="_ZNK5clang4Sema15ConditionResult13getKnownValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema15ConditionResult13getKnownValueEv")
  //</editor-fold>
  public final OptionalBool getKnownValue() /*const*/ {
    if (!HasKnownValue) {
      return new OptionalBool(None);
    }
    return new OptionalBool(JD$T$C$R.INSTANCE, KnownValue);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::ConditionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8975,
   FQN="clang::Sema::ConditionResult::ConditionResult", NM="_ZN5clang4Sema15ConditionResultC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15ConditionResultC1EOS1_")
  //</editor-fold>
  public /*inline*/ ConditionResult(JD$Move _dparam, final ConditionResult /*&&*/$Prm0) {
    // : ConditionVar(static_cast<ConditionResult &&>().ConditionVar), Condition(static_cast<ConditionResult &&>().Condition), Invalid(static_cast<ConditionResult &&>().Invalid), HasKnownValue(static_cast<ConditionResult &&>().HasKnownValue), KnownValue(static_cast<ConditionResult &&>().KnownValue) 
    //START JInit
    this.ConditionVar = $Prm0.ConditionVar;
    this.Condition = new FullExprArg(JD$Move.INSTANCE, $Prm0.Condition);
    this.Invalid = $Prm0.Invalid;
    this.HasKnownValue = $Prm0.HasKnownValue;
    this.KnownValue = $Prm0.KnownValue;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::ConditionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8975,
   FQN="clang::Sema::ConditionResult::ConditionResult", NM="_ZN5clang4Sema15ConditionResultC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15ConditionResultC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ConditionResult(final /*const*/ ConditionResult /*&*/ $Prm0) {
    // : ConditionVar(.ConditionVar), Condition(.Condition), Invalid(.Invalid), HasKnownValue(.HasKnownValue), KnownValue(.KnownValue) 
    //START JInit
    this.ConditionVar = $Prm0.ConditionVar;
    this.Condition = new FullExprArg($Prm0.Condition);
    this.Invalid = $Prm0.Invalid;
    this.HasKnownValue = $Prm0.HasKnownValue;
    this.KnownValue = $Prm0.KnownValue;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8975,
   FQN="clang::Sema::ConditionResult::operator=", NM="_ZN5clang4Sema15ConditionResultaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema15ConditionResultaSEOS1_")
  //</editor-fold>
  public final /*inline*/ ConditionResult /*&*/ $assignMove(final ConditionResult /*&&*/$Prm0) {
    this.ConditionVar = $Prm0.ConditionVar;
    this.Condition.$assignMove($Prm0.Condition);
    this.Invalid = $Prm0.Invalid;
    this.HasKnownValue = $Prm0.HasKnownValue;
    this.KnownValue = $Prm0.KnownValue;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "ConditionVar=" + ConditionVar // NOI18N
              + ", Condition=" + Condition // NOI18N
              + ", Invalid=" + Invalid // NOI18N
              + ", HasKnownValue=" + HasKnownValue // NOI18N
              + ", KnownValue=" + KnownValue; // NOI18N
  }
}

// This struct is for use by ActOnMemberAccess to allow
// BuildMemberReferenceExpr to be able to reinvoke ActOnMemberAccess after
// changing the access operator from a '.' to a '->' (to see if that is the
// change needed to fix an error about an unknown member, e.g. when the class
// defines a custom operator->).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMemberAccessExtraArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3941,
 FQN="clang::Sema::ActOnMemberAccessExtraArgs", NM="_ZN5clang4Sema26ActOnMemberAccessExtraArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema26ActOnMemberAccessExtraArgsE")
//</editor-fold>
public static class/*struct*/ ActOnMemberAccessExtraArgs {
  public Scope /*P*/ S;
  public final UnqualifiedId /*&*/ Id;
  public Decl /*P*/ ObjCImpDecl;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ActOnMemberAccessExtraArgs(Scope S, UnqualifiedId Id, Decl ObjCImpDecl) {
    this.S = S;
    this.Id = Id;
    this.ObjCImpDecl = ObjCImpDecl;
  }

  @Override public String toString() {
    return "" + "S=" + S // NOI18N
              + ", Id=" + Id // NOI18N
              + ", ObjCImpDecl=" + ObjCImpDecl; // NOI18N
  }
}

// __builtin_offsetof(type, identifier(.identifier|[expr])*)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::OffsetOfComponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4080,
 FQN="clang::Sema::OffsetOfComponent", NM="_ZN5clang4Sema17OffsetOfComponentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17OffsetOfComponentE")
//</editor-fold>
public static class/*struct*/ OffsetOfComponent implements NativeCloneable<OffsetOfComponent> {
  public SourceLocation LocStart;
  public SourceLocation LocEnd;
  public boolean isBrackets; // true if [expr], false if .ident
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OffsetOfComponent::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4083,
   FQN="clang::Sema::OffsetOfComponent::(anonymous)", NM="_ZN5clang4Sema17OffsetOfComponentE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema17OffsetOfComponentE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public IdentifierInfo /*P*/ IdentInfo;
    public Expr /*P*/ E;

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::OffsetOfComponent::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4083,
     FQN="clang::Sema::OffsetOfComponent::(anonymous union)::", NM="_ZN5clang4Sema17OffsetOfComponentUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang4Sema17OffsetOfComponentUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union1() {
    }

    public /*inline*/ Unnamed_union1(Unnamed_union1 $Prm0) {
      this.IdentInfo = $Prm0.IdentInfo;
      this.E = $Prm0.E;
    }
    
    @Override public String toString() {
      return "" + "IdentInfo=" + IdentInfo // NOI18N
                + ", E=" + E; // NOI18N
    }
  };
  public final Unnamed_union1 U;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OffsetOfComponent::OffsetOfComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4080,
   FQN="clang::Sema::OffsetOfComponent::OffsetOfComponent", NM="_ZN5clang4Sema17OffsetOfComponentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang4Sema17OffsetOfComponentC1Ev")
  //</editor-fold>
  public /*inline*/ OffsetOfComponent() {
    // : LocStart(), LocEnd(), U() 
    //START JInit
    this.LocStart = new SourceLocation();
    this.LocEnd = new SourceLocation();
    this.U = new Unnamed_union1();
    this.isBrackets = false;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OffsetOfComponent::~OffsetOfComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4080,
   FQN="clang::Sema::OffsetOfComponent::~OffsetOfComponent", NM="_ZN5clang4Sema17OffsetOfComponentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang4Sema17OffsetOfComponentD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
  }

  private /*inline*/ OffsetOfComponent(OffsetOfComponent $Prm0) {
    // : LocStart(), LocEnd(), U() 
    //START JInit
    this.LocStart = new SourceLocation($Prm0.LocStart);
    this.LocEnd = new SourceLocation($Prm0.LocEnd);
    this.U = new Unnamed_union1($Prm0.U);
    this.isBrackets = $Prm0.isBrackets;
    //END JInit
  }
  
  @Override public OffsetOfComponent clone() { 
    return new OffsetOfComponent(this); 
  }
  
  @Override public String toString() {
    return "" + "LocStart=" + LocStart // NOI18N
              + ", LocEnd=" + LocEnd // NOI18N
              + ", isBrackets=" + isBrackets // NOI18N
              + ", U=" + U; // NOI18N
  }
}

/// \brief Helper class that collects exception specifications for
/// implicitly-declared special member functions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4338,
 FQN="clang::Sema::ImplicitExceptionSpecification", NM="_ZN5clang4Sema30ImplicitExceptionSpecificationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecificationE")
//</editor-fold>
public static class ImplicitExceptionSpecification implements Destructors.ClassWithDestructor {
  // Pointer to allow copying
  protected/*private*/ Sema /*P*/ Self;
  // We order exception specifications thus:
  // noexcept is the most restrictive, but is only used in C++11.
  // throw() comes next.
  // Then a throw(collected exceptions)
  // Finally no specification, which is expressed as noexcept(false).
  // throw(...) is used instead if any called function uses it.
  protected/*private*/ ExceptionSpecificationType ComputedEST;
  protected/*private*/ SmallPtrSet<CanQual<Type>> ExceptionsSeen;
  protected/*private*/ SmallVector<QualType> Exceptions;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::ClearExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4351,
   FQN="clang::Sema::ImplicitExceptionSpecification::ClearExceptions", NM="_ZN5clang4Sema30ImplicitExceptionSpecification15ClearExceptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecification15ClearExceptionsEv")
  //</editor-fold>
  protected/*private*/ final void ClearExceptions() {
    ExceptionsSeen.clear();
    Exceptions.clear();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::ImplicitExceptionSpecification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4357,
   FQN="clang::Sema::ImplicitExceptionSpecification::ImplicitExceptionSpecification", NM="_ZN5clang4Sema30ImplicitExceptionSpecificationC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecificationC1ERS0_")
  //</editor-fold>
  public /*explicit*/ ImplicitExceptionSpecification(final Sema /*&*/ Self) {
    // : Self(&Self), ComputedEST(EST_BasicNoexcept), ExceptionsSeen(), Exceptions() 
    //START JInit
    this.Self = $AddrOf(Self);
    this.ComputedEST = ExceptionSpecificationType.EST_BasicNoexcept;
    this.ExceptionsSeen = new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 4);
    this.Exceptions = new SmallVector<QualType>(4, new QualType());
    //END JInit
    if (!Self.getLangOpts().CPlusPlus11) {
      ComputedEST = ExceptionSpecificationType.EST_DynamicNone;
    }
  }

  
  /// \brief Get the computed exception specification type.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::getExceptionSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4364,
   FQN="clang::Sema::ImplicitExceptionSpecification::getExceptionSpecType", NM="_ZNK5clang4Sema30ImplicitExceptionSpecification20getExceptionSpecTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema30ImplicitExceptionSpecification20getExceptionSpecTypeEv")
  //</editor-fold>
  public final ExceptionSpecificationType getExceptionSpecType() /*const*/ {
    assert (ComputedEST != ExceptionSpecificationType.EST_ComputedNoexcept) : "noexcept(expr) should not be a possible result";
    return ComputedEST;
  }

  
  /// \brief The number of exceptions in the exception specification.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4371,
   FQN="clang::Sema::ImplicitExceptionSpecification::size", NM="_ZNK5clang4Sema30ImplicitExceptionSpecification4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema30ImplicitExceptionSpecification4sizeEv")
  //</editor-fold>
  public final /*uint*/int size() /*const*/ {
    return Exceptions.size();
  }

  
  /// \brief The set of exceptions in the exception specification.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::data">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4374,
   FQN="clang::Sema::ImplicitExceptionSpecification::data", NM="_ZNK5clang4Sema30ImplicitExceptionSpecification4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema30ImplicitExceptionSpecification4dataEv")
  //</editor-fold>
  public final /*const*/type$ptr<QualType /*P*/> data() /*const*/ {
    return Exceptions.data$Const();
  }

  
  /// \brief Integrate another called method into the collected data.
  
  /// \brief Integrate another called method into the collected data.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::CalledDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 150,
   FQN="clang::Sema::ImplicitExceptionSpecification::CalledDecl", NM="_ZN5clang4Sema30ImplicitExceptionSpecification10CalledDeclENS_14SourceLocationEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecification10CalledDeclENS_14SourceLocationEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public final void CalledDecl(SourceLocation CallLoc, 
            /*const*/ CXXMethodDecl /*P*/ Method) {
    // If we have an MSAny spec already, don't bother.
    if (!(Method != null) || ComputedEST == ExceptionSpecificationType.EST_MSAny) {
      return;
    }
    
    /*const*/ FunctionProtoType /*P*/ Proto = Method.getType().$arrow().getAs(FunctionProtoType.class);
    Proto = Self.ResolveExceptionSpec(new SourceLocation(CallLoc), Proto);
    if (!(Proto != null)) {
      return;
    }
    
    ExceptionSpecificationType EST = Proto.getExceptionSpecType();
    
    // If we have a throw-all spec at this point, ignore the function.
    if (ComputedEST == ExceptionSpecificationType.EST_None) {
      return;
    }
    switch (EST) {
     case EST_MSAny:
     case EST_None:
      // If this function can throw any exceptions, make a note of that.
      ClearExceptions();
      ComputedEST = EST;
      return;
     case EST_BasicNoexcept:
      // FIXME: If the call to this decl is using any of its default arguments, we
      // need to search them for potentially-throwing calls.
      // If this function has a basic noexcept, it doesn't affect the outcome.
      return;
     case EST_DynamicNone:
      // If we're still at noexcept(true) and there's a nothrow() callee,
      // change to that specification.
      if (ComputedEST == ExceptionSpecificationType.EST_BasicNoexcept) {
        ComputedEST = ExceptionSpecificationType.EST_DynamicNone;
      }
      return;
     case EST_ComputedNoexcept:
      {
        FunctionProtoType.NoexceptResult NR = Proto.getNoexceptSpec(Self.Context);
        assert (NR != FunctionProtoType.NoexceptResult.NR_NoNoexcept) : "Must have noexcept result for EST_ComputedNoexcept.";
        assert (NR != FunctionProtoType.NoexceptResult.NR_Dependent) : "Should not generate implicit declarations for dependent cases, and don't know how to handle them anyway.";
        // noexcept(false) -> no spec on the new function
        if (NR == FunctionProtoType.NoexceptResult.NR_Throw) {
          ClearExceptions();
          ComputedEST = ExceptionSpecificationType.EST_None;
        }
        // noexcept(true) won't change anything either.
        return;
      }
     default:
      break;
    }
    assert (EST == ExceptionSpecificationType.EST_Dynamic) : "EST case not considered earlier.";
    assert (ComputedEST != ExceptionSpecificationType.EST_None) : "Shouldn't collect exceptions when throw-all is guaranteed.";
    ComputedEST = ExceptionSpecificationType.EST_Dynamic;
    // Record the exceptions in this function's exception specification.
    for (final /*const*/ QualType /*&*/ E : Proto.exceptions())  {
      if (ExceptionsSeen.insert(Self.Context.getCanonicalType(new QualType(E))).second) {
        Exceptions.push_back(E);
      }
    }
  }


  
  /// \brief Integrate an invoked expression into the collected data.
  
  /// \brief Integrate an invoked expression into the collected data.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::CalledExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 218,
   FQN="clang::Sema::ImplicitExceptionSpecification::CalledExpr", NM="_ZN5clang4Sema30ImplicitExceptionSpecification10CalledExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecification10CalledExprEPNS_4ExprE")
  //</editor-fold>
  public final void CalledExpr(Expr /*P*/ E) {
    if (!(E != null) || ComputedEST == ExceptionSpecificationType.EST_MSAny) {
      return;
    }
    
    // FIXME:
    //
    // C++0x [except.spec]p14:
    //   [An] implicit exception-specification specifies the type-id T if and
    // only if T is allowed by the exception-specification of a function directly
    // invoked by f's implicit definition; f shall allow all exceptions if any
    // function it directly invokes allows all exceptions, and f shall allow no
    // exceptions if every function it directly invokes allows no exceptions.
    //
    // Note in particular that if an implicit exception-specification is generated
    // for a function containing a throw-expression, that specification can still
    // be noexcept(true).
    //
    // Note also that 'directly invoked' is not defined in the standard, and there
    // is no indication that we should only consider potentially-evaluated calls.
    //
    // Ultimately we should implement the intent of the standard: the exception
    // specification should be the set of exceptions which can be thrown by the
    // implicit definition. For now, we assume that any non-nothrow expression can
    // throw any exception.
    if ((Self.canThrow(E).getValue() != 0)) {
      ComputedEST = ExceptionSpecificationType.EST_None;
    }
  }


  
  /// \brief Overwrite an EPI's exception specification with this
  /// computed exception specification.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::getExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4384,
   FQN="clang::Sema::ImplicitExceptionSpecification::getExceptionSpec", NM="_ZNK5clang4Sema30ImplicitExceptionSpecification16getExceptionSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema30ImplicitExceptionSpecification16getExceptionSpecEv")
  //</editor-fold>
  public final FunctionProtoType.ExceptionSpecInfo getExceptionSpec() /*const*/ {
    FunctionProtoType.ExceptionSpecInfo ESI/*J*/= new FunctionProtoType.ExceptionSpecInfo();
    ESI.Type = getExceptionSpecType();
    if (ESI.Type == ExceptionSpecificationType.EST_Dynamic) {
      ESI.Exceptions.$assignMove(new ArrayRef<QualType>(Exceptions, false));
    } else if (ESI.Type == ExceptionSpecificationType.EST_None) {
      /// C++11 [except.spec]p14:
      ///   The exception-specification is noexcept(false) if the set of
      ///   potential exceptions of the special member function contains "any"
      ESI.Type = ExceptionSpecificationType.EST_ComputedNoexcept;
      ESI.NoexceptExpr = Self.ActOnCXXBoolLiteral(new SourceLocation(), 
          tok.TokenKind.kw_false).get();
    }
    return ESI;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::ImplicitExceptionSpecification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4338,
   FQN="clang::Sema::ImplicitExceptionSpecification::ImplicitExceptionSpecification", NM="_ZN5clang4Sema30ImplicitExceptionSpecificationC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecificationC1EOS1_")
  //</editor-fold>
  public /*inline*/ ImplicitExceptionSpecification(JD$Move _dparam, final ImplicitExceptionSpecification /*&&*/$Prm0) {
    // : Self(static_cast<ImplicitExceptionSpecification &&>().Self), ComputedEST(static_cast<ImplicitExceptionSpecification &&>().ComputedEST), ExceptionsSeen(static_cast<ImplicitExceptionSpecification &&>().ExceptionsSeen), Exceptions(static_cast<ImplicitExceptionSpecification &&>().Exceptions) 
    //START JInit
    this.Self = $Prm0.Self;
    this.ComputedEST = $Prm0.ComputedEST;
    this.ExceptionsSeen = new SmallPtrSet<CanQual<Type>>(JD$Move.INSTANCE, $Prm0.ExceptionsSeen);
    this.Exceptions = new SmallVector<QualType>(JD$Move.INSTANCE, $Prm0.Exceptions);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitExceptionSpecification::~ImplicitExceptionSpecification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4338,
   FQN="clang::Sema::ImplicitExceptionSpecification::~ImplicitExceptionSpecification", NM="_ZN5clang4Sema30ImplicitExceptionSpecificationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ImplicitExceptionSpecificationD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    Exceptions.$destroy();
    ExceptionsSeen.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Self=" + "[Sema]" // NOI18N
              + ", ComputedEST=" + ComputedEST // NOI18N
              + ", ExceptionsSeen=" + ExceptionsSeen // NOI18N
              + ", Exceptions=" + Exceptions; // NOI18N
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::InheritedConstructorInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5074,
 FQN="clang::Sema::InheritedConstructorInfo", NM="_ZN5clang4Sema24InheritedConstructorInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24InheritedConstructorInfoE")
//</editor-fold>
public static class InheritedConstructorInfo implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ SourceLocation UseLoc;
  
  /// A mapping from the base classes through which the constructor was
  /// inherited to the using shadow declaration in that base class (or a null
  /// pointer if the constructor was declared in that base class).
  protected/*private*/ DenseMap<CXXRecordDecl /*P*/ , ConstructorUsingShadowDecl /*P*/ > InheritedFromBases;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InheritedConstructorInfo::InheritedConstructorInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5085,
   FQN="clang::Sema::InheritedConstructorInfo::InheritedConstructorInfo", NM="_ZN5clang4Sema24InheritedConstructorInfoC1ERS0_NS_14SourceLocationEPNS_26ConstructorUsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24InheritedConstructorInfoC1ERS0_NS_14SourceLocationEPNS_26ConstructorUsingShadowDeclE")
  //</editor-fold>
  public InheritedConstructorInfo(final Sema /*&*/ S, SourceLocation UseLoc, 
      ConstructorUsingShadowDecl /*P*/ Shadow) {
    // : S(S), UseLoc(UseLoc), InheritedFromBases() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.UseLoc = new SourceLocation(UseLoc);
    this.InheritedFromBases = new DenseMap<CXXRecordDecl /*P*/ , ConstructorUsingShadowDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ConstructorUsingShadowDecl /*P*/ )null);
    //END JInit
    boolean DiagnosedMultipleConstructedBases = false;
    CXXRecordDecl /*P*/ ConstructedBase = null;
    UsingDecl /*P*/ ConstructedBaseUsing = null;
    
    // Find the set of such base class subobjects and check that there's a
    // unique constructed subobject.
    for (UsingShadowDecl /*P*/ D : Shadow.redeclarable_redecls()) {
      ConstructorUsingShadowDecl /*P*/ DShadow = cast_ConstructorUsingShadowDecl(D);
      CXXRecordDecl /*P*/ DNominatedBase = DShadow.getNominatedBaseClass();
      CXXRecordDecl /*P*/ DConstructedBase = DShadow.getConstructedBaseClass();
      
      InheritedFromBases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(DNominatedBase.getCanonicalDecl(), 
              DShadow.getNominatedBaseClassShadowDecl()));
      if (DShadow.constructsVirtualBase()) {
        InheritedFromBases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(DConstructedBase.getCanonicalDecl(), 
                DShadow.getConstructedBaseClassShadowDecl()));
      } else {
        assert (DNominatedBase == DConstructedBase);
      }
      
      // [class.inhctor.init]p2:
      //   If the constructor was inherited from multiple base class subobjects
      //   of type B, the program is ill-formed.
      if (!(ConstructedBase != null)) {
        ConstructedBase = DConstructedBase;
        ConstructedBaseUsing = D.getUsingDecl();
      } else if (ConstructedBase != DConstructedBase
         && !Shadow.isInvalidDecl()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!DiagnosedMultipleConstructedBases) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(UseLoc), diag.err_ambiguous_inherited_constructor)), 
                Shadow.getTargetDecl()));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ConstructedBaseUsing.getLocation(), 
                    diag.note_ambiguous_inherited_constructor_using)), 
                ConstructedBase));
            DiagnosedMultipleConstructedBases = true;
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getUsingDecl().getLocation(), 
                  diag.note_ambiguous_inherited_constructor_using)), 
              DConstructedBase));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (DiagnosedMultipleConstructedBases) {
      Shadow.setInvalidDecl();
    }
  }

  
  /// Find the constructor to use for inherited construction of a base class,
  /// and whether that base class constructor inherits the constructor from a
  /// virtual base class (in which case it won't actually invoke it).
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InheritedConstructorInfo::findConstructorForBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5138,
   FQN="clang::Sema::InheritedConstructorInfo::findConstructorForBase", NM="_ZNK5clang4Sema24InheritedConstructorInfo22findConstructorForBaseEPNS_13CXXRecordDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK5clang4Sema24InheritedConstructorInfo22findConstructorForBaseEPNS_13CXXRecordDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public final std.pairTypeBool<CXXConstructorDecl /*P*/ > findConstructorForBase(CXXRecordDecl /*P*/ Base, CXXConstructorDecl /*P*/ Ctor) /*const*/ {
    DenseMapIterator<CXXRecordDecl /*P*/ , ConstructorUsingShadowDecl /*P*/ > It = InheritedFromBases.find$Const(Base.getCanonicalDecl());
    if (It.$eq(InheritedFromBases.end$Const())) {
      return std.make_pair_nullptr_t_bool((CXXConstructorDecl /*P*/)null, false);
    }
    
    // This is an intermediary class.
    if ((It.$arrow().second != null)) {
      return std.make_pair_Ptr_bool(S.findInheritingConstructor(new SourceLocation(UseLoc), Ctor, It.$arrow().second), 
          It.$arrow().second.constructsVirtualBase());
    }
    
    // This is the base class from which the constructor was inherited.
    return std.make_pair_Ptr_bool(Ctor, false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InheritedConstructorInfo::~InheritedConstructorInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5074,
   FQN="clang::Sema::InheritedConstructorInfo::~InheritedConstructorInfo", NM="_ZN5clang4Sema24InheritedConstructorInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24InheritedConstructorInfoD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    InheritedFromBases.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", UseLoc=" + UseLoc // NOI18N
              + ", InheritedFromBases=" + InheritedFromBases; // NOI18N
  }
}

/// \brief RAII object used to temporarily allow the C++ 'this' expression
/// to be used, with the given qualifiers on the current class type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CXXThisScopeRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4695,
 FQN="clang::Sema::CXXThisScopeRAII", NM="_ZN5clang4Sema16CXXThisScopeRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema16CXXThisScopeRAIIE")
//</editor-fold>
public static class CXXThisScopeRAII implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ QualType OldCXXThisTypeOverride;
  protected/*private*/ boolean Enabled;
/*public:*/
  /// \brief Introduce a new scope where 'this' may be allowed (when enabled),
  /// using the given declaration (which is either a class template or a
  /// class) along with the given qualifiers.
  /// along with the qualifiers placed on '*this'.
  /// \brief Introduce a new scope where 'this' may be allowed (when enabled),
  /// using the given declaration (which is either a class template or a
  /// class) along with the given qualifiers.
  /// along with the qualifiers placed on '*this'.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CXXThisScopeRAII::CXXThisScopeRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 995,
   FQN="clang::Sema::CXXThisScopeRAII::CXXThisScopeRAII", NM="_ZN5clang4Sema16CXXThisScopeRAIIC1ERS0_PNS_4DeclEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema16CXXThisScopeRAIIC1ERS0_PNS_4DeclEjb")
  //</editor-fold>
  public CXXThisScopeRAII(final Sema /*&*/ S, 
      Decl /*P*/ ContextDecl, 
      /*uint*/int CXXThisTypeQuals) {
    this(S, 
      ContextDecl, 
      CXXThisTypeQuals, 
      true);
  }
  public CXXThisScopeRAII(final Sema /*&*/ S, 
      Decl /*P*/ ContextDecl, 
      /*uint*/int CXXThisTypeQuals, 
      boolean Enabled/*= true*/) {
    // : S(S), OldCXXThisTypeOverride(S.CXXThisTypeOverride), Enabled(false) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.OldCXXThisTypeOverride = new QualType(S.CXXThisTypeOverride);
    this.Enabled = false;
    //END JInit
    if (!Enabled || !(ContextDecl != null)) {
      return;
    }
    
    CXXRecordDecl /*P*/ Record = null;
    {
      ClassTemplateDecl /*P*/ Template = dyn_cast_ClassTemplateDecl(ContextDecl);
      if ((Template != null)) {
        Record = Template.getTemplatedDecl();
      } else {
        Record = cast_CXXRecordDecl(ContextDecl);
      }
    }
    
    // We care only for CVR qualifiers here, so cut everything else.
    CXXThisTypeQuals &= Qualifiers.FastMask;
    S.CXXThisTypeOverride.$assignMove(
        S.Context.getPointerType(S.Context.getRecordType(Record).withCVRQualifiers(CXXThisTypeQuals))
    );
    
    this.Enabled = true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CXXThisScopeRAII::~CXXThisScopeRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1020,
   FQN="clang::Sema::CXXThisScopeRAII::~CXXThisScopeRAII", NM="_ZN5clang4Sema16CXXThisScopeRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema16CXXThisScopeRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    if (Enabled) {
      S.CXXThisTypeOverride.$assign(OldCXXThisTypeOverride);
    }
  }


  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", OldCXXThisTypeOverride=" + OldCXXThisTypeOverride // NOI18N
              + ", Enabled=" + Enabled; // NOI18N
  }
}

/// brief A function argument from which we performed template argument
// deduction for a call.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::OriginalCallArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6477,
 FQN="clang::Sema::OriginalCallArg", NM="_ZN5clang4Sema15OriginalCallArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15OriginalCallArgE")
//</editor-fold>
public static class/*struct*/ OriginalCallArg implements NativeCloneable<OriginalCallArg> {

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public OriginalCallArg() {
    this.OriginalParamType = new QualType();
    this.ArgIdx = 0;
    this.OriginalArgType = new QualType();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OriginalCallArg::OriginalCallArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6478,
   FQN="clang::Sema::OriginalCallArg::OriginalCallArg", NM="_ZN5clang4Sema15OriginalCallArgC1ENS_8QualTypeEjS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema15OriginalCallArgC1ENS_8QualTypeEjS2_")
  //</editor-fold>
  public OriginalCallArg(QualType OriginalParamType, 
      /*uint*/int ArgIdx, 
      QualType OriginalArgType) {
    // : OriginalParamType(OriginalParamType), ArgIdx(ArgIdx), OriginalArgType(OriginalArgType) 
    //START JInit
    this.OriginalParamType = new QualType(OriginalParamType);
    this.ArgIdx = ArgIdx;
    this.OriginalArgType = new QualType(OriginalArgType);
    //END JInit
  }

  
  public QualType OriginalParamType;
  public /*uint*/int ArgIdx;
  public QualType OriginalArgType;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OriginalCallArg::OriginalCallArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6477,
   FQN="clang::Sema::OriginalCallArg::OriginalCallArg", NM="_ZN5clang4Sema15OriginalCallArgC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema15OriginalCallArgC1ERKS1_")
  //</editor-fold>
  public /*inline*/ OriginalCallArg(final /*const*/ OriginalCallArg /*&*/ $Prm0) {
    // : OriginalParamType(.OriginalParamType), ArgIdx(.ArgIdx), OriginalArgType(.OriginalArgType) 
    //START JInit
    this.OriginalParamType = new QualType($Prm0.OriginalParamType);
    this.ArgIdx = $Prm0.ArgIdx;
    this.OriginalArgType = new QualType($Prm0.OriginalArgType);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OriginalCallArg::OriginalCallArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6477,
   FQN="clang::Sema::OriginalCallArg::OriginalCallArg", NM="_ZN5clang4Sema15OriginalCallArgC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema15OriginalCallArgC1EOS1_")
  //</editor-fold>
  public /*inline*/ OriginalCallArg(JD$Move _dparam, final OriginalCallArg /*&&*/$Prm0) {
    // : OriginalParamType(static_cast<OriginalCallArg &&>().OriginalParamType), ArgIdx(static_cast<OriginalCallArg &&>().ArgIdx), OriginalArgType(static_cast<OriginalCallArg &&>().OriginalArgType) 
    //START JInit
    this.OriginalParamType = new QualType(JD$Move.INSTANCE, $Prm0.OriginalParamType);
    this.ArgIdx = $Prm0.ArgIdx;
    this.OriginalArgType = new QualType(JD$Move.INSTANCE, $Prm0.OriginalArgType);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::OriginalCallArg::~OriginalCallArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6477,
   FQN="clang::Sema::OriginalCallArg::~OriginalCallArg", NM="_ZN5clang4Sema15OriginalCallArgD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema15OriginalCallArgD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
  }

  @Override
  public OriginalCallArg clone() {
    return new OriginalCallArg(this);
  }
  
  @Override public String toString() {
    return "" + "OriginalParamType=" + OriginalParamType // NOI18N
              + ", ArgIdx=" + ArgIdx // NOI18N
              + ", OriginalArgType=" + OriginalArgType; // NOI18N
  }
  }

/// \brief A template instantiation that is currently in progress.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6608,
 FQN="clang::Sema::ActiveTemplateInstantiation", NM="_ZN5clang4Sema27ActiveTemplateInstantiationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ActiveTemplateInstantiationE")
//</editor-fold>
public static class/*struct*/ ActiveTemplateInstantiation implements NativePOD<ActiveTemplateInstantiation> {
  /// \brief The kind of template instantiation we are performing
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::InstantiationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6610,
   FQN="clang::Sema::ActiveTemplateInstantiation::InstantiationKind", NM="_ZN5clang4Sema27ActiveTemplateInstantiation17InstantiationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ActiveTemplateInstantiation17InstantiationKindE")
  //</editor-fold>
  public enum InstantiationKind implements Native.ComparableLower {
    /// We are instantiating a template declaration. The entity is
    /// the declaration we're instantiating (e.g., a CXXRecordDecl).
    TemplateInstantiation(0),
    
    /// We are instantiating a default argument for a template
    /// parameter. The Entity is the template, and
    /// TemplateArgs/NumTemplateArguments provides the template
    /// arguments as specified.
    /// FIXME: Use a TemplateArgumentList
    DefaultTemplateArgumentInstantiation(TemplateInstantiation.getValue() + 1),
    
    /// We are instantiating a default argument for a function.
    /// The Entity is the ParmVarDecl, and TemplateArgs/NumTemplateArgs
    /// provides the template arguments as specified.
    DefaultFunctionArgumentInstantiation(DefaultTemplateArgumentInstantiation.getValue() + 1),
    
    /// We are substituting explicit template arguments provided for
    /// a function template. The entity is a FunctionTemplateDecl.
    ExplicitTemplateArgumentSubstitution(DefaultFunctionArgumentInstantiation.getValue() + 1),
    
    /// We are substituting template argument determined as part of
    /// template argument deduction for either a class template
    /// partial specialization or a function template. The
    /// Entity is either a ClassTemplatePartialSpecializationDecl or
    /// a FunctionTemplateDecl.
    DeducedTemplateArgumentSubstitution(ExplicitTemplateArgumentSubstitution.getValue() + 1),
    
    /// We are substituting prior template arguments into a new
    /// template parameter. The template parameter itself is either a
    /// NonTypeTemplateParmDecl or a TemplateTemplateParmDecl.
    PriorTemplateArgumentSubstitution(DeducedTemplateArgumentSubstitution.getValue() + 1),
    
    /// We are checking the validity of a default template argument that
    /// has been used when naming a template-id.
    DefaultTemplateArgumentChecking(PriorTemplateArgumentSubstitution.getValue() + 1),
    
    /// We are instantiating the exception specification for a function
    /// template which was deferred until it was needed.
    ExceptionSpecInstantiation(DefaultTemplateArgumentChecking.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InstantiationKind valueOf(int val) {
      InstantiationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InstantiationKind[] VALUES;
      private static final InstantiationKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InstantiationKind kind : InstantiationKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InstantiationKind[min < 0 ? (1-min) : 0];
        VALUES = new InstantiationKind[max >= 0 ? (1+max) : 0];
        for (InstantiationKind kind : InstantiationKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private InstantiationKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InstantiationKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InstantiationKind)obj).value);}
    //</editor-fold>
  };
  public  InstantiationKind Kind;
  
  /// \brief The point of instantiation within the source code.
  public SourceLocation PointOfInstantiation;
  
  /// \brief The template (or partial specialization) in which we are
  /// performing the instantiation, for substitutions of prior template
  /// arguments.
  public NamedDecl /*P*/ Template;
  
  /// \brief The entity that is being instantiated.
  public Decl /*P*/ Entity;
  
  /// \brief The list of template arguments we are substituting, if they
  /// are not part of the entity.
  public /*const*/ type$ptr<TemplateArgument> /*P*/ TemplateArgs;
  
  /// \brief The number of template arguments in TemplateArgs.
  public /*uint*/int NumTemplateArgs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6670,
   FQN="clang::Sema::ActiveTemplateInstantiation::template_arguments", NM="_ZNK5clang4Sema27ActiveTemplateInstantiation18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema27ActiveTemplateInstantiation18template_argumentsEv")
  //</editor-fold>
  public final ArrayRef<TemplateArgument> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgument>(TemplateArgs, NumTemplateArgs, false)/* }*/;
  }

  
  /// \brief The template deduction info object associated with the
  /// substitution or checking of explicit or deduced template arguments.
  public TemplateDeductionInfo /*P*/ DeductionInfo;
  
  /// \brief The source range that covers the construct that cause
  /// the instantiation, e.g., the template-id that causes a class
  /// template instantiation.
  public SourceRange InstantiationRange;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::ActiveTemplateInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6683,
   FQN="clang::Sema::ActiveTemplateInstantiation::ActiveTemplateInstantiation", NM="_ZN5clang4Sema27ActiveTemplateInstantiationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema27ActiveTemplateInstantiationC1Ev")
  //</editor-fold>
  public ActiveTemplateInstantiation() {
    // : Kind(TemplateInstantiation), PointOfInstantiation(), Template(null), Entity(null), TemplateArgs(null), NumTemplateArgs(0), DeductionInfo(null), InstantiationRange() 
    //START JInit
    this.Kind = InstantiationKind.TemplateInstantiation;
    this.PointOfInstantiation = new SourceLocation();
    this.Template = null;
    this.Entity = null;
    this.TemplateArgs = null;
    this.NumTemplateArgs = 0;
    this.DeductionInfo = null;
    this.InstantiationRange = new SourceRange();
    //END JInit
  }

  
  /// \brief Determines whether this template is an actual instantiation
  /// that should be counted toward the maximum instantiation depth.
  
  /// \brief Determines whether this template is an actual instantiation
  /// that should be counted toward the maximum instantiation depth.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::isInstantiationRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 186,
   FQN="clang::Sema::ActiveTemplateInstantiation::isInstantiationRecord", NM="_ZNK5clang4Sema27ActiveTemplateInstantiation21isInstantiationRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZNK5clang4Sema27ActiveTemplateInstantiation21isInstantiationRecordEv")
  //</editor-fold>
  public final boolean isInstantiationRecord() /*const*/ {
    switch (Kind) {
     case TemplateInstantiation:
     case ExceptionSpecInstantiation:
     case DefaultTemplateArgumentInstantiation:
     case DefaultFunctionArgumentInstantiation:
     case ExplicitTemplateArgumentSubstitution:
     case DeducedTemplateArgumentSubstitution:
     case PriorTemplateArgumentSubstitution:
      return true;
     case DefaultTemplateArgumentChecking:
      return false;
    }
    throw new llvm_unreachable("Invalid InstantiationKind!");
  }


  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6691,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_4Sema27ActiveTemplateInstantiationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clangeqERKNS_4Sema27ActiveTemplateInstantiationES3_")
  //</editor-fold>
  public static boolean $eq_ActiveTemplateInstantiation$C(final /*const*/ ActiveTemplateInstantiation /*&*/ X, 
                                   final /*const*/ ActiveTemplateInstantiation /*&*/ Y) {
    if (X.Kind != Y.Kind) {
      return false;
    }
    if (X.Entity != Y.Entity) {
      return false;
    }
    switch (X.Kind) {
     case TemplateInstantiation:
     case ExceptionSpecInstantiation:
      return true;
     case PriorTemplateArgumentSubstitution:
     case DefaultTemplateArgumentChecking:
      return X.Template == Y.Template && X.TemplateArgs == Y.TemplateArgs;
     case DefaultTemplateArgumentInstantiation:
     case ExplicitTemplateArgumentSubstitution:
     case DeducedTemplateArgumentSubstitution:
     case DefaultFunctionArgumentInstantiation:
      return X.TemplateArgs == Y.TemplateArgs;
    }
    throw new llvm_unreachable("Invalid InstantiationKind!");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6719,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_4Sema27ActiveTemplateInstantiationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clangneERKNS_4Sema27ActiveTemplateInstantiationES3_")
  //</editor-fold>
  public static boolean $noteq_ActiveTemplateInstantiation$C(final /*const*/ ActiveTemplateInstantiation /*&*/ X, 
                                      final /*const*/ ActiveTemplateInstantiation /*&*/ Y) {
    return !($eq_ActiveTemplateInstantiation$C(X, Y));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6608,
   FQN="clang::Sema::ActiveTemplateInstantiation::operator=", NM="_ZN5clang4Sema27ActiveTemplateInstantiationaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema27ActiveTemplateInstantiationaSERKS1_")
  //</editor-fold>
  public final /*inline*/ ActiveTemplateInstantiation /*&*/ $assign(final /*const*/ ActiveTemplateInstantiation /*&*/ $Prm0) {
    this.Kind = $Prm0.Kind;
    this.PointOfInstantiation.$assign($Prm0.PointOfInstantiation);
    this.Template = $Prm0.Template;
    this.Entity = $Prm0.Entity;
    this.TemplateArgs = $Prm0.TemplateArgs;
    this.NumTemplateArgs = $Prm0.NumTemplateArgs;
    this.DeductionInfo = $Prm0.DeductionInfo;
    this.InstantiationRange.$assign($Prm0.InstantiationRange);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::~ActiveTemplateInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6608,
   FQN="clang::Sema::ActiveTemplateInstantiation::~ActiveTemplateInstantiation", NM="_ZN5clang4Sema27ActiveTemplateInstantiationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27ActiveTemplateInstantiationD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActiveTemplateInstantiation::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6608,
   FQN="clang::Sema::ActiveTemplateInstantiation::operator=", NM="_ZN5clang4Sema27ActiveTemplateInstantiationaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27ActiveTemplateInstantiationaSEOS1_")
  //</editor-fold>
  public final /*inline*/ ActiveTemplateInstantiation /*&*/ $assignMove(final ActiveTemplateInstantiation /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.PointOfInstantiation.$assignMove($Prm0.PointOfInstantiation);
    this.Template = $Prm0.Template;
    this.Entity = $Prm0.Entity;
    this.TemplateArgs = $Prm0.TemplateArgs;
    this.NumTemplateArgs = $Prm0.NumTemplateArgs;
    this.DeductionInfo = $Prm0.DeductionInfo;
    this.InstantiationRange.$assignMove($Prm0.InstantiationRange);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public ActiveTemplateInstantiation clone() { 
    return new ActiveTemplateInstantiation().$assign(this); 
  }

  @Override
  public boolean $eq(ActiveTemplateInstantiation other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    } 
    if (this.NumTemplateArgs != other.NumTemplateArgs) {
      return false;
    }
    if (this.Kind != other.Kind) {
      return false;
    }
    if (this.Template != other.Template) {
      return false;
    }
    if (this.Entity != other.Entity) {
      return false;
    }
    if (this.DeductionInfo != other.DeductionInfo) {
      return false;
    }
    if (this.PointOfInstantiation.$noteq(other.PointOfInstantiation)) {
      return false;
    }
    if (this.InstantiationRange.$noteq(other.InstantiationRange)) {
      return false;
    }
    if (!Native.$eq_ptr(this.TemplateArgs, other.TemplateArgs)) {
      return false;
    }
    return true;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", PointOfInstantiation=" + PointOfInstantiation // NOI18N
              + ", Template=" + Template // NOI18N
              + ", Entity=" + Entity // NOI18N
              + ", TemplateArgs=" + TemplateArgs // NOI18N
              + ", NumTemplateArgs=" + NumTemplateArgs // NOI18N
              + ", DeductionInfo=" + DeductionInfo // NOI18N
              + ", InstantiationRange=" + InstantiationRange; // NOI18N
  }
  }

/// \brief RAII object used to change the argument pack substitution index
/// within a \c Sema object.
///
/// See \c ArgumentPackSubstitutionIndex for more information.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ArgumentPackSubstitutionIndexRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6785,
 FQN="clang::Sema::ArgumentPackSubstitutionIndexRAII", NM="_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIIE")
//</editor-fold>
public static class ArgumentPackSubstitutionIndexRAII implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ Self;
  protected/*private*/ int OldSubstitutionIndex;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ArgumentPackSubstitutionIndexRAII::ArgumentPackSubstitutionIndexRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6790,
   FQN="clang::Sema::ArgumentPackSubstitutionIndexRAII::ArgumentPackSubstitutionIndexRAII", NM="_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIIC1ERS0_i",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIIC1ERS0_i")
  //</editor-fold>
  public ArgumentPackSubstitutionIndexRAII(final Sema /*&*/ Self, int NewSubstitutionIndex) {
    // : Self(Self), OldSubstitutionIndex(Self.ArgumentPackSubstitutionIndex) 
    //START JInit
    this./*&*/Self=/*&*/Self;
    this.OldSubstitutionIndex = Self.ArgumentPackSubstitutionIndex;
    //END JInit
    Self.ArgumentPackSubstitutionIndex = NewSubstitutionIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ArgumentPackSubstitutionIndexRAII::~ArgumentPackSubstitutionIndexRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6795,
   FQN="clang::Sema::ArgumentPackSubstitutionIndexRAII::~ArgumentPackSubstitutionIndexRAII", NM="_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema33ArgumentPackSubstitutionIndexRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    Self.ArgumentPackSubstitutionIndex = OldSubstitutionIndex;
  }

  
  @Override public String toString() {
    return "" + "Self=" + "[Sema]" // NOI18N
              + ", OldSubstitutionIndex=" + OldSubstitutionIndex; // NOI18N
  }
}

/// \brief A stack object to be created when performing template
/// instantiation.
///
/// Construction of an object of type \c InstantiatingTemplate
/// pushes the current instantiation onto the stack of active
/// instantiations. If the size of this stack exceeds the maximum
/// number of recursive template instantiations, construction
/// produces an error and evaluates true.
///
/// Destruction of this object will pop the named instantiation off
/// the stack.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6822,
 FQN="clang::Sema::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateE")
//</editor-fold>
public static class/*struct*/ InstantiatingTemplate implements Destructors.ClassWithDestructor {
  /// \brief Note that we are instantiating a class template,
  /// function template, variable template, alias template,
  /// or a member thereof.
  /// \brief Note that we are instantiating a class template,
  /// function template, variable template, alias template,
  /// or a member thereof.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 235,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_4DeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_4DeclENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, Decl /*P*/ Entity) {
    this(SemaRef, PointOfInstantiation, Entity, 
      new SourceRange());
  }
  public InstantiatingTemplate(final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, Decl /*P*/ Entity, 
      SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::TemplateInstantiation, PointOfInstantiation, InstantiationRange, Entity) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.TemplateInstantiation, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Entity);
    //END JInit
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::ExceptionSpecification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6830,
   FQN="clang::Sema::InstantiatingTemplate::ExceptionSpecification", NM="_ZN5clang4Sema21InstantiatingTemplate22ExceptionSpecificationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplate22ExceptionSpecificationE")
  //</editor-fold>
  public static class/*struct*/ ExceptionSpecification {

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public /*inline*/ ExceptionSpecification() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::ExceptionSpecification::ExceptionSpecification">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6830,
     FQN="clang::Sema::InstantiatingTemplate::ExceptionSpecification::ExceptionSpecification", NM="_ZN5clang4Sema21InstantiatingTemplate22ExceptionSpecificationC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplate22ExceptionSpecificationC1EOS2_")
    //</editor-fold>
    public /*inline*/ ExceptionSpecification(JD$Move _dparam, final ExceptionSpecification /*&&*/$Prm0) {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::ExceptionSpecification::~ExceptionSpecification">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6830,
     FQN="clang::Sema::InstantiatingTemplate::ExceptionSpecification::~ExceptionSpecification", NM="_ZN5clang4Sema21InstantiatingTemplate22ExceptionSpecificationD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplate22ExceptionSpecificationD0Ev")
    //</editor-fold>
    public final /*inline*/ void $destroy() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  /// \brief Note that we are instantiating an exception specification
  /// of a function template.
  /// \brief Note that we are instantiating an exception specification
  /// of a function template.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 242,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_12FunctionDeclENS1_22ExceptionSpecificationENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_12FunctionDeclENS1_22ExceptionSpecificationENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, FunctionDecl /*P*/ Entity, 
      ExceptionSpecification $Prm3) {
    this(SemaRef, PointOfInstantiation, Entity, 
      $Prm3, new SourceRange());
  }
  public InstantiatingTemplate(final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, FunctionDecl /*P*/ Entity, 
      ExceptionSpecification $Prm3, SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::ExceptionSpecInstantiation, PointOfInstantiation, InstantiationRange, Entity) 
    //START JInit
    this(SemaRef, ActiveTemplateInstantiation.InstantiationKind.ExceptionSpecInstantiation, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Entity);
    //END JInit
  }


  
  /// \brief Note that we are instantiating a default argument in a
  /// template-id.
  
  /// \brief Note that we are instantiating a default argument in a
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 249,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_12TemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_12TemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, TemplateDecl /*P*/ Template, 
      ArrayRef<TemplateArgument> TemplateArgs) {
    this(_dparam, SemaRef, PointOfInstantiation, Template,
      TemplateArgs, new SourceRange());
  }
  public InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, TemplateDecl /*P*/ Template, 
      ArrayRef<TemplateArgument> TemplateArgs, SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::DefaultTemplateArgumentInstantiation, PointOfInstantiation, InstantiationRange, Template, null, TemplateArgs) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.DefaultTemplateArgumentInstantiation, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Template, (NamedDecl /*P*/ )null, 
        new ArrayRef<TemplateArgument>(TemplateArgs));
    //END JInit
  }


  
  /// \brief Note that we are instantiating a default argument in a
  /// template-id.
  
  /// \brief Note that we are instantiating a default argument in a
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 258,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_20FunctionTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS0_27ActiveTemplateInstantiation17InstantiationKindERNS_4sema21TemplateDeductionInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_20FunctionTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS0_27ActiveTemplateInstantiation17InstantiationKindERNS_4sema21TemplateDeductionInfoENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, 
      FunctionTemplateDecl /*P*/ FunctionTemplate, 
      ArrayRef<TemplateArgument> TemplateArgs, 
      ActiveTemplateInstantiation.InstantiationKind Kind, 
      final TemplateDeductionInfo /*&*/ DeductionInfo) {
    this(SemaRef, PointOfInstantiation, 
      FunctionTemplate, 
      TemplateArgs, 
      Kind, 
      DeductionInfo, new SourceRange());
  }
  public InstantiatingTemplate(final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, 
      FunctionTemplateDecl /*P*/ FunctionTemplate, 
      ArrayRef<TemplateArgument> TemplateArgs, 
      ActiveTemplateInstantiation.InstantiationKind Kind, 
      final TemplateDeductionInfo /*&*/ DeductionInfo, SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, Kind, PointOfInstantiation, InstantiationRange, FunctionTemplate, null, TemplateArgs, &DeductionInfo) 
    //START JInit
    this(SemaRef, Kind, new SourceLocation(PointOfInstantiation), 
        new SourceRange(InstantiationRange), FunctionTemplate, (NamedDecl /*P*/ )null, 
        new ArrayRef<TemplateArgument>(TemplateArgs), $AddrOf(DeductionInfo));
    //END JInit
  }


  
  /// \brief Note that we are instantiating as part of template
  /// argument deduction for a class template partial
  /// specialization.
  
  /// \brief Note that we are instantiating as part of template
  /// argument deduction for a class template partial
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 268,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_38ClassTemplatePartialSpecializationDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEERNS_4sema21TemplateDeductionInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_38ClassTemplatePartialSpecializationDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEERNS_4sema21TemplateDeductionInfoENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_ClassTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, 
      ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec, 
      ArrayRef<TemplateArgument> TemplateArgs, 
      final TemplateDeductionInfo /*&*/ DeductionInfo) {
    this(_dparam, SemaRef, PointOfInstantiation, 
      PartialSpec, 
      TemplateArgs, 
      DeductionInfo, new SourceRange());
  }
  public InstantiatingTemplate(JD$Sema_SourceLocation_ClassTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, 
      ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec, 
      ArrayRef<TemplateArgument> TemplateArgs, 
      final TemplateDeductionInfo /*&*/ DeductionInfo, SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::DeducedTemplateArgumentSubstitution, PointOfInstantiation, InstantiationRange, PartialSpec, null, TemplateArgs, &DeductionInfo) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.DeducedTemplateArgumentSubstitution, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), PartialSpec, (NamedDecl /*P*/ )null, 
        new ArrayRef<TemplateArgument>(TemplateArgs), $AddrOf(DeductionInfo));
    //END JInit
  }


  
  /// \brief Note that we are instantiating as part of template
  /// argument deduction for a variable template partial
  /// specialization.
  
  /// \brief Note that we are instantiating as part of template
  /// argument deduction for a variable template partial
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 279,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_36VarTemplatePartialSpecializationDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEERNS_4sema21TemplateDeductionInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_36VarTemplatePartialSpecializationDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEERNS_4sema21TemplateDeductionInfoENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_VarTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, 
      VarTemplatePartialSpecializationDecl /*P*/ PartialSpec, 
      ArrayRef<TemplateArgument> TemplateArgs, 
      final TemplateDeductionInfo /*&*/ DeductionInfo) {
    this(_dparam, SemaRef, PointOfInstantiation, 
      PartialSpec, 
      TemplateArgs, 
      DeductionInfo, new SourceRange());
  }
  public InstantiatingTemplate(JD$Sema_SourceLocation_VarTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, 
      VarTemplatePartialSpecializationDecl /*P*/ PartialSpec, 
      ArrayRef<TemplateArgument> TemplateArgs, 
      final TemplateDeductionInfo /*&*/ DeductionInfo, SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::DeducedTemplateArgumentSubstitution, PointOfInstantiation, InstantiationRange, PartialSpec, null, TemplateArgs, &DeductionInfo) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.DeducedTemplateArgumentSubstitution, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), PartialSpec, (NamedDecl /*P*/ )null, 
        new ArrayRef<TemplateArgument>(TemplateArgs), $AddrOf(DeductionInfo));
    //END JInit
  }


  
  /// \brief Note that we are instantiating a default argument for a function
  /// parameter.
  
  /// \brief Note that we are instantiating a default argument for a function
  /// parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 290,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_11ParmVarDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_11ParmVarDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_ParmVarDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, ParmVarDecl /*P*/ Param, 
      ArrayRef<TemplateArgument> TemplateArgs) {
    this(_dparam, SemaRef, PointOfInstantiation, Param, 
      TemplateArgs, new SourceRange());
  }
  public InstantiatingTemplate(JD$Sema_SourceLocation_ParmVarDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, ParmVarDecl /*P*/ Param, 
      ArrayRef<TemplateArgument> TemplateArgs, SourceRange InstantiationRange/*= SourceRange()*/) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::DefaultFunctionArgumentInstantiation, PointOfInstantiation, InstantiationRange, Param, null, TemplateArgs) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.DefaultFunctionArgumentInstantiation, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Param, (NamedDecl /*P*/ )null, 
        new ArrayRef<TemplateArgument>(TemplateArgs));
    //END JInit
  }


  
  /// \brief Note that we are substituting prior template arguments into a
  /// non-type parameter.
  
  /// \brief Note that we are substituting prior template arguments into a
  /// non-type parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 299,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_9NamedDeclEPNS_23NonTypeTemplateParmDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_9NamedDeclEPNS_23NonTypeTemplateParmDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_NamedDecl$P_NonTypeTemplateParmDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, NamedDecl /*P*/ Template, 
      NonTypeTemplateParmDecl /*P*/ Param, ArrayRef<TemplateArgument> TemplateArgs, 
      SourceRange InstantiationRange) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::PriorTemplateArgumentSubstitution, PointOfInstantiation, InstantiationRange, Param, Template, TemplateArgs) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.PriorTemplateArgumentSubstitution, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Param, Template, 
        new ArrayRef<TemplateArgument>(TemplateArgs));
    //END JInit
  }


  
  /// \brief Note that we are substituting prior template arguments into a
  /// template template parameter.
  
  /// \brief Note that we are substituting prior template arguments into a
  /// template template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 309,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_9NamedDeclEPNS_24TemplateTemplateParmDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_9NamedDeclEPNS_24TemplateTemplateParmDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_NamedDecl$P_TemplateTemplateParmDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, NamedDecl /*P*/ Template, 
      TemplateTemplateParmDecl /*P*/ Param, ArrayRef<TemplateArgument> TemplateArgs, 
      SourceRange InstantiationRange) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::PriorTemplateArgumentSubstitution, PointOfInstantiation, InstantiationRange, Param, Template, TemplateArgs) 
    //START JInit
    this(SemaRef, 
        ActiveTemplateInstantiation.InstantiationKind.PriorTemplateArgumentSubstitution, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Param, Template, 
        new ArrayRef<TemplateArgument>(TemplateArgs));
    //END JInit
  }


  
  /// \brief Note that we are checking the default template argument
  /// against the template parameter for a given template-id.
  
  /// \brief Note that we are checking the default template argument
  /// against the template parameter for a given template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 319,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_12TemplateDeclEPNS_9NamedDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS_14SourceLocationEPNS_12TemplateDeclEPNS_9NamedDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_11SourceRangeE")
  //</editor-fold>
  public InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_NamedDecl$P_ArrayRef$TemplateArgument_SourceRange _dparam, final Sema /*&*/ SemaRef, SourceLocation PointOfInstantiation, TemplateDecl /*P*/ Template, 
      NamedDecl /*P*/ Param, ArrayRef<TemplateArgument> TemplateArgs, 
      SourceRange InstantiationRange) {
    // : InstantiatingTemplate(SemaRef, ActiveTemplateInstantiation::DefaultTemplateArgumentChecking, PointOfInstantiation, InstantiationRange, Param, Template, TemplateArgs) 
    //START JInit
    this(SemaRef, ActiveTemplateInstantiation.InstantiationKind.DefaultTemplateArgumentChecking, 
        new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange), Param, Template, 
        new ArrayRef<TemplateArgument>(TemplateArgs));
    //END JInit
  }


  
  /// \brief Note that we have finished instantiating this template.
  
  /// \brief Note that we have finished instantiating this template.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::Clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 328,
   FQN="clang::Sema::InstantiatingTemplate::Clear", NM="_ZN5clang4Sema21InstantiatingTemplate5ClearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplate5ClearEv")
  //</editor-fold>
  public final void Clear() {
    if (!Invalid) {
      if (!SemaRef.ActiveTemplateInstantiations.back().isInstantiationRecord()) {
        assert ($greater_uint(SemaRef.NonInstantiationEntries, 0));
        --SemaRef.NonInstantiationEntries;
      }
      SemaRef.InNonInstantiationSFINAEContext
         = SavedInNonInstantiationSFINAEContext;
      
      // Name lookup no longer looks in this template's defining module.
      assert ($greatereq_uint(SemaRef.ActiveTemplateInstantiations.size(), SemaRef.ActiveTemplateInstantiationLookupModules.size())) : "forgot to remove a lookup module for a template instantiation";
      if (SemaRef.ActiveTemplateInstantiations.size()
         == SemaRef.ActiveTemplateInstantiationLookupModules.size()) {
        {
          Module /*P*/ M = SemaRef.ActiveTemplateInstantiationLookupModules.back();
          if ((M != null)) {
            SemaRef.LookupModulesCache.erase(M);
          }
        }
        SemaRef.ActiveTemplateInstantiationLookupModules.pop_back();
      }
      
      SemaRef.ActiveTemplateInstantiations.pop_back();
      Invalid = true;
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::~InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6906,
   FQN="clang::Sema::InstantiatingTemplate::~InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateD0Ev")
  //</editor-fold>
  public final void $destroy() {
    Clear();
  }

  
  /// \brief Determines whether we have exceeded the maximum
  /// recursive template instantiations.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6910,
   FQN="clang::Sema::InstantiatingTemplate::isInvalid", NM="_ZNK5clang4Sema21InstantiatingTemplate9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema21InstantiatingTemplate9isInvalidEv")
  //</editor-fold>
  public final boolean isInvalid() /*const*/ {
    return Invalid;
  }

/*private:*/
  protected/*private*/ final Sema /*&*/ SemaRef;
  protected/*private*/ boolean Invalid;
  protected/*private*/ boolean SavedInNonInstantiationSFINAEContext;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::CheckInstantiationDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 353,
   FQN="clang::Sema::InstantiatingTemplate::CheckInstantiationDepth", NM="_ZN5clang4Sema21InstantiatingTemplate23CheckInstantiationDepthENS_14SourceLocationENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplate23CheckInstantiationDepthENS_14SourceLocationENS_11SourceRangeE")
  //</editor-fold>
  protected/*private*/ final boolean CheckInstantiationDepth(SourceLocation PointOfInstantiation, 
                         SourceRange InstantiationRange) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($lesseq_uint(SemaRef.NonInstantiationEntries, SemaRef.ActiveTemplateInstantiations.size()));
      if ($lesseq_uint((SemaRef.ActiveTemplateInstantiations.size()
         - SemaRef.NonInstantiationEntries)
        , SemaRef.getLangOpts().InstantiationDepth)) {
        return false;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_uint($c$.track(SemaRef.Diag(new SourceLocation(PointOfInstantiation), 
                  diag.err_template_recursion_depth_exceeded)), 
              SemaRef.getLangOpts().InstantiationDepth), 
          InstantiationRange));
      $c$.clean($out_SemaDiagnosticBuilder_uint($c$.track(SemaRef.Diag(new SourceLocation(PointOfInstantiation), diag.note_template_recursion_depth)), 
          SemaRef.getLangOpts().InstantiationDepth));
      return true;
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 204,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS0_27ActiveTemplateInstantiation17InstantiationKindENS_14SourceLocationENS_11SourceRangeEPNS_4DeclEPNS_9NamedDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPNS_4sema21TemplateDeductionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERS0_NS0_27ActiveTemplateInstantiation17InstantiationKindENS_14SourceLocationENS_11SourceRangeEPNS_4DeclEPNS_9NamedDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPNS_4sema21TemplateDeductionInfoE")
  //</editor-fold>
  protected/*private*/ InstantiatingTemplate(final Sema /*&*/ SemaRef, ActiveTemplateInstantiation.InstantiationKind Kind, 
      SourceLocation PointOfInstantiation, SourceRange InstantiationRange, 
      Decl /*P*/ Entity) {
    this(SemaRef, Kind, 
      PointOfInstantiation, InstantiationRange, 
      Entity, (NamedDecl /*P*/ )null, new ArrayRef<TemplateArgument>(None, false), 
      (TemplateDeductionInfo /*P*/ )null);
  }
  protected/*private*/ InstantiatingTemplate(final Sema /*&*/ SemaRef, ActiveTemplateInstantiation.InstantiationKind Kind, 
      SourceLocation PointOfInstantiation, SourceRange InstantiationRange, 
      Decl /*P*/ Entity, NamedDecl /*P*/ Template/*= null*/) {
    this(SemaRef, Kind, 
      PointOfInstantiation, InstantiationRange, 
      Entity, Template, new ArrayRef<TemplateArgument>(None, false), 
      (TemplateDeductionInfo /*P*/ )null);
  }
  protected/*private*/ InstantiatingTemplate(final Sema /*&*/ SemaRef, ActiveTemplateInstantiation.InstantiationKind Kind, 
      SourceLocation PointOfInstantiation, SourceRange InstantiationRange, 
      Decl /*P*/ Entity, NamedDecl /*P*/ Template/*= null*/, ArrayRef<TemplateArgument> TemplateArgs/*= None*/) {
    this(SemaRef, Kind, 
      PointOfInstantiation, InstantiationRange, 
      Entity, Template, TemplateArgs, 
      (TemplateDeductionInfo /*P*/ )null);
  }
  protected/*private*/ InstantiatingTemplate(final Sema /*&*/ SemaRef, ActiveTemplateInstantiation.InstantiationKind Kind, 
      SourceLocation PointOfInstantiation, SourceRange InstantiationRange, 
      Decl /*P*/ Entity, NamedDecl /*P*/ Template/*= null*/, ArrayRef<TemplateArgument> TemplateArgs/*= None*/, 
      TemplateDeductionInfo /*P*/ DeductionInfo/*= null*/) {
    // : SemaRef(SemaRef), SavedInNonInstantiationSFINAEContext(SemaRef.InNonInstantiationSFINAEContext) 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.SavedInNonInstantiationSFINAEContext = SemaRef.InNonInstantiationSFINAEContext;
    //END JInit
    // Don't allow further instantiation if a fatal error has occcured.  Any
    // diagnostics we might have raised will not be visible.
    if (SemaRef.Diags.hasFatalErrorOccurred()) {
      Invalid = true;
      return;
    }
    Invalid = CheckInstantiationDepth(new SourceLocation(PointOfInstantiation), new SourceRange(InstantiationRange));
    if (!Invalid) {
      ActiveTemplateInstantiation Inst/*J*/= new ActiveTemplateInstantiation();
      Inst.Kind = Kind;
      Inst.PointOfInstantiation.$assign(PointOfInstantiation);
      Inst.Entity = Entity;
      Inst.Template = Template;
      Inst.TemplateArgs = TemplateArgs.data();
      Inst.NumTemplateArgs = TemplateArgs.size();
      Inst.DeductionInfo = DeductionInfo;
      Inst.InstantiationRange.$assign(InstantiationRange);
      SemaRef.InNonInstantiationSFINAEContext = false;
      SemaRef.ActiveTemplateInstantiations.push_back(Inst);
      if (!Inst.isInstantiationRecord()) {
        ++SemaRef.NonInstantiationEntries;
      }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::InstantiatingTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6926,
   FQN="clang::Sema::InstantiatingTemplate::InstantiatingTemplate", NM="_ZN5clang4Sema21InstantiatingTemplateC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateC1ERKS1_")
  //</editor-fold>
  protected/*private*/ InstantiatingTemplate(final /*const*/ InstantiatingTemplate /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiatingTemplate::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6928,
   FQN="clang::Sema::InstantiatingTemplate::operator=", NM="_ZN5clang4Sema21InstantiatingTemplateaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema21InstantiatingTemplateaSERKS1_")
  //</editor-fold>
  protected/*private*/ final InstantiatingTemplate /*&*/ $assign(final /*const*/ InstantiatingTemplate /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", Invalid=" + Invalid // NOI18N
              + ", SavedInNonInstantiationSFINAEContext=" + SavedInNonInstantiationSFINAEContext; // NOI18N
  }
}

/// \brief RAII class used to determine whether SFINAE has
/// trapped any errors that occur during template argument
/// deduction.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SFINAETrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6955,
 FQN="clang::Sema::SFINAETrap", NM="_ZN5clang4Sema10SFINAETrapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema10SFINAETrapE")
//</editor-fold>
public static class SFINAETrap implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ SemaRef;
  protected/*private*/ /*uint*/int PrevSFINAEErrors;
  protected/*private*/ boolean PrevInNonInstantiationSFINAEContext;
  protected/*private*/ boolean PrevAccessCheckingSFINAE;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SFINAETrap::SFINAETrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6962,
   FQN="clang::Sema::SFINAETrap::SFINAETrap", NM="_ZN5clang4Sema10SFINAETrapC1ERS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema10SFINAETrapC1ERS0_b")
  //</editor-fold>
  public /*explicit*/ SFINAETrap(final Sema /*&*/ SemaRef) {
    this(SemaRef, false);
  }
  public /*explicit*/ SFINAETrap(final Sema /*&*/ SemaRef, boolean AccessCheckingSFINAE/*= false*/) {
    // : SemaRef(SemaRef), PrevSFINAEErrors(SemaRef.NumSFINAEErrors), PrevInNonInstantiationSFINAEContext(SemaRef.InNonInstantiationSFINAEContext), PrevAccessCheckingSFINAE(SemaRef.AccessCheckingSFINAE) 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.PrevSFINAEErrors = SemaRef.NumSFINAEErrors;
    this.PrevInNonInstantiationSFINAEContext = SemaRef.InNonInstantiationSFINAEContext;
    this.PrevAccessCheckingSFINAE = SemaRef.AccessCheckingSFINAE;
    //END JInit
    if (!SemaRef.isSFINAEContext().$bool()) {
      SemaRef.InNonInstantiationSFINAEContext = true;
    }
    SemaRef.AccessCheckingSFINAE = AccessCheckingSFINAE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SFINAETrap::~SFINAETrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6973,
   FQN="clang::Sema::SFINAETrap::~SFINAETrap", NM="_ZN5clang4Sema10SFINAETrapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema10SFINAETrapD0Ev")
  //</editor-fold>
  public final void $destroy() {
    SemaRef.NumSFINAEErrors = PrevSFINAEErrors;
    SemaRef.InNonInstantiationSFINAEContext
       = PrevInNonInstantiationSFINAEContext;
    SemaRef.AccessCheckingSFINAE = PrevAccessCheckingSFINAE;
  }

  
  /// \brief Determine whether any SFINAE errors have been trapped.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SFINAETrap::hasErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6981,
   FQN="clang::Sema::SFINAETrap::hasErrorOccurred", NM="_ZNK5clang4Sema10SFINAETrap16hasErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang4Sema10SFINAETrap16hasErrorOccurredEv")
  //</editor-fold>
  public final boolean hasErrorOccurred() /*const*/ {
    return $greater_uint(SemaRef.NumSFINAEErrors, PrevSFINAEErrors);
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", PrevSFINAEErrors=" + PrevSFINAEErrors // NOI18N
              + ", PrevInNonInstantiationSFINAEContext=" + PrevInNonInstantiationSFINAEContext // NOI18N
              + ", PrevAccessCheckingSFINAE=" + PrevAccessCheckingSFINAE; // NOI18N
  }
}

/// \brief RAII class used to indicate that we are performing provisional
/// semantic analysis to determine the validity of a construct, so
/// typo-correction and diagnostics in the immediate context (not within
/// implicitly-instantiated templates) should be suppressed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TentativeAnalysisScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6990,
 FQN="clang::Sema::TentativeAnalysisScope", NM="_ZN5clang4Sema22TentativeAnalysisScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema22TentativeAnalysisScopeE")
//</editor-fold>
public static class TentativeAnalysisScope implements Destructors.ClassWithDestructor {
  protected/*private*/ final Sema /*&*/ SemaRef;
  // FIXME: Using a SFINAETrap for this is a hack.
  protected/*private*/ SFINAETrap Trap;
  protected/*private*/ boolean PrevDisableTypoCorrection;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TentativeAnalysisScope::TentativeAnalysisScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6996,
   FQN="clang::Sema::TentativeAnalysisScope::TentativeAnalysisScope", NM="_ZN5clang4Sema22TentativeAnalysisScopeC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema22TentativeAnalysisScopeC1ERS0_")
  //</editor-fold>
  public /*explicit*/ TentativeAnalysisScope(final Sema /*&*/ SemaRef) {
    // : SemaRef(SemaRef), Trap(SemaRef, true), PrevDisableTypoCorrection(SemaRef.DisableTypoCorrection) 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.Trap = new SFINAETrap(SemaRef, true);
    this.PrevDisableTypoCorrection = SemaRef.DisableTypoCorrection;
    //END JInit
    SemaRef.DisableTypoCorrection = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TentativeAnalysisScope::~TentativeAnalysisScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7001,
   FQN="clang::Sema::TentativeAnalysisScope::~TentativeAnalysisScope", NM="_ZN5clang4Sema22TentativeAnalysisScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema22TentativeAnalysisScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    SemaRef.DisableTypoCorrection = PrevDisableTypoCorrection;
    //START JDestroy
    Trap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", Trap=" + Trap // NOI18N
              + ", PrevDisableTypoCorrection=" + PrevDisableTypoCorrection; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SavePendingInstantiationsAndVTableUsesRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7043,
 FQN="clang::Sema::SavePendingInstantiationsAndVTableUsesRAII", NM="_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIIE")
//</editor-fold>
public static class SavePendingInstantiationsAndVTableUsesRAII implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SavePendingInstantiationsAndVTableUsesRAII::SavePendingInstantiationsAndVTableUsesRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7045,
   FQN="clang::Sema::SavePendingInstantiationsAndVTableUsesRAII::SavePendingInstantiationsAndVTableUsesRAII", NM="_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIIC1ERS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIIC1ERS0_b")
  //</editor-fold>
  public SavePendingInstantiationsAndVTableUsesRAII(final Sema /*&*/ S, boolean Enabled) {
    // : S(S), SavedVTableUses(), SavedPendingInstantiations(), Enabled(Enabled) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.SavedVTableUses = new SmallVector<std.pair<CXXRecordDecl /*P*/ , SourceLocation>>(16, new std.pairPtrType<CXXRecordDecl /*P*/ , SourceLocation>(null, new SourceLocation()));
    this.SavedPendingInstantiations = new std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> >(false);
    this.Enabled = Enabled;
    //END JInit
    if (!Enabled) {
      return;
    }
    
    SavedPendingInstantiations.swap(S.PendingInstantiations);
    SavedVTableUses.swap(S.VTableUses);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SavePendingInstantiationsAndVTableUsesRAII::~SavePendingInstantiationsAndVTableUsesRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7053,
   FQN="clang::Sema::SavePendingInstantiationsAndVTableUsesRAII::~SavePendingInstantiationsAndVTableUsesRAII", NM="_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema42SavePendingInstantiationsAndVTableUsesRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    if (!Enabled) {
      return;
    }
    
    // Restore the set of pending vtables.
    assert (S.VTableUses.empty()) : "VTableUses should be empty before it is discarded.";
    S.VTableUses.swap(SavedVTableUses);
    
    // Restore the set of pending implicit instantiations.
    assert (S.PendingInstantiations.empty()) : "PendingInstantiations should be empty before it is discarded.";
    S.PendingInstantiations.swap(SavedPendingInstantiations);
    //START JDestroy
    SavedPendingInstantiations.$destroy();
    SavedVTableUses.$destroy();
    //END JDestroy
  }

/*private:*/
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ SmallVector<std.pair<CXXRecordDecl /*P*/ , SourceLocation>> SavedVTableUses;
  protected/*private*/ std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> > SavedPendingInstantiations;
  protected/*private*/ boolean Enabled;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SavedVTableUses=" + SavedVTableUses // NOI18N
              + ", SavedPendingInstantiations=" + SavedPendingInstantiations // NOI18N
              + ", Enabled=" + Enabled; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SavePendingLocalImplicitInstantiationsRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7083,
 FQN="clang::Sema::SavePendingLocalImplicitInstantiationsRAII", NM="_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIIE")
//</editor-fold>
public static class SavePendingLocalImplicitInstantiationsRAII implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SavePendingLocalImplicitInstantiationsRAII::SavePendingLocalImplicitInstantiationsRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7085,
   FQN="clang::Sema::SavePendingLocalImplicitInstantiationsRAII::SavePendingLocalImplicitInstantiationsRAII", NM="_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIIC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIIC1ERS0_")
  //</editor-fold>
  public SavePendingLocalImplicitInstantiationsRAII(final Sema /*&*/ S) {
    // : S(S), SavedPendingLocalImplicitInstantiations() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.SavedPendingLocalImplicitInstantiations = new std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> >(false);
    //END JInit
    SavedPendingLocalImplicitInstantiations.swap(S.PendingLocalImplicitInstantiations);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SavePendingLocalImplicitInstantiationsRAII::~SavePendingLocalImplicitInstantiationsRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7090,
   FQN="clang::Sema::SavePendingLocalImplicitInstantiationsRAII::~SavePendingLocalImplicitInstantiationsRAII", NM="_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema42SavePendingLocalImplicitInstantiationsRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    assert (S.PendingLocalImplicitInstantiations.empty()) : "there shouldn't be any pending local implicit instantiations";
    SavedPendingLocalImplicitInstantiations.swap(S.PendingLocalImplicitInstantiations);
    //START JDestroy
    SavedPendingLocalImplicitInstantiations.$destroy();
    //END JDestroy
  }

/*private:*/
  protected/*private*/ final Sema /*&*/ S;
  protected/*private*/ std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> > SavedPendingLocalImplicitInstantiations;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SavedPendingLocalImplicitInstantiations=" + SavedPendingLocalImplicitInstantiations; // NOI18N
  }
}

/// A helper class for building up ExtParameterInfos.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ExtParameterInfoBuilder">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7104,
 FQN="clang::Sema::ExtParameterInfoBuilder", NM="_ZN5clang4Sema23ExtParameterInfoBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23ExtParameterInfoBuilderE")
//</editor-fold>
public static class ExtParameterInfoBuilder implements Destructors.ClassWithDestructor {
  protected/*private*/ SmallVector<FunctionProtoType.ExtParameterInfo> Infos;
  protected/*private*/ boolean HasInteresting/* = false*/;
/*public:*/
  /// Set the ExtParameterInfo for the parameter at the given index,
  /// 
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExtParameterInfoBuilder::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7111,
   FQN="clang::Sema::ExtParameterInfoBuilder::set", NM="_ZN5clang4Sema23ExtParameterInfoBuilder3setEjNS_17FunctionProtoType16ExtParameterInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23ExtParameterInfoBuilder3setEjNS_17FunctionProtoType16ExtParameterInfoE")
  //</editor-fold>
  public final void set(/*uint*/int index, FunctionProtoType.ExtParameterInfo info) {
    assert ($lesseq_uint(Infos.size(), index));
    Infos.resize(index);
    Infos.push_back(info);
    if (!HasInteresting) {
      HasInteresting = (FunctionProtoType.ExtParameterInfo.$noteq_ExtParameterInfo(/*NO_COPY*/info, new FunctionProtoType.ExtParameterInfo()));
    }
  }

  
  /// Return a pointer (suitable for setting in an ExtProtoInfo) to the
  /// ExtParameterInfo array we've built up.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExtParameterInfoBuilder::getPointerOrNull">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7122,
   FQN="clang::Sema::ExtParameterInfoBuilder::getPointerOrNull", NM="_ZN5clang4Sema23ExtParameterInfoBuilder16getPointerOrNullEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema23ExtParameterInfoBuilder16getPointerOrNullEj")
  //</editor-fold>
  public final /*const*/ type$ptr<FunctionProtoType.ExtParameterInfo> /*P*/ getPointerOrNull(/*uint*/int numParams) {
    if (!HasInteresting) {
      return null;
    }
    Infos.resize(numParams);
    return Infos.data();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExtParameterInfoBuilder::ExtParameterInfoBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7104,
   FQN="clang::Sema::ExtParameterInfoBuilder::ExtParameterInfoBuilder", NM="_ZN5clang4Sema23ExtParameterInfoBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23ExtParameterInfoBuilderC1Ev")
  //</editor-fold>
  public /*inline*/ ExtParameterInfoBuilder() {
    // : Infos(), HasInteresting(false) 
    //START JInit
    this.Infos = new SmallVector<FunctionProtoType.ExtParameterInfo>(16, new FunctionProtoType.ExtParameterInfo());
    /*InClass*/this.HasInteresting = false;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ExtParameterInfoBuilder::~ExtParameterInfoBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7104,
   FQN="clang::Sema::ExtParameterInfoBuilder::~ExtParameterInfoBuilder", NM="_ZN5clang4Sema23ExtParameterInfoBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23ExtParameterInfoBuilderD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    Infos.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Infos=" + Infos // NOI18N
              + ", HasInteresting=" + HasInteresting; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LateInstantiatedAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7214,
 FQN="clang::Sema::LateInstantiatedAttribute", NM="_ZN5clang4Sema25LateInstantiatedAttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema25LateInstantiatedAttributeE")
//</editor-fold>
public static class/*struct*/ LateInstantiatedAttribute implements Native.NativePOD<LateInstantiatedAttribute> {
  public /*const*/ Attr /*P*/ TmplAttr;
  public LocalInstantiationScope /*P*/ Scope;
  public Decl /*P*/ NewDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::LateInstantiatedAttribute::LateInstantiatedAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7219,
   FQN="clang::Sema::LateInstantiatedAttribute::LateInstantiatedAttribute", NM="_ZN5clang4Sema25LateInstantiatedAttributeC1EPKNS_4AttrEPNS_23LocalInstantiationScopeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema25LateInstantiatedAttributeC1EPKNS_4AttrEPNS_23LocalInstantiationScopeEPNS_4DeclE")
  //</editor-fold>
  public LateInstantiatedAttribute(/*const*/ Attr /*P*/ A, LocalInstantiationScope /*P*/ S, 
      Decl /*P*/ D) {
    // : TmplAttr(A), Scope(S), NewDecl(D) 
    //START JInit
    this.TmplAttr = A;
    this.Scope = S;
    this.NewDecl = D;
    //END JInit
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public LateInstantiatedAttribute() {}
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public LateInstantiatedAttribute(LateInstantiatedAttribute Other) {
    this.TmplAttr = Other.TmplAttr;
    this.Scope = Other.Scope;
    this.NewDecl = Other.NewDecl;
  }
  
  @Override
  public LateInstantiatedAttribute $assign(LateInstantiatedAttribute Other) {
    this.TmplAttr = Other.TmplAttr;
    this.Scope = Other.Scope;
    this.NewDecl = Other.NewDecl;
    return this;
  }
  
  @Override
  public LateInstantiatedAttribute clone() {
    return new LateInstantiatedAttribute(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::LateInstantiatedAttribute::~LateInstantiatedAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7214,
   FQN="clang::Sema::LateInstantiatedAttribute::~LateInstantiatedAttribute", NM="_ZN5clang4Sema25LateInstantiatedAttributeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema25LateInstantiatedAttributeD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
  }

  
  @Override public String toString() {
    return "" + "TmplAttr=" + TmplAttr // NOI18N
              + ", Scope=" + Scope // NOI18N
              + ", NewDecl=" + NewDecl; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCArgInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7534,
 FQN="clang::Sema::ObjCArgInfo", NM="_ZN5clang4Sema11ObjCArgInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11ObjCArgInfoE")
//</editor-fold>
public static class/*struct*/ ObjCArgInfo {
  public IdentifierInfo /*P*/ Name;
  public SourceLocation NameLoc;
  // The Type is null if no type was specified, and the DeclSpec is invalid
  // in this case.
  public OpaquePtr<QualType> Type;
  public ObjCDeclSpec DeclSpec;
  
  /// ArgAttrs - Attribute list for this argument.
  public AttributeList /*P*/ ArgAttrs;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ObjCArgInfo::ObjCArgInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7534,
   FQN="clang::Sema::ObjCArgInfo::ObjCArgInfo", NM="_ZN5clang4Sema11ObjCArgInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang4Sema11ObjCArgInfoC1Ev")
  //</editor-fold>
  public /*inline*/ ObjCArgInfo() {
    // : NameLoc(), Type(), DeclSpec() 
    //START JInit
    this.NameLoc = new SourceLocation();
    this.Type = new OpaquePtr<QualType>();
    this.DeclSpec = new ObjCDeclSpec();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", NameLoc=" + NameLoc // NOI18N
              + ", Type=" + Type // NOI18N
              + ", DeclSpec=" + DeclSpec // NOI18N
              + ", ArgAttrs=" + ArgAttrs; // NOI18N
  }
}

/// \brief Abstract base class used for diagnosing integer constant
/// expression violations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyICEDiagnoser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9065,
 FQN="clang::Sema::VerifyICEDiagnoser", NM="_ZN5clang4Sema18VerifyICEDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18VerifyICEDiagnoserE")
//</editor-fold>
public abstract static class VerifyICEDiagnoser implements Destructors.ClassWithDestructor {
/*public:*/
  public boolean Suppress;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyICEDiagnoser::VerifyICEDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9069,
   FQN="clang::Sema::VerifyICEDiagnoser::VerifyICEDiagnoser", NM="_ZN5clang4Sema18VerifyICEDiagnoserC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18VerifyICEDiagnoserC1Eb")
  //</editor-fold>
  public VerifyICEDiagnoser() {
    this(false);
  }
  public VerifyICEDiagnoser(boolean Suppress/*= false*/) {
    // : Suppress(Suppress) 
    //START JInit
    this.Suppress = Suppress;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyICEDiagnoser::diagnoseNotICE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9071,
   FQN="clang::Sema::VerifyICEDiagnoser::diagnoseNotICE", NM="_ZN5clang4Sema18VerifyICEDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18VerifyICEDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE")
  //</editor-fold>
  public abstract /*virtual*/ void diagnoseNotICE(final Sema /*&*/ S, SourceLocation Loc, SourceRange SR)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyICEDiagnoser::diagnoseFold">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12629,
   FQN="clang::Sema::VerifyICEDiagnoser::diagnoseFold", NM="_ZN5clang4Sema18VerifyICEDiagnoser12diagnoseFoldERS0_NS_14SourceLocationENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18VerifyICEDiagnoser12diagnoseFoldERS0_NS_14SourceLocationENS_11SourceRangeE")
  //</editor-fold>
  public void diagnoseFold(final Sema /*&*/ S, SourceLocation Loc, 
              SourceRange SR) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_expr_not_ice)), SR), S.LangOpts.CPlusPlus));
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyICEDiagnoser::~VerifyICEDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9073,
   FQN="clang::Sema::VerifyICEDiagnoser::~VerifyICEDiagnoser", NM="_ZN5clang4Sema18VerifyICEDiagnoserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema18VerifyICEDiagnoserD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  @Override public String toString() {
    return "" + "Suppress=" + Suppress; // NOI18N
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteExpressionData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3486,
 FQN="clang::Sema::CodeCompleteExpressionData", NM="_ZN5clang4Sema26CodeCompleteExpressionDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteExpressionDataE")
//</editor-fold>
public static class/*struct*/ CodeCompleteExpressionData implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteExpressionData::CodeCompleteExpressionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3487,
   FQN="clang::Sema::CodeCompleteExpressionData::CodeCompleteExpressionData", NM="_ZN5clang4Sema26CodeCompleteExpressionDataC1ENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteExpressionDataC1ENS_8QualTypeE")
  //</editor-fold>
  public CodeCompleteExpressionData() {
    this(new QualType());
  }
  public CodeCompleteExpressionData(QualType PreferredType/*= QualType()*/) {
    // : PreferredType(PreferredType), IntegralConstantExpression(false), ObjCCollection(false), IgnoreDecls() 
    //START JInit
    this.PreferredType = new QualType(PreferredType);
    this.IntegralConstantExpression = false;
    this.ObjCCollection = false;
    this.IgnoreDecls = new SmallVector<Decl /*P*/>(4, null);
    //END JInit
  }

  
  public QualType PreferredType;
  public boolean IntegralConstantExpression;
  public boolean ObjCCollection;
  public SmallVector<Decl /*P*/> IgnoreDecls;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteExpressionData::~CodeCompleteExpressionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3486,
   FQN="clang::Sema::CodeCompleteExpressionData::~CodeCompleteExpressionData", NM="_ZN5clang4Sema26CodeCompleteExpressionDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteExpressionDataD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    IgnoreDecls.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "PreferredType=" + PreferredType // NOI18N
              + ", IntegralConstantExpression=" + IntegralConstantExpression // NOI18N
              + ", ObjCCollection=" + ObjCCollection // NOI18N
              + ", IgnoreDecls=" + IgnoreDecls; // NOI18N
  }
}
// Used to grab the relevant information from a FormatAttr and a
// FunctionDeclaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FormatStringInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9340,
 FQN="clang::Sema::FormatStringInfo", NM="_ZN5clang4Sema16FormatStringInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema16FormatStringInfoE")
//</editor-fold>
protected/*private*/ static class/*struct*/ FormatStringInfo {
  public /*uint*/int FormatIdx;
  public /*uint*/int FirstDataArg;
  public boolean HasVAListArg;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FormatStringInfo::FormatStringInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9340,
   FQN="clang::Sema::FormatStringInfo::FormatStringInfo", NM="_ZN5clang4Sema16FormatStringInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema16FormatStringInfoC1Ev")
  //</editor-fold>
  public /*inline*/ FormatStringInfo() {
  }

  
  @Override public String toString() {
    return "" + "FormatIdx=" + FormatIdx // NOI18N
              + ", FirstDataArg=" + FirstDataArg // NOI18N
              + ", HasVAListArg=" + HasVAListArg; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9495,
 FQN="clang::Sema::TypeTagData", NM="_ZN5clang4Sema11TypeTagDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11TypeTagDataE")
//</editor-fold>
public static class/*struct*/ TypeTagData implements NativePOD<TypeTagData> {
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::TypeTagData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9496,
   FQN="clang::Sema::TypeTagData::TypeTagData", NM="_ZN5clang4Sema11TypeTagDataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11TypeTagDataC1Ev")
  //</editor-fold>
  public TypeTagData() {
    // : Type() 
    //START JInit
    this.Type = new QualType();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::TypeTagData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9498,
   FQN="clang::Sema::TypeTagData::TypeTagData", NM="_ZN5clang4Sema11TypeTagDataC1ENS_8QualTypeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11TypeTagDataC1ENS_8QualTypeEbb")
  //</editor-fold>
  public TypeTagData(QualType Type, boolean LayoutCompatible, boolean MustBeNull) {
    // : Type(Type), LayoutCompatible(LayoutCompatible), MustBeNull(MustBeNull) 
    //START JInit
    this.Type = new QualType(Type);
    this.LayoutCompatible = LayoutCompatible;
    this.MustBeNull = MustBeNull;
    //END JInit
  }

  
  public QualType Type;
  
  /// If true, \c Type should be compared with other expression's types for
  /// layout-compatibility.
  public /*JBIT unsigned int*/ boolean LayoutCompatible /*: 1*/;
  public /*JBIT unsigned int*/ boolean MustBeNull /*: 1*/;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::TypeTagData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9495,
   FQN="clang::Sema::TypeTagData::TypeTagData", NM="_ZN5clang4Sema11TypeTagDataC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema11TypeTagDataC1ERKS1_")
  //</editor-fold>
  public /*inline*/ TypeTagData(final /*const*/ TypeTagData /*&*/ $Prm0) {
    // : Type(.Type), LayoutCompatible(.LayoutCompatible), MustBeNull(.MustBeNull) 
    //START JInit
    this.Type = new QualType($Prm0.Type);
    this.LayoutCompatible = $Prm0.LayoutCompatible;
    this.MustBeNull = $Prm0.MustBeNull;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::TypeTagData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9495,
   FQN="clang::Sema::TypeTagData::TypeTagData", NM="_ZN5clang4Sema11TypeTagDataC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema11TypeTagDataC1EOS1_")
  //</editor-fold>
  public /*inline*/ TypeTagData(JD$Move _dparam, final TypeTagData /*&&*/$Prm0) {
    // : Type(static_cast<TypeTagData &&>().Type), LayoutCompatible(static_cast<TypeTagData &&>().LayoutCompatible), MustBeNull(static_cast<TypeTagData &&>().MustBeNull) 
    //START JInit
    this.Type = new QualType(JD$Move.INSTANCE, $Prm0.Type);
    this.LayoutCompatible = $Prm0.LayoutCompatible;
    this.MustBeNull = $Prm0.MustBeNull;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::~TypeTagData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9495,
   FQN="clang::Sema::TypeTagData::~TypeTagData", NM="_ZN5clang4Sema11TypeTagDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema11TypeTagDataD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9495,
   FQN="clang::Sema::TypeTagData::operator=", NM="_ZN5clang4Sema11TypeTagDataaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema11TypeTagDataaSERKS1_")
  //</editor-fold>
  public final /*inline*/ TypeTagData /*&*/ $assign(final /*const*/ TypeTagData /*&*/ $Prm0) {
    this.Type.$assign($Prm0.Type);
    this.LayoutCompatible = $Prm0.LayoutCompatible;
    this.MustBeNull = $Prm0.MustBeNull;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TypeTagData::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9495,
   FQN="clang::Sema::TypeTagData::operator=", NM="_ZN5clang4Sema11TypeTagDataaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema11TypeTagDataaSEOS1_")
  //</editor-fold>
  public final /*inline*/ TypeTagData /*&*/ $assignMove(final TypeTagData /*&&*/$Prm0) {
    this.Type.$assignMove($Prm0.Type);
    this.LayoutCompatible = $Prm0.LayoutCompatible;
    this.MustBeNull = $Prm0.MustBeNull;
    return /*Deref*/this;
  }

  @Override public TypeTagData clone() {
    return new TypeTagData(this);
  }
  
  @Override public String toString() {
    return "" + "Type=" + Type // NOI18N
              + ", LayoutCompatible=" + LayoutCompatible // NOI18N
              + ", MustBeNull=" + MustBeNull; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="clang::Sema::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2945,
 FQN="clang::Sema::(anonymous)", NM="_ZN5clang4SemaE_Unnamed_class42",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4SemaE_Unnamed_class42")
//</editor-fold>
public static class Unnamed_class42 {
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::(anonymous class)::operator()">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2945,
   FQN="clang::Sema::(anonymous class)::operator()", NM="_ZZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEPNS_7VarDeclEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEEEd_NKUlS2_E_clES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEPNS_7VarDeclEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEEEd_NKUlS2_E_clES2_")
  //</editor-fold>
  public /*inline*/ ActionResultTTrue<Expr /*P*/ > $call(Expr /*P*/ E) /*const*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2956,
 FQN="clang::Sema::(anonymous)", NM="_ZN5clang4SemaE_Unnamed_class43",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4SemaE_Unnamed_class43")
//</editor-fold>
public static class Unnamed_class43 {
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::(anonymous class)::operator()">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2956,
   FQN="clang::Sema::(anonymous class)::operator()", NM="_ZZN5clang4Sema25CorrectDelayedTyposInExprENS_12ActionResultIPNS_4ExprELb1EEEPNS_7VarDeclEN4llvm12function_refIFS4_S3_EEEEd_NKUlS3_E_clES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZZN5clang4Sema25CorrectDelayedTyposInExprENS_12ActionResultIPNS_4ExprELb1EEEPNS_7VarDeclEN4llvm12function_refIFS4_S3_EEEEd_NKUlS3_E_clES3_")
  //</editor-fold>
  public /*inline*/ ActionResultTTrue<Expr /*P*/ > $call(Expr /*P*/ E) /*const*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}

//////////////////////////////////////////////////////////////////////////////
/*template <typename ValueType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 343,
 FQN="clang::Sema::PragmaStack", NM="_ZN5clang4Sema11PragmaStackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStackE")
//</editor-fold>
public static class/*struct*/ PragmaStackUInt  {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  void $destroy() {
    this.Stack.$destroy();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::Slot">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 345,
   FQN="clang::Sema::PragmaStack::Slot", NM="_ZN5clang4Sema11PragmaStack4SlotE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStack4SlotE")
  //</editor-fold>
  public static class/*struct*/ SlotUInt {
    public StringRef StackSlotLabel;
    public /*uint*/int Value;
    public SourceLocation PragmaLocation;
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::Slot::Slot">
    @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 349,
     FQN="clang::Sema::PragmaStack::Slot::Slot", NM="_ZN5clang4Sema11PragmaStack4SlotC1EN4llvm9StringRefET_NS_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStack4SlotC1EN4llvm9StringRefET_NS_14SourceLocationE")
    //</editor-fold>
    public SlotUInt(StringRef StackSlotLabel, 
        /*uint*/int Value, 
        SourceLocation PragmaLocation) {
      // : StackSlotLabel(StackSlotLabel), Value(Value), PragmaLocation(PragmaLocation) 
      //START JInit
      this.StackSlotLabel = new StringRef(StackSlotLabel);
      this.Value = /*ParenListExpr*//*new ValueType(Default)*/ Value;
      this.PragmaLocation = new SourceLocation(PragmaLocation);
      //END JInit
    }


    @Override public String toString() {
      return "" + "StackSlotLabel=" + StackSlotLabel // NOI18N
                + ", Value=" + Value // NOI18N
                + ", PragmaLocation=" + PragmaLocation; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::Act">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 211,
   FQN="clang::Sema::PragmaStack::Act", NM="_ZN5clang4Sema11PragmaStack3ActENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema11PragmaStack3ActENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefET_")
  //</editor-fold>
  public void Act(SourceLocation PragmaLocation, 
     /*PragmaMsStackAction*//*uint*/int Action, 
     StringRef StackSlotLabel, 
     /*uint*/int Value) {
    
    if (Action == PragmaMsStackAction.PSK_Reset) {
      CurrentValue = DefaultValue;
      return;
    }
    if (((Action & PragmaMsStackAction.PSK_Push) != 0)) {
        Stack.push_back(new SlotUInt(StackSlotLabel, CurrentValue, CurrentPragmaLocation));
    } else if (((Action & PragmaMsStackAction.PSK_Pop) != 0)) {
      if (!StackSlotLabel.empty()) {
        // If we've got a label, try to find it and jump there.
          /*<dependent type>*/
          std.reverse_iterator<SlotUInt> I = (std.reverse_iterator<SlotUInt>)llvm.find_if(llvm.reverse(Stack), /*[&]*/ (final /*const*/ SlotUInt /*&*/ x) -> {
                  return Native.$eq(x.StackSlotLabel, StackSlotLabel);
                });
        // If we found the label so pop from there.
        if (Native.$noteq_iter(I, Stack.rend())) {
            CurrentValue = I.$star().Value;
            CurrentPragmaLocation = I.$star().PragmaLocation;
            // FIXME the cast type$ptr<Slot<ValueType>> below shoudl be removed. SmallVector.erase(type$iterator...) should be used instead
            Stack.erase(std.prev((type$ptr<SlotUInt>)I.base()), Stack.end());
        }
      } else if (Native.$not(Stack.empty())) {
        // We don't have a label, just pop the last entry.
        CurrentValue = Stack.back().Value;
        CurrentPragmaLocation = Stack.back().PragmaLocation;
        Stack.pop_back();
      }
    }
    if (((Action & PragmaMsStackAction.PSK_Set) != 0)) {
      CurrentValue = Value;
      CurrentPragmaLocation = PragmaLocation;
    }    
  }



  // MSVC seems to add artificial slots to #pragma stacks on entering a C++
  // method body to restore the stacks on exit, so it works like this:
  //
  //   struct S {
  //     #pragma <name>(push, InternalPragmaSlot, <current_pragma_value>)
  //     void Method {}
  //     #pragma <name>(pop, InternalPragmaSlot)
  //   };
  //
  // It works even with #pragma vtordisp, although MSVC doesn't support
  //   #pragma vtordisp(push [, id], n)
  // syntax.
  //
  // Push / pop a named sentinel slot.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::SentinelAction">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 374,
   FQN="clang::Sema::PragmaStack::SentinelAction", NM="_ZN5clang4Sema11PragmaStack14SentinelActionENS0_19PragmaMsStackActionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStack14SentinelActionENS0_19PragmaMsStackActionEN4llvm9StringRefE")
  //</editor-fold>
  public void SentinelAction(/*PragmaMsStackAction*//*uint*/int Action, StringRef Label) {
    assert ((Action == PragmaMsStackAction.PSK_Push || Action == PragmaMsStackAction.PSK_Pop)) : "Can only push / pop #pragma stack sentinels!";
    Act(CurrentPragmaLocation, Action, Label, CurrentValue);
  }


  // Constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PragmaStack::PragmaStack<ValueType>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 381,
   FQN="clang::Sema::PragmaStack::PragmaStack<ValueType>", NM="_ZN5clang4Sema11PragmaStackC1ERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang4Sema11PragmaStackC1ERKT_")
  //</editor-fold>
  public /*explicit*/ PragmaStackUInt(final /*const*/ /*uint*/int /*&*/ Default) {
    // : DefaultValue(Default), CurrentValue(Default) 
    //START JInit
    this.DefaultValue = /*ParenListExpr*//*new ValueType*/ $tryClone(Default);
    this.CurrentValue = /*ParenListExpr*//*new ValueType(Default)*/ $tryClone(Default);
    //END JInit
    this.Stack = new SmallVector<SlotUInt>(2);
    this.CurrentPragmaLocation = new SourceLocation();    
  }


  public SmallVector<SlotUInt> Stack;
  public /*uint*/int DefaultValue; // Value used for PSK_Reset action.
  public /*uint*/int CurrentValue;
  public SourceLocation CurrentPragmaLocation;

  @Override public String toString() {
    return "" + "Stack=" + Stack // NOI18N
              + ", DefaultValue=" + DefaultValue // NOI18N
              + ", CurrentValue=" + CurrentValue // NOI18N
              + ", CurrentPragmaLocation=" + CurrentPragmaLocation; // NOI18N
  }
}
} // END OF class Sema_NestedClasses
