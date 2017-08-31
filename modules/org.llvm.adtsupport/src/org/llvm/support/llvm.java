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

import static org.clank.support.Native.$AddrOf;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import java.util.UnknownFormatConversionException;
import org.clank.java.*;
import static org.clank.java.built_in.__builtin_huge_valf;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.$tryClone;
import org.clank.support.Native.NativeIterable;
import org.clank.support.Native.NativeReverseIterable;
import org.clank.support.NativeCallback.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTFunctionPointers.fatal_error_handler_t;
import org.llvm.adt.aliases.*;
import org.llvm.adt.impl.StatisticLlvmGlobals;
import org.llvm.cl.ClGlobals;
import org.llvm.mc.MCAsmInfo;
import org.llvm.mc.MCContext;
import org.llvm.mc.MCStreamer;
import org.llvm.mc.mcparser.MCAsmParser;
import org.llvm.support.ConvertUTFGlobals.ConversionFlags;
import org.llvm.support.ConvertUTFGlobals.ConversionResult;
import static org.llvm.support.ConvertUTFGlobals.*;
import org.llvm.support.endian.EndianGlobals;
import org.llvm.support.impl.AtomicOrderingLlvmGlobals;
import org.llvm.support.impl.CastingLlvmGlobals;
import static org.llvm.support.impl.ManagedStaticStatics.StaticList;
import org.llvm.support.impl.MathExtrasLlvmGlobals;
import static org.llvm.support.impl.StringRefStatics.GetAutoSenseRadix;
import org.llvm.support.impl.ThreadingLlvmGlobals;
import org.llvm.support.impl.TimerStatics;


//<editor-fold defaultstate="collapsed" desc="static type llvm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print -empty-body ${LLVM_SRC}/llvm/lib/Support/Twine.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp ${LLVM_SRC}/llvm/lib/Support/SmallVector.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp ${LLVM_SRC}/llvm/lib/Support/APInt.cpp ${LLVM_SRC}/llvm/lib/Support/system_error.cpp ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp ${LLVM_SRC}/llvm/lib/Support/MD5.cpp ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp ${LLVM_SRC}/llvm/lib/Support/Threading.cpp ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroArgs.cpp ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp ${LLVM_SRC}/llvm/lib/Support/Debug.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -file-filter=${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h#1688;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#462;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#360;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#145;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#32;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#572;${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h#410;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#282;${LLVM_SRC}/llvm/include/llvm/Support/Debug.h#88;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#67;${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h#921;${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h#231;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#410;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#88;${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h#179;${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h#414;${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h#240;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#252;${LLVM_SRC}/llvm/include/llvm/Support/PrettyStackTrace.h#24;${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h#498;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#230;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#139;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#597;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#237;${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h#170;${LLVM_SRC}/llvm/include/llvm/Support/Threading.h#25;${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h#140;${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h#215;${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h#1050;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#715;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#247;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#221;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#490;${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h#516;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#117;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#527;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#536;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#243;${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h#161;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#526;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#308;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#565;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#443;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#29;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#479;${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h#418;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#314;${LLVM_SRC}/llvm/include/llvm/Support/Threading.h#42;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#277;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#283;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#89;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#275;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#183;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#270;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#26;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#289;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#532;${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h#185;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#262;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#265;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#540;${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h#1684;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#899;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#665;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#194;${LLVM_SRC}/llvm/include/llvm/Support/Threading.h#34;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#271;${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h#1686;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#173;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#153;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#323;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#795;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#800;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#127;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#139;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#804;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#160;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#199;${LLVM_SRC}/llvm/include/llvm/Support/Threading.h#30;${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h#505;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#315;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#256;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#342;${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h#512;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#295;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#378;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#530;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#301;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#579;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#531;${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h#305;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#791;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#820;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#816;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#249;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#296;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#544;${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h#298;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#257;${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h#143;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#558;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#236;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#166;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#72;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#114;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#516;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#288;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#812;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#808;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#61;${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h#188;${LLVM_SRC}/llvm/include/llvm/ADT/OwningPtr.h#146;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#528;${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h#185;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#79;${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h#202;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#46;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#104;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#94;${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h#216;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#55;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#283;${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h#179;${LLVM_SRC}/llvm/include/llvm/Support/Debug.h#50;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#524;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#122;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#417;${LLVM_SRC}/llvm/include/llvm/Support/Capacity.h#22;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#546;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#133;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#402;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#73;${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h#57;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#429;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#348;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#354;${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h#181;${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h#195;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#503;${LLVM_SRC}/llvm/include/llvm/Support/Casting.h#263;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#372;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#315;${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h#209;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#456;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#178;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#288;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#138;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#468;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#603;${LLVM_SRC}/llvm/include/llvm/Support/Debug.h#56;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#449;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#215;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#267;${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h#301;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#659;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#585;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#163;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#782;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#386;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#145;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#293;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#275;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#394;${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h#198;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#35;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#719;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#206;${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h#140;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#160;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#535;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#271;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#551;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#267;${LLVM_SRC}/llvm/include/llvm/Support/Threading.h#38;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#335;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#83;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#81;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#79;${LLVM_SRC}/llvm/include/llvm/Support/Threading.h#55;${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h#152;${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h#310;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#591;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#301;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#328;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#77;${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h#50;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#297;${LLVM_SRC}/llvm/include/llvm/Support/Format.h#202;${LLVM_SRC}/llvm/include/llvm/ADT/OwningPtr.h#84;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#786;${LLVM_SRC}/llvm/include/llvm/Support/Format.h#214;${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h#128;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#321;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#49;${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h#188;${LLVM_SRC}/llvm/include/llvm/Support/Format.h#227;${LLVM_SRC}/llvm/include/llvm/Support/Format.h#179;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#366;${LLVM_SRC}/llvm/include/llvm/Support/system_error.h#660;${LLVM_SRC}/llvm/include/llvm/Support/Format.h#190;${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h#520;${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h#220; -static-type=llvm")
//</editor-fold>
public final class llvm {

public static NoneType None = NoneType.None;

  public static <T> setPtr<T> set_difference(setPtr<T> CurrentOverrides, setPtr<T> LastOverrides) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static <T> setType<T> set_difference(setType<T> CurrentOverrides, setType<T> LastOverrides) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static boolean __toString(Error track) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @FunctionalInterface public interface JavaDumpCallback<T> {
    public void dump(T $this, raw_ostream Out);
  }
  
  // when class or it's base class provides dump(raw_ostream Out) method:
  // use this method in Java toString implementation like
  // "Val=[" + llvm.DumpJavaString(this, ValClass::dump) + "]
  public static <T> String DumpJavaString(T $this, JavaDumpCallback<? super T> DumpFunc) {
    std.string Result/*J*/= new std.string();
    raw_string_ostream Out = null;
    try {
      Out/*J*/= new raw_string_ostream(Result);
      DumpFunc.dump($this, Out);
      Out.flush();
    } finally {
      Out.$destroy();
    }    
    return Result.toJavaString();
  }
  
private llvm() {}

public static final boolean DebugFlag = false;
public static final boolean LLVM_ON_WIN32 = isWindows();
public static final boolean LLVM_ENABLE_THREADS = false; // compile time -D directive

public static void LLVM_BUILTIN_TRAP() {
  throw new UnsupportedOperationException("EmptyBody");
}

public static void consumeError(Error err) {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

// JAVA
private static boolean isWindows() {
  String osName = System.getProperty("os.name");
  // strings below are taken from
  // org.openide.util.BaseUtilities.getOperatingSystem()
  if ("Windows NT".equals(osName)) { // NOI18N
    return true;
  } else if ("Windows 95".equals(osName)) { // NOI18N
    return true;
  } else if ("Windows 98".equals(osName)) { // NOI18N
    return true;
  } else if ("Windows 2000".equals(osName)) { // NOI18N
    return true;
  } else if ("Windows Vista".equals(osName)) { // NOI18N
    return true;
  } else if (osName.startsWith("Windows ")) { // NOI18N
    return true;
  } else if ("Solaris".equals(osName)) { // NOI18N
    return false;
  } else if (osName.startsWith("SunOS")) { // NOI18N
    return false;
  } // JDK 1.4 b2 defines os.name for me as "Redhat Linux" -jglick
  else if (osName.endsWith("Linux")) { // NOI18N
    return false;
  } else if ("HP-UX".equals(osName)) { // NOI18N
    return false;
  } else if ("AIX".equals(osName)) { // NOI18N
    return false;
  } else if ("Irix".equals(osName)) { // NOI18N
    return false;
  } else if ("SunOS".equals(osName)) { // NOI18N
    return false;
  } else if ("Digital UNIX".equals(osName)) { // NOI18N
    return false;
  } else if ("OS/2".equals(osName)) { // NOI18N
    return false;
  } else if ("OpenVMS".equals(osName)) { // NOI18N
    return false;
  } else if (osName.equals("Mac OS X")) { // NOI18N
    return false;
  } else if (osName.startsWith("Darwin")) { // NOI18N
    return false;
  } else if (osName.toLowerCase(Locale.US).startsWith("freebsd")) { // NOI18N
    return false;
  } else if ("OpenBSD".equals(osName)) { // NOI18N
    return false;
  } else if (File.pathSeparatorChar == ':') { // NOI18N
    return false;
  } else {
    return false;
  }
}

/// \brief Macro compressed bit reversal table for 256 bits.
///
/// http://graphics.stanford.edu/~seander/bithacks.html#BitReverseTable
//<editor-fold defaultstate="collapsed" desc="llvm::BitReverseTable256">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 219,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 227,
 FQN = "llvm::BitReverseTable256", NM = "_ZN4llvmL18BitReverseTable256E",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL18BitReverseTable256E")
//</editor-fold>
public static /*const*//*uchar*/short BitReverseTable256[/*256*/] = new /*const*//*uchar*/short [/*256*/] {
  0, 0 + 2 * 64, 0 + 1 * 64, 0 + 3 * 64, 0 + 2 * 16, 0 + 2 * 16 + 2 * 64, 0 + 2 * 16 + 1 * 64, 0 + 2 * 16 + 3 * 64, 0 + 1 * 16, 0 + 1 * 16 + 2 * 64, 0 + 1 * 16 + 1 * 64, 0 + 1 * 16 + 3 * 64, 0 + 3 * 16, 0 + 3 * 16 + 2 * 64, 0 + 3 * 16 + 1 * 64, 0 + 3 * 16 + 3 * 64, 0 + 2 * 4, 0 + 2 * 4 + 2 * 64, 0 + 2 * 4 + 1 * 64, 0 + 2 * 4 + 3 * 64, 0 + 2 * 4 + 2 * 16, 0 + 2 * 4 + 2 * 16 + 2 * 64, 0 + 2 * 4 + 2 * 16 + 1 * 64, 0 + 2 * 4 + 2 * 16 + 3 * 64, 0 + 2 * 4 + 1 * 16, 0 + 2 * 4 + 1 * 16 + 2 * 64, 0 + 2 * 4 + 1 * 16 + 1 * 64, 0 + 2 * 4 + 1 * 16 + 3 * 64, 0 + 2 * 4 + 3 * 16, 0 + 2 * 4 + 3 * 16 + 2 * 64, 0 + 2 * 4 + 3 * 16 + 1 * 64, 0 + 2 * 4 + 3 * 16 + 3 * 64, 0 + 1 * 4, 0 + 1 * 4 + 2 * 64, 0 + 1 * 4 + 1 * 64, 0 + 1 * 4 + 3 * 64, 0 + 1 * 4 + 2 * 16, 0 + 1 * 4 + 2 * 16 + 2 * 64, 0 + 1 * 4 + 2 * 16 + 1 * 64, 0 + 1 * 4 + 2 * 16 + 3 * 64, 0 + 1 * 4 + 1 * 16, 0 + 1 * 4 + 1 * 16 + 2 * 64, 0 + 1 * 4 + 1 * 16 + 1 * 64, 0 + 1 * 4 + 1 * 16 + 3 * 64, 0 + 1 * 4 + 3 * 16, 0 + 1 * 4 + 3 * 16 + 2 * 64, 0 + 1 * 4 + 3 * 16 + 1 * 64, 0 + 1 * 4 + 3 * 16 + 3 * 64, 0 + 3 * 4, 0 + 3 * 4 + 2 * 64, 0 + 3 * 4 + 1 * 64, 0 + 3 * 4 + 3 * 64, 0 + 3 * 4 + 2 * 16, 0 + 3 * 4 + 2 * 16 + 2 * 64, 0 + 3 * 4 + 2 * 16 + 1 * 64, 0 + 3 * 4 + 2 * 16 + 3 * 64, 0 + 3 * 4 + 1 * 16, 0 + 3 * 4 + 1 * 16 + 2 * 64, 0 + 3 * 4 + 1 * 16 + 1 * 64, 0 + 3 * 4 + 1 * 16 + 3 * 64, 0 + 3 * 4 + 3 * 16, 0 + 3 * 4 + 3 * 16 + 2 * 64, 0 + 3 * 4 + 3 * 16 + 1 * 64, 0 + 3 * 4 + 3 * 16 + 3 * 64, 2, 2 + 2 * 64, 2 + 1 * 64, 2 + 3 * 64, 2 + 2 * 16, 2 + 2 * 16 + 2 * 64, 2 + 2 * 16 + 1 * 64, 2 + 2 * 16 + 3 * 64, 2 + 1 * 16, 2 + 1 * 16 + 2 * 64, 2 + 1 * 16 + 1 * 64, 2 + 1 * 16 + 3 * 64, 2 + 3 * 16, 2 + 3 * 16 + 2 * 64, 2 + 3 * 16 + 1 * 64, 2 + 3 * 16 + 3 * 64, 2 + 2 * 4, 2 + 2 * 4 + 2 * 64, 2 + 2 * 4 + 1 * 64, 2 + 2 * 4 + 3 * 64, 2 + 2 * 4 + 2 * 16, 2 + 2 * 4 + 2 * 16 + 2 * 64, 2 + 2 * 4 + 2 * 16 + 1 * 64, 2 + 2 * 4 + 2 * 16 + 3 * 64, 2 + 2 * 4 + 1 * 16, 2 + 2 * 4 + 1 * 16 + 2 * 64, 2 + 2 * 4 + 1 * 16 + 1 * 64, 2 + 2 * 4 + 1 * 16 + 3 * 64, 2 + 2 * 4 + 3 * 16, 2 + 2 * 4 + 3 * 16 + 2 * 64, 2 + 2 * 4 + 3 * 16 + 1 * 64, 2 + 2 * 4 + 3 * 16 + 3 * 64, 2 + 1 * 4, 2 + 1 * 4 + 2 * 64, 2 + 1 * 4 + 1 * 64, 2 + 1 * 4 + 3 * 64, 2 + 1 * 4 + 2 * 16, 2 + 1 * 4 + 2 * 16 + 2 * 64, 2 + 1 * 4 + 2 * 16 + 1 * 64, 2 + 1 * 4 + 2 * 16 + 3 * 64, 2 + 1 * 4 + 1 * 16, 2 + 1 * 4 + 1 * 16 + 2 * 64, 2 + 1 * 4 + 1 * 16 + 1 * 64, 2 + 1 * 4 + 1 * 16 + 3 * 64, 2 + 1 * 4 + 3 * 16, 2 + 1 * 4 + 3 * 16 + 2 * 64, 2 + 1 * 4 + 3 * 16 + 1 * 64, 2 + 1 * 4 + 3 * 16 + 3 * 64, 2 + 3 * 4, 2 + 3 * 4 + 2 * 64, 2 + 3 * 4 + 1 * 64, 2 + 3 * 4 + 3 * 64, 2 + 3 * 4 + 2 * 16, 2 + 3 * 4 + 2 * 16 + 2 * 64, 2 + 3 * 4 + 2 * 16 + 1 * 64, 2 + 3 * 4 + 2 * 16 + 3 * 64, 2 + 3 * 4 + 1 * 16, 2 + 3 * 4 + 1 * 16 + 2 * 64, 2 + 3 * 4 + 1 * 16 + 1 * 64, 2 + 3 * 4 + 1 * 16 + 3 * 64, 2 + 3 * 4 + 3 * 16, 2 + 3 * 4 + 3 * 16 + 2 * 64, 2 + 3 * 4 + 3 * 16 + 1 * 64, 2 + 3 * 4 + 3 * 16 + 3 * 64, 1, 1 + 2 * 64, 1 + 1 * 64, 1 + 3 * 64, 1 + 2 * 16, 1 + 2 * 16 + 2 * 64, 1 + 2 * 16 + 1 * 64, 1 + 2 * 16 + 3 * 64, 1 + 1 * 16, 1 + 1 * 16 + 2 * 64, 1 + 1 * 16 + 1 * 64, 1 + 1 * 16 + 3 * 64, 1 + 3 * 16, 1 + 3 * 16 + 2 * 64, 1 + 3 * 16 + 1 * 64, 1 + 3 * 16 + 3 * 64, 1 + 2 * 4, 1 + 2 * 4 + 2 * 64, 1 + 2 * 4 + 1 * 64, 1 + 2 * 4 + 3 * 64, 1 + 2 * 4 + 2 * 16, 1 + 2 * 4 + 2 * 16 + 2 * 64, 1 + 2 * 4 + 2 * 16 + 1 * 64, 1 + 2 * 4 + 2 * 16 + 3 * 64, 1 + 2 * 4 + 1 * 16, 1 + 2 * 4 + 1 * 16 + 2 * 64, 1 + 2 * 4 + 1 * 16 + 1 * 64, 1 + 2 * 4 + 1 * 16 + 3 * 64, 1 + 2 * 4 + 3 * 16, 1 + 2 * 4 + 3 * 16 + 2 * 64, 1 + 2 * 4 + 3 * 16 + 1 * 64, 1 + 2 * 4 + 3 * 16 + 3 * 64, 1 + 1 * 4, 1 + 1 * 4 + 2 * 64, 1 + 1 * 4 + 1 * 64, 1 + 1 * 4 + 3 * 64, 1 + 1 * 4 + 2 * 16, 1 + 1 * 4 + 2 * 16 + 2 * 64, 1 + 1 * 4 + 2 * 16 + 1 * 64, 1 + 1 * 4 + 2 * 16 + 3 * 64, 1 + 1 * 4 + 1 * 16, 1 + 1 * 4 + 1 * 16 + 2 * 64, 1 + 1 * 4 + 1 * 16 + 1 * 64, 1 + 1 * 4 + 1 * 16 + 3 * 64, 1 + 1 * 4 + 3 * 16, 1 + 1 * 4 + 3 * 16 + 2 * 64, 1 + 1 * 4 + 3 * 16 + 1 * 64, 1 + 1 * 4 + 3 * 16 + 3 * 64, 1 + 3 * 4, 1 + 3 * 4 + 2 * 64,  
1 + 3 * 4 + 1 * 64, 1 + 3 * 4 + 3 * 64, 1 + 3 * 4 + 2 * 16, 1 + 3 * 4 + 2 * 16 + 2 * 64, 1 + 3 * 4 + 2 * 16 + 1 * 64, 1 + 3 * 4 + 2 * 16 + 3 * 64, 1 + 3 * 4 + 1 * 16, 1 + 3 * 4 + 1 * 16 + 2 * 64, 1 + 3 * 4 + 1 * 16 + 1 * 64, 1 + 3 * 4 + 1 * 16 + 3 * 64, 1 + 3 * 4 + 3 * 16, 1 + 3 * 4 + 3 * 16 + 2 * 64, 1 + 3 * 4 + 3 * 16 + 1 * 64, 1 + 3 * 4 + 3 * 16 + 3 * 64, 3, 3 + 2 * 64, 3 + 1 * 64, 3 + 3 * 64, 3 + 2 * 16, 3 + 2 * 16 + 2 * 64, 3 + 2 * 16 + 1 * 64, 3 + 2 * 16 + 3 * 64, 3 + 1 * 16, 3 + 1 * 16 + 2 * 64, 3 + 1 * 16 + 1 * 64, 3 + 1 * 16 + 3 * 64, 3 + 3 * 16, 3 + 3 * 16 + 2 * 64, 3 + 3 * 16 + 1 * 64, 3 + 3 * 16 + 3 * 64, 3 + 2 * 4, 3 + 2 * 4 + 2 * 64, 3 + 2 * 4 + 1 * 64, 3 + 2 * 4 + 3 * 64, 3 + 2 * 4 + 2 * 16, 3 + 2 * 4 + 2 * 16 + 2 * 64, 3 + 2 * 4 + 2 * 16 + 1 * 64, 3 + 2 * 4 + 2 * 16 + 3 * 64, 3 + 2 * 4 + 1 * 16, 3 + 2 * 4 + 1 * 16 + 2 * 64, 3 + 2 * 4 + 1 * 16 + 1 * 64, 3 + 2 * 4 + 1 * 16 + 3 * 64, 3 + 2 * 4 + 3 * 16, 3 + 2 * 4 + 3 * 16 + 2 * 64, 3 + 2 * 4 + 3 * 16 + 1 * 64, 3 + 2 * 4 + 3 * 16 + 3 * 64, 3 + 1 * 4, 3 + 1 * 4 + 2 * 64, 3 + 1 * 4 + 1 * 64, 3 + 1 * 4 + 3 * 64, 3 + 1 * 4 + 2 * 16, 3 + 1 * 4 + 2 * 16 + 2 * 64, 3 + 1 * 4 + 2 * 16 + 1 * 64, 3 + 1 * 4 + 2 * 16 + 3 * 64, 3 + 1 * 4 + 1 * 16, 3 + 1 * 4 + 1 * 16 + 2 * 64, 3 + 1 * 4 + 1 * 16 + 1 * 64, 3 + 1 * 4 + 1 * 16 + 3 * 64, 3 + 1 * 4 + 3 * 16, 3 + 1 * 4 + 3 * 16 + 2 * 64, 3 + 1 * 4 + 3 * 16 + 1 * 64, 3 + 1 * 4 + 3 * 16 + 3 * 64, 3 + 3 * 4, 3 + 3 * 4 + 2 * 64, 3 + 3 * 4 + 1 * 64, 3 + 3 * 4 + 3 * 64, 3 + 3 * 4 + 2 * 16, 3 + 3 * 4 + 2 * 16 + 2 * 64, 3 + 3 * 4 + 2 * 16 + 1 * 64, 3 + 3 * 4 + 2 * 16 + 3 * 64, 3 + 3 * 4 + 1 * 16, 3 + 3 * 4 + 1 * 16 + 2 * 64, 3 + 3 * 4 + 1 * 16 + 1 * 64, 3 + 3 * 4 + 1 * 16 + 3 * 64, 3 + 3 * 4 + 3 * 16, 3 + 3 * 4 + 3 * 16 + 2 * 64, 3 + 3 * 4 + 3 * 16 + 1 * 64, 3 + 3 * 4 + 3 * 16 + 3 * 64
};
//<editor-fold defaultstate="collapsed" desc="llvm::huge_valf">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 642,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -filter=llvm::huge_valf")
//</editor-fold>
public static final/*const*/float huge_valf = __builtin_huge_valf();
//<editor-fold defaultstate="collapsed" desc="llvm::host_char_bit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 39,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 41,
 FQN = "llvm::host_char_bit", NM = "_ZN4llvmL13host_char_bitE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmL13host_char_bitE")
//</editor-fold>
public static final/*const*//*uint*/int host_char_bit = 8;
//<editor-fold defaultstate="collapsed" desc="llvm::integerPartWidth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 40,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 42,
 FQN = "llvm::integerPartWidth", NM = "_ZN4llvmL16integerPartWidthE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmL16integerPartWidthE")
