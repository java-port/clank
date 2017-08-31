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

import org.clank.java.std_time.timespec;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;

public final class signal implements signal_defines {

private signal() {
}

public static final class sigset_t {		/* signal set type */
	/*uint*/int	__sigbits[] = new$uint(4);
};

public static final class siginfo_t {
  
}

public static interface sigaction_t {
  void $call(int $P0, siginfo_t /*P*/$P1, void$ptr $P2);
}

public static final class sigaction {
	public int sa_flags;
	public static final class _union {
//#ifdef	__cplusplus
    public NativeCallback.Int2Void _handler;
//#else
//		void (*_handler)();
//#endif
//#if defined(__EXTENSIONS__) || defined(_KERNEL) || \
//	(!defined(_STRICT_STDC) && !defined(__XOPEN_OR_POSIX)) || \
//	(_POSIX_C_SOURCE > 2) || defined(_XPG4_2)
		sigaction_t _sigaction;
//#endif
	};
  public _union _funcptr = new _union();
	public sigset_t sa_mask = new sigset_t();
//#ifndef _LP64
	public int sa_resv[] = new$int(2);
//#endif  
}

/* Type for data associated with a signal.  */
public static final class sigval_t
  {
    int sival_int;
    Object sival_ptr;
  }

/* Type of a signal handler.  */
//typedef void (*__sighandler_t) (int);
@FunctionalInterface
public static interface sighandler_t extends NativeCallback.Int2Void {}

/* Structure describing a signal stack (obsolete).  */
public static final class sigstack
  {
    Object ss_sp;		/* Signal stack pointer.  */
    int ss_onstack;		/* Nonzero if executing on this stack.  */
  };


/* Possible values for `ss_flags.'.  */
//enum
//{
public static final byte SS_ONSTACK = 1;
//#define SS_ONSTACK	SS_ONSTACK
public static final byte SS_DISABLE = 2;
//#define SS_DISABLE	SS_DISABLE
//};

/* Minimum stack size for a signal handler.  */
public static final int MINSIGSTKSZ =	2048;

/* System default stack size.  */
public static final int SIGSTKSZ =	8192;


/* Alternate, preferred interface.  */
public static final class stack_t
  {
    public Object ss_sp;
    public int ss_flags;
    public /*uint*/int ss_size;
  }

public static final class _fpx_sw_bytes
{
  public /*uint32_t*/int magic1;
  public /*uint32_t*/int extended_size;
  public /*uint64_t*/long xstate_bv;
  public /*uint32_t*/int xstate_size;
  public /*uint32_t*/int padding[/*7*/];
};

public static final class _fpreg
{
  public /*ushort*/char significand[/*4*/];
  public /*ushort*/char exponent;
};

public static final class _fpxreg
{
  public /*ushort*/char significand[/*4*/];
  public /*ushort*/char exponent;
  public /*ushort*/char padding[/*3*/];
};

public static final class _xmmreg
{
  public /*uint32_t*/int	element[/*4*/];
};

public static final class _fpstate
{
  /* FPU environment matching the 64-bit FXSAVE layout.  */
  public /*uint16_t*/char		cwd;
  public /*uint16_t*/char		swd;
  public /*uint16_t*/char		ftw;
  public /*uint16_t*/char		fop;
  public /*uint64_t*/long		rip;
  public /*uint64_t*/long		rdp;
  public /*uint32_t*/int		mxcsr;
  public /*uint32_t*/int		mxcr_mask;
  public _fpxreg	_st[/*8*/];
  public _xmmreg	_xmm[/*16*/];
  public /*uint32_t*/int		padding[/*24*/];
};

public static final class sigcontext
{
  public /*uint64_t*/long r8;
  public /*uint64_t*/long r9;
  public /*uint64_t*/long r10;
  public /*uint64_t*/long r11;
  public /*uint64_t*/long r12;
  public /*uint64_t*/long r13;
  public /*uint64_t*/long r14;
  public /*uint64_t*/long r15;
  public /*uint64_t*/long rdi;
  public /*uint64_t*/long rsi;
  public /*uint64_t*/long rbp;
  public /*uint64_t*/long rbx;
  public /*uint64_t*/long rdx;
  public /*uint64_t*/long rax;
  public /*uint64_t*/long rcx;
  public /*uint64_t*/long rsp;
  public /*uint64_t*/long rip;
  public /*uint64_t*/long eflags;
  public /*ushort*/char cs;
  public /*ushort*/char gs;
  public /*ushort*/char fs;
  public /*ushort*/char __pad0;
  public /*uint64_t*/long err;
  public /*uint64_t*/long trapno;
  public /*uint64_t*/long oldmask;
  public /*uint64_t*/long cr2;
  //__extension__ union
  //  {
      public _fpstate/*P*/ fpstate;
      public /*uint64_t*/long __fpstate_word;
  //  };
  public /*uint64_t*/long __reserved1 [/*8*/];
};

/* Send signal SIG to process number PID.  If PID is zero,
   send SIG to all processes in the current process's process group.
   If PID is < -1, send SIG to all processes in process group - PID.  */
//#ifdef __USE_POSIX
public static final int kill (/*__pid_t*/int __pid, int __sig) {
  throw new UnsupportedOperationException("EmptyBody");
}
//#endif /* Use POSIX.  */

/* None of the following functions should be used anymore.  They are here
   only for compatibility.  A single word (`int') is not guaranteed to be
   enough to hold a complete signal mask and therefore these functions
   simply do not work in many situations.  Use `sigprocmask' instead.  */

/* Compute mask for signal SIG.  */
//# define sigmask(sig)	__sigmask(sig)

/* Block signals in MASK, returning the old mask.  */
public static final int sigblock (int __mask) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Set the mask of blocked signals to MASK, returning the old mask.  */
public static final int sigsetmask (int __mask) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Return currently selected signal mask.  */
public static final int siggetmask () {
  throw new UnsupportedOperationException("EmptyBody");
}


//#ifdef __USE_MISC
//# define NSIG	_NSIG
//#endif
//
//#ifdef __USE_GNU
//typedef __sighandler_t sighandler_t;
//#endif

/* 4.4 BSD uses the name `sig_t' for this.  */
//#ifdef __USE_BSD
//typedef __sighandler_t sig_t;
//#endif
//
//#ifdef __USE_POSIX

/* Clear all signals from SET.  */
public static final int sigemptyset (sigset_t/*P*/__set) {
  for (int i = 0; i < __set.__sigbits.length; i++) {
    __set.__sigbits[i] = 0;
  }
  return 0;
}

/* Set all signals in SET.  */
public static final int sigfillset (sigset_t/*P*/__set) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Add SIGNO to SET.  */
public static final int sigaddset (sigset_t/*P*/__set, int __signo) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Remove SIGNO from SET.  */
public static final int sigdelset (sigset_t/*P*/__set, int __signo) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Return 1 if SIGNO is in SET, 0 if not.  */
public static final int sigismember (/*const*/sigset_t/*P*/__set, int __signo)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

//# ifdef __USE_GNU
/* Return non-empty value is SET is not empty.  */
public static final int sigisemptyset (/*const*/sigset_t/*P*/__set) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Build new signal set by combining the two inputs set using logical AND.  */
public static final int sigandset (sigset_t/*P*/__set, /*const*/sigset_t/*P*/__left,
		      /*const*/sigset_t/*P*/__right) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Build new signal set by combining the two inputs set using logical OR.  */
public static final int sigorset (sigset_t/*P*/__set, /*const*/sigset_t/*P*/__left,
		     /*const*/sigset_t/*P*/__right) {
  throw new UnsupportedOperationException("EmptyBody");
}
//# endif /* GNU */

/* Get the system-specific definitions of `struct sigaction'
   and the `SA_*' and `SIG_*'. constants.  */
//# include <bits/sigaction.h>

/* Get and/or change the set of blocked signals.  */
public static final int sigprocmask (int __how, /*const*/sigset_t/*P*/ __set,
			sigset_t/*P*/ __oset) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Change the set of blocked signals to SET,
   wait until a signal arrives, and restore the set of blocked signals.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
public static final int sigsuspend (/*const*/sigset_t/*P*/__set) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Get and/or set the action for signal SIG.  */
public static final int sigaction (int __sig, sigaction/*P*/ __act,
		      sigaction/*P*/ __oact) {
  // Not implemented
  return -1;
}

/* Put in SET all signals that are blocked and waiting to be delivered.  */
public static final int sigpending (sigset_t/*P*/__set) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Select any of pending signals from SET or wait for any to arrive.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
public static final int sigwait (/*const*/sigset_t/*P*/ __set, int$ptr __sig)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

//# ifdef __USE_POSIX199309
/* Select any of pending signals from SET and place information in INFO.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
public static final int sigwaitinfo (/*const*/sigset_t/*P*/ __set,
			siginfo_t/*P*/ __info) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Select any of pending signals from SET and place information in INFO.
   Wait the time specified by TIMEOUT if no signal is pending.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
