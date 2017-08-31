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

import org.clank.support.aliases.*;

public interface io_defines {
  // stdio.h
  public static final char$ptr P_tmpdir	= FileInfoCalculator.getTmpDir();
  
  // iso/stdio_iso.h
  public static final int 	BUFSIZ =	1024;
  public static final int   BLOCK_SIZE = FileInfoCalculator.getBlockSize();

  /*
   * The value of _NFILE is defined in the Processor Specific ABI.  The value
   * is chosen for historical reasons rather than for truly processor related
   * attribute.  Note that the SPARC Processor Specific ABI uses the common
   * UNIX historical value of 20 so it is allowed to fall through.
   */
  //#if defined(__i386)
  public static final int 	_NFILE = 60;	/* initial number of streams: Intel x86 ABI */
  //#else
  //public static final int 	_NFILE = 20;	/* initial number of streams: SPARC ABI and default */
  //#endif

  public static final int _SBFSIZ	  = 8;	/* compatibility with shared libs */

  public static final int _IOFBF		= 0000;	/* full buffered */
  public static final int _IOLBF		= 0100;	/* line buffered */
  public static final int _IONBF		= 0004;	/* not buffered */
  public static final int _IOEOF		= 0020;	/* EOF reached on read */
  public static final int _IOERR		= 0040;	/* I/O error from system */

  public static final int _IOREAD		= 0001;	/* currently reading */
  public static final int _IOWRT		= 0002;	/* currently writing */
  public static final int _IORW		  = 0200;	/* opened for reading and writing */
  public static final int _IOMYBUF	= 0010;	/* stdio malloc()'d buffer */

  public static final int EOF	= (-1);

  public static final int FOPEN_MAX	= _NFILE;
  public static final int FILENAME_MAX  =  1024;	/* max # of characters in a path name */
  public static final int MAXPATHLEN  =  1024;	/* max # of characters in a path name */

  public static final int SEEK_SET = 0;
  public static final int SEEK_CUR = 1;
  public static final int SEEK_END = 2;

  public static final int TMP_MAX	 =	26 * 26 * 26;
  /////////////////////////// 
  // end of iso/stdio_iso.h
  ///////////////////////////  
  
  // fcntl-linux.h

  /* open/fcntl.  */
  public static final int O_ACCMODE = 0003;
  public static final int O_RDONLY = 00;
  public static final int O_WRONLY = 01;
  public static final int O_RDWR = 02;
  //#ifndef O_CREAT
  public static final int O_CREAT = 0100;	/* Not fcntl.  */
  //#endif
  //#ifndef O_EXCL
  public static final int O_EXCL = 0200;	/* Not fcntl.  */
  //#endif
  //#ifndef O_NOCTTY
  public static final int O_NOCTTY = 0400;	/* Not fcntl.  */
  //#endif
  //#ifndef O_TRUNC
  public static final int O_TRUNC = 01000;	/* Not fcntl.  */
  //#endif
  //#ifndef O_APPEND
  public static final int O_APPEND = 02000;
  //#endif
  //#ifndef O_NONBLOCK
  public static final int O_NONBLOCK = 04000;
  //#endif
  //#ifndef O_NDELAY
  public static final int O_NDELAY = O_NONBLOCK;
  //#endif
  //#ifndef O_SYNC
  public static final int O_SYNC = 04010000;
  //#endif
  public static final int O_FSYNC = O_SYNC;
  //#ifndef O_ASYNC
  public static final int O_ASYNC = 020000;
  //#endif
  //#ifndef __O_LARGEFILE
  public static final int __O_LARGEFILE = 0100000;
  //#endif

  //#ifndef __O_DIRECTORY
  public static final int __O_DIRECTORY = 0200000;
  //#endif
  //#ifndef __O_NOFOLLOW
  public static final int __O_NOFOLLOW = 0400000;
  //#endif
  //#ifndef __O_CLOEXEC
  public static final int __O_CLOEXEC = 02000000;
  //#endif
  //#ifndef __O_DIRECT
  public static final int __O_DIRECT = 040000;
  //#endif
  //#ifndef __O_NOATIME
  public static final int __O_NOATIME = 01000000;
  //#endif
  //#ifndef __O_PATH
  public static final int __O_PATH = 010000000;
  //#endif
  //#ifndef __O_DSYNC
  public static final int __O_DSYNC = 010000;
  //#endif
  //#ifndef __O_TMPFILE
  public static final int __O_TMPFILE = 020200000;
  //#endif

