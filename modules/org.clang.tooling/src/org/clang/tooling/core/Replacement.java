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

package org.clang.tooling.core;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.rewrite.core.*;
import org.clang.tooling.core.*;
import static org.clang.tooling.impl.ToolingStatics.InvalidLocation;
import static org.clang.tooling.impl.ToolingStatics.getRangeSize;


/// \brief A text replacement.
///
/// Represents a SourceManager independent replacement of a range of text in a
/// specific file.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 77,
 FQN="clang::tooling::Replacement", NM="_ZN5clang7tooling11ReplacementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang7tooling11ReplacementE")
//</editor-fold>
public class Replacement implements Destructors.ClassWithDestructor, Native.ComparableLower {
/*public:*/
  /// \brief Creates an invalid (not applicable) replacement.
  /// \brief Creates an invalid (not applicable) replacement.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 32,
   FQN="clang::tooling::Replacement::Replacement", NM="_ZN5clang7tooling11ReplacementC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11ReplacementC1Ev")
  //</editor-fold>
  public Replacement() {
    // : FilePath(InvalidLocation), ReplacementRange(), ReplacementText() 
    //START JInit
    this.FilePath = new std.string(JD$T$C$P_T2$C$R.INSTANCE, InvalidLocation);
    this.ReplacementRange = new Range();
    this.ReplacementText = new std.string();
    //END JInit
  }


  
  /// \brief Creates a replacement of the range [Offset, Offset+Length) in
  /// FilePath with ReplacementText.
  ///
  /// \param FilePath A source file accessible via a SourceManager.
  /// \param Offset The byte offset of the start of the range in the file.
  /// \param Length The length of the range in bytes.
  
  /// \brief Creates a replacement of the range [Offset, Offset+Length) in
  /// FilePath with ReplacementText.
  ///
  /// \param FilePath A source file accessible via a SourceManager.
  /// \param Offset The byte offset of the start of the range in the file.
  /// \param Length The length of the range in bytes.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 35,
   FQN="clang::tooling::Replacement::Replacement", NM="_ZN5clang7tooling11ReplacementC1EN4llvm9StringRefEjjS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11ReplacementC1EN4llvm9StringRefEjjS3_")
  //</editor-fold>
  public Replacement(StringRef FilePath, /*uint*/int Offset, /*uint*/int Length, 
      StringRef ReplacementText) {
    // : FilePath(FilePath.operator basic_string()), ReplacementRange(Offset, Length), ReplacementText(ReplacementText.operator basic_string()) 
    //START JInit
    this.FilePath = FilePath.$string();
    this.ReplacementRange = new Range(Offset, Length);
    this.ReplacementText = ReplacementText.$string();
    //END JInit
  }


  
  /// \brief Creates a Replacement of the range [Start, Start+Length) with
  /// ReplacementText.
  
  /// \brief Creates a Replacement of the range [Start, Start+Length) with
  /// ReplacementText.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 40,
   FQN="clang::tooling::Replacement::Replacement", NM="_ZN5clang7tooling11ReplacementC1ERKNS_13SourceManagerENS_14SourceLocationEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11ReplacementC1ERKNS_13SourceManagerENS_14SourceLocationEjN4llvm9StringRefE")
  //</editor-fold>
  public Replacement(final /*const*/ SourceManager /*&*/ Sources, SourceLocation Start, 
      /*uint*/int Length, StringRef ReplacementText) {
    // : FilePath(), ReplacementRange(), ReplacementText() 
    //START JInit
    this.FilePath = new std.string();
    this.ReplacementRange = new Range();
    this.ReplacementText = new std.string();
    //END JInit
    setFromSourceLocation(Sources, new SourceLocation(Start), Length, new StringRef(ReplacementText));
  }


  
  /// \brief Creates a Replacement of the given range with ReplacementText.
  
  /// \brief Creates a Replacement of the given range with ReplacementText.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 45,
   FQN="clang::tooling::Replacement::Replacement", NM="_ZN5clang7tooling11ReplacementC1ERKNS_13SourceManagerERKNS_15CharSourceRangeEN4llvm9StringRefERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11ReplacementC1ERKNS_13SourceManagerERKNS_15CharSourceRangeEN4llvm9StringRefERKNS_11LangOptionsE")
  //</editor-fold>
  public Replacement(final /*const*/ SourceManager /*&*/ Sources, 
      final /*const*/ CharSourceRange /*&*/ Range, 
      StringRef ReplacementText) {
    this(Sources, 
      Range, 
      ReplacementText, 
      new LangOptions());
  }
  public Replacement(final /*const*/ SourceManager /*&*/ Sources, 
      final /*const*/ CharSourceRange /*&*/ Range, 
      StringRef ReplacementText, 
      final /*const*/ LangOptions /*&*/ LangOpts/*= LangOptions()*/) {
    // : FilePath(), ReplacementRange(), ReplacementText() 
    //START JInit
    this.FilePath = new std.string();
    this.ReplacementRange = new Range();
    this.ReplacementText = new std.string();
    //END JInit
    setFromSourceRange(Sources, Range, new StringRef(ReplacementText), LangOpts);
  }


  
