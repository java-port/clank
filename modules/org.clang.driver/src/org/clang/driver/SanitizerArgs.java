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

package org.clang.driver;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.SanitizerArgsStatics.*;
import org.clang.basic.SanitizerKind;
import static org.clang.basic.SanitizerKind.*;

//<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 24,
 FQN="clang::driver::SanitizerArgs", NM="_ZN5clang6driver13SanitizerArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZN5clang6driver13SanitizerArgsE")
//</editor-fold>
public class SanitizerArgs implements Destructors.ClassWithDestructor {
  private SanitizerSet Sanitizers;
  private SanitizerSet RecoverableSanitizers;
  private SanitizerSet TrapSanitizers;
  
  private std.vectorString BlacklistFiles;
  private std.vectorString ExtraDeps;
  private int CoverageFeatures/* = 0*/;
  private int MsanTrackOrigins/* = 0*/;
  private boolean MsanUseAfterDtor/* = false*/;
  private boolean CfiCrossDso/* = false*/;
  private int AsanFieldPadding/* = 0*/;
  private boolean AsanSharedRuntime/* = false*/;
  private boolean AsanUseAfterScope/* = false*/;
  private boolean LinkCXXRuntimes/* = false*/;
  private boolean NeedPIE/* = false*/;
  private boolean Stats/* = false*/;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final int$ref MsanTrackOrigins$Ref = new int$ref() {
    @Override
    public int $deref() { return MsanTrackOrigins; }

    @Override
    public int $set(int value) {
      MsanTrackOrigins = value;
      return value;
    }
  };

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final int$ref AsanFieldPadding$Ref = new int$ref() {
    @Override
    public int $deref() { return AsanFieldPadding; }

    @Override
    public int $set(int value) {
      AsanFieldPadding = value;
      return value;
    }
  };
  
/*public:*/
  /// Parses the sanitizer arguments from an argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::SanitizerArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 199,
   FQN="clang::driver::SanitizerArgs::SanitizerArgs", NM="_ZN5clang6driver13SanitizerArgsC1ERKNS0_9ToolChainERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZN5clang6driver13SanitizerArgsC1ERKNS0_9ToolChainERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public SanitizerArgs(/*const*/ ToolChain /*&*/ TC, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Sanitizers(), RecoverableSanitizers(), TrapSanitizers(), BlacklistFiles(), ExtraDeps(), CoverageFeatures(0), MsanTrackOrigins(0), MsanUseAfterDtor(false), CfiCrossDso(false), AsanFieldPadding(0), AsanSharedRuntime(false), AsanUseAfterScope(false), LinkCXXRuntimes(false), NeedPIE(false), Stats(false)*/ 
    //START JInit
    this.Sanitizers = new SanitizerSet();
    this.RecoverableSanitizers = new SanitizerSet();
    this.TrapSanitizers = new SanitizerSet();
    this.BlacklistFiles = new std.vectorString(std.string.EMPTY);
    this.ExtraDeps = new std.vectorString(std.string.EMPTY);
    /*InClass*/this.CoverageFeatures = 0;
    /*InClass*/this.MsanTrackOrigins = 0;
    /*InClass*/this.MsanUseAfterDtor = false;
    /*InClass*/this.CfiCrossDso = false;
    /*InClass*/this.AsanFieldPadding = 0;
    /*InClass*/this.AsanSharedRuntime = false;
    /*InClass*/this.AsanUseAfterScope = false;
    /*InClass*/this.LinkCXXRuntimes = false;
    /*InClass*/this.NeedPIE = false;
    /*InClass*/this.Stats = false;
    //END JInit
    long/*uint64_t*/ AllRemove = 0; // During the loop below, the accumulated set of
    // sanitizers disabled by the current sanitizer
    // argument or any argument after it.
    long/*uint64_t*/ AllAddedKinds = 0; // Mask of all sanitizers ever enabled by
    // -fsanitize= flags (directly or via group
    // expansion), some of which may be disabled
    // later. Used to carefully prune
    // unused-argument diagnostics.
    long/*uint64_t*/ DiagnosedKinds = 0; // All Kinds we have diagnosed up to now.
    // Used to deduplicate diagnostics.
    long/*uint64_t*/ Kinds = 0;
    /*const*/long/*uint64_t*/ Supported = setGroupBits(TC.getSupportedSanitizers());
    ToolChain.RTTIMode RTTIMode = TC.getRTTIMode();
    
    /*const*/ Driver /*&*/ D = TC.getDriver();
    long/*uint64_t*/ TrappingKinds = parseSanitizeTrapArgs(D, Args);
    long/*uint64_t*/ InvalidTrappingKinds = TrappingKinds & SanitizerArgs_cpp_Unnamed_enum.NotAllowedWithTrap.getValue();
    
