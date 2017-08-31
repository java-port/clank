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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.impl.regexJava.*;
import static org.llvm.support.impl.regexJava.*;
import static org.llvm.support.impl.regfreeStatics.*;

//<editor-fold defaultstate="collapsed" desc="static type regcompStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_Z12llvm_regcomp;_ZL10categorize;_ZL10nonnewline;_ZL10p_b_cclass;_ZL10p_b_eclass;_ZL10p_b_symbol;_ZL13p_b_coll_elem;_ZL3nch;_ZL4dupl;_ZL5dofwd;_ZL5mcadd;_ZL5p_bre;_ZL5p_ere;_ZL5p_str;_ZL6doemit;_ZL6mccase;_ZL6repeat;_ZL6seterr;_ZL7enlarge;_ZL7firstch;_ZL7freeset;_ZL7p_count;_ZL8allocset;_ZL8doinsert;_ZL8findmust;_ZL8isinsets;_ZL8mcinvert;_ZL8ordinary;_ZL8p_b_term;_ZL8samesets;_ZL9bothcases;_ZL9freezeset;_ZL9othercase;_ZL9p_bracket;_ZL9p_ere_exp;_ZL9p_simp_re;_ZL9pluscount;_ZL9stripsnug; -static-type=regcompStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class regcompStatics {


/*
- llvm_regcomp - interface for parser and compilation
*/
//<editor-fold defaultstate="collapsed" desc="llvm_regcomp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 164,
 FQN="llvm_regcomp", NM="_Z12llvm_regcomp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_Z12llvm_regcomp")
//</editor-fold>
public static int llvm_regcomp( llvm_regex /*P*/ preg, /*const*/char$ptr/*char P*/ pattern, int cflags) {
  if (true) {
    NativeTrace.traceNotImplemented("llvm_regcomp");
    return 0;
  }
   parse pa = new parse();
   re_guts /*P*/ g;
   parse /*P*/ p = $AddrOf(pa);
  int i;
  /*size_t*/int len;
  
  cflags = ((cflags) & ~REG_DUMP);
  if (Native.$bool((cflags & REG_EXTENDED)) && Native.$bool((cflags & REG_NOSPEC))) {
    return (REG_INVARG);
  }
  if ((cflags & REG_PEND) != 0) {
    if (preg.re_endp.$less(pattern)) {
      return (REG_INVARG);
    }
    len = preg.re_endp.$sub(pattern);
  } else {
    len = strlen(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, pattern));
  }
  
  /* do the mallocs early so failure handling is easy */
  // JAVA: just create object
//  g = ( re_guts /*P*/ )malloc($sizeof_Re_guts()
//         + (NC - 1) * $sizeof_UChar());
  g = new re_guts();
  if (g == ((Object/*void P*/ )NULL)) {
    return (REG_ESPACE);
  }
  p.ssize = $div_uint(len, (/*size_t*/int)2) * (/*size_t*/int)3 + (/*size_t*/int)1; /* ugh */
  // JAVA: just create array
//  p.strip = $tryClone(reinterpret_cast(/*ulong*/long/*P*/ .class, calloc(p.ssize, $sizeof_ULong())));
  p.strip = create_ulong$ptr(new$ulong($long2uint(p.ssize)));
  p.slen = 0;
  if ($eq_ptr(p.strip, ((Object/*void P*/ )NULL))) {
    //free((char$ptr/*char P*/ )g);
    return (REG_ESPACE);
  }
  
  /* set things up */
  p.g = g;
  p.next = $tryConstClone(reinterpret_cast(char$ptr/*char P*/ .class, pattern)); /* convenience; we do not modify it */
  p.end = $tryConstClone(p.next.$add(len));
  p.error = 0;
  p.ncsalloc = 0;
  for (i = 0; i < NPAREN; i++) {
    p.pbegin[i] = 0;
    p.pend[i] = 0;
  }
  g.csetsize = NC;
  g.sets = null;
  g.setbits = null;
  g.ncsets = 0;
  g.cflags = cflags;
  g.iflags = 0;
  g.nbol = 0;
  g.neol = 0;
  g.must = null;
  g.mlen = 0;
  g.nsub = 0;
  g.ncategories = 1; /* category 0 is "everything else" */
  g.categories = create_char$ptr($AddrOf(g.catspace), -(CHAR_MIN));
  /*J:(void)*/memset(g.catspace, $$TERM, NC/* * $sizeof_UChar()*/);
  g.backrefs = 0;
  
  /* do it */
  doemit(p, OEND, (/*size_t*/int)(0));
  g.firststate = (p.slen - 1);
  if ((cflags & REG_EXTENDED) != 0) {
    p_ere(p, OUT);
  } else if ((cflags & REG_NOSPEC) != 0) {
    p_str(p);
  } else {
    p_bre(p, OUT, OUT);
  }
  doemit(p, OEND, (/*size_t*/int)(0));
  g.laststate = (p.slen - 1);
  
  /* tidy up loose ends and fill things in */
  categorize(p, g);
  stripsnug(p, g);
  findmust(p, g);
  g.nplus = pluscount(p, g);
  g.magic = MAGIC2;
  preg.re_nsub = g.nsub;
  preg.re_g = g;
  preg.re_magic = MAGIC1;
  /* not debugging, so can't rely on the assert() in llvm_regexec() */
  if ((g.iflags & REGEX_BAD) != 0) {
    seterr(p, (REG_ASSERT));
  }
  
  /* win or lose, we're done */
  if (p.error != 0) { /* lose */
    llvm_regfree(preg);
  }
  return (p.error);
}


/*
- p_ere - ERE parser top level, concatenation and alternation
*/
//<editor-fold defaultstate="collapsed" desc="p_ere">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 264,
 FQN="p_ere", NM="_ZL5p_ere",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL5p_ere")
//</editor-fold>
public static void p_ere( parse /*P*/ p, int stop) {
  NativeTrace.traceNotImplemented("p_ere");
//  /*char*/byte c;
//  long prevback = 0;
//  long prevfwd = 0;
//  long conc;
//  int first = 1; /* is this the first alternative? */
//  
//  for (;;) {
//    /* do a bunch of concatenated expressions */
//    conc = (p.slen);
//    while (Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((c = (p.next.$star())) != $$PIPE)) && Native.$bool(c != stop)) {
//      p_ere_exp(p);
//    }
//    /*J:(void)*/(Native.$bool(((p.slen) != conc)) || Native.$bool(seterr(p, (14)))); /* require nonempty */
//    if (!(((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$PIPE)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//      break; /* NOTE BREAK OUT */
//    }
//    if (first) {
//      doinsert(p, (/*ulong*/long)((15L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (conc) + 1, conc); /* offset is wrong */
//      prevfwd = conc;
//      prevback = conc;
//      first = 0;
//    }
//    doemit(p, (/*ulong*/long)((16L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - prevback));
//    prevback = (p.slen - 1);
//    dofwd(p, prevfwd, (p.slen) - (prevfwd)); /* fix previous offset */
//    prevfwd = (p.slen);
//    doemit(p, (/*ulong*/long)((17L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0)); /* offset is very wrong */
//  }
//  if (!first) { /* tail-end fixups */
//    dofwd(p, prevfwd, (p.slen) - (prevfwd));
//    doemit(p, (/*ulong*/long)((18L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - prevback));
//  }
//  //(/*J:(void)*/(0));
}


/*
- p_ere_exp - parse one subERE, an atom possibly followed by a repetition op
*/
//<editor-fold defaultstate="collapsed" desc="p_ere_exp">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 307,
 FQN="p_ere_exp", NM="_ZL9p_ere_exp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9p_ere_exp")
