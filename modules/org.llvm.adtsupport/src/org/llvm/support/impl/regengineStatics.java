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
import org.llvm.support.impl.regexJava.*;

//<editor-fold defaultstate="collapsed" desc="static type regengineStatics">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5lfast;_ZL5lslow;_ZL5lstep;_ZL5sfast;_ZL5sslow;_ZL5sstep;_ZL8lbackref;_ZL8ldissect;_ZL8lmatcher;_ZL8sbackref;_ZL8sdissect;_ZL8smatcher; -static-type=regengineStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class regengineStatics {


/*
- matcher - the actual matching engine
*/
//<editor-fold defaultstate="collapsed" desc="smatcher">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 130,
 FQN="smatcher", NM="_ZL8smatcher",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL8smatcher")
//</editor-fold>
public static int smatcher( re_guts /*P*/ g, /*const*/char$ptr/*char P*/ string, /*size_t*/int nmatch, 
        type$ptr<llvm_regmatch_t> pmatch, 
        int eflags) {
  NativeTrace.traceNotImplemented("smatcher");
  return 0;
//  /*const*/char$ptr/*char P*/ endp = create_char$ptr();
//  /*size_t*/int i;
//   smat mv;
//   smat /*P*/ m = /*AddrOf*/mv;
//  /*const*/char$ptr/*char P*/ dp = create_char$ptr();
//  /*const*/long gf = g.firststate + 1; /* +1 for OEND */
//  /*const*/long gl = g.laststate;
//  /*const*/char$ptr/*char P*/ start = create_char$ptr();
//  /*const*/char$ptr/*char P*/ stop = create_char$ptr();
//  
//  /* simplify the situation where possible */
//  if ((g.cflags & REG_NOSUB) != 0) {
//    nmatch = 0;
//  }
//  if ((eflags & REG_STARTEND) != 0) {
//    start = $tryClone(string.$add(pmatch[0].rm_so));
//    stop = $tryClone(string.$add(pmatch[0].rm_eo));
//  } else {
//    start = $tryClone(string);
//    stop = $tryClone(start.$add(strlen(start)));
//  }
//  if (stop.$less(start)) {
//    return (REG_INVARG);
//  }
//  
//  /* prescreening; this does wonders for this rather slow code */
//  if ($noteq_ptr(g.must, ((Object/*void P*/ )NULL))) {
//    for (dp = $tryClone(start); dp.$less(stop); dp.$postInc())  {
//      if (Native.$bool(Native.$bool(dp.$star() == g.must.$at(0)) && Native.$bool(stop.$sub(dp) >= g.mlen))
//         && Native.$bool(memcmp(dp, g.must, (/*size_t*/int)g.mlen) == 0)) {
//        break;
//      }
//    }
//    if ($eq_ptr(dp, stop)) { /* we didn't find g->must */
//      return (REG_NOMATCH);
//    }
//  }
//  
//  /* match struct setup */
//  m.g = g;
//  m.eflags = eflags;
//  m.pmatch = null;
//  m.lastpos = $tryClone(null);
//  m.offp = $tryClone(string);
//  m.beginp = $tryClone(start);
//  m.endp = $tryClone(stop);
//  ;
//  ((m.st) = 0);
//  ((m.fresh) = 0);
//  ((m.tmp) = 0);
//  ((m.empty) = 0);
//  ((m.empty) = 0);
//  
//  /* this loop does only one repetition except for backrefs */
//  for (;;) {
//    endp = $tryClone(sfast(m, start, stop, gf, gl));
//    if ($eq_ptr(endp, ((Object/*void P*/ )NULL))) { /* a miss */
//      free(m.pmatch);
//      free(reinterpret_cast(Object/*void P*/ .class, m.lastpos));
//      ;
//      return (REG_NOMATCH);
//    }
//    if (Native.$bool(nmatch == 0) && !g.backrefs) {
//      break; /* no further info needed */
//    }
//    
//    /* where? */
//    //(/*J:(void)*/(0));
//    for (;;) {
//      ;
//      endp = $tryClone(sslow(m, m.coldp, stop, gf, gl));
//      if ($noteq_ptr(endp, ((Object/*void P*/ )NULL))) {
//        break;
//      }
//      //(/*J:(void)*/(0));
//      m.coldp.$postInc();
//    }
//    if (Native.$bool(nmatch == 1) && !g.backrefs) {
//      break; /* no further info needed */
//    }
//    
//    /* oh my, they want the subexpressions... */
//    if (m.pmatch == ((Object/*void P*/ )NULL)) {
//      m.pmatch = ( llvm_regmatch_t /*P*/ )malloc((m.g.nsub + 1)
//             * $sizeof_Llvm_regmatch_t());
//    }
//    if (m.pmatch == ((Object/*void P*/ )NULL)) {
//      ;
//      return (REG_ESPACE);
//    }
//    for (i = 1; $lesseq_uint(i, m.g.nsub); i++)  {
//      m.pmatch[i].rm_so = m.pmatch[i].rm_eo = -1;
//    }
//    if (!g.backrefs && !(m.eflags & REG_BACKR)) {
//      ;
//      dp = $tryClone(sdissect(m, m.coldp, endp, gf, gl));
//    } else {
//      if (Native.$bool(g.nplus > 0) && Native.$bool($eq_ptr(m.lastpos, ((Object/*void P*/ )NULL)))) {
//        m.lastpos = $tryClone(reinterpret_cast(/*const*/type$ptr<char$ptr>/*char PP*/ .class, malloc((g.nplus + 1)
//               * $sizeof_ptr(/*char$ptr */))));
//      }
//      if (Native.$bool(g.nplus > 0) && Native.$bool($eq_ptr(m.lastpos, ((Object/*void P*/ )NULL)))) {
//        free(m.pmatch);
//        ;
//        return (REG_ESPACE);
//      }
//      ;
//      dp = $tryClone(sbackref(m, m.coldp, endp, gf, gl, (long)0, 0));
//    }
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      break;
//    }
//    
//    /* uh-oh... we couldn't find a subexpression-level match */
//    //(/*J:(void)*/(0)); /* must be back references doing it */
//    //(/*J:(void)*/(0));
//    for (;;) {
//      if (Native.$bool($noteq_ptr(dp, ((Object/*void P*/ )NULL))) || Native.$bool(endp.$lesseq(m.coldp))) {
//        break; /* defeat */
//      }
//      ;
//      endp = $tryClone(sslow(m, m.coldp, endp.$sub(1), gf, gl));
//      if ($eq_ptr(endp, ((Object/*void P*/ )NULL))) {
//        break; /* defeat */
//      }
//      ;
//      dp = $tryClone(sbackref(m, m.coldp, endp, gf, gl, (long)0, 0));
//    }
//    //(/*J:(void)*/(0));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) { /* found a shorter one */
//      break;
//    }
//    ;
//    if ($eq_ptr(m.coldp, stop)) {
//      break;
//    }
//    start = $tryClone(m.coldp.$add(1)); /* recycle starting later */
//  }
//  
//  /* fill in the details if requested */
//  if ($greater_uint(nmatch, 0)) {
//    pmatch[0].rm_so = m.coldp.$sub(m.offp);
//    pmatch[0].rm_eo = endp.$sub(m.offp);
//  }
//  if ($greater_uint(nmatch, 1)) {
//    //(/*J:(void)*/(0));
//    for (i = 1; $less_uint(i, nmatch); i++)  {
//      if ($lesseq_uint(i, m.g.nsub)) {
//        pmatch[i] = m.pmatch[i];
//      } else {
//        pmatch[i].rm_so = -1;
//        pmatch[i].rm_eo = -1;
//      }
//    }
//  }
//  if (m.pmatch != ((Object/*void P*/ )NULL)) {
//    free((char$ptr/*char P*/ )m.pmatch);
//  }
//  if ($noteq_ptr(m.lastpos, ((Object/*void P*/ )NULL))) {
//    free(reinterpret_cast(char$ptr/*char P*/ .class, m.lastpos));
//  }
//  ;
//  return (0);
}


