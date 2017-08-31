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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.ConvertUTFGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ConvertUTFStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL11isLegalUTF8PKhi;_ZL13firstByteMark;_ZL15offsetsFromUTF8;_ZL20trailingBytesForUTF8;_ZL22ConvertUTF8toUTF32ImplPPKhS0_PPjS2_15ConversionFlagsh;_ZL41findMaximalSubpartOfIllFormedUTF8SequencePKhS0_;_ZL8halfBase;_ZL8halfMask;_ZL9halfShift; -static-type=ConvertUTFStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class ConvertUTFStatics {

//<editor-fold defaultstate="collapsed" desc="halfShift">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 56,
 FQN="halfShift", NM="_ZL9halfShift",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL9halfShift")
//</editor-fold>
public static final /*const*/int halfShift = 10;
/* used for shifting by 10 bits */
//<editor-fold defaultstate="collapsed" desc="halfBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 58,
 FQN="halfBase", NM="_ZL8halfBase",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL8halfBase")
//</editor-fold>
public static final /*const*/int/*UTF32*/ halfBase = 0x0010000/*UL*/;
//<editor-fold defaultstate="collapsed" desc="halfMask">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 59,
 FQN="halfMask", NM="_ZL8halfMask",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL8halfMask")
//</editor-fold>
public static final /*const*/int/*UTF32*/ halfMask = 0x3FF/*UL*/;

@Converted(kind = Converted.Kind.MANUAL_ADDED, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 61)
public static final /*UTF32*/int UNI_SUR_HIGH_START  =/*(UTF32)*/0xD800;
public static final /*UTF32*/int UNI_SUR_HIGH_END    =/*(UTF32)*/0xDBFF;
public static final /*UTF32*/int UNI_SUR_LOW_START   =/*(UTF32)*/0xDC00;
public static final /*UTF32*/int UNI_SUR_LOW_END     =/*(UTF32)*/0xDFFF;

/* --------------------------------------------------------------------- */

/*
* Index into the table below with the first byte of a UTF-8 sequence to
* get the number of trailing bytes that are supposed to follow it.
* Note that *legal* UTF-8 values can't have 4 or 5-bytes. The table is
* left as-is for anyone who may want to do such conversion, which was
* allowed in earlier algorithms.
*/
//<editor-fold defaultstate="collapsed" desc="trailingBytesForUTF8">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed to int for easier use*/,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 77,
 FQN="trailingBytesForUTF8", NM="_ZL20trailingBytesForUTF8",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL20trailingBytesForUTF8")
//</editor-fold>
public static final /*const*//*char*/int trailingBytesForUTF8[/*256*/] = new /*const*//*char*/int [/*256*/] {
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
  2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5
};

static { assert NativeTrace.registerArrayWithImmutableContent(trailingBytesForUTF8, "trailingBytesForUTF8"); }

/*
* Magic values subtracted from a buffer value during UTF8 conversion.
* This table contains as many values as there might be trailing bytes
* in a UTF-8 sequence.
*/
//<editor-fold defaultstate="collapsed" desc="offsetsFromUTF8">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 93,
 FQN="offsetsFromUTF8", NM="_ZL15offsetsFromUTF8",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL15offsetsFromUTF8")
//</editor-fold>
public static /*const*/int/*UTF32*/ offsetsFromUTF8[/*6*/] = new /*const*/int/*UTF32*/ [/*6*/] {
  0x00000000/*UL*/, 0x00003080/*UL*/, 0x000E2080/*UL*/, 
  0x03C82080/*UL*/, 0xFA082080/*UL*/, 0x82082080/*UL*/};

static { assert NativeTrace.registerArrayWithImmutableContent(offsetsFromUTF8, "offsetsFromUTF8"); }

/*
* Once the bits are split out into bytes of UTF-8, this is a mask OR-ed
* into the first byte, depending on how many bytes follow.  There are
* as many entries in this table as there are UTF-8 sequence types.
* (I.e., one byte sequence, two byte... etc.). Remember that sequencs
* for *legal* UTF-8 will be 4 or fewer bytes total.
*/
//<editor-fold defaultstate="collapsed" desc="firstByteMark">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 103,
 FQN="firstByteMark", NM="_ZL13firstByteMark",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL13firstByteMark")
//</editor-fold>
public static final /*const*/byte/*UTF8*/ firstByteMark[/*7*/] = new /*const*/byte/*UTF8*/ [/*7*/] {$int2uchar(0x00), $int2uchar(0x00), $int2uchar(0xC0), $int2uchar(0xE0), $int2uchar(0xF0), $int2uchar(0xF8), $int2uchar(0xFC)};

static { assert NativeTrace.registerArrayWithImmutableContent(firstByteMark, "firstByteMark"); }

/* --------------------------------------------------------------------- */

/*
* Utility routine to tell whether a sequence of bytes is legal UTF-8.
* This must be called with the length pre-determined by the first byte.
* If not calling this from ConvertUTF8to*, then the length can be set by:
*  length = trailingBytesForUTF8[*source]+1;
* and the sequence is illegal right away if there aren't that many bytes
* available.
* If presented with a length > 4, this returns false.  The Unicode
* definition of UTF-8 goes up to 4-byte sequences.
*/
//<editor-fold defaultstate="collapsed" desc="isLegalUTF8">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*return type int*/, 
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 355,
 FQN="isLegalUTF8", NM="_ZL11isLegalUTF8PKhi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL11isLegalUTF8PKhi")
