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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// DerivedArgList - An ordered collection of driver arguments,
/// whose storage may be in another argument list.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 377,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 346,
 FQN = "llvm::opt::DerivedArgList", NM = "_ZN4llvm3opt14DerivedArgListE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgListE")
//</editor-fold>
public class DerivedArgList extends /*public*/ ArgList implements Destructors.ClassWithDestructor {
  private /*const*/InputArgList /*&*/ BaseArgs;
  
  /// The list of arguments we synthesized.
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 350,
   FQN = "llvm::opt::DerivedArgList::SynthesizedArgs", NM = "_ZN4llvm3opt14DerivedArgList15SynthesizedArgsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgList15SynthesizedArgsE")
  private /*mutable */SmallVector<std.unique_ptr<Arg>/*, 16*/> SynthesizedArgs;
/*public:*/
/// Construct a new derived arg list from \p BaseArgs.

//
//<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::DerivedArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 380,
          old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 343,
          FQN = "llvm::opt::DerivedArgList::DerivedArgList", NM = "_ZN4llvm3opt14DerivedArgListC1ERKNS0_12InputArgListE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgListC1ERKNS0_12InputArgListE")
//</editor-fold>
  public DerivedArgList(/*const*/InputArgList /*&*/ BaseArgs) {
    /* : ArgList(), BaseArgs(BaseArgs), SynthesizedArgs()*/
    //START JInit
    super();
    this./*&*/BaseArgs =/*&*/ BaseArgs;
    this.SynthesizedArgs = new SmallVector<std.unique_ptr<Arg>>(16, new std.unique_ptr<Arg>((Arg) null));
    //END JInit
  }

  /// DerivedArgList - An ordered collection of driver arguments,
  /// whose storage may be in another argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::~DerivedArgList">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 377,
            old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 347,
            FQN = "llvm::opt::DerivedArgList::~DerivedArgList", NM = "_ZN4llvm3opt14DerivedArgListD0Ev",
            cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN4llvm3opt14DerivedArgListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SynthesizedArgs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::getArgString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 387,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 357,
   FQN = "llvm::opt::DerivedArgList::getArgString", NM = "_ZNK4llvm3opt14DerivedArgList12getArgStringEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList12getArgStringEj")
  //</editor-fold>
  @Override public /*virtual*/ /*const*/char$ptr/*char P*/ getArgString(/*uint*/int Index) /*const*/ {
    return BaseArgs.getArgString(Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::getNumInputArgStrings">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 391,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 361,
   FQN = "llvm::opt::DerivedArgList::getNumInputArgStrings", NM = "_ZNK4llvm3opt14DerivedArgList21getNumInputArgStringsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList21getNumInputArgStringsEv")
  //</editor-fold>
  @Override public /*virtual*/ /*uint*/int getNumInputArgStrings() /*const*/ {
    return BaseArgs.getNumInputArgStrings();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::getBaseArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 365,
   FQN = "llvm::opt::DerivedArgList::getBaseArgs", NM = "_ZNK4llvm3opt14DerivedArgList11getBaseArgsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList11getBaseArgsEv")
  //</editor-fold>
  public /*const*/InputArgList /*&*/ getBaseArgs() /*const*/ {
    return BaseArgs;
  }

  
  /// @name Arg Synthesis
  /// @{
  
  /// AddSynthesizedArg - Add a argument to the list of synthesized arguments
  /// (to be freed).
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::AddSynthesizedArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 387,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 353,
   FQN = "llvm::opt::DerivedArgList::AddSynthesizedArg", NM = "_ZN4llvm3opt14DerivedArgList17AddSynthesizedArgEPNS0_3ArgE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgList17AddSynthesizedArgEPNS0_3ArgE")
  //</editor-fold>
  public void AddSynthesizedArg(Arg /*P*/ A) {
    SynthesizedArgs.push_back_T$RR(new std.unique_ptr<Arg>(A));
  }

  
  //JAVA: using ArgList::MakeArgString;
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::MakeArgStringRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 383,
   FQN="llvm::opt::DerivedArgList::MakeArgStringRef", NM="_ZNK4llvm3opt14DerivedArgList16MakeArgStringRefENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList16MakeArgStringRefENS_9StringRefE")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ MakeArgStringRef(StringRef Str) /*const*//* override*/ {
    return BaseArgs.MakeArgString(Str);
  }

  
  /// AddFlagArg - Construct a new FlagArg for the given option \p Id and
  /// append it to the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::AddFlagArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 411,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 381,
   FQN = "llvm::opt::DerivedArgList::AddFlagArg", NM = "_ZN4llvm3opt14DerivedArgList10AddFlagArgEPKNS0_3ArgENS0_6OptionE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgList10AddFlagArgEPKNS0_3ArgENS0_6OptionE")
  //</editor-fold>
  public void AddFlagArg(/*const*/Arg /*P*/ BaseArg, /*const*/Option Opt) {
    append(MakeFlagArg(BaseArg, Opt));
  }

  
  /// AddPositionalArg - Construct a new Positional arg for the given option
  /// \p Id, with the provided \p Value and append it to the argument
  /// list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::AddPositionalArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 418,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 388,
   FQN = "llvm::opt::DerivedArgList::AddPositionalArg", NM = "_ZN4llvm3opt14DerivedArgList16AddPositionalArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgList16AddPositionalArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE")
  //</editor-fold>
  public void AddPositionalArg(/*const*/Arg /*P*/ BaseArg, /*const*/Option Opt, StringRef Value) {
    append(MakePositionalArg(BaseArg, Opt, Value));
  }

  
  /// AddSeparateArg - Construct a new Positional arg for the given option
  /// \p Id, with the provided \p Value and append it to the argument
  /// list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::AddSeparateArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 427,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 397,
   FQN = "llvm::opt::DerivedArgList::AddSeparateArg", NM = "_ZN4llvm3opt14DerivedArgList14AddSeparateArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgList14AddSeparateArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE")
  //</editor-fold>
  public void AddSeparateArg(/*const*/Arg /*P*/ BaseArg, /*const*/Option Opt, StringRef Value) {
    append(MakeSeparateArg(BaseArg, Opt, Value));
  }

  
  /// AddJoinedArg - Construct a new Positional arg for the given option
  /// \p Id, with the provided \p Value and append it to the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::AddJoinedArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 435,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 405,
   FQN = "llvm::opt::DerivedArgList::AddJoinedArg", NM = "_ZN4llvm3opt14DerivedArgList12AddJoinedArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt14DerivedArgList12AddJoinedArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE")
  //</editor-fold>
  public void AddJoinedArg(/*const*/Arg /*P*/ BaseArg, /*const*/Option Opt, StringRef Value) {
    append(MakeJoinedArg(BaseArg, Opt, Value));
  }

  
  /// MakeFlagArg - Construct a new FlagArg for the given option \p Id.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::MakeFlagArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 391,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 357,
   FQN = "llvm::opt::DerivedArgList::MakeFlagArg", NM = "_ZNK4llvm3opt14DerivedArgList11MakeFlagArgEPKNS0_3ArgENS0_6OptionE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList11MakeFlagArgEPKNS0_3ArgENS0_6OptionE")
  //</editor-fold>
  public Arg /*P*/ MakeFlagArg(/*const*/ Arg /*P*/ BaseArg, /*const*/ Option Opt) /*const*/ {
    SynthesizedArgs.push_back_T$RR(std.make_unique(new Arg(Opt, new StringRef(MakeArgString($add_Twine(new /*const*/ Twine(Opt.getPrefix()), new /*const*/ Twine(Opt.getName())))), 
            BaseArgs.MakeIndex(Opt.getName()), BaseArg)));
    return SynthesizedArgs.back().get();
  }

  
