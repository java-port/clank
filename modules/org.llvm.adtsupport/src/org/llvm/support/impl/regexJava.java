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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;

/**
 * Collection of declarations not found in commands.
 * @author Vladimir Voskresensky
 */
public final class regexJava {

  private regexJava() { }

/* llvm_regcomp() flags */
public static final int	REG_BASIC     =	0000;
public static final int	REG_EXTENDED  = 0001;
public static final int	REG_ICASE     = 0002;
public static final int	REG_NOSUB     = 0004;
public static final int	REG_NEWLINE   = 0010;
public static final int	REG_NOSPEC    = 0020;
public static final int	REG_PEND      = 0040;
public static final int	REG_DUMP      = 0200;

/* llvm_regerror() flags */
public static final int	REG_NOMATCH	 = 1;
public static final int	REG_BADPAT	 = 2;
public static final int	REG_ECOLLATE = 3;
public static final int	REG_ECTYPE	 = 4;
public static final int	REG_EESCAPE	 = 5;
public static final int	REG_ESUBREG	 = 6;
public static final int	REG_EBRACK	 = 7;
public static final int	REG_EPAREN	 = 8;
public static final int	REG_EBRACE	 = 9;
public static final int	REG_BADBR    = 10;
public static final int	REG_ERANGE   = 11;
public static final int	REG_ESPACE	 = 12;
public static final int	REG_BADRPT	 = 13;
public static final int	REG_EMPTY	   = 14;
public static final int	REG_ASSERT	 = 15;
public static final int	REG_INVARG	 = 16;
public static final int	REG_ATOI     = 255;	/* convert name to number (!) */
public static final int	REG_ITOA     = 0400;	/* convert number to name (!) */

/* llvm_regexec() flags */
public static final int	REG_NOTBOL    = 00001;
public static final int	REG_NOTEOL    = 00002;
public static final int	REG_STARTEND	= 00004;
public static final int	REG_TRACE     = 00400;	/* tracing of execution */
public static final int	REG_LARGE     = 01000;	/* force large representation */
public static final int	REG_BACKR     = 02000;	/* force use of backref code */

/*
 * internals of regex_t
 */
public static final int	MAGIC1 = ((('r'^0200)<<8) | 'e');
public static final int	MAGIC2 = ((('R'^0200)<<8) | 'E');

public static final int	USEBOL    = 01;	/* used ^ */
public static final int	USEEOL    = 02;	/* used $ */
public static final int	REGEX_BAD = 04;	/* something wrong */

//<editor-fold defaultstate="collapsed" desc="<anonymous>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/regex_impl.h", line = 43,
 FQN = "(anonymous)", NM = "_llvm_regmatch_t",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_llvm_regmatch_t")
//</editor-fold>
public static class/*struct*/ llvm_regmatch_t implements NativePOD<llvm_regmatch_t> {
  public long/*off_t*/ rm_so; /* start of match */
  public long/*off_t*/ rm_eo; /* end of match */
  //<editor-fold defaultstate="collapsed" desc="<anonymous struct>::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/regex_impl.h", line = 43,
   FQN = "llvm_regmatch_t", NM = "_Z15llvm_regmatch_t",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -filter=__anonymous_struct::operator=",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public /*inline*/ llvm_regmatch_t /*&*/ $assign(/*const*/llvm_regmatch_t /*&*/ $Prm0)/* throw()*/ {
    this.rm_so = $Prm0.rm_so;
    this.rm_eo = $Prm0.rm_eo;
    return this;
  }

  @Override
  public llvm_regmatch_t clone() {
    return new llvm_regmatch_t().$assign(this);
  }
  
  @Override public String toString() {
    return "" + "rm_so=" + rm_so // NOI18N
              + ", rm_eo=" + rm_eo; // NOI18N
  }  
}