//</editor-fold>
public static /*uchar*/int isLegalUTF8(/*const*/char$ptr/*UTF8 P*/ source, int length) {
  byte/*UTF8*/ a;
  /*const*/char$ptr/*UTF8 P*/ srcptr = source.$add(length);
  switch (length) {
   default:
    return 0;
   case 4:
    /* Everything else falls through when "true"... */
    if ($uchar2int((a = (srcptr.$preDec().$star()))) < 0x80 || $uchar2int(a) > 0xBF) {
      return 0;
    }
   case 3:
    if ($uchar2int((a = (srcptr.$preDec().$star()))) < 0x80 || $uchar2int(a) > 0xBF) {
      return 0;
    }
   case 2:
    if ($uchar2int((a = (srcptr.$preDec().$star()))) < 0x80 || $uchar2int(a) > 0xBF) {
      return 0;
    }
    switch ($uchar2int(source.$star())) {
     case 0xE0:
      /* no fall-through in this inner switch */
      if ($uchar2int(a) < 0xA0) {
        return 0;
      }
      break;
     case 0xED:
      if ($uchar2int(a) > 0x9F) {
        return 0;
      }
      break;
     case 0xF0:
      if ($uchar2int(a) < 0x90) {
        return 0;
      }
      break;
     case 0xF4:
      if ($uchar2int(a) > 0x8F) {
        return 0;
      }
      break;
     default:
      if ($uchar2int(a) < 0x80) {
        return 0;
      }
    }
   case 1:
    if ($uchar2int(source.$star()) >= 0x80 && $uchar2int(source.$star()) < 0xC2) {
      return 0;
    }
  }
  if ($uchar2int(source.$star()) > 0xF4) {
    return 0;
  }
  return 1;
}



/* --------------------------------------------------------------------- */
//<editor-fold defaultstate="collapsed" desc="findMaximalSubpartOfIllFormedUTF8Sequence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 396,
 FQN="findMaximalSubpartOfIllFormedUTF8Sequence", NM="_ZL41findMaximalSubpartOfIllFormedUTF8SequencePKhS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL41findMaximalSubpartOfIllFormedUTF8SequencePKhS0_")
