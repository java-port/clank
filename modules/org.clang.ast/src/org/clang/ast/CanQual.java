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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.aliases.*;
import org.clang.ast.java.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//----------------------------------------------------------------------------//
// Canonical, qualified type template
//----------------------------------------------------------------------------//

/// \brief Represents a canonical, potentially-qualified type.
///
/// The CanQual template is a lightweight smart pointer that provides access
/// to the canonical representation of a type, where all typedefs and other
/// syntactic sugar has been eliminated. A CanQualType may also have various
/// qualifiers (const, volatile, restrict) attached to it.
///
/// The template type parameter @p T is one of the Type classes (PointerType,
/// BuiltinType, etc.). The type stored within @c CanQual<T> will be of that
/// type (or some subclass of that type). The typedef @c CanQualType is just
/// a shorthand for @c CanQual<Type>.
///
/// An instance of @c CanQual<T> can be implicitly converted to a
/// @c CanQual<U> when T is derived from U, which essentially provides an
/// implicit upcast. For example, @c CanQual<LValueReferenceType> can be
/// converted to @c CanQual<ReferenceType>. Note that any @c CanQual type can
/// be implicitly converted to a QualType, but the reverse operation requires
/// a call to ASTContext::getCanonicalType().
///
///
/*template <typename T = Type> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::CanQual">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 51,
 FQN="clang::CanQual", NM="_ZN5clang7CanQualE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CanQualE")
//</editor-fold>
public class CanQual</*typename*/ T extends Type/* = Type*/>  implements NativeHashable, NativePOD<CanQual<?>>, Native.Native$Bool, simplify_type {
  /// \brief The actual, canonical type.
  private QualType Stored;
/*public:*/
  /// \brief Constructs a NULL canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::CanQual<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 58,
   FQN="clang::CanQual::CanQual<type-parameter-0-0>", NM="_ZN5clang7CanQualC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CanQualC1Ev")
  //</editor-fold>
  public CanQual() {
    // : Stored() 
    //START JInit
    this.Stored = new QualType();
    //END JInit
  }

  
  /// \brief Converting constructor that permits implicit upcasting of
  /// canonical type pointers.
  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::CanQual<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*no TU?*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 63,
   FQN="clang::CanQual::CanQual<type-parameter-0-0>", NM="Tpl__ZN5clang7CanQualC1ERKNS_7CanQualIT_EENSt9enable_ifIXsr3std10is_base_ofIT_S2_EE5valueEiE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=Tpl__ZN5clang7CanQualC1ERKNS_7CanQualIT_EENSt9enable_ifIXsr3std10is_base_ofIT_S2_EE5valueEiE4typeE")
  //</editor-fold>
  public </*typename*/ U extends Type> CanQual(JD$BaseOf _dparam, final /*const*/ CanQual<U> /*&*/ Other) {
    this.Stored = new QualType(Other.Stored);
  }
  
  
  /// \brief Retrieve the underlying type pointer, which refers to a
  /// canonical type.
  ///
  /// The underlying pointer must not be NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getTypePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 70,
   FQN="clang::CanQual::getTypePtr", NM="_ZNK5clang7CanQual10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual10getTypePtrEv")
  //</editor-fold>
  public /*const*/ T /*P*/ getTypePtr() /*const*/ {
    return (T)cast_Type(Stored.getTypePtr());
  }

  
  /// \brief Retrieve the underlying type pointer, which refers to a
  /// canonical type, or NULL.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getTypePtrOrNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 75,
   FQN="clang::CanQual::getTypePtrOrNull", NM="_ZNK5clang7CanQual16getTypePtrOrNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual16getTypePtrOrNullEv")
  //</editor-fold>
  public /*const*/ T /*P*/ getTypePtrOrNull() /*const*/ {
    return (T)cast_or_null_Type(Stored.getTypePtrOrNull());
  }

  
  /// \brief Implicit conversion to a qualified type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::operator QualType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*copy*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 80,
   FQN="clang::CanQual::operator QualType", NM="_ZNK5clang7CanQualcvNS_8QualTypeEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQualcvNS_8QualTypeEEv")
  //</editor-fold>
  public QualType $QualType() /*const*/ {
    // JAVA: MUST BE COPY HERE
    return new QualType(Stored);
  }

  
  /// \brief Implicit conversion to bool.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 83,
   FQN="clang::CanQual::operator bool", NM="_ZNK5clang7CanQualcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQualcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return Native.$not(isNull());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 85,
   FQN="clang::CanQual::isNull", NM="_ZNK5clang7CanQual6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return Stored.isNull();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::split">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 89,
   FQN="clang::CanQual::split", NM="_ZNK5clang7CanQual5splitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual5splitEv")
  //</editor-fold>
  public SplitQualType split() /*const*/ {
    return Stored.split();
  }

  
  /// \brief Retrieve a canonical type pointer with a different static type,
  /// upcasting or downcasting as needed.
  ///
  /// The getAs() function is typically used to try to downcast to a
  /// more specific (canonical) type in the type system. For example:
  ///
  /// @code
  /// void f(CanQual<Type> T) {
  ///   if (CanQual<PointerType> Ptr = T->getAs<PointerType>()) {
  ///     // look at Ptr's pointee type
  ///   }
  /// }
  /// @endcode
  ///
  /// \returns A proxy pointer to the same type, but with the specified
  /// static type (@p U). If the dynamic type is not the specified static type
  /// or a derived class thereof, a NULL canonical type.
  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 630,
   FQN="clang::CanQual::getAs", NM="Tpl__ZNK5clang7CanQual5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=Tpl__ZNK5clang7CanQual5getAsEv")
  //</editor-fold>
  public final </*typename*/ U extends Type> CanProxy<U> getAs(Class<U> clazz) /*const*/ {
    ArrayType_cannot_be_used_with_getAs<U> at;
    ///*J:(void)*/at;
    if (Stored.isNull()) {
      return AstJavaTypesSupport.Create$CanProxy(new CanQual(), clazz);
    }
    if (isa(clazz, Stored.getTypePtr())) {
      return AstJavaTypesSupport.Create$CanProxy(CanQual.CreateUnsafe(Stored), clazz);
    }
    
    return AstJavaTypesSupport.Create$CanProxy(new CanQual(), clazz);
  }

  
  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::castAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 645,
   FQN="clang::CanQual::castAs", NM="Tpl__ZNK5clang7CanQual6castAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=Tpl__ZNK5clang7CanQual6castAsEv")
  //</editor-fold>
  public final </*typename*/ U extends Type> CanProxy<U> castAs(Class<U> clazz) /*const*/ {
    ArrayType_cannot_be_used_with_getAs<U> at;
    ///*J:(void)*/at;
    assert Native.$bool(Native.$not(Stored.isNull()) && Native.$bool(isa(clazz, Stored.getTypePtr())));
    return AstJavaTypesSupport.Create$CanProxy(CanQual.CreateUnsafe(Stored), clazz);
  }

  
  /// \brief Overloaded arrow operator that produces a canonical type
  /// proxy.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 655,
   FQN="clang::CanQual::operator->", NM="_ZNK5clang7CanQualptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQualptEv")
  //</editor-fold>
  public final CanProxyType $arrow() /*const*/ {
    assert !this.isNull() : "do we need to extract class type from Stored's PointerUnion?" + this.Stored;
    assert this.Stored.getAsOpaquePtr() != (Object/*void P*/ )QualType.DUMMY_QUAL_TYPE_OPAQUE_VALUE;
    assert this.Stored.isCanonical() : "Type is not canonical!" + this.Stored;
    return (CanProxyType)AstJavaTypesSupport.Create$CanProxy(this, Type.class);
  }
  public final </*typename*/ U extends Type> CanProxy<U> $arrow(Class<U> clazz) /*const*/ {
    assert !this.isNull() : "do we need to extract class type from Stored's PointerUnion?" + this.Stored;
    assert this.Stored.getAsOpaquePtr() != (Object/*void P*/ )QualType.DUMMY_QUAL_TYPE_OPAQUE_VALUE;
    assert this.Stored.isCanonical() : "Type is not canonical!" + this.Stored;
    return AstJavaTypesSupport.Create$CanProxy(this, clazz);
  }

  
  /// \brief Retrieve all qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 117,
   FQN="clang::CanQual::getQualifiers", NM="_ZNK5clang7CanQual13getQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual13getQualifiersEv")
  //</editor-fold>
  public Qualifiers getQualifiers() /*const*/ {
    return Stored.getLocalQualifiers();
  }

  
  /// \brief Retrieve the const/volatile/restrict qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 120,
   FQN="clang::CanQual::getCVRQualifiers", NM="_ZNK5clang7CanQual16getCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual16getCVRQualifiersEv")
  //</editor-fold>
  public /*uint*/int getCVRQualifiers() /*const*/ {
    return Stored.getLocalCVRQualifiers();
  }

  
  /// \brief Determines whether this type has any qualifiers
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::hasQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 123,
   FQN="clang::CanQual::hasQualifiers", NM="_ZNK5clang7CanQual13hasQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual13hasQualifiersEv")
  //</editor-fold>
  public boolean hasQualifiers() /*const*/ {
    return Stored.hasLocalQualifiers();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isConstQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 125,
   FQN="clang::CanQual::isConstQualified", NM="_ZNK5clang7CanQual16isConstQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual16isConstQualifiedEv")
  //</editor-fold>
  public boolean isConstQualified() /*const*/ {
    return Stored.isLocalConstQualified();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isVolatileQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 128,
   FQN="clang::CanQual::isVolatileQualified", NM="_ZNK5clang7CanQual19isVolatileQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual19isVolatileQualifiedEv")
  //</editor-fold>
  public boolean isVolatileQualified() /*const*/ {
    return Stored.isLocalVolatileQualified();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isRestrictQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 131,
   FQN="clang::CanQual::isRestrictQualified", NM="_ZNK5clang7CanQual19isRestrictQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual19isRestrictQualifiedEv")
  //</editor-fold>
  public boolean isRestrictQualified() /*const*/ {
    return Stored.isLocalRestrictQualified();
  }

  
  /// \brief Determines if this canonical type is furthermore
  /// canonical as a parameter.  The parameter-canonicalization
  /// process decays arrays to pointers and drops top-level qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isCanonicalAsParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 138,
   FQN="clang::CanQual::isCanonicalAsParam", NM="_ZNK5clang7CanQual18isCanonicalAsParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual18isCanonicalAsParamEv")
  //</editor-fold>
  public boolean isCanonicalAsParam() /*const*/ {
    return Stored.isCanonicalAsParam();
  }

  
  /// \brief Retrieve the unqualified form of this type.
  
  //----------------------------------------------------------------------------//
  // Method and function definitions
  //----------------------------------------------------------------------------//
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getUnqualifiedType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 598,
   FQN="clang::CanQual::getUnqualifiedType", NM="_ZNK5clang7CanQual18getUnqualifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual18getUnqualifiedTypeEv")
  //</editor-fold>
  public /*inline*/ CanQual<T> getUnqualifiedType() /*const*/ {
    return (CanQual<T>)CanQual.CreateUnsafe(Stored.getLocalUnqualifiedType());
  }

  
  /// \brief Retrieves a version of this type with const applied.
  /// Note that this does not always yield a canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::withConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 147,
   FQN="clang::CanQual::withConst", NM="_ZNK5clang7CanQual9withConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual9withConstEv")
  //</editor-fold>
  public QualType withConst() /*const*/ {
    return Stored.withConst();
  }

  
  /// \brief Determines whether this canonical type is more qualified than
  /// the @p Other canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isMoreQualifiedThan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 153,
   FQN="clang::CanQual::isMoreQualifiedThan", NM="_ZNK5clang7CanQual19isMoreQualifiedThanENS_7CanQualIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual19isMoreQualifiedThanENS_7CanQualIT_EE")
  //</editor-fold>
  public boolean isMoreQualifiedThan(CanQual<T> Other) /*const*/ {
    return Stored.isMoreQualifiedThan(Other.Stored);
  }

  
  /// \brief Determines whether this canonical type is at least as qualified as
  /// the @p Other canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::isAtLeastAsQualifiedAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 159,
   FQN="clang::CanQual::isAtLeastAsQualifiedAs", NM="_ZNK5clang7CanQual22isAtLeastAsQualifiedAsENS_7CanQualIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual22isAtLeastAsQualifiedAsENS_7CanQualIT_EE")
  //</editor-fold>
  public boolean isAtLeastAsQualifiedAs(CanQual<T> Other) /*const*/ {
    return Stored.isAtLeastAsQualifiedAs(Other.Stored);
  }

  
  /// \brief If the canonical type is a reference type, returns the type that
  /// it refers to; otherwise, returns the type itself.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getNonReferenceType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 603,
   FQN="clang::CanQual::getNonReferenceType", NM="_ZNK5clang7CanQual19getNonReferenceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual19getNonReferenceTypeEv")
  //</editor-fold>
  public /*inline*/ CanQual<Type> getNonReferenceType() /*const*/ {
    {
      CanQual<ReferenceType> RefType = getAs(ReferenceType.class).$CanQual$T();
      if (RefType.$bool()) {
        return ((CanProxyReferenceType)RefType.$arrow(ReferenceType.class)).$arrow().getPointeeType();
      } else {
        return (CanQual<Type>)new CanQual(this);
      }
    }
  }

  
  /// \brief Retrieve the internal representation of this canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 168,
   FQN="clang::CanQual::getAsOpaquePtr", NM="_ZNK5clang7CanQual14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    return Stored.getAsOpaquePtr();
  }

  
  /// \brief Construct a canonical type from its internal representation.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::getFromOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 611,
   FQN="clang::CanQual::getFromOpaquePtr", NM="_ZN5clang7CanQual16getFromOpaquePtrEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CanQual16getFromOpaquePtrEPv")
  //</editor-fold>
  public static </*typename*/ T extends Type/* = Type*/> CanQual<T> getFromOpaquePtr(Object/*void P*/ Ptr) {
    CanQual<T> Result = new CanQual();
    Result.Stored.$assign(QualType.getFromOpaquePtr(Ptr));
    assert (!Result.$bool() || 
            Native.$eq(Result.Stored.getAsOpaquePtr(), (Object/*void P*/ )QualType.DUMMY_QUAL_TYPE_OPAQUE_VALUE) || 
            Result.Stored.isCanonical()) : "Type is not canonical!" + Result.Stored;
    return Result;
  }

  
  /// \brief Builds a canonical type from a QualType.
  ///
  /// This routine is inherently unsafe, because it requires the user to
  /// ensure that the given type is a canonical type with the correct
  // (dynamic) type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::CreateUnsafe">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 620,
   FQN="clang::CanQual::CreateUnsafe", NM="_ZN5clang7CanQual12CreateUnsafeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CanQual12CreateUnsafeENS_8QualTypeE")
  //</editor-fold>
  public static /*<typename T  = Type>*/ CanQual<Type> CreateUnsafe(QualType Other) {
    assert ((Other.isNull() || Other.isCanonical())) : "Type is not canonical!";
    assert Native.$bool((Other.isNull() || isa_Type(Other.getTypePtr()))) : "Dynamic type does not meet the static type's requires";
    CanQual<Type> Result = new CanQual();
    Result.Stored.$assign(Other);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 180,
   FQN="clang::CanQual::dump", NM="_ZNK5clang7CanQual4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    Stored.dump();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanQual::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 182,
   FQN="clang::CanQual::Profile", NM="_ZNK5clang7CanQual7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang7CanQual7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(getAsOpaquePtr());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override int $hashcode() { 
    return this.Stored.$hashcode();  
  }
  
  public CanQual<T> $assign(CanQual<?> $Prm0) {
    this.Stored.$assign($Prm0.Stored);
    return this;
  }
  
  public CanQual<T> $assignMove(CanQual<?> $Prm0) {
    assert this != $Prm0;
    this.Stored = $Prm0.Stored;
    $Prm0.Stored = null;
    return this;
  }

  public CanQual(final /*const*/ CanQual<T> /*&*/ Other) {
    this.Stored = new QualType(Other.Stored);
  }
  
  public CanQual(JD$Move _dparam, final /*const*/ CanQual<T> /*&*/ Other) {
    assert this != Other;
    this.Stored = Other.Stored;
    Other.Stored = null;
  }

  @Override public CanQual<T> clone() {
    return new CanQual(this);
  }

  @Override
  public boolean $eq(CanQual<?> other) {
    return $eq_CanQual(this, other);
  }
  
  public static boolean $eq_CanQual(CanQual<?> LHS, CanQual<?> RHS) {
    return QualType.$eq_QualType$C(LHS.Stored, RHS.Stored);
  }

  public static boolean $noteq_CanQual(CanQual<?> LHS, CanQual<?> RHS) {
    return QualType.$noteq_QualType$C(LHS.Stored, RHS.Stored);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::simplify_type<CanQual<type-parameter-0-0> >::getSimplifiedValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 355,
   FQN="llvm::simplify_type<CanQual<type-parameter-0-0> >::getSimplifiedValue", NM="_ZN4llvm13simplify_typeIN5clang7CanQualIT_EEE18getSimplifiedValueES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN4llvm13simplify_typeIN5clang7CanQualIT_EEE18getSimplifiedValueES4_")
  //</editor-fold>  
  @Override public Object getSimplifiedValue(Object $This) {
    // copied from llvm::simplify_type<CanQual>
    assert $This == this : "must be called on itself " + this + " vs. " + $This;
    return this.getTypePtr();
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Stored=" + Stored; // NOI18N
  }
}