    for (std.reverse_iterator<Arg /*P*/> I = Args.rbegin(), E = Args.rend();
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      /*const*/ Arg /*P*/ Arg = I.$star();
      if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_EQ.getValue()))) {
        Arg.claim();
        long/*uint64_t*/ Add = parseArgValues(D, Arg, true);
        AllAddedKinds |= expandSanitizerGroups(Add);
        
        // Avoid diagnosing any sanitizer which is disabled later.
        Add &= ~AllRemove;
        {
          // At this point we have not expanded groups, so any unsupported
          // sanitizers in Add are those which have been explicitly enabled.
          // Diagnose them.
          long/*uint64_t*/ KindsToDiagnose = Add & InvalidTrappingKinds & ~DiagnosedKinds;
          if ((KindsToDiagnose != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              std.string Desc = describeSanitizeArg(I.$star(), KindsToDiagnose);
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                      new StringRef(Desc)), /*KEEP_STR*/"-fsanitize-trap=undefined"));
              DiagnosedKinds |= KindsToDiagnose;
            } finally {
              $c$.$destroy();
            }
          }
        }
        Add &= ~InvalidTrappingKinds;
        {
          long/*uint64_t*/ KindsToDiagnose = Add & ~Supported & ~DiagnosedKinds;
          if ((KindsToDiagnose != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              std.string Desc = describeSanitizeArg(I.$star(), KindsToDiagnose);
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_opt_for_target)), 
                      new StringRef(Desc)), new StringRef(TC.getTriple().str())));
              DiagnosedKinds |= KindsToDiagnose;
            } finally {
              $c$.$destroy();
            }
          }
        }
        Add &= Supported;
        
        // Test for -fno-rtti + explicit -fsanitizer=vptr before expanding groups
        // so we don't error out if -fno-rtti and -fsanitize=undefined were
        // passed.
        if (((Add & Vptr) != 0)
           && (RTTIMode == ToolChain.RTTIMode.RM_DisabledImplicitly
           || RTTIMode == ToolChain.RTTIMode.RM_DisabledExplicitly)) {
          if (RTTIMode == ToolChain.RTTIMode.RM_DisabledImplicitly) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Warn about not having rtti enabled if the vptr sanitizer is
              // explicitly enabled
              $c$.clean($c$.track(D.Diag(diag.warn_drv_disabling_vptr_no_rtti_default)));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              /*const*/ Arg /*P*/ NoRTTIArg = TC.getRTTIArg();
              assert ((NoRTTIArg != null)) : "RTTI disabled explicitly but we have no argument!";
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                      /*KEEP_STR*/"-fsanitize=vptr"), new StringRef(NoRTTIArg.getAsString(Args))));
            } finally {
              $c$.$destroy();
            }
          }
          
          // Take out the Vptr sanitizer from the enabled sanitizers
          AllRemove |= Vptr;
        }
        
        Add = expandSanitizerGroups(Add);
        // Group expansion may have enabled a sanitizer which is disabled later.
        Add &= ~AllRemove;
        // Silently discard any unsupported sanitizers implicitly enabled through
        // group expansion.
        Add &= ~InvalidTrappingKinds;
        Add &= Supported;
        
        Kinds |= Add;
      } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_EQ.getValue()))) {
        Arg.claim();
        long/*uint64_t*/ Remove = parseArgValues(D, Arg, true);
        AllRemove |= expandSanitizerGroups(Remove);
      }
    }
    
    // Enable toolchain specific default sanitizers if not explicitly disabled.
    Kinds |= TC.getDefaultSanitizers() & ~AllRemove;
    
    // We disable the vptr sanitizer if it was enabled by group expansion but RTTI
    // is disabled.
    if (((Kinds & Vptr) != 0)
       && (RTTIMode == ToolChain.RTTIMode.RM_DisabledImplicitly
       || RTTIMode == ToolChain.RTTIMode.RM_DisabledExplicitly)) {
      Kinds &= ~Vptr;
    }
    
    // Check that LTO is enabled if we need it.
    if (((Kinds & SanitizerArgs_cpp_Unnamed_enum.NeedsLTO.getValue()) != 0) && !D.isUsingLTO()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
                new StringRef(lastArgumentForMask(D, Args, Kinds & SanitizerArgs_cpp_Unnamed_enum.NeedsLTO.getValue()))), /*KEEP_STR*/"-flto"));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Report error if there are non-trapping sanitizers that require
    // c++abi-specific  parts of UBSan runtime, and they are not provided by the
    // toolchain. We don't have a good way to check the latter, so we just
    // check if the toolchan supports vptr.
    if (((~Supported & Vptr) != 0)) {
      long/*uint64_t*/ KindsToDiagnose = Kinds & ~TrappingKinds & SanitizerArgs_cpp_Unnamed_enum.NeedsUbsanCxxRt.getValue();
      // The runtime library supports the Microsoft C++ ABI, but only well enough
      // for CFI. FIXME: Remove this once we support vptr on Windows.
      if (TC.getTriple().isOSWindows()) {
        KindsToDiagnose &= ~CFI;
      }
      if ((KindsToDiagnose != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SanitizerSet S/*J*/= new SanitizerSet();
          S.Mask = KindsToDiagnose;
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_opt_for_target)), 
                  new StringRef(($add_T_string(/*KEEP_STR*/"-fno-sanitize-trap=", __toString(S))))), new StringRef(TC.getTriple().str())));
          Kinds &= ~KindsToDiagnose;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Warn about incompatible groups of sanitizers.
    std.pairULongULong IncompatibleGroups[/*14*/] = new std.pairULongULong [/*14*/] {
      std.make_pair_ullong_ullong(Address, Thread), std.make_pair_ullong_ullong(Address, Memory), 
      std.make_pair_ullong_ullong(Thread, Memory), std.make_pair_ullong_ullong(Leak, Thread), 
      std.make_pair_ullong_ullong(Leak, Memory), std.make_pair_ullong_ullong(KernelAddress, Address), 
      std.make_pair_ullong_ullong(KernelAddress, Leak), 
      std.make_pair_ullong_ullong(KernelAddress, Thread), 
      std.make_pair_ullong_ullong(KernelAddress, Memory), 
      std.make_pair_ullong_ullong(Efficiency, Address), 
      std.make_pair_ullong_ullong(Efficiency, Leak), 
      std.make_pair_ullong_ullong(Efficiency, Thread), 
      std.make_pair_ullong_ullong(Efficiency, Memory), 
      std.make_pair_ullong_ullong(Efficiency, KernelAddress)};
    for (std.pairULongULong G : IncompatibleGroups) {
      long/*uint64_t*/ Group = G.first;
      if (((Kinds & Group) != 0)) {
        {
          long/*uint64_t*/ Incompatible = Kinds & G.second;
          if ((Incompatible != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                      new StringRef(lastArgumentForMask(D, Args, Group))), 
                  new StringRef(lastArgumentForMask(D, Args, Incompatible))));
              Kinds &= ~Incompatible;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    // FIXME: Currently -fsanitize=leak is silently ignored in the presence of
    // -fsanitize=address. Perhaps it should print an error, or perhaps
    // -f(-no)sanitize=leak should change whether leak detection is enabled by
    // default in ASan?
    
    // Parse -f(no-)?sanitize-recover flags.
    long/*uint64_t*/ RecoverableKinds = SanitizerArgs_cpp_Unnamed_enum.RecoverableByDefault.getValue();
    long/*uint64_t*/ DiagnosedUnrecoverableKinds = 0;
    for (/*const*/ Arg /*P*/ Arg : Args) {
      /*const*/char$ptr/*char P*/ DeprecatedReplacement = null;
      if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_recover.getValue()))) {
        DeprecatedReplacement = $tryClone($("-fsanitize-recover=undefined,integer' or '-fsanitize-recover=all"));
        RecoverableKinds |= expandSanitizerGroups(SanitizerArgs_cpp_Unnamed_enum.LegacyFsanitizeRecoverMask.getValue());
        Arg.claim();
      } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_recover.getValue()))) {
        DeprecatedReplacement = $tryClone($("-fno-sanitize-recover=undefined,integer' or '-fno-sanitize-recover=all"));
        RecoverableKinds &= ~expandSanitizerGroups(SanitizerArgs_cpp_Unnamed_enum.LegacyFsanitizeRecoverMask.getValue());
        Arg.claim();
      } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_recover_EQ.getValue()))) {
        long/*uint64_t*/ Add = parseArgValues(D, Arg, true);
        {
          // Report error if user explicitly tries to recover from unrecoverable
          // sanitizer.
          long/*uint64_t*/ KindsToDiagnose = Add & SanitizerArgs_cpp_Unnamed_enum.Unrecoverable.getValue() & ~DiagnosedUnrecoverableKinds;
          if ((KindsToDiagnose != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              SanitizerSet SetToDiagnose/*J*/= new SanitizerSet();
              SetToDiagnose.Mask |= KindsToDiagnose;
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                      Arg.getOption().getName()), new StringRef(__toString(SetToDiagnose))));
              DiagnosedUnrecoverableKinds |= KindsToDiagnose;
            } finally {
              $c$.$destroy();
            }
          }
        }
        RecoverableKinds |= expandSanitizerGroups(Add);
        Arg.claim();
      } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_recover_EQ.getValue()))) {
        RecoverableKinds &= ~expandSanitizerGroups(parseArgValues(D, Arg, true));
        Arg.claim();
      }
      if ((DeprecatedReplacement != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_deprecated_arg)), new StringRef(Arg.getAsString(Args))), 
              DeprecatedReplacement));
        } finally {
          $c$.$destroy();
        }
      }
    }
    RecoverableKinds &= Kinds;
    RecoverableKinds &= ~SanitizerArgs_cpp_Unnamed_enum.Unrecoverable.getValue();
    
    TrappingKinds &= Kinds;
    {
      std.string BLPath/*J*/= new std.string();
      if (getDefaultBlacklist(D, Kinds, BLPath) && fs.exists(new Twine(BLPath))) {
        BlacklistFiles.push_back(BLPath);
      }
    }
    // Parse -f(no-)sanitize-blacklist options.
    for (/*const*/ Arg /*P*/ Arg : Args) {
      if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_blacklist.getValue()))) {
        Arg.claim();
        std.string BLPath = new std.string(Arg.getValue());
        if (fs.exists(new Twine(BLPath))) {
          BlacklistFiles.push_back(BLPath);
          ExtraDeps.push_back(BLPath);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_such_file)), new StringRef(BLPath)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_blacklist.getValue()))) {
        Arg.claim();
        BlacklistFiles.clear();
        ExtraDeps.clear();
      }
    }
    {
      std.unique_ptr<SpecialCaseList> SCL = null;
      try {
        std.string BLError/*J*/= new std.string();
        SCL/*J*/= SpecialCaseList.create(BlacklistFiles, BLError);
        if (!(SCL.get() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_malformed_sanitizer_blacklist)), new StringRef(BLError)));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (SCL != null) { SCL.$destroy(); }
      }
    }
    
    // Parse -f[no-]sanitize-memory-track-origins[=level] options.
    if (((AllAddedKinds & Memory) != 0)) {
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fsanitize_memory_track_origins_EQ.getValue()), 
            new OptSpecifier(options.ID.OPT_fsanitize_memory_track_origins.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_sanitize_memory_track_origins.getValue()));
        if ((A != null)) {
          if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_memory_track_origins.getValue()))) {
            MsanTrackOrigins = 2;
          } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_memory_track_origins.getValue()))) {
            MsanTrackOrigins = 0;
          } else {
            StringRef S = new StringRef(A.getValue());
            if (S.getAsInteger$Signed(0, MsanTrackOrigins$Ref) || MsanTrackOrigins < 0
               || MsanTrackOrigins > 2) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), /*NO_COPY*/S));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
      MsanUseAfterDtor
         = Args.hasArg(new OptSpecifier(options.ID.OPT_fsanitize_memory_use_after_dtor.getValue()));
      NeedPIE |= !(TC.getTriple().isOSLinux()
         && TC.getTriple().getArch() == Triple.ArchType.x86_64);
    }
    if (((AllAddedKinds & CFI) != 0)) {
      CfiCrossDso = Args.hasFlag(new OptSpecifier(options.ID.OPT_fsanitize_cfi_cross_dso.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_sanitize_cfi_cross_dso.getValue()), false);
      // Without PIE, external function address may resolve to a PLT record, which
      // can not be verified by the target module.
      NeedPIE |= CfiCrossDso;
    }
    
    Stats = Args.hasFlag(new OptSpecifier(options.ID.OPT_fsanitize_stats.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_sanitize_stats.getValue()), false);
    
    // Parse -f(no-)?sanitize-coverage flags if coverage is supported by the
    // enabled sanitizers.
    for (/*const*/ Arg /*P*/ Arg : Args) {
      if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fsanitize_coverage.getValue()))) {
        int$ref LegacySanitizeCoverage = create_int$ref();
        if (Arg.getNumValues() == 1
           && !new StringRef(Arg.getValue(0)).
            getAsInteger$Signed(0, LegacySanitizeCoverage)
           && LegacySanitizeCoverage.$deref() >= 0 && LegacySanitizeCoverage.$deref() <= 4) {
          switch (LegacySanitizeCoverage.$deref()) {
           case 0:
            CoverageFeatures = 0;
            Arg.claim();
            break;
           case 1:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_deprecated_arg)), new StringRef(Arg.getAsString(Args))), 
                    /*KEEP_STR*/"-fsanitize-coverage=func"));
                CoverageFeatures = CoverageFeature.CoverageFunc;
                break;
              } finally {
                $c$.$destroy();
              }
            }
           case 2:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_deprecated_arg)), new StringRef(Arg.getAsString(Args))), 
                    /*KEEP_STR*/"-fsanitize-coverage=bb"));
                CoverageFeatures = CoverageFeature.CoverageBB;
                break;
              } finally {
                $c$.$destroy();
              }
            }
           case 3:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_deprecated_arg)), new StringRef(Arg.getAsString(Args))), 
                    /*KEEP_STR*/"-fsanitize-coverage=edge"));
                CoverageFeatures = CoverageFeature.CoverageEdge;
                break;
              } finally {
                $c$.$destroy();
              }
            }
           case 4:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_deprecated_arg)), 
                        new StringRef(Arg.getAsString(Args))), 
                    /*KEEP_STR*/"-fsanitize-coverage=edge,indirect-calls"));
                CoverageFeatures = CoverageFeature.CoverageEdge | CoverageFeature.CoverageIndirCall;
                break;
              } finally {
                $c$.$destroy();
              }
            }
          }
          continue;
        }
        CoverageFeatures |= parseCoverageFeatures(D, Arg);
        
        // Disable coverage and not claim the flags if there is at least one
        // non-supporting sanitizer.
        if (!((AllAddedKinds & ~setGroupBits(SanitizerArgs_cpp_Unnamed_enum.SupportsCoverage.getValue())) != 0)) {
          Arg.claim();
        } else {
          CoverageFeatures = 0;
        }
      } else if (Arg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_sanitize_coverage.getValue()))) {
        Arg.claim();
        CoverageFeatures &= ~parseCoverageFeatures(D, Arg);
      }
    }
    // Choose at most one coverage type: function, bb, or edge.
    if (((CoverageFeatures & CoverageFeature.CoverageFunc) != 0) && ((CoverageFeatures & CoverageFeature.CoverageBB) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                /*KEEP_STR*/"-fsanitize-coverage=func"), 
            /*KEEP_STR*/"-fsanitize-coverage=bb"));
      } finally {
        $c$.$destroy();
      }
    }
    if (((CoverageFeatures & CoverageFeature.CoverageFunc) != 0) && ((CoverageFeatures & CoverageFeature.CoverageEdge) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                /*KEEP_STR*/"-fsanitize-coverage=func"), 
            /*KEEP_STR*/"-fsanitize-coverage=edge"));
      } finally {
        $c$.$destroy();
      }
    }
    if (((CoverageFeatures & CoverageFeature.CoverageBB) != 0) && ((CoverageFeatures & CoverageFeature.CoverageEdge) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                /*KEEP_STR*/"-fsanitize-coverage=bb"), 
            /*KEEP_STR*/"-fsanitize-coverage=edge"));
      } finally {
        $c$.$destroy();
      }
    }
    // Basic block tracing and 8-bit counters require some type of coverage
    // enabled.
    int CoverageTypes = CoverageFeature.CoverageFunc | CoverageFeature.CoverageBB | CoverageFeature.CoverageEdge;
    if (((CoverageFeatures & CoverageFeature.CoverageTraceBB) != 0)
       && !((CoverageFeatures & CoverageTypes) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
                /*KEEP_STR*/"-fsanitize-coverage=trace-bb"), 
            /*KEEP_STR*/"-fsanitize-coverage=(func|bb|edge)"));
      } finally {
        $c$.$destroy();
      }
    }
    if (((CoverageFeatures & CoverageFeature.Coverage8bitCounters) != 0)
       && !((CoverageFeatures & CoverageTypes) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
                /*KEEP_STR*/"-fsanitize-coverage=8bit-counters"), 
            /*KEEP_STR*/"-fsanitize-coverage=(func|bb|edge)"));
      } finally {
        $c$.$destroy();
      }
    }
    // trace-pc w/o func/bb/edge implies edge.
    if (((CoverageFeatures & CoverageFeature.CoverageTracePC) != 0)
       && !((CoverageFeatures & CoverageTypes) != 0)) {
      CoverageFeatures |= CoverageFeature.CoverageEdge;
    }
    if (((AllAddedKinds & Address) != 0)) {
      AsanSharedRuntime
         = Args.hasArg(new OptSpecifier(options.ID.OPT_shared_libasan.getValue())) || TC.getTriple().isAndroid();
      NeedPIE |= TC.getTriple().isAndroid();
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fsanitize_address_field_padding.getValue()));
        if ((A != null)) {
          StringRef S = new StringRef(A.getValue());
          // Legal values are 0 and 1, 2, but in future we may add more levels.
          if (S.getAsInteger$Signed(0, AsanFieldPadding$Ref) || AsanFieldPadding < 0
             || AsanFieldPadding > 2) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), /*NO_COPY*/S));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      {
        
        Arg /*P*/ WindowsDebugRTArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_MTd.getValue()), new OptSpecifier(options.ID.OPT__SLASH_MT.getValue()), 
            new OptSpecifier(options.ID.OPT__SLASH_MDd.getValue()), new OptSpecifier(options.ID.OPT__SLASH_MD.getValue()), 
            new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()), new OptSpecifier(options.ID.OPT__SLASH_LD.getValue()));
        if ((WindowsDebugRTArg != null)) {
          switch (options.ID.valueOf(WindowsDebugRTArg.getOption().getID())) {
           case OPT__SLASH_MTd:
           case OPT__SLASH_MDd:
           case OPT__SLASH_LDd:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                        new StringRef(WindowsDebugRTArg.getAsString(Args))), 
                    new StringRef(lastArgumentForMask(D, Args, Address))));
                $c$.clean($c$.track(D.Diag(diag.note_drv_address_sanitizer_debug_runtime)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
    
    AsanUseAfterScope
       = Args.hasArg(new OptSpecifier(options.ID.OPT_fsanitize_address_use_after_scope.getValue()));
    if (AsanUseAfterScope && !((AllAddedKinds & Address) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
                /*KEEP_STR*/"-fsanitize-address-use-after-scope"), 
            /*KEEP_STR*/"-fsanitize=address"));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Parse -link-cxx-sanitizer flag.
    LinkCXXRuntimes
       = Args.hasArg(new OptSpecifier(options.ID.OPT_fsanitize_link_cxx_runtime.getValue())) || D.CCCIsCXX();
    
    // Finally, initialize the set of available and recoverable sanitizers.
    Sanitizers.Mask |= Kinds;
    RecoverableSanitizers.Mask |= RecoverableKinds;
    TrapSanitizers.Mask |= TrappingKinds;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsAsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 44,
   FQN="clang::driver::SanitizerArgs::needsAsanRt", NM="_ZNK5clang6driver13SanitizerArgs11needsAsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs11needsAsanRtEv")
  //</editor-fold>
  public boolean needsAsanRt() /*const*/ {
    return Sanitizers.has(SanitizerKind.Address);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsSharedAsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 47,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 45,
   FQN="clang::driver::SanitizerArgs::needsSharedAsanRt", NM="_ZNK5clang6driver13SanitizerArgs17needsSharedAsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs17needsSharedAsanRtEv")
  //</editor-fold>
  public boolean needsSharedAsanRt() /*const*/ {
    return AsanSharedRuntime;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsTsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 46,
   FQN="clang::driver::SanitizerArgs::needsTsanRt", NM="_ZNK5clang6driver13SanitizerArgs11needsTsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs11needsTsanRtEv")
  //</editor-fold>
  public boolean needsTsanRt() /*const*/ {
    return Sanitizers.has(SanitizerKind.Thread);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsMsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 47,
   FQN="clang::driver::SanitizerArgs::needsMsanRt", NM="_ZNK5clang6driver13SanitizerArgs11needsMsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs11needsMsanRtEv")
  //</editor-fold>
  public boolean needsMsanRt() /*const*/ {
    return Sanitizers.has(SanitizerKind.Memory);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsLsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 48,
   FQN="clang::driver::SanitizerArgs::needsLsanRt", NM="_ZNK5clang6driver13SanitizerArgs11needsLsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs11needsLsanRtEv")
  //</editor-fold>
  public boolean needsLsanRt() /*const*/ {
    return Sanitizers.has(SanitizerKind.Leak)
       && !Sanitizers.has(SanitizerKind.Address);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsUbsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 161,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 159,
   FQN="clang::driver::SanitizerArgs::needsUbsanRt", NM="_ZNK5clang6driver13SanitizerArgs12needsUbsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs12needsUbsanRtEv")
  //</editor-fold>
  public boolean needsUbsanRt() /*const*/ {
    return (((Sanitizers.Mask & SanitizerArgs_cpp_Unnamed_enum.NeedsUbsanRt.getValue() & ~TrapSanitizers.Mask) != 0)
       || (CoverageFeatures != 0))
       && !Sanitizers.has(Address) && !Sanitizers.has(Memory)
       && !Sanitizers.has(Thread) && !Sanitizers.has(DataFlow) && !CfiCrossDso;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsDfsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 55,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 53,
   FQN="clang::driver::SanitizerArgs::needsDfsanRt", NM="_ZNK5clang6driver13SanitizerArgs12needsDfsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs12needsDfsanRtEv")
  //</editor-fold>
  public boolean needsDfsanRt() /*const*/ {
    return Sanitizers.has(SanitizerKind.DataFlow);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsSafeStackRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 54,
   FQN="clang::driver::SanitizerArgs::needsSafeStackRt", NM="_ZNK5clang6driver13SanitizerArgs16needsSafeStackRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs16needsSafeStackRtEv")
  //</editor-fold>
  public boolean needsSafeStackRt() /*const*/ {
    return Sanitizers.has(SanitizerKind.SafeStack);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsCfiRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 167,
   FQN="clang::driver::SanitizerArgs::needsCfiRt", NM="_ZNK5clang6driver13SanitizerArgs10needsCfiRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs10needsCfiRtEv")
  //</editor-fold>
  public boolean needsCfiRt() /*const*/ {
    return !((Sanitizers.Mask & CFI & ~TrapSanitizers.Mask) != 0) && CfiCrossDso;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsCfiDiagRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 172,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 171,
   FQN="clang::driver::SanitizerArgs::needsCfiDiagRt", NM="_ZNK5clang6driver13SanitizerArgs14needsCfiDiagRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs14needsCfiDiagRtEv")
  //</editor-fold>
  public boolean needsCfiDiagRt() /*const*/ {
    return ((Sanitizers.Mask & CFI & ~TrapSanitizers.Mask) != 0) && CfiCrossDso;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsStatsRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 61,
   FQN="clang::driver::SanitizerArgs::needsStatsRt", NM="_ZNK5clang6driver13SanitizerArgs12needsStatsRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs12needsStatsRtEv")
  //</editor-fold>
  public boolean needsStatsRt() /*const*/ {
    return Stats;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsEsanRt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 62,
   FQN="clang::driver::SanitizerArgs::needsEsanRt", NM="_ZNK5clang6driver13SanitizerArgs11needsEsanRtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs11needsEsanRtEv")
  //</editor-fold>
  public boolean needsEsanRt() /*const*/ {
    return Sanitizers.hasOneOf(SanitizerKind.Efficiency);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::requiresPIE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 175,
   FQN="clang::driver::SanitizerArgs::requiresPIE", NM="_ZNK5clang6driver13SanitizerArgs11requiresPIEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs11requiresPIEEv")
  //</editor-fold>
  public boolean requiresPIE() /*const*/ {
    return NeedPIE || ((Sanitizers.Mask & SanitizerArgs_cpp_Unnamed_enum.RequiresPIE.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::needsUnwindTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 179,
   FQN="clang::driver::SanitizerArgs::needsUnwindTables", NM="_ZNK5clang6driver13SanitizerArgs17needsUnwindTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs17needsUnwindTablesEv")
  //</editor-fold>
  public boolean needsUnwindTables() /*const*/ {
    return ((Sanitizers.Mask & SanitizerArgs_cpp_Unnamed_enum.NeedsUnwindTables.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::linkCXXRuntimes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", old_line = 62,
   FQN="clang::driver::SanitizerArgs::linkCXXRuntimes", NM="_ZNK5clang6driver13SanitizerArgs15linkCXXRuntimesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs15linkCXXRuntimesEv")
  //</editor-fold>
  public boolean linkCXXRuntimes() /*const*/ {
    return LinkCXXRuntimes;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::addArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", line = 605,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp", old_line = 568,
   FQN="clang::driver::SanitizerArgs::addArgs", NM="_ZNK5clang6driver13SanitizerArgs7addArgsERKNS0_9ToolChainERKN4llvm3opt7ArgListERNS5_11SmallVectorIPKcLj16EEENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/SanitizerArgs.cpp -nm=_ZNK5clang6driver13SanitizerArgs7addArgsERKNS0_9ToolChainERKN4llvm3opt7ArgListERNS5_11SmallVectorIPKcLj16EEENS0_5types2IDE")
  //</editor-fold>
  public void addArgs(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
         ArgStringList/*&*/ CmdArgs, 
         types.ID InputType) /*const*/ {
    // Translate available CoverageFeatures to corresponding clang-cc1 flags.
    // Do it even if Sanitizers.empty() since some forms of coverage don't require
    // sanitizers.
    std.pairUIntType</*const*/char$ptr/*char P*/> CoverageFlags[/*8*/] = new std.pairUIntType [/*8*/] {
      std.make_pair_uint_T(CoverageFeature.CoverageFunc, $("-fsanitize-coverage-type=1")), 
      std.make_pair_uint_T(CoverageFeature.CoverageBB, $("-fsanitize-coverage-type=2")), 
      std.make_pair_uint_T(CoverageFeature.CoverageEdge, $("-fsanitize-coverage-type=3")), 
      std.make_pair_uint_T(CoverageFeature.CoverageIndirCall, $("-fsanitize-coverage-indirect-calls")), 
      std.make_pair_uint_T(CoverageFeature.CoverageTraceBB, $("-fsanitize-coverage-trace-bb")), 
      std.make_pair_uint_T(CoverageFeature.CoverageTraceCmp, $("-fsanitize-coverage-trace-cmp")), 
      std.make_pair_uint_T(CoverageFeature.Coverage8bitCounters, $("-fsanitize-coverage-8bit-counters")), 
      std.make_pair_uint_T(CoverageFeature.CoverageTracePC, $("-fsanitize-coverage-trace-pc"))};
    for (std.pairUIntType</*const*/char$ptr/*char P*/> F : CoverageFlags) {
      if (((CoverageFeatures & F.first) != 0)) {
        CmdArgs.push_back(Args.MakeArgString(new Twine(F.second)));
      }
    }
    if (TC.getTriple().isOSWindows() && needsUbsanRt()) {
      // Instruct the code generator to embed linker directives in the object file
      // that cause the required runtime libraries to be linked.
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"--dependent-lib=", TC.getCompilerRT(Args, new StringRef(/*KEEP_STR*/"ubsan_standalone"))))));
      if (types.isCXX(InputType)) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"--dependent-lib=", TC.getCompilerRT(Args, new StringRef(/*KEEP_STR*/"ubsan_standalone_cxx"))))));
      }
    }
    if (TC.getTriple().isOSWindows() && needsStatsRt()) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"--dependent-lib=", 
                      TC.getCompilerRT(Args, new StringRef(/*KEEP_STR*/"stats_client"))))));
      
      // The main executable must export the stats runtime.
      // FIXME: Only exporting from the main executable (e.g. based on whether the
      // translation unit defines main()) would save a little space, but having
      // multiple copies of the runtime shouldn't hurt.
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"--dependent-lib=", 
                      TC.getCompilerRT(Args, new StringRef(/*KEEP_STR*/"stats"))))));
      addIncludeLinkerOption(TC, Args, CmdArgs, new StringRef(/*KEEP_STR*/"__sanitizer_stats_register"));
    }
    if (Sanitizers.empty()) {
      return;
    }
    CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fsanitize=", __toString(Sanitizers)))));
    if (!RecoverableSanitizers.empty()) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fsanitize-recover=", 
                      __toString(RecoverableSanitizers)))));
    }
    if (!TrapSanitizers.empty()) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fsanitize-trap=", __toString(TrapSanitizers)))));
    }
    
    for (/*const*/std.string/*&*/ BLPath : BlacklistFiles) {
      SmallString/*64*/ BlacklistOpt/*J*/= new SmallString/*64*/(new StringRef(/*KEEP_STR*/"-fsanitize-blacklist="), 64);
      BlacklistOpt.$addassign(new StringRef(BLPath));
      CmdArgs.push_back(Args.MakeArgString(new Twine(BlacklistOpt)));
    }
    for (/*const*/std.string/*&*/ Dep : ExtraDeps) {
      SmallString/*64*/ ExtraDepOpt/*J*/= new SmallString/*64*/(new StringRef(/*KEEP_STR*/"-fdepfile-entry="), 64);
      ExtraDepOpt.$addassign(new StringRef(Dep));
      CmdArgs.push_back(Args.MakeArgString(new Twine(ExtraDepOpt)));
    }
    if ((MsanTrackOrigins != 0)) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fsanitize-memory-track-origins=", 
                      llvm.utostr($int2ulong(MsanTrackOrigins))))));
    }
    if (MsanUseAfterDtor) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-fsanitize-memory-use-after-dtor")));
    }
    if (CfiCrossDso) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-fsanitize-cfi-cross-dso")));
    }
    if (Stats) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-fsanitize-stats")));
    }
    if ((AsanFieldPadding != 0)) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fsanitize-address-field-padding=", 
                      llvm.utostr($int2ulong(AsanFieldPadding))))));
    }
    if (AsanUseAfterScope) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-fsanitize-address-use-after-scope")));
    }
    
    // MSan: Workaround for PR16386.
    // ASan: This is mainly to help LSan with cases such as
    // https://code.google.com/p/address-sanitizer/issues/detail?id=373
    // We can't make this conditional on -fsanitize=leak, as that flag shouldn't
    // affect compilation.
    if (Sanitizers.has(Memory) || Sanitizers.has(Address)) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-fno-assume-sane-operator-new")));
    }
    
    // Require -fvisibility= flag on non-Windows when compiling if vptr CFI is
    // enabled.
    if (Sanitizers.hasOneOf(SanitizerArgs_cpp_Unnamed_enum.CFIClasses.getValue()) && !TC.getTriple().isOSWindows()
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_fvisibility_EQ.getValue()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(TC.getDriver().Diag(diag.err_drv_argument_only_allowed_with)), 
                new StringRef(lastArgumentForMask(TC.getDriver(), Args, 
                        Sanitizers.Mask & SanitizerArgs_cpp_Unnamed_enum.CFIClasses.getValue()))), 
            /*KEEP_STR*/"-fvisibility="));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::SanitizerArgs::~SanitizerArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/SanitizerArgs.h", line = 24,
   FQN="clang::driver::SanitizerArgs::~SanitizerArgs", NM="_ZN5clang6driver13SanitizerArgsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN5clang6driver13SanitizerArgsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ExtraDeps.$destroy();
    BlacklistFiles.$destroy();
    //END JDestroy
  }


  
  public String toString() {
    return "" + "Sanitizers=" + Sanitizers // NOI18N
              + ", RecoverableSanitizers=" + RecoverableSanitizers // NOI18N
              + ", TrapSanitizers=" + TrapSanitizers // NOI18N
              + ", BlacklistFiles=" + BlacklistFiles // NOI18N
              + ", ExtraDeps=" + ExtraDeps // NOI18N
              + ", CoverageFeatures=" + CoverageFeatures // NOI18N
              + ", MsanTrackOrigins=" + MsanTrackOrigins // NOI18N
              + ", MsanUseAfterDtor=" + MsanUseAfterDtor // NOI18N
              + ", CfiCrossDso=" + CfiCrossDso // NOI18N
              + ", AsanFieldPadding=" + AsanFieldPadding // NOI18N
              + ", AsanSharedRuntime=" + AsanSharedRuntime // NOI18N
              + ", AsanUseAfterScope=" + AsanUseAfterScope // NOI18N
              + ", LinkCXXRuntimes=" + LinkCXXRuntimes // NOI18N
              + ", NeedPIE=" + NeedPIE // NOI18N
              + ", Stats=" + Stats; // NOI18N
  }
}
