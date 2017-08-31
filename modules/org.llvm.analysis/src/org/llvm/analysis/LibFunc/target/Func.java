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

package org.llvm.analysis.LibFunc.target;

import org.clank.support.*;

//<editor-fold defaultstate="collapsed" desc="llvm::LibFunc::Func">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 34,
 FQN="llvm::LibFunc::Func", NM="_ZN4llvm7LibFunc4FuncE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm7LibFunc4FuncE")
//</editor-fold>
public enum Func implements Native.NativeUIntEnum {
  
  /// void *new(unsigned int);
  msvc_new_int(0),
  
  /// void *new(unsigned int, nothrow);
  msvc_new_int_nothrow(msvc_new_int.getValue() + 1),
  
  /// void *new(unsigned long long);
  msvc_new_longlong(msvc_new_int_nothrow.getValue() + 1),
  
  /// void *new(unsigned long long, nothrow);
  msvc_new_longlong_nothrow(msvc_new_longlong.getValue() + 1),
  
  /// void operator delete(void*);
  msvc_delete_ptr32(msvc_new_longlong_nothrow.getValue() + 1),
  
  /// void operator delete(void*, nothrow);
  msvc_delete_ptr32_nothrow(msvc_delete_ptr32.getValue() + 1),
  
  /// void operator delete(void*, unsigned int);
  msvc_delete_ptr32_int(msvc_delete_ptr32_nothrow.getValue() + 1),
  
  /// void operator delete(void*);
  msvc_delete_ptr64(msvc_delete_ptr32_int.getValue() + 1),
  
  /// void operator delete(void*, nothrow);
  msvc_delete_ptr64_nothrow(msvc_delete_ptr64.getValue() + 1),
  
  /// void operator delete(void*, unsigned long long);
  msvc_delete_ptr64_longlong(msvc_delete_ptr64_nothrow.getValue() + 1),
  
  /// void *new[](unsigned int);
  msvc_new_array_int(msvc_delete_ptr64_longlong.getValue() + 1),
  
  /// void *new[](unsigned int, nothrow);
  msvc_new_array_int_nothrow(msvc_new_array_int.getValue() + 1),
  
  /// void *new[](unsigned long long);
  msvc_new_array_longlong(msvc_new_array_int_nothrow.getValue() + 1),
  
  /// void *new[](unsigned long long, nothrow);
  msvc_new_array_longlong_nothrow(msvc_new_array_longlong.getValue() + 1),
  
  /// void operator delete[](void*);
  msvc_delete_array_ptr32(msvc_new_array_longlong_nothrow.getValue() + 1),
  
  /// void operator delete[](void*, nothrow);
  msvc_delete_array_ptr32_nothrow(msvc_delete_array_ptr32.getValue() + 1),
  
  /// void operator delete[](void*, unsigned int);
  msvc_delete_array_ptr32_int(msvc_delete_array_ptr32_nothrow.getValue() + 1),
  
  /// void operator delete[](void*);
  msvc_delete_array_ptr64(msvc_delete_array_ptr32_int.getValue() + 1),
  
  /// void operator delete[](void*, nothrow);
  msvc_delete_array_ptr64_nothrow(msvc_delete_array_ptr64.getValue() + 1),
  
  /// void operator delete[](void*, unsigned long long);
  msvc_delete_array_ptr64_longlong(msvc_delete_array_ptr64_nothrow.getValue() + 1),
  