//</editor-fold>
public static final/*const*//*uint*/int integerPartWidth = host_char_bit * (/*static_cast*//*uint*/int)(sizeof$uint64());

@Converted(kind = Converted.Kind.DUMMY)
public static <T> std.unique_ptr<T> make_unique(T val) {
  return std.make_unique(val);
}

@Converted(kind = Converted.Kind.DUMMY)
public static <T> std.unique_ptr_array<T> make_unique(T val[]) {
  return std.make_unique(val);
}

/// \brief Returns the necessary adjustment for aligning \c Ptr to \c Alignment
/// bytes, rounding up.
//<editor-fold defaultstate="collapsed" desc="llvm::alignmentAdjustment">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 567,
 FQN = "llvm::alignmentAdjustment", NM = "_ZN4llvm19alignmentAdjustmentEPvj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm19alignmentAdjustmentEPvm")
//</editor-fold>
public static /*inline*/ /*size_t*/int alignmentAdjustment(char$ptr/*void P*/ Ptr, /*size_t*/int Alignment) {
  return alignAddr(Ptr, Alignment) - (int/*uintptr_t*/)Native.$ptr_index(Ptr);
}

/// \brief Aligns \c Addr to \c Alignment bytes, rounding up.
///
/// Alignment should be a power of two.  This method rounds up, so
/// alignAddr(7, 4) == 8 and alignAddr(8, 4) == 8.
//<editor-fold defaultstate="collapsed" desc="llvm::alignAddr">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 556,
 FQN = "llvm::alignAddr", NM = "_ZN4llvm9alignAddrEPvj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9alignAddrEPvm")
//</editor-fold>
public static /*inline*/ int/*uintptr_t*/ alignAddr(char$ptr/*void P*/ Addr, /*size_t*/int Alignment) {
  assert ((Alignment != 0) && isPowerOf2_32((int/*uint64_t*/)Alignment)) : "Alignment is not a power of two!";  
  assert ((int/*uintptr_t*/)Native.$ptr_index(Addr) + Alignment - 1 >= (int/*uintptr_t*/)Native.$ptr_index(Addr));
  
  return (((int/*uintptr_t*/)Native.$ptr_index(Addr) + Alignment - 1) & ~(int/*uintptr_t*/)(Alignment - 1));
}
        
/// Helper functions for StringRef::getAsInteger.
//<editor-fold defaultstate="collapsed" desc="llvm::getAsUnsignedInteger">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 378,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 339,
 FQN = "llvm::getAsUnsignedInteger", NM = "_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy")
//</editor-fold>
public static boolean getAsUnsignedInteger(StringRef Str, /*uint*/int Radix, /*ullong*/ullong$ref/*&*/ Result) {
  // Autosense radix if not specified.
  if (Radix == 0) {
    Radix = GetAutoSenseRadix(Str);
  }
  
  // Empty strings (after the radix autosense) are invalid.
  if (Str.empty()) {
    return true;
  }
  
  // Parse all the bytes of the string given this radix.  Watch for overflow.
  Result.$set(0);
  while (!Str.empty()) {
    /*uint*/int CharVal;
    if (Str.$at(0) >= $('0') && Str.$at(0) <= $('9')) {
      CharVal = Str.$at(0) - '0';
    } else if (Str.$at(0) >= $('a') && Str.$at(0) <= $('z')) {
      CharVal = Str.$at(0) - 'a' + 10;
    } else if (Str.$at(0) >= $('A') && Str.$at(0) <= $('Z')) {
      CharVal = Str.$at(0) - 'A' + 10;
    } else {
      return true;
    }
    
    // If the parsed value is larger than the integer radix, the string is
    // invalid.
    if (CharVal >= Radix) {
      return true;
    }
    
    // Add in this character.
    /*ullong*/long PrevResult = Result.$deref();
    Result.$set(Result.$deref() * Radix + CharVal);
    
    // Check for overflow by shifting back and seeing if bits were lost.
    if ((Result.$deref() / Radix) < PrevResult) {
      return true;
    }
    
    Str = Str.substr(1);
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::getAsSignedInteger">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 419,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 380,
 FQN = "llvm::getAsSignedInteger", NM = "_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx")
//</editor-fold>
public static boolean getAsSignedInteger(StringRef Str, /*uint*/int Radix, /*llong*/llong$ref/*&*/ Result) {
  /*ullong*/ullong$ref ULLVal = NativePointer.create_ullong$ref(0);
  
  // Handle positive strings first.
  if (Str.empty() || Str.front() != $('-')) {
    if (getAsUnsignedInteger(Str, Radix, ULLVal)
      // Check for value so large it overflows a signed value.
       || ((/*llong*/long)ULLVal.$deref()) < 0) {
      return true;
    }
    Result.$set(ULLVal.$deref());
    return false;
  }
  
  // Get the positive part of the value.
  if (getAsUnsignedInteger(Str.substr(1), Radix, ULLVal)
    // Reject values so large they'd overflow as negative signed, but allow
    // "-0".  This negates the unsigned so that the negative isn't undefined
    // on signed overflow.
     || ((/*llong*/long)-ULLVal.$deref()) > 0) {
    return true;
  }
  
  Result.$set(-ULLVal.$deref());
  return false;
}


//<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParser::Run">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 214,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", old_line = 201,
 FQN = "llvm::createMCAsmParser", NM = "_ZN4llvm17createMCAsmParserERNS_9SourceMgrERNS_9MCContextERNS_10MCStreamerERKNS_9MCAsmInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/MCAsmParser.cpp -nm=_ZN4llvm17createMCAsmParserERNS_9SourceMgrERNS_9MCContextERNS_10MCStreamerERKNS_9MCAsmInfoE")
//</editor-fold>  
public static MCAsmParser /*P*/ createMCAsmParser(SourceMgr /*&*/ $Prm0, MCContext /*&*/ $Prm1, MCStreamer /*&*/ $Prm2, /*const*/MCAsmInfo /*&*/ $Prm3) {
  throw new UnsupportedOperationException();
}

/// createNullStreamer - Create a dummy machine code streamer, which does
/// nothing. This is useful for timing the assembler front end.
//<editor-fold defaultstate="collapsed" desc="llvm::createNullStreamer">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp", line = 41,
 FQN = "llvm::createNullStreamer", NM = "_ZN4llvm18createNullStreamerERNS_9MCContextE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp -nm=_ZN4llvm18createNullStreamerERNS_9MCContextE")
//</editor-fold>
public static MCStreamer /*P*/ createNullStreamer(MCContext /*&*/ Context) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// @name StringRef Comparison Operators
/// @{
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 566,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 530,
 FQN = "llvm::operator==", NM = "_ZN4llvmeqENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmeqENS_9StringRefES0_")
//</editor-fold>
public static /*inline*/ boolean $eq_StringRef(StringRef LHS, StringRef RHS) {
  return LHS.equals(RHS);
}
public static /*inline*/ boolean $eq_StringRef(StringRef LHS, String RHS) {
  return LHS.equals(RHS);
}
public static /*inline*/ boolean $eq_StringRef(String LHS, StringRef RHS) {
  return RHS.equals(LHS);
}
public static /*inline*/ boolean $eq_StringRef(SmallString LHS, String RHS) {
  int Len = RHS.length();
  return (LHS.size() == Len) && (memcmp(LHS.$array(), 0, RHS, Len) == 0);
}
public static /*inline*/ boolean $eq_StringRef(std.string LHS, StringRef RHS) {
  return RHS.equals(LHS);
}
public static /*inline*/ boolean $eq_StringRef(char$ptr LHS, StringRef RHS) {
  return RHS.equals(LHS);
}
public static /*inline*/ boolean $eq_StringRef(char$ptr LHS, char$ptr RHS) {
  return strcmp(LHS, RHS) == 0;
}
public static /*inline*/ boolean $eq_StringRef(StringRef LHS, std.string RHS) {
  return $eq_StringRef(RHS, LHS);
}
public static /*inline*/ boolean $eq_StringRef(StringRef LHS, char$ptr RHS) {
  return $eq_StringRef(RHS, LHS);
}
public static /*inline*/ boolean $eq_StringRef(StringRef LHS, byte[] RHSWithNullTerm) {
  return LHS.equals(RHSWithNullTerm);
}
public static /*inline*/ boolean $eq_StringRef(char$ptr LHS, String RHS) {
  int LHSLen = strlen(LHS);
  return $eq_StringRef(LHS, LHSLen, RHS);
}
public static /*inline*/ boolean $eq_StringRef(char$ptr LHS, int LHSLen, String RHS) {
  return (LHSLen == RHS.length()) && (memcmp(LHS, RHS, LHSLen) == 0);
}
public static /*inline*/ boolean $eq_RawStringRef(char$ptr LHS, int LHSLen, char$ptr RHS, int RHSLen) {
  return (LHSLen == RHSLen) && ((LHSLen == 0) || (memcmp(LHS, RHS, RHSLen) == 0));
}
public static /*inline*/ boolean $eq_RawStringRef(char$ptr LHS, int LHSLen, byte[] RHS, int RHSIdx, int RHSLen) {
  return (LHSLen == RHSLen) && ((LHSLen == 0) || (memcmp(LHS, RHS, RHSIdx, RHSLen) == 0));
}
public static /*inline*/ boolean $eq_RawStringRef_with_null_termed(char$ptr LHS, int LHSLen, byte[] RHSWithNullTerm, int RHSFromIdx) {
  return memcmp_null_termed(LHS, RHSWithNullTerm, RHSFromIdx, LHSLen) == 0;
}
public static /*inline*/ boolean $eq_RawStringRef_with_null_termed(byte[] LHS, int LHSStartIndex, int LHSLen, byte[] RHSWithNullTerm, int RHSFromIdx) {
  return memcmp_null_termed(LHS, LHSStartIndex, RHSWithNullTerm, RHSFromIdx, LHSLen) == 0;
}
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 571,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 534,
 FQN = "llvm::operator!=", NM = "_ZN4llvmneENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmneENS_9StringRefES0_")
//</editor-fold>
public static /*inline*/ boolean $noteq_StringRef(StringRef LHS, StringRef RHS) {
  return !LHS.equals(RHS);
}
public static /*inline*/ boolean $noteq_StringRef(StringRef LHS, String RHS) {
  return !LHS.equals(RHS);
}
public static /*inline*/ boolean $noteq_StringRef(std.string LHS, StringRef RHS) {
  return !RHS.equals(LHS);
}
public static /*inline*/ boolean $noteq_StringRef(char$ptr LHS, StringRef RHS) {
  return !RHS.equals(LHS);
}
public static /*inline*/ boolean $noteq_StringRef(char$ptr LHS, char$ptr RHS) {
  return strcmp(LHS, RHS) != 0;
}
public static /*inline*/ boolean $noteq_StringRef(StringRef LHS, std.string RHS) {
  return $noteq_StringRef(RHS, LHS);
}
public static /*inline*/ boolean $noteq_StringRef(char$ptr LHS, String RHS) {
  return !$eq_StringRef(LHS, RHS);
}
public static /*inline*/ boolean $noteq_StringRef(char$ptr LHS, int LHSLen, String RHS) {
  return !$eq_StringRef(LHS, LHSLen, RHS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 576,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 538,
 FQN = "llvm::operator<", NM = "_ZN4llvmltENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmltENS_9StringRefES0_")
//</editor-fold>
public static /*inline*/ boolean $less_StringRef(StringRef LHS, StringRef RHS) {
  return LHS.compare(RHS) == -1;
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 580,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 542,
 FQN = "llvm::operator<=", NM = "_ZN4llvmleENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmleENS_9StringRefES0_")
//</editor-fold>
public static /*inline*/ boolean $lesseq_StringRef(StringRef LHS, StringRef RHS) {
  return LHS.compare(RHS) != 1;
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 584,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 546,
 FQN = "llvm::operator>", NM = "_ZN4llvmgtENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmgtENS_9StringRefES0_")
//</editor-fold>
public static /*inline*/ boolean $greater_StringRef(StringRef LHS, StringRef RHS) {
  return LHS.compare(RHS) == 1;
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 588,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 550,
 FQN = "llvm::operator>=", NM = "_ZN4llvmgeENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmgeENS_9StringRefES0_")
//</editor-fold>
public static /*inline*/ boolean $greatereq_StringRef(StringRef LHS, StringRef RHS) {
  return LHS.compare(RHS) != -1;
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator+=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 592,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 554,
 FQN = "llvm::operator+=", NM = "_ZN4llvmpLERSsNS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmpLERSsNS_9StringRefE")
//</editor-fold>
public static /*inline*/ std.string /*&*/ $addassign_str_StringRef(std.string /*&*/ buffer, StringRef string) {
  return $addassign_string_StringRef(buffer, string);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator+=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 592,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 554,
 FQN = "llvm::operator+=", NM = "_ZN4llvmpLERSsNS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmpLERSsNS_9StringRefE")
//</editor-fold>
public static /*inline*/ std.string /*&*/ $addassign_string_StringRef(std.string /*&*/ buffer, StringRef string) {
  return buffer.append(string.data(), string.size());
}

/// Construct a string ref from a boolean.
//<editor-fold defaultstate="collapsed" desc="llvm::toStringRef">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 558,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::toStringRef")
//</editor-fold>
public static /*inline*/ StringRef toStringRef(boolean B) {
  return new StringRef(B ? NativePointer.$true : NativePointer.$false);
}

public static <T> boolean $eq_ArrayRef$T(ArrayRef<T> LHS, ArrayRef<T> RHS) {
  return LHS.$eq(RHS);
}

public static <T> boolean $eq_ArrayRef$T(ArrayRefULong LHS, ArrayRefULong RHS) {
  return LHS.$eq(RHS);
}

public static <T> boolean $eq_ArrayRef$T(ArrayRefUInt LHS, ArrayRefUInt RHS) {
  return LHS.$eq(RHS);
}

public static <T> type$ptr<T> remove_if(SmallVectorImpl<T> Range, BoolPredicate<T> P) {
  return std.remove_if(Range.begin(), Range.end(), P);
}

/// ScopedFatalErrorHandler - This is a simple helper class which just
/// calls install_fatal_error_handler in its constructor and
/// remove_fatal_error_handler in its destructor.
//<editor-fold defaultstate="collapsed" desc="llvm::ScopedFatalErrorHandler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h", line = 55,
 FQN = "llvm::ScopedFatalErrorHandler", NM = "_ZN4llvm23ScopedFatalErrorHandlerE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm23ScopedFatalErrorHandlerE")
//</editor-fold>
public static class/*struct*/ ScopedFatalErrorHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedFatalErrorHandler::ScopedFatalErrorHandler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h", line = 56,
   FQN = "llvm::ScopedFatalErrorHandler::ScopedFatalErrorHandler", NM = "_ZN4llvm23ScopedFatalErrorHandlerC1EPFvPvRKSsbES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm23ScopedFatalErrorHandlerC1EPFvPvRKSsbES1_")
  //</editor-fold>
  public /*explicit*/ ScopedFatalErrorHandler(fatal_error_handler_t handler) {
    this(handler, (Object/*void P*/ )null);
  }
  public /*explicit*/ ScopedFatalErrorHandler(fatal_error_handler_t handler, 
      Object/*void P*/ user_data/*= 0*/) {
    install_fatal_error_handler(handler, user_data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedFatalErrorHandler::~ScopedFatalErrorHandler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h", line = 61,
   FQN = "llvm::ScopedFatalErrorHandler::~ScopedFatalErrorHandler", NM = "_ZN4llvm23ScopedFatalErrorHandlerD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm23ScopedFatalErrorHandlerD0Ev")
  //</editor-fold>
  public void $destroy() {
    remove_fatal_error_handler();
  }

}

//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 514,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 500,
 FQN = "llvm::operator+", NM = "_ZN4llvmplERKNS_5TwineES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_5TwineES2_")
//</editor-fold>
public static /*inline*/ Twine $add_Twine(/*const*/Twine /*&*/ LHS, /*const*/Twine /*&*/ RHS) {
  return LHS.concat(RHS);
}
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 514,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 500,
 FQN = "llvm::operator+", NM = "_ZN4llvmplERKNS_5TwineES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_5TwineES2_")
//</editor-fold>
public static /*inline*/ Twine $add_Twine$C(/*const*/Twine /*&*/ LHS, /*const*/Twine /*&*/ RHS) {
  return LHS.concat(RHS);
}


/// Additional overload to guarantee simplified codegen; this is equivalent to
/// concat().
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 521,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 507,
 FQN = "llvm::operator+", NM = "_ZN4llvmplEPKcRKNS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplEPKcRKNS_9StringRefE")
