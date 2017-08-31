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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import org.clank.java.spawn.posix_spawn_file_actions_t;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.sys.*;
import org.llvm.mc.MCFixup;
import static org.llvm.support.unix.impl.UnixStatics.MakeErrMsg;


//<editor-fold defaultstate="collapsed" desc="static type AdtsupportLlvmStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.AdtsupportLlvmStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp ${LLVM_SRC}/llvm/lib/Support/Debug.cpp ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp ${LLVM_SRC}/llvm/lib/Support/Program.cpp ${LLVM_SRC}/llvm/lib/Support/SearchForAddressOfSpecialSymbol.cpp ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=Tpl__ZN4llvmL25ConvertUTF8toWideInternalENS_9StringRefERT_;_MCSymbolELF_cpp_Unnamed_enum;_ZN4llvm17ReverseStackTraceEPNS_21PrettyStackTraceEntryE;_ZN4llvm18PrintRecyclerStatsEjjj;_ZN4llvm18createELFAsmParserEv;_ZN4llvm19createCOFFAsmParserEv;_ZN4llvm21createDarwinAsmParserEv;_ZN4llvm31SearchForAddressOfSpecialSymbolEPKc;_ZN4llvmL10RedirectIOEPKNS_9StringRefEiPNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvmL11maxExponentE;_ZN4llvmL12maxPrecisionE;_ZN4llvmL13RedirectIO_PSEPKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEiPS5_P26posix_spawn_file_actions_t;_ZN4llvmL14CallBacksToRunE;_ZN4llvmL14TimeOutHandlerEi;_ZN4llvmL15SetMemoryLimitsEj;_ZN4llvmL16CurrentDebugTypeB5cxx11E;_ZN4llvmL19maxPowerOfFivePartsE;_ZN4llvmL22maxPowerOfFiveExponentE;_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCFixupE; -static-type=AdtsupportLlvmStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class AdtsupportLlvmStatics {


/* A tight upper bound on number of parts required to hold the value
pow(5, power) is

power * 815 / (351 * integerPartWidth) + 1

However, whilst the result may require only this many parts,
because we are multiplying two values to get it, the
multiplication may require an extra part with the excess part
being zero (consider the trivial case of 1 * 1, tcFullMultiply
requires two parts to hold the single-part result).  So we add an
extra one to guarantee enough space whilst multiplying.  */
//<editor-fold defaultstate="collapsed" desc="llvm::maxExponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 92,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 91,
 FQN="llvm::maxExponent", NM="_ZN4llvmL11maxExponentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL11maxExponentE")
//</editor-fold>
public static /*const*//*uint*/int maxExponent = 16383;
//<editor-fold defaultstate="collapsed" desc="llvm::maxPrecision">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 93,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 92,
 FQN="llvm::maxPrecision", NM="_ZN4llvmL12maxPrecisionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL12maxPrecisionE")
//</editor-fold>
public static /*const*//*uint*/int maxPrecision = 113;
//<editor-fold defaultstate="collapsed" desc="llvm::maxPowerOfFiveExponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 94,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 93,
 FQN="llvm::maxPowerOfFiveExponent", NM="_ZN4llvmL22maxPowerOfFiveExponentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL22maxPowerOfFiveExponentE")
//</editor-fold>
public static /*const*//*uint*/int maxPowerOfFiveExponent = maxExponent + maxPrecision - 1;
//<editor-fold defaultstate="collapsed" desc="llvm::maxPowerOfFiveParts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 95,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 94,
 FQN="llvm::maxPowerOfFiveParts", NM="_ZN4llvmL19maxPowerOfFivePartsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL19maxPowerOfFivePartsE")
//</editor-fold>
public static /*const*//*uint*/int maxPowerOfFiveParts = 2 + ($div_uint((maxPowerOfFiveExponent * 815)
  , (351 * integerPartWidth)));
// End namespace detail.
//<editor-fold defaultstate="collapsed" desc="llvm::PrintRecyclerStats">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Allocator.cpp", line = 32,
 FQN="llvm::PrintRecyclerStats", NM="_ZN4llvm18PrintRecyclerStatsEjjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm18PrintRecyclerStatsEjjj")