/*
- dissect - figure out what matched what, no back references
*/
//<editor-fold defaultstate="collapsed" desc="sdissect">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 294,
 FQN="sdissect", NM="_ZL8sdissect",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL8sdissect")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ sdissect( smat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
        long stopst) {
  NativeTrace.traceNotImplemented("sdissect");
  return null;
//  int i;
//  long ss; /* start sop of current subRE */
//  long es; /* end sop of current subRE */
//  /*const*/char$ptr/*char P*/ sp = create_char$ptr(); /* start of string matched by it */
//  /*const*/char$ptr/*char P*/ stp = create_char$ptr(); /* string matched by it cannot pass here */
//  /*const*/char$ptr/*char P*/ rest = create_char$ptr(); /* start of rest of string */
//  /*const*/char$ptr/*char P*/ tail = create_char$ptr(); /* string unmatched by rest of RE */
//  long ssub; /* start sop of subsubRE */
//  long esub; /* end sop of subsubRE */
//  /*const*/char$ptr/*char P*/ ssp = create_char$ptr(); /* start of string matched by subsubRE */
//  /*const*/char$ptr/*char P*/ sep = create_char$ptr(); /* end of string matched by subsubRE */
//  /*const*/char$ptr/*char P*/ oldssp = create_char$ptr(); /* previous ssp */
//  ;
//  sp = $tryClone(start);
//  for (ss = startst; ss < stopst; ss = es) {
//    /* identify end of subRE */
//    es = ss;
//    switch (((m.g.strip.$at(es)) & 0xF8000000L/*UL*/)) {
//     case 9L/*UL*/ << (/*uint*/int)27:
//     case 11L/*UL*/ << (/*uint*/int)27:
//      es += ((m.g.strip.$at(es)) & 0x7FFFFFFL/*UL*/);
//      break;
//     case 15L/*UL*/ << (/*uint*/int)27:
//      while (((m.g.strip.$at(es)) & 0xF8000000L/*UL*/) != O_CH) {
//        es += ((m.g.strip.$at(es)) & 0x7FFFFFFL/*UL*/);
//      }
//      break;
//    }
//    es++;
//    
//    /* figure out what it matched */
//    switch (((m.g.strip.$at(ss)) & 0xF8000000L/*UL*/)) {
//     case 1L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 2L/*UL*/ << (/*uint*/int)27:
//      sp.$postInc();
//      break;
//     case 3L/*UL*/ << (/*uint*/int)27:
//     case 4L/*UL*/ << (/*uint*/int)27:
//     case 19L/*UL*/ << (/*uint*/int)27:
//     case 20L/*UL*/ << (/*uint*/int)27:
//      break;
//     case 5L/*UL*/ << (/*uint*/int)27:
//     case 6L/*UL*/ << (/*uint*/int)27:
//      sp.$postInc();
//      break;
//     case 7L/*UL*/ << (/*uint*/int)27:
//     case 8L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 11L/*UL*/ << (/*uint*/int)27:
//      /* cases where length of match is hard to find */
//      stp = $tryClone(stop);
//      for (;;) {
//        /* how long could this one be? */
//        rest = $tryClone(sslow(m, sp, stp, ss, es));
//        //(/*J:(void)*/(0)); /* it did match */
//        /* could the rest match the rest? */
//        tail = $tryClone(sslow(m, rest, stop, es, stopst));
//        if ($eq_ptr(tail, stop)) {
//          break; /* yes! */
//        }
//        /* no -- try a shorter match for this one */
//        stp = $tryClone(rest.$sub(1));
//        //(/*J:(void)*/(0)); /* it did work */
//      }
//      ssub = ss + 1;
//      esub = es - 1;
//      /* did innards match? */
//      if ($noteq_ptr(sslow(m, sp, rest, ssub, esub), ((Object/*void P*/ )NULL))) {
//        /*const*/char$ptr/*char P*/ dp = $tryClone(sdissect(m, sp, rest, ssub, esub));
//        /*J:(void)*/dp; /* avoid warning if assertions off */
//        //(/*J:(void)*/(0));
//      } else { /* no */
//        //(/*J:(void)*/(0));
//      }
//      sp = $tryClone(rest);
//      break;
//     case 9L/*UL*/ << (/*uint*/int)27:
//      stp = $tryClone(stop);
//      for (;;) {
//        /* how long could this one be? */
//        rest = $tryClone(sslow(m, sp, stp, ss, es));
//        //(/*J:(void)*/(0)); /* it did match */
//        /* could the rest match the rest? */
//        tail = $tryClone(sslow(m, rest, stop, es, stopst));
//        if ($eq_ptr(tail, stop)) {
//          break; /* yes! */
//        }
//        /* no -- try a shorter match for this one */
//        stp = $tryClone(rest.$sub(1));
//        //(/*J:(void)*/(0)); /* it did work */
//      }
//      ssub = ss + 1;
//      esub = es - 1;
//      ssp = $tryClone(sp);
//      oldssp = $tryClone(ssp);
//      for (;;) { /* find last match of innards */
//        sep = $tryClone(sslow(m, ssp, rest, ssub, esub));
//        if (Native.$bool($eq_ptr(sep, ((Object/*void P*/ )NULL))) || Native.$bool($eq_ptr(sep, ssp))) {
//          break; /* failed or matched null */
//        }
//        oldssp = $tryClone(ssp); /* on to next try */
//        ssp = $tryClone(sep);
//      }
//      if ($eq_ptr(sep, ((Object/*void P*/ )NULL))) {
//        /* last successful match */
//        sep = $tryClone(ssp);
//        ssp = $tryClone(oldssp);
//      }
//      //(/*J:(void)*/(0)); /* must exhaust substring */
//      //(/*J:(void)*/(0));
//      {
//        /*const*/char$ptr/*char P*/ dp = $tryClone(sdissect(m, ssp, sep, ssub, esub));
//        /*J:(void)*/dp; /* avoid warning if assertions off */
//        //(/*J:(void)*/(0));
//      }
//      sp = $tryClone(rest);
//      break;
//     case 15L/*UL*/ << (/*uint*/int)27:
//      stp = $tryClone(stop);
//      for (;;) {
//        /* how long could this one be? */
//        rest = $tryClone(sslow(m, sp, stp, ss, es));
//        //(/*J:(void)*/(0)); /* it did match */
//        /* could the rest match the rest? */
//        tail = $tryClone(sslow(m, rest, stop, es, stopst));
//        if ($eq_ptr(tail, stop)) {
//          break; /* yes! */
//        }
//        /* no -- try a shorter match for this one */
//        stp = $tryClone(rest.$sub(1));
//        //(/*J:(void)*/(0)); /* it did work */
//      }
//      ssub = ss + 1;
//      esub = ss + ((m.g.strip.$at(ss)) & 0x7FFFFFFL/*UL*/) - 1;
//      //(/*J:(void)*/(0));
//      for (;;) { /* find first matching branch */
//        if ($eq_ptr(sslow(m, sp, rest, ssub, esub), rest)) {
//          break; /* it matched all of it */
//        }
//        /* that one missed, try next one */
//        //(/*J:(void)*/(0));
//        esub++;
//        //(/*J:(void)*/(0));
//        ssub = esub + 1;
//        esub += ((m.g.strip.$at(esub)) & 0x7FFFFFFL/*UL*/);
//        if (((m.g.strip.$at(esub)) & 0xF8000000L/*UL*/) == OOR2) {
//          esub--;
//        } else {
//          //(/*J:(void)*/(0));
//        }
//      }
//      {
//        /*const*/char$ptr/*char P*/ dp = $tryClone(sdissect(m, sp, rest, ssub, esub));
//        /*J:(void)*/dp; /* avoid warning if assertions off */
//        //(/*J:(void)*/(0));
//      }
//      sp = $tryClone(rest);
//      break;
//     case 10L/*UL*/ << (/*uint*/int)27:
//     case 12L/*UL*/ << (/*uint*/int)27:
//     case 16L/*UL*/ << (/*uint*/int)27:
//     case 17L/*UL*/ << (/*uint*/int)27:
//     case 18L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 13L/*UL*/ << (/*uint*/int)27:
//      i = ((m.g.strip.$at(ss)) & 0x7FFFFFFL/*UL*/);
//      //(/*J:(void)*/(0));
//      m.pmatch[i].rm_so = sp.$sub(m.offp);
//      break;
//     case 14L/*UL*/ << (/*uint*/int)27:
//      i = ((m.g.strip.$at(ss)) & 0x7FFFFFFL/*UL*/);
//      //(/*J:(void)*/(0));
//      m.pmatch[i].rm_eo = sp.$sub(m.offp);
//      break;
//     default: /* uh oh */
//      //(/*J:(void)*/(0));
//      break;
//    }
//  }
//  //(/*J:(void)*/(0));
//  return (sp);
}


