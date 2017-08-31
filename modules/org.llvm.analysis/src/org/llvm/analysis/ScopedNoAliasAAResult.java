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


/// A simple AA result which uses scoped-noalias metadata to answer queries.
//<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScopedNoAliasAA.h", line = 26,
 FQN="llvm::ScopedNoAliasAAResult", NM="_ZN4llvm21ScopedNoAliasAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResultE")
//</editor-fold>
public class ScopedNoAliasAAResult extends /*public*/ AAResultBase<ScopedNoAliasAAResult> {
  /*friend  AAResultBase<ScopedNoAliasAAResult>*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::ScopedNoAliasAAResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScopedNoAliasAA.h", line = 30,
   FQN="llvm::ScopedNoAliasAAResult::ScopedNoAliasAAResult", NM="_ZN4llvm21ScopedNoAliasAAResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResultC1Ev")
  //</editor-fold>
  public /*explicit*/ ScopedNoAliasAAResult() {
    // : AAResultBase<ScopedNoAliasAAResult>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::ScopedNoAliasAAResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScopedNoAliasAA.h", line = 31,
   FQN="llvm::ScopedNoAliasAAResult::ScopedNoAliasAAResult", NM="_ZN4llvm21ScopedNoAliasAAResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResultC1EOS0_")
  //</editor-fold>
  public ScopedNoAliasAAResult(JD$Move _dparam, final ScopedNoAliasAAResult /*&&*/Arg) {
    // : AAResultBase<ScopedNoAliasAAResult>(std::move(Arg)) 
    super(JD$Move.INSTANCE, std.move(Arg));
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Handle invalidation events from the new pass manager.
  ///
  /// By definition, this result is stateless and so remains valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::invalidate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScopedNoAliasAA.h", line = 37,
   FQN="llvm::ScopedNoAliasAAResult::invalidate", NM="_ZN4llvm21ScopedNoAliasAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // end of anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 75,
   FQN="llvm::ScopedNoAliasAAResult::alias", NM="_ZN4llvm21ScopedNoAliasAAResult5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResult5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 95,
   FQN="llvm::ScopedNoAliasAAResult::getModRefInfo", NM="_ZN4llvm21ScopedNoAliasAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 112,
   FQN="llvm::ScopedNoAliasAAResult::getModRefInfo", NM="_ZN4llvm21ScopedNoAliasAAResult13getModRefInfoENS_17ImmutableCallSiteES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm21ScopedNoAliasAAResult13getModRefInfoENS_17ImmutableCallSiteES1_")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS1, 
               ImmutableCallSite CS2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::mayAliasInScopes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 139,
   FQN="llvm::ScopedNoAliasAAResult::mayAliasInScopes", NM="_ZNK4llvm21ScopedNoAliasAAResult16mayAliasInScopesEPKNS_6MDNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZNK4llvm21ScopedNoAliasAAResult16mayAliasInScopesEPKNS_6MDNodeES3_")
  //</editor-fold>
  private boolean mayAliasInScopes(/*const*/ MDNode /*P*/ Scopes, 
                  /*const*/ MDNode /*P*/ NoAlias) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScopedNoAliasAAResult::collectMDInDomain">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 130,
   FQN="llvm::ScopedNoAliasAAResult::collectMDInDomain", NM="_ZNK4llvm21ScopedNoAliasAAResult17collectMDInDomainEPKNS_6MDNodeES3_RNS_15SmallPtrSetImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZNK4llvm21ScopedNoAliasAAResult17collectMDInDomainEPKNS_6MDNodeES3_RNS_15SmallPtrSetImplIS3_EE")
  //</editor-fold>
  private void collectMDInDomain(/*const*/ MDNode /*P*/ List, /*const*/ MDNode /*P*/ Domain, 
                   final SmallPtrSetImpl</*const*/ MDNode /*P*/ > /*&*/ Nodes) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
