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
package org.llvm.support;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.impl.ConvertUTFStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ConvertUTFGlobals">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ConversionFlags;_ConversionResult;_Z17isLegalUTF8String;_Z18ConvertUTF16toUTF8;_Z18ConvertUTF32toUTF8;_Z18ConvertUTF8toUTF16;_Z18ConvertUTF8toUTF32;_Z18getNumBytesForUTF8;_Z19ConvertUTF16toUTF32;_Z19ConvertUTF32toUTF16;_Z19isLegalUTF8Sequence;_Z25ConvertUTF8toUTF32Partial; -static-type=ConvertUTFGlobals -package=org.llvm.support")
//</editor-fold>
public final class ConvertUTFGlobals {
/* Some fundamental constants */
@Converted(kind = Converted.Kind.MANUAL_ADDED, source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", line = 107)
public static final /*UTF32*/int UNI_REPLACEMENT_CHAR = /*(UTF32)*/0x0000FFFD;
public static final /*UTF32*/int UNI_MAX_BMP = /*(UTF32)*/0x0000FFFF;
public static final /*UTF32*/int UNI_MAX_UTF16 = /*(UTF32)*/0x0010FFFF;
public static final /*UTF32*/int UNI_MAX_UTF32 = /*(UTF32)*/0x7FFFFFFF;
public static final /*UTF32*/int UNI_MAX_LEGAL_UTF32 = /*(UTF32)*/0x0010FFFF;

public static final /*uint*/int UNI_MAX_UTF8_BYTES_PER_CODE_POINT = 4;

public static final /*uint*/int UNI_UTF16_BYTE_ORDER_MARK_NATIVE = 0xFEFF;
public static final /*uint*/int UNI_UTF16_BYTE_ORDER_MARK_SWAPPED = 0xFFFE;

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", line = 118,
 FQN="(anonymous)", NM="_ConversionResult",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ConversionResult")
//</editor-fold>
public enum ConversionResult implements Native.ComparableLower {
  conversionOK(0), /* conversion successful */
  sourceExhausted(conversionOK.getValue() + 1), /* partial character in source, but hit end */
  targetExhausted(sourceExhausted.getValue() + 1), /* insuff. room in target for conversion */
  sourceIllegal(targetExhausted.getValue() + 1)/* source sequence is illegal/malformed */;

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ConversionResult valueOf(int val) {
    ConversionResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ConversionResult[] VALUES;
    private static final ConversionResult[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ConversionResult kind : ConversionResult.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ConversionResult[min < 0 ? (1-min) : 0];
      VALUES = new ConversionResult[max >= 0 ? (1+max) : 0];
      for (ConversionResult kind : ConversionResult.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ConversionResult(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConversionResult)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConversionResult)obj).value);}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", line = 125,
 FQN="(anonymous)", NM="_ConversionFlags",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_ConversionFlags")
//</editor-fold>
public enum ConversionFlags implements Native.ComparableLower {
  strictConversion(0),
  lenientConversion(strictConversion.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ConversionFlags valueOf(int val) {
    ConversionFlags out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ConversionFlags[] VALUES;
    private static final ConversionFlags[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ConversionFlags kind : ConversionFlags.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ConversionFlags[min < 0 ? (1-min) : 0];
      VALUES = new ConversionFlags[max >= 0 ? (1+max) : 0];
      for (ConversionFlags kind : ConversionFlags.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ConversionFlags(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConversionFlags)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConversionFlags)obj).value);}
  //</editor-fold>
}  

/* --------------------------------------------------------------------- */
//<editor-fold defaultstate="collapsed" desc="ConvertUTF8toUTF16">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 515,
 FQN="ConvertUTF8toUTF16", NM="_Z18ConvertUTF8toUTF16",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z18ConvertUTF8toUTF16")
//</editor-fold>
public static ConversionResult ConvertUTF8toUTF16(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ sourceStart, /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
        type$ptr<ushort$ptr>/*UTF16 PP*/ targetStart, ushort$ptr/*UTF16 P*/ targetEnd, ConversionFlags flags) {
  ConversionResult result = ConversionResult.conversionOK;
  /*const*/char$ptr/*UTF8 P*/ source = $tryClone(sourceStart.$star());
  ushort$ptr/*UTF16 P*/ target = $tryClone(targetStart.$star());
  while (source.$less(sourceEnd)) {
    int/*UTF32*/ ch = 0;
    // JAVA: changed to int to simplify calculations
    /*ushort*/int extraBytesToRead = trailingBytesForUTF8[$uchar2int(source.$star())];
    if (extraBytesToRead >= sourceEnd.$sub(source)) {
      result = ConversionResult.sourceExhausted;
      break;
    }
    /* Do this check whether lenient or strict */
    if (!(isLegalUTF8(source, extraBytesToRead + 1) != 0)) {
      result = ConversionResult.sourceIllegal;
      break;
    }
    /*
    * The cases all fall through. See "Note A" below.
    */
    switch (extraBytesToRead) {
     case 5:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6; /* remember, illegal UTF-8 */
     case 4:
      ch += $uchar2uint(source.$star());source.$preInc();
      ch <<= 6; /* remember, illegal UTF-8 */
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
    if (target.$greatereq(targetEnd)) {
      source.$dec((extraBytesToRead + 1)); /* Back up source pointer! */
      result = ConversionResult.targetExhausted;
      break;
    }
    if ($lesseq_uint(ch, UNI_MAX_BMP)) { /* Target is a character <= 0xFFFF */
/* UTF-16 surrogate values are illegal in UTF-32 */
      if ($greatereq_uint(ch, UNI_SUR_HIGH_START) && $lesseq_uint(ch, UNI_SUR_LOW_END)) {
        if (flags == ConversionFlags.strictConversion) {
          source.$dec((extraBytesToRead + 1)); /* return to the illegal value itself */
          result = ConversionResult.sourceIllegal;
          break;
        } else {
          target.$set($uint2ushort(UNI_REPLACEMENT_CHAR));target.$preInc();
        }
      } else {
        target.$set((char/*UTF16*/)$uint2ushort(ch));target.$preInc(); /* normal case */
      }
    } else if ($greater_uint(ch, UNI_MAX_UTF16)) {
      if (flags == ConversionFlags.strictConversion) {
        result = ConversionResult.sourceIllegal;
        source.$dec((extraBytesToRead + 1)); /* return to the start */
        break; /* Bail out; shouldn't continue */
      } else {
        target.$set($uint2ushort(UNI_REPLACEMENT_CHAR));target.$preInc();
      }
    } else {
      /* target is a character in range 0xFFFF - 0x10FFFF. */
      if (target.$add(1).$greatereq(targetEnd)) {
        source.$dec((extraBytesToRead + 1)); /* Back up source pointer! */
        result = ConversionResult.targetExhausted;
        break;
      }
      ch -= halfBase;
      target.$set((char/*UTF16*/)$uint2ushort(((ch >>> halfShift) + UNI_SUR_HIGH_START)));target.$preInc();
      target.$set((char/*UTF16*/)$uint2ushort(((ch & halfMask) + UNI_SUR_LOW_START)));target.$preInc();
    }
  }
  // Clone here due to simple $set
  sourceStart.$set($tryClone(source));
  targetStart.$set($tryClone(target));
  return result;
}


/**
* Convert a partial UTF8 sequence to UTF32.  If the sequence ends in an
* incomplete code unit sequence, returns \c sourceExhausted.
*/
//<editor-fold defaultstate="collapsed" desc="ConvertUTF8toUTF32Partial">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 675,
 FQN="ConvertUTF8toUTF32Partial", NM="_Z25ConvertUTF8toUTF32Partial",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z25ConvertUTF8toUTF32Partial")
//</editor-fold>
public static ConversionResult ConvertUTF8toUTF32Partial(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ sourceStart, 
                         /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
                         type$ptr<uint$ptr>/*UTF32 PP*/ targetStart, 
                         uint$ptr/*UTF32 P*/ targetEnd, 
                         ConversionFlags flags) {
  return ConvertUTF8toUTF32Impl(sourceStart, sourceEnd, targetStart, targetEnd, 
      flags, /*InputIsPartial=*/ true);
}


/**
* Convert a partial UTF8 sequence to UTF32.  If the sequence ends in an
* incomplete code unit sequence, returns \c sourceIllegal.
*/
//<editor-fold defaultstate="collapsed" desc="ConvertUTF8toUTF32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 684,
 FQN="ConvertUTF8toUTF32", NM="_Z18ConvertUTF8toUTF32",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z18ConvertUTF8toUTF32")
//</editor-fold>
public static ConversionResult ConvertUTF8toUTF32(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ sourceStart, 
                  /*const*/char$ptr/*UTF8 P*/ sourceEnd, type$ptr<uint$ptr>/*UTF32 PP*/ targetStart, 
                  uint$ptr/*UTF32 P*/ targetEnd, ConversionFlags flags) {
  return ConvertUTF8toUTF32Impl(sourceStart, sourceEnd, targetStart, targetEnd, 
      flags, /*InputIsPartial=*/ false);
}

//<editor-fold defaultstate="collapsed" desc="ConvertUTF16toUTF8">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 221,
 FQN="ConvertUTF16toUTF8", NM="_Z18ConvertUTF16toUTF8",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z18ConvertUTF16toUTF8")
//</editor-fold>
public static ConversionResult ConvertUTF16toUTF8(/*const*/type$ptr<ushort$ptr>/*UTF16 PP*/ sourceStart, /*const*/ushort$ptr/*UTF16 P*/ sourceEnd, 
        type$ptr<char$ptr>/*UTF8 P P*/ targetStart, char$ptr/*UTF8 P*/ targetEnd, ConversionFlags flags) {
  ConversionResult result = ConversionResult.conversionOK;
  /*const*/ushort$ptr/*UTF16 P*/ source = $tryClone(sourceStart.$star());
  char$ptr/*UTF8 P*/ target = $tryClone(targetStart.$star());
  while (source.$less(sourceEnd)) {
    int/*UTF32*/ ch;
    /*ushort*/int bytesToWrite = 0;
    /*const*/int/*UTF32*/ byteMask = 0xBF;
    /*const*/int/*UTF32*/ byteMark = 0x80;
    /*const*/ushort$ptr/*UTF16 P*/ oldSource = $tryClone(source); /* In case we have to back up because of target overflow. */
    ch = $ushort2uint(source.$star());source.$preInc();
    /* If we have a surrogate pair, convert to UTF32 first. */
    if ($greatereq_uint(ch, UNI_SUR_HIGH_START) && $lesseq_uint(ch, UNI_SUR_HIGH_END)) {
      /* If the 16 bits following the high surrogate are in the source buffer... */
      if (source.$less(sourceEnd)) {
        int/*UTF32*/ ch2 = $ushort2uint(source.$star());
        /* If it's a low surrogate, convert to UTF32. */
        if ($greatereq_uint(ch2, UNI_SUR_LOW_START) && $lesseq_uint(ch2, UNI_SUR_LOW_END)) {
          ch = ((ch - UNI_SUR_HIGH_START) << halfShift)
             + (ch2 - UNI_SUR_LOW_START) + halfBase;
          source.$preInc();
        } else if (flags == ConversionFlags.strictConversion) { /* it's an unpaired high surrogate */
          source.$preDec(); /* return to the illegal value itself */
          result = ConversionResult.sourceIllegal;
          break;
        }
      } else { /* We don't have the 16 bits following the high surrogate. */
        source.$preDec(); /* return to the high surrogate */
        result = ConversionResult.sourceExhausted;
        break;
      }
    } else if (flags == ConversionFlags.strictConversion) {
      /* UTF-16 surrogate values are illegal in UTF-32 */
      if ($greatereq_uint(ch, UNI_SUR_LOW_START) && $lesseq_uint(ch, UNI_SUR_LOW_END)) {
        source.$preDec(); /* return to the illegal value itself */
        result = ConversionResult.sourceIllegal;
        break;
      }
    }
    /* Figure out how many bytes the result will require */
    if ($less_uint(ch, (int/*UTF32*/)0x80)) {
      bytesToWrite = 1;
    } else if ($less_uint(ch, (int/*UTF32*/)0x800)) {
      bytesToWrite = 2;
    } else if ($less_uint(ch, (int/*UTF32*/)0x10000)) {
      bytesToWrite = 3;
    } else if ($less_uint(ch, (int/*UTF32*/)0x110000)) {
      bytesToWrite = 4;
    } else {
      bytesToWrite = 3;
      ch = UNI_REPLACEMENT_CHAR;
    }
    
    target.$inc(bytesToWrite);
    if (target.$greater(targetEnd)) {
      source = $tryClone(oldSource); /* Back up source pointer! */
      target.$dec(bytesToWrite);
      result = ConversionResult.targetExhausted;
      break;
    }
    switch (bytesToWrite) { /* note: everything falls through. */
     case 4:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar(((ch | byteMark) & byteMask)));
      ch >>>= 6;
     case 3:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar(((ch | byteMark) & byteMask)));
      ch >>>= 6;
     case 2:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar(((ch | byteMark) & byteMask)));
      ch >>>= 6;
     case 1:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar((ch | $uchar2uint(firstByteMark[bytesToWrite]))));
    }
    target.$inc(bytesToWrite);
  }
  // Clone here due to simple $set
  sourceStart.$set($tryClone(source));
  targetStart.$set($tryClone(target));
  return result;
}


