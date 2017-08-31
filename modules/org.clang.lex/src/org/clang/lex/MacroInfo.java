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

import org.clang.lex.llvm.SmallVectorToken;
import java.util.Arrays;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.llvm.ArrayRefToken;
import static org.clank.java.std_pair.*;
import org.clank.support.*;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.$less_uint;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;


/// \brief Encapsulates the data about a macro definition (e.g. its tokens).
///
/// There's an instance of this class for every #define.
//<editor-fold defaultstate="collapsed" desc="clang::MacroInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 34,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 30,
 FQN = "clang::MacroInfo", NM = "_ZN5clang9MacroInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfoE")
//</editor-fold>
public class MacroInfo implements Destructors.ClassWithDestructor {
  
  //===--------------------------------------------------------------------===//
  // State set when the macro is defined.
  // JAVA: remember position (we need this information for callbacks)
  private /*SourceLocation*/int HashLoc = SourceLocation.getInvalid();
  private /*SourceLocation*/int EodLoc = SourceLocation.getInvalid();

  // JAVA: we need this information for callbacks
  void setLocationRange(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc) {
    assert SourceLocation.isInvalid(this.HashLoc) : "must be initialized once";
    assert SourceLocation.isInvalid(this.EodLoc) : "must be initialized once";
    this.HashLoc = HashLoc;
    this.EodLoc = EodLoc;
  }
  
  // JAVA: we need this information for callbacks
  public /*SourceLocation*/int getHashLoc() {
    return HashLoc;
  }

  // JAVA: we need this information for callbacks
  public /*SourceLocation*/int getEodLoc() {
    return EodLoc;
  }
  
  /// \brief The location the macro is defined.
  private /*SourceLocation*/int Location;
  /// \brief The location of the last token in the macro.
  private /*SourceLocation*/int EndLocation;
  
  /// \brief The list of arguments for a function-like macro.
  ///
  /// ArgumentList points to the first of NumArguments pointers.
  ///
  /// This can be empty, for, e.g. "#define X()".  In a C99-style variadic
  /// macro, this includes the \c __VA_ARGS__ identifier on the list.
  private IdentifierInfo[] ArgumentList;
  
  /// \see ArgumentList
  private /*uint*/int NumArguments;
  
  /// \brief This is the list of tokens that the macro is defined to.
  private SmallVectorToken ReplacementTokens;
  // JAVA PERF: changed semantic to initialize ReplacementTokens as soon as 
  // whole body is gathered (like done with ArgumentList)
  // 
  // it prevents initial array creation and unused for empty macro
  // also it prevents growing and realloc internal array when body is big
  // @see setReplacementTokens
  private static final SmallVectorToken DUMMY = SmallVectorToken.DEFAULT;
  
  /// \brief Length in characters of the macro definition.
  private /*mutable *//*uint*/int DefinitionLength;
  private /*mutable *//*JBIT bool*/ boolean IsDefinitionLengthCached /*: 1*/;
  
  /// \brief True if this macro is function-like, false if it is object-like.
  private /*JBIT bool*/ boolean IsFunctionLike /*: 1*/;
  
  /// \brief True if this macro is of the form "#define X(...)" or
  /// "#define X(Y,Z,...)".
  ///
  /// The __VA_ARGS__ token should be replaced with the contents of "..." in an
  /// invocation.
  private /*JBIT bool*/ boolean IsC99Varargs /*: 1*/;
  
  /// \brief True if this macro is of the form "#define X(a...)".
  ///
  /// The "a" identifier in the replacement list will be replaced with all
  /// arguments of the macro starting with the specified one.
  private /*JBIT bool*/ boolean IsGNUVarargs /*: 1*/;
  
  /// \brief True if this macro requires processing before expansion.
  ///
  /// This is the case for builtin macros such as __LINE__, so long as they have
  /// not been redefined, but not for regular predefined macros from the
  /// "<built-in>" memory buffer (see Preprocessing::getPredefinesFileID).
  private /*JBIT bool*/ boolean IsBuiltinMacro /*: 1*/;
  
  /// \brief Whether this macro contains the sequence ", ## __VA_ARGS__"
  private /*JBIT bool*/ boolean HasCommaPasting /*: 1*/;
  
  //===--------------------------------------------------------------------===//
  // State that changes as the macro is used.
  
  /// \brief True if we have started an expansion of this macro already.
  ///
  /// This disables recursive expansion, which would be quite bad for things
  /// like \#define A A.
  private /*JBIT bool*/ boolean IsDisabled /*: 1*/;
  
  /// \brief True if this macro is either defined in the main file and has
  /// been used, or if it is not defined in the main file.
  ///
  /// This is used to emit -Wunused-macros diagnostics.
  private /*JBIT bool*/ boolean IsUsed /*: 1*/;
  
  /// \brief True if this macro can be redefined without emitting a warning.
  private /*JBIT bool*/ boolean IsAllowRedefinitionsWithoutWarning /*: 1*/;
  
