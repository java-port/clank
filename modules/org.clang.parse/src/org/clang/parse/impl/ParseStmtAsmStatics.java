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
package org.clang.parse.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseStmtAsmStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZL15isTypeQualifierRKN5clang5TokenE;_ZL16buildMSAsmStringRN5clang12PreprocessorENS_14SourceLocationEN4llvm8ArrayRefINS_5TokenEEERNS3_15SmallVectorImplIjEERNS3_11SmallStringILj512EEE;_ZL17isGCCAsmStatementRKN5clang5TokenE; -static-type=ParseStmtAsmStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseStmtAsmStatics {


/// Turn a sequence of our tokens back into a string that we can hand
/// to the MC asm parser.
//<editor-fold defaultstate="collapsed" desc="buildMSAsmString">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 283,
 FQN="buildMSAsmString", NM="_ZL16buildMSAsmStringRN5clang12PreprocessorENS_14SourceLocationEN4llvm8ArrayRefINS_5TokenEEERNS3_15SmallVectorImplIjEERNS3_11SmallStringILj512EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZL16buildMSAsmStringRN5clang12PreprocessorENS_14SourceLocationEN4llvm8ArrayRefINS_5TokenEEERNS3_15SmallVectorImplIjEERNS3_11SmallStringILj512EEE")
//</editor-fold>
public static boolean buildMSAsmString(Preprocessor /*&*/ PP, SourceLocation AsmLoc, 
                ArrayRefToken AsmToks, 
                SmallVectorImplUInt/*&*/ TokOffsets, 
                SmallString/*512*/ /*&*/ Asm) {
  assert (!AsmToks.empty()) : "Didn't expect an empty AsmToks!";
  
  // Is this the start of a new assembly statement?
  boolean isNewStatement = true;
  
  for (/*uint*/int i = 0, e = AsmToks.size(); $less_uint(i, e); ++i) {
    /*const*/ Token /*&*/ Tok = AsmToks.$at(i);
    
    // Start each new statement with a newline and a tab.
    if (!isNewStatement && (Tok.is(tok.TokenKind.kw_asm) || Tok.isAtStartOfLine())) {
      Asm.$addassign(/*STRINGREF_STR*/"\n\t");
      isNewStatement = true;
    }
    
    // Preserve the existence of leading whitespace except at the
    // start of a statement.
    if (!isNewStatement && Tok.hasLeadingSpace()) {
      Asm.$addassign($$SPACE);
    }
    
    // Remember the offset of this token.
    TokOffsets.push_back(Asm.size());
    
    // Don't actually write '__asm' into the assembly stream.
    if (Tok.is(tok.TokenKind.kw_asm)) {
      // Complain about __asm at the end of the stream.
      if (i + 1 == e) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/AsmLoc, diag.err_asm_empty)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      continue;
    }
    
    // Append the spelling of the token.
    SmallString/*32*/ SpellingBuffer/*J*/= new SmallString/*32*/(32);
    bool$ptr SpellingInvalid = create_bool$ptr();
    Asm.$addassign(PP.getSpelling(Tok, SpellingBuffer, $AddrOf(SpellingInvalid)));
    assert (!SpellingInvalid.$star()) : "spelling was invalid after correct parse?";
    
    // We are no longer at the start of a statement.
    isNewStatement = false;
  }
  
  // Ensure that the buffer is null-terminated.
  Asm.push_back($$TERM);
  Asm.pop_back();
  assert (TokOffsets.size() == AsmToks.size());
  return false;
}


/// isTypeQualifier - Return true if the current token could be the
/// start of a type-qualifier-list.
//<editor-fold defaultstate="collapsed" desc="isTypeQualifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 340,
 FQN="isTypeQualifier", NM="_ZL15isTypeQualifierRKN5clang5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZL15isTypeQualifierRKN5clang5TokenE")
//</editor-fold>
public static boolean isTypeQualifier(/*const*/ Token /*&*/ Tok) {
  switch (Tok.getKind()) {
   default:
    return false;
   case tok.TokenKind.kw_const:
   case tok.TokenKind.kw_volatile:
   case tok.TokenKind.kw_restrict:
   case tok.TokenKind.kw___private:
   case tok.TokenKind.kw___local:
   case tok.TokenKind.kw___global:
   case tok.TokenKind.kw___constant:
   case tok.TokenKind.kw___generic:
   case tok.TokenKind.kw___read_only:
   case tok.TokenKind.kw___read_write:
   case tok.TokenKind.kw___write_only:
    // type-qualifier
    return true;
  }
}


// Determine if this is a GCC-style asm statement.
//<editor-fold defaultstate="collapsed" desc="isGCCAsmStatement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 360,
 FQN="isGCCAsmStatement", NM="_ZL17isGCCAsmStatementRKN5clang5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZL17isGCCAsmStatementRKN5clang5TokenE")
//</editor-fold>
public static boolean isGCCAsmStatement(/*const*/ Token /*&*/ TokAfterAsm) {
  return TokAfterAsm.is(tok.TokenKind.l_paren) || TokAfterAsm.is(tok.TokenKind.kw_goto)
     || isTypeQualifier(TokAfterAsm);
}

} // END OF class ParseStmtAsmStatics
