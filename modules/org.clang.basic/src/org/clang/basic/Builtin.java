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
package org.clang.basic;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.impl.BuiltinsStatics.BuiltinInfo$Clang$Builtins;
import org.clang.basic.target.*;
import org.clank.java.std;


//<editor-fold defaultstate="collapsed" desc="static type Builtin">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin2IDE;_ZN5clang7Builtin4InfoE;_ZN5clang7Builtin7ContextE; -static-type=Builtin -package=org.clang.basic")
//</editor-fold>
public final class Builtin {

//<editor-fold defaultstate="collapsed" desc="clang::Builtin::ID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*see valueOf*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 46,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 45,
 FQN="clang::Builtin::ID", NM="_ZN5clang7Builtin2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin2IDE")
//</editor-fold>
public enum ID implements Native.ComparableLower {
  NotBuiltin(0), // This is not a builtin function.
  
  // Standard libc/libm functions:
  BI__builtin_atan2(NotBuiltin.getValue() + 1),
  BI__builtin_atan2f(BI__builtin_atan2.getValue() + 1),
  BI__builtin_atan2l(BI__builtin_atan2f.getValue() + 1),
  BI__builtin_abs(BI__builtin_atan2l.getValue() + 1),
  BI__builtin_copysign(BI__builtin_abs.getValue() + 1),
  BI__builtin_copysignf(BI__builtin_copysign.getValue() + 1),
  BI__builtin_copysignl(BI__builtin_copysignf.getValue() + 1),
  BI__builtin_fabs(BI__builtin_copysignl.getValue() + 1),
  BI__builtin_fabsf(BI__builtin_fabs.getValue() + 1),
  BI__builtin_fabsl(BI__builtin_fabsf.getValue() + 1),
  BI__builtin_fmod(BI__builtin_fabsl.getValue() + 1),
  BI__builtin_fmodf(BI__builtin_fmod.getValue() + 1),
  BI__builtin_fmodl(BI__builtin_fmodf.getValue() + 1),
  BI__builtin_frexp(BI__builtin_fmodl.getValue() + 1),
  BI__builtin_frexpf(BI__builtin_frexp.getValue() + 1),
  BI__builtin_frexpl(BI__builtin_frexpf.getValue() + 1),
  BI__builtin_huge_val(BI__builtin_frexpl.getValue() + 1),
  BI__builtin_huge_valf(BI__builtin_huge_val.getValue() + 1),
  BI__builtin_huge_vall(BI__builtin_huge_valf.getValue() + 1),
  BI__builtin_inf(BI__builtin_huge_vall.getValue() + 1),
  BI__builtin_inff(BI__builtin_inf.getValue() + 1),
  BI__builtin_infl(BI__builtin_inff.getValue() + 1),
  BI__builtin_labs(BI__builtin_infl.getValue() + 1),
  BI__builtin_llabs(BI__builtin_labs.getValue() + 1),
  BI__builtin_ldexp(BI__builtin_llabs.getValue() + 1),
  BI__builtin_ldexpf(BI__builtin_ldexp.getValue() + 1),
  BI__builtin_ldexpl(BI__builtin_ldexpf.getValue() + 1),
  BI__builtin_modf(BI__builtin_ldexpl.getValue() + 1),
  BI__builtin_modff(BI__builtin_modf.getValue() + 1),
  BI__builtin_modfl(BI__builtin_modff.getValue() + 1),
  BI__builtin_nan(BI__builtin_modfl.getValue() + 1),
  BI__builtin_nanf(BI__builtin_nan.getValue() + 1),
  BI__builtin_nanl(BI__builtin_nanf.getValue() + 1),
  BI__builtin_nans(BI__builtin_nanl.getValue() + 1),
  BI__builtin_nansf(BI__builtin_nans.getValue() + 1),
  BI__builtin_nansl(BI__builtin_nansf.getValue() + 1),
  BI__builtin_powi(BI__builtin_nansl.getValue() + 1),
  BI__builtin_powif(BI__builtin_powi.getValue() + 1),
  BI__builtin_powil(BI__builtin_powif.getValue() + 1),
  BI__builtin_pow(BI__builtin_powil.getValue() + 1),
  BI__builtin_powf(BI__builtin_pow.getValue() + 1),
  BI__builtin_powl(BI__builtin_powf.getValue() + 1),
  
  // Standard unary libc/libm functions with double/float/long double variants:
  BI__builtin_acos(BI__builtin_powl.getValue() + 1),
  BI__builtin_acosf(BI__builtin_acos.getValue() + 1),
  BI__builtin_acosl(BI__builtin_acosf.getValue() + 1),
  BI__builtin_acosh(BI__builtin_acosl.getValue() + 1),
  BI__builtin_acoshf(BI__builtin_acosh.getValue() + 1),
  BI__builtin_acoshl(BI__builtin_acoshf.getValue() + 1),
  BI__builtin_asin(BI__builtin_acoshl.getValue() + 1),
  BI__builtin_asinf(BI__builtin_asin.getValue() + 1),
  BI__builtin_asinl(BI__builtin_asinf.getValue() + 1),
  BI__builtin_asinh(BI__builtin_asinl.getValue() + 1),
  BI__builtin_asinhf(BI__builtin_asinh.getValue() + 1),
  BI__builtin_asinhl(BI__builtin_asinhf.getValue() + 1),
  BI__builtin_atan(BI__builtin_asinhl.getValue() + 1),
  BI__builtin_atanf(BI__builtin_atan.getValue() + 1),
  BI__builtin_atanl(BI__builtin_atanf.getValue() + 1),
  BI__builtin_atanh(BI__builtin_atanl.getValue() + 1),
  BI__builtin_atanhf(BI__builtin_atanh.getValue() + 1),
  BI__builtin_atanhl(BI__builtin_atanhf.getValue() + 1),
  BI__builtin_cbrt(BI__builtin_atanhl.getValue() + 1),
  BI__builtin_cbrtf(BI__builtin_cbrt.getValue() + 1),
  BI__builtin_cbrtl(BI__builtin_cbrtf.getValue() + 1),
  BI__builtin_ceil(BI__builtin_cbrtl.getValue() + 1),
  BI__builtin_ceilf(BI__builtin_ceil.getValue() + 1),
  BI__builtin_ceill(BI__builtin_ceilf.getValue() + 1),
  BI__builtin_cos(BI__builtin_ceill.getValue() + 1),
  BI__builtin_cosf(BI__builtin_cos.getValue() + 1),
  BI__builtin_cosh(BI__builtin_cosf.getValue() + 1),
  BI__builtin_coshf(BI__builtin_cosh.getValue() + 1),
  BI__builtin_coshl(BI__builtin_coshf.getValue() + 1),
  BI__builtin_cosl(BI__builtin_coshl.getValue() + 1),
  BI__builtin_erf(BI__builtin_cosl.getValue() + 1),
  BI__builtin_erff(BI__builtin_erf.getValue() + 1),
  BI__builtin_erfl(BI__builtin_erff.getValue() + 1),
  BI__builtin_erfc(BI__builtin_erfl.getValue() + 1),
  BI__builtin_erfcf(BI__builtin_erfc.getValue() + 1),
  BI__builtin_erfcl(BI__builtin_erfcf.getValue() + 1),
  BI__builtin_exp(BI__builtin_erfcl.getValue() + 1),
  BI__builtin_expf(BI__builtin_exp.getValue() + 1),
  BI__builtin_expl(BI__builtin_expf.getValue() + 1),
  BI__builtin_exp2(BI__builtin_expl.getValue() + 1),
  BI__builtin_exp2f(BI__builtin_exp2.getValue() + 1),
  BI__builtin_exp2l(BI__builtin_exp2f.getValue() + 1),
  BI__builtin_expm1(BI__builtin_exp2l.getValue() + 1),
  BI__builtin_expm1f(BI__builtin_expm1.getValue() + 1),
  BI__builtin_expm1l(BI__builtin_expm1f.getValue() + 1),
  BI__builtin_fdim(BI__builtin_expm1l.getValue() + 1),
  BI__builtin_fdimf(BI__builtin_fdim.getValue() + 1),
  BI__builtin_fdiml(BI__builtin_fdimf.getValue() + 1),
  BI__builtin_floor(BI__builtin_fdiml.getValue() + 1),
  BI__builtin_floorf(BI__builtin_floor.getValue() + 1),
  BI__builtin_floorl(BI__builtin_floorf.getValue() + 1),
  BI__builtin_fma(BI__builtin_floorl.getValue() + 1),
  BI__builtin_fmaf(BI__builtin_fma.getValue() + 1),
  BI__builtin_fmal(BI__builtin_fmaf.getValue() + 1),
  BI__builtin_fmax(BI__builtin_fmal.getValue() + 1),
  BI__builtin_fmaxf(BI__builtin_fmax.getValue() + 1),
  BI__builtin_fmaxl(BI__builtin_fmaxf.getValue() + 1),
  BI__builtin_fmin(BI__builtin_fmaxl.getValue() + 1),
  BI__builtin_fminf(BI__builtin_fmin.getValue() + 1),
  BI__builtin_fminl(BI__builtin_fminf.getValue() + 1),
  BI__builtin_hypot(BI__builtin_fminl.getValue() + 1),
  BI__builtin_hypotf(BI__builtin_hypot.getValue() + 1),
  BI__builtin_hypotl(BI__builtin_hypotf.getValue() + 1),
  BI__builtin_ilogb(BI__builtin_hypotl.getValue() + 1),
  BI__builtin_ilogbf(BI__builtin_ilogb.getValue() + 1),
  BI__builtin_ilogbl(BI__builtin_ilogbf.getValue() + 1),
  BI__builtin_lgamma(BI__builtin_ilogbl.getValue() + 1),
  BI__builtin_lgammaf(BI__builtin_lgamma.getValue() + 1),
  BI__builtin_lgammal(BI__builtin_lgammaf.getValue() + 1),
  BI__builtin_llrint(BI__builtin_lgammal.getValue() + 1),
  BI__builtin_llrintf(BI__builtin_llrint.getValue() + 1),
  BI__builtin_llrintl(BI__builtin_llrintf.getValue() + 1),
  BI__builtin_llround(BI__builtin_llrintl.getValue() + 1),
  BI__builtin_llroundf(BI__builtin_llround.getValue() + 1),
  BI__builtin_llroundl(BI__builtin_llroundf.getValue() + 1),
  BI__builtin_log(BI__builtin_llroundl.getValue() + 1),
  BI__builtin_log10(BI__builtin_log.getValue() + 1),
  BI__builtin_log10f(BI__builtin_log10.getValue() + 1),
  BI__builtin_log10l(BI__builtin_log10f.getValue() + 1),
  BI__builtin_log1p(BI__builtin_log10l.getValue() + 1),
  BI__builtin_log1pf(BI__builtin_log1p.getValue() + 1),
  BI__builtin_log1pl(BI__builtin_log1pf.getValue() + 1),
  BI__builtin_log2(BI__builtin_log1pl.getValue() + 1),
  BI__builtin_log2f(BI__builtin_log2.getValue() + 1),
  BI__builtin_log2l(BI__builtin_log2f.getValue() + 1),
  BI__builtin_logb(BI__builtin_log2l.getValue() + 1),
  BI__builtin_logbf(BI__builtin_logb.getValue() + 1),
  BI__builtin_logbl(BI__builtin_logbf.getValue() + 1),
  BI__builtin_logf(BI__builtin_logbl.getValue() + 1),
  BI__builtin_logl(BI__builtin_logf.getValue() + 1),
  BI__builtin_lrint(BI__builtin_logl.getValue() + 1),
  BI__builtin_lrintf(BI__builtin_lrint.getValue() + 1),
  BI__builtin_lrintl(BI__builtin_lrintf.getValue() + 1),
  BI__builtin_lround(BI__builtin_lrintl.getValue() + 1),
  BI__builtin_lroundf(BI__builtin_lround.getValue() + 1),
  BI__builtin_lroundl(BI__builtin_lroundf.getValue() + 1),
  BI__builtin_nearbyint(BI__builtin_lroundl.getValue() + 1),
  BI__builtin_nearbyintf(BI__builtin_nearbyint.getValue() + 1),
  BI__builtin_nearbyintl(BI__builtin_nearbyintf.getValue() + 1),
  BI__builtin_nextafter(BI__builtin_nearbyintl.getValue() + 1),
  BI__builtin_nextafterf(BI__builtin_nextafter.getValue() + 1),
  BI__builtin_nextafterl(BI__builtin_nextafterf.getValue() + 1),
  BI__builtin_nexttoward(BI__builtin_nextafterl.getValue() + 1),
  BI__builtin_nexttowardf(BI__builtin_nexttoward.getValue() + 1),
  BI__builtin_nexttowardl(BI__builtin_nexttowardf.getValue() + 1),
  BI__builtin_remainder(BI__builtin_nexttowardl.getValue() + 1),
  BI__builtin_remainderf(BI__builtin_remainder.getValue() + 1),
  BI__builtin_remainderl(BI__builtin_remainderf.getValue() + 1),
  BI__builtin_remquo(BI__builtin_remainderl.getValue() + 1),
  BI__builtin_remquof(BI__builtin_remquo.getValue() + 1),
  BI__builtin_remquol(BI__builtin_remquof.getValue() + 1),
  BI__builtin_rint(BI__builtin_remquol.getValue() + 1),
  BI__builtin_rintf(BI__builtin_rint.getValue() + 1),
  BI__builtin_rintl(BI__builtin_rintf.getValue() + 1),
  BI__builtin_round(BI__builtin_rintl.getValue() + 1),
  BI__builtin_roundf(BI__builtin_round.getValue() + 1),
  BI__builtin_roundl(BI__builtin_roundf.getValue() + 1),
  BI__builtin_scalbln(BI__builtin_roundl.getValue() + 1),
  BI__builtin_scalblnf(BI__builtin_scalbln.getValue() + 1),
  BI__builtin_scalblnl(BI__builtin_scalblnf.getValue() + 1),
  BI__builtin_scalbn(BI__builtin_scalblnl.getValue() + 1),
  BI__builtin_scalbnf(BI__builtin_scalbn.getValue() + 1),
  BI__builtin_scalbnl(BI__builtin_scalbnf.getValue() + 1),
  BI__builtin_sin(BI__builtin_scalbnl.getValue() + 1),
  BI__builtin_sinf(BI__builtin_sin.getValue() + 1),
  BI__builtin_sinh(BI__builtin_sinf.getValue() + 1),
  BI__builtin_sinhf(BI__builtin_sinh.getValue() + 1),
  BI__builtin_sinhl(BI__builtin_sinhf.getValue() + 1),
  BI__builtin_sinl(BI__builtin_sinhl.getValue() + 1),
  BI__builtin_sqrt(BI__builtin_sinl.getValue() + 1),
  BI__builtin_sqrtf(BI__builtin_sqrt.getValue() + 1),
  BI__builtin_sqrtl(BI__builtin_sqrtf.getValue() + 1),
  BI__builtin_tan(BI__builtin_sqrtl.getValue() + 1),
  BI__builtin_tanf(BI__builtin_tan.getValue() + 1),
  BI__builtin_tanh(BI__builtin_tanf.getValue() + 1),
  BI__builtin_tanhf(BI__builtin_tanh.getValue() + 1),
  BI__builtin_tanhl(BI__builtin_tanhf.getValue() + 1),
  BI__builtin_tanl(BI__builtin_tanhl.getValue() + 1),
  BI__builtin_tgamma(BI__builtin_tanl.getValue() + 1),
  BI__builtin_tgammaf(BI__builtin_tgamma.getValue() + 1),
  BI__builtin_tgammal(BI__builtin_tgammaf.getValue() + 1),
  BI__builtin_trunc(BI__builtin_tgammal.getValue() + 1),
  BI__builtin_truncf(BI__builtin_trunc.getValue() + 1),
  BI__builtin_truncl(BI__builtin_truncf.getValue() + 1),
  