/*
- backref - figure out what matched what, figuring in back references
*/
//<editor-fold defaultstate="collapsed" desc="sbackref">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 482,
 FQN="sbackref", NM="_ZL8sbackref",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL8sbackref")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ sbackref( smat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
        long stopst, long lev, int rec) {
  NativeTrace.traceNotImplemented("sbackref");
  return null;
//  int i;
//  long ss; /* start sop of current subRE */
//  /*const*/char$ptr/*char P*/ sp = create_char$ptr(); /* start of string matched by it */
//  long ssub; /* start sop of subsubRE */
//  long esub; /* end sop of subsubRE */
//  /*const*/char$ptr/*char P*/ ssp = create_char$ptr(); /* start of string matched by subsubRE */
//  /*const*/char$ptr/*char P*/ dp = create_char$ptr();
//  /*size_t*/int len;
//  int hard;
//  /*ulong*/long s;
//  long/*off_t*/ offsave;
//   cset /*P*/ cs;
//  ;
//  sp = $tryClone(start);
//  
//  /* get as far as we can with easy stuff */
//  hard = 0;
//  for (ss = startst; !hard && Native.$bool(ss < stopst); ss++)  {
//    switch (((s = m.g.strip.$at(ss)) & 0xF8000000L/*UL*/)) {
//     case 2L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool($eq_ptr(sp, stop)) || Native.$bool(sp.$postInc().$star() != (/*char*/byte)((s) & 0x7FFFFFFL/*UL*/))) {
//        return null;
//      }
//      break;
//     case 5L/*UL*/ << (/*uint*/int)27:
//      if ($eq_ptr(sp, stop)) {
//        return null;
//      }
//      sp.$postInc();
//      break;
//     case 6L/*UL*/ << (/*uint*/int)27:
//      cs = /*AddrOf*/m.g.sets[(int)((s) & 0x7FFFFFFL/*UL*/)];
//      if (Native.$bool($eq_ptr(sp, stop)) || !($uchar2int((cs).ptr.$at((/*uchar*/byte)(sp.$postInc().$star()))) & $uchar2int((cs).mask))) {
//        return null;
//      }
//      break;
//     case 3L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool($eq_ptr(sp, m.beginp)) && !(m.eflags & REG_NOTBOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool((sp.$sub(1)).$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 4L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool($eq_ptr(sp, m.endp)) && !(m.eflags & REG_NOTEOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool(sp.$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 19L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool(Native.$bool((Native.$bool($eq_ptr(sp, m.beginp)) && !(m.eflags & REG_NOTBOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool((sp.$sub(1)).$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE)))))
//         || Native.$bool((Native.$bool(sp.$greater(m.beginp))
//         && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((sp.$sub(1)).$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool(((sp.$sub(1)).$star()) == $$UNDERSCORE))))))
//         && Native.$bool((Native.$bool(sp.$less(m.endp)) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((sp.$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((sp.$star()) == $$UNDERSCORE)))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 20L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool(Native.$bool((Native.$bool($eq_ptr(sp, m.endp)) && !(m.eflags & REG_NOTEOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool(sp.$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE)))))
//         || Native.$bool((Native.$bool(sp.$less(m.endp)) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((sp.$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((sp.$star()) == $$UNDERSCORE))))))
//         && Native.$bool((Native.$bool(sp.$greater(m.beginp)) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((sp.$sub(1)).$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool(((sp.$sub(1)).$star()) == $$UNDERSCORE)))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 12L/*UL*/ << (/*uint*/int)27:
//      break;
//     case 16L/*UL*/ << (/*uint*/int)27: /* matches null but needs to skip */
//      ss++;
//      s = m.g.strip.$at(ss);
//      do {
//        //(/*J:(void)*/(0));
//        ss += ((s) & 0x7FFFFFFL/*UL*/);
//      } while (((s = m.g.strip.$at(ss)) & 0xF8000000L/*UL*/) != O_CH);
//      /* note that the ss++ gets us past the O_CH */
//      break;
//     default: /* have to make a choice */
//      hard = 1;
//      break;
//    }
//  }
//  if (!hard) { /* that was it! */
//    if ($noteq_ptr(sp, stop)) {
//      return null;
//    }
//    return (sp);
//  }
//  ss--; /* adjust for the for's final increment */
//  ;
//  s = m.g.strip.$at(ss);
//  switch (((s) & 0xF8000000L/*UL*/)) {
//   case 7L/*UL*/ << (/*uint*/int)27: /* the vilest depths */
//    i = ((s) & 0x7FFFFFFL/*UL*/);
//    //(/*J:(void)*/(0));
//    if (m.pmatch[i].rm_eo == -1) {
//      return null;
//    }
//    //(/*J:(void)*/(0));
//    len = m.pmatch[i].rm_eo - m.pmatch[i].rm_so;
//    if (Native.$bool(len == 0) && Native.$bool(rec++ > MAX_RECURSION)) {
//      return null;
//    }
//    //(/*J:(void)*/(0));
//    if (sp.$greater(stop.$sub(len))) {
//      return null; /* not enough left to match */
//    }
//    ssp = $tryClone(m.offp.$add(m.pmatch[i].rm_so));
//    if (memcmp(sp, ssp, len) != 0) {
//      return null;
//    }
//    while (m.g.strip.$at(ss) != (((8L/*UL*/ << ((/*uint*/int)27))) | (i))) {
//      ss++;
//    }
//    return (sbackref(m, sp.$add(len), stop, ss + 1, stopst, lev, rec));
//    break;
//   case 11L/*UL*/ << (/*uint*/int)27: /* to null or not */
//    dp = $tryClone(sbackref(m, sp, stop, ss + 1, stopst, lev, rec));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (dp); /* not */
//    }
//    return (sbackref(m, sp, stop, ss + ((s) & 0x7FFFFFFL/*UL*/) + 1, stopst, lev, rec));
//    break;
//   case 9L/*UL*/ << (/*uint*/int)27:
//    //(/*J:(void)*/(0));
//    //(/*J:(void)*/(0));
//    m.lastpos.$set(lev + 1, sp);
//    return (sbackref(m, sp, stop, ss + 1, stopst, lev + 1, rec));
//    break;
//   case 10L/*UL*/ << (/*uint*/int)27:
//    if ($eq_ptr(sp, m.lastpos.$at(lev))) { /* last pass matched null */
//      return (sbackref(m, sp, stop, ss + 1, stopst, lev - 1, rec));
//    }
//    /* try another pass */
//    m.lastpos.$set(lev, sp);
//    dp = $tryClone(sbackref(m, sp, stop, ss - ((s) & 0x7FFFFFFL/*UL*/) + 1, stopst, lev, rec));
//    if ($eq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (sbackref(m, sp, stop, ss + 1, stopst, lev - 1, rec));
//    } else {
//      return (dp);
//    }
//    break;
//   case 15L/*UL*/ << (/*uint*/int)27: /* find the right one, if any */
//    ssub = ss + 1;
//    esub = ss + ((s) & 0x7FFFFFFL/*UL*/) - 1;
//    //(/*J:(void)*/(0));
//    for (;;) { /* find first matching branch */
//      dp = $tryClone(sbackref(m, sp, stop, ssub, esub, lev, rec));
//      if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//        return (dp);
//      }
//      /* that one missed, try next one */
//      if (((m.g.strip.$at(esub)) & 0xF8000000L/*UL*/) == O_CH) {
//        return null; /* there is none */
//      }
//      esub++;
//      //(/*J:(void)*/(0));
//      ssub = esub + 1;
//      esub += ((m.g.strip.$at(esub)) & 0x7FFFFFFL/*UL*/);
//      if (((m.g.strip.$at(esub)) & 0xF8000000L/*UL*/) == OOR2) {
//        esub--;
//      } else {
//        //(/*J:(void)*/(0));
//      }
//    }
//    break;
//   case 13L/*UL*/ << (/*uint*/int)27: /* must undo assignment if rest fails */
//    i = ((s) & 0x7FFFFFFL/*UL*/);
//    //(/*J:(void)*/(0));
//    offsave = m.pmatch[i].rm_so;
//    m.pmatch[i].rm_so = sp.$sub(m.offp);
//    dp = $tryClone(sbackref(m, sp, stop, ss + 1, stopst, lev, rec));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (dp);
//    }
//    m.pmatch[i].rm_so = offsave;
//    return null;
//    break;
//   case 14L/*UL*/ << (/*uint*/int)27: /* must undo assignment if rest fails */
//    i = ((s) & 0x7FFFFFFL/*UL*/);
//    //(/*J:(void)*/(0));
//    offsave = m.pmatch[i].rm_eo;
//    m.pmatch[i].rm_eo = sp.$sub(m.offp);
//    dp = $tryClone(sbackref(m, sp, stop, ss + 1, stopst, lev, rec));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (dp);
//    }
//    m.pmatch[i].rm_eo = offsave;
//    return null;
//    break;
//   default: /* uh oh */
//    //(/*J:(void)*/(0));
//    break;
//  }
//  
//  /* "can't happen" */
//  //(/*J:(void)*/(0));
//  /* NOTREACHED */
//  return null;
}


/*
- fast - step through the string at top speed
*/
//<editor-fold defaultstate="collapsed" desc="sfast">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 682,
 FQN="sfast", NM="_ZL5sfast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5sfast")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ sfast( smat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
     long stopst) {
  NativeTrace.traceNotImplemented("sfast");
  return null;
//  long st = m.st;
//  long fresh = m.fresh;
//  long tmp = m.tmp;
//  /*const*/char$ptr/*char P*/ p = $tryClone(start);
//  int c = ($eq_ptr(start, m.beginp)) ? OUT : (start.$sub(1)).$star();
//  int lastc; /* previous c */
//  int flagch;
//  int i;
//  /*const*/char$ptr/*char P*/ coldp = create_char$ptr(); /* last p after which no match was underway */
//  (st = 0);
//  (st |= (/*ulong*/long)1 << (startst));
//  st = sstep(m.g, startst, stopst, st, NOTHING, st);
//  ((fresh) = st);
//  ;
//  coldp = $tryClone(null);
//  for (;;) {
//    /* next character */
//    lastc = c;
//    c = ($eq_ptr(p, m.endp)) ? OUT : p.$star();
//    if ((st == (fresh))) {
//      coldp = $tryClone(p);
//    }
//    
//    /* is there an EOL and/or BOL between lastc and c? */
//    flagch = $$TERM;
//    i = 0;
//    if (Native.$bool((Native.$bool(lastc == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(lastc == OUT) && !(m.eflags & REG_NOTBOL)))) {
//      flagch = BOL;
//      i = m.g.nbol;
//    }
//    if (Native.$bool((Native.$bool(c == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(c == OUT) && !(m.eflags & REG_NOTEOL)))) {
//      flagch = (flagch == BOL) ? BOLEOL : EOL;
//      i += m.g.neol;
//    }
//    if (i != 0) {
//      for (; i > 0; i--)  {
//        st = sstep(m.g, startst, stopst, st, flagch, st);
//      }
//      ;
//    }
//    
//    /* how about a word boundary? */
//    if (Native.$bool((Native.$bool(flagch == BOL) || Native.$bool((Native.$bool(lastc != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE))))))
//       && Native.$bool((Native.$bool(c != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE)))))) {
//      flagch = BOW;
//    }
//    if (Native.$bool((Native.$bool(lastc != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE)))))
//       && Native.$bool((Native.$bool(flagch == EOL) || Native.$bool((Native.$bool(c != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE))))))) {
//      flagch = EOW;
//    }
//    if (Native.$bool(flagch == BOW) || Native.$bool(flagch == EOW)) {
//      st = sstep(m.g, startst, stopst, st, flagch, st);
//      ;
//    }
//    
//    /* are we done? */
//    if (Native.$bool((((st) & ((/*ulong*/long)1 << (stopst))) != 0)) || Native.$bool($eq_ptr(p, stop))) {
//      break; /* NOTE BREAK OUT */
//    }
//    
//    /* no, we must deal with this character */
//    tmp = (st);
//    st = (fresh);
//    //(/*J:(void)*/(0));
//    st = sstep(m.g, startst, stopst, tmp, c, st);
//    ;
//    //(/*J:(void)*/(0));
//    p.$postInc();
//  }
//  //(/*J:(void)*/(0));
//  m.coldp = $tryClone(coldp);
//  if ((((st) & ((/*ulong*/long)1 << (stopst))) != 0)) {
//    return (p.$add(1));
//  } else {
//    return null;
//  }
}