//  /// \brief Creates a Replacement of the node with ReplacementText.
//  /*template <typename Node> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 243,
//   FQN="clang::tooling::Replacement::Replacement", NM="Tpl__ZN5clang7tooling11ReplacementC1ERKNS_13SourceManagerERKT_N4llvm9StringRefERKNS_11LangOptionsE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=Tpl__ZN5clang7tooling11ReplacementC1ERKNS_13SourceManagerERKT_N4llvm9StringRefERKNS_11LangOptionsE")
//  //</editor-fold>
//  public </*typename*/ Node> Replacement(final /*const*/ SourceManager /*&*/ Sources, 
//      final /*const*/ Node /*&*/ NodeToReplace, StringRef ReplacementText) {
//    this(Sources, 
//      NodeToReplace, ReplacementText, 
//      new LangOptions());
//  }
//  public </*typename*/ Node> Replacement(final /*const*/ SourceManager /*&*/ Sources, 
//      final /*const*/ Node /*&*/ NodeToReplace, StringRef ReplacementText, 
//      final /*const*/ LangOptions /*&*/ LangOpts/*= LangOptions()*/) {
//    /*const*/ CharSourceRange Range = CharSourceRange.getTokenRange(NodeToReplace.getSourceRange());
//    setFromSourceRange(Sources, Range, new StringRef(ReplacementText), LangOpts);
//  }

  
  /// \brief Returns whether this replacement can be applied to a file.
  ///
  /// Only replacements that are in a valid file can be applied.
  
  /// \brief Returns whether this replacement can be applied to a file.
  ///
  /// Only replacements that are in a valid file can be applied.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::isApplicable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 52,
   FQN="clang::tooling::Replacement::isApplicable", NM="_ZNK5clang7tooling11Replacement12isApplicableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling11Replacement12isApplicableEv")
  //</editor-fold>
  public boolean isApplicable() /*const*/ {
    return $noteq_string$C_T$C$P(FilePath, InvalidLocation.toString());
  }


  
  /// \brief Accessors.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::getFilePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 114,
   FQN="clang::tooling::Replacement::getFilePath", NM="_ZNK5clang7tooling11Replacement11getFilePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZNK5clang7tooling11Replacement11getFilePathEv")
  //</editor-fold>
  public StringRef getFilePath() /*const*/ {
    return new StringRef(FilePath);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 115,
   FQN="clang::tooling::Replacement::getOffset", NM="_ZNK5clang7tooling11Replacement9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZNK5clang7tooling11Replacement9getOffsetEv")
  //</editor-fold>
  public /*uint*/int getOffset() /*const*/ {
    return ReplacementRange.getOffset();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 116,
   FQN="clang::tooling::Replacement::getLength", NM="_ZNK5clang7tooling11Replacement9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZNK5clang7tooling11Replacement9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    return ReplacementRange.getLength();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::getReplacementText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 117,
   FQN="clang::tooling::Replacement::getReplacementText", NM="_ZNK5clang7tooling11Replacement18getReplacementTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZNK5clang7tooling11Replacement18getReplacementTextEv")
  //</editor-fold>
  public StringRef getReplacementText() /*const*/ {
    return new StringRef(ReplacementText);
  }

  /// @}
  
  /// \brief Applies the replacement on the Rewriter.
  /// @}
  
  /// \brief Applies the replacement on the Rewriter.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::apply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 56,
   FQN="clang::tooling::Replacement::apply", NM="_ZNK5clang7tooling11Replacement5applyERNS_8RewriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling11Replacement5applyERNS_8RewriterE")
  //</editor-fold>
  public boolean apply(final Rewriter /*&*/ Rewrite) /*const*/ {
    final SourceManager /*&*/ SM = Rewrite.getSourceMgr();
    /*const*/ FileEntry /*P*/ Entry = SM.getFileManager().getFile(new StringRef(FilePath));
    if (!(Entry != null)) {
      return false;
    }
    
    FileID ID = SM.getOrCreateFileID(Entry, SrcMgr.CharacteristicKind.C_User);
    /*const*/ SourceLocation Start = SM.getLocForStartOfFile(/*NO_COPY*/ID).
        getLocWithOffset(ReplacementRange.getOffset());
    // ReplaceText returns false on success.
    // ReplaceText only fails if the source location is not a file location, in
    // which case we already returned false earlier.
    boolean RewriteSucceeded = !Rewrite.ReplaceText(new SourceLocation(Start), ReplacementRange.getLength(), new StringRef(ReplacementText));
    assert (RewriteSucceeded);
    return RewriteSucceeded;
  }


  
  /// \brief Returns a human readable string representation.
  
  /// \brief Returns a human readable string representation.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 75,
   FQN="clang::tooling::Replacement::toString", NM="_ZNK5clang7tooling11Replacement8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling11Replacement8toStringEv")
  //</editor-fold>
  public std.string __toString() /*const*/ {
    raw_string_ostream Stream = null;
    try {
      std.string Result/*J*/= new std.string();
      Stream/*J*/= new raw_string_ostream(Result);
      Stream.$out(FilePath).$out(/*KEEP_STR*/": ").$out_uint(ReplacementRange.getOffset()).$out(/*KEEP_STR*/":+").$out_uint(
          ReplacementRange.getLength()
      ).$out(/*KEEP_STR*/":\"").$out(ReplacementText).$out(/*KEEP_STR*/$DBL_QUOTE);
      return new std.string(Stream.str());
    } finally {
      if (Stream != null) { Stream.$destroy(); }
    }
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::setFromSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 105,
   FQN="clang::tooling::Replacement::setFromSourceLocation", NM="_ZN5clang7tooling11Replacement21setFromSourceLocationERKNS_13SourceManagerENS_14SourceLocationEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11Replacement21setFromSourceLocationERKNS_13SourceManagerENS_14SourceLocationEjN4llvm9StringRefE")
  //</editor-fold>
  private void setFromSourceLocation(final /*const*/ SourceManager /*&*/ Sources, 
                       SourceLocation Start, /*uint*/int Length, 
                       StringRef ReplacementText) {
    /*const*/std.pairTypeUInt<FileID> DecomposedLocation = Sources.getDecomposedLoc(/*NO_COPY*/Start);
    /*const*/ FileEntry /*P*/ Entry = Sources.getFileEntryForID(/*NO_COPY*/DecomposedLocation.first);
    this.FilePath.$assign_T$C$P((Entry != null) ? Entry.getName() : InvalidLocation);
    this.ReplacementRange.$assignMove(new Range(DecomposedLocation.second, Length));
    this.ReplacementText.$assignMove(ReplacementText.$string());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::setFromSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 132,
   FQN="clang::tooling::Replacement::setFromSourceRange", NM="_ZN5clang7tooling11Replacement18setFromSourceRangeERKNS_13SourceManagerERKNS_15CharSourceRangeEN4llvm9StringRefERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11Replacement18setFromSourceRangeERKNS_13SourceManagerERKNS_15CharSourceRangeEN4llvm9StringRefERKNS_11LangOptionsE")
  //</editor-fold>
  private void setFromSourceRange(final /*const*/ SourceManager /*&*/ Sources, 
                    final /*const*/ CharSourceRange /*&*/ Range, 
                    StringRef ReplacementText, 
                    final /*const*/ LangOptions /*&*/ LangOpts) {
    setFromSourceLocation(Sources, Sources.getSpellingLoc(Range.getBegin()), 
        getRangeSize(Sources, Range, LangOpts), 
        new StringRef(ReplacementText));
  }


  
  private std.string FilePath;
  private Range ReplacementRange;
  private std.string ReplacementText;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 77,
   FQN="clang::tooling::Replacement::Replacement", NM="_ZN5clang7tooling11ReplacementC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang7tooling11ReplacementC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Replacement(final /*const*/ Replacement /*&*/ $Prm0) {
    // : FilePath(.FilePath), ReplacementRange(.ReplacementRange), ReplacementText(.ReplacementText) 
    //START JInit
    this.FilePath = new std.string($Prm0.FilePath);
    this.ReplacementRange = new Range($Prm0.ReplacementRange);
    this.ReplacementText = new std.string($Prm0.ReplacementText);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 77,
   FQN="clang::tooling::Replacement::Replacement", NM="_ZN5clang7tooling11ReplacementC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang7tooling11ReplacementC1EOS1_")
  //</editor-fold>
  public /*inline*/ Replacement(JD$Move _dparam, final Replacement /*&&*/$Prm0) {
    // : FilePath(static_cast<Replacement &&>().FilePath), ReplacementRange(static_cast<Replacement &&>().ReplacementRange), ReplacementText(static_cast<Replacement &&>().ReplacementText) 
    //START JInit
    this.FilePath = new std.string(JD$Move.INSTANCE, $Prm0.FilePath);
    this.ReplacementRange = new Range(JD$Move.INSTANCE, $Prm0.ReplacementRange);
    this.ReplacementText = new std.string(JD$Move.INSTANCE, $Prm0.ReplacementText);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 77,
   FQN="clang::tooling::Replacement::operator=", NM="_ZN5clang7tooling11ReplacementaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang7tooling11ReplacementaSERKS1_")
  //</editor-fold>
  public /*inline*/ Replacement /*&*/ $assign(final /*const*/ Replacement /*&*/ $Prm0) {
    this.FilePath.$assign($Prm0.FilePath);
    this.ReplacementRange.$assign($Prm0.ReplacementRange);
    this.ReplacementText.$assign($Prm0.ReplacementText);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 77,
   FQN="clang::tooling::Replacement::operator=", NM="_ZN5clang7tooling11ReplacementaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang7tooling11ReplacementaSEOS1_")
  //</editor-fold>
  public /*inline*/ Replacement /*&*/ $assignMove(final Replacement /*&&*/$Prm0) {
    this.FilePath.$assignMove($Prm0.FilePath);
    this.ReplacementRange.$assignMove($Prm0.ReplacementRange);
    this.ReplacementText.$assignMove($Prm0.ReplacementText);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Replacement::~Replacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 77,
   FQN="clang::tooling::Replacement::~Replacement", NM="_ZN5clang7tooling11ReplacementD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang7tooling11ReplacementD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ReplacementText.$destroy();
    FilePath.$destroy();
    //END JDestroy
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public boolean $less(Object other) {
    if (FilePath.$less(((Replacement)other).FilePath)) {
      return true;
    }
    if (FilePath.$eq(((Replacement)other).FilePath)) {
      int res = ReplacementRange.getOffset() - ((Replacement)other).getOffset();
      if (res < 0) {
        return true;
      }
      if (res == 0) {
        return ReplacementText.$less(((Replacement)other).ReplacementText);
      }
    }
    return false;
  }
  
  @Override public String toString() {
    return "Replacement{" + __toString().toJavaString() + "}"; // NOI18N
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