  // C99 complex builtins
  BI__builtin_cabs(BI__builtin_truncl.getValue() + 1),
  BI__builtin_cabsf(BI__builtin_cabs.getValue() + 1),
  BI__builtin_cabsl(BI__builtin_cabsf.getValue() + 1),
  BI__builtin_cacos(BI__builtin_cabsl.getValue() + 1),
  BI__builtin_cacosf(BI__builtin_cacos.getValue() + 1),
  BI__builtin_cacosh(BI__builtin_cacosf.getValue() + 1),
  BI__builtin_cacoshf(BI__builtin_cacosh.getValue() + 1),
  BI__builtin_cacoshl(BI__builtin_cacoshf.getValue() + 1),
  BI__builtin_cacosl(BI__builtin_cacoshl.getValue() + 1),
  BI__builtin_carg(BI__builtin_cacosl.getValue() + 1),
  BI__builtin_cargf(BI__builtin_carg.getValue() + 1),
  BI__builtin_cargl(BI__builtin_cargf.getValue() + 1),
  BI__builtin_casin(BI__builtin_cargl.getValue() + 1),
  BI__builtin_casinf(BI__builtin_casin.getValue() + 1),
  BI__builtin_casinh(BI__builtin_casinf.getValue() + 1),
  BI__builtin_casinhf(BI__builtin_casinh.getValue() + 1),
  BI__builtin_casinhl(BI__builtin_casinhf.getValue() + 1),
  BI__builtin_casinl(BI__builtin_casinhl.getValue() + 1),
  BI__builtin_catan(BI__builtin_casinl.getValue() + 1),
  BI__builtin_catanf(BI__builtin_catan.getValue() + 1),
  BI__builtin_catanh(BI__builtin_catanf.getValue() + 1),
  BI__builtin_catanhf(BI__builtin_catanh.getValue() + 1),
  BI__builtin_catanhl(BI__builtin_catanhf.getValue() + 1),
  BI__builtin_catanl(BI__builtin_catanhl.getValue() + 1),
  BI__builtin_ccos(BI__builtin_catanl.getValue() + 1),
  BI__builtin_ccosf(BI__builtin_ccos.getValue() + 1),
  BI__builtin_ccosl(BI__builtin_ccosf.getValue() + 1),
  BI__builtin_ccosh(BI__builtin_ccosl.getValue() + 1),
  BI__builtin_ccoshf(BI__builtin_ccosh.getValue() + 1),
  BI__builtin_ccoshl(BI__builtin_ccoshf.getValue() + 1),
  BI__builtin_cexp(BI__builtin_ccoshl.getValue() + 1),
  BI__builtin_cexpf(BI__builtin_cexp.getValue() + 1),
  BI__builtin_cexpl(BI__builtin_cexpf.getValue() + 1),
  BI__builtin_cimag(BI__builtin_cexpl.getValue() + 1),
  BI__builtin_cimagf(BI__builtin_cimag.getValue() + 1),
  BI__builtin_cimagl(BI__builtin_cimagf.getValue() + 1),
  BI__builtin_conj(BI__builtin_cimagl.getValue() + 1),
  BI__builtin_conjf(BI__builtin_conj.getValue() + 1),
  BI__builtin_conjl(BI__builtin_conjf.getValue() + 1),
  BI__builtin_clog(BI__builtin_conjl.getValue() + 1),
  BI__builtin_clogf(BI__builtin_clog.getValue() + 1),
  BI__builtin_clogl(BI__builtin_clogf.getValue() + 1),
  BI__builtin_cproj(BI__builtin_clogl.getValue() + 1),
  BI__builtin_cprojf(BI__builtin_cproj.getValue() + 1),
  BI__builtin_cprojl(BI__builtin_cprojf.getValue() + 1),
  BI__builtin_cpow(BI__builtin_cprojl.getValue() + 1),
  BI__builtin_cpowf(BI__builtin_cpow.getValue() + 1),
  BI__builtin_cpowl(BI__builtin_cpowf.getValue() + 1),
  BI__builtin_creal(BI__builtin_cpowl.getValue() + 1),
  BI__builtin_crealf(BI__builtin_creal.getValue() + 1),
  BI__builtin_creall(BI__builtin_crealf.getValue() + 1),
  BI__builtin_csin(BI__builtin_creall.getValue() + 1),
  BI__builtin_csinf(BI__builtin_csin.getValue() + 1),
  BI__builtin_csinl(BI__builtin_csinf.getValue() + 1),
  BI__builtin_csinh(BI__builtin_csinl.getValue() + 1),
  BI__builtin_csinhf(BI__builtin_csinh.getValue() + 1),
  BI__builtin_csinhl(BI__builtin_csinhf.getValue() + 1),
  BI__builtin_csqrt(BI__builtin_csinhl.getValue() + 1),
  BI__builtin_csqrtf(BI__builtin_csqrt.getValue() + 1),
  BI__builtin_csqrtl(BI__builtin_csqrtf.getValue() + 1),
  BI__builtin_ctan(BI__builtin_csqrtl.getValue() + 1),
  BI__builtin_ctanf(BI__builtin_ctan.getValue() + 1),
  BI__builtin_ctanl(BI__builtin_ctanf.getValue() + 1),
  BI__builtin_ctanh(BI__builtin_ctanl.getValue() + 1),
  BI__builtin_ctanhf(BI__builtin_ctanh.getValue() + 1),
  BI__builtin_ctanhl(BI__builtin_ctanhf.getValue() + 1),
  
  // FP Comparisons.
  BI__builtin_isgreater(BI__builtin_ctanhl.getValue() + 1),
  BI__builtin_isgreaterequal(BI__builtin_isgreater.getValue() + 1),
  BI__builtin_isless(BI__builtin_isgreaterequal.getValue() + 1),
  BI__builtin_islessequal(BI__builtin_isless.getValue() + 1),
  BI__builtin_islessgreater(BI__builtin_islessequal.getValue() + 1),
  BI__builtin_isunordered(BI__builtin_islessgreater.getValue() + 1),
  
  // Unary FP classification
  BI__builtin_fpclassify(BI__builtin_isunordered.getValue() + 1),
  BI__builtin_isfinite(BI__builtin_fpclassify.getValue() + 1),
  BI__builtin_isinf(BI__builtin_isfinite.getValue() + 1),
  BI__builtin_isinf_sign(BI__builtin_isinf.getValue() + 1),
  BI__builtin_isnan(BI__builtin_isinf_sign.getValue() + 1),
  BI__builtin_isnormal(BI__builtin_isnan.getValue() + 1),
  
  // FP signbit builtins
  BI__builtin_signbit(BI__builtin_isnormal.getValue() + 1),
  BI__builtin_signbitf(BI__builtin_signbit.getValue() + 1),
  BI__builtin_signbitl(BI__builtin_signbitf.getValue() + 1),
  
  // Special FP builtins.
  BI__builtin_canonicalize(BI__builtin_signbitl.getValue() + 1),
  BI__builtin_canonicalizef(BI__builtin_canonicalize.getValue() + 1),
  BI__builtin_canonicalizel(BI__builtin_canonicalizef.getValue() + 1),
  
  // Builtins for arithmetic.
  BI__builtin_clzs(BI__builtin_canonicalizel.getValue() + 1),
  BI__builtin_clz(BI__builtin_clzs.getValue() + 1),
  BI__builtin_clzl(BI__builtin_clz.getValue() + 1),
  BI__builtin_clzll(BI__builtin_clzl.getValue() + 1),
  // TODO: int clzimax(uintmax_t)
  BI__builtin_ctzs(BI__builtin_clzll.getValue() + 1),
  BI__builtin_ctz(BI__builtin_ctzs.getValue() + 1),
  BI__builtin_ctzl(BI__builtin_ctz.getValue() + 1),
  BI__builtin_ctzll(BI__builtin_ctzl.getValue() + 1),
  // TODO: int ctzimax(uintmax_t)
  BI__builtin_ffs(BI__builtin_ctzll.getValue() + 1),
  BI__builtin_ffsl(BI__builtin_ffs.getValue() + 1),
  BI__builtin_ffsll(BI__builtin_ffsl.getValue() + 1),
  BI__builtin_parity(BI__builtin_ffsll.getValue() + 1),
  BI__builtin_parityl(BI__builtin_parity.getValue() + 1),
  BI__builtin_parityll(BI__builtin_parityl.getValue() + 1),
  BI__builtin_popcount(BI__builtin_parityll.getValue() + 1),
  BI__builtin_popcountl(BI__builtin_popcount.getValue() + 1),
  BI__builtin_popcountll(BI__builtin_popcountl.getValue() + 1),
  
  // FIXME: These type signatures are not correct for targets with int != 32-bits
  // or with ULL != 64-bits.
  BI__builtin_bswap16(BI__builtin_popcountll.getValue() + 1),
  BI__builtin_bswap32(BI__builtin_bswap16.getValue() + 1),
  BI__builtin_bswap64(BI__builtin_bswap32.getValue() + 1),
  BI__builtin_bitreverse8(BI__builtin_bswap64.getValue() + 1),
  BI__builtin_bitreverse16(BI__builtin_bitreverse8.getValue() + 1),
  BI__builtin_bitreverse32(BI__builtin_bitreverse16.getValue() + 1),
  BI__builtin_bitreverse64(BI__builtin_bitreverse32.getValue() + 1),
  
