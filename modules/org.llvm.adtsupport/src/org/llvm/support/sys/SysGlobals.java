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
package org.llvm.support.sys;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type SysGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.sys.SysGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp ${LLVM_SRC}/llvm/lib/Support/Memory.cpp ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp ${LLVM_SRC}/llvm/lib/Support/Path.cpp ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp ${LLVM_SRC}/llvm/lib/Support/Timer.cpp ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=Tpl__ZN4llvm3sys13swapByteOrderERT_;_ZN4llvm3sys11MemoryFenceEv;_ZN4llvm3sys13ExecuteNoWaitENS_9StringRefEPPKcS4_PPKS1_jPNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEPb;_ZN4llvm3sys14CompareAndSwapEPVjjj;_ZN4llvm3sys14ExecuteAndWaitENS_9StringRefEPPKcS4_PPKS1_jjPNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEPb;_ZN4llvm3sys14getHostCPUNameEv;_ZN4llvm3sys15PrintStackTraceERNS_11raw_ostreamE;_ZN4llvm3sys15getSwappedBytesEa;_ZN4llvm3sys15getSwappedBytesEc;_ZN4llvm3sys15getSwappedBytesEd;_ZN4llvm3sys15getSwappedBytesEf;_ZN4llvm3sys15getSwappedBytesEh;_ZN4llvm3sys15getSwappedBytesEi;_ZN4llvm3sys15getSwappedBytesEj;_ZN4llvm3sys15getSwappedBytesEl;_ZN4llvm3sys15getSwappedBytesEm;_ZN4llvm3sys15getSwappedBytesEs;_ZN4llvm3sys15getSwappedBytesEt;_ZN4llvm3sys15getSwappedBytesEx;_ZN4llvm3sys15getSwappedBytesEy;_ZN4llvm3sys16AddSignalHandlerEPFvPvES1_;_ZN4llvm3sys16SwapByteOrder_16Et;_ZN4llvm3sys16SwapByteOrder_32Ej;_ZN4llvm3sys16SwapByteOrder_64Ey;_ZN4llvm3sys16getProcessTripleB5cxx11Ev;_ZN4llvm3sys17RunSignalHandlersEv;_ZN4llvm3sys17RunningOnValgrindEv;_ZN4llvm3sys17findProgramByNameB5cxx11ENS_9StringRefENS_8ArrayRefIS1_EE;_ZN4llvm3sys18RemoveFileOnSignalENS_9StringRefEPNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE;_ZN4llvm3sys19ChangeStdinToBinaryEv;_ZN4llvm3sys20ChangeStdoutToBinaryEv;_ZN4llvm3sys20RunInterruptHandlersEv;_ZN4llvm3sys20SetInterruptFunctionEPFvvE;_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE;_ZN4llvm3sys22DontRemoveFileOnSignalENS_9StringRefE;_ZN4llvm3sys22getDefaultTargetTripleB5cxx11Ev;_ZN4llvm3sys27DisableSystemDialogsOnCrashEv;_ZN4llvm3sys27ValgrindDiscardTranslationsEPKvj;_ZN4llvm3sys28PrintStackTraceOnErrorSignalENS_9StringRefEb;_ZN4llvm3sys33commandLineFitsWithinSystemLimitsENS_9StringRefENS_8ArrayRefIPKcEE;_ZN4llvm3sys4WaitERKNS0_11ProcessInfoEjbPNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvm3sys8StrErrorB5cxx11Ei;_ZN4llvm3sys8StrErrorB5cxx11Ev;_ZN4llvm3sysL15IsBigEndianHostE;_ZN4llvm3sysL16EnvPathSeparatorE;_ZN4llvm3sysL18IsLittleEndianHostE;_ZN4llvm3sysltENS0_16UnicodeCharRangeEj;_ZN4llvm3sysltEjNS0_16UnicodeCharRangeE;_ZN4llvm3sysmiERKNS0_9TimeValueES3_;_ZN4llvm3sysplERKNS0_9TimeValueES3_; -static-type=SysGlobals -package=org.llvm.support.sys")
//</editor-fold>
public final class SysGlobals {


/// SwapByteOrder_16 - This function returns a byte-swapped representation of
/// the 16-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_16">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 27,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 28,
 FQN="llvm::sys::SwapByteOrder_16", NM="_ZN4llvm3sys16SwapByteOrder_16Et",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys16SwapByteOrder_16Et")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char SwapByteOrder_16(/*uint16_t*/char value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    SwapByteOrder_16(value);
}


