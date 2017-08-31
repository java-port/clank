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
package org.clang.driver.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.SanitizerKind.*;

//<editor-fold defaultstate="collapsed" desc="static type SanitizerArgsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_SanitizerArgs_cpp_Unnamed_enum;_ZL12setGroupBitsy;_ZL14parseArgValuesRKN5clang6driver6DriverEPKN4llvm3opt3ArgEb;_ZL19describeSanitizeArgPKN4llvm3opt3ArgEy;_ZL19getDefaultBlacklistRKN5clang6driver6DriverEyRSs;_ZL19lastArgumentForMaskRKN5clang6driver6DriverERKN4llvm3opt7ArgListEy;_ZL21parseCoverageFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgE;_ZL21parseSanitizeTrapArgsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE;_ZL22addIncludeLinkerOptionRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefE;_ZL8toStringRKN5clang12SanitizerSetE; -static-type=SanitizerArgsStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class SanitizerArgsStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.MANUAL/*fix long Value*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 28,
 FQN="(anonymous)", NM="_SanitizerArgs_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_SanitizerArgs_cpp_Unnamed_enum")
//</editor-fold>
public enum SanitizerArgs_cpp_Unnamed_enum/* : SanitizerMask*/ implements Native.ComparableLower {
  NeedsUbsanRt(Undefined | Integer | CFI),
  NeedsUbsanCxxRt(Vptr | CFI),
  NotAllowedWithTrap(Vptr),
  RequiresPIE(DataFlow),
  NeedsUnwindTables(Address | Thread | Memory | DataFlow),
  SupportsCoverage(Address | Memory | Leak | Undefined | Integer | DataFlow),
  RecoverableByDefault(Undefined | Integer),
  Unrecoverable(Unreachable | Return),
  LegacyFsanitizeRecoverMask(Undefined | Integer),
  NeedsLTO(CFI),
  TrappingSupported((Undefined & ~Vptr) | UnsignedIntegerOverflow | LocalBounds | CFI),
  TrappingDefault(CFI),
  CFIClasses(CFIVCall | CFINVCall | CFIDerivedCast | CFIUnrelatedCast);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SanitizerArgs_cpp_Unnamed_enum valueOf(long/*uint64_t*/ val) {
    SanitizerArgs_cpp_Unnamed_enum out = valueOf((int)val);
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
    return out;
  }
  public static SanitizerArgs_cpp_Unnamed_enum valueOf(int val) {
    SanitizerArgs_cpp_Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SanitizerArgs_cpp_Unnamed_enum[] VALUES;
    private static final SanitizerArgs_cpp_Unnamed_enum[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SanitizerArgs_cpp_Unnamed_enum kind : SanitizerArgs_cpp_Unnamed_enum.values()) {
        if (kind.value > max) { max = (int) kind.value; } //TODO: resolve possible loss
        if (kind.value < min) { min = (int) kind.value; } //TODO: resolve possible loss
      }
      _VALUES = new SanitizerArgs_cpp_Unnamed_enum[min < 0 ? (1-min) : 0];
      VALUES = new SanitizerArgs_cpp_Unnamed_enum[max >= 0 ? (1+max) : 0];
      for (SanitizerArgs_cpp_Unnamed_enum kind : SanitizerArgs_cpp_Unnamed_enum.values()) {
        if (kind.value < 0) {
          _VALUES[-((int)kind.value)] = kind; //TODO: resolve possible loss
        } else {
          VALUES[(int)kind.value] = kind; //TODO: resolve possible loss
        }
      }
    }
  }

  private final long/*uint64_t*/ value;
  private SanitizerArgs_cpp_Unnamed_enum(long val) { this.value = (long/*uint64_t*/)val;}
  public long/*uint64_t*/ getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_ulong(value, ((SanitizerArgs_cpp_Unnamed_enum)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_ulong(value, ((SanitizerArgs_cpp_Unnamed_enum)obj).value);}
  //</editor-fold>
}

/// Parse a -fsanitize= or -fno-sanitize= argument's values, diagnosing any
/// invalid components. Returns a SanitizerMask.
//<editor-fold defaultstate="collapsed" desc="parseArgValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 709,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 641,
 FQN="parseArgValues", NM="_ZL14parseArgValuesRKN5clang6driver6DriverEPKN4llvm3opt3ArgEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL14parseArgValuesRKN5clang6driver6DriverEPKN4llvm3opt3ArgEb")
