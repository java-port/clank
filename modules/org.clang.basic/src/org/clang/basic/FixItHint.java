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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Annotates a diagnostic with some code that should be
/// inserted, removed, or replaced to fix the problem.
///
/// This kind of hint should be used when we are certain that the
/// introduction, removal, or modification of a particular (small!)
/// amount of code will correct a compilation error. The compiler
/// should also provide full recovery from such errors, such that
/// suppressing the diagnostic output can still result in successful
/// compilation.
//<editor-fold defaultstate="collapsed" desc="clang::FixItHint">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 52,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 51,
 FQN="clang::FixItHint", NM="_ZN5clang9FixItHintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintE")
//</editor-fold>
public class FixItHint implements Destructors.ClassWithDestructor, Native.NativePOD<FixItHint>, NativeMoveable<FixItHint> {
/*public:*/
  /// \brief Code that should be replaced to correct the error. Empty for an
  /// insertion hint.
  public CharSourceRange RemoveRange;
  
  /// \brief Code in the specific range that should be inserted in the insertion
  /// location.
  public CharSourceRange InsertFromRange;
  
  /// \brief The actual code to insert at the insertion location, as a
  /// string.
  public std.string CodeToInsert;
  
  public boolean BeforePreviousInsertions;
  
  /// \brief Empty code modification hint, indicating that no code
  /// modification is known.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::FixItHint">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 69,
   FQN="clang::FixItHint::FixItHint", NM="_ZN5clang9FixItHintC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintC1Ev")
  //</editor-fold>
  public FixItHint() {
    /* : RemoveRange(), InsertFromRange(), CodeToInsert(), BeforePreviousInsertions(false)*/ 
    //START JInit
    this.RemoveRange = new CharSourceRange();
    this.InsertFromRange = new CharSourceRange();
    this.CodeToInsert = new std.string();
    this.BeforePreviousInsertions = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::isNull">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 72,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 71,
   FQN="clang::FixItHint::isNull", NM="_ZNK5clang9FixItHint6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang9FixItHint6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return !RemoveRange.isValid();
  }

  
  /// \brief Create a code modification hint that inserts the given
  /// code string at a specific location.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateInsertion">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 77,
   FQN="clang::FixItHint::CreateInsertion", NM="_ZN5clang9FixItHint15CreateInsertionENS_14SourceLocationEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint15CreateInsertionENS_14SourceLocationEN4llvm9StringRefEb")
  //</editor-fold>
  public static FixItHint CreateInsertion(SourceLocation InsertionLoc, 
                 StringRef Code) {
    return CreateInsertion(InsertionLoc.getRawEncoding(), 
                 Code, 
                 false);
  }
  public static FixItHint CreateInsertion(SourceLocation InsertionLoc, 
                 StringRef Code, 
                 boolean BeforePreviousInsertions/*= false*/) {
    return CreateInsertion(InsertionLoc.getRawEncoding(), 
                 Code, 
                 BeforePreviousInsertions);
  }
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateInsertion">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 77,
   FQN="clang::FixItHint::CreateInsertion", NM="_ZN5clang9FixItHint15CreateInsertionENS_14SourceLocationEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint15CreateInsertionENS_14SourceLocationEN4llvm9StringRefEb")
  //</editor-fold>  
  public static FixItHint CreateInsertion(/*SourceLocation*/int InsertionLoc, 
                 StringRef Code) {
    return CreateInsertion(InsertionLoc, 
                 Code, 
                 false);
  }
  public static FixItHint CreateInsertion(/*SourceLocation*/int InsertionLoc, 
                 StringRef Code, 
                 boolean BeforePreviousInsertions/*= false*/) {
    FixItHint Hint/*J*/= new FixItHint();
    Hint.RemoveRange.$assignMove(
        CharSourceRange.getCharRange(/*NO_COPY*/InsertionLoc, /*NO_COPY*/InsertionLoc)
    );
    Hint.CodeToInsert.$assignMove(Code.$string());
    Hint.BeforePreviousInsertions = BeforePreviousInsertions;
    return Hint;
  }

  
  /// \brief Create a code modification hint that inserts the given
  /// code from \p FromRange at a specific location.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateInsertionFromRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 90,
   FQN="clang::FixItHint::CreateInsertionFromRange", NM="_ZN5clang9FixItHint24CreateInsertionFromRangeENS_14SourceLocationENS_15CharSourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint24CreateInsertionFromRangeENS_14SourceLocationENS_15CharSourceRangeEb")
  //</editor-fold>
  public static FixItHint CreateInsertionFromRange(SourceLocation InsertionLoc, 
                          CharSourceRange FromRange) {
    return CreateInsertionFromRange(InsertionLoc, 
                          FromRange, 
                          false);
  }
  public static FixItHint CreateInsertionFromRange(SourceLocation InsertionLoc, 
                          CharSourceRange FromRange, 
                          boolean BeforePreviousInsertions/*= false*/) {
    FixItHint Hint/*J*/= new FixItHint();
    Hint.RemoveRange.$assignMove(CharSourceRange.getCharRange(/*NO_COPY*/InsertionLoc, /*NO_COPY*/InsertionLoc));
    Hint.InsertFromRange.$assign(FromRange);
    Hint.BeforePreviousInsertions = BeforePreviousInsertions;
    return Hint;
  }

  
  /// \brief Create a code modification hint that removes the given
  /// source range.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateRemoval">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 103,
   FQN="clang::FixItHint::CreateRemoval", NM="_ZN5clang9FixItHint13CreateRemovalENS_15CharSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint13CreateRemovalENS_15CharSourceRangeE")
  //</editor-fold>
  public static FixItHint CreateRemoval(CharSourceRange RemoveRange) {
    FixItHint Hint/*J*/= new FixItHint();
    Hint.RemoveRange.$assign(RemoveRange);
    return Hint;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateRemoval">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 108,
   FQN="clang::FixItHint::CreateRemoval", NM="_ZN5clang9FixItHint13CreateRemovalENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint13CreateRemovalENS_11SourceRangeE")
  //</editor-fold>
  public static FixItHint CreateRemoval(SourceRange RemoveRange) {
    return CreateRemoval(CharSourceRange.getTokenRange(/*NO_COPY*/RemoveRange));
  }

  
  /// \brief Create a code modification hint that replaces the given
  /// source range with the given code string.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateReplacement">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 114,
   FQN="clang::FixItHint::CreateReplacement", NM="_ZN5clang9FixItHint17CreateReplacementENS_15CharSourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint17CreateReplacementENS_15CharSourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  public static FixItHint CreateReplacement(CharSourceRange RemoveRange, 
                   StringRef Code) {
    FixItHint Hint/*J*/= new FixItHint();
    Hint.RemoveRange.$assign(RemoveRange);
    Hint.CodeToInsert.$assignMove(Code.$string());
    return Hint;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::CreateReplacement">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 122,
   FQN="clang::FixItHint::CreateReplacement", NM="_ZN5clang9FixItHint17CreateReplacementENS_11SourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHint17CreateReplacementENS_11SourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  public static FixItHint CreateReplacement(SourceRange RemoveRange, 
                   StringRef Code) {
    return CreateReplacement(CharSourceRange.getTokenRange(/*NO_COPY*/RemoveRange), /*NO_COPY*/Code);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::FixItHint">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 51,
   FQN="clang::FixItHint::FixItHint", NM="_ZN5clang9FixItHintC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FixItHint(/*const*/ FixItHint /*&*/ $Prm0) {
    /* : RemoveRange(.RemoveRange), InsertFromRange(.InsertFromRange), CodeToInsert(.CodeToInsert), BeforePreviousInsertions(.BeforePreviousInsertions)*/ 
    //START JInit
    this.RemoveRange = new CharSourceRange($Prm0.RemoveRange);
    this.InsertFromRange = new CharSourceRange($Prm0.InsertFromRange);
    this.CodeToInsert = new std.string($Prm0.CodeToInsert);
    this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::FixItHint">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 51,
   FQN="clang::FixItHint::FixItHint", NM="_ZN5clang9FixItHintC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintC1EOS0_")
  //</editor-fold>
  public /*inline*/ FixItHint(JD$Move _dparam, FixItHint /*&&*/$Prm0) {
    /* : RemoveRange(static_cast<FixItHint &&>().RemoveRange), InsertFromRange(static_cast<FixItHint &&>().InsertFromRange), CodeToInsert(static_cast<FixItHint &&>().CodeToInsert), BeforePreviousInsertions(static_cast<FixItHint &&>().BeforePreviousInsertions)*/ 
    //START JInit
    this.RemoveRange = new CharSourceRange(JD$Move.INSTANCE, $Prm0.RemoveRange);
    this.InsertFromRange = new CharSourceRange(JD$Move.INSTANCE, $Prm0.InsertFromRange);
    this.CodeToInsert = new std.string(JD$Move.INSTANCE, $Prm0.CodeToInsert);
    this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 51,
   FQN="clang::FixItHint::operator=", NM="_ZN5clang9FixItHintaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintaSERKS0_")
  //</editor-fold>
  public /*inline*/ FixItHint /*&*/ $assign(/*const*/ FixItHint /*&*/ $Prm0) {
    this.RemoveRange.$assign($Prm0.RemoveRange);
    this.InsertFromRange.$assign($Prm0.InsertFromRange);
    this.CodeToInsert.$assign($Prm0.CodeToInsert);
    this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 51,
   FQN="clang::FixItHint::operator=", NM="_ZN5clang9FixItHintaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintaSEOS0_")
  //</editor-fold>
  public /*inline*/ FixItHint /*&*/ $assignMove(FixItHint /*&&*/$Prm0) {
    this.RemoveRange.$assignMove($Prm0.RemoveRange);
    this.InsertFromRange.$assignMove($Prm0.InsertFromRange);
    this.CodeToInsert.$assignMove($Prm0.CodeToInsert);
    this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItHint::~FixItHint">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 51,
   FQN="clang::FixItHint::~FixItHint", NM="_ZN5clang9FixItHintD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang9FixItHintD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CodeToInsert.$destroy();
    //END JDestroy
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
  public FixItHint clone() {
    return new FixItHint(this);
  }
  
  @Override public FixItHint move() {
    return new FixItHint(JD$Move.INSTANCE, this);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public boolean $eq(FixItHint other) {
    if (this.BeforePreviousInsertions != other.BeforePreviousInsertions) {
      return false;
    }
    if (!this.RemoveRange.$eq(other.RemoveRange)) {
      return false;
    }
    if (!this.InsertFromRange.$eq(other.InsertFromRange)) {
      return false;
    }
    if (!this.CodeToInsert.$eq(other.CodeToInsert)) {
      return false;
    }
    return true;
  }
  
  public String toString() {
    return "" + "RemoveRange=" + RemoveRange // NOI18N
              + ", InsertFromRange=" + InsertFromRange // NOI18N
              + ", CodeToInsert=" + CodeToInsert // NOI18N
              + ", BeforePreviousInsertions=" + BeforePreviousInsertions; // NOI18N
  }
}