/* --------------------------------------------------------------------- */
//<editor-fold defaultstate="collapsed" desc="ConvertUTF32toUTF8">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 291,
 FQN="ConvertUTF32toUTF8", NM="_Z18ConvertUTF32toUTF8",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z18ConvertUTF32toUTF8")
//</editor-fold>
public static ConversionResult ConvertUTF32toUTF8(/*const*/type$ptr<uint$ptr>/*UTF32 PP*/ sourceStart, /*const*/uint$ptr/*UTF32 P*/ sourceEnd, 
        type$ptr<char$ptr>/*UTF8 P P*/ targetStart, char$ptr/*UTF8 P*/ targetEnd, ConversionFlags flags) {
  ConversionResult result = ConversionResult.conversionOK;
  /*const*/uint$ptr/*UTF32 P*/ source = $tryClone(sourceStart.$star());
  char$ptr/*UTF8 P*/ target = $tryClone(targetStart.$star());
  while (source.$less(sourceEnd)) {
    int/*UTF32*/ ch;
    /*ushort*/int bytesToWrite = 0;
    /*const*/int/*UTF32*/ byteMask = 0xBF;
    /*const*/int/*UTF32*/ byteMark = 0x80;
    ch = source.$star();source.$preInc();
    if (flags == ConversionFlags.strictConversion) {
      /* UTF-16 surrogate values are illegal in UTF-32 */
      if ($greatereq_uint(ch, UNI_SUR_HIGH_START) && $lesseq_uint(ch, UNI_SUR_LOW_END)) {
        source.$preDec(); /* return to the illegal value itself */
        result = ConversionResult.sourceIllegal;
        break;
      }
    }
    /*
    * Figure out how many bytes the result will require. Turn any
    * illegally large UTF32 things (> Plane 17) into replacement chars.
    */
    if ($less_uint(ch, (int/*UTF32*/)0x80)) {
      bytesToWrite = 1;
    } else if ($less_uint(ch, (int/*UTF32*/)0x800)) {
      bytesToWrite = 2;
    } else if ($less_uint(ch, (int/*UTF32*/)0x10000)) {
      bytesToWrite = 3;
    } else if ($lesseq_uint(ch, UNI_MAX_LEGAL_UTF32)) {
      bytesToWrite = 4;
    } else {
      bytesToWrite = 3;
      ch = UNI_REPLACEMENT_CHAR;
      result = ConversionResult.sourceIllegal;
    }
    
    target.$inc(bytesToWrite);
    if (target.$greater(targetEnd)) {
      source.$preDec(); /* Back up source pointer! */
      target.$dec(bytesToWrite);
      result = ConversionResult.targetExhausted;
      break;
    }
    switch (bytesToWrite) { /* note: everything falls through. */
     case 4:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar((ch | byteMark) & byteMask));
      ch >>>= 6;
     case 3:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar((ch | byteMark) & byteMask));
      ch >>>= 6;
     case 2:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar((ch | byteMark) & byteMask));
      ch >>>= 6;
     case 1:
      target.$preDec().$set((byte/*UTF8*/)$uint2uchar(ch | $uchar2uint(firstByteMark[bytesToWrite])));
    }
    target.$inc(bytesToWrite);
  }
  // Clone here due to simple $set
  sourceStart.$set($tryClone(source));
  targetStart.$set($tryClone(target));
  return result;
}