  /// \brief Must warn if the macro is unused at the end of translation unit.
  private /*JBIT bool*/ boolean IsWarnIfUnused /*: 1*/;
  
  /// \brief Whether this macro info was loaded from an AST file.
  /*friend*/ /*JBIT bool*/ boolean FromASTFile /*: 1*/;
  
  /// \brief Whether this macro was used as header guard.
  private /*JBIT bool*/ boolean UsedForHeaderGuard /*: 1*/;
  
  // FIXME: dedicated field to eleminate this+1 
  private /*uint*/int OwningModuleID;
  
  protected MacroInfo() {}

  // Only the Preprocessor gets to create and destroy these.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::MacroInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 18,
   FQN = "clang::MacroInfo::MacroInfo", NM = "_ZN5clang9MacroInfoC1ENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfoC1ENS_14SourceLocationE")
  //</editor-fold>
  public MacroInfo(SourceLocation DefLoc) {
    this(DefLoc.getRawEncoding());
  }
  public MacroInfo(/*SourceLocation*/int DefLoc) {
    /* : Location(DefLoc), EndLocation(), ArgumentList(0), NumArguments(0), ReplacementTokens(), IsDefinitionLengthCached(false), IsFunctionLike(false), IsC99Varargs(false), IsGNUVarargs(false), IsBuiltinMacro(false), HasCommaPasting(false), IsDisabled(false), IsUsed(false), IsAllowRedefinitionsWithoutWarning(false), IsWarnIfUnused(false), FromASTFile(false)*/ 
    //START JInit
    this.Location = DefLoc;
    this.EndLocation = SourceLocation.getInvalid();
    this.ArgumentList = null;
    this.NumArguments = 0;
    this.ReplacementTokens = DUMMY;
    this.IsDefinitionLengthCached = false;
    this.IsFunctionLike = false;
    this.IsC99Varargs = false;
    this.IsGNUVarargs = false;
    this.IsBuiltinMacro = false;
    this.HasCommaPasting = false;
    this.IsDisabled = false;
    this.IsUsed = false;
    this.IsAllowRedefinitionsWithoutWarning = false;
    this.IsWarnIfUnused = false;
    this.FromASTFile = false;
    this.UsedForHeaderGuard = false;
    //END JInit
  }

  public MacroInfo $assign(MacroInfo other) {
    this.Location = other.Location;
    this.EndLocation = other.EndLocation;
    this.ArgumentList = other.ArgumentList;
    this.NumArguments = other.NumArguments;
    this.ReplacementTokens = other.ReplacementTokens;
    this.DefinitionLength = other.DefinitionLength;
    this.IsDefinitionLengthCached = other.IsDefinitionLengthCached;
    this.IsFunctionLike = other.IsFunctionLike;
    this.IsC99Varargs = other.IsC99Varargs;
    this.IsGNUVarargs = other.IsGNUVarargs;
    this.IsBuiltinMacro = other.IsBuiltinMacro;
    this.HasCommaPasting = other.HasCommaPasting;
    this.IsDisabled = other.IsDisabled;
    this.IsUsed = other.IsUsed;
    this.IsAllowRedefinitionsWithoutWarning = other.IsAllowRedefinitionsWithoutWarning;
    this.IsWarnIfUnused = other.IsWarnIfUnused;
    this.FromASTFile = other.FromASTFile;
    this.OwningModuleID = other.OwningModuleID;
    this.UsedForHeaderGuard = other.UsedForHeaderGuard;
    return this;
  }  
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::~MacroInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 112,
   FQN = "clang::MacroInfo::~MacroInfo", NM = "_ZN5clang9MacroInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang9MacroInfoD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() {
    if (ReplacementTokens != DUMMY) {
      //START JDestroy
      ReplacementTokens.set_size(0);
      //END JDestroy
    }
  }
  

