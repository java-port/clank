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

package org.clang.lex;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Implements the simple state machine that the Lexer class uses to
/// detect files subject to the 'multiple-include' optimization.
///
/// The public methods in this class are triggered by various
/// events that occur when a file is lexed, and after the entire file is lexed,
/// information about which macro (if any) controls the header is returned.
//<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 29,
 FQN = "clang::MultipleIncludeOpt", NM = "_ZN5clang18MultipleIncludeOptE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOptE")
//</editor-fold>
public class MultipleIncludeOpt {
  static final MultipleIncludeOpt NULL = new MultipleIncludeOpt();
  
  /// ReadAnyTokens - This is set to false when a file is first opened and true
  /// any time a token is returned to the client or a (non-multiple-include)
  /// directive is parsed.  When the final \#endif is parsed this is reset back
  /// to false, that way any tokens before the first \#ifdef or after the last
  /// \#endif can be easily detected.
  private boolean ReadAnyTokens;
  
  /// ImmediatelyAfterTopLevelIfndef - This is true when the only tokens
  /// processed in the file so far is an #ifndef and an identifier.  Used in
  /// the detection of header guards in a file.
  private boolean ImmediatelyAfterTopLevelIfndef;
  
  /// ReadAnyTokens - This is set to false when a file is first opened and true
  /// any time a token is returned to the client or a (non-multiple-include)
  /// directive is parsed.  When the final #endif is parsed this is reset back
  /// to false, that way any tokens before the first #ifdef or after the last
  /// #endif can be easily detected.
  private boolean DidMacroExpansion;
  
  /// TheMacro - The controlling macro for a file, if valid.
  ///
  private /*const*/IdentifierInfo /*P*/ TheMacro;
  
