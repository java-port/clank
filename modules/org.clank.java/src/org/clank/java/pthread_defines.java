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
public interface pthread_defines {

/*
 * Thread related attribute values defined as in thread.h.
 * These are defined as bit pattern in thread.h.
 * Any change here should be reflected in thread.h.
 */
/* detach */
public static final int	PTHREAD_CREATE_DETACHED	=	0x40;	/* = THR_DETACHED */
public static final int	PTHREAD_CREATE_JOINABLE	=	0;
/* scope */
public static final int	PTHREAD_SCOPE_SYSTEM	=	0x01;	/* = THR_BOUND */
public static final int	PTHREAD_SCOPE_PROCESS	=	0;

/*
 * Other attributes which are not defined in thread.h
 */
/* inherit */
public static final int	PTHREAD_INHERIT_SCHED	=	1;
public static final int	PTHREAD_EXPLICIT_SCHED	=	0;

/*
 * Value of process-shared attribute
 * These are defined as values defined in sys/synch.h
 * Any change here should be reflected in sys/synch.h.
 */
public static final int	PTHREAD_PROCESS_SHARED	=	1;	/* = USYNC_PROCESS */
public static final int	PTHREAD_PROCESS_PRIVATE	=	0;	/* = USYNC_THREAD */

public static final int	_DEFAULT_TYPE 	=		PTHREAD_PROCESS_PRIVATE;
//#if !defined(__XOPEN_OR_POSIX) || defined(__EXTENSIONS__)
public static final int	DEFAULT_TYPE	=		_DEFAULT_TYPE;
//#endif

/*
 * mutex types
 * keep these in synch which sys/synch.h lock flags
 */
public static final int	PTHREAD_MUTEX_NORMAL	=	0x0;
public static final int	PTHREAD_MUTEX_ERRORCHECK =	0x2;
public static final int	PTHREAD_MUTEX_RECURSIVE	=	0x4;
public static final int	PTHREAD_MUTEX_DEFAULT	=	PTHREAD_MUTEX_NORMAL;

/*
 * Mutex protocol values. Keep these in synch with sys/synch.h lock types.
 */
public static final int	PTHREAD_PRIO_NONE	=	0x0;
public static final int	PTHREAD_PRIO_INHERIT	=	0x10;
public static final int	PTHREAD_PRIO_PROTECT	=	0x20;

/*
 * Mutex robustness attribute values. The robustness attribute is a
 * Solaris specific extension to support robust mutexes. Note the _NP suffix
 * to indicate these are not part of the current POSIX spec (POSIX 1003.1 1996),
 * but are platform specific non-portable extensions. Keep these in synch
 * with sys/synch.h lock types.
 */
public static final int	PTHREAD_MUTEX_STALL_NP	=	0x0;
public static final int	PTHREAD_MUTEX_ROBUST_NP	=	0x40;  
}