  //#ifndef F_GETLK
  //# ifndef __USE_FILE_OFFSET64
  public static final int F_GETLK = 5;	/* Get record locking info.  */
  public static final int F_SETLK = 6;	/* Set record locking info (non-blocking).  */
  public static final int F_SETLKW = 7;	/* Set record locking info (blocking).	*/
  //# else
  //public static final int F_GETLK = F_GETLK64;  /* Get record locking info.	*/
  //public static final int F_SETLK = F_SETLK64;  /* Set record locking info (non-blocking).*/
  //public static final int F_SETLKW = F_SETLKW64; /* Set record locking info (blocking).  */
  //# endif
  //#endif
  //#ifndef F_GETLK64
  public static final int F_GETLK64 = 12;	/* Get record locking info.  */
  public static final int F_SETLK64 = 13;	/* Set record locking info (non-blocking).  */
  public static final int F_SETLKW64 = 14;	/* Set record locking info (blocking).	*/
  //#endif

  //#ifdef __USE_LARGEFILE64
  public static final int O_LARGEFILE = __O_LARGEFILE;
  //#endif

  //#ifdef __USE_XOPEN2K8
  public static final int O_DIRECTORY = __O_DIRECTORY;	/* Must be a directory.	 */
  public static final int O_NOFOLLOW = __O_NOFOLLOW;	/* Do not follow links.	 */
  public static final int O_CLOEXEC = __O_CLOEXEC;	/* Set close_on_exec.  */
  //#endif

  //#ifdef __USE_GNU
  public static final int O_DIRECT = __O_DIRECT;	/* Direct disk access.	*/
  public static final int O_NOATIME = __O_NOATIME;	/* Do not set atime.  */
  public static final int O_PATH = __O_PATH;	/* Resolve pathname but do not open file.  */
  public static final int O_TMPFILE = __O_TMPFILE;	/* Atomically create nameless file.  */
  //#endif

  /* For now, Linux has no separate synchronicitiy options for read
     operations.  We define O_RSYNC therefore as the same as O_SYNC
     since this is a superset.  */
  //#if defined __USE_POSIX199309 || defined __USE_UNIX98
  public static final int O_DSYNC = __O_DSYNC;	/* Synchronize data.  */
  //# if defined __O_RSYNC
  //public static final int O_RSYNC = __O_RSYNC;	/* Synchronize read operations.	 */
  //# else
  public static final int O_RSYNC = O_SYNC;		/* Synchronize read operations.	 */
  //# endif
  //#endif

  /* Values for the second argument to `fcntl'.  */
  public static final int F_DUPFD = 0;	/* Duplicate file descriptor.  */
  public static final int F_GETFD = 1;	/* Get file descriptor flags.  */
  public static final int F_SETFD = 2;	/* Set file descriptor flags.  */
  public static final int F_GETFL = 3;	/* Get file status flags.  */
  public static final int F_SETFL = 4;	/* Set file status flags.  */

  //#ifndef __F_SETOWN
  public static final int __F_SETOWN = 8;
  public static final int __F_GETOWN = 9;
  //#endif

  //#if defined __USE_BSD || defined __USE_UNIX98 || defined __USE_XOPEN2K8
  public static final int F_SETOWN = __F_SETOWN; /* Get owner (process receiving SIGIO).  */
  public static final int F_GETOWN = __F_GETOWN; /* Set owner (process receiving SIGIO).  */
  //#endif

  //#ifndef __F_SETSIG
  public static final int __F_SETSIG = 10;	/* Set number of signal to be sent.  */
  public static final int __F_GETSIG = 11;	/* Get number of signal to be sent.  */
  //#endif
  //#ifndef __F_SETOWN_EX
  public static final int __F_SETOWN_EX = 15;	/* Get owner (thread receiving SIGIO).  */
  public static final int __F_GETOWN_EX = 16;	/* Set owner (thread receiving SIGIO).  */
  //#endif

