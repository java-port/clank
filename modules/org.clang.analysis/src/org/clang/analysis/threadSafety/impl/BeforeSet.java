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

package org.clang.analysis.threadSafety.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.threadSafety.impl.*;
import static org.clang.analysis.java.AnalysisFunctionPointers.*;
import org.clang.analysis.analyses.threadSafety.*;
import static org.clang.ast.java.AstAttributesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 256,
 FQN="clang::threadSafety::BeforeSet", NM="_ZN5clang12threadSafety9BeforeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSetE")
//</editor-fold>
public class BeforeSet implements Destructors.ClassWithDestructor {
/*private:*/
  /*typedef SmallVector<const ValueDecl *, 4> BeforeVect*/
//  public final class BeforeVect extends SmallVector</*const*/ ValueDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::BeforeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 260,
   FQN="clang::threadSafety::BeforeSet::BeforeInfo", NM="_ZN5clang12threadSafety9BeforeSet10BeforeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet10BeforeInfoE")
  //</editor-fold>
  private static class/*struct*/ BeforeInfo implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::BeforeInfo::BeforeInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 261,
     FQN="clang::threadSafety::BeforeSet::BeforeInfo::BeforeInfo", NM="_ZN5clang12threadSafety9BeforeSet10BeforeInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet10BeforeInfoC1Ev")
    //</editor-fold>
    public BeforeInfo() {
      // : Vect(), Visited(0) 
      //START JInit
      this.Vect = new SmallVector</*const*/ ValueDecl /*P*/ >(4, (/*const*/ ValueDecl /*P*/ )null);
      this.Visited = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::BeforeInfo::BeforeInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 262,
     FQN="clang::threadSafety::BeforeSet::BeforeInfo::BeforeInfo", NM="_ZN5clang12threadSafety9BeforeSet10BeforeInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet10BeforeInfoC1EOS2_")
    //</editor-fold>
    public BeforeInfo(JD$Move _dparam, final BeforeInfo /*&&*/O) {
      // : Vect(std::move(O.Vect)), Visited(O.Visited) 
      //START JInit
      this.Vect = new SmallVector</*const*/ ValueDecl /*P*/ >(JD$Move.INSTANCE, std.move(O.Vect));
      this.Visited = O.Visited;
      //END JInit
    }

    
    public SmallVector</*const*/ ValueDecl /*P*/ > Vect;
    public int Visited;
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::BeforeInfo::~BeforeInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 260,
     FQN="clang::threadSafety::BeforeSet::BeforeInfo::~BeforeInfo", NM="_ZN5clang12threadSafety9BeforeSet10BeforeInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet10BeforeInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Vect.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Vect=" + Vect // NOI18N
                + ", Visited=" + Visited; // NOI18N
    }
  };
  
  /*typedef llvm::DenseMap<const ValueDecl *, std::unique_ptr<BeforeInfo> > BeforeMap*/
//  public final class BeforeMap extends DenseMap</*const*/ ValueDecl /*P*/ , std.unique_ptr<BeforeInfo>>{ };
  /*typedef llvm::DenseMap<const ValueDecl *, bool> CycleMap*/
