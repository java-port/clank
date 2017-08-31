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

import static org.clank.java.errno_codes.EINTR;
import static org.clank.java.errno_codes.EINVAL;
import static org.clank.java.io.setErrno;
import org.clank.support.Native.NativePOD;
import static org.clank.support.Unsigned.$long2int;

/**
 * #include <time.h>
 * #include <sys/time.h>
 * 
 * @author Vladimir Voskresensky
 */
public class std_time {
  private std_time() {}
  
  public static final class/*struct*/  timeval {
    public long/*time_t*/		tv_sec;		/* seconds */
    public long/*suseconds_t*/tv_usec;	/* and microseconds */
  };

  public static final class/*struct*/ timezone {
    int	tz_minuteswest;	/* minutes west of Greenwich */
    int	tz_dsttime;	/* type of dst correction */
  };
  
  public static int gettimeofday(timeval out, timezone tz) {
    setErrno(0); 
    out.tv_sec = System.currentTimeMillis() / 1000;
    out.tv_usec = System.nanoTime();
    return 0;
  }
  
  public static final class/*struct*/ timespec implements NativePOD<timespec> {
    public long/*time_t*/ tv_sec; /* seconds */
    public long tv_nsec; /* and nanoseconds */

    public timespec() {
    }

    public timespec(timespec other) {
      this.tv_nsec = other.tv_nsec;
      this.tv_sec = other.tv_sec;
    }

    @Override
    public timespec $assign(timespec value) {
      this.tv_nsec = value.tv_nsec;
      this.tv_sec = value.tv_sec;
      return this;
    }

    @Override
    public timespec clone() {
      return new timespec(this);
    }

    @Override
    public boolean $noteq(timespec other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(timespec other) {
      return this.tv_nsec == other.tv_nsec && this.tv_sec == other.tv_sec;
    }
  }  
  
  /**
   *  nanosleep - high-resolution sleep.
   * 
   *   nanosleep() suspends the execution of the calling thread until either
   *   at least the time specified in *req has elapsed, or the delivery of a
   *   signal that triggers the invocation of a handler in the calling
   *   thread or that terminates the process.
   *
   *   If the call is interrupted by a signal handler, nanosleep() returns
   *   -1, sets errno to EINTR, and writes the remaining time into the
   *   structure pointed to by rem unless rem is NULL.  The value of *rem
   *   can then be used to call nanosleep() again and complete the specified
   *   pause (but see NOTES).
   *
   *   The value of the nanoseconds field must be in the range 0 to
   *   999999999.
   *
   *   Compared to sleep(3) and usleep(3), nanosleep() has the following
   *   advantages: it provides a higher resolution for specifying the sleep
   *   interval; POSIX.1 explicitly specifies that it does not interact with
   *   signals; and it makes the task of resuming a sleep that has been
   *   interrupted by a signal handler easier.
   * 
   * RETURN VALUE
   *
   * On successfully sleeping for the requested interval, nanosleep() returns 0.
   * If the call is interrupted by a signal handler or encounters an error, then
   * it returns -1, with errno set to indicate the error.
   *
   * ERRORS
   *
   *   EFAULT Problem with copying information from user space.
   *  
   *   EINTR The pause has been interrupted by a signal that was delivered to the
   *   thread (see signal(7)). The remaining sleep time has been written into *rem
   *   so that the thread can easily call nanosleep() again and continue with the
   *   pause.
   *  
   *   EINVAL The value in the tv_nsec field was not in the range 0 to 999999999
   *   or tv_sec was negative.
   */     
  public static int nanosleep(/*const*/ timespec /*P*/ req, /*const*/ timespec /*P*/ rem) {
    setErrno(0); 
    assert req != null;
    if (req.tv_sec < 0 || req.tv_nsec < 0 || req.tv_nsec > 999999999) {
      setErrno(EINVAL); 
      return -1;
    }
    try {
      Thread.sleep(req.tv_sec * 1000, $long2int(req.tv_nsec));
      return 0;
    } catch (InterruptedException ex) {
      setErrno(EINTR);
      return -1;
    }
  }
}
