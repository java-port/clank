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
public class io_ioctl extends std_errors {
  
  //////////////////////////////////////////////////////////////////////////////
  // ioctl-types.h
  
  public static final class winsize {
    public /*ushort*/char ws_row;
    public /*ushort*/char ws_col;
    public /*ushort*/char ws_xpixel;
    public /*ushort*/char ws_ypixel;
  };

  public static final int NCC = 8;
  public static final class termio {
    public /*ushort*/char c_iflag;		/* input mode flags */
    public /*ushort*/char c_oflag;		/* output mode flags */
    public /*ushort*/char c_cflag;		/* control mode flags */
    public /*ushort*/char c_lflag;		/* local mode flags */
    public /*uchar*/byte c_line;		/* line discipline */
    public /*uchar*/byte c_cc[] = new byte[NCC];		/* control characters */
  };

  /* modem lines */
  public static final char TIOCM_LE = 0x001;
  public static final char TIOCM_DTR = 0x002;
  public static final char TIOCM_RTS = 0x004;
  public static final char TIOCM_ST = 0x008;
  public static final char TIOCM_SR = 0x010;
  public static final char TIOCM_CTS = 0x020;
  public static final char TIOCM_CAR = 0x040;
  public static final char TIOCM_RNG = 0x080;
  public static final char TIOCM_DSR = 0x100;
  public static final char TIOCM_CD = TIOCM_CAR;
  public static final char TIOCM_RI = TIOCM_RNG;

  /* ioctl (fd, TIOCSERGETLSR, &result) where result may be as below */

  /* line disciplines */
  public static final byte N_TTY = 0;
  public static final byte N_SLIP = 1;
  public static final byte N_MOUSE = 2;
  public static final byte N_PPP = 3;
  public static final byte N_STRIP = 4;
  public static final byte N_AX25 = 5;
  public static final byte N_X25 = 6	/* X.25 async  */;
  public static final byte N_6PACK = 7;
  public static final byte N_MASC = 8	/* Mobitex module  */;
  public static final byte N_R3964 = 9	/* Simatic R3964 module  */;
  public static final byte N_PROFIBUS_FDL = 10	/* Profibus  */;
  public static final byte N_IRDA = 11	/* Linux IR  */;
  public static final byte N_SMSBLOCK = 12	/* SMS block mode  */;
  public static final byte N_HDLC = 13	/* synchronous HDLC  */;
  public static final byte N_SYNC_PPP = 14	/* synchronous PPP  */;
  
  
  //////////////////////////////////////////////////////////////////////////////
  // ioctls.h
  
  /*
   * These are the most common definitions for tty ioctl numbers.
   * Most of them do not use the recommended _IOC(), but there is
   * probably some source code out there hardcoding the number,
   * so we might as well use them for all new platforms.
   *
   * The architectures that use different values here typically
   * try to be compatible with some Unix variants for the same
   * architecture.
   */

  /* 0x54 is just a magic number to make these relatively unique ('T') */

