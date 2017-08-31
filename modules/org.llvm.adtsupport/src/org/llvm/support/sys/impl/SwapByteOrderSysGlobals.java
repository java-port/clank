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
package org.llvm.support.sys.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type SwapByteOrderSysGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.sys.impl.SwapByteOrderSysGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=Tpl__ZN4llvm3sys13swapByteOrderERT_;_ZN4llvm3sys15getSwappedBytesEa;_ZN4llvm3sys15getSwappedBytesEc;_ZN4llvm3sys15getSwappedBytesEd;_ZN4llvm3sys15getSwappedBytesEf;_ZN4llvm3sys15getSwappedBytesEh;_ZN4llvm3sys15getSwappedBytesEi;_ZN4llvm3sys15getSwappedBytesEj;_ZN4llvm3sys15getSwappedBytesEl;_ZN4llvm3sys15getSwappedBytesEm;_ZN4llvm3sys15getSwappedBytesEs;_ZN4llvm3sys15getSwappedBytesEt;_ZN4llvm3sys15getSwappedBytesEx;_ZN4llvm3sys15getSwappedBytesEy;_ZN4llvm3sys16SwapByteOrder_16Et;_ZN4llvm3sys16SwapByteOrder_32Ej;_ZN4llvm3sys16SwapByteOrder_64Ey; -static-type=SwapByteOrderSysGlobals -package=org.llvm.support.sys.impl")
//</editor-fold>
public final class SwapByteOrderSysGlobals {


/// SwapByteOrder_16 - This function returns a byte-swapped representation of
/// the 16-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_16">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 27,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 28,
 FQN="llvm::sys::SwapByteOrder_16", NM="_ZN4llvm3sys16SwapByteOrder_16Et",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys16SwapByteOrder_16Et")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char SwapByteOrder_16(/*uint16_t*/char value) {
  /*uint16_t*/char Hi = /*$int2ushort*/(char)($ushort2uint(value) << 8);
  /*uint16_t*/char Lo = /*$int2ushort*/(char)($ushort2uint(value) >>> 8);
  return $uint2ushort($ushort2uint(Hi) | $ushort2uint(Lo));
}


/// SwapByteOrder_32 - This function returns a byte-swapped representation of
/// the 32-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 41,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 42,
 FQN="llvm::sys::SwapByteOrder_32", NM="_ZN4llvm3sys16SwapByteOrder_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys16SwapByteOrder_32Ej")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int SwapByteOrder_32(/*uint32_t*/int value) {
  int Byte0 = value & 0x000000FF;
  int Byte1 = value & 0x0000FF00;
  int Byte2 = value & 0x00FF0000;
  int Byte3 = value & 0xFF000000;
  return (Byte0 << 24) | (Byte1 << 8) | (Byte2 >> 8) | (Byte3 >> 24);
}


/// SwapByteOrder_64 - This function returns a byte-swapped representation of
/// the 64-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 57,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 58,
 FQN="llvm::sys::SwapByteOrder_64", NM="_ZN4llvm3sys16SwapByteOrder_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys16SwapByteOrder_64Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ SwapByteOrder_64(long/*uint64_t*/ value) {
  long Hi = SwapByteOrder_32((int)(value & 0xFFFFFFFF));
  long Lo = SwapByteOrder_32((int)(value >> 32));
  return (Hi << 32) | Lo;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 69,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 70,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEh")
//</editor-fold>
public static /*inline*/ /*uchar*/byte getSwappedBytes_uchar(/*uchar*/byte C) {
  return C;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 70,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 71,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEa",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEa")
//</editor-fold>
public static /*inline*/ /*schar*/byte getSwappedBytes_schar(/*schar*/byte C) {
  return C;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 71,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 72,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEc")
//</editor-fold>
public static /*inline*/ /*char*/byte getSwappedBytes_char(/*char*/byte C) {
  return C;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 73,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 74,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEt")
//</editor-fold>
public static /*inline*/ /*ushort*/char getSwappedBytes_ushort(/*ushort*/char C) {
  return SwapByteOrder_16(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 74,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 75,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEs")
//</editor-fold>
public static /*inline*/ short getSwappedBytes_short(short C) {
  return $ushort2short(SwapByteOrder_16($short2ushort(C)));
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 76,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 77,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEj")
//</editor-fold>
public static /*inline*/ /*uint*/int getSwappedBytes_uint(/*uint*/int C) {
  return SwapByteOrder_32(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 77,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 78,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEi")
//</editor-fold>
public static /*inline*/ int getSwappedBytes_int(int C) {
  return SwapByteOrder_32(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 80,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 81,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEm")
//</editor-fold>
public static /*inline*/ /*ulong*/long getSwappedBytes_ulong(/*ulong*/long C) {
  return SwapByteOrder_32((int)C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 81,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 82,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEl")
//</editor-fold>
public static /*inline*/ long getSwappedBytes_long(long C) {
  return SwapByteOrder_32((int)C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 89,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 90,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEy")
//</editor-fold>
public static /*inline*/ /*ullong*/long getSwappedBytes_ullong(/*ullong*/long C) {
  return SwapByteOrder_64(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 92,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 93,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEx")
//</editor-fold>
public static /*inline*/ /*llong*/long getSwappedBytes_llong(/*llong*/long C) {
  return SwapByteOrder_64(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 96,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 97,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEf")
//</editor-fold>
public static /*inline*/ float getSwappedBytes(float C) {
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 97,
   FQN="", NM="_ZN4llvm3sys15getSwappedBytesEf_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEf_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public /*uint32_t*/int i;
    public float f;
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes(float)::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 97,
     FQN="llvm::sys::getSwappedBytes(float)::(anonymous union)::", NM="_ZZN4llvm3sys15getSwappedBytesEfENUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZZN4llvm3sys15getSwappedBytesEfENUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "i=" + i // NOI18N
                + ", f=" + f; // NOI18N
    }
  }Unnamed_union in/*J*/= new Unnamed_union();
  Unnamed_union out/*J*/= new Unnamed_union();
  in.f = C;
  out.i = SwapByteOrder_32(in.i);
  return out.f;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 106,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 107,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEd")
//</editor-fold>
public static /*inline*/ double getSwappedBytes(double C) {
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 107,
   FQN="", NM="_ZN4llvm3sys15getSwappedBytesEd_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN4llvm3sys15getSwappedBytesEd_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public long/*uint64_t*/ i;
    public double d;
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes(double)::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 107,
     FQN="llvm::sys::getSwappedBytes(double)::(anonymous union)::", NM="_ZZN4llvm3sys15getSwappedBytesEdENUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZZN4llvm3sys15getSwappedBytesEdENUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "i=" + i // NOI18N
                + ", d=" + d; // NOI18N
    }
  }Unnamed_union in/*J*/= new Unnamed_union();
  Unnamed_union out/*J*/= new Unnamed_union();
  in.d = C;
  out.i = SwapByteOrder_64(in.i);
  return out.d;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::sys::swapByteOrder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 117,
 FQN="llvm::sys::swapByteOrder", NM="Tpl__ZN4llvm3sys13swapByteOrderERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=Tpl__ZN4llvm3sys13swapByteOrderERT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T/*JAVA added return type*/ swapByteOrder(T /*&*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class SwapByteOrderSysGlobals
