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

package org.clang.lex.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type TokenConcatenationStatics">
@Converted(kind = Converted.Kind.MANUAL, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZL14IsStringPrefixN4llvm9StringRefEb;_ZL12GetFirstCharRN5clang12PreprocessorERKNS_5TokenE; -static-type=TokenConcatenationStatics")
//</editor-fold>
public final class TokenConcatenationStatics {


/// IsStringPrefix - Return true if Str is a string prefix.
/// 'L', 'u', 'U', or 'u8'. Including raw versions.
//<editor-fold defaultstate="collapsed" desc="IsStringPrefix">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp", line = 23,
 FQN = "IsStringPrefix", NM = "_ZL14IsStringPrefixN4llvm9StringRefEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZL14IsStringPrefixN4llvm9StringRefEb")
//</editor-fold>
public static boolean IsStringPrefix(StringRef Str, boolean CPlusPlus11) {
  if (Str.$at(0) == $('L') || (CPlusPlus11 && (Str.$at(0) == $('u') || Str.$at(0) == $('U') || Str.$at(0) == $('R')))) {
    if (Str.size() == 1) {
      return true; // "L", "u", "U", and "R"
    }
    
    // Check for raw flavors. Need to make sure the first character wasn't
    // already R. Need CPlusPlus11 check for "LR".
    if (Str.$at(1) == $('R') && Str.$at(0) != $('R') && Str.size() == 2 && CPlusPlus11) {
      return true; // "LR", "uR", "UR"
    }
    
    // Check for "u8" and "u8R"
    if (Str.$at(0) == $('u') && Str.$at(1) == $('8')) {
      if (Str.size() == 2) {
        return true; // "u8"
      }
      if (Str.size() == 3 && Str.$at(2) == $('R')) {
        return true; // "u8R"
      }
    }
  }
  
  return false;
}


/// GetFirstChar - Get the first character of the token \arg Tok,
/// avoiding calls to getSpelling where possible.
//<editor-fold defaultstate="collapsed" desc="GetFirstChar">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp", line = 125,
 FQN = "GetFirstChar", NM = "_ZL12GetFirstCharRN5clang12PreprocessorERKNS_5TokenE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZL12GetFirstCharRN5clang12PreprocessorERKNS_5TokenE")
//</editor-fold>
public static /*char*/byte GetFirstChar(Preprocessor /*&*/ PP, /*const*/Token /*&*/ Tok) {
  {
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    if ((II != null)) {
      // Avoid spelling identifiers, the most common form of token.
      StringMapEntryBase Entry = II.getEntry();
      return Entry.getKeyArray()[Entry.getKeyArrayIndex()];
//      return II.getNameStart().$at(0);
    } else if (!Tok.needsCleaning()) {
      if (Tok.isLiteral() && (Tok.$CharPtrData() != null)) {
        return Tok.$CharPtrData()[Tok.$CharPtrDataIndex()];
      } else if (Tok.isLiteral() && (Tok.getLiteralData() != null)) {
        return Tok.getLiteralData().$star();
      } else {
        SourceManager /*&*/ SM = PP.getSourceManager();
        return SM.getCharacterData_FirstChar(SM.getSpellingLoc(Tok.$getLocation()), null);
      }
    } else if (Tok.getLength() < 256) {
//      /*char*/byte Buffer[/*256*/] = new$char(256);
//      /*const*/type$ref<char$ptr>/*char P*/ TokPtr = create_type$ref(create_char$ptr(Buffer));
//      return TokPtr.$deref().$at(0);
      return PP.getSpelling_FirstChar(Tok);
    } else {
//      return PP.getSpelling(Tok).$at(0);
      return PP.getSpelling_FirstChar(Tok);
    }
  }
}

} // END OF class TokenConcatenationStatics