/* --------------------------------------------------------------------- */
//<editor-fold defaultstate="collapsed" desc="ConvertUTF16toUTF32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 167,
 FQN="ConvertUTF16toUTF32", NM="_Z19ConvertUTF16toUTF32",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z19ConvertUTF16toUTF32")
//</editor-fold>
public static ConversionResult ConvertUTF16toUTF32(/*const*/type$ptr<ushort$ptr>/*UTF16 PP*/ sourceStart, /*const*/ushort$ptr/*UTF16 P*/ sourceEnd, 
        type$ptr<uint$ptr>/*UTF32 PP*/ targetStart, uint$ptr/*UTF32 P*/ targetEnd, ConversionFlags flags) {
  ConversionResult result = ConversionResult.conversionOK;
  /*const*/ushort$ptr/*UTF16 P*/ source = $tryClone(sourceStart.$star());
  uint$ptr/*UTF32 P*/ target = $tryClone(targetStart.$star());
  int/*UTF32*/ ch;
  int/*UTF32*/ ch2;
  while (source.$less(sourceEnd)) {
    /*const*/ushort$ptr/*UTF16 P*/ oldSource = $tryClone(source); /*  In case we have to back up because of target overflow. */
    ch = $ushort2uint(source.$star());source.$preInc();
    /* If we have a surrogate pair, convert to UTF32 first. */
    if ($greatereq_uint(ch, UNI_SUR_HIGH_START) && $lesseq_uint(ch, UNI_SUR_HIGH_END)) {
      /* If the 16 bits following the high surrogate are in the source buffer... */
      if (source.$less(sourceEnd)) {
        ch2 = $ushort2uint(source.$star());
        /* If it's a low surrogate, convert to UTF32. */
        if ($greatereq_uint(ch2, UNI_SUR_LOW_START) && $lesseq_uint(ch2, UNI_SUR_LOW_END)) {
          ch = ((ch - UNI_SUR_HIGH_START) << halfShift)
             + (ch2 - UNI_SUR_LOW_START) + halfBase;
          source.$preInc();
        } else if (flags == ConversionFlags.strictConversion) { /* it's an unpaired high surrogate */
          source.$preDec(); /* return to the illegal value itself */
          result = ConversionResult.sourceIllegal;
          break;
        }
      } else { /* We don't have the 16 bits following the high surrogate. */
        source.$preDec(); /* return to the high surrogate */
        result = ConversionResult.sourceExhausted;
        break;
      }
    } else if (flags == ConversionFlags.strictConversion) {
      /* UTF-16 surrogate values are illegal in UTF-32 */
      if ($greatereq_uint(ch, UNI_SUR_LOW_START) && $lesseq_uint(ch, UNI_SUR_LOW_END)) {
        source.$preDec(); /* return to the illegal value itself */
        result = ConversionResult.sourceIllegal;
        break;
      }
    }
    if (target.$greatereq(targetEnd)) {
      source = $tryClone(oldSource); /* Back up source pointer! */
      result = ConversionResult.targetExhausted;
      break;
    }
    target.$set(ch);target.$preInc();
  }
  // Clone here due to simple $set
  sourceStart.$set($tryClone(source));
  targetStart.$set($tryClone(target));
  return result;
}


