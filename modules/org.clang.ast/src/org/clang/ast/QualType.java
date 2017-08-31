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

package org.clang.ast;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import org.clang.ast.comments.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.impl.TypeStatics.*;


/// A (possibly-)qualified type.
///
/// For efficiency, we don't store CV-qualified types as nodes on their
/// own: instead each reference to a type stores the qualifiers.  This
/// greatly reduces the number of nodes we need to allocate for types (for
/// example we only need one for 'int', 'const int', 'volatile int',
/// 'const volatile int', etc).
///
/// As an added efficiency bonus, instead of making this a pair, we
/// just store the two bits we care about in the low bits of the
/// pointer.  To handle the packing/unpacking, we make QualType be a
/// simple wrapper class that acts like a smart pointer.  A third bit
/// indicates whether there are extended qualifiers present, in which
/// case the pointer points to a special structure.
//<editor-fold defaultstate="collapsed" desc="clang::QualType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 598,
 FQN="clang::QualType", NM="_ZN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeE")
//</editor-fold>
public class QualType implements NativeHashable, NativePOD<QualType>, Native.ComparableLower, 
        simplify_type, FoldingSetTrait.Profilable {
  // Thankfully, these are efficiently composable.
  private final PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/> Value;
  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getExtQualsUnsafe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 603,
   FQN="clang::QualType::getExtQualsUnsafe", NM="_ZNK5clang8QualType17getExtQualsUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType17getExtQualsUnsafeEv")
  //</editor-fold>
  /*friend*/final protected/*private*/ /*const*/ ExtQuals /*P*/ getExtQualsUnsafe() /*const*/ {
    return Value.getPointer().get(/*const*/ ExtQuals /*P*/ .class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getTypePtrUnsafe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 607,
   FQN="clang::QualType::getTypePtrUnsafe", NM="_ZNK5clang8QualType16getTypePtrUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16getTypePtrUnsafeEv")
  //</editor-fold>
  /*friend*/final protected/*private*/ /*const*/ Type /*P*/ getTypePtrUnsafe() /*const*/ {
    return Value.getPointer().get(/*const*/ Type /*P*/ .class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getCommonPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 611,
   FQN="clang::QualType::getCommonPtr", NM="_ZNK5clang8QualType12getCommonPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType12getCommonPtrEv")
  //</editor-fold>
  private /*const*/ ExtQualsTypeCommonBase /*P*/ getCommonPtr() /*const*/ {
    assert (!isNull()) : "Cannot retrieve a NULL type pointer";
    PointerUnion<Type, ExtQuals> pointer = Value.getPointer();
//    Object/*uintptr_t*/ CommonPtrVal = reinterpret_cast_Object/*uintptr_t*/(Value.getOpaqueValue());
//    CommonPtrVal &= ~(Object/*uintptr_t*/)((1 << TypeAlignmentInBits) - 1);    
    return reinterpret_cast(ExtQualsTypeCommonBase /*P*/ .class, pointer.getOpaqueValue());
  }

  
  /*friend  class QualifierCollector*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::QualType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*inititalization*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 621,
   FQN="clang::QualType::QualType", NM="_ZN5clang8QualTypeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeC1Ev")
  //</editor-fold>
  public QualType() {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>(
            new PointerUnion(Type.class)
    );
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::QualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 623,
   FQN="clang::QualType::QualType", NM="_ZN5clang8QualTypeC1EPKNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeC1EPKNS_4TypeEj")
  //</editor-fold>
  public QualType(/*const*/ Type /*P*/ Ptr, /*uint*/int Quals) {
    // : Value(Ptr, Quals) 
    //START JInit
    this.Value = new PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>(new PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >(JD$T.INSTANCE, /*const*/ Type /*P*/ .class, Ptr), Quals);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::QualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 625,
   FQN="clang::QualType::QualType", NM="_ZN5clang8QualTypeC1EPKNS_8ExtQualsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeC1EPKNS_8ExtQualsEj")
  //</editor-fold>
  public QualType(/*const*/ ExtQuals /*P*/ Ptr, /*uint*/int Quals) {
    // : Value(Ptr, Quals) 
    //START JInit
    this.Value = new PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>(new PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >(JD$T1.INSTANCE, /*const*/ ExtQuals /*P*/ .class, Ptr), Quals);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getLocalFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 628,
   FQN="clang::QualType::getLocalFastQualifiers", NM="_ZNK5clang8QualType22getLocalFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType22getLocalFastQualifiersEv")
  //</editor-fold>
  public /*uint*/int getLocalFastQualifiers() /*const*/ {
    return Value.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::setLocalFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 629,
   FQN="clang::QualType::setLocalFastQualifiers", NM="_ZN5clang8QualType22setLocalFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType22setLocalFastQualifiersEj")
  //</editor-fold>
  public void setLocalFastQualifiers(/*uint*/int Quals) {
    Value.setInt(Quals);
  }

  
  /// Retrieves a pointer to the underlying (unqualified) type.
  ///
  /// This function requires that the type not be NULL. If the type might be
  /// NULL, use the (slightly less efficient) \c getTypePtrOrNull().
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getTypePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5259,
   FQN="clang::QualType::getTypePtr", NM="_ZNK5clang8QualType10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType10getTypePtrEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Type /*P*/ getTypePtr() /*const*/ {
    return getCommonPtr().BaseType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getTypePtrOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5263,
   FQN="clang::QualType::getTypePtrOrNull", NM="_ZNK5clang8QualType16getTypePtrOrNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16getTypePtrOrNullEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Type /*P*/ getTypePtrOrNull() /*const*/ {
    return (isNull() ? null : getCommonPtr().BaseType);
  }

  
  /// Retrieves a pointer to the name of the base type.
  
  /// Retrieves a pointer to the name of the base type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getBaseTypeIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 47,
   FQN="clang::QualType::getBaseTypeIdentifier", NM="_ZNK5clang8QualType21getBaseTypeIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType21getBaseTypeIdentifierEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getBaseTypeIdentifier() /*const*/ {
    /*const*/ Type /*P*/ ty = getTypePtr();
    NamedDecl /*P*/ ND = null;
    if (ty.isPointerType() || ty.isReferenceType()) {
      return ty.getPointeeType().getBaseTypeIdentifier();
    } else if (ty.isRecordType()) {
      ND = ty.<RecordType>getAs$RecordType().getDecl();
    } else if (ty.isEnumeralType()) {
      ND = ty.<EnumType>getAs$EnumType().getDecl();
    } else if (ty.getTypeClass() == Type.TypeClass.Typedef) {
      ND = ty.<TypedefType>getAs$TypedefType().getDecl();
    } else if (ty.isArrayType()) {
      return ty.castAsArrayTypeUnsafe().
          getElementType().getBaseTypeIdentifier();
    }
    if ((ND != null)) {
      return ND.getIdentifier();
    }
    return null;
  }


  
  /// Divides a QualType into its unqualified type and a set of local
  /// qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::split">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5267,
   FQN="clang::QualType::split", NM="_ZNK5clang8QualType5splitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType5splitEv")
  //</editor-fold>
  public /*inline*/ SplitQualType split() /*const*/ {
    if (!hasLocalNonFastQualifiers()) {
      return new SplitQualType(getTypePtrUnsafe(), 
          Qualifiers.fromFastMask(getLocalFastQualifiers()));
    }
    
    /*const*/ ExtQuals /*P*/ eq = getExtQualsUnsafe();
    Qualifiers qs = eq.getQualifiers();
    qs.addFastQualifiers(getLocalFastQualifiers());
    return new SplitQualType(eq.getBaseType(), new Qualifiers(qs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*see contract in TypeLoc!!!*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 646,
   FQN="clang::QualType::getAsOpaquePtr", NM="_ZNK5clang8QualType14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    // JAVA: try to emulate contract expected by TypeLoc:
    // The correctness of this relies on the property that, for Type *Ty,
    //   QualType(Ty, 0).getAsOpaquePtr() == (void*) Ty       
    if (Value.getInt() == 0) {
      PointerUnion<Type, ExtQuals> Ptr = Value.getPointer();
      return Ptr == null || Ptr.isNull() ? null : Ptr.getOpaqueValue();
    } else if (Value.getInt() == DUMMY_QUAL_TYPE_VALUE) {
      return DUMMY_QUAL_TYPE_OPAQUE_VALUE;
    } else {
      return Value.getOpaqueValue();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getFromOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*see contract in TypeLoc!!!*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 647,
   FQN="clang::QualType::getFromOpaquePtr", NM="_ZN5clang8QualType16getFromOpaquePtrEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType16getFromOpaquePtrEPKv")
  //</editor-fold>
  public static QualType getFromOpaquePtr(/*const*/Object/*void P*/ Ptr) {
    QualType T/*J*/= new QualType();
    // JAVA: try to emulate contract expected by TypeLoc:
    // The correctness of this relies on the property that, for Type *Ty,
    //   QualType(Ty, 0).getAsOpaquePtr() == (void*) Ty    
    if (Ptr == null || Ptr instanceof Type) {
      T.Value.initWithPointer(new PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >(JD$T.INSTANCE, /*const*/ Type /*P*/ .class, (Type) Ptr));
    } else if (Ptr instanceof ExtQuals) {
      T.Value.initWithPointer(new PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >(JD$T1.INSTANCE, /*const*/ ExtQuals /*P*/ .class, (ExtQuals) Ptr));
    } else if (Ptr == DUMMY_QUAL_TYPE_OPAQUE_VALUE) {
      T.Value.initWithPointer(new PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >(JD$T.INSTANCE, /*const*/ Type /*P*/ .class, (Type) null));
      T.Value.setInt(DUMMY_QUAL_TYPE_VALUE);
    } else {
      T.Value.setFromOpaqueValue(((/*const_cast*/Object/*void P*/ )(Ptr)));
    }
    return T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 653,
   FQN="clang::QualType::operator*", NM="_ZNK5clang8QualTypedeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualTypedeEv")
  //</editor-fold>
  public /*const*/ Type /*&*/ $star() /*const*/ {
    return $Deref(getTypePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 657,
   FQN="clang::QualType::operator->", NM="_ZNK5clang8QualTypeptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualTypeptEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ $arrow() /*const*/ {
    return getTypePtr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isCanonical">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5303,
   FQN="clang::QualType::isCanonical", NM="_ZNK5clang8QualType11isCanonicalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType11isCanonicalEv")
  //</editor-fold>
  public /*inline*/ boolean isCanonical() /*const*/ {
    return getTypePtr().isCanonicalUnqualified();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isCanonicalAsParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5307,
   FQN="clang::QualType::isCanonicalAsParam", NM="_ZNK5clang8QualType18isCanonicalAsParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType18isCanonicalAsParamEv")
  //</editor-fold>
  public /*inline*/ boolean isCanonicalAsParam() /*const*/ {
    if (!isCanonical()) {
      return false;
    }
    if (hasLocalQualifiers()) {
      return false;
    }
    
    /*const*/ Type /*P*/ T = getTypePtr();
    if (T.isVariablyModifiedType() && T.hasSizedVLAType()) {
      return false;
    }
    
    return !isa_FunctionType(T) && !isa_ArrayType(T);
  }

  
  /// Return true if this QualType doesn't point to a type yet.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 665,
   FQN="clang::QualType::isNull", NM="_ZNK5clang8QualType6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    PointerUnion<Type, ExtQuals> pointer = Value.getPointer();
    return pointer == null || pointer.isNull();
  }

  
  /// \brief Determine whether this particular QualType instance has the
  /// "const" qualifier set, without looking through typedefs that may have
  /// added "const" at a different level.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isLocalConstQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 672,
   FQN="clang::QualType::isLocalConstQualified", NM="_ZNK5clang8QualType21isLocalConstQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType21isLocalConstQualifiedEv")
  //</editor-fold>
  public boolean isLocalConstQualified() /*const*/ {
    return ((getLocalFastQualifiers() & Qualifiers.TQ.Const) != 0);
  }

  
  /// \brief Determine whether this type is const-qualified.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isConstQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5318,
   FQN="clang::QualType::isConstQualified", NM="_ZNK5clang8QualType16isConstQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16isConstQualifiedEv")
  //</editor-fold>
  public /*inline*/ boolean isConstQualified() /*const*/ {
    return isLocalConstQualified()
       || getCommonPtr().CanonicalType.isLocalConstQualified();
  }

  
  /// \brief Determine whether this particular QualType instance has the
  /// "restrict" qualifier set, without looking through typedefs that may have
  /// added "restrict" at a different level.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isLocalRestrictQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 682,
   FQN="clang::QualType::isLocalRestrictQualified", NM="_ZNK5clang8QualType24isLocalRestrictQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType24isLocalRestrictQualifiedEv")
  //</editor-fold>
  public boolean isLocalRestrictQualified() /*const*/ {
    return ((getLocalFastQualifiers() & Qualifiers.TQ.Restrict) != 0);
  }

  
  /// \brief Determine whether this type is restrict-qualified.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isRestrictQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5323,
   FQN="clang::QualType::isRestrictQualified", NM="_ZNK5clang8QualType19isRestrictQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType19isRestrictQualifiedEv")
  //</editor-fold>
  public /*inline*/ boolean isRestrictQualified() /*const*/ {
    return isLocalRestrictQualified()
       || getCommonPtr().CanonicalType.isLocalRestrictQualified();
  }

  
  /// \brief Determine whether this particular QualType instance has the
  /// "volatile" qualifier set, without looking through typedefs that may have
  /// added "volatile" at a different level.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isLocalVolatileQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 692,
   FQN="clang::QualType::isLocalVolatileQualified", NM="_ZNK5clang8QualType24isLocalVolatileQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType24isLocalVolatileQualifiedEv")
  //</editor-fold>
  public boolean isLocalVolatileQualified() /*const*/ {
    return ((getLocalFastQualifiers() & Qualifiers.TQ.Volatile) != 0);
  }

  
  /// \brief Determine whether this type is volatile-qualified.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isVolatileQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5329,
   FQN="clang::QualType::isVolatileQualified", NM="_ZNK5clang8QualType19isVolatileQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType19isVolatileQualifiedEv")
  //</editor-fold>
  public /*inline*/ boolean isVolatileQualified() /*const*/ {
    return isLocalVolatileQualified()
       || getCommonPtr().CanonicalType.isLocalVolatileQualified();
  }

  
  /// \brief Determine whether this particular QualType instance has any
  /// qualifiers, without looking through any typedefs that might add
  /// qualifiers at a different level.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::hasLocalQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 702,
   FQN="clang::QualType::hasLocalQualifiers", NM="_ZNK5clang8QualType18hasLocalQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType18hasLocalQualifiersEv")
  //</editor-fold>
  public boolean hasLocalQualifiers() /*const*/ {
    return (getLocalFastQualifiers() != 0) || hasLocalNonFastQualifiers();
  }

  
  /// \brief Determine whether this type has any qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::hasQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5334,
   FQN="clang::QualType::hasQualifiers", NM="_ZNK5clang8QualType13hasQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType13hasQualifiersEv")
  //</editor-fold>
  public /*inline*/ boolean hasQualifiers() /*const*/ {
    return hasLocalQualifiers()
       || getCommonPtr().CanonicalType.hasLocalQualifiers();
  }

  
  /// \brief Determine whether this particular QualType instance has any
  /// "non-fast" qualifiers, e.g., those that are stored in an ExtQualType
  /// instance.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::hasLocalNonFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 712,
   FQN="clang::QualType::hasLocalNonFastQualifiers", NM="_ZNK5clang8QualType25hasLocalNonFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType25hasLocalNonFastQualifiersEv")
  //</editor-fold>
  public boolean hasLocalNonFastQualifiers() /*const*/ {
    return (Value.getPointer().is(/*const*/ ExtQuals /*P*/ .class) != 0);
  }

  
  /// \brief Retrieve the set of qualifiers local to this particular QualType
  /// instance, not including any qualifiers acquired through typedefs or
  /// other sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getLocalQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5278,
   FQN="clang::QualType::getLocalQualifiers", NM="_ZNK5clang8QualType18getLocalQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType18getLocalQualifiersEv")
  //</editor-fold>
  public /*inline*/ Qualifiers getLocalQualifiers() /*const*/ {
    Qualifiers Quals/*J*/= new Qualifiers();
    if (hasLocalNonFastQualifiers()) {
      Quals.$assignMove(getExtQualsUnsafe().getQualifiers());
    }
    Quals.addFastQualifiers(getLocalFastQualifiers());
    return Quals;
  }

  
  /// \brief Retrieve the set of qualifiers applied to this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5286,
   FQN="clang::QualType::getQualifiers", NM="_ZNK5clang8QualType13getQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType13getQualifiersEv")
  //</editor-fold>
  public /*inline*/ Qualifiers getQualifiers() /*const*/ {
    Qualifiers quals = getCommonPtr().CanonicalType.getLocalQualifiers();
    quals.addFastQualifiers(getLocalFastQualifiers());
    return quals;
  }

  
  /// \brief Retrieve the set of CVR (const-volatile-restrict) qualifiers
  /// local to this particular QualType instance, not including any qualifiers
  /// acquired through typedefs or other sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getLocalCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 727,
   FQN="clang::QualType::getLocalCVRQualifiers", NM="_ZNK5clang8QualType21getLocalCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType21getLocalCVRQualifiersEv")
  //</editor-fold>
  public /*uint*/int getLocalCVRQualifiers() /*const*/ {
    return getLocalFastQualifiers();
  }

  
  /// \brief Retrieve the set of CVR (const-volatile-restrict) qualifiers
  /// applied to this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5292,
   FQN="clang::QualType::getCVRQualifiers", NM="_ZNK5clang8QualType16getCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16getCVRQualifiersEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getCVRQualifiers() /*const*/ {
    /*uint*/int cvr = getCommonPtr().CanonicalType.getLocalCVRQualifiers();
    cvr |= getLocalCVRQualifiers();
    return cvr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 735,
   FQN="clang::QualType::isConstant", NM="_ZNK5clang8QualType10isConstantERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType10isConstantERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isConstant(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return QualType.isConstant(new QualType(/*Deref*/this), Ctx);
  }

  
  /// \brief Determine whether this is a Plain Old Data (POD) type (C++ 3.9p10).
  
  /// \brief Determine whether this is a Plain Old Data (POD) type (C++ 3.9p10).
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isPODType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1967,
   FQN="clang::QualType::isPODType", NM="_ZNK5clang8QualType9isPODTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType9isPODTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isPODType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    // C++11 has a more relaxed definition of POD.
    if (Context.getLangOpts().CPlusPlus11) {
      return isCXX11PODType(Context);
    }
    
    return isCXX98PODType(Context);
  }


  
  /// Return true if this is a POD type according to the rules of the C++98
  /// standard, regardless of the current compilation's language.
  
  /// Return true if this is a POD type according to the rules of the C++98
  /// standard, regardless of the current compilation's language.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isCXX98PODType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1975,
   FQN="clang::QualType::isCXX98PODType", NM="_ZNK5clang8QualType14isCXX98PODTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType14isCXX98PODTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isCXX98PODType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    // The compiler shouldn't query this for incomplete types, but the user might.
    // We return false for that case. Except for incomplete arrays of PODs, which
    // are PODs according to the standard.
    if (isNull()) {
      return false;
    }
    if ((/*Deref*/this).$arrow().isIncompleteArrayType()) {
      return Context.getBaseElementType(new QualType(/*Deref*/this)).isCXX98PODType(Context);
    }
    if ((/*Deref*/this).$arrow().isIncompleteType()) {
      return false;
    }
    if (Context.getLangOpts().ObjCAutoRefCount) {
      switch (getObjCLifetime()) {
       case OCL_ExplicitNone:
        return true;
       case OCL_Strong:
       case OCL_Weak:
       case OCL_Autoreleasing:
        return false;
       case OCL_None:
        break;
      }
    }

    QualType CanonicalType = new QualType(getTypePtr().CanonicalType);
    switch (CanonicalType.$arrow().getTypeClass()) {
     default:
      // Everything not explicitly mentioned is not POD.
      return false;
     case VariableArray:
     case ConstantArray:
      // IncompleteArray is handled above.
      return Context.getBaseElementType(new QualType(/*Deref*/this)).isCXX98PODType(Context);
     case ObjCObjectPointer:
     case BlockPointer:
     case Builtin:
     case Complex:
     case Pointer:
     case MemberPointer:
     case Vector:
     case ExtVector:
      return true;
     case Enum:
      return true;
     case Record:
      {
        CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(cast_RecordType(CanonicalType).getDecl());
        if ((ClassDecl != null)) {
          return ClassDecl.isPOD();
        }
      }
      
      // C struct/union is POD.
      return true;
    }
  }


  
  /// Return true if this is a POD type according to the more relaxed rules
  /// of the C++11 standard, regardless of the current compilation's language.
  /// (C++0x [basic.types]p9)
  
  /// Return true if this is a POD type according to the more relaxed rules
  /// of the C++11 standard, regardless of the current compilation's language.
  /// (C++0x [basic.types]p9)
  
  // This is effectively the intersection of isTrivialType and
  // isStandardLayoutType. We implement it directly to avoid redundant
  // conversions from a type to a CXXRecordDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isCXX11PODType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2258,
   FQN="clang::QualType::isCXX11PODType", NM="_ZNK5clang8QualType14isCXX11PODTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType14isCXX11PODTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isCXX11PODType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    /*const*/ Type /*P*/ ty = getTypePtr();
    if (ty.isDependentType()) {
      return false;
    }
    if (Context.getLangOpts().ObjCAutoRefCount) {
      switch (getObjCLifetime()) {
       case OCL_ExplicitNone:
        return true;
       case OCL_Strong:
       case OCL_Weak:
       case OCL_Autoreleasing:
        return false;
       case OCL_None:
        break;
      }
    }
    
    // C++11 [basic.types]p9:
    //   Scalar types, POD classes, arrays of such types, and cv-qualified
    //   versions of these types are collectively called trivial types.
    /*const*/ Type /*P*/ BaseTy = ty.getBaseElementTypeUnsafe();
    assert ((BaseTy != null)) : "NULL element type";
    
    // Return false for incomplete types after skipping any incomplete array
    // types which are expressly allowed by the standard and thus our API.
    if (BaseTy.isIncompleteType()) {
      return false;
    }
    
    // As an extension, Clang treats vector types as Scalar types.
    if (BaseTy.isScalarType() || BaseTy.isVectorType()) {
      return true;
    }
    {
      /*const*/ RecordType /*P*/ RT = BaseTy.<RecordType>getAs$RecordType();
      if ((RT != null)) {
        {
          /*const*/ CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(RT.getDecl());
          if ((ClassDecl != null)) {
            // C++11 [class]p10:
            //   A POD struct is a non-union class that is both a trivial class [...]
            if (!ClassDecl.isTrivial()) {
              return false;
            }
            
            // C++11 [class]p10:
            //   A POD struct is a non-union class that is both a trivial class and
            //   a standard-layout class [...]
            if (!ClassDecl.isStandardLayout()) {
              return false;
            }
            // C++11 [class]p10:
            //   A POD struct is a non-union class that is both a trivial class and
            //   a standard-layout class, and has no non-static data members of type
            //   non-POD struct, non-POD union (or array of such types). [...]
            //
            // We don't directly query the recursive aspect as the requirements for
            // both standard-layout classes and trivial classes apply recursively
            // already.
          }
        }
        
        return true;
      }
    }
    
    // No other types can match.
    return false;
  }


  
  /// Return true if this is a trivial type per (C++0x [basic.types]p9)
  
  /// Return true if this is a trivial type per (C++0x [basic.types]p9)
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isTrivialType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2035,
   FQN="clang::QualType::isTrivialType", NM="_ZNK5clang8QualType13isTrivialTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType13isTrivialTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isTrivialType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    // The compiler shouldn't query this for incomplete types, but the user might.
    // We return false for that case. Except for incomplete arrays of PODs, which
    // are PODs according to the standard.
    if (isNull()) {
      return false;
    }
    if ((/*Deref*/this).$arrow().isArrayType()) {
      return Context.getBaseElementType(new QualType(/*Deref*/this)).isTrivialType(Context);
    }
    
    // Return false for incomplete types after skipping any incomplete array
    // types which are expressly allowed by the standard and thus our API.
    if ((/*Deref*/this).$arrow().isIncompleteType()) {
      return false;
    }
    if (Context.getLangOpts().ObjCAutoRefCount) {
      switch (getObjCLifetime()) {
       case OCL_ExplicitNone:
        return true;
       case OCL_Strong:
       case OCL_Weak:
       case OCL_Autoreleasing:
        return false;
       case OCL_None:
        if ((/*Deref*/this).$arrow().isObjCLifetimeType()) {
          return false;
        }
        break;
      }
    }
    
    QualType CanonicalType = new QualType(getTypePtr().CanonicalType);
    if (CanonicalType.$arrow().isDependentType()) {
      return false;
    }
    
    // C++0x [basic.types]p9:
    //   Scalar types, trivial class types, arrays of such types, and
    //   cv-qualified versions of these types are collectively called trivial
    //   types.
    
    // As an extension, Clang treats vector types as Scalar types.
    if (CanonicalType.$arrow().isScalarType() || CanonicalType.$arrow().isVectorType()) {
      return true;
    }
    {
      /*const*/ RecordType /*P*/ RT = CanonicalType.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        {
          /*const*/ CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(RT.getDecl());
          if ((ClassDecl != null)) {
            // C++11 [class]p6:
            //   A trivial class is a class that has a default constructor,
            //   has no non-trivial default constructors, and is trivially
            //   copyable.
            return ClassDecl.hasDefaultConstructor()
               && !ClassDecl.hasNonTrivialDefaultConstructor()
               && ClassDecl.isTriviallyCopyable();
          }
        }
        
        return true;
      }
    }
    
    // No other types can match.
    return false;
  }


  
  /// Return true if this is a trivially copyable type (C++0x [basic.types]p9)
  
  /// Return true if this is a trivially copyable type (C++0x [basic.types]p9)
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isTriviallyCopyableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2098,
   FQN="clang::QualType::isTriviallyCopyableType", NM="_ZNK5clang8QualType23isTriviallyCopyableTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType23isTriviallyCopyableTypeERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isTriviallyCopyableType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    if ((/*Deref*/this).$arrow().isArrayType()) {
      return Context.getBaseElementType(new QualType(/*Deref*/this)).isTriviallyCopyableType(Context);
    }
    if (Context.getLangOpts().ObjCAutoRefCount) {
      switch (getObjCLifetime()) {
       case OCL_ExplicitNone:
        return true;
       case OCL_Strong:
       case OCL_Weak:
       case OCL_Autoreleasing:
        return false;
       case OCL_None:
        if ((/*Deref*/this).$arrow().isObjCLifetimeType()) {
          return false;
        }
        break;
      }
    }
    
    // C++11 [basic.types]p9
    //   Scalar types, trivially copyable class types, arrays of such types, and
    //   non-volatile const-qualified versions of these types are collectively
    //   called trivially copyable types.
    QualType CanonicalType = getCanonicalType();
    if (CanonicalType.$arrow().isDependentType()) {
      return false;
    }
    if (CanonicalType.isVolatileQualified()) {
      return false;
    }
    
    // Return false for incomplete types after skipping any incomplete array types
    // which are expressly allowed by the standard and thus our API.
    if (CanonicalType.$arrow().isIncompleteType()) {
      return false;
    }
    
    // As an extension, Clang treats vector types as Scalar types.
    if (CanonicalType.$arrow().isScalarType() || CanonicalType.$arrow().isVectorType()) {
      return true;
    }
    {
      
      /*const*/ RecordType /*P*/ RT = CanonicalType.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        {
          /*const*/ CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(RT.getDecl());
          if ((ClassDecl != null)) {
            if (!ClassDecl.isTriviallyCopyable()) {
              return false;
            }
          }
        }
        
        return true;
      }
    }
    
    // No other types can match.
    return false;
  }


  
  // Don't promise in the API that anything besides 'const' can be
  // easily added.
  
  /// Add the `const` type qualifier to this QualType.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::addConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 761,
   FQN="clang::QualType::addConst", NM="_ZN5clang8QualType8addConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType8addConstEv")
  //</editor-fold>
  public void addConst() {
    addFastQualifiers(Qualifiers.TQ.Const);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 764,
   FQN="clang::QualType::withConst", NM="_ZNK5clang8QualType9withConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType9withConstEv")
  //</editor-fold>
  public QualType withConst() /*const*/ {
    return withFastQualifiers(Qualifiers.TQ.Const);
  }

  
  /// Add the `volatile` type qualifier to this QualType.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::addVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 769,
   FQN="clang::QualType::addVolatile", NM="_ZN5clang8QualType11addVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType11addVolatileEv")
  //</editor-fold>
  public void addVolatile() {
    addFastQualifiers(Qualifiers.TQ.Volatile);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 772,
   FQN="clang::QualType::withVolatile", NM="_ZNK5clang8QualType12withVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType12withVolatileEv")
  //</editor-fold>
  public QualType withVolatile() /*const*/ {
    return withFastQualifiers(Qualifiers.TQ.Volatile);
  }

  
  /// Add the `restrict` qualifier to this QualType.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::addRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 777,
   FQN="clang::QualType::addRestrict", NM="_ZN5clang8QualType11addRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType11addRestrictEv")
  //</editor-fold>
  public void addRestrict() {
    addFastQualifiers(Qualifiers.TQ.Restrict);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 780,
   FQN="clang::QualType::withRestrict", NM="_ZNK5clang8QualType12withRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType12withRestrictEv")
  //</editor-fold>
  public QualType withRestrict() /*const*/ {
    return withFastQualifiers(Qualifiers.TQ.Restrict);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 784,
   FQN="clang::QualType::withCVRQualifiers", NM="_ZNK5clang8QualType17withCVRQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType17withCVRQualifiersEj")
  //</editor-fold>
  public QualType withCVRQualifiers(/*uint*/int CVR) /*const*/ {
    return withFastQualifiers(CVR);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::addFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 788,
   FQN="clang::QualType::addFastQualifiers", NM="_ZN5clang8QualType17addFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType17addFastQualifiersEj")
  //</editor-fold>
  public void addFastQualifiers(/*uint*/int TQs) {
    assert (!((TQs & ~Qualifiers.FastMask) != 0)) : "non-fast qualifier bits set in mask!";
    Value.setInt(Value.getInt() | TQs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::removeLocalConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5353,
   FQN="clang::QualType::removeLocalConst", NM="_ZN5clang8QualType16removeLocalConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType16removeLocalConstEv")
  //</editor-fold>
  public /*inline*/ void removeLocalConst() {
    removeLocalFastQualifiers(Qualifiers.TQ.Const);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::removeLocalVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5361,
   FQN="clang::QualType::removeLocalVolatile", NM="_ZN5clang8QualType19removeLocalVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType19removeLocalVolatileEv")
  //</editor-fold>
  public /*inline*/ void removeLocalVolatile() {
    removeLocalFastQualifiers(Qualifiers.TQ.Volatile);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::removeLocalRestrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5357,
   FQN="clang::QualType::removeLocalRestrict", NM="_ZN5clang8QualType19removeLocalRestrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType19removeLocalRestrictEv")
  //</editor-fold>
  public /*inline*/ void removeLocalRestrict() {
    removeLocalFastQualifiers(Qualifiers.TQ.Restrict);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::removeLocalCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5365,
   FQN="clang::QualType::removeLocalCVRQualifiers", NM="_ZN5clang8QualType24removeLocalCVRQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType24removeLocalCVRQualifiersEj")
  //</editor-fold>
  public /*inline*/ void removeLocalCVRQualifiers(/*uint*/int Mask) {
    assert (!((Mask & ~Qualifiers.TQ.CVRMask) != 0)) : "mask has non-CVR bits";
    static_assert((int)Qualifiers.TQ.CVRMask == (int)Qualifiers.FastMask, $("Fast bits differ from CVR bits!"));
    
    // Fast path: we don't need to touch the slow qualifiers.
    removeLocalFastQualifiers(Mask);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::removeLocalFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 799,
   FQN="clang::QualType::removeLocalFastQualifiers", NM="_ZN5clang8QualType25removeLocalFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType25removeLocalFastQualifiersEv")
  //</editor-fold>
  public void removeLocalFastQualifiers() {
    Value.setInt(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::removeLocalFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 800,
   FQN="clang::QualType::removeLocalFastQualifiers", NM="_ZN5clang8QualType25removeLocalFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType25removeLocalFastQualifiersEj")
  //</editor-fold>
  public void removeLocalFastQualifiers(/*uint*/int Mask) {
    assert (!((Mask & ~Qualifiers.FastMask) != 0)) : "mask has non-fast qualifiers";
    Value.setInt(Value.getInt() & ~Mask);
  }

  
  // Creates a type with the given qualifiers in addition to any
  // qualifiers already on this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 807,
   FQN="clang::QualType::withFastQualifiers", NM="_ZNK5clang8QualType18withFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType18withFastQualifiersEj")
  //</editor-fold>
  public QualType withFastQualifiers(/*uint*/int TQs) /*const*/ {
    QualType T = new QualType(/*Deref*/this);
    T.addFastQualifiers(TQs);
    return T;
  }

  
  // Creates a type with exactly the given fast qualifiers, removing
  // any existing fast qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withExactLocalFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 815,
   FQN="clang::QualType::withExactLocalFastQualifiers", NM="_ZNK5clang8QualType28withExactLocalFastQualifiersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType28withExactLocalFastQualifiersEj")
  //</editor-fold>
  public QualType withExactLocalFastQualifiers(/*uint*/int TQs) /*const*/ {
    return withoutLocalFastQualifiers().withFastQualifiers(TQs);
  }

  
  // Removes fast qualifiers, but leaves any extended qualifiers in place.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::withoutLocalFastQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 820,
   FQN="clang::QualType::withoutLocalFastQualifiers", NM="_ZNK5clang8QualType26withoutLocalFastQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType26withoutLocalFastQualifiersEv")
  //</editor-fold>
  public QualType withoutLocalFastQualifiers() /*const*/ {
    QualType T = new QualType(/*Deref*/this);
    T.removeLocalFastQualifiers();
    return T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getCanonicalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5298,
   FQN="clang::QualType::getCanonicalType", NM="_ZNK5clang8QualType16getCanonicalTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16getCanonicalTypeEv")
  //</editor-fold>
  public /*inline*/ QualType getCanonicalType() /*const*/ {
    QualType canon = new QualType(getCommonPtr().CanonicalType);
    return canon.withFastQualifiers(getLocalFastQualifiers());
  }

  
  /// \brief Return this type with all of the instance-specific qualifiers
  /// removed, but without removing any qualifiers that may have been applied
  /// through typedefs.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getLocalUnqualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 831,
   FQN="clang::QualType::getLocalUnqualifiedType", NM="_ZNK5clang8QualType23getLocalUnqualifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType23getLocalUnqualifiedTypeEv")
  //</editor-fold>
  public QualType getLocalUnqualifiedType() /*const*/ {
    return new QualType(getTypePtr(), 0);
  }

  
  /// \brief Retrieve the unqualified variant of the given type,
  /// removing as little sugar as possible.
  ///
  /// This routine looks through various kinds of sugar to find the
  /// least-desugared type that is unqualified. For example, given:
  ///
  /// \code
  /// typedef int Integer;
  /// typedef const Integer CInteger;
  /// typedef CInteger DifferenceType;
  /// \endcode
  ///
  /// Executing \c getUnqualifiedType() on the type \c DifferenceType will
  /// desugar until we hit the type \c Integer, which has no qualifiers on it.
  ///
  /// The resulting type might still be qualified if it's sugar for an array
  /// type.  To strip qualifiers even from within a sugared array type, use
  /// ASTContext::getUnqualifiedArrayType.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getUnqualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5339,
   FQN="clang::QualType::getUnqualifiedType", NM="_ZNK5clang8QualType18getUnqualifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType18getUnqualifiedTypeEv")
  //</editor-fold>
  public /*inline*/ QualType getUnqualifiedType() /*const*/ {
    if (!getTypePtr().getCanonicalTypeInternal().hasLocalQualifiers()) {
      return new QualType(getTypePtr(), 0);
    }
    
    return new QualType(getSplitUnqualifiedTypeImpl(new QualType(/*Deref*/this)).Ty, 0);
  }

  
  /// Retrieve the unqualified variant of the given type, removing as little
  /// sugar as possible.
  ///
  /// Like getUnqualifiedType(), but also returns the set of
  /// qualifiers that were built up.
  ///
  /// The resulting type might still be qualified if it's sugar for an array
  /// type.  To strip qualifiers even from within a sugared array type, use
  /// ASTContext::getUnqualifiedArrayType.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getSplitUnqualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5346,
   FQN="clang::QualType::getSplitUnqualifiedType", NM="_ZNK5clang8QualType23getSplitUnqualifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType23getSplitUnqualifiedTypeEv")
  //</editor-fold>
  public /*inline*/ SplitQualType getSplitUnqualifiedType() /*const*/ {
    if (!getTypePtr().getCanonicalTypeInternal().hasLocalQualifiers()) {
      return split();
    }
    
    return getSplitUnqualifiedTypeImpl(new QualType(/*Deref*/this));
  }

  
  /// \brief Determine whether this type is more qualified than the other
  /// given type, requiring exact equality for non-CVR qualifiers.
  
  /// Determine whether this type is more
  /// qualified than the Other type. For example, "const volatile int"
  /// is more qualified than "const int", "volatile int", and
  /// "int". However, it is not more qualified than "const volatile
  /// int".
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isMoreQualifiedThan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5403,
   FQN="clang::QualType::isMoreQualifiedThan", NM="_ZNK5clang8QualType19isMoreQualifiedThanES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType19isMoreQualifiedThanES0_")
  //</editor-fold>
  public /*inline*/ boolean isMoreQualifiedThan(QualType other) /*const*/ {
    Qualifiers MyQuals = getQualifiers();
    Qualifiers OtherQuals = other.getQualifiers();
    return (MyQuals.$noteq(/*NO_COPY*/OtherQuals) && MyQuals.compatiblyIncludes(new Qualifiers(OtherQuals)));
  }

  
  /// \brief Determine whether this type is at least as qualified as the other
  /// given type, requiring exact equality for non-CVR qualifiers.
  
  /// Determine whether this type is at last
  /// as qualified as the Other type. For example, "const volatile
  /// int" is at least as qualified as "const int", "volatile int",
  /// "int", and "const volatile int".
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isAtLeastAsQualifiedAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5413,
   FQN="clang::QualType::isAtLeastAsQualifiedAs", NM="_ZNK5clang8QualType22isAtLeastAsQualifiedAsES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType22isAtLeastAsQualifiedAsES0_")
  //</editor-fold>
  public /*inline*/ boolean isAtLeastAsQualifiedAs(QualType other) /*const*/ {
    Qualifiers OtherQuals = other.getQualifiers();
    
    // Ignore __unaligned qualifier if this type is a void.
    if (getUnqualifiedType().$arrow().isVoidType()) {
      OtherQuals.removeUnaligned();
    }
    
    return getQualifiers().compatiblyIncludes(new Qualifiers(OtherQuals));
  }

  
  
  /// If Type is a reference type (e.g., const
  /// int&), returns the type that the reference refers to ("const
  /// int"). Otherwise, returns the type itself. This routine is used
  /// throughout Sema to implement C++ 5p6:
  ///
  ///   If an expression initially has the type "reference to T" (8.3.2,
  ///   8.5.3), the type is adjusted to "T" prior to any further
  ///   analysis, the expression designates the object or function
  ///   denoted by the reference, and the expression is an lvalue.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getNonReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5432,
   FQN="clang::QualType::getNonReferenceType", NM="_ZNK5clang8QualType19getNonReferenceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType19getNonReferenceTypeEv")
  //</editor-fold>
  public /*inline*/ QualType getNonReferenceType() /*const*/ {
    {
      /*const*/ ReferenceType /*P*/ RefType = (/*Deref*/this).$arrow().getAs(ReferenceType.class);
      if ((RefType != null)) {
        return RefType.getPointeeType();
      } else {
        return new QualType(/*Deref*/this);
      }
    }
  }

  
  /// \brief Determine the type of a (typically non-lvalue) expression with the
  /// specified result type.
  ///
  /// This routine should be used for expressions for which the return type is
  /// explicitly specified (e.g., in a cast or call) and isn't necessarily
  /// an lvalue. It removes a top-level reference (since there are no
  /// expressions of reference type) and deletes top-level cvr-qualifiers
  /// from non-class types (in C++) or all types (in C).
  
  /// \brief Determine the type of a (typically non-lvalue) expression with the
  /// specified result type.
  ///
  /// This routine should be used for expressions for which the return type is
  /// explicitly specified (e.g., in a cast or call) and isn't necessarily
  /// an lvalue. It removes a top-level reference (since there are no
  /// expressions of reference type) and deletes top-level cvr-qualifiers
  /// from non-class types (in C++) or all types (in C).
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getNonLValueExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2615,
   FQN="clang::QualType::getNonLValueExprType", NM="_ZNK5clang8QualType20getNonLValueExprTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType20getNonLValueExprTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType getNonLValueExprType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    {
      /*const*/ ReferenceType /*P*/ RefType = getTypePtr().getAs(ReferenceType.class);
      if ((RefType != null)) {
        return RefType.getPointeeType();
      }
    }
    
    // C++0x [basic.lval]:
    //   Class prvalues can have cv-qualified types; non-class prvalues always 
    //   have cv-unqualified types.
    //
    // See also C99 6.3.2.1p2.
    if (!Context.getLangOpts().CPlusPlus
       || (!getTypePtr().isDependentType() && !getTypePtr().isRecordType())) {
      return getUnqualifiedType();
    }
    
    return new QualType(/*Deref*/this);
  }


  
  /// Return the specified type with any "sugar" removed from
  /// the type.  This takes off typedefs, typeof's etc.  If the outer level of
  /// the type is already concrete, it returns it unmodified.  This is similar
  /// to getting the canonical type, but it doesn't remove *all* typedefs.  For
  /// example, it returns "T*" as "T*", (not as "int*"), because the pointer is
  /// concrete.
  ///
  /// Qualifiers are left in place.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 892,
   FQN="clang::QualType::getDesugaredType", NM="_ZNK5clang8QualType16getDesugaredTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16getDesugaredTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType getDesugaredType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    return getDesugaredType(new QualType(/*Deref*/this), Context);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getSplitDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 896,
   FQN="clang::QualType::getSplitDesugaredType", NM="_ZNK5clang8QualType21getSplitDesugaredTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType21getSplitDesugaredTypeEv")
  //</editor-fold>
  public SplitQualType getSplitDesugaredType() /*const*/ {
    return getSplitDesugaredType(new QualType(/*Deref*/this));
  }

  
  /// \brief Return the specified type with one level of "sugar" removed from
  /// the type.
  ///
  /// This routine takes off the first typedef, typeof, etc. If the outer level
  /// of the type is already concrete, it returns it unmodified.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getSingleStepDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 905,
   FQN="clang::QualType::getSingleStepDesugaredType", NM="_ZNK5clang8QualType26getSingleStepDesugaredTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType26getSingleStepDesugaredTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType getSingleStepDesugaredType(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    return getSingleStepDesugaredTypeImpl(new QualType(/*Deref*/this), Context);
  }

  
  /// Returns the specified type after dropping any
  /// outer-level parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::IgnoreParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 911,
   FQN="clang::QualType::IgnoreParens", NM="_ZNK5clang8QualType12IgnoreParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType12IgnoreParensEv")
  //</editor-fold>
  public QualType IgnoreParens() /*const*/ {
    if (isa_ParenType(/*Deref*/this)) {
      return QualType.IgnoreParens(new QualType(/*Deref*/this));
    }
    return new QualType(/*Deref*/this);
  }

  
  /// Indicate whether the specified types and qualifiers are identical.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 918,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangeqERKNS_8QualTypeES2_")
  //</editor-fold>
  public static boolean $eq_QualType$C(final /*const*/ QualType /*&*/ LHS, final /*const*/ QualType /*&*/ RHS) {
    return LHS == RHS || LHS.Value.$eq(RHS.Value);
  }
  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 921,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangneERKNS_8QualTypeES2_")
  //</editor-fold>
  public static boolean $noteq_QualType$C(final /*const*/ QualType /*&*/ LHS, final /*const*/ QualType /*&*/ RHS) {
    return LHS.Value.$noteq(RHS.Value);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 924,
   FQN="clang::QualType::getAsString", NM="_ZNK5clang8QualType11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    return getAsString(split());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 927,
   FQN="clang::QualType::getAsString", NM="_ZN5clang8QualType11getAsStringENS_13SplitQualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType11getAsStringENS_13SplitQualTypeE")
  //</editor-fold>
  public static std.string getAsString(SplitQualType split) {
    return getAsString(split.Ty, new Qualifiers(split.Quals));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1649,
   FQN="clang::QualType::getAsString", NM="_ZN5clang8QualType11getAsStringEPKNS_4TypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang8QualType11getAsStringEPKNS_4TypeENS_10QualifiersE")
  //</editor-fold>
  public static std.string getAsString(/*const*/ Type /*P*/ ty, Qualifiers qs) {
    std.string buffer/*J*/= new std.string();
    LangOptions options/*J*/= new LangOptions();
    getAsStringInternal(ty, new Qualifiers(qs), buffer, new PrintingPolicy(options));
    return buffer;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1643,
   FQN="clang::QualType::getAsString", NM="_ZNK5clang8QualType11getAsStringERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZNK5clang8QualType11getAsStringERKNS_14PrintingPolicyE")
  //</editor-fold>
  public std.string getAsString(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    std.string S/*J*/= new std.string();
    getAsStringInternal(S, Policy);
    return S;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 934,
   FQN="clang::QualType::print", NM="_ZNK5clang8QualType5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyERKNS1_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyERKNS1_5TwineEj")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    print(OS, Policy, 
       new Twine(), 
       0);
  }
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, 
       final /*const*/ Twine /*&*/ PlaceHolder/*= Twine()*/) /*const*/ {
    print(OS, Policy, 
       PlaceHolder, 
       0);
  }
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, 
       final /*const*/ Twine /*&*/ PlaceHolder/*= Twine()*/, 
       /*uint*/int Indentation/*= 0*/) /*const*/ {
    print(split(), OS, Policy, PlaceHolder, Indentation);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 939,
   FQN="clang::QualType::print", NM="_ZN5clang8QualType5printENS_13SplitQualTypeERN4llvm11raw_ostreamERKNS_14PrintingPolicyERKNS2_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType5printENS_13SplitQualTypeERN4llvm11raw_ostreamERKNS_14PrintingPolicyERKNS2_5TwineEj")
  //</editor-fold>
  public static void print(SplitQualType split, final raw_ostream /*&*/ OS, 
       final /*const*/ PrintingPolicy /*&*/ policy, final /*const*/ Twine /*&*/ PlaceHolder) {
    print(split, OS, 
       policy, PlaceHolder, 
       0);
  }
  public static void print(SplitQualType split, final raw_ostream /*&*/ OS, 
       final /*const*/ PrintingPolicy /*&*/ policy, final /*const*/ Twine /*&*/ PlaceHolder, 
       /*uint*/int Indentation/*= 0*/) {
    print(split.Ty, new Qualifiers(split.Quals), OS, policy, PlaceHolder, Indentation);
    return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1656,
   FQN="clang::QualType::print", NM="_ZN5clang8QualType5printEPKNS_4TypeENS_10QualifiersERN4llvm11raw_ostreamERKNS_14PrintingPolicyERKNS5_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang8QualType5printEPKNS_4TypeENS_10QualifiersERN4llvm11raw_ostreamERKNS_14PrintingPolicyERKNS5_5TwineEj")
  //</editor-fold>
  public static void print(/*const*/ Type /*P*/ ty, Qualifiers qs, 
       final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ policy, 
       final /*const*/ Twine /*&*/ PlaceHolder) {
    print(ty, qs, 
       OS, policy, 
       PlaceHolder, 0);
  }
  public static void print(/*const*/ Type /*P*/ ty, Qualifiers qs, 
       final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ policy, 
       final /*const*/ Twine /*&*/ PlaceHolder, /*uint*/int Indentation/*= 0*/) {
    SmallString/*128*/ PHBuf/*J*/= new SmallString/*128*/(128);
    StringRef PH = PlaceHolder.toStringRef(PHBuf);
    
    new TypePrinter(policy, Indentation).print(ty, new Qualifiers(qs), OS, new StringRef(PH));
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsStringInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 949,
   FQN="clang::QualType::getAsStringInternal", NM="_ZNK5clang8QualType19getAsStringInternalERSsRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType19getAsStringInternalERSsRKNS_14PrintingPolicyE")
  //</editor-fold>
  public void getAsStringInternal(final std.string/*&*/ Str, 
                     final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    getAsStringInternal(split(), Str, Policy);
    return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsStringInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 953,
   FQN="clang::QualType::getAsStringInternal", NM="_ZN5clang8QualType19getAsStringInternalENS_13SplitQualTypeERSsRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType19getAsStringInternalENS_13SplitQualTypeERSsRKNS_14PrintingPolicyE")
  //</editor-fold>
  public static void getAsStringInternal(SplitQualType split, final std.string/*&*/ out, 
                     final /*const*/ PrintingPolicy /*&*/ policy) {
    getAsStringInternal(split.Ty, new Qualifiers(split.Quals), out, policy);
    return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAsStringInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1665,
   FQN="clang::QualType::getAsStringInternal", NM="_ZN5clang8QualType19getAsStringInternalEPKNS_4TypeENS_10QualifiersERSsRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang8QualType19getAsStringInternalEPKNS_4TypeENS_10QualifiersERSsRKNS_14PrintingPolicyE")
  //</editor-fold>
  public static void getAsStringInternal(/*const*/ Type /*P*/ ty, Qualifiers qs, 
                     final std.string/*&*/ buffer, 
                     final /*const*/ PrintingPolicy /*&*/ policy) {
    raw_svector_ostream StrOS = null;
    try {
      SmallString/*256*/ Buf/*J*/= new SmallString/*256*/(256);
      StrOS/*J*/= new raw_svector_ostream(Buf);
      new TypePrinter(policy).print(ty, new Qualifiers(qs), StrOS, new StringRef(buffer));
      std.string str = StrOS.str().$string();
      buffer.swap(str);
    } finally {
      if (StrOS != null) { StrOS.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::StreamedQualTypeHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 961,
   FQN="clang::QualType::StreamedQualTypeHelper", NM="_ZN5clang8QualType22StreamedQualTypeHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType22StreamedQualTypeHelperE")
  //</editor-fold>
  public static class StreamedQualTypeHelper {
    private final /*const*/ QualType /*&*/ T;
    private final /*const*/ PrintingPolicy /*&*/ Policy;
    private final /*const*/ Twine /*&*/ PlaceHolder;
    private /*uint*/int Indentation;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::QualType::StreamedQualTypeHelper::StreamedQualTypeHelper">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 967,
     FQN="clang::QualType::StreamedQualTypeHelper::StreamedQualTypeHelper", NM="_ZN5clang8QualType22StreamedQualTypeHelperC1ERKS0_RKNS_14PrintingPolicyERKN4llvm5TwineEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType22StreamedQualTypeHelperC1ERKS0_RKNS_14PrintingPolicyERKN4llvm5TwineEj")
    //</editor-fold>
    public StreamedQualTypeHelper(final /*const*/ QualType /*&*/ T, final /*const*/ PrintingPolicy /*&*/ Policy, 
        final /*const*/ Twine /*&*/ PlaceHolder, /*uint*/int Indentation) {
      // : T(T), Policy(Policy), PlaceHolder(PlaceHolder), Indentation(Indentation) 
      //START JInit
      this./*&*/T=/*&*/T;
      this./*&*/Policy=/*&*/Policy;
      this./*&*/PlaceHolder=/*&*/PlaceHolder;
      this.Indentation = Indentation;
      //END JInit
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 972,
     FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_8QualType22StreamedQualTypeHelperE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_8QualType22StreamedQualTypeHelperE")
    //</editor-fold>
    public static raw_ostream /*&*/ $out_raw_ostream_StreamedQualTypeHelper$C(final raw_ostream /*&*/ OS, 
                                             final /*const*/ StreamedQualTypeHelper /*&*/ SQT) {
      SQT.T.print(OS, SQT.Policy, SQT.PlaceHolder, SQT.Indentation);
      return OS;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::QualType::StreamedQualTypeHelper::StreamedQualTypeHelper">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 961,
     FQN="clang::QualType::StreamedQualTypeHelper::StreamedQualTypeHelper", NM="_ZN5clang8QualType22StreamedQualTypeHelperC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType22StreamedQualTypeHelperC1EOS1_")
    //</editor-fold>
    public /*inline*/ StreamedQualTypeHelper(JD$Move _dparam, final StreamedQualTypeHelper /*&&*/$Prm0) {
      // : T(static_cast<StreamedQualTypeHelper &&>().T), Policy(static_cast<StreamedQualTypeHelper &&>().Policy), PlaceHolder(static_cast<StreamedQualTypeHelper &&>().PlaceHolder), Indentation(static_cast<StreamedQualTypeHelper &&>().Indentation) 
      //START JInit
      this./*&*/T=/*&*/$Prm0.T;
      this./*&*/Policy=/*&*/$Prm0.Policy;
      this./*&*/PlaceHolder=/*&*/$Prm0.PlaceHolder;
      this.Indentation = $Prm0.Indentation;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "T=" + T // NOI18N
                + ", Policy=" + Policy // NOI18N
                + ", PlaceHolder=" + PlaceHolder // NOI18N
                + ", Indentation=" + Indentation; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::stream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 979,
   FQN="clang::QualType::stream", NM="_ZNK5clang8QualType6streamERKNS_14PrintingPolicyERKN4llvm5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType6streamERKNS_14PrintingPolicyERKN4llvm5TwineEj")
  //</editor-fold>
  public StreamedQualTypeHelper stream(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    return stream(Policy, 
        new Twine(), 
        0);
  }
  public StreamedQualTypeHelper stream(final /*const*/ PrintingPolicy /*&*/ Policy, 
        final /*const*/ Twine /*&*/ PlaceHolder/*= Twine()*/) /*const*/ {
    return stream(Policy, 
        PlaceHolder, 
        0);
  }
  public StreamedQualTypeHelper stream(final /*const*/ PrintingPolicy /*&*/ Policy, 
        final /*const*/ Twine /*&*/ PlaceHolder/*= Twine()*/, 
        /*uint*/int Indentation/*= 0*/) /*const*/ {
    return new StreamedQualTypeHelper(/*Deref*/this, Policy, PlaceHolder, Indentation);
  }

  
  
  //===----------------------------------------------------------------------===//
  // Type method implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2448,
   FQN="clang::QualType::dump", NM="_ZNK5clang8QualType4dumpEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType4dumpEPKc")
  //</editor-fold>
  public void dump(/*const*/char$ptr/*char P*/ msg) /*const*/ {
    if ((msg != null)) {
      llvm.errs().$out(msg).$out(/*KEEP_STR*/": ");
    }
    dump();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2454,
   FQN="clang::QualType::dump", NM="_ZNK5clang8QualType4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper Dumper = null;
    try {
      Dumper/*J*/= new ASTDumper(llvm.errs(), (/*const*/ CommandTraits /*P*/ )null, (/*const*/ SourceManager /*P*/ )null);
      Dumper.dumpTypeAsChild(new QualType(/*Deref*/this));
    } finally {
      if (Dumper != null) { Dumper.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 988,
   FQN="clang::QualType::Profile", NM="_ZNK5clang8QualType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(getAsOpaquePtr());
  }

  
  /// Return the address space of this type.
  
  /// Return the address space of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5375,
   FQN="clang::QualType::getAddressSpace", NM="_ZNK5clang8QualType15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType15getAddressSpaceEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getAddressSpace() /*const*/ {
    return getQualifiers().getAddressSpace();
  }

  
  /// Returns gc attribute of this type.
  
  /// Return the gc attribute of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5380,
   FQN="clang::QualType::getObjCGCAttr", NM="_ZNK5clang8QualType13getObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType13getObjCGCAttrEv")
  //</editor-fold>
  public /*inline*/ Qualifiers.GC getObjCGCAttr() /*const*/ {
    return getQualifiers().getObjCGCAttr();
  }

  
  /// true when Type is objc's weak.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isObjCGCWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 999,
   FQN="clang::QualType::isObjCGCWeak", NM="_ZNK5clang8QualType12isObjCGCWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType12isObjCGCWeakEv")
  //</editor-fold>
  public boolean isObjCGCWeak() /*const*/ {
    return getObjCGCAttr() == Qualifiers.GC.Weak;
  }

  
  /// true when Type is objc's strong.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isObjCGCStrong">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1004,
   FQN="clang::QualType::isObjCGCStrong", NM="_ZNK5clang8QualType14isObjCGCStrongEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType14isObjCGCStrongEv")
  //</editor-fold>
  public boolean isObjCGCStrong() /*const*/ {
    return getObjCGCAttr() == Qualifiers.GC.Strong;
  }

  
  /// Returns lifetime attribute of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1009,
   FQN="clang::QualType::getObjCLifetime", NM="_ZNK5clang8QualType15getObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType15getObjCLifetimeEv")
  //</editor-fold>
  public Qualifiers.ObjCLifetime getObjCLifetime() /*const*/ {
    return getQualifiers().getObjCLifetime();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::hasNonTrivialObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1013,
   FQN="clang::QualType::hasNonTrivialObjCLifetime", NM="_ZNK5clang8QualType25hasNonTrivialObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType25hasNonTrivialObjCLifetimeEv")
  //</editor-fold>
  public boolean hasNonTrivialObjCLifetime() /*const*/ {
    return getQualifiers().hasNonTrivialObjCLifetime();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::hasStrongOrWeakObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1017,
   FQN="clang::QualType::hasStrongOrWeakObjCLifetime", NM="_ZNK5clang8QualType27hasStrongOrWeakObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType27hasStrongOrWeakObjCLifetimeEv")
  //</editor-fold>
  public boolean hasStrongOrWeakObjCLifetime() /*const*/ {
    return getQualifiers().hasStrongOrWeakObjCLifetime();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::DestructionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1021,
   FQN="clang::QualType::DestructionKind", NM="_ZN5clang8QualType15DestructionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualType15DestructionKindE")
  //</editor-fold>
  public enum DestructionKind implements Native.ComparableLower {
    DK_none(0),
    DK_cxx_destructor(DK_none.getValue() + 1),
    DK_objc_strong_lifetime(DK_cxx_destructor.getValue() + 1),
    DK_objc_weak_lifetime(DK_objc_strong_lifetime.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DestructionKind valueOf(int val) {
      DestructionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DestructionKind[] VALUES;
      private static final DestructionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DestructionKind kind : DestructionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DestructionKind[min < 0 ? (1-min) : 0];
        VALUES = new DestructionKind[max >= 0 ? (1+max) : 0];
        for (DestructionKind kind : DestructionKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DestructionKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DestructionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DestructionKind)obj).value);}
    //</editor-fold>
  };
  
  /// Returns a nonzero value if objects of this type require
  /// non-trivial work to clean up after.  Non-zero because it's
  /// conceivable that qualifiers (objc_gc(weak)?) could make
  /// something require destruction.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isDestructedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1032,
   FQN="clang::QualType::isDestructedType", NM="_ZNK5clang8QualType16isDestructedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType16isDestructedTypeEv")
  //</editor-fold>
  public DestructionKind isDestructedType() /*const*/ {
    return isDestructedTypeImpl(new QualType(/*Deref*/this));
  }

  
  /// Determine whether expressions of the given type are forbidden
  /// from being lvalues in C.
  ///
  /// The expression types that are forbidden to be lvalues are:
  ///   - 'void', but not qualified void
  ///   - function types
  ///
  /// The exact rule here is C99 6.3.2.1:
  ///   An lvalue is an expression with an object type or an incomplete
  ///   type other than void.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isCForbiddenLValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5439,
   FQN="clang::QualType::isCForbiddenLValueType", NM="_ZNK5clang8QualType22isCForbiddenLValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8QualType22isCForbiddenLValueTypeEv")
  //</editor-fold>
  public /*inline*/ boolean isCForbiddenLValueType() /*const*/ {
    return ((getTypePtr().isVoidType() && !hasQualifiers())
       || getTypePtr().isFunctionType());
  }

  
  /// Substitute type arguments for the Objective-C type parameters used in the
  /// subject type.
  ///
  /// \param ctx ASTContext in which the type exists.
  ///
  /// \param typeArgs The type arguments that will be substituted for the
  /// Objective-C type parameters in the subject type, which are generally
  /// computed via \c Type::getObjCSubstitutions. If empty, the type
  /// parameters will be replaced with their bounds or id/Class, as appropriate
  /// for the context.
  ///
  /// \param context The context in which the subject type was written.
  ///
  /// \returns the resulting type.
  
  /// Substitute type arguments for the Objective-C type parameters used in the
  /// subject type.
  ///
  /// \param ctx ASTContext in which the type exists.
  ///
  /// \param typeArgs The type arguments that will be substituted for the
  /// Objective-C type parameters in the subject type, which are generally
  /// computed via \c Type::getObjCSubstitutions. If empty, the type
  /// parameters will be replaced with their bounds or id/Class, as appropriate
  /// for the context.
  ///
  /// \param context The context in which the subject type was written.
  ///
  /// \returns the resulting type.
  // end anonymous namespace
  
  /// Substitute the given type arguments for Objective-C type
  /// parameters within the given type, recursively.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::substObjCTypeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1065,
   FQN="clang::QualType::substObjCTypeArgs", NM="_ZNK5clang8QualType17substObjCTypeArgsERNS_10ASTContextEN4llvm8ArrayRefIS0_EENS_23ObjCSubstitutionContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType17substObjCTypeArgsERNS_10ASTContextEN4llvm8ArrayRefIS0_EENS_23ObjCSubstitutionContextE")
  //</editor-fold>
  public QualType substObjCTypeArgs(final ASTContext /*&*/ ctx, 
                   ArrayRef<QualType> typeArgs, 
                   ObjCSubstitutionContext context) /*const*/ {
    return simpleTransform(ctx, new QualType(/*Deref*/this), 
         /*[&]*/(/*QualType*/ type) -> 
          {
            SplitQualType splitType = type.split();
            {
              
              // Replace an Objective-C type parameter reference with the corresponding
              // type argument.
              /*const*/ TypedefType /*P*/ typedefTy = dyn_cast_TypedefType(splitType.Ty);
              if ((typedefTy != null)) {
                {
                  ObjCTypeParamDecl /*P*/ typeParam = dyn_cast_ObjCTypeParamDecl(typedefTy.getDecl());
                  if ((typeParam != null)) {
                    // If we have type arguments, use them.
                    if (!typeArgs.empty()) {
                      // FIXME: Introduce SubstObjCTypeParamType ?
                      QualType argType = new QualType(typeArgs.$at(typeParam.getIndex()));
                      return ctx.getQualifiedType(new QualType(argType), new Qualifiers(splitType.Quals));
                    }
                    switch (context) {
                     case Ordinary:
                     case Parameter:
                     case Superclass:
                      // Substitute the bound.
                      return ctx.getQualifiedType(typeParam.getUnderlyingType(), 
                          new Qualifiers(splitType.Quals));
                     case Result:
                     case Property:
                      {
                        // Substitute the __kindof form of the underlying type.
                        /*const*/ ObjCObjectPointerType /*P*/ objPtr = typeParam.getUnderlyingType().$arrow().castAs(ObjCObjectPointerType.class);
                        
                        // __kindof types, id, and Class don't need an additional
                        // __kindof.
                        if (objPtr.isKindOfType() || objPtr.isObjCIdOrClassType()) {
                          return ctx.getQualifiedType(typeParam.getUnderlyingType(), 
                              new Qualifiers(splitType.Quals));
                        }
                        
                        // Add __kindof.
                        /*const*/ ObjCObjectType /*P*/ obj = objPtr.getObjectType();
                        QualType resultTy = ctx.getObjCObjectType(obj.getBaseType(), 
                            obj.getTypeArgsAsWritten(), 
                            obj.getProtocols(), 
                            /*isKindOf=*/ true);
                        
                        // Rebuild object pointer type.
                        resultTy.$assignMove(ctx.getObjCObjectPointerType(new QualType(resultTy)));
                        return ctx.getQualifiedType(new QualType(resultTy), new Qualifiers(splitType.Quals));
                      }
                    }
                  }
                }
              }
            }
            {
              
              // If we have a function type, update the context appropriately.
              /*const*/ FunctionType /*P*/ funcType = dyn_cast_FunctionType(splitType.Ty);
              if ((funcType != null)) {
                // Substitute result type.
                QualType returnType = funcType.getReturnType().substObjCTypeArgs(ctx, 
                    new ArrayRef<QualType>(typeArgs), 
                    ObjCSubstitutionContext.Result);
                if (returnType.isNull()) {
                  return new QualType();
                }
                
                // Handle non-prototyped functions, which only substitute into the result
                // type.
                if (isa_FunctionNoProtoType(funcType)) {
                  // If the return type was unchanged, do nothing.
                  if ($eq_ptr(returnType.getAsOpaquePtr(), funcType.getReturnType().getAsOpaquePtr())) {
                    return new QualType(JD$Move.INSTANCE, type);
                  }
                  
                  // Otherwise, build a new type.
                  return ctx.getFunctionNoProtoType(new QualType(returnType), funcType.getExtInfo());
                }
                
                /*const*/ FunctionProtoType /*P*/ funcProtoType = cast_FunctionProtoType(funcType);
                
                // Transform parameter types.
                SmallVector<QualType> paramTypes/*J*/= new SmallVector<QualType>(4, new QualType());
                boolean paramChanged = false;
                for (QualType paramType : funcProtoType.getParamTypes()) {
                  QualType newParamType = paramType.substObjCTypeArgs(ctx, 
                      new ArrayRef<QualType>(typeArgs), 
                      ObjCSubstitutionContext.Parameter);
                  if (newParamType.isNull()) {
                    return new QualType();
                  }
                  if ($noteq_ptr(newParamType.getAsOpaquePtr(), paramType.getAsOpaquePtr())) {
                    paramChanged = true;
                  }
                  
                  paramTypes.push_back(newParamType);
                }
                
                // Transform extended info.
                FunctionProtoType.ExtProtoInfo info = funcProtoType.getExtProtoInfo();
                boolean exceptionChanged = false;
                if (info.ExceptionSpec.Type == ExceptionSpecificationType.EST_Dynamic) {
                  SmallVector<QualType> exceptionTypes/*J*/= new SmallVector<QualType>(4, new QualType());
                  for (QualType exceptionType : info.ExceptionSpec.Exceptions) {
                    QualType newExceptionType = exceptionType.substObjCTypeArgs(ctx, 
                        new ArrayRef<QualType>(typeArgs), 
                        ObjCSubstitutionContext.Ordinary);
                    if (newExceptionType.isNull()) {
                      return new QualType();
                    }
                    if ($noteq_ptr(newExceptionType.getAsOpaquePtr(), exceptionType.getAsOpaquePtr())) {
                      exceptionChanged = true;
                    }
                    
                    exceptionTypes.push_back(newExceptionType);
                  }
                  if (exceptionChanged) {
                    info.ExceptionSpec.Exceptions.$assignMove(
                        llvm.makeArrayRef(exceptionTypes).copy(QualType.class, ctx)
                    );
                  }
                }
                if ($eq_ptr(returnType.getAsOpaquePtr(), funcProtoType.getReturnType().getAsOpaquePtr())
                   && !paramChanged && !exceptionChanged) {
                  return new QualType(JD$Move.INSTANCE, type);
                }
                
                return ctx.getFunctionType(new QualType(returnType), new ArrayRef<QualType>(paramTypes, false), info);
              }
            }
            {
              
              // Substitute into the type arguments of a specialized Objective-C object
              // type.
              /*const*/ ObjCObjectType /*P*/ objcObjectType = dyn_cast_ObjCObjectType(splitType.Ty);
              if ((objcObjectType != null)) {
                if (objcObjectType.isSpecializedAsWritten()) {
                  SmallVector<QualType> newTypeArgs/*J*/= new SmallVector<QualType>(4, new QualType());
                  boolean anyChanged = false;
                  for (QualType typeArg : objcObjectType.getTypeArgsAsWritten()) {
                    QualType newTypeArg = typeArg.substObjCTypeArgs(ctx, new ArrayRef<QualType>(typeArgs), 
                        ObjCSubstitutionContext.Ordinary);
                    if (newTypeArg.isNull()) {
                      return new QualType();
                    }
                    if ($noteq_ptr(newTypeArg.getAsOpaquePtr(), typeArg.getAsOpaquePtr())) {
                      // If we're substituting based on an unspecialized context type,
                      // produce an unspecialized type.
                      ArrayRef<ObjCProtocolDecl /*P*/ > protocols/*J*/= new ArrayRef<ObjCProtocolDecl /*P*/ >(objcObjectType.qual_begin(), 
                          objcObjectType.getNumProtocols(), true);
                      if (typeArgs.empty()
                         && context != ObjCSubstitutionContext.Superclass) {
                        return ctx.getObjCObjectType(objcObjectType.getBaseType(), /*{ */new ArrayRef<QualType>(false)/* }*/, 
                            new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), 
                            objcObjectType.isKindOfTypeAsWritten());
                      }
                      
                      anyChanged = true;
                    }
                    
                    newTypeArgs.push_back(newTypeArg);
                  }
                  if (anyChanged) {
                    ArrayRef<ObjCProtocolDecl /*P*/ > protocols/*J*/= new ArrayRef<ObjCProtocolDecl /*P*/ >(objcObjectType.qual_begin(), 
                        objcObjectType.getNumProtocols(), true);
                    return ctx.getObjCObjectType(objcObjectType.getBaseType(), 
                        new ArrayRef<QualType>(newTypeArgs, false), new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), 
                        objcObjectType.isKindOfTypeAsWritten());
                  }
                }
                
                return new QualType(JD$Move.INSTANCE, type);
              }
            }
            
            return new QualType(JD$Move.INSTANCE, type);
          }
    );
  }


  
  /// Substitute type arguments from an object type for the Objective-C type
  /// parameters used in the subject type.
  ///
  /// This operation combines the computation of type arguments for
  /// substitution (\c Type::getObjCSubstitutions) with the actual process of
  /// substitution (\c QualType::substObjCTypeArgs) for the convenience of
  /// callers that need to perform a single substitution in isolation.
  ///
  /// \param objectType The type of the object whose member type we're
  /// substituting into. For example, this might be the receiver of a message
  /// or the base of a property access.
  ///
  /// \param dc The declaration context from which the subject type was
  /// retrieved, which indicates (for example) which type parameters should
  /// be substituted.
  ///
  /// \param context The context in which the subject type was written.
  ///
  /// \returns the subject type after replacing all of the Objective-C type
  /// parameters with their corresponding arguments.
  
  /// Substitute type arguments from an object type for the Objective-C type
  /// parameters used in the subject type.
  ///
  /// This operation combines the computation of type arguments for
  /// substitution (\c Type::getObjCSubstitutions) with the actual process of
  /// substitution (\c QualType::substObjCTypeArgs) for the convenience of
  /// callers that need to perform a single substitution in isolation.
  ///
  /// \param objectType The type of the object whose member type we're
  /// substituting into. For example, this might be the receiver of a message
  /// or the base of a property access.
  ///
  /// \param dc The declaration context from which the subject type was
  /// retrieved, which indicates (for example) which type parameters should
  /// be substituted.
  ///
  /// \param context The context in which the subject type was written.
  ///
  /// \returns the subject type after replacing all of the Objective-C type
  /// parameters with their corresponding arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::substObjCMemberType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1244,
   FQN="clang::QualType::substObjCMemberType", NM="_ZNK5clang8QualType19substObjCMemberTypeES0_PKNS_11DeclContextENS_23ObjCSubstitutionContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType19substObjCMemberTypeES0_PKNS_11DeclContextENS_23ObjCSubstitutionContextE")
  //</editor-fold>
  public QualType substObjCMemberType(QualType objectType, 
                     /*const*/ DeclContext /*P*/ dc, 
                     ObjCSubstitutionContext context) /*const*/ {
    {
      Optional<ArrayRef<QualType> > subs = objectType.$arrow().getObjCSubstitutions(dc);
      if (subs.$bool()) {
        return substObjCTypeArgs(dc.getParentASTContext(), new ArrayRef<QualType>(subs.$star()), context);
      }
    }
    
    return new QualType(/*Deref*/this);
  }


  
  /// Strip Objective-C "__kindof" types from the given type.
  
  /// Strip Objective-C "__kindof" types from the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::stripObjCKindOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1253,
   FQN="clang::QualType::stripObjCKindOfType", NM="_ZNK5clang8QualType19stripObjCKindOfTypeERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType19stripObjCKindOfTypeERKNS_10ASTContextE")
  //</editor-fold>
  public QualType stripObjCKindOfType(final /*const*/ ASTContext /*&*/ constCtx) /*const*/ {
    // FIXME: Because ASTContext::getAttributedType() is non-const.
    final ASTContext /*&*/ ctx = ((/*const_cast*/ASTContext /*&*/ )(constCtx));
    return simpleTransform(ctx, new QualType(/*Deref*/this), 
         /*[&]*/(/*QualType*/ type) -> 
          {
            SplitQualType splitType = type.split();
            {
              /*const*/ ObjCObjectType /*P*/ objType = splitType.Ty.getAs(ObjCObjectType.class);
              if ((objType != null)) {
                if (!objType.isKindOfType()) {
                  return new QualType(JD$Move.INSTANCE, type);
                }
                
                QualType baseType = objType.getBaseType().stripObjCKindOfType(ctx);
                return ctx.getQualifiedType(ctx.getObjCObjectType(new QualType(baseType), 
                        objType.getTypeArgsAsWritten(), 
                        objType.getProtocols(), 
                        /*isKindOf=*/ false), 
                    new Qualifiers(splitType.Quals));
              }
            }
            
            return new QualType(JD$Move.INSTANCE, type);
          }
  );
  }


  
  /// Remove all qualifiers including _Atomic.
  
  /// Remove all qualifiers including _Atomic.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getAtomicUnqualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1277,
   FQN="clang::QualType::getAtomicUnqualifiedType", NM="_ZNK5clang8QualType24getAtomicUnqualifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8QualType24getAtomicUnqualifiedTypeEv")
  //</editor-fold>
  public QualType getAtomicUnqualifiedType() /*const*/ {
    {
      /*const*/ AtomicType /*P*/ AT = getTypePtr().getAs(AtomicType.class);
      if ((AT != null)) {
        return AT.getValueType().getUnqualifiedType();
      }
    }
    return getUnqualifiedType();
  }


