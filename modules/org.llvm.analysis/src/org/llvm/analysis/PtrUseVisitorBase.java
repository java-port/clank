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

/// \brief Implementation of non-dependent functionality for \c PtrUseVisitor.
///
/// See \c PtrUseVisitor for the public interface and detailed comments about
/// usage. This class is just a helper base class which is not templated and
/// contains all common code to be shared between different instantiations of
/// PtrUseVisitor.
//<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 42,
 FQN="llvm::detail::PtrUseVisitorBase", NM="_ZN4llvm6detail17PtrUseVisitorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBaseE")
//</editor-fold>
public class PtrUseVisitorBase implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief This class provides information about the result of a visit.
  ///
  /// After walking all the users (recursively) of a pointer, the basic
  /// infrastructure records some commonly useful information such as escape
  /// analysis and whether the visit completed or aborted early.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 49,
   FQN="llvm::detail::PtrUseVisitorBase::PtrInfo", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoE")
  //</editor-fold>
  public static class PtrInfo {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::PtrInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 51,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::PtrInfo", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoC1Ev")
    //</editor-fold>
    public PtrInfo() {
      // : AbortedInfo(null, false), EscapedInfo(null, false) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Reset the pointer info, clearing all state.
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::reset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 54,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::reset", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo5resetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo5resetEv")
    //</editor-fold>
    public void reset() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Did we abort the visit early?
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::isAborted">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 62,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::isAborted", NM="_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo9isAbortedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo9isAbortedEv")
    //</editor-fold>
    public boolean isAborted() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Is the pointer escaped at some point?
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::isEscaped">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 65,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::isEscaped", NM="_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo9isEscapedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo9isEscapedEv")
    //</editor-fold>
    public boolean isEscaped() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Get the instruction causing the visit to abort.
    /// \returns a pointer to the instruction causing the abort if one is
    /// available; otherwise returns null.
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::getAbortingInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 70,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::getAbortingInst", NM="_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo15getAbortingInstEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo15getAbortingInstEv")
    //</editor-fold>
    public Instruction /*P*/ getAbortingInst() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Get the instruction causing the pointer to escape.
    /// \returns a pointer to the instruction which escapes the pointer if one
    /// is available; otherwise returns null.
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::getEscapingInst">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 75,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::getEscapingInst", NM="_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo15getEscapingInstEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZNK4llvm6detail17PtrUseVisitorBase7PtrInfo15getEscapingInstEv")
    //</editor-fold>
    public Instruction /*P*/ getEscapingInst() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Mark the visit as aborted. Intended for use in a void return.
    /// \param I The instruction which caused the visit to abort, if available.
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::setAborted">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 79,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::setAborted", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo10setAbortedEPNS_11InstructionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo10setAbortedEPNS_11InstructionE")
    //</editor-fold>
    public void setAborted() {
      setAborted((Instruction /*P*/ )null);
    }
    public void setAborted(Instruction /*P*/ I/*= null*/) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Mark the pointer as escaped. Intended for use in a void return.
    /// \param I The instruction which escapes the pointer, if available.
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::setEscaped">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 86,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::setEscaped", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo10setEscapedEPNS_11InstructionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo10setEscapedEPNS_11InstructionE")
    //</editor-fold>
    public void setEscaped() {
      setEscaped((Instruction /*P*/ )null);
    }
    public void setEscaped(Instruction /*P*/ I/*= null*/) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Mark the pointer as escaped, and the visit as aborted. Intended
    /// for use in a void return.
    /// \param I The instruction which both escapes the pointer and aborts the
    /// visit, if available.
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::setEscapedAndAborted">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 95,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::setEscapedAndAborted", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo20setEscapedAndAbortedEPNS_11InstructionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfo20setEscapedAndAbortedEPNS_11InstructionE")
    //</editor-fold>
    public void setEscapedAndAborted() {
      setEscapedAndAborted((Instruction /*P*/ )null);
    }
    public void setEscapedAndAborted(Instruction /*P*/ I/*= null*/) {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private PointerBoolPair<Instruction /*P*/ > AbortedInfo;
    private PointerBoolPair<Instruction /*P*/ > EscapedInfo;

    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::PtrInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 49,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::PtrInfo", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoC1ERKS2_")
    //</editor-fold>
    public /*inline*/ PtrInfo(final /*const*/ PtrInfo /*&*/ $Prm0) {
      // : AbortedInfo(.AbortedInfo), EscapedInfo(.EscapedInfo) 
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrInfo::PtrInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 49,
     FQN="llvm::detail::PtrUseVisitorBase::PtrInfo::PtrInfo", NM="_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase7PtrInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ PtrInfo(JD$Move _dparam, final PtrInfo /*&&*/$Prm0) {
      // : AbortedInfo(static_cast<PtrInfo &&>().AbortedInfo), EscapedInfo(static_cast<PtrInfo &&>().EscapedInfo) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "AbortedInfo=" + AbortedInfo // NOI18N
                + ", EscapedInfo=" + EscapedInfo; // NOI18N
    }
  };
