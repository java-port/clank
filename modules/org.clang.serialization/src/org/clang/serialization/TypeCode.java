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

package org.clang.serialization;

import org.clank.support.*;


/// \brief Record codes for each kind of type.
///
/// These constants describe the type records that can occur within a
/// block identified by DECLTYPES_BLOCK_ID in the AST file. Each
/// constant describes a record for a specific type class in the
/// AST. Note that DeclCode values share this code space.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeCode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 818,
 FQN="clang::serialization::TypeCode", NM="_ZN5clang13serialization8TypeCodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization8TypeCodeE")
//</editor-fold>
public final class/*enum*/ TypeCode {
  /// \brief An ExtQualType record.
  public static final int TYPE_EXT_QUAL = 1;
  /// \brief A ComplexType record.
  public static final int TYPE_COMPLEX = 3;
  /// \brief A PointerType record.
  public static final int TYPE_POINTER = 4;
  /// \brief A BlockPointerType record.
  public static final int TYPE_BLOCK_POINTER = 5;
  /// \brief An LValueReferenceType record.
  public static final int TYPE_LVALUE_REFERENCE = 6;
  /// \brief An RValueReferenceType record.
  public static final int TYPE_RVALUE_REFERENCE = 7;
  /// \brief A MemberPointerType record.
  public static final int TYPE_MEMBER_POINTER = 8;
  /// \brief A ConstantArrayType record.
  public static final int TYPE_CONSTANT_ARRAY = 9;
  /// \brief An IncompleteArrayType record.
  public static final int TYPE_INCOMPLETE_ARRAY = 10;
  /// \brief A VariableArrayType record.
  public static final int TYPE_VARIABLE_ARRAY = 11;
  /// \brief A VectorType record.
  public static final int TYPE_VECTOR = 12;
  /// \brief An ExtVectorType record.
  public static final int TYPE_EXT_VECTOR = 13;
  /// \brief A FunctionNoProtoType record.
  public static final int TYPE_FUNCTION_NO_PROTO = 14;
  /// \brief A FunctionProtoType record.
  public static final int TYPE_FUNCTION_PROTO = 15;
  /// \brief A TypedefType record.
  public static final int TYPE_TYPEDEF = 16;
  /// \brief A TypeOfExprType record.
  public static final int TYPE_TYPEOF_EXPR = 17;
  /// \brief A TypeOfType record.
  public static final int TYPE_TYPEOF = 18;
  /// \brief A RecordType record.
  public static final int TYPE_RECORD = 19;
  /// \brief An EnumType record.
  public static final int TYPE_ENUM = 20;
  /// \brief An ObjCInterfaceType record.
  public static final int TYPE_OBJC_INTERFACE = 21;
  /// \brief An ObjCObjectPointerType record.
  public static final int TYPE_OBJC_OBJECT_POINTER = 22;
  /// \brief a DecltypeType record.
  public static final int TYPE_DECLTYPE = 23;
  /// \brief An ElaboratedType record.
  public static final int TYPE_ELABORATED = 24;
  /// \brief A SubstTemplateTypeParmType record.
  public static final int TYPE_SUBST_TEMPLATE_TYPE_PARM = 25;
  /// \brief An UnresolvedUsingType record.
  public static final int TYPE_UNRESOLVED_USING = 26;
  /// \brief An InjectedClassNameType record.
  public static final int TYPE_INJECTED_CLASS_NAME = 27;
  /// \brief An ObjCObjectType record.
  public static final int TYPE_OBJC_OBJECT = 28;
  /// \brief An TemplateTypeParmType record.
  public static final int TYPE_TEMPLATE_TYPE_PARM = 29;
  /// \brief An TemplateSpecializationType record.
  public static final int TYPE_TEMPLATE_SPECIALIZATION = 30;
  /// \brief A DependentNameType record.
  public static final int TYPE_DEPENDENT_NAME = 31;
  /// \brief A DependentTemplateSpecializationType record.
  public static final int TYPE_DEPENDENT_TEMPLATE_SPECIALIZATION = 32;
  /// \brief A DependentSizedArrayType record.
  public static final int TYPE_DEPENDENT_SIZED_ARRAY = 33;
  /// \brief A ParenType record.
  public static final int TYPE_PAREN = 34;
  /// \brief A PackExpansionType record.
  public static final int TYPE_PACK_EXPANSION = 35;
  /// \brief An AttributedType record.
  public static final int TYPE_ATTRIBUTED = 36;
  /// \brief A SubstTemplateTypeParmPackType record.
  public static final int TYPE_SUBST_TEMPLATE_TYPE_PARM_PACK = 37;
  /// \brief A AutoType record.
  public static final int TYPE_AUTO = 38;
  /// \brief A UnaryTransformType record.
  public static final int TYPE_UNARY_TRANSFORM = 39;
  /// \brief An AtomicType record.
  public static final int TYPE_ATOMIC = 40;
  /// \brief A DecayedType record.
  public static final int TYPE_DECAYED = 41;
  /// \brief An AdjustedType record.
  public static final int TYPE_ADJUSTED = 42;
  /// \brief A PipeType record.
  public static final int TYPE_PIPE = 43;
}