public static final int sigtimedwait (/*const*/sigset_t/*P*/ __set,
			 siginfo_t/*P*/ __info,
			 timespec/*P*/ __timeout)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Send signal SIG to the process PID.  Associate data in VAL with the
   signal.  */
public static final int sigqueue (/*__pid_t*/int __pid, int __sig, sigval_t __val)
     {
  throw new UnsupportedOperationException("EmptyBody");
}
//# endif	/* Use POSIX 199306.  */
//
//#endif /* Use POSIX.  */
//
//#ifdef __USE_BSD

/* Names of the signals.  This variable exists only for compatibility.
   Use `strsignal' instead (see <string.h>).  */
public static final char$ptr _sys_siglist[/*_NSIG*/] = new char$ptr[_NSIG];
public static final char$ptr sys_siglist[/*_NSIG*/] = new char$ptr[_NSIG];

/* Structure passed to `sigvec'.  */
public static final class sigvec
  {
    sighandler_t sv_handler;	/* Signal handler.  */
    int sv_mask;		/* Mask of signals to be blocked.  */

    int sv_flags;		/* Flags (see below).  */
//# define sv_onstack	sv_flags /* 4.2 BSD compatibility.  */
  };

/* Bits in `sv_flags'.  */
public static final int SV_ONSTACK = (1 << 0);/* Take the signal on the signal stack.  */
public static final int SV_INTERRUPT = (1 << 1);/* Do not restart system calls.  */
public static final int SV_RESETHAND = (1 << 2);/* Reset handler to SIG_DFL on receipt.  */