/* --------------------------------------------------------------------- */

/* The interface converts a whole buffer to avoid function-call overhead.
* Constants have been gathered. Loops & conditionals have been removed as
* much as possible for efficiency, in favor of drop-through switches.
* (See "Note A" at the bottom of the file for equivalent code.)
* If your compiler supports it, the "isLegalUTF8" call can be turned
* into an inline function.
*/

/* --------------------------------------------------------------------- */
//<editor-fold defaultstate="collapsed" desc="ConvertUTF32toUTF16">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 118,
 FQN="ConvertUTF32toUTF16", NM="_Z19ConvertUTF32toUTF16",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z19ConvertUTF32toUTF16")
//</editor-fold>
public static ConversionResult ConvertUTF32toUTF16(/*const*/type$ptr<uint$ptr>/*UTF32 PP*/ sourceStart, /*const*/uint$ptr/*UTF32 P*/ sourceEnd, 
        type$ptr<ushort$ptr>/*UTF16 PP*/ targetStart, ushort$ptr/*UTF16 P*/ targetEnd, ConversionFlags flags) {
  ConversionResult result = ConversionResult.conversionOK;
  /*const*/uint$ptr/*UTF32 P*/ source = $tryClone(sourceStart.$star());
  ushort$ptr/*UTF16 P*/ target = $tryClone(targetStart.$star());
  while (source.$less(sourceEnd)) {
    int/*UTF32*/ ch;
    if (target.$greatereq(targetEnd)) {
      result = ConversionResult.targetExhausted;
      break;
    }
    ch = source.$star();source.$preInc();
    if ($lesseq_uint(ch, UNI_MAX_BMP)) { /* Target is a character <= 0xFFFF */
/* UTF-16 surrogate values are illegal in UTF-32; 0xffff or 0xfffe are both reserved values */
      if ($greatereq_uint(ch, UNI_SUR_HIGH_START) && $lesseq_uint(ch, UNI_SUR_LOW_END)) {
        if (flags == ConversionFlags.strictConversion) {
          source.$preDec(); /* return to the illegal value itself */
          result = ConversionResult.sourceIllegal;
          break;
        } else {
          target.$set($uint2ushort(UNI_REPLACEMENT_CHAR));target.$preInc();
        }
      } else {
        target.$set((char/*UTF16*/)$uint2ushort(ch));target.$preInc(); /* normal case */
      }
    } else if ($greater_uint(ch, UNI_MAX_LEGAL_UTF32)) {
      if (flags == ConversionFlags.strictConversion) {
        result = ConversionResult.sourceIllegal;
      } else {
        target.$set($uint2ushort(UNI_REPLACEMENT_CHAR));target.$preInc();
      }
    } else {
      /* target is a character in range 0xFFFF - 0x10FFFF. */
      if (target.$add(1).$greatereq(targetEnd)) {
        source.$preDec(); /* Back up source pointer! */
        result = ConversionResult.targetExhausted;
        break;
      }
      ch -= halfBase;
      target.$set((char/*UTF16*/)$uint2ushort(((ch >>> halfShift) + UNI_SUR_HIGH_START)));target.$preInc();
      target.$set((char/*UTF16*/)$uint2ushort(((ch & halfMask) + UNI_SUR_LOW_START)));target.$preInc();
    }
  }
  // Clone here due to simple $set
  sourceStart.$set($tryClone(source));
  targetStart.$set($tryClone(target));
  return result;
}


