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
package org.clang.basic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;



//<editor-fold defaultstate="collapsed" desc="static type DiagnosticStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=Tpl__ZL10ModifierIsPKcjRAT__S_;_ZL10ScanFormatPKcS0_c;_ZL12PluralNumberRPKcS0_;_ZL14EvalPluralExprjPKcS0_;_ZL15TestPluralRangejRPKcS0_;_ZL18DummyArgToStringFnN5clang17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE;_ZL20HandlePluralModifierRKN5clang10DiagnosticEjPKcjRN4llvm15SmallVectorImplIcEE;_ZL20HandleSelectModifierRKN5clang10DiagnosticEjPKcjRN4llvm15SmallVectorImplIcEE;_ZL21HandleOrdinalModifierjRN4llvm15SmallVectorImplIcEE;_ZL22HandleIntegerSModifierjRN4llvm15SmallVectorImplIcEE;_ZL25getTokenDescForDiagnosticN5clang3tok9TokenKindE; -static-type=DiagnosticStatics -package=org.clang.basic.impl ")
//</editor-fold>
public final class DiagnosticStatics {

//<editor-fold defaultstate="collapsed" desc="DummyArgToStringFn">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 48,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 27,
 FQN="DummyArgToStringFn", NM="_ZL18DummyArgToStringFnN5clang17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL18DummyArgToStringFnN5clang17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE")
//</editor-fold>
public static void DummyArgToStringFn(DiagnosticsEngine.ArgumentKind AK, Object/*intptr_t*/ QT, 
                  StringRef Modifier, StringRef Argument, 
                  ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/> > PrevArgs, 
                  SmallString/*&*/ Output, 
                  Object/*void P*/ Cookie, 
                  ArrayRef<Object/*intptr_t*/> QualTypeVals) {
  StringRef Str = new StringRef(/*KEEP_STR*/"<can't format argument>");
  Output.append(Str.begin(), Str.size()/*MANUAL_SEMANTIC:use size()*/);
}


/// ModifierIs - Return true if the specified modifier matches specified string.
/*template <std::size_t StrLen> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="ModifierIs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 412,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 410,
 FQN="ModifierIs", NM="Tpl__ZL10ModifierIsPKcjRAT__S_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=Tpl__ZL10ModifierIsPKcjRAT__S_")
//</editor-fold>
public static boolean ModifierIs(/*const*/char$ptr/*char P*/ Modifier, /*uint*/int ModifierLen, 
          String Str) {
  /*size_t*/int StrLen = Str.length() + 1/*\0*/;
  return StrLen - 1 == ModifierLen && !(memcmp(Modifier, Str, StrLen - 1) != 0);
}


/// ScanForward - Scans forward, looking for the given character, skipping
/// nested clauses and escaped characters.
//<editor-fold defaultstate="collapsed" desc="ScanFormat">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 419,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 418,
 FQN="ScanFormat", NM="_ZL10ScanFormatPKcS0_c",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL10ScanFormatPKcS0_c")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ScanFormat(/*const*/char$ptr/*char P*/ I, /*const*/char$ptr/*char P*/ E, /*char*/byte Target) {
  /*uint*/int Depth = 0;
  
  // JAVA FIX:
  I = $tryClone(I);
  
  for (; $noteq_ptr(I, E); I.$preInc()) {
    if (Depth == 0 && I.$star() == Target) {
      return I;
    }
    if (Depth != 0 && I.$star() == $$RCURLY) {
      Depth--;
    }
    if (I.$star() == $$PERCENT) {
      I.$postInc();
      if ($eq_ptr(I, E)) {
        break;
      }
      
      // Escaped characters get implicitly skipped here.
      
      // Format specifier.
      if (!isDigit(I.$star()) && !isPunctuation(I.$star())) {
        for (I.$postInc(); $noteq_ptr(I, E) && !isDigit(I.$star()) && I.$star() != $$LCURLY; I.$postInc())  {
          ;
        }
        if ($eq_ptr(I, E)) {
          break;
        }
        if (I.$star() == $$LCURLY) {
          Depth++;
        }
      }
    }
  }
  return E;
}


