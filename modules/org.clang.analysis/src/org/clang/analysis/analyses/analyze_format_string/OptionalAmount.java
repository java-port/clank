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

package org.clang.analysis.analyses.analyze_format_string;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.analyze_format_string.*;

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 273,
 FQN="clang::analyze_format_string::OptionalAmount", NM="_ZN5clang21analyze_format_string14OptionalAmountE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountE")
//</editor-fold>
public class OptionalAmount {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::HowSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 275,
   FQN="clang::analyze_format_string::OptionalAmount::HowSpecified", NM="_ZN5clang21analyze_format_string14OptionalAmount12HowSpecifiedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmount12HowSpecifiedE")
  //</editor-fold>
  public enum HowSpecified implements Native.ComparableLower {
    NotSpecified(0),
    Constant(NotSpecified.getValue() + 1),
    Arg(Constant.getValue() + 1),
    Invalid(Arg.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static HowSpecified valueOf(int val) {
      HowSpecified out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final HowSpecified[] VALUES;
      private static final HowSpecified[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (HowSpecified kind : HowSpecified.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new HowSpecified[min < 0 ? (1-min) : 0];
        VALUES = new HowSpecified[max >= 0 ? (1+max) : 0];
        for (HowSpecified kind : HowSpecified.values()) {
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
    private HowSpecified(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((HowSpecified)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((HowSpecified)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::OptionalAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 277,
   FQN="clang::analyze_format_string::OptionalAmount::OptionalAmount", NM="_ZN5clang21analyze_format_string14OptionalAmountC1ENS1_12HowSpecifiedEjPKcjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountC1ENS1_12HowSpecifiedEjPKcjb")
  //</editor-fold>
  public OptionalAmount(HowSpecified howSpecified, 
      /*uint*/int amount, 
      /*const*/char$ptr/*char P*/ amountStart, 
      /*uint*/int amountLength, 
      boolean usesPositionalArg) {
    // : start(amountStart), length(amountLength), hs(howSpecified), amt(amount), UsesPositionalArg(usesPositionalArg), UsesDotPrefix(0) 
    //START JInit
    this.start = $tryClone(amountStart);
    this.length = amountLength;
    this.hs = howSpecified;
    this.amt = amount;
    this.UsesPositionalArg = usesPositionalArg;
    this.UsesDotPrefix = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::OptionalAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 285,
   FQN="clang::analyze_format_string::OptionalAmount::OptionalAmount", NM="_ZN5clang21analyze_format_string14OptionalAmountC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountC1Eb")
  //</editor-fold>
  public OptionalAmount() {
    this(true);
  }
  public OptionalAmount(boolean valid/*= true*/) {
    // : start(null), length(0), hs(valid ? NotSpecified : Invalid), amt(0), UsesPositionalArg(0), UsesDotPrefix(0) 
    //START JInit
    this.start = null;
    this.length = 0;
    this.hs = valid ? HowSpecified.NotSpecified : HowSpecified.Invalid;
    this.amt = 0;
    this.UsesPositionalArg = false;
    this.UsesDotPrefix = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 289,
   FQN="clang::analyze_format_string::OptionalAmount::isInvalid", NM="_ZNK5clang21analyze_format_string14OptionalAmount9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return hs == HowSpecified.Invalid;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getHowSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 293,
   FQN="clang::analyze_format_string::OptionalAmount::getHowSpecified", NM="_ZNK5clang21analyze_format_string14OptionalAmount15getHowSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount15getHowSpecifiedEv")
  //</editor-fold>
  public HowSpecified getHowSpecified() /*const*/ {
    return hs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::setHowSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 294,
   FQN="clang::analyze_format_string::OptionalAmount::setHowSpecified", NM="_ZN5clang21analyze_format_string14OptionalAmount15setHowSpecifiedENS1_12HowSpecifiedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmount15setHowSpecifiedENS1_12HowSpecifiedE")
  //</editor-fold>
  public void setHowSpecified(HowSpecified h) {
    hs = h;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::hasDataArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 296,
   FQN="clang::analyze_format_string::OptionalAmount::hasDataArgument", NM="_ZNK5clang21analyze_format_string14OptionalAmount15hasDataArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount15hasDataArgumentEv")
  //</editor-fold>
  public boolean hasDataArgument() /*const*/ {
    return hs == HowSpecified.Arg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getArgIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 298,
   FQN="clang::analyze_format_string::OptionalAmount::getArgIndex", NM="_ZNK5clang21analyze_format_string14OptionalAmount11getArgIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount11getArgIndexEv")
  //</editor-fold>
  public /*uint*/int getArgIndex() /*const*/ {
    assert (hasDataArgument());
    return amt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getConstantAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 303,
   FQN="clang::analyze_format_string::OptionalAmount::getConstantAmount", NM="_ZNK5clang21analyze_format_string14OptionalAmount17getConstantAmountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount17getConstantAmountEv")
  //</editor-fold>
  public /*uint*/int getConstantAmount() /*const*/ {
    assert (hs == HowSpecified.Constant);
    return amt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 308,
   FQN="clang::analyze_format_string::OptionalAmount::getStart", NM="_ZNK5clang21analyze_format_string14OptionalAmount8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount8getStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getStart() /*const*/ {
    // We include the . character if it is given.
    return start.$sub((UsesDotPrefix ? 1 : 0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getConstantLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 313,
   FQN="clang::analyze_format_string::OptionalAmount::getConstantLength", NM="_ZNK5clang21analyze_format_string14OptionalAmount17getConstantLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount17getConstantLengthEv")
  //</editor-fold>
  public /*uint*/int getConstantLength() /*const*/ {
    assert (hs == HowSpecified.Constant);
    return length + (UsesDotPrefix ? 1 : 0);
  }

  
  
  //===----------------------------------------------------------------------===//
  // Methods on OptionalAmount.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 508,
   FQN="clang::analyze_format_string::OptionalAmount::getArgType", NM="_ZNK5clang21analyze_format_string14OptionalAmount10getArgTypeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount10getArgTypeERNS_10ASTContextE")
  //</editor-fold>
  public ArgType getArgType(final ASTContext /*&*/ Ctx) /*const*/ {
    return new ArgType(new CanQual<Type>(Ctx.IntTy));
  }

  
  
  //===----------------------------------------------------------------------===//
  // Methods on OptionalAmount.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 636,
   FQN="clang::analyze_format_string::OptionalAmount::toString", NM="_ZNK5clang21analyze_format_string14OptionalAmount8toStringERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount8toStringERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void __toString(final raw_ostream /*&*/ os) /*const*/ {
    switch (hs) {
     case Invalid:
     case NotSpecified:
      return;
     case Arg:
      if (UsesDotPrefix) {
        os.$out(/*KEEP_STR*/$DOT);
      }
      if (usesPositionalArg()) {
        os.$out(/*KEEP_STR*/$STAR).$out_uint(getPositionalArgIndex()).$out(/*KEEP_STR*/$DOLLAR);
      } else {
        os.$out(/*KEEP_STR*/$STAR);
      }
      break;
     case Constant:
      if (UsesDotPrefix) {
        os.$out(/*KEEP_STR*/$DOT);
      }
      os.$out_uint(amt);
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::usesPositionalArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 322,
   FQN="clang::analyze_format_string::OptionalAmount::usesPositionalArg", NM="_ZNK5clang21analyze_format_string14OptionalAmount17usesPositionalArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount17usesPositionalArgEv")
  //</editor-fold>
  public boolean usesPositionalArg() /*const*/ {
    return (boolean)UsesPositionalArg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::getPositionalArgIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 323,
   FQN="clang::analyze_format_string::OptionalAmount::getPositionalArgIndex", NM="_ZNK5clang21analyze_format_string14OptionalAmount21getPositionalArgIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount21getPositionalArgIndexEv")
  //</editor-fold>
  public /*uint*/int getPositionalArgIndex() /*const*/ {
    assert (hasDataArgument());
    return amt + 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::usesDotPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 328,
   FQN="clang::analyze_format_string::OptionalAmount::usesDotPrefix", NM="_ZNK5clang21analyze_format_string14OptionalAmount13usesDotPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string14OptionalAmount13usesDotPrefixEv")
  //</editor-fold>
  public boolean usesDotPrefix() /*const*/ {
    return UsesDotPrefix;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::setUsesDotPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 329,
   FQN="clang::analyze_format_string::OptionalAmount::setUsesDotPrefix", NM="_ZN5clang21analyze_format_string14OptionalAmount16setUsesDotPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmount16setUsesDotPrefixEv")
  //</editor-fold>
  public void setUsesDotPrefix() {
    UsesDotPrefix = true;
  }

/*private:*/
  private /*const*/char$ptr/*char P*/ start;
  private /*uint*/int length;
  private HowSpecified hs;
  private /*uint*/int amt;
  private /*JBIT bool*/ boolean UsesPositionalArg /*: 1*/;
  private boolean UsesDotPrefix;
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::OptionalAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 273,
   FQN="clang::analyze_format_string::OptionalAmount::OptionalAmount", NM="_ZN5clang21analyze_format_string14OptionalAmountC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountC1EOS1_")
  //</editor-fold>
  public /*inline*/ OptionalAmount(JD$Move _dparam, final OptionalAmount /*&&*/$Prm0) {
    // : start(static_cast<OptionalAmount &&>().start), length(static_cast<OptionalAmount &&>().length), hs(static_cast<OptionalAmount &&>().hs), amt(static_cast<OptionalAmount &&>().amt), UsesPositionalArg(static_cast<OptionalAmount &&>().UsesPositionalArg), UsesDotPrefix(static_cast<OptionalAmount &&>().UsesDotPrefix) 
    //START JInit
    this.start = $tryClone($Prm0.start);
    this.length = $Prm0.length;
    this.hs = $Prm0.hs;
    this.amt = $Prm0.amt;
    this.UsesPositionalArg = $Prm0.UsesPositionalArg;
    this.UsesDotPrefix = $Prm0.UsesDotPrefix;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 273,
   FQN="clang::analyze_format_string::OptionalAmount::operator=", NM="_ZN5clang21analyze_format_string14OptionalAmountaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountaSERKS1_")
  //</editor-fold>
  public /*inline*/ OptionalAmount /*&*/ $assign(final /*const*/ OptionalAmount /*&*/ $Prm0) {
    this.start = $tryClone($Prm0.start);
    this.length = $Prm0.length;
    this.hs = $Prm0.hs;
    this.amt = $Prm0.amt;
    this.UsesPositionalArg = $Prm0.UsesPositionalArg;
    this.UsesDotPrefix = $Prm0.UsesDotPrefix;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::OptionalAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 273,
   FQN="clang::analyze_format_string::OptionalAmount::OptionalAmount", NM="_ZN5clang21analyze_format_string14OptionalAmountC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountC1ERKS1_")
  //</editor-fold>
  public /*inline*/ OptionalAmount(final /*const*/ OptionalAmount /*&*/ $Prm0) {
    // : start(.start), length(.length), hs(.hs), amt(.amt), UsesPositionalArg(.UsesPositionalArg), UsesDotPrefix(.UsesDotPrefix) 
    //START JInit
    this.start = $tryClone($Prm0.start);
    this.length = $Prm0.length;
    this.hs = $Prm0.hs;
    this.amt = $Prm0.amt;
    this.UsesPositionalArg = $Prm0.UsesPositionalArg;
    this.UsesDotPrefix = $Prm0.UsesDotPrefix;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::OptionalAmount::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 273,
   FQN="clang::analyze_format_string::OptionalAmount::operator=", NM="_ZN5clang21analyze_format_string14OptionalAmountaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string14OptionalAmountaSEOS1_")
  //</editor-fold>
  public /*inline*/ OptionalAmount /*&*/ $assignMove(final OptionalAmount /*&&*/$Prm0) {
    this.start = $tryClone($Prm0.start);
    this.length = $Prm0.length;
    this.hs = $Prm0.hs;
    this.amt = $Prm0.amt;
    this.UsesPositionalArg = $Prm0.UsesPositionalArg;
    this.UsesDotPrefix = $Prm0.UsesDotPrefix;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "start=" + start // NOI18N
              + ", length=" + length // NOI18N
              + ", hs=" + hs // NOI18N
              + ", amt=" + amt // NOI18N
              + ", UsesPositionalArg=" + UsesPositionalArg // NOI18N
              + ", UsesDotPrefix=" + UsesDotPrefix; // NOI18N
  }
}
