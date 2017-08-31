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

package org.llvm.option;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorImpl;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


/// \brief A concrete instance of a particular driver option.
///
/// The Arg class encodes just enough information to be able to
/// derive the argument values efficiently.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 31,
 FQN = "llvm::opt::Arg", NM = "_ZN4llvm3opt3ArgE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgE")
//</editor-fold>
public class Arg implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::Arg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 32,
          FQN = "llvm::opt::Arg::Arg", NM = "_ZN4llvm3opt3ArgC1ERKS1_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgC1ERKS1_")
//</editor-fold>
  private Arg(/*const*/Arg /*&*/ $Prm0) {
    throw new UnsupportedOperationException("Deleted");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 33,
          FQN = "llvm::opt::Arg::operator=", NM = "_ZN4llvm3opt3ArgaSERKS1_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgaSERKS1_")
//</editor-fold>
  private void $assign(/*const*/Arg /*&*/ $Prm0) {
    throw new UnsupportedOperationException("Deleted");
  }

/*private:*/
  /// \brief The option this argument is an instance of.
  private /*const*/Option Opt;
  
  /// \brief The argument this argument was derived from (during tool chain
  /// argument translation), if any.
  private /*const*/Arg /*P*/ BaseArg;
  
  /// \brief How this instance of the option was spelled.
  private StringRef Spelling;
  
  /// \brief The index at which this argument appears in the containing
  /// ArgList.
  private /*uint*/int Index;
  
  /// \brief Was this argument used to effect compilation?
  ///
  /// This is used for generating "argument unused" diagnostics.
  private /*mutable *//*JBIT unsigned int*/ boolean Claimed /*: 1*/;
  
  /// \brief Does this argument own its values?
  private /*mutable *//*JBIT unsigned int*/ boolean OwnsValues /*: 1*/;
  
  /// \brief The argument values, as C strings.
  private SmallVector</*const*/char$ptr/*char P*/> Values;
/*public:*/
//<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::Arg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 21,
          old_source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", old_line = 20,
          FQN = "llvm::opt::Arg::Arg", NM = "_ZN4llvm3opt3ArgC1ENS0_6OptionENS_9StringRefEjPKS1_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgC1ENS0_6OptionENS_9StringRefEjPKS1_")
//</editor-fold>
  public Arg(/*const*/Option Opt, StringRef S, /*uint*/ int Index) {
    this(Opt, S, Index, (/*const*/Arg /*P*/) null);
  }

  public Arg(/*const*/Option Opt, StringRef S, /*uint*/ int Index, /*const*/ Arg /*P*/ BaseArg/*= null*/) {
    /* : Opt(Opt), BaseArg(BaseArg), Spelling(S), Index(Index), Claimed(false), OwnsValues(false), Values()*/
    //START JInit
    this.Opt = new Option(Opt);
    this.BaseArg = BaseArg;
    this.Spelling = new StringRef(S);
    this.Index = Index;
    this.Claimed = false;
    this.OwnsValues = false;
    this.Values = new SmallVector</*const*/char$ptr/*char P*//*,  2*/>(2, null);
    //END JInit
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::Arg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 25,
          FQN = "llvm::opt::Arg::Arg", NM = "_ZN4llvm3opt3ArgC1ENS0_6OptionENS_9StringRefEjPKcPKS1_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgC1ENS0_6OptionENS_9StringRefEjPKcPKS1_")