/// HandleSelectModifier - Handle the integer 'select' modifier.  This is used
/// like this:  %select{foo|bar|baz}2.  This means that the integer argument
/// "%2" has a value from 0-2.  If the value is 0, the diagnostic prints 'foo'.
/// If the value is 1, it prints 'bar'.  If it has the value 2, it prints 'baz'.
/// This is very useful for certain classes of variant diagnostics.
//<editor-fold defaultstate="collapsed" desc="HandleSelectModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 449,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 448,
 FQN="HandleSelectModifier", NM="_ZL20HandleSelectModifierRKN5clang10DiagnosticEjPKcjRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL20HandleSelectModifierRKN5clang10DiagnosticEjPKcjRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void HandleSelectModifier(/*const*/ Diagnostic /*&*/ DInfo, /*uint*/int ValNo, 
                    /*const*/char$ptr/*char P*/ Argument, /*uint*/int ArgumentLen, 
                    SmallString/*&*/ OutStr) {
  /*const*/char$ptr/*char P*/ ArgumentEnd = $tryClone(Argument.$add(ArgumentLen));
  
  // Skip over 'ValNo' |'s.
  while ((ValNo != 0)) {
    /*const*/char$ptr/*char P*/ NextVal = $tryClone(ScanFormat(Argument, ArgumentEnd, $$PIPE));
    assert ($noteq_ptr(NextVal, ArgumentEnd)) : "Value for integer select modifier was larger than the number of options in the diagnostic string!";
    Argument = $tryClone(NextVal.$add(1)); // Skip this string.
    --ValNo;
  }
  
  // Get the end of the value.  This is either the } or the |.
  /*const*/char$ptr/*char P*/ EndPtr = $tryClone(ScanFormat(Argument, ArgumentEnd, $$PIPE));
  
  // Recursively format the result of the select clause into the output string.
  DInfo.FormatDiagnostic(Argument, EndPtr, OutStr);
}


/// HandleIntegerSModifier - Handle the integer 's' modifier.  This adds the
/// letter 's' to the string if the value is not 1.  This is used in cases like
/// this:  "you idiot, you have %4 parameter%s4!".
//<editor-fold defaultstate="collapsed" desc="HandleIntegerSModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 473,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 472,
 FQN="HandleIntegerSModifier", NM="_ZL22HandleIntegerSModifierjRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL22HandleIntegerSModifierjRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void HandleIntegerSModifier(/*uint*/int ValNo, 
                      SmallString/*&*/ OutStr) {
  if (ValNo != 1) {
    OutStr.push_back($$s);
  }
}


/// HandleOrdinalModifier - Handle the integer 'ord' modifier.  This
/// prints the ordinal form of the given integer, with 1 corresponding
/// to the first ordinal.  Currently this is hard-coded to use the
/// English form.
//<editor-fold defaultstate="collapsed" desc="HandleOrdinalModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 483,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 482,
 FQN="HandleOrdinalModifier", NM="_ZL21HandleOrdinalModifierjRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL21HandleOrdinalModifierjRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void HandleOrdinalModifier(/*uint*/int ValNo, 
                     SmallString/*&*/ OutStr) {
  raw_svector_ostream Out = null;
  try {
    assert (ValNo != 0) : "ValNo must be strictly positive!";
    
    Out/*J*/= new raw_svector_ostream(OutStr);
    
    // We could use text forms for the first N ordinals, but the numeric
    // forms are actually nicer in diagnostics because they stand out.
    Out.$out_uint(ValNo).$out(llvm.getOrdinalSuffix(ValNo));
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}


/// PluralNumber - Parse an unsigned integer and advance Start.
//<editor-fold defaultstate="collapsed" desc="PluralNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 496,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 495,
 FQN="PluralNumber", NM="_ZL12PluralNumberRPKcS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL12PluralNumberRPKcS0_")
//</editor-fold>
public static /*uint*/int PluralNumber(char$ptr/*const char P &*/ Start, /*const*/char$ptr/*char P*/ End) {
  // Programming 101: Parse a decimal number :-)
  /*uint*/int Val = 0;
  while ($noteq_ptr(Start, End) && Start.$star() >= $$0 && Start.$star() <= $$9) {
    Val *= 10;
    Val += Start.$star() - $$0;
    Start.$preInc();
  }
  return Val;
}


/// TestPluralRange - Test if Val is in the parsed range. Modifies Start.
//<editor-fold defaultstate="collapsed" desc="TestPluralRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 508,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 507,
 FQN="TestPluralRange", NM="_ZL15TestPluralRangejRPKcS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL15TestPluralRangejRPKcS0_")
//</editor-fold>
public static boolean TestPluralRange(/*uint*/int Val, char$ptr/*const char P &*/ Start, /*const*/char$ptr/*char P*/ End) {
  if (Start.$star() != $$LSQUARE) {
    /*uint*/int Ref = PluralNumber(Start, End);
    return Ref == Val;
  }
  
  Start.$preInc();
  /*uint*/int Low = PluralNumber(Start, End);
  assert (Start.$star() == $$COMMA) : "Bad plural expression syntax: expected ,";
  Start.$preInc();
  /*uint*/int High = PluralNumber(Start, End);
  assert (Start.$star() == $$RSQUARE) : "Bad plural expression syntax: expected )";
  Start.$preInc();
  return $lesseq_uint(Low, Val) && $lesseq_uint(Val, High);
}


/// EvalPluralExpr - Actual expression evaluator for HandlePluralModifier.
//<editor-fold defaultstate="collapsed" desc="EvalPluralExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 525,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 524,
 FQN="EvalPluralExpr", NM="_ZL14EvalPluralExprjPKcS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL14EvalPluralExprjPKcS0_")