/*public:*/
  /// \brief Return the location that the macro was defined at.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getDefinitionLoc">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 116,
   FQN = "clang::MacroInfo::getDefinitionLoc", NM = "_ZNK5clang9MacroInfo16getDefinitionLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo16getDefinitionLocEv")
  //</editor-fold>
  public SourceLocation getDefinitionLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(Location);
  }
  public /*SourceLocation*/int $getDefinitionLoc() /*const*/ {
    return Location;
  }

  
  /// \brief Set the location of the last token in the macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setDefinitionEndLoc">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 119,
   FQN = "clang::MacroInfo::setDefinitionEndLoc", NM = "_ZN5clang9MacroInfo19setDefinitionEndLocENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo19setDefinitionEndLocENS_14SourceLocationE")
  //</editor-fold>
  public void setDefinitionEndLoc(SourceLocation EndLoc) {
    EndLocation = EndLoc.getRawEncoding();
  }
  public void setDefinitionEndLoc(/*SourceLocation*/int EndLoc) {
    EndLocation = EndLoc;
  }

  
  /// \brief Return the location of the last token in the macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getDefinitionEndLoc">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 122,
   FQN = "clang::MacroInfo::getDefinitionEndLoc", NM = "_ZNK5clang9MacroInfo19getDefinitionEndLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo19getDefinitionEndLocEv")
  //</editor-fold>
  public SourceLocation getDefinitionEndLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(EndLocation);
  }
  public /*SourceLocation*/int $getDefinitionEndLoc() /*const*/ {
    return EndLocation;
  }

  
  /// \brief Get length in characters of the macro definition.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getDefinitionLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 125,
   FQN = "clang::MacroInfo::getDefinitionLength", NM = "_ZNK5clang9MacroInfo19getDefinitionLengthERNS_13SourceManagerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo19getDefinitionLengthERNS_13SourceManagerE")
  //</editor-fold>
  public /*uint*/int getDefinitionLength(SourceManager /*&*/ SM) /*const*/ {
    if (IsDefinitionLengthCached) {
      return DefinitionLength;
    }
    return getDefinitionLengthSlow(SM);
  }

  
  /// \brief Return true if the specified macro definition is equal to
  /// this macro in spelling, arguments, and whitespace.
  ///
  /// \param Syntactically if true, the macro definitions can be identical even
  /// if they use different identifiers for the function macro parameters.
  /// Otherwise the comparison is lexical and this implements the rules in
  /// C99 6.10.3.
  
  /// \brief Return true if the specified macro definition is equal to
  /// this macro in spelling, arguments, and whitespace.
  ///
  /// \param Syntactically if true, the macro definitions can be identical even
  /// if they use different identifiers for the function macro parameters.
  /// Otherwise the comparison is lexical and this implements the rules in
  /// C99 6.10.3.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isIdenticalTo">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 72,
   FQN = "clang::MacroInfo::isIdenticalTo", NM = "_ZNK5clang9MacroInfo13isIdenticalToERKS0_RNS_12PreprocessorEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo13isIdenticalToERKS0_RNS_12PreprocessorEb")
  //</editor-fold>
  public boolean isIdenticalTo(/*const*/MacroInfo /*&*/ Other, Preprocessor /*&*/ PP, boolean Syntactically) /*const*/ {
    boolean Lexically = !Syntactically;
    
    // Check # tokens in replacement, number of args, and various flags all match.
    if (ReplacementTokens.size() != Other.ReplacementTokens.size() 
       || getNumArgs() != Other.getNumArgs() 
       || isFunctionLike() != Other.isFunctionLike() 
       || isC99Varargs() != Other.isC99Varargs() 
       || isGNUVarargs() != Other.isGNUVarargs()) {
      return false;
    }
    if (Lexically) {
      // Check arguments.
      for (int I = 0, OI = 0; I != NumArguments; ++I, ++OI)  {
        // FIXME: equals? 
        // NOTE: here are pointers should be equal
        if (/*Deref*/this.ArgumentList[I] != /*Deref*/Other.ArgumentList[OI]) {
          return false;
        }
      }
    }
    
    // Check all the tokens.
    for (/*uint*/int i = 0, e = ReplacementTokens.size(); i != e; ++i) {
      /*const*/Token /*&*/ A = ReplacementTokens.$at(i);
      /*const*/Token /*&*/ B = Other.ReplacementTokens.$at(i);
      if (A.getKind() != B.getKind()) {
        return false;
      }
      
      // If this isn't the first first token, check that the whitespace and
      // start-of-line characteristics match.
      if (i != 0
         && (A.isAtStartOfLine() != B.isAtStartOfLine()
         || A.hasLeadingSpace() != B.hasLeadingSpace())) {
        return false;
      }
      
      // If this is an identifier, it is easy.
      if ((A.getIdentifierInfo() != null) || (B.getIdentifierInfo() != null)) {
        if (A.getIdentifierInfo() == B.getIdentifierInfo()) {
          continue;
        }
        if (Lexically) {
          return false;
        }
        // With syntactic equivalence the parameter names can be different as long
        // as they are used in the same place.
        int AArgNum = getArgumentNum(A.getIdentifierInfo());
        if (AArgNum == -1) {
          return false;
        }
        if (AArgNum != Other.getArgumentNum(B.getIdentifierInfo())) {
          return false;
        }
        continue;
      }
      
      // Otherwise, check the spelling.
      SmallString LHSSpelling = PP.$getLHSTokenSpelling(A.getLength());
      SmallString RHSSpelling = PP.$getRHSTokenSpelling(B.getLength());
      int LHSLen = PP.copySpelling(A, LHSSpelling.$array(), 0);
      int RHSLen = PP.copySpelling(B, RHSSpelling.$array(), 0);
      boolean $noteq = (LHSLen != RHSLen) || LHSSpelling.$noteq(RHSSpelling);
      PP.$releaseLHSTokenSpelling(LHSSpelling);
      PP.$releaseRHSTokenSpelling(RHSSpelling);
      if ($noteq) {
        return false;
      }
    }
    
    return true;
  }

  
  /// \brief Set or clear the isBuiltinMacro flag.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsBuiltinMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 142,
   FQN = "clang::MacroInfo::setIsBuiltinMacro", NM = "_ZN5clang9MacroInfo17setIsBuiltinMacroEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo17setIsBuiltinMacroEb")
  //</editor-fold>
  public void setIsBuiltinMacro() {
    setIsBuiltinMacro(true);
  }
  public void setIsBuiltinMacro(boolean Val/*= true*/) {
    IsBuiltinMacro = Val;
  }

  
  /// \brief Set the value of the IsUsed flag.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 147,
   FQN = "clang::MacroInfo::setIsUsed", NM = "_ZN5clang9MacroInfo9setIsUsedEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo9setIsUsedEb")
  //</editor-fold>
  public void setIsUsed(boolean Val) {
    IsUsed = Val;
  }

  
  /// \brief Set the value of the IsAllowRedefinitionsWithoutWarning flag.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsAllowRedefinitionsWithoutWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 152,
   FQN = "clang::MacroInfo::setIsAllowRedefinitionsWithoutWarning", NM = "_ZN5clang9MacroInfo37setIsAllowRedefinitionsWithoutWarningEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo37setIsAllowRedefinitionsWithoutWarningEb")
  //</editor-fold>
  public void setIsAllowRedefinitionsWithoutWarning(boolean Val) {
    IsAllowRedefinitionsWithoutWarning = Val;
  }

  
  /// \brief Set the value of the IsWarnIfUnused flag.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsWarnIfUnused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 157,
   FQN = "clang::MacroInfo::setIsWarnIfUnused", NM = "_ZN5clang9MacroInfo17setIsWarnIfUnusedEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo17setIsWarnIfUnusedEb")
  //</editor-fold>
  public void setIsWarnIfUnused(boolean val) {
    IsWarnIfUnused = val;
  }

  
  /// \brief Set the specified list of identifiers as the argument list for
  /// this macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setArgumentList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 161,
   FQN="clang::MacroInfo::setArgumentList", NM="_ZN5clang9MacroInfo15setArgumentListEN4llvm8ArrayRefIPNS_14IdentifierInfoEEERNS1_20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo15setArgumentListEN4llvm8ArrayRefIPNS_14IdentifierInfoEEERNS1_20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public void setArgumentList(/*MANUAL_SEMANTIC SmallVector instead of ArrayRef*/SmallVector<IdentifierInfo /*P*/> List, 
          BumpPtrAllocator /*&*/ PPAllocator) {
    assert (ArgumentList == null && NumArguments == 0) : "Argument list already set!";
    NumArguments = (int) List.size();
    if (NumArguments == 0) {
      return;
    }
    
    if (false) {
      /*ArgumentList =*/ PPAllocator.Allocate_T(IdentifierInfo.class /*P*/, NumArguments);
    } else {
      assert NumArguments != 0;
      ArgumentList = new IdentifierInfo[NumArguments];
    }
    for (/*uint*/int i = 0; i != NumArguments; ++i)  {
      ArgumentList[i] = List.$at(i);
    }
  }
  public void setArgumentList(ArrayRef<IdentifierInfo /*P*/> List, 
          BumpPtrAllocator /*&*/ PPAllocator) {
    assert false : "use setArgumentList(SmallVector) version instead";
    setArgumentList(new SmallVector<IdentifierInfo /*P*/>(List.size(), List.data(), List.size(), (IdentifierInfo /*P*/)null), PPAllocator);
  }

  /// Arguments - The list of arguments for a function-like macro.  This can be
  /// empty, for, e.g. "#define X()".
  /*typedef IdentifierInfo *const *arg_iterator*/