//</editor-fold>
public static void p_ere_exp( parse /*P*/ p) {
  NativeTrace.traceNotImplemented("p_ere_exp");
//  /*char*/byte c;
//  long pos;
//  int count;
//  int count2;
//  int backrefnum;
//  long subno;
//  int wascaret = 0;
//  //(/*J:(void)*/(0)); /* caller should have ensured this */
//  c = (p.next.$postInc().$star());
//  
//  pos = (p.slen);
//  switch (c) {
//   case '(':
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (8))));
//    p.g.nsub++;
//    subno = p.g.nsub;
//    if (subno < NPAREN) {
//      p.pbegin[(int)subno] = (p.slen);
//    }
//    doemit(p, (/*ulong*/long)((13L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(subno));
//    if (!(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$RPAREN)))) {
//      p_ere(p, $$RPAREN);
//    }
//    if (subno < NPAREN) {
//      p.pend[(int)subno] = (p.slen);
//      //(/*J:(void)*/(0));
//    }
//    doemit(p, (/*ulong*/long)((14L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(subno));
//    //(/*J:(void)*/(Native.$bool((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$postInc().$star()) == ($$RPAREN)))) || Native.$bool(seterr(p, (8)))));
//    break;
//   case ')': /* happens only if no current unmatched ( */
//    /*
//    * You may ask, why the ifndef?  Because I didn't notice
//    * this until slightly too late for 1003.2, and none of the
//    * other 1003.2 regular-expression reviewers noticed it at
//    * all.  So an unmatched ) is legal POSIX, at least until
//    * we can get it fixed.
//    */
//    seterr(p, (8));
//    break;
//   case '^':
//    doemit(p, (/*ulong*/long)((3L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    p.g.iflags |= USEBOL;
//    p.g.nbol++;
//    wascaret = 1;
//    break;
//   case '$':
//    doemit(p, (/*ulong*/long)((4L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    p.g.iflags |= USEEOL;
//    p.g.neol++;
//    break;
//   case '|':
//    seterr(p, (14));
//    break;
//   case '*':
//   case '+':
//   case '?':
//    seterr(p, (13));
//    break;
//   case '.':
//    if (p.g.cflags & REG_NEWLINE) {
//      nonnewline(p);
//    } else {
//      doemit(p, (/*ulong*/long)((5L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    }
//    break;
//   case '[':
//    p_bracket(p);
//    break;
//   case '\\':
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (5))));
//    c = (p.next.$postInc().$star());
//    if (Native.$bool(c >= $$1) && Native.$bool(c <= $$9)) {
//      /* \[0-9] is taken to be a back-reference to a previously specified
//      * matching group. backrefnum will hold the number. The matching
//      * group must exist (i.e. if \4 is found there must have been at
//      * least 4 matching groups specified in the pattern previously).
//      */
//      backrefnum = c - $$0;
//      if (p.pend[backrefnum] == 0) {
//        seterr(p, (6));
//        break;
//      }
//      
//      /* Make sure everything checks out and emit the sequence
//      * that marks a back-reference to the parse structure.
//      */
//      //(/*J:(void)*/(0));
//      doemit(p, (/*ulong*/long)((7L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(backrefnum));
//      //(/*J:(void)*/(0));
//      //(/*J:(void)*/(0));
//      //(/*J:(void)*/(0));
//      /*J:(void)*/dupl(p, p.pbegin[backrefnum] + 1, p.pend[backrefnum]);
//      doemit(p, (/*ulong*/long)((8L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(backrefnum));
//      p.g.backrefs = 1;
//    } else {
//      /* Other chars are simply themselves when escaped with a backslash.
//      */
//      ordinary(p, c);
//    }
//    break;
//   case '{': /* okay as ordinary except if digit follows */
//    /*J:(void)*/(Native.$bool((!(p.next.$less(p.end)) || !($ushort2int((__ctype_b_loc().$star()).$at((int)(((/*uchar*/byte)(p.next.$star()))))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISdigit)))) || Native.$bool(seterr(p, (13))));
//   default:
//    /* FALLTHROUGH */
//    ordinary(p, c);
//    break;
//  }
//  if (!(p.next.$less(p.end))) {
//    return;
//  }
//  c = (p.next.$star());
//  /* we call { a repetition if followed by a digit */
//  if (!(Native.$bool(Native.$bool(Native.$bool(c == $$STAR) || Native.$bool(c == $$PLUS)) || Native.$bool(c == $$QMARK))
//     || Native.$bool((Native.$bool(Native.$bool(c == $$LCURLY) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((/*uchar*/byte)((p.next.$add(1)).$star()))))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISdigit))))))) {
//    return; /* no repetition, we're done */
//  }
//  (p.next.$postInc());
//  /*J:(void)*/(Native.$bool((!wascaret)) || Native.$bool(seterr(p, (13))));
//  switch (c) {
//   case '*': /* implemented as +? */
//    /* this case does not require the (y|) trick, noKLUDGE */
//    doinsert(p, (/*ulong*/long)((9L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (pos) + 1, pos);
//    doemit(p, (/*ulong*/long)((10L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - pos));
//    doinsert(p, (/*ulong*/long)((11L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (pos) + 1, pos);
//    doemit(p, (/*ulong*/long)((12L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - pos));
//    break;
//   case '+':
//    doinsert(p, (/*ulong*/long)((9L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (pos) + 1, pos);
//    doemit(p, (/*ulong*/long)((10L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - pos));
//    break;
//   case '?':
//    /* KLUDGE: emit y? as (y|) until subtle bug gets fixed */
//    doinsert(p, (/*ulong*/long)((15L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (pos) + 1, pos); /* offset slightly wrong */
//    doemit(p, (/*ulong*/long)((16L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - pos)); /* this one's right */
//    dofwd(p, pos, (p.slen) - (pos)); /* fix the OCH_ */
//    doemit(p, (/*ulong*/long)((17L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0)); /* offset very wrong... */
//    dofwd(p, (p.slen - 1), (p.slen) - ((p.slen - 1))); /* ...so fix it */
//    doemit(p, (/*ulong*/long)((18L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - (p.slen - 2)));
//    break;
//   case '{':
//    count = p_count(p);
//    if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$COMMA)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//      if (($ushort2int((__ctype_b_loc().$star()).$at((int)(((/*uchar*/byte)(p.next.$star()))))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISdigit))) {
//        count2 = p_count(p);
//        /*J:(void)*/(Native.$bool((count <= count2)) || Native.$bool(seterr(p, (10))));
//      } else { /* single number with comma */
//        count2 = INFINITY;
//      }
//    } else { /* just a single number */
//      count2 = count;
//    }
//    repeat(p, pos, count, count2);
//    if (!(((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$RCURLY)))) ? ((p.next.$postInc());/*,*/1) : 0)) { /* error heuristics */
//      while (Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) != $$RCURLY)) {
//        (p.next.$postInc());
//      }
//      /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (9))));
//      seterr(p, (10));
//    }
//    break;
//  }
//  if (!(p.next.$less(p.end))) {
//    return;
//  }
//  c = (p.next.$star());
//  if (!(Native.$bool(Native.$bool(Native.$bool(c == $$STAR) || Native.$bool(c == $$PLUS)) || Native.$bool(c == $$QMARK))
//     || Native.$bool((Native.$bool(Native.$bool(c == $$LCURLY) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((/*uchar*/byte)((p.next.$add(1)).$star()))))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISdigit))))))) {
//    return;
//  }
//  seterr(p, (13));
}


/*
- p_str - string (no metacharacters) "parser"
*/
//<editor-fold defaultstate="collapsed" desc="p_str">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 482,
 FQN="p_str", NM="_ZL5p_str",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL5p_str")
//</editor-fold>
public static void p_str( parse /*P*/ p) {
  /*J:(void)*/if(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (REG_EMPTY))));
  while ((p.next.$less(p.end))) {
    ordinary(p, (p.next.$postInc().$star()));
  }
}


/*
- p_bre - BRE parser top level, anchoring and concatenation
* Giving end1 as OUT essentially eliminates the end1/end2 check.
*
* This implementation is a bit of a kludge, in that a trailing $ is first
* taken as an ordinary character and then revised to be an anchor.  The
* only undesirable side effect is that '$' gets included as a character
* category in such cases.  This is fairly harmless; not worth fixing.
* The amount of lookahead needed to avoid this kludge is excessive.
*/
//<editor-fold defaultstate="collapsed" desc="p_bre">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 500,
 FQN="p_bre", NM="_ZL5p_bre",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL5p_bre")