/* --------------------------------------------------------------------- */

/*
* Exported function to return whether a UTF-8 sequence is legal or not.
* This is not used here; it's just exported.
*/
//<editor-fold defaultstate="collapsed" desc="isLegalUTF8Sequence">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*return type int*/,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 386,
 FQN="isLegalUTF8Sequence", NM="_Z19isLegalUTF8Sequence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z19isLegalUTF8Sequence")
//</editor-fold>
public static /*uchar*/int isLegalUTF8Sequence(/*const*/char$ptr/*UTF8 P*/ source, /*const*/char$ptr/*UTF8 P*/ sourceEnd) {
  int length = trailingBytesForUTF8[$uchar2int(source.$star())] + 1;
  if (length > sourceEnd.$sub(source)) {
    return 0;
  }
  return isLegalUTF8(source, length);
}


/* --------------------------------------------------------------------- */

/*
* Exported function to return whether a UTF-8 string is legal or not.
* This is not used here; it's just exported.
*/
//<editor-fold defaultstate="collapsed" desc="isLegalUTF8String">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*return type int*/,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 503,
 FQN="isLegalUTF8String", NM="_Z17isLegalUTF8String",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z17isLegalUTF8String")
//</editor-fold>
public static /*uchar*/int isLegalUTF8String(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ source, /*const*/char$ptr/*UTF8 P*/ sourceEnd) {
  while (source.$star().$noteq(sourceEnd)) {
    int length = trailingBytesForUTF8[$uchar2int(source.$star().$star())] + 1;
    if (length > sourceEnd.$sub(source.$star()) || !(isLegalUTF8(source.$star(), length) != 0)) {
      return 0;
    }
    source.$star().$inc(length);
  }
  return 1;
}


/* --------------------------------------------------------------------- */

/*
* Exported function to return the total number of bytes in a codepoint
* represented in UTF-8, given the value of the first byte.
*/
//<editor-fold defaultstate="collapsed" desc="getNumBytesForUTF8">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c", line = 493,
 FQN="getNumBytesForUTF8", NM="_Z18getNumBytesForUTF8",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTF.c -nm=_Z18getNumBytesForUTF8")
//</editor-fold>
public static /*uint*/int getNumBytesForUTF8(byte/*UTF8*/ first) {
  return trailingBytesForUTF8[$uchar2int(first)] + 1;
}

} // END OF class ConvertUTFGlobals