//</editor-fold>
public static /*inline*/Twine $add_char$ptr_StringRef(/*const*/char$ptr/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_char$ptr_StringRef(/*const*/String/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_char$ptr$C_StringRef(/*const*/char$ptr/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return $add_char$ptr_StringRef(LHS, RHS);
}
public static /*inline*/Twine $add_char$ptr$C_StringRef(/*const*/String/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return $add_char$ptr_StringRef(LHS, RHS);
}
public static /*inline*/Twine $add_char$ptr$C_StringRef$C(/*const*/String/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return $add_char$ptr_StringRef(LHS, RHS);
}
public static /*inline*/Twine $add_char$ptr$C_StringRef$C(/*const*/char$ptr/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return $add_char$ptr_StringRef(LHS, RHS);
}
public static /*inline*/Twine $add_char$ptr$C_StringRef(/*const*/String/*char P*/ LHS, /*const*/char$ptr /*&*/ RHS) {
  return new Twine(LHS, RHS);
}

/// Additional overload to guarantee simplified codegen; this is equivalent to
/// concat().
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 521,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 507,
 FQN = "llvm::operator+", NM = "_ZN4llvmplEPKcRKNS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplEPKcRKNS_9StringRefE")
//</editor-fold>
public static /*inline*/Twine $add_T_StringRef(/*const*/char$ptr/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_T_StringRef(/*const*/String/*char P*/ LHS, /*const*/StringRef /*&*/ RHS) {
  return new Twine(LHS, RHS);
}

/// Additional overload to guarantee simplified codegen; this is equivalent to
/// concat().
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 528,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 514,
 FQN = "llvm::operator+", NM = "_ZN4llvmplERKNS_9StringRefEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_9StringRefEPKc")
//</editor-fold>
public static /*inline*/ Twine $add_StringRef_char$ptr(/*const*/StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_StringRef_char$ptr(/*const*/StringRef /*&*/ LHS, /*const*/String/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 528,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 514,
 FQN = "llvm::operator+", NM = "_ZN4llvmplERKNS_9StringRefEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_9StringRefEPKc")
//</editor-fold>
public static /*inline*/ Twine $add_StringRef_char$ptr$C(/*const*/StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_StringRef_char$ptr$C(/*const*/StringRef /*&*/ LHS, /*const*/String/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_StringRef$C_char$ptr$C(/*const*/StringRef /*&*/ LHS, /*const*/String/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_StringRef$C_char$ptr$C(/*const*/StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}

/// Additional overload to guarantee simplified codegen; this is equivalent to
/// concat().
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 528,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 514,
 FQN = "llvm::operator+", NM = "_ZN4llvmplERKNS_9StringRefEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_9StringRefEPKc")
//</editor-fold>
public static /*inline*/ Twine $add_StringRef_T(/*const*/StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}
public static /*inline*/Twine $add_StringRef_T(/*const*/StringRef /*&*/ LHS, /*const*/String/*char P*/ RHS) {
  return new Twine(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 532,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 518,
 FQN = "llvm::operator<<", NM = "_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Twine(raw_ostream /*&*/ OS, /*const*/Twine /*&*/ RHS) {
  RHS.print(OS);
  return OS;
}
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Twine$C(raw_ostream /*&*/ OS, /*const*/Twine /*&*/ RHS) {
  RHS.print(OS);
  return OS;
}

/*template <typename T> TEMPLATE*/

/// alignOf - A templated function that returns the minimum alignment of
///  of a type.  This provides no extra functionality beyond the AlignOf
///  class besides some cosmetic cleanliness.  Example usage:
///  alignOf<int>() returns the alignment of an int.
//<editor-fold defaultstate="collapsed" desc="llvm::alignOf">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 58,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::alignOf")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*uint*/int alignOf(Class<T> cls) {
  if (cls == byte.class) {
    return 1;
  }
  if (cls == char.class) {
    return 2;
  }
  if (cls == short.class) {
    return 2;
  }
  if (cls == int.class) {
    return 4;
  }
  NativeTrace.traceNotImplemented("llvm.alignOf");
  return 1;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 78,
 FQN = "llvm::countTrailingZeros", NM = "_ZN4llvm18countTrailingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEjE4typeES2_NS_12ZeroBehaviorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm18countTrailingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE")
//</editor-fold>
public static </*typename*/ T>  /*size_t*/int countTrailingZeros(T Val) {
  return countTrailingZeros(Val, ZeroBehavior.ZB_Width);
}
public static </*typename*/ T>  /*size_t*/int countTrailingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
  throw new UnsupportedOperationException("Use dedicated methods instead!");
}
public static /*inline*/ /*ulong*/int countTrailingZeros_uint32_t_ZeroBehavior(int/*uint32_t*/ Val) {
  return countTrailingZeros_uint32_t_ZeroBehavior(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*ulong*/int countTrailingZeros_uint32_t_ZeroBehavior(int/*uint32_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0) {
    return 32;
  }
  return Integer.numberOfTrailingZeros(Long.valueOf(Val).intValue());
  //return __builtin_ctz(Val);
}
public static /*inline*/ /*ulong*/int countTrailingZeros_uint64_t_ZeroBehavior(long/*uint64_t*/ Val) {
  return countTrailingZeros_uint64_t_ZeroBehavior(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*ulong*/int countTrailingZeros_uint64_t_ZeroBehavior(long/*uint64_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0) {
    return 64;
  }
  return Long.numberOfTrailingZeros(Val);
  //return __builtin_ctzll(Val);
}

///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 74,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::countTrailingZeros")
////</editor-fold>
//public static </*typename*/ T>  enable_if_c<std.numeric_limits<T>.is_integer && std.numeric_limits<T>.is_signed, std.size_t>.type countTrailingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

//<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 79,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::countTrailingZeros")
//</editor-fold>
public static /*inline*/ /*uint*/int countTrailingZeros(int/*uint32_t*/ Val, ZeroBehavior ZB) {
  throw new UnsupportedOperationException("EmptyBody");
}

///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 118,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::countLeadingZeros")
////</editor-fold>
//public static </*typename*/ T>  /*size_t*/int countLeadingZeros(T Val) {
//  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T>  /*size_t*/int countLeadingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 140,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::countLeadingZeros")
////</editor-fold>
//public static </*typename*/ T>  enable_if_c<std.numeric_limits<T>.is_integer && std.numeric_limits<T>.is_signed, std.size_t>.type countLeadingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

//<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 145,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::countLeadingZeros")
//</editor-fold>
public static /*size_t*/int countLeadingZeros(long/*uint64_t*/ Val) {
  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros(long/*uint64_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0)
    return 64;
  return Long.numberOfLeadingZeros(Val);
}

public static /*size_t*/int countLeadingZeros(int/*uint32_t*/ Val) {
  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros(int/*uint32_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0)
    return 32;
  return Integer.numberOfLeadingZeros(Val);
}
public static /*size_t*/int countLeadingZeros(short Val) {
  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros(short/*uint32_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0)
    return 16;
  throw new UnsupportedOperationException();
}
public static /*size_t*/int countLeadingZeros_uint64_t_ZeroBehavior(long/*uint64_t*/ Val) {
  return countLeadingZeros_uint64_t_ZeroBehavior(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros_uint64_t_ZeroBehavior(long/*uint64_t*/ Val, ZeroBehavior ZB) {
  return countLeadingZeros(Val, ZB);
}

/// Provide wrappers to std::find which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::find">
@Converted(kind = Converted.Kind.DEPRECATED,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 385,
 FQN="llvm::find", NM="Tpl__ZN4llvm4findEOT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=Tpl__ZN4llvm4findEOT_RKT0_")
//</editor-fold>
public static <Iter extends type$iterator<?, _Tp>, _Tp> Iter find(NativeIterable<Iter>/*&&*/ Range, /*const*/ _Tp /*&*/ val) {
  return LlvmGlobals.find(Range, val);
}
public static <_Tp> type$iterator<?, _Tp> find(iterator_range<_Tp> /*&&*/ Range, /*const*/ _Tp /*&*/ val) {
  return LlvmGlobals.find(Range, val);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 184,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::findFirstSet")
//</editor-fold>
public static </*typename*/ T>  /*size_t*/int findFirstSet(T Val) {
  return findFirstSet(Val, ZeroBehavior.ZB_Max);
}
public static </*typename*/ T>  /*size_t*/int findFirstSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// \brief Get the index of the first set bit starting from the least
///   significant bit.
///
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
///   valid arguments.
//</*typename*/ T/* = unsigned long long*/> 
//<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 194,
 FQN="llvm::findFirstSet", NM="_ZN4llvm12findFirstSetIyEET_S1_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm12findFirstSetIyEET_S1_NS_12ZeroBehaviorE")
//</editor-fold>
public static /*uint*/int findFirstSet(/*ullong*/long Val) {
  return findFirstSet(Val, ZeroBehavior.ZB_Max);
}
public static /*uint*/int findFirstSet(/*ullong*/long Val, ZeroBehavior ZB) {
  if (ZB == ZeroBehavior.ZB_Max && Val == $int2ullong(0)) {
    return (/*uint*/int)std.numeric_limitsULLong./*ullong*/max();
  }
  
  return countTrailingZeros_uint64_t_ZeroBehavior(Val, ZeroBehavior.ZB_Undefined);
}

///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 195,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::findFirstSet")
////</editor-fold>
//public static </*typename*/ T>  enable_if_c<std.numeric_limits<T>.is_integer && std.numeric_limits<T>.is_signed, T>.type findFirstSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 207,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::findLastSet")
//</editor-fold>
public static </*typename*/ T>  /*size_t*/int findLastSet(T Val) {
  return findLastSet(Val, ZeroBehavior.ZB_Max);
}
public static </*typename*/ T>  /*size_t*/int findLastSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// \brief Get the index of the last set bit starting from the least
///   significant bit.
///
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
///   valid arguments.
//</*typename*/ T/* = unsigned long long*/> 
//<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 208,
 FQN="llvm::findLastSet", NM="_ZN4llvm11findLastSetIyEET_S1_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm11findLastSetIyEET_S1_NS_12ZeroBehaviorE")
//</editor-fold>
public static /*uint*/int findLastSet(/*ullong*/long Val) {
  return findLastSet(Val, ZeroBehavior.ZB_Max);
}        
public static /*uint*/int findLastSet(/*ullong*/long Val, ZeroBehavior ZB) {
  if (ZB == ZeroBehavior.ZB_Max && Val == $int2ullong(0)) {
    return (/*uint*/int)std.numeric_limitsULLong./*<ullong*/max();
  }
  
  // Use ^ instead of - because both gcc and llvm can remove the associated ^
  // in the __builtin_clz intrinsic on x86.
  return countLeadingZeros(Val, ZeroBehavior.ZB_Undefined)
     ^ (std.numeric_limitsULLong./*<ullong*/digits - 1);
}

///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 221,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::findLastSet")
////</editor-fold>
//public static </*typename*/ T>  enable_if_c<std.numeric_limits<T>.is_integer && std.numeric_limits<T>.is_signed, T>.type findLastSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

/*template <typename T> TEMPLATE*/

/// \brief Reverse the bits in \p Val.
//<editor-fold defaultstate="collapsed" desc="llvm::reverseBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 237,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::reverseBits")
//</editor-fold>
public static </*typename*/ T> T reverseBits(T Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

public static <T> iterator_range<T> reverse$NotHasRBegin(NativeReverseIterable<? extends type$iterator<?, T>> Components) {
  return new iterator_range(Components.rbegin(), Components.rend());
}

public static <T>  Iterable<T> reverse$NotHasRBegin(vector<T> RegionStack) {
  return new iterator_range(RegionStack.rbegin(), RegionStack.rend());
}

public static <T> iterator_range<T> reverse$NotHasRBegin(SmallVectorImpl<T> Components) {
  return new iterator_range(Components.rbegin(), Components.rend());
}

public static <T> iterator_range<T> reverse$NotHasRBegin(SmallVectorImplWithoutDestroy<T> Components) {
  return new iterator_range(Components.rbegin(), Components.rend());
}

public static <T> iterator_range<T> reverse$NotHasRBegin(iterator_range<T> Components) {
//  if (true) {
//      throw new UnsupportedOperationException("EmptyBody");
//  }
  final type$iterator<? extends type$iterator, T> beg = Components.begin();
  final type$iterator<? extends type$iterator, T> end = Components.end();
// reverse_iterator subtracts 1 in $star(), so we don't need this
//  if (beg.$noteq(end)) {
//    beg.$preDec(); 
//    end.$preDec();
//  }
  final reverse_iterator rbeg = new reverse_iterator(end);
  final reverse_iterator rend = new reverse_iterator(beg);
  return new iterator_range(rbeg, rend);
}

@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 221,
 FQN="llvm::reverse")
//public static <T> iterator_range<T> reverse$HasRBegin(NativeIterable<type$iterator<?, T>> C) {
public static <T> iterator_range<T> reverse$HasRBegin(NativeReverseIterable<std.reverse_iterator<T>> C) {
  return make_range(new reverse_iterator(C.rbegin()), new reverse_iterator(C.rend()));
}

/// Hi_32 - This function returns the high 32 bits of a 64 bit value.
//<editor-fold defaultstate="collapsed" desc="llvm::Hi_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 246,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 254,
 FQN = "llvm::Hi_32", NM = "_ZN4llvm5Hi_32Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Hi_32Ey")
//</editor-fold>
public static /*inline*/ int/*uint32_t*/ Hi_32(long/*uint64_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Lo_32 - This function returns the low 32 bits of a 64 bit value.
//<editor-fold defaultstate="collapsed" desc="llvm::Lo_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 251,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 259,
 FQN = "llvm::Lo_32", NM = "_ZN4llvm5Lo_32Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Lo_32Ey")
//</editor-fold>
public static /*inline*/ int/*uint32_t*/ Lo_32(long/*uint64_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <unsigned int N> TEMPLATE*/

/// isInt - Checks if an integer fits into the given bit width.
//<editor-fold defaultstate="collapsed" desc="llvm::isInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 263,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::isInt")
//</editor-fold>
public static /*inline*/ boolean isInt(long/*int64_t*/ x, /*uint*/int N) {
  throw new UnsupportedOperationException("EmptyBody");
}

// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 267,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 275,
 FQN = "llvm::isInt", NM = "_ZN4llvm5isIntILj8EEEbx",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5isIntILj8EEEbx")
//</editor-fold>
public static /*inline*/ boolean isInt(long/*int64_t*/ x) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <unsigned int N, unsigned int S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 275,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 283,
 FQN = "llvm::isInt", NM = "_ZN4llvm5isIntILj32EEEbx",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5isIntILj32EEEbx")
//</editor-fold>
public static /*inline*/ boolean isShiftedInt(long/*int64_t*/ x, /*uint*/int N, /*uint*/int S) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <unsigned int N> TEMPLATE*/

/// isUInt - Checks if an unsigned integer fits into the given bit width.
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 300,
 FQN = "llvm::isUInt", NM = "_ZN4llvm6isUIntILj8EEEby",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm6isUIntILj8EEEby")
//</editor-fold>
public static /*inline*/ boolean isUInt(/*uint*/int N, long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUInt(N, x);
}
public static /*inline*/ boolean isUInt(long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUInt(x);
}

// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 300,
 FQN = "llvm::isUInt", NM = "_ZN4llvm6isUIntILj8EEEby",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm6isUIntILj8EEEby")
//</editor-fold>
public static /*inline*/ boolean isUInt8(long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUInt8(x);
}
public static /*inline*/ boolean isUInt16(long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUInt16(x);
}
public static /*inline*/ boolean isUInt24(long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUInt24(x);
}
public static /*inline*/ boolean isUInt32(long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUInt32(x);
}

/*template <unsigned int N, unsigned int S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedUInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 301,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 309,
 FQN = "llvm::isUInt", NM = "_ZN4llvm6isUIntILj32EEEby",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm6isUIntILj32EEEby")
//</editor-fold>
public static /*inline*/boolean isShiftedUInt(long/*uint64_t*/ x, /*uint*/int N, /*uint*/int S) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isUIntN - Checks if an unsigned integer fits into the given (dynamic)
/// bit width.
//<editor-fold defaultstate="collapsed" desc="llvm::isUIntN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 354,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 315,
 FQN="llvm::isUIntN", NM="_ZN4llvm7isUIntNEjy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm7isUIntNEjy")
//</editor-fold>
public static /*inline*/ boolean isUIntN(/*uint*/int N, long/*uint64_t*/ x) {
  return MathExtrasLlvmGlobals.isUIntN(N, x);
}


/// isIntN - Checks if an signed integer fits into the given (dynamic)
/// bit width.
//<editor-fold defaultstate="collapsed" desc="llvm::isIntN">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 321,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 329,
 FQN = "llvm::isIntN", NM = "_ZN4llvm6isIntNEjx",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm6isIntNEjx")
//</editor-fold>
public static /*inline*/ boolean isIntN(/*uint*/int N, long/*int64_t*/ x) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isMask_32 - This function returns true if the argument is a sequence of ones
/// starting at the least significant bit with the remainder zero (32 bit
/// version).   Ex. isMask_32(0x0000FFFFU) == true.
//<editor-fold defaultstate="collapsed" desc="llvm::isMask_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 328,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 336,
 FQN = "llvm::isMask_32", NM = "_ZN4llvm9isMask_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm9isMask_32Ej")
//</editor-fold>
public static /*inline*/ boolean isMask_32(int/*uint32_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isMask_64 - This function returns true if the argument is a sequence of ones
/// starting at the least significant bit with the remainder zero (64 bit
/// version).
//<editor-fold defaultstate="collapsed" desc="llvm::isMask_64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 335,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 343,
 FQN = "llvm::isMask_64", NM = "_ZN4llvm9isMask_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm9isMask_64Ey")
//</editor-fold>
public static /*inline*/ boolean isMask_64(long/*uint64_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isShiftedMask_32 - This function returns true if the argument contains a
/// sequence of ones with the remainder zero (32 bit version.)
/// Ex. isShiftedMask_32(0x0000FF00U) == true.
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 342,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 350,
 FQN = "llvm::isShiftedMask_32", NM = "_ZN4llvm16isShiftedMask_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm16isShiftedMask_32Ej")
//</editor-fold>
public static /*inline*/ boolean isShiftedMask_32(int/*uint32_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isShiftedMask_64 - This function returns true if the argument contains a
/// sequence of ones with the remainder zero (64 bit version.)
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 348,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 356,
 FQN = "llvm::isShiftedMask_64", NM = "_ZN4llvm16isShiftedMask_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm16isShiftedMask_64Ey")
//</editor-fold>
public static /*inline*/ boolean isShiftedMask_64(long/*uint64_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isPowerOf2_32 - This function returns true if the argument is a power of
/// two > 0. Ex. isPowerOf2_32(0x00100000U) == true (32 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::isPowerOf2_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 354,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 362,
 FQN = "llvm::isPowerOf2_32", NM = "_ZN4llvm13isPowerOf2_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm13isPowerOf2_32Ej")
//</editor-fold>
public static /*inline*/ boolean isPowerOf2_32(int/*uint32_t*/ Value) {
  return (Value != 0) && !((Value & (Value - 1)) != 0L);
}


/// isPowerOf2_64 - This function returns true if the argument is a power of two
/// > 0 (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::isPowerOf2_64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 360,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 368,
 FQN = "llvm::isPowerOf2_64", NM = "_ZN4llvm13isPowerOf2_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm13isPowerOf2_64Ey")
//</editor-fold>
public static /*inline*/ boolean isPowerOf2_64(long/*uint64_t*/ Value) {
  return (Value != 0L) && !((Value & (Value - ((long/*int64_t*/)(1L/*L*/)))) != 0L);
}


/// ByteSwap_16 - This function returns a byte-swapped representation of the
/// 16-bit argument, Value.
//<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_16">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 366,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 374,
 FQN = "llvm::ByteSwap_16", NM = "_ZN4llvm11ByteSwap_16Et",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm11ByteSwap_16Et")
//</editor-fold>
public static /*inline*/ char/*uint16_t*/ ByteSwap_16(char/*uint16_t*/ Value) {
  return MathExtrasLlvmGlobals.ByteSwap_16(Value);
}


/// ByteSwap_32 - This function returns a byte-swapped representation of the
/// 32-bit argument, Value.
//<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 372,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 380,
 FQN = "llvm::ByteSwap_32", NM = "_ZN4llvm11ByteSwap_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm11ByteSwap_32Ej")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int ByteSwap_32(/*uint32_t*/int Value) {
  return MathExtrasLlvmGlobals.ByteSwap_32(Value);
}


/// ByteSwap_64 - This function returns a byte-swapped representation of the
/// 64-bit argument, Value.
//<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 378,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 386,
 FQN = "llvm::ByteSwap_64", NM = "_ZN4llvm11ByteSwap_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm11ByteSwap_64Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ ByteSwap_64(long/*uint64_t*/ Value) {
  return MathExtrasLlvmGlobals.ByteSwap_64(Value);
}


/// CountLeadingOnes_32 - this function performs the operation of
/// counting the number of ones from the most significant bit to the first zero
/// bit.  Ex. CountLeadingOnes_32(0xFF0FFF00) == 8.
/// Returns 32 if the word is all ones.
//<editor-fold defaultstate="collapsed" desc="llvm::CountLeadingOnes_32">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 394,
 FQN = "llvm::CountLeadingOnes_32", NM = "_ZN4llvm19CountLeadingOnes_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::CountLeadingOnes_32")
//</editor-fold>
public static /*inline*/ /*uint*/int CountLeadingOnes_32(int/*uint32_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// CountLeadingOnes_64 - This function performs the operation
/// of counting the number of ones from the most significant bit to the first
/// zero bit (64 bit edition.)
/// Returns 64 if the word is all ones.
//<editor-fold defaultstate="collapsed" desc="llvm::CountLeadingOnes_64">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 402,
 FQN = "llvm::CountLeadingOnes_64", NM = "_ZN4llvm19CountLeadingOnes_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm19CountLeadingOnes_64Em")
//</editor-fold>
public static /*inline*/ /*uint*/int CountLeadingOnes_64(long/*uint64_t*/ Value) {
  return countLeadingZeros_uint64_t_ZeroBehavior(~Value);
}


/// CountTrailingOnes_32 - this function performs the operation of
/// counting the number of ones from the least significant bit to the first zero
/// bit.  Ex. CountTrailingOnes_32(0x00FF00FF) == 8.
/// Returns 32 if the word is all ones.
//<editor-fold defaultstate="collapsed" desc="llvm::CountTrailingOnes_32">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 410,
 FQN = "llvm::CountTrailingOnes_32", NM = "_ZN4llvm20CountTrailingOnes_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::CountTrailingOnes_32")
//</editor-fold>
public static /*inline*/ /*uint*/int CountTrailingOnes_32(int/*uint32_t*/ Value) {
  return countTrailingZeros_uint32_t_ZeroBehavior(~Value);
}


/// CountTrailingOnes_64 - This function performs the operation
/// of counting the number of ones from the least significant bit to the first
/// zero bit (64 bit edition.)
/// Returns 64 if the word is all ones.
//<editor-fold defaultstate="collapsed" desc="llvm::CountTrailingOnes_64">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 418,
 FQN = "llvm::CountTrailingOnes_64", NM = "_ZN4llvm20CountTrailingOnes_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::CountTrailingOnes_64")
//</editor-fold>
public static /*inline*/ /*uint*/int CountTrailingOnes_64(long/*uint64_t*/ Value) {
  return countTrailingZeros_uint64_t_ZeroBehavior(~Value);
}


/// CountPopulation_32 - this function counts the number of set bits in a value.
/// Ex. CountPopulation(0xF000F000) = 8
/// Returns 0 if the word is zero.
//<editor-fold defaultstate="collapsed" desc="llvm::CountPopulation_32">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 425,
 FQN = "llvm::CountPopulation_32", NM = "_ZN4llvm18CountPopulation_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::CountPopulation_32")
//</editor-fold>
public static /*inline*/ /*uint*/int CountPopulation_32(int/*uint32_t*/ Value) {
  return Long.bitCount(Value);
}


/// CountPopulation_64 - this function counts the number of set bits in a value,
/// (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::CountPopulation_64">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 437,
 FQN = "llvm::CountPopulation_64", NM = "_ZN4llvm18CountPopulation_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm18CountPopulation_64Em")
//</editor-fold>
public static /*inline*/ /*uint*/int CountPopulation_64(long/*uint64_t*/ Value) {
  return Long.bitCount(Value);
}


/// Log2_32 - This function returns the floor log base 2 of the specified value,
/// -1 if the value is zero. (32 bit edition.)
/// Ex. Log2_32(32) == 5, Log2_32(1) == 0, Log2_32(0) == -1, Log2_32(6) == 2
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 507,
 FQN = "llvm::Log2_32", NM = "_ZN4llvm7Log2_32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm7Log2_32Ej")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_32(int/*uint32_t*/ Value) {
  return 31 - countLeadingZeros(Value);
}


/// Log2_64 - This function returns the floor log base 2 of the specified value,
/// -1 if the value is zero. (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 513,
 FQN = "llvm::Log2_64", NM = "_ZN4llvm7Log2_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm7Log2_64Ey")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_64(long/*uint64_t*/ Value) {
  return 63 - countLeadingZeros(Value);
}


/// Log2_32_Ceil - This function returns the ceil log base 2 of the specified
/// value, 32 if the value is zero. (32 bit edition).
/// Ex. Log2_32_Ceil(32) == 5, Log2_32_Ceil(1) == 0, Log2_32_Ceil(6) == 3
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_32_Ceil">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 520,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 481,
 FQN="llvm::Log2_32_Ceil", NM="_ZN4llvm12Log2_32_CeilEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm12Log2_32_CeilEj")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_32_Ceil(/*uint32_t*/int Value) {
  return 32 - countLeadingZeros(Value - 1);
}


/// Log2_64_Ceil - This function returns the ceil log base 2 of the specified
/// value, 64 if the value is zero. (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_64_Ceil">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 487,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 470,
 FQN = "llvm::Log2_64_Ceil", NM = "_ZN4llvm12Log2_64_CeilEy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm12Log2_64_CeilEy")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_64_Ceil(long/*uint64_t*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// GreatestCommonDivisor64 - Return the greatest common divisor of the two
/// values using Euclid's algorithm.
//<editor-fold defaultstate="collapsed" desc="llvm::GreatestCommonDivisor64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 493,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 476,
 FQN = "llvm::GreatestCommonDivisor64", NM = "_ZN4llvm23GreatestCommonDivisor64Eyy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm23GreatestCommonDivisor64Eyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ GreatestCommonDivisor64(long/*uint64_t*/ A, long/*uint64_t*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// BitsToDouble - This function takes a 64-bit integer and returns the bit
/// equivalent double.
//<editor-fold defaultstate="collapsed" desc="llvm::BitsToDouble">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 504,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 487,
 FQN = "llvm::BitsToDouble", NM = "_ZN4llvm12BitsToDoubleEy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm12BitsToDoubleEy")
//</editor-fold>
public static /*inline*/ double BitsToDouble(long/*uint64_t*/ Bits) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// BitsToFloat - This function takes a 32-bit integer and returns the bit
/// equivalent float.
//<editor-fold defaultstate="collapsed" desc="llvm::BitsToFloat">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 515,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 498,
 FQN = "llvm::BitsToFloat", NM = "_ZN4llvm11BitsToFloatEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm11BitsToFloatEj")
//</editor-fold>
public static /*inline*/ float BitsToFloat(int/*uint32_t*/ Bits) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// DoubleToBits - This function takes a double and returns the bit
/// equivalent 64-bit integer.  Note that copying doubles around
/// changes the bits of NaNs on some hosts, notably x86, so this
/// routine cannot be used if these bits are needed.
//<editor-fold defaultstate="collapsed" desc="llvm::DoubleToBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 528,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 511,
 FQN = "llvm::DoubleToBits", NM = "_ZN4llvm12DoubleToBitsEd",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm12DoubleToBitsEd")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ DoubleToBits(double Double) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// FloatToBits - This function takes a float and returns the bit
/// equivalent 32-bit integer.  Note that copying floats around
/// changes the bits of NaNs on some hosts, notably x86, so this
/// routine cannot be used if these bits are needed.
//<editor-fold defaultstate="collapsed" desc="llvm::FloatToBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 541,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 524,
 FQN = "llvm::FloatToBits", NM = "_ZN4llvm11FloatToBitsEf",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm11FloatToBitsEf")
//</editor-fold>
public static /*inline*/ int/*uint32_t*/ FloatToBits(float Float) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Platform-independent wrappers for the C99 isnan() function.
//<editor-fold defaultstate="collapsed" desc="llvm::IsNAN">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp", line = 31,
 FQN = "llvm::IsNAN", NM = "_ZN4llvm5IsNANEf",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::IsNAN")
//</editor-fold>
public static int IsNAN(float f) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::IsNAN">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp", line = 32,
 FQN = "llvm::IsNAN", NM = "_ZN4llvm5IsNANEd",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::IsNAN")
//</editor-fold>
public static int IsNAN(double d) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Platform-independent wrappers for the C99 isinf() function.
//<editor-fold defaultstate="collapsed" desc="llvm::IsInf">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/IsInf.cpp", line = 46,
 FQN = "llvm::IsInf", NM = "_ZN4llvm5IsInfEf",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::IsInf")
//</editor-fold>
public static int IsInf(float f) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::IsInf">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/IsInf.cpp", line = 47,
 FQN = "llvm::IsInf", NM = "_ZN4llvm5IsInfEd",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::IsInf")
//</editor-fold>
public static int IsInf(double d) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// MinAlign - A and B are either alignments or offsets.  Return the minimum
/// alignment that may be assumed after adding the two together.
//<editor-fold defaultstate="collapsed" desc="llvm::MinAlign">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 552,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 543,
 FQN = "llvm::MinAlign", NM = "_ZN4llvm8MinAlignEyy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm8MinAlignEyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ MinAlign(long/*uint64_t*/ A, long/*uint64_t*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// NextPowerOf2 - Returns the next power of two (in 64-bits)
/// that is strictly greater than A.  Returns zero on overflow.
//<editor-fold defaultstate="collapsed" desc="llvm::NextPowerOf2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 582,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 573,
 FQN = "llvm::NextPowerOf2", NM = "_ZN4llvm12NextPowerOf2Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm12NextPowerOf2Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ NextPowerOf2(long/*uint64_t*/ A) {
  A |= (A >>> 1);
  A |= (A >>> 2);
  A |= (A >>> 4);
  A |= (A >>> 8);
  A |= (A >>> 16);
  A |= (A >>> 32);
  return A + 1;
}
public static /*inline*/ int/*uint32_t*/ NextPowerOf2(int/*uint32_t*/ A) {
  A |= (A >>> 1);
  A |= (A >>> 2);
  A |= (A >> 4);
  A |= (A >>> 8);
  A |= (A >>> 16);
  return A + 1;
}


/// Returns the next integer (mod 2**64) that is greater than or equal to
/// \p Value and is a multiple of \p Align. \p Align must be non-zero.
///
/// Examples:
/// \code
///   RoundUpToAlignment(5, 8) = 8
///   RoundUpToAlignment(17, 8) = 24
///   RoundUpToAlignment(~0LL, 8) = 0
///   RoundUpToAlignment(321, 255) = 510
/// \endcode
//<editor-fold defaultstate="collapsed" desc="llvm::RoundUpToAlignment">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 600,
 FQN = "llvm::RoundUpToAlignment", NM = "_ZN4llvm18RoundUpToAlignmentEyy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm18RoundUpToAlignmentEmm")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ RoundUpToAlignment(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return (Value + Align - 1) / Align * Align;
}


/// Returns the offset to the next integer (mod 2**64) that is greater than
/// or equal to \p Value and is a multiple of \p Align. \p Align must be
/// non-zero.
//<editor-fold defaultstate="collapsed" desc="llvm::OffsetToAlignment">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 628,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 607,
 FQN = "llvm::OffsetToAlignment", NM = "_ZN4llvm17OffsetToAlignmentEyy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm17OffsetToAlignmentEyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ OffsetToAlignment(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return RoundUpToAlignment(Value, Align) - Value;
}

/// Returns the next integer (mod 2**64) that is greater than or equal to
/// \p Value and is a multiple of \p Align. \p Align must be non-zero.
///
/// If non-zero \p Skew is specified, the return value will be a minimal
/// integer that is greater than or equal to \p Value and equal to
/// \p Align * N + \p Skew for some integer N. If \p Skew is larger than
/// \p Align, its value is adjusted to '\p Skew mod \p Align'.
///
/// Examples:
/// \code
///   alignTo(5, 8) = 8
///   alignTo(17, 8) = 24
///   alignTo(~0LL, 8) = 0
///   alignTo(321, 255) = 510
///
///   alignTo(5, 8, 7) = 7
///   alignTo(17, 8, 1) = 17
///   alignTo(~0LL, 8, 3) = 3
///   alignTo(321, 255, 42) = 552
/// \endcode
//<editor-fold defaultstate="collapsed" desc="llvm::alignTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 658,
 FQN="llvm::alignTo", NM="_ZN4llvm7alignToEyyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm7alignToEyyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ alignTo(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return alignTo(Value, Align, 0);
}
public static /*inline*/ long/*uint64_t*/ alignTo(long/*uint64_t*/ Value, long/*uint64_t*/ Align, long/*uint64_t*/ Skew/*= 0*/) {
  Skew %= Align;
  return (Value + Align - 1 - Skew) / Align * Align + Skew;
}

public static /*inline*/ type$ptr<?>/*uint64_t*/ alignTo(type$ptr<?>/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return alignTo(Value, Align, 0);
}
public static /*inline*/ type$ptr<?>/*uint64_t*/ alignTo(type$ptr<?>/*uint64_t*/ Value, long/*uint64_t*/ Align, long/*uint64_t*/ Skew/*= 0*/) {
  Skew %= Align;
  long Value$Index = $uint2ulong(Value.$index());
  Value$Index = $div_ulong((Value$Index + Align - 1 - Skew) , Align * Align) + Skew;
  Native.$setIndex(Value, $ulong2uint(Value$Index));
  return Value;
}
/// abs64 - absolute value of a 64-bit int.  Not all environments support
/// "abs" on whatever their name for the 64-bit int type is.  The absolute
/// value of the largest negative number is undefined, as with "abs".
//<editor-fold defaultstate="collapsed" desc="llvm::abs64">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 614,
 FQN = "llvm::abs64", NM = "_ZN4llvm5abs64Ex",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5abs64El")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ abs64(long/*int64_t*/ x) {
  return (x < 0L) ? -x : x;
}

/*template <unsigned int B> TEMPLATE*/

/// SignExtend32 - Sign extend B-bit number x to 32-bit int.
/// Usage int32_t r = SignExtend32<5>(x);
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 634,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 620,
 FQN = "llvm::SignExtend32", NM = "Tpl__ZN4llvm12SignExtend32Ej",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=Tpl__ZN4llvm12SignExtend32Ej")
//</editor-fold>
public static /*inline*/ int SignExtend32(int/*uint32_t*/ x, /*uint*/int B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Sign extend number in the bottom B bits of X to a 32-bit int.
/// Requires 0 < B <= 32.
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 591,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::SignExtend32")
//</editor-fold>
//public static /*inline*/ int SignExtend32(int/*uint32_t*/ X, /*uint*/int B) {
//  throw new UnsupportedOperationException("EmptyBody");
//}

/*template <unsigned int B> TEMPLATE*/

/// SignExtend64 - Sign extend B-bit number x to 64-bit int.
/// Usage int64_t r = SignExtend64<5>(x);
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 597,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::SignExtend64")
//</editor-fold>
//public static /*inline*/long/*int64_t*/ SignExtend64(long/*uint64_t*/ x, /*uint*/int B) {
//  throw new UnsupportedOperationException("EmptyBody");
//}


/// Sign-extend the number in the bottom B bits of X to a 64-bit integer.
/// Requires 0 < B < 64.
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 703,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 652,
 FQN="llvm::SignExtend64", NM="_ZN4llvm12SignExtend64Eyj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm12SignExtend64Eyj")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ SignExtend64(long/*uint64_t*/ X, /*uint*/int B) {
  assert ($greater_uint(B, 0)) : "Bit width can't be 0.";
  assert ($lesseq_uint(B, 64)) : "Bit width out of range.";
  return ((long/*int64_t*/)(X << (64 - B))) >> (64 - B);
}

/*template <typename T, unsigned int N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 922,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::capacity_in_bytes")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*size_t*/int capacity_in_bytes(/*const*/SmallVector<T> /*&*/ X, /*uint*/int N) {
  throw new UnsupportedOperationException("EmptyBody");
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static <T> T getSimplifiedValue(Object Val) {
  return CastingLlvmGlobals.getSimplifiedValue(Val);
}
public static <T> T getSimplifiedValue(simplify_type Val) {
  return CastingLlvmGlobals.getSimplifiedValue(Val);
}
// isa<X> - Return true if the parameter to the template is an instance of the
// template type argument.  Used like this:
//
//  if (isa<Type>(myVal)) { ... }
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isa">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 132,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 131,
 FQN="llvm::isa", NM="Tpl__ZN4llvm3isaERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm3isaERKT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y> boolean isa(Class<X> cls, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.isa(cls, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> boolean isa(Class<X> cls, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.isa(cls, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y> boolean isa(Class<X> cls, /*const*/ type$ref<Y> /*&*/ ValRef)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.isa(cls, ValRef.$deref());
}
public static /*inline*/ </*class*/ X, /*class*/ Y> boolean isa(Class<X> cls, /*const*/ type$ptr<Y> /*&*/ ValPtr)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.isa(cls, ValPtr.$star());
}

// cast<X> - Return the argument parameter cast to the specified type.  This
// casting operator asserts that the type is correct, so it does not return null
// on failure.  It does not allow a null argument (use cast_or_null for that).
// It is typically used like this:
//
//  cast<Instruction>(myVal)->getParent()
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 220,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 219,
 FQN="llvm::cast", NM="Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X cast$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val) {
  return CastingLlvmGlobals.cast$NotSimpleType(clsX, Val);
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 229,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 228,
 FQN="llvm::cast", NM="Tpl__ZN4llvm4castERT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm4castERT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X cast(Class<X> clsX, Y /*&*/ Val) {
  return CastingLlvmGlobals.cast(clsX, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X cast(Class<X> clsX, Y /*&*/ Val) {
  return CastingLlvmGlobals.cast(clsX, Val);
}

// cast_or_null<X> - Functionally identical to cast, except that a null value is
// accepted.
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 246,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 245,
 FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X cast_or_null$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.cast_or_null$NotSimpleType(clsX, Val);
}

/*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 256,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 255,
// FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE")
//////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X, Y>.ret_type>::type*/ cast_retty<X, Y>.ret_type cast_or_null$NotSimpleType(Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  if (Val == null) {
//    return null;
//  }
//  assert (isa<X>(Val)) : "cast_or_null<Ty>() argument of incompatible type!";
//  return cast<X>(Val);
//}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 266,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 265,
 FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullEPT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullEPT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.cast_or_null(clsX, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.cast_or_null(clsX, Val);
}


// dyn_cast<X> - Return the argument parameter cast to the specified type.  This
// casting operator returns null if the argument is of the wrong type, so it can
// be used to test for a type as well as cast if successful.  This should be
// used in the context of an if statement like this:
//
//  if (const Instruction *I = dyn_cast<Instruction>(myVal)) { ... }
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 283,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 282,
 FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X dyn_cast$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.dyn_cast$NotSimpleType(clsX, Val);
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 290,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 289,
 FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castERT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm8dyn_castERT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X dyn_cast(Class<X> clsX, Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.dyn_cast(clsX, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X dyn_cast(Class<X> clsX, Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.dyn_cast(clsX, Val);
}

// dyn_cast_or_null<X> - Functionally identical to dyn_cast, except that a null
// value is accepted.
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 305,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 304,
 FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X dyn_cast_or_null$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.dyn_cast_or_null$NotSimpleType(clsX, Val);
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 319,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 318,
 FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullEPT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullEPT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X dyn_cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.dyn_cast_or_null(clsX, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X dyn_cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  return CastingLlvmGlobals.dyn_cast_or_null(clsX, Val);
}

//<editor-fold defaultstate="collapsed" desc="llvm::make_error_code">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Errc.h", line = 78,
 FQN="llvm::make_error_code", NM="_ZN4llvm15make_error_codeENS_4errcE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm15make_error_codeENS_4errcE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(errc E) {
  return /*delegate*/org.llvm.support.impl.ErrcLlvmGlobals.
    make_error_code(E);
}

/// Provide wrappers to std::all_of which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::all_of">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 465,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 368,
 FQN="llvm::all_of", NM="Tpl__ZN4llvm6all_ofEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=Tpl__ZN4llvm6all_ofEOT_OT0_")
//</editor-fold>
public static boolean all_of(SmallVectorUInt /*&&*/Range, UIntBoolPredicate /*&&*/P) {
  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
    all_of(Range, P);
}
public static <T> boolean all_of(iterator_range<T> /*&&*/Range, BoolPredicate<T> /*&&*/P) {
  return std.all_of(Range.begin(), Range.end(), P);
}
public static <Iter extends type$iterator<?, T>, T> boolean all_of(NativeIterable<Iter> /*&&*/Range, BoolPredicate<T> /*&&*/P) {
  return std.all_of(Range.begin(), Range.end(), P);
}
public static <T extends ilist_node<T>> boolean all_of(iplist<T> /*&&*/Range, BoolPredicate<T> /*&&*/P) {
  return std.all_of(Range.begin(), Range.end(), P);
}
/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 181,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 182,
 FQN = "llvm::IntrusiveRefCntPtr::swap", NM = "_ZN4llvm18IntrusiveRefCntPtr4swapERNS_18IntrusiveRefCntPtrIT_EE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm18IntrusiveRefCntPtr4swapERNS_18IntrusiveRefCntPtrIT_EE")
//</editor-fold>
public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, /*const*/IntrusiveRefCntPtr<U> /*&*/ B) {
  return A.get() == B.get();
}

/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 189,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator!=")
//</editor-fold>
public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_IntrusiveRefCntPtr(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, /*const*/IntrusiveRefCntPtr<U> /*&*/ B) {
  return A.get() != B.get();
}

/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 196,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator==")
//</editor-fold>
public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr_T(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, U /*P*/ B) {
  return A.get() == B;
}

public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr$T$C_T1$P(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, U /*P*/ B) {
  return A.get() == B;
}
        
/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 203,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator!=")
//</editor-fold>
public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_IntrusiveRefCntPtr_T(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, U /*P*/ B) {
  return A.get() != B;
}

/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 203,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator!=")
//</editor-fold>
public static /*inline*/ </*class*/ T> boolean $noteq_IntrusiveRefCntPtr$C_nullptr_t(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, Object /*P*/ nullptr) {
  assert nullptr == null : "this method is used only when compare to nullptr_t";
  return A != null && A.$Void2RetType() != null;
}

/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 203,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator!=")
//</editor-fold>
public static /*inline*/ </*class*/ T> boolean $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(/*const*/IntrusiveRefCntPtr<T> /*&*/ A, Object /*P*/ nullptr) {
  assert nullptr == null : "this method is used only when compare to nullptr_t";
  return A != null && A.$Void2RetType() != null;
}

/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 210,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator==")
//</editor-fold>
public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_T_IntrusiveRefCntPtr(T /*P*/ A, /*const*/IntrusiveRefCntPtr<U> /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class T, class U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 217,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::operator!=")
//</editor-fold>
public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_T_IntrusiveRefCntPtr(T /*P*/ A, /*const*/IntrusiveRefCntPtr<U> /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::swap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/OwningPtr.h", line = 85,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -filter=llvm::swap")
//</editor-fold>
public static /*inline*/ </*class*/ T> void swap(unique_ptr<T> /*&*/ a, unique_ptr<T> /*&*/ b) {
  a.swap(b);
}


//===----------------------------------------------------------------------===//
//  outs(), errs(), nulls()
//===----------------------------------------------------------------------===//

/// outs() - This returns a reference to a raw_ostream for standard output.
/// Use it like: outs() << "foo" << "bar";
//<editor-fold defaultstate="collapsed" desc="llvm::outs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 718,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 720,
 FQN="llvm::outs", NM="_ZN4llvm4outsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4outsEv")
//</editor-fold>
public static raw_ostream /*&*/ outs() {
  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
    outs();
}

/// This returns a reference to a raw_ostream for standard error. Use it like:
/// errs() << "foo" << "bar";

/// errs() - This returns a reference to a raw_ostream for standard error.
/// Use it like: errs() << "foo" << "bar";
//<editor-fold defaultstate="collapsed" desc="llvm::errs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 731,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 732,
 FQN="llvm::errs", NM="_ZN4llvm4errsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4errsEv")
//</editor-fold>
public static raw_ostream /*&*/ errs() {
  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
    errs();
}

/// This returns a reference to a raw_ostream which simply discards output.

/// nulls() - This returns a reference to a raw_ostream which discards output.
//<editor-fold defaultstate="collapsed" desc="llvm::nulls">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 738,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 739,
 FQN="llvm::nulls", NM="_ZN4llvm5nullsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm5nullsEv")