//</editor-fold>
public static long/*uint64_t*/ parseArgValues(/*const*/ Driver /*&*/ D, /*const*/ Arg /*P*/ A, 
              boolean DiagnoseErrors) {
  assert ((A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_EQ.getValue())) || A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_EQ.getValue())) || A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_recover_EQ.getValue())) || A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_recover_EQ.getValue())) || A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_trap_EQ.getValue())) || A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_trap_EQ.getValue())))) : "Invalid argument in parseArgValues!";
  long/*uint64_t*/ Kinds = 0;
  for (int i = 0, n = A.getNumValues(); i != n; ++i) {
    /*const*/char$ptr/*char P*/ Value = $tryClone(A.getValue(i));
    long/*uint64_t*/ Kind;
    // Special case: don't accept -fsanitize=all.
    if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_EQ.getValue()))
       && 0 == strcmp(/*KEEP_STR*/"all", Value)) {
      Kind = 0;
    } else // Similarly, don't accept -fsanitize=efficiency-all.
    if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_EQ.getValue()))
       && 0 == strcmp(/*KEEP_STR*/"efficiency-all", Value)) {
      Kind = 0;
    } else {
      Kind = parseSanitizerValue(new StringRef(Value), /*AllowGroups=*/ true);
    }
    if ((Kind != 0)) {
      Kinds |= Kind;
    } else if (DiagnoseErrors) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                A.getOption().getName()), Value));
      } finally {
        $c$.$destroy();
      }
    }
  }
  return Kinds;
}


/// Parse -f(no-)?sanitize-coverage= flag values, diagnosing any invalid
/// components. Returns OR of members of \c CoverageFeature enumeration.
//<editor-fold defaultstate="collapsed" desc="parseCoverageFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 742,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 670,
 FQN="parseCoverageFeatures", NM="_ZL21parseCoverageFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL21parseCoverageFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgE")
//</editor-fold>
public static int parseCoverageFeatures(/*const*/ Driver /*&*/ D, /*const*/ Arg /*P*/ A) {
  assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_coverage.getValue())) || A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_coverage.getValue())));
  int Features = 0;
  for (int i = 0, n = A.getNumValues(); i != n; ++i) {
    /*const*/char$ptr/*char P*/ Value = $tryClone(A.getValue(i));
    int F = new StringSwitchInt(/*STRINGREF_STR*/Value).
        Case(/*KEEP_STR*/"func", CoverageFeature.CoverageFunc).
        Case(/*KEEP_STR*/"bb", CoverageFeature.CoverageBB).
        Case(/*KEEP_STR*/"edge", CoverageFeature.CoverageEdge).
        Case(/*KEEP_STR*/"indirect-calls", CoverageFeature.CoverageIndirCall).
        Case(/*KEEP_STR*/"trace-bb", CoverageFeature.CoverageTraceBB).
        Case(/*KEEP_STR*/"trace-cmp", CoverageFeature.CoverageTraceCmp).
        Case(/*KEEP_STR*/"8bit-counters", CoverageFeature.Coverage8bitCounters).
        Case(/*KEEP_STR*/"trace-pc", CoverageFeature.CoverageTracePC).
        Default(0);
    if (F == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                A.getOption().getName()), Value));
      } finally {
        $c$.$destroy();
      }
    }
    Features |= F;
  }
  return Features;
}


/// Produce an argument string from ArgList \p Args, which shows how it
/// provides some sanitizer kind from \p Mask. For example, the argument list
/// "-fsanitize=thread,vptr -fsanitize=address" with mask \c NeedsUbsanRt
/// would produce "-fsanitize=vptr".
//<editor-fold defaultstate="collapsed" desc="lastArgumentForMask">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 766,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 693,
 FQN="lastArgumentForMask", NM="_ZL19lastArgumentForMaskRKN5clang6driver6DriverERKN4llvm3opt7ArgListEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL19lastArgumentForMaskRKN5clang6driver6DriverERKN4llvm3opt7ArgListEy")