//</editor-fold>
public static void PrintRecyclerStats(/*size_t*/int Size, 
                  /*size_t*/int Align, 
                  /*size_t*/int FreeListSize) {
  /*delegate*/org.llvm.support.impl.AllocatorLlvmStatics.
    PrintRecyclerStats(Size, 
                  Align, 
                  FreeListSize);
}

/*template <typename TResult> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ConvertUTF8toWideInternal">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 186,
 FQN="llvm::ConvertUTF8toWideInternal", NM="Tpl__ZN4llvmL25ConvertUTF8toWideInternalENS_9StringRefERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=Tpl__ZN4llvmL25ConvertUTF8toWideInternalENS_9StringRefERT_")
//</editor-fold>
public static /*inline*/ </*typename*/ TResult> boolean ConvertUTF8toWideInternal(StringRef Source, 
                         final TResult /*&*/ Result) {
  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmStatics.
    ConvertUTF8toWideInternal(Source, 
                         Result);
}

//<editor-fold defaultstate="collapsed" desc="llvm::CurrentDebugType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 44,
 FQN="llvm::CurrentDebugType", NM="_ZN4llvmL16CurrentDebugTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvmL16CurrentDebugTypeE")
//</editor-fold>
public static ManagedStatic<std.vectorString> CurrentDebugType/*J*/= new ManagedStatic<std.vectorString>(new ManagedStaticInfoImpl<std.vectorString>(){
  @Override
  protected vectorString create() {
    return new vectorString();
  }
});//new std.vectorStringInfo());
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 309,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 304,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCFixupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCFixupE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_MCFixup$C(final raw_ostream /*&*/ OS, final /*const*/ MCFixup /*&*/ AF) {
  return /*delegate*/org.llvm.mc.impl.MCFragmentLlvmStatics.
    $out_raw_ostream_MCFixup$C(OS, AF);
}

//<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 18,
 FQN="llvm::(anonymous namespace)::(anonymous)", NM="_MCSymbolELF_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_MCSymbolELF_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // Shift value for STT_* flags. 7 possible values. 3 bits.
  public static final /*uint*/int ELF_STT_Shift = 0;
  
  // Shift value for STB_* flags. 4 possible values, 2 bits.
  public static final /*uint*/int ELF_STB_Shift = 3;
  
  // Shift value for STV_* flags. 4 possible values, 2 bits.
  public static final /*uint*/int ELF_STV_Shift = 5;
  
  // Shift value for STO_* flags. 3 bits. All the values are between 0x20 and
  // 0xe0, so we shift right by 5 before storing.
  public static final /*uint*/int ELF_STO_Shift = 7;
  
  // One bit.
  public static final /*uint*/int ELF_IsSignature_Shift = 10;
  
  // One bit.
  public static final /*uint*/int ELF_WeakrefUsedInReloc_Shift = 11;
  
  // One bit.
  public static final /*uint*/int ELF_BindingSet_Shift = 12;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::ReverseStackTrace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 44,
 FQN="llvm::ReverseStackTrace", NM="_ZN4llvm17ReverseStackTraceEPNS_21PrettyStackTraceEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm17ReverseStackTraceEPNS_21PrettyStackTraceEntryE")
//</editor-fold>
public static PrettyStackTraceEntry /*P*/ ReverseStackTrace(PrettyStackTraceEntry /*P*/ Head) {
  return /*delegate*/org.llvm.support.impl.PrettyStackTraceLlvmStatics.
    ReverseStackTrace(Head);
}

//<editor-fold defaultstate="collapsed" desc="llvm::RedirectIO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 99,
 FQN="llvm::RedirectIO", NM="_ZN4llvmL10RedirectIOEPKNS_9StringRefEiPSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL10RedirectIOEPKNS_9StringRefEiPSs")
