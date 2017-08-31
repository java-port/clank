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
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaExceptionSpecClangStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL14canCalleeThrowERNS_4SemaEPKNS_4ExprEPKNS_4DeclE;_ZN5clangL14canTypeidThrowERNS_4SemaEPKNS_13CXXTypeidExprE;_ZN5clangL16canSubExprsThrowERNS_4SemaEPKNS_4ExprE;_ZN5clangL19canDynamicCastThrowEPKNS_18CXXDynamicCastExprE;_ZN5clangL21GetUnderlyingFunctionENS_8QualTypeE;_ZN5clangL24hasImplicitExceptionSpecEPNS_12FunctionDeclE;_ZN5clangL27CheckSpecForTypesEquivalentERNS_4SemaERKNS_17PartialDiagnosticES4_NS_8QualTypeENS_14SourceLocationES5_S6_; -static-type=SemaExceptionSpecClangStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaExceptionSpecClangStatics {

//<editor-fold defaultstate="collapsed" desc="clang::GetUnderlyingFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 27,
 FQN="clang::GetUnderlyingFunction", NM="_ZN5clangL21GetUnderlyingFunctionENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL21GetUnderlyingFunctionENS_8QualTypeE")
//</editor-fold>
public static /*const*/ FunctionProtoType /*P*/ GetUnderlyingFunction(QualType T) {
  {
    /*const*/ PointerType /*P*/ PtrTy = T.$arrow().getAs(PointerType.class);
    if ((PtrTy != null)) {
      T.$assignMove(PtrTy.getPointeeType());
    } else {
      /*const*/ ReferenceType /*P*/ RefTy = T.$arrow().getAs(ReferenceType.class);
      if ((RefTy != null)) {
        T.$assignMove(RefTy.getPointeeType());
      } else {
        /*const*/ MemberPointerType /*P*/ MPTy = T.$arrow().getAs(MemberPointerType.class);
        if ((MPTy != null)) {
          T.$assignMove(MPTy.getPointeeType());
        }
      }
    }
  }
  return T.$arrow().getAs(FunctionProtoType.class);
}


/// Determine whether a function has an implicitly-generated exception
/// specification.
//<editor-fold defaultstate="collapsed" desc="clang::hasImplicitExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 193,
 FQN="clang::hasImplicitExceptionSpec", NM="_ZN5clangL24hasImplicitExceptionSpecEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL24hasImplicitExceptionSpecEPNS_12FunctionDeclE")
//</editor-fold>
public static boolean hasImplicitExceptionSpec(FunctionDecl /*P*/ Decl) {
  if (!isa_CXXDestructorDecl(Decl)
     && Decl.getDeclName().getCXXOverloadedOperator() != OverloadedOperatorKind.OO_Delete
     && Decl.getDeclName().getCXXOverloadedOperator() != OverloadedOperatorKind.OO_Array_Delete) {
    return false;
  }
  
  // For a function that the user didn't declare:
  //  - if this is a destructor, its exception specification is implicit.
  //  - if this is 'operator delete' or 'operator delete[]', the exception
  //    specification is as-if an explicit exception specification was given
  //    (per [basic.stc.dynamic]p2).
  if (!(Decl.getTypeSourceInfo() != null)) {
    return isa_CXXDestructorDecl(Decl);
  }
  
  /*const*/ FunctionProtoType /*P*/ Ty = Decl.getTypeSourceInfo().getType().$arrow().getAs(FunctionProtoType.class);
  return !Ty.hasExceptionSpec();
}

//<editor-fold defaultstate="collapsed" desc="clang::CheckSpecForTypesEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 757,
 FQN="clang::CheckSpecForTypesEquivalent", NM="_ZN5clangL27CheckSpecForTypesEquivalentERNS_4SemaERKNS_17PartialDiagnosticES4_NS_8QualTypeENS_14SourceLocationES5_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL27CheckSpecForTypesEquivalentERNS_4SemaERKNS_17PartialDiagnosticES4_NS_8QualTypeENS_14SourceLocationES5_S6_")
