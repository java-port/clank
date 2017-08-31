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

package org.clang.tooling.core.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.tooling.core.*;

// Represents a merged replacement, i.e. a replacement consisting of multiple
// overlapping replacements from 'First' and 'Second' in mergeReplacements.
//
// Position projection:
// Offsets and lengths of the replacements can generally refer to two different
// coordinate spaces. Replacements from 'First' refer to the original text
// whereas replacements from 'Second' refer to the text after applying 'First'.
//
// MergedReplacement always operates in the coordinate space of the original
// text, i.e. transforms elements from 'Second' to take into account what was
// changed based on the elements from 'First'.
//
// We can correctly calculate this projection as we look at the replacements in
// order of strictly increasing offsets.
//
// Invariants:
// * We always merge elements from 'First' into elements from 'Second' and vice
//   versa. Within each set, the replacements are non-overlapping.
// * We only extend to the right, i.e. merge elements with strictly increasing
//   offsets.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 355,
 FQN="clang::tooling::(anonymous namespace)::MergedReplacement", NM="_ZN5clang7tooling12_GLOBAL__N_117MergedReplacementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_117MergedReplacementE")
//</editor-fold>
public class MergedReplacement implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::MergedReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 357,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::MergedReplacement", NM="_ZN5clang7tooling12_GLOBAL__N_117MergedReplacementC1ERKNS0_11ReplacementEbi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_117MergedReplacementC1ERKNS0_11ReplacementEbi")
  //</editor-fold>
  public MergedReplacement(final /*const*/ Replacement /*&*/ R, boolean MergeSecond, int D) {
    // : MergeSecond(MergeSecond), Delta(D), FilePath(R.getFilePath()), Offset(R.getOffset() + (MergeSecond ? 0 : Delta)), Length(R.getLength()), Text(R.getReplacementText().operator basic_string()) 
    //START JInit
    this.MergeSecond = MergeSecond;
    this.Delta = D;
    this.FilePath = R.getFilePath();
    this.Offset = R.getOffset() + (MergeSecond ? 0 : Delta);
    this.Length = R.getLength();
    this.Text = R.getReplacementText().$string();
    //END JInit
    Delta += MergeSecond ? 0 : Text.size() - Length;
    DeltaFirst = MergeSecond ? Text.size() - Length : 0;
  }

  
  // Merges the next element 'R' into this merged element. As we always merge
  // from 'First' into 'Second' or vice versa, the MergedReplacement knows what
  // set the next element is coming from.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::merge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 368,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::merge", NM="_ZN5clang7tooling12_GLOBAL__N_117MergedReplacement5mergeERKNS0_11ReplacementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_117MergedReplacement5mergeERKNS0_11ReplacementE")
  //</editor-fold>
  public void merge(final /*const*/ Replacement /*&*/ R) {
    if (MergeSecond) {
      /*uint*/int REnd = R.getOffset() + Delta + R.getLength();
      /*uint*/int End = Offset + Text.size();
      if ($greater_uint(REnd, End)) {
        Length += REnd - End;
        MergeSecond = false;
      }
      StringRef TextRef = new StringRef(Text);
      StringRef Head = TextRef.substr(0, R.getOffset() + Delta - Offset);
      StringRef Tail = TextRef.substr(REnd - Offset);
      Text.$assignMove(($add_Twine$C($add_Twine$C(new Twine(Head), new Twine(R.getReplacementText())), new Twine(Tail))).str());
      Delta += R.getReplacementText().size() - R.getLength();
    } else {
      /*uint*/int End = Offset + Length;
      StringRef RText = R.getReplacementText();
      StringRef Tail = RText.substr(End - R.getOffset());
      Text.$assignMove(($add_Twine$C(new Twine(Text), new Twine(Tail))).str());
      if ($greater_uint(R.getOffset() + RText.size(), End)) {
        Length = R.getOffset() + R.getLength() - Offset;
        MergeSecond = true;
      } else {
        Length += R.getLength() - RText.size();
      }
      DeltaFirst += RText.size() - R.getLength();
    }
  }

  
  // Returns 'true' if 'R' starts strictly after the MergedReplacement and thus
  // doesn't need to be merged.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::endsBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 398,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::endsBefore", NM="_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement10endsBeforeERKNS0_11ReplacementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement10endsBeforeERKNS0_11ReplacementE")
  //</editor-fold>
  public boolean endsBefore(final /*const*/ Replacement /*&*/ R) /*const*/ {
    if (MergeSecond) {
      return $less_uint(Offset + Text.size(), R.getOffset() + Delta);
    }
    return $less_uint(Offset + Length, R.getOffset());
  }

  
  // Returns 'true' if an element from the second set should be merged next.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::mergeSecond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 405,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::mergeSecond", NM="_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement11mergeSecondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement11mergeSecondEv")
  //</editor-fold>
  public boolean mergeSecond() /*const*/ {
    return MergeSecond;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::deltaFirst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 406,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::deltaFirst", NM="_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement10deltaFirstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement10deltaFirstEv")
  //</editor-fold>
  public int deltaFirst() /*const*/ {
    return DeltaFirst;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::asReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 407,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::asReplacement", NM="_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement13asReplacementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling12_GLOBAL__N_117MergedReplacement13asReplacementEv")
  //</editor-fold>
  public Replacement asReplacement() /*const*/ {
    return /*{ */new Replacement(new StringRef(FilePath), Offset, Length, new StringRef(Text))/* }*/;
  }

/*private:*/
  private boolean MergeSecond;
  
  // Amount of characters that elements from 'Second' need to be shifted by in
  // order to refer to the original text.
  private int Delta;
  
  // Sum of all deltas (text-length - length) of elements from 'First' merged
  // into this element. This is used to update 'Delta' once the
  // MergedReplacement is completed.
  private int DeltaFirst;
  
  // Data of the actually merged replacement. FilePath and Offset aren't changed
  // as the element is only extended to the right.
  private /*const*/ StringRef FilePath;
  private /*const*//*uint*/int Offset;
  private /*uint*/int Length;
  private std.string Text;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::MergedReplacement::~MergedReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 355,
   FQN="clang::tooling::(anonymous namespace)::MergedReplacement::~MergedReplacement", NM="_ZN5clang7tooling12_GLOBAL__N_117MergedReplacementD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_117MergedReplacementD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Text.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "MergeSecond=" + MergeSecond // NOI18N
              + ", Delta=" + Delta // NOI18N
              + ", DeltaFirst=" + DeltaFirst // NOI18N
              + ", FilePath=" + FilePath // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", Length=" + Length // NOI18N
              + ", Text=" + Text; // NOI18N
  }
}
