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

package org.llvm.analysis.target;

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
import org.llvm.analysis.target.impl.TargetLibraryInfoStatics;
import static org.llvm.analysis.target.impl.TargetLibraryInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.*;


/// Implementation of the target library information.
///
/// This class constructs tables that hold the target library information and
/// make it available. However, it is somewhat expensive to compute and only
/// depends on the triple. So users typically interact with the \c
/// TargetLibraryInfo wrapper below.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 48,
 FQN="llvm::TargetLibraryInfoImpl", NM="_ZN4llvm21TargetLibraryInfoImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplE")
//</editor-fold>
public class TargetLibraryInfoImpl implements Destructors.ClassWithDestructor {
  /*friend  class TargetLibraryInfo*/

  private /*uchar*/byte AvailableArray[/*89*/] = new /*uchar*/byte [89];
  /*friend*/public/*private*/ DenseMapUIntType<std.string> CustomNames;
  /*friend*/public/*private*/ static type$ptr</*const*/char$ptr/*char P*//*const*//*[354]*/> StandardNames = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*354*/] {
    $("??2@YAPAXI@Z"),
    $("??2@YAPAXIABUnothrow_t@std@@@Z"),
    $("??2@YAPEAX_K@Z"),
    $("??2@YAPEAX_KAEBUnothrow_t@std@@@Z"),
    $("??3@YAXPAX@Z"),
    $("??3@YAXPAXABUnothrow_t@std@@@Z"),
    $("??3@YAXPAXI@Z"),
    $("??3@YAXPEAX@Z"),
    $("??3@YAXPEAXAEBUnothrow_t@std@@@Z"),
    $("??3@YAXPEAX_K@Z"),
    $("??_U@YAPAXI@Z"),
    $("??_U@YAPAXIABUnothrow_t@std@@@Z"),
    $("??_U@YAPEAX_K@Z"),
    $("??_U@YAPEAX_KAEBUnothrow_t@std@@@Z"),
    $("??_V@YAXPAX@Z"),
    $("??_V@YAXPAXABUnothrow_t@std@@@Z"),
    $("??_V@YAXPAXI@Z"),
    $("??_V@YAXPEAX@Z"),
    $("??_V@YAXPEAXAEBUnothrow_t@std@@@Z"),
    $("??_V@YAXPEAX_K@Z"),
    $("_IO_getc"),
    $("_IO_putc"),
    $("_ZdaPv"),
    $("_ZdaPvRKSt9nothrow_t"),
    $("_ZdaPvj"),
    $("_ZdaPvm"),
    $("_ZdlPv"),
    $("_ZdlPvRKSt9nothrow_t"),
    $("_ZdlPvj"),
    $("_ZdlPvm"),
    $("_Znaj"),
    $("_ZnajRKSt9nothrow_t"),
    $("_Znam"),
    $("_ZnamRKSt9nothrow_t"),
    $("_Znwj"),
    $("_ZnwjRKSt9nothrow_t"),
    $("_Znwm"),
    $("_ZnwmRKSt9nothrow_t"),
    $("__cospi"),
    $("__cospif"),
    $("__cxa_atexit"),
    $("__cxa_guard_abort"),
    $("__cxa_guard_acquire"),
    $("__cxa_guard_release"),
    $("__isoc99_scanf"),
    $("__isoc99_sscanf"),
    $("__memcpy_chk"),
    $("__memmove_chk"),
    $("__memset_chk"),
    $("__nvvm_reflect"),
    $("__sincospi_stret"),
    $("__sincospif_stret"),
    $("__sinpi"),
    $("__sinpif"),
    $("__sqrt_finite"),
    $("__sqrtf_finite"),
    $("__sqrtl_finite"),
    $("__stpcpy_chk"),
    $("__stpncpy_chk"),
    $("__strcpy_chk"),
    $("__strdup"),
    $("__strncpy_chk"),
    $("__strndup"),
    $("__strtok_r"),
    $("abs"),
    $("access"),
    $("acos"),
    $("acosf"),
    $("acosh"),
    $("acoshf"),
    $("acoshl"),
    $("acosl"),
    $("asin"),
    $("asinf"),
    $("asinh"),
    $("asinhf"),
    $("asinhl"),
    $("asinl"),
    $("atan"),
    $("atan2"),
    $("atan2f"),
    $("atan2l"),
    $("atanf"),
    $("atanh"),
    $("atanhf"),
    $("atanhl"),
    $("atanl"),
    $("atof"),
    $("atoi"),
    $("atol"),
    $("atoll"),
    $("bcmp"),
    $("bcopy"),
    $("bzero"),
    $("calloc"),
    $("cbrt"),
    $("cbrtf"),
    $("cbrtl"),
    $("ceil"),
    $("ceilf"),
    $("ceill"),
    $("chmod"),
    $("chown"),
    $("clearerr"),
    $("closedir"),
    $("copysign"),
    $("copysignf"),
    $("copysignl"),
    $("cos"),
    $("cosf"),
    $("cosh"),
    $("coshf"),
    $("coshl"),
    $("cosl"),
    $("ctermid"),
    $("exp"),
    $("exp10"),
    $("exp10f"),
    $("exp10l"),
    $("exp2"),
    $("exp2f"),
    $("exp2l"),
    $("expf"),
    $("expl"),
    $("expm1"),
    $("expm1f"),
    $("expm1l"),
    $("fabs"),
    $("fabsf"),
    $("fabsl"),
    $("fclose"),
    $("fdopen"),
    $("feof"),
    $("ferror"),
    $("fflush"),
    $("ffs"),
    $("ffsl"),
    $("ffsll"),
    $("fgetc"),
    $("fgetpos"),
    $("fgets"),
    $("fileno"),
    $("fiprintf"),
    $("flockfile"),
    $("floor"),
    $("floorf"),
    $("floorl"),
    $("fls"),
    $("flsl"),
    $("flsll"),
    $("fmax"),
    $("fmaxf"),
    $("fmaxl"),
    $("fmin"),
    $("fminf"),
    $("fminl"),
    $("fmod"),
    $("fmodf"),
    $("fmodl"),
    $("fopen"),
    $("fopen64"),
    $("fprintf"),
    $("fputc"),
    $("fputs"),
    $("fread"),
    $("free"),
    $("frexp"),
    $("frexpf"),
    $("frexpl"),
    $("fscanf"),
    $("fseek"),
    $("fseeko"),
    $("fseeko64"),
    $("fsetpos"),
    $("fstat"),
    $("fstat64"),
    $("fstatvfs"),
    $("fstatvfs64"),
    $("ftell"),
    $("ftello"),
    $("ftello64"),
    $("ftrylockfile"),
    $("funlockfile"),
    $("fwrite"),
    $("getc"),
    $("getc_unlocked"),
    $("getchar"),
    $("getenv"),
    $("getitimer"),
    $("getlogin_r"),
    $("getpwnam"),
    $("gets"),
    $("gettimeofday"),
    $("htonl"),
    $("htons"),
    $("iprintf"),
    $("isascii"),
    $("isdigit"),
    $("labs"),
    $("lchown"),
    $("ldexp"),
    $("ldexpf"),
    $("ldexpl"),
    $("llabs"),
    $("log"),
    $("log10"),
    $("log10f"),
    $("log10l"),
    $("log1p"),
    $("log1pf"),
    $("log1pl"),
    $("log2"),
    $("log2f"),
    $("log2l"),
    $("logb"),
    $("logbf"),
    $("logbl"),
    $("logf"),
    $("logl"),
    $("lstat"),
    $("lstat64"),
    $("malloc"),
    $("memalign"),
    $("memccpy"),
    $("memchr"),
    $("memcmp"),
    $("memcpy"),
    $("memmove"),
    $("memrchr"),
    $("memset"),
    $("memset_pattern16"),
    $("mkdir"),
    $("mktime"),
    $("modf"),
    $("modff"),
    $("modfl"),
    $("nearbyint"),
    $("nearbyintf"),
    $("nearbyintl"),
    $("ntohl"),
    $("ntohs"),
    $("open"),
    $("open64"),
    $("opendir"),
    $("pclose"),
    $("perror"),
    $("popen"),
    $("posix_memalign"),
    $("pow"),
    $("powf"),
    $("powl"),
    $("pread"),
    $("printf"),
    $("putc"),
    $("putchar"),
    $("puts"),
    $("pwrite"),
    $("qsort"),
    $("read"),
    $("readlink"),
    $("realloc"),
    $("reallocf"),
    $("realpath"),
    $("remove"),
    $("rename"),
    $("rewind"),
    $("rint"),
    $("rintf"),
    $("rintl"),
    $("rmdir"),
    $("round"),
    $("roundf"),
    $("roundl"),
    $("scanf"),
    $("setbuf"),
    $("setitimer"),
    $("setvbuf"),
    $("sin"),
    $("sinf"),
    $("sinh"),
    $("sinhf"),
    $("sinhl"),
    $("sinl"),
    $("siprintf"),
    $("snprintf"),
    $("sprintf"),
    $("sqrt"),
    $("sqrtf"),
    $("sqrtl"),
    $("sscanf"),
    $("stat"),
    $("stat64"),
    $("statvfs"),
    $("statvfs64"),
    $("stpcpy"),
    $("stpncpy"),
    $("strcasecmp"),
    $("strcat"),
    $("strchr"),
    $("strcmp"),
    $("strcoll"),
    $("strcpy"),
    $("strcspn"),
    $("strdup"),
    $("strlen"),
    $("strncasecmp"),
    $("strncat"),
    $("strncmp"),
    $("strncpy"),
    $("strndup"),
    $("strnlen"),
    $("strpbrk"),
    $("strrchr"),
    $("strspn"),
    $("strstr"),
    $("strtod"),
    $("strtof"),
    $("strtok"),
    $("strtok_r"),
    $("strtol"),
    $("strtold"),
    $("strtoll"),
    $("strtoul"),
    $("strtoull"),
    $("strxfrm"),
    $("system"),
    $("tan"),
    $("tanf"),
    $("tanh"),
    $("tanhf"),
    $("tanhl"),
    $("tanl"),
    $("times"),
    $("tmpfile"),
    $("tmpfile64"),
    $("toascii"),
    $("trunc"),
    $("truncf"),
    $("truncl"),
    $("uname"),
    $("ungetc"),
    $("unlink"),
    $("unsetenv"),
    $("utime"),
    $("utimes"),
    $("valloc"),
    $("vfprintf"),
    $("vfscanf"),
    $("vprintf"),
    $("vscanf"),
    $("vsnprintf"),
    $("vsprintf"),
    $("vsscanf"),
    $("write")
  });

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::AvailabilityState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 55,
   FQN="llvm::TargetLibraryInfoImpl::AvailabilityState", NM="_ZN4llvm21TargetLibraryInfoImpl17AvailabilityStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl17AvailabilityStateE")
  //</editor-fold>
  /*friend*/public/*private*/ enum AvailabilityState implements Native.NativeUIntEnum {
    StandardName(3), // (memset to all ones)
    CustomName(1),
    Unavailable(0); // (memset to all zeros)

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AvailabilityState valueOf(int val) {
      AvailabilityState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AvailabilityState[] VALUES;
      private static final AvailabilityState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AvailabilityState kind : AvailabilityState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AvailabilityState[min < 0 ? (1-min) : 0];
        VALUES = new AvailabilityState[max >= 0 ? (1+max) : 0];
        for (AvailabilityState kind : AvailabilityState.values()) {
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
    private AvailabilityState(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::setState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 60,
   FQN="llvm::TargetLibraryInfoImpl::setState", NM="_ZN4llvm21TargetLibraryInfoImpl8setStateENS_7LibFunc4FuncENS0_17AvailabilityStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl8setStateENS_7LibFunc4FuncENS0_17AvailabilityStateE")
  //</editor-fold>
  private void setState(Func F, AvailabilityState State) {
    AvailableArray[F.getValue() / 4] &= ~(3 << 2 * (F.getValue() & 3));
    AvailableArray[F.getValue() / 4] |= State.getValue() << 2 * (F.getValue() & 3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 64,
   FQN="llvm::TargetLibraryInfoImpl::getState", NM="_ZNK4llvm21TargetLibraryInfoImpl8getStateENS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl8getStateENS_7LibFunc4FuncE")
  //</editor-fold>
  /*friend*/public/*private*/ AvailabilityState getState(Func F) /*const*/ {
    return /*static_cast*/AvailabilityState.valueOf(($uchar2int(AvailableArray[F.getValue() / 4]) >> 2 * (F.getValue() & 3)) & 3);
  }


  /// Vectorization descriptors - sorted by ScalarFnName.
  private std.vector<VecDesc> VectorDescs;
  /// Scalarization descriptors - same content as VectorDescs but sorted based
  /// on VectorFnName rather than ScalarFnName.
  private std.vector<VecDesc> ScalarDescs;

  /// Return true if the function type FTy is valid for the library function
  /// F, regardless of whether the function is available.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::isValidProtoForLibFunc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 490,
   FQN="llvm::TargetLibraryInfoImpl::isValidProtoForLibFunc", NM="_ZNK4llvm21TargetLibraryInfoImpl22isValidProtoForLibFuncERKNS_12FunctionTypeENS_7LibFunc4FuncEPKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl22isValidProtoForLibFuncERKNS_12FunctionTypeENS_7LibFunc4FuncEPKNS_10DataLayoutE")
  //</editor-fold>
  private boolean isValidProtoForLibFunc(final /*const*/ FunctionType /*&*/ FTy,
                        Func F,
                        /*const*/ DataLayout /*P*/ DL) /*const*/ {
    //throw new UnsupportedOperationException("EmptyBody");
    final LLVMContext /*&*/ Ctx = FTy.getContext();
    Type /*P*/ PCharTy = Type.getInt8PtrTy(Ctx);
    Type /*P*/ SizeTTy = (DL != null) ? DL.getIntPtrType(Ctx, /*AS=*/ 0) : null;
    /*ADD MAPPING FOR FUN PTR[bool (Type * ) const]*/BoolPredicate<Type /*P*/> IsSizeTTy /*const*/ = /*[=L$SizeTTy(SizeTTy)]*/ (Type /*P*/ Ty) -> {
          return (SizeTTy != null) ? Ty == SizeTTy : Ty.isIntegerTy();
        };
    /*uint*/int NumParams = FTy.getNumParams();
    switch (F) {
     case strlen:
      return (NumParams == 1 && FTy.getParamType(0).isPointerTy()
         && FTy.getReturnType().isIntegerTy());
     case strchr:
     case strrchr:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0) == FTy.getReturnType()
         && FTy.getParamType(1).isIntegerTy());
     case strtol:
     case strtod:
     case strtof:
     case strtoul:
     case strtoll:
     case strtold:
     case strtoull:
      return ((NumParams == 2 || NumParams == 3)
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case strcat:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0) == FTy.getReturnType()
         && FTy.getParamType(1) == FTy.getReturnType());
     case strncat:
      return (NumParams == 3 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0) == FTy.getReturnType()
         && FTy.getParamType(1) == FTy.getReturnType()
         && FTy.getParamType(2).isIntegerTy());
     case strcpy_chk:
     case stpcpy_chk:
      --NumParams;
      if (!IsSizeTTy.$call(FTy.getParamType(NumParams))) {
        return false;
      }
     case strcpy:
     case stpcpy:
      // fallthrough
      return (NumParams == 2 && FTy.getReturnType() == FTy.getParamType(0)
         && FTy.getParamType(0) == FTy.getParamType(1)
         && FTy.getParamType(0) == PCharTy);
     case strncpy_chk:
     case stpncpy_chk:
      --NumParams;
      if (!IsSizeTTy.$call(FTy.getParamType(NumParams))) {
        return false;
      }
     case strncpy:
     case stpncpy:
      // fallthrough
      return (NumParams == 3 && FTy.getReturnType() == FTy.getParamType(0)
         && FTy.getParamType(0) == FTy.getParamType(1)
         && FTy.getParamType(0) == PCharTy
         && FTy.getParamType(2).isIntegerTy());
     case strxfrm:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case strcmp:
      return (NumParams == 2 && FTy.getReturnType().isIntegerTy(32)
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(0) == FTy.getParamType(1));
     case strncmp:
      return (NumParams == 3 && FTy.getReturnType().isIntegerTy(32)
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(0) == FTy.getParamType(1)
         && FTy.getParamType(2).isIntegerTy());
     case strspn:
     case strcspn:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(0) == FTy.getParamType(1)
         && FTy.getReturnType().isIntegerTy());
     case strcoll:
     case strcasecmp:
     case strncasecmp:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case strstr:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case strpbrk:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy()
         && FTy.getReturnType() == FTy.getParamType(0)
         && FTy.getParamType(0) == FTy.getParamType(1));
     case strtok:
     case strtok_r:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(1).isPointerTy());
     case scanf:
     case setbuf:
     case setvbuf:
      return ($greatereq_uint(NumParams, 1) && FTy.getParamType(0).isPointerTy());
     case strdup:
     case strndup:
      return ($greatereq_uint(NumParams, 1) && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy());
     case sscanf:
     case stat:
     case statvfs:
     case sprintf:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case snprintf:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case setitimer:
      return (NumParams == 3 && FTy.getParamType(1).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case system:
      return (NumParams == 1 && FTy.getParamType(0).isPointerTy());
     case malloc:
      return (NumParams == 1 && FTy.getReturnType().isPointerTy());
     case memcmp:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy()
         && FTy.getReturnType().isIntegerTy(32));
     case memchr:
     case memrchr:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isIntegerTy(32)
         && FTy.getParamType(2).isIntegerTy()
         && FTy.getReturnType().isPointerTy());
     case modf:
     case modff:
     case modfl:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(1).isPointerTy());
     case memcpy_chk:
     case memmove_chk:
      --NumParams;
      if (!IsSizeTTy.$call(FTy.getParamType(NumParams))) {
        return false;
      }
     case memcpy:
     case memmove:
      // fallthrough
      return (NumParams == 3 && FTy.getReturnType() == FTy.getParamType(0)
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy()
         && IsSizeTTy.$call(FTy.getParamType(2)));
     case memset_chk:
      --NumParams;
      if (!IsSizeTTy.$call(FTy.getParamType(NumParams))) {
        return false;
      }
     case memset:
      // fallthrough
      return (NumParams == 3 && FTy.getReturnType() == FTy.getParamType(0)
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isIntegerTy()
         && IsSizeTTy.$call(FTy.getParamType(2)));
     case memccpy:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(1).isPointerTy());
     case memalign:
      return (FTy.getReturnType().isPointerTy());
     case realloc:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy()
         && FTy.getReturnType().isPointerTy());
     case read:
      return (NumParams == 3 && FTy.getParamType(1).isPointerTy());
     case rewind:
     case rmdir:
     case remove:
     case realpath:
      return ($greatereq_uint(NumParams, 1) && FTy.getParamType(0).isPointerTy());
     case rename:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case readlink:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case write:
      return (NumParams == 3 && FTy.getParamType(1).isPointerTy());
     case bcopy:
     case bcmp:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case bzero:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy());
     case calloc:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy());
     case atof:
     case atoi:
     case atol:
     case atoll:
     case ferror:
     case getenv:
     case getpwnam:
     case pclose:
     case perror:
     case printf:
     case puts:
     case uname:
     case under_IO_getc:
     case unlink:
     case unsetenv:
      return (NumParams == 1 && FTy.getParamType(0).isPointerTy());
     case chmod:
     case chown:
     case clearerr:
     case closedir:
     case ctermid:
     case fclose:
     case feof:
     case fflush:
     case fgetc:
     case fileno:
     case flockfile:
     case free:
     case fseek:
     case fseeko64:
     case fseeko:
     case fsetpos:
     case ftell:
     case ftello64:
     case ftello:
     case ftrylockfile:
     case funlockfile:
     case getc:
     case getc_unlocked:
     case getlogin_r:
     case mkdir:
     case mktime:
     case times:
      return (NumParams != 0 && FTy.getParamType(0).isPointerTy());
     case access:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy());
     case fopen:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case fdopen:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case fputc:
     case fstat:
     case frexp:
     case frexpf:
     case frexpl:
     case fstatvfs:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case fgets:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case fread:
      return (NumParams == 4 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(3).isPointerTy());
     case fwrite:
      return (NumParams == 4 && FTy.getReturnType().isIntegerTy()
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isIntegerTy()
         && FTy.getParamType(2).isIntegerTy()
         && FTy.getParamType(3).isPointerTy());
     case fputs:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case fscanf:
     case fprintf:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case fgetpos:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case gets:
     case getchar:
     case getitimer:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case ungetc:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case utime:
     case utimes:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case putc:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case pread:
     case pwrite:
      return (NumParams == 4 && FTy.getParamType(1).isPointerTy());
     case popen:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case vscanf:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case vsscanf:
      return (NumParams == 3 && FTy.getParamType(1).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case vfscanf:
      return (NumParams == 3 && FTy.getParamType(1).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case valloc:
      return (FTy.getReturnType().isPointerTy());
     case vprintf:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy());
     case vfprintf:
     case vsprintf:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case vsnprintf:
      return (NumParams == 4 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case open:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy());
     case opendir:
      return (NumParams == 1 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy());
     case tmpfile:
      return (FTy.getReturnType().isPointerTy());
     case htonl:
     case htons:
     case ntohl:
     case ntohs:
     case lstat:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case lchown:
      return (NumParams == 3 && FTy.getParamType(0).isPointerTy());
     case qsort:
      return (NumParams == 4 && FTy.getParamType(3).isPointerTy());
     case dunder_strdup:
     case dunder_strndup:
      return ($greatereq_uint(NumParams, 1) && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy());
     case dunder_strtok_r:
      return (NumParams == 3 && FTy.getParamType(1).isPointerTy());
     case under_IO_putc:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case dunder_isoc99_scanf:
      return ($greatereq_uint(NumParams, 1) && FTy.getParamType(0).isPointerTy());
     case stat64:
     case lstat64:
     case statvfs64:
      return ($greatereq_uint(NumParams, 1) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case dunder_isoc99_sscanf:
      return ($greatereq_uint(NumParams, 1) && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case fopen64:
      return (NumParams == 2 && FTy.getReturnType().isPointerTy()
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case tmpfile64:
      return (FTy.getReturnType().isPointerTy());
     case fstat64:
     case fstatvfs64:
      return (NumParams == 2 && FTy.getParamType(1).isPointerTy());
     case open64:
      return ($greatereq_uint(NumParams, 2) && FTy.getParamType(0).isPointerTy());
     case gettimeofday:
      return (NumParams == 2 && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy());
     case Znwj: // new(unsigned int);
     case Znwm: // new(unsigned long);
     case Znaj: // new[](unsigned int);
     case Znam: // new[](unsigned long);
     case msvc_new_int: // new(unsigned int);
     case msvc_new_longlong: // new(unsigned long long);
     case msvc_new_array_int: // new[](unsigned int);
     case msvc_new_array_longlong: // new[](unsigned long long);
      return (NumParams == 1);
     case memset_pattern16:
      return (!FTy.isVarArg() && NumParams == 3
         && isa_PointerType(FTy.getParamType(0))
         &&isa_PointerType(FTy.getParamType(1))
         && isa_IntegerType(FTy.getParamType(2)));
     case nvvm_reflect:

      // int __nvvm_reflect(const char *);
      return (NumParams == 1 && isa_PointerType(FTy.getParamType(0)));
     case sin:
     case sinf:
     case sinl:
     case cos:
     case cosf:
     case cosl:
     case tan:
     case tanf:
     case tanl:
     case exp:
     case expf:
     case expl:
     case exp2:
     case exp2f:
     case exp2l:
     case log:
     case logf:
     case logl:
     case log10:
     case log10f:
     case log10l:
     case log2:
     case log2f:
     case log2l:
     case fabs:
     case fabsf:
     case fabsl:
     case floor:
     case floorf:
     case floorl:
     case ceil:
     case ceilf:
     case ceill:
     case trunc:
     case truncf:
     case truncl:
     case rint:
     case rintf:
     case rintl:
     case nearbyint:
     case nearbyintf:
     case nearbyintl:
     case round:
     case roundf:
     case roundl:
     case sqrt:
     case sqrtf:
     case sqrtl:
      return (NumParams == 1 && FTy.getReturnType().isFloatingPointTy()
         && FTy.getReturnType() == FTy.getParamType(0));
     case fmin:
     case fminf:
     case fminl:
     case fmax:
     case fmaxf:
     case fmaxl:
     case copysign:
     case copysignf:
     case copysignl:
     case pow:
     case powf:
     case powl:
      return (NumParams == 2 && FTy.getReturnType().isFloatingPointTy()
         && FTy.getReturnType() == FTy.getParamType(0)
         && FTy.getReturnType() == FTy.getParamType(1));
     case ffs:
     case ffsl:
     case ffsll:
     case isdigit:
     case isascii:
     case toascii:
      return (NumParams == 1 && FTy.getReturnType().isIntegerTy(32)
         && FTy.getParamType(0).isIntegerTy());
     case fls:
     case flsl:
     case flsll:
     case abs:
     case labs:
     case llabs:
      return (NumParams == 1 && FTy.getReturnType().isIntegerTy()
         && FTy.getReturnType() == FTy.getParamType(0));
     case cxa_atexit:
      return (NumParams == 3 && FTy.getReturnType().isIntegerTy()
         && FTy.getParamType(0).isPointerTy()
         && FTy.getParamType(1).isPointerTy()
         && FTy.getParamType(2).isPointerTy());
     case sinpi:
     case cospi:
      return (NumParams == 1 && FTy.getReturnType().isDoubleTy()
         && FTy.getReturnType() == FTy.getParamType(0));
     case sinpif:
     case cospif:
      return (NumParams == 1 && FTy.getReturnType().isFloatTy()
         && FTy.getReturnType() == FTy.getParamType(0));
     default:
      // Assume the other functions are correct.
      // FIXME: It'd be really nice to cover them all.
      return true;
    }
  }

/*public:*/
  /// List of known vector-functions libraries.
  ///
  /// The vector-functions library defines, which functions are vectorizable
  /// and with which factor. The library can be specified by either frontend,
  /// or a commandline option, and then used by
  /// addVectorizableFunctionsFromVecLib for filling up the tables of
  /// vectorizable functions.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::VectorLibrary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 87,
   FQN="llvm::TargetLibraryInfoImpl::VectorLibrary", NM="_ZN4llvm21TargetLibraryInfoImpl13VectorLibraryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl13VectorLibraryE")
  //</editor-fold>
  public enum VectorLibrary implements Native.NativeUIntEnum {
    NoLibrary(0), // Don't use any vector library.
    Accelerate(NoLibrary.getValue() + 1); // Use Accelerate framework.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VectorLibrary valueOf(int val) {
      VectorLibrary out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VectorLibrary[] VALUES;
      private static final VectorLibrary[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VectorLibrary kind : VectorLibrary.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VectorLibrary[min < 0 ? (1-min) : 0];
        VALUES = new VectorLibrary[max >= 0 ? (1+max) : 0];
        for (VectorLibrary kind : VectorLibrary.values()) {
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
    private VectorLibrary(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 417,
   FQN="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl", NM="_ZN4llvm21TargetLibraryInfoImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplC1Ev")
  //</editor-fold>
  public TargetLibraryInfoImpl() {
    // : CustomNames(), VectorDescs(), ScalarDescs()
    //START JInit
    this.CustomNames = new DenseMapUIntType<std.string>(DenseMapInfoUInt.$Info(), new std.string());
    this.VectorDescs = new std.vector<VecDesc>(new VecDesc());
    this.ScalarDescs = new std.vector<VecDesc>(new VecDesc());
    //END JInit
    // Default to everything being available.
    memset(AvailableArray, (byte)-1, sizeof(AvailableArray));

    TargetLibraryInfoStatics.initialize(/*Deref*/this, new Triple(), new ArrayRef</*const*/char$ptr/*char P*/ >(StandardNames.$array()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 424,
   FQN="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl", NM="_ZN4llvm21TargetLibraryInfoImplC1ERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplC1ERKNS_6TripleE")
  //</editor-fold>
  public TargetLibraryInfoImpl(final /*const*/ Triple /*&*/ T) {
    // : CustomNames(), VectorDescs(), ScalarDescs()
    //START JInit
    this.CustomNames = new DenseMapUIntType<std.string>(DenseMapInfoUInt.$Info(), new std.string());
    this.VectorDescs = new std.vector<VecDesc>(new VecDesc());
    this.ScalarDescs = new std.vector<VecDesc>(new VecDesc());
    //END JInit
    // Default to everything being available.
    memset(AvailableArray, (byte)-1, sizeof(AvailableArray));

    initialize(/*Deref*/this, T, new ArrayRef</*const*/char$ptr/*char P*/ >(StandardNames.$array()));
  }


  // Provide value semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 431,
   FQN="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl", NM="_ZN4llvm21TargetLibraryInfoImplC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplC1ERKS0_")
  //</editor-fold>
  public TargetLibraryInfoImpl(final /*const*/ TargetLibraryInfoImpl /*&*/ TLI) {
    // : CustomNames(TLI.CustomNames), VectorDescs(), ScalarDescs()
    //START JInit
    this.CustomNames = new DenseMapUIntType<std.string>(TLI.CustomNames);
    this.VectorDescs = new std.vector<VecDesc>(new VecDesc());
    this.ScalarDescs = new std.vector<VecDesc>(new VecDesc());
    //END JInit
    memcpy(AvailableArray, TLI.AvailableArray, sizeof(AvailableArray));
    VectorDescs.$assign(TLI.VectorDescs);
    ScalarDescs.$assign(TLI.ScalarDescs);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 438,
   FQN="llvm::TargetLibraryInfoImpl::TargetLibraryInfoImpl", NM="_ZN4llvm21TargetLibraryInfoImplC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplC1EOS0_")
  //</editor-fold>
  public TargetLibraryInfoImpl(JD$Move _dparam, final TargetLibraryInfoImpl /*&&*/TLI) {
    // : CustomNames(std::move(TLI.CustomNames)), VectorDescs(), ScalarDescs()
    //START JInit
    this.CustomNames = new DenseMapUIntType<std.string>(JD$Move.INSTANCE, std.move(TLI.CustomNames));
    this.VectorDescs = new std.vector<VecDesc>(new VecDesc());
    this.ScalarDescs = new std.vector<VecDesc>(new VecDesc());
    //END JInit
    std.move(std.begin(/*89,*/ TLI.AvailableArray), std.end(/*89,*/ TLI.AvailableArray),
        create_char$ptr(AvailableArray));
    VectorDescs.$assign(TLI.VectorDescs);
    ScalarDescs.$assign(TLI.ScalarDescs);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 446,
   FQN="llvm::TargetLibraryInfoImpl::operator=", NM="_ZN4llvm21TargetLibraryInfoImplaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplaSERKS0_")
  //</editor-fold>
  public TargetLibraryInfoImpl /*&*/ $assign(final /*const*/ TargetLibraryInfoImpl /*&*/ TLI) {
    CustomNames.$assign(TLI.CustomNames);
    memcpy(AvailableArray, TLI.AvailableArray, sizeof(AvailableArray));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 452,
   FQN="llvm::TargetLibraryInfoImpl::operator=", NM="_ZN4llvm21TargetLibraryInfoImplaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplaSEOS0_")
  //</editor-fold>
  public TargetLibraryInfoImpl /*&*/ $assignMove(final TargetLibraryInfoImpl /*&&*/TLI) {
    CustomNames.$assignMove(std.move(TLI.CustomNames));
    std.move(std.begin(/*89,*/ TLI.AvailableArray), std.end(/*89,*/ TLI.AvailableArray),
        create_char$ptr(AvailableArray));
    return /*Deref*/this;
  }


  /// Searches for a particular function name.
  ///
  /// If it is one of the known library functions, return true and set F to the
  /// corresponding value.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::getLibFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 470,
   FQN="llvm::TargetLibraryInfoImpl::getLibFunc", NM="_ZNK4llvm21TargetLibraryInfoImpl10getLibFuncENS_9StringRefERNS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl10getLibFuncENS_9StringRefERNS_7LibFunc4FuncE")
  //</editor-fold>
  public boolean getLibFunc(StringRef funcName,
            final type$ref<Func /*&*/> F) /*const*/ {
    /*const*/type$ptr<char$ptr>/*char P const P*/ Start = $tryClone(StandardNames.$add(0));
    /*const*/type$ptr<char$ptr>/*char P const P*/ End = $tryClone(StandardNames.$add(Func.NumLibFuncs.getValue()));

    funcName.$assignMove(sanitizeFunctionName(new StringRef(funcName)));
    if (funcName.empty()) {
      return false;
    }

    /*const*/type$ptr<char$ptr>/*char P const P*/ I = $tryClone(std.lower_bound(Start, End, funcName, /*[]*/ (/*const*/char$ptr/*char P*/ LHS, StringRef RHS) -> {
              return std.strncmp(LHS, RHS.data(), RHS.size()) < 0;
            }));
    if ($noteq_ptr(I, End) && $eq_StringRef(/*STRINGREF_STR*/I.$star(), /*NO_COPY*/funcName)) {
      F.$set(Func.valueOf((I.$sub(Start))));
      return true;
    }
    return false;
  }


  /// Searches for a particular function name, also checking that its type is
  /// valid for the library function matching that name.
  ///
  /// If it is one of the known library functions, return true and set F to the
  /// corresponding value.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::getLibFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 994,
   FQN="llvm::TargetLibraryInfoImpl::getLibFunc", NM="_ZNK4llvm21TargetLibraryInfoImpl10getLibFuncERKNS_8FunctionERNS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl10getLibFuncERKNS_8FunctionERNS_7LibFunc4FuncE")
  //</editor-fold>
  public boolean getLibFunc(final /*const*/ Function /*&*/ FDecl,
            final type$ref<Func /*&*/> F) /*const*/ {
    /*const*/ DataLayout /*P*/ DL = (FDecl.getParent$Const() != null) ? $AddrOf(FDecl.getParent$Const().getDataLayout()) : null;
    return getLibFunc(FDecl.getName(), F)
       && isValidProtoForLibFunc($Deref(FDecl.getFunctionType()), F.$deref(), DL);
  }


  /// Forces a function to be marked as unavailable.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::setUnavailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 115,
   FQN="llvm::TargetLibraryInfoImpl::setUnavailable", NM="_ZN4llvm21TargetLibraryInfoImpl14setUnavailableENS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl14setUnavailableENS_7LibFunc4FuncE")
  //</editor-fold>
  public void setUnavailable(Func F) {
    setState(F, AvailabilityState.Unavailable);
  }


  /// Forces a function to be marked as available.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::setAvailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 120,
   FQN="llvm::TargetLibraryInfoImpl::setAvailable", NM="_ZN4llvm21TargetLibraryInfoImpl12setAvailableENS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl12setAvailableENS_7LibFunc4FuncE")
  //</editor-fold>
  public void setAvailable(Func F) {
    setState(F, AvailabilityState.StandardName);
  }


  /// Forces a function to be marked as available and provide an alternate name
  /// that must be used.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::setAvailableWithName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 126,
   FQN="llvm::TargetLibraryInfoImpl::setAvailableWithName", NM="_ZN4llvm21TargetLibraryInfoImpl20setAvailableWithNameENS_7LibFunc4FuncENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl20setAvailableWithNameENS_7LibFunc4FuncENS_9StringRefE")
  //</editor-fold>
  public void setAvailableWithName(Func F, StringRef Name) {
    if ($noteq_StringRef(/*STRINGREF_STR*/StandardNames.$at(F.getValue()), /*NO_COPY*/Name)) {
      setState(F, AvailabilityState.CustomName);
      CustomNames.$at_T1$RR(/*KEEP_ENUM*/F.getValue()).$assignMove(Name.$string());
      assert (CustomNames.find(/*KEEP_ENUM*/F.getValue()).$noteq(/*NO_ITER_COPY*/CustomNames.end()));
    } else {
      setState(F, AvailabilityState.StandardName);
    }
  }


  /// Disables all builtins.
  ///
  /// This can be used for options like -fno-builtin.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::disableAllFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1002,
   FQN="llvm::TargetLibraryInfoImpl::disableAllFunctions", NM="_ZN4llvm21TargetLibraryInfoImpl19disableAllFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl19disableAllFunctionsEv")
  //</editor-fold>
  public void disableAllFunctions() {
    memset(AvailableArray, (byte)0, sizeof(AvailableArray));
  }


  /// Add a set of scalar -> vector mappings, queryable via
  /// getVectorizedFunction and getScalarizedFunction.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::addVectorizableFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1024,
   FQN="llvm::TargetLibraryInfoImpl::addVectorizableFunctions", NM="_ZN4llvm21TargetLibraryInfoImpl24addVectorizableFunctionsENS_8ArrayRefINS_7VecDescEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl24addVectorizableFunctionsENS_8ArrayRefINS_7VecDescEEE")
  //</editor-fold>
  public void addVectorizableFunctions(ArrayRef<VecDesc> Fns) {
    VectorDescs.insert$T(new std.vector.iterator</*const*/ VecDesc /*P*/ >(VectorDescs.end()), Fns.begin(), Fns.end());
    std.sort(VectorDescs.begin(), VectorDescs.end(), /*FuncRef*/TargetLibraryInfoStatics::compareByScalarFnName);

    ScalarDescs.insert$T(new std.vector.iterator</*const*/ VecDesc /*P*/ >(ScalarDescs.end()), Fns.begin(), Fns.end());
    std.sort(ScalarDescs.begin(), ScalarDescs.end(), /*FuncRef*/TargetLibraryInfoStatics::compareByVectorFnName);
  }


  /// Calls addVectorizableFunctions with a known preset of functions for the
  /// given vector library.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::addVectorizableFunctionsFromVecLib">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1032,
   FQN="llvm::TargetLibraryInfoImpl::addVectorizableFunctionsFromVecLib", NM="_ZN4llvm21TargetLibraryInfoImpl34addVectorizableFunctionsFromVecLibENS0_13VectorLibraryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImpl34addVectorizableFunctionsFromVecLibENS0_13VectorLibraryE")
  //</editor-fold>
  public void addVectorizableFunctionsFromVecLib( VectorLibrary VecLib) {
    switch (VecLib) {
     case Accelerate:
      {
        /*const*/ VecDesc VecFuncs[/*29*/] = new /*const*/ VecDesc [/*29*/] {
          // Floating-Point Arithmetic and Auxiliary Functions
          new VecDesc($("ceilf"), $("vceilf"), 4),
          new VecDesc($("fabsf"), $("vfabsf"), 4),
          new VecDesc($("llvm.fabs.f32"), $("vfabsf"), 4),
          new VecDesc($("floorf"), $("vfloorf"), 4),
          new VecDesc($("sqrtf"), $("vsqrtf"), 4),
          new VecDesc($("llvm.sqrt.f32"), $("vsqrtf"), 4),

          // Exponential and Logarithmic Functions
          new VecDesc($("expf"), $("vexpf"), 4),
          new VecDesc($("llvm.exp.f32"), $("vexpf"), 4),
          new VecDesc($("expm1f"), $("vexpm1f"), 4),
          new VecDesc($("logf"), $("vlogf"), 4),
          new VecDesc($("llvm.log.f32"), $("vlogf"), 4),
          new VecDesc($("log1pf"), $("vlog1pf"), 4),
          new VecDesc($("log10f"), $("vlog10f"), 4),
          new VecDesc($("llvm.log10.f32"), $("vlog10f"), 4),
          new VecDesc($("logbf"), $("vlogbf"), 4),

          // Trigonometric Functions
          new VecDesc($("sinf"), $("vsinf"), 4),
          new VecDesc($("llvm.sin.f32"), $("vsinf"), 4),
          new VecDesc($("cosf"), $("vcosf"), 4),
          new VecDesc($("llvm.cos.f32"), $("vcosf"), 4),
          new VecDesc($("tanf"), $("vtanf"), 4),
          new VecDesc($("asinf"), $("vasinf"), 4),
          new VecDesc($("acosf"), $("vacosf"), 4),
          new VecDesc($("atanf"), $("vatanf"), 4),

          // Hyperbolic Functions
          new VecDesc($("sinhf"), $("vsinhf"), 4),
          new VecDesc($("coshf"), $("vcoshf"), 4),
          new VecDesc($("tanhf"), $("vtanhf"), 4),
          new VecDesc($("asinhf"), $("vasinhf"), 4),
          new VecDesc($("acoshf"), $("vacoshf"), 4),
          new VecDesc($("atanhf"), $("vatanhf"), 4)
        };
        addVectorizableFunctions(new ArrayRef<VecDesc>(VecFuncs, false));
        break;
      }
     case NoLibrary:
      break;
    }
  }


  /// Return true if the function F has a vector equivalent with vectorization
  /// factor VF.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::isFunctionVectorizable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 151,
   FQN="llvm::TargetLibraryInfoImpl::isFunctionVectorizable", NM="_ZNK4llvm21TargetLibraryInfoImpl22isFunctionVectorizableENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl22isFunctionVectorizableENS_9StringRefEj")
  //</editor-fold>
  public boolean isFunctionVectorizable(StringRef F, /*uint*/int VF) /*const*/ {
    return !getVectorizedFunction(new StringRef(F), VF).empty();
  }


  /// Return true if the function F has a vector equivalent with any
  /// vectorization factor.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::isFunctionVectorizable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1082,
   FQN="llvm::TargetLibraryInfoImpl::isFunctionVectorizable", NM="_ZNK4llvm21TargetLibraryInfoImpl22isFunctionVectorizableENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl22isFunctionVectorizableENS_9StringRefE")
  //</editor-fold>
  public boolean isFunctionVectorizable(StringRef funcName) /*const*/ {
    funcName.$assignMove(sanitizeFunctionName(new StringRef(funcName)));
    if (funcName.empty()) {
      return false;
    }

    std.vector.iterator</*const*/ VecDesc /*P*/ > I = std.lower_bound(VectorDescs.begin$Const(), VectorDescs.end$Const(), funcName,
        /*FuncRef*/ComparatorLower(TargetLibraryInfoStatics::compareWithScalarFnName));
    return $noteq___normal_iterator$C(I, VectorDescs.end$Const()) && $eq_StringRef(/*STRINGREF_STR*/I.$arrow().ScalarFnName, /*NO_COPY*/funcName);
  }


  /// Return the name of the equivalent of F, vectorized with factor VF. If no
  /// such mapping exists, return the empty string.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::getVectorizedFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1093,
   FQN="llvm::TargetLibraryInfoImpl::getVectorizedFunction", NM="_ZNK4llvm21TargetLibraryInfoImpl21getVectorizedFunctionENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl21getVectorizedFunctionENS_9StringRefEj")
  //</editor-fold>
  public StringRef getVectorizedFunction(StringRef F,
                       /*uint*/int VF) /*const*/ {
    F.$assignMove(sanitizeFunctionName(new StringRef(F)));
    if (F.empty()) {
      return new StringRef(JD$Move.INSTANCE, F);
    }
    std.vector.iterator</*const*/ VecDesc /*P*/ > I = std.lower_bound(VectorDescs.begin$Const(), VectorDescs.end$Const(), F, /*FuncRef*/ComparatorLower(TargetLibraryInfoStatics::compareWithScalarFnName));
    while ($noteq___normal_iterator$C(I, VectorDescs.end$Const()) && $eq_StringRef(/*STRINGREF_STR*/I.$arrow().ScalarFnName, /*NO_COPY*/F)) {
      if (I.$arrow().VectorizationFactor == VF) {
        return new StringRef(I.$arrow().VectorFnName);
      }
      I.$preInc();
    }
    return new StringRef();
  }


  /// Return true if the function F has a scalar equivalent, and set VF to be
  /// the vectorization factor.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::isFunctionScalarizable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 165,
   FQN="llvm::TargetLibraryInfoImpl::isFunctionScalarizable", NM="_ZNK4llvm21TargetLibraryInfoImpl22isFunctionScalarizableENS_9StringRefERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl22isFunctionScalarizableENS_9StringRefERj")
  //</editor-fold>
  public boolean isFunctionScalarizable(StringRef F, final uint$ref/*uint &*/ VF) /*const*/ {
    return !getScalarizedFunction(new StringRef(F), VF).empty();
  }


  /// Return the name of the equivalent of F, scalarized. If no such mapping
  /// exists, return the empty string.
  ///
  /// Set VF to the vectorization factor.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::getScalarizedFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1108,
   FQN="llvm::TargetLibraryInfoImpl::getScalarizedFunction", NM="_ZNK4llvm21TargetLibraryInfoImpl21getScalarizedFunctionENS_9StringRefERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm21TargetLibraryInfoImpl21getScalarizedFunctionENS_9StringRefERj")
  //</editor-fold>
  public StringRef getScalarizedFunction(StringRef F,
                       final uint$ref/*uint &*/ VF) /*const*/ {
    F.$assignMove(sanitizeFunctionName(new StringRef(F)));
    if (F.empty()) {
      return new StringRef(JD$Move.INSTANCE, F);
    }

    std.vector.iterator</*const*/ VecDesc /*P*/ > I = std.lower_bound(ScalarDescs.begin$Const(), ScalarDescs.end$Const(), F, /*FuncRef*/ComparatorLower(TargetLibraryInfoStatics::compareWithVectorFnName));
    if ($eq___normal_iterator$C(I, VectorDescs.end$Const()) || $noteq_StringRef(/*STRINGREF_STR*/I.$arrow().VectorFnName, /*NO_COPY*/F)) {
      return new StringRef();
    }
    VF.$set(I.$arrow().VectorizationFactor);
    return new StringRef(I.$arrow().ScalarFnName);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfoImpl::~TargetLibraryInfoImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 48,
   FQN="llvm::TargetLibraryInfoImpl::~TargetLibraryInfoImpl", NM="_ZN4llvm21TargetLibraryInfoImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryInfoImplD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ScalarDescs.$destroy();
    VectorDescs.$destroy();
    CustomNames.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "AvailableArray=" + AvailableArray // NOI18N
              + ", CustomNames=" + CustomNames // NOI18N
              + ", VectorDescs=" + VectorDescs // NOI18N
              + ", ScalarDescs=" + ScalarDescs; // NOI18N
  }
}