/*
- slow - step through the string more deliberately
*/
//<editor-fold defaultstate="collapsed" desc="sslow">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 767,
 FQN="sslow", NM="_ZL5sslow",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5sslow")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ sslow( smat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
     long stopst) {
  NativeTrace.traceNotImplemented("sslow");
  return null;
//  long st = m.st;
//  long empty = m.empty;
//  long tmp = m.tmp;
//  /*const*/char$ptr/*char P*/ p = $tryClone(start);
//  int c = ($eq_ptr(start, m.beginp)) ? OUT : (start.$sub(1)).$star();
//  int lastc; /* previous c */
//  int flagch;
//  int i;
//  /*const*/char$ptr/*char P*/ matchp = create_char$ptr(); /* last p at which a match ended */
//  ;
//  (st = 0);
//  ((st) |= (/*ulong*/long)1 << (startst));
//  ;
//  st = sstep(m.g, startst, stopst, st, NOTHING, st);
//  matchp = $tryClone(null);
//  for (;;) {
//    /* next character */
//    lastc = c;
//    c = ($eq_ptr(p, m.endp)) ? OUT : p.$star();
//    
//    /* is there an EOL and/or BOL between lastc and c? */
//    flagch = $$TERM;
//    i = 0;
//    if (Native.$bool((Native.$bool(lastc == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(lastc == OUT) && !(m.eflags & REG_NOTBOL)))) {
//      flagch = BOL;
//      i = m.g.nbol;
//    }
//    if (Native.$bool((Native.$bool(c == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(c == OUT) && !(m.eflags & REG_NOTEOL)))) {
//      flagch = (flagch == BOL) ? BOLEOL : EOL;
//      i += m.g.neol;
//    }
//    if (i != 0) {
//      for (; i > 0; i--)  {
//        st = sstep(m.g, startst, stopst, st, flagch, st);
//      }
//      ;
//    }
//    
//    /* how about a word boundary? */
//    if (Native.$bool((Native.$bool(flagch == BOL) || Native.$bool((Native.$bool(lastc != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE))))))
//       && Native.$bool((Native.$bool(c != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE)))))) {
//      flagch = BOW;
//    }
//    if (Native.$bool((Native.$bool(lastc != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE)))))
//       && Native.$bool((Native.$bool(flagch == EOL) || Native.$bool((Native.$bool(c != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE))))))) {
//      flagch = EOW;
//    }
//    if (Native.$bool(flagch == BOW) || Native.$bool(flagch == EOW)) {
//      st = sstep(m.g, startst, stopst, st, flagch, st);
//      ;
//    }
//    
//    /* are we done? */
//    if ((((st) & ((/*ulong*/long)1 << (stopst))) != 0)) {
//      matchp = $tryClone(p);
//    }
//    if (Native.$bool((st == (empty))) || Native.$bool($eq_ptr(p, stop))) {
//      break; /* NOTE BREAK OUT */
//    }
//    
//    /* no, we must deal with this character */
//    (tmp = (st));
//    (st = (empty));
//    //(/*J:(void)*/(0));
//    st = sstep(m.g, startst, stopst, tmp, c, st);
//    ;
//    //(/*J:(void)*/(0));
//    p.$postInc();
//  }
//  
//  return (matchp);
}


/*
- step - map set of states reachable before char to set reachable after
*/
//<editor-fold defaultstate="collapsed" desc="sstep">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 848,
 FQN="sstep", NM="_ZL5sstep",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5sstep")
//</editor-fold>
public static long sstep( re_guts /*P*/ g, 
     long start,  /* start state within strip */
     long stop,  /* state after stop state within strip */
     long bef,  /* states reachable before */
     int ch,  /* character or NONCHAR code */
     long aft) {
  NativeTrace.traceNotImplemented("sstep");
  return 0;
//   cset /*P*/ cs;
//  /*ulong*/long s;
//  long pc;
//  long here; /* note, macros know this name */
//  long look;
//  int i;
//  
//  for (pc = start , ((here) = (/*ulong*/long)1 << (pc)); pc != stop; pc++ , ((here) = (/*ulong*/long)(here) << 1)) {
//    s = g.strip.$at(pc);
//    switch (((s) & 0xF8000000L/*UL*/)) {
//     case 1L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 2L/*UL*/ << (/*uint*/int)27:
//      /* only characters can match */
//      //(/*J:(void)*/(0));
//      if (ch == (/*char*/byte)((s) & 0x7FFFFFFL/*UL*/)) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 3L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool(ch == BOL) || Native.$bool(ch == BOLEOL)) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 4L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool(ch == EOL) || Native.$bool(ch == BOLEOL)) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 19L/*UL*/ << (/*uint*/int)27:
//      if (ch == BOW) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 20L/*UL*/ << (/*uint*/int)27:
//      if (ch == EOW) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 5L/*UL*/ << (/*uint*/int)27:
//      if (!((ch) > 127)) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 6L/*UL*/ << (/*uint*/int)27:
//      cs = /*AddrOf*/g.sets[(int)((s) & 0x7FFFFFFL/*UL*/)];
//      if (!((ch) > 127) && Native.$bool(($uchar2int((cs).ptr.$at((/*uchar*/byte)(ch))) & $uchar2int((cs).mask)))) {
//        ((aft) |= ((/*ulong*/long)(bef) & (here)) << (1));
//      }
//      break;
//     case 7L/*UL*/ << (/*uint*/int)27: /* ignored here */
//     case 8L/*UL*/ << (/*uint*/int)27:
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      break;
//     case 9L/*UL*/ << (/*uint*/int)27: /* forward, this is just an empty */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      break;
//     case 10L/*UL*/ << (/*uint*/int)27: /* both forward and back */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      i = (((aft) & ((/*ulong*/long)here >>> (((s) & 0x7FFFFFFL/*UL*/)))) != 0);
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) >>> (((s) & 0x7FFFFFFL/*UL*/)));
//      if (!i && Native.$bool((((aft) & ((/*ulong*/long)here >>> (((s) & 0x7FFFFFFL/*UL*/)))) != 0))) {
//        /* oho, must reconsider loop body */
//        pc -= ((s) & 0x7FFFFFFL/*UL*/) + 1;
//        ((here) = (/*ulong*/long)1 << (pc));
//      }
//      break;
//     case 11L/*UL*/ << (/*uint*/int)27: /* two branches, both forward */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (((s) & 0x7FFFFFFL/*UL*/)));
//      break;
//     case 12L/*UL*/ << (/*uint*/int)27: /* just an empty */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      break;
//     case 13L/*UL*/ << (/*uint*/int)27: /* not significant here */
//     case 14L/*UL*/ << (/*uint*/int)27:
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      break;
//     case 15L/*UL*/ << (/*uint*/int)27: /* mark the first two branches */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      //(/*J:(void)*/(0));
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (((s) & 0x7FFFFFFL/*UL*/)));
//      break;
//     case 16L/*UL*/ << (/*uint*/int)27: /* done a branch, find the O_CH */
//      if ((((aft) & (here)) != 0)) {
//        for (look = 1;
//             ((s = g.strip.$at(pc + look)) & 0xF8000000L/*UL*/) != O_CH;
//             look += ((s) & 0x7FFFFFFL/*UL*/))  {
//          //(/*J:(void)*/(0));
//        }
//        ((aft) |= ((/*ulong*/long)(aft) & (here)) << (look));
//      }
//      break;
//     case 17L/*UL*/ << (/*uint*/int)27: /* propagate OCH_'s marking */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      if (((g.strip.$at(pc + ((s) & 0x7FFFFFFL/*UL*/))) & 0xF8000000L/*UL*/) != O_CH) {
//        //(/*J:(void)*/(0));
//        ((aft) |= ((/*ulong*/long)(aft) & (here)) << (((s) & 0x7FFFFFFL/*UL*/)));
//      }
//      break;
//     case 18L/*UL*/ << (/*uint*/int)27: /* just empty */
//      ((aft) |= ((/*ulong*/long)(aft) & (here)) << (1));
//      break;
//     default: /* ooooops... */
//      //(/*J:(void)*/(0));
//      break;
//    }
//  }
//  
//  return (aft);
}


/*
- matcher - the actual matching engine
*/
//<editor-fold defaultstate="collapsed" desc="lmatcher">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 130,
 FQN="lmatcher", NM="_ZL8lmatcher",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL8lmatcher")