/* If VEC is non-NULL, set the handler for SIG to the `sv_handler' member
   of VEC.  The signals in `sv_mask' will be blocked while the handler runs.
   If the SV_RESETHAND bit is set in `sv_flags', the handler for SIG will be
   reset to SIG_DFL before `sv_handler' is entered.  If OVEC is non-NULL,
   it is filled in with the old information for SIG.  */
public static final int sigvec (int __sig, sigvec/*P*/ __vec,
		   sigvec/*P*/ __ovec) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Get machine-dependent `struct sigcontext' and signal subcodes.  */
//# include <bits/sigcontext.h>

/* Restore the state saved in SCP.  */
public static final int sigreturn (sigcontext/*P*/ __scp) {
  throw new UnsupportedOperationException("EmptyBody");
}

//#endif /*  use BSD.  */


//#if defined __USE_BSD || defined __USE_XOPEN_EXTENDED || defined __USE_XOPEN2K8
//# define __need_size_t
//# include <stddef.h>

/* If INTERRUPT is nonzero, make signal SIG interrupt system calls
   (causing them to fail with EINTR); if INTERRUPT is zero, make system
   calls be restarted after signal SIG.  */
public static final int siginterrupt (int __sig, int __interrupt) {
  throw new UnsupportedOperationException("EmptyBody");
}

//# include <bits/sigstack.h>
//# if defined __USE_XOPEN || defined __USE_XOPEN2K8
///* This will define `ucontext_t' and `mcontext_t'.  */
//#  include <sys/ucontext.h>
//# endif

/* Run signals handlers on the stack specified by SS (if not NULL).
   If OSS is not NULL, it is filled in with the old signal stack status.
   This interface is obsolete and on many platform not implemented.  */
public static final int sigstack (stack_t/*P*/__ss, stack_t/*P*/__oss) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Alternate signal handler stack interface.
   This interface should always be preferred over `sigstack'.  */
public static final int sigaltstack (stack_t/*P*/ __ss,
			stack_t/*P*/ __oss) {
  throw new UnsupportedOperationException("EmptyBody");
}

//#endif /* use BSD or X/Open Unix.  */

//#ifdef __USE_XOPEN_EXTENDED
/* Simplified interface for signal management.  */

/* Add SIG to the calling process' signal mask.  */
public static final int sighold (int __sig) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Remove SIG from the calling process' signal mask.  */
public static final int sigrelse (int __sig) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Set the disposition of SIG to SIG_IGN.  */
public static final int sigignore (int __sig) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Set the disposition of SIG.  */
public static final sighandler_t sigset (int __sig, sighandler_t __disp) {
  throw new UnsupportedOperationException("EmptyBody");
}

//#endif

}
