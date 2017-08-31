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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.lex.llvm.SmallVectorToken;
import java.util.Arrays;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clank.support.Unsigned.*;


/// MacroArgs - An instance of this class captures information about
/// the formal arguments specified to a function-like macro invocation.
//<editor-fold defaultstate="collapsed" desc="clang::MacroArgs">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", line = 29,
 FQN = "clang::MacroArgs", NM = "_ZN5clang9MacroArgsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgsE")
//</editor-fold>
public class MacroArgs implements Destructors.ClassWithDestructor {
  // JAVA: limit of amount of tokens in an expanded body of macro argument
  private static final int MAX_PARAMETERS_SIZE = Integer.getInteger("apt.limit.expanded.params", 1000); // NOI18N
  
  /// NumUnexpArgTokens - The number of raw, unexpanded tokens for the
  /// arguments.  All of the actual argument tokens are allocated immediately
  /// after the MacroArgs object in memory.  This is all of the arguments
  /// concatenated together, with 'EOF' markers at the end of each argument.
  private /*uint*/int NumUnexpArgTokens;
  //FIXME: UnexpArgTokens is extra field to eleminate "this+1" 
  private final Token[] UnexpArgTokens;
  
  /// VarargsElided - True if this is a C99 style varargs macro invocation and
  /// there was no argument specified for the "..." argument.  If the argument
  /// was specified (even empty) or this isn't a C99 style varargs function, or
  /// if in strict mode and the C99 varargs macro had only a ... argument, this
  /// is false.
  private boolean VarargsElided;
  
  /// PreExpArgTokens - Pre-expanded tokens for arguments that need them.  Empty
  /// if not yet computed.  This includes the EOF marker at the end of the
  /// stream.
  private final SmallVector<SmallVectorToken> PreExpArgTokens;
  
  /// StringifiedArgs - This contains arguments in 'stringified' form.  If the
  /// stringified form of an argument has not yet been computed, this is empty.
  private final SmallVectorToken StringifiedArgs;
  
  /// ArgCache - This is a linked list of MacroArgs objects that the
  /// Preprocessor owns which we use to avoid thrashing malloc/free.
  private MacroArgs/*MacroArgs P*/ ArgCache;
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::MacroArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", line = 56,
   FQN = "clang::MacroArgs::MacroArgs", NM = "_ZN5clang9MacroArgsC1Ejb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgsC1Ejb")
  //</editor-fold>
  private MacroArgs(/*uint*/int NumToks, boolean varargsElided) {
    /* : NumUnexpArgTokens(NumToks), VarargsElided(varargsElided), PreExpArgTokens(), StringifiedArgs(), ArgCache(null)*/ 
    //START JInit
    this.NumUnexpArgTokens = NumToks;
    this.UnexpArgTokens = new Token[(int)NumToks];
    for (int i = 0; i < this.UnexpArgTokens.length; i++) {
      this.UnexpArgTokens[i] = new Token();
    }    
    this.VarargsElided = varargsElided;
    this.PreExpArgTokens = new SmallVector<SmallVectorToken>(0, null);
    this.StringifiedArgs = new SmallVectorToken(0, null);
    this.ArgCache = null;
    //END JInit
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::~MacroArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", line = 59,
   FQN="clang::MacroArgs::~MacroArgs", NM="_ZN5clang9MacroArgsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgsD0Ev")
  //</editor-fold>
  @Override public/*private*/ void $destroy()/* = default*/ {
    // JAVA: just set size to 0 to prevent null'ing inner pool for further reuse
    if (false) {
      // JAVA: call all destructors
      for (/*uint*/int i = 0, e = PreExpArgTokens.size(); i != e; ++i)  {
        PreExpArgTokens.$at(i).$destroy();
      }
    } else {
      PreExpArgTokens.set_size(0);
    }
    this.PreExpArgTokens.set_size(0);
    this.StringifiedArgs.set_size(0);
    // PERF: don't do extra work (this instance could be reused for smaller num of tokens than whole array)
    for (int i = 0; i < NumUnexpArgTokens; i++) {
      UnexpArgTokens[i].$destroy();
    }
  }