//</editor-fold>
public static boolean RedirectIO(/*const*/ StringRef /*P*/ Path, int FD, std.string/*P*/ ErrMsg) {
  if (!(Path != null)) { // Noop
    return false;
  }
  std.string File/*J*/= new std.string();
  if (Path.empty()) {
    // Redirect empty paths to /dev/null
    File.$assign_T$C$P(/*KEEP_STR*/"/dev/null");
  } else {
    File.$assignMove($Deref(Path).$string());
  }
  
  // Open the file
  int InFD = open(File.c_str(), FD == 0 ? O_RDONLY : O_WRONLY|O_CREAT, 0666);
  if (InFD == -1) {
    MakeErrMsg(ErrMsg, $add_string_T$C$P($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"Cannot open file '", File), /*KEEP_STR*/"' for "), 
            (FD == 0 ? $("input") : $("output"))));
    return true;
  }
  
  // Install it as the requested FD
  if (dup2(InFD, FD) == -1) {
    MakeErrMsg(ErrMsg, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Cannot dup2"));
    close(InFD);
    return true;
  }
  close(InFD); // Close the original FD
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::RedirectIO_PS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 128,
 FQN="llvm::RedirectIO_PS", NM="_ZN4llvmL13RedirectIO_PSEPKSsiPSsP26posix_spawn_file_actions_t",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL13RedirectIO_PSEPKSsiPSsP26posix_spawn_file_actions_t")
//</editor-fold>
public static boolean RedirectIO_PS(/*const*/std.string/*P*/ Path, int FD, std.string/*P*/ ErrMsg, 
              posix_spawn_file_actions_t /*P*/ FileActions) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::TimeOutHandler">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 147,
 FQN="llvm::TimeOutHandler", NM="_ZN4llvmL14TimeOutHandlerEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL14TimeOutHandlerEi")
//</editor-fold>
public static void TimeOutHandler(int Sig) {
  /*delegate*/org.llvm.support.unix.impl.ProgramLlvmStatics.
    TimeOutHandler(Sig);
}

//<editor-fold defaultstate="collapsed" desc="llvm::SetMemoryLimits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 150,
 FQN="llvm::SetMemoryLimits", NM="_ZN4llvmL15SetMemoryLimitsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL15SetMemoryLimitsEj")
//</editor-fold>
public static void SetMemoryLimits(/*uint*/int size) {
  /*delegate*/org.llvm.support.unix.impl.ProgramLlvmStatics.
    SetMemoryLimits(size);
}

//<editor-fold defaultstate="collapsed" desc="llvm::SearchForAddressOfSpecialSymbol">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/SearchForAddressOfSpecialSymbol.cpp", line = 55,
 FQN="llvm::SearchForAddressOfSpecialSymbol", NM="_ZN4llvm31SearchForAddressOfSpecialSymbolEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/SearchForAddressOfSpecialSymbol.cpp -nm=_ZN4llvm31SearchForAddressOfSpecialSymbolEPKc")
//</editor-fold>
public static Object/*void P*/ SearchForAddressOfSpecialSymbol(/*const*/char$ptr/*char P*/ symbolName) {
  return /*delegate*/org.llvm.support.impl.SearchForAddressOfSpecialSymbolLlvmStatics.
    SearchForAddressOfSpecialSymbol(symbolName);
}


//===----------------------------------------------------------------------===//
//=== WARNING: Implementation here must contain only TRULY operating system
//===          independent code.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::CallBacksToRun">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Signals.cpp", line = 39,
 FQN="llvm::CallBacksToRun", NM="_ZN4llvmL14CallBacksToRunE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZN4llvmL14CallBacksToRunE")
//</editor-fold>
public static ManagedStatic<std.vector<std.pairPtrPtr<VoidPtr2Void, Object/*void P*/ >>> CallBacksToRun/*J*/= 
        new ManagedStatic<std.vector<std.pairPtrPtr<VoidPtr2Void, Object/*void P*/ >>>(new ManagedStaticInfoImpl<std.vector<std.pairPtrPtr<VoidPtr2Void, Object/*void P*/ >>>(){
  @Override
  protected vector<pairPtrPtr<VoidPtr2Void, Object>> create() {
    return new vector<pairPtrPtr<VoidPtr2Void, Object>>(new pairPtrPtr<>());
  }
});//new std.vector<std.pairPtrPtr<VoidPtr2Void, Object/*void P*/ >>Info());
} // END OF class AdtsupportLlvmStatics
