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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 200,
 FQN="(anonymous namespace)::ParseHelper", NM="_ZN12_GLOBAL__N_111ParseHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelperE")
//</editor-fold>
public class ParseHelper {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::ParseHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 203,
   FQN="(anonymous namespace)::ParseHelper::ParseHelper", NM="_ZN12_GLOBAL__N_111ParseHelperC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelperC1EN4llvm9StringRefE")
  //</editor-fold>
  public ParseHelper(StringRef S) {
    // : Begin(S.begin()), End(S.end()), C(Begin), P(Begin), PEnd(null) 
    //START JInit
    this.Begin = $tryClone(S.begin());
    this.End = $tryClone(S.end());
    this.C = $tryClone(Begin);
    this.P = $tryClone(Begin);
    this.PEnd = null;
    //END JInit
  }

  
  // Return true if string literal is next.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::Next">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 207,
   FQN="(anonymous namespace)::ParseHelper::Next", NM="_ZN12_GLOBAL__N_111ParseHelper4NextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper4NextEN4llvm9StringRefE")
  //</editor-fold>
  public boolean Next(StringRef S) {
    P = $tryClone(C);
    PEnd = $tryClone(C.$add(S.size()));
    if (PEnd.$greater(End)) {
      return false;
    }
    return !(memcmp(P, S.data(), S.size()) != 0);
  }

  
  // Return true if number is next.
  // Output N only if number is next.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::Next">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 217,
   FQN="(anonymous namespace)::ParseHelper::Next", NM="_ZN12_GLOBAL__N_111ParseHelper4NextERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper4NextERj")
  //</editor-fold>
  public boolean Next(uint$ref/*uint &*/ N) {
    /*uint*/int TMP = 0;
    P = $tryClone(C);
    for (; P.$less(End) && P.$at(0) >= $$0 && P.$at(0) <= $$9; P.$preInc()) {
      TMP *= 10;
      TMP += P.$at(0) - $$0;
    }
    if ($eq_ptr(P, C)) {
      return false;
    }
    PEnd = $tryClone(P);
    N.$set(TMP);
    return true;
  }

  
  // Return true if string literal is found.
  // When true, P marks begin-position of S in content.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::Search">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 233,
   FQN="(anonymous namespace)::ParseHelper::Search", NM="_ZN12_GLOBAL__N_111ParseHelper6SearchEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper6SearchEN4llvm9StringRefEb")
  //</editor-fold>
  public boolean Search(StringRef S) {
    return Search(S, false);
  }
  public boolean Search(StringRef S, boolean EnsureStartOfWord/*= false*/) {
    do {
      P = $tryClone(std.search(C, End, S.begin(), S.end()));
      PEnd = $tryClone(P.$add(S.size()));
      if ($eq_ptr(P, End)) {
        break;
      }
      if (!EnsureStartOfWord
        // Check if string literal starts a new word.
         || $eq_ptr(P, Begin) || isWhitespace(P.$at(-1))
        // Or it could be preceded by the start of a comment.
         || (P.$greater((Begin.$add(1))) && (P.$at(-1) == $$SLASH || P.$at(-1) == $$STAR)
         && P.$at(-2) == $$SLASH)) {
        return true;
      }
      // Otherwise, skip and search again.
    } while (Advance());
    return false;
  }

  
  // Return true if a CloseBrace that closes the OpenBrace at the current nest
  // level is found. When true, P marks begin-position of CloseBrace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::SearchClosingBrace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 253,
   FQN="(anonymous namespace)::ParseHelper::SearchClosingBrace", NM="_ZN12_GLOBAL__N_111ParseHelper18SearchClosingBraceEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper18SearchClosingBraceEN4llvm9StringRefES2_")
  //</editor-fold>
  public boolean SearchClosingBrace(StringRef OpenBrace, StringRef CloseBrace) {
    /*uint*/int Depth = 1;
    P = $tryClone(C);
    while (P.$less(End)) {
      // JAVA: $tryClone(P) to fix pass of pointer which will be constantified*/
      StringRef S/*J*/= new StringRef($tryClone(P)/*JAVA*/, End.$sub(P));
      if (S.startswith(/*NO_COPY*/OpenBrace)) {
        ++Depth;
        P.$inc(OpenBrace.size());
      } else if (S.startswith(/*NO_COPY*/CloseBrace)) {
        --Depth;
        if (Depth == 0) {
          PEnd = $tryClone(P.$add(CloseBrace.size()));
          return true;
        }
        P.$inc(CloseBrace.size());
      } else {
        P.$preInc();
      }
    }
    return false;
  }

  
  // Advance 1-past previous next/search.
  // Behavior is undefined if previous next/search failed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::Advance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 277,
   FQN="(anonymous namespace)::ParseHelper::Advance", NM="_ZN12_GLOBAL__N_111ParseHelper7AdvanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper7AdvanceEv")
  //</editor-fold>
  public boolean Advance() {
    C = $tryClone(PEnd);
    return C.$less(End);
  }

  
  // Skip zero or more whitespace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::SkipWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 283,
   FQN="(anonymous namespace)::ParseHelper::SkipWhitespace", NM="_ZN12_GLOBAL__N_111ParseHelper14SkipWhitespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper14SkipWhitespaceEv")
  //</editor-fold>
  public void SkipWhitespace() {
    for (; C.$less(End) && isWhitespace(C.$star()); C.$preInc())  {
      ;
    }
  }

  
  // Return true if EOF reached.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParseHelper::Done">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 289,
   FQN="(anonymous namespace)::ParseHelper::Done", NM="_ZN12_GLOBAL__N_111ParseHelper4DoneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_111ParseHelper4DoneEv")
  //</editor-fold>
  public boolean Done() {
    return !(C.$less(End));
  }

  
  public /*const*/char$ptr/*char P*//*const*/ Begin; // beginning of expected content
  public /*const*/char$ptr/*char P*//*const*/ End; // end of expected content (1-past)
  public /*const*/char$ptr/*char P*/ C; // position of next char in content
  public /*const*/char$ptr/*char P*/ P;
/*private:*/
  private /*const*/char$ptr/*char P*/ PEnd; // previous next/search subject end (1-past)
  
  @Override public String toString() {
    return "" + "Begin=" + Begin // NOI18N
              + ", End=" + End // NOI18N
              + ", C=" + C // NOI18N
              + ", P=" + P // NOI18N
              + ", PEnd=" + PEnd; // NOI18N
  }
}