//</editor-fold>
public static int lmatcher( re_guts /*P*/ g, /*const*/char$ptr/*char P*/ string, /*size_t*/int nmatch, 
        type$ptr<llvm_regmatch_t> pmatch, 
        int eflags) {
  NativeTrace.traceNotImplemented("lmatcher");
  return 0;
//  /*const*/char$ptr/*char P*/ endp = create_char$ptr();
//  /*size_t*/int i;
//   lmat mv;
//   lmat /*P*/ m = /*AddrOf*/mv;
//  /*const*/char$ptr/*char P*/ dp = create_char$ptr();
//  /*const*/long gf = g.firststate + 1; /* +1 for OEND */
//  /*const*/long gl = g.laststate;
//  /*const*/char$ptr/*char P*/ start = create_char$ptr();
//  /*const*/char$ptr/*char P*/ stop = create_char$ptr();
//  
//  /* simplify the situation where possible */
//  if (g.cflags & REG_NOSUB) {
//    nmatch = 0;
//  }
//  if (eflags & REG_STARTEND) {
//    start = $tryClone(string.$add(pmatch[0].rm_so));
//    stop = $tryClone(string.$add(pmatch[0].rm_eo));
//  } else {
//    start = $tryClone(string);
//    stop = $tryClone(start.$add(strlen(start)));
//  }
//  if (stop.$less(start)) {
//    return (REG_INVARG);
//  }
//  
//  /* prescreening; this does wonders for this rather slow code */
//  if ($noteq_ptr(g.must, ((Object/*void P*/ )NULL))) {
//    for (dp = $tryClone(start); dp.$less(stop); dp.$postInc())  {
//      if (Native.$bool(Native.$bool(dp.$star() == g.must.$at(0)) && Native.$bool(stop.$sub(dp) >= g.mlen))
//         && Native.$bool(memcmp(dp, g.must, (/*size_t*/int)g.mlen) == 0)) {
//        break;
//      }
//    }
//    if ($eq_ptr(dp, stop)) { /* we didn't find g->must */
//      return (REG_NOMATCH);
//    }
//  }
//  
//  /* match struct setup */
//  m.g = g;
//  m.eflags = eflags;
//  m.pmatch = null;
//  m.lastpos = $tryClone(null);
//  m.offp = $tryClone(string);
//  m.beginp = $tryClone(start);
//  m.endp = $tryClone(stop);
//  {
//    (m).space = $tryClone(malloc((4) * (m).g.nstates));
//    if ($eq_ptr((m).space, ((Object/*void P*/ )0))) {
//      return (12);
//    }
//    (m).vn = 0;
//  }
//  ;
//  ((m.st) = $tryClone(m.space.$set$addr(m.vn++ * m.g.nstates)));
//  ((m.fresh) = $tryClone(m.space.$set$addr(m.vn++ * m.g.nstates)));
//  ((m.tmp) = $tryClone(m.space.$set$addr(m.vn++ * m.g.nstates)));
//  ((m.empty) = $tryClone(m.space.$set$addr(m.vn++ * m.g.nstates)));
//  memset(m.empty, 0, m.g.nstates);
//  
//  /* this loop does only one repetition except for backrefs */
//  for (;;) {
//    endp = $tryClone(lfast(m, start, stop, gf, gl));
//    if ($eq_ptr(endp, ((Object/*void P*/ )NULL))) { /* a miss */
//      free(m.pmatch);
//      free(reinterpret_cast(Object/*void P*/ .class, m.lastpos));
//      {
//        free((m).space);
//      }
//      ;
//      return (REG_NOMATCH);
//    }
//    if (Native.$bool(nmatch == 0) && !g.backrefs) {
//      break; /* no further info needed */
//    }
//    
//    /* where? */
//    //(/*J:(void)*/(0));
//    for (;;) {
//      ;
//      endp = $tryClone(lslow(m, m.coldp, stop, gf, gl));
//      if ($noteq_ptr(endp, ((Object/*void P*/ )NULL))) {
//        break;
//      }
//      //(/*J:(void)*/(0));
//      m.coldp.$postInc();
//    }
//    if (Native.$bool(nmatch == 1) && !g.backrefs) {
//      break; /* no further info needed */
//    }
//    
//    /* oh my, they want the subexpressions... */
//    if (m.pmatch == ((Object/*void P*/ )NULL)) {
//      m.pmatch = ( llvm_regmatch_t /*P*/ )malloc((m.g.nsub + 1)
//             * $sizeof_Llvm_regmatch_t());
//    }
//    if (m.pmatch == ((Object/*void P*/ )NULL)) {
//      {
//        free((m).space);
//      }
//      ;
//      return (REG_ESPACE);
//    }
//    for (i = 1; $lesseq_uint(i, m.g.nsub); i++)  {
//      m.pmatch[i].rm_so = m.pmatch[i].rm_eo = -1;
//    }
//    if (!g.backrefs && !(m.eflags & REG_BACKR)) {
//      ;
//      dp = $tryClone(ldissect(m, m.coldp, endp, gf, gl));
//    } else {
//      if (Native.$bool(g.nplus > 0) && Native.$bool($eq_ptr(m.lastpos, ((Object/*void P*/ )NULL)))) {
//        m.lastpos = $tryClone(reinterpret_cast(/*const*/type$ptr<char$ptr>/*char PP*/ .class, malloc((g.nplus + 1)
//               * $sizeof_ptr(/*char$ptr */))));
//      }
//      if (Native.$bool(g.nplus > 0) && Native.$bool($eq_ptr(m.lastpos, ((Object/*void P*/ )NULL)))) {
//        free(m.pmatch);
//        {
//          free((m).space);
//        }
//        ;
//        return (REG_ESPACE);
//      }
//      ;
//      dp = $tryClone(lbackref(m, m.coldp, endp, gf, gl, (long)0, 0));
//    }
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      break;
//    }
//    
//    /* uh-oh... we couldn't find a subexpression-level match */
//    //(/*J:(void)*/(0)); /* must be back references doing it */
//    //(/*J:(void)*/(0));
//    for (;;) {
//      if (Native.$bool($noteq_ptr(dp, ((Object/*void P*/ )NULL))) || Native.$bool(endp.$lesseq(m.coldp))) {
//        break; /* defeat */
//      }
//      ;
//      endp = $tryClone(lslow(m, m.coldp, endp.$sub(1), gf, gl));
//      if ($eq_ptr(endp, ((Object/*void P*/ )NULL))) {
//        break; /* defeat */
//      }
//      ;
//      dp = $tryClone(lbackref(m, m.coldp, endp, gf, gl, (long)0, 0));
//    }
//    //(/*J:(void)*/(0));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) { /* found a shorter one */
//      break;
//    }
//    ;
//    if ($eq_ptr(m.coldp, stop)) {
//      break;
//    }
//    start = $tryClone(m.coldp.$add(1)); /* recycle starting later */
//  }
//  
//  /* fill in the details if requested */
//  if ($greater_uint(nmatch, 0)) {
//    pmatch[0].rm_so = m.coldp.$sub(m.offp);
//    pmatch[0].rm_eo = endp.$sub(m.offp);
//  }
//  if ($greater_uint(nmatch, 1)) {
//    //(/*J:(void)*/(0));
//    for (i = 1; $less_uint(i, nmatch); i++)  {
//      if ($lesseq_uint(i, m.g.nsub)) {
//        pmatch[i] = m.pmatch[i];
//      } else {
//        pmatch[i].rm_so = -1;
//        pmatch[i].rm_eo = -1;
//      }
//    }
//  }
//  if (m.pmatch != ((Object/*void P*/ )NULL)) {
//    free((char$ptr/*char P*/ )m.pmatch);
//  }
//  if ($noteq_ptr(m.lastpos, ((Object/*void P*/ )NULL))) {
//    free(reinterpret_cast(char$ptr/*char P*/ .class, m.lastpos));
//  }
//  {
//    free((m).space);
//  }
//  ;
//  return (0);
}