//</editor-fold>
public static void p_bre( parse /*P*/ p, 
     int end1,  /* first terminating character */
     int end2) {
  NativeTrace.traceNotImplemented("p_bre");
//  long start = (p.slen);
//  int first = 1; /* first subexpression? */
//  int wasdollar = 0;
//  if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$CARET)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//    doemit(p, (/*ulong*/long)((3L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    p.g.iflags |= USEBOL;
//    p.g.nbol++;
//  }
//  while (Native.$bool((p.next.$less(p.end))) && !(Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == (end1))) && Native.$bool(((p.next.$add(1)).$star()) == (end2)))) {
//    wasdollar = p_simp_re(p, first);
//    first = 0;
//  }
//  if (wasdollar) { /* oops, that was a trailing anchor */
//    (p.slen -= (1));
//    doemit(p, (/*ulong*/long)((4L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    p.g.iflags |= USEEOL;
//    p.g.neol++;
//  }
//  /*J:(void)*/(Native.$bool(((p.slen) != start)) || Native.$bool(seterr(p, (14)))); /* require nonempty */
}


/*
- p_simp_re - parse a simple RE, an atom possibly followed by a repetition
*/
//<editor-fold defaultstate="collapsed" desc="p_simp_re">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 531,
 FQN="p_simp_re", NM="_ZL9p_simp_re",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9p_simp_re")
//</editor-fold>
public static int p_simp_re( parse /*P*/ p, 
         int starordinary) {
  NativeTrace.traceNotImplemented("p_simp_re");
  return 0;
//  int c;
//  int count;
//  int count2;
//  long pos;
//  int i;
//  long subno;
//  
//  pos = (p.slen); /* repetition op, if any, covers from here */
//  //(/*J:(void)*/(0)); /* caller should have ensured this */
//  c = (p.next.$postInc().$star());
//  if (c == $$BACK_SLASH) {
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (5))));
//    c = BACKSL | (p.next.$postInc().$star());
//  }
//  switch (c) {
//   case '.':
//    if (p.g.cflags & REG_NEWLINE) {
//      nonnewline(p);
//    } else {
//      doemit(p, (/*ulong*/long)((5L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    }
//    break;
//   case '[':
//    p_bracket(p);
//    break;
//   case 1 << 8 | '{':
//    seterr(p, (13));
//    break;
//   case 1 << 8 | '(':
//    p.g.nsub++;
//    subno = p.g.nsub;
//    if (subno < NPAREN) {
//      p.pbegin[(int)subno] = (p.slen);
//    }
//    doemit(p, (/*ulong*/long)((13L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(subno));
//    /* the MORE here is an error heuristic */
//    if (Native.$bool((p.next.$less(p.end))) && !(Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$BACK_SLASH))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RPAREN)))) {
//      p_bre(p, $$BACK_SLASH, $$RPAREN);
//    }
//    if (subno < NPAREN) {
//      p.pend[(int)subno] = (p.slen);
//      //(/*J:(void)*/(0));
//    }
//    doemit(p, (/*ulong*/long)((14L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(subno));
//    /*J:(void)*/(Native.$bool(((((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$BACK_SLASH))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RPAREN)))) ? ((p.next.$inc(2));/*,*/1) : 0))) || Native.$bool(seterr(p, (8))));
//    break;
//   case 1 << 8 | ')': /* should not get here -- must be user */
//   case 1 << 8 | '}':
//    seterr(p, (8));
//    break;
//   case 1 << 8 | '1':
//   case 1 << 8 | '2':
//   case 1 << 8 | '3':
//   case 1 << 8 | '4':
//   case 1 << 8 | '5':
//   case 1 << 8 | '6':
//   case 1 << 8 | '7':
//   case 1 << 8 | '8':
//   case 1 << 8 | '9':
//    i = (c & ~BACKSL) - $$0;
//    //(/*J:(void)*/(0));
//    if (p.pend[i] != 0) {
//      //(/*J:(void)*/(0));
//      doemit(p, (/*ulong*/long)((7L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(i));
//      //(/*J:(void)*/(0));
//      //(/*J:(void)*/(0));
//      //(/*J:(void)*/(0));
//      /*J:(void)*/dupl(p, p.pbegin[i] + 1, p.pend[i]);
//      doemit(p, (/*ulong*/long)((8L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(i));
//    } else {
//      seterr(p, (6));
//    }
//    p.g.backrefs = 1;
//    break;
//   case '*':
//    /*J:(void)*/(Native.$bool((starordinary)) || Native.$bool(seterr(p, (13))));
//   default:
//    /* FALLTHROUGH */
//    ordinary(p, (/*char*/byte)c);
//    break;
//  }
//  if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$STAR)))) ? ((p.next.$postInc());/*,*/1) : 0)) { /* implemented as +? */
//    /* this case does not require the (y|) trick, noKLUDGE */
//    doinsert(p, (/*ulong*/long)((9L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (pos) + 1, pos);
//    doemit(p, (/*ulong*/long)((10L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - pos));
//    doinsert(p, (/*ulong*/long)((11L/*UL*/ << ((/*uint*/int)27))), (p.slen) - (pos) + 1, pos);
//    doemit(p, (/*ulong*/long)((12L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - pos));
//  } else if ((((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$BACK_SLASH))) && Native.$bool(((p.next.$add(1)).$star()) == ($$LCURLY)))) ? ((p.next.$inc(2));/*,*/1) : 0)) {
//    count = p_count(p);
//    if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$COMMA)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//      if (Native.$bool((p.next.$less(p.end))) && Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((/*uchar*/byte)(p.next.$star()))))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISdigit)))) {
//        count2 = p_count(p);
//        /*J:(void)*/(Native.$bool((count <= count2)) || Native.$bool(seterr(p, (10))));
//      } else { /* single number with comma */
//        count2 = INFINITY;
//      }
//    } else { /* just a single number */
//      count2 = count;
//    }
//    repeat(p, pos, count, count2);
//    if (!(((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$BACK_SLASH))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RCURLY)))) ? ((p.next.$inc(2));/*,*/1) : 0)) { /* error heuristics */
//      while (Native.$bool((p.next.$less(p.end))) && !(Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$BACK_SLASH))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RCURLY)))) {
//        (p.next.$postInc());
//      }
//      /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (9))));
//      seterr(p, (10));
//    }
//  } else if (c == $$DOLLAR) { /* $ (but not \$) ends it */
//    return (1);
//  }
//  
//  return (0);
}


/*
- p_count - parse a repetition count
*/
//<editor-fold defaultstate="collapsed" desc="p_count">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 647,
 FQN="p_count", NM="_ZL7p_count",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL7p_count")
//</editor-fold>
public static int p_count( parse /*P*/ p) {
  int count = 0;
  int ndigits = 0;
  while ((p.next.$less(p.end)) && Native.$bool(isdigit(p.next.$star())) && (count <= DUPMAX)) {
    count = count * 10 + ((p.next.$postInc().$star()) - $$0);
    ndigits++;
  }
  /*J:(void)*/if(Native.$bool((Native.$bool(ndigits > 0) && Native.$bool(count <= DUPMAX))) || Native.$bool(seterr(p, (REG_BADBR))));
  return (count);
}


/*
- p_bracket - parse a bracketed character list
*
* Note a significant property of this code:  if the allocset() did SETERROR,
* no set operations are done.
*/
//<editor-fold defaultstate="collapsed" desc="p_bracket">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 668,
 FQN="p_bracket", NM="_ZL9p_bracket",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9p_bracket")