  //#ifdef __USE_GNU
  public static final int F_SETSIG = __F_SETSIG;	/* Set number of signal to be sent.  */
  public static final int F_GETSIG = __F_GETSIG;	/* Get number of signal to be sent.  */
  public static final int F_SETOWN_EX = __F_SETOWN_EX;	/* Get owner (thread receiving SIGIO).  */
  public static final int F_GETOWN_EX = __F_GETOWN_EX;	/* Set owner (thread receiving SIGIO).  */
  //#endif

  //#ifdef __USE_GNU
  public static final int F_SETLEASE = 1024;	/* Set a lease.	 */
  public static final int F_GETLEASE = 1025;	/* Enquire what lease is active.  */
  public static final int F_NOTIFY = 1026;	/* Request notifications on a directory.  */
  public static final int F_SETPIPE_SZ = 1031;	/* Set pipe page size array.  */
  public static final int F_GETPIPE_SZ = 1032;	/* Set pipe page size array.  */
  //#endif
  //#ifdef __USE_XOPEN2K8
  public static final int F_DUPFD_CLOEXEC = 1030;	/* Duplicate file descriptor with
             close-on-exit set.  */
  //#endif

  /* For F_[GET|SET]FD.  */
  public static final int FD_CLOEXEC = 1;	/* Actually anything with low bit set goes */

  //#ifndef F_RDLCK
  /* For posix fcntl() and `l_type' field of a `struct flock' for lockf().  */
  public static final int F_RDLCK = 0;	/* Read lock.  */
  public static final int F_WRLCK = 1;	/* Write lock.	*/
  public static final int F_UNLCK = 2;	/* Remove lock.	 */
  //#endif


  /* For old implementation of BSD flock.  */
  //#ifndef F_EXLCK
  public static final int F_EXLCK = 4;	/* or 3 */
  public static final int F_SHLCK = 8;	/* or 4 */
  //#endif

  //#ifdef __USE_BSD
  /* Operations for BSD flock, also used by the kernel implementation.  */
  public static final int LOCK_SH = 1;	/* Shared lock.  */
  public static final int LOCK_EX = 2;	/* Exclusive lock.  */
  public static final int LOCK_NB = 4;	/* Or'd with one of the above to prevent
             blocking.  */
  public static final int LOCK_UN = 8;	/* Remove lock.  */
  //#endif

  //#ifdef __USE_GNU
  public static final int LOCK_MAND = 32;	/* This is a mandatory flock:	*/
  public static final int LOCK_READ = 64;	/* ... which allows concurrent read operations.	 */
  public static final int LOCK_WRITE = 128;	/* ... which allows concurrent write operations.  */
  public static final int LOCK_RW = 192;	/* ... Which allows concurrent read & write operations.	 */
  //#endif

  //#ifdef __USE_GNU
  /* Types of directory notifications that may be requested with F_NOTIFY.  */
  public static final int DN_ACCESS = 0x00000001;	/* File accessed.  */
  public static final int DN_MODIFY = 0x00000002;	/* File modified.  */
  public static final int DN_CREATE = 0x00000004;	/* File created.  */
  public static final int DN_DELETE = 0x00000008;	/* File removed.  */
  public static final int DN_RENAME = 0x00000010;	/* File renamed.  */
  public static final int DN_ATTRIB = 0x00000020;	/* File changed attributes.  */
  public static final int DN_MULTISHOT = 0x80000000;	/* Don't remove notifier.  */
  //#endif


  //#ifdef __U/SE_GNU
  ///* Owner types.  */
  //enum __pid_type
  //  {
  //    F_OWNER_TID = 0,		/* Kernel thread.  */
  //    F_OWNER_PID,		/* Process.  */
  //    F_OWNER_PGRP,		/* Process group.  */
  //    F_OWNER_GID = F_OWNER_PGRP	/* Alternative, obsolete name.  */
  //  };
  //
  ///* Structure to use with F_GETOWN_EX and F_SETOWN_EX.  */
  //struct f_owner_ex
  //  {
  //    enum __pid_type type;	/* Owner type of ID.  */
  //    __pid_t pid;		/* ID of owner.  */
  //  };
  //#endif

