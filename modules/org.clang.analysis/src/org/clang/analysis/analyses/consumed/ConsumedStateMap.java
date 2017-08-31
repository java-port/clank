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

package org.clang.analysis.analyses.consumed;

import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.consumed.*;
import static org.clang.analysis.impl.ConsumedStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 131,
 FQN="clang::consumed::ConsumedStateMap", NM="_ZN5clang8consumed16ConsumedStateMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMapE")
//</editor-fold>
public class ConsumedStateMap implements Destructors.ClassWithDestructor {
  
  /*typedef llvm::DenseMap<const VarDecl *, ConsumedState> VarMapType*/
//  public final class VarMapType extends DenseMap</*const*/ VarDecl /*P*/ , ConsumedState>{ };
  /*typedef llvm::DenseMap<const CXXBindTemporaryExpr *, ConsumedState> TmpMapType*/
//  public final class TmpMapType extends DenseMap</*const*/ CXXBindTemporaryExpr /*P*/ , ConsumedState>{ };
/*protected:*/
  
  protected boolean Reachable;
  protected /*const*/ Stmt /*P*/ From;
  protected DenseMap</*const*/ VarDecl /*P*/ , ConsumedState> VarMap;
  protected DenseMap</*const*/ CXXBindTemporaryExpr /*P*/ , ConsumedState> TmpMap;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::ConsumedStateMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 145,
   FQN="clang::consumed::ConsumedStateMap::ConsumedStateMap", NM="_ZN5clang8consumed16ConsumedStateMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMapC1Ev")
  //</editor-fold>
  public ConsumedStateMap() {
    // : Reachable(true), From(null), VarMap(), TmpMap() 
    //START JInit
    this.Reachable = true;
    this.From = null;
    this.VarMap = new DenseMap</*const*/ VarDecl /*P*/ , ConsumedState>(DenseMapInfo$LikePtr.$Info(), (ConsumedState)null);
    this.TmpMap = new DenseMap</*const*/ CXXBindTemporaryExpr /*P*/ , ConsumedState>(DenseMapInfo$LikePtr.$Info(), (ConsumedState)null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::ConsumedStateMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 146,
   FQN="clang::consumed::ConsumedStateMap::ConsumedStateMap", NM="_ZN5clang8consumed16ConsumedStateMapC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMapC1ERKS1_")
  //</editor-fold>
  public ConsumedStateMap(final /*const*/ ConsumedStateMap /*&*/ Other) {
    // : Reachable(Other.Reachable), From(Other.From), VarMap(Other.VarMap), TmpMap() 
    //START JInit
    this.Reachable = Other.Reachable;
    this.From = Other.From;
    this.VarMap = new DenseMap</*const*/ VarDecl /*P*/ , ConsumedState>(Other.VarMap);
    this.TmpMap = new DenseMap</*const*/ CXXBindTemporaryExpr /*P*/ , ConsumedState>(DenseMapInfo$LikePtr.$Info(), (ConsumedState)null);
    //END JInit
  }

  
  /// \brief Warn if any of the parameters being tracked are not in the state
  /// they were declared to be in upon return from a function.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::checkParamsForReturnTypestate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1121,
   FQN="clang::consumed::ConsumedStateMap::checkParamsForReturnTypestate", NM="_ZNK5clang8consumed16ConsumedStateMap29checkParamsForReturnTypestateENS_14SourceLocationERNS0_27ConsumedWarningsHandlerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed16ConsumedStateMap29checkParamsForReturnTypestateENS_14SourceLocationERNS0_27ConsumedWarningsHandlerBaseE")
  //</editor-fold>
  public void checkParamsForReturnTypestate(SourceLocation BlameLoc, 
                               final ConsumedWarningsHandlerBase /*&*/ WarningsHandler) /*const*/ {
    for (final /*const*/ pair</*const*/ VarDecl /*P*/ , ConsumedState> /*&*/ DM : VarMap) {
      if (isa_ParmVarDecl(DM.first)) {
        /*const*/ ParmVarDecl /*P*/ Param = cast_ParmVarDecl(DM.first);
        /*const*/ ReturnTypestateAttr /*P*/ RTA = Param.getAttr(ReturnTypestateAttr.class);
        if (!(RTA != null)) {
          continue;
        }
        
        ConsumedState ExpectedState = mapReturnTypestateAttrState(RTA);
        if (DM.second != ExpectedState) {
          WarningsHandler.warnParamReturnTypestateMismatch(new SourceLocation(BlameLoc), 
              new StringRef(Param.getNameAsString()), stateToString(ExpectedState), 
              stateToString(DM.second));
        }
      }
    }
  }

  
  /// \brief Clear the TmpMap.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::clearTemporaries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1141,
   FQN="clang::consumed::ConsumedStateMap::clearTemporaries", NM="_ZN5clang8consumed16ConsumedStateMap16clearTemporariesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap16clearTemporariesEv")
  //</editor-fold>
  public void clearTemporaries() {
    TmpMap.clear();
  }

  
  /// \brief Get the consumed state of a given variable.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1145,
   FQN="clang::consumed::ConsumedStateMap::getState", NM="_ZNK5clang8consumed16ConsumedStateMap8getStateEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed16ConsumedStateMap8getStateEPKNS_7VarDeclE")
  //</editor-fold>
  public ConsumedState getState(/*const*/ VarDecl /*P*/ Var) /*const*/ {
    DenseMapIterator</*const*/ VarDecl /*P*/ , ConsumedState> Entry = VarMap.find$Const(Var);
    if (Entry.$noteq(VarMap.end$Const())) {
      return Entry.$arrow().second;
    }
    
    return ConsumedState.CS_None;
  }

  
  /// \brief Get the consumed state of a given temporary value.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1154,
   FQN="clang::consumed::ConsumedStateMap::getState", NM="_ZNK5clang8consumed16ConsumedStateMap8getStateEPKNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed16ConsumedStateMap8getStateEPKNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public ConsumedState getState(/*const*/ CXXBindTemporaryExpr /*P*/ Tmp) /*const*/ {
    DenseMapIterator</*const*/ CXXBindTemporaryExpr /*P*/ , ConsumedState> Entry = TmpMap.find$Const(Tmp);
    if (Entry.$noteq(TmpMap.end$Const())) {
      return Entry.$arrow().second;
    }
    
    return ConsumedState.CS_None;
  }

  
  /// \brief Merge this state map with another map.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::intersect">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1164,
   FQN="clang::consumed::ConsumedStateMap::intersect", NM="_ZN5clang8consumed16ConsumedStateMap9intersectERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap9intersectERKS1_")
  //</editor-fold>
  public void intersect(final /*const*/ ConsumedStateMap /*&*/ Other) {
    ConsumedState LocalState;
    if ((this.From != null) && this.From == Other.From && !Other.Reachable) {
      this.markUnreachable();
      return;
    }
    
    for (final /*const*/ pair</*const*/ VarDecl /*P*/ , ConsumedState> /*&*/ DM : Other.VarMap) {
      LocalState = this.getState(DM.first);
      if (LocalState == ConsumedState.CS_None) {
        continue;
      }
      if (LocalState != DM.second) {
        VarMap.$set(DM.first, ConsumedState.CS_Unknown);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::intersectAtLoopHead">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1183,
   FQN="clang::consumed::ConsumedStateMap::intersectAtLoopHead", NM="_ZN5clang8consumed16ConsumedStateMap19intersectAtLoopHeadEPKNS_8CFGBlockES4_PKS1_RNS0_27ConsumedWarningsHandlerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap19intersectAtLoopHeadEPKNS_8CFGBlockES4_PKS1_RNS0_27ConsumedWarningsHandlerBaseE")
  //</editor-fold>
  public void intersectAtLoopHead(/*const*/ CFGBlock /*P*/ LoopHead, 
                     /*const*/ CFGBlock /*P*/ LoopBack, /*const*/ ConsumedStateMap /*P*/ LoopBackStates, 
                     final ConsumedWarningsHandlerBase /*&*/ WarningsHandler) {
    
    ConsumedState LocalState;
    SourceLocation BlameLoc = getLastStmtLoc(LoopBack);
    
    for (final /*const*/ pair</*const*/ VarDecl /*P*/ , ConsumedState> /*&*/ DM : LoopBackStates.VarMap) {
      LocalState = this.getState(DM.first);
      if (LocalState == ConsumedState.CS_None) {
        continue;
      }
      if (LocalState != DM.second) {
        VarMap.$set(DM.first, ConsumedState.CS_Unknown);
        WarningsHandler.warnLoopStateMismatch(new SourceLocation(BlameLoc), 
            new StringRef(DM.first.getNameAsString()));
      }
    }
  }

  
  /// \brief Return true if this block is reachable.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::isReachable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 172,
   FQN="clang::consumed::ConsumedStateMap::isReachable", NM="_ZNK5clang8consumed16ConsumedStateMap11isReachableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed16ConsumedStateMap11isReachableEv")
  //</editor-fold>
  public boolean isReachable() /*const*/ {
    return Reachable;
  }

  
  /// \brief Mark the block as unreachable.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::markUnreachable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1204,
   FQN="clang::consumed::ConsumedStateMap::markUnreachable", NM="_ZN5clang8consumed16ConsumedStateMap15markUnreachableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap15markUnreachableEv")
  //</editor-fold>
  public void markUnreachable() {
    this.Reachable = false;
    VarMap.clear();
    TmpMap.clear();
  }

  
  /// \brief Set the source for a decision about the branching of states.
  /// \param Source -- The statement that was the origin of a branching
  /// decision.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::setSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 180,
   FQN="clang::consumed::ConsumedStateMap::setSource", NM="_ZN5clang8consumed16ConsumedStateMap9setSourceEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap9setSourceEPKNS_4StmtE")
  //</editor-fold>
  public void setSource(/*const*/ Stmt /*P*/ Source) {
    this.From = Source;
  }

  
  /// \brief Set the consumed state of a given variable.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::setState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1210,
   FQN="clang::consumed::ConsumedStateMap::setState", NM="_ZN5clang8consumed16ConsumedStateMap8setStateEPKNS_7VarDeclENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap8setStateEPKNS_7VarDeclENS0_13ConsumedStateE")
  //</editor-fold>
  public void setState(/*const*/ VarDecl /*P*/ Var, ConsumedState State) {
    VarMap.$set(Var, State);
  }

  
  /// \brief Set the consumed state of a given temporary value.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::setState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1214,
   FQN="clang::consumed::ConsumedStateMap::setState", NM="_ZN5clang8consumed16ConsumedStateMap8setStateEPKNS_20CXXBindTemporaryExprENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap8setStateEPKNS_20CXXBindTemporaryExprENS0_13ConsumedStateE")
  //</editor-fold>
  public void setState(/*const*/ CXXBindTemporaryExpr /*P*/ Tmp, 
          ConsumedState State) {
    TmpMap.$set(Tmp, State);
  }

  
  /// \brief Remove the temporary value from our state map.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1219,
   FQN="clang::consumed::ConsumedStateMap::remove", NM="_ZN5clang8consumed16ConsumedStateMap6removeEPKNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMap6removeEPKNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public void remove(/*const*/ CXXBindTemporaryExpr /*P*/ Tmp) {
    TmpMap.erase(Tmp);
  }

  
  /// \brief Tests to see if there is a mismatch in the states stored in two
  /// maps.
  ///
  /// \param Other -- The second map to compare against.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1223,
   FQN="clang::consumed::ConsumedStateMap::operator!=", NM="_ZNK5clang8consumed16ConsumedStateMapneEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed16ConsumedStateMapneEPKS1_")
  //</editor-fold>
  public boolean $noteq(/*const*/ ConsumedStateMap /*P*/ Other) /*const*/ {
    for (final /*const*/ pair</*const*/ VarDecl /*P*/ , ConsumedState> /*&*/ DM : Other.VarMap)  {
      if (this.getState(DM.first) != DM.second) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStateMap::~ConsumedStateMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 131,
   FQN="clang::consumed::ConsumedStateMap::~ConsumedStateMap", NM="_ZN5clang8consumed16ConsumedStateMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedStateMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TmpMap.$destroy();
    VarMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Reachable=" + Reachable // NOI18N
              + ", From=" + From // NOI18N
              + ", VarMap=" + VarMap // NOI18N
              + ", TmpMap=" + TmpMap; // NOI18N
  }
}