/// MakePositionalArg - Construct a new Positional arg for the
/// given option \p Id, with the provided \p Value.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::MakePositionalArg">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 398,
 old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 364,
 FQN = "llvm::opt::DerivedArgList::MakePositionalArg", NM = "_ZNK4llvm3opt14DerivedArgList17MakePositionalArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList17MakePositionalArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE")
//</editor-fold>
public Arg /*P*/ MakePositionalArg(/*const*/ Arg /*P*/ BaseArg, /*const*/ Option Opt, 
                 StringRef Value) /*const*/ {
  /*uint*/int Index = BaseArgs.MakeIndex(Value);
  SynthesizedArgs.push_back_T$RR(std.make_unique(new Arg(Opt, new StringRef(MakeArgString($add_Twine(new /*const*/ Twine(Opt.getPrefix()), new /*const*/ Twine(Opt.getName())))), 
          Index, BaseArgs.getArgString(Index), BaseArg)));
  return SynthesizedArgs.back().get();
}

  
/// MakeSeparateArg - Construct a new Positional arg for the
/// given option \p Id, with the provided \p Value.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::MakeSeparateArg">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 407,
 old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 373,
 FQN = "llvm::opt::DerivedArgList::MakeSeparateArg", NM = "_ZNK4llvm3opt14DerivedArgList15MakeSeparateArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList15MakeSeparateArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE")