  public static final int TCGETS = 0x5401;
  public static final int TCSETS = 0x5402;
  public static final int TCSETSW = 0x5403;
  public static final int TCSETSF = 0x5404;
  public static final int TCGETA = 0x5405;
  public static final int TCSETA = 0x5406;
  public static final int TCSETAW = 0x5407;
  public static final int TCSETAF = 0x5408;
  public static final int TCSBRK = 0x5409;
  public static final int TCXONC = 0x540A;
  public static final int TCFLSH = 0x540B;
  public static final int TIOCEXCL = 0x540C;
  public static final int TIOCNXCL = 0x540D;
  public static final int TIOCSCTTY = 0x540E;
  public static final int TIOCGPGRP = 0x540F;
  public static final int TIOCSPGRP = 0x5410;
  public static final int TIOCOUTQ = 0x5411;
  public static final int TIOCSTI = 0x5412;
  public static final int TIOCGWINSZ = 0x5413;
  public static final int TIOCSWINSZ = 0x5414;
  public static final int TIOCMGET = 0x5415;
  public static final int TIOCMBIS = 0x5416;
  public static final int TIOCMBIC = 0x5417;
  public static final int TIOCMSET = 0x5418;
  public static final int TIOCGSOFTCAR = 0x5419;
  public static final int TIOCSSOFTCAR = 0x541A;
  public static final int FIONREAD = 0x541B;
  public static final int TIOCINQ = FIONREAD;
  public static final int TIOCLINUX = 0x541C;
  public static final int TIOCCONS = 0x541D;
  public static final int TIOCGSERIAL = 0x541E;
  public static final int TIOCSSERIAL = 0x541F;
  public static final int TIOCPKT = 0x5420;
  public static final int FIONBIO = 0x5421;
  public static final int TIOCNOTTY = 0x5422;
  public static final int TIOCSETD = 0x5423;
  public static final int TIOCGETD = 0x5424;
  public static final int TCSBRKP = 0x5425	/* Needed for POSIX tcsendbreak() */;
  public static final int TIOCSBRK = 0x5427  /* BSD compatibility */;
  public static final int TIOCCBRK = 0x5428  /* BSD compatibility */;
  public static final int TIOCGSID = 0x5429  /* Return the session ID of FD */;
  //public static final int TCGETS2 = _IOR('T', 0x2A, struct termios2);
  //public static final int TCSETS2 = _IOW('T', 0x2B, struct termios2);
  //public static final int TCSETSW2 = _IOW('T', 0x2C, struct termios2);
  //public static final int TCSETSF2 = _IOW('T', 0x2D, struct termios2);
  //public static final int TIOCGRS485 = 0x542E;
  //#ifndef TIOCSRS485
  //public static final int TIOCSRS485 = 0x542F;
  //#endif
  //public static final int TIOCGPTN = _IOR('T', 0x30, unsigned int) /* Get Pty Number (of pty-mux device) */;
  //public static final int TIOCSPTLCK = _IOW('T', 0x31, int)  /* Lock/unlock Pty */;
  //public static final int TIOCGDEV = _IOR('T', 0x32, unsigned int) /* Get primary device node of /dev/console */;
  public static final int TCGETX = 0x5432 /* SYS5 TCGETX compatibility */;
  public static final int TCSETX = 0x5433;
  public static final int TCSETXF = 0x5434;
  public static final int TCSETXW = 0x5435;
  //public static final int TIOCSIG = _IOW('T', 0x36, int)  /* pty: generate signal */;
  public static final int TIOCVHANGUP = 0x5437;
  //public static final int TIOCGPKT = _IOR('T', 0x38, int) /* Get packet mode state */;
  //public static final int TIOCGPTLCK = _IOR('T', 0x39, int) /* Get Pty lock state */;
  //public static final int TIOCGEXCL = _IOR('T', 0x40, int) /* Get exclusive mode state */;

  public static final int FIONCLEX = 0x5450;
  public static final int FIOCLEX = 0x5451;
  public static final int FIOASYNC = 0x5452;
  public static final int TIOCSERCONFIG = 0x5453;
  public static final int TIOCSERGWILD = 0x5454;
  public static final int TIOCSERSWILD = 0x5455;
  public static final int TIOCGLCKTRMIOS = 0x5456;
  public static final int TIOCSLCKTRMIOS = 0x5457;
  public static final int TIOCSERGSTRUCT = 0x5458 /* For debugging only */;
  public static final int TIOCSERGETLSR = 0x5459 /* Get line status register */;
  public static final int TIOCSERGETMULTI = 0x545A /* Get multiport config  */;
  public static final int TIOCSERSETMULTI = 0x545B /* Set multiport config */;

  public static final int TIOCMIWAIT = 0x545C	/* wait for a change on serial input line(s) */;
  public static final int TIOCGICOUNT = 0x545D	/* read serial port __inline__ interrupt counts */;

  /*
   * Some arches already define FIOQSIZE due to a historical
   * conflict with a Hayes modem-specific ioctl value.
   */
  //#ifndef FIOQSIZE
  //# define FIOQSIZE	0x5460
  //#endif

  /* Used for packet mode */
  public static final int TIOCPKT_DATA = 0;
  public static final int TIOCPKT_FLUSHREAD = 1;
  public static final int TIOCPKT_FLUSHWRITE = 2;
  public static final int TIOCPKT_STOP = 4;
  public static final int TIOCPKT_START = 8;
  public static final int TIOCPKT_NOSTOP = 16;
  public static final int TIOCPKT_DOSTOP = 32;
  public static final int TIOCPKT_IOCTL = 64;

  public static final int TIOCSER_TEMT = 0x01	/* Transmitter physically empty */;
  
  //////////////////////////////////////////////////////////////////////////////
  // ioctl.h
  
  /* Perform the I/O control operation specified by REQUEST on FD.
   One argument may follow; its presence and type depend on REQUEST.
   Return value depends on REQUEST.  Usually -1 indicates error.  */
  public static int ioctl(int __fd, /*ulong*/long __request, Object ... args) {
    throw new UnsupportedOperationException("EmptyBody");
  }
}
