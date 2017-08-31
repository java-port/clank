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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// BuiltinCandidateTypeSet - A set of types that will be used for the
/// candidate operator functions for built-in operators (C++
/// [over.built]). The types are separated into pointer types and
/// enumeration types.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6827,
 FQN="(anonymous namespace)::BuiltinCandidateTypeSet", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetE")
//</editor-fold>
public class BuiltinCandidateTypeSet implements Destructors.ClassWithDestructor {
  
  /// TypeSet - A set of types.
  /*typedef llvm::SetVector<QualType, SmallVector<QualType, 8>, llvm::SmallPtrSet<QualType, 8> > TypeSet*/
//  public final class TypeSet extends SetVector<QualType, SmallVector<QualType>, SmallPtrSet<QualType> >{ };
  
  /// PointerTypes - The set of pointer types that will be used in the
  /// built-in candidates.
  private SetVector<QualType> PointerTypes;
  
  /// MemberPointerTypes - The set of member pointer types that will be
  /// used in the built-in candidates.
  private SetVector<QualType> MemberPointerTypes;
  
  /// EnumerationTypes - The set of enumeration types that will be
  /// used in the built-in candidates.
  private SetVector<QualType> EnumerationTypes;
  
  /// \brief The set of vector types that will be used in the built-in
  /// candidates.
  private SetVector<QualType> VectorTypes;
  
  /// \brief A flag indicating non-record types are viable candidates
  private boolean HasNonRecordTypes;
  
  /// \brief A flag indicating whether either arithmetic or enumeration types
  /// were present in the candidate set.
  private boolean HasArithmeticOrEnumeralTypes;
  
  /// \brief A flag indicating whether the nullptr type was present in the
  /// candidate set.
  private boolean HasNullPtrType;
  
  /// Sema - The semantic analysis instance where we are building the
  /// candidate type set.
  private final Sema /*&*/ SemaRef;
  
  /// Context - The AST context in which we will build the type sets.
  private final ASTContext /*&*/ Context;
  
  // end anonymous namespace
  
