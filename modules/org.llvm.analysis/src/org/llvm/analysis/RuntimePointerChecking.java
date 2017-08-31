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


/// \brief Holds information about the memory runtime legality checks to verify
/// that a group of pointers do not overlap.
//<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 332,
 FQN="llvm::RuntimePointerChecking", NM="_ZN4llvm22RuntimePointerCheckingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerCheckingE")
//</editor-fold>
public class RuntimePointerChecking implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::PointerInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 334,
   FQN="llvm::RuntimePointerChecking::PointerInfo", NM="_ZN4llvm22RuntimePointerChecking11PointerInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking11PointerInfoE")
  //</editor-fold>
  public static class/*struct*/ PointerInfo implements Destructors.ClassWithDestructor {
    /// Holds the pointer value that we need to check.
    public TrackingVH<Value> PointerValue;
    /// Holds the pointer value at the beginning of the loop.
    public /*const*/ SCEV /*P*/ Start;
    /// Holds the pointer value at the end of the loop.
    public /*const*/ SCEV /*P*/ End;
    /// Holds the information if this pointer is used for writing to memory.
    public boolean IsWritePtr;
    /// Holds the id of the set of pointers that could be dependent because of a
    /// shared underlying object.
    public /*uint*/int DependencySetId;
    /// Holds the id of the disjoint alias set to which this pointer belongs.
    public /*uint*/int AliasSetId;
    /// SCEV for the access.
    public /*const*/ SCEV /*P*/ Expr;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::PointerInfo::PointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 351,
     FQN="llvm::RuntimePointerChecking::PointerInfo::PointerInfo", NM="_ZN4llvm22RuntimePointerChecking11PointerInfoC1EPNS_5ValueEPKNS_4SCEVES6_bjjS6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking11PointerInfoC1EPNS_5ValueEPKNS_4SCEVES6_bjjS6_")
    //</editor-fold>
    public PointerInfo(Value /*P*/ PointerValue, /*const*/ SCEV /*P*/ Start, /*const*/ SCEV /*P*/ End, 
        boolean IsWritePtr, /*uint*/int DependencySetId, /*uint*/int AliasSetId, 
        /*const*/ SCEV /*P*/ Expr) {
      // : PointerValue(PointerValue), Start(Start), End(End), IsWritePtr(IsWritePtr), DependencySetId(DependencySetId), AliasSetId(AliasSetId), Expr(Expr) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::PointerInfo::~PointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 334,
     FQN="llvm::RuntimePointerChecking::PointerInfo::~PointerInfo", NM="_ZN4llvm22RuntimePointerChecking11PointerInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking11PointerInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::PointerInfo::PointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 334,
     FQN="llvm::RuntimePointerChecking::PointerInfo::PointerInfo", NM="_ZN4llvm22RuntimePointerChecking11PointerInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking11PointerInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ PointerInfo(JD$Move _dparam, final PointerInfo /*&&*/$Prm0) {
      // : PointerValue(static_cast<PointerInfo &&>().PointerValue), Start(static_cast<PointerInfo &&>().Start), End(static_cast<PointerInfo &&>().End), IsWritePtr(static_cast<PointerInfo &&>().IsWritePtr), DependencySetId(static_cast<PointerInfo &&>().DependencySetId), AliasSetId(static_cast<PointerInfo &&>().AliasSetId), Expr(static_cast<PointerInfo &&>().Expr) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "PointerValue=" + PointerValue // NOI18N
                + ", Start=" + Start // NOI18N
                + ", End=" + End // NOI18N
                + ", IsWritePtr=" + IsWritePtr // NOI18N
                + ", DependencySetId=" + DependencySetId // NOI18N
                + ", AliasSetId=" + AliasSetId // NOI18N
                + ", Expr=" + Expr; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::RuntimePointerChecking">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 359,
   FQN="llvm::RuntimePointerChecking::RuntimePointerChecking", NM="_ZN4llvm22RuntimePointerCheckingC1EPNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerCheckingC1EPNS_15ScalarEvolutionE")
  //</editor-fold>
  public RuntimePointerChecking(ScalarEvolution /*P*/ SE) {
    // : Need(false), Pointers(), CheckingGroups(), SE(SE), Checks() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Reset the state of the pointer runtime information.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::reset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 362,
   FQN="llvm::RuntimePointerChecking::reset", NM="_ZN4llvm22RuntimePointerChecking5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking5resetEv")
  //</editor-fold>
  public void reset() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Insert a pointer and calculate the start and end SCEVs.
  /// We need \p PSE in order to compute the SCEV expression of the pointer
  /// according to the assumptions that we've made during the analysis.
  /// The method might also version the pointer stride according to \p Strides,
  /// and add new predicates to \p PSE.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 151,
   FQN="llvm::RuntimePointerChecking::insert", NM="_ZN4llvm22RuntimePointerChecking6insertEPNS_4LoopEPNS_5ValueEbjjRKNS_8DenseMapIPKS3_S4_NS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S4_EEEERNS_25PredicatedScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking6insertEPNS_4LoopEPNS_5ValueEbjjRKNS_8DenseMapIPKS3_S4_NS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S4_EEEERNS_25PredicatedScalarEvolutionE")
  //</editor-fold>
  public void insert(Loop /*P*/ Lp, Value /*P*/ Ptr, boolean WritePtr, 
        /*uint*/int DepSetId, /*uint*/int ASId, 
        final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ Strides, 
        final PredicatedScalarEvolution /*&*/ PSE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief No run-time memory checking is necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 378,
   FQN="llvm::RuntimePointerChecking::empty", NM="_ZNK4llvm22RuntimePointerChecking5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// A grouping of pointers. A single memcheck is required between
  /// two groups.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::CheckingPtrGroup">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 382,
   FQN="llvm::RuntimePointerChecking::CheckingPtrGroup", NM="_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupE")
  //</editor-fold>
  public static class/*struct*/ CheckingPtrGroup implements Destructors.ClassWithDestructor {
    /// \brief Create a new pointer checking group containing a single
    /// pointer, with index \p Index in RtCheck.
    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::CheckingPtrGroup::CheckingPtrGroup">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 385,
     FQN="llvm::RuntimePointerChecking::CheckingPtrGroup::CheckingPtrGroup", NM="_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupC1EjRS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupC1EjRS0_")
    //</editor-fold>
    public CheckingPtrGroup(/*uint*/int Index, final RuntimePointerChecking /*&*/ RtCheck) {
      // : RtCheck(RtCheck), High(RtCheck.Pointers[Index].End), Low(RtCheck.Pointers[Index].Start), Members() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Tries to add the pointer recorded in RtCheck at index
    /// \p Index to this pointer checking group. We can only add a pointer
    /// to a checking group if we will still be able to get
    /// the upper and lower bounds of the check. Returns true in case
    /// of success, false otherwise.
    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::CheckingPtrGroup::addPointer">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 236,
     FQN="llvm::RuntimePointerChecking::CheckingPtrGroup::addPointer", NM="_ZN4llvm22RuntimePointerChecking16CheckingPtrGroup10addPointerEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking16CheckingPtrGroup10addPointerEj")
    //</editor-fold>
    public boolean addPointer(/*uint*/int Index) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Constitutes the context of this pointer checking group. For each
    /// pointer that is a member of this group we will retain the index
    /// at which it appears in RtCheck.
    public final RuntimePointerChecking /*&*/ RtCheck;
    /// The SCEV expression which represents the upper bound of all the
    /// pointers in this group.
    public /*const*/ SCEV /*P*/ High;
    /// The SCEV expression which represents the lower bound of all the
    /// pointers in this group.
    public /*const*/ SCEV /*P*/ Low;
    /// Indices of all the pointers that constitute this grouping.
    public SmallVectorUInt Members;
    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::CheckingPtrGroup::CheckingPtrGroup">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 382,
     FQN="llvm::RuntimePointerChecking::CheckingPtrGroup::CheckingPtrGroup", NM="_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupC1EOS1_")
    //</editor-fold>
    public /*inline*/ CheckingPtrGroup(JD$Move _dparam, final CheckingPtrGroup /*&&*/$Prm0) {
      // : RtCheck(static_cast<CheckingPtrGroup &&>().RtCheck), High(static_cast<CheckingPtrGroup &&>().High), Low(static_cast<CheckingPtrGroup &&>().Low), Members(static_cast<CheckingPtrGroup &&>().Members) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::CheckingPtrGroup::CheckingPtrGroup">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 382,
     FQN="llvm::RuntimePointerChecking::CheckingPtrGroup::CheckingPtrGroup", NM="_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupC1ERKS1_")
    //</editor-fold>
    public /*inline*/ CheckingPtrGroup(final /*const*/ CheckingPtrGroup /*&*/ $Prm0) {
      // : RtCheck(.RtCheck), High(.High), Low(.Low), Members(.Members) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::CheckingPtrGroup::~CheckingPtrGroup">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 382,
     FQN="llvm::RuntimePointerChecking::CheckingPtrGroup::~CheckingPtrGroup", NM="_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking16CheckingPtrGroupD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "RtCheck=" + RtCheck // NOI18N
                + ", High=" + High // NOI18N
                + ", Low=" + Low // NOI18N
                + ", Members=" + Members; // NOI18N
    }
  };
  
  /// \brief A memcheck which made up of a pair of grouped pointers.
  ///
  /// These *have* to be const for now, since checks are generated from
  /// CheckingPtrGroups in LAI::addRuntimeChecks which is a const member
  /// function.  FIXME: once check-generation is moved inside this class (after
  /// the PtrPartition hack is removed), we could drop const.
  // JAVA: typedef std::pair<const CheckingPtrGroup *, const CheckingPtrGroup *> PointerCheck
