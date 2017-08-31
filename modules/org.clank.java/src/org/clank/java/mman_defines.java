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
 * /usr/include/bits/mman.h
 * @author vv159170
 */
public interface mman_defines {
/* The following definitions basically come from the kernel headers.
   But the kernel header is not namespace clean.  */


/* Protections are chosen from these bits, OR'd together.  The
   implementation does not necessarily support PROT_EXEC or PROT_WRITE
   without PROT_READ.  The only guarantees are that no writing will be
   allowed without PROT_WRITE and no access will be allowed for PROT_NONE. */

public static final int PROT_READ = 0x1;		/* Page can be read.  */
public static final int PROT_WRITE = 0x2;		/* Page can be written.  */
public static final int PROT_EXEC = 0x4;		/* Page can be executed.  */
public static final int PROT_NONE = 0x0;		/* Page can not be accessed.  */
public static final int PROT_GROWSDOWN = 0x01000000;	/* Extend change to start of
					   growsdown vma (mprotect only).  */
public static final int PROT_GROWSUP = 0x02000000;	/* Extend change to start of
					   growsup vma (mprotect only).  */

/* Sharing types (must choose one and only one of these).  */
public static final int MAP_SHARED = 0x01;		/* Share changes.  */
public static final int MAP_PRIVATE	= 0x02;		/* Changes are private.  */
//#ifdef __USE_MISC
public static final int MAP_TYPE = 0x0f;		/* Mask for type of mapping.  */
//#endif

/* Other flags.  */
public static final int MAP_FIXED = 0x10;		/* Interpret addr exactly.  */
//#ifdef __USE_MISC
public static final int MAP_FILE = 0;
public static final int MAP_ANONYMOUS = 0x20;		/* Don't use a file.  */
public static final int MAP_ANON = MAP_ANONYMOUS;
public static final int MAP_32BIT = 0x40;		/* Only give out 32-bit addresses.  */
//#endif

/* These are Linux-specific.  */
//#ifdef __USE_MISC
public static final int MAP_GROWSDOWN = 0x00100;		/* Stack-like segment.  */
public static final int MAP_DENYWRITE = 0x00800;		/* ETXTBSY */
public static final int MAP_EXECUTABLE = 0x01000;		/* Mark it as an executable.  */
public static final int MAP_LOCKED = 0x02000;		/* Lock the mapping.  */
public static final int MAP_NORESERVE = 0x04000;		/* Don't check for reservations.  */
public static final int MAP_POPULATE = 0x08000;		/* Populate (prefault) pagetables.  */
public static final int MAP_NONBLOCK = 0x10000;		/* Do not block on IO.  */
public static final int MAP_STACK = 0x20000;		/* Allocation is for a stack.  */
//#endif

/* Flags to `msync'.  */
public static final int MS_ASYNC = 1;		/* Sync memory asynchronously.  */
public static final int MS_SYNC = 4;		/* Synchronous memory sync.  */
public static final int MS_INVALIDATE = 2;		/* Invalidate the caches.  */

/* Flags for `mlockall'.  */
public static final int MCL_CURRENT = 1;		/* Lock all currently mapped pages.  */
public static final int MCL_FUTURE = 2;		/* Lock all additions to address
					   space.  */

/* Flags for `mremap'.  */
//#ifdef __USE_GNU
public static final int MREMAP_MAYMOVE = 1;
public static final int MREMAP_FIXED = 2;
//#endif

/* Advice to `madvise'.  */
//#ifdef __USE_BSD
public static final int MADV_NORMAL = 0;	/* No further special treatment.  */
public static final int MADV_RANDOM = 1;	/* Expect random page references.  */
public static final int MADV_SEQUENTIAL = 2;	/* Expect sequential page references.  */
public static final int MADV_WILLNEED = 3;	/* Will need these pages.  */
public static final int MADV_DONTNEED = 4;	/* Don't need these pages.  */
public static final int MADV_REMOVE = 9;	/* Remove these pages and resources.  */
public static final int MADV_DONTFORK = 10;	/* Do not inherit across fork.  */
public static final int MADV_DOFORK = 11;	/* Do inherit across fork.  */
public static final int MADV_MERGEABLE = 12;	/* KSM may merge identical pages.  */
public static final int MADV_UNMERGEABLE = 13;	/* KSM may not merge identical pages.  */
public static final int MADV_HWPOISON = 100;	/* Poison a page for testing.  */
//#endif

/* The POSIX people had to invent similar names for the same things.  */
//#ifdef __USE_XOPEN2K
public static final int POSIX_MADV_NORMAL = 0; /* No further special treatment.  */
public static final int POSIX_MADV_RANDOM = 1; /* Expect random page references.  */
public static final int POSIX_MADV_SEQUENTIAL = 2; /* Expect sequential page references.  */
public static final int POSIX_MADV_WILLNEED = 3; /* Will need these pages.  */
public static final int POSIX_MADV_DONTNEED = 4; /* Don't need these pages.  */
//#endif  
}
