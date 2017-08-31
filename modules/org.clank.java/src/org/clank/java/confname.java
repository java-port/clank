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

package org.clank.java;

/**
 *
 * @author petrk
 */
public final class confname {
  
  // confname.h
  private confname() {
    throw new AssertionError();
  }
  
  /* Values for the NAME argument to `pathconf' and `fpathconf'.  */
//public final class/*enum*/ {
  public static final int _PC_LINK_MAX = 0;
  public static final int _PC_MAX_CANON = _PC_LINK_MAX + 1;
  public static final int _PC_MAX_INPUT = _PC_MAX_CANON + 1;
  public static final int _PC_NAME_MAX = _PC_MAX_INPUT + 1;
  public static final int _PC_PATH_MAX = _PC_NAME_MAX + 1;
  public static final int _PC_PIPE_BUF = _PC_PATH_MAX + 1;
  public static final int _PC_CHOWN_RESTRICTED = _PC_PIPE_BUF + 1;
  public static final int _PC_NO_TRUNC = _PC_CHOWN_RESTRICTED + 1;
  public static final int _PC_VDISABLE = _PC_NO_TRUNC + 1;
  public static final int _PC_SYNC_IO = _PC_VDISABLE + 1;
  public static final int _PC_ASYNC_IO = _PC_SYNC_IO + 1;
  public static final int _PC_PRIO_IO = _PC_ASYNC_IO + 1;
  public static final int _PC_SOCK_MAXBUF = _PC_PRIO_IO + 1;
  public static final int _PC_FILESIZEBITS = _PC_SOCK_MAXBUF + 1;
  public static final int _PC_REC_INCR_XFER_SIZE = _PC_FILESIZEBITS + 1;
  public static final int _PC_REC_MAX_XFER_SIZE = _PC_REC_INCR_XFER_SIZE + 1;
  public static final int _PC_REC_MIN_XFER_SIZE = _PC_REC_MAX_XFER_SIZE + 1;
  public static final int _PC_REC_XFER_ALIGN = _PC_REC_MIN_XFER_SIZE + 1;
  public static final int _PC_ALLOC_SIZE_MIN = _PC_REC_XFER_ALIGN + 1;
  public static final int _PC_SYMLINK_MAX = _PC_ALLOC_SIZE_MIN + 1;
  public static final int _PC_2_SYMLINKS = _PC_SYMLINK_MAX + 1;
//}

/* Values for the argument to `sysconf'.  */
//public final class/*enum*/ {
  public static final int _SC_ARG_MAX = 0;
  public static final int _SC_CHILD_MAX = _SC_ARG_MAX + 1;
  public static final int _SC_CLK_TCK = _SC_CHILD_MAX + 1;
  public static final int _SC_NGROUPS_MAX = _SC_CLK_TCK + 1;
  public static final int _SC_OPEN_MAX = _SC_NGROUPS_MAX + 1;
  public static final int _SC_STREAM_MAX = _SC_OPEN_MAX + 1;
  public static final int _SC_TZNAME_MAX = _SC_STREAM_MAX + 1;
  public static final int _SC_JOB_CONTROL = _SC_TZNAME_MAX + 1;
  public static final int _SC_SAVED_IDS = _SC_JOB_CONTROL + 1;
  public static final int _SC_REALTIME_SIGNALS = _SC_SAVED_IDS + 1;
  public static final int _SC_PRIORITY_SCHEDULING = _SC_REALTIME_SIGNALS + 1;
  public static final int _SC_TIMERS = _SC_PRIORITY_SCHEDULING + 1;
  public static final int _SC_ASYNCHRONOUS_IO = _SC_TIMERS + 1;
  public static final int _SC_PRIORITIZED_IO = _SC_ASYNCHRONOUS_IO + 1;
  public static final int _SC_SYNCHRONIZED_IO = _SC_PRIORITIZED_IO + 1;
  public static final int _SC_FSYNC = _SC_SYNCHRONIZED_IO + 1;
  public static final int _SC_MAPPED_FILES = _SC_FSYNC + 1;
  public static final int _SC_MEMLOCK = _SC_MAPPED_FILES + 1;
  public static final int _SC_MEMLOCK_RANGE = _SC_MEMLOCK + 1;
  public static final int _SC_MEMORY_PROTECTION = _SC_MEMLOCK_RANGE + 1;
  public static final int _SC_MESSAGE_PASSING = _SC_MEMORY_PROTECTION + 1;
  public static final int _SC_SEMAPHORES = _SC_MESSAGE_PASSING + 1;
  public static final int _SC_SHARED_MEMORY_OBJECTS = _SC_SEMAPHORES + 1;
  public static final int _SC_AIO_LISTIO_MAX = _SC_SHARED_MEMORY_OBJECTS + 1;
  public static final int _SC_AIO_MAX = _SC_AIO_LISTIO_MAX + 1;
  public static final int _SC_AIO_PRIO_DELTA_MAX = _SC_AIO_MAX + 1;
  public static final int _SC_DELAYTIMER_MAX = _SC_AIO_PRIO_DELTA_MAX + 1;
  public static final int _SC_MQ_OPEN_MAX = _SC_DELAYTIMER_MAX + 1;
  public static final int _SC_MQ_PRIO_MAX = _SC_MQ_OPEN_MAX + 1;
  public static final int _SC_VERSION = _SC_MQ_PRIO_MAX + 1;
  public static final int _SC_PAGESIZE = _SC_VERSION + 1;
  public static final int _SC_RTSIG_MAX = _SC_PAGESIZE + 1;
  public static final int _SC_SEM_NSEMS_MAX = _SC_RTSIG_MAX + 1;
  public static final int _SC_SEM_VALUE_MAX = _SC_SEM_NSEMS_MAX + 1;
  public static final int _SC_SIGQUEUE_MAX = _SC_SEM_VALUE_MAX + 1;
  public static final int _SC_TIMER_MAX = _SC_SIGQUEUE_MAX + 1;
  
