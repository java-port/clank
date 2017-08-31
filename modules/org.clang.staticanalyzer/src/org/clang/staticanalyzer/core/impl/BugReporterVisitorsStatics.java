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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.core.impl.BugReporterVisitorsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type BugReporterVisitorsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZL16peelOffOuterExprPKN5clang4ExprEPKNS_4ento12ExplodedNodeE;_ZL21isInitializationOfVarPKN5clang4ento12ExplodedNodeEPKNS0_9VarRegionE;_ZL28getLocationRegionIfReferencePKN5clang4ExprEPKNS_4ento12ExplodedNodeE; -static-type=BugReporterVisitorsStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class BugReporterVisitorsStatics {


/// Returns true if \p N represents the DeclStmt declaring and initializing
/// \p VR.
//<editor-fold defaultstate="collapsed" desc="isInitializationOfVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 423,
 FQN="isInitializationOfVar", NM="_ZL21isInitializationOfVarPKN5clang4ento12ExplodedNodeEPKNS0_9VarRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZL21isInitializationOfVarPKN5clang4ento12ExplodedNodeEPKNS0_9VarRegionE")
//</editor-fold>
public static boolean isInitializationOfVar(/*const*/ ExplodedNode /*P*/ N, /*const*/ VarRegion /*P*/ VR) {
  Optional<org.clang.analysis.PostStmt> P = N.<org.clang.analysis.PostStmt>getLocationAs(org.clang.analysis.PostStmt.class);
  if (!P.$bool()) {
    return false;
  }
  
  /*const*/ DeclStmt /*P*/ DS = P.$arrow().<DeclStmt>getStmtAs(DeclStmt.class);
  if (!(DS != null)) {
    return false;
  }
  if (DS.getSingleDecl$Const() != VR.getDecl()) {
    return false;
  }
  
  /*const*/ MemSpaceRegion /*P*/ VarSpace = VR.getMemorySpace();
  /*const*/ StackSpaceRegion /*P*/ FrameSpace = dyn_cast_StackSpaceRegion(VarSpace);
  if (!(FrameSpace != null)) {
    // If we ever directly evaluate global DeclStmts, this assertion will be
    // invalid, but this still seems preferable to silently accepting an
    // initialization that may be for a path-sensitive variable.
    assert (VR.getDecl().isStaticLocal()) : "non-static stackless VarRegion";
    return true;
  }
  assert (VR.getDecl().hasLocalStorage());
  /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
  return FrameSpace.getStackFrame() == LCtx.getCurrentStackFrame();
}

//<editor-fold defaultstate="collapsed" desc="getLocationRegionIfReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 886,
 FQN="getLocationRegionIfReference", NM="_ZL28getLocationRegionIfReferencePKN5clang4ExprEPKNS_4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZL28getLocationRegionIfReferencePKN5clang4ExprEPKNS_4ento12ExplodedNodeE")
//</editor-fold>
public static /*const*/ MemRegion /*P*/ getLocationRegionIfReference(/*const*/ Expr /*P*/ E, 
                            /*const*/ ExplodedNode /*P*/ N) {
  {
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E);
    if ((DR != null)) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
        if ((VD != null)) {
          if (!VD.getType().$arrow().isReferenceType()) {
            return null;
          }
          final ProgramStateManager /*&*/ StateMgr = N.getState().$arrow().getStateManager();
          final MemRegionManager /*&*/ MRMgr = StateMgr.getRegionManager();
          return MRMgr.getVarRegion(VD, N.getLocationContext());
        }
      }
    }
  }
  
  // FIXME: This does not handle other kinds of null references,
  // for example, references from FieldRegions:
  //   struct Wrapper { int &ref; };
  //   Wrapper w = { *(int *)0 };
  //   w.ref = 1;
  return null;
}

//<editor-fold defaultstate="collapsed" desc="peelOffOuterExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 907,
 FQN="peelOffOuterExpr", NM="_ZL16peelOffOuterExprPKN5clang4ExprEPKNS_4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZL16peelOffOuterExprPKN5clang4ExprEPKNS_4ento12ExplodedNodeE")
//</editor-fold>
public static /*const*/ Expr /*P*/ peelOffOuterExpr(/*const*/ Expr /*P*/ Ex, 
                /*const*/ ExplodedNode /*P*/ N) {
  Ex = Ex.IgnoreParenCasts$Const();
  {
    /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(Ex);
    if ((EWC != null)) {
      return peelOffOuterExpr(EWC.getSubExpr$Const(), N);
    }
  }
  {
    /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(Ex);
    if ((OVE != null)) {
      return peelOffOuterExpr(OVE.getSourceExpr(), N);
    }
  }
  {
    /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(Ex);
    if ((POE != null)) {
      /*const*/ ObjCPropertyRefExpr /*P*/ PropRef = dyn_cast_ObjCPropertyRefExpr(POE.getSyntacticForm$Const());
      if ((PropRef != null) && PropRef.isMessagingGetter()) {
        /*const*/ Expr /*P*/ GetterMessageSend = POE.getSemanticExpr$Const(POE.getNumSemanticExprs() - 1);
        assert (isa_ObjCMessageExpr(GetterMessageSend));
        return peelOffOuterExpr(GetterMessageSend, N);
      }
    }
  }
  {
    
    // Peel off the ternary operator.
    /*const*/ ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(Ex);
    if ((CO != null)) {
      // Find a node where the branching occurred and find out which branch
      // we took (true/false) by looking at the ExplodedGraph.
      /*const*/ ExplodedNode /*P*/ NI = N;
      do {
        ProgramPoint ProgPoint = NI.getLocation();
        {
          Optional<BlockEdge> BE = ProgPoint.getAs(BlockEdge.class);
          if (BE.$bool()) {
            /*const*/ CFGBlock /*P*/ srcBlk = BE.$arrow().getSrc();
            {
              /*const*/ Stmt /*P*/ term = srcBlk.getTerminator$Const().$Stmt$C$P();
              if ((term != null)) {
                if (term == CO) {
                  boolean TookTrueBranch = ((srcBlk.succ_begin$Const()).$star().$CFGBlock$P() == BE.$arrow().getDst());
                  if (TookTrueBranch) {
                    return peelOffOuterExpr(CO.getTrueExpr(), N);
                  } else {
                    return peelOffOuterExpr(CO.getFalseExpr(), N);
                  }
                }
              }
            }
          }
        }
        NI = NI.getFirstPred$Const();
      } while ((NI != null));
    }
  }
  return Ex;
}

} // END OF class BugReporterVisitorsStatics