/*typedef struct llvm_regmatch_t llvm_regmatch_t*/
//public final class llvm_regmatch_t extends  llvm_regmatch_t{ };
//<editor-fold defaultstate="collapsed" desc="llvm_regex">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/regex_impl.h", line = 48,
 FQN = "llvm_regex", NM = "_Z10llvm_regex",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_Z10llvm_regex")
//</editor-fold>
public static class/*struct*/ llvm_regex {
  public int re_magic;
  public /*size_t*/int re_nsub; /* number of parenthesized subexpressions */
  public /*const*/char$ptr/*char P*/ re_endp; /* end pointer for REG_PEND */
  public  re_guts /*P*/ re_g; /* none of your business :-) */
  
  @Override public String toString() {
    return "" + "re_magic=" + re_magic // NOI18N
              + ", re_nsub=" + re_nsub // NOI18N
              + ", re_endp=" + re_endp // NOI18N
              + ", re_g=" + re_g; // NOI18N
  }  
}

//#define	NC		(CHAR_MAX - CHAR_MIN + 1)
//typedef unsigned char uch;

/*
 * Structure for [] character-set representation.  Character sets are
 * done as bit vectors, grouped 8 to a byte vector for compactness.
 * The individual set therefore has both a pointer to the byte vector
 * and a mask to pick out the relevant bit of each byte.  A hash code
 * simplifies testing whether two sets could be identical.
 *
 * This will get trickier for multicharacter collating elements.  As
 * preliminary hooks for dealing with such things, we also carry along
 * a string of multi-character elements, and decide the size of the
 * vectors at run time.
 */
//<editor-fold defaultstate="collapsed" desc="re_guts">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regex2.h", line = 108,
 FQN="cset",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -filter=cset")
//</editor-fold>
public static final class/*struct*/ cset {
	/*uchar*/uchar$ptr ptr;		/* -> uch [csetsize] */
	/*uchar*/byte mask;		/* bit within array */
	/*uchar*/byte hash;		/* hash code */
	/*size_t*/int smultis;
	/*char*/char$ptr multis;		/* -> char[smulti]  ab\0cd\0ef\0\0 */  
}

public static void CHadd(cset cs, byte c) {
  cs.ptr.$set$orassign($uchar2uint(c), cs.mask);
  cs.hash += c;
}      

public static void CHsub(cset cs, byte c) {
  cs.ptr.$set$andassign($uchar2uint(c), (byte)((~cs.mask)&0xff));
  cs.hash -= c;
}      

public static boolean CHIN(cset cs, byte c) {
  return (cs.ptr.$at($uchar2uint(c)) & cs.mask) != 0;
}      

