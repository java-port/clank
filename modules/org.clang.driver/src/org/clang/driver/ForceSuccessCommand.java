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

package org.clang.driver;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
;


/// Like Command, but always pretends that the wrapped command succeeded.
//<editor-fold defaultstate="collapsed" desc="clang::driver::ForceSuccessCommand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 142,
 FQN="clang::driver::ForceSuccessCommand", NM="_ZN5clang6driver19ForceSuccessCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver19ForceSuccessCommandE")
//</editor-fold>
public class ForceSuccessCommand extends /*public*/ Command implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ForceSuccessCommand::ForceSuccessCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 313,
   FQN="clang::driver::ForceSuccessCommand::ForceSuccessCommand", NM="_ZN5clang6driver19ForceSuccessCommandC1ERKNS0_6ActionERKNS0_4ToolEPKcRKN4llvm11SmallVectorIS9_Lj16EEENSA_8ArrayRefINS0_9InputInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver19ForceSuccessCommandC1ERKNS0_6ActionERKNS0_4ToolEPKcRKN4llvm11SmallVectorIS9_Lj16EEENSA_8ArrayRefINS0_9InputInfoEEE")
  //</editor-fold>
  public ForceSuccessCommand(/*const*/ Action /*&*/ Source_, 
      /*const*/ Tool /*&*/ Creator_, 
      /*const*/char$ptr/*char P*/ Executable_, 
      /*const*/ArgStringList/*&*/ Arguments_, 
      ArrayRef<InputInfo> Inputs) {
    /* : Command(Source_, Creator_, Executable_, Arguments_, Inputs)*/ 
    //START JInit
    super(Source_, Creator_, Executable_, Arguments_, new ArrayRef<InputInfo>(Inputs));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ForceSuccessCommand::Print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 320,
   FQN="clang::driver::ForceSuccessCommand::Print", NM="_ZNK5clang6driver19ForceSuccessCommand5PrintERN4llvm11raw_ostreamEPKcbPNS0_15CrashReportInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver19ForceSuccessCommand5PrintERN4llvm11raw_ostreamEPKcbPNS0_15CrashReportInfoE")
  //</editor-fold>
  @Override public void Print(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Terminator, 
       boolean Quote) /*const*//* override*/ {
    Print(OS, Terminator, 
       Quote, (CrashReportInfo /*P*/ )null);
  }
  @Override public void Print(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Terminator, 
       boolean Quote, CrashReportInfo /*P*/ CrashInfo/*= null*/) /*const*//* override*/ {
    super.Print(OS, $EMPTY, Quote, CrashInfo);
    OS.$out(/*KEEP_STR*/" || (exit 0)").$out(Terminator);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::ForceSuccessCommand::Execute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 326,
   FQN="clang::driver::ForceSuccessCommand::Execute", NM="_ZNK5clang6driver19ForceSuccessCommand7ExecuteEPPKN4llvm9StringRefEPSsPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver19ForceSuccessCommand7ExecuteEPPKN4llvm9StringRefEPSsPb")
  //</editor-fold>
  @Override public int Execute(/*const*/type$ptr<StringRef> Redirects, 
         std.string/*P*/ ErrMsg, 
         bool$ptr/*bool P*/ ExecutionFailed) /*const*//* override*/ {
    int Status = super.Execute(Redirects, ErrMsg, ExecutionFailed);
    //(void)Status;
    if ((ExecutionFailed != null)) {
      ExecutionFailed.$set(false);
    }
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::ForceSuccessCommand::~ForceSuccessCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 142,
   FQN="clang::driver::ForceSuccessCommand::~ForceSuccessCommand", NM="_ZN5clang6driver19ForceSuccessCommandD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver19ForceSuccessCommandD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
