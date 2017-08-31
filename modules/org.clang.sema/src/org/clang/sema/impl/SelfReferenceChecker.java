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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


// Visits an initialization expression to see if OrigDecl is evaluated in
// its own initialization and throws a warning if it does.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9094,
 FQN="(anonymous namespace)::SelfReferenceChecker", NM="_ZN12_GLOBAL__N_120SelfReferenceCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceCheckerE")
//</editor-fold>
public class SelfReferenceChecker implements /*public*/ EvaluatedExprVisitor<SelfReferenceChecker>, Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  private Decl /*P*/ OrigDecl;
  private boolean isRecordType;
  private boolean isPODType;
  private boolean isReferenceType;
  
  private boolean isInitList;
  private SmallVectorUInt InitFieldIndex;
/*public:*/
  /*typedef EvaluatedExprVisitor<SelfReferenceChecker> Inherited*/
//  public final class Inherited extends EvaluatedExprVisitor<SelfReferenceChecker>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::SelfReferenceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9108,
   FQN="(anonymous namespace)::SelfReferenceChecker::SelfReferenceChecker", NM="_ZN12_GLOBAL__N_120SelfReferenceCheckerC1ERN5clang4SemaEPNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceCheckerC1ERN5clang4SemaEPNS1_4DeclE")
  //</editor-fold>
  public SelfReferenceChecker(final Sema /*&*/ S, Decl /*P*/ OrigDecl) {
    // : Inherited(S.Context), S(S), OrigDecl(OrigDecl), InitFieldIndex() 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this./*&*/S=/*&*/S;
    this.OrigDecl = OrigDecl;
    this.InitFieldIndex = new SmallVectorUInt(4, 0);
    //END JInit
    isPODType = false;
    isRecordType = false;
    isReferenceType = false;
    isInitList = false;
    {
      ValueDecl /*P*/ VD = dyn_cast_ValueDecl(OrigDecl);
      if ((VD != null)) {
        isPODType = VD.getType().isPODType(S.Context);
        isRecordType = VD.getType().$arrow().isRecordType();
        isReferenceType = VD.getType().$arrow().isReferenceType();
      }
    }
  }

  
  // For most expressions, just call the visitor.  For initializer lists,
  // track the index of the field being initialized since fields are
  // initialized in order allowing use of previously initialized fields.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::CheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9124,
   FQN="(anonymous namespace)::SelfReferenceChecker::CheckExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker9CheckExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker9CheckExprEPN5clang4ExprE")
  //</editor-fold>
  public void CheckExpr(Expr /*P*/ E) {
    InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(E);
    if (!(InitList != null)) {
      Visit(E);
      return;
    }
    
    // Track and increment the index here.
    isInitList = true;
    InitFieldIndex.push_back(0);
    for (Stmt /*P*/ Child : InitList.children()) {
      CheckExpr(cast_Expr(Child));
      InitFieldIndex.ref$back().$set$preInc();
    }
    InitFieldIndex.pop_back();
  }

  
  // Returns true if MemberExpr is checked and no futher checking is needed.
  // Returns false if additional checking is required.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::CheckInitListMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9143,
   FQN="(anonymous namespace)::SelfReferenceChecker::CheckInitListMemberExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker23CheckInitListMemberExprEPN5clang10MemberExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker23CheckInitListMemberExprEPN5clang10MemberExprEb")
  //</editor-fold>
  public boolean CheckInitListMemberExpr(MemberExpr /*P*/ E, boolean CheckReference) {
    SmallVector<FieldDecl /*P*/ > Fields/*J*/= new SmallVector<FieldDecl /*P*/ >(4, (FieldDecl /*P*/ )null);
    Expr /*P*/ Base = E;
    boolean ReferenceField = false;
    {
      
      // Get the field memebers used.
      MemberExpr /*P*/ ME;
      while (((/*P*/ ME = dyn_cast_MemberExpr(Base)) != null)) {
        FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ME.getMemberDecl());
        if (!(FD != null)) {
          return false;
        }
        Fields.push_back(FD);
        if (FD.getType().$arrow().isReferenceType()) {
          ReferenceField = true;
        }
        Base = ME.getBase().IgnoreParenImpCasts();
      }
    }
    
    // Keep checking only if the base Decl is the same.
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Base);
    if (!(DRE != null) || DRE.getDecl() != OrigDecl) {
      return false;
    }
    
    // A reference field can be bound to an unininitialized field.
    if (CheckReference && !ReferenceField) {
      return true;
    }
    
    // Convert FieldDecls to their index number.
    SmallVectorUInt UsedFieldIndex/*J*/= new SmallVectorUInt(4, 0);
    for (/*const*/ FieldDecl /*P*/ I : llvm.reverse$NotHasRBegin(Fields))  {
      UsedFieldIndex.push_back(I.getFieldIndex());
    }
    
    // See if a warning is needed by checking the first difference in index
    // numbers.  If field being used has index less than the field being
    // initialized, then the use is safe.
    for (uint$ptr/*uint P*/ UsedIter = $tryClone(UsedFieldIndex.begin()), 
        /*P*/ UsedEnd = $tryClone(UsedFieldIndex.end()), 
        /*P*/ OrigIter = $tryClone(InitFieldIndex.begin()), 
        /*P*/ OrigEnd = $tryClone(InitFieldIndex.end());
         $noteq_ptr(UsedIter, UsedEnd) && $noteq_ptr(OrigIter, OrigEnd); UsedIter.$preInc() , OrigIter.$preInc()) {
      if ($less_uint(UsedIter.$star(), OrigIter.$star())) {
        return true;
      }
      if ($greater_uint(UsedIter.$star(), OrigIter.$star())) {
        break;
      }
    }
    
    // TODO: Add a different warning which will print the field names.
    HandleDeclRefExpr(DRE);
    return true;
  }

  
  // For most expressions, the cast is directly above the DeclRefExpr.
  // For conditional operators, the cast can be outside the conditional
  // operator if both expressions are DeclRefExpr's.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::HandleValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9195,
   FQN="(anonymous namespace)::SelfReferenceChecker::HandleValue", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker11HandleValueEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker11HandleValueEPN5clang4ExprE")
  //</editor-fold>
  public void HandleValue(Expr /*P*/ E) {
    E = E.IgnoreParens();
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        HandleDeclRefExpr(DRE);
        return;
      }
    }
    {
      
      ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
      if ((CO != null)) {
        Visit(CO.getCond());
        HandleValue(CO.getTrueExpr());
        HandleValue(CO.getFalseExpr());
        return;
      }
    }
    {
      
      BinaryConditionalOperator /*P*/ BCO = dyn_cast_BinaryConditionalOperator(E);
      if ((BCO != null)) {
        Visit(BCO.getCond());
        HandleValue(BCO.getFalseExpr());
        return;
      }
    }
    {
      
      OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
      if ((OVE != null)) {
        HandleValue(OVE.getSourceExpr());
        return;
      }
    }
    {
      
      BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
      if ((BO != null)) {
        if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
          Visit(BO.getLHS());
          HandleValue(BO.getRHS());
          return;
        }
      }
    }
    if (isa_MemberExpr(E)) {
      if (isInitList) {
        if (CheckInitListMemberExpr(cast_MemberExpr(E), 
            false/*CheckReference*/)) {
          return;
        }
      }
      
      Expr /*P*/ Base = E.IgnoreParenImpCasts();
      {
        MemberExpr /*P*/ ME;
        while (((/*P*/ ME = dyn_cast_MemberExpr(Base)) != null)) {
          // Check for static member variables and don't warn on them.
          if (!isa_FieldDecl(ME.getMemberDecl())) {
            return;
          }
          Base = ME.getBase().IgnoreParenImpCasts();
        }
      }
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Base);
        if ((DRE != null)) {
          HandleDeclRefExpr(DRE);
        }
      }
      return;
    }
    
    Visit(E);
  }

  
  // Reference types not handled in HandleValue are handled here since all
  // uses of references are bad, not just r-value uses.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9253,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    if (isReferenceType) {
      HandleDeclRefExpr(E);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9258,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker21VisitImplicitCastExprEPN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker21VisitImplicitCastExprEPN5clang16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    if (E.getCastKind() == CastKind.CK_LValueToRValue) {
      HandleValue(E.getSubExpr());
      return;
    }
    
    EvaluatedExprVisitor.super.VisitImplicitCastExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9267,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitMemberExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ E) {
    if (isInitList) {
      if (CheckInitListMemberExpr(E, true/*CheckReference*/)) {
        return;
      }
    }
    
    // Don't warn on arrays since they can be treated as pointers.
    if (E.getType().$arrow().canDecayToPointerType()) {
      return;
    }
    
    // Warn when a non-static method call is followed by non-static member
    // field accesses, which is followed by a DeclRefExpr.
    CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(E.getMemberDecl());
    boolean Warn = ((MD != null) && !MD.isStatic());
    Expr /*P*/ Base = E.getBase().IgnoreParenImpCasts();
    {
      MemberExpr /*P*/ ME;
      while (((/*P*/ ME = dyn_cast_MemberExpr(Base)) != null)) {
        if (!isa_FieldDecl(ME.getMemberDecl())) {
          Warn = false;
        }
        Base = ME.getBase().IgnoreParenImpCasts();
      }
    }
    {
      
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Base);
      if ((DRE != null)) {
        if (Warn) {
          HandleDeclRefExpr(DRE);
        }
        return;
      }
    }
    
    // The base of a MemberExpr is not a MemberExpr or a DeclRefExpr.
    // Visit that expression.
    Visit(Base);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9298,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitCXXOperatorCallExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker24VisitCXXOperatorCallExprEPN5clang19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker24VisitCXXOperatorCallExprEPN5clang19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(CXXOperatorCallExpr /*P*/ E) {
    Expr /*P*/ Callee = E.getCallee();
    if (isa_UnresolvedLookupExpr(Callee)) {
      EvaluatedExprVisitor.super.VisitCXXOperatorCallExpr(E);
      /*JAVA:return*/return;
    }
    
    Visit(Callee);
    for (Expr /*P*/ Arg : E.arguments())  {
      HandleValue(Arg.IgnoreParenImpCasts());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9309,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ E) {
    // For POD record types, addresses of its own members are well-defined.
    if (E.getOpcode() == UnaryOperatorKind.UO_AddrOf && isRecordType
       && isa_MemberExpr(E.getSubExpr().IgnoreParens())) {
      if (!isPODType) {
        HandleValue(E.getSubExpr());
      }
      return;
    }
    if (E.isIncrementDecrementOp()) {
      HandleValue(E.getSubExpr());
      return;
    }
    
    EvaluatedExprVisitor.super.VisitUnaryOperator(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9326,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9328,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    if (E.getConstructor().isCopyConstructor()) {
      Expr /*P*/ ArgExpr = E.getArg(0);
      {
        InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(ArgExpr);
        if ((ILE != null)) {
          if (ILE.getNumInits() == 1) {
            ArgExpr = ILE.getInit(0);
          }
        }
      }
      {
        ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(ArgExpr);
        if ((ICE != null)) {
          if (ICE.getCastKind() == CastKind.CK_NoOp) {
            ArgExpr = ICE.getSubExpr();
          }
        }
      }
      HandleValue(ArgExpr);
      return;
    }
    EvaluatedExprVisitor.super.VisitCXXConstructExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9343,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitCallExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ E) {
    // Treat std::move as a use.
    if (E.getNumArgs() == 1) {
      {
        FunctionDecl /*P*/ FD = E.getDirectCallee();
        if ((FD != null)) {
          if (FD.isInStdNamespace() && (FD.getIdentifier() != null)
             && FD.getIdentifier().isStr(/*KEEP_STR*/"move")) {
            HandleValue(E.getArg(0));
            return;
          }
        }
      }
    }
    
    EvaluatedExprVisitor.super.VisitCallExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9358,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ E) {
    if (E.isCompoundAssignmentOp()) {
      HandleValue(E.getLHS());
      Visit(E.getRHS());
      return;
    }
    
    EvaluatedExprVisitor.super.VisitBinaryOperator(E);
  }

  
  // A custom visitor for BinaryConditionalOperator is needed because the
  // regular visitor would check the condition and true expression separately
  // but both point to the same place giving duplicate diagnostics.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9371,
   FQN="(anonymous namespace)::SelfReferenceChecker::VisitBinaryConditionalOperator", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker30VisitBinaryConditionalOperatorEPN5clang25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker30VisitBinaryConditionalOperatorEPN5clang25BinaryConditionalOperatorE")
  //</editor-fold>
  public void VisitBinaryConditionalOperator(BinaryConditionalOperator /*P*/ E) {
    Visit(E.getCond());
    Visit(E.getFalseExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::HandleDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9376,
   FQN="(anonymous namespace)::SelfReferenceChecker::HandleDeclRefExpr", NM="_ZN12_GLOBAL__N_120SelfReferenceChecker17HandleDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceChecker17HandleDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void HandleDeclRefExpr(DeclRefExpr /*P*/ DRE) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Decl /*P*/ ReferenceDecl = DRE.getDecl();
      if (OrigDecl != ReferenceDecl) {
        return;
      }
      /*uint*/int _diag;
      if (isReferenceType) {
        _diag = diag.warn_uninit_self_reference_in_reference_init;
      } else if (cast_VarDecl(OrigDecl).isStaticLocal()) {
        _diag = diag.warn_static_self_reference_in_init;
      } else if (isa_TranslationUnitDecl(OrigDecl.getDeclContext())
         || isa_NamespaceDecl(OrigDecl.getDeclContext())
         || DRE.getDecl().getType().$arrow().isRecordType()) {
        _diag = diag.warn_uninit_self_reference_in_init;
      } else {
        // Local variables will be handled by the CFG analysis.
        return;
      }
      
      $c$.clean(S.DiagRuntimeBehavior(DRE.getLocStart(), DRE, 
          $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_DeclarationName($c$.track(S.PDiag(_diag)), 
                      DRE.getNameInfo().getName()), 
                  new SourceRange(OrigDecl.getLocation())), 
              DRE.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SelfReferenceChecker::~SelfReferenceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9094,
   FQN="(anonymous namespace)::SelfReferenceChecker::~SelfReferenceChecker", NM="_ZN12_GLOBAL__N_120SelfReferenceCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120SelfReferenceCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    InitFieldIndex.$destroy();
    EvaluatedExprVisitor.super.$destroy$EvaluatedExprVisitor();
    //END JDestroy
  }

  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", OrigDecl=" + OrigDecl // NOI18N
              + ", isRecordType=" + isRecordType // NOI18N
              + ", isPODType=" + isPODType // NOI18N
              + ", isReferenceType=" + isReferenceType // NOI18N
              + ", isInitList=" + isInitList // NOI18N
              + ", InitFieldIndex=" + InitFieldIndex // NOI18N
              + super.toString(); // NOI18N
  }
}
