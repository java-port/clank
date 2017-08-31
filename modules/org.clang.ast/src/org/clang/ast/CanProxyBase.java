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


/// \brief Base class of all canonical proxy types, which is responsible for
/// storing the underlying canonical type and providing basic conversions.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 224,
 FQN="clang::CanProxyBase", NM="_ZN5clang12CanProxyBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang12CanProxyBaseE")
//</editor-fold>
public class CanProxyBase</*typename*/ T extends Type>  {
  /*protected:*/
  protected CanQual<T> Stored;
/*public:*/
  /// \brief Retrieve the pointer to the underlying Type
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::getTypePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 231,
   FQN="clang::CanProxyBase::getTypePtr", NM="_ZNK5clang12CanProxyBase10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase10getTypePtrEv")
  //</editor-fold>
  public /*const*/ T /*P*/ getTypePtr() /*const*/ {
    return Stored.getTypePtr();
  }

  
  /// \brief Implicit conversion to the underlying pointer.
  ///
  /// Also provides the ability to use canonical type proxies in a Boolean
  // context,e.g.,
  /// @code
  ///   if (CanQual<PointerType> Ptr = T->getAs<PointerType>()) { ... }
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::operator const type-parameter-0-0 * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 240,
   FQN="clang::CanProxyBase::operator const type-parameter-0-0 * ", NM="_ZNK5clang12CanProxyBasecvPKT_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBasecvPKT_Ev")
  //</editor-fold>
  public /*const*/ T /*P*/ $T$C$P() /*const*/ {
    return this.Stored.getTypePtrOrNull();
  }

  
  /// \brief Try to convert the given canonical type to a specific structural
  /// type.
  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 244,
   FQN="clang::CanProxyBase::getAs", NM="Tpl__ZNK5clang12CanProxyBase5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=Tpl__ZNK5clang12CanProxyBase5getAsEv")
  //</editor-fold>
  public </*typename*/ U extends Type> CanProxy<U> getAs(Class<U> clazz) /*const*/ {
    return this.Stored./*template */<U>getAs(clazz);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::getTypeClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 248,
   FQN="clang::CanProxyBase::getTypeClass", NM="_ZNK5clang12CanProxyBase12getTypeClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase12getTypeClassEv")
  //</editor-fold>
  public Type.TypeClass getTypeClass() /*const*/ {
    return this.getTypePtr().getTypeClass();
  }

  
  // Type predicates
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 251,
   FQN="clang::CanProxyBase::isObjectType", NM="_ZNK5clang12CanProxyBase12isObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase12isObjectTypeEv")
  //</editor-fold>
  public boolean isObjectType() /*const*/ {
    return this.getTypePtr().isObjectType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isIncompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 252,
   FQN="clang::CanProxyBase::isIncompleteType", NM="_ZNK5clang12CanProxyBase16isIncompleteTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase16isIncompleteTypeEv")
  //</editor-fold>
  public boolean isIncompleteType() /*const*/ {
    return this.getTypePtr().isIncompleteType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isIncompleteOrObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 253,
   FQN="clang::CanProxyBase::isIncompleteOrObjectType", NM="_ZNK5clang12CanProxyBase24isIncompleteOrObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase24isIncompleteOrObjectTypeEv")
  //</editor-fold>
  public boolean isIncompleteOrObjectType() /*const*/ {
    return this.getTypePtr().isIncompleteOrObjectType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isVariablyModifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 254,
   FQN="clang::CanProxyBase::isVariablyModifiedType", NM="_ZNK5clang12CanProxyBase22isVariablyModifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase22isVariablyModifiedTypeEv")
  //</editor-fold>
  public boolean isVariablyModifiedType() /*const*/ {
    return this.getTypePtr().isVariablyModifiedType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 255,
   FQN="clang::CanProxyBase::isIntegerType", NM="_ZNK5clang12CanProxyBase13isIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase13isIntegerTypeEv")
  //</editor-fold>
  public boolean isIntegerType() /*const*/ {
    return this.getTypePtr().isIntegerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isEnumeralType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 256,
   FQN="clang::CanProxyBase::isEnumeralType", NM="_ZNK5clang12CanProxyBase14isEnumeralTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase14isEnumeralTypeEv")
  //</editor-fold>
  public boolean isEnumeralType() /*const*/ {
    return this.getTypePtr().isEnumeralType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isBooleanType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 257,
   FQN="clang::CanProxyBase::isBooleanType", NM="_ZNK5clang12CanProxyBase13isBooleanTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase13isBooleanTypeEv")
  //</editor-fold>
  public boolean isBooleanType() /*const*/ {
    return this.getTypePtr().isBooleanType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 258,
   FQN="clang::CanProxyBase::isCharType", NM="_ZNK5clang12CanProxyBase10isCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase10isCharTypeEv")
  //</editor-fold>
  public boolean isCharType() /*const*/ {
    return this.getTypePtr().isCharType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isWideCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 259,
   FQN="clang::CanProxyBase::isWideCharType", NM="_ZNK5clang12CanProxyBase14isWideCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase14isWideCharTypeEv")
  //</editor-fold>
  public boolean isWideCharType() /*const*/ {
    return this.getTypePtr().isWideCharType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isIntegralType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 260,
   FQN="clang::CanProxyBase::isIntegralType", NM="_ZNK5clang12CanProxyBase14isIntegralTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase14isIntegralTypeEv")
  //</editor-fold>
  public boolean isIntegralType() /*const*/ {
    throw new UnsupportedOperationException("method does not called in C++");
    //return this.getTypePtr().isIntegralType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isIntegralOrEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 261,
   FQN="clang::CanProxyBase::isIntegralOrEnumerationType", NM="_ZNK5clang12CanProxyBase27isIntegralOrEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase27isIntegralOrEnumerationTypeEv")
  //</editor-fold>
  public boolean isIntegralOrEnumerationType() /*const*/ {
    return this.getTypePtr().isIntegralOrEnumerationType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isRealFloatingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 262,
   FQN="clang::CanProxyBase::isRealFloatingType", NM="_ZNK5clang12CanProxyBase18isRealFloatingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase18isRealFloatingTypeEv")
  //</editor-fold>
  public boolean isRealFloatingType() /*const*/ {
    return this.getTypePtr().isRealFloatingType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 263,
   FQN="clang::CanProxyBase::isComplexType", NM="_ZNK5clang12CanProxyBase13isComplexTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase13isComplexTypeEv")
  //</editor-fold>
  public boolean isComplexType() /*const*/ {
    return this.getTypePtr().isComplexType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isAnyComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 264,
   FQN="clang::CanProxyBase::isAnyComplexType", NM="_ZNK5clang12CanProxyBase16isAnyComplexTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase16isAnyComplexTypeEv")
  //</editor-fold>
  public boolean isAnyComplexType() /*const*/ {
    return this.getTypePtr().isAnyComplexType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isFloatingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 265,
   FQN="clang::CanProxyBase::isFloatingType", NM="_ZNK5clang12CanProxyBase14isFloatingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase14isFloatingTypeEv")
  //</editor-fold>
  public boolean isFloatingType() /*const*/ {
    return this.getTypePtr().isFloatingType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isRealType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 266,
   FQN="clang::CanProxyBase::isRealType", NM="_ZNK5clang12CanProxyBase10isRealTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase10isRealTypeEv")
  //</editor-fold>
  public boolean isRealType() /*const*/ {
    return this.getTypePtr().isRealType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isArithmeticType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 267,
   FQN="clang::CanProxyBase::isArithmeticType", NM="_ZNK5clang12CanProxyBase16isArithmeticTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase16isArithmeticTypeEv")
  //</editor-fold>
  public boolean isArithmeticType() /*const*/ {
    return this.getTypePtr().isArithmeticType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isVoidType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 268,
   FQN="clang::CanProxyBase::isVoidType", NM="_ZNK5clang12CanProxyBase10isVoidTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase10isVoidTypeEv")
  //</editor-fold>
  public boolean isVoidType() /*const*/ {
    return this.getTypePtr().isVoidType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isDerivedType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 269,
   FQN="clang::CanProxyBase::isDerivedType", NM="_ZNK5clang12CanProxyBase13isDerivedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase13isDerivedTypeEv")
  //</editor-fold>
  public boolean isDerivedType() /*const*/ {
    throw new UnsupportedOperationException("method does not called in C++");
    //return this.getTypePtr().isDerivedType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isScalarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 270,
   FQN="clang::CanProxyBase::isScalarType", NM="_ZNK5clang12CanProxyBase12isScalarTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase12isScalarTypeEv")
  //</editor-fold>
  public boolean isScalarType() /*const*/ {
    return this.getTypePtr().isScalarType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isAggregateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 271,
   FQN="clang::CanProxyBase::isAggregateType", NM="_ZNK5clang12CanProxyBase15isAggregateTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase15isAggregateTypeEv")
  //</editor-fold>
  public boolean isAggregateType() /*const*/ {
    return this.getTypePtr().isAggregateType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isAnyPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 272,
   FQN="clang::CanProxyBase::isAnyPointerType", NM="_ZNK5clang12CanProxyBase16isAnyPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase16isAnyPointerTypeEv")
  //</editor-fold>
  public boolean isAnyPointerType() /*const*/ {
    return this.getTypePtr().isAnyPointerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isVoidPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 273,
   FQN="clang::CanProxyBase::isVoidPointerType", NM="_ZNK5clang12CanProxyBase17isVoidPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase17isVoidPointerTypeEv")
  //</editor-fold>
  public boolean isVoidPointerType() /*const*/ {
    return this.getTypePtr().isVoidPointerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isFunctionPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 274,
   FQN="clang::CanProxyBase::isFunctionPointerType", NM="_ZNK5clang12CanProxyBase21isFunctionPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase21isFunctionPointerTypeEv")
  //</editor-fold>
  public boolean isFunctionPointerType() /*const*/ {
    return this.getTypePtr().isFunctionPointerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isMemberFunctionPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 275,
   FQN="clang::CanProxyBase::isMemberFunctionPointerType", NM="_ZNK5clang12CanProxyBase27isMemberFunctionPointerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase27isMemberFunctionPointerTypeEv")
  //</editor-fold>
  public boolean isMemberFunctionPointerType() /*const*/ {
    return this.getTypePtr().isMemberFunctionPointerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 276,
   FQN="clang::CanProxyBase::isClassType", NM="_ZNK5clang12CanProxyBase11isClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase11isClassTypeEv")
  //</editor-fold>
  public boolean isClassType() /*const*/ {
    return this.getTypePtr().isClassType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isStructureType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 277,
   FQN="clang::CanProxyBase::isStructureType", NM="_ZNK5clang12CanProxyBase15isStructureTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase15isStructureTypeEv")
  //</editor-fold>
  public boolean isStructureType() /*const*/ {
    return this.getTypePtr().isStructureType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 278,
   FQN="clang::CanProxyBase::isInterfaceType", NM="_ZNK5clang12CanProxyBase15isInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase15isInterfaceTypeEv")
  //</editor-fold>
  public boolean isInterfaceType() /*const*/ {
    return this.getTypePtr().isInterfaceType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isStructureOrClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 279,
   FQN="clang::CanProxyBase::isStructureOrClassType", NM="_ZNK5clang12CanProxyBase22isStructureOrClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase22isStructureOrClassTypeEv")
  //</editor-fold>
  public boolean isStructureOrClassType() /*const*/ {
    return this.getTypePtr().isStructureOrClassType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isUnionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 280,
   FQN="clang::CanProxyBase::isUnionType", NM="_ZNK5clang12CanProxyBase11isUnionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase11isUnionTypeEv")
  //</editor-fold>
  public boolean isUnionType() /*const*/ {
    return this.getTypePtr().isUnionType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isComplexIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 281,
   FQN="clang::CanProxyBase::isComplexIntegerType", NM="_ZNK5clang12CanProxyBase20isComplexIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase20isComplexIntegerTypeEv")
  //</editor-fold>
  public boolean isComplexIntegerType() /*const*/ {
    return this.getTypePtr().isComplexIntegerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isNullPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 282,
   FQN="clang::CanProxyBase::isNullPtrType", NM="_ZNK5clang12CanProxyBase13isNullPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase13isNullPtrTypeEv")
  //</editor-fold>
  public boolean isNullPtrType() /*const*/ {
    return this.getTypePtr().isNullPtrType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isDependentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 283,
   FQN="clang::CanProxyBase::isDependentType", NM="_ZNK5clang12CanProxyBase15isDependentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase15isDependentTypeEv")
  //</editor-fold>
  public boolean isDependentType() /*const*/ {
    return this.getTypePtr().isDependentType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isOverloadableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 284,
   FQN="clang::CanProxyBase::isOverloadableType", NM="_ZNK5clang12CanProxyBase18isOverloadableTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase18isOverloadableTypeEv")
  //</editor-fold>
  public boolean isOverloadableType() /*const*/ {
    return this.getTypePtr().isOverloadableType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 285,
   FQN="clang::CanProxyBase::isArrayType", NM="_ZNK5clang12CanProxyBase11isArrayTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase11isArrayTypeEv")
  //</editor-fold>
  public boolean isArrayType() /*const*/ {
    return this.getTypePtr().isArrayType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::hasPointerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 286,
   FQN="clang::CanProxyBase::hasPointerRepresentation", NM="_ZNK5clang12CanProxyBase24hasPointerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase24hasPointerRepresentationEv")
  //</editor-fold>
  public boolean hasPointerRepresentation() /*const*/ {
    return this.getTypePtr().hasPointerRepresentation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::hasObjCPointerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 287,
   FQN="clang::CanProxyBase::hasObjCPointerRepresentation", NM="_ZNK5clang12CanProxyBase28hasObjCPointerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase28hasObjCPointerRepresentationEv")
  //</editor-fold>
  public boolean hasObjCPointerRepresentation() /*const*/ {
    return this.getTypePtr().hasObjCPointerRepresentation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::hasIntegerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 288,
   FQN="clang::CanProxyBase::hasIntegerRepresentation", NM="_ZNK5clang12CanProxyBase24hasIntegerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase24hasIntegerRepresentationEv")
  //</editor-fold>
  public boolean hasIntegerRepresentation() /*const*/ {
    return this.getTypePtr().hasIntegerRepresentation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::hasSignedIntegerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 289,
   FQN="clang::CanProxyBase::hasSignedIntegerRepresentation", NM="_ZNK5clang12CanProxyBase30hasSignedIntegerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase30hasSignedIntegerRepresentationEv")
  //</editor-fold>
  public boolean hasSignedIntegerRepresentation() /*const*/ {
    return this.getTypePtr().hasSignedIntegerRepresentation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::hasUnsignedIntegerRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 290,
   FQN="clang::CanProxyBase::hasUnsignedIntegerRepresentation", NM="_ZNK5clang12CanProxyBase32hasUnsignedIntegerRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase32hasUnsignedIntegerRepresentationEv")
  //</editor-fold>
  public boolean hasUnsignedIntegerRepresentation() /*const*/ {
    return this.getTypePtr().hasUnsignedIntegerRepresentation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::hasFloatingRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 291,
   FQN="clang::CanProxyBase::hasFloatingRepresentation", NM="_ZNK5clang12CanProxyBase25hasFloatingRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase25hasFloatingRepresentationEv")
  //</editor-fold>
  public boolean hasFloatingRepresentation() /*const*/ {
    return this.getTypePtr().hasFloatingRepresentation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isPromotableIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 292,
   FQN="clang::CanProxyBase::isPromotableIntegerType", NM="_ZNK5clang12CanProxyBase23isPromotableIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase23isPromotableIntegerTypeEv")
  //</editor-fold>
  public boolean isPromotableIntegerType() /*const*/ {
    return this.getTypePtr().isPromotableIntegerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isSignedIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 293,
   FQN="clang::CanProxyBase::isSignedIntegerType", NM="_ZNK5clang12CanProxyBase19isSignedIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase19isSignedIntegerTypeEv")
  //</editor-fold>
  public boolean isSignedIntegerType() /*const*/ {
    return this.getTypePtr().isSignedIntegerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isUnsignedIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 294,
   FQN="clang::CanProxyBase::isUnsignedIntegerType", NM="_ZNK5clang12CanProxyBase21isUnsignedIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase21isUnsignedIntegerTypeEv")
  //</editor-fold>
  public boolean isUnsignedIntegerType() /*const*/ {
    return this.getTypePtr().isUnsignedIntegerType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isSignedIntegerOrEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 295,
   FQN="clang::CanProxyBase::isSignedIntegerOrEnumerationType", NM="_ZNK5clang12CanProxyBase32isSignedIntegerOrEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase32isSignedIntegerOrEnumerationTypeEv")
  //</editor-fold>
  public boolean isSignedIntegerOrEnumerationType() /*const*/ {
    return this.getTypePtr().isSignedIntegerOrEnumerationType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isUnsignedIntegerOrEnumerationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 296,
   FQN="clang::CanProxyBase::isUnsignedIntegerOrEnumerationType", NM="_ZNK5clang12CanProxyBase34isUnsignedIntegerOrEnumerationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase34isUnsignedIntegerOrEnumerationTypeEv")
  //</editor-fold>
  public boolean isUnsignedIntegerOrEnumerationType() /*const*/ {
    return this.getTypePtr().isUnsignedIntegerOrEnumerationType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isConstantSizeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 297,
   FQN="clang::CanProxyBase::isConstantSizeType", NM="_ZNK5clang12CanProxyBase18isConstantSizeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase18isConstantSizeTypeEv")
  //</editor-fold>
  public boolean isConstantSizeType() /*const*/ {
    return this.getTypePtr().isConstantSizeType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::isSpecifierType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 298,
   FQN="clang::CanProxyBase::isSpecifierType", NM="_ZNK5clang12CanProxyBase15isSpecifierTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase15isSpecifierTypeEv")
  //</editor-fold>
  public boolean isSpecifierType() /*const*/ {
    return this.getTypePtr().isSpecifierType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::getAsCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 299,
   FQN="clang::CanProxyBase::getAsCXXRecordDecl", NM="_ZNK5clang12CanProxyBase18getAsCXXRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBase18getAsCXXRecordDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getAsCXXRecordDecl() /*const*/ {
    return this.getTypePtr().getAsCXXRecordDecl();
  }

  
  /// \brief Retrieve the proxy-adaptor type.
  ///
  /// This arrow operator is used when CanProxyAdaptor has been specialized
  /// for the given type T. In that case, we reference members of the
  /// CanProxyAdaptor specialization. Otherwise, this operator will be hidden
  /// by the arrow operator in the primary CanProxyAdaptor template.
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyBase::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 307,
   FQN="clang::CanProxyBase::operator->", NM="_ZNK5clang12CanProxyBaseptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang12CanProxyBaseptEv")
  //</editor-fold>
  public /*const*/ CanProxyAdaptor<T> /*P*/ $arrow() /*const*/ {
    return ((/*static_cast*//*const*/ CanProxyAdaptor<T> /*P*/ )(this));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CanProxyBase() {this.Stored = new CanQual();}
  
  public CanProxyBase(JD$Move _dparam, CanProxyBase<T> /*&&*/$Prm0) {this.Stored = $Prm0.Stored; $Prm0.Stored = null;}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Stored=" + Stored; // NOI18N
  }
}
