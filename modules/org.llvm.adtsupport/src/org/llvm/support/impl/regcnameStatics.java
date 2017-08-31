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
package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;


//<editor-fold defaultstate="collapsed" desc="static type regcnameStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL6cnames; -static-type=regcnameStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class regcnameStatics {

//<editor-fold defaultstate="collapsed" desc="cname">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regcname.h", line = 42,
 FQN="cname", NM="_Z5cname",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_Z5cname")
//</editor-fold>
static final class/*struct*/ cname {
  public final /*const*/char$ptr/*char P*/ name;
  public final /*char*/byte code;
  
  public cname(char$ptr name, byte code) {
    this.name = name;
    this.code = code;
  }
  
  @Override public String toString() {
    return "" + "name=" + name // NOI18N
              + ", code=" + code; // NOI18N
  }  
}

/* character-name table */
//<editor-fold defaultstate="collapsed" desc="cnames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regcname.h", line = 42,
 FQN="cnames", NM="_ZL6cnames",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL6cnames")
//</editor-fold>
public static  cname cnames[/*96*/] = new  cname [/*96*/] {
  new  cname($("NUL"), $$TERM), 
  new  cname($("SOH"), $$SOH), 
  new  cname($("STX"), $$STX), 
  new  cname($("ETX"), $$ETX), 
  new  cname($("EOT"), $$EOT), 
  new  cname($("ENQ"), $$ENQ), 
  new  cname($("ACK"), $$ACK), 
  new  cname($("BEL"), $$BEL), 
  new  cname($("alert"), $$BEL), 
  new  cname($("BS"), $$BS), 
  new  cname($("backspace"), $$BS), 
  new  cname($("HT"), $$TAB), 
  new  cname($("tab"), $$TAB), 
  new  cname($("LF"), $$LF), 
  new  cname($("newline"), $$LF), 
  new  cname($("VT"), $$VTAB), 
  new  cname($("vertical-tab"), $$VTAB), 
  new  cname($("FF"), $$FF), 
  new  cname($("form-feed"), $$FF), 
  new  cname($("CR"), $$CR), 
  new  cname($("carriage-return"), $$CR), 
  new  cname($("SO"), $$SO), 
  new  cname($("SI"), $$SI), 
  new  cname($("DLE"), $$DLE), 
  new  cname($("DC1"), $$DC1), 
  new  cname($("DC2"), $$DC2), 
  new  cname($("DC3"), $$DC3), 
  new  cname($("DC4"), $$DC4), 
  new  cname($("NAK"), $$NAK), 
  new  cname($("SYN"), $$SYN), 
  new  cname($("ETB"), $$ETB), 
  new  cname($("CAN"), $$CAN), 
  new  cname($("EM"), $$EM), 
  new  cname($("SUB"), $$SUB), 
  new  cname($("ESC"), $$ESC), 
  new  cname($("IS4"), $$IS4), 
  new  cname($("FS"), $$IS4), 
  new  cname($("IS3"), $$IS3), 
  new  cname($("GS"), $$IS3), 
  new  cname($("IS2"), $$IS2), 
  new  cname($("RS"), $$IS2), 
  new  cname($("IS1"), $$IS1), 
  new  cname($("US"), $$IS1), 
  new  cname($("space"), $$SPACE), 
  new  cname($("exclamation-mark"), $$EXCLAMATION), 
  new  cname($("quotation-mark"), $$DBL_QUOTE), 
  new  cname($("number-sign"), $$HASH), 
  new  cname($("dollar-sign"), $$DOLLAR), 
  new  cname($("percent-sign"), $$PERCENT), 
  new  cname($("ampersand"), $$AMP), 
  new  cname($("apostrophe"), $$SGL_QUOTE), 
  new  cname($("left-parenthesis"), $$LPAREN), 
  new  cname($("right-parenthesis"), $$RPAREN), 
  new  cname($("asterisk"), $$STAR), 
  new  cname($("plus-sign"), $$PLUS), 
  new  cname($comma, $$COMMA), 
  new  cname($("hyphen"), $$MINUS), 
  new  cname($("hyphen-minus"), $$MINUS), 
  new  cname($period, $$DOT), 
  new  cname($("full-stop"), $$DOT), 
  new  cname($slash, $$SLASH), 
  new  cname($("solidus"), $$SLASH), 
  new  cname($("zero"), $$0), 
  new  cname($("one"), $$1), 
  new  cname($("two"), $$2), 
  new  cname($("three"), $$3), 
  new  cname($("four"), $$4), 
  new  cname($("five"), $$5), 
  new  cname($("six"), $$6), 
  new  cname($("seven"), $$7), 
  new  cname($("eight"), $$8), 
  new  cname($("nine"), $$9), 
  new  cname($colon, $$COLON), 
  new  cname($("semicolon"), $$SEMI), 
  new  cname($("less-than-sign"), $$LT), 
  new  cname($("equals-sign"), $$EQ), 
  new  cname($("greater-than-sign"), $$GT), 
  new  cname($("question-mark"), $$QMARK), 
  new  cname($("commercial-at"), $$AT), 
  new  cname($("left-square-bracket"), $$LSQUARE), 
  new  cname($("backslash"), $$BACK_SLASH), 
  new  cname($("reverse-solidus"), $$BACK_SLASH), 
  new  cname($("right-square-bracket"), $$RSQUARE), 
  new  cname($("circumflex"), $$CARET), 
  new  cname($("circumflex-accent"), $$CARET), 
  new  cname($("underscore"), $$UNDERSCORE), 
  new  cname($("low-line"), $$UNDERSCORE), 
  new  cname($("grave-accent"), $$BACKQUOTE), 
  new  cname($("left-brace"), $$LCURLY), 
  new  cname($("left-curly-bracket"), $$LCURLY), 
  new  cname($("vertical-line"), $$PIPE), 
  new  cname($("right-brace"), $$RCURLY), 
  new  cname($("right-curly-bracket"), $$RCURLY), 
  new  cname($tilde, $$TILDE), 
  new  cname($("DEL"), $$DEL), 
  new  cname((/*const*/char$ptr/*char P*/ )null, $$TERM)
};
} // END OF class regcnameStatics
