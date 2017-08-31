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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5395,
 FQN="(anonymous namespace)::RecordExprEvaluator", NM="_ZN12_GLOBAL__N_119RecordExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluatorE")
//</editor-fold>
public class RecordExprEvaluator extends /*public*/ ExprEvaluatorBase<RecordExprEvaluator> {
  private final /*const*/ LValue /*&*/ This;
  private final APValue /*&*/ Result;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::RecordExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5401,
   FQN="(anonymous namespace)::RecordExprEvaluator::RecordExprEvaluator", NM="_ZN12_GLOBAL__N_119RecordExprEvaluatorC1ERNS_8EvalInfoERKNS_6LValueERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluatorC1ERNS_8EvalInfoERKNS_6LValueERN5clang7APValueE")
  //</editor-fold>
  public RecordExprEvaluator(final EvalInfo /*&*/ info, final /*const*/ LValue /*&*/ This, final APValue /*&*/ Result) {
    // : ExprEvaluatorBaseTy(info), This(This), Result(Result) 
    //START JInit
    super(info);
    this./*&*/This=/*&*/This;
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5404,
   FQN="(anonymous namespace)::RecordExprEvaluator::Success", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Result.$assign($c$.track(new APValue(V))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5408,
   FQN="(anonymous namespace)::RecordExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    return ZeroInitialization(E, E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5477,
   FQN="(anonymous namespace)::RecordExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator18ZeroInitializationEPKN5clang4ExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator18ZeroInitializationEPKN5clang4ExprENS1_8QualTypeE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E, QualType T) {
    /*const*/ RecordDecl /*P*/ RD = T.$arrow().castAs$RecordType().getDecl();
    if (RD.isInvalidDecl()) {
      return false;
    }
    if (RD.isUnion()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++11 [dcl.init]p5: If T is a (possibly cv-qualified) union type, the
        // object's first non-static named data member is zero-initialized
        specific_decl_iterator<FieldDecl> I = RD.field_begin();
        if ($eq_specific_decl_iterator$SpecificDecl$C(I, RD.field_end())) {
          $c$.clean(Result.$assign($c$.track(new APValue((/*const*/ FieldDecl /*P*/ )(/*const*/ FieldDecl /*P*/ )null))));
          return true;
        }
        
        LValue Subobject = new LValue(This);
        if (!HandleLValueMember(Info, E, Subobject, I.$star())) {
          return false;
        }
        $c$.clean(Result.$assign($c$.track(new APValue(I.$star()))));
        ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr(I.$arrow().getType());
        return EvaluateInPlace(Result.getUnionValue(), Info, Subobject, $AddrOf(VIE));
      } finally {
        $c$.$destroy();
      }
    }
    if (isa_CXXRecordDecl(RD) && (cast_CXXRecordDecl(RD).getNumVBases() != 0)) {
      Info.FFDiag(E, diag.note_constexpr_virtual_base).$out$T(RD);
      return false;
    }
    
    return HandleClassZeroInitialization(Info, E, RD, This, Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5413,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    return handleCallExpr(E, Result, $AddrOf(This));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5505,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_ConstructorConversion:
      return Visit(E.getSubExpr$Const());
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
      {
        APValue DerivedObject = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          DerivedObject/*J*/= new APValue();
          if (!Evaluate(DerivedObject, Info, E.getSubExpr$Const())) {
            return false;
          }
          if (!DerivedObject.isStruct()) {
            return Error(E.getSubExpr$Const());
          }
          
          // Derived-to-base rvalue conversion: just slice off the derived part.
          APValue /*P*/ Value = $AddrOf(DerivedObject);
          /*const*/ CXXRecordDecl /*P*/ RD = E.getSubExpr$Const().getType().$arrow().getAsCXXRecordDecl();
          for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathI = $tryClone(E.path_begin$Const()), 
              /*P*/ /*const*/ /*P*/ PathE = $tryClone(E.path_end$Const()); $noteq_ptr(PathI, PathE); PathI.$preInc()) {
            assert (!(PathI.$star()).isVirtual()) : "record rvalue with virtual base";
            /*const*/ CXXRecordDecl /*P*/ Base = (PathI.$star()).getType().$arrow().getAsCXXRecordDecl();
            Value = $AddrOf(Value.getStructBase(getBaseIndex(RD, Base)));
            RD = Base;
          }
          $c$.clean(Result.$assign($c$.track(new APValue($Deref(Value)))));
          return true;
        } finally {
          if (DerivedObject != null) { DerivedObject.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5537,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitInitListExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public boolean VisitInitListExpr(/*const*/ InitListExpr /*P*/ E) {
    /*const*/ RecordDecl /*P*/ RD = E.getType().$arrow().castAs$RecordType().getDecl();
    if (RD.isInvalidDecl()) {
      return false;
    }
    final /*const*/ ASTRecordLayout /*&*/ Layout = Info.Ctx.getASTRecordLayout(RD);
    if (RD.isUnion()) {
      ThisOverrideRAII ThisOverride = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ FieldDecl /*P*/ Field = E.getInitializedFieldInUnion$Const();
        $c$.clean(Result.$assign($c$.track(new APValue(Field))));
        if (!(Field != null)) {
          return true;
        }
        
        // If the initializer list for a union does not contain any elements, the
        // first element of the union is value-initialized.
        // FIXME: The element should be initialized from an initializer list.
        //        Is this difference ever observable for initializer lists which
        //        we don't build?
        ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr(Field.getType());
        /*const*/ Expr /*P*/ InitExpr = (E.getNumInits() != 0) ? E.getInit$Const(0) : $AddrOf(VIE);
        
        LValue Subobject = new LValue(This);
        if (!HandleLValueMember(Info, InitExpr, Subobject, Field, $AddrOf(Layout))) {
          return false;
        }
        
        // Temporarily override This, in case there's a CXXDefaultInitExpr in here.
        ThisOverride/*J*/= new ThisOverrideRAII($Deref(Info.CurrentCall), $AddrOf(This), 
            isa_CXXDefaultInitExpr(InitExpr));
        
        return EvaluateInPlace(Result.getUnionValue(), Info, Subobject, InitExpr);
      } finally {
        if (ThisOverride != null) { ThisOverride.$destroy(); }
        $c$.$destroy();
      }
    }
    
    /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
    if (Result.isUninit()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitStruct(), (CXXRD != null) ? CXXRD.getNumBases() : 0, 
                std.distance(RD.field_begin(), RD.field_end())))));
      } finally {
        $c$.$destroy();
      }
    }
    /*uint*/int ElementNo = 0;
    boolean Success = true;
    
    // Initialize base classes.
    if ((CXXRD != null)) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ Base : CXXRD.bases$Const()) {
        assert ($less_uint(ElementNo, E.getNumInits())) : "missing init for base class";
        /*const*/ Expr /*P*/ Init = E.getInit$Const(ElementNo);
        
        LValue Subobject = new LValue(This);
        if (!HandleLValueBase(Info, Init, Subobject, CXXRD, $AddrOf(Base))) {
          return false;
        }
        
        final APValue /*&*/ FieldVal = Result.getStructBase(ElementNo);
        if (!EvaluateInPlace(FieldVal, Info, Subobject, Init)) {
          if (!Info.noteFailure()) {
            return false;
          }
          Success = false;
        }
        ++ElementNo;
      }
    }
    
    // Initialize members.
    for (/*const*/ FieldDecl /*P*/ Field : RD.fields()) {
      ThisOverrideRAII ThisOverride = null;
      try {
        // Anonymous bit-fields are not considered members of the class for
        // purposes of aggregate initialization.
        if (Field.isUnnamedBitfield()) {
          continue;
        }
        
        LValue Subobject = new LValue(This);
        
        boolean HaveInit = $less_uint(ElementNo, E.getNumInits());
        
        // FIXME: Diagnostics here should point to the end of the initializer
        // list, not the start.
        if (!HandleLValueMember(Info, HaveInit ? E.getInit$Const(ElementNo) : E, 
            Subobject, Field, $AddrOf(Layout))) {
          return false;
        }
        
        // Perform an implicit value-initialization for members beyond the end of
        // the initializer list.
        ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr(HaveInit ? Info.Ctx.IntTy.$QualType() : Field.getType());
        /*const*/ Expr /*P*/ Init = HaveInit ? E.getInit$Const(ElementNo++) : $AddrOf(VIE);
        
        // Temporarily override This, in case there's a CXXDefaultInitExpr in here.
        ThisOverride/*J*/= new ThisOverrideRAII($Deref(Info.CurrentCall), $AddrOf(This), 
            isa_CXXDefaultInitExpr(Init));
        
        final APValue /*&*/ FieldVal = Result.getStructField(Field.getFieldIndex());
        if (!EvaluateInPlace(FieldVal, Info, Subobject, Init)
           || (Field.isBitField() && !truncateBitfieldValue(Info, Init, 
            FieldVal, Field))) {
          if (!Info.noteFailure()) {
            return false;
          }
          Success = false;
        }
      } finally {
        if (ThisOverride != null) { ThisOverride.$destroy(); }
      }
    }
    
    return Success;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5418,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public boolean VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E) {
    return VisitCXXConstructExpr(E, E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5678,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitCXXInheritedCtorInitExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator29VisitCXXInheritedCtorInitExprEPKN5clang24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator29VisitCXXInheritedCtorInitExprEPKN5clang24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public boolean VisitCXXInheritedCtorInitExpr(/*const*/ CXXInheritedCtorInitExpr /*P*/ E) {
    if (!(Info.CurrentCall != null)) {
      assert (Info.checkingPotentialConstantExpression());
      return false;
    }
    
    /*const*/ CXXConstructorDecl /*P*/ FD = E.getConstructor();
    if (FD.isInvalidDecl() || FD.getParent$Const().isInvalidDecl()) {
      return false;
    }
    
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$null$ref(null);
    Stmt /*P*/ Body = FD.getBody(Definition);
    if (!CheckConstexprFunction(Info, E.getExprLoc(), FD, Definition.$deref(), Body)) {
      return false;
    }
    
    return HandleConstructorCall(E, This, Info.CurrentCall.Arguments, 
        cast_CXXConstructorDecl(Definition.$deref()), Info, 
        Result);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5633,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprENS1_8QualTypeE")
  //</editor-fold>
  public boolean VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E, 
                       QualType T) {
    // Note that E's type is not necessarily the type of our class here; we might
    // be initializing an array element instead.
    /*const*/ CXXConstructorDecl /*P*/ FD = E.getConstructor();
    if (FD.isInvalidDecl() || FD.getParent$Const().isInvalidDecl()) {
      return false;
    }
    
    boolean ZeroInit = E.requiresZeroInitialization();
    if (CheckTrivialDefaultConstructor(Info, E.getExprLoc(), FD, ZeroInit)) {
      // If we've already performed zero-initialization, we're already done.
      if (!Result.isUninit()) {
        return true;
      }
      
      // We can get here in two different ways:
      //  1) We're performing value-initialization, and should zero-initialize
      //     the object, or
      //  2) We're performing default-initialization of an object with a trivial
      //     constexpr default constructor, in which case we should start the
      //     lifetimes of all the base subobjects (there can be no data member
      //     subobjects in this case) per [basic.life]p1.
      // Either way, ZeroInitialization is appropriate.
      return ZeroInitialization(E, new QualType(T));
    }
    
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$null$ref(null);
    Stmt /*P*/ Body = FD.getBody(Definition);
    if (!CheckConstexprFunction(Info, E.getExprLoc(), FD, Definition.$deref(), Body)) {
      return false;
    }
    
    // Avoid materializing a temporary for an elidable copy/move constructor.
    if (E.isElidable() && !ZeroInit) {
      {
        /*const*/ MaterializeTemporaryExpr /*P*/ ME = dyn_cast_MaterializeTemporaryExpr(E.getArg$Const(0));
        if ((ME != null)) {
          return Visit(ME.GetTemporaryExpr());
        }
      }
    }
    if (ZeroInit && !ZeroInitialization(E, new QualType(T))) {
      return false;
    }
    
    ArrayRef</*const*/ Expr /*P*/ > Args = llvm.makeArrayRef(E.getArgs$Const(), E.getNumArgs());
    return HandleConstructorCall(E, This, new ArrayRef</*const*/ Expr /*P*/ >(Args), 
        cast_CXXConstructorDecl(Definition.$deref()), Info, 
        Result);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExprEvaluator::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5700,
   FQN="(anonymous namespace)::RecordExprEvaluator::VisitCXXStdInitializerListExpr", NM="_ZN12_GLOBAL__N_119RecordExprEvaluator30VisitCXXStdInitializerListExprEPKN5clang25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119RecordExprEvaluator30VisitCXXStdInitializerListExprEPKN5clang25CXXStdInitializerListExprE")
  //</editor-fold>
  public boolean VisitCXXStdInitializerListExpr(/*const*/ CXXStdInitializerListExpr /*P*/ E) {
    LValue Array = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ConstantArrayType /*P*/ ArrayType = Info.Ctx.getAsConstantArrayType(E.getSubExpr$Const().getType());
      
      Array/*J*/= new LValue();
      if (!EvaluateLValue(E.getSubExpr$Const(), Array, Info)) {
        return false;
      }
      
      // Get a pointer to the first element of the array.
      Array.addArray(Info, E, ArrayType);
      
      // FIXME: Perform the checks on the field types in SemaInit.
      RecordDecl /*P*/ Record = E.getType().$arrow().castAs$RecordType().getDecl();
      specific_decl_iterator<FieldDecl> Field = Record.field_begin();
      if ($eq_specific_decl_iterator$SpecificDecl$C(Field, Record.field_end())) {
        return Error(E);
      }
      
      // Start pointer.
      if (!Field.$arrow().getType().$arrow().isPointerType()
         || !Info.Ctx.hasSameType(Field.$arrow().getType().$arrow().getPointeeType(), 
          ArrayType.getElementType())) {
        return Error(E);
      }
      
      // FIXME: What if the initializer_list type has base classes, etc?
      $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitStruct(), 0, 2))));
      Array.moveInto(Result.getStructField(0));
      if ($eq_specific_decl_iterator$SpecificDecl$C(Field.$preInc(), Record.field_end())) {
        return Error(E);
      }
      if (Field.$arrow().getType().$arrow().isPointerType()
         && Info.Ctx.hasSameType(Field.$arrow().getType().$arrow().getPointeeType(), 
          ArrayType.getElementType())) {
        // End pointer.
        if (!HandleLValueArrayAdjustment(Info, E, Array, 
            ArrayType.getElementType(), 
            ArrayType.getSize().getZExtValue())) {
          return false;
        }
        Array.moveInto(Result.getStructField(1));
      } else if (Info.Ctx.hasSameType(Field.$arrow().getType(), Info.Ctx.getSizeType().$QualType())) {
        // Length.
        $c$.clean(Result.getStructField(1).$assign($c$.track(new APValue(new APSInt(new APInt(ArrayType.getSize()))))));
      } else {
        return Error(E);
      }
      if ($noteq_specific_decl_iterator$SpecificDecl$C(Field.$preInc(), Record.field_end())) {
        return Error(E);
      }
      
      return true;
    } finally {
      if (Array != null) { Array.$destroy(); }
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "This=" + This // NOI18N
              + ", Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
