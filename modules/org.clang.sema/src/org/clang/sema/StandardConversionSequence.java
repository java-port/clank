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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;


/// StandardConversionSequence - represents a standard conversion
/// sequence (C++ 13.3.3.1.1). A standard conversion sequence
/// contains between zero and three conversions. If a particular
/// conversion is not needed, it will be set to the identity conversion
/// (ICK_Identity). Note that the three conversions are
/// specified as separate members (rather than in an array) so that
/// we can keep the size of a standard conversion sequence to a
/// single word.
//<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 131,
 FQN="clang::StandardConversionSequence", NM="_ZN5clang26StandardConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang26StandardConversionSequenceE")
//</editor-fold>
public class StandardConversionSequence {
/*public:*/
  /// First -- The first conversion can be an lvalue-to-rvalue
  /// conversion, array-to-pointer conversion, or
  /// function-to-pointer conversion.
  public ImplicitConversionKind First /*: 8*/;
  
  /// Second - The second conversion can be an integral promotion,
  /// floating point promotion, integral conversion, floating point
  /// conversion, floating-integral conversion, pointer conversion,
  /// pointer-to-member conversion, or boolean conversion.
  public ImplicitConversionKind Second /*: 8*/;
  
  /// Third - The third conversion can be a qualification conversion.
  public ImplicitConversionKind Third /*: 8*/;
  
  /// \brief Whether this is the deprecated conversion of a
  /// string literal to a pointer to non-const character data
  /// (C++ 4.2p2).
  public /*JBIT unsigned int*/ boolean DeprecatedStringLiteralToCharPtr /*: 1*/;
  
  /// \brief Whether the qualification conversion involves a change in the
  /// Objective-C lifetime (for automatic reference counting).
  public /*JBIT unsigned int*/ boolean QualificationIncludesObjCLifetime /*: 1*/;
  
  /// IncompatibleObjC - Whether this is an Objective-C conversion
  /// that we should warn about (if we actually use it).
  public /*JBIT unsigned int*/ boolean IncompatibleObjC /*: 1*/;
  
  /// ReferenceBinding - True when this is a reference binding
  /// (C++ [over.ics.ref]).
  public /*JBIT unsigned int*/ boolean ReferenceBinding /*: 1*/;
  
  /// DirectBinding - True when this is a reference binding that is a
  /// direct binding (C++ [dcl.init.ref]).
  public /*JBIT unsigned int*/ boolean DirectBinding /*: 1*/;
  
  /// \brief Whether this is an lvalue reference binding (otherwise, it's
  /// an rvalue reference binding).
  public /*JBIT unsigned int*/ boolean IsLvalueReference /*: 1*/;
  
  /// \brief Whether we're binding to a function lvalue.
  public /*JBIT unsigned int*/ boolean BindsToFunctionLvalue /*: 1*/;
  
  /// \brief Whether we're binding to an rvalue.
  public /*JBIT unsigned int*/ boolean BindsToRvalue /*: 1*/;
  
  /// \brief Whether this binds an implicit object argument to a 
  /// non-static member function without a ref-qualifier.
  public /*JBIT unsigned int*/ boolean BindsImplicitObjectArgumentWithoutRefQualifier /*: 1*/;
  
  /// \brief Whether this binds a reference to an object with a different
  /// Objective-C lifetime qualifier.
  public /*JBIT unsigned int*/ boolean ObjCLifetimeConversionBinding /*: 1*/;
  
  /// FromType - The type that this conversion is converting
  /// from. This is an opaque pointer that can be translated into a
  /// QualType.
  public Object/*void P*/ FromTypePtr;
  
  /// ToType - The types that this conversion is converting to in
  /// each step. This is an opaque pointer that can be translated
  /// into a QualType.
  public Object/*void P*/ ToTypePtrs[/*3*/] = new Object/*void P*/ [3];
  