//  public final class arg_iterator extends IdentifierInfo /*P*/ /*const*/ /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::arg_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 178,
   FQN = "clang::MacroInfo::arg_empty", NM = "_ZNK5clang9MacroInfo9arg_emptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo9arg_emptyEv")
  //</editor-fold>
  public boolean arg_empty() /*const*/ {
    return NumArguments == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 177,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 179,
   FQN = "clang::MacroInfo::arg_begin", NM = "_ZNK5clang9MacroInfo9arg_beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo9arg_beginEv")
  //</editor-fold>
  public type$ptr<IdentifierInfo> arg_begin() /*const*/ {
    if (NativeTrace.VERBOSE_MODE) llvm.errs().$out("use $args() and getNumArgs()\n");
    return create_type$ptr(ArgumentList);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::arg_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 178,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 180,
   FQN = "clang::MacroInfo::arg_end", NM = "_ZNK5clang9MacroInfo7arg_endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo7arg_endEv")
  //</editor-fold>
  public type$ptr<IdentifierInfo> arg_end() /*const*/ {
    if (NativeTrace.VERBOSE_MODE) llvm.errs().$out("use $args() and getNumArgs()\n");
    return create_type$ptr(ArgumentList, NumArguments);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 181,
   FQN = "clang::MacroInfo::getNumArgs", NM = "_ZNK5clang9MacroInfo10getNumArgsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArguments;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::args">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 180,
   FQN="clang::MacroInfo::args", NM="_ZNK5clang9MacroInfo4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo4argsEv")
  //</editor-fold>
  public ArrayRef</*const*/ IdentifierInfo /*P*/ > args() /*const*/ {
    if (NativeTrace.VERBOSE_MODE) llvm.errs().$out("use $args() and getNumArgs()\n");
    return new ArrayRef</*const*/ IdentifierInfo /*P*/ >(ArgumentList, NumArguments);
  }

  public IdentifierInfo[] $args() /*const*/ {
    return ArgumentList;
  }  
  
  /// \brief Return the argument number of the specified identifier,
  /// or -1 if the identifier is not a formal argument identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getArgumentNum">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 186,
   FQN="clang::MacroInfo::getArgumentNum", NM="_ZNK5clang9MacroInfo14getArgumentNumEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo14getArgumentNumEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public int getArgumentNum(/*const*/ IdentifierInfo /*P*/ Arg) /*const*/ {
    for (int I = 0; I != NumArguments; ++I)  {
      // NOTE: here are pointers should be equal
      if (/*Deref*/ArgumentList[I] == Arg) {
        return I;
      }
    }
    return -1;
  }

  
  /// Function/Object-likeness.  Keep track of whether this macro has formal
  /// parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsFunctionLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 193,
   FQN = "clang::MacroInfo::setIsFunctionLike", NM = "_ZN5clang9MacroInfo17setIsFunctionLikeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo17setIsFunctionLikeEv")
  //</editor-fold>
  public void setIsFunctionLike() {
    IsFunctionLike = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isFunctionLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 196,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 194,
   FQN = "clang::MacroInfo::isFunctionLike", NM = "_ZNK5clang9MacroInfo14isFunctionLikeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo14isFunctionLikeEv")
  //</editor-fold>
  public boolean isFunctionLike() /*const*/ {
    return IsFunctionLike;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isObjectLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 195,
   FQN = "clang::MacroInfo::isObjectLike", NM = "_ZNK5clang9MacroInfo12isObjectLikeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo12isObjectLikeEv")
  //</editor-fold>
  public boolean isObjectLike() /*const*/ {
    return !IsFunctionLike;
  }

  
  /// Varargs querying methods.  This can only be set for function-like macros.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsC99Varargs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 198,
   FQN = "clang::MacroInfo::setIsC99Varargs", NM = "_ZN5clang9MacroInfo15setIsC99VarargsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo15setIsC99VarargsEv")
  //</editor-fold>
  public void setIsC99Varargs() {
    IsC99Varargs = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setIsGNUVarargs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 201,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 199,
   FQN = "clang::MacroInfo::setIsGNUVarargs", NM = "_ZN5clang9MacroInfo15setIsGNUVarargsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo15setIsGNUVarargsEv")
  //</editor-fold>
  public void setIsGNUVarargs() {
    IsGNUVarargs = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isC99Varargs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 200,
   FQN = "clang::MacroInfo::isC99Varargs", NM = "_ZNK5clang9MacroInfo12isC99VarargsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo12isC99VarargsEv")
  //</editor-fold>
  public boolean isC99Varargs() /*const*/ {
    return IsC99Varargs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isGNUVarargs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 203,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 201,
   FQN = "clang::MacroInfo::isGNUVarargs", NM = "_ZNK5clang9MacroInfo12isGNUVarargsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo12isGNUVarargsEv")
  //</editor-fold>
  public boolean isGNUVarargs() /*const*/ {
    return IsGNUVarargs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isVariadic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 204,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 202,
   FQN = "clang::MacroInfo::isVariadic", NM = "_ZNK5clang9MacroInfo10isVariadicEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    return IsC99Varargs || IsGNUVarargs;
  }

  
  /// \brief Return true if this macro requires processing before expansion.
  ///
  /// This is true only for builtin macro, such as \__LINE__, whose values
  /// are not given by fixed textual expansions.  Regular predefined macros
  /// from the "<built-in>" buffer are not reported as builtins by this
  /// function.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isBuiltinMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 210,
   FQN = "clang::MacroInfo::isBuiltinMacro", NM = "_ZNK5clang9MacroInfo14isBuiltinMacroEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo14isBuiltinMacroEv")
  //</editor-fold>
  public boolean isBuiltinMacro() /*const*/ {
    return IsBuiltinMacro;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::hasCommaPasting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 212,
   FQN = "clang::MacroInfo::hasCommaPasting", NM = "_ZNK5clang9MacroInfo15hasCommaPastingEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo15hasCommaPastingEv")
  //</editor-fold>
  public boolean hasCommaPasting() /*const*/ {
    return HasCommaPasting;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setHasCommaPasting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 215,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 213,
   FQN = "clang::MacroInfo::setHasCommaPasting", NM = "_ZN5clang9MacroInfo18setHasCommaPastingEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo18setHasCommaPastingEv")
  //</editor-fold>
  public void setHasCommaPasting() {
    HasCommaPasting = true;
  }

  
  /// \brief Return false if this macro is defined in the main file and has
  /// not yet been used.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 217,
   FQN = "clang::MacroInfo::isUsed", NM = "_ZNK5clang9MacroInfo6isUsedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo6isUsedEv")
  //</editor-fold>
  public boolean isUsed() /*const*/ {
    return IsUsed;
  }

  
  /// \brief Return true if this macro can be redefined without warning.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isAllowRedefinitionsWithoutWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 222,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 220,
   FQN = "clang::MacroInfo::isAllowRedefinitionsWithoutWarning", NM = "_ZNK5clang9MacroInfo34isAllowRedefinitionsWithoutWarningEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo34isAllowRedefinitionsWithoutWarningEv")
  //</editor-fold>
  public boolean isAllowRedefinitionsWithoutWarning() /*const*/ {
    return IsAllowRedefinitionsWithoutWarning;
  }

  
  /// \brief Return true if we should emit a warning if the macro is unused.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isWarnIfUnused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 227,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 225,
   FQN = "clang::MacroInfo::isWarnIfUnused", NM = "_ZNK5clang9MacroInfo14isWarnIfUnusedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo14isWarnIfUnusedEv")
  //</editor-fold>
  public boolean isWarnIfUnused() /*const*/ {
    return IsWarnIfUnused;
  }


  /// \brief Return the number of tokens that this macro expands to.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getNumTokens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 231,
   FQN = "clang::MacroInfo::getNumTokens", NM = "_ZNK5clang9MacroInfo12getNumTokensEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo12getNumTokensEv")
  //</editor-fold>
  public /*uint*/int getNumTokens() /*const*/ {
    return ReplacementTokens.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getReplacementToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 235,
   FQN = "clang::MacroInfo::getReplacementToken", NM = "_ZNK5clang9MacroInfo19getReplacementTokenEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo19getReplacementTokenEj")
  //</editor-fold>
  public /*const*/Token /*&*/ getReplacementToken(/*uint*/int Tok) /*const*/ {
    assert ($less_uint(Tok, ReplacementTokens.size())) : "Invalid token #";
    return ReplacementTokens.$at(Tok);
  }


  /*typedef SmallVectorImpl<Token>::const_iterator tokens_iterator*/