//</editor-fold>
  public Arg(/*const*/Option Opt, StringRef S, /*uint*/ int Index, /*const*/ char$ptr/*char P*/ Value0) {
    this(Opt, S, Index, Value0,
            (/*const*/Arg /*P*/) null);
  }

  public Arg(/*const*/Option Opt, StringRef S, /*uint*/ int Index, /*const*/ char$ptr/*char P*/ Value0,
          /*const*/ Arg /*P*/ BaseArg/*= null*/) {
    /* : Opt(Opt), BaseArg(BaseArg), Spelling(S), Index(Index), Claimed(false), OwnsValues(false), Values()*/
    //START JInit
    this.Opt = new Option(Opt);
    this.BaseArg = BaseArg;
    this.Spelling = new StringRef(S);
    this.Index = Index;
    this.Claimed = false;
    this.OwnsValues = false;
    this.Values = new SmallVector</*const*/char$ptr/*char P*//*,  2*/>(2, null);
    //END JInit
    Values.push_back(Value0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::Arg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 32,
          FQN = "llvm::opt::Arg::Arg", NM = "_ZN4llvm3opt3ArgC1ENS0_6OptionENS_9StringRefEjPKcS5_PKS1_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgC1ENS0_6OptionENS_9StringRefEjPKcS5_PKS1_")
//</editor-fold>
  public Arg(/*const*/Option Opt, StringRef S, /*uint*/ int Index, /*const*/ char$ptr/*char P*/ Value0,
          /*const*/ char$ptr/*char P*/ Value1) {
    this(Opt, S, Index, Value0,
            Value1, (/*const*/Arg /*P*/) null);
  }

  public Arg(/*const*/Option Opt, StringRef S, /*uint*/ int Index, /*const*/ char$ptr/*char P*/ Value0,
          /*const*/ char$ptr/*char P*/ Value1, /*const*/ Arg /*P*/ BaseArg/*= null*/) {
    /* : Opt(Opt), BaseArg(BaseArg), Spelling(S), Index(Index), Claimed(false), OwnsValues(false), Values()*/
    //START JInit
    this.Opt = new Option(Opt);
    this.BaseArg = BaseArg;
    this.Spelling = new StringRef(S);
    this.Index = Index;
    this.Claimed = false;
    this.OwnsValues = false;
    this.Values = new SmallVector</*const*/char$ptr/*char P*//*,  2*/>(2, null);
    //END JInit
    Values.push_back(Value0);
    Values.push_back(Value1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::~Arg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 40,
   FQN = "llvm::opt::Arg::~Arg", NM = "_ZN4llvm3opt3ArgD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3ArgD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (OwnsValues) {
      for (/*uint*/int i = 0, e = Values.size(); i != e; ++i)  {
        /*delete[]*/Destructors.$destroyArray(Values.$at(i));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getOption">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 70,
   FQN = "llvm::opt::Arg::getOption", NM = "_ZNK4llvm3opt3Arg9getOptionEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg9getOptionEv")
  //</editor-fold>
  public /*const*/Option getOption() /*const*/ {
    return Opt;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getSpelling">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 71,
   FQN = "llvm::opt::Arg::getSpelling", NM = "_ZNK4llvm3opt3Arg11getSpellingEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg11getSpellingEv")
  //</editor-fold>
  public StringRef getSpelling() /*const*/ {
    return Spelling;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getIndex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 72,
   FQN = "llvm::opt::Arg::getIndex", NM = "_ZNK4llvm3opt3Arg8getIndexEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg8getIndexEv")
  //</editor-fold>
  public /*uint*/int getIndex() /*const*/ {
    return Index;
  }

  
  /// \brief Return the base argument which generated this arg.
  ///
  /// This is either the argument itself or the argument it was
  /// derived from during tool chain specific argument translation.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getBaseArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 78,
   FQN = "llvm::opt::Arg::getBaseArg", NM = "_ZNK4llvm3opt3Arg10getBaseArgEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg10getBaseArgEv")
  //</editor-fold>
  public /*const*/Arg /*&*/ getBaseArg() /*const*/ {
    return (BaseArg != null) ? $Deref(BaseArg) : /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::setBaseArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 81,
          FQN = "llvm::opt::Arg::setBaseArg", NM = "_ZN4llvm3opt3Arg10setBaseArgEPKS1_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3Arg10setBaseArgEPKS1_")
//</editor-fold>
  public void setBaseArg(/*const*/Arg /*P*/ BaseArg) {
    this.BaseArg = BaseArg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getOwnsValues">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 85,
   FQN = "llvm::opt::Arg::getOwnsValues", NM = "_ZNK4llvm3opt3Arg13getOwnsValuesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg13getOwnsValuesEv")
  //</editor-fold>
  public boolean getOwnsValues() /*const*/ {
    return OwnsValues;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::setOwnsValues">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 86,
   FQN = "llvm::opt::Arg::setOwnsValues", NM = "_ZNK4llvm3opt3Arg13setOwnsValuesEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg13setOwnsValuesEb")
  //</editor-fold>
  public void setOwnsValues(boolean Value) /*const*/ {
    OwnsValues = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::isClaimed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 88,
   FQN = "llvm::opt::Arg::isClaimed", NM = "_ZNK4llvm3opt3Arg9isClaimedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg9isClaimedEv")
  //</editor-fold>
  public boolean isClaimed() /*const*/ {
    return getBaseArg().Claimed;
  }

  
  /// \brief Set the Arg claimed bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::claim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 91,
   FQN = "llvm::opt::Arg::claim", NM = "_ZNK4llvm3opt3Arg5claimEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg5claimEv")
  //</editor-fold>
  public void claim() /*const*/ {
    getBaseArg().Claimed = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getNumValues">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 93,
   FQN = "llvm::opt::Arg::getNumValues", NM = "_ZNK4llvm3opt3Arg12getNumValuesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg12getNumValuesEv")
  //</editor-fold>
  public /*uint*/int getNumValues() /*const*/ {
    return Values.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 94,
   FQN = "llvm::opt::Arg::getValue", NM = "_ZNK4llvm3opt3Arg8getValueEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg8getValueEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getValue() /*const*/ {
    return getValue(0);
  }
  public /*const*/char$ptr/*char P*/ getValue(/*uint*/int N/*= 0*/) /*const*/ {
    return Values.$at(N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getValues">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 96,
          old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 98,
          FQN = "llvm::opt::Arg::getValues", NM = "_ZN4llvm3opt3Arg9getValuesEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt3Arg9getValuesEv")
//</editor-fold>
  public SmallVectorImpl</*const*/char$ptr/*char P*/> /*&*/ getValues() {
    return Values;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::containsValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/Arg.h", old_line = 102,
   FQN = "llvm::opt::Arg::containsValue", NM = "_ZNK4llvm3opt3Arg13containsValueENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg13containsValueENS_9StringRefE")
  //</editor-fold>
  public boolean containsValue(StringRef Value) /*const*/ {
    for (/*uint*/int i = 0, e = getNumValues(); i != e; ++i)  {
      if ($eq_StringRef(new StringRef(Values.$at(i)), Value)) {
        return true;
      }
    }
    return false;
  }

  
/// \brief Append the argument onto the given array as strings.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::render">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 91,
          old_source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", old_line = 90,
          FQN = "llvm::opt::Arg::render", NM = "_ZNK4llvm3opt3Arg6renderERKNS0_7ArgListERNS_11SmallVectorIPKcLj16EEE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg6renderERKNS0_7ArgListERNS_11SmallVectorIPKcLj16EEE")
//</editor-fold>
  public void render(/*const*/ArgList /*&*/ Args, ArgStringList/*&*/ Output) /*const*/ {
    switch (getOption().getRenderStyle()) {
      case RenderValuesStyle:
        Output.append_T(Values.begin(), Values.end());
        break;
      case RenderCommaJoinedStyle: {
        raw_svector_ostream OS = null;
        try {
          SmallString/*256*/ Res/*J*/ = new SmallString/*256*/(256);
          OS/*J*/ = new raw_svector_ostream(Res);
          OS.$out(getSpelling());
          for (/*uint*/int i = 0, e = getNumValues(); i != e; ++i) {
            if ((i != 0)) {
              OS.$out_char($$COMMA);
            }
            OS.$out(getValue(i));
          }
          Output.push_back(Args.MakeArgString(new Twine(OS.str())));
          break;
        } finally {
          if (OS != null) {
            OS.$destroy();
          }
        }
      }
      case RenderJoinedStyle:
        Output.push_back(Args.GetOrMakeJoinedArgString(getIndex(), getSpelling(), new StringRef(getValue(0))));
        Output.append_T(Values.begin().$add(1), Values.end());
        break;
      case RenderSeparateStyle:
        Output.push_back(Args.MakeArgString(new Twine(getSpelling())));
        Output.append_T(Values.begin(), Values.end());
        break;
    }
  }


/// \brief Append the argument, render as an input, onto the given
/// array as strings.
///
/// The distinction is that some options only render their values
/// when rendered as a input (e.g., Xlinker).
//<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::renderAsInput">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 82,
          old_source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", old_line = 80,
          FQN = "llvm::opt::Arg::renderAsInput", NM = "_ZNK4llvm3opt3Arg13renderAsInputERKNS0_7ArgListERNS_11SmallVectorIPKcLj16EEE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg13renderAsInputERKNS0_7ArgListERNS_11SmallVectorIPKcLj16EEE")
