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
package org.llvm.analysis.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type TargetLibraryInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.target.impl.TargetLibraryInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL10initializeRN4llvm21TargetLibraryInfoImplERKNS_6TripleENS_8ArrayRefIPKcEE;_ZL15ClVectorLibrary;_ZL16hasSinCosPiStretRKN4llvm6TripleE;_ZL20sanitizeFunctionNameN4llvm9StringRefE;_ZL21compareByScalarFnNameRKN4llvm7VecDescES2_;_ZL21compareByVectorFnNameRKN4llvm7VecDescES2_;_ZL23compareWithScalarFnNameRKN4llvm7VecDescENS_9StringRefE;_ZL23compareWithVectorFnNameRKN4llvm7VecDescENS_9StringRefE;_ZL46InitializeTargetLibraryInfoWrapperPassPassFlag;_ZL46initializeTargetLibraryInfoWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=TargetLibraryInfoStatics -package=org.llvm.analysis.target.impl")
//</editor-fold>
public final class TargetLibraryInfoStatics {

//<editor-fold defaultstate="collapsed" desc="ClVectorLibrary">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 19,
 FQN="ClVectorLibrary", NM="_ZL15ClVectorLibrary",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL15ClVectorLibrary")
//</editor-fold>
public static optEnum<TargetLibraryInfoImpl.VectorLibrary> ClVectorLibrary/*J*/= new optEnum<TargetLibraryInfoImpl.VectorLibrary>(TargetLibraryInfoImpl.VectorLibrary::valueOf, $("vector-library"), OptionHidden.Hidden, new desc($("Vector functions library")),
    ClGlobals.init(TargetLibraryInfoImpl.VectorLibrary.NoLibrary),
    ClGlobals.values($("none"), ((int)(TargetLibraryInfoImpl.VectorLibrary.NoLibrary.getValue())), $("No vector functions library"),
        $("Accelerate"), ((int)(TargetLibraryInfoImpl.VectorLibrary.Accelerate.getValue())), $("Accelerate framework"),
        (reinterpret_cast(Object/*void P*/ .class, ClGlobals.clEnumValEnd))));
//<editor-fold defaultstate="collapsed" desc="hasSinCosPiStret">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 33,
 FQN="hasSinCosPiStret", NM="_ZL16hasSinCosPiStretRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL16hasSinCosPiStretRKN4llvm6TripleE")
//</editor-fold>
public static boolean hasSinCosPiStret(final /*const*/ Triple /*&*/ T) {
  // Only Darwin variants have _stret versions of combined trig functions.
  if (!T.isOSDarwin()) {
    return false;
  }

  // The ABI is rather complicated on x86, so don't do anything special there.
  if (T.getArch() == Triple.ArchType.x86) {
    return false;
  }
  if (T.isMacOSX() && T.isMacOSXVersionLT(10, 9)) {
    return false;
  }
  if (T.isiOS() && T.isOSVersionLT(7, 0)) {
    return false;
  }

  return true;
}


/// initialize - Initialize the set of available library functions based on the
/// specified target triple.  This should be carefully written so that a missing
/// target triple gets a sane set of defaults.
//<editor-fold defaultstate="collapsed" desc="initialize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 54,
 FQN="initialize", NM="_ZL10initializeRN4llvm21TargetLibraryInfoImplERKNS_6TripleENS_8ArrayRefIPKcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL10initializeRN4llvm21TargetLibraryInfoImplERKNS_6TripleENS_8ArrayRefIPKcEE")