//</editor-fold>
public static raw_ostream /*&*/ nulls() {
  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
    nulls();
}

/// isCurrentDebugType - Return true if the specified string is the debug type
/// specified on the command line, or if none was specified on the command line
/// with the -debug-only=X option.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isCurrentDebugType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 49,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", old_line = 91,
 FQN = "llvm::isCurrentDebugType", NM = "_ZN4llvm18isCurrentDebugTypeEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm18isCurrentDebugTypeEPKc")
//</editor-fold>
public static boolean isCurrentDebugType(/*const*/char$ptr/*char P*/ Type) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean isCurrentDebugType(/*const*/String/*char P*/ Type) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// setCurrentDebugType - Set the current debug type, as if the -debug-only=X
/// option were specified.  Note that DebugFlag also needs to be set to true for
/// debug output to be produced.
///
//<editor-fold defaultstate="collapsed" desc="llvm::setCurrentDebugType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 65,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", old_line = 107,
 FQN = "llvm::setCurrentDebugType", NM = "_ZN4llvm19setCurrentDebugTypeEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm19setCurrentDebugTypeEPKc")
//</editor-fold>
public static void setCurrentDebugType(/*const*/char$ptr/*char P*/ Type) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// dbgs() - This returns a reference to a raw_ostream for debugging
/// messages.  If debugging is disabled it returns errs().  Use it
/// like: dbgs() << "foo" << "bar";
//<editor-fold defaultstate="collapsed" desc="llvm::dbgs">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 149,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", old_line = 125,
 FQN="llvm::dbgs", NM="_ZN4llvm4dbgsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm4dbgsEv")
