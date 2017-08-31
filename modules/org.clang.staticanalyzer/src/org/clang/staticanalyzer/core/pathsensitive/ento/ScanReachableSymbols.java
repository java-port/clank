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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


/// \class ScanReachableSymbols
/// A Utility class that allows to visit the reachable symbols using a custom
/// SymbolVisitor.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 833,
 FQN="clang::ento::ScanReachableSymbols", NM="_ZN5clang4ento20ScanReachableSymbolsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbolsE")
//</editor-fold>
public class ScanReachableSymbols implements Destructors.ClassWithDestructor {
  // JAVA: typedef llvm::DenseSet<const void *> VisitedItems
//  public final class VisitedItems extends DenseSet</*const*/Object/*void P*/>{ };
  
  private DenseSet</*const*/Object/*void P*/> visited;
  private IntrusiveRefCntPtr</*const*/ ProgramState> state;
  private final SymbolVisitor /*&*/ visitor;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::ScanReachableSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 840,
   FQN="clang::ento::ScanReachableSymbols::ScanReachableSymbols", NM="_ZN5clang4ento20ScanReachableSymbolsC1EN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_13SymbolVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbolsC1EN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_13SymbolVisitorE")
  //</editor-fold>
  public ScanReachableSymbols(IntrusiveRefCntPtr</*const*/ ProgramState> st, final SymbolVisitor /*&*/ v) {
    // : visited(), state(std::move(st)), visitor(v) 
    //START JInit
    this.visited = new DenseSet</*const*/Object/*void P*/>(DenseMapInfo$LikePtr.$Info());
    this.state = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(st));
    this./*&*/visitor=/*&*/v;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::scan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 508,
   FQN="clang::ento::ScanReachableSymbols::scan", NM="_ZN5clang4ento20ScanReachableSymbols4scanENS0_6nonloc15LazyCompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbols4scanENS0_6nonloc15LazyCompoundValE")
  //</editor-fold>
  public boolean scan(NsNonloc.LazyCompoundVal val) {
    boolean wasVisited = !visited.insert(val.getCVData()).second;
    if (wasVisited) {
      return true;
    }
    
    final StoreManager /*&*/ StoreMgr = state.$arrow().getStateManager().getStoreManager();
    // FIXME: We don't really want to use getBaseRegion() here because pointer
    // arithmetic doesn't apply, but scanReachableSymbols only accepts base
    // regions right now.
    /*const*/ MemRegion /*P*/ R = val.getRegion().getBaseRegion();
    return StoreMgr.scanReachableSymbols(val.getStore(), R, /*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::scan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 521,
   FQN="clang::ento::ScanReachableSymbols::scan", NM="_ZN5clang4ento20ScanReachableSymbols4scanENS0_6nonloc11CompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbols4scanENS0_6nonloc11CompoundValE")
  //</editor-fold>
  public boolean scan(NsNonloc.CompoundVal val) {
    for (ImmutableList.iterator<SVal> I = val.begin(), E = val.end(); I.$noteq(E); I.$preInc())  {
      if (!scan(new SVal(I.$star()))) {
        return false;
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::scan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 559,
   FQN="clang::ento::ScanReachableSymbols::scan", NM="_ZN5clang4ento20ScanReachableSymbols4scanENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbols4scanENS0_4SValE")
  //</editor-fold>
  public boolean scan(SVal val) {
    {
      Optional<NsLoc.MemRegionVal> X = val.getAs(NsLoc.MemRegionVal.class);
      if (X.$bool()) {
        return scan(X.$arrow().getRegion());
      }
    }
    {
      
      Optional<NsNonloc.LazyCompoundVal> X = val.getAs(NsNonloc.LazyCompoundVal.class);
      if (X.$bool()) {
        return scan(new NsNonloc.LazyCompoundVal(X.$star()));
      }
    }
    {
      
      Optional<NsNonloc.LocAsInteger> X = val.getAs(NsNonloc.LocAsInteger.class);
      if (X.$bool()) {
        return scan(new SVal(JD$Move.INSTANCE, X.$arrow().getLoc()));
      }
    }
    {
      
      /*const*/ SymExpr /*P*/ Sym = val.getAsSymbol();
      if ((Sym != null)) {
        return scan(Sym);
      }
    }
    {
      
      /*const*/ SymExpr /*P*/ Sym = val.getAsSymbolicExpression();
      if ((Sym != null)) {
        return scan(Sym);
      }
    }
    {
      
      Optional<NsNonloc.CompoundVal> X = val.getAs(NsNonloc.CompoundVal.class);
      if (X.$bool()) {
        return scan(new NsNonloc.CompoundVal(X.$star()));
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::scan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 582,
   FQN="clang::ento::ScanReachableSymbols::scan", NM="_ZN5clang4ento20ScanReachableSymbols4scanEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbols4scanEPKNS0_9MemRegionE")
  //</editor-fold>
  public boolean scan(/*const*/ MemRegion /*P*/ R) {
    if (isa_MemSpaceRegion(R)) {
      return true;
    }
    
    boolean wasVisited = !visited.insert(R).second;
    if (wasVisited) {
      return true;
    }
    if (!visitor.VisitMemRegion(R)) {
      return false;
    }
    {
      
      // If this is a symbolic region, visit the symbol for the region.
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
      if ((SR != null)) {
        if (!visitor.VisitSymbol(SR.getSymbol())) {
          return false;
        }
      }
    }
    {
      
      // If this is a subregion, also visit the parent regions.
      /*const*/ SubRegion /*P*/ SR = dyn_cast_SubRegion(R);
      if ((SR != null)) {
        /*const*/ MemRegion /*P*/ Super = SR.getSuperRegion();
        if (!scan(Super)) {
          return false;
        }
        
        // When we reach the topmost region, scan all symbols in it.
        if (isa_MemSpaceRegion(Super)) {
          final StoreManager /*&*/ StoreMgr = state.$arrow().getStateManager().getStoreManager();
          if (!StoreMgr.scanReachableSymbols(state.$arrow().getStore(), SR, /*Deref*/this)) {
            return false;
          }
        }
      }
    }
    {
      
      // Regions captured by a block are also implicitly reachable.
      /*const*/ BlockDataRegion /*P*/ BDR = dyn_cast_BlockDataRegion(R);
      if ((BDR != null)) {
        BlockDataRegion.referenced_vars_iterator I = BDR.referenced_vars_begin();
        BlockDataRegion.referenced_vars_iterator E = BDR.referenced_vars_end();
        for (; I.$noteq(E); I.$preInc()) {
          if (!scan(I.getCapturedRegion())) {
            return false;
          }
        }
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::scan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 529,
   FQN="clang::ento::ScanReachableSymbols::scan", NM="_ZN5clang4ento20ScanReachableSymbols4scanEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbols4scanEPKNS0_7SymExprE")
  //</editor-fold>
  public boolean scan(/*const*/ SymExpr /*P*/ sym) {
    boolean wasVisited = !visited.insert(sym).second;
    if (wasVisited) {
      return true;
    }
    if (!visitor.VisitSymbol(sym)) {
      return false;
    }
    
    // TODO: should be rewritten using SymExpr::symbol_iterator.
    switch (sym.getKind()) {
     case SymbolRegionValueKind:
     case SymbolConjuredKind:
     case SymbolDerivedKind:
     case SymbolExtentKind:
     case SymbolMetadataKind:
      break;
     case SymbolCastKind:
      return scan(cast_SymbolCast(sym).getOperand());
     case SymIntExprKind:
      return scan(cast_SymIntExpr(sym).getLHS());
     case IntSymExprKind:
      return scan(cast_IntSymExpr(sym).getRHS());
     case SymSymExprKind:
      {
        /*const*/ SymSymExpr /*P*/ x = cast_SymSymExpr(sym);
        return scan(x.getLHS()) && scan(x.getRHS());
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ScanReachableSymbols::~ScanReachableSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 833,
   FQN="clang::ento::ScanReachableSymbols::~ScanReachableSymbols", NM="_ZN5clang4ento20ScanReachableSymbolsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento20ScanReachableSymbolsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    state.$destroy();
    visited.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "visited=" + visited // NOI18N
              + ", state=" + state // NOI18N
              + ", visitor=" + "[SymbolVisitor]"; // NOI18N
  }
}