//</editor-fold>
public static void p_bracket( parse /*P*/ p) {
  NativeTrace.traceNotImplemented("p_bracket");
//   cset /*P*/ cs;
//  int invert = 0;
//  
//  /* Dept of Truly Sickening Special-Case Kludges */
//  if (Native.$bool(p.next.$add(5).$less(p.end)) && Native.$bool(strncmp(p.next, $("[:<:]]"), 6) == 0)) {
//    doemit(p, (/*ulong*/long)((19L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    (p.next.$inc((6)));
//    return;
//  }
//  if (Native.$bool(p.next.$add(5).$less(p.end)) && Native.$bool(strncmp(p.next, $("[:>:]]"), 6) == 0)) {
//    doemit(p, (/*ulong*/long)((20L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
//    (p.next.$inc((6)));
//    return;
//  }
//  if ((cs = allocset(p)) == ((Object/*void P*/ )NULL)) {
//    /* allocset did set error status in p */
//    return;
//  }
//  if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$CARET)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//    invert++; /* make note to invert set at end */
//  }
//  if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$RSQUARE)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//    ((cs).ptr.$set$orassign((/*uchar*/byte)($$RSQUARE), $uchar2int((cs).mask));/*,*/(cs).hash += ($$RSQUARE));
//  } else if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$MINUS)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//    ((cs).ptr.$set$orassign((/*uchar*/byte)($$MINUS), $uchar2int((cs).mask));/*,*/(cs).hash += ($$MINUS));
//  }
//  while (Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) != $$RSQUARE)) && !(Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$MINUS))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RSQUARE)))) {
//    p_b_term(p, cs);
//  }
//  if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$MINUS)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//    ((cs).ptr.$set$orassign((/*uchar*/byte)($$MINUS), $uchar2int((cs).mask));/*,*/(cs).hash += ($$MINUS));
//  }
//  //(/*J:(void)*/(Native.$bool((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$postInc().$star()) == ($$RSQUARE)))) || Native.$bool(seterr(p, (7)))));
//  if (p.error != 0) { /* don't mess things up further */
//    freeset(p, cs);
//    return;
//  }
//  if (p.g.cflags & REG_ICASE) {
//    int i;
//    int ci;
//    
//    for (i = p.g.csetsize - 1; i >= 0; i--)  {
//      if (Native.$bool(($uchar2int((cs).ptr.$at((/*uchar*/byte)(i))) & $uchar2int((cs).mask))) && Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((i)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalpha)))) {
//        ci = othercase(i);
//        if (ci != i) {
//          ((cs).ptr.$set$orassign((/*uchar*/byte)(ci), $uchar2int((cs).mask));/*,*/(cs).hash += (ci));
//        }
//      }
//    }
//    if ($noteq_ptr(cs.multis, ((Object/*void P*/ )NULL))) {
//      mccase(p, cs);
//    }
//  }
//  if (invert) {
//    int i;
//    
//    for (i = p.g.csetsize - 1; i >= 0; i--)  {
//      if (($uchar2int((cs).ptr.$at((/*uchar*/byte)(i))) & $uchar2int((cs).mask))) {
//        ((cs).ptr.$set$andassign((/*uchar*/byte)(i), ~$uchar2int((cs).mask));/*,*/(cs).hash -= (i));
//      } else {
//        ((cs).ptr.$set$orassign((/*uchar*/byte)(i), $uchar2int((cs).mask));/*,*/(cs).hash += (i));
//      }
//    }
//    if (p.g.cflags & REG_NEWLINE) {
//      ((cs).ptr.$set$andassign((/*uchar*/byte)($$LF), ~$uchar2int((cs).mask));/*,*/(cs).hash -= ($$LF));
//    }
//    if ($noteq_ptr(cs.multis, ((Object/*void P*/ )NULL))) {
//      mcinvert(p, cs);
//    }
//  }
//  //(/*J:(void)*/(0)); /* xxx */
//  if (nch(p, cs) == 1) { /* optimize singleton sets */
//    ordinary(p, firstch(p, cs));
//    freeset(p, cs);
//  } else {
//    doemit(p, (/*ulong*/long)((6L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(freezeset(p, cs)));
//  }
}


/*
- p_b_term - parse one term of a bracketed character list
*/
//<editor-fold defaultstate="collapsed" desc="p_b_term">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 747,
 FQN="p_b_term", NM="_ZL8p_b_term",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8p_b_term")
//</editor-fold>
public static void p_b_term( parse /*P*/ p,  cset /*P*/ cs) {
  NativeTrace.traceNotImplemented("p_b_term");
//  /*char*/byte c;
//  /*char*/byte start;
//  /*char*/byte finish;
//  int i;
//  
//  /* classify what we've got */
//  switch (((p.next.$less(p.end))) ? (p.next.$star()) : $$TERM) {
//   case '[':
//    c = ((p.next.$add(1).$less(p.end))) ? ((p.next.$add(1)).$star()) : $$TERM;
//    break;
//   case '-':
//    seterr(p, (11));
//    return; /* NOTE RETURN */
//    break;
//   default:
//    c = $$TERM;
//    break;
//  }
//  switch (c) {
//   case ':': /* character class */
//    (p.next.$inc(2));
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (7))));
//    c = (p.next.$star());
//    /*J:(void)*/(Native.$bool((Native.$bool(c != $$MINUS) && Native.$bool(c != $$RSQUARE))) || Native.$bool(seterr(p, (4))));
//    p_b_cclass(p, cs);
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (7))));
//    /*J:(void)*/(Native.$bool(((((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$COLON))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RSQUARE)))) ? ((p.next.$inc(2));/*,*/1) : 0))) || Native.$bool(seterr(p, (4))));
//    break;
//   case '=': /* equivalence class */
//    (p.next.$inc(2));
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (7))));
//    c = (p.next.$star());
//    /*J:(void)*/(Native.$bool((Native.$bool(c != $$MINUS) && Native.$bool(c != $$RSQUARE))) || Native.$bool(seterr(p, (3))));
//    p_b_eclass(p, cs);
//    /*J:(void)*/(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (7))));
//    /*J:(void)*/(Native.$bool(((((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$EQ))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RSQUARE)))) ? ((p.next.$inc(2));/*,*/1) : 0))) || Native.$bool(seterr(p, (3))));
//    break;
//   default: /* symbol, ordinary character, or range */
//    /* xxx revision needed for multichar stuff */
//    start = p_b_symbol(p);
//    if (Native.$bool(Native.$bool((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$MINUS)))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool(((p.next.$add(1)).$star()) != $$RSQUARE)) {
//      /* range */
//      (p.next.$postInc());
//      if ((((Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$star()) == ($$MINUS)))) ? ((p.next.$postInc());/*,*/1) : 0)) {
//        finish = $$MINUS;
//      } else {
//        finish = p_b_symbol(p);
//      }
//    } else {
//      finish = start;
//    }
//    /* xxx what about signed chars here... */
//    /*J:(void)*/(Native.$bool((start <= finish)) || Native.$bool(seterr(p, (11))));
//    for (i = start; i <= finish; i++)  {
//      ((cs).ptr.$set$orassign((/*uchar*/byte)(i), $uchar2int((cs).mask));/*,*/(cs).hash += (i));
//    }
//    break;
//  }
}


/*
- p_b_cclass - parse a character-class name and deal with it
*/
//<editor-fold defaultstate="collapsed" desc="p_b_cclass">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 810,
 FQN="p_b_cclass", NM="_ZL10p_b_cclass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL10p_b_cclass")
//</editor-fold>
public static void p_b_cclass( parse /*P*/ p,  cset /*P*/ cs) {
  NativeTrace.traceNotImplemented("p_b_cclass");
//  char$ptr/*char P*/ sp = $tryClone(p.next);
//   cclass /*P*/ cp;
//  /*size_t*/int len;
//  /*const*/char$ptr/*char P*/ u = create_char$ptr();
//  /*char*/byte c;
//  while (Native.$bool((p.next.$less(p.end))) && Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((/*uchar*/byte)(p.next.$star()))))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalpha)))) {
//    (p.next.$postInc());
//  }
//  len = p.next.$sub(sp);
//  for (cp = cclasses; $noteq_ptr(cp.name, ((Object/*void P*/ )NULL)); cp++)  {
//    if (Native.$bool(strncmp(cp.name, sp, len) == 0) && Native.$bool(cp.name.$at(len) == $$TERM)) {
//      break;
//    }
//  }
//  if ($eq_ptr(cp.name, ((Object/*void P*/ )NULL))) {
//    /* oops, didn't find it */
//    seterr(p, (4));
//    return;
//  }
//  
//  u = $tryClone(cp.chars);
//  while ((c = u.$postInc().$star()) != $$TERM) {
//    ((cs).ptr.$set$orassign((/*uchar*/byte)(c), $uchar2int((cs).mask));/*,*/(cs).hash += (c));
//  }
//  for (u = $tryClone(cp.multis); u.$star() != $$TERM; u.$inc(strlen(u) + 1))  {
//    mcadd(p, cs, u);
//  }
}


/*
- p_b_eclass - parse an equivalence-class name and deal with it
*
* This implementation is incomplete. xxx
*/
//<editor-fold defaultstate="collapsed" desc="p_b_eclass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 843,
 FQN="p_b_eclass", NM="_ZL10p_b_eclass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL10p_b_eclass")
//</editor-fold>
public static void p_b_eclass( parse /*P*/ p,  cset /*P*/ cs) {
  /*char*/byte c;
  
  c = p_b_coll_elem(p, $$EQ);
  CHadd(cs, c);
}