/*public:*/
  /// MacroArgs ctor function - Create a new MacroArgs object with the specified
  /// macro and argument info.
  
  /// MacroArgs ctor function - This destroys the vector passed in.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::create">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 25,
   FQN = "clang::MacroArgs::create", NM = "_ZN5clang9MacroArgs6createEPKNS_9MacroInfoEN4llvm8ArrayRefINS_5TokenEEEbRNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs6createEPKNS_9MacroInfoEN4llvm8ArrayRefINS_5TokenEEEbRNS_12PreprocessorE")
  //</editor-fold>
  public static MacroArgs/*MacroArgs P*/ create(/*const*/MacroInfo /*P*/ MI, SmallVectorToken UnexpArgTokens, boolean VarargsElided, Preprocessor /*&*/ PP) {
    assert (MI.isFunctionLike()) : "Can't have args for an object-like macro!";
    
    MacroArgs/*MacroArgs PP*/ ResultEnt = null;
    MacroArgs/*MacroArgs PP*/ PreviousEnt = null;
    MacroArgs/*MacroArgs PP*/ PreviousForResultEnt = null;
    /*uint*/int ClosestMatch = std.UINT32_MAX/*U*/;
    int neededSize = UnexpArgTokens.size();
    
    // See if we have an entry with a big enough argument list to reuse on the
    // free list.  If so, reuse it.
    for (MacroArgs/*MacroArgs PP*/ Entry = PP.MacroArgCache; Entry != null; PreviousEnt = Entry, Entry = Entry.ArgCache)  {
      if ($greatereq_uint(Entry.NumUnexpArgTokens, neededSize) 
        && $less_uint($Deref(Entry.NumUnexpArgTokens), ClosestMatch)) {
        ResultEnt = Entry;
        // remember who pointed to this candidate
        PreviousForResultEnt = PreviousEnt;
        
        // If we have an exact match, use it.
        if (Entry.NumUnexpArgTokens == neededSize) {
          break;
        }
        // Otherwise, use the best fit.
        ClosestMatch = $Deref(Entry.NumUnexpArgTokens);
      }
    }
    
    MacroArgs/*MacroArgs P*/ Result;
    if (ResultEnt == null) {
      // Allocate memory for a MacroArgs object with the lexer tokens at the end.
      if (false) std.<MacroArgs>malloc(sizeof(MacroArgs.class) + neededSize * sizeof(Token.class));
      // Construct the MacroArgs object.
      /*FIXME:*/Result = new /*(Result)*/ MacroArgs(neededSize, VarargsElided);
    } else {
      Result = ResultEnt;
      assert Result != null;
      // Unlink this node from the preprocessors singly linked list.
      PP.MacroArgCacheNumEntries--;
      PP.MacroArgCacheCapacity -= Result.$UnexpArgTokens().length;
      if (PreviousForResultEnt == null) {
        // head of list
        assert PP.MacroArgCache == Result;
        PP.MacroArgCache = Result.ArgCache;
      } else {
        // make connection from prev to the next
        assert PreviousForResultEnt.ArgCache == Result;
        PreviousForResultEnt.ArgCache = Result.ArgCache;
      }
      Result.NumUnexpArgTokens = neededSize;
      Result.VarargsElided = VarargsElided;
    }
    
    // Copy the actual unexpanded tokens to immediately after the result ptr.
    if (!UnexpArgTokens.empty()) {
      if (false) std.copy(UnexpArgTokens.$array(), 0, neededSize, Result.$UnexpArgTokens(), 0);
      for (int i = 0; i < neededSize; i++) {
        Result.$UnexpArgTokens()[i].$assign(UnexpArgTokens.$array()[i]);
      }
    }
    
    return Result;
  }