/// SwapByteOrder_32 - This function returns a byte-swapped representation of
/// the 32-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_32">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 41,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 42,
 FQN="llvm::sys::SwapByteOrder_32", NM="_ZN4llvm3sys16SwapByteOrder_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys16SwapByteOrder_32Ej")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int SwapByteOrder_32(/*uint32_t*/int value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    SwapByteOrder_32(value);
}


/// SwapByteOrder_64 - This function returns a byte-swapped representation of
/// the 64-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_64">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 57,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 58,
 FQN="llvm::sys::SwapByteOrder_64", NM="_ZN4llvm3sys16SwapByteOrder_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys16SwapByteOrder_64Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ SwapByteOrder_64(long/*uint64_t*/ value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    SwapByteOrder_64(value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 69,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 70,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEh")
//</editor-fold>
public static /*inline*/ /*uchar*/byte getSwappedBytes_uchar(/*uchar*/byte C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_uchar(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 70,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 71,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEa",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEa")
//</editor-fold>
public static /*inline*/ /*schar*/byte getSwappedBytes_schar(/*schar*/byte C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_schar(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 71,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 72,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEc")
//</editor-fold>
public static /*inline*/ /*char*/byte getSwappedBytes_char(/*char*/byte C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_char(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 73,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 74,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEt")
//</editor-fold>
public static /*inline*/ /*ushort*/char getSwappedBytes_ushort(/*ushort*/char C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_ushort(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 74,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 75,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEs")
//</editor-fold>
public static /*inline*/ short getSwappedBytes_short(short C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_short(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 76,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 77,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEj")
//</editor-fold>
public static /*inline*/ /*uint*/int getSwappedBytes_uint(/*uint*/int C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_uint(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 77,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 78,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEi")
//</editor-fold>
public static /*inline*/ int getSwappedBytes_int(int C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_int(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 80,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 81,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEm")
//</editor-fold>
public static /*inline*/ /*ulong*/long getSwappedBytes_ulong(/*ulong*/long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_ulong(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 81,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 82,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEl")
//</editor-fold>
public static /*inline*/ long getSwappedBytes_long(long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_long(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 89,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 90,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEy")
//</editor-fold>
public static /*inline*/ /*ullong*/long getSwappedBytes_ullong(/*ullong*/long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_ullong(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 92,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 93,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEx")
//</editor-fold>
public static /*inline*/ /*llong*/long getSwappedBytes_llong(/*llong*/long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_llong(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 96,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 97,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEf")
//</editor-fold>
public static /*inline*/ float getSwappedBytes(float C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 106,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 107,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sys15getSwappedBytesEd")
//</editor-fold>
public static /*inline*/ double getSwappedBytes(double C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes(C);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::sys::swapByteOrder">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 117,
 FQN="llvm::sys::swapByteOrder", NM="Tpl__ZN4llvm3sys13swapByteOrderERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=Tpl__ZN4llvm3sys13swapByteOrderERT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> void swapByteOrder(final T /*&*/ Value) {
  /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    swapByteOrder(Value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::IsBigEndianHost">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 35,
 FQN="llvm::sys::IsBigEndianHost", NM="_ZN4llvm3sysL15IsBigEndianHostE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sysL15IsBigEndianHostE")
//</editor-fold>
public static /*const*/boolean IsBigEndianHost = false;
//<editor-fold defaultstate="collapsed" desc="llvm::sys::IsLittleEndianHost">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 38,
 FQN="llvm::sys::IsLittleEndianHost", NM="_ZN4llvm3sysL18IsLittleEndianHostE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm3sysL18IsLittleEndianHostE")
//</editor-fold>
public static /*const*/boolean IsLittleEndianHost = !IsBigEndianHost;

/// Adds two TimeValue objects together.
/// @returns The sum of the two operands as a new TimeValue
/// @brief Addition operator.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator+">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 371,
 FQN="llvm::sys::operator+", NM="_ZN4llvm3sysplERKNS0_9TimeValueES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sysplERKNS0_9TimeValueES3_")
//</editor-fold>
public static /*inline*/ TimeValue $add_TimeValue$C(final /*const*/ TimeValue /*&*/ tv1, final /*const*/ TimeValue /*&*/ tv2) {
  return /*delegate*/org.llvm.support.sys.impl.TimeValueSysGlobals.
    $add_TimeValue$C(tv1, tv2);
}


/// Subtracts two TimeValue objects.
/// @returns The difference of the two operands as a new TimeValue
/// @brief Subtraction operator.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator-">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 377,
 FQN="llvm::sys::operator-", NM="_ZN4llvm3sysmiERKNS0_9TimeValueES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sysmiERKNS0_9TimeValueES3_")
//</editor-fold>
public static /*inline*/ TimeValue $sub_TimeValue$C(final /*const*/ TimeValue /*&*/ tv1, final /*const*/ TimeValue /*&*/ tv2) {
  return /*delegate*/org.llvm.support.sys.impl.TimeValueSysGlobals.
    $sub_TimeValue$C(tv1, tv2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::EnvPathSeparator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", line = 29,
 FQN="llvm::sys::EnvPathSeparator", NM="_ZN4llvm3sysL16EnvPathSeparatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm3sysL16EnvPathSeparatorE")
//</editor-fold>
public static /*const*//*char*/byte EnvPathSeparator = $$COLON;

/// getDefaultTargetTriple() - Return the default target triple the compiler
/// has been configured to produce code for.
///
/// The target triple is a string in the format of:
///   CPU_TYPE-VENDOR-OPERATING_SYSTEM
/// or
///   CPU_TYPE-VENDOR-KERNEL-OPERATING_SYSTEM
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getDefaultTargetTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 47,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Host.inc", old_line = 37,
 FQN="llvm::sys::getDefaultTargetTriple", NM="_ZN4llvm3sys22getDefaultTargetTripleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys22getDefaultTargetTripleEv")
//</editor-fold>
public static std.string getDefaultTargetTriple() {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}


/// getProcessTriple() - Return an appropriate target triple for generating
/// code to be loaded into the current process, e.g. when using the JIT.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getProcessTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 51,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 919,
 FQN="llvm::sys::getProcessTriple", NM="_ZN4llvm3sys16getProcessTripleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys16getProcessTripleEv")
//</editor-fold>
public static std.string getProcessTriple() {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}


/// getHostCPUName - Get the LLVM name for the host CPU. The particular format
/// of the name is target dependent, and suitable for passing as -mcpu to the
/// target which matches the host.
///
/// \return - The host CPU name, or empty if the CPU could not be determined.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 58,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 215,
 FQN="llvm::sys::getHostCPUName", NM="_ZN4llvm3sys14getHostCPUNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys14getHostCPUNameEv")
//</editor-fold>
public static StringRef getHostCPUName() {
  return /*delegate*/org.llvm.support.sys.impl.HostSysGlobals.
    getHostCPUName();
}


/// getHostCPUFeatures - Get the LLVM names for the host CPU features.
/// The particular format of the names are target dependent, and suitable for
/// passing as -mattr to the target which matches the host.
///
/// \param Features - A string mapping feature names to either
/// true (if enabled) or false (if disabled). This routine makes no guarantees
/// about exactly which features may appear in this map, except that they are
/// all valid LLVM feature names.
///
/// \return - True on success.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUFeatures">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 70,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 744,
 FQN="llvm::sys::getHostCPUFeatures", NM="_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE")
//</editor-fold>
public static boolean getHostCPUFeatures(final StringMapBool/*&*/ Features) {
  return /*delegate*/org.llvm.support.sys.impl.HostSysGlobals.
    getHostCPUFeatures(Features);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 32,
 FQN="llvm::sys::operator<", NM="_ZN4llvm3sysltEjNS0_16UnicodeCharRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sysltEjNS0_16UnicodeCharRangeE")
//</editor-fold>
public static /*inline*/ boolean $less_uint_UnicodeCharRange(/*uint32_t*/int Value, UnicodeCharRange Range) {
  return /*delegate*/org.llvm.support.sys.impl.UnicodeCharRangesSysGlobals.
    $less_uint_UnicodeCharRange(Value, Range);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 35,
 FQN="llvm::sys::operator<", NM="_ZN4llvm3sysltENS0_16UnicodeCharRangeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sysltENS0_16UnicodeCharRangeEj")
//</editor-fold>
public static /*inline*/ boolean $less_UnicodeCharRange_uint(UnicodeCharRange Range, /*uint32_t*/int Value) {
  return /*delegate*/org.llvm.support.sys.impl.UnicodeCharRangesSysGlobals.
    $less_UnicodeCharRange_uint(Range, Value);
}

} // END OF class SysGlobals
