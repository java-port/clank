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


/// A simple AA result that uses TBAA metadata to answer queries.
//<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TypeBasedAliasAnalysis.h", line = 26,
 FQN="llvm::TypeBasedAAResult", NM="_ZN4llvm17TypeBasedAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResultE")
//</editor-fold>
public class TypeBasedAAResult extends /*public*/ AAResultBase<TypeBasedAAResult> {
  /*friend  AAResultBase<TypeBasedAAResult>*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::TypeBasedAAResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TypeBasedAliasAnalysis.h", line = 30,
   FQN="llvm::TypeBasedAAResult::TypeBasedAAResult", NM="_ZN4llvm17TypeBasedAAResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResultC1Ev")
  //</editor-fold>
  public /*explicit*/ TypeBasedAAResult() {
    // : AAResultBase<TypeBasedAAResult>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::TypeBasedAAResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TypeBasedAliasAnalysis.h", line = 31,
   FQN="llvm::TypeBasedAAResult::TypeBasedAAResult", NM="_ZN4llvm17TypeBasedAAResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResultC1EOS0_")
  //</editor-fold>
  public TypeBasedAAResult(JD$Move _dparam, final TypeBasedAAResult /*&&*/Arg) {
    // : AAResultBase<TypeBasedAAResult>(std::move(Arg)) 
    super(JD$Move.INSTANCE, std.move(Arg));
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Handle invalidation events from the new pass manager.
  ///
  /// By definition, this result is stateless and so remains valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::invalidate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TypeBasedAliasAnalysis.h", line = 36,
   FQN="llvm::TypeBasedAAResult::invalidate", NM="_ZN4llvm17TypeBasedAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 281,
   FQN="llvm::TypeBasedAAResult::alias", NM="_ZN4llvm17TypeBasedAAResult5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::pointsToConstantMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 303,
   FQN="llvm::TypeBasedAAResult::pointsToConstantMemory", NM="_ZN4llvm17TypeBasedAAResult22pointsToConstantMemoryERKNS_14MemoryLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult22pointsToConstantMemoryERKNS_14MemoryLocationEb")
  //</editor-fold>
  public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, 
                        boolean OrLocal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 321,
   FQN="llvm::TypeBasedAAResult::getModRefBehavior", NM="_ZN4llvm17TypeBasedAAResult17getModRefBehaviorENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult17getModRefBehaviorENS_17ImmutableCallSiteE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 338,
   FQN="llvm::TypeBasedAAResult::getModRefBehavior", NM="_ZN4llvm17TypeBasedAAResult17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 343,
   FQN="llvm::TypeBasedAAResult::getModRefInfo", NM="_ZN4llvm17TypeBasedAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 357,
   FQN="llvm::TypeBasedAAResult::getModRefInfo", NM="_ZN4llvm17TypeBasedAAResult13getModRefInfoENS_17ImmutableCallSiteES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm17TypeBasedAAResult13getModRefInfoENS_17ImmutableCallSiteES1_")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS1, 
               ImmutableCallSite CS2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  
  /// Aliases - Test whether the type represented by A may alias the
  /// type represented by B.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::Aliases">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 480,
   FQN="llvm::TypeBasedAAResult::Aliases", NM="_ZNK4llvm17TypeBasedAAResult7AliasesEPKNS_6MDNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK4llvm17TypeBasedAAResult7AliasesEPKNS_6MDNodeES3_")
  //</editor-fold>
  private boolean Aliases(/*const*/ MDNode /*P*/ A, /*const*/ MDNode /*P*/ B) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the struct-path tag represented by A may alias the
  /// struct-path tag represented by B.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeBasedAAResult::PathAliases">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 525,
   FQN="llvm::TypeBasedAAResult::PathAliases", NM="_ZNK4llvm17TypeBasedAAResult11PathAliasesEPKNS_6MDNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK4llvm17TypeBasedAAResult11PathAliasesEPKNS_6MDNodeES3_")
  //</editor-fold>
  private boolean PathAliases(/*const*/ MDNode /*P*/ A, /*const*/ MDNode /*P*/ B) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
