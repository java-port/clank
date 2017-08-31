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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.impl.CGClassStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1231,
 FQN="(anonymous namespace)::AssignmentMemcpyizer", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizerE")
//</editor-fold>
public class AssignmentMemcpyizer extends /*public*/ FieldMemcpyizer implements Destructors.ClassWithDestructor {
/*private:*/
  // Returns the memcpyable field copied by the given statement, if one
  // exists. Otherwise returns null.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer::getMemcpyableField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1235,
   FQN="(anonymous namespace)::AssignmentMemcpyizer::getMemcpyableField", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizer18getMemcpyableFieldEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizer18getMemcpyableFieldEPN5clang4StmtE")
  //</editor-fold>
  private FieldDecl /*P*/ getMemcpyableField(Stmt /*P*/ S) {
    if (!AssignmentsMemcpyable) {
      return null;
    }
    {
      org.clang.ast.BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(S);
      if ((BO != null)) {
        // Recognise trivial assignments.
        if (BO.getOpcode() != BinaryOperatorKind.BO_Assign) {
          return null;
        }
        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(BO.getLHS());
        if (!(ME != null)) {
          return null;
        }
        FieldDecl /*P*/ Field = dyn_cast_FieldDecl(ME.getMemberDecl());
        if (!(Field != null) || !isMemcpyableField(Field)) {
          return null;
        }
        Stmt /*P*/ RHS = BO.getRHS();
        {
          ImplicitCastExpr /*P*/ EC = dyn_cast_ImplicitCastExpr(RHS);
          if ((EC != null)) {
            RHS = EC.getSubExpr();
          }
        }
        if (!(RHS != null)) {
          return null;
        }
        MemberExpr /*P*/ ME2 = dyn_cast_MemberExpr(RHS);
        if (dyn_cast_FieldDecl(ME2.getMemberDecl()) != Field) {
          return null;
        }
        return Field;
      } else {
        CXXMemberCallExpr /*P*/ MCE = dyn_cast_CXXMemberCallExpr(S);
        if ((MCE != null)) {
          CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(MCE.getCalleeDecl());
          if (!((MD != null) && isMemcpyEquivalentSpecialMember(MD))) {
            return null;
          }
          MemberExpr /*P*/ IOA = dyn_cast_MemberExpr(MCE.getImplicitObjectArgument());
          if (!(IOA != null)) {
            return null;
          }
          FieldDecl /*P*/ Field = dyn_cast_FieldDecl(IOA.getMemberDecl());
          if (!(Field != null) || !isMemcpyableField(Field)) {
            return null;
          }
          MemberExpr /*P*/ Arg0 = dyn_cast_MemberExpr(MCE.getArg(0));
          if (!(Arg0 != null) || Field != dyn_cast_FieldDecl(Arg0.getMemberDecl())) {
            return null;
          }
          return Field;
        } else {
          CallExpr /*P*/ CE = dyn_cast_CallExpr(S);
          if ((CE != null)) {
            FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CE.getCalleeDecl());
            if (!(FD != null) || FD.getBuiltinID() != Builtin.ID.BI__builtin_memcpy.getValue()) {
              return null;
            }
            Expr /*P*/ DstPtr = CE.getArg(0);
            {
              ImplicitCastExpr /*P*/ DC = dyn_cast_ImplicitCastExpr(DstPtr);
              if ((DC != null)) {
                DstPtr = DC.getSubExpr();
              }
            }
            UnaryOperator /*P*/ DUO = dyn_cast_UnaryOperator(DstPtr);
            if (!(DUO != null) || DUO.getOpcode() != UnaryOperatorKind.UO_AddrOf) {
              return null;
            }
            MemberExpr /*P*/ ME = dyn_cast_MemberExpr(DUO.getSubExpr());
            if (!(ME != null)) {
              return null;
            }
            FieldDecl /*P*/ Field = dyn_cast_FieldDecl(ME.getMemberDecl());
            if (!(Field != null) || !isMemcpyableField(Field)) {
              return null;
            }
            Expr /*P*/ SrcPtr = CE.getArg(1);
            {
              ImplicitCastExpr /*P*/ SC = dyn_cast_ImplicitCastExpr(SrcPtr);
              if ((SC != null)) {
                SrcPtr = SC.getSubExpr();
              }
            }
            UnaryOperator /*P*/ SUO = dyn_cast_UnaryOperator(SrcPtr);
            if (!(SUO != null) || SUO.getOpcode() != UnaryOperatorKind.UO_AddrOf) {
              return null;
            }
            MemberExpr /*P*/ ME2 = dyn_cast_MemberExpr(SUO.getSubExpr());
            if (!(ME2 != null) || Field != dyn_cast_FieldDecl(ME2.getMemberDecl())) {
              return null;
            }
            return Field;
          }
        }
      }
    }
    