//</editor-fold>
  public void renderAsInput(/*const*/ArgList /*&*/ Args, ArgStringList/*&*/ Output) /*const*/ {
    if (!getOption().hasNoOptAsInput()) {
      render(Args, Output);
      return;
    }

    Output.append_T(Values.begin(), Values.end());
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 47,
          FQN = "llvm::opt::Arg::print", NM = "_ZNK4llvm3opt3Arg5printERNS_11raw_ostreamE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg5printERNS_11raw_ostreamE")
//</editor-fold>
  public void print(raw_ostream /*&*/ O) /*const*/ {
    O.$out(/*KEEP_STR*/$LT);

    O.$out(/*KEEP_STR*/" Opt:");
    Opt.print(O);

    O.$out(/*KEEP_STR*/" Index:").$out_uint(Index);

    O.$out(/*KEEP_STR*/" Values: [");
    for (/*uint*/int i = 0, e = Values.size(); i != e; ++i) {
      if ((i != 0)) {
        O.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      O.$out(/*KEEP_STR*/$SGL_QUOTE).$out(Values.$at(i)).$out(/*KEEP_STR*/$SGL_QUOTE);
    }

    O.$out(/*KEEP_STR*/"]>\n");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::dump">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 64,
          old_source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", old_line = 47,
          FQN = "llvm::opt::Arg::dump", NM = "_ZNK4llvm3opt3Arg4dumpEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg4dumpEv")
//</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }
  
  /// \brief Return a formatted version of the argument and
  /// its values, for debugging and diagnostics.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::Arg::getAsString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", line = 66,
   old_source = "${LLVM_SRC}/llvm/lib/Option/Arg.cpp", old_line = 64,
   FQN = "llvm::opt::Arg::getAsString", NM = "_ZNK4llvm3opt3Arg11getAsStringERKNS0_7ArgListE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZNK4llvm3opt3Arg11getAsStringERKNS0_7ArgListE")
  //</editor-fold>
  public std.string getAsString(/*const*/ArgList /*&*/ Args) /*const*/ {
    raw_svector_ostream OS = null;
    ArgStringList ASL/*J*/= new ArgStringList();
    try {
      SmallString/*256*/ Res/*J*/= new SmallString(256);
      OS/*J*/= new raw_svector_ostream(Res);
      
      render(Args, ASL);
      for (type$ptr<char$ptr>  it = $tryClone(ASL.begin()), ie = $tryClone(ASL.end()); it.$noteq(ie); it.$preInc()) {
        if (it.$noteq(ASL.begin())) {
          OS.$out_char($$SPACE);
        }
        OS.$out(it.$star());
      }
      
      return OS.str().$string();
    } finally {
      if (ASL != null) { ASL.$destroy(); }
      if (OS != null) { OS.$destroy(); }
    }
  }

  @Override
  public String toString() {
    return "Arg{" + "Opt=" + Opt + ", BaseArg=" + BaseArg + 
            "\n, Spelling=" + Spelling.toJavaString() + ", Index=" + Index + ", Claimed=" + Claimed + 
            "\n, OwnsValues=" + OwnsValues + ", Values=" + Values + '}';
  }
}
