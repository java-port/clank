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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.ilist_iterator;
import org.llvm.ir.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;
import static org.llvm.ir.java.IrRTTI.isa_Constant;
import static org.llvm.ir.java.IrRTTI.isa_GlobalValue;
import static org.llvm.support.AdtsupportLlvmGlobals.isStrongerThanMonotonic;

//<editor-fold defaultstate="collapsed" desc="llvm::AAResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 166,
 FQN="llvm::AAResults", NM="_ZN4llvm9AAResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResultsE")
//</editor-fold>
public class AAResults implements Destructors.ClassWithDestructor {
/*public:*/
  // Make these results default constructable and movable. We have to spell
  // these out because MSVC won't synthesize them.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::AAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 170,
   FQN="llvm::AAResults::AAResults", NM="_ZN4llvm9AAResultsC1ERKNS_17TargetLibraryInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResultsC1ERKNS_17TargetLibraryInfoE")
  //</editor-fold>
  public AAResults(final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    // : TLI(TLI), AAs() 
    //START JInit
    this./*&*/TLI=/*&*/TLI;
    this.AAs = new std.vector<std.unique_ptr<Concept>>(new std.unique_ptr<Concept>());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::AAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 56,
   FQN="llvm::AAResults::AAResults", NM="_ZN4llvm9AAResultsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResultsC1EOS0_")
  //</editor-fold>
  public AAResults(JD$Move _dparam, final AAResults /*&&*/Arg) {
    // : TLI(Arg.TLI), AAs(std::move(Arg.AAs)) 
    //START JInit
    this./*&*/TLI=/*&*/Arg.TLI;
    this.AAs = new std.vector<std.unique_ptr<Concept>>(JD$Move.INSTANCE, std.move(Arg.AAs));
    //END JInit
    for (final unique_ptr<Concept> /*&*/ AA : AAs)  {
      AA.$arrow().setAAResults(this);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::~AAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 61,
   FQN="llvm::AAResults::~AAResults", NM="_ZN4llvm9AAResultsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResultsD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    AAs.$destroy();
    //END JDestroy
  }

  
  /// Register a specific AA result.
  /*template <typename AAResultT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::addAAResult">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 175,
   FQN="llvm::AAResults::addAAResult", NM="Tpl__ZN4llvm9AAResults11addAAResultERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvm9AAResults11addAAResultERT_")
  //</editor-fold>
  public </*typename*/ AAResultT extends AAResultBase> void addAAResult(final AAResultT /*&*/ AAResult) {
    // FIXME: We should use a much lighter weight system than the usual
    // polymorphic pattern because we don't own AAResult. It should
    // ideally involve two pointers and no separate allocation.
    //std.unique_ptr<Concept>
//    throw new UnsupportedOperationException("EmptyBody");
    AAs.emplace_back(/*FIXME: NEW_EXPR [NoNewFun]*/std.make_unique(new Model<AAResultT>( AAResult, /*Deref*/this )));
  }

  
  //===--------------------------------------------------------------------===//
  /// \name Alias Queries
  /// @{
  
  /// The main low level interface to the alias analysis implementation.
  /// Returns an AliasResult indicating whether the two pointers are aliased to
  /// each other. This is the interface that must be implemented by specific
  /// alias analysis implementations.
  
  //===----------------------------------------------------------------------===//
  // Default chaining methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 76,
   FQN="llvm::AAResults::alias", NM="_ZN4llvm9AAResults5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs) {
      AliasResult Result = AA.$arrow().alias(LocA, LocB);
      if (Result != AliasResult.MayAlias) {
        return Result;
      }
    }
    return AliasResult.MayAlias;
  }

  
  /// A convenience wrapper around the primary \c alias interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 193,
   FQN="llvm::AAResults::alias", NM="_ZN4llvm9AAResults5aliasEPKNS_5ValueEyS3_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5aliasEPKNS_5ValueEyS3_y")
  //</editor-fold>
  public AliasResult alias(/*const*/ Value /*P*/ V1, long/*uint64_t*/ V1Size, /*const*/ Value /*P*/ V2, 
       long/*uint64_t*/ V2Size) {
    return alias(new MemoryLocation(V1, V1Size), new MemoryLocation(V2, V2Size));
  }

  
  /// A convenience wrapper around the primary \c alias interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 199,
   FQN="llvm::AAResults::alias", NM="_ZN4llvm9AAResults5aliasEPKNS_5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5aliasEPKNS_5ValueES3_")
  //</editor-fold>
  public AliasResult alias(/*const*/ Value /*P*/ V1, /*const*/ Value /*P*/ V2) {
    return alias(V1, MemoryLocation.UnknownSize, V2, 
        MemoryLocation.UnknownSize);
  }

  
  /// A trivial helper function to check to see if the specified pointers are
  /// no-alias.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::isNoAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 206,
   FQN="llvm::AAResults::isNoAlias", NM="_ZN4llvm9AAResults9isNoAliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults9isNoAliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public boolean isNoAlias(final /*const*/ MemoryLocation /*&*/ LocA, final /*const*/ MemoryLocation /*&*/ LocB) {
    return alias(LocA, LocB) == AliasResult.NoAlias;
  }

  
  /// A convenience wrapper around the \c isNoAlias helper interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::isNoAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 211,
   FQN="llvm::AAResults::isNoAlias", NM="_ZN4llvm9AAResults9isNoAliasEPKNS_5ValueEyS3_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults9isNoAliasEPKNS_5ValueEyS3_y")
  //</editor-fold>
  public boolean isNoAlias(/*const*/ Value /*P*/ V1, long/*uint64_t*/ V1Size, /*const*/ Value /*P*/ V2, 
           long/*uint64_t*/ V2Size) {
    return isNoAlias(new MemoryLocation(V1, V1Size), new MemoryLocation(V2, V2Size));
  }

  
  /// A convenience wrapper around the \c isNoAlias helper interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::isNoAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 217,
   FQN="llvm::AAResults::isNoAlias", NM="_ZN4llvm9AAResults9isNoAliasEPKNS_5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults9isNoAliasEPKNS_5ValueES3_")
  //</editor-fold>
  public boolean isNoAlias(/*const*/ Value /*P*/ V1, /*const*/ Value /*P*/ V2) {
    return isNoAlias(new MemoryLocation(V1), new MemoryLocation(V2));
  }

  
  /// A trivial helper function to check to see if the specified pointers are
  /// must-alias.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::isMustAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 223,
   FQN="llvm::AAResults::isMustAlias", NM="_ZN4llvm9AAResults11isMustAliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults11isMustAliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public boolean isMustAlias(final /*const*/ MemoryLocation /*&*/ LocA, final /*const*/ MemoryLocation /*&*/ LocB) {
    return alias(LocA, LocB) == AliasResult.MustAlias;
  }

  
  /// A convenience wrapper around the \c isMustAlias helper interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::isMustAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 228,
   FQN="llvm::AAResults::isMustAlias", NM="_ZN4llvm9AAResults11isMustAliasEPKNS_5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults11isMustAliasEPKNS_5ValueES3_")
  //</editor-fold>
  public boolean isMustAlias(/*const*/ Value /*P*/ V1, /*const*/ Value /*P*/ V2) {
    return alias(V1, $int2ulong(1), V2, $int2ulong(1)) == AliasResult.MustAlias;
  }

  
  /// Checks whether the given location points to constant memory, or if
  /// \p OrLocal is true whether it points to a local alloca.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::pointsToConstantMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 86,
   FQN="llvm::AAResults::pointsToConstantMemory", NM="_ZN4llvm9AAResults22pointsToConstantMemoryERKNS_14MemoryLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults22pointsToConstantMemoryERKNS_14MemoryLocationEb")
  //</editor-fold>
  public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc) {
    return pointsToConstantMemory(Loc, 
                        false);
  }
  public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, 
                        boolean OrLocal/*= false*/) {
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs)  {
      if (AA.$arrow().pointsToConstantMemory(Loc, OrLocal)) {
        return true;
      }
    }
    
    return false;
  }

  
  /// A convenience wrapper around the primary \c pointsToConstantMemory
  /// interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::pointsToConstantMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 238,
   FQN="llvm::AAResults::pointsToConstantMemory", NM="_ZN4llvm9AAResults22pointsToConstantMemoryEPKNS_5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults22pointsToConstantMemoryEPKNS_5ValueEb")
  //</editor-fold>
  public boolean pointsToConstantMemory(/*const*/ Value /*P*/ P) {
    return pointsToConstantMemory(P, false);
  }
  public boolean pointsToConstantMemory(/*const*/ Value /*P*/ P, boolean OrLocal/*= false*/) {
    return pointsToConstantMemory(new MemoryLocation(P), OrLocal);
  }

  
  /// @}
  //===--------------------------------------------------------------------===//
  /// \name Simple mod/ref information
  /// @{
  
  /// Get the ModRef info associated with a pointer argument of a callsite. The
  /// result's bits are set to indicate the allowed aliasing ModRef kinds. Note
  /// that these bits do not necessarily account for the overall behavior of
  /// the function, but rather only provide additional per-argument
  /// information.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getArgModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 95,
   FQN="llvm::AAResults::getArgModRefInfo", NM="_ZN4llvm9AAResults16getArgModRefInfoENS_17ImmutableCallSiteEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults16getArgModRefInfoENS_17ImmutableCallSiteEj")
  //</editor-fold>
  public ModRefInfo getArgModRefInfo(ImmutableCallSite CS, /*uint*/int ArgIdx) {
    ModRefInfo Result = ModRefInfo.MRI_ModRef;
    
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs) {
      Result = ModRefInfo.valueOf(Result.getValue() & AA.$arrow().getArgModRefInfo(new ImmutableCallSite(CS), ArgIdx).getValue());
      
      // Early-exit the moment we reach the bottom of the lattice.
      if (Result == ModRefInfo.MRI_NoModRef) {
        return Result;
      }
    }
    
    return Result;
  }

  
  /// Return the behavior of the given call site.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 283,
   FQN="llvm::AAResults::getModRefBehavior", NM="_ZN4llvm9AAResults17getModRefBehaviorENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults17getModRefBehaviorENS_17ImmutableCallSiteE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
    FunctionModRefBehavior Result = FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs) {
      Result = FunctionModRefBehavior.valueOf(Result.getValue() & AA.$arrow().getModRefBehavior(new ImmutableCallSite(CS)).getValue());
      
      // Early-exit the moment we reach the bottom of the lattice.
      if (Result == FunctionModRefBehavior.FMRB_DoesNotAccessMemory) {
        return Result;
      }
    }
    
    return Result;
  }

  
  /// Return the behavior when calling the given function.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 297,
   FQN="llvm::AAResults::getModRefBehavior", NM="_ZN4llvm9AAResults17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    FunctionModRefBehavior Result = FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs) {
      Result = FunctionModRefBehavior.valueOf(Result.getValue() & AA.$arrow().getModRefBehavior(F).getValue());
      
      // Early-exit the moment we reach the bottom of the lattice.
      if (Result == FunctionModRefBehavior.FMRB_DoesNotAccessMemory) {
        return Result;
      }
    }
    
    return Result;
  }

  
  /// Checks if the specified call is known to never read or write memory.
  ///
  /// Note that if the call only reads from known-constant memory, it is also
  /// legal to return true. Also, calls that unwind the stack are legal for
  /// this predicate.
  ///
  /// Many optimizations (such as CSE and LICM) can be performed on such calls
  /// without worrying about aliasing properties, and many calls have this
  /// property (e.g. calls to 'sin' and 'cos').
  ///
  /// This property corresponds to the GCC 'const' attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 271,
   FQN="llvm::AAResults::doesNotAccessMemory", NM="_ZN4llvm9AAResults19doesNotAccessMemoryENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults19doesNotAccessMemoryENS_17ImmutableCallSiteE")
  //</editor-fold>
  public boolean doesNotAccessMemory(ImmutableCallSite CS) {
    return getModRefBehavior(new ImmutableCallSite(CS)) == FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
  }

  
  /// Checks if the specified function is known to never read or write memory.
  ///
  /// Note that if the function only reads from known-constant memory, it is
  /// also legal to return true. Also, function that unwind the stack are legal
  /// for this predicate.
  ///
  /// Many optimizations (such as CSE and LICM) can be performed on such calls
  /// to such functions without worrying about aliasing properties, and many
  /// functions have this property (e.g. 'sin' and 'cos').
  ///
  /// This property corresponds to the GCC 'const' attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 286,
   FQN="llvm::AAResults::doesNotAccessMemory", NM="_ZN4llvm9AAResults19doesNotAccessMemoryEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults19doesNotAccessMemoryEPKNS_8FunctionE")
  //</editor-fold>
  public boolean doesNotAccessMemory(/*const*/ Function /*P*/ F) {
    return getModRefBehavior(F) == FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
  }

  
  /// Checks if the specified call is known to only read from non-volatile
  /// memory (or not access memory at all).
  ///
  /// Calls that unwind the stack are legal for this predicate.
  ///
  /// This property allows many common optimizations to be performed in the
  /// absence of interfering store instructions, such as CSE of strlen calls.
  ///
  /// This property corresponds to the GCC 'pure' attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 299,
   FQN="llvm::AAResults::onlyReadsMemory", NM="_ZN4llvm9AAResults15onlyReadsMemoryENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults15onlyReadsMemoryENS_17ImmutableCallSiteE")
  //</editor-fold>
  public boolean onlyReadsMemory(ImmutableCallSite CS) {
    return AAResults.onlyReadsMemory(getModRefBehavior(new ImmutableCallSite(CS)));
  }

  
  /// Checks if the specified function is known to only read from non-volatile
  /// memory (or not access memory at all).
  ///
  /// Functions that unwind the stack are legal for this predicate.
  ///
  /// This property allows many common optimizations to be performed in the
  /// absence of interfering store instructions, such as CSE of strlen calls.
  ///
  /// This property corresponds to the GCC 'pure' attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 312,
   FQN="llvm::AAResults::onlyReadsMemory", NM="_ZN4llvm9AAResults15onlyReadsMemoryEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults15onlyReadsMemoryEPKNS_8FunctionE")
  //</editor-fold>
  public boolean onlyReadsMemory(/*const*/ Function /*P*/ F) {
    return AAResults.onlyReadsMemory(getModRefBehavior(F));
  }

  
  /// Checks if functions with the specified behavior are known to only read
  /// from non-volatile memory (or not access memory at all).
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 318,
   FQN="llvm::AAResults::onlyReadsMemory", NM="_ZN4llvm9AAResults15onlyReadsMemoryENS_22FunctionModRefBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults15onlyReadsMemoryENS_22FunctionModRefBehaviorE")
  //</editor-fold>
  public static boolean onlyReadsMemory(FunctionModRefBehavior MRB) {
    return !((MRB.getValue() & ModRefInfo.MRI_Mod.getValue()) != 0);
  }

  
  /// Checks if functions with the specified behavior are known to only write
  /// memory (or not access memory at all).
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::doesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 324,
   FQN="llvm::AAResults::doesNotReadMemory", NM="_ZN4llvm9AAResults17doesNotReadMemoryENS_22FunctionModRefBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults17doesNotReadMemoryENS_22FunctionModRefBehaviorE")
  //</editor-fold>
  public static boolean doesNotReadMemory(FunctionModRefBehavior MRB) {
    return !((MRB.getValue() & ModRefInfo.MRI_Ref.getValue()) != 0);
  }

  
  /// Checks if functions with the specified behavior are known to read and
  /// write at most from objects pointed to by their pointer-typed arguments
  /// (with arbitrary offsets).
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::onlyAccessesArgPointees">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 331,
   FQN="llvm::AAResults::onlyAccessesArgPointees", NM="_ZN4llvm9AAResults23onlyAccessesArgPointeesENS_22FunctionModRefBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults23onlyAccessesArgPointeesENS_22FunctionModRefBehaviorE")
  //</editor-fold>
  public static boolean onlyAccessesArgPointees(FunctionModRefBehavior MRB) {
    return !((MRB.getValue() & FunctionModRefLocation.FMRL_Anywhere.getValue() & ~FunctionModRefLocation.FMRL_ArgumentPointees.getValue()) != 0);
  }

  
  /// Checks if functions with the specified behavior are known to potentially
  /// read or write from objects pointed to be their pointer-typed arguments
  /// (with arbitrary offsets).
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::doesAccessArgPointees">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 338,
   FQN="llvm::AAResults::doesAccessArgPointees", NM="_ZN4llvm9AAResults21doesAccessArgPointeesENS_22FunctionModRefBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults21doesAccessArgPointeesENS_22FunctionModRefBehaviorE")
  //</editor-fold>
  public static boolean doesAccessArgPointees(FunctionModRefBehavior MRB) {
    return ((MRB.getValue() & ModRefInfo.MRI_ModRef.getValue()) != 0) && ((MRB.getValue() & FunctionModRefLocation.FMRL_ArgumentPointees.getValue()) != 0);
  }

  
  /// getModRefInfo (for call sites) - Return information about whether
  /// a particular call site modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 129,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    ModRefInfo Result = ModRefInfo.MRI_ModRef;
    
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs) {
      Result = ModRefInfo.valueOf(Result.getValue() & AA.$arrow().getModRefInfo(new ImmutableCallSite(CS), Loc).getValue());
      
      // Early-exit the moment we reach the bottom of the lattice.
      if (Result == ModRefInfo.MRI_NoModRef) {
        return Result;
      }
    }
    
    // Try to refine the mod-ref info further using other API entry points to the
    // aggregate set of AA results.
    FunctionModRefBehavior MRB = getModRefBehavior(new ImmutableCallSite(CS));
    if (MRB == FunctionModRefBehavior.FMRB_DoesNotAccessMemory) {
      return ModRefInfo.MRI_NoModRef;
    }
    if (AAResults.onlyReadsMemory(MRB)) {
      Result = ModRefInfo.valueOf(Result.getValue() & ModRefInfo.MRI_Ref.getValue());
    } else if (AAResults.doesNotReadMemory(MRB)) {
      Result = ModRefInfo.valueOf(Result.getValue() & ModRefInfo.MRI_Mod.getValue());
    }
    if (AAResults.onlyAccessesArgPointees(MRB)) {
      boolean DoesAlias = false;
      ModRefInfo AllArgsMask = ModRefInfo.MRI_NoModRef;
      if (AAResults.doesAccessArgPointees(MRB)) {
        for (/*const*/ type$ptr<Use> /*P*/ AI = CS.arg_begin(), AE = CS.arg_end(); Native.$noteq_ptr(AI, AE); AI.$preInc()) {
          /*const*/ Value /*P*/ Arg = $Deref(AI).$Value$P();
          if (!Arg.getType().isPointerTy()) {
            continue;
          }
          /*uint*/int ArgIdx = std.distance(CS.arg_begin(), AI);
          MemoryLocation ArgLoc = MemoryLocation.getForArgument(new ImmutableCallSite(CS), ArgIdx, TLI);
          AliasResult ArgAlias = alias(ArgLoc, Loc);
          if (ArgAlias != AliasResult.NoAlias) {
            ModRefInfo ArgMask = getArgModRefInfo(new ImmutableCallSite(CS), ArgIdx);
            DoesAlias = true;
            AllArgsMask = ModRefInfo.valueOf(AllArgsMask.getValue() | ArgMask.getValue());
          }
        }
      }
      if (!DoesAlias) {
        return ModRefInfo.MRI_NoModRef;
      }
      Result = ModRefInfo.valueOf(Result.getValue() & AllArgsMask.getValue());
    }
    
    // If Loc is a constant memory location, the call definitely could not
    // modify the memory location.
    if (((Result.getValue() & ModRefInfo.MRI_Mod.getValue()) != 0)
       && pointsToConstantMemory(Loc, /*OrLocal*/ false)) {
      Result = ModRefInfo.valueOf(Result.getValue() & ~ModRefInfo.MRI_Mod.getValue());
    }
    
    return Result;
  }

  
  /// getModRefInfo (for call sites) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 347,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoENS_17ImmutableCallSiteEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoENS_17ImmutableCallSiteEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, /*const*/ Value /*P*/ P, 
               long/*uint64_t*/ Size) {
    return getModRefInfo(new ImmutableCallSite(CS), new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for calls) - Return information about whether
  /// a particular call modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 354,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_8CallInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_8CallInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ CallInst /*P*/ C, final /*const*/ MemoryLocation /*&*/ Loc) {
    return getModRefInfo(new ImmutableCallSite(C), Loc);
  }

  
  /// getModRefInfo (for calls) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 359,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_8CallInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_8CallInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_CallInst$C$P_Value$C$P_ulong(/*const*/ CallInst /*P*/ C, /*const*/ Value /*P*/ P, long/*uint64_t*/ Size) {
    return getModRefInfo(C, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for invokes) - Return information about whether
  /// a particular invoke modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 365,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_10InvokeInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_10InvokeInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ InvokeInst /*P*/ I, final /*const*/ MemoryLocation /*&*/ Loc) {
    return getModRefInfo(new ImmutableCallSite(I), Loc);
  }

  
  /// getModRefInfo (for invokes) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 370,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_10InvokeInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_10InvokeInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_InvokeInst$C$P_Value$C$P_ulong(/*const*/ InvokeInst /*P*/ I, /*const*/ Value /*P*/ P, long/*uint64_t*/ Size) {
    return getModRefInfo(I, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for loads) - Return information about whether
  /// a particular load modifies or reads the specified memory location.
  
  //===----------------------------------------------------------------------===//
  // Helper method implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 315,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_8LoadInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_8LoadInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ LoadInst /*P*/ L, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    // Be conservative in the face of volatile/atomic.
    if (!L.isUnordered()) {
      return ModRefInfo.MRI_ModRef;
    }
    
    // If the load address doesn't alias the given address, it doesn't read
    // or write the specified memory.
    if ((Loc.Ptr != null) && !(alias(MemoryLocation.get(L), Loc).getValue() != 0)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    // Otherwise, a load just reads.
    return ModRefInfo.MRI_Ref;
  }

  
  /// getModRefInfo (for loads) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 379,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_8LoadInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_8LoadInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_LoadInst$C$P_Value$C$P_ulong(/*const*/ LoadInst /*P*/ L, /*const*/ Value /*P*/ P, long/*uint64_t*/ Size) {
    return getModRefInfo(L, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for stores) - Return information about whether
  /// a particular store modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 330,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_9StoreInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_9StoreInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ StoreInst /*P*/ S, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    // Be conservative in the face of volatile/atomic.
    if (!S.isUnordered()) {
      return ModRefInfo.MRI_ModRef;
    }
    if ((Loc.Ptr != null)) {
      // If the store address cannot alias the pointer in question, then the
      // specified memory cannot be modified by the store.
      if (!(alias(MemoryLocation.get(S), Loc).getValue() != 0)) {
        return ModRefInfo.MRI_NoModRef;
      }
      
      // If the pointer is a pointer to constant memory, then it could not have
      // been modified by this store.
      if (pointsToConstantMemory(Loc)) {
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    // Otherwise, a store just writes.
    return ModRefInfo.MRI_Mod;
  }

  
  /// getModRefInfo (for stores) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 388,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_9StoreInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_9StoreInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_StoreInst$C$P_Value$C$P_ulong(/*const*/ StoreInst /*P*/ S, /*const*/ Value /*P*/ P, long/*uint64_t*/ Size) {
    return getModRefInfo(S, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for fences) - Return information about whether
  /// a particular store modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 394,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_9FenceInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_9FenceInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ FenceInst /*P*/ S, final /*const*/ MemoryLocation /*&*/ Loc) {
    // Conservatively correct.  (We could possibly be a bit smarter if
    // Loc is a alloca that doesn't escape.)
    return ModRefInfo.MRI_ModRef;
  }

  
  /// getModRefInfo (for fences) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 401,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_9FenceInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_9FenceInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_FenceInst$C$P_Value$C$P_ulong(/*const*/ FenceInst /*P*/ S, /*const*/ Value /*P*/ P, long/*uint64_t*/ Size) {
    return getModRefInfo(S, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for cmpxchges) - Return information about whether
  /// a particular cmpxchg modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 397,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_17AtomicCmpXchgInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_17AtomicCmpXchgInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ AtomicCmpXchgInst /*P*/ CX, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    // Acquire/Release cmpxchg has properties that matter for arbitrary addresses.
    if (isStrongerThanMonotonic(CX.getSuccessOrdering())) {
      return ModRefInfo.MRI_ModRef;
    }
    
    // If the cmpxchg address does not alias the location, it does not access it.
    if ((Loc.Ptr != null) && !(alias(MemoryLocation.get(CX), Loc).getValue() != 0)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    return ModRefInfo.MRI_ModRef;
  }

  
  /// getModRefInfo (for cmpxchges) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 411,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_17AtomicCmpXchgInstEPKNS_5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_17AtomicCmpXchgInstEPKNS_5ValueEj")
  //</editor-fold>
  public ModRefInfo getModRefInfo_AtomicCmpXchgInst$C$P_Value$C$P_uint(/*const*/ AtomicCmpXchgInst /*P*/ CX, /*const*/ Value /*P*/ P, 
                                                    /*uint*/int Size) {
    return getModRefInfo(CX, new MemoryLocation(P, $uint2ulong(Size)));
  }

  
  /// getModRefInfo (for atomicrmws) - Return information about whether
  /// a particular atomicrmw modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 410,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_13AtomicRMWInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_13AtomicRMWInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ AtomicRMWInst /*P*/ RMW, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    // Acquire/Release atomicrmw has properties that matter for arbitrary addresses.
    if (isStrongerThanMonotonic(RMW.getOrdering())) {
      return ModRefInfo.MRI_ModRef;
    }
    
    // If the atomicrmw address does not alias the location, it does not access it.
    if ((Loc.Ptr != null) && !(alias(MemoryLocation.get(RMW), Loc).getValue() != 0)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    return ModRefInfo.MRI_ModRef;
  }

  
  /// getModRefInfo (for atomicrmws) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 421,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_13AtomicRMWInstEPKNS_5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_13AtomicRMWInstEPKNS_5ValueEj")
  //</editor-fold>
  public ModRefInfo getModRefInfo_AtomicRMWInst$C$P_Value$C$P_uint(/*const*/ AtomicRMWInst /*P*/ RMW, /*const*/ Value /*P*/ P, 
                                                /*uint*/int Size) {
    return getModRefInfo(RMW, new MemoryLocation(P, $uint2ulong(Size)));
  }

  
  /// getModRefInfo (for va_args) - Return information about whether
  /// a particular va_arg modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 352,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_9VAArgInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_9VAArgInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ VAArgInst /*P*/ V, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    if ((Loc.Ptr != null)) {
      // If the va_arg address cannot alias the pointer in question, then the
      // specified memory cannot be accessed by the va_arg.
      if (!(alias(MemoryLocation.get(V), Loc).getValue() != 0)) {
        return ModRefInfo.MRI_NoModRef;
      }
      
      // If the pointer is a pointer to constant memory, then it could not have
      // been modified by this va_arg.
      if (pointsToConstantMemory(Loc)) {
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    // Otherwise, a va_arg reads and writes.
    return ModRefInfo.MRI_ModRef;
  }

  
  /// getModRefInfo (for va_args) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 431,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_9VAArgInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_9VAArgInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_VAArgInst$C$P_Value$C$P_ulong(/*const*/ VAArgInst /*P*/ I, /*const*/ Value /*P*/ P, long/*uint64_t*/ Size) {
    return getModRefInfo(I, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for catchpads) - Return information about whether
  /// a particular catchpad modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 371,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_12CatchPadInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_12CatchPadInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ CatchPadInst /*P*/ CatchPad, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    if ((Loc.Ptr != null)) {
      // If the pointer is a pointer to constant memory,
      // then it could not have been modified by this catchpad.
      if (pointsToConstantMemory(Loc)) {
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    // Otherwise, a catchpad reads and writes.
    return ModRefInfo.MRI_ModRef;
  }

  
  /// getModRefInfo (for catchpads) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 440,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_12CatchPadInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_12CatchPadInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_CatchPadInst$C$P_Value$C$P_ulong(/*const*/ CatchPadInst /*P*/ I, /*const*/ Value /*P*/ P, 
                                                long/*uint64_t*/ Size) {
    return getModRefInfo(I, new MemoryLocation(P, Size));
  }

  
  /// getModRefInfo (for catchrets) - Return information about whether
  /// a particular catchret modifies or reads the specified memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 384,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_15CatchReturnInstERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_15CatchReturnInstERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ CatchReturnInst /*P*/ CatchRet, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    if ((Loc.Ptr != null)) {
      // If the pointer is a pointer to constant memory,
      // then it could not have been modified by this catchpad.
      if (pointsToConstantMemory(Loc)) {
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    // Otherwise, a catchret reads and writes.
    return ModRefInfo.MRI_ModRef;
  }

  
  /// getModRefInfo (for catchrets) - A convenience wrapper.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 450,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_15CatchReturnInstEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_15CatchReturnInstEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_CatchReturnInst$C$P_Value$C$P_ulong(/*const*/ CatchReturnInst /*P*/ I, /*const*/ Value /*P*/ P, 
                                                   long/*uint64_t*/ Size) {
    return getModRefInfo(I, new MemoryLocation(P, Size));
  }

  
  /// Check whether or not an instruction may read or write memory (without
  /// regard to a specific location).
  ///
  /// For function calls, this delegates to the alias-analysis specific
  /// call-site mod-ref behavior queries. Otherwise it delegates to the generic
  /// mod ref information query without a location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 461,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_11InstructionE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ Instruction /*P*/ I) {
    {
      ImmutableCallSite CS = new ImmutableCallSite(I);
      if (CS.$bool()) {
        FunctionModRefBehavior MRB = getModRefBehavior(new ImmutableCallSite(CS));
        if ((MRB.getValue() & ModRefInfo.MRI_ModRef.getValue()) == ModRefInfo.MRI_ModRef.getValue()) {
          return ModRefInfo.MRI_ModRef;
        }
        if (((MRB.getValue() & ModRefInfo.MRI_Ref.getValue()) != 0)) {
          return ModRefInfo.MRI_Ref;
        }
        if (((MRB.getValue() & ModRefInfo.MRI_Mod.getValue()) != 0)) {
          return ModRefInfo.MRI_Mod;
        }
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    return getModRefInfo(I, new MemoryLocation());
  }

  
  /// Check whether or not an instruction may read or write the specified
  /// memory location.
  ///
  /// An instruction that doesn't read or write memory may be trivially LICM'd
  /// for example.
  ///
  /// This primarily delegates to specific helpers above.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 483,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_11InstructionERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_11InstructionERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(/*const*/ Instruction /*P*/ I, final /*const*/ MemoryLocation /*&*/ Loc) {
    switch (I.getOpcode()) {
     case Instruction.OtherOps.VAArg:
      return getModRefInfo((/*const*/ VAArgInst /*P*/ )I, Loc);
     case Instruction.MemoryOps.Load:
      return getModRefInfo((/*const*/ LoadInst /*P*/ )I, Loc);
     case Instruction.MemoryOps.Store:
      return getModRefInfo((/*const*/ StoreInst /*P*/ )I, Loc);
     case Instruction.MemoryOps.Fence:
      return getModRefInfo((/*const*/ FenceInst /*P*/ )I, Loc);
     case Instruction.MemoryOps.AtomicCmpXchg:
      return getModRefInfo((/*const*/ AtomicCmpXchgInst /*P*/ )I, Loc);
     case Instruction.MemoryOps.AtomicRMW:
      return getModRefInfo((/*const*/ AtomicRMWInst /*P*/ )I, Loc);
     case Instruction.OtherOps.Call:
      return getModRefInfo((/*const*/ CallInst /*P*/ )I, Loc);
     case Instruction.TermOps.Invoke:
      return getModRefInfo((/*const*/ InvokeInst /*P*/ )I, Loc);
     case Instruction.FuncletPadOps.CatchPad:
      return getModRefInfo((/*const*/ CatchPadInst /*P*/ )I, Loc);
     case Instruction.TermOps.CatchRet:
      return getModRefInfo((/*const*/ CatchReturnInst /*P*/ )I, Loc);
     default:
      return ModRefInfo.MRI_NoModRef;
    }
  }

  
  /// A convenience wrapper for constructing the memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 505,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPKNS_11InstructionEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPKNS_11InstructionEPKNS_5ValueEy")
  //</editor-fold>
  public ModRefInfo getModRefInfo_Instruction$C$P_Value$C$P_ulong(/*const*/ Instruction /*P*/ I, /*const*/ Value /*P*/ P, 
                                               long/*uint64_t*/ Size) {
    return getModRefInfo(I, new MemoryLocation(P, Size));
  }

  
  /// Return information about whether a call and an instruction may refer to
  /// the same memory locations.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 109,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoEPNS_11InstructionENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoEPNS_11InstructionENS_17ImmutableCallSiteE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(Instruction /*P*/ I, ImmutableCallSite Call) {
    {
      // We may have two calls
      ImmutableCallSite CS = new ImmutableCallSite(I);
      if (CS.$bool()) {
        // Check if the two calls modify the same memory
        return getModRefInfo(new ImmutableCallSite(CS), new ImmutableCallSite(Call));
      } else if (I.isFenceLike()) {
        // If this is a fence, just return MRI_ModRef.
        return ModRefInfo.MRI_ModRef;
      } else {
        // Otherwise, check if the call modifies or references the
        // location this memory access defines.  The best we can say
        // is that if the call references what this instruction
        // defines, it must be clobbered by this location.
        /*const*/ MemoryLocation DefLoc = MemoryLocation.get(I);
        if (getModRefInfo(new ImmutableCallSite(Call), DefLoc) != ModRefInfo.MRI_NoModRef) {
          return ModRefInfo.MRI_ModRef;
        }
      }
    }
    return ModRefInfo.MRI_NoModRef;
  }

  
  /// Return information about whether two call sites may refer to the same set
  /// of memory locations. See the AA documentation for details:
  ///   http://llvm.org/docs/AliasAnalysis.html#ModRefInfo
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::getModRefInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 184,
   FQN="llvm::AAResults::getModRefInfo", NM="_ZN4llvm9AAResults13getModRefInfoENS_17ImmutableCallSiteES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults13getModRefInfoENS_17ImmutableCallSiteES1_")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS1, 
               ImmutableCallSite CS2) {
    ModRefInfo Result = ModRefInfo.MRI_ModRef;
    
    for (final /*const*/unique_ptr<Concept> /*&*/ AA : AAs) {
      Result = ModRefInfo.valueOf(Result.getValue() & AA.$arrow().getModRefInfo(new ImmutableCallSite(CS1), new ImmutableCallSite(CS2)).getValue());
      
      // Early-exit the moment we reach the bottom of the lattice.
      if (Result == ModRefInfo.MRI_NoModRef) {
        return Result;
      }
    }
    
    // Try to refine the mod-ref info further using other API entry points to the
    // aggregate set of AA results.
    
    // If CS1 or CS2 are readnone, they don't interact.
    FunctionModRefBehavior CS1B = getModRefBehavior(new ImmutableCallSite(CS1));
    if (CS1B == FunctionModRefBehavior.FMRB_DoesNotAccessMemory) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    FunctionModRefBehavior CS2B = getModRefBehavior(new ImmutableCallSite(CS2));
    if (CS2B == FunctionModRefBehavior.FMRB_DoesNotAccessMemory) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    // If they both only read from memory, there is no dependence.
    if (AAResults.onlyReadsMemory(CS1B) && AAResults.onlyReadsMemory(CS2B)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    // If CS1 only reads memory, the only dependence on CS2 can be
    // from CS1 reading memory written by CS2.
    if (AAResults.onlyReadsMemory(CS1B)) {
      Result = ModRefInfo.valueOf(Result.getValue() & ModRefInfo.MRI_Ref.getValue());
    } else if (AAResults.doesNotReadMemory(CS1B)) {
      Result = ModRefInfo.valueOf(Result.getValue() & ModRefInfo.MRI_Mod.getValue());
    }
    
    // If CS2 only access memory through arguments, accumulate the mod/ref
    // information from CS1's references to the memory referenced by
    // CS2's arguments.
    if (AAResults.onlyAccessesArgPointees(CS2B)) {
      ModRefInfo R = ModRefInfo.MRI_NoModRef;
      if (AAResults.doesAccessArgPointees(CS2B)) {
        for (/*const*/ type$ptr<Use> /*P*/ I = CS2.arg_begin(), E = CS2.arg_end(); Native.$noteq_ptr(I, E); I.$preInc()) {
          /*const*/ Value /*P*/ Arg = $Deref(I).$Value$P();
          if (!Arg.getType().isPointerTy()) {
            continue;
          }
          /*uint*/int CS2ArgIdx = std.distance(CS2.arg_begin(), I);
          MemoryLocation CS2ArgLoc = MemoryLocation.getForArgument(new ImmutableCallSite(CS2), CS2ArgIdx, TLI);
          
          // ArgMask indicates what CS2 might do to CS2ArgLoc, and the dependence
          // of CS1 on that location is the inverse.
          ModRefInfo ArgMask = getArgModRefInfo(new ImmutableCallSite(CS2), CS2ArgIdx);
          if (ArgMask == ModRefInfo.MRI_Mod) {
            ArgMask = ModRefInfo.MRI_ModRef;
          } else if (ArgMask == ModRefInfo.MRI_Ref) {
            ArgMask = ModRefInfo.MRI_Mod;
          }
          
          ArgMask = ModRefInfo.valueOf(ArgMask.getValue() & getModRefInfo(new ImmutableCallSite(CS1), CS2ArgLoc).getValue());
          
          R = ModRefInfo.valueOf((R.getValue() | ArgMask.getValue()) & Result.getValue());
          if (R == Result) {
            break;
          }
        }
      }
      return R;
    }
    
    // If CS1 only accesses memory through arguments, check if CS2 references
    // any of the memory referenced by CS1's arguments. If not, return NoModRef.
    if (AAResults.onlyAccessesArgPointees(CS1B)) {
      ModRefInfo R = ModRefInfo.MRI_NoModRef;
      if (AAResults.doesAccessArgPointees(CS1B)) {
        for (/*const*/ type$ptr<Use> /*P*/ I = CS1.arg_begin(), E = CS1.arg_end(); Native.$noteq_ptr(I, E); I.$preInc()) {
          /*const*/ Value /*P*/ Arg = $Deref(I).$Value$P();
          if (!Arg.getType().isPointerTy()) {
            continue;
          }
          /*uint*/int CS1ArgIdx = std.distance(CS1.arg_begin(), I);
          MemoryLocation CS1ArgLoc = MemoryLocation.getForArgument(new ImmutableCallSite(CS1), CS1ArgIdx, TLI);
          
          // ArgMask indicates what CS1 might do to CS1ArgLoc; if CS1 might Mod
          // CS1ArgLoc, then we care about either a Mod or a Ref by CS2. If CS1
          // might Ref, then we care only about a Mod by CS2.
          ModRefInfo ArgMask = getArgModRefInfo(new ImmutableCallSite(CS1), CS1ArgIdx);
          ModRefInfo ArgR = getModRefInfo(new ImmutableCallSite(CS2), CS1ArgLoc);
          if (((ArgMask.getValue() & ModRefInfo.MRI_Mod.getValue()) != ModRefInfo.MRI_NoModRef.getValue()
             && (ArgR.getValue() & ModRefInfo.MRI_ModRef.getValue()) != ModRefInfo.MRI_NoModRef.getValue())
             || ((ArgMask.getValue() & ModRefInfo.MRI_Ref.getValue()) != ModRefInfo.MRI_NoModRef.getValue()
             && (ArgR.getValue() & ModRefInfo.MRI_Mod.getValue()) != ModRefInfo.MRI_NoModRef.getValue())) {
            R = ModRefInfo.valueOf((R.getValue() | ArgMask.getValue()) & Result.getValue());
          }
          if (R == Result) {
            break;
          }
        }
      }
      return R;
    }
    
    return Result;
  }

  
  /// \brief Return information about whether a particular call site modifies
  /// or reads the specified memory location \p MemLoc before instruction \p I
  /// in a BasicBlock. A ordered basic block \p OBB can be used to speed up
  /// instruction ordering queries inside the BasicBlock containing \p I.
  
  /// \brief Return information about whether a particular call site modifies
  /// or reads the specified memory location \p MemLoc before instruction \p I
  /// in a BasicBlock. A ordered basic block \p OBB can be used to speed up
  /// instruction-ordering queries inside the BasicBlock containing \p I.
  /// FIXME: this is really just shoring-up a deficiency in alias analysis.
  /// BasicAA isn't willing to spend linear time determining whether an alloca
  /// was captured before or after this particular call, while we are. However,
  /// with a smarter AA in place, this test is just wasting compile time.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::callCapturesBefore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 431,
   FQN="llvm::AAResults::callCapturesBefore", NM="_ZN4llvm9AAResults18callCapturesBeforeEPKNS_11InstructionERKNS_14MemoryLocationEPNS_13DominatorTreeEPNS_17OrderedBasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults18callCapturesBeforeEPKNS_11InstructionERKNS_14MemoryLocationEPNS_13DominatorTreeEPNS_17OrderedBasicBlockE")
  //</editor-fold>
  public ModRefInfo callCapturesBefore(/*const*/ Instruction /*P*/ I, 
                    final /*const*/ MemoryLocation /*&*/ MemLoc, 
                    DominatorTree /*P*/ DT) {
    return callCapturesBefore(I, 
                    MemLoc, 
                    DT, 
                    (OrderedBasicBlock /*P*/ )null);
  }
  public ModRefInfo callCapturesBefore(/*const*/ Instruction /*P*/ I, 
                    final /*const*/ MemoryLocation /*&*/ MemLoc, 
                    DominatorTree /*P*/ DT, 
                    OrderedBasicBlock /*P*/ OBB/*= null*/) {
    if (!(DT != null)) {
      return ModRefInfo.MRI_ModRef;
    }
    
    /*const*/ Value /*P*/ Object = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(MemLoc.Ptr, I.getModule$Const().getDataLayout());
    if (!AliasAnalysisLlvmGlobals.isIdentifiedObject(Object) || isa_GlobalValue(Object)
       || isa_Constant(Object)) {
      return ModRefInfo.MRI_ModRef;
    }
    
    ImmutableCallSite CS/*J*/= new ImmutableCallSite(I);
    if (!(CS.getInstruction() != null) || CS.getInstruction() == Object) {
      return ModRefInfo.MRI_ModRef;
    }
    if (AnalysisLlvmGlobals.PointerMayBeCapturedBefore(Object, /* ReturnCaptures */ true, 
        /* StoreCaptures */ true, I, DT, 
        /* include Object */ true, 
        /* OrderedBasicBlock */ OBB)) {
      return ModRefInfo.MRI_ModRef;
    }
    
    /*uint*/int ArgNo = 0;
    ModRefInfo R = ModRefInfo.MRI_NoModRef;
    for (/*const*/ type$ptr<Use> /*P*/ CI = CS.data_operands_begin(), CE = CS.data_operands_end();
         Native.$noteq_ptr(CI, CE); CI.$preInc() , ++ArgNo) {
      // Only look at the no-capture or byval pointer arguments.  If this
      // pointer were passed to arguments that were neither of these, then it
      // couldn't be no-capture.
      if (!($Deref(CI)).$arrow$Const().getType().isPointerTy()
         || (!CS.doesNotCapture(ArgNo) && !CS.isByValArgument(ArgNo))) {
        continue;
      }
      
      // If this is a no-capture pointer argument, see if we can tell that it
      // is impossible to alias the pointer we're checking.  If not, we have to
      // assume that the call could touch the pointer, even though it doesn't
      // escape.
      if (isNoAlias(new MemoryLocation($Deref(CI).$Value$P()), new MemoryLocation(Object))) {
        continue;
      }
      if (CS.doesNotAccessMemory(ArgNo)) {
        continue;
      }
      if (CS.onlyReadsMemory(ArgNo)) {
        R = ModRefInfo.MRI_Ref;
        continue;
      }
      return ModRefInfo.MRI_ModRef;
    }
    return R;
  }

  
  /// \brief A convenience wrapper to synthesize a memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::callCapturesBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 528,
   FQN="llvm::AAResults::callCapturesBefore", NM="_ZN4llvm9AAResults18callCapturesBeforeEPKNS_11InstructionEPKNS_5ValueEyPNS_13DominatorTreeEPNS_17OrderedBasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults18callCapturesBeforeEPKNS_11InstructionEPKNS_5ValueEyPNS_13DominatorTreeEPNS_17OrderedBasicBlockE")
  //</editor-fold>
  public ModRefInfo callCapturesBefore(/*const*/ Instruction /*P*/ I, /*const*/ Value /*P*/ P, 
                    long/*uint64_t*/ Size, DominatorTree /*P*/ DT) {
    return callCapturesBefore(I, P, 
                    Size, DT, 
                    (OrderedBasicBlock /*P*/ )null);
  }
  public ModRefInfo callCapturesBefore(/*const*/ Instruction /*P*/ I, /*const*/ Value /*P*/ P, 
                    long/*uint64_t*/ Size, DominatorTree /*P*/ DT, 
                    OrderedBasicBlock /*P*/ OBB/*= null*/) {
    return callCapturesBefore(I, new MemoryLocation(P, Size), DT, OBB);
  }

  
  /// @}
  //===--------------------------------------------------------------------===//
  /// \name Higher level methods for querying mod/ref information.
  /// @{
  
  /// Check if it is possible for execution of the specified basic block to
  /// modify the location Loc.
  
  /// canBasicBlockModify - Return true if it is possible for execution of the
  /// specified basic block to modify the location Loc.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::canBasicBlockModify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 485,
   FQN="llvm::AAResults::canBasicBlockModify", NM="_ZN4llvm9AAResults19canBasicBlockModifyERKNS_10BasicBlockERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults19canBasicBlockModifyERKNS_10BasicBlockERKNS_14MemoryLocationE")
  //</editor-fold>
  public boolean canBasicBlockModify(final /*const*/ BasicBlock /*&*/ BB, 
                     final /*const*/ MemoryLocation /*&*/ Loc) {
    return canInstructionRangeModRef(BB.front$Const(), BB.back$Const(), Loc, ModRefInfo.MRI_Mod);
  }

  
  /// A convenience wrapper synthesizing a memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::canBasicBlockModify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 544,
   FQN="llvm::AAResults::canBasicBlockModify", NM="_ZN4llvm9AAResults19canBasicBlockModifyERKNS_10BasicBlockEPKNS_5ValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults19canBasicBlockModifyERKNS_10BasicBlockEPKNS_5ValueEy")
  //</editor-fold>
  public boolean canBasicBlockModify(final /*const*/ BasicBlock /*&*/ BB, /*const*/ Value /*P*/ P, 
                     long/*uint64_t*/ Size) {
    return canBasicBlockModify(BB, new MemoryLocation(P, Size));
  }

  
  /// Check if it is possible for the execution of the specified instructions
  /// to mod\ref (according to the mode) the location Loc.
  ///
  /// The instructions to consider are all of the instructions in the range of
  /// [I1,I2] INCLUSIVE. I1 and I2 must be in the same basic block.
  
  /// canInstructionRangeModRef - Return true if it is possible for the
  /// execution of the specified instructions to mod\ref (according to the
  /// mode) the location Loc. The instructions to consider are all
  /// of the instructions in the range of [I1,I2] INCLUSIVE.
  /// I1 and I2 must be in the same basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::canInstructionRangeModRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 495,
   FQN="llvm::AAResults::canInstructionRangeModRef", NM="_ZN4llvm9AAResults25canInstructionRangeModRefERKNS_11InstructionES3_RKNS_14MemoryLocationENS_10ModRefInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults25canInstructionRangeModRefERKNS_11InstructionES3_RKNS_14MemoryLocationENS_10ModRefInfoE")
  //</editor-fold>
  public boolean canInstructionRangeModRef(final /*const*/ Instruction /*&*/ I1, 
                           final /*const*/ Instruction /*&*/ I2, 
                           final /*const*/ MemoryLocation /*&*/ Loc, 
                           /*const*/ ModRefInfo Mode) {
    assert (I1.getParent$Const() == I2.getParent$Const()) : "Instructions not in same basic block!";
    ilist_iterator</*const*/ Instruction> I = I1.getIterator$Const();
    ilist_iterator</*const*/ Instruction> E = I2.getIterator$Const();
    E.$preInc(); // Convert from inclusive to exclusive range.
    
    for (; I.$noteq(E); I.$preInc())  { // Check every instruction in range
      if (((getModRefInfo($AddrOf(I.$star()), Loc).getValue() & Mode.getValue()) != 0)) {
        return true;
      }
    }
    return false;
  }

  
  /// A convenience wrapper synthesizing a memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::canInstructionRangeModRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 559,
   FQN="llvm::AAResults::canInstructionRangeModRef", NM="_ZN4llvm9AAResults25canInstructionRangeModRefERKNS_11InstructionES3_PKNS_5ValueEyNS_10ModRefInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults25canInstructionRangeModRefERKNS_11InstructionES3_PKNS_5ValueEyNS_10ModRefInfoE")
  //</editor-fold>
  public boolean canInstructionRangeModRef(final /*const*/ Instruction /*&*/ I1, final /*const*/ Instruction /*&*/ I2, 
                           /*const*/ Value /*P*/ Ptr, long/*uint64_t*/ Size, 
                           /*const*/ ModRefInfo Mode) {
    return canInstructionRangeModRef(I1, I2, new MemoryLocation(Ptr, Size), Mode);
  }