  /* Values for the argument to `sysconf'
  corresponding to _POSIX2_* symbols.  */
  public static final int _SC_BC_BASE_MAX = _SC_TIMER_MAX + 1;
  public static final int _SC_BC_DIM_MAX = _SC_BC_BASE_MAX + 1;
  public static final int _SC_BC_SCALE_MAX = _SC_BC_DIM_MAX + 1;
  public static final int _SC_BC_STRING_MAX = _SC_BC_SCALE_MAX + 1;
  public static final int _SC_COLL_WEIGHTS_MAX = _SC_BC_STRING_MAX + 1;
  public static final int _SC_EQUIV_CLASS_MAX = _SC_COLL_WEIGHTS_MAX + 1;
  public static final int _SC_EXPR_NEST_MAX = _SC_EQUIV_CLASS_MAX + 1;
  public static final int _SC_LINE_MAX = _SC_EXPR_NEST_MAX + 1;
  public static final int _SC_RE_DUP_MAX = _SC_LINE_MAX + 1;
  public static final int _SC_CHARCLASS_NAME_MAX = _SC_RE_DUP_MAX + 1;
  
  public static final int _SC_2_VERSION = _SC_CHARCLASS_NAME_MAX + 1;
  public static final int _SC_2_C_BIND = _SC_2_VERSION + 1;
  public static final int _SC_2_C_DEV = _SC_2_C_BIND + 1;
  public static final int _SC_2_FORT_DEV = _SC_2_C_DEV + 1;
  public static final int _SC_2_FORT_RUN = _SC_2_FORT_DEV + 1;
  public static final int _SC_2_SW_DEV = _SC_2_FORT_RUN + 1;
  public static final int _SC_2_LOCALEDEF = _SC_2_SW_DEV + 1;
  
  public static final int _SC_PII = _SC_2_LOCALEDEF + 1;
  public static final int _SC_PII_XTI = _SC_PII + 1;
  public static final int _SC_PII_SOCKET = _SC_PII_XTI + 1;
  public static final int _SC_PII_INTERNET = _SC_PII_SOCKET + 1;
  public static final int _SC_PII_OSI = _SC_PII_INTERNET + 1;
  public static final int _SC_POLL = _SC_PII_OSI + 1;
  public static final int _SC_SELECT = _SC_POLL + 1;
  public static final int _SC_UIO_MAXIOV = _SC_SELECT + 1;
  public static final int _SC_IOV_MAX = _SC_UIO_MAXIOV;
  public static final int _SC_PII_INTERNET_STREAM = _SC_IOV_MAX + 1;
  public static final int _SC_PII_INTERNET_DGRAM = _SC_PII_INTERNET_STREAM + 1;
  public static final int _SC_PII_OSI_COTS = _SC_PII_INTERNET_DGRAM + 1;
  public static final int _SC_PII_OSI_CLTS = _SC_PII_OSI_COTS + 1;
  public static final int _SC_PII_OSI_M = _SC_PII_OSI_CLTS + 1;
  public static final int _SC_T_IOV_MAX = _SC_PII_OSI_M + 1;
  