//</editor-fold>
public static raw_ostream /*&*/ dbgs() {
  return errs();
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 144,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -filter=llvm::operator==")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> boolean $eq_T(/*const*/Optional<T> /*&*/ X, /*const*/Optional<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static </*typename*/ T, /*typename*/ U> boolean $eq_T(/*const*/OptionalPtr<T> /*&*/ X, /*const*/OptionalPtr<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 153,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -filter=llvm::operator!=")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> boolean $noteq_T(/*const*/Optional<T> /*&*/ X, /*const*/Optional<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static </*typename*/ T, /*typename*/ U> boolean $noteq_T(/*const*/OptionalPtr<T> /*&*/ X, /*const*/OptionalPtr<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 162,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -filter=llvm::operator<",
 notes = Converted.Notes.FAILED)
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> boolean $less_T(/*const*/Optional<T> /*&*/ X, /*const*/Optional<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static </*typename*/ T, /*typename*/ U> boolean $less_T(/*const*/OptionalPtr<T> /*&*/ X, /*const*/OptionalPtr<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 171,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -filter=llvm::operator<=")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> boolean $lesseq_T(/*const*/Optional<T> /*&*/ X, /*const*/Optional<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static </*typename*/ T, /*typename*/ U> boolean $lesseq_T(/*const*/OptionalPtr<T> /*&*/ X, /*const*/OptionalPtr<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 180,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -filter=llvm::operator>=")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> void $greatereq_T(/*const*/Optional<T> /*&*/ X, /*const*/Optional<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 189,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -filter=llvm::operator>")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> void $greater_T(/*const*/Optional<T> /*&*/ X, /*const*/Optional<U> /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 169,
 FQN = "llvm::wrap", NM = "_ZN4llvm4wrapEPKNS_12MemoryBufferE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm4wrapEPKNS_12MemoryBufferE")
//</editor-fold>
public static /*inline*/ MemoryBuffer /*P*/ unwrap(LLVMMemoryBufferRef P) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 169,
 FQN = "llvm::wrap", NM = "_ZN4llvm4wrapEPKNS_12MemoryBufferE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm4wrapEPKNS_12MemoryBufferE")
//</editor-fold>
public static /*inline*/ LLVMMemoryBufferRef wrap(/*const*/MemoryBuffer /*P*/ P) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/

/// Construct an ArrayRef from a single element.
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 266,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/T /*&*/ OneElt) {
  return new ArrayRef(OneElt);
}
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/T /*&*/ OneElt, boolean isDataPointerLike) {
  return new ArrayRef(OneElt, isDataPointerLike);
}
public static ArrayRefUShort makeArrayRef_ushort(/*const*//*ushort*/char /*&*/ ...Elt) {
  return new ArrayRefUShort(Elt);
}
public static ArrayRefUShort makeArrayRef_TokenKind(/*const*//*tok.TokenKind*/char /*&*/ ...Elt) {
  return new ArrayRefUShort(Elt);
}
public static ArrayRefUShort makeArrayRef_ushort(char$ptr data) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/

/// Construct an ArrayRef from a pointer and length.
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 272,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/T /*P*/ data, /*size_t*/int length) {
  switch (length) {
    case 0:
      return new ArrayRef(create_type$null$ptr(), 0);
    case 1:
      return new ArrayRef(data);
    default:
      throw new IllegalArgumentException("Consider calling makeArrayRef with pointer!");
  }
}

public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/type$ptr<T> /*P*/ data, /*size_t*/int length) {
  return makeArrayRef(data, length, true/*this is pointers*/);
}

public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/type$ptr<T> /*P*/ data, /*size_t*/int length, boolean isPointerLike) {
  return new ArrayRef(data, length, isPointerLike);
}

public static ArrayRefUInt makeArrayRef(/*const*/uint$ptr /*P*/ begin, /*size_t*/int length) {
  return new ArrayRefUInt(begin, length);
}

public static ArrayRefChar makeArrayRef(/*const*/char$ptr /*P*/ begin, /*size_t*/int length) {
  return new ArrayRefChar(begin, length);
}

public static ArrayRefUChar makeArrayRef(/*const*/uchar$ptr /*P*/ begin, /*size_t*/int length) {
  return new ArrayRefUChar(begin, length);
}

public static ArrayRefUChar makeArrayRef$UChar(/*const*/uchar$ptr /*P*/ begin, /*size_t*/int length) {
  return new ArrayRefUChar(begin, length);
}

public static ArrayRefUChar makeArrayRef$UChar(/*const*/uchar$ptr /*P*/ begin, /*size_t*/int length, boolean isDataPointerLike) {
  assert isDataPointerLike == false;
  return new ArrayRefUChar(begin, length, isDataPointerLike);
}

public static ArrayRefChar makeArrayRef$Char(/*const*/char$ptr /*P*/ begin, /*size_t*/int length) {
  return new ArrayRefChar(begin, length);
}

public static ArrayRefChar makeArrayRef$Char(/*const*/char$ptr /*P*/ begin, /*size_t*/int length, boolean isDataPointerLike) {
  assert isDataPointerLike == false;
  return new ArrayRefChar(begin, length, isDataPointerLike);
}

public static ArrayRefUInt makeArrayRef(int[] a, /*size_t*/int length) {
  return new ArrayRefUInt(a, length);
}

public static ArrayRefULong makeArrayRef(/*const*/ulong$ptr /*P*/ begin, /*size_t*/int length) {
  return new ArrayRefULong(begin, length);
}

public static ArrayRefUInt makeArrayRef(SmallVectorImplUInt Vec) {
  return new ArrayRefUInt(Vec);
}

public static ArrayRefUInt makeArrayRef$UInt(SmallVectorImplUInt Vec) {
  return new ArrayRefUInt(Vec);
}

public static ArrayRefUInt makeArrayRef$UInt(int value) {
  return new ArrayRefUInt(value);
}

public static ArrayRefUInt makeArrayRef$UInt(int value, boolean isDataPointerLike) {
  return new ArrayRefUInt(value, isDataPointerLike);
}

/*template <typename T> TEMPLATE*/

/// Construct an ArrayRef from a range.
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 278,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/type$iterator<?, T> /*P*/ begin, /*const*/type$iterator<?, T> /*P*/ end) {  
  throw new UnsupportedOperationException("EmptyBody");
}
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/std.vector.iterator<T> /*P*/ begin, /*const*/std.vector.iterator<T> /*P*/ end, boolean isDataPointerLike) {
  return new ArrayRef<>(begin.toPointer(), std.distance(begin, end), isDataPointerLike);
}

/// Construct an ArrayRef from a range.
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 278,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/type$ptr<T> /*P*/ begin, /*const*/type$ptr<T> /*P*/ end) {
  return new ArrayRef<>(begin, end);
}

public static ArrayRefUInt makeArrayRef(/*const*/uint$ptr /*P*/ begin, /*const*/uint$ptr /*P*/ end) {
  return new ArrayRefUInt(begin, end);
}

/*template <typename T> TEMPLATE*/

/// Construct an ArrayRef from a SmallVector.
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 284,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/SmallVectorImpl<T> /*&*/ Vec) {
  return new ArrayRef(Vec);
}
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/SmallVectorImpl<T> /*&*/ Vec, boolean isDataPointerLike) {
  return new ArrayRef(Vec, isDataPointerLike);
}

/*template <typename T, unsigned int N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 290,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef",
 notes = Converted.Notes.FAILED)
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/SmallVector<T/*, N*/> /*&*/ Vec, /*uint*/int N) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/

/// Construct an ArrayRef from a std::vector.
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 296,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/std.vector<T> /*&*/ Vec) {
  return new ArrayRef(Vec);
}

/*template <typename T, size_t N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 302,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/T[] arr, /*size_t*/int N) {
  assert N >= 0;
  return new ArrayRef<T>(arr, N);
}
/*template <typename T, size_t N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 302,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/T[] arr) {
  assert arr != null;
  return new ArrayRef<T>(arr, arr.length);
}
public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/T[] arr, boolean isDataPointerLike) {
  assert arr != null;
  return new ArrayRef<T>(arr, arr.length, isDataPointerLike);
}
public static </*typename*/ T> ArrayRef<T> makeArrayRef(int size, /*const*/T[] arr, boolean isDataPointerLike) {
  assert arr != null;
  assert size == arr.length;
  return new ArrayRef<T>(arr, arr.length, isDataPointerLike);
}

/*template <typename T, size_t N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 302,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::makeArrayRef")
//</editor-fold>
public static ArrayRefULong makeArrayRef$ULong(/*const*//*ulong*/SmallVectorImplULong V) {
  return new ArrayRefULong(V.$array(), V.size());
}
public static ArrayRefULong makeArrayRef$ULong(/*const*//*ulong*/long[] arr) {
  return makeArrayRef$ULLong(arr, arr.length);
}
public static ArrayRefULong makeArrayRef$ULong(/*const*//*ulong*/long[] arr, /*size_t*/int N) {
  assert N >= 0 : "must be non negative " + N;  
  return new ArrayRefULong(arr, N);
}
public static ArrayRefULong makeArrayRef$ULong(/*const*//*ulong*/ulong$ptr arr, /*size_t*/int N) {
  assert N >= 0 : "must be non negative " + N;  
  return new ArrayRefULong(arr, N);
}

public static ArrayRefULong makeArrayRef$ULLong(/*const*//*ulong*/SmallVectorImplULong V) {
  return new ArrayRefULong(V.$array(), V.size());
}
public static ArrayRefULong makeArrayRef$ULLong(/*const*//*ulong*/long[] arr) {
  return makeArrayRef$ULLong(arr, arr.length);
}
public static ArrayRefULong makeArrayRef$ULLong(/*const*//*ulong*/long[] arr, /*size_t*/int N) {
  assert N >= 0 : "must be non negative " + N;  
  return new ArrayRefULong(arr, N);
}
public static ArrayRefULong makeArrayRef$ULLong(/*const*//*ulong*/ulong$ptr arr, /*size_t*/int N) {
  assert N >= 0 : "must be non negative " + N;  
  return new ArrayRefULong(arr, N);
}
/*template <typename T> TEMPLATE*/

/// @}
/// @name ArrayRef Comparison Operators
/// @{
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 311,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::operator==")
//</editor-fold>
public static /*inline*/ </*typename*/ T> boolean $eq_T(ArrayRef<T> LHS, ArrayRef<T> RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 316,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::operator!=")
//</editor-fold>
public static /*inline*/ </*typename*/ T> boolean $noteq_T(ArrayRef<T> LHS, ArrayRef<T> RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 180,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -filter=llvm::operator==")
//</editor-fold>
public static </*typename*/ PT1, /*typename*/ PT2> boolean $eq_T(PointerUnion<PT1, PT2> lhs, PointerUnion<PT1, PT2> rhs) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 188,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", old_line = 186,
 FQN = "llvm::operator==", NM = "Tpl__ZN4llvmeqENS_12PointerUnionIT_T0_EES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvmeqENS_12PointerUnionIT_T0_EES3_")
//</editor-fold>
public static </*typename*/ PT1, /*typename*/ PT2> boolean $noteq_T(PointerUnion<PT1, PT2> lhs, PointerUnion<PT1, PT2> rhs) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1735,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1722,
 FQN = "llvm::operator==", NM = "_ZN4llvmeqEyRKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmeqEyRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean $eq_uint64_t_APInt(long/*uint64_t*/ V1, /*const*/APInt /*&*/ V2) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1737,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1724,
 FQN = "llvm::operator!=", NM = "_ZN4llvmneEyRKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmneEyRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean $noteq_uint64_t_APInt(long/*uint64_t*/ V1, /*const*/APInt /*&*/ V2) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1739,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1726,
 FQN = "llvm::operator<<", NM = "_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_APInt(raw_ostream /*&*/ OS, /*const*/APInt /*&*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class T> TEMPLATE*/

// deleter - Very very very simple method that is used to invoke operator
// delete on something.  It is used like this:
//
//   for_each(V.begin(), B.end(), deleter<Interval>);
//
//<editor-fold defaultstate="collapsed" desc="llvm::deleter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 62,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::deleter")
//</editor-fold>
public static /*inline*/ </*class*/ T> void deleter(T /*P*/ Ptr) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class _Iterator, class Func> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 129,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::operator+")
//</editor-fold>
public static /*inline*/ </*class*/ FromType, /*class*/ ToType> mapped_iterator<FromType, ToType> $add_T( int /*mapped_iterator<_Iterator, Func>.difference_type*/ N, /*const*/mapped_iterator<FromType, ToType> /*&*/ X) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class ItTy, class FuncTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::map_iterator">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 207,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 194,
 FQN="llvm::map_iterator", NM="Tpl__ZN4llvm12map_iteratorERKT_T0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm12map_iteratorERKT_T0_")
//</editor-fold>
public static /*inline*/ </*class*/ FromType, /*class*/ ToType> 
        mapped_iterator<FromType, ToType> 
        map_iterator(/*const*/type$iterator<?, FromType> /*&*/ I, Converter<FromType, ToType> F) {
  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
    map_iterator(I, F);
}

/*template <typename ItTy, typename Dist> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::next">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 154,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::next")
//</editor-fold>
public static /*inline*/ </*typename*/ ItTy, /*typename*/ Dist> ItTy next(ItTy it, Dist n) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename ItTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::next">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 161,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::next")
//</editor-fold>
public static /*inline*/ </*typename*/ ItTy> ItTy next(ItTy it) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename ItTy, typename Dist> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::prior">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 167,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::prior")
//</editor-fold>
public static /*inline*/ </*typename*/ ItTy, /*typename*/ Dist> ItTy prior(ItTy it, Dist n) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename ItTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::prior">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 174,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::prior")
//</editor-fold>
public static /*inline*/ </*typename*/ ItTy> ItTy prior(ItTy it) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class T, std::size_t N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::array_endof">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 244,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::array_endof")
//</editor-fold>
public static /*inline*/ </*class*/ T> type$ptr<T> /*P*/ array_endof(T[] x) {
  return NativePointer.create_type$ptr(x, x.length);
}
public static /*inline*/ int$ptr /*P*/ array_endof(int[] x) {
  return NativePointer.create_int$ptr(x, x.length);
}

/*template <class T, std::size_t N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::array_lengthof">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 250,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::array_lengthof")
//</editor-fold>
//public static /*inline*/ </*class*/ T, /*uint*/int N> /*size_t*/int array_lengthof(T (/*&*/ $Prm0)[N]) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
public static int array_lengthof(Object[] arr) {
  return arr.length;
}
public static int array_lengthof(byte[] arr) {
  return arr.length;
}
public static int array_lengthof(boolean[] arr) {
  return arr.length;
}
public static int array_lengthof(long[] arr) {
  return arr.length;
}
public static int array_lengthof(int[] arr) {
  return arr.length;
}
public static int array_lengthof(String arr) {
  return arr.length();
}
/*template <typename T> TEMPLATE*/

/// array_pod_sort_comparator - This is helper function for array_pod_sort,
/// which just uses operator< on T.
//<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort_comparator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 170,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 257,
 FQN = "llvm::mapped_iterator::operator[]", NM = "_ZNK4llvm15mapped_iteratorixENSt15iterator_traitsIT_E15difference_typeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm15mapped_iteratorixENSt15iterator_traitsIT_E15difference_typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> int array_pod_sort_comparator(/*const*/T/*void P*/ P1, /*const*/T/*void P*/ P2) {
  if (Native.$less(P1, P2)) {
    return -1;
  }
  if (Native.$less(P2, P1)) {
    return 1;
  }
  return 0;
}

private static final Comparator<?> array_pod_sort_comparatorCallback = new Comparator() {

  @Override
  public int compare(Object o1, Object o2) {
    return array_pod_sort_comparator(o1, o2);
  }
};
        
/*template <typename T> TEMPLATE*/

/// get_array_pod_sort_comparator - This is an internal helper function used to
/// get type deduction of T right.
//<editor-fold defaultstate="collapsed" desc="llvm::get_array_pod_sort_comparator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 183,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 268,
 FQN = "llvm::operator+", NM = "Tpl__ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=Tpl__ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> Comparator<T> get_array_pod_sort_comparator(/*const*/T /*&*/ $Prm0) {
  return (Comparator<T>)array_pod_sort_comparatorCallback;
}

/*template <class IteratorTy> TEMPLATE*/

/// array_pod_sort - This sorts an array with the specified start and end
/// extent.  This is just like std::sort, except that it calls qsort instead of
/// using an inlined template.  qsort is slightly slower than std::sort, but
/// most sorts are not performance critical in LLVM and std::sort has to be
/// template instantiated for each type, leading to significant measured code
/// bloat.  This function should generally be used instead of std::sort where
/// possible.
///
/// This function assumes that you have simple POD-like types that can be
/// compared with operator< and can be moved with memcpy.  If this isn't true,
/// you should use std::sort.
///
/// NOTE: If qsort_r were portable, we could allow a custom comparator and
/// default to std::less.
//<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 289,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::array_pod_sort")
//</editor-fold>
public static /*inline*/ </*class*/ T> void array_pod_sort(type$ptr<T> Start, type$ptr<T> End) {
  // Don't dereference start iterator of empty sequence.
  if (Native.$eq_ptr(Start, End)) {
    return;
  }
  qsort($AddrOf(Start), End.$sub(Start), /*NativeType.sizeof(Start.$star())*/-1, get_array_pod_sort_comparator(Start.$star()));
//  qsort(/*AddrOf*/Start.$star(), End - Start, sizeof (Start.$star()), 
//      get_array_pod_sort_comparator(Start.$star()));
}
public static /*inline*/ void array_pod_sort(uint$ptr Start, uint$ptr End) {
  if (std.distance(Start, End) < 2) {
    return;
  }  
  stable_sort($AddrOf(Start), End, (Integer f, Integer s)->(Unsigned.$compare_uint(f, s) < 0));
}

/*template <class IteratorTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 297,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::array_pod_sort")
//</editor-fold>
public static /*inline*/ <T> void array_pod_sort(type$ptr<T> Start, type$ptr<T> End, 
              Comparator<T> Compare) {
  // Don't dereference start iterator of empty sequence.
  if (std.distance(Start, End) < 2) {
    return;
  }
  qsort($AddrOf(Start), End.$sub(Start), /*NativeType.sizeof(Start.$star())*/-1, Compare);
}
public static /*inline*/ <T> void array_pod_sort(type$ptr<T> Start, type$ptr<T> End, 
              CompareTypePtr<T> Compare) {
  array_pod_sort(Start, End, (Comparator<T>)Compare);
}
public static /*inline*/ <T> void array_pod_sort(type$iterator<?,T> Start, type$iterator<?,T> End) {  
  array_pod_sort(Start, End, Native::compare$less$Objects);
}

public static /*inline*/ <T> void array_pod_sort(type$iterator<?,T> Start, type$iterator<?,T> End, 
              Comparator<T> Compare) {
  int distance = std.distance(Start, End);
  if (distance < 2) {
    return;
  }
  std.qsort(Start, End, Compare);
}

/*template <typename Container> TEMPLATE*/

/// For a container of pointers, deletes the pointers and then clears the
/// container.
//<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerPointers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 287,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 315,
 FQN = "llvm::array_pod_sort_comparator", NM = "Tpl__ZN4llvm25array_pod_sort_comparatorEPKvS1_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=Tpl__ZN4llvm25array_pod_sort_comparatorEPKvS1_")