/* stuff for character categories */
//typedef unsigned char cat_t;
/* strip operator */
/*typedef long sopno*/;
public static final long OPRMASK =	0xf8000000L/*U*/;
public static final long OPDMASK = 0x07ffffffL/*U*/;
public static final long OPSHIFT = /*unsigned*/27;
//public static final long OP(n)	((n)&OPRMASK)
//public static final long OPND(n)	((n)&OPDMASK)
//public static final long SOP(op, opnd)	((op)|(opnd))
/* operators			   meaning	operand			*/
/*						(back, fwd are offsets)	*/
public static final long OEND	= (1L/*U*/<<OPSHIFT);	/* endmarker	-			*/
public static final long OCHAR =	(2L/*U*/<<OPSHIFT);	/* character	unsigned char		*/
public static final long OBOL	= (3L/*U*/<<OPSHIFT);	/* left anchor	-			*/
public static final long OEOL	 = (4L/*U*/<<OPSHIFT);	/* right anchor	-			*/
public static final long OANY	 = (5L/*U*/<<OPSHIFT);	/* .		-			*/
public static final long OANYOF	= (6L/*U*/<<OPSHIFT);	/* [...]	set number		*/
public static final long OBACK_	= (7L/*U*/<<OPSHIFT);	/* begin \d	paren number		*/
public static final long O_BACK	= (8L/*U*/<<OPSHIFT);	/* end \d	paren number		*/
public static final long OPLUS_	= (9L/*U*/<<OPSHIFT);	/* + prefix	fwd to suffix		*/
public static final long O_PLUS	= (10L/*U*/<<OPSHIFT);	/* + suffix	back to prefix		*/
public static final long OQUEST_ = (11L/*U*/<<OPSHIFT);	/* ? prefix	fwd to suffix		*/
public static final long O_QUEST = (12L/*U*/<<OPSHIFT);	/* ? suffix	back to prefix		*/
public static final long OLPAREN = (13L/*U*/<<OPSHIFT);	/* (		fwd to )		*/
public static final long ORPAREN = (14L/*U*/<<OPSHIFT);	/* )		back to (		*/
public static final long OCH_	= (15L/*U*/<<OPSHIFT);	/* begin choice	fwd to OOR2		*/
public static final long OOR1	= (16L/*U*/<<OPSHIFT);	/* | pt. 1	back to OOR1 or OCH_	*/
public static final long OOR2	= (17L/*U*/<<OPSHIFT);	/* | pt. 2	fwd to OOR2 or O_CH	*/
public static final long O_CH	= (18L/*U*/<<OPSHIFT);	/* end choice	back to OOR1		*/
public static final long OBOW	= (19L/*U*/<<OPSHIFT);	/* begin word	-			*/
public static final long OEOW	= (20L/*U*/<<OPSHIFT);	/* end word	-			*/

public static final int CHAR_MAX = INT8_MAX;
public static final int CHAR_MIN = INT8_MIN;
public static final int NC = (CHAR_MAX - CHAR_MIN + 1);

public static final int NPAREN = 10;	/* we need to remember () 1-9 for back refs */

/* misc utilities */
public static final int OUT =	(CHAR_MAX+1);	/* a non-character value */
public static boolean ISWORD(int c) {
  return (isalnum(c&0xff) != 0) || (c == '_');
}

public static final int DUPMAX = 255;
public static final int INFINITY = (DUPMAX + 1);

public static final char$ptr nuls; /* place to point scanner in event of error */
static {
  byte[] $arr = new$char(10);
  nuls = create_const_char$ptr($arr);
  NativeTrace.registerArrayWithImmutableContent($arr, "regex.nuls");
}		

/*
* parse structure, passed up and down to avoid global variables and
* other clumsinesses
*/
//<editor-fold defaultstate="collapsed" desc="parse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 64,
 FQN="parse", NM="_Z5parse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_Z5parse")
//</editor-fold>
public static final class/*struct*/ parse {
  public char$ptr/*char P*/ next; /* next character in RE */
  public char$ptr/*char P*/ end; /* end of string (-> NUL normally) */
  public int error; /* has an error been seen? */
  public /*ulong*/ulong$ptr/*P*/ strip; /* malloced strip */
  public long ssize; /* malloced strip size (allocated) */
  public long slen; /* malloced strip length (used) */
  public int ncsalloc; /* number of csets allocated */
  public  re_guts /*P*/ g;
  /* we need to remember () 1-9 for back refs */
  public /*sopno*/long pbegin[/*NPAREN*/] = new long [NPAREN]; /* -> ( ([0] unused) */
  public /*sopno*/long pend[/*NPAREN*/] = new long [NPAREN]; /* -> ) ([0] unused) */
  //<editor-fold defaultstate="collapsed" desc="parse::parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/regcomp.c", line = 64,
   FQN="parse::parse", NM="_ZN5parseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZN5parseC1Ev")
  //</editor-fold>
  public /*inline*/ parse() {
  }

  
  @Override public String toString() {
    return "" + "next=" + next // NOI18N
              + ", end=" + end // NOI18N
              + ", error=" + error // NOI18N
              + ", strip=" + strip // NOI18N
              + ", ssize=" + ssize // NOI18N
              + ", slen=" + slen // NOI18N
              + ", ncsalloc=" + ncsalloc // NOI18N
              + ", g=" + g // NOI18N
              + ", pbegin=" + pbegin // NOI18N
              + ", pend=" + pend; // NOI18N
  }
}

