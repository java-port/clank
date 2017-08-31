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
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2273,
 FQN="(anonymous namespace)::UninitializedFieldVisitor", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitorE")
//</editor-fold>
public class UninitializedFieldVisitor implements /*public*/ EvaluatedExprVisitor<UninitializedFieldVisitor>, Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  // List of Decls to generate a warning on.  Also remove Decls that become
  // initialized.
  private final SmallPtrSetImpl<ValueDecl /*P*/ > /*&*/ Decls;
  // List of base classes of the record.  Classes are removed after their
  // initializers.
  private final SmallPtrSetImpl<QualType> /*&*/ BaseClasses;
  // Vector of decls to be removed from the Decl set prior to visiting the
  // nodes.  These Decls may have been initialized in the prior initializer.
  private SmallVector<ValueDecl /*P*/ > DeclsToRemove;
  // If non-null, add a note to the warning pointing back to the constructor.
  private /*const*/ CXXConstructorDecl /*P*/ Constructor;
  // Variables to hold state when processing an initializer list.  When
  // InitList is true, special case initialization of FieldDecls matching
  // InitListFieldDecl.
  private boolean InitList;
  private FieldDecl /*P*/ InitListFieldDecl;
  private SmallVectorUInt InitFieldIndex;
/*public:*/
  /*typedef EvaluatedExprVisitor<UninitializedFieldVisitor> Inherited*/