/*private:*/
  
  /// A private abstract base class describing the concept of an individual alias
  /// analysis implementation.
  ///
  /// This interface is implemented by any \c Model instantiation. It is also the
  /// interface which a type used to instantiate the model must provide.
  ///
  /// All of these methods model methods by the same name in the \c
  /// AAResults class. Only differences and specifics to how the
  /// implementations are called are documented here.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 589,
   FQN="llvm::AAResults::Concept", NM="_ZN4llvm9AAResults7ConceptE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7ConceptE")
  //</editor-fold>
  private abstract static class Concept implements Destructors.ClassWithDestructor {
  /*public:*/
    
    // Provide a definition for the root virtual destructor.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::~Concept">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 512,
     FQN="llvm::AAResults::Concept::~Concept", NM="_ZN4llvm9AAResults7ConceptD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7ConceptD0Ev")
    //</editor-fold>
    public abstract void $destroy()/* = 0*/;
    
    /// An update API used internally by the AAResults to provide
    /// a handle back to the top level aggregation.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::setAAResults">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 595,
     FQN="llvm::AAResults::Concept::setAAResults", NM="_ZN4llvm9AAResults7Concept12setAAResultsEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept12setAAResultsEPS0_")
    //</editor-fold>
    public abstract /*virtual*/ void setAAResults(AAResults /*P*/ NewAAR)/* = 0*/;

    
    //===--------------------------------------------------------------------===//
    /// \name Alias Queries
    /// @{
    
    /// The main low level interface to the alias analysis implementation.
    /// Returns an AliasResult indicating whether the two pointers are aliased to
    /// each other. This is the interface that must be implemented by specific
    /// alias analysis implementations.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::alias">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 605,
     FQN="llvm::AAResults::Concept::alias", NM="_ZN4llvm9AAResults7Concept5aliasERKNS_14MemoryLocationES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept5aliasERKNS_14MemoryLocationES4_")
    //</editor-fold>
    public abstract /*virtual*/ AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
         final /*const*/ MemoryLocation /*&*/ LocB)/* = 0*/;

    
    /// Checks whether the given location points to constant memory, or if
    /// \p OrLocal is true whether it points to a local alloca.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::pointsToConstantMemory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 610,
     FQN="llvm::AAResults::Concept::pointsToConstantMemory", NM="_ZN4llvm9AAResults7Concept22pointsToConstantMemoryERKNS_14MemoryLocationEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept22pointsToConstantMemoryERKNS_14MemoryLocationEb")
    //</editor-fold>
    public abstract /*virtual*/ boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, 
                          boolean OrLocal)/* = 0*/;

    
    /// @}
    //===--------------------------------------------------------------------===//
    /// \name Simple mod/ref information
    /// @{
    
    /// Get the ModRef info associated with a pointer argument of a callsite. The
    /// result's bits are set to indicate the allowed aliasing ModRef kinds. Note
    /// that these bits do not necessarily account for the overall behavior of
    /// the function, but rather only provide additional per-argument
    /// information.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::getArgModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 623,
     FQN="llvm::AAResults::Concept::getArgModRefInfo", NM="_ZN4llvm9AAResults7Concept16getArgModRefInfoENS_17ImmutableCallSiteEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept16getArgModRefInfoENS_17ImmutableCallSiteEj")
    //</editor-fold>
    public abstract /*virtual*/ ModRefInfo getArgModRefInfo(ImmutableCallSite CS, 
                    /*uint*/int ArgIdx)/* = 0*/;

    
    /// Return the behavior of the given call site.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::getModRefBehavior">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 627,
     FQN="llvm::AAResults::Concept::getModRefBehavior", NM="_ZN4llvm9AAResults7Concept17getModRefBehaviorENS_17ImmutableCallSiteE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept17getModRefBehaviorENS_17ImmutableCallSiteE")
    //</editor-fold>
    public abstract /*virtual*/ FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS)/* = 0*/;

    
    /// Return the behavior when calling the given function.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::getModRefBehavior">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 630,
     FQN="llvm::AAResults::Concept::getModRefBehavior", NM="_ZN4llvm9AAResults7Concept17getModRefBehaviorEPKNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept17getModRefBehaviorEPKNS_8FunctionE")
    //</editor-fold>
    public abstract /*virtual*/ FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F)/* = 0*/;

    
    /// getModRefInfo (for call sites) - Return information about whether
    /// a particular call site modifies or reads the specified memory location.
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::getModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 634,
     FQN="llvm::AAResults::Concept::getModRefInfo", NM="_ZN4llvm9AAResults7Concept13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
    //</editor-fold>
    public abstract /*virtual*/ ModRefInfo getModRefInfo(ImmutableCallSite CS, 
                 final /*const*/ MemoryLocation /*&*/ Loc)/* = 0*/;

    
    /// Return information about whether two call sites may refer to the same set
    /// of memory locations. See the AA documentation for details:
    ///   http://llvm.org/docs/AliasAnalysis.html#ModRefInfo
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::getModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 640,
     FQN="llvm::AAResults::Concept::getModRefInfo", NM="_ZN4llvm9AAResults7Concept13getModRefInfoENS_17ImmutableCallSiteES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7Concept13getModRefInfoENS_17ImmutableCallSiteES2_")
    //</editor-fold>
    public abstract /*virtual*/ ModRefInfo getModRefInfo(ImmutableCallSite CS1, 
                 ImmutableCallSite CS2)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Concept::Concept">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 589,
     FQN="llvm::AAResults::Concept::Concept", NM="_ZN4llvm9AAResults7ConceptC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults7ConceptC1Ev")
    //</editor-fold>
    public /*inline*/ Concept() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  /// @}
    };

  /// A private class template which derives from \c Concept and wraps some other
  /// type.
  ///
  /// This models the concept by directly forwarding each interface point to the
  /// wrapped type which must implement a compatible interface. This provides
  /// a type erased binding.
  /*template <typename AAResultT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 652,
   FQN="llvm::AAResults::Model", NM="_ZN4llvm9AAResults5ModelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5ModelE")
  //</editor-fold>
  public static final class Model</*typename*/ AAResultT extends AAResultBase>  extends /*public*/ Concept implements Destructors.ClassWithDestructor {
    private final AAResultT /*&*/ Result;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::Model<T>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 656,
     FQN="llvm::AAResults::Model::Model<T>", NM="_ZN4llvm9AAResults5ModelC1ERT_RS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5ModelC1ERT_RS0_")
    //</editor-fold>
    public /*explicit*/ Model(final AAResultT /*&*/ Result, final AAResults /*&*/ AAR) {
      // : Result(Result) 
      //START JInit
      this./*&*/Result=/*&*//*ParenListExpr*/Result;
      //END JInit
      Result.setAAResults($AddrOf(AAR));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::~Model<T>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 659,
     FQN="llvm::AAResults::Model::~Model<T>", NM="_ZN4llvm9AAResults5ModelD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5ModelD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      //super.$destroy();
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::setAAResults">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 661,
     FQN="llvm::AAResults::Model::setAAResults", NM="_ZN4llvm9AAResults5Model12setAAResultsEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model12setAAResultsEPS0_")
    //</editor-fold>
    @Override public void setAAResults(AAResults /*P*/ NewAAR)/* override*/ {
      Result.setAAResults(NewAAR);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::alias">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 663,
     FQN="llvm::AAResults::Model::alias", NM="_ZN4llvm9AAResults5Model5aliasERKNS_14MemoryLocationES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model5aliasERKNS_14MemoryLocationES4_")
    //</editor-fold>
    @Override public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
         final /*const*/ MemoryLocation /*&*/ LocB)/* override*/ {
      return Result.alias(LocA, LocB);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::pointsToConstantMemory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 668,
     FQN="llvm::AAResults::Model::pointsToConstantMemory", NM="_ZN4llvm9AAResults5Model22pointsToConstantMemoryERKNS_14MemoryLocationEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model22pointsToConstantMemoryERKNS_14MemoryLocationEb")
    //</editor-fold>
    @Override public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, 
                          boolean OrLocal)/* override*/ {
      return Result.pointsToConstantMemory(Loc, OrLocal);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::getArgModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 673,
     FQN="llvm::AAResults::Model::getArgModRefInfo", NM="_ZN4llvm9AAResults5Model16getArgModRefInfoENS_17ImmutableCallSiteEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model16getArgModRefInfoENS_17ImmutableCallSiteEj")
    //</editor-fold>
    @Override public ModRefInfo getArgModRefInfo(ImmutableCallSite CS, /*uint*/int ArgIdx)/* override*/ {
      return Result.getArgModRefInfo(CS, ArgIdx);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::getModRefBehavior">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 677,
     FQN="llvm::AAResults::Model::getModRefBehavior", NM="_ZN4llvm9AAResults5Model17getModRefBehaviorENS_17ImmutableCallSiteE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model17getModRefBehaviorENS_17ImmutableCallSiteE")
    //</editor-fold>
    @Override public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS)/* override*/ {
      return Result.getModRefBehavior(CS);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::getModRefBehavior">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 681,
     FQN="llvm::AAResults::Model::getModRefBehavior", NM="_ZN4llvm9AAResults5Model17getModRefBehaviorEPKNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model17getModRefBehaviorEPKNS_8FunctionE")
    //</editor-fold>
    @Override public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F)/* override*/ {
      return Result.getModRefBehavior(F);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::getModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 685,
     FQN="llvm::AAResults::Model::getModRefInfo", NM="_ZN4llvm9AAResults5Model13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
    //</editor-fold>
    @Override public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
                 final /*const*/ MemoryLocation /*&*/ Loc)/* override*/ {
      return Result.getModRefInfo(CS, Loc);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AAResults::Model::getModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 690,
     FQN="llvm::AAResults::Model::getModRefInfo", NM="_ZN4llvm9AAResults5Model13getModRefInfoENS_17ImmutableCallSiteES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAResults5Model13getModRefInfoENS_17ImmutableCallSiteES2_")
    //</editor-fold>
    @Override public ModRefInfo getModRefInfo(ImmutableCallSite CS1, 
                 ImmutableCallSite CS2)/* override*/ {
      return Result.getModRefInfo(CS1, CS2);
    }


    @Override public String toString() {
      return "" + "Result=" + Result // NOI18N
                + super.toString(); // NOI18N
    }
  }
  
  /*friend template <typename T> class AAResultBase*/
  
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  
  private std.vector<std.unique_ptr<Concept>> AAs;
  
  @Override public String toString() {
    return "" + "TLI=" + TLI // NOI18N
              + ", AAs=" + AAs; // NOI18N
  }
}