  /// AddPointerWithMoreQualifiedTypeVariants - Add the pointer type @p Ty to
  /// the set of pointer types along with any more-qualified variants of
  /// that type. For example, if @p Ty is "int const *", this routine
  /// will add "int const *", "int const volatile *", "int const
  /// restrict *", and "int const volatile restrict *" to the set of
  /// pointer types. Returns true if the add of @p Ty itself succeeded,
  /// false otherwise.
  ///
  /// FIXME: what to do about extended qualifiers?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::AddPointerWithMoreQualifiedTypeVariants">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6924,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::AddPointerWithMoreQualifiedTypeVariants", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet39AddPointerWithMoreQualifiedTypeVariantsEN5clang8QualTypeERKNS1_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet39AddPointerWithMoreQualifiedTypeVariantsEN5clang8QualTypeERKNS1_10QualifiersE")
  //</editor-fold>
  private boolean AddPointerWithMoreQualifiedTypeVariants(QualType Ty, 
                                         final /*const*/ Qualifiers /*&*/ VisibleQuals) {
    
    // Insert this type.
    if (!PointerTypes.insert(Ty)) {
      return false;
    }
    
    QualType PointeeTy/*J*/= new QualType();
    /*const*/ PointerType /*P*/ PointerTy = Ty.$arrow().getAs(PointerType.class);
    boolean buildObjCPtr = false;
    if (!(PointerTy != null)) {
      /*const*/ ObjCObjectPointerType /*P*/ PTy = Ty.$arrow().castAs(ObjCObjectPointerType.class);
      PointeeTy.$assignMove(PTy.getPointeeType());
      buildObjCPtr = true;
    } else {
      PointeeTy.$assignMove(PointerTy.getPointeeType());
    }
    
    // Don't add qualified variants of arrays. For one, they're not allowed
    // (the qualifier would sink to the element type), and for another, the
    // only overload situation where it matters is subscript or pointer +- int,
    // and those shouldn't have qualifier variants anyway.
    if (PointeeTy.$arrow().isArrayType()) {
      return true;
    }
    
    /*uint*/int BaseCVR = PointeeTy.getCVRQualifiers();
    boolean hasVolatile = VisibleQuals.hasVolatile();
    boolean hasRestrict = VisibleQuals.hasRestrict();
    
    // Iterate through all strict supersets of BaseCVR.
    for (/*uint*/int CVR = BaseCVR + 1; $lesseq_uint(CVR, Qualifiers.TQ.CVRMask); ++CVR) {
      if ((CVR | BaseCVR) != CVR) {
        continue;
      }
      // Skip over volatile if no volatile found anywhere in the types.
      if (((CVR & Qualifiers.TQ.Volatile) != 0) && !hasVolatile) {
        continue;
      }
      
      // Skip over restrict if no restrict found anywhere in the types, or if
      // the type cannot be restrict-qualified.
      if (((CVR & Qualifiers.TQ.Restrict) != 0)
         && (!hasRestrict
         || (!(PointeeTy.$arrow().isAnyPointerType() || PointeeTy.$arrow().isReferenceType())))) {
        continue;
      }
      
      // Build qualified pointee type.
      QualType QPointeeTy = Context.getCVRQualifiedType(new QualType(PointeeTy), CVR);
      
      // Build qualified pointer type.
      QualType QPointerTy/*J*/= new QualType();
      if (!buildObjCPtr) {
        QPointerTy.$assignMove(Context.getPointerType(new QualType(QPointeeTy)));
      } else {
        QPointerTy.$assignMove(Context.getObjCObjectPointerType(new QualType(QPointeeTy)));
      }
      
      // Insert qualified pointer type.
      PointerTypes.insert(QPointerTy);
    }
    
    return true;
  }

  
  /// AddMemberPointerWithMoreQualifiedTypeVariants - Add the pointer type @p Ty
  /// to the set of pointer types along with any more-qualified variants of
  /// that type. For example, if @p Ty is "int const *", this routine
  /// will add "int const *", "int const volatile *", "int const
  /// restrict *", and "int const volatile restrict *" to the set of
  /// pointer types. Returns true if the add of @p Ty itself succeeded,
  /// false otherwise.
  ///
  /// FIXME: what to do about extended qualifiers?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::AddMemberPointerWithMoreQualifiedTypeVariants">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6993,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::AddMemberPointerWithMoreQualifiedTypeVariants", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet45AddMemberPointerWithMoreQualifiedTypeVariantsEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet45AddMemberPointerWithMoreQualifiedTypeVariantsEN5clang8QualTypeE")
  //</editor-fold>
  private boolean AddMemberPointerWithMoreQualifiedTypeVariants(QualType Ty) {
    // Insert this type.
    if (!MemberPointerTypes.insert(Ty)) {
      return false;
    }
    
    /*const*/ MemberPointerType /*P*/ PointerTy = Ty.$arrow().getAs(MemberPointerType.class);
    assert ((PointerTy != null)) : "type was not a member pointer type!";
    
    QualType PointeeTy = PointerTy.getPointeeType();
    // Don't add qualified variants of arrays. For one, they're not allowed
    // (the qualifier would sink to the element type), and for another, the
    // only overload situation where it matters is subscript or pointer +- int,
    // and those shouldn't have qualifier variants anyway.
    if (PointeeTy.$arrow().isArrayType()) {
      return true;
    }
    /*const*/ Type /*P*/ ClassTy = PointerTy.__getClass();
    
    // Iterate through all strict supersets of the pointee type's CVR
    // qualifiers.
    /*uint*/int BaseCVR = PointeeTy.getCVRQualifiers();
    for (/*uint*/int CVR = BaseCVR + 1; $lesseq_uint(CVR, Qualifiers.TQ.CVRMask); ++CVR) {
      if ((CVR | BaseCVR) != CVR) {
        continue;
      }
      
      QualType QPointeeTy = Context.getCVRQualifiedType(new QualType(PointeeTy), CVR);
      MemberPointerTypes.insert(Context.getMemberPointerType(new QualType(QPointeeTy), ClassTy));
    }
    
    return true;
  }

/*public:*/
  /// iterator - Iterates through the types that are part of the set.
  /*typedef TypeSet::iterator iterator*/
//  public final class iterator extends /*const*/type$ptr<QualType /*P*/> { };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::BuiltinCandidateTypeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6874,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::BuiltinCandidateTypeSet", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetC1ERN5clang4SemaE")
  //</editor-fold>
  public BuiltinCandidateTypeSet(final Sema /*&*/ SemaRef) {
    // : PointerTypes(), MemberPointerTypes(), EnumerationTypes(), VectorTypes(), HasNonRecordTypes(false), HasArithmeticOrEnumeralTypes(false), HasNullPtrType(false), SemaRef(SemaRef), Context(SemaRef.Context) 
    //START JInit
    final QualType defaultValue = new QualType();
    this.PointerTypes = new SetVector<QualType>(defaultValue);
    this.MemberPointerTypes = new SetVector<QualType>(defaultValue);
    this.EnumerationTypes = new SetVector<QualType>(defaultValue);
    this.VectorTypes = new SetVector<QualType>(defaultValue);
    this.HasNonRecordTypes = false;
    this.HasArithmeticOrEnumeralTypes = false;
    this.HasNullPtrType = false;
    this./*&*/SemaRef=/*&*/SemaRef;
    this./*&*/Context=/*&*/SemaRef.Context;
    //END JInit
  }

  
  