  /* Values according to POSIX 1003.1c (POSIX threads).  */
  public static final int _SC_THREADS = _SC_T_IOV_MAX + 1;
  public static final int _SC_THREAD_SAFE_FUNCTIONS = _SC_THREADS + 1;
  public static final int _SC_GETGR_R_SIZE_MAX = _SC_THREAD_SAFE_FUNCTIONS + 1;
  public static final int _SC_GETPW_R_SIZE_MAX = _SC_GETGR_R_SIZE_MAX + 1;
  public static final int _SC_LOGIN_NAME_MAX = _SC_GETPW_R_SIZE_MAX + 1;
  public static final int _SC_TTY_NAME_MAX = _SC_LOGIN_NAME_MAX + 1;
  public static final int _SC_THREAD_DESTRUCTOR_ITERATIONS = _SC_TTY_NAME_MAX + 1;
  public static final int _SC_THREAD_KEYS_MAX = _SC_THREAD_DESTRUCTOR_ITERATIONS + 1;
  public static final int _SC_THREAD_STACK_MIN = _SC_THREAD_KEYS_MAX + 1;
  public static final int _SC_THREAD_THREADS_MAX = _SC_THREAD_STACK_MIN + 1;
  public static final int _SC_THREAD_ATTR_STACKADDR = _SC_THREAD_THREADS_MAX + 1;
  public static final int _SC_THREAD_ATTR_STACKSIZE = _SC_THREAD_ATTR_STACKADDR + 1;
  public static final int _SC_THREAD_PRIORITY_SCHEDULING = _SC_THREAD_ATTR_STACKSIZE + 1;
  public static final int _SC_THREAD_PRIO_INHERIT = _SC_THREAD_PRIORITY_SCHEDULING + 1;
  public static final int _SC_THREAD_PRIO_PROTECT = _SC_THREAD_PRIO_INHERIT + 1;
  public static final int _SC_THREAD_PROCESS_SHARED = _SC_THREAD_PRIO_PROTECT + 1;
  
  public static final int _SC_NPROCESSORS_CONF = _SC_THREAD_PROCESS_SHARED + 1;
  public static final int _SC_NPROCESSORS_ONLN = _SC_NPROCESSORS_CONF + 1;
  public static final int _SC_PHYS_PAGES = _SC_NPROCESSORS_ONLN + 1;
  public static final int _SC_AVPHYS_PAGES = _SC_PHYS_PAGES + 1;
  public static final int _SC_ATEXIT_MAX = _SC_AVPHYS_PAGES + 1;
  public static final int _SC_PASS_MAX = _SC_ATEXIT_MAX + 1;
  
  public static final int _SC_XOPEN_VERSION = _SC_PASS_MAX + 1;
  public static final int _SC_XOPEN_XCU_VERSION = _SC_XOPEN_VERSION + 1;
  public static final int _SC_XOPEN_UNIX = _SC_XOPEN_XCU_VERSION + 1;
  public static final int _SC_XOPEN_CRYPT = _SC_XOPEN_UNIX + 1;
  public static final int _SC_XOPEN_ENH_I18N = _SC_XOPEN_CRYPT + 1;
  public static final int _SC_XOPEN_SHM = _SC_XOPEN_ENH_I18N + 1;
  
  public static final int _SC_2_CHAR_TERM = _SC_XOPEN_SHM + 1;
  public static final int _SC_2_C_VERSION = _SC_2_CHAR_TERM + 1;
  public static final int _SC_2_UPE = _SC_2_C_VERSION + 1;
  
