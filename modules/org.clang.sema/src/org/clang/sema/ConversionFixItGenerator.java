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

package org.clang.sema;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// The class facilities generation and storage of conversion FixIts. Hints for
/// new conversions are added using TryToFixConversion method. The default type
/// conversion checker can be reset.
//<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 33,
 FQN="clang::ConversionFixItGenerator", NM="_ZN5clang24ConversionFixItGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGeneratorE")
//</editor-fold>
public class/*struct*/ ConversionFixItGenerator implements Destructors.ClassWithDestructor, NativePOD<ConversionFixItGenerator> {
  /// Performs a simple check to see if From type can be converted to To type.
  /// Performs a simple check to see if From type can be converted to To type.
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::compareTypesSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp", line = 23,
   FQN="clang::ConversionFixItGenerator::compareTypesSimple", NM="_ZN5clang24ConversionFixItGenerator18compareTypesSimpleENS_7CanQualINS_4TypeEEES3_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZN5clang24ConversionFixItGenerator18compareTypesSimpleENS_7CanQualINS_4TypeEEES3_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindE")
  //</editor-fold>
  public static boolean compareTypesSimple(CanQual<Type> From, 
                    CanQual<Type> To, 
                    final Sema /*&*/ S, 
                    SourceLocation Loc, 
                    ExprValueKind FromVK) {
    if (!To.isAtLeastAsQualifiedAs(new CanQual<Type>(From))) {
      return false;
    }
    
    From.$assignMove(From.getNonReferenceType());
    To.$assignMove(To.getNonReferenceType());
    
    // If both are pointer types, work with the pointee types.
    if (isa_PointerType(From.getTypePtr()) && isa_PointerType(To.getTypePtr())) {
      From.$assignMove(S.Context.getCanonicalType((cast_PointerType(From.getTypePtr())).getPointeeType()));
      To.$assignMove(S.Context.getCanonicalType((cast_PointerType(To.getTypePtr())).getPointeeType()));
    }
    
    /*const*/ CanQual<Type> FromUnq = From.getUnqualifiedType();
    /*const*/ CanQual<Type> ToUnq = To.getUnqualifiedType();
    if (($eq_CanQual$T_CanQual$U(/*NO_COPY*/FromUnq, /*NO_COPY*/ToUnq) || (S.IsDerivedFrom(new SourceLocation(Loc), FromUnq.$QualType(), ToUnq.$QualType())))
       && To.isAtLeastAsQualifiedAs(new CanQual<Type>(From))) {
      return true;
    }
    return false;
  }


  
  /// The list of Hints generated so far.
  public std.vector<FixItHint> Hints;
  
  /// The number of Conversions fixed. This can be different from the size
  /// of the Hints vector since we allow multiple FixIts per conversion.
  public /*uint*/int NumConversionsFixed;
  
  /// The type of fix applied. If multiple conversions are fixed, corresponds
  /// to the kid of the very first conversion.
  public OverloadFixItKind Kind;
  
  /*typedef bool (*TypeComparisonFuncTy)(const CanQualType, const CanQualType, Sema &, SourceLocation, ExprValueKind)*/;
  /// The type comparison function used to decide if expression FromExpr of
  /// type FromTy can be converted to ToTy. For example, one could check if
  /// an implicit conversion exists. Returns true if comparison exists.
  public TypeComparisonFuncTy CompareTypes;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::ConversionFixItGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 62,
   FQN="clang::ConversionFixItGenerator::ConversionFixItGenerator", NM="_ZN5clang24ConversionFixItGeneratorC1EPFbNS_7CanQualINS_4TypeEEES3_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGeneratorC1EPFbNS_7CanQualINS_4TypeEEES3_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindEE")
  //</editor-fold>
  public ConversionFixItGenerator(TypeComparisonFuncTy Foo) {
    // : Hints(), NumConversionsFixed(0), Kind(OFIK_Undefined), CompareTypes(Foo) 
    //START JInit
    this.Hints = new std.vector<FixItHint>(new FixItHint());
    this.NumConversionsFixed = 0;
    this.Kind = OverloadFixItKind.OFIK_Undefined;
    this.CompareTypes = $tryClone(Foo);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::ConversionFixItGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 66,
   FQN="clang::ConversionFixItGenerator::ConversionFixItGenerator", NM="_ZN5clang24ConversionFixItGeneratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGeneratorC1Ev")
  //</editor-fold>
  public ConversionFixItGenerator() {
    // : Hints(), NumConversionsFixed(0), Kind(OFIK_Undefined), CompareTypes(compareTypesSimple) 
    //START JInit
    this.Hints = new std.vector<FixItHint>(new FixItHint());
    this.NumConversionsFixed = 0;
    this.Kind = OverloadFixItKind.OFIK_Undefined;
    this.CompareTypes = ConversionFixItGenerator::compareTypesSimple;
    //END JInit
  }

  
  /// Resets the default conversion checker method.
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::setConversionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 71,
   FQN="clang::ConversionFixItGenerator::setConversionChecker", NM="_ZN5clang24ConversionFixItGenerator20setConversionCheckerEPFbNS_7CanQualINS_4TypeEEES3_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGenerator20setConversionCheckerEPFbNS_7CanQualINS_4TypeEEES3_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindEE")
  //</editor-fold>
  public void setConversionChecker(TypeComparisonFuncTy Foo) {
    CompareTypes = $tryClone(Foo);
  }

  
  /// If possible, generates and stores a fix for the given conversion.
  
  /// If possible, generates and stores a fix for the given conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::tryToFixConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp", line = 51,
   FQN="clang::ConversionFixItGenerator::tryToFixConversion", NM="_ZN5clang24ConversionFixItGenerator18tryToFixConversionEPKNS_4ExprENS_8QualTypeES4_RNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZN5clang24ConversionFixItGenerator18tryToFixConversionEPKNS_4ExprENS_8QualTypeES4_RNS_4SemaE")
  //</editor-fold>
  public boolean tryToFixConversion(/*const*/ Expr /*P*/ FullExpr, 
                    /*const*/ QualType FromTy, 
                    /*const*/ QualType ToTy, 
                    final Sema /*&*/ S) {
    if (!(FullExpr != null)) {
      return false;
    }
    
    /*const*/ CanQual<Type> FromQTy = S.Context.getCanonicalType(new QualType(FromTy));
    /*const*/ CanQual<Type> ToQTy = S.Context.getCanonicalType(new QualType(ToTy));
    /*const*/ SourceLocation Begin = FullExpr.getSourceRange().getBegin();
    /*const*/ SourceLocation End = S.getLocForEndOfToken(FullExpr.getSourceRange().
            getEnd());
    
    // Strip the implicit casts - those are implied by the compiler, not the
    // original source code.
    /*const*/ Expr /*P*/ _Expr = FullExpr.IgnoreImpCasts$Const();
    
    boolean NeedParen = true;
    if (isa_ArraySubscriptExpr(_Expr)
       || isa_CallExpr(_Expr)
       || isa_DeclRefExpr(_Expr)
       || isa_CastExpr(_Expr)
       || isa_CXXNewExpr(_Expr)
       || isa_CXXConstructExpr(_Expr)
       || isa_CXXDeleteExpr(_Expr)
       || isa_CXXNoexceptExpr(_Expr)
       || isa_CXXPseudoDestructorExpr(_Expr)
       || isa_CXXScalarValueInitExpr(_Expr)
       || isa_CXXThisExpr(_Expr)
       || isa_CXXTypeidExpr(_Expr)
       || isa_CXXUnresolvedConstructExpr(_Expr)
       || isa_ObjCMessageExpr(_Expr)
       || isa_ObjCPropertyRefExpr(_Expr)
       || isa_ObjCProtocolExpr(_Expr)
       || isa_MemberExpr(_Expr)
       || isa_ParenExpr(FullExpr)
       || isa_ParenListExpr(_Expr)
       || isa_SizeOfPackExpr(_Expr)
       || isa_UnaryOperator(_Expr)) {
      NeedParen = false;
    }
    {
      
      // Check if the argument needs to be dereferenced:
      //   (type * -> type) or (type * -> type &).
      /*const*/ PointerType /*P*/ FromPtrTy = dyn_cast_PointerType(FromQTy.getTypePtr());
      if ((FromPtrTy != null)) {
        OverloadFixItKind FixKind = OverloadFixItKind.OFIK_Dereference;
        
        boolean CanConvert = CompareTypes.$call(S.Context.getCanonicalType(FromPtrTy.getPointeeType()), new CanQual<Type>(ToQTy), 
            S, new SourceLocation(Begin), ExprValueKind.VK_LValue);
        if (CanConvert) {
          final Expr.NullPointerConstantKind nullPointerConstant = _Expr.IgnoreParenCasts$Const().
                  isNullPointerConstant(S.Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull);
          // Do not suggest dereferencing a Null pointer.
          if ((nullPointerConstant.getValue() != 0)) {
            return false;
          }
          {
            
            /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(_Expr);
            if ((UO != null)) {
              if (UO.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
                FixKind = OverloadFixItKind.OFIK_RemoveTakeAddress;
                Hints.push_back_T$RR(FixItHint.CreateRemoval(CharSourceRange.getTokenRange(/*NO_COPY*/Begin, /*NO_COPY*/Begin)));
              }
            } else if (NeedParen) {
              Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/Begin, new StringRef(/*KEEP_STR*/"*(")));
              Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/End, new StringRef(/*KEEP_STR*/$RPAREN)));
            } else {
              Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/Begin, new StringRef(/*KEEP_STR*/$STAR)));
            }
          }
          
          NumConversionsFixed++;
          if (NumConversionsFixed == 1) {
            Kind = FixKind;
          }
          return true;
        }
      }
    }
    
    // Check if the pointer to the argument needs to be passed:
    //   (type -> type *) or (type & -> type *).
    if (isa_PointerType(ToQTy.getTypePtr())) {
      boolean CanConvert = false;
      OverloadFixItKind FixKind = OverloadFixItKind.OFIK_TakeAddress;
      
      // Only suggest taking address of L-values.
      if (!_Expr.isLValue() || _Expr.getObjectKind() != ExprObjectKind.OK_Ordinary) {
        return false;
      }
      
      CanConvert = CompareTypes.$call(S.Context.getPointerType(new CanQual<Type>(FromQTy)), new CanQual<Type>(ToQTy), 
          S, new SourceLocation(Begin), ExprValueKind.VK_RValue);
      if (CanConvert) {
        {
          
          /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(_Expr);
          if ((UO != null)) {
            if (UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
              FixKind = OverloadFixItKind.OFIK_RemoveDereference;
              Hints.push_back_T$RR(FixItHint.CreateRemoval(CharSourceRange.getTokenRange(/*NO_COPY*/Begin, /*NO_COPY*/Begin)));
            }
          } else if (NeedParen) {
            Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/Begin, new StringRef(/*KEEP_STR*/"&(")));
            Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/End, new StringRef(/*KEEP_STR*/$RPAREN)));
          } else {
            Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/Begin, new StringRef(/*KEEP_STR*/$AMP)));
          }
        }
        
        NumConversionsFixed++;
        if (NumConversionsFixed == 1) {
          Kind = FixKind;
        }
        return true;
      }
    }
    
    return false;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 80,
   FQN="clang::ConversionFixItGenerator::clear", NM="_ZN5clang24ConversionFixItGenerator5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGenerator5clearEv")
  //</editor-fold>
  public void clear() {
    Hints.clear();
    NumConversionsFixed = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 85,
   FQN="clang::ConversionFixItGenerator::isNull", NM="_ZN5clang24ConversionFixItGenerator6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGenerator6isNullEv")
  //</editor-fold>
  public boolean isNull() {
    return (NumConversionsFixed == 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::ConversionFixItGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 33,
   FQN="clang::ConversionFixItGenerator::ConversionFixItGenerator", NM="_ZN5clang24ConversionFixItGeneratorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGeneratorC1EOS0_")
  //</editor-fold>
  public /*inline*/ ConversionFixItGenerator(JD$Move _dparam, final ConversionFixItGenerator /*&&*/$Prm0) {
    // : Hints(static_cast<ConversionFixItGenerator &&>().Hints), NumConversionsFixed(static_cast<ConversionFixItGenerator &&>().NumConversionsFixed), Kind(static_cast<ConversionFixItGenerator &&>().Kind), CompareTypes(static_cast<ConversionFixItGenerator &&>().CompareTypes) 
    //START JInit
    this.Hints = new std.vector<FixItHint>(JD$Move.INSTANCE, $Prm0.Hints);
    this.NumConversionsFixed = $Prm0.NumConversionsFixed;
    this.Kind = $Prm0.Kind;
    this.CompareTypes = $tryClone($Prm0.CompareTypes);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 33,
   FQN="clang::ConversionFixItGenerator::operator=", NM="_ZN5clang24ConversionFixItGeneratoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGeneratoraSEOS0_")
  //</editor-fold>
  public /*inline*/ ConversionFixItGenerator /*&*/ $assignMove(final ConversionFixItGenerator /*&&*/$Prm0) {
    this.Hints.$assignMove($Prm0.Hints);
    this.NumConversionsFixed = $Prm0.NumConversionsFixed;
    this.Kind = $Prm0.Kind;
    this.CompareTypes = $tryClone($Prm0.CompareTypes);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConversionFixItGenerator::~ConversionFixItGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaFixItUtils.h", line = 33,
   FQN="clang::ConversionFixItGenerator::~ConversionFixItGenerator", NM="_ZN5clang24ConversionFixItGeneratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang24ConversionFixItGeneratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Hints.$destroy();
    //END JDestroy
  }

  public /*inline*/ ConversionFixItGenerator(final ConversionFixItGenerator /*&&*/$Prm0) {
    // : Hints(static_cast<ConversionFixItGenerator &&>().Hints), NumConversionsFixed(static_cast<ConversionFixItGenerator &&>().NumConversionsFixed), Kind(static_cast<ConversionFixItGenerator &&>().Kind), CompareTypes(static_cast<ConversionFixItGenerator &&>().CompareTypes) 
    //START JInit
    this.Hints = new std.vector<FixItHint>($Prm0.Hints);
    this.NumConversionsFixed = $Prm0.NumConversionsFixed;
    this.Kind = $Prm0.Kind;
    this.CompareTypes = $tryClone($Prm0.CompareTypes);
    //END JInit
  }
  
  @Override
  public ConversionFixItGenerator $assign(ConversionFixItGenerator $Prm0) {
    this.Hints.$assign($Prm0.Hints);
    this.NumConversionsFixed = $Prm0.NumConversionsFixed;
    this.Kind = $Prm0.Kind;
    this.CompareTypes = $tryClone($Prm0.CompareTypes);
    return /*Deref*/this;
  }

  @Override
  public ConversionFixItGenerator clone() {
    return new ConversionFixItGenerator(this);
  }
  
  @Override public String toString() {
    return "" + "Hints=" + Hints // NOI18N
              + ", NumConversionsFixed=" + NumConversionsFixed // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", CompareTypes=" + CompareTypes; // NOI18N
  }
}