  /// int _IO_getc(_IO_FILE * __fp);
  under_IO_getc(msvc_delete_array_ptr64_longlong.getValue() + 1),
  /// int _IO_putc(int __c, _IO_FILE * __fp);
  under_IO_putc(under_IO_getc.getValue() + 1),
  /// void operator delete[](void*);
  ZdaPv(under_IO_putc.getValue() + 1),
  /// void operator delete[](void*, nothrow);
  ZdaPvRKSt9nothrow_t(ZdaPv.getValue() + 1),
  /// void operator delete[](void*, unsigned int);
  ZdaPvj(ZdaPvRKSt9nothrow_t.getValue() + 1),
  /// void operator delete[](void*, unsigned long);
  ZdaPvm(ZdaPvj.getValue() + 1),
  /// void operator delete(void*);
  ZdlPv(ZdaPvm.getValue() + 1),
  /// void operator delete(void*, nothrow);
  ZdlPvRKSt9nothrow_t(ZdlPv.getValue() + 1),
  /// void operator delete(void*, unsigned int);
  ZdlPvj(ZdlPvRKSt9nothrow_t.getValue() + 1),
  /// void operator delete(void*, unsigned long);
  ZdlPvm(ZdlPvj.getValue() + 1),
  /// void *new[](unsigned int);
  Znaj(ZdlPvm.getValue() + 1),
  /// void *new[](unsigned int, nothrow);
  ZnajRKSt9nothrow_t(Znaj.getValue() + 1),
  /// void *new[](unsigned long);
  Znam(ZnajRKSt9nothrow_t.getValue() + 1),
  /// void *new[](unsigned long, nothrow);
  ZnamRKSt9nothrow_t(Znam.getValue() + 1),
  /// void *new(unsigned int);
  Znwj(ZnamRKSt9nothrow_t.getValue() + 1),
  /// void *new(unsigned int, nothrow);
  ZnwjRKSt9nothrow_t(Znwj.getValue() + 1),
  /// void *new(unsigned long);
  Znwm(ZnwjRKSt9nothrow_t.getValue() + 1),
  /// void *new(unsigned long, nothrow);
  ZnwmRKSt9nothrow_t(Znwm.getValue() + 1),
  /// double __cospi(double x);
  cospi(ZnwmRKSt9nothrow_t.getValue() + 1),
  /// float __cospif(float x);
  cospif(cospi.getValue() + 1),
  /// int __cxa_atexit(void (*f)(void *), void *p, void *d);
  cxa_atexit(cospif.getValue() + 1),
  /// void __cxa_guard_abort(guard_t *guard);
  /// guard_t is int64_t in Itanium ABI or int32_t on ARM eabi.
  cxa_guard_abort(cxa_atexit.getValue() + 1),
  /// int __cxa_guard_acquire(guard_t *guard);
  cxa_guard_acquire(cxa_guard_abort.getValue() + 1),
  /// void __cxa_guard_release(guard_t *guard);
  cxa_guard_release(cxa_guard_acquire.getValue() + 1),
  /// int __isoc99_scanf (const char *format, ...)
  dunder_isoc99_scanf(cxa_guard_release.getValue() + 1),
  /// int __isoc99_sscanf(const char *s, const char *format, ...)
  dunder_isoc99_sscanf(dunder_isoc99_scanf.getValue() + 1),
  /// void *__memcpy_chk(void *s1, const void *s2, size_t n, size_t s1size);
  memcpy_chk(dunder_isoc99_sscanf.getValue() + 1),
  /// void *__memmove_chk(void *s1, const void *s2, size_t n, size_t s1size);
  memmove_chk(memcpy_chk.getValue() + 1),
  /// void *__memset_chk(void *s, char v, size_t n, size_t s1size);
  memset_chk(memmove_chk.getValue() + 1),
  
  // int __nvvm_reflect(const char *)
  nvvm_reflect(memset_chk.getValue() + 1),
  