/*private:*/
  // These methods are implemented in a separate translation unit;
  // "static"-ize them to avoid creating temporary QualTypes in the
  // caller.
  // These methods are implemented in a separate translation unit;
  // "static"-ize them to avoid creating temporary QualTypes in the
  // caller.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 67,
   FQN="clang::QualType::isConstant", NM="_ZN5clang8QualType10isConstantES0_RKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType10isConstantES0_RKNS_10ASTContextE")
  //</editor-fold>
  private static boolean isConstant(QualType T, final /*const*/ ASTContext /*&*/ Ctx) {
    if (T.isConstQualified()) {
      return true;
    }
    {
      
      /*const*/ ArrayType /*P*/ AT = Ctx.getAsArrayType(new QualType(T));
      if ((AT != null)) {
        return AT.getElementType().isConstant(Ctx);
      }
    }
    
    return T.getAddressSpace() == LangAS.ID.opencl_constant;
  }


  
  /// getDesugaredType - Return the specified type with any "sugar" removed from
  /// the type.  This takes off typedefs, typeof's etc.  If the outer level of
  /// the type is already concrete, it returns it unmodified.  This is similar
  /// to getting the canonical type, but it doesn't remove *all* typedefs.  For
  /// example, it returns "T*" as "T*", (not as "int*"), because the pointer is
  /// concrete.
  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 212,
   FQN="clang::QualType::getDesugaredType", NM="_ZN5clang8QualType16getDesugaredTypeES0_RKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType16getDesugaredTypeES0_RKNS_10ASTContextE")
  //</editor-fold>
  private static QualType getDesugaredType(QualType T, final /*const*/ ASTContext /*&*/ Context) {
    SplitQualType split = getSplitDesugaredType(new QualType(T));
    return Context.getQualifiedType(split.Ty, new Qualifiers(split.Quals));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getSplitDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 238,
   FQN="clang::QualType::getSplitDesugaredType", NM="_ZN5clang8QualType21getSplitDesugaredTypeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType21getSplitDesugaredTypeES0_")
  //</editor-fold>
  private static SplitQualType getSplitDesugaredType(QualType T) {
    QualifierCollector Qs/*J*/= new QualifierCollector();
    
    QualType Cur = new QualType(T);
    while (true) {
      /*const*/ Type /*P*/ CurTy = Qs.strip(new QualType(Cur));
      switch (CurTy.getTypeClass()) {
       case Builtin:
        {
          /*const*/ BuiltinType /*P*/ Ty = cast_BuiltinType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Complex:
        {
          /*const*/ ComplexType /*P*/ Ty = cast_ComplexType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Pointer:
        {
          /*const*/ PointerType /*P*/ Ty = cast_PointerType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case BlockPointer:
        {
          /*const*/ BlockPointerType /*P*/ Ty = cast_BlockPointerType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case LValueReference:
        {
          /*const*/ LValueReferenceType /*P*/ Ty = cast_LValueReferenceType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case RValueReference:
        {
          /*const*/ RValueReferenceType /*P*/ Ty = cast_RValueReferenceType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case MemberPointer:
        {
          /*const*/ MemberPointerType /*P*/ Ty = cast_MemberPointerType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case ConstantArray:
        {
          /*const*/ ConstantArrayType /*P*/ Ty = cast_ConstantArrayType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case IncompleteArray:
        {
          /*const*/ IncompleteArrayType /*P*/ Ty = cast_IncompleteArrayType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case VariableArray:
        {
          /*const*/ VariableArrayType /*P*/ Ty = cast_VariableArrayType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case DependentSizedArray:
        {
          /*const*/ DependentSizedArrayType /*P*/ Ty = cast_DependentSizedArrayType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case DependentSizedExtVector:
        {
          /*const*/ DependentSizedExtVectorType /*P*/ Ty = cast_DependentSizedExtVectorType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Vector:
        {
          /*const*/ VectorType /*P*/ Ty = cast_VectorType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case ExtVector:
        {
          /*const*/ ExtVectorType /*P*/ Ty = cast_ExtVectorType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case FunctionProto:
        {
          /*const*/ FunctionProtoType /*P*/ Ty = cast_FunctionProtoType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case FunctionNoProto:
        {
          /*const*/ FunctionNoProtoType /*P*/ Ty = cast_FunctionNoProtoType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case UnresolvedUsing:
        {
          /*const*/ UnresolvedUsingType /*P*/ Ty = cast_UnresolvedUsingType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Paren:
        {
          /*const*/ ParenType /*P*/ Ty = cast_ParenType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Typedef:
        {
          /*const*/ TypedefType /*P*/ Ty = cast_TypedefType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Adjusted:
        {
          /*const*/ AdjustedType /*P*/ Ty = cast_AdjustedType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Decayed:
        {
          /*const*/ DecayedType /*P*/ Ty = cast_DecayedType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case TypeOfExpr:
        {
          /*const*/ TypeOfExprType /*P*/ Ty = cast_TypeOfExprType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case TypeOf:
        {
          /*const*/ TypeOfType /*P*/ Ty = cast_TypeOfType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Decltype:
        {
          /*const*/ DecltypeType /*P*/ Ty = cast_DecltypeType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case UnaryTransform:
        {
          /*const*/ UnaryTransformType /*P*/ Ty = cast_UnaryTransformType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Record:
        {
          /*const*/ RecordType /*P*/ Ty = cast_RecordType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Enum:
        {
          /*const*/ EnumType /*P*/ Ty = cast_EnumType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Elaborated:
        {
          /*const*/ ElaboratedType /*P*/ Ty = cast_ElaboratedType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Attributed:
        {
          /*const*/ AttributedType /*P*/ Ty = cast_AttributedType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case TemplateTypeParm:
        {
          /*const*/ TemplateTypeParmType /*P*/ Ty = cast_TemplateTypeParmType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case SubstTemplateTypeParm:
        {
          /*const*/ SubstTemplateTypeParmType /*P*/ Ty = cast_SubstTemplateTypeParmType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case SubstTemplateTypeParmPack:
        {
          /*const*/ SubstTemplateTypeParmPackType /*P*/ Ty = cast_SubstTemplateTypeParmPackType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case TemplateSpecialization:
        {
          /*const*/ TemplateSpecializationType /*P*/ Ty = cast_TemplateSpecializationType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Auto:
        {
          /*const*/ AutoType /*P*/ Ty = cast_AutoType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case InjectedClassName:
        {
          /*const*/ InjectedClassNameType /*P*/ Ty = cast_InjectedClassNameType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case DependentName:
        {
          /*const*/ DependentNameType /*P*/ Ty = cast_DependentNameType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case DependentTemplateSpecialization:
        {
          /*const*/ DependentTemplateSpecializationType /*P*/ Ty = cast_DependentTemplateSpecializationType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case PackExpansion:
        {
          /*const*/ PackExpansionType /*P*/ Ty = cast_PackExpansionType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case ObjCObject:
        {
          /*const*/ ObjCObjectType /*P*/ Ty = cast_ObjCObjectType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case ObjCInterface:
        {
          /*const*/ ObjCInterfaceType /*P*/ Ty = cast_ObjCInterfaceType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case ObjCObjectPointer:
        {
          /*const*/ ObjCObjectPointerType /*P*/ Ty = cast_ObjCObjectPointerType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Pipe:
        {
          /*const*/ PipeType /*P*/ Ty = cast_PipeType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
       case Atomic:
        {
          /*const*/ AtomicType /*P*/ Ty = cast_AtomicType(CurTy);
          if (!Ty.isSugared()) {
            return new SplitQualType(Ty, new Qualifiers(Qs));
          }
          Cur.$assignMove(Ty.desugar());
          break;
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getSplitUnqualifiedTypeImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*goto=>break*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 259,
   FQN="clang::QualType::getSplitUnqualifiedTypeImpl", NM="_ZN5clang8QualType27getSplitUnqualifiedTypeImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType27getSplitUnqualifiedTypeImplES0_")
  //</editor-fold>
  private static SplitQualType getSplitUnqualifiedTypeImpl(QualType type) {
    SplitQualType split = type.split();
    
    // All the qualifiers we've seen so far.
    Qualifiers quals = new Qualifiers(split.Quals);
    
    // The last type node we saw with any nodes inside it.
    /*const*/ Type /*P*/ lastTypeWithQuals = split.Ty;
    LOOP:// JAVA: to replace goto done
    while (true) {
      QualType next/*J*/= new QualType();
      
      // Do a single-step desugar, aborting the loop if the type isn't
      // sugared.
      switch (split.Ty.getTypeClass()) {
       case Builtin:
        {
          /*const*/ BuiltinType /*P*/ ty = cast_BuiltinType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Complex:
        {
          /*const*/ ComplexType /*P*/ ty = cast_ComplexType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Pointer:
        {
          /*const*/ PointerType /*P*/ ty = cast_PointerType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case BlockPointer:
        {
          /*const*/ BlockPointerType /*P*/ ty = cast_BlockPointerType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case LValueReference:
        {
          /*const*/ LValueReferenceType /*P*/ ty = cast_LValueReferenceType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case RValueReference:
        {
          /*const*/ RValueReferenceType /*P*/ ty = cast_RValueReferenceType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case MemberPointer:
        {
          /*const*/ MemberPointerType /*P*/ ty = cast_MemberPointerType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case ConstantArray:
        {
          /*const*/ ConstantArrayType /*P*/ ty = cast_ConstantArrayType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case IncompleteArray:
        {
          /*const*/ IncompleteArrayType /*P*/ ty = cast_IncompleteArrayType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case VariableArray:
        {
          /*const*/ VariableArrayType /*P*/ ty = cast_VariableArrayType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case DependentSizedArray:
        {
          /*const*/ DependentSizedArrayType /*P*/ ty = cast_DependentSizedArrayType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case DependentSizedExtVector:
        {
          /*const*/ DependentSizedExtVectorType /*P*/ ty = cast_DependentSizedExtVectorType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Vector:
        {
          /*const*/ VectorType /*P*/ ty = cast_VectorType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case ExtVector:
        {
          /*const*/ ExtVectorType /*P*/ ty = cast_ExtVectorType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case FunctionProto:
        {
          /*const*/ FunctionProtoType /*P*/ ty = cast_FunctionProtoType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case FunctionNoProto:
        {
          /*const*/ FunctionNoProtoType /*P*/ ty = cast_FunctionNoProtoType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case UnresolvedUsing:
        {
          /*const*/ UnresolvedUsingType /*P*/ ty = cast_UnresolvedUsingType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Paren:
        {
          /*const*/ ParenType /*P*/ ty = cast_ParenType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Typedef:
        {
          /*const*/ TypedefType /*P*/ ty = cast_TypedefType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Adjusted:
        {
          /*const*/ AdjustedType /*P*/ ty = cast_AdjustedType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Decayed:
        {
          /*const*/ DecayedType /*P*/ ty = cast_DecayedType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case TypeOfExpr:
        {
          /*const*/ TypeOfExprType /*P*/ ty = cast_TypeOfExprType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case TypeOf:
        {
          /*const*/ TypeOfType /*P*/ ty = cast_TypeOfType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Decltype:
        {
          /*const*/ DecltypeType /*P*/ ty = cast_DecltypeType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case UnaryTransform:
        {
          /*const*/ UnaryTransformType /*P*/ ty = cast_UnaryTransformType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Record:
        {
          /*const*/ RecordType /*P*/ ty = cast_RecordType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Enum:
        {
          /*const*/ EnumType /*P*/ ty = cast_EnumType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Elaborated:
        {
          /*const*/ ElaboratedType /*P*/ ty = cast_ElaboratedType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Attributed:
        {
          /*const*/ AttributedType /*P*/ ty = cast_AttributedType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case TemplateTypeParm:
        {
          /*const*/ TemplateTypeParmType /*P*/ ty = cast_TemplateTypeParmType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case SubstTemplateTypeParm:
        {
          /*const*/ SubstTemplateTypeParmType /*P*/ ty = cast_SubstTemplateTypeParmType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case SubstTemplateTypeParmPack:
        {
          /*const*/ SubstTemplateTypeParmPackType /*P*/ ty = cast_SubstTemplateTypeParmPackType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case TemplateSpecialization:
        {
          /*const*/ TemplateSpecializationType /*P*/ ty = cast_TemplateSpecializationType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Auto:
        {
          /*const*/ AutoType /*P*/ ty = cast_AutoType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case InjectedClassName:
        {
          /*const*/ InjectedClassNameType /*P*/ ty = cast_InjectedClassNameType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case DependentName:
        {
          /*const*/ DependentNameType /*P*/ ty = cast_DependentNameType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case DependentTemplateSpecialization:
        {
          /*const*/ DependentTemplateSpecializationType /*P*/ ty = cast_DependentTemplateSpecializationType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case PackExpansion:
        {
          /*const*/ PackExpansionType /*P*/ ty = cast_PackExpansionType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case ObjCObject:
        {
          /*const*/ ObjCObjectType /*P*/ ty = cast_ObjCObjectType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case ObjCInterface:
        {
          /*const*/ ObjCInterfaceType /*P*/ ty = cast_ObjCInterfaceType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case ObjCObjectPointer:
        {
          /*const*/ ObjCObjectPointerType /*P*/ ty = cast_ObjCObjectPointerType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Pipe:
        {
          /*const*/ PipeType /*P*/ ty = cast_PipeType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
       case Atomic:
        {
          /*const*/ AtomicType /*P*/ ty = cast_AtomicType(split.Ty);
          if (!ty.isSugared()) {
            /*JAVA: goto done*/break LOOP;
          }
          next.$assignMove(ty.desugar());
          break;
        }
      }
      
      // Otherwise, split the underlying type.  If that yields qualifiers,
      // update the information.
      split.$assignMove(next.split());
      if (!split.Quals.empty()) {
        lastTypeWithQuals = split.Ty;
        quals.addConsistentQualifiers(new Qualifiers(split.Quals));
      }
    }
   /*done:*/
    return new SplitQualType(lastTypeWithQuals, new Qualifiers(quals));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::getSingleStepDesugaredTypeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 217,
   FQN="clang::QualType::getSingleStepDesugaredTypeImpl", NM="_ZN5clang8QualType30getSingleStepDesugaredTypeImplES0_RKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType30getSingleStepDesugaredTypeImplES0_RKNS_10ASTContextE")
  //</editor-fold>
  private static QualType getSingleStepDesugaredTypeImpl(QualType type, 
                                final /*const*/ ASTContext /*&*/ Context) {
    SplitQualType split = type.split();
    QualType desugar = split.Ty.getLocallyUnqualifiedSingleStepDesugaredType();
    return Context.getQualifiedType(new QualType(desugar), new Qualifiers(split.Quals));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::IgnoreParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 298,
   FQN="clang::QualType::IgnoreParens", NM="_ZN5clang8QualType12IgnoreParensES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType12IgnoreParensES0_")
  //</editor-fold>
  private static QualType IgnoreParens(QualType T) {
    {
      // FIXME: this seems inherently un-qualifiers-safe.
      /*const*/ ParenType /*P*/ PT;
      while (((/*P*/ PT = T.$arrow().getAs(ParenType.class)) != null)) {
        T.$assignMove(PT.getInnerType());
      }
    }
    return new QualType(JD$Move.INSTANCE, T);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::isDestructedTypeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3759,
   FQN="clang::QualType::isDestructedTypeImpl", NM="_ZN5clang8QualType20isDestructedTypeImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8QualType20isDestructedTypeImplES0_")
  //</editor-fold>
  private static QualType.DestructionKind isDestructedTypeImpl(QualType type) {
    switch (type.getObjCLifetime()) {
     case OCL_None:
     case OCL_ExplicitNone:
     case OCL_Autoreleasing:
      break;
     case OCL_Strong:
      return DestructionKind.DK_objc_strong_lifetime;
     case OCL_Weak:
      return DestructionKind.DK_objc_weak_lifetime;
    }
    
    /// Currently, the only destruction kind we recognize is C++ objects
    /// with non-trivial destructors.
    /*const*/ CXXRecordDecl /*P*/ record = type.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
    if ((record != null) && record.hasDefinition() && !record.hasTrivialDestructor()) {
      return DestructionKind.DK_cxx_destructor;
    }
    
    return DestructionKind.DK_none;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::QualType::QualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 598,
   FQN="clang::QualType::QualType", NM="_ZN5clang8QualTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ QualType(final /*const*/ QualType /*&*/ $Prm0) {
    // : Value(.Value) 
    //START JInit
    this.Value = new PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>($Prm0.Value);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::QualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 598,
   FQN="clang::QualType::QualType", NM="_ZN5clang8QualTypeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeC1EOS0_")
  //</editor-fold>
  public /*inline*/ QualType(JD$Move _dparam, final QualType /*&&*/$Prm0) {
    // : Value(static_cast<QualType &&>().Value) 
    //START JInit
    this.Value = new PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>(JD$Move.INSTANCE, $Prm0.Value);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 598,
   FQN="clang::QualType::operator=", NM="_ZN5clang8QualTypeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeaSERKS0_")
  //</editor-fold>
  public /*inline*/ QualType /*&*/ $assign(final /*const*/ QualType /*&*/ $Prm0) {
    this.Value.$assign($Prm0.Value);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualType::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 598,
   FQN="clang::QualType::operator=", NM="_ZN5clang8QualTypeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8QualTypeaSEOS0_")
  //</editor-fold>
  public /*inline*/ QualType /*&*/ $assignMove(final QualType /*&&*/$Prm0) {
    assert this != $Prm0;
    this.Value.$assignMove($Prm0.Value);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override int $hashcode() { 
    return this.Value.$hashcode();
  }
  
  @Override public QualType clone() { 
    return new QualType(this); 
  }
  
  private static final int DUMMY_QUAL_TYPE_VALUE = -1;
  
  public static final Object/*P*/DUMMY_QUAL_TYPE_OPAQUE_VALUE = 
          new PointerIntPair(null, DUMMY_QUAL_TYPE_VALUE);
  
  @Override public boolean $less(Object Other) { 
    PointerIntPair<PointerUnion<Type, ExtQuals>> RHS = (PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>)Other; 
    return this.Value.$less(RHS);
  }
  public boolean $less(QualType RHS) {
    return this.Value.$less(RHS.Value);
  }
  
  @Override public boolean $lesseq(Object Other) { 
    PointerIntPair<PointerUnion<Type, ExtQuals>> RHS = (PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>)Other; 
    return this.Value.$lesseq(RHS);
  }
  public boolean $lesseq(QualType RHS) { 
    return this.Value.$lesseq(RHS.Value);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::simplify_type<clang::QualType>::getSimplifiedValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1117,
   FQN="llvm::simplify_type<clang::QualType>::getSimplifiedValue", NM="_ZN4llvm13simplify_typeIN5clang8QualTypeEE18getSimplifiedValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN4llvm13simplify_typeIN5clang8QualTypeEE18getSimplifiedValueES2_")
  //</editor-fold>  
  @Override public Object getSimplifiedValue(Object $This) {
    // copied from llvm::simplify_type<clang::QualType>
    assert $This == this : "must be called on itself " + $This + " vs. " + this;
    return this.getTypePtr();
  }
  
  @Override
  public boolean $noteq(QualType other) {
    if (other == null) {
      return !isNull();
    }
    return $noteq_QualType$C(this, other);
  }

  @Override
  public boolean $eq(QualType other) {
    if (other == null) {
      return isNull();
    }
    return $eq_QualType$C(this, other);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    String msg;
    String canonical = "";
    if (isNull()) {
      msg = "NULL";
    } else {
      int Flags = Value.getInt();
      msg = "Flags=" + Flags + "|";
      if (Value == QualType.DUMMY_QUAL_TYPE_OPAQUE_VALUE) {
        msg = "DUMMY_QUAL_TYPE_OPAQUE_VALUE";
      } else {
        std.string asString = null;
        try {
          ExtQualsTypeCommonBase commonPtr = getCommonPtr();
          canonical = (commonPtr.CanonicalType == this) ? "CANON" : "";
          msg += "ThisPtr=" + NativeTrace.getIdentityStr(commonPtr);
          msg += ";BaseType=" + (commonPtr.BaseType == null ? "<null>" : commonPtr.BaseType.getClass().getSimpleName());
          asString = this.getAsString();
        } catch (Throwable e) {
          // catch any problem here to not break toString
        }
        if (asString != null) {
          msg += "[" + asString.toJavaString() + "]";
        }
      }
    }
    return "QualType{" + canonical + "#" + $hashcode() + ":" + msg + "}"; // NOI18N
  }
}
