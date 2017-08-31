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
package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.rewrite.core.*;
import org.clang.lex.*;
import org.clang.lex.llvm.SmallVectorToken;
import static org.clang.rewrite.frontend.impl.RewriteMacrosStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type RewriteMacrosClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZN5clang20RewriteMacrosInInputERNS_12PreprocessorEPN4llvm11raw_ostreamE; -static-type=RewriteMacrosClangGlobals -package=org.clang.rewrite.frontend.impl")
//</editor-fold>
public final class RewriteMacrosClangGlobals {


/// RewriteMacrosInInput - Implement -rewrite-macros mode.

/// RewriteMacrosInInput - Implement -rewrite-macros mode.
//<editor-fold defaultstate="collapsed" desc="clang::RewriteMacrosInInput">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use SmallVectorToken. $add vs (Addr)$at*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp", line = 90,
 FQN="clang::RewriteMacrosInInput", NM="_ZN5clang20RewriteMacrosInInputERNS_12PreprocessorEPN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZN5clang20RewriteMacrosInInputERNS_12PreprocessorEPN4llvm11raw_ostreamE")
//</editor-fold>
public static void RewriteMacrosInInput(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS) {
  Rewriter Rewrite = null;
  SmallVectorToken RawTokens = null;
  try {
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    Rewrite/*J*/= new Rewriter();
    Rewrite.setSourceMgr(SM, PP.getLangOpts());
    RewriteBuffer /*&*/ RB = Rewrite.getEditBuffer(SM.getMainFileID());
    
    RawTokens/*J*/= new SmallVectorToken(16, /*PERF: new Token()*/(Token)null);
    LexRawTokensFromMainFile(PP, RawTokens);
    /*uint*/uint$ref CurRawTok = create_uint$ref(0);
    Token RawTok = new Token(GetNextRawTok(RawTokens, CurRawTok, false));
    
    // Get the first preprocessing token.
    PP.EnterMainSourceFile();
    Token PPTok/*J*/= new Token();
    PP.Lex(PPTok);
    
    // Preprocess the input file in parallel with raw lexing the main file. Ignore
    // all tokens that are preprocessed from a file other than the main file (e.g.
    // a header).  If we see tokens that are in the preprocessed file but not the
    // lexed file, we have a macro expansion.  If we see tokens in the lexed file
    // that aren't in the preprocessed view, we have macros that expand to no
    // tokens, or macro arguments etc.
    while (RawTok.isNot(tok.TokenKind.eof) || PPTok.isNot(tok.TokenKind.eof)) {
      SourceLocation PPLoc = SM.getExpansionLoc(PPTok.getLocation());
      
      // If PPTok is from a different source file, ignore it.
      if (!SM.isWrittenInMainFile(/*NO_COPY*/PPLoc)) {
        PP.Lex(PPTok);
        continue;
      }
      
      // If the raw file hits a preprocessor directive, they will be extra tokens
      // in the raw file that don't exist in the preprocsesed file.  However, we
      // choose to preserve them in the output file and otherwise handle them
      // specially.
      if (RawTok.is(tok.TokenKind.hash) && RawTok.isAtStartOfLine()) {
        // If this is a #warning directive or #pragma mark (GNU extensions),
        // comment the line out.
        if (RawTokens.$at(CurRawTok.$deref()).is(tok.TokenKind.identifier)) {
          /*const*/ IdentifierInfo /*P*/ II = RawTokens.$at(CurRawTok.$deref()).getIdentifierInfo();
          if ($eq_StringRef(II.getName(), /*STRINGREF_STR*/"warning")) {
            // Comment out #warning.
            RB.InsertTextAfter(SM.getFileOffset(RawTok.getLocation()), new StringRef(/*KEEP_STR*/"//"));
          } else if ($eq_StringRef(II.getName(), /*STRINGREF_STR*/"pragma")
             && RawTokens.$at(CurRawTok.$deref() + 1).is(tok.TokenKind.identifier)
             && ($eq_StringRef(RawTokens.$at(CurRawTok.$deref() + 1).getIdentifierInfo().getName(), 
              /*STRINGREF_STR*/"mark"))) {
            // Comment out #pragma mark.
            RB.InsertTextAfter(SM.getFileOffset(RawTok.getLocation()), new StringRef(/*KEEP_STR*/"//"));
          }
        }
        
        // Otherwise, if this is a #include or some other directive, just leave it
        // in the file by skipping over the line.
        RawTok.$assign(GetNextRawTok(RawTokens, CurRawTok, false));
        while (!RawTok.isAtStartOfLine() && RawTok.isNot(tok.TokenKind.eof)) {
          RawTok.$assign(GetNextRawTok(RawTokens, CurRawTok, false));
        }
        continue;
      }
      
      // Okay, both tokens are from the same file.  Get their offsets from the
      // start of the file.
      /*uint*/int PPOffs = SM.getFileOffset(/*NO_COPY*/PPLoc);
      /*uint*/int RawOffs = SM.getFileOffset(RawTok.getLocation());
      
      // If the offsets are the same and the token kind is the same, ignore them.
      if (PPOffs == RawOffs && isSameToken(RawTok, PPTok)) {
        RawTok.$assign(GetNextRawTok(RawTokens, CurRawTok, false));
        PP.Lex(PPTok);
        continue;
      }
      
      // If the PP token is farther along than the raw token, something was
      // deleted.  Comment out the raw token.
      if ($lesseq_uint(RawOffs, PPOffs)) {
        // Comment out a whole run of tokens instead of bracketing each one with
        // comments.  Add a leading space if RawTok didn't have one.
        boolean HasSpace = RawTok.hasLeadingSpace();
        RB.InsertTextAfter(RawOffs, new StringRef(/*AddrOf*/$(" /*").$add(HasSpace ? 1 : 0))); // JAVA
        /*uint*/int EndPos;
        
        do {
          EndPos = RawOffs + RawTok.getLength();
          
          RawTok.$assign(GetNextRawTok(RawTokens, CurRawTok, true));
          RawOffs = SM.getFileOffset(RawTok.getLocation());
          if (RawTok.is(tok.TokenKind.comment)) {
            // Skip past the comment.
            RawTok.$assign(GetNextRawTok(RawTokens, CurRawTok, false));
            break;
          }
        } while ($lesseq_uint(RawOffs, PPOffs) && !RawTok.isAtStartOfLine()
           && (PPOffs != RawOffs || !isSameToken(RawTok, PPTok)));
        
        RB.InsertTextBefore(EndPos, new StringRef(/*KEEP_STR*/$STAR_SLASH));
        continue;
      }
      
      // Otherwise, there was a replacement an expansion.  Insert the new token
      // in the output buffer.  Insert the whole run of new tokens at once to get
      // them in the right order.
      /*uint*/int InsertPos = PPOffs;
      std.string Expansion/*J*/= new std.string();
      while ($less_uint(PPOffs, RawOffs)) {
        Expansion.$addassign($add_T_string($$SPACE, PP.getSpelling(PPTok)));
        PP.Lex(PPTok);
        PPLoc.$assignMove(SM.getExpansionLoc(PPTok.getLocation()));
        PPOffs = SM.getFileOffset(/*NO_COPY*/PPLoc);
      }
      Expansion.$addassign_T($$SPACE);
      RB.InsertTextBefore(InsertPos, new StringRef(Expansion));
    }
    {
      
      // Get the buffer corresponding to MainFileID.  If we haven't changed it, then
      // we are done.
      /*const*/ RewriteBuffer /*P*/ RewriteBuf = Rewrite.getRewriteBufferFor(SM.getMainFileID());
      if ((RewriteBuf != null)) {
        //printf("Changed:\n");
        /*Deref*/OS.$out(new std.string(RewriteBuf.begin(), RewriteBuf.end()));
      } else {
        fprintf(stderr, /*KEEP_STR*/"No changes\n");
      }
    }
    OS.flush();
  } finally {
    if (RawTokens != null) { RawTokens.$destroy(); }
    if (Rewrite != null) { Rewrite.$destroy(); }
  }
}

} // END OF class RewriteMacrosClangGlobals