    return null;
  }

  
  private boolean AssignmentsMemcpyable;
  private SmallVector<Stmt /*P*/ > AggregatedStmts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer::AssignmentMemcpyizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1306,
   FQN="(anonymous namespace)::AssignmentMemcpyizer::AssignmentMemcpyizer", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizerC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXMethodDeclERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizerC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXMethodDeclERNS2_15FunctionArgListE")
  //</editor-fold>
  public AssignmentMemcpyizer(final CodeGenFunction /*&*/ CGF, /*const*/ CXXMethodDecl /*P*/ AD, 
      final FunctionArgList /*&*/ Args) {
    // : FieldMemcpyizer(CGF, AD->getParent(), Args[Args.size() - 1]), AssignmentsMemcpyable(CGF.getLangOpts().getGC() == LangOptions::NonGC), AggregatedStmts() 
    //START JInit
    super(CGF, AD.getParent$Const(), Args.$at(Args.size() - 1));
    this.AssignmentsMemcpyable = CGF.getLangOpts().getGC() == LangOptions.GCMode.NonGC;
    this.AggregatedStmts = new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    //END JInit
    assert (Args.size() == 2);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer::emitAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1313,
   FQN="(anonymous namespace)::AssignmentMemcpyizer::emitAssignment", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizer14emitAssignmentEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizer14emitAssignmentEPN5clang4StmtE")
  //</editor-fold>
  public void emitAssignment(Stmt /*P*/ S) {
    FieldDecl /*P*/ F = getMemcpyableField(S);
    if ((F != null)) {
      addMemcpyableField(F);
      AggregatedStmts.push_back(S);
    } else {
      emitAggregatedStmts();
      CGF.EmitStmt(S);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer::emitAggregatedStmts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1324,
   FQN="(anonymous namespace)::AssignmentMemcpyizer::emitAggregatedStmts", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizer19emitAggregatedStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizer19emitAggregatedStmtsEv")
  //</editor-fold>
  public void emitAggregatedStmts() {
    if ($lesseq_uint(AggregatedStmts.size(), 1)) {
      if (!AggregatedStmts.empty()) {
        CopyingValueRepresentation CVR = null;
        try {
          CVR/*J*/= new CopyingValueRepresentation(CGF);
          CGF.EmitStmt(AggregatedStmts.$at(0));
        } finally {
          if (CVR != null) { CVR.$destroy(); }
        }
      }
      reset();
    }
    
    emitMemcpy();
    AggregatedStmts.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1337,
   FQN="(anonymous namespace)::AssignmentMemcpyizer::finish", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizer6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizer6finishEv")
  //</editor-fold>
  public void finish() {
    emitAggregatedStmts();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssignmentMemcpyizer::~AssignmentMemcpyizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1231,
   FQN="(anonymous namespace)::AssignmentMemcpyizer::~AssignmentMemcpyizer", NM="_ZN12_GLOBAL__N_120AssignmentMemcpyizerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_120AssignmentMemcpyizerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AggregatedStmts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "AssignmentsMemcpyable=" + AssignmentsMemcpyable // NOI18N
              + ", AggregatedStmts=" + "[SmallVector$Stmt]" // NOI18N
              + super.toString(); // NOI18N
  }
}
