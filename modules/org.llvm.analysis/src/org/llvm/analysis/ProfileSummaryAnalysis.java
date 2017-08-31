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


/// An analysis pass based on the new PM to deliver ProfileSummaryInfo.
//<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ProfileSummaryInfo.h", line = 79,
 FQN="llvm::ProfileSummaryAnalysis", NM="_ZN4llvm22ProfileSummaryAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysisE")
//</editor-fold>
public class ProfileSummaryAnalysis implements /*public*/ AnalysisInfoMixin<ProfileSummaryAnalysis> {
/*public:*/
  // JAVA: typedef ProfileSummaryInfo Result
//  public final class Result extends ProfileSummaryInfo{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis::ProfileSummaryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ProfileSummaryInfo.h", line = 84,
   FQN="llvm::ProfileSummaryAnalysis::ProfileSummaryAnalysis", NM="_ZN4llvm22ProfileSummaryAnalysisC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysisC1Ev")
  //</editor-fold>
  public ProfileSummaryAnalysis() {
    // : AnalysisInfoMixin<ProfileSummaryAnalysis>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis::ProfileSummaryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ProfileSummaryInfo.h", line = 85,
   FQN="llvm::ProfileSummaryAnalysis::ProfileSummaryAnalysis", NM="_ZN4llvm22ProfileSummaryAnalysisC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysisC1ERKS0_")
  //</editor-fold>
  public ProfileSummaryAnalysis(final /*const*/ ProfileSummaryAnalysis /*&*/ Arg) {
    // : AnalysisInfoMixin<ProfileSummaryAnalysis>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis::ProfileSummaryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ProfileSummaryInfo.h", line = 86,
   FQN="llvm::ProfileSummaryAnalysis::ProfileSummaryAnalysis", NM="_ZN4llvm22ProfileSummaryAnalysisC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysisC1EOS0_")
  //</editor-fold>
  public ProfileSummaryAnalysis(JD$Move _dparam, final ProfileSummaryAnalysis /*&&*/Arg) {
    // : AnalysisInfoMixin<ProfileSummaryAnalysis>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ProfileSummaryInfo.h", line = 87,
   FQN="llvm::ProfileSummaryAnalysis::operator=", NM="_ZN4llvm22ProfileSummaryAnalysisaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysisaSERKS0_")
  //</editor-fold>
  public ProfileSummaryAnalysis /*&*/ $assign(final /*const*/ ProfileSummaryAnalysis /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ProfileSummaryInfo.h", line = 90,
   FQN="llvm::ProfileSummaryAnalysis::operator=", NM="_ZN4llvm22ProfileSummaryAnalysisaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysisaSEOS0_")
  //</editor-fold>
  public ProfileSummaryAnalysis /*&*/ $assignMove(final ProfileSummaryAnalysis /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummaryAnalysis::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 143,
   FQN="llvm::ProfileSummaryAnalysis::run", NM="_ZN4llvm22ProfileSummaryAnalysis3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm22ProfileSummaryAnalysis3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public ProfileSummaryInfo run(final Module /*&*/ M, 
     final AnalysisManager<Module>/*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /*friend  AnalysisInfoMixin<ProfileSummaryAnalysis>*/
  private static /*char*/byte PassID;
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
