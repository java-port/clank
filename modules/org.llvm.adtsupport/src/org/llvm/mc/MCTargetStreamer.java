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

package org.llvm.mc;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// Target specific streamer interface. This is used so that targets can
/// implement support for target specific assembly directives.
///
/// If target foo wants to use this, it should implement 3 classes:
/// * FooTargetStreamer : public MCTargetStreamer
/// * FooTargetAsmStreamer : public FooTargetStreamer
/// * FooTargetELFStreamer : public FooTargetStreamer
///
/// FooTargetStreamer should have a pure virtual method for each directive. For
/// example, for a ".bar symbol_name" directive, it should have
/// virtual emitBar(const MCSymbol &Symbol) = 0;
///
/// The FooTargetAsmStreamer and FooTargetELFStreamer classes implement the
/// method. The assembly streamer just prints ".bar symbol_name". The object
/// streamer does whatever is needed to implement .bar in the object file.
///
/// In the assembly printer and parser the target streamer can be used by
/// calling getTargetStreamer and casting it to FooTargetStreamer:
///
/// MCTargetStreamer &TS = OutStreamer.getTargetStreamer();
/// FooTargetStreamer &ATS = static_cast<FooTargetStreamer &>(TS);
///
/// The base classes FooTargetAsmStreamer and FooTargetELFStreamer should
/// *never* be treated differently. Callers should always talk to a
/// FooTargetStreamer.
//<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 73,
 FQN="llvm::MCTargetStreamer", NM="_ZN4llvm16MCTargetStreamerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamerE")
//</editor-fold>
public class MCTargetStreamer implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final MCStreamer /*&*/ Streamer;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::MCTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 35,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 33,
   FQN="llvm::MCTargetStreamer::MCTargetStreamer", NM="_ZN4llvm16MCTargetStreamerC1ERNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamerC1ERNS_10MCStreamerE")
  //</editor-fold>
  public MCTargetStreamer(final MCStreamer /*&*/ S) {
    // : Streamer(S) 
    //START JInit
    this./*&*/Streamer=/*&*/S;
    //END JInit
    S.setTargetStreamer(this);
  }

  
  // Pin the vtables to this file.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::~MCTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 33,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 31,
   FQN="llvm::MCTargetStreamer::~MCTargetStreamer", NM="_ZN4llvm16MCTargetStreamerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::getStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 81,
   FQN="llvm::MCTargetStreamer::getStreamer", NM="_ZN4llvm16MCTargetStreamer11getStreamerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamer11getStreamerEv")
  //</editor-fold>
  public MCStreamer /*&*/ getStreamer() {
    return Streamer;
  }

  
  // Allow a target to add behavior to the EmitLabel of MCStreamer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::emitLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 39,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 37,
   FQN="llvm::MCTargetStreamer::emitLabel", NM="_ZN4llvm16MCTargetStreamer9emitLabelEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamer9emitLabelEPNS_8MCSymbolE")
  //</editor-fold>
  public void emitLabel(MCSymbol /*P*/ Symbol) {
  }

  // Allow a target to add behavior to the emitAssignment of MCStreamer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::emitAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 43,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 41,
   FQN="llvm::MCTargetStreamer::emitAssignment", NM="_ZN4llvm16MCTargetStreamer14emitAssignmentEPNS_8MCSymbolEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamer14emitAssignmentEPNS_8MCSymbolEPKNS_6MCExprE")
  //</editor-fold>
  public void emitAssignment(MCSymbol /*P*/ Symbol, /*const*/ MCExpr /*P*/ Value) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::prettyPrintAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 690,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 613,
   FQN="llvm::MCTargetStreamer::prettyPrintAsm", NM="_ZN4llvm16MCTargetStreamer14prettyPrintAsmERNS_13MCInstPrinterERNS_11raw_ostreamERKNS_6MCInstERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamer14prettyPrintAsmERNS_13MCInstPrinterERNS_11raw_ostreamERKNS_6MCInstERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  public void prettyPrintAsm(final MCInstPrinter /*&*/ InstPrinter, final raw_ostream /*&*/ OS, 
                final /*const*/ MCInst /*&*/ Inst, final /*const*/ MCSubtargetInfo /*&*/ STI) {
    InstPrinter.printInst($AddrOf(Inst), OS, new StringRef(/*KEEP_STR*/$EMPTY), STI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetStreamer::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 39,
   FQN="llvm::MCTargetStreamer::finish", NM="_ZN4llvm16MCTargetStreamer6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCTargetStreamer6finishEv")
  //</editor-fold>
  public void finish() {
  }

  
  @Override public String toString() {
    return "" + "Streamer=" + Streamer; // NOI18N
  }
}