  /// double __sincospi_stret(double x);
  sincospi_stret(nvvm_reflect.getValue() + 1),
  /// float __sincospif_stret(float x);
  sincospif_stret(sincospi_stret.getValue() + 1),
  /// double __sinpi(double x);
  sinpi(sincospif_stret.getValue() + 1),
  /// float __sinpif(float x);
  sinpif(sinpi.getValue() + 1),
  /// double __sqrt_finite(double x);
  sqrt_finite(sinpif.getValue() + 1),
  /// float __sqrt_finite(float x);
  sqrtf_finite(sqrt_finite.getValue() + 1),
  /// long double __sqrt_finite(long double x);
  sqrtl_finite(sqrtf_finite.getValue() + 1),
  /// char *__stpcpy_chk(char *s1, const char *s2, size_t s1size);
  stpcpy_chk(sqrtl_finite.getValue() + 1),
  /// char *__stpncpy_chk(char *s1, const char *s2, size_t n, size_t s1size);
  stpncpy_chk(stpcpy_chk.getValue() + 1),
  /// char *__strcpy_chk(char *s1, const char *s2, size_t s1size);
  strcpy_chk(stpncpy_chk.getValue() + 1),
  /// char * __strdup(const char *s);
  dunder_strdup(strcpy_chk.getValue() + 1),
  /// char *__strncpy_chk(char *s1, const char *s2, size_t n, size_t s1size);
  strncpy_chk(dunder_strdup.getValue() + 1),
  /// char *__strndup(const char *s, size_t n);
  dunder_strndup(strncpy_chk.getValue() + 1),
  /// char * __strtok_r(char *s, const char *delim, char **save_ptr);
  dunder_strtok_r(dunder_strndup.getValue() + 1),
  /// int abs(int j);
  abs(dunder_strtok_r.getValue() + 1),
  /// int access(const char *path, int amode);
  access(abs.getValue() + 1),
  /// double acos(double x);
  acos(access.getValue() + 1),
  /// float acosf(float x);
  acosf(acos.getValue() + 1),
  /// double acosh(double x);
  acosh(acosf.getValue() + 1),
  /// float acoshf(float x);
  acoshf(acosh.getValue() + 1),
  /// long double acoshl(long double x);
  acoshl(acoshf.getValue() + 1),
  /// long double acosl(long double x);
  acosl(acoshl.getValue() + 1),
  /// double asin(double x);
  asin(acosl.getValue() + 1),
  /// float asinf(float x);
  asinf(asin.getValue() + 1),
  /// double asinh(double x);
  asinh(asinf.getValue() + 1),
  /// float asinhf(float x);
  asinhf(asinh.getValue() + 1),
  /// long double asinhl(long double x);
  asinhl(asinhf.getValue() + 1),
  /// long double asinl(long double x);
  asinl(asinhl.getValue() + 1),
  /// double atan(double x);
  atan(asinl.getValue() + 1),
  /// double atan2(double y, double x);
  atan2(atan.getValue() + 1),
  /// float atan2f(float y, float x);
  atan2f(atan2.getValue() + 1),
  /// long double atan2l(long double y, long double x);
  atan2l(atan2f.getValue() + 1),
  /// float atanf(float x);
  atanf(atan2l.getValue() + 1),
  /// double atanh(double x);
  atanh(atanf.getValue() + 1),
  /// float atanhf(float x);
  atanhf(atanh.getValue() + 1),
  /// long double atanhl(long double x);
  atanhl(atanhf.getValue() + 1),
  /// long double atanl(long double x);
  atanl(atanhl.getValue() + 1),
  /// double atof(const char *str);
  atof(atanl.getValue() + 1),
  /// int atoi(const char *str);
  atoi(atof.getValue() + 1),
  /// long atol(const char *str);
  atol(atoi.getValue() + 1),
  /// long long atoll(const char *nptr);
  atoll(atol.getValue() + 1),
  /// int bcmp(const void *s1, const void *s2, size_t n);
  bcmp(atoll.getValue() + 1),
  /// void bcopy(const void *s1, void *s2, size_t n);
  bcopy(bcmp.getValue() + 1),
  /// void bzero(void *s, size_t n);
  bzero(bcopy.getValue() + 1),
  /// void *calloc(size_t count, size_t size);
  calloc(bzero.getValue() + 1),
  /// double cbrt(double x);
  cbrt(calloc.getValue() + 1),
  /// float cbrtf(float x);
  cbrtf(cbrt.getValue() + 1),
  /// long double cbrtl(long double x);
  cbrtl(cbrtf.getValue() + 1),
  /// double ceil(double x);
  ceil(cbrtl.getValue() + 1),
  /// float ceilf(float x);
  ceilf(ceil.getValue() + 1),
  /// long double ceill(long double x);
  ceill(ceilf.getValue() + 1),
  /// int chmod(const char *path, mode_t mode);
  chmod(ceill.getValue() + 1),
  /// int chown(const char *path, uid_t owner, gid_t group);
  chown(chmod.getValue() + 1),
  /// void clearerr(FILE *stream);
  clearerr(chown.getValue() + 1),
  /// int closedir(DIR *dirp);
  closedir(clearerr.getValue() + 1),
  /// double copysign(double x, double y);
  copysign(closedir.getValue() + 1),
  /// float copysignf(float x, float y);
  copysignf(copysign.getValue() + 1),
  /// long double copysignl(long double x, long double y);
  copysignl(copysignf.getValue() + 1),
  /// double cos(double x);
  cos(copysignl.getValue() + 1),
  /// float cosf(float x);
  cosf(cos.getValue() + 1),
  /// double cosh(double x);
  cosh(cosf.getValue() + 1),
  /// float coshf(float x);
  coshf(cosh.getValue() + 1),
  /// long double coshl(long double x);
  coshl(coshf.getValue() + 1),
  /// long double cosl(long double x);
  cosl(coshl.getValue() + 1),
  /// char *ctermid(char *s);
  ctermid(cosl.getValue() + 1),
  /// double exp(double x);
  exp(ctermid.getValue() + 1),
  /// double exp10(double x);
  exp10(exp.getValue() + 1),
  /// float exp10f(float x);
  exp10f(exp10.getValue() + 1),
  /// long double exp10l(long double x);
  exp10l(exp10f.getValue() + 1),
  /// double exp2(double x);
  exp2(exp10l.getValue() + 1),
  /// float exp2f(float x);
  exp2f(exp2.getValue() + 1),
  /// long double exp2l(long double x);
  exp2l(exp2f.getValue() + 1),
  /// float expf(float x);
  expf(exp2l.getValue() + 1),
  /// long double expl(long double x);
  expl(expf.getValue() + 1),
  /// double expm1(double x);
  expm1(expl.getValue() + 1),
  /// float expm1f(float x);
  expm1f(expm1.getValue() + 1),
  /// long double expm1l(long double x);
  expm1l(expm1f.getValue() + 1),
  /// double fabs(double x);
  fabs(expm1l.getValue() + 1),
  /// float fabsf(float x);
  fabsf(fabs.getValue() + 1),
  /// long double fabsl(long double x);
  fabsl(fabsf.getValue() + 1),
  /// int fclose(FILE *stream);
  fclose(fabsl.getValue() + 1),
  /// FILE *fdopen(int fildes, const char *mode);
  fdopen(fclose.getValue() + 1),
  /// int feof(FILE *stream);
  feof(fdopen.getValue() + 1),
  /// int ferror(FILE *stream);
  ferror(feof.getValue() + 1),
  /// int fflush(FILE *stream);
  fflush(ferror.getValue() + 1),
  /// int ffs(int i);
  ffs(fflush.getValue() + 1),
  /// int ffsl(long int i);
  ffsl(ffs.getValue() + 1),
  /// int ffsll(long long int i);
  ffsll(ffsl.getValue() + 1),
  /// int fgetc(FILE *stream);
  fgetc(ffsll.getValue() + 1),
  /// int fgetpos(FILE *stream, fpos_t *pos);
  fgetpos(fgetc.getValue() + 1),
  /// char *fgets(char *s, int n, FILE *stream);
  fgets(fgetpos.getValue() + 1),
  /// int fileno(FILE *stream);
  fileno(fgets.getValue() + 1),
  /// int fiprintf(FILE *stream, const char *format, ...);
  fiprintf(fileno.getValue() + 1),
  /// void flockfile(FILE *file);
  flockfile(fiprintf.getValue() + 1),
  /// double floor(double x);
  floor(flockfile.getValue() + 1),
  /// float floorf(float x);
  floorf(floor.getValue() + 1),
  /// long double floorl(long double x);
  floorl(floorf.getValue() + 1),
  /// int fls(int i);
  fls(floorl.getValue() + 1),
  /// int flsl(long int i);
  flsl(fls.getValue() + 1),
  /// int flsll(long long int i);
  flsll(flsl.getValue() + 1),
  /// double fmax(double x, double y);
  fmax(flsll.getValue() + 1),
  /// float fmaxf(float x, float y);
  fmaxf(fmax.getValue() + 1),
  /// long double fmaxl(long double x, long double y);
  fmaxl(fmaxf.getValue() + 1),
  /// double fmin(double x, double y);
  fmin(fmaxl.getValue() + 1),
  /// float fminf(float x, float y);
  fminf(fmin.getValue() + 1),
  /// long double fminl(long double x, long double y);
  fminl(fminf.getValue() + 1),
  /// double fmod(double x, double y);
  fmod(fminl.getValue() + 1),
  /// float fmodf(float x, float y);
  fmodf(fmod.getValue() + 1),
  /// long double fmodl(long double x, long double y);
  fmodl(fmodf.getValue() + 1),
  /// FILE *fopen(const char *filename, const char *mode);
  fopen(fmodl.getValue() + 1),
  /// FILE *fopen64(const char *filename, const char *opentype)
  fopen64(fopen.getValue() + 1),
  /// int fprintf(FILE *stream, const char *format, ...);
  fprintf(fopen64.getValue() + 1),
  /// int fputc(int c, FILE *stream);
  fputc(fprintf.getValue() + 1),
  /// int fputs(const char *s, FILE *stream);
  fputs(fputc.getValue() + 1),
  /// size_t fread(void *ptr, size_t size, size_t nitems, FILE *stream);
  fread(fputs.getValue() + 1),
  /// void free(void *ptr);
  free(fread.getValue() + 1),
  /// double frexp(double num, int *exp);
  frexp(free.getValue() + 1),
  /// float frexpf(float num, int *exp);
  frexpf(frexp.getValue() + 1),
  /// long double frexpl(long double num, int *exp);
  frexpl(frexpf.getValue() + 1),
  /// int fscanf(FILE *stream, const char *format, ... );
  fscanf(frexpl.getValue() + 1),
  /// int fseek(FILE *stream, long offset, int whence);
  fseek(fscanf.getValue() + 1),
  /// int fseeko(FILE *stream, off_t offset, int whence);
  fseeko(fseek.getValue() + 1),
  /// int fseeko64(FILE *stream, off64_t offset, int whence)
  fseeko64(fseeko.getValue() + 1),
  /// int fsetpos(FILE *stream, const fpos_t *pos);
  fsetpos(fseeko64.getValue() + 1),
  /// int fstat(int fildes, struct stat *buf);
  fstat(fsetpos.getValue() + 1),
  /// int fstat64(int filedes, struct stat64 *buf)
  fstat64(fstat.getValue() + 1),
  /// int fstatvfs(int fildes, struct statvfs *buf);
  fstatvfs(fstat64.getValue() + 1),
  /// int fstatvfs64(int fildes, struct statvfs64 *buf);
  fstatvfs64(fstatvfs.getValue() + 1),
  /// long ftell(FILE *stream);
  ftell(fstatvfs64.getValue() + 1),
  /// off_t ftello(FILE *stream);
  ftello(ftell.getValue() + 1),
  /// off64_t ftello64(FILE *stream)
  ftello64(ftello.getValue() + 1),
  /// int ftrylockfile(FILE *file);
  ftrylockfile(ftello64.getValue() + 1),
  /// void funlockfile(FILE *file);
  funlockfile(ftrylockfile.getValue() + 1),
  /// size_t fwrite(const void *ptr, size_t size, size_t nitems, FILE *stream);
  fwrite(funlockfile.getValue() + 1),
  /// int getc(FILE *stream);
  getc(fwrite.getValue() + 1),
  /// int getc_unlocked(FILE *stream);
  getc_unlocked(getc.getValue() + 1),
  /// int getchar(void);
  getchar(getc_unlocked.getValue() + 1),
  /// char *getenv(const char *name);
  getenv(getchar.getValue() + 1),
  /// int getitimer(int which, struct itimerval *value);
  getitimer(getenv.getValue() + 1),
  /// int getlogin_r(char *name, size_t namesize);
  getlogin_r(getitimer.getValue() + 1),
  /// struct passwd *getpwnam(const char *name);
  getpwnam(getlogin_r.getValue() + 1),
  /// char *gets(char *s);
  gets(getpwnam.getValue() + 1),
  /// int gettimeofday(struct timeval *tp, void *tzp);
  gettimeofday(gets.getValue() + 1),
  /// uint32_t htonl(uint32_t hostlong);
  htonl(gettimeofday.getValue() + 1),
  /// uint16_t htons(uint16_t hostshort);
  htons(htonl.getValue() + 1),
  /// int iprintf(const char *format, ...);
  iprintf(htons.getValue() + 1),
  /// int isascii(int c);
  isascii(iprintf.getValue() + 1),
  /// int isdigit(int c);
  isdigit(isascii.getValue() + 1),
  /// long int labs(long int j);
  labs(isdigit.getValue() + 1),
  /// int lchown(const char *path, uid_t owner, gid_t group);
  lchown(labs.getValue() + 1),
  /// double ldexp(double x, int n);
  ldexp(lchown.getValue() + 1),
  /// float ldexpf(float x, int n);
  ldexpf(ldexp.getValue() + 1),
  /// long double ldexpl(long double x, int n);
  ldexpl(ldexpf.getValue() + 1),
  /// long long int llabs(long long int j);
  llabs(ldexpl.getValue() + 1),
  /// double log(double x);
  log(llabs.getValue() + 1),
  /// double log10(double x);
  log10(log.getValue() + 1),
  /// float log10f(float x);
  log10f(log10.getValue() + 1),
  /// long double log10l(long double x);
  log10l(log10f.getValue() + 1),
  /// double log1p(double x);
  log1p(log10l.getValue() + 1),
  /// float log1pf(float x);
  log1pf(log1p.getValue() + 1),
  /// long double log1pl(long double x);
  log1pl(log1pf.getValue() + 1),
  /// double log2(double x);
  log2(log1pl.getValue() + 1),
  /// float log2f(float x);
  log2f(log2.getValue() + 1),
  /// double long double log2l(long double x);
  log2l(log2f.getValue() + 1),
  /// double logb(double x);
  logb(log2l.getValue() + 1),
  /// float logbf(float x);
  logbf(logb.getValue() + 1),
  /// long double logbl(long double x);
  logbl(logbf.getValue() + 1),
  /// float logf(float x);
  logf(logbl.getValue() + 1),
  /// long double logl(long double x);
  logl(logf.getValue() + 1),
  /// int lstat(const char *path, struct stat *buf);
  lstat(logl.getValue() + 1),
  /// int lstat64(const char *path, struct stat64 *buf);
  lstat64(lstat.getValue() + 1),
  /// void *malloc(size_t size);
  malloc(lstat64.getValue() + 1),
  /// void *memalign(size_t boundary, size_t size);
  memalign(malloc.getValue() + 1),
  /// void *memccpy(void *s1, const void *s2, int c, size_t n);
  memccpy(memalign.getValue() + 1),
  /// void *memchr(const void *s, int c, size_t n);
  memchr(memccpy.getValue() + 1),
  /// int memcmp(const void *s1, const void *s2, size_t n);
  memcmp(memchr.getValue() + 1),
  /// void *memcpy(void *s1, const void *s2, size_t n);
  memcpy(memcmp.getValue() + 1),
  /// void *memmove(void *s1, const void *s2, size_t n);
  memmove(memcpy.getValue() + 1),
  // void *memrchr(const void *s, int c, size_t n);
  memrchr(memmove.getValue() + 1),
  /// void *memset(void *b, int c, size_t len);
  memset(memrchr.getValue() + 1),
  /// void memset_pattern16(void *b, const void *pattern16, size_t len);
  memset_pattern16(memset.getValue() + 1),
  /// int mkdir(const char *path, mode_t mode);
  mkdir(memset_pattern16.getValue() + 1),
  /// time_t mktime(struct tm *timeptr);
  mktime(mkdir.getValue() + 1),
  /// double modf(double x, double *iptr);
  modf(mktime.getValue() + 1),
  /// float modff(float, float *iptr);
  modff(modf.getValue() + 1),
  /// long double modfl(long double value, long double *iptr);
  modfl(modff.getValue() + 1),
  