//</editor-fold>
public static std.string lastArgumentForMask(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args, 
                   long/*uint64_t*/ Mask) {
  for (std.reverse_iterator<Arg /*P*/> I = Args.rbegin(), 
      E = Args.rend();
       $noteq_reverse_iterator$C(I, E); I.$preInc()) {
    /*const*/ Arg /*P*/ Arg = I.$star();
    if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_EQ.getValue()))) {
      long/*uint64_t*/ AddKinds = expandSanitizerGroups(parseArgValues(D, Arg, false));
      if (((AddKinds & Mask) != 0)) {
        return describeSanitizeArg(Arg, Mask);
      }
    } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_EQ.getValue()))) {
      long/*uint64_t*/ RemoveKinds = expandSanitizerGroups(parseArgValues(D, Arg, false));
      Mask &= ~RemoveKinds;
    }
  }
  throw new llvm_unreachable("arg list didn't provide expected value");
}


/// Produce an argument string from argument \p A, which shows how it provides
/// a value in \p Mask. For instance, the argument
/// "-fsanitize=address,alignment" with mask \c NeedsUbsanRt would produce
/// "-fsanitize=alignment".
//<editor-fold defaultstate="collapsed" desc="describeSanitizeArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 786,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 713,
 FQN="describeSanitizeArg", NM="_ZL19describeSanitizeArgPKN4llvm3opt3ArgEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL19describeSanitizeArgPKN4llvm3opt3ArgEy")
//</editor-fold>
public static std.string describeSanitizeArg(/*const*/ Arg /*P*/ A, long/*uint64_t*/ Mask) {
  assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_EQ.getValue()))) : "Invalid argument in describeSanitizerArg!";
  
  std.string Sanitizers/*J*/= new std.string();
  for (int i = 0, n = A.getNumValues(); i != n; ++i) {
    if (((expandSanitizerGroups(parseSanitizerValue(new StringRef(A.getValue(i)), /*AllowGroups=*/ true))
       & Mask) != 0)) {
      if (!Sanitizers.empty()) {
        Sanitizers.$addassign(/*KEEP_STR*/",");
      }
      Sanitizers.$addassign(A.getValue(i));
    }
  }
  assert (!Sanitizers.empty()) : "arg didn't provide expected value";
  return $add_T_string$C(/*KEEP_STR*/"-fsanitize=", Sanitizers);
}


/// Produce a string containing comma-separated names of sanitizers in \p
/// Sanitizers set.
//<editor-fold defaultstate="collapsed" desc="toString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 579,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 556,
 FQN="toString", NM="_ZL8toStringRKN5clang12SanitizerSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL8toStringRKN5clang12SanitizerSetE")
//</editor-fold>
public static std.string __toString(/*const*/ SanitizerSet /*&*/ Sanitizers) {
  std.string Res/*J*/= new std.string();
  
  // AddressSanitizer
  if (Sanitizers.has(Address)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"address");
  }
  
  // Kernel AddressSanitizer (KASan)
  if (Sanitizers.has(KernelAddress)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"kernel-address");
  }
  
  // MemorySanitizer
  if (Sanitizers.has(Memory)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"memory");
  }
  
  // ThreadSanitizer
  if (Sanitizers.has(Thread)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"thread");
  }
  
  // LeakSanitizer
  if (Sanitizers.has(Leak)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"leak");
  }
  
  // UndefinedBehaviorSanitizer
  if (Sanitizers.has(Alignment)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"alignment");
  }
  if (Sanitizers.has(ArrayBounds)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"array-bounds");
  }
  if (Sanitizers.has(Bool)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"bool");
  }
  if (Sanitizers.has(Enum)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"enum");
  }
  if (Sanitizers.has(FloatCastOverflow)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"float-cast-overflow");
  }
  if (Sanitizers.has(FloatDivideByZero)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"float-divide-by-zero");
  }
  if (Sanitizers.has(Function)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"function");
  }
  if (Sanitizers.has(IntegerDivideByZero)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"integer-divide-by-zero");
  }
  if (Sanitizers.has(NonnullAttribute)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"nonnull-attribute");
  }
  if (Sanitizers.has(Null)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"null");
  }
  if (Sanitizers.has(ObjectSize)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"object-size");
  }
  if (Sanitizers.has(Return)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"return");
  }
  if (Sanitizers.has(ReturnsNonnullAttribute)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"returns-nonnull-attribute");
  }
  if (Sanitizers.has(ShiftBase)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"shift-base");
  }
  if (Sanitizers.has(ShiftExponent)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"shift-exponent");
  }
  if (Sanitizers.has(SignedIntegerOverflow)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"signed-integer-overflow");
  }
  if (Sanitizers.has(Unreachable)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"unreachable");
  }
  if (Sanitizers.has(VLABound)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"vla-bound");
  }
  if (Sanitizers.has(Vptr)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"vptr");
  }
  
  // IntegerSanitizer
  if (Sanitizers.has(UnsignedIntegerOverflow)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"unsigned-integer-overflow");
  }
  
  // DataFlowSanitizer
  if (Sanitizers.has(DataFlow)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"dataflow");
  }
  
  // Control Flow Integrity
  if (Sanitizers.has(CFICastStrict)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"cfi-cast-strict");
  }
  if (Sanitizers.has(CFIDerivedCast)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"cfi-derived-cast");
  }
  if (Sanitizers.has(CFIICall)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"cfi-icall");
  }
  if (Sanitizers.has(CFIUnrelatedCast)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"cfi-unrelated-cast");
  }
  if (Sanitizers.has(CFINVCall)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"cfi-nvcall");
  }
  if (Sanitizers.has(CFIVCall)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"cfi-vcall");
  }
  
  // Safe Stack
  if (Sanitizers.has(SafeStack)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"safe-stack");
  }
  if (Sanitizers.has(LocalBounds)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"local-bounds");
  }
  
  // EfficiencySanitizer
  if (Sanitizers.has(EfficiencyCacheFrag)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"efficiency-cache-frag");
  }
  if (Sanitizers.has(EfficiencyWorkingSet)) {
    if (!Res.empty()) {
      Res.$addassign(/*KEEP_STR*/",");
    }
    Res.$addassign(/*KEEP_STR*/"efficiency-working-set");
  }
  return Res;
}