  public static final int _SC_XOPEN_XPG2 = _SC_2_UPE + 1;
  public static final int _SC_XOPEN_XPG3 = _SC_XOPEN_XPG2 + 1;
  public static final int _SC_XOPEN_XPG4 = _SC_XOPEN_XPG3 + 1;
  
  public static final int _SC_CHAR_BIT = _SC_XOPEN_XPG4 + 1;
  public static final int _SC_CHAR_MAX = _SC_CHAR_BIT + 1;
  public static final int _SC_CHAR_MIN = _SC_CHAR_MAX + 1;
  public static final int _SC_INT_MAX = _SC_CHAR_MIN + 1;
  public static final int _SC_INT_MIN = _SC_INT_MAX + 1;
  public static final int _SC_LONG_BIT = _SC_INT_MIN + 1;
  public static final int _SC_WORD_BIT = _SC_LONG_BIT + 1;
  public static final int _SC_MB_LEN_MAX = _SC_WORD_BIT + 1;
  public static final int _SC_NZERO = _SC_MB_LEN_MAX + 1;
  public static final int _SC_SSIZE_MAX = _SC_NZERO + 1;
  public static final int _SC_SCHAR_MAX = _SC_SSIZE_MAX + 1;
  public static final int _SC_SCHAR_MIN = _SC_SCHAR_MAX + 1;
  public static final int _SC_SHRT_MAX = _SC_SCHAR_MIN + 1;
  public static final int _SC_SHRT_MIN = _SC_SHRT_MAX + 1;
  public static final int _SC_UCHAR_MAX = _SC_SHRT_MIN + 1;
  public static final int _SC_UINT_MAX = _SC_UCHAR_MAX + 1;
  public static final int _SC_ULONG_MAX = _SC_UINT_MAX + 1;
  public static final int _SC_USHRT_MAX = _SC_ULONG_MAX + 1;
  
  public static final int _SC_NL_ARGMAX = _SC_USHRT_MAX + 1;
  public static final int _SC_NL_LANGMAX = _SC_NL_ARGMAX + 1;
  public static final int _SC_NL_MSGMAX = _SC_NL_LANGMAX + 1;
  public static final int _SC_NL_NMAX = _SC_NL_MSGMAX + 1;
  public static final int _SC_NL_SETMAX = _SC_NL_NMAX + 1;
  public static final int _SC_NL_TEXTMAX = _SC_NL_SETMAX + 1;
  
  public static final int _SC_XBS5_ILP32_OFF32 = _SC_NL_TEXTMAX + 1;
  public static final int _SC_XBS5_ILP32_OFFBIG = _SC_XBS5_ILP32_OFF32 + 1;
  public static final int _SC_XBS5_LP64_OFF64 = _SC_XBS5_ILP32_OFFBIG + 1;
  public static final int _SC_XBS5_LPBIG_OFFBIG = _SC_XBS5_LP64_OFF64 + 1;
  
  public static final int _SC_XOPEN_LEGACY = _SC_XBS5_LPBIG_OFFBIG + 1;
  public static final int _SC_XOPEN_REALTIME = _SC_XOPEN_LEGACY + 1;
  public static final int _SC_XOPEN_REALTIME_THREADS = _SC_XOPEN_REALTIME + 1;
  