  // Random GCC builtins
  BI__builtin_constant_p(BI__builtin_bitreverse64.getValue() + 1),
  BI__builtin_classify_type(BI__builtin_constant_p.getValue() + 1),
  BI__builtin___CFStringMakeConstantString(BI__builtin_classify_type.getValue() + 1),
  BI__builtin___NSStringMakeConstantString(BI__builtin___CFStringMakeConstantString.getValue() + 1),
  BI__builtin_va_start(BI__builtin___NSStringMakeConstantString.getValue() + 1),
  BI__builtin_va_end(BI__builtin_va_start.getValue() + 1),
  BI__builtin_va_copy(BI__builtin_va_end.getValue() + 1),
  BI__builtin_stdarg_start(BI__builtin_va_copy.getValue() + 1),
  BI__builtin_assume_aligned(BI__builtin_stdarg_start.getValue() + 1),
  BI__builtin_bcmp(BI__builtin_assume_aligned.getValue() + 1),
  BI__builtin_bcopy(BI__builtin_bcmp.getValue() + 1),
  BI__builtin_bzero(BI__builtin_bcopy.getValue() + 1),
  BI__builtin_fprintf(BI__builtin_bzero.getValue() + 1),
  BI__builtin_memchr(BI__builtin_fprintf.getValue() + 1),
  BI__builtin_memcmp(BI__builtin_memchr.getValue() + 1),
  BI__builtin_memcpy(BI__builtin_memcmp.getValue() + 1),
  BI__builtin_memmove(BI__builtin_memcpy.getValue() + 1),
  BI__builtin_mempcpy(BI__builtin_memmove.getValue() + 1),
  BI__builtin_memset(BI__builtin_mempcpy.getValue() + 1),
  BI__builtin_printf(BI__builtin_memset.getValue() + 1),
  BI__builtin_stpcpy(BI__builtin_printf.getValue() + 1),
  BI__builtin_stpncpy(BI__builtin_stpcpy.getValue() + 1),
  BI__builtin_strcasecmp(BI__builtin_stpncpy.getValue() + 1),
  BI__builtin_strcat(BI__builtin_strcasecmp.getValue() + 1),
  BI__builtin_strchr(BI__builtin_strcat.getValue() + 1),
  BI__builtin_strcmp(BI__builtin_strchr.getValue() + 1),
  BI__builtin_strcpy(BI__builtin_strcmp.getValue() + 1),
  BI__builtin_strcspn(BI__builtin_strcpy.getValue() + 1),
  BI__builtin_strdup(BI__builtin_strcspn.getValue() + 1),
  BI__builtin_strlen(BI__builtin_strdup.getValue() + 1),
  BI__builtin_strncasecmp(BI__builtin_strlen.getValue() + 1),
  BI__builtin_strncat(BI__builtin_strncasecmp.getValue() + 1),
  BI__builtin_strncmp(BI__builtin_strncat.getValue() + 1),
  BI__builtin_strncpy(BI__builtin_strncmp.getValue() + 1),
  BI__builtin_strndup(BI__builtin_strncpy.getValue() + 1),
  BI__builtin_strpbrk(BI__builtin_strndup.getValue() + 1),
  BI__builtin_strrchr(BI__builtin_strpbrk.getValue() + 1),
  BI__builtin_strspn(BI__builtin_strrchr.getValue() + 1),
  BI__builtin_strstr(BI__builtin_strspn.getValue() + 1),
  BI__builtin_return_address(BI__builtin_strstr.getValue() + 1),
  BI__builtin_extract_return_addr(BI__builtin_return_address.getValue() + 1),
  BI__builtin_frame_address(BI__builtin_extract_return_addr.getValue() + 1),
  BI__builtin___clear_cache(BI__builtin_frame_address.getValue() + 1),
  BI__builtin_flt_rounds(BI__builtin___clear_cache.getValue() + 1),
  BI__builtin_setjmp(BI__builtin_flt_rounds.getValue() + 1),
  BI__builtin_longjmp(BI__builtin_setjmp.getValue() + 1),
  BI__builtin_unwind_init(BI__builtin_longjmp.getValue() + 1),
  BI__builtin_eh_return_data_regno(BI__builtin_unwind_init.getValue() + 1),
  BI__builtin_snprintf(BI__builtin_eh_return_data_regno.getValue() + 1),
  BI__builtin_vsprintf(BI__builtin_snprintf.getValue() + 1),
  BI__builtin_vsnprintf(BI__builtin_vsprintf.getValue() + 1),
  BI__builtin_thread_pointer(BI__builtin_vsnprintf.getValue() + 1),
  
  // GCC exception builtins
  BI__builtin_eh_return(BI__builtin_thread_pointer.getValue() + 1),
  // FIXME: Takes intptr_t, not size_t!
  BI__builtin_frob_return_addr(BI__builtin_eh_return.getValue() + 1),
  BI__builtin_dwarf_cfa(BI__builtin_frob_return_addr.getValue() + 1),
  BI__builtin_init_dwarf_reg_size_table(BI__builtin_dwarf_cfa.getValue() + 1),
  BI__builtin_dwarf_sp_column(BI__builtin_init_dwarf_reg_size_table.getValue() + 1),
  BI__builtin_extend_pointer(BI__builtin_dwarf_sp_column.getValue() + 1),
  // _Unwind_Word == uint64_t
  
  // GCC Object size checking builtins
  BI__builtin_object_size(BI__builtin_extend_pointer.getValue() + 1),
  BI__builtin___memcpy_chk(BI__builtin_object_size.getValue() + 1),
  BI__builtin___memccpy_chk(BI__builtin___memcpy_chk.getValue() + 1),
  BI__builtin___memmove_chk(BI__builtin___memccpy_chk.getValue() + 1),
  BI__builtin___mempcpy_chk(BI__builtin___memmove_chk.getValue() + 1),
  BI__builtin___memset_chk(BI__builtin___mempcpy_chk.getValue() + 1),
  BI__builtin___stpcpy_chk(BI__builtin___memset_chk.getValue() + 1),
  BI__builtin___strcat_chk(BI__builtin___stpcpy_chk.getValue() + 1),
  BI__builtin___strcpy_chk(BI__builtin___strcat_chk.getValue() + 1),
  BI__builtin___strlcat_chk(BI__builtin___strcpy_chk.getValue() + 1),
  BI__builtin___strlcpy_chk(BI__builtin___strlcat_chk.getValue() + 1),
  BI__builtin___strncat_chk(BI__builtin___strlcpy_chk.getValue() + 1),
  BI__builtin___strncpy_chk(BI__builtin___strncat_chk.getValue() + 1),
  BI__builtin___stpncpy_chk(BI__builtin___strncpy_chk.getValue() + 1),
  BI__builtin___snprintf_chk(BI__builtin___stpncpy_chk.getValue() + 1),
  BI__builtin___sprintf_chk(BI__builtin___snprintf_chk.getValue() + 1),
  BI__builtin___vsnprintf_chk(BI__builtin___sprintf_chk.getValue() + 1),
  BI__builtin___vsprintf_chk(BI__builtin___vsnprintf_chk.getValue() + 1),
  BI__builtin___fprintf_chk(BI__builtin___vsprintf_chk.getValue() + 1),
  BI__builtin___printf_chk(BI__builtin___fprintf_chk.getValue() + 1),
  BI__builtin___vfprintf_chk(BI__builtin___printf_chk.getValue() + 1),
  BI__builtin___vprintf_chk(BI__builtin___vfprintf_chk.getValue() + 1),
  BI__builtin_unpredictable(BI__builtin___vprintf_chk.getValue() + 1),
  BI__builtin_expect(BI__builtin_unpredictable.getValue() + 1),
  BI__builtin_prefetch(BI__builtin_expect.getValue() + 1),
  BI__builtin_readcyclecounter(BI__builtin_prefetch.getValue() + 1),
  BI__builtin_trap(BI__builtin_readcyclecounter.getValue() + 1),
  BI__builtin_debugtrap(BI__builtin_trap.getValue() + 1),
  BI__builtin_unreachable(BI__builtin_debugtrap.getValue() + 1),
  BI__builtin_shufflevector(BI__builtin_unreachable.getValue() + 1),
  BI__builtin_convertvector(BI__builtin_shufflevector.getValue() + 1),
  BI__builtin_alloca(BI__builtin_convertvector.getValue() + 1),
  BI__builtin_call_with_static_chain(BI__builtin_alloca.getValue() + 1),
  
  // "Overloaded" Atomic operator builtins.  These are overloaded to support data
  // types of i8, i16, i32, i64, and i128.  The front-end sees calls to the
  // non-suffixed version of these (which has a bogus type) and transforms them to
  // the right overloaded version in Sema (plus casts).
  