//<editor-fold defaultstate="collapsed" desc="getDefaultBlacklist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 84,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 82,
 FQN="getDefaultBlacklist", NM="_ZL19getDefaultBlacklistRKN5clang6driver6DriverEyRSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL19getDefaultBlacklistRKN5clang6driver6DriverEyRSs")
//</editor-fold>
public static boolean getDefaultBlacklist(/*const*/ Driver /*&*/ D, long/*uint64_t*/ Kinds, 
                   std.string/*&*/ BLPath) {
  /*const*/char$ptr/*char P*/ BlacklistFile = null;
  if (((Kinds & Address) != 0)) {
    BlacklistFile = $tryClone($("asan_blacklist.txt"));
  } else if (((Kinds & Memory) != 0)) {
    BlacklistFile = $tryClone($("msan_blacklist.txt"));
  } else if (((Kinds & Thread) != 0)) {
    BlacklistFile = $tryClone($("tsan_blacklist.txt"));
  } else if (((Kinds & DataFlow) != 0)) {
    BlacklistFile = $tryClone($("dfsan_abilist.txt"));
  } else if (((Kinds & CFI) != 0)) {
    BlacklistFile = $tryClone($("cfi_blacklist.txt"));
  }
  if ((BlacklistFile != null)) {
    SmallString/*64*/ Path/*J*/= new SmallString/*64*/(new StringRef(D.ResourceDir), 64);
    path.append(Path, new Twine(BlacklistFile));
    BLPath.$assignMove(Path.str().$string());
    return true;
  }
  return false;
}


/// Sets group bits for every group that has at least one representative already
/// enabled in \p Kinds.
//<editor-fold defaultstate="collapsed" desc="setGroupBits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 109,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 107,
 FQN="setGroupBits", NM="_ZL12setGroupBitsy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL12setGroupBitsy")
//</editor-fold>
public static long/*uint64_t*/ setGroupBits(long/*uint64_t*/ Kinds) {
  if (((Kinds & SanitizerKind.Shift) != 0)) {
    Kinds |= SanitizerKind.ShiftGroup;
  }
  if (((Kinds & SanitizerKind.CFI) != 0)) {
    Kinds |= SanitizerKind.CFIGroup;
  }
  
  // -fsanitize=undefined includes all the sanitizers which have low overhead, no
  // ABI or address space layout implications, and only catch undefined behavior.
  if (((Kinds & SanitizerKind.Undefined) != 0)) {
    Kinds |= SanitizerKind.UndefinedGroup;
  }
  
  // -fsanitize=undefined-trap is an alias for -fsanitize=undefined.
  if (((Kinds & SanitizerKind.UndefinedTrap) != 0)) {
    Kinds |= SanitizerKind.UndefinedTrapGroup;
  }
  if (((Kinds & SanitizerKind.Integer) != 0)) {
    Kinds |= SanitizerKind.IntegerGroup;
  }
  if (((Kinds & SanitizerKind.Bounds) != 0)) {
    Kinds |= SanitizerKind.BoundsGroup;
  }
  // Meta-group only used internally.
  if (((Kinds & SanitizerKind.Efficiency) != 0)) {
    Kinds |= SanitizerKind.EfficiencyGroup;
  }
  
  // Magic group, containing all sanitizers. For example, "-fno-sanitize=all"
  // can be used to disable all the sanitizers.
  if (((Kinds & SanitizerKind.All) != 0)) {
    Kinds |= SanitizerKind.AllGroup;
  }
  return Kinds;
}