  /* Define some more compatibility macros to be backward compatible with
     BSD systems which did not managed to hide these kernel macros.  */
  //#ifdef	__USE_BSD
  public static final int FAPPEND = O_APPEND;
  public static final int FFSYNC = O_FSYNC;
  public static final int FASYNC = O_ASYNC;
  public static final int FNONBLOCK = O_NONBLOCK;
  public static final int FNDELAY = O_NDELAY;
  //#endif /* Use BSD.  */

  //#ifndef __POSIX_FADV_DONTNEED
  public static final int __POSIX_FADV_DONTNEED = 4;
  public static final int __POSIX_FADV_NOREUSE = 5;
  //#endif
  /* Advise to `posix_fadvise'.  */
  //#ifdef __USE_XOPEN2K
  public static final int POSIX_FADV_NORMAL = 0; /* No further special treatment.  */
  public static final int POSIX_FADV_RANDOM = 1; /* Expect random page references.  */
  public static final int POSIX_FADV_SEQUENTIAL = 2; /* Expect sequential page references.	 */
  public static final int POSIX_FADV_WILLNEED = 3; /* Will need these pages.  */
  public static final int POSIX_FADV_DONTNEED = __POSIX_FADV_DONTNEED; /* Don't need these pages.  */
  public static final int POSIX_FADV_NOREUSE = __POSIX_FADV_NOREUSE; /* Data will be accessed once.  */
  //#endif


  //#ifdef __USE_GNU
  /* Flags for SYNC_FILE_RANGE.  */
  public static final int SYNC_FILE_RANGE_WAIT_BEFORE = 1; /* Wait upon writeout of all pages
                 in the range before performing the
                 write.  */
  public static final int SYNC_FILE_RANGE_WRITE = 2; /* Initiate writeout of all those
                 dirty pages in the range which are
                 not presently under writeback.  */
  public static final int SYNC_FILE_RANGE_WAIT_AFTER = 4; /* Wait upon writeout of all pages in
                 the range after performing the
                 write.  */

  /* Flags for SPLICE and VMSPLICE.  */
  public static final int SPLICE_F_MOVE = 1;	/* Move pages instead of copying.  */
  public static final int SPLICE_F_NONBLOCK = 2;	/* Don't block on the pipe splicing
               (but we may still block on the fd
               we splice from/to).  */
  public static final int SPLICE_F_MORE = 4;	/* Expect more data.  */
  public static final int SPLICE_F_GIFT = 8;	/* Pages passed in are a gift.  */


  /* Flags for fallocate.  */
  public static final int FALLOC_FL_KEEP_SIZE = 1; /* Don't extend size of file
                 even if offset + len is
                 greater than file size.  */
  public static final int FALLOC_FL_PUNCH_HOLE = 2; /* Create a hole in the file.  */


  /* File handle structure.  */
  public static final class file_handle
  {
    public /*uint*/int handle_bytes;
    public int handle_type;
    /* File identifier.  */
    /*uchar*/byte f_handle[/*0*/];
  }

  /* Maximum handle size (for now).  */
  public static final int MAX_HANDLE_SZ = 128;
  //#endif

  /* Values for `*at' functions.  */
  //#ifdef __USE_ATFILE
  public static final int AT_FDCWD = -100;	/* Special value used to indicate
               the *at functions should use the
               current working directory. */
  public static final int AT_SYMLINK_NOFOLLOW = 0x100;	/* Do not follow symbolic links.  */
  public static final int AT_REMOVEDIR = 0x200;	/* Remove directory instead of
               unlinking file.  */
  public static final int AT_SYMLINK_FOLLOW = 0x400;	/* Follow symbolic links.  */
  //# ifdef __USE_GNU
  public static final int AT_NO_AUTOMOUNT = 0x800;	/* Suppress terminal automount
               traversal.  */
  public static final int AT_EMPTY_PATH = 0x1000;	/* Allow empty relative pathname.  */
  //# endif
  public static final int AT_EACCESS = 0x200;	/* Test access permitted for
               effective IDs, not real IDs.  */
  //#endif
          
  /////////////////////////// 
  // end of fcntl-linux.h
  ///////////////////////////  
}
