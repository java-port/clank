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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// Common features for diagnostics dealing with optimization remarks.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 375,
 FQN="llvm::DiagnosticInfoOptimizationBase", NM="_ZN4llvm30DiagnosticInfoOptimizationBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoOptimizationBaseE")
//</editor-fold>
public abstract class DiagnosticInfoOptimizationBase extends /*public*/ DiagnosticInfoWithDebugLocBase implements Destructors.ClassWithDestructor {
/*public:*/
  /// \p PassName is the name of the pass emitting this diagnostic.
  /// \p Fn is the function where the diagnostic is being emitted. \p DLoc is
  /// the location information to use in the diagnostic. If line table
  /// information is available, the diagnostic will include the source code
  /// location. \p Msg is the message to show. Note that this class does not
  /// copy this message, so this reference must be valid for the whole life time
  /// of the diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::DiagnosticInfoOptimizationBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 384,
   FQN="llvm::DiagnosticInfoOptimizationBase::DiagnosticInfoOptimizationBase", NM="_ZN4llvm30DiagnosticInfoOptimizationBaseC1ENS_14DiagnosticKindENS_18DiagnosticSeverityEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineENS_8OptionalIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoOptimizationBaseC1ENS_14DiagnosticKindENS_18DiagnosticSeverityEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineENS_8OptionalIyEE")
  //</editor-fold>
  public DiagnosticInfoOptimizationBase( DiagnosticKind Kind,
       DiagnosticSeverity Severity,
      /*const*/char$ptr/*char P*/ PassName, final /*const*/ Function /*&*/ Fn,
      final /*const*/ DebugLoc /*&*/ DLoc, final /*const*/ Twine /*&*/ Msg) {
    this(Kind,
      Severity,
      PassName, Fn,
      DLoc, Msg,
      new OptionalULong(None));
  }
  public DiagnosticInfoOptimizationBase( DiagnosticKind Kind,
       DiagnosticSeverity Severity,
      /*const*/char$ptr/*char P*/ PassName, final /*const*/ Function /*&*/ Fn,
      final /*const*/ DebugLoc /*&*/ DLoc, final /*const*/ Twine /*&*/ Msg,
      OptionalULong Hotness/*= None*/) {
    // : DiagnosticInfoWithDebugLocBase(Kind, Severity, Fn, DLoc), PassName(PassName), Msg(Msg), Hotness(Hotness)
    //START JInit
    super(Kind, Severity, Fn, DLoc);
    this.PassName = $tryClone(PassName);
    this./*&*/Msg=/*&*/Msg;
    this.Hotness = new OptionalULong(Hotness);
    //END JInit
  }


  /// \see DiagnosticInfo::print.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 173,
   FQN="llvm::DiagnosticInfoOptimizationBase::print", NM="_ZNK4llvm30DiagnosticInfoOptimizationBase5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoOptimizationBase5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  @Override public void print(final DiagnosticPrinter /*&*/ DP) /*const*//* override*/ {
    DP.$out(getLocationStr()).$out(/*KEEP_STR*/": ").$out(getMsg());
    if (Hotness.$bool()) {
      DP.$out(/*KEEP_STR*/" (hotness: ").$out_ullong(Hotness.$star$Const()).$out(/*KEEP_STR*/")");
    }
  }


  /// Return true if this optimization remark is enabled by one of
  /// of the LLVM command line flags (-pass-remarks, -pass-remarks-missed,
  /// or -pass-remarks-analysis). Note that this only handles the LLVM
  /// flags. We cannot access Clang flags from here (they are handled
  /// in BackendConsumer::OptimizationRemarkHandler).
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::isEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 400,
   FQN="llvm::DiagnosticInfoOptimizationBase::isEnabled", NM="_ZNK4llvm30DiagnosticInfoOptimizationBase9isEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoOptimizationBase9isEnabledEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isEnabled() /*const*//* = 0*/;


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 402,
   FQN="llvm::DiagnosticInfoOptimizationBase::getPassName", NM="_ZNK4llvm30DiagnosticInfoOptimizationBase11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoOptimizationBase11getPassNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPassName() /*const*/ {
    return PassName;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::getMsg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 403,
   FQN="llvm::DiagnosticInfoOptimizationBase::getMsg", NM="_ZNK4llvm30DiagnosticInfoOptimizationBase6getMsgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoOptimizationBase6getMsgEv")
  //</editor-fold>
  public /*const*/ Twine /*&*/ getMsg() /*const*/ {
    return Msg;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 405,
   FQN="llvm::DiagnosticInfoOptimizationBase::classof", NM="_ZN4llvm30DiagnosticInfoOptimizationBase7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoOptimizationBase7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() >= DiagnosticKind.DK_FirstRemark.getValue()
       && DI.getKind() <= DiagnosticKind.DK_LastRemark.getValue();
  }

/*private:*/
  /// Name of the pass that triggers this report. If this matches the
  /// regular expression given in -Rpass=regexp, then the remark will
  /// be emitted.
  private /*const*/char$ptr/*char P*/ PassName;

  /// Message to report.
  private final /*const*/ Twine /*&*/ Msg;

  /// If profile information is available, this is the number of times the
  /// corresponding code was executed in a profile instrumentation run.
  private OptionalULong Hotness;
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationBase::~DiagnosticInfoOptimizationBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 375,
   FQN="llvm::DiagnosticInfoOptimizationBase::~DiagnosticInfoOptimizationBase", NM="_ZN4llvm30DiagnosticInfoOptimizationBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoOptimizationBaseD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Hotness.$destroy();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "PassName=" + PassName // NOI18N
              + ", Msg=" + Msg // NOI18N
              + ", Hotness=" + Hotness // NOI18N
              + super.toString(); // NOI18N
  }
}