  /// CopyConstructor - The copy constructor that is used to perform
  /// this conversion, when the conversion is actually just the
  /// initialization of an object via copy constructor. Such
  /// conversions are either identity conversions or derived-to-base
  /// conversions.
  public CXXConstructorDecl /*P*/ CopyConstructor;
  public DeclAccessPair FoundCopyConstructor;
  
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::setFromType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 204,
   FQN="clang::StandardConversionSequence::setFromType", NM="_ZN5clang26StandardConversionSequence11setFromTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang26StandardConversionSequence11setFromTypeENS_8QualTypeE")
  //</editor-fold>
  public void setFromType(QualType T) {
    FromTypePtr = T.getAsOpaquePtr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::setToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 205,
   FQN="clang::StandardConversionSequence::setToType", NM="_ZN5clang26StandardConversionSequence9setToTypeEjNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang26StandardConversionSequence9setToTypeEjNS_8QualTypeE")
  //</editor-fold>
  public void setToType(/*uint*/int Idx, QualType T) {
    assert ($less_uint(Idx, 3)) : "To type index is out of range";
    ToTypePtrs[Idx] = T.getAsOpaquePtr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::setAllToTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 209,
   FQN="clang::StandardConversionSequence::setAllToTypes", NM="_ZN5clang26StandardConversionSequence13setAllToTypesENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang26StandardConversionSequence13setAllToTypesENS_8QualTypeE")
  //</editor-fold>
  public void setAllToTypes(QualType T) {
    ToTypePtrs[0] = T.getAsOpaquePtr();
    ToTypePtrs[1] = ToTypePtrs[0];
    ToTypePtrs[2] = ToTypePtrs[0];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::getFromType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 215,
   FQN="clang::StandardConversionSequence::getFromType", NM="_ZNK5clang26StandardConversionSequence11getFromTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK5clang26StandardConversionSequence11getFromTypeEv")
  //</editor-fold>
  public QualType getFromType() /*const*/ {
    return QualType.getFromOpaquePtr(FromTypePtr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::getToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 218,
   FQN="clang::StandardConversionSequence::getToType", NM="_ZNK5clang26StandardConversionSequence9getToTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK5clang26StandardConversionSequence9getToTypeEj")
  //</editor-fold>
  public QualType getToType(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, 3)) : "To type index is out of range";
    return QualType.getFromOpaquePtr(ToTypePtrs[Idx]);
  }

  
  /// StandardConversionSequence - Set the standard conversion
  /// sequence to the identity conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::setAsIdentityConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 179,
   FQN="clang::StandardConversionSequence::setAsIdentityConversion", NM="_ZN5clang26StandardConversionSequence23setAsIdentityConversionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26StandardConversionSequence23setAsIdentityConversionEv")
  //</editor-fold>
  public void setAsIdentityConversion() {
    First = ImplicitConversionKind.ICK_Identity;
    Second = ImplicitConversionKind.ICK_Identity;
    Third = ImplicitConversionKind.ICK_Identity;
    DeprecatedStringLiteralToCharPtr = false;
    QualificationIncludesObjCLifetime = false;
    ReferenceBinding = false;
    DirectBinding = false;
    IsLvalueReference = true;
    BindsToFunctionLvalue = false;
    BindsToRvalue = false;
    BindsImplicitObjectArgumentWithoutRefQualifier = false;
    ObjCLifetimeConversionBinding = false;
    CopyConstructor = null;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::isIdentityConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 225,
   FQN="clang::StandardConversionSequence::isIdentityConversion", NM="_ZNK5clang26StandardConversionSequence20isIdentityConversionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK5clang26StandardConversionSequence20isIdentityConversionEv")
  //</editor-fold>
  public boolean isIdentityConversion() /*const*/ {
    return Second == ImplicitConversionKind.ICK_Identity && Third == ImplicitConversionKind.ICK_Identity;
  }

  
  /// getRank - Retrieve the rank of this standard conversion sequence
  /// (C++ 13.3.3.1.1p3). The rank is the largest rank of each of the
  /// implicit conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::getRank">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 198,
   FQN="clang::StandardConversionSequence::getRank", NM="_ZNK5clang26StandardConversionSequence7getRankEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26StandardConversionSequence7getRankEv")
  //</editor-fold>
  public ImplicitConversionRank getRank() /*const*/ {
    ImplicitConversionRank Rank = ImplicitConversionRank.ICR_Exact_Match;
    if (GetConversionRank(First).getValue() > Rank.getValue()) {
      Rank = GetConversionRank(First);
    }
    if (GetConversionRank(Second).getValue() > Rank.getValue()) {
      Rank = GetConversionRank(Second);
    }
    if (GetConversionRank(Third).getValue() > Rank.getValue()) {
      Rank = GetConversionRank(Third);
    }
    return Rank;
  }


  
  /// Check if this standard conversion sequence represents a narrowing
  /// conversion, according to C++11 [dcl.init.list]p7.
  ///
  /// \param Ctx  The AST context.
  /// \param Converted  The result of applying this standard conversion sequence.
  /// \param ConstantValue  If this is an NK_Constant_Narrowing conversion, the
  ///        value of the expression prior to the narrowing conversion.
  /// \param ConstantType  If this is an NK_Constant_Narrowing conversion, the
  ///        type of the expression prior to the narrowing conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::getNarrowingKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 285,
   FQN="clang::StandardConversionSequence::getNarrowingKind", NM="_ZNK5clang26StandardConversionSequence16getNarrowingKindERNS_10ASTContextEPKNS_4ExprERNS_7APValueERNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26StandardConversionSequence16getNarrowingKindERNS_10ASTContextEPKNS_4ExprERNS_7APValueERNS_8QualTypeE")
  //</editor-fold>
  public NarrowingKind getNarrowingKind(final ASTContext /*&*/ Ctx, 
                  /*const*/ Expr /*P*/ _Converted, 
                  final APValue /*&*/ ConstantValue, 
                  final QualType /*&*/ ConstantType) /*const*/ {
    assert (Ctx.getLangOpts().CPlusPlus) : "narrowing check outside C++";
    
    // C++11 [dcl.init.list]p7:
    //   A narrowing conversion is an implicit conversion ...
    QualType FromType = getToType(0);
    QualType ToType = getToType(1);
    {
      
      // A conversion to an enumeration type is narrowing if the conversion to
      // the underlying type is narrowing. This only arises for expressions of
      // the form 'Enum{init}'.
      /*const*/ EnumType /*P*/ ET = ToType.$arrow().<EnumType>getAs$EnumType();
      if ((ET != null)) {
        ToType.$assignMove(ET.getDecl().getIntegerType());
      }
    }
    switch (Second) {
     case ICK_Boolean_Conversion:
      // 'bool' is an integral type; dispatch to the right place to handle it.
      if (FromType.$arrow().isRealFloatingType()) {
        // goto FloatingIntegralConversion;
        // instead of "goto" we'll get there just  via fallthrough
      } else {
        if (FromType.$arrow().isIntegralOrUnscopedEnumerationType()) {
          return IntegralConversion(FromType, ToType, Ctx, _Converted, ConstantType, ConstantValue);
        }
        // Boolean conversions can be from pointers and pointers to members
        // [conv.bool], and those aren't considered narrowing conversions.
        return NarrowingKind.NK_Not_Narrowing;
      }
     case ICK_Floating_Integral:
     FloatingIntegralConversion:
      
      // -- from a floating-point type to an integer type, or
      //
      // -- from an integer type or unscoped enumeration type to a floating-point
      //    type, except where the source is a constant expression and the actual
      //    value after conversion will fit into the target type and will produce
      //    the original value when converted back to the original type, or
      if (FromType.$arrow().isRealFloatingType() && ToType.$arrow().isIntegralType(Ctx)) {
        return NarrowingKind.NK_Type_Narrowing;
      } else if (FromType.$arrow().isIntegralType(Ctx) && ToType.$arrow().isRealFloatingType()) {
        APSInt IntConstantValue/*J*/= new APSInt();
        /*const*/ Expr /*P*/ Initializer = IgnoreNarrowingConversion(_Converted);
        if ((Initializer != null)
           && Initializer.isIntegerConstantExpr(IntConstantValue, Ctx)) {
          APFloat Result = null;
          try {
            // Convert the integer to the floating type.
            Result/*J*/= new APFloat(Ctx.getFloatTypeSemantics(new QualType(ToType)));
            Result.convertFromAPInt(IntConstantValue, IntConstantValue.isSigned(), 
                APFloat.roundingMode.rmNearestTiesToEven);
            // And back.
            APSInt ConvertedValue = new APSInt(IntConstantValue);
            bool$ptr ignored = create_bool$ptr();
            Result.convertToInteger(ConvertedValue, 
                APFloat.roundingMode.rmTowardZero, ignored);
            // If the resulting value is different, this was a narrowing conversion.
            if (IntConstantValue.$noteq(ConvertedValue)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean(ConstantValue.$assign($c$.track(new APValue(new APSInt(IntConstantValue)))));
                ConstantType.$assignMove(Initializer.getType());
                return NarrowingKind.NK_Constant_Narrowing;
              } finally {
                $c$.$destroy();
              }
            }
          } finally {
            if (Result != null) { Result.$destroy(); }
          }
        } else {
          // Variables are always narrowings.
          return NarrowingKind.NK_Variable_Narrowing;
        }
      }
      return NarrowingKind.NK_Not_Narrowing;
     case ICK_Floating_Conversion:
      
      // -- from long double to double or float, or from double to float, except
      //    where the source is a constant expression and the actual value after
      //    conversion is within the range of values that can be represented (even
      //    if it cannot be represented exactly), or
      if (FromType.$arrow().isRealFloatingType() && ToType.$arrow().isRealFloatingType()
         && Ctx.getFloatingTypeOrder(new QualType(FromType), new QualType(ToType)) == 1) {
        // FromType is larger than ToType.
        /*const*/ Expr /*P*/ Initializer = IgnoreNarrowingConversion(_Converted);
        if (Initializer.isCXX11ConstantExpr(Ctx, $AddrOf(ConstantValue))) {
          // Constant!
          assert (ConstantValue.isFloat());
          APFloat FloatVal = new APFloat(ConstantValue.getFloat());
          // Convert the source value into the target type.
          bool$ptr ignored = create_bool$ptr();
          /*APFloat::opStatus*//*uint*/int ConvertStatus = FloatVal.convert(Ctx.getFloatTypeSemantics(new QualType(ToType)), 
              APFloat.roundingMode.rmNearestTiesToEven, ignored);
          // If there was no overflow, the source value is within the range of
          // values that can be represented.
          if (((ConvertStatus & APFloat.opStatus.opOverflow) != 0)) {
            ConstantType.$assignMove(Initializer.getType());
            return NarrowingKind.NK_Constant_Narrowing;
          }
        } else {
          return NarrowingKind.NK_Variable_Narrowing;
        }
      }
      return NarrowingKind.NK_Not_Narrowing;
     case ICK_Integral_Conversion:
        return IntegralConversion(FromType, ToType, Ctx, _Converted, ConstantType, ConstantValue);
     default:
      // Other kinds of conversions are not narrowings.
      return NarrowingKind.NK_Not_Narrowing;
    }
  }

  private NarrowingKind IntegralConversion(QualType FromType, QualType ToType, final ASTContext Ctx, Expr _Converted, final QualType ConstantType, final APValue ConstantValue) {
      assert (FromType.$arrow().isIntegralOrUnscopedEnumerationType());
      assert (ToType.$arrow().isIntegralOrUnscopedEnumerationType());
      /*const*/boolean FromSigned = FromType.$arrow().isSignedIntegerOrEnumerationType();
      /*const*//*uint*/int FromWidth = Ctx.getIntWidth(new QualType(FromType));
      /*const*/boolean ToSigned = ToType.$arrow().isSignedIntegerOrEnumerationType();
      /*const*//*uint*/int ToWidth = Ctx.getIntWidth(new QualType(ToType));
      if ($greater_uint(FromWidth, ToWidth)
              || (FromWidth == ToWidth && FromSigned != ToSigned)
              || (FromSigned && !ToSigned)) {
          // Not all values of FromType can be represented in ToType.
          APSInt InitializerValue/*J*/= new APSInt();
          /*const*/ Expr /*P*/ Initializer = IgnoreNarrowingConversion(_Converted);
          if (!Initializer.isIntegerConstantExpr(InitializerValue, Ctx)) {
              // Such conversions on variables are always narrowing.
              return NarrowingKind.NK_Variable_Narrowing;
          }
          boolean Narrowing = false;
          if ($less_uint(FromWidth, ToWidth)) {
              // Negative -> unsigned is narrowing. Otherwise, more bits is never
              // narrowing.
              if (InitializerValue.isSigned() && InitializerValue.isNegative()) {
                  Narrowing = true;
              }
          } else {
              // Add a bit to the InitializerValue so we don't have to worry about
              // signed vs. unsigned comparisons.
              InitializerValue.$assignMove(InitializerValue.extend(InitializerValue.getBitWidth() + 1));
              // Convert the initializer to and from the target width and signed-ness.
              APSInt ConvertedValue = new APSInt(InitializerValue);
              ConvertedValue.$assignMove(ConvertedValue.trunc(ToWidth));
              ConvertedValue.setIsSigned(ToSigned);
              ConvertedValue.$assignMove(ConvertedValue.extend(InitializerValue.getBitWidth()));
              ConvertedValue.setIsSigned(InitializerValue.isSigned());
              // If the result is different, this was a narrowing conversion.
              if (ConvertedValue.$noteq(InitializerValue)) {
                  Narrowing = true;
              }
          }
          if (Narrowing) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                  ConstantType.$assignMove(Initializer.getType());
                  $c$.clean(ConstantValue.$assign($c$.track(new APValue(new APSInt(InitializerValue)))));
                  return NarrowingKind.NK_Constant_Narrowing;
              } finally {
                  $c$.$destroy();
              }
          }
      }
      return NarrowingKind.NK_Not_Narrowing;
  }


  
  /// isPointerConversionToBool - Determines whether this conversion is
  /// a conversion of a pointer or pointer-to-member to bool. This is
  /// used as part of the ranking of standard conversion sequences
  /// (C++ 13.3.3.2p4).
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::isPointerConversionToBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 213,
   FQN="clang::StandardConversionSequence::isPointerConversionToBool", NM="_ZNK5clang26StandardConversionSequence25isPointerConversionToBoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26StandardConversionSequence25isPointerConversionToBoolEv")
  //</editor-fold>
  public boolean isPointerConversionToBool() /*const*/ {
    // Note that FromType has not necessarily been transformed by the
    // array-to-pointer or function-to-pointer implicit conversions, so
    // check for their presence as well as checking whether FromType is
    // a pointer.
    if (getToType(1).$arrow().isBooleanType()
       && (getFromType().$arrow().isPointerType()
       || getFromType().$arrow().isObjCObjectPointerType()
       || getFromType().$arrow().isBlockPointerType()
       || getFromType().$arrow().isNullPtrType()
       || First == ImplicitConversionKind.ICK_Array_To_Pointer || First == ImplicitConversionKind.ICK_Function_To_Pointer)) {
      return true;
    }
    
    return false;
  }


  
  /// isPointerConversionToVoidPointer - Determines whether this
  /// conversion is a conversion of a pointer to a void pointer. This is
  /// used as part of the ranking of standard conversion sequences (C++
  /// 13.3.3.2p4).
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::isPointerConversionToVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 233,
   FQN="clang::StandardConversionSequence::isPointerConversionToVoidPointer", NM="_ZNK5clang26StandardConversionSequence32isPointerConversionToVoidPointerERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26StandardConversionSequence32isPointerConversionToVoidPointerERNS_10ASTContextE")
  //</editor-fold>
  public boolean isPointerConversionToVoidPointer(final ASTContext /*&*/ Context) /*const*/ {
    QualType FromType = getFromType();
    QualType ToType = getToType(1);
    
    // Note that FromType has not necessarily been transformed by the
    // array-to-pointer implicit conversion, so check for its presence
    // and redo the conversion to get a pointer.
    if (First == ImplicitConversionKind.ICK_Array_To_Pointer) {
      FromType.$assignMove(Context.getArrayDecayedType(new QualType(FromType)));
    }
    if (Second == ImplicitConversionKind.ICK_Pointer_Conversion && FromType.$arrow().isAnyPointerType()) {
      {
        /*const*/ PointerType /*P*/ ToPtrType = ToType.$arrow().getAs(PointerType.class);
        if ((ToPtrType != null)) {
          return ToPtrType.getPointeeType().$arrow().isVoidType();
        }
      }
    }
    
    return false;
  }


  
  /// dump - Print this standard conversion sequence to standard
  /// error. Useful for debugging overloading issues.
  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 443,
   FQN="clang::StandardConversionSequence::dump", NM="_ZNK5clang26StandardConversionSequence4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26StandardConversionSequence4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    final raw_ostream /*&*/ OS = llvm.errs();
    boolean PrintedSomething = false;
    if (First != ImplicitConversionKind.ICK_Identity) {
      OS.$out(GetImplicitConversionName(First));
      PrintedSomething = true;
    }
    if (Second != ImplicitConversionKind.ICK_Identity) {
      if (PrintedSomething) {
        OS.$out(/*KEEP_STR*/" -> ");
      }
      OS.$out(GetImplicitConversionName(Second));
      if ((CopyConstructor != null)) {
        OS.$out(/*KEEP_STR*/" (by copy constructor)");
      } else if (DirectBinding) {
        OS.$out(/*KEEP_STR*/" (direct reference binding)");
      } else if (ReferenceBinding) {
        OS.$out(/*KEEP_STR*/" (reference binding)");
      }
      PrintedSomething = true;
    }
    if (Third != ImplicitConversionKind.ICK_Identity) {
      if (PrintedSomething) {
        OS.$out(/*KEEP_STR*/" -> ");
      }
      OS.$out(GetImplicitConversionName(Third));
      PrintedSomething = true;
    }
    if (!PrintedSomething) {
      OS.$out(/*KEEP_STR*/"No conversions required");
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 131,
   FQN="clang::StandardConversionSequence::operator=", NM="_ZN5clang26StandardConversionSequenceaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang26StandardConversionSequenceaSERKS0_")
  //</editor-fold>
  public /*inline*/ StandardConversionSequence /*&*/ $assign(final /*const*/ StandardConversionSequence /*&*/ $Prm0) {
    this.First = $Prm0.First;
    this.Second = $Prm0.Second;
    this.Third = $Prm0.Third;
    this.DeprecatedStringLiteralToCharPtr = $Prm0.DeprecatedStringLiteralToCharPtr;
    this.QualificationIncludesObjCLifetime = $Prm0.QualificationIncludesObjCLifetime;
    this.IncompatibleObjC = $Prm0.IncompatibleObjC;
    this.ReferenceBinding = $Prm0.ReferenceBinding;
    this.DirectBinding = $Prm0.DirectBinding;
    this.IsLvalueReference = $Prm0.IsLvalueReference;
    this.BindsToFunctionLvalue = $Prm0.BindsToFunctionLvalue;
    this.BindsToRvalue = $Prm0.BindsToRvalue;
    this.BindsImplicitObjectArgumentWithoutRefQualifier = $Prm0.BindsImplicitObjectArgumentWithoutRefQualifier;
    this.ObjCLifetimeConversionBinding = $Prm0.ObjCLifetimeConversionBinding;
    this.FromTypePtr = $Prm0.FromTypePtr;
    __builtin_memcpy($AddrOf(this.ToTypePtrs), $AddrOf($Prm0.ToTypePtrs) /*, SKIP_ARG*/, true);    
    this.CopyConstructor = $Prm0.CopyConstructor;
    this.FoundCopyConstructor.$assign($Prm0.FoundCopyConstructor);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 131,
   FQN="clang::StandardConversionSequence::operator=", NM="_ZN5clang26StandardConversionSequenceaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang26StandardConversionSequenceaSEOS0_")
  //</editor-fold>
  public /*inline*/ StandardConversionSequence /*&*/ $assignMove(final StandardConversionSequence /*&&*/$Prm0) {
    this.First = $Prm0.First;
    this.Second = $Prm0.Second;
    this.Third = $Prm0.Third;
    this.DeprecatedStringLiteralToCharPtr = $Prm0.DeprecatedStringLiteralToCharPtr;
    this.QualificationIncludesObjCLifetime = $Prm0.QualificationIncludesObjCLifetime;
    this.IncompatibleObjC = $Prm0.IncompatibleObjC;
    this.ReferenceBinding = $Prm0.ReferenceBinding;
    this.DirectBinding = $Prm0.DirectBinding;
    this.IsLvalueReference = $Prm0.IsLvalueReference;
    this.BindsToFunctionLvalue = $Prm0.BindsToFunctionLvalue;
    this.BindsToRvalue = $Prm0.BindsToRvalue;
    this.BindsImplicitObjectArgumentWithoutRefQualifier = $Prm0.BindsImplicitObjectArgumentWithoutRefQualifier;
    this.ObjCLifetimeConversionBinding = $Prm0.ObjCLifetimeConversionBinding;
    this.FromTypePtr = $Prm0.FromTypePtr;
    __builtin_memcpy($AddrOf(this.ToTypePtrs), $AddrOf($Prm0.ToTypePtrs) /*, SKIP_ARG*/, true);
    this.CopyConstructor = $Prm0.CopyConstructor;
    this.FoundCopyConstructor.$assignMove($Prm0.FoundCopyConstructor);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StandardConversionSequence::StandardConversionSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 131,
   FQN="clang::StandardConversionSequence::StandardConversionSequence", NM="_ZN5clang26StandardConversionSequenceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26StandardConversionSequenceC1Ev")
  //</editor-fold>
  public /*inline*/ StandardConversionSequence() {
    // : FoundCopyConstructor() 
    //START JInit
    this.FoundCopyConstructor = new DeclAccessPair();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "First=" + First // NOI18N
              + ", Second=" + Second // NOI18N
              + ", Third=" + Third // NOI18N
              + ", DeprecatedStringLiteralToCharPtr=" + DeprecatedStringLiteralToCharPtr // NOI18N
              + ", QualificationIncludesObjCLifetime=" + QualificationIncludesObjCLifetime // NOI18N
              + ", IncompatibleObjC=" + IncompatibleObjC // NOI18N
              + ", ReferenceBinding=" + ReferenceBinding // NOI18N
              + ", DirectBinding=" + DirectBinding // NOI18N
              + ", IsLvalueReference=" + IsLvalueReference // NOI18N
              + ", BindsToFunctionLvalue=" + BindsToFunctionLvalue // NOI18N
              + ", BindsToRvalue=" + BindsToRvalue // NOI18N
              + ", BindsImplicitObjectArgumentWithoutRefQualifier=" + BindsImplicitObjectArgumentWithoutRefQualifier // NOI18N
              + ", ObjCLifetimeConversionBinding=" + ObjCLifetimeConversionBinding // NOI18N
              + ", FromTypePtr=" + FromTypePtr // NOI18N
              + ", ToTypePtrs=" + ToTypePtrs // NOI18N
              + ", CopyConstructor=" + CopyConstructor // NOI18N
              + ", FoundCopyConstructor=" + FoundCopyConstructor; // NOI18N
  }
}
