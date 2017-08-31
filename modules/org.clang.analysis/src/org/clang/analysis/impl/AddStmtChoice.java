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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.analysis.impl.*;


/// The CFG builder uses a recursive algorithm to build the CFG.  When
///  we process an expression, sometimes we know that we must add the
///  subexpressions as block-level expressions.  For example:
///
///    exp1 || exp2
///
///  When processing the '||' expression, we know that exp1 and exp2
///  need to be added as block-level expressions, even though they
///  might not normally need to be.  AddStmtChoice records this
///  contextual information.  If AddStmtChoice is 'NotAlwaysAdd', then
///  the builder has an option not to add a subexpression as a
///  block-level expression.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 129,
 FQN="(anonymous namespace)::AddStmtChoice", NM="_ZN12_GLOBAL__N_113AddStmtChoiceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113AddStmtChoiceE")
//</editor-fold>
public class AddStmtChoice {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 131,
   FQN="(anonymous namespace)::AddStmtChoice::Kind", NM="_ZN12_GLOBAL__N_113AddStmtChoice4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113AddStmtChoice4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    NotAlwaysAdd(0),
    AlwaysAdd(1);

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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::AddStmtChoice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 133,
   FQN="(anonymous namespace)::AddStmtChoice::AddStmtChoice", NM="_ZN12_GLOBAL__N_113AddStmtChoiceC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113AddStmtChoiceC1ENS0_4KindE")
  //</editor-fold>
  public AddStmtChoice() {
    this(Kind.NotAlwaysAdd);
  }
  public AddStmtChoice(Kind a_kind/*= NotAlwaysAdd*/) {
    // : kind(a_kind) 
    //START JInit
    this.kind = a_kind;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::alwaysAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 963,
   FQN="(anonymous namespace)::AddStmtChoice::alwaysAdd", NM="_ZNK12_GLOBAL__N_113AddStmtChoice9alwaysAddERNS_10CFGBuilderEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_113AddStmtChoice9alwaysAddERNS_10CFGBuilderEPKN5clang4StmtE")
  //</editor-fold>
  public /*inline*/ boolean alwaysAdd(final CFGBuilder /*&*/ builder, 
           /*const*/ Stmt /*P*/ stmt) /*const*/ {
    return builder.alwaysAdd(stmt) || kind == Kind.AlwaysAdd;
  }

  
  /// Return a copy of this object, except with the 'always-add' bit
  ///  set as specified.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::withAlwaysAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 140,
   FQN="(anonymous namespace)::AddStmtChoice::withAlwaysAdd", NM="_ZNK12_GLOBAL__N_113AddStmtChoice13withAlwaysAddEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_113AddStmtChoice13withAlwaysAddEb")
  //</editor-fold>
  public AddStmtChoice withAlwaysAdd(boolean alwaysAdd) /*const*/ {
    return new AddStmtChoice(alwaysAdd ? Kind.AlwaysAdd : Kind.NotAlwaysAdd);
  }

/*private:*/
  private Kind kind;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::AddStmtChoice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 129,
   FQN="(anonymous namespace)::AddStmtChoice::AddStmtChoice", NM="_ZN12_GLOBAL__N_113AddStmtChoiceC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113AddStmtChoiceC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AddStmtChoice(final /*const*/ AddStmtChoice /*&*/ $Prm0) {
    // : kind(.kind) 
    //START JInit
    this.kind = $Prm0.kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::AddStmtChoice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 129,
   FQN="(anonymous namespace)::AddStmtChoice::AddStmtChoice", NM="_ZN12_GLOBAL__N_113AddStmtChoiceC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113AddStmtChoiceC1EOS0_")
  //</editor-fold>
  public /*inline*/ AddStmtChoice(JD$Move _dparam, final AddStmtChoice /*&&*/$Prm0) {
    // : kind(static_cast<AddStmtChoice &&>().kind) 
    //START JInit
    this.kind = $Prm0.kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddStmtChoice::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 129,
   FQN="(anonymous namespace)::AddStmtChoice::operator=", NM="_ZN12_GLOBAL__N_113AddStmtChoiceaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113AddStmtChoiceaSEOS0_")
  //</editor-fold>
  public /*inline*/ AddStmtChoice /*&*/ $assignMove(final AddStmtChoice /*&&*/$Prm0) {
    this.kind = $Prm0.kind;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "kind=" + kind; // NOI18N
  }
}