//</editor-fold>
public static void initialize(final TargetLibraryInfoImpl /*&*/ TLI, final /*const*/ Triple /*&*/ T,
          ArrayRef</*const*/char$ptr/*char P*/ > StandardNames) {
  // Verify that the StandardNames array is in alphabetical order.
  assert (std.is_sorted(StandardNames.begin(), StandardNames.end(), /*[]*/ (/*const*/char$ptr/*char P*/ LHS, /*const*/char$ptr/*char P*/ RHS) -> {
          return strcmp(LHS, RHS) < 0;
        })) : "TargetLibraryInfoImpl function names must be sorted";
  if (T.getArch() == Triple.ArchType.r600
     || T.getArch() == Triple.ArchType.amdgcn) {
    TLI.setUnavailable(Func.ldexp);
    TLI.setUnavailable(Func.ldexpf);
    TLI.setUnavailable(Func.ldexpl);
    TLI.setUnavailable(Func.exp10);
    TLI.setUnavailable(Func.exp10f);
    TLI.setUnavailable(Func.exp10l);
    TLI.setUnavailable(Func.log10);
    TLI.setUnavailable(Func.log10f);
    TLI.setUnavailable(Func.log10l);
  }

  // There are no library implementations of mempcy and memset for AMD gpus and
  // these can be difficult to lower in the backend.
  if (T.getArch() == Triple.ArchType.r600
     || T.getArch() == Triple.ArchType.amdgcn) {
    TLI.setUnavailable(Func.memcpy);
    TLI.setUnavailable(Func.memset);
    TLI.setUnavailable(Func.memset_pattern16);
    return;
  }

  // memset_pattern16 is only available on iOS 3.0 and Mac OS X 10.5 and later.
  // All versions of watchOS support it.
  if (T.isMacOSX()) {
    if (T.isMacOSXVersionLT(10, 5)) {
      TLI.setUnavailable(Func.memset_pattern16);
    }
  } else if (T.isiOS()) {
    if (T.isOSVersionLT(3, 0)) {
      TLI.setUnavailable(Func.memset_pattern16);
    }
  } else if (!T.isWatchOS()) {
    TLI.setUnavailable(Func.memset_pattern16);
  }
  if (!hasSinCosPiStret(T)) {
    TLI.setUnavailable(Func.sinpi);
    TLI.setUnavailable(Func.sinpif);
    TLI.setUnavailable(Func.cospi);
    TLI.setUnavailable(Func.cospif);
    TLI.setUnavailable(Func.sincospi_stret);
    TLI.setUnavailable(Func.sincospif_stret);
  }
  if (T.isMacOSX() && T.getArch() == Triple.ArchType.x86
     && !T.isMacOSXVersionLT(10, 7)) {
    // x86-32 OSX has a scheme where fwrite and fputs (and some other functions
    // we don't care about) have two versions; on recent OSX, the one we want
    // has a $UNIX2003 suffix. The two implementations are identical except
    // for the return value in some edge cases.  However, we don't want to
    // generate code that depends on the old symbols.
    TLI.setAvailableWithName(Func.fwrite, new StringRef(/*KEEP_STR*/"fwrite$UNIX2003"));
    TLI.setAvailableWithName(Func.fputs, new StringRef(/*KEEP_STR*/"fputs$UNIX2003"));
  }

  // iprintf and friends are only available on XCore and TCE.
  if (T.getArch() != Triple.ArchType.xcore && T.getArch() != Triple.ArchType.tce) {
    TLI.setUnavailable(Func.iprintf);
    TLI.setUnavailable(Func.siprintf);
    TLI.setUnavailable(Func.fiprintf);
  }
  if (T.isOSWindows() && !T.isOSCygMing()) {
    // Win32 does not support long double
    TLI.setUnavailable(Func.acosl);
    TLI.setUnavailable(Func.asinl);
    TLI.setUnavailable(Func.atanl);
    TLI.setUnavailable(Func.atan2l);
    TLI.setUnavailable(Func.ceill);
    TLI.setUnavailable(Func.copysignl);
    TLI.setUnavailable(Func.cosl);
    TLI.setUnavailable(Func.coshl);
    TLI.setUnavailable(Func.expl);
    TLI.setUnavailable(Func.fabsf); // Win32 and Win64 both lack fabsf
    TLI.setUnavailable(Func.fabsl);
    TLI.setUnavailable(Func.floorl);
    TLI.setUnavailable(Func.fmaxl);
    TLI.setUnavailable(Func.fminl);
    TLI.setUnavailable(Func.fmodl);
    TLI.setUnavailable(Func.frexpl);
    TLI.setUnavailable(Func.ldexpf);
    TLI.setUnavailable(Func.ldexpl);
    TLI.setUnavailable(Func.logl);
    TLI.setUnavailable(Func.modfl);
    TLI.setUnavailable(Func.powl);
    TLI.setUnavailable(Func.sinl);
    TLI.setUnavailable(Func.sinhl);
    TLI.setUnavailable(Func.sqrtl);
    TLI.setUnavailable(Func.tanl);
    TLI.setUnavailable(Func.tanhl);

    // Win32 only has C89 math
    TLI.setUnavailable(Func.acosh);
    TLI.setUnavailable(Func.acoshf);
    TLI.setUnavailable(Func.acoshl);
    TLI.setUnavailable(Func.asinh);
    TLI.setUnavailable(Func.asinhf);
    TLI.setUnavailable(Func.asinhl);
    TLI.setUnavailable(Func.atanh);
    TLI.setUnavailable(Func.atanhf);
    TLI.setUnavailable(Func.atanhl);
    TLI.setUnavailable(Func.cbrt);
    TLI.setUnavailable(Func.cbrtf);
    TLI.setUnavailable(Func.cbrtl);
    TLI.setUnavailable(Func.exp2);
    TLI.setUnavailable(Func.exp2f);
    TLI.setUnavailable(Func.exp2l);
    TLI.setUnavailable(Func.expm1);
    TLI.setUnavailable(Func.expm1f);
    TLI.setUnavailable(Func.expm1l);
    TLI.setUnavailable(Func.log2);
    TLI.setUnavailable(Func.log2f);
    TLI.setUnavailable(Func.log2l);
    TLI.setUnavailable(Func.log1p);
    TLI.setUnavailable(Func.log1pf);
    TLI.setUnavailable(Func.log1pl);
    TLI.setUnavailable(Func.logb);
    TLI.setUnavailable(Func.logbf);
    TLI.setUnavailable(Func.logbl);
    TLI.setUnavailable(Func.nearbyint);
    TLI.setUnavailable(Func.nearbyintf);
    TLI.setUnavailable(Func.nearbyintl);
    TLI.setUnavailable(Func.rint);
    TLI.setUnavailable(Func.rintf);
    TLI.setUnavailable(Func.rintl);
    TLI.setUnavailable(Func.round);
    TLI.setUnavailable(Func.roundf);
    TLI.setUnavailable(Func.roundl);
    TLI.setUnavailable(Func.trunc);
    TLI.setUnavailable(Func.truncf);
    TLI.setUnavailable(Func.truncl);

    // Win32 provides some C99 math with mangled names
    TLI.setAvailableWithName(Func.copysign, new StringRef(/*KEEP_STR*/"_copysign"));
    if (T.getArch() == Triple.ArchType.x86) {
      // Win32 on x86 implements single-precision math functions as macros
      TLI.setUnavailable(Func.acosf);
      TLI.setUnavailable(Func.asinf);
      TLI.setUnavailable(Func.atanf);
      TLI.setUnavailable(Func.atan2f);
      TLI.setUnavailable(Func.ceilf);
      TLI.setUnavailable(Func.copysignf);
      TLI.setUnavailable(Func.cosf);
      TLI.setUnavailable(Func.coshf);
      TLI.setUnavailable(Func.expf);
      TLI.setUnavailable(Func.floorf);
      TLI.setUnavailable(Func.fminf);
      TLI.setUnavailable(Func.fmaxf);
      TLI.setUnavailable(Func.fmodf);
      TLI.setUnavailable(Func.logf);
      TLI.setUnavailable(Func.log10f);
      TLI.setUnavailable(Func.modff);
      TLI.setUnavailable(Func.powf);
      TLI.setUnavailable(Func.sinf);
      TLI.setUnavailable(Func.sinhf);
      TLI.setUnavailable(Func.sqrtf);
      TLI.setUnavailable(Func.tanf);
      TLI.setUnavailable(Func.tanhf);
    }

    // Win32 does *not* provide provide these functions, but they are
    // generally available on POSIX-compliant systems:
    TLI.setUnavailable(Func.access);
    TLI.setUnavailable(Func.bcmp);
    TLI.setUnavailable(Func.bcopy);
    TLI.setUnavailable(Func.bzero);
    TLI.setUnavailable(Func.chmod);
    TLI.setUnavailable(Func.chown);
    TLI.setUnavailable(Func.closedir);
    TLI.setUnavailable(Func.ctermid);
    TLI.setUnavailable(Func.fdopen);
    TLI.setUnavailable(Func.ffs);
    TLI.setUnavailable(Func.fileno);
    TLI.setUnavailable(Func.flockfile);
    TLI.setUnavailable(Func.fseeko);
    TLI.setUnavailable(Func.fstat);
    TLI.setUnavailable(Func.fstatvfs);
    TLI.setUnavailable(Func.ftello);
    TLI.setUnavailable(Func.ftrylockfile);
    TLI.setUnavailable(Func.funlockfile);
    TLI.setUnavailable(Func.getc_unlocked);
    TLI.setUnavailable(Func.getitimer);
    TLI.setUnavailable(Func.getlogin_r);
    TLI.setUnavailable(Func.getpwnam);
    TLI.setUnavailable(Func.gettimeofday);
    TLI.setUnavailable(Func.htonl);
    TLI.setUnavailable(Func.htons);
    TLI.setUnavailable(Func.lchown);
    TLI.setUnavailable(Func.lstat);
    TLI.setUnavailable(Func.memccpy);
    TLI.setUnavailable(Func.mkdir);
    TLI.setUnavailable(Func.ntohl);
    TLI.setUnavailable(Func.ntohs);
    TLI.setUnavailable(Func.open);
    TLI.setUnavailable(Func.opendir);
    TLI.setUnavailable(Func.pclose);
    TLI.setUnavailable(Func.popen);
    TLI.setUnavailable(Func.pread);
    TLI.setUnavailable(Func.pwrite);
    TLI.setUnavailable(Func.read);
    TLI.setUnavailable(Func.readlink);
    TLI.setUnavailable(Func.realpath);
    TLI.setUnavailable(Func.rmdir);
    TLI.setUnavailable(Func.setitimer);
    TLI.setUnavailable(Func.stat);
    TLI.setUnavailable(Func.statvfs);
    TLI.setUnavailable(Func.stpcpy);
    TLI.setUnavailable(Func.stpncpy);
    TLI.setUnavailable(Func.strcasecmp);
    TLI.setUnavailable(Func.strncasecmp);
    TLI.setUnavailable(Func.times);
    TLI.setUnavailable(Func.uname);
    TLI.setUnavailable(Func.unlink);
    TLI.setUnavailable(Func.unsetenv);
    TLI.setUnavailable(Func.utime);
    TLI.setUnavailable(Func.utimes);
    TLI.setUnavailable(Func.write);

    // Win32 does *not* provide provide these functions, but they are
    // specified by C99:
    TLI.setUnavailable(Func.atoll);
    TLI.setUnavailable(Func.frexpf);
    TLI.setUnavailable(Func.llabs);
  }
  switch (T.getOS()) {
   case MacOSX:
    // exp10 and exp10f are not available on OS X until 10.9 and iOS until 7.0
    // and their names are __exp10 and __exp10f. exp10l is not available on
    // OS X or iOS.
    TLI.setUnavailable(Func.exp10l);
    if (T.isMacOSXVersionLT(10, 9)) {
      TLI.setUnavailable(Func.exp10);
      TLI.setUnavailable(Func.exp10f);
    } else {
      TLI.setAvailableWithName(Func.exp10, new StringRef(/*KEEP_STR*/"__exp10"));
      TLI.setAvailableWithName(Func.exp10f, new StringRef(/*KEEP_STR*/"__exp10f"));
    }
    break;
   case IOS:
   case TvOS:
   case WatchOS:
    TLI.setUnavailable(Func.exp10l);
    if (!T.isWatchOS() && (T.isOSVersionLT(7, 0)
       || (T.isOSVersionLT(9, 0)
       && (T.getArch() == Triple.ArchType.x86
       || T.getArch() == Triple.ArchType.x86_64)))) {
      TLI.setUnavailable(Func.exp10);
      TLI.setUnavailable(Func.exp10f);
    } else {
      TLI.setAvailableWithName(Func.exp10, new StringRef(/*KEEP_STR*/"__exp10"));
      TLI.setAvailableWithName(Func.exp10f, new StringRef(/*KEEP_STR*/"__exp10f"));
    }
    break;
   case Linux:
   default:
    // exp10, exp10f, exp10l is available on Linux (GLIBC) but are extremely
    // buggy prior to glibc version 2.18. Until this version is widely deployed
    // or we have a reasonable detection strategy, we cannot use exp10 reliably
    // on Linux.
    //
    // Fall through to disable all of them.
    TLI.setUnavailable(Func.exp10);
    TLI.setUnavailable(Func.exp10f);
    TLI.setUnavailable(Func.exp10l);
  }

  // ffsl is available on at least Darwin, Mac OS X, iOS, FreeBSD, and
  // Linux (GLIBC):
  // http://developer.apple.com/library/mac/#documentation/Darwin/Reference/ManPages/man3/ffsl.3.html
  // http://svn.freebsd.org/base/head/lib/libc/string/ffsl.c
  // http://www.gnu.org/software/gnulib/manual/html_node/ffsl.html
  switch (T.getOS()) {
   case Darwin:
   case MacOSX:
   case IOS:
   case TvOS:
   case WatchOS:
   case FreeBSD:
   case Linux:
    break;
   default:
    TLI.setUnavailable(Func.ffsl);
  }

  // ffsll is available on at least FreeBSD and Linux (GLIBC):
  // http://svn.freebsd.org/base/head/lib/libc/string/ffsll.c
  // http://www.gnu.org/software/gnulib/manual/html_node/ffsll.html
  switch (T.getOS()) {
   case Darwin:
   case MacOSX:
   case IOS:
   case TvOS:
   case WatchOS:
   case FreeBSD:
   case Linux:
    break;
   default:
    TLI.setUnavailable(Func.ffsll);
  }

  // The following functions are available on at least FreeBSD:
  // http://svn.freebsd.org/base/head/lib/libc/string/fls.c
  // http://svn.freebsd.org/base/head/lib/libc/string/flsl.c
  // http://svn.freebsd.org/base/head/lib/libc/string/flsll.c
  if (!T.isOSFreeBSD()) {
    TLI.setUnavailable(Func.fls);
    TLI.setUnavailable(Func.flsl);
    TLI.setUnavailable(Func.flsll);
  }

  // The following functions are available on at least Linux:
  if (!T.isOSLinux()) {
    TLI.setUnavailable(Func.dunder_strdup);
    TLI.setUnavailable(Func.dunder_strtok_r);
    TLI.setUnavailable(Func.dunder_isoc99_scanf);
    TLI.setUnavailable(Func.dunder_isoc99_sscanf);
    TLI.setUnavailable(Func.under_IO_getc);
    TLI.setUnavailable(Func.under_IO_putc);
    TLI.setUnavailable(Func.memalign);
    TLI.setUnavailable(Func.fopen64);
    TLI.setUnavailable(Func.fseeko64);
    TLI.setUnavailable(Func.fstat64);
    TLI.setUnavailable(Func.fstatvfs64);
    TLI.setUnavailable(Func.ftello64);
    TLI.setUnavailable(Func.lstat64);
    TLI.setUnavailable(Func.open64);
    TLI.setUnavailable(Func.stat64);
    TLI.setUnavailable(Func.statvfs64);
    TLI.setUnavailable(Func.tmpfile64);
  }

  // As currently implemented in clang, NVPTX code has no standard library to
  // speak of.  Headers provide a standard-ish library implementation, but many
  // of the signatures are wrong -- for example, many libm functions are not
  // extern "C".
  //
  // libdevice, an IR library provided by nvidia, is linked in by the front-end,
  // but only used functions are provided to llvm.  Moreover, most of the
  // functions in libdevice don't map precisely to standard library functions.
  //
  // FIXME: Having no standard library prevents e.g. many fastmath
  // optimizations, so this situation should be fixed.
  if (T.isNVPTX()) {
    TLI.disableAllFunctions();
    TLI.setAvailable(Func.nvvm_reflect);
  } else {
    TLI.setUnavailable(Func.nvvm_reflect);
  }

  TLI.addVectorizableFunctionsFromVecLib(ClVectorLibrary.$T());
}