  public static final int _SC_ADVISORY_INFO = _SC_XOPEN_REALTIME_THREADS + 1;
  public static final int _SC_BARRIERS = _SC_ADVISORY_INFO + 1;
  public static final int _SC_BASE = _SC_BARRIERS + 1;
  public static final int _SC_C_LANG_SUPPORT = _SC_BASE + 1;
  public static final int _SC_C_LANG_SUPPORT_R = _SC_C_LANG_SUPPORT + 1;
  public static final int _SC_CLOCK_SELECTION = _SC_C_LANG_SUPPORT_R + 1;
  public static final int _SC_CPUTIME = _SC_CLOCK_SELECTION + 1;
  public static final int _SC_THREAD_CPUTIME = _SC_CPUTIME + 1;
  public static final int _SC_DEVICE_IO = _SC_THREAD_CPUTIME + 1;
  public static final int _SC_DEVICE_SPECIFIC = _SC_DEVICE_IO + 1;
  public static final int _SC_DEVICE_SPECIFIC_R = _SC_DEVICE_SPECIFIC + 1;
  public static final int _SC_FD_MGMT = _SC_DEVICE_SPECIFIC_R + 1;
  public static final int _SC_FIFO = _SC_FD_MGMT + 1;
  public static final int _SC_PIPE = _SC_FIFO + 1;
  public static final int _SC_FILE_ATTRIBUTES = _SC_PIPE + 1;
  public static final int _SC_FILE_LOCKING = _SC_FILE_ATTRIBUTES + 1;
  public static final int _SC_FILE_SYSTEM = _SC_FILE_LOCKING + 1;
  public static final int _SC_MONOTONIC_CLOCK = _SC_FILE_SYSTEM + 1;
  public static final int _SC_MULTI_PROCESS = _SC_MONOTONIC_CLOCK + 1;
  public static final int _SC_SINGLE_PROCESS = _SC_MULTI_PROCESS + 1;
  public static final int _SC_NETWORKING = _SC_SINGLE_PROCESS + 1;
  public static final int _SC_READER_WRITER_LOCKS = _SC_NETWORKING + 1;
  public static final int _SC_SPIN_LOCKS = _SC_READER_WRITER_LOCKS + 1;
  public static final int _SC_REGEXP = _SC_SPIN_LOCKS + 1;
  public static final int _SC_REGEX_VERSION = _SC_REGEXP + 1;
  public static final int _SC_SHELL = _SC_REGEX_VERSION + 1;
  public static final int _SC_SIGNALS = _SC_SHELL + 1;
  public static final int _SC_SPAWN = _SC_SIGNALS + 1;
  public static final int _SC_SPORADIC_SERVER = _SC_SPAWN + 1;
  public static final int _SC_THREAD_SPORADIC_SERVER = _SC_SPORADIC_SERVER + 1;
  public static final int _SC_SYSTEM_DATABASE = _SC_THREAD_SPORADIC_SERVER + 1;
  public static final int _SC_SYSTEM_DATABASE_R = _SC_SYSTEM_DATABASE + 1;
  public static final int _SC_TIMEOUTS = _SC_SYSTEM_DATABASE_R + 1;
  public static final int _SC_TYPED_MEMORY_OBJECTS = _SC_TIMEOUTS + 1;
  public static final int _SC_USER_GROUPS = _SC_TYPED_MEMORY_OBJECTS + 1;
  public static final int _SC_USER_GROUPS_R = _SC_USER_GROUPS + 1;
  public static final int _SC_2_PBS = _SC_USER_GROUPS_R + 1;
  public static final int _SC_2_PBS_ACCOUNTING = _SC_2_PBS + 1;
  public static final int _SC_2_PBS_LOCATE = _SC_2_PBS_ACCOUNTING + 1;
  public static final int _SC_2_PBS_MESSAGE = _SC_2_PBS_LOCATE + 1;
  public static final int _SC_2_PBS_TRACK = _SC_2_PBS_MESSAGE + 1;
  public static final int _SC_SYMLOOP_MAX = _SC_2_PBS_TRACK + 1;
  public static final int _SC_STREAMS = _SC_SYMLOOP_MAX + 1;
  public static final int _SC_2_PBS_CHECKPOINT = _SC_STREAMS + 1;
  
  public static final int _SC_V6_ILP32_OFF32 = _SC_2_PBS_CHECKPOINT + 1;
  public static final int _SC_V6_ILP32_OFFBIG = _SC_V6_ILP32_OFF32 + 1;
  public static final int _SC_V6_LP64_OFF64 = _SC_V6_ILP32_OFFBIG + 1;
  public static final int _SC_V6_LPBIG_OFFBIG = _SC_V6_LP64_OFF64 + 1;
  
  public static final int _SC_HOST_NAME_MAX = _SC_V6_LPBIG_OFFBIG + 1;
  public static final int _SC_TRACE = _SC_HOST_NAME_MAX + 1;
  public static final int _SC_TRACE_EVENT_FILTER = _SC_TRACE + 1;
  public static final int _SC_TRACE_INHERIT = _SC_TRACE_EVENT_FILTER + 1;
  public static final int _SC_TRACE_LOG = _SC_TRACE_INHERIT + 1;
  