//  public final class tokens_iterator extends SmallVectorToken.iterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::tokens_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 239,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 241,
   FQN = "clang::MacroInfo::tokens_begin", NM = "_ZNK5clang9MacroInfo12tokens_beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo12tokens_beginEv")
  //</editor-fold>
  public SmallVectorToken.iterator tokens_begin() /*const*/ {
    if (NativeTrace.VERBOSE_MODE) llvm.errs().$out("use $tokens() and getNumTokens()\n");
    return ReplacementTokens.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::tokens_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 240,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 242,
   FQN = "clang::MacroInfo::tokens_end", NM = "_ZNK5clang9MacroInfo10tokens_endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo10tokens_endEv")
  //</editor-fold>
  public SmallVectorToken.iterator tokens_end() /*const*/ {
    if (NativeTrace.VERBOSE_MODE) llvm.errs().$out("use $tokens() and getNumTokens()\n");
    return ReplacementTokens.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::tokens_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 241,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 243,
   FQN = "clang::MacroInfo::tokens_empty", NM = "_ZNK5clang9MacroInfo12tokens_emptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo12tokens_emptyEv")
  //</editor-fold>
  public boolean tokens_empty() /*const*/ {
    return ReplacementTokens.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::tokens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 242,
   FQN="clang::MacroInfo::tokens", NM="_ZNK5clang9MacroInfo6tokensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo6tokensEv")
  //</editor-fold>
  public ArrayRefToken tokens() /*const*/ {
    if (NativeTrace.VERBOSE_MODE) llvm.errs().$out("use $tokens() and getNumTokens()\n");
    return new ArrayRefToken(ReplacementTokens);
  }
  
  public Token[] $tokens() {
    return ReplacementTokens.$array();
  }
    
  /// \brief Add the specified token to the replacement text for the macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::AddTokenToBody">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 246,
   FQN = "clang::MacroInfo::AddTokenToBody", NM = "_ZN5clang9MacroInfo14AddTokenToBodyERKNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo14AddTokenToBodyERKNS_5TokenE")
  //</editor-fold>
  public void AddTokenToBody(/*const*/Token /*&*/ Tok) {
    assert false : "use AddDeserializedTokenToBody or setReplacementTokens at once";
    assert (!IsDefinitionLengthCached) : "Changing replacement tokens after definition length got calculated";
    ReplacementTokens.push_back(Tok);
  }

  /*ASTReader friend*/public void AddDeserializedTokenToBody(/*const*/Token /*&*/ Tok) {
    assert (!IsDefinitionLengthCached) : "Changing replacement tokens after definition length got calculated";
    assert this.ReplacementTokens == DUMMY || !this.ReplacementTokens.empty() : "should be initial state or already with deserialized token";
    if (this.ReplacementTokens == DUMMY) {
      this.ReplacementTokens = new SmallVectorToken(1, null);
    }
    ReplacementTokens.push_back(Tok);
  }

  /*Preprocessor*/void setReplacementTokens(SmallVectorToken BodyTokens) {
    assert (!IsDefinitionLengthCached) : "Changing replacement tokens after definition length got calculated";
    assert this.ReplacementTokens == DUMMY;
    this.ReplacementTokens = BodyTokens.deepCopy();
  }
  
  /// \brief Return true if this macro is enabled.
  ///
  /// In other words, that we are not currently in an expansion of this macro.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 255,
   FQN = "clang::MacroInfo::isEnabled", NM = "_ZNK5clang9MacroInfo9isEnabledEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo9isEnabledEv")
  //</editor-fold>
  public boolean isEnabled() /*const*/ {
    return !IsDisabled;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::EnableMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 257,
   FQN = "clang::MacroInfo::EnableMacro", NM = "_ZN5clang9MacroInfo11EnableMacroEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo11EnableMacroEv")
  //</editor-fold>
  public void EnableMacro() {
    assert (IsDisabled) : "Cannot enable an already-enabled macro!";
    IsDisabled = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::DisableMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 262,
   FQN = "clang::MacroInfo::DisableMacro", NM = "_ZN5clang9MacroInfo12DisableMacroEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo12DisableMacroEv")
  //</editor-fold>
  public void DisableMacro() {
    assert (!IsDisabled) : "Cannot disable an already-disabled macro!";
    IsDisabled = true;
  }

  
  /// \brief Determine whether this macro info came from an AST file (such as
  /// a precompiled header or module) rather than having been parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isFromASTFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 269,
   FQN = "clang::MacroInfo::isFromASTFile", NM = "_ZNK5clang9MacroInfo13isFromASTFileEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo13isFromASTFileEv")
  //</editor-fold>
  public boolean isFromASTFile() /*const*/ {
    return FromASTFile;
  }

  
  /// \brief Determine whether this macro was used for a header guard.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::isUsedForHeaderGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 272,
   FQN = "clang::MacroInfo::isUsedForHeaderGuard", NM = "_ZNK5clang9MacroInfo20isUsedForHeaderGuardEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo20isUsedForHeaderGuardEv")
  //</editor-fold>
  public boolean isUsedForHeaderGuard() /*const*/ {
    return UsedForHeaderGuard;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setUsedForHeaderGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 274,
   FQN = "clang::MacroInfo::setUsedForHeaderGuard", NM = "_ZN5clang9MacroInfo21setUsedForHeaderGuardEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo21setUsedForHeaderGuardEb")
  //</editor-fold>
  public void setUsedForHeaderGuard(boolean Val) {
    UsedForHeaderGuard = Val;
  }
  
  
  /// \brief Retrieve the global ID of the module that owns this particular
  /// macro info.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getOwningModuleID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 278,
   FQN = "clang::MacroInfo::getOwningModuleID", NM = "_ZNK5clang9MacroInfo17getOwningModuleIDEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo17getOwningModuleIDEv")
  //</editor-fold>
  public /*uint*/int getOwningModuleID() /*const*/ {
    if (isFromASTFile()) {
      // FIXME: this + 1 
      return this.OwningModuleID;///*const*/uint$ptr/*uint P*/ )(this + 1).$star();
    }
    
    return 0;
  }
  
  