//<editor-fold defaultstate="collapsed" desc="parseSanitizeTrapArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 118,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 116,
 FQN="parseSanitizeTrapArgs", NM="_ZL21parseSanitizeTrapArgsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL21parseSanitizeTrapArgsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE")
//</editor-fold>
public static long/*uint64_t*/ parseSanitizeTrapArgs(/*const*/ Driver /*&*/ D, 
                     /*const*/ ArgList /*&*/ Args) {
  long/*uint64_t*/ TrapRemove = 0; // During the loop below, the accumulated set of
  // sanitizers disabled by the current sanitizer
  // argument or any argument after it.
  long/*uint64_t*/ TrappingKinds = 0;
  long/*uint64_t*/ TrappingSupportedWithGroups = setGroupBits(SanitizerArgs_cpp_Unnamed_enum.TrappingSupported.getValue());
  
  for (std.reverse_iterator<Arg /*P*/> I = Args.rbegin(), E = Args.rend();
       $noteq_reverse_iterator$C(I, E); I.$preInc()) {
    /*const*/ Arg /*P*/ Arg = I.$star();
    if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_trap_EQ.getValue()))) {
      Arg.claim();
      long/*uint64_t*/ Add = parseArgValues(D, Arg, true);
      Add &= ~TrapRemove;
      {
        long/*uint64_t*/ InvalidValues = Add & ~TrappingSupportedWithGroups;
        if ((InvalidValues != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SanitizerSet S/*J*/= new SanitizerSet();
            S.Mask = InvalidValues;
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), /*KEEP_STR*/"-fsanitize-trap"), 
                new StringRef(__toString(S))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      TrappingKinds |= expandSanitizerGroups(Add) & ~TrapRemove;
    } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_trap_EQ.getValue()))) {
      Arg.claim();
      TrapRemove |= expandSanitizerGroups(parseArgValues(D, Arg, true));
    } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_undefined_trap_on_error.getValue()))) {
      Arg.claim();
      TrappingKinds |= expandSanitizerGroups(UndefinedGroup & ~TrapRemove) & ~TrapRemove;
    } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_undefined_trap_on_error.getValue()))) {
      Arg.claim();
      TrapRemove |= expandSanitizerGroups(UndefinedGroup);
    }
  }
  
  // Apply default trapping behavior.
  TrappingKinds |= SanitizerArgs_cpp_Unnamed_enum.TrappingDefault.getValue() & ~TrapRemove;
  
  return TrappingKinds;
}

//<editor-fold defaultstate="collapsed" desc="addIncludeLinkerOption">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 591,
 FQN="addIncludeLinkerOption", NM="_ZL22addIncludeLinkerOptionRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZL22addIncludeLinkerOptionRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefE")
//</editor-fold>
public static void addIncludeLinkerOption(/*const*/ ToolChain /*&*/ TC, 
                      /*const*/ ArgList /*&*/ Args, 
                      ArgStringList/*&*/ CmdArgs, 
                      StringRef SymbolName) {
  SmallString/*64*/ LinkerOptionFlag/*J*/= new SmallString/*64*/(64);
  LinkerOptionFlag.$assign(/*STRINGREF_STR*/"--linker-option=/include:");
  if (TC.getTriple().getArch() == Triple.ArchType.x86) {
    // Win32 mangles C function names with a '_' prefix.
    LinkerOptionFlag.$addassign($$UNDERSCORE);
  }
  LinkerOptionFlag.$addassign(/*NO_COPY*/SymbolName);
  CmdArgs.push_back(Args.MakeArgString(new Twine(LinkerOptionFlag)));
}

} // END OF class SanitizerArgsStatics