  public static final int _SC_LEVEL1_ICACHE_SIZE = _SC_TRACE_LOG + 1;
  public static final int _SC_LEVEL1_ICACHE_ASSOC = _SC_LEVEL1_ICACHE_SIZE + 1;
  public static final int _SC_LEVEL1_ICACHE_LINESIZE = _SC_LEVEL1_ICACHE_ASSOC + 1;
  public static final int _SC_LEVEL1_DCACHE_SIZE = _SC_LEVEL1_ICACHE_LINESIZE + 1;
  public static final int _SC_LEVEL1_DCACHE_ASSOC = _SC_LEVEL1_DCACHE_SIZE + 1;
  public static final int _SC_LEVEL1_DCACHE_LINESIZE = _SC_LEVEL1_DCACHE_ASSOC + 1;
  public static final int _SC_LEVEL2_CACHE_SIZE = _SC_LEVEL1_DCACHE_LINESIZE + 1;
  public static final int _SC_LEVEL2_CACHE_ASSOC = _SC_LEVEL2_CACHE_SIZE + 1;
  public static final int _SC_LEVEL2_CACHE_LINESIZE = _SC_LEVEL2_CACHE_ASSOC + 1;
  public static final int _SC_LEVEL3_CACHE_SIZE = _SC_LEVEL2_CACHE_LINESIZE + 1;
  public static final int _SC_LEVEL3_CACHE_ASSOC = _SC_LEVEL3_CACHE_SIZE + 1;
  public static final int _SC_LEVEL3_CACHE_LINESIZE = _SC_LEVEL3_CACHE_ASSOC + 1;
  public static final int _SC_LEVEL4_CACHE_SIZE = _SC_LEVEL3_CACHE_LINESIZE + 1;
  public static final int _SC_LEVEL4_CACHE_ASSOC = _SC_LEVEL4_CACHE_SIZE + 1;
  public static final int _SC_LEVEL4_CACHE_LINESIZE = _SC_LEVEL4_CACHE_ASSOC + 1;
  /* Leave room here, maybe we need a few more cache levels some day.  */
  public static final int _SC_IPV6 = _SC_LEVEL1_ICACHE_SIZE + 50;
  public static final int _SC_RAW_SOCKETS = _SC_IPV6 + 1;
  
  public static final int _SC_V7_ILP32_OFF32 = _SC_RAW_SOCKETS + 1;
  public static final int _SC_V7_ILP32_OFFBIG = _SC_V7_ILP32_OFF32 + 1;
  public static final int _SC_V7_LP64_OFF64 = _SC_V7_ILP32_OFFBIG + 1;
  public static final int _SC_V7_LPBIG_OFFBIG = _SC_V7_LP64_OFF64 + 1;
  
  public static final int _SC_SS_REPL_MAX = _SC_V7_LPBIG_OFFBIG + 1;
  
  public static final int _SC_TRACE_EVENT_NAME_MAX = _SC_SS_REPL_MAX + 1;
  public static final int _SC_TRACE_NAME_MAX = _SC_TRACE_EVENT_NAME_MAX + 1;
  public static final int _SC_TRACE_SYS_MAX = _SC_TRACE_NAME_MAX + 1;
  public static final int _SC_TRACE_USER_EVENT_MAX = _SC_TRACE_SYS_MAX + 1;
  
  public static final int _SC_XOPEN_STREAMS = _SC_TRACE_USER_EVENT_MAX + 1;
  
  public static final int _SC_THREAD_ROBUST_PRIO_INHERIT = _SC_XOPEN_STREAMS + 1;
  public static final int _SC_THREAD_ROBUST_PRIO_PROTECT = _SC_THREAD_ROBUST_PRIO_INHERIT + 1;
//}

/* Values for the NAME argument to `confstr'.  */
//public final class/*enum*/ {
  public static final int _CS_PATH = 0; /* The default search path.  */
  
  public static final int _CS_V6_WIDTH_RESTRICTED_ENVS = _CS_PATH + 1;
  
  public static final int _CS_GNU_LIBC_VERSION = _CS_V6_WIDTH_RESTRICTED_ENVS + 1;
  public static final int _CS_GNU_LIBPTHREAD_VERSION = _CS_GNU_LIBC_VERSION + 1;
  
  public static final int _CS_V5_WIDTH_RESTRICTED_ENVS = _CS_GNU_LIBPTHREAD_VERSION + 1;
  