//</editor-fold>
public static /*uint*/int findMaximalSubpartOfIllFormedUTF8Sequence(/*const*/char$ptr/*UTF8 P*/ source, 
                                         /*const*/char$ptr/*UTF8 P*/ sourceEnd) {
  byte/*UTF8*/ b1;
  byte/*UTF8*/ b2;
  byte/*UTF8*/ b3;
  assert (!(isLegalUTF8Sequence(source, sourceEnd) != 0));
  
  /*
  * Unicode 6.3.0, D93b:
  *
  *   Maximal subpart of an ill-formed subsequence: The longest code unit
  *   subsequence starting at an unconvertible offset that is either:
  *   a. the initial subsequence of a well-formed code unit sequence, or
  *   b. a subsequence of length one.
  */
  if ($eq_ptr(source, sourceEnd)) {
    return 0;
  }
  
  /*
  * Perform case analysis.  See Unicode 6.3.0, Table 3-7. Well-Formed UTF-8
  * Byte Sequences.
  */
  b1 = source.$star();
  source.$preInc();
  if ($uchar2int(b1) >= 0xC2 && $uchar2int(b1) <= 0xDF) {
    /*
    * First byte is valid, but we know that this code unit sequence is
    * invalid, so the maximal subpart has to end after the first byte.
    */
    return 1;
  }
  if ($eq_ptr(source, sourceEnd)) {
    return 1;
  }
  
  b2 = source.$star();
  source.$preInc();
  if ($uchar2int(b1) == 0xE0) {
    return ($uchar2int(b2) >= 0xA0 && $uchar2int(b2) <= 0xBF) ? 2 : 1;
  }
  if ($uchar2int(b1) >= 0xE1 && $uchar2int(b1) <= 0xEC) {
    return ($uchar2int(b2) >= 0x80 && $uchar2int(b2) <= 0xBF) ? 2 : 1;
  }
  if ($uchar2int(b1) == 0xED) {
    return ($uchar2int(b2) >= 0x80 && $uchar2int(b2) <= 0x9F) ? 2 : 1;
  }
  if ($uchar2int(b1) >= 0xEE && $uchar2int(b1) <= 0xEF) {
    return ($uchar2int(b2) >= 0x80 && $uchar2int(b2) <= 0xBF) ? 2 : 1;
  }
  if ($uchar2int(b1) == 0xF0) {
    if ($uchar2int(b2) >= 0x90 && $uchar2int(b2) <= 0xBF) {
      if ($eq_ptr(source, sourceEnd)) {
        return 2;
      }
      
      b3 = source.$star();
      return ($uchar2int(b3) >= 0x80 && $uchar2int(b3) <= 0xBF) ? 3 : 2;
    }
    return 1;
  }
  if ($uchar2int(b1) >= 0xF1 && $uchar2int(b1) <= 0xF3) {
    if ($uchar2int(b2) >= 0x80 && $uchar2int(b2) <= 0xBF) {
      if ($eq_ptr(source, sourceEnd)) {
        return 2;
      }
      
      b3 = source.$star();
      return ($uchar2int(b3) >= 0x80 && $uchar2int(b3) <= 0xBF) ? 3 : 2;
    }
    return 1;
  }
  if ($uchar2int(b1) == 0xF4) {
    if ($uchar2int(b2) >= 0x80 && $uchar2int(b2) <= 0x8F) {
      if ($eq_ptr(source, sourceEnd)) {
        return 2;
      }
      
      b3 = source.$star();
      return ($uchar2int(b3) >= 0x80 && $uchar2int(b3) <= 0xBF) ? 3 : 2;
    }
    return 1;
  }
  assert (($uchar2int(b1) >= 0x80 && $uchar2int(b1) <= 0xC1) || $uchar2int(b1) >= 0xF5);
  /*
  * There are no valid sequences that start with these bytes.  Maximal subpart
  * is defined to have length 1 in these cases.
  */
  return 1;
}