  // FIXME: These assume that char -> i8, short -> i16, int -> i32,
  // long long -> i64.
  BI__sync_fetch_and_add(BI__builtin_call_with_static_chain.getValue() + 1),
  BI__sync_fetch_and_add_1(BI__sync_fetch_and_add.getValue() + 1),
  BI__sync_fetch_and_add_2(BI__sync_fetch_and_add_1.getValue() + 1),
  BI__sync_fetch_and_add_4(BI__sync_fetch_and_add_2.getValue() + 1),
  BI__sync_fetch_and_add_8(BI__sync_fetch_and_add_4.getValue() + 1),
  BI__sync_fetch_and_add_16(BI__sync_fetch_and_add_8.getValue() + 1),
  BI__sync_fetch_and_sub(BI__sync_fetch_and_add_16.getValue() + 1),
  BI__sync_fetch_and_sub_1(BI__sync_fetch_and_sub.getValue() + 1),
  BI__sync_fetch_and_sub_2(BI__sync_fetch_and_sub_1.getValue() + 1),
  BI__sync_fetch_and_sub_4(BI__sync_fetch_and_sub_2.getValue() + 1),
  BI__sync_fetch_and_sub_8(BI__sync_fetch_and_sub_4.getValue() + 1),
  BI__sync_fetch_and_sub_16(BI__sync_fetch_and_sub_8.getValue() + 1),
  BI__sync_fetch_and_or(BI__sync_fetch_and_sub_16.getValue() + 1),
  BI__sync_fetch_and_or_1(BI__sync_fetch_and_or.getValue() + 1),
  BI__sync_fetch_and_or_2(BI__sync_fetch_and_or_1.getValue() + 1),
  BI__sync_fetch_and_or_4(BI__sync_fetch_and_or_2.getValue() + 1),
  BI__sync_fetch_and_or_8(BI__sync_fetch_and_or_4.getValue() + 1),
  BI__sync_fetch_and_or_16(BI__sync_fetch_and_or_8.getValue() + 1),
  BI__sync_fetch_and_and(BI__sync_fetch_and_or_16.getValue() + 1),
  BI__sync_fetch_and_and_1(BI__sync_fetch_and_and.getValue() + 1),
  BI__sync_fetch_and_and_2(BI__sync_fetch_and_and_1.getValue() + 1),
  BI__sync_fetch_and_and_4(BI__sync_fetch_and_and_2.getValue() + 1),
  BI__sync_fetch_and_and_8(BI__sync_fetch_and_and_4.getValue() + 1),
  BI__sync_fetch_and_and_16(BI__sync_fetch_and_and_8.getValue() + 1),
  BI__sync_fetch_and_xor(BI__sync_fetch_and_and_16.getValue() + 1),
  BI__sync_fetch_and_xor_1(BI__sync_fetch_and_xor.getValue() + 1),
  BI__sync_fetch_and_xor_2(BI__sync_fetch_and_xor_1.getValue() + 1),
  BI__sync_fetch_and_xor_4(BI__sync_fetch_and_xor_2.getValue() + 1),
  BI__sync_fetch_and_xor_8(BI__sync_fetch_and_xor_4.getValue() + 1),
  BI__sync_fetch_and_xor_16(BI__sync_fetch_and_xor_8.getValue() + 1),
  BI__sync_fetch_and_nand(BI__sync_fetch_and_xor_16.getValue() + 1),
  BI__sync_fetch_and_nand_1(BI__sync_fetch_and_nand.getValue() + 1),
  BI__sync_fetch_and_nand_2(BI__sync_fetch_and_nand_1.getValue() + 1),
  BI__sync_fetch_and_nand_4(BI__sync_fetch_and_nand_2.getValue() + 1),
  BI__sync_fetch_and_nand_8(BI__sync_fetch_and_nand_4.getValue() + 1),
  BI__sync_fetch_and_nand_16(BI__sync_fetch_and_nand_8.getValue() + 1),
  BI__sync_add_and_fetch(BI__sync_fetch_and_nand_16.getValue() + 1),
  BI__sync_add_and_fetch_1(BI__sync_add_and_fetch.getValue() + 1),
  BI__sync_add_and_fetch_2(BI__sync_add_and_fetch_1.getValue() + 1),
  BI__sync_add_and_fetch_4(BI__sync_add_and_fetch_2.getValue() + 1),
  BI__sync_add_and_fetch_8(BI__sync_add_and_fetch_4.getValue() + 1),
  BI__sync_add_and_fetch_16(BI__sync_add_and_fetch_8.getValue() + 1),
  BI__sync_sub_and_fetch(BI__sync_add_and_fetch_16.getValue() + 1),
  BI__sync_sub_and_fetch_1(BI__sync_sub_and_fetch.getValue() + 1),
  BI__sync_sub_and_fetch_2(BI__sync_sub_and_fetch_1.getValue() + 1),
  BI__sync_sub_and_fetch_4(BI__sync_sub_and_fetch_2.getValue() + 1),
  BI__sync_sub_and_fetch_8(BI__sync_sub_and_fetch_4.getValue() + 1),
  BI__sync_sub_and_fetch_16(BI__sync_sub_and_fetch_8.getValue() + 1),
  BI__sync_or_and_fetch(BI__sync_sub_and_fetch_16.getValue() + 1),
  BI__sync_or_and_fetch_1(BI__sync_or_and_fetch.getValue() + 1),
  BI__sync_or_and_fetch_2(BI__sync_or_and_fetch_1.getValue() + 1),
  BI__sync_or_and_fetch_4(BI__sync_or_and_fetch_2.getValue() + 1),
  BI__sync_or_and_fetch_8(BI__sync_or_and_fetch_4.getValue() + 1),
  BI__sync_or_and_fetch_16(BI__sync_or_and_fetch_8.getValue() + 1),
  BI__sync_and_and_fetch(BI__sync_or_and_fetch_16.getValue() + 1),
  BI__sync_and_and_fetch_1(BI__sync_and_and_fetch.getValue() + 1),
  BI__sync_and_and_fetch_2(BI__sync_and_and_fetch_1.getValue() + 1),
  BI__sync_and_and_fetch_4(BI__sync_and_and_fetch_2.getValue() + 1),
  BI__sync_and_and_fetch_8(BI__sync_and_and_fetch_4.getValue() + 1),
  BI__sync_and_and_fetch_16(BI__sync_and_and_fetch_8.getValue() + 1),
  BI__sync_xor_and_fetch(BI__sync_and_and_fetch_16.getValue() + 1),
  BI__sync_xor_and_fetch_1(BI__sync_xor_and_fetch.getValue() + 1),
  BI__sync_xor_and_fetch_2(BI__sync_xor_and_fetch_1.getValue() + 1),
  BI__sync_xor_and_fetch_4(BI__sync_xor_and_fetch_2.getValue() + 1),
  BI__sync_xor_and_fetch_8(BI__sync_xor_and_fetch_4.getValue() + 1),
  BI__sync_xor_and_fetch_16(BI__sync_xor_and_fetch_8.getValue() + 1),
  BI__sync_nand_and_fetch(BI__sync_xor_and_fetch_16.getValue() + 1),
  BI__sync_nand_and_fetch_1(BI__sync_nand_and_fetch.getValue() + 1),
  BI__sync_nand_and_fetch_2(BI__sync_nand_and_fetch_1.getValue() + 1),
  BI__sync_nand_and_fetch_4(BI__sync_nand_and_fetch_2.getValue() + 1),
  BI__sync_nand_and_fetch_8(BI__sync_nand_and_fetch_4.getValue() + 1),
  BI__sync_nand_and_fetch_16(BI__sync_nand_and_fetch_8.getValue() + 1),
  BI__sync_bool_compare_and_swap(BI__sync_nand_and_fetch_16.getValue() + 1),
  BI__sync_bool_compare_and_swap_1(BI__sync_bool_compare_and_swap.getValue() + 1),
  BI__sync_bool_compare_and_swap_2(BI__sync_bool_compare_and_swap_1.getValue() + 1),
  BI__sync_bool_compare_and_swap_4(BI__sync_bool_compare_and_swap_2.getValue() + 1),
  BI__sync_bool_compare_and_swap_8(BI__sync_bool_compare_and_swap_4.getValue() + 1),
  BI__sync_bool_compare_and_swap_16(BI__sync_bool_compare_and_swap_8.getValue() + 1),
  BI__sync_val_compare_and_swap(BI__sync_bool_compare_and_swap_16.getValue() + 1),
  BI__sync_val_compare_and_swap_1(BI__sync_val_compare_and_swap.getValue() + 1),
  BI__sync_val_compare_and_swap_2(BI__sync_val_compare_and_swap_1.getValue() + 1),
  BI__sync_val_compare_and_swap_4(BI__sync_val_compare_and_swap_2.getValue() + 1),
  BI__sync_val_compare_and_swap_8(BI__sync_val_compare_and_swap_4.getValue() + 1),
  BI__sync_val_compare_and_swap_16(BI__sync_val_compare_and_swap_8.getValue() + 1),
  BI__sync_lock_test_and_set(BI__sync_val_compare_and_swap_16.getValue() + 1),
  BI__sync_lock_test_and_set_1(BI__sync_lock_test_and_set.getValue() + 1),
  BI__sync_lock_test_and_set_2(BI__sync_lock_test_and_set_1.getValue() + 1),
  BI__sync_lock_test_and_set_4(BI__sync_lock_test_and_set_2.getValue() + 1),
  BI__sync_lock_test_and_set_8(BI__sync_lock_test_and_set_4.getValue() + 1),
  BI__sync_lock_test_and_set_16(BI__sync_lock_test_and_set_8.getValue() + 1),
  BI__sync_lock_release(BI__sync_lock_test_and_set_16.getValue() + 1),
  BI__sync_lock_release_1(BI__sync_lock_release.getValue() + 1),
  BI__sync_lock_release_2(BI__sync_lock_release_1.getValue() + 1),
  BI__sync_lock_release_4(BI__sync_lock_release_2.getValue() + 1),
  BI__sync_lock_release_8(BI__sync_lock_release_4.getValue() + 1),
  BI__sync_lock_release_16(BI__sync_lock_release_8.getValue() + 1),
  BI__sync_swap(BI__sync_lock_release_16.getValue() + 1),
  BI__sync_swap_1(BI__sync_swap.getValue() + 1),
  BI__sync_swap_2(BI__sync_swap_1.getValue() + 1),
  BI__sync_swap_4(BI__sync_swap_2.getValue() + 1),
  BI__sync_swap_8(BI__sync_swap_4.getValue() + 1),
  BI__sync_swap_16(BI__sync_swap_8.getValue() + 1),
  
  // C11 _Atomic operations for <stdatomic.h>.
  BI__c11_atomic_init(BI__sync_swap_16.getValue() + 1),
  BI__c11_atomic_load(BI__c11_atomic_init.getValue() + 1),
  BI__c11_atomic_store(BI__c11_atomic_load.getValue() + 1),
  BI__c11_atomic_exchange(BI__c11_atomic_store.getValue() + 1),
  BI__c11_atomic_compare_exchange_strong(BI__c11_atomic_exchange.getValue() + 1),
  BI__c11_atomic_compare_exchange_weak(BI__c11_atomic_compare_exchange_strong.getValue() + 1),
  BI__c11_atomic_fetch_add(BI__c11_atomic_compare_exchange_weak.getValue() + 1),
  BI__c11_atomic_fetch_sub(BI__c11_atomic_fetch_add.getValue() + 1),
  BI__c11_atomic_fetch_and(BI__c11_atomic_fetch_sub.getValue() + 1),
  BI__c11_atomic_fetch_or(BI__c11_atomic_fetch_and.getValue() + 1),
  BI__c11_atomic_fetch_xor(BI__c11_atomic_fetch_or.getValue() + 1),
  BI__c11_atomic_thread_fence(BI__c11_atomic_fetch_xor.getValue() + 1),
  BI__c11_atomic_signal_fence(BI__c11_atomic_thread_fence.getValue() + 1),
  BI__c11_atomic_is_lock_free(BI__c11_atomic_signal_fence.getValue() + 1),
  
  // GNU atomic builtins.
  BI__atomic_load(BI__c11_atomic_is_lock_free.getValue() + 1),
  BI__atomic_load_n(BI__atomic_load.getValue() + 1),
  BI__atomic_store(BI__atomic_load_n.getValue() + 1),
  BI__atomic_store_n(BI__atomic_store.getValue() + 1),
  BI__atomic_exchange(BI__atomic_store_n.getValue() + 1),
  BI__atomic_exchange_n(BI__atomic_exchange.getValue() + 1),
  BI__atomic_compare_exchange(BI__atomic_exchange_n.getValue() + 1),
  BI__atomic_compare_exchange_n(BI__atomic_compare_exchange.getValue() + 1),
  BI__atomic_fetch_add(BI__atomic_compare_exchange_n.getValue() + 1),
  BI__atomic_fetch_sub(BI__atomic_fetch_add.getValue() + 1),
  BI__atomic_fetch_and(BI__atomic_fetch_sub.getValue() + 1),
  BI__atomic_fetch_or(BI__atomic_fetch_and.getValue() + 1),
  BI__atomic_fetch_xor(BI__atomic_fetch_or.getValue() + 1),
  BI__atomic_fetch_nand(BI__atomic_fetch_xor.getValue() + 1),
  BI__atomic_add_fetch(BI__atomic_fetch_nand.getValue() + 1),
  BI__atomic_sub_fetch(BI__atomic_add_fetch.getValue() + 1),
  BI__atomic_and_fetch(BI__atomic_sub_fetch.getValue() + 1),
  BI__atomic_or_fetch(BI__atomic_and_fetch.getValue() + 1),
  BI__atomic_xor_fetch(BI__atomic_or_fetch.getValue() + 1),
  BI__atomic_nand_fetch(BI__atomic_xor_fetch.getValue() + 1),
  BI__atomic_test_and_set(BI__atomic_nand_fetch.getValue() + 1),
  BI__atomic_clear(BI__atomic_test_and_set.getValue() + 1),
  BI__atomic_thread_fence(BI__atomic_clear.getValue() + 1),
  BI__atomic_signal_fence(BI__atomic_thread_fence.getValue() + 1),
  BI__atomic_always_lock_free(BI__atomic_signal_fence.getValue() + 1),
  BI__atomic_is_lock_free(BI__atomic_always_lock_free.getValue() + 1),
  
  // Non-overloaded atomic builtins.
  BI__sync_synchronize(BI__atomic_is_lock_free.getValue() + 1),
  // GCC does not support these, they are a Clang extension.
  BI__sync_fetch_and_min(BI__sync_synchronize.getValue() + 1),
  BI__sync_fetch_and_max(BI__sync_fetch_and_min.getValue() + 1),
  BI__sync_fetch_and_umin(BI__sync_fetch_and_max.getValue() + 1),
  BI__sync_fetch_and_umax(BI__sync_fetch_and_umin.getValue() + 1),
  
  // Random libc builtins.
  BI__builtin_abort(BI__sync_fetch_and_umax.getValue() + 1),
  BI__builtin_index(BI__builtin_abort.getValue() + 1),
  BI__builtin_rindex(BI__builtin_index.getValue() + 1),
  
  // Microsoft builtins.  These are only active with -fms-extensions.
  BI_alloca(BI__builtin_rindex.getValue() + 1),
  BI__assume(BI_alloca.getValue() + 1),
  BI__debugbreak(BI__assume.getValue() + 1),
  BI__exception_code(BI__debugbreak.getValue() + 1),
  BI_exception_code(BI__exception_code.getValue() + 1),
  BI__exception_info(BI_exception_code.getValue() + 1),
  BI_exception_info(BI__exception_info.getValue() + 1),
  BI__abnormal_termination(BI_exception_info.getValue() + 1),
  BI_abnormal_termination(BI__abnormal_termination.getValue() + 1),
  BI__GetExceptionInfo(BI_abnormal_termination.getValue() + 1),
  BI_InterlockedCompareExchange(BI__GetExceptionInfo.getValue() + 1),
  BI_InterlockedCompareExchangePointer(BI_InterlockedCompareExchange.getValue() + 1),
  BI_InterlockedDecrement(BI_InterlockedCompareExchangePointer.getValue() + 1),
  BI_InterlockedExchangeAdd(BI_InterlockedDecrement.getValue() + 1),
  BI_InterlockedExchange(BI_InterlockedExchangeAdd.getValue() + 1),
  BI_InterlockedExchangePointer(BI_InterlockedExchange.getValue() + 1),
  BI_InterlockedIncrement(BI_InterlockedExchangePointer.getValue() + 1),
  BI__noop(BI_InterlockedIncrement.getValue() + 1),
  BI__readfsdword(BI__noop.getValue() + 1),
  BI__va_start(BI__readfsdword.getValue() + 1),
  
  // Microsoft library builtins.
  BI_setjmpex(BI__va_start.getValue() + 1),
  
