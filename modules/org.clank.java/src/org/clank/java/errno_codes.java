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
public interface errno_codes {
 //////////////////////////////////////////////////////////////////////////////
 // errno.h
/*
 * Error codes
 */

public static final int EPERM = 1; /* Not super-user  */
public static final int ENOENT = 2; /* No such file or directory */
public static final int ESRCH = 3; /* No such process  */
public static final int EINTR = 4; /* interrupted system call */
public static final int EIO = 5; /* I/O error  */
public static final int ENXIO = 6; /* No such device or address */
public static final int E2BIG = 7; /* Arg list too long  */
public static final int ENOEXEC = 8; /* Exec format error  */
public static final int EBADF = 9; /* Bad file number  */
public static final int ECHILD = 10; /* No children  */
public static final int EAGAIN = 11; /* Resource temporarily unavailable */
public static final int ENOMEM = 12; /* Not enough core  */
public static final int EACCES = 13; /* Permission denied  */
public static final int EFAULT = 14; /* Bad address  */
public static final int ENOTBLK = 15; /* Block device required */
public static final int EBUSY = 16; /* Mount device busy  */
public static final int EEXIST = 17; /* File exists  */
public static final int EXDEV = 18; /* Cross-device link  */
public static final int ENODEV = 19; /* No such device  */
public static final int ENOTDIR = 20; /* Not a directory  */
public static final int EISDIR = 21; /* Is a directory  */
public static final int EINVAL = 22; /* Invalid argument  */
public static final int ENFILE = 23; /* File table overflow  */
public static final int EMFILE = 24; /* Too many open files  */
public static final int ENOTTY = 25; /* Inappropriate ioctl for device */
public static final int ETXTBSY = 26; /* Text file busy  */
public static final int EFBIG = 27; /* File too large  */
public static final int ENOSPC = 28; /* No space left on device */
public static final int ESPIPE = 29; /* Illegal seek  */
public static final int EROFS = 30; /* Read only file system */
public static final int EMLINK = 31; /* Too many links  */
public static final int EPIPE = 32; /* Broken pipe  */
public static final int EDOM = 33; /* Math arg out of domain of func */
public static final int ERANGE = 34; /* Math result not representable */
public static final int ENOMSG = 35; /* No message of desired type */
public static final int EIDRM = 36; /* Identifier removed  */
public static final int ECHRNG = 37; /* Channel number out of range */
public static final int EL2NSYNC = 38; /* Level 2 not synchronized */
public static final int EL3HLT = 39; /* Level 3 halted  */
public static final int EL3RST = 40; /* Level 3 reset  */
public static final int ELNRNG = 41; /* Link number out of range */
public static final int EUNATCH = 42;/* Protocol driver not attached */
public static final int ENOCSI = 43; /* No CSI structure available */
public static final int EL2HLT = 44; /* Level 2 halted  */
public static final int EDEADLK = 45; /* Deadlock condition.  */
public static final int ENOLCK = 46; /* No record locks available. */
public static final int ECANCELED = 47; /* Operation canceled  */
public static final int ENOTSUP = 48; /* Operation not supported */

/* Filesystem Quotas */
public static final int EDQUOT = 49; /* Disc quota exceeded  */

/* Convergent Error Returns */
public static final int EBADE = 50; /* invalid exchange  */
public static final int EBADR = 51; /* invalid request descriptor */
public static final int EXFULL = 52; /* exchange full  */
public static final int ENOANO = 53; /* no anode  */
public static final int EBADRQC = 54; /* invalid request code  */
public static final int EBADSLT = 55; /* invalid slot  */
public static final int EDEADLOCK = 56; /* file locking deadlock error */

public static final int EBFONT = 57; /* bad font file fmt  */

/* Interprocess Robust Locks */
public static final int EOWNERDEAD = 58; /* process died with the lock */
public static final int ENOTRECOVERABLE = 59; /* lock is not recoverable */

/* stream problems */
public static final int ENOSTR = 60; /* Device not a stream  */
public static final int ENODATA = 61; /* no data (for no delay io) */
public static final int ETIME = 62; /* timer expired  */
public static final int ENOSR = 63; /* out of streams resources */

public static final int ENONET = 64; /* Machine is not on the network */
public static final int ENOPKG = 65; /* Package not installed */
public static final int EREMOTE = 66; /* The object is remote  */
public static final int ENOLINK = 67; /* the link has been severed */
public static final int EADV = 68; /* advertise error  */
public static final int ESRMNT = 69; /* srmount error  */

public static final int ECOMM = 70; /* Communication error on send */
public static final int EPROTO = 71; /* Protocol error  */

/* Interprocess Robust Locks */
public static final int ELOCKUNMAPPED = 72; /* locked lock was unmapped */

public static final int ENOTACTIVE = 73; /* Facility is not active */
public static final int EMULTIHOP = 74; /* multihop attempted  */
public static final int EBADMSG = 77; /* trying to read unreadable message */
public static final int ENAMETOOLONG = 78; /* path name is too long */
public static final int EOVERFLOW = 79; /* value too large to be stored in data type */
public static final int ENOTUNIQ = 80; /* given log. name not unique */
public static final int EBADFD = 81; /* f.d. invalid for this operation */
public static final int EREMCHG = 82; /* Remote address changed */

/* shared library problems */
public static final int ELIBACC = 83; /* Can't access a needed shared lib. */
public static final int ELIBBAD = 84; /* Accessing a corrupted shared lib. */
public static final int ELIBSCN = 85; /* .lib section in a.out corrupted. */
public static final int ELIBMAX = 86; /* Attempting to link in too many libs. */
public static final int ELIBEXEC = 87; /* Attempting to exec a shared library. */
public static final int EILSEQ = 88; /* Illegal byte sequence. */
public static final int ENOSYS = 89; /* Unsupported file system operation */
public static final int ELOOP = 90; /* Symbolic link loop  */
public static final int ERESTART = 91; /* Restartable system call */
public static final int ESTRPIPE = 92; /* if pipe/FIFO, don't sleep in stream head */
public static final int ENOTEMPTY = 93; /* directory not empty  */
public static final int EUSERS = 94; /* Too many users (for UFS) */

/* BSD Networking Software */
 /* argument errors */
public static final int ENOTSOCK = 95; /* Socket operation on non-socket */
public static final int EDESTADDRREQ = 96; /* Destination address required */
public static final int EMSGSIZE = 97; /* Message too long */
public static final int EPROTOTYPE = 98; /* Protocol wrong type for socket */
public static final int ENOPROTOOPT = 99; /* Protocol not available */
public static final int EPROTONOSUPPORT = 120; /* Protocol not supported */
public static final int ESOCKTNOSUPPORT = 121; /* Socket type not supported */
public static final int EOPNOTSUPP = 122; /* Operation not supported on socket */
public static final int EPFNOSUPPORT = 123; /* Protocol family not supported */
public static final int EAFNOSUPPORT = 124; /* Address family not supported by */
  /* protocol family */
public static final int EADDRINUSE = 125; /* Address already in use */
public static final int EADDRNOTAVAIL = 126; /* Can't assign requested address */
 /* operational errors */
public static final int ENETDOWN = 127; /* Network is down */
public static final int ENETUNREACH = 128; /* Network is unreachable */
public static final int ENETRESET = 129; /* Network dropped connection because */
  /* of reset */
public static final int ECONNABORTED = 130; /* Software caused connection abort */
public static final int ECONNRESET = 131; /* Connection reset by peer */
public static final int ENOBUFS = 132; /* No buffer space available */
public static final int EISCONN = 133; /* Socket is already connected */
public static final int ENOTCONN = 134; /* Socket is not connected */
/* XENIX has 135 - 142 */
public static final int ESHUTDOWN = 143; /* Can't send after socket shutdown */
public static final int ETOOMANYREFS = 144; /* Too many references: can't splice */
public static final int ETIMEDOUT = 145; /* Connection timed out */
public static final int ECONNREFUSED = 146; /* Connection refused */
public static final int EHOSTDOWN = 147; /* Host is down */
public static final int EHOSTUNREACH = 148; /* No route to host */
public static final int EWOULDBLOCK = EAGAIN;
public static final int EALREADY = 149; /* operation already in progress */
public static final int EINPROGRESS = 150; /* operation now in progress */

/* SUN Network File System */
public static final int ESTALE = 151; /* Stale NFS file handle */ 

}