//</editor-fold>
public static </*typename*/ Container> void DeleteContainerPointers(Container /*&*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename Container> TEMPLATE*/

/// In a container of pairs (usually a map) whose second element is a pointer,
/// deletes the second elements and then clears the container.
//<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerSeconds">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 324,
// cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::DeleteContainerSeconds")
////</editor-fold>
//public static </*typename*/ Container> void DeleteContainerSeconds(Container /*&*/ C) {
//  throw new UnsupportedOperationException("EmptyBody");
//}
public static void DeleteContainerSeconds(DenseMapIntType<?> /*&*/ C) {
  for (DenseMapIteratorIntType<?> I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
    Native.destroy(I.$star().second);
  }
  C.clear();
}
public static void DeleteContainerSeconds(DenseMap<?, ?> /*&*/ C) {
  for (DenseMapIterator<?, ?> I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
    Native.destroy(I.$star().second);
  }
  C.clear();
}

/// In a container of pairs (usually a map) whose second element is a pointer,
/// deletes the second elements and then clears the container.
//<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerSeconds">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 324,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::DeleteContainerSeconds")
//</editor-fold>
public static void DeleteContainerSeconds(StringMap /*&*/ C) {
  for (StringMapIterator I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
    Native.destroy(I.$star().second);
  }
  C.clear();
}
public static void DeleteContainerSeconds(MapVectorPtrPtr /*&*/ C) {
  for (std.vector.iterator<std.pairPtrPtr> I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
    Native.destroy(I.$star().second);
  }
  C.clear();
}

/// hexdigit - Return the hexadecimal character for the
/// given number \p X (which should be less than 16).
//<editor-fold defaultstate="collapsed" desc="llvm::hexdigit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 26,
 FQN = "llvm::hexdigit", NM = "_ZN4llvmL8hexdigitEjb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvmL8hexdigitEjb")
//</editor-fold>
public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X) {
  return hexdigit(X, false);
}
public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X, boolean LowerCase/*= false*/) {
  /*const*//*char*/byte HexChar = (byte) (LowerCase ? 'a' : 'A');
  return (byte) (X < 10 ? '0' + X : HexChar + X - 10);
}


/// Interpret the given character \p C as a hexadecimal digit and return its
/// value.
///
/// If \p C is not a valid hex digit, -1U is returned.
//<editor-fold defaultstate="collapsed" desc="llvm::hexDigitValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 40,
 FQN="llvm::hexDigitValue", NM="_ZN4llvmL13hexDigitValueEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvmL13hexDigitValueEc")
//</editor-fold>
public static /*inline*/ /*uint*/int hexDigitValue(/*char*/byte C) {
  if (C >= $$0 && C <= $$9) {
    return C - $$0;
  }
  if (C >= $$a && C <= $$f) {
    return C - $$a + 10/*U*/;
  }
  if (C >= $$A && C <= $$F) {
    return C - $$A + 10/*U*/;
  }
  return -1/*U*/;
}

/*template <typename IntTy> TEMPLATE*/

/// utohex_buffer - Emit the specified number into the buffer specified by
/// BufferEnd, returning a pointer to the start of the string.  This can be used
/// like this: (note that the buffer must be large enough to handle any number):
///    char Buffer[40];
///    printf("0x%s", utohex_buffer(X, Buffer+40));
///
/// This should only be used with unsigned types.
///
//<editor-fold defaultstate="collapsed" desc="llvm::utohex_buffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 51,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::utohex_buffer")
//</editor-fold>
public static /*inline*/ </*typename*/ IntTy> char$ptr/*char P*/ utohex_buffer(IntTy X, char$ptr/*char P*/ BufferEnd) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::utohexstr">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 67,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::utohexstr")
//</editor-fold>
public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X) {
  return new std.string(ULongToUnsignedString(X, 16));
}

//<editor-fold defaultstate="collapsed" desc="llvm::utostr_32">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 77,
 FQN = "llvm::utostr_32", NM = "_ZN4llvmL9utostr_32Ejb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvmL9utostr_32Ejb")
//</editor-fold>
public static /*inline*/ std.string utostr_32(int/*uint32_t*/ X) {
  return utostr_32(X, false);
}
public static /*inline*/ std.string utostr_32(int/*uint32_t*/ X, boolean isNeg/*= false*/) {
  return utostr(X, isNeg);
}

//<editor-fold defaultstate="collapsed" desc="llvm::utostr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 93,
 FQN = "llvm::utostr", NM = "_ZN4llvmL6utostrEyb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvmL6utostrEyb")
//</editor-fold>
public static /*inline*/ std.string utostr(long/*uint64_t*/ X) {
  return utostr(X, false);
}
public static /*inline*/ std.string utostr(long/*uint64_t*/ X, boolean isNeg/*= false*/) {
  String text = ULongToUnsignedString(X, 10);
  if (isNeg) {
    text = "-" + text;
  }
  return new std.string(text);
}

//<editor-fold defaultstate="collapsed" desc="llvm::itostr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 94,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 109,
 FQN="llvm::itostr", NM="_ZN4llvmL6itostrEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL6itostrEx")
//</editor-fold>
public static /*inline*/ std.string itostr(long/*int64_t*/ X) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    itostr(X);
}


/// StrInStrNoCase - Portable version of strcasestr.  Locates the first
/// occurrence of string 's1' in string 's2', ignoring case.  Returns
/// the offset of s2 in s1 or npos if s2 cannot be found.

//<editor-fold defaultstate="collapsed" desc="llvm::StrInStrNoCase">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 21,
 FQN="llvm::StrInStrNoCase", NM="_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_")
//</editor-fold>
public static /*size_t*/int StrInStrNoCase(StringRef s1, StringRef s2) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    StrInStrNoCase(s1, s2);
}

public static final StringRef STRING_REF_DELIMETERS = new StringRef(" \t\n\013\014\015");

/// getToken - This function extracts one token from source, ignoring any
/// leading characters that appear in the Delimiters string, and ending the
/// token at any of the characters that appear in the Delimiters string.  If
/// there are no tokens in the source string, an empty string is returned.
/// The function returns a pair containing the extracted token and the
/// remaining tail string.
//<editor-fold defaultstate="collapsed" desc="llvm::getToken">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 37,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", old_line = 38,
 FQN = "llvm::getToken", NM = "_ZN4llvm8getTokenENS_9StringRefES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm8getTokenENS_9StringRefES0_")
//</editor-fold>
public static std.pair<StringRef, StringRef> getToken(StringRef Source) {
  return getToken(Source, 
        STRING_REF_DELIMETERS);
}
public static std.pair<StringRef, StringRef> getToken(StringRef Source, 
        StringRef Delimiters/*= " \t\n\013\014\015"*/) {
  // Figure out where the token starts.
  /*size_t*/int Start = Source.find_first_not_of(new StringRef(Delimiters));
  
  // Find the next occurrence of the delimiter.
  /*size_t*/int End = Source.find_first_of(new StringRef(Delimiters), Start);
  
  return std.make_pair(Source.slice(Start, End), Source.substr(End));
}

/// SplitString - Split up the specified string according to the specified
/// delimiters, appending the result fragments to the output list.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitString">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 50,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", old_line = 51,
 FQN = "llvm::SplitString", NM = "_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_")
//</editor-fold>
public static void SplitString(StringRef Source, 
           SmallVectorImpl<StringRef> /*&*/ OutFragments) {
  SplitString(Source, 
           OutFragments, 
           STRING_REF_DELIMETERS);
}
public static void SplitString(StringRef Source, 
           SmallVectorImpl<StringRef> /*&*/ OutFragments, 
           StringRef Delimiters/*= " \t\n\013\014\015"*/) {
  std.pair<StringRef, StringRef> S = getToken(new StringRef(Source), new StringRef(Delimiters));
  while (!S.first.empty()) {
    OutFragments.push_back(S.first);
    S.$assign(getToken(new StringRef(S.second), new StringRef(Delimiters)));
  }
}


/// HashString - Hash function for strings.
///
/// This is the Bernstein hash function.
//
// FIXME: Investigate whether a modified bernstein hash function performs
// better: http://eternallyconfuzzled.com/tuts/algorithms/jsw_tut_hashing.aspx
//   X*33+c -> X*33^c
//<editor-fold defaultstate="collapsed" desc="llvm::HashString">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 143,
 FQN = "llvm::HashString", NM = "_ZN4llvmL10HashStringENS_9StringRefEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvmL10HashStringENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ /*uint*/int HashString(StringRef Str) {
  return HashString(Str, 0);
}
public static /*inline*/ /*uint*/int HashString(StringRef Str, /*uint*/int Result/*= 0*/) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    HashString(Str, Result);
}
public static /*inline*/ /*uint*/int HashString(char$ptr Str, int KeyLen) {
  return HashString(Str, KeyLen, 0);
}
public static /*inline*/ /*uint*/int HashString(char$ptr Str, int KeyLen, /*uint*/int Result/*= 0*/) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    HashString(Str, KeyLen, Result);
}
public static /*inline*/ /*uint*/int HashString(byte Str[], int fromIdx, int KeyLen) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    HashString(Str, fromIdx, KeyLen);
}


/// Returns the English suffix for an ordinal integer (-st, -nd, -rd, -th).
//<editor-fold defaultstate="collapsed" desc="llvm::getOrdinalSuffix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 135,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 150,
 FQN="llvm::getOrdinalSuffix", NM="_ZN4llvmL16getOrdinalSuffixEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvmL16getOrdinalSuffixEj")
//</editor-fold>
public static /*inline*/ StringRef getOrdinalSuffix(/*uint*/int Val) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
          getOrdinalSuffix(Val);
}

/*template <typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 164,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::join_impl")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT> std.string join_impl(IteratorT Begin, IteratorT End, StringRef Separator, std.input_iterator_tag $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 179,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::join_impl")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT> std.string join_impl(IteratorT Begin, IteratorT End, StringRef Separator, std.forward_iterator_tag $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename IteratorT> TEMPLATE*/

/// Joins the strings in the range [Begin, End), adding Separator between
/// the elements.
//<editor-fold defaultstate="collapsed" desc="llvm::join">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 200,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::join")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT extends type$iterator<?, std.string>> std.string join(IteratorT Begin, IteratorT End, StringRef Separator) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    join(Begin, End, Separator);
}

/*template <typename T> TEMPLATE*/

  /// These are helper functions used to produce formatted output.  They use
  /// template type deduction to construct the appropriate instance of the
  /// format_object class to simplify their construction.
  ///
  /// This is typically used like:
  /// \code
  ///   OS << format("%0.4f", myfloat) << '\n';
  /// \endcode
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::format">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 111,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", old_line = 110,
   FQN="llvm::format", NM="Tpl__ZN4llvm6formatEPKcDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=Tpl__ZN4llvm6formatEPKcDpRKT_")
  //</editor-fold>
  public static /*inline*/ format_object format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ Object /*&*/ ... Vals) {
    return AdtsupportLlvmGlobals.format(Fmt, Vals);
  }

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static /*inline*/ String format_uint(/*const*/String/*char P*/ Fmt, /*const*//*uint*/uint$ptr /*&*/ Val) {
  return format_uint(Fmt, Val.$star());
}
public static /*inline*/ String format_uint(/*const*/String/*char P*/ Fmt, /*const*//*uint*/int /*&*/ Val) {
  // JAVA: helper sutable for the most cases
  try {
    return String.format(/*llvm.format(*/io.Cpp2JavaFormatString(Fmt), Val);
  } catch (UnknownFormatConversionException e) {
    // no luck with format string...
    NativeTrace.registerReason(e);
    NativeTrace.traceNotImplemented("This format string is not supported: " + Fmt);
    return Fmt;
  }  
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static /*inline*/ String format_uchar(/*const*/String/*char P*/ Fmt, /*const*//*uchar*/byte /*&*/ Val) {
  // JAVA: helper sutable for the most cases
  // JAVA: helper sutable for the most cases
  try {  
    return String.format(/*llvm.format(*/io.Cpp2JavaFormatString(Fmt), $uchar2uint(Val));
  } catch (UnknownFormatConversionException e) {
    // no luck with format string...
    NativeTrace.registerReason(e);
    NativeTrace.traceNotImplemented("This format string is not supported: " + Fmt);
    return Fmt;
  }  
}

public static /*inline*/ String format(/*const*/String/*char P*/ Fmt, /*const*/Object... /*&*/ Vals) {
  // JAVA: helper sutable for the most cases
  try {
    return String.format(/*llvm.format(*/io.Cpp2JavaFormatString(Fmt), io.prepareArgsForPrintf(Vals));
  } catch (UnknownFormatConversionException e) {
    // no luck with format string...
    NativeTrace.registerReason(e);
    NativeTrace.traceNotImplemented("This format string is not supported: " + Fmt);
    return Fmt;
  }
}

///*template <typename T1, typename T2> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 191,
// cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::format")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2> format_object2<T1, T2> format(/*const*/String/*char P*/ Fmt, /*const*/T1 /*&*/ Val1, /*const*/T2 /*&*/ Val2) {
//  // JAVA: helper sutable for the most cases
//  return String.format(/*llvm.format(*/Fmt, Val1, Val2);
//}
//
///*template <typename T1, typename T2, typename T3> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 203,
// cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::format")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3> format_object3<T1, T2, T3> format(/*const*/String/*char P*/ Fmt, /*const*/T1 /*&*/ Val1, /*const*/T2 /*&*/ Val2, /*const*/T3 /*&*/ Val3) {
//  // JAVA: helper sutable for the most cases
//  return String.format(/*llvm.format(*/Fmt, Val1, Val2, Val3);
//}
//
///*template <typename T1, typename T2, typename T3, typename T4> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 215,
// cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::format")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4> format_object4<T1, T2, T3, T4> format(/*const*/String/*char P*/ Fmt, /*const*/T1 /*&*/ Val1, /*const*/T2 /*&*/ Val2, /*const*/T3 /*&*/ Val3, /*const*/T4 /*&*/ Val4) {
//  // JAVA: helper sutable for the most cases
//  return String.format(/*llvm.format(*/Fmt, Val1, Val2, Val3, Val4);
//}
//
///*template <typename T1, typename T2, typename T3, typename T4, typename T5> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 228,
// cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -filter=llvm::format")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5> format_object5<T1, T2, T3, T4, T5> format(/*const*/String/*char P*/ Fmt, /*const*/T1 /*&*/ Val1, /*const*/T2 /*&*/ Val2, /*const*/T3 /*&*/ Val3, /*const*/T4 /*&*/ Val4, /*const*/T5 /*&*/ Val5) {
//  // JAVA: helper sutable for the most cases
//  return String.format(/*llvm.format(*/Fmt, Val1, Val2, Val3, Val4, Val5);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 328,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", old_line = 288,
 FQN = "llvm::operator==", NM = "_ZN4llvmeqExRKNS_6APSIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvmeqExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $eq_int64_t_APSInt(long/*int64_t*/ V1, /*const*/APSInt /*&*/ V2) {
  return AdtsupportLlvmGlobals.$eq_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 329,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", old_line = 291,
 FQN = "llvm::operator!=", NM = "_ZN4llvmneExRKNS_6APSIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvmneExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $noteq_int64_t_APSInt(long/*int64_t*/ V1, /*const*/APSInt /*&*/ V2) {
  return AdtsupportLlvmGlobals.$noteq_long_APSInt$C(V1, V2);
}

public static <T> boolean $noteq_ArrayRef$T(ArrayRef<T> a1, ArrayRef<T> a2) {
  return ! a1.equals(a2);
}

public static <T> boolean $noteq_ArrayRef$T(ArrayRefUInt a1, ArrayRefUInt a2) {
  return !$eq_ArrayRef$T(a1, a2);
}

public static std.string to_string(/*uint*/int Val) {
  return new std.string(Unsigned.UIntToUnsignedString(Val, 10));
}

/// acquire_global_lock - Acquire the global lock.  This is a no-op if called
/// before llvm_start_multithreaded().
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_acquire_global_lock">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Threading.h", line = 38,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -filter=llvm::llvm_acquire_global_lock")
//</editor-fold>
public static void llvm_acquire_global_lock() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// release_global_lock - Release the global lock.  This is a no-op if called
/// before llvm_start_multithreaded().
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_release_global_lock">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Threading.h", line = 42,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -filter=llvm::llvm_release_global_lock")
//</editor-fold>
public static void llvm_release_global_lock() {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Capacity.h", line = 23,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -filter=llvm::capacity_in_bytes")
//</editor-fold>
public static <T extends NativeType.SizeofCapable> /*size_t*/int capacity_in_bytes(T X) {
  return X.$sizeof();
}

///*template <typename KeyT, typename ValueT, typename KeyInfoT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1051,
// cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -filter=llvm::capacity_in_bytes")
////</editor-fold>
//public static /*inline*/ /*size_t*/int capacity_in_bytes(/*const*/ DenseMap<?, ?> /*&*/ X) {
//  return X.getMemorySize();
//}
//
//public static /*inline*/ /*size_t*/int capacity_in_bytes(/*const*/ DenseSet<?> /*&*/ X) {
//  return X.getMemorySize();
//}
//
///*template <typename T, unsigned int N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 922,
// cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -filter=llvm::capacity_in_bytes")
////</editor-fold>
//public static /*inline*/ /*size_t*/int capacity_in_bytes(/*const*/ SmallVectorImpl<?> /*&*/ X) {
//  return X.capacity_in_bytes();
//}

/**
* Convert an UTF8 StringRef to UTF8, UTF16, or UTF32 depending on
* WideCharWidth. The converted data is written to ResultPtr, which needs to
* point to at least WideCharWidth * (Source.Size() + 1) bytes. On success,
* ResultPtr will point one after the end of the copied string. On failure,
* ResultPtr will not be changed, and ErrorPtr will be set to the location of
* the first character which could not be converted.
* \return true on success.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::ConvertUTF8toWide">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 17,
 FQN = "llvm::ConvertUTF8toWide", NM = "_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh")
//</editor-fold>
public static boolean ConvertUTF8toWide(/*uint*/int WideCharWidth, StringRef Source, 
                 type$ref<char$ptr>/*char P&*/ ResultPtr, /*const*/type$ref<char$ptr>/*UTF8 P&*/ ErrorPtr) {
  assert (WideCharWidth == 1 || WideCharWidth == 2 || WideCharWidth == 4);
   ConversionResult result = ConversionResult.conversionOK;
  // Copy the character span over.
  if (WideCharWidth == 1) {
    /*const*/char$ptr/*UTF8 P*/ Pos = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Source.begin()));
    if (!(isLegalUTF8String(Pos.$addr(), reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Source.end())) != 0)) {
      result = ConversionResult.sourceIllegal;
      ErrorPtr.$set(Pos);
    } else {
      memcpy(ResultPtr.$deref(), Source.data(), Source.size());
      ResultPtr.$deref().$inc(Source.size());
    }
  } else if (WideCharWidth == 2) {
    /*const*/char$ptr/*UTF8 P*/ sourceStart = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Source.data()));
    // FIXME: Make the type of the result buffer correct instead of
    // using reinterpret_cast.
    ushort$ptr/*UTF16 P*/ targetStart = $tryClone(reinterpret_cast(ushort$ptr/*UTF16 P*/ .class, ResultPtr.$deref()));
     ConversionFlags flags = ConversionFlags.strictConversion;
    result = ConvertUTF8toUTF16(sourceStart.$addr(), sourceStart.$add(Source.size()), 
        targetStart.$addr(), targetStart.$add(Source.size()), flags);
    if (result == ConversionResult.conversionOK) {
      ResultPtr.$set(reinterpret_cast(char$ptr/*char P*/ .class, targetStart));
    } else {
      ErrorPtr.$set(sourceStart);
    }
  } else if (WideCharWidth == 4) {
    /*const*/char$ptr/*UTF8 P*/ sourceStart = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Source.data()));
    // FIXME: Make the type of the result buffer correct instead of
    // using reinterpret_cast.
    uint$ptr/*UTF32 P*/ targetStart = $tryClone(reinterpret_cast(uint$ptr/*UTF32 P*/ .class, ResultPtr.$deref()));
     ConversionFlags flags = ConversionFlags.strictConversion;
    result = ConvertUTF8toUTF32(sourceStart.$addr(), sourceStart.$add(Source.size()), 
        targetStart.$addr(), targetStart.$add(Source.size()), flags);
    if (result == ConversionResult.conversionOK) {
      ResultPtr.$set(reinterpret_cast(char$ptr/*char P*/ .class, targetStart));
    } else {
      ErrorPtr.$set(sourceStart);
    }
  }
  assert ((result != ConversionResult.targetExhausted)) : "ConvertUTF8toUTFXX exhausted target buffer";
  return result == ConversionResult.conversionOK;
}


/**
* Convert an Unicode code point to UTF8 sequence.
*
* \param Source a Unicode code point.
* \param [in,out] ResultPtr pointer to the output buffer, needs to be at least
* \c UNI_MAX_UTF8_BYTES_PER_CODE_POINT bytes.  On success \c ResultPtr is
* updated one past end of the converted sequence.
*
* \returns true on success.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::ConvertCodePointToUTF8">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 63,
 FQN="llvm::ConvertCodePointToUTF8", NM="_ZN4llvm22ConvertCodePointToUTF8EjRPc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm22ConvertCodePointToUTF8EjRPc")
//</editor-fold>
public static boolean ConvertCodePointToUTF8(/*uint*/int Source, type$ref<char$ptr>/*char P&*/ ResultPtr) {
  /*const*/uint$ptr/*UTF32 P*/ SourceStart = create_uint$ptr(new$uint$elem($AddrOf(Source)));
  /*const*/uint$ptr/*UTF32 P*/ SourceEnd = $tryClone(SourceStart.$add(1));
  char$ptr/*UTF8 P*/ TargetStart = $tryClone(reinterpret_cast(char$ptr/*UTF8 P*/ .class, ResultPtr.$deref()));
  char$ptr/*UTF8 P*/ TargetEnd = $tryClone(TargetStart.$add(4));
   ConversionResult CR = ConvertUTF32toUTF8(SourceStart.$addr(), SourceEnd, 
      TargetStart.$addr(), TargetEnd, 
      ConversionFlags.strictConversion);
  if (CR != ConversionResult.conversionOK) {
    return false;
  }
  
  ResultPtr.$set(reinterpret_cast(char$ptr/*char P*/ .class, TargetStart));
  return true;
}

