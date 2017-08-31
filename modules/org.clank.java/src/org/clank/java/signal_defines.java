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
 * @author Vladimir Voskresensky
 */
public interface signal_defines {
public static final int	SIGHUP	= 1;/* hangup */
public static final int	SIGINT	= 2;/* interrupt (rubout) */
public static final int	SIGQUIT	= 3;/* quit (ASCII FS) */
public static final int	SIGILL	= 4;/* illegal instruction (not reset when caught) */
public static final int	SIGTRAP	= 5;/* trace trap (not reset when caught) */
public static final int	SIGIOT	= 6;/* IOT instruction */
public static final int	SIGABRT = 6;/* used by abort, replace SIGIOT in the future */
public static final int	SIGEMT	= 7;/* EMT instruction */
public static final int	SIGFPE	= 8;/* floating point exception */
public static final int	SIGKILL	= 9;/* kill (cannot be caught or ignored) */
public static final int	SIGBUS  	= 10;/* bus error */
public static final int	SIGSEGV	= 11;/* segmentation violation */
public static final int	SIGSYS  = 12	;/* bad argument to system call */
public static final int	SIGPIPE	= 13;/* write on a pipe with no one to read it */
public static final int	SIGALRM	= 14;/* alarm clock */
public static final int	SIGTERM	= 15;/* software termination signal from kill */
public static final int	SIGUSR1	= 16;/* user defined signal 1 */
public static final int	SIGUSR2	= 17;/* user defined signal 2 */
public static final int	SIGCLD	= 18;/* child status change */
public static final int	SIGCHLD	= 18;/* child status change alias (POSIX) */
public static final int	SIGPWR	= 19;/* power-fail restart */
public static final int	SIGWINCH=  20;/* window size change */
public static final int	SIGURG	= 21;/* urgent socket condition */
public static final int	SIGPOLL = 22;/* pollable event occured */
public static final int	SIGIO	  = SIGPOLL;/* socket I/O possible (SIGPOLL alias) */
public static final int	SIGSTOP = 23;/* stop (cannot be caught or ignored) */
public static final int	SIGTSTP = 24;/* user stop requested from tty */
public static final int	SIGCONT = 25;/* stopped process has been continued */
public static final int	SIGTTIN = 26;/* background tty read attempted */
public static final int	SIGTTOU = 27;/* background tty write attempted */
public static final int	SIGVTALRM = 28;/* virtual timer expired */
public static final int	SIGPROF = 29;/* profiling timer expired */
public static final int	SIGXCPU = 30;/* exceeded cpu limit */
public static final int	SIGXFSZ = 31;/* exceeded file size limit */
public static final int	SIGWAITING = 32;/* reserved signal no longer used by threading code */
public static final int	SIGLWP = 33;/* reserved signal no longer used by threading code */
public static final int	SIGFREEZE = 34;/* special signal used by CPR */
public static final int	SIGTHAW = 35;/* special signal used by CPR */
public static final int	SIGCANCEL = 36;/* reserved signal for thread cancellation */
public static final int	SIGLOST	= 37;/* resource lost (eg, record-lock lost) */
public static final int	SIGXRES	= 38;/* resource control exceeded */
public static final int	SIGJVM1	= 39;/* reserved signal for Java Virtual Machine */
public static final int	SIGJVM2	= 40;/* reserved signal for Java Virtual Machine */

public static final int	_NSIG	=	65;	/* Biggest signal number + 1

/* definitions for the sa_flags field */
public static final int	SA_ONSTACK	= 0x00000001;
public static final int	SA_RESETHAND =	0x00000002;
public static final int	SA_RESTART =	0x00000004;
public static final int	SA_SIGINFO = 0x00000008;
public static final int	SA_NODEFER = 0x00000010;
/* this is only valid for SIGCLD */
public static final int	SA_NOCLDWAIT = 0x00010000;	/* don't save zombie children	 */


/* Bits in `sa_flags'.  */
public static final int SA_NOCLDSTOP = 1;		 /* Don't send SIGCHLD when children stop.  */
public static final int SA_INTERRUPT = 0x20000000; /* Historical no-op.  */

/* Some aliases for the SA_ constants.  */
public static final int SA_NOMASK = SA_NODEFER;
public static final int SA_ONESHOT = SA_RESETHAND;
public static final int SA_STACK = SA_ONSTACK;
//#endif

/* Values for the HOW argument to `sigprocmask'.  */
public static final int SIG_BLOCK = 0;		 /* Block signals.  */
public static final int SIG_UNBLOCK = 1;		 /* Unblock signals.  */
public static final int SIG_SETMASK = 2;		 /* Set the set of blocked signals.  */

}