//</editor-fold>
public static boolean EvalPluralExpr(/*uint*/int ValNo, /*const*/char$ptr/*char P*/ Start, /*const*/char$ptr/*char P*/ End) {
  // Empty condition?
  if (Start.$star() == $$COLON) {
    return true;
  }
  while (true) {
    /*char*/byte C = Start.$star();
    if (C == $$PERCENT) {
      // Modulo expression
      Start.$preInc();
      /*uint*/int Arg = PluralNumber(Start, End);
      assert (Start.$star() == $$EQ) : "Bad plural expression syntax: expected =";
      Start.$preInc();
      /*uint*/int ValMod = ValNo % Arg;
      if (TestPluralRange(ValMod, Start, End)) {
        return true;
      }
    } else {
      assert ((C == $$LSQUARE || (C >= $$0 && C <= $$9))) : "Bad plural expression syntax: unexpected character";
      // Range expression
      if (TestPluralRange(ValNo, Start, End)) {
        return true;
      }
    }
    
    // Scan for next or-expr part.
    Start = $tryClone(std.find(Start, End, $$COMMA));
    if ($eq_ptr(Start, End)) {
      break;
    }
    Start.$preInc();
  }
  return false;
}


/// HandlePluralModifier - Handle the integer 'plural' modifier. This is used
/// for complex plural forms, or in languages where all plurals are complex.
/// The syntax is: %plural{cond1:form1|cond2:form2|:form3}, where condn are
/// conditions that are tested in order, the form corresponding to the first
/// that applies being emitted. The empty condition is always true, making the
/// last form a default case.
/// Conditions are simple boolean expressions, where n is the number argument.
/// Here are the rules.
/// condition  := expression | empty
/// empty      :=                             -> always true
/// expression := numeric [',' expression]    -> logical or
/// numeric    := range                       -> true if n in range
///             | '%' number '=' range        -> true if n % number in range
/// range      := number
///             | '[' number ',' number ']'   -> ranges are inclusive both ends
///
/// Here are some examples from the GNU gettext manual written in this form:
/// English:
/// {1:form0|:form1}
/// Latvian:
/// {0:form2|%100=11,%10=0,%10=[2,9]:form1|:form0}
/// Gaeilge:
/// {1:form0|2:form1|:form2}
/// Romanian:
/// {1:form0|0,%100=[1,19]:form1|:form2}
/// Lithuanian:
/// {%10=0,%100=[10,19]:form2|%10=1:form0|:form1}
/// Russian (requires repeated form):
/// {%100=[11,14]:form2|%10=1:form0|%10=[2,4]:form1|:form2}
/// Slovak
/// {1:form0|[2,4]:form1|:form2}
/// Polish (requires repeated form):
/// {1:form0|%100=[10,20]:form2|%10=[2,4]:form1|:form2}
//<editor-fold defaultstate="collapsed" desc="HandlePluralModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 591,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 590,
 FQN="HandlePluralModifier", NM="_ZL20HandlePluralModifierRKN5clang10DiagnosticEjPKcjRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL20HandlePluralModifierRKN5clang10DiagnosticEjPKcjRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void HandlePluralModifier(/*const*/ Diagnostic /*&*/ DInfo, /*uint*/int ValNo, 
                    /*const*/char$ptr/*char P*/ Argument, /*uint*/int ArgumentLen, 
                    SmallString/*&*/ OutStr) {
  /*const*/char$ptr/*char P*/ ArgumentEnd = $tryClone(Argument.$add(ArgumentLen));
  while (true) {
    assert (Argument.$less(ArgumentEnd)) : "Plural expression didn't match.";
    /*const*/char$ptr/*char P*/ ExprEnd = $tryClone(Argument);
    while (ExprEnd.$star() != $$COLON) {
      assert ($noteq_ptr(ExprEnd, ArgumentEnd)) : "Plural missing expression end";
      ExprEnd.$preInc();
    }
    if (EvalPluralExpr(ValNo, Argument, ExprEnd)) {
      Argument = $tryClone(ExprEnd.$add(1));
      ExprEnd = $tryClone(ScanFormat(Argument, ArgumentEnd, $$PIPE));
      
      // Recursively format the result of the plural clause into the
      // output string.
      DInfo.FormatDiagnostic(Argument, ExprEnd, OutStr);
      return;
    }
    Argument = $tryClone(ScanFormat(Argument, ArgumentEnd.$sub(1), $$PIPE).$add(1));
  }
}


/// \brief Returns the friendly description for a token kind that will appear
/// without quotes in diagnostic messages. These strings may be translatable in
/// future.
//<editor-fold defaultstate="collapsed" desc="getTokenDescForDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 618,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 617,
 FQN="getTokenDescForDiagnostic", NM="_ZL25getTokenDescForDiagnosticN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZL25getTokenDescForDiagnosticN5clang3tok9TokenKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTokenDescForDiagnostic(/*tok.TokenKind*/char Kind) {
  switch (Kind) {
   case tok.TokenKind.identifier:
    return $identifier;
   default:
    return null;
  }
}

} // END OF class DiagnosticStatics
