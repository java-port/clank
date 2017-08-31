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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// Optimization analysis message produced during vectorization. Messages inform
/// the user why vectorization did not occur.
//<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 40,
 FQN="llvm::LoopAccessReport", NM="_ZN4llvm16LoopAccessReportE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportE")
//</editor-fold>
public class LoopAccessReport implements Destructors.ClassWithDestructor {
  private std.string Message;
  private /*const*/ Instruction /*P*/ Instr;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::LoopAccessReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 45,
   FQN="llvm::LoopAccessReport::LoopAccessReport", NM="_ZN4llvm16LoopAccessReportC1ERKNS_5TwineEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportC1ERKNS_5TwineEPKNS_11InstructionE")
  //</editor-fold>
  protected LoopAccessReport(final /*const*/ Twine /*&*/ Message, /*const*/ Instruction /*P*/ I) {
    // : Message(Message.str()), Instr(I) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::LoopAccessReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 49,
   FQN="llvm::LoopAccessReport::LoopAccessReport", NM="_ZN4llvm16LoopAccessReportC1EPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportC1EPKNS_11InstructionE")
  //</editor-fold>
  public LoopAccessReport() {
    this((/*const*/ Instruction /*P*/ )null);
  }
  public LoopAccessReport(/*const*/ Instruction /*P*/ I/*= null*/) {
    // : Message(), Instr(I) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename A> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::operator<<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 51,
   FQN="llvm::LoopAccessReport::operator<<", NM="Tpl__ZN4llvm16LoopAccessReportlsERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=Tpl__ZN4llvm16LoopAccessReportlsERKT_")
  //</editor-fold>
  public </*typename*/ A> LoopAccessReport /*&*/ $out(final /*const*/ A /*&*/ Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::getInstr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 57,
   FQN="llvm::LoopAccessReport::getInstr", NM="_ZNK4llvm16LoopAccessReport8getInstrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16LoopAccessReport8getInstrEv")
  //</editor-fold>
  public /*const*/ Instruction /*P*/ getInstr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::str">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 59,
   FQN="llvm::LoopAccessReport::str", NM="_ZN4llvm16LoopAccessReport3strEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReport3strEv")
  //</editor-fold>
  public std.string/*&*/ str() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::str">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 60,
   FQN="llvm::LoopAccessReport::str", NM="_ZNK4llvm16LoopAccessReport3strEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16LoopAccessReport3strEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ str$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::operator Twine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 61,
   FQN="llvm::LoopAccessReport::operator Twine", NM="_ZN4llvm16LoopAccessReportcvNS_5TwineEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportcvNS_5TwineEEv")
  //</editor-fold>
  public Twine $Twine() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Emit an analysis note for \p PassName with the debug location from
  /// the instruction in \p Message if available.  Otherwise use the location of
  /// \p TheLoop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::emitAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 96,
   FQN="llvm::LoopAccessReport::emitAnalysis", NM="_ZN4llvm16LoopAccessReport12emitAnalysisERKS0_PKNS_8FunctionEPKNS_4LoopEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReport12emitAnalysisERKS0_PKNS_8FunctionEPKNS_4LoopEPKc")
  //</editor-fold>
  public static void emitAnalysis(final /*const*/ LoopAccessReport /*&*/ Message, 
              /*const*/ Function /*P*/ TheFunction, 
              /*const*/ Loop /*P*/ TheLoop, 
              /*const*/char$ptr/*char P*/ PassName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::LoopAccessReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 40,
   FQN="llvm::LoopAccessReport::LoopAccessReport", NM="_ZN4llvm16LoopAccessReportC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LoopAccessReport(final /*const*/ LoopAccessReport /*&*/ $Prm0) {
    // : Message(.Message), Instr(.Instr) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::LoopAccessReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 40,
   FQN="llvm::LoopAccessReport::LoopAccessReport", NM="_ZN4llvm16LoopAccessReportC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportC1EOS0_")
  //</editor-fold>
  public /*inline*/ LoopAccessReport(JD$Move _dparam, final LoopAccessReport /*&&*/$Prm0) {
    // : Message(static_cast<LoopAccessReport &&>().Message), Instr(static_cast<LoopAccessReport &&>().Instr) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 40,
   FQN="llvm::LoopAccessReport::operator=", NM="_ZN4llvm16LoopAccessReportaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportaSERKS0_")
  //</editor-fold>
  public /*inline*/ LoopAccessReport /*&*/ $assign(final /*const*/ LoopAccessReport /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 40,
   FQN="llvm::LoopAccessReport::operator=", NM="_ZN4llvm16LoopAccessReportaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportaSEOS0_")
  //</editor-fold>
  public /*inline*/ LoopAccessReport /*&*/ $assignMove(final LoopAccessReport /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessReport::~LoopAccessReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 40,
   FQN="llvm::LoopAccessReport::~LoopAccessReport", NM="_ZN4llvm16LoopAccessReportD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16LoopAccessReportD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Message=" + Message // NOI18N
              + ", Instr=" + Instr; // NOI18N
  }
}