  // C99 library functions
  // C99 stdlib.h
  BIabort(BI_setjmpex.getValue() + 1),
  BIcalloc(BIabort.getValue() + 1),
  BIexit(BIcalloc.getValue() + 1),
  BI_Exit(BIexit.getValue() + 1),
  BImalloc(BI_Exit.getValue() + 1),
  BIrealloc(BImalloc.getValue() + 1),
  // C99 string.h
  BImemcpy(BIrealloc.getValue() + 1),
  BImemcmp(BImemcpy.getValue() + 1),
  BImemmove(BImemcmp.getValue() + 1),
  BIstrcpy(BImemmove.getValue() + 1),
  BIstrncpy(BIstrcpy.getValue() + 1),
  BIstrcmp(BIstrncpy.getValue() + 1),
  BIstrncmp(BIstrcmp.getValue() + 1),
  BIstrcat(BIstrncmp.getValue() + 1),
  BIstrncat(BIstrcat.getValue() + 1),
  BIstrxfrm(BIstrncat.getValue() + 1),
  BImemchr(BIstrxfrm.getValue() + 1),
  BIstrchr(BImemchr.getValue() + 1),
  BIstrcspn(BIstrchr.getValue() + 1),
  BIstrpbrk(BIstrcspn.getValue() + 1),
  BIstrrchr(BIstrpbrk.getValue() + 1),
  BIstrspn(BIstrrchr.getValue() + 1),
  BIstrstr(BIstrspn.getValue() + 1),
  BIstrtok(BIstrstr.getValue() + 1),
  BImemset(BIstrtok.getValue() + 1),
  BIstrerror(BImemset.getValue() + 1),
  BIstrlen(BIstrerror.getValue() + 1),
  // C99 stdio.h
  BIprintf(BIstrlen.getValue() + 1),
  BIfprintf(BIprintf.getValue() + 1),
  BIsnprintf(BIfprintf.getValue() + 1),
  BIsprintf(BIsnprintf.getValue() + 1),
  BIvprintf(BIsprintf.getValue() + 1),
  BIvfprintf(BIvprintf.getValue() + 1),
  BIvsnprintf(BIvfprintf.getValue() + 1),
  BIvsprintf(BIvsnprintf.getValue() + 1),
  BIscanf(BIvsprintf.getValue() + 1),
  BIfscanf(BIscanf.getValue() + 1),
  BIsscanf(BIfscanf.getValue() + 1),
  BIvscanf(BIsscanf.getValue() + 1),
  BIvfscanf(BIvscanf.getValue() + 1),
  BIvsscanf(BIvfscanf.getValue() + 1),
  // C99 ctype.h
  BIisalnum(BIvsscanf.getValue() + 1),
  BIisalpha(BIisalnum.getValue() + 1),
  BIisblank(BIisalpha.getValue() + 1),
  BIiscntrl(BIisblank.getValue() + 1),
  BIisdigit(BIiscntrl.getValue() + 1),
  BIisgraph(BIisdigit.getValue() + 1),
  BIislower(BIisgraph.getValue() + 1),
  BIisprint(BIislower.getValue() + 1),
  BIispunct(BIisprint.getValue() + 1),
  BIisspace(BIispunct.getValue() + 1),
  BIisupper(BIisspace.getValue() + 1),
  BIisxdigit(BIisupper.getValue() + 1),
  BItolower(BIisxdigit.getValue() + 1),
  BItoupper(BItolower.getValue() + 1),
  BIsetjmp(BItoupper.getValue() + 1),
  BIlongjmp(BIsetjmp.getValue() + 1),
  
  // Non-C library functions, active in GNU mode only.
  // Functions with (returns_twice) attribute (marked as "j") are still active in
  // all languages, because losing this attribute would result in miscompilation
  // when these functions are used in non-GNU mode. PR16138.
  BIalloca(BIlongjmp.getValue() + 1),
  // POSIX string.h
  BIstpcpy(BIalloca.getValue() + 1),
  BIstpncpy(BIstpcpy.getValue() + 1),
  BIstrdup(BIstpncpy.getValue() + 1),
  BIstrndup(BIstrdup.getValue() + 1),
  // POSIX strings.h
  BIindex(BIstrndup.getValue() + 1),
  BIrindex(BIindex.getValue() + 1),
  BIbzero(BIrindex.getValue() + 1),
  BIstrcasecmp(BIbzero.getValue() + 1),
  BIstrncasecmp(BIstrcasecmp.getValue() + 1),
  // POSIX unistd.h
  BI_exit(BIstrncasecmp.getValue() + 1),
  BIvfork(BI_exit.getValue() + 1),
  // POSIX setjmp.h
  BI_setjmp(BIvfork.getValue() + 1),
  BI__sigsetjmp(BI_setjmp.getValue() + 1),
  BIsigsetjmp(BI__sigsetjmp.getValue() + 1),
  BIsetjmp_syscall(BIsigsetjmp.getValue() + 1),
  BIsavectx(BIsetjmp_syscall.getValue() + 1),
  BIqsetjmp(BIsavectx.getValue() + 1),
  BIgetcontext(BIqsetjmp.getValue() + 1),
  BI_longjmp(BIgetcontext.getValue() + 1),
  BIsiglongjmp(BI_longjmp.getValue() + 1),
  // non-standard but very common
  BIstrlcpy(BIsiglongjmp.getValue() + 1),
  BIstrlcat(BIstrlcpy.getValue() + 1),
  //   id objc_msgSend(id, SEL, ...)
  BIobjc_msgSend(BIstrlcat.getValue() + 1),
  // long double objc_msgSend_fpret(id self, SEL op, ...) 
  BIobjc_msgSend_fpret(BIobjc_msgSend.getValue() + 1),
  // _Complex long double objc_msgSend_fp2ret(id self, SEL op, ...)
  BIobjc_msgSend_fp2ret(BIobjc_msgSend_fpret.getValue() + 1),
  // void objc_msgSend_stret (id, SEL, ...)
  BIobjc_msgSend_stret(BIobjc_msgSend_fp2ret.getValue() + 1),
  // id objc_msgSendSuper(struct objc_super *super, SEL op, ...)
  BIobjc_msgSendSuper(BIobjc_msgSend_stret.getValue() + 1),
  // void objc_msgSendSuper_stret(struct objc_super *super, SEL op, ...)
  BIobjc_msgSendSuper_stret(BIobjc_msgSendSuper.getValue() + 1),
  //   id objc_getClass(const char *name)
  BIobjc_getClass(BIobjc_msgSendSuper_stret.getValue() + 1),
  //   id objc_getMetaClass(const char *name)
  BIobjc_getMetaClass(BIobjc_getClass.getValue() + 1),
  // void objc_enumerationMutation(id)
  BIobjc_enumerationMutation(BIobjc_getMetaClass.getValue() + 1),
  
  // id objc_read_weak(id *location)
  BIobjc_read_weak(BIobjc_enumerationMutation.getValue() + 1),
  // id objc_assign_weak(id value, id *location)
  BIobjc_assign_weak(BIobjc_read_weak.getValue() + 1),
  // id objc_assign_ivar(id value, id dest, ptrdiff_t offset)
  BIobjc_assign_ivar(BIobjc_assign_weak.getValue() + 1),
  // id objc_assign_global(id val, id *dest)
  BIobjc_assign_global(BIobjc_assign_ivar.getValue() + 1),
  // id objc_assign_strongCast(id val, id *dest
  BIobjc_assign_strongCast(BIobjc_assign_global.getValue() + 1),
  
  // id objc_exception_extract(void *localExceptionData)
  BIobjc_exception_extract(BIobjc_assign_strongCast.getValue() + 1),
  // void objc_exception_try_enter(void *localExceptionData)
  BIobjc_exception_try_enter(BIobjc_exception_extract.getValue() + 1),
  // void objc_exception_try_exit(void *localExceptionData)
  BIobjc_exception_try_exit(BIobjc_exception_try_enter.getValue() + 1),
  // int objc_exception_match(Class exceptionClass, id exception)
  BIobjc_exception_match(BIobjc_exception_try_exit.getValue() + 1),
  // void objc_exception_throw(id exception)
  BIobjc_exception_throw(BIobjc_exception_match.getValue() + 1),
  
  // int objc_sync_enter(id obj)
  BIobjc_sync_enter(BIobjc_exception_throw.getValue() + 1),
  // int objc_sync_exit(id obj)
  BIobjc_sync_exit(BIobjc_sync_enter.getValue() + 1),
  BI__builtin_objc_memmove_collectable(BIobjc_sync_exit.getValue() + 1),
  
  // void NSLog(NSString *fmt, ...)
  BINSLog(BI__builtin_objc_memmove_collectable.getValue() + 1),
  // void NSLogv(NSString *fmt, va_list args)
  BINSLogv(BINSLog.getValue() + 1),
  