//<editor-fold defaultstate="collapsed" desc="sanitizeFunctionName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 459,
 FQN="sanitizeFunctionName", NM="_ZL20sanitizeFunctionNameN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL20sanitizeFunctionNameN4llvm9StringRefE")
//</editor-fold>
public static StringRef sanitizeFunctionName(StringRef funcName) {
  // Filter out empty names and names containing null bytes, those can't be in
  // our table.
  if (funcName.empty() || funcName.find($$TERM) != StringRef.npos) {
    return new StringRef();
  }

  // Check for \01 prefix that is used to mangle __asm declarations and
  // strip it if present.
  return GlobalValue.getRealLinkageName(new StringRef(funcName));
}

//<editor-fold defaultstate="collapsed" desc="compareByScalarFnName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1006,
 FQN="compareByScalarFnName", NM="_ZL21compareByScalarFnNameRKN4llvm7VecDescES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL21compareByScalarFnNameRKN4llvm7VecDescES2_")
//</editor-fold>
public static boolean compareByScalarFnName(final /*const*/ VecDesc /*&*/ LHS, final /*const*/ VecDesc /*&*/ RHS) {
  return std.strncmp(LHS.ScalarFnName, RHS.ScalarFnName,
      std.strlen(RHS.ScalarFnName)) < 0;
}