/*
- dissect - figure out what matched what, no back references
*/
//<editor-fold defaultstate="collapsed" desc="ldissect">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 294,
 FQN="ldissect", NM="_ZL8ldissect",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL8ldissect")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ldissect( lmat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
        long stopst) {
  NativeTrace.traceNotImplemented("ldissect");
  return null;
//  int i;
//  long ss; /* start sop of current subRE */
//  long es; /* end sop of current subRE */
//  /*const*/char$ptr/*char P*/ sp = create_char$ptr(); /* start of string matched by it */
//  /*const*/char$ptr/*char P*/ stp = create_char$ptr(); /* string matched by it cannot pass here */
//  /*const*/char$ptr/*char P*/ rest = create_char$ptr(); /* start of rest of string */
//  /*const*/char$ptr/*char P*/ tail = create_char$ptr(); /* string unmatched by rest of RE */
//  long ssub; /* start sop of subsubRE */
//  long esub; /* end sop of subsubRE */
//  /*const*/char$ptr/*char P*/ ssp = create_char$ptr(); /* start of string matched by subsubRE */
//  /*const*/char$ptr/*char P*/ sep = create_char$ptr(); /* end of string matched by subsubRE */
//  /*const*/char$ptr/*char P*/ oldssp = create_char$ptr(); /* previous ssp */
//  ;
//  sp = $tryClone(start);
//  for (ss = startst; ss < stopst; ss = es) {
//    /* identify end of subRE */
//    es = ss;
//    switch (((m.g.strip.$at(es)) & 0xF8000000L/*UL*/)) {
//     case 9L/*UL*/ << (/*uint*/int)27:
//     case 11L/*UL*/ << (/*uint*/int)27:
//      es += ((m.g.strip.$at(es)) & 0x7FFFFFFL/*UL*/);
//      break;
//     case 15L/*UL*/ << (/*uint*/int)27:
//      while (((m.g.strip.$at(es)) & 0xF8000000L/*UL*/) != O_CH) {
//        es += ((m.g.strip.$at(es)) & 0x7FFFFFFL/*UL*/);
//      }
//      break;
//    }
//    es++;
//    
//    /* figure out what it matched */
//    switch (((m.g.strip.$at(ss)) & 0xF8000000L/*UL*/)) {
//     case 1L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 2L/*UL*/ << (/*uint*/int)27:
//      sp.$postInc();
//      break;
//     case 3L/*UL*/ << (/*uint*/int)27:
//     case 4L/*UL*/ << (/*uint*/int)27:
//     case 19L/*UL*/ << (/*uint*/int)27:
//     case 20L/*UL*/ << (/*uint*/int)27:
//      break;
//     case 5L/*UL*/ << (/*uint*/int)27:
//     case 6L/*UL*/ << (/*uint*/int)27:
//      sp.$postInc();
//      break;
//     case 7L/*UL*/ << (/*uint*/int)27:
//     case 8L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 11L/*UL*/ << (/*uint*/int)27:
//      /* cases where length of match is hard to find */
//      stp = $tryClone(stop);
//      for (;;) {
//        /* how long could this one be? */
//        rest = $tryClone(lslow(m, sp, stp, ss, es));
//        //(/*J:(void)*/(0)); /* it did match */
//        /* could the rest match the rest? */
//        tail = $tryClone(lslow(m, rest, stop, es, stopst));
//        if ($eq_ptr(tail, stop)) {
//          break; /* yes! */
//        }
//        /* no -- try a shorter match for this one */
//        stp = $tryClone(rest.$sub(1));
//        //(/*J:(void)*/(0)); /* it did work */
//      }
//      ssub = ss + 1;
//      esub = es - 1;
//      /* did innards match? */
//      if ($noteq_ptr(lslow(m, sp, rest, ssub, esub), ((Object/*void P*/ )NULL))) {
//        /*const*/char$ptr/*char P*/ dp = $tryClone(ldissect(m, sp, rest, ssub, esub));
//        /*J:(void)*/dp; /* avoid warning if assertions off */
//        //(/*J:(void)*/(0));
//      } else { /* no */
//        //(/*J:(void)*/(0));
//      }
//      sp = $tryClone(rest);
//      break;
//     case 9L/*UL*/ << (/*uint*/int)27:
//      stp = $tryClone(stop);
//      for (;;) {
//        /* how long could this one be? */
//        rest = $tryClone(lslow(m, sp, stp, ss, es));
//        //(/*J:(void)*/(0)); /* it did match */
//        /* could the rest match the rest? */
//        tail = $tryClone(lslow(m, rest, stop, es, stopst));
//        if ($eq_ptr(tail, stop)) {
//          break; /* yes! */
//        }
//        /* no -- try a shorter match for this one */
//        stp = $tryClone(rest.$sub(1));
//        //(/*J:(void)*/(0)); /* it did work */
//      }
//      ssub = ss + 1;
//      esub = es - 1;
//      ssp = $tryClone(sp);
//      oldssp = $tryClone(ssp);
//      for (;;) { /* find last match of innards */
//        sep = $tryClone(lslow(m, ssp, rest, ssub, esub));
//        if (Native.$bool($eq_ptr(sep, ((Object/*void P*/ )NULL))) || Native.$bool($eq_ptr(sep, ssp))) {
//          break; /* failed or matched null */
//        }
//        oldssp = $tryClone(ssp); /* on to next try */
//        ssp = $tryClone(sep);
//      }
//      if ($eq_ptr(sep, ((Object/*void P*/ )NULL))) {
//        /* last successful match */
//        sep = $tryClone(ssp);
//        ssp = $tryClone(oldssp);
//      }
//      //(/*J:(void)*/(0)); /* must exhaust substring */
//      //(/*J:(void)*/(0));
//      {
//        /*const*/char$ptr/*char P*/ dp = $tryClone(ldissect(m, ssp, sep, ssub, esub));
//        /*J:(void)*/dp; /* avoid warning if assertions off */
//        //(/*J:(void)*/(0));
//      }
//      sp = $tryClone(rest);
//      break;
//     case 15L/*UL*/ << (/*uint*/int)27:
//      stp = $tryClone(stop);
//      for (;;) {
//        /* how long could this one be? */
//        rest = $tryClone(lslow(m, sp, stp, ss, es));
//        //(/*J:(void)*/(0)); /* it did match */
//        /* could the rest match the rest? */
//        tail = $tryClone(lslow(m, rest, stop, es, stopst));
//        if ($eq_ptr(tail, stop)) {
//          break; /* yes! */
//        }
//        /* no -- try a shorter match for this one */
//        stp = $tryClone(rest.$sub(1));
//        //(/*J:(void)*/(0)); /* it did work */
//      }
//      ssub = ss + 1;
//      esub = ss + ((m.g.strip.$at(ss)) & 0x7FFFFFFL/*UL*/) - 1;
//      //(/*J:(void)*/(0));
//      for (;;) { /* find first matching branch */
//        if ($eq_ptr(lslow(m, sp, rest, ssub, esub), rest)) {
//          break; /* it matched all of it */
//        }
//        /* that one missed, try next one */
//        //(/*J:(void)*/(0));
//        esub++;
//        //(/*J:(void)*/(0));
//        ssub = esub + 1;
//        esub += ((m.g.strip.$at(esub)) & 0x7FFFFFFL/*UL*/);
//        if (((m.g.strip.$at(esub)) & 0xF8000000L/*UL*/) == OOR2) {
//          esub--;
//        } else {
//          //(/*J:(void)*/(0));
//        }
//      }
//      {
//        /*const*/char$ptr/*char P*/ dp = $tryClone(ldissect(m, sp, rest, ssub, esub));
//        /*J:(void)*/dp; /* avoid warning if assertions off */
//        //(/*J:(void)*/(0));
//      }
//      sp = $tryClone(rest);
//      break;
//     case 10L/*UL*/ << (/*uint*/int)27:
//     case 12L/*UL*/ << (/*uint*/int)27:
//     case 16L/*UL*/ << (/*uint*/int)27:
//     case 17L/*UL*/ << (/*uint*/int)27:
//     case 18L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 13L/*UL*/ << (/*uint*/int)27:
//      i = ((m.g.strip.$at(ss)) & 0x7FFFFFFL/*UL*/);
//      //(/*J:(void)*/(0));
//      m.pmatch[i].rm_so = sp.$sub(m.offp);
//      break;
//     case 14L/*UL*/ << (/*uint*/int)27:
//      i = ((m.g.strip.$at(ss)) & 0x7FFFFFFL/*UL*/);
//      //(/*J:(void)*/(0));
//      m.pmatch[i].rm_eo = sp.$sub(m.offp);
//      break;
//     default: /* uh oh */
//      //(/*J:(void)*/(0));
//      break;
//    }
//  }
//  //(/*J:(void)*/(0));
//  return (sp);
}