/**
* Convert the first UTF8 sequence in the given source buffer to a UTF32
* code point.
*
* \param [in,out] source A pointer to the source buffer. If the conversion
* succeeds, this pointer will be updated to point to the byte just past the
* end of the converted sequence.
* \param sourceEnd A pointer just past the end of the source buffer.
* \param [out] target The converted code
* \param flags Whether the conversion is strict or lenient.
*
* \returns conversionOK on success
*
* \sa ConvertUTF8toUTF32
*/
//<editor-fold defaultstate="collapsed" desc="llvm::convertUTF8Sequence">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", line = 227,
 FQN = "llvm::convertUTF8Sequence", NM = "_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags")
//</editor-fold>
public static /*inline*/  ConversionResult convertUTF8Sequence(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ source, 
                   /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
                   int[]/*UTF32 P*/ CodePoint, 
                    ConversionFlags flags) {
  return convertUTF8Sequence(source, sourceEnd, create_uint$ptr(CodePoint), flags);
}

public static /*inline*/  ConversionResult convertUTF8Sequence(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ source, 
                   /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
                   uint$ptr/*UTF32*/ target, 
                    ConversionFlags flags) {
  if (source.$star().$eq(sourceEnd)) {
    return ConversionResult.sourceExhausted;
  }
  /*uint*/int size = getNumBytesForUTF8(source.$star().$star());
  if (size > sourceEnd.$sub(source.$star())) {
    return ConversionResult.sourceExhausted;
  }
  return ConvertUTF8toUTF32(source, source.$star().$add(size), target.$addr(), target.$add(1), flags);
}


/**
* Returns true if a blob of text starts with a UTF-16 big or little endian byte
* order mark.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::hasUTF16ByteOrderMark">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 81,
 old_source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", old_line = 78,
 FQN="llvm::hasUTF16ByteOrderMark", NM="_ZN4llvm21hasUTF16ByteOrderMarkENS_8ArrayRefIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm21hasUTF16ByteOrderMarkENS_8ArrayRefIcEE")
//</editor-fold>
public static boolean hasUTF16ByteOrderMark(ArrayRefChar S) {
  return ($greatereq_uint(S.size(), 2)
     && ((S.$at(0) == $$0xFF && S.$at(1) == $$0xFE)
     || (S.$at(0) == $$0xFE && S.$at(1) == $$0xFF)));
}


/**
* Converts a stream of raw bytes assumed to be UTF16 into a UTF8 std::string.
*
* \param [in] SrcBytes A buffer of what is assumed to be UTF-16 encoded text.
* \param [out] Out Converted UTF-8 is stored here on success.
* \returns true on success
*/
//<editor-fold defaultstate="collapsed" desc="llvm::convertUTF16ToUTF8String">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 84,
 FQN = "llvm::convertUTF16ToUTF8String", NM = "_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs")
//</editor-fold>
public static boolean convertUTF16ToUTF8String(ArrayRefChar SrcBytes, std.string /*&*/ Out) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::EnablePrettyStackTrace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 163,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 149,
 FQN="llvm::EnablePrettyStackTrace", NM="_ZN4llvm22EnablePrettyStackTraceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm22EnablePrettyStackTraceEv")
//</editor-fold>
public static void EnablePrettyStackTrace() {
  org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
          EnablePrettyStackTrace();
}


/// Returns the topmost element of the "pretty" stack state.
//<editor-fold defaultstate="collapsed" desc="llvm::SavePrettyStackState">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 171,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 157,
 FQN="llvm::SavePrettyStackState", NM="_ZN4llvm20SavePrettyStackStateEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm20SavePrettyStackStateEv")
//</editor-fold>
public static /*const*/Object/*void P*/ SavePrettyStackState() {
  return org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
          SavePrettyStackState();
}


/// Restores the topmost element of the "pretty" stack state to State, which
/// should come from a previous call to SavePrettyStackState().  This is
/// useful when using a CrashRecoveryContext in code that also uses
/// PrettyStackTraceEntries, to make sure the stack that's printed if a crash
/// happens after a crash that's been recovered by CrashRecoveryContext
/// doesn't have frames on it that were added in code unwound by the
/// CrashRecoveryContext.
//<editor-fold defaultstate="collapsed" desc="llvm::RestorePrettyStackState">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 179,
 old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 165,
 FQN="llvm::RestorePrettyStackState", NM="_ZN4llvm23RestorePrettyStackStateEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm23RestorePrettyStackStateEPKv")
//</editor-fold>
public static void RestorePrettyStackState(/*const*/Object/*void P*/ Top) {
  org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
          RestorePrettyStackState(Top);
}

private static final/*uint*/int SmallBufferSize = 64;

/*template <typename T> TEMPLATE*/

/// \brief Determine the edit distance between two sequences.
///
/// \param FromArray the first sequence to compare.
///
/// \param ToArray the second sequence to compare.
///
/// \param AllowReplacements whether to allow element replacements (change one
/// element into another) as a single operation, rather than as two operations
/// (an insertion and a removal).
///
/// \param MaxEditDistance If non-zero, the maximum edit distance that this
/// routine is allowed to compute. If the edit distance will exceed that
/// maximum, returns \c MaxEditDistance+1.
///
/// \returns the minimum number of element insertions, removals, or (if
/// \p AllowReplacements is \c true) replacements needed to transform one of
/// the given sequences into the other. If zero, the sequences are identical.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeEditDistance">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/edit_distance.h", line = 43,
 FQN = "llvm::ComputeEditDistance", NM = "Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj")
//</editor-fold>
public static /*uint*/int ComputeEditDistance(ArrayRefChar FromArray, ArrayRefChar ToArray) {
  return ComputeEditDistance(FromArray, ToArray, true, 0);
}
public static /*uint*/int ComputeEditDistance(ArrayRefChar FromArray, ArrayRefChar ToArray, boolean AllowReplacements/*= true*/) {
  return ComputeEditDistance(FromArray, ToArray, AllowReplacements, 0);
}
public static /*uint*/int ComputeEditDistance(ArrayRefChar FromArray, ArrayRefChar ToArray, boolean AllowReplacements/*= true*/, /*uint*/int MaxEditDistance/*= 0*/) {
  // The algorithm implemented below is the "classic"
  // dynamic-programming algorithm for computing the Levenshtein
  // distance, which is described here:
  //
  //   http://en.wikipedia.org/wiki/Levenshtein_distance
  //
  // Although the algorithm is typically described using an m x n
  // array, only two rows are used at a time, so this implemenation
  // just keeps two separate vectors for those two rows.
  /*size_t*/int m = FromArray.size();
  /*size_t*/int n = ToArray.size();

  int$ptr/*uint P*/ Previous;
  if (2*(n + 1) > SmallBufferSize) {
    Previous = create_int$ptr(new$int(2*(n+1)));
  } else {
    /*uint*/int SmallBuffer[/*64*/] = new$int(SmallBufferSize);
    Previous = create_int$ptr(SmallBuffer);
  }
  int$ptr/*uint P*/ Current = Previous.$add(n+1);

  for (/*uint*/int i = 0; i <= n; ++i)  {
    Previous.$set(i, i);
  }

  for (/*size_t*/int y = 1; y <= m; ++y) {
    Current.$set(0, y);
    /*uint*/int BestThisRow = Current.$at(0);

    for (/*size_t*/int x = 1; x <= n; ++x) {
      if (AllowReplacements) {
        Current.$set(x, std.min(
                            (Previous.$at(x - 1) + ((FromArray.$at(y - 1) == ToArray.$at(x - 1) ? 0/*U*/ : 1/*U*/))), 
                            (std.min(Current.$at(x - 1), Previous.$at(x)) + 1)
                        )
                    );
      } else {
        if ((FromArray.$at(y - 1) == ToArray.$at(x - 1))) {
          Current.$set(x, Previous.$at(x - 1));
        } else {
          Current.$set(x, (std.min(Current.$at(x - 1), Previous.$at(x)) + 1));
        }
      }
      BestThisRow = std.min(BestThisRow, Current.$at(x));
    }
    if ((MaxEditDistance != 0) && BestThisRow > MaxEditDistance) {
      return MaxEditDistance + 1;
    }

    int Current$Index = Current.$index();
    Native.$setIndex(Current, Previous.$index());
    Native.$setIndex(Previous, Current$Index);
  }

  /*uint*/int Result = Previous.$at(n);
  return Result;
}

@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/edit_distance.h", line = 43,
 FQN = "llvm::ComputeEditDistance", NM = "Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj")
//</editor-fold>
public static <T> /*uint*/int ComputeEditDistance(ArrayRef<T> FromArray, ArrayRef<T> ToArray) {
  return ComputeEditDistance(FromArray, ToArray, true, 0);
}
public static <T> /*uint*/int ComputeEditDistance(ArrayRef<T> FromArray, ArrayRef<T> ToArray, boolean AllowReplacements/*= true*/) {
  return ComputeEditDistance(FromArray, ToArray, AllowReplacements, 0);
}
public static <T> /*uint*/int ComputeEditDistance(ArrayRef<T> FromArray, ArrayRef<T> ToArray, boolean AllowReplacements/*= true*/, /*uint*/int MaxEditDistance/*= 0*/) {
  // The algorithm implemented below is the "classic"
  // dynamic-programming algorithm for computing the Levenshtein
  // distance, which is described here:
  //
  //   http://en.wikipedia.org/wiki/Levenshtein_distance
  //
  // Although the algorithm is typically described using an m x n
  // array, only two rows are used at a time, so this implemenation
  // just keeps two separate vectors for those two rows.
  /*size_t*/int m = FromArray.size();
  /*size_t*/int n = ToArray.size();

  int$ptr/*uint P*/ Previous;
  if (2*(n + 1) > SmallBufferSize) {
    Previous = create_int$ptr(new$int(2*(n+1)));
  } else {
    /*uint*/int SmallBuffer[/*64*/] = new$int(SmallBufferSize);
    Previous = create_int$ptr(SmallBuffer);
  }
  int$ptr/*uint P*/ Current = Previous.$add(n+1);

  for (/*uint*/int i = 0; i <= n; ++i)  {
    Previous.$set(i, i);
  }

  for (/*size_t*/int y = 1; y <= m; ++y) {
    Current.$set(0, y);
    /*uint*/int BestThisRow = Current.$at(0);

    for (/*size_t*/int x = 1; x <= n; ++x) {
      if (AllowReplacements) {
        Current.$set(x, std.min(
                            (Previous.$at(x - 1) + ((FromArray.$at(y - 1) == ToArray.$at(x - 1) ? 0/*U*/ : 1/*U*/))), 
                            (std.min(Current.$at(x - 1), Previous.$at(x)) + 1)
                        )
                    );
      } else {
        if ((FromArray.$at(y - 1) == ToArray.$at(x - 1))) {
          Current.$set(x, Previous.$at(x - 1));
        } else {
          Current.$set(x, (std.min(Current.$at(x - 1), Previous.$at(x)) + 1));
        }
      }
      BestThisRow = std.min(BestThisRow, Current.$at(x));
    }
    if ((MaxEditDistance != 0) && BestThisRow > MaxEditDistance) {
      return MaxEditDistance + 1;
    }

    int Current$Index = Current.$index();
    Native.$setIndex(Current, Previous.$index());
    Native.$setIndex(Previous, Current$Index);
  }

  /*uint*/int Result = Previous.$at(n);
  return Result;
}

/// InitializeAllTargetInfos - The main program should call this function if
/// it wants access to all available targets that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetInfos">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 53,
 FQN = "llvm::InitializeAllTargetInfos", NM = "_ZN4llvm24InitializeAllTargetInfosEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm24InitializeAllTargetInfosEv")
//</editor-fold>
public static /*inline*/ void InitializeAllTargetInfos() {
  NativeTrace.traceNotImplemented("llvm.InitializeAllTargetInfos");
//  LLVMInitializeR600TargetInfo();
//  LLVMInitializeSystemZTargetInfo();
//  LLVMInitializeHexagonTargetInfo();
//  LLVMInitializeNVPTXTargetInfo();
//  LLVMInitializeCppBackendTargetInfo();
//  LLVMInitializeMSP430TargetInfo();
//  LLVMInitializeXCoreTargetInfo();
//  LLVMInitializeMipsTargetInfo();
//  LLVMInitializeARMTargetInfo();
//  LLVMInitializeAArch64TargetInfo();
//  LLVMInitializePowerPCTargetInfo();
//  LLVMInitializeSparcTargetInfo();
//  LLVMInitializeX86TargetInfo();
}

/*template <class T> TEMPLATE*/

/// \brief Convenience function for iterating over sub-ranges.
///
/// This provides a bit of syntactic sugar to make using sub-ranges
/// in for loops a bit easier. Analogous to std::make_pair().
//<editor-fold defaultstate="collapsed" desc="llvm::make_range">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 54,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 47,
 FQN = "llvm::make_range", NM = "Tpl__ZN4llvm10make_rangeET_S0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=Tpl__ZN4llvm10make_rangeET_S0_")
//</editor-fold>
public static </*class*/ Iter extends type$iterator<?, Type>, Type> iterator_range<Type> make_range(Iter x, Iter y) {
  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
    make_range(x, y);
}
public static iterator_rangeUInt make_range(uint$iterator x, uint$iterator y) {
  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
    make_range(x, y);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::make_range">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 58,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 51,
 FQN = "llvm::make_range", NM = "Tpl__ZN4llvm10make_rangeESt4pairIT_S1_E",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=Tpl__ZN4llvm10make_rangeESt4pairIT_S1_E")
//</editor-fold>
public static </*class*/ Iter extends type$iterator<?, Type>, Type> iterator_range<Type> make_range(std.pair<Iter, Iter> p) {
  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
    make_range(p);
}

        
/// InitializeAllTargets - The main program should call this function if it
/// wants access to all available target machines that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargets">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 63,
 FQN = "llvm::InitializeAllTargets", NM = "_ZN4llvm20InitializeAllTargetsEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm20InitializeAllTargetsEv")
//</editor-fold>  
public static void InitializeAllTargets() {  
  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
    InitializeAllTargets();  
}

/// InitializeAllTargetMCs - The main program should call this function if it
/// wants access to all available target MC that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetMCs">
@Converted(kind = Converted.Kind.DUMMY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 76,
 FQN = "llvm::InitializeAllTargetMCs", NM = "_ZN4llvm22InitializeAllTargetMCsEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm22InitializeAllTargetMCsEv")
//</editor-fold>  
public static void InitializeAllTargetMCs() {
  NativeTrace.traceNotImplemented("llvm.InitializeAllTargetMCs");
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

/// InitializeAllAsmPrinters - The main program should call this function if
/// it wants all asm printers that LLVM is configured to support, to make them
/// available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllAsmPrinters">
@Converted(kind = Converted.Kind.DUMMY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 86,
 FQN = "llvm::InitializeAllAsmPrinters", NM = "_ZN4llvm24InitializeAllAsmPrintersEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm24InitializeAllAsmPrintersEv")
//</editor-fold>  
public static void InitializeAllAsmPrinters() {
  NativeTrace.traceNotImplemented("llvm.InitializeAllAsmPrinters");
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

/// InitializeAllAsmParsers - The main program should call this function if it
/// wants all asm parsers that LLVM is configured to support, to make them
/// available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllAsmParsers">
@Converted(kind = Converted.Kind.DUMMY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 96,
 FQN = "llvm::InitializeAllAsmParsers", NM = "_ZN4llvm23InitializeAllAsmParsersEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm23InitializeAllAsmParsersEv")
//</editor-fold>  
public static void InitializeAllAsmParsers() {
  NativeTrace.traceNotImplemented("llvm.InitializeAllAsmParsers");
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

/// \brief Enable the collection and printing of statistics.
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 90,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 92,
 FQN = "llvm::EnableStatistics", NM = "_ZN4llvm16EnableStatisticsEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm16EnableStatisticsEv")
//</editor-fold>
public static void EnableStatistics() {
  /*delegate*//*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
          EnableStatistics();
}

/// \brief Check if statistics are enabled.
//<editor-fold defaultstate="collapsed" desc="llvm::AreStatisticsEnabled">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 94,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 96,
 FQN = "llvm::AreStatisticsEnabled", NM = "_ZN4llvm20AreStatisticsEnabledEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm20AreStatisticsEnabledEv")
//</editor-fold>
public static boolean AreStatisticsEnabled() {
  return /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
          AreStatisticsEnabled();
}

/// \brief Print statistics to the file returned by CreateInfoOutputFile().
//<editor-fold defaultstate="collapsed" desc="llvm::PrintStatistics">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 139,
 FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsEv")
//</editor-fold>
public static void PrintStatistics() {
  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
    PrintStatistics();
}

/// \brief Print statistics to the given output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::PrintStatistics">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 100,
 FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE")
//</editor-fold>
public static void PrintStatistics(raw_ostream /*&*/ OS) {
  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
    PrintStatistics(OS);
}

/// llvm_shutdown - Deallocate and destroy all ManagedStatic variables.

/// llvm_shutdown - Deallocate and destroy all ManagedStatic variables.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_shutdown">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", line = 86,
 old_source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", old_line = 85,
 FQN = "llvm::llvm_shutdown", NM = "_ZN4llvm13llvm_shutdownEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm13llvm_shutdownEv")
//</editor-fold>
public static void llvm_shutdown() {
  while ((StaticList != null)) {
    StaticList.destroy();
  }
  assert StaticList == null;
  // JAVA: destory other temporaries
  TimerStatics.java$shutdown();
  StatisticLlvmGlobals.java$shutdown();
  ThreadingLlvmGlobals.java$shutdown();
  ClGlobals.java$shutdown();
  llvm.outs().flush();
  llvm.errs().flush();
}

/// llvm_shutdown_obj - This is a simple helper class that calls
/// llvm_shutdown() when it is destroyed.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_shutdown_obj">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 104,
 FQN = "llvm::llvm_shutdown_obj", NM = "_ZN4llvm17llvm_shutdown_objE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm17llvm_shutdown_objE")
//</editor-fold>
public static class/*struct*/ llvm_shutdown_obj implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::llvm_shutdown_obj::llvm_shutdown_obj">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 105,
   FQN = "llvm::llvm_shutdown_obj::llvm_shutdown_obj", NM = "_ZN4llvm17llvm_shutdown_objC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm17llvm_shutdown_objC1Ev")
  //</editor-fold>
  public llvm_shutdown_obj() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::llvm_shutdown_obj::~llvm_shutdown_obj">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 106,
   FQN = "llvm::llvm_shutdown_obj::~llvm_shutdown_obj", NM = "_ZN4llvm17llvm_shutdown_objD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm17llvm_shutdown_objD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm_shutdown();
  }

}