/*
- p_b_symbol - parse a character or [..]ed multicharacter collating symbol
*/
//<editor-fold defaultstate="collapsed" desc="p_b_symbol">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 855,
 FQN="p_b_symbol", NM="_ZL10p_b_symbol",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL10p_b_symbol")
//</editor-fold>
public static /*char*/byte p_b_symbol( parse /*P*/ p) {
  NativeTrace.traceNotImplemented("p_b_symbol");
  return 0;
//  /*char*/byte value;
//  /*J:(void)*/if(Native.$bool(((p.next.$less(p.end)))) || Native.$bool(seterr(p, (REG_EBRACK))));
//  if (!(((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$LSQUARE))) && Native.$bool(((p.next.$add(1)).$star()) == ($$DOT)))) ? ((p.next.$inc(2));/*,*/1) : 0)) {
//    return ((p.next.$postInc().$star()));
//  }
//  
//  /* collating symbol */
//  value = p_b_coll_elem(p, $$DOT);
//  /*J:(void)*/if(Native.$bool(((((Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == ($$DOT))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RSQUARE)))) ? ((p.next.$inc(2));/*,*/1) : 0))) || Native.$bool(seterr(p, (REG_ECOLLATE))));
//  return (value);
}


/*
- p_b_coll_elem - parse a collating-element name and look it up
*/
//<editor-fold defaultstate="collapsed" desc="p_b_coll_elem">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 873,
 FQN="p_b_coll_elem", NM="_ZL13p_b_coll_elem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL13p_b_coll_elem")
//</editor-fold>
public static /*char*/byte p_b_coll_elem( parse /*P*/ p, 
             int endc) {
  NativeTrace.traceNotImplemented("p_b_coll_elem");
  return 0;
//  char$ptr/*char P*/ sp = $tryClone(p.next);
//   cname /*P*/ cp;
//  int len;
//  while (Native.$bool((p.next.$less(p.end))) && !(Native.$bool(Native.$bool(Native.$bool((p.next.$less(p.end))) && Native.$bool((p.next.$add(1).$less(p.end)))) && Native.$bool((p.next.$star()) == (endc))) && Native.$bool(((p.next.$add(1)).$star()) == ($$RSQUARE)))) {
//    (p.next.$postInc());
//  }
//  if (!(p.next.$less(p.end))) {
//    seterr(p, (7));
//    return (0);
//  }
//  len = p.next.$sub(sp);
//  for (cp = cnames; $noteq_ptr(cp.name, ((Object/*void P*/ )NULL)); cp++)  {
//    if (Native.$bool(strncmp(cp.name, sp, len) == 0) && Native.$bool(cp.name.$at(len) == $$TERM)) {
//      return (cp.code); /* known name */
//    }
//  }
//  if (len == 1) {
//    return (sp.$star()); /* single character */
//  }
//  seterr(p, (3)); /* neither */
//  return (0);
}


/*
- othercase - return the case counterpart of an alphabetic
*/
//<editor-fold defaultstate="collapsed" desc="othercase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 900,
 FQN="othercase", NM="_ZL9othercase",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9othercase")
//</editor-fold>
public static /*char*/byte othercase(int ch) {
  ch = $uchar2int((/*uchar*/byte)ch);
  assert(isalpha(ch) != 0);
  if (isupper(ch) != 0) {
    return ((/*uchar*/byte)tolower(ch));
  } else if (islower(ch) != 0) {
    return ((/*uchar*/byte)toupper(ch));
  } else { /* peculiar, but could happen */
    return (/*uchar*/byte)(ch);
  }
}


/*
- bothcases - emit a dualcase version of a two-case character
*
* Boy, is this implementation ever a kludge...
*/
//<editor-fold defaultstate="collapsed" desc="bothcases">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 918,
 FQN="bothcases", NM="_ZL9bothcases",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9bothcases")
//</editor-fold>
public static void bothcases( parse /*P*/ p, int ch) {
  char$ptr/*char P*/ oldnext = $tryClone(p.next);
  char$ptr/*char P*/ oldend = $tryClone(p.end);
  /*char*/byte bracket[/*3*/] = new$char(3);
  
  ch = $uchar2int((/*uchar*/byte)ch);
  //(/*J:(void)*/(0)); /* p_bracket() would recurse */
  p.next = create_char$ptr(bracket);
  p.end = create_char$ptr(bracket, 2);
  bracket[0] = (byte)ch;
  bracket[1] = $$RSQUARE;
  bracket[2] = $$TERM;
  p_bracket(p);
  //(/*J:(void)*/(0));
  p.next = $tryClone(oldnext);
  p.end = $tryClone(oldend);
}


/*
- ordinary - emit an ordinary character
*/
//<editor-fold defaultstate="collapsed" desc="ordinary">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 941,
 FQN="ordinary", NM="_ZL8ordinary",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8ordinary")
