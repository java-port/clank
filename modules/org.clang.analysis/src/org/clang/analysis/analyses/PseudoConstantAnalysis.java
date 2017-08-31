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

package org.clang.analysis.analyses;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PseudoConstantAnalysis.h", line = 23,
 FQN="clang::PseudoConstantAnalysis", NM="_ZN5clang22PseudoConstantAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysisE")
//</editor-fold>
public class PseudoConstantAnalysis implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis::PseudoConstantAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp", line = 27,
   FQN="clang::PseudoConstantAnalysis::PseudoConstantAnalysis", NM="_ZN5clang22PseudoConstantAnalysisC1EPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysisC1EPKNS_4StmtE")
  //</editor-fold>
  public PseudoConstantAnalysis(/*const*/ Stmt /*P*/ DeclBody) {
    // : DeclBody(DeclBody), Analyzed(false) 
    //START JInit
    this.DeclBody = DeclBody;
    this.Analyzed = false;
    //END JInit
    NonConstantsImpl = new SmallPtrSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    UsedVarsImpl = new SmallPtrSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis::~PseudoConstantAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp", line = 33,
   FQN="clang::PseudoConstantAnalysis::~PseudoConstantAnalysis", NM="_ZN5clang22PseudoConstantAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysisD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)NonConstantsImpl != null) { ((SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)NonConstantsImpl).$destroy();};
    if ((SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)UsedVarsImpl != null) { ((SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)UsedVarsImpl).$destroy();};
  }

  
  
  // Returns true if the given ValueDecl is never written to in the given DeclBody
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis::isPseudoConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp", line = 39,
   FQN="clang::PseudoConstantAnalysis::isPseudoConstant", NM="_ZN5clang22PseudoConstantAnalysis16isPseudoConstantEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysis16isPseudoConstantEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean isPseudoConstant(/*const*/ VarDecl /*P*/ VD) {
    // Only local and static variables can be pseudoconstants
    if (!VD.hasLocalStorage() && !VD.isStaticLocal()) {
      return false;
    }
    if (!Analyzed) {
      RunAnalysis();
      Analyzed = true;
    }
    
    SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/ NonConstants = (SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)NonConstantsImpl;
    
    return !(NonConstants.count(VD) != 0);
  }

  
  // Returns true if the variable was used (self assignments don't count)
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis::wasReferenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp", line = 55,
   FQN="clang::PseudoConstantAnalysis::wasReferenced", NM="_ZN5clang22PseudoConstantAnalysis13wasReferencedEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysis13wasReferencedEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean wasReferenced(/*const*/ VarDecl /*P*/ VD) {
    if (!Analyzed) {
      RunAnalysis();
      Analyzed = true;
    }
    
    SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/ UsedVars = (SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)UsedVarsImpl;
    
    return (UsedVars.count(VD) != 0);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis::RunAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp", line = 74,
   FQN="clang::PseudoConstantAnalysis::RunAnalysis", NM="_ZN5clang22PseudoConstantAnalysis11RunAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysis11RunAnalysisEv")
  //</editor-fold>
  private void RunAnalysis() {
    std.deque</*const*/ Stmt /*P*/ > WorkList = null;
    try {
      WorkList/*J*/= new std.deque</*const*/ Stmt /*P*/ >(true);
      SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/ NonConstants = (SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)NonConstantsImpl;
      SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/ UsedVars = (SmallPtrSet</*const*/ VarDecl /*P*/ > /*P*/)UsedVarsImpl;
      
      // Start with the top level statement of the function
      WorkList.push_back_T$C$R(DeclBody);
      while (!WorkList.empty()) {
        /*const*/ Stmt /*P*/ Head = WorkList.front();
        WorkList.pop_front();
        {
          
          /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(Head);
          if ((Ex != null)) {
            Head = Ex.IgnoreParenCasts$Const();
          }
        }
        switch (Head.getStmtClass()) {
         case BinaryOperatorClass:
          {
            /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(Head);
            // Look for a Decl on the LHS
            /*const*/ Decl /*P*/ LHSDecl = getDecl(BO.getLHS().IgnoreParenCasts());
            if (!(LHSDecl != null)) {
              break;
            }
            
            // We found a binary operator with a DeclRefExpr on the LHS. We now check
            // for any of the assignment operators, implying that this Decl is being
            // written to.
            switch (BO.getOpcode()) {
             case BO_Assign:
              {
                // Look for a DeclRef on the RHS
                /*const*/ Decl /*P*/ RHSDecl = getDecl(BO.getRHS().IgnoreParenCasts());
                
                // If the Decls match, we have self-assignment
                if (LHSDecl == RHSDecl) {
                  // Do not visit the children
                  continue;
                }
              }
             case BO_AddAssign:
             case BO_SubAssign:
             case BO_MulAssign:
             case BO_DivAssign:
             case BO_AndAssign:
             case BO_OrAssign:
             case BO_XorAssign:
             case BO_ShlAssign:
             case BO_ShrAssign:
              {
                /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(LHSDecl);
                // The DeclRefExpr is being assigned to - mark it as non-constant
                if ((VD != null)) {
                  NonConstants.insert(VD);
                }
                break;
              }
             default:
              break;
            }
            break;
          }
         case UnaryOperatorClass:
          {
            /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(Head);
            
            // Look for a DeclRef in the subexpression
            /*const*/ Decl /*P*/ D = getDecl(UO.getSubExpr().IgnoreParenCasts());
            if (!(D != null)) {
              break;
            }
            
            // We found a unary operator with a DeclRef as a subexpression. We now
            // check for any of the increment/decrement operators, as well as
            // addressOf.
            switch (UO.getOpcode()) {
             case UO_PostDec:
             case UO_PostInc:
             case UO_PreDec:
             case UO_PreInc:
             case UO_AddrOf:
              {
                // If we are taking the address of the DeclRefExpr, assume it is
                // non-constant.
                /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
                if ((VD != null)) {
                  NonConstants.insert(VD);
                }
                break;
              }
             default:
              break;
            }
            break;
          }
         case DeclStmtClass:
          {
            /*const*/ DeclStmt /*P*/ DS = cast_DeclStmt(Head);
            // Iterate over each decl and see if any of them contain reference decls
            for (/*const*/ Decl /*P*/ I : DS.decls$Const()) {
              // We only care about VarDecls
              /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(I);
              if (!(VD != null)) {
                continue;
              }
              
              // We found a VarDecl; make sure it is a reference type
              if (!VD.getType().getTypePtr().isReferenceType()) {
                continue;
              }
              
              // Try to find a Decl in the initializer
              /*const*/ Decl /*P*/ D = getDecl(VD.getInit$Const().IgnoreParenCasts$Const());
              if (!(D != null)) {
                break;
              }
              {
                
                // If the reference is to another var, add the var to the non-constant
                // list
                /*const*/ VarDecl /*P*/ RefVD = dyn_cast_VarDecl(D);
                if ((RefVD != null)) {
                  NonConstants.insert(RefVD);
                  continue;
                }
              }
            }
            break;
          }
         case DeclRefExprClass:
          {
            /*const*/ DeclRefExpr /*P*/ DR = cast_DeclRefExpr(Head);
            {
              /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
              if ((VD != null)) {
                // Add the Decl to the used list
                UsedVars.insert(VD);
                continue;
              }
            }
            break;
          }
         case BlockExprClass:
          {
            /*const*/ BlockExpr /*P*/ B = cast_BlockExpr(Head);
            // Add the body of the block to the list
            WorkList.push_back_T$RR(B.getBody$Const());
            continue;
          }
         default:
          break;
        } // switch (head->getStmtClass())
        
        // Add all substatements to the worklist
        for (/*const*/ Stmt /*P*/ SubStmt : Head.children$Const())  {
          if ((SubStmt != null)) {
            WorkList.push_back_T$C$R(SubStmt);
          }
        }
      } // while (!WorkList.empty())
    } finally {
      if (WorkList != null) { WorkList.$destroy(); }
    }
  }

  
  // Returns a Decl from a (Block)DeclRefExpr (if any)
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoConstantAnalysis::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp", line = 67,
   FQN="clang::PseudoConstantAnalysis::getDecl", NM="_ZN5clang22PseudoConstantAnalysis7getDeclEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PseudoConstantAnalysis.cpp -nm=_ZN5clang22PseudoConstantAnalysis7getDeclEPKNS_4ExprE")
  //</editor-fold>
  private static /*const*/ Decl /*P*/ getDecl(/*const*/ Expr /*P*/ E) {
    {
      /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E);
      if ((DR != null)) {
        return DR.getDecl$Const();
      } else {
        return null;
      }
    }
  }

  
  // for storing the result of analyzed ValueDecls
  private Object/*void P*/ NonConstantsImpl;
  private Object/*void P*/ UsedVarsImpl;
  
  private /*const*/ Stmt /*P*/ DeclBody;
  private boolean Analyzed;
  
  @Override public String toString() {
    return "" + "NonConstantsImpl=" + NonConstantsImpl // NOI18N
              + ", UsedVarsImpl=" + UsedVarsImpl // NOI18N
              + ", DeclBody=" + DeclBody // NOI18N
              + ", Analyzed=" + Analyzed; // NOI18N
  }
}