//</editor-fold>
public Arg /*P*/ MakeSeparateArg(/*const*/ Arg /*P*/ BaseArg, /*const*/ Option Opt, 
               StringRef Value) /*const*/ {
  /*uint*/int Index = BaseArgs.MakeIndex(Opt.getName(), Value);
  SynthesizedArgs.push_back_T$RR(std.make_unique(new Arg(Opt, new StringRef(MakeArgString($add_Twine(new /*const*/ Twine(Opt.getPrefix()), new /*const*/ Twine(Opt.getName())))), 
          Index, BaseArgs.getArgString(Index + 1), BaseArg)));
  return SynthesizedArgs.back().get();
}

  
  /// MakeJoinedArg - Construct a new Positional arg for the
  /// given option \p Id, with the provided \p Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::MakeJoinedArg">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 416,
            old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 382,
            FQN = "llvm::opt::DerivedArgList::MakeJoinedArg", NM = "_ZNK4llvm3opt14DerivedArgList13MakeJoinedArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE",
            cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt14DerivedArgList13MakeJoinedArgEPKNS0_3ArgENS0_6OptionENS_9StringRefE")
  //</editor-fold>
  public Arg /*P*/ MakeJoinedArg(/*const*/Arg /*P*/ BaseArg, /*const*/ Option Opt,
                  StringRef Value) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/
      int Index = BaseArgs.MakeIndex(new StringRef(($add_Twine(new Twine(Opt.getName()), new Twine(Value))).str()));
      SynthesizedArgs.push_back_T$RR($c$.track(llvm.make_unique(new Arg(Opt, new StringRef(MakeArgString($add_Twine(new Twine(Opt.getPrefix()), new Twine(Opt.getName())))), Index,
              BaseArgs.getArgString(Index).$add(Opt.getName().size()), BaseArg))));
      $c$.clean();
      return SynthesizedArgs.back().get();
    } finally {
      $c$.$destroy();
    }
  }


  /// DerivedArgList - An ordered collection of driver arguments,
  /// whose storage may be in another argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::DerivedArgList::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 377,
            FQN = "llvm::opt::DerivedArgList::operator=", NM = "_ZN4llvm3opt14DerivedArgListaSEOS1_",
            cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp -nm=_ZN4llvm3opt14DerivedArgListaSEOS1_")
  //</editor-fold>
  public /*inline*/ DerivedArgList /*&*/ $assignMove(DerivedArgList /*&&*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

/// @}
  @Override
  public String toString() {
    return "DerivedArgList{" + "BaseArgs=" + BaseArgs + ", SynthesizedArgs=" + SynthesizedArgs + "\nsuper=" + super.toString() + '}';
  }    
}