/*
* main compiled-expression structure
*/
//<editor-fold defaultstate="collapsed" desc="re_guts">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regex2.h", line = 129,
 FQN="re_guts", NM="_Z7re_guts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_Z7re_guts")
//</editor-fold>
public static final class/*struct*/ re_guts {
  public int magic;
  public /*ulong*/ulong$ptr/*P*/ strip; /* malloced area for strip */
  public int csetsize; /* number of bits in a cset vector */
  public int ncsets; /* number of csets in use */
  public type$ptr<cset /*P*/> sets; /* -> cset [ncsets] */
  public char$ptr/*uchar P*/ setbits; /* -> uch[csetsize][ncsets/CHAR_BIT] */
  public int cflags; /* copy of llvm_regcomp() cflags argument */
  public long nstates; /* = number of sops */
  public long firststate; /* the initial OEND (normally 0) */
  public long laststate; /* the final OEND */
  public int iflags; /* internal flags */
  /* something wrong */
  public int nbol; /* number of ^ used */
  public int neol; /* number of $ used */
  public int ncategories; /* how many character categories */
  public char$ptr/*uchar P*/ categories; /* ->catspace[-CHAR_MIN] */
  public char$ptr/*char P*/ must; /* match must contain this string */
  public int mlen; /* length of must */
  public /*size_t*/int nsub; /* copy of re_nsub */
  public int backrefs; /* does it use back references? */
  public long nplus; /* how deep does it nest +s? */
  /* catspace must be last */
  public /*uchar*/byte catspace[/*NC*/] = new /*uchar*/byte [NC]; /* actually [NC] */
  
  @Override public String toString() {
    return "" + "magic=" + magic // NOI18N
              + ", strip=" + strip // NOI18N
              + ", csetsize=" + csetsize // NOI18N
              + ", ncsets=" + ncsets // NOI18N
              + ", sets=" + sets // NOI18N
              + ", setbits=" + setbits // NOI18N
              + ", cflags=" + cflags // NOI18N
              + ", nstates=" + nstates // NOI18N
              + ", firststate=" + firststate // NOI18N
              + ", laststate=" + laststate // NOI18N
              + ", iflags=" + iflags // NOI18N
              + ", nbol=" + nbol // NOI18N
              + ", neol=" + neol // NOI18N
              + ", ncategories=" + ncategories // NOI18N
              + ", categories=" + categories // NOI18N
              + ", must=" + must // NOI18N
              + ", mlen=" + mlen // NOI18N
              + ", nsub=" + nsub // NOI18N
              + ", backrefs=" + backrefs // NOI18N
              + ", nplus=" + nplus // NOI18N
              + ", catspace=" + catspace; // NOI18N
  }
}  

/* another structure passed up and down to avoid zillions of parameters */
//<editor-fold defaultstate="collapsed" desc="lmat">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 71,
 FQN="lmat", NM="_Z4lmat",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_Z4lmat")