  /// AddTypesConvertedFrom - Add each of the types to which the type @p
  /// Ty can be implicit converted to the given set of @p Types. We're
  /// primarily interested in pointer types and enumeration types. We also
  /// take member pointer types, for the conditional operator.
  /// AllowUserConversions is true if we should look at the conversion
  /// functions of a class type, and AllowExplicitConversions if we
  /// should also include the explicit conversion functions of a class
  /// type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::AddTypesConvertedFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7034,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::AddTypesConvertedFrom", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet21AddTypesConvertedFromEN5clang8QualTypeENS1_14SourceLocationEbbRKNS1_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet21AddTypesConvertedFromEN5clang8QualTypeENS1_14SourceLocationEbbRKNS1_10QualifiersE")
  //</editor-fold>
  public void AddTypesConvertedFrom(QualType Ty, 
                       SourceLocation Loc, 
                       boolean AllowUserConversions, 
                       boolean AllowExplicitConversions, 
                       final /*const*/ Qualifiers /*&*/ VisibleQuals) {
    // Only deal with canonical types.
    Ty.$assignMove(Context.getCanonicalType(new QualType(Ty)).$QualType());
    {
      
      // Look through reference types; they aren't part of the type of an
      // expression for the purposes of conversions.
      /*const*/ ReferenceType /*P*/ RefTy = Ty.$arrow().getAs(ReferenceType.class);
      if ((RefTy != null)) {
        Ty.$assignMove(RefTy.getPointeeType());
      }
    }
    
    // If we're dealing with an array type, decay to the pointer.
    if (Ty.$arrow().isArrayType()) {
      Ty.$assignMove(SemaRef.Context.getArrayDecayedType(new QualType(Ty)));
    }
    
    // Otherwise, we don't care about qualifiers on the type.
    Ty.$assignMove(Ty.getLocalUnqualifiedType());
    
    // Flag if we ever add a non-record type.
    /*const*/ RecordType /*P*/ TyRec = Ty.$arrow().<RecordType>getAs$RecordType();
    HasNonRecordTypes = HasNonRecordTypes || !(TyRec != null);
    
    // Flag if we encounter an arithmetic type.
    HasArithmeticOrEnumeralTypes
       = HasArithmeticOrEnumeralTypes || Ty.$arrow().isArithmeticType();
    if (Ty.$arrow().isObjCIdType() || Ty.$arrow().isObjCClassType()) {
      PointerTypes.insert(Ty);
    } else if ((Ty.$arrow().getAs(PointerType.class) != null) || (Ty.$arrow().getAs(ObjCObjectPointerType.class) != null)) {
      // Insert our type, and its more-qualified variants, into the set
      // of types.
      if (!AddPointerWithMoreQualifiedTypeVariants(new QualType(Ty), VisibleQuals)) {
        return;
      }
    } else if (Ty.$arrow().isMemberPointerType()) {
      // Member pointers are far easier, since the pointee can't be converted.
      if (!AddMemberPointerWithMoreQualifiedTypeVariants(new QualType(Ty))) {
        return;
      }
    } else if (Ty.$arrow().isEnumeralType()) {
      HasArithmeticOrEnumeralTypes = true;
      EnumerationTypes.insert(Ty);
    } else if (Ty.$arrow().isVectorType()) {
      // We treat vector types as arithmetic types in many contexts as an
      // extension.
      HasArithmeticOrEnumeralTypes = true;
      VectorTypes.insert(Ty);
    } else if (Ty.$arrow().isNullPtrType()) {
      HasNullPtrType = true;
    } else if (AllowUserConversions && (TyRec != null)) {
      // No conversion functions in incomplete types.
      if (!SemaRef.isCompleteType(new SourceLocation(Loc), new QualType(Ty))) {
        return;
      }
      
      CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(TyRec.getDecl());
      for (NamedDecl /*P*/ D : ClassDecl.getVisibleConversionFunctions()) {
        if (isa_UsingShadowDecl(D)) {
          D = cast_UsingShadowDecl(D).getTargetDecl();
        }
        
        // Skip conversion function templates; they don't tell us anything
        // about which builtin types we can convert to.
        if (isa_FunctionTemplateDecl(D)) {
          continue;
        }
        
        CXXConversionDecl /*P*/ Conv = cast_CXXConversionDecl(D);
        if (AllowExplicitConversions || !Conv.isExplicit()) {
          AddTypesConvertedFrom(Conv.getConversionType(), new SourceLocation(Loc), false, false, 
              VisibleQuals);
        }
      }
    }
  }

  
  /// pointer_begin - First pointer type found;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::pointer_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6888,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::pointer_begin", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet13pointer_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet13pointer_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> pointer_begin() {
    return PointerTypes.begin().toPointer();
  }

  
  /// pointer_end - Past the last pointer type found;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::pointer_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6891,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::pointer_end", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet11pointer_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet11pointer_endEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> pointer_end() {
    return PointerTypes.end().toPointer();
  }

  
  /// member_pointer_begin - First member pointer type found;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::member_pointer_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6894,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::member_pointer_begin", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet20member_pointer_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet20member_pointer_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> member_pointer_begin() {
    return MemberPointerTypes.begin().toPointer();
  }

  
  /// member_pointer_end - Past the last member pointer type found;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::member_pointer_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6897,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::member_pointer_end", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet18member_pointer_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet18member_pointer_endEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> member_pointer_end() {
    return MemberPointerTypes.end().toPointer();
  }

  
  /// enumeration_begin - First enumeration type found;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::enumeration_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6900,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::enumeration_begin", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet17enumeration_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet17enumeration_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> enumeration_begin() {
    return EnumerationTypes.begin().toPointer();
  }

  
  /// enumeration_end - Past the last enumeration type found;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::enumeration_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6903,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::enumeration_end", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet15enumeration_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet15enumeration_endEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> enumeration_end() {
    return EnumerationTypes.end().toPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::vector_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6905,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::vector_begin", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet12vector_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet12vector_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> vector_begin() {
    return VectorTypes.begin().toPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::vector_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6906,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::vector_end", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet10vector_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet10vector_endEv")
  //</editor-fold>
  public /*const*/type$ptr<QualType /*P*/> vector_end() {
    return VectorTypes.end().toPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::hasNonRecordTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6908,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::hasNonRecordTypes", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet17hasNonRecordTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet17hasNonRecordTypesEv")
  //</editor-fold>
  public boolean hasNonRecordTypes() {
    return HasNonRecordTypes;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::hasArithmeticOrEnumeralTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6909,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::hasArithmeticOrEnumeralTypes", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet28hasArithmeticOrEnumeralTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSet28hasArithmeticOrEnumeralTypesEv")
  //</editor-fold>
  public boolean hasArithmeticOrEnumeralTypes() {
    return HasArithmeticOrEnumeralTypes;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::hasNullPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6910,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::hasNullPtrType", NM="_ZNK12_GLOBAL__N_123BuiltinCandidateTypeSet14hasNullPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_123BuiltinCandidateTypeSet14hasNullPtrTypeEv")
  //</editor-fold>
  public boolean hasNullPtrType() /*const*/ {
    return HasNullPtrType;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::~BuiltinCandidateTypeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6827,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::~BuiltinCandidateTypeSet", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VectorTypes.$destroy();
    EnumerationTypes.$destroy();
    MemberPointerTypes.$destroy();
    PointerTypes.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinCandidateTypeSet::BuiltinCandidateTypeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6827,
   FQN="(anonymous namespace)::BuiltinCandidateTypeSet::BuiltinCandidateTypeSet", NM="_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_123BuiltinCandidateTypeSetC1EOS0_")
  //</editor-fold>
  public /*inline*/ BuiltinCandidateTypeSet(JD$Move _dparam, final BuiltinCandidateTypeSet /*&&*/$Prm0) {
    // : PointerTypes(static_cast<BuiltinCandidateTypeSet &&>().PointerTypes), MemberPointerTypes(static_cast<BuiltinCandidateTypeSet &&>().MemberPointerTypes), EnumerationTypes(static_cast<BuiltinCandidateTypeSet &&>().EnumerationTypes), VectorTypes(static_cast<BuiltinCandidateTypeSet &&>().VectorTypes), HasNonRecordTypes(static_cast<BuiltinCandidateTypeSet &&>().HasNonRecordTypes), HasArithmeticOrEnumeralTypes(static_cast<BuiltinCandidateTypeSet &&>().HasArithmeticOrEnumeralTypes), HasNullPtrType(static_cast<BuiltinCandidateTypeSet &&>().HasNullPtrType), SemaRef(static_cast<BuiltinCandidateTypeSet &&>().SemaRef), Context(static_cast<BuiltinCandidateTypeSet &&>().Context) 
    //START JInit
    this.PointerTypes = new SetVector<QualType>(JD$Move.INSTANCE, $Prm0.PointerTypes);
    this.MemberPointerTypes = new SetVector<QualType>(JD$Move.INSTANCE, $Prm0.MemberPointerTypes);
    this.EnumerationTypes = new SetVector<QualType>(JD$Move.INSTANCE, $Prm0.EnumerationTypes);
    this.VectorTypes = new SetVector<QualType>(JD$Move.INSTANCE, $Prm0.VectorTypes);
    this.HasNonRecordTypes = $Prm0.HasNonRecordTypes;
    this.HasArithmeticOrEnumeralTypes = $Prm0.HasArithmeticOrEnumeralTypes;
    this.HasNullPtrType = $Prm0.HasNullPtrType;
    this./*&*/SemaRef=/*&*/$Prm0.SemaRef;
    this./*&*/Context=/*&*/$Prm0.Context;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "PointerTypes=" + PointerTypes // NOI18N
              + ", MemberPointerTypes=" + MemberPointerTypes // NOI18N
              + ", EnumerationTypes=" + EnumerationTypes // NOI18N
              + ", VectorTypes=" + VectorTypes // NOI18N
              + ", HasNonRecordTypes=" + HasNonRecordTypes // NOI18N
              + ", HasArithmeticOrEnumeralTypes=" + HasArithmeticOrEnumeralTypes // NOI18N
              + ", HasNullPtrType=" + HasNullPtrType // NOI18N
              + ", SemaRef=" + "[Sema]" // NOI18N
              + ", Context=" + "[ASTContext]"; // NOI18N
  }
}