//  public final class PointerCheck extends std.pair</*const*/ CheckingPtrGroup /*P*/ , /*const*/ CheckingPtrGroup /*P*/ >{ };
  
  /// \brief Generate the checks and store it.  This also performs the grouping
  /// of pointers to reduce the number of memchecks necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::generateChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 206,
   FQN="llvm::RuntimePointerChecking::generateChecks", NM="_ZN4llvm22RuntimePointerChecking14generateChecksERNS_18EquivalenceClassesINS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking14generateChecksERNS_18EquivalenceClassesINS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEEEEb")
  //</editor-fold>
  public void generateChecks(final EquivalenceClasses<PointerBoolPair<Value /*P*/ > > /*&*/ DepCands, boolean UseDependencies) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the checks that generateChecks created.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::getChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 427,
   FQN="llvm::RuntimePointerChecking::getChecks", NM="_ZNK4llvm22RuntimePointerChecking9getChecksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking9getChecksEv")
  //</editor-fold>
  public /*const*/SmallVector<std.pair</*const*/ CheckingPtrGroup /*P*/ , /*const*/ CheckingPtrGroup /*P*/ >> /*&*/ getChecks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Decide if we need to add a check between two groups of pointers,
  /// according to needsChecking.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::needsChecking">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 213,
   FQN="llvm::RuntimePointerChecking::needsChecking", NM="_ZNK4llvm22RuntimePointerChecking13needsCheckingERKNS0_16CheckingPtrGroupES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking13needsCheckingERKNS0_16CheckingPtrGroupES3_")
  //</editor-fold>
  public boolean needsChecking(final /*const*/ CheckingPtrGroup /*&*/ M, 
               final /*const*/ CheckingPtrGroup /*&*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the number of run-time checks required according to
  /// needsChecking.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::getNumberOfChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 436,
   FQN="llvm::RuntimePointerChecking::getNumberOfChecks", NM="_ZNK4llvm22RuntimePointerChecking17getNumberOfChecksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking17getNumberOfChecksEv")
  //</editor-fold>
  public /*uint*/int getNumberOfChecks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Print the list run-time memory checks necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 428,
   FQN="llvm::RuntimePointerChecking::print", NM="_ZNK4llvm22RuntimePointerChecking5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking5printERNS_11raw_ostreamEj")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, 0);
  }
  public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Print \p Checks.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::printChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 409,
   FQN="llvm::RuntimePointerChecking::printChecks", NM="_ZNK4llvm22RuntimePointerChecking11printChecksERNS_11raw_ostreamERKNS_15SmallVectorImplISt4pairIPKNS0_16CheckingPtrGroupES7_EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking11printChecksERNS_11raw_ostreamERKNS_15SmallVectorImplISt4pairIPKNS0_16CheckingPtrGroupES7_EEEj")
  //</editor-fold>
  public void printChecks(final raw_ostream /*&*/ OS, final /*const*/ SmallVectorImpl<std.pair</*const*/ CheckingPtrGroup /*P*/ , /*const*/ CheckingPtrGroup /*P*/ > > /*&*/ Checks) /*const*/ {
    printChecks(OS, Checks, 
             0);
  }
  public void printChecks(final raw_ostream /*&*/ OS, final /*const*/ SmallVectorImpl<std.pair</*const*/ CheckingPtrGroup /*P*/ , /*const*/ CheckingPtrGroup /*P*/ > > /*&*/ Checks, 
             /*uint*/int Depth/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This flag indicates if we need to add the runtime check.
  public boolean Need;
  
  /// Information about the pointers that may require checking.
  public SmallVector<PointerInfo> Pointers;
  
  /// Holds a partitioning of pointers into "check groups".
  public SmallVector<CheckingPtrGroup> CheckingGroups;
  
  /// \brief Check if pointers are in the same partition
  ///
  /// \p PtrToPartition contains the partition number for pointers (-1 if the
  /// pointer belongs to multiple partitions).
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::arePointersInSamePartition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 383,
   FQN="llvm::RuntimePointerChecking::arePointersInSamePartition", NM="_ZN4llvm22RuntimePointerChecking26arePointersInSamePartitionERKNS_15SmallVectorImplIiEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking26arePointersInSamePartitionERKNS_15SmallVectorImplIiEEjj")
  //</editor-fold>
  public static boolean arePointersInSamePartition(final /*const*/SmallVectorImplInt/*&*/ PtrToPartition, /*uint*/int PtrIdx1, 
                            /*uint*/int PtrIdx2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Decide whether we need to issue a run-time check for pointer at
  /// index \p I and \p J to prove their independence.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::needsChecking">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 390,
   FQN="llvm::RuntimePointerChecking::needsChecking", NM="_ZNK4llvm22RuntimePointerChecking13needsCheckingEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking13needsCheckingEjj")
  //</editor-fold>
  public boolean needsChecking(/*uint*/int I, /*uint*/int J) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return PointerInfo for pointer at index \p PtrIdx.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::getPointerInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 467,
   FQN="llvm::RuntimePointerChecking::getPointerInfo", NM="_ZNK4llvm22RuntimePointerChecking14getPointerInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking14getPointerInfoEj")
  //</editor-fold>
  public /*const*/ PointerInfo /*&*/ getPointerInfo(/*uint*/int PtrIdx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Groups pointers such that a single memcheck is required
  /// between two different groups. This will clear the CheckingGroups vector
  /// and re-compute it. We will only group dependecies if \p UseDependencies
  /// is true, otherwise we will create a separate group for each pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::groupChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 263,
   FQN="llvm::RuntimePointerChecking::groupChecks", NM="_ZN4llvm22RuntimePointerChecking11groupChecksERNS_18EquivalenceClassesINS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerChecking11groupChecksERNS_18EquivalenceClassesINS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEEEEb")
  //</editor-fold>
  private void groupChecks(final EquivalenceClasses<PointerBoolPair<Value /*P*/ > > /*&*/ DepCands, boolean UseDependencies) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Generate the checks and return them.
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::generateChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 190,
   FQN="llvm::RuntimePointerChecking::generateChecks", NM="_ZNK4llvm22RuntimePointerChecking14generateChecksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm22RuntimePointerChecking14generateChecksEv")
  //</editor-fold>
  private SmallVector<std.pair</*const*/ CheckingPtrGroup /*P*/ , /*const*/ CheckingPtrGroup /*P*/ >> generateChecks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Holds a pointer to the ScalarEvolution analysis.
  private ScalarEvolution /*P*/ SE;
  
  /// \brief Set of run-time checks required to establish independence of
  /// otherwise may-aliasing pointers in the loop.
  private SmallVector<std.pair</*const*/ CheckingPtrGroup /*P*/ , /*const*/ CheckingPtrGroup /*P*/ >> Checks;
  //<editor-fold defaultstate="collapsed" desc="llvm::RuntimePointerChecking::~RuntimePointerChecking">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 332,
   FQN="llvm::RuntimePointerChecking::~RuntimePointerChecking", NM="_ZN4llvm22RuntimePointerCheckingD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22RuntimePointerCheckingD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Need=" + Need // NOI18N
              + ", Pointers=" + Pointers // NOI18N
              + ", CheckingGroups=" + CheckingGroups // NOI18N
              + ", SE=" + SE // NOI18N
              + ", Checks=" + Checks; // NOI18N
  }
}