//<editor-fold defaultstate="collapsed" desc="static type support">
@Converted(kind = Converted.Kind.AUTO, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -namespace=llvm::support")
//</editor-fold>
public static final class support {

//<editor-fold defaultstate="collapsed" desc="llvm::support::endianness">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 23,
 FQN = "llvm::support::endianness", NM = "_ZN4llvm7support10endiannessE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm7support10endiannessE")
//</editor-fold>
public enum endianness {
  big(0),
  little(1),
  __native(2);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static endianness valueOf(int val) {
    endianness out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final endianness[] VALUES;
    private static final endianness[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (endianness kind : endianness.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new endianness[min < 0 ? (1-min) : 0];
      VALUES = new endianness[max >= 0 ? (1+max) : 0];
      for (endianness kind : endianness.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private endianness(/*uint*/int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}
  //</editor-fold>
}

// These are named values for common alignments.
// From: ${LLVM_SRC}/llvm/include/llvm/Support/Endian.h:27:1
/*enum ANONYMOUS_HEX_CONSTANTS {*/
  public static final int aligned = 0;
  public static final int unaligned = 1;
/*}*/
//JAVA: namespace detail {
public static final class detail {
  
  // We call out to an external function to actually print the message as the
  // printing code uses Allocator.h in its implementation.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::printBumpPtrAllocatorStats">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Allocator.cpp", line = 21,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Allocator.cpp", old_line = 26,
   FQN = "llvm::detail::printBumpPtrAllocatorStats", NM = "_ZN4llvm6detail26printBumpPtrAllocatorStatsEjjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm6detail26printBumpPtrAllocatorStatsEjjj")
  //</editor-fold>
  public static void printBumpPtrAllocatorStats(/*uint*/int NumSlabs, /*size_t*/int BytesAllocated, 
                            /*size_t*/int TotalMemory) {
    printBumpPtrAllocatorStats("", errs(), NumSlabs, BytesAllocated, TotalMemory, 0, 0);
  }
  // JAVA: pass OS, SizeThreshold, and SlabSize and return some integral value
  public static long printBumpPtrAllocatorStats(String container, raw_ostream /*&*/ OS, /*uint*/int NumSlabs, /*size_t*/int BytesAllocated,
                            /*size_t*/long TotalMemory, /*size_t*/int SizeThreshold, /*size_t*/int SlabSize) {
    String valueName = container.isEmpty() ? "BumpPtrAllocatedBytes" : container;
    NativeTrace.dumpStatisticValue(container, BytesAllocated);
    OS.$out("\nNumber of memory regions: ")
            .$out(NativeTrace.formatNumber(NumSlabs)).$out_char($('\n'))
            .$out("Bytes      used: ")
            .$out(NativeTrace.formatNumber(BytesAllocated))
            .$out_char($('\n'))
            .$out("Bytes allocated: ")
            .$out(NativeTrace.formatNumber((TotalMemory)))
            .$out_char($('\n'))
            .$out("Bytes    wasted: ")
            .$out(NativeTrace.formatNumber((TotalMemory - BytesAllocated)))
            .$out(" (includes alignment, etc)\n");
    if (SizeThreshold > 0) {
          OS.$out("SizeThreashold : ").$out(NativeTrace.formatNumber(SizeThreshold)).$out_char($$LF)
            .$out("SlabSize       : ").$out(NativeTrace.formatNumber(SlabSize)).$out_char($$LF);
    }
    return BytesAllocated;
  }

  /// \brief ::value is either alignment, or alignof(T) if alignment is 0.
  /*template <class T, int alignment> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::support::detail::PickAlignment">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 31,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::support::detail::PickAlignment")
//  //</editor-fold>
//  public static class/*struct*/ PickAlignment</*class*/ T, int alignment>  {
//    //<editor-fold defaultstate="collapsed" desc="llvm::support::detail::PickAlignment::<anonymous>">
//    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 33,
//     cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::support::detail::PickAlignment::<anonymous>")
//    //</editor-fold>
//    public enum Unnamed_enum {
//      value(alignment == 0 ? AlignOf<T>.Alignment : alignment);
//
//      //<editor-fold defaultstate="collapsed" desc="hidden">
//      public static Unnamed_enum valueOf(int val) {
//        Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
//        assert out != null : "no value for " + val;
//        return out;
//      }
//
//      private static final class Values {
//        private static final Unnamed_enum[] VALUES;
//        private static final Unnamed_enum[] _VALUES; // [0] not used
//        static {
//          int max = 0;
//          int min = 0;
//          for (Unnamed_enum kind : Unnamed_enum.values()) {
//            if (kind.value > max) { max = kind.value; }
//            if (kind.value < min) { min = kind.value; }
//          }
//          _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
//          VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
//          for (Unnamed_enum kind : Unnamed_enum.values()) {
//            if (kind.value < 0) {
//              _VALUES[-kind.value] = kind;
//            } else {
//              VALUES[kind.value] = kind;
//            }
//          }
//        }
//      }
//
//      private final int value;
//      private Unnamed_enum(/*uint*/int val) { this.value = (int)val;}
//      public int getValue() { return (int)value;}
//      //</editor-fold>
//    };
//  };

/*template <typename value_type, endianness endian, std::size_t alignment> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::detail::packed_endian_specific_integral">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 172,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 82,
 FQN = "llvm::support::detail::packed_endian_specific_integral", NM = "_ZN4llvm7support6detail31packed_endian_specific_integralE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm7support6detail31packed_endian_specific_integralE")
//</editor-fold>
public static class/*struct*/ packed_endian_specific_integral</*typename*/ value_type>  {
  private final char$ptr Buffer;
  private final Class<value_type> Type;
  private final endianness endian;
  /*uint*/int alignment;

  public packed_endian_specific_integral(char$ptr Buffer, Class<value_type> Type, endianness endian, /*uint*/int alignment) {
    this.Buffer = Buffer;
    this.Type = Type;
    this.endian = endian;
    this.alignment = alignment;
  }
    
  //<editor-fold defaultstate="collapsed" desc="llvm::support::detail::packed_endian_specific_integral::operator type-parameter-0-0">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 86,
   FQN = "llvm::support::detail::packed_endian_specific_integral::operator type-parameter-0-0", NM = "_ZNK4llvm7support6detail31packed_endian_specific_integralcvT_Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::support::detail::packed_endian_specific_integral::operator type-parameter-0-0")
  //</editor-fold>
  public value_type $value() /*const*/ {
    return support.endian.read(Type, endian, alignment, Buffer);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::support::detail::packed_endian_specific_integral::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 91,
   FQN = "llvm::support::detail::packed_endian_specific_integral::operator=", NM = "_ZN4llvm7support6detail31packed_endian_specific_integralaSET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm7support6detail31packed_endian_specific_integralaSET_")
  //</editor-fold>
  public void $assign(value_type newValue) {
    support.endian.write(Buffer, newValue, Type, endian, alignment);
  }

/*private:*/
//  private AlignedCharArray<PickAlignment<value_type, alignment>.value, sizeof(value_type)> Value;
}
//} JAVA: end of class packed_endian_specific_integral
}
//} JAVA: end of namespace detail

//JAVA: namespace endian {
public static final class endian extends EndianGlobals {
}
//} JAVA: end of namespace endian

/*typedef detail::packed_endian_specific_integral<uint8_t, endianness.little, unaligned> ulittle8_t*/
public final static class ulittle8_t extends detail.packed_endian_specific_integral<Byte/*uint8_t*/>{ 

    public ulittle8_t(char$ptr buffer) {
      super(buffer, Byte.class, endianness.little, unaligned);
    }
  
};
/*typedef detail::packed_endian_specific_integral<uint16_t, endianness.little, unaligned> ulittle16_t*/
public final static class ulittle16_t extends detail.packed_endian_specific_integral<Character/*uint16_t*/>{ 

    public ulittle16_t(char$ptr buffer) {
      super(buffer, Character.class, endianness.little, unaligned);
    }
};
/*typedef detail::packed_endian_specific_integral<uint32_t, endianness.little, unaligned> ulittle32_t*/
public final static class ulittle32_t extends detail.packed_endian_specific_integral<Integer/*uint32_t*/>{ 

    public ulittle32_t(char$ptr buffer) {
      super(buffer, Integer.class, endianness.little, unaligned);
    }
};
/*typedef detail::packed_endian_specific_integral<uint64_t, endianness.little, unaligned> ulittle64_t*/
public final static class ulittle64_t extends detail.packed_endian_specific_integral<Long/*uint64_t*/>{ 

    public ulittle64_t(char$ptr buffer) {
      super(buffer, Long.class, endianness.little, unaligned);
    }
};
/*typedef detail::packed_endian_specific_integral<int8_t, endianness.little, unaligned> little8_t*/
public final static class little8_t extends detail.packed_endian_specific_integral<Byte/*int8_t*/>{

    public little8_t(char$ptr buffer) {
      super(buffer, Byte.class, endianness.little, unaligned);
    }
  
};
/*typedef detail::packed_endian_specific_integral<int16_t, endianness.little, unaligned> little16_t*/
public final static class little16_t extends detail.packed_endian_specific_integral<Short/*int16_t*/>{ 

    public little16_t(char$ptr buffer) {
			super(buffer, Short.class, endianness.little, unaligned);
    }
};
/*typedef detail::packed_endian_specific_integral<int32_t, endianness.little, unaligned> little32_t*/
public final static class little32_t extends detail.packed_endian_specific_integral<Integer/*int32_t*/>{ 

    public little32_t(char$ptr buffer) {
			super(buffer, Integer.class, endianness.little, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int64_t, endianness.little, unaligned> little64_t*/
public final static class little64_t extends detail.packed_endian_specific_integral<Long>{ 

    public little64_t(char$ptr buffer) {
			super(buffer,Long.class/*int64_t*/, endianness.little, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint8_t, endianness.little, aligned> aligned_ulittle8_t*/
public final static class aligned_ulittle8_t extends detail.packed_endian_specific_integral<Byte/*uint8_t*/>{ 

    public aligned_ulittle8_t(char$ptr buffer) {
			super(buffer,Byte.class/*uint8_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint16_t, endianness.little, aligned> aligned_ulittle16_t*/
public final static class aligned_ulittle16_t extends detail.packed_endian_specific_integral<Character/*uint16_t*/>{ 

    public aligned_ulittle16_t(char$ptr buffer) {
			super(buffer,Character.class/*uint16_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint32_t, endianness.little, aligned> aligned_ulittle32_t*/
public final static class aligned_ulittle32_t extends detail.packed_endian_specific_integral<Long/*uint32_t*/>{ 

    public aligned_ulittle32_t(char$ptr buffer) {
			super(buffer, Long.class/*uint32_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint64_t, endianness.little, aligned> aligned_ulittle64_t*/
public final static class aligned_ulittle64_t extends detail.packed_endian_specific_integral<Long/*uint64_t*/>{ 

    public aligned_ulittle64_t(char$ptr buffer) {
			super(buffer, Long.class/*uint64_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int8_t, endianness.little, aligned> aligned_little8_t*/
public final static class aligned_little8_t extends detail.packed_endian_specific_integral<Byte/*int8_t*/>{

    public aligned_little8_t(char$ptr buffer) {
			super(buffer,Byte.class/*int8_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int16_t, endianness.little, aligned> aligned_little16_t*/
public final static class aligned_little16_t extends detail.packed_endian_specific_integral<Short/*int16_t*/>{ 

    public aligned_little16_t(char$ptr buffer) {
			super(buffer, Short.class/*int16_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int32_t, endianness.little, aligned> aligned_little32_t*/
public final static class aligned_little32_t extends detail.packed_endian_specific_integral<Integer/*int32_t*/>{ 

    public aligned_little32_t(char$ptr buffer) {
			super(buffer,Integer.class/*int32_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int64_t, endianness.little, aligned> aligned_little64_t*/
public final static class aligned_little64_t extends detail.packed_endian_specific_integral<Long/*int64_t*/>{

    public aligned_little64_t(char$ptr buffer) {
			super(buffer,Long.class/*int64_t*/, endianness.little, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint8_t, endianness.big, unaligned> ubig8_t*/
public final static class ubig8_t extends detail.packed_endian_specific_integral<Byte/*uint8_t*/>{

    public ubig8_t(char$ptr buffer) {
			super(buffer,Byte.class/*uint8_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint16_t, endianness.big, unaligned> ubig16_t*/
public final static class ubig16_t extends detail.packed_endian_specific_integral<Character/*uint16_t*/>{ 

    public ubig16_t(char$ptr buffer) {
			super(buffer,Character.class/*uint16_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint32_t, endianness.big, unaligned> ubig32_t*/
public final static class ubig32_t extends detail.packed_endian_specific_integral<Long/*uint32_t*/>{ 

    public ubig32_t(char$ptr buffer) {
			super(buffer, Long.class/*uint32_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint64_t, endianness.big, unaligned> ubig64_t*/
public final static class ubig64_t extends detail.packed_endian_specific_integral<Long/*uint64_t*/>{ 

    public ubig64_t(char$ptr buffer) {
			super(buffer,Long.class/*uint64_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int8_t, endianness.big, unaligned> big8_t*/
public final static class big8_t extends detail.packed_endian_specific_integral<Byte/*int8_t*/>{

    public big8_t(char$ptr buffer) {
			super(buffer,Byte.class/*int8_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int16_t, endianness.big, unaligned> big16_t*/
public final static class big16_t extends detail.packed_endian_specific_integral<Short/*int16_t*/>{ 

    public big16_t(char$ptr buffer) {
			super(buffer,Short.class/*int16_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int32_t, endianness.big, unaligned> big32_t*/
public final static class big32_t extends detail.packed_endian_specific_integral<Integer/*int32_t*/>{

    public big32_t(char$ptr buffer) {
			super(buffer, Integer.class/*int32_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int64_t, endianness.big, unaligned> big64_t*/
public final static class big64_t extends detail.packed_endian_specific_integral<Long/*int64_t*/>{ 

    public big64_t(char$ptr buffer) {
			super(buffer,Long.class/*int64_t*/, endianness.big, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint8_t, endianness.big, aligned> aligned_ubig8_t*/
public final static class aligned_ubig8_t extends detail.packed_endian_specific_integral<Byte/*uint8_t*/>{ 

    public aligned_ubig8_t(char$ptr buffer) {
			super(buffer,Byte.class/*uint8_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint16_t, endianness.big, aligned> aligned_ubig16_t*/
public final static class aligned_ubig16_t extends detail.packed_endian_specific_integral<Character/*uint16_t*/>{ 

    public aligned_ubig16_t(char$ptr buffer) {
			super(buffer,Character.class/*uint16_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint32_t, endianness.big, aligned> aligned_ubig32_t*/
public final static class aligned_ubig32_t extends detail.packed_endian_specific_integral<Long/*uint32_t*/>{ 

    public aligned_ubig32_t(char$ptr buffer) {
			super(buffer,Long.class/*uint32_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint64_t, endianness.big, aligned> aligned_ubig64_t*/
public final static class aligned_ubig64_t extends detail.packed_endian_specific_integral<Long/*uint64_t*/>{

    public aligned_ubig64_t(char$ptr buffer) {
			super(buffer,Long.class/*uint64_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int8_t, endianness.big, aligned> aligned_big8_t*/
public final static class aligned_big8_t extends detail.packed_endian_specific_integral<Byte/*int8_t*/>{ 

    public aligned_big8_t(char$ptr buffer) {
			super(buffer,Byte.class/*int8_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int16_t, endianness.big, aligned> aligned_big16_t*/
public final static class aligned_big16_t extends detail.packed_endian_specific_integral<Short/*int16_t*/>{ 

    public aligned_big16_t(char$ptr buffer) {
			super(buffer,Short.class/*int16_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int32_t, endianness.big, aligned> aligned_big32_t*/
public final static class aligned_big32_t extends detail.packed_endian_specific_integral<Integer/*int32_t*/>{

    public aligned_big32_t(char$ptr buffer) {
			super(buffer,Integer.class/*int32_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int64_t, endianness.big, aligned> aligned_big64_t*/
public final static class aligned_big64_t extends detail.packed_endian_specific_integral<Long/*int64_t*/>{ 

    public aligned_big64_t(char$ptr buffer) {
			super(buffer,Long.class/*int64_t*/, endianness.big, aligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint16_t, __native, unaligned> unaligned_uint16_t*/
public final static class unaligned_uint16_t extends detail.packed_endian_specific_integral<Character/*uint16_t*/>{ 

    public unaligned_uint16_t(char$ptr buffer) {
			super(buffer,Character.class/*uint16_t*/, endianness.__native, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint32_t, __native, unaligned> unaligned_uint32_t*/
public final static class unaligned_uint32_t extends detail.packed_endian_specific_integral<Integer/*uint32_t*/>{ 

    public unaligned_uint32_t(char$ptr buffer) {
			super(buffer,Integer.class/*uint32_t*/, endianness.__native, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<uint64_t, __native, unaligned> unaligned_uint64_t*/
public final static class unaligned_uint64_t extends detail.packed_endian_specific_integral<Long/*uint64_t*/>{ 

    public unaligned_uint64_t(char$ptr buffer) {
			super(buffer,Long.class/*uint64_t*/, endianness.__native, unaligned);
    }

    public long $T() {
      return $value();
    }
};
/*typedef detail::packed_endian_specific_integral<int16_t, __native, unaligned> unaligned_int16_t*/
public final static class unaligned_int16_t extends detail.packed_endian_specific_integral<Short/*int16_t*/>{ 

    public unaligned_int16_t(char$ptr buffer) {
			super(buffer,Short.class/*int16_t*/, endianness.__native, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int32_t, __native, unaligned> unaligned_int32_t*/
public final static class unaligned_int32_t extends detail.packed_endian_specific_integral<Integer/*int32_t*/>{ 

    public unaligned_int32_t(char$ptr buffer) {
			super(buffer,Integer.class/*int32_t*/, endianness.__native, unaligned);
    }

};
/*typedef detail::packed_endian_specific_integral<int64_t, __native, unaligned> unaligned_int64_t*/
public final static class unaligned_int64_t extends detail.packed_endian_specific_integral<Long/*int64_t*/>{ 

    public unaligned_int64_t(char$ptr buffer) {
			super(buffer,Long.class/*int64_t*/, endianness.__native, unaligned);
    }

};
} // END OF class support

/// install_fatal_error_handler - Installs a new error handler to be used
/// whenever a serious (non-recoverable) error is encountered by LLVM.
///
/// If no error handler is installed the default is to print the error message
/// to stderr, and call exit(1).  If an error handler is installed then it is
/// the handler's responsibility to log the message, it will no longer be
/// printed to stderr.  If the error handler returns, then exit(1) will be
/// called.
///
/// It is dangerous to naively use an error handler which throws an exception.
/// Even though some applications desire to gracefully recover from arbitrary
/// faults, blindly throwing exceptions through unfamiliar code isn't a way to
/// achieve this.
///
/// \param user_data - An argument which will be passed to the install error
/// handler.
//<editor-fold defaultstate="collapsed" desc="llvm::install_fatal_error_handler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 47,
 FQN = "llvm::install_fatal_error_handler", NM = "_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_")
//</editor-fold>
public static void install_fatal_error_handler(fatal_error_handler_t handler) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.install_fatal_error_handler(handler);
}
public static void install_fatal_error_handler(fatal_error_handler_t handler, 
                           Object/*void P*/ user_data/*= null*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.install_fatal_error_handler(handler, user_data);
}


/// Restores default error handling behaviour.
//<editor-fold defaultstate="collapsed" desc="llvm::remove_fatal_error_handler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 55,
 FQN = "llvm::remove_fatal_error_handler", NM = "_ZN4llvm26remove_fatal_error_handlerEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm26remove_fatal_error_handlerEv")
//</editor-fold>
public static void remove_fatal_error_handler() {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.remove_fatal_error_handler();
}


/// Reports a serious error, calling any installed error handler. These
/// functions are intended to be used for error conditions which are outside
/// the control of the compiler (I/O errors, invalid user input, etc.)
///
/// If no error handler is installed the default is to print the message to
/// standard error, followed by a newline.
/// After the error handler is called this function will call exit(1), it 
/// does not return.
//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 61,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorEPKcb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorEPKcb")
//</editor-fold>
public static void report_fatal_error(/*const*/char$ptr/*char P*/ Reason) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason);
}
public static void report_fatal_error(/*const*/char$ptr/*char P*/ Reason, boolean GenCrashDiag/*= true*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason, GenCrashDiag);
}
public static void report_fatal_error(/*const*/String/*char P*/ Reason) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(create_char$ptr(Reason));
}

//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 65,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorERKSsb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKSsb")
//</editor-fold>
public static void report_fatal_error(/*const*/std.string/*&*/ Reason) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason);
}
public static void report_fatal_error(/*const*/std.string/*&*/ Reason, boolean GenCrashDiag/*= true*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason, GenCrashDiag);
}

//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 69,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorENS_9StringRefEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorENS_9StringRefEb")
//</editor-fold>
public static void report_fatal_error(StringRef Reason) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason);
}
public static void report_fatal_error(StringRef Reason, boolean GenCrashDiag/*= true*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason, GenCrashDiag);
}

//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 73,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKNS_5TwineEb")
//</editor-fold>
public static void report_fatal_error(/*const*/ Twine /*&*/ Reason) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason);
}
public static void report_fatal_error(/*const*/ Twine /*&*/ Reason, boolean GenCrashDiag/*= true*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.report_fatal_error(Reason, GenCrashDiag);
}


/// This function calls abort(), and prints the optional message to stderr.
/// Use the llvm_unreachable macro (that adds location info), instead of
/// calling this function directly.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_unreachable_internal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 106,
 FQN = "llvm::llvm_unreachable_internal", NM = "_ZN4llvm25llvm_unreachable_internalEPKcS1_j",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm25llvm_unreachable_internalEPKcS1_j")
//</editor-fold>
public static void llvm_unreachable_internal() {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.llvm_unreachable_internal();
}
public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.llvm_unreachable_internal(msg);
}
public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/, /*const*/char$ptr/*char P*/ file/*= null*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.llvm_unreachable_internal(msg, file);
}
public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/, /*const*/char$ptr/*char P*/ file/*= null*/, 
                         /*uint*/int line/*= 0*/) {
  org.llvm.support.impl.ErrorHandlingLlvmGlobals.llvm_unreachable_internal(msg, file, line);
}
public static void llvm_unreachable_internal(/*const*/String/*char P*/ msg/*= 0*/, /*const*/String/*char P*/ file/*= 0*/, /*uint*/int line/*= 0*/) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static void llvm_unreachable_internal(String msg) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static StringRef getInstrProfRuntimeHookVarName() {
  return new StringRef("__llvm_profile_runtime");
}

public static <T> boolean any_of(Iterable<? extends T> iter, NativeCallback.BoolPredicate<T> predicate) {
  if (iter != null) {
    for (T t : iter) {
      if (predicate.$call(t)) {
        return true;
      }
    }
  }
  return false;
}

public static <IterT extends type$iterator<?, T>, T> IterT find_if(NativeIterable<IterT> iter, NativeCallback.BoolPredicate<T> predicate) {
  return std.find_if(iter.begin(), iter.end(), predicate);
}

public static </*class*/ Iter extends type$iterator<?, T>, T> iterator_range<T> reverse(NativeReverseIterable<Iter> x) {
  return make_range(x.rbegin(), x.rend());
}

public static boolean isValidAtomicOrderingCABI(long Ordering) {
  return AtomicOrderingLlvmGlobals.isValidAtomicOrderingCABI(Ordering);
}

public static FormattedString right_justify(StringRef Str, int Width) {
  return new FormattedString(Str, Width, true);
}
/// Wrapper function around std::transform to apply a function to a range and
/// store the result elsewhere.
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 525)
public static <T, UnaryOperation extends NativeCallback.Type2RetType<T, T>> 
        type$ptr<T> transform(NativeIterable<type$ptr<T>> range, type$ptr<T> result, UnaryOperation op) {
  return std.transform(range.begin(), range.end(), result, op);
}

} // END OF class llvm
