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

package org.clang.basic;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 81,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 81,
 FQN = "clang::DiagnosticMapping", NM = "_ZN5clang17DiagnosticMappingE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMappingE")
//</editor-fold>
public class DiagnosticMapping implements NativeCloneable<DiagnosticMapping>{
  private /*JBYTE unsigned int*/ byte Severity /*: 3*/;
  private /*JBIT unsigned int*/ boolean IsUser /*: 1*/;
  private /*JBIT unsigned int*/ boolean IsPragma /*: 1*/;
  private /*JBIT unsigned int*/ boolean HasNoWarningAsError /*: 1*/;
  private /*JBIT unsigned int*/ boolean HasNoErrorAsFatal /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::Make">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 89,
   FQN = "clang::DiagnosticMapping::Make", NM = "_ZN5clang17DiagnosticMapping4MakeENS_4diag8SeverityEbb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMapping4MakeENS_4diag8SeverityEbb")
  //</editor-fold>
  public static DiagnosticMapping Make(diag.Severity Severity, boolean IsUser, 
      boolean IsPragma) {
    DiagnosticMapping Result/*J*/= new DiagnosticMapping();
    Result.Severity = (byte) Severity.getValue();
    Result.IsUser = IsUser;
    Result.IsPragma = IsPragma;
    Result.HasNoWarningAsError = false;
    Result.HasNoErrorAsFatal = false;
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::getSeverity">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 100,
   FQN = "clang::DiagnosticMapping::getSeverity", NM = "_ZNK5clang17DiagnosticMapping11getSeverityEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang17DiagnosticMapping11getSeverityEv")
  //</editor-fold>
  public diag.Severity getSeverity() /*const*/ {
    return diag.Severity.valueOf(Severity);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::setSeverity">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 101,
   FQN = "clang::DiagnosticMapping::setSeverity", NM = "_ZN5clang17DiagnosticMapping11setSeverityENS_4diag8SeverityE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMapping11setSeverityENS_4diag8SeverityE")
  //</editor-fold>
  public void setSeverity(diag.Severity Value) {
    Severity = (byte) Value.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::isUser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 103,
   FQN = "clang::DiagnosticMapping::isUser", NM = "_ZNK5clang17DiagnosticMapping6isUserEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang17DiagnosticMapping6isUserEv")
  //</editor-fold>
  public boolean isUser() /*const*/ {
    return IsUser;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::isPragma">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 104,
   FQN = "clang::DiagnosticMapping::isPragma", NM = "_ZNK5clang17DiagnosticMapping8isPragmaEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang17DiagnosticMapping8isPragmaEv")
  //</editor-fold>
  public boolean isPragma() /*const*/ {
    return IsPragma;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::hasNoWarningAsError">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 106,
   FQN = "clang::DiagnosticMapping::hasNoWarningAsError", NM = "_ZNK5clang17DiagnosticMapping19hasNoWarningAsErrorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang17DiagnosticMapping19hasNoWarningAsErrorEv")
  //</editor-fold>
  public boolean hasNoWarningAsError() /*const*/ {
    return HasNoWarningAsError;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::setNoWarningAsError">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 107,
   FQN = "clang::DiagnosticMapping::setNoWarningAsError", NM = "_ZN5clang17DiagnosticMapping19setNoWarningAsErrorEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMapping19setNoWarningAsErrorEb")
  //</editor-fold>
  public void setNoWarningAsError(boolean Value) {
    HasNoWarningAsError = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::hasNoErrorAsFatal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 109,
   FQN = "clang::DiagnosticMapping::hasNoErrorAsFatal", NM = "_ZNK5clang17DiagnosticMapping17hasNoErrorAsFatalEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang17DiagnosticMapping17hasNoErrorAsFatalEv")
  //</editor-fold>
  public boolean hasNoErrorAsFatal() /*const*/ {
    return HasNoErrorAsFatal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::setNoErrorAsFatal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 110,
   FQN = "clang::DiagnosticMapping::setNoErrorAsFatal", NM = "_ZN5clang17DiagnosticMapping17setNoErrorAsFatalEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMapping17setNoErrorAsFatalEb")
  //</editor-fold>
  public void setNoErrorAsFatal(boolean Value) {
    HasNoErrorAsFatal = Value;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::DiagnosticMapping">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 81,
   FQN = "clang::DiagnosticMapping::DiagnosticMapping", NM = "_ZN5clang17DiagnosticMappingC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMappingC1Ev")
  //</editor-fold>
  public /*inline*/ DiagnosticMapping() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::DiagnosticMapping">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 81,
   FQN = "clang::DiagnosticMapping::DiagnosticMapping", NM = "_ZN5clang17DiagnosticMappingC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMappingC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DiagnosticMapping(/*const*/ DiagnosticMapping /*&*/ $Prm0) {
    /* : Severity(.Severity), IsUser(.IsUser), IsPragma(.IsPragma), HasNoWarningAsError(.HasNoWarningAsError), HasNoErrorAsFatal(.HasNoErrorAsFatal)*/ 
    //START JInit
    this.Severity = $Prm0.Severity;
    this.IsUser = $Prm0.IsUser;
    this.IsPragma = $Prm0.IsPragma;
    this.HasNoWarningAsError = $Prm0.HasNoWarningAsError;
    this.HasNoErrorAsFatal = $Prm0.HasNoErrorAsFatal;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::DiagnosticMapping">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 81,
   FQN="clang::DiagnosticMapping::DiagnosticMapping", NM="_ZN5clang17DiagnosticMappingC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMappingC1EOS0_")
  //</editor-fold>
  public /*inline*/ DiagnosticMapping(JD$Move _dparam, DiagnosticMapping /*&&*/$Prm0) {
    /* : Severity(static_cast<DiagnosticMapping &&>().Severity), IsUser(static_cast<DiagnosticMapping &&>().IsUser), IsPragma(static_cast<DiagnosticMapping &&>().IsPragma), HasNoWarningAsError(static_cast<DiagnosticMapping &&>().HasNoWarningAsError), HasNoErrorAsFatal(static_cast<DiagnosticMapping &&>().HasNoErrorAsFatal)*/ 
    //START JInit
    this.Severity = $Prm0.Severity;
    this.IsUser = $Prm0.IsUser;
    this.IsPragma = $Prm0.IsPragma;
    this.HasNoWarningAsError = $Prm0.HasNoWarningAsError;
    this.HasNoErrorAsFatal = $Prm0.HasNoErrorAsFatal;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 81,
   FQN = "clang::DiagnosticMapping::operator=", NM = "_ZN5clang17DiagnosticMappingaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMappingaSERKS0_")
  //</editor-fold>
  public /*inline*/ DiagnosticMapping /*&*/ $assign(/*const*/ DiagnosticMapping /*&*/ $Prm0) {
    this.Severity = $Prm0.Severity;
    this.IsUser = $Prm0.IsUser;
    this.IsPragma = $Prm0.IsPragma;
    this.HasNoWarningAsError = $Prm0.HasNoWarningAsError;
    this.HasNoErrorAsFatal = $Prm0.HasNoErrorAsFatal;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticMapping::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 81,
   FQN="clang::DiagnosticMapping::operator=", NM="_ZN5clang17DiagnosticMappingaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticMappingaSEOS0_")
  //</editor-fold>
  public /*inline*/ DiagnosticMapping /*&*/ $assignMove(DiagnosticMapping /*&&*/$Prm0) {
    this.Severity = $Prm0.Severity;
    this.IsUser = $Prm0.IsUser;
    this.IsPragma = $Prm0.IsPragma;
    this.HasNoWarningAsError = $Prm0.HasNoWarningAsError;
    this.HasNoErrorAsFatal = $Prm0.HasNoErrorAsFatal;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "Severity=" + Severity // NOI18N
              + ", IsUser=" + IsUser // NOI18N
              + ", IsPragma=" + IsPragma // NOI18N
              + ", HasNoWarningAsError=" + HasNoWarningAsError // NOI18N
              + ", HasNoErrorAsFatal=" + HasNoErrorAsFatal; // NOI18N
  }

  @Override
  public DiagnosticMapping clone() {
    return new DiagnosticMapping(this);
  }
}