  /// DefinedMacro - The macro defined right after TheMacro, if any.
  private /*const*/IdentifierInfo /*P*/ DefinedMacro;
  private /*uint*/int MacroLoc;
  private /*uint*/int DefinedLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::MultipleIncludeOpt">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 59,
   FQN = "clang::MultipleIncludeOpt::MultipleIncludeOpt", NM = "_ZN5clang18MultipleIncludeOptC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOptC1Ev")
  //</editor-fold>
  public MultipleIncludeOpt() {
    /* : MacroLoc(), DefinedLoc()*/ 
    //START JInit
    this.MacroLoc = 0;
    this.DefinedLoc = 0;
    //END JInit
    ReadAnyTokens = false;
    ImmediatelyAfterTopLevelIfndef = false;
    DidMacroExpansion = false;
    TheMacro = null;
    DefinedMacro = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::GetMacroLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 67,
   FQN = "clang::MultipleIncludeOpt::GetMacroLocation", NM = "_ZNK5clang18MultipleIncludeOpt16GetMacroLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang18MultipleIncludeOpt16GetMacroLocationEv")
  //</editor-fold>
  public SourceLocation GetMacroLocation() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return SourceLocation.getFromRawEncoding(MacroLoc);
  }
  public /*SourceLocation*/int GetRawMacroLocation() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return MacroLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::GetDefinedLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 71,
   FQN = "clang::MultipleIncludeOpt::GetDefinedLocation", NM = "_ZNK5clang18MultipleIncludeOpt18GetDefinedLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang18MultipleIncludeOpt18GetDefinedLocationEv")
  //</editor-fold>
  public SourceLocation GetDefinedLocation() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return SourceLocation.getFromRawEncoding(DefinedLoc);
  }
  public /*SourceLocation*/int GetRawDefinedLocation() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return DefinedLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::resetImmediatelyAfterTopLevelIfndef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 75,
   FQN = "clang::MultipleIncludeOpt::resetImmediatelyAfterTopLevelIfndef", NM = "_ZN5clang18MultipleIncludeOpt35resetImmediatelyAfterTopLevelIfndefEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt35resetImmediatelyAfterTopLevelIfndefEv")
  //</editor-fold>
  public void resetImmediatelyAfterTopLevelIfndef() {
    ImmediatelyAfterTopLevelIfndef = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::SetDefinedMacro">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 79,
   FQN = "clang::MultipleIncludeOpt::SetDefinedMacro", NM = "_ZN5clang18MultipleIncludeOpt15SetDefinedMacroEPNS_14IdentifierInfoENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt15SetDefinedMacroEPNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public void SetDefinedMacro(IdentifierInfo /*P*/ M, SourceLocation Loc) {
    DefinedMacro = M;
    DefinedLoc = Loc.getRawEncoding();
  }

  
  /// Invalidate - Permanently mark this file as not being suitable for the
  /// include-file optimization.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::Invalidate">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 86,
   FQN = "clang::MultipleIncludeOpt::Invalidate", NM = "_ZN5clang18MultipleIncludeOpt10InvalidateEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt10InvalidateEv")
  //</editor-fold>
  public void Invalidate() {
    // If we have read tokens but have no controlling macro, the state-machine
    // below can never "accept".
    ReadAnyTokens = true;
    ImmediatelyAfterTopLevelIfndef = false;
    DefinedMacro = null;
    TheMacro = null;
  }

  
  /// getHasReadAnyTokensVal - This is used for the \#ifndef hande-shake at the
  /// top of the file when reading preprocessor directives.  Otherwise, reading
  /// the "ifndef x" would count as reading tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::getHasReadAnyTokensVal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 98,
   FQN = "clang::MultipleIncludeOpt::getHasReadAnyTokensVal", NM = "_ZNK5clang18MultipleIncludeOpt22getHasReadAnyTokensValEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang18MultipleIncludeOpt22getHasReadAnyTokensValEv")
  //</editor-fold>
  public boolean getHasReadAnyTokensVal() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return ReadAnyTokens;
  }

  
  /// getImmediatelyAfterTopLevelIfndef - returns true if the last directive
  /// was an #ifndef at the beginning of the file.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::getImmediatelyAfterTopLevelIfndef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 102,
   FQN = "clang::MultipleIncludeOpt::getImmediatelyAfterTopLevelIfndef", NM = "_ZNK5clang18MultipleIncludeOpt33getImmediatelyAfterTopLevelIfndefEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang18MultipleIncludeOpt33getImmediatelyAfterTopLevelIfndefEv")
  //</editor-fold>
  public boolean getImmediatelyAfterTopLevelIfndef() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return ImmediatelyAfterTopLevelIfndef;
  }

  
  // If a token is read, remember that we have seen a side-effect in this file.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::ReadToken">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 107,
   FQN = "clang::MultipleIncludeOpt::ReadToken", NM = "_ZN5clang18MultipleIncludeOpt9ReadTokenEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt9ReadTokenEv")
  //</editor-fold>
  public void ReadToken() {
    ReadAnyTokens = true;
    ImmediatelyAfterTopLevelIfndef = false;
  }

  
  /// ExpandedMacro - When a macro is expanded with this lexer as the current
  /// buffer, this method is called to disable the MIOpt if needed.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::ExpandedMacro">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 114,
   FQN = "clang::MultipleIncludeOpt::ExpandedMacro", NM = "_ZN5clang18MultipleIncludeOpt13ExpandedMacroEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt13ExpandedMacroEv")
  //</editor-fold>
  public void ExpandedMacro() {
    DidMacroExpansion = true;
  }

  
  /// \brief Called when entering a top-level \#ifndef directive (or the
  /// "\#if !defined" equivalent) without any preceding tokens.
  ///
  /// Note, we don't care about the input value of 'ReadAnyTokens'.  The caller
  /// ensures that this is only called if there are no tokens read before the
  /// \#ifndef.  The caller is required to do this, because reading the \#if
  /// line obviously reads in in tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::EnterTopLevelIfndef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 123,
   FQN = "clang::MultipleIncludeOpt::EnterTopLevelIfndef", NM = "_ZN5clang18MultipleIncludeOpt19EnterTopLevelIfndefEPKNS_14IdentifierInfoENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt19EnterTopLevelIfndefEPKNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public void EnterTopLevelIfndef(/*const*/IdentifierInfo /*P*/ M, SourceLocation Loc) {
    if (this == NULL) {
      return;
    }
    // If the macro is already set, this is after the top-level #endif.
    if ((TheMacro != null)) {
      Invalidate();
      return;
    }
    
    // If we have already expanded a macro by the end of the #ifndef line, then
    // there is a macro expansion *in* the #ifndef line.  This means that the
    // condition could evaluate differently when subsequently #included.  Reject
    // this.
    if (DidMacroExpansion) {
      Invalidate();
      return;
    }
    
    // Remember that we're in the #if and that we have the macro.
    ReadAnyTokens = true;
    ImmediatelyAfterTopLevelIfndef = true;
    TheMacro = M;
    MacroLoc = Loc.getRawEncoding();
  }

  
  /// \brief Invoked when a top level conditional (except \#ifndef) is found.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::EnterTopLevelConditional">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 143,
   FQN = "clang::MultipleIncludeOpt::EnterTopLevelConditional", NM = "_ZN5clang18MultipleIncludeOpt24EnterTopLevelConditionalEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt24EnterTopLevelConditionalEv")
  //</editor-fold>
  public void EnterTopLevelConditional() {
    if (this == NULL) {
      return;
    }    
    // If a conditional directive (except #ifndef) is found at the top level,
    // there is a chunk of the file not guarded by the controlling macro.
    Invalidate();
  }

  
  /// \brief Called when the lexer exits the top-level conditional.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::ExitTopLevelConditional">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 150,
   FQN = "clang::MultipleIncludeOpt::ExitTopLevelConditional", NM = "_ZN5clang18MultipleIncludeOpt23ExitTopLevelConditionalEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang18MultipleIncludeOpt23ExitTopLevelConditionalEv")
  //</editor-fold>
  public void ExitTopLevelConditional() {
    if (this == NULL) {
      return;
    }    
    // If we have a macro, that means the top of the file was ok.  Set our state
    // back to "not having read any tokens" so we can detect anything after the
    // #endif.
    if (!(TheMacro != null)) {
      Invalidate();
      return;
    }
    
    // At this point, we haven't "read any tokens" but we do have a controlling
    // macro.
    ReadAnyTokens = false;
    ImmediatelyAfterTopLevelIfndef = false;
  }

  
  /// \brief Once the entire file has been lexed, if there is a controlling
  /// macro, return it.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::GetControllingMacroAtEndOfFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 164,
   FQN = "clang::MultipleIncludeOpt::GetControllingMacroAtEndOfFile", NM = "_ZNK5clang18MultipleIncludeOpt30GetControllingMacroAtEndOfFileEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang18MultipleIncludeOpt30GetControllingMacroAtEndOfFileEv")
  //</editor-fold>
  public /*const*/IdentifierInfo /*P*/ GetControllingMacroAtEndOfFile() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    // If we haven't read any tokens after the #endif, return the controlling
    // macro if it's valid (if it isn't, it will be null).
    if (!ReadAnyTokens) {
      return TheMacro;
    }
    return null;
  }

  
  /// \brief If the ControllingMacro is followed by a macro definition, return
  /// the macro that was defined.
  //<editor-fold defaultstate="collapsed" desc="clang::MultipleIncludeOpt::GetDefinedMacro">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MultipleIncludeOpt.h", line = 174,
   FQN = "clang::MultipleIncludeOpt::GetDefinedMacro", NM = "_ZNK5clang18MultipleIncludeOpt15GetDefinedMacroEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang18MultipleIncludeOpt15GetDefinedMacroEv")
  //</editor-fold>
  public /*const*/IdentifierInfo /*P*/ GetDefinedMacro() /*const*/ {
    assert this != NULL : "Lexer was created assuming MIOpt is not requeired";
    return DefinedMacro;
  }

}