//<editor-fold defaultstate="collapsed" desc="compareByVectorFnName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1011,
 FQN="compareByVectorFnName", NM="_ZL21compareByVectorFnNameRKN4llvm7VecDescES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL21compareByVectorFnNameRKN4llvm7VecDescES2_")
//</editor-fold>
public static boolean compareByVectorFnName(final /*const*/ VecDesc /*&*/ LHS, final /*const*/ VecDesc /*&*/ RHS) {
  return std.strncmp(LHS.VectorFnName, RHS.VectorFnName,
      std.strlen(RHS.VectorFnName)) < 0;
}

//<editor-fold defaultstate="collapsed" desc="compareWithScalarFnName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1016,
 FQN="compareWithScalarFnName", NM="_ZL23compareWithScalarFnNameRKN4llvm7VecDescENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL23compareWithScalarFnNameRKN4llvm7VecDescENS_9StringRefE")
//</editor-fold>
public static boolean compareWithScalarFnName(final /*const*/ VecDesc /*&*/ LHS, StringRef S) {
  return std.strncmp(LHS.ScalarFnName, S.data(), S.size()) < 0;
}

//<editor-fold defaultstate="collapsed" desc="compareWithVectorFnName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1020,
 FQN="compareWithVectorFnName", NM="_ZL23compareWithVectorFnNameRKN4llvm7VecDescENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL23compareWithVectorFnNameRKN4llvm7VecDescENS_9StringRefE")
//</editor-fold>
public static boolean compareWithVectorFnName(final /*const*/ VecDesc /*&*/ LHS, StringRef S) {
  return std.strncmp(LHS.VectorFnName, S.data(), S.size()) < 0;
}


// Register the basic pass.
//<editor-fold defaultstate="collapsed" desc="initializeTargetLibraryInfoWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1168,
 FQN="initializeTargetLibraryInfoWrapperPassPassOnce", NM="_ZL46initializeTargetLibraryInfoWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL46initializeTargetLibraryInfoWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeTargetLibraryInfoWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Target Library Information"), $("targetlibinfo"), $AddrOf(TargetLibraryInfoWrapperPass.ID),
          ()->IrLlvmGlobals.callDefaultCtor(TargetLibraryInfoWrapperPass.class), false, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeTargetLibraryInfoWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1168,
 FQN="InitializeTargetLibraryInfoWrapperPassPassFlag", NM="_ZL46InitializeTargetLibraryInfoWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZL46InitializeTargetLibraryInfoWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeTargetLibraryInfoWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class TargetLibraryInfoStatics
