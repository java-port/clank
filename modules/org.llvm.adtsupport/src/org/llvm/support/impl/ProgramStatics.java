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

package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.spi.ExecuteProgramProvider;
import org.llvm.support.sys.*;
import org.openide.util.Lookup;


//<editor-fold defaultstate="collapsed" desc="static type ProgramStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZL7ExecuteRN4llvm3sys11ProcessInfoENS_9StringRefEPPKcS6_PPKS3_jPSs; -static-type=ProgramStatics")
//</editor-fold>
public final class ProgramStatics {


  //===----------------------------------------------------------------------===//
  //=== WARNING: Implementation here must contain only TRULY operating system
  //===          independent code.
  //===----------------------------------------------------------------------===//
  
  
  //<editor-fold defaultstate="collapsed" desc="Execute">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 181,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 168,
   FQN = "Execute", NM = "_ZL7ExecuteRN4llvm3sys11ProcessInfoENS_9StringRefEPPKcS6_PPKS3_jPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZL7ExecuteRN4llvm3sys11ProcessInfoENS_9StringRefEPPKcS6_PPKS3_jPSs")
  //</editor-fold>
  public static boolean Execute(ProcessInfo /*&*/ PI, StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
         /*const*/type$ptr<char$ptr>/*char PP*/ envp, /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects, 
         /*uint*/int memoryLimit, std.string/*P*/ ErrMsg) throws Throwable {
    ExecuteProgramProvider provider = findExecuteProvider(Program);
    if (provider == null) {
      llvm.errs().$out("Execute is not yet implemented for ").$out(Program).$out($LF);
      llvm.errs().$out("Implement ExecuteProgramProvider in corresponding module as @ServiceProvider\n");
      throw new UnsupportedOperationException("trying to invoke " + Program.toJavaString() + " natively with args:" + args);
    }
    return provider.Execute(PI, Program, args, envp, redirects, memoryLimit, ErrMsg);
  }

  

  private static ExecuteProgramProvider findExecuteProvider(StringRef Program) {
    ExecuteProgramProvider out = null;
    for (ExecuteProgramProvider p : Lookup.getDefault().lookupAll(ExecuteProgramProvider.class)) {
      if (p.canExecute(Program)) {
        if (out == null) {
          out = p;
        } else {
          llvm.errs().$out("Providers collision for ").$out(Program).$out($LF);
          llvm.errs().$out("Found ").$out(out.getClass().getName());
          llvm.errs().$out(" and ").$out(out.getClass().getName()).$out($LF);
        }
      }
    }
    return out;
  }

} // END OF class ProgramStatics
