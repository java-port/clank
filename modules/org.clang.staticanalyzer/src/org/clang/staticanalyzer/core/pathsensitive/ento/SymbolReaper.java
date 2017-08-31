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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.analysis.analyses.*;


/// \brief A class responsible for cleaning up unused symbols.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 475,
 FQN="clang::ento::SymbolReaper", NM="_ZN5clang4ento12SymbolReaperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento12SymbolReaperE")
//</editor-fold>
public class SymbolReaper implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::SymbolStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 476,
   FQN="clang::ento::SymbolReaper::SymbolStatus", NM="_ZN5clang4ento12SymbolReaper12SymbolStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento12SymbolReaper12SymbolStatusE")
  //</editor-fold>
  private enum SymbolStatus implements Native.ComparableLower {
    NotProcessed(0),
    HaveMarkedDependents(NotProcessed.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SymbolStatus valueOf(int val) {
      SymbolStatus out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SymbolStatus[] VALUES;
      private static final SymbolStatus[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SymbolStatus kind : SymbolStatus.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SymbolStatus[min < 0 ? (1-min) : 0];
        VALUES = new SymbolStatus[max >= 0 ? (1+max) : 0];
        for (SymbolStatus kind : SymbolStatus.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private SymbolStatus(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SymbolStatus)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SymbolStatus)obj).value);}
    //</editor-fold>
  };
  
  /*typedef llvm::DenseSet<SymbolRef> SymbolSetTy*/
//  public final class SymbolSetTy extends DenseSet</*const*/ SymExpr /*P*/ >{ };
  /*typedef llvm::DenseMap<SymbolRef, SymbolStatus> SymbolMapTy*/
//  public final class SymbolMapTy extends DenseMap</*const*/ SymExpr /*P*/ , SymbolStatus>{ };
  /*typedef llvm::DenseSet<const MemRegion *> RegionSetTy*/
//  public final class RegionSetTy extends DenseSet</*const*/ MemRegion /*P*/ >{ };
  
  private DenseMap</*const*/ SymExpr /*P*/ , SymbolStatus> TheLiving;
  private DenseSet</*const*/ SymExpr /*P*/ > MetadataInUse;
  private DenseSet</*const*/ SymExpr /*P*/ > TheDead;
  
  private DenseSet</*const*/ MemRegion /*P*/ > RegionRoots;
  
  private /*const*/ StackFrameContext /*P*/ LCtx;
  private /*const*/ Stmt /*P*/ Loc;
  private final SymbolManager /*&*/ SymMgr;
  private StoreRef reapedStore;
  private DenseMapTypeUInt</*const*/ MemRegion /*P*/ > includedRegionCache;
