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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.option.*;

//<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 315,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 299,
 FQN="llvm::opt::InputArgList", NM="_ZN4llvm3opt12InputArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12InputArgListE")
//</editor-fold>
public final class InputArgList extends /*public*/ ArgList implements Destructors.ClassWithDestructor {
/*private:*/
  /// List of argument strings used by the contained Args.
  ///
  /// This is mutable since we treat the ArgList as being the list
  /// of Args, and allow routines to add new strings (to have a
  /// convenient place to store the memory) via MakeIndex.
  private /*mutable */ArgStringList ArgStrings;
  
  /// Strings for synthesized arguments.
  ///
  /// This is mutable since we treat the ArgList as being the list
  /// of Args, and allow routines to add new strings (to have a
  /// convenient place to store the memory) via MakeIndex.
  private /*mutable */std.list<std.string> SynthesizedStrings;
  
  /// The number of original input argument strings.
  private /*uint*/int NumInputArgStrings;
  
  /// Release allocated arguments.
  
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 343,
   FQN="llvm::opt::InputArgList::releaseMemory", NM="_ZN4llvm3opt12InputArgList13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12InputArgList13releaseMemoryEv")
  //</editor-fold>
  private void releaseMemory() {
    // An InputArgList always owns its arguments.
    for (Arg /*P*/ A : /*Deref*/this)  {
      if (A != null) { A.$destroy();};
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::InputArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 349,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 306,
   FQN="llvm::opt::InputArgList::InputArgList", NM="_ZN4llvm3opt12InputArgListC1EPKPKcS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12InputArgListC1EPKPKcS5_")
  //</editor-fold>
  public InputArgList(/*const*/type$ptr<char$ptr>/*char P const P*/ ArgBegin, 
      /*const*/type$ptr<char$ptr>/*char P const P*/ ArgEnd) {
    /* : ArgList(), ArgStrings(), SynthesizedStrings(), NumInputArgStrings(ArgEnd - ArgBegin)*/ 
    //START JInit
    super();
    this.ArgStrings = new ArgStringList();
    this.SynthesizedStrings = new std.list<std.string>(new std.string());
    this.NumInputArgStrings = ArgEnd.$sub(ArgBegin);
    //END JInit
    ArgStrings.append_T(ArgBegin, ArgEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::InputArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 339,
   FQN="llvm::opt::InputArgList::InputArgList", NM="_ZN4llvm3opt12InputArgListC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12InputArgListC1EOS1_")
  //</editor-fold>
  public InputArgList(JD$Move _dparam, InputArgList /*&&*/RHS) {
    /* : ArgList(std::move(RHS)), ArgStrings(std::move(RHS.ArgStrings)), SynthesizedStrings(std::move(RHS.SynthesizedStrings)), NumInputArgStrings(RHS.NumInputArgStrings)*/ 
    //START JInit
    super(JD$Move.INSTANCE, std.move(RHS));
    this.ArgStrings = new ArgStringList(JD$Move.INSTANCE, std.move(RHS.ArgStrings));
    this.SynthesizedStrings = new std.list<std.string>(JD$Move.INSTANCE, std.move(RHS.SynthesizedStrings));
    this.NumInputArgStrings = RHS.NumInputArgStrings;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 343,
   FQN="llvm::opt::InputArgList::operator=", NM="_ZN4llvm3opt12InputArgListaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12InputArgListaSEOS1_")
  //</editor-fold>
  public InputArgList /*&*/ $assignMove(InputArgList /*&&*/RHS) {
    releaseMemory();
    super.$assignMove(std.move(RHS));
    ArgStrings.$assignMove(std.move(RHS.ArgStrings));
    SynthesizedStrings.$assignMove(std.move(RHS.SynthesizedStrings));
    NumInputArgStrings = RHS.NumInputArgStrings;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::~InputArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 351,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 312,
   FQN="llvm::opt::InputArgList::~InputArgList", NM="_ZN4llvm3opt12InputArgListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12InputArgListD0Ev")
  //</editor-fold>
  public void $destroy() {
    releaseMemory();
    //START JDestroy
    SynthesizedStrings.$destroy();
    ArgStrings.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::getArgString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 353,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 322,
   FQN="llvm::opt::InputArgList::getArgString", NM="_ZNK4llvm3opt12InputArgList12getArgStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12InputArgList12getArgStringEj")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getArgString(/*uint*/int Index) /*const*//* override*/ {
    return ArgStrings.$at(Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::getNumInputArgStrings">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 357,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 326,
   FQN="llvm::opt::InputArgList::getNumInputArgStrings", NM="_ZNK4llvm3opt12InputArgList21getNumInputArgStringsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12InputArgList21getNumInputArgStringsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumInputArgStrings() /*const*//* override*/ {
    return NumInputArgStrings;
  }

/*public:*/
  /// MakeIndex - Get an index for the given string(s).
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::MakeIndex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 355,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 318,
   FQN="llvm::opt::InputArgList::MakeIndex", NM="_ZNK4llvm3opt12InputArgList9MakeIndexENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12InputArgList9MakeIndexENS_9StringRefE")
  //</editor-fold>
  public /*uint*/int MakeIndex(StringRef String0) /*const*/ {
    /*uint*/int Index = ArgStrings.size();
    
    // Tuck away so we have a reliable const char *.
    SynthesizedStrings.push_back(String0.$string());
    ArgStrings.push_back(SynthesizedStrings.back().c_str());
    
    return Index;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::MakeIndex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 365,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 328,
   FQN="llvm::opt::InputArgList::MakeIndex", NM="_ZNK4llvm3opt12InputArgList9MakeIndexENS_9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12InputArgList9MakeIndexENS_9StringRefES2_")
  //</editor-fold>
  public /*uint*/int MakeIndex(StringRef String0, 
           StringRef String1) /*const*/ {
    /*uint*/int Index0 = MakeIndex(/*NO_COPY*/String0);
    /*uint*/int Index1 = MakeIndex(/*NO_COPY*/String1);
    assert (Index0 + 1 == Index1) : "Unexpected non-consecutive indices!";
    //(void)Index1;
    return Index0;
  }

  
  //JAVA: using ArgList::MakeArgString;
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::InputArgList::MakeArgStringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 374,
   FQN="llvm::opt::InputArgList::MakeArgStringRef", NM="_ZNK4llvm3opt12InputArgList16MakeArgStringRefENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12InputArgList16MakeArgStringRefENS_9StringRefE")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ MakeArgStringRef(StringRef Str) /*const*//* override*/ {
    return getArgString(MakeIndex(/*NO_COPY*/Str));
  }

  
  public String toString() {
    return "" + "ArgStrings=" + ArgStrings // NOI18N
              + ", SynthesizedStrings=" + SynthesizedStrings // NOI18N
              + ", NumInputArgStrings=" + NumInputArgStrings // NOI18N
              + super.toString(); // NOI18N
  }
/// @}
}
