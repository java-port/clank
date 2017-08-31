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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.pass.*;


/// Diagnostic information for unsupported feature in backend.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoUnsupported">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 667,
 FQN="llvm::DiagnosticInfoUnsupported", NM="_ZN4llvm25DiagnosticInfoUnsupportedE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm25DiagnosticInfoUnsupportedE")
//</editor-fold>
public class DiagnosticInfoUnsupported extends /*public*/ DiagnosticInfoWithDebugLocBase implements Destructors.ClassWithDestructor {
/*private:*/
  private Twine Msg;
/*public:*/
  /// \p Fn is the function where the diagnostic is being emitted. \p DLoc is
  /// the location information to use in the diagnostic. If line table
  /// information is available, the diagnostic will include the source code
  /// location. \p Msg is the message to show. Note that this class does not
  /// copy this message, so this reference must be valid for the whole life time
  /// of the diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoUnsupported::DiagnosticInfoUnsupported">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 679,
   FQN="llvm::DiagnosticInfoUnsupported::DiagnosticInfoUnsupported", NM="_ZN4llvm25DiagnosticInfoUnsupportedC1ERKNS_8FunctionERKNS_5TwineENS_8DebugLocENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm25DiagnosticInfoUnsupportedC1ERKNS_8FunctionERKNS_5TwineENS_8DebugLocENS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfoUnsupported(final /*const*/ Function /*&*/ Fn, final /*const*/ Twine /*&*/ Msg) {
    this(Fn, Msg,
      /*$c$.track*/(new DebugLoc()),
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoUnsupported(final /*const*/ Function /*&*/ Fn, final /*const*/ Twine /*&*/ Msg,
      DebugLoc DLoc/*= $c$.track(DebugLoc())*/) {
    this(Fn, Msg,
      DLoc,
      DiagnosticSeverity.DS_Error);
  }
  public DiagnosticInfoUnsupported(final /*const*/ Function /*&*/ Fn, final /*const*/ Twine /*&*/ Msg,
      DebugLoc DLoc/*= $c$.track(DebugLoc())*/,
      DiagnosticSeverity Severity/*= DS_Error*/) {
    // : DiagnosticInfoWithDebugLocBase(DK_Unsupported, Severity, Fn, DLoc), Msg(Msg)
    //START JInit
    super(DiagnosticKind.DK_Unsupported, Severity, Fn, DLoc);
    this.Msg = new Twine(Msg);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoUnsupported::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 685,
   FQN="llvm::DiagnosticInfoUnsupported::classof", NM="_ZN4llvm25DiagnosticInfoUnsupported7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm25DiagnosticInfoUnsupported7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_Unsupported.getValue();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoUnsupported::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 689,
   FQN="llvm::DiagnosticInfoUnsupported::getMessage", NM="_ZNK4llvm25DiagnosticInfoUnsupported10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm25DiagnosticInfoUnsupported10getMessageEv")
  //</editor-fold>
  public /*const*/ Twine /*&*/ getMessage() /*const*/ {
    return Msg;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoUnsupported::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 244,
   FQN="llvm::DiagnosticInfoUnsupported::print", NM="_ZNK4llvm25DiagnosticInfoUnsupported5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm25DiagnosticInfoUnsupported5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);

      $out_raw_ostream_Twine$C(IrLlvmGlobals.$out_raw_ostream_Type(OS.$out(getLocationStr()).$out(/*KEEP_STR*/": in function ").$out(getFunction().getName()).$out_char($$SPACE),
              $Deref(getFunction().getFunctionType())).$out(/*KEEP_STR*/": "), Msg).$out_char($$LF);
      OS.flush();
      DP.$out(Str);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoUnsupported::~DiagnosticInfoUnsupported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 667,
   FQN="llvm::DiagnosticInfoUnsupported::~DiagnosticInfoUnsupported", NM="_ZN4llvm25DiagnosticInfoUnsupportedD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm25DiagnosticInfoUnsupportedD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "Msg=" + Msg // NOI18N
              + super.toString(); // NOI18N
  }
}