/*protected:*/
  protected final /*const*/ DataLayout /*&*/ DL;
  
  /// \name Visitation infrastructure
  /// @{
  
  /// \brief The info collected about the pointer being visited thus far.
  protected PtrInfo PI;
  
  /// \brief A struct of the data needed to visit a particular use.
  ///
  /// This is used to maintain a worklist fo to-visit uses. This is used to
  /// make the visit be iterative rather than recursive.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::UseToVisit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 117,
   FQN="llvm::detail::PtrUseVisitorBase::UseToVisit", NM="_ZN4llvm6detail17PtrUseVisitorBase10UseToVisitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase10UseToVisitE")
  //</editor-fold>
  protected static class/*struct*/ UseToVisit implements Destructors.ClassWithDestructor {
    // JAVA: typedef PointerIntPair<Use *, 1, bool> UseAndIsOffsetKnownPair
//    public final class UseAndIsOffsetKnownPair extends PointerBoolPair<Use /*P*/ >{ };
    public PointerBoolPair<Use /*P*/ > UseAndIsOffsetKnown;
    public APInt Offset;
    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::UseToVisit::UseToVisit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 117,
     FQN="llvm::detail::PtrUseVisitorBase::UseToVisit::UseToVisit", NM="_ZN4llvm6detail17PtrUseVisitorBase10UseToVisitC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase10UseToVisitC1EOS2_")
    //</editor-fold>
    public /*inline*/ UseToVisit(JD$Move _dparam, final UseToVisit /*&&*/$Prm0) {
      // : UseAndIsOffsetKnown(static_cast<UseToVisit &&>().UseAndIsOffsetKnown), Offset(static_cast<UseToVisit &&>().Offset) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::UseToVisit::~UseToVisit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 117,
     FQN="llvm::detail::PtrUseVisitorBase::UseToVisit::~UseToVisit", NM="_ZN4llvm6detail17PtrUseVisitorBase10UseToVisitD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase10UseToVisitD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "UseAndIsOffsetKnown=" + UseAndIsOffsetKnown // NOI18N
                + ", Offset=" + Offset; // NOI18N
    }
  };
  
  /// \brief The worklist of to-visit uses.
  protected SmallVector<UseToVisit> Worklist;
  
  /// \brief A set of visited uses to break cycles in unreachable code.
  protected SmallPtrSet<Use /*P*/ > VisitedUses;
  
  /// @}
  
  /// \name Per-visit state
  /// This state is reset for each instruction visited.
  /// @{
  
  /// \brief The use currently being visited.
  protected Use /*P*/ U;
  
  /// \brief True if we have a known constant offset for the use currently
  /// being visited.
  protected boolean IsOffsetKnown;
  
  /// \brief The constant offset of the use if that is known.
  protected APInt Offset;
  
  /// @}
  
  /// Note that the constructor is protected because this class must be a base
  /// class, we can't create instances directly of this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::PtrUseVisitorBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 151,
   FQN="llvm::detail::PtrUseVisitorBase::PtrUseVisitorBase", NM="_ZN4llvm6detail17PtrUseVisitorBaseC1ERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBaseC1ERKNS_10DataLayoutE")
  //</editor-fold>
  protected PtrUseVisitorBase(final /*const*/ DataLayout /*&*/ DL) {
    // : DL(DL), PI(), Worklist(), VisitedUses(), Offset() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Enqueue the users of this instruction in the visit worklist.
  ///
  /// This will visit the users with the same offset of the current visit
  /// (including an unknown offset if that is the current state).
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::enqueueUsers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp", line = 18,
   FQN="llvm::detail::PtrUseVisitorBase::enqueueUsers", NM="_ZN4llvm6detail17PtrUseVisitorBase12enqueueUsersERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase12enqueueUsersERNS_11InstructionE")
  //</editor-fold>
  protected void enqueueUsers(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Walk the operands of a GEP and adjust the offset as appropriate.
  ///
  /// This routine does the heavy lifting of the pointer walk by computing
  /// offsets and looking through GEPs.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::adjustOffsetForGEP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp", line = 30,
   FQN="llvm::detail::PtrUseVisitorBase::adjustOffsetForGEP", NM="_ZN4llvm6detail17PtrUseVisitorBase18adjustOffsetForGEPERNS_17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PtrUseVisitor.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBase18adjustOffsetForGEPERNS_17GetElementPtrInstE")
  //</editor-fold>
  protected boolean adjustOffsetForGEP(final GetElementPtrInst /*&*/ GEPI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PtrUseVisitorBase::~PtrUseVisitorBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PtrUseVisitor.h", line = 42,
   FQN="llvm::detail::PtrUseVisitorBase::~PtrUseVisitorBase", NM="_ZN4llvm6detail17PtrUseVisitorBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm6detail17PtrUseVisitorBaseD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "DL=" + DL // NOI18N
              + ", PI=" + PI // NOI18N
              + ", Worklist=" + Worklist // NOI18N
              + ", VisitedUses=" + VisitedUses // NOI18N
              + ", U=" + U // NOI18N
              + ", IsOffsetKnown=" + IsOffsetKnown // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}
