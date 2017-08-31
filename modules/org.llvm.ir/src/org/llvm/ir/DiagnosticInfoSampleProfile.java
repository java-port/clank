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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// Diagnostic information for the sample profiler.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 277,
 FQN="llvm::DiagnosticInfoSampleProfile", NM="_ZN4llvm27DiagnosticInfoSampleProfileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoSampleProfileE")
//</editor-fold>
public class DiagnosticInfoSampleProfile extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::DiagnosticInfoSampleProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 279,
   FQN="llvm::DiagnosticInfoSampleProfile::DiagnosticInfoSampleProfile", NM="_ZN4llvm27DiagnosticInfoSampleProfileC1ENS_9StringRefEjRKNS_5TwineENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoSampleProfileC1ENS_9StringRefEjRKNS_5TwineENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoSampleProfile(StringRef FileName, /*uint*/int LineNum,
      final /*const*/ Twine /*&*/ Msg) {
    this(FileName, LineNum,
      Msg,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoSampleProfile(StringRef FileName, /*uint*/int LineNum,
      final /*const*/ Twine /*&*/ Msg,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfo(DK_SampleProfile, Severity), FileName(FileName), LineNum(LineNum), Msg(Msg)
    //START JInit
    super(DiagnosticKind.DK_SampleProfile.getValue(), Severity);
    this.FileName = new StringRef(FileName);
    this.LineNum = LineNum;
    this./*&*/Msg=/*&*/Msg;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::DiagnosticInfoSampleProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 284,
   FQN="llvm::DiagnosticInfoSampleProfile::DiagnosticInfoSampleProfile", NM="_ZN4llvm27DiagnosticInfoSampleProfileC1ENS_9StringRefERKNS_5TwineENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoSampleProfileC1ENS_9StringRefERKNS_5TwineENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoSampleProfile(StringRef FileName, final /*const*/ Twine /*&*/ Msg) {
    this(FileName, Msg,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoSampleProfile(StringRef FileName, final /*const*/ Twine /*&*/ Msg,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfo(DK_SampleProfile, Severity), FileName(FileName), LineNum(0), Msg(Msg)
    //START JInit
    super(DiagnosticKind.DK_SampleProfile.getValue(), Severity);
    this.FileName = new StringRef(FileName);
    this.LineNum = 0;
    this./*&*/Msg=/*&*/Msg;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::DiagnosticInfoSampleProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 288,
   FQN="llvm::DiagnosticInfoSampleProfile::DiagnosticInfoSampleProfile", NM="_ZN4llvm27DiagnosticInfoSampleProfileC1ERKNS_5TwineENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoSampleProfileC1ERKNS_5TwineENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoSampleProfile(final /*const*/ Twine /*&*/ Msg) {
    this(Msg,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoSampleProfile(final /*const*/ Twine /*&*/ Msg,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfo(DK_SampleProfile, Severity), FileName(), LineNum(0), Msg(Msg)
    //START JInit
    super(DiagnosticKind.DK_SampleProfile.getValue(), Severity);
    this.FileName = new StringRef();
    this.LineNum = 0;
    this./*&*/Msg=/*&*/Msg;
    //END JInit
  }


  /// \see DiagnosticInfo::print.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 134,
   FQN="llvm::DiagnosticInfoSampleProfile::print", NM="_ZNK4llvm27DiagnosticInfoSampleProfile5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoSampleProfile5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    if (!FileName.empty()) {
      DP.$out(getFileName());
      if ($greater_uint(LineNum, 0)) {
        DP.$out(/*KEEP_STR*/":").$out_uint(getLineNum());
      }
      DP.$out(/*KEEP_STR*/": ");
    }
    DP.$out(getMsg());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 295,
   FQN="llvm::DiagnosticInfoSampleProfile::classof", NM="_ZN4llvm27DiagnosticInfoSampleProfile7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoSampleProfile7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_SampleProfile.getValue();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::getFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 299,
   FQN="llvm::DiagnosticInfoSampleProfile::getFileName", NM="_ZNK4llvm27DiagnosticInfoSampleProfile11getFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoSampleProfile11getFileNameEv")
  //</editor-fold>
  public StringRef getFileName() /*const*/ {
    return new StringRef(FileName);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::getLineNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 300,
   FQN="llvm::DiagnosticInfoSampleProfile::getLineNum", NM="_ZNK4llvm27DiagnosticInfoSampleProfile10getLineNumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoSampleProfile10getLineNumEv")
  //</editor-fold>
  public /*uint*/int getLineNum() /*const*/ {
    return LineNum;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::getMsg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 301,
   FQN="llvm::DiagnosticInfoSampleProfile::getMsg", NM="_ZNK4llvm27DiagnosticInfoSampleProfile6getMsgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm27DiagnosticInfoSampleProfile6getMsgEv")
  //</editor-fold>
  public /*const*/ Twine /*&*/ getMsg() /*const*/ {
    return Msg;
  }

/*private:*/
  /// Name of the input file associated with this diagnostic.
  private StringRef FileName;

  /// Line number where the diagnostic occurred. If 0, no line number will
  /// be emitted in the message.
  private /*uint*/int LineNum;

  /// Message to report.
  private final /*const*/ Twine /*&*/ Msg;
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoSampleProfile::~DiagnosticInfoSampleProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 277,
   FQN="llvm::DiagnosticInfoSampleProfile::~DiagnosticInfoSampleProfile", NM="_ZN4llvm27DiagnosticInfoSampleProfileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm27DiagnosticInfoSampleProfileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "FileName=" + FileName // NOI18N
              + ", LineNum=" + LineNum // NOI18N
              + ", Msg=" + Msg // NOI18N
              + super.toString(); // NOI18N
  }
}