//  public final class CycleMap extends DenseMapTypeBool</*const*/ ValueDecl /*P*/ >{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::BeforeSet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 273,
   FQN="clang::threadSafety::BeforeSet::BeforeSet", NM="_ZN5clang12threadSafety9BeforeSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSetC1Ev")
  //</editor-fold>
  public BeforeSet() {
    // : BMap(), CycMap() 
    //START JInit
    this.BMap = new DenseMap</*const*/ ValueDecl /*P*/ , std.unique_ptr<BeforeInfo>>(DenseMapInfo$LikePtr.$Info(), new std.unique_ptr<BeforeInfo>());
    this.CycMap = new DenseMapTypeBool</*const*/ ValueDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
    //END JInit
  }

  
  // namespace
  
  /// Process acquired_before and acquired_after attributes on Vd.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::insertAttrExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 967,
   FQN="clang::threadSafety::BeforeSet::insertAttrExprs", NM="_ZN5clang12threadSafety9BeforeSet15insertAttrExprsEPKNS_9ValueDeclERN12_GLOBAL__N_120ThreadSafetyAnalyzerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet15insertAttrExprsEPKNS_9ValueDeclERN12_GLOBAL__N_120ThreadSafetyAnalyzerE")
  //</editor-fold>
  public BeforeSet.BeforeInfo /*P*/ insertAttrExprs(/*const*/ ValueDecl /*P*/ Vd, 
                 final ThreadSafetyAnalyzer /*&*/ Analyzer) {
    // Create a new entry for Vd.
    BeforeInfo /*P*/ Info = null;
    {
      // Keep InfoPtr in its own scope in case BMap is modified later and the
      // reference becomes invalid.
      final std.unique_ptr<BeforeInfo> /*&*/ InfoPtr = BMap.$at_T1$C$R(Vd);
      if (!InfoPtr.$bool()) {
        InfoPtr.reset(new BeforeInfo());
      }
      Info = InfoPtr.get();
    }
    
    for (Attr /*P*/ At : Vd.attrs()) {
      switch (At.getKind()) {
       case AcquiredBefore:
        {
          AcquiredBeforeAttr /*P*/ A = cast_AcquiredBeforeAttr(At);
          
          // Read exprs from the attribute, and add them to BeforeVect.
          for (/*const*/ Expr /*P*/ Arg : A.args()) {
            CapabilityExpr Cp = Analyzer.SxBuilder.translateAttrExpr(Arg, (SExprBuilder.CallingContext /*P*/ )null);
            {
              /*const*/ ValueDecl /*P*/ Cpvd = Cp.valueDecl();
              if ((Cpvd != null)) {
                Info.Vect.push_back(Cpvd);
                DenseMapIterator</*const*/ ValueDecl /*P*/ , unique_ptr<BeforeInfo>> It = BMap.find(Cpvd);
                if (It.$eq(/*NO_ITER_COPY*/BMap.end())) {
                  insertAttrExprs(Cpvd, Analyzer);
                }
              }
            }
          }
          break;
        }
       case AcquiredAfter:
        {
          AcquiredAfterAttr /*P*/ A = cast_AcquiredAfterAttr(At);
          
          // Read exprs from the attribute, and add them to BeforeVect.
          for (/*const*/ Expr /*P*/ Arg : A.args()) {
            CapabilityExpr Cp = Analyzer.SxBuilder.translateAttrExpr(Arg, (SExprBuilder.CallingContext /*P*/ )null);
            {
              /*const*/ ValueDecl /*P*/ ArgVd = Cp.valueDecl();
              if ((ArgVd != null)) {
                // Get entry for mutex listed in attribute
                BeforeInfo /*P*/ ArgInfo = getBeforeInfoForDecl(ArgVd, Analyzer);
                ArgInfo.Vect.push_back(Vd);
              }
            }
          }
          break;
        }
       default:
        break;
      }
    }
    
    return Info;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::getBeforeInfoForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1021,
   FQN="clang::threadSafety::BeforeSet::getBeforeInfoForDecl", NM="_ZN5clang12threadSafety9BeforeSet20getBeforeInfoForDeclEPKNS_9ValueDeclERN12_GLOBAL__N_120ThreadSafetyAnalyzerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet20getBeforeInfoForDeclEPKNS_9ValueDeclERN12_GLOBAL__N_120ThreadSafetyAnalyzerE")
  //</editor-fold>
  public BeforeSet.BeforeInfo /*P*/ getBeforeInfoForDecl(/*const*/ ValueDecl /*P*/ Vd, 
                      final ThreadSafetyAnalyzer /*&*/ Analyzer) {
    DenseMapIterator</*const*/ ValueDecl /*P*/ , unique_ptr<BeforeInfo>> It = BMap.find(Vd);
    BeforeInfo /*P*/ Info = null;
    if (It.$eq(/*NO_ITER_COPY*/BMap.end())) {
      Info = insertAttrExprs(Vd, Analyzer);
    } else {
      Info = It.$arrow().second.get();
    }
    assert ((Info != null)) : "BMap contained nullptr?";
    return Info;
  }

  
  
  /// Return true if any mutexes in FSet are in the acquired_before set of Vd.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::checkBeforeAfter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1035,
   FQN="clang::threadSafety::BeforeSet::checkBeforeAfter", NM="_ZN5clang12threadSafety9BeforeSet16checkBeforeAfterEPKNS_9ValueDeclERKN12_GLOBAL__N_17FactSetERNS5_20ThreadSafetyAnalyzerENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSet16checkBeforeAfterEPKNS_9ValueDeclERKN12_GLOBAL__N_17FactSetERNS5_20ThreadSafetyAnalyzerENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public void checkBeforeAfter(/*const*/ ValueDecl /*P*/ StartVd, 
                  final /*const*/ FactSet /*&*/ FSet, 
                  final ThreadSafetyAnalyzer /*&*/ Analyzer, 
                  SourceLocation Loc, StringRef CapKind) {
    SmallVector<BeforeInfo /*P*/ > InfoVect/*J*/= new SmallVector<BeforeInfo /*P*/ >(8, (BeforeInfo /*P*/ )null);
    
    // Do a depth-first traversal of Vd.
    // Return true if there are cycles.
    ThisValueDecl2Bool traverse = /*FuncArg*//*[&, this, &Analyzer, &InfoVect, &FSet, &StartVd, &CapKind, &Loc, &traverse]*/ (ThisValueDecl2Bool $this, /*const*/ ValueDecl /*P*/ Vd) -> {
          if (!(Vd != null)) {
            return false;
          }
          
          BeforeSet.BeforeInfo /*P*/ Info = getBeforeInfoForDecl(Vd, Analyzer);
          if (Info.Visited == 1) {
            return true;
          }
          if (Info.Visited == 2) {
            return false;
          }
          if (Info.Vect.empty()) {
            return false;
          }
          
          InfoVect.push_back(Info);
          Info.Visited = 1;
          for (/*const*/ ValueDecl /*P*/ Vdb : Info.Vect) {
            // Exclude mutexes in our immediate before set.
            if (FSet.containsMutexDecl(Analyzer.FactMan, Vdb)) {
              StringRef L1 = StartVd.getName();
              StringRef L2 = Vdb.getName();
              Analyzer.Handler.handleLockAcquiredBefore(new StringRef(CapKind), new StringRef(L1), new StringRef(L2), new SourceLocation(Loc));
            }
            // Transitively search other before sets, and warn on cycles.
            if ($this.$call($this, Vdb)) {
              if (CycMap.find(Vd).$eq(/*NO_ITER_COPY*/CycMap.end())) {
                CycMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_bool(Vd, true));
                StringRef L1 = Vd.getName();
                Analyzer.Handler.handleBeforeAfterCycle(new StringRef(L1), Vd.getLocation());
              }
            }
          }
          Info.Visited = 2;
          return false;
        };
    
    traverse.$call(traverse, StartVd);
    
    for (BeforeInfo /*P*/ Info : InfoVect)  {
      Info.Visited = 0;
    }
  }

/*private:*/
  private DenseMap</*const*/ ValueDecl /*P*/ , std.unique_ptr<BeforeInfo>> BMap;
  private DenseMapTypeBool</*const*/ ValueDecl /*P*/ > CycMap;
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::BeforeSet::~BeforeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 256,
   FQN="clang::threadSafety::BeforeSet::~BeforeSet", NM="_ZN5clang12threadSafety9BeforeSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety9BeforeSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CycMap.$destroy();
    BMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "BMap=" + BMap // NOI18N
              + ", CycMap=" + CycMap; // NOI18N
  }
}