  /// double nearbyint(double x);
  nearbyint(modfl.getValue() + 1),
  /// float nearbyintf(float x);
  nearbyintf(nearbyint.getValue() + 1),
  /// long double nearbyintl(long double x);
  nearbyintl(nearbyintf.getValue() + 1),
  /// uint32_t ntohl(uint32_t netlong);
  ntohl(nearbyintl.getValue() + 1),
  /// uint16_t ntohs(uint16_t netshort);
  ntohs(ntohl.getValue() + 1),
  /// int open(const char *path, int oflag, ... );
  open(ntohs.getValue() + 1),
  /// int open64(const char *filename, int flags[, mode_t mode])
  open64(open.getValue() + 1),
  /// DIR *opendir(const char *dirname);
  opendir(open64.getValue() + 1),
  /// int pclose(FILE *stream);
  pclose(opendir.getValue() + 1),
  /// void perror(const char *s);
  perror(pclose.getValue() + 1),
  /// FILE *popen(const char *command, const char *mode);
  popen(perror.getValue() + 1),
  /// int posix_memalign(void **memptr, size_t alignment, size_t size);
  posix_memalign(popen.getValue() + 1),
  /// double pow(double x, double y);
  pow(posix_memalign.getValue() + 1),
  /// float powf(float x, float y);
  powf(pow.getValue() + 1),
  /// long double powl(long double x, long double y);
  powl(powf.getValue() + 1),
  /// ssize_t pread(int fildes, void *buf, size_t nbyte, off_t offset);
  pread(powl.getValue() + 1),
  /// int printf(const char *format, ...);
  printf(pread.getValue() + 1),
  /// int putc(int c, FILE *stream);
  putc(printf.getValue() + 1),
  /// int putchar(int c);
  putchar(putc.getValue() + 1),
  /// int puts(const char *s);
  puts(putchar.getValue() + 1),
  /// ssize_t pwrite(int fildes, const void *buf, size_t nbyte, off_t offset);
  pwrite(puts.getValue() + 1),
  /// void qsort(void *base, size_t nel, size_t width,
  ///            int (*compar)(const void *, const void *));
  qsort(pwrite.getValue() + 1),
  /// ssize_t read(int fildes, void *buf, size_t nbyte);
  read(qsort.getValue() + 1),
  /// ssize_t readlink(const char *path, char *buf, size_t bufsize);
  readlink(read.getValue() + 1),
  /// void *realloc(void *ptr, size_t size);
  realloc(readlink.getValue() + 1),
  /// void *reallocf(void *ptr, size_t size);
  reallocf(realloc.getValue() + 1),
  /// char *realpath(const char *file_name, char *resolved_name);
  realpath(reallocf.getValue() + 1),
  /// int remove(const char *path);
  remove(realpath.getValue() + 1),
  /// int rename(const char *old, const char *new);
  rename(remove.getValue() + 1),
  /// void rewind(FILE *stream);
  rewind(rename.getValue() + 1),
  /// double rint(double x);
  rint(rewind.getValue() + 1),
  /// float rintf(float x);
  rintf(rint.getValue() + 1),
  /// long double rintl(long double x);
  rintl(rintf.getValue() + 1),
  /// int rmdir(const char *path);
  rmdir(rintl.getValue() + 1),
  /// double round(double x);
  round(rmdir.getValue() + 1),
  /// float roundf(float x);
  roundf(round.getValue() + 1),
  /// long double roundl(long double x);
  roundl(roundf.getValue() + 1),
  /// int scanf(const char *restrict format, ... );
  scanf(roundl.getValue() + 1),
  /// void setbuf(FILE *stream, char *buf);
  setbuf(scanf.getValue() + 1),
  /// int setitimer(int which, const struct itimerval *value,
  ///               struct itimerval *ovalue);
  setitimer(setbuf.getValue() + 1),
  /// int setvbuf(FILE *stream, char *buf, int type, size_t size);
  setvbuf(setitimer.getValue() + 1),
  /// double sin(double x);
  sin(setvbuf.getValue() + 1),
  /// float sinf(float x);
  sinf(sin.getValue() + 1),
  /// double sinh(double x);
  sinh(sinf.getValue() + 1),
  /// float sinhf(float x);
  sinhf(sinh.getValue() + 1),
  /// long double sinhl(long double x);
  sinhl(sinhf.getValue() + 1),
  /// long double sinl(long double x);
  sinl(sinhl.getValue() + 1),
  /// int siprintf(char *str, const char *format, ...);
  siprintf(sinl.getValue() + 1),
  /// int snprintf(char *s, size_t n, const char *format, ...);
  snprintf(siprintf.getValue() + 1),
  /// int sprintf(char *str, const char *format, ...);
  sprintf(snprintf.getValue() + 1),
  /// double sqrt(double x);
  sqrt(sprintf.getValue() + 1),
  /// float sqrtf(float x);
  sqrtf(sqrt.getValue() + 1),
  /// long double sqrtl(long double x);
  sqrtl(sqrtf.getValue() + 1),
  /// int sscanf(const char *s, const char *format, ... );
  sscanf(sqrtl.getValue() + 1),
  /// int stat(const char *path, struct stat *buf);
  stat(sscanf.getValue() + 1),
  /// int stat64(const char *path, struct stat64 *buf);
  stat64(stat.getValue() + 1),
  /// int statvfs(const char *path, struct statvfs *buf);
  statvfs(stat64.getValue() + 1),
  /// int statvfs64(const char *path, struct statvfs64 *buf)
  statvfs64(statvfs.getValue() + 1),
  /// char *stpcpy(char *s1, const char *s2);
  stpcpy(statvfs64.getValue() + 1),
  /// char *stpncpy(char *s1, const char *s2, size_t n);
  stpncpy(stpcpy.getValue() + 1),
  /// int strcasecmp(const char *s1, const char *s2);
  strcasecmp(stpncpy.getValue() + 1),
  /// char *strcat(char *s1, const char *s2);
  strcat(strcasecmp.getValue() + 1),
  /// char *strchr(const char *s, int c);
  strchr(strcat.getValue() + 1),
  /// int strcmp(const char *s1, const char *s2);
  strcmp(strchr.getValue() + 1),
  /// int strcoll(const char *s1, const char *s2);
  strcoll(strcmp.getValue() + 1),
  /// char *strcpy(char *s1, const char *s2);
  strcpy(strcoll.getValue() + 1),
  /// size_t strcspn(const char *s1, const char *s2);
  strcspn(strcpy.getValue() + 1),
  /// char *strdup(const char *s1);
  strdup(strcspn.getValue() + 1),
  /// size_t strlen(const char *s);
  strlen(strdup.getValue() + 1),
  /// int strncasecmp(const char *s1, const char *s2, size_t n);
  strncasecmp(strlen.getValue() + 1),
  /// char *strncat(char *s1, const char *s2, size_t n);
  strncat(strncasecmp.getValue() + 1),
  /// int strncmp(const char *s1, const char *s2, size_t n);
  strncmp(strncat.getValue() + 1),
  /// char *strncpy(char *s1, const char *s2, size_t n);
  strncpy(strncmp.getValue() + 1),
  /// char *strndup(const char *s1, size_t n);
  strndup(strncpy.getValue() + 1),
  /// size_t strnlen(const char *s, size_t maxlen);
  strnlen(strndup.getValue() + 1),
  /// char *strpbrk(const char *s1, const char *s2);
  strpbrk(strnlen.getValue() + 1),
  /// char *strrchr(const char *s, int c);
  strrchr(strpbrk.getValue() + 1),
  /// size_t strspn(const char *s1, const char *s2);
  strspn(strrchr.getValue() + 1),
  /// char *strstr(const char *s1, const char *s2);
  strstr(strspn.getValue() + 1),
  /// double strtod(const char *nptr, char **endptr);
  strtod(strstr.getValue() + 1),
  /// float strtof(const char *nptr, char **endptr);
  strtof(strtod.getValue() + 1),
  // char *strtok(char *s1, const char *s2);
  strtok(strtof.getValue() + 1),
  // char *strtok_r(char *s, const char *sep, char **lasts);
  strtok_r(strtok.getValue() + 1),
  /// long int strtol(const char *nptr, char **endptr, int base);
  strtol(strtok_r.getValue() + 1),
  /// long double strtold(const char *nptr, char **endptr);
  strtold(strtol.getValue() + 1),
  /// long long int strtoll(const char *nptr, char **endptr, int base);
  strtoll(strtold.getValue() + 1),
  /// unsigned long int strtoul(const char *nptr, char **endptr, int base);
  strtoul(strtoll.getValue() + 1),
  /// unsigned long long int strtoull(const char *nptr, char **endptr, int base);
  strtoull(strtoul.getValue() + 1),
  /// size_t strxfrm(char *s1, const char *s2, size_t n);
  strxfrm(strtoull.getValue() + 1),
  /// int system(const char *command);
  system(strxfrm.getValue() + 1),
  /// double tan(double x);
  tan(system.getValue() + 1),
  /// float tanf(float x);
  tanf(tan.getValue() + 1),
  /// double tanh(double x);
  tanh(tanf.getValue() + 1),
  /// float tanhf(float x);
  tanhf(tanh.getValue() + 1),
  /// long double tanhl(long double x);
  tanhl(tanhf.getValue() + 1),
  /// long double tanl(long double x);
  tanl(tanhl.getValue() + 1),
  /// clock_t times(struct tms *buffer);
  times(tanl.getValue() + 1),
  /// FILE *tmpfile(void);
  tmpfile(times.getValue() + 1),
  /// FILE *tmpfile64(void)
  tmpfile64(tmpfile.getValue() + 1),
  /// int toascii(int c);
  toascii(tmpfile64.getValue() + 1),
  /// double trunc(double x);
  trunc(toascii.getValue() + 1),
  /// float truncf(float x);
  truncf(trunc.getValue() + 1),
  /// long double truncl(long double x);
  truncl(truncf.getValue() + 1),
  /// int uname(struct utsname *name);
  uname(truncl.getValue() + 1),
  /// int ungetc(int c, FILE *stream);
  ungetc(uname.getValue() + 1),
  /// int unlink(const char *path);
  unlink(ungetc.getValue() + 1),
  /// int unsetenv(const char *name);
  unsetenv(unlink.getValue() + 1),
  /// int utime(const char *path, const struct utimbuf *times);
  utime(unsetenv.getValue() + 1),
  /// int utimes(const char *path, const struct timeval times[2]);
  utimes(utime.getValue() + 1),
  /// void *valloc(size_t size);
  valloc(utimes.getValue() + 1),
  /// int vfprintf(FILE *stream, const char *format, va_list ap);
  vfprintf(valloc.getValue() + 1),
  /// int vfscanf(FILE *stream, const char *format, va_list arg);
  vfscanf(vfprintf.getValue() + 1),
  /// int vprintf(const char *restrict format, va_list ap);
  vprintf(vfscanf.getValue() + 1),
  /// int vscanf(const char *format, va_list arg);
  vscanf(vprintf.getValue() + 1),
  /// int vsnprintf(char *s, size_t n, const char *format, va_list ap);
  vsnprintf(vscanf.getValue() + 1),
  /// int vsprintf(char *s, const char *format, va_list ap);
  vsprintf(vsnprintf.getValue() + 1),
  /// int vsscanf(const char *s, const char *format, va_list arg);
  vsscanf(vsprintf.getValue() + 1),
  /// ssize_t write(int fildes, const void *buf, size_t nbyte);
  write(vsscanf.getValue() + 1),
  
  NumLibFuncs(write.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Func valueOf(int val) {
    Func out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Func[] VALUES;
    private static final Func[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Func kind : Func.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Func[min < 0 ? (1-min) : 0];
      VALUES = new Func[max >= 0 ? (1+max) : 0];
      for (Func kind : Func.values()) {
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
  private Func(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