/*
- backref - figure out what matched what, figuring in back references
*/
//<editor-fold defaultstate="collapsed" desc="lbackref">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 482,
 FQN="lbackref", NM="_ZL8lbackref",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL8lbackref")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ lbackref( lmat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
        long stopst, long lev, int rec) {
  NativeTrace.traceNotImplemented("lbackref");
  return null;
//  int i;
//  long ss; /* start sop of current subRE */
//  /*const*/char$ptr/*char P*/ sp = create_char$ptr(); /* start of string matched by it */
//  long ssub; /* start sop of subsubRE */
//  long esub; /* end sop of subsubRE */
//  /*const*/char$ptr/*char P*/ ssp = create_char$ptr(); /* start of string matched by subsubRE */
//  /*const*/char$ptr/*char P*/ dp = create_char$ptr();
//  /*size_t*/int len;
//  int hard;
//  /*ulong*/long s;
//  long/*off_t*/ offsave;
//   cset /*P*/ cs;
//  ;
//  sp = $tryClone(start);
//  
//  /* get as far as we can with easy stuff */
//  hard = 0;
//  for (ss = startst; !hard && Native.$bool(ss < stopst); ss++)  {
//    switch (((s = m.g.strip.$at(ss)) & 0xF8000000L/*UL*/)) {
//     case 2L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool($eq_ptr(sp, stop)) || Native.$bool(sp.$postInc().$star() != (/*char*/byte)((s) & 0x7FFFFFFL/*UL*/))) {
//        return null;
//      }
//      break;
//     case 5L/*UL*/ << (/*uint*/int)27:
//      if ($eq_ptr(sp, stop)) {
//        return null;
//      }
//      sp.$postInc();
//      break;
//     case 6L/*UL*/ << (/*uint*/int)27:
//      cs = /*AddrOf*/m.g.sets[(int)((s) & 0x7FFFFFFL/*UL*/)];
//      if (Native.$bool($eq_ptr(sp, stop)) || !($uchar2int((cs).ptr.$at((/*uchar*/byte)(sp.$postInc().$star()))) & $uchar2int((cs).mask))) {
//        return null;
//      }
//      break;
//     case 3L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool($eq_ptr(sp, m.beginp)) && !(m.eflags & REG_NOTBOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool((sp.$sub(1)).$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 4L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool($eq_ptr(sp, m.endp)) && !(m.eflags & REG_NOTEOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool(sp.$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 19L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool(Native.$bool((Native.$bool($eq_ptr(sp, m.beginp)) && !(m.eflags & REG_NOTBOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool((sp.$sub(1)).$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE)))))
//         || Native.$bool((Native.$bool(sp.$greater(m.beginp))
//         && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((sp.$sub(1)).$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool(((sp.$sub(1)).$star()) == $$UNDERSCORE))))))
//         && Native.$bool((Native.$bool(sp.$less(m.endp)) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((sp.$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((sp.$star()) == $$UNDERSCORE)))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 20L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool((Native.$bool(Native.$bool((Native.$bool($eq_ptr(sp, m.endp)) && !(m.eflags & REG_NOTEOL)))
//         || Native.$bool((Native.$bool(Native.$bool(sp.$less(m.endp)) && Native.$bool(sp.$star() == $$LF))
//         && Native.$bool((m.g.cflags & REG_NEWLINE)))))
//         || Native.$bool((Native.$bool(sp.$less(m.endp)) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((sp.$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((sp.$star()) == $$UNDERSCORE))))))
//         && Native.$bool((Native.$bool(sp.$greater(m.beginp)) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)(((sp.$sub(1)).$star() & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool(((sp.$sub(1)).$star()) == $$UNDERSCORE)))))) { /* yes */
//      } else {
//        return null;
//      }
//      break;
//     case 12L/*UL*/ << (/*uint*/int)27:
//      break;
//     case 16L/*UL*/ << (/*uint*/int)27: /* matches null but needs to skip */
//      ss++;
//      s = m.g.strip.$at(ss);
//      do {
//        //(/*J:(void)*/(0));
//        ss += ((s) & 0x7FFFFFFL/*UL*/);
//      } while (((s = m.g.strip.$at(ss)) & 0xF8000000L/*UL*/) != O_CH);
//      /* note that the ss++ gets us past the O_CH */
//      break;
//     default: /* have to make a choice */
//      hard = 1;
//      break;
//    }
//  }
//  if (!hard) { /* that was it! */
//    if ($noteq_ptr(sp, stop)) {
//      return null;
//    }
//    return (sp);
//  }
//  ss--; /* adjust for the for's final increment */
//  ;
//  s = m.g.strip.$at(ss);
//  switch (((s) & 0xF8000000L/*UL*/)) {
//   case 7L/*UL*/ << (/*uint*/int)27: /* the vilest depths */
//    i = ((s) & 0x7FFFFFFL/*UL*/);
//    //(/*J:(void)*/(0));
//    if (m.pmatch[i].rm_eo == -1) {
//      return null;
//    }
//    //(/*J:(void)*/(0));
//    len = m.pmatch[i].rm_eo - m.pmatch[i].rm_so;
//    if (Native.$bool(len == 0) && Native.$bool(rec++ > MAX_RECURSION)) {
//      return null;
//    }
//    //(/*J:(void)*/(0));
//    if (sp.$greater(stop.$sub(len))) {
//      return null; /* not enough left to match */
//    }
//    ssp = $tryClone(m.offp.$add(m.pmatch[i].rm_so));
//    if (memcmp(sp, ssp, len) != 0) {
//      return null;
//    }
//    while (m.g.strip.$at(ss) != (((8L/*UL*/ << ((/*uint*/int)27))) | (i))) {
//      ss++;
//    }
//    return (lbackref(m, sp.$add(len), stop, ss + 1, stopst, lev, rec));
//    break;
//   case 11L/*UL*/ << (/*uint*/int)27: /* to null or not */
//    dp = $tryClone(lbackref(m, sp, stop, ss + 1, stopst, lev, rec));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (dp); /* not */
//    }
//    return (lbackref(m, sp, stop, ss + ((s) & 0x7FFFFFFL/*UL*/) + 1, stopst, lev, rec));
//    break;
//   case 9L/*UL*/ << (/*uint*/int)27:
//    //(/*J:(void)*/(0));
//    //(/*J:(void)*/(0));
//    m.lastpos.$set(lev + 1, sp);
//    return (lbackref(m, sp, stop, ss + 1, stopst, lev + 1, rec));
//    break;
//   case 10L/*UL*/ << (/*uint*/int)27:
//    if ($eq_ptr(sp, m.lastpos.$at(lev))) { /* last pass matched null */
//      return (lbackref(m, sp, stop, ss + 1, stopst, lev - 1, rec));
//    }
//    /* try another pass */
//    m.lastpos.$set(lev, sp);
//    dp = $tryClone(lbackref(m, sp, stop, ss - ((s) & 0x7FFFFFFL/*UL*/) + 1, stopst, lev, rec));
//    if ($eq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (lbackref(m, sp, stop, ss + 1, stopst, lev - 1, rec));
//    } else {
//      return (dp);
//    }
//    break;
//   case 15L/*UL*/ << (/*uint*/int)27: /* find the right one, if any */
//    ssub = ss + 1;
//    esub = ss + ((s) & 0x7FFFFFFL/*UL*/) - 1;
//    //(/*J:(void)*/(0));
//    for (;;) { /* find first matching branch */
//      dp = $tryClone(lbackref(m, sp, stop, ssub, esub, lev, rec));
//      if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//        return (dp);
//      }
//      /* that one missed, try next one */
//      if (((m.g.strip.$at(esub)) & 0xF8000000L/*UL*/) == O_CH) {
//        return null; /* there is none */
//      }
//      esub++;
//      //(/*J:(void)*/(0));
//      ssub = esub + 1;
//      esub += ((m.g.strip.$at(esub)) & 0x7FFFFFFL/*UL*/);
//      if (((m.g.strip.$at(esub)) & 0xF8000000L/*UL*/) == OOR2) {
//        esub--;
//      } else {
//        //(/*J:(void)*/(0));
//      }
//    }
//    break;
//   case 13L/*UL*/ << (/*uint*/int)27: /* must undo assignment if rest fails */
//    i = ((s) & 0x7FFFFFFL/*UL*/);
//    //(/*J:(void)*/(0));
//    offsave = m.pmatch[i].rm_so;
//    m.pmatch[i].rm_so = sp.$sub(m.offp);
//    dp = $tryClone(lbackref(m, sp, stop, ss + 1, stopst, lev, rec));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (dp);
//    }
//    m.pmatch[i].rm_so = offsave;
//    return null;
//    break;
//   case 14L/*UL*/ << (/*uint*/int)27: /* must undo assignment if rest fails */
//    i = ((s) & 0x7FFFFFFL/*UL*/);
//    //(/*J:(void)*/(0));
//    offsave = m.pmatch[i].rm_eo;
//    m.pmatch[i].rm_eo = sp.$sub(m.offp);
//    dp = $tryClone(lbackref(m, sp, stop, ss + 1, stopst, lev, rec));
//    if ($noteq_ptr(dp, ((Object/*void P*/ )NULL))) {
//      return (dp);
//    }
//    m.pmatch[i].rm_eo = offsave;
//    return null;
//    break;
//   default: /* uh oh */
//    //(/*J:(void)*/(0));
//    break;
//  }
//  
//  /* "can't happen" */
//  //(/*J:(void)*/(0));
//  /* NOTREACHED */
//  return null;
}


/*
- fast - step through the string at top speed
*/
//<editor-fold defaultstate="collapsed" desc="lfast">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 682,
 FQN="lfast", NM="_ZL5lfast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5lfast")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ lfast( lmat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
     long stopst) {
  NativeTrace.traceNotImplemented("lsfast");
  return null;
//  char$ptr/*char P*/ st = $tryClone(m.st);
//  char$ptr/*char P*/ fresh = $tryClone(m.fresh);
//  char$ptr/*char P*/ tmp = $tryClone(m.tmp);
//  /*const*/char$ptr/*char P*/ p = $tryClone(start);
//  int c = ($eq_ptr(start, m.beginp)) ? OUT : (start.$sub(1)).$star();
//  int lastc; /* previous c */
//  int flagch;
//  int i;
//  /*const*/char$ptr/*char P*/ coldp = create_char$ptr(); /* last p after which no match was underway */
//  memset(st, 0, m.g.nstates);
//  ((st).$set(startst, 1));
//  st = $tryClone(lstep(m.g, startst, stopst, st, NOTHING, st));
//  memmove(fresh, st, m.g.nstates);
//  ;
//  coldp = $tryClone(null);
//  for (;;) {
//    /* next character */
//    lastc = c;
//    c = ($eq_ptr(p, m.endp)) ? OUT : p.$star();
//    if ((memcmp(st, fresh, m.g.nstates) == 0)) {
//      coldp = $tryClone(p);
//    }
//    
//    /* is there an EOL and/or BOL between lastc and c? */
//    flagch = $$TERM;
//    i = 0;
//    if (Native.$bool((Native.$bool(lastc == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(lastc == OUT) && !(m.eflags & REG_NOTBOL)))) {
//      flagch = BOL;
//      i = m.g.nbol;
//    }
//    if (Native.$bool((Native.$bool(c == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(c == OUT) && !(m.eflags & REG_NOTEOL)))) {
//      flagch = (flagch == BOL) ? BOLEOL : EOL;
//      i += m.g.neol;
//    }
//    if (i != 0) {
//      for (; i > 0; i--)  {
//        st = $tryClone(lstep(m.g, startst, stopst, st, flagch, st));
//      }
//      ;
//    }
//    
//    /* how about a word boundary? */
//    if (Native.$bool((Native.$bool(flagch == BOL) || Native.$bool((Native.$bool(lastc != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE))))))
//       && Native.$bool((Native.$bool(c != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE)))))) {
//      flagch = BOW;
//    }
//    if (Native.$bool((Native.$bool(lastc != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE)))))
//       && Native.$bool((Native.$bool(flagch == EOL) || Native.$bool((Native.$bool(c != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE))))))) {
//      flagch = EOW;
//    }
//    if (Native.$bool(flagch == BOW) || Native.$bool(flagch == EOW)) {
//      st = $tryClone(lstep(m.g, startst, stopst, st, flagch, st));
//      ;
//    }
//    
//    /* are we done? */
//    if (Native.$bool(((st).$at(stopst))) || Native.$bool($eq_ptr(p, stop))) {
//      break; /* NOTE BREAK OUT */
//    }
//    
//    /* no, we must deal with this character */
//    memmove(tmp, st, m.g.nstates);
//    memmove(st, fresh, m.g.nstates);
//    //(/*J:(void)*/(0));
//    st = $tryClone(lstep(m.g, startst, stopst, tmp, c, st));
//    ;
//    //(/*J:(void)*/(0));
//    p.$postInc();
//  }
//  //(/*J:(void)*/(0));
//  m.coldp = $tryClone(coldp);
//  if (((st).$at(stopst))) {
//    return (p.$add(1));
//  } else {
//    return null;
//  }
}