  public static final int _CS_V7_WIDTH_RESTRICTED_ENVS = _CS_V5_WIDTH_RESTRICTED_ENVS + 1;
  
  public static final int _CS_LFS_CFLAGS = 1000;
  public static final int _CS_LFS_LDFLAGS = _CS_LFS_CFLAGS + 1;
  public static final int _CS_LFS_LIBS = _CS_LFS_LDFLAGS + 1;
  public static final int _CS_LFS_LINTFLAGS = _CS_LFS_LIBS + 1;
  public static final int _CS_LFS64_CFLAGS = _CS_LFS_LINTFLAGS + 1;
  public static final int _CS_LFS64_LDFLAGS = _CS_LFS64_CFLAGS + 1;
  public static final int _CS_LFS64_LIBS = _CS_LFS64_LDFLAGS + 1;
  public static final int _CS_LFS64_LINTFLAGS = _CS_LFS64_LIBS + 1;
  
  public static final int _CS_XBS5_ILP32_OFF32_CFLAGS = 1100;
  public static final int _CS_XBS5_ILP32_OFF32_LDFLAGS = _CS_XBS5_ILP32_OFF32_CFLAGS + 1;
  public static final int _CS_XBS5_ILP32_OFF32_LIBS = _CS_XBS5_ILP32_OFF32_LDFLAGS + 1;
  public static final int _CS_XBS5_ILP32_OFF32_LINTFLAGS = _CS_XBS5_ILP32_OFF32_LIBS + 1;
  public static final int _CS_XBS5_ILP32_OFFBIG_CFLAGS = _CS_XBS5_ILP32_OFF32_LINTFLAGS + 1;
  public static final int _CS_XBS5_ILP32_OFFBIG_LDFLAGS = _CS_XBS5_ILP32_OFFBIG_CFLAGS + 1;
  public static final int _CS_XBS5_ILP32_OFFBIG_LIBS = _CS_XBS5_ILP32_OFFBIG_LDFLAGS + 1;
  public static final int _CS_XBS5_ILP32_OFFBIG_LINTFLAGS = _CS_XBS5_ILP32_OFFBIG_LIBS + 1;
  public static final int _CS_XBS5_LP64_OFF64_CFLAGS = _CS_XBS5_ILP32_OFFBIG_LINTFLAGS + 1;
  public static final int _CS_XBS5_LP64_OFF64_LDFLAGS = _CS_XBS5_LP64_OFF64_CFLAGS + 1;
  public static final int _CS_XBS5_LP64_OFF64_LIBS = _CS_XBS5_LP64_OFF64_LDFLAGS + 1;
  public static final int _CS_XBS5_LP64_OFF64_LINTFLAGS = _CS_XBS5_LP64_OFF64_LIBS + 1;
  public static final int _CS_XBS5_LPBIG_OFFBIG_CFLAGS = _CS_XBS5_LP64_OFF64_LINTFLAGS + 1;
  public static final int _CS_XBS5_LPBIG_OFFBIG_LDFLAGS = _CS_XBS5_LPBIG_OFFBIG_CFLAGS + 1;
  public static final int _CS_XBS5_LPBIG_OFFBIG_LIBS = _CS_XBS5_LPBIG_OFFBIG_LDFLAGS + 1;
  public static final int _CS_XBS5_LPBIG_OFFBIG_LINTFLAGS = _CS_XBS5_LPBIG_OFFBIG_LIBS + 1;
  