//</editor-fold>
public static void ordinary( parse /*P*/ p, int ch) {
  char$ptr/*uchar P*/ cap = $tryClone(p.g.categories);
  if (Native.$bool(Native.$bool((p.g.cflags & REG_ICASE)) && Native.$bool(isalpha(ch))) && Native.$bool(othercase(ch) != ch)) {
    bothcases(p, ch);
  } else {
    doemit(p, (/*ulong*/long)((2L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((/*uchar*/byte)ch));
    if ($uchar2int(cap.$at(ch)) == 0) {
      cap.$set(ch, $int2uchar(p.g.ncategories++));
    }
  }
}


/*
- nonnewline - emit REG_NEWLINE version of OANY
*
* Boy, is this implementation ever a kludge...
*/
//<editor-fold defaultstate="collapsed" desc="nonnewline">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 960,
 FQN="nonnewline", NM="_ZL10nonnewline",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL10nonnewline")
//</editor-fold>
public static void nonnewline( parse /*P*/ p) {
  char$ptr/*char P*/ oldnext = $tryClone(p.next);
  char$ptr/*char P*/ oldend = $tryClone(p.end);
  /*char*/byte bracket[/*4*/] = new$char(4);
  
  p.next = create_char$ptr(bracket);
  p.end = create_char$ptr(bracket, (3));
  bracket[0] = $$CARET;
  bracket[1] = $$LF;
  bracket[2] = $$RSQUARE;
  bracket[3] = $$TERM;
  p_bracket(p);
  //(/*J:(void)*/(0));
  p.next = $tryClone(oldnext);
  p.end = $tryClone(oldend);
}


/*
- repeat - generate code for a bounded repetition, recursively if needed
*/
//<editor-fold defaultstate="collapsed" desc="repeat">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 982,
 FQN="repeat", NM="_ZL6repeat",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL6repeat")
//</editor-fold>
public static void repeat( parse /*P*/ p, 
      long start,  /* operand from here to end of strip */
      int from,  /* repeated from this number */
      int to) {
  long finish = (p.slen);
  long copy;
  if (p.error != 0) { /* head off possible runaway recursion */
    return;
  }
  //(/*J:(void)*/(0));
  switch ((((((from) <= 1) ? (from) : ((from) == (255 + 1)) ? 3 : 2)) * 8 + ((((to) <= 1) ? (to) : ((to) == (255 + 1)) ? 3 : 2)))) {
   case 0 * 8 + 0: /* must be user doing this */
    p.slen -= (finish - start); /* drop the operand */
    break;
   case 0 * 8 + 1: /* as x{1,1}? */
   case 0 * 8 + 2: /* as x{1,n}? */
   case 0 * 8 + 3: /* as x{1,}? */
    /* KLUDGE: emit y? as (y|) until subtle bug gets fixed */
    doinsert(p, (/*ulong*/long)((15L/*UL*/ << ((/*uint*/int)27))), $long2uint((p.slen) - (start) + 1), start); /* offset is wrong... */
    repeat(p, start + 1, 1, to);
    doemit(p, (/*ulong*/long)((16L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - start));
    dofwd(p, start, (p.slen) - (start)); /* ... fix it */
    doemit(p, (/*ulong*/long)((17L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0));
    dofwd(p, (p.slen - 1), (p.slen) - ((p.slen - 1)));
    doemit(p, (/*ulong*/long)((18L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - (p.slen - 2)));
    break;
   case 1 * 8 + 1: /* trivial case */
    /* done */
    break;
   case 1 * 8 + 2: /* as x?x{1,n-1} */
    /* KLUDGE: emit y? as (y|) until subtle bug gets fixed */
    doinsert(p, (/*ulong*/long)((15L/*UL*/ << ((/*uint*/int)27))), $long2uint((p.slen) - (start) + 1), start);
    doemit(p, (/*ulong*/long)((16L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - start));
    dofwd(p, start, (p.slen) - (start));
    doemit(p, (/*ulong*/long)((17L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)(0)); /* offset very wrong... */
    dofwd(p, (p.slen - 1), (p.slen) - ((p.slen - 1))); /* ...so fix it */
    doemit(p, (/*ulong*/long)((18L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - (p.slen - 2)));
    copy = dupl(p, start + 1, finish + 1);
    //(/*J:(void)*/(0));
    repeat(p, copy, 1, to - 1);
    break;
   case 1 * 8 + 3: /* as x+ */
    doinsert(p, (/*ulong*/long)((9L/*UL*/ << ((/*uint*/int)27))), $long2uint((p.slen) - (start) + 1), start);
    doemit(p, (/*ulong*/long)((10L/*UL*/ << ((/*uint*/int)27))), (/*size_t*/int)((p.slen) - start));
    break;
   case 2 * 8 + 2: /* as xx{m-1,n-1} */
    copy = dupl(p, start, finish);
    repeat(p, copy, from - 1, to - 1);
    break;
   case 2 * 8 + 3: /* as xx{n-1,INF} */
    copy = dupl(p, start, finish);
    repeat(p, copy, from - 1, to);
    break;
   default: /* "can't happen" */
    seterr(p, (15)); /* just in case */
    break;
  }
}


/*
- seterr - set an error condition
*/
//<editor-fold defaultstate="collapsed" desc="seterr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1052,
 FQN="seterr", NM="_ZL6seterr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL6seterr")
//</editor-fold>
public static int seterr( parse /*P*/ p, int e) {
  if (p.error == 0) { /* keep earliest error condition */
    p.error = e;
  }
  p.next = $tryClone(nuls); /* try to bring things to a halt */
  p.end = $tryClone(nuls);
  return (0); /* make the return value well-defined */
}


/*
- allocset - allocate a set of characters for []
*/
//<editor-fold defaultstate="collapsed" desc="allocset">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1065,
 FQN="allocset", NM="_ZL8allocset",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8allocset")
//</editor-fold>
public static  cset /*P*/ allocset( parse /*P*/ p) {
  NativeTrace.traceNotImplemented("allocset");
  return null;
//  int no = p.g.ncsets++;
//  /*size_t*/int nc;
//  /*size_t*/int nbytes;
//   cset /*P*/ cs;
//  /*size_t*/int css = (/*size_t*/int)p.g.csetsize;
//  int i;
//  if (no >= p.ncsalloc) { /* need another column of space */
//    Object/*void P*/ ptr;
//    
//    p.ncsalloc += CHAR_BIT;
//    nc = p.ncsalloc;
//    if ($greater_uint(nc, $div_uint(SIZE_MAX, $sizeof_Cset()))) {
//      goto nomem;
//    }
//    //(/*J:(void)*/(0));
//    nbytes = $div_uint(nc, CHAR_BIT) * css;
//    
//    ptr = ( cset /*P*/ )realloc((char$ptr/*char P*/ )p.g.sets, nc * $sizeof_Cset());
//    if ($eq_ptr(ptr, ((Object/*void P*/ )NULL))) {
//      goto nomem;
//    }
//    p.g.sets = ptr;
//    
//    ptr = $tryClone(reinterpret_cast(char$ptr/*uchar P*/ .class, realloc(reinterpret_cast(char$ptr/*char P*/ .class, p.g.setbits), nbytes)));
//    if ($eq_ptr(ptr, ((Object/*void P*/ )NULL))) {
//      goto nomem;
//    }
//    p.g.setbits = $tryClone(ptr);
//    
//    for (i = 0; i < no; i++)  {
//      p.g.sets[i].ptr = $tryClone(p.g.setbits.$add(css * (i / CHAR_BIT)));
//    }
//    
//    /*J:(void)*/memset(reinterpret_cast(char$ptr/*char P*/ .class, p.g.setbits).$add((nbytes - css)), 0, css);
//  }
//  /* XXX should not happen */
//  if (Native.$bool(p.g.sets == ((Object/*void P*/ )NULL)) || Native.$bool($eq_ptr(p.g.setbits, ((Object/*void P*/ )NULL)))) {
//    goto nomem;
//  }
//  
//  cs = /*AddrOf*/p.g.sets[no];
//  cs.ptr = $tryClone(p.g.setbits.$add(css * ((no) / CHAR_BIT)));
//  cs.mask = $int2uchar(1 << ((no) % CHAR_BIT));
//  cs.hash = $int2uchar(0);
//  cs.smultis = 0;
//  cs.multis = $tryClone(null);
//  
//  return (cs);
// nomem:
//  free(p.g.sets);
//  p.g.sets = null;
//  free(p.g.setbits);
//  p.g.setbits = $tryClone(null);
//  seterr(p, (12));
//  /* caller's responsibility not to do set ops */
//  return null;
}


/*
- freeset - free a now-unused set
*/
//<editor-fold defaultstate="collapsed" desc="freeset">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1126,
 FQN="freeset", NM="_ZL7freeset",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL7freeset")
//</editor-fold>
public static void freeset( parse /*P*/ p,  cset /*P*/ cs) {
  /*size_t*/int i;
   cset /*P*/ top = $AddrOf(p.g.sets.$at(p.g.ncsets));
  /*size_t*/int css = (/*size_t*/int)p.g.csetsize;
  
  for (i = 0; $less_uint(i, css); i++)  {
    CHsub(cs, (byte)i);
  }
  if (p.g.ncsets > 0 && cs == p.g.sets.$at(p.g.ncsets-1)) { /* recover only the easy case */
    p.g.ncsets--;
  }
}


/*
- freezeset - final processing on a set of characters
*
* The main task here is merging identical sets.  This is usually a waste
* of time (although the hash code minimizes the overhead), but can win
* big if REG_ICASE is being used.  REG_ICASE, by the way, is why the hash
* is done using addition rather than xor -- all ASCII [aA] sets xor to
* the same value!
*/
//<editor-fold defaultstate="collapsed" desc="freezeset">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1148,
 FQN="freezeset", NM="_ZL9freezeset",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9freezeset")
//</editor-fold>
public static int freezeset( parse /*P*/ p,  cset /*P*/ cs) {
  NativeTrace.traceNotImplemented("freezeset");
  return 0;
//  /*uchar*/byte h = cs.hash;
//  /*size_t*/int i;
//   cset /*P*/ top = /*AddrOf*/p.g.sets[p.g.ncsets];
//   cset /*P*/ cs2;
//  /*size_t*/int css = (/*size_t*/int)p.g.csetsize;
//  
//  /* look for an earlier one which is the same */
//  for (cs2 = /*AddrOf*/p.g.sets[0]; cs2 < top; cs2++)  {
//    if (Native.$bool($uchar2int(cs2.hash) == $uchar2int(h)) && Native.$bool(cs2 != cs)) {
//      /* maybe */
//      for (i = 0; $less_uint(i, css); i++)  {
//        if (!!($uchar2int((cs2).ptr.$at((/*uchar*/byte)(i))) & $uchar2int((cs2).mask)) != !!($uchar2int((cs).ptr.$at((/*uchar*/byte)(i))) & $uchar2int((cs).mask))) {
//          break; /* no */
//        }
//      }
//      if (i == css) {
//        break; /* yes */
//      }
//    }
//  }
//  if (cs2 < top) { /* found one */
//    freeset(p, cs);
//    cs = cs2;
//  }
//  
//  return ((int)(cs - p.g.sets));
}

/*
- firstch - return first character in a set (which must have at least one)
*/
//<editor-fold defaultstate="collapsed" desc="firstch">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1179,
 FQN="firstch", NM="_ZL7firstch",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL7firstch")
//</editor-fold>
public static int firstch( parse /*P*/ p,  cset /*P*/ cs) {
  /*size_t*/int i;
  /*size_t*/int css = (/*size_t*/int)p.g.csetsize;
  
  for (i = 0; $less_uint(i, css); i++)  {
    if (CHIN(cs, (/*uchar*/byte)(i))) {
      return ((/*char*/byte)i);
    }
  }
  assert false;
  return (0); /* arbitrary */
}


/*
- nch - number of characters in a set
*/
//<editor-fold defaultstate="collapsed" desc="nch">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1195,
 FQN="nch", NM="_ZL3nch",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL3nch")
//</editor-fold>
public static int nch( parse /*P*/ p,  cset /*P*/ cs) {
  /*size_t*/int i;
  /*size_t*/int css = (/*size_t*/int)p.g.csetsize;
  int n = 0;
  
  for (i = 0; $less_uint(i, css); i++)  {
    if (CHIN(cs, (/*uchar*/byte)(i))) {
      n++;
    }
  }
  return (n);
}


/*
- mcadd - add a collating element to a cset
*/
//<editor-fold defaultstate="collapsed" desc="mcadd">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1211,
 FQN="mcadd", NM="_ZL5mcadd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL5mcadd")
//</editor-fold>
public static void mcadd( parse /*P*/ p,  cset /*P*/ cs, /*const*/char$ptr/*char P*/ cp) {
  NativeTrace.traceNotImplemented("freezeset");
//  /*size_t*/int oldend = cs.smultis;
//  Object/*void P*/ np;
//  
//  cs.smultis += strlen(cp) + 1;
//  np = realloc(cs.multis, cs.smultis);
//  if ($eq_ptr(np, ((Object/*void P*/ )NULL))) {
//    if (cs.multis) {
//      free(cs.multis);
//    }
//    cs.multis = $tryClone(null);
//    seterr(p, (12));
//    return;
//  }
//  cs.multis = $tryClone(np);
//  
//  llvm_strlcpy(cs.multis.$add(oldend).$sub(1), cp, cs.smultis - oldend + 1);
}


/*
- mcinvert - invert the list of collating elements in a cset
*
* This would have to know the set of possibilities.  Implementation
* is deferred.
*/
/* ARGSUSED */
//<editor-fold defaultstate="collapsed" desc="mcinvert">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1238,
 FQN="mcinvert", NM="_ZL8mcinvert",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8mcinvert")
//</editor-fold>
public static void mcinvert( parse /*P*/ p,  cset /*P*/ cs) {
  assert(cs.multis == NULL);	/* xxx */
}


/*
- mccase - add case counterparts of the list of collating elements in a cset
*
* This would have to know the set of possibilities.  Implementation
* is deferred.
*/
/* ARGSUSED */
//<editor-fold defaultstate="collapsed" desc="mccase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1251,
 FQN="mccase", NM="_ZL6mccase",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL6mccase")
//</editor-fold>
public static void mccase( parse /*P*/ p,  cset /*P*/ cs) {
  assert(cs.multis == NULL);	/* xxx */
}


/*
- isinsets - is this character in any sets?
*/
//<editor-fold defaultstate="collapsed" desc="isinsets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1260,
 FQN="isinsets", NM="_ZL8isinsets",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8isinsets")
//</editor-fold>
public static int isinsets( re_guts /*P*/ g, int c) {
  char$ptr/*uchar P*/ col;
  int i;
  int ncols = (g.ncsets + (CHAR_BIT - 1)) / CHAR_BIT;
  /*uint*/int uc = $uchar2uint((/*uchar*/byte)c);
  
  for (i = 0 , col = $tryClone(g.setbits); i < ncols; i++ , col.$inc(g.csetsize))  {
    if ($uchar2int(col.$at(uc)) != 0) {
      return (1);
    }
  }
  return (0);
}


/*
- samesets - are these two characters in exactly the same sets?
*/
//<editor-fold defaultstate="collapsed" desc="samesets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1277,
 FQN="samesets", NM="_ZL8samesets",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8samesets")
//</editor-fold>
public static int samesets( re_guts /*P*/ g, int c1, int c2) {
  char$ptr/*uchar P*/ col;
  int i;
  int ncols = (g.ncsets + (CHAR_BIT - 1)) / CHAR_BIT;
  /*uint*/int uc1 = $uchar2uint((/*uchar*/byte)c1);
  /*uint*/int uc2 = $uchar2uint((/*uchar*/byte)c2);
  
  for (i = 0 , col = $tryClone(g.setbits); i < ncols; i++ , col.$inc(g.csetsize))  {
    if ($uchar2int(col.$at(uc1)) != $uchar2int(col.$at(uc2))) {
      return (0);
    }
  }
  return (1);
}


/*
- categorize - sort out character categories
*/
//<editor-fold defaultstate="collapsed" desc="categorize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1295,
 FQN="categorize", NM="_ZL10categorize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL10categorize")
//</editor-fold>
public static void categorize( parse /*P*/ p,  re_guts /*P*/ g) {
  char$ptr/*uchar P*/ cats = $tryClone(g.categories);
  int c;
  int c2;
  /*uchar*/byte cat;
  
  /* avoid making error situations worse */
  if (p.error != 0) {
    return;
  }
  
  for (c = CHAR_MIN; c <= CHAR_MAX; c++)  {
    if (Native.$bool($uchar2int(cats.$at(c)) == 0) && Native.$bool(isinsets(g, c))) {
      cat = $int2uchar(g.ncategories++);
      cats.$set(c, cat);
      for (c2 = c + 1; c2 <= CHAR_MAX; c2++)  {
        if (Native.$bool($uchar2int(cats.$at(c2)) == 0) && Native.$bool(samesets(g, c, c2))) {
          cats.$set(c2, cat);
        }
      }
    }
  }
}


/*
- dupl - emit a duplicate of a bunch of sops
*/
//<editor-fold defaultstate="collapsed" desc="dupl">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1320,
 FQN="dupl", NM="_ZL4dupl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL4dupl")
//</editor-fold>
public static long dupl( parse /*P*/ p, 
    long start,  /* from here */
    long finish) {
  NativeTrace.traceNotImplemented("freezeset");
  return 0;
//  long ret = (p.slen);
//  long len = finish - start;
//  (/*J:(void)*/(0));
//  if (len == 0) {
//    return (ret);
//  }
//  enlarge(p, p.ssize + len); /* this many unexpected additions */
//  (/*J:(void)*/(0));
//  /*J:(void)*/memmove(reinterpret_cast(char$ptr/*char P*/ .class, (p.strip.$add(p.slen))), 
//      reinterpret_cast(char$ptr/*char P*/ .class, (p.strip.$add(start))), (/*size_t*/int)len * $sizeof_ULong());
//  p.slen += len;
//  return (ret);
}

/*
- doemit - emit a strip operator
*
* It might seem better to implement this as a macro with a function as
* hard-case backup, but it's just too big and messy unless there are
* some changes to the data structures.  Maybe later.
*/
//<editor-fold defaultstate="collapsed" desc="doemit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1346,
 FQN="doemit", NM="_ZL6doemit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL6doemit")
//</editor-fold>
public static void doemit( parse /*P*/ p, /*ulong*/long op, /*size_t*/int opnd) {
  /* avoid making error situations worse */
  if (p.error != 0) {
    return;
  }
  
  /* deal with oversize operands ("can't happen", more or less) */
//  (/*J:(void)*/(0));
  
  /* deal with undersized strip */
  if (p.slen >= p.ssize) {
    enlarge(p, (p.ssize + 1) / 2 * 3); /* +50% */
  }
//  (/*J:(void)*/(0));
  
  /* finally, it's all reduced to the easy case */
  p.strip.$set((int)p.slen++, ((op) | (opnd)));
}


/*
- doinsert - insert a sop into the strip
*/
//<editor-fold defaultstate="collapsed" desc="doinsert">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1368,
 FQN="doinsert", NM="_ZL8doinsert",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8doinsert")
//</editor-fold>
public static void doinsert( parse /*P*/ p, /*ulong*/long op, /*size_t*/int opnd, long pos) {
  NativeTrace.traceNotImplemented("doinsert");
//  long sn;
//  /*ulong*/long s;
//  int i;
//  
//  /* avoid making error situations worse */
//  if (p.error != 0) {
//    return;
//  }
//  
//  sn = (p.slen);
//  doemit(p, (/*ulong*/long)(op), (/*size_t*/int)(opnd)); /* do checks, ensure space */
//  (/*J:(void)*/(0));
//  s = p.strip.$at(sn);
//  
//  /* adjust paren pointers */
//  (/*J:(void)*/(0));
//  for (i = 1; i < NPAREN; i++) {
//    if (p.pbegin[i] >= pos) {
//      p.pbegin[i]++;
//    }
//    if (p.pend[i] >= pos) {
//      p.pend[i]++;
//    }
//  }
//  
//  memmove(reinterpret_cast(char$ptr/*char P*/ .class, p.strip.$set$addr(pos + 1)), reinterpret_cast(char$ptr/*char P*/ .class, p.strip.$set$addr(pos)), 
//      ((p.slen) - pos - 1) * $sizeof_ULong());
//  p.strip.$set(pos, s);
}


/*
- dofwd - complete a forward reference
*/
//<editor-fold defaultstate="collapsed" desc="dofwd">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1403,
 FQN="dofwd", NM="_ZL5dofwd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL5dofwd")
//</editor-fold>
public static void dofwd( parse /*P*/ p, long pos, /*ulong*/long value) {
  /* avoid making error situations worse */
  if (p.error != 0) {
    return;
  }
  assert($less_ulong(value, 1L<<OPSHIFT));
  p.strip.$set($long2uint(pos), ((p.strip.$at($long2uint(pos))) & 0xF8000000L/*UL*/) | value);
}


/*
- enlarge - enlarge the strip
*/
//<editor-fold defaultstate="collapsed" desc="enlarge">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1417,
 FQN="enlarge", NM="_ZL7enlarge",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL7enlarge")
//</editor-fold>
public static void enlarge( parse /*P*/ p, long size) {
  NativeTrace.traceNotImplemented("enlarge");
//  /*ulong*/long/*P*/ sp;
//  if (p.ssize >= size) {
//    return;
//  }
//  if ($greater_uintptr_t_uint((Object/*uintptr_t*/)size, $div_uint(SIZE_MAX, $sizeof_ULong()))) {
//    seterr(p, (12));
//    return;
//  }
//  
//  sp = $tryClone(reinterpret_cast(/*ulong*/long/*P*/ .class, realloc(p.strip, size * $sizeof_ULong())));
//  if ($eq_ptr(sp, ((Object/*void P*/ )NULL))) {
//    seterr(p, (12));
//    return;
//  }
//  p.strip = $tryClone(sp);
//  p.ssize = size;
}


/*
- stripsnug - compact the strip
*/
//<editor-fold defaultstate="collapsed" desc="stripsnug">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1442,
 FQN="stripsnug", NM="_ZL9stripsnug",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9stripsnug")
//</editor-fold>
public static void stripsnug( parse /*P*/ p,  re_guts /*P*/ g) {
  NativeTrace.traceNotImplemented("stripsnug");
//  g.nstates = p.slen;
//  if ($greater_uintptr_t_uint((Object/*uintptr_t*/)p.slen, $div_uint(SIZE_MAX, $sizeof_ULong()))) {
//    g.strip = $tryClone(p.strip);
//    seterr(p, (12));
//    return;
//  }
//  
//  g.strip = $tryClone(reinterpret_cast(/*ulong*/long/*P*/ .class, realloc(reinterpret_cast(char$ptr/*char P*/ .class, p.strip), p.slen * $sizeof_ULong())));
//  if ($eq_ptr(g.strip, ((Object/*void P*/ )NULL))) {
//    seterr(p, (12));
//    g.strip = $tryClone(p.strip);
//  }
}


/*
- findmust - fill in must and mlen with longest mandatory literal string
*
* This algorithm could do fancy things like analyzing the operands of |
* for common subsequences.  Someday.  This code is simple and finds most
* of the interesting cases.
*
* Note that must and mlen got initialized during setup.
*/
//<editor-fold defaultstate="collapsed" desc="findmust">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1468,
 FQN="findmust", NM="_ZL8findmust",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8findmust")
//</editor-fold>
public static void findmust( parse /*P*/ p,  re_guts /*P*/ g) {
  NativeTrace.traceNotImplemented("findmust");
//  /*ulong*/long/*P*/ scan;
//  /*ulong*/long/*P*/ start = null; /* start initialized in the default case, after that */
//  /*ulong*/long/*P*/ newstart = null; /* newstart was initialized in the OCHAR case */
//  long newlen;
//  /*ulong*/long s;
//  char$ptr/*char P*/ cp = create_char$ptr();
//  long i;
//  
//  /* avoid making error situations worse */
//  if (p.error != 0) {
//    return;
//  }
//  
//  /* find the longest OCHAR sequence in strip */
//  newlen = 0;
//  scan = $tryClone(g.strip.$add(1));
//  do {
//    s = scan.$postInc().$star();
//    switch (((s) & 0xF8000000L/*UL*/)) {
//     case 2L/*UL*/ << (/*uint*/int)27: /* sequence member */
//      if (newlen == 0) { /* new sequence */
//        newstart = $tryClone(scan.$sub(1));
//      }
//      newlen++;
//      break;
//     case 9L/*UL*/ << (/*uint*/int)27: /* things that don't break one */
//     case 13L/*UL*/ << (/*uint*/int)27:
//     case 14L/*UL*/ << (/*uint*/int)27:
//      break;
//     case 11L/*UL*/ << (/*uint*/int)27: /* things that must be skipped */
//     case 15L/*UL*/ << (/*uint*/int)27:
//      scan.$postDec();
//      do {
//        scan.$inc(((s) & 0x7FFFFFFL/*UL*/));
//        s = scan.$star();
//        /* assert() interferes w debug printouts */
//        if (Native.$bool(Native.$bool(((s) & 0xF8000000L/*UL*/) != O_QUEST) && Native.$bool(((s) & 0xF8000000L/*UL*/) != O_CH))
//           && Native.$bool(((s) & 0xF8000000L/*UL*/) != OOR2)) {
//          g.iflags |= REGEX_BAD;
//          return;
//        }
//      } while (Native.$bool(((s) & 0xF8000000L/*UL*/) != O_QUEST) && Native.$bool(((s) & 0xF8000000L/*UL*/) != O_CH));
//     default: /* things that break a sequence */
//      if (newlen > g.mlen) { /* ends one */
//        start = $tryClone(newstart);
//        g.mlen = newlen;
//      }
//      newlen = 0;
//      break;
//    }
//  } while (((s) & 0xF8000000L/*UL*/) != OEND);
//  if (g.mlen == 0) { /* there isn't one */
//    return;
//  }
//  
//  /* turn it into a character string */
//  g.must = $tryClone(malloc((/*size_t*/int)g.mlen + 1));
//  if ($eq_ptr(g.must, ((Object/*void P*/ )NULL))) { /* argh; just forget it */
//    g.mlen = 0;
//    return;
//  }
//  cp = $tryClone(g.must);
//  scan = $tryClone(start);
//  for (i = g.mlen; i > 0; i--) {
//    while (((s = scan.$postInc().$star()) & 0xF8000000L/*UL*/) != OCHAR) {
//      continue;
//    }
//    (/*J:(void)*/(0));
//    cp.$postInc().$set((/*char*/byte)((s) & 0x7FFFFFFL/*UL*/));
//  }
//  (/*J:(void)*/(0));
//  cp.$postInc().$set($$TERM); /* just on general principles */
}


/*
- pluscount - count + nesting
*/
//<editor-fold defaultstate="collapsed" desc="pluscount">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 1546,
 FQN="pluscount", NM="_ZL9pluscount",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL9pluscount")
//</editor-fold>
public static long pluscount( parse /*P*/ p,  re_guts /*P*/ g) {
  /*ulong*/ulong$ptr/*P*/ scan;
  /*ulong*/long s;
  long plusnest = 0;
  long maxnest = 0;
  if (p.error != 0) {
    return (0); /* there may not be an OEND */
  }
  
  scan = $tryClone(g.strip.$add(1));
  do {
    s = scan.$postInc().$star();
    long s$masked = ((s) & OPRMASK);
    // JAVA: switch => if
    if (s$masked == OPLUS_) {
      plusnest++;
    } else if (s$masked == O_PLUS) {
      if (plusnest > maxnest) {
        maxnest = plusnest;
      }
      plusnest--;
    }
  } while (((s) & OPRMASK) != OEND);
  if (plusnest != 0) {
    g.iflags |= REGEX_BAD;
  }
  return (maxnest);
}

} // END OF class regcompStatics