  // Builtin math library functions
  BIatan2(BINSLogv.getValue() + 1),
  BIatan2f(BIatan2.getValue() + 1),
  BIatan2l(BIatan2f.getValue() + 1),
  BIabs(BIatan2l.getValue() + 1),
  BIlabs(BIabs.getValue() + 1),
  BIllabs(BIlabs.getValue() + 1),
  BIcopysign(BIllabs.getValue() + 1),
  BIcopysignf(BIcopysign.getValue() + 1),
  BIcopysignl(BIcopysignf.getValue() + 1),
  BIfabs(BIcopysignl.getValue() + 1),
  BIfabsf(BIfabs.getValue() + 1),
  BIfabsl(BIfabsf.getValue() + 1),
  BIfmod(BIfabsl.getValue() + 1),
  BIfmodf(BIfmod.getValue() + 1),
  BIfmodl(BIfmodf.getValue() + 1),
  BIfrexp(BIfmodl.getValue() + 1),
  BIfrexpf(BIfrexp.getValue() + 1),
  BIfrexpl(BIfrexpf.getValue() + 1),
  BIldexp(BIfrexpl.getValue() + 1),
  BIldexpf(BIldexp.getValue() + 1),
  BIldexpl(BIldexpf.getValue() + 1),
  BImodf(BIldexpl.getValue() + 1),
  BImodff(BImodf.getValue() + 1),
  BImodfl(BImodff.getValue() + 1),
  BInan(BImodfl.getValue() + 1),
  BInanf(BInan.getValue() + 1),
  BInanl(BInanf.getValue() + 1),
  BIpow(BInanl.getValue() + 1),
  BIpowf(BIpow.getValue() + 1),
  BIpowl(BIpowf.getValue() + 1),
  BIacos(BIpowl.getValue() + 1),
  BIacosf(BIacos.getValue() + 1),
  BIacosl(BIacosf.getValue() + 1),
  BIacosh(BIacosl.getValue() + 1),
  BIacoshf(BIacosh.getValue() + 1),
  BIacoshl(BIacoshf.getValue() + 1),
  BIasin(BIacoshl.getValue() + 1),
  BIasinf(BIasin.getValue() + 1),
  BIasinl(BIasinf.getValue() + 1),
  BIasinh(BIasinl.getValue() + 1),
  BIasinhf(BIasinh.getValue() + 1),
  BIasinhl(BIasinhf.getValue() + 1),
  BIatan(BIasinhl.getValue() + 1),
  BIatanf(BIatan.getValue() + 1),
  BIatanl(BIatanf.getValue() + 1),
  BIatanh(BIatanl.getValue() + 1),
  BIatanhf(BIatanh.getValue() + 1),
  BIatanhl(BIatanhf.getValue() + 1),
  BIcbrt(BIatanhl.getValue() + 1),
  BIcbrtf(BIcbrt.getValue() + 1),
  BIcbrtl(BIcbrtf.getValue() + 1),
  BIceil(BIcbrtl.getValue() + 1),
  BIceilf(BIceil.getValue() + 1),
  BIceill(BIceilf.getValue() + 1),
  BIcos(BIceill.getValue() + 1),
  BIcosf(BIcos.getValue() + 1),
  BIcosl(BIcosf.getValue() + 1),
  BIcosh(BIcosl.getValue() + 1),
  BIcoshf(BIcosh.getValue() + 1),
  BIcoshl(BIcoshf.getValue() + 1),
  BIerf(BIcoshl.getValue() + 1),
  BIerff(BIerf.getValue() + 1),
  BIerfl(BIerff.getValue() + 1),
  BIerfc(BIerfl.getValue() + 1),
  BIerfcf(BIerfc.getValue() + 1),
  BIerfcl(BIerfcf.getValue() + 1),
  BIexp(BIerfcl.getValue() + 1),
  BIexpf(BIexp.getValue() + 1),
  BIexpl(BIexpf.getValue() + 1),
  BIexp2(BIexpl.getValue() + 1),
  BIexp2f(BIexp2.getValue() + 1),
  BIexp2l(BIexp2f.getValue() + 1),
  BIexpm1(BIexp2l.getValue() + 1),
  BIexpm1f(BIexpm1.getValue() + 1),
  BIexpm1l(BIexpm1f.getValue() + 1),
  BIfdim(BIexpm1l.getValue() + 1),
  BIfdimf(BIfdim.getValue() + 1),
  BIfdiml(BIfdimf.getValue() + 1),
  BIfloor(BIfdiml.getValue() + 1),
  BIfloorf(BIfloor.getValue() + 1),
  BIfloorl(BIfloorf.getValue() + 1),
  BIfma(BIfloorl.getValue() + 1),
  BIfmaf(BIfma.getValue() + 1),
  BIfmal(BIfmaf.getValue() + 1),
  BIfmax(BIfmal.getValue() + 1),
  BIfmaxf(BIfmax.getValue() + 1),
  BIfmaxl(BIfmaxf.getValue() + 1),
  BIfmin(BIfmaxl.getValue() + 1),
  BIfminf(BIfmin.getValue() + 1),
  BIfminl(BIfminf.getValue() + 1),
  BIhypot(BIfminl.getValue() + 1),
  BIhypotf(BIhypot.getValue() + 1),
  BIhypotl(BIhypotf.getValue() + 1),
  BIilogb(BIhypotl.getValue() + 1),
  BIilogbf(BIilogb.getValue() + 1),
  BIilogbl(BIilogbf.getValue() + 1),
  BIlgamma(BIilogbl.getValue() + 1),
  BIlgammaf(BIlgamma.getValue() + 1),
  BIlgammal(BIlgammaf.getValue() + 1),
  BIllrint(BIlgammal.getValue() + 1),
  BIllrintf(BIllrint.getValue() + 1),
  BIllrintl(BIllrintf.getValue() + 1),
  BIllround(BIllrintl.getValue() + 1),
  BIllroundf(BIllround.getValue() + 1),
  BIllroundl(BIllroundf.getValue() + 1),
  BIlog(BIllroundl.getValue() + 1),
  BIlogf(BIlog.getValue() + 1),
  BIlogl(BIlogf.getValue() + 1),
  BIlog10(BIlogl.getValue() + 1),
  BIlog10f(BIlog10.getValue() + 1),
  BIlog10l(BIlog10f.getValue() + 1),
  BIlog1p(BIlog10l.getValue() + 1),
  BIlog1pf(BIlog1p.getValue() + 1),
  BIlog1pl(BIlog1pf.getValue() + 1),
  BIlog2(BIlog1pl.getValue() + 1),
  BIlog2f(BIlog2.getValue() + 1),
  BIlog2l(BIlog2f.getValue() + 1),
  BIlogb(BIlog2l.getValue() + 1),
  BIlogbf(BIlogb.getValue() + 1),
  BIlogbl(BIlogbf.getValue() + 1),
  BIlrint(BIlogbl.getValue() + 1),
  BIlrintf(BIlrint.getValue() + 1),
  BIlrintl(BIlrintf.getValue() + 1),
  BIlround(BIlrintl.getValue() + 1),
  BIlroundf(BIlround.getValue() + 1),
  BIlroundl(BIlroundf.getValue() + 1),
  BInearbyint(BIlroundl.getValue() + 1),
  BInearbyintf(BInearbyint.getValue() + 1),
  BInearbyintl(BInearbyintf.getValue() + 1),
  BInextafter(BInearbyintl.getValue() + 1),
  BInextafterf(BInextafter.getValue() + 1),
  BInextafterl(BInextafterf.getValue() + 1),
  BInexttoward(BInextafterl.getValue() + 1),
  BInexttowardf(BInexttoward.getValue() + 1),
  BInexttowardl(BInexttowardf.getValue() + 1),
  BIremainder(BInexttowardl.getValue() + 1),
  BIremainderf(BIremainder.getValue() + 1),
  BIremainderl(BIremainderf.getValue() + 1),
  BIrint(BIremainderl.getValue() + 1),
  BIrintf(BIrint.getValue() + 1),
  BIrintl(BIrintf.getValue() + 1),
  BIround(BIrintl.getValue() + 1),
  BIroundf(BIround.getValue() + 1),
  BIroundl(BIroundf.getValue() + 1),
  BIscalbln(BIroundl.getValue() + 1),
  BIscalblnf(BIscalbln.getValue() + 1),
  BIscalblnl(BIscalblnf.getValue() + 1),
  BIscalbn(BIscalblnl.getValue() + 1),
  BIscalbnf(BIscalbn.getValue() + 1),
  BIscalbnl(BIscalbnf.getValue() + 1),
  BIsin(BIscalbnl.getValue() + 1),
  BIsinf(BIsin.getValue() + 1),
  BIsinl(BIsinf.getValue() + 1),
  BIsinh(BIsinl.getValue() + 1),
  BIsinhf(BIsinh.getValue() + 1),
  BIsinhl(BIsinhf.getValue() + 1),
  BIsqrt(BIsinhl.getValue() + 1),
  BIsqrtf(BIsqrt.getValue() + 1),
  BIsqrtl(BIsqrtf.getValue() + 1),
  BItan(BIsqrtl.getValue() + 1),
  BItanf(BItan.getValue() + 1),
  BItanl(BItanf.getValue() + 1),
  BItanh(BItanl.getValue() + 1),
  BItanhf(BItanh.getValue() + 1),
  BItanhl(BItanhf.getValue() + 1),
  BItgamma(BItanhl.getValue() + 1),
  BItgammaf(BItgamma.getValue() + 1),
  BItgammal(BItgammaf.getValue() + 1),
  BItrunc(BItgammal.getValue() + 1),
  BItruncf(BItrunc.getValue() + 1),
  BItruncl(BItruncf.getValue() + 1),
  BIcabs(BItruncl.getValue() + 1),
  BIcabsf(BIcabs.getValue() + 1),
  BIcabsl(BIcabsf.getValue() + 1),
  BIcacos(BIcabsl.getValue() + 1),
  BIcacosf(BIcacos.getValue() + 1),
  BIcacosl(BIcacosf.getValue() + 1),
  BIcacosh(BIcacosl.getValue() + 1),
  BIcacoshf(BIcacosh.getValue() + 1),
  BIcacoshl(BIcacoshf.getValue() + 1),
  BIcarg(BIcacoshl.getValue() + 1),
  BIcargf(BIcarg.getValue() + 1),
  BIcargl(BIcargf.getValue() + 1),
  BIcasin(BIcargl.getValue() + 1),
  BIcasinf(BIcasin.getValue() + 1),
  BIcasinl(BIcasinf.getValue() + 1),
  BIcasinh(BIcasinl.getValue() + 1),
  BIcasinhf(BIcasinh.getValue() + 1),
  BIcasinhl(BIcasinhf.getValue() + 1),
  BIcatan(BIcasinhl.getValue() + 1),
  BIcatanf(BIcatan.getValue() + 1),
  BIcatanl(BIcatanf.getValue() + 1),
  BIcatanh(BIcatanl.getValue() + 1),
  BIcatanhf(BIcatanh.getValue() + 1),
  BIcatanhl(BIcatanhf.getValue() + 1),
  BIccos(BIcatanhl.getValue() + 1),
  BIccosf(BIccos.getValue() + 1),
  BIccosl(BIccosf.getValue() + 1),
  BIccosh(BIccosl.getValue() + 1),
  BIccoshf(BIccosh.getValue() + 1),
  BIccoshl(BIccoshf.getValue() + 1),
  BIcexp(BIccoshl.getValue() + 1),
  BIcexpf(BIcexp.getValue() + 1),
  BIcexpl(BIcexpf.getValue() + 1),
  BIcimag(BIcexpl.getValue() + 1),
  BIcimagf(BIcimag.getValue() + 1),
  BIcimagl(BIcimagf.getValue() + 1),
  BIconj(BIcimagl.getValue() + 1),
  BIconjf(BIconj.getValue() + 1),
  BIconjl(BIconjf.getValue() + 1),
  BIclog(BIconjl.getValue() + 1),
  BIclogf(BIclog.getValue() + 1),
  BIclogl(BIclogf.getValue() + 1),
  BIcproj(BIclogl.getValue() + 1),
  BIcprojf(BIcproj.getValue() + 1),
  BIcprojl(BIcprojf.getValue() + 1),
  BIcpow(BIcprojl.getValue() + 1),
  BIcpowf(BIcpow.getValue() + 1),
  BIcpowl(BIcpowf.getValue() + 1),
  BIcreal(BIcpowl.getValue() + 1),
  BIcrealf(BIcreal.getValue() + 1),
  BIcreall(BIcrealf.getValue() + 1),
  BIcsin(BIcreall.getValue() + 1),
  BIcsinf(BIcsin.getValue() + 1),
  BIcsinl(BIcsinf.getValue() + 1),
  BIcsinh(BIcsinl.getValue() + 1),
  BIcsinhf(BIcsinh.getValue() + 1),
  BIcsinhl(BIcsinhf.getValue() + 1),
  BIcsqrt(BIcsinhl.getValue() + 1),
  BIcsqrtf(BIcsqrt.getValue() + 1),
  BIcsqrtl(BIcsqrtf.getValue() + 1),
  BIctan(BIcsqrtl.getValue() + 1),
  BIctanf(BIctan.getValue() + 1),
  BIctanl(BIctanf.getValue() + 1),
  BIctanh(BIctanl.getValue() + 1),
  BIctanhf(BIctanh.getValue() + 1),
  BIctanhl(BIctanhf.getValue() + 1),
  
  // __sinpi and friends are OS X specific library functions, but otherwise much
  // like the standard (non-complex) sin (etc).
  BI__sinpi(BIctanhl.getValue() + 1),
  BI__sinpif(BI__sinpi.getValue() + 1),
  BI__cospi(BI__sinpif.getValue() + 1),
  BI__cospif(BI__cospi.getValue() + 1),
  BI__tanpi(BI__cospif.getValue() + 1),
  BI__tanpif(BI__tanpi.getValue() + 1),
  
  // Similarly, __exp10 is OS X only
  BI__exp10(BI__tanpif.getValue() + 1),
  BI__exp10f(BI__exp10.getValue() + 1),
  
  // Blocks runtime Builtin math library functions
  BI_Block_object_assign(BI__exp10f.getValue() + 1),
  BI_Block_object_dispose(BI_Block_object_assign.getValue() + 1),
  // FIXME: Also declare NSConcreteGlobalBlock and NSConcreteStackBlock.
  
  // Annotation function
  BI__builtin_annotation(BI_Block_object_dispose.getValue() + 1),
  
  // Invariants
  BI__builtin_assume(BI__builtin_annotation.getValue() + 1),
  
  // Multiprecision Arithmetic Builtins.
  BI__builtin_addcb(BI__builtin_assume.getValue() + 1),
  BI__builtin_addcs(BI__builtin_addcb.getValue() + 1),
  BI__builtin_addc(BI__builtin_addcs.getValue() + 1),
  BI__builtin_addcl(BI__builtin_addc.getValue() + 1),
  BI__builtin_addcll(BI__builtin_addcl.getValue() + 1),
  BI__builtin_subcb(BI__builtin_addcll.getValue() + 1),
  BI__builtin_subcs(BI__builtin_subcb.getValue() + 1),
  BI__builtin_subc(BI__builtin_subcs.getValue() + 1),
  BI__builtin_subcl(BI__builtin_subc.getValue() + 1),
  BI__builtin_subcll(BI__builtin_subcl.getValue() + 1),
  
  // Checked Arithmetic Builtins for Security.
  BI__builtin_add_overflow(BI__builtin_subcll.getValue() + 1),
  BI__builtin_sub_overflow(BI__builtin_add_overflow.getValue() + 1),
  BI__builtin_mul_overflow(BI__builtin_sub_overflow.getValue() + 1),
  BI__builtin_uadd_overflow(BI__builtin_mul_overflow.getValue() + 1),
  BI__builtin_uaddl_overflow(BI__builtin_uadd_overflow.getValue() + 1),
  BI__builtin_uaddll_overflow(BI__builtin_uaddl_overflow.getValue() + 1),
  BI__builtin_usub_overflow(BI__builtin_uaddll_overflow.getValue() + 1),
  BI__builtin_usubl_overflow(BI__builtin_usub_overflow.getValue() + 1),
  BI__builtin_usubll_overflow(BI__builtin_usubl_overflow.getValue() + 1),
  BI__builtin_umul_overflow(BI__builtin_usubll_overflow.getValue() + 1),
  BI__builtin_umull_overflow(BI__builtin_umul_overflow.getValue() + 1),
  BI__builtin_umulll_overflow(BI__builtin_umull_overflow.getValue() + 1),
  BI__builtin_sadd_overflow(BI__builtin_umulll_overflow.getValue() + 1),
  BI__builtin_saddl_overflow(BI__builtin_sadd_overflow.getValue() + 1),
  BI__builtin_saddll_overflow(BI__builtin_saddl_overflow.getValue() + 1),
  BI__builtin_ssub_overflow(BI__builtin_saddll_overflow.getValue() + 1),
  BI__builtin_ssubl_overflow(BI__builtin_ssub_overflow.getValue() + 1),
  BI__builtin_ssubll_overflow(BI__builtin_ssubl_overflow.getValue() + 1),
  BI__builtin_smul_overflow(BI__builtin_ssubll_overflow.getValue() + 1),
  BI__builtin_smull_overflow(BI__builtin_smul_overflow.getValue() + 1),
  BI__builtin_smulll_overflow(BI__builtin_smull_overflow.getValue() + 1),
  