//  public final class Inherited extends EvaluatedExprVisitor<UninitializedFieldVisitor>{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::UninitializedFieldVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2296,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::UninitializedFieldVisitor", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitorC1ERN5clang4SemaERN4llvm15SmallPtrSetImplIPNS1_9ValueDeclEEERNS5_INS1_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitorC1ERN5clang4SemaERN4llvm15SmallPtrSetImplIPNS1_9ValueDeclEEERNS5_INS1_8QualTypeEEE")
  //</editor-fold>
  public UninitializedFieldVisitor(final Sema /*&*/ S, 
      final SmallPtrSetImpl<ValueDecl /*P*/ > /*&*/ Decls, 
      final SmallPtrSetImpl<QualType> /*&*/ BaseClasses) {
    // : Inherited(S.Context), S(S), Decls(Decls), BaseClasses(BaseClasses), DeclsToRemove(), Constructor(null), InitList(false), InitListFieldDecl(null), InitFieldIndex() 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this./*&*/S=/*&*/S;
    this./*&*/Decls=/*&*/Decls;
    this./*&*/BaseClasses=/*&*/BaseClasses;
    this.DeclsToRemove = new SmallVector<ValueDecl /*P*/ >(4, (ValueDecl /*P*/ )null);
    this.Constructor = null;
    this.InitList = false;
    this.InitListFieldDecl = null;
    this.InitFieldIndex = new SmallVectorUInt(4, 0);
    //END JInit
  }

  
  // Returns true if the use of ME is not an uninitialized use.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::IsInitListMemberExprInitialized">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2303,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::IsInitListMemberExprInitialized", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor31IsInitListMemberExprInitializedEPN5clang10MemberExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor31IsInitListMemberExprInitializedEPN5clang10MemberExprEb")
  //</editor-fold>
  public boolean IsInitListMemberExprInitialized(MemberExpr /*P*/ ME, 
                                 boolean CheckReferenceOnly) {
    SmallVector<FieldDecl /*P*/ > Fields/*J*/= new SmallVector<FieldDecl /*P*/ >(4, (FieldDecl /*P*/ )null);
    boolean ReferenceField = false;
    while ((ME != null)) {
      FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ME.getMemberDecl());
      if (!(FD != null)) {
        return false;
      }
      Fields.push_back(FD);
      if (FD.getType().$arrow().isReferenceType()) {
        ReferenceField = true;
      }
      ME = dyn_cast_MemberExpr(ME.getBase().IgnoreParenImpCasts());
    }
    
    // Binding a reference to an unintialized field is not an
    // uninitialized use.
    if (CheckReferenceOnly && !ReferenceField) {
      return true;
    }
    
    SmallVectorUInt UsedFieldIndex/*J*/= new SmallVectorUInt(4, 0);
    // Discard the first field since it is the field decl that is being
    // initialized.
    for (reverse_iterator<FieldDecl /*P*/ /*P*/ > I = Fields.rbegin().$add(1), E = Fields.rend(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      UsedFieldIndex.push_back((I.$star()).getFieldIndex());
    }
    
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
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::HandleMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2343,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::HandleMemberExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor16HandleMemberExprEPN5clang10MemberExprEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor16HandleMemberExprEPN5clang10MemberExprEbb")
  //</editor-fold>
  public void HandleMemberExpr(MemberExpr /*P*/ ME, boolean CheckReferenceOnly, 
                  boolean AddressOf) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (isa_EnumConstantDecl(ME.getMemberDecl())) {
        return;
      }
      
      // FieldME is the inner-most MemberExpr that is not an anonymous struct
      // or union.
      MemberExpr /*P*/ FieldME = ME;
      
      boolean AllPODFields = FieldME.getType().isPODType(S.Context);
      
      Expr /*P*/ Base = ME;
      {
        MemberExpr /*P*/ SubME;
        while (((/*P*/ SubME = dyn_cast_MemberExpr(Base.IgnoreParenImpCasts())) != null)) {
          if (isa_VarDecl(SubME.getMemberDecl())) {
            return;
          }
          {
            
            FieldDecl /*P*/ FD = dyn_cast_FieldDecl(SubME.getMemberDecl());
            if ((FD != null)) {
              if (!FD.isAnonymousStructOrUnion()) {
                FieldME = SubME;
              }
            }
          }
          if (!FieldME.getType().isPODType(S.Context)) {
            AllPODFields = false;
          }
          
          Base = SubME.getBase();
        }
      }
      if (!isa_CXXThisExpr(Base.IgnoreParenImpCasts())) {
        return;
      }
      if (AddressOf && AllPODFields) {
        return;
      }
      
      ValueDecl /*P*/ FoundVD = FieldME.getMemberDecl();
      {
        
        ImplicitCastExpr /*P*/ BaseCast = dyn_cast_ImplicitCastExpr(Base);
        if ((BaseCast != null)) {
          while (isa_ImplicitCastExpr(BaseCast.getSubExpr())) {
            BaseCast = cast_ImplicitCastExpr(BaseCast.getSubExpr());
          }
          if (BaseCast.getCastKind() == CastKind.CK_UncheckedDerivedToBase) {
            QualType T = BaseCast.getType();
            if (T.$arrow().isPointerType()
               && (BaseClasses.count(T.$arrow().getPointeeType()) != 0)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FieldME.getExprLoc(), diag.warn_base_class_is_uninit)), 
                      T.$arrow().getPointeeType()), FoundVD));
            }
          }
        }
      }
      if (!(Decls.count(FoundVD) != 0)) {
        return;
      }
      
      /*const*/boolean IsReference = FoundVD.getType().$arrow().isReferenceType();
      if (InitList && !AddressOf && FoundVD == InitListFieldDecl) {
        // Special checking for initializer lists.
        if (IsInitListMemberExprInitialized(ME, CheckReferenceOnly)) {
          return;
        }
      } else {
        // Prevent double warnings on use of unbounded references.
        if (CheckReferenceOnly && !IsReference) {
          return;
        }
      }
      
      /*uint*/int _diag = IsReference ? diag.warn_reference_field_is_uninit : diag.warn_field_is_uninit;
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FieldME.getExprLoc(), _diag)), FoundVD));
      if ((Constructor != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Constructor.getLocation(), 
                diag.note_uninit_in_this_constructor)), 
            (Constructor.isDefaultConstructor() && Constructor.isImplicit())));
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::HandleValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2421,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::HandleValue", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor11HandleValueEPN5clang4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor11HandleValueEPN5clang4ExprEb")
  //</editor-fold>
  public void HandleValue(Expr /*P*/ E, boolean AddressOf) {
    E = E.IgnoreParens();
    {
      
      MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
      if ((ME != null)) {
        HandleMemberExpr(ME, false/*CheckReferenceOnly*/, 
            AddressOf/*AddressOf*/);
        return;
      }
    }
    {
      
      ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
      if ((CO != null)) {
        Visit(CO.getCond());
        HandleValue(CO.getTrueExpr(), AddressOf);
        HandleValue(CO.getFalseExpr(), AddressOf);
        return;
      }
    }
    {
      
      BinaryConditionalOperator /*P*/ BCO = dyn_cast_BinaryConditionalOperator(E);
      if ((BCO != null)) {
        Visit(BCO.getCond());
        HandleValue(BCO.getFalseExpr(), AddressOf);
        return;
      }
    }
    {
      
      OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
      if ((OVE != null)) {
        HandleValue(OVE.getSourceExpr(), AddressOf);
        return;
      }
    }
    {
      
      BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
      if ((BO != null)) {
        switch (BO.getOpcode()) {
         default:
          break;
         case BO_PtrMemD:
         case BO_PtrMemI:
          HandleValue(BO.getLHS(), AddressOf);
          Visit(BO.getRHS());
          return;
         case BO_Comma:
          Visit(BO.getLHS());
          HandleValue(BO.getRHS(), AddressOf);
          return;
        }
      }
    }
    
    Visit(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::CheckInitListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2468,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::CheckInitListExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor17CheckInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor17CheckInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public void CheckInitListExpr(InitListExpr /*P*/ ILE) {
    InitFieldIndex.push_back(0);
    for (Stmt /*P*/ Child : ILE.children()) {
      {
        InitListExpr /*P*/ SubList = dyn_cast_InitListExpr(Child);
        if ((SubList != null)) {
          CheckInitListExpr(SubList);
        } else {
          Visit(Child);
        }
      }
      /*++*/InitFieldIndex./*back()*/ref$back().$set$preInc();
    }
    InitFieldIndex.pop_back();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::CheckInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2481,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::CheckInitializer", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor16CheckInitializerEPN5clang4ExprEPKNS1_18CXXConstructorDeclEPNS1_9FieldDeclEPKNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor16CheckInitializerEPN5clang4ExprEPKNS1_18CXXConstructorDeclEPNS1_9FieldDeclEPKNS1_4TypeE")
  //</editor-fold>
  public void CheckInitializer(Expr /*P*/ E, /*const*/ CXXConstructorDecl /*P*/ FieldConstructor, 
                  FieldDecl /*P*/ Field, /*const*/ Type /*P*/ BaseClass) {
    // Remove Decls that may have been initialized in the previous
    // initializer.
    for (ValueDecl /*P*/ VD : DeclsToRemove)  {
      Decls.erase(VD);
    }
    DeclsToRemove.clear();
    
    Constructor = FieldConstructor;
    InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(E);
    if ((ILE != null) && (Field != null)) {
      InitList = true;
      InitListFieldDecl = Field;
      InitFieldIndex.clear();
      CheckInitListExpr(ILE);
    } else {
      InitList = false;
      Visit(E);
    }
    if ((Field != null)) {
      Decls.erase(Field);
    }
    if ((BaseClass != null)) {
      BaseClasses.erase(BaseClass.getCanonicalTypeInternal());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2508,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitMemberExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ ME) {
    // All uses of unbounded reference fields will warn.
    HandleMemberExpr(ME, true/*CheckReferenceOnly*/, false/*AddressOf*/);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2513,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor21VisitImplicitCastExprEPN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor21VisitImplicitCastExprEPN5clang16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    if (E.getCastKind() == CastKind.CK_LValueToRValue) {
      HandleValue(E.getSubExpr(), false/*AddressOf*/);
      return;
    }
    
    EvaluatedExprVisitor.super.VisitImplicitCastExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2522,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
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
      HandleValue(ArgExpr, false/*AddressOf*/);
      return;
    }
    EvaluatedExprVisitor.super.VisitCXXConstructExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2537,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitCXXMemberCallExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor22VisitCXXMemberCallExprEPN5clang17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor22VisitCXXMemberCallExprEPN5clang17CXXMemberCallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(CXXMemberCallExpr /*P*/ E) {
    Expr /*P*/ Callee = E.getCallee();
    if (isa_MemberExpr(Callee)) {
      HandleValue(Callee, false/*AddressOf*/);
      for (Expr /*P*/ Arg : E.arguments())  {
        Visit(Arg);
      }
      return;
    }
    
    EvaluatedExprVisitor.super.VisitCXXMemberCallExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2549,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitCallExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ E) {
    // Treat std::move as a use.
    if (E.getNumArgs() == 1) {
      {
        FunctionDecl /*P*/ FD = E.getDirectCallee();
        if ((FD != null)) {
          if (FD.isInStdNamespace() && (FD.getIdentifier() != null)
             && FD.getIdentifier().isStr(/*KEEP_STR*/"move")) {
            HandleValue(E.getArg(0), false/*AddressOf*/);
            return;
          }
        }
      }
    }
    
    EvaluatedExprVisitor.super.VisitCallExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2564,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitCXXOperatorCallExpr", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor24VisitCXXOperatorCallExprEPN5clang19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor24VisitCXXOperatorCallExprEPN5clang19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(CXXOperatorCallExpr /*P*/ E) {
    Expr /*P*/ Callee = E.getCallee();
    if (isa_UnresolvedLookupExpr(Callee)) {
      EvaluatedExprVisitor.super.VisitCXXOperatorCallExpr(E);
      /*JAVA:return*/return;
    }
    
    Visit(Callee);
    for (Expr /*P*/ Arg : E.arguments())  {
      HandleValue(Arg.IgnoreParenImpCasts(), false/*AddressOf*/);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2575,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ E) {
    // If a field assignment is detected, remove the field from the
    // uninitiailized field set.
    if (E.getOpcode() == BinaryOperatorKind.BO_Assign) {
      {
        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E.getLHS());
        if ((ME != null)) {
          {
            FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ME.getMemberDecl());
            if ((FD != null)) {
              if (!FD.getType().$arrow().isReferenceType()) {
                DeclsToRemove.push_back(FD);
              }
            }
          }
        }
      }
    }
    if (E.isCompoundAssignmentOp()) {
      HandleValue(E.getLHS(), false/*AddressOf*/);
      Visit(E.getRHS());
      return;
    }
    
    EvaluatedExprVisitor.super.VisitBinaryOperator(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2593,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitor18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitor18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ E) {
    if (E.isIncrementDecrementOp()) {
      HandleValue(E.getSubExpr(), false/*AddressOf*/);
      return;
    }
    if (E.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
      {
        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E.getSubExpr());
        if ((ME != null)) {
          HandleValue(ME.getBase(), true/*AddressOf*/);
          return;
        }
      }
    }
    
    EvaluatedExprVisitor.super.VisitUnaryOperator(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitializedFieldVisitor::~UninitializedFieldVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2273,
   FQN="(anonymous namespace)::UninitializedFieldVisitor::~UninitializedFieldVisitor", NM="_ZN12_GLOBAL__N_125UninitializedFieldVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125UninitializedFieldVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    InitFieldIndex.$destroy();
    DeclsToRemove.$destroy();
    EvaluatedExprVisitor.super.$destroy$EvaluatedExprVisitor();
    //END JDestroy
  }

  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Decls=" + Decls // NOI18N
              + ", BaseClasses=" + BaseClasses // NOI18N
              + ", DeclsToRemove=" + DeclsToRemove // NOI18N
              + ", Constructor=" + Constructor // NOI18N
              + ", InitList=" + InitList // NOI18N
              + ", InitListFieldDecl=" + InitListFieldDecl // NOI18N
              + ", InitFieldIndex=" + InitFieldIndex // NOI18N
              + super.toString(); // NOI18N
  }
}
