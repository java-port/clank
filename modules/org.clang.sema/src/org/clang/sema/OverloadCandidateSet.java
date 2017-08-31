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

package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import java.util.Iterator;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// OverloadCandidateSet - A set of overload candidates, used in C++
/// overload resolution (C++ 13.3).
//<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 701,
 FQN="clang::OverloadCandidateSet", NM="_ZN5clang20OverloadCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSetE")
//</editor-fold>
public class OverloadCandidateSet implements Iterable<OverloadCandidate>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::CandidateSetKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 703,
   FQN="clang::OverloadCandidateSet::CandidateSetKind", NM="_ZN5clang20OverloadCandidateSet16CandidateSetKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet16CandidateSetKindE")
  //</editor-fold>
  public enum CandidateSetKind implements Native.ComparableLower {
    /// Normal lookup.
    CSK_Normal(0),
    /// Lookup for candidates for a call using operator syntax. Candidates
    /// that have no parameters of class type will be skipped unless there
    /// is a parameter of (reference to) enum type and the corresponding
    /// argument is of the same enum type.
    CSK_Operator(CSK_Normal.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CandidateSetKind valueOf(int val) {
      CandidateSetKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CandidateSetKind[] VALUES;
      private static final CandidateSetKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CandidateSetKind kind : CandidateSetKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CandidateSetKind[min < 0 ? (1-min) : 0];
        VALUES = new CandidateSetKind[max >= 0 ? (1+max) : 0];
        for (CandidateSetKind kind : CandidateSetKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CandidateSetKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CandidateSetKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CandidateSetKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private SmallVector<OverloadCandidate> Candidates;
  private SmallPtrSet<Decl /*P*/ > Functions;
  
  // Allocator for OverloadCandidate::Conversions. We store the first few
  // elements inline to avoid allocation for small sets.
  private BumpPtrAllocatorImpl ConversionSequenceAllocator;
  
  private SourceLocation Loc;
  private CandidateSetKind Kind;
  
// JAVA: we don't need this
//  private /*uint*/int NumInlineSequences;
//  private AlignedCharArray InlineSpace;
  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::OverloadCandidateSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 728,
   FQN="clang::OverloadCandidateSet::OverloadCandidateSet", NM="_ZN5clang20OverloadCandidateSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSetC1ERKS0_")
  //</editor-fold>
  private OverloadCandidateSet(final /*const*/ OverloadCandidateSet /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 729,
   FQN="clang::OverloadCandidateSet::operator=", NM="_ZN5clang20OverloadCandidateSetaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSetaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ OverloadCandidateSet /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::destroyCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 804,
   FQN="clang::OverloadCandidateSet::destroyCandidates", NM="_ZN5clang20OverloadCandidateSet17destroyCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet17destroyCandidatesEv")
  //</editor-fold>
  private void destroyCandidates() {
    for (type$ptr<OverloadCandidate> i = $tryClone(begin()), /*P*/ e = $tryClone(end()); $noteq_ptr(i, e); i.$preInc()) {
      for (/*uint*/int ii = 0, ie = i./*->*/$star().NumConversions; ii != ie; ++ii)  {
        i./*->*/$star().Conversions[ii].$destroy();
      }
      if (!i./*->*/$star().Viable && $uchar2int(i./*->*/$star().FailureKind) == OverloadFailureKind.ovl_fail_bad_deduction.getValue()) {
        i./*->*/$star().Unnamed_field12.DeductionFailure.Destroy();
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::OverloadCandidateSet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 734,
   FQN="clang::OverloadCandidateSet::OverloadCandidateSet", NM="_ZN5clang20OverloadCandidateSetC1ENS_14SourceLocationENS0_16CandidateSetKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSetC1ENS_14SourceLocationENS0_16CandidateSetKindE")
  //</editor-fold>
  public OverloadCandidateSet(SourceLocation Loc, CandidateSetKind CSK) {
    // : Candidates(), Functions(), ConversionSequenceAllocator(), Loc(Loc), Kind(CSK), NumInlineSequences(0), InlineSpace() 
    //START JInit
    this.Candidates = new SmallVector<OverloadCandidate>(16, new OverloadCandidate());
    this.Functions = new SmallPtrSet<Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    this.ConversionSequenceAllocator = new BumpPtrAllocatorImpl();
    this.Loc = new SourceLocation(Loc);
    this.Kind = CSK;
    //JAVA: this.NumInlineSequences = 0;
    //JAVA: this.InlineSpace = new AlignedCharArray|16 * $sizeof_ImplicitConversionSequence()();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::~OverloadCandidateSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 736,
   FQN="clang::OverloadCandidateSet::~OverloadCandidateSet", NM="_ZN5clang20OverloadCandidateSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSetD0Ev")
  //</editor-fold>
  public void $destroy() {
    destroyCandidates();
    //START JDestroy
    ConversionSequenceAllocator.$destroy();
    Functions.$destroy();
    Candidates.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 738,
   FQN="clang::OverloadCandidateSet::getLocation", NM="_ZNK5clang20OverloadCandidateSet11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang20OverloadCandidateSet11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 739,
   FQN="clang::OverloadCandidateSet::getKind", NM="_ZNK5clang20OverloadCandidateSet7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang20OverloadCandidateSet7getKindEv")
  //</editor-fold>
  public CandidateSetKind getKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Determine when this overload candidate will be new to the
  /// overload set.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::isNewCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 743,
   FQN="clang::OverloadCandidateSet::isNewCandidate", NM="_ZN5clang20OverloadCandidateSet14isNewCandidateEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet14isNewCandidateEPNS_4DeclE")
  //</editor-fold>
  public boolean isNewCandidate(Decl /*P*/ F) {
    return Functions.insert(F.getCanonicalDecl()).second;
  }

  
  /// \brief Clear out all of the candidates.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 813,
   FQN="clang::OverloadCandidateSet::clear", NM="_ZN5clang20OverloadCandidateSet5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet5clearEv")
  //</editor-fold>
  public void clear() {
    destroyCandidates();
    //JAVA: NumInlineSequences = 0;
    Candidates.clear();
    Functions.clear();
  }

  
  /*typedef SmallVectorImpl<OverloadCandidate>::iterator iterator*/
//  public final class iterator extends type$ptr<OverloadCandidate>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 751,
   FQN="clang::OverloadCandidateSet::begin", NM="_ZN5clang20OverloadCandidateSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet5beginEv")
  //</editor-fold>
  public type$ptr<OverloadCandidate> begin() {
    return Candidates.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 752,
   FQN="clang::OverloadCandidateSet::end", NM="_ZN5clang20OverloadCandidateSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet3endEv")
  //</editor-fold>
  public type$ptr<OverloadCandidate> end() {
    return Candidates.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 754,
   FQN="clang::OverloadCandidateSet::size", NM="_ZNK5clang20OverloadCandidateSet4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang20OverloadCandidateSet4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Candidates.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 755,
   FQN="clang::OverloadCandidateSet::empty", NM="_ZNK5clang20OverloadCandidateSet5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang20OverloadCandidateSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Candidates.empty();
  }

  
  /// \brief Add a new candidate with NumConversions conversion sequence slots
  /// to the overload set.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::addCandidate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 759,
   FQN="clang::OverloadCandidateSet::addCandidate", NM="_ZN5clang20OverloadCandidateSet12addCandidateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet12addCandidateEj")
  //</editor-fold>
  public OverloadCandidate /*&*/ addCandidate() {
    return addCandidate(0);
  }
  public OverloadCandidate /*&*/ addCandidate(/*uint*/int NumConversions/*= 0*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Candidates.push_back_T$RR($c$.track(new OverloadCandidate())); $c$.clean();
      final OverloadCandidate /*&*/ C = Candidates.back();
      
// JAVA: we don't use this optimization
//      // Assign space from the inline array if there are enough free slots
//      // available.
//      if ($lesseq_uint(NumConversions + NumInlineSequences, 16)) {
//        ImplicitConversionSequence[] /*P*/ I = InlineSpace;
//        C.Conversions = /*AddrOf*/I[NumInlineSequences];
//        NumInlineSequences += NumConversions;
//      } else {
        // Otherwise get memory from the allocator.
        if (false) { ConversionSequenceAllocator.<ImplicitConversionSequence>Allocate(ImplicitConversionSequence.class, NumConversions); }
        C.Conversions = new ImplicitConversionSequence[NumConversions];
//      }
      
      // Construct the new objects.
      for (/*uint*/int i = 0; i != NumConversions; ++i)  {
        /*FIXME:NEW_EXPR*//*AddrOf*/C.Conversions[i] = /*new (&C.Conversions[i])*/ new ImplicitConversionSequence();
      }
      
      C.NumConversions = NumConversions;
      return C;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Find the best viable function on this overload set, if it exists.
  
  /// \brief Computes the best viable function (C++ 13.3.3)
  /// within an overload candidate set.
  ///
  /// \param Loc The location of the function name (or operator symbol) for
  /// which overload resolution occurs.
  ///
  /// \param Best If overload resolution was successful or found a deleted
  /// function, \p Best points to the candidate function found.
  ///
  /// \returns The result of overload resolution.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::BestViableFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$assign/$set*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8769,
   FQN="clang::OverloadCandidateSet::BestViableFunction", NM="_ZN5clang20OverloadCandidateSet18BestViableFunctionERNS_4SemaENS_14SourceLocationERPNS_17OverloadCandidateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet18BestViableFunctionERNS_4SemaENS_14SourceLocationERPNS_17OverloadCandidateEb")
  //</editor-fold>
  public OverloadingResult BestViableFunction(final Sema /*&*/ S, SourceLocation Loc, 
                    final type$ptr<OverloadCandidate> /*&*/ Best) {
    return BestViableFunction(S, Loc, 
                    Best, 
                    false);
  }
  public OverloadingResult BestViableFunction(final Sema /*&*/ S, SourceLocation Loc, 
                    final type$ptr<OverloadCandidate> /*&*/ Best, 
                    boolean UserDefinedConversion/*= false*/) {
    // JAVA: make sure not Candidates.$destroy is called, because internal array 
    // is reused for in/out Best param
    SmallVector<OverloadCandidate /*P*/ > Candidates/*J*/= new SmallVector<OverloadCandidate /*P*/ >(16, (OverloadCandidate /*P*/ )null);
    std.transform(begin(), end(), std.back_inserter(Candidates), 
        /*[]*/ (final OverloadCandidate /*&*/ Cand) -> {
              return $AddrOf(Cand);
            });
    
    // [CUDA] HD->H or HD->D calls are technically not allowed by CUDA
    // but accepted by both clang and NVCC. However during a particular
    // compilation mode only one call variant is viable. We need to
    // exclude non-viable overload candidates from consideration based
    // only on their host/device attributes. Specifically, if one
    // candidate call is WrongSide and the other is SameSide, we ignore
    // the WrongSide candidate.
    if (S.getLangOpts().CUDA) {
      /*const*/ FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl(S.CurContext);
      boolean ContainsSameSideCandidate = llvm.any_of(Candidates, /*[&]*/ (OverloadCandidate /*P*/ Cand) -> {
                return (Cand.Function != null)
                   && S.IdentifyCUDAPreference(Caller, Cand.Function)
                   == Sema.CUDAFunctionPreference.CFP_SameSide;
              });
      if (ContainsSameSideCandidate) {
        BoolPredicate<OverloadCandidate> IsWrongSideCandidate = /*[&]*/ (OverloadCandidate /*P*/ Cand) -> {
              return (Cand.Function != null)
                 && S.IdentifyCUDAPreference(Caller, Cand.Function)
                 == Sema.CUDAFunctionPreference.CFP_WrongSide;
            };
        Candidates.erase(std.remove_if(Candidates.begin(), Candidates.end(), IsWrongSideCandidate), Candidates.end());
      }
    }
    
    // Find the best viable function.
    Best.$assign(end());
    // JAVA: we need Cand to be iterator here, replace loop    
//    for (OverloadCandidate /*P*/ Cand : Candidates)  {
    for (type$ptr<OverloadCandidate> Cand = Candidates.begin(), E = Candidates.end();
            Cand.$noteq(E); Cand.$preInc()) {
      if (Cand.$arrow().Viable) {
        if ($eq_ptr(Best, end()) || isBetterOverloadCandidate(S, $Deref(Cand.$star()), Best.$star(), new SourceLocation(Loc), 
            UserDefinedConversion)) {
          // JAVA: must use $assign here, not $set
          // It will work in Java, because we will reuse array from Candidates
          // and Candidates will not be destroyed in this function neither by us nor by JVM
          Best.$assign(Cand);
        }
      }
    }
    
    // If we didn't find any viable functions, abort.
    if ($eq_ptr(Best, end())) {
      return OverloadingResult.OR_No_Viable_Function;
    }
    
    SmallVector</*const*/ NamedDecl /*P*/ > EquivalentCands/*J*/= new SmallVector</*const*/ NamedDecl /*P*/ >(4, (/*const*/ NamedDecl /*P*/ )null);
    
    // Make sure that this function is better than every other viable
    // function. If not, we have an ambiguity.
    for (OverloadCandidate /*P*/ Cand : Candidates) {
      if (Cand.Viable
         && Cand != Best.$star()
         && !isBetterOverloadCandidate(S, Best.$star(), $Deref(Cand), new SourceLocation(Loc), 
          UserDefinedConversion)) {
        if (S.isEquivalentInternalLinkageDeclaration(Best./*->*/$star().Function, 
            Cand.Function)) {
          EquivalentCands.push_back(Cand.Function);
          continue;
        }
        
        Best.$assign(end());
        return OverloadingResult.OR_Ambiguous;
      }
    }
    
    // Best is the best viable function.
    if ((Best./*->*/$star().Function != null)
       && (Best./*->*/$star().Function.isDeleted()
       || S.isFunctionConsideredUnavailable(Best./*->*/$star().Function))) {
      return OverloadingResult.OR_Deleted;
    }
    if (!EquivalentCands.empty()) {
      S.diagnoseEquivalentInternalLinkageDeclarations(new SourceLocation(Loc), Best./*->*/$star().Function, 
          new ArrayRef</*const*/ NamedDecl /*P*/ >(EquivalentCands, true));
    }
    
    return OverloadingResult.OR_Success;
  }

  
  
  /// PrintOverloadCandidates - When overload resolution fails, prints
  /// diagnostic messages containing the candidates in the candidate
  /// set.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidateSet::NoteCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10077,
   FQN="clang::OverloadCandidateSet::NoteCandidates", NM="_ZN5clang20OverloadCandidateSet14NoteCandidatesERNS_4SemaENS_28OverloadCandidateDisplayKindEN4llvm8ArrayRefIPNS_4ExprEEENS4_9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20OverloadCandidateSet14NoteCandidatesERNS_4SemaENS_28OverloadCandidateDisplayKindEN4llvm8ArrayRefIPNS_4ExprEEENS4_9StringRefENS_14SourceLocationE")
  //</editor-fold>
  public void NoteCandidates(final Sema /*&*/ S, 
                OverloadCandidateDisplayKind OCD, 
                ArrayRef<Expr /*P*/ > Args) {
    NoteCandidates(S, 
                OCD, 
                Args, 
                new StringRef(/*KEEP_STR*/$EMPTY), 
                new SourceLocation());
  }
  public void NoteCandidates(final Sema /*&*/ S, 
                OverloadCandidateDisplayKind OCD, 
                ArrayRef<Expr /*P*/ > Args, 
                StringRef Opc/*= ""*/) {
    NoteCandidates(S, 
                OCD, 
                Args, 
                Opc, 
                new SourceLocation());
  }
  public void NoteCandidates(final Sema /*&*/ S, 
                OverloadCandidateDisplayKind OCD, 
                ArrayRef<Expr /*P*/ > Args, 
                StringRef Opc/*= ""*/, 
                SourceLocation OpLoc/*= SourceLocation()*/) {
    // Sort the candidates by viability and position.  Sorting directly would
    // be prohibitive, so we make a set of pointers and sort those.
    SmallVector<OverloadCandidate /*P*/ > Cands/*J*/= new SmallVector<OverloadCandidate /*P*/ >(32, (OverloadCandidate /*P*/ )null);
    if (OCD == OverloadCandidateDisplayKind.OCD_AllCandidates) {
      Cands.reserve(size());
    }
    for (type$ptr<OverloadCandidate> Cand = $tryClone(begin()), /*P*/ LastCand = $tryClone(end()); $noteq_ptr(Cand, LastCand); Cand.$preInc()) {
      if (Cand./*->*/$star().Viable) {
        Cands.push_back(Cand.$star());
      } else if (OCD == OverloadCandidateDisplayKind.OCD_AllCandidates) {
        CompleteNonViableCandidate(S, Cand.$star(), new ArrayRef<Expr /*P*/ >(Args));
        if ((Cand./*->*/$star().Function != null) || Cand./*->*/$star().IsSurrogate) {
          Cands.push_back(Cand.$star());
        }
        // Otherwise, this a non-viable builtin candidate.  We do not, in general,
        // want to list every possible builtin candidate.
      }
    }
    
    std.sort(Cands.begin(), Cands.end(), 
        new CompareOverloadCandidatesForDisplay(S, new SourceLocation(OpLoc), Args.size()));
    
    boolean ReportedAmbiguousConversions = false;
    
    type$ptr<OverloadCandidate /*P*/ /*P*/> I, /*P*/ E;
    /*const*/ OverloadsShown ShowOverloads = S.Diags.getShowOverloads();
    /*uint*/int CandsShown = 0;
    for (I = $tryClone(Cands.begin()) , E = $tryClone(Cands.end()); $noteq_ptr(I, E); I.$preInc()) {
      OverloadCandidate /*P*/ Cand = I.$star();
      
      // Set an arbitrary limit on the number of candidate functions we'll spam
      // the user with.  FIXME: This limit should depend on details of the
      // candidate list.
      if ($greatereq_uint(CandsShown, 4) && ShowOverloads == OverloadsShown.Ovl_Best) {
        break;
      }
      ++CandsShown;
      if ((Cand.Function != null)) {
        NoteFunctionCandidate(S, Cand, Args.size(), 
            /*TakingCandidateAddress=*/ false);
      } else if (Cand.IsSurrogate) {
        NoteSurrogateCandidate(S, Cand);
      } else {
        assert (Cand.Viable) : "Non-viable built-in candidates are not added to Cands.";
        // Generally we only see ambiguities including viable builtin
        // operators if overload resolution got screwed up by an
        // ambiguous user-defined conversion.
        //
        // FIXME: It's quite possible for different conversions to see
        // different ambiguities, though.
        if (!ReportedAmbiguousConversions) {
          NoteAmbiguousUserConversions(S, new SourceLocation(OpLoc), Cand);
          ReportedAmbiguousConversions = true;
        }
        
        // If this is a viable builtin, print it.
        NoteBuiltinOperatorCandidate(S, new StringRef(Opc), new SourceLocation(OpLoc), Cand);
      }
    }
    if ($noteq_ptr(I, E)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.note_ovl_too_many_candidates)), ((int)(E.$sub(I)))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public Iterator<OverloadCandidate> iterator() {return new JavaIterator(begin(), end());}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Candidates=" + Candidates // NOI18N
              + ", Functions=" + Functions // NOI18N
              + ", ConversionSequenceAllocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