  // Clang builtins (not available in GCC).
  BI__builtin_addressof(BI__builtin_smulll_overflow.getValue() + 1),
  BI__builtin_operator_new(BI__builtin_addressof.getValue() + 1),
  BI__builtin_operator_delete(BI__builtin_operator_new.getValue() + 1),
  
  // Safestack builtins
  BI__builtin___get_unsafe_stack_start(BI__builtin_operator_delete.getValue() + 1),
  BI__builtin___get_unsafe_stack_ptr(BI__builtin___get_unsafe_stack_start.getValue() + 1),
  
  // Nontemporal loads/stores builtins
  BI__builtin_nontemporal_store(BI__builtin___get_unsafe_stack_ptr.getValue() + 1),
  BI__builtin_nontemporal_load(BI__builtin_nontemporal_store.getValue() + 1),
  
  // OpenCL v2.0 s6.13.16, s9.17.3.5 - Pipe functions.
  // We need the generic prototype, since the packet type could be anything.
  BIread_pipe(BI__builtin_nontemporal_load.getValue() + 1),
  BIwrite_pipe(BIread_pipe.getValue() + 1),
  BIreserve_read_pipe(BIwrite_pipe.getValue() + 1),
  BIreserve_write_pipe(BIreserve_read_pipe.getValue() + 1),
  BIcommit_write_pipe(BIreserve_write_pipe.getValue() + 1),
  BIcommit_read_pipe(BIcommit_write_pipe.getValue() + 1),
  BIsub_group_reserve_read_pipe(BIcommit_read_pipe.getValue() + 1),
  BIsub_group_reserve_write_pipe(BIsub_group_reserve_read_pipe.getValue() + 1),
  BIsub_group_commit_read_pipe(BIsub_group_reserve_write_pipe.getValue() + 1),
  BIsub_group_commit_write_pipe(BIsub_group_commit_read_pipe.getValue() + 1),
  BIwork_group_reserve_read_pipe(BIsub_group_commit_write_pipe.getValue() + 1),
  BIwork_group_reserve_write_pipe(BIwork_group_reserve_read_pipe.getValue() + 1),
  BIwork_group_commit_read_pipe(BIwork_group_reserve_write_pipe.getValue() + 1),
  BIwork_group_commit_write_pipe(BIwork_group_commit_read_pipe.getValue() + 1),
  BIget_pipe_num_packets(BIwork_group_commit_write_pipe.getValue() + 1),
  BIget_pipe_max_packets(BIget_pipe_num_packets.getValue() + 1),
  
  // OpenCL v2.0 s6.13.17 - Enqueue kernel functions.
  // Custom builtin check allows to perform special check of passed block arguments.
  BIenqueue_kernel(BIget_pipe_max_packets.getValue() + 1),
  BIget_kernel_work_group_size(BIenqueue_kernel.getValue() + 1),
  BIget_kernel_preferred_work_group_size_multiple(BIget_kernel_work_group_size.getValue() + 1),
  
  // OpenCL v2.0 s6.13.9 - Address space qualifier functions.
  BIto_global(BIget_kernel_preferred_work_group_size_multiple.getValue() + 1),
  BIto_local(BIto_global.getValue() + 1),
  BIto_private(BIto_local.getValue() + 1),
  FirstTSBuiltin(BIto_private.getValue() + 1),
  BI_JavaOutOfRange(Integer.MAX_VALUE);

  // JAVA: This enum is very special. It is used in switch/case but 'val' can be out of range
  // and switch jumps to default branch in native, emulate this in JAVA
  // by returning enumerator not used anywere
  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ID valueOf(int val) {
    if (val > Values.THE_LAST_VALID_VALUE) {
      return BI_JavaOutOfRange;
    }
    assert val >= 0;
    ID out = Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }
  
  private static final class Values {
    private static final ID[] VALUES;
    private static final ID[] _VALUES; // [0] not used
    private static final int THE_LAST_VALID_VALUE;
    static {
      int max = 0;
      int min = 0;
      for (ID kind : ID.values()) {
        if (kind != BI_JavaOutOfRange) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
      }
      assert min == 0;
      _VALUES = new ID[min < 0 ? (1-min) : 0];
      assert max == FirstTSBuiltin.value;
      VALUES = new ID[max];
      for (ID kind : ID.values()) {
        if (kind != BI_JavaOutOfRange && kind != FirstTSBuiltin) {
          VALUES[kind.value] = kind;
        }
      }
      // use the previous index as the last valid query value, all others are out-of-range
      THE_LAST_VALID_VALUE = FirstTSBuiltin.value - 1;
    }
  }
  
  private final /*uint*/int value;
  private ID(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ID)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ID)obj).value);}
  //</editor-fold>
  }

//<editor-fold defaultstate="collapsed" desc="clang::Builtin::Info">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 53,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 52,
 FQN="clang::Builtin::Info", NM="_ZN5clang7Builtin4InfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin4InfoE")
//</editor-fold>
public static class/*struct*/ Info {
  public final /*const*/char$ptr/*char P*/ Name;
  public final /*const*/char$ptr/*char P*/ Type;
  public final /*const*/char$ptr/*char P*/ Attributes;
  public final /*const*/char$ptr/*char P*/ HeaderName;
  public final /*LanguageID*//*uint*/int Langs;
  public final /*const*/char$ptr/*char P*/ Features;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Info">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 52)
  //</editor-fold>  
  public Info(Object/*char$ptr || String*/ Name, Object/*char$ptr || String*/ Type, Object/*char$ptr || String*/ Attributes, Object/*char$ptr || String*/ HeaderName, 
          /*LanguageID*//*uint*/int Langs, Object/*char$ptr || String*/  Features) {
    assert Name != null;
    this.Name = param2constPtr(Name);
    this.Type = param2constPtr(Type);
    this.Attributes = param2constPtr(Attributes);
    this.HeaderName = param2constPtr(HeaderName);
    this.Langs = Langs;
    this.Features = param2constPtr(Features);
  }
  private static char$ptr param2constPtr(Object/*char$ptr || String*/ param) {
    if (param == null) {
      return null;
    }
    if (param instanceof String) {
      return $toConst(create_char$ptr_utf8((String)param));
    }
    assert param instanceof char$ptr : "must be char$ptr " + param.getClass();
    return $toConst((char$ptr)param);
  }
  
  public String toString() {
    return "" + "Name=" + Casts.toJavaString(Name) // NOI18N
              + ", Type=" + Casts.toJavaString(Type) // NOI18N
              + ", Attributes=" + Casts.toJavaString(Attributes) // NOI18N
              + ", HeaderName=" + Casts.toJavaString(HeaderName) // NOI18N
              + ", (LanguageID)Langs=" + Integer.toBinaryString(Langs) // NOI18N
              + ", Features=" + Casts.toJavaString(Features); // NOI18N
  }
}

/// \brief Holds information about both target-independent and
/// target-specific builtins, allowing easy queries by clients.
///
/// Builtins from an optional auxiliary target are stored in
/// AuxTSRecords. Their IDs are shifted up by TSRecords.size() and need to
/// be translated back with getAuxBuiltinID() before use.
//<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 65,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 64,
 FQN="clang::Builtin::Context", NM="_ZN5clang7Builtin7ContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7ContextE")