/*public:*/
  /// \brief Construct a reaper object, which removes everything which is not
  /// live before we execute statement s in the given location context.
  ///
  /// If the statement is NULL, everything is this and parent contexts is
  /// considered live.
  /// If the stack frame context is NULL, everything on stack is considered
  /// dead.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::SymbolReaper">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*null for TheLiving*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 505,
   FQN="clang::ento::SymbolReaper::SymbolReaper", NM="_ZN5clang4ento12SymbolReaperC1EPKNS_17StackFrameContextEPKNS_4StmtERNS0_13SymbolManagerERNS0_12StoreManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento12SymbolReaperC1EPKNS_17StackFrameContextEPKNS_4StmtERNS0_13SymbolManagerERNS0_12StoreManagerE")
  //</editor-fold>
  public SymbolReaper(/*const*/ StackFrameContext /*P*/ Ctx, /*const*/ Stmt /*P*/ s, final SymbolManager /*&*/ symmgr, 
      final StoreManager /*&*/ storeMgr) {
    // : TheLiving(), MetadataInUse(), TheDead(), RegionRoots(), LCtx(Ctx), Loc(s), SymMgr(symmgr), reapedStore(null, storeMgr), includedRegionCache() 
    //START JInit
    this.TheLiving = new DenseMap</*const*/ SymExpr /*P*/ , SymbolStatus>(DenseMapInfo$LikePtr.$Info(), /*SymbolStatus.NotProcessed*/(SymbolStatus)null);
    this.MetadataInUse = new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.TheDead = new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.RegionRoots = new DenseSet</*const*/ MemRegion /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.LCtx = Ctx;
    this.Loc = s;
    this./*&*/SymMgr=/*&*/symmgr;
    this.reapedStore = new StoreRef((/*const*/Object/*void P*/ )null, storeMgr);
    this.includedRegionCache = new DenseMapTypeUInt</*const*/ MemRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 510,
   FQN="clang::ento::SymbolReaper::getLocationContext", NM="_ZNK5clang4ento12SymbolReaper18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return LCtx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::isLive">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 452,
   FQN="clang::ento::SymbolReaper::isLive", NM="_ZN5clang4ento12SymbolReaper6isLiveEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper6isLiveEPKNS0_7SymExprE")
  //</editor-fold>
  public boolean isLive(/*const*/ SymExpr /*P*/ sym) {
    if ((TheLiving.count(sym) != 0)) {
      markDependentsLive(sym);
      return true;
    }
    
    boolean KnownLive = false;
    switch (sym.getKind()) {
     case SymbolRegionValueKind:
      KnownLive = isLiveRegion(cast_SymbolRegionValue(sym).getRegion());
      break;
     case SymbolConjuredKind:
      KnownLive = false;
      break;
     case SymbolDerivedKind:
      KnownLive = isLive(cast_SymbolDerived(sym).getParentSymbol());
      break;
     case SymbolExtentKind:
      KnownLive = isLiveRegion(cast_SymbolExtent(sym).getRegion());
      break;
     case SymbolMetadataKind:
      KnownLive = (MetadataInUse.count(sym) != 0)
         && isLiveRegion(cast_SymbolMetadata(sym).getRegion());
      if (KnownLive) {
        MetadataInUse.erase(sym);
      }
      break;
     case SymIntExprKind:
      KnownLive = isLive(cast_SymIntExpr(sym).getLHS());
      break;
     case IntSymExprKind:
      KnownLive = isLive(cast_IntSymExpr(sym).getRHS());
      break;
     case SymSymExprKind:
      KnownLive = isLive(cast_SymSymExpr(sym).getLHS())
         && isLive(cast_SymSymExpr(sym).getRHS());
      break;
     case SymbolCastKind:
      KnownLive = isLive(cast_SymbolCast(sym).getOperand());
      break;
    }
    if (KnownLive) {
      markLive(sym);
    }
    
    return KnownLive;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::isLiveRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 421,
   FQN="clang::ento::SymbolReaper::isLiveRegion", NM="_ZN5clang4ento12SymbolReaper12isLiveRegionEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper12isLiveRegionEPKNS0_9MemRegionE")
  //</editor-fold>
  public boolean isLiveRegion(/*const*/ MemRegion /*P*/ MR) {
    if ((RegionRoots.count(MR) != 0)) {
      return true;
    }
    
    MR = MR.getBaseRegion();
    {
      
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(MR);
      if ((SR != null)) {
        return isLive(SR.getSymbol());
      }
    }
    {
      
      /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(MR);
      if ((VR != null)) {
        return isLive(VR, true);
      }
    }
    
    // FIXME: This is a gross over-approximation. What we really need is a way to
    // tell if anything still refers to this region. Unlike SymbolicRegions,
    // AllocaRegions don't have associated symbols, though, so we don't actually
    // have a way to track their liveness.
    if (isa_AllocaRegion(MR)) {
      return true;
    }
    if (isa_CXXThisRegion(MR)) {
      return true;
    }
    if (isa_MemSpaceRegion(MR)) {
      return true;
    }
    if (isa_CodeTextRegion(MR)) {
      return true;
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::isLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 500,
   FQN="clang::ento::SymbolReaper::isLive", NM="_ZNK5clang4ento12SymbolReaper6isLiveEPKNS_4StmtEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento12SymbolReaper6isLiveEPKNS_4StmtEPKNS_15LocationContextE")
  //</editor-fold>
  public boolean isLive(/*const*/ Stmt /*P*/ ExprVal, /*const*/ LocationContext /*P*/ ELCtx) /*const*/ {
    if (LCtx == null) {
      return false;
    }
    if (LCtx != ELCtx) {
      // If the reaper's location context is a parent of the expression's
      // location context, then the expression value is now "out of scope".
      if (LCtx.isParentOf(ELCtx)) {
        return false;
      }
      return true;
    }
    
    // If no statement is provided, everything is this and parent contexts is live.
    if (!(Loc != null)) {
      return true;
    }
    
    return LCtx.<RelaxedLiveVariables>getAnalysis(RelaxedLiveVariables.class).isLive(Loc, ExprVal);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::isLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 520,
   FQN="clang::ento::SymbolReaper::isLive", NM="_ZNK5clang4ento12SymbolReaper6isLiveEPKNS0_9VarRegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento12SymbolReaper6isLiveEPKNS0_9VarRegionEb")
  //</editor-fold>
  public boolean isLive(/*const*/ VarRegion /*P*/ VR) /*const*/ {
    return isLive(VR, false);
  }
  public boolean isLive(/*const*/ VarRegion /*P*/ VR, boolean includeStoreBindings/*= false*/) /*const*/ {
    /*const*/ StackFrameContext /*P*/ VarContext = VR.getStackFrame();
    if (!(VarContext != null)) {
      return true;
    }
    if (!(LCtx != null)) {
      return false;
    }
    /*const*/ StackFrameContext /*P*/ CurrentContext = LCtx.getCurrentStackFrame();
    if (VarContext == CurrentContext) {
      // If no statement is provided, everything is live.
      if (!(Loc != null)) {
        return true;
      }
      if (LCtx.<RelaxedLiveVariables>getAnalysis(RelaxedLiveVariables.class).isLive(Loc, VR.getDecl())) {
        return true;
      }
      if (!includeStoreBindings) {
        return false;
      }
      
      final uint$ref/*uint &*/ cachedQuery = ((/*const_cast*/SymbolReaper /*P*/ )(this)).includedRegionCache.ref$at(VR);
      if ((cachedQuery.$deref() != 0)) {
        return cachedQuery.$deref() == 1;
      }
      {
        
        // Query the store to see if the region occurs in any live bindings.
        /*const*/Object/*void P*/ store = reapedStore.getStore();
        if ((store != null)) {
          boolean hasRegion = reapedStore.getStoreManager().includedInBindings(store, VR);
          cachedQuery.$set(hasRegion ? 1 : 2);
          return hasRegion;
        }
      }
      
      return false;
    }
    
    return VarContext.isParentOf(CurrentContext);
  }


  
  /// \brief Unconditionally marks a symbol as live.
  ///
  /// This should never be
  /// used by checkers, only by the state infrastructure such as the store and
  /// environment. Checkers should instead use metadata symbols and markInUse.
  
  /// \brief Unconditionally marks a symbol as live.
  ///
  /// This should never be
  /// used by checkers, only by the state infrastructure such as the store and
  /// environment. Checkers should instead use metadata symbols and markInUse.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::markLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 386,
   FQN="clang::ento::SymbolReaper::markLive", NM="_ZN5clang4ento12SymbolReaper8markLiveEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper8markLiveEPKNS0_7SymExprE")
  //</editor-fold>
  public void markLive(/*const*/ SymExpr /*P*/ sym) {
    TheLiving.$set(sym, SymbolStatus.NotProcessed);
    TheDead.erase(sym);
    markDependentsLive(sym);
  }


  
  /// \brief Marks a symbol as important to a checker.
  ///
  /// For metadata symbols,
  /// this will keep the symbol alive as long as its associated region is also
  /// live. For other symbols, this has no effect; checkers are not permitted
  /// to influence the life of other symbols. This should be used before any
  /// symbol marking has occurred, i.e. in the MarkLiveSymbols callback.
  
  /// \brief Marks a symbol as important to a checker.
  ///
  /// For metadata symbols,
  /// this will keep the symbol alive as long as its associated region is also
  /// live. For other symbols, this has no effect; checkers are not permitted
  /// to influence the life of other symbols. This should be used before any
  /// symbol marking has occurred, i.e. in the MarkLiveSymbols callback.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::markInUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 408,
   FQN="clang::ento::SymbolReaper::markInUse", NM="_ZN5clang4ento12SymbolReaper9markInUseEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper9markInUseEPKNS0_7SymExprE")
  //</editor-fold>
  public void markInUse(/*const*/ SymExpr /*P*/ sym) {
    if (isa_SymbolMetadata(sym)) {
      MetadataInUse.insert(sym);
    }
  }


  
  /// \brief If a symbol is known to be live, marks the symbol as live.
  ///
  ///  Otherwise, if the symbol cannot be proven live, it is marked as dead.
  ///  Returns true if the symbol is dead, false if live.
  
  /// \brief If a symbol is known to be live, marks the symbol as live.
  ///
  ///  Otherwise, if the symbol cannot be proven live, it is marked as dead.
  ///  Returns true if the symbol is dead, false if live.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::maybeDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 413,
   FQN="clang::ento::SymbolReaper::maybeDead", NM="_ZN5clang4ento12SymbolReaper9maybeDeadEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper9maybeDeadEPKNS0_7SymExprE")
  //</editor-fold>
  public boolean maybeDead(/*const*/ SymExpr /*P*/ sym) {
    if (isLive(sym)) {
      return false;
    }
    
    TheDead.insert(sym);
    return true;
  }


  
  /*typedef SymbolSetTy::const_iterator dead_iterator*/
