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

import java.lang.management.ManagementFactory;
import org.clank.support.Converted;
import org.clank.support.NativePointer;
import org.clank.support.aliases.char$ptr;

/**
 * #include <unistd.h>
 * 
 * @author Vladimir Voskresensky
 */
public class unistd {
  private unistd() {}
  
  //<editor-fold defaultstate="collapsed" desc="getsid">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "/usr/include/unistd.h", line = 671,
   FQN="getsid", NM="_Z6getsid",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_Z6getsid")
  //</editor-fold>
  public static int getsid(int __pid)/* throw()*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }  
  
  //<editor-fold defaultstate="collapsed" desc="getpid">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "/usr/include/unistd.h", line = 628,
   FQN="getpid", NM="_Z6getpid",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_Z6getpid")
  //</editor-fold>
  public static int getpid()/* throw()*/ {
    return gethostname$$.PID;
  }
  
  public static int gethostname(char$ptr OutBuf, int BufLen) {
    std.memcpy(OutBuf, gethostname$$.CLANK_HOSTNAME, std.min(gethostname$$.CLANK_HOSTNAME_LEN, BufLen));
    return 0;
  }
  
  private static final class gethostname$$ {
    private static final char$ptr CLANK_HOSTNAME;
    private static final int CLANK_HOSTNAME_LEN;
    private static final int PID;
    
    static {
      String pid_and_host = ManagementFactory.getRuntimeMXBean().getName();
      int pid = 0;
      String host = "";
      boolean inHost = false;
      for (int b = 0, e = pid_and_host.length(); b < e; b++) {
        if (inHost) {
          host = pid_and_host.substring(b);
          break;
        } else {
          final char ch = pid_and_host.charAt(b);
          if (Character.isDigit(ch)) {
            pid = pid*10 + (ch - '0');
          } else if (ch == '@') {
            inHost = true;
          } else {
            // error
            break;
          }
        }
      }
      if (host.isEmpty()) {
        host = "clank-hostname";
      }
      PID = pid;
      CLANK_HOSTNAME_LEN = host.length();
      CLANK_HOSTNAME = NativePointer.create_char$ptr_utf8(host);
    }
  }
  
}