//  private static void checkCycle(type$ptr<MacroArgs> macroArgs) {
//    IdentityHashMap<type$ptr<MacroArgs>, Boolean> map = new IdentityHashMap<type$ptr<MacroArgs>, Boolean>();
//    while (macroArgs.$star() != null) {
//      if (map.containsKey(macroArgs)) {
//        throw new RuntimeException("Cycle found!");
//      }
//      map.put(macroArgs, TRUE);
//      macroArgs = macroArgs.$star().ArgCache;
//    }
//  }
  
  /// destroy - Destroy and deallocate the memory for this object.
  ///
  
  /// destroy - Destroy and deallocate the memory for this object.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::destroy">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 73,
   FQN = "clang::MacroArgs::destroy", NM = "_ZN5clang9MacroArgs7destroyERNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs7destroyERNS_12PreprocessorE")
  //</editor-fold>
  public void destroy(Preprocessor /*&*/ PP) {
    StringifiedArgs.clear();
    
    // Don't clear PreExpArgTokens, just clear the entries.  Clearing the entries
    // would deallocate the element vectors.
    for (/*uint*/int i = 0, e = PreExpArgTokens.size(); i != e; ++i)  {
      PreExpArgTokens.$at(i).clear();
    }
    
    // Add this to the preprocessor's free list.
    int capacity = this.$UnexpArgTokens().length;
    // but not huge objects 
    if ((capacity < Preprocessor.MACRO_ARG_ELEMENT_MAX_CAPACITY) &&
      // and if enough space
      (PP.MacroArgCacheCapacity < Preprocessor.MACRO_ARG_CACHE_MAX_CAPACITY)) {
      ArgCache = PP.MacroArgCache;
      PP.MacroArgCache = this;
      PP.MacroArgCacheNumEntries++;
      PP.MacroArgCacheCapacity += capacity;
    } else {
      if (NativeTrace.VERBOSE_MODE) {
        llvm.errs().$out("<=Skip MacroArg ").$out(NativeTrace.formatNumber(capacity, 12));
        llvm.errs().$out(" Where Total Capacity ").$out(NativeTrace.formatNumber(PP.MacroArgCacheCapacity, 12)).$out($LF);
      }
    }
  }

  
  /// ArgNeedsPreexpansion - If we can prove that the argument won't be affected
  /// by pre-expansion, return false.  Otherwise, conservatively return true.
  
  /// ArgNeedsPreexpansion - If we can prove that the argument won't be affected
  /// by pre-expansion, return false.  Otherwise, conservatively return true.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::ArgNeedsPreexpansion">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 131,
   FQN = "clang::MacroArgs::ArgNeedsPreexpansion", NM = "_ZNK5clang9MacroArgs20ArgNeedsPreexpansionEPKNS_5TokenERNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZNK5clang9MacroArgs20ArgNeedsPreexpansionEPKNS_5TokenERNS_12PreprocessorE")
  //</editor-fold>
  public static boolean ArgNeedsPreexpansion(/*const*/Token[] /*P*/ ArgTok, int ArgTokenIdx, Preprocessor /*&*/ PP) /*const*/ {
    // If there are no identifiers in the argument list, or if the identifiers are
    // known to not be macros, pre-expansion won't modify it.
    for (; ArgTok[ArgTokenIdx].isNot(tok.TokenKind.eof); ++ArgTokenIdx)  {
      {
        IdentifierInfo /*P*/ II = ArgTok[ArgTokenIdx].getIdentifierInfo();
        if ((II != null)) {
          if (II.hasMacroDefinition() ) {
            // Return true even though the macro could be a function-like macro
            // without a following '(' token, or could be disabled, or not visible.
            return true;
          }
        }
      }
    }
    return false;
  }

  
  /// getUnexpArgument - Return a pointer to the first token of the unexpanded
  /// token list for the specified formal.
  ///
  
  /// getUnexpArgument - Return the unexpanded tokens for the specified formal.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::getUnexpArgument">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 113,
   FQN = "clang::MacroArgs::getUnexpArgument", NM = "_ZNK5clang9MacroArgs16getUnexpArgumentEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZNK5clang9MacroArgs16getUnexpArgumentEj")
  //</editor-fold>
  public int getUnexpArgument(/*uint*/int Arg) /*const*/ {
    // The unexpanded argument tokens start immediately after the MacroArgs object
    // in memory.
//    /*const*/type$ptr<Token> /*P*/ Start = (/*const*/type$ptr<Token> /*P*/ )(this + 1);
    /*const*/int /*P*/ Result = 0;
    // Scan to find Arg.
    for (; (Arg != 0); Result++) {
      assert (Result < NumUnexpArgTokens) : "Invalid arg #";
      if (UnexpArgTokens[Result].is(tok.TokenKind.eof)) {
        --Arg;
      }
    }
    assert (Result < NumUnexpArgTokens) : "Invalid arg #";
    return Result;
  }

  // JAVA: access to the array of unexpanded arguments
  public Token[] $UnexpArgTokens() {
    return UnexpArgTokens;
  }
  
  /// getArgLength - Given a pointer to an expanded or unexpanded argument,
  /// return the number of tokens, not counting the EOF, that make up the
  /// argument.
  
  /// getArgLength - Given a pointer to an expanded or unexpanded argument,
  /// return the number of tokens, not counting the EOF, that make up the
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::getArgLength">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 103,
   FQN = "clang::MacroArgs::getArgLength", NM = "_ZN5clang9MacroArgs12getArgLengthEPKNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs12getArgLengthEPKNS_5TokenE")
  //</editor-fold>
  public static /*uint*/int getArgLength(/*const*/Token[] /*P*/ ArgPtr, int ArgPtrIdx) {
    /*uint*/int NumArgTokens = 0;
    for (;ArgPtr[ArgPtrIdx].isNot(tok.TokenKind.eof); ArgPtrIdx++) {
      ++NumArgTokens;
    }
    return NumArgTokens;
  }

  
  /// getPreExpArgument - Return the pre-expanded form of the specified
  /// argument.
  
  /// getPreExpArgument - Return the pre-expanded form of the specified
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::getPreExpArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", old_line = 147,
   FQN = "clang::MacroArgs::getPreExpArgument", NM = "_ZN5clang9MacroArgs17getPreExpArgumentEjPKNS_9MacroInfoERNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs17getPreExpArgumentEjPKNS_9MacroInfoERNS_12PreprocessorE")
  //</editor-fold>
  public /*const*/SmallVectorToken /*&*/ getPreExpArgument(/*uint*/int Arg, /*const*/MacroInfo /*P*/ MI, Preprocessor /*&*/ PP) {
    final boolean PreExpandingMacroArgs = PP.InMacroArgPreExpansion;
//    try {//PERF: remove try/finally
      assert (Arg < MI.getNumArgs()) : "Invalid argument number!";
      
      // If we have already computed this, return it.
      if (PreExpArgTokens.size() < MI.getNumArgs()) {
        PreExpArgTokens.resize(MI.getNumArgs(), new SmallVectorToken(0, null));
      }
      
      SmallVectorToken /*&*/ Result = PreExpArgTokens.$at(Arg);
      if (!Result.empty()) {
        // Restore on return
        PP.InMacroArgPreExpansion = PreExpandingMacroArgs;        
        return Result;
      }
      
      PP.InMacroArgPreExpansion = true;
      
      /*const*/int /*P*/ AT = getUnexpArgument(Arg);
      /*uint*/int NumToks = getArgLength($UnexpArgTokens(), AT) + 1; // Include the EOF.
      
      // Otherwise, we have to pre-expand this argument, populating Result.  To do
      // this, we set up a fake TokenLexer to lex from the unexpanded argument
      // list.  With this installed, we lex expanded tokens until we hit the EOF
      // token at the end of the unexp list.
      PP.EnterTokenStream($UnexpArgTokens(), AT, NumToks, /*DisableMacroExpansion=*/ false, /*OwnsTokens=*/ false);
      
      // Lex all of the macro-expanded tokens into Result.
      
      // JAVA: Added threshold for amount of tokens in macro argument body
      boolean thresholdReached = false;
      do {
        if (thresholdReached) {
          Result.clear();
        } else if (Result.size() >= MAX_PARAMETERS_SIZE) {
          thresholdReached = true;
        }
        Result.push_back(new Token());
        Token /*&*/ Tok = Result.back();
        PP.Lex(Tok);
      } while (Result.back().isNot(tok.TokenKind.eof));
      
      // Pop the token stream off the top of the stack.  We know that the internal
      // pointer inside of it is to the "end" of the token stream, but the stack
      // will not otherwise be popped until the next token is lexed.  The problem is
      // that the token may be lexed sometime after the vector of tokens itself is
      // destroyed, which would be badness.
      if (PP.InCachingLexMode()) {
        PP.ExitCachingLexMode();
      }
      PP.RemoveTopOfLexerStack();
      // Restore on return
      PP.InMacroArgPreExpansion = PreExpandingMacroArgs;
      return Result;
//    } finally {
//    }
  }

  
  /// getStringifiedArgument - Compute, cache, and return the specified argument
  /// that has been 'stringified' as required by the # operator.
  
  /// getStringifiedArgument - Compute, cache, and return the specified argument
  /// that has been 'stringified' as required by the # operator.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::getStringifiedArgument">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 297,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", old_line = 298,
   FQN = "clang::MacroArgs::getStringifiedArgument", NM = "_ZN5clang9MacroArgs22getStringifiedArgumentEjRNS_12PreprocessorENS_14SourceLocationES3_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs22getStringifiedArgumentEjRNS_12PreprocessorENS_14SourceLocationES3_")
  //</editor-fold>
  public /*const*/Token /*&*/ getStringifiedArgument(/*uint*/int ArgNo, Preprocessor /*&*/ PP, /*SourceLocation*/int ExpansionLocStart, /*SourceLocation*/int ExpansionLocEnd) {
    assert (ArgNo < NumUnexpArgTokens) : "Invalid argument number!";
    if (StringifiedArgs.empty()) {
      StringifiedArgs.resize(getNumArguments());
      // VVV: instead of memset
      // clear using startToken, because resize only call light weight $destroy 
      // and old tokens properties remain
      if (false) {
        memset($AddrOf(StringifiedArgs.ptr$at(0)), new Token(), getNumArguments());
      } else {
        Token[] $array = StringifiedArgs.$array();
        for (int i = 0; i < getNumArguments(); i++) {
          $array[i].startToken();
        }
      }
    }
    if (StringifiedArgs.$at(ArgNo).isNot(tok.TokenKind.string_literal)) {
      StringifiedArgs.$set(ArgNo, StringifyArgument($UnexpArgTokens(), getUnexpArgument(ArgNo), PP, false, ExpansionLocStart, ExpansionLocEnd));
    }
    return StringifiedArgs.$at(ArgNo);
  }

  
  /// getNumArguments - Return the number of arguments passed into this macro
  /// invocation.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::getNumArguments">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", old_line = 98,
   FQN = "clang::MacroArgs::getNumArguments", NM = "_ZNK5clang9MacroArgs15getNumArgumentsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZNK5clang9MacroArgs15getNumArgumentsEv")
  //</editor-fold>
  public /*uint*/int getNumArguments() /*const*/ {
    return NumUnexpArgTokens;
  }

  
  /// isVarargsElidedUse - Return true if this is a C99 style varargs macro
  /// invocation and there was no argument specified for the "..." argument.  If
  /// the argument was specified (even empty) or this isn't a C99 style varargs
  /// function, or if in strict mode and the C99 varargs macro had only a ...
  /// argument, this returns false.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::isVarargsElidedUse">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroArgs.h", old_line = 106,
   FQN = "clang::MacroArgs::isVarargsElidedUse", NM = "_ZNK5clang9MacroArgs18isVarargsElidedUseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZNK5clang9MacroArgs18isVarargsElidedUseEv")
  //</editor-fold>
  public boolean isVarargsElidedUse() /*const*/ {
    return VarargsElided;
  }

  
  /// StringifyArgument - Implement C99 6.10.3.2p2, converting a sequence of
  /// tokens into the literal string token that should be produced by the C #
  /// preprocessor operator.  If Charify is true, then it should be turned into
  /// a character literal for the Microsoft charize (#@) extension.
  ///
  
  /// StringifyArgument - Implement C99 6.10.3.2p2, converting a sequence of
  /// tokens into the literal string token that should be produced by the C #
  /// preprocessor operator.  If Charify is true, then it should be turned into
  /// a character literal for the Microsoft charize (#@) extension.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::StringifyArgument">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 194,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", old_line = 195,
   FQN = "clang::MacroArgs::StringifyArgument", NM = "_ZN5clang9MacroArgs17StringifyArgumentEPKNS_5TokenERNS_12PreprocessorEbNS_14SourceLocationES6_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs17StringifyArgumentEPKNS_5TokenERNS_12PreprocessorEbNS_14SourceLocationES6_")
  //</editor-fold>
  public static Token StringifyArgument(/*const*/final Token[] /*P*/ ArgToks, int ArgToksIdx, Preprocessor /*&*/ PP, boolean Charify, /*SourceLocation*/int ExpansionLocStart, /*SourceLocation*/int ExpansionLocEnd) {
    Token _Tok/*J*/= new Token();
    _Tok.startToken();
    _Tok.setKind(Charify ? tok.TokenKind.char_constant : tok.TokenKind.string_literal);

    /*const*/int /*P*/ ArgTokStart = ArgToksIdx;

    // Stringify all the tokens.
    SmallString/*128*/ Result/*J*/= PP.$getStringifyArgument_Result();
    try {
      Result.$addassign($('\"'));

      boolean isFirst = true;
      for (; ArgToks[ArgToksIdx].isNot(tok.TokenKind.eof); ++ArgToksIdx) {
        /*const*/Token /*&*/ Tok = $Deref(ArgToks[ArgToksIdx]);
        if (!isFirst && (Tok.hasLeadingSpace() || Tok.isAtStartOfLine())) {
          Result.$addassign($(' '));
        }
        isFirst = false;

        // If this is a string or character constant, escape the token as specified
        // by 6.10.3.2p2.
        if (tok.isStringLiteral(Tok.getKind()) // "foo", u8R"x(foo)x"_bar, etc.
           || Tok.is(tok.TokenKind.char_constant) // 'x'
           || Tok.is(tok.TokenKind.wide_char_constant) // L'x'.
           || Tok.is(tok.TokenKind.utf8_char_constant) // u8'x'.
           || Tok.is(tok.TokenKind.utf16_char_constant) // u'x'.
           || Tok.is(tok.TokenKind.utf32_char_constant)) { // U'x'.
          bool$ptr Invalid = create_bool$ptr(false);
          std.string TokStr = PP.getSpelling(Tok, $AddrOf(Invalid));
          if (!Invalid.$star()) {
            std.string Str = Lexer.Stringify(TokStr);
            Result.append(Str);
          }
        } else if (Tok.is(tok.TokenKind.code_completion)) {
          PP.CodeCompleteNaturalLanguage();
        } else {
          // Otherwise, just append the token.  Do some gymnastics to get the token
          // in place and avoid copies where possible.
          /*uint*/int CurStrLen = Result.size();
          Result.resize(CurStrLen + Tok.getLength());
  //        /*const*/type$ref<char$ptr>/*char P*/ BufPtr = create_type$ref(/*AddrOf*/Result.data().$add(CurStrLen));
  //        bool$ptr Invalid = create_bool$ptr(false);
          /*uint*/int ActualTokLen = PP.copySpelling(Tok, Result, $AddrOf(CurStrLen));
          if (ActualTokLen != Lexer.INVALID_SPELLING) {
            // If getSpelling returned a pointer to an already uniqued version of
            // the string instead of filling in BufPtr, memcpy it onto our string.

            // JAVA: already copied
  //          if (ActualTokLen != 0 && BufPtr.$deref().$noteq(/*AddrOf*/Result.$at(CurStrLen))) {
  //            memcpy(/*AddrOf*/Result.ref$at(CurStrLen).deref$ptr(), BufPtr.$deref(), ActualTokLen);
  //          }

            // If the token was dirty, the spelling may be shorter than the token.
            if (ActualTokLen != Tok.getLength()) {
              Result.resize(CurStrLen + ActualTokLen);
            }
          }
        }
      }

      // If the last character of the string is a \, and if it isn't escaped, this
      // is an invalid string literal, diagnose it as specified in C99.
      if (Result.back() == '\\') {
        // Count the number of consequtive \ characters.  If even, then they are
        // just escaped backslashes, otherwise it's an error.
        /*uint*/int FirstNonSlash = Result.size() - 2;
        // Guaranteed to find the starting " if nothing else.
        while (Result.$at(FirstNonSlash) == '\\') {
          --FirstNonSlash;
        }
        if ((((Result.size() - 1 - FirstNonSlash) & 1) != 0)) {
          // Diagnose errors for things like: #define F(X) #X   /   F(\)
          PP.Diag(ArgToks[ArgToksIdx-1], diag.pp_invalid_string_literal).$destroy();
          Result.pop_back(); // remove one of the \'s.
        }
      }
      Result.$addassign($('"'));

      // If this is the charify operation and the result is not a legal character
      // constant, diagnose it.
      if (Charify) {
        // First step, turn double quotes into single quotes:
        Result.$set(0, $('\''));
        Result.$set(Result.size() - 1, $('\''));

        // Check for bogus character.
        boolean isBad = false;
        if (Result.size() == 3) {
          isBad = Result.$at(1) == $('\''); // ''' is not legal. '\' already fixed above.
        } else {
          isBad = (Result.size() != 4 || Result.$at(1) != '\\'); // Not '\x'
        }
        if (isBad) {
          PP.Diag(ArgToks[ArgTokStart], diag.err_invalid_character_to_charify).$destroy();
          Result.$assign("' '"); // Use something arbitrary, but legal.
        }
      }

      PP.CreateString(Result.$array(), 0, Result.size(), _Tok, ExpansionLocStart, ExpansionLocEnd);
      return _Tok;
    } finally {
      PP.$releaseStringifyArgument_Result(Result);
    }
  }

  
  /// deallocate - This should only be called by the Preprocessor when managing
  /// its freelist.
  
  /// deallocate - This should only be called by the Preprocessor when managing
  /// its freelist.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroArgs::deallocate">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp", line = 88,
   FQN = "clang::MacroArgs::deallocate", NM = "_ZN5clang9MacroArgs10deallocateEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp -nm=_ZN5clang9MacroArgs10deallocateEv")
  //</editor-fold>
  public MacroArgs/*MacroArgs P*/ deallocate() {
    MacroArgs/*MacroArgs P*/ Next = ArgCache;
    
    // Run the dtor to deallocate the vectors.
    this.$destroy();
    // Release the memory for the object.
    free(this);
    
    return Next;
  }

  @Override
  public String toString() {
    return "MacroArgs{" + "NumUnexpArgTokens=" + NumUnexpArgTokens + ", UnexpArgTokens=" + Arrays.toString(UnexpArgTokens) + ", VarargsElided=" + VarargsElided + ", PreExpArgTokens=" + PreExpArgTokens + ", StringifiedArgs=" + StringifiedArgs + ", ArgCache=" + ArgCache + '}';
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", MacroArgs.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(MacroArgs.class.getSimpleName(), instances);
    return instances;
  }     
}