//  public final class dead_iterator extends DenseSet.ConstIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::dead_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 540,
   FQN="clang::ento::SymbolReaper::dead_begin", NM="_ZNK5clang4ento12SymbolReaper10dead_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper10dead_beginEv")
  //</editor-fold>
  public DenseSet.iterator</*const*/SymExpr/*P*/> dead_begin() /*const*/ {
    return TheDead.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::dead_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 541,
   FQN="clang::ento::SymbolReaper::dead_end", NM="_ZNK5clang4ento12SymbolReaper8dead_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper8dead_endEv")
  //</editor-fold>
  public DenseSet.iterator</*const*/SymExpr/*P*/> dead_end() /*const*/ {
    return TheDead.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::hasDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 543,
   FQN="clang::ento::SymbolReaper::hasDeadSymbols", NM="_ZNK5clang4ento12SymbolReaper14hasDeadSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper14hasDeadSymbolsEv")
  //</editor-fold>
  public boolean hasDeadSymbols() /*const*/ {
    return !TheDead.empty();
  }

  
  /*typedef RegionSetTy::const_iterator region_iterator*/
//  public final class region_iterator extends DenseSet.ConstIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::region_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 548,
   FQN="clang::ento::SymbolReaper::region_begin", NM="_ZNK5clang4ento12SymbolReaper12region_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper12region_beginEv")
  //</editor-fold>
  public DenseSet.iterator</*const*/MemRegion/*P*/> region_begin() /*const*/ {
    return RegionRoots.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::region_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 549,
   FQN="clang::ento::SymbolReaper::region_end", NM="_ZNK5clang4ento12SymbolReaper10region_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper10region_endEv")
  //</editor-fold>
  public DenseSet.iterator</*const*/MemRegion/*P*/> region_end() /*const*/ {
    return RegionRoots.end$Const();
  }

  
  /// \brief Returns whether or not a symbol has been confirmed dead.
  ///
  /// This should only be called once all marking of dead symbols has completed.
  /// (For checkers, this means only in the evalDeadSymbols callback.)
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::isDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 555,
   FQN="clang::ento::SymbolReaper::isDead", NM="_ZNK5clang4ento12SymbolReaper6isDeadEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento12SymbolReaper6isDeadEPKNS0_7SymExprE")
  //</editor-fold>
  public boolean isDead(/*const*/ SymExpr /*P*/ sym) /*const*/ {
    return (TheDead.count(sym) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::markLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 392,
   FQN="clang::ento::SymbolReaper::markLive", NM="_ZN5clang4ento12SymbolReaper8markLiveEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper8markLiveEPKNS0_9MemRegionE")
  //</editor-fold>
  public void markLive(/*const*/ MemRegion /*P*/ region) {
    RegionRoots.insert(region);
    markElementIndicesLive(region);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::markElementIndicesLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 397,
   FQN="clang::ento::SymbolReaper::markElementIndicesLive", NM="_ZN5clang4ento12SymbolReaper22markElementIndicesLiveEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper22markElementIndicesLiveEPKNS0_9MemRegionE")
  //</editor-fold>
  public void markElementIndicesLive(/*const*/ MemRegion /*P*/ region) {
    for (/*const*/ SubRegion /*P*/ SR = dyn_cast_SubRegion(region); (SR != null);
         SR = dyn_cast_SubRegion(SR.getSuperRegion())) {
      {
        /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(SR);
        if ((ER != null)) {
          SVal Idx = new SVal(JD$Move.INSTANCE, ER.getIndex());
          SymExpr.symbol_iterator SI = null;
          SymExpr.symbol_iterator SE = null;
          try {
            for (SI = Idx.symbol_begin(), SE = Idx.symbol_end(); SI.$noteq(SE); SI.$preInc())  {
              markLive(SI.$star());
            }
          } finally {
            if (SE != null) { SE.$destroy(); }
            if (SI != null) { SI.$destroy(); }
          }
        }
      }
    }
  }


  
  /// \brief Set to the value of the symbolic store after
  /// StoreManager::removeDeadBindings has been called.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::setReapedStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 564,
   FQN="clang::ento::SymbolReaper::setReapedStore", NM="_ZN5clang4ento12SymbolReaper14setReapedStoreENS0_8StoreRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento12SymbolReaper14setReapedStoreENS0_8StoreRefE")
  //</editor-fold>
  public void setReapedStore(StoreRef st) {
    reapedStore.$assign(st);
  }

