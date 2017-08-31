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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

// end namespace detail

/// \brief A base class for visitors over the uses of a pointer value.
///
/// Once constructed, a user can call \c visit on a pointer value, and this
/// will walk its uses and visit each instruction using an InstVisitor. It also
/// provides visit methods which will recurse through any pointer-to-pointer
/// transformations such as GEPs and bitcasts.
///
/// During the visit, the current Use* being visited is available to the
/// subclass, as well as the current offset from the original base pointer if
/// known.
///
/// The recursive visit of uses is accomplished with a worklist, so the only
/// ordering guarantee is that an instruction is visited before any uses of it
/// are visited. Note that this does *not* mean before any of its users are
/// visited! This is because users can be visited multiple times due to
/// multiple, different uses of pointers derived from the same base.
///
/// A particular Use will only be visited once, but a User may be visited
/// multiple times, once per Use. This visits may notably have different
/// offsets.
///
/// All visit methods on the underlying InstVisitor return a boolean. This
/// return short-circuits the visit, stopping it immediately.
///
/// FIXME: Generalize this for all values rather than just instructions.
/*template <typename DerivedT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 192,
 FQN="llvm::PtrUseVisitor", NM="_ZN4llvm13PtrUseVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitorE")
//</editor-fold>
public class PtrUseVisitor</*typename*/ DerivedT>  extends /*public*/ PtrUseVisitorBase implements InstVisitorVoid<PtrUseVisitor</*typename*/ DerivedT>>, Destructors.ClassWithDestructor {
  /*friend  class InstVisitor<DerivedT>*/
  // JAVA: typedef InstVisitor<DerivedT> Base
//  public final class Base extends InstVisitor<DerivedT>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::PtrUseVisitor<DerivedT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 199,
   FQN="llvm::PtrUseVisitor::PtrUseVisitor<DerivedT>", NM="_ZN4llvm13PtrUseVisitorC1ERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitorC1ERKNS_10DataLayoutE")
  //</editor-fold>
  public PtrUseVisitor(final /*const*/ DataLayout /*&*/ DL) {
    // : PtrUseVisitorBase(DL) 
    /*ParenListExpr*/super(DL);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Recursively visit the uses of the given pointer.
  /// \returns An info struct about the pointer. See \c PtrInfo for details.
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 203,
   FQN="llvm::PtrUseVisitor::visitPtr", NM="_ZN4llvm13PtrUseVisitor8visitPtrERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor8visitPtrERNS_11InstructionE")
  //</editor-fold>
  public PtrUseVisitorBase.PtrInfo visitPtr(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitStoreInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 233,
   FQN="llvm::PtrUseVisitor::visitStoreInst", NM="_ZN4llvm13PtrUseVisitor14visitStoreInstERNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor14visitStoreInstERNS_9StoreInstE")
  //</editor-fold>
  public/*protected*/ void visitStoreInst(final StoreInst /*&*/ SI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitBitCastInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 238,
   FQN="llvm::PtrUseVisitor::visitBitCastInst", NM="_ZN4llvm13PtrUseVisitor16visitBitCastInstERNS_11BitCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor16visitBitCastInstERNS_11BitCastInstE")
  //</editor-fold>
  public/*protected*/ void visitBitCastInst(final BitCastInst /*&*/ BC) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitPtrToIntInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 242,
   FQN="llvm::PtrUseVisitor::visitPtrToIntInst", NM="_ZN4llvm13PtrUseVisitor17visitPtrToIntInstERNS_12PtrToIntInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor17visitPtrToIntInstERNS_12PtrToIntInstE")
  //</editor-fold>
  public/*protected*/ void visitPtrToIntInst(final PtrToIntInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitGetElementPtrInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 246,
   FQN="llvm::PtrUseVisitor::visitGetElementPtrInst", NM="_ZN4llvm13PtrUseVisitor22visitGetElementPtrInstERNS_17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor22visitGetElementPtrInstERNS_17GetElementPtrInstE")
  //</editor-fold>
  public/*protected*/ void visitGetElementPtrInst(final GetElementPtrInst /*&*/ GEPI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // No-op intrinsics which we know don't escape the pointer to to logic in
  // some other function.
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitDbgInfoIntrinsic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 262,
   FQN="llvm::PtrUseVisitor::visitDbgInfoIntrinsic", NM="_ZN4llvm13PtrUseVisitor21visitDbgInfoIntrinsicERNS_16DbgInfoIntrinsicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor21visitDbgInfoIntrinsicERNS_16DbgInfoIntrinsicE")
  //</editor-fold>
  public/*protected*/ void visitDbgInfoIntrinsic(final DbgInfoIntrinsic /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitMemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 263,
   FQN="llvm::PtrUseVisitor::visitMemIntrinsic", NM="_ZN4llvm13PtrUseVisitor17visitMemIntrinsicERNS_12MemIntrinsicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor17visitMemIntrinsicERNS_12MemIntrinsicE")
  //</editor-fold>
  public/*protected*/ void visitMemIntrinsic(final MemIntrinsic /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitIntrinsicInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 264,
   FQN="llvm::PtrUseVisitor::visitIntrinsicInst", NM="_ZN4llvm13PtrUseVisitor18visitIntrinsicInstERNS_13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor18visitIntrinsicInstERNS_13IntrinsicInstE")
  //</editor-fold>
  public/*protected*/ void visitIntrinsicInst(final IntrinsicInst /*&*/ II) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Generically, arguments to calls and invokes escape the pointer to some
  // other function. Mark that.
  //<editor-fold defaultstate="collapsed" desc="llvm::PtrUseVisitor::visitCallSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 277,
   FQN="llvm::PtrUseVisitor::visitCallSite", NM="_ZN4llvm13PtrUseVisitor13visitCallSiteENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm13PtrUseVisitor13visitCallSiteENS_8CallSiteE")
  //</editor-fold>
  public/*protected*/ void visitCallSite(CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
