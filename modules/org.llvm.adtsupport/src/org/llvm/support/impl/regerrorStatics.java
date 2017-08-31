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
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.impl.regstrlcpyStatics.llvm_strlcpy;
import org.llvm.support.impl.regexJava.*;
import static org.llvm.support.impl.regexJava.*;

//<editor-fold defaultstate="collapsed" desc="static type regerrorStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regerror.c -nm=_Z13llvm_regerror;_ZL5rerrs;_ZL7regatoi; -static-type=regerrorStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class regerrorStatics {


/*
- llvm_regerror - the interface to error numbers
= extern size_t llvm_regerror(int, const llvm_regex_t *, char *, size_t);
*/
/* ARGSUSED */
//<editor-fold defaultstate="collapsed" desc="llvm_regerror">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regerror.c", line = 83,
 FQN="llvm_regerror", NM="_Z13llvm_regerror",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regerror.c -nm=_Z13llvm_regerror")
//</editor-fold>
public static /*size_t*/int llvm_regerror(int errcode, /*const*/  llvm_regex /*P*/ preg, char$ptr/*char P*/ errbuf, /*size_t*/int errbuf_size) {
   rerr /*P*/ r;
  /*size_t*/int len;
  int target = errcode & ~REG_ITOA;
  /*const*/char$ptr/*char P*/ s = create_char$ptr();
  /*char*/byte convbuf[/*50*/] = new$char(50);
  if (errcode == REG_ATOI) {
    s = $tryClone(regatoi(preg, create_char$ptr(convbuf), sizeof(convbuf)));
  } else {
    int idx = 0;
    /*P*/ r = rerrs[0];
    for (; r.code != 0; idx++)  {
      r = rerrs[idx];
      if (r.code == target) {
        break;
      }
    }
    if ((errcode & REG_ITOA) != 0) {
      if (r.code != 0) {
        //(/*J:(void)*/(0));
        /*J:(void)*/llvm_strlcpy(create_char$ptr(convbuf), r.name, sizeof(convbuf));
      } else {
        /*J:(void)*/snprintf(create_char$ptr(convbuf), sizeof(convbuf), 
            $("REG_0x%x"), target);
      }
      s = $tryClone(create_char$ptr(convbuf));
    } else {
      s = $tryClone(r.explain);
    }
  }
  
  len = strlen(s) + 1;
  if ($greater_uint(errbuf_size, 0)) {
    llvm_strlcpy(errbuf, s, errbuf_size);
  }
  
  return (len);
}


/*
- regatoi - internal routine to implement REG_ATOI
*/
//<editor-fold defaultstate="collapsed" desc="regatoi">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/regerror.c", line = 122,
 FQN="regatoi", NM="_ZL7regatoi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regerror.c -nm=_ZL7regatoi")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ regatoi(/*const*/  llvm_regex /*P*/ preg, char$ptr/*char P*/ localbuf, int localbufsize) {
  int idx = 0;
  rerr /*P*/ r = rerrs[0];
  for (; r.code != 0; idx++)  {
    r = rerrs[idx];
    if (strcmp(r.name, preg.re_endp) == 0) {
      break;
    }
  }
  if (r.code == 0) {
    return ($0);
  }
  
  /*J:(void)*/snprintf(localbuf, localbufsize, $("%d"), r.code);
  return (localbuf);
}

//<editor-fold defaultstate="collapsed" desc="rerr">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regerror.c", line = 54,
 FQN="rerr", NM="_Z4rerr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regerror.c -nm=_Z4rerr")
//</editor-fold>
public static final class/*struct*/ rerr {
  public final int code;
  public final /*const*/char$ptr/*char P*/ name;
  public final /*const*/char$ptr/*char P*/ explain;

  public rerr(int code, char$ptr name, char$ptr explain) {
    this.code = code;
    this.name = name;
    this.explain = explain;
  }
  
  @Override public String toString() {
    return "" + "code=" + code // NOI18N
              + ", name=" + name // NOI18N
              + ", explain=" + explain; // NOI18N
  }
}


//<editor-fold defaultstate="collapsed" desc="rerrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regerror.c", line = 54,
 FQN="rerrs", NM="_ZL5rerrs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regerror.c -nm=_ZL5rerrs")
//</editor-fold>
public static  rerr rerrs[/*17*/] = new  rerr [/*17*/] {
  new  rerr(REG_NOMATCH, $("REG_NOMATCH"), $("llvm_regexec() failed to match")), 
  new  rerr(REG_BADPAT, $("REG_BADPAT"), $("invalid regular expression")), 
  new  rerr(REG_ECOLLATE, $("REG_ECOLLATE"), $("invalid collating element")), 
  new  rerr(REG_ECTYPE, $("REG_ECTYPE"), $("invalid character class")), 
  new  rerr(REG_EESCAPE, $("REG_EESCAPE"), $("trailing backslash (\\)")), 
  new  rerr(REG_ESUBREG, $("REG_ESUBREG"), $("invalid backreference number")), 
  new  rerr(REG_EBRACK, $("REG_EBRACK"), $("brackets ([ ]) not balanced")), 
  new  rerr(REG_EPAREN, $("REG_EPAREN"), $("parentheses not balanced")), 
  new  rerr(REG_EBRACE, $("REG_EBRACE"), $("braces not balanced")), 
  new  rerr(REG_BADBR, $("REG_BADBR"), $("invalid repetition count(s)")), 
  new  rerr(REG_ERANGE, $("REG_ERANGE"), $("invalid character range")), 
  new  rerr(REG_ESPACE, $("REG_ESPACE"), $("out of memory")), 
  new  rerr(REG_BADRPT, $("REG_BADRPT"), $("repetition-operator operand invalid")), 
  new  rerr(REG_EMPTY, $("REG_EMPTY"), $("empty (sub)expression")), 
  new  rerr(REG_ASSERT, $("REG_ASSERT"), $("\"can't happen\" -- you found a bug")), 
  new  rerr(REG_INVARG, $("REG_INVARG"), $("invalid argument to regex routine")), 
  new  rerr(0, $EMPTY, $("*** unknown regexp error code ***"))
};
} // END OF class regerrorStatics