//<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 129,
   FQN = "clang::MacroInfo::dump", NM = "_ZNK5clang9MacroInfo4dumpEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    dump(llvm.errs());
  }
  public void dump(raw_ostream /*&*/ Out/*=llvm.errs()*/)  /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    
    // FIXME: Dump locations.
    Out.$out(/*KEEP_STR*/"MacroInfo ").$out(this);
    if (IsBuiltinMacro) {
      Out.$out(/*KEEP_STR*/" builtin");
    }
    if (IsDisabled) {
      Out.$out(/*KEEP_STR*/" disabled");
    }
    if (IsUsed) {
      Out.$out(/*KEEP_STR*/" used");
    }
    if (IsAllowRedefinitionsWithoutWarning) {
      Out.$out(/*KEEP_STR*/" allow_redefinitions_without_warning");
    }
    if (IsWarnIfUnused) {
      Out.$out(/*KEEP_STR*/" warn_if_unused");
    }
    if (FromASTFile) {
      Out.$out(/*KEEP_STR*/" imported");
    }
    if (UsedForHeaderGuard) {
      Out.$out(/*KEEP_STR*/" header_guard");
    }
    
    Out.$out(/*KEEP_STR*/"\n    #define <macro>");
    if (IsFunctionLike) {
      Out.$out(/*KEEP_STR*/$LPAREN);
      for (/*uint*/int I = 0; I != NumArguments; ++I) {
        if ((I != 0)) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        Out.$out(ArgumentList[I].getName());
      }
      if (IsC99Varargs || IsGNUVarargs) {
        if ((NumArguments != 0) && IsC99Varargs) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        Out.$out(/*KEEP_STR*/$ELLIPSIS);
      }
      Out.$out(/*KEEP_STR*/$RPAREN);
    }
    
    boolean First = true;
    for (/*const*/ Token /*&*/ Tok : ReplacementTokens) {
      // Leading space is semantically meaningful in a macro definition,
      // so preserve it in the dump output.
      if (First || Tok.hasLeadingSpace()) {
        Out.$out(/*KEEP_STR*/$SPACE);
      }
      First = false;
      {
        
        /*const*/char$ptr/*char P*/ Punc = $tryClone(tok.getPunctuatorSpelling(Tok.getKind()));
        if ((Punc != null)) {
          Out.$out(Punc);
        } else if (Tok.isLiteral() && (Tok.getLiteralData() != null)) {
          Out.$out(new StringRef(Tok.getLiteralData(), Tok.getLength()));
        } else {
          IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
          if ((II != null)) {
            Out.$out(II.getName());
          } else {
            Out.$out(Tok.getName());
          }
        }
      }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::getDefinitionLengthSlow">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 36,
   FQN = "clang::MacroInfo::getDefinitionLengthSlow", NM = "_ZNK5clang9MacroInfo23getDefinitionLengthSlowERNS_13SourceManagerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang9MacroInfo23getDefinitionLengthSlowERNS_13SourceManagerE")
  //</editor-fold>
  private /*uint*/int getDefinitionLengthSlow(SourceManager /*&*/ SM) /*const*/ {
    assert (!IsDefinitionLengthCached);
    IsDefinitionLengthCached = true;
    if (ReplacementTokens.empty()) {
      return (DefinitionLength = 0);
    }
    
    /*const*/Token /*&*/ firstToken = ReplacementTokens.front();
    /*const*/Token /*&*/ lastToken = ReplacementTokens.back();
    /*SourceLocation*/int macroStart = firstToken.$getLocation();
    /*SourceLocation*/int macroEnd = lastToken.$getLocation();
    assert SourceLocation.isValid(macroStart) && SourceLocation.isValid(macroEnd);
    assert ((SourceLocation.isFileID(macroStart) || firstToken.is(tok.TokenKind.comment))) : "Macro defined in macro?";
    assert ((SourceLocation.isFileID(macroEnd) || lastToken.is(tok.TokenKind.comment))) : "Macro defined in macro?";
    long/*<FileID, uint>*/ startInfo = SM.getDecomposedExpansionLoc(macroStart);
    long/*<FileID, uint>*/ endInfo = SM.getDecomposedExpansionLoc(macroEnd);
    assert ($first_FileID(startInfo) == $first_FileID(endInfo)) : "Macro definition spanning multiple FileIDs ?";
    assert ($second_uint(startInfo) <= $second_uint(endInfo));
    DefinitionLength =  $second_uint(endInfo) - $second_uint(startInfo);
    DefinitionLength += lastToken.getLength();
    
    return DefinitionLength;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroInfo::setOwningModuleID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 290,
   FQN = "clang::MacroInfo::setOwningModuleID", NM = "_ZN5clang9MacroInfo17setOwningModuleIDEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang9MacroInfo17setOwningModuleIDEj")
  //</editor-fold>
  /*friend*/ void setOwningModuleID(/*uint*/int ID) {
    assert (isFromASTFile());
    // FIXME: this + 1 
    // (uint$ptr/*uint P*/ )(this + 1).$star() = ID;
    this.OwningModuleID = ID;
  }

  
  /*friend  class Preprocessor*/

  @Override
  public String toString() {
    return "MacroInfo{" + "Loc=[" + Location + "]" // NOI18N
            + ", EndLoc=[" + EndLocation + "]" // NOI18N
            + ", IsFunLike=" + IsFunctionLike // NOI18N
            + ", NumArgs=" + NumArguments // NOI18N
            + (NumArguments == 0 ? "" : ", Args=" + Arrays.toString(ArgumentList)) // NOI18N
            + ", BodyToks=" + ReplacementTokens // NOI18N
            + ", DefLen=" + DefinitionLength // NOI18N
            + ", IsDefLenCached=" + IsDefinitionLengthCached // NOI18N
            + ", IsC99Varargs=" + IsC99Varargs // NOI18N
            + ", IsGNUVarargs=" + IsGNUVarargs // NOI18N
            + ", IsBuiltinMacro=" + IsBuiltinMacro // NOI18N
            + ", HasCommaPasting=" + HasCommaPasting // NOI18N
            + ", IsDisabled=" + IsDisabled // NOI18N
            + ", IsUsed=" + IsUsed // NOI18N
            + ", IsAllowRedefinitionsWithoutWarning=" + IsAllowRedefinitionsWithoutWarning // NOI18N
            + ", IsWarnIfUnused=" + IsWarnIfUnused // NOI18N
            + ", FromASTFile=" + FromASTFile // NOI18N
            + ", UsedForHeaderGuard=" + UsedForHeaderGuard // NOI18N
            + ", OwningModuleID=" + OwningModuleID + '}';
  }
}