//</editor-fold>
public static boolean CheckSpecForTypesEquivalent(final Sema /*&*/ S, 
                           final /*const*/ PartialDiagnostic /*&*/ DiagID, final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                           QualType Target, SourceLocation TargetLoc, 
                           QualType Source, SourceLocation SourceLoc) {
  /*const*/ FunctionProtoType /*P*/ TFunc = GetUnderlyingFunction(new QualType(Target));
  if (!(TFunc != null)) {
    return false;
  }
  /*const*/ FunctionProtoType /*P*/ SFunc = GetUnderlyingFunction(new QualType(Source));
  if (!(SFunc != null)) {
    return false;
  }
  
  return S.CheckEquivalentExceptionSpec(DiagID, NoteID, TFunc, new SourceLocation(TargetLoc), 
      SFunc, new SourceLocation(SourceLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::canSubExprsThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 871,
 FQN="clang::canSubExprsThrow", NM="_ZN5clangL16canSubExprsThrowERNS_4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL16canSubExprsThrowERNS_4SemaEPKNS_4ExprE")
//</editor-fold>
public static CanThrowResult canSubExprsThrow(final Sema /*&*/ S, /*const*/ Expr /*P*/ E) {
  CanThrowResult R = CanThrowResult.CT_Cannot;
  for (/*const*/ Stmt /*P*/ SubStmt : E.children$Const()) {
    R = mergeCanThrow(R, S.canThrow(cast_Expr(SubStmt)));
    if (R == CanThrowResult.CT_Can) {
      break;
    }
  }
  return R;
}

//<editor-fold defaultstate="collapsed" desc="clang::canCalleeThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 881,
 FQN="clang::canCalleeThrow", NM="_ZN5clangL14canCalleeThrowERNS_4SemaEPKNS_4ExprEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL14canCalleeThrowERNS_4SemaEPKNS_4ExprEPKNS_4DeclE")
//</editor-fold>
public static CanThrowResult canCalleeThrow(final Sema /*&*/ S, /*const*/ Expr /*P*/ E, /*const*/ Decl /*P*/ D) {
  assert ((D != null)) : "Expected decl";
  
  // See if we can get a function type from the decl somehow.
  /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
  if (!(VD != null)) { // If we have no clue what we're calling, assume the worst.
    return CanThrowResult.CT_Can;
  }
  
  // As an extension, we assume that __attribute__((nothrow)) functions don't
  // throw.
  if (isa_FunctionDecl(D) && D.hasAttr(NoThrowAttr.class)) {
    return CanThrowResult.CT_Cannot;
  }
  
  QualType T = VD.getType();
  /*const*/ FunctionProtoType /*P*/ FT;
  if (((FT = T.$arrow().getAs(FunctionProtoType.class)) != null)) {
  } else {
    /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      FT = PT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
    } else {
      /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
      if ((RT != null)) {
        FT = RT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
      } else {
        /*const*/ MemberPointerType /*P*/ MT = T.$arrow().getAs(MemberPointerType.class);
        if ((MT != null)) {
          FT = MT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
        } else {
          /*const*/ BlockPointerType /*P*/ BT = T.$arrow().getAs(BlockPointerType.class);
          if ((BT != null)) {
            FT = BT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
          }
        }
      }
    }
  }
  if (!(FT != null)) {
    return CanThrowResult.CT_Can;
  }
  
  FT = S.ResolveExceptionSpec(E.getLocStart(), FT);
  if (!(FT != null)) {
    return CanThrowResult.CT_Can;
  }
  
  return FT.isNothrow(S.Context) ? CanThrowResult.CT_Cannot : CanThrowResult.CT_Can;
}

//<editor-fold defaultstate="collapsed" desc="clang::canDynamicCastThrow">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 916,
 FQN="clang::canDynamicCastThrow", NM="_ZN5clangL19canDynamicCastThrowEPKNS_18CXXDynamicCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL19canDynamicCastThrowEPKNS_18CXXDynamicCastExprE")
//</editor-fold>
public static CanThrowResult canDynamicCastThrow(/*const*/ CXXDynamicCastExpr /*P*/ DC) {
  if (DC.isTypeDependent()) {
    return CanThrowResult.CT_Dependent;
  }
  if (!DC.getTypeAsWritten().$arrow().isReferenceType()) {
    return CanThrowResult.CT_Cannot;
  }
  if (DC.getSubExpr$Const().isTypeDependent()) {
    return CanThrowResult.CT_Dependent;
  }
  
  return DC.getCastKind() == CastKind.CK_Dynamic ? CanThrowResult.CT_Can : CanThrowResult.CT_Cannot;
}

//<editor-fold defaultstate="collapsed" desc="clang::canTypeidThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 929,
 FQN="clang::canTypeidThrow", NM="_ZN5clangL14canTypeidThrowERNS_4SemaEPKNS_13CXXTypeidExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL14canTypeidThrowERNS_4SemaEPKNS_13CXXTypeidExprE")
//</editor-fold>
public static CanThrowResult canTypeidThrow(final Sema /*&*/ S, /*const*/ CXXTypeidExpr /*P*/ DC) {
  if (DC.isTypeOperand()) {
    return CanThrowResult.CT_Cannot;
  }
  
  Expr /*P*/ Op = DC.getExprOperand();
  if (Op.isTypeDependent()) {
    return CanThrowResult.CT_Dependent;
  }
  
  /*const*/ RecordType /*P*/ RT = Op.getType().$arrow().<RecordType>getAs$RecordType();
  if (!(RT != null)) {
    return CanThrowResult.CT_Cannot;
  }
  if (!cast_CXXRecordDecl(RT.getDecl()).isPolymorphic()) {
    return CanThrowResult.CT_Cannot;
  }
  if (Op.Classify(S.Context).isPRValue()) {
    return CanThrowResult.CT_Cannot;
  }
  
  return CanThrowResult.CT_Can;
}

} // END OF class SemaExceptionSpecClangStatics
