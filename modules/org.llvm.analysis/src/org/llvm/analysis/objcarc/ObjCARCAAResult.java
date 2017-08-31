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

package org.llvm.analysis.objcarc;

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
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;


/// \brief This is a simple alias analysis implementation that uses knowledge
/// of ARC constructs to answer queries.
///
/// TODO: This class could be generalized to know about other ObjC-specific
/// tricks. Such as knowing that ivars in the non-fragile ABI are non-aliasing
/// even though their offsets are dynamic.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAliasAnalysis.h", line = 38,
 FQN="llvm::objcarc::ObjCARCAAResult", NM="_ZN4llvm7objcarc15ObjCARCAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResultE")
//</editor-fold>
public class ObjCARCAAResult extends /*public*/ AAResultBase<ObjCARCAAResult> {
  /*friend  AAResultBase<ObjCARCAAResult>*/
  
  private final /*const*/ DataLayout /*&*/ DL;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::ObjCARCAAResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAliasAnalysis.h", line = 44,
   FQN="llvm::objcarc::ObjCARCAAResult::ObjCARCAAResult", NM="_ZN4llvm7objcarc15ObjCARCAAResultC1ERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResultC1ERKNS_10DataLayoutE")
  //</editor-fold>
  public /*explicit*/ ObjCARCAAResult(final /*const*/ DataLayout /*&*/ DL) {
    // : AAResultBase<ObjCARCAAResult>(), DL(DL) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::ObjCARCAAResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAliasAnalysis.h", line = 45,
   FQN="llvm::objcarc::ObjCARCAAResult::ObjCARCAAResult", NM="_ZN4llvm7objcarc15ObjCARCAAResultC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResultC1EOS1_")
  //</editor-fold>
  public ObjCARCAAResult(JD$Move _dparam, final ObjCARCAAResult /*&&*/Arg) {
    // : AAResultBase<ObjCARCAAResult>(std::move(Arg)), DL(Arg.DL) 
    super(JD$Move.INSTANCE, std.move(Arg));
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Handle invalidation events from the new pass manager.
  ///
  /// By definition, this result is stateless and so remains valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::invalidate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAliasAnalysis.h", line = 51,
   FQN="llvm::objcarc::ObjCARCAAResult::invalidate", NM="_ZN4llvm7objcarc15ObjCARCAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 40,
   FQN="llvm::objcarc::ObjCARCAAResult::alias", NM="_ZN4llvm7objcarc15ObjCARCAAResult5aliasERKNS_14MemoryLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResult5aliasERKNS_14MemoryLocationES4_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::pointsToConstantMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 72,
   FQN="llvm::objcarc::ObjCARCAAResult::pointsToConstantMemory", NM="_ZN4llvm7objcarc15ObjCARCAAResult22pointsToConstantMemoryERKNS_14MemoryLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResult22pointsToConstantMemoryERKNS_14MemoryLocationEb")
  //</editor-fold>
  public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, 
                        boolean OrLocal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //JAVA: using AAResultBase<ObjCARCAAResult>::getModRefBehavior;
  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 95,
   FQN="llvm::objcarc::ObjCARCAAResult::getModRefBehavior", NM="_ZN4llvm7objcarc15ObjCARCAAResult17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResult17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //JAVA: using AAResultBase<ObjCARCAAResult>::getModRefInfo;
  //<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ObjCARCAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 109,
   FQN="llvm::objcarc::ObjCARCAAResult::getModRefInfo", NM="_ZN4llvm7objcarc15ObjCARCAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm7objcarc15ObjCARCAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DL=" + DL // NOI18N
              + super.toString(); // NOI18N
  }
}
