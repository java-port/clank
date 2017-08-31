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

import org.clank.java.sched.sched_param;
import org.clank.java.signal.sigset_t;
import org.clank.support.aliases.*;

/**
 *
 * @author petrk
 */
public final class spawn {
/* Data structure to contain attributes for thread creation.  */
public static final class posix_spawnattr_t
{
  short __flags;
  /*pid_t*/int __pgrp;
  sigset_t __sd;
  sigset_t __ss;
  sched_param __sp;
  int __policy;
  int __pad[/*16*/] = new int[16];
}


/* Data structure to contain information about the actions to be
   performed in the new process with respect to file descriptors.  */
public static final class posix_spawn_file_actions_t
{
  int __allocated;
  int __used;
  type$ptr __actions;
  int __pad[/*16*/] = new int[16];
}


/* Flags to be set in the `posix_spawnattr_t'.  */
public static final byte POSIX_SPAWN_RESETIDS	=	0x01;
public static final byte POSIX_SPAWN_SETPGROUP =		0x02;
public static final byte POSIX_SPAWN_SETSIGDEF =		0x04;
public static final byte POSIX_SPAWN_SETSIGMASK =		0x08;
public static final byte POSIX_SPAWN_SETSCHEDPARAM =	0x10;
public static final byte POSIX_SPAWN_SETSCHEDULER =	0x20;

public static final byte POSIX_SPAWN_USEVFORK =		0x40;




/* Spawn a new process executing PATH with the attributes describes in *ATTRP.
   Before running the process perform the actions described in FILE-ACTIONS.

   This function is a possible cancellation point and therefore not
   marked with __THROW. */
public static final int posix_spawn (int$ptr __pid,
			char$ptr __path,
			posix_spawn_file_actions_t/*P*/
			__file_actions,
			posix_spawnattr_t/*P*/ __attrp,
			char$ptr __argv[/*_arr*/],
			char$ptr __envp[/*_arr*/]) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Similar to `posix_spawn' but search for FILE in the PATH.

   This function is a possible cancellation point and therefore not
   marked with __THROW.  */
public static final int posix_spawnp (int$ptr __pid, char$ptr __file,
			 posix_spawn_file_actions_t/*P*/ __file_actions,
			 posix_spawnattr_t/*P*/ __attrp,
			 char$ptr __argv[], char$ptr __envp[]) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Initialize data structure with attributes for `spawn' to default values.  */
public static final int posix_spawnattr_init (posix_spawnattr_t/*P*/__attr) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Free resources associated with ATTR.  */
public static final int posix_spawnattr_destroy (posix_spawnattr_t/*P*/__attr) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Store signal mask for signals with default handling from ATTR in
   SIGDEFAULT.  */
public static final int posix_spawnattr_getsigdefault (posix_spawnattr_t/*P*/ 
					   __attr,
					  sigset_t/*P*/ __sigdefault)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Set signal mask for signals with default handling in ATTR to SIGDEFAULT.  */
public static final int posix_spawnattr_setsigdefault (posix_spawnattr_t/*P*/ __attr,
					  sigset_t/*P*/__sigdefault) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Store signal mask for the new process from ATTR in SIGMASK.  */
public static final int posix_spawnattr_getsigmask (posix_spawnattr_t/*P*/ 
				       __attr,
				       sigset_t/*P*/ __sigmask) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Set signal mask for the new process in ATTR to SIGMASK.  */
public static final int posix_spawnattr_setsigmask (posix_spawnattr_t/*P*/ __attr,
				       sigset_t/*P*/ __sigmask)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Get flag word from the attribute structure.  */
public static final int posix_spawnattr_getflags (posix_spawnattr_t/*P*/ 
				     __attr,
				     short$ptr __flags) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Store flags in the attribute structure.  */
public static final int posix_spawnattr_setflags (posix_spawnattr_t/*P*/_attr,
				     short __flags) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Get process group ID from the attribute structure.  */
public static final int posix_spawnattr_getpgroup (posix_spawnattr_t/*P*/ 
				      __attr, /*int$ptr  */int$ptr __pgroup)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Store process group ID in the attribute structure.  */
public static final int posix_spawnattr_setpgroup (posix_spawnattr_t/*P*/__attr,
				      /*pid_t*/int __pgroup) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Get scheduling policy from the attribute structure.  */
public static final int posix_spawnattr_getschedpolicy (posix_spawnattr_t/*P*/ 
					    __attr,
					   int$ptr __schedpolicy)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Store scheduling policy in the attribute structure.  */
public static final int posix_spawnattr_setschedpolicy (posix_spawnattr_t/*P*/__attr,
					   int __schedpolicy) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Get scheduling parameters from the attribute structure.  */
public static final int posix_spawnattr_getschedparam (posix_spawnattr_t/*P*/ 
					   __attr,
					  sched_param/*P*/
					  __schedparam) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Store scheduling parameters in the attribute structure.  */
public static final int posix_spawnattr_setschedparam (posix_spawnattr_t/*P*/ __attr,
					  sched_param/*P*/__schedparam) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Initialize data structure for file attribute for `spawn' call.  */
public static final int posix_spawn_file_actions_init (posix_spawn_file_actions_t/*P*/
					  __file_actions) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Free resources associated with FILE-ACTIONS.  */
public static final int posix_spawn_file_actions_destroy (posix_spawn_file_actions_t/*P*/
					     __file_actions) {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Add an action to FILE-ACTIONS which tells the implementation to call
   `open' for the given file during the `spawn' call.  */
public static final int posix_spawn_file_actions_addopen (posix_spawn_file_actions_t/*P*/
					      __file_actions,
					     int __fd,
					     char$ptr __path,
					     int __oflag, /*mode_t*/int __mode)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Add an action to FILE-ACTIONS which tells the implementation to call
   `close' for the given file descriptor during the `spawn' call.  */
public static final int posix_spawn_file_actions_addclose (posix_spawn_file_actions_t/*P*/
					      __file_actions, int __fd)
     {
  throw new UnsupportedOperationException("EmptyBody");
}

/* Add an action to FILE-ACTIONS which tells the implementation to call
   `dup2' for the given file descriptors during the `spawn' call.  */
public static final int posix_spawn_file_actions_adddup2 (posix_spawn_file_actions_t/*P*/
					     __file_actions,
					     int __fd, int __newfd) {
  throw new UnsupportedOperationException("EmptyBody");
}
}