  public static final int _CS_POSIX_V6_ILP32_OFF32_CFLAGS = _CS_XBS5_LPBIG_OFFBIG_LINTFLAGS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFF32_LDFLAGS = _CS_POSIX_V6_ILP32_OFF32_CFLAGS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFF32_LIBS = _CS_POSIX_V6_ILP32_OFF32_LDFLAGS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFF32_LINTFLAGS = _CS_POSIX_V6_ILP32_OFF32_LIBS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFFBIG_CFLAGS = _CS_POSIX_V6_ILP32_OFF32_LINTFLAGS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFFBIG_LDFLAGS = _CS_POSIX_V6_ILP32_OFFBIG_CFLAGS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFFBIG_LIBS = _CS_POSIX_V6_ILP32_OFFBIG_LDFLAGS + 1;
  public static final int _CS_POSIX_V6_ILP32_OFFBIG_LINTFLAGS = _CS_POSIX_V6_ILP32_OFFBIG_LIBS + 1;
  public static final int _CS_POSIX_V6_LP64_OFF64_CFLAGS = _CS_POSIX_V6_ILP32_OFFBIG_LINTFLAGS + 1;
  public static final int _CS_POSIX_V6_LP64_OFF64_LDFLAGS = _CS_POSIX_V6_LP64_OFF64_CFLAGS + 1;
  public static final int _CS_POSIX_V6_LP64_OFF64_LIBS = _CS_POSIX_V6_LP64_OFF64_LDFLAGS + 1;
  public static final int _CS_POSIX_V6_LP64_OFF64_LINTFLAGS = _CS_POSIX_V6_LP64_OFF64_LIBS + 1;
  public static final int _CS_POSIX_V6_LPBIG_OFFBIG_CFLAGS = _CS_POSIX_V6_LP64_OFF64_LINTFLAGS + 1;
  public static final int _CS_POSIX_V6_LPBIG_OFFBIG_LDFLAGS = _CS_POSIX_V6_LPBIG_OFFBIG_CFLAGS + 1;
  public static final int _CS_POSIX_V6_LPBIG_OFFBIG_LIBS = _CS_POSIX_V6_LPBIG_OFFBIG_LDFLAGS + 1;
  public static final int _CS_POSIX_V6_LPBIG_OFFBIG_LINTFLAGS = _CS_POSIX_V6_LPBIG_OFFBIG_LIBS + 1;
  
  public static final int _CS_POSIX_V7_ILP32_OFF32_CFLAGS = _CS_POSIX_V6_LPBIG_OFFBIG_LINTFLAGS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFF32_LDFLAGS = _CS_POSIX_V7_ILP32_OFF32_CFLAGS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFF32_LIBS = _CS_POSIX_V7_ILP32_OFF32_LDFLAGS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFF32_LINTFLAGS = _CS_POSIX_V7_ILP32_OFF32_LIBS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFFBIG_CFLAGS = _CS_POSIX_V7_ILP32_OFF32_LINTFLAGS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFFBIG_LDFLAGS = _CS_POSIX_V7_ILP32_OFFBIG_CFLAGS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFFBIG_LIBS = _CS_POSIX_V7_ILP32_OFFBIG_LDFLAGS + 1;
  public static final int _CS_POSIX_V7_ILP32_OFFBIG_LINTFLAGS = _CS_POSIX_V7_ILP32_OFFBIG_LIBS + 1;
  public static final int _CS_POSIX_V7_LP64_OFF64_CFLAGS = _CS_POSIX_V7_ILP32_OFFBIG_LINTFLAGS + 1;
  public static final int _CS_POSIX_V7_LP64_OFF64_LDFLAGS = _CS_POSIX_V7_LP64_OFF64_CFLAGS + 1;
  public static final int _CS_POSIX_V7_LP64_OFF64_LIBS = _CS_POSIX_V7_LP64_OFF64_LDFLAGS + 1;
  public static final int _CS_POSIX_V7_LP64_OFF64_LINTFLAGS = _CS_POSIX_V7_LP64_OFF64_LIBS + 1;
  public static final int _CS_POSIX_V7_LPBIG_OFFBIG_CFLAGS = _CS_POSIX_V7_LP64_OFF64_LINTFLAGS + 1;
  public static final int _CS_POSIX_V7_LPBIG_OFFBIG_LDFLAGS = _CS_POSIX_V7_LPBIG_OFFBIG_CFLAGS + 1;
  public static final int _CS_POSIX_V7_LPBIG_OFFBIG_LIBS = _CS_POSIX_V7_LPBIG_OFFBIG_LDFLAGS + 1;
  public static final int _CS_POSIX_V7_LPBIG_OFFBIG_LINTFLAGS = _CS_POSIX_V7_LPBIG_OFFBIG_LIBS + 1;
  
  public static final int _CS_V6_ENV = _CS_POSIX_V7_LPBIG_OFFBIG_LINTFLAGS + 1;
  public static final int _CS_V7_ENV = _CS_V6_ENV + 1;
//}
}