//</editor-fold>
public static class Context {
  private ArrayRef<Info> TSRecords;
  private ArrayRef<Info> AuxTSRecords;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::Context">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 69,
   FQN="clang::Builtin::Context::Context", NM="_ZN5clang7Builtin7ContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7ContextC1Ev")
  //</editor-fold>
  public Context() {
    /* : TSRecords(), AuxTSRecords()*/ 
    //START JInit
    this.TSRecords = new ArrayRef<Info>();
    this.AuxTSRecords = new ArrayRef<Info>();
    //END JInit
  }

  
  /// \brief Perform target-specific initialization
  /// \param AuxTarget Target info to incorporate builtins from. May be nullptr.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::InitializeTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 43,
   FQN="clang::Builtin::Context::InitializeTarget", NM="_ZN5clang7Builtin7Context16InitializeTargetERKNS_10TargetInfoEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context16InitializeTargetERKNS_10TargetInfoEPS3_")
  //</editor-fold>
  public void InitializeTarget(/*const*/ TargetInfo /*&*/ Target, 
                  /*const*/ TargetInfo /*P*/ AuxTarget) {
    assert (TSRecords.empty()) : "Already initialized target?";
    TSRecords.$assignMove(Target.getTargetBuiltins());
    if ((AuxTarget != null)) {
      AuxTSRecords.$assignMove(AuxTarget.getTargetBuiltins());
    }
  }

  
  /// \brief Mark the identifiers for all the builtins with their
  /// appropriate builtin ID # and mark any non-portable builtin identifiers as
  /// such.
  
  /// initializeBuiltins - Mark the identifiers for all the builtins with their
  /// appropriate builtin ID # and mark any non-portable builtin identifiers as
  /// such.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::initializeBuiltins">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", old_line = 79,
   FQN="clang::Builtin::Context::initializeBuiltins", NM="_ZN5clang7Builtin7Context18initializeBuiltinsERNS_15IdentifierTableERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context18initializeBuiltinsERNS_15IdentifierTableERKNS_11LangOptionsE")
  //</editor-fold>
  public void initializeBuiltins(IdentifierTable /*&*/ Table, 
                    /*const*/ LangOptions /*&*/ LangOpts) {
    // Step #1: mark all target-independent builtins with their ID's.
    for (/*uint*/int i = Builtin.ID.NotBuiltin.getValue() + 1; i != Builtin.ID.FirstTSBuiltin.getValue(); ++i)  {
      if (builtinIsSupported(BuiltinInfo$Clang$Builtins[i], LangOpts)) {
        char$ptr $Name = BuiltinInfo$Clang$Builtins[i].Name;
        Table.get($Name.$array(), $Name.$index(), std.strlen($Name)).setBuiltinID(i);
      }
    }
    
    // Step #2: Register target-specific builtins.
    for (/*uint*/int i = 0, e = TSRecords.size(); i != e; ++i)  {
      if (builtinIsSupported(TSRecords.$at(i), LangOpts)) {
        char$ptr $Name = TSRecords.$at(i).Name;
        Table.get($Name.$array(), $Name.$index(), std.strlen($Name)).setBuiltinID(i + Builtin.ID.FirstTSBuiltin.getValue());
      }
    }
    
    // Step #3: Register target-specific builtins for AuxTarget.
    for (/*uint*/int i = 0, e = AuxTSRecords.size(); i != e; ++i)  {
      char$ptr $Name = AuxTSRecords.$at(i).Name;
      Table.get($Name.$array(), $Name.$index(), std.strlen($Name)).
          setBuiltinID(i + Builtin.ID.FirstTSBuiltin.getValue() + TSRecords.size());
    }
  }

  
  /// \brief Return the identifier name for the specified builtin,
  /// e.g. "__builtin_abs".
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 82,
   FQN="clang::Builtin::Context::getName", NM="_ZNK5clang7Builtin7Context7getNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context7getNameEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName(/*uint*/int ID) /*const*/ {
    return getRecord(ID).Name;
  }

  
  /// \brief Get the type descriptor string for the specified builtin.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::getTypeString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 87,
   FQN="clang::Builtin::Context::getTypeString", NM="_ZNK5clang7Builtin7Context13getTypeStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context13getTypeStringEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getTypeString(/*uint*/int ID) /*const*/ {
    return getRecord(ID).Type;
  }

  
  /// \brief Return true if this function is a target-specific builtin.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isTSBuiltin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 92,
   FQN="clang::Builtin::Context::isTSBuiltin", NM="_ZNK5clang7Builtin7Context11isTSBuiltinEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context11isTSBuiltinEj")
  //</editor-fold>
  public boolean isTSBuiltin(/*uint*/int ID) /*const*/ {
    return $greatereq_uint(ID, Builtin.ID.FirstTSBuiltin.getValue());
  }

  
  /// \brief Return true if this function has no side effects.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isPure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 98,
   FQN="clang::Builtin::Context::isPure", NM="_ZNK5clang7Builtin7Context6isPureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context6isPureEj")
  //</editor-fold>
  public boolean isPure(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$U) != null;
  }

  
  /// \brief Return true if this function has no side effects and doesn't
  /// read memory.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 98,
   FQN="clang::Builtin::Context::isConst", NM="_ZNK5clang7Builtin7Context7isConstEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context7isConstEj")
  //</editor-fold>
  public boolean isConst(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$c) != null;
  }

  
  /// \brief Return true if we know this builtin never throws an exception.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isNoThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 103,
   FQN="clang::Builtin::Context::isNoThrow", NM="_ZNK5clang7Builtin7Context9isNoThrowEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context9isNoThrowEj")
  //</editor-fold>
  public boolean isNoThrow(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$n) != null;
  }

  
  /// \brief Return true if we know this builtin never returns.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 108,
   FQN="clang::Builtin::Context::isNoReturn", NM="_ZNK5clang7Builtin7Context10isNoReturnEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context10isNoReturnEj")
  //</editor-fold>
  public boolean isNoReturn(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$r) != null;
  }

  
  /// \brief Return true if we know this builtin can return twice.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isReturnsTwice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 113,
   FQN="clang::Builtin::Context::isReturnsTwice", NM="_ZNK5clang7Builtin7Context14isReturnsTwiceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context14isReturnsTwiceEj")
  //</editor-fold>
  public boolean isReturnsTwice(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$j) != null;
  }

  
  /// \brief Returns true if this builtin does not perform the side-effects
  /// of its arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isUnevaluated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 119,
   FQN="clang::Builtin::Context::isUnevaluated", NM="_ZNK5clang7Builtin7Context13isUnevaluatedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context13isUnevaluatedEj")
  //</editor-fold>
  public boolean isUnevaluated(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$u) != null;
  }

  
  /// \brief Return true if this is a builtin for a libc/libm function,
  /// with a "__builtin_" prefix (e.g. __builtin_abs).
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isLibFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 131,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 125,
   FQN="clang::Builtin::Context::isLibFunction", NM="_ZNK5clang7Builtin7Context13isLibFunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context13isLibFunctionEj")
  //</editor-fold>
  public boolean isLibFunction(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$F) != null;
  }

  
  /// \brief Determines whether this builtin is a predefined libc/libm
  /// function, such as "malloc", where we know the signature a
  /// priori.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isPredefinedLibFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 132,
   FQN="clang::Builtin::Context::isPredefinedLibFunction", NM="_ZNK5clang7Builtin7Context23isPredefinedLibFunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context23isPredefinedLibFunctionEj")
  //</editor-fold>
  public boolean isPredefinedLibFunction(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$f) != null;
  }

  
  /// \brief Determines whether this builtin is a predefined compiler-rt/libgcc
  /// function, such as "__clear_cache", where we know the signature a
  /// priori.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isPredefinedRuntimeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 139,
   FQN="clang::Builtin::Context::isPredefinedRuntimeFunction", NM="_ZNK5clang7Builtin7Context27isPredefinedRuntimeFunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context27isPredefinedRuntimeFunctionEj")
  //</editor-fold>
  public boolean isPredefinedRuntimeFunction(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$i) != null;
  }

  
  /// \brief Determines whether this builtin has custom typechecking.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::hasCustomTypechecking">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 144,
   FQN="clang::Builtin::Context::hasCustomTypechecking", NM="_ZNK5clang7Builtin7Context21hasCustomTypecheckingEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context21hasCustomTypecheckingEj")
  //</editor-fold>
  public boolean hasCustomTypechecking(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$t) != null;
  }

  
  /// \brief Determines whether this builtin has a result or any arguments which
  /// are pointer types.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::hasPtrArgsOrResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 150,
   FQN="clang::Builtin::Context::hasPtrArgsOrResult", NM="_ZNK5clang7Builtin7Context18hasPtrArgsOrResultEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context18hasPtrArgsOrResultEj")
  //</editor-fold>
  public boolean hasPtrArgsOrResult(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Type, $$STAR) != null;
  }

  
  /// \brief Completely forget that the given ID was ever considered a builtin,
  /// e.g., because the user provided a conflicting signature.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::forgetBuiltin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", old_line = 98,
   FQN="clang::Builtin::Context::forgetBuiltin", NM="_ZN5clang7Builtin7Context13forgetBuiltinEjRNS_15IdentifierTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context13forgetBuiltinEjRNS_15IdentifierTableE")
  //</editor-fold>
  public void forgetBuiltin(/*uint*/int ID, IdentifierTable /*&*/ Table) {
    char$ptr $Name = getRecord(ID).Name;
    Table.get($Name.$array(), $Name.$index(), std.strlen($Name)).setBuiltinID(0);
  }

  
  /// \brief If this is a library function that comes from a specific
  /// header, retrieve that header name.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::getHeaderName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 160,
   FQN="clang::Builtin::Context::getHeaderName", NM="_ZNK5clang7Builtin7Context13getHeaderNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context13getHeaderNameEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getHeaderName(/*uint*/int ID) /*const*/ {
    return getRecord(ID).HeaderName;
  }

  
  /// \brief Determine whether this builtin is like printf in its
  /// formatting rules and, if so, set the index to the format string
  /// argument and whether this function as a va_list argument.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isPrintfLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 127,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", old_line = 125,
   FQN="clang::Builtin::Context::isPrintfLike", NM="_ZN5clang7Builtin7Context12isPrintfLikeEjRjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context12isPrintfLikeEjRjRb")
  //</editor-fold>
  public boolean isPrintfLike(/*uint*/int ID, uint$ref/*uint &*/ FormatIdx, 
              bool$ref/*bool &*/ HasVAListArg) {
    return isLike(ID, FormatIdx, HasVAListArg, $("pP"));
  }

  
  /// \brief Determine whether this builtin is like scanf in its
  /// formatting rules and, if so, set the index to the format string
  /// argument and whether this function as a va_list argument.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isScanfLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 132,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", old_line = 130,
   FQN="clang::Builtin::Context::isScanfLike", NM="_ZN5clang7Builtin7Context11isScanfLikeEjRjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context11isScanfLikeEjRjRb")
  //</editor-fold>
  public boolean isScanfLike(/*uint*/int ID, uint$ref/*uint &*/ FormatIdx, 
             bool$ref/*bool &*/ HasVAListArg) {
    return isLike(ID, FormatIdx, HasVAListArg, $("sS"));
  }

  
  /// \brief Return true if this function has no side effects and doesn't
  /// read memory, except for possibly errno.
  ///
  /// Such functions can be const when the MathErrno lang option is disabled.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isConstWithoutErrno">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 178,
   FQN="clang::Builtin::Context::isConstWithoutErrno", NM="_ZNK5clang7Builtin7Context19isConstWithoutErrnoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context19isConstWithoutErrnoEj")
  //</editor-fold>
  public boolean isConstWithoutErrno(/*uint*/int ID) /*const*/ {
    return strchr(getRecord(ID).Attributes, $$e) != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::getRequiredFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 182,
   FQN="clang::Builtin::Context::getRequiredFeatures", NM="_ZNK5clang7Builtin7Context19getRequiredFeaturesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context19getRequiredFeaturesEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getRequiredFeatures(/*uint*/int ID) /*const*/ {
    return getRecord(ID).Features;
  }

  
  /// \brief Return true if builtin ID belongs to AuxTarget.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isAuxBuiltinID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 187,
   FQN="clang::Builtin::Context::isAuxBuiltinID", NM="_ZNK5clang7Builtin7Context14isAuxBuiltinIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context14isAuxBuiltinIDEj")
  //</editor-fold>
  public boolean isAuxBuiltinID(/*uint*/int ID) /*const*/ {
    return $greatereq_uint(ID, (Builtin.ID.FirstTSBuiltin.getValue() + TSRecords.size()));
  }

  
  /// Return real buitin ID (i.e. ID it would have furing compilation
  /// for AuxTarget).
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::getAuxBuiltinID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 193,
   FQN="clang::Builtin::Context::getAuxBuiltinID", NM="_ZNK5clang7Builtin7Context15getAuxBuiltinIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context15getAuxBuiltinIDEj")
  //</editor-fold>
  public /*uint*/int getAuxBuiltinID(/*uint*/int ID) /*const*/ {
    return ID - TSRecords.size();
  }

  
  /// Returns true if this is a libc/libm function without the '__builtin_'
  /// prefix.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isBuiltinFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 51,
   FQN="clang::Builtin::Context::isBuiltinFunc", NM="_ZN5clang7Builtin7Context13isBuiltinFuncEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context13isBuiltinFuncEPKc")
  //</editor-fold>
  public static boolean isBuiltinFunc(/*const*/char$ptr/*char P*/ Name) {
    StringRef FuncName/*J*/= new StringRef(Name);
    for (/*uint*/int i = Builtin.ID.NotBuiltin.getValue() + 1; i != Builtin.ID.FirstTSBuiltin.getValue(); ++i)  {
      if (FuncName.equals(/*STRINGREF_STR*/BuiltinInfo$Clang$Builtins[i].Name)) {
        return strchr(BuiltinInfo$Clang$Builtins[i].Attributes, $$f) != null;
      }
    }
    
    return false;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::getRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 32,
   FQN="clang::Builtin::Context::getRecord", NM="_ZNK5clang7Builtin7Context9getRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context9getRecordEj")
  //</editor-fold>
  private /*const*/ Builtin.Info /*&*/ getRecord(/*uint*/int ID) /*const*/ {
    if ($less_uint(ID, Builtin.ID.FirstTSBuiltin.getValue())) {
      return BuiltinInfo$Clang$Builtins[ID];
    }
    assert (($less_uint((ID - Builtin.ID.FirstTSBuiltin.getValue()), (TSRecords.size() + AuxTSRecords.size())))) : "Invalid builtin ID!";
    if (isAuxBuiltinID(ID)) {
      return AuxTSRecords.$at(getAuxBuiltinID(ID) - Builtin.ID.FirstTSBuiltin.getValue());
    }
    return TSRecords.$at(ID - Builtin.ID.FirstTSBuiltin.getValue());
  }

  
  /// \brief Is this builtin supported according to the given language options?
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::builtinIsSupported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 60,
   FQN="clang::Builtin::Context::builtinIsSupported", NM="_ZN5clang7Builtin7Context18builtinIsSupportedERKNS0_4InfoERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN5clang7Builtin7Context18builtinIsSupportedERKNS0_4InfoERKNS_11LangOptionsE")
  //</editor-fold>
  private boolean builtinIsSupported(/*const*/ Builtin.Info /*&*/ BuiltinInfo, 
                    /*const*/ LangOptions /*&*/ LangOpts) {
    boolean BuiltinsUnsupported = (LangOpts.NoBuiltin || LangOpts.isNoBuiltinFunc(BuiltinInfo.Name))
       && (strchr(BuiltinInfo.Attributes, $$f) != null);
    boolean MathBuiltinsUnsupported = LangOpts.NoMathBuiltin && (BuiltinInfo.HeaderName != null)
       && new StringRef(BuiltinInfo.HeaderName).equals(/*STRINGREF_STR*/"math.h");
    boolean GnuModeUnsupported = !LangOpts.GNUMode && ((BuiltinInfo.Langs & LanguageID.GNU_LANG) != 0);
    boolean MSModeUnsupported = !LangOpts.MicrosoftExt && ((BuiltinInfo.Langs & LanguageID.MS_LANG) != 0);
    boolean ObjCUnsupported = !LangOpts.ObjC1 && BuiltinInfo.Langs == LanguageID.OBJC_LANG;
    boolean OclCUnsupported = LangOpts.OpenCLVersion != 200
       && BuiltinInfo.Langs == LanguageID.OCLC20_LANG;
    return !BuiltinsUnsupported && !MathBuiltinsUnsupported && !OclCUnsupported
       && !GnuModeUnsupported && !MSModeUnsupported && !ObjCUnsupported;
  }

  
  /// \brief Helper function for isPrintfLike and isScanfLike.
  //<editor-fold defaultstate="collapsed" desc="clang::Builtin::Context::isLike">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp", old_line = 102,
   FQN="clang::Builtin::Context::isLike", NM="_ZNK5clang7Builtin7Context6isLikeEjRjRbPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK5clang7Builtin7Context6isLikeEjRjRbPKc")
  //</editor-fold>
  private boolean isLike(/*uint*/int ID, uint$ref/*uint &*/ FormatIdx, 
        bool$ref/*bool &*/ HasVAListArg, /*const*/char$ptr/*char P*/ Fmt) /*const*/ {
    assert ((Fmt != null)) : "Not passed a format string";
    assert (/*::*/strlen(Fmt) == 2) : "Format string needs to be two characters long";
    assert (/*::*/toupper(Fmt.$at(0)) == Fmt.$at(1)) : "Format string is not in the form \"xX\"";
    
    /*const*/char$ptr/*char P*/ Like = $tryClone(/*::*/strpbrk(getRecord(ID).Attributes, Fmt));
    if (!(Like != null)) {
      return false;
    }
    
    HasVAListArg.$set((Like.$star() == Fmt.$at(1)));
    
    Like.$preInc();
    assert (Like.$star() == $$COLON) : "Format specifier must be followed by a ':' [" + Like + "]";
    Like.$preInc();
    assert ((/*::*/strchr(Like, $$COLON) != null)) : "Format specifier must end with a ':' [" + Like + "]";
    FormatIdx.$set(/*::*/$long2uint(strtol(Like, (type$ptr<char$ptr>/*char PP*/ )null, 10)));
    return true;
  }

  
  public String toString() {
    return "" + "TSRecords=" + TSRecords // NOI18N
              + ", AuxTSRecords=" + AuxTSRecords; // NOI18N
  }
}
} // END OF class Builtin