/* --------------------------------------------------------------------- */
//<editor-fold defaultstate="collapsed" desc="ConvertUTF8toUTF32Impl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 588,
 FQN="ConvertUTF8toUTF32Impl", NM="_ZL22ConvertUTF8toUTF32ImplPPKhS0_PPjS2_15ConversionFlagsh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ZL22ConvertUTF8toUTF32ImplPPKhS0_PPjS2_15ConversionFlagsh")
//</editor-fold>
public static ConversionResult ConvertUTF8toUTF32Impl(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ sourceStart, /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
        type$ptr<uint$ptr>/*UTF32 PP*/ targetStart, uint$ptr/*UTF32 P*/ targetEnd, ConversionFlags flags, 
        /*uchar*/boolean InputIsPartial) {
  ConversionResult result = ConversionResult.conversionOK;
  /*const*/char$ptr/*UTF8 P*/ source = $tryClone(sourceStart.$star());
  uint$ptr/*UTF32 P*/ target = $tryClone(targetStart.$star());
  while (source.$less(sourceEnd)) {
    int/*UTF32*/ ch = 0;
    /*ushort*/int extraBytesToRead = trailingBytesForUTF8[$uchar2int(source.$star())];
    if (extraBytesToRead >= sourceEnd.$sub(source)) {
      if (flags == ConversionFlags.strictConversion || InputIsPartial) {
        result = ConversionResult.sourceExhausted;
        break;
      } else {
        result = ConversionResult.sourceIllegal;
        
        /*
        * Replace the maximal subpart of ill-formed sequence with
        * replacement character.
        */
        source.$inc(findMaximalSubpartOfIllFormedUTF8Sequence(source, 
            sourceEnd));
        target.$postInc().$set(UNI_REPLACEMENT_CHAR);
        continue;
      }
    }
    if (target.$greatereq(targetEnd)) {
      result = ConversionResult.targetExhausted;
      break;
    }
    
    /* Do this check whether lenient or strict */
    if (!(isLegalUTF8(source, extraBytesToRead + 1) != 0)) {
      result = ConversionResult.sourceIllegal;
      if (flags == ConversionFlags.strictConversion) {
        /* Abort conversion. */
        break;
      } else {
        /*
        * Replace the maximal subpart of ill-formed sequence with
        * replacement character.
        */
        source.$inc(findMaximalSubpartOfIllFormedUTF8Sequence(source, 
            sourceEnd));
        target.$postInc().$set(UNI_REPLACEMENT_CHAR);
        continue;
      }
    }
    /*
    * The cases all fall through. See "Note A" below.
    */
    switch (extraBytesToRead) {
     case 5:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6;
     case 4:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6;
     case 3:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6;
     case 2:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6;
     case 1:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6;
     case 0:
      ch += $uchar2uint(source.$star());source.$preInc();
    }
    ch -= offsetsFromUTF8[extraBytesToRead];
    if ($lesseq_uint(ch, UNI_MAX_LEGAL_UTF32)) {
      /*
      * UTF-16 surrogate values are illegal in UTF-32, and anything
      * over Plane 17 (> 0x10FFFF) is illegal.
      */
      if ($greatereq_uint(ch, UNI_SUR_HIGH_START) && $lesseq_uint(ch, UNI_SUR_LOW_END)) {
        if (flags == ConversionFlags.strictConversion) {
          source.$dec((extraBytesToRead + 1)); /* return to the illegal value itself */
          result = ConversionResult.sourceIllegal;
          break;
        } else {
          target.$set(UNI_REPLACEMENT_CHAR);target.$preInc();
        }
      } else {
        target.$set(ch);target.$preInc();
      }
    } else { /* i.e., ch > UNI_MAX_LEGAL_UTF32 */
      result = ConversionResult.sourceIllegal;
      target.$set(UNI_REPLACEMENT_CHAR);target.$preInc();
    }
  }
  // Clone here due to simple $set
  sourceStart.$set($tryClone(source));
  targetStart.$set($tryClone(target));
  return result;
}

} // END OF class ConvertUTFStatics