//</editor-fold>
public class/*struct*/ lmat {
  public  re_guts /*P*/ g;
  public int eflags;
  public  llvm_regmatch_t /*P*/ pmatch; /* [nsub+1] (0 element unused) */
  public /*const*/char$ptr/*char P*/ offp; /* offsets work from here */
  public /*const*/char$ptr/*char P*/ beginp; /* start of string -- virtual NUL precedes */
  public /*const*/char$ptr/*char P*/ endp; /* end of string -- virtual NUL here */
  public /*const*/char$ptr/*char P*/ coldp; /* can be no match starting before here */
  public /*const*/type$ptr<char$ptr>/*char PP*/ lastpos; /* [nplus+1] */
  public long vn;
  public char$ptr/*char P*/ space;
  public char$ptr/*char P*/ st; /* current states */
  public char$ptr/*char P*/ fresh; /* states for a fresh start */
  public char$ptr/*char P*/ tmp; /* temporary */
  public char$ptr/*char P*/ empty; /* empty set of states */
  //<editor-fold defaultstate="collapsed" desc="lmat::lmat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 71,
   FQN="lmat::lmat", NM="_ZN4lmatC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZN4lmatC1Ev")
  //</editor-fold>
  public /*inline*/ lmat() {
  }

  
  @Override public String toString() {
    return "" + "g=" + g // NOI18N
              + ", eflags=" + eflags // NOI18N
              + ", pmatch=" + pmatch // NOI18N
              + ", offp=" + offp // NOI18N
              + ", beginp=" + beginp // NOI18N
              + ", endp=" + endp // NOI18N
              + ", coldp=" + coldp // NOI18N
              + ", lastpos=" + lastpos // NOI18N
              + ", vn=" + vn // NOI18N
              + ", space=" + space // NOI18N
              + ", st=" + st // NOI18N
              + ", fresh=" + fresh // NOI18N
              + ", tmp=" + tmp // NOI18N
              + ", empty=" + empty; // NOI18N
  }
}

/* another structure passed up and down to avoid zillions of parameters */
//<editor-fold defaultstate="collapsed" desc="smat">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 71,
 FQN="smat", NM="_Z4smat",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_Z4smat")
//</editor-fold>
public class/*struct*/ smat {
  public  re_guts /*P*/ g;
  public int eflags;
  public  llvm_regmatch_t /*P*/ pmatch; /* [nsub+1] (0 element unused) */
  public /*const*/char$ptr/*char P*/ offp; /* offsets work from here */
  public /*const*/char$ptr/*char P*/ beginp; /* start of string -- virtual NUL precedes */
  public /*const*/char$ptr/*char P*/ endp; /* end of string -- virtual NUL here */
  public /*const*/char$ptr/*char P*/ coldp; /* can be no match starting before here */
  public /*const*/type$ptr<char$ptr>/*char PP*/ lastpos; /* [nplus+1] */
  public long dummy;
  public long st; /* current states */
  public long fresh; /* states for a fresh start */
  public long tmp; /* temporary */
  public long empty; /* empty set of states */
  //<editor-fold defaultstate="collapsed" desc="smat::smat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/regengine.inc", line = 71,
   FQN="smat::smat", NM="_ZN4smatC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regexec.c -nm=_ZN4smatC1Ev")
  //</editor-fold>
  public /*inline*/ smat() {
  }

  
  @Override public String toString() {
    return "" + "g=" + g // NOI18N
              + ", eflags=" + eflags // NOI18N
              + ", pmatch=" + pmatch // NOI18N
              + ", offp=" + offp // NOI18N
              + ", beginp=" + beginp // NOI18N
              + ", endp=" + endp // NOI18N
              + ", coldp=" + coldp // NOI18N
              + ", lastpos=" + lastpos // NOI18N
              + ", dummy=" + dummy // NOI18N
              + ", st=" + st // NOI18N
              + ", fresh=" + fresh // NOI18N
              + ", tmp=" + tmp // NOI18N
              + ", empty=" + empty; // NOI18N
  }
}

// JAVA: std.swap for llvm_regex
public static void swap_llvm_regex(llvm_regex one, llvm_regex other) {
  int re_magic = one.re_magic;
  one.re_magic = other.re_magic;
  other.re_magic = re_magic;
  
  int re_nsub = one.re_nsub;
  one.re_nsub = other.re_nsub;
  other.re_nsub = re_nsub;

  /*const*/char$ptr/*char P*/ re_endp = one.re_endp;
  one.re_endp = other.re_endp;
  other.re_endp = re_endp;
  
  /*const*/re_guts/*char P*/ re_g = one.re_g;
  one.re_g = other.re_g;
  other.re_g = re_g;
}
}