/*private:*/
  /// Mark the symbols dependent on the input symbol as live.
  /// Mark the symbols dependent on the input symbol as live.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::markDependentsLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 368,
   FQN="clang::ento::SymbolReaper::markDependentsLive", NM="_ZN5clang4ento12SymbolReaper18markDependentsLiveEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento12SymbolReaper18markDependentsLiveEPKNS0_7SymExprE")
  //</editor-fold>
  private void markDependentsLive(/*const*/ SymExpr /*P*/ sym) {
    // Do not mark dependents more then once.
    DenseMapIterator</*const*/ SymExpr /*P*/ , SymbolStatus> LI = TheLiving.find(sym);
    assert (LI.$noteq(/*NO_ITER_COPY*/TheLiving.end())) : "The primary symbol is not live.";
    if (LI.$arrow().second == SymbolStatus.HaveMarkedDependents) {
      return;
    }
    LI.$arrow().second = SymbolStatus.HaveMarkedDependents;
    {
      
      /*const*/SmallVector</*const*/ SymExpr /*P*/ > /*P*/ Deps = SymMgr.getDependentSymbols(sym);
      if ((Deps != null)) {
        for (type$ptr</*const*/ SymExpr /*P*/ /*const*/ /*P*/> I = $tryClone(Deps.begin$Const()), 
            /*P*/ E = $tryClone(Deps.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
          if (TheLiving.find(I.$star()).$noteq(/*NO_ITER_COPY*/TheLiving.end())) {
            continue;
          }
          markLive(I.$star());
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolReaper::~SymbolReaper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 475,
   FQN="clang::ento::SymbolReaper::~SymbolReaper", NM="_ZN5clang4ento12SymbolReaperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento12SymbolReaperD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    includedRegionCache.$destroy();
    reapedStore.$destroy();
    RegionRoots.$destroy();
    TheDead.$destroy();
    MetadataInUse.$destroy();
    TheLiving.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "TheLiving=" + TheLiving // NOI18N
              + ", MetadataInUse=" + MetadataInUse // NOI18N
              + ", TheDead=" + TheDead // NOI18N
              + ", RegionRoots=" + RegionRoots // NOI18N
              + ", LCtx=" + "[StackFrameContext]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", SymMgr=" + "[SymbolManager]" // NOI18N
              + ", reapedStore=" + reapedStore // NOI18N
              + ", includedRegionCache=" + includedRegionCache; // NOI18N
  }
}
