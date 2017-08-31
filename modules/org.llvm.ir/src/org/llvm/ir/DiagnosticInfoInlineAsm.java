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

package org.llvm.ir;

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.mdconst.MdconstGlobals;


/// Diagnostic information for inline asm reporting.
/// This is basically a message and an optional location.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 116,
 FQN="llvm::DiagnosticInfoInlineAsm", NM="_ZN4llvm23DiagnosticInfoInlineAsmE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoInlineAsmE")
//</editor-fold>
public class DiagnosticInfoInlineAsm extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
/*private:*/
  /// Optional line information. 0 if not set.
  private /*uint*/int LocCookie;
  /// Message to be reported.
  private final /*const*/ Twine /*&*/ MsgStr;
  /// Optional origin of the problem.
  private /*const*/ Instruction /*P*/ Instr;
/*public:*/
  /// \p MsgStr is the message to be reported to the frontend.
  /// This class does not copy \p MsgStr, therefore the reference must be valid
  /// for the whole life time of the Diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::DiagnosticInfoInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 129,
   FQN="llvm::DiagnosticInfoInlineAsm::DiagnosticInfoInlineAsm", NM="_ZN4llvm23DiagnosticInfoInlineAsmC1ERKNS_5TwineENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoInlineAsmC1ERKNS_5TwineENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoInlineAsm(final /*const*/ Twine /*&*/ MsgStr) {
    this(MsgStr,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoInlineAsm(final /*const*/ Twine /*&*/ MsgStr,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfo(DK_InlineAsm, Severity), LocCookie(0), MsgStr(MsgStr), Instr(null)
    //START JInit
    super(DiagnosticKind.DK_InlineAsm.getValue(), Severity);
    this.LocCookie = 0;
    this./*&*/MsgStr=/*&*/MsgStr;
    this.Instr = null;
    //END JInit
  }


  /// \p LocCookie if non-zero gives the line number for this report.
  /// \p MsgStr gives the message.
  /// This class does not copy \p MsgStr, therefore the reference must be valid
  /// for the whole life time of the Diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::DiagnosticInfoInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 138,
   FQN="llvm::DiagnosticInfoInlineAsm::DiagnosticInfoInlineAsm", NM="_ZN4llvm23DiagnosticInfoInlineAsmC1EjRKNS_5TwineENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoInlineAsmC1EjRKNS_5TwineENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoInlineAsm(/*uint*/int LocCookie, final /*const*/ Twine /*&*/ MsgStr) {
    this(LocCookie, MsgStr,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoInlineAsm(/*uint*/int LocCookie, final /*const*/ Twine /*&*/ MsgStr,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfo(DK_InlineAsm, Severity), LocCookie(LocCookie), MsgStr(MsgStr), Instr(null)
    //START JInit
    super(DiagnosticKind.DK_InlineAsm.getValue(), Severity);
    this.LocCookie = LocCookie;
    this./*&*/MsgStr=/*&*/MsgStr;
    this.Instr = null;
    //END JInit
  }


  /// \p Instr gives the original instruction that triggered the diagnostic.
  /// \p MsgStr gives the message.
  /// This class does not copy \p MsgStr, therefore the reference must be valid
  /// for the whole life time of the Diagnostic.
  /// Same for \p I.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::DiagnosticInfoInlineAsm">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 96,
   FQN="llvm::DiagnosticInfoInlineAsm::DiagnosticInfoInlineAsm", NM="_ZN4llvm23DiagnosticInfoInlineAsmC1ERKNS_11InstructionERKNS_5TwineENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoInlineAsmC1ERKNS_11InstructionERKNS_5TwineENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoInlineAsm(final /*const*/ Instruction /*&*/ I,
      final /*const*/ Twine /*&*/ MsgStr) {
    this(I,
      MsgStr,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoInlineAsm(final /*const*/ Instruction /*&*/ I,
      final /*const*/ Twine /*&*/ MsgStr,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfo(DK_InlineAsm, Severity), LocCookie(0), MsgStr(MsgStr), Instr(&I)
    //START JInit
    super(DiagnosticKind.DK_InlineAsm.getValue(), Severity);
    this.LocCookie = 0;
    this./*&*/MsgStr=/*&*/MsgStr;
    this.Instr = $AddrOf(I);
    //END JInit
    {
      /*const*/ MDNode /*P*/ SrcLoc = I.getMetadata(new StringRef(/*KEEP_STR*/"srcloc"));
      if ((SrcLoc != null)) {
        if (SrcLoc.getNumOperands() != 0) {
          {
            /*const*/ ConstantInt /*P*/ CI = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, SrcLoc.getOperand(0));
            if ((CI != null)) {
              LocCookie = $ulong2uint(CI.getZExtValue());
            }
          }
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::getLocCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 151,
   FQN="llvm::DiagnosticInfoInlineAsm::getLocCookie", NM="_ZNK4llvm23DiagnosticInfoInlineAsm12getLocCookieEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm23DiagnosticInfoInlineAsm12getLocCookieEv")
  //</editor-fold>
  public /*uint*/int getLocCookie() /*const*/ {
    return LocCookie;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::getMsgStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 152,
   FQN="llvm::DiagnosticInfoInlineAsm::getMsgStr", NM="_ZNK4llvm23DiagnosticInfoInlineAsm9getMsgStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm23DiagnosticInfoInlineAsm9getMsgStrEv")
  //</editor-fold>
  public /*const*/ Twine /*&*/ getMsgStr() /*const*/ {
    return MsgStr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::getInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 153,
   FQN="llvm::DiagnosticInfoInlineAsm::getInstruction", NM="_ZNK4llvm23DiagnosticInfoInlineAsm14getInstructionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm23DiagnosticInfoInlineAsm14getInstructionEv")
  //</editor-fold>
  public /*const*/ Instruction /*P*/ getInstruction() /*const*/ {
    return Instr;
  }


  /// \see DiagnosticInfo::print.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 109,
   FQN="llvm::DiagnosticInfoInlineAsm::print", NM="_ZNK4llvm23DiagnosticInfoInlineAsm5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm23DiagnosticInfoInlineAsm5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    DP.$out(getMsgStr());
    if ((getLocCookie() != 0)) {
      DP.$out(/*KEEP_STR*/" at line ").$out_uint(getLocCookie());
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 158,
   FQN="llvm::DiagnosticInfoInlineAsm::classof", NM="_ZN4llvm23DiagnosticInfoInlineAsm7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoInlineAsm7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_InlineAsm.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoInlineAsm::~DiagnosticInfoInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 116,
   FQN="llvm::DiagnosticInfoInlineAsm::~DiagnosticInfoInlineAsm", NM="_ZN4llvm23DiagnosticInfoInlineAsmD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm23DiagnosticInfoInlineAsmD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "LocCookie=" + LocCookie // NOI18N
              + ", MsgStr=" + MsgStr // NOI18N
              + ", Instr=" + Instr // NOI18N
              + super.toString(); // NOI18N
  }
}
