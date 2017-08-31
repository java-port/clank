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

package org.llvm.analysis.target;

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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.ir.java.IPassFunction;
import org.llvm.ir.java.IPassModule;


/// Analysis pass providing the \c TargetLibraryInfo.
///
/// Note that this pass's result cannot be invalidated, it is immutable for the
/// life of the module.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 281,
 FQN="llvm::TargetLibraryAnalysis", NM="_ZN4llvm21TargetLibraryAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21TargetLibraryAnalysisE")
//</editor-fold>
public class TargetLibraryAnalysis implements /*public*/ AnalysisInfoMixin<TargetLibraryAnalysis>, Destructors.ClassWithDestructor, IPassModule<TargetLibraryInfo>, IPassFunction<TargetLibraryInfo> {
/*public:*/
  // JAVA: typedef TargetLibraryInfo Result
//  public final class Result extends TargetLibraryInfo{ };
  
  /// Default construct the library analysis.
  ///
  /// This will use the module's triple to construct the library info for that
  /// module.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::TargetLibraryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 289,
   FQN="llvm::TargetLibraryAnalysis::TargetLibraryAnalysis", NM="_ZN4llvm21TargetLibraryAnalysisC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21TargetLibraryAnalysisC1Ev")
  //</editor-fold>
  public TargetLibraryAnalysis() {
    // : AnalysisInfoMixin<TargetLibraryAnalysis>(), PresetInfoImpl(), Impls() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Construct a library analysis with preset info.
  ///
  /// This will directly copy the preset info into the result without
  /// consulting the module's triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::TargetLibraryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 295,
   FQN="llvm::TargetLibraryAnalysis::TargetLibraryAnalysis", NM="_ZN4llvm21TargetLibraryAnalysisC1ENS_21TargetLibraryInfoImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21TargetLibraryAnalysisC1ENS_21TargetLibraryInfoImplE")
  //</editor-fold>
  public TargetLibraryAnalysis(TargetLibraryInfoImpl PresetInfoImpl) {
    // : AnalysisInfoMixin<TargetLibraryAnalysis>(), PresetInfoImpl(std::move(PresetInfoImpl)), Impls() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Move semantics. We spell out the constructors for MSVC.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::TargetLibraryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 299,
   FQN="llvm::TargetLibraryAnalysis::TargetLibraryAnalysis", NM="_ZN4llvm21TargetLibraryAnalysisC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21TargetLibraryAnalysisC1EOS0_")
  //</editor-fold>
  public TargetLibraryAnalysis(JD$Move _dparam, final TargetLibraryAnalysis /*&&*/Arg) {
    // : AnalysisInfoMixin<TargetLibraryAnalysis>(), PresetInfoImpl(std::move(Arg.PresetInfoImpl)), Impls(std::move(Arg.Impls)) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 301,
   FQN="llvm::TargetLibraryAnalysis::operator=", NM="_ZN4llvm21TargetLibraryAnalysisaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21TargetLibraryAnalysisaSEOS0_")
  //</editor-fold>
  public TargetLibraryAnalysis /*&*/ $assignMove(final TargetLibraryAnalysis /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1122,
   FQN="llvm::TargetLibraryAnalysis::run", NM="_ZN4llvm21TargetLibraryAnalysis3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryAnalysis3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public TargetLibraryInfo run(final Module /*&*/ M, 
     final AnalysisManager<Module>/*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1130,
   FQN="llvm::TargetLibraryAnalysis::run", NM="_ZN4llvm21TargetLibraryAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public TargetLibraryInfo run(final Function /*&*/ F, 
     final AnalysisManager<Function>/*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  /*friend  AnalysisInfoMixin<TargetLibraryAnalysis>*/
  private static /*char*/byte PassID;
  
  private Optional<TargetLibraryInfoImpl> PresetInfoImpl;
  
  private StringMap<std.unique_ptr<TargetLibraryInfoImpl>> Impls;
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::lookupInfoImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1139,
   FQN="llvm::TargetLibraryAnalysis::lookupInfoImpl", NM="_ZN4llvm21TargetLibraryAnalysis14lookupInfoImplERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm21TargetLibraryAnalysis14lookupInfoImplERKNS_6TripleE")
  //</editor-fold>
  private TargetLibraryInfoImpl /*&*/ lookupInfoImpl(final /*const*/ Triple /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryAnalysis::~TargetLibraryAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 281,
   FQN="llvm::TargetLibraryAnalysis::~TargetLibraryAnalysis", NM="_ZN4llvm21TargetLibraryAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21TargetLibraryAnalysisD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "PresetInfoImpl=" + PresetInfoImpl // NOI18N
              + ", Impls=" + Impls // NOI18N
              + super.toString(); // NOI18N
  }
}