/*
- slow - step through the string more deliberately
*/
//<editor-fold defaultstate="collapsed" desc="lslow">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 767,
 FQN="lslow", NM="_ZL5lslow",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5lslow")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ lslow( lmat /*P*/ m, /*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ stop, long startst, 
     long stopst) {
  NativeTrace.traceNotImplemented("lslow");
  return null;
//  char$ptr/*char P*/ st = $tryClone(m.st);
//  char$ptr/*char P*/ empty = $tryClone(m.empty);
//  char$ptr/*char P*/ tmp = $tryClone(m.tmp);
//  /*const*/char$ptr/*char P*/ p = $tryClone(start);
//  int c = ($eq_ptr(start, m.beginp)) ? OUT : (start.$sub(1)).$star();
//  int lastc; /* previous c */
//  int flagch;
//  int i;
//  /*const*/char$ptr/*char P*/ matchp = create_char$ptr(); /* last p at which a match ended */
//  ;
//  memset(st, 0, m.g.nstates);
//  ((st).$set(startst, 1));
//  ;
//  st = $tryClone(lstep(m.g, startst, stopst, st, NOTHING, st));
//  matchp = $tryClone(null);
//  for (;;) {
//    /* next character */
//    lastc = c;
//    c = ($eq_ptr(p, m.endp)) ? OUT : p.$star();
//    
//    /* is there an EOL and/or BOL between lastc and c? */
//    flagch = $$TERM;
//    i = 0;
//    if (Native.$bool((Native.$bool(lastc == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(lastc == OUT) && !(m.eflags & REG_NOTBOL)))) {
//      flagch = BOL;
//      i = m.g.nbol;
//    }
//    if (Native.$bool((Native.$bool(c == $$LF) && Native.$bool(m.g.cflags & REG_NEWLINE)))
//       || Native.$bool((Native.$bool(c == OUT) && !(m.eflags & REG_NOTEOL)))) {
//      flagch = (flagch == BOL) ? BOLEOL : EOL;
//      i += m.g.neol;
//    }
//    if (i != 0) {
//      for (; i > 0; i--)  {
//        st = $tryClone(lstep(m.g, startst, stopst, st, flagch, st));
//      }
//      ;
//    }
//    
//    /* how about a word boundary? */
//    if (Native.$bool((Native.$bool(flagch == BOL) || Native.$bool((Native.$bool(lastc != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE))))))
//       && Native.$bool((Native.$bool(c != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE)))))) {
//      flagch = BOW;
//    }
//    if (Native.$bool((Native.$bool(lastc != OUT) && Native.$bool((Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((lastc & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((lastc) == $$UNDERSCORE)))))
//       && Native.$bool((Native.$bool(flagch == EOL) || Native.$bool((Native.$bool(c != OUT) && !(Native.$bool(($ushort2int((__ctype_b_loc().$star()).$at((int)((c & 0xFF)))) & $ushort2int((/*ushort*/char)ctype_h_Unnamed_enum._ISalnum))) || Native.$bool((c) == $$UNDERSCORE))))))) {
//      flagch = EOW;
//    }
//    if (Native.$bool(flagch == BOW) || Native.$bool(flagch == EOW)) {
//      st = $tryClone(lstep(m.g, startst, stopst, st, flagch, st));
//      ;
//    }
//    
//    /* are we done? */
//    if (((st).$at(stopst))) {
//      matchp = $tryClone(p);
//    }
//    if (Native.$bool((memcmp(st, empty, m.g.nstates) == 0)) || Native.$bool($eq_ptr(p, stop))) {
//      break; /* NOTE BREAK OUT */
//    }
//    
//    /* no, we must deal with this character */
//    memmove(tmp, st, m.g.nstates);
//    memmove(st, empty, m.g.nstates);
//    //(/*J:(void)*/(0));
//    st = $tryClone(lstep(m.g, startst, stopst, tmp, c, st));
//    ;
//    //(/*J:(void)*/(0));
//    p.$postInc();
//  }
//  
//  return (matchp);
}


/*
- step - map set of states reachable before char to set reachable after
*/
//<editor-fold defaultstate="collapsed" desc="lstep">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 848,
 FQN="lstep", NM="_ZL5lstep",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZL5lstep")
//</editor-fold>
public static char$ptr/*char P*/ lstep( re_guts /*P*/ g, 
     long start,  /* start state within strip */
     long stop,  /* state after stop state within strip */
     char$ptr/*char P*/ bef,  /* states reachable before */
     int ch,  /* character or NONCHAR code */
     char$ptr/*char P*/ aft) {
  NativeTrace.traceNotImplemented("lstep");
  return null;
//   cset /*P*/ cs;
//  /*ulong*/long s;
//  long pc;
//  long here; /* note, macros know this name */
//  long look;
//  int i;
//  
//  for (pc = start , ((here) = (pc)); pc != stop; pc++ , ((here)++)) {
//    s = g.strip.$at(pc);
//    switch (((s) & 0xF8000000L/*UL*/)) {
//     case 1L/*UL*/ << (/*uint*/int)27:
//      //(/*J:(void)*/(0));
//      break;
//     case 2L/*UL*/ << (/*uint*/int)27:
//      /* only characters can match */
//      //(/*J:(void)*/(0));
//      if (ch == (/*char*/byte)((s) & 0x7FFFFFFL/*UL*/)) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 3L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool(ch == BOL) || Native.$bool(ch == BOLEOL)) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 4L/*UL*/ << (/*uint*/int)27:
//      if (Native.$bool(ch == EOL) || Native.$bool(ch == BOLEOL)) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 19L/*UL*/ << (/*uint*/int)27:
//      if (ch == BOW) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 20L/*UL*/ << (/*uint*/int)27:
//      if (ch == EOW) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 5L/*UL*/ << (/*uint*/int)27:
//      if (!((ch) > 127)) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 6L/*UL*/ << (/*uint*/int)27:
//      cs = /*AddrOf*/g.sets[(int)((s) & 0x7FFFFFFL/*UL*/)];
//      if (!((ch) > 127) && Native.$bool(($uchar2int((cs).ptr.$at((/*uchar*/byte)(ch))) & $uchar2int((cs).mask)))) {
//        ((aft).$set$orassign(here + (1), (bef).$at(here)));
//      }
//      break;
//     case 7L/*UL*/ << (/*uint*/int)27: /* ignored here */
//     case 8L/*UL*/ << (/*uint*/int)27:
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      break;
//     case 9L/*UL*/ << (/*uint*/int)27: /* forward, this is just an empty */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      break;
//     case 10L/*UL*/ << (/*uint*/int)27: /* both forward and back */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      i = ((aft).$at(here - (((s) & 0x7FFFFFFL/*UL*/))));
//      ((aft).$set$orassign(here - (((s) & 0x7FFFFFFL/*UL*/)), (aft).$at(here)));
//      if (!i && Native.$bool(((aft).$at(here - (((s) & 0x7FFFFFFL/*UL*/)))))) {
//        /* oho, must reconsider loop body */
//        pc -= ((s) & 0x7FFFFFFL/*UL*/) + 1;
//        ((here) = (pc));
//      }
//      break;
//     case 11L/*UL*/ << (/*uint*/int)27: /* two branches, both forward */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      ((aft).$set$orassign(here + (((s) & 0x7FFFFFFL/*UL*/)), (aft).$at(here)));
//      break;
//     case 12L/*UL*/ << (/*uint*/int)27: /* just an empty */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      break;
//     case 13L/*UL*/ << (/*uint*/int)27: /* not significant here */
//     case 14L/*UL*/ << (/*uint*/int)27:
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      break;
//     case 15L/*UL*/ << (/*uint*/int)27: /* mark the first two branches */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      //(/*J:(void)*/(0));
//      ((aft).$set$orassign(here + (((s) & 0x7FFFFFFL/*UL*/)), (aft).$at(here)));
//      break;
//     case 16L/*UL*/ << (/*uint*/int)27: /* done a branch, find the O_CH */
//      if (((aft).$at(here))) {
//        for (look = 1;
//             ((s = g.strip.$at(pc + look)) & 0xF8000000L/*UL*/) != O_CH;
//             look += ((s) & 0x7FFFFFFL/*UL*/))  {
//          //(/*J:(void)*/(0));
//        }
//        ((aft).$set$orassign(here + (look), (aft).$at(here)));
//      }
//      break;
//     case 17L/*UL*/ << (/*uint*/int)27: /* propagate OCH_'s marking */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      if (((g.strip.$at(pc + ((s) & 0x7FFFFFFL/*UL*/))) & 0xF8000000L/*UL*/) != O_CH) {
//        //(/*J:(void)*/(0));
//        ((aft).$set$orassign(here + (((s) & 0x7FFFFFFL/*UL*/)), (aft).$at(here)));
//      }
//      break;
//     case 18L/*UL*/ << (/*uint*/int)27: /* just empty */
//      ((aft).$set$orassign(here + (1), (aft).$at(here)));
//      break;
//     default: /* ooooops... */
//      //(/*J:(void)*/(0));
//      break;
//    }
//  }
//  
//  return (aft);
}

} // END OF class regengineStatics
